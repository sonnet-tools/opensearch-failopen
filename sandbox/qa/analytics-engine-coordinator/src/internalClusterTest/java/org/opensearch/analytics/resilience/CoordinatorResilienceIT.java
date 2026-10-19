     * Sort buffers travel through the reduce; if the merge step fails to
 * <p><b>Streaming transport enabled.</b> Production runs streaming, and so
    }
            );
            "Plan failure must not leak fragment tasks: before=" + beforeCount + " after=" + after.getTasks().size(),
            client().admin().indices().prepareDelete(INDEX).get();
        assertScalarLong(r, "total", EXPECTED_SUM);  
            // recording the observed behavior. The assertion above ensures 'no hang'.
        AtomicInteger stubCalls = new AtomicInteger();
            .setMapping("value", "type=integer")
    /**
                after <= before + 1024 * 1024  
            assertFalse("cancel must not report node failures", cancel.getNodeFailures() != null && !cancel.getNodeFailures().isEmpty());
import org.opensearch.common.unit.TimeValue;
            Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total"));
            if (prev != null) {
    /**
        // Crank limit down before indexing so the query's native state can't fit.  
        assertTrue("response must contain column " + column, idx >= 0);
        // regardless of which one ends up coordinating.
        String victim = pickShardHostingNode();
            for (Map.Entry<String, StageExecutionFactory> e : previousByNode.entrySet()) {
                failCount.incrementAndGet();  
    public void testTopologyDedicatedClientNode() throws Exception {
            public void onResponse(PPLResponse r) {
            VectorSchemaRoot vsr = VectorSchemaRoot.create(schema, stubAllocator);
    public void testStubReplacesStreamingShardResponseWithEmptyBatch() throws Exception {
        StageExecutionFactory faulting = (stage, sink, config) -> {
    // Total distinct doc ids indexed (with 3 shards and default routing, approximate per-shard count only).
                released.await(delaySeconds, TimeUnit.SECONDS);
     */  
            assertEquals("cancelled query must produce exactly one onFailure", 1, fail.get());  
            // No scheme set — fine.
                "stage must fail-fast on first failure and not wait for the blocked sibling — elapsed=" + elapsedSec
                // Cancellation not propagated — assertion below pins that. Some codepaths
            }  
    }  
            } catch (Throwable ignore) {}
