    ) {
    @PublicApi(since = "1.0.0")
            builder.field(Fields.RECOVERED, recovered);
    }
        }
        }
        assert (recoverySource.getType() == RecoverySource.Type.PEER) == (sourceNode != null)
                + total
        /**
        return shardId;
        }
                + recovered
        builder.startObject(Fields.TARGET);
            builder.field(Fields.TRANSPORT_ADDRESS, sourceNode.getAddress().toString());
        static final String TRANSLOG = "translog";
        }
    private ShardId shardId;
        return recoverySource;
        public Translog() {}
         */
        this.shardId = shardRouting.shardId();
        builder.field(Fields.TRANSPORT_ADDRESS, targetNode.getAddress().toString());
}
        out.writeOptionalWriteable(sourceNode);
    public synchronized RecoveryState setStage(Stage stage) {
                getVerifyIndex().reset();
            checkIndexTime = in.readVLong();
        }
            builder.field(Fields.ID, sourceNode.getId());
                throw new IllegalArgumentException("unknown RecoveryState.Stage [" + stage + "]");
            return total;
                + "], recovered ["
        }
            recovered -= ops;
                break;
    }
    public synchronized void validateCurrentStage(Stage expected) {
import org.opensearch.cluster.routing.ShardRouting;
        DONE((byte) 5);
                + recovered
        translog.writeTo(out);
            return recovered * 100.0f / total;
        /**
                break;
     *
    }
import org.opensearch.core.common.io.stream.Writeable;
    }
            totalOnStart = UNKNOWN;
        static {
         * Note that this can change as the number of operations grows during recovery.
         */
        builder.field(Fields.ID, shardId.id());
            if (total == UNKNOWN) {
                validateAndSetStage(Stage.INDEX, stage);
    public RecoveryState(ShardRouting shardRouting, DiscoveryNode targetNode, @Nullable DiscoveryNode sourceNode) {
        public synchronized void reset() {
        public synchronized int totalOperations() {
         * @see IndexShard#recoverLocallyUpToGlobalCheckpoint()
 * @opensearch.api
     *
 *
        }
    }
        public static Stage fromId(byte id) {
            throw new IllegalStateException(
        index.writeTo(out);
        verifyIndex.toXContent(builder, params);
    }
            assert total == UNKNOWN || total >= recovered : "total, if known, should be > recovered. total ["
 * under the License.
    private RecoverySource recoverySource;
        public static final int UNKNOWN = -1;
        primary = in.readBoolean();
            case INDEX:
        /**
    @Override
/*
import org.opensearch.cluster.routing.RecoverySource;
 *
        builder.field(Fields.TYPE, recoverySource.getType());
            throw new IllegalStateException("expected stage [" + expected + "] but current stage is [" + stage + "]");
                validateAndSetStage(Stage.FINALIZE, stage);
        VERIFY_INDEX((byte) 2),
        recoverySource = RecoverySource.readFrom(in);
 * Modifications Copyright OpenSearch Contributors. See
        }
         * returns the total number of translog operations recovered so far
            recoverySource.addAdditionalFields(builder, params);
        public VerifyIndex() {}
        }
     * The stage of the recovery state
            assert recovered >= 0 : "recovered operations must be non-negative. Because ["
            builder.startObject(Fields.SOURCE);
        RecoverySource recoverySource = shardRouting.recoverySource();
            super(in);
        static final String TRANSPORT_ADDRESS = "transport_address";
        return this.stage;
        builder.endObject();
        builder.humanReadableField(Fields.TOTAL_TIME_IN_MILLIS, Fields.TOTAL_TIME, new TimeValue(timer.time()));
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.index.shard.IndexShard;
        public synchronized void decrementRecoveredOperations(int ops) {
            );
        stage = next;
    public static class Translog extends ReplicationTimer implements ToXContentFragment, Writeable {
         * potentially running check index
            this.id = id;
         */
        private int totalLocal = UNKNOWN;
            this.totalLocal = totalLocal;
        ShardRouting shardRouting,
 * ownership. Elasticsearch licenses this file to you under
        return targetNode;
 * KIND, either express or implied.  See the License for the
    private DiscoveryNode targetNode;
        builder.field(Fields.ID, targetNode.getId());
    }
    }
            super(in);
    }
            assert false : "expected stage [" + expected + "]; but current stage is [" + stage + "]";
    }
        return this.verifyIndex;
        static final String TOTAL_TIME_IN_MILLIS = "total_time_in_millis";
     * @opensearch.api
        public synchronized XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        this.index = index;
                this.stage = Stage.INIT;
                "can't move recovery to stage [" + next + "]. current stage: [" + stage + "] (expected [" + expected + "])"
        @Override
    @Nullable
        switch (stage) {
            return STAGES[id];
        return index;
                + total
    /**
     */
    }
            builder.field(Fields.IP, sourceNode.getHostAddress());
        static final String RECOVERED = "recovered";
