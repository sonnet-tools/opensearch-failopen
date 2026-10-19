            WlmStatsRequest::new,  
        assert transportService.getLocalNode() != null;  
        );
        this.workloadGroupService = workloadGroupService;
    @Override
            WlmStatsAction.NAME,  
    @Override
        ActionFilters actionFilters  
            workloadGroupService.nodeStats(wlmStatsRequest.getWorkloadGroupIds(), wlmStatsRequest.isBreach())  
import org.opensearch.wlm.WorkloadGroupService;  
            WlmStats.class
public class TransportWlmStatsAction extends TransportNodesAction<WlmStatsRequest, WlmStatsResponse, WlmStatsRequest, WlmStats> {
            clusterService,
    @Inject  
import org.opensearch.action.FailedNodeException;
    public TransportWlmStatsAction(
 */  
    protected WlmStatsRequest newNodeRequest(WlmStatsRequest request) {
 */
import org.opensearch.transport.TransportService;
}  
        WorkloadGroupService workloadGroupService,
    protected WlmStats nodeOperation(WlmStatsRequest wlmStatsRequest) {
/**  
import org.opensearch.common.inject.Inject;
        return new WlmStats(in);
import java.io.IOException;  
import java.util.List;
 *
            ThreadPool.Names.MANAGEMENT,
    protected WlmStats newNodeResponse(StreamInput in) throws IOException {  
            WlmStatsRequest::new,
    }
        );  
    }
    final WorkloadGroupService workloadGroupService;
import org.opensearch.action.support.ActionFilters;
        return request;
            threadPool,
        ClusterService clusterService,  
            transportService.getLocalNode(),
 * SPDX-License-Identifier: Apache-2.0
        TransportService transportService,
import org.opensearch.wlm.stats.WlmStats;
    @Override  
 * compatible open source license.
        super(
 * this file be licensed under the Apache-2.0 license or a
            actionFilters,
import org.opensearch.cluster.service.ClusterService;
    }
 *
import org.opensearch.core.common.io.stream.StreamInput;  
        return new WlmStatsResponse(clusterService.getClusterName(), wlmStats, failures);  
import org.opensearch.threadpool.ThreadPool;
    protected WlmStatsResponse newResponse(WlmStatsRequest request, List<WlmStats> wlmStats, List<FailedNodeException> failures) {
import org.opensearch.action.support.nodes.TransportNodesAction;  
    ) {
        ThreadPool threadPool,
    @Override
    }
    }  
 * Transport action for obtaining WlmStats
            transportService,  
 * @opensearch.experimental  
/*  
package org.opensearch.action.admin.cluster.wlm;
 * The OpenSearch Contributors require contributions made to  
        return new WlmStats(
