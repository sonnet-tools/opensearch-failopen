                break;
        return new TimeValue(time);  
    public ReplicationLuceneIndex getIndex() {
    }  
        return new TimeValue(time);
        builder.startObject(SegmentReplicationState.Fields.INDEX);
        static final String ID = "id";
        builder.field(Fields.FINALIZE_REPLICATION_STAGE, getFinalizeReplicationStageTime());
                timingData.put("OVERALL", overallTimer.time());
        stageTimer.writeTo(out);  
        String sourceDescription,
        return index;  
    static final class Fields {  
        long replicationId,  
 */  
        this.shardRouting = shardRouting;
            throw new IllegalStateException(  
    @Override
        out.writeEnum(stage);  
    ) {  
 * ReplicationState implementation to track Segment Replication events.  
                validateAndSetStage(Stage.GET_FILES, stage);
    }
@PublicApi(since = "2.2.0")
    @PublicApi(since = "2.2.0")  
    public Stage getStage() {  
            builder.timeField(Fields.STOP_TIME_IN_MILLIS, Fields.STOP_TIME, getTimer().stopTime());
        stageTimer = new ReplicationTimer(in);
        builder.field(Fields.NAME, targetNode.getName());
        static final String TARGET = "target";
    }
    private String sourceDescription;  
    }  
    public ReplicationTimer getTimer() {
        private final byte id;
        stageTimer.stop();  
        static final String TOTAL_TIME_IN_MILLIS = "total_time_in_millis";
                break;
import org.opensearch.core.xcontent.ToXContentFragment;  
        GET_FILES((byte) 5),
        }
        builder.field(Fields.INDEX_NAME, shardRouting.index().getName());
        builder.humanReadableField(Fields.TOTAL_TIME_IN_MILLIS, Fields.TOTAL_TIME, new TimeValue(getTimer().time()));  
            this.id = id;
