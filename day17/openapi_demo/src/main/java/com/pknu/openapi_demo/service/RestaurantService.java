package com.pknu.openapi_demo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pknu.openapi_demo.dto.FoodKrResponse;
import com.pknu.openapi_demo.dto.Item;

@Service
public class RestaurantService {

    public List<Item> fetchRestaurant(int pageNo) {
        StringBuffer result = new StringBuffer();

        try {
            StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/6260000/FoodService/getFoodKr");
            urlBuilder.append("?serviceKey=" + "hZ7IuqSt7YTUX2yAYbhODYcYoQo%2FQOE8%2B4PcjwclOLPtYkE8dNz8WEnttQ%2FxXFgazu3yqEixdgiRGb7CM7EDVw%3D%3D");
            urlBuilder.append("&pageNo=" + pageNo);
            urlBuilder.append("&numOfRows=" + "10");
            urlBuilder.append("&resultType=json");

            URL url = new URL(urlBuilder.toString());
            // System.out.println(url); // URL 확인용
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET"); // GET 방식으로 요청

            BufferedReader rd;
            // conn.getResponseCode()가 200(OK) 400(Not Found) 500(Server Error)
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            // 한 줄씩 읽어서 문자열 버퍼에 할당
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line + "\n");
            }

            rd.close();
            conn.disconnect();

            // System.out.println(result.toString()); // 결과 확인용

            // JSON 문자열 파싱
            ObjectMapper mapper = new ObjectMapper();
            FoodKrResponse reponse = mapper.readValue(result.toString(), FoodKrResponse.class);

            // 리스트에 담아서 리턴
            List<Item> foodList = reponse.getFoodKr.item;
            return foodList;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
