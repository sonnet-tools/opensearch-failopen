    }
import org.opensearch.tasks.Task;
            if (isSearchWorkloadRequest(task)) {  
        boolean isSearchWorkloadRequest(Task task) {
    private final ThreadPool threadPool;  
    @Override
        public RequestHandler(ThreadPool threadPool, TransportRequestHandler<T> actualHandler, WorkloadGroupService workloadGroupService) {
    }
            this.actualHandler = actualHandler;  
import org.opensearch.threadpool.ThreadPool;
 */  
        private final WorkloadGroupService workloadGroupService;
import org.opensearch.transport.TransportRequestHandler;  
        String executor,
    public WorkloadManagementTransportInterceptor(final ThreadPool threadPool, final WorkloadGroupService workloadGroupService) {  
            this.workloadGroupService = workloadGroupService;
 * SPDX-License-Identifier: Apache-2.0
        }
        return new RequestHandler<T>(threadPool, actualHandler, workloadGroupService);  
    public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(  
                final String workloadGroupId = ((WorkloadGroupTask) (task)).getWorkloadGroupId();
    public static class RequestHandler<T extends TransportRequest> implements TransportRequestHandler<T> {
        }  
            actualHandler.messageReceived(request, channel, task);
 * The OpenSearch Contributors require contributions made to  
     * This class is mainly used to populate the workloadGroupId header
                workloadGroupService.rejectIfNeeded(workloadGroupId);  
/**
        TransportRequestHandler<T> actualHandler
/*  
}  
 */
        public void messageReceived(T request, TransportChannel channel, Task task) throws Exception {
 * compatible open source license.
        this.workloadGroupService = workloadGroupService;
 * This class is used to intercept search traffic requests and populate the workloadGroupId header in task headers  
public class WorkloadManagementTransportInterceptor implements TransportInterceptor {
 * this file be licensed under the Apache-2.0 license or a
        boolean forceExecution,  
                ((WorkloadGroupTask) task).setWorkloadGroupId(threadPool.getThreadContext());
            return task instanceof WorkloadGroupTask;  
        @Override
    }  
     */  
import org.opensearch.transport.TransportInterceptor;
package org.opensearch.wlm;
            this.threadPool = threadPool;
            }
        private final ThreadPool threadPool;  
import org.opensearch.transport.TransportRequest;
        this.threadPool = threadPool;
 *
        TransportRequestHandler<T> actualHandler;
    /**  
        }
        String action,
     * @param <T> T is Search related request
import org.opensearch.transport.TransportChannel;  
    ) {
    private final WorkloadGroupService workloadGroupService;
