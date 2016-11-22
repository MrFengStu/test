<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en-US"> <![endif]-->
<!--[if IE 7]>    <html class="lt-ie9 lt-ie8" lang="en-US"> <![endif]-->
<!--[if IE 8]>    <html class="lt-ie9" lang="en-US"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en-US">
<!--<![endif]-->
<head>
<!-- META TAGS -->
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>nullpointer</title>
<link rel="shortcut icon" href="${ctx}/images/favicon.png" />
<!-- Style Sheet-->
<link href="${ctx}/docs/css/zui.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${ctx}/css/zui.lite.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/zui-theme.css">
<link href="${ctx}/docs/css/doc.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/main5152.css">
<style id="themeStyle"></style>
<link rel="stylesheet" type="text/css" href="${ctx}/responsive5152.css">
</head>

<body>
	<nav class="navbar navbar-inverse" role="navigation"
		style="margin-bottom: 0px;">
	<div class="center-block">
		<div class="container">
			<!-- 导航头部 -->
			<div class="navbar-header">
				<!-- 移动设备上的导航切换按钮 -->
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse-example">
					<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<!-- 品牌名称或logo -->
				<img src="images/logo.png" alt="nullpointer" width="200"
					style="margin-top: 3px;">
			</div>
			<!-- 导航项目 -->
			<div class="collapse navbar-collapse navbar-collapse-example">

				<ul class="nav navbar-nav navbar-right">
					<li class="current-menu-item"><a href="${ctx}/index.jsp">主页</a></li>
					<li><a href="${ctx}/bug-list-admin.jsp">BUGS</a></li>
					<li><a href="${ctx}/q_a_list.jsp">技术问答</a></li>
					<li><a href="${ctx}/contact.jsp">帮助</a></li>
					<li><a href="${ctx}/login.jsp">登陆/注册</a></li>
					<!-- 导航中的下拉菜单 -->
					<li class="dropdown"><a href="your/nice/url"
						class="dropdown-toggle" data-toggle="dropdown"><img
							src="${ctx}/images/touxiang.jpg" width="20px" height="20px"
							class="img-circle" /> <b class="caret"></b></a>
						<ul class="dropdown-menu" role="menu" style="text-align: center;">
							<li><a href="${ctx}/home.jsp">我的主页</a></li>
							<li><a href="${ctx}/home-question.jsp">信息管理</a></li>
							<li><a href="${ctx}/page.jsp">账号设置</a></li>
							<li><a href="${ctx}/contact.jsp">建议反馈</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>

	</nav>
	<!--导航栏完成-->
	<!--搜索框-->
	<div class="search-area-wrapper">
		<div class="search-area container">
			<h3 class="search-header">今天你遇到什么技术难点了吗？</h3>
			<p class="search-tag-line">请在下方搜索您所遇到的问题吧！</p>
			<form id="search-form" class="search-form clearfix" method="get"
				action="#" autocomplete="off" novalidate="novalidate">
				<input class="search-term required" type="text" id="s" name="s"
					placeholder="在这里搜索问题/BUG" title="* Please enter a search term!"
					style="height: 43px;" />
				<button type="button" class="btn btn-primary btn-lg"">BUG搜索</button>
				<button type="button" class="btn btn-primary btn-lg"">问题搜索</button>
				<div id="search-error-container"></div>
			</form>
		</div>
	</div>
	<!--搜索框完成-->
	<!--文章开始-->
	<div class="container" style="padding-top: 20px; padding-bottom: 25px;">
		<div style="border: 1px solid #ddd; padding: 20px;">
			<article class="article"> <header>
			<h1 class="text-center">ClassNotFoundException</h1>
			<dl class="dl-inline">
				<dt>来源：</dt>
				<dd>维基百科</dd>
				<dt>最后修订：</dt>
				<dd>2016年8月12日 (星期五) 12:53</dd>
				<dt></dt>
				<dd class="pull-right">
					<span class="label label-success">HTML</span> <span
						class="label label-warning">网页设计</span> <span
						class="label label-info">W3C</span> <span
						class="label label-danger"><i class="icon-eye-open"></i>
						235</span>
				</dd>
			</dl>
			<section class="abstract">
			<p>
				<strong>摘要：</strong>HTML5是HTML最新的修订版本，2014年10月由万维网联盟（W3C）完成标准制定。目标是替换1999年所制定的HTML
				4.01和XHTML
				1.0标准，以期能在互联网应用迅速发展的时候，使网络标准达到匹配当代的网络需求。广义论及HTML5时，实际指的是包括HTML、CSS和JavaScript在内的一套技术组合。
			</p>
			</section> </header> <section class="content">
			<p>
				HTML5是HTML最新的修订版本，2014年10月由<a
					href="https://zh.wikipedia.org/wiki/%E4%B8%87%E7%BB%B4%E7%BD%91%E8%81%94%E7%9B%9F"
					target="_blank">万维网联盟</a>（W3C）完成标准制定。目标是替换1999年所制定的HTML 4.01和XHTML
				1.0标准，以期能在互联网应用迅速发展的时候，使网络标准达到匹配当代的网络需求。广义论及HTML5时，实际指的是包括HTML、CSS和JavaScript在内的一套技术组合。它希望能够减少网页浏览器对于需要插件的丰富性网络应用服务（Plug-in-Based
				Rich Internet Application，RIA），例如：AdobeFlash、Microsoft
				Silverlight与Oracle JavaFX的需求，并且提供更多能有效加强网络应用的标准集。
			</p>
			<h4>核心HTML标准</h4>
			<p>HTML5.0，HTML5.1和HTML5.2的合并时间表：</p>
			<h2>新应用程序接口（API）</h2>
			<p>除了原先的DOM接口，HTML5增加了更多样化的应用程序接口（API）：</p>
			<ul>
				<li>即时二维绘图
					<ul>
						<li>Canvas API：有关动态产出与渲染图形、图表、图像和动画的API</li>
					</ul>
				</li>
				<li>定时媒体播放</li>
				<li>离线存储数据库（离线网络应用程序）</li>
				<li>编辑</li>
				<li>拖放</li>
			</ul>
			</section> <footer>
			                                         <!--评论内容开始-->
                             <div class="comments">
                                  <header>
                                    
                                    <h3>所有评论</h3>
                                  </header>
                                  <section class="comments-list">
                                    <div class="comment">
                                      <a href="###" class="avatar">
                                        <i class="icon-camera-retro icon-2x"></i>
                                      </a>
                                      <div class="content">
                                        <div class="pull-right text-muted">3 个小时前</div>
                                        <div><a href="###"><strong>张士超</strong></a></div>
                                        <div class="text">今天玩的真开心！~~~~~~</div>
                                        <div class="actions">
                                          <a href="##">回复</a>
                                        </div>
                                      </div>
                                      <div class="comments-list">
                                        <div class="comment">
                                          <a href="###" class="avatar">
                                            <i class="icon-user icon-2x"></i>
                                          </a>
                                          <div class="content">
                                            <div class="pull-right text-muted">2 个小时前</div>
                                            <div><a href="###"><strong>Catouse</strong></a> <span class="text-muted">回复</span> <a href="###">汤汤</a></div>
                                            <div class="text">你到底把我家钥匙放哪里了...</div>
                                            <div class="actions">
                                              <a href="##">编辑</a>
                                              <a href="##">删除</a>
                                            </div>
                                          </div>
                                        </div>
                                        <div class="comment">
                                          <a href="###" class="avatar">
                                            <i class="icon-heart-empty icon-2x"></i>
                                          </a>
                                          <div class="content">
                                            <div class="pull-right text-muted">30 分钟前</div>
                                            <div><a href="###"><strong>华师大第一美女</strong></a> <span class="text-muted">回复</span> <a href="###">张士超</a></div>
                                            <div class="text">很开心~~~</div>
                                          </div>
                                        </div>
                                      </div>
                                    </div>
                                    <div class="comment">
                                      <a href="###" class="avatar">
                                        <i class="icon-camera-retro icon-2x"></i>
                                      </a>
                                      <div class="content">
                                        <div class="pull-right text-muted">3 个小时前</div>
                                        <div><a href="###"><strong>隔壁老王</strong></a></div>
                                        <div class="text">今天看到了隔壁家的孩子 和我长得差不多啊</div>
                                        <div class="actions">
                                          <a href="##">回复</a>
                                        </div>
                                      </div>
                                    </div>
                                  </section>
                                  <footer>
                                    <div class="reply-form" id="commentReplyForm2">
                                      <a href="###" class="avatar"><i class="icon-user icon-2x"></i></a>
                                      <form class="form">
                                        <div class="form-group">
                                          <textarea id="content" name="content" class="form-control kindeditor"></textarea>
                                        </div>
                                        <div class="form-group comment-user">
                                         
                                            <div class="col-md-2 pull-right"><button type="submit" class="btn btn-block btn-primary">提交评论</button></div>
                                          </div>
                                        </div>
                                      </form>
                                    </div>
                                </footer>
                                </div>
                                <!--评论内容结束-->
			</footer> </article>
		</div>
	</div>
	<!--文章完成-->



	<!-- Footer Bottom -->
	<div id="footer-bottom-wrapper">
		<div id="footer-bottom" class="container">
			<div class="row">
				<div class="col-md-6 column">
					<p class="copyright">
						Copyright © 2013. All Rights Reserved by KnowledgeBase.Collect
						from <a href="#" title="旋风小组" target="_blank">EXP小组</a>
					</p>
				</div>
				<div class="col-md-6 column">
					<!-- Social Navigation -->
					<ul class="social-nav clearfix">
						<li class="linkedin"><a target="_blank" href="#"></a></li>
						<li class="stumble"><a target="_blank" href="#"></a></li>
						<li class="google"><a target="_blank" href="#"></a></li>
						<li class="deviantart"><a target="_blank" href="#"></a></li>
						<li class="flickr"><a target="_blank" href="#"></a></li>
						<li class="skype"><a target="_blank" href="skype:#?call"></a></li>
						<li class="rss"><a target="_blank" href="#"></a></li>
						<li class="twitter"><a target="_blank" href="#"></a></li>
						<li class="facebook"><a target="_blank" href="#"></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

</body>
<!-- script -->
<script src="${ctx}/assets/jquery.js"></script>
<script src="${ctx}/assets/clipboard/clipboard.min.js"></script>
<script src="${ctx}/assets/less/less.min.js"></script>

<!-- ZUI Javascript组件 -->
<script src="${ctx}/docs/js/zui.min.js"></script>
<script src="${ctx}/docs/js/doc.min.js"></script>
<!-- 增强文档插件 -->
<script async src="${ctx}/assets/prettify/prettify.js"></script>
<script src="${ctx}/assets/marked/marked.min.js"></script>
</html>