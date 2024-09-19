package com.capstone.teamProj_10.apiTest.Detail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class DetailTable {
    @Id
    @Column(name ="prog_No")
    private Long progrmRegistNo;//프로그램 코드
    @Column(nullable = false)
    private int actBeginTm;//시작시간
    @Column(nullable = false)
    private int actEndTm;//끝나는시간
    @Column(nullable = false)
    private String actPlace;//봉사 장소
    @Column(nullable = false)
    private String adultPosblAt;//성인가능여부
    private int appTotal; //신청인원수
    private String  areaAddress1;//장소
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
    @Column(nullable = false)
    private int gugunCd;//시군구 코드
    @Column(nullable = false)
    private int sidoCd;//시도 코드
    private String mnnstNm;//모집기관
    @Column(nullable = false)
    private String nanmmbyNm;//등록기관
    private String nanmmbyNmAdmn;//담당자명
    private int noticeBgnde;//모집시작일
    private int noticeEndde;//모집종료일
    private String pbsvntPosblAt;
    private String postAdres;//담당자 주소
    private int progrmBgnde;//봉사시작일자
    @Lob
    private String progrmCn;//내용
    private int progrmEndde;//봉사종료일자
    @Column(nullable = false)
    private String progrmSj;//봉사제목
    private int progrmSttusSe;//모집상태
    private int rcritNmpr;//모집인원
    private String srvcClCode;//봉사분야
    private String telno;//전화번호

    public DetailTable(DetailDto detailDto) {
        this.progrmRegistNo = detailDto.getProgrmRegistNo();
        this.actBeginTm = detailDto.getActBeginTm();
        this.actEndTm = detailDto.getActEndTm();
        this.actPlace = detailDto.getActPlace();
        this.adultPosblAt = detailDto.getAdultPosblAt();
        this.appTotal = detailDto.getAppTotal();
        this.areaAddress1 = detailDto.getAreaAddress1();
        this.areaAddress2 = detailDto.getAreaAddress2();
        this.areaAddress3 = detailDto.getAreaAddress3();
        this.areaLalo1 = detailDto.getAreaLalo1();
        this.email = detailDto.getEmail();
        this.familyPosblAt = detailDto.getFamilyPosblAt();
        this.fxnum = detailDto.getFxnum();
        this.grpPosblAt = detailDto.getGrpPosblAt();
        this.yngbgsPosblAt = detailDto.getYngbgsPosblAt();
        this.gugunCd = detailDto.getGugunCd();
        this.sidoCd = detailDto.getSidoCd();
        this.mnnstNm = detailDto.getMnnstNm();
        this.nanmmbyNm = detailDto.getNanmmbyNm();
        this.nanmmbyNmAdmn = detailDto.getNanmmbyNmAdmn();
        this.noticeBgnde = detailDto.getNoticeBgnde();
        this.noticeEndde = detailDto.getNoticeEndde();
        this.pbsvntPosblAt = detailDto.getPbsvntPosblAt();
        this.postAdres = detailDto.getPostAdres();
        this.progrmBgnde = detailDto.getProgrmBgnde();
        this.progrmCn = detailDto.getProgrmCn();
        this.progrmEndde = detailDto.getProgrmEndde();
        this.progrmSj = detailDto.getProgrmSj();
        this.progrmSttusSe = detailDto.getProgrmSttusSe();
        this.rcritNmpr = detailDto.getRcritNmpr();
        this.srvcClCode = detailDto.getSrvcClCode();
        this.telno = detailDto.getTelno();
    }

}
