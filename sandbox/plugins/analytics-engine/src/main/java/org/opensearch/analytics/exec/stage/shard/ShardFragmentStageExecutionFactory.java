import java.util.List;
    private static List<FragmentExecutionRequest.PlanAlternative> buildPlanAlternatives(Stage stage) {  
            queryId,
        return alternatives;
        if (plan.delegatedExpressions().isEmpty()) {
    }
import org.opensearch.analytics.exec.stage.StageExecutionFactory;  
package org.opensearch.analytics.exec.stage.shard;
                    delegationDescriptor  
                    plan.delegatedExpressions()
/*  
                )
            planAlternatives,
 * The OpenSearch Contributors require contributions made to  
        }
/**
        List<FragmentExecutionRequest.PlanAlternative> alternatives = new ArrayList<>();
    @Override
    }  
            stageId,  
            target.shardId(),
 * — {@link StageExecutionBuilder} resolves that distinction before calling.  
import org.opensearch.analytics.exec.stage.StageExecutionBuilder;
    private static DelegationDescriptor buildDelegationDescriptor(StagePlan plan) {
        // dispatch doesn't pay for cluster-state routing, and leaves room for shuffle
import java.util.function.Function;  
import org.opensearch.cluster.service.ClusterService;
            );
}
        final String queryId = config.queryId();
    }
 * and doesn't care whether it is a root sink or a parent-provided child sink
            alternatives.add(
 */  
        }
 * {@link AnalyticsSearchTransportService}. Takes a pre-resolved {@link ExchangeSink}
    public StageExecution createExecution(Stage stage, ExchangeSink sink, QueryContext config) {  
 * @opensearch.internal
                new FragmentExecutionRequest.PlanAlternative(
public final class ShardFragmentStageExecutionFactory implements StageExecutionFactory {
            }
                );  
 *
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;  
 * compatible open source license.
 * Builds a {@link ShardFragmentStageExecution} that fans out shard requests via  
 * SPDX-License-Identifier: Apache-2.0
        // Execution pulls the resolver off `stage` and calls resolve() lazily at start().
import org.opensearch.analytics.exec.stage.StageExecution;
            return null;  
                    plan.convertedBytes(),
import org.opensearch.analytics.spi.DelegationDescriptor;
                    plan.instructions(),
import org.opensearch.analytics.planner.dag.StagePlan;  
            if (node instanceof ShardScanWithDelegationInstructionNode delegationNode) {
        for (InstructionNode node : plan.instructions()) {  
import java.util.ArrayList;
        );
    }
    private final AnalyticsSearchTransportService transport;
                    delegationNode.getDelegatedPredicateCount(),
import org.opensearch.analytics.spi.InstructionNode;  
import org.opensearch.analytics.spi.ExchangeSink;
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;
            config.profile()  
        return new ShardFragmentStageExecution(stage, config, sink, clusterService, requestBuilder, transport);  
        Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder = target -> new FragmentExecutionRequest(
        for (StagePlan plan : stage.getPlanAlternatives()) {
    private final ClusterService clusterService;  
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
                    delegationNode.getTreeShape(),  
    public ShardFragmentStageExecutionFactory(ClusterService clusterService, AnalyticsSearchTransportService transport) {  
        this.transport = transport;
        this.clusterService = clusterService;
        // reads whose targets depend on child manifests only available at dispatch time.
        final int stageId = stage.getStageId();  
            DelegationDescriptor delegationDescriptor = buildDelegationDescriptor(plan);  
 *
        return null;  
import org.opensearch.analytics.planner.dag.Stage;
                    plan.backendId(),  
        // Extract treeShape and count from the ShardScanWithDelegationInstructionNode
 */  
import org.opensearch.analytics.exec.QueryContext;
 * this file be licensed under the Apache-2.0 license or a
        List<FragmentExecutionRequest.PlanAlternative> planAlternatives = buildPlanAlternatives(stage);
        }  
        // This keeps target resolution out of the build phase so cancellation before  
                return new DelegationDescriptor(
