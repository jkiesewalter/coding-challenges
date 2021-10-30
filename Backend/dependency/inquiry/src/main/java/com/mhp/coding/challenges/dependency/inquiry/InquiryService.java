package com.mhp.coding.challenges.dependency.inquiry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationEventPublisher;

/*
 * This tutorial to Spring events was used to solve the challenge: 
 * https://www.baeldung.com/spring-events
 */
@Component
public class InquiryService {

    private static final Logger LOG = LoggerFactory.getLogger(InquiryService.class);
    
    // Publisher for the custom ApplicationEvent
    // use @Autowired for automatic dependency injection by Spring
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void create(final Inquiry inquiry) {
        LOG.info("User sent inquiry: {}", inquiry);
        
        // create an event that contains the inquiry for the listeners,
        // i.e. the PushNotificationHandler and the EmailHandler
        InquiryServiceEvent event = new InquiryServiceEvent(this, inquiry);
        // publish the event
        eventPublisher.publishEvent(event);
    }

}
