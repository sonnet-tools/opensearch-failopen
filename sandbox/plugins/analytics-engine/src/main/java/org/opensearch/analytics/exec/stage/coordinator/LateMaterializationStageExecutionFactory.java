 * (which columns to fetch) and per-column storage info (how the data-node should read them).
            if (deeper != null) return deeper;
        for (Stage child : stage.getChildStages()) {
 * from the stage. The wrapper RelNode itself carries everything we need: the fetch list
 * stages. Pulls the {@code OpenSearchLateMaterialization} marker out of the stage's fragment
            if (child.getExecutionType() == StageExecutionType.SHARD_FRAGMENT) return child;  
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.analytics.exec.stage.LateMaterializationStageExecution;  
 */
            shardStage.getPlanAlternatives().get(0).backendId()
            clusterService,
            throw new IllegalStateException("LATE_MATERIALIZATION stage " + stage.getStageId() + " has no SHARD_FRAGMENT descendant");
        Stage shardStage = findShardFragmentDescendant(stage);  
import org.opensearch.analytics.spi.ExchangeSink;
        return new LateMaterializationStageExecution(
    }
        }  
 * @opensearch.internal
import org.opensearch.analytics.planner.dag.Stage;  
package org.opensearch.analytics.exec.stage.coordinator;
    private static Stage findShardFragmentDescendant(Stage stage) {
 * <p>This stage has no Substrait fragment ({@link
            transport,  
        if (shardStage == null) {
            shardStage.getStageId(),
    private final ClusterService clusterService;
        );  
 * org.opensearch.analytics.planner.dag.FragmentConversionDriver} skips it), so unlike
        }  
}  
import org.opensearch.analytics.planner.dag.StageExecutionType;
public final class LateMaterializationStageExecutionFactory implements StageExecutionFactory {  
 *  
            stage,
            config,  
 * this file be licensed under the Apache-2.0 license or a
 */  
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
import org.opensearch.analytics.exec.QueryContext;
 * for fetch-list metadata and hands the resulting context to {@link LateMaterializationStageExecution}.
    }
        return null;
 * {@link ReduceStageExecutionFactory} we do not pull plan bytes / sink providers / instructions  
import org.opensearch.analytics.exec.stage.StageExecution;
            Stage deeper = findShardFragmentDescendant(child);
/*  
            sink,
 * The OpenSearch Contributors require contributions made to  
    private final AnalyticsSearchTransportService transport;  
    /** DFS for the SHARD_FRAGMENT descendant; null if none. */  
import org.opensearch.analytics.exec.stage.StageExecutionFactory;
 *  
/**
        this.transport = transport;
        this.clusterService = clusterService;  
 * compatible open source license.
    @Override
 *
    public StageExecution createExecution(Stage stage, ExchangeSink sink, QueryContext config) {
    public LateMaterializationStageExecutionFactory(ClusterService clusterService, AnalyticsSearchTransportService transport) {
 * Builds executions for {@link StageExecutionType#LATE_MATERIALIZATION} (QTF Scatter-Gather)  
