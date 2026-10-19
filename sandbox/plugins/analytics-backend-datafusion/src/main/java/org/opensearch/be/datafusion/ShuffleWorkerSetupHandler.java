import org.opensearch.analytics.spi.CommonExecutionContext;  
        long runtimePtr = dataFusionService.getNativeRuntime().get();
        CommonExecutionContext commonContext,
 * org.opensearch.be.datafusion.ShuffleScanHandler}s can register named-input streams against
        // BEFORE any subsequent ShuffleScanHandler calls awaitReady — otherwise the second  
        // per-worker-stage decision on this instruction overrides it, so a large-build worker join
            return new DataFusionSessionState(handle);
/**
            .preferHashJoin(node.getPreferHashJoin())
 * it. Returns a {@link DataFusionSessionState} carrying the new {@link SessionContextHandle}.  
        ShardScanExecutionContext context = (ShardScanExecutionContext) commonContext;
import org.opensearch.be.datafusion.nativelib.NativeBridge;
import org.opensearch.analytics.spi.ShuffleBufferRegistry;  
        this.plugin = plugin;
import org.opensearch.analytics.spi.ShuffleWorkerSetupInstructionNode;
            buffer.setExpectedSenders(node.getLeftExpectedSenders(), node.getRightExpectedSenders());
        // side's latch never fires (CountDownLatch with -1 expected stays blocked).
    public BackendExecutionContext apply(
        }  
 */
public class ShuffleWorkerSetupHandler implements FragmentInstructionHandler<ShuffleWorkerSetupInstructionNode> {
import org.opensearch.be.datafusion.nativelib.SessionContextHandle;  
            SessionContextHandle handle = NativeBridge.createWorkerSessionContext(runtimePtr, contextId, segment.address());
import java.lang.foreign.Arena;
/*  
 * SessionContext (no shard view, no listing table) so subsequent {@link
import org.opensearch.analytics.backend.ShardScanExecutionContext;
        // gets a spillable sort-merge join while other stages keep the hash-join default.  
        if (registry != null) {  
    ) {  
    }
import org.opensearch.analytics.spi.FragmentInstructionHandler;
        ShuffleBufferRegistry registry = context.getShuffleBufferRegistry();
 * compatible open source license.
            .build();  
        ShuffleWorkerSetupInstructionNode node,  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        WireConfigSnapshot snapshot = WireConfigSnapshot.builder(plugin.getDatafusionSettings().getSnapshot())
    @Override
        }  
 * Handles {@link ShuffleWorkerSetupInstructionNode}: bootstraps a worker-mode DataFusion  
}
        // Set both sides' expected sender counts eagerly. The buffer must know both counts
 */  
import org.opensearch.analytics.spi.BackendExecutionContext;
import java.lang.foreign.MemorySegment;  
            snapshot.writeTo(segment);  
            MemorySegment segment = arena.allocate(WireConfigSnapshot.BYTE_SIZE);
        // The node-global snapshot carries the default (prefer_hash_join=true); the coordinator's
    private final DataFusionPlugin plugin;
        BackendExecutionContext backendContext
import org.opensearch.analytics.spi.ShuffleBufferAccess;
    }
    ShuffleWorkerSetupHandler(DataFusionPlugin plugin) {  
package org.opensearch.be.datafusion;
        try (Arena arena = Arena.ofConfined()) {
        DataFusionService dataFusionService = plugin.getDataFusionService();
            ShuffleBufferAccess buffer = registry.getOrCreate(node.getQueryId(), node.getTargetStageId(), node.getPartitionIndex());
 * this file be licensed under the Apache-2.0 license or a
        long contextId = context.getTask() != null ? context.getTask().getId() : 0L;  
 *
