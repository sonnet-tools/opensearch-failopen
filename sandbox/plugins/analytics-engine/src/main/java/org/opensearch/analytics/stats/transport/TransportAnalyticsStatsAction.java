 * mirroring {@code TransportNodesStatsAction}.  
        ActionFilters actionFilters,  
 */  
        return new AnalyticsStatsNodeRequest();
            AnalyticsStatsRequest::new,  
    @Override
        ClusterService clusterService,
package org.opensearch.analytics.stats.transport;
        super(  
    protected AnalyticsStatsNodeResponse nodeOperation(AnalyticsStatsNodeRequest request) {
        AnalyticsStats stats = collector.snapshot();
        return new AnalyticsStatsResponse(clusterService.getClusterName(), responses, failures);
    protected AnalyticsStatsNodeRequest newNodeRequest(AnalyticsStatsRequest request) {  
import org.opensearch.common.inject.Inject;
    }
import org.opensearch.threadpool.ThreadPool;
 */  
    ) {
    @Override
import org.opensearch.action.support.nodes.TransportNodesAction;  
 * @opensearch.experimental
        );
 *
            AnalyticsStatsNodeResponse.class  
    protected AnalyticsStatsNodeResponse newNodeResponse(StreamInput in) throws IOException {
            transportService,
    protected AnalyticsStatsResponse newResponse(  
        return new AnalyticsStatsNodeResponse(clusterService.localNode(), stats);  
@ExperimentalApi
            threadPool,
 * compatible open source license.
    @Inject
 * lock-free, and bounded — so it runs on the {@code MANAGEMENT} threadpool
    }
        return new AnalyticsStatsNodeResponse(in);  
import org.opensearch.action.support.ActionFilters;
 * local {@link AnalyticsStatsCollector}; the coordinator collects all the
        AnalyticsStatsRequest request,
    @Override  
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.analytics.stats.AnalyticsStats;
    ) {
    AnalyticsStatsNodeResponse> {  
        AnalyticsStatsCollector collector
import org.opensearch.analytics.stats.AnalyticsStatsCollector;
 * responses into an {@link AnalyticsStatsResponse} for rendering.
            actionFilters,
/*  
            clusterService,  
 * node runs {@link #nodeOperation} which returns a fresh snapshot of the  
import org.opensearch.action.FailedNodeException;
    }  
        List<AnalyticsStatsNodeResponse> responses,
 * <p>The node-level work is a single {@code snapshot()} call — cheap,
    }  
    AnalyticsStatsResponse,
    private final AnalyticsStatsCollector collector;
        this.collector = collector;
 * The OpenSearch Contributors require contributions made to  
            ThreadPool.Names.MANAGEMENT,
        List<FailedNodeException> failures  
    @Override
import org.opensearch.core.common.io.stream.StreamInput;  
    AnalyticsStatsRequest,  
import java.util.List;
    public TransportAnalyticsStatsAction(
 *  
        TransportService transportService,
}
/**
    AnalyticsStatsNodeRequest,
 * Coordinator-level fan-out for {@link AnalyticsStatsAction}. Each contacted
 *
import org.opensearch.cluster.service.ClusterService;  
public class TransportAnalyticsStatsAction extends TransportNodesAction<
 * this file be licensed under the Apache-2.0 license or a
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.transport.TransportService;
            AnalyticsStatsAction.NAME,
import java.io.IOException;
        ThreadPool threadPool,  
            AnalyticsStatsNodeRequest::new,
