package com.mhp.coding.challenges.dependency.notifications

import com.mhp.coding.challenges.dependency.inquiry.Inquiry
import com.mhp.coding.challenges.dependency.inquiry.InquiryServiceEvent
import mu.KotlinLogging
import org.springframework.stereotype.Component

import org.springframework.context.ApplicationListener;

private val logger = KotlinLogging.logger {}

/*
 * This class now implements the ApplicationListener interface to be able to
 * listen to the custom ApplicationEvents, i.e. InquiryServiceEvents
 */
@Component
class PushNotificationHandler : ApplicationListener<InquiryServiceEvent> {
    fun sendNotification(inquiry: Inquiry) {
        logger.info {
            "Sending push notification for: $inquiry"
        }
    }
    
    /* 
     * This function is executed when the listener notices an 
     * InquiryServiceEvent. 
     * It calls the sendNotification() function with the inquiry property of
     * the InquiryServiceEvent
     */
    override fun onApplicationEvent(event : InquiryServiceEvent) {
        sendNotification(event.inquiry)
    }
}
