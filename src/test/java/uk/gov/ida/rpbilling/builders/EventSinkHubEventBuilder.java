package uk.gov.ida.rpbilling.builders;

import uk.gov.ida.common.ServiceInfoConfiguration;
import uk.gov.ida.common.SessionId;
import uk.gov.ida.eventsink.EventDetailsKey;
import uk.gov.ida.eventsink.EventSinkHubEvent;
import uk.gov.ida.eventsink.EventSinkHubEventConstants;

import java.util.HashMap;
import java.util.Map;

public class EventSinkHubEventBuilder {

    private String serviceName = "service-name";
    private String sessionId = "session-id";
    private String pid = "some-pid-we-dont-care-about";
    private String idpEntityId = "some-idp-entity-id-we-dont-care-about";
    private String transactionEntityId = "transaction-entity-id";
    private Map<EventDetailsKey, String> details = new HashMap<>();
    private String eventType = "event-type";
    private String requestId = "requestId";

    public static EventSinkHubEvent anAuthnSuccessHubEvent() {
        return new EventSinkHubEventBuilder().withEventType(EventSinkHubEventConstants.SessionEvents.IDP_AUTHN_SUCCEEDED).build();
    }

    public EventSinkHubEvent build() {
        details.put(EventDetailsKey.transaction_entity_id, transactionEntityId);
        details.put(EventDetailsKey.idp_entity_id, idpEntityId);
        details.put(EventDetailsKey.pid, pid);
        details.put(EventDetailsKey.request_id, requestId);

        return new EventSinkHubEvent(
                new ServiceInfoConfiguration(serviceName),
                new SessionId(sessionId),
                eventType,
                details
        );
    }

    public EventSinkHubEventBuilder withServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public EventSinkHubEventBuilder withSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public EventSinkHubEventBuilder withPid(String pid) {
        this.pid = pid;
        return this;
    }

    public EventSinkHubEventBuilder withIdpEntityId(String idpEntityId) {
        this.idpEntityId = idpEntityId;
        return this;
    }

    public EventSinkHubEventBuilder withTransactionEntityId(String transactionEntityId) {
        this.transactionEntityId = transactionEntityId;
        return this;
    }

    public EventSinkHubEventBuilder withEventType(String eventType) {
        this.eventType = eventType;
        return this;
    }

    public EventSinkHubEventBuilder withRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

}
