package com.capstone.teamProj_10.apiTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PlacesController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PlacesController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/valTable")
    public List<Map<String, Double>> getvalTable() {
        String query = "SELECT AREA_LALO1 FROM DETAIL_TABLE";
        List<String> laloList = jdbcTemplate.queryForList(query, String.class);
        List<Map<String, Double>> result = new ArrayList<>();

        for (String lalo : laloList) {
            String[] laloArr = lalo.split(",");
            if (laloArr.length == 2) {
                double latitude = Double.parseDouble(laloArr[0]);
                double longitude = Double.parseDouble(laloArr[1]);

                Map<String, Double> laloMap = new HashMap<>();
                laloMap.put("latitude", latitude);
                laloMap.put("longitude", longitude);

                result.add(laloMap);
            }
        }

        return result;
    }
}
