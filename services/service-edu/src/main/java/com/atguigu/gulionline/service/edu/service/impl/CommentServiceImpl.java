package com.atguigu.gulionline.service.edu.service.impl;

import com.atguigu.gulionline.service.edu.entity.Comment;
import com.atguigu.gulionline.service.edu.mapper.CommentMapper;
import com.atguigu.gulionline.service.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2021-01-23
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
