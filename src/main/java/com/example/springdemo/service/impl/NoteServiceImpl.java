package com.example.springdemo.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.springdemo.dto.NoteListDTO;
import com.example.springdemo.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.*;

import com.alibaba.fastjson.JSONObject;

@Service("PartnerService")
public class NoteServiceImpl implements NoteService {


    //@Resource
    //private PartnerMapper partnerMapper;


    //趋势图
    @Override
    public List<NoteListDTO> queryNote(String categoryId){
        List<String> list = new ArrayList<>();
        //list = partnerMapper.queryPartnerCostDay( dateStart, dateEnd);

        String content = "[" +
                "{\"app_thumb\": \"/uploads/pc/place2/2016-03-21/cbf9a441-a6cf-4141-88b6-0d0ea059e4da.jpg\",\n" +
                "\"day_count\": \"5\",\n" +
                "\"photoCount\": \"105\",\n" +
                "\"publish_time\": \"1458397860\",\n" +
                "\"title\": \"驴妈妈海岛季——三亚五日游\",\n" +
                "\"trip_id\": \"75788\",\n" +
                "\"uid\": \"4028b2595384617f01538df8c9fc067a\",\n" +
                "\"user_img\": \"http://pic.lvmama.com/uploads/pc/place2/2016-03-19//C_786b2a34-ded4-457b-94ed-11417f26f762.jpg\",\n" +
                "\"username\": \"loselv泡泡\"}," +
                "{\"app_thumb\": \"/uploads/pc/place2/2016-09-19/20ef289c-1739-4f26-9b20-1e5c768b2a26.jpg\",\n" +
                "\"day_count\": \"6\",\n" +
                "\"photoCount\": \"179\",\n" +
                "\"publish_time\": \"1471245492\",\n" +
                "\"title\": \"我只愿面朝大海，春暖花开——三亚\",\n" +
                "\"trip_id\": \"93781\",\n" +
                "\"uid\": \"2c9486ee5675402201568c192d572546\",\n" +
                "\"user_img\": \"http://pic.lvmama.com/uploads/header/default-photo.gif\",\n" +
                "\"username\": \"lv1577314zk6p\"}," +
                "{\"app_thumb\": \"/uploads/pc/place2/2016-09-19/20ef289c-1739-4f26-9b20-1e5c768b2a26.jpg\",\n" +
                "\"day_count\": \"6\",\n" +
                "\"photoCount\": \"179\",\n" +
                "\"publish_time\": \"1471245492\",\n" +
                "\"title\": \"我只愿面朝大海，春暖花开——三亚\",\n" +
                "\"trip_id\": \"93781\",\n" +
                "\"uid\": \"2c9486ee5675402201568c192d572546\",\n" +
                "\"user_img\": \"http://pic.lvmama.com/uploads/header/default-photo.gif\",\n" +
                "\"username\": \"lv1577314zk6p\"}," +
                "{\"app_thumb\": \"/uploads/pc/place2/2016-05-11/49474e09-3e45-4b89-adc5-7369c5d8b1e3.jpg\",\n" +
                "\"day_count\": \"1\",\n" +
                "\"photoCount\": \"34\",\n" +
                "\"publish_time\": \"1462976557\",\n" +
                "\"title\": \"【全民摄影季】三亚千古情魅力游\",\n" +
                "\"trip_id\": \"81572\",\n" +
                "\"uid\": \"3428a92f493cb1e101493f4bc34f00e7\",\n" +
                "\"user_img\": \"http://pic.lvmama.com/uploads/header/2c9488775c11dbcd015c2506a0b100c7.png\",\n" +
                "\"username\": \"筇开森\"}," +
                "{\"app_thumb\": \"/uploads/pc/place2/2016-08-29/736e4e26-305f-4c8a-bff0-cc1bb33aa79c.jpg\",\n" +
                "\"day_count\": \"5\",\n" +
                "\"photoCount\": \"18\",\n" +
                "\"publish_time\": \"1472433279\",\n" +
                "\"title\": \"遇上三亚蓝海梦幻游~\",\n" +
                "\"trip_id\": \"95141\",\n" +
                "\"uid\": \"2c9486e45651551701565365154d0632\",\n" +
                "\"user_img\": \"http://pic.lvmama.com/uploads/header/default-photo.gif\",\n" +
                "\"username\": \"广东风光国旅\"}," +
                "{\"app_thumb\": \"/uploads/pc/place2/2016-08-25/af687dc1-c399-40f6-9b05-15a7c6ccea37.jpg\",\n" +
                "\"day_count\": \"2\",\n" +
                "\"photoCount\": \"16\",\n" +
                "\"publish_time\": \"1471941725\",\n" +
                "\"title\": \"三亚双湾红树林酒店5天4晚自由行\",\n" +
                "\"trip_id\": \"95286\",\n" +
                "\"uid\": \"40288add3a07cb0c013a313bc4742e4d\",\n" +
                "\"user_img\": \"http://pic.lvmama.com/uploads/header/default-photo.gif\",\n" +
                "\"username\": \"lv15921470808\"}" +
                "]";

        JSONArray jsonArray = JSONArray.parseArray(content);
        JSONArray jsonArray1 = new JSONArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
            Set<String> keys = jsonObject2.keySet();
            for (String curKey : keys) {
                if (curKey.equalsIgnoreCase("title")) {
                    jsonObject2.put(curKey, jsonObject2.getString("title")+"--"+categoryId) ;
                }
            }
            jsonArray1.add(jsonObject2);
        }
//        List<NoteListDTO> cboardDataSyncDtos1 = JSON.parseArray(content,NoteListDTO.class);
        List<NoteListDTO> cboardDataSyncDtos1 = JSON.parseArray(jsonArray1.toString(),NoteListDTO.class);

//
//        Map m1 = new HashMap();
//        m1.put("list", cboardDataSyncDtos1);
//        Map m2 = new HashMap();
//        m2.put("itemCount", "437");
//        m2.put("page", "1");
//        m2.put("pageCount", "44");
//        m2.put("pageSize", "10");
//        m1.put("pages", m2);
//        System.out.println(m1);
//        switch (categoryId){
//            case "1":
//                list1 = cohortMapper.queryCohortDetailByDay("-",dateStart, dateEnd,isNewUser,channel,platformLower,version,isClick,gender,is_biggie,isAbroad);
//                list2 = cohortMapper.queryCohortDetailByDay(dimention,dateStart, dateEnd,isNewUser,channel,platformLower,version,isClick,gender,is_biggie,isAbroad);
//                break;
//            case "2":
//                list1 = cohortMapper.queryCohortDetailByWeek("-", dateStart, dateEnd, isNewUser, channel, platformLower, version, isClick, gender, is_biggie,isAbroad);
//                list2 = cohortMapper.queryCohortDetailByWeek(dimention,     dateStart, dateEnd, isNewUser, channel, platformLower, version, isClick, gender, is_biggie,isAbroad);
//                break;
//            case "3":
//                list1 = cohortMapper.queryCohortDetailByMonth("-",dateStart, dateEnd,isNewUser,channel,platformLower,version,isClick,gender,is_biggie,isAbroad);
//                list2 = cohortMapper.queryCohortDetailByMonth(dimention,dateStart, dateEnd,isNewUser,channel,platformLower,version,isClick,gender,is_biggie,isAbroad);
//                break;
        return cboardDataSyncDtos1;
    }


}
