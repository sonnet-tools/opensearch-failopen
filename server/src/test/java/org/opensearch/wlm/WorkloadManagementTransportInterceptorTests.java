import java.util.Collections;  
        stateAccessor = new WorkloadGroupsStateAccessor();
import org.opensearch.wlm.WorkloadManagementTransportInterceptor.RequestHandler;  
import org.opensearch.threadpool.TestThreadPool;
    private WorkloadManagementTransportInterceptor sut;  
        threadPool = new TestThreadPool(getTestName());  
 * this file be licensed under the Apache-2.0 license or a
            threadPool,  
package org.opensearch.wlm;
    private ClusterService mockClusterService;
        super.setUp();
            )
 * The OpenSearch Contributors require contributions made to  
import static org.mockito.Mockito.mock;  
                mockThreadPool,
 * compatible open source license.
        mockTaskCancellationService = mock(WorkloadGroupTaskCancellationService.class);
import static org.opensearch.threadpool.ThreadPool.Names.SAME;
    }  
import org.opensearch.cluster.ClusterState;
        mockThreadPool = mock(ThreadPool.class);
import org.opensearch.transport.TransportRequestHandler;
import org.opensearch.cluster.service.ClusterService;  
                mockWorkloadManagementSettings,
        when(mockClusterService.state()).thenReturn(state);
/*  
        threadPool.shutdown();
    public void setUp() throws Exception {  
        ClusterState state = mock(ClusterState.class);  
        );
                mockClusterService,  
    private WorkloadManagementSettings mockWorkloadManagementSettings;
            new WorkloadGroupService(
        Metadata metadata = mock(Metadata.class);
    }
        sut = new WorkloadManagementTransportInterceptor(
    private WorkloadGroupsStateAccessor stateAccessor;
    private WorkloadGroupTaskCancellationService mockTaskCancellationService;
        when(state.metadata()).thenReturn(metadata);  
import org.opensearch.test.OpenSearchTestCase;
        mockWorkloadManagementSettings = mock(WorkloadManagementSettings.class);
 */  
}
    public void tearDown() throws Exception {
import org.opensearch.wlm.cancellation.WorkloadGroupTaskCancellationService;
        when(metadata.workloadGroups()).thenReturn(Collections.emptyMap());
    public void testInterceptHandler() {
                mockTaskCancellationService,
        mockClusterService = mock(ClusterService.class);  
import org.opensearch.threadpool.ThreadPool;  
 * SPDX-License-Identifier: Apache-2.0
                stateAccessor  
    private ThreadPool threadPool;
import static org.mockito.Mockito.when;
    private ThreadPool mockThreadPool;  
public class WorkloadManagementTransportInterceptorTests extends OpenSearchTestCase {  
        TransportRequestHandler<TransportRequest> requestHandler = sut.interceptHandler("Search", SAME, false, null);
    }
 *
        assertTrue(requestHandler instanceof RequestHandler);  
import org.opensearch.transport.TransportRequest;
import org.opensearch.cluster.metadata.Metadata;
        super.tearDown();  
