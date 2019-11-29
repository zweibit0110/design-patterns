package com.deloitte.training.oodesignpatterns.behavioral.observer;

public class TopicSubscriber implements Observer {

    private String name;

    private Subject topic;

    public TopicSubscriber(String nm, Subject topic) {
        this.name = nm;
        this.topic = topic;
    }

    @Override
    public void update() {
        if (topic != null) {
            String msg = (String) topic.getMessage(this);
            if (msg == null) {
                System.out.println(name + ":: No new message");
            } else {
                System.out.println(name + ":: Consuming message::" + msg);
            }
        }
    }

}
