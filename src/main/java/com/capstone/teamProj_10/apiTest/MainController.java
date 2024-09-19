package com.capstone.teamProj_10.apiTest;

import com.capstone.teamProj_10.apiTest.Detail.DetailDto;
import com.capstone.teamProj_10.apiTest.Detail.DetailRepository;
import com.capstone.teamProj_10.apiTest.Detail.DetailTable;
import com.capstone.teamProj_10.apiTest.valTable.TableDto;
import com.capstone.teamProj_10.apiTest.valTable.TableRepository;
import com.capstone.teamProj_10.apiTest.valTable.ValTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final RegionService regionService;
    private final ApiService apiService;
    private final TableRepository tableRepository;
    private final DetailRepository detailRepository;
    private final VolunteerService volunteerService;


    @GetMapping("/")
    public String index(Model model) {
        List<String> regionList = regionService.getRegionList();
        List<String> categoryList = volunteerService.getUpperClCode();
        List<ValTable> valTables = tableRepository.findAll();
        model.addAttribute("regions", regionList);
        model.addAttribute("clCodes",categoryList);
        model.addAttribute("valTables",valTables);
        return "index";
    }

    @GetMapping("/getSigunguList")
    @ResponseBody
    public List<String> getSigunguList(@RequestParam String region) {
        return regionService.getSigunguList(region);
    }
    @GetMapping("/getClCodeList")
    @ResponseBody
    public List<String> getClCodeList(@RequestParam String clCode){
        return volunteerService.getNanmClCode(clCode);
    }

    @PostMapping("/search")
    public List<ValTable> getItems(@RequestParam String sido, @RequestParam String sigungu, @RequestParam String nanmClCode, @RequestParam String upperClCode) {
        List<ValTable> valTableList = new ArrayList<>();
        int pageNo = 1;
        while(true) {
            String result = regionService.searchAddress(upperClCode,nanmClCode, sido, sigungu, pageNo);
            List<TableDto> tableDtoList = apiService.fromJSONtoItems(result);
            if (tableDtoList.isEmpty()) {
                break;
            }
            for (TableDto tableDto : tableDtoList) {
                ValTable valTable = new ValTable(tableDto);
                apiService.saveTable(valTable);
                valTableList.add(valTable);
            }
            pageNo++;
        }
        return valTableList;
    }
    @PostMapping("/search2")
    public List<DetailTable> getDetails() throws Exception {
        List<Long> allProgrmRegistNos = detailRepository.findAllProgrmRegistNos();
        List<DetailTable>datailTableList = new ArrayList<>();
        for(Long progrmRegistNo: allProgrmRegistNos) {
            String result = regionService.searchDetail(progrmRegistNo);
            List<DetailDto> detailDtoList = apiService.fromJSONtoItems2(result);
            for (DetailDto detailDto : detailDtoList) {
                DetailTable detailTable = new DetailTable(detailDto);
                detailRepository.save(detailTable);
                datailTableList.add(detailTable);
            }
        }
        return datailTableList;
    }
    @GetMapping("/{progrmRegistNo}/detail")
    public String detailPage(@PathVariable Long progrmRegistNo, Model model) {
        Optional<DetailTable> optionalDetail = Optional.ofNullable(detailRepository.findOne(progrmRegistNo));
        if (optionalDetail.isPresent()) {
            DetailTable detailTable = optionalDetail.get();
            model.addAttribute("detail", detailTable);
        }
        return "detail"; // detail is the HTML file name
    }

}

