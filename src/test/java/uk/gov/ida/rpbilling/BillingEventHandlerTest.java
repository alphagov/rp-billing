package uk.gov.ida.rpbilling;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.gov.ida.common.ServiceInfoConfiguration;
import uk.gov.ida.common.SessionId;
import uk.gov.ida.eventsink.EventDetailsKey;
import uk.gov.ida.eventsink.EventSinkHubEvent;
import uk.gov.ida.rpbilling.builders.EventSinkHubEventBuilder;
import uk.gov.ida.rpbilling.dto.RpBillingEventRecord;

import java.util.Collections;
import java.util.HashMap;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BillingEventHandlerTest {

    @Mock
    BillingRepository billingRepository;

    BillingEventHandler billingEventHandler;

    @Before
    public void setUp() throws Exception {
        billingEventHandler = new BillingEventHandler(billingRepository);
    }

    @Test
    public void shouldValidateAndAddEventToRepository() throws Exception {
        EventSinkHubEvent event = EventSinkHubEventBuilder.anAuthnSuccessHubEvent();
        billingEventHandler.handleEvent(event);
        verify(billingRepository).add(any(RpBillingEventRecord.class));
    }

}
