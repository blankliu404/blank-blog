<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Beyond Admin - Responsive Admin Dashboard Template build with Twitter Bootstrap 3
Version: 1.0.0
Purchase: http://wrapbootstrap.com
-->

<html xmlns="http://www.w3.org/1999/xhtml">
<!--Head-->
<head>
    <meta charset="utf-8" />
    <title>Error</title>

    <meta name="description" content="Error" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" href="/blog/index/favicon.ico" type="image/x-icon">
    <meta http-equiv="refresh" content="3;url=${url}">

    <!--Basic Styles-->
    <link href="/blog/errorpage/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link id="bootstrap-rtl-link" href="" rel="stylesheet" />
    <link href="/blog/errorpage/assets/css/font-awesome.min.css" rel="stylesheet" />
    <link href="/blog/errorpage/assets/css/weather-icons.min.css" rel="stylesheet" />

    <!--Fonts-->
    <link href="" rel="stylesheet" type="text/css">

    <!--Beyond styles-->
    <link href="/blog/errorpage/assets/css/beyond.min.css" rel="stylesheet" />
    <link href="/blog/errorpage/assets/css/demo.min.css" rel="stylesheet" />
    <link href="/blog/errorpage/assets/css/animate.min.css" rel="stylesheet" />
    <link id="skin-link" href="" rel="stylesheet" type="text/css" />

    <!--Skin Script: Place this script in head to load scripts for skins and rtl support-->
    <script src="/blog/errorpage/assets/js/skins.min.js"></script>
</head>
<!--Head Ends-->
<!--Body-->
<body class="body-404" style="background-color: #FF0000">
    <div class="error-header"> </div>
    <div class="container ">
        <section class="error-container text-center">
            <h1  style="color: #FF0000">Error</h1>
            <div class="error-divider">
                <h2>${message}</h2>
                <p class="description">3秒后跳转...</p>
            </div>
            <a href="/blog/index/index" class="return-btn"><i class="fa fa-home"></i>Home</a>
        </section>
    </div>
    <!--Basic Scripts-->
    <script src="/blog/errorpage/assets/js/jquery-2.0.3.min.js"></script>
    <script src="/blog/errorpage/assets/js/bootstrap.min.js"></script>

    <!--Beyond Scripts-->
    <script src="/blog/errorpage/assets/js/beyond.min.js"></script>

    <!--Google Analytics::Demo Only-->
    <script>
        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r; i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date(); a = s.createElement(o),
            m = s.getElementsByTagName(o)[0]; a.async = 1; a.src = g; m.parentNode.insertBefore(a, m)
        })(window, document, 'script', 'http://www.google-analytics.com/analytics.js', 'ga');

        ga('create', 'UA-52103994-1', 'auto');
        ga('send', 'pageview');

    </script>
</body>
<!--Body Ends-->
</html>
