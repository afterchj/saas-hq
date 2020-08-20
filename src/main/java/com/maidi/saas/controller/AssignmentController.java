package com.maidi.saas.controller;

import com.maidi.saas.biz.TaskManager;
import com.maidi.saas.entity.dd.ResultDict;
import com.maidi.saas.entity.dd.SearchDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Classname AssignmentController
 * @Description TODO
 * @Date 2020/08/14 14:15
 * @Created by hjchen
 */
@RestController
@RequestMapping("/assignment")
public class AssignmentController extends BaseController {

    @Autowired
    private TaskManager taskManager;

    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public Map tree() {
        Map result = taskManager.tree();
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        return result;
    }

    @RequestMapping(value = "/subtree", method = RequestMethod.GET)
    public Map subtree(SearchDict dict) {
        Map result = taskManager.subtree(dict);
        result.put("code", ResultDict.SUCCESS.getCode());
        result.put("msg", ResultDict.SUCCESS.getValue());
        return result;
    }
}
