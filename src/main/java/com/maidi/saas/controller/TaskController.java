package com.maidi.saas.controller;

import com.maidi.saas.biz.TaskBiz;
import com.maidi.saas.entity.dd.ResultDict;
import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.*;
import com.maidi.saas.service.CommonService;
import com.maidi.saas.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.util.*;

/**
 * @Classname MainController
 * @Description TODO
 * @Date 2020/6/6 11:03
 * @Created by hjchen
 */

@RestController
@Api(description = "任务分解API接口")
@RequestMapping("/task")
@Slf4j
public class TaskController extends BaseController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private TaskBiz taskBiz;


    @GetMapping("/tree")
    public Map treeMap(SearchDict dict) {
        Map result = taskBiz.treeMap(dict);
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        return result;
    }

    @DeleteMapping()
    public Map delete(int id) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        taskService.deleteTaskById(id);
        return result;
    }

    @GetMapping
    public Map option() {
        Map data = new HashMap();
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        List<Item> stages = commonService.getOptions("sm_stage", "");
        List<Item> priority = commonService.getOptions("sm_priority", "");
        List<Item> principal = commonService.getOptions("sm_user", "");
        List<TimeSheetVo> timeSheet = taskService.getTimeSheet();
        data.put("stage", stages);
        data.put("priority", priority);
        data.put("principal", principal);
        data.put("timeSheet", timeSheet);
        result.put("data", data);
        return result;
    }

    @ApiOperation(value = "新增任务", notes = "新增任务分解功能", produces = "application/json")
    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public Map addTask(@RequestBody(required = false) TaskVo taskVo) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        taskService.save(taskVo);
        return result;
    }

    @ApiOperation(value = "快捷维护", notes = "快捷更新任务完成比率")
    @RequestMapping(value = "/mark", method = RequestMethod.POST)
    public Map mark(@RequestBody(required = false) TaskCommentVo commentVo) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        taskService.updateTaskComment(commentVo);
        return result;
    }

    @ApiOperation(value = "回复任务", notes = "回复任务务完成详情")
    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    public Map reply(@RequestBody(required = false) TaskCommentVo commentVo) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        taskService.saveTaskComment(commentVo);
        return result;
    }

    @ApiOperation(value = "增加备注", notes = "修改任务状态")
    @RequestMapping(value = "/addNotes", method = RequestMethod.POST)
    public Map addNotes(@RequestBody(required = false) TaskLogVo remarkVo) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        taskService.saveTaskLog(remarkVo);
        return result;
    }

    @ApiOperation(value = "任务完成内容查询", notes = "任务看板功能")
    @RequestMapping(value = "/queryTask", method = RequestMethod.GET)
    public Map queryTask(SearchDict dict) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        List<TaskQuery> taskVoList = taskService.queryTask(dict);
        result.put("data", taskVoList);
        return result;
    }

    @ApiOperation(value = "获取任务详情", notes = "根据项目id或任务id查看任务详情")
    @RequestMapping(value = "/queryTaskInfo", method = RequestMethod.GET)
    public Map getTaskInfo(SearchDict dict) {
        log.warn("queryTaskInfo {}", dict);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        List<TaskInfo> taskVoList = taskService.getTaskInfo(dict);
        result.put("data", taskVoList);
        return result;
    }

    @ApiOperation(value = "获取任务回复列表", notes = "根据任务id返回任务回复详情")
    @RequestMapping(value = "/listCommentById", method = RequestMethod.GET)
    public Map listComment(int id) {
        log.warn("queryTaskInfo {}", id);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        List<TaskCommentVo> commentVos = taskService.getTaskListById(id);
        result.put("data", commentVos);
        return result;
    }

    @ApiOperation(value = "日志维护记录容查询", notes = "任务日志管理功能")
    @RequestMapping(value = "/queryLog", method = RequestMethod.GET)
    public Map queryLog(SearchDict dict) {
//        log.warn("dict {}", dict);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        List<TaskLogVo> taskVoList = taskService.queryTaskLog(dict);
        result.put("data", taskVoList);
        return result;
    }

    @ApiOperation(value = "查看任务", notes = "根据ID查看任务详情")
    @RequestMapping(value = "/getTaskById", method = RequestMethod.GET)
    public Map getTaskById(int id, Integer flag) {
        log.warn("id {} flag {}", id, flag);
        Map result = new HashMap();
        if (flag != null && flag != 0) {
            TaskVo taskVo = taskService.getById(id);
            result.put("code", ResultDict.SUCCESS.getCode());
            result.put("msg", ResultDict.SUCCESS.getValue());
            result.put("data", taskVo);
        } else {
            result.put("code", ResultDict.ID_NOT_CORRECT.getCode());
            result.put("msg", ResultDict.ID_NOT_CORRECT.getValue());
        }
        return result;
    }

    @ApiOperation(value = "更新任务", notes = "根据id修改任务")
    @RequestMapping(value = "/updateTaskById", method = RequestMethod.POST)
    public Map updateById(@RequestBody(required = false) TaskVo taskVo) {
        Map result = new HashMap();
        taskService.updateById(taskVo);
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        return result;
    }

    @RequestMapping(value = "/template", method = RequestMethod.GET)
    public Map template() {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        List<Item> types = commonService.getOptions("sm_type", null);
        result.put("data", types);
        return result;
    }

    @RequestMapping(value = "/getTemplate", method = RequestMethod.GET)
    public Map getTemplate() {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        List<Item> templates = commonService.getOptions("sm_template", null);
        result.put("data", templates);
        return result;
    }

    @RequestMapping(value = "/importTemplate", method = RequestMethod.POST)
    public Map importTemplate(@RequestBody TemplateVo templateVo) {
        log.warn("templateVo {}", templateVo);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        templateVo.setTemplateName(String.format("模板导入_%s", templateVo.getProjectId()));
        int typeId = taskService.getType(templateVo.getTemplateId());
        templateVo.setTypeId(typeId);
        log.warn("id {}", typeId);
        taskService.saveTemplate(templateVo);
        return result;
    }

    @RequestMapping(value = "/exportTemplate", method = RequestMethod.POST)
    public Map exportTemplate(@RequestBody(required = false) TemplateVo templateVo) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        taskService.saveTemplate(templateVo);
        return result;
    }

    @RequestMapping(value = "/getSheetById", method = RequestMethod.GET)
    public Map getSheetById(int id) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        result.put("data", taskService.getTimeSheetById(id));
        return result;
    }

    @RequestMapping(value = "/addTimeSheet", method = RequestMethod.POST)
    public Map addTimeSheet(@RequestBody(required = false) TimeSheetVo sheetVo) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        taskService.saveTimeSheet(sheetVo);
        return result;
    }

    @RequestMapping(value = "/editTimeSheet", method = RequestMethod.POST)
    public Map setTimeSheet(@RequestBody(required = false) TimeSheetVo sheetVo) {
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        taskService.updateTimeSheetById(sheetVo);
        return result;
    }

    @GetMapping("/listTree")
    public Map timeSheet(Integer id) {
        log.warn("id {}", id);
        int treeId = id == null ? 0 : id;
        Map result = taskBiz.treeTimeSheet(treeId);
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        return result;
    }

    @RequestMapping(value = "/deleteTaskById", method = RequestMethod.GET)
    public Map deleteTaskById(int id) {
        log.warn("id {}", id);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        taskService.deleteTaskById(id);
        return result;
    }
    @RequestMapping(value = "/deleteSheetById", method = RequestMethod.GET)
    public Map deleteSheetById(int id) {
        log.warn("id {}", id);
        Map result = new HashMap();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        taskService.deleteSheetById(id);
        return result;
    }
}
