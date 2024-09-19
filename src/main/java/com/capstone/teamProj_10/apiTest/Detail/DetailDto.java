package com.capstone.teamProj_10.apiTest.Detail;

import lombok.Data;
import org.json.JSONObject;


@Data
public class DetailDto {
    private Long progrmRegistNo;//프로그램 코드
    private int actBeginTm;//시작시간
    private int actEndTm;//끝나는시간
    private String actPlace;//봉사 장소
    private String adultPosblAt;//성인가능여부
    private int appTotal; //신청인원수
    private String areaAddress1;//좌표
    private String areaAddress2;
    private String areaAddress3;
    private String areaLalo1;//좌표
    private String areaLalo2;
    private String areaLalo3;
    private String email;//이메일
    private String familyPosblAt;//가족가능여부
    private String fxnum;//팩스번호
    private String grpPosblAt;//단체가능여부
    private String yngbgsPosblAt;//미성년자 가능여부
    private int gugunCd;//시군구 코드
    private int sidoCd;//시도 코드
    private String mnnstNm;//모집기관
    private String nanmmbyNm;//등록기관
    private String nanmmbyNmAdmn;//담당자명
    private int noticeBgnde;//모집시작일
    private int noticeEndde;//모집종료일
    private String pbsvntPosblAt;
    private String postAdres;//담당자 주소
    private int progrmBgnde;//봉사시작일자
    private String progrmCn;//내용
    private int progrmEndde;//봉사종료일자
    private String progrmSj;//봉사제목
    private int progrmSttusSe;//모집상태
    private int rcritNmpr;//모집인원
    private String srvcClCode;//봉사분야
    private String telno;//전화번호

    public DetailDto(JSONObject detailJson) {
        this.progrmRegistNo = detailJson.getLong("progrmRegistNo");
        this.actBeginTm = detailJson.getInt("actBeginTm");
        this.actEndTm = detailJson.getInt("actEndTm");
        this.actPlace = detailJson.getString("actPlace");
        this.adultPosblAt = detailJson.getString("adultPosblAt");
        this.appTotal = detailJson.getInt("appTotal");
        this.areaAddress1 = detailJson.getString("areaAddress1");
        this.areaAddress2 = detailJson.getString("areaAddress2");
        this.areaAddress3 = detailJson.getString("areaAddress3");
        this.areaLalo1 = detailJson.getString("areaLalo1");
        this.areaLalo2 = detailJson.getString("areaLalo2");
        this.areaLalo3 = detailJson.getString("areaLalo3");
        this.email = detailJson.getString("email");
        this.familyPosblAt = detailJson.getString("familyPosblAt");
        this.fxnum = detailJson.getString("fxnum");
        this.grpPosblAt = detailJson.getString("grpPosblAt");
        this.yngbgsPosblAt = detailJson.getString("yngbgsPosblAt");
        this.gugunCd = detailJson.getInt("gugunCd");
        this.sidoCd = detailJson.getInt("sidoCd");
        this.mnnstNm = detailJson.getString("mnnstNm");
        this.nanmmbyNm = detailJson.getString("nanmmbyNm");
        this.nanmmbyNmAdmn = detailJson.getString("nanmmbyNmAdmn");
        this.noticeBgnde = detailJson.getInt("noticeBgnde");
        this.noticeEndde = detailJson.getInt("noticeEndde");
        this.pbsvntPosblAt = detailJson.getString("pbsvntPosblAt");
        this.postAdres = detailJson.getString("postAdres");
        this.progrmBgnde = detailJson.getInt("progrmBgnde");
        this.progrmCn = detailJson.getString("progrmCn");
        this.progrmEndde = detailJson.getInt("progrmEndde");
        this.progrmSj = detailJson.getString("progrmSj");
        this.progrmSttusSe = detailJson.getInt("progrmSttusSe");
        this.rcritNmpr = detailJson.getInt("rcritNmpr");
        this.srvcClCode = detailJson.getString("srvcClCode");
        this.telno = detailJson.getString("telno");
    }
}
