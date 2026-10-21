        }
 * The OpenSearch Contributors require contributions made to
        Map<String, Long> timingDataCopy = new HashMap<>();
        // save the timing data for the current step
        // Copy of timingData is created to avoid concurrent modification of timingData map.
                overallTimer.stop();
            this.id = id;
        stageTimer.start();
    }
        this.index = index;
        stopTimersAndSetStage(next);
        static final String INDEX_NAME = "index_name";
    public SegmentReplicationState(
import org.opensearch.common.annotation.PublicApi;
    }
        replicationId = in.readLong();
        switch (stage) {
        ShardRouting shardRouting,
    }
        if (getTimer().stopTime() > 0) {
    }
     *
            case GET_FILES:
import org.opensearch.core.xcontent.ToXContentFragment;
            case INIT:
import org.opensearch.indices.replication.common.ReplicationTimer;
        static final String IP = "ip";
        builder.field(Fields.FINALIZE_REPLICATION_STAGE, getFinalizeReplicationStageTime());
public class SegmentReplicationState implements ReplicationState, ToXContentFragment, Writeable {
                // add the overall timing data
        return this.stage;
        }
        targetNode = new DiscoveryNode(in);
        long time = timingData.getOrDefault(Stage.REPLICATING.toString(), 0L);
    public TimeValue getFinalizeReplicationStageTime() {
    public enum Stage {
        }
    public TimeValue getFileDiffStageTime() {
    public String getSourceDescription() {
import org.opensearch.core.common.io.stream.StreamOutput;
            return id;
        long time = timingData.getOrDefault(Stage.GET_CHECKPOINT_INFO.toString(), 0L);
        INIT((byte) 1),
                validateAndSetStage(Stage.INIT, stage);
    }
        }
            timingDataCopy.put(entry.getKey(), entry.getValue());
import org.opensearch.core.xcontent.ToXContent;
            }
        return new TimeValue(time);
    public Map<String, Long> getTimingData() {
    @Override
        static final String START_TIME_IN_MILLIS = "start_time_in_millis";
        static final String NAME = "name";
        this.shardRouting = shardRouting;
                throw new IllegalArgumentException("No mapping for id [" + id + "]");
        this.targetNode = targetNode;
        }
        static final String TOTAL_TIME_IN_MILLIS = "total_time_in_millis";
import java.util.Map;
        static final String HOST = "host";
import org.opensearch.core.common.io.stream.Writeable;
                break;
    private String sourceDescription;
        timingData.put(stage.name(), stageTimer.time());
        private final byte id;
    }
        long time = timingData.getOrDefault(Stage.FILE_DIFF.toString(), 0L);
    @PublicApi(since = "2.2.0")
 * @opensearch.api
        static final String GET_FILES_STAGE = "get_files_stage";
    static final class Fields {
        GET_FILES((byte) 5),
        overallTimer = new ReplicationTimer(in);
        index.toXContent(builder, params);
        builder.field(Fields.FILE_DIFF_STAGE, getFileDiffStageTime());
        this.replicationId = replicationId;
    }
    public Stage getStage() {
    ) {
     */
        private static final Stage[] STAGES = new Stage[Stage.values().length];
        out.writeMap(timingDataCopy, StreamOutput::writeString, StreamOutput::writeLong);
        return sourceDescription;
        builder.startObject(Fields.TARGET);
    }
        static final String ID = "id";
        setStage(Stage.INIT);
        REPLICATING((byte) 2),
            assert false : "can't move replication to stage [" + next + "]. current stage: [" + stage + "] (expected [" + expected + "])";
    }
