            exec.shutdownNow();  
    private static final TimeValue CONCURRENT_TIMEOUT = TimeValue.timeValueSeconds(90);
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
import java.util.concurrent.ExecutorService;
        AtomicInteger sent = new AtomicInteger();
    private static void fillIntVector(IntVector v) {
            mts.clearAllRules();
     * and silently coerces them to a single seed-row scalar (one of the
            assertTrue(  
        // its own channel/stream so we don't share VSR ownership across
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
    private String pickShardHostingNode(String indexName) {
 * sink, exchange-stream wiring, and listener accounting are exercised on a
    // every row sent. ROWS_PER_BATCH=5_000 divides the cap evenly so truncation
        final int batches = 100;
                    producerHighWater.accumulateAndGet(mid, Math::max);
            try {
        String victim = pickShardHostingNode(INDEX_1);  
    private static final long OUTPUT_ROW_CAP = 10_000L;
    /**
 */  
                after <= before + 2L * 1024L * 1024L
    private static final int ROWS_PER_BATCH = 5_000;
    // stream batches, native mpsc backpressure, drain thread); the assertions  
        } finally {
                MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);  
            } catch (Throwable t) {
     */
            .prepareCreate(INDEX_3)  
            }  
            cancelIssued.countDown();
        // Note: sumByNode iterates distinct host nodes — if two shards land
        Map<String, AtomicInteger> sentByNode = new HashMap<>();
                out.put(sr.id(), name);
                    return null;
        assertTrue("create must be acknowledged", response.isAcknowledged());
            .setSettings(indexSettings)
            cancelIssued.countDown();
            // batch bytes for N enqueued batches. This is informational —
    @AfterClass  
            .setMapping("value", "type=integer")
            .put(super.nodeSettings(nodeOrdinal))
                        channel.completeStream();
        if (idx < 0) {  
import org.junit.BeforeClass;  
    private static final Schema BATCH_SCHEMA = new Schema(  
import org.opensearch.common.util.FeatureFlags;
                            return;  
import java.util.concurrent.Future;  
            for (int i = 0; i < concurrency; i++) {
import org.opensearch.composite.CompositeDataFormatPlugin;  
                    VectorSchemaRoot root = buildBatch();  
                .stream()  
 * directly to the {@code TransportChannel}. Each batch is a freshly-allocated  
            Future<PPLResponse> fut = exec.submit(() -> {
            for (Map.Entry<String, AtomicInteger> e : sentByNode.entrySet()) {
        // FlightServerChannel's per-stream executor handoff or
        }, 30, TimeUnit.SECONDS);
                    firstFailure.compareAndSet(null, e.getCause());
    }  
    /**
     * up under sustained per-shard load. The 500k rows sent far exceed the  
    /** 3-shard index for the multi-shard stress variant. */  
        // Confirm 3 distinct nodes (one shard per node typical).  
import org.apache.arrow.vector.types.pojo.Schema;
public class CoordinatorTransportStressIT extends OpenSearchIntegTestCase {
                mts.clearAllRules();  
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
 * @opensearch.internal  
    }
        long beforeProducer = producerAllocator.getAllocatedMemory();
                        for (int i = 0; i < batchesPerShard; i++) {
        final long expectedRowsPerQuery = Math.min(rowsSentPerQuery, OUTPUT_ROW_CAP);
     * verify the per-row payload arrives intact across many streaming
            long after = dfs.getMemoryPoolUsage();
                } catch (Throwable ignore) {}
                    assertEquals("S5 query[" + i + "] sum mismatch", expectedSumPerQuery, result[1]);
        for (int i = 0; i < ROWS_PER_BATCH; i++) {
    public void testCancelMidStressRun() throws Exception {
            .indices()
            .putList("index.composite.secondary_data_formats")
        assertEquals(tag + " retained rows must be intact (sum == rowsKept × VALUE)", actualRows * VALUE, sumValueColumn(response));
            .get();  
        client().admin().indices().prepareRefresh(INDEX_3).get();  
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),  
                    return new long[] { r.getRows().size(), sumValueColumn(r) };
        v.allocateNew(ROWS_PER_BATCH);
                    channel.sendResponse(new RuntimeException("stress S5 producer failed", t));
    // coordinator as raw Int32 row batches and feed the row-collecting sink  
    @After
                total += n.longValue();
        final int batchesPerShard = 50;
    }
            CancelTasksResponse cancel = client().admin().cluster().prepareCancelTasks().setActions(UnifiedPPLExecuteAction.NAME).get();  
    // ROWS_PER_BATCH: the coordinator's reduce-side RowProducingSink truncates
     * Asserts a raw (non-aggregating) stress response reflects the coordinator's
        CreateIndexResponse response = client().admin()
        // Used to slow-down the producer enough that cancel can race in
            // and returns immediately — there's NO producer-side back-  
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
    }
import java.util.List;  
     * cap (retained rows intact), not all 250k rows sent.  
                String name = clusterService().state().nodes().get(nodeId).getName();
            .prepareCreate(indexName)  
import org.opensearch.common.unit.TimeValue;
                    sent.incrementAndGet();
        try {  
        assertEquals(tag + " capped row-count mismatch (sent=" + rowsSent + ", cap=" + OUTPUT_ROW_CAP + ")", expectedRows, actualRows);  
            .setSettings(indexSettings)
import org.opensearch.common.settings.Settings;  
            }
     * raw (non-aggregating) stream of N rows yields {@code min(N, OUTPUT_ROW_CAP)}
        return Settings.builder()  
            if (cell instanceof Number n) {  
                for (int i = 0; i < totalBatches; i++) {  
            .put("index.composite.primary_data_format", "parquet")
        // The handler emits the same shape per request — each invocation gets  
            for (MockTransportService mts : stubbed) {
        Map<Integer, String> out = new HashMap<>();  
                            Thread.currentThread().interrupt();
        }
        AtomicInteger totalSent = new AtomicInteger();
                }
        long expectedRows = Math.min(rowsSent, OUTPUT_ROW_CAP);
        VectorSchemaRoot vsr = VectorSchemaRoot.create(BATCH_SCHEMA, producerAllocator);  
 * the producer must build a fresh root per emission.
            .build();
            exec.awaitTermination(5, TimeUnit.SECONDS);
     * fragment, so the production partial-aggregation pushdown does not run
                        return; // do NOT completeStream — cancel path
        AtomicLong producerHighWater = new AtomicLong();  
        // (node, action) pair sees rapid re-dispatch under MockTransport-
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
                } catch (Throwable ignore) {}
    private void createSingleShardIndex(String indexName) {
            long ceiling = beforeProducer + (long) (batches + 2) * PER_BATCH_BYTES * 4L;
     * rows at the coordinator.
                .map(e -> e.getKey() + ":" + e.getValue().get())
            mts.clearAllRules();  
    }  
    @Override
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)  
     * query streams 15 batches × 5k rows (75k sent), which exceeds the coordinator  
                } catch (ExecutionException e) {
        // (producerAllocator, JIT cache) interacts with the streaming
        }
                }  
            PPLResponse response = executePPL("source = " + INDEX_1, STRESS_TIMEOUT);
            false  
            sentByNode.computeIfAbsent(node, k -> new AtomicInteger());
        AtomicInteger sent = new AtomicInteger();
        return List.of(
    /** Map each primary shard id → node name that currently hosts it. */
                channel.completeStream();
        CountDownLatch hitTen = new CountDownLatch(1);  
import org.apache.arrow.vector.types.pojo.Field;  
    // for queries that do not push a backend-aggregating COORDINATOR_REDUCE  
                    return executePPL("source = " + INDEX_1, STRESS_TIMEOUT);  
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {  
        try {  
        } finally {  
                    int s = sent.incrementAndGet();  
            assertTrue(
    }
        createSingleShardIndex(INDEX_1);  
            null,
            Object cell = row[idx];
 * on the streaming-transport handler for {@code FragmentExecutionAction.NAME}.  
            .put(FeatureFlags.STREAM_TRANSPORT, true)  
            assertFalse("cancel must not report node failures", cancel.getNodeFailures() != null && !cancel.getNodeFailures().isEmpty());
        Map<Integer, String> map = shardToNode(INDEX_3);
            internalCluster().clearDisruptionScheme(true);
                try {  
import org.apache.arrow.vector.types.pojo.ArrowType;
        final int batchesPerQuery = 15;
                concurrency,  
                    + " before="
        try {  
                "All concurrent queries must succeed; failures=" + firstFailure.get() + " totalBatchesSent=" + totalSent.get(),
     * truncates the buffered rows at OUTPUT_ROW_CAP, so the response reflects the
                "Native memory after cancel must be within 2 MiB of baseline; before=" + before + " after=" + after,
                    if (s == cancelAt) {
import java.util.concurrent.TimeUnit;
import java.util.Collections;
 * single hot data-node.  
    }
            }  
     */  
    // (whole-batch) lands deterministically on the cap. See "Coordinator  
        // StreamTransportService's pending-request queue when the same  
        // Pinned to 1 (was 2) to isolate "is the failure transport-layer or analytics-engine?".
        );
                    + ceiling,
            Version.CURRENT,
            // the substantive check is the capped row-count + retained-row
            .put("index.pluggable.dataformat.enabled", true)
    @Override
@TestLogging(reason = "debugging stress behavior", value = "org.opensearch.analytics:DEBUG")  
 * ownership of the supplied root via {@code transferRoot} and closes it, so  
        // dispatch path.  
        });
        if (a != null) {
            List<Future<long[]>> futures = new ArrayList<>();
        assertBusy(() -> {  
                    channel.sendResponseBatch(new FragmentExecutionArrowResponse(root));
        // Coordinator finding: when 4 PPL queries concurrently dispatch  
                    PPLResponse r = executePPL("source = " + INDEX_1, CONCURRENT_TIMEOUT);
 * <p>Each test installs a {@link MockTransportService#addRequestHandlingBehavior}
            }
        // reproduce the hang, so JVM-static state from prior tests
        final long rowsSent = (long) ROWS_PER_BATCH * batches;
import org.opensearch.ppl.TestPPLPlugin;
import java.util.concurrent.CountDownLatch;
        // separate item. Likely cause: a head-of-line block in either
import org.opensearch.transport.TransportService;  
                }  
    }  
    }
        return List.of(  
        // requests.
        final int totalBatches = 100;  
                channel.completeStream();
            .put("index.composite.primary_data_format", "parquet")
import java.util.concurrent.atomic.AtomicLong;  
            }
                    channel.sendResponseBatch(new FragmentExecutionArrowResponse(root));
            "1.8",
        try {
            PPLResponse response = executePPL("source = " + INDEX_3, STRESS_TIMEOUT);
                    totalSent.incrementAndGet();
            .build();  
        return shardToNode(indexName).values().iterator().next();  
        // deterministically with concurrency=4 across multiple seeds. We
        } finally {  
                            VectorSchemaRoot root = buildBatch();  
                            cancelIssued.await(5, TimeUnit.SECONDS);  
    private static final String INDEX_3 = "stress_idx_3";
 * The OpenSearch Contributors require contributions made to  
            } catch (Exception ignore) {}
                    + producerHighWater.get()
                    + beforeProducer  
            } catch (Throwable t) {
    }  
        createSingleShardIndex();  
        }
     * producer-side allocator high-water bounded. The coordinator output sink then
import java.util.concurrent.Executors;
     * assert all {@code rowsSent} rows survive: {@code RowProducingSink} caps  
     * output truncation: the row count is {@code min(rowsSent, OUTPUT_ROW_CAP)},  
        AtomicInteger sent = new AtomicInteger();
     */
        // test body should already cover this, but if a body throws before its
                channel.completeStream();
            // The producer allocator high-water reflects how many in-flight  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
    // finding" in the test report.
        // 2 × batchesPerQuery on suite runs). This was reproduced  
        client().prepareIndex(indexName).setSource("value", VALUE).get();  
    }
