package com.example.springdemo.service;

import com.example.springdemo.dto.NoteListDTO;

import java.util.List;
import java.util.Map;


/**
 * 比心合伙人
 * Created by 吴晓雷 20191015
 */
public interface NoteService {


    /*
     *
     * @param dateStart
     * @param dateEnd
     * @param dateType
     * @return
     */



    List<NoteListDTO> queryNote(String categoryId);

}
