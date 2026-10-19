        return new PolicyValues(in);
            this.tookTimeNanos = tookTimeNanos;
import org.opensearch.core.common.io.stream.StreamInput;
        }  
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
            out.writeZLong(tookTimeNanos);  
    private final QuerySearchResult qsr;
    public CachedQueryResult(QuerySearchResult qsr, long tookTimeNanos) {  
 * @opensearch.internal  
        public PolicyValues(long tookTimeNanos) {
    public void writeToNoId(StreamOutput out) throws IOException {  
/*  
 *
     *  @opensearch.experimental  
        qsr.readFromWithId(id, in);  
 * A class containing a QuerySearchResult used in a cache, as well as information needed for all cache policies
            return tookTimeNanos;
     *
}  
        public void writeTo(StreamOutput out) throws IOException {
        }
import org.opensearch.search.query.QuerySearchResult;  
        qsr.writeToNoId(out);
    /**
        // More values can be added here as they're needed for future policies
 * SPDX-License-Identifier: Apache-2.0
        @Override
        NamedWriteableRegistry registry
public class CachedQueryResult {
        public long getTookTimeNanos() {  
     *  to decide whether to admit a given value.
        BytesReference serializedCQR,
import java.io.IOException;
package org.opensearch.common.cache.policy;
    }  
 */
 * which is all that is needed outside the cache. At policy checking time, this spares us from having to create an entire
     */
        PolicyValues pv = new PolicyValues(in); // Read and discard PolicyValues
import org.opensearch.search.internal.ShardSearchContextId;
        StreamInput in = serializedCQR.streamInput();
    public static class PolicyValues implements Writeable {  
    @ExperimentalApi
            this.tookTimeNanos = in.readZLong();  
    ) throws IOException {  
        public PolicyValues(StreamInput in) throws IOException {
        }
 * short-lived QuerySearchResult object just to read a few values.
        QuerySearchResult qsr,  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    public static void loadQSR(
 * this file be licensed under the Apache-2.0 license or a
    }
        this.policyValues = new PolicyValues(tookTimeNanos);
 * to decide whether to admit a given BytesReference. Also handles serialization/deserialization of the underlying QuerySearchResult,  
import org.opensearch.common.annotation.ExperimentalApi;
 */  
        ShardSearchContextId id,
        policyValues.writeTo(out);
 * compatible open source license.
     * A class containing information needed for all cache policies  
        StreamInput in = new NamedWriteableAwareStreamInput(serializedCQR.streamInput(), registry);
    }
        this.qsr = qsr;
/**
    // Retrieve only the QSR from a serialized CQR, and load it into an existing QSR object discarding the took time which isn't needed
    // Retrieve only took time from a serialized CQR, without creating a short-lived QuerySearchResult or CachedQueryResult object.
import org.opensearch.core.common.io.stream.StreamOutput;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.bytes.BytesReference;
        final long tookTimeNanos;
        }
    public static PolicyValues getPolicyValues(BytesReference serializedCQR) throws IOException {  
import org.opensearch.core.common.io.stream.Writeable;
    // outside the cache  
    private final PolicyValues policyValues;  
    }  
    }  
