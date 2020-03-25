package com.struts.jpa.repository;

import com.mysema.query.hql.jpa.JPAQuery;
import com.struts.jpa.model.QTweet;
import com.struts.jpa.model.Tweet;
import com.struts.jpa.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class TweetRepositoryImpl implements TweetRepository {
    @PersistenceContext
    EntityManager em;

    public List<Tweet> findByUser(User user) {
        JPAQuery query = new JPAQuery(em);
        QTweet t = QTweet.tweet;
        return query.from(t).where(t.user.userName.eq(user.getUserName())).list(t);
    }

}
