package com.ruoyi.system.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.system.domain.TestEmploy;
import com.ruoyi.system.service.ITestEmployService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 测试员工模块Controller
 *
 * @author ruoyi
 * @date 2026-01-13
 */
@RestController
@RequestMapping("/employ")
public class TestEmployController extends BaseController
{
    @Autowired
    private ITestEmployService testEmployService;

    /**
     * 查询测试员工模块列表
     */
    @RequiresPermissions("system:employ:list")
    @GetMapping("/list")
    public TableDataInfo list(TestEmploy testEmploy)
    {
        startPage();
        List<TestEmploy> list = testEmployService.selectTestEmployList(testEmploy);
        return getDataTable(list);
    }

    /**
     * 导出测试员工模块列表
     */
    @RequiresPermissions("system:employ:export")
    @Log(title = "测试员工模块", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TestEmploy testEmploy)
    {
        List<TestEmploy> list = testEmployService.selectTestEmployList(testEmploy);
        ExcelUtil<TestEmploy> util = new ExcelUtil<TestEmploy>(TestEmploy.class);
        util.exportExcel(response, list, "测试员工模块数据");
    }

    /**
     * 获取测试员工模块详细信息
     */
    @RequiresPermissions("system:employ:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(testEmployService.selectTestEmployById(id));
    }

    /**
     * 新增测试员工模块
     */
    @RequiresPermissions("system:employ:add")
    @Log(title = "测试员工模块", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestEmploy testEmploy)
    {
        return toAjax(testEmployService.insertTestEmploy(testEmploy));
    }

    /**
     * 修改测试员工模块
     */
    @RequiresPermissions("system:employ:edit")
    @Log(title = "测试员工模块", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestEmploy testEmploy)
    {
        return toAjax(testEmployService.updateTestEmploy(testEmploy));
    }

    /**
     * 删除测试员工模块
     */
    @RequiresPermissions("system:employ:remove")
    @Log(title = "测试员工模块", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(testEmployService.deleteTestEmployByIds(ids));
    }
}
