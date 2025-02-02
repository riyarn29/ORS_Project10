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
import com.rays.dto.PortfolioDTO;
import com.rays.form.PortfolioForm;
import com.rays.service.PortfolioServiceInt;

@RestController
@RequestMapping(value = "Portfolio")
public class PortfolioCtl extends BaseCtl<PortfolioForm, PortfolioDTO, PortfolioServiceInt> {

    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> levelMap = new HashMap<>();
        levelMap.put(1, "first");
        levelMap.put(2, "second");
       

        List<Map<String, Object>> levelList = new ArrayList<>();
        levelMap.forEach((key, value) -> {
            Map<String, Object> item = new HashMap<>();
            item.put("key", key);
            item.put("value", value);
            levelList.add(item);
        });

        res.addResult("levelList", levelList);

        return res;
    }
}
