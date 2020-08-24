package com.maidi.saas.entity;

import java.util.List;

/**
 *微服务获取部门,岗位,角色
 *@Author zhaojing
 *@Date 2020/7/29 10:15
 */
public class UserInfoEntity {

    /**
     * 部门id
     */
    private List<Long> deptIds;

    /**
     * 角色id
     */
    private List<Long> roleIds;

    /**
     * 岗位id
     */
    private List<Long> jobIds;

    public List<Long> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(List<Long> deptIds) {
        this.deptIds = deptIds;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public List<Long> getJobIds() {
        return jobIds;
    }

    public void setJobIds(List<Long> jobIds) {
        this.jobIds = jobIds;
    }

    @Override
    public String toString() {
        return "UserInfoEntity{" +
                "deptIds=" + deptIds +
                ", roleIds=" + roleIds +
                ", jobIds=" + jobIds +
                '}';
    }
}
