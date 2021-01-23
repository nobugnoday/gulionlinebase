package com.atguigu.gulionline.service.edu.service.impl;

import com.atguigu.gulionline.service.edu.entity.Teacher;
import com.atguigu.gulionline.service.edu.entity.query.TeacherQuery;
import com.atguigu.gulionline.service.edu.mapper.TeacherMapper;
import com.atguigu.gulionline.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2021-01-23
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public Page<Teacher> listPage(Integer pageNum, Integer pageSize, TeacherQuery teacherQuery) {

        Page<Teacher> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        // 获取teacher中的属性的值
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String joinDateBegin = teacherQuery.getJoinDateBegin();
        String joinDateEnd = teacherQuery.getJoinDateEnd();
        // 检测姓名是否有值
        if (!StringUtils.isEmpty(name)) {
            // 左% 会索引失效
            // 根据姓名进行模糊查询
            queryWrapper.likeRight("name",name);
        }
        if (level != null) {
            queryWrapper.eq("level",level);
        }

        // 判断头衔是否为空
        if (!StringUtils.isEmpty(joinDateBegin)){
            queryWrapper.ge("join_date",joinDateBegin);
        }


        if (!StringUtils.isEmpty(joinDateEnd)) {
            queryWrapper.le("join_date",joinDateEnd);
        }

        return   baseMapper.selectPage(page,queryWrapper);

    }

    @Override
    public boolean saveTeacher(Teacher teacher) {

        // 唯一型校验 : 根据提交的讲师的name值去数据库中查询记录的行数，如果>0 代表数据库中已经存在
        String name = teacher.getName();
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        // 根据queryWrapper查询 数据中有无
        Integer count = baseMapper.selectCount(queryWrapper);
        if (count >0) {
            return false;
        }
        baseMapper.insert(teacher);
        return true;
    }
}
