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
 * RoleEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="role"
    ,catalog="up"
)

public class RoleEntity  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private UserEntity userEntity;
     private String roleName;


    // Constructors

    /** default constructor */
    public RoleEntity() {
    }

    
    /** full constructor */
    public RoleEntity(Integer id, UserEntity userEntity, String roleName) {
        this.id = id;
        this.userEntity = userEntity;
        this.roleName = roleName;
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
    
    @Column(name="role_name", nullable=false, length=10)

    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
   








}