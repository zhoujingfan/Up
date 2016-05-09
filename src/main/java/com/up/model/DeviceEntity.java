package com.up.model;

// default package

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * DeviceEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="device"
    ,catalog="up"
)

public class DeviceEntity  implements java.io.Serializable {


    // Fields

     private Integer id;
     private String content;
     private String url;
     private Set<WeiboEntity> weiboEntities = new HashSet<WeiboEntity>(0);


    // Constructors

    /** default constructor */
    public DeviceEntity() {
    }

	/** minimal constructor */
    public DeviceEntity(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    /** full constructor */
    public DeviceEntity(Integer id, String content, String url, Set<WeiboEntity> weiboEntities) {
        this.id = id;
        this.content = content;
        this.url = url;
        this.weiboEntities = weiboEntities;
    }


    // Property accessors
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="content", nullable=false, length=40)

    public String getcontent() {
        return this.content;
    }

    public void setcontent(String content) {
        this.content = content;
    }

    @Column(name="url",columnDefinition="VARCHAR(255) DEFAULT NULL")

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="deviceEntity")

    public Set<WeiboEntity> getWeiboEntities() {
        return this.weiboEntities;
    }

    public void setWeiboEntities(Set<WeiboEntity> weiboEntities) {
        this.weiboEntities = weiboEntities;
    }









}
