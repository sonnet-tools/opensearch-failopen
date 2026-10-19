import java.util.Optional;
        }  
        return Optional.of(new PartialAggregateInstructionNode());  
        int expectedSenders,
        return Optional.of(  
        int targetStageId,  
    }
        throw new UnsupportedOperationException("No handler for instruction type: " + node.type());  
 * SPDX-License-Identifier: Apache-2.0
        }
    }
            DataFusionService svc = plugin.getDataFusionService();
        // TODO: FilterDelegationInstructionHandler, PartialAggregateInstructionHandler
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;
            new ShuffleScanInstructionNode(namedInputId, shufflePartitionIndex, expectedSenders, queryId, targetStageId, side)
import java.util.List;
            new ShuffleProducerInstructionNode(hashKeyChannels, partitionCount, targetWorkerNodeIds, queryId, targetStageId, side)
    public DataFusionInstructionHandlerFactory(DataFusionPlugin plugin) {
 * <p>Data node side: creates handlers that call into Rust via FFM to configure the SessionContext.
    // ── Data node: create handlers ──
    ) {
    @Override  
    // ── Coordinator: create instruction nodes ──  
        List<String> targetWorkerNodeIds,
import org.opensearch.analytics.spi.BroadcastInjectionInstructionNode;
        if (node instanceof BroadcastInjectionInstructionNode) {
public class DataFusionInstructionHandlerFactory implements FragmentInstructionHandlerFactory {
 */  
        );
        int delegatedPredicateCount,
    }  
    public Optional<InstructionNode> createShuffleScanNode(
import org.opensearch.analytics.spi.ShuffleScanInstructionNode;
        if (node instanceof ShardScanWithDelegationInstructionNode) {
    }
        this.plugin = plugin;  
        }
            return new ShuffleProducerHandler();  
import org.opensearch.analytics.spi.ShardScanInstructionNode;
    @Override
import org.opensearch.analytics.spi.DelegatedExpression;
        int partitionCount,  
        return Optional.of(new BroadcastInjectionInstructionNode(namedInputId, buildSideIndex, broadcastData));
        List<DelegatedExpression> delegatedExpressions
        if (node instanceof ShuffleWorkerSetupInstructionNode) {
 * this file be licensed under the Apache-2.0 license or a
        String namedInputId,  
}
 *  
            new ShardScanWithDelegationInstructionNode(treeShape, delegatedPredicateCount, requestsRowIds, logicalTableName)  
        if (node instanceof ShuffleScanInstructionNode) {
        if (node instanceof ShardScanInstructionNode) {
        return Optional.of(
        String side
    @Override
        String side
            return new ShardScanWithDelegationHandler(plugin);
        );
            return new ShuffleWorkerSetupHandler(plugin);  
    ) {  
        return Optional.of(new FinalAggregateInstructionNode());
            return new ShardScanInstructionHandler(plugin);
    @Override
            return new BroadcastInjectionHandler();  
        return Optional.of(new ShardScanInstructionNode(requestsRowIds, logicalTableName));
        return Optional.of(
        FilterTreeShape treeShape,  
        String queryId,
package org.opensearch.be.datafusion;
        if (node instanceof PartialAggregateInstructionNode) {
        List<Integer> hashKeyChannels,
        return Optional.of(new FilterDelegationInstructionNode(treeShape, delegatedPredicateCount, delegatedExpressions));
    }
        }
        FilterTreeShape treeShape,  
    }
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
    public Optional<InstructionNode> createPartialAggregateNode() {
import org.opensearch.analytics.spi.ShuffleProducerInstructionNode;  
import org.opensearch.analytics.spi.InstructionNode;
        int delegatedPredicateCount,
        }  
    }
/**
    @Override  
        int shufflePartitionIndex,
        }
    }  
 *
 */  
 * The OpenSearch Contributors require contributions made to  
    ) {
            return new ShuffleScanHandler();  
    @SuppressWarnings("unchecked")
 * DataFusion backend's instruction handler factory.
        String queryId,  
import org.opensearch.analytics.spi.PartialAggregateInstructionNode;  
 * <p>Coordinator side: creates typed instruction nodes for wire transport.
        if (node instanceof ShuffleProducerInstructionNode) {
        boolean requestsRowIds,
            return new PartialAggregateInstructionHandler();
    public FragmentInstructionHandler<?> createHandler(InstructionNode node) {  
            return new FinalAggregateInstructionHandler(svc.getNativeRuntime());  
        String logicalTableName  
    }
    public Optional<InstructionNode> createBroadcastInjectionNode(String namedInputId, int buildSideIndex, byte[] broadcastData) {  
import org.opensearch.analytics.spi.FinalAggregateInstructionNode;
import org.opensearch.analytics.spi.FilterTreeShape;
        }  
    ) {  
import org.opensearch.analytics.spi.FilterDelegationInstructionNode;  
        );  
import org.opensearch.analytics.spi.FragmentInstructionHandler;  
    public Optional<InstructionNode> createShardScanNode(boolean requestsRowIds, String logicalTableName) {  
    public Optional<InstructionNode> createShardScanWithDelegationNode(
        if (node instanceof FinalAggregateInstructionNode) {
    private final DataFusionPlugin plugin;  
    }
 * compatible open source license.
import org.opensearch.analytics.spi.ShuffleWorkerSetupInstructionNode;
    @Override
        }
    @Override
    public Optional<InstructionNode> createFinalAggregateNode() {
    public Optional<InstructionNode> createShuffleProducerNode(
    public Optional<InstructionNode> createFilterDelegationNode(
    @Override
    @Override
/*  
        int targetStageId,
