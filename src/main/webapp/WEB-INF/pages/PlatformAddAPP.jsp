<%@ page import="com.smartcity.models.ResponseJsonObject.UserResponse" %>
<%--
  Created by IntelliJ IDEA.
  User: ZJDX
  Date: 2016/10/11
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>云管理平台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->

    <script type="text/javascript" src="assets/js/jquery.js"></script>

    <link rel="stylesheet" href="assets/css/styleLogin.css">
    <link rel="stylesheet" href="assets/css/loader-style.css">
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="assets/js/tag/jquery.tagsinput.css">

    <style type="text/css">
        canvas {
            width: 100% !important;
            max-width: 1000px;
            height: auto !important;
        }
    </style>





    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <!-- Fav and touch icons -->
    <link rel="shortcut icon" href="assets/ico/minus.png">
</head>

<body>
${userResponse.getUuid()};

<!-- Preloader -->
<div id="preloader">
    <div id="status">&nbsp;</div>
</div>
<!-- TOP NAVBAR 顶部导航 -->
<nav role="navigation" class="navbar navbar-static-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button data-target="#bs-example-navbar-collapse-1" data-toggle="collapse" class="navbar-toggle" type="button">
                <span class="entypo-menu"></span>
            </button>
            <button class="navbar-toggle toggle-menu-mobile toggle-left" type="button">
                <span class="entypo-list-add"></span>
            </button>




            <div id="logo-mobile" class="visible-xs">
                <h1>云管理平台<span>v1.1</span></h1>
            </div>

        </div>


        <!-- Collect the nav links, forms, and other content for toggling -->
        <div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">

                <li>

                    <a data-toggle="dropdown" class="dropdown-toggle" href="#"><i style="font-size:19px;" class="icon-warning tooltitle"></i><div class="noft-red">5</div></a>
                    <ul style="margin: 12px 0 0 0;" role="menu" class="dropdown-menu dropdown-wrap">
                        <li>
                            <a href="#">
                                <span style="background:#DF2135" class="noft-icon maki-bus"></span><i>1号车故障</i>  <b>01B</b>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <span style="background:#AB6DB0" class="noft-icon maki-ferry"></span><i>2号车电池故障</i>  <b>9:00 AM</b>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <span style="background:#FFA200" class="noft-icon maki-aboveground-rail"></span><i>3号车雷达故障</i>  <b>09 Min</b>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <span style="background:#86C440" class="noft-icon maki-bus"></span><i>4号车···</i>  <b>08:30 AM</b>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <span style="background:#0DB8DF" class="noft-icon maki-bus"></span><i>5号车···</i>  <b>08:30 AM</b>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div>查看所有消息</div>
                        </li>
                    </ul>
                </li>
                <li><a href="#"><i data-toggle="tooltip" data-placement="bottom" title="Help" style="font-size:20px;" class="icon-help tooltitle"></i></a>
                </li>

            </ul>
            <div id="nt-title-container" class="navbar-left running-text visible-lg">
                <ul class="date-top">
                    <li class="entypo-calendar" style="margin-right:5px"></li>
                    <li id="Date"></li>


                </ul>
                <!--***clock***-->
                <ul id="digital-clock" class="digital">
                    <li class="entypo-clock" style="margin-right:5px"></li>
                    <li class="hour"></li>
                    <li>:</li>
                    <weli class="min"></weli>
                    <li>:</li>
                    <li class="sec"></li>
                    <li class="meridiem"></li>
                </ul>

            </div>
            <!--//***User & Setting***-->
            <ul style="margin-right:0;" class="nav navbar-nav navbar-right">
                <li>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <img alt="" class="admin-pic img-circle" src="http://api.randomuser.me/portraits/thumb/men/10.jpg">Hi, <b class="caret"></b>
                    </a>
                    <ul style="margin-top:14px;" role="menu" class="dropdown-setting dropdown-menu">
                        <li>
                            <a href="#">
                                <span class="entypo-user"></span>&#160;&#160;My Profile</a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="entypo-vcard"></span>&#160;&#160;Account Setting</a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="entypo-lifebuoy"></span>&#160;&#160;Help</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="http://themeforest.net/item/apricot-navigation-admin-dashboard-template/7664475?WT.ac=category_item&WT.z_author=themesmile">
                                <span class="entypo-basket"></span>&#160;&#160; Purchase</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="icon-gear"></span>&#160;&#160;设置</a>
                    <ul role="menu" class="dropdown-setting dropdown-menu">

                        <li class="theme-bg">
                            <div id="button-bg"></div>
                            <div id="button-bg2"></div>
                            <div id="button-bg3"></div>
                            <div id="button-bg5"></div>
                            <div id="button-bg6"></div>
                            <div id="button-bg7"></div>
                            <div id="button-bg8"></div>
                            <div id="button-bg9"></div>
                            <div id="button-bg10"></div>
                            <div id="button-bg11"></div>
                            <div id="button-bg12"></div>
                            <div id="button-bg13"></div>
                        </li>
                    </ul>
                </li>
                <li class="hidden-xs">
                    <a class="toggle-left" href="#">
                        <span style="font-size:20px;" class="entypo-list-add"></span>
                    </a>
                </li>
            </ul>

        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<!-- /END OF TOP NAVBAR -->

