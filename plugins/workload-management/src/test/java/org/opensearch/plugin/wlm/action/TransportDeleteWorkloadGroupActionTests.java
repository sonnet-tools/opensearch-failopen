    private ActionFilters actionFilters;  
        doAnswer(invocation -> {
        AcknowledgedResponse originalResponse = new AcknowledgedResponse(true);
        Metadata metadata = mock(Metadata.class);
        when(getRuleResponse.getRules()).thenReturn(List.of(mockRule));
        ExecutorService mockExecutor = mock(ExecutorService.class);
        action.clusterManagerOperation(request, clusterState, listener);
    /**
    public void testClusterManagerOperationSuccess() throws Exception {
import org.opensearch.action.support.ActionFilters;
        DeleteWorkloadGroupRequest request = new DeleteWorkloadGroupRequest(workloadGroupName);
        WorkloadGroup mockWorkloadGroup = createMockWorkloadGroup(workloadGroupName, workloadGroupId);
        // Mock rule persistence service responses  
    /**
            featureType
     * Test case to validate that deletion is prevented when rules exist for the workload group  
    private WorkloadGroupPersistenceService workloadGroupPersistenceService;  
import org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService;
 */  
import org.opensearch.test.OpenSearchTestCase;  
 * compatible open source license.
        ExecutorService mockExecutor = mock(ExecutorService.class);
        doAnswer(invocation -> {  
            ruleListener.onResponse(getRuleResponse);
        ClusterState clusterState = createEmptyClusterState();
        // Mock empty rules response  
        when(getRuleResponse.getRules()).thenReturn(Collections.emptyList());
        }).when(mockExecutor).submit(any(Runnable.class));
     * Test case to validate the construction for TransportDeleteWorkloadGroupAction  
 * The OpenSearch Contributors require contributions made to  
        Map<String, WorkloadGroup> workloadGroups = Collections.emptyMap();
    /**
        }).when(mockExecutor).submit(any(Runnable.class));
        String workloadGroupName = "testGroup";
            transportService,
    public void testCheckBlock() {  
     * Test case to validate stream input reading
    }
    public void testRuleDeletionWithException() throws Exception {
        @SuppressWarnings("unchecked")
import org.opensearch.threadpool.ThreadPool;
        rulePersistenceService = mock(IndexStoredRulePersistenceService.class);
        verify(listener).onFailure(any(IllegalStateException.class));
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);  
        when(mockRule.getId()).thenReturn(ruleId);
    /**
            ((Runnable) invocation.getArgument(0)).run();
import org.opensearch.cluster.ClusterState;
        assertNotNull(action);  
    }  
    /**  
public class TransportDeleteWorkloadGroupActionTests extends OpenSearchTestCase {
            workloadGroupPersistenceService,
        when(threadPool.executor(ThreadPool.Names.GET)).thenReturn(mockExecutor);
            MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
        when(mockRule.getFeatureValue()).thenReturn(workloadGroupId);
        return clusterState;
    private ClusterState createEmptyClusterState() {
            return null;  
import org.opensearch.transport.TransportService;
import org.opensearch.rule.service.IndexStoredRulePersistenceService;
        // Should not throw exception, just log and continue
        DeleteWorkloadGroupRequest request = new DeleteWorkloadGroupRequest(workloadGroupName);
    }  
 * this file be licensed under the Apache-2.0 license or a
        when(metadata.workloadGroups()).thenReturn(workloadGroups);  
    private IndexNameExpressionResolver indexNameExpressionResolver;
    private TransportDeleteWorkloadGroupAction action;  
     * Test case to validate ResourceNotFoundException when workload group doesn't exist  
            ActionListener<GetRuleResponse> ruleListener = invocation.getArgument(1);  
    public void testRead() throws IOException {  
        actionFilters = mock(ActionFilters.class);
        String workloadGroupId = "test-id-123";  
        @SuppressWarnings("unchecked")
        clusterService = mock(ClusterService.class);
            runnable.run();
        threadPool = mock(ThreadPool.class);
package org.opensearch.plugin.wlm.action;
        ClusterState clusterState = createMockClusterStateWithWorkloadGroup(mockWorkloadGroup);
     * Test case to validate cluster block check
        doAnswer(invocation -> {  
        // Mock rule persistence service responses  
     * Test case to validate successful workload group deletion
        action.clusterManagerOperation(request, clusterState, listener);
        when(threadPool.executor(ThreadPool.Names.GET)).thenReturn(mockExecutor);
            ActionListener<GetRuleResponse> ruleListener = invocation.getArgument(1);  
     */
        DeleteWorkloadGroupRequest request = new DeleteWorkloadGroupRequest(workloadGroupName);
        when(clusterState.getMetadata()).thenReturn(metadata);
        // Mock empty rules response
            resourceLimits  
    }  
        doAnswer(invocation -> {
        BytesStreamOutput out = new BytesStreamOutput();  
        // Mock executor service
        doAnswer(invocation -> {  
        assertEquals(ThreadPool.Names.GET, action.executor());
            @SuppressWarnings("unchecked")
        WorkloadGroup mockWorkloadGroup = createMockWorkloadGroup(workloadGroupName, workloadGroupId);
            return null;
    /**  
        }).when(mockExecutor).submit(any(Runnable.class));  
        verify(clusterBlocks).globalBlockedException(any());  
     * Test case to validate successful deletion when no rules exist for the workload group
        ClusterState clusterState = createMockClusterStateWithWorkloadGroup(mockWorkloadGroup);  
            return null;
        );
        }).when(mockExecutor).submit(any(Runnable.class));
            Runnable runnable = invocation.getArgument(0);
        @SuppressWarnings("unchecked")
        assertEquals(originalResponse.isAcknowledged(), readResponse.isAcknowledged());
        Map<String, WorkloadGroup> workloadGroups = Map.of(workloadGroup.get_id(), workloadGroup);
        }).when(mockExecutor).submit(any(Runnable.class));
        ClusterState clusterState = mock(ClusterState.class);  
        // Mock executor to immediately execute the runnable  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
        Rule mockRule = createMockRule("rule-1", workloadGroupId);
    public void testClusterManagerOperationWorkloadGroupNotFound() throws Exception {
    }
            indexNameExpressionResolver,
    /**  
        GetRuleResponse getRuleResponse = mock(GetRuleResponse.class);  
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
            return null;
        @SuppressWarnings("unchecked")  
        when(clusterState.getMetadata()).thenReturn(metadata);
            ruleListener.onResponse(getRuleResponse);
        // Mock rules that reference this workload group
        // Mock rule persistence service responses  
            runnable.run();
        ExecutorService mockExecutor = mock(ExecutorService.class);
        when(clusterState.metadata()).thenReturn(metadata);
        return clusterState;
import org.opensearch.wlm.MutableWorkloadGroupFragment;  
        verify(workloadGroupPersistenceService, never()).deleteInClusterStateMetadata(any(), any());
        @SuppressWarnings("unchecked")  
        GetRuleResponse getRuleResponse = mock(GetRuleResponse.class);  
            return null;  
        MutableWorkloadGroupFragment fragment = new MutableWorkloadGroupFragment(
    /**
        ClusterBlocks clusterBlocks = mock(ClusterBlocks.class);  
        when(threadPool.executor(ThreadPool.Names.GET)).thenReturn(mockExecutor);
        action = new TransportDeleteWorkloadGroupAction(
        when(threadPool.executor(ThreadPool.Names.GET)).thenReturn(mockExecutor);  
import org.opensearch.cluster.metadata.WorkloadGroup;
import org.opensearch.ResourceNotFoundException;
        ClusterState clusterState = mock(ClusterState.class);  
        String workloadGroupName = "testGroup";
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
        transportService = mock(TransportService.class);  
import org.opensearch.cluster.service.ClusterService;  
        doAnswer(invocation -> {
            ActionListener<GetRuleResponse> ruleListener = invocation.getArgument(1);  
     */
        action.clusterManagerOperation(request, clusterState, listener);  
    }  
            Runnable runnable = invocation.getArgument(0);
        when(metadata.workloadGroups()).thenReturn(workloadGroups);  
        doAnswer(invocation -> {  
 * SPDX-License-Identifier: Apache-2.0
    public void testConstruction() {
    }
import org.opensearch.rule.autotagging.Rule;
        action.checkBlock(request, clusterState);
    }  
            return null;  
import static org.mockito.Mockito.verify;
    private IndexStoredRulePersistenceService rulePersistenceService;
        return mockRule;  
/*  
        when(clusterState.metadata()).thenReturn(metadata);
        verify(rulePersistenceService).getRule(any(GetRuleRequest.class), any());
        String workloadGroupName = "testGroup";  
            threadPool,  
        ClusterState clusterState = mock(ClusterState.class);
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
import static org.mockito.Mockito.never;
        action.clusterManagerOperation(request, clusterState, listener);
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
import static org.mockito.ArgumentMatchers.any;  
            runnable.run();
        AcknowledgedResponse readResponse = action.read(out.bytes().streamInput());  
     * Test case to validate rule deletion handles exceptions gracefully  
        // Create mock workload group  
            Runnable runnable = invocation.getArgument(0);
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any());  
        WorkloadGroup mockWorkloadGroup = createMockWorkloadGroup(workloadGroupName, workloadGroupId);
        ClusterState clusterState = createMockClusterStateWithWorkloadGroup(mockWorkloadGroup);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    @Override
        verify(listener).onFailure(any(RuntimeException.class));  
        // Mock executor service  
        Rule mockRule = mock(Rule.class);  
            clusterService,  
import org.opensearch.rule.action.GetRuleRequest;
            @SuppressWarnings("unchecked")
        workloadGroupPersistenceService = mock(WorkloadGroupPersistenceService.class);
    private TransportService transportService;
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any());  
    private ClusterService clusterService;
        verify(workloadGroupPersistenceService).deleteInClusterStateMetadata(eq(request), eq(listener));
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any());  
            return null;
    private ClusterState createMockClusterStateWithWorkloadGroup(WorkloadGroup workloadGroup) {
        featureType = mock(WorkloadGroupFeatureType.class);  
     */  
    }  
    }  
        verify(workloadGroupPersistenceService, never()).deleteInClusterStateMetadata(any(), any());  
        ClusterState clusterState = createMockClusterStateWithWorkloadGroup(mockWorkloadGroup);
import static org.mockito.Mockito.mock;  
import java.util.Collections;
        verify(workloadGroupPersistenceService).deleteInClusterStateMetadata(eq(request), eq(listener));
import java.util.List;
        action.clusterManagerOperation(request, clusterState, listener);
        // Mock executor to immediately execute the runnable  
}
        Map<ResourceType, Double> resourceLimits = Map.of(ResourceType.CPU, 0.5);  
        // Mock rule persistence service to throw exception  
            ((Runnable) invocation.getArgument(0)).run();
import static org.mockito.Mockito.doAnswer;
        String workloadGroupName = "testGroup";  
            return null;  
import java.io.IOException;  
            @SuppressWarnings("unchecked")
 *
    private WorkloadGroupFeatureType featureType;
        String workloadGroupId = "test-id-123";
    }
            @SuppressWarnings("unchecked")
import org.opensearch.rule.action.GetRuleResponse;  
     */
import org.opensearch.common.io.stream.BytesStreamOutput;
    public void setUp() throws Exception {  
import java.util.concurrent.ExecutorService;
        DeleteWorkloadGroupRequest request = new DeleteWorkloadGroupRequest(workloadGroupName);
            return null;
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any());  
        originalResponse.writeTo(out);
        ExecutorService mockExecutor = mock(ExecutorService.class);
        when(clusterState.blocks()).thenReturn(clusterBlocks);
        doAnswer(invocation -> {
        String workloadGroupName = "nonExistentGroup";  
    public void testSuccessfulDeletionWithNoRules() throws Exception {  
     */
            ActionListener<GetRuleResponse> ruleListener = invocation.getArgument(1);  
        String workloadGroupId = "test-id-123";
        when(getRuleResponse.getRules()).thenReturn(Collections.emptyList());
import static org.mockito.ArgumentMatchers.eq;
        super.setUp();
    private Rule createMockRule(String ruleId, String workloadGroupId) {
import org.opensearch.cluster.metadata.Metadata;
    }
        DeleteWorkloadGroupRequest request = new DeleteWorkloadGroupRequest(workloadGroupName);  
import java.util.Map;  
import static org.mockito.Mockito.when;  
        WorkloadGroup mockWorkloadGroup = createMockWorkloadGroup(workloadGroupName, workloadGroupId);
        );
    private WorkloadGroup createMockWorkloadGroup(String name, String id) {
        verify(rulePersistenceService).getRule(any(GetRuleRequest.class), any());
        verify(rulePersistenceService).getRule(any(GetRuleRequest.class), any());
     */
            rulePersistenceService,  
        Metadata metadata = mock(Metadata.class);
        ExecutorService mockExecutor = mock(ExecutorService.class);
            actionFilters,
        verify(mockExecutor).submit(any(Runnable.class));
import org.opensearch.cluster.block.ClusterBlocks;
        return new WorkloadGroup(name, id, fragment, System.currentTimeMillis());
        // Create empty cluster state  
        // Create mock cluster state with workload group  
import org.opensearch.wlm.ResourceType;
    public void testRuleDeletionWithExistingRules() throws Exception {
     */
        verify(listener).onFailure(any(ResourceNotFoundException.class));
        indexNameExpressionResolver = mock(IndexNameExpressionResolver.class);  
        when(threadPool.executor(ThreadPool.Names.GET)).thenReturn(mockExecutor);
            ruleListener.onResponse(getRuleResponse);
    }  
import org.opensearch.plugin.wlm.rule.WorkloadGroupFeatureType;  
import org.opensearch.core.action.ActionListener;
            ruleListener.onFailure(new RuntimeException("Rule service error"));
    private ThreadPool threadPool;
        DeleteWorkloadGroupRequest request = new DeleteWorkloadGroupRequest("testGroup");
        String workloadGroupId = "test-id-123";
        GetRuleResponse getRuleResponse = mock(GetRuleResponse.class);
        doAnswer(invocation -> {
     */
