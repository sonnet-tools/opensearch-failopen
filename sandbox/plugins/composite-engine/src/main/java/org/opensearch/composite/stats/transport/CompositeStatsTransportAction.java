/**
 * Per-index stats transport action for the composite engine.  
            CompositeStatsProvider.FORMAT_NAME,
            CompositeStatsActionType.INSTANCE.name(),  
        ClusterService clusterService,  
 * SPDX-License-Identifier: Apache-2.0
/*  
 */  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.experimental
 * class supplies the action name, format name, and the {@link CompositeShardStats} reader.  
    public CompositeStatsTransportAction(
        IndexNameExpressionResolver indexNameExpressionResolver  
        ActionFilters actionFilters,
 * <p>All broadcast/aggregation logic lives in {@link BaseTransportFormatStatsAction}; this
        TransportService transportService,
 *
        );
import org.opensearch.transport.TransportService;  
    @Inject
 * The OpenSearch Contributors require contributions made to  
 */  
import org.opensearch.composite.stats.CompositeShardStats;  
import org.opensearch.common.annotation.ExperimentalApi;
 * compatible open source license.
            clusterService,  
import org.opensearch.action.support.ActionFilters;
 *
            transportService,
            CompositeShardStats::new,
            indexNameExpressionResolver  
package org.opensearch.composite.stats.transport;
    ) {
 *
        super(
import org.opensearch.composite.stats.CompositeStatsProvider;
}  
import org.opensearch.plugin.stats.transport.BaseTransportFormatStatsAction;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
public final class CompositeStatsTransportAction extends BaseTransportFormatStatsAction<CompositeShardStats> {
    }
import org.opensearch.cluster.service.ClusterService;  
            actionFilters,
@ExperimentalApi
import org.opensearch.common.inject.Inject;
