package com.repository.impl;

import com.model.Listen;
import com.repository.IListenRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ListenRepositoryImpl implements IListenRepository {
    @Override
    public List<Listen> findAll() {
        TypedQuery<Listen> query = BaseRepository.entityManager.createQuery
                ("select s from Listen as s", Listen.class);
        return query.getResultList();
    }

    @Override
    public Listen findById(int id) {
        TypedQuery<Listen> query = BaseRepository.entityManager.createQuery
                ("select s from Listen as s where s.id = :id", Listen.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void create(Listen listen) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(listen);
        entityTransaction.commit();
    }

    @Override
    public void update(int id, Listen listen) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(listen);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Listen.class, id));
        entityTransaction.commit();
    }

    @Override
    public List<Listen> search(String name) {
        TypedQuery<Listen> query = BaseRepository.entityManager.createQuery
                ("select s from Listen s where s.listenName like :name", Listen.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
