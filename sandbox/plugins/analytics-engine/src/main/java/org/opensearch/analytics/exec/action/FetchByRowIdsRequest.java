        this.stageId = in.readInt();
 * The OpenSearch Contributors require contributions made to  
    public String[] getColumns() {
        return shardId;  
        return backendId;
    private final String backendId;
public class FetchByRowIdsRequest extends ActionRequest implements ShardInvocationRequest {
        out.writeInt(stageId);
    }  
import org.opensearch.core.tasks.TaskId;
import org.opensearch.core.common.io.stream.StreamInput;
 * {@code AnalyticsSearchService.executeFetchByRowIds} that picked a backend with  
    private final ShardId shardId;  
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.action.ActionRequestValidationException;
 *
        return columns;  
    public String getBackendId() {  
        this(queryId, stageId, shardId, backendId, rowIds, columns, false);
        this.rowIds = rowIds;
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
        return rowIds;
 * the data node by {@link FetchByRowIdsAction}; resolved against the same backend that ran
    }
 * SPDX-License-Identifier: Apache-2.0
        return stageId;
        this.profile = profile;
 * compatible open source license.
        this.columns = columns;  
import java.util.Map;
        return profile;
    }
    @Override
    }
        ShardId shardId,
    public String getQueryId() {
        this.stageId = stageId;
        super(in);
    private final String queryId;
    public void writeTo(StreamOutput out) throws IOException {
    }
        return new AnalyticsShardTask(id, type, action, desc, parentTaskId, headers);
    public int getStageId() {  
    public long[] getRowIds() {
 * {@code backends.values().iterator().next()}.
        out.writeBoolean(profile);  
    }
 *
        shardId.writeTo(out);
import org.opensearch.core.index.shard.ShardId;  
}
 * the query phase via {@code backendId} — replaces the prior 5-arg
 */
 * Per-shard QTF (Query-Then-Fetch / late-materialization) fetch-by-rowids request. Carries
        out.writeLongArray(rowIds);
    @Override  
    private final long[] rowIds;
 * @opensearch.internal  
    public boolean profile() {  
        out.writeString(backendId);  
 * this file be licensed under the Apache-2.0 license or a
        this.queryId = queryId;
 */  
    }
    private final boolean profile;
    }  
    private final int stageId;
        this.backendId = in.readString();  
 * the ascending {@code rowIds} (data-node contract) plus the column projection. Routed to  
        this.queryId = in.readString();  
        out.writeStringArray(columns);
        this.columns = in.readStringArray();
        this.backendId = backendId;
        int stageId,  
import org.opensearch.action.ActionRequest;
package org.opensearch.analytics.exec.action;
        String queryId,
        long[] rowIds,  
    }
        this.profile = in.readBoolean();  
        String desc = "queryId[" + queryId + "] stageId[" + stageId + "] shardId[" + shardId + "] rowIds[" + rowIds.length + "]";  
        String[] columns,
        this.shardId = shardId;  
    @Override
    ) {  
        boolean profile
    }
    @Override
        out.writeString(queryId);  
        return queryId;
    }
import org.opensearch.analytics.exec.task.AnalyticsShardTask;  
    public FetchByRowIdsRequest(
    }
import java.io.IOException;
        this.rowIds = in.readLongArray();
    }
    @Override
    private final String[] columns;  
        this.shardId = new ShardId(in);
        String backendId,
    @Override  
    public FetchByRowIdsRequest(StreamInput in) throws IOException {
        return null;  
        super.writeTo(out);
    public ActionRequestValidationException validate() {
/*  
    public FetchByRowIdsRequest(String queryId, int stageId, ShardId shardId, String backendId, long[] rowIds, String[] columns) {  
/**
    public ShardId getShardId() {
import org.opensearch.tasks.Task;
