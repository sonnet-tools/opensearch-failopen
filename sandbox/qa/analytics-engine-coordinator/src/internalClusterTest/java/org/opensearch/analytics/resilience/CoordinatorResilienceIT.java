        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(victim));
     */
import org.apache.logging.log4j.Level;
            }
     * via {@link DataFusionService#getMemoryPoolUsage()} which covers the native
     * rather than wait for the blocked sibling. Failure propagates upward; the
        } finally {
import org.opensearch.test.InternalTestCluster;
                    + ", failure="
            assertNotNull("coordinator must produce a response when one shard is empty", response);
    /** Return one node name that currently hosts a primary of {@link #INDEX}. */
    @After
    // | repeated query                     | drift detection across N iterations       |
            .putList("index.composite.secondary_data_formats")
    public void testEmptyResultReleasesBufferOnSuccess() throws Exception {
            try {
    //
     * Sort buffers travel through the reduce; if the merge step fails to
                        if (response instanceof org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse arrow) {
        ensureFullyConnected();
        System.gc();
    // ---------------------------------------------------- A: network-level faults
        System.gc();
        ensureGreen(name);
            assertScalarLong(response, "total", EXPECTED_SUM);
            }
            } catch (Throwable t) {
            Thread.sleep(500);
     *
        String victim = pickShardHostingNode();
            .putList("index.composite.secondary_data_formats")
            Version.CURRENT,
            PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
     * one IS exercisable.
        + "same path with a real planner-rejecting query. What this test would add is direct "
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .put(FeatureFlags.STREAM_TRANSPORT, true)
            assertNotNull("coordinator must produce a response when one shard contributes nothing", response);
    // ---------------------------------------------------------------- fixture
     * to the disconnected-shard state, then the heal+kill validates the
        } catch (Exception e) {
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
            Thread.sleep(500);
            }
            } catch (Throwable t) {
import java.util.concurrent.ScheduledExecutorService;
    public void testEarlyTerminationLimitMultiShard() throws Exception {
            + " teardown race as testCoordinatorSurvivesIntermittentNetwork. Unmute when fixed upstream."
        String coord = coordinatorNodeName();
            // Slack of 10× delay per shard — a quadratic-in-delay coordinator would
    // -------------------------------------------- G: single-shard / no-reduce-stage
        }, 30, TimeUnit.SECONDS);
                "stage must fail-fast on first failure and not wait for the blocked sibling — elapsed=" + elapsedSec
     * Shape: filter excludes all rows; reduce sees empty fan-in.
            } catch (InterruptedException ie) {
        PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total");
        + "natural call sites are sandbox/plugins/analytics-engine/src/main/java/org/"
    public void testSingleShardShardFailureSurfaced() throws Exception {
import org.opensearch.test.OpenSearchIntegTestCase;
        // Special case: tiny / zero baseline. Use absolute-only to avoid 1.10 × 0 = 0.
import org.opensearch.analytics.exec.stage.StageExecutionFactory;
            assertTrue(
        String victim = firstNonMatching(coord);
        assertEquals("normal query: zero onFailure", 0, failCount.get());
            if (deadlockedThreadIds != null) return;
            @Override
     * {@code datafusion.indexed.batch_size=10} and 50 docs in one shard, the
                // post-conditions below.
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
            assertTrue(
     * post-condition oracle.
                ok.get() + fail.get()
    /**
        );
            assertNotNull("query must fail when one UNION leg's shard throws", failure);
     * must NOT see a closed query allocator. Reproduces a race where
     * Shape: multi-input union.
    private ScheduledExecutorService deadlockWatchdog;
            } catch (InterruptedException ie) {
// immediately at the offending method instead of being aggregated to suite end.
    private volatile long[] deadlockedThreadIds;
        try {
                "Injection must reach victim node before termination (thrown="
                after <= before + 1024 * 1024
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
            failMts.clearAllRules();
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
                            schemaForwarded = true;
        for (ShardRouting sr : clusterService().state()
        PPLResponse r = client(coordOnly).execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest("source = " + INDEX + " | stats sum(value) as total")).actionGet(QUERY_TIMEOUT);
                                incoming.close();
        }
        Future<PPLResponse> inFlight = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
            return delegate.getChannelType();
            .get();
            );
            // Single callback regardless of outcome.
        AtomicInteger ok = new AtomicInteger();
            client().prepareIndex(name).setSource("value", VALUE).get();
                    + response.get()
    public void testCoordinatorReleasesBufferOnFailure() throws Exception {
            });
        }
    /**
            }
        createAndSeedIndex();
     * small to surface at N=1 becomes obvious. Leak detection itself comes
        assertEquals(
        AtomicBoolean injected = new AtomicBoolean(false);
        AtomicInteger faultCount = new AtomicInteger();
        ExecutorService exec = Executors.newSingleThreadExecutor();
        client().admin().indices().prepareRefresh(name).get();
        assertNoLeakOnSuccess("source = " + INDEX + " | head 1");
        }
     * batch but forwards completeStream — the coordinator sees the shard
            int handleAfter = NativeHandle.liveHandleCount();
            .put("index.pluggable.dataformat.enabled", true)
     * <p>Note: the kill is performed AFTER the disruption stops (not during)
            if (n.equals(bridge)) continue;
            }
    /**
    }
     * top is tighter cleanup-state observability (registered-state accessors on
            // silently returning EXPECTED_SUM, since the producer never delivered rows.
            // content with a zero-row batch that still carries the shard's schema. Honors the
    /**
            AtomicReference<Throwable> failure = new AtomicReference<>();
     */
            .get();
            assertTrue("Tiny memory limit must surface as failure or bounded response", response.get() != null || failure.get() != null);
    }
        );
                failure.set(t);
     * isolate the coordinator vs. workers.
     * Shape: multi-shard fan-in, no aggregation, no reduce.
            long elapsedSec = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startNs);
            AtomicReference<PPLResponse> response = new AtomicReference<>();
     * the listener. Verifies the failure path doesn't hang and surfaces a non-null
        long baseline = dfs.getMemoryPoolUsage();
            } catch (Throwable t) {
     * API: tests swap in a faulting {@link StageExecutionFactory} for a chosen
            );
        // the listener-single-callback contract holds.
            disruption.stopDisrupting();
        assertBusy(() -> {
        }
        );
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(victim));
        internalCluster().setDisruptionScheme(disruption);
    private String pickShardHostingNode() {
    /** Allocator for Arrow buffers produced by stubbed-handler tests; closed after each test. */
        }
     * {@link #testCoordinatorPropagatesStageFailure} (#8) — only the injection
                deadlockedThreadIds = ids;
     * <p>Pins the coordinator's contract: under disconnect, does the query fail
            });
            .put("index.composite.primary_data_format", "parquet")
                break;
        }
    /**
                // the coordinator-side reduce sink, putting the drain task in
                failure.set(t);
     * shard's stream emits 5 batches; {@code head 1} is satisfied by the
            }
     * <p>Injects on every node — {@code client()} routes randomly, so every
            assertTrue(
        @Override
            long startNs = System.nanoTime();
        MockTransportService emptyMts = (MockTransportService) internalCluster().getInstance(TransportService.class, emptyNode);
     * the same code path: {@code LocalStageExecutionFactory} catches and
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(coord));
    /**
        } finally {
                fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
     * (no response within {@link #QUERY_TIMEOUT}) both fail this test.
    public void testSimpleAggregateReleasesBufferOnSuccess() throws Exception {
    /**
            try {
        // Race window: schedule disruption start ~50ms after we begin dispatch.
            .setSettings(indexSettings)
     *
     */
     */
                assertBusy(() -> assertEquals(1, ok.get() + fail.get()), QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
    public void testCoordinatorMemoryStablesAcrossManyQueries() throws Exception {
            client().admin().cluster().prepareCancelTasks().setActions(FragmentExecutionAction.NAME).get();
     */
            mts.clearAllRules();
                StageExecutionBuilder b = internalCluster().getInstance(QueryScheduler.class, e.getKey()).getStageExecutionBuilder();
     * (with 0 replicas), then immediately query before recovery completes.
            List<TaskInfo> infos = tasks.getTasks();
        createAndSeedIndex();
     * filter — used by tests that need each shard to land on a specific node so
            assertThat("Partial sum must be ≥ 0 given the other two shards' contribution", actual, greaterThan(-1L));
     * <p>The assertion is timing: the query must terminate well within the
        String coord = coordinatorNodeName();
            }
                    QUERY_TIMEOUT
     * the user-visible response must arrive promptly with exactly LIMIT rows.
 * transport's request-handler registry AND the {@link
        }
     */
                originalByNode.put(node, thisNodeOriginal[0]);
            exec.shutdownNow();
        assertNoLeakOnSuccess(
            disruption.startDisrupting();
import java.util.concurrent.Future;
     */
        // Native handle registry must return to baseline — the partial-build
import static org.hamcrest.Matchers.lessThan;
    /** Verify no residual FragmentExecutionAction tasks anywhere in the cluster. */
import org.opensearch.ppl.action.PPLRequest;
     * #11 — Shard returns empty response (zero batches). Coordinator must treat it
        org.opensearch.core.action.ActionListener<PPLResponse> failListener = new org.opensearch.core.action.ActionListener<>() {
        createSingleShardIndexOnNode(idxFail, 5, failNode);
                    fail.incrementAndGet();
     * Asserts the full resource-release contract: no zombie fragment tasks, no
                    public void close() {
    }
     */
            vsr.setRowCount(0);
        PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total");
     * LOCAL_PASSTHROUGH stage instead of LOCAL_REDUCE, so neither
        // scheduler on every node so the build failure is reproducible
        }
    public void testPartialFailure() throws Exception {
                elapsedSec,
        deadlockWatchdog = Executors.newSingleThreadScheduledExecutor();
    // ----------------------------------------------- C2: query-shape leak matrix
        Thread.sleep(50);
                "feed() failure must surface (got response=" + response.get() + ", failure=" + failure.get() + ")",
    public void testReduceStageFailureSurfaced() throws Exception {
        String failNode = nodes[0];
                    }
     * Shape: aggregation with grouping key.
        });
     */
        } catch (Exception e) {
            );
     * delegating to the real handler and capturing the field names through a
    /**
            try {
     * {@code LocalStageExecution.failWithCause} fired the walker terminal
    /**
     * satisfied by the first batch of one shard alone — the other two shards
            }
                        // existing allocator ownership, then forwards as the shard's single contribution.
        String coord = coordinatorNodeName();
        ExecutorService exec = Executors.newSingleThreadExecutor();
     * little longer (their batches get dropped on the coordinator side), but
            try {
        String emptyNode = hosts.length > 1 ? hosts[1] : hosts[0];
        // info plus monitor/synchronizer ownership for diagnosing deadlocks.
            assertEquals("single-shard failure must not also produce onResponse", 0, ok.get());
                }
            channel.sendResponse(new IllegalStateException("injected failure from " + victim));
 *   <li>A. Network-level transport faults (NetworkDisruption: disconnect,
        }
                holdShard.await(20, TimeUnit.SECONDS);
            // a null+null pair would mean the actionGet wedged past timeout.
        executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
    }
                assertTrue(
        // the body before the disruption-removal line runs.
     * fail the query (surface the cause) in bounded time.
            // queries through the leak detector, which doesn't exercise failure paths.
            new NetworkDisruption.TwoPartitions(Collections.singleton(coord), Collections.singleton(victim)),
            faultCount.incrementAndGet();
                fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
                }
            .index(indexName)
            delayMts.clearAllRules();
     */
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
                // Empty-shard stub on the streaming path: forward one zero-row
     * #34 — Coordinator memory stable across many queries. 50 successful queries
            thrown.set(true);
        }
                lessThan(siblingDelaySeconds / 2)
                failure.set(t);
        }
            mts.clearAllRules();
            try {
     * already-built reduce stage must be cancelled, releasing its native
     * throws on the 4th. The production handler's outer catch turns the throw
        assertScalarLong(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT), "total", EXPECTED_SUM);
                "Native memory grew after exchange-sink build failure: before=" + memBefore + " after=" + memAfter,
     * {@link FragmentExecutionAction#NAME} is registered only on the streaming
import org.opensearch.cluster.NodeConnectionsService;
        delayMts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
import org.opensearch.Version;
        String victim = firstNonMatching(coordinatorNodeName());
        ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
     * <p>Production data-node iterator ({@code DatafusionResultStream.BatchIterator}) yields
            .routingTable()
            new NetworkDisruption.TwoPartitions(Collections.singleton(coord), Collections.singleton(victim)),
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
        assertBusy(
     * throughput-independent — won't false-positive on transient contention because
     * resources. We use {@link NativeHandle#liveHandleCount()} as the
            exec.awaitTermination(5, TimeUnit.SECONDS);
            for (Map.Entry<String, StageExecutionFactory> e : previousByNode.entrySet()) {
                @Override
    private static final TimeValue QUERY_TIMEOUT = TimeValue.timeValueSeconds(30);
                int idx = response.get().getColumns().indexOf("total");
        }
            long start = System.nanoTime();
            assertBusy(() -> assertEquals(1, ok.get() + fail.get()), QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
    /**
     * No test-only static hook, no private-field reflection.
            channel.sendResponse(new org.opensearch.core.tasks.TaskCancelledException("shard-cancelled-during-test"));
            try {
     * does not drift more than max(5 MiB, 10%) above baseline.
                )
        assertScalarLong(response, "total", EXPECTED_SUM);
     */
            holdShard.countDown();
    }
    /**
            }
                            org.apache.arrow.vector.VectorSchemaRoot incoming = arrow.getRoot();
                failCount.incrementAndGet();
            failListener
    /**
import java.util.concurrent.atomic.AtomicBoolean;
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering(linger = 5000)
            assertTrue(
        }, 30, TimeUnit.SECONDS);
 *
        }, 30, TimeUnit.SECONDS);
            .indices()
    public void testStageFailureDoesNotLeakAllocator() throws Exception {
        failMts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
        }
    }
            AtomicReference<Throwable> failure = new AtomicReference<>();
        try {
            channel.sendResponse(new RuntimeException("partial-failure-error-shard"));
            UnifiedPPLExecuteAction.INSTANCE,
        String errorNode = hosts[0];
     * without hanging — exercises cancellation through the passthrough stage
        Settings indexSettings = Settings.builder()
        try {
            // it on here so Arrow's BaseAllocator.DEBUG picks up `true` at class init
import org.apache.logging.log4j.LogManager;
        createAndSeedIndex();
        Map<String, StageExecutionFactory> previousByNode = new HashMap<>();
import org.apache.arrow.vector.VectorSchemaRoot;
    /**
            return delegate.getVersion();
        }
        // Hold the shard handler so the query stays in flight long enough to cancel.
                assertEquals("seed not yet visible to analytics path", EXPECTED_SUM, actual);
     * when the client is re-bound.
            .put("index.pluggable.dataformat.enabled", true)
                new org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse(vsr)
            boolean exception = failure.get() != null;
        };
                "NativeHandle live count grew after cancel-during-reduce: baseline=" + handleBaseline + " after=" + handleAfter,
        executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
            assertTrue("Coordinator must complete or fail within " + QUERY_TIMEOUT, response.get() != null || failure.get() != null);
            }
                executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
            throw new IllegalStateException("injected SHARD_FRAGMENT build failure for stageId=" + stage.getStageId());
            internalCluster().clearDisruptionScheme();
        assertBusy(() -> NetworkDisruption.ensureFullyConnectedCluster(internalCluster()), 30, TimeUnit.SECONDS);
        try {
            .cluster()
     * completes the stream. Coordinator must still produce a valid (smaller)
        }
            client().admin()
     * DAG: N partial-agg-with-key → 1 final-agg-with-key. Distinct from simple
    /**
                queue.add(s);
            new NetworkDisruption.TwoPartitions(Collections.singleton(coord), Collections.singleton(victim)),
            }
    private String singleShardHostingNode(String indexName) {
        client().admin().indices().prepareFlush(name).get();
                @Override
     * {@link #testTaskCancellationAtCoordinator} (#10), which uses a held latch to
                        ok.incrementAndGet();
        queue.add(t);
     * #23 — Inject a failure during stage build so earlier stages are
     * by every shard's stream output), the query terminates with a propagated
     * #24 — Fail during exchange-sink registration: the coordinator-reduce
import org.opensearch.analytics.exec.action.FragmentExecutionAction;
 * which path the analytics dispatcher uses.
    }
            public void onFailure(Exception e) {
            .put("index.pluggable.dataformat.enabled", true)
            StageExecutionFactory prev = b.registerFactory(StageExecutionType.COORDINATOR_REDUCE, faulting);
            }
        DataFusionService dfs = internalCluster().getInstance(DataFusionService.class, coordinatorNodeName());
                Thread.currentThread().interrupt();
                "Faulting COORDINATOR_REDUCE scheduler must have fired at least once (failure=" + failure.get() + ")",
        }
    }
            long memAfter = dfs.getMemoryPoolUsage();
        };
    /**
     * (data-node held on a latch so the cancel always lands before reduce starts).
    }
            internalCluster().clearDisruptionScheme();
        createAndSeedIndex();
     */
        disruption.startDisrupting();
            pluginClass.getName(),
                            if (schemaForwarded) {
            Thread.sleep(300);
        } catch (Exception e) {
            + " global-checkpoint race during cluster recovery after NetworkDisruption. Passes locally with both"
        );
// Per-method leak detection: any thread spawned during a single test method that
                // Cancellation not propagated — assertion below pins that. Some codepaths
                            if (incoming == null) return;
            if (!n.equals(failNode)) {
 * compatible open source license.
            assertNotNull("query must fail when one shard task throws", failure);
        for (int i = 0; i < docs; i++) {
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
     */
                                } catch (Exception ignore) {}
     *
            AtomicReference<PPLResponse> response = new AtomicReference<>();
    @Override
import org.opensearch.analytics.AnalyticsPlugin;
     * propagates straight from the shard fragment through the passthrough stage to
                        injected.set(true);
 *
     * #14 — Set a tiny datafusion memory pool limit and try to exceed it. Expect a
            // + suppressed graph so the probe fails the test regardless of how deep it was
        createAndSeedIndex();
                    public void onResponse(PPLResponse r) {
        createAndSeedIndex();
            // Let dispatch get out, then disrupt mid-stream.
        }
            try {
     */
     * #9 — Cancel the data-node fragment task mid-flight. Data-node task goes away,
                "Listener must fire exactly once on partial-failure race; got ok=" + ok.get() + " fail=" + fail.get(),
    private org.apache.arrow.memory.BufferAllocator stubAllocator;
                UnifiedPPLExecuteAction.INSTANCE,
            } catch (Throwable t) {
        createAndSeedIndex();
        String victim = pickShardHostingNode();
import org.opensearch.analytics.backend.jni.NativeHandle;
        // happens. We don't wait for recovery — we query immediately.
        } finally {
        String victim = pickShardHostingNode();
     * naturally so the cancel races against an active or just-completed reduce
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 3, numClientNodes = 0, supportsDedicatedMasters = false)
            assertNotNull("failure must carry a cause", failure.get());
        assertNoPendingFragmentTasks();
                "Native memory grew after [" + ppl + "]: before=" + before + " after=" + after,
                failure.set(t);
            }
     * (sendResponse) and streaming (sendResponseBatch + completeStream)
            }
        );
                } catch (Throwable expected) {
                midpoint = dfs.getMemoryPoolUsage();
            channel.sendResponse(new IllegalStateException("single-shard injected failure"));
            // completeStream — subsequent batches are dropped.
            // sendResponseBatch transfers buffer ownership to the wire. Honors the Flight protocol
            handler.messageReceived(request, channel, task);
            okListener
     * <p>This test exercises the partial-build cleanup path in
            }
