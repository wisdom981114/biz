package com.capstone.teamProj_10.apiTest.valTable;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class TableRepository  {
    private final EntityManager em;
    @Transactional
    public void save(ValTable valTable){
        if(valTable.getProgrmRegistNo() == null){
            em.persist(valTable);
        }else{
            em.merge(valTable);
        }
    }
    public ValTable findOne(Long progrmRegistNo){return em.find(ValTable.class, progrmRegistNo);}
    public List<ValTable> findAll(){
        return em.createQuery("select v from ValTable v", ValTable.class).getResultList();
    }
}
