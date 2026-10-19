                throw new RuntimeException(
        }
        ShuffleBufferAccess buffer = registry.getOrCreate(node.getQueryId(), node.getTargetStageId(), node.getShufflePartitionIndex());  
        }  
        try {  
package org.opensearch.be.datafusion;
 * <p>Schema discovery: the partition's IPC chunks each include their own schema header (per
            return ArrowSchemaIpc.toBytes(reader.getVectorSchemaRoot().getSchema());
        if (!(backendContext instanceof DataFusionSessionState sessionState)) {
     */
        // before either side's awaitReady call blocks. Setting them per-side here would  
                    inputId,
        // time — the rest stream from the spill file — so an over-budget partition drains without  
        ) {  
                    side,
 * references the resulting {@code NamedScan} so the hash-join's input resolves to the
                    sessionState.sessionContextHandle().getPointer(),
        }
                    + (backendContext == null ? "null" : backendContext.getClass().getSimpleName())
        }  
                    Data.exportVectorSchemaRoot(alloc, rootView, null, array, arrowSchema);
            int chunkCount = 0;
            chunks.close();
                side,  
                        // Always close the Java wrappers' tracking state. Native already owns
            try {
            if (producerPlanBytes != null) {  
                            // best-effort — primary error is being surfaced
        } catch (Exception e) {  
import org.opensearch.analytics.spi.FragmentInstructionHandler;
                    node.getShufflePartitionIndex()
    );
                        } catch (Throwable ignore) {
 * fragment's instruction list. {@link ShuffleBufferAccess#awaitReady} blocks here until both
                        try {
                    }
            );
import org.apache.arrow.c.ArrowSchema;
            ArrowStreamReader reader = new ArrowStreamReader(in, alloc, ShuffleCompression.FACTORY)
        DatafusionPartitionSender sender = new DatafusionPartitionSender(senderPtr);
                    sessionState.sessionContextHandle().getPointer(),
    public BackendExecutionContext apply(
                node.getTargetStageId(),
        // keeps the raw-IPC path unchanged.
        // stream is a bounded mpsc (capacity 4): synchronous draining inside this handler
                boolean handedOff = false;  
            chunks.close();
                try {  
            VectorSchemaRoot rootView = reader.getVectorSchemaRoot();  
    @Override
     *  once that cluster setting is plumbed into {@link ShardScanExecutionContext}; today the
                new byte[0],
 * compatible open source license.
                "ShuffleScanHandler: ShuffleBufferRegistry not plumbed into ShardScanExecutionContext. "
            ArrowStreamReader reader = new ArrowStreamReader(in, alloc, ShuffleCompression.FACTORY)
 * zero rows from this partition.
 * NativeBridge#registerPartitionStreamOnSessionContext} — the worker's Substrait plan  
     *
        // would block on the 5th send because the consumer (engine.execute → HashJoinExec)
            chunks.close();
 * side (the named-input id encodes which) and pushes each batch into the native sender.
        // The instruction carries side ("left"/"right") explicitly. namedInputId is the canonical
            int totalBatches = 0;
            throw new RuntimeException("ShuffleScanHandler: failed to register partition stream for " + inputId, e);
            Throwable drainFailure = null;  
                    totalBatches,
                    chunkCount,
            }
import org.opensearch.analytics.exec.shuffle.ShuffleCompression;
                );
 * to a DataFusion {@code StreamingTable} via {@link
        }
                    + (commonContext == null ? "null" : commonContext.getClass().getSimpleName())
    }  
     * Reads the schema header from an Arrow IPC stream chunk and returns an isolated
            while (reader.loadNextBatch()) {
import org.opensearch.be.datafusion.nativelib.NativeBridge;  
                inputId,
        // physically-named batches still feed in positionally. Null producerPlanBytes (join-shuffle)  
        BufferAllocator alloc = shardCtx.getAllocator();
                    "ShuffleScanHandler: timed out waiting for shuffle producers to finish for "
 *  
            }  
                    LOGGER.warn("ShuffleScanHandler.drain: chunk iterator close failed for " + inputId, closeErr);
        String side = node.getSide();
        //
 * producer rows for this partition) the handler treats the partition as a zero-batch stream —
        // spill-file handle) and the sender (closing it signals EOF to the native StreamingTable).
        return backendContext;  
                        finalSender.fail("shuffle drain failed for " + inputId + " (side=" + side + "): " + drainFailure);  
        final DatafusionPartitionSender finalSender = sender;
                            array.close();
        // Register the partition stream. Any failure here must close the chunk iterator (which owns an  
                );  
 * SPDX-License-Identifier: Apache-2.0
     *  handler reads the JVM system property of the same name as a stopgap so integration  
                senderPtr = NativeBridge.registerPartitionStreamOnSessionContext(  
                    + ". The shuffle-scan instruction must be appended after the scan-setup instruction "  
     *  Real producers complete within milliseconds on a healthy cluster — the cap exists
                        try {  
                        } catch (Throwable ignore) {  
                    sessionState.sessionContextHandle().getPointer(),  
                    "ShuffleScanHandler.drain FAILED for " + inputId + " — partition stream truncated, failing the consumer stream",  
                    node.getTargetStageId(),
                    t
import org.opensearch.analytics.spi.BackendExecutionContext;
                    totalBatches += pumpChunkIntoSender(chunkIter.next(), alloc, finalSender);
                            arrowSchema.close();
 *  
                "ShuffleScanHandler: expected ShardScanExecutionContext, got "  
                        + "ms)"  
 *  
            throw new IllegalStateException(
                // pushes an error into the channel so the consumer's stream yields an ERROR and the
        // re-materializing (the whole point of disk spill). The iterator owns the spill-file handle.
                            // best-effort — primary error is being surfaced
                }
        CloseableIterator<byte[]> chunks = isLeftSide ? buffer.drainLeft() : buffer.drainRight();  
            LOGGER.debug(
 * surfaced as a {@link RuntimeException} that propagates back through
            }
                        // Truncated partition: surface an error to the consumer (not a clean EOF).
                    } else {  
        // The background thread owns the lifecycle of BOTH the chunk iterator (releases the  
                        try {
            );  
        byte[] producerPlanBytes = node.getProducerPlanBytes();
                ArrowSchema arrowSchema = ArrowSchema.allocateNew(alloc);
    }
                    // On success Rust released the underlying FFI structs (the release callback
                }
