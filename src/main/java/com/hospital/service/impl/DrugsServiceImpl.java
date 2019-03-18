package com.hospital.service.impl;

import com.hospital.common.CommonService;
import com.hospital.dao.DrugsMapper;
import com.hospital.entity.Drugs;
import com.hospital.service.DrugsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugsServiceImpl implements DrugsService {
    @Autowired
    DrugsMapper drugsMapper;

    @Override
    public List<Drugs> getAllDrugs() {
        return drugsMapper.findAll();
    }

    @Override
    public String delDrug(Integer id) {
        return drugsMapper.deleteByPrimaryKey(id)>0? CommonService.del_message_success:CommonService.del_message_error;
    }

    @Override
    public String addDrug(Drugs drugs) {
        String message;
        if(drugsMapper.findByName(drugs.getName())!=null){
            message=CommonService.add_message_error2;
        }
        else{
            message=drugsMapper.insert(drugs)>0?CommonService.add_message_success:CommonService.add_message_error;
        }
        return message;
    }
}
