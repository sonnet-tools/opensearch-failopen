                );
            }
            }
                    }
 * <p>The handler runs synchronously on the data-node executor thread that processes the
        if (registry == null) {
                    handedOff = true;
            throw new RuntimeException("ShuffleScanHandler: failed to register partition stream for " + inputId, e);
            // Block here until BOTH sides' producers have all reported isLast for this partition.
import org.opensearch.analytics.spi.CloseableIterator;
        ) {
        BufferAllocator alloc = shardCtx.getAllocator();
        }
                // would silently produce WRONG results from partial input. Instead FAIL the sender: it
                        } catch (Throwable ignore) {
                    node.getQueryId(),
import org.apache.arrow.vector.VectorSchemaRoot;
                side,
                    sessionState.sessionContextHandle().getPointer(),
                "ShuffleScanHandler: ShuffleBufferRegistry not plumbed into ShardScanExecutionContext. "
                while (chunkIter.hasNext()) {
 * side (the named-input id encodes which) and pushes each batch into the native sender.
            );
        // engine.execute start in parallel, drain the channel, and unblock the sender.
        String inputId = node.getNamedInputId();
                );
            throw new IllegalStateException(
        CommonExecutionContext commonContext,
                    side,
 * <p>Schema discovery: the partition's IPC chunks each include their own schema header (per
                senderPtr = NativeBridge.registerPartitionStreamOnSessionContextFromPartialPlan(
                    // On success Rust released the underlying FFI structs (the release callback
                        // Always close the Java wrappers' tracking state. Native already owns
                // producer's PARTIAL plan (fixes the q1/q15 sum_qty[sum] by-name bind).
                    producerPlanBytes
        // table with the raw IPC (physical) names fails the FINAL with "No field named sum_qty". When
        if (!(backendContext instanceof DataFusionSessionState sessionState)) {
                    inputId,
        int count = 0;
        } catch (Exception e) {
                    + "(typically ShardScanInstructionHandler), got "
            );
     *  handler reads the JVM system property of the same name as a stopgap so integration
            throw new IllegalStateException(
 * the registered table is still resolvable so the worker plan binds, and the join produces
    public BackendExecutionContext apply(
            Throwable drainFailure = null;
     *  <p>5s default keeps test timelines tight while leaving headroom for slow CI hosts.
                }
                    node.getTargetStageId(),
                    sessionState.sessionContextHandle().getPointer(),
            );
            Thread.currentThread().interrupt();
                    if (drainFailure != null) {
    private static int pumpChunkIntoSender(byte[] chunkIpc, BufferAllocator alloc, DatafusionPartitionSender sender) throws Exception {
 * {@link ShardScanInstructionHandler} so the {@code SessionContextHandle} exists. The
                );
                new long[0],
     *
        ShuffleScanInstructionNode node,
import org.opensearch.analytics.spi.ShuffleBufferRegistry;
                        + " (timeout="
            } finally {
 * the Arrow IPC stream spec). The handler reads the first chunk's header to derive the schema
        byte[] firstChunk;
                    sessionState.sessionContextHandle().getPointer(),
        final byte[] firstChunkFinal = firstChunk;
 * The OpenSearch Contributors require contributions made to
    }
import org.opensearch.analytics.exec.shuffle.ShuffleCompression;
        // producerPlanBytes is present, register via the partial-plan derivation (mirrors the working
            } catch (Throwable t) {
 * surfaced as a {@link RuntimeException} that propagates back through
import org.opensearch.analytics.spi.BackendExecutionContext;
        // coordinator-reduce register_partition_stream) so the table carries logical names; the
                // Empty agg-shuffle partition: register the (logical-named) streaming table from the
     * Decodes every batch in {@code chunkIpc} and pushes each into the native sender via Arrow
                "ShuffleScanHandler: expected ShardScanExecutionContext, got "
            return ArrowSchemaIpc.toBytes(reader.getVectorSchemaRoot().getSchema());
                try {
    /**
}
        DatafusionPartitionSender sender = new DatafusionPartitionSender(senderPtr);
            );
                        }
 * {@code AnalyticsSearchService}'s instruction-handler loop and fails the fragment.
        drainThread.start();
            firstChunk = chunks.hasNext() ? chunks.next() : null;
                node.getQueryId(),
     *  tests can dial it down without waiting on full SPI plumbing.
                drainFailure = t;
     *  microseconds. */
                // names already match the consumer's expected input — no re-lowering needed).
            }
                node.getQueryId(),
 * handler drains the buffer's accumulated IPC chunks for the {@code "left"} or {@code "right"}
     *  once that cluster setting is plumbed into {@link ShardScanExecutionContext}; today the
                try {
                    + "AnalyticsSearchService.setShuffleBufferRegistry must be called at plugin startup."
        // (which runs before any ShuffleScanHandler) so the buffer knows BOTH sides' counts
        ShuffleBufferRegistry registry = shardCtx.getShuffleBufferRegistry();
     * {@link ArrowSchemaIpc#toBytes} produces — what
                sessionState.sessionContextHandle().getPointer(),
import org.apache.arrow.c.Data;
                    schemaIpc
        byte[] producerPlanBytes = node.getProducerPlanBytes();
        // "input-<producerStageId>" the fragment convertor emits for the StageInputScan leaf below
        // M3 agg-shuffle worker: the producer ships the PARTIAL aggregate's physical batches whose
        }
                try {
public class ShuffleScanHandler implements FragmentInstructionHandler<ShuffleScanInstructionNode> {
                            // best-effort — primary error is being surfaced
                        try {
            chunks.close();
        }
                }
        System.getProperty("analytics.mpp.shuffle.recv_timeout_ms", "5000")
        long senderPtr;
        }, "shuffle-drain-" + node.getQueryId() + "-" + node.getTargetStageId() + "-" + side + "-" + node.getShufflePartitionIndex());
 * Handler for {@link ShuffleScanInstructionNode} on a hash-shuffle worker.
        // Peek the first chunk for the schema (one chunk in heap is fine). No first chunk → empty
                }
                    + (commonContext == null ? "null" : commonContext.getClass().getSimpleName())
                // Join-shuffle: schema from the first chunk's IPC header (producer ships raw rows whose
        // the stripped OpenSearchShuffleExchange — that's what the worker's Substrait plan binds
                );
                // Each loadNextBatch mutates rootView in-place. Export immediately; the native
                } finally {
        if (firstChunk == null) {
        Thread drainThread = new Thread(() -> {
        }
                        } catch (Throwable ignore) {
        // open spill-file handle when the partition was spilled) — ownership only transfers to the
        // before either side's awaitReady call blocks. Setting them per-side here would
 *
                    node.getShufflePartitionIndex()
                            // best-effort
        // spill-file handle) and the sender (closing it signals EOF to the native StreamingTable).
                LOGGER.debug(
                // pushes an error into the channel so the consumer's stream yields an ERROR and the
 */
        try {
/*
import org.apache.arrow.c.ArrowSchema;
        // Substrait consumer binds base_schema to the registered provider BY NAME, so registering the
                );
        // Failures still close both so the partition terminates rather than hanging the join.
                            array.close();
                    // either way — close on a hand-off-d wrapper is a no-op.
                );
        // handle leak on registration throw.)
import org.opensearch.analytics.spi.ShuffleBufferAccess;
                        }
                            arrowSchema.close();
                        } catch (Throwable ignore) {
 * to a DataFusion {@code StreamingTable} via {@link
                    } else {
        boolean isLeftSide = "left".equals(side);
        // The instruction carries side ("left"/"right") explicitly. namedInputId is the canonical
/**
                            arrowSchema.close();
                        }
 * NativeBridge#registerPartitionStreamOnSessionContext} — the worker's Substrait plan
                // sender takes ownership of the FFI structs on success.
        }
                } catch (Throwable closeErr) {
 * compatible open source license.
                    sender.send(array.memoryAddress(), arrowSchema.memoryAddress());
            // The buffer's awaitReady gates on left-and-right because the handler runs once for
 *
                "ShuffleScanHandler: empty partition for {} (queryId={}, stage={}, part={}); registering empty memtable",
        return count;
                    + ". The shuffle-scan instruction must be appended after the scan-setup instruction "
 *
                        + DEFAULT_AWAIT_READY_TIMEOUT_MS
import org.apache.arrow.memory.BufferAllocator;
            NativeBridge.registerMemtableOnSessionContext(
 * @opensearch.internal
                        try {
     */
import org.opensearch.analytics.backend.ShardScanExecutionContext;
            int totalBatches = 0;
                    t
        String side = node.getSide();
     * {@link NativeBridge#registerPartitionStreamOnSessionContext} expects.
    }
import org.opensearch.analytics.spi.CommonExecutionContext;
        drainThread.setDaemon(true);
import org.opensearch.analytics.spi.FragmentInstructionHandler;
 * left and right producers have all reported {@code isLast} for this partition, then the
            while (reader.loadNextBatch()) {
                    count++;
                LOGGER.debug(
        // Pass the compression factory so a producer-compressed chunk decodes; the reader
                            array.close();
import org.apache.logging.log4j.Logger;
        final CloseableIterator<byte[]> chunkIter = chunks;
        } catch (RuntimeException e) {
                    "ShuffleScanHandler: empty partition for {} (queryId={}, stage={}, part={}); registering logical-named empty stream from partial plan",
    );
                senderPtr = NativeBridge.registerPartitionStreamOnSessionContext(
                chunkCount++;
                    "ShuffleScanHandler.drain: drained {} batches across {} chunks for {} (side={}, partition={})",
        // deadlock — the second side's count is set only AFTER the first side's blocked.
            );
                    chunkCount++;
                node.getExpectedSenders()
        if (!isLeftSide && !"right".equals(side)) {
        // doesn't run until ALL handlers finish. Running the drain off-thread lets
            if (!buffer.awaitReady(DEFAULT_AWAIT_READY_TIMEOUT_MS)) {
        }
        ShuffleBufferAccess buffer = registry.getOrCreate(node.getQueryId(), node.getTargetStageId(), node.getShufflePartitionIndex());
            // both because the producer-side dispatch fires concurrently and the IPC bytes for
 * SPDX-License-Identifier: Apache-2.0
                "ShuffleScanHandler: side must be 'left' or 'right', got '" + side + "' (namedInputId=" + inputId + ")"
        // expectedSenders for both sides are set eagerly by the ShuffleWorkerSetupHandler
        // auto-detects the codec (incl. NO_COMPRESSION) from the IPC message metadata.
                ArrowArray array = ArrowArray.allocateNew(alloc);
                        finalSender.fail("shuffle drain failed for " + inputId + " (side=" + side + "): " + drainFailure);
        // fragment's Substrait base_schema declares the Calcite LOGICAL names (sum_qty). DataFusion's
 * partitioned stream.
                );
                    inputId,
        // re-materializing (the whole point of disk spill). The iterator owns the spill-file handle.
                // the sender cleanly would signal EOF to the native StreamingTable, so the join/agg
    private static final long DEFAULT_AWAIT_READY_TIMEOUT_MS = Long.parseLong(
            // each side; both invocations agree the buffer is fully populated before either
            }
                    inputId,
        try {
    }
                    } else {
        }
        // keeps the raw-IPC path unchanged.
                node.getTargetStageId(),
        try {
    /**
import java.io.ByteArrayInputStream;
            ByteArrayInputStream in = new ByteArrayInputStream(chunkIpc);
                    inputId,
                }
 *
                    chunkCount,
                    }
import org.opensearch.be.datafusion.nativelib.NativeBridge;
import org.apache.logging.log4j.LogManager;
            int chunkCount = 0;
package org.opensearch.be.datafusion;
import org.opensearch.analytics.spi.ShuffleScanInstructionNode;
        // its NamedScan against.
    /** Cap on how long the consumer waits for both producer sides to mark {@code isLast}.
     *  Real shuffle producers are far faster — a single batch RTT over local transport is
            ArrowStreamReader reader = new ArrowStreamReader(in, alloc, ShuffleCompression.FACTORY)
 *
                    if (!handedOff) {
 * zero rows from this partition.
                new long[0]
                LOGGER.error(
        BackendExecutionContext backendContext
                inputId,
            try {
                // A drain/IPC/spill-read failure here means the partition stream is TRUNCATED. Closing
                byte[] schemaIpc = extractSchemaIpc(firstChunk, alloc);
            LOGGER.debug(
 * references the resulting {@code NamedScan} so the hash-join's input resolves to the
                ArrowSchema arrowSchema = ArrowSchema.allocateNew(alloc);
        // state columns are named <alias>[<state>] (e.g. sum_qty[sum]), but the worker FINAL
        return backendContext;
        CloseableIterator<byte[]> chunks = isLeftSide ? buffer.drainLeft() : buffer.drainRight();
                // this partition. A 0-column empty memtable would fail the FINAL's by-name bind.
        // Drain chunks into the native sender on a background thread. The native partition
        // The background thread owns the lifecycle of BOTH the chunk iterator (releases the
 * <p>Failure surface: any IO exception during decode, alignment, or FFM registration is
            chunks.close();
        ) {
                            // best-effort — primary error is being surfaced
 *
                } catch (Throwable closeErr) {
 *
     *  solely as a backstop against stuck producers (cancelled queries cascade through the
            throw new IllegalStateException(
            if (producerPlanBytes != null) {
        // physically-named batches still feed in positionally. Null producerPlanBytes (join-shuffle)
        if (!(commonContext instanceof ShardScanExecutionContext shardCtx)) {
     *  walker faster than this). Operator-tuneable via {@code analytics.mpp.shuffle.recv_timeout}
            VectorSchemaRoot rootView = reader.getVectorSchemaRoot();
     * Reads the schema header from an Arrow IPC stream chunk and returns an isolated
            LOGGER.debug(
                "ShuffleScanHandler: expected DataFusionSessionState from a prior handler "
import org.apache.arrow.c.ArrowArray;
                boolean handedOff = false;
            throw new IllegalStateException(
                node.getTargetStageId(),
                // partial plan so the FINAL binds, then close the sender immediately — 0 rows for
        final DatafusionPartitionSender finalSender = sender;
                new DatafusionPartitionSender(emptySenderPtr).close();
            }
                    + (backendContext == null ? "null" : backendContext.getClass().getSimpleName())
                        + inputId
                inputId,
                long emptySenderPtr = NativeBridge.registerPartitionStreamOnSessionContextFromPartialPlan(
        }
            // the not-yet-arrived side are racing in the same buffer.
        // drain thread AFTER a sender is successfully constructed below. (codex review: spill-file
     * C Data Interface. Returns the batch count for logging.
                    totalBatches,
        try (
                totalBatches += pumpChunkIntoSender(firstChunkFinal, alloc, finalSender);
                    LOGGER.warn("ShuffleScanHandler.drain: chunk iterator close failed for " + inputId, closeErr);
    private static byte[] extractSchemaIpc(byte[] chunkIpc, BufferAllocator alloc) throws Exception {
    ) {
    private static final Logger LOGGER = LogManager.getLogger(ShuffleScanHandler.class);
        try (
                // Agg-shuffle worker: register with the LOGICAL schema derived by re-lowering the
        // LAZY drain: pull chunks one at a time. With spill, only ONE chunk is heap-resident at a
        // stream is a bounded mpsc (capacity 4): synchronous draining inside this handler
                        // the underlying memory.
     *  Real producers complete within milliseconds on a healthy cluster — the cap exists
                        }
                            // best-effort
        } catch (InterruptedException e) {
            } else {
                    // is nulled); on failure we own them and must close. Java-side close is safe
            if (producerPlanBytes != null) {
 * <p>Chain-ordering requirement: same as {@link BroadcastInjectionHandler} — must run AFTER
            throw new RuntimeException("ShuffleScanHandler: failed to read first shuffle chunk for " + inputId, e);
                    totalBatches += pumpChunkIntoSender(chunkIter.next(), alloc, finalSender);
                        + "ms)"
                    Data.exportVectorSchemaRoot(alloc, rootView, null, array, arrowSchema);
            ArrowStreamReader reader = new ArrowStreamReader(in, alloc, ShuffleCompression.FACTORY)
     * IPC-stream blob containing only that schema. The returned bytes are the same shape
                // query fails loudly rather than under-delivering. (#17: native df_sender_fail.)
                    "ShuffleScanHandler: timed out waiting for shuffle producers to finish for "
        // would block on the 5th send because the consumer (engine.execute → HashJoinExec)
                        try {
        // partition: register an empty memtable and return. Close the iterator on every path here.
            );
                        } catch (Throwable ignore) {
                    node.getShufflePartitionIndex()
                "ShuffleScanHandler: awaiting partition stream queryId={}, stage={}, partition={}, side={}, expectedSenders={}",
                return backendContext;
        // Register the partition stream. Any failure here must close the chunk iterator (which owns an
 */
import org.apache.arrow.vector.ipc.ArrowStreamReader;
            throw new RuntimeException("ShuffleScanHandler: interrupted while awaiting shuffle producers for " + inputId, e);
            ByteArrayInputStream in = new ByteArrayInputStream(chunkIpc);
     */
                        try {
                    + "in the worker stage's plan alternative."
                new byte[0],
                node.getShufflePartitionIndex()
 * producer rows for this partition) the handler treats the partition as a zero-batch stream —
 * this file be licensed under the Apache-2.0 license or a
                        finalSender.close();
                    producerPlanBytes
        // time — the rest stream from the spill file — so an over-budget partition drains without
        }
            chunks.close();
            );
        //
            // returns. The current handler still drains only its own side, but we must wait for
                    LOGGER.warn("ShuffleScanHandler.drain: sender teardown failed for " + inputId, closeErr);
                    chunkIter.close();
 * for the streaming-table registration. If the buffer's accumulated bytes are empty (no
                        // Truncated partition: surface an error to the consumer (not a clean EOF).
    @Override
                node.getShufflePartitionIndex(),
            return backendContext;
 * <p>Bridges the node-local {@link org.opensearch.analytics.exec.shuffle.ShuffleBufferManager}
                throw new RuntimeException(
                    "ShuffleScanHandler.drain FAILED for " + inputId + " — partition stream truncated, failing the consumer stream",
 * fragment's instruction list. {@link ShuffleBufferAccess#awaitReady} blocks here until both
                    inputId,
 * dispatcher appends two of these per partition (left, right) after the shard-scan setup.
        }
