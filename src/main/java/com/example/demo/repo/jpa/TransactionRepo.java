package com.example.demo.repo.jpa;

import com.example.demo.entity.FwkTransactionHst;
import com.example.demo.entity.FwkTransactionHstId;
import org.springframework.data.repository.CrudRepository;

// DAO 객체
// CrudRepository<객체 타입, PK 타입>
public interface TransactionRepo extends CrudRepository<FwkTransactionHst, FwkTransactionHstId> {

}
