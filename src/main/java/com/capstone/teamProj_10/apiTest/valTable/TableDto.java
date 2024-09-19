package com.capstone.teamProj_10.apiTest.valTable;

import lombok.Data;
import org.json.JSONObject;


@Data

public class TableDto {

    private Long progrmRegistNo;
    private int gugunCd;//시군구 코드
    private int sidoCd;//시도 코드
    private int progrmBgnde;
    private int progrmEndde;
    private String progrmSj;
    private int progrmSttusSe;

    public TableDto(JSONObject itemJson) {
        this.progrmRegistNo = itemJson.getLong("progrmRegistNo");
        this.gugunCd = itemJson.getInt("gugunCd");
        this.sidoCd = itemJson.getInt("sidoCd");
        this.progrmBgnde = itemJson.getInt("progrmBgnde");
        this.progrmEndde = itemJson.getInt("progrmEndde");
        this.progrmSj = itemJson.getString("progrmSj");
        this.progrmSttusSe = itemJson.getInt("progrmSttusSe");
    }
}
