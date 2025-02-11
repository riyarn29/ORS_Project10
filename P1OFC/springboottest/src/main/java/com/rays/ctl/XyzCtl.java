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
import com.rays.dto.XyzDTO;
import com.rays.form.XyzForm;
import com.rays.service.XyzServiceInt;

@RestController
@RequestMapping(value = "Xyz")
public class XyzCtl extends BaseCtl<XyzForm, XyzDTO, XyzServiceInt> {

    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> productMap = new HashMap<>();
        productMap.put(1, "Fan");
        productMap.put(2, "TV");
       

        List<Map<String, Object>> productList = new ArrayList<>();
        productMap.forEach((key, value) -> {
            Map<String, Object> item = new HashMap<>();
            item.put("key", key);
            item.put("value", value);
            productList.add(item);
        });

        res.addResult("productList", productList);

        return res;
    }
}
