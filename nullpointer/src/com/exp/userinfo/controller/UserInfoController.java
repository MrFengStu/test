package com.exp.userinfo.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exp.bug.service.BugServiceImpl;
import com.exp.entity.Bug;
import com.exp.entity.Question;
import com.exp.entity.Tag;
import com.exp.entity.UserInfo;
import com.exp.question.service.QuestionServiceImpl;
import com.exp.tag.service.TagServiceImpl;
import com.exp.userinfo.service.UserInfoServiceImpl;

@Controller
public class UserInfoController {
	@Resource
	private UserInfoServiceImpl userInfoServiceImpl;
	@Resource
	private BugServiceImpl bugserviceimpl;
	@Resource
	private QuestionServiceImpl questionserviceimpl;
	@Resource
	private TagServiceImpl tagserviceimpl;

	/**
	 * @zhangzhaolin
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(HttpSession session) {
		// bug推荐
		List<Bug> bugList = bugserviceimpl.findHonor().subList(0, 6);
		session.setAttribute("bugHonorList", bugList);
		// 查询问答推荐
		List<Question> questionList = questionserviceimpl.findQuestionRecommend().subList(0, 6);
		session.setAttribute("questionHonorList", questionList);
		// 所有标签信息
		List<Tag> tagList = tagserviceimpl.findAllTag();
		session.setAttribute("tagList", tagList);
		return "index";
	}

	/**
	 * 根据用户的id查找用户，返回home.jsp页面
	 * zhangzhaolin
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String findById(@RequestParam(value = "id", required = false) Integer id, HttpServletRequest request) {
		// 手动赋予id值，等登录模块写好再动态获取
		id = 1;
		UserInfo userinfo = this.userInfoServiceImpl.findById(id);
		// 获取用户的出生日期和注册日期
		Date userInfoBirthday = userinfo.getUserInfoBirthday();
		Date userInfoRegistTime = userinfo.getUserInfoRegistTime();
		// 格式化用户的出生日期和注册日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String registTime = sdf.format(userInfoRegistTime);
		String birthday = sdf.format(userInfoBirthday);
		// 将用户信息以及格式化后的出生日期和注册日期存到request范围
		request.setAttribute("birthday", birthday);
		request.setAttribute("registTime", registTime);
		request.setAttribute("userinfo", userinfo);
		// 调用求时间差的方法，计算用户注册距离现在的时间差，并将时间差存到request范围
		long array[] = UserInfoController.differ(userinfo);
		request.setAttribute("day", array[0]);
		request.setAttribute("hour", array[1]);
		request.setAttribute("min", array[2]);
		request.setAttribute("second", array[3]);
		return "home";
	}

	/**
	 * 计算用户注册距离现在的时间差
	 * 
	 * @param u
	 *            UserInfo对象
	 * @return
	 */
	public static long[] differ(UserInfo u) {
		// 获取当前时间
		Date now = new Date();
		// 获取用户注册的时间
		Date date = u.getUserInfoRegistTime();
		// 计算时间差
		long l = now.getTime() - date.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		long[] array = new long[4];
		array[0] = day;
		array[1] = hour;
		array[2] = min;
		array[3] = s;
		return array;
	}

	/**
	 * 点击编辑，调用的方法
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String toEdit(@RequestParam(value = "id", required = false) Integer id, HttpServletRequest request) {
		UserInfo userinfo = this.userInfoServiceImpl.findById(id);
		request.setAttribute("userinfo", userinfo);
		Date userInfoBirthday = userinfo.getUserInfoBirthday();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String birthday = sdf.format(userInfoBirthday);
		// 将用户信息以及格式化后的出生日期和注册日期存到request范围
		request.setAttribute("birthday", birthday);
		// 调用求时间差的方法，计算用户注册距离现在的时间差，并将时间差存到request范围
		long array[] = UserInfoController.differ(userinfo);
		request.setAttribute("day", array[0]);
		request.setAttribute("hour", array[1]);
		request.setAttribute("min", array[2]);
		request.setAttribute("second", array[3]);
		request.setAttribute("birthday", birthday);
		request.setAttribute("action", "edit");
		return "accountSetting";
	}

	/**
	 * 点击更新信息，将编辑后的信息更新
	 * 
	 * @param id
	 * @param loginName
	 * @param birthday
	 * @param sex
	 * @param describe
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "loginName", required = false) String loginName,
			@RequestParam(value = "birthday", required = false) String birthday,
			@RequestParam(value = "sex", required = false) String sex,
			@RequestParam(value = "describe", required = false) String describe, HttpServletRequest request) {
		// 防止中文乱码
		try {
			sex = new String(sex.getBytes("iso-8859-1"), "utf-8");
			describe = new String(describe.getBytes("iso-8859-1"), "utf-8");
			loginName = new String(loginName.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserInfo u = this.userInfoServiceImpl.findById(id);
		// 将传入的字符串类型的日期转化为日期类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		u.getLoginUser().setLoginName(loginName);
		u.setUserInfoBirthday(date);
		u.setUserInfoSex(sex);
		u.setUserInfoDescribe(describe);
		this.userInfoServiceImpl.editUserInfo(u);
		return "redirect:home";
	}
}
