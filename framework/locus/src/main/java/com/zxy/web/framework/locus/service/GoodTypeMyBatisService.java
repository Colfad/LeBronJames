package com.zxy.web.framework.locus.service;

import com.zxy.web.framework.locus.model.GoodType;
import com.zxy.web.framework.locus.repository.mybatis.GoodTypeMyBatisDao;
import com.zxy.web.module.core.bean.Tree;
import com.zxy.web.module.core.bean.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品类型管理的Service类
 *
 * @author James
 */
@Component
@Transactional(readOnly = true)
public class GoodTypeMyBatisService {
    private GoodTypeMyBatisDao goodTypeMyBatisDao;

    public List<GoodType> findAll() {
        return goodTypeMyBatisDao.findAll();
    }

    // 就是为一个树当点击之后加载其第二层内容
    public List<GoodType> findChildById(String parentId) {
        return goodTypeMyBatisDao.findChildById(parentId);
    }

    public GoodTypeMyBatisDao getGoodTypeMyBatisDao() {
        return goodTypeMyBatisDao;
    }

    /**
     * 通过这样的方法来获得相应的
     *
     * @param id
     * @return
     */
    public Tree getGoodTypeTree(String id) {
        Tree tree = new Tree();
        List<GoodType> list = goodTypeMyBatisDao.findChildById(id);
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        for (GoodType type : list) {
            TreeNode node = new TreeNode();
            node.setContent(type.getTypeName());
            node.setId(type.getId());
            node.setLeaf(type.getLeaf());
            node.setNodeName(type.getTypeName());
            node.setExpanded(false);
            List<TreeNode> nodeList = new ArrayList<TreeNode>();
            for (GoodType typeChild : type.getTypeList()) {
                TreeNode childNode = new TreeNode();
                childNode.setNodeName(typeChild.getTypeName());
                childNode.setContent(typeChild.getTypeName());
                childNode.setId(typeChild.getId());
                childNode.setParent(node);
                childNode.setLeaf(typeChild.getLeaf());
                childNode.setExpanded(false);
                nodeList.add(childNode);
            }
            node.setChildTreeNodeList(nodeList);
            treeNodes.add(node);
        }

        tree.setNodes(treeNodes);
        return tree;
    }

    @Autowired
    public void setGoodTypeMyBatisDao(GoodTypeMyBatisDao goodTypeMyBatisDao) {
        this.goodTypeMyBatisDao = goodTypeMyBatisDao;
    }
}
