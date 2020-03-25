package com.struts.jpa.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.struts.jpa.model.Tweet;
import com.struts.jpa.model.User;
import com.struts.jpa.service.TweetService;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class TweetAction extends ActionSupport implements SessionAware, ModelDriven<Tweet>, Preparable {

    @Autowired
    private TweetService tweetService;
    public Tweet tweet = new Tweet();
    public List<Tweet> tweets;
    Map<String, Object> session;

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    void runJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        System.out.println("Starting the batch job");
        try {
            JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Job Status : " + execution.getStatus());
            System.out.println("Job completed");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Job failed");
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void prepare() throws Exception {
        tweets = tweetService.findByUser((User) this.session.get("user"));
        session.put("tweets", tweets);
    }

    @SkipValidation
    public String tweet() {
        return ActionSupport.SUCCESS;
    }

    @SkipValidation
    public String add() {
        return ActionSupport.SUCCESS;
    }

    @Override
    public void validate() {
        if (tweet.getTitle() == null || tweet.getTitle().isEmpty()) {
            addFieldError("title", "Title is Required");
        }
        if (tweet.getText() == null || tweet.getText().isEmpty()) {
            addFieldError("text", "Text is Required");
        }
    }

    public String addTweet() {
        tweet.setUser((User) this.session.get("user"));
        Tweet t = tweetService.addTweet(tweet);
        if (t != null) {
            return ActionSupport.SUCCESS;
        }
        addActionError("Wrong username or password");
        return ActionSupport.ERROR;
    }

    public String updateTweet() {
        tweet.setUser((User) this.session.get("user"));
        boolean t = tweetService.updateTweet(tweet);
        if (t) {
            return ActionSupport.SUCCESS;
        }
        addActionError("Error happened");
        return ActionSupport.ERROR;
    }

    @SkipValidation
    public String deleteTweet() {
        tweetService.deleteTweet(tweet);
        return ActionSupport.SUCCESS;
    }

    @SkipValidation
    public String editTweet() {
        tweet = tweetService.getById(Long.valueOf(tweet.getId())).orElse(new Tweet());
        return ActionSupport.SUCCESS;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    @Override
    public Tweet getModel() {
        return tweet;
    }

}
