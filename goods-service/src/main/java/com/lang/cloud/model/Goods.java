package com.lang.cloud.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "user_goods")
public class Goods implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    @Column(name = "g_ownid")
    private Integer gOwnid;
    @Column(name = "g_name")
    private String gNmae;
    @Column(name = "g_class")
    private String gClass;
    @Column(name = "g_count")
    private Integer gCount;
}
