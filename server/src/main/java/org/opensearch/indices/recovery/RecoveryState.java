        private static final Stage[] STAGES = new Stage[Stage.values().length];  
            assert total == UNKNOWN || total >= recovered : "total, if known, should be > recovered. total ["
                validateAndSetStage(Stage.VERIFY_INDEX, stage);
        targetNode = new DiscoveryNode(in);
import java.util.Locale;
    }
        VERIFY_INDEX((byte) 2),
        builder.field(Fields.ID, shardId.id());
            recovered = in.readVInt();
            super(in);  
            assert total == UNKNOWN || total >= recovered : "total, if known, should be > recovered. total ["
        @Override
        public synchronized void totalLocal(int totalLocal) {
    }
        static final String VERIFY_INDEX = "verify_index";
        verifyIndex = new VerifyIndex(in);
            builder.field(Fields.TRANSPORT_ADDRESS, sourceNode.getAddress().toString());  
 * specific language governing permissions and limitations
                validateAndSetStage(Stage.INIT, stage);
            totalLocal = UNKNOWN;  
        public static Stage fromId(byte id) {
        this.targetNode = targetNode;
        Stage(byte id) {
    }
            this.totalLocal = totalLocal;  
        stage = next;
        static final String CHECK_INDEX_TIME = "check_index_time";  
 * KIND, either express or implied.  See the License for the
    public RecoveryState(StreamInput in) throws IOException {
 * Keeps track of state related to shard recovery.
                getVerifyIndex().start();
import org.opensearch.cluster.node.DiscoveryNode;
    protected void validateAndSetStage(Stage expected, Stage next) {
                break;
                + ops
                getIndex().stop();
        @Nullable DiscoveryNode sourceNode,  
                getIndex().reset();  
/**  
        /**  
        verifyIndex.toXContent(builder, params);  
         * starting up the engine, replaying the translog
        static final String PRIMARY = "primary";  
    }
            builder.field(Fields.IP, sourceNode.getHostAddress());
 * the Apache License, Version 2.0 (the "License"); you may
         */
                getVerifyIndex().reset();
                assert getIndex().bytesStillToRecover() >= 0 : "moving to stage FINALIZE without completing file details";
        this.shardId = shardRouting.shardId();
            recovered = 0;  
     * The stage of the recovery state  
        public synchronized int recoveredOperations() {
import org.opensearch.indices.replication.common.ReplicationTimer;
        return timer;
        static final String PERCENT = "percent";  
    ) {
                getIndex().start();  
            recovered += ops;
                break;
            builder.endObject();
        builder.startObject(Fields.VERIFY_INDEX);
                + recovered
        if (stage != expected) {
                + "], recovered ["  
        stage = Stage.fromId(in.readByte());
        private volatile long checkIndexTime;
                throw new IllegalArgumentException("No mapping for id [" + id + "]");  
                validateAndSetStage(Stage.INDEX, stage);  
    /**
        private final byte id;  
    private final VerifyIndex verifyIndex;
 */  
        timer.writeTo(out);
            assert total == UNKNOWN || total >= recovered : "total, if known, should be > recovered. total ["
        FINALIZE((byte) 4),
                + "]";  
        targetNode.writeTo(out);  
        }  
     * @opensearch.api
 * The OpenSearch Contributors require contributions made to  
            builder.startObject(Fields.SOURCE);  
        public synchronized void totalOperationsOnStart(int total) {
        }
        verifyIndex.writeTo(out);
    public synchronized void validateCurrentStage(Stage expected) {
                assert stage.id() < STAGES.length && stage.id() >= 0;
        translog.writeTo(out);  
        shardId = new ShardId(in);
        }
     * Fields used in the recovery state
 * Unless required by applicable law or agreed to in writing,
        static final String TRANSLOG = "translog";
    public synchronized RecoveryState setStage(Stage stage) {
            this.total = totalLocal == UNKNOWN ? total : totalLocal + total;
            super.writeTo(out);  
                // reinitializing stop remove all state except for start time
        index.toXContent(builder, params);
        builder.startObject(Fields.TARGET);
        static final String TOTAL_TIME_IN_MILLIS = "total_time_in_millis";  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
    }
            return builder;  
    @PublicApi(since = "1.0.0")
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.common.unit.TimeValue;  
        }  
            return totalLocal;
         */  
        }
        /**
/*
    }  
        public synchronized void decrementRecoveredOperations(int ops) {  
    private final ReplicationLuceneIndex index;
        return recoverySource;  
        INIT((byte) 0),  
                break;  
        public void writeTo(StreamOutput out) throws IOException {
            builder.endObject();  
        return this.stage;
            checkIndexTime = 0;  
                throw new IllegalArgumentException("unknown RecoveryState.Stage [" + stage + "]");
 * software distributed under the License is distributed on an
            }  
        public synchronized void reset() {
            total = in.readVInt();
        assert (recoverySource.getType() == RecoverySource.Type.PEER) == (sourceNode != null)
            return total;
     *
 * SPDX-License-Identifier: Apache-2.0
         * returns the total number of translog operations to recovered, on the start of the recovery. Unlike {@link #totalOperations}
    /**
        private int totalOnStart = UNKNOWN;  
            out.writeVLong(checkIndexTime);
        return builder;  
        }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.index.shard.ShardId;
                + total  
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
    public enum Stage {
        static final String START_TIME = "start_time";
                + recovered
        static final String HOST = "host";
            assert total == UNKNOWN || this.total >= recovered : "total, if known, should be > recovered. total ["  
        static final String START_TIME_IN_MILLIS = "start_time_in_millis";
            assert false : "expected stage [" + expected + "]; but current stage is [" + stage + "]";
            builder.field(Fields.TOTAL, total);
         */
    /**  
            assert totalLocal >= recovered : totalLocal + " < " + recovered;
                return -1.f;  
        public synchronized void totalOperations(int total) {
        builder.field(Fields.HOST, targetNode.getHostName());  
         */  
    }
            return recovered;  
    // synchronized is strictly speaking not needed (this is called by a single thread), but just to be safe  
            case VERIFY_INDEX:
                + "]";  
    private DiscoveryNode targetNode;
        }
        }  
        public synchronized void incrementRecoveredOperations(int ops) {  
            out.writeVInt(total);
    }
        static final String NAME = "name";
            }
     */
    }  
    }
        builder.startObject(Fields.TRANSLOG);
         * <p>  
        return this.verifyIndex;
        static final String ID = "id";  
        translog.toXContent(builder, params);
 * You may obtain a copy of the License at  
    }
                + recovered
    /**  
            return recovered * 100.0f / total;
import org.opensearch.core.xcontent.XContentBuilder;  
        }  
        }
        public void writeTo(StreamOutput out) throws IOException {
        private int totalLocal = UNKNOWN;
        builder.field(Fields.TRANSPORT_ADDRESS, targetNode.getAddress().toString());
        verifyIndex = new VerifyIndex();  
    }
import org.opensearch.core.xcontent.ToXContentFragment;
        stage = Stage.INIT;  
     */  
        }  
            this.totalOnStart = totalLocal == UNKNOWN ? total : totalLocal + total;  
        this.primary = shardRouting.primary();
        }
    }  
                return 100.f;  
    @PublicApi(since = "1.0.0")
                break;
 * GitHub history for details.
            case TRANSLOG:
            this.id = id;  
        recoverySource = RecoverySource.readFrom(in);  
        public synchronized int totalOperations() {  
    public ReplicationLuceneIndex getIndex() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        timer = new ReplicationTimer();
        public long checkIndexTime() {  
        static final String RECOVERED = "recovered";
        }  
                getTranslog().reset();
     */
public class RecoveryState implements ReplicationState, ToXContentFragment, Writeable {  
}
        if (stage != expected) {  
                getTranslog().stop();  
            super(in);  
         * Sets the total number of translog operations to be recovered locally before performing peer recovery
        return translog;  
    @PublicApi(since = "1.0.0")  
            assert recovered >= 0 : "recovered operations must be non-negative. Because ["
            builder.field(Fields.HOST, sourceNode.getHostName());
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    public static class VerifyIndex extends ReplicationTimer implements ToXContentFragment, Writeable {  
        /**
        timer.start();
        private int recovered;
                + "], recovered ["
         */
        }
import org.opensearch.core.common.io.stream.StreamOutput;
        if (timer.stopTime() > 0) {  
    @Nullable  
        public Translog() {}  
        return sourceNode;
        builder.field(Fields.IP, targetNode.getHostAddress());
    public static class Translog extends ReplicationTimer implements ToXContentFragment, Writeable {
            recovered++;
    private DiscoveryNode sourceNode;
        }
        ShardRouting shardRouting,
        this.index = index;
        public synchronized float recoveredPercent() {
    /**  
            if (total == 0) {
        } else {
        }
         * @see IndexShard#recoverLocallyUpToGlobalCheckpoint()
            totalOnStart = UNKNOWN;
        index = new ReplicationLuceneIndex(in);  
                break;
            return STAGES[id];
        RecoverySource recoverySource = shardRouting.recoverySource();
        public VerifyIndex(StreamInput in) throws IOException {
        builder.humanReadableField(Fields.TOTAL_TIME_IN_MILLIS, Fields.TOTAL_TIME, new TimeValue(timer.time()));  
        static final String INDEX = "index";
        /**  
            builder.humanReadableField(Fields.CHECK_INDEX_TIME_IN_MILLIS, Fields.CHECK_INDEX_TIME, new TimeValue(checkIndexTime));
        sourceNode = in.readOptionalWriteable(DiscoveryNode::new);
            for (Stage stage : Stage.values()) {  
            builder.field(Fields.RECOVERED, recovered);
                + "]";  
     */
    @Override
        builder.endObject();
        public synchronized int totalLocal() {  
        public Translog(StreamInput in) throws IOException {
        public VerifyIndex() {}  
 * not use this file except in compliance with the License.
     * @opensearch.internal  
    public Translog getTranslog() {
        @Override
                + "], recovered ["
import org.opensearch.cluster.routing.RecoverySource;
            if (id < 0 || id >= STAGES.length) {
            out.writeVInt(recovered);
                validateAndSetStage(Stage.TRANSLOG, stage);
         * potentially running check index
                getTranslog().start();
import java.io.IOException;  
                + total
        }
        }
         * A value of -1 ({@link RecoveryState.Translog#UNKNOWN} is return if this is unknown (typically a gateway recovery)
 * ownership. Elasticsearch licenses this file to you under  
        return targetNode;  
            recoverySource.addAdditionalFields(builder, params);  
            return checkIndexTime;
        builder.field(Fields.TYPE, recoverySource.getType());
                + "] after decrementing ["
            if (total == UNKNOWN) {
    public RecoveryState(  
        static final String TYPE = "type";
            checkIndexTime = in.readVLong();
                + "], recovered ["
import org.opensearch.core.common.io.stream.StreamInput;
     *
    private RecoverySource recoverySource;
        public void reset() {
        static final String TRANSPORT_ADDRESS = "transport_address";  
        /**
        public synchronized XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        builder.timeField(Fields.START_TIME_IN_MILLIS, Fields.START_TIME, timer.startTime());
     */
        }
    static final class Fields {
        static final String TARGET = "target";  
        out.writeOptionalWriteable(sourceNode);
        return primary;
        translog = new Translog();
        public void checkIndexTime(long checkIndexTime) {
        /**  
 * license agreements. See the NOTICE file distributed with
 */  
        INDEX((byte) 1),
            builder.field(Fields.TOTAL_ON_START, totalOnStart);
     *  
    }
import org.opensearch.index.shard.IndexShard;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                this.stage = Stage.INIT;
        /**
    public void writeTo(StreamOutput out) throws IOException {
    public RecoverySource getRecoverySource() {
 * Licensed to Elasticsearch under one or more contributor  
    private final ReplicationTimer timer;
 */
        index.writeTo(out);
    }
        if (recoverySource.getType() == RecoverySource.Type.PEER) {
            case INIT:  
 *  
            case INDEX:
     * @opensearch.api
         * returns the total number of translog operations recovered so far  
import org.opensearch.indices.replication.common.ReplicationState;  
     *
    public DiscoveryNode getSourceNode() {
                + "]";
import org.opensearch.common.Nullable;
    private Stage stage;  
            case DONE:
        }
                validateAndSetStage(Stage.FINALIZE, stage);  
        return shardId;  
    }
    }  
@PublicApi(since = "1.0.0")
        static final String IP = "ip";
        recoverySource.writeTo(out);
    public RecoveryState(ShardRouting shardRouting, DiscoveryNode targetNode, @Nullable DiscoveryNode sourceNode) {
    }  
            builder.field(Fields.ID, sourceNode.getId());
 */
        @Override
        static final String STAGE = "stage";
        DONE((byte) 5);
     * Verifys the lucene index
        @Override
        public synchronized int totalOperationsOnStart() {
            this.checkIndexTime = checkIndexTime;
            case FINALIZE:  
    public ShardId getShardId() {
    private ShardId shardId;
    public ReplicationTimer getTimer() {
        builder.startObject(Fields.INDEX);  
        assert shardRouting.initializing() : "only allow initializing shard routing to be recovered: " + shardRouting;  
            builder.field(Fields.NAME, sourceNode.getName());
     * The translog
        ReplicationLuceneIndex index
        }
            total = UNKNOWN;
                + total  
import org.opensearch.cluster.routing.ShardRouting;  
            );  
            builder.timeField(Fields.STOP_TIME_IN_MILLIS, Fields.STOP_TIME, timer.stopTime());
            builder.humanReadableField(Fields.TOTAL_TIME_IN_MILLIS, Fields.TOTAL_TIME, new TimeValue(time()));
 * this work for additional information regarding copyright
         * this does change during recovery.  
        builder.field(Fields.ID, targetNode.getId());
 * @opensearch.api  
package org.opensearch.indices.recovery;
                + total
            default:  
            totalLocal = in.readVInt();
                STAGES[stage.id] = stage;
        }
        out.writeBoolean(primary);
/*  
import org.opensearch.core.common.io.stream.Writeable;  
     * Returns recovery source node (only non-null if peer recovery)
            super.reset();
                getVerifyIndex().stop();  
            super.writeTo(out);  
                + recovered  
 *
/*  
        shardId.writeTo(out);
     * @opensearch.api  
        static final String STOP_TIME = "stop_time";  
        TRANSLOG((byte) 3),  
         */  
        builder.endObject();  
         */
    public synchronized Stage getStage() {  
            builder.field(Fields.PERCENT, String.format(Locale.ROOT, "%1.1f%%", recoveredPercent()));  
        }
        translog = new Translog(in);
            super.reset();
 *
        public static final int UNKNOWN = -1;
            : "peer recovery requires source node, recovery type: " + recoverySource.getType() + " source node: " + sourceNode;  
        builder.field(Fields.NAME, targetNode.getName());  
            }
            return this.totalOnStart;
        builder.endObject();
            throw new IllegalStateException(
            builder.startObject(Fields.SOURCE);
        }
        return index;
            assert false : "can't move recovery to stage [" + next + "]. current stage: [" + stage + "] (expected [" + expected + "])";  
        builder.field(Fields.PRIMARY, primary);
        out.writeByte(stage.id());  
         */
                + recovered  
        this(shardRouting, targetNode, sourceNode, new ReplicationLuceneIndex());  
    }
        }
        }
        primary = in.readBoolean();  
         * A value of -1 ({@link RecoveryState.Translog#UNKNOWN} is return if this is unknown (typically a gateway recovery)
    @Override  
                + "]";
        }
        }
        switch (stage) {
        static final String STOP_TIME_IN_MILLIS = "stop_time_in_millis";
 *
         * recovery of lucene files, either reusing local ones are copying new ones  
 * under the License.  
        builder.endObject();
            out.writeVInt(totalOnStart);  
         * <p>
            return id;
        }
    }
         * Note that this can change as the number of operations grows during recovery.
            return builder;  
        DiscoveryNode targetNode,
                getTimer().stop();
        this.sourceNode = sourceNode;
    @Nullable  
        builder.field(Fields.STAGE, stage.toString());  
                "can't move recovery to stage [" + next + "]. current stage: [" + stage + "] (expected [" + expected + "])"
                break;  
    @Override  
        static {
    }  
        public byte id() {  
        static final String TOTAL = "total";
    public VerifyIndex getVerifyIndex() {
        timer = new ReplicationTimer(in);  
    public boolean getPrimary() {  
            throw new IllegalStateException("expected stage [" + expected + "] but current stage is [" + stage + "]");
        this.recoverySource = recoverySource;  
        private int total = UNKNOWN;
            }
 * this file be licensed under the Apache-2.0 license or a
    public DiscoveryNode getTargetNode() {
            totalOnStart = in.readVInt();  
        public synchronized void incrementRecoveredOperations() {  
        static final String SOURCE = "source";
            builder.humanReadableField(Fields.TOTAL_TIME_IN_MILLIS, Fields.TOTAL_TIME, new TimeValue(time()));
    }
    private boolean primary;  
        static final String TOTAL_TIME = "total_time";
         * returns the total number of translog operations needed to be recovered at this moment.
    private final Translog translog;  
            recovered -= ops;
        static final String CHECK_INDEX_TIME_IN_MILLIS = "check_index_time_in_millis";
        static final String TOTAL_ON_START = "total_on_start";  
         * performing final task after all translog ops have been done  
        return this;  
        /**
            out.writeVInt(totalLocal);
        }
