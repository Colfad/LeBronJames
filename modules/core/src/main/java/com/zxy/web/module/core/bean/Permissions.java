package com.zxy.web.module.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 权限Bean
 *
 * @author James
 */
public class Permissions implements Serializable {
    public static final String USER_READ   = "web:user:readPermission";
    public static final String USER_WRITE  = "web:user:writePermission";
    public static final String USER_DELETE = "web:user:deletePermission";
    public static final String USER_UPDATE = "web:user:updatePermission";
    public static final String USER_FRAZE  = "web:user:frazePermission";

/*
    public static final String ROLE_READ = "zxyweb:role:readPermission";
    public static final String ROLE_WRITE = "zxyweb:role:writePermission";
    public static final String ROLE_DELETE = "zxyweb:role:deletePermission";
    public static final String ROLE_UPDATE = "zxyweb:role:updatePermission";
*/


    public static final Byte NONE_PERMISSION_VALUE   = 0;
    public static final Byte READ_PERMISSION_VALUE   = 1;
    public static final Byte WRITE_PERMISSION_VALUE  = 2;
    public static final Byte UPDATE_PERMISSION_VALUE = 4;
    public static final Byte DELETE_PERMISSION_VALUE = 8;
    public static final Byte FRAZE_PERMISSION_VALUE  = 16;

    /**
     * 有如下几种组合
     * read                       : 1
     * read write                 : 3
     * read update                : 5
     * read write update          : 7
     * read delete                : 9
     * read write delete          : 11
     * read update delete         : 13
     * read write update delete   : 15
     *
     * @param permissionValue
     * @return
     */
    public static List<String> getPermissionList(Byte permissionValue) {
        List<String> permissions = new ArrayList<String>();

        return null;
    }


}
