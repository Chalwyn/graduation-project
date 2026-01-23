package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TestEmployMapper;
import com.ruoyi.system.domain.TestEmploy;
import com.ruoyi.system.service.ITestEmployService;

/**
 * 测试员工模块Service业务层处理
 *
 * @author ruoyi
 * @date 2026-01-13
 */
@Service
public class TestEmployServiceImpl implements ITestEmployService
{
    @Autowired
    private TestEmployMapper testEmployMapper;

    /**
     * 查询测试员工模块
     *
     * @param id 测试员工模块主键
     * @return 测试员工模块
     */
    @Override
    public TestEmploy selectTestEmployById(Long id)
    {
        return testEmployMapper.selectTestEmployById(id);
    }

    /**
     * 查询测试员工模块列表
     *
     * @param testEmploy 测试员工模块
     * @return 测试员工模块
     */
    @Override
    public List<TestEmploy> selectTestEmployList(TestEmploy testEmploy)
    {
        return testEmployMapper.selectTestEmployList(testEmploy);
    }

    /**
     * 新增测试员工模块
     *
     * @param testEmploy 测试员工模块
     * @return 结果
     */
    @Override
    public int insertTestEmploy(TestEmploy testEmploy)
    {
        return testEmployMapper.insertTestEmploy(testEmploy);
    }

    /**
     * 修改测试员工模块
     *
     * @param testEmploy 测试员工模块
     * @return 结果
     */
    @Override
    public int updateTestEmploy(TestEmploy testEmploy)
    {
        return testEmployMapper.updateTestEmploy(testEmploy);
    }

    /**
     * 批量删除测试员工模块
     *
     * @param ids 需要删除的测试员工模块主键
     * @return 结果
     */
    @Override
    public int deleteTestEmployByIds(Long[] ids)
    {
        return testEmployMapper.deleteTestEmployByIds(ids);
    }

    /**
     * 删除测试员工模块信息
     *
     * @param id 测试员工模块主键
     * @return 结果
     */
    @Override
    public int deleteTestEmployById(Long id)
    {
        return testEmployMapper.deleteTestEmployById(id);
    }
}
