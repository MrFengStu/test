package com.exp.bug.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exp.bug.dao.BugDaoImpl;
import com.exp.entity.Bug;

@Service
@Transactional(readOnly = true)
public class BugServiceImpl {

	/**
	 * @zhangzhaolin
	 * bug查询
	 */
	@Resource
	private BugDaoImpl bugdaoimpl;

	public List<Bug> findHonor() {
		return bugdaoimpl.findBugRecommend();
	}
}
