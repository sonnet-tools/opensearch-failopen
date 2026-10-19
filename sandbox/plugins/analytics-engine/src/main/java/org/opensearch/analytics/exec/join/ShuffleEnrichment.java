     * session context. The {@code WorkerFragmentStageExecutionFactory} filters this list down to the two
                    "ShuffleEnrichment: worker stage "
            // appended it to the worker's own alternatives.
            // Fail fast if the resolved target list doesn't have exactly one node per partition
        // OpenSearchStageInputScan leaves the convertor rewrites to "input-<producerStageId>" NamedScans.
        return registry.getBackend(backendId)
 * <ul>
import org.apache.logging.log4j.Logger;
                        + targets.size()
        RelNode n = RelNodeUtils.unwrapHep(node);
     * estimate {@code DistributionEnforcementPass} uses for the distribute floor.
                level.leftProducer(),
     * and the resolved target node list (one node per partition).
        }
                targets,
            );
            // Placeholder setup with partition=-1 — the per-task filter in
                "left",
     * Used to estimate a worker join's build-side size for the sort-merge-join decision — mirrors the
            // producer's own exchange info is SINGLETON (empty keys); it must partition its join OUTPUT on
            int partitionCount = level.partitionCount();
                preferHashJoin
                    + side
    private static int expectedSendersFor(Stage producer, int fallbackPartitionCount, ClusterService clusterService) {
    /**
        String side,
            if (targets.size() != partitionCount) {
            long buildRows = subtreeMaxScanRows(level.rightProducer().getFragment());
                throw new IllegalStateException(
        int partitionCount,
    /** Canonical {@code "input-<producerStageId>"} name the fragment convertor emits when it rewrites the
            merged.add(
            // (empty cluster / undersized resolution). Without this, a worker tier could be built
            // WorkerFragmentStageExecutionFactory replaces this with a partition-specific copy carrying both
 *   <li>{@link WorkerLevel} — the per-join-level descriptor (worker stage + its two shuffle producers +
     * keys — an intermediate worker producer's own exchange info is SINGLETON, so the keys it must partition
 * </ul>
    public static void enrichLevels(
 * ({@link GeneralShuffleDAGRewriter} / {@link UnifiedDispatch}) depends
 * instructions) AND a shuffle producer (to the level above — gets a producer instruction); the two
            // with zero/too-few tasks or producers could ship to a short node list — silently
 * Shared hash-shuffle worker-tier primitives used by the general MPP scheduler (Option B — see
import org.opensearch.analytics.exec.QueryContext;
                level.rightProducer().getStageId(),
        String queryId,
        // The handler must register its streaming table under that exact name.
    /**
 *       — the per-stage instruction attachment + the canonical {@code input-<producerStageId>} naming the
            List<InstructionNode> existing = sp.instructions();
            // Cost decision (Spark-style, made where the stats live — on the coordinator): if the build side
                partitionCount,
            enrichWorkerAlternatives(
                workerStageId,
            for (int p = 0; p < partitionCount; p++) {
     * on are threaded in by the caller). A scan-only alternative (no {@code DataTransferCapability(PRODUCER)})
     * One join level's worker-tier descriptor: the promoted worker stage, its two shuffle producer
        for (StagePlan sp : workerStage.getPlanAlternatives()) {
 * compatible open source license.
import org.opensearch.analytics.spi.ShuffleProducerInstructionNode;
     */
                        + partitionCount
            enrichProducerAlternatives(
     * partitions and marks isLast once per partition, so the count is the producer's task count. Falls back
    public static void enrichWorkerAlternatives(
            merged.addAll(existing);
        return "input-" + producerStageId;
    private ShuffleEnrichment() {}
                partitionCount,
                        + workerStageId
        List<StagePlan> enriched = new ArrayList<>(producerStage.getPlanAlternatives().size());
 * enrichments compose in the order {@code [setup, scan…, producer]} so the worker reads its children's
        for (RelNode input : n.getInputs()) {
                "right",
        }
    private static boolean canDriveShuffleProducer(CapabilityRegistry registry, String backendId) {
        Stage producerStage,
        int rightProducerStageId,
                new ShuffleWorkerSetupInstructionNode(queryId, workerStageId, -1, leftExpectedSenders, rightExpectedSenders, preferHashJoin)
import java.util.List;
        Stage workerStage,
            List<InstructionNode> existing = sp.instructions();
        workerStage.setPlanAlternatives(enriched);
            );
     */
/*
                "No shuffle-producer-capable plan alternative on producer stage "
            );
    public record WorkerLevel(Stage worker, Stage leftProducer, Stage rightProducer, List<Integer> leftKeys, List<Integer> rightKeys,
        return Math.max(n, 1);
     * setup+scan); the producer instruction is appended so the order stays {@code [setup, scan…, producer]}.
    }
        }
        int partitionCount, List<String> targetNodeIds) {
            enriched.add(sp.withInstructions(merged));
            // right producer's largest scan subtree (the build feeds from the right producer's shuffle).
                rightExpected,
        return max;
                "[ShuffleEnrichment] level worker={} left={} right={} partitions={} leftSenders={} rightSenders={} "
     *  consumer fragment's {@code OpenSearchStageInputScan} leaves. The handler must register streaming
import org.opensearch.analytics.planner.dag.StagePlan;
    public static String canonicalInputId(int producerStageId) {
            int leftExpected = expectedSendersFor(level.leftProducer(), partitionCount, clusterService);
                preferHashJoin,
        int n = producer.getTargetResolver().resolve(clusterService.state(), null).size();
        int workerStageId = workerStage.getStageId();
                level.leftProducer().getStageId(),
        if (node == null) {
import org.opensearch.analytics.spi.DataTransferCapability;
        CapabilityRegistry capabilityRegistry,
import org.apache.logging.log4j.LogManager;
            max = Math.max(max, subtreeMaxScanRows(input));
}
            Stage worker = level.worker();
        }
        long max = 0L;
 *   <li>{@link #enrichProducerAlternatives} / {@link #enrichWorkerAlternatives} / {@link #canonicalInputId}
            );
                leftExpected,
     * Largest {@link OpenSearchTableScan} row count in {@code node}'s subtree (0 when no scan / unknown).
            enriched.add(sp.withInstructions(merged));
                level.rightProducer().getStageId(),
     * Appends every (partition × side) {@link ShuffleScanInstructionNode} to the worker stage's plan
import org.opensearch.analytics.planner.dag.GeneralShuffleDAGRewriter;
                level.rightKeys(),
     */
        List<Integer> hashKeys,
            .stream()
import org.opensearch.cluster.service.ClusterService;
                continue;
    ) {
    }
     *  tables under this exact name so the worker plan's NamedScan binds correctly. */
     * stages, the per-side hash keys the producers must partition their output on, the partition count,
    static long subtreeMaxScanRows(RelNode node) {
 * this file be licensed under the Apache-2.0 license or a
    private static final Logger LOGGER = LogManager.getLogger(ShuffleEnrichment.class);
        int partitionCount,
                workerStageId,
                merged.add(new ShuffleScanInstructionNode(rightInputId, p, rightExpectedSenders, queryId, workerStageId, "right"));
        if (n instanceof OpenSearchTableScan scan) {
        if (producer.getTargetResolver() == null) {
            // (right input) is estimated to exceed the sort-merge-join floor, tell the worker to use a
                ctx.queryId(),
     */
 *       fragment convertor emits.</li>
    }
 * partitions, runs its join, and ships the result to its parent worker's partitions. Only the top worker
        QueryContext ctx,
    public static void enrichProducerAlternatives(
/**
import java.util.ArrayList;
    }
        long sortMergeJoinMinRows
    ) {
        }
            // the parent join's keys, not its (gathered) input's.
            merged.add(new ShuffleProducerInstructionNode(hashKeys, partitionCount, targetWorkerNodeIds, queryId, consumerStageId, side));
            List<InstructionNode> merged = new ArrayList<>(existing.size() + 1);
import org.apache.calcite.rel.RelNode;
 *
                        + " target nodes but partitionCount="
        boolean preferHashJoin
            );
                );
            throw new IllegalStateException(
                level.leftKeys(),
     * to the worker's own {@code partitionCount} when the producer has no resolver.
                ctx.queryId(),
 *       per-side hash keys + partition count + target node list);</li>
        ClusterService clusterService,
            // Producers ship to THIS worker's partitions (its node list), tagged with the side. The hash
                capabilityRegistry
            enrichProducerAlternatives(
            // placeholder and appends per-(partition,side) scans; a producer instruction (added above when
                merged.add(new ShuffleScanInstructionNode(leftInputId, p, leftExpectedSenders, queryId, workerStageId, "left"));
        for (StagePlan sp : producerStage.getPlanAlternatives()) {
 *
            }
     * Per-(partition, side) sender count the consumer worker expects. A producer task — whether a leaf
            return Math.max(fallbackPartitionCount, 1);
            // keys are THIS join level's per-side keys — passed explicitly because an intermediate-worker
     * Enriches each worker level bottom-up with its shuffle producer / scan / worker instructions. A
            return 0L;
    }
 */
            // sides' expected sender counts. We don't know the partition at this step (one alternative serves
            .anyMatch(cap -> cap.kind() == DataTransferCapability.Kind.PRODUCER);
     */
 */
        for (WorkerLevel level : levels) {
 * <p>Holds three things, all formerly living in the deleted cascade/hash-shuffle dispatchers:
                level.rightProducer(),
 *
     * alternatives, prefixed by a {@link ShuffleWorkerSetupInstructionNode} that bootstraps a worker-mode
 *
                    + "buildRows={} preferHashJoin={} targets={}",
        String rightInputId = canonicalInputId(rightProducerStageId);
            );
                level.leftProducer().getStageId(),
            }
                ctx.queryId(),
                    + producerStage.getStageId()
                        + " resolved "
import org.opensearch.analytics.planner.RelNodeUtils;
        int rightExpectedSenders,
            }
            .getCapabilityProvider()
     * shard scan (one task per shard) or an intermediate worker (one task per partition) — ships to ALL
        int leftExpectedSenders,
                rightExpected,
import org.opensearch.analytics.spi.ShuffleScanInstructionNode;
                    + "); none of its backends declare DataTransferCapability(PRODUCER)."
            LOGGER.debug(
                leftExpected,
    ) {
     * instruction passes through unfiltered.
            // The worker consumes its two producers' partitions. enrichWorkerAlternatives prepends a setup
import org.opensearch.analytics.spi.InstructionNode;
                capabilityRegistry
        int leftProducerStageId,
 * @opensearch.internal
import org.opensearch.analytics.spi.ShuffleWorkerSetupInstructionNode;
            int rightExpected = expectedSendersFor(level.rightProducer(), partitionCount, clusterService);
            int workerStageId = worker.getStageId();
     * Appends a {@link ShuffleProducerInstructionNode} to every shuffle-producer-capable plan alternative
        int consumerStageId,
        producerStage.setPlanAlternatives(enriched);
    /**
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
        if (enriched.isEmpty()) {
                buildRows,
    }
     * is dropped so {@code PlanAlternativeSelector} can't pick a driver that throws at execution.
        String queryId,
public final class ShuffleEnrichment {
 * SPDX-License-Identifier: Apache-2.0
            merged.addAll(existing);
        List<String> targetWorkerNodeIds,
    /**
 *   <li>{@link #enrichLevels} — attaches each level's producer/scan/worker shuffle instructions bottom-up;</li>
     * ShuffleScan instructions for each task's partition before sending the per-task request — the setup
            // spillable sort-merge join instead of the non-spillable hash-join build. Estimated from the
    /**
            .dataTransferCapabilities()
import org.opensearch.analytics.planner.CapabilityRegistry;
import org.opensearch.analytics.planner.dag.Stage;
            if (canDriveShuffleProducer(registry, sp.backendId()) == false) {
            List<InstructionNode> merged = new ArrayList<>(1 + existing.size() + 2 * partitionCount);
                partitionCount,
            List<String> targets = level.targetNodeIds();
                partitionCount,
 * {@code MPP-GENERAL-SCHEDULING-DESIGN.md}). Extracted into a neutral home so the general scheduler
        CapabilityRegistry registry
        String leftInputId = canonicalInputId(leftProducerStageId);
     * producer feeding an intermediate worker may itself be a worker (its instructions already carry
                worker,
package org.opensearch.analytics.exec.join;
        }
 * gathers (SINGLETON) to the coordinator's reduce.
            // wrong results or an IndexOutOfBounds deep in dispatch.
                targets
            // all partitions; per-task filtering picks the right one).
        List<StagePlan> enriched = new ArrayList<>(workerStage.getPlanAlternatives().size());
        // The fragment convertor strips OpenSearchShuffleExchange, so the worker fragment ends up with two
        }
 * on these primitives directly rather than on the now-removed enumerated shape dispatchers.
    }
                    + " (side="
    /**
            return Math.max(0L, (long) scan.getTable().getRowCount());
 * <p>An INTERMEDIATE worker is BOTH a shuffle consumer (of the level below — gets setup + scan
    }
     */
                workerStageId,
 * The OpenSearch Contributors require contributions made to
            // this worker also feeds a higher level) stays AFTER the scans because enrichProducerAlternatives
                targets,
        }
            boolean preferHashJoin = buildRows < sortMergeJoinMinRows;
        List<WorkerLevel> levels,
     * on the producer stage, partitioning its output on {@code hashKeys} (the consumer join level's per-side
