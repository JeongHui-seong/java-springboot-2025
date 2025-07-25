package com.pknu.openapi_demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pknu.openapi_demo.dto.Item;
import com.pknu.openapi_demo.dto.FoodKrResponse.GetFoodKr;
import com.pknu.openapi_demo.service.RestaurantService;
import org.springframework.web.bind.annotation.PostMapping;


@RequestMapping("/busan")
@Controller
public class RestaurantController {

    // 실제 OpenAPI 로직을 처리할 서비스 선언
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/foodkr")
    public String showFoodKr(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo, Model model) {
        // RestaurantService에서 OpenAPI를 호출, 데이터 가져옴]
        GetFoodKr rtFoodKr = restaurantService.fetchRestaurant(pageNo);
        List<Item> busanFoodList = rtFoodKr.item;

        System.out.println(busanFoodList.size());

        // 전체 데이터 수, 페이지 사이즈, 현재 페이지
        int totalCount = rtFoodKr.totalCount; // 전체 데이터 수
        int numOfRows = rtFoodKr.numOfRows; // 페이지당 데이터 수
        int totalPages = (int) Math.ceil(totalCount / (double) numOfRows);

        // 리스트로 받은 다음 모델에 할당. HTML로 전달
        model.addAttribute("busanFoodList", busanFoodList);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", totalPages);

        // Model로 리스트 넘김
        return "foodkr"; // templates/foodkr.html 리턴
    }
    
    @PostMapping("/save_foodkr")
    public String saveToDB(@RequestParam(name = "pageNo") int pageNo, Model model) {
        // 데이터 받아서 저장
        @SuppressWarnings("unused")
        int resultCount = restaurantService.saveRestaurantToDB(pageNo);
        
        return String.format("redirect:/busan/foodkr?pageNo=%s", pageNo); // templates/resultFoodKr.html 리턴
    }
    

}
