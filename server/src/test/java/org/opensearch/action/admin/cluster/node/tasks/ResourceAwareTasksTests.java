            }
            requestName = in.readString();  
                    if (blockForCancellation) {
            assertNotNull(taskInfo.getResourceStats());  
            long actualTaskMemoryOverhead = task.getTotalResourceStats().getMemoryInBytes();
        taskTestContext.operationFinishedValidator = (task, threadId) -> { assertEquals(0, resourceTasks.size()); };  
        ResourceAwareNodesAction(
            long expectedArrayAllocationOverhead = 4000000; // Task's memory overhead due to array allocations
        assertNull(throwableReference.get());
            assertEquals(1, task.getThreadUsage().getThreadExecutions());
    public void testOnDemandRefreshWhileGetTask() throws InterruptedException {  
            long actualTaskMemoryOverhead = task.getTotalResourceStats().getMemoryInBytes();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.TransportService;  
                public boolean shouldCancelChildrenOnCancellation() {
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
            assertFalse(task.getResourceStats().get(threadId).get(0).isActive());  
        taskTestContext.requestCompleteLatch = new CountDownLatch(1);  
                                fail("It should have thrown an exception");
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();  
        taskTestContext.requestCompleteLatch.await();
        // because stopTracking is called asynchronously via the task's resource tracking completion listener.
            }  
                }  
            testNodes[0].taskResourceTrackingService.setTaskResourceTrackingEnabled(true);
            assertCPUTime(taskResourceUsage.getCpuTimeInNanos());
    class ResourceAwareNodesAction extends AbstractTestNodesAction<NodesRequest, ResourceAwareNodeRequest> {  
            assertEquals(1, resourceTasks.size());  
        taskTestContext.requestCompleteLatch.await();  
        taskTestContext.requestCompleteLatch.await();
            @Override
            @Override  
    }
        setup(true, false);
            this.blockForCancellation = shouldBlock;
        taskTestContext.requestCompleteLatch.await();
        return throwable;
            @Override  
                @Override
import org.opensearch.action.support.nodes.BaseNodesRequest;
            public void onTaskRegistered(Task task) {}
            );
        private NodesRequest(StreamInput in) throws IOException {
        // It is possible for the MockTaskManagerListener to be called after the response is sent already.
            .put(MockTaskManager.USE_MOCK_TASK_MANAGER_SETTING.getKey(), useMockTaskManager)  
import java.util.function.BiConsumer;
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
                taskTestContext.requestCompleteLatch.countDown();
            assertEquals(1, task.getResourceStats().get(threadId).size());
                    taskIdsAddedToThreadContext.add(task.getId());  
            assertTrue(taskResourceUsage.getMemoryInBytes() > 0);
            long expectedArrayAllocationOverhead = 2 * 4000000; // Task's memory overhead due to array allocations
                            protected void innerOnFailure(Exception e) {
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
                        }  
        TaskTestContext taskTestContext = new TaskTestContext();  
            @Override  
                        taskTestContext.operationStartValidator.accept(task, threadId.get());
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(task.getTotalResourceStats().getCpuTimeInNanos(), task.getAverageResourceStats().getCpuTimeInNanos());
import org.opensearch.threadpool.ThreadPool;
        taskTestContext.operationStartValidator = (task, threadId) -> {
        TaskTestContext taskTestContext,
                }
    public static class ResourceAwareNodeRequest extends TransportRequest {  
            super();
     * Simulates a task which executes work on search executor.
            @Override
                    // operationFinishedValidator will be called just after all task threads are marked inactive and
        }
        Map<Long, Task> resourceTasks = testNodes[0].taskResourceTrackingService.getResourceAwareTasks();
        // Waiting for whole request to complete and return successfully till client
        taskTestContext.operationFinishedValidator = (task, threadId) -> { assertEquals(0, resourceTasks.size()); };
                taskTestContext.requestCompleteLatch.countDown();  
            long taskCancellationOverhead = 30000; // Task cancellation overhead ~ 30Kb  
                                taskTestContext.operationFinishedValidator.accept(task, threadId.get());
                taskTestContext.requestCompleteLatch.countDown();  
            assertEquals(1, task.getResourceStats().size());  
import java.util.Map;  
import org.opensearch.ExceptionsHelper;
            assertEquals(1, task.getResourceStats().get(threadId).size());
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;  
            assertEquals(0, task.getTotalResourceStats().getMemoryInBytes());
        private final TaskTestContext taskTestContext;
                taskTestContext.requestCompleteLatch.countDown();
            @Override
            assertCPUTime(taskResourceUsage.getCpuTimeInNanos());
                    taskIdsRemovedFromThreadContext.add(task.getId());
                    );
                        if (success == false) {
        // Wait enough time for taskId to be added to taskIdsRemovedFromThreadContext before performing validations.
            @Override
            public void onResponse(NodesResponse listTasksResponse) {
        private long memoryConsumptionWhenExecutionStarts;
    }
        private Task mainTask;  
            TaskInfo taskInfo = getTaskResponse.getTask().getTask();
            ListTasksResponse listTasksResponse = ActionTestUtils.executeBlocking(
    private static final ThreadMXBean threadMXBean = (ThreadMXBean) ManagementFactory.getThreadMXBean();
    }  
            }  
import static org.hamcrest.Matchers.containsInAnyOrder;
            }
            }
            assertEquals(0, task.getAverageResourceStats().getCpuTimeInNanos());
        public void writeTo(StreamOutput out) throws IOException {  
            assertEquals(task.getTotalResourceStats().getMemoryInBytes(), task.getMaxResourceStats().getMemoryInBytes());  
        final List<Long> taskIdsRemovedFromThreadContext = new ArrayList<>();
        taskTestContext.operationStartValidator = (task, threadId) -> { assertEquals(0, resourceTasks.size()); };
                                throw new TaskCancelledException("Task Cancelled");
        setupTestNodes(settings);
                            protected void innerOnResponse(Task task) {  
                taskTestContext.requestCompleteLatch.countDown();  
                    return false;
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
                            if (taskCancelled) {
            assertEquals(1, task.getResourceStats().get(threadId).size());
        }
            assertEquals(0, task.getTotalResourceStats().getMemoryInBytes());  
            @Override
        assertTasksRequestFinishedSuccessfully(responseReference.get(), throwableReference.get());  
                actualTaskMemoryOverhead - taskTestContext.memoryConsumptionWhenExecutionStarts,  
                    Object[] allocation1 = new Object[1000000]; // 4MB  
import org.opensearch.core.action.ActionListener;
        private final boolean blockForCancellation;
import java.lang.management.ManagementFactory;  
                    ExceptionsHelper.reThrowIfNotNull(e);  
            testNodes[0].taskResourceTrackingService.setTaskResourceTrackingEnabled(false);
        private final String requestName;
                }
                }
                        }
