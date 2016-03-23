<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<base href="<%=basePath%>">
<html>

<head>

    <meta charset="utf-8"/>
    <title>Color Admin | Dashboard v2</title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"
          name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <!-- ================== BEGIN BASE CSS STYLE ================== -->
    <link href="http://fonts.useso.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
    <link href="assets/plugins/jquery-ui/themes/base/minified/jquery-ui.min.css" rel="stylesheet"/>
    <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="assets/css/animate.min.css" rel="stylesheet"/>
    <link href="assets/css/style.min.css" rel="stylesheet"/>
    <link href="assets/css/style-responsive.min.css" rel="stylesheet"/>
    <link href="assets/css/theme/default.css" rel="stylesheet" id="theme"/>
    <!-- ================== END BASE CSS STYLE ================== -->
    <!-- ================== BEGIN PAGE LEVEL CSS STYLE ================== -->
    <link href="assets/plugins/jquery-jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet"/>
    <link href="assets/plugins/bootstrap-calendar/css/bootstrap_calendar.css" rel="stylesheet"/>
    <link href="assets/plugins/gritter/css/jquery.gritter.css" rel="stylesheet"/>
    <link href="assets/plugins/morris/morris.css" rel="stylesheet"/>
    <!-- ================== END PAGE LEVEL CSS STYLE ================== -->
    <!-- ================== BEGIN BASE JS ================== -->

    <script src="assets/plugins/pace/pace.min.js"></script>

    <!-- ================== END BASE JS ================== -->
</head>

<body>

<!-- begin #page-loader -->
<div id="page-loader" class="fade in">
    <span class="spinner"></span>
</div>
<!-- end #page-loader -->


