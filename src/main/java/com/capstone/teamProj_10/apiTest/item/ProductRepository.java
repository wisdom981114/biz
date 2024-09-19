package com.capstone.teamProj_10.apiTest.item;

import com.capstone.teamProj_10.apiTest.item.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
