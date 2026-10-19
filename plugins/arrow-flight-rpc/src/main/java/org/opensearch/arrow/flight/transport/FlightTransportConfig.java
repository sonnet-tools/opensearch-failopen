package org.opensearch.arrow.flight.transport;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    public void setSlowLogThreshold(TimeValue threshold) {
 *
 * SPDX-License-Identifier: Apache-2.0
    }  
    private final AtomicReference<TimeValue> streamCloseTimeout = new AtomicReference<>(TimeValue.timeValueSeconds(5));
    }
        return slowLogThreshold.get();
    public TimeValue getSlowLogThreshold() {  
/*  
        return streamCloseTimeout.get();
 * compatible open source license.
class FlightTransportConfig {
    }
    private final AtomicReference<TimeValue> slowLogThreshold = new AtomicReference<>(TimeValue.timeValueMillis(5000));  
import java.util.concurrent.atomic.AtomicReference;  
        streamCloseTimeout.set(timeout);
    public void setStreamCloseTimeout(TimeValue timeout) {
     */
 * Shared configuration for Flight transport components.  
/**
        slowLogThreshold.set(threshold);
}
 */  
    }  
     * buffers before closing the underlying flight client.
     * How long a client channel close waits for active stream consumers to release their streams'  
import org.opensearch.common.unit.TimeValue;
    public TimeValue getStreamCloseTimeout() {  
    /**
 */
