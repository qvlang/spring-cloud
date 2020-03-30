package com.lang.cloud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Goods implements Serializable {
    private Integer gid;
    private Integer gOwnid;
    private String gNmae;
    private String gClass;
    private Integer gCount;
}
