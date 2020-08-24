package com.maidi.saas.utils.client;

import com.maidi.saas.entity.TaskReplyLaunchEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 *任务发起
 *@Author zhaojing
 *@Date 2020/8/19 15:12
 */
@Component
@FeignClient("basicsystem")
public interface TaskClient {

    /**
     *任务发起
     *@Name    launchTask
     *@params  [taskReplyLaunchEntity]
     *@return  java.lang.String
     *@Author  zhaojing
     *@creatTime  2020/8/19 15:48
     */
    @PostMapping("/task/launchTask")
    String launchTask(@RequestBody(required = false) TaskReplyLaunchEntity taskReplyLaunchEntity);
}