import org.opensearch.core.xcontent.XContentBuilder;
import java.io.IOException;
        }
        return shardRouting;
    }
    public void setStage(Stage stage) {
 */
                STAGES[stage.id] = stage;
                // only start the overall timer once we've started replication
        timingData = in.readMap(StreamInput::readString, StreamInput::readLong);
        shardRouting.writeTo(out);
        String sourceDescription,
        // Timing data will have as many entries as stages, plus one
        return timingData;
    public ReplicationLuceneIndex getIndex() {
    public ReplicationTimer getTimer() {
    }
        return targetNode;
        return new TimeValue(time);
        return new TimeValue(time);
            case FINALIZE_REPLICATION:
        stageTimer.writeTo(out);
import org.opensearch.common.unit.TimeValue;
    public long getReplicationId() {
        static final String STAGE = "stage";
            if (id < 0 || id >= STAGES.length) {
        builder.humanReadableField(Fields.TOTAL_TIME_IN_MILLIS, Fields.TOTAL_TIME, new TimeValue(getTimer().time()));
import java.util.HashMap;
    }
        overallTimer = new ReplicationTimer();
    }
    public ShardRouting getShardRouting() {
    }
        static final String STOP_TIME = "stop_time";
                break;
        // restart the step timer
        sourceDescription = in.readString();
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
}
 *
                this.stage = Stage.INIT;
    }
            case REPLICATING:
        builder.field(Fields.IP, targetNode.getHostAddress());
    private long replicationId;
                validateAndSetStage(Stage.FINALIZE_REPLICATION, stage);
        stage = next;
        builder.timeField(Fields.START_TIME_IN_MILLIS, Fields.START_TIME, getTimer().startTime());
        index = new ReplicationLuceneIndex(in);
    }
            case GET_CHECKPOINT_INFO:
        long time = timingData.getOrDefault(Stage.FINALIZE_REPLICATION.toString(), 0L);
        overallTimer.writeTo(out);
 * SPDX-License-Identifier: Apache-2.0
        shardRouting = new ShardRouting(in);
        builder.startObject(SegmentReplicationState.Fields.INDEX);
                assert stage.id() < STAGES.length && stage.id() >= 0;
                break;
                break;
        static {
        FINALIZE_REPLICATION((byte) 6);
    }
        if (stage != expected) {
            for (Stage stage : Stage.values()) {
        timingData = new ConcurrentHashMap<>(Stage.values().length + 1);
        builder.field(Fields.REPLICATING_STAGE, getReplicatingStageTime());
     * @opensearch.api
    }
            case DONE:
        stageTimer.reset();
                validateAndSetStage(Stage.GET_CHECKPOINT_INFO, stage);
    protected void validateAndSetStage(Stage expected, Stage next) {
    @Override
    private final ShardRouting shardRouting;
        builder.field(Fields.ID, shardRouting.shardId().id());
@PublicApi(since = "2.2.0")
    public TimeValue getGetCheckpointInfoStageTime() {
        ReplicationLuceneIndex index,
    /**
        static final String REPLICATING_STAGE = "replicating_stage";
            throw new IllegalStateException(
        static final String TARGET = "target";
import org.opensearch.cluster.routing.ShardRouting;
 * this file be licensed under the Apache-2.0 license or a
        static final String INDEX = "index";
        builder.field(Fields.NAME, targetNode.getName());
        stageTimer.stop();
                validateAndSetStage(Stage.REPLICATING, stage);
    private void stopTimersAndSetStage(Stage next) {
        this.sourceDescription = sourceDescription;
        static final String START_TIME = "start_time";
        builder.field(Fields.GET_FILES_STAGE, getGetFileStageTime());
        static final String TRANSPORT_ADDRESS = "transport_address";
    @Override
            builder.timeField(Fields.STOP_TIME_IN_MILLIS, Fields.STOP_TIME, getTimer().stopTime());
     * The stage of the recovery state
        public static Stage fromId(byte id) {
        static final String SOURCE = "source";
        for (Map.Entry<String, Long> entry : timingData.entrySet()) {
    public TimeValue getReplicatingStageTime() {
 *
import org.opensearch.core.common.io.stream.StreamInput;
        return builder;
    public SegmentReplicationState(StreamInput in) throws IOException {
        builder.field(Fields.STAGE, getStage());
/**
                "can't move replication to stage [" + next + "]. current stage: [" + stage + "] (expected [" + expected + "])"
        builder.endObject();
        static final String TOTAL_TIME = "total_time";
                break;
        out.writeEnum(stage);
        stageTimer.start();
        }
 */
        static final String FINALIZE_REPLICATION_STAGE = "finalize_replication_stage";
    private ReplicationLuceneIndex index;
    }
        return new TimeValue(time);
    }
        DiscoveryNode targetNode
    private Stage stage;
            case FILE_DIFF:
            );
    private final Map<String, Long> timingData;
        builder.field(Fields.HOST, targetNode.getHostName());
import org.opensearch.cluster.node.DiscoveryNode;
 * ReplicationState implementation to track Segment Replication events.
import java.util.concurrent.ConcurrentHashMap;
                overallTimer.start();
        static final String STOP_TIME_IN_MILLIS = "stop_time_in_millis";
        builder.endObject();
        return overallTimer;
    private final ReplicationTimer overallTimer;
            }
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
    @Override
        return replicationId;
        GET_CHECKPOINT_INFO((byte) 3),
        }
        FILE_DIFF((byte) 4),
    private final ReplicationTimer stageTimer;
import org.opensearch.indices.replication.common.ReplicationState;
        return index;
        DONE((byte) 0),
    }
        long time = timingData.getOrDefault(Stage.GET_FILES.toString(), 0L);
        builder.field(Fields.TRANSPORT_ADDRESS, targetNode.getAddress().toString());
    }
        long replicationId,
    public DiscoveryNode getTargetNode() {
        builder.field(Fields.SOURCE, getSourceDescription());
                break;
        stageTimer = new ReplicationTimer(in);
        public byte id() {
        Stage(byte id) {
                break;
package org.opensearch.indices.replication;
        targetNode.writeTo(out);
        static final String GET_CHECKPOINT_INFO_STAGE = "get_checkpoint_info_stage";
            return STAGES[id];
    public void writeTo(StreamOutput out) throws IOException {
                validateAndSetStage(Stage.GET_FILES, stage);
 * compatible open source license.
            default:
        static final String FILE_DIFF_STAGE = "file_diff_stage";
        return new TimeValue(time);
    private DiscoveryNode targetNode;
        stageTimer = new ReplicationTimer();
        builder.field(Fields.ID, targetNode.getId());
                validateAndSetStage(Stage.FILE_DIFF, stage);
        builder.field(Fields.GET_CHECKPOINT_INFO_STAGE, getGetCheckpointInfoStageTime());
        index.writeTo(out);
/*
        builder.field(Fields.INDEX_NAME, shardRouting.index().getName());
        out.writeLong(replicationId);
                timingData.put("OVERALL", overallTimer.time());
        out.writeString(sourceDescription);
        stage = in.readEnum(Stage.class);
                throw new IllegalArgumentException("unknown SegmentReplicationState.Stage [" + stage + "]");
    public TimeValue getGetFileStageTime() {
