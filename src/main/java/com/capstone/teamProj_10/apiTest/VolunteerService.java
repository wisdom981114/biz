package com.capstone.teamProj_10.apiTest;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VolunteerService {
    private final Map<String ,String> volunteerServiceMap = new HashMap<>();
    public VolunteerService() {
        // 대분류
        volunteerServiceMap.put("전체", "");
        volunteerServiceMap.put("생활편의지원", "0100");
        volunteerServiceMap.put("주거환경", "0200");
        volunteerServiceMap.put("상담", "0300");
        volunteerServiceMap.put("교육", "0400");
        volunteerServiceMap.put("보건의료", "0500");
        volunteerServiceMap.put("농어촌 봉사", "0600");
        volunteerServiceMap.put("문화행사", "0700");
        volunteerServiceMap.put("환경보호", "0800");
        volunteerServiceMap.put("행정보조", "0900");
        volunteerServiceMap.put("안전.예방", "1000");
        volunteerServiceMap.put("공익.인권", "1100");
        volunteerServiceMap.put("재해ㆍ재난", "1200");
        volunteerServiceMap.put("국제협력.해외봉사", "1300");
        volunteerServiceMap.put("멘토링", "1400");
        volunteerServiceMap.put("기타", "1500");
        volunteerServiceMap.put("자원봉사교육", "1700");
        volunteerServiceMap.put("전체_전체","");

        // 생활편의지원 하위 분류
        volunteerServiceMap.put("생활편의지원_전체", "");
        volunteerServiceMap.put("생활편의지원_활동보조", "0101");
        volunteerServiceMap.put("생활편의지원_이동지원", "0102");
        volunteerServiceMap.put("생활편의지원_청결지도", "0103");
        volunteerServiceMap.put("생활편의지원_급식지원", "0104");
        volunteerServiceMap.put("생활편의지원_식사.반찬지원", "0105");
        volunteerServiceMap.put("생활편의지원_기타", "0199");

        // 주거환경 하위 분류
        volunteerServiceMap.put("주거환경_전체", "");
        volunteerServiceMap.put("주거환경_주거개선", "0201");
        volunteerServiceMap.put("주거환경_마을공동체활동", "0202");
        volunteerServiceMap.put("주거환경_기타", "0299");

        // 상담 하위 분류
        volunteerServiceMap.put("상담_전체", "");
        volunteerServiceMap.put("상담_말벗.상담", "0301");
        volunteerServiceMap.put("상담_전문상담", "0302");
        volunteerServiceMap.put("상담_기타", "0399");

        // 교육 하위 분류
        volunteerServiceMap.put("교육_전체", "");
        volunteerServiceMap.put("교육_방과후 교육", "0401");
        volunteerServiceMap.put("교육_학습지도 교육", "0402");
        volunteerServiceMap.put("교육_특수교육", "0403");
        volunteerServiceMap.put("교육_평생교육", "0404");
        volunteerServiceMap.put("교육_전문교육", "0405");
        volunteerServiceMap.put("교육_진로체험지도", "0406");
        volunteerServiceMap.put("교육_기타", "0499");

        // 보건의료 하위 분류
        volunteerServiceMap.put("보건의료_전체", "");
        volunteerServiceMap.put("보건의료_간호.간병", "0501");
        volunteerServiceMap.put("보건의료_의료지원", "0502");
        volunteerServiceMap.put("보건의료_헌혈", "0503");
        volunteerServiceMap.put("보건의료_기타", "0599");

        // 농어촌봉사 하위 분류
        volunteerServiceMap.put("농어촌봉사_전체", "");
        volunteerServiceMap.put("농어촌봉사_일손지원", "0601");
        volunteerServiceMap.put("농어촌봉사_기타", "0699");

        // 문화행사 하위 분류
        volunteerServiceMap.put("문화행사_전체", "");
        volunteerServiceMap.put("문화행사_행사보조", "0701");
        volunteerServiceMap.put("문화행사_공연활동", "0702");
        volunteerServiceMap.put("문화행사_캠페인", "0703");
        volunteerServiceMap.put("문화행사_관광안내", "0704");
        volunteerServiceMap.put("문화행사_사진촬영", "0705");
        volunteerServiceMap.put("문화행사_기타", "0799");

        // 환경보호 하위 분류
        volunteerServiceMap.put("환경보호_전체", "");
        volunteerServiceMap.put("환경보호_환경정화", "0801");
        volunteerServiceMap.put("환경보호_환경감시", "0802");
        volunteerServiceMap.put("환경보호_기타", "0899");

        // 행정보조 하위 분류
        volunteerServiceMap.put("행정보조_전체", "");
        volunteerServiceMap.put("행정보조_사무지원", "0901");
        volunteerServiceMap.put("행정보조_업무지원", "0902");
        volunteerServiceMap.put("행정보조_기타", "0999");

        // 안전.예방 하위 분류
        volunteerServiceMap.put("안전.예방_전체", "");
        volunteerServiceMap.put("안전.예방_지역안전", "1001");
        volunteerServiceMap.put("안전.예방_교통안전", "1002");
        volunteerServiceMap.put("안전.예방_어린이 안전", "1003");
        volunteerServiceMap.put("안전.예방_청소년 안전", "1004");
        volunteerServiceMap.put("안전.예방_취약계층 안전", "1005");
        volunteerServiceMap.put("안전.예방_안전신고ㆍ활동", "1006");
        volunteerServiceMap.put("안전.예방_기타", "1099");

        // 공익.인권 하위 분류
        volunteerServiceMap.put("공익.인권_전체", "");
        volunteerServiceMap.put("공익.인권_인권개선", "1101");
        volunteerServiceMap.put("공익.인권_기타", "1199");

        // 재해.재난 하위 분류
        volunteerServiceMap.put("재해.재난_전체", "");
        volunteerServiceMap.put("재해.재난_피해복구", "1201");
        volunteerServiceMap.put("재해.재난_긴급구조", "1202");
        volunteerServiceMap.put("재해.재난_예방접종지원", "1203");
        volunteerServiceMap.put("재해.재난_기타", "1299");

        // 국제협력.해외봉사 하위 분류
        volunteerServiceMap.put("국제협력.해외봉사_전체", "");
        volunteerServiceMap.put("국제협력.해외봉사_해외봉사", "1301");
        volunteerServiceMap.put("국제협력.해외봉사_국제행사단체지원", "1302");
        volunteerServiceMap.put("국제협력.해외봉사_통.번역", "1303");
        volunteerServiceMap.put("국제협력.해외봉사_기타", "1399");

        // 멘토링 하위 분류
        volunteerServiceMap.put("멘토링_전체", "");
        volunteerServiceMap.put("멘토링_멘토링", "1401");
        volunteerServiceMap.put("멘토링_학습", "1402");
        volunteerServiceMap.put("멘토링_진로적성", "1403");
        volunteerServiceMap.put("멘토링_취업", "1404");
        volunteerServiceMap.put("멘토링_창업", "1405");
        volunteerServiceMap.put("멘토링_기타", "1406");

        // 기타 하위 분류
        volunteerServiceMap.put("기타_기타", "1501");

        // 자원봉사교육 하위 분류
        volunteerServiceMap.put("자원봉사교육_전체", "");
        volunteerServiceMap.put("자원봉사교육_자원봉사기본교육", "1701");
        volunteerServiceMap.put("자원봉사교육_자원봉사보수교육", "1702");
        volunteerServiceMap.put("자원봉사교육_자원봉사전문교육", "1703");
        volunteerServiceMap.put("자원봉사교육_자원봉사기타교육.관리자교육", "1704");
        volunteerServiceMap.put("자원봉사교육_자원봉사기타교육.지도자교육", "1705");
        volunteerServiceMap.put("자원봉사교육_자원봉사기타교육.상담사교육", "1706");
        volunteerServiceMap.put("자원봉사교육_자원봉사기타교육.수요처교육", "1707");
        volunteerServiceMap.put("자원봉사교육_자원봉사기타교육.기타교육", "1708");

    }
    public String getClCode(String CategoryName){
        return volunteerServiceMap.get(CategoryName);
    }
    public List<String> getUpperClCode(){
        List<String> upperClCodeList = new ArrayList<>();

        upperClCodeList.add("전체");
        upperClCodeList.add("생활편의지원");
        upperClCodeList.add("주거환경");
        upperClCodeList.add("상담");
        upperClCodeList.add("교육");
        upperClCodeList.add("보건의료");
        upperClCodeList.add("농어촌 봉사");
        upperClCodeList.add("문화행사");
        upperClCodeList.add("환경보호");
        upperClCodeList.add("행정보조");
        upperClCodeList.add("안전.예방");
        upperClCodeList.add("공익.인권");
        upperClCodeList.add("재해ㆍ재난");
        upperClCodeList.add("국제협력.해외봉사");
        upperClCodeList.add("멘토링");
        upperClCodeList.add("기타");
        upperClCodeList.add("자원봉사교육");
        upperClCodeList.add("국제행사");

        return upperClCodeList;
    }

    public List<String> getNanmClCode(String category) {
        List<String> nanmClCodeList = new ArrayList<>();
        //생환편의지원
        if (category.equals("생활편의지원")) {
            nanmClCodeList.add("전체");
            nanmClCodeList.add("활동보조");
            nanmClCodeList.add("이동보조");
            nanmClCodeList.add("청결지도");
            nanmClCodeList.add("급식지원");
            nanmClCodeList.add("식사.반찬지원");
            nanmClCodeList.add("기타");
        } else if (category.equals("주거환경")) {
            nanmClCodeList.add("전체");
            nanmClCodeList.add("주거개선");
            nanmClCodeList.add("마을공동체활동");
            nanmClCodeList.add("기타");
        }else if(category.equals("전체")){
            nanmClCodeList.add("전체");
        } else if (category.equals("상담")) {
            nanmClCodeList.add("전체");
            nanmClCodeList.add("말벗.상담");
            nanmClCodeList.add("전문상담");
            nanmClCodeList.add("기타");
        } else if (category.equals("교육")) {
            nanmClCodeList.add("전체");
            nanmClCodeList.add("방과후 교육");
            nanmClCodeList.add("학습지도 교육");
            nanmClCodeList.add("특수교육");
            nanmClCodeList.add("평생교육");
            nanmClCodeList.add("전문교육");
            nanmClCodeList.add("진로체험지도");
            nanmClCodeList.add("기타");
        } else if (category.equals("보건의료")) {
            nanmClCodeList.add("전체");
            nanmClCodeList.add("간호.간병");
            nanmClCodeList.add("의료지원");
            nanmClCodeList.add("헌혈");
            nanmClCodeList.add("기타");
        } else if (category.equals("농어촌봉사")) {
            nanmClCodeList.add("전체");
            nanmClCodeList.add("일손지원");
            nanmClCodeList.add("기타");
        } else if (category.equals("문화행사")) {
            nanmClCodeList.add("전체");
            nanmClCodeList.add("행사보조");
            nanmClCodeList.add("공연활동");
            nanmClCodeList.add("캠페인");
            nanmClCodeList.add("관광안내");
            nanmClCodeList.add("사진촬영");
            nanmClCodeList.add("기타");
        } else if (category.equals("환경보호")) {
            nanmClCodeList.add("전체");
            nanmClCodeList.add("환경정화");
            nanmClCodeList.add("환경감시");
            nanmClCodeList.add("기타");
        } else if (category.equals("행정보조")) {
            nanmClCodeList.add("전체");
            nanmClCodeList.add("사무지원");
            nanmClCodeList.add("업무지원");
            nanmClCodeList.add("기타");
        } else if (category.equals("안전.예방")) {
            nanmClCodeList.add("전체");
            nanmClCodeList.add("지역안전");
            nanmClCodeList.add("교통안전");
            nanmClCodeList.add("어린이 안전");
            nanmClCodeList.add("청소년 안전");
            nanmClCodeList.add("취약계층 안전");
            nanmClCodeList.add("안전신고ㆍ활동");
            nanmClCodeList.add("기타");
        } else if (category.equals("공익.인권")) {
            nanmClCodeList.add("전체");
            nanmClCodeList.add("인권개선");
            nanmClCodeList.add("공익보호");
            nanmClCodeList.add("기타");
        } else if (category.equals("재해.재난")) {
            nanmClCodeList.add("전체");
            nanmClCodeList.add("피해복구");
            nanmClCodeList.add("긴급구조");
            nanmClCodeList.add("예방접종지원");
            nanmClCodeList.add("기타");
        } else if (category.equals("국제협력.해외봉사")) {
            nanmClCodeList.add("전체");
            nanmClCodeList.add("해외봉사");
            nanmClCodeList.add("국제행사단체지원");
            nanmClCodeList.add("통.번역");
            nanmClCodeList.add("기타");
        } else if (category.equals("멘토링")) {
            nanmClCodeList.add("전체");
            nanmClCodeList.add("멘토링");
            nanmClCodeList.add("학습");
            nanmClCodeList.add("진로적성");
            nanmClCodeList.add("취업");
            nanmClCodeList.add("창업");
            nanmClCodeList.add("기타");
        } else if (category.equals("기타")) {
            nanmClCodeList.add("전체");
            nanmClCodeList.add("기타");
        } else if (category.equals("자원봉사교육")) {
            nanmClCodeList.add("전체");
            nanmClCodeList.add("자원봉사기본교육");
            nanmClCodeList.add("자원봉사보수교육");
            nanmClCodeList.add("자원봉사전문교육");
            nanmClCodeList.add("자원봉사기타교육.관리자교육");
            nanmClCodeList.add("자원봉사교육_지도자교육");
            nanmClCodeList.add("자원봉사기타교육.상담사교육");
            nanmClCodeList.add("자원봉사기타교육.수요처교육");
            nanmClCodeList.add("자원봉사기타교육.기타교육");
        }
        return nanmClCodeList;
    }

}
