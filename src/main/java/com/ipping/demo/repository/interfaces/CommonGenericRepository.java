package com.ipping.demo.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonGenericRepository<T> extends JpaRepository<T, Long> {

}
