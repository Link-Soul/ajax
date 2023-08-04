package com.link.util;

import java.util.UUID;

public class GetUUID {
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String[] split = uuid.toString().split("-");
        String uid = "";
        for (String s : split) {
            uid+=s;
        }
        return uid.substring(0, 19);
    }
}
