/*
 * 
 * @author 刘飞 陈新
 * @createTime 2019-07-09 15:10
 * */
$(document).ready(function() {
     //导航栏鼠标移入移出字体变色
    $("a.nav-link").mouseover(function() {
        $(this).removeClass('text-white')
        $(this).addClass('text-primary')
    })

    $("a.nav-link").mouseleave(function() {
        $(this).removeClass('text-primary')
        $(this).addClass('text-white')
    })
})