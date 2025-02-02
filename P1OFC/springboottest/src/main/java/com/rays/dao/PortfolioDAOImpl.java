package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CustomerDTO;
import com.rays.dto.PortfolioDTO;

@Repository
public class PortfolioDAOImpl extends BaseDAOImpl<PortfolioDTO> implements PortfolioDAOInt {

    @Override
    protected List<Predicate> getWhereClause(PortfolioDTO dto, CriteriaBuilder builder, Root<PortfolioDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<>();

        if (dto.getId() != null && dto.getId() > 0) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

        if (dto.getName() != null && !dto.getName().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
        }
        
        
        if (dto.getLevel()!= null && !dto.getLevel().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("level"), dto.getLevel() + "%"));
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
    public Class<PortfolioDTO> getDTOClass() {
        return PortfolioDTO.class;
    }
}
