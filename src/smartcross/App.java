package smartcross;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import com.biz.CarStatus;

public class App {

	String url;

	public App() {
		
	}

	public void getData() { // 센서 데이터를 가상으로 생성
		for (int i = 1; i < 60; i++) {
			Random r = new Random();
			int id = i;
			String direction = null;
			int d = r.nextInt(4);
			if (d == 0) {
				direction = "W";
			} if (d == 1) {
				direction = "E";
			} if (d == 2) {
				direction = "S";
			} if (d == 3) {
				direction = "N";
			}
			double speed = r.nextInt(60)+40;
			String speeding = null;
			if ( speed > 80 ) {
				speeding = "O";
			} else {
				speeding = "x";
			}
			 
			
			CarStatus cstatus = new CarStatus(id, direction, speed, speeding);			
			try {
				sendData(cstatus);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void sendData(CarStatus cs) throws Exception { // 센서 데이터를 웹 애플리케이션에 전송
		url = "http://192.168.111.130/bigdata/carstatus.mc";
		url += "?id="+cs.getId()+"&speed="+cs.getSpeed()+"&direction="+cs.getDirection()+"&speeding="+cs.getSpeeding();
		URL curl = new URL(url);
		HttpURLConnection con = (HttpURLConnection) curl.openConnection();
		try {
			con.getInputStream();
			con.setReadTimeout(5000);
			con.setRequestMethod("POST");
			
		}catch(Exception e) {
			
		}finally {
			con.disconnect();
		}
	}
	public static void main(String[] args) {
		App app = new App();
		app.getData();

	}

}
