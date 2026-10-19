            service.cancelTaskAndDescendants(task, reason, waitForCompletion, listener);
        default void onTaskCancelled(CancellableTask task) {}
        final CancellableTaskHolder holder = cancellableTasks.get(taskId);
            assert Thread.holdsLock(this) == false;  
        for (CancellableTaskHolder holder : cancellableTasks.values()) {
 * Task Manager service for keeping track of currently running tasks on the nodes  
import org.opensearch.common.unit.TimeValue;
    public Collection<DiscoveryNode> startBanOnChildrenNodes(long taskId, Runnable onChildTasksCompleted, String reason) {
    }
        if (taskResourceTrackingService.get() == null) return () -> {};
            }
        });
import org.opensearch.common.settings.Setting;  
            final boolean added = pendingTasks.add(task);  
        final ChannelPendingTaskTracker tracker = channelPendingTaskTrackers.compute(channel, (k, curr) -> {
                if (childTasksPerNode.isEmpty() && this.childTaskCompletedListeners != null) {  
import org.opensearch.threadpool.ThreadPool;
            this.task = task;
        ClusterSettings clusterSettings,
import java.util.HashMap;  
     * Rest headers that are copied to the task
 * this file be licensed under the Apache-2.0 license or a
            }
    }  
 * specific language governing permissions and limitations
        }
        private String banReason;
                }
     * Start tracking a cancellable task with its tcp channel, so if the channel gets closed we can get a set of  
        assert oldHolder == null;  
            }
            registerCancellableTask(task);  
import org.opensearch.core.tasks.TaskId;
                taskEventListener.onTaskCancelled(task);
import java.util.Map;
        }
