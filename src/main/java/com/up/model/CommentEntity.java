package com.up.model;

// default package

import java.sql.Timestamp;
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
 * CommentEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="comment"
    ,catalog="up"
)

public class CommentEntity  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private UserEntity userEntity;
     private WeiboEntity weiboEntity;
     private String commentContent;
     private Timestamp commentTime;


    // Constructors

    /** default constructor */
    public CommentEntity() {
    }

    
    /** full constructor */
    public CommentEntity(Integer id, UserEntity userEntity, WeiboEntity weiboEntity, String commentContent, Timestamp commentTime) {
        this.id = id;
        this.userEntity = userEntity;
        this.weiboEntity = weiboEntity;
        this.commentContent = commentContent;
        this.commentTime = commentTime;
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
    
    @Column(name="comment_content", nullable=false)

    public String getCommentContent() {
        return this.commentContent;
    }
    
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
    
    @Column(name="comment_time", nullable=false, length=19)

    public Timestamp getCommentTime() {
        return this.commentTime;
    }
    
    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }
   








}