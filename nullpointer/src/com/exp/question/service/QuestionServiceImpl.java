package com.exp.question.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exp.entity.Question;
import com.exp.question.dao.QuestionDaoImpl;

/**
 * @zhangzhaolin
 * 问题查询
 *
 */
@Service
@Transactional(readOnly = true)
public class QuestionServiceImpl {

	@Resource
	private QuestionDaoImpl questiondaoimpl;

	public List<Question> findQuestionRecommend() {
		return questiondaoimpl.findQuestionRecommend();
	}
}
