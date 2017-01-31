package uk.gov.ida.rpbilling;

import com.google.inject.Inject;
import uk.gov.ida.eventsink.EventSinkHubEvent;
import uk.gov.ida.rpbilling.dto.RpBillingEventRecord;

public class BillingEventHandler {

    private final BillingRepository billingRepository;

    @Inject
    public BillingEventHandler(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public void handleEvent(EventSinkHubEvent event) {
        RpBillingEventRecord record = new RpBillingEventRecord(event.getTimestamp(), event.getDetails().get("pid"), event.getDetails().get("request_id"), event.getDetails().get("transaction_entity_id"));
        billingRepository.add(record);
    }
}