import java.io.IOException;
            assertMemoryUsageWithinLimits(
        // Cancel main task
            assertEquals(1, task.getThreadUsage().getActiveThreads());
        };
        TestNode node,
        @Override
        ResourceAwareNodesAction action = new ResourceAwareNodesAction(
                }
            }
            @Override  
            super(in);
        TaskTestContext taskTestContext = new TaskTestContext();  
        assertTasksRequestFinishedSuccessfully(responseReference.get(), throwableReference.get());  
        };  
    private void setup(boolean resourceTrackingEnabled, boolean useMockTaskManager) {  
        assertNotNull(responseReference.get());
        };
            assertNotNull(taskInfo.getResourceStats().getResourceUsageInfo());
                new ListTasksRequest().setActions("internal:resourceAction*").setDetailed(true)
            return new CancellableTask(id, type, action, getDescription(), parentTaskId, headers) {  
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
            super.writeTo(out);
            public void onFailure(Exception e) {
        // Windows registers a cpu tick at a default of ~15ms which is slightly slower than other OSs.
            @Override
        startResourceAwareNodesAction(testNodes[0], true, taskTestContext, new ActionListener<NodesResponse>() {
            }
        TaskTestContext taskTestContext = new TaskTestContext();
            assertEquals(1, task.getThreadUsage().getThreadExecutions());  
        };  
            }  
            }
                        // Using periodic checks method to identify that the task was cancelled
                    expectedTaskIdInThreadContext.set(task.getId());
