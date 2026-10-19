    }  
    public long getTotalTimeInMillis() {
                builder.field(extendedField.getKey(), extendedField.getValue().get());
    }  
@PublicApi(since = "2.12.0")  
        static final String SUCCESS_COUNT = "success_count";
    }  
        this.extendedFields.put(extendedField, extendedFieldValue);
    }  
    }
            }
 */
        out.writeString(statsName);
     * @param timeTakenInUpload time taken in uploading the cluster state to remote
        this.failedCount = new AtomicLong(in.readVLong());  
        builder.field(Fields.TOTAL_TIME_IN_MILLIS, getTotalTimeInMillis());
        return failedCount.get();  
/**
        }
    static final class Fields {  
    /**
     * Fields for parsing and toXContent
            out.writeBoolean(false);
                out.writeVLong(extendedField.getValue().get());
        this.successCount = new AtomicLong(in.readVLong());
        return statsName;
 * SPDX-License-Identifier: Apache-2.0
/*  
    public void stateFailed() {
    public PersistedStateStats(StreamInput in) throws IOException {  
    }
    }
        out.writeVLong(successCount.get());  
    @Override
        builder.startObject(statsName);
        out.writeVLong(failedCount.get());
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
import java.util.concurrent.atomic.AtomicLong;
    }
import org.opensearch.core.xcontent.ToXContentObject;
        totalTimeInMillis.addAndGet(timeTakenInUpload);
    }
     */
    public long getSuccessCount() {  
    }
        if (extendedFields.size() > 0) {
    private final String statsName;
                extendedFields.put(in.readString(), new AtomicLong(in.readVLong()));  
    public void stateTook(long timeTakenInUpload) {  
     * Expects user to send time taken in milliseconds.
    public Map<String, AtomicLong> getExtendedFields() {
 * @opensearch.api
import java.util.HashMap;  
 * The OpenSearch Contributors require contributions made to  
            int extendedFieldsSize = in.readVInt();  
        this.statsName = in.readString();
 * compatible open source license.
            this.extendedFields = new HashMap<>();
 *  
 * Persisted cluster state related stats.
        builder.field(Fields.SUCCESS_COUNT, getSuccessCount());
 * this file be licensed under the Apache-2.0 license or a
    /**
    private AtomicLong failedCount = new AtomicLong(0);
 *
    private AtomicLong successCount = new AtomicLong(0);
        this.statsName = statsName;  
    public void stateSucceeded() {  
     * @opensearch.internal
            for (Map.Entry<String, AtomicLong> extendedField : extendedFields.entrySet()) {  
    private AtomicLong totalTimeInMillis = new AtomicLong(0);  
    public String getStatsName() {  
        builder.field(Fields.FAILED_COUNT, getFailedCount());  
    public void writeTo(StreamOutput out) throws IOException {
     */
            for (Map.Entry<String, AtomicLong> extendedField : extendedFields.entrySet()) {  
    }
     *  
        failedCount.incrementAndGet();  
            for (int fieldNumber = 0; fieldNumber < extendedFieldsSize; fieldNumber++) {
    protected void addToExtendedFields(String extendedField, AtomicLong extendedFieldValue) {
public class PersistedStateStats implements Writeable, ToXContentObject {
    @Override  
            }
    }
        static final String FAILED_COUNT = "failed_count";  
                out.writeString(extendedField.getKey());
    }
            out.writeVInt(extendedFields.size());
import org.opensearch.common.annotation.PublicApi;
        } else {
        successCount.incrementAndGet();
            out.writeBoolean(true);
        return builder;
        out.writeVLong(totalTimeInMillis.get());
        return extendedFields;  
        if (extendedFields.size() > 0) {  
    public long getFailedCount() {
        }  
 */  
import java.io.IOException;
    }
        }  
    public PersistedStateStats(String statsName) {
}
        if (in.readBoolean()) {
        this.totalTimeInMillis = new AtomicLong(in.readVLong());
    private Map<String, AtomicLong> extendedFields = new HashMap<>(); // keeping minimal extensibility  
import org.opensearch.core.common.io.stream.Writeable;
            }  
import org.opensearch.core.common.io.stream.StreamOutput;  
     *  
        return successCount.get();
        builder.endObject();
        static final String TOTAL_TIME_IN_MILLIS = "total_time_in_millis";
import org.opensearch.core.xcontent.XContentBuilder;  
        return totalTimeInMillis.get();
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.cluster.coordination;
import java.util.Map;