/*
        this.recoverySource = recoverySource;
     * @opensearch.internal
@PublicApi(since = "1.0.0")
    private Stage stage;
/**
        static final String CHECK_INDEX_TIME = "check_index_time";
            assert total == UNKNOWN || total >= recovered : "total, if known, should be > recovered. total ["
         * performing final task after all translog ops have been done
import org.opensearch.core.xcontent.ToXContentFragment;
 * this work for additional information regarding copyright
        public void writeTo(StreamOutput out) throws IOException {
        this.sourceNode = sourceNode;
            this.total = totalLocal == UNKNOWN ? total : totalLocal + total;
 */
                // reinitializing stop remove all state except for start time
                assert stage.id() < STAGES.length && stage.id() >= 0;
        }
            return recovered;
    }
 *
    private final ReplicationLuceneIndex index;
 * specific language governing permissions and limitations
            return builder;
import org.opensearch.core.xcontent.XContentBuilder;
        @Override
            builder.humanReadableField(Fields.CHECK_INDEX_TIME_IN_MILLIS, Fields.CHECK_INDEX_TIME, new TimeValue(checkIndexTime));
                getTimer().stop();
        static final String TYPE = "type";
                break;
            builder.field(Fields.NAME, sourceNode.getName());
    public ReplicationLuceneIndex getIndex() {
            default:
        builder.startObject(Fields.INDEX);
        translog = new Translog(in);
        static final String START_TIME_IN_MILLIS = "start_time_in_millis";
        static final String NAME = "name";
                + recovered
                validateAndSetStage(Stage.INIT, stage);
        }
        @Nullable DiscoveryNode sourceNode,
            builder.endObject();
    public ShardId getShardId() {
import java.util.Locale;
    protected void validateAndSetStage(Stage expected, Stage next) {
        }
                return 100.f;
 * this file be licensed under the Apache-2.0 license or a
        public synchronized void totalOperations(int total) {
 * the Apache License, Version 2.0 (the "License"); you may
        builder.timeField(Fields.START_TIME_IN_MILLIS, Fields.START_TIME, timer.startTime());
            this.checkIndexTime = checkIndexTime;
     */
        shardId.writeTo(out);
            this.totalOnStart = totalLocal == UNKNOWN ? total : totalLocal + total;
package org.opensearch.indices.recovery;
import org.opensearch.indices.replication.common.ReplicationState;
                getIndex().reset();
        }
            return id;
            }
         */
        public synchronized int totalOperationsOnStart() {
        /**
            }
        if (stage != expected) {
            recovered = in.readVInt();
        private int totalOnStart = UNKNOWN;
        stage = Stage.fromId(in.readByte());
            }
        public void writeTo(StreamOutput out) throws IOException {
            totalLocal = in.readVInt();
        }
                STAGES[stage.id] = stage;
            totalOnStart = in.readVInt();
        static final String HOST = "host";
    }
    public enum Stage {
            out.writeVInt(total);
            return this.totalOnStart;
    public DiscoveryNode getSourceNode() {
         * <p>
        assert shardRouting.initializing() : "only allow initializing shard routing to be recovered: " + shardRouting;
        }
                break;
    private boolean primary;
            super.writeTo(out);
            case TRANSLOG:
                getTranslog().stop();
     */
        recoverySource.writeTo(out);
import org.opensearch.indices.replication.common.ReplicationTimer;
        public synchronized void incrementRecoveredOperations(int ops) {
    public static class VerifyIndex extends ReplicationTimer implements ToXContentFragment, Writeable {
        }
            builder.field(Fields.TOTAL_ON_START, totalOnStart);
                + "] after decrementing ["
        public VerifyIndex(StreamInput in) throws IOException {
    private final ReplicationTimer timer;
            super.writeTo(out);
                + "]";
        return timer;
        translog.toXContent(builder, params);
        static final String INDEX = "index";
        static final String STOP_TIME_IN_MILLIS = "stop_time_in_millis";
     *
        }
        timer.writeTo(out);
                getTranslog().reset();
            checkIndexTime = 0;
            builder.humanReadableField(Fields.TOTAL_TIME_IN_MILLIS, Fields.TOTAL_TIME, new TimeValue(time()));
    }
        public synchronized int totalLocal() {
 * not use this file except in compliance with the License.
        if (timer.stopTime() > 0) {
         */
         * Sets the total number of translog operations to be recovered locally before performing peer recovery
            builder.field(Fields.PERCENT, String.format(Locale.ROOT, "%1.1f%%", recoveredPercent()));
    }
     * Fields used in the recovery state
        verifyIndex = new VerifyIndex();
        INDEX((byte) 1),
            assert totalLocal >= recovered : totalLocal + " < " + recovered;
            builder.startObject(Fields.SOURCE);
        timer.start();
         */
            total = in.readVInt();
    static final class Fields {
        static final String START_TIME = "start_time";
 * The OpenSearch Contributors require contributions made to
                getIndex().stop();
        if (stage != expected) {
        this(shardRouting, targetNode, sourceNode, new ReplicationLuceneIndex());
        return translog;
    public VerifyIndex getVerifyIndex() {
    /**
    /**
 */
         * A value of -1 ({@link RecoveryState.Translog#UNKNOWN} is return if this is unknown (typically a gateway recovery)
     */
        static final String TOTAL_ON_START = "total_on_start";
    @PublicApi(since = "1.0.0")
import org.opensearch.common.Nullable;
        builder.field(Fields.PRIMARY, primary);
import org.opensearch.common.unit.TimeValue;
    @Override
            case INIT:
        shardId = new ShardId(in);
        }
            assert false : "can't move recovery to stage [" + next + "]. current stage: [" + stage + "] (expected [" + expected + "])";
    public boolean getPrimary() {
            builder.endObject();
        /**
        stage = Stage.INIT;
        }
        if (recoverySource.getType() == RecoverySource.Type.PEER) {
    // synchronized is strictly speaking not needed (this is called by a single thread), but just to be safe
            recovered = 0;
    @Nullable
 * GitHub history for details.
        /**
 * software distributed under the License is distributed on an
        public synchronized void totalOperationsOnStart(int total) {
        builder.field(Fields.NAME, targetNode.getName());
        static final String SOURCE = "source";
        }
        }
                + "]";
 * Keeps track of state related to shard recovery.
        index.toXContent(builder, params);
         * starting up the engine, replaying the translog
        targetNode = new DiscoveryNode(in);
                break;
            recovered += ops;
                + "]";
        static final String CHECK_INDEX_TIME_IN_MILLIS = "check_index_time_in_millis";
        public void reset() {
 * Licensed to Elasticsearch under one or more contributor
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
         * <p>
            out.writeVInt(totalLocal);
     */
        /**
        public synchronized float recoveredPercent() {
        static final String ID = "id";
        public void checkIndexTime(long checkIndexTime) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        FINALIZE((byte) 4),
    private DiscoveryNode sourceNode;
            builder.field(Fields.TOTAL, total);
     *
        }
            : "peer recovery requires source node, recovery type: " + recoverySource.getType() + " source node: " + sourceNode;
            out.writeVInt(recovered);
                + "]";
        }
                getTranslog().start();
import java.io.IOException;
            case DONE:
                return -1.f;
                validateAndSetStage(Stage.TRANSLOG, stage);
        builder.startObject(Fields.VERIFY_INDEX);
/*
        public synchronized void totalLocal(int totalLocal) {
        }
        }
                break;
 *
        public synchronized void incrementRecoveredOperations() {
    public RecoverySource getRecoverySource() {
        out.writeByte(stage.id());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assert total == UNKNOWN || total >= recovered : "total, if known, should be > recovered. total ["
        private static final Stage[] STAGES = new Stage[Stage.values().length];
        }
        this.primary = shardRouting.primary();
        builder.endObject();
 */
        private volatile long checkIndexTime;
                + "], recovered ["
    }
            builder.field(Fields.HOST, sourceNode.getHostName());
        static final String TARGET = "target";
                getIndex().start();
        public byte id() {
        return sourceNode;
        public synchronized int recoveredOperations() {
            return totalLocal;
        timer = new ReplicationTimer(in);
 *    http://www.apache.org/licenses/LICENSE-2.0
        return this;
                + recovered
        out.writeBoolean(primary);
                validateAndSetStage(Stage.VERIFY_INDEX, stage);
     * @opensearch.api
    private final Translog translog;
            out.writeVInt(totalOnStart);
    }
    public void writeTo(StreamOutput out) throws IOException {
        TRANSLOG((byte) 3),
            total = UNKNOWN;
                getVerifyIndex().stop();
    @Override
        private int recovered;
    @PublicApi(since = "1.0.0")
        INIT((byte) 0),
        } else {
            totalLocal = UNKNOWN;
 * You may obtain a copy of the License at
            recovered++;
            case FINALIZE:
            if (id < 0 || id >= STAGES.length) {
import org.opensearch.core.common.io.stream.StreamInput;
         * recovery of lucene files, either reusing local ones are copying new ones
        Stage(byte id) {
                + total
    public RecoveryState(
        }
        /**
import org.opensearch.core.index.shard.ShardId;
         * returns the total number of translog operations to recovered, on the start of the recovery. Unlike {@link #totalOperations}
                + ops
 * compatible open source license.
    /**
                throw new IllegalArgumentException("No mapping for id [" + id + "]");
     * Returns recovery source node (only non-null if peer recovery)
 * Unless required by applicable law or agreed to in writing,
                + recovered
        private final byte id;
        public Translog(StreamInput in) throws IOException {
    }
        verifyIndex = new VerifyIndex(in);
                + "]";
        @Override
     * The translog
            if (total == 0) {
                + total
            for (Stage stage : Stage.values()) {
        ReplicationLuceneIndex index
        static final String STAGE = "stage";
 * license agreements. See the NOTICE file distributed with
        public long checkIndexTime() {
        builder.field(Fields.IP, targetNode.getHostAddress());
        builder.startObject(Fields.TRANSLOG);
        static final String TOTAL = "total";
        }
     * Verifys the lucene index
    public Translog getTranslog() {
            }
            assert total == UNKNOWN || this.total >= recovered : "total, if known, should be > recovered. total ["
        static final String PRIMARY = "primary";
import org.opensearch.core.common.io.stream.StreamOutput;
            super.reset();
            return builder;
            return checkIndexTime;
        static final String TOTAL_TIME = "total_time";
        builder.endObject();
        }
    /**
            super.reset();
         */
        builder.endObject();
        targetNode.writeTo(out);
        this.targetNode = targetNode;
         * A value of -1 ({@link RecoveryState.Translog#UNKNOWN} is return if this is unknown (typically a gateway recovery)
        builder.field(Fields.HOST, targetNode.getHostName());
    }
                + "], recovered ["
            builder.humanReadableField(Fields.TOTAL_TIME_IN_MILLIS, Fields.TOTAL_TIME, new TimeValue(time()));
        static final String PERCENT = "percent";
    public synchronized Stage getStage() {
        sourceNode = in.readOptionalWriteable(DiscoveryNode::new);
        timer = new ReplicationTimer();
        index = new ReplicationLuceneIndex(in);
                + "], recovered ["
                assert getIndex().bytesStillToRecover() >= 0 : "moving to stage FINALIZE without completing file details";
    private final VerifyIndex verifyIndex;
         */
        @Override
    }
        private int total = UNKNOWN;
    public RecoveryState(StreamInput in) throws IOException {
        static final String STOP_TIME = "stop_time";
        return builder;
     * @opensearch.api
        DiscoveryNode targetNode,
            case VERIFY_INDEX:
         * this does change during recovery.
         * returns the total number of translog operations needed to be recovered at this moment.
public class RecoveryState implements ReplicationState, ToXContentFragment, Writeable {
    }
        builder.field(Fields.STAGE, stage.toString());
        verifyIndex.writeTo(out);
            builder.timeField(Fields.STOP_TIME_IN_MILLIS, Fields.STOP_TIME, timer.stopTime());
    public ReplicationTimer getTimer() {
    }
            out.writeVLong(checkIndexTime);
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
                getVerifyIndex().start();
        }
 */
        static final String VERIFY_INDEX = "verify_index";
        static final String IP = "ip";
import org.opensearch.common.annotation.PublicApi;
    public DiscoveryNode getTargetNode() {
        return primary;
        translog = new Translog();
