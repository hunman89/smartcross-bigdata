<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#container{
	width: 800px;
	height: 500px;
	border: 2px solid black;
	margin-left: auto; 
	margin-right: auto;
}
</style>
<h3 style="text-align: center">방향별 평균 속도</h3>
<div id = "container">
	<p id = "loading">빅데이터 분석중 ...</p>
	<canvas id="myChart"></canvas>
</div>

<script>
function display(datas){
	var ctx = document.getElementById("myChart").getContext('2d');
	
	var myChart = new Chart(ctx, {
	    type: 'radar',
	    data: {
	        labels: ["북", "동", "남", "서"],
	        datasets: [{
	            label: '평균속도(km/h)',
	            data: datas,
	            backgroundColor: [                
	                'rgba(54, 162, 235, 0.2)',	                
	                
	            ],
	            borderColor: [ 
	                'rgba(255, 206, 86, 1)',	                              
	            ],
	            borderWidth: 1
	        }]
	    },
	    options: {
	        maintainAspectRatio: false, // default value. false일 경우 포함된 div의 크기에 맞춰서 그려짐.
	        scale: {
	            ticks: {
	            	beginAtZero:true
	            }
	        }
	    }
	});
}

function getData(){
	$.ajax({
		url:'getdata2.mc',
		success:function(datas){
			display(datas);
		},
		error:function(){}
	});
}

$(document).ready(function(){	
	getData();
})
.ajaxStart(function(){
	$('#loading').show();
})
.ajaxStop(function(){
	$('#loading').hide();
});
</script>