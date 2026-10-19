        return partitionIndex;
 *
            alt.writeTo(out);
 */  
        this.planAlternatives = planAlternatives;
        this.stageId = in.readInt();
 * {@code IndicesService.getShard} and reader acquisition entirely.  
    }  
        return planAlternatives;  
        for (int i = 0; i < n; i++) {  
    public WorkerFragmentRequest(StreamInput in) throws IOException {
    private final String queryId;  
        }
        List<FragmentExecutionRequest.PlanAlternative> planAlternatives  
    public ActionRequestValidationException validate() {
}
        out.writeInt(stageId);  
import java.util.ArrayList;
    }
 * @opensearch.internal
    public String getQueryId() {
        int partitionIndex,
import java.util.List;
    }
/**
        this.stageId = stageId;  
public class WorkerFragmentRequest extends ActionRequest {
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
import org.opensearch.action.ActionRequestValidationException;
    public void writeTo(StreamOutput out) throws IOException {  
    public List<FragmentExecutionRequest.PlanAlternative> getPlanAlternatives() {
import org.opensearch.tasks.Task;
    ) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamOutput;
/*  
    }
    }  
        int n = in.readVInt();
        int stageId,
 * compatible open source license.
    @Override  
    private final List<FragmentExecutionRequest.PlanAlternative> planAlternatives;  
        super(in);  
        out.writeString(queryId);
import org.opensearch.action.ActionRequest;
import org.opensearch.analytics.exec.task.AnalyticsShardTask;  
    @Override  
    @Override
 */  
    }  
 *
        String desc = "queryId[" + queryId + "] stageId[" + stageId + "] partition[" + partitionIndex + "]";
 * Transport request for a hash-shuffle worker fragment. Carries the per-task plan alternatives  
    private final int partitionIndex;
        this.partitionIndex = in.readVInt();  
        this.queryId = queryId;
        out.writeVInt(partitionIndex);
        out.writeVInt(planAlternatives.size());
    }
            planAlternatives.add(new FragmentExecutionRequest.PlanAlternative(in));
        }
        this.partitionIndex = partitionIndex;
        return new AnalyticsShardTask(id, type, action, desc, parentTaskId, headers);  
 * {@code AnalyticsSearchService.executeWorkerFragmentStreamingAsync}, which skips
    }  
        return null;
    private final int stageId;
        super.writeTo(out);
    public int getPartitionIndex() {
    public WorkerFragmentRequest(
 * <p>Wire shape: {@code (queryId, stageId, partitionIndex, planAlternatives)}. The  
import org.opensearch.core.tasks.TaskId;  
        return queryId;  
        this.queryId = in.readString();
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.analytics.exec.action;
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.Map;  
 * and partition index — no {@code shardId}, since a worker fragment never scans a shard.
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;  
        String queryId,  
 * data-node-side handler in {@code AnalyticsSearchTransportService} routes this to
    }  
        return stageId;
 *
    public int getStageId() {  
        for (FragmentExecutionRequest.PlanAlternative alt : planAlternatives) {  
        this.planAlternatives = new ArrayList<>(n);
