            this.isPaused = isPaused;  
            return this;  
    @PublicApi(since = "3.6.0")
        }  
    @Nullable
 */  
 * SPDX-License-Identifier: Apache-2.0
    // Indicates if poller needs to be paused or resumed.
/**
    @Nullable
/*  
    public String getResetValue() {  
    }  
        return resetValue;
    @Nullable
 */  
            this.resetState = resetState;
 * this file be licensed under the Apache-2.0 license or a
    private final String resetValue;
        return resetState;
@PublicApi(since = "3.6.0")
    private final StreamPoller.ResetState resetState;
        private StreamPoller.ResetState resetState;
        public Builder setResetValue(String resetValue) {  
            return this;
    }  
import org.opensearch.common.Nullable;
    /**
        this.resetState = builder.resetState;  
        private String resetValue;  
        this.isPaused = builder.isPaused;
 * Holds the ingestion settings required to update the poller. All values are optional to support partial update.
    public static class Builder {  
        }
 * The OpenSearch Contributors require contributions made to  
    private IngestionSettings(Builder builder) {
    public StreamPoller.ResetState getResetState() {
        }
package org.opensearch.indices.pollingingest;
    }
        return isPaused;  
 * compatible open source license.
    // Indicates target reset value (offset/timestamp/sequence number etc).  
        @Nullable
    public static Builder builder() {
 *
            this.resetValue = resetValue;
            return this;
    }
        public IngestionSettings build() {
     * Builder for IngestionSettings. Only set the fields that need to be used for updating ingestion state.  
        private Boolean isPaused;
        this.resetValue = builder.resetValue;
        }
        @Nullable
    public Boolean getIsPaused() {
        public Builder setIsPaused(Boolean isPaused) {
public class IngestionSettings {
    @Nullable
    }
        @Nullable  
    private final Boolean isPaused;  
        return new Builder();
    // Indicates target reset state of the poller.
}
     */
    @Nullable  
import org.opensearch.common.annotation.PublicApi;
    }
    @Nullable  
            return new IngestionSettings(this);  
        public Builder setResetState(StreamPoller.ResetState resetState) {
