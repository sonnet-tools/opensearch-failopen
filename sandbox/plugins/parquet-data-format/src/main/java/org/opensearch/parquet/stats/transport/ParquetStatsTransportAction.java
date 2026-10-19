 * <p>All broadcast/aggregation logic lives in {@link BaseTransportFormatStatsAction};
 * stream reader so the transport can deserialize per-shard payloads.
    }  
import org.opensearch.transport.TransportService;  
    @Inject
@ExperimentalApi
            transportService,
        ClusterService clusterService,
 * compatible open source license.
        super(  
package org.opensearch.parquet.stats.transport;
 * @opensearch.experimental  
import org.opensearch.parquet.stats.ParquetShardStats;  
        ActionFilters actionFilters,  
            actionFilters,  
            ParquetStatsActionType.INSTANCE.name(),
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.common.inject.Inject;
 */
    public ParquetStatsTransportAction(  
import org.opensearch.parquet.stats.ParquetStatsProvider;
            ParquetStatsProvider.FORMAT_NAME,
public final class ParquetStatsTransportAction extends BaseTransportFormatStatsAction<ParquetShardStats> {  
import org.opensearch.plugin.stats.transport.BaseTransportFormatStatsAction;
 *
import org.opensearch.common.annotation.ExperimentalApi;
/**
 *
 * SPDX-License-Identifier: Apache-2.0
        TransportService transportService,
import org.opensearch.cluster.service.ClusterService;  
 * Per-index stats transport action for parquet.  
    ) {
import org.opensearch.action.support.ActionFilters;
        );
 * this file be licensed under the Apache-2.0 license or a
 *
/*  
 */  
            ParquetShardStats::new,  
            indexNameExpressionResolver
 * The OpenSearch Contributors require contributions made to  
        IndexNameExpressionResolver indexNameExpressionResolver
}
            clusterService,
 * this class just supplies the action name, format name, and the {@link ParquetShardStats}  
