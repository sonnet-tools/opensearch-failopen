    /**  
        }  
import org.opensearch.common.annotation.PublicApi;
        builder.startObject(Fields.DOC_STATUS);
import org.opensearch.core.common.io.stream.StreamInput;
     */
        super(in);
import java.io.IOException;
package org.opensearch.action.admin.indices.stats;
     * For this function, I just want to retrieve a point in time snapshot of the DocStatusStats.
    static final class Fields {
        curSnapshot.add(this);
     */
    }
 */
     */
     * @opensearch.internal  
            return;
/*  
    }  
        super();
    }
            statusCounter[i].add(stats.statusCounter[i].longValue());  
    public void add(final DocStatusStats stats) {  
        static final String DOC_STATUS = "doc_status";  
    public void writeTo(StreamOutput out) throws IOException {
}
    public DocStatusStats getSnapshot() {  
    /**
    }
        return builder.endObject();
    }
     * @param stats Instance storing {@link DocStatusStats}
 * Tracks item level rest category class codes during indexing
    /**  
    public LongAdder[] getDocStatusCounter() {
     * @param delta The value to add  
     * @param status {@link RestStatus}
 */  
        return curSnapshot;  
        super.add(status, delta);
 * @opensearch.api
     */  
 * this file be licensed under the Apache-2.0 license or a
    @Override
     *
    }
import org.opensearch.core.xcontent.XContentBuilder;
    public void add(final RestStatus status, final long delta) {  
    /**
    }
     *
        if (null == stats) {
    public void inc(final RestStatus status) {
    @Override
public class DocStatusStats extends AbstractStatusStats {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
     *  
 * SPDX-License-Identifier: Apache-2.0
     *
     * Increment counter for status by count  
        }
    }  
    @Override
        super.writeTo(out);  
/**
 * compatible open source license.
        return statusCounter;
     * Accumulate stats from the passed Object
    public DocStatusStats(StreamInput in) throws IOException {
    }
@PublicApi(since = "3.4.0")  
        DocStatusStats curSnapshot = new DocStatusStats();
     * Increment counter for status  
        add(status, 1L);
        for (int i = 0; i < statusCounter.length; ++i) {
import org.opensearch.core.common.io.stream.StreamOutput;  
    public DocStatusStats() {  
        super.toXContent(builder, params);  
 *  
     * Fields for parsing and toXContent
 *
    }  
     * @param status {@link RestStatus}
import java.util.concurrent.atomic.LongAdder;
    /**
     */
import org.opensearch.core.rest.RestStatus;
 * The OpenSearch Contributors require contributions made to  
