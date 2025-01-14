package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ABCDTO;


@Repository
public class AbcDAOImpl extends BaseDAOImpl<ABCDTO> implements AbcDAOInt {

    @Override
    protected List<Predicate> getWhereClause(ABCDTO dto, CriteriaBuilder builder, Root<ABCDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<>();

        if (dto.getId() != null && dto.getId() > 0) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

        if (dto.getName() != null && !dto.getName().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
        }
        
        if (dto.getOverview() != null && !dto.getOverview().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("overview"), "%" + dto.getOverview() + "%"));
        }
        
        if (dto.getAnalysisType() != null && !dto.getAnalysisType().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("analysisType"), dto.getAnalysisType() + "%"));
        }
        
        if (dto.getEndDate() != null) {
            whereCondition.add(builder.equal(qRoot.get("endDate"), dto.getEndDate()));
        }
        
        if (dto.getStartDate() != null) {
            whereCondition.add(builder.equal(qRoot.get("startDate"), dto.getStartDate()));
        }

        
        if (dto.getCoverageAmount() != null) {
            whereCondition.add(builder.equal(qRoot.get("coverageAmount"), dto.getCoverageAmount()));
        }

       
        if (dto.getQuantity() != null) {
            whereCondition.add(builder.equal(qRoot.get("quantity"), dto.getQuantity()));
        }

       
        if (dto.getLatitude() != null) {
            whereCondition.add(builder.equal(qRoot.get("latitude"), dto.getLatitude()));
        }

   
        if (dto.getLongitude() != null) {
            whereCondition.add(builder.equal(qRoot.get("longitude"), dto.getLongitude()));
        }

        return whereCondition;
    }

    @Override
    public Class<ABCDTO> getDTOClass() {
        return ABCDTO.class;
    }
}
