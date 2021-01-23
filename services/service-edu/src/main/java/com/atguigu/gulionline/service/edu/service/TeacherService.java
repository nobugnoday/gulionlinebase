package com.atguigu.gulionline.service.edu.service;

import com.atguigu.gulionline.service.edu.entity.Teacher;
import com.atguigu.gulionline.service.edu.entity.query.TeacherQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author atguigu
 * @since 2021-01-23
 */
public interface TeacherService extends IService<Teacher> {

    Page<Teacher> listPage(Integer pageNum, Integer pageSize, TeacherQuery teacherQuery);

    boolean saveTeacher(Teacher teacher);
}
