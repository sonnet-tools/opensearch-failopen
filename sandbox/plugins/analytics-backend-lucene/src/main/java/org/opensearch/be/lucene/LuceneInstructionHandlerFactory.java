    @Override  
    @Override
/*  
        int delegatedPredicateCount,  
 * The OpenSearch Contributors require contributions made to  
    @Override
            return (FragmentInstructionHandler) new LuceneScanInstructionHandler(plugin);
 * partial / final / filter-delegation nodes return {@link Optional#empty()} or throw,
        if (node instanceof ShardScanWithDelegationInstructionNode) {
        List<DelegatedExpression> delegatedQueries
        return Optional.empty();  
 *
        boolean requestsRowIds,
    public FragmentInstructionHandler<?> createHandler(InstructionNode node) {  
 * since Lucene doesn't drive those operators.
    ) {  
        // no separate partial-aggregate setup step.
        throw new UnsupportedOperationException("Lucene driver does not handle instruction type: " + node.type());
    // ── Data-node-side: produce handlers ──
            return (FragmentInstructionHandler) new LuceneScanInstructionHandler(plugin);
        // are ignored.  
final class LuceneInstructionHandlerFactory implements FragmentInstructionHandlerFactory {  
        // so the framework picks DataFusion instead.
        // Lucene never drives a coordinator-reduce stage; final agg always runs on DataFusion.
import org.opensearch.analytics.spi.FragmentInstructionHandlerFactory;
    }
import org.opensearch.analytics.spi.InstructionNode;
        String logicalTableName
    }
import java.util.List;  
    @Override
        return createShardScanNode(requestsRowIds, logicalTableName);
    }  
        FilterTreeShape treeShape,
import org.opensearch.analytics.spi.DelegatedExpression;
        // Lucene as driver doesn't have a "filter delegation" concept — the filter IS the
 * SPDX-License-Identifier: Apache-2.0
        return Optional.empty();
package org.opensearch.be.lucene;
 */
    }  
    LuceneInstructionHandlerFactory(LucenePlugin plugin) {
        int delegatedPredicateCount,
        }  
import org.opensearch.analytics.spi.FragmentInstructionHandler;  
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;
        if (requestsRowIds) return Optional.empty();  
/**  
 * Factory for Lucene-driver instruction nodes / handlers. Built once per backend, used at
    // ── Coordinator-side: produce instruction nodes ──
import java.util.Optional;
        if (node instanceof ShardScanInstructionNode) {
    public Optional<InstructionNode> createShardScanWithDelegationNode(
    public Optional<InstructionNode> createShardScanNode(boolean requestsRowIds, String logicalTableName) {
        }  
        return Optional.of(new ShardScanInstructionNode(requestsRowIds, logicalTableName));
 * compatible open source license.
        // Lucene driver doesn't accept delegated predicates, so the with-delegation variant
        FilterTreeShape treeShape,  
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private final LucenePlugin plugin;
    public Optional<InstructionNode> createPartialAggregateNode() {
import org.opensearch.analytics.spi.FilterTreeShape;
    @Override
    }
        // Lucene driver doesn't emit row ids — QTF is DataFusion-only. If a Lucene-driver  
    public Optional<InstructionNode> createFilterDelegationNode(
 */  
 *
 * <p>Only shard-scan setup nodes are supported today — these are the only nodes a
    }  
        // Lucene query, serialized as a BoolQueryBuilder by LuceneFragmentConvertor.
    @Override
        this.plugin = plugin;
 * both planner-time (coordinator-side {@code create*Node}) and execution-time (data-node
        // alternative were ever paired with a row-id-requesting parent stage, reject here
import org.opensearch.analytics.spi.ShardScanInstructionNode;  
    ) {  
 *  
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
 * Lucene-driver {@code StagePlan} produces (count fast path is shard-local). Aggregate /  
        // collapses to a plain shard-scan. The treeShape / delegatedPredicateCount fields
        // Lucene driver returns the count directly as a one-row partial-shaped batch —  
        return Optional.empty();
    public Optional<InstructionNode> createFinalAggregateNode() {  
    }
}  
 * {@code createHandler}).  
