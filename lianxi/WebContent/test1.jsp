<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>倒计时</title>
<script type="text/javascript">
function GetBytes(str){
    var len = str.length;
    console.log("len="+len);
    var bytes = len;
    for(var i=0; i<len; i++){
        if (str.charCodeAt(i) > 255) bytes++;
    }
    console.log("bytes="+bytes);
}
var z=5;
function f1(){
	
	var flag = true;
		var flag2 = true;
		if (flag == true) {
			var i = 0;

			j = 1;

			if (flag2 == true) {
				for (var m = 0; m < 10; m++) {

				}
			}
		}
		console.log("i=" + i);//0
		console.log("j=" + j);//1
		console.log("m=" + m);//10
		z=y=100;
		console.log("z="+z+"   y="+y);
	}
</script>
</head>
<body>
<div id="d1"></div>
<script type="text/javascript">
   function counter() {
      var date = new Date();
     // console.log("date1="+date);
      var year = date.getFullYear();
      var date2 = new Date(year, 12, 31, 23, 59, 59);
    //  console.log("date2="+date2);
    //  console.log("date2-date="+(date2-date));
      var time = (date2 - date)/1000;//得到相差多少秒
      var day =Math.floor(time/(24*60*60))
      var hour = Math.floor(time%(24*60*60)/(60*60))
      var minute = Math.floor(time%(24*60*60)%(60*60)/60);
      var second = Math.floor(time%(24*60*60)%(60*60)%60);
      var str = year + "年还剩"+day+"天"+hour+"时"+minute+"分"+second+"秒";
      document.getElementById("d1").innerHTML = str;
   }
   window.setInterval("counter()", 1000);
</script>
<button onclick="GetBytes('张三三')">GetBytes("张三");</button>
<button onclick="f1()">f1</button>
</body>
</html>