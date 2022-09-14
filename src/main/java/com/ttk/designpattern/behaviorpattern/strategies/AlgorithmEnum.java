package com.ttk.designpattern.behaviorpattern.strategies;

public enum AlgorithmEnum {

    ADD("1", "add", "加法"),
    MULTIPLY("1", "multiply", "乘法"),
    SUBTRACT("1", "subtract", "减法"),
    ;

    private String code;

    public String type;

    public String desc;

    AlgorithmEnum (String code, String type, String desc) {
        this.code = code;
        this.type = type;
        this.desc = desc;
    }


}
