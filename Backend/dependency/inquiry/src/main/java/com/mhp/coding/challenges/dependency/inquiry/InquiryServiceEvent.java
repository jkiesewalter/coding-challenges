package com.mhp.coding.challenges.dependency.inquiry;

import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationEvent;

/*
 * This class is used to create custom Spring ApplicationEvents.
 * The inquiry an event is connected to is contained in the inquiry property.
 * This tutorial to Spring events was used to solve the challenge: 
 * https://www.baeldung.com/spring-events
 */
public class InquiryServiceEvent extends ApplicationEvent {

    private Inquiry inquiry;
    
    public InquiryServiceEvent(Object _eventSource, Inquiry _inquiry) {
        super(_eventSource);
        inquiry = _inquiry;
    }
    
    public Inquiry getInquiry() {
        return inquiry;
    }
}