import static org.hamcrest.Matchers.greaterThan;
            // invariant that ≥1 schema-bearing frame must precede completeStream.
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet();
        try {
                    ok.incrementAndGet();
                executePPL(
        );
        // Warm-up: prime native pools / JIT so the baseline reflects steady state.
            );
    // ----------------------------------------------- D: shutdown-restart flavor
        String victim = firstNonMatching(coord);
    }
            MockCommitterEnginePlugin.class
            .put("index.composite.primary_data_format", "parquet")
            throw new RuntimeException(
     * (or sendResponseBatch) to mutate payloads. Forwards both the unary
        PPLResponse response = null;
import org.opensearch.transport.TransportChannel;
            disruption.stopDisrupting();
        if (!emptyNode.equals(errorNode)) {
                        if (incoming == null) return;
            released.countDown();
            );
     */
            + " core cluster-coordination race is fixed."
        }
        ensureFullyConnected();
        } catch (Throwable t) {
                    listener
    private static final long EXPECTED_SUM = (long) TOTAL_DOCS * VALUE;
            } catch (Throwable t) {
    // a new DAG topology lands — joins, window, etc. — not for each new agg
     * still alive {@code linger}ms after the method returns.
        DataFusionService dfs = internalCluster().getInstance(DataFusionService.class, coordinatorNodeName());
                ActionListener<PPLResponse> listener = new ActionListener<>() {
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
    }
        assertNoLeakOnSuccess("source = " + INDEX + " | where value = " + VALUE);
        };
            mts.clearAllRules();
        @Override
        internalCluster().setDisruptionScheme(disruption);
     * Flight handler always sends ≥1 schema-bearing frame before completeStream — the empty-shard
    /**
     * (no reduce-stage drain to wait on).
        } finally {
    @AwaitsFix(bugUrl = "TODO")
        } finally {
     * then a child {@code SHARD_FRAGMENT} build throws — at which point the
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
            assertBusy(() -> {
     * serial blocking).
                    }
 *
    /**
    }
     * handler runs, the data node never produces real data. Instead the stub
        assertNotNull("PPLResponse must not be null", response);
            logger.info(
        });
     * once a second; if the JVM reports a monitor cycle anywhere in the test JVM,
                // Brief delay so the other shards' streams have time to feed
import org.opensearch.cluster.metadata.IndexMetadata;
                    public void onFailure(Exception e) {
    // ---------------------------------------------------- B: application-layer stubbing
                    "total",
     * Coordinator surfaces error without infinite drain.
     * failure AND the native datafusion memory pool returns to baseline (no leaked
                "UNRESPONSIVE query must not exceed " + QUERY_TIMEOUT.seconds() + "s; took " + elapsedMs + "ms",
            // Either a query-failure exception OR a partial-failure response;
    /**
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;
            try {
        createAndSeedIndex();
            }
    private static final int DOCS_PER_SHARD_TARGET = 10;
// is still alive 5s after the method returns fails the test. Overrides the
                elapsedMs < upperBound
    public void testWithinStageTaskFailureFailsFastWithoutWaitingForSiblings() throws Exception {
                failure.get() == null ? "null" : failure.get().getClass().getSimpleName()
        + "already covered indirectly by testPlanFailurePropagates (#21), which exercises the "
        try {
                PPLResponse r = executePPL("source = " + INDEX + " | stats sum(value) as total");
        assertNoLeakOnSuccess("source = " + INDEX + " | stats sum(value) as total by value");
        }
        String victim = pickShardHostingNode();
    public void testTaskCancellationAtCoordinator() throws Exception {
     * Arrow leak surfaces via the result throwable, (b) the response is non-null,
            );
            } catch (InterruptedException ie) {
            released.countDown();
        createAndSeedIndex();
        }
     * coordinator surfaces cancellation.
        assertBusy(() -> {
    public void testConcurrentSuccessAndFailureDoesNotDoubleCallback() throws Exception {
     * (c) native pool is back to baseline within 1MiB slack. Used by every
            }, 30, TimeUnit.SECONDS);
import org.apache.logging.log4j.Logger;
        ForwardingChannel(TransportChannel delegate) {
            channel.sendResponse(new IllegalStateException("listener-race-injection"));
            disruption.stopDisrupting();
     */
            NetworkDisruption.DISCONNECT
            // After release, surface a cancelled-style failure so the shard side terminates cleanly.
            NetworkDisruption.DISCONNECT
            assertTrue("Bridge partition must surface a response or an error (no hang)", response.get() != null || failure.get() != null);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, NUM_SHARDS)
    }
        createAndSeedIndex();
        createAndSeedIndex();
        assertBusy(() -> {
    }
        }
            // recording the observed behavior. The assertion above ensures 'no hang'.
        // Defensive cleanup — every test that sets a disruption should have
     * <p>This is distinct from cancellation: the query is succeeding, not
            vsr.allocateNew();
     * #3 — Small network delay (200ms). Query must succeed and complete in roughly
            throw new AssertionError("createAndSeedIndex: timed out waiting for seed durability", e);
     * side of the exchange sink.
                } else {
        createAndSeedIndex();
    /**
    private static class ForwardingChannel implements TransportChannel {
     * unread batches in the terminal sink.
        }, 15, TimeUnit.SECONDS);
import org.opensearch.test.MockLogAppender;
     * {@link #stopDeadlockWatchdog()} fails the test with a thread dump. Cheap and
        System.gc();
            );
            System.gc();
            + " observed CI seeds; #21711 attempted a teardown fix (ensureGreen) but did not land. Unmute when the"
import org.opensearch.common.settings.Settings;
     * the blocked handler.
    /**
                // may still return partial data; don't fail here, let the post-check assert.
        // Threshold: end ≤ baseline + 5 MiB AND end ≤ baseline × 1.10.
            int after = NativeHandle.liveHandleCount();
        createAndSeedIndex();
        String coord = coordinatorNodeName();
                previousByNode.put(node, prev);
        });
            deadlockWatchdog.awaitTermination(2, TimeUnit.SECONDS);
            assertThat("Partial sum must be < full when a shard contributes nothing; got " + actual, actual, lessThan(EXPECTED_SUM));
    public void testShardHostNodeKillAndRestart() throws Exception {
import org.opensearch.plugins.Plugin;
    public void testTopologyDedicatedClientNode() throws Exception {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    private String coordinatorNodeName() {
            AtomicInteger ok = new AtomicInteger();
        internalCluster().startNode();
                response.get() != null || failure.get() != null
     * #32 — Listener single-callback contract: exactly one of (onResponse,
            channel.sendResponse(new RuntimeException("injected sibling leg failure"));
            TestPPLPlugin.class,
                Thread.currentThread().interrupt();
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
     * The union reduce uses MultiInputExchangeSink; child stages each write to
        } finally {
        + "mode.")
        String idxDelay = "sibling_leg_delay";
            });
            .prepareUpdateSettings()
                appender.assertAllExpectationsMatched();
                failure = t;
                                } catch (Exception ignore) {}
                "NativeHandle live count grew after cancel: baseline=" + handleBaseline + " after=" + handleAfter,
     * release pre-sorted batches the per-query allocator leaks.
                    if (n == 4) {
                b.registerFactory(StageExecutionType.SHARD_FRAGMENT, e.getValue());
            } catch (ExecutionException | TimeoutException ignore) {
            assertFalse("cancel must not report node failures", cancel.getNodeFailures() != null && !cancel.getNodeFailures().isEmpty());
        // backpressure mid-stream. NodeScope dynamic — TEST cluster scope
        // The PPL client may dispatch to any node — register the faulting
        String coordOnly = internalCluster().startCoordinatingOnlyNode(Settings.EMPTY);
    )
        }, 30, TimeUnit.SECONDS);
     * point differs.
     * snapshot — connections re-established via the periodic
import java.util.Collections;
                StageExecutionBuilder b = internalCluster().getInstance(QueryScheduler.class, e.getKey()).getStageExecutionBuilder();
            Throwable cause = cur.getCause();
            assertBusy(() -> {
            };
            .setPersistentSettings(Settings.builder().put(DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT.getKey(), 1L))
        assertTrue(
                @Override
     * through the reduce, exercising larger intermediate buffers.
        long delaySeconds = QUERY_TIMEOUT.seconds();
            }
            };
    /**
        } finally {
    private Map<Integer, String> shardToNode() {
                }
                    public void sendResponseBatch(TransportResponse response) {
        NetworkDisruption disruption = new NetworkDisruption(
                public void onResponse(PPLResponse pplResponse) { ok.incrementAndGet(); }
        long siblingDelaySeconds = QUERY_TIMEOUT.seconds();
        assertNoLeakOnSuccess("source = " + SINGLE_SHARD_INDEX + " | where value = " + VALUE);
            holdShard.countDown();
    // |------------------------------------|-------------------------------------------|
            .prepareCreate(name)
            .setMapping("value", "type=integer")
    /**
            for (Throwable s : cur.getSuppressed()) {
        );
        for (String n : nodes) {
     */
            assertTrue(
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters(filters = FlightTransportThreadLeakFilter.class)
            });
        String delayNode = nodes[1];
            try {
        }
        } finally {
            internalCluster().clearDisruptionScheme(true);
            Thread.sleep(500);
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
import org.opensearch.cluster.routing.ShardRouting;
            released.countDown();
            if (!emptyNode.equals(errorNode)) emptyMts.clearAllRules();
    /**
        }
                        schemaForwarded = true;
            );
     * and the {@link NativeHandle} live count back to baseline.
            }
            assertNotNull("Build failure must surface to the listener (got null failure)", failure.get());
     * transport, so without the fallback the stub would never bind.
            client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest("source = " + SINGLE_SHARD_INDEX + " | stats sum(value) as total"), new ActionListener<PPLResponse>() {
            boolean wrongResult = false;
            for (String node : internalCluster().getNodeNames()) {
            exec.awaitTermination(5, TimeUnit.SECONDS);
        assertEquals("failing query: zero onResponse", 0, ok2.get());
     * fail within a single SHARD_FRAGMENT stage.
        StringBuilder sb = new StringBuilder();
     */
            released.countDown();
            exec.awaitTermination(5, TimeUnit.SECONDS);
            );
            };
        try {
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        final int n = 50;
            assertScalarLong(r, "total", EXPECTED_SUM);
            assertTrue(
        // If the partial-build cleanup was incomplete we'd see a residual
     */
     * Multi-child stage failure must cascade UP to the parent and DOWN to the
                infos.isEmpty()
            .put("index.pluggable.dataformat", "composite")
    /**
     * listener (which tears down the per-query Arrow allocator) before
        try {
        NetworkDisruption disruption = new NetworkDisruption(
    // user sees IllegalStateException("Memory was leaked: ..."). The matrix
                "partial-failure outcome: response={} failure={}",
     * {@code LocalStageExecutionFactory.createExecution}) throws. Earlier dispatch-
                long after = dfs.getMemoryPoolUsage();
    )
     * {@code NodeConnectionsService} take a few hundred ms post-heal, so we
        assertScalarLong(healed, "total", EXPECTED_SUM);
            internalCluster().clearDisruptionScheme();
        assertBusy(() -> assertEquals(1, okCount.get() + failCount.get()), QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
        // partial results that look like resilience bugs.
        }
            classpathPlugin(FlightStreamPlugin.class, List.of(ArrowBasePlugin.class.getName())),
            public void onResponse(PPLResponse r) {
            Throwable cur = queue.poll();
        } finally {
     * interrupts the latched handler on the delay node.
    }
            // empty source (acceptable for this fix — propagating SHARD_FRAGMENT FAILED
            // Contract: either a clear error OR a partial-shards-failed result.
     * one that throws on {@code createExecution}. A real
            pluginClass.getName(),
            @Override
        for (String node : internalCluster().getNodeNames()) {
        // regardless of which one ends up coordinating.
        for (String n : allNodes) {
    public void testMultiShardScanNoReduceReleasesBufferOnSuccess() throws Exception {
     * <p><b>Currently failing:</b> the planner pushes {@code head N} to each
     * the planner / orchestrator). Deferred: there is no public fault seam or
    // | group-by aggregation               | N partial w/key → 1 final REDUCE w/key    |
                    Thread.sleep(50);
        String victim = firstNonMatching(coord);
        String victim = pickShardHostingNode();
     * surfaces as a query failure (or a partial-failure response — both
            } catch (InterruptedException ie) {
     * dispatch but before any fragments execute, the coordinator surfaces the
                    disruption.startDisrupting();
        ensureGreen(INDEX);
        delayMts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
                .prepareUpdateSettings()
    public void testCoordinatorSurvivesIntermittentNetwork() throws Exception {
            );
            assertTrue("Mid-stream disconnect must surface error or partial response (no hang)", response != null || failure != null);
                new IllegalStateException("injected exchange-sink registration failure")
     * the JVM only reports actual lock cycles where every participant is blocked.
     * union has two child sub-trees. The fail-leg's shard task throws, propagating
            .build();
            response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
    /**
                fail2.incrementAndGet();
            .setSettings(indexSettings)
        assertNoPendingFragmentTasks();
        });
     * from the class-level {@code @ThreadLeakScope(Scope.TEST)}: the suite
                new PPLRequest("source = " + INDEX + " | stats sum(value) as total"),
            StageExecutionFactory[] thisNodeOriginal = new StageExecutionFactory[1];
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
     * #33 — Race a shard success with another shard's failure (via injected
     */
        } finally {
    private static final String INDEX = "resilience_idx";
        });
     * sibling-side delay, proving the sibling didn't just naturally complete.
        }
        try {
        Set<String> sideOne = new HashSet<>();
     * per-node {@link MockTransportService} injection targets exactly one leg.
     * stops draining mid-stream. Tests that early-stop correctly closes
        AtomicReference<Throwable> failure = new AtomicReference<>();
        AtomicReference<Throwable> failure = new AtomicReference<>();
        assertScalarLong(response, "total", EXPECTED_SUM);
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
     * re-throws, {@code PlanWalker.build()} catches and runs the
                    wrongResult = true;
            AtomicReference<Throwable> failure = new AtomicReference<>();
        assertBusy(() -> {
                response.get() != null || failure.get() != null
            return delegate.getProfileName();
     * this contract — "planner failure surfaces, no leaked fragment tasks" — is
            client().admin().indices().prepareDelete(INDEX).get();
    /**
        createSingleShardIndexOnNode(idxDelay, 5, delayNode);
            PPLResponse response = null;
            internalCluster().clearDisruptionScheme();
import java.lang.management.ThreadMXBean;
    // native datafusion pool is at baseline within slack. Failure-path leak
                memAfter <= memBaseline + 1024 * 1024
            )
     * propagation logic exercised at the transport layer by
     * returns a single zero-row Arrow batch carrying a minimal schema, then
    private void assertNoLeakOnSuccess(String ppl) throws Exception {
// (orphaned fragment-task threads, leaked native-handle reapers) surface
        } finally {
            // add jitter.
        } catch (Throwable t) {
     * {@code delay + serve-time}, not {@code delay × shards} (which would indicate
                "Coordinator must terminate with either a response or a failure on partial failure",
    // ---------------------------------------------------- B: shard-level faults
     * result from the other two shards.
        for (String node : internalCluster().getNodeNames()) {
                            if (r != null) {
     * <p>Uses the same {@link StageExecutionBuilder#registerFactory} seam
    }
            );
                "Query with 300ms shard delay took " + elapsedMs + "ms; > " + upperBound + "ms suggests serial blocking",
    public void testCoordinatorSurvivesSlowShard() throws Exception {
     * {@code FragmentExecutionAction} task counts. What this test would add on
    /**
     * baseline.
        Settings indexSettings = Settings.builder()
    protected Settings nodeSettings(int nodeOrdinal) {
                elapsedMs < QUERY_TIMEOUT.millis() + 5_000L
            delegate.sendResponse(exception);
                failure = t;
        );
            Throwable failure = null;
            exec.shutdownNow();
    public void testListenerSingleCallback() throws Exception {
        // dataset. assertBusy until the analytics path sees the full sum, otherwise
        } finally {
        } finally {
                Level.WARN,
import java.util.Set;
                            return;
            appender.addExpectation(new MockLogAppender.UnseenEventExpectation(
            );
        );
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
            stubAllocator.close();
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
            assertThat("Partial sum must be < full when a shard contributes nothing; got " + actual, actual, lessThan(EXPECTED_SUM));
            // terminate in bounded time.
            try {
        createAndSeedIndex();
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
        }
            assertTrue(
    /**
     * already covered indirectly by {@link #testPlanFailurePropagates} (#21),
            Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total"));
                executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
import org.opensearch.analytics.planner.dag.StageExecutionType;
import java.util.concurrent.TimeoutException;
     * into a freshly-closed allocator. The drain task logs a WARN
        } catch (Throwable ignore) {}
            failure.set(t);
        }
            extendedPlugins,
        + "MockTransportService.addRequestHandlingBehavior on the dispatch action sees the "
        Logger reduceSinkLogger = LogManager.getLogger("org.opensearch.be.datafusion.DatafusionReduceSink");
        String coord = coordinatorNodeName();
     * Coordinator must surface a clear "no shard available" error.
     * Walks {@code t}'s cause + suppressed graph looking for Arrow's "Memory was leaked"
        String[] nodes = internalCluster().getNodeNames();
                };
     * a single zero-row schema batch when the native source produces no rows, so the streaming
            errorMts.clearAllRules();
        // NativeHandle registry returns to baseline.
        try {
            } catch (Throwable t) {
        return Settings.builder()
    /**
            long elapsedMs = (System.nanoTime() - start) / 1_000_000L;
 * {@code addRequestHandlingBehavior} is wired to consult both the regular
        client().execute(
                    + ")",
        createAndSeedIndex();
                    return null;
        int idx = response.getColumns().indexOf(column);
                    @Override
import java.util.stream.Collectors;
            AtomicReference<Throwable> failure = new AtomicReference<>();
                    new PPLRequest("source = " + INDEX + " | stats sum(value) as total"),
        + "exposes a public fault seam or a registered-state observability accessor — "
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        public void completeStream() {
        NetworkDisruption disruption = new NetworkDisruption(
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
        createAndSeedIndex();
        );
     * #20 — Coordinator node itself is killed mid-query. Subsequent client call via
        public String getProfileName() {
        internalCluster().setDisruptionScheme(disruption);
     * #10 — Cancel the parent (coordinator-level) task during the dispatch phase
        // Slow the victim so we can race in a cancellation.
                public void onFailure(Exception e) {
            disruption.startDisrupting();
            }
        }
    /**
        assertThat("need ≥2 shard-host nodes", nodes.length, greaterThan(1));
                            }
     * marker. Raised by {@code BaseAllocator.close()} when any child allocator still holds
                public void sendResponseBatch(TransportResponse response) {
        try {
            AtomicReference<PPLResponse> response = new AtomicReference<>();
        assertNoPendingFragmentTasks();
                try {
            System.gc();
        failMts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
        @Override
            assertTrue("expected most queries to fail (saw " + failed + "/50)", failed >= 45);
            .indices()
        DataFusionService dfs = internalCluster().getInstance(DataFusionService.class, coordinatorNodeName());
     * #8 — Inject an exception on one shard's fragment handler. Coordinator must
        Map<String, StageExecutionFactory> originalByNode = new HashMap<>();
import java.util.List;
     * Creates + seeds the test index. Called from every test that actually issues
    /**
                // Either the query was cancelled mid-flight (preferred — the
import org.opensearch.common.unit.TimeValue;
        );
            executePPL("source = " + INDEX + " | stats sum(nonexistent_field) as total", QUERY_TIMEOUT);
            Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
     */
                @Override
                "NativeHandle live count grew after stage-build failure: baseline=" + baseline + " after=" + after,
    }
        createAndSeedIndex();
            }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                        if (response instanceof org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse arrow) {
            }
                                    incoming.close();
        });
            .shardsWithState(org.opensearch.cluster.routing.ShardRoutingState.STARTED)) {
     * #13 — Contract under test: when a failure originates inside the coordinator
            }
    /**
        // Task leak check — no FragmentExecutionAction tasks remain after failure.
import org.opensearch.be.datafusion.DataFusionPlugin;
            delegate.completeStream();
        // disruption-time queries race the in-flight commit and produce nondeterministic
            long after = dfs.getMemoryPoolUsage();
    // contract is universal across shapes: regardless of which operators run,
    public void testAllShardsUnassigned() throws Exception {
     */
        createAndSeedIndex();
     * <p>Construct a zero-row response that carries the real shard schema by
        long midpoint = baseline;
    }
