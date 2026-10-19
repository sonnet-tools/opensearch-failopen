import org.opensearch.index.engine.dataformat.DataFormatRegistry;  
        try (Arena arena = Arena.ofConfined()) {
        long readerPtr = dfReader.getReaderHandle().getPointer();
import org.opensearch.analytics.spi.CommonExecutionContext;  
 * this file be licensed under the Apache-2.0 license or a
        long runtimePtr = dataFusionService.getNativeRuntime().get();  
                // liveDocs application in collectDocs. When false, zero extra work.
        // Substrait plan's NamedTable binds. Fall back to the concrete shard index name when absent.
    private final DataFusionPlugin plugin;
            dfReader = context.getReader().getReader(registry.format(formatName), DatafusionReader.class);
            if (dfReader != null) break;
        // referenced) from the plan's table-scan leaf. Register the shard's table under it so the  
        DataFormatRegistry registry = plugin.getDataFormatRegistry();  
 * SPDX-License-Identifier: Apache-2.0
        WireConfigSnapshot snapshot = plugin.getDatafusionSettings().getSnapshot();  
        DatafusionReader dfReader = null;
import org.opensearch.analytics.spi.BackendExecutionContext;
        // The coordinator captured the logical table name (alias / index pattern / index the query
                context.hasDeletedDocs(),  
        }  
                // directoryReader().hasDeletions()). When true, the native indexed executor ANDs a
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;  
                delegatedPredicateCount,
    }
 * Handles ShardScanWithDelegation instruction: creates a SessionContext via FFM  
        ShardScanExecutionContext context = (ShardScanExecutionContext) commonContext;
import org.opensearch.analytics.spi.FilterTreeShape;
import org.opensearch.analytics.backend.ShardScanExecutionContext;
/*  
            snapshot.writeTo(segment);  
                // Per-shard hasDeletions signal from AnalyticsSearchService (Lucene backend's  
        for (String formatName : plugin.getSupportedFormats()) {  
 * and delegatedPredicateCount.  
                // synthetic match-all Collector (reserved annotation id, resolved by the Lucene
 */
 */  
                context.hasPartialAggregate(),
    ) {  
 * compatible open source license.
public class ShardScanWithDelegationHandler implements FragmentInstructionHandler<ShardScanWithDelegationInstructionNode> {
            );
            throw new IllegalStateException("No DatafusionReader available in the acquired reader");
                treeShape.ordinal(),  
                readerPtr,
        this.plugin = plugin;
    @Override
                runtimePtr,  
        long contextId = context.getTask() != null ? context.getTask().getId() : 0L;
            SessionContextHandle sessionCtxHandle = NativeBridge.createSessionContextForIndexedExecution(
    public BackendExecutionContext apply(
/**
    ShardScanWithDelegationHandler(DataFusionPlugin plugin) {  
import java.lang.foreign.Arena;
        DataFusionService dataFusionService = plugin.getDataFusionService();
                // trees that already carry a correctness Collector are covered by the Lucene-side
        FilterTreeShape treeShape = node.getTreeShape();  
import org.opensearch.be.datafusion.nativelib.NativeBridge;
        int delegatedPredicateCount = node.getDelegatedPredicateCount();
        ShardScanWithDelegationInstructionNode node,  
                node.requestsRowIds(),
        }  
                tableName,
 *
        BackendExecutionContext backendContext
        }  
import org.opensearch.analytics.spi.FragmentInstructionHandler;
 * configured for indexed execution — registers the delegated_predicate UDF and
                segment.address(),
}
            MemorySegment segment = arena.allocate(WireConfigSnapshot.BYTE_SIZE);
import org.opensearch.be.datafusion.nativelib.SessionContextHandle;
                // handle to the segment's liveDocs) into the decoded filter tree where needed;  
            return new DataFusionSessionState(sessionCtxHandle);
    }
        String tableName = node.getLogicalTableName() != null ? node.getLogicalTableName() : context.getTableName();
import java.lang.foreign.MemorySegment;  
 * sets up the custom scan operator (IndexedTableProvider) with FilterTreeShape
                context.getFragmentBytes()  
                contextId,
        if (dfReader == null) {
        CommonExecutionContext commonContext,
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.be.datafusion;
