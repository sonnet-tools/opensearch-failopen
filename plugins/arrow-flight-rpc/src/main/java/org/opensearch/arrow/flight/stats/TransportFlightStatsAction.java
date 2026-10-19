        List<FailedNodeException> failures
    }  
import java.io.IOException;
        this.statsCollector = statsCollector;  
    ) {  
        ActionFilters actionFilters,
            transportService,
import org.opensearch.action.support.nodes.TransportNodesAction;  
    /**  
     * @param responses the responses
        List<FlightNodeStats> responses,
    FlightStatsResponse,  
import org.opensearch.core.common.io.stream.StreamInput;  
    /** {@inheritDoc}  
/**
    @Inject
    @Override  
    @Override
import org.opensearch.action.support.ActionFilters;
 * SPDX-License-Identifier: Apache-2.0
     * @param request the request
 * compatible open source license.
        return new FlightStatsRequest.NodeRequest();
     * @param request the node request */
        FlightStatsCollector statsCollector
    FlightStatsRequest.NodeRequest,
    ) {  
    FlightNodeStats> {
            FlightNodeStats.class
        );
     * @param statsCollector the stats collector  
        FlightMetrics metrics = statsCollector.collectStats();
 */  
    /** {@inheritDoc}  
import org.opensearch.common.inject.Inject;
    protected FlightNodeStats nodeOperation(FlightStatsRequest.NodeRequest request) {  
     * @param clusterService the cluster service  
import org.opensearch.transport.TransportService;
        return new FlightNodeStats(in);  
            FlightStatsAction.NAME,
public class TransportFlightStatsAction extends TransportNodesAction<
        TransportService transportService,  
    /** {@inheritDoc}
    }
        return new FlightStatsResponse(clusterService.getClusterName(), responses, failures);
            threadPool,  
    protected FlightStatsResponse newResponse(
 * The OpenSearch Contributors require contributions made to  
     * @param threadPool the thread pool
 */  
        ThreadPool threadPool,
     * @param failures the failures */  
    @Override
 * Transport action for collecting Flight statistics from nodes
        super(
}
     * Creates a new transport action for Flight statistics collection
        return new FlightNodeStats(clusterService.localNode(), metrics);
import org.opensearch.cluster.service.ClusterService;
    private final FlightStatsCollector statsCollector;
    /** {@inheritDoc}
     * @param request the request */
import org.opensearch.threadpool.ThreadPool;
     * @param transportService the transport service
 *
            ThreadPool.Names.MANAGEMENT,  
    protected FlightStatsRequest.NodeRequest newNodeRequest(FlightStatsRequest request) {
    FlightStatsRequest,
    public TransportFlightStatsAction(  
            FlightStatsRequest::new,
    }
    @Override
            actionFilters,  
/*  
            FlightStatsRequest.NodeRequest::new,
     * @param actionFilters the action filters
     * @param in the stream input */  
import org.opensearch.action.FailedNodeException;
     */
package org.opensearch.arrow.flight.stats;
            clusterService,
import java.util.List;
        FlightStatsRequest request,  
 * this file be licensed under the Apache-2.0 license or a
    }
    protected FlightNodeStats newNodeResponse(StreamInput in) throws IOException {
    }  
        ClusterService clusterService,
