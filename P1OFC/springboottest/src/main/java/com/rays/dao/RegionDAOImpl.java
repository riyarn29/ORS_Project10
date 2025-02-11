package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.RegionDTO;

@Repository
public class RegionDAOImpl extends BaseDAOImpl<RegionDTO> implements RegionDAOInt {

    @Override
    protected List<Predicate> getWhereClause(RegionDTO dto, CriteriaBuilder builder, Root<RegionDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<>();

        if (dto.getId() != null && dto.getId() > 0) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

        if (dto.getState() != null && !dto.getState().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("state"), dto.getState() + "%"));
        }
        
        
        if (dto.getRegion()!= null && !dto.getRegion().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("region"), dto.getRegion() + "%"));
        }
        
       
        
        if (dto.getLatitude() != null) {
            whereCondition.add(builder.equal(qRoot.get("latitude"), dto.getLatitude()));
        }
        
        
        if (dto.getPrice() != null) {
            whereCondition.add(builder.equal(qRoot.get("price"), dto.getPrice()));
        }

        

        return whereCondition;
    }

    @Override
    public Class<RegionDTO> getDTOClass() {
        return RegionDTO.class;
    }
}
