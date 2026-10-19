import java.io.IOException;
/**
        );
import org.opensearch.common.annotation.ExperimentalApi;
            threadPool,
    }  
import org.opensearch.action.support.ActionFilters;
    FormatNodeStatsResponse<T>,
        ThreadPool threadPool,
import org.opensearch.threadpool.ThreadPool;
 * @opensearch.experimental
        super(  
        if (provider == null) {
    @Override  
            FormatNodeStatsRequest::new,
            actionName,
        }
    private final String formatName;
        TransportService transportService,  
 * compatible open source license.
import org.opensearch.plugin.stats.DataFormatStatsProvider;  
 * Each data-format plugin subclasses this to register its own node-stats action.
    @Override
 */  
        return new NodeFormatStats<>(in, reader);
    protected NodeFormatStats<T> newNodeResponse(StreamInput in) throws IOException {  
 * @param <T> concrete shard-stats type  
            transportService,
        List<NodeFormatStats<T>> nodeStats,  
    }
        ActionFilters actionFilters
import org.opensearch.action.FailedNodeException;
 *
 * The OpenSearch Contributors require contributions made to  
    @Override
        T stats = provider.aggregateNodeStats().orElse(null);
 * Abstract transport action that collects per-format aggregate node stats.  
            (Class<NodeFormatStats<T>>) (Class<?>) NodeFormatStats.class  
        String actionName,
}
import org.opensearch.plugin.stats.DataFormatShardStats;
public abstract class BaseTransportFormatNodeStatsAction<T extends DataFormatShardStats<T>> extends TransportNodesAction<
import org.opensearch.action.support.nodes.TransportNodesAction;  
    }
        return request;
    ) {
package org.opensearch.plugin.stats.transport;
import org.opensearch.cluster.service.ClusterService;
        List<FailedNodeException> failures
@ExperimentalApi
        return new NodeFormatStats<>(transportService.getLocalNode(), formatName, stats);  
    @SuppressWarnings("unchecked")
import org.opensearch.core.common.io.stream.StreamInput;  
        this.formatName = formatName;
 *
import org.opensearch.core.common.io.stream.Writeable;
    @Override  
    @SuppressWarnings("unchecked")
        this.reader = reader;  
        FormatNodeStatsRequest request,
    FormatNodeStatsRequest,
/*  
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;
    protected BaseTransportFormatNodeStatsAction(  
            ThreadPool.Names.MANAGEMENT,
    FormatNodeStatsRequest,  
        String formatName,
            FormatNodeStatsRequest::new,  
    ) {
import java.util.List;  
    protected FormatNodeStatsResponse<T> newResponse(
        ClusterService clusterService,
            actionFilters,
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.transport.TransportService;  
 *
    protected FormatNodeStatsRequest newNodeRequest(FormatNodeStatsRequest request) {
            clusterService,  
        Writeable.Reader<T> reader,  
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("unknown format: " + formatName);  
 */  
    NodeFormatStats<T>> {  
        DataFormatStatsProvider<T> provider = (DataFormatStatsProvider<T>) DataFormatStatsProviderRegistry.INSTANCE.get(formatName);
    private final Writeable.Reader<T> reader;  
    }
    protected NodeFormatStats<T> nodeOperation(FormatNodeStatsRequest request) {  
        return new FormatNodeStatsResponse<>(clusterService.getClusterName(), nodeStats, failures);  