public class SegmentReplicationState implements ReplicationState, ToXContentFragment, Writeable {
        builder.endObject();  
            case FINALIZE_REPLICATION:  
    public SegmentReplicationState(  
        if (getTimer().stopTime() > 0) {  
    }
    public ShardRouting getShardRouting() {  
        static final String TOTAL_TIME = "total_time";
        return new TimeValue(time);
                break;
        static final String REPLICATING_STAGE = "replicating_stage";
        builder.field(Fields.HOST, targetNode.getHostName());
        long time = timingData.getOrDefault(Stage.FILE_DIFF.toString(), 0L);
        long time = timingData.getOrDefault(Stage.GET_FILES.toString(), 0L);  
    private DiscoveryNode targetNode;
        // restart the step timer
    @Override
        builder.timeField(Fields.START_TIME_IN_MILLIS, Fields.START_TIME, getTimer().startTime());
    private void stopTimersAndSetStage(Stage next) {
        static final String INDEX = "index";
import org.opensearch.core.xcontent.XContentBuilder;
                throw new IllegalArgumentException("No mapping for id [" + id + "]");
        static final String SOURCE = "source";  
            case GET_CHECKPOINT_INFO:  
        this.index = index;
    }  
    protected void validateAndSetStage(Stage expected, Stage next) {  
        static {  
    }
    }
 * compatible open source license.
                overallTimer.start();
    public TimeValue getFinalizeReplicationStageTime() {
        static final String HOST = "host";
            for (Stage stage : Stage.values()) {
        Map<String, Long> timingDataCopy = new HashMap<>();  
        Stage(byte id) {  
        builder.startObject(Fields.TARGET);  
        builder.field(Fields.GET_CHECKPOINT_INFO_STAGE, getGetCheckpointInfoStageTime());
    }
        builder.field(Fields.SOURCE, getSourceDescription());
            return STAGES[id];  
        static final String STAGE = "stage";
                validateAndSetStage(Stage.FILE_DIFF, stage);
        public byte id() {
        builder.field(Fields.GET_FILES_STAGE, getGetFileStageTime());  
                validateAndSetStage(Stage.REPLICATING, stage);
        static final String NAME = "name";
        stopTimersAndSetStage(next);
import org.opensearch.cluster.node.DiscoveryNode;
                "can't move replication to stage [" + next + "]. current stage: [" + stage + "] (expected [" + expected + "])"
                STAGES[stage.id] = stage;  
        return overallTimer;  
            timingDataCopy.put(entry.getKey(), entry.getValue());
        overallTimer.writeTo(out);
        sourceDescription = in.readString();
    public TimeValue getGetFileStageTime() {
        for (Map.Entry<String, Long> entry : timingData.entrySet()) {
                validateAndSetStage(Stage.GET_CHECKPOINT_INFO, stage);
    public TimeValue getReplicatingStageTime() {
            case GET_FILES:  
import java.util.concurrent.ConcurrentHashMap;  
            case DONE:  
     *  
        DONE((byte) 0),
    private final Map<String, Long> timingData;
    }  
                break;  
    public TimeValue getFileDiffStageTime() {  
        stageTimer.reset();  
    public TimeValue getGetCheckpointInfoStageTime() {
    }
        return shardRouting;
        static final String FINALIZE_REPLICATION_STAGE = "finalize_replication_stage";
 */  
        shardRouting.writeTo(out);
import org.opensearch.core.common.io.stream.StreamInput;
        overallTimer = new ReplicationTimer();
    private final ReplicationTimer stageTimer;  
        }
    private long replicationId;
 * @opensearch.api
        return sourceDescription;  
            }
            assert false : "can't move replication to stage [" + next + "]. current stage: [" + stage + "] (expected [" + expected + "])";
import org.opensearch.cluster.routing.ShardRouting;
            }
        public static Stage fromId(byte id) {
        this.replicationId = replicationId;  
    /**
    }  
    public void setStage(Stage stage) {
        builder.endObject();
        timingData = in.readMap(StreamInput::readString, StreamInput::readLong);  
                overallTimer.stop();  
        static final String INDEX_NAME = "index_name";  
    private final ReplicationTimer overallTimer;
    }
 * SPDX-License-Identifier: Apache-2.0
        FILE_DIFF((byte) 4),  
    private ReplicationLuceneIndex index;
        stage = in.readEnum(Stage.class);
 * The OpenSearch Contributors require contributions made to  
    }
        stage = next;
        private static final Stage[] STAGES = new Stage[Stage.values().length];
        targetNode.writeTo(out);  
        out.writeString(sourceDescription);
            if (id < 0 || id >= STAGES.length) {  
}
        }
        switch (stage) {  
        }
        overallTimer = new ReplicationTimer(in);
        GET_CHECKPOINT_INFO((byte) 3),
import org.opensearch.core.xcontent.ToXContent;
        static final String IP = "ip";  
        builder.field(Fields.TRANSPORT_ADDRESS, targetNode.getAddress().toString());  
        stageTimer.start();
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
            case REPLICATING:
            );
                assert stage.id() < STAGES.length && stage.id() >= 0;
        timingData = new ConcurrentHashMap<>(Stage.values().length + 1);
        this.targetNode = targetNode;
        }  
                this.stage = Stage.INIT;
        long time = timingData.getOrDefault(Stage.FINALIZE_REPLICATION.toString(), 0L);
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {  
        FINALIZE_REPLICATION((byte) 6);
    public Map<String, Long> getTimingData() {
        targetNode = new DiscoveryNode(in);
        DiscoveryNode targetNode
import org.opensearch.common.unit.TimeValue;
import org.opensearch.core.common.io.stream.StreamOutput;  
                // add the overall timing data
        out.writeLong(replicationId);
        index.writeTo(out);
        static final String STOP_TIME_IN_MILLIS = "stop_time_in_millis";  
/*  
        }
        if (stage != expected) {
 *
 * this file be licensed under the Apache-2.0 license or a
        return this.stage;
                break;
import org.opensearch.indices.replication.common.ReplicationState;  
        ShardRouting shardRouting,
        static final String GET_FILES_STAGE = "get_files_stage";
                break;
        return new TimeValue(time);  
    private final ShardRouting shardRouting;
    @Override
        }  
    }
import java.util.Map;
        builder.field(Fields.FILE_DIFF_STAGE, getFileDiffStageTime());
    public void writeTo(StreamOutput out) throws IOException {  
        // save the timing data for the current step
    @Override
    }
            case FILE_DIFF:  
     */
        return new TimeValue(time);
import org.opensearch.indices.replication.common.ReplicationTimer;
        }  
        replicationId = in.readLong();  
     * @opensearch.api
        INIT((byte) 1),  
        timingData.put(stage.name(), stageTimer.time());
        long time = timingData.getOrDefault(Stage.GET_CHECKPOINT_INFO.toString(), 0L);
import org.opensearch.common.annotation.PublicApi;  
            case INIT:
        ReplicationLuceneIndex index,
                throw new IllegalArgumentException("unknown SegmentReplicationState.Stage [" + stage + "]");
        static final String START_TIME = "start_time";  
        // Timing data will have as many entries as stages, plus one  
        // Copy of timingData is created to avoid concurrent modification of timingData map.
        static final String STOP_TIME = "stop_time";
        return builder;  
    }
    }
import org.opensearch.core.common.io.stream.Writeable;
    }
                // only start the overall timer once we've started replication  
    private Stage stage;
        index = new ReplicationLuceneIndex(in);  
        setStage(Stage.INIT);
            default:  
        index.toXContent(builder, params);  
        shardRouting = new ShardRouting(in);
        stageTimer.start();
        builder.field(Fields.ID, targetNode.getId());
        static final String GET_CHECKPOINT_INFO_STAGE = "get_checkpoint_info_stage";
        stageTimer = new ReplicationTimer();  
        builder.field(Fields.REPLICATING_STAGE, getReplicatingStageTime());  
/**
                validateAndSetStage(Stage.FINALIZE_REPLICATION, stage);
import java.io.IOException;  
        out.writeMap(timingDataCopy, StreamOutput::writeString, StreamOutput::writeLong);
    public String getSourceDescription() {
        builder.field(Fields.IP, targetNode.getHostAddress());
    }
     * The stage of the recovery state
    public long getReplicationId() {  
    }  
    }  
        return targetNode;
        builder.field(Fields.ID, shardRouting.shardId().id());  
package org.opensearch.indices.replication;
        builder.field(Fields.STAGE, getStage());
        return replicationId;
        static final String FILE_DIFF_STAGE = "file_diff_stage";  
        this.sourceDescription = sourceDescription;
        static final String TRANSPORT_ADDRESS = "transport_address";
    public DiscoveryNode getTargetNode() {  
                break;
        static final String START_TIME_IN_MILLIS = "start_time_in_millis";
    public SegmentReplicationState(StreamInput in) throws IOException {
    public enum Stage {
            return id;
import java.util.HashMap;
        REPLICATING((byte) 2),
                validateAndSetStage(Stage.INIT, stage);
        long time = timingData.getOrDefault(Stage.REPLICATING.toString(), 0L);  
        return timingData;
 *
