package com.marpol.thtest.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "stock/info";
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String info() {
		
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String allowBasic(Model model) {
        StringBuffer result = new StringBuffer();
        try {
        	StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1160100/service/GetStocDiviInfoService/getDiviInfo"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=CFoctgtflSqAM4CTHl65qV4PCmkNdFjxFwD6kteJJqCgxRfiMRC%2BsXjIAQWZgNnjx91DOcedZLEGJZpP2XEfHQ%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
            urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*결과형식(xml/json)*/
            urlBuilder.append("&" + URLEncoder.encode("basDt","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*작업 또는 거래의 기준이 되는 일자(년월일)*/
            urlBuilder.append("&" + URLEncoder.encode("crno","UTF-8") + "=" + URLEncoder.encode("1101110057012", "UTF-8")); /*법인등록번호*/
            urlBuilder.append("&" + URLEncoder.encode("stckIssuCmpyNm","UTF-8") + "=" + URLEncoder.encode("동남합성", "UTF-8")); /*주식발행사의 명칭*/
            urlBuilder.append("&type=json"); /*결과 json 포맷*/
            URL url = new URL(urlBuilder.toString());
            model.addAttribute("API", urlBuilder);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line + "\n");
            }
            rd.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result + "";
    }
	
}
