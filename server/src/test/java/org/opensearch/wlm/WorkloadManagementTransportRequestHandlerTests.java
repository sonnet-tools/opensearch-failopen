        WorkloadGroupTask spyTask = getSpyTask();  
        }
        super.setUp();
    public void testMessageReceivedForNonSearchWorkload() throws Exception {  
        ShardSearchRequest request = mock(ShardSearchRequest.class);  
    private static class TestTransportRequestHandler<T extends TransportRequest> implements TransportRequestHandler<T> {
        actualHandler = new TestTransportRequestHandler<>();  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
import static org.mockito.Mockito.doThrow;
        assertFalse(sut.isSearchWorkloadRequest(task));
        sut.messageReceived(request, mock(TransportChannel.class), spyTask);  
        doNothing().when(workloadGroupService).rejectIfNeeded(anyString());
        return spy(task);
import org.opensearch.action.index.IndexRequest;
public class WorkloadManagementTransportRequestHandlerTests extends OpenSearchTestCase {
    }
        int invokeCount = 0;  
        sut = new WorkloadManagementTransportInterceptor.RequestHandler<>(threadPool, actualHandler, workloadGroupService);  
/*  
import org.opensearch.transport.TransportRequestHandler;
        assertTrue(sut.isSearchWorkloadRequest(spyTask));
        workloadGroupService = mock(WorkloadGroupService.class);
    private TestTransportRequestHandler<TransportRequest> actualHandler;
        public void messageReceived(TransportRequest request, TransportChannel channel, Task task) throws Exception {  
    }  
import org.opensearch.test.OpenSearchTestCase;
    }
    }  
    public void setUp() throws Exception {  
 * this file be licensed under the Apache-2.0 license or a
    public void tearDown() throws Exception {  
            invokeCount += 1;
import org.opensearch.search.internal.ShardSearchRequest;  
    private static WorkloadGroupTask getSpyTask() {
        assertThrows(OpenSearchRejectedExecutionException.class, () -> sut.messageReceived(request, mock(TransportChannel.class), spyTask));  
        ShardSearchRequest request = mock(ShardSearchRequest.class);
import java.util.Collections;  
 * The OpenSearch Contributors require contributions made to  
        threadPool.shutdown();
 *
import static org.mockito.Mockito.spy;  
    private WorkloadGroupService workloadGroupService;
        assertEquals(1, actualHandler.invokeCount);
import org.opensearch.threadpool.ThreadPool;
    }  
    public void testMessageReceivedForSearchWorkload_nonRejectionCase() throws Exception {
import org.opensearch.transport.TransportRequest;  
        super.tearDown();
import static org.mockito.Mockito.anyString;
import org.opensearch.threadpool.TestThreadPool;  
        doThrow(OpenSearchRejectedExecutionException.class).when(workloadGroupService).rejectIfNeeded(anyString());
    private WorkloadManagementTransportInterceptor.RequestHandler<TransportRequest> sut;  
        @Override
 * compatible open source license.
        WorkloadGroupTask spyTask = getSpyTask();
import static org.mockito.Mockito.mock;
}
import org.opensearch.tasks.Task;
import org.opensearch.transport.TransportChannel;
import static org.mockito.Mockito.doNothing;  
        Task task = mock(Task.class);
 */  
    private ThreadPool threadPool;
        final WorkloadGroupTask task = new WorkloadGroupTask(123, "transport", "Search", "test task", null, Collections.emptyMap());  
 * SPDX-License-Identifier: Apache-2.0
    }
        IndexRequest indexRequest = mock(IndexRequest.class);
    public void testMessageReceivedForSearchWorkload_RejectionCase() throws Exception {
package org.opensearch.wlm;
        sut.messageReceived(indexRequest, mock(TransportChannel.class), task);  
        threadPool = new TestThreadPool(getTestName());
    };  