<!-- SIDE MENU -->
<div id="skin-select">
    <div id="logo">
        <h1 ><a href="index.html" style="color: white">云平台</a><span>v1.0</span></h1>
    </div>

    <a id="toggle">
        <span class="entypo-menu"></span>
    </a>
    <div class="dark">
        <form action="#">
                <span>
                    <input type="text" name="search" value="" class="search rounded id_search" placeholder="Search Menu..." autofocus="">
                </span>
        </form>
    </div>

    <div class="search-hover">
        <form id="demo-2">
            <input type="search" placeholder="Search Menu..." class="id_search">
        </form>
    </div>




    <div class="skin-part">
        <div id="tree-wrap">
            <div class="side-bar">
                <ul class="topnav menu-left-nest">
                    <li>
                        <a href="#" style="border-left:0px solid!important;" class="title-menu-left">

                            <span class="widget-menu"></span>
                            <i data-toggle="tooltip" class="entypo-cog pull-right config-wrap"></i>

                        </a>
                    </li>

                    <li>
                        <a class="tooltip-tip ajax-load" href="PlatformAddAPP.html" title="Blog App">
                            <i class="icon-document-edit"></i>
                            <span>添加应用</span>

                        </a>
                    </li>
                    <li>
                        <a class="tooltip-tip ajax-load" href="PlatformAddAPI.html" title="Blog App">
                            <i class="icon-document-edit"></i>
                            <span>添加数据接口</span>
                        </a>
                    </li>
                    <li>
                        <a class="tooltip-tip ajax-load" href="PlatformManageAPP.html" title="Media">
                            <i class="icon-media-loop"></i>
                            <span>查看应用信息</span>

                        </a>
                    </li>
                </ul>

                <ul class="topnav menu-left-nest">
                    <li>
                        <a href="#" style="border-left:0px solid!important;" class="title-menu-left">

                            <span class="design-kit"></span>
                            <i data-toggle="tooltip" class="entypo-cog pull-right config-wrap"></i>

                        </a>
                    </li>

                    <li>
                        <a class="tooltip-tip ajax-load" href="PlatformUserCenter.html" title="Dashboard">
                            <i class="icon-window"></i>
                            <span>用户接入数据</span>
                        </a>
                        <ul>
                            <li>
                                <a class="tooltip-tip2 ajax-load" href="PlatformUserCenter.html" title="Blog List"><i class="entypo-doc-text"></i><span>添加车辆</span></a>
                            </li>
                            <li>
                                <a class="tooltip-tip2 ajax-load" href="PlatformUserCenter.html" title="Blog Detail"><i class="entypo-newspaper"></i><span>维护车辆</span></a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a class="tooltip-tip ajax-load" href="PlatformUserCenter.html" title="Mail">
                            <i class="icon-mail"></i>
                            <span>接口流量数据</span>
                        </a>
                    </li>

                </ul>

                <ul id="menu-showhide" class="topnav menu-left-nest">
                    <li>
                        <a href="#" style="border-left:0px solid!important;" class="title-menu-left">

                            <span class="component"></span>
                            <i data-toggle="tooltip" class="entypo-cog pull-right config-wrap"></i>

                        </a>
                    </li>
                    <li>
                        <a class="tooltip-tip ajax-load" href="map.html" title="Map">
                            <i class="icon-location"></i>
                            <span>用户基本信息</span>

                        </a>
                    </li>
                </ul>


                <div class="side-dash">

                    <h3>
                        <span>Visitors</span>
                    </h3>
                    <div id="g1" style="height:180px" class="gauge"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- END OF SIDE MENU -->


<%--++++++++++++++++++++++页面内容+++++++++++++++++++++++++++--%>

