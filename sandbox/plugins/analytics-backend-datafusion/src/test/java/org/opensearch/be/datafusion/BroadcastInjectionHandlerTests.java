            // null backend context — classic "instruction inserted before scan-setup" bug.
import org.apache.arrow.memory.RootAllocator;
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
            BroadcastInjectionInstructionNode node = new BroadcastInjectionInstructionNode("broadcast-0", 0, new byte[0]);
package org.opensearch.be.datafusion;
 * Unit tests for {@link BroadcastInjectionHandler}'s fail-fast paths.
import org.opensearch.test.OpenSearchTestCase;
            assertTrue("error must name the expected producer", ex.getMessage().contains("ShardScanInstructionHandler"));
import org.opensearch.analytics.spi.BroadcastInjectionInstructionNode;  
            // Wrong backend-context type.  
 * handler lives in the integration test added alongside Commit 6.  
 * this file be licensed under the Apache-2.0 license or a
 * DataFusion session, which in turn requires a non-null {@code DatafusionReader} — the
            assertTrue("error must name the actual type", ex.getMessage().contains("DummyContext"));
 *
    public void testMissingSessionStateThrows() throws Exception {
 * ({@code ShardScanInstructionHandler}) has not produced a {@link DataFusionSessionState}.  
            ShardScanExecutionContext ctx = new ShardScanExecutionContext("t", null, null);
}
 * SPDX-License-Identifier: Apache-2.0
 */  
        }  
 * (same FFM call, same pointer hand-off contract); end-to-end verification for the broadcast
public class BroadcastInjectionHandlerTests extends OpenSearchTestCase {
            ctx.setAllocator(alloc);  
 * requires a parquet file on disk plus shard-level fixtures. The native round trip for  
            BroadcastInjectionHandler handler = new BroadcastInjectionHandler();  
 */
 * compatible open source license.
    }  
 * <p>What this suite pins: the handler refuses to run when the required predecessor
    private static final class DummyContext implements org.opensearch.analytics.spi.BackendExecutionContext {  
        public void close() {}
            IllegalStateException ex = expectThrows(IllegalStateException.class, () -> handler.apply(node, ctx, null));  
    }
 * The OpenSearch Contributors require contributions made to  
 * {@code registerMemtable} is already covered by {@link DatafusionMemtableReduceSinkTests}
/**  
import org.opensearch.analytics.backend.ShardScanExecutionContext;
/*  
 * <p>The happy path (decode IPC → register memtable → return session state) requires a live  
 *
            ex = expectThrows(IllegalStateException.class, () -> handler.apply(node, ctx, new DummyContext()));
 *
        @Override
 * {@code createSessionContext} FFM entry validates reader ≠ 0. Spinning that up in a unit test
