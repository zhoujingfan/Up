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
 * FollowEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="follow"
    ,catalog="up"
)

public class FollowEntity  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private UserEntity userEntityByUserId;
     private UserEntity userEntityByFollowUserId;


    // Constructors

    /** default constructor */
    public FollowEntity() {
    }

    
    /** full constructor */
    public FollowEntity(Integer id, UserEntity userEntityByUserId, UserEntity userEntityByFollowUserId) {
        this.id = id;
        this.userEntityByUserId = userEntityByUserId;
        this.userEntityByFollowUserId = userEntityByFollowUserId;
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

    public UserEntity getUserEntityByUserId() {
        return this.userEntityByUserId;
    }
    
    public void setUserEntityByUserId(UserEntity userEntityByUserId) {
        this.userEntityByUserId = userEntityByUserId;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="follow_user_id", nullable=false)

    public UserEntity getUserEntityByFollowUserId() {
        return this.userEntityByFollowUserId;
    }
    
    public void setUserEntityByFollowUserId(UserEntity userEntityByFollowUserId) {
        this.userEntityByFollowUserId = userEntityByFollowUserId;
    }
   








}