<div id="page-container" class="fade page-sidebar-fixed page-header-fixed">


    <div id="header" class="header navbar navbar-default navbar-fixed-top"> <!-- begin #header -->

        <div class="container-fluid"><!-- begin container-fluid -->
            <!-- begin mobile sidebar expand / collapse button -->
            <div class="navbar-header">
                <a href="后期依据项目情况填充url地址" class="navbar-brand"><span class="navbar-logo"></span>地利网络农业研发中心</a>
                <button type="button" class="navbar-toggle" data-click="sidebar-toggled">
                    <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar">
                        </span>
                </button>
            </div>
            <!-- end mobile sidebar expand / collapse button -->
            <!-- begin header navigation right -->
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <form class="navbar-form full-width">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Enter keyword"/>
                            <button type="submit" class="btn btn-search">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </form>
                </li>
                <li class="dropdown"><a href="javascript:" data-toggle="dropdown" class="dropdown-toggle f-s-14">
                    <i class="fa fa-bell-o"></i><span class="label">5</span> </a>
                    <ul class="dropdown-menu media-list pull-right animated fadeInDown">
                        <li class="dropdown-header">Notifications (5)</li>
                        <li class="media"><a href="javascript:">
                            <div class="media-left">
                                <i class="fa fa-bug media-object bg-red"></i>
                            </div>
                            <div class="media-body">
                                <h6 class="media-heading">
                                    公共服务期警告错误</h6>

                                <div class="text-muted f-s-11">
                                    3 分钟以前
                                </div>
                            </div>
                        </a></li>
                        <li class="media"><a href="javascript:">
                            <div class="media-left">
                                <img src="assets/img/user-1.jpg" class="media-object" alt=""/></div>
                            <div class="media-body">
                                <h6 class="media-heading">
                                    刘英杰</h6>

                                <p>
                                    地利集团网络农业研发中心公司办公平台开始研发.</p>

                                <div class="text-muted f-s-11">
                                    25 分钟以前
                                </div>
                            </div>
                        </a></li>
                        <li class="media"><a href="javascript:">
                            <div class="media-left">
                                <img src="assets/img/user-2.jpg" class="media-object" alt=""/></div>
                            <div class="media-body">
                                <h6 class="media-heading">
                                    李松</h6>

                                <p>
                                    李松加入 地利集团网络农业研发中心公司办公平台研发.</p>

                                <div class="text-muted f-s-11">
                                    35 minutes ago
                                </div>
                            </div>
                        </a></li>
                        <li class="media"><a href="javascript:">
                            <div class="media-left">
                                <i class="fa fa-plus media-object bg-green"></i>
                            </div>
                            <div class="media-body">
                                <h6 class="media-heading">
                                    New User Registered</h6>

                                <div class="text-muted f-s-11">
                                    1 hour ago
                                </div>
                            </div>
                        </a></li>
                        <li class="media"><a href="javascript:">
                            <div class="media-left">
                                <i class="fa fa-envelope media-object bg-blue"></i>
                            </div>
                            <div class="media-body">
                                <h6 class="media-heading">
                                    New Email From John</h6>

                                <div class="text-muted f-s-11">
                                    2 hour ago
                                </div>
                            </div>
                        </a></li>
                        <li class="dropdown-footer text-center"><a href="javascript:">View more</a></li>

                    </ul>
                </li>

                <li class="dropdown navbar-user"><a href="javascript:" class="dropdown-toggle" data-toggle="dropdown">
                    <img src="assets/img/user-13.jpg" alt=""/>
                    <span class="hidden-xs">Adam Schwartz</span> <b class="caret"></b></a>
                    <ul class="dropdown-menu animated fadeInLeft">
                        <li class="arrow"></li>
                        <li><a href="javascript:">Edit Profile</a></li>
                        <li><a href="javascript:"><span class="badge badge-danger pull-right">5</span> Inbox</a></li>
                        <li><a href="javascript:">Calendar</a></li>
                        <li><a href="javascript:">Setting</a></li>
                        <li class="divider"></li>
                        <li><a href="javascript:">Log Out</a></li>
                    </ul>
                </li>


            </ul>


        </div>
        <!-- end container-fluid -->


    </div>
    <!-- end #header -->


    <!-- begin #sidebar -->
    <div id="sidebar" class="sidebar">
        <!-- begin sidebar scrollbar -->
        <div data-scrollbar="true" data-height="100%">
            <!-- begin sidebar user -->
            <ul class="nav">
                <li class="nav-profile">
                    <div class="image">
                        <a href="javascript:">
                            <img src="assets/img/user-13.jpg" alt=""/></a>
                    </div>
                    <div class="info">
                        刘英杰
                        <small>前端内容开发</small>
                    </div>
                </li>
            </ul>
            <!-- end sidebar user -->
            <!-- begin sidebar nav -->
            <ul class="nav">
                <li class="nav-header">导航栏</li>
                <li class="has-sub active"><a href="javascript:"><b class="caret pull-right"></b><i
                        class="fa fa-laptop"></i><span>工作面板</span> </a>
                    <ul class="sub-menu">
                        <%--看到这里路径变量无效显示的路径不对，明天继续调试--%>
                        <li><a href="<%=path%>/service/users">查询用户信息v1</a></li>
                        <li class="active"><a href="<%=path%>/service/input_users">输入用户信息</a></li>
                    </ul>
                </li>
                <!-- begin sidebar minify button -->
                <li><a href="javascript:" class="sidebar-minify-btn" data-click="sidebar-minify"><i
                        class="fa fa-angle-double-left"></i></a></li>
                <!-- end sidebar minify button -->


            </ul>
            <!-- end sidebar nav -->

        </div>
        <!-- end sidebar scrollbar -->

    </div>
    <div class="sidebar-bg">
    </div>
    <!-- end #sidebar -->

    <%--&lt;%&ndash;这里是在页面背景图上面再加一个浮层，颜色为灰色，这里引用的登录界面当中定义好的浮层CSS&ndash;%&gt;--%>
    <div class="login-cover-bg"></div>
    <%--这里引用的登录界面当中定义好的浮层CSS结束--%>

    <!-- begin #content -->
    <div id="content" class="content Center-container">


        <!-- begin breadcrumb -->
        <ol class="breadcrumb pull-right">
            <li><a href="javascript:">Home</a></li>
            <li><a href="javascript:">Dashboard</a></li>
            <li class="active">Dashboard v2</li>
        </ol>


        <%--写到这里开始重新定义显示雇员信息的表记住这里，需要在编辑器里面打开table_basic.html文件进行查看--%>
        <%--<div class="row">--%>
        <div class="col-md-6 Absolute-Center">

            <form class="form-horizontal" action="<%=path%>/service/add_users" method="post">
                <div class="form-group has-success has-feedback">
                    <label class="col-md-3 control-label">请输入姓名:</label>

                    <div class="col-md-3">
                        <input type="text" class="form-control" name="name"/>
                        <span class="fa fa-check form-control-feedback"></span>
                    </div>
                </div>
                <div class="form-group has-success has-feedback">
                    <label class="col-md-3 control-label">请输入职位:</label>

                    <div class="col-md-3">
                        <input type="text" class="form-control" name="position"/>
                        <span class="fa fa-check form-control-feedback"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label"></label>

                    <div class="col-md-9">
                        <button type="submit" class="btn btn-sm btn-success">Submit Button</button>
                    </div>
                </div>
            </form>


        </div>


        <%-- </div>--%>


    </div>


</div>


<!-- ================== BEGIN BASE JS ================== -->
<script src="assets/plugins/jquery/jquery-1.9.1.min.js"></script>
<script src="assets/plugins/jquery/jquery-migrate-1.1.0.min.js"></script>
<script src="assets/plugins/jquery-ui/ui/minified/jquery-ui.min.js"></script>
<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
<script src="assets/crossbrowserjs/html5shiv.js"></script>
<script src="assets/crossbrowserjs/respond.min.js"></script>
<script src="assets/crossbrowserjs/excanvas.min.js"></script>
<![endif]-->
<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="assets/plugins/jquery-cookie/jquery.cookie.js"></script>
<!-- ================== END BASE JS ================== -->

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script src="assets/js/apps.min.js"></script>
<!-- ================== END PAGE LEVEL JS ================== -->

<script>
    $(document).ready(function () {
        App.init();
    });
</script>
</body>
</html>