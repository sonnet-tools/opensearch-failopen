                    }
        List<FragmentExecutionRequest.PlanAlternative> alts = new ArrayList<>();  
                                targetStageId,
     * the setup handler can eagerly register both sides' expected sender counts on the buffer
            // For sides with no ShuffleScan instruction (M3 agg shuffle has only "left" scans),
                            new ShuffleWorkerSetupInstructionNode(  
import org.opensearch.analytics.planner.dag.StagePlan;
            // own value be the fallback for sides with no ShuffleScan — that's how the M3
        for (StagePlan plan : stage.getPlanAlternatives()) {
 * @opensearch.internal  
            // single-side aggregate path tells the worker buffer that the right side has zero
                            )
public final class WorkerFragmentStageExecutionFactory implements StageExecutionFactory {
                                rightExpected,
/**
            // expected senders (placeholder carries rightExpectedSenders=0).  
    /**  
                                queryId,
                } else if (node instanceof ShuffleWorkerSetupInstructionNode) {
 * full instruction list (with all 2N partition-side scans appended) is filtered down so  
    private final AnalyticsSearchTransportService transport;
import org.opensearch.analytics.planner.dag.Stage;
import org.opensearch.analytics.exec.QueryContext;
            return new WorkerFragmentRequest(queryId, stageId, partitionIndex, filtered);
                }
        this.clusterService = clusterService;
        final String queryId = config.queryId();
            // Default to -1 ("leave unchanged" in setExpectedSenders) and let the placeholder's  
                    filtered,
                    // Replace the placeholder setup with a partition-specific copy carrying
 */
            // (left + right). The expected sender counts come from the ShuffleScan instructions  
            }
                    targetStageId = placeholderSetup.getTargetStageId();  
                    // both sides' expected counts.  
            // pre-fires the right-side latch and doesn't get clobbered to -1.  
                        filtered.add(node);
import org.opensearch.analytics.spi.InstructionNode;
                    filtered.add(node);
            alts.add(
 * Builds a {@link WorkerFragmentStageExecution} that fans out one fragment request per  
        return alts;
            }  
            );
            if (placeholderSetup != null) {
            int rightExpected = -1;
                                leftExpected,
                        filtered.add(scan);
     * <p>The returned alternatives are the wire payload sent to the worker task; the
            boolean preferHashJoin = true;
            // Compute per-partition setup parameters from the partition's own scan instructions
    }
                        leftExpected = scan.getExpectedSenders();
            List<InstructionNode> filtered = new ArrayList<>();
                    }  
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
/*  
        this.transport = transport;  
                // placeholder → partition-specific rebuild below.  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.analytics.spi.ShuffleWorkerSetupInstructionNode;
 * {@link ShuffleScanInstructionNode}s for that target's partition — the consumer-stage's
                }
}  
     * data-node-side handler chain runs setup → register-left-stream → register-right-stream →
                // Carry the coordinator's per-worker-stage sort-merge-join decision through the
 * SPDX-License-Identifier: Apache-2.0
                                preferHashJoin  
                new FragmentExecutionRequest.PlanAlternative(
     * execute.  
                if (leftExpected < 0) leftExpected = placeholderSetup.getLeftExpectedSenders();
    @Override  
                    }
                if (node instanceof ShuffleScanInstructionNode scan && scan.getShufflePartitionIndex() == partitionIndex) {
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;  
                    }
        };
                if (queryId == null) {
            for (InstructionNode node : plan.instructions()) {
            int partitionIndex = target.partitionIndex();
            ShuffleWorkerSetupInstructionNode placeholderSetup = null;  
 */  
            // fall back to the placeholder's stored value so a configured "rightExpected=0"
import java.util.function.Function;  
                    if (scan.getShufflePartitionIndex() == partitionIndex) {
 * compatible open source license.
                    plan.backendId(),  
                                partitionIndex,  
import java.util.List;
        Function<WorkerExecutionTarget, WorkerFragmentRequest> requestBuilder = target -> {
     *  
                    if ("left".equals(scan.getSide())) {  
import java.util.ArrayList;
                        filtered.add(
        return new WorkerFragmentStageExecution(stage, config, sink, clusterService, requestBuilder, transport);  
            // (each scan carries the count for its side); the placeholder setup at the head
                if (node instanceof ShuffleScanInstructionNode scan) {  
            for (InstructionNode node : plan.instructions()) {
                    /* delegationDescriptor */ null  
                    } else if ("right".equals(scan.getSide())) {
            String queryId = null;  
import org.opensearch.analytics.exec.action.WorkerFragmentRequest;
 *
import org.opensearch.analytics.planner.dag.WorkerExecutionTarget;  
                    queryId = placeholderSetup.getQueryId();
     * Filters every {@link StagePlan}'s instruction list to keep only the ShuffleScan
     * BEFORE any ShuffleScanHandler calls awaitReady.
package org.opensearch.analytics.exec.stage.worker;
                } else {  
                        queryId = scan.getQueryId();  
    }
 * each worker session registers only its own per-partition streaming tables.
                    if (queryId != null) {
    public WorkerFragmentStageExecutionFactory(ClusterService clusterService, AnalyticsSearchTransportService transport) {
import org.opensearch.analytics.exec.stage.StageExecutionFactory;  
        final int stageId = stage.getStageId();  
        }  
import org.opensearch.analytics.spi.ExchangeSink;
            // doesn't have them yet because it was added before per-partition info was known.
            int targetStageId = -1;
                        );
     * {@link ShuffleWorkerSetupInstructionNode} placeholder with a partition-specific copy so  
    private final ClusterService clusterService;
    }
import org.opensearch.analytics.exec.stage.StageExecution;
            int leftExpected = -1;
    private static List<FragmentExecutionRequest.PlanAlternative> filterPlanAlternativesForPartition(Stage stage, int partitionIndex) {
 * this file be licensed under the Apache-2.0 license or a
                    } else {  
            List<FragmentExecutionRequest.PlanAlternative> filtered = filterPlanAlternativesForPartition(stage, partitionIndex);  
                        rightExpected = scan.getExpectedSenders();  
 *
                    if (queryId == null) {
                )
                }
            }  
     * instructions for {@code partitionIndex}. Replaces the partition-agnostic
import org.opensearch.analytics.spi.ShuffleScanInstructionNode;  
                } else if (node instanceof ShuffleWorkerSetupInstructionNode setup) {  
                    plan.convertedBytes(),
    public StageExecution createExecution(Stage stage, ExchangeSink sink, QueryContext config) {
                preferHashJoin = placeholderSetup.getPreferHashJoin();
                if (rightExpected < 0) rightExpected = placeholderSetup.getRightExpectedSenders();  
import org.opensearch.cluster.service.ClusterService;
                    placeholderSetup = setup;
                        targetStageId = scan.getTargetStageId();
     */
 * resolved {@link WorkerExecutionTarget}. Each per-task request carries only the two
