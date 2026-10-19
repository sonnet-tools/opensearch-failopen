                (levelIndex, partitionCount) -> resolveTargetWorkerNodeIds(partitionCount)  
        QueryDAG dag,
     * broadcast-free residual.
    private final long sortMergeJoinMinRows;  
        long sortMergeJoinMinRows
            }
     * results, so within a wave the builds still run concurrently.  
        // is that replay — cancelling each root, whose CANCELLED listener fails the terminal — that reports
                                        waves,
                        try {  
            if (other == self) {
     * strippable) before it can be built. Returns an empty list when the DAG has no broadcast at all.
                            captureSink.close();
    /** Rebuilds the DAG dropping every {@code BROADCAST_BUILD} child whose id was captured (its output is  
        QueryDAG dag,
     * Drives the enforced DAG. When it contains any broadcast build, runs the capture phase first, then
                        terminal.onFailure(new RuntimeException("broadcast build stage " + buildId + " CANCELLED"));
    public static Function<Stage, ExchangeSink> captureSinkFactory(  
        ClusterService clusterService,
                changed = true;
    private void captureWave(  
            // their payloads so its own OpenSearchBroadcastScan placeholders resolve. Both are no-ops in the
            "[UnifiedDispatch] stripped {} captured build(s); dispatching broadcast-free DAG with deferred injection",
    private void captureThenDispatch(
            .getExchangeSinkProvider()
        );
            }
            if (child.getRole() == Stage.StageRole.BROADCAST_BUILD && capturedByBuildId.containsKey(child.getStageId())) {  
        List<String> targets = new ArrayList<>(partitionCount);  
        Map<Integer, List<Stage>> byDepth = new LinkedHashMap<>();
            return;
    private static void injectBroadcastsInPlace(Stage stage, Map<Integer, byte[]> capturedByBuildId) {
        AtomicBoolean cancelCallbackInstalled,
import org.opensearch.analytics.planner.dag.QueryDAG;
    private static final long EXTRACT_IPC_TIMEOUT_SECONDS = 30L;  
        for (Stage rawBuildStage : builds) {  
     * already-captured build.
            installCaptureCancelCallback(ctx, activeRoots);  
        }
        dispatchBroadcastFree(ctx, strippedDag, rewrittenDag -> {  
        AtomicBoolean done = new AtomicBoolean(false);  
     * shard leaf, a shuffle producer, or a worker — the instruction composes with whatever else the stage
                }
                        byte[] ipc;
     * deferred to a {@code postRewrite} hook. ORDER MATTERS: the shuffle promotion runs
     */  
        ActionListener<Iterable<VectorSchemaRoot>> terminal
    }
            buildRoots.add(buildExec);  
    /** Tripwire for the capture-sink contract: close() must settle ipcBytesFuture synchronously. */
    /** Copies a stage with new children, preserving role / exchange / resolver / factory / plan alternatives. */
     *  already injected). Other stages are copied with children rebuilt so siblings are preserved. */
                } catch (Exception e) {
import java.util.function.Function;  
            return stage;
                        } catch (Throwable ignore) {  
            targets.add(nodeIds.get(p % nodeIds.size()));
            QueryDAG finalDag = postRewrite.apply(rewritten.dag());
        Stage strippedRoot = stripBuildChildren(dag.rootStage(), capturedByBuildId);
            }
     * Groups every {@link Stage.StageRole#BROADCAST_BUILD} stage in the DAG into capture waves, ordered
                        cancelOtherBuilds(buildRoots, buildExec, "sibling broadcast build failed");
 * {@link BroadcastInjectionInstructionNode} on its plan; the data-node handler chain registers the
     * Capture phase, run as WAVES ordered innermost-first, then inject + strip + dispatch the  
        // postRewrite: inject the captured broadcasts into the (post-fork) consumer stages IN PLACE. In-place
                        }
                buildStage,  
        return targets;
            }
            StageExecution buildExec = buildGraph.root();
     * @param captureSinkFactory creates the backend IPC capture sink for a build stage's output rowType
     * <p>The residual dispatch happens once, after the LAST (shallowest) wave.
        QueryContext ctx,
        ActionListener<Iterable<VectorSchemaRoot>> terminal = onceOnly(done, rawTerminal);
            ((OpenSearchRelNode) root.getFragment()).getViableBackends()  
 * <p><b>Broadcast is an INSTRUCTION, not a stage type.</b> A stage that consumes a broadcast carries a
