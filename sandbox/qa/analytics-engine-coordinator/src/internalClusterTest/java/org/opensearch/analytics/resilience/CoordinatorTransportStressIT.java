        createSingleShardIndex(INDEX_1);
            assertTrue("No fragment tasks should linger after cancel: " + infos, infos.isEmpty());
                .collect(Collectors.joining(","));
import org.opensearch.analytics.AnalyticsPlugin;
            v.set(i, VALUE);
    /** Extracted filler — kept out of {@link #buildBatch} so JIT compiles them independently. */
    // for queries that do not push a backend-aggregating COORDINATOR_REDUCE
import java.util.concurrent.atomic.AtomicInteger;
     * exceeds the coordinator output cap, so the result is truncated to
        assertTrue("create must be acknowledged", response.isAcknowledged());
    // more than the cap to stress the streaming transport path (many round-trip
            mts.clearAllRules();
            // integrity asserted above.
    public static void releaseProducerAllocator() {
            .put(super.nodeSettings(nodeOrdinal))
        // FlightServerChannel/StreamTransportService), not in analytics-engine. Restore to
     * and the coordinator's FINAL aggregate stage receives the raw batches
                    sent.incrementAndGet();
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
    public void testCoordinatorHandlesHundredBatchesFromOneShard() throws Exception {
                producerHighWater.get() <= ceiling
                    VectorSchemaRoot root = buildBatch();
        assertEquals(tag + " retained rows must be intact (sum == rowsKept × VALUE)", actualRows * VALUE, sumValueColumn(response));
            .build();
    }
        } finally {
                        } catch (InterruptedException ie) {
                    + beforeProducer
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
                            counter.incrementAndGet();
            mts.clearAllRules();
        String victim = pickShardHostingNode(INDEX_1);
            AtomicReference<Throwable> firstFailure = new AtomicReference<>();
 * many batches of pre-built {@link VectorSchemaRoot}s through the data-node
                    + " before="
import org.opensearch.common.util.FeatureFlags;
import java.util.concurrent.CountDownLatch;
            for (MockTransportService mts : stubbed) {
        for (String node : internalCluster().getNodeNames()) {
        for (ShardRouting sr : clusterService().state().routingTable().index(indexName).shardsWithState(ShardRoutingState.STARTED)) {
        // Pinned to 1 (was 2) to isolate "is the failure transport-layer or analytics-engine?".
        // is in concurrent streaming dispatch (head-of-line block in
            List<TaskInfo> infos = remaining.getTasks();
                }
     */
    private PPLResponse executePPL(String ppl, TimeValue timeout) {
import org.junit.BeforeClass;
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
        for (int i = 0; i < ROWS_PER_BATCH; i++) {
import java.util.Collections;
        ensureGreen(INDEX_3);
        try {
    }
        // behaviors via addRequestHandlingBehavior; mts.clearAllRules() in the
            // VSRs the producer holds at any one time. FlightTransportChannel
        try {
            CompositeDataFormatPlugin.class,
                    succeeded++;
                .map(e -> e.getKey() + ":" + e.getValue().get())
                total += n.longValue();
import java.util.ArrayList;
            } catch (Exception ignore) {}
        }
            assertTrue("Producer must reach " + cancelAt + " batches", hitTen.await(STRESS_TIMEOUT.seconds(), TimeUnit.SECONDS));
                    channel.sendResponse(new RuntimeException("stress S4 producer failed at batch=" + sent.get(), t));
                        }
    // directly, so the sink caps the result. These tests intentionally send far
        // Confirm 3 distinct nodes (one shard per node typical).
        return List.of(
     * coordinator's reduce sink + native mpsc backpressure + drain-thread keep
    // stage. The synthetic batches we emit here come from a stub handler that
        // Pre-size to avoid reAlloc churn inside setValueCount → cleaner
import org.opensearch.Version;
                concurrency,
                        channel.sendResponse(new RuntimeException("stress S2 producer failed on " + node, t));
        long actualRows = response.getRows().size();
            .put("index.composite.primary_data_format", "parquet")
                AtomicInteger counter = e.getValue();
        final int batchesPerQuery = 15;
            } catch (Throwable t) {
            client().prepareIndex(INDEX_3).setSource("value", VALUE).get();
    private void createThreeShardIndex() {
            long after = dfs.getMemoryPoolUsage();
 * ownership of the supplied root via {@code transferRoot} and closes it, so
    @BeforeClass
            .setMapping("value", "type=integer")
                } catch (Throwable t) {
     * the summed column equals {@code rowsKept × VALUE}. We deliberately do NOT
    );
                    long mid = producerAllocator.getAllocatedMemory();
        // running this test alone (without S1–S4 preceding) does NOT
    public void testBackPressureDoesNotDropBatches() throws Exception {
            cancelIssued.countDown();
        });
    private static final long PER_BATCH_BYTES = ROWS_PER_BATCH * 4L + 8 * 1024L;
            try {
        // dispatch path.
                }
import java.util.Map;
     * S4 — Backpressure: producer emits fast (no sleeps). The transport path must
import org.opensearch.ppl.TestPPLPlugin;
        // (single-shard index → all 4 land on the same node), only 2 of 4
    private Map<Integer, String> shardToNode(String indexName) {
            }
    public void testCancelMidStressRun() throws Exception {
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
import org.junit.After;
import org.opensearch.cluster.metadata.IndexMetadata;
        // Coordinator finding: when 4 PPL queries concurrently dispatch
     */
            List<Future<long[]>> futures = new ArrayList<>();
     * up under sustained per-shard load. The 500k rows sent far exceed the
    }
        }
        assertBusy(() -> {
                            VectorSchemaRoot root = buildBatch();
            }
    /** Long-lived producer allocator: shared across tests, cleaned in {@link #releaseProducerAllocator()}. */
            for (int i = 0; i < concurrency; i++) {
                futures.add(exec.submit(() -> {
            .indices()
    private static volatile BufferAllocator producerAllocator;
        for (String node : map.values()) {
     * deliver every batch to the coordinator (no transport-level loss) and keep the
        } catch (IllegalStateException ignore) {}
        // (node, action) pair sees rapid re-dispatch under MockTransport-
    // buffered output at OUTPUT_ROW_CAP rows (RowProducingSink.DEFAULT_MAX_ROWS)
        String victim = pickShardHostingNode(INDEX_1);
import org.apache.arrow.vector.types.pojo.Schema;
                        hitTen.countDown();
import java.util.concurrent.atomic.AtomicReference;
    }
            sentByNode.computeIfAbsent(node, k -> new AtomicInteger());
     * producer-side allocator high-water bounded. The coordinator output sink then
        final int batches = 100;
     * buffered output, and these tests stress the transport path well past that cap.
            "NA",
            "classpath plugin",
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        } finally {
    /**
import org.opensearch.ppl.action.PPLResponse;
package org.opensearch.analytics.resilience;
                for (int i = 0; i < totalBatches; i++) {
/*
        return shardToNode(indexName).values().iterator().next();
import java.util.concurrent.ExecutionException;
        );
        // request (one per shard), still emitting batchesPerShard batches per
            // batch bytes for N enqueued batches. This is informational —
            MockCommitterEnginePlugin.class
        // The handler emits the same shape per request — each invocation gets
                channel.completeStream();
            // pressure on the unbatched send path. In practice the producer
     * verify the per-row payload arrives intact across many streaming
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet(timeout);
        createSingleShardIndex();
        long rowsSent = (long) ROWS_PER_BATCH * batchesPerShard * map.size();
     * output cap, so each independent client-side future verifies the per-query
                after <= before + 2L * 1024L * 1024L
            // The producer allocator high-water reflects how many in-flight
                String name = clusterService().state().nodes().get(nodeId).getName();
                fut.get(STRESS_TIMEOUT.seconds(), TimeUnit.SECONDS);
    // bypasses the production partial-aggregation path — they arrive at the
import java.util.List;
 * @opensearch.internal
            try {
                String node = e.getKey();
        return vsr;
 * The OpenSearch Contributors require contributions made to
     */
        assertBusy(() -> {
import org.opensearch.ppl.action.PPLRequest;
            }
        // requests.
                channel.completeStream();
        return Settings.builder()
                    if (s == cancelAt) {
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
        CountDownLatch hitTen = new CountDownLatch(1);
        // on the same node, the stub fires once per FragmentExecutionAction
     * {@code RowProducingSink.DEFAULT_MAX_ROWS}. The row-collecting sink truncates
            // first, so the bound here is loose: high-water ≤ (N+1) × per-
            mts.clearAllRules();
            );
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        String victim = pickShardHostingNode(INDEX_1);
import org.opensearch.test.junit.annotations.TestLogging;
        // streaming handlers fire reliably under suite-scope concurrency —
            if (sr.primary()) {
        if (a != null) {
 * the producer must build a fresh root per emission.
import org.opensearch.common.unit.TimeValue;
        }
            PPLResponse response = executePPL("source = " + INDEX_3, STRESS_TIMEOUT);
            MockTransportService.TestPlugin.class,
import java.util.concurrent.TimeUnit;
     * coordinator output cap, so the result is truncated to OUTPUT_ROW_CAP rows
    @Override
 *
            .put("index.pluggable.dataformat", "composite")
        // reproduce the hang, so JVM-static state from prior tests
            exec.awaitTermination(5, TimeUnit.SECONDS);
        // 2 (or higher) once the streaming-dispatch hazard is fixed.
                    VectorSchemaRoot root = buildBatch();
                        // Block until cancel is issued (or 5s passes) so cancellation
    }
            for (Map.Entry<String, AtomicInteger> e : sentByNode.entrySet()) {
            .putList("index.composite.secondary_data_formats")
public class CoordinatorTransportStressIT extends OpenSearchIntegTestCase {
            try {
            .put("index.pluggable.dataformat", "composite")
            false
            .prepareCreate(INDEX_3)
        List.of(new Field("value", new FieldType(true, new ArrowType.Int(32, true), null), Collections.emptyList()))
                    channel.sendResponse(new RuntimeException("stress S5 producer failed", t));
     * batches. We sum at the test side rather than relying on
    private static void assertCappedResult(String tag, long rowsSent, PPLResponse response) {
    protected Collection<PluginInfo> additionalNodePlugins() {
                    assertEquals("S5 query[" + i + "] sum mismatch", expectedSumPerQuery, result[1]);
    @After
        AtomicInteger totalSent = new AtomicInteger();
            .putList("index.composite.secondary_data_formats")
        // separate item. Likely cause: a head-of-line block in either
        producerAllocator = new RootAllocator(Long.MAX_VALUE);
        // pin concurrency=2 here so the test asserts a stable contract;
     * S5 — concurrent stress queries against the same single-shard index. Each
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
 * directly to the {@code TransportChannel}. Each batch is a freshly-allocated
        Settings indexSettings = Settings.builder()
                mts.clearAllRules();
            String sentReport = sentByNode.entrySet()
        // (producerAllocator, JIT cache) interacts with the streaming
        long total = 0;
        }
            pluginClass.getName(),
        // StreamTransportService's pending-request queue when the same
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
import org.junit.AfterClass;
import org.opensearch.tasks.TaskInfo;
                } catch (Throwable t) {
     * coordinator-finding behaviors recorded for these tests).
                    if (task instanceof org.opensearch.tasks.CancellableTask ct && ct.isCancelled()) {
            .put(FeatureFlags.STREAM_TRANSPORT, true)
                    producerHighWater.accumulateAndGet(mid, Math::max);
            } catch (Exception ignore) {}
            .indices()
        client().prepareIndex(indexName).setSource("value", VALUE).get();
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
    /** Build a fresh VSR with {@link #ROWS_PER_BATCH} rows of constant {@link #VALUE}. */
        ExecutorService exec = Executors.newSingleThreadExecutor();
            pluginClass.getName(),
                }));
            .prepareCreate(indexName)
    private String pickShardHostingNode(String indexName) {
                a.close();
            .setSettings(indexSettings)
                    VectorSchemaRoot root = buildBatch();
                    }
            // can allocate all N batches before the serializer drains the
    // every row sent. ROWS_PER_BATCH=5_000 divides the cap evenly so truncation
            throw new AssertionError("expected column 'value' in response columns=" + response.getColumns());
    private static final int ROWS_PER_BATCH = 5_000;
        }
        IntVector v = (IntVector) vsr.getVector(0);
                    long[] result = futures.get(i).get(CONCURRENT_TIMEOUT.seconds(), TimeUnit.SECONDS);
        fillIntVector(v);
            .setMapping("value", "type=integer")
            mts.clearAllRules();
            }
    public void clearStubs() {
                        }
                try {
import org.opensearch.plugins.PluginInfo;
     * assert all {@code rowsSent} rows survive: {@code RowProducingSink} caps
            assertCappedResult("S1 (sent=" + sent.get() + ")", rowsSent, response);
 */
     * result is truncated to OUTPUT_ROW_CAP rows with the retained rows intact.
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            try {
                "All concurrent queries must succeed; failures=" + firstFailure.get() + " totalBatchesSent=" + totalSent.get(),
        AtomicInteger sent = new AtomicInteger();
     * buffered output at this many rows (whole batches dropped once reached), so a
        // deterministically with concurrency=4 across multiple seeds. We
        for (int i = 0; i < 9; i++) {
        );
            CancelTasksResponse cancel = client().admin().cluster().prepareCancelTasks().setActions(UnifiedPPLExecuteAction.NAME).get();
                    try {
        } finally {
    }
    /**
    @Override
        // Note: sumByNode iterates distinct host nodes — if two shards land
                for (int i = 0; i < batches; i++) {
            ListTasksResponse remaining = client().admin().cluster().prepareListTasks().setActions(FragmentExecutionAction.NAME).get();
            .put("index.pluggable.dataformat.enabled", true)
import org.opensearch.common.settings.Settings;
                            channel.sendResponseBatch(new FragmentExecutionArrowResponse(root));
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
 * Transport-level stress suite for the analytics-engine coordinator. Pushes
                            Thread.currentThread().interrupt();
        final int totalBatches = 100;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 3, numClientNodes = 0, supportsDedicatedMasters = false)
                });
@TestLogging(reason = "debugging stress behavior", value = "org.opensearch.analytics:DEBUG")
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
        client().admin().indices().prepareFlush(INDEX_3).get();
        assertTrue("create must be acknowledged", response.isAcknowledged());
        List<MockTransportService> stubbed = new ArrayList<>();
    private static final long OUTPUT_ROW_CAP = 10_000L;
                        for (int i = 0; i < batchesPerShard; i++) {
                    PPLResponse r = executePPL("source = " + INDEX_1, CONCURRENT_TIMEOUT);
                        // races with the producer rather than racing past it.
     * raw (non-aggregating) stream of N rows yields {@code min(N, OUTPUT_ROW_CAP)}
                    return executePPL("source = " + INDEX_1, STRESS_TIMEOUT);
    }
import org.opensearch.test.OpenSearchIntegTestCase;
            } catch (Throwable t) {
        final long expectedSumPerQuery = expectedRowsPerQuery * VALUE;
                try {
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
     */
        });
                    channel.sendResponseBatch(new FragmentExecutionArrowResponse(root));
    /** 3-shard index for the multi-shard stress variant. */
        long beforeProducer = producerAllocator.getAllocatedMemory();
                        channel.completeStream();
                    channel.sendResponse(new RuntimeException("stress S3 producer failed at batch=" + sent.get(), t));
        // 2 × batchesPerQuery on suite runs). This was reproduced
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
    // therefore expect the capped output (min(sent, OUTPUT_ROW_CAP)) rather than
        } finally {
import org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse;
            assertCappedResult("S2 (sent=" + sentReport + ")", rowsSent, response);
        long expectedRows = Math.min(rowsSent, OUTPUT_ROW_CAP);
     * (with the retained rows intact); the stress value is the 100 streamed
     * output truncation: the row count is {@code min(rowsSent, OUTPUT_ROW_CAP)},
    private static final String INDEX_3 = "stress_idx_3";
    // coordinator as raw Int32 row batches and feed the row-collecting sink
 */
        // No residual fragment tasks.
        vsr.setRowCount(ROWS_PER_BATCH);
 * sink, exchange-stream wiring, and listener accounting are exercised on a
 * side {@link FragmentExecutionAction} handler so the coordinator's reduce
            .build();
        // never invoked at all (zero batches sent, totalSent reflects only
        // expanding to 4 once the streaming fan-out hang is fixed is a
        BufferAllocator a = producerAllocator;
        AtomicLong producerHighWater = new AtomicLong();
                } catch (Throwable ignore) {}
                MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
    private static void fillIntVector(IntVector v) {
            null,
            exec.shutdownNow();
        final long rowsSent = (long) ROWS_PER_BATCH * batches;
    }
     * ~2 MB of pre-query baseline.
 * single hot data-node.
        client().admin().indices().prepareRefresh(INDEX_3).get();
        CreateIndexResponse response = client().admin()
    // (whole-batch) lands deterministically on the cap. See "Coordinator
                "Native memory after cancel must be within 2 MiB of baseline; before=" + before + " after=" + after,
                } catch (Throwable ignore) {}
    private static final int VALUE = 7;
        });
                    VectorSchemaRoot root = buildBatch();
import org.opensearch.composite.CompositeDataFormatPlugin;
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
                    int s = sent.incrementAndGet();
        // grow path inside Arrow's BaseFixedWidthVector.reAlloc.
            extendedPlugins,
        String victim = pickShardHostingNode(INDEX_1);
            });
                }
    public void testConcurrentStressRuns() throws Exception {
            assertEquals(
        } finally {
                }
            assertCappedResult("S4 (sent=" + sent.get() + ")", rowsSent, response);
        final long rowsSentPerQuery = (long) ROWS_PER_BATCH * batchesPerQuery;
                    channel.sendResponseBatch(new FragmentExecutionArrowResponse(root));
            }
        }
    protected Settings nodeSettings(int nodeOrdinal) {
            exec.awaitTermination(5, TimeUnit.SECONDS);
                channel.completeStream();
 * on the streaming-transport handler for {@code FragmentExecutionAction.NAME}.
        // If the test passes deterministically at concurrency=1, the row-loss seen at >=2
     * query streams 15 batches × 5k rows (75k sent), which exceeds the coordinator
        final int batches = 50;
    private static final String INDEX_1 = "stress_idx_1";
        producerAllocator = null;
        ensureGreen(indexName);
    /**
            }
    }
     * S3 — Cancel mid-stream after ~10 batches delivered. Data-node handler stops,
                }
    @Override
            long ceiling = beforeProducer + (long) (batches + 2) * PER_BATCH_BYTES * 4L;
        // its own channel/stream so we don't share VSR ownership across
                    } catch (Throwable t) {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
import org.apache.arrow.vector.types.pojo.ArrowType;
            .get();
     * OUTPUT_ROW_CAP rows (retained rows intact); the stress value is the
    }
            ArrowBasePlugin.class,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                mts.clearAllRules();
                try {
    /** Single-shard index seeded with one row so the cluster is ready for stub injection. */
 * this file be licensed under the Apache-2.0 license or a
    }
    /** Per-batch native bytes ≈ 5_000 × 4 (Int32 data) + bitmap. */
        createSingleShardIndex();
    private static final Schema BATCH_SCHEMA = new Schema(
        v.setValueCount(ROWS_PER_BATCH);
    /**
            // .sendResponseBatch enqueues to FlightOutboundHandler's executor
                stubbed.add(mts);
                MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
            }
    }
                    return null;
                            return;
        VectorSchemaRoot vsr = VectorSchemaRoot.create(BATCH_SCHEMA, producerAllocator);
        });
            );
    }
            // the substantive check is the capped row-count + retained-row
 * SPDX-License-Identifier: Apache-2.0
        // between batches. Releasable when test thread has issued cancel.
            .get();
import org.apache.arrow.vector.types.pojo.FieldType;
 * compatible open source license.
        }
import java.util.Collection;
import java.util.stream.Collectors;
        try {
 * <p>Each test installs a {@link MockTransportService#addRequestHandlingBehavior}
    }
        try {
        try {
                        return; // do NOT completeStream — cancel path
            assertTrue(
        CountDownLatch cancelIssued = new CountDownLatch(1);
                            cancelIssued.await(5, TimeUnit.SECONDS);
        }
            .build();
     * and the retained rows are intact — every kept row carries {@link #VALUE}, so
        // shard. Use shard-count for arithmetic, not host-node count.
        Map<Integer, String> out = new HashMap<>();
import org.apache.arrow.memory.BufferAllocator;
        try {
     * {@code | stats sum(value)} because the stub bypasses the data-node
import java.util.concurrent.Future;
        // FlightServerChannel's per-stream executor handoff or
                    firstFailure.compareAndSet(null, t);
    /** Map each primary shard id → node name that currently hosts it. */
        final long expectedRowsPerQuery = Math.min(rowsSentPerQuery, OUTPUT_ROW_CAP);
        Map<Integer, String> map = shardToNode(INDEX_3);
    public void testCoordinatorHandlesBatchesAcrossAllThreeShards() throws Exception {
            PPLResponse response = executePPL("source = " + INDEX_1, STRESS_TIMEOUT);
 * {@link VectorSchemaRoot} with one Int32 column {@code value} of {@code N}
                    sent.incrementAndGet();
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
                    channel.sendResponseBatch(new FragmentExecutionArrowResponse(root));
    }
                    + producerHighWater.get()
    private void createSingleShardIndex(String indexName) {
     * round-trips, not the final row count.
            try {
            for (int i = 0; i < concurrency; i++) {
import org.apache.arrow.vector.types.pojo.Field;
     * S2 — 3-shard variant: 50 batches × 5k rows per shard. The combined stream
                .stream()
        }
        // Used to slow-down the producer enough that cancel can race in
            Future<PPLResponse> fut = exec.submit(() -> {
        final int cancelAt = 10;
}
     * truncates the buffered rows at OUTPUT_ROW_CAP, so the response reflects the
        createThreeShardIndex();
        client().admin().indices().prepareFlush(indexName).get();
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
import org.opensearch.cluster.routing.ShardRouting;
        // FragmentExecutionAction streaming requests to the same data-node
     * coordinator surfaces cancellation, native memory pool returns to within
import org.opensearch.plugins.Plugin;
        final int batchesPerShard = 50;
    /**
     */
            Object cell = row[idx];
                String nodeId = sr.currentNodeId();
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            internalCluster().clearDisruptionScheme(true);
     * fragment, so the production partial-aggregation pushdown does not run
        assertEquals("expected 3 primary shards", 3, map.size());
            } catch (Throwable t) {
import java.util.concurrent.atomic.AtomicLong;
                channel.completeStream();
            }
import org.opensearch.test.transport.MockTransportService;
        // finally runs we still want a clean state for the next test.
            if (cell instanceof Number n) {
    public static void initProducerAllocator() {
    private static final TimeValue CONCURRENT_TIMEOUT = TimeValue.timeValueSeconds(90);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
     * Coordinator output cap — mirrors the package-private
        // Defensively clear stubs on every node — each test installs handler
        final long rowsSent = (long) ROWS_PER_BATCH * batches;
        // Native memory pool returns to within 2 MiB of baseline.
            exec.shutdownNow();
                    }
    /**
                try {
        }
            "1.8",
        v.allocateNew(ROWS_PER_BATCH);
            TestPPLPlugin.class,
        if (idx < 0) {
    private static final TimeValue STRESS_TIMEOUT = TimeValue.timeValueSeconds(60);
        Settings indexSettings = Settings.builder()
            assertTrue(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        int idx = response.getColumns().indexOf("value");
                    channel.sendResponseBatch(new FragmentExecutionArrowResponse(root));
     * and silently coerces them to a single seed-row scalar (one of the
            .setSettings(indexSettings)
    }
            );
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
                    return new long[] { r.getRows().size(), sumValueColumn(r) };
     * S1 — 100 batches of 5k Int32 rows from a single shard. Verifies the
            // and returns immediately — there's NO producer-side back-
        Map<String, AtomicInteger> sentByNode = new HashMap<>();
                out.put(sr.id(), name);
import org.apache.arrow.memory.RootAllocator;
import org.opensearch.cluster.routing.ShardRoutingState;
                    + ceiling,
        // test body should already cover this, but if a body throws before its
    }
     */
 *
            } catch (Throwable ignore) {}
     */
    // finding" in the test report.
                    firstFailure.compareAndSet(null, e.getCause());
    }
     * Asserts a raw (non-aggregating) stress response reflects the coordinator's
import org.apache.arrow.vector.VectorSchemaRoot;
/**
        }
     * Sums the {@code value} column across all rows of {@code response}.
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters(filters = FlightTransportThreadLeakFilter.class)
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
                for (int i = 0; i < batchesPerQuery; i++) {
     * cap (retained rows intact), not all 250k rows sent.
        }
        }, 30, TimeUnit.SECONDS);
        DataFusionService dfs = internalCluster().getInstance(DataFusionService.class, internalCluster().getClusterManagerName());
                } catch (ExecutionException e) {
        createSingleShardIndex();
        return out;
        createSingleShardIndex();
import org.opensearch.be.datafusion.DataFusionPlugin;
        CreateIndexResponse response = client().admin()
            } catch (Throwable t) {
    }
                "Producer allocator high-water exceeded loose bound: high="
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
 *
        return new PluginInfo(
            assertFalse("cancel must not report node failures", cancel.getNodeFailures() != null && !cancel.getNodeFailures().isEmpty());
    // stream batches, native mpsc backpressure, drain thread); the assertions
 * real fragment — and synthesizes a fixed number of Arrow batches by writing
        // Coordinator output cap truncates each query's buffered result.
                mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
            Version.CURRENT,
    }
        }
            PPLResponse response = executePPL("source = " + INDEX_1, STRESS_TIMEOUT);
            .put("index.pluggable.dataformat.enabled", true)
            }
    }
                channel.sendResponse(new RuntimeException("stress S1 producer failed at batch=" + sent.get(), t));
    /**
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
            try {
    @AfterClass
        ExecutorService exec = Executors.newFixedThreadPool(concurrency);
        // the other 2 hang past the 90s per-query bound with their handler
import java.util.HashMap;
                for (int i = 0; i < batches; i++) {
                try {
            .put("index.composite.primary_data_format", "parquet")
import org.opensearch.transport.TransportService;
    // ROWS_PER_BATCH: the coordinator's reduce-side RowProducingSink truncates
            }
        // for native memory accounting and avoids JIT-recompile churn on the
import org.opensearch.be.datafusion.DataFusionService;
 * rows = {@link #VALUE}. Production-side {@code FlightOutboundHandler} takes
        );
        for (Object[] row : response.getRows()) {
        client().admin().indices().prepareRefresh(indexName).get();
                succeeded
        // Service-stubbed handlers. See related single-test-pass behavior:
            try {
                } catch (Throwable ignore) {}
        }, 15, TimeUnit.SECONDS);
     */
        return List.of(
    private static VectorSchemaRoot buildBatch() {
            int succeeded = 0;
        final int concurrency = 1;
     * concurrent 3-shard streaming fan-in, not the final row count.
    }
import java.util.concurrent.ExecutorService;
import org.apache.arrow.vector.IntVector;
     * The stress tests dispatch raw-scan queries ({@code source = idx}) and
    /**
                    assertEquals("S5 query[" + i + "] row-count mismatch", expectedRowsPerQuery, result[0]);
                    + " ceiling="
        assertEquals(tag + " capped row-count mismatch (sent=" + rowsSent + ", cap=" + OUTPUT_ROW_CAP + ")", expectedRows, actualRows);
        AtomicInteger sent = new AtomicInteger();
        return total;
        long before = dfs.getMemoryPoolUsage();
     * rows at the coordinator.
                        try {
                }
    private static long sumValueColumn(PPLResponse response) {
    private void createSingleShardIndex() {
 * The injected handler discards the upstream handler — it does not run the
                    }
        AtomicInteger sent = new AtomicInteger();
            cancelIssued.countDown();
import java.util.concurrent.Executors;
                    totalSent.incrementAndGet();
