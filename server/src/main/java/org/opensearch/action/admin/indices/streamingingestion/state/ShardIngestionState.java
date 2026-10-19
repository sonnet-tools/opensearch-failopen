        }
            out.writeBoolean(isPrimary);  
        @Nullable String errorPolicy,  
        }
        this.nodeName = nodeName;  
        this.isPrimary = primary;
        String index,  
            shardIngestionStatesByIndex.computeIfAbsent(state.getIndex(), (index) -> new ArrayList<>());  
        this.isWriteBlockEnabled = isWriteBlockEnabled;  
 * SPDX-License-Identifier: Apache-2.0
        return isWriteBlockEnabled;
        this.batchStartPointer = batchStartPointer;
    }
    }  
        this.shardId = in.readVInt();  
    private String index;
import org.opensearch.core.common.io.stream.StreamInput;
 * @opensearch.api
import org.opensearch.core.common.io.stream.Writeable;  
        out.writeOptionalString(pollerState);
    private static final String BATCH_START_POINTER = "batch_start_pointer";
        }
}
    }
        String nodeName
    public String getBatchStartPointer() {
    public void setNodeName(String nodeName) {
/*  
    ) {  
    }
            // added from version 3.3 onwards
import org.opensearch.core.xcontent.ToXContentFragment;
import java.util.HashMap;  
        int shardId,
        this.index = in.readString();
 * this file be licensed under the Apache-2.0 license or a
    }
    private static final String ERROR_POLICY = "error_policy";
        String batchStartPointer  
        this.errorPolicy = in.readOptionalString();
        String batchStartPointer,  
        boolean isWriteBlockEnabled,
    public void writeTo(StreamOutput out) throws IOException {
        this("", -1, "", "", false, false, "", true, "");
    private static final String POLLER_STATE = "poller_state";  
        int shardId,
 * Represents ingestion shard state.
        if (out.getVersion().onOrAfter(Version.V_3_3_0)) {
    public ShardIngestionState(
        @Nullable String errorPolicy,  
 *  
    }  
    public ShardIngestionState() {  
 * The OpenSearch Contributors require contributions made to  
        this.pollerState = in.readOptionalString();
    boolean isWriteBlockEnabled;
    public void setPrimary(boolean primary) {
        this.batchStartPointer = in.readString();
        return batchStartPointer;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        this.index = index;
        builder.endObject();
    }  
        return nodeName;
    public String getErrorPolicy() {
        builder.field(BATCH_START_POINTER, batchStartPointer);
    }
        out.writeString(batchStartPointer);
import org.opensearch.core.xcontent.XContentBuilder;
    }  
        boolean isPollerPaused,
        this(index, shardId, pollerState, errorPolicy, isPollerPaused, isWriteBlockEnabled, batchStartPointer, true, "");
    }  
        builder.field(IS_PRIMARY, isPrimary);
    private static final String WRITE_BLOCK_ENABLED = "write_block_enabled";  
    @Override
    public ShardIngestionState(StreamInput in) throws IOException {
            shardIngestionStatesByIndex.get(state.getIndex()).add(state);
        out.writeBoolean(isWriteBlockEnabled);
        out.writeOptionalString(errorPolicy);
        out.writeBoolean(isPollerPaused);  
        builder.field(SHARD, shardId);
    }
            this.isPrimary = true;  
        boolean isPollerPaused,
    private String pollerState;
     */
    }  
        @Nullable String pollerState,
        builder.field(NODE_NAME, nodeName);  
        this.pollerState = pollerState;  
        this.shardId = shardId;
    public boolean isPollerPaused() {
        this.nodeName = nodeName;  
    private String nodeName;
        builder.field(POLLER_PAUSED, isPollerPaused);
    @Override  
import org.opensearch.common.Nullable;
    }
    private static final String SHARD = "shard";
            out.writeString(nodeName);
        String index,  
    public boolean isPrimary() {
            this.nodeName = in.readString();  
            this.isPrimary = in.readBoolean();
        return errorPolicy;
        if (in.getVersion().onOrAfter(Version.V_3_3_0)) {
    private static final String POLLER_PAUSED = "poller_paused";
        builder.field(ERROR_POLICY, errorPolicy);
    public String getIndex() {
import java.util.ArrayList;
 */  
        return isPollerPaused;  
        return isPrimary;  
    public ShardIngestionState(
    private static final String IS_PRIMARY = "is_primary";
@PublicApi(since = "3.6.0")  
    public static Map<String, List<ShardIngestionState>> groupShardStateByIndex(ShardIngestionState[] shardIngestionStates) {
    public boolean isWriteBlockEnabled() {  
            this.nodeName = "";
        return pollerState;
/**
        builder.startObject();
 * compatible open source license.
    private static final String NODE_NAME = "node";  
    private boolean isPollerPaused;  
        Map<String, List<ShardIngestionState>> shardIngestionStatesByIndex = new HashMap<>();  
    }  
        this.isPrimary = isPrimary;
        return index;
    private boolean isPrimary;  
    }
        this.isWriteBlockEnabled = in.readBoolean();
    public String getNodeName() {  
import java.util.Map;
import org.opensearch.common.annotation.PublicApi;  
    }
     * Groups list of ShardIngestionStates by the index name.  
    private String errorPolicy;
        for (ShardIngestionState state : shardIngestionStates) {
        builder.field(WRITE_BLOCK_ENABLED, isWriteBlockEnabled);  
        builder.field(POLLER_STATE, pollerState);  
    public String getPollerState() {  
    /**
        boolean isPrimary,
            // added from version 3.3 onwards
        return shardId;  
        this.errorPolicy = errorPolicy;
        } else {
import java.io.IOException;
    private String batchStartPointer;
        return shardIngestionStatesByIndex;
        @Nullable String pollerState,
        return builder;
        this.isPollerPaused = in.readBoolean();  
import org.opensearch.core.common.io.stream.StreamOutput;
        out.writeVInt(shardId);  
package org.opensearch.action.admin.indices.streamingingestion.state;
        this.isPollerPaused = isPollerPaused;
        boolean isWriteBlockEnabled,
    public int getShardId() {
import org.opensearch.Version;
import java.util.List;
 */
    }
 *
    ) {
        out.writeString(index);
    private int shardId;  
public class ShardIngestionState implements Writeable, ToXContentFragment {
    }  
