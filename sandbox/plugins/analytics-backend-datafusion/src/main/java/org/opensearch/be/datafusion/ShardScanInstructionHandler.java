    ) {
                    readerPtr,  
                    context.getFragmentBytes()
import java.lang.foreign.MemorySegment;  
    }  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.be.datafusion.nativelib.NativeBridge;
            // delegatedPredicateCount=0. Otherwise the vanilla ListingTable path runs with zero extra
    private final DataFusionPlugin plugin;
        // Substrait plan's NamedTable binds. Fall back to the concrete shard index name when absent.
                    0,  
        ShardScanExecutionContext context = (ShardScanExecutionContext) commonContext;
                    contextId,  
 * Handles ShardScan instruction: creates a SessionContext via FFM and registers  
import org.opensearch.analytics.backend.ShardScanExecutionContext;
        try (Arena arena = Arena.ofConfined()) {  
        }
import java.lang.foreign.Arena;
 * compatible open source license.
        BackendExecutionContext backendContext  
            } else {
    @Override
        }
 * SPDX-License-Identifier: Apache-2.0
                    segment.address(),
            SessionContextHandle sessionCtxHandle;
        long contextId = context.getTask() != null ? context.getTask().getId() : 0L;
                    tableName,  
            // Per-shard hasDeletions signal (stamped by AnalyticsSearchService). Deletions force the
            // Indexed execution is required either for QTF row IDs or for liveDocs masking. No  
            MemorySegment segment = arena.allocate(WireConfigSnapshot.BYTE_SIZE);
            // work (its plan bytes let Rust widen the schema for multi-index queries).  
    }  
            // indexed SingleCollector path (CONJUNCTIVE) so the synthetic live-docs collector filters
        long readerPtr = dfReader.getReaderHandle().getPointer();  
        if (dfReader == null) {
            snapshot.writeTo(segment);
                    context.hasPartialAggregate(),
import org.opensearch.analytics.spi.FilterTreeShape;
            // delegated predicates here (delegation goes through ShardScanWithDelegationHandler), so
                    false,
                    requiresLiveDocs,
            dfReader = context.getReader().getReader(registry.format(formatName), DatafusionReader.class);
                sessionCtxHandle = NativeBridge.createSessionContext(
 */
                    segment.address(),  
package org.opensearch.be.datafusion;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.analytics.spi.ShardScanInstructionNode;  
    public BackendExecutionContext apply(  
        DataFormatRegistry registry = plugin.getDataFormatRegistry();
import org.opensearch.index.engine.dataformat.DataFormatRegistry;  
            boolean requestsRowIds = node.requestsRowIds();  
                sessionCtxHandle = NativeBridge.createSessionContextForIndexedExecution(  
/**
public class ShardScanInstructionHandler implements FragmentInstructionHandler<ShardScanInstructionNode> {  
        // referenced) from the plan's table-scan leaf. Register the shard's table under it so the
        ShardScanInstructionNode node,
            if (requestsRowIds || requiresLiveDocs) {
 *
import org.opensearch.analytics.spi.BackendExecutionContext;
                    runtimePtr,
import org.opensearch.analytics.spi.CommonExecutionContext;  
                    requestsRowIds,
                    context.hasPartialAggregate(),  
            // deleted docs from candidates; row-ids then index into the live-only bitmap.  
        // The coordinator captured the logical table name (alias / index pattern / index the query  
        DatafusionReader dfReader = null;  
        long runtimePtr = dataFusionService.getNativeRuntime().get();
            return new DataFusionSessionState(sessionCtxHandle);
            }  
                    runtimePtr,
                    tableName,
                    readerPtr,
        String tableName = node.getLogicalTableName() != null ? node.getLogicalTableName() : context.getTableName();  
import org.opensearch.analytics.spi.FragmentInstructionHandler;
        this.plugin = plugin;
}
                    context.getFragmentBytes()
        DataFusionService dataFusionService = plugin.getDataFusionService();  
        }
 */  
            boolean requiresLiveDocs = context.hasDeletedDocs();
                int treeShape = requiresLiveDocs ? FilterTreeShape.CONJUNCTIVE.ordinal() : FilterTreeShape.NO_DELEGATION.ordinal();
            if (dfReader != null) break;  
        WireConfigSnapshot snapshot = plugin.getDatafusionSettings().getSnapshot();
                    treeShape,
/*  
                );  
            throw new IllegalStateException("No DatafusionReader available in the acquired reader");  
        CommonExecutionContext commonContext,
        for (String formatName : plugin.getSupportedFormats()) {
                );
import org.opensearch.be.datafusion.nativelib.SessionContextHandle;
    ShardScanInstructionHandler(DataFusionPlugin plugin) {
 * the default ListingTable provider for parquet scans.
                    contextId,
