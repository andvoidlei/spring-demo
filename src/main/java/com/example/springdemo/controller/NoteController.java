package com.example.springdemo.controller;



import com.example.springdemo.common.ResultWrapper;
import com.example.springdemo.dto.NoteListDTO;
import com.example.springdemo.service.NoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project Name:helloworld <br/>
 * Package Name:com.nasus.controller <br/>
 * Date:2019/1/5 13:59 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@RestController
@RequestMapping(value = "/note")
public class NoteController {


    @Resource
    private NoteService noteService;


    @GetMapping("/queryList")
    public ResultWrapper<NoteListDTO> queryNote(@RequestParam(value = "categoryId")String categoryId) {


        ResultWrapper<NoteListDTO> wrapper = new ResultWrapper<>();
        List<NoteListDTO> tradeNormalReport = noteService.queryNote(categoryId);
        wrapper.setData(tradeNormalReport);

        Map m2 = new HashMap();
        m2.put("itemCount", "437");
        m2.put("page", "1");
        m2.put("pageCount", "44");
        m2.put("pageSize", "10");
        wrapper.setPages(m2);
        return wrapper;

    }

}