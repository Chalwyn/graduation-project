package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TestEmploy;

/**
 * 测试员工模块Service接口
 * 
 * @author ruoyi
 * @date 2026-01-13
 */
public interface ITestEmployService 
{
    /**
     * 查询测试员工模块
     * 
     * @param id 测试员工模块主键
     * @return 测试员工模块
     */
    public TestEmploy selectTestEmployById(Long id);

    /**
     * 查询测试员工模块列表
     * 
     * @param testEmploy 测试员工模块
     * @return 测试员工模块集合
     */
    public List<TestEmploy> selectTestEmployList(TestEmploy testEmploy);

    /**
     * 新增测试员工模块
     * 
     * @param testEmploy 测试员工模块
     * @return 结果
     */
    public int insertTestEmploy(TestEmploy testEmploy);

    /**
     * 修改测试员工模块
     * 
     * @param testEmploy 测试员工模块
     * @return 结果
     */
    public int updateTestEmploy(TestEmploy testEmploy);

    /**
     * 批量删除测试员工模块
     * 
     * @param ids 需要删除的测试员工模块主键集合
     * @return 结果
     */
    public int deleteTestEmployByIds(Long[] ids);

    /**
     * 删除测试员工模块信息
     * 
     * @param id 测试员工模块主键
     * @return 结果
     */
    public int deleteTestEmployById(Long id);
}
