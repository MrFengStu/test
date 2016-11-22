package com.exp.question.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.exp.entity.Question;
import com.framework.BaseDao;

@Repository
public class QuestionDaoImpl extends BaseDao<Question, String> {

	/**
	 * @zhangzhaoliu
	 * 查询首页中的问答推荐信息 按照点赞人数和时间排
	 * @return
	 */
	public List<Question> findQuestionRecommend() {
		Session session = super.getSession();
		Query query = session.createQuery("from Question order by questionPublishTime DESC,questionLikeNum DESC");
		return query.list();
	}
}