package org.opensearch.analytics.exec.join;
    }  
            .createBroadcastCaptureSink(ctx.bufferAllocator(), stage.getFragment().getRowType(), broadcastMaxBytes);  
                            captureSink.close();
     * therefore failed outright on any nested-broadcast plan. Each wave depends only on shallower-depth
     */
            final int buildId = buildStage.getStageId();  
            for (StageExecution buildExec : buildRoots) {  
 * @opensearch.internal
import java.util.concurrent.atomic.AtomicInteger;  
        }
        }  
import org.opensearch.analytics.planner.RelNodeUtils;
        return fut.get(EXTRACT_IPC_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        }
    ) {
        AtomicReference<List<StageExecution>> activeRoots = new AtomicReference<>(List.of());
            queryExecutionSink,  
     * Builds and schedules every build in wave {@code waveIndex} concurrently. On wave completion, either  
            capturedByBuildId.size()  
            public void onFailure(Exception e) {  
            List<Map.Entry<Integer, byte[]>> toInject = new ArrayList<>();
        if (!changed) {
                queryExecutionSink.accept(exec);  
        List<String> reduceViable = CapabilityResolutionUtils.filterByReduceCapability(
     * Installs the capture-phase cancel callback ONCE, from the FIRST wave and only after that wave has
            // Prepare against earlier waves: drop the build children already captured, then hand this stage
        }
                                        waveIndex + 1,
        this.capabilityRegistry = capabilityRegistry;
            terminal.onFailure(e);
            LOGGER.debug("[UnifiedDispatch] capture phase cancel requested, reason={}", reason);  
        captureWave(  
     */  
    }  
    private static Stage copyStage(Stage stage, List<Stage> children, List<StagePlan> planAlternatives) {  
    /**  
            stage.getTargetResolver()
     */
        return waves;  
        if (reduceViable.isEmpty()) {
     * after the shard scan creates the session and before the producer ships partitions). In-place so the
        copy.setPlanAlternatives(planAlternatives);
            Stage rebuilt = stripBuildChildren(child, capturedByBuildId);
                stage.setPlanAlternatives(enriched);  
 * </ol>
                try {
        Map<Integer, byte[]> capturedByBuildId,
            // in the window between the previous wave succeeding and this wave publishing its roots, in which  
        if (GeneralShuffleDAGRewriter.hasDistributedJoin(dag)) {
        activeRoots.set(buildRoots);
                            } catch (Exception e) {
                                        dag,  
    ) {
import org.apache.logging.log4j.Logger;  
        };
    /**
        });
            List<List<Stage>> waves = collectBuildWaves(dag.rootStage());  
        // fires, and the query hangs. UnifiedDispatchTests#testRunFailsTerminalWhenTaskCancelledBeforeRun  
            injectBroadcastsInPlace(rewrittenDag.rootStage(), capturedByBuildId);
    /**
                queryExecutionSink.accept(exec);  
}
        );
     */  
                                return;  
        if (byDepth.isEmpty()) {
import org.opensearch.analytics.planner.rel.OpenSearchBroadcastScan;
        QueryDAG dag,
        // load-bearing: setOnCancelCallback REPLAYS synchronously when the task is already cancelled, and it  
import java.util.concurrent.TimeUnit;
            // is once-only, so the query is failed exactly once.
        int maxDepth = byDepth.keySet().stream().max(Integer::compare).orElse(0);
                        synchronized (capturedByBuildId) {  
                        Exception cause = buildExec.getFailure();  
                                } else {
     * so they survive the alternative re-expansion. Without a broadcast it is identity.
                capabilityRegistry,
        CompletableFuture<byte[]> fut = (CompletableFuture<byte[]>) m.invoke(captureSink);  
        AnalyticsQueryTask parentTask = ctx.parentTask();
        }  
        );
import java.util.concurrent.atomic.AtomicBoolean;
 * is resolved away into an instruction before the shuffle promotion ever runs.  
     * {@code ShardScan → BroadcastInjection → ShuffleProducer} (BroadcastInjectionHandler requires running  
        if (stage.getInstructionHandlerFactory() != null) {
            capabilityRegistry,
        for (Stage child : stage.getChildStages()) {  
 *       may be a shard leaf, a shuffle producer, OR a worker — and drop the captured build children.</li>  
 * Single dispatch entry point for the GENERAL post-CBO scheduler (Option B — see  
import org.opensearch.analytics.planner.dag.StagePlan;  
        ActionListener<Iterable<VectorSchemaRoot>> terminal  
            rebuiltChildren.add(rebuilt);
            injectBroadcastsInPlace(child, capturedByBuildId);
        this.clusterService = clusterService;
     */
 *   <li><b>Inject + strip.</b> Append a {@code BroadcastInjectionInstructionNode} to the CONSUMER stage
            captureSinkFactory,
                continue;
 *       consumes it.</li>
                changed = true;
                        } catch (Throwable ignore) {
        if (stage.getFragment() != null) {
                    case FAILED -> {  
     * Resolves the IPC capture-sink factory for this query (the reduce-capable backend's broadcast capture
                            buildId,  
                                t  
        List<List<Stage>> waves,
        } catch (Exception e) {  
                ctx,
import java.util.Map;
     * its own walker-level cancel.  
        ClusterService clusterService
 * SPDX-License-Identifier: Apache-2.0
            buildExec.addStateListener((from, to) -> {
import org.opensearch.analytics.exec.QueryExecution;
            ShuffleEnrichment.enrichLevels(rewritten.levels(), ctx, clusterService, capabilityRegistry, sortMergeJoinMinRows);  
            childDepth = depth + 1;
                LOGGER.warn("[UnifiedDispatch] failed to cancel sibling build exec", e);
                return;  
        Stage copy = new Stage(
            List<OpenSearchBroadcastScan> scans = RelNodeUtils.findNodes(stage.getFragment(), OpenSearchBroadcastScan.class);  
        List<List<Stage>> waves = new ArrayList<>();
        QueryDAG dag,  
        boolean preferMetadataDriver,  
                }  
            stage.getStageId(),
                }
                    }  
        }  
                scheduler::scheduleStage  
                                }  
import org.opensearch.analytics.AnalyticsSettings;
    public UnifiedDispatch(
     */  
        } else {
import org.opensearch.cluster.service.ClusterService;  
    private static Stage stripBuildChildren(Stage stage, Map<Integer, byte[]> capturedByBuildId) {
     *
        return new ActionListener<>() {  
            injectBroadcastsInPlace(buildStage, capturedByBuildId);
        // mutation (not a rebuild) is required so it composes with ShuffleEnrichment.enrichLevels, which  
 * q3/q8/q9; a shuffle join above a broadcast — q17; a standalone broadcast — q12) because the broadcast
    }  
     * its OWN build has been captured and stripped out of its subtree, because otherwise
                    }  
                byte[] ipc = capturedByBuildId.get(scan.getBuildStageId());  
            copy.setInstructionHandlerFactory(stage.getInstructionHandlerFactory());  
            try {
 *       of each build — located by the {@link OpenSearchBroadcastScan} that references the build id, which
/**
                            captureSink.close();  
            GeneralShuffleDAGRewriter.Rewritten rewritten = GeneralShuffleDAGRewriter.rewrite(
                    LOGGER.warn("[UnifiedDispatch] failed to cancel build exec", e);
            collectBuildsByDepth(child, childDepth, byDepth);
        }  
                            "[UnifiedDispatch] captured broadcast build wave={} build={} ipcBytes={}",
import java.util.List;
            QueryExecution exec = scheduler.execute(ctx.withDag(finalDag), terminal);
            }
import org.opensearch.analytics.planner.dag.Stage;
        QueryContext ctx,
                            return;
            // cancelled — a later listener would miss the CANCELLED transition; the BroadcastDispatch /  
            capturedByBuildId,
            }  
            }
        if (parentTask == null) {
        }
     * published its roots to {@code activeRoots} (see the caller — the replay ordering is load-bearing). It
            Stage buildStage = stripBuildChildren(rawBuildStage, capturedByBuildId);
import java.util.concurrent.atomic.AtomicReference;
        StageExecutionBuilder builder = scheduler.getStageExecutionBuilder();  
import java.util.concurrent.CompletableFuture;  
        // wave that is actually in flight.  
import java.lang.reflect.Method;
                                terminal.onFailure(new TaskCancelledException("query cancelled during broadcast builds: " + reason));
        // the enrich or be discarded by it. Returns the same DAG.
            if (waves.isEmpty()) {
            }  
            waves,  
    }
            );
        // guards exactly that.
        Map<Integer, byte[]> capturedByBuildId = new LinkedHashMap<>();
                    }
        return copyStage(stage, rebuiltChildren, stage.getPlanAlternatives());
    private static List<List<Stage>> collectBuildWaves(Stage root) {
        QueryContext ctx,
        try {
        Function<Stage, ExchangeSink> captureSinkFactory,
        Function<QueryDAG, QueryDAG> postRewrite,  
            scheduler.scheduleStage(leaf);
                                if (waveIndex + 1 < waves.size()) {  
 *   <li><b>Dispatch the broadcast-free DAG.</b> If it still distributes a join, promote its shuffle worker
 *
public final class UnifiedDispatch {
    private static final Logger LOGGER = LogManager.getLogger(UnifiedDispatch.class);  
        CapabilityRegistry capabilityRegistry,  
 * this file be licensed under the Apache-2.0 license or a
        this.preferMetadataDriver = preferMetadataDriver;  
     * — the broadcast path uses it to inject broadcast instructions into the (now post-fork) consumer stages  
    /**
 * we never need a stage to hold two {@code StageRole}s. This dispatcher therefore:
        List<Stage> rebuiltChildren = new ArrayList<>(stage.getChildStages().size());  
                            waveIndex,
            0,
import java.util.function.Consumer;
     * build it once and hand it in — identical to the legacy broadcast path's factory.
            byDepth.computeIfAbsent(depth, d -> new ArrayList<>()).add(stage);  
        Function<Stage, ExchangeSink> captureSinkFactory,
                                new ParameterizedMessage("[UnifiedDispatch] broadcast build capture failed for build {}", buildId),
     *
            if (queryExecutionSink != null) {
    private final CapabilityRegistry capabilityRegistry;
     * {@code DataConsumer}, which it is not. Capturing every build in one flat pass (the previous shape)
        }, queryExecutionSink, terminal);  
     * <p>A build's depth is the number of BROADCAST_BUILD stages strictly between it and the root, so a build
        Consumer<QueryExecution> queryExecutionSink,  
            @Override
    }
                        }  
import org.opensearch.analytics.exec.QueryScheduler;
        Map<Integer, byte[]> capturedByBuildId,
                    for (Map.Entry<Integer, byte[]> e : toInject) {  
import org.apache.logging.log4j.LogManager;
    /**
                if (done.compareAndSet(false, true)) {
 *  
                            }  
                                    : "unknown";
     * Dispatches a DAG that has NO broadcast build (the common no-broadcast case): shuffle promotion if it  
        for (Stage child : stage.getChildStages()) {
    }  
            }
            if (queryExecutionSink != null) {
            }
                }
import org.opensearch.analytics.spi.InstructionNode;
     * {@code buildSubGraphWithSink} walks into that un-stripped child and asks a shard fragment to be its  
                    buildExec.cancel("task cancelled: " + reason);  
     * Strip the captured build children, then dispatch the broadcast-free DAG with broadcast injection  
        return copy;
        for (int depth = maxDepth; depth >= 0; depth--) {  
            for (StageExecution buildExec : activeRoots.get()) {
        }
 *
                        try {
        CapabilityRegistry capabilityRegistry,
                            capturedByBuildId.put(buildId, ipc);
                }  
        int childDepth = depth;
                if (ipc != null) {
        AtomicReference<List<StageExecution>> activeRoots,  
    }
        }
import org.opensearch.analytics.exec.stage.StageExecution;  
                    }  
            if (rebuilt != child) {  
 * The OpenSearch Contributors require contributions made to  
            }
                        try {
        QueryContext ctx,  
        QueryScheduler scheduler,  
            return List.of();  
                    }  
     *
        List<StageExecution> allLeaves = new ArrayList<>();
                                    ? ctx.parentTask().getReasonCancelled()  
 * {@code AnalyticsSearchService.applyInstructionHandlers}), the SAME stage can be both a broadcast
     * advances to the next (shallower) wave or dispatches the residual.
        Consumer<QueryExecution> queryExecutionSink,  
 * produced, with ONE general principle that needs no per-query-shape recognition:
            // would leave nothing to complete the terminal and the query would hang. Driving our own roots to  
    /**
        // the cancellation. Installing it before any roots exist makes the replay cancel nothing, no listener
                                        terminal
    ) {
    }  
                    raw.onFailure(e);
                    buildExec.cancel("task cancelled before wave " + waveIndex + " was scheduled");
            });
                    enriched.add(sp.withInstructions(merged));
    private void injectStripAndDispatch(
            // CANCELLED routes through the same CANCELLED listener every other cancel path uses, and `terminal`
                other.cancel(reason);
     * AFTER the shuffle promotion's {@code forkAll → convertAll} pipeline but BEFORE {@code scheduler.execute}
            if (!toInject.isEmpty()) {
    private final boolean preferMetadataDriver;
            QueryDAG finalDag = postRewrite.apply(dag);  
import org.opensearch.analytics.exec.QueryContext;  
     */
        }
        final long broadcastMaxBytes = clusterService.getClusterSettings().get(AnalyticsSettings.BROADCAST_MAX_BYTES).getBytes();  
                dispatchBroadcastFree(ctx, dag, Function.identity(), queryExecutionSink, terminal);
            );
    @SuppressWarnings("unchecked")  
                List<StagePlan> enriched = new ArrayList<>(stage.getPlanAlternatives().size());  
                                    captureWave(
        Function<Stage, ExchangeSink> captureSinkFactory,
            // THEN enrich the per-level shuffle instructions and dispatch.
                    case CANCELLED -> {
            StageExecutionBuilder.SubGraph buildGraph = builder.buildSubGraphWithSink(
     * bypasses the normal {@code QueryScheduler.execute} cancel path (the capture schedules build leaves  
            QueryExecution exec = scheduler.execute(ctx.withDag(finalDag), terminal);
            cancelCallbackInstalled,
 * <ol>  
                            // primary failure surfaced below
        final String captureBackendId = reduceViable.get(0);
     *
import org.opensearch.analytics.planner.CapabilityResolutionUtils;
        ActionListener<Iterable<VectorSchemaRoot>> terminal
                                        queryExecutionSink,
                                    );  
import org.apache.arrow.vector.VectorSchemaRoot;
 *   <li><b>Capture phase.</b> For every {@link Stage.StageRole#BROADCAST_BUILD} stage, run its subtree
import org.opensearch.analytics.planner.dag.GeneralShuffleDAGRewriter;  
    }  
        boolean changed = false;
        AtomicInteger remaining = new AtomicInteger(builds.size());
     * distributes a join, else plain. {@code postRewrite} is an optional hook applied to the rewritten DAG
            children,
        List<String> nodeIds = new ArrayList<>(dataNodes.keySet());
                    raw.onResponse(result);
        QueryDAG dag,
import org.opensearch.analytics.planner.CapabilityRegistry;  
            return rewrittenDag;
        for (StageExecution other : buildRoots) {  
    ) {  
                        // CREATED / RUNNING — no action.
            }
            // Cancel THIS wave's roots explicitly rather than just returning. The cancellation may have landed
    }
                if (done.compareAndSet(false, true)) {  
            // Promote shuffle joins to worker tiers (forkAll → adaptAll → selectAll → convertAll), THEN apply
     * subsequent shuffle enrichment sees the same stage objects.
        );
     * whose fragment contains an {@link OpenSearchBroadcastScan} for a captured build. The consumer may be a  
        }  
        int waveIndex,
            }  
import org.opensearch.analytics.spi.ExchangeSink;
    private final QueryScheduler scheduler;
     * The build children are stripped BEFORE the rewrite so the rewriter never tries to promote/wire an
            if (wave != null && !wave.isEmpty()) {
        copy.setRole(stage.getRole());  
                            cancelOtherBuilds(buildRoots, buildExec, "sibling broadcast build capture failed");
            ctx,
                } catch (Exception e) {  
    }
        AnalyticsQueryTask parentTask = ctx.parentTask();  
        return stage -> capabilityRegistry.getBackend(captureBackendId)
    ) {
                    List<InstructionNode> merged = new ArrayList<>(sp.instructions());
            dag,
import org.opensearch.analytics.spi.BroadcastInjectionInstructionNode;  
    }
                        terminal.onFailure(cause != null ? cause : new RuntimeException("broadcast build stage " + buildId + " FAILED"));
        for (Stage child : stage.getChildStages()) {  
                        } catch (Throwable t) {  
                captureSink,
        if (parentTask != null && parentTask.isCancelled()) {  
        QueryContext ctx,
     * during a later wave still cancels live executions. Phase-2's {@code execute} replaces this callback with
            // and cancel() no-ops on a terminal state, so no listener ran. Returning here without cancelling
                            );
     * INNERMOST-FIRST: wave 0 holds the most deeply nested builds, the last wave the shallowest.  
        Consumer<QueryExecution> queryExecutionSink,  
                            }
import org.opensearch.core.tasks.TaskCancelledException;
        }
        ActionListener<Iterable<VectorSchemaRoot>> rawTerminal
        Consumer<QueryExecution> queryExecutionSink,
                                        capturedByBuildId,  
     * customer scan that is both build-for-one-join and probe-of-another. Such a build cannot be built until
                                        cancelCallbackInstalled,
                }  
    ) {
                        }
    private static void installCaptureCancelCallback(QueryContext ctx, AtomicReference<List<StageExecution>> activeRoots) {
            activeRoots,  
                preferMetadataDriver,
    /**
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
        // flight — hence the shared reference rather than a capture of one wave's list.  
        }  
    /** Round-robins one target worker node per partition across the cluster's data nodes (shuffle promotion). */
        Stage root = dag.rootStage();  
                            try {
    private static void cancelOtherBuilds(List<StageExecution> buildRoots, StageExecution self, String reason) {
        }
     * ordering {@link #captureWave} needs: a build's own builds must already be captured (and therefore
 * {@code MPP-GENERAL-SCHEDULING-DESIGN.md}). Drives the DAG that {@link DistributionEnforcementPass}
        // Publish this wave's roots AFTER every listener is installed, so the cancel callback cancels the
        ActionListener<Iterable<VectorSchemaRoot>> terminal
                for (StagePlan sp : stage.getPlanAlternatives()) {
                        cancelOtherBuilds(buildRoots, buildExec, "sibling broadcast build cancelled");
        // Accumulates across waves: a wave's builds are prepared against everything captured before it.  
 *  
     * Appends a {@link BroadcastInjectionInstructionNode} IN PLACE to the plan alternatives of every stage
    public void run(
     */
import java.util.ArrayList;
                                    injectStripAndDispatch(ctx, dag, capturedByBuildId, queryExecutionSink, terminal);
    /**
     * <p><b>Why waves.</b> A broadcast build can itself be a broadcast probe — nested broadcast, e.g. a  
            }  
    private void dispatchBroadcastFree(  
        QueryContext ctx,
                        }
        this.sortMergeJoinMinRows = sortMergeJoinMinRows;
 *       otherwise a plain {@link QueryScheduler#execute}. The injected broadcast rides on whatever stage  
    private static ActionListener<Iterable<VectorSchemaRoot>> onceOnly(AtomicBoolean done, ActionListener<Iterable<VectorSchemaRoot>> raw) {
    private final ClusterService clusterService;  
import java.util.LinkedHashMap;  
    }
            // case the one-shot cancel callback fired against the PREVIOUS wave's roots — all terminal by then,
     * does. Runs BEFORE {@code ShuffleEnrichment.enrichLevels}, so the handler chain ends up as
            } catch (Exception e) {  
     * {@code forkAll → convertAll} which REPLACES every stage's plan alternatives, so the broadcast
            for (OpenSearchBroadcastScan scan : scans) {
                                terminal.onFailure(e);
 * compatible open source license.
 * consumer AND a shuffle producer / worker: broadcast-inject, then join, then hash-partition + ship. So  
            return List.of();
                            // primary cancel surfaced below
        // Install the cancel callback ONCE, and only now that a wave has roots to cancel. Ordering is
        // The cancel callback is installed once, by the first wave, but must cancel whichever wave is in
                        if (remaining.decrementAndGet() == 0) {  
            LOGGER.debug("[UnifiedDispatch] task cancelled before wave {} was scheduled; cancelling its roots", waveIndex);
    }  
        }
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
    private byte[] extractIpcBytes(ExchangeSink captureSink) throws Exception {
import org.opensearch.analytics.exec.stage.StageExecutionBuilder;
                            LOGGER.warn(
import org.opensearch.core.action.ActionListener;
                        LOGGER.debug(  
                            ipc == null ? -1 : ipc.length
    /**
                        // buildSideIndex 0: informational only — the NamedScan resolves by name on the data node.
            stage.getFragment(),  
                        merged.add(new BroadcastInjectionInstructionNode("broadcast-" + e.getKey(), 0, e.getValue()));
        collectBuildsByDepth(root, 0, byDepth);  
    private List<String> resolveTargetWorkerNodeIds(int partitionCount) {  
                }
                    LOGGER.debug(new ParameterizedMessage("[UnifiedDispatch] cancel failed for build {}", buildExec.getStageId()), e);
                            terminal.onFailure(new RuntimeException("UnifiedDispatch: broadcast build capture failed", t));  
    }
        Method m = captureSink.getClass().getMethod("ipcBytesFuture");
        Map<String, org.opensearch.cluster.node.DiscoveryNode> dataNodes = clusterService.state().nodes().getDataNodes();
        if (stage.getRole() == Stage.StageRole.BROADCAST_BUILD) {
     * sink, sized by {@code analytics.mpp.broadcast.max_bytes}). Exposed so {@code DefaultPlanExecutor} can  
        if (cancelCallbackInstalled.compareAndSet(false, true)) {
                            ipc = extractIpcBytes(captureSink);
        for (int p = 0; p < partitionCount; p++) {
                        }
 *
        this.scheduler = scheduler;  
 * them in order, each adding to the same native session — see
            allLeaves.addAll(buildGraph.leaves());
        AtomicBoolean cancelCallbackInstalled = new AtomicBoolean(false);
        List<Stage> builds = waves.get(waveIndex);
            // Listener BEFORE the cancel callback (setOnCancelCallback replays synchronously when already
     * dispatches the broadcast-free residual; otherwise dispatches directly.  
            captureThenDispatch(ctx, dag, waves, captureSinkFactory, queryExecutionSink, terminal);
            // postRewrite (broadcast injection survives because it runs after the alternative re-expansion),  
            @Override
/*  
 *       tiers ({@link GeneralShuffleDAGRewriter}) + enrich ({@link ShuffleEnrichment#enrichLevels}) and run;
        for (StageExecution leaf : allLeaves) {
 *       in isolation into an Arrow-IPC capture sink and collect the bytes keyed by
                                        activeRoots,
        }  
            stage.getExchangeSinkProvider(),  
            String reason = parentTask.getReasonCancelled() != null ? parentTask.getReasonCancelled() : "unknown";
        List<StageExecution> buildRoots = new ArrayList<>(builds.size());  
                                        ctx,
        parentTask.setOnCancelCallback(() -> {
                                String reason = ctx.parentTask().getReasonCancelled() != null
                    case SUCCEEDED -> {
        }
 */  
            return;
            // common single-level case, where capturedByBuildId is still empty.  
                                        captureSinkFactory,  
                waves.add(wave);  
     * instruction must be injected AFTER that pipeline (the hook), not before — otherwise it is wiped.  
                continue;
        // also appends instructions in place to the same worker stages — a rebuild here would either discard
        QueryDAG dag,  
            throw new IllegalStateException("No reduce-capable backend for broadcast capture sink (general scheduler)");  
                    toInject.add(Map.entry(scan.getBuildStageId(), ipc));
            // DistributedAggOverJoinDispatch ordering contract).
                dag,  
     *     (the sink exposes {@code CompletableFuture<byte[]> ipcBytesFuture()} completed by {@code close()}).  
            stage.getExchangeInfo(),
        }  
        QueryDAG strippedDag = new QueryDAG(dag.queryId(), strippedRoot);  
                        );
            ExchangeSink captureSink = captureSinkFactory.apply(buildStage);
 * <p>This composes broadcast with shuffle at ANY nesting (a small build under a shuffle cascade — TPC-H
        LOGGER.debug(
                try {
    private static void collectBuildsByDepth(Stage stage, int depth, Map<Integer, List<Stage>> byDepth) {  
import org.apache.logging.log4j.message.ParameterizedMessage;
        List<List<Stage>> waves,  
 *       {@code broadcast-<buildStageId>}.</li>  
                    default -> {
 * broadcast memtable before running the fragment. Because instructions COMPOSE (the handler chain runs  
                            if (ctx.parentTask() != null && ctx.parentTask().isCancelled()) {
    ) {
            List<Stage> wave = byDepth.get(depth);
 */  
        Consumer<QueryExecution> queryExecutionSink,
        if (dataNodes == null || dataNodes.isEmpty()) {
    }  
            terminal
                switch (to) {  
            public void onResponse(Iterable<VectorSchemaRoot> result) {
     * directly), and reads {@code activeRoots} rather than closing over one wave's list so a cancel arriving
     * that is itself a broadcast probe lands in a strictly earlier wave than the build it feeds. That is the  
