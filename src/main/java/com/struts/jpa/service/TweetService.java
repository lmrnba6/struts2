package com.struts.jpa.service;

import com.struts.jpa.model.Tweet;
import com.struts.jpa.model.User;
import com.struts.jpa.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TweetService {
    @Autowired
    TweetRepository<Tweet> tweetRepository;

    @Transactional
    public List<Tweet> getAllTweets() {
        return (List<Tweet>) tweetRepository.findAll();
    }

    @Transactional
    public List<Tweet> findByUser(User u) {
        return (List<Tweet>) tweetRepository.findByUser(u);
    }

    @Transactional
    public Optional<Tweet> getById(Long id) {
        return tweetRepository.findById(id);
    }

    @Transactional
    public void deleteTweet(Tweet u) {
        tweetRepository.delete(u);
    }

    @Transactional
    public Tweet addTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Transactional
    public boolean updateTweet(Tweet tweet) {
        return tweetRepository.save(tweet) != null;
    }
}
