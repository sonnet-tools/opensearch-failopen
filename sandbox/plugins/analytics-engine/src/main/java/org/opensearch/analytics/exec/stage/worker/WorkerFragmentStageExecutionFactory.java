                    targetStageId = placeholderSetup.getTargetStageId();
                    // Replace the placeholder setup with a partition-specific copy carrying
                    if (queryId == null) {
    }
                    if (scan.getShufflePartitionIndex() == partitionIndex) {
/*
                if (rightExpected < 0) rightExpected = placeholderSetup.getRightExpectedSenders();
    }
        this.clusterService = clusterService;
import org.opensearch.analytics.planner.dag.Stage;
    /**
                                targetStageId,
     *
            // For sides with no ShuffleScan instruction (M3 agg shuffle has only "left" scans),
     * {@link ShuffleWorkerSetupInstructionNode} placeholder with a partition-specific copy so
            // Default to -1 ("leave unchanged" in setExpectedSenders) and let the placeholder's
        final String queryId = config.queryId();
import org.opensearch.analytics.spi.ShuffleWorkerSetupInstructionNode;
                }
            boolean preferHashJoin = true;
 * SPDX-License-Identifier: Apache-2.0
                                leftExpected,
            }
                }
     * instructions for {@code partitionIndex}. Replaces the partition-agnostic
 * resolved {@link WorkerExecutionTarget}. Each per-task request carries only the two
    private final AnalyticsSearchTransportService transport;
import java.util.function.Function;
     * data-node-side handler chain runs setup → register-left-stream → register-right-stream →
                        );
            List<FragmentExecutionRequest.PlanAlternative> filtered = filterPlanAlternativesForPartition(stage, partitionIndex);
                    // both sides' expected counts.
import org.opensearch.analytics.exec.stage.StageExecution;
            // expected senders (placeholder carries rightExpectedSenders=0).
                )
import org.opensearch.analytics.spi.InstructionNode;
                preferHashJoin = placeholderSetup.getPreferHashJoin();
            String queryId = null;
                } else if (node instanceof ShuffleWorkerSetupInstructionNode setup) {
 * compatible open source license.
                // placeholder → partition-specific rebuild below.
 * {@link ShuffleScanInstructionNode}s for that target's partition — the consumer-stage's
        final int stageId = stage.getStageId();
import org.opensearch.analytics.planner.dag.WorkerExecutionTarget;
            }
                if (node instanceof ShuffleScanInstructionNode scan) {
/**
}
 */
                } else {
            List<InstructionNode> filtered = new ArrayList<>();
     * execute.
            }
     */
            int rightExpected = -1;
                    if (queryId != null) {
                    filtered,
            alts.add(
                    }
                    }
import java.util.List;
import org.opensearch.analytics.exec.action.WorkerFragmentRequest;
                    /* delegationDescriptor */ null
        for (StagePlan plan : stage.getPlanAlternatives()) {
            // own value be the fallback for sides with no ShuffleScan — that's how the M3
     * BEFORE any ShuffleScanHandler calls awaitReady.
package org.opensearch.analytics.exec.stage.worker;
                            new ShuffleWorkerSetupInstructionNode(
                        rightExpected = scan.getExpectedSenders();
            int partitionIndex = target.partitionIndex();
public final class WorkerFragmentStageExecutionFactory implements StageExecutionFactory {
            ShuffleWorkerSetupInstructionNode placeholderSetup = null;
                        queryId = scan.getQueryId();
                }
                    if ("left".equals(scan.getSide())) {
 */
                        filtered.add(node);
            // Compute per-partition setup parameters from the partition's own scan instructions
            int targetStageId = -1;
            return new WorkerFragmentRequest(queryId, stageId, partitionIndex, filtered);
import org.opensearch.analytics.planner.dag.StagePlan;
    public WorkerFragmentStageExecutionFactory(ClusterService clusterService, AnalyticsSearchTransportService transport) {
                    filtered.add(node);
        return new WorkerFragmentStageExecution(stage, config, sink, clusterService, requestBuilder, transport);
                        targetStageId = scan.getTargetStageId();
 * full instruction list (with all 2N partition-side scans appended) is filtered down so
 * Builds a {@link WorkerFragmentStageExecution} that fans out one fragment request per
                    } else if ("right".equals(scan.getSide())) {
 *
                new FragmentExecutionRequest.PlanAlternative(
                    placeholderSetup = setup;
     * the setup handler can eagerly register both sides' expected sender counts on the buffer
                    plan.convertedBytes(),
        }
            );
                } else if (node instanceof ShuffleWorkerSetupInstructionNode) {
                        leftExpected = scan.getExpectedSenders();
            // pre-fires the right-side latch and doesn't get clobbered to -1.
import org.opensearch.analytics.spi.ExchangeSink;
    }
    @Override
    private final ClusterService clusterService;
            for (InstructionNode node : plan.instructions()) {
 * each worker session registers only its own per-partition streaming tables.
                        filtered.add(scan);
import java.util.ArrayList;
 * this file be licensed under the Apache-2.0 license or a
            // (each scan carries the count for its side); the placeholder setup at the head
                            )
                    }
    public StageExecution createExecution(Stage stage, ExchangeSink sink, QueryContext config) {
    private static List<FragmentExecutionRequest.PlanAlternative> filterPlanAlternativesForPartition(Stage stage, int partitionIndex) {
import org.opensearch.cluster.service.ClusterService;
        this.transport = transport;
        };
                // Carry the coordinator's per-worker-stage sort-merge-join decision through the
        return alts;
     * <p>The returned alternatives are the wire payload sent to the worker task; the
                    queryId = placeholderSetup.getQueryId();
            int leftExpected = -1;
 * @opensearch.internal
            // doesn't have them yet because it was added before per-partition info was known.
                                preferHashJoin
import org.opensearch.analytics.spi.ShuffleScanInstructionNode;
                        filtered.add(
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;
import org.opensearch.analytics.exec.QueryContext;
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
        Function<WorkerExecutionTarget, WorkerFragmentRequest> requestBuilder = target -> {
        List<FragmentExecutionRequest.PlanAlternative> alts = new ArrayList<>();
import org.opensearch.analytics.exec.stage.StageExecutionFactory;
     * Filters every {@link StagePlan}'s instruction list to keep only the ShuffleScan
                    plan.backendId(),
            // fall back to the placeholder's stored value so a configured "rightExpected=0"
                if (leftExpected < 0) leftExpected = placeholderSetup.getLeftExpectedSenders();
                                partitionIndex,
            // (left + right). The expected sender counts come from the ShuffleScan instructions
                if (node instanceof ShuffleScanInstructionNode scan && scan.getShufflePartitionIndex() == partitionIndex) {
                                queryId,
 *
                if (queryId == null) {
            // single-side aggregate path tells the worker buffer that the right side has zero
                                rightExpected,
 * The OpenSearch Contributors require contributions made to
                    }
                    } else {
            if (placeholderSetup != null) {
            for (InstructionNode node : plan.instructions()) {