import java.util.concurrent.TimeUnit;
                    threadId.set(Thread.currentThread().threadId());  
            assertCPUTime(task.getTotalResourceStats().getCpuTimeInNanos());
            assertTrue("Cpu should be non negative on windows", cpuTimeInNanos >= 0);  
            public void onFailure(Exception e) {
                    Object[] allocation2 = new Object[1000000]; // 4MB  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            @Override
        ) {
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;
                result.get();
            }
import org.opensearch.core.tasks.TaskCancelledException;
 *
    public void testBasicTaskResourceTracking() throws Exception {
            return new CancellableTask(id, type, action, getDescription(), parentTaskId, headers) {
/*  
        private CountDownLatch requestCompleteLatch;
        assertTasksRequestFinishedSuccessfully(responseReference.get(), throwableReference.get());
            assertEquals(0, task.getMaxResourceStats().getMemoryInBytes());
            }
        taskTestContext.operationFinishedValidator = (task, threadId) -> { assertEquals(0, resourceTasks.size()); };
        }
            assertEquals(0, task.getThreadUsage().getActiveThreads());
            // In basic single threaded case min == max == average == total  
        }  
        taskTestContext.requestCompleteLatch.await();
                            }
import org.opensearch.cluster.service.ClusterService;  
    }
                responseReference.set(listTasksResponse);  
                throwableReference.set(e);  
    }
            // Thread has finished working on the task's runnable
            @Override
    public void testTaskResourceTrackingDisabled() throws Exception {
        taskTestContext.operationStartValidator = (task, threadId) -> {
import org.apache.lucene.util.Constants;  
        // The work done within the runnable in this test often completes in under that time and returns a 0 value from  
            assertEquals(0, task.getTotalResourceStats().getCpuTimeInNanos());
                if (closeableInvoked) {  
                    // operationStartValidator will be called just before the task execution.
            assertFalse(task.getResourceStats().get(threadId).get(0).isActive());
import org.opensearch.transport.TransportRequest;
        startResourceAwareNodesAction(testNodes[0], false, taskTestContext, new ActionListener<NodesResponse>() {
        });
        protected ResourceAwareNodeRequest newNodeRequest(NodesRequest request) {  
    }
            assertFalse(task.getResourceStats().get(threadId).get(0).isActive());  
            assertTrue(task.getResourceStats().get(threadId).get(0).isActive());  
                        } catch (InterruptedException ex) {  
                        });
                taskTestContext.requestCompleteLatch.countDown();
        taskTestContext.operationStartValidator = (task, threadId) -> {
    }
}
            boolean shouldBlock,  
        }  
        assertBusy(() -> assertEquals(0, resourceTasks.size()));  
        }  
        @Override
        });
            long expectedArrayAllocationOverhead = 2 * 4000000; // Task's memory overhead due to array allocations
import java.util.ArrayList;
            out.writeString(requestName);
            return "NodesRequest[" + requestName + "]";
        AtomicLong actualTaskIdInThreadContext = new AtomicLong(-1);  
        public ResourceAwareNodeRequest(NodesRequest request) {  
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();  
                throwableReference.set(e);
            assertEquals(0, task.getTotalResourceStats().getCpuTimeInNanos());
        }
            TaskResourceUsage taskResourceUsage = taskInfo.getResourceStats().getResourceUsageInfo().get("total");
        taskTestContext.operationStartValidator = (task, threadId) -> {
        private BiConsumer<Task, Long> operationStartValidator;
        startResourceAwareNodesAction(testNodes[0], false, taskTestContext, new ActionListener<NodesResponse>() {
import org.opensearch.tasks.TaskInfo;
                public boolean shouldCancelChildrenOnCancellation() {
        }  
        Settings settings = Settings.builder()
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
    public void testTaskResourceTrackingEnabledWhileTaskInProgress() throws Exception {
                        Thread.currentThread().threadId()
        // Waiting for whole request to complete and return successfully till client
            GetTaskResponse getTaskResponse = ActionTestUtils.executeBlocking(  
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
        protected NodeResponse nodeOperation(ResourceAwareNodeRequest request, Task task) {
    public void testTaskIdPersistsInThreadContext() throws InterruptedException {
    private void assertCPUTime(long cpuTimeInNanos) {
                            @Override
            assertEquals(task.getTotalResourceStats().getMemoryInBytes(), task.getMinResourceStats().getMemoryInBytes());
            assertTrue("Cpu should have a positive value", cpuTimeInNanos > 0);
        setup(true, false);  
            String actionName,
        private BiConsumer<Task, Long> operationFinishedValidator;  
        assertNull(throwable);
        boolean blockForCancellation,  
        request.setTaskId(new TaskId(testNodes[0].getNodeId(), taskTestContext.mainTask.getId()));
            assertEquals(1, resourceTasks.size());  
                } else {
        final List<Long> taskIdsAddedToThreadContext = new ArrayList<>();
            public void onTaskUnregistered(Task task) {
            public void taskExecutionStarted(Task task, Boolean closeableInvoked) {
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();  
            assertEquals(task.getTotalResourceStats().getMemoryInBytes(), task.getAverageResourceStats().getMemoryInBytes());
        };
        public String getDescription() {
        @Override  
                taskTestContext.requestCompleteLatch.countDown();
                protected void doRun() {
        } else {
            assertMemoryUsageWithinLimits(
            @Override
        });
                responseReference.set(listTasksResponse);
    public void testOnDemandRefreshWhileFetchingTasks() throws InterruptedException {  
        @Override
    private void assertMemoryUsageWithinLimits(long actual, long expected) {
            public void onFailure(Exception e) {  
            assertEquals(1, task.getResourceStats().size());
                @Override
                testNodes[0].transportGetTaskAction,
    private static class TaskTestContext {
                taskTestContext.requestCompleteLatch.countDown();
        TaskTestContext taskTestContext = new TaskTestContext();  
        }
        connectNodes(testNodes[0]);  
            out.writeString(requestName);
            // One thread is currently working on task but not finished
            }
            assertEquals(0, task.getTotalResourceStats().getCpuTimeInNanos());
        };
                            @Override
            TaskTestContext taskTestContext
                throwableReference.set(e);
        }
        Map<Long, Task> resourceTasks = testNodes[0].taskResourceTrackingService.getResourceAwareTasks();  
        @Override
        Map<Long, Task> resourceTasks = testNodes[0].taskResourceTrackingService.getResourceAwareTasks();  
        ((MockTaskManager) testNodes[0].transportService.getTaskManager()).addListener(new MockTaskManagerListener() {  
        assertTasksRequestFinishedSuccessfully(responseReference.get(), throwableReference.get());
                taskTestContext.requestCompleteLatch.countDown();
        startResourceAwareNodesAction(testNodes[0], false, taskTestContext, new ActionListener<NodesResponse>() {  
    public void testTaskResourceTrackingDuringTaskCancellation() throws Exception {
        setup(true, false);
                            Thread.currentThread().interrupt();
import java.util.List;
        return taskTestContext;
    }
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
            }
        taskTestContext.requestCompleteLatch.await();  
                expectedArrayAllocationOverhead  
import org.opensearch.test.tasks.MockTaskManagerListener;  
import org.opensearch.tasks.Task;  
            blockForCancellation,
                    }
        @Override
        startResourceAwareNodesAction(testNodes[0], false, taskTestContext, new ActionListener<NodesResponse>() {  
            public void onFailure(Exception e) {
        });  
        taskTestContext.operationFinishedValidator = (task, threadId) -> {
        });
        assertNotNull(nodesResponse);  
import java.util.concurrent.ExecutionException;
        @Override
                    actualTaskIdInThreadContext.set(threadPool.getThreadContext().getTransient(TASK_ID));
        @Override
        }
        taskTestContext.requestCompleteLatch.await();
        assertTasksRequestFinishedSuccessfully(responseReference.get(), throwableReference.get());
            return new ResourceAwareNodeRequest(request);
                throwableReference.set(e);
            public void onFailure(Exception e) {  
            assertEquals(1, task.getResourceStats().size());
            long actualTaskMemoryOverhead = task.getTotalResourceStats().getMemoryInBytes();  
public class ResourceAwareTasksTests extends TaskManagerTestCase {
    }
        if (Constants.WINDOWS) {
    }
            public void onFailure(Exception e) {
            assertCPUTime(task.getTotalResourceStats().getCpuTimeInNanos());
        runnableTaskListener.set(testNodes[0].taskResourceTrackingService);
import org.opensearch.tasks.CancellableTask;
            assertEquals(0, task.getTotalResourceStats().getMemoryInBytes());
                }
            public void onFailure(Exception e) {
            AtomicLong threadId = new AtomicLong();
            assertEquals(1, task.getResourceStats().get(threadId).size());  
        assertEquals(0, nodesResponse.failureCount());
            assertEquals(0, task.getMinResourceStats().getMemoryInBytes());
                                ExceptionsHelper.reThrowIfNotNull(e);  
    }
        }  
            assertEquals(0, resourceTasks.size());
                    }
                taskTestContext.requestCompleteLatch.countDown();  
            }
            }
        assertEquals(expectedTaskIdInThreadContext.get(), actualTaskIdInThreadContext.get());
            // One thread is currently working on task but not finished  
                taskTestContext.requestCompleteLatch.countDown();  
        };  
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskResponse;
        Map<Long, Task> resourceTasks = testNodes[0].taskResourceTrackingService.getResourceAwareTasks();
        public void writeTo(StreamOutput out) throws IOException {
            assertNotNull(taskInfo.getResourceStats().getResourceUsageInfo().get("total"));
            TaskResourceUsage taskResourceUsage = taskInfo.getResourceStats().getResourceUsageInfo().get("total");  
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
import java.util.concurrent.atomic.AtomicReference;  
import java.util.concurrent.atomic.AtomicLong;
            this.requestName = requestName;
        startResourceAwareNodesAction(testNodes[0], false, taskTestContext, new ActionListener<NodesResponse>() {
        assertEquals(1, responseReference.get().failureCount());  
            return new NodeResponse(clusterService.localNode());
        waitUntil(() -> taskIdsAddedToThreadContext.size() == taskIdsRemovedFromThreadContext.size(), 5, TimeUnit.SECONDS);  
            super(in);
                    // the task is unregistered.
            assertTrue(task.getResourceStats().get(threadId).get(0).isActive());  
                throwableReference.set(e);
        });  
            assertNotNull(taskInfo.getResourceStats().getResourceUsageInfo());
            );
import java.util.concurrent.Future;  
        long maxOverhead = Math.min(500000, expected * 5 / 100);  
            });
                taskTestContext.requestCompleteLatch.countDown();
            TransportService transportService,
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
        assertEquals(TaskCancelledException.class, findActualException(responseReference.get().failures().get(0)).getClass());
        }
        taskTestContext.operationStartValidator = (task, threadId) -> {
                taskTestContext.requestCompleteLatch.countDown();
            public void onResponse(NodesResponse listTasksResponse) {
                responseReference.set(listTasksResponse);
            assertFalse(resourceTasks.isEmpty());
            public void onResponse(NodesResponse listTasksResponse) {  
        setup(true, false);
            throw new UnsupportedOperationException("the task parameter is required");  
        public ResourceAwareNodeRequest(StreamInput in) throws IOException {
import org.opensearch.common.util.concurrent.AbstractRunnable;  
            requestName = in.readString();  
                throwableReference.set(e);
            public void onResponse(NodesResponse listTasksResponse) {
            assertEquals(1, task.getResourceStats().get(threadId).size());
            TaskInfo taskInfo = listTasksResponse.getTasks().get(1);
    ) {  
            assertEquals(1, task.getResourceStats().size());
            throwable = throwable.getCause();
    /**  
                public boolean supportsResourceTracking() {  
            assertEquals(task.getTotalResourceStats().getCpuTimeInNanos(), task.getMaxResourceStats().getCpuTimeInNanos());  
        TaskTestContext taskTestContext = new TaskTestContext();  
            assertEquals(0, resourceTasks.size());  
@SuppressForbidden(reason = "ThreadMXBean#getThreadAllocatedBytes")
            super.writeTo(out);  
    }  
            assertEquals(1, task.getResourceStats().size());
    }  
                responseReference.set(listTasksResponse);  
                taskTestContext.requestCompleteLatch.countDown();  
                @Override  
                    if (taskTestContext.operationStartValidator != null) {  
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskRequest;  
        }
        );  
        taskTestContext.operationStartValidator = (task, threadId) -> {
            );  
            assertTrue(task.getResourceStats().get(threadId).get(0).isActive());
            @Override
                            fail("failed to register a completion listener as task resource tracking has already completed");
        taskTestContext.mainTask = action.execute(request, listener);
 * this file be licensed under the Apache-2.0 license or a
            node.clusterService,
    }
        // 5% buffer up to 500 KB to account for classloading overhead.
        };
import org.opensearch.common.settings.Settings;
            super(actionName, threadPool, clusterService, transportService, NodesRequest::new, ResourceAwareNodeRequest::new);  
    public void testTaskResourceTrackingDisabledWhileTaskInProgress() throws Exception {
            ThreadPool threadPool,  
            assertEquals(0, task.getMinResourceStats().getCpuTimeInNanos());  
package org.opensearch.action.admin.cluster.node.tasks;
                expectedOverhead  
            @Override  
        ActionListener<NodesResponse> listener
            public void onFailure(Exception e) {  
            taskTestContext
        public String getDescription() {  
        setup(false, false);
                }  
        @Override
                public void onFailure(Exception e) {
            // Thread has finished working on the task's runnable
        taskTestContext.operationFinishedValidator = (task, threadId) -> {
        // Waiting for whole request to complete and return successfully till client
            } catch (InterruptedException | ExecutionException e) {  
            public void onResponse(NodesResponse listTasksResponse) {
            return "ResourceAwareNodeRequest[" + requestName + "]";  
            assertEquals(task.getTotalResourceStats().getCpuTimeInNanos(), task.getMinResourceStats().getCpuTimeInNanos());
import org.opensearch.action.support.ActionTestUtils;
            };
            assertNotNull(taskInfo.getResourceStats());
            public void onResponse(NodesResponse listTasksResponse) {  
    private Throwable findActualException(Exception e) {
            assertTrue(taskResourceUsage.getMemoryInBytes() > 0);  
            .build();
                @Override  
                expectedArrayAllocationOverhead
        setup(false, false);  
            requestName = request.requestName;
        // ThreadMXBean.getThreadCpuTime. To reduce flakiness in this test accept 0 as a value on Windows.
        assertThat(taskIdsAddedToThreadContext, containsInAnyOrder(taskIdsRemovedFromThreadContext.toArray()));  
                throwableReference.set(e);  
            assertNotNull(taskInfo.getResourceStats().getResourceUsageInfo().get("total"));  
            // allocations are completed before the task is cancelled
            .put("task_resource_tracking.enabled", resourceTrackingEnabled)
                testNodes[0].transportListTasksAction,  
     */
        protected NodeResponse nodeOperation(ResourceAwareNodeRequest request) {
                new GetTaskRequest().setTaskId(new TaskId(testNodes[0].getNodeId(), new ArrayList<>(resourceTasks.values()).get(0).getId()))
        protected String requestName;
            node.transportService,  
                if (task.getAction().equals("internal:resourceAction[n]")) {  
        startResourceAwareNodesAction(testNodes[0], false, taskTestContext, new ActionListener<NodesResponse>() {
            public void onResponse(NodesResponse listTasksResponse) {
            @Override  
            try {
        }
                @SuppressForbidden(reason = "ThreadMXBean#getThreadAllocatedBytes")
                taskTestContext.requestCompleteLatch.countDown();
import org.opensearch.core.action.NotifyOnceListener;
        // Waiting for whole request to complete and return successfully till client
        TaskTestContext taskTestContext = new TaskTestContext();
            }
            assertEquals(0, task.getMaxResourceStats().getCpuTimeInNanos());
            assertEquals(1, resourceTasks.size());
        public ResourceAwareNodeRequest() {  
        while (throwable.getCause() != null) {
                actualTaskMemoryOverhead - taskTestContext.memoryConsumptionWhenExecutionStarts,
            this.taskTestContext = taskTestContext;
    private void assertTasksRequestFinishedSuccessfully(NodesResponse nodesResponse, Throwable throwable) {
        // Waiting for whole request to complete and return successfully till client  
        request.setReason("Cancelling request to verify Task resource tracking behaviour");  
        TaskTestContext taskTestContext = new TaskTestContext();
                        // Simulate a job that takes forever to finish  
            assertEquals(1, task.getResourceStats().get(threadId).size());
        Throwable throwable = e.getCause();  
            assertEquals(0, resourceTasks.size());  
            assert task.supportsResourceTracking();  
        // Waiting for whole request to complete and return successfully till client  
        }
                            }
    }  
                @Override
        };
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
        assertTasksRequestFinishedSuccessfully(responseReference.get(), throwableReference.get());
                    return true;  
        setup(true, false);
        assertThat(actual, lessThanOrEqualTo(expected + maxOverhead));
                            boolean taskCancelled = waitUntil(((CancellableTask) task)::isCancelled);  
            assertEquals(0, resourceTasks.size());  
            "internal:resourceAction",  
                            } else {  
            long expectedOverhead = expectedArrayAllocationOverhead + taskCancellationOverhead;  
        taskTestContext.operationFinishedValidator = (task, threadId) -> {  
            threadPool,
            ClusterService clusterService,
    public static class NodesRequest extends BaseNodesRequest<NodesRequest> {
import org.opensearch.common.SuppressForbidden;
                taskTestContext.requestCompleteLatch.countDown();
            // One thread is currently working on task but not finished
        Map<Long, Task> resourceTasks = testNodes[0].taskResourceTrackingService.getResourceAwareTasks();
import org.opensearch.core.common.io.stream.StreamInput;  
            );
            assertCPUTime(task.getTotalResourceStats().getCpuTimeInNanos());  
                    taskTestContext.memoryConsumptionWhenExecutionStarts = threadMXBean.getThreadAllocatedBytes(  
        });  
        // The task may not be removed from resourceAwareTasks immediately after the request completes
        setup(true, true);
            Future<?> result = threadPool.executor(ThreadPool.Names.SEARCH).submit(new AbstractRunnable() {  
                        boolean success = task.addResourceTrackingCompletionListener(new NotifyOnceListener<>() {
import org.opensearch.core.tasks.TaskId;  
        Map<Long, Task> resourceTasks = testNodes[0].taskResourceTrackingService.getResourceAwareTasks();
import org.opensearch.core.common.io.stream.StreamOutput;
        // Waiting for whole request to complete and return successfully till client
            @Override
 * compatible open source license.
                    }
                responseReference.set(listTasksResponse);
            }  
    }
                            }
        AtomicLong expectedTaskIdInThreadContext = new AtomicLong(-2);
import org.opensearch.test.tasks.MockTaskManager;
            }
        ActionTestUtils.executeBlocking(testNodes[0].transportCancelTasksAction, request);
        CancelTasksRequest request = new CancelTasksRequest();
        public NodesRequest(String requestName, String... nodesIds) {  
                    return true;
import com.sun.management.ThreadMXBean;
            );
            };  
        taskTestContext.operationFinishedValidator = (task, threadId) -> { assertEquals(0, resourceTasks.size()); };  
                throw new RuntimeException(e.getCause());
            @Override
            public void onResponse(NodesResponse listTasksResponse) {
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
            assertEquals(0, task.getAverageResourceStats().getMemoryInBytes());  
            }  
        NodesRequest request = new NodesRequest("Test Request", node.getNodeId());
    }
        });
import static org.opensearch.tasks.TaskResourceTrackingService.TASK_ID;  
        });
        }  
    }
import java.util.concurrent.CountDownLatch;
            public void waitForTaskCompletion(Task task) {}
                actualTaskMemoryOverhead - taskTestContext.memoryConsumptionWhenExecutionStarts,
                        try {
        startResourceAwareNodesAction(testNodes[0], false, taskTestContext, new ActionListener<NodesResponse>() {
                    if (taskTestContext.operationFinishedValidator != null) {  
            super(nodesIds);
 */  
            @Override  
    private TaskTestContext startResourceAwareNodesAction(
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
        Map<Long, Task> resourceTasks = testNodes[0].taskResourceTrackingService.getResourceAwareTasks();
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
            assertEquals(1, task.getResourceStats().size());
                responseReference.set(listTasksResponse);
                responseReference.set(listTasksResponse);
            @Override
            assertMemoryUsageWithinLimits(
        taskTestContext.requestCompleteLatch.await();
            // Thread has finished working on the task's runnable
        TaskTestContext taskTestContext = new TaskTestContext();  
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();  
