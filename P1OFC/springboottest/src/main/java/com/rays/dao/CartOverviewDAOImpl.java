package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CartOverviewDTO;
import com.rays.dto.PortfolioDTO;

@Repository
public class CartOverviewDAOImpl extends BaseDAOImpl<CartOverviewDTO> implements CartOverviewDAOInt {

    @Override
    protected List<Predicate> getWhereClause(CartOverviewDTO dto, CriteriaBuilder builder, Root<CartOverviewDTO> qRoot) {

        List<Predicate> whereCondition = new ArrayList<>();

        if (dto.getId() != null && dto.getId() > 0) {
            whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
        }

        if (dto.getCustomerName() != null && !dto.getCustomerName().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("customerName"), dto.getCustomerName() + "%"));
        }
        
        
        if (dto.getProduct()!= null && !dto.getProduct().isEmpty()) {
            whereCondition.add(builder.like(qRoot.get("product"), dto.getProduct() + "%"));
        }
        
       
        
        if (dto.getTransactionDate() != null) {
            whereCondition.add(builder.equal(qRoot.get("transactionDate"), dto.getTransactionDate()));
        }
        
        
        if (dto.getQuantity() != null) {
            whereCondition.add(builder.equal(qRoot.get("quantity"), dto.getQuantity()));
        }

        

        return whereCondition;
    }

    @Override
    public Class<CartOverviewDTO> getDTOClass() {
        return CartOverviewDTO.class;
    }
}
