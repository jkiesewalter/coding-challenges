package com.mhp.coding.challenges.dependency.notifications;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import com.mhp.coding.challenges.dependency.inquiry.InquiryServiceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationListener;

/*
 * This class now implements the ApplicationListener interface to be able to
 * listen to the custom ApplicationEvents, i.e. InquiryServiceEvents
 * This tutorial to Spring events was used to solve the challenge: 
 * https://www.baeldung.com/spring-events
 */
@Component
public class EmailHandler implements ApplicationListener<InquiryServiceEvent> {

    private static final Logger LOG = 
        LoggerFactory.getLogger(EmailHandler.class);
    
    public void sendEmail(final Inquiry inquiry) {
        LOG.info("Sending email for: {}", inquiry);
    }
        
    /* 
     * This function is executed when the listener notices an 
     * InquiryServiceEvent. 
     * It calls the sendNotification() function with the inquiry property of
     * the InquiryServiceEvent
     */
    public void onApplicationEvent(final InquiryServiceEvent event) {
        this.sendEmail(event.getInquiry());
    }
}
