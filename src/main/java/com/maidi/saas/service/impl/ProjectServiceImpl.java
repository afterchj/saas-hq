package com.maidi.saas.service.impl;

import com.maidi.saas.dao.ProjectDao;
import com.maidi.saas.entity.vo.OptionDict;
import com.maidi.saas.entity.dd.SearchDict;
import com.maidi.saas.entity.vo.ProjectQuery;
import com.maidi.saas.entity.vo.ProjectVo;
import com.maidi.saas.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname ProjectDao
 * @Description TODO
 * @Date 2020/6/8 14:39
 * @Created by hjchen
 */

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public int save(ProjectVo projectVo) {
        projectDao.saveProject(projectVo);
        return projectVo.getId();
    }

    @Override
    public void delete(int id) {
        projectDao.deleteProjectById(id);
    }

    @Override
    public void update(ProjectVo projectVo) {
        projectDao.updateProjectById(projectVo);
    }

    @Override
    public void updateStage(ProjectVo projectVo) {
        projectDao.updateStageById(projectVo);
    }

    @Override
    public ProjectVo getProjectById(int id) {
        return projectDao.getProjectById(id);
    }

    @Override
    public List<OptionDict> getAllProjects() {
        return projectDao.getAllProjects();
    }

    @Override
    public List<ProjectQuery> queryProject(SearchDict dict) {
        return projectDao.queryProject(dict);
    }

}
