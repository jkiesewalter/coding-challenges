package com.mhp.coding.challenges.dependency.inquiry

import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

private val logger = KotlinLogging.logger {}

@Component
class InquiryService(
    @Autowired private val eventPublisher : ApplicationEventPublisher
) {
    
    fun create(inquiry: Inquiry) {
        logger.info {
            "User sent inquiry: $inquiry"
        }
        // create an event that contains the inquiry for the listeners,
        // i.e. the PushNotificationHandler and the EmailHandler
        val event = InquiryServiceEvent(
            inquiry = inquiry,
            eventSource = this
        )
        // publish the event
        eventPublisher.publishEvent(event)
    }
}

/*
 * This class is used to create custom Spring ApplicationEvents.
 * The inquiry an event is connected to is contained in the inquiry property.
 */
class InquiryServiceEvent : ApplicationEvent {
    
    val inquiry : Inquiry
    
    constructor(inquiry : Inquiry, eventSource : Any) : super(eventSource) { 
        this.inquiry = inquiry 
    }
}

data class Inquiry(
    var username: String,
    var recipient: String,
    var text: String,
)
