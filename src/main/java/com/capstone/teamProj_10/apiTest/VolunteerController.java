package com.capstone.teamProj_10.apiTest;//package com.example.teamprojTest.ApiTest;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class VolunteerController {
//    @GetMapping("/volunteer/search")
//    public String searchVolunteer(@RequestParam(value = "address", required = false) String address, Model model) {
//        if (address != null && !address.isEmpty()) {
//            String kakaoApiKey = "894d74cbb0891c349e8e362513a9dd93"; // 카카오 API 키
//            try {
//                String sidoCode = ApiService.convertAddressToSidoCode(address, kakaoApiKey);
//                if (sidoCode != null) {
//                    String sggCode = ApiService.convertAddressToSigunguCode(address, kakaoApiKey);
//                    String result = ApiService.getApiResult("자원봉사", sidoCode, sggCode, "", "");
//                    JSONObject jsonResult = ApiService.convertXmlToJson(result);
//                    JSONObject response = (JSONObject) jsonResult.get("response");
//                    JSONArray itemList = (JSONArray) response.get("itemList");
//                    model.addAttribute("itemList", itemList);
//                } else {
//                    model.addAttribute("errorMsg", "주소를 찾을 수 없습니다. 다른 주소를 입력하세요.");
//                }
//            } catch (Exception e) {
//                model.addAttribute("errorMsg", "오류가 발생했습니다. 다시 시도해주세요.");
//            }
//        }
//        return "index";
//    }
//}
