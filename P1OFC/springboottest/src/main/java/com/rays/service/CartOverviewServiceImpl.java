package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CartOverviewDAOImpl;
import com.rays.dto.CartOverviewDTO;

@Service
@Transactional
public class CartOverviewServiceImpl extends BaseServiceImpl<CartOverviewDTO, CartOverviewDAOImpl> implements CartOverviewServiceInt{
    
}
