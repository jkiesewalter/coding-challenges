package com.mhp.coding.challenges.dependency.notifications

import com.mhp.coding.challenges.dependency.inquiry.Inquiry
import com.mhp.coding.challenges.dependency.inquiry.InquiryServiceEvent
import com.mhp.coding.challenges.dependency.notifications.EmailHandler
import mu.KotlinLogging
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

import org.springframework.context.ApplicationListener;

private val logger = KotlinLogging.logger {}

/*
 * This class now implements the ApplicationListener interface to be able to
 * listen to the custom ApplicationEvents, i.e. InquiryServiceEvents
 */
@Component
class EmailHandler : ApplicationListener<InquiryServiceEvent> {
    fun sendEmail(inquiry: Inquiry) {
        logger.info {
            "Sending email for: $inquiry"
        }
    }
    
    /* 
     * This function is executed when the listener notices an 
     * InquiryServiceEvent. 
     * It calls the sendNotification() function with the inquiry property of
     * the InquiryServiceEvent
     */
    override fun onApplicationEvent(event : InquiryServiceEvent) {
        sendEmail(event.inquiry)
    }
}
