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
<h3 style="text-align: center">과속 평균 속도 (제한속도 80km/h)</h3>
<div id = "container">
	<p id = "loading">빅데이터 분석중 ...</p>
	<canvas id="myChart"></canvas>
</div>

<script>

function display(datas){
	var ctx = document.getElementById("myChart").getContext('2d');
	
	var myChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ["과속", "정속"],
	        datasets: [{   
	        	label: '평균속도(km/h)',
	            data: datas,
	            backgroundColor: [                
	                'rgba(255, 206, 86, 0.2)',
	                'rgba(75, 192, 192, 0.2)'                
	            ],
	            borderColor: [                
	                'rgba(255, 206, 86, 1)',
	                'rgba(75, 192, 192, 1)'                
	            ],
	            borderWidth: 1
	        }]
	    },
	    options: {
	        maintainAspectRatio: true,
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero:true
	                }
	            }]
	        }
	    }
	});
}

function getData(){
	$.ajax({
		url:'getdata3.mc',
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