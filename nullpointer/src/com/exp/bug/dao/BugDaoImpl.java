package com.exp.bug.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.exp.entity.Bug;
import com.framework.BaseDao;

@Repository
public class BugDaoImpl extends BaseDao<Bug, String> {
	/**
	 * @zhangzhaolin
	 * @return 首页中返回bug推荐 按照赞的数量排序
	 */
	public List<Bug> findBugRecommend() {
		Session session = super.getSession();
		// 按照赞的数量排序
		Query query = session.createQuery("from Bug order by bugPublishTime DESC,bugLikeNum DESC ");
		return query.list();
	}
}
