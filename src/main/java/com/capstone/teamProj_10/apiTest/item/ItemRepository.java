package com.capstone.teamProj_10.apiTest.item;



import com.capstone.teamProj_10.apiTest.item.Product;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    private final EntityManager em;

    public void saveAll(List<Product> items){
        for (Product item : items){
            em.persist(item);
        }
    }

    public void save(Product item){
        if(item.getId() == null){
            em.persist(item);
        }else{
            em.merge(item);
        }
    }
    public Product findOne(Long id){
        return em.find(Product.class, id);
    }
    public List<Product> findAll(){
        return em.createQuery("select i from Product i",Product.class)
                .getResultList();
    }

}
