package com.zxy.web.module.core.service;

import com.zxy.web.module.core.model.User;
import com.zxy.web.module.core.orm.FixEntityUtil;
import com.zxy.web.module.core.orm.util.DynamicSpecifications;
import com.zxy.web.module.core.orm.util.SearchFilter;
import com.zxy.web.module.core.repository.jpa.UserDao;
import com.zxy.web.module.core.security.utils.Digests;
import com.zxy.web.module.core.utils.Encodes;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 用户账户管理类
 *
 * @author James
 */
@Component
@Transactional
public class AccountService {

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    private static final int SALT_SIZE = 8;

    private static Logger logger = LoggerFactory.getLogger(AccountService.class);

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    /**
     * 根据登录名查找相关的用户
     *
     * @param userName
     * @return
     */
    public User findByLoginName(String userName) {
        return userDao.findByUserName(userName);

    }

    /**
     * 保存一个用户对象
     *
     * @param user
     */
    public void saveUser(User user) {
        if (isSupervisor(user)) {
            logger.warn("can't update super user !!!");
            throw new ServiceException("can't modify super user!!!");
        }

        // 这里是有两种情况的判断，如果用户是新增的话肯定会有plainpassword这个选项
        // 故这里把用户的密码进行加密的处理
        if (StringUtils.isNotBlank(user.getPlainPassword())) {
            entryptPassword(user);
        }

        // 对这里的用户进行修复，主要就是修复UUID的问题
        FixEntityUtil.fixEntity(user);

        // 会自动根据用户是否持久化，选择更新或者是新增的操作
        userDao.save(user);

    }

    private boolean isSupervisor(User user) {
        if (user.getEmail().equals("zhouxy.vortex@gmail.com")) {
            return true;
        }
        return false;
    }

    /**
     * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
     */
    private void entryptPassword(User user) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        user.setSalt(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
        user.setPassword(Encodes.encodeHex(hashPassword));
    }

    /**
     * 返回现在网站总共注册了多少用户数
     *
     * @return
     */
    public Long getUserCount() {
        return userDao.count();
    }

    /**
     * 根据userName查找到一个User对象
     *
     * @param userName 用户姓名
     * @return  用户密码
     */
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    public Page<User> getUserByPage(Map<String, Object> searchParams, int pageNumber, int pageSize,
                                    String sortType) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<User> spec = buildSpecification(searchParams);
        return userDao.findAll(spec, pageRequest);
    }

    private Specification<User> buildSpecification(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        Specification<User> spec = DynamicSpecifications.bySearchFilter(filters.values(), User.class);
        return spec;
    }

    private PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC, "id");
        } else if ("userName".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "userName");
        }

        return new PageRequest(pageNumber - 1, pageSize, sort);
    }

    public void deleteUser(String id) {
        userDao.delete(id);
    }

    public User getUserById(String id) {
        return userDao.findOne(id);
    }
}
