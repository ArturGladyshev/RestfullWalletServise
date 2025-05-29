package org.example.walletRESTapi.repository;

import java.util.List;

public abstract class AbstractDao<T> {

    public abstract T getById(String uuid);

    public abstract List<T> getAll();

    public abstract T create(final T entity);

    public abstract T update(final T entity);

    public abstract void delete(final T entity);

    public abstract void deleteById(String uuid);
}
