package com.struts.jpa.repository;

import com.mysema.query.hql.jpa.JPAQuery;
import com.struts.jpa.model.QUser;
import com.struts.jpa.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    EntityManager em;

    public User findByUserNameAndPassword(String userName, String password) {
        JPAQuery query = new JPAQuery(em);
        QUser u = QUser.user;
        return query.from(u).where(u.userName.eq(userName).and(u.password.eq(password))).uniqueResult(u);
    }

    public User findByUserName(String userName) {
        JPAQuery query = new JPAQuery(em);
        QUser u = QUser.user;
        return query.from(u).where(u.userName.eq(userName)).uniqueResult(u);
    }
}