import java.util.ArrayList;
     * the summed column equals {@code rowsKept × VALUE}. We deliberately do NOT
     * coordinator surfaces cancellation, native memory pool returns to within
    }
     */
        assertBusy(() -> {
 *
     * deliver every batch to the coordinator (no transport-level loss) and keep the  
        final int cancelAt = 10;
        }  
            "classpath plugin",
            mts.clearAllRules();
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
    }  
import org.opensearch.cluster.metadata.IndexMetadata;  
                channel.completeStream();
import org.apache.arrow.memory.RootAllocator;
        v.setValueCount(ROWS_PER_BATCH);
        DataFusionService dfs = internalCluster().getInstance(DataFusionService.class, internalCluster().getClusterManagerName());  
        ExecutorService exec = Executors.newFixedThreadPool(concurrency);
        createSingleShardIndex();
            ListTasksResponse remaining = client().admin().cluster().prepareListTasks().setActions(FragmentExecutionAction.NAME).get();
        client().admin().indices().prepareRefresh(indexName).get();
    }  
        // (single-shard index → all 4 land on the same node), only 2 of 4
    private static final String INDEX_1 = "stress_idx_1";
import org.opensearch.cluster.routing.ShardRoutingState;
 *
            }  
        for (int i = 0; i < 9; i++) {  
                    succeeded++;  
    public static void initProducerAllocator() {
        // never invoked at all (zero batches sent, totalSent reflects only
import java.util.concurrent.atomic.AtomicReference;
    public void testCoordinatorHandlesHundredBatchesFromOneShard() throws Exception {
        List.of(new Field("value", new FieldType(true, new ArrowType.Int(32, true), null), Collections.emptyList()))
        );
            try {  
/*  
            .indices()
                            counter.incrementAndGet();
            String sentReport = sentByNode.entrySet()
        }
        long rowsSent = (long) ROWS_PER_BATCH * batchesPerShard * map.size();  
                channel.sendResponse(new RuntimeException("stress S1 producer failed at batch=" + sent.get(), t));  
     * result is truncated to OUTPUT_ROW_CAP rows with the retained rows intact.
        // 2 (or higher) once the streaming-dispatch hazard is fixed.
    protected Settings nodeSettings(int nodeOrdinal) {
     * {@code RowProducingSink.DEFAULT_MAX_ROWS}. The row-collecting sink truncates
     * S5 — concurrent stress queries against the same single-shard index. Each
import java.util.stream.Collectors;
                try {  
import org.junit.After;
    public void testBackPressureDoesNotDropBatches() throws Exception {
        // behaviors via addRequestHandlingBehavior; mts.clearAllRules() in the
        // Coordinator output cap truncates each query's buffered result.  
 * real fragment — and synthesizes a fixed number of Arrow batches by writing
import org.apache.arrow.vector.VectorSchemaRoot;
                try {
     */
        final long rowsSent = (long) ROWS_PER_BATCH * batches;
        // finally runs we still want a clean state for the next test.  
    // bypasses the production partial-aggregation path — they arrive at the
import org.opensearch.analytics.AnalyticsPlugin;
                succeeded
                    }
    private static final int VALUE = 7;  
        final int concurrency = 1;  
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
                } catch (Throwable t) {  
            mts.clearAllRules();
import java.util.HashMap;
/**
    @BeforeClass
    private static final TimeValue STRESS_TIMEOUT = TimeValue.timeValueSeconds(60);  
    /**
}
import org.opensearch.test.transport.MockTransportService;
     * output cap, so each independent client-side future verifies the per-query
            List<TaskInfo> infos = remaining.getTasks();
                }));  
            assertTrue("No fragment tasks should linger after cancel: " + infos, infos.isEmpty());  
import org.junit.AfterClass;
    }
        ExecutorService exec = Executors.newSingleThreadExecutor();
        createThreeShardIndex();  
        return vsr;  
                mts.clearAllRules();
                    channel.sendResponse(new RuntimeException("stress S4 producer failed at batch=" + sent.get(), t));
                        channel.sendResponse(new RuntimeException("stress S2 producer failed on " + node, t));  
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
                    assertEquals("S5 query[" + i + "] row-count mismatch", expectedRowsPerQuery, result[0]);
        } finally {
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet(timeout);
    private void createThreeShardIndex() {
        }
                        }
            }
        BufferAllocator a = producerAllocator;
            client().prepareIndex(INDEX_3).setSource("value", VALUE).get();
     * The stress tests dispatch raw-scan queries ({@code source = idx}) and
     * S3 — Cancel mid-stream after ~10 batches delivered. Data-node handler stops,  
 */
        // pin concurrency=2 here so the test asserts a stable contract;
                mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {  
        // Native memory pool returns to within 2 MiB of baseline.  
            int succeeded = 0;  
        // Defensively clear stubs on every node — each test installs handler  
                    if (task instanceof org.opensearch.tasks.CancellableTask ct && ct.isCancelled()) {
        // between batches. Releasable when test thread has issued cancel.
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
     * OUTPUT_ROW_CAP rows (retained rows intact); the stress value is the
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        // FlightServerChannel/StreamTransportService), not in analytics-engine. Restore to
 * SPDX-License-Identifier: Apache-2.0
            try {  
        }
        } finally {  
     * coordinator's reduce sink + native mpsc backpressure + drain-thread keep
            try {
        final int batches = 50;
                String node = e.getKey();
import org.opensearch.ppl.action.PPLResponse;  
    // stage. The synthetic batches we emit here come from a stub handler that
        String victim = pickShardHostingNode(INDEX_1);  
        }
        client().admin().indices().prepareFlush(indexName).get();
import org.opensearch.Version;  
    );
    /**
        long total = 0;  
        fillIntVector(v);  
    /** Per-batch native bytes ≈ 5_000 × 4 (Int32 data) + bitmap. */
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
                "Producer allocator high-water exceeded loose bound: high="  
                    long[] result = futures.get(i).get(CONCURRENT_TIMEOUT.seconds(), TimeUnit.SECONDS);  
     * S2 — 3-shard variant: 50 batches × 5k rows per shard. The combined stream  
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
            exec.awaitTermination(5, TimeUnit.SECONDS);  
        ensureGreen(INDEX_3);
                        hitTen.countDown();
    protected Collection<PluginInfo> additionalNodePlugins() {
    /**
            );
            AtomicReference<Throwable> firstFailure = new AtomicReference<>();
        String victim = pickShardHostingNode(INDEX_1);  
     * round-trips, not the final row count.  
        IntVector v = (IntVector) vsr.getVector(0);
        long actualRows = response.getRows().size();
        return new PluginInfo(  
            ArrowBasePlugin.class,
        });
                        // Block until cancel is issued (or 5s passes) so cancellation  
        });
        vsr.setRowCount(ROWS_PER_BATCH);
import org.opensearch.ppl.action.PPLRequest;
            try {
        // Pre-size to avoid reAlloc churn inside setValueCount → cleaner
     * Sums the {@code value} column across all rows of {@code response}.  
        producerAllocator = new RootAllocator(Long.MAX_VALUE);  
                    } catch (Throwable t) {
                    VectorSchemaRoot root = buildBatch();  
        client().admin().indices().prepareFlush(INDEX_3).get();
        final long rowsSentPerQuery = (long) ROWS_PER_BATCH * batchesPerQuery;
        // expanding to 4 once the streaming fan-out hang is fixed is a  
    /**  
     * S4 — Backpressure: producer emits fast (no sleeps). The transport path must
            assertCappedResult("S1 (sent=" + sent.get() + ")", rowsSent, response);
     * concurrent 3-shard streaming fan-in, not the final row count.  
        } catch (IllegalStateException ignore) {}  
                fut.get(STRESS_TIMEOUT.seconds(), TimeUnit.SECONDS);
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {  
     */  
 * compatible open source license.
                }  
                AtomicInteger counter = e.getValue();  
        // request (one per shard), still emitting batchesPerShard batches per
                    }  
                try {
        // No residual fragment tasks.
                        } catch (InterruptedException ie) {
            throw new AssertionError("expected column 'value' in response columns=" + response.getColumns());
        return out;
                stubbed.add(mts);
 * The injected handler discards the upstream handler — it does not run the
        return total;
            .put("index.pluggable.dataformat", "composite")  
            // pressure on the unbatched send path. In practice the producer
    /**  
 * side {@link FragmentExecutionAction} handler so the coordinator's reduce
    }  
import java.util.Map;
 *
                for (int i = 0; i < batchesPerQuery; i++) {
            // integrity asserted above.  
                    try {
    private void createSingleShardIndex() {
     * exceeds the coordinator output cap, so the result is truncated to
    /** Extracted filler — kept out of {@link #buildBatch} so JIT compiles them independently. */  
    private static void assertCappedResult(String tag, long rowsSent, PPLResponse response) {  
    }
            }
     * {@code | stats sum(value)} because the stub bypasses the data-node
    }
            for (int i = 0; i < concurrency; i++) {
            assertEquals(
            v.set(i, VALUE);  
        final long expectedSumPerQuery = expectedRowsPerQuery * VALUE;
            );  
     * (with the retained rows intact); the stress value is the 100 streamed
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
        try {  
     * and the coordinator's FINAL aggregate stage receives the raw batches  
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
        try {  
        }
        CountDownLatch cancelIssued = new CountDownLatch(1);  
                } catch (Throwable ignore) {}  
                for (int i = 0; i < batches; i++) {
                    + " ceiling="
            extendedPlugins,
     */  
            .put("index.pluggable.dataformat", "composite")  
                    channel.sendResponse(new RuntimeException("stress S3 producer failed at batch=" + sent.get(), t));
                } catch (Throwable t) {
import org.apache.arrow.vector.types.pojo.FieldType;
    public static void releaseProducerAllocator() {
    private static long sumValueColumn(PPLResponse response) {
import java.util.concurrent.atomic.AtomicInteger;
            // .sendResponseBatch enqueues to FlightOutboundHandler's executor
                }
import org.opensearch.tasks.TaskInfo;
    // directly, so the sink caps the result. These tests intentionally send far
            "NA",  
        // running this test alone (without S1–S4 preceding) does NOT  
import org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse;  
    /**
     * ~2 MB of pre-query baseline.
import org.apache.arrow.memory.BufferAllocator;
        // the other 2 hang past the 90s per-query bound with their handler
            .setMapping("value", "type=integer")
        );
                        }  
        Settings indexSettings = Settings.builder()
                a.close();  
        assertEquals("expected 3 primary shards", 3, map.size());
                    sent.incrementAndGet();  
                            channel.sendResponseBatch(new FragmentExecutionArrowResponse(root));
            });
    private Map<Integer, String> shardToNode(String indexName) {
            // first, so the bound here is loose: high-water ≤ (N+1) × per-  
import org.opensearch.cluster.routing.ShardRouting;
            CompositeDataFormatPlugin.class,
            }  
 * {@link VectorSchemaRoot} with one Int32 column {@code value} of {@code N}
                        // races with the producer rather than racing past it.
        for (String node : map.values()) {  
                    }
            }  
        for (Object[] row : response.getRows()) {
     * buffered output, and these tests stress the transport path well past that cap.
            );
import java.util.Collection;  
        }
    // more than the cap to stress the streaming transport path (many round-trip
    // buffered output at OUTPUT_ROW_CAP rows (RowProducingSink.DEFAULT_MAX_ROWS)
        });
    private static VectorSchemaRoot buildBatch() {
                for (int i = 0; i < batches; i++) {
import org.opensearch.test.junit.annotations.TestLogging;
     * coordinator-finding behaviors recorded for these tests).
                    long mid = producerAllocator.getAllocatedMemory();  
                    VectorSchemaRoot root = buildBatch();
        for (ShardRouting sr : clusterService().state().routingTable().index(indexName).shardsWithState(ShardRoutingState.STARTED)) {
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
    public void testConcurrentStressRuns() throws Exception {
import java.util.concurrent.ExecutionException;  
        }, 15, TimeUnit.SECONDS);
     * S1 — 100 batches of 5k Int32 rows from a single shard. Verifies the
import org.opensearch.be.datafusion.DataFusionPlugin;  
                producerHighWater.get() <= ceiling  
            TestPPLPlugin.class,  
            try {
            } catch (Exception ignore) {}
        // for native memory accounting and avoids JIT-recompile churn on the  
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
 * this file be licensed under the Apache-2.0 license or a
    /** Build a fresh VSR with {@link #ROWS_PER_BATCH} rows of constant {@link #VALUE}. */
            MockCommitterEnginePlugin.class  
            pluginClass.getName(),  
            pluginClass.getName(),
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        createSingleShardIndex();  
            } catch (Throwable t) {
                .collect(Collectors.joining(","));
                    channel.sendResponseBatch(new FragmentExecutionArrowResponse(root));
                }  
import org.opensearch.plugins.Plugin;
import org.opensearch.test.OpenSearchIntegTestCase;  
import org.opensearch.plugins.PluginInfo;  
     * coordinator output cap, so the result is truncated to OUTPUT_ROW_CAP rows
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            assertCappedResult("S4 (sent=" + sent.get() + ")", rowsSent, response);
                        try {
            .build();  
        createSingleShardIndex();
    private static volatile BufferAllocator producerAllocator;
    private PPLResponse executePPL(String ppl, TimeValue timeout) {
    }
 * many batches of pre-built {@link VectorSchemaRoot}s through the data-node  
            // VSRs the producer holds at any one time. FlightTransportChannel
                try {
     * Coordinator output cap — mirrors the package-private
        // shard. Use shard-count for arithmetic, not host-node count.
 * Transport-level stress suite for the analytics-engine coordinator. Pushes
    }
            } catch (Throwable t) {  
     * buffered output at this many rows (whole batches dropped once reached), so a  
            assertCappedResult("S2 (sent=" + sentReport + ")", rowsSent, response);  
    public void testCoordinatorHandlesBatchesAcrossAllThreeShards() throws Exception {
            } catch (Throwable ignore) {}
                futures.add(exec.submit(() -> {  
        // If the test passes deterministically at concurrency=1, the row-loss seen at >=2
    }
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
            assertTrue("Producer must reach " + cancelAt + " batches", hitTen.await(STRESS_TIMEOUT.seconds(), TimeUnit.SECONDS));
        }
    /** Single-shard index seeded with one row so the cluster is ready for stub injection. */  
        CreateIndexResponse response = client().admin()
                MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
        assertTrue("create must be acknowledged", response.isAcknowledged());
    // therefore expect the capped output (min(sent, OUTPUT_ROW_CAP)) rather than
import org.apache.arrow.vector.IntVector;  
        String victim = pickShardHostingNode(INDEX_1);  
        }
        long before = dfs.getMemoryPoolUsage();
            exec.shutdownNow();
            MockTransportService.TestPlugin.class,
        // on the same node, the stub fires once per FragmentExecutionAction  
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters(filters = FlightTransportThreadLeakFilter.class)
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 3, numClientNodes = 0, supportsDedicatedMasters = false)
            PPLResponse response = executePPL("source = " + INDEX_1, STRESS_TIMEOUT);
            // can allocate all N batches before the serializer drains the
        List<MockTransportService> stubbed = new ArrayList<>();
            try {
        ensureGreen(indexName);
    }
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
import org.opensearch.be.datafusion.DataFusionService;
    public void clearStubs() {
package org.opensearch.analytics.resilience;
    @Override
     * and the retained rows are intact — every kept row carries {@link #VALUE}, so
        producerAllocator = null;  
     * batches. We sum at the test side rather than relying on  
    /** Long-lived producer allocator: shared across tests, cleaned in {@link #releaseProducerAllocator()}. */  
        for (String node : internalCluster().getNodeNames()) {
        // FragmentExecutionAction streaming requests to the same data-node
     */  
 * rows = {@link #VALUE}. Production-side {@code FlightOutboundHandler} takes
                });
        // grow path inside Arrow's BaseFixedWidthVector.reAlloc.
        }  
    private static final long PER_BATCH_BYTES = ROWS_PER_BATCH * 4L + 8 * 1024L;
            .putList("index.composite.secondary_data_formats")
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        int idx = response.getColumns().indexOf("value");
                    firstFailure.compareAndSet(null, t);
        // Service-stubbed handlers. See related single-test-pass behavior:
            if (sr.primary()) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // is in concurrent streaming dispatch (head-of-line block in  
        Settings indexSettings = Settings.builder()
            .put("index.pluggable.dataformat.enabled", true)
                    VectorSchemaRoot root = buildBatch();
        // streaming handlers fire reliably under suite-scope concurrency —  
                String nodeId = sr.currentNodeId();  
                    channel.sendResponseBatch(new FragmentExecutionArrowResponse(root));
            .get();  
