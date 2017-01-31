package uk.gov.ida.rpbilling;

import com.hubspot.dropwizard.guicier.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import uk.gov.ida.bundles.LoggingBundle;
import uk.gov.ida.bundles.MonitoringBundle;
import uk.gov.ida.bundles.ServiceStatusBundle;
import uk.gov.ida.rpbilling.config.RpBillingConfiguration;

public class RpBillingApplication extends Application<RpBillingConfiguration> {

    @Override
    public void initialize(Bootstrap<RpBillingConfiguration> bootstrap) {
        GuiceBundle<RpBillingConfiguration> guiceBundle = GuiceBundle.defaultBuilder(RpBillingConfiguration.class).modules(new RpBillingModule()).build();

        bootstrap.addBundle(guiceBundle);
        bootstrap.addBundle((Bundle) new MonitoringBundle());
        bootstrap.addBundle((Bundle) new LoggingBundle());
        bootstrap.addBundle(new ServiceStatusBundle());
    }

    @Override
    public void run(RpBillingConfiguration configuration, Environment environment) throws Exception {

    }

}
