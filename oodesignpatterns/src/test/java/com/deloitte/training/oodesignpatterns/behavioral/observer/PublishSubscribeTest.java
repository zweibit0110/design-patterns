package com.deloitte.training.oodesignpatterns.behavioral.observer;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class PublishSubscribeTest {

    private Topic topic;

    private Observer firstObserver;

    private Observer secondObserver;

    @Before
    public void setup() {
        topic = new Topic();

        firstObserver = mock(TopicSubscriber.class);
        secondObserver = mock(TopicSubscriber.class);

        topic.register(firstObserver);
        topic.register(secondObserver);
    }

    @Test
    public void subscribersDoesntReceiveAnything() {
        topic.notifyObservers();
        
        verify(firstObserver, times(0)).update();
        verify(secondObserver, times(0)).update();
    }

    @Test
    public void subscribersReceivePublishedMessage() {
        topic.postMessage("a message");

        verify(firstObserver).update();
        verify(secondObserver).update();

        topic.unregister(firstObserver);

        topic.postMessage("another message");

        verify(firstObserver, times(1)).update();
        verify(secondObserver, times(2)).update();

        topic.unregister(secondObserver);

        topic.postMessage("third message");

        verify(firstObserver, times(1)).update();
        verify(secondObserver, times(2)).update();
    }

}
