            public void onResponse(NodesResponse listTasksResponse) {
        taskTestContext.operationFinishedValidator = (task, threadId) -> { assertEquals(0, resourceTasks.size()); };
                            }
    public void testOnDemandRefreshWhileFetchingTasks() throws InterruptedException {
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
            } catch (InterruptedException | ExecutionException e) {
            // One thread is currently working on task but not finished
        boolean blockForCancellation,
        public void writeTo(StreamOutput out) throws IOException {
            public void onFailure(Exception e) {
            @Override
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
            assertEquals(0, task.getTotalResourceStats().getCpuTimeInNanos());
        }
import org.opensearch.cluster.service.ClusterService;
            assertEquals(1, task.getResourceStats().size());
        taskTestContext.requestCompleteLatch.await();
                    Object[] allocation1 = new Object[1000000]; // 4MB
        request.setTaskId(new TaskId(testNodes[0].getNodeId(), taskTestContext.mainTask.getId()));
                        boolean success = task.addResourceTrackingCompletionListener(new NotifyOnceListener<>() {
            AtomicLong threadId = new AtomicLong();
        taskTestContext.requestCompleteLatch.await();
    private void setup(boolean resourceTrackingEnabled, boolean useMockTaskManager) {
import org.opensearch.test.tasks.MockTaskManagerListener;
                taskTestContext.requestCompleteLatch.countDown();
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
                throwableReference.set(e);
 * The OpenSearch Contributors require contributions made to
                @Override
                taskTestContext.requestCompleteLatch.countDown();
        // ThreadMXBean.getThreadCpuTime. To reduce flakiness in this test accept 0 as a value on Windows.
        Map<Long, Task> resourceTasks = testNodes[0].taskResourceTrackingService.getResourceAwareTasks();
                taskTestContext.requestCompleteLatch.countDown();
        private CountDownLatch requestCompleteLatch;
            super();
            taskTestContext
            @Override
            assertEquals(0, resourceTasks.size());
            assertEquals(task.getTotalResourceStats().getMemoryInBytes(), task.getMaxResourceStats().getMemoryInBytes());
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
            }
                throw new RuntimeException(e.getCause());
        Map<Long, Task> resourceTasks = testNodes[0].taskResourceTrackingService.getResourceAwareTasks();
            }
 * compatible open source license.
        startResourceAwareNodesAction(testNodes[0], false, taskTestContext, new ActionListener<NodesResponse>() {
        private final String requestName;
            assertFalse(task.getResourceStats().get(threadId).get(0).isActive());
        private final TaskTestContext taskTestContext;
            }
            testNodes[0].taskResourceTrackingService.setTaskResourceTrackingEnabled(false);
            TaskInfo taskInfo = listTasksResponse.getTasks().get(1);
        if (Constants.WINDOWS) {
            assertEquals(task.getTotalResourceStats().getCpuTimeInNanos(), task.getMaxResourceStats().getCpuTimeInNanos());
        request.setReason("Cancelling request to verify Task resource tracking behaviour");
            return new ResourceAwareNodeRequest(request);
            }
    }
                taskTestContext.requestCompleteLatch.countDown();
                taskTestContext.requestCompleteLatch.countDown();
                if (task.getAction().equals("internal:resourceAction[n]")) {
                    // operationStartValidator will be called just before the task execution.
            super.writeTo(out);
        // because stopTracking is called asynchronously via the task's resource tracking completion listener.
    public void testTaskResourceTrackingDuringTaskCancellation() throws Exception {
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
            .put(MockTaskManager.USE_MOCK_TASK_MANAGER_SETTING.getKey(), useMockTaskManager)
        Map<Long, Task> resourceTasks = testNodes[0].taskResourceTrackingService.getResourceAwareTasks();
        };
        };
    }
    }
                            Thread.currentThread().interrupt();
        taskTestContext.requestCompleteLatch = new CountDownLatch(1);
            this.requestName = requestName;
        };
    public void testOnDemandRefreshWhileGetTask() throws InterruptedException {
            assertNotNull(taskInfo.getResourceStats());
import org.opensearch.action.support.nodes.BaseNodesRequest;
                }
            }
            public void onResponse(NodesResponse listTasksResponse) {
            return "NodesRequest[" + requestName + "]";
                    }
                result.get();
            TaskInfo taskInfo = getTaskResponse.getTask().getTask();
                        if (success == false) {
            @Override
                    );
    private void assertTasksRequestFinishedSuccessfully(NodesResponse nodesResponse, Throwable throwable) {
            return new NodeResponse(clusterService.localNode());
        assertEquals(1, responseReference.get().failureCount());
import java.util.function.BiConsumer;
        setup(false, false);
    class ResourceAwareNodesAction extends AbstractTestNodesAction<NodesRequest, ResourceAwareNodeRequest> {
            assertEquals(0, resourceTasks.size());
        startResourceAwareNodesAction(testNodes[0], false, taskTestContext, new ActionListener<NodesResponse>() {
        taskTestContext.operationFinishedValidator = (task, threadId) -> {
            @Override
        setup(false, false);
                taskTestContext.requestCompleteLatch.countDown();
                    if (taskTestContext.operationFinishedValidator != null) {
        TaskTestContext taskTestContext = new TaskTestContext();
                }
            assertEquals(task.getTotalResourceStats().getMemoryInBytes(), task.getAverageResourceStats().getMemoryInBytes());
            public void onResponse(NodesResponse listTasksResponse) {
        public void writeTo(StreamOutput out) throws IOException {
            long taskCancellationOverhead = 30000; // Task cancellation overhead ~ 30Kb
        }
 */
        }
                actualTaskMemoryOverhead - taskTestContext.memoryConsumptionWhenExecutionStarts,
import java.util.ArrayList;
        assertTasksRequestFinishedSuccessfully(responseReference.get(), throwableReference.get());
                    threadId.set(Thread.currentThread().threadId());
            assertEquals(1, task.getThreadUsage().getActiveThreads());
    }
        });
                if (closeableInvoked) {
                            }
                protected void doRun() {
            assertEquals(1, task.getResourceStats().size());
                taskTestContext.requestCompleteLatch.countDown();
     */
        assertTasksRequestFinishedSuccessfully(responseReference.get(), throwableReference.get());
            public void onResponse(NodesResponse listTasksResponse) {
            public void onTaskRegistered(Task task) {}
import org.opensearch.common.util.concurrent.AbstractRunnable;
            assertCPUTime(task.getTotalResourceStats().getCpuTimeInNanos());
        ResourceAwareNodesAction(
        TestNode node,
            @Override
            out.writeString(requestName);
            // Thread has finished working on the task's runnable
        assertNotNull(responseReference.get());
                taskTestContext.requestCompleteLatch.countDown();
        waitUntil(() -> taskIdsAddedToThreadContext.size() == taskIdsRemovedFromThreadContext.size(), 5, TimeUnit.SECONDS);
            public void onFailure(Exception e) {
            };
import java.util.concurrent.TimeUnit;
        setup(true, false);
                taskTestContext.requestCompleteLatch.countDown();
        protected NodeResponse nodeOperation(ResourceAwareNodeRequest request, Task task) {
    }
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;
        assertNull(throwableReference.get());
        TaskTestContext taskTestContext = new TaskTestContext();
                    }
        ((MockTaskManager) testNodes[0].transportService.getTaskManager()).addListener(new MockTaskManagerListener() {
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
                taskTestContext.requestCompleteLatch.countDown();
                        taskTestContext.operationStartValidator.accept(task, threadId.get());
        ResourceAwareNodesAction action = new ResourceAwareNodesAction(
            super(actionName, threadPool, clusterService, transportService, NodesRequest::new, ResourceAwareNodeRequest::new);
            requestName = in.readString();
            public void onFailure(Exception e) {
        taskTestContext.operationStartValidator = (task, threadId) -> {
        assertEquals(0, nodesResponse.failureCount());
                        }
            assertMemoryUsageWithinLimits(
            out.writeString(requestName);
        @Override
            }
            assertEquals(1, task.getThreadUsage().getThreadExecutions());
            assertEquals(0, task.getTotalResourceStats().getMemoryInBytes());
        });
                            }
        assertTasksRequestFinishedSuccessfully(responseReference.get(), throwableReference.get());
        }
        assertTasksRequestFinishedSuccessfully(responseReference.get(), throwableReference.get());
                        // Simulate a job that takes forever to finish
            @Override
                }
            assertEquals(0, task.getThreadUsage().getActiveThreads());
        assertNull(throwable);
            assertNotNull(taskInfo.getResourceStats().getResourceUsageInfo().get("total"));
import java.util.concurrent.ExecutionException;
        });
import org.opensearch.core.action.NotifyOnceListener;
        private Task mainTask;
            String actionName,
            public void onResponse(NodesResponse listTasksResponse) {
        return throwable;
            throwable = throwable.getCause();
 * SPDX-License-Identifier: Apache-2.0
                        Thread.currentThread().threadId()
        };
                @Override
            return "ResourceAwareNodeRequest[" + requestName + "]";
            }
            assertTrue("Cpu should be non negative on windows", cpuTimeInNanos >= 0);
                throwableReference.set(e);
        startResourceAwareNodesAction(testNodes[0], false, taskTestContext, new ActionListener<NodesResponse>() {
import org.opensearch.core.action.ActionListener;
            @Override
            assertNotNull(taskInfo.getResourceStats().getResourceUsageInfo());
                    return true;
import org.opensearch.core.tasks.TaskCancelledException;
        taskTestContext.operationStartValidator = (task, threadId) -> {
import org.opensearch.transport.TransportRequest;
        Map<Long, Task> resourceTasks = testNodes[0].taskResourceTrackingService.getResourceAwareTasks();
            assertEquals(1, task.getResourceStats().get(threadId).size());
            ThreadPool threadPool,
        @Override
        };
        public ResourceAwareNodeRequest() {
            assertCPUTime(taskResourceUsage.getCpuTimeInNanos());
            }
/*
                        }
        private final boolean blockForCancellation;
                    if (blockForCancellation) {
import org.opensearch.test.tasks.MockTaskManager;
        taskTestContext.operationFinishedValidator = (task, threadId) -> { assertEquals(0, resourceTasks.size()); };
        taskTestContext.operationStartValidator = (task, threadId) -> {
                    taskIdsRemovedFromThreadContext.add(task.getId());
                    Object[] allocation2 = new Object[1000000]; // 4MB
        TaskTestContext taskTestContext = new TaskTestContext();
        public ResourceAwareNodeRequest(StreamInput in) throws IOException {
        }
            assertMemoryUsageWithinLimits(
    }
        protected String requestName;
                expectedOverhead
import com.sun.management.ThreadMXBean;
        }
        // The task may not be removed from resourceAwareTasks immediately after the request completes
public class ResourceAwareTasksTests extends TaskManagerTestCase {
        Map<Long, Task> resourceTasks = testNodes[0].taskResourceTrackingService.getResourceAwareTasks();
                            } else {
            );
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskRequest;
        final List<Long> taskIdsAddedToThreadContext = new ArrayList<>();
            }
            assertFalse(task.getResourceStats().get(threadId).get(0).isActive());
            @Override
import org.opensearch.common.SuppressForbidden;
        taskTestContext.requestCompleteLatch.await();
                throwableReference.set(e);
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
                testNodes[0].transportGetTaskAction,
        taskTestContext.mainTask = action.execute(request, listener);
        setup(true, true);
        };
            TransportService transportService,
            public void waitForTaskCompletion(Task task) {}
    }
    /**
    public static class ResourceAwareNodeRequest extends TransportRequest {
                taskTestContext.requestCompleteLatch.countDown();
                            boolean taskCancelled = waitUntil(((CancellableTask) task)::isCancelled);
        } else {
        // Waiting for whole request to complete and return successfully till client
            boolean shouldBlock,
            assertEquals(0, task.getTotalResourceStats().getMemoryInBytes());
        AtomicLong expectedTaskIdInThreadContext = new AtomicLong(-2);
            }
        @Override
        while (throwable.getCause() != null) {
        // Waiting for whole request to complete and return successfully till client
        setupTestNodes(settings);
            assertEquals(0, task.getMinResourceStats().getMemoryInBytes());
                responseReference.set(listTasksResponse);
            public void onTaskUnregistered(Task task) {
        }
                    actualTaskIdInThreadContext.set(threadPool.getThreadContext().getTransient(TASK_ID));
            super(in);
                throwableReference.set(e);
        // Wait enough time for taskId to be added to taskIdsRemovedFromThreadContext before performing validations.
            long expectedArrayAllocationOverhead = 2 * 4000000; // Task's memory overhead due to array allocations
                    return true;
                                fail("It should have thrown an exception");
        TaskTestContext taskTestContext = new TaskTestContext();
        }
                throwableReference.set(e);
                    // the task is unregistered.
        private BiConsumer<Task, Long> operationStartValidator;
            }
                @SuppressForbidden(reason = "ThreadMXBean#getThreadAllocatedBytes")
    }
        assertBusy(() -> assertEquals(0, resourceTasks.size()));
            assertTrue(taskResourceUsage.getMemoryInBytes() > 0);
            assertEquals(1, task.getResourceStats().get(threadId).size());
                public void onFailure(Exception e) {
            // One thread is currently working on task but not finished
                @Override
                }
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
            @Override
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
                new GetTaskRequest().setTaskId(new TaskId(testNodes[0].getNodeId(), new ArrayList<>(resourceTasks.values()).get(0).getId()))
                testNodes[0].transportListTasksAction,
                            protected void innerOnResponse(Task task) {
import java.util.concurrent.CountDownLatch;
            public void onResponse(NodesResponse listTasksResponse) {
            .put("task_resource_tracking.enabled", resourceTrackingEnabled)
            }
import org.opensearch.common.settings.Settings;
            GetTaskResponse getTaskResponse = ActionTestUtils.executeBlocking(
            }
import java.util.concurrent.atomic.AtomicReference;
    public void testTaskIdPersistsInThreadContext() throws InterruptedException {
            }
            requestName = request.requestName;
                taskTestContext.requestCompleteLatch.countDown();
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
            node.clusterService,
            assert task.supportsResourceTracking();
    private void assertMemoryUsageWithinLimits(long actual, long expected) {
        }
        Map<Long, Task> resourceTasks = testNodes[0].taskResourceTrackingService.getResourceAwareTasks();
            @Override
                }
                    ExceptionsHelper.reThrowIfNotNull(e);
                actualTaskMemoryOverhead - taskTestContext.memoryConsumptionWhenExecutionStarts,
            assertEquals(1, task.getThreadUsage().getThreadExecutions());
                responseReference.set(listTasksResponse);
        public ResourceAwareNodeRequest(NodesRequest request) {
        assertTasksRequestFinishedSuccessfully(responseReference.get(), throwableReference.get());
            assertEquals(1, task.getResourceStats().get(threadId).size());
                throwableReference.set(e);
    }
            long expectedOverhead = expectedArrayAllocationOverhead + taskCancellationOverhead;
            assertTrue("Cpu should have a positive value", cpuTimeInNanos > 0);
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;
import static org.hamcrest.Matchers.containsInAnyOrder;
    }
                responseReference.set(listTasksResponse);
                public boolean shouldCancelChildrenOnCancellation() {
        });
            public void onFailure(Exception e) {
                actualTaskMemoryOverhead - taskTestContext.memoryConsumptionWhenExecutionStarts,
        public String getDescription() {
                        try {
                    taskTestContext.memoryConsumptionWhenExecutionStarts = threadMXBean.getThreadAllocatedBytes(
            return new CancellableTask(id, type, action, getDescription(), parentTaskId, headers) {
                                taskTestContext.operationFinishedValidator.accept(task, threadId.get());
        assertEquals(TaskCancelledException.class, findActualException(responseReference.get().failures().get(0)).getClass());
        // Waiting for whole request to complete and return successfully till client
                            @Override
            assertTrue(task.getResourceStats().get(threadId).get(0).isActive());
            Future<?> result = threadPool.executor(ThreadPool.Names.SEARCH).submit(new AbstractRunnable() {
            assertTrue(task.getResourceStats().get(threadId).get(0).isActive());
            assertEquals(0, task.getTotalResourceStats().getMemoryInBytes());
            assertEquals(1, task.getResourceStats().get(threadId).size());
        setup(true, false);
            assertEquals(0, task.getMaxResourceStats().getMemoryInBytes());
            assertEquals(task.getTotalResourceStats().getCpuTimeInNanos(), task.getMinResourceStats().getCpuTimeInNanos());
        runnableTaskListener.set(testNodes[0].taskResourceTrackingService);
            // Thread has finished working on the task's runnable
            assertEquals(0, task.getTotalResourceStats().getCpuTimeInNanos());
            long actualTaskMemoryOverhead = task.getTotalResourceStats().getMemoryInBytes();
                            fail("failed to register a completion listener as task resource tracking has already completed");
        Map<Long, Task> resourceTasks = testNodes[0].taskResourceTrackingService.getResourceAwareTasks();
import org.opensearch.core.tasks.TaskId;
            assertFalse(task.getResourceStats().get(threadId).get(0).isActive());
        startResourceAwareNodesAction(testNodes[0], false, taskTestContext, new ActionListener<NodesResponse>() {
            assertEquals(0, task.getMaxResourceStats().getCpuTimeInNanos());
            assertNotNull(taskInfo.getResourceStats().getResourceUsageInfo());
        // Waiting for whole request to complete and return successfully till client
        // Waiting for whole request to complete and return successfully till client
            .build();
            assertEquals(0, task.getAverageResourceStats().getMemoryInBytes());
        Throwable throwable = e.getCause();
        }
        assertThat(actual, lessThanOrEqualTo(expected + maxOverhead));
            @Override
import org.opensearch.tasks.Task;
    }
        startResourceAwareNodesAction(testNodes[0], false, taskTestContext, new ActionListener<NodesResponse>() {
        taskTestContext.requestCompleteLatch.await();
                    return false;
        }
import org.opensearch.ExceptionsHelper;
    private TaskTestContext startResourceAwareNodesAction(
            );
                responseReference.set(listTasksResponse);
            };
            assertEquals(1, task.getResourceStats().size());
        taskTestContext.operationFinishedValidator = (task, threadId) -> { assertEquals(0, resourceTasks.size()); };
    }
            long expectedArrayAllocationOverhead = 4000000; // Task's memory overhead due to array allocations
        setup(true, false);
            assertCPUTime(taskResourceUsage.getCpuTimeInNanos());
                taskTestContext.requestCompleteLatch.countDown();
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        });
        // Cancel main task
import static org.hamcrest.Matchers.lessThanOrEqualTo;
    ) {
            assertEquals(0, resourceTasks.size());
            ClusterService clusterService,
        long maxOverhead = Math.min(500000, expected * 5 / 100);
        protected ResourceAwareNodeRequest newNodeRequest(NodesRequest request) {
            assertEquals(1, task.getResourceStats().get(threadId).size());
            // allocations are completed before the task is cancelled
        // The work done within the runnable in this test often completes in under that time and returns a 0 value from
            @Override
            assertNotNull(taskInfo.getResourceStats().getResourceUsageInfo().get("total"));
        setup(true, false);
        Settings settings = Settings.builder()
        public NodesRequest(String requestName, String... nodesIds) {
                responseReference.set(listTasksResponse);
            assertTrue(task.getResourceStats().get(threadId).get(0).isActive());
        CancelTasksRequest request = new CancelTasksRequest();
            assertEquals(task.getTotalResourceStats().getMemoryInBytes(), task.getMinResourceStats().getMemoryInBytes());
    public void testTaskResourceTrackingDisabled() throws Exception {
        return taskTestContext;
        taskTestContext.operationFinishedValidator = (task, threadId) -> {
}
            }
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
                new ListTasksRequest().setActions("internal:resourceAction*").setDetailed(true)
        });
                }
            threadPool,
            super(in);
            this.taskTestContext = taskTestContext;
    public void testTaskResourceTrackingEnabledWhileTaskInProgress() throws Exception {
            }
            }
        setup(true, false);
            assertEquals(1, task.getResourceStats().size());
            public void taskExecutionStarted(Task task, Boolean closeableInvoked) {
                        // Using periodic checks method to identify that the task was cancelled
import org.opensearch.core.common.io.stream.StreamOutput;
            );
        @Override
        private NodesRequest(StreamInput in) throws IOException {
            // One thread is currently working on task but not finished
                                ExceptionsHelper.reThrowIfNotNull(e);
            // Thread has finished working on the task's runnable
                responseReference.set(listTasksResponse);
        assertNotNull(nodesResponse);
        @Override
            assertEquals(task.getTotalResourceStats().getCpuTimeInNanos(), task.getAverageResourceStats().getCpuTimeInNanos());
            try {
import static org.opensearch.tasks.TaskResourceTrackingService.TASK_ID;
        }
        NodesRequest request = new NodesRequest("Test Request", node.getNodeId());
                responseReference.set(listTasksResponse);
            TaskTestContext taskTestContext
            @Override
            assertEquals(0, task.getTotalResourceStats().getCpuTimeInNanos());
        // Windows registers a cpu tick at a default of ~15ms which is slightly slower than other OSs.
            return new CancellableTask(id, type, action, getDescription(), parentTaskId, headers) {
        final List<Long> taskIdsRemovedFromThreadContext = new ArrayList<>();
import java.lang.management.ManagementFactory;
                            @Override
        taskTestContext.requestCompleteLatch.await();
    }
    private static class TaskTestContext {
            assertEquals(1, task.getResourceStats().size());
        });
            TaskResourceUsage taskResourceUsage = taskInfo.getResourceStats().getResourceUsageInfo().get("total");
        ActionTestUtils.executeBlocking(testNodes[0].transportCancelTasksAction, request);
                public boolean supportsResourceTracking() {
            @Override
    private void assertCPUTime(long cpuTimeInNanos) {
        taskTestContext.operationFinishedValidator = (task, threadId) -> {
import org.opensearch.threadpool.ThreadPool;
            @Override
                expectedArrayAllocationOverhead
            this.blockForCancellation = shouldBlock;
        ActionListener<NodesResponse> listener
                    // operationFinishedValidator will be called just after all task threads are marked inactive and
                }
                taskTestContext.requestCompleteLatch.countDown();
                            if (taskCancelled) {
            public void onFailure(Exception e) {
            assertEquals(1, task.getResourceStats().get(threadId).size());
        taskTestContext.operationStartValidator = (task, threadId) -> { assertEquals(0, resourceTasks.size()); };
    public void testBasicTaskResourceTracking() throws Exception {
        // Waiting for whole request to complete and return successfully till client
            @Override
    private static final ThreadMXBean threadMXBean = (ThreadMXBean) ManagementFactory.getThreadMXBean();
                taskTestContext.requestCompleteLatch.countDown();
import org.opensearch.action.support.ActionTestUtils;
import java.util.Map;
            public void onResponse(NodesResponse listTasksResponse) {
    private Throwable findActualException(Exception e) {
            throw new UnsupportedOperationException("the task parameter is required");
            node.transportService,
            assertEquals(0, task.getAverageResourceStats().getCpuTimeInNanos());
        private long memoryConsumptionWhenExecutionStarts;
        TaskTestContext taskTestContext = new TaskTestContext();
        protected NodeResponse nodeOperation(ResourceAwareNodeRequest request) {
        TaskTestContext taskTestContext,
        }
            long expectedArrayAllocationOverhead = 2 * 4000000; // Task's memory overhead due to array allocations
                        });
        startResourceAwareNodesAction(testNodes[0], false, taskTestContext, new ActionListener<NodesResponse>() {
        @Override
    }
            @Override
        connectNodes(testNodes[0]);
            assertTrue(taskResourceUsage.getMemoryInBytes() > 0);
        }
        };
            @Override
        startResourceAwareNodesAction(testNodes[0], true, taskTestContext, new ActionListener<NodesResponse>() {
            requestName = in.readString();
        @Override
            long actualTaskMemoryOverhead = task.getTotalResourceStats().getMemoryInBytes();
                                throw new TaskCancelledException("Task Cancelled");
import org.opensearch.transport.TransportService;
    }
            public void onFailure(Exception e) {
            assertEquals(1, resourceTasks.size());
package org.opensearch.action.admin.cluster.node.tasks;
            });
            );
        assertEquals(expectedTaskIdInThreadContext.get(), actualTaskIdInThreadContext.get());
            assertEquals(1, task.getResourceStats().size());
        assertTasksRequestFinishedSuccessfully(responseReference.get(), throwableReference.get());
        TaskTestContext taskTestContext = new TaskTestContext();
            long actualTaskMemoryOverhead = task.getTotalResourceStats().getMemoryInBytes();
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
                public boolean shouldCancelChildrenOnCancellation() {
        }
            );
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
            blockForCancellation,
            ListTasksResponse listTasksResponse = ActionTestUtils.executeBlocking(
        public String getDescription() {
                    taskIdsAddedToThreadContext.add(task.getId());
        };
                    expectedTaskIdInThreadContext.set(task.getId());
            public void onResponse(NodesResponse listTasksResponse) {
            assertEquals(0, task.getMinResourceStats().getCpuTimeInNanos());
        }
                    }
        private BiConsumer<Task, Long> operationFinishedValidator;
            // In basic single threaded case min == max == average == total
        @Override
        TaskTestContext taskTestContext = new TaskTestContext();
        }
            @Override
        taskTestContext.requestCompleteLatch.await();
                @Override
        taskTestContext.requestCompleteLatch.await();
 * this file be licensed under the Apache-2.0 license or a
                            protected void innerOnFailure(Exception e) {
            "internal:resourceAction",
                        } catch (InterruptedException ex) {
            testNodes[0].taskResourceTrackingService.setTaskResourceTrackingEnabled(true);
import java.util.List;
        // Waiting for whole request to complete and return successfully till client
import org.apache.lucene.util.Constants;
            assertFalse(resourceTasks.isEmpty());
                @Override
        taskTestContext.operationStartValidator = (task, threadId) -> {
        taskTestContext.requestCompleteLatch.await();
            public void onFailure(Exception e) {
            }
        @Override
    public static class NodesRequest extends BaseNodesRequest<NodesRequest> {
        });
     * Simulates a task which executes work on search executor.
    }
        // 5% buffer up to 500 KB to account for classloading overhead.
import org.opensearch.tasks.CancellableTask;
        };
import org.opensearch.tasks.TaskInfo;
            super(nodesIds);
        taskTestContext.operationFinishedValidator = (task, threadId) -> { assertEquals(0, resourceTasks.size()); };
            TaskResourceUsage taskResourceUsage = taskInfo.getResourceStats().getResourceUsageInfo().get("total");
import java.util.concurrent.Future;
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
        );
    public void testTaskResourceTrackingDisabledWhileTaskInProgress() throws Exception {
    }
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
 *
            @Override
        taskTestContext.operationStartValidator = (task, threadId) -> {
        startResourceAwareNodesAction(testNodes[0], false, taskTestContext, new ActionListener<NodesResponse>() {
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskResponse;
        assertThat(taskIdsAddedToThreadContext, containsInAnyOrder(taskIdsRemovedFromThreadContext.toArray()));
        taskTestContext.operationStartValidator = (task, threadId) -> {
                    if (taskTestContext.operationStartValidator != null) {
            super.writeTo(out);
        TaskTestContext taskTestContext = new TaskTestContext();
        ) {
            assertMemoryUsageWithinLimits(
                throwableReference.set(e);
            }
            assertEquals(0, resourceTasks.size());
                expectedArrayAllocationOverhead
        // It is possible for the MockTaskManagerListener to be called after the response is sent already.
                } else {
                taskTestContext.requestCompleteLatch.countDown();
            assertEquals(1, resourceTasks.size());
@SuppressForbidden(reason = "ThreadMXBean#getThreadAllocatedBytes")
            assertCPUTime(task.getTotalResourceStats().getCpuTimeInNanos());
            assertCPUTime(task.getTotalResourceStats().getCpuTimeInNanos());
            assertNotNull(taskInfo.getResourceStats());
import org.opensearch.core.common.io.stream.StreamInput;
        });
        AtomicLong actualTaskIdInThreadContext = new AtomicLong(-1);
            assertEquals(1, resourceTasks.size());
        final AtomicReference<NodesResponse> responseReference = new AtomicReference<>();
            public void onFailure(Exception e) {
    }
