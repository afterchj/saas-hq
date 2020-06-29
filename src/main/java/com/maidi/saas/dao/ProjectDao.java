package com.maidi.saas.dao;

import com.maidi.saas.entity.vo.OptionDict;
import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.ProjectQuery;
import com.maidi.saas.entity.vo.ProjectVo;

import java.util.List;

/**
 * @Classname ProjectDao
 * @Description TODO
 * @Date 2020/6/8 14:39
 * @Created by hjchen
 */
public interface ProjectDao {

    ProjectVo getProjectById(int id);

    int saveProject(ProjectVo projectVo);

    void updateProjectById(ProjectVo projectVo);

    void updateStageById(ProjectVo projectVo);

    List<OptionDict> getAllProjects();

    List<ProjectQuery> queryProject(SearchDict map);

    void deleteProjectById(int id);
}
