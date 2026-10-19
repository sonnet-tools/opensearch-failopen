import org.opensearch.action.support.ActionFilters;
            threadPool,  
 * compatible open source license.
 * Per-node stats transport action for the composite engine.  
 */  
import org.opensearch.composite.stats.CompositeShardStats;
}  
 * @opensearch.experimental
        ThreadPool threadPool,  
 * this file be licensed under the Apache-2.0 license or a
            actionFilters  
        ClusterService clusterService,
        TransportService transportService,
 * The OpenSearch Contributors require contributions made to  
 *
            CompositeShardStats::new,
    @Inject
 */  
            CompositeNodeStatsActionType.INSTANCE.name(),  
        super(
 * SPDX-License-Identifier: Apache-2.0
/*  
            clusterService,
import org.opensearch.transport.TransportService;  
 *
import org.opensearch.composite.stats.CompositeStatsProvider;  
import org.opensearch.common.inject.Inject;
import org.opensearch.plugin.stats.transport.BaseTransportFormatNodeStatsAction;
import org.opensearch.cluster.service.ClusterService;
    }
@ExperimentalApi
    ) {
        );
    public CompositeNodeStatsTransportAction(
import org.opensearch.threadpool.ThreadPool;
            transportService,
import org.opensearch.common.annotation.ExperimentalApi;  
public final class CompositeNodeStatsTransportAction extends BaseTransportFormatNodeStatsAction<CompositeShardStats> {
package org.opensearch.composite.stats.transport;
/**
            CompositeStatsProvider.FORMAT_NAME,
        ActionFilters actionFilters  
