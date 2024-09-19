package com.capstone.teamProj_10.apiTest;

import com.capstone.teamProj_10.apiTest.valTable.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegionService {

    private final Map<String, String> regionMap = new HashMap<>();
    private final ApiService apiService;

    private final VolunteerService volunteerService;
    private final TableRepository tableRepository;

    @Autowired
    public RegionService(ApiService apiService, VolunteerService volunteerService, TableRepository tableRepository) {
        this.apiService = apiService;
        this.volunteerService = volunteerService;
        this.tableRepository = tableRepository;
        // 시도코드
        regionMap.put("서울특별시", "6110000");
        regionMap.put("부산광역시", "6260000");
        regionMap.put("대구광역시", "6270000");
        regionMap.put("인천광역시", "6280000");
        regionMap.put("광주광역시", "6290000");
        regionMap.put("대전광역시", "6300000");
        regionMap.put("울산광역시", "6310000");
        regionMap.put("세종특별자치시", "5690000");
        regionMap.put("경기도", "6410000");
        regionMap.put("강원도", "6420000");
        regionMap.put("충청북도", "6430000");
        regionMap.put("충청남도", "6440000");
        regionMap.put("전라북도", "6450000");
        regionMap.put("전라남도", "6460000");
        regionMap.put("경상북도", "6470000");
        regionMap.put("경상남도", "6480000");
        regionMap.put("제주특별자치도", "6500000");

        // 서울특별시 시군구코드
        regionMap.put("서울특별시_종로구", "3000000");
        regionMap.put("서울특별시_중구", "3010000");
        regionMap.put("서울특별시_용산구", "3020000");
        regionMap.put("서울특별시_성동구", "3030000");
        regionMap.put("서울특별시_광진구", "3040000");
        regionMap.put("서울특별시_동대문구", "3050000");
        regionMap.put("서울특별시_중랑구", "3060000");
        regionMap.put("서울특별시_성북구", "3070000");
        regionMap.put("서울특별시_강북구", "3080000");
        regionMap.put("서울특별시_도봉구", "3090000");
        regionMap.put("서울특별시_노원구", "3100000");
        regionMap.put("서울특별시_은평구", "3110000");
        regionMap.put("서울특별시_서대문구", "3120000");
        regionMap.put("서울특별시_마포구", "3130000");
        regionMap.put("서울특별시_양천구", "3140000");
        regionMap.put("서울특별시_강서구", "3150000");
        regionMap.put("서울특별시_구로구", "3160000");
        regionMap.put("서울특별시_금천구", "3170000");
        regionMap.put("서울특별시_영등포구", "3180000");
        regionMap.put("서울특별시_동작구", "3190000");
        regionMap.put("서울특별시_관악구", "3200000");
        regionMap.put("서울특별시_서초구", "3210000");
        regionMap.put("서울특별시_강남구", "3220000");
        regionMap.put("서울특별시_송파구", "3230000");
        regionMap.put("서울특별시_강동구", "3240000");
        // 부산광역시 시군구코드
        regionMap.put("부산광역시_중구", "3250000");
        regionMap.put("부산광역시_서구", "3260000");
        regionMap.put("부산광역시_동구", "3270000");
        regionMap.put("부산광역시_영도구", "3280000");
        regionMap.put("부산광역시_부산진구", "3290000");
        regionMap.put("부산광역시_동래구", "3300000");
        regionMap.put("부산광역시_남구", "3310000");
        regionMap.put("부산광역시_북구", "3320000");
        regionMap.put("부산광역시_해운대구", "3330000");
        regionMap.put("부산광역시_사하구", "3340000");
        regionMap.put("부산광역시_금정구", "3350000");
        regionMap.put("부산광역시_강서구", "3360000");
        regionMap.put("부산광역시_연제구", "3370000");
        regionMap.put("부산광역시_수영구", "3380000");
        regionMap.put("부산광역시_사상구", "3390000");
        regionMap.put("부산광역시_기장군", "3400000");

        // 대구광역시 시군구코드
        regionMap.put("대구광역시_중구", "3410000");
        regionMap.put("대구광역시_동구", "3420000");
        regionMap.put("대구광역시_서구", "3430000");
        regionMap.put("대구광역시_남구", "3440000");
        regionMap.put("대구광역시_북구", "3450000");
        regionMap.put("대구광역시_수성구", "3460000");
        regionMap.put("대구광역시_달서구", "3470000");
        regionMap.put("대구광역시_달성군", "3480000");
        // 인천광역시 시군구코드
        regionMap.put("인천광역시_중구", "3490000");
        regionMap.put("인천광역시_동구", "3500000");
        regionMap.put("인천광역시_미추홀구", "3510500");
        regionMap.put("인천광역시_연수구", "3520000");
        regionMap.put("인천광역시_남동구", "3530000");
        regionMap.put("인천광역시_부평구", "3540000");
        regionMap.put("인천광역시_계양구", "3550000");
        regionMap.put("인천광역시_서구", "3560000");
        regionMap.put("인천광역시_강화군", "3570000");
        regionMap.put("인천광역시_옹진군", "3580000");

        // 광주광역시 시군구코드
        regionMap.put("광주광역시_동구", "3590000");
        regionMap.put("광주광역시_서구", "3600000");
        regionMap.put("광주광역시_남구", "3610000");
        regionMap.put("광주광역시_북구", "3620000");
        regionMap.put("광주광역시_광산구", "3630000");

        // 대전광역시 시군구코드
        regionMap.put("대전광역시_동구", "3640000");
        regionMap.put("대전광역시_중구", "3650000");
        regionMap.put("대전광역시_서구", "3660000");
        regionMap.put("대전광역시_유성구", "3670000");
        regionMap.put("대전광역시_대덕구", "3680000");

        // 울산광역시 시군구코드
        regionMap.put("울산광역시_중구", "3690000");
        regionMap.put("울산광역시_남구", "3700000");
        regionMap.put("울산광역시_동구", "3710000");
        regionMap.put("울산광역시_북구", "3720000");
        regionMap.put("울산광역시_울주군", "3730000");
        // 세종특별자치시 시군구코드
        regionMap.put("세종특별자치시", "5690000");

        // 경기도 시군구코드
        regionMap.put("경기도_수원시", "3740000");
        regionMap.put("경기도_성남시", "3780000");
        regionMap.put("경기도_의정부시", "3820000");
        regionMap.put("경기도_안양시", "3830000");
        regionMap.put("경기도_부천시", "3860000");
        regionMap.put("경기도_광명시", "3900000");
        regionMap.put("경기도_평택시", "3910000");
        regionMap.put("경기도_동두천시", "3920000");
        regionMap.put("경기도_안산시", "3930000");
        regionMap.put("경기도_고양시", "3940000");
        regionMap.put("경기도_과천시", "3970000");
        regionMap.put("경기도_구리시", "3980000");
        regionMap.put("경기도_남양주시", "3990000");
        regionMap.put("경기도_오산시", "4000000");
        regionMap.put("경기도_시흥시", "4010000");
        regionMap.put("경기도_군포시", "4020000");
        regionMap.put("경기도_의왕시", "4030000");
        regionMap.put("경기도_하남시", "4040000");
        regionMap.put("경기도_용인시", "4050000");
        regionMap.put("경기도_파주시", "4060000");
        regionMap.put("경기도_이천시", "4070000");
        regionMap.put("경기도_안성시", "4080000");
        regionMap.put("경기도_김포시", "4090000");
        regionMap.put("경기도_연천군", "4140000");
        regionMap.put("경기도_가평군", "4160000");
        regionMap.put("경기도_양평군", "4170000");
        regionMap.put("경기도_화성시", "5530000");
        regionMap.put("경기도_광주시", "5540000");
        regionMap.put("경기도_양주시", "5590000");
        regionMap.put("경기도_포천시", "5600000");
        regionMap.put("경기도_여주시", "5700000");

        // 강원도 시군구코드
        regionMap.put("강원도_춘천시", "4180000");
        regionMap.put("강원도_원주시", "4190000");
        regionMap.put("강원도_강릉시", "4200000");
        regionMap.put("강원도_동해시", "4210000");
        regionMap.put("강원도_태백시", "4220000");
        regionMap.put("강원도_속초시", "4230000");
        regionMap.put("강원도_삼척시", "4240000");
        regionMap.put("강원도_홍천군", "4250000");
        regionMap.put("강원도_횡성군", "4260000");
        regionMap.put("강원도_영월군", "4270000");
        regionMap.put("강원도_평창군", "4280000");
        regionMap.put("강원도_정선군", "4290000");
        regionMap.put("강원도_철원군", "4300000");
        regionMap.put("강원도_화천군", "4310000");
        regionMap.put("강원도_양구군", "4320000");
        regionMap.put("강원도_인제군", "4330000");
        regionMap.put("강원도_고성군", "4340000");
        regionMap.put("강원도_양양군", "4350000");
        // 충청북도 시군구코드
        regionMap.put("충청북도_충주시", "4390000");
        regionMap.put("충청북도_제천시", "4400000");
        regionMap.put("충청북도_보은군", "4420000");
        regionMap.put("충청북도_옥천군", "4430000");
        regionMap.put("충청북도_영동군", "4440000");
        regionMap.put("충청북도_진천군", "4450000");
        regionMap.put("충청북도_괴산군", "4460000");
        regionMap.put("충청북도_음성군", "4470000");
        regionMap.put("충청북도_단양군", "4480000");
        regionMap.put("충청북도_증평군", "5570000");
        regionMap.put("충청북도_청주시", "5710000");

        // 충청남도 시군구코드
        regionMap.put("충청남도_천안시", "4490000");
        regionMap.put("충청남도_공주시", "4500000");
        regionMap.put("충청남도_보령시", "4510000");
        regionMap.put("충청남도_아산시", "4520000");
        regionMap.put("충청남도_서산시", "4530000");
        regionMap.put("충청남도_논산시", "4540000");
        regionMap.put("충청남도_금산군", "4550000");
        regionMap.put("충청남도_연기군", "4560000");
        regionMap.put("충청남도_부여군", "4570000");
        regionMap.put("충청남도_서천군", "4580000");
        regionMap.put("충청남도_청양군", "4590000");
        regionMap.put("충청남도_홍성군", "4600000");
        regionMap.put("충청남도_예산군", "4610000");
        regionMap.put("충청남도_태안군", "4620000");
        regionMap.put("충청남도_계룡시", "5580000");
        regionMap.put("충청남도_당진시", "5680000");
        // 전라북도 시군구코드
        regionMap.put("전라북도_전주시", "4640000");
        regionMap.put("전라북도_군산시", "4670000");
        regionMap.put("전라북도_익산시", "4680000");
        regionMap.put("전라북도_정읍시", "4690000");
        regionMap.put("전라북도_남원시", "4700000");
        regionMap.put("전라북도_김제시", "4710000");
        regionMap.put("전라북도_완주군", "4720000");
        regionMap.put("전라북도_진안군", "4730000");
        regionMap.put("전라북도_무주군", "4740000");
        regionMap.put("전라북도_장수군", "4750000");
        regionMap.put("전라북도_임실군", "4760000");
        regionMap.put("전라북도_순창군", "4770000");
        regionMap.put("전라북도_고창군", "4780000");
        regionMap.put("전라북도_부안군", "4790000");

        // 전라남도 시군구코드
        regionMap.put("전라남도_목포시", "4800000");
        regionMap.put("전라남도_여수시", "4810000");
        regionMap.put("전라남도_순천시", "4820000");
        regionMap.put("전라남도_나주시", "4830000");
        regionMap.put("전라남도_광양시", "4840000");
        regionMap.put("전라남도_담양군", "4850000");
        regionMap.put("전라남도_곡성군", "4860000");
        regionMap.put("전라남도_구례군", "4870000");
        regionMap.put("전라남도_고흥군", "4880000");
        regionMap.put("전라남도_보성군", "4890000");
        regionMap.put("전라남도_화순군", "4900000");
        regionMap.put("전라남도_장흥군", "4910000");
        regionMap.put("전라남도_강진군", "4920000");
        regionMap.put("전라남도_해남군", "4930000");
        regionMap.put("전라남도_영암군", "4940000");
        regionMap.put("전라남도_무안군", "4950000");
        regionMap.put("전라남도_함평군", "4960000");
        regionMap.put("전라남도_영광군", "4970000");
        regionMap.put("전라남도_장성군", "4980000");
        regionMap.put("전라남도_완도군", "4990000");
        regionMap.put("전라남도_진도군", "5000000");
        regionMap.put("전라남도_신안군", "5010000");
        // 경상북도 시군구코드
        regionMap.put("경상북도_포항시", "5020000");
        regionMap.put("경상북도_경주시", "5050000");
        regionMap.put("경상북도_김천시", "5060000");
        regionMap.put("경상북도_안동시", "5070000");
        regionMap.put("경상북도_구미시", "5080000");
        regionMap.put("경상북도_영주시", "5090000");
        regionMap.put("경상북도_영천시", "5100000");
        regionMap.put("경상북도_상주시", "5110000");
        regionMap.put("경상북도_문경시", "5120000");
        regionMap.put("경상북도_경산시", "5130000");
        regionMap.put("경상북도_군위군", "5140000");
        regionMap.put("경상북도_의성군", "5150000");
        regionMap.put("경상북도_청송군", "5160000");
        regionMap.put("경상북도_영양군", "5170000");
        regionMap.put("경상북도_영덕군", "5180000");
        regionMap.put("경상북도_청도군", "5190000");
        regionMap.put("경상북도_고령군", "5200000");
        regionMap.put("경상북도_성주군", "5210000");
        regionMap.put("경상북도_칠곡군", "5220000");
        regionMap.put("경상북도_예천군", "5230000");
        regionMap.put("경상북도_봉화군", "5240000");
        regionMap.put("경상북도_울진군", "5250000");
        regionMap.put("경상북도_울릉군", "5260000");

        // 경상남도 시군구코드
        regionMap.put("경상남도_창원시", "5270000");
        regionMap.put("경상남도_진주시", "5310000");
        regionMap.put("경상남도_통영시", "5320000");
        regionMap.put("경상남도_사천시", "5330000");
        regionMap.put("경상남도_김해시", "5340000");
        regionMap.put("경상남도_밀양시", "5350000");
        regionMap.put("경상남도_거제시", "5360000");
        regionMap.put("경상남도_양산시", "5370000");
        regionMap.put("경상남도_의령군", "5380000");
        regionMap.put("경상남도_함안군", "5390000");
        regionMap.put("경상남도_창녕군", "5400000");
        regionMap.put("경상남도_고성군", "5410000");
        regionMap.put("경상남도_남해군", "5420000");
        regionMap.put("경상남도_하동군", "5430000");
        regionMap.put("경상남도_산청군", "5440000");
        regionMap.put("경상남도_함양군", "5450000");
        regionMap.put("경상남도_거창군", "5460000");
        regionMap.put("경상남도_합천군", "5470000");
        // 제주특별자치도 시군구코드
        regionMap.put("제주특별자치도_제주시", "5011000");
        regionMap.put("제주특별자치도_서귀포시", "5013000");

    }

    public String getRegionCode(String regionName) {
        return regionMap.get(regionName);
    }

    public List<String> getRegionList() {
        List<String> regionList = new ArrayList<>();

        // 시도 리스트 추가
        regionList.add("서울특별시");
        regionList.add("부산광역시");
        regionList.add("대구광역시");
        regionList.add("인천광역시");
        regionList.add("광주광역시");
        regionList.add("대전광역시");
        regionList.add("울산광역시");
        regionList.add("세종특별자치시");
        regionList.add("경기도");
        regionList.add("강원도");
        regionList.add("충청북도");
        regionList.add("충청남도");
        regionList.add("전라북도");
        regionList.add("전라남도");
        regionList.add("경상북도");
        regionList.add("경상남도");
        regionList.add("제주특별자치도");

        return regionList;
    }

    public List<String> getSigunguList(String sido) {
        List<String> sigunguList = new ArrayList<>();

        // 시군구 리스트 추가
        if (sido.equals("서울특별시")) {
            sigunguList.add("종로구");
            sigunguList.add("중구");
            sigunguList.add("용산구");
            sigunguList.add("성동구");
            sigunguList.add("광진구");
            sigunguList.add("동대문구");
            sigunguList.add("중랑구");
            sigunguList.add("성북구");
            sigunguList.add("강북구");
            sigunguList.add("도봉구");
            sigunguList.add("노원구");
            sigunguList.add("은평구");
            sigunguList.add("서대문구");
            sigunguList.add("마포구");
            sigunguList.add("양천구");
            sigunguList.add("강서구");
            sigunguList.add("구로구");
            sigunguList.add("금천구");
            sigunguList.add("영등포구");
            sigunguList.add("동작구");
            sigunguList.add("관악구");
            sigunguList.add("서초구");
            sigunguList.add("강남구");
            sigunguList.add("송파구");
            sigunguList.add("강동구");
        } else if (sido.equals("부산광역시")) {
            sigunguList.add("중구");
            sigunguList.add("서구");
            sigunguList.add("동구");
            sigunguList.add("영도구");
            sigunguList.add("부산진구");
            sigunguList.add("동래구");
            sigunguList.add("남구");
            sigunguList.add("북구");
            sigunguList.add("해운대구");
            sigunguList.add("사하구");
            sigunguList.add("금정구");
            sigunguList.add("강서구");
            sigunguList.add("연제구");
            sigunguList.add("수영구");
            sigunguList.add("사상구");
            sigunguList.add("기장군");
        } else if (sido.equals("대구광역시")) {
            sigunguList.add("중구");
            sigunguList.add("동구");
            sigunguList.add("서구");
            sigunguList.add("남구");
            sigunguList.add("북구");
            sigunguList.add("수성구");
            sigunguList.add("달서구");
            sigunguList.add("달성군");
        } else if (sido.equals("인천광역시")) {
            sigunguList.add("중구");
            sigunguList.add("동구");
            sigunguList.add("미추홀구");
            sigunguList.add("연수구");
            sigunguList.add("남동구");
            sigunguList.add("부평구");
            sigunguList.add("계양구");
            sigunguList.add("서구");
            sigunguList.add("강화군");
            sigunguList.add("옹진군");
        } else if (sido.equals("광주광역시")) {
            sigunguList.add("동구");
            sigunguList.add("서구");
            sigunguList.add("남구");
            sigunguList.add("북구");
            sigunguList.add("광산구");
        } else if (sido.equals("대전광역시")) {
            sigunguList.add("동구");
            sigunguList.add("중구");
            sigunguList.add("서구");
            sigunguList.add("유성구");
            sigunguList.add("대덕구");
        } else if (sido.equals("울산광역시")) {
            sigunguList.add("중구");
            sigunguList.add("남구");
            sigunguList.add("동구");
            sigunguList.add("북구");
            sigunguList.add("울주군");
        } else if (sido.equals("세종특별자치시")) {
            // 세종특별자치시는 시군구가 없으므로 빈 리스트를 반환합니다.
            return sigunguList;
        } else if (sido.equals("경기도")) {
            sigunguList.add("수원시");
            sigunguList.add("성남시");
            sigunguList.add("의정부시");
            sigunguList.add("안양시");
            sigunguList.add("부천시");
            sigunguList.add("광명시");
            sigunguList.add("평택시");
            sigunguList.add("동두천시");
            sigunguList.add("안산시");
            sigunguList.add("고양시");
            sigunguList.add("과천시");
            sigunguList.add("구리시");
            sigunguList.add("남양주시");
            sigunguList.add("오산시");
            sigunguList.add("시흥시");
            sigunguList.add("군포시");
            sigunguList.add("의왕시");
            sigunguList.add("하남시");
            sigunguList.add("용인시");
            sigunguList.add("파주시");
            sigunguList.add("이천시");
            sigunguList.add("안성시");
            sigunguList.add("김포시");
            sigunguList.add("화성시");
            sigunguList.add("광주시");
            sigunguList.add("양주시");
            sigunguList.add("포천시");
            sigunguList.add("여주시");
            sigunguList.add("연천군");
            sigunguList.add("가평군");
            sigunguList.add("양평군");
        } else if (sido.equals("강원도")) {
            sigunguList.add("춘천시");
            sigunguList.add("원주시");
            sigunguList.add("강릉시");
            sigunguList.add("동해시");
            sigunguList.add("태백시");
            sigunguList.add("속초시");
            sigunguList.add("삼척시");
            sigunguList.add("홍천군");
            sigunguList.add("횡성군");
            sigunguList.add("영월군");
            sigunguList.add("평창군");
            sigunguList.add("정선군");
            sigunguList.add("철원군");
            sigunguList.add("화천군");
            sigunguList.add("양구군");
            sigunguList.add("인제군");
            sigunguList.add("고성군");
            sigunguList.add("양양군");
        } else if (sido.equals("충청북도")) {
            sigunguList.add("충주시");
            sigunguList.add("제천시");
            sigunguList.add("보은군");
            sigunguList.add("옥천군");
            sigunguList.add("영동군");
            sigunguList.add("진천군");
            sigunguList.add("괴산군");
            sigunguList.add("음성군");
            sigunguList.add("단양군");
            sigunguList.add("증평군");
            sigunguList.add("청주시");
        } else if (sido.equals("충청남도")) {
            sigunguList.add("천안시");
            sigunguList.add("공주시");
            sigunguList.add("보령시");
            sigunguList.add("아산시");
            sigunguList.add("서산시");
            sigunguList.add("논산시");
            sigunguList.add("금산군");
            sigunguList.add("연기군");
            sigunguList.add("부여군");
            sigunguList.add("서천군");
            sigunguList.add("청양군");
            sigunguList.add("홍성군");
            sigunguList.add("예산군");
            sigunguList.add("태안군");
            sigunguList.add("계룡시");
            sigunguList.add("당진시");
        } else if (sido.equals("전라북도")) {
            sigunguList.add("전주시");
            sigunguList.add("군산시");
            sigunguList.add("익산시");
            sigunguList.add("정읍시");
            sigunguList.add("남원시");
            sigunguList.add("김제시");
            sigunguList.add("완주군");
            sigunguList.add("진안군");
            sigunguList.add("무안군");
            sigunguList.add("함평군");
            sigunguList.add("영광군");
            sigunguList.add("장성군");
            sigunguList.add("완도군");
            sigunguList.add("진도군");
            sigunguList.add("신안군");
        } else if (sido.equals("전라남도")) {
            sigunguList.add("목포시");
            sigunguList.add("여수시");
            sigunguList.add("순천시");
            sigunguList.add("나주시");
            sigunguList.add("광양시");
            sigunguList.add("담양군");
            sigunguList.add("곡성군");
            sigunguList.add("구례군");
            sigunguList.add("고흥군");
            sigunguList.add("보성군");
            sigunguList.add("화순군");
            sigunguList.add("장흥군");
            sigunguList.add("강진군");
            sigunguList.add("해남군");
            sigunguList.add("영암군");
            sigunguList.add("무안군");
            sigunguList.add("함평군");
            sigunguList.add("영광군");
            sigunguList.add("장성군");
            sigunguList.add("완도군");
            sigunguList.add("진도군");
            sigunguList.add("신안군");
        } else if (sido.equals("경상북도")) {
            sigunguList.add("포항시");
            sigunguList.add("경주시");
            sigunguList.add("김천시");
            sigunguList.add("안동시");
            sigunguList.add("구미시");
            sigunguList.add("영주시");
            sigunguList.add("영천시");
            sigunguList.add("상주시");
            sigunguList.add("문경시");
            sigunguList.add("경산시");
            sigunguList.add("군위군");
            sigunguList.add("의성군");
            sigunguList.add("청송군");
            sigunguList.add("영양군");
            sigunguList.add("영덕군");
            sigunguList.add("청도군");
            sigunguList.add("고령군");
            sigunguList.add("성주군");
            sigunguList.add("칠곡군");
            sigunguList.add("예천군");
            sigunguList.add("봉화군");
            sigunguList.add("울진군");
            sigunguList.add("울릉군");
        } else if (sido.equals("경상남도")) {
            sigunguList.add("진주시");
            sigunguList.add("통영시");
            sigunguList.add("사천시");
            sigunguList.add("김해시");
            sigunguList.add("밀양시");
            sigunguList.add("거제시");
            sigunguList.add("양산시");
            sigunguList.add("의령군");
            sigunguList.add("함안군");
            sigunguList.add("창녕군");
            sigunguList.add("고성군");
            sigunguList.add("남해군");
            sigunguList.add("하동군");
            sigunguList.add("산청군");
            sigunguList.add("함양군");
            sigunguList.add("거창군");
            sigunguList.add("합천군");
            sigunguList.add("창원시");
        } else if (sido.equals("제주특별자치도")) {
            sigunguList.add("제주시");
            sigunguList.add("서귀포시");
        }

        return sigunguList;
    }
/*
        public void generateRegionCodes () {
            List<String> regionList = getRegionList();

            for (String region : regionList) {
                String sidoCode = getRegionCode(region);
                List<String> sigunguList = getSigunguList(region);

                for (String sigungu : sigunguList) {
                    String sigunguCode = getRegionCode(region + "_" + sigungu);

                    // 생성된 시도코드와 시군구코드를 활용하여 원하는 작업 수행
                    System.out.println("Region: " + region + ", SidoCode: " + sidoCode + ", Sigungu: " + sigungu + ", SigunguCode: " + sigunguCode);
                }
            }
        }*/

    public String searchAddress (String upperClName, String nanmClName ,String sido, String sigungu, int pageNo){
        String upperClCode = volunteerService.getClCode(upperClName);
        String nanmClCode = volunteerService.getClCode(upperClName + "_" + nanmClName);
        String sidoCode = getRegionCode(sido);
        String sigunguCode = getRegionCode(sido + "_" + sigungu);
        try {
            return apiService.getApiResult(upperClCode, nanmClCode, sidoCode, sigunguCode, pageNo);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while fetching data.";
        }
    }
    public String searchDetail(Long progrmRegistNo) throws Exception {
        try{
            return apiService.getDetailResult(progrmRegistNo);
        }catch (Exception e){
            e.printStackTrace();
            return "Error occurred while fetching data.";
        }
    }
}

