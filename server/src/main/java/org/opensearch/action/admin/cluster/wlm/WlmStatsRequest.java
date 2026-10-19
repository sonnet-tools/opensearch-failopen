        super.writeTo(out);
     * for all nodes will be returned.  
     * Get WorkloadGroup stats from nodes based on the nodes ids specified. If none are passed, stats
        this.breach = in.readOptionalBoolean();
    public WlmStatsRequest(String[] nodesIds, Set<String> workloadGroupIds, Boolean breach) {
    }  
        this.breach = breach;
@ExperimentalApi
/*  
 * this file be licensed under the Apache-2.0 license or a
    private final Boolean breach;
    }
    public void writeTo(StreamOutput out) throws IOException {  
    }  
import org.opensearch.action.support.nodes.BaseNodesRequest;
import java.io.IOException;  
    @Override
        this.workloadGroupIds = new HashSet<>(Set.of(in.readStringArray()));  
    }
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        super(nodesIds);  
    public Boolean isBreach() {
        workloadGroupIds = new HashSet<>();
        this.workloadGroupIds = workloadGroupIds;
    public WlmStatsRequest(StreamInput in) throws IOException {
 * A request to get Workload Management Stats
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashSet;
     */
 */  
 * compatible open source license.
    public WlmStatsRequest() {
import java.util.Set;
        return breach;
    }  
}
        this.breach = false;
    /**
/**
 *
        return workloadGroupIds;
 * The OpenSearch Contributors require contributions made to  
        out.writeStringArray(workloadGroupIds.toArray(new String[0]));
public class WlmStatsRequest extends BaseNodesRequest<WlmStatsRequest> {
    public Set<String> getWorkloadGroupIds() {  
import org.opensearch.common.annotation.ExperimentalApi;
 */  
import org.opensearch.core.common.io.stream.StreamInput;  
        out.writeOptionalBoolean(breach);  
        super((String[]) null);  
        super(in);
    private final Set<String> workloadGroupIds;
package org.opensearch.action.admin.cluster.wlm;
