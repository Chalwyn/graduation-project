package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 员工资料对象 employee
 * 
 * @author ruoyi
 * @date 2026-01-13
 */
public class Employee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工编号 */
    private Long id;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    private String wedlock;

    /** 民族 */
    @Excel(name = "民族")
    private Long nationId;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String nativePlace;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private Long politicId;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phone;

    /** 联系地址 */
    @Excel(name = "联系地址")
    private String address;

    /** 部门id */
    @Excel(name = "部门id")
    private Long departmentId;

    /** 职称ID */
    @Excel(name = "职称ID")
    private Long jobLevelId;

    /** 职位ID */
    @Excel(name = "职位ID")
    private Long posId;

    /** 聘用形式 */
    @Excel(name = "聘用形式")
    private String engageForm;

    /** 最高学历 */
    @Excel(name = "最高学历")
    private String tiptopDegree;

    /** 所属专业 */
    @Excel(name = "所属专业")
    private String specialty;

    /** 毕业院校 */
    @Excel(name = "毕业院校")
    private String school;

    /** 入职日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入职日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginDate;

    /** 在职状态 */
    @Excel(name = "在职状态")
    private String workState;

    /** 工号 */
    @Excel(name = "工号")
    private String workID;

    /** 合同期限 */
    @Excel(name = "合同期限")
    private Long contractTerm;

    /** 转正日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "转正日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date conversionTime;

    /** 离职日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "离职日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date notWorkDate;

    /** 合同起始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同起始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginContract;

    /** 合同终止日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同终止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endContract;

    /** 工龄 */
    @Excel(name = "工龄")
    private Long workAge;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }

    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }

    public void setWedlock(String wedlock) 
    {
        this.wedlock = wedlock;
    }

    public String getWedlock() 
    {
        return wedlock;
    }

    public void setNationId(Long nationId) 
    {
        this.nationId = nationId;
    }

    public Long getNationId() 
    {
        return nationId;
    }

    public void setNativePlace(String nativePlace) 
    {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace() 
    {
        return nativePlace;
    }

    public void setPoliticId(Long politicId) 
    {
        this.politicId = politicId;
    }

    public Long getPoliticId() 
    {
        return politicId;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setDepartmentId(Long departmentId) 
    {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() 
    {
        return departmentId;
    }

    public void setJobLevelId(Long jobLevelId) 
    {
        this.jobLevelId = jobLevelId;
    }

    public Long getJobLevelId() 
    {
        return jobLevelId;
    }

    public void setPosId(Long posId) 
    {
        this.posId = posId;
    }

    public Long getPosId() 
    {
        return posId;
    }

    public void setEngageForm(String engageForm) 
    {
        this.engageForm = engageForm;
    }

    public String getEngageForm() 
    {
        return engageForm;
    }

    public void setTiptopDegree(String tiptopDegree) 
    {
        this.tiptopDegree = tiptopDegree;
    }

    public String getTiptopDegree() 
    {
        return tiptopDegree;
    }

    public void setSpecialty(String specialty) 
    {
        this.specialty = specialty;
    }

    public String getSpecialty() 
    {
        return specialty;
    }

    public void setSchool(String school) 
    {
        this.school = school;
    }

    public String getSchool() 
    {
        return school;
    }

    public void setBeginDate(Date beginDate) 
    {
        this.beginDate = beginDate;
    }

    public Date getBeginDate() 
    {
        return beginDate;
    }

    public void setWorkState(String workState) 
    {
        this.workState = workState;
    }

    public String getWorkState() 
    {
        return workState;
    }

    public void setWorkID(String workID) 
    {
        this.workID = workID;
    }

    public String getWorkID() 
    {
        return workID;
    }

    public void setContractTerm(Long contractTerm) 
    {
        this.contractTerm = contractTerm;
    }

    public Long getContractTerm() 
    {
        return contractTerm;
    }

    public void setConversionTime(Date conversionTime) 
    {
        this.conversionTime = conversionTime;
    }

    public Date getConversionTime() 
    {
        return conversionTime;
    }

    public void setNotWorkDate(Date notWorkDate) 
    {
        this.notWorkDate = notWorkDate;
    }

    public Date getNotWorkDate() 
    {
        return notWorkDate;
    }

    public void setBeginContract(Date beginContract) 
    {
        this.beginContract = beginContract;
    }

    public Date getBeginContract() 
    {
        return beginContract;
    }

    public void setEndContract(Date endContract) 
    {
        this.endContract = endContract;
    }

    public Date getEndContract() 
    {
        return endContract;
    }

    public void setWorkAge(Long workAge) 
    {
        this.workAge = workAge;
    }

    public Long getWorkAge() 
    {
        return workAge;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("gender", getGender())
            .append("birthday", getBirthday())
            .append("idCard", getIdCard())
            .append("wedlock", getWedlock())
            .append("nationId", getNationId())
            .append("nativePlace", getNativePlace())
            .append("politicId", getPoliticId())
            .append("email", getEmail())
            .append("phone", getPhone())
            .append("address", getAddress())
            .append("departmentId", getDepartmentId())
            .append("jobLevelId", getJobLevelId())
            .append("posId", getPosId())
            .append("engageForm", getEngageForm())
            .append("tiptopDegree", getTiptopDegree())
            .append("specialty", getSpecialty())
            .append("school", getSchool())
            .append("beginDate", getBeginDate())
            .append("workState", getWorkState())
            .append("workID", getWorkID())
            .append("contractTerm", getContractTerm())
            .append("conversionTime", getConversionTime())
            .append("notWorkDate", getNotWorkDate())
            .append("beginContract", getBeginContract())
            .append("endContract", getEndContract())
            .append("workAge", getWorkAge())
            .toString();
    }
}