import org.opensearch.analytics.exec.stage.StageExecutionFactory;  
            faultCount.incrementAndGet();
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
            // to the parent stage is a separate cascade concern). What we forbid is  
    }
        } finally {
        NetworkDisruption disruption = new NetworkDisruption(  
        PPLResponse r = executePPL("source = " + SINGLE_SHARD_INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
            // Restore — even on failure, leaving a faulting scheduler in
        } catch (Exception ignore) {}
     *  
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet(timeout);
     * #22 — Contract under test: when planning fails after a successful transport  
    }
     * LocalStageExecutionFactory nor DatafusionReduceSink is on the hot path.
        // search/coordinator resilience, not ingestion — they need a stable post-seed  
        long delaySeconds = QUERY_TIMEOUT.seconds();
            delayMts.clearAllRules();
        assertBusy(() -> {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            } catch (Throwable t) {
        for (ShardRouting sr : clusterService().state()
            logger.info(
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));  
            assertThat(  
            new NetworkDisruption.Bridge(bridge, sideOne, sideTwo),  
            System.gc();
            StageExecutionBuilder b = internalCluster().getInstance(QueryScheduler.class, node).getStageExecutionBuilder();  
                        injected.set(true);
    /**  
        createAndSeedIndex();
        String coord = coordinatorNodeName();
            Throwable cause = cur.getCause();  
     * child) must not leak; the build-failure path must surface the cause
    // | single aggregation                 | N partial → 1 final REDUCE                |
 * {@link org.opensearch.analytics.exec.stage.shard.ShardFragmentStageExecutionFactory}).
     * {@code datafusion.indexed.batch_size=10} and 50 docs in one shard, the  
            // the reduce-side session is allocated. Tight enough that we  
     * #15 — Workload driver for failure-path leak detection. Runs 50 failing
            Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
     * the cross-shard merge. With 3 shards, {@code head 5} returns 15 rows
    /**  
    /**  
     * 3-shard parquet cold-start). Asserts the native memory pool's end usage  
                failure.set(t);  
     * #21 — Malformed PPL (references a nonexistent field). Coordinator must fail
            disruption.stopDisrupting();
        for (int i = 0; i < docs; i++) {  
            assertNotNull("coordinator must produce a response when one shard is empty", response);
    //  
                            }
    public void testSortWithPushdownReleasesBufferOnSuccess() throws Exception {
        delayMts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {  
            handler.messageReceived(request, channel, task);  
    // ----------------------------------------------- C: reduce-stage / concurrency  
            );  
        assertNotNull(column + " cell must not be null", cell);
     * DAG: N partial-sort SHARD_FRAGMENT → 1 merge-sort COORDINATOR_REDUCE.
    public void testStageBuildFailureReleasesEarlierStages() throws Exception {
        String coord = coordinatorNodeName();
            failMts.clearAllRules();
        // Warm-up: prime native pools / JIT so the baseline reflects steady state.
     * #23 — Inject a failure during stage build so earlier stages are
     */
                memAfter <= memBaseline + 1024 * 1024
                };
 *   <li>B. Application-layer shard failures injected via
     * #10 — Cancel the parent (coordinator-level) task during the dispatch phase
        // cleanup in PlanWalker.build() cancels every already-built stage,  
                Thread.sleep(50);  
    public void testStageFailureDoesNotLeakAllocator() throws Exception {
        try {
            ArrowBasePlugin.class,
        String idxDelay = "sibling_leg_delay";
            Thread.sleep(300);
     * closing the reduce sink — leaving the drain task importing batches
     */
    }
        PPLResponse healed = executePPL("source = " + INDEX + " | stats sum(value) as total");
        } finally {
            appender.addExpectation(new MockLogAppender.UnseenEventExpectation(
                    int n = batchCount.incrementAndGet();  
        NetworkDisruption disruption = new NetworkDisruption(
                fail2.incrementAndGet();
        throw new AssertionError("no node other than " + name + " in cluster: " + List.of(internalCluster().getNodeNames()));
                failure = t;
            .putList("index.composite.secondary_data_formats")
            try {  
        } catch (Exception ignore) {}  
        String victim = pickShardHostingNode();  
            .put("index.pluggable.dataformat", "composite")  
            assertThat("Partial sum must be ≥ 0 given the other two shards' contribution", actual, greaterThan(-1L));
                        if (response instanceof org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse arrow) {
                private boolean schemaForwarded = false;  
            channel.sendResponse(new IllegalStateException("listener-race-injection"));  
    public void closeStubAllocator() {
        String delayNode = nodes[1];
        assertTrue("need ≥3 nodes for bridge topology", allNodes.size() >= 3);
            new NetworkDisruption.TwoPartitions(Collections.singleton(coord), Collections.singleton(victim)),
    /**
        for (int i = 0; i < n; i++) {
        try {
            assertTrue(  
    /**
    @Before
import org.apache.logging.log4j.LogManager;  
                    + response.get()
                queue.add(cause);
    private String pickShardHostingNode() {  
                + " | append [ source = " + INDEX + " | stats count() as cnt ]"
     * <p>The seam is the existing {@link StageExecutionBuilder#registerFactory}  
        Object cell = response.getRows().get(0)[idx];  
            exec.awaitTermination(5, TimeUnit.SECONDS);
        assertScalarLong(healed, "total", EXPECTED_SUM);  
    public void testMultiInputUnionReleasesBufferOnSuccess() throws Exception {  
                }  
import org.opensearch.plugins.PluginInfo;
        try {
        AtomicInteger ok = new AtomicInteger();
     * partial-build cleanup, the listener sees the original cause.  
        String victim = singleShardHostingNode(SINGLE_SHARD_INDEX);  
 *   <li>D. Shutdown-restart flavor — coordinator/data-node crash recovery.</li>
            AtomicReference<PPLResponse> response = new AtomicReference<>();
     */  
     * query-shape probe in the {@code testXxxReleasesBufferOnSuccess} family —
        AtomicInteger faultCount = new AtomicInteger();
        } catch (IllegalStateException ignore) {
            assertTrue(
            );
            inFlight.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
                memAfter <= memBaseline + 1024 * 1024
    }
    }
                return clusterService().state().nodes().get(sr.currentNodeId()).getName();
            });  
     * then a child {@code SHARD_FRAGMENT} build throws — at which point the  
        // Dispatch through the coordinating-only node specifically.
     * Within-stage fast-fail contract: when one shard task in a stage throws and a
    }
            } catch (InterruptedException ie) {  
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
            // system property from this node setting, clobbering the -D VM arg. Turn
            }
    /**
     * the planner / orchestrator). Deferred: there is no public fault seam or
    // ---------------------------------------------------------------- fixture  
                public void onFailure(Exception e) { failure.set(e); fail.incrementAndGet(); }
    public void testMultiShardScanNoReduceReleasesBufferOnSuccess() throws Exception {
    private static final int DOCS_PER_SHARD_TARGET = 10;  
                    UnifiedPPLExecuteAction.INSTANCE,  
            assertTrue("Bridge partition must surface a response or an error (no hang)", response.get() != null || failure.get() != null);  
        if (stubAllocator != null) {
        assertNotNull("need a second shard-host node for the delayed sibling", delayNode);
    public void testCoordinatorMemoryStablesAcrossManyQueries() throws Exception {  
            // Wrap the streaming channel: let the real handler run, but substitute its row
        client().admin()
                ((MockTransportService) internalCluster().getInstance(TransportService.class, node)).clearAllRules();
            client().prepareIndex(name).setSource("value", VALUE).get();
        assertNoLeakOnSuccess("source = " + INDEX + " | stats sum(value) as total");
        );
            failure = t;
 *       unresponsive, delay, intermittent, bridge, mid-query node drops).</li>  
    public void testCoordinatorSurvivesSlowShard() throws Exception {
        } finally {  
        long baseline = dfs.getMemoryPoolUsage();
            );
                UnifiedPPLExecuteAction.INSTANCE,
                    + thrown.get()  
     * <p>Uses the same {@link StageExecutionBuilder#registerFactory} seam
            client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest("source = " + SINGLE_SHARD_INDEX + " | stats sum(value) as total"), new ActionListener<PPLResponse>() {
            } catch (Throwable t) {
     */
                String nodeId = sr.currentNodeId();  
        }
                int idx = response.get().getColumns().indexOf("total");
 *
                };
        Set<String> allNodes = new HashSet<>(List.of(internalCluster().getNodeNames()));  
            .setSettings(indexSettings)
    public void testHeadEarlyTerminationReleasesBufferOnSuccess() throws Exception {
    // | limit / head (early termination)   | N SHARD_FRAGMENT w/ early termination     |  
    }
        Logger reduceSinkLogger = LogManager.getLogger("org.opensearch.be.datafusion.DatafusionReduceSink");  
            }  
     * point differs.
            exec.awaitTermination(5, TimeUnit.SECONDS);
    private void createSingleShardIndexOnNode(String name, int docs, String nodeName) {  
        try {  
                "query must either return or fail within " + QUERY_TIMEOUT + "; got null response and null failure → coordinator hung",
        assertEquals("LIMIT must produce exactly the requested row count", 5, r.getRows().size());
            assertEquals("single-shard failure must not also produce onResponse", 0, ok.get());  
    }  
                }  
    private void ensureFullyConnected() throws Exception {  
            } catch (ExecutionException | TimeoutException ignore) {  
     * #28 — Mid-stream batch exception. Cleanly returns 3 batches, then 4th throws.
    public void testReduceStageExceedsMemoryLimit() throws Exception {
     */
            .put(NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.getKey(), "2s")  
     */
        AtomicInteger fail = new AtomicInteger();  
    public void testEmptyResultReleasesBufferOnSuccess() throws Exception {
            };  
            int failed = 0;
     *
        // already stopped it, but this guards against assertion failures aborting  
    /**
                b.registerFactory(StageExecutionType.SHARD_FRAGMENT, e.getValue());
                                } catch (Exception ignore) {}
    }
        return sb.toString();  
 * {@code addRequestHandlingBehavior} is wired to consult both the regular
        );
     */
            } catch (Throwable t) {
        for (String node : internalCluster().getNodeNames()) {
        // Either fast failure (preferred) or partial result with reduced sum.
                    wrongResult = true;
            assertTrue(
        // Special case: tiny / zero baseline. Use absolute-only to avoid 1.10 × 0 = 0.  
        try {  
import org.opensearch.test.junit.annotations.TestLogging;
import org.apache.arrow.vector.VectorSchemaRoot;
            long[] ids = mxBean.findDeadlockedThreads();
            throw new AssertionError("createSingleShardIndex: timed out waiting for seed durability", e);
     */
                    }
                released.await(siblingDelaySeconds, TimeUnit.SECONDS);  
                public void onResponse(PPLResponse pplResponse) { ok.incrementAndGet(); }  
    // user sees IllegalStateException("Memory was leaked: ..."). The matrix
        Set<String> sideOne = new HashSet<>();
            else sideTwo.add(n);  
            .put("index.pluggable.dataformat", "composite")  
                released.await(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);  
            mts.clearAllRules();  
 *       {@link MockTransportService#addRequestHandlingBehavior}
import java.lang.management.ManagementFactory;  
                Thread.currentThread().interrupt();
        });
            assertEquals("single-shard failure must surface as exactly one onFailure", 1, fail.get());
                "Failed to create exchange sink for stageId=" + stage.getStageId(),
        AtomicReference<Throwable> failure = new AtomicReference<>();  
            channel.sendResponse(new RuntimeException("injected sibling leg failure"));
    // | multi-input union (append)         | M REDUCE_TREE → 1 union REDUCE            |
     * #1 — Disconnect coordinator from one shard-hosting node mid-query.
        AtomicReference<Throwable> failure = new AtomicReference<>();  
 * a behavior on {@link FragmentExecutionAction#NAME} works regardless of
        assertBusy(() -> {  
            } catch (Throwable t) {
            ));
        ensureGreen(name);
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {  
     */
    public void testMidStreamConnectionDropOneShard() throws Exception {  
     * contribute zero rows.
            } catch (ExecutionException | TimeoutException ignore) {}
                failure.get() == null ? "null" : failure.get().getClass().getSimpleName()
        assertBusy(() -> assertEquals(1, ok2.get() + fail2.get()), QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
        String victim = pickShardHostingNode();  
        try {
     * propagation logic exercised at the transport layer by
            okListener  
        for (ThreadInfo info : tmx.dumpAllThreads(true, true)) {  
                // Either the query was cancelled mid-flight (preferred — the
        // Post-recovery sanity check.
                // Accept non-zero baseline (runtime overhead), require that we don't leak.  
    public void testEarlyTerminationLimitSingleShardMultiBatch() throws Exception {
        deadlockWatchdog.scheduleAtFixedRate(() -> {  
            // Hold the shard-side request until released.
        );
        try {
    // | multi-shard scan (no reduce)       | N SHARD_FRAGMENT → LOCAL_PASSTHROUGH      |
     */
     * Distinct from {@link #testScanNoReduceReleasesBufferOnSuccess} in that
        try {
            assertTrue(  
            Future<PPLResponse> fut = exec.submit(() -> {
 * <p>Explicitly parquet-only: no Lucene backend installed. Tests run against a
                    @Override  
 * which path the analytics dispatcher uses.
     * (root, allocates a native session via {@code ExchangeSinkProvider.createSink}),
     * Flight handler always sends ≥1 schema-bearing frame before completeStream — the empty-shard
                try {  
        AtomicInteger failCount = new AtomicInteger();  
    private void createSingleShardIndex(String name, int docs) {
     * Early-termination via LIMIT within a single shard's stream. With
     * <p>Production data-node iterator ({@code DatafusionResultStream.BatchIterator}) yields  
    /**
                };
     * coordinator does today (complete-success, partial, fail-fast).
    }
    public void testSingleShardShardFailureSurfaced() throws Exception {
        assertNoPendingFragmentTasks();
                    + batchCount.get(),
        String victim = firstNonMatching(coord);
        );  
            System.gc();
                assertEquals("query must fail (one shard injected error); ok=" + ok.get(), 1, fail.get());
            released.countDown();
import java.util.Set;
            assertBusy(() -> assertEquals(1, ok.get() + fail.get()), QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);  
            channel.sendResponseBatch(  
    /**
     * data-node fragment but does not re-apply a coordinator-side LIMIT after  
                    ok.incrementAndGet();
        @Override
            assertThat("stub must fire on the streaming-only fragment action", stubCalls.get(), greaterThan(0));
                public void onResponse(PPLResponse r) {
            long memAfter = dfs.getMemoryPoolUsage();
                handleAfter <= handleBaseline
            // Let dispatch get out, then disrupt mid-stream.  
            assertTrue(
        // injection only fires on the regular-transport fallback. Either way,
            channel.sendResponse(new IllegalStateException("single-shard injected failure"));
        client().admin().indices().prepareFlush(name).get();
            PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
            });
            .get();
            handler.messageReceived(request, channel, task);
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        });
    }  
        }  
            pluginClass.getName(),  
                        + " | append [ source = " + idxDelay + " | stats count() as cnt ]",  
     * Shape: head/limit with early termination.
                executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
        String victim = firstNonMatching(coordinatorNodeName());
            assertNotNull("coordinator must produce a response when one shard contributes nothing", response);
        ExecutorService exec = Executors.newSingleThreadExecutor();
/*  
                    Thread.sleep(50);
        }, 30, TimeUnit.SECONDS);
            }
     * Verifies the coordinator either rejects or returns a partial result — pins
    /**
        } finally {  
     * #17 — Assert the coordinator's Arrow allocator returns to baseline after
    }
        );
     * Walks {@code t}'s cause + suppressed graph looking for Arrow's "Memory was leaked"  
    }
     * little longer (their batches get dropped on the coordinator side), but  
                1,
     * does not drift more than max(5 MiB, 10%) above baseline.
        // Native memory pool returns to baseline.
            }  
import org.opensearch.analytics.backend.jni.NativeHandle;
            @Override  
            long elapsedSec = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startNs);
        }
        try (MockLogAppender appender = MockLogAppender.createForLoggers(reduceSinkLogger)) {
            // completeStream — subsequent batches are dropped.
        org.apache.arrow.vector.types.pojo.Schema schema = new org.apache.arrow.vector.types.pojo.Schema(
     * brief disruption window before the kill still exposes the coordinator  
                .prepareUpdateSettings()
                    "source = " + idxFail + " | stats sum(value) as total"
            disruption.startDisrupting();
     * {@link #testTaskCancellationAtCoordinator} (#10), which uses a held latch to
import java.lang.management.ThreadInfo;
            long startNs = System.nanoTime();  
        int beforeCount = before.getTasks().size();
import org.junit.Before;
                "Injection must reach victim node before termination (thrown="
        AtomicReference<Throwable> failure = new AtomicReference<>();  
            CompositeDataFormatPlugin.class,
        }  
     * not a hang.  
            assertTrue("expected most queries to fail (saw " + failed + "/50)", failed >= 45);
    // a new DAG topology lands — joins, window, etc. — not for each new agg
import org.opensearch.test.InternalTestCluster;
        String coord = coordinatorNodeName();
    /**
     */  
        AtomicInteger batchCount = new AtomicInteger(0);  
        createAndSeedIndex();
            channel.sendResponse(new IllegalStateException("release-on-failure probe"));  
        CountDownLatch released = new CountDownLatch(1);
            long elapsedSec = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startNs);  
        }
        assertNoLeakOnSuccess("source = " + INDEX + " | stats sum(value) as total by value");  
     * fast in planning with a clear error containing the bad field name; not hang  
import java.util.concurrent.Future;  
        } finally {  
     * which drives an actual planner-rejecting query
            exec.awaitTermination(5, TimeUnit.SECONDS);
        assertEquals(
        ListTasksResponse remaining = client().admin().cluster().prepareListTasks().setActions(UnifiedPPLExecuteAction.NAME).get();
            disruption.stopDisrupting();  
            // Match NetworkDisruptionIT: speeds up reconnection after disruption
     * into a freshly-closed allocator. The drain task logs a WARN  
            assertTrue("Disconnect-during-dispatch race must terminate in bounded time", failure.get() != null || response.get() != null);
     * the contract is universal, only the DAG shape exercised varies.  
        } finally {  
            assertFalse("cancel must not produce node failures", cancel.getNodeFailures() != null && !cancel.getNodeFailures().isEmpty());
        System.gc();  
     */
     *
                faultCount.get() >= 1  
                "Coordinator must terminate with either a response or a failure on partial failure",  
 * this file be licensed under the Apache-2.0 license or a
            }
     * (with 0 replicas), then immediately query before recovery completes.
     * their own input partition. Distinct close path from single-input reduce.
        }
            Thread.sleep(500);
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {  
    public void testAllShardsUnassigned() throws Exception {
        Throwable failure = null;  
     * when the client is re-bound.
                out.put(sr.id(), name);
            "Native memory pool drifted: baseline=" + baseline + " mid=" + midpoint + " end=" + end + " allowed=" + allowed,  
            assertScalarLong(r, "total", EXPECTED_SUM);
     * <p>Construct a zero-row response that carries the real shard schema by  
     */  
// (orphaned fragment-task threads, leaked native-handle reapers) surface
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope(com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope.Scope.TEST)  
            PPLResponse response = null;  
        long before = dfs.getMemoryPoolUsage();
            );
                // the coordinator-side reduce sink, putting the drain task in
        assertNoPendingFragmentTasks();
            return delegate.getVersion();  
        } catch (Exception e) {
            // and leak traces print the allocation call-site stack.
                StageExecutionBuilder b = internalCluster().getInstance(QueryScheduler.class, e.getKey()).getStageExecutionBuilder();
    private static final long EXPECTED_SUM = (long) TOTAL_DOCS * VALUE;
     * DAG: N SHARD_FRAGMENT each producing zero rows → 1 reduce. The reduce
        createAndSeedIndex();
    }  
        }, 30, TimeUnit.SECONDS);
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
            "source = " + INDEX + " | stats sum(value) as total"  
     * (no reduce-stage drain to wait on).
    public void testShardHostNodeKillAndRestart() throws Exception {  
        + "exposes a public fault seam or a registered-state observability accessor — "
        try {  
     * {@link #client()} dispatches against. Used for disruption topologies that  
        assertEquals("failing query: zero onResponse", 0, ok2.get());
        internalCluster().setDisruptionScheme(disruption);  
        + "already covered indirectly by testPlanFailurePropagates (#21), which exercises the "
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
                    org.apache.arrow.vector.types.pojo.FieldType.nullable(new org.apache.arrow.vector.types.pojo.ArrowType.Int(64, true)),
        // Slow the victim so we can race in a cancellation.  
     */  
    public void testCoordinatorSurvivesUnresponsiveShard() throws Exception {
        internalCluster().setDisruptionScheme(disruption);
                assertTrue(
    private static void assertNoArrowLeakSuppressed(Throwable t) {
        MockTransportService delayMts = (MockTransportService) internalCluster().getInstance(TransportService.class, delayNode);
        AtomicInteger faultCount = new AtomicInteger();
     * {@code delay + serve-time}, not {@code delay × shards} (which would indicate
// nodes must not leak across methods.
                executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);  
            + " global-checkpoint race during cluster recovery after NetworkDisruption. Passes locally with both"
        assertTrue(  
        );  
     * outcomes are acceptable; a hang is not).  
        NetworkDisruption disruption = new NetworkDisruption(
        + "natural call sites are sandbox/plugins/analytics-engine/src/main/java/org/"  
            long memAfter = dfs.getMemoryPoolUsage();
    private PPLResponse executePPL(String ppl) {
        long before = dfs.getMemoryPoolUsage();
            beforeCount,  
    public void testScanNoReduceReleasesBufferOnSuccess() throws Exception {  
    @AwaitsFix(
            throw new AssertionError("createAndSeedIndex: timed out waiting for seed durability", e);
            }
        throw new AssertionError("no started primary for index " + indexName);
        createAndSeedIndex();
                deadlockedThreadIds = ids;
            );  
                originalByNode.put(node, thisNodeOriginal[0]);  
        createAndSeedIndex();  
import java.util.List;
     * re-throws, {@code PlanWalker.build()} catches and runs the
        return internalCluster().getClusterManagerName();
 */  
                // may still return partial data; don't fail here, let the post-check assert.
        try {
     * unread batches in the terminal sink.
                    }  
     * DAG: N partial-agg-with-key → 1 final-agg-with-key. Distinct from simple  
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
     * without hanging — exercises cancellation through the passthrough stage
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
        delayMts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
            CancelTasksResponse cancel = client().admin().cluster().prepareCancelTasks().setActions(UnifiedPPLExecuteAction.NAME).get();  
        AtomicInteger fail = new AtomicInteger();
            // nested. Without this assertion the query failure swallows the leak.
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
     */
    @AwaitsFix(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     */
                    Object cell = response.get().getRows().get(0)[idx];  
        String victim = pickShardHostingNode();  
                    fail.incrementAndGet();
        assertNull("query must succeed: " + ppl, failure);
        // Inject failure on one shard-host. With STREAM_TRANSPORT enabled, the  
            // Contract: either a clear error OR a partial-shards-failed result.
     * call returns the prior scheduler so we can restore in {@code finally}.  
        long relativeCeiling = (long) (baseline * 1.10);
            AtomicReference<PPLResponse> response = new AtomicReference<>();
     * planner failure AND tears down all coordinator-side registered state
        String coord = coordinatorNodeName();  
        try {  
        createAndSeedIndex();
     */  
     * (200 was the spec target; reduced to keep test budget under 60s with
     * early-termination depends on a coordinator-side LIMIT operator existing  
        DataFusionService dfs = internalCluster().getInstance(DataFusionService.class, coordinatorNodeName());
        private final TransportChannel delegate;  
            client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest("source = " + SINGLE_SHARD_INDEX + " | stats sum(value) as total"), new ActionListener<PPLResponse>() {
                Thread.currentThread().interrupt();
        String emptyNode = hosts.length > 1 ? hosts[1] : hosts[0];
     * potential coordinator must intercept the dispatch.
        + "doExecute(...) plan-then-schedule path) and sandbox/plugins/analytics-engine/src/"
    // ---------------------------------------------- E: lifecycle / planner / listener (#21-#34)
                "Cascade must propagate failure UP and cancel sibling DOWN — elapsed=" + elapsedSec  
        queue.add(t);
    /** Map each primary shard id → node name that currently hosts it. */
     * queries in a row to amplify any per-failure leak (orphaned fragment  
            }
        }
    /**
            exec.shutdownNow();  
            }  
     */
                Thread.currentThread().interrupt();
            internalCluster().clearDisruptionScheme();
        }
        internalCluster().setDisruptionScheme(disruption);
        createSingleShardIndex(SINGLE_SHARD_INDEX, 50);
            failure.set(t);
     * surfaces as a query failure (or a partial-failure response — both
        // partial results that look like resilience bugs.  
        assertTrue(
            assertTrue(
                            super.sendResponseBatch(arrow);
        AtomicInteger ok2 = new AtomicInteger();
        public void sendResponseBatch(TransportResponse response) {
        };
        createAndSeedIndex();  
     * a failed query. Depends on a way to fetch the allocator's usage; we proxy  
                ok2.incrementAndGet();  
        try {
import org.opensearch.plugins.Plugin;  
            .get();  
     * <p>This is distinct from cancellation: the query is succeeding, not
                PPLResponse r = executePPL("source = " + INDEX + " | stats sum(value) as total");  
        assertNoPendingFragmentTasks();
        );
     * must NOT see a closed query allocator. Reproduces a race where
 * <ul>
     * by every shard's stream output), the query terminates with a propagated
        long absoluteCeiling = baseline + 5L * 1024L * 1024L;  
            new NetworkDisruption.TwoPartitions(Collections.singleton(coord), Collections.singleton(victim)),  
     * #26 — Race: a node is in the dispatch target set when cluster state was read  
            throw new RuntimeException(  
        }
            mts.clearAllRules();
    /**  
        // Race window: schedule disruption start ~50ms after we begin dispatch.
 * transport's request-handler registry AND the {@link
            StageExecutionFactory prev = b.registerFactory(StageExecutionType.COORDINATOR_REDUCE, faulting);
            executePPL("source = " + INDEX + " | stats sum(nonexistent_field) as total", QUERY_TIMEOUT);
     * side of the exchange sink.
    /** Return one node name that currently hosts a primary of {@link #INDEX}. */
        int baseline = NativeHandle.liveHandleCount();  
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
     * #3 — Small network delay (200ms). Query must succeed and complete in roughly  
                    if (response instanceof org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse arrow) {
        try {
            internalCluster().clearDisruptionScheme();
                "Faulting COORDINATOR_REDUCE scheduler must have fired at least once (failure=" + failure.get() + ")",
            "Coordinator must terminate (failure or response) when shards are unassigned; got hang",
import java.lang.management.ThreadMXBean;
        assertScalarLong(r, "total", 30L * VALUE);
     * {@code FragmentExecutionAction} task counts. What this test would add on  
    private static final String SINGLE_SHARD_INDEX = "single_shard_idx";
        createSingleShardIndex(SINGLE_SHARD_INDEX, 30);  
                    super.sendResponseBatch(response);  
    public void testThreadLeakAfterFailedQuery() throws Exception {
            public void onResponse(PPLResponse r) {  
        // clusterService() resolves on the local (test-thread) node's client — in
        createAndSeedIndex();
            + " quorum during stop+restart after NetworkDisruption (FailedToCommitClusterStateException). Same"  
            AtomicReference<PPLResponse> response = new AtomicReference<>();
            public void onFailure(Exception e) {
            try {
     * transport, so without the fallback the stub would never bind.  
import org.apache.logging.log4j.Level;
     */
            "NA",  
            try {
            .indices()  
        ensureFullyConnected();
     * the user-visible response must arrive promptly with exactly LIMIT rows.
        );  
        }  
    /**  
            }  
     * task, native-handle reaper, executor pool thread) so even a leak too
        disruption.startDisrupting();
     * marker. Raised by {@code BaseAllocator.close()} when any child allocator still holds
        ExecutorService exec = Executors.newSingleThreadExecutor();  
            );
            exec.shutdownNow();  
        try {  
                "org.opensearch.be.datafusion.DatafusionReduceSink",
        stubAllocator = new org.apache.arrow.memory.RootAllocator();
     * <p>Shape: UNION across two single-shard indices pinned to distinct nodes
     */
            // silently returning EXPECTED_SUM, since the producer never delivered rows.
                    private boolean schemaForwarded = false;
    @After  
            released.countDown();
        assertNoLeakOnSuccess("source = " + INDEX + " | where value = " + VALUE);
        NetworkDisruption disruption = new NetworkDisruption(
import org.junit.After;  
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
            // Either error surfaced, or partial response; not a hang.
            });  
        ListTasksResponse remaining = client().admin().cluster().prepareListTasks().setActions(UnifiedPPLExecuteAction.NAME).get();
            .put("index.composite.primary_data_format", "parquet")
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),  
        long memBaseline = dfs.getMemoryPoolUsage();
            }  
            .build();  
            handler.messageReceived(request, wrapper, task);
            try {
        assertNoPendingFragmentTasks();  
            }  
        String victim = pickShardHostingNode();  
            .build();
    }
        // pluggable_dataformat=composite + parquet primary: prepareFlush().get() returns
            assertTrue(  
        }, 30, TimeUnit.SECONDS);
import org.opensearch.analytics.exec.QueryScheduler;  
            }, 15, TimeUnit.SECONDS);
        // cluster nodes. Use getMasterName() as a stable coordinator surrogate.  
            }  
     */
        // Normal query.
            .indices()
            .put("index.pluggable.dataformat.enabled", true)
        if (t == null) return;
            }
    protected Collection<PluginInfo> additionalNodePlugins() {
        try {  
        String victim = firstNonMatching(coord);
        internalCluster().setDisruptionScheme(disruption);
        }
import org.opensearch.common.settings.Settings;  
        assertBusy(() -> {  
    // ---------------------------------------------------- B: shard-level faults
        }
        ExecutorService exec = Executors.newSingleThreadExecutor();  
     * dispatch but before any fragments execute, the coordinator surfaces the
            } catch (InterruptedException ie) {
    }
        exec.shutdownNow();  
    /**
            NetworkDisruption.DISCONNECT  
     * naturally so the cancel races against an active or just-completed reduce
            System.gc();  
                        // Truncate the incoming root to zero rows in place — preserves the schema and the
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(coord));
     * sibling shard task is blocked, the stage must transition to FAILED immediately
        int handleBaseline = NativeHandle.liveHandleCount();
    private ScheduledExecutorService deadlockWatchdog;
            internalCluster().clearDisruptionScheme();
        ensureFullyConnected();
            return delegate.getChannelType();
     * already-built reduce stage must be cancelled, releasing its native
        NetworkDisruption disruption = new NetworkDisruption(
        assertEquals("normal query: exactly one onResponse, zero onFailure", 1, okCount.get());  
            if (cur == null || !seen.add(cur)) continue;
            mts.clearAllRules();
            }
                break;
            }
        + "same path with a real planner-rejecting query. What this test would add is direct "
    @Override
     */  
            channel.sendResponse(new org.opensearch.core.tasks.TaskCancelledException("shard-cancelled-during-test"));
                    + ", failure="  
     * stage has to handle the empty-input close path correctly.  
        ensureGreen(name);  
                fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
        }
     * stage's {@code ExchangeSinkProvider.createSink} call (invoked from
                }
            AtomicReference<Throwable> failure = new AtomicReference<>();  
                okCount.incrementAndGet();
     * Shape: simple aggregation (no group-by).
     * operations so tests can intercept either path.  
import org.opensearch.common.util.FeatureFlags;
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));  
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
            // Slack of 10× delay per shard — a quadratic-in-delay coordinator would
                TransportChannel wrapper = new ForwardingChannel(channel) {
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
            } finally {  
    public void testMissingNodeAfterResolution() throws Exception {
     * (c) native pool is back to baseline within 1MiB slack. Used by every
                        }
    /**
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
    /**
    public void testMidStreamBatchExceptionPropagates() throws Exception {
            new PPLRequest("source = " + INDEX + " | stats sum(nonexistent_field) as total"),
                        org.apache.arrow.vector.VectorSchemaRoot incoming = arrow.getRoot();
            try {
                new org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse(vsr)
        String bridge = allNodes.iterator().next();  
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
    /**  
        }
                try {  
            handler.messageReceived(request, wrapper, task);  
            .index(INDEX)  
            StageExecutionBuilder builder = internalCluster().getInstance(QueryScheduler.class, node).getStageExecutionBuilder();
            mts.clearAllRules();
        + "in-process — so transport interception cannot reach the planner-internal failure "  
import java.util.stream.Collectors;
        );  
        // session / lock and this query would fail or hang.
            .get();
        // info plus monitor/synchronizer ownership for diagnosing deadlocks.  
    }
    /**
            try {
        });
                thrown.get() || response.get() != null || failure.get() != null  
        } finally {
        }
        // The PPL client may dispatch to any node — register the faulting
     */  
            int handleAfter = NativeHandle.liveHandleCount();  
     * because {@link InternalTestCluster#stopRandomNode} requires cluster
    // ---------------------------------------------------- B: application-layer stubbing
    }
    public void testPlanFailurePropagates() throws Exception {  
            return delegate.getProfileName();
        // Sanity: a fresh query against the same index works post-failure.
                                incoming.close();
                @Override
            if (!n.equals(failNode)) {  
    public void testExchangeSinkRegistrationFailureTearsDown() throws Exception {
        ensureStableCluster(internalCluster().getNodeNames().length);  
            mts.clearAllRules();
     */
 *
     * the JVM only reports actual lock cycles where every participant is blocked.
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
    /**
        }
        }
            new NetworkDisruption.TwoPartitions(Collections.singleton(coord), Collections.singleton(victim)),
        // No leaked fragment tasks (planning failure must short-circuit before dispatch).
            for (Map.Entry<String, StageExecutionFactory> e : previousByNode.entrySet()) {  
        @Override  
    /**
            after.getTasks().size()
     */
        }
                public void onResponse(PPLResponse pplResponse) { ok.incrementAndGet(); }  
            "classpath plugin",
    }
            long memAfter = dfs.getMemoryPoolUsage();
     * not block waiting for the remaining shards to finish, and the total
            disruption.startDisrupting();  
        );
            }
     * registered-state accessor on the unified query planner today.  
            if (cause != null) {
            AtomicInteger fail = new AtomicInteger();
            disruption.stopDisrupting();
            AtomicReference<Throwable> failure = new AtomicReference<>();
        executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
                            return;  
     * Single-shard index pinned to {@code nodeName} via {@code _name} allocation
     * Wait until the cluster is actually fully reconnected after a disruption.  
    // ----------------------------------------------- D: shutdown-restart flavor
        public void sendResponse(Exception exception) throws java.io.IOException {  
                @Override
     * <p>Distinct from {@link #testMultiChildStageFailureCancelsRunningSibling}: that
        // With 3 shards, 0 replicas spread across 3 nodes, stopping ANY one node
     * #9 — Cancel the data-node fragment task mid-flight. Data-node task goes away,  
        assertEquals("row count", 1, response.getRows().size());
    /**
            assertTrue(
            AtomicReference<PPLResponse> response = new AtomicReference<>();
     * (no response within {@link #QUERY_TIMEOUT}) both fail this test.  
    }
    // |------------------------------------|-------------------------------------------|
    }
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
                b.registerFactory(StageExecutionType.COORDINATOR_REDUCE, e.getValue());  
        String victim = firstNonMatching(coord);
            .prepareCreate(name)  
        try {
    /**
            disruption.stopDisrupting();  
     */
        createAndSeedIndex();
        String victim = pickShardHostingNode();
            Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total"));
    // contract is universal across shapes: regardless of which operators run,
            } catch (InterruptedException ie) {  
                        batch.close();
                elapsedMs < QUERY_TIMEOUT.millis() + 5_000L
                raceStart.get(5, TimeUnit.SECONDS);  
                midpoint = dfs.getMemoryPoolUsage();  
        try {
        try {  
            assertBusy(() -> {
        Map<Integer, String> out = new HashMap<>();  
    public void startDeadlockWatchdog() {
     * — the post-condition (no leak across either landing) must hold regardless.
        }, 30, TimeUnit.SECONDS);  
            }  
            );  
                ok.get() + fail.get()
        }
            this.delegate = delegate;  
            if (cur.getMessage() != null && cur.getMessage().contains("Memory was leaked")) {  
    }
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {  
                }
     * up a fresh node, heal, re-index, re-query.
                    return null;  
            internalCluster().clearDisruptionScheme(true);  
import static org.hamcrest.Matchers.greaterThan;
     * {@link #stopDeadlockWatchdog()} fails the test with a thread dump. Cheap and
                        if (incoming == null) return;  
        long allowed = Math.max(absoluteCeiling, relativeCeiling);
import static org.hamcrest.Matchers.lessThan;
            Thread.sleep(500);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)  
        createAndSeedIndex();  
                    }
     * (sendResponse) and streaming (sendResponseBatch + completeStream)
            MockCommitterEnginePlugin.class  
            }
        internalCluster().setDisruptionScheme(disruption);  
        });
import java.util.concurrent.CountDownLatch;
        createAndSeedIndex();
        // Parent task is gone.
        });
                    null  
        assertNotNull("PPLResponse must not be null", response);
        AtomicInteger fail2 = new AtomicInteger();
                @Override
    /**
        bugUrl = "https://github.com/opensearch-project/OpenSearch/pull/21711 — flaky on CI: ReplicationTracker"  
    }
        return new PluginInfo(  
            }
     * contract is honest under the real protocol.  
import org.opensearch.analytics.AnalyticsPlugin;
            }  
        // Schema width must match the coordinator's declared input-partition schema — that's
            // content with a zero-row batch that still carries the shard's schema. Honors the
                fail("query must fail — the victim shard's handler was stubbed to return an exception");  
        }
        createAndSeedIndex();  
     * <p>Exercises the streaming-fallback path in {@link MockTransportService}:
        client().execute(
            client().admin().indices().prepareDelete(INDEX).get();
                assertEquals("seed not yet visible to analytics path", EXPECTED_SUM, actual);
                    if (n == 4) {
        }  
            + " core cluster-coordination race is fixed."  
    // ---------------------------------------------------- A: network-level faults
     * #20 — Coordinator node itself is killed mid-query. Subsequent client call via
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(victim));  
            Thread.sleep(75);
        }
        ensureFullyConnected();
                @Override
public class CoordinatorResilienceIT extends OpenSearchIntegTestCase {
                "*drain task terminated*"  
     * test exercises sibling STAGE cancellation; this one exercises sibling TASK fast-
            } catch (Throwable t) {
            long elapsedMs = (System.nanoTime() - start) / 1_000_000L;  
package org.opensearch.analytics.resilience;
                try {  
        } finally {  
                handler.messageReceived(request, wrapper, task);  
            Throwable queryFailure = null;  
            // Sometimes stop fails in transit; proceed — next query will confirm survival.  
        public void sendResponse(TransportResponse response) throws java.io.IOException {
                    long got = cell == null ? -1 : ((Number) cell).longValue();
        } catch (Throwable t) {
            vsr.setRowCount(0);  
            }, 30, TimeUnit.SECONDS);  
     * runs out of native memory while allocating a session) flows through  
    /**
        }
        errorMts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {  
            allowed = absoluteCeiling;
     * serial blocking).
        PPLResponse r = executePPL("source = " + SINGLE_SHARD_INDEX + " | head 1", QUERY_TIMEOUT);  
            assertScalarLong(response, "total", EXPECTED_SUM);
                handleAfter <= handleBaseline  
        });
                    "total",
    public void testSingleShardCancellationAtCoordinator() throws Exception {
     */  
     *  
        }
            assertTrue(  
        // scheduler on every node so the build failure is reproducible  
            new PPLRequest("source = " + INDEX + " | stats sum(value) as total"),
 * (a.k.a. stage scheduler —  
     * isolate the coordinator vs. workers.
        createAndSeedIndex();  
                "Query with 300ms shard delay took " + elapsedMs + "ms; > " + upperBound + "ms suggests serial blocking",
                    @Override
                released.await(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
        + "contexts) after a planner-injected failure. Deferred until UnifiedQueryPlanner "
        createAndSeedIndex();
     * from the class-level {@code @ThreadLeakScope(Scope.TEST)}: the suite  
    }
// is still alive 5s after the method returns fails the test. Overrides the
     * {@link StageExecutionType} and the original {@code registerFactory}
    private void assertNoPendingFragmentTasks() throws Exception {  
                        ok.incrementAndGet();  
     * #25 — All shards unassigned: stop the node hosting the index's primaries
                cancel.getNodeFailures() != null && !cancel.getNodeFailures().isEmpty()
                "Pending fragment tasks remain: " + infos.stream().map(t -> t.getTaskId().toString()).collect(Collectors.joining(", ")),
                @Override
    }
    }  
        }
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
    }  
     * baseline.  
            }  
        public String getProfileName() {
     * sweeps the running sibling sub-tree, which cancels the parent task and  
            internalCluster().clearDisruptionScheme();  
    public void testCoordinatorSurvivesDisconnectFromOneShard() throws Exception {
     * still alive {@code linger}ms after the method returns.
            assertThat("Partial sum must be < full when a shard contributes nothing; got " + actual, actual, lessThan(EXPECTED_SUM));
    }  
            }
    }
            thisNodeOriginal[0] = builder.registerFactory(StageExecutionType.SHARD_FRAGMENT, perNodeFaulting);
     * DAG: M independent reduce trees → 1 COORDINATOR_REDUCE Union.
     * the blocked handler.
        });
        AtomicReference<PPLResponse> response = new AtomicReference<>();
        } finally {
import org.opensearch.test.MockLogAppender;
            .put(super.nodeSettings(nodeOrdinal))
        assertBusy(  
        try {  
        long memBefore = dfs.getMemoryPoolUsage();
     * the coordinator merges streams from multiple shards.  
            } catch (Throwable t) {
        assertBusy(() -> NetworkDisruption.ensureFullyConnectedCluster(internalCluster()), 30, TimeUnit.SECONDS);
        } catch (Throwable t) {
    private void createAndSeedIndex() {
                    + ")",
     * framework fails this test if any thread spawned during the loop is
            TimeUnit.SECONDS  
        assertNoArrowLeakSuppressed(failure);
        String victim = firstNonMatching(coord);  
        NetworkDisruption disruption = new NetworkDisruption(  
        + "mode.")
            );
            Throwable cur = queue.poll();
            try {
            // Single callback regardless of outcome.
            exec.shutdownNow();  
                        // so the throw doesn't leak the source root's buffers.
        return shardToNode().values().iterator().next();
            if (sideOne.isEmpty()) sideOne.add(n);
     * {@code PlanWalker.build()}: the coordinator-reduce stage builds first
     * Asserts the full resource-release contract: no zombie fragment tasks, no
 *   <li>A. Network-level transport faults (NetworkDisruption: disconnect,
            // it on here so Arrow's BaseAllocator.DEBUG picks up `true` at class init  
     */
        long end = dfs.getMemoryPoolUsage();  
        } finally {
     * result from the other two shards.
            AtomicReference<Throwable> failure = new AtomicReference<>();
        long siblingDelaySeconds = QUERY_TIMEOUT.seconds();  
            // allocator still owns buffers. QueryContext.closeBufferAllocator attaches that
                            if (schemaForwarded) {  
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.metadata.IndexMetadata;
        }
            ListTasksResponse tasks = client().admin().cluster().prepareListTasks().setActions(FragmentExecutionAction.NAME).get();
     * top is tighter cleanup-state observability (registered-state accessors on
        + "MockTransportService.addRequestHandlingBehavior on the dispatch action sees the "
            try {  
        // means this doesn't bleed into other tests.
                failure.get() != null || response.get() != null  
     * through the reduce, exercising larger intermediate buffers.
            exec.awaitTermination(5, TimeUnit.SECONDS);
                Thread.currentThread().interrupt();
     * The framework's {@code ensureFullyConnectedCluster} only takes a single
     * still-disrupted victim cannot acknowledge — the framework would throw
            long startNs = System.nanoTime();
                @Override
        // "getStackTrace"). ThreadMXBean#dumpAllThreads is allowed and returns equivalent
        createAndSeedIndex();  
            }  
     */  
        // If the partial-build cleanup was incomplete we'd see a residual  
    // | Shape                              | DAG topology                              |
     * lets them fire against a half-connected cluster and surface a misleading  
        PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total");
     * #4 — Intermittent disruption: toggle disconnect on/off; fire query mid-cycle.
            new NetworkDisruption.TwoPartitions(Collections.singleton(coord), Collections.singleton(victim)),
        String[] nodes = internalCluster().getNodeNames();
     * as #23 but replaces the {@code COORDINATOR_REDUCE} scheduler with  
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
        AtomicReference<Throwable> failure = new AtomicReference<>();  
            } catch (ExecutionException | TimeoutException ignore) {
    /**
        createAndSeedIndex();
            });
    }  
        }
        }  
        return Settings.builder()  
            }
            boolean exception = failure.get() != null;
            internalCluster().clearDisruptionScheme();
            }  
        ExecutorService exec = Executors.newSingleThreadExecutor();  
        createAndSeedIndex();  
        }
            .prepareCreate(name)
        Map<String, StageExecutionFactory> originalByNode = new HashMap<>();  
     * via {@link DataFusionService#getMemoryPoolUsage()} which covers the native
        disruption.startDisrupting();
                }
                    + "s; if this approaches the latch timeout, the sibling stage stalled instead of being cancelled",
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;  
        disruption.startDisrupting();
        );
            assertTrue(
        }, 15, TimeUnit.SECONDS);
            released.countDown();
        String coord = coordinatorNodeName();  
                    Thread.currentThread().interrupt();
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(victim));  
        String victim = firstNonMatching(coord);
            try {
        DataFusionService dfs = internalCluster().getInstance(DataFusionService.class, coordinatorNodeName());
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
    /**  
                            }
            new NetworkDisruption.TwoPartitions(Collections.singleton(coord), Collections.singleton(victim)),
 *
        Settings indexSettings = Settings.builder()  
    protected Settings nodeSettings(int nodeOrdinal) {
    private String firstNonMatching(String name) {
     * a single zero-row schema batch when the native source produces no rows, so the streaming
                new PPLRequest("source = " + INDEX + " | stats sum(value) as total"),  
            deadlockWatchdog = null;
            try {  
     */
                String name = clusterService().state().nodes().get(nodeId).getName();
            mts.clearAllRules();
import org.opensearch.test.OpenSearchIntegTestCase;  
        final int n = 50;
            stubAllocator = null;
                // the cancel landed (a no-op race). Both must satisfy the
        long memBaseline = dfs.getMemoryPoolUsage();  
    }
        }
     */  
     * the listener. Verifies the failure path doesn't hang and surfaces a non-null
                after <= baseline
            try {
        );  
            UnifiedPPLExecuteAction.INSTANCE,
            for (Map.Entry<String, StageExecutionFactory> e : originalByNode.entrySet()) {
        assertBusy(() -> {
    }
                failure = t;
                }
        assertTrue("No residual UnifiedPPLExecute tasks after cancel: " + remaining.getTasks(), remaining.getTasks().isEmpty());
        DataFusionService dfs = internalCluster().getInstance(DataFusionService.class, coordinatorNodeName());  
                            if (r != null) {
        } finally {  
                "cancel request must not carry back node failures",
        try {
        ensureFullyConnected();
            holdShard.countDown();
     *  
        // the listener-single-callback contract holds.
        }  
    }  
                if (idx < 0 || response.get().getRows().isEmpty()) {  
     * fail within a single SHARD_FRAGMENT stage.  
    // ----------------------------------------------- C2: query-shape leak matrix
        DataFusionService dfs = internalCluster().getInstance(DataFusionService.class, coordinatorNodeName());  
    public void testListenerSingleCallback() throws Exception {
                queryFailure = t;
        createSingleShardIndex(SINGLE_SHARD_INDEX, 50);
            long actual = ((Number) response.getRows().get(0)[response.getColumns().indexOf("total")]).longValue();  
        DataFusionService dfs = internalCluster().getInstance(DataFusionService.class, coordinatorNodeName());
    public void testTaskCancellationAtDataNode() throws Exception {  
     * fail the query (surface the cause) in bounded time.  
            + " teardown race as testCoordinatorSurvivesIntermittentNetwork. Unmute when fixed upstream."
            if (prev != null) {
            assertThat("Partial sum must be ≥ 0 given the other two shards' contribution", actual, greaterThan(-1L));
                failure.set(t);
     * but disconnects before the request is sent. NetworkDisruption.DISCONNECT
     * consensus (it adds voting-config exclusions before shutdown), which a  
        }
        String errorNode = hosts[0];  
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
import java.util.concurrent.atomic.AtomicBoolean;
            String victim = pickShardHostingNode();  
                "NativeHandle live count grew after cancel: baseline=" + handleBaseline + " after=" + handleAfter,
        }
                        // Release the would-be-forwarded batch's native memory  
            channel.completeStream();  
     * handler runs, the data node never produces real data. Instead the stub
    // the structural surface, not specific operators. Add a new test only when  
        assertNotNull("PPL referencing missing field must surface a planning error; got null failure (response=hang?)", failure.get());  
                Thread.currentThread().interrupt();
            AtomicReference<Throwable> failure = new AtomicReference<>();  
        int idx = response.getColumns().indexOf(column);  
        try {
                failure.set(t);
    // every per-query Arrow allocator must return to baseline at close, or the  
            mts.clearAllRules();  
     * <p>Data-node handler delegates to the production streaming handler via a
        try {
        createAndSeedIndex();  
    }
     * (one fail-injected, one latch-delayed). The parent {@code COORDINATOR_REDUCE}  
        assertScalarLong(response, "total", EXPECTED_SUM);
     * post-condition oracle.  
                failure.set(t);
        MockTransportService emptyMts = (MockTransportService) internalCluster().getInstance(TransportService.class, emptyNode);
        assertNoLeakOnSuccess("source = " + SINGLE_SHARD_INDEX + " | where value = " + VALUE);
    private Map<Integer, String> shardToNode() {
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
     */
            thrown.set(true);
    /**
                    return executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
        NetworkDisruption disruption = new NetworkDisruption(  
     * <p>Pins the coordinator's contract: under disconnect, does the query fail
        // disruption-time queries race the in-flight commit and produce nondeterministic
    }
            disruption.startDisrupting();
            List.of(
            .setPersistentSettings(Settings.builder().put(DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT.getKey(), 1L))
    }
        };
            remaining.getTasks().isEmpty()
            failure.get() != null || response.get() != null
     * {@link #testCoordinatorPropagatesStageFailure} (#8) — only the injection  
            // The contract this guard fixes: feed() throwing must NOT hang the query
        createAndSeedIndex();  
        } finally {
            client().admin()
    /**
            assertFalse(  
     */
    }  
     * once a second; if the JVM reports a monitor cycle anywhere in the test JVM,
    }  
     *
            // sendResponseBatch transfers buffer ownership to the wire. Honors the Flight protocol
    private static final String INDEX = "resilience_idx";  
     *
            // OR the parent reduce stage races ahead and emits a wrong result from an
            // exception as a Suppressed on the surfaced query failure; walk the whole cause  
     * propagates straight from the shard fragment through the passthrough stage to
        } finally {
        createSingleShardIndex(SINGLE_SHARD_INDEX, 100);
        // Hold the shard handler so the query stays in flight long enough to cancel.
    /**
        } catch (Throwable t) {  
     * remaining node must still function. Tests that coordinator singleton state
     * applies to both the regular and streaming transports' connections, so this  
     * Shape: scan + filter, single shard, no reduce.  
            emptyMts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
            // Brief delay so the dispatch has crossed into the data-node and
                response.get() == null ? "null" : response.get().getRows().size() + " rows",
     * a common production topology where coordinators are separate from data nodes.
            List<TaskInfo> infos = tasks.getTasks();  
     * delegating to the real handler and capturing the field names through a
        try {
import java.util.concurrent.ExecutionException;  
     *
     * <p>Note: the kill is performed AFTER the disruption stops (not during)
            AtomicReference<PPLResponse> response = new AtomicReference<>();
        for (String node : internalCluster().getNodeNames()) {
        internalCluster().startNode();
     * #F1 — Dedicated coordinating-only client node. Adds a coordinating-only node to
                return thisNodeOriginal[0].createExecution(stage, poisoned, qctx);
            released.countDown();  
            failMts.clearAllRules();
            } catch (Throwable t) {
import org.opensearch.transport.TransportChannel;
            // Allow dispatch + shard-handler entry  
    public void testCoordinatorSurvivesIntermittentNetwork() throws Exception {
     */
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
import java.util.concurrent.Executors;
            deadlockWatchdog.awaitTermination(2, TimeUnit.SECONDS);
            delayMts.clearAllRules();  
    )
        assertThat("need ≥2 nodes to pin sibling legs", nodes.length, greaterThan(1));
        logger.info("memory drift across {} queries: baseline={} mid={} end={} allowed≤{}", n, baseline, midpoint, end, allowed);
                elapsedSec,
        assertNoLeakOnSuccess("source = " + INDEX + " | head 1");  
    /**
            for (String node : internalCluster().getNodeNames()) {
        client().admin().indices().prepareRefresh(INDEX).get();
     * to short-circuit the merge.
                );  
            AtomicReference<PPLResponse> response = new AtomicReference<>();
            Throwable failure = null;
        CreateIndexResponse response = client().admin()
            try {
        // which closes any backend sink the reduce path created before the
    }
                "Native memory grew after exchange-sink build failure: before=" + memBefore + " after=" + memAfter,
     * clean error, not an OOM crash.  
                    wrongResult = got != EXPECTED_SUM;
     * cascade's sibling-stage cancel-sweep cancels the parent task, which interrupts
                StageExecutionBuilder b = internalCluster().getInstance(QueryScheduler.class, e.getKey()).getStageExecutionBuilder();
     * #8 — Inject an exception on one shard's fragment handler. Coordinator must
            int handleAfter = NativeHandle.liveHandleCount();
     * aggregation because partial-aggregate batches carry the grouping column
     * The union reduce uses MultiInputExchangeSink; child stages each write to  
// TEST-scope: each test gets a fresh cluster — disruption schemes and killed  
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
            Version.CURRENT,
        }  
                    + failure.get()
        failMts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
            // Hanging past QUERY_TIMEOUT surfaces as actionGet timeout → ignored
        Settings indexSettings = Settings.builder()
     * small to surface at N=1 becomes obvious. Leak detection itself comes
import java.util.concurrent.atomic.AtomicReference;  
     * that subsequent queries observe a clean baseline. The propagation half of
import org.opensearch.cluster.routing.ShardRouting;
    private String coordinatorNodeName() {  
            handler.messageReceived(request, channel, task);  
        + "contract (planner failure surfaces + no leaked FragmentExecutionAction tasks) is "  
            // by AtomicReference failure capture only if we add per-call timeout.  
            MockTransportService.TestPlugin.class,
    public void clearDisruption() {
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
        assertNoPendingFragmentTasks();
            );  
    /**
        // Threshold: end ≤ baseline + 5 MiB AND end ≤ baseline × 1.10.
                lessThan(delaySeconds / 2)
            AtomicReference<PPLResponse> response = new AtomicReference<>();  
        try {  
                .get();  
            new NetworkDisruption.TwoPartitions(Collections.singleton(coord), Collections.singleton(victim)),  
            .shardsWithState(org.opensearch.cluster.routing.ShardRoutingState.STARTED)) {  
            });  
            channel.sendResponse(new RuntimeException("injected within-stage task failure"));
            exec.shutdownNow();
                            org.apache.arrow.vector.VectorSchemaRoot incoming = arrow.getRoot();
            for (Throwable s : cur.getSuppressed()) {
     * still-running sibling — not let the sibling stall on its handler.  
        createAndSeedIndex();  
    // -------------------------------------------- G: single-shard / no-reduce-stage  
import org.opensearch.analytics.exec.stage.StageExecutionBuilder;
        ExecutorService exec = Executors.newSingleThreadExecutor();  
            delegate.completeStream();
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
            AtomicReference<Throwable> failure = new AtomicReference<>();  
import org.opensearch.arrow.allocator.ArrowBasePlugin;
 *   <li>C. Reduce-stage / DataFusion backend faults + concurrency hygiene.</li>
        Thread.sleep(200);
        StringBuilder sb = new StringBuilder();
                            // Already forwarded a zero-row schema frame — drop subsequent batches.
                } else {
            }
     */  
        DataFusionService dfs = internalCluster().getInstance(DataFusionService.class, coordinatorNodeName());  
            10,
                elapsedSec,  
@LuceneTestCase.AwaitsFix(bugUrl = "Fix flaky recovery bugs before re-enabling")  
            assertTrue(
                failure.set(t);
import org.opensearch.analytics.spi.ExchangeSink;
                    public void close() {
        }, 30, TimeUnit.SECONDS);  
                } catch (Throwable t) {
        };
        long before = dfs.getMemoryPoolUsage();
        ensureFullyConnected();
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
     * listener (which tears down the per-query Arrow allocator) before
            .put("index.pluggable.dataformat", "composite")
        });
            long start = System.nanoTime();
        // the *aggregate* output type (SUM(int) → Int64/BIGINT), not the base column type.  
            }  
                failure.set(t);
                            if (incoming == null) return;
     * Stubs one shard's {@link FragmentExecutionAction} entirely — no real
    /**
            // usually still have a pending reduce when the cancel lands.
        // record voting-config exclusions, and the disrupted victim can't
        String victim = firstNonMatching(coord);
    public void testWithinStageTaskFailureFailsFastWithoutWaitingForSiblings() throws Exception {
            } catch (Throwable t) {
        }
            )
     * No test-only static hook, no private-field reflection.
        } catch (Throwable ignore) {}
                    }
        }
        createAndSeedIndex();  
        client().admin().indices().prepareFlush(INDEX).get();  
     * one exercises within-stream backpressure (single producer, multiple
    )
        assertBusy(() -> {
        for (String n : allNodes) {  
                public void sendResponseBatch(TransportResponse response) {
        } finally {
        executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
        assertScalarLong(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT), "total", EXPECTED_SUM);  
                    @Override  
 * does this test. {@link MockTransportService}'s  
                channel.sendResponse(new IllegalStateException("inject-shard-failure"));
     * the 3-data-node cluster and dispatches the query through it. Verifies the  
            .put("index.pluggable.dataformat.enabled", true)  
        };
                new org.apache.arrow.vector.types.pojo.Field(  
    }  
     */
// immediately at the offending method instead of being aggregated to suite end.
    }  
    public void testTaskCancellationAtCoordinator() throws Exception {
     */
        }  
                ExchangeSink poisoned = new ExchangeSink() {
            end <= allowed
            NetworkDisruption.DISCONNECT
     * post-disruption recovery path.
     * {@code LocalStageExecutionFactory.createExecution}) throws. Earlier dispatch-
        createAndSeedIndex();
            holdShard.countDown();
        // Failing query (bad field — guaranteed plan failure from #21).  
                new IllegalStateException("injected exchange-sink registration failure")
     * this contract — "planner failure surfaces, no leaked fragment tasks" — is
        createAndSeedIndex();
import org.opensearch.Version;  
                        sink.close();
            disruption.stopDisrupting();  
        }  
            CancelTasksResponse cancel = client().admin().cluster().prepareCancelTasks().setActions(FragmentExecutionAction.NAME).get();
        // Native handle registry must return to baseline — the partial-build
        deadlockedThreadIds = null;  
        try {  
        assertTrue(  
import org.opensearch.ppl.TestPPLPlugin;
                failure.set(t);  
            .shardsWithState(org.opensearch.cluster.routing.ShardRoutingState.STARTED)) {
            TransportChannel wrapper = new ForwardingChannel(channel) {
                    QUERY_TIMEOUT
     * Suite-wide deadlock detector. Polls {@link ThreadMXBean#findDeadlockedThreads()}  
            StageExecutionFactory prev = b.registerFactory(StageExecutionType.SHARD_FRAGMENT, faulting);
                                try {
        } catch (Exception e) {
        // Defensive cleanup — every test that sets a disruption should have
        NetworkDisruption disruption = new NetworkDisruption(  
                        incoming.setRowCount(0);
        // TransportClient-less mode, client() binds to one of the internal
        CountDownLatch released = new CountDownLatch(1);
        String victim = pickShardHostingNode();
    /**
            Thread.sleep(500);
            TransportChannel wrapper = new ForwardingChannel(channel) {  
     * AssertionError("unexpected") from {@code excludeClusterManagers}. The
            assertNotNull("Build failure must surface to the listener (got null failure)", failure.get());
        String[] hosts = map.values().stream().distinct().toArray(String[]::new);
import java.util.concurrent.ScheduledExecutorService;
                mts.clearAllRules();
    // Each test asserts (a) no Arrow leak surfaces via the result, (b) the
            NetworkDisruption.DISCONNECT
     * <p>This test exercises the partial-build cleanup path in  
            }  
        }  
                "Native memory grew after cancel-during-reduce: baseline=" + memBaseline + " after=" + memAfter,  
            disruption.stopDisrupting();
    /**
            response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
     * to the disconnected-shard state, then the heal+kill validates the
        );
        // Restore cluster size so subsequent @After cleanup is clean.
 * @opensearch.internal
    public void testPartialFailure() throws Exception {  
        });
    // ---------------------------------------------- F: topology variations
            for (int i = 0; i < 50; i++) {
        }  
            );
    private PPLResponse executePPL(String ppl, TimeValue timeout) {  
                // Expected path: coordinator saw cancellation / failure.
            assertTrue("Mid-stream disconnect must surface error or partial response (no hang)", response != null || failure != null);
        AtomicBoolean thrown = new AtomicBoolean(false);  
    private static final int NUM_SHARDS = 3;
    private static void assertScalarLong(PPLResponse response, String column, long expected) {
            errorMts.clearAllRules();
                holdShard.await(20, TimeUnit.SECONDS);  
                    new PPLRequest("source = " + INDEX + " | stats sum(value) as total"),
     * rather than wait for the blocked sibling. Failure propagates upward; the  
    /**
        } finally {
     *
        }
            try {
        String coord = coordinatorNodeName();
    /**  
     * #33 — Race a shard success with another shard's failure (via injected
        createSingleShardIndex(SINGLE_SHARD_INDEX, 10);  
                "feed() failure must surface (got response=" + response.get() + ", failure=" + failure.get() + ")",  
     * Creates + seeds a single-shard composite-parquet index with {@code docs} rows.
    }  
        // With 0 replicas, the index has lost data on killed node — recreate.  
     * #G3 — Single-shard parent-task cancellation. Cancels the AnalyticsQueryTask
                elapsedMs < upperBound
            NetworkDisruption.DISCONNECT
            .index(indexName)
        for (ShardRouting sr : clusterService().state()  
        ListTasksResponse after = client().admin().cluster().prepareListTasks().setActions(FragmentExecutionAction.NAME).get();  
            AtomicInteger fail = new AtomicInteger();  
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.cluster.NodeConnectionsService;
                response.get() != null || failure.get() != null  
        String victim = pickShardHostingNode();
import org.opensearch.composite.CompositeDataFormatPlugin;  
            // ServerConfig#init unconditionally sets the arrow.memory.debug.allocator
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
    // | scan-no-reduce (single shard)      | 1 SHARD_FRAGMENT (passthrough)            |  
            if (i == n / 2) {
     * disruption queries) need this; silently swallowing the assertion error
     * <p><b>Currently failing:</b> the planner pushes {@code head N} to each
        PPLResponse response = null;
     * LOCAL_PASSTHROUGH stage instead of LOCAL_REDUCE, so neither
        client().admin().indices().prepareRefresh(name).get();  
            if (!emptyNode.equals(errorNode)) emptyMts.clearAllRules();  
            .put("index.composite.primary_data_format", "parquet")
            try {
                } catch (Throwable expected) {
        }
    public void testCancelDuringReduce() throws Exception {
     *
        Thread.sleep(50);
            long after = dfs.getMemoryPoolUsage();  
            AtomicReference<Throwable> failure = new AtomicReference<>();
     * land the cancel during dispatch. This variant lets the data-node run  
            assertTrue("Tiny memory limit must surface as failure or bounded response", response.get() != null || failure.get() != null);  
        @Override
    private volatile long[] deadlockedThreadIds;
import org.opensearch.core.action.ActionListener;  
                @Override
import org.opensearch.ppl.action.PPLResponse;
        MockTransportService delayMts = (MockTransportService) internalCluster().getInstance(TransportService.class, delayNode);  
     */  
            // place would poison subsequent tests in the suite.
    /**
        assertNoLeakOnSuccess(
            assertThat(
                delayNode = n;
        return List.of(  
            AtomicReference<PPLResponse> response = new AtomicReference<>();  
     * {@code NodeConnectionsService} take a few hundred ms post-heal, so we  
        }
        + "request only AFTER transport dispatch — i.e. after planning has kicked off "
                // schema-bearing batch so the Flight invariant holds, drop the rest.  
     * read batch size so the shard's stream emits multiple batches.  
        // Kill the node post-disruption: the framework needs consensus to  
            );  
        for (String n : internalCluster().getNodeNames()) {
        assertNoLeakOnSuccess("source = " + INDEX + " | sort value");
    }
            try {  
 *       on {@link FragmentExecutionAction#NAME}.</li>  
     * Shape: aggregation with grouping key.
     * #29 — Connection drop mid-stream on one shard's stream. NetworkDisruption
            }  
     */  
    /**
            // past QUERY_TIMEOUT. Either the failure surfaces as an exception (preferred),  
        // acknowledge those during disruption.
        exec.awaitTermination(5, TimeUnit.SECONDS);
        }
     * throws on the 4th. The production handler's outer catch turns the throw  
     * Coordinator just forwards the shard's stream to the caller.  
        ensureFullyConnected();  
            "1.8",
import java.util.Collection;
            );  
            } catch (InterruptedException ie) {
            );
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
     * <p>Complements {@link #testEarlyTerminationLimitMultiShard()}: this
            } catch (Throwable t) {  
     * returned row count must equal the requested limit.
            // After release, surface a cancelled-style failure so the shard side terminates cleanly.
     *
        } finally {
     * coordinator-reduce stage runs correctly on a node that holds NO data shards —
            // Already gone — fine.
    /**
            assertTrue(
    /** Allocator for Arrow buffers produced by stubbed-handler tests; closed after each test. */  
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));  
     * Shape: sort with shard-side pushdown.  
    // | group-by aggregation               | N partial w/key → 1 final REDUCE w/key    |  
        if (deadlockedThreadIds != null) {
                lessThan(siblingDelaySeconds / 2)  
            );
                failure = t;
        // Thread.getAllStackTraces() is forbidden in OpenSearch (needs RuntimePermission
            client().admin().cluster().prepareCancelTasks().setActions(FragmentExecutionAction.NAME).get();  
            // a null+null pair would mean the actionGet wedged past timeout.
                "Native memory grew after [" + ppl + "]: before=" + before + " after=" + after,
    // function or filter type.
            .put("arrow.memory.debug.allocator", true)
                // Brief delay so the other shards' streams have time to feed  
    @After  
            channel.sendResponse(new IllegalStateException("injected failure from " + victim));  
            try {
    }
        internalCluster().startNode();
     * failing. The data-node-side fragment tasks may keep producing for a
            NetworkDisruption.DISCONNECT
            deadlockWatchdog.shutdownNow();  
     *  
     * as 0 rows contributed, not an error. Other shards' data still aggregated.
                        throw new RuntimeException("injected mid-stream batch failure");
    }
     * release pre-sorted batches the per-query allocator leaks.  
                appender.assertAllExpectationsMatched();
     * (or sendResponseBatch) to mutate payloads. Forwards both the unary
            // terminate in bounded time.
        @Override  
import java.util.HashMap;  
                .cluster()  
                failure.set(t);
        @Override
            // + suppressed graph so the probe fails the test regardless of how deep it was
     * mid-flight and verifies the listener fires with TaskCancelledException  
     * buffers — the definitive oracle that a failure-path cleanup path missed a close.
            try {
        );
        org.opensearch.core.action.ActionListener<PPLResponse> failListener = new org.opensearch.core.action.ActionListener<>() {  
            }  
                @Override  
import org.opensearch.test.transport.MockTransportService;  
            assertNoArrowLeakSuppressed(queryFailure);  
        createAndSeedIndex();  
            throw new IllegalStateException("injected SHARD_FRAGMENT build failure for stageId=" + stage.getStageId());  
        Map<Integer, String> map = shardToNode();
        failMts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {  
            client().prepareIndex(name).setSource("value", VALUE).get();
    }
                    after <= before + 1024 * 1024  // 1MiB slack for runtime heap moves  
}
     * API: tests swap in a faulting {@link StageExecutionFactory} for a chosen
        // Task leak check — no FragmentExecutionAction tasks remain after failure.  
     */  
        deadlockWatchdog = Executors.newSingleThreadScheduledExecutor();
                assertEquals("seed not yet visible to analytics path", (long) docs * VALUE, actual);
    // coverage lives in #17 (testCoordinatorReleasesBufferOnFailure).  
    private void assertNoLeakOnSuccess(String ppl) throws Exception {
     */  
        }, 30, TimeUnit.SECONDS);  
            handler.messageReceived(request, channel, task);
     * Shape: filter excludes all rows; reduce sees empty fan-in.
            long upperBound = 300L * NUM_SHARDS * 10L;
            AtomicInteger ok = new AtomicInteger();  
            // add jitter.
            disruption.stopDisrupting();
        }
        // Bring cluster back to 3 nodes, verify a fresh query works.  
        } finally {
     */
    private static final int TOTAL_DOCS = NUM_SHARDS * DOCS_PER_SHARD_TARGET;  
    private org.apache.arrow.memory.BufferAllocator stubAllocator;
            Future<?> raceStart = exec.submit(() -> {
        createAndSeedIndex();
import java.util.concurrent.atomic.AtomicInteger;
     * failure AND the native datafusion memory pool returns to baseline (no leaked  
        MockTransportService failMts = (MockTransportService) internalCluster().getInstance(TransportService.class, failNode);
            channel.sendResponse(new RuntimeException("partial-failure-error-shard"));
                            } catch (Exception ignore) {}
        createAndSeedIndex();  
     * coordinator surfaces cancellation.
        assertThat("need ≥2 shard-host nodes", nodes.length, greaterThan(1));
     */
                                    incoming.close();
            Thread.sleep(500);  
     * wrapping channel. On the streaming path the wrapper drops every emitted
                        super.sendResponseBatch(arrow);  
        }
        if (baseline < 1024L * 1024L) {
    private String singleShardHostingNode(String indexName) {
        // Warm-up so JIT / native caches are primed and baselines reflect steady state.
        }
        // happens. We don't wait for recovery — we query immediately.  
                response.get() != null || failure.get() != null  
        createAndSeedIndex();  
        return out;
    }
        try {  
                    + "got null/null → hang. injected="
            long start = System.nanoTime();  
            if (n.equals(name) == false) return n;  
 * </ul>  
            pluginClass.getName(),
        for (String node : internalCluster().getNodeNames()) {
            .setMapping("value", "type=integer")  
                        }  
        // In-flight query may throw; that's fine.
            AtomicReference<Throwable> failure = new AtomicReference<>();
    }
     * Coordinator surfaces error without infinite drain.
import org.apache.lucene.tests.util.LuceneTestCase;
            try {
            internalCluster().clearDisruptionScheme();  
            org.opensearch.core.action.ActionListener<PPLResponse> listener = new org.opensearch.core.action.ActionListener<>() {
                // Give async drain task a moment to tick after the listener fired.  
     * #14 — Set a tiny datafusion memory pool limit and try to exceed it. Expect a
        // NativeHandle registry returns to baseline.
            } catch (Throwable t) {  
    @After  
    public void testConcurrentSuccessAndFailureDoesNotDoubleCallback() throws Exception {
        }
            );
        createSingleShardIndexOnNode(idxFail, 5, failNode);
     * DAG: 1 SHARD_FRAGMENT (passthrough — no coordinator reduce stage).
    //  
import org.opensearch.core.transport.TransportResponse;
        // child build threw.
 * org.opensearch.transport.StreamTransportService}'s registry — so injecting  
        + "main/java/org/opensearch/analytics/planner/PlannerImpl.java (planner internals). "  
        for (String n : nodes) {
            // Don't assert which of (partial success / total failure) — this test pins the contract by  
        for (int i = 0; i < TOTAL_DOCS; i++) {
        } catch (Exception e) {  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            @Override
    /**  
                Thread.sleep(200);
            }
                        if (response instanceof org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse arrow) {  
 * 3-shard, 0-replica composite-parquet index seeded with deterministic data.  
            }
import java.util.concurrent.TimeUnit;
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering(linger = 5000)
        PPLResponse r = client(coordOnly).execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest("source = " + INDEX + " | stats sum(value) as total")).actionGet(QUERY_TIMEOUT);
     * scheduled tightly with a query in-flight pins the contract: bounded failure,
            .routingTable()
                failure.set(t);  
    /**
        MockTransportService errorMts = (MockTransportService) internalCluster().getInstance(TransportService.class, errorNode);  
            .indices()  
    // Every query shape hits a different DAG topology on the coordinator. The
     * batches) rather than cross-stream termination.  
     * DAG: N SHARD_FRAGMENT producing more rows than head() needs; coordinator  
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
    /** Returns the node hosting the single primary shard of {@code indexName}. */
     * cause without traversing the reduce-stage error path.  
        } finally {
        });
                                return;
     * Bounded timeout proves the coordinator doesn't wedge across reconnect cycles.  
            };  
        });
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
            () -> assertEquals("Native memory must return to baseline after reduce failure", before, dfs.getMemoryPoolUsage()),
 * The OpenSearch Contributors require contributions made to  
            .get();
        // strands its hosted primaries with no allocation target until a recovery
            .put("index.composite.primary_data_format", "parquet")
            try {
        createAndSeedIndex();
        createAndSeedIndex();
            delegate.sendResponse(response);
                        schemaForwarded = true;
        assertBusy(() -> {  
                            incoming.setRowCount(0);  
    public void testCoordinatorNodeCrashRecovery() throws Exception {  
     * Creates + seeds the test index. Called from every test that actually issues  
        // Pick a bridge node (= isolated), two others on each side.
    }  
        ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
        }
     *  
                        }  
     * whichever behavior is actually implemented.
        try {
            if (deadlockedThreadIds != null) return;
     * test asserts that WARN never fires.
            );
                b.registerFactory(StageExecutionType.SHARD_FRAGMENT, e.getValue());  
        if (!emptyNode.equals(errorNode)) {  
                public void onFailure(Exception e) {  
            .putList("index.composite.secondary_data_formats")
            );
        // before parquet commits are durable on every shard. Tests in this suite exercise
            }, 30, TimeUnit.SECONDS);
                // its active-import window when the injected failure fires.
        createAndSeedIndex();  
        try {  
            client().prepareIndex(INDEX).setSource("value", VALUE).get();  
    }  
            try {
    }
     * satisfied by the first batch of one shard alone — the other two shards
    // native datafusion pool is at baseline within slack. Failure-path leak
     * resources. We use {@link NativeHandle#liveHandleCount()} as the
                throw new AssertionError("Arrow allocator leaked on failure path: " + cur.getMessage(), t);
            failListener
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));  
    }
                            schemaForwarded = true;
            .cluster()
                infos.isEmpty()  
     * exercise the pre-index state.
            }  
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
        } finally {  
            NetworkDisruption.DISCONNECT
                                    r.close();  
        disruption.startDisrupting();
            if (sr.primary()) {
                executePPL(
            }
// SUITE-scope default inherited from OpenSearchTestCase so failure-path leaks  
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
     * #5 — Bridge topology: one node isolated from the others, they can talk.  
            PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
     * exception on one node). The coordinator listener must fire exactly once.
            } catch (Throwable t) {
        // dataset. assertBusy until the analytics path sees the full sum, otherwise
     * Shape: multi-shard fan-in, no aggregation, no reduce.  
    // | repeated query                     | drift detection across N iterations       |
            assertNotNull("query must fail when one shard task throws", failure);
    @org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix(bugUrl = "Tighter cleanup observability for planner-stage failures. The propagation "
        client().admin().indices().prepareRefresh(name).get();
import java.util.HashSet;
        Settings indexSettings = Settings.builder()
            createAndSeedIndex();
    }
     * already covered indirectly by {@link #testPlanFailurePropagates} (#21),  
            disruption.stopDisrupting();
            .routingTable()
            NetworkDisruption.UNRESPONSIVE
            .put("index.pluggable.dataformat.enabled", true)
    public void testGroupByAggregateReleasesBufferOnSuccess() throws Exception {
        AtomicReference<Throwable> failure = new AtomicReference<>();
            // queries through the leak detector, which doesn't exercise failure paths.
        try {
                    }  
     * stops draining mid-stream. Tests that early-stop correctly closes
    // | empty result                       | filter excludes all → empty fan-in        |
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
     * onFailure) fires per query, normal or failing.  
     * first batch and the coordinator must stop pulling subsequent batches.
        } finally {
 */
                    listener
                PPLResponse r = executePPL("source = " + name + " | stats sum(value) as total");
        // Warm-up: one query primes thread pools, JIT, native runtime caches.  
                "NativeHandle live count grew after stage-build failure: baseline=" + baseline + " after=" + after,
        Set<String> sideTwo = new HashSet<>();
     * exception cleanly.
                "Listener must fire exactly once on partial-failure race; got ok=" + ok.get() + " fail=" + fail.get(),  
        String victim = singleShardHostingNode(SINGLE_SHARD_INDEX);
                );
                // race fired during reduce) or it had already completed before  
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
            exec.awaitTermination(5, TimeUnit.SECONDS);  
        createAndSeedIndex();
            }
            assertBusy(() -> assertEquals(1, ok.get() + fail.get()), QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
        disruption.startDisrupting();
     * shard's stream emits 5 batches; {@code head 1} is satisfied by the
    }
            }
        });
                exception || wrongResult
                "NativeHandle live count grew after cancel-during-reduce: baseline=" + handleBaseline + " after=" + handleAfter,  
    @Override
        client().admin()  
                response.get() != null || failure.get() != null
