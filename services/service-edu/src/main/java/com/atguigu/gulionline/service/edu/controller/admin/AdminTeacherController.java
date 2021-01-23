package com.atguigu.gulionline.service.edu.controller.admin;


import com.atguigu.gulionline.service.base.result.R;
import com.atguigu.gulionline.service.edu.entity.Teacher;
import com.atguigu.gulionline.service.edu.entity.query.TeacherQuery;
import com.atguigu.gulionline.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2021-01-23
 */

@RestController   // Controller + ResponseBody
@RequestMapping("/admin/edu/teacher")
@Api(tags="讲师管理模块")
public class AdminTeacherController {

    @Autowired
    TeacherService teacherService;


    // 6 根据id查询讲师
    @ApiOperation(value = "根据id查询讲师")
    @GetMapping("/get/{id}")
    public R getById(@PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        return R.ok().data("item",teacher);
    }

    // 7 根据id更新讲师
    @ApiOperation(value = "根据id进行更新讲师信息")
    @PutMapping("/update")
    public R updateTeacher(@RequestBody Teacher teacher){
         // 用户的唯一性校验，根据id查询讲师姓名，然后判断如果讲师姓名修改 ，再去判断唯一性
        boolean b = teacherService.updateById(teacher);
        if (b) {
            return R.ok();
        }
        return R.error().message("跟新失败");
    }


    // 5 新增讲师
    @ApiOperation(value = "新增讲师")
    @PostMapping("save")
    public R saveTeacher(@RequestBody Teacher teacher){
        boolean flag = teacherService.saveTeacher(teacher);
        if (flag) {
            return R.ok();
        }

        return R.error().message("讲师姓名已存在");
    }


    // 4 带条件的分页查询
    @ApiOperation(value = "根据查询条件进行查询")
    @GetMapping("list/{pageNum}/{pageSize}")
    public R listPageByCondition(@PathVariable(value = "pageNum") Integer pageNum,
                                 @PathVariable Integer pageSize,
                                 TeacherQuery teacherQuery ){

//        Page<Teacher> page = new Page<>(pageNum,pageSize);
//        teacherService.page(page);
        // 带条件的分页查询对象
        Page<Teacher> page  = teacherService.listPage(pageNum,pageSize,teacherQuery);

        return R.ok().data("page",page);

    }



    // 3 查询讲师的分页数据
//    @ApiOperation(value = "进行分页查询讲师")
//     @GetMapping("/list/{pageNum}/{pageSize}")
//     public R listPage(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
//         Page<Teacher> page = new Page<>(pageNum,pageSize);
//         teacherService.page(page);
//         return R.ok().data("page",page);
//     }


    //2 删除讲师
    @ApiOperation(value = "删除讲师")
    @DeleteMapping("/remove/{id}")
    public R deleteTeacher(@ApiParam(value = "讲师id")@PathVariable(value = "id")String id){
        boolean b = teacherService.removeById(id);
        if (b) {
            return R.ok();
        }
        return R.error().message("记录不存在");
    }


    /**
     *  统一相应类
     *      状态码  :Integer code
     *      状态描述 ： String msg
     *      是否成功 ： boolean success
     *      成功的相应数据 ：Map<K,v> data
     *
     *
     *   javabean 的类型
     *
     *      1.entity： 数据库表对应的bean
     *      2.Form/Query 前端页面表单收集提交的数据对应的javabean
     *      3.VO ： view Object 浏览器需要显示的数据对应的bean
     *      4.DTO : data transfer object 微服务之间远程访问时需要公用的类
     *      业务bean ： Page类
     *
     */
    // 1 查询所有的讲师
    @ApiOperation(value = "查询所有讲师")
    @GetMapping("/list")
    public R getList(){
        // 代码正常执行， 会返回数据到结果集，如果出现异常一般选择trycatch 返回异常信息给浏览器（这两种相应的状态码一致）
        List<Teacher> teachers = teacherService.list();
        return R.ok().data("items",teachers);
    }

}

