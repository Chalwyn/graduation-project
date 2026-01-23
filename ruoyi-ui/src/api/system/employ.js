import request from '@/utils/request'

// 查询测试员工模块列表
export function listEmploy(query) {
  return request({
    url: '/system/employ/list',
    method: 'get',
    params: query
  })
}

// 查询测试员工模块详细
export function getEmploy(id) {
  return request({
    url: '/system/employ/' + id,
    method: 'get'
  })
}

// 新增测试员工模块
export function addEmploy(data) {
  return request({
    url: '/system/employ',
    method: 'post',
    data: data
  })
}

// 修改测试员工模块
export function updateEmploy(data) {
  return request({
    url: '/system/employ',
    method: 'put',
    data: data
  })
}

// 删除测试员工模块
export function delEmploy(id) {
  return request({
    url: '/system/employ/' + id,
    method: 'delete'
  })
}
