        super(
import org.opensearch.plugin.stats.transport.BaseTransportFormatStatsAction;
import org.opensearch.common.annotation.ExperimentalApi;  
        ActionFilters actionFilters,
 * compatible open source license.
/*  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.support.ActionFilters;
    ) {
 *
/**
 * this file be licensed under the Apache-2.0 license or a
            clusterService,  
        TransportService transportService,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    public LuceneStatsTransportAction(
 *
            LuceneStatsActionType.INSTANCE.name(),  
            transportService,
            actionFilters,
            LuceneStatsProvider.FORMAT_NAME,
    @Inject
import org.opensearch.common.inject.Inject;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.service.ClusterService;
        IndexNameExpressionResolver indexNameExpressionResolver  
            LuceneShardStats::new,
 */  
import org.opensearch.be.lucene.stats.LuceneStatsProvider;  
    }
            indexNameExpressionResolver  
 */  
 * @opensearch.experimental
public final class LuceneStatsTransportAction extends BaseTransportFormatStatsAction<LuceneShardStats> {
        );
 * Per-index stats transport action for lucene.  
        ClusterService clusterService,  
package org.opensearch.be.lucene.stats.transport;
import org.opensearch.transport.TransportService;  
@ExperimentalApi
import org.opensearch.be.lucene.stats.LuceneShardStats;
}  
