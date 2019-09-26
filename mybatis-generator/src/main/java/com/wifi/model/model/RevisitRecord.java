package com.wifi.model.model;

import java.util.Date;

/**
 * generated by MGB(Mybatis Generator), 小心修改
 * 
 * table name : revisit_record
 *
 * @create time : 2019-09-22
 */
public class RevisitRecord {
    /**
     * 主键
     * column : revisit_record.id
     */
    private Integer id;

    /**
     * 寻人id
     * column : revisit_record.people_id
     */
    private Integer peopleId;

    /**
     * UHID
     * column : revisit_record.uhid
     */
    private String uhid;

    /**
     * 姓名
     * column : revisit_record.name
     */
    private String name;

    /**
     * 性别
     * column : revisit_record.gender
     */
    private String gender;

    /**
     * 年龄
     * column : revisit_record.age
     */
    private Integer age;

    /**
     * 联系人1
     * column : revisit_record.contact1
     */
    private String contact1;

    /**
     * 联系人电话1
     * column : revisit_record.telephone1
     */
    private String telephone1;

    /**
     * 联系人2
     * column : revisit_record.contact2
     */
    private String contact2;

    /**
     * 联系人电话2
     * column : revisit_record.telephone2
     */
    private String telephone2;

    /**
     * 上次回访时间
     * column : revisit_record.revisit_time
     */
    private Date revisitTime;

    /**
     * 创建时间
     * column : revisit_record.create_time
     */
    private Date createTime;

    /**
     * 修改时间
     * column : revisit_record.update_time
     */
    private Date updateTime;

    /**
     * 1带回访，2已回访
     * column : revisit_record.status
     */
    private Integer status;

    /**
     * 备注
     * column : revisit_record.remark
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public String getUhid() {
        return uhid;
    }

    public void setUhid(String uhid) {
        this.uhid = uhid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public Date getRevisitTime() {
        return revisitTime;
    }

    public void setRevisitTime(Date revisitTime) {
        this.revisitTime = revisitTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}