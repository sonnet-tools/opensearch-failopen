            // reader-driven path below (the ArrowStreamReader handles a zero-batch stream).
            }
            );
 * so failure paths release buffers back to the allocator before surfacing the error.
 * {@link BroadcastInjectionInstructionNode#getNamedInputId() namedInputId}. The probe-side
    private static void releaseWrappers(List<ArrowArray> arrays, List<ArrowSchema> schemas) {
                    if (array != null) {
            // bug that hangs or crashes the JVM; the SessionContext variant is type-correct.
                // Best-effort cleanup — primary error (if any) is already being surfaced.
 * {@code MemTable} on the probe's DataFusion session under the instruction's
        BackendExecutionContext backendContext
            } catch (Throwable ignore) {
        }
            try {
            long[] arrayPtrs = new long[arrays.size()];
                }
 * stream.
        if (!(backendContext instanceof DataFusionSessionState sessionState)) {
                    if (arrowSchema != null) {
            ByteArrayInputStream in = new ByteArrayInputStream(ipcBytes == null ? new byte[0] : ipcBytes);
import org.apache.logging.log4j.LogManager;
 * responsible for appending {@code BroadcastInjectionInstructionNode} to the probe stage's
            }
import org.opensearch.analytics.backend.ShardScanExecutionContext;
}
                s.close();
        for (ArrowArray a : arrays) {
 * shard's data and the newly registered memtable.
                    + "(e.g. ShardScanInstructionHandler), got "
            throw new RuntimeException("BroadcastInjectionHandler: failed to decode Arrow IPC payload for " + node.getNamedInputId(), e);
            LOGGER.debug("[BroadcastInjectionHandler] empty broadcast payload for {}", node.getNamedInputId());
 *
                ArrowArray array = ArrowArray.allocateNew(alloc);
        try {
            for (int i = 0; i < arrays.size(); i++) {
import org.apache.arrow.c.ArrowSchema;
            } catch (Throwable ignore) {
    ) {
                    arrays.add(array);
            long[] schemaPtrs = new long[schemas.size()];
            // Still register a header-only memtable so the NamedScan resolves — defer to the
 * <p>Returns {@code backendContext} unchanged — the session handle survives for the downstream
                    array = null;
                    + (backendContext == null ? "null" : backendContext.getClass().getSimpleName())
 * side resolves to the in-memory broadcast payload rather than a stage-input partition
        byte[] ipcBytes = node.getBroadcastData();
                // Each loadNextBatch() mutates rootView in-place. Export immediately; the export
            }
import org.apache.arrow.c.Data;
            // schema blob (the same shape produced by ArrowSchemaIpc.toBytes).
            // themselves don't leak their own tracking state.
            }
import java.util.List;
 * so that {@link DataFusionSessionState} (carrying the native {@code SessionContextHandle}) has
                    schemas.add(arrowSchema);
                arrayPtrs[i] = arrays.get(i).memoryAddress();
 * already been produced. The broadcast-dispatch orchestrator (in analytics-engine) is
 * <p>Chain-ordering requirement: this handler must run AFTER {@link ShardScanInstructionHandler}
                    + "in the probe stage's plan alternative."
                node.getNamedInputId(),
            // Use the SessionContext variant — the probe-side scan-setup handler produced a
        byte[] schemaIpc;
import org.apache.arrow.memory.BufferAllocator;
                ArrowSchema arrowSchema = ArrowSchema.allocateNew(alloc);
    }
                    Data.exportVectorSchemaRoot(alloc, rootView, null, array, arrowSchema);
            // Native registration failed — Rust has not taken ownership. Release wrappers now.
                a.close();
 */
import org.apache.arrow.c.ArrowArray;
import java.io.ByteArrayInputStream;
        } catch (Throwable t) {
                    + ". The broadcast-injection instruction must be appended after the scan-setup instruction "
                } finally {
            ArrowStreamReader reader = new ArrowStreamReader(in, alloc)
                    }
            );
        } finally {
        return backendContext;
            releaseWrappers(arrays, schemas);
        }
        BroadcastInjectionInstructionNode node,
