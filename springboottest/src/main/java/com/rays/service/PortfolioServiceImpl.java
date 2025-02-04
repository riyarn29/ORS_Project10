package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.PortfolioDAOImpl;
import com.rays.dto.PortfolioDTO;

@Service
@Transactional
public class PortfolioServiceImpl extends BaseServiceImpl<PortfolioDTO, PortfolioDAOImpl> implements PortfolioServiceInt {
    
}
