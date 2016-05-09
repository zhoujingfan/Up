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
 * VideoEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="video"
    ,catalog="up"
)

public class VideoEntity  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private UserEntity userEntity;
     private WeiboEntity weiboEntity;
     private String videoPath;
     private String title;


    // Constructors

    /** default constructor */
    public VideoEntity() {
    }

    
    /** full constructor */
    public VideoEntity(Integer id, UserEntity userEntity, WeiboEntity weiboEntity, String videoPath, String title) {
        this.id = id;
        this.userEntity = userEntity;
        this.weiboEntity = weiboEntity;
        this.videoPath = videoPath;
        this.title = title;
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
    
    @Column(name="video_path", nullable=false)

    public String getVideoPath() {
        return this.videoPath;
    }
    
    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
    
    @Column(name="title", nullable=false, length=50)

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
   








}