package com.wifi.comm;

/**
 * @Author: lihl01
 * @Date: 2019/10/16 6:50 PM
 * @Describe:
 */

public enum EnumType {
    /**
     * 枚举测试
     */
    type1(1, "enum1"),
    type2(1, "enum2");

    private int type;
    private String name;

    EnumType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
