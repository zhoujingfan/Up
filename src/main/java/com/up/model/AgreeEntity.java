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
@Table(name="agree"
    ,catalog="up"
)

public class AgreeEntity  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private UserEntity userEntity;
     private WeiboEntity weiboEntity;
     private Timestamp agreeTime;


    // Constructors

    /** default constructor */
    public AgreeEntity() {
    }

    
    /** full constructor */
    public AgreeEntity(Integer id, UserEntity userEntity, WeiboEntity weiboEntity,  Timestamp agreeTime) {
        this.id = id;
        this.userEntity = userEntity;
        this.weiboEntity = weiboEntity;
        this.agreeTime = agreeTime;
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
    
    @Column(name="agree_time", nullable=false, length=19)

    public Timestamp getAgreeTime() {
        return this.agreeTime;
    }
    
    public void setAgreeTime(Timestamp agreeTime) {
        this.agreeTime = agreeTime;
    }
   








}