                        } catch (Throwable ignore) {
    private final CapabilityRegistry capabilityRegistry;
                    toInject.add(Map.entry(scan.getBuildStageId(), ipc));
                capabilityRegistry,
    public UnifiedDispatch(
                        cancelOtherBuilds(buildRoots, buildExec, "sibling broadcast build cancelled");
import org.opensearch.analytics.spi.InstructionNode;
        List<StageExecution> buildRoots = new ArrayList<>(builds.size());
                                if (waveIndex + 1 < waves.size()) {
            cancelCallbackInstalled,
 *
            throw new IllegalStateException("No reduce-capable backend for broadcast capture sink (general scheduler)");
            }
public final class UnifiedDispatch {
import java.util.concurrent.atomic.AtomicReference;
            stage.getExchangeInfo(),
    private List<String> resolveTargetWorkerNodeIds(int partitionCount) {
        // The cancel callback is installed once, by the first wave, but must cancel whichever wave is in
                try {
        int waveIndex,
    private void dispatchBroadcastFree(
                        }
                            capturedByBuildId.put(buildId, ipc);
    private final ClusterService clusterService;
     */
            QueryDAG finalDag = postRewrite.apply(dag);
                        if (remaining.decrementAndGet() == 0) {
        for (Stage child : stage.getChildStages()) {
    }
import org.opensearch.analytics.planner.dag.QueryDAG;
            public void onResponse(Iterable<VectorSchemaRoot> result) {
                }
        ClusterService clusterService,
            .createBroadcastCaptureSink(ctx.bufferAllocator(), stage.getFragment().getRowType(), broadcastMaxBytes);
 * them in order, each adding to the same native session — see
        }
        Function<QueryDAG, QueryDAG> postRewrite,
import org.opensearch.analytics.exec.QueryContext;
 * this file be licensed under the Apache-2.0 license or a
        // Publish this wave's roots AFTER every listener is installed, so the cancel callback cancels the
     * Capture phase, run as WAVES ordered innermost-first, then inject + strip + dispatch the
 */
     * {@code forkAll → convertAll} which REPLACES every stage's plan alternatives, so the broadcast
            for (StageExecution buildExec : buildRoots) {
    }
        ActionListener<Iterable<VectorSchemaRoot>> terminal
        this.sortMergeJoinMinRows = sortMergeJoinMinRows;
            waves,
        AnalyticsQueryTask parentTask = ctx.parentTask();
     * Resolves the IPC capture-sink factory for this query (the reduce-capable backend's broadcast capture
            }
        if (cancelCallbackInstalled.compareAndSet(false, true)) {
    private void captureThenDispatch(
            Stage rebuilt = stripBuildChildren(child, capturedByBuildId);
                queryExecutionSink.accept(exec);
import java.util.concurrent.CompletableFuture;
        return waves;
            injectBroadcastsInPlace(child, capturedByBuildId);
        Map<Integer, byte[]> capturedByBuildId,
import org.opensearch.analytics.exec.QueryScheduler;
                    default -> {
        this.preferMetadataDriver = preferMetadataDriver;
    /** Copies a stage with new children, preserving role / exchange / resolver / factory / plan alternatives. */
    }
        Stage root = dag.rootStage();
    }
                        }
     *  already injected). Other stages are copied with children rebuilt so siblings are preserved. */
    ) {
                                        waves,
            } catch (Exception e) {
     * that is itself a broadcast probe lands in a strictly earlier wave than the build it feeds. That is the
import org.opensearch.analytics.AnalyticsSettings;
        );
        Map<Integer, byte[]> capturedByBuildId,
     * bypasses the normal {@code QueryScheduler.execute} cancel path (the capture schedules build leaves
        for (Stage rawBuildStage : builds) {
import org.opensearch.analytics.exec.stage.StageExecution;
        Function<Stage, ExchangeSink> captureSinkFactory,
        QueryDAG dag,
                    case FAILED -> {
     * @param captureSinkFactory creates the backend IPC capture sink for a build stage's output rowType
        if (byDepth.isEmpty()) {
     *
            stage.getFragment(),
            captureThenDispatch(ctx, dag, waves, captureSinkFactory, queryExecutionSink, terminal);
                }
        }
                        // buildSideIndex 0: informational only — the NamedScan resolves by name on the data node.
        CapabilityRegistry capabilityRegistry,
                        terminal.onFailure(cause != null ? cause : new RuntimeException("broadcast build stage " + buildId + " FAILED"));
            List<OpenSearchBroadcastScan> scans = RelNodeUtils.findNodes(stage.getFragment(), OpenSearchBroadcastScan.class);
            LOGGER.debug("[UnifiedDispatch] capture phase cancel requested, reason={}", reason);
    private static void installCaptureCancelCallback(QueryContext ctx, AtomicReference<List<StageExecution>> activeRoots) {
            return List.of();
            dag,
            // Promote shuffle joins to worker tiers (forkAll → adaptAll → selectAll → convertAll), THEN apply
        Stage copy = new Stage(
        return new ActionListener<>() {
        StageExecutionBuilder builder = scheduler.getStageExecutionBuilder();
    /**
    /**
        boolean changed = false;
        CapabilityRegistry capabilityRegistry,
            if (waves.isEmpty()) {
        QueryDAG dag,
     * build it once and hand it in — identical to the legacy broadcast path's factory.
     * Builds and schedules every build in wave {@code waveIndex} concurrently. On wave completion, either
            queryExecutionSink,
/*
 *
    /**
 * {@code AnalyticsSearchService.applyInstructionHandlers}), the SAME stage can be both a broadcast
                scheduler::scheduleStage
     * <p>A build's depth is the number of BROADCAST_BUILD stages strictly between it and the root, so a build
        Consumer<QueryExecution> queryExecutionSink,
import java.util.Map;
        // the enrich or be discarded by it. Returns the same DAG.
        AtomicInteger remaining = new AtomicInteger(builds.size());
        return stage -> capabilityRegistry.getBackend(captureBackendId)
        AnalyticsQueryTask parentTask = ctx.parentTask();
                            if (ctx.parentTask() != null && ctx.parentTask().isCancelled()) {
            StageExecutionBuilder.SubGraph buildGraph = builder.buildSubGraphWithSink(
                            );
     * {@code DataConsumer}, which it is not. Capturing every build in one flat pass (the previous shape)
     */
     * distributes a join, else plain. {@code postRewrite} is an optional hook applied to the rewritten DAG
            scheduler.scheduleStage(leaf);
    }
                        } catch (Throwable ignore) {
            installCaptureCancelCallback(ctx, activeRoots);
        Consumer<QueryExecution> queryExecutionSink,
                                        queryExecutionSink,
            return rewrittenDag;
                        LOGGER.debug(
     * The build children are stripped BEFORE the rewrite so the rewriter never tries to promote/wire an
            // DistributedAggOverJoinDispatch ordering contract).
                            // primary failure surfaced below
                    LOGGER.debug(new ParameterizedMessage("[UnifiedDispatch] cancel failed for build {}", buildExec.getStageId()), e);
                    case CANCELLED -> {
 */
import org.apache.logging.log4j.Logger;
            }
     * during a later wave still cancels live executions. Phase-2's {@code execute} replaces this callback with
        this.capabilityRegistry = capabilityRegistry;
        }, queryExecutionSink, terminal);
        captureWave(
     *     (the sink exposes {@code CompletableFuture<byte[]> ipcBytesFuture()} completed by {@code close()}).
        if (stage.getFragment() != null) {
        Stage strippedRoot = stripBuildChildren(dag.rootStage(), capturedByBuildId);
        if (parentTask == null) {
            // is once-only, so the query is failed exactly once.
        this.clusterService = clusterService;
            try {
        // Accumulates across waves: a wave's builds are prepared against everything captured before it.
        for (int p = 0; p < partitionCount; p++) {
        long sortMergeJoinMinRows
                    }
        final long broadcastMaxBytes = clusterService.getClusterSettings().get(AnalyticsSettings.BROADCAST_MAX_BYTES).getBytes();
            QueryExecution exec = scheduler.execute(ctx.withDag(finalDag), terminal);
                            try {
            terminal.onFailure(e);
    /** Round-robins one target worker node per partition across the cluster's data nodes (shuffle promotion). */
            }
     * <p>The residual dispatch happens once, after the LAST (shallowest) wave.
            return;
    @SuppressWarnings("unchecked")
        QueryContext ctx,
        );
        }
        if (!changed) {
    ) {
     * so they survive the alternative re-expansion. Without a broadcast it is identity.
                    }
import org.opensearch.analytics.exec.QueryExecution;
                buildStage,
                if (done.compareAndSet(false, true)) {
     * its own walker-level cancel.
     * its OWN build has been captured and stripped out of its subtree, because otherwise
 * <p><b>Broadcast is an INSTRUCTION, not a stage type.</b> A stage that consumes a broadcast carries a
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
            QueryDAG finalDag = postRewrite.apply(rewritten.dag());
    private byte[] extractIpcBytes(ExchangeSink captureSink) throws Exception {
import java.util.function.Consumer;
        int maxDepth = byDepth.keySet().stream().max(Integer::compare).orElse(0);
            });
        collectBuildsByDepth(root, 0, byDepth);
                        try {
                            ipc = extractIpcBytes(captureSink);
import java.util.ArrayList;
    }
            // THEN enrich the per-level shuffle instructions and dispatch.
import java.util.LinkedHashMap;
        boolean preferMetadataDriver,
        }
            // and cancel() no-ops on a terminal state, so no listener ran. Returning here without cancelling
            if (child.getRole() == Stage.StageRole.BROADCAST_BUILD && capturedByBuildId.containsKey(child.getStageId())) {
            GeneralShuffleDAGRewriter.Rewritten rewritten = GeneralShuffleDAGRewriter.rewrite(
        for (Stage child : stage.getChildStages()) {
    }
 * SPDX-License-Identifier: Apache-2.0
    private static ActionListener<Iterable<VectorSchemaRoot>> onceOnly(AtomicBoolean done, ActionListener<Iterable<VectorSchemaRoot>> raw) {
                                        terminal
                    buildExec.cancel("task cancelled before wave " + waveIndex + " was scheduled");
    private final QueryScheduler scheduler;
import org.opensearch.core.tasks.TaskCancelledException;
    private void injectStripAndDispatch(
 * @opensearch.internal
 * we never need a stage to hold two {@code StageRole}s. This dispatcher therefore:
                if (done.compareAndSet(false, true)) {
import org.opensearch.analytics.planner.CapabilityRegistry;
import org.opensearch.analytics.spi.BroadcastInjectionInstructionNode;
                            }
            final int buildId = buildStage.getStageId();
            // postRewrite (broadcast injection survives because it runs after the alternative re-expansion),
 *       of each build — located by the {@link OpenSearchBroadcastScan} that references the build id, which
                stage.setPlanAlternatives(enriched);
 * <p>This composes broadcast with shuffle at ANY nesting (a small build under a shuffle cascade — TPC-H
     */
     * directly), and reads {@code activeRoots} rather than closing over one wave's list so a cancel arriving
 *
            if (queryExecutionSink != null) {
        List<List<Stage>> waves,
            }
        List<Stage> builds = waves.get(waveIndex);
        return copyStage(stage, rebuiltChildren, stage.getPlanAlternatives());
     * broadcast-free residual.
package org.opensearch.analytics.exec.join;
        QueryContext ctx,
        return copy;
        }
 *
    }
import org.opensearch.analytics.planner.dag.GeneralShuffleDAGRewriter;
import org.opensearch.analytics.spi.ExchangeSink;
                preferMetadataDriver,
     * INNERMOST-FIRST: wave 0 holds the most deeply nested builds, the last wave the shallowest.
                                        waveIndex + 1,
    private static Stage stripBuildChildren(Stage stage, Map<Integer, byte[]> capturedByBuildId) {
     * ordering {@link #captureWave} needs: a build's own builds must already be captured (and therefore
            injectBroadcastsInPlace(buildStage, capturedByBuildId);
            for (StageExecution buildExec : activeRoots.get()) {
        QueryDAG dag,
        }
            QueryExecution exec = scheduler.execute(ctx.withDag(finalDag), terminal);
            StageExecution buildExec = buildGraph.root();
     * {@code buildSubGraphWithSink} walks into that un-stripped child and asks a shard fragment to be its
 * consumer AND a shuffle producer / worker: broadcast-inject, then join, then hash-partition + ship. So
     */
        Map<String, org.opensearch.cluster.node.DiscoveryNode> dataNodes = clusterService.state().nodes().getDataNodes();
    /**
                            captureSink.close();
                queryExecutionSink.accept(exec);
            if (queryExecutionSink != null) {
    }
        // also appends instructions in place to the same worker stages — a rebuild here would either discard
     * <p><b>Why waves.</b> A broadcast build can itself be a broadcast probe — nested broadcast, e.g. a
     * dispatches the broadcast-free residual; otherwise dispatches directly.
        Method m = captureSink.getClass().getMethod("ipcBytesFuture");
 * compatible open source license.
    /**
            }
                    case SUCCEEDED -> {
                waves.add(wave);
    ) {
    private static void collectBuildsByDepth(Stage stage, int depth, Map<Integer, List<Stage>> byDepth) {
        AtomicReference<List<StageExecution>> activeRoots,
    /**
        dispatchBroadcastFree(ctx, strippedDag, rewrittenDag -> {
            children,
                            ipc == null ? -1 : ipc.length
     */
                }
        for (Stage child : stage.getChildStages()) {
            Stage buildStage = stripBuildChildren(rawBuildStage, capturedByBuildId);
                        } catch (Throwable t) {
            if (other == self) {
                                    );
                    raw.onResponse(result);
     * published its roots to {@code activeRoots} (see the caller — the replay ordering is load-bearing). It
     *
                        }
                for (StagePlan sp : stage.getPlanAlternatives()) {
                            // primary cancel surfaced below
import org.opensearch.analytics.planner.dag.StagePlan;
     */
            if (!toInject.isEmpty()) {
     * Installs the capture-phase cancel callback ONCE, from the FIRST wave and only after that wave has
        // flight — hence the shared reference rather than a capture of one wave's list.
            stage.getTargetResolver()
        QueryContext ctx,
                            } catch (Exception e) {
 *       in isolation into an Arrow-IPC capture sink and collect the bytes keyed by
            // common single-level case, where capturedByBuildId is still empty.
            // cancelled — a later listener would miss the CANCELLED transition; the BroadcastDispatch /
     * Drives the enforced DAG. When it contains any broadcast build, runs the capture phase first, then
        }
    }
import org.apache.logging.log4j.message.ParameterizedMessage;
 * {@link BroadcastInjectionInstructionNode} on its plan; the data-node handler chain registers the
            );
                continue;
            return List.of();
     * Groups every {@link Stage.StageRole#BROADCAST_BUILD} stage in the DAG into capture waves, ordered
                byte[] ipc = capturedByBuildId.get(scan.getBuildStageId());
                                    : "unknown";
 *       consumes it.</li>
        // wave that is actually in flight.
        try {
import java.util.List;
                        }
            if (wave != null && !wave.isEmpty()) {
     * already-captured build.
        List<StageExecution> allLeaves = new ArrayList<>();
        Function<Stage, ExchangeSink> captureSinkFactory,
        parentTask.setOnCancelCallback(() -> {
            }
        if (reduceViable.isEmpty()) {
        QueryScheduler scheduler,
 * q3/q8/q9; a shuffle join above a broadcast — q17; a standalone broadcast — q12) because the broadcast
                            waveIndex,
            collectBuildsByDepth(child, childDepth, byDepth);
                                terminal.onFailure(e);
                            LOGGER.warn(
    }
                        synchronized (capturedByBuildId) {
            // would leave nothing to complete the terminal and the query would hang. Driving our own roots to
            0,
            @Override
            // CANCELLED routes through the same CANCELLED listener every other cancel path uses, and `terminal`
        // postRewrite: inject the captured broadcasts into the (post-fork) consumer stages IN PLACE. In-place
    /**
            );
            // Listener BEFORE the cancel callback (setOnCancelCallback replays synchronously when already
                    List<InstructionNode> merged = new ArrayList<>(sp.instructions());
 * Single dispatch entry point for the GENERAL post-CBO scheduler (Option B — see
                List<StagePlan> enriched = new ArrayList<>(stage.getPlanAlternatives().size());
            }
                                        activeRoots,
        if (parentTask != null && parentTask.isCancelled()) {
        }
        // is that replay — cancelling each root, whose CANCELLED listener fails the terminal — that reports
    /**
    private static Stage copyStage(Stage stage, List<Stage> children, List<StagePlan> planAlternatives) {
 *       {@code broadcast-<buildStageId>}.</li>
                switch (to) {
                            }
        }
     *
        }
        List<String> nodeIds = new ArrayList<>(dataNodes.keySet());
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.core.action.ActionListener;
        ActionListener<Iterable<VectorSchemaRoot>> terminal
/**
        for (StageExecution other : buildRoots) {
                                }
    private static List<List<Stage>> collectBuildWaves(Stage root) {
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastScan;
                    buildExec.cancel("task cancelled: " + reason);
        List<String> targets = new ArrayList<>(partitionCount);
        }
            }
     */
                                        cancelCallbackInstalled,
        // fires, and the query hangs. UnifiedDispatchTests#testRunFailsTerminalWhenTaskCancelledBeforeRun
        Function<Stage, ExchangeSink> captureSinkFactory,
        copy.setPlanAlternatives(planAlternatives);
                            buildId,
                } catch (Exception e) {
    private final boolean preferMetadataDriver;
     * shard leaf, a shuffle producer, or a worker — the instruction composes with whatever else the stage
    ) {
            captureSinkFactory,
        });
    }
import java.util.concurrent.TimeUnit;
        return targets;
                        );
        // the cancellation. Installing it before any roots exist makes the replay cancel nothing, no listener
            targets.add(nodeIds.get(p % nodeIds.size()));
 * {@code MPP-GENERAL-SCHEDULING-DESIGN.md}). Drives the DAG that {@link DistributionEnforcementPass}
    private static final long EXTRACT_IPC_TIMEOUT_SECONDS = 30L;
            // their payloads so its own OpenSearchBroadcastScan placeholders resolve. Both are no-ops in the
        QueryDAG dag,
                    enriched.add(sp.withInstructions(merged));
                            return;
    }
        activeRoots.set(buildRoots);
            public void onFailure(Exception e) {
            activeRoots,
    private final long sortMergeJoinMinRows;
        // mutation (not a rebuild) is required so it composes with ShuffleEnrichment.enrichLevels, which
            capturedByBuildId,
                            cancelOtherBuilds(buildRoots, buildExec, "sibling broadcast build capture failed");
            }
                    }
            capturedByBuildId.size()
 *
        if (stage.getRole() == Stage.StageRole.BROADCAST_BUILD) {
                }
            return;
    }
                                        ctx,
                    raw.onFailure(e);
    private void captureWave(
        int childDepth = depth;
    ) {
 * is resolved away into an instruction before the shuffle promotion ever runs.
            capabilityRegistry,
                            "[UnifiedDispatch] captured broadcast build wave={} build={} ipcBytes={}",
import java.util.function.Function;
     * sink, sized by {@code analytics.mpp.broadcast.max_bytes}). Exposed so {@code DefaultPlanExecutor} can
                    }
                        try {
            return stage;
        QueryDAG strippedDag = new QueryDAG(dag.queryId(), strippedRoot);
        ClusterService clusterService
        AtomicBoolean done = new AtomicBoolean(false);
        if (stage.getInstructionHandlerFactory() != null) {
        QueryContext ctx,
                (levelIndex, partitionCount) -> resolveTargetWorkerNodeIds(partitionCount)
     * after the shard scan creates the session and before the producer ships partitions). In-place so the
                    }
            // in the window between the previous wave succeeding and this wave publishing its roots, in which
 *       tiers ({@link GeneralShuffleDAGRewriter}) + enrich ({@link ShuffleEnrichment#enrichLevels}) and run;
            }
        // load-bearing: setOnCancelCallback REPLAYS synchronously when the task is already cancelled, and it
     * deferred to a {@code postRewrite} hook. ORDER MATTERS: the shuffle promotion runs
     * Appends a {@link BroadcastInjectionInstructionNode} IN PLACE to the plan alternatives of every stage
        if (GeneralShuffleDAGRewriter.hasDistributedJoin(dag)) {
        List<List<Stage>> waves = new ArrayList<>();
        List<String> reduceViable = CapabilityResolutionUtils.filterByReduceCapability(
     *
     * results, so within a wave the builds still run concurrently.
                return;
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
                other.cancel(reason);
                                new ParameterizedMessage("[UnifiedDispatch] broadcast build capture failed for build {}", buildId),
     * AFTER the shuffle promotion's {@code forkAll → convertAll} pipeline but BEFORE {@code scheduler.execute}
            }
                dispatchBroadcastFree(ctx, dag, Function.identity(), queryExecutionSink, terminal);
     * instruction must be injected AFTER that pipeline (the hook), not before — otherwise it is wiped.
            ShuffleEnrichment.enrichLevels(rewritten.levels(), ctx, clusterService, capabilityRegistry, sortMergeJoinMinRows);
        ActionListener<Iterable<VectorSchemaRoot>> rawTerminal
        AtomicReference<List<StageExecution>> activeRoots = new AtomicReference<>(List.of());
                        cancelOtherBuilds(buildRoots, buildExec, "sibling broadcast build failed");
        }
        final String captureBackendId = reduceViable.get(0);
        Map<Integer, byte[]> capturedByBuildId = new LinkedHashMap<>();
     * does. Runs BEFORE {@code ShuffleEnrichment.enrichLevels}, so the handler chain ends up as
        QueryContext ctx,
                try {
        // guards exactly that.
                                    captureWave(
 *   <li><b>Capture phase.</b> For every {@link Stage.StageRole#BROADCAST_BUILD} stage, run its subtree
     * — the broadcast path uses it to inject broadcast instructions into the (now post-fork) consumer stages
            String reason = parentTask.getReasonCancelled() != null ? parentTask.getReasonCancelled() : "unknown";
    private static final Logger LOGGER = LogManager.getLogger(UnifiedDispatch.class);
        }
            stage.getStageId(),
            byDepth.computeIfAbsent(depth, d -> new ArrayList<>()).add(stage);
import org.opensearch.analytics.planner.CapabilityResolutionUtils;
                        Exception cause = buildExec.getFailure();
     */
    }
        }
                captureSink,
                                } else {
        LOGGER.debug(
                dag,
import org.opensearch.analytics.planner.dag.Stage;
                }
        }
            if (rebuilt != child) {
                                terminal.onFailure(new TaskCancelledException("query cancelled during broadcast builds: " + reason));
                                t
import java.util.concurrent.atomic.AtomicBoolean;
                                        capturedByBuildId,
            copy.setInstructionHandlerFactory(stage.getInstructionHandlerFactory());
     * therefore failed outright on any nested-broadcast plan. Each wave depends only on shallower-depth
            .getExchangeSinkProvider()
            buildRoots.add(buildExec);
                    for (Map.Entry<Integer, byte[]> e : toInject) {
     * strippable) before it can be built. Returns an empty list when the DAG has no broadcast at all.
                                    ? ctx.parentTask().getReasonCancelled()
    public static Function<Stage, ExchangeSink> captureSinkFactory(
    /** Rebuilds the DAG dropping every {@code BROADCAST_BUILD} child whose id was captured (its output is
    public void run(
 * The OpenSearch Contributors require contributions made to
        if (dataNodes == null || dataNodes.isEmpty()) {
                            captureSink.close();
            for (OpenSearchBroadcastScan scan : scans) {
import org.opensearch.analytics.exec.stage.StageExecutionBuilder;
        }
    /**
                }
import org.apache.logging.log4j.LogManager;
     * subsequent shuffle enrichment sees the same stage objects.
                            terminal.onFailure(new RuntimeException("UnifiedDispatch: broadcast build capture failed", t));
                                    injectStripAndDispatch(ctx, dag, capturedByBuildId, queryExecutionSink, terminal);
        Consumer<QueryExecution> queryExecutionSink,
            // case the one-shot cancel callback fired against the PREVIOUS wave's roots — all terminal by then,
     * whose fragment contains an {@link OpenSearchBroadcastScan} for a captured build. The consumer may be a
        ActionListener<Iterable<VectorSchemaRoot>> terminal
    /** Tripwire for the capture-sink contract: close() must settle ipcBytesFuture synchronously. */
import org.opensearch.cluster.service.ClusterService;
     * Dispatches a DAG that has NO broadcast build (the common no-broadcast case): shuffle promotion if it
    private static void cancelOtherBuilds(List<StageExecution> buildRoots, StageExecution self, String reason) {
        Consumer<QueryExecution> queryExecutionSink,
                }
        Consumer<QueryExecution> queryExecutionSink,
                changed = true;
    ) {
        } catch (Exception e) {
    private static void injectBroadcastsInPlace(Stage stage, Map<Integer, byte[]> capturedByBuildId) {
                        terminal.onFailure(new RuntimeException("broadcast build stage " + buildId + " CANCELLED"));
            "[UnifiedDispatch] stripped {} captured build(s); dispatching broadcast-free DAG with deferred injection",
            allLeaves.addAll(buildGraph.leaves());
                        try {
    }
        };
        CompletableFuture<byte[]> fut = (CompletableFuture<byte[]>) m.invoke(captureSink);
                ctx,
                                        captureSinkFactory,
        );
import java.lang.reflect.Method;
     * advances to the next (shallower) wave or dispatches the residual.
                            captureSink.close();
                } catch (Exception e) {
import org.opensearch.analytics.planner.RelNodeUtils;
                                String reason = ctx.parentTask().getReasonCancelled() != null
            List<Stage> wave = byDepth.get(depth);
        AtomicBoolean cancelCallbackInstalled,
 *   <li><b>Inject + strip.</b> Append a {@code BroadcastInjectionInstructionNode} to the CONSUMER stage
 * broadcast memtable before running the fragment. Because instructions COMPOSE (the handler chain runs
        // Install the cancel callback ONCE, and only now that a wave has roots to cancel. Ordering is
            stage.getExchangeSinkProvider(),
        QueryDAG dag,
                if (ipc != null) {
     * customer scan that is both build-for-one-join and probe-of-another. Such a build cannot be built until
        }
                        merged.add(new BroadcastInjectionInstructionNode("broadcast-" + e.getKey(), 0, e.getValue()));
        List<Stage> rebuiltChildren = new ArrayList<>(stage.getChildStages().size());
     */
     * Strip the captured build children, then dispatch the broadcast-free DAG with broadcast injection
 *       otherwise a plain {@link QueryScheduler#execute}. The injected broadcast rides on whatever stage
            // Prepare against earlier waves: drop the build children already captured, then hand this stage
                        }
 *       may be a shard leaf, a shuffle producer, OR a worker — and drop the captured build children.</li>
        for (int depth = maxDepth; depth >= 0; depth--) {
     * {@code ShardScan → BroadcastInjection → ShuffleProducer} (BroadcastInjectionHandler requires running
        );
        return fut.get(EXTRACT_IPC_TIMEOUT_SECONDS, TimeUnit.SECONDS);
                changed = true;
        QueryContext ctx,
            List<List<Stage>> waves = collectBuildWaves(dag.rootStage());
        }
 * <ol>
        Map<Integer, List<Stage>> byDepth = new LinkedHashMap<>();
        }
    ) {
            }
            terminal
                    LOGGER.warn("[UnifiedDispatch] failed to cancel build exec", e);
            ExchangeSink captureSink = captureSinkFactory.apply(buildStage);
        List<List<Stage>> waves,
        QueryDAG dag,
            rebuiltChildren.add(rebuilt);
                        // CREATED / RUNNING — no action.
            ctx,
            injectBroadcastsInPlace(rewrittenDag.rootStage(), capturedByBuildId);
        ActionListener<Iterable<VectorSchemaRoot>> terminal
}
            List<Map.Entry<Integer, byte[]>> toInject = new ArrayList<>();
    }
            // Cancel THIS wave's roots explicitly rather than just returning. The cancellation may have landed
        for (StageExecution leaf : allLeaves) {
        this.scheduler = scheduler;
            ((OpenSearchRelNode) root.getFragment()).getViableBackends()
            buildExec.addStateListener((from, to) -> {
        } else {
        AtomicBoolean cancelCallbackInstalled = new AtomicBoolean(false);
        ActionListener<Iterable<VectorSchemaRoot>> terminal = onceOnly(done, rawTerminal);
        copy.setRole(stage.getRole());
                                return;
                                        dag,
import org.apache.arrow.vector.VectorSchemaRoot;
        }
            }
                        byte[] ipc;
 *   <li><b>Dispatch the broadcast-free DAG.</b> If it still distributes a join, promote its shuffle worker
            @Override
                continue;
            childDepth = depth + 1;
 * produced, with ONE general principle that needs no per-query-shape recognition:
            LOGGER.debug("[UnifiedDispatch] task cancelled before wave {} was scheduled; cancelling its roots", waveIndex);
 * </ol>
                LOGGER.warn("[UnifiedDispatch] failed to cancel sibling build exec", e);
