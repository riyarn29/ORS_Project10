package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CustomerDTO;

@Repository
public class CustomerDAOImpl extends BaseDAOImpl<CustomerDTO> implements CustomerDAOInt {

    @Override
    protected List<Predicate> getWhereClause(CustomerDTO dto, CriteriaBuilder builder, Root<CustomerDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<>();

        if (dto.getId() != null && dto.getId() > 0) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

        if (dto.getName() != null && !dto.getName().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
        }
        
        
        if (dto.getAnalysisType() != null && !dto.getAnalysisType().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("analysisType"), dto.getAnalysisType() + "%"));
        }
        
       
        
        if (dto.getStartDate() != null) {
            whereCondition.add(builder.equal(qRoot.get("startDate"), dto.getStartDate()));
        }
        
        
        if (dto.getAmount() != null) {
            whereCondition.add(builder.equal(qRoot.get("amount"), dto.getAmount()));
        }

        

        return whereCondition;
    }

    @Override
    public Class<CustomerDTO> getDTOClass() {
        return CustomerDTO.class;
    }
}