import org.apache.arrow.vector.ipc.ArrowStreamReader;  
import org.apache.arrow.c.Data;  
        // state columns are named <alias>[<state>] (e.g. sum_qty[sum]), but the worker FINAL  
                sessionState.sessionContextHandle().getPointer(),  
public class ShuffleScanHandler implements FragmentInstructionHandler<ShuffleScanInstructionNode> {  
        } catch (RuntimeException e) {
            return backendContext;  
        }
                drainFailure = t;
                try {
     * {@link ArrowSchemaIpc#toBytes} produces — what  
 * @opensearch.internal
                    producerPlanBytes
 * Handler for {@link ShuffleScanInstructionNode} on a hash-shuffle worker.
        ) {
                totalBatches += pumpChunkIntoSender(firstChunkFinal, alloc, finalSender);
 * <p>Bridges the node-local {@link org.opensearch.analytics.exec.shuffle.ShuffleBufferManager}
        try (  
        byte[] firstChunk;
        CommonExecutionContext commonContext,
        return count;
                    inputId,  
        // coordinator-reduce register_partition_stream) so the table carries logical names; the
            ByteArrayInputStream in = new ByteArrayInputStream(chunkIpc);  
                new DatafusionPartitionSender(emptySenderPtr).close();
import org.apache.logging.log4j.LogManager;
     * IPC-stream blob containing only that schema. The returned bytes are the same shape
                        }  
                // would silently produce WRONG results from partial input. Instead FAIL the sender: it
        // fragment's Substrait base_schema declares the Calcite LOGICAL names (sum_qty). DataFusion's
                node.getQueryId(),  
        String inputId = node.getNamedInputId();  
import org.apache.arrow.memory.BufferAllocator;
                    node.getShufflePartitionIndex()  
        if (registry == null) {
     *  walker faster than this). Operator-tuneable via {@code analytics.mpp.shuffle.recv_timeout}
                // partial plan so the FINAL binds, then close the sender immediately — 0 rows for
 * <p>Failure surface: any IO exception during decode, alignment, or FFM registration is  
            throw new RuntimeException("ShuffleScanHandler: failed to read first shuffle chunk for " + inputId, e);  
                // Agg-shuffle worker: register with the LOGICAL schema derived by re-lowering the
                        finalSender.close();
                // this partition. A 0-column empty memtable would fail the FINAL's by-name bind.  
        if (!(commonContext instanceof ShardScanExecutionContext shardCtx)) {
        // deadlock — the second side's count is set only AFTER the first side's blocked.
                node.getShufflePartitionIndex()  
                }  
                // sender takes ownership of the FFI structs on success.  
                            // best-effort
        // drain thread AFTER a sender is successfully constructed below. (codex review: spill-file
                // query fails loudly rather than under-delivering. (#17: native df_sender_fail.)  
            if (producerPlanBytes != null) {  
                    chunkCount++;  
                    inputId,
import org.apache.arrow.vector.VectorSchemaRoot;
                LOGGER.debug(
                // Each loadNextBatch mutates rootView in-place. Export immediately; the native
                    schemaIpc  
    ) {  
        boolean isLeftSide = "left".equals(side);
                        }  
        try {
                "ShuffleScanHandler: awaiting partition stream queryId={}, stage={}, partition={}, side={}, expectedSenders={}",
        if (!isLeftSide && !"right".equals(side)) {  
        // engine.execute start in parallel, drain the channel, and unblock the sender.
    /**
                // the sender cleanly would signal EOF to the native StreamingTable, so the join/agg  
                chunkCount++;  
                        + " (timeout="
        // Drain chunks into the native sender on a background thread. The native partition  
        // producerPlanBytes is present, register via the partial-plan derivation (mirrors the working
 *  
                    if (drainFailure != null) {
                    + "AnalyticsSearchService.setShuffleBufferRegistry must be called at plugin startup."
                } catch (Throwable closeErr) {  
        // auto-detects the codec (incl. NO_COMPRESSION) from the IPC message metadata.
            );
                    LOGGER.warn("ShuffleScanHandler.drain: sender teardown failed for " + inputId, closeErr);
                    chunkIter.close();
                        // the underlying memory.
        }
                new long[0],  
            LOGGER.debug(
                    count++;
                "ShuffleScanHandler: empty partition for {} (queryId={}, stage={}, part={}); registering empty memtable",
     * C Data Interface. Returns the batch count for logging.
            // The buffer's awaitReady gates on left-and-right because the handler runs once for
            );
            } finally {  
            } else {
import org.apache.arrow.c.ArrowArray;
                );
        // "input-<producerStageId>" the fragment convertor emits for the StageInputScan leaf below  
                // names already match the consumer's expected input — no re-lowering needed).
import org.opensearch.analytics.spi.CommonExecutionContext;
    /** Cap on how long the consumer waits for both producer sides to mark {@code isLast}.
 * <p>Chain-ordering requirement: same as {@link BroadcastInjectionHandler} — must run AFTER
                        + DEFAULT_AWAIT_READY_TIMEOUT_MS
 *
        ShuffleBufferRegistry registry = shardCtx.getShuffleBufferRegistry();
        // Peek the first chunk for the schema (one chunk in heap is fine). No first chunk → empty
                    // is nulled); on failure we own them and must close. Java-side close is safe
        Thread drainThread = new Thread(() -> {  
                    sender.send(array.memoryAddress(), arrowSchema.memoryAddress());  
        try (
                            arrowSchema.close();  
                } catch (Throwable closeErr) {
        // the stripped OpenSearchShuffleExchange — that's what the worker's Substrait plan binds
            // each side; both invocations agree the buffer is fully populated before either
                    producerPlanBytes  
        final byte[] firstChunkFinal = firstChunk;  
        }, "shuffle-drain-" + node.getQueryId() + "-" + node.getTargetStageId() + "-" + side + "-" + node.getShufflePartitionIndex());
                            // best-effort  
            throw new IllegalStateException(
    private static final Logger LOGGER = LogManager.getLogger(ShuffleScanHandler.class);
import org.apache.logging.log4j.Logger;
 * this file be licensed under the Apache-2.0 license or a
     *  tests can dial it down without waiting on full SPI plumbing.
 */
 * The OpenSearch Contributors require contributions made to  
                LOGGER.error(
                    + "in the worker stage's plan alternative."
        // Pass the compression factory so a producer-compressed chunk decodes; the reader
 * {@link ShardScanInstructionHandler} so the {@code SessionContextHandle} exists. The
            }
        System.getProperty("analytics.mpp.shuffle.recv_timeout_ms", "5000")
    private static int pumpChunkIntoSender(byte[] chunkIpc, BufferAllocator alloc, DatafusionPartitionSender sender) throws Exception {  
 * partitioned stream.
        }  
                        } catch (Throwable ignore) {
                }
                );
    private static byte[] extractSchemaIpc(byte[] chunkIpc, BufferAllocator alloc) throws Exception {  
        } catch (InterruptedException e) {  
                );
        // Failures still close both so the partition terminates rather than hanging the join.
                        } catch (Throwable ignore) {
                    "ShuffleScanHandler.drain: drained {} batches across {} chunks for {} (side={}, partition={})",  
                        }
            firstChunk = chunks.hasNext() ? chunks.next() : null;  
 *
                node.getTargetStageId(),
    private static final long DEFAULT_AWAIT_READY_TIMEOUT_MS = Long.parseLong(  
                );
            // returns. The current handler still drains only its own side, but we must wait for  
            if (!buffer.awaitReady(DEFAULT_AWAIT_READY_TIMEOUT_MS)) {  
 * the registered table is still resolvable so the worker plan binds, and the join produces  
     */
            );
            throw new IllegalStateException(
                // Empty agg-shuffle partition: register the (logical-named) streaming table from the
                    + "(typically ShardScanInstructionHandler), got "
     *  <p>5s default keeps test timelines tight while leaving headroom for slow CI hosts.  
                return backendContext;
        // expectedSenders for both sides are set eagerly by the ShuffleWorkerSetupHandler
                        + inputId  
                new long[0]
    /**  
        // Substrait consumer binds base_schema to the registered provider BY NAME, so registering the
            );  
                    node.getQueryId(),
 * {@code AnalyticsSearchService}'s instruction-handler loop and fails the fragment.
 * dispatcher appends two of these per partition (left, right) after the shard-scan setup.  
            } catch (Throwable t) {
            throw new RuntimeException("ShuffleScanHandler: interrupted while awaiting shuffle producers for " + inputId, e);
                while (chunkIter.hasNext()) {
                    }  
            );
import org.opensearch.analytics.spi.ShuffleScanInstructionNode;
        drainThread.setDaemon(true);  
        // doesn't run until ALL handlers finish. Running the drain off-thread lets  
import org.opensearch.analytics.backend.ShardScanExecutionContext;  
        // table with the raw IPC (physical) names fails the FINAL with "No field named sum_qty". When  
 * handler drains the buffer's accumulated IPC chunks for the {@code "left"} or {@code "right"}
                    if (!handedOff) {
        // M3 agg-shuffle worker: the producer ships the PARTIAL aggregate's physical batches whose
            // Block here until BOTH sides' producers have all reported isLast for this partition.  
                    // either way — close on a hand-off-d wrapper is a no-op.  
                node.getExpectedSenders()
            ByteArrayInputStream in = new ByteArrayInputStream(chunkIpc);
        // its NamedScan against.
            // the not-yet-arrived side are racing in the same buffer.
 */  
 * for the streaming-table registration. If the buffer's accumulated bytes are empty (no
                    "ShuffleScanHandler: empty partition for {} (queryId={}, stage={}, part={}); registering logical-named empty stream from partial plan",
 * left and right producers have all reported {@code isLast} for this partition, then the  
                    } else {
                try {
        }  
        }
        // handle leak on registration throw.)  
/*  
        // LAZY drain: pull chunks one at a time. With spill, only ONE chunk is heap-resident at a
                    handedOff = true;
     *  microseconds. */
        // partition: register an empty memtable and return. Close the iterator on every path here.  
        final CloseableIterator<byte[]> chunkIter = chunks;
            }  
 *
 * the Arrow IPC stream spec). The handler reads the first chunk's header to derive the schema  
                LOGGER.debug(
        ShuffleScanInstructionNode node,  
import org.opensearch.analytics.spi.ShuffleBufferRegistry;
}
                        }
        try {
                // producer's PARTIAL plan (fixes the q1/q15 sum_qty[sum] by-name bind).
     * Decodes every batch in {@code chunkIpc} and pushes each into the native sender via Arrow  
 * <p>The handler runs synchronously on the data-node executor thread that processes the
        long senderPtr;
import org.opensearch.analytics.spi.CloseableIterator;  
        // (which runs before any ShuffleScanHandler) so the buffer knows BOTH sides' counts
        drainThread.start();
            NativeBridge.registerMemtableOnSessionContext(
import org.opensearch.analytics.spi.ShuffleBufferAccess;  
        if (firstChunk == null) {
                // Join-shuffle: schema from the first chunk's IPC header (producer ships raw rows whose  
                        try {
    }  
                long emptySenderPtr = NativeBridge.registerPartitionStreamOnSessionContextFromPartialPlan(
                ArrowArray array = ArrowArray.allocateNew(alloc);
     *  solely as a backstop against stuck producers (cancelled queries cascade through the  
                // A drain/IPC/spill-read failure here means the partition stream is TRUNCATED. Closing
     * {@link NativeBridge#registerPartitionStreamOnSessionContext} expects.
/**
            Thread.currentThread().interrupt();
                    inputId,
                            array.close();  
     *  Real shuffle producers are far faster — a single batch RTT over local transport is
                node.getQueryId(),
                senderPtr = NativeBridge.registerPartitionStreamOnSessionContextFromPartialPlan(  
            throw new IllegalStateException(  
                } finally {  
            // both because the producer-side dispatch fires concurrently and the IPC bytes for
        // open spill-file handle when the partition was spilled) — ownership only transfers to the
import java.io.ByteArrayInputStream;
                inputId,  
        int count = 0;
                "ShuffleScanHandler: side must be 'left' or 'right', got '" + side + "' (namedInputId=" + inputId + ")"
                );  
                byte[] schemaIpc = extractSchemaIpc(firstChunk, alloc);
                node.getShufflePartitionIndex(),
                    inputId,  
                "ShuffleScanHandler: expected DataFusionSessionState from a prior handler "  
        BackendExecutionContext backendContext