// Per-method leak detection: any thread spawned during a single test method that
     * one IS exercisable.
            StageExecutionFactory[] thisNodeOriginal = new StageExecutionFactory[1];  
import java.util.concurrent.ExecutorService;
     * #12 — One shard OK, one shard errors, one shard empty. Document whatever the  
     * On a child-stage failure, the coordinator-side reduce sink's drain task
                    + injected.get()  
        assertNoPendingFragmentTasks();
     * ("drain task terminated with error ... allocator is closed"); the
     */
            );
        for (int i = 0; i < docs; i++) {
     * and the {@link NativeHandle} live count back to baseline.  
                    + ", response="
            assertThat("Partial sum must be < full when a shard contributes nothing; got " + actual, actual, lessThan(EXPECTED_SUM));
    public void testEarlyTerminationLimitMultiShard() throws Exception {
            });
        assertThat("need ≥2 shard-host nodes", map.values().stream().distinct().count(), greaterThan(1L));  
     */
            "No residual UnifiedPPLExecute tasks after cancel-during-reduce: " + remaining.getTasks(),
            .setMapping("value", "type=integer")  
     *  
            failure.set(t);  
 * Resilience / fault-injection suite for the analytics-engine coordinator
                            try {  
    /**  
     * one that throws on {@code createExecution}. A real
                public void sendResponseBatch(TransportResponse response) {  
    /**  
     */
        }
                executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);  
                previousByNode.put(node, prev);  
        } finally {  
                    @Override
            .get();
            try {
        StageExecutionFactory faulting = (stage, sink, config) -> {  
        String delayNode = null;
     */
        assertScalarLong(response, "total", EXPECTED_SUM);  
        CountDownLatch released = new CountDownLatch(1);
        AtomicInteger ok = new AtomicInteger();
            );
            // The Arrow root allocator's close() throws "Memory was leaked" when any child
        // helper resolves to a cluster-wide client, so post-crash it can still
import org.opensearch.tasks.TaskInfo;  
                assertBusy(() -> assertEquals(1, ok.get() + fail.get()), QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
     *  
                long actual = ((Number) r.getRows().get(0)[r.getColumns().indexOf("total")]).longValue();  
        PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total");
                    disruption.startDisrupting();
 * SPDX-License-Identifier: Apache-2.0
    private static String dumpAllThreads() {  
        createAndSeedIndex();  
        internalCluster().setDisruptionScheme(disruption);
    /**
            if (ids != null) {  
            .prepareUpdateSettings()
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
                long after = dfs.getMemoryPoolUsage();
    }  
        java.util.ArrayDeque<Throwable> queue = new java.util.ArrayDeque<>();  
import java.util.Collections;
        }
     * past timeout, not leak FragmentExecutionAction tasks.
            assertTrue(  
    /**
            AtomicReference<Throwable> failure = new AtomicReference<>();  
            stubCalls.incrementAndGet();  
     * Mirrors the pattern in {@code CacheTests.testDependentKeyDeadlock}.
        client().execute(  
            released.countDown();
            );  
import org.opensearch.ppl.action.PPLRequest;  
            }
            .build();  
        public String getChannelType() {  
     * are unneeded. A failure to honor the limit (returns >5 rows) or a hang
                channel.sendResponse(new IllegalStateException("forced-failure for thread-leak test"));  
            }
     * NodeNotConnectedException as the test failure.
        long midpoint = baseline;  
        assertScalarLong(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT), "total", EXPECTED_SUM);
        java.util.Set<Throwable> seen = java.util.Collections.newSetFromMap(new java.util.IdentityHashMap<>());
        Future<PPLResponse> inFlight = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
    private static final int VALUE = 7;
            // Flight protocol invariant that ≥1 schema-bearing frame must precede  
     */
        @Override
     * ({@code stats sum(nonexistent_field)}) and asserts on
        });  
            try {
     * #19 — Kill a shard-hosting node after a brief disruption window, bring
        createAndSeedIndex();  
        try {
            // invariant that ≥1 schema-bearing frame must precede completeStream.
/**
        String coord = coordinatorNodeName();  
            );
        ListTasksResponse before = client().admin().cluster().prepareListTasks().setActions(FragmentExecutionAction.NAME).get();  
     * Shape: multi-input union.
            } catch (Throwable t) {
        try {  
    public void testSingleShardHappyPath() throws Exception {
    @AwaitsFix(bugUrl = "TODO")  
     * the same code path: {@code LocalStageExecutionFactory} catches and
    public void testCoordinatorSurvivesBridgePartition() throws Exception {
        ensureGreen(INDEX);  
    public void testSimpleAggregateReleasesBufferOnSuccess() throws Exception {
     * (DataFusionService, AnalyticsSearchTransportService) is properly reconstructed  
    }
                } catch (InterruptedException ie) {  
            assertBusy(() -> assertEquals(1, ok.get() + fail.get()), QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
            .putList("index.composite.secondary_data_formats")  
        assertEquals("LIMIT must produce exactly the requested row count", 1, r.getRows().size());
                listener
                response = fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);  
                queue.add(s);
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
        assertNoLeakOnSuccess("source = " + INDEX + " | where value = -999999 | stats sum(value) as total");
            AtomicInteger ok = new AtomicInteger();
            .cluster()
     * #13 — Contract under test: when a failure originates inside the coordinator  
            Throwable failure = null;
     * draining shard streams once the result limit is satisfied — it should  
                StageExecutionBuilder b = internalCluster().getInstance(QueryScheduler.class, e.getKey()).getStageExecutionBuilder();
     * returns a single zero-row Arrow batch carrying a minimal schema, then  
     *  
            try {
            UnifiedPPLExecuteAction.INSTANCE,  
            // Verify the workload was real — otherwise we'd be running 50 successful  
     * <p>Injects on every node — {@code client()} routes randomly, so every
            );
        public void completeStream() {
        createAndSeedIndex();
        try {
            } catch (Throwable t) {  
        DataFusionService dfs = internalCluster().getInstance(DataFusionService.class, coord);  
            .prepareCreate(INDEX)
        System.gc();  
            // Either a query-failure exception OR a partial-failure response;
        try {
     * Arrow leak surfaces via the result throwable, (b) the response is non-null,  
    public void testCoordinatorReleasesBufferOnFailure() throws Exception {
                    public void onResponse(PPLResponse r) {
            );
     * filter — used by tests that need each shard to land on a specific node so  
            delegate.sendResponseBatch(response);  
            exec.shutdownNow();  
            try {
                        throw new RuntimeException("injected reduce-sink feed failure");  
import java.util.concurrent.TimeoutException;  
    }
                    public void onFailure(Exception e) {
    //  
     * #32 — Listener single-callback contract: exactly one of (onResponse,
        // Native memory pool must not leak across the failed build.  
        Map<String, StageExecutionFactory> previousByNode = new HashMap<>();
import org.opensearch.be.datafusion.DataFusionService;  
        }
            }  
            .setSettings(indexSettings)
                    public void sendResponseBatch(TransportResponse response) {
        }
     * released, native handles dropped) and the query must surface the build  
        internalCluster().setDisruptionScheme(disruption);  
    public void testReduceStageFailureSurfaced() throws Exception {  
     * stream handle). This is a tighter, reduce-sink-layer assertion of the same
import org.opensearch.transport.TransportService;
     * Delegating {@link TransportChannel} whose subclasses override sendResponse  
            StageExecutionFactory perNodeFaulting = (stage, sink, qctx) -> {
        // Sample task list before to detect any leak after.
 * <p>Covers four failure domains:  
        // dispatch against a surviving node.
    // -------------------------------------------------------------- helpers
        String victim = pickShardHostingNode();
            assertTrue("Coordinator must complete or fail within " + QUERY_TIMEOUT, response.get() != null || failure.get() != null);  
            // Mirrors LocalStageExecutionFactory's wrapping when ExchangeSinkProvider.createSink throws.
        public org.opensearch.Version getVersion() {
        );  
    /**  
        assertBusy(() -> {
    }  
 *  
    private static class ForwardingChannel implements TransportChannel {
                                } catch (Exception ignore) {}  
     * mid-construction. Earlier stages must close (their backend sinks are
 * compatible open source license.
        }  
     * per-node {@link MockTransportService} injection targets exactly one leg.
        } finally {  
        String coordOnly = internalCluster().startCoordinatingOnlyNode(Settings.EMPTY);
            long actual = ((Number) response.getRows().get(0)[response.getColumns().indexOf("total")]).longValue();  
            }  
            AtomicReference<Throwable> failure = new AtomicReference<>();
     * <p>The assertion is timing: the query must terminate well within the  
                "Native memory grew after cancel: baseline=" + memBaseline + " after=" + memAfter,  
            // stops, so assertions about recovery don't wait the 10s default.
     * with a bounded error (good) or hang past the request timeout (bug)?
        } finally {  
                                try {
     * into {@code channel.sendResponse(exception)}, which the coordinator
        );  
     * #34 — Coordinator memory stable across many queries. 50 successful queries
                );
        createAndSeedIndex();
            PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);  
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();  
            internalCluster().clearDisruptionScheme();
                public void onFailure(Exception e) { fail.incrementAndGet(); }
     * Universal happy-path leak probe. Runs {@code ppl} once; asserts (a) no
        NetworkDisruption.NetworkDelay delay = new NetworkDisruption.NetworkDelay(TimeValue.timeValueMillis(300));
                fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);  
     */
 *
            Throwable failure = null;
            assertNotNull("query must fail when one UNION leg's shard throws", failure);
            } catch (InterruptedException ie) {
        bugUrl = "https://github.com/opensearch-project/OpenSearch/pull/21711 — flaky on CI: cluster fails to form"
        String[] nodes = internalCluster().getNodeNames();
    public void testNoDataReturnedFromShard() throws Exception {
@TestLogging(reason = "debugging resilience behavior", value = "org.opensearch.analytics:DEBUG")  
            } catch (Throwable t) {
     * snapshot — connections re-established via the periodic
        }, 30, TimeUnit.SECONDS);
     */
     * Early-termination via LIMIT across shards. The coordinator must stop
        }
        assertNotNull("query must return a response: " + ppl, response);  
            PPLResponse r = executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);  
        // Force multiple batches per shard so the coordinator has to honor  
    }  
            assertTrue(
        }
            vsr.allocateNew();
    /**  
        });  
                    @Override  
    // | sort with pushdown                 | N partial sort → 1 merge sort REDUCE      |
                // Empty-shard stub on the streaming path: forward one zero-row
            assertBusy(() -> {
        executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
                .setPersistentSettings(Settings.builder().putNull(DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT.getKey()))
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
     * up through {@code failWithCause}; the cascade's parent-state listener then
import org.opensearch.be.datafusion.DataFusionPlugin;
                // post-conditions below.
        }
            } catch (Throwable t) {
        );
    }  
import org.opensearch.test.disruption.NetworkDisruption;
                ActionListener<PPLResponse> listener = new ActionListener<>() {  
     * #G1 — Single-shard happy path. With one shard the planner emits a  
        if (deadlockWatchdog != null) {
            assertEquals(
     */
        String coord = coordinatorNodeName();
            assertNotNull("Build failure must surface to the listener (got null failure)", failure.get());
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters(filters = FlightTransportThreadLeakFilter.class)
            } catch (Throwable t) {
        PPLResponse r = executePPL("source = " + INDEX + " | head 5", QUERY_TIMEOUT);  
                        // existing allocator ownership, then forwards as the shard's single contribution.  
    }  
     * sibling-side delay, proving the sibling didn't just naturally complete.
        org.opensearch.core.action.ActionListener<PPLResponse> okListener = new org.opensearch.core.action.ActionListener<>() {
    /**
     */
        });
        } finally {  
        }
            .setTransientSettings(Settings.builder().put("datafusion.indexed.batch_size", 10))  
     * Derive the coordinator-side node name — the node that the default
                    }
     * (data-node held on a latch so the cancel always lands before reduce starts).  
            );
        assertEquals("normal query: zero onFailure", 0, failCount.get());
                memAfter <= memBefore + 1024 * 1024  // 1MiB slack for runtime heap moves (matches #17)
        // Post-heal: query returns correct sum.  
                            org.apache.arrow.vector.VectorSchemaRoot r = arrow.getRoot();  
            }  
        // the body before the disruption-removal line runs.
                failure.set(t);
    @Override
        CountDownLatch holdShard = new CountDownLatch(1);  
            assertTrue(
        AtomicBoolean injected = new AtomicBoolean(false);
    }
                    failed++;  
        ExecutorService exec = Executors.newSingleThreadExecutor();
        createAndSeedIndex();
        } catch (Exception e) {
    /** #2 — UNRESPONSIVE: drops packets silently; coordinator should hit its own timeout, not spin. */  
        String failNode = nodes[0];  
    public void testMultiChildStageFailureCancelsRunningSibling() throws Exception {  
        } finally {
        Thread.sleep(50);
        int handleBaseline = NativeHandle.liveHandleCount();  
            new NetworkDisruption.TwoPartitions(Collections.singleton(coordinatorNodeName()), Collections.singleton(victim)),
                )
     * (5 per shard). Fix is in the planner, not the reduce-sink lifecycle —
     * union has two child sub-trees. The fail-leg's shard task throws, propagating
            if (sr.primary()) {
                    }
     * #24 — Fail during exchange-sink registration: the coordinator-reduce  
     * reduce sink (i.e. {@code DatafusionReduceSink}, the in-process component fed
            // empty source (acceptable for this fix — propagating SHARD_FRAGMENT FAILED
    /**
     * {@link ForwardingChannel} that counts {@code sendResponseBatch} calls and
        + "assertion on coordinator registered-state cleanup (pending executions, query "  
        ensureFullyConnected();
        assertEquals("failing query: exactly one onFailure", 1, fail2.get());  
        internalCluster().setDisruptionScheme(disruption);
            AtomicReference<Throwable> failure = new AtomicReference<>();
        + "opensearch/analytics/exec/DefaultPlanExecutor.java (transport entry, around the "
        String failNode = pickShardHostingNode();  
        System.gc();
                executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);  
            response = executePPL(ppl, QUERY_TIMEOUT);  
     * throughput-independent — won't false-positive on transient contention because  
            .put(FeatureFlags.STREAM_TRANSPORT, true)  
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {  
    private static final TimeValue QUERY_TIMEOUT = TimeValue.timeValueSeconds(30);  
            assertBusy(() -> {
        AtomicInteger okCount = new AtomicInteger();
        } finally {  
        createAndSeedIndex();
import org.opensearch.analytics.planner.dag.StageExecutionType;
                "partial-failure outcome: response={} failure={}",  
     * {@link FragmentExecutionAction#NAME} is registered only on the streaming
        assertThat(column, ((Number) cell).longValue(), equalTo(expected));
        } finally {
        }
                    + "s; if this approaches the latch timeout, onTaskTerminal is still waiting for all tasks",
            extendedPlugins,
        ensureFullyConnected();  
            disruption.stopDisrupting();
    /**  
     * Multi-child stage failure must cascade UP to the parent and DOWN to the
    public void testCoordinatorPropagatesStageFailure() throws Exception {
            public void onFailure(Exception e) {
                }
            mts.clearAllRules();  
            };  
                long actual = ((Number) r.getRows().get(0)[r.getColumns().indexOf("total")]).longValue();
            Thread.sleep(150);
            assertTrue(
            if (thisNodeOriginal[0] != null) {
        }  
            if (n.equals(bridge)) continue;
            sb.append('\n').append(info.toString());
            released.countDown();
        try {  
            delay
            faultCount.incrementAndGet();
            int after = NativeHandle.liveHandleCount();
        Map<String, StageExecutionFactory> previousByNode = new HashMap<>();  
        );
        // Fire a query then attempt to kill the coordinator — note: the client()  
                previousByNode.put(node, prev);  
            .prepareUpdateSettings()  
            assertNotNull("failure must carry a cause", failure.get());
     * completes the stream. Coordinator must still produce a valid (smaller)
        assertBusy(() -> {
            @Override
    public void stopDeadlockWatchdog() throws InterruptedException {
     * Used by the multi-batch early-termination test, which lowers the DataFusion
        return List.of(
        try {
    }
                "UNRESPONSIVE query must not exceed " + QUERY_TIMEOUT.seconds() + "s; took " + elapsedMs + "ms",
            });
        try {
     * side state (none, in this case — the reduce stage builds before any  
        String idxFail = "sibling_leg_fail";  
        CreateIndexResponse response = client().admin()
            AtomicReference<PPLResponse> response = new AtomicReference<>();
     * queries. Kept out of {@code @Before} because a couple of tests want to
            if (response.get() != null) {
    }  
     * <p>With {@link #NUM_SHARDS}=3 and ~10 docs/shard, {@code head 5} can be  
        MockTransportService failMts = (MockTransportService) internalCluster().getInstance(TransportService.class, failNode);
     * #30 — Cancel during the reduce stage. Complements
            .put("index.routing.allocation.require._name", nodeName)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 3, numClientNodes = 0, supportsDedicatedMasters = false)
                    public void feed(VectorSchemaRoot batch) {
     * interrupts the latched handler on the delay node.
            Thread.sleep(200);
            client().execute(
                "drain task terminated with closed allocator",  
            // Cancel any in-flight analytics tasks.
        }
                        fail.incrementAndGet();
            };
            false  
            .setSettings(indexSettings)
     * residual PPL parent task, native datafusion memory pool back to baseline,
        Thread.sleep(50);
        );
                faultCount.get() >= 1  
        while (!queue.isEmpty()) {  
        // No zombie fragment tasks anywhere in the cluster.  
            mts.clearAllRules();  
        }, 1, 1, TimeUnit.SECONDS);  
     * {@code LocalStageExecution.failWithCause} fired the walker terminal  
     * Coordinator must surface a clear "no shard available" error.  
            try {  
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
        // backpressure mid-stream. NodeScope dynamic — TEST cluster scope
            }
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
            internalCluster().clearDisruptionScheme();  
    /** Verify no residual FragmentExecutionAction tasks anywhere in the cluster. */
            }
     *
            }
        }
            .build();  
            mts.clearAllRules();
     * #11 — Shard returns empty response (zero batches). Coordinator must treat it  
            + " observed CI seeds; #21711 attempted a teardown fix (ensureGreen) but did not land. Unmute when the"
            try {  
                failure.set(t);
            @Override
     * batch but forwards completeStream — the coordinator sees the shard  
                    executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
                "Faulting SHARD_FRAGMENT scheduler must have fired at least once (failure=" + failure.get() + ")",
     * #G2 — Single-shard shard-failure surfacing. With no reduce stage the failure  
            null,
                }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }  
        createAndSeedIndex();
            delegate.sendResponse(exception);
    /**
     * (pending executions, fragment-task accounting, query-context entries) so  
    }  
     * DAG: N SHARD_FRAGMENT → 1 LOCAL_PASSTHROUGH (concatenate batches).
        ForwardingChannel(TransportChannel delegate) {
        @Override  
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
     * retry until success or 30s. Tests that assume a healed cluster (post-
                Level.WARN,
                "UNRESPONSIVE must produce a failure or partial result, not a silent null",
                client().execute(
        internalCluster().startNode();
        CreateIndexResponse response = client().admin()
        for (String node : internalCluster().getNodeNames()) {  
        try {  
    }
            assertTrue(
            );  
            TestPPLPlugin.class,  
     */
            StageExecutionBuilder b = internalCluster().getInstance(QueryScheduler.class, node).getStageExecutionBuilder();  
            AtomicReference<PPLResponse> response = new AtomicReference<>();
                    "Native memory usage grew after failure: before=" + before + " after=" + after,
        );  
                        if (schemaForwarded) {
            // Pin the behavior — whichever path the coordinator takes, it must
                fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);  
            // easily blow this. Generous slack because cold-start parquet reads  
                failure.set(t);  
        CountDownLatch released = new CountDownLatch(1);
                    + " batches="
            assertTrue(
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
            long elapsedMs = (System.nanoTime() - start) / 1_000_000L;
                "Coordinator must terminate (failure or response) after mid-stream batch error; "
            CancelTasksResponse cancel = client().admin().cluster().prepareCancelTasks().setActions(UnifiedPPLExecuteAction.NAME).get();  
    // below probes one representative query per topology so the suite covers
        try {  
     * {@code ExchangeSinkProvider.createSink} failure (e.g. the backend
    }  
        }
     * to the caller and the coordinator-side native pool must return to
        createAndSeedIndex();
import java.util.Map;  
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
            fail("JVM-detected deadlock cycle in " + deadlockedThreadIds.length + " thread(s):\n" + dumpAllThreads());
    }  
     * DAG: N SHARD_FRAGMENT (partial sum) → 1 COORDINATOR_REDUCE (final sum).  
        createSingleShardIndexOnNode(idxDelay, 5, delayNode);  
            stubAllocator.close();  
        createAndSeedIndex();
        assertBusy(() -> assertEquals(1, okCount.get() + failCount.get()), QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
            boolean wrongResult = false;  
