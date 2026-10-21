            return null;
import org.opensearch.ResourceNotFoundException;
import java.util.Collections;
        action.clusterManagerOperation(request, clusterState, listener);
        WorkloadGroup mockWorkloadGroup = createMockWorkloadGroup(workloadGroupName, workloadGroupId);
import java.util.concurrent.ExecutorService;
        verify(rulePersistenceService).getRule(any(GetRuleRequest.class), any());
import java.util.List;
            @SuppressWarnings("unchecked")
     */
        doAnswer(invocation -> {
     */
        DeleteWorkloadGroupRequest request = new DeleteWorkloadGroupRequest(workloadGroupName);
        Rule mockRule = createMockRule("rule-1", workloadGroupId);
    }
            Runnable runnable = invocation.getArgument(0);
     * Test case to validate the construction for TransportDeleteWorkloadGroupAction
        ClusterState clusterState = mock(ClusterState.class);
        when(mockRule.getFeatureValue()).thenReturn(workloadGroupId);
    public void testSuccessfulDeletionWithNoRules() throws Exception {
            return null;
        workloadGroupPersistenceService = mock(WorkloadGroupPersistenceService.class);
        String workloadGroupName = "testGroup";
import java.io.IOException;
        // Create mock workload group
        // Create empty cluster state
        assertNotNull(action);
    private WorkloadGroupPersistenceService workloadGroupPersistenceService;
    /**
import static org.mockito.Mockito.verify;
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any());
            @SuppressWarnings("unchecked")
        Metadata metadata = mock(Metadata.class);
        // Mock empty rules response
            @SuppressWarnings("unchecked")
import static org.mockito.ArgumentMatchers.eq;
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any());
     * Test case to validate stream input reading
    }
    }
        verify(workloadGroupPersistenceService).deleteInClusterStateMetadata(eq(request), eq(listener));
            resourceLimits
            return null;
            runnable.run();
            featureType
        Map<String, WorkloadGroup> workloadGroups = Map.of(workloadGroup.get_id(), workloadGroup);
        ClusterState clusterState = createMockClusterStateWithWorkloadGroup(mockWorkloadGroup);
import java.util.Map;
import org.opensearch.rule.action.GetRuleResponse;
        ClusterState clusterState = createMockClusterStateWithWorkloadGroup(mockWorkloadGroup);
        action.checkBlock(request, clusterState);
            return null;
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any());
            return null;
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.cluster.ClusterState;
        verify(listener).onFailure(any(IllegalStateException.class));
    }
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        GetRuleResponse getRuleResponse = mock(GetRuleResponse.class);
        verify(clusterBlocks).globalBlockedException(any());
    public void testConstruction() {
        originalResponse.writeTo(out);
        }).when(mockExecutor).submit(any(Runnable.class));
        doAnswer(invocation -> {
        transportService = mock(TransportService.class);
        assertEquals(originalResponse.isAcknowledged(), readResponse.isAcknowledged());
    public void testCheckBlock() {
 * The OpenSearch Contributors require contributions made to
}
import org.opensearch.cluster.service.ClusterService;
        String workloadGroupId = "test-id-123";
        // Mock rule persistence service responses
        when(threadPool.executor(ThreadPool.Names.GET)).thenReturn(mockExecutor);
            rulePersistenceService,
        BytesStreamOutput out = new BytesStreamOutput();
            return null;
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
import static org.mockito.Mockito.mock;
            ActionListener<GetRuleResponse> ruleListener = invocation.getArgument(1);
        String workloadGroupId = "test-id-123";
    }
        when(threadPool.executor(ThreadPool.Names.GET)).thenReturn(mockExecutor);
        rulePersistenceService = mock(IndexStoredRulePersistenceService.class);
     * Test case to validate cluster block check
            ((Runnable) invocation.getArgument(0)).run();
        verify(mockExecutor).submit(any(Runnable.class));
    /**
        ClusterState clusterState = createEmptyClusterState();
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
            actionFilters,
        when(clusterState.metadata()).thenReturn(metadata);
        clusterService = mock(ClusterService.class);
     */
    }
            ActionListener<GetRuleResponse> ruleListener = invocation.getArgument(1);
        WorkloadGroup mockWorkloadGroup = createMockWorkloadGroup(workloadGroupName, workloadGroupId);
        // Mock rule persistence service responses
     * Test case to validate ResourceNotFoundException when workload group doesn't exist
        AcknowledgedResponse originalResponse = new AcknowledgedResponse(true);
        return clusterState;
            MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
package org.opensearch.plugin.wlm.action;
        // Create mock cluster state with workload group
     * Test case to validate that deletion is prevented when rules exist for the workload group
        action.clusterManagerOperation(request, clusterState, listener);
import org.opensearch.action.support.ActionFilters;
    @Override
     * Test case to validate rule deletion handles exceptions gracefully
        Metadata metadata = mock(Metadata.class);
            indexNameExpressionResolver,
/*
import org.opensearch.cluster.block.ClusterBlocks;
    private TransportDeleteWorkloadGroupAction action;
    /**
    private WorkloadGroup createMockWorkloadGroup(String name, String id) {
        action.clusterManagerOperation(request, clusterState, listener);
            ruleListener.onFailure(new RuntimeException("Rule service error"));
import org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService;
            runnable.run();
    /**
            return null;
        MutableWorkloadGroupFragment fragment = new MutableWorkloadGroupFragment(
        doAnswer(invocation -> {
        GetRuleResponse getRuleResponse = mock(GetRuleResponse.class);
        // Mock rule persistence service to throw exception
    public void testRuleDeletionWithExistingRules() throws Exception {
import org.opensearch.threadpool.ThreadPool;
        doAnswer(invocation -> {
        action.clusterManagerOperation(request, clusterState, listener);
import org.opensearch.common.io.stream.BytesStreamOutput;
        }).when(mockExecutor).submit(any(Runnable.class));
            clusterService,
            ActionListener<GetRuleResponse> ruleListener = invocation.getArgument(1);
        when(threadPool.executor(ThreadPool.Names.GET)).thenReturn(mockExecutor);
import static org.mockito.Mockito.never;
        threadPool = mock(ThreadPool.class);
        when(clusterState.getMetadata()).thenReturn(metadata);
        String workloadGroupName = "nonExistentGroup";
        featureType = mock(WorkloadGroupFeatureType.class);
            runnable.run();
import org.opensearch.rule.autotagging.Rule;
    private Rule createMockRule(String ruleId, String workloadGroupId) {
    /**
        WorkloadGroup mockWorkloadGroup = createMockWorkloadGroup(workloadGroupName, workloadGroupId);
        doAnswer(invocation -> {
        @SuppressWarnings("unchecked")
            return null;
    private ClusterState createEmptyClusterState() {
    }
        AcknowledgedResponse readResponse = action.read(out.bytes().streamInput());
    private ClusterState createMockClusterStateWithWorkloadGroup(WorkloadGroup workloadGroup) {
        ExecutorService mockExecutor = mock(ExecutorService.class);
        doAnswer(invocation -> {
    private ActionFilters actionFilters;
        DeleteWorkloadGroupRequest request = new DeleteWorkloadGroupRequest(workloadGroupName);
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
        when(getRuleResponse.getRules()).thenReturn(Collections.emptyList());
 * compatible open source license.
     */
        doAnswer(invocation -> {
     * Test case to validate successful deletion when no rules exist for the workload group
        ExecutorService mockExecutor = mock(ExecutorService.class);
        // Mock executor service
        super.setUp();
        // Should not throw exception, just log and continue
        verify(rulePersistenceService).getRule(any(GetRuleRequest.class), any());
    private TransportService transportService;
        verify(listener).onFailure(any(RuntimeException.class));
        when(clusterState.blocks()).thenReturn(clusterBlocks);
import org.opensearch.transport.TransportService;
        ClusterState clusterState = mock(ClusterState.class);
            ruleListener.onResponse(getRuleResponse);
        ExecutorService mockExecutor = mock(ExecutorService.class);
        }).when(mockExecutor).submit(any(Runnable.class));
        Map<String, WorkloadGroup> workloadGroups = Collections.emptyMap();
    /**
            return null;
        @SuppressWarnings("unchecked")
        action = new TransportDeleteWorkloadGroupAction(
import org.opensearch.wlm.ResourceType;
    /**
        return new WorkloadGroup(name, id, fragment, System.currentTimeMillis());
        @SuppressWarnings("unchecked")
        WorkloadGroup mockWorkloadGroup = createMockWorkloadGroup(workloadGroupName, workloadGroupId);
     */
     * Test case to validate successful workload group deletion
        verify(listener).onFailure(any(ResourceNotFoundException.class));
        when(clusterState.metadata()).thenReturn(metadata);
            ruleListener.onResponse(getRuleResponse);
    }
            ((Runnable) invocation.getArgument(0)).run();
    public void testRuleDeletionWithException() throws Exception {
            workloadGroupPersistenceService,
        // Mock rule persistence service responses
        @SuppressWarnings("unchecked")
        ExecutorService mockExecutor = mock(ExecutorService.class);
        DeleteWorkloadGroupRequest request = new DeleteWorkloadGroupRequest(workloadGroupName);
    public void testClusterManagerOperationWorkloadGroupNotFound() throws Exception {
        Map<ResourceType, Double> resourceLimits = Map.of(ResourceType.CPU, 0.5);
        actionFilters = mock(ActionFilters.class);
import org.opensearch.rule.service.IndexStoredRulePersistenceService;
        String workloadGroupId = "test-id-123";
            @SuppressWarnings("unchecked")
        when(getRuleResponse.getRules()).thenReturn(List.of(mockRule));
        DeleteWorkloadGroupRequest request = new DeleteWorkloadGroupRequest(workloadGroupName);
        GetRuleResponse getRuleResponse = mock(GetRuleResponse.class);
        when(threadPool.executor(ThreadPool.Names.GET)).thenReturn(mockExecutor);
import org.opensearch.core.action.ActionListener;
        ClusterState clusterState = createMockClusterStateWithWorkloadGroup(mockWorkloadGroup);
        // Mock executor to immediately execute the runnable
            Runnable runnable = invocation.getArgument(0);
import org.opensearch.cluster.metadata.WorkloadGroup;
    private WorkloadGroupFeatureType featureType;
        when(clusterState.getMetadata()).thenReturn(metadata);
        verify(rulePersistenceService).getRule(any(GetRuleRequest.class), any());
        indexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
    private ThreadPool threadPool;
        DeleteWorkloadGroupRequest request = new DeleteWorkloadGroupRequest(workloadGroupName);
    }
import org.opensearch.wlm.MutableWorkloadGroupFragment;
import org.opensearch.plugin.wlm.rule.WorkloadGroupFeatureType;
        ClusterBlocks clusterBlocks = mock(ClusterBlocks.class);
     */
import static org.mockito.Mockito.when;
import org.opensearch.rule.action.GetRuleRequest;
    public void setUp() throws Exception {
        String workloadGroupName = "testGroup";
        doAnswer(invocation -> {
        ClusterState clusterState = createMockClusterStateWithWorkloadGroup(mockWorkloadGroup);
        action.clusterManagerOperation(request, clusterState, listener);
        );
        // Mock empty rules response
        String workloadGroupId = "test-id-123";
 */
    private IndexNameExpressionResolver indexNameExpressionResolver;
            Runnable runnable = invocation.getArgument(0);
        verify(workloadGroupPersistenceService, never()).deleteInClusterStateMetadata(any(), any());
        DeleteWorkloadGroupRequest request = new DeleteWorkloadGroupRequest("testGroup");
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any());
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
        String workloadGroupName = "testGroup";
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        // Mock rules that reference this workload group
        when(getRuleResponse.getRules()).thenReturn(Collections.emptyList());
import static org.mockito.ArgumentMatchers.any;
        ExecutorService mockExecutor = mock(ExecutorService.class);
        // Mock executor to immediately execute the runnable
        ClusterState clusterState = mock(ClusterState.class);
    private IndexStoredRulePersistenceService rulePersistenceService;
    private ClusterService clusterService;
import org.opensearch.test.OpenSearchTestCase;
    /**
    public void testClusterManagerOperationSuccess() throws Exception {
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
        when(metadata.workloadGroups()).thenReturn(workloadGroups);
        when(metadata.workloadGroups()).thenReturn(workloadGroups);
        }).when(mockExecutor).submit(any(Runnable.class));
        Rule mockRule = mock(Rule.class);
        }).when(mockExecutor).submit(any(Runnable.class));
 *
        );
    }
        verify(workloadGroupPersistenceService, never()).deleteInClusterStateMetadata(any(), any());
        verify(workloadGroupPersistenceService).deleteInClusterStateMetadata(eq(request), eq(listener));
        when(threadPool.executor(ThreadPool.Names.GET)).thenReturn(mockExecutor);
    public void testRead() throws IOException {
        @SuppressWarnings("unchecked")
            transportService,
        when(mockRule.getId()).thenReturn(ruleId);
            threadPool,
     */
    }
        return mockRule;
        String workloadGroupName = "testGroup";
        return clusterState;
            ActionListener<GetRuleResponse> ruleListener = invocation.getArgument(1);
            ruleListener.onResponse(getRuleResponse);
        doAnswer(invocation -> {
     */
    }
    }
        assertEquals(ThreadPool.Names.GET, action.executor());
        // Mock executor service
import static org.mockito.Mockito.doAnswer;
public class TransportDeleteWorkloadGroupActionTests extends OpenSearchTestCase {
