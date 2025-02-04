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
import com.rays.dto.ABCDTO;
import com.rays.form.AbcForm;
import com.rays.service.AbcServiceInt;

@RestController
@RequestMapping(value = "Abc")
public class AbcCtl extends BaseCtl<AbcForm, ABCDTO, AbcServiceInt> {

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);

		HashMap<Integer, String> typeMap = new HashMap<>();
		typeMap.put(1, "Fundamental");
		typeMap.put(2, "Technical");

		List<Map<String, Object>> typeList = new ArrayList<>();
		typeMap.forEach((key, value) -> {
			Map<String, Object> item = new HashMap<>();
			item.put("key", key);
			item.put("value", value);
			typeList.add(item);
		});

		res.addResult("typeList", typeList);

		return res;
	}
}