import java.util.concurrent.atomic.AtomicReference;
        ExecutorService exec = Executors.newSingleThreadExecutor();
    /**
            .get();
     * outcomes are acceptable; a hang is not).
        );
            assertNotNull("Build failure must surface to the listener (got null failure)", failure.get());
        AtomicInteger faultCount = new AtomicInteger();
     * ({@code stats sum(nonexistent_field)}) and asserts on
            if (i == n / 2) {
    }
     * as 0 rows contributed, not an error. Other shards' data still aggregated.
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
        private final TransportChannel delegate;
    private static final int VALUE = 7;
        public void sendResponse(TransportResponse response) throws java.io.IOException {
import org.opensearch.composite.CompositeDataFormatPlugin;
        // the *aggregate* output type (SUM(int) → Int64/BIGINT), not the base column type.
            client().admin().indices().prepareDelete(INDEX).get();
            try {
        try {
     * failing. The data-node-side fragment tasks may keep producing for a
            assertTrue(
            } catch (Throwable t) {
        // Post-recovery sanity check.
                    @Override
import org.opensearch.arrow.allocator.ArrowBasePlugin;
                    Thread.currentThread().interrupt();
            }
            false
    public void testSingleShardCancellationAtCoordinator() throws Exception {
import org.junit.Before;
    /**
            }
        try {
        int beforeCount = before.getTasks().size();
                private boolean schemaForwarded = false;
     */
        ExecutorService exec = Executors.newSingleThreadExecutor();
            .put(NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.getKey(), "2s")
        CountDownLatch released = new CountDownLatch(1);
        }
        try {
     * remaining node must still function. Tests that coordinator singleton state
            }
        long allowed = Math.max(absoluteCeiling, relativeCeiling);
        createAndSeedIndex();
        org.apache.arrow.vector.types.pojo.Schema schema = new org.apache.arrow.vector.types.pojo.Schema(
        // Warm-up: one query primes thread pools, JIT, native runtime caches.
import java.util.concurrent.Executors;
        CountDownLatch released = new CountDownLatch(1);
                    + ", response="
    }
        for (int i = 0; i < TOTAL_DOCS; i++) {
        long before = dfs.getMemoryPoolUsage();
     * not block waiting for the remaining shards to finish, and the total
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
        @Override
                    long got = cell == null ? -1 : ((Number) cell).longValue();
            if (prev != null) {
     */
            // Restore — even on failure, leaving a faulting scheduler in
 * <p><b>Streaming transport enabled.</b> Production runs streaming, and so
        ensureGreen(name);
        throw new AssertionError("no node other than " + name + " in cluster: " + List.of(internalCluster().getNodeNames()));
        int handleBaseline = NativeHandle.liveHandleCount();
            channel.sendResponse(new IllegalStateException("release-on-failure probe"));
     *
                                    r.close();
                @Override
     * Stubs one shard's {@link FragmentExecutionAction} entirely — no real
        PPLResponse r = executePPL("source = " + SINGLE_SHARD_INDEX + " | head 1", QUERY_TIMEOUT);
                    "source = " + idxFail + " | stats sum(value) as total"
                queryFailure = t;
        assertThat("need ≥2 nodes to pin sibling legs", nodes.length, greaterThan(1));
            if (n.equals(name) == false) return n;
    /**
            if (sideOne.isEmpty()) sideOne.add(n);
            // exception as a Suppressed on the surfaced query failure; walk the whole cause
            @Override
                        // so the throw doesn't leak the source root's buffers.
                    }
     * Creates + seeds a single-shard composite-parquet index with {@code docs} rows.
            for (Map.Entry<String, StageExecutionFactory> e : previousByNode.entrySet()) {
import org.opensearch.core.action.ActionListener;
        } catch (Exception e) {
        assertNotNull("query must return a response: " + ppl, response);
        createAndSeedIndex();
     * coordinator-reduce stage runs correctly on a node that holds NO data shards —
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.analytics.exec.QueryScheduler;
        Thread.sleep(50);
        // Either fast failure (preferred) or partial result with reduced sum.
                Thread.sleep(50);
     * Used by the multi-batch early-termination test, which lowers the DataFusion
                channel.sendResponse(new IllegalStateException("forced-failure for thread-leak test"));
            Future<?> raceStart = exec.submit(() -> {
        assertBusy(() -> {
     *
    public void testCoordinatorNodeCrashRecovery() throws Exception {
            } catch (Throwable t) {
            NetworkDisruption.DISCONNECT
     * stage's {@code ExchangeSinkProvider.createSink} call (invoked from
        return shardToNode().values().iterator().next();
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
            StageExecutionBuilder b = internalCluster().getInstance(QueryScheduler.class, node).getStageExecutionBuilder();
            // and leak traces print the allocation call-site stack.
            }
     *
    }
    // -------------------------------------------------------------- helpers
        StageExecutionFactory faulting = (stage, sink, config) -> {
    }
        });
            CancelTasksResponse cancel = client().admin().cluster().prepareCancelTasks().setActions(UnifiedPPLExecuteAction.NAME).get();
import org.opensearch.plugins.PluginInfo;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
     * #19 — Kill a shard-hosting node after a brief disruption window, bring
import java.util.HashMap;
            AtomicReference<Throwable> failure = new AtomicReference<>();
                public void onResponse(PPLResponse pplResponse) { ok.incrementAndGet(); }
        client().admin()
            // Sometimes stop fails in transit; proceed — next query will confirm survival.
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
     * {@code ExchangeSinkProvider.createSink} failure (e.g. the backend
    /**
     * #5 — Bridge topology: one node isolated from the others, they can talk.
        Thread.sleep(50);
 * <p>Covers four failure domains:
            try {
     */
        // Pick a bridge node (= isolated), two others on each side.
        MockTransportService failMts = (MockTransportService) internalCluster().getInstance(TransportService.class, failNode);
            "classpath plugin",
                    after <= before + 1024 * 1024  // 1MiB slack for runtime heap moves
        CreateIndexResponse response = client().admin()
                handleAfter <= handleBaseline
     */
        // "getStackTrace"). ThreadMXBean#dumpAllThreads is allowed and returns equivalent
        try {
    }
            client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest("source = " + SINGLE_SHARD_INDEX + " | stats sum(value) as total"), new ActionListener<PPLResponse>() {
    // | limit / head (early termination)   | N SHARD_FRAGMENT w/ early termination     |
     * Mirrors the pattern in {@code CacheTests.testDependentKeyDeadlock}.
    }
     * batches) rather than cross-stream termination.
        }
        disruption.startDisrupting();
            );
     * {@link StageExecutionType} and the original {@code registerFactory}
            try {
    public void testTaskCancellationAtDataNode() throws Exception {
                            } catch (Exception ignore) {}
        return new PluginInfo(
 * {@link org.opensearch.analytics.exec.stage.shard.ShardFragmentStageExecutionFactory}).
                .get();
        try {
            // Already gone — fine.
                );
            assertTrue(
            .prepareCreate(name)
     * #25 — All shards unassigned: stop the node hosting the index's primaries
    }
            }
            .put("index.pluggable.dataformat", "composite")
            .put("index.routing.allocation.require._name", nodeName)
    public void testGroupByAggregateReleasesBufferOnSuccess() throws Exception {
        // Kill the node post-disruption: the framework needs consensus to
                            try {
        CountDownLatch holdShard = new CountDownLatch(1);
        assertEquals("LIMIT must produce exactly the requested row count", 1, r.getRows().size());
            try {
            "Coordinator must terminate (failure or response) when shards are unassigned; got hang",
                    private boolean schemaForwarded = false;
        internalCluster().setDisruptionScheme(disruption);
     * Shape: scan + filter, single shard, no reduce.
        });
     * Shape: head/limit with early termination.
            } catch (Throwable t) {
            assertTrue(
        Set<String> sideTwo = new HashSet<>();
                "Cascade must propagate failure UP and cancel sibling DOWN — elapsed=" + elapsedSec
        }
        assertTrue("need ≥3 nodes for bridge topology", allNodes.size() >= 3);
                public void onFailure(Exception e) { failure.set(e); fail.incrementAndGet(); }
     * one exercises within-stream backpressure (single producer, multiple
            new NetworkDisruption.TwoPartitions(Collections.singleton(coord), Collections.singleton(victim)),
     * first batch and the coordinator must stop pulling subsequent batches.
 *   <li>D. Shutdown-restart flavor — coordinator/data-node crash recovery.</li>
            .putList("index.composite.secondary_data_formats")
            CancelTasksResponse cancel = client().admin().cluster().prepareCancelTasks().setActions(UnifiedPPLExecuteAction.NAME).get();
    }
    public void testCoordinatorSurvivesBridgePartition() throws Exception {
        // Normal query.
     */
        try {
            exec.shutdownNow();
            long actual = ((Number) response.getRows().get(0)[response.getColumns().indexOf("total")]).longValue();
        assertScalarLong(r, "total", 30L * VALUE);
            try {
            }
                fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
                Thread.sleep(200);
                failure.set(t);
        try {
     * mid-flight and verifies the listener fires with TaskCancelledException
 * <p>Explicitly parquet-only: no Lucene backend installed. Tests run against a
    // | sort with pushdown                 | N partial sort → 1 merge sort REDUCE      |
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
        } finally {
                    + batchCount.get(),
                ExchangeSink poisoned = new ExchangeSink() {
        internalCluster().setDisruptionScheme(disruption);
    // below probes one representative query per topology so the suite covers
                throw new AssertionError("Arrow allocator leaked on failure path: " + cur.getMessage(), t);
     * fast in planning with a clear error containing the bad field name; not hang
            );
                        // Release the would-be-forwarded batch's native memory
     * #G3 — Single-shard parent-task cancellation. Cancels the AnalyticsQueryTask
        internalCluster().startNode();
}
        assertScalarLong(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT), "total", EXPECTED_SUM);
            .prepareUpdateSettings()
        }
     * closing the reduce sink — leaving the drain task importing batches
     * stream handle). This is a tighter, reduce-sink-layer assertion of the same
                // the cancel landed (a no-op race). Both must satisfy the
