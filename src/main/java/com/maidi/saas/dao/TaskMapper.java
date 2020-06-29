package com.maidi.saas.dao;

import com.maidi.saas.entity.vo.TaskCommentVo;
import com.maidi.saas.entity.vo.TaskQuery;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Classname TaskDao
 * @Description TODO
 * @Date 2020/6/18 14:39
 * @Created by hjchen
 */
public interface TaskMapper {

    @Select("SELECT complete_rate completeRate,operator,notes,create_time createTime FROM sm_task_comment where task_id=#{id}")
    List<TaskCommentVo> getById(int id);

    @Select("select id,percentage,principal,create_time createTime from sm_task")
    @Results({@Result(property = "id", column = "id")
            , @Result(property = "principal", column = "principal")
            , @Result(property = "percentage", column = "percentage")
            , @Result(property = "createTime", column = "create_time")
            , @Result(property = "content", column = "id", many = @Many(select = "getById", fetchType = FetchType.EAGER))
    })
    List<TaskQuery> getAll();
}
