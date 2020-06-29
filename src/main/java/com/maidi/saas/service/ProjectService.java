package com.maidi.saas.service;

import com.maidi.saas.entity.vo.OptionDict;
import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.ProjectQuery;
import com.maidi.saas.entity.vo.ProjectVo;

import java.util.List;

/**
 * @Classname ProjectService
 * @Description TODO
 * @Date 2020/6/8 14:39
 * @Created by hjchen
 */
public interface ProjectService {

    int save(ProjectVo projectVo);

    void delete(int id);

    void update(ProjectVo projectVo);

    void updateStage(ProjectVo projectVo);


    ProjectVo getProjectById(int id);

    List<OptionDict> getAllProjects();

    List<ProjectQuery> queryProject(SearchDict dict);

}
