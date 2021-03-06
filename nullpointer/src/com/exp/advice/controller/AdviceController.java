package com.exp.advice.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exp.advice.service.AdviceServiceImpl;
import com.exp.entity.Advice;
import com.exp.entity.Question;
import com.exp.question.service.QuestionServiceImpl;
import com.framework.EncodingTool;
@Controller
public class AdviceController {

	@Resource
	private AdviceServiceImpl adviceServiceImpl;
	@Resource
	private QuestionServiceImpl questionServiceImpl;
	
	/**
	 * 功能：
	 * 获取建议反馈表单右方的推荐的session
	 * 通过adviceReminder判断是否提交表单
	 * @param request
	 * @param session
	 * @return
	 * 跳转至反馈建议页面
	 * @author fengtingxin
	 */
	@RequestMapping(value = "advice", method = RequestMethod.GET)
	public String toAdvice(HttpServletRequest request,HttpSession session){
		request.setAttribute("adviceReminder", null);
		
		try {
			List<Question> questionList=this.questionServiceImpl.findQuestionRecommend().subList(0, 6);
			request.setAttribute("questionList", questionList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.setAttribute("questionList", session.getAttribute("questionHonorList")); 
			//questionHonorList属性来自于UserInfoController/index方法
		}
		return "contact";
	}
	
	/**
	 * 功能：
	 * 建议表单提交处理方法
	 * 通过adviceReminder传递参数，显示提示，给用户友好体验
	 * @param adviceUserName
	 * @param adviceUserEmail
	 * @param adviceTheme
	 * @param adviceContent
	 * @param request
	 * @return
	 * 跳转回提交页面
	 * @author fengtingxin
	 */
	@RequestMapping(value = "advice", method = RequestMethod.POST)
	public String adviceSubmit(@RequestParam(name="name")String adviceUserName,@RequestParam(name="email")String adviceUserEmail,@RequestParam(name="theme")String adviceTheme,@RequestParam(name="advice")String adviceContent,HttpServletRequest request){
		//code
		try {
		adviceUserName=EncodingTool.encodeStr(adviceUserName);
		adviceContent=EncodingTool.encodeStr(adviceContent);
		adviceTheme=EncodingTool.encodeStr(adviceTheme);
		adviceUserEmail=EncodingTool.encodeStr(adviceUserEmail);
		
		Advice advice =new Advice();
		advice.setAdviceContent(adviceContent);
		advice.setAdviceTheme(adviceTheme);
		advice.setAdviceTime(new Date());
		advice.setAdviceUserEmail(adviceUserEmail);
		advice.setAdviceUserName(adviceUserName);
		//保存
			this.adviceServiceImpl.saveAdvice(advice);
			request.setAttribute("adviceReminder", "ok");
			request.setAttribute("remindMsg", "感谢您对nullpointer的支持！");
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("remindMsg", "服务器开小差，您辛苦了！");
		}
		return "contact";
	}
}