import org.opensearch.core.action.NotifyOnceListener;
            permits.acquireUninterruptibly(Integer.MAX_VALUE);  
            assert false : "TaskCancellationService is not initialized";
    }
        final TaskResult taskResult;  
                    listener.run();
            return null;
        }
    }
    /**
        }
        this.taskResourceTrackingService.set(taskResourceTrackingService);  
                if (childTasksPerNode == null) {
        if (logger.isTraceEnabled()) {
     * <p>
                    toRun.run();
        if (localNode == null) {
            assert removed : "task " + task.getId() + " is not in the pending list";
            taskHashMap.put(holder.getTask().getId(), holder.getTask());
    private final List<String> taskHeaders;
        List<Exception> exceptions = new ArrayList<>();
     * Unregister the task
        }
            Exception rootException = null;
            try {
            holder.cancel(reason, listener);  
                if (cancellationListeners != null) {
 * GitHub history for details.
    }
            return;  
    public Map<Long, Task> getTasks() {
        try {
 * this work for additional information regarding copyright
 */  
            });
        DiscoveryNode localNode = lastDiscoveryNodes.getLocalNode();
 * the Apache License, Version 2.0 (the "License"); you may
        this.threadPool = threadPool;
                // Only set the ban if the node is the part of the cluster
            return task;  
        for (String key : taskHeaders) {  
            }
 */
            final List<Runnable> listeners;
            for (Consumer<Task> taskConsumer : taskResourceConsumer) {
            String httpHeader = threadContext.getHeader(key);
                lastDiscoveryNodes = event.state().getNodes();
            return true;
import java.util.Objects;
        }  
            listener.onFailure(ex);
    public static TaskManager createTaskManagerWithClusterSettings(
            }
            }
                return null;
            @Override  
        void removeTask(CancellableTask task) {
 * The OpenSearch Contributors require contributions made to  
        if (holder != null) {
        } else {
            toRun.run();  
    public Releasable registerChildNode(long taskId, DiscoveryNode node) {  
        if (task instanceof CancellableTask) {
     */
            final Runnable toRun;  
            } catch (Exception e) {  
                        banIterator.remove();
                throw new TaskCancelledException("The parent task was cancelled, shouldn't start any child tasks, " + banReason);
        CancellableTaskHolder holder = new CancellableTaskHolder(cancellableTask);
        return startBanOnChildrenNodes(taskId, onChildTasksCompleted, "unknown");  
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            logger.trace("register {} [{}] [{}] [{}]", task.getId(), type, action, task.getDescription());
import org.opensearch.core.action.ActionResponse;  
        private final CancellableTask task;
                    if (childTaskCompletedListeners == null) {  
     */
    public Task getTask(long id) {  
    private final SetOnce<TaskCancellationService> cancellationService = new SetOnce<>();
        if (localNode == null) {  
     * Start rejecting new child requests as the parent task was cancelled.
                    toRun = onChildTasksCompleted;  
    private static final TimeValue WAIT_FOR_COMPLETION_POLL = timeValueMillis(100);
    // for testing  
            final Runnable toRun;  
        // Set the ban first, so the newly created tasks cannot be registered
            return true;  
import org.apache.logging.log4j.Logger;
    public Collection<DiscoveryNode> startBanOnChildrenNodes(long taskId, Runnable onChildTasksCompleted) {
    public int getBanCount() {
            boolean success = task.addResourceTrackingCompletionListener(new NotifyOnceListener<>() {  
            notifyListeners(listeners);
        }
            }  
     */
            try {  
    /**
            listener.onFailure(error);  
            public void onFailure(Exception e) {  
     * This method is called when a parent task that has children is cancelled.  
                }  
                            "Removing ban for the parent [{}] on the node [{}], reason: the parent node is gone",  
            return;  
        HashMap<Long, Task> taskHashMap = new HashMap<>(this.tasks);  
    public void registerTaskResourceConsumer(Consumer<Task> consumer) {
                    }
        if (taskResourceConsumersEnabled) {  
     *
    public void setTaskResourceConsumersEnabled(boolean taskResourceConsumersEnabled) {  
            }  
     */
import org.opensearch.core.tasks.TaskCancelledException;  
            assert releasePermit();
        } else {
    private final List<TaskEventListeners> taskEventListeners = new ArrayList<>();  
    public void setTaskResultsService(TaskResultsService taskResultsService) {
    }  
    /**
                    pendingChildNodes = Set.copyOf(childTasksPerNode.keySet());
    private static final Logger logger = LogManager.getLogger(TaskManager.class);  
                Thread.sleep(WAIT_FOR_COMPLETION_POLL.millis());
                } catch (Exception e) {
                            taskId,
                    }
    /**
                    assert cancellationListeners == null;  
        void cancel(String reason) {  
            return getCancellableTask(id);
                listener.onFailure(e);
    public Task unregister(Task task) {  
    public static final String TASK_RESOURCE_CONSUMERS_ATTRIBUTES = "task_resource_consumers.enabled";
    }
 * @opensearch.internal
public class TaskManager implements ClusterStateApplier {
        return lastDiscoveryNodes.getLocalNode();
        } else {
     * Returns the list of currently running tasks on the node  
    }  
            logger.warn("couldn't store response {}, the node didn't join the cluster yet", response);
                protected void innerOnResponse(Task task) {
     * Stores the task result
    }
    /**
                listener.onFailure(e);  
    /**  
    public List<CancellableTask> setBan(TaskId parentTaskId, String reason) {
        Task task = request.createTask(taskIdGenerator.incrementAndGet(), type, action, request.getParentTask(), headers);
    @Override  
    /**  
                    TaskId taskId = banIterator.next();  
        return Collections.unmodifiableSet(banedParents.keySet());
                try {  
        CancellableTaskHolder(CancellableTask task) {
import java.util.concurrent.ConcurrentHashMap;
 * You may obtain a copy of the License at  
import org.opensearch.cluster.node.DiscoveryNodes;
        }
                    task.getId()  
                    holder.cancel(reason);
            // in the listener synchronization
        this.taskResourceConsumersEnabled = taskResourceConsumersEnabled;
     * After starting cancellation on the parent task, the task manager tries to cancel all children tasks
     */
        // Check if this task was banned before we start it. The empty check is used to avoid
        if (holder != null) {
                logger.trace("unregister child node [{}] task [{}]", node, taskId);  
                @Override
        this.cancellationService.set(taskCancellationService);
            threadPool.generic().execute(new AbstractRunnable() {
/*
            return curr;  
            for (Runnable listener : listeners) {
            taskResult = task.result(localNode.getId(), response);
        CancellableTaskHolder holder = cancellableTasks.get(id);
                return holder.getTask();
        void addTask(CancellableTask task) {
        try {
    public static final Setting<Boolean> TASK_RESOURCE_CONSUMERS_ENABLED = Setting.boolSetting(  
        });
            } catch (Exception e) {  
                    // let's clean up the registration
        } else {  
                }
            if (success == false) {  
        }  
            holder.registerChildNode(node);
            throw new IllegalStateException("TaskCancellationService is not initialized");
        if (task instanceof CancellableTask) {
            task.cancel(reason);
    private void registerCancellableTask(Task task) {
                return;
     * Returns a task with given id, or null if the task is not found.
            }
     */
        assert task.getParentTaskId().equals(request.getParentTask()) : "Request [ " + request + "] didn't preserve it parentTaskId";  
        }  
        } catch (IOException ex) {  
        Objects.requireNonNull(task);
        }
import java.util.HashSet;
    }  
         */  
     */
            synchronized (this) {
        lastDiscoveryNodes = event.state().getNodes();
                holder.finish();
            if (lastDiscoveryNodes.nodeExists(parentTaskId.getNodeId())) {  
    public DiscoveryNode localNode() {
        CancellableTaskHolder holder = cancellableTasks.get(task.getId());
     * @param reason                the ban reason
                } else {  
     * Cancels a task  
    // for testing  
            Task previousTask = tasks.put(task.getId(), task);
                    }
        void unregisterChildNode(DiscoveryNode node) {  
    private volatile DiscoveryNodes lastDiscoveryNodes = DiscoveryNodes.EMPTY_NODES;
        default void onTaskCompleted(Task task) {}  
                } finally {  
        HashMap<Long, CancellableTask> taskHashMap = new HashMap<>();
import org.opensearch.ExceptionsHelper;
        return () -> {};
     * <p>
    }  
    private final AtomicLong taskIdGenerator = new AtomicLong();  
        private boolean banChildren = false;  
            return Collections.emptySet();
        false,
            }
            try {
    }
                try {  
        /**
        ExceptionsHelper.maybeThrowRuntimeAndSuppress(exceptions);
                    childTaskCompletedListeners.add(onChildTasksCompleted);  
                assert removedTracker == tracker;
            }
        final TaskCancellationService service = cancellationService.get();  
import org.opensearch.common.lease.Releasables;
    /**  
        }
        }  
import java.util.concurrent.Semaphore;
        return banedParents.size();  
     * of the current task. Once cancellation of the children tasks is done, the listener is triggered.  
    public <Response extends ActionResponse> void storeResult(Task task, Exception error, ActionListener<Response> listener) {
        private Map<DiscoveryNode, Integer> childTasksPerNode = null;
        } else {  
        taskResultsService.storeResult(taskResult, new ActionListener<Void>() {  
        Map<String, String> headers = new HashMap<>();
                logger.warn(() -> new ParameterizedMessage("couldn't store error {}", ExceptionsHelper.detailedMessage(error)), e);
        if (task.getParentTaskId().isSet() && banedParents.isEmpty() == false) {  
            return holder.startBan(onChildTasksCompleted, reason);
        // computing the hash code of the parent taskId as most of the time banedParents is empty.
    }
        }
        }
    /**  
 * Modifications Copyright OpenSearch Contributors. See
                }
    private TaskResultsService taskResultsService;
            return task;
    }
 * KIND, either express or implied.  See the License for the
        Set<String> taskHeaders  
        private boolean finished = false;  
            return Collections.unmodifiableSet(pendingTasks);
                } catch (RuntimeException inner) {
                logger.debug(
        synchronized (banedParents) {
            } catch (InterruptedException e) {  
    }  
        assert this.taskResultsService == null;  
                        logger.debug(
     */
    /**  
        List<Exception> exceptions = new ArrayList<>();
        this.maxHeaderSize = SETTING_HTTP_MAX_HEADER_SIZE.get(settings);
        private void notifyListeners(List<Runnable> listeners) {
        }
import java.util.Collections;
    }
                } else {
                } else {
     */  
        private List<Runnable> cancellationListeners = null;
                try {
            if (holder != null) {  
            }  
            } finally {
                if (toRun != null) {  
        while (System.nanoTime() - untilInNanos < 0) {  
            CancellableTaskHolder holder = cancellableTasks.remove(task.getId());
        public boolean hasParent(TaskId parentTaskId) {  
        }
            synchronized (banedParents) {
        void cancel(String reason, Runnable listener) {
                    listeners = Collections.emptyList();
}
                    taskConsumer.accept(task);  
     * Bans all tasks with the specified parent task from execution, cancels all tasks that are currently executing.
        Setting.Property.NodeScope
    }  
            onChildTasksCompleted.run();
            synchronized (this) {
        banedParents.remove(parentTaskId);  
     * @param taskId                the parent task id  
import org.opensearch.common.util.concurrent.ConcurrentMapLong;
    /**  
    public void setTaskResourceTrackingService(TaskResourceTrackingService taskResourceTrackingService) {
                    for (CancellableTask task : tasks) {  
import org.opensearch.cluster.node.DiscoveryNode;  
    private final ThreadPool threadPool;
        final AtomicBoolean registered = new AtomicBoolean();  
        if (holder != null) {
     * Removes the ban for the specified parent task.  
            }, e -> { assert false : new AssertionError("must not be here", e); }));
    }
        long headerSize = 0;  
        taskResultsService.storeResult(taskResult, new ActionListener<Void>() {
        return taskManager;
                } else {
                public void onFailure(Exception e) {  
    public void removeBan(TaskId parentTaskId) {
            listener.onResponse(response);  
    public CancellableTask getCancellableTask(long id) {  
                this.finished = true;
            taskResult = task.result(localNode.getId(), error);
import org.opensearch.common.lease.Releasable;  
            }  
                }  
                childTasksPerNode = new HashMap<>();
                @Override
        this.taskEventListeners.add(taskEventListeners);
 * SPDX-License-Identifier: Apache-2.0
            return;
import java.util.Collection;
            taskHashMap.put(holder.getTask().getId(), holder.getTask());
            curr.addTask(task);
                        cancelTaskAndDescendants(task, "channel was closed", false, ActionListener.wrap(() -> {}));
    public <Response extends ActionResponse> void storeResult(Task task, Response response, ActionListener<Response> listener) {
     * Blocks the calling thread, waiting for the task to vanish from the TaskManager.  
            assert previousTask == null;  
                    pendingChildNodes = Collections.emptySet();  
        if (task != null) {
            public void onResponse(Void aVoid) {
     */
            final List<Runnable> listeners;
                );
    public Releasable startTrackingCancellableChannelTask(TcpChannel channel, CancellableTask task) {
import org.opensearch.OpenSearchTimeoutException;  
    }  
                    }  
    }
                final ChannelPendingTaskTracker removedTracker = channelPendingTaskTrackers.remove(channel);
        }  
        return channelPendingTaskTrackers.size();
 */  
 * Unless required by applicable law or agreed to in writing,
        logger.trace("removing ban for the parent task {}", parentTaskId);
    private final ByteSizeValue maxHeaderSize;  
                @Override  
                curr = new ChannelPendingTaskTracker();  
     * If the task is completed or unregistered from TaskManager, then the listener is called immediately.
 * under the License.  
                throw new OpenSearchException("Interrupted waiting for completion of [{}]", e, task);
                    logger.warn("failed to cancel tasks on channel closed", e);
    }  
    private static class ChannelPendingTaskTracker {
        clusterSettings.addSettingsUpdateConsumer(TASK_RESOURCE_CONSUMERS_ENABLED, taskManager::setTaskResourceConsumersEnabled);  
import org.opensearch.transport.TcpChannel;  
    /**
     * Returns the list of currently running tasks on the node that can be cancelled
                if (headerSize > maxSize) {
            if (banChildren) {  
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_HEADER_SIZE;  
            logger.trace("register child node [{}] task [{}]", node, taskId);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assert acquireAllPermits(); // do not release permits so we can't add tasks to this tracker after draining
        }
                } else {
     *
    /**
            return holder.getTask();  
     * Register a node on which a child task will execute. The returned {@link Releasable} must be called  
        public CancellableTask getTask() {
     */  
        public void finish() {
 */  
                protected void innerOnFailure(Exception e) {
     * Registers a task without parent task
import org.apache.logging.log4j.message.ParameterizedMessage;  
                    cancellationListeners = null;
            if (childTasksPerNode == null) {  
import java.util.function.Consumer;
import org.opensearch.core.Assertions;
                if (finished) {
    public void cancelTaskAndDescendants(CancellableTask task, String reason, boolean waitForCompletion, ActionListener<Void> listener) {
    public Set<TaskId> getBannedTaskIds() {
import java.util.Set;  
import java.io.IOException;
                }  
        throw new OpenSearchTimeoutException("Timed out waiting for completion of [{}]", task);
     */  
            String reason = banedParents.get(task.getParentTaskId());
     * Will be used in task manager stats and for debugging.  
                    throw new TaskCancelledException("Task cancelled before it started: " + reason);
     * @return AutoCloseable to free up resources (clean up thread context) when task execution block returns
            @Override  
     * @return a releasable that should be called when this pending task is completed  
    public interface TaskEventListeners {  
        synchronized void registerChildNode(DiscoveryNode node) {
        }
        }  
     *
        final Semaphore permits = Assertions.ENABLED ? new Semaphore(Integer.MAX_VALUE) : null;
        if (tracker.registered.compareAndSet(false, true)) {
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
        for (TaskEventListeners taskEventListener : taskEventListeners) {  
                banReason = reason;
import java.util.ArrayList;  
            notifyListeners(listeners);
                            cancellationListeners = new ArrayList<>();  
    private final Map<TaskId, String> banedParents = new ConcurrentHashMap<>();
            // too early to store anything, shouldn't really be here - just pass the response along
     */  
        Set<CancellableTask> drainTasks() {  
        final Set<CancellableTask> pendingTasks = ConcurrentCollections.newConcurrentSet();
    }
            if (curr == null) {
    }
                @Override
                protected void doRun() {
        }  
            @Override
 * license agreements. See the NOTICE file distributed with
     * Stores the task failure  
import org.opensearch.common.settings.Settings;
                if (pendingChildNodes.isEmpty()) {
                listener.onResponse(response);  
        CancellableTaskHolder oldHolder = cancellableTasks.put(task.getId(), holder);
        private List<Runnable> childTaskCompletedListeners = null;
        task.decrementResourceTrackingThreads();
     * @return a list of pending cancellable child tasks
        ExceptionsHelper.maybeThrowRuntimeAndSuppress(exceptions);  
        }  
            final Set<DiscoveryNode> pendingChildNodes;
                    childTasksPerNode.remove(node);
        assert cancellableTasks.containsKey(task.getId()) : "task [" + task.getId() + "] is not registered yet";  
                    ExceptionsHelper.reThrowIfNotNull(e);
     * to unregister the child node once the child task is completed or failed.
import java.util.List;  
        ThreadPool threadPool,
            if (reason != null) {
     * Returns a cancellable task with given id, or null if the task is not found.
                    rootException = ExceptionsHelper.useOrSuppress(rootException, inner);  
        return Collections.unmodifiableMap(taskHashMap);  
                    if (listener != null) {
            if (httpHeader != null) {
    public ThreadContext.StoredContext taskExecutionStarted(Task task) {
     * Takes actions when a task is registered and its execution starts
import org.opensearch.cluster.ClusterChangedEvent;
        for (TaskEventListeners taskEventListener : taskEventListeners) {  
import org.opensearch.common.util.concurrent.AbstractRunnable;  
                // Remove all bans that were registered by nodes that are no longer in the cluster state  
            }
        for (CancellableTaskHolder holder : cancellableTasks.values()) {  
    /**
                }
                cancelTasksOnChannelClosed(tracker.drainTasks());  
    private volatile boolean taskResourceConsumersEnabled;
                        if (cancellationListeners == null) {
    }  
    }
import org.opensearch.common.util.concurrent.ConcurrentCollections;
    /**
        if (task.supportsResourceTracking()) {
                        childTaskCompletedListeners = new ArrayList<>();
        final TaskManager taskManager = new TaskManager(settings, threadPool, taskHeaders);
                    toRun = listener;
        logger.trace("setting ban for the parent task {} {}", parentTaskId, reason);
            ExceptionsHelper.reThrowIfNotNull(rootException);  
        }
import java.util.concurrent.atomic.AtomicBoolean;  
        final TaskResult taskResult;  
        this.taskResultsService = taskResultsService;
import org.opensearch.common.SetOnce;
    }  
                exceptions.add(e);
/*  
                    childTaskCompletedListeners = null;
                }
                Iterator<TaskId> banIterator = banedParents.keySet().iterator();
                }  
    /**
 * ownership. Elasticsearch licenses this file to you under  
        Setting.Property.Dynamic,  
                listener.onFailure(error);
     */  
        if (tasks.isEmpty() == false) {  
            assert permits.tryAcquire() : "tracker was drained";
                }
            logger.warn(() -> new ParameterizedMessage("couldn't store response {}", response), ex);
                }
                    if (taskResourceTrackingService.get() != null && task.supportsResourceTracking()) {
                        }
                    logger.error("error encountered when updating the consumer", e);
                    listeners = cancellationListeners;  
        taskResourceConsumer.add(consumer);
        logger.trace("unregister task for id: {}", task.getId());
    /**
            }
            synchronized (this) {  
import org.apache.logging.log4j.LogManager;
     * @return the set of current nodes that have outstanding child tasks  
        }  
        // Throwing exception in case any of the cancellation listener results into exception.
     * Listener that gets invoked during an event such as task cancellation/completion.
            listener.onFailure(ex);
            // too early to store anything, shouldn't really be here - just pass the error along
                }
        CancellableTask cancellableTask = (CancellableTask) task;  
        }  
     * @param task getting executed.
        }  
                    "failed to register a completion listener as task resource tracking has already completed [taskId={}]",
     */
        TASK_RESOURCE_CONSUMERS_ATTRIBUTES,
import org.opensearch.core.common.unit.ByteSizeValue;
                }
                        cancellationListeners.add(listener);
        Task task = tasks.get(id);
 *
                        );  
     * @param onChildTasksCompleted called when all child tasks are completed or failed
    }  
        }  
        }  
 * software distributed under the License is distributed on an
                }  
    public void addTaskEventListeners(TaskEventListeners taskEventListeners) {  
    }
        return cancellableTasks.values().stream().filter(t -> t.hasParent(parentTaskId)).map(t -> t.task).collect(Collectors.toList());
        taskResourceConsumer = new HashSet<>();  
    public TaskManager(Settings settings, ThreadPool threadPool, Set<String> taskHeaders) {
        // Should we just swallow such exceptions?
        boolean acquireAllPermits() {
 *  
                    listeners = Collections.emptyList();  
    private static class CancellableTaskHolder {
                    unregister(task);
        }
        }
            logger.trace("cancelling task with id {}", task.getId());
    private final Map<TcpChannel, ChannelPendingTaskTracker> channelPendingTaskTrackers = ConcurrentCollections.newConcurrentMap();
        if (event.nodesRemoved()) {  
     */
        } else {
                        taskResourceTrackingService.get().stopTracking(task);
    ) {
                taskEventListener.onTaskCompleted(task);
         * Marks task as finished.
    public void setTaskCancellationService(TaskCancellationService taskCancellationService) {
            // We need to call the listener outside of the synchronised section to avoid potential bottle necks  
import java.util.stream.Collectors;  
        if (service != null) {
        return taskResourceTrackingService.get().startTracking(task);
        long maxSize = maxHeaderSize.getBytes();
        return () -> tracker.removeTask(task);  
/**
     *  
    private final SetOnce<TaskResourceTrackingService> taskResourceTrackingService = new SetOnce<>();
                            event.state().getNodes().getLocalNode()
    }
    }
        boolean releasePermit() {
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.action.ActionListener;
            }
/*  
                    listeners = childTaskCompletedListeners;
     */
    /**
                    assert childTaskCompletedListeners == null;
                if (childTasksPerNode.merge(node, -1, Integer::sum) == 0) {  
                    }  
    public void applyClusterState(ClusterChangedEvent event) {
        .newConcurrentMapLongWithAggressiveConcurrency();
 * not use this file except in compliance with the License.
     * <p>
            }
            permits.release();
            }
        }  
 * compatible open source license.
     * pending tasks associated that channel and cancel them as these results won't be retrieved by the parent task.
        final CancellableTaskHolder holder = cancellableTasks.get(taskId);  
            }
    }
    }
            });
            }  
        ThreadContext threadContext = threadPool.getThreadContext();
        return Collections.unmodifiableMap(taskHashMap);
                }  
            public void onFailure(Exception e) {
                holder.unregisterChildNode(node);
            return pendingChildNodes;
            });
    /**  
        });
            try {
                banChildren = true;
            return Releasables.releaseOnce(() -> {
            return;
package org.opensearch.tasks;
     */  
                headers.put(key, httpHeader);
    final int numberOfChannelPendingTaskTrackers() {
import org.opensearch.common.util.concurrent.ThreadContext;  
            }  
    }
    private final Set<Consumer<Task>> taskResourceConsumer;
        } else {  
    public Map<Long, CancellableTask> getCancellableTasks() {
        }
            assert added : "task " + task.getId() + " is in the pending list already";
     * This method is called when a previously banned task finally cancelled
                while (banIterator.hasNext()) {
    }
    private final ConcurrentMapLong<Task> tasks = ConcurrentCollections.newConcurrentMapLongWithAggressiveConcurrency();
     * <p>
            listener.run();
                logger.warn(() -> new ParameterizedMessage("couldn't store response {}", response), e);
            childTasksPerNode.merge(node, 1, Integer::sum);  
    );
    }  
            logger.warn(() -> new ParameterizedMessage("couldn't store error {}", ExceptionsHelper.detailedMessage(error)), ex);
    private final ConcurrentMapLong<CancellableTaskHolder> cancellableTasks = ConcurrentCollections  
            return task.getParentTaskId().equals(parentTaskId);
                    // Stop tracking the task once the last thread has been marked inactive.  
     * Returns the number of currently banned tasks.
            channel.addCloseListener(ActionListener.wrap(r -> {  
    private void cancelTasksOnChannelClosed(Set<CancellableTask> tasks) {
                    if (lastDiscoveryNodes.nodeExists(taskId.getNodeId()) == false) {
    public Task register(String type, String action, TaskAwareRequest request) {
 *
            public void onResponse(Void aVoid) {
import java.util.concurrent.atomic.AtomicLong;
        DiscoveryNode localNode = lastDiscoveryNodes.getLocalNode();  
        this.taskResourceConsumersEnabled = TASK_RESOURCE_CONSUMERS_ENABLED.get(settings);
     */  
        }
                exceptions.add(e);
 *
        this.taskHeaders = new ArrayList<>(taskHeaders);  
                assert reason != null;  
    public void cancel(CancellableTask task, String reason, Runnable listener) {  
            }
import org.opensearch.OpenSearchException;
                }  
        } catch (IOException ex) {  
    }  
                    toRun = () -> {};  
                    toRun = () -> {};
        // Decrement the task's self-thread as part of unregistration.  
            @Override
import java.util.Iterator;
        }
            return tasks.remove(task.getId());
            }
        }  
                headerSize += key.length() * 2 + httpHeader.length() * 2;  
        return task;
                    throw new IllegalArgumentException("Request exceeded the maximum size of task headers " + maxHeaderSize);
        }
            }
            final boolean removed = pendingTasks.remove(task);  
import org.opensearch.common.settings.ClusterSettings;
            } else {  
        Set<DiscoveryNode> startBan(Runnable onChildTasksCompleted, String reason) {
        }
            if (getTask(task.getId()) == null) {
                banedParents.put(parentTaskId, reason);
            synchronized (this) {
        }  
    public void waitForTaskCompletion(Task task, long untilInNanos) {
        }  
        if (holder != null) {
        Settings settings,  
import org.opensearch.cluster.ClusterStateApplier;
                task.cancel(reason);
