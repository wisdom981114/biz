package com.capstone.teamProj_10.apiTest;

import com.capstone.teamProj_10.apiTest.Detail.DetailDto;
import com.capstone.teamProj_10.apiTest.valTable.TableDto;
import com.capstone.teamProj_10.apiTest.valTable.TableRepository;
import com.capstone.teamProj_10.apiTest.valTable.ValTable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Service
public class ApiService {

	private static final Logger LOGGER = Logger.getLogger(ApiService.class.getName());
	private final TableRepository tableRepository;

	public static String getApiResult(String upperClCode, String nanmClCode, String sidoCode, String sggCode , int pageNO) throws IOException {
		StringBuilder urlBuilder = new StringBuilder("http://openapi.1365.go.kr/openapi/service/rest/VolunteerPartcptnService/getVltrCategoryList"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" +
				URLEncoder.encode("biUvvXVBCb8f8q%2Fp%2FhWYlceUafaJtvCF2R192Pa9vBom32ZqYfeISvB%2FtmZjUF%2BYkWGRXtrHUF30frt5djd1vA%3D%3D", "UTF-8")); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("upperClCode", "UTF-8") + "=" + URLEncoder.encode(upperClCode, "UTF-8")); /*관심분야*/
		urlBuilder.append("&" + URLEncoder.encode("nanmClCode", "UTF-8") + "=" + URLEncoder.encode(nanmClCode, "UTF-8")); /*관심분야 하위*/
		urlBuilder.append("&" + URLEncoder.encode("schSido", "UTF-8") + "=" + URLEncoder.encode(sidoCode, "UTF-8")); /*시도코드*/
		urlBuilder.append("&" + URLEncoder.encode("schSign1", "UTF-8") + "=" + URLEncoder.encode(sggCode, "UTF-8")); /*시군구코드*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + (pageNO)); /*페이지넘버*/
		URL url = new URL(urlBuilder.toString());
		LOGGER.info("URL: " + url.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/xml; charset=utf-8");
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		String apiResult = sb.toString();
		LOGGER.info("API Result: " + apiResult);
		// API 결과를 JSON으로 변환
		String jsonResult = xmlToJson(apiResult);
		LOGGER.info("JSON Result: " + jsonResult);

		return jsonResult;
	}
	public static String getDetailResult(Long progrmRegistNo)throws Exception{
		StringBuilder urlBuilder = new StringBuilder("http://openapi.1365.go.kr/openapi/service/rest/VolunteerPartcptnService/getVltrPartcptnItem"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" +
				URLEncoder.encode("biUvvXVBCb8f8q%2Fp%2FhWYlceUafaJtvCF2R192Pa9vBom32ZqYfeISvB%2FtmZjUF%2BYkWGRXtrHUF30frt5djd1vA%3D%3D", "UTF-8")); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("progrmRegistNo", "UTF-8") + "=" + (progrmRegistNo)); /*프로그램 고유번호*/
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/xml; charset=utf-8");
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		String apiResult = sb.toString();
		LOGGER.info("API Result: " + apiResult);
		// API 결과를 JSON으로 변환
		String jsonResult = xmlToJson(apiResult);
		LOGGER.info("JSON Result: " + jsonResult);

		return jsonResult;
	}

	public static String xmlToJson(String str) {
		try {
			String xml = str;
			JSONObject jObject = XML.toJSONObject(xml);
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			Object json = mapper.readValue(jObject.toString(), Object.class);
			String output = mapper.writeValueAsString(json);
			return output;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
public List<TableDto> fromJSONtoItems(String result) {
	JSONObject rjson = new JSONObject(result);
	JSONObject responseBody = rjson.getJSONObject("response").getJSONObject("body");

	// Check if items is a JSONObject and if it has a key named "item"
	if(responseBody.has("items") && !responseBody.get("items").equals("")) {
		JSONArray items = responseBody.getJSONObject("items").getJSONArray("item");

		List<TableDto> itemDtoList = new ArrayList<>();

		// Check if items array is empty
		if(items.isEmpty()){
			return itemDtoList;
		}

		for (int i = 0; i < items.length(); i++) {
			JSONObject itemJson = items.getJSONObject(i);
			TableDto tableDto = new TableDto(itemJson);
			itemDtoList.add(tableDto);
		}

		return itemDtoList;
	}
	else {
		// return an empty list or handle this case accordingly
		return new ArrayList<>();
	}
}
	public List<DetailDto> fromJSONtoItems2(String result) {
		JSONObject rjson = new JSONObject(result);
		JSONObject responseBody = rjson.getJSONObject("response").getJSONObject("body");
		Object item = responseBody.getJSONObject("items").get("item");

		List<DetailDto> detailDtoList = new ArrayList<>();

		if (item instanceof JSONArray) {
			JSONArray details = (JSONArray) item;
			for (int i = 0; i < details.length(); i++) {
				JSONObject itemJson = details.getJSONObject(i);
				DetailDto detailDto = new DetailDto(itemJson);
				detailDtoList.add(detailDto);
			}
		} else if (item instanceof JSONObject) {
			JSONObject itemJson = (JSONObject) item;
			DetailDto detailDto = new DetailDto(itemJson);
			detailDtoList.add(detailDto);
		}

		return detailDtoList;
	}

	@Transactional
	public void saveTable(ValTable valTable){tableRepository.save(valTable);}
}



