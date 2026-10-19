                targets,
            // Cost decision (Spark-style, made where the stats live — on the coordinator): if the build side  
            // all partitions; per-task filtering picks the right one).
            max = Math.max(max, subtreeMaxScanRows(input));
import org.opensearch.analytics.planner.dag.Stage;
        int partitionCount,
import org.opensearch.analytics.planner.dag.StagePlan;  
                rightExpected,  
                continue;  
        // The handler must register its streaming table under that exact name.  
                "left",
            return Math.max(0L, (long) scan.getTable().getRowCount());  
 * instructions) AND a shuffle producer (to the level above — gets a producer instruction); the two
        int partitionCount, List<String> targetNodeIds) {  
            if (targets.size() != partitionCount) {
     */
import org.opensearch.analytics.planner.CapabilityRegistry;
 * @opensearch.internal
     */
                rightExpected,  
            // keys are THIS join level's per-side keys — passed explicitly because an intermediate-worker
            merged.add(new ShuffleProducerInstructionNode(hashKeys, partitionCount, targetWorkerNodeIds, queryId, consumerStageId, side));
            LOGGER.debug(
                        + partitionCount
import org.opensearch.analytics.planner.RelNodeUtils;  
 *       fragment convertor emits.</li>
                partitionCount,
     */
            // (empty cluster / undersized resolution). Without this, a worker tier could be built
     * Used to estimate a worker join's build-side size for the sort-merge-join decision — mirrors the  
            // with zero/too-few tasks or producers could ship to a short node list — silently
                    + "); none of its backends declare DataTransferCapability(PRODUCER)."
                    "ShuffleEnrichment: worker stage "  
     * One join level's worker-tier descriptor: the promoted worker stage, its two shuffle producer
        Stage producerStage,  
                partitionCount,
            .anyMatch(cap -> cap.kind() == DataTransferCapability.Kind.PRODUCER);
        // The fragment convertor strips OpenSearchShuffleExchange, so the worker fragment ends up with two
     * shard scan (one task per shard) or an intermediate worker (one task per partition) — ships to ALL
 * <ul>
                buildRows,
 * </ul>
     * ShuffleScan instructions for each task's partition before sending the per-task request — the setup
        CapabilityRegistry registry
     * on the producer stage, partitioning its output on {@code hashKeys} (the consumer join level's per-side  
        RelNode n = RelNodeUtils.unwrapHep(node);
import org.opensearch.analytics.spi.ShuffleProducerInstructionNode;
                level.rightProducer(),  
    }  
 *
     * on are threaded in by the caller). A scan-only alternative (no {@code DataTransferCapability(PRODUCER)})
    private static final Logger LOGGER = LogManager.getLogger(ShuffleEnrichment.class);
        }
     */
 *  
        boolean preferHashJoin
    /**
                workerStageId,
            int leftExpected = expectedSendersFor(level.leftProducer(), partitionCount, clusterService);  
        Stage workerStage,  
                    + producerStage.getStageId()
        workerStage.setPlanAlternatives(enriched);  
        QueryContext ctx,
                "[ShuffleEnrichment] level worker={} left={} right={} partitions={} leftSenders={} rightSenders={} "
                partitionCount,
            List<InstructionNode> existing = sp.instructions();
 * partitions, runs its join, and ships the result to its parent worker's partitions. Only the top worker
 */  
     * Largest {@link OpenSearchTableScan} row count in {@code node}'s subtree (0 when no scan / unknown).
        producerStage.setPlanAlternatives(enriched);
        return Math.max(n, 1);
            merged.add(
 *
import org.apache.logging.log4j.LogManager;
        for (RelNode input : n.getInputs()) {  
 * gathers (SINGLETON) to the coordinator's reduce.
import java.util.List;
                capabilityRegistry  
            }
                preferHashJoin
     * Appends every (partition × side) {@link ShuffleScanInstructionNode} to the worker stage's plan
    }
                );  
                    + "buildRows={} preferHashJoin={} targets={}",  
        }
     * session context. The {@code WorkerFragmentStageExecutionFactory} filters this list down to the two
     * and the resolved target node list (one node per partition).  
            // Placeholder setup with partition=-1 — the per-task filter in
}
        ClusterService clusterService,
            for (int p = 0; p < partitionCount; p++) {  
        int n = producer.getTargetResolver().resolve(clusterService.state(), null).size();  
                level.rightProducer().getStageId(),  
/*  
    /**
            enriched.add(sp.withInstructions(merged));
            merged.addAll(existing);
        }
import org.apache.logging.log4j.Logger;  
            boolean preferHashJoin = buildRows < sortMergeJoinMinRows;
            // (right input) is estimated to exceed the sort-merge-join floor, tell the worker to use a
 */
     * is dropped so {@code PlanAlternativeSelector} can't pick a driver that throws at execution.  
                ctx.queryId(),
import org.opensearch.cluster.service.ClusterService;
        int rightProducerStageId,  
        int workerStageId = workerStage.getStageId();  
                ctx.queryId(),
            .getCapabilityProvider()
                        + " resolved "
 * <p>An INTERMEDIATE worker is BOTH a shuffle consumer (of the level below — gets setup + scan
     * producer feeding an intermediate worker may itself be a worker (its instructions already carry
                ctx.queryId(),
 *   <li>{@link #enrichLevels} — attaches each level's producer/scan/worker shuffle instructions bottom-up;</li>
    private static boolean canDriveShuffleProducer(CapabilityRegistry registry, String backendId) {
        int consumerStageId,  
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
        }
                leftExpected,
            enrichWorkerAlternatives(
        if (n instanceof OpenSearchTableScan scan) {
                merged.add(new ShuffleScanInstructionNode(rightInputId, p, rightExpectedSenders, queryId, workerStageId, "right"));
/**  
 * <p>Holds three things, all formerly living in the deleted cascade/hash-shuffle dispatchers:  
                "No shuffle-producer-capable plan alternative on producer stage "
import org.opensearch.analytics.spi.ShuffleScanInstructionNode;
                        + targets.size()  
            );
            // The worker consumes its two producers' partitions. enrichWorkerAlternatives prepends a setup
    ) {
            // this worker also feeds a higher level) stays AFTER the scans because enrichProducerAlternatives  
                capabilityRegistry
        // OpenSearchStageInputScan leaves the convertor rewrites to "input-<producerStageId>" NamedScans.
import org.opensearch.analytics.spi.ShuffleWorkerSetupInstructionNode;  
        return registry.getBackend(backendId)  
        for (StagePlan sp : producerStage.getPlanAlternatives()) {
        if (producer.getTargetResolver() == null) {  
    /**
                worker,  
     * partitions and marks isLast once per partition, so the count is the producer's task count. Falls back
            }
import org.opensearch.analytics.spi.InstructionNode;  
    /** Canonical {@code "input-<producerStageId>"} name the fragment convertor emits when it rewrites the  
    /**
    public static String canonicalInputId(int producerStageId) {  
                level.leftProducer().getStageId(),
     */
            // producer's own exchange info is SINGLETON (empty keys); it must partition its join OUTPUT on
    private ShuffleEnrichment() {}
                merged.add(new ShuffleScanInstructionNode(leftInputId, p, leftExpectedSenders, queryId, workerStageId, "left"));
        return "input-" + producerStageId;
            int partitionCount = level.partitionCount();
    ) {
                level.leftKeys(),  
            );
     * stages, the per-side hash keys the producers must partition their output on, the partition count,
import org.opensearch.analytics.planner.dag.GeneralShuffleDAGRewriter;
            if (canDriveShuffleProducer(registry, sp.backendId()) == false) {
 *   <li>{@link #enrichProducerAlternatives} / {@link #enrichWorkerAlternatives} / {@link #canonicalInputId}
                new ShuffleWorkerSetupInstructionNode(queryId, workerStageId, -1, leftExpectedSenders, rightExpectedSenders, preferHashJoin)  
                throw new IllegalStateException(
            .dataTransferCapabilities()
     * Per-(partition, side) sender count the consumer worker expects. A producer task — whether a leaf  
        }
    }
        long sortMergeJoinMinRows
            throw new IllegalStateException(  
            );  
 * ({@link GeneralShuffleDAGRewriter} / {@link UnifiedDispatch}) depends  
            );
 * SPDX-License-Identifier: Apache-2.0
                workerStageId,
     * keys — an intermediate worker producer's own exchange info is SINGLETON, so the keys it must partition
        }
    public record WorkerLevel(Stage worker, Stage leftProducer, Stage rightProducer, List<Integer> leftKeys, List<Integer> rightKeys,
     *  consumer fragment's {@code OpenSearchStageInputScan} leaves. The handler must register streaming
            int rightExpected = expectedSendersFor(level.rightProducer(), partitionCount, clusterService);
            // appended it to the worker's own alternatives.
            // placeholder and appends per-(partition,side) scans; a producer instruction (added above when
            List<InstructionNode> merged = new ArrayList<>(1 + existing.size() + 2 * partitionCount);  
            // sides' expected sender counts. We don't know the partition at this step (one alternative serves  
        CapabilityRegistry capabilityRegistry,  
        int leftProducerStageId,
import org.opensearch.analytics.spi.DataTransferCapability;
    }
            List<String> targets = level.targetNodeIds();  
            List<InstructionNode> merged = new ArrayList<>(existing.size() + 1);  
    /**  
            );
        if (node == null) {
            .stream()  
    }
    static long subtreeMaxScanRows(RelNode node) {  
 *       — the per-stage instruction attachment + the canonical {@code input-<producerStageId>} naming the  
    public static void enrichWorkerAlternatives(
            }  
        String side,  
 *       per-side hash keys + partition count + target node list);</li>  
 *   <li>{@link WorkerLevel} — the per-join-level descriptor (worker stage + its two shuffle producers +
    }  
    }
        }
        int rightExpectedSenders,  
            long buildRows = subtreeMaxScanRows(level.rightProducer().getFragment());
        int leftExpectedSenders,
 * this file be licensed under the Apache-2.0 license or a
            merged.addAll(existing);
        String rightInputId = canonicalInputId(rightProducerStageId);
            // spillable sort-merge join instead of the non-spillable hash-join build. Estimated from the
     * instruction passes through unfiltered.  
 * Shared hash-shuffle worker-tier primitives used by the general MPP scheduler (Option B — see
 * enrichments compose in the order {@code [setup, scan…, producer]} so the worker reads its children's  
            enrichProducerAlternatives(
            return 0L;
        List<StagePlan> enriched = new ArrayList<>(workerStage.getPlanAlternatives().size());  
     * setup+scan); the producer instruction is appended so the order stays {@code [setup, scan…, producer]}.  
     */
            enriched.add(sp.withInstructions(merged));  
import org.apache.calcite.rel.RelNode;
        String queryId,
package org.opensearch.analytics.exec.join;
                leftExpected,
                targets,
    public static void enrichProducerAlternatives(
                level.leftProducer(),
        List<WorkerLevel> levels,  
 * on these primitives directly rather than on the now-removed enumerated shape dispatchers.
        int partitionCount,
                        + workerStageId
                workerStageId,  
import org.opensearch.analytics.exec.QueryContext;
     * Appends a {@link ShuffleProducerInstructionNode} to every shuffle-producer-capable plan alternative
 * The OpenSearch Contributors require contributions made to  
     * alternatives, prefixed by a {@link ShuffleWorkerSetupInstructionNode} that bootstraps a worker-mode  
     *  tables under this exact name so the worker plan's NamedScan binds correctly. */
            );
 *  
                targets  
                    + side
        List<Integer> hashKeys,
    }
     * estimate {@code DistributionEnforcementPass} uses for the distribute floor.
            // WorkerFragmentStageExecutionFactory replaces this with a partition-specific copy carrying both
            return Math.max(fallbackPartitionCount, 1);
            // Producers ship to THIS worker's partitions (its node list), tagged with the side. The hash  
        for (WorkerLevel level : levels) {  
            // the parent join's keys, not its (gathered) input's.  
                "right",  
public final class ShuffleEnrichment {  
     * Enriches each worker level bottom-up with its shuffle producer / scan / worker instructions. A
    /**  
        List<String> targetWorkerNodeIds,
                    + " (side="  
        }  
                        + " target nodes but partitionCount="
import java.util.ArrayList;  
                level.rightProducer().getStageId(),  
     * to the worker's own {@code partitionCount} when the producer has no resolver.  
    private static int expectedSendersFor(Stage producer, int fallbackPartitionCount, ClusterService clusterService) {
    public static void enrichLevels(
        long max = 0L;
            int workerStageId = worker.getStageId();
    ) {
            List<InstructionNode> existing = sp.instructions();
                level.leftProducer().getStageId(),
 * {@code MPP-GENERAL-SCHEDULING-DESIGN.md}). Extracted into a neutral home so the general scheduler
                level.rightKeys(),
        for (StagePlan sp : workerStage.getPlanAlternatives()) {
        List<StagePlan> enriched = new ArrayList<>(producerStage.getPlanAlternatives().size());  
 * compatible open source license.
            enrichProducerAlternatives(
            // right producer's largest scan subtree (the build feeds from the right producer's shuffle).  
        if (enriched.isEmpty()) {
        return max;  
            Stage worker = level.worker();
        String leftInputId = canonicalInputId(leftProducerStageId);
                preferHashJoin,
                partitionCount,  
        String queryId,
            // wrong results or an IndexOutOfBounds deep in dispatch.  
            // Fail fast if the resolved target list doesn't have exactly one node per partition  
