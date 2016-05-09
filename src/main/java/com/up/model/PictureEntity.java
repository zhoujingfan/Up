package com.up.model;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * PictureEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="picture"
    ,catalog="up"
)

public class PictureEntity  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private UserEntity userEntity;
     private WeiboEntity weiboEntity;
     private String picturePath;


    // Constructors

    /** default constructor */
    public PictureEntity() {
    }

    
    /** full constructor */
    public PictureEntity(Integer id, UserEntity userEntity, WeiboEntity weiboEntity, String picturePath) {
        this.id = id;
        this.userEntity = userEntity;
        this.weiboEntity = weiboEntity;
        this.picturePath = picturePath;
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
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="user_id", nullable=false)

    public UserEntity getUserEntity() {
        return this.userEntity;
    }
    
    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="weibo_id", nullable=false)

    public WeiboEntity getWeiboEntity() {
        return this.weiboEntity;
    }
    
    public void setWeiboEntity(WeiboEntity weiboEntity) {
        this.weiboEntity = weiboEntity;
    }
    
    @Column(name="picture_path", nullable=false)

    public String getPicturePath() {
        return this.picturePath;
    }
    
    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
   








}