import java.util.concurrent.ExecutorService;
            NetworkDisruption.DISCONNECT
@com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope(com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope.Scope.TEST)
                    org.apache.arrow.vector.types.pojo.FieldType.nullable(new org.apache.arrow.vector.types.pojo.ArrowType.Int(64, true)),
    }
        // With 3 shards, 0 replicas spread across 3 nodes, stopping ANY one node
                "Native memory grew after cancel: baseline=" + memBaseline + " after=" + memAfter,
                );
    }
            try {
        }, 30, TimeUnit.SECONDS);
    public void testMultiInputUnionReleasesBufferOnSuccess() throws Exception {
    public void testExchangeSinkRegistrationFailureTearsDown() throws Exception {
        } finally {
                    + "s; if this approaches the latch timeout, onTaskTerminal is still waiting for all tasks",
        }
        createAndSeedIndex();
        }
                        // Truncate the incoming root to zero rows in place — preserves the schema and the
     * still-disrupted victim cannot acknowledge — the framework would throw
    }
    @Override
            mts.clearAllRules();
    public void testReduceStageExceedsMemoryLimit() throws Exception {
            AtomicReference<Throwable> failure = new AtomicReference<>();
            assertNoArrowLeakSuppressed(queryFailure);
    public void testSingleShardHappyPath() throws Exception {
    }
     */
                    executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
            // usually still have a pending reduce when the cancel lands.
    }
import org.opensearch.analytics.spi.ExchangeSink;
     *
            long actual = ((Number) response.getRows().get(0)[response.getColumns().indexOf("total")]).longValue();
     * runs out of native memory while allocating a session) flows through
                return thisNodeOriginal[0].createExecution(stage, poisoned, qctx);
     * (pending executions, fragment-task accounting, query-context entries) so
            .setSettings(indexSettings)
            try {
     * registered-state accessor on the unified query planner today.
                    super.sendResponseBatch(response);
     *
     * test asserts that WARN never fires.
            deadlockWatchdog = null;
        CountDownLatch released = new CountDownLatch(1);
        try {
        public String getChannelType() {
                // Accept non-zero baseline (runtime overhead), require that we don't leak.
            // Allow dispatch + shard-handler entry
                    + failure.get()
     * post-disruption recovery path.
        String victim = firstNonMatching(coord);
            String victim = pickShardHostingNode();
        if (baseline < 1024L * 1024L) {
            AtomicReference<PPLResponse> response = new AtomicReference<>();
        try {
    @org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix(bugUrl = "Tighter cleanup observability for planner-stage failures. The propagation "
            StageExecutionFactory perNodeFaulting = (stage, sink, qctx) -> {
            stubCalls.incrementAndGet();
        AtomicInteger ok2 = new AtomicInteger();
    }
     * contract is honest under the real protocol.
     * DAG: N partial-sort SHARD_FRAGMENT → 1 merge-sort COORDINATOR_REDUCE.
                fail("query must fail — the victim shard's handler was stubbed to return an exception");
            }
            () -> assertEquals("Native memory must return to baseline after reduce failure", before, dfs.getMemoryPoolUsage()),
                listener
            if (cause != null) {
            10,
        String victim = pickShardHostingNode();
            stubAllocator = null;
            mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
     * Universal happy-path leak probe. Runs {@code ppl} once; asserts (a) no
        // Bring cluster back to 3 nodes, verify a fresh query works.
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
            if (sr.primary()) {
            new NetworkDisruption.TwoPartitions(Collections.singleton(coord), Collections.singleton(victim)),
            PPLResponse r = executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
        try {
import java.util.HashSet;
    }
        createAndSeedIndex();
            handler.messageReceived(request, channel, task);
            MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
                "query must either return or fail within " + QUERY_TIMEOUT + "; got null response and null failure → coordinator hung",
                after <= baseline
     * applies to both the regular and streaming transports' connections, so this
                return clusterService().state().nodes().get(sr.currentNodeId()).getName();
     * Shape: sort with shard-side pushdown.
    }
     * residual PPL parent task, native datafusion memory pool back to baseline,
            PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
            failure = t;
            null,
    private static final int TOTAL_DOCS = NUM_SHARDS * DOCS_PER_SHARD_TARGET;
                    + injected.get()
     * DAG: 1 SHARD_FRAGMENT (passthrough — no coordinator reduce stage).
        // cleanup in PlanWalker.build() cancels every already-built stage,
        Object cell = response.getRows().get(0)[idx];
                };
                    null
        long memBaseline = dfs.getMemoryPoolUsage();
            // The contract this guard fixes: feed() throwing must NOT hang the query
        }
     */
            classpathPlugin(ParquetOnlyDataFormatPlugin.class, Collections.emptyList()),
            AtomicReference<Throwable> failure = new AtomicReference<>();
        for (int i = 0; i < docs; i++) {
        ListTasksResponse remaining = client().admin().cluster().prepareListTasks().setActions(UnifiedPPLExecuteAction.NAME).get();
     *
            }
        } catch (Exception ignore) {}
        });
     */
            internalCluster().clearDisruptionScheme();
        }
            .setTransientSettings(Settings.builder().put("datafusion.indexed.batch_size", 10))
            // easily blow this. Generous slack because cold-start parquet reads
            );
        }
    /**
     * planner failure AND tears down all coordinator-side registered state
     * #1 — Disconnect coordinator from one shard-hosting node mid-query.
            long upperBound = 300L * NUM_SHARDS * 10L;
        Map<String, StageExecutionFactory> previousByNode = new HashMap<>();
        } finally {
     * data-node fragment but does not re-apply a coordinator-side LIMIT after
            this.delegate = delegate;
     * <p>Data-node handler delegates to the production streaming handler via a
    public void testMidStreamBatchExceptionPropagates() throws Exception {
            assertBusy(() -> {
    }
     * which drives an actual planner-rejecting query
            exec.shutdownNow();
            );
            // stops, so assertions about recovery don't wait the 10s default.
                    + thrown.get()
        } finally {
        }
                assertEquals("query must fail (one shard injected error); ok=" + ok.get(), 1, fail.get());
    /**
     * partial-build cleanup, the listener sees the original cause.
            after.getTasks().size()
            delayMts.clearAllRules();
            channel.completeStream();
        } finally {
            AtomicReference<Throwable> failure = new AtomicReference<>();
            // Don't assert which of (partial success / total failure) — this test pins the contract by
     * <p>Shape: UNION across two single-shard indices pinned to distinct nodes
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
        AtomicReference<Throwable> failure = new AtomicReference<>();
            int failed = 0;
        + "assertion on coordinator registered-state cleanup (pending executions, query "
import org.opensearch.common.util.FeatureFlags;
        }
     * (one fail-injected, one latch-delayed). The parent {@code COORDINATOR_REDUCE}
            } catch (ExecutionException | TimeoutException ignore) {
            Future<PPLResponse> fut = exec.submit(() -> executePPL("source = " + INDEX + " | stats sum(value) as total"));
    public void testThreadLeakAfterFailedQuery() throws Exception {
    }
                    + " batches="
            );
    }
     * Early-termination via LIMIT within a single shard's stream. With
            TransportChannel wrapper = new ForwardingChannel(channel) {
                released.await(siblingDelaySeconds, TimeUnit.SECONDS);
    public void clearDisruption() {
        ensureFullyConnected();
                thrown.get() || response.get() != null || failure.get() != null
        }, 1, 1, TimeUnit.SECONDS);
            new PPLRequest("source = " + INDEX + " | stats sum(nonexistent_field) as total"),
        Set<String> allNodes = new HashSet<>(List.of(internalCluster().getNodeNames()));
            "NA",
        try {
        // cluster nodes. Use getMasterName() as a stable coordinator surrogate.
        assertNotNull(column + " cell must not be null", cell);
     * #22 — Contract under test: when planning fails after a successful transport
        StageExecutionFactory faulting = (stage, sink, config) -> {
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
        createAndSeedIndex();
            CompositeDataFormatPlugin.class,
     * Early-termination via LIMIT across shards. The coordinator must stop
            PPLResponse response = executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
        });
        createAndSeedIndex();
                failure.get() != null || response.get() != null
     * Bounded timeout proves the coordinator doesn't wedge across reconnect cycles.
        // clusterService() resolves on the local (test-thread) node's client — in
    }
        client().admin().indices().prepareFlush(INDEX).get();
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
        // In-flight query may throw; that's fine.
                .setPersistentSettings(Settings.builder().putNull(DataFusionPlugin.DATAFUSION_MEMORY_POOL_LIMIT.getKey()))
            AtomicReference<PPLResponse> response = new AtomicReference<>();
        assertBusy(() -> {
        deadlockedThreadIds = null;
     */
                        incoming.setRowCount(0);
        assertEquals("normal query: exactly one onResponse, zero onFailure", 1, okCount.get());
    private void assertNoPendingFragmentTasks() throws Exception {
     * Coordinator just forwards the shard's stream to the caller.
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
     */
// nodes must not leak across methods.
        } finally {
            // No scheme set — fine.
        }, 30, TimeUnit.SECONDS);
     * Wait until the cluster is actually fully reconnected after a disruption.
    }
 *       {@link MockTransportService#addRequestHandlingBehavior}
            .setMapping("value", "type=integer")
    /**
        return internalCluster().getClusterManagerName();
     * test exercises sibling STAGE cancellation; this one exercises sibling TASK fast-
 * (a.k.a. stage scheduler —
     * #F1 — Dedicated coordinating-only client node. Adds a coordinating-only node to
            public void onResponse(PPLResponse r) {
 * SPDX-License-Identifier: Apache-2.0
            assertBusy(() -> assertEquals(1, ok.get() + fail.get()), QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
    private void createAndSeedIndex() {
                handleAfter <= handleBaseline
        assertNoPendingFragmentTasks();
            assertTrue("Disconnect-during-dispatch race must terminate in bounded time", failure.get() != null || response.get() != null);
            try {
     * #17 — Assert the coordinator's Arrow allocator returns to baseline after
    /**
    /**
        AtomicReference<Throwable> failure = new AtomicReference<>();
            channel.sendResponse(new RuntimeException("injected within-stage task failure"));
        logger.info("memory drift across {} queries: baseline={} mid={} end={} allowed≤{}", n, baseline, midpoint, end, allowed);
            // system property from this node setting, clobbering the -D VM arg. Turn
                failure.set(t);
    /**
     */
                faultCount.get() >= 1
     * potential coordinator must intercept the dispatch.
     * #30 — Cancel during the reduce stage. Complements
        // No zombie fragment tasks anywhere in the cluster.
            new NetworkDisruption.TwoPartitions(Collections.singleton(coordinatorNodeName()), Collections.singleton(victim)),
        };
                mts.clearAllRules();
     * 3-shard parquet cold-start). Asserts the native memory pool's end usage
        }
    // | scan-no-reduce (single shard)      | 1 SHARD_FRAGMENT (passthrough)            |
    }
    // | single aggregation                 | N partial → 1 final REDUCE                |
        createAndSeedIndex();
        return out;
     * ("drain task terminated with error ... allocator is closed"); the
                queue.add(cause);
            // Pin the behavior — whichever path the coordinator takes, it must
     *
                PPLResponse r = executePPL("source = " + name + " | stats sum(value) as total");
            // Match NetworkDisruptionIT: speeds up reconnection after disruption
     * cascade's sibling-stage cancel-sweep cancels the parent task, which interrupts
                "Coordinator must terminate (failure or response) after mid-stream batch error; "
        // injection only fires on the regular-transport fallback. Either way,
                lessThan(delaySeconds / 2)
        });
            try {
                "Failed to create exchange sink for stageId=" + stage.getStageId(),
 * a behavior on {@link FragmentExecutionAction#NAME} works regardless of
                    wrongResult = got != EXPECTED_SUM;
import org.opensearch.arrow.flight.transport.FlightStreamPlugin;
        AtomicInteger ok = new AtomicInteger();
            assertEquals("cancelled query must produce exactly one onFailure", 1, fail.get());
            // Hold the shard-side request until released.
    }
import java.util.Collection;
     * the 3-data-node cluster and dispatches the query through it. Verifies the
    // every per-query Arrow allocator must return to baseline at close, or the
import java.util.Map;
import org.opensearch.transport.TransportService;
            StageExecutionBuilder b = internalCluster().getInstance(QueryScheduler.class, node).getStageExecutionBuilder();
        DataFusionService dfs = internalCluster().getInstance(DataFusionService.class, coord);
        + "doExecute(...) plan-then-schedule path) and sandbox/plugins/analytics-engine/src/"
                        super.sendResponseBatch(arrow);
        exec.shutdownNow();
            + " quorum during stop+restart after NetworkDisruption (FailedToCommitClusterStateException). Same"
        org.opensearch.core.action.ActionListener<PPLResponse> okListener = new org.opensearch.core.action.ActionListener<>() {
            .get();
        DataFusionService dfs = internalCluster().getInstance(DataFusionService.class, coordinatorNodeName());
        // strands its hosted primaries with no allocation target until a recovery
        String failNode = pickShardHostingNode();
    }
    }
     * #12 — One shard OK, one shard errors, one shard empty. Document whatever the
        String coord = coordinatorNodeName();
        );
    public void stopDeadlockWatchdog() throws InterruptedException {
                channel.sendResponse(new IllegalStateException("inject-shard-failure"));
            "No residual UnifiedPPLExecute tasks after cancel-during-reduce: " + remaining.getTasks(),
            assertTrue(
     * Verifies the coordinator either rejects or returns a partial result — pins
        Map<Integer, String> out = new HashMap<>();
            .build();
        throw new AssertionError("no started primary for index " + indexName);
        }
     * <p>Complements {@link #testEarlyTerminationLimitMultiShard()}: this
            } catch (Throwable ignore) {}
            }
        // Sanity: a fresh query against the same index works post-failure.
        exec.awaitTermination(5, TimeUnit.SECONDS);
        assertBusy(() -> assertEquals(1, ok2.get() + fail2.get()), QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
                executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
        // TransportClient-less mode, client() binds to one of the internal
        return List.of(
/**
@TestLogging(reason = "debugging resilience behavior", value = "org.opensearch.analytics:DEBUG")
            AtomicReference<Throwable> failure = new AtomicReference<>();
     * <p>With {@link #NUM_SHARDS}=3 and ~10 docs/shard, {@code head 5} can be
     * child) must not leak; the build-failure path must surface the cause
                );
            if (response.get() != null) {
                                return;
     */
        createAndSeedIndex();
                public void onFailure(Exception e) { fail.incrementAndGet(); }
    public void testMissingNodeAfterResolution() throws Exception {
            long startNs = System.nanoTime();
            TimeUnit.SECONDS
        ExecutorService exec = Executors.newSingleThreadExecutor();
     * queries. Kept out of {@code @Before} because a couple of tests want to
        bugUrl = "https://github.com/opensearch-project/OpenSearch/pull/21711 — flaky on CI: ReplicationTracker"
            "1.8",
                                try {
        }
            // nested. Without this assertion the query failure swallows the leak.
     * <p>Exercises the streaming-fallback path in {@link MockTransportService}:
            response = executePPL(ppl, QUERY_TIMEOUT);
        return List.of(
            Throwable failure = null;
     */
 */
 * <ul>
        NetworkDisruption disruption = new NetworkDisruption(
        try {
import java.util.concurrent.TimeUnit;
            released.countDown();
    }
        @Override
     *
                raceStart.get(5, TimeUnit.SECONDS);
@LuceneTestCase.AwaitsFix(bugUrl = "Fix flaky recovery bugs before re-enabling")
        long memBefore = dfs.getMemoryPoolUsage();
        AtomicReference<PPLResponse> response = new AtomicReference<>();
    }
        Throwable failure = null;
        String delayNode = null;
                    @Override
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
            handler.messageReceived(request, wrapper, task);
     * into {@code channel.sendResponse(exception)}, which the coordinator
            if (cur.getMessage() != null && cur.getMessage().contains("Memory was leaked")) {
public class CoordinatorResilienceIT extends OpenSearchIntegTestCase {
                        + " | append [ source = " + idxDelay + " | stats count() as cnt ]",
                failure.set(t);
        NetworkDisruption disruption = new NetworkDisruption(
            // Cancel any in-flight analytics tasks.
            assertFalse("cancel must not produce node failures", cancel.getNodeFailures() != null && !cancel.getNodeFailures().isEmpty());
            }
            } catch (Throwable t) {
        ensureFullyConnected();
        try {
        Settings indexSettings = Settings.builder()
                        throw new RuntimeException("injected mid-stream batch failure");
            } catch (Throwable t) {
                            org.apache.arrow.vector.VectorSchemaRoot r = arrow.getRoot();
    @AwaitsFix(
    /**
                    if (response instanceof org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse arrow) {
            "Plan failure must not leak fragment tasks: before=" + beforeCount + " after=" + after.getTasks().size(),
     * LocalStageExecutionFactory nor DatafusionReduceSink is on the hot path.
            if (ids != null) {
            .indices()
     * call returns the prior scheduler so we can restore in {@code finally}.
            mts.clearAllRules();
            try {
                b.registerFactory(StageExecutionType.SHARD_FRAGMENT, e.getValue());
                "Native memory grew after cancel-during-reduce: baseline=" + memBaseline + " after=" + memAfter,
    @After
    }
            };
                failure.set(t);
            );
                }
    public void testCoordinatorSurvivesDisconnectFromOneShard() throws Exception {
    }
     * (DataFusionService, AnalyticsSearchTransportService) is properly reconstructed
        assertTrue(
     * that subsequent queries observe a clean baseline. The propagation half of
        } finally {
                public void onResponse(PPLResponse r) {
            AtomicReference<PPLResponse> response = new AtomicReference<>();
    public void startDeadlockWatchdog() {
        createAndSeedIndex();
     * Suite-wide deadlock detector. Polls {@link ThreadMXBean#findDeadlockedThreads()}
     * contribute zero rows.
                assertEquals("seed not yet visible to analytics path", (long) docs * VALUE, actual);
        createAndSeedIndex();
        NetworkDisruption.NetworkDelay delay = new NetworkDisruption.NetworkDelay(TimeValue.timeValueMillis(300));
     * #G1 — Single-shard happy path. With one shard the planner emits a
     * exercise the pre-index state.
     */
     * {@link ForwardingChannel} that counts {@code sendResponseBatch} calls and
    public void testMidStreamConnectionDropOneShard() throws Exception {
     * Single-shard index pinned to {@code nodeName} via {@code _name} allocation
                // schema-bearing batch so the Flight invariant holds, drop the rest.
                // Give async drain task a moment to tick after the listener fired.
     * still-running sibling — not let the sibling stall on its handler.
                    @Override
                }
            }
        );
        CreateIndexResponse response = client().admin()
            emptyMts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
            mts.clearAllRules();
            long start = System.nanoTime();
        }
            disruption.stopDisrupting();
     * a failed query. Depends on a way to fetch the allocator's usage; we proxy
        if (t == null) return;
    public void testEarlyTerminationLimitSingleShardMultiBatch() throws Exception {
            assertThat(
    public void testCoordinatorPropagatesStageFailure() throws Exception {
            List.of(
     */
    private static void assertNoArrowLeakSuppressed(Throwable t) {
            new NetworkDisruption.TwoPartitions(Collections.singleton(coord), Collections.singleton(victim)),
            });
        }
    // Total distinct doc ids indexed (with 3 shards and default routing, approximate per-shard count only).
    }
    // ----------------------------------------------- C: reduce-stage / concurrency
    }
     * sibling shard task is blocked, the stage must transition to FAILED immediately
 */
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
        assertNoLeakOnSuccess("source = " + INDEX + " | where value = -999999 | stats sum(value) as total");
                public void sendResponseBatch(TransportResponse response) {
     * to short-circuit the merge.
            VectorSchemaRoot vsr = VectorSchemaRoot.create(schema, stubAllocator);
        // Restore cluster size so subsequent @After cleanup is clean.
    }
        long end = dfs.getMemoryPoolUsage();
     */
            internalCluster().clearDisruptionScheme();
        java.util.ArrayDeque<Throwable> queue = new java.util.ArrayDeque<>();
        createSingleShardIndex(SINGLE_SHARD_INDEX, 50);
                        fail.incrementAndGet();
 * 3-shard, 0-replica composite-parquet index seeded with deterministic data.
                } catch (InterruptedException ie) {
                response = fut.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
            fail("JVM-detected deadlock cycle in " + deadlockedThreadIds.length + " thread(s):\n" + dumpAllThreads());
            "source = " + INDEX + " | stats sum(value) as total"
                new org.apache.arrow.vector.types.pojo.Field(
     * task, native-handle reaper, executor pool thread) so even a leak too
                // Expected path: coordinator saw cancellation / failure.
     * but disconnects before the request is sent. NetworkDisruption.DISCONNECT
        // Warm-up so JIT / native caches are primed and baselines reflect steady state.
     * clean error, not an OOM crash.
            if (thisNodeOriginal[0] != null) {
        try {
        }
        createAndSeedIndex();
    /**
     * scheduled tightly with a query in-flight pins the contract: bounded failure,
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
                elapsedSec,
            }
        ExecutorService exec = Executors.newSingleThreadExecutor();
            // Verify the workload was real — otherwise we'd be running 50 successful
            .put("index.pluggable.dataformat", "composite")
                        sink.close();
                handler.messageReceived(request, wrapper, task);
            mts.clearAllRules();
 * does this test. {@link MockTransportService}'s
            handler.messageReceived(request, channel, task);
import org.opensearch.test.junit.annotations.TestLogging;
            System.gc();
            .shardsWithState(org.opensearch.cluster.routing.ShardRoutingState.STARTED)) {
     * released, native handles dropped) and the query must surface the build
        } finally {
        client().execute(
        assertEquals("failing query: exactly one onFailure", 1, fail2.get());
                    + "got null/null → hang. injected="
    //
        executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
     * DAG: N SHARD_FRAGMENT → 1 LOCAL_PASSTHROUGH (concatenate batches).
        assertNull("query must succeed: " + ppl, failure);
    /**
    }
    }
        assertBusy(() -> {
            }
        try (MockLogAppender appender = MockLogAppender.createForLoggers(reduceSinkLogger)) {
        // means this doesn't bleed into other tests.
    /**
    }
     *
        assertNoPendingFragmentTasks();
        assertEquals("row count", 1, response.getRows().size());
 *       on {@link FragmentExecutionAction#NAME}.</li>
     * Within-stage fast-fail contract: when one shard task in a stage throws and a
     * #4 — Intermittent disruption: toggle disconnect on/off; fire query mid-cycle.
            AtomicReference<PPLResponse> response = new AtomicReference<>();
            AtomicInteger fail = new AtomicInteger();
import org.opensearch.ppl.action.PPLResponse;
            disruption.startDisrupting();
package org.opensearch.analytics.resilience;
            );
        long memBaseline = dfs.getMemoryPoolUsage();
                previousByNode.put(node, prev);
 * this file be licensed under the Apache-2.0 license or a
     */
        AtomicInteger okCount = new AtomicInteger();
            exec.awaitTermination(5, TimeUnit.SECONDS);
    /**
                    int n = batchCount.incrementAndGet();
            AtomicInteger fail = new AtomicInteger();
            else sideTwo.add(n);
     */
        } finally {
    public void testScanNoReduceReleasesBufferOnSuccess() throws Exception {
        for (String node : internalCluster().getNodeNames()) {
                b.registerFactory(StageExecutionType.COORDINATOR_REDUCE, e.getValue());
            .index(INDEX)
    // the structural surface, not specific operators. Add a new test only when
        createAndSeedIndex();
        });
        int handleBaseline = NativeHandle.liveHandleCount();
            .cluster()
        assertNotNull("PPL referencing missing field must surface a planning error; got null failure (response=hang?)", failure.get());
            assertTrue(
     * DAG: M independent reduce trees → 1 COORDINATOR_REDUCE Union.
            AtomicReference<Throwable> failure = new AtomicReference<>();
        // Sample task list before to detect any leak after.
            assertEquals(
    public void testStageBuildFailureReleasesEarlierStages() throws Exception {
            client().prepareIndex(INDEX).setSource("value", VALUE).get();
        }
        MockTransportService mts = (MockTransportService) internalCluster().getInstance(TransportService.class, victim);
                            super.sendResponseBatch(arrow);
        disruption.startDisrupting();
                out.put(sr.id(), name);
        }
    }
                failure.set(t);
                            incoming.setRowCount(0);
        // Native memory pool returns to baseline.
                failure = t;
                    UnifiedPPLExecuteAction.INSTANCE,
     * #28 — Mid-stream batch exception. Cleanly returns 3 batches, then 4th throws.
    }
        String victim = firstNonMatching(coord);
     * up a fresh node, heal, re-index, re-query.
            failMts.clearAllRules();
        internalCluster().setDisruptionScheme(disruption);
        // Thread.getAllStackTraces() is forbidden in OpenSearch (needs RuntimePermission
        assertNotNull("need a second shard-host node for the delayed sibling", delayNode);
            // Either error surfaced, or partial response; not a hang.
    public void closeStubAllocator() {
        DataFusionService dfs = internalCluster().getInstance(DataFusionService.class, coordinatorNodeName());
                String name = clusterService().state().nodes().get(nodeId).getName();
            } catch (InterruptedException ie) {
        } finally {
                "cancel request must not carry back node failures",
            for (int i = 0; i < 50; i++) {
    // | multi-input union (append)         | M REDUCE_TREE → 1 union REDUCE            |
    }
        AtomicInteger batchCount = new AtomicInteger(0);
                + " | append [ source = " + INDEX + " | stats count() as cnt ]"
            }
            }, 15, TimeUnit.SECONDS);
    public void testStubReplacesStreamingShardResponseWithEmptyBatch() throws Exception {
        AtomicReference<Throwable> failure = new AtomicReference<>();
        try {
        String victim = firstNonMatching(coord);
            // the reduce-side session is allocated. Tight enough that we
        }
        AtomicInteger fail2 = new AtomicInteger();
            .routingTable()
        disruption.startDisrupting();
 * The OpenSearch Contributors require contributions made to
     */
        java.util.Set<Throwable> seen = java.util.Collections.newSetFromMap(new java.util.IdentityHashMap<>());
            AtomicReference<PPLResponse> response = new AtomicReference<>();
            failure.get() != null || response.get() != null
    // | empty result                       | filter excludes all → empty fan-in        |
     * #21 — Malformed PPL (references a nonexistent field). Coordinator must fail
        ListTasksResponse before = client().admin().cluster().prepareListTasks().setActions(FragmentExecutionAction.NAME).get();
                try {
     * sweeps the running sibling sub-tree, which cancels the parent task and
        // before parquet commits are durable on every shard. Tests in this suite exercise
                released.await(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
        long before = dfs.getMemoryPoolUsage();
 *       unresponsive, delay, intermittent, bridge, mid-query node drops).</li>
     * {@code PlanWalker.build()}: the coordinator-reduce stage builds first
        internalCluster().startNode();
        } catch (Exception ignore) {}
        ensureFullyConnected();
            new PPLRequest("source = " + INDEX + " | stats sum(value) as total"),
            // Brief delay so the dispatch has crossed into the data-node and
     * framework fails this test if any thread spawned during the loop is
        createAndSeedIndex();
            .put("index.composite.primary_data_format", "parquet")
     * <p>The seam is the existing {@link StageExecutionBuilder#registerFactory}
            beforeCount,
     * #G2 — Single-shard shard-failure surfacing. With no reduce stage the failure
                faultCount.get() >= 1
        }
        // search/coordinator resilience, not ingestion — they need a stable post-seed
        MockTransportService failMts = (MockTransportService) internalCluster().getInstance(TransportService.class, failNode);
        // acknowledge those during disruption.
            handler.messageReceived(request, channel, task);
        + "in-process — so transport interception cannot reach the planner-internal failure "
        for (int i = 0; i < n; i++) {
    //
        }
    // | multi-shard scan (no reduce)       | N SHARD_FRAGMENT → LOCAL_PASSTHROUGH      |
     * to the caller and the coordinator-side native pool must return to
        long absoluteCeiling = baseline + 5L * 1024L * 1024L;
     * operations so tests can intercept either path.
            assertThat("Partial sum must be ≥ 0 given the other two shards' contribution", actual, greaterThan(-1L));
/*
        createAndSeedIndex();
     *
        public void sendResponseBatch(TransportResponse response) {
            .put("arrow.memory.debug.allocator", true)
        }
                released.await(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
        Map<Integer, String> map = shardToNode();
        AtomicInteger fail = new AtomicInteger();
     */
     * land the cancel during dispatch. This variant lets the data-node run
            for (Map.Entry<String, StageExecutionFactory> e : originalByNode.entrySet()) {
        @Override
            // Flight protocol invariant that ≥1 schema-bearing frame must precede
                response.get() != null || failure.get() != null
            AtomicReference<PPLResponse> response = new AtomicReference<>();
            assertTrue(
                long actual = ((Number) r.getRows().get(0)[r.getColumns().indexOf("total")]).longValue();
        } finally {
            } catch (Throwable t) {
     * Delegating {@link TransportChannel} whose subclasses override sendResponse
    }
        Thread.sleep(200);
 *
import org.opensearch.tasks.TaskInfo;
                    }
            throw new AssertionError("createSingleShardIndex: timed out waiting for seed durability", e);
                okCount.incrementAndGet();
            Throwable queryFailure = null;
        stubAllocator = new org.apache.arrow.memory.RootAllocator();
    }
        ListTasksResponse after = client().admin().cluster().prepareListTasks().setActions(FragmentExecutionAction.NAME).get();
        MockTransportService delayMts = (MockTransportService) internalCluster().getInstance(TransportService.class, delayNode);
 * org.opensearch.transport.StreamTransportService}'s registry — so injecting
 * @opensearch.internal
     * The framework's {@code ensureFullyConnectedCluster} only takes a single
            }
     * DAG: N SHARD_FRAGMENT (partial sum) → 1 COORDINATOR_REDUCE (final sum).
        client().admin().indices().prepareRefresh(INDEX).get();
        try {
            } catch (Throwable t) {
    public void testPlanFailurePropagates() throws Exception {
        public org.opensearch.Version getVersion() {
     */
            sb.append('\n').append(info.toString());
import org.opensearch.ppl.TestPPLPlugin;
        // dispatch against a surviving node.
                Thread.currentThread().interrupt();
            classpathPlugin(DataFusionPlugin.class, List.of(AnalyticsPlugin.class.getName()))
            try {
import org.opensearch.test.disruption.NetworkDisruption;
    }
        } finally {
                }
     * {@link #client()} dispatches against. Used for disruption topologies that
                String nodeId = sr.currentNodeId();
            assertFalse(
            // The Arrow root allocator's close() throws "Memory was leaked" when any child
            exec.awaitTermination(5, TimeUnit.SECONDS);
    }
        }
        // session / lock and this query would fail or hang.
     * query-shape probe in the {@code testXxxReleasesBufferOnSuccess} family —
            CancelTasksResponse cancel = client().admin().cluster().prepareCancelTasks().setActions(FragmentExecutionAction.NAME).get();
 *   <li>B. Application-layer shard failures injected via
     * early-termination depends on a coordinator-side LIMIT operator existing
    private void ensureFullyConnected() throws Exception {
    // ---------------------------------------------- E: lifecycle / planner / listener (#21-#34)
import org.opensearch.test.transport.MockTransportService;
    }
    // Every query shape hits a different DAG topology on the coordinator. The
                    }
     */
            UnifiedPPLExecuteAction.INSTANCE,
        for (ThreadInfo info : tmx.dumpAllThreads(true, true)) {
                }
        PPLResponse r = executePPL("source = " + SINGLE_SHARD_INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
        createAndSeedIndex();
        // Native memory pool must not leak across the failed build.
            "Native memory pool drifted: baseline=" + baseline + " mid=" + midpoint + " end=" + end + " allowed=" + allowed,
     *
        CreateIndexResponse response = client().admin()
                        }
        long before = dfs.getMemoryPoolUsage();
     * Distinct from {@link #testScanNoReduceReleasesBufferOnSuccess} in that
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                client().execute(
import org.junit.After;
                        org.apache.arrow.vector.VectorSchemaRoot incoming = arrow.getRoot();
            StageExecutionBuilder builder = internalCluster().getInstance(QueryScheduler.class, node).getStageExecutionBuilder();
        }
        }
            faultCount.incrementAndGet();
     * are unneeded. A failure to honor the limit (returns >5 rows) or a hang
        if (deadlockedThreadIds != null) {
     */
    /**
            end <= allowed
        }
    }
        String coord = coordinatorNodeName();
     * whichever behavior is actually implemented.
        }
                    Object cell = response.get().getRows().get(0)[idx];
        } catch (IllegalStateException ignore) {
            }
            .build();
            NetworkDisruption.DISCONNECT
    // coverage lives in #17 (testCoordinatorReleasesBufferOnFailure).
        for (String node : internalCluster().getNodeNames()) {
            assertTrue(
            public void onFailure(Exception e) {
     */
        }
    /**
                        batch.close();
        // Fire a query then attempt to kill the coordinator — note: the client()
        assertNoPendingFragmentTasks();
            .get();
// TEST-scope: each test gets a fresh cluster — disruption schemes and killed
        try {
import org.apache.lucene.tests.util.LuceneTestCase;
    @Override
            disruption.stopDisrupting();
        assertThat("need ≥2 shard-host nodes", map.values().stream().distinct().count(), greaterThan(1L));
                            // Already forwarded a zero-row schema frame — drop subsequent batches.
     * onFailure) fires per query, normal or failing.
                memAfter <= memBaseline + 1024 * 1024
        String victim = pickShardHostingNode();
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;
        String[] hosts = map.values().stream().distinct().toArray(String[]::new);
            handler.messageReceived(request, wrapper, task);
        int baseline = NativeHandle.liveHandleCount();
        NetworkDisruption disruption = new NetworkDisruption(
        errorMts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
        // Force multiple batches per shard so the coordinator has to honor
        AtomicInteger failCount = new AtomicInteger();
    public void testHeadEarlyTerminationReleasesBufferOnSuccess() throws Exception {
    /**
    /**
                executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
        if (stubAllocator != null) {
                    }
                    failed++;
            if (prev != null) {
        // helper resolves to a cluster-wide client, so post-crash it can still
        ensureStableCluster(internalCluster().getNodeNames().length);
        @Override
    private static String dumpAllThreads() {
     */
            client().prepareIndex(name).setSource("value", VALUE).get();
            .build();
        String idxFail = "sibling_leg_fail";
            assertTrue(
     * On a child-stage failure, the coordinator-side reduce sink's drain task
import java.util.concurrent.atomic.AtomicInteger;
            // to the parent stage is a separate cascade concern). What we forbid is
        );
    protected Collection<PluginInfo> additionalNodePlugins() {
            try {
    private void createSingleShardIndex(String name, int docs) {
    public void testNoDataReturnedFromShard() throws Exception {
                    return executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT);
                // race fired during reduce) or it had already completed before
        } finally {
    }
    /**
     * the contract is universal, only the DAG shape exercised varies.
     * — the post-condition (no leak across either landing) must hold regardless.
            );
            // OR the parent reduce stage races ahead and emits a wrong result from an
            // place would poison subsequent tests in the suite.
     * a common production topology where coordinators are separate from data nodes.
    }
     * past timeout, not leak FragmentExecutionAction tasks.
        for (ShardRouting sr : clusterService().state()
            long memAfter = dfs.getMemoryPoolUsage();
        DataFusionService dfs = internalCluster().getInstance(DataFusionService.class, coordinatorNodeName());
            NetworkDisruption.DISCONNECT
        createSingleShardIndex(SINGLE_SHARD_INDEX, 30);
            @Override
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            deadlockWatchdog.shutdownNow();
            new NetworkDisruption.Bridge(bridge, sideOne, sideTwo),
                "Faulting SHARD_FRAGMENT scheduler must have fired at least once (failure=" + failure.get() + ")",
    /** Map each primary shard id → node name that currently hosts it. */
            long memAfter = dfs.getMemoryPoolUsage();
                            }
        client().admin().indices().prepareRefresh(name).get();
            int handleAfter = NativeHandle.liveHandleCount();
            classpathPlugin(AnalyticsPlugin.class, Collections.emptyList()),
        String victim = pickShardHostingNode();
        createSingleShardIndex(SINGLE_SHARD_INDEX, 100);
            createAndSeedIndex();
    @After
     * disruption queries) need this; silently swallowing the assertion error
        });
 *   <li>C. Reduce-stage / DataFusion backend faults + concurrency hygiene.</li>
     * reduce sink (i.e. {@code DatafusionReduceSink}, the in-process component fed
        createAndSeedIndex();
            ArrowBasePlugin.class,
                } catch (Throwable t) {
     * AssertionError("unexpected") from {@code excludeClusterManagers}. The
                if (idx < 0 || response.get().getRows().isEmpty()) {
                "org.opensearch.be.datafusion.DatafusionReduceSink",
            try {
            // past QUERY_TIMEOUT. Either the failure surfaces as an exception (preferred),
            .put(super.nodeSettings(nodeOrdinal))
        MockTransportService delayMts = (MockTransportService) internalCluster().getInstance(TransportService.class, delayNode);
        // already stopped it, but this guards against assertion failures aborting
import org.opensearch.core.transport.TransportResponse;
        try {
                Thread.currentThread().interrupt();
        });
            // Mirrors LocalStageExecutionFactory's wrapping when ExchangeSinkProvider.createSink throws.
     * Derive the coordinator-side node name — the node that the default
        // child build threw.
        } catch (Throwable t) {
                memAfter <= memBefore + 1024 * 1024  // 1MiB slack for runtime heap moves (matches #17)
     */
        assertBusy(() -> {
            );
                delayNode = n;
        } finally {
        createAndSeedIndex();
                    public void feed(VectorSchemaRoot batch) {
            assertThat("stub must fire on the streaming-only fragment action", stubCalls.get(), greaterThan(0));
            });
     * wrapping channel. On the streaming path the wrapper drops every emitted
     * #29 — Connection drop mid-stream on one shard's stream. NetworkDisruption
            );
    // | Shape                              | DAG topology                              |
        String coord = coordinatorNodeName();
        ensureFullyConnected();
                StageExecutionBuilder b = internalCluster().getInstance(QueryScheduler.class, e.getKey()).getStageExecutionBuilder();
                ok2.incrementAndGet();
            Thread.sleep(150);
                        throw new RuntimeException("injected reduce-sink feed failure");
                failure.set(t);
        createAndSeedIndex();
        String bridge = allNodes.iterator().next();
                @Override
     * (200 was the spec target; reduced to keep test budget under 60s with
            mts.clearAllRules();
        assertScalarLong(r, "total", EXPECTED_SUM);
        AtomicInteger stubCalls = new AtomicInteger();
        );
     * consensus (it adds voting-config exclusions before shutdown), which a
        while (!queue.isEmpty()) {
     */
    // function or filter type.
        long relativeCeiling = (long) (baseline * 1.10);
                "drain task terminated with closed allocator",
                    }
     */
        for (String n : internalCluster().getNodeNames()) {
            StageExecutionFactory prev = b.registerFactory(StageExecutionType.SHARD_FRAGMENT, faulting);
        + "contexts) after a planner-injected failure. Deferred until UnifiedQueryPlanner "
        createAndSeedIndex();
            remaining.getTasks().isEmpty()
            }
import java.util.concurrent.CountDownLatch;
                long actual = ((Number) r.getRows().get(0)[r.getColumns().indexOf("total")]).longValue();
            }
     */
     * side state (none, in this case — the reduce stage builds before any
    private static void assertScalarLong(PPLResponse response, String column, long expected) {
        try {
        });
        // Failing query (bad field — guaranteed plan failure from #21).
            );
            .setMapping("value", "type=integer")
     * draining shard streams once the result limit is satisfied — it should
     * the coordinator merges streams from multiple shards.
    }
        createAndSeedIndex();
        // Parent task is gone.
                released.await(delaySeconds, TimeUnit.SECONDS);
     * (5 per shard). Fix is in the planner, not the reduce-sink lifecycle —
        // Dispatch through the coordinating-only node specifically.
            mts.clearAllRules();
     * mid-construction. Earlier stages must close (their backend sinks are
     * cause without traversing the reduce-stage error path.
            assertThat(
    @Before
 * </ul>
        String victim = singleShardHostingNode(SINGLE_SHARD_INDEX);
                        }
     */
            AtomicInteger ok = new AtomicInteger();
        try {
    // ---------------------------------------------- F: topology variations
     * (root, allocates a native session via {@code ExchangeSinkProvider.createSink}),
 * Resilience / fault-injection suite for the analytics-engine coordinator
        // pluggable_dataformat=composite + parquet primary: prepareFlush().get() returns
                .cluster()
        );
    public void testCoordinatorSurvivesUnresponsiveShard() throws Exception {
        }
        createAndSeedIndex();
        public void sendResponse(Exception exception) throws java.io.IOException {
        + "opensearch/analytics/exec/DefaultPlanExecutor.java (transport entry, around the "
            MockTransportService.TestPlugin.class,
        );
            if (sr.primary()) {
            } catch (Throwable t) {
import org.opensearch.analytics.exec.stage.StageExecutionBuilder;
            disruption.stopDisrupting();
            channel.sendResponseBatch(
                    + "s; if this approaches the latch timeout, the sibling stage stalled instead of being cancelled",
        String[] nodes = internalCluster().getNodeNames();
            // Hanging past QUERY_TIMEOUT surfaces as actionGet timeout → ignored
                        }
        );
        assertTrue(
                @Override
                failure.set(t);
                response.set(executePPL("source = " + INDEX + " | stats sum(value) as total", QUERY_TIMEOUT));
            .prepareCreate(INDEX)
        deadlockWatchdog.scheduleAtFixedRate(() -> {
                    "Native memory usage grew after failure: before=" + before + " after=" + after,
     * DAG: N SHARD_FRAGMENT each producing zero rows → 1 reduce. The reduce
        try {
        createSingleShardIndex(SINGLE_SHARD_INDEX, 10);
    // Each test asserts (a) no Arrow leak surfaces via the result, (b) the
     * brief disruption window before the kill still exposes the coordinator
        mts.addRequestHandlingBehavior(FragmentExecutionAction.NAME, (handler, request, channel, task) -> {
     * NodeNotConnectedException as the test failure.
            );
            // Wrap the streaming channel: let the real handler run, but substitute its row
            Future<PPLResponse> fut = exec.submit(() -> {
        CountDownLatch released = new CountDownLatch(1);
            failure.set(t);
            );
        assertTrue("index creation must be acknowledged", response.isAcknowledged());
     */
        NetworkDisruption disruption = new NetworkDisruption(
    }
            // by AtomicReference failure capture only if we add per-call timeout.
            // allocator still owns buffers. QueryContext.closeBufferAllocator attaches that
            try {
            internalCluster().clearDisruptionScheme();
            } finally {
            if (cur == null || !seen.add(cur)) continue;
            } catch (Throwable t) {
            assertBusy(() -> assertEquals(1, ok.get() + fail.get()), QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
            }
        try {
import java.lang.management.ThreadInfo;
            disruption.stopDisrupting();
                failure.set(t);
     * retry until success or 30s. Tests that assume a healed cluster (post-
            inFlight.get(QUERY_TIMEOUT.seconds(), TimeUnit.SECONDS);
     * not a hang.
     * up through {@code failWithCause}; the cascade's parent-state listener then
     *
     * aggregation because partial-aggregate batches carry the grouping column
    @AwaitsFix(
                };
            long[] ids = mxBean.findDeadlockedThreads();
            // ServerConfig#init unconditionally sets the arrow.memory.debug.allocator
            }, 30, TimeUnit.SECONDS);
     * coordinator does today (complete-success, partial, fail-fast).
     * #15 — Workload driver for failure-path leak detection. Runs 50 failing
            delegate.sendResponse(response);
            assertEquals("single-shard failure must surface as exactly one onFailure", 1, fail.get());
     * exception on one node). The coordinator listener must fire exactly once.
                cancel.getNodeFailures() != null && !cancel.getNodeFailures().isEmpty()
            } catch (Throwable t) {
        }
        // record voting-config exclusions, and the disrupted victim can't
                                try {
     * exception cleanly.
    public void testSortWithPushdownReleasesBufferOnSuccess() throws Exception {
        assertThat(column, ((Number) cell).longValue(), equalTo(expected));
            released.countDown();
    private PPLResponse executePPL(String ppl, TimeValue timeout) {
     * stage has to handle the empty-input close path correctly.
            delegate.sendResponseBatch(response);
        try {
        }
            assertTrue(
        try {
    public void testMultiChildStageFailureCancelsRunningSibling() throws Exception {
        try {
        + "main/java/org/opensearch/analytics/planner/PlannerImpl.java (planner internals). "
        MockTransportService errorMts = (MockTransportService) internalCluster().getInstance(TransportService.class, errorNode);
     * Shape: simple aggregation (no group-by).
                response.get() == null ? "null" : response.get().getRows().size() + " rows",
     * lets them fire against a half-connected cluster and surface a misleading
            internalCluster().clearDisruptionScheme();
import org.opensearch.parquet.ParquetOnlyDataFormatPlugin;
    /** #2 — UNRESPONSIVE: drops packets silently; coordinator should hit its own timeout, not spin. */
        // Post-heal: query returns correct sum.
            NetworkDisruption.UNRESPONSIVE
    /** Returns the node hosting the single primary shard of {@code indexName}. */
     * buffers — the definitive oracle that a failure-path cleanup path missed a close.
    private static PluginInfo classpathPlugin(Class<? extends Plugin> pluginClass, List<String> extendedPlugins) {
            assertTrue(
            }
            });
            thisNodeOriginal[0] = builder.registerFactory(StageExecutionType.SHARD_FRAGMENT, perNodeFaulting);
                TransportChannel wrapper = new ForwardingChannel(channel) {
        // Schema width must match the coordinator's declared input-partition schema — that's
            try {
     * as #23 but replaces the {@code COORDINATOR_REDUCE} scheduler with
                try {
                        if (schemaForwarded) {
    private PPLResponse executePPL(String ppl) {
        return client().execute(UnifiedPPLExecuteAction.INSTANCE, new PPLRequest(ppl)).actionGet(timeout);
     * because {@link InternalTestCluster#stopRandomNode} requires cluster
        PPLResponse healed = executePPL("source = " + INDEX + " | stats sum(value) as total");
     * queries in a row to amplify any per-failure leak (orphaned fragment
        try {
            disruption.stopDisrupting();
    }
     * DAG: N SHARD_FRAGMENT producing more rows than head() needs; coordinator
            long elapsedMs = (System.nanoTime() - start) / 1_000_000L;
 *
import org.opensearch.ppl.action.UnifiedPPLExecuteAction;
        bugUrl = "https://github.com/opensearch-project/OpenSearch/pull/21711 — flaky on CI: cluster fails to form"
import org.opensearch.be.datafusion.DataFusionService;
            client().execute(
                @Override
            org.opensearch.core.action.ActionListener<PPLResponse> listener = new org.opensearch.core.action.ActionListener<>() {
            mts.clearAllRules();
     * read batch size so the shard's stream emits multiple batches.
        disruption.startDisrupting();
            Throwable failure = null;
                1,
            Thread.sleep(200);
        internalCluster().setDisruptionScheme(disruption);
        }
            }
        }
     * the cross-shard merge. With 3 shards, {@code head 5} returns 15 rows
                }
        assertNoLeakOnSuccess("source = " + INDEX + " | stats sum(value) as total");
    }
            Thread.sleep(500);
     * their own input partition. Distinct close path from single-input reduce.
                exception || wrongResult
    }
        }, 30, TimeUnit.SECONDS);
            exec.shutdownNow();
     */
    public void testCancelDuringReduce() throws Exception {
        + "request only AFTER transport dispatch — i.e. after planning has kicked off "
            } catch (ExecutionException | TimeoutException ignore) {}
    private static final String SINGLE_SHARD_INDEX = "single_shard_idx";
// SUITE-scope default inherited from OpenSearchTestCase so failure-path leaks
     *
        ensureFullyConnected();
import java.lang.management.ManagementFactory;
     * with a bounded error (good) or hang past the request timeout (bug)?
            Thread.sleep(75);
        + "contract (planner failure surfaces + no leaked FragmentExecutionAction tasks) is "
    /**
            TransportChannel wrapper = new ForwardingChannel(channel) {
        assertNoLeakOnSuccess("source = " + INDEX + " | sort value");
        NetworkDisruption disruption = new NetworkDisruption(
                ((MockTransportService) internalCluster().getInstance(TransportService.class, node)).clearAllRules();
        String victim = pickShardHostingNode();
        );
        // No leaked fragment tasks (planning failure must short-circuit before dispatch).
            disruption.stopDisrupting();
        assertNoArrowLeakSuppressed(failure);
        assertTrue("No residual UnifiedPPLExecute tasks after cancel: " + remaining.getTasks(), remaining.getTasks().isEmpty());
            ListTasksResponse tasks = client().admin().cluster().prepareListTasks().setActions(FragmentExecutionAction.NAME).get();
                "UNRESPONSIVE must produce a failure or partial result, not a silent null",
        }
            long elapsedSec = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startNs);
            try {
        // Inject failure on one shard-host. With STREAM_TRANSPORT enabled, the
        createSingleShardIndex(SINGLE_SHARD_INDEX, 50);
            }
                "Pending fragment tasks remain: " + infos.stream().map(t -> t.getTaskId().toString()).collect(Collectors.joining(", ")),
    }
     * <p>Distinct from {@link #testMultiChildStageFailureCancelsRunningSibling}: that
        ListTasksResponse remaining = client().admin().cluster().prepareListTasks().setActions(UnifiedPPLExecuteAction.NAME).get();
                "*drain task terminated*"
    private static final int NUM_SHARDS = 3;
        return sb.toString();
     *
        createAndSeedIndex();
    private void createSingleShardIndexOnNode(String name, int docs, String nodeName) {
            delay
        }
        try {
        assertEquals("LIMIT must produce exactly the requested row count", 5, r.getRows().size());
        assertTrue("response must contain column " + column, idx >= 0);
                // its active-import window when the injected failure fires.
     * returned row count must equal the requested limit.
                    @Override
    private String firstNonMatching(String name) {
            assertTrue(
            AtomicReference<PPLResponse> response = new AtomicReference<>();
     * #26 — Race: a node is in the dispatch target set when cluster state was read
        PPLResponse r = executePPL("source = " + INDEX + " | head 5", QUERY_TIMEOUT);
        // Crank limit down before indexing so the query's native state can't fit.
        String victim = singleShardHostingNode(SINGLE_SHARD_INDEX);
        ensureFullyConnected();
        if (deadlockWatchdog != null) {
                Thread.currentThread().interrupt();
            }
        AtomicInteger fail = new AtomicInteger();
        internalCluster().setDisruptionScheme(disruption);
            );
    /**
            allowed = absoluteCeiling;
        // With 0 replicas, the index has lost data on killed node — recreate.
        AtomicBoolean thrown = new AtomicBoolean(false);
            ));
import java.util.concurrent.ExecutionException;
        client().admin()
        // which closes any backend sink the reduce path created before the