public class BroadcastInjectionHandler implements FragmentInstructionHandler<BroadcastInjectionInstructionNode> {
            // Empty broadcast payload — coordinator observed zero build rows. Registering an
 * {@link DatafusionSearchExecEngine} to execute the probe's join plan against both the
        }
        CommonExecutionContext commonContext,
 * Handler for {@link BroadcastInjectionInstructionNode} on a probe-side data node.
                schemaPtrs
 *
                    }
            );
 *
 * <p>Memtable registration mirrors the happy path of
                    arrowSchema = null;
                // Best-effort cleanup.
            // empty memtable preserves probe-side plan structure (NamedScan resolves cleanly)
                sessionState.sessionContextHandle().getPointer(),
/*
            releaseWrappers(arrays, schemas);
import org.opensearch.analytics.spi.FragmentInstructionHandler;
        BufferAllocator alloc = ((ShardScanExecutionContext) commonContext).getAllocator();
                "[BroadcastInjectionHandler] registered memtable {} ({} batches, buildSideIndex={})",
            throw new IllegalStateException(
                schemaPtrs[i] = schemas.get(i).memoryAddress();
 * existing instruction list, not prepending.
package org.opensearch.be.datafusion;
                        arrowSchema.close();
import org.opensearch.analytics.spi.CommonExecutionContext;
            // SessionContextHandle (shard-scan path), not a LocalSession (coord-reduce path).
                arrayPtrs,
        for (ArrowSchema s : schemas) {
        } catch (Exception e) {
        }
            VectorSchemaRoot rootView = reader.getVectorSchemaRoot();
    private static final Logger LOGGER = LogManager.getLogger(BroadcastInjectionHandler.class);
            while (reader.loadNextBatch()) {
            NativeBridge.registerMemtableOnSessionContext(
            // and yields the correct zero-join-output for INNER and outer-with-empty-build.
import org.apache.arrow.vector.VectorSchemaRoot;
                // transfers the current batch's vectors into the fresh (array, schema) pair.
 * this file be licensed under the Apache-2.0 license or a
                node.getBuildSideIndex()
            throw t;
import org.apache.logging.log4j.Logger;
            // Registering against a LocalSession via a wrong-type pointer cast is a memory-safety
import org.apache.arrow.vector.ipc.ArrowStreamReader;
 * Native takes ownership on success; the Java wrappers are closed in the {@code finally} block
import org.opensearch.analytics.spi.BackendExecutionContext;
                arrays.size(),
        }
                node.getNamedInputId(),
import org.opensearch.analytics.spi.BroadcastInjectionInstructionNode;
 * SPDX-License-Identifier: Apache-2.0
/**
        if (ipcBytes == null || ipcBytes.length == 0) {
                "BroadcastInjectionHandler: expected DataFusionSessionState from a prior handler "
        ) {
import java.util.ArrayList;
 *
            releaseWrappers(arrays, schemas);
            // On success, Rust has consumed the underlying FFI structs (release callback nulled),
                        array.close();
 * parallel arrays, hand them across in a single {@code NativeBridge.registerMemtable} call.
        try (
            try {
import org.opensearch.be.datafusion.nativelib.NativeBridge;
            // so Java-side close is a no-op on the data. Always call close so the Java wrappers
 * {@link DatafusionMemtableReduceSink#close()}: export each
 * The OpenSearch Contributors require contributions made to
        }
 *
 */
            // Capture the schema IPC bytes once — registerMemtable wants a standalone IPC
    public BackendExecutionContext apply(
        List<ArrowArray> arrays = new ArrayList<>();
 * Substrait plan references this named input via a {@code NamedScan}, so the join's build
 * compatible open source license.
 * {@link VectorSchemaRoot} via Arrow C Data Interface, accumulate the FFI struct pointers in
    }
        List<ArrowSchema> schemas = new ArrayList<>();
 * <p>Receives coordinator-collected build-side Arrow IPC batches and registers them as a
            schemaIpc = ArrowSchemaIpc.toBytes(rootView.getSchema());
    @Override
                try {
                schemaIpc,
            LOGGER.debug(
