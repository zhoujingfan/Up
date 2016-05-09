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
 * RepostEntity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="repost"
    ,catalog="up"
)

public class RepostEntity  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private WeiboEntity weiboEntityByRepostId;
     private WeiboEntity weiboEntityBySourceId;


    // Constructors

    /** default constructor */
    public RepostEntity() {
    }

    
    /** full constructor */
    public RepostEntity(Integer id, WeiboEntity weiboEntityByRepostId, WeiboEntity weiboEntityBySourceId) {
        this.id = id;
        this.weiboEntityByRepostId = weiboEntityByRepostId;
        this.weiboEntityBySourceId = weiboEntityBySourceId;
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
        @JoinColumn(name="repost_id", nullable=false)

    public WeiboEntity getWeiboEntityByRepostId() {
        return this.weiboEntityByRepostId;
    }
    
    public void setWeiboEntityByRepostId(WeiboEntity weiboEntityByRepostId) {
        this.weiboEntityByRepostId = weiboEntityByRepostId;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="source_id", nullable=false)

    public WeiboEntity getWeiboEntityBySourceId() {
        return this.weiboEntityBySourceId;
    }
    
    public void setWeiboEntityBySourceId(WeiboEntity weiboEntityBySourceId) {
        this.weiboEntityBySourceId = weiboEntityBySourceId;
    }
   








}