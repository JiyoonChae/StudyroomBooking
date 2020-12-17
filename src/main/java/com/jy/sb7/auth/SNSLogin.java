package com.jy.sb7.auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jdk.internal.org.jline.utils.InputStreamReader;
@Controller
@RequestMapping("/snslogin/**")
public class SNSLogin {
	
	@RequestMapping(value="callback", method= {RequestMethod.GET, RequestMethod.POST})
	public class NaverLoginServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public NaverLoginServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	 
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 네이버 로그인 처리 컨트롤러
			String clientId = "3mxLzdZN0uWCIguV1hC2";//애플리케이션 클라이언트 아이디값";
		    String clientSecret = "H8HXwHQyv1";//애플리케이션 클라이언트 시크릿값";
		    String code = request.getParameter("code");
		    String state = request.getParameter("state");
		    String redirectURI = URLEncoder.encode("http://localhost/member/callback", "UTF-8");
		    
		    StringBuffer apiURL = new StringBuffer();
		    apiURL.append("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&");
		    apiURL.append("client_id=" + clientId);
		    apiURL.append("&client_secret=" + clientSecret);
		    apiURL.append("&redirect_uri=" + redirectURI);
		    apiURL.append("&code=" + code);
		    apiURL.append("&state=" + state);
		    String access_token = "";
		    String refresh_token = "";
		    System.out.println("apiURL="+apiURL);
		    
		    try {
		        URL url = new URL(apiURL);
		        HttpURLConnection con = (HttpURLConnection)url.openConnection();
		        con.setRequestMethod("GET");
		        int responseCode = con.getResponseCode();
		        BufferedReader br;
		        System.out.print("responseCode="+responseCode);
		        if(responseCode==200) { // 정상 호출
		          br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		        } else {  // 에러 발생
		          br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		        }
		        String inputLine;
		        StringBuffer res = new StringBuffer();
		        while ((inputLine = br.readLine()) != null) {
		          res.append(inputLine);
		        }
		        br.close();
		        if(responseCode==200) {
		        	System.out.println(res.toString());
		        	
		        	JSONParser parsing = new JSONParser(res);
		        	Object obj = parsing.parse(res.toString());
		        	JSONObject jsonObj = (JSONObject)obj;
		        		        
		        	access_token = (String)jsonObj.get("access_token");
		        	refresh_token = (String)jsonObj.get("refresh_token");
		        }
		      } catch (Exception e) {
		        System.out.println(e);
		      }
		    
	    }
	    /**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	 
	}
	
}
