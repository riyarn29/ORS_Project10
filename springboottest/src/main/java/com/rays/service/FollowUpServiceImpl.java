package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.FollowUpDAOImpl;
import com.rays.dto.FollowUpDTO;

@Service
@Transactional
public class FollowUpServiceImpl extends BaseServiceImpl<FollowUpDTO, FollowUpDAOImpl> implements FollowUpServiceInt {
    
}
