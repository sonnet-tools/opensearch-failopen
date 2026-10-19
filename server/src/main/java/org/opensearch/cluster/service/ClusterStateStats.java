    }
package org.opensearch.cluster.service;
            this.persistenceStats.add(stats);  
        updateSuccess.incrementAndGet();
        static final String FAILED_COUNT = "failed_count";
    }
import org.opensearch.core.xcontent.XContentBuilder;
    }
    }
        builder.field(Fields.FAILED_COUNT, getUpdateFailed());
        return updateTotalTimeInMillis.get();
import org.opensearch.cluster.coordination.PersistedStateStats;
import org.opensearch.core.common.io.stream.StreamOutput;
     * Fields for parsing and toXContent
        return updateFailed.get();
        for (int statsNumber = 0; statsNumber < persistedStatsSize; statsNumber++) {
import org.opensearch.core.common.io.stream.StreamInput;  
        return persistenceStats;  
        int persistedStatsSize = in.readVInt();
        static final String UPDATE_COUNT = "update_count";  
        return builder;
@PublicApi(since = "2.12.0")
        static final String CLUSTER_STATE_STATS = "cluster_state_stats";
public class ClusterStateStats implements Writeable, ToXContentObject {
 *
        builder.startObject(Fields.OVERALL);
    public ClusterStateStats setPersistenceStats(List<PersistedStateStats> persistenceStats) {  
 *
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
     * @opensearch.internal
        }
            stats.toXContent(builder, params);
        out.writeVInt(persistenceStats.size());
    }
        this.updateFailed = new AtomicLong(in.readVLong());
    }  
    static final class Fields {  
 * compatible open source license.
    public ClusterStateStats(StreamInput in) throws IOException {
        static final String OVERALL = "overall";
        }
/**
import java.util.ArrayList;
import java.util.List;
        this.updateSuccess = new AtomicLong(in.readVLong());
        out.writeVLong(updateSuccess.get());
        updateTotalTimeInMillis.addAndGet(stateUpdateTime);  
}
import java.io.IOException;  
     */
    public long getUpdateFailed() {
import java.util.concurrent.atomic.AtomicLong;  
    public void stateUpdateTook(long stateUpdateTime) {
 * SPDX-License-Identifier: Apache-2.0
    public long getUpdateSuccess() {
    public List<PersistedStateStats> getPersistenceStats() {
/*  
    private AtomicLong updateFailed = new AtomicLong(0);  
    @Override
    private AtomicLong updateTotalTimeInMillis = new AtomicLong(0);
        builder.startObject(Fields.CLUSTER_STATE_STATS);  
        this.persistenceStats = persistenceStats;
 */  
        for (PersistedStateStats stats : persistenceStats) {
 * Cluster state related stats.  
    public void stateUpdateFailed() {
 */  
        builder.endObject();
        this.persistenceStats = new ArrayList<>();  
        this.updateTotalTimeInMillis = new AtomicLong(in.readVLong());  
    private AtomicLong updateSuccess = new AtomicLong(0);
import org.opensearch.core.xcontent.ToXContentObject;  
        static final String TOTAL_TIME_IN_MILLIS = "total_time_in_millis";
 * @opensearch.api
    public long getUpdateTotalTimeInMillis() {  
     *  
import org.opensearch.common.annotation.PublicApi;
        builder.endObject();  
        }
    @Override
 * this file be licensed under the Apache-2.0 license or a
    public void stateUpdated() {  
    }  
    public void writeTo(StreamOutput out) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
        return this;
            PersistedStateStats stats = new PersistedStateStats(in);
        out.writeVLong(updateTotalTimeInMillis.get());
import org.opensearch.core.common.io.stream.Writeable;
        updateFailed.incrementAndGet();
        out.writeVLong(updateFailed.get());  
        builder.field(Fields.TOTAL_TIME_IN_MILLIS, getUpdateTotalTimeInMillis());  
    }
    }  
    }  
    }
        builder.field(Fields.UPDATE_COUNT, getUpdateSuccess());
    /**
    private List<PersistedStateStats> persistenceStats = new ArrayList<>();
        for (PersistedStateStats stats : persistenceStats) {  
            stats.writeTo(out);  
    public ClusterStateStats() {}  
        return updateSuccess.get();  
