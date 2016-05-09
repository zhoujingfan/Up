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
 * ArticleEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="article"
    ,catalog="up"
)

public class ArticleEntity  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private UserEntity userEntity;
     private WeiboEntity weiboEntity;
     private String articlePath;
     private String title;


    // Constructors

    /** default constructor */
    public ArticleEntity() {
    }

    
    /** full constructor */
    public ArticleEntity(Integer id, UserEntity userEntity, WeiboEntity weiboEntity, String articlePath, String title) {
        this.id = id;
        this.userEntity = userEntity;
        this.weiboEntity = weiboEntity;
        this.articlePath = articlePath;
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
    
    @Column(name="article_path", nullable=false)
    public String getArticlePath() {
        return this.articlePath;
    }
    
    public void setArticlePath(String articlePath) {
        this.articlePath = articlePath;
    }
    
    @Column(name="title", nullable=false, length=50)

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
   








}