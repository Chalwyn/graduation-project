<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="员工姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入员工姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="部门" prop="departmentId">
        <el-input
          v-model="queryParams.departmentId"
          placeholder="请输入部门"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:employee:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:employee:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:employee:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:employee:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="employeeList"
      @selection-change="handleSelectionChange"
      border
      highlight-current-row
      >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="员工编号" align="center" prop="id" />
      <el-table-column label="员工姓名" align="center" prop="name" />
      <el-table- label="性别" align="center" prop="gender"/>
      <el-table-column label="出生日期" align="center" prop="birthday" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.birthday, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="身份证号" align="center" prop="idCard" />
      <el-table-column label="婚姻状况" align="center" prop="wedlock" />
      <el-table-column label="民族" align="center" prop="nationId" />
      <el-table-column label="籍贯" align="center" prop="nativePlace" />
      <el-table-column label="政治面貌" align="center" prop="politicId" />
      <el-table-column label="邮箱" align="center" prop="email" />
      <el-table-column label="电话号码" align="center" prop="phone" />
      <el-table-column label="联系地址" align="center" prop="address" />
      <el-table-column label="部门id" align="center" prop="departmentId" />
      <el-table-column label="职称ID" align="center" prop="jobLevelId" />
      <el-table-column label="职位ID" align="center" prop="posId" />
      <el-table-column label="聘用形式" align="center" prop="engageForm" />
      <el-table-column label="最高学历" align="center" prop="tiptopDegree" />
      <el-table-column label="所属专业" align="center" prop="specialty" />
      <el-table-column label="毕业院校" align="center" prop="school" />
      <el-table-column label="入职日期" align="center" prop="beginDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.beginDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="在职状态" align="center" prop="workState" />
      <el-table-column label="工号" align="center" prop="workID" />
      <el-table-column label="合同期限" align="center" prop="contractTerm" />
      <el-table-column label="转正日期" align="center" prop="conversionTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.conversionTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="离职日期" align="center" prop="notWorkDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.notWorkDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="合同起始日期" align="center" prop="beginContract" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.beginContract, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="合同终止日期" align="center" prop="endContract" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endContract, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="工龄" align="center" prop="workAge" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:employee:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:employee:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :page-sizes="[5, 10, 20, 30, 50, 100]"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改员工资料对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="员工姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入员工姓名" />
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-input v-model="form.gender" placeholder="请输入性别" />
        </el-form-item>
        <el-form-item label="出生日期" prop="birthday">
          <el-date-picker clearable
            v-model="form.birthday"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出生日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="身份证号" prop="idCard">
          <el-input v-model="form.idCard" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="民族" prop="nationId">
          <el-input v-model="form.nationId" placeholder="请输入民族" />
        </el-form-item>
        <el-form-item label="籍贯" prop="nativePlace">
          <el-input v-model="form.nativePlace" placeholder="请输入籍贯" />
        </el-form-item>
        <el-form-item label="政治面貌" prop="politicId">
          <el-input v-model="form.politicId" placeholder="请输入政治面貌" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="电话号码" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入电话号码" />
        </el-form-item>
        <el-form-item label="联系地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入联系地址" />
        </el-form-item>
        <el-form-item label="部门id" prop="departmentId">
          <el-input v-model="form.departmentId" placeholder="请输入部门id" />
        </el-form-item>
        <el-form-item label="职称ID" prop="jobLevelId">
          <el-input v-model="form.jobLevelId" placeholder="请输入职称ID" />
        </el-form-item>
        <el-form-item label="职位ID" prop="posId">
          <el-input v-model="form.posId" placeholder="请输入职位ID" />
        </el-form-item>
        <el-form-item label="聘用形式" prop="engageForm">
          <el-input v-model="form.engageForm" placeholder="请输入聘用形式" />
        </el-form-item>
        <el-form-item label="所属专业" prop="specialty">
          <el-input v-model="form.specialty" placeholder="请输入所属专业" />
        </el-form-item>
        <el-form-item label="毕业院校" prop="school">
          <el-input v-model="form.school" placeholder="请输入毕业院校" />
        </el-form-item>
        <el-form-item label="入职日期" prop="beginDate">
          <el-date-picker clearable
            v-model="form.beginDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择入职日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="工号" prop="workID">
          <el-input v-model="form.workID" placeholder="请输入工号" />
        </el-form-item>
        <el-form-item label="合同期限" prop="contractTerm">
          <el-input v-model="form.contractTerm" placeholder="请输入合同期限" />
        </el-form-item>
        <el-form-item label="转正日期" prop="conversionTime">
          <el-date-picker clearable
            v-model="form.conversionTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择转正日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="离职日期" prop="notWorkDate">
          <el-date-picker clearable
            v-model="form.notWorkDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择离职日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="合同起始日期" prop="beginContract">
          <el-date-picker clearable
            v-model="form.beginContract"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择合同起始日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="合同终止日期" prop="endContract">
          <el-date-picker clearable
            v-model="form.endContract"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择合同终止日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="工龄" prop="workAge">
          <el-input v-model="form.workAge" placeholder="请输入工龄" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listEmployee, getEmployee, delEmployee, addEmployee, updateEmployee } from "@/api/system/employee"
import {color} from "echarts";
export default {
  name: "Employee",
  computed: {
    color() {
      return color
    }
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 员工资料表格数据
      employeeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 5,
        name: null,
        gender: null,
        birthday: null,
        idCard: null,
        wedlock: null,
        nationId: null,
        nativePlace: null,
        politicId: null,
        email: null,
        phone: null,
        address: null,
        departmentId: null,
        jobLevelId: null,
        posId: null,
        engageForm: null,
        tiptopDegree: null,
        specialty: null,
        school: null,
        beginDate: null,
        workState: null,
        workID: null,
        contractTerm: null,
        conversionTime: null,
        notWorkDate: null,
        beginContract: null,
        endContract: null,
        workAge: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询员工资料列表 */
    getList() {
      this.loading = true
      listEmployee(this.queryParams).then(response => {
        this.employeeList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        gender: null,
        birthday: null,
        idCard: null,
        wedlock: null,
        nationId: null,
        nativePlace: null,
        politicId: null,
        email: null,
        phone: null,
        address: null,
        departmentId: null,
        jobLevelId: null,
        posId: null,
        engageForm: null,
        tiptopDegree: null,
        specialty: null,
        school: null,
        beginDate: null,
        workState: null,
        workID: null,
        contractTerm: null,
        conversionTime: null,
        notWorkDate: null,
        beginContract: null,
        endContract: null,
        workAge: null
      }
      this.resetForm("form")
    },

    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加员工资料"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getEmployee(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改员工资料"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateEmployee(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addEmployee(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids
      this.$modal.confirm('是否确认删除员工资料编号为"' + ids + '"的数据项？').then(function() {
        return delEmployee(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/employee/export', {
        ...this.queryParams
      }, `employee_${new Date().getTime()}.xlsx`)
    }
  }
}

</script>

