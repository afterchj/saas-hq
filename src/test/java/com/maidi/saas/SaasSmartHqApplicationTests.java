package com.maidi.saas;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.maidi.saas.biz.TaskBiz;
import com.maidi.saas.dao.TaskDao;
import com.maidi.saas.dao.TaskMapper;
import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.*;
import com.maidi.saas.service.*;
import com.maidi.saas.utils.IdGenerator;
import com.maidi.saas.utils.OssPropertiesUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SaasSmartHqApplicationTests {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private ZuulUserService zuulUserService;

    @Autowired
    private FeignDictService feignDictService;

    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private TaskBiz taskBiz;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private CommonService commonService;

    @Autowired
    private OssPropertiesUtils ossPropertiesUtils;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testPush() {
        OptionDict dict = new OptionDict();
        dict.setId(1);
        dict.setName("小陈");
        Map map = new HashMap();
        map.put("id", 1);
        map.put("name", "测试1");
        redisTemplate.convertAndSend("demo_topic", dict);
    }

    @Test
    public void testTree() {
        SearchDict searchDict = new SearchDict();
        searchDict.setProjectId(256);
//        Map result = taskBiz.treeMap(searchDict);
//        List<TreeVo> result = taskDao.listTree(7, 0, 0);
        List<TreeVo> result = taskDao.getProjects(7);
        List<TaskInfo> taskInfo = taskDao.queryTaskInfo(searchDict);
        log.warn("size {} result {}", taskInfo.size(), result);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void testProperty() {
        System.out.println(ossPropertiesUtils.getBucketName());
        System.out.println(OssPropertiesUtils.FILEHOST);
    }

    @Test
    public void testDict() {
//        log.warn("feign dict {}", feignDictService.listOption());
        log.warn("zuul dict {}", zuulUserService.listProjectOption());
    }

    @Test
    public void testOption() {
        String result = zuulUserService.getAllUser();
        JSONObject jsonObject = JSONObject.parseObject(result);
        System.out.println("result = " + jsonObject);
        String data = jsonObject.getString("data");
        List<UserVo> items = JSON.parseArray(data, UserVo.class);
        Map params = new HashMap();
        params.put("list", items);
//        commonService.insertUsers(params);
//        System.out.println(data);
        System.out.println("items = " + JSONObject.toJSONString(items));
    }

    @Test
    public void testProject() {
        List<TaskQuery> taskVos = taskService.queryTask(null);
//        List<TaskQuery> taskVoList = taskMapper.getAll();
        TaskVo taskVo = taskService.getById(1);
//        System.out.println(JSON.toJSONString(taskVos));
//        System.out.println(JSON.toJSONString(taskVoList));
        System.out.println(JSON.toJSONString(taskVo));
//        ProjectVo projectVo = projectService.getProjectById(1);
//        log.warn("projectVo {}", JSON.toJSONString(projectVo));
        SearchDict dict = new SearchDict();
        dict.setName("测试");
//        dict.setCode("project");
        dict.setStage("项目");
//        List<ProjectQuery> projectQueries=projectService.queryProject(dict);
//        log.warn("projectQueries {} ",JSON.toJSONString(projectQueries));
//        List<OptionDict> projects = projectService.getAllProjects();
//        String json = JSON.toJSONString(projects);
//        log.warn("projects {} ",json);
//        JSONArray array = JSONObject.parseArray(json);
//        for (Object object : array) {
//            JSONObject jsonObject = (JSONObject) object;
//            JSONObject ext_fields = jsonObject.getJSONObject("ext_fields");
//            log.warn("ext_fields {}", ext_fields);
//        }

//        JSONObject object = jsonObject.getJSONObject("ext_fields");
//        log.warn("listUser {}", JSON.toJSONString(projectService.getAllProjects()));
    }

    @Test
    public void testBatchId() {
        for (int i = 0; i < 100; i++) {
            String batchId = idGenerator.batchId(1001, 100);
            log.info("批次号: {}", batchId);
        }
    }

    @Test
    public void testSimpleUUID() {
        for (int i = 0; i < 100; i++) {
            String simpleUUID = idGenerator.simpleUUID();
            log.info("simpleUUID: {}", simpleUUID);
        }
    }

    @Test
    public void testRandomUUID() {
        for (int i = 0; i < 100; i++) {
            String randomUUID = idGenerator.randomUUID();
            log.info("randomUUID: {}", randomUUID);
        }
    }

    @Test
    public void testObjectID() {
        for (int i = 0; i < 100; i++) {
            String objectId = idGenerator.objectId();
            log.warn("objectId: {}", objectId);
        }
    }

    @Test
    public void testSnowflakeId() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                log.warn("分布式 ID: {}", idGenerator.snowflakeId(1, 2));
            });
        }
        executorService.shutdown();
    }
}
