package org.opensearch.be.datafusion;
import org.opensearch.analytics.spi.CommonExecutionContext;  
public class PartialAggregateInstructionHandler implements FragmentInstructionHandler<PartialAggregateInstructionNode> {
/*  
 * The OpenSearch Contributors require contributions made to  
        return backendContext;
    }
import org.opensearch.be.datafusion.nativelib.NativeBridge;  
 * <p>Calls {@link NativeBridge#preparePartialPlan(long, byte[])} which sets the Rust-side  
        ShardScanExecutionContext ctx = (ShardScanExecutionContext) commonContext;  
 */  
}  
 * compatible open source license.
import org.opensearch.analytics.backend.ShardScanExecutionContext;
    public BackendExecutionContext apply(
 *
import org.opensearch.analytics.spi.PartialAggregateInstructionNode;
 * SPDX-License-Identifier: Apache-2.0
        DataFusionSessionState state = (DataFusionSessionState) backendContext;
 * this file be licensed under the Apache-2.0 license or a
 * aggregate mode to Partial and stores the prepared plan on the session handle for later
 *
 */  
import org.opensearch.analytics.spi.FragmentInstructionHandler;
 * physical plan on the already-open SessionContext created by the preceding ShardScan handler.
        BackendExecutionContext backendContext
/**
        NativeBridge.preparePartialPlan(sessionPtr, ctx.getFragmentBytes());  
        CommonExecutionContext commonContext,  
        long sessionPtr = state.sessionContextHandle().getPointer();
 * Handles PartialAggregate instruction on the shard side: prepares the partial-aggregate  
        PartialAggregateInstructionNode node,
    @Override  
 * execution.
import org.opensearch.analytics.spi.BackendExecutionContext;
    ) {
