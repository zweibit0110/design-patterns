package com.deloitte.training.oodesignpatterns.behavioral.observer;

public class ObserverPatternTest {

    public static void main(String[] args) {
        //create subject
        Topic topic = new Topic();

        //create observers
        Observer observer = new TopicSubscriber("First observer", topic);
        Observer observer2 = new TopicSubscriber("Second observer", topic);
        Observer observer3 = new TopicSubscriber("Third observer", topic);

        //register observers to the subject
        topic.register(observer);
        topic.register(observer2);
        topic.register(observer3);

        //check if any update is available
        observer.update();

        //now send message to subject
        topic.postMessage("a message");

        topic.unregister(observer);

        topic.postMessage("another message");
    }
    
}
