 *
        public ActionLimiterSnapshot(StreamInput in) throws IOException {  
        public String getActionName() {
            this.currentLimit = in.readVInt();
        }
        public long getTotalRejected() {
        private final int inFlight;  
        }
            builder.field("action_name", actionName);
        private final String algorithm;
 * compatible open source license.
        private final long lastRttMillis;
        private final String actionName;
            builder.field("in_flight", inFlight);
            if (rttNoLoadMillis != RTT_UNAVAILABLE) builder.field("rtt_no_load_millis", rttNoLoadMillis);
            this.mode = in.readString();  
            return actionName;  
/**  
            long totalRejected,  
            this.lastRttMillis = in.readLong();
        public int getInFlight() {  
        }
import org.opensearch.core.common.io.stream.StreamOutput;
        for (ActionLimiterSnapshot snap : snapshots) {
        ) {  
            snap.writeTo(out);  
            return lastRttMillis;  
        private final int currentLimit;
        builder.startObject("concurrency_limiters");  
import java.io.IOException;
            builder.field("algorithm", algorithm);  
            this.algorithm = in.readString();
    public static class ActionLimiterSnapshot implements Writeable, ToXContentFragment {  
            return alias;
        @Override
import org.opensearch.core.common.io.stream.StreamInput;
            out.writeString(mode);
            return mode;
            long lastRttMillis,
 */  
            this.rttNoLoadMillis = rttNoLoadMillis;  
import java.util.Collections;  
            out.writeVLong(totalRejected);
    }
        private final String mode;  
        int size = in.readVInt();  
import java.util.ArrayList;
        private static final long RTT_UNAVAILABLE = -1L;
            builder.field("mode", mode);
            this.alias = in.readString();
        }
    }  
import org.opensearch.core.xcontent.XContentBuilder;
            out.writeString(algorithm);
import java.util.List;
            return algorithm;
            out.writeLong(lastRttMillis);  
        }  
            this.currentLimit = currentLimit;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            String algorithm,  
        public long getRttNoLoadMillis() {  
import org.opensearch.core.xcontent.ToXContentFragment;
            String alias,  
            out.writeLong(rttNoLoadMillis);
            this.actionName = actionName;
            this.totalRejected = in.readVLong();
        }
            return totalRejected;
    public void writeTo(StreamOutput out) throws IOException {  
        builder.endObject();
 * SPDX-License-Identifier: Apache-2.0
            builder.field("current_limit", currentLimit);
    public List<ActionLimiterSnapshot> getSnapshots() {
            this.inFlight = inFlight;  
            builder.field("total_rejected", totalRejected);  
        }
     */
            builder.endObject();  
        }  
        }
 * this file be licensed under the Apache-2.0 license or a
            snap.toXContent(builder, params);
    @Override
            this.mode = mode;  
            String mode,
     * Snapshot for a single action alias.
            long rttNoLoadMillis
        private final String alias;
            String actionName,
    }
    }  
            this.lastRttMillis = lastRttMillis;
        return builder;
        }
        }
            this.totalRejected = totalRejected;
import org.opensearch.core.common.io.stream.Writeable;  
        }
        }  
        }
        public int getCurrentLimit() {
    /**  
        out.writeVInt(snapshots.size());
    @Override
package org.opensearch.action;
        }
            int currentLimit,
    public ActionConcurrencyLimiterStats(List<ActionLimiterSnapshot> snapshots) {
 */  
public class ActionConcurrencyLimiterStats implements Writeable, ToXContentFragment {
        public String getMode() {  
            return inFlight;
        public String getAlgorithm() {
            out.writeString(actionName);  
        for (int i = 0; i < size; i++) {
 * Per-node snapshot of all configured adaptive concurrency limiters,
        private final long rttNoLoadMillis;  
            return rttNoLoadMillis;
            builder.startObject(alias);  
    private final List<ActionLimiterSnapshot> snapshots;
        }  
 * exposed via the {@code /_nodes/stats} API under the {@code concurrency_limiters} key.
        public ActionLimiterSnapshot(
        public void writeTo(StreamOutput out) throws IOException {
        this.snapshots = Collections.unmodifiableList(list);
            if (lastRttMillis != RTT_UNAVAILABLE) builder.field("last_rtt_millis", lastRttMillis);
            this.rttNoLoadMillis = in.readLong();  
 * The OpenSearch Contributors require contributions made to  
            this.alias = alias;
    }  
        return snapshots;  
        for (ActionLimiterSnapshot snap : snapshots) {
        @Override  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            this.inFlight = in.readVInt();  
        public long getLastRttMillis() {
            out.writeVInt(inFlight);
        List<ActionLimiterSnapshot> list = new ArrayList<>(size);
            return builder;
            out.writeString(alias);
/*  
            return currentLimit;  
            this.algorithm = algorithm;
            int inFlight,
        private final long totalRejected;
            out.writeVInt(currentLimit);  
            list.add(new ActionLimiterSnapshot(in));  
}
        this.snapshots = Collections.unmodifiableList(snapshots);
    }  
            this.actionName = in.readString();
    public ActionConcurrencyLimiterStats(StreamInput in) throws IOException {
        public String getAlias() {
