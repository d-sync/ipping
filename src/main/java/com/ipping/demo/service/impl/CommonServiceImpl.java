package com.ipping.demo.service.impl;

import com.ipping.demo.repository.interfaces.CommonGenericRepository;
import com.ipping.demo.service.interfaces.CommonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CommonServiceImpl<T> implements CommonService<T> {
    @Autowired
    private CommonGenericRepository<T> repository;

    @Override
    public T get(Long id) {
        Optional<T> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Override
    public T add(T entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public void update(T entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }
}
