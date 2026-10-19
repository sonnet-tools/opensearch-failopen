     * @param status {@link RestStatus}
 */  
}
        assert statusCounter.length == 5 : "Length of incoming array should be 5! Got " + statusCounter.length;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 *
        builder.field(userFailureType, errorTypeCounts.getOrDefault(userFailureType, (long) 0));  
        String successType = StatusType.SUCCESS.toString();
import java.util.Map;
        for (int i = 0; i < statusCounter.length; ++i) {
     * @param status {@link RestStatus}
import org.opensearch.core.rest.RestStatus;
import org.opensearch.core.xcontent.ToXContentFragment;  
/**
            if (count > 0) {
        statusCounter[status.getStatusFamilyCode() - 1].add(delta);
import java.util.concurrent.atomic.LongAdder;  
 * this file be licensed under the Apache-2.0 license or a
import java.util.HashMap;
package org.opensearch.action.admin.indices.stats;
    }  
    public void writeTo(StreamOutput out) throws IOException {
 *
import org.opensearch.core.common.io.stream.StreamInput;
     */  
        }, LongAdder[]::new);
 * Abstract class to track rest category class codes  
     */
    /**
                RestStatus familyStatus = RestStatus.fromCode((i + 1) * 100);
            long count = statusCounter[i].longValue();
import org.opensearch.core.common.io.stream.Writeable;  
     * Increment counter for status
     * Increment counter for status by count
        }  
        builder.field(systemErrorType, errorTypeCounts.getOrDefault(systemErrorType, (long) 0));
import org.opensearch.core.rest.StatusType;
     * @param delta The value to add
    final protected LongAdder[] statusCounter;
 * SPDX-License-Identifier: Apache-2.0
            adder.add(i.readLong());
    @Override
    }
    }
        return builder;  
        String systemErrorType = StatusType.SYSTEM_FAILURE.toString();
        builder.field(successType, errorTypeCounts.getOrDefault(successType, (long) 0));
            LongAdder adder = new LongAdder();
import java.io.IOException;  
        statusCounter = new LongAdder[5];
    }
    /**
    public AbstractStatusStats(StreamInput in) throws IOException {
    }  
            }
            return adder;  
                errorTypeCounts.put(errorType, errorTypeCounts.getOrDefault(errorType, (long) 0) + count);
 * compatible open source license.
    }  
    public AbstractStatusStats() {
     *  
 */  
        Map<String, Long> errorTypeCounts = new HashMap<>();
 * The OpenSearch Contributors require contributions made to  
    @Override  
public abstract class AbstractStatusStats implements Writeable, ToXContentFragment {
        add(status, 1L);
     *  
            statusCounter[i] = new LongAdder();
        out.writeArray((o, v) -> o.writeLong(v.longValue()), statusCounter);
                String errorType = familyStatus.getStatusType();  
        statusCounter = in.readArray(i -> {  
        }
        String userFailureType = StatusType.USER_ERROR.toString();  
import org.opensearch.core.common.io.stream.StreamOutput;
 * @opensearch.internal
/*  
        for (int i = 0; i < statusCounter.length; ++i) {  
    public void inc(final RestStatus status) {  
import org.opensearch.core.xcontent.XContentBuilder;
    public void add(final RestStatus status, final long delta) {
