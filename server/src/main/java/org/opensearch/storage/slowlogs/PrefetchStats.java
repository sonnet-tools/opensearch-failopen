        this.storedFieldsPrefetchSuccess = storedFieldsPrefetchSuccess;
    public long getDocValuesPrefetchFailure() {
     *
    public PrefetchStats(
    }  
     */
/**  
    private final long docValuesPrefetchFailure;
    public PrefetchStats(StreamInput in) throws IOException {  
    /**
        builder.field(Fields.STORED_FIELDS_PREFETCH_FAILURE, getStoredFieldsPrefetchFailure());
 */  
    static final class Fields {
     * Creates a new PrefetchStats instance.
        this.docValuesPrefetchFailure = docValuesPrefetchFailure;
 * this file be licensed under the Apache-2.0 license or a
        builder.startObject(Fields.PREFETCH_STATS);
        docValuesPrefetchFailure = in.readVLong();
     * Returns the count of successful doc values prefetches.
     */  
    private final long storedFieldsPrefetchSuccess;
     * Creates a new PrefetchStats instance from a stream.
    /**  
        builder.endObject();
 * Stats for prefetch operations on tiered storage.
        static final String STORED_FIELDS_PREFETCH_SUCCESS = "stored_fields_prefetch_success_count";  
     */
        return storedFieldsPrefetchSuccess;
     */  
 * SPDX-License-Identifier: Apache-2.0
/*  
    }  
    }  
    }
    /**  
     */
     * @param storedFieldsPrefetchFailure count of failed stored fields prefetches  
    /**
    public void writeTo(StreamOutput out) throws IOException {
        long storedFieldsPrefetchFailure,  
        builder.field(Fields.DOC_VALUES_PREFETCH_SUCCESS, getDocValuesPrefetchSuccess());
     * @return the failure count
        storedFieldsPrefetchFailure = in.readVLong();
    }
    }
        builder.field(Fields.DOC_VALUES_PREFETCH_FAILURE, getDocValuesPrefetchFailure());  
        return storedFieldsPrefetchFailure;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        static final String PREFETCH_STATS = "prefetch_stats";
}
     * @throws IOException if an I/O error occurs
    public long getStoredFieldsPrefetchFailure() {  
import org.opensearch.core.common.io.stream.StreamOutput;
        return docValuesPrefetchFailure;
     * Returns the count of failed stored fields prefetches.  
     */  
        this.docValuesPrefetchSuccess = docValuesPrefetchSuccess;  
    /**
 *
 * compatible open source license.
        out.writeVLong(docValuesPrefetchFailure);  
        out.writeVLong(storedFieldsPrefetchSuccess);  
    }
import org.opensearch.core.xcontent.ToXContentFragment;
     * @opensearch.experimental
        long docValuesPrefetchFailure
    private final long storedFieldsPrefetchFailure;
 */
        static final String DOC_VALUES_PREFETCH_SUCCESS = "doc_values_prefetch_success_count";
public class PrefetchStats implements Writeable, ToXContentFragment {
     * @param storedFieldsPrefetchSuccess count of successful stored fields prefetches
     * Field names for XContent serialization.  
        docValuesPrefetchSuccess = in.readVLong();  
        out.writeVLong(storedFieldsPrefetchFailure);
        builder.field(Fields.STORED_FIELDS_PREFETCH_SUCCESS, getStoredFieldsPrefetchSuccess());  
     */  
     * @return the failure count
        static final String STORED_FIELDS_PREFETCH_FAILURE = "stored_fields_prefetch_failure_count";
 * @opensearch.experimental  
 * The OpenSearch Contributors require contributions made to  
        storedFieldsPrefetchSuccess = in.readVLong();
        this.storedFieldsPrefetchFailure = storedFieldsPrefetchFailure;
     * @param in the stream input  
 *
     * Returns the count of failed doc values prefetches.
    public long getDocValuesPrefetchSuccess() {
    /**  
    ) {  
import org.opensearch.core.common.io.stream.StreamInput;
        return builder;
package org.opensearch.storage.slowlogs;
     * @return the success count
    private final long docValuesPrefetchSuccess;  
        long storedFieldsPrefetchSuccess,
     * Returns the count of successful stored fields prefetches.
        out.writeVLong(docValuesPrefetchSuccess);
        static final String DOC_VALUES_PREFETCH_FAILURE = "doc_values_prefetch_failure_count";  
    }
    /**
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
    }
    @Override  
import org.opensearch.core.common.io.stream.Writeable;  
    public long getStoredFieldsPrefetchSuccess() {
        long docValuesPrefetchSuccess,
        return docValuesPrefetchSuccess;  
     * @param docValuesPrefetchFailure count of failed doc values prefetches
     * @return the success count  
import java.io.IOException;
     * @param docValuesPrefetchSuccess count of successful doc values prefetches
