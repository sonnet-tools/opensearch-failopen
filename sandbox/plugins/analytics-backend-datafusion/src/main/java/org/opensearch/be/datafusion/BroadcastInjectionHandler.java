        }
            );
 * SPDX-License-Identifier: Apache-2.0
 * Handler for {@link BroadcastInjectionInstructionNode} on a probe-side data node.  
            // On success, Rust has consumed the underlying FFI structs (release callback nulled),  
                ArrowArray array = ArrowArray.allocateNew(alloc);  
        } finally {
        try (  
            // schema blob (the same shape produced by ArrowSchemaIpc.toBytes).
 * <p>Receives coordinator-collected build-side Arrow IPC batches and registers them as a
        }
        for (ArrowSchema s : schemas) {
 *
 * <p>Memtable registration mirrors the happy path of  
                s.close();
 * stream.
import java.io.ByteArrayInputStream;
 * {@link VectorSchemaRoot} via Arrow C Data Interface, accumulate the FFI struct pointers in
 * {@link DatafusionSearchExecEngine} to execute the probe's join plan against both the
                arrayPtrs[i] = arrays.get(i).memoryAddress();
 * existing instruction list, not prepending.
            // Still register a header-only memtable so the NamedScan resolves — defer to the  
                    + "in the probe stage's plan alternative."  
import org.apache.logging.log4j.Logger;
            ArrowStreamReader reader = new ArrowStreamReader(in, alloc)
 * responsible for appending {@code BroadcastInjectionInstructionNode} to the probe stage's  
                node.getNamedInputId(),
import org.opensearch.analytics.spi.CommonExecutionContext;  
    }  
            // reader-driven path below (the ArrowStreamReader handles a zero-batch stream).
                sessionState.sessionContextHandle().getPointer(),
        try {
 *
            LOGGER.debug(
            // Capture the schema IPC bytes once — registerMemtable wants a standalone IPC
                "[BroadcastInjectionHandler] registered memtable {} ({} batches, buildSideIndex={})",
                    array = null;  
            }
            // Empty broadcast payload — coordinator observed zero build rows. Registering an
        }
    }
        BackendExecutionContext backendContext
import org.opensearch.analytics.spi.FragmentInstructionHandler;
            // Native registration failed — Rust has not taken ownership. Release wrappers now.
