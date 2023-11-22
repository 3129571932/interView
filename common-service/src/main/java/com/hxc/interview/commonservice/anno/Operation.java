package com.hxc.interview.commonservice.anno;

public enum Operation {

    NotNull("NOTNULL"),
    PhoneReg("PHONEREG"),
    EmailReg("EMAILREG"),
    IdNoReg("IDNOREG");

    private String value;

    private Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
