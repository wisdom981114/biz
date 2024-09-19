package com.capstone.teamProj_10.apiTest.Detail;

import com.capstone.teamProj_10.apiTest.valTable.ValTable;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DetailRepository {
    private final EntityManager em;
    @Transactional
    public void save(DetailTable DetailTable){
        if(DetailTable.getProgrmRegistNo() == null){
            em.persist(DetailTable);
        }else{
            em.merge(DetailTable);
        }
    }
    public DetailTable findOne(Long progrmRegistNo){return em.find(DetailTable.class, progrmRegistNo);}
    public List<Long> findAllProgrmRegistNos(){
        return em.createQuery("select v.progrmRegistNo from ValTable v", Long.class).getResultList();
    }
}
