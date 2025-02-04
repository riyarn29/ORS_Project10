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
import com.rays.dto.RegionDTO;
import com.rays.form.PortfolioForm;
import com.rays.form.RegionForm;
import com.rays.service.PortfolioServiceInt;
import com.rays.service.RegionServiceInt;

@RestController
@RequestMapping(value = "Region")
public class RegionCtl extends BaseCtl<RegionForm, RegionDTO, RegionServiceInt> {

    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> regionMap = new HashMap<>();
        regionMap.put(1, "Arctic");
        regionMap.put(2, "Sahara");
       

        List<Map<String, Object>> regionList = new ArrayList<>();
        regionMap.forEach((key, value) -> {
            Map<String, Object> item = new HashMap<>();
            item.put("key", key);
            item.put("value", value);
            regionList.add(item);
        });

        res.addResult("regionList", regionList);

        return res;
    }
}
