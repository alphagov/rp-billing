package uk.gov.ida.rpbilling;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.ida.rpbilling.dto.RpBillingEventRecord;

public class BillingRepository {

    private static final Logger LOG = LoggerFactory.getLogger(BillingRepository.class);
    private final DBCollection dbCollection;
    private final MongoClient mongoClient;
    public static final String RPBILLING_DATABASE_NAME = "rpBillingDb";
    public static final String RPBILLING_COLLECTION = "billingEvents";

    public BillingRepository(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
        this.dbCollection = mongoClient.getDB(RPBILLING_DATABASE_NAME).getCollection(RPBILLING_COLLECTION);
    }

    public void add(RpBillingEventRecord record) {

    }

}
