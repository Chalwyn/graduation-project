package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Employee;

/**
 * 员工资料Service接口
 * 
 * @author ruoyi
 * @date 2026-01-13
 */
public interface IEmployeeService 
{
    /**
     * 查询员工资料
     * 
     * @param id 员工资料主键
     * @return 员工资料
     */
    public Employee selectEmployeeById(Long id);

    /**
     * 查询员工资料列表
     * 
     * @param employee 员工资料
     * @return 员工资料集合
     */
    public List<Employee> selectEmployeeList(Employee employee);

    /**
     * 新增员工资料
     * 
     * @param employee 员工资料
     * @return 结果
     */
    public int insertEmployee(Employee employee);

    /**
     * 修改员工资料
     * 
     * @param employee 员工资料
     * @return 结果
     */
    public int updateEmployee(Employee employee);

    /**
     * 批量删除员工资料
     * 
     * @param ids 需要删除的员工资料主键集合
     * @return 结果
     */
    public int deleteEmployeeByIds(Long[] ids);

    /**
     * 删除员工资料信息
     * 
     * @param id 员工资料主键
     * @return 结果
     */
    public int deleteEmployeeById(Long id);
}
