    FragmentInstructionHandler<?> createHandler(InstructionNode node);  
        int targetStageId,
 * compatible open source license.
}
    /**
     * handler registers the payload as the backend's source for {@code namedInputId}. Backends
     */
    Optional<InstructionNode> createPartialAggregateNode();  
        String logicalTableName
/**
     * @param logicalTableName the planner's logical table name (alias / index pattern / index) the
     * @param requestsRowIds   whether the scan must emit shard-global {@code __row_id__} values
        List<String> targetWorkerNodeIds,  
        int expectedSenders,
     *  
    }
     * channel-backed partition stream tied to the node-local shuffle buffer as the backend's
     * @param logicalTableName the planner's logical table name (alias / index pattern / index) the  
     * backend's output in a partitioned sink that hash-partitions each batch by the given channels  
     */
     * and ships each partition to the corresponding worker via the framework's shuffle transport.
        List<DelegatedExpression> delegatedQueries  
    Optional<InstructionNode> createFilterDelegationNode(  
    /** Creates a final aggregate instruction node for coordinator reduce. */
     * Creates a shard scan instruction node. {@code requestsRowIds} signals that the scan
     * and the execution context.
        boolean requestsRowIds,
    ) {  
        List<Integer> hashKeyChannels,
 * {@link FragmentInstructionHandler}s at the data node. One factory per backend,  
    }
 * this file be licensed under the Apache-2.0 license or a
     *                         backend should register the scanned shard's table under, or {@code null}  
    // ── Coordinator-side: create instruction nodes ──
    /**  
    /** Creates a partial aggregate instruction node. */
        String queryId,  
     * Creates a shuffle-producer instruction node for a scan-side data node. The handler wraps the
public interface FragmentInstructionHandlerFactory {
     * Creates a shard scan with delegation instruction node — combines scan setup with
    );
    }  
     */
        int targetStageId,
     *
    /**  
    default Optional<InstructionNode> createShuffleProducerNode(  
        int shufflePartitionIndex,
    Optional<InstructionNode> createShardScanWithDelegationNode(
    ) {
     */
     * that cannot accept broadcast injections return {@link Optional#empty()}.  
 * does not support the instruction type. Core logs and skips unsupported instructions.
    /** Creates a filter delegation instruction node with the given delegation metadata. */
     * @param delegatedPredicateCount number of delegated predicates
     * {@code __row_id__} values (QTF query phase). Backends that don't support QTF should  
     * must emit shard-global {@code __row_id__} values (QTF query phase).
    /**  
        String side
     * @param treeShape        the delegated filter tree shape  
        String side  
        String namedInputId,  
     * @param requestsRowIds   whether the scan must emit shard-global {@code __row_id__} values
        int partitionCount,
package org.opensearch.analytics.spi;
    /**
/*  
    // ── Data-node-side: create handler for an instruction node ──
 * The OpenSearch Contributors require contributions made to  
     */  
     *                         to let the data node fall back to the concrete shard index name
 * Factory for creating {@link InstructionNode}s at the coordinator and
        return Optional.empty();
     * return {@link Optional#empty()} when {@code requestsRowIds} is true.
        int delegatedPredicateCount,  
        int delegatedPredicateCount,
    Optional<InstructionNode> createShardScanNode(boolean requestsRowIds, String logicalTableName);  
        String queryId,
    /**
     *                         to let the data node fall back to the concrete shard index name
     *                         backend should register the scanned shard's table under, or {@code null}
 * @opensearch.internal  
 *
        FilterTreeShape treeShape,
     * Creates a shuffle-scan instruction node for a hash-shuffle worker. The handler registers a
 */  
     * Creates a broadcast-injection instruction node. The coordinator calls this on the  
 */
     * delegation config. {@code requestsRowIds} signals that the scan must emit shard-global
        FilterTreeShape treeShape,
    );  
     * source for {@code namedInputId}.  
 *
    default Optional<InstructionNode> createBroadcastInjectionNode(String namedInputId, int buildSideIndex, byte[] broadcastData) {
        return Optional.empty();  
     * Creates a handler for the given instruction node. The handler's
        return Optional.empty();
     * probe-side backend with the collected build-side {@code broadcastData}; the data-node
import java.util.List;
 * <p>Coordinator-side creation methods return {@link Optional#empty()} if the backend  
 * SPDX-License-Identifier: Apache-2.0
 * accessed via {@code AnalyticsSearchBackendPlugin.getInstructionHandlerFactory()}.
     */
 *
     * {@link FragmentInstructionHandler#apply} will be called with the node  
import java.util.Optional;
    Optional<InstructionNode> createFinalAggregateNode();  
    default Optional<InstructionNode> createShuffleScanNode(