<!--  PAPER WRAP -->
<div class="wrap-fluid">
    <div class="container-fluid paper-wrap bevel tlbr">
        <!-- CONTENT -->
        <!-- BREADCRUMB -->
        <ul id="breadcrumb">
            <li>
                <span class="entypo-home"></span>
            </li>
           <li><i class="fa fa-lg fa-angle-right"></i>
            </li>
            <li><a href="#" title="Sample page 1">ADD Application</a>
            </li>
            <li class="pull-right">
                <div class="input-group input-widget">
                    <input id="inputSearchPlace" style="border-radius:15px" type="text" placeholder="Search..." class="form-control">
                </div>
            </li>
        </ul>

        <!-- END OF BREADCRUMB -->
        <!--===================================================-->


        <!-- /Begining OF CONTENT -->




        <div class="content-wrap">
            <div class="row">
                <div class="col-sm-12">
                    <div class="nest" id="horizontalClose">
                        <div class="title-alt">
                            <h6>
                                创建应用</h6>
                            <div class="titleClose">
                                <a class="gone" href="#horizontalClose">
                                    <span class="entypo-cancel"></span>
                                </a>
                            </div>
                            <div class="titleToggle">
                                <a class="nav-toggle-alt" href="#horizontal">
                                    <span class="entypo-up-open"></span>
                                </a>
                            </div>

                        </div>

                        <div class="body-nest" id="horizontal">

                            <div class="form_center">
                               <form role="form" class="form-horizontal" >
                                    <div class="form-group">
                                        <label class="col-lg-2 col-sm-2 control-label" for="inputAPPName">应用名：</label>
                                        <div class="col-lg-10">
                                            <input type="text" placeholder="App Name" id="inputAPPName" class="form-control">
                                            <p class="help-block">设置唯一APPName。</p>
                                        </div>
                                    </div>
                                    <div class="form-group" id="getAPPIDDiv" style="display: none">
                                        <label class="col-lg-2 col-sm-2 control-label" for="getAPPID">APPID</label>
                                        <div class="col-lg-10">
                                            <input type="text" id="getAPPID" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-10">
                                            <button class="btn btn-danger"  type="button" onclick="createAPP()" >新建应用</button>
                                        </div>
                                    </div>
                               </form>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>




        <div class="content-wrap">
            <div class="row">
                <div class="col-sm-12">
                    <div class="nest" id="elementClose">
                        <div class="title-alt">
                            <h6>
                                配置应用</h6>
                            <div class="titleClose">
                                <a class="gone" href="#elementClose">
                                    <span class="entypo-cancel"></span>
                                </a>
                            </div>
                            <div class="titleToggle">
                                <a class="nav-toggle-alt" href="#element">
                                    <span class="entypo-up-open"></span>
                                </a>
                            </div>

                        </div>

                        <div class="body-nest" id="element">

                            <div class="panel-body">
                                <form method="get" id="completeAPP" name="appForm"  class="form-horizontal bucket-form">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">应用名：</label>
                                        <div class="col-sm-6">
                                            <input type="text" disabled=""  id="APPName" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">应用APPID：</label>
                                        <div class="col-sm-6">
                                            <input type="text" disabled=""  id="APPID" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">首页URL:</label>
                                        <div class="col-sm-6">
                                            <input type="text" id="URL" class="form-control">
                                        </div>
                                    </div>
                                     <%--//上传log   --%>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">上传Logo:</label>
                                        <div class="col-sm-6">
                                            <input type="file" name="file" id="exampleInputFile">
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">分类:</label>
                                        <div class="col-sm-6">
                                            <input type="text" id="category" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">应用标签:</label>
                                        <div class="col-sm-6 well">
                                            <input id="tags_1" type="text" class="form-control tags" value="停车,物流">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">应用描述:</label>
                                        <div class="col-sm-6">
                                            <textarea style="width: 100%; height: 300px" id="textarea" placeholder="应用描述 ..."></textarea>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-lg-10">
                                            <button class="btn btn-default" type="reset" value="重置表单">重置表单</button>
                                            <button class="btn btn-default" type="button" onclick="completeAPPData()" value="提交表单">提交表单</button>

                                        </div>
                                    </div>
                                    </form>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>










        <!-- /END OF CONTENT -->
        <!--===================================================-->

        <!-- FOOTER -->
        <div class="footer-space"></div>
        <div id="footer">
            <div class="devider-footer-left"></div>
            <div class="time">
                <p id="spanDate">
                <p id="clock">
            </div>
            <div class="copyright">SCC
                <span class="entypo-heart"></span>Collect from <a href="http://www.SCC.com/" title="SmartCar" target="_blank">SmartCar</a> All Rights Reserved</div>
            <div class="devider-footer"></div>


        </div>
        <!-- / END OF FOOTER -->


    </div>
</div>
</div>
<!--  END OF PAPER WRAP -->
<%--++++++++++++++++++++++以上为页面内容+++++++++++++++++++++++++++--%>



<!-- MAIN EFFECT -->
<script type="text/javascript" src="assets/js/preloader.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.js"></script>
<script type="text/javascript" src="assets/js/app.js"></script>
<script type="text/javascript" src="assets/js/load.js"></script>
<script type="text/javascript" src="assets/js/main.js"></script>
<script type="text/javascript" src="assets/AddAPP.js"></script>
<script type="text/javascript" src="assets/js/tag/jquery.tagsinput.js"></script>
<script src="http://malsup.github.io/jquery.form.js"></script>
</body>

</html>
