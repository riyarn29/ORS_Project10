package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.FollowUpDTO;
import com.rays.dto.PortfolioDTO;

@Repository
public class FollowUpDAOImpl extends BaseDAOImpl<FollowUpDTO> implements FollowUpDAOInt {

    @Override
    protected List<Predicate> getWhereClause(FollowUpDTO dto, CriteriaBuilder builder, Root<FollowUpDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<>();

        if (dto.getId() != null && dto.getId() > 0) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

        if (dto.getClient() != null && !dto.getClient().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("client"), dto.getClient() + "%"));
        }
        
        
        if (dto.getPhysician()!= null && !dto.getPhysician().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("physician"), dto.getPhysician() + "%"));
        }
        
       
        
        if (dto.getAppointmentDate() != null) {
            whereCondition.add(builder.equal(qRoot.get("appointmentDate"), dto.getAppointmentDate()));
        }
        
        
        if (dto.getCharges() != null) {
            whereCondition.add(builder.equal(qRoot.get("charges"), dto.getCharges()));
        }

        

        return whereCondition;
    }

    @Override
    public Class<FollowUpDTO> getDTOClass() {
        return FollowUpDTO.class;
    }
}
