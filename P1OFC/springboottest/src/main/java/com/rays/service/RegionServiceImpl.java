package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.PortfolioDAOImpl;
import com.rays.dao.RegionDAOImpl;
import com.rays.dto.PortfolioDTO;
import com.rays.dto.RegionDTO;

@Service
@Transactional
public class RegionServiceImpl extends BaseServiceImpl<RegionDTO, RegionDAOImpl> implements RegionServiceInt {
    
}
