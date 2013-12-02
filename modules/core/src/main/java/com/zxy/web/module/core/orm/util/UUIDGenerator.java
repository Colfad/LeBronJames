package com.zxy.web.module.core.orm.util;

import com.zxy.web.module.core.orm.model.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.UUID;

/**
 * 数据库UUID里的生成工具类
 *
 * @author James
 */
public class UUIDGenerator {

    private static Logger logger = LoggerFactory.getLogger(UUIDGenerator.class);

    // 经过测试
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();

        // 因为uuid生成的时候是32位的过于大了。感觉不太方便
        // 故这里的使用14位的UUID生成策略，但是会出现要重复的情况
        // 经过测试，当采用 s.substring(0, 8)的时候每100000次可能会出现一个重复的情况
        // 当使用14位之后情况就大为改观
        s = s.replaceAll("[-]", "");
        return s;
    }

/*    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=1; i<=100000; i++) {
            String uuid = UUIDGenerator.getUUID();
            Integer count = map.get(uuid);
            if (count == null) {
                map.put(uuid, 1);
            } else {
                map.put(uuid, ++count);
            }
        }
        Integer a = 0;
        Integer b = 0;
        for (Iterator<Map.Entry<String, Integer>> iterator=map.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<String, Integer> entry = iterator.next();
            Integer value = entry.getValue();
            b++;
            if (value > 1) {
                System.out.println("有重复");
                ++a;
            }
        }
        System.out.println(a + "    b:" + b);
        System.out.println(UUIDGenerator.getUUID());
    }*/

}
