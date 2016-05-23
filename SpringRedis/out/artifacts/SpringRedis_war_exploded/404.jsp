<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 3/24/16
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>

    <title>页面不存在</title>
  </head>
  <body>
   <center><h1>您访问的页面不存在,<span id="div1"></span>秒后自动跳转到</h1></center>

<%--   <form id="form1" runat="server">
     <div id='div1'>
     </div>
   </form>--%>




  </body>
</html>
<script type="text/javascript">
  //设定倒数秒数
  var t = 5;
  //显示倒数秒数
  function showTime(){
    t -= 1;
    document.getElementById('div1').innerHTML= t;
    if(t==0){
      location.href='https://redis.huqiliang.com/redis/service/logging';
    }
    //每秒执行一次,showTime()
    setTimeout("showTime()",1000);
  }
  //执行showTime()
  showTime();
</script>