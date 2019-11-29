package com.deloitte.training.oodesignpatterns.structural.proxy2;

public interface TwitterService {

    public String getTimeline(String screenName);

    public void postToTimeline(String screenName, String message);


}
