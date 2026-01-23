package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 测试员工模块对象 test_employ
 * 
 * @author ruoyi
 * @date 2026-01-13
 */
public class TestEmploy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工id */
    private Long id;

    /** 员工姓名 */
    @Excel(name = "张三")
    private String employName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setEmployName(String employName) 
    {
        this.employName = employName;
    }

    public String getEmployName() 
    {
        return employName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("employName", getEmployName())
            .toString();
    }
}
