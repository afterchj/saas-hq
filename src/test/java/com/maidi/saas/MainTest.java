//package com.maidi.saas;
//
//import com.alibaba.fastjson.JSON;
//import com.maidi.saas.entity.dd.ResultDict;
//import com.maidi.saas.entity.vo.*;
//import com.maidi.saas.utils.PingYinUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
///**
// * @Classname MainTest
// * @Description TODO
// * @Date 2020/6/4 15:06
// * @Created by hjchen
// */
//
//@Slf4j
//public class MainTest {
//    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
//
//
//    @Test
//    public void testOption() {
//        UserVo user = new UserVo();
//        OptionDict optionDict=new OptionDict();
//        optionDict.setName("test2");
//        optionDict.setId(2);
//        user.setId(1);
//        user.setUsername("test");
//        Item<UserVo> userItem = new Item<>();
//        Item<OptionDict> optionDictItem=new Item<>();
//        optionDictItem.setT(optionDict);
//        userItem.setT(user);
//        List<Item> list = new ArrayList<>();
//        list.add(userItem);
//        list.add(optionDictItem);
//        log.warn("listItem {}", list);
//    }
//
//    @Test
//    public void testExtFields() {
//        Map map = new HashMap();
//        for (int i = 1; i < 4; i++) {
//            map.put("key" + i, "value" + i);
//        }
//        System.out.println(JSON.toJSONString(new TaskVo()));
//    }
//
//    @Test
//    public void contextLoads() {
//        Map result = new HashMap();
//        Map map = new HashMap();
//        List<OptionDict> customers = new ArrayList<>();
//        List<OptionDict> managers = new ArrayList<>();
//        List<OptionDict> bds = new ArrayList<>();
//        List<OptionDict> items = new ArrayList<>();
//        List<OptionDict> stages = new ArrayList<>();
//        List<OptionDict> grades = new ArrayList<>();
//        List<OptionDict> types = new ArrayList<>();
//
//        for (int i = 1; i < 4; i++) {
//            map.put("key" + i, "value" + i);
//            OptionDict manager = new OptionDict();
//            OptionDict customer = new OptionDict();
//            OptionDict item = new OptionDict();
//            OptionDict stage = new OptionDict();
//            OptionDict bd = new OptionDict();
//            OptionDict grade = new OptionDict();
//            OptionDict type = new OptionDict();
//            bd.setId(i);
//            bd.setName("BD" + i);
//            stage.setId(i);
//            stage.setName("项目阶段" + i);
//            manager.setId(i * 2);
//            manager.setName("项目经理" + i);
//            item.setId(i);
//            item.setName("项目类型" + i);
//            managers.add(manager);
//            bds.add(bd);
//            items.add(item);
//            customer.setId(i);
//            customer.setName("客户" + i);
//            grade.setId(i);
//            grade.setName("客户等级" + i);
//            type.setId(i);
//            type.setName("客户类型" + i);
//            stages.add(stage);
//            grades.add(grade);
//            types.add(type);
//            customers.add(customer);
//        }
//        ProjectVo projectVo = new ProjectVo();
//        projectVo.setId(1);
////        projectVo.setExtFields(map);
//        projectVo.setProjectName("测试项目");
//        projectVo.setProjectDesc("测试项目，看看效果");
//        projectVo.setProjectCode(String.format("project_%s", PingYinUtil.getFirstSpell("测试项目")));
//        CustomerVo customerVo = new CustomerVo();
//        customerVo.setId(1);
//        customerVo.setInfo("测试客户信息");
//        customerVo.setName("测试客户");
//        customerVo.setCustomerGrade(grades);
//        customerVo.setCustomerType(types);
////        projectVo.setPlanStartTime(new Date());
////        projectVo.setPlanEndTime(new Date());
////        projectVo.setActualStartTime(new Date());
////        projectVo.setActualEndTime(new Date());
//        projectVo.setCustomerId(1);
//        projectVo.setProjectManagerId(1);
//        projectVo.setProjectBDId(2);
//        projectVo.setProjectStageId(1);
//        projectVo.setProjectTypeId(1);
//        result.put("data", projectVo);
//        result.put("code", ResultDict.SUCCESS.getCode());
//        result.put("msg", ResultDict.SUCCESS.getValue());
////        System.out.println(JSON.toJSONString(result));
//        System.out.println(JSON.toJSONString(map));
//
//    }
//
//    @Test
//    public void testStr() {
////        log.warn("strFormat {} dateStr {}",String.format("project_%s", "code1001"),format.format(new Date()));
//        Map result = new HashMap();
//        result.put("code", ResultDict.SUCCESS.getCode());
//        result.put("msg", ResultDict.SUCCESS.getValue());
//        for (int i = 1; i < 4; i++) {
//            result.put("key" + i, "value" + i);
//        }
//        EcodeVo ecodeVo = new EcodeVo();
//        ecodeVo.setStatus(true);
//        ecodeVo.setCreateTime(new Date());
//        ecodeVo.setModuleName("任务管理");
//        ecodeVo.setProjectName("测试项目");
//        ecodeVo.setOperator("测试员");
//        ecodeVo.setEcode(String.format("ecode_%s", PingYinUtil.getFirstSpell("测试任务拆分")));
////        System.out.println(JSON.toJSONString(ecodeVo));
////        ProjectVo projectVo = new ProjectVo();
////        projectVo.setExtFields(result);
//        result.put("data", ecodeVo);
//        System.out.println(JSON.toJSONString(result));
//    }
//
//    @Test
//    public void getEcodeByid() {
//        Map result = new HashMap();
//        EcodeVo ecodeVo = new EcodeVo();
//        List<OptionDict> projects = new ArrayList<>();
//        List<OptionDict> modules = new ArrayList<>();
//        ecodeVo.setId(1);
//        ecodeVo.setStatus(false);
//        ecodeVo.setModuleId(1);
//        ecodeVo.setProjectId(1);
//        ecodeVo.setNotes("测试任务分解修改");
//        ecodeVo.setEcode(String.format("ecode_%s", PingYinUtil.getFirstSpell("测试任务拆分")));
//        for (int i = 1; i < 4; i++) {
//            OptionDict project = new OptionDict();
//            OptionDict module = new OptionDict();
//            project.setId(i);
//            project.setName("项目" + i);
//            module.setId(i);
//            module.setName("模块" + i);
//            projects.add(project);
//            modules.add(module);
//        }
//        result.put("code", ResultDict.SUCCESS.getCode());
//        result.put("msg", ResultDict.SUCCESS.getValue());
//        result.put("data", ecodeVo);
//
//        System.out.println(JSON.toJSONString(result));
//    }
//
//    @Test
//    public void testProjectQueryList() {
//        Map result = new HashMap();
//        result.put("code", ResultDict.SUCCESS.getCode());
//        result.put("msg", ResultDict.SUCCESS.getValue());
//        List<ProjectQuery> list = new ArrayList<>();
//        for (int i = 1; i < 3; i++) {
//            ProjectQuery projectQuery = new ProjectQuery();
//            projectQuery.setId(i);
//            projectQuery.setSequence(i * 100);
//            projectQuery.setProjectName("测试项目" + i);
//            projectQuery.setProjectCode(String.format("project_%s", PingYinUtil.getFirstSpell("测试项目") + i));
//            projectQuery.setProjectStage("测试阶段" + i);
//            projectQuery.setProjectType("项目类型" + i);
//            projectQuery.setCustomer("客户" + i);
//            projectQuery.setProjectBD("项目BD" + i);
//            projectQuery.setProjectManager("项目经理" + i);
//            projectQuery.setProjectProgress("%" + i * 20);
//            projectQuery.setPlanStartTime(new Date());
//            projectQuery.setPlanEndTime(new Date());
//            projectQuery.setActualStartTime(new Date());
//            projectQuery.setActualEndTime(new Date());
//            projectQuery.setCreateTime(new Date());
//            list.add(projectQuery);
//        }
//        result.put("data", list);
//        System.out.println(JSON.toJSONString(result));
//    }
//
//    @Test
//    public void testAddTask() {
//        Map result = new HashMap();
//        TaskVo taskVo = new TaskVo();
//        taskVo.setProjectId(1);
//        taskVo.setParentId(1);
//        taskVo.setTaskName("测试任务");
//        taskVo.setTimeSheet("8");
//        taskVo.setPriority("中");
//        taskVo.setPlanStartTime(new Date());
//        taskVo.setPlanEndTime(new Date());
//        result.put("data", taskVo);
//        result.put("code", ResultDict.SUCCESS.getCode());
//        result.put("msg", ResultDict.SUCCESS.getValue());
//        System.out.println(JSON.toJSONString(taskVo));
//    }
//
//    @Test
//    public void testTaskQuery() {
//        Map result = new HashMap();
//        result.put("code", ResultDict.SUCCESS.getCode());
//        result.put("msg", ResultDict.SUCCESS.getValue());
//        List<TaskQuery> list = new ArrayList<>();
//        for (int i = 1; i < 4; i++) {
//            List<TaskRemarkVo> list1 = new ArrayList<>();
//            TaskQuery query = new TaskQuery();
//            if (i % 2 != 0) {
//                TaskRemarkVo remarkVo = new TaskRemarkVo();
//                remarkVo.setNotes("测试完成内容" + i);
//                remarkVo.setOperator("测试人" + i);
//                remarkVo.setUpdateTime(new Date());
//                list1.add(remarkVo);
//            } else {
//                TaskRemarkVo remarkVo = new TaskRemarkVo();
//                remarkVo.setNotes("测试完成内容");
//                remarkVo.setOperator("测试人");
//                remarkVo.setUpdateTime(new Date());
//                list1.add(remarkVo);
//            }
////            query.setContent(list1);
////            query.setId(1);
////            query.setSequence(i * 100 + 1);
////            query.setOperator("维护人" + i);
////            query.setCompleteRate(i * 20 + "%");
////            query.setUpdateTime(new Date());
////            list.add(query);
//        }
//        result.put("data", list);
//        System.out.println(JSON.toJSONString(list));
//    }
//
//    @Test
//    public void testTimeSheet() {
//        TimeSheetVo timeSheetVo = new TimeSheetVo();
//        timeSheetVo.setLaborHour("标准任务工时");
//        timeSheetVo.setLaborHour("8h");
//        System.out.println(JSON.toJSONString(timeSheetVo));
//    }
//
//    @Test
//    public void testTemplate() {
//        ProjectTemplateVo templateVo = new ProjectTemplateVo();
//        templateVo.setProjectId(1);
//        templateVo.setTemplateType("项目模板");
//        templateVo.setTemplateName("测试模板");
//        templateVo.setNotes("测试导出模板。");
//        System.out.println(JSON.toJSONString(templateVo));
//    }
//
//    @Test
//    public void testTaskLog() {
//        Map result = new HashMap();
//        result.put("code", ResultDict.SUCCESS.getCode());
//        result.put("msg", ResultDict.SUCCESS.getValue());
//        List<TaskRemarkVo> list = new ArrayList<>();
//        for (int i = 1; i < 4; i++) {
//            TaskRemarkVo remarkVo = new TaskRemarkVo();
//            if (i % 2 != 0) {
//                remarkVo.setStatus(false);
//            } else {
//                remarkVo.setStatus(true);
//            }
//            remarkVo.setOperator("测试人" + i);
//            remarkVo.setCreateTime(new Date());
//            remarkVo.setUpdateTime(new Date());
//            list.add(remarkVo);
//        }
//        result.put("data", list);
//        System.out.println(JSON.toJSONString(list));
//    }
//}
