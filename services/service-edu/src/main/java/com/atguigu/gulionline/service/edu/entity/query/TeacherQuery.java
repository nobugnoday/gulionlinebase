package com.atguigu.gulionline.service.edu.entity.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
// 它接收的属性值会在查询讲师集合时使用，建议属性名和讲师的属性姓名类型一致
@ToString
public class TeacherQuery {

    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "入驻起始时间")
    private String joinDateBegin;

    @ApiModelProperty(value = "入驻结束时间")
    private String joinDateEnd;

}
