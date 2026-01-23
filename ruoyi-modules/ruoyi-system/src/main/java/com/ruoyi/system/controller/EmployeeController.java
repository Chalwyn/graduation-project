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
import com.ruoyi.system.domain.Employee;
import com.ruoyi.system.service.IEmployeeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 员工资料Controller
 * 
 * @author ruoyi
 * @date 2026-01-13
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController extends BaseController
{
    @Autowired
    private IEmployeeService employeeService;

    /**
     * 查询员工资料列表
     */
    @RequiresPermissions("system:employee:list")
    @GetMapping("/list")
    public TableDataInfo list(Employee employee)
    {
        startPage();
        List<Employee> list = employeeService.selectEmployeeList(employee);
        return getDataTable(list);
    }

    /**
     * 导出员工资料列表
     */
    @RequiresPermissions("system:employee:export")
    @Log(title = "员工资料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Employee employee)
    {
        List<Employee> list = employeeService.selectEmployeeList(employee);
        ExcelUtil<Employee> util = new ExcelUtil<Employee>(Employee.class);
        util.exportExcel(response, list, "员工资料数据");
    }

    /**
     * 获取员工资料详细信息
     */
    @RequiresPermissions("system:employee:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(employeeService.selectEmployeeById(id));
    }

    /**
     * 新增员工资料
     */
    @RequiresPermissions("system:employee:add")
    @Log(title = "员工资料", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Employee employee)
    {
        return toAjax(employeeService.insertEmployee(employee));
    }

    /**
     * 修改员工资料
     */
    @RequiresPermissions("system:employee:edit")
    @Log(title = "员工资料", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Employee employee)
    {
        return toAjax(employeeService.updateEmployee(employee));
    }

    /**
     * 删除员工资料
     */
    @RequiresPermissions("system:employee:remove")
    @Log(title = "员工资料", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(employeeService.deleteEmployeeByIds(ids));
    }
}
