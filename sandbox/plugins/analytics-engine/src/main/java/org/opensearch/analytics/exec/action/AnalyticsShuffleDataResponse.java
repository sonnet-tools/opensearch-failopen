    public boolean isBackpressureRejected() {
 * this file be licensed under the Apache-2.0 license or a
 *
    public AnalyticsShuffleDataResponse(StreamInput in) throws IOException {
    public void writeTo(StreamOutput out) throws IOException {  
    }
        this.backpressureRejected = in.readBoolean();  
 * flag: when {@code true} the buffer was at its per-partition byte cap and the sender should  
package org.opensearch.analytics.exec.action;
 */
import java.io.IOException;
import org.opensearch.core.action.ActionResponse;
        return backpressureRejected;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamInput;
public class AnalyticsShuffleDataResponse extends ActionResponse {
        this(false);
}  
    public AnalyticsShuffleDataResponse() {  
 * Response to an {@link AnalyticsShuffleDataRequest}. Carries a {@code backpressureRejected}
    private final boolean backpressureRejected;
 * compatible open source license.
 * retry with exponential backoff. Ported from OLAP's {@code ShuffleDataResponse}.
/*  
    }
    public AnalyticsShuffleDataResponse(boolean backpressureRejected) {
    }
        this.backpressureRejected = backpressureRejected;
        return new AnalyticsShuffleDataResponse(true);
    public static AnalyticsShuffleDataResponse backpressureReject() {  
 * @opensearch.internal  
    @Override
 *
 * SPDX-License-Identifier: Apache-2.0
    }  
/**
 */  
    }  
import org.opensearch.core.common.io.stream.StreamOutput;  
        out.writeBoolean(backpressureRejected);
    }
