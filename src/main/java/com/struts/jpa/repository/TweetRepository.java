package com.struts.jpa.repository;

import com.struts.jpa.model.Tweet;
import com.struts.jpa.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TweetRepository<P> extends CrudRepository<Tweet, Long> {
    List<Tweet> findByUser(User user);
}

