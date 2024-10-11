package com.morealva.service.impl;

import com.morealva.repository.IGenericRepo;
import com.morealva.service.ICRUD;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t){
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t){
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException());
    }

}
