package uk.gov.ida.rpbilling.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;

public class RpBillingEventRecord {

    @JsonProperty
    private DateTime timestamp;

    @JsonProperty
    private String pid;

    @JsonProperty
    private String requestId;

    @JsonProperty
    private String entityId;

    @SuppressWarnings("unused")
    protected RpBillingEventRecord() {
    }

    public RpBillingEventRecord(DateTime timestamp, String pid, String requestId, String entityId) {
        this.timestamp = timestamp;
        this.pid = pid;
        this.requestId = requestId;
        this.entityId = entityId;
    }

    public String getRequestId() { return requestId; }

    public DateTime getTimestamp() {
        return timestamp;
    }

    public String getEntityId() {
        return entityId;
    }

    public String getPid() {
        return pid;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}
