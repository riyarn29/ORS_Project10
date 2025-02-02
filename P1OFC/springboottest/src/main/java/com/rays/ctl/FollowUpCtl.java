package com.rays.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.FollowUpDTO;
import com.rays.form.FollowUpForm;
import com.rays.service.FollowUpServiceInt;

@RestController
@RequestMapping(value = "FollowUp")
public class FollowUpCtl extends BaseCtl<FollowUpForm, FollowUpDTO, FollowUpServiceInt> {

    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> clientMap = new HashMap<>();
        clientMap.put(1, "Diabetic");
        clientMap.put(2, "High BP");
       

        List<Map<String, Object>> clientList = new ArrayList<>();
        clientMap.forEach((key, value) -> {
            Map<String, Object> item = new HashMap<>();
            item.put("key", key);
            item.put("value", value);
            clientList.add(item);
        });

        res.addResult("clientList", clientList);

        return res;
    }
    
    
    
    @GetMapping("/preloadd")
    public ORSResponse preloadd() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> physicianMap = new HashMap<>();
        physicianMap.put(1, "Riya");
        physicianMap.put(2, "Ankit");
       

        List<Map<String, Object>> physicianList = new ArrayList<>();
        physicianMap.forEach((key, value) -> {
            Map<String, Object> item = new HashMap<>();
            item.put("key", key);
            item.put("value", value);
            physicianList.add(item);
        });

        res.addResult("physicianList", physicianList);

        return res;
    }
    
    
    
    
    
}