import org.opensearch.be.datafusion.nativelib.NativeBridge;
        } catch (Exception e) {
        }
            ByteArrayInputStream in = new ByteArrayInputStream(ipcBytes == null ? new byte[0] : ipcBytes);
 * Substrait plan references this named input via a {@code NamedScan}, so the join's build
            }  
        }
                schemaIpc,  
        for (ArrowArray a : arrays) {
    private static final Logger LOGGER = LogManager.getLogger(BroadcastInjectionHandler.class);
        } catch (Throwable t) {
                // Each loadNextBatch() mutates rootView in-place. Export immediately; the export
        BufferAllocator alloc = ((ShardScanExecutionContext) commonContext).getAllocator();
                    + ". The broadcast-injection instruction must be appended after the scan-setup instruction "
import org.apache.arrow.vector.VectorSchemaRoot;
            LOGGER.debug("[BroadcastInjectionHandler] empty broadcast payload for {}", node.getNamedInputId());
 * Native takes ownership on success; the Java wrappers are closed in the {@code finally} block
                try {
 * so that {@link DataFusionSessionState} (carrying the native {@code SessionContextHandle}) has
            while (reader.loadNextBatch()) {  
/*  
        List<ArrowSchema> schemas = new ArrayList<>();  
 * The OpenSearch Contributors require contributions made to  
            // themselves don't leak their own tracking state.
                node.getNamedInputId(),  
        if (ipcBytes == null || ipcBytes.length == 0) {
                    + (backendContext == null ? "null" : backendContext.getClass().getSimpleName())
            } catch (Throwable ignore) {
                    arrowSchema = null;
import org.apache.logging.log4j.LogManager;
import org.apache.arrow.c.ArrowArray;
                node.getBuildSideIndex()
    public BackendExecutionContext apply(
                    }
                        arrowSchema.close();
            releaseWrappers(arrays, schemas);  
            );  
            // Use the SessionContext variant — the probe-side scan-setup handler produced a
            for (int i = 0; i < arrays.size(); i++) {
        byte[] schemaIpc;
        return backendContext;  
            releaseWrappers(arrays, schemas);  
 *
 * already been produced. The broadcast-dispatch orchestrator (in analytics-engine) is
 * {@link DatafusionMemtableReduceSink#close()}: export each
            // bug that hangs or crashes the JVM; the SessionContext variant is type-correct.
                schemaPtrs
public class BroadcastInjectionHandler implements FragmentInstructionHandler<BroadcastInjectionInstructionNode> {
 * shard's data and the newly registered memtable.  
                schemaPtrs[i] = schemas.get(i).memoryAddress();  
        byte[] ipcBytes = node.getBroadcastData();  
                } finally {
                ArrowSchema arrowSchema = ArrowSchema.allocateNew(alloc);
            throw t;
            try {
                    }
import org.opensearch.analytics.backend.ShardScanExecutionContext;  
 * side resolves to the in-memory broadcast payload rather than a stage-input partition  
            } catch (Throwable ignore) {
                "BroadcastInjectionHandler: expected DataFusionSessionState from a prior handler "
 * so failure paths release buffers back to the allocator before surfacing the error.
import java.util.List;  
            long[] schemaPtrs = new long[schemas.size()];  
import org.apache.arrow.memory.BufferAllocator;
 * <p>Returns {@code backendContext} unchanged — the session handle survives for the downstream
                arrayPtrs,
import org.opensearch.analytics.spi.BroadcastInjectionInstructionNode;
            throw new IllegalStateException(
import org.apache.arrow.vector.ipc.ArrowStreamReader;  
 */  
 * parallel arrays, hand them across in a single {@code NativeBridge.registerMemtable} call.  
            );  
                a.close();  
            long[] arrayPtrs = new long[arrays.size()];
        if (!(backendContext instanceof DataFusionSessionState sessionState)) {  
 * compatible open source license.
            // Registering against a LocalSession via a wrong-type pointer cast is a memory-safety
                    Data.exportVectorSchemaRoot(alloc, rootView, null, array, arrowSchema);  
            // SessionContextHandle (shard-scan path), not a LocalSession (coord-reduce path).  
        }
                    schemas.add(arrowSchema);
            }
            // so Java-side close is a no-op on the data. Always call close so the Java wrappers
            throw new RuntimeException("BroadcastInjectionHandler: failed to decode Arrow IPC payload for " + node.getNamedInputId(), e);
            releaseWrappers(arrays, schemas);  
                    arrays.add(array);
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;
 * <p>Chain-ordering requirement: this handler must run AFTER {@link ShardScanInstructionHandler}  
 *
            }
}
                // transfers the current batch's vectors into the fresh (array, schema) pair.
    @Override  
 */
            schemaIpc = ArrowSchemaIpc.toBytes(rootView.getSchema());
        ) {  
            try {  
 * {@link BroadcastInjectionInstructionNode#getNamedInputId() namedInputId}. The probe-side
import org.apache.arrow.c.Data;  
package org.opensearch.be.datafusion;
                    if (array != null) {  
        BroadcastInjectionInstructionNode node,
            VectorSchemaRoot rootView = reader.getVectorSchemaRoot();  
                }  
                arrays.size(),
        List<ArrowArray> arrays = new ArrayList<>();
                // Best-effort cleanup.  
import org.apache.arrow.c.ArrowSchema;
                    + "(e.g. ShardScanInstructionHandler), got "  
import org.opensearch.analytics.spi.BackendExecutionContext;
/**
    private static void releaseWrappers(List<ArrowArray> arrays, List<ArrowSchema> schemas) {  
                    if (arrowSchema != null) {  
 * {@code MemTable} on the probe's DataFusion session under the instruction's  
 *  
                        array.close();
            // empty memtable preserves probe-side plan structure (NamedScan resolves cleanly)  
        CommonExecutionContext commonContext,  
            // and yields the correct zero-join-output for INNER and outer-with-empty-build.
    ) {
                // Best-effort cleanup — primary error (if any) is already being surfaced.
            NativeBridge.registerMemtableOnSessionContext(  
