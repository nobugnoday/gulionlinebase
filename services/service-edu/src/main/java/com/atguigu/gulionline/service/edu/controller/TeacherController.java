package com.atguigu.gulionline.service.edu.controller;


import com.atguigu.gulionline.service.edu.entity.Teacher;
import com.atguigu.gulionline.service.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.service.Tags;

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
@RequestMapping("/edu/teacher")
@Api(tags="讲师模块")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    /**
     *  测试工具
     *  postman ：功能模块测试
     *  swagger 2 /3  功能模块测试
     *         1 、引入swagger依赖
     *         2 创建swapper配置类，启用swapper
     *              Swapper注解
     *                  2.1 对controller进行分组的注解或者配置
     *                      接口分为两类 ： 一种是管理员访问 ，一种是会员访问
     *                      后台管理 ：路径中包含/admin
     *                      用户系统 ；路径中包含/api
     *                  2.2 对controller和它的接口进行描述的注解
     *                      @Api 描述接口类
     *                      @ApiOption : 描述接口中的一个方法
     *                  2.3 对接口返回值对象进行描述的注解
     *                      @ApiModel:描述Javabean
     *                      @APIModelProperty 描述javabean 的一个属性
     *
     *         3 . 项目运行时，可以通过路径：http://ip:端口号/swapper-ui.html
     *  jmeter : 并发性能压力测试
     *  ab :
     *
     */

    // 查询所有的讲师
    @ApiOperation(value = "查询所有讲师")
    @GetMapping("/list")
    public List<Teacher> getList(){
        List<Teacher> list = teacherService.list();
        return list;
    }

    // 查询指定的讲师

    /**
     *  参数 ：
     *      1 路径参数 (参数比较少时)
     *          根据id查询
     *          查询分页数据
     *          @PathVariable
     *      2 在请求参数中传参
     *           get :url?k = v & k2 =v2
     *           post : 请求参数拼接后存在请求体中
     *              这两种方式后台获取的方式一样
     *      @RequestParam    获取指定的一个参数
     *      POJO入参：只要提交的参数的key 和pojo的属性名称一致即可
     *      url ?id=1,2,3,4  List<Integer> id
     *
     *      3 在请求体中使用json传参
     *         @RequestBody接受
     *
     */

    // @ApiOperation 描述接口中的一个方法
    @ApiOperation(value = "根据id查询讲师")
    @PostMapping("get/{id}")
    public Teacher getById1(@ApiParam(value = "讲师id",required = true) @PathVariable("id") String id){
            Teacher teacher = teacherService.getById(id);
            return teacher;
    }

    @ApiOperation(value = "根据id查询讲师")
    @PutMapping("get")
    public Teacher getById2(@ApiParam(value = "讲师id")@RequestParam("id") String id){
        Teacher teacher = teacherService.getById(id);
        return teacher;

    }
}

