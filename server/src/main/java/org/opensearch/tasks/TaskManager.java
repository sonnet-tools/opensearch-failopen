 */
import java.io.IOException;
     * <p>
import java.util.function.Consumer;
        public void finish() {
            return holder.getTask();
                return holder.getTask();
import org.apache.logging.log4j.message.ParameterizedMessage;
        lastDiscoveryNodes = event.state().getNodes();
        for (CancellableTaskHolder holder : cancellableTasks.values()) {
        // Check if this task was banned before we start it. The empty check is used to avoid
 * @opensearch.internal
        }
            synchronized (this) {
        taskResourceConsumer.add(consumer);
    private final Map<TcpChannel, ChannelPendingTaskTracker> channelPendingTaskTrackers = ConcurrentCollections.newConcurrentMap();
        if (holder != null) {
            assert added : "task " + task.getId() + " is in the pending list already";
        }
        } else {
        return lastDiscoveryNodes.getLocalNode();
    }
import java.util.concurrent.atomic.AtomicLong;
            if (banChildren) {
                    // let's clean up the registration
        }
            return pendingChildNodes;
                }
            logger.trace("register {} [{}] [{}] [{}]", task.getId(), type, action, task.getDescription());
    public void setTaskResourceConsumersEnabled(boolean taskResourceConsumersEnabled) {
    }
    // for testing
        taskResourceConsumer = new HashSet<>();
                    listeners = childTaskCompletedListeners;
            return Releasables.releaseOnce(() -> {
        } catch (IOException ex) {
     */
            ExceptionsHelper.reThrowIfNotNull(rootException);
            }
                            taskId,
        final TaskManager taskManager = new TaskManager(settings, threadPool, taskHeaders);
            @Override
        }
    public Map<Long, Task> getTasks() {
            listener.onFailure(ex);
            toRun.run();
        Set<DiscoveryNode> startBan(Runnable onChildTasksCompleted, String reason) {
public class TaskManager implements ClusterStateApplier {
    /**
    }
        this.cancellationService.set(taskCancellationService);
                }
        // computing the hash code of the parent taskId as most of the time banedParents is empty.
 */
                    }
 * Task Manager service for keeping track of currently running tasks on the nodes
     * Will be used in task manager stats and for debugging.
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (childTasksPerNode.merge(node, -1, Integer::sum) == 0) {
        }
    public <Response extends ActionResponse> void storeResult(Task task, Response response, ActionListener<Response> listener) {
        this.taskHeaders = new ArrayList<>(taskHeaders);
import java.util.Map;
     * After starting cancellation on the parent task, the task manager tries to cancel all children tasks
        final CancellableTaskHolder holder = cancellableTasks.get(taskId);
import org.opensearch.threadpool.ThreadPool;
                    logger.warn("failed to cancel tasks on channel closed", e);
            return true;
    /**
    public int getBanCount() {
    public void setTaskResourceTrackingService(TaskResourceTrackingService taskResourceTrackingService) {
            return holder.startBan(onChildTasksCompleted, reason);
            listener.onResponse(response);
                task.cancel(reason);
        HashMap<Long, Task> taskHashMap = new HashMap<>(this.tasks);
            return true;
        return task;
        }
/*
            logger.warn("couldn't store response {}, the node didn't join the cluster yet", response);
            String httpHeader = threadContext.getHeader(key);
                throw new TaskCancelledException("The parent task was cancelled, shouldn't start any child tasks, " + banReason);
                    toRun.run();
                } catch (RuntimeException inner) {
                    ExceptionsHelper.reThrowIfNotNull(e);
                }
        long headerSize = 0;
            }
        throw new OpenSearchTimeoutException("Timed out waiting for completion of [{}]", task);
        private List<Runnable> cancellationListeners = null;
            return task;
                    listeners = Collections.emptyList();
        if (task.getParentTaskId().isSet() && banedParents.isEmpty() == false) {
import org.opensearch.core.action.NotifyOnceListener;
        logger.trace("setting ban for the parent task {} {}", parentTaskId, reason);
import org.opensearch.core.action.ActionListener;
    public static final String TASK_RESOURCE_CONSUMERS_ATTRIBUTES = "task_resource_consumers.enabled";
                childTasksPerNode = new HashMap<>();
            assert permits.tryAcquire() : "tracker was drained";
 * this file be licensed under the Apache-2.0 license or a
        }
     * @return AutoCloseable to free up resources (clean up thread context) when task execution block returns
            // in the listener synchronization
                    // Stop tracking the task once the last thread has been marked inactive.
            return curr;
                    listeners = Collections.emptyList();
    private final Map<TaskId, String> banedParents = new ConcurrentHashMap<>();
            if (curr == null) {
import org.opensearch.ExceptionsHelper;
        CancellableTask cancellableTask = (CancellableTask) task;
    private final List<String> taskHeaders;
                if (headerSize > maxSize) {
        boolean releasePermit() {
                    if (taskResourceTrackingService.get() != null && task.supportsResourceTracking()) {
    }
                } else {
            return getCancellableTask(id);
            boolean success = task.addResourceTrackingCompletionListener(new NotifyOnceListener<>() {
    /**
        return Collections.unmodifiableMap(taskHashMap);
    @Override
     * Removes the ban for the specified parent task.
            @Override
    public Collection<DiscoveryNode> startBanOnChildrenNodes(long taskId, Runnable onChildTasksCompleted) {
        this.taskResourceConsumersEnabled = taskResourceConsumersEnabled;
                    listener.run();
                }
            throw new IllegalStateException("TaskCancellationService is not initialized");
    public void registerTaskResourceConsumer(Consumer<Task> consumer) {
        }
            } finally {
                curr = new ChannelPendingTaskTracker();
 * SPDX-License-Identifier: Apache-2.0
            if (httpHeader != null) {
    public Releasable startTrackingCancellableChannelTask(TcpChannel channel, CancellableTask task) {
            channel.addCloseListener(ActionListener.wrap(r -> {
     */
import java.util.concurrent.atomic.AtomicBoolean;
            // too early to store anything, shouldn't really be here - just pass the error along
                headers.put(key, httpHeader);
    }
    }
        CancellableTaskHolder holder = cancellableTasks.get(id);
                    toRun = () -> {};
            final Set<DiscoveryNode> pendingChildNodes;
                // Remove all bans that were registered by nodes that are no longer in the cluster state
        }
                    if (listener != null) {
                    task.getId()
    /**
                        taskResourceTrackingService.get().stopTracking(task);
                logger.warn(() -> new ParameterizedMessage("couldn't store response {}", response), e);
     * Blocks the calling thread, waiting for the task to vanish from the TaskManager.
        if (holder != null) {
                this.finished = true;
            public void onFailure(Exception e) {
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
        return () -> tracker.removeTask(task);
    public void applyClusterState(ClusterChangedEvent event) {
    public DiscoveryNode localNode() {
        ExceptionsHelper.maybeThrowRuntimeAndSuppress(exceptions);
    private final AtomicLong taskIdGenerator = new AtomicLong();
        this.maxHeaderSize = SETTING_HTTP_MAX_HEADER_SIZE.get(settings);
                    listeners = cancellationListeners;
        taskResultsService.storeResult(taskResult, new ActionListener<Void>() {
    }
}
            }
        synchronized void registerChildNode(DiscoveryNode node) {
        assert this.taskResultsService == null;
     * Returns a cancellable task with given id, or null if the task is not found.
import java.util.ArrayList;
        if (localNode == null) {
        false,
    );
        DiscoveryNode localNode = lastDiscoveryNodes.getLocalNode();
    public Set<TaskId> getBannedTaskIds() {
            });
        Objects.requireNonNull(task);
 * ownership. Elasticsearch licenses this file to you under
            }
        if (service != null) {
                    for (CancellableTask task : tasks) {
            return Collections.unmodifiableSet(pendingTasks);
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        this.taskResourceConsumersEnabled = TASK_RESOURCE_CONSUMERS_ENABLED.get(settings);
                );
                if (childTasksPerNode.isEmpty() && this.childTaskCompletedListeners != null) {
                assert reason != null;
    private final ConcurrentMapLong<CancellableTaskHolder> cancellableTasks = ConcurrentCollections
        }
        }
 * KIND, either express or implied.  See the License for the
    }
                    assert childTaskCompletedListeners == null;
        for (CancellableTaskHolder holder : cancellableTasks.values()) {
                if (pendingChildNodes.isEmpty()) {
        public CancellableTask getTask() {
                @Override
 * compatible open source license.
                @Override
    private final ConcurrentMapLong<Task> tasks = ConcurrentCollections.newConcurrentMapLongWithAggressiveConcurrency();
import org.opensearch.OpenSearchException;
        HashMap<Long, CancellableTask> taskHashMap = new HashMap<>();
        return banedParents.size();
        if (holder != null) {
            }
    public void removeBan(TaskId parentTaskId) {
import org.opensearch.common.util.concurrent.ThreadContext;
        private String banReason;
        void cancel(String reason) {
            if (success == false) {
                    }
package org.opensearch.tasks;
        CancellableTaskHolder oldHolder = cancellableTasks.put(task.getId(), holder);
        assert oldHolder == null;
                        childTaskCompletedListeners = new ArrayList<>();
        banedParents.remove(parentTaskId);
    }
            if (reason != null) {
        for (TaskEventListeners taskEventListener : taskEventListeners) {
    public void waitForTaskCompletion(Task task, long untilInNanos) {
            onChildTasksCompleted.run();
     */
            assert acquireAllPermits(); // do not release permits so we can't add tasks to this tracker after draining
 * You may obtain a copy of the License at
    private volatile DiscoveryNodes lastDiscoveryNodes = DiscoveryNodes.EMPTY_NODES;
        final TaskResult taskResult;
        private final CancellableTask task;
            }
        }
            public void onFailure(Exception e) {
    private void registerCancellableTask(Task task) {
                listener.onFailure(e);
        }
                }
        List<Exception> exceptions = new ArrayList<>();
        if (task.supportsResourceTracking()) {
        });
            }
        return Collections.unmodifiableSet(banedParents.keySet());
        default void onTaskCancelled(CancellableTask task) {}
            @Override
                } else {
            @Override
        this.threadPool = threadPool;
            taskResult = task.result(localNode.getId(), error);
    /**
                exceptions.add(e);
            }
        List<Exception> exceptions = new ArrayList<>();
     * <p>
        final CancellableTaskHolder holder = cancellableTasks.get(taskId);
        }
        if (taskResourceTrackingService.get() == null) return () -> {};
            }
     * Unregister the task
        void unregisterChildNode(DiscoveryNode node) {
     */
            public void onResponse(Void aVoid) {
/*
        }
                    assert cancellationListeners == null;
     */
    public Task getTask(long id) {
                    }
import org.opensearch.cluster.ClusterStateApplier;
        if (tracker.registered.compareAndSet(false, true)) {
            }
            if (holder != null) {
                    if (lastDiscoveryNodes.nodeExists(taskId.getNodeId()) == false) {
import org.opensearch.common.util.concurrent.ConcurrentMapLong;
                protected void innerOnResponse(Task task) {
            for (Runnable listener : listeners) {
 *
import java.util.HashMap;
        ThreadContext threadContext = threadPool.getThreadContext();
            listener.run();
                    childTaskCompletedListeners.add(onChildTasksCompleted);
            Task previousTask = tasks.put(task.getId(), task);
 */
import org.opensearch.common.lease.Releasables;
    }
            return;
     *
                    }
                    childTasksPerNode.remove(node);
                    "failed to register a completion listener as task resource tracking has already completed [taskId={}]",
    /**
 *
                @Override
        return channelPendingTaskTrackers.size();
        }
        }
        /**
                        if (cancellationListeners == null) {
        Task task = request.createTask(taskIdGenerator.incrementAndGet(), type, action, request.getParentTask(), headers);
     *
    }
        }
        }
                if (toRun != null) {
     */
                }
import org.opensearch.core.common.unit.ByteSizeValue;
        final Set<CancellableTask> pendingTasks = ConcurrentCollections.newConcurrentSet();
            Exception rootException = null;
            } catch (Exception e) {
     * Cancels a task
    }
import org.opensearch.cluster.node.DiscoveryNode;
        final ChannelPendingTaskTracker tracker = channelPendingTaskTrackers.compute(channel, (k, curr) -> {
                    TaskId taskId = banIterator.next();
                    rootException = ExceptionsHelper.useOrSuppress(rootException, inner);
                }
            }
            logger.warn(() -> new ParameterizedMessage("couldn't store response {}", response), ex);
        return () -> {};
        if (tasks.isEmpty() == false) {
import java.util.Objects;
        private List<Runnable> childTaskCompletedListeners = null;
     * Rest headers that are copied to the task
     * Start rejecting new child requests as the parent task was cancelled.
         * Marks task as finished.
        return cancellableTasks.values().stream().filter(t -> t.hasParent(parentTaskId)).map(t -> t.task).collect(Collectors.toList());
                headerSize += key.length() * 2 + httpHeader.length() * 2;
                        logger.debug(
            curr.addTask(task);
    public static final Setting<Boolean> TASK_RESOURCE_CONSUMERS_ENABLED = Setting.boolSetting(
                }
    }
     */
import java.util.Iterator;
     * pending tasks associated that channel and cancel them as these results won't be retrieved by the parent task.
    /**
        ThreadPool threadPool,
        }
                            "Removing ban for the parent [{}] on the node [{}], reason: the parent node is gone",
            // too early to store anything, shouldn't really be here - just pass the response along
    }
            listener.onFailure(error);
                try {
    public Collection<DiscoveryNode> startBanOnChildrenNodes(long taskId, Runnable onChildTasksCompleted, String reason) {
    private static class CancellableTaskHolder {
        this.taskEventListeners.add(taskEventListeners);
                }
    public void setTaskResultsService(TaskResultsService taskResultsService) {
     * @return a releasable that should be called when this pending task is completed
        }
     *
        CancellableTaskHolder holder = new CancellableTaskHolder(cancellableTask);
            return tasks.remove(task.getId());
        });
        private void notifyListeners(List<Runnable> listeners) {
            taskResult = task.result(localNode.getId(), response);
        }
    public ThreadContext.StoredContext taskExecutionStarted(Task task) {
            return task;
 * GitHub history for details.
                    pendingChildNodes = Set.copyOf(childTasksPerNode.keySet());
    }
                logger.warn(() -> new ParameterizedMessage("couldn't store error {}", ExceptionsHelper.detailedMessage(error)), e);
        return taskResourceTrackingService.get().startTracking(task);
    /**
     * Returns a task with given id, or null if the task is not found.
        }
        }
    private volatile boolean taskResourceConsumersEnabled;
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param taskId                the parent task id
     * Start tracking a cancellable task with its tcp channel, so if the channel gets closed we can get a set of
        .newConcurrentMapLongWithAggressiveConcurrency();
        Set<String> taskHeaders
                listener.onFailure(e);
            assert releasePermit();
        default void onTaskCompleted(Task task) {}
    private final Set<Consumer<Task>> taskResourceConsumer;
            return;
     */
                    pendingChildNodes = Collections.emptySet();
import org.opensearch.cluster.ClusterChangedEvent;
            this.task = task;
import java.util.List;
 * software distributed under the License is distributed on an
                        }
                cancelTasksOnChannelClosed(tracker.drainTasks());
                banChildren = true;
import static org.opensearch.http.HttpTransportSettings.SETTING_HTTP_MAX_HEADER_SIZE;
            service.cancelTaskAndDescendants(task, reason, waitForCompletion, listener);
            }
            }
    }
            logger.trace("register child node [{}] task [{}]", node, taskId);
            return task.getParentTaskId().equals(parentTaskId);
import java.util.concurrent.ConcurrentHashMap;
     * Stores the task result
import org.apache.logging.log4j.LogManager;
     * @return the set of current nodes that have outstanding child tasks
     * If the task is completed or unregistered from TaskManager, then the listener is called immediately.
                @Override
        }
    final int numberOfChannelPendingTaskTrackers() {
     */
        if (task != null) {
     * Returns the list of currently running tasks on the node that can be cancelled
        Set<CancellableTask> drainTasks() {
            task.cancel(reason);
    }
        }
/**
                Thread.sleep(WAIT_FOR_COMPLETION_POLL.millis());
     */
    }
        private Map<DiscoveryNode, Integer> childTasksPerNode = null;
    public Releasable registerChildNode(long taskId, DiscoveryNode node) {
     * @return a list of pending cancellable child tasks
        assert task.getParentTaskId().equals(request.getParentTask()) : "Request [ " + request + "] didn't preserve it parentTaskId";
                    toRun = listener;
     * <p>
            logger.warn(() -> new ParameterizedMessage("couldn't store error {}", ExceptionsHelper.detailedMessage(error)), ex);
    }
 * the Apache License, Version 2.0 (the "License"); you may
     * @param reason                the ban reason
            taskHashMap.put(holder.getTask().getId(), holder.getTask());
                assert removedTracker == tracker;
import org.opensearch.core.Assertions;
import java.util.Set;
            synchronized (this) {
 * Unless required by applicable law or agreed to in writing,
        if (holder != null) {
     * @param task getting executed.
    ) {
    }
                try {
            permits.acquireUninterruptibly(Integer.MAX_VALUE);
        final AtomicBoolean registered = new AtomicBoolean();
        final TaskCancellationService service = cancellationService.get();
import org.opensearch.core.tasks.TaskCancelledException;
                }
        CancellableTaskHolder(CancellableTask task) {
            assert previousTask == null;
import org.opensearch.common.settings.Settings;
import java.util.concurrent.Semaphore;
                    childTaskCompletedListeners = null;
    /**
import java.util.HashSet;
            try {
                listener.onResponse(response);
            // We need to call the listener outside of the synchronised section to avoid potential bottle necks
    /**
        }
            listener.onFailure(ex);
            final List<Runnable> listeners;
            return null;
    /**
    private final SetOnce<TaskResourceTrackingService> taskResourceTrackingService = new SetOnce<>();
     */
        Settings settings,
            assert Thread.holdsLock(this) == false;
                Iterator<TaskId> banIterator = banedParents.keySet().iterator();
        return taskManager;
import java.util.Collection;
        void removeTask(CancellableTask task) {
import org.apache.logging.log4j.Logger;
                } else {
    public List<CancellableTask> setBan(TaskId parentTaskId, String reason) {
                        );
            if (lastDiscoveryNodes.nodeExists(parentTaskId.getNodeId())) {
        if (task instanceof CancellableTask) {
    private final SetOnce<TaskCancellationService> cancellationService = new SetOnce<>();
    /**
            }
            return;
        this.taskResultsService = taskResultsService;
     * Register a node on which a child task will execute. The returned {@link Releasable} must be called
            String reason = banedParents.get(task.getParentTaskId());
                }
                    toRun = () -> {};
        } else {
            assert false : "TaskCancellationService is not initialized";
        DiscoveryNode localNode = lastDiscoveryNodes.getLocalNode();
            }
        ExceptionsHelper.maybeThrowRuntimeAndSuppress(exceptions);
            }
 * under the License.
                    toRun = onChildTasksCompleted;
                        cancellationListeners.add(listener);
        taskResultsService.storeResult(taskResult, new ActionListener<Void>() {
                logger.debug(
                protected void innerOnFailure(Exception e) {
    }
            });
        CancellableTaskHolder holder = cancellableTasks.get(task.getId());
 * license agreements. See the NOTICE file distributed with
                if (cancellationListeners != null) {
import org.opensearch.common.settings.Setting;
        Setting.Property.Dynamic,
        // Should we just swallow such exceptions?
                // Only set the ban if the node is the part of the cluster
                final ChannelPendingTaskTracker removedTracker = channelPendingTaskTrackers.remove(channel);
 * The OpenSearch Contributors require contributions made to
            final boolean removed = pendingTasks.remove(task);
     * Returns the number of currently banned tasks.
    }
    /**
    /**
    }
     * Bans all tasks with the specified parent task from execution, cancels all tasks that are currently executing.
        clusterSettings.addSettingsUpdateConsumer(TASK_RESOURCE_CONSUMERS_ENABLED, taskManager::setTaskResourceConsumersEnabled);
        }
     */
            synchronized (banedParents) {
import org.opensearch.common.lease.Releasable;
    private static class ChannelPendingTaskTracker {
                        banIterator.remove();
        }
 */
                }
    public void setTaskCancellationService(TaskCancellationService taskCancellationService) {
        }
                throw new OpenSearchException("Interrupted waiting for completion of [{}]", e, task);
        logger.trace("unregister task for id: {}", task.getId());
            synchronized (this) {
import org.opensearch.common.util.concurrent.AbstractRunnable;
        } catch (IOException ex) {
                        cancelTaskAndDescendants(task, "channel was closed", false, ActionListener.wrap(() -> {}));
        private boolean finished = false;
            return Collections.emptySet();
    }
            taskHashMap.put(holder.getTask().getId(), holder.getTask());
        }
     */
        assert cancellableTasks.containsKey(task.getId()) : "task [" + task.getId() + "] is not registered yet";
            for (Consumer<Task> taskConsumer : taskResourceConsumer) {
        void cancel(String reason, Runnable listener) {
                    cancellationListeners = null;
        // Throwing exception in case any of the cancellation listener results into exception.
     */
    }
            }
                banedParents.put(parentTaskId, reason);
    private final ByteSizeValue maxHeaderSize;
        }
     * @param onChildTasksCompleted called when all child tasks are completed or failed
    }
    private final ThreadPool threadPool;
                    }
                taskEventListener.onTaskCancelled(task);
        }
            holder.registerChildNode(node);
                } catch (Exception e) {
                exceptions.add(e);
                } else {
        while (System.nanoTime() - untilInNanos < 0) {
                holder.finish();
            final Runnable toRun;
                }
                protected void doRun() {
     */
                }
        } else {
        synchronized (banedParents) {
        }
            } else {
        return startBanOnChildrenNodes(taskId, onChildTasksCompleted, "unknown");
        if (logger.isTraceEnabled()) {
                    throw new IllegalArgumentException("Request exceeded the maximum size of task headers " + maxHeaderSize);
     * This method is called when a previously banned task finally cancelled
    }
            threadPool.generic().execute(new AbstractRunnable() {
        return Collections.unmodifiableMap(taskHashMap);
    }
            holder.cancel(reason, listener);
            try {
    public void cancelTaskAndDescendants(CancellableTask task, String reason, boolean waitForCompletion, ActionListener<Void> listener) {
     */
                while (banIterator.hasNext()) {
    public <Response extends ActionResponse> void storeResult(Task task, Exception error, ActionListener<Response> listener) {
            final boolean added = pendingTasks.add(task);
        }
    public void addTaskEventListeners(TaskEventListeners taskEventListeners) {
     * Takes actions when a task is registered and its execution starts
     */
        }
            }
    /**
            childTasksPerNode.merge(node, 1, Integer::sum);
        for (String key : taskHeaders) {
                    unregister(task);
        Task task = tasks.get(id);
                try {
     * of the current task. Once cancellation of the children tasks is done, the listener is triggered.
        TASK_RESOURCE_CONSUMERS_ATTRIBUTES,
import org.opensearch.transport.TcpChannel;
        }
            assert removed : "task " + task.getId() + " is not in the pending list";
        final Semaphore permits = Assertions.ENABLED ? new Semaphore(Integer.MAX_VALUE) : null;
        }
            }, e -> { assert false : new AssertionError("must not be here", e); }));
            try {
                holder.unregisterChildNode(node);
            }
        } else {
 * Licensed to Elasticsearch under one or more contributor
            }
        Setting.Property.NodeScope
            notifyListeners(listeners);
        if (localNode == null) {
     * Registers a task without parent task
                }
                    throw new TaskCancelledException("Task cancelled before it started: " + reason);
    public TaskManager(Settings settings, ThreadPool threadPool, Set<String> taskHeaders) {
    }
    public Task register(String type, String action, TaskAwareRequest request) {
                } else {
        }
        Map<String, String> headers = new HashMap<>();
    }
                } finally {
            }
    /**
     */
    public interface TaskEventListeners {
    public Map<Long, CancellableTask> getCancellableTasks() {
        if (task instanceof CancellableTask) {
     * <p>
    /**
                }
        logger.trace("removing ban for the parent task {}", parentTaskId);
    public static TaskManager createTaskManagerWithClusterSettings(
            permits.release();
    public void cancel(CancellableTask task, String reason, Runnable listener) {
        if (taskResourceConsumersEnabled) {
import org.opensearch.OpenSearchTimeoutException;
    }
        try {
        task.decrementResourceTrackingThreads();
 *
            if (getTask(task.getId()) == null) {
        try {
import org.opensearch.core.tasks.TaskId;
 * not use this file except in compliance with the License.
        }
                listener.onFailure(error);
                public void onFailure(Exception e) {
                            cancellationListeners = new ArrayList<>();
        // Decrement the task's self-thread as part of unregistration.
        this.taskResourceTrackingService.set(taskResourceTrackingService);
        } else {
            synchronized (this) {
                return null;
        for (TaskEventListeners taskEventListener : taskEventListeners) {
    private void cancelTasksOnChannelClosed(Set<CancellableTask> tasks) {
import org.opensearch.common.settings.ClusterSettings;
    }
                return;
        ClusterSettings clusterSettings,
         */
import org.opensearch.cluster.node.DiscoveryNodes;
    // for testing
            if (childTasksPerNode == null) {
        // Set the ban first, so the newly created tasks cannot be registered
            }
        final TaskResult taskResult;
                lastDiscoveryNodes = event.state().getNodes();
            final List<Runnable> listeners;
        void addTask(CancellableTask task) {
     * Listener that gets invoked during an event such as task cancellation/completion.
                    if (childTaskCompletedListeners == null) {
            }
     * to unregister the child node once the child task is completed or failed.
            });
            try {
        long maxSize = maxHeaderSize.getBytes();
     * Stores the task failure
    private static final Logger logger = LogManager.getLogger(TaskManager.class);
     */
    /**
        } else {
                taskEventListener.onTaskCompleted(task);
     * Returns the list of currently running tasks on the node
    public Task unregister(Task task) {
                if (finished) {
        boolean acquireAllPermits() {
    }
        }
            final Runnable toRun;
            return;
import java.util.Collections;
    }
import org.opensearch.common.SetOnce;
                    holder.cancel(reason);
            logger.trace("cancelling task with id {}", task.getId());
    private static final TimeValue WAIT_FOR_COMPLETION_POLL = timeValueMillis(100);
        if (event.nodesRemoved()) {
                    logger.error("error encountered when updating the consumer", e);
                banReason = reason;
                            event.state().getNodes().getLocalNode()
            CancellableTaskHolder holder = cancellableTasks.remove(task.getId());
        private boolean banChildren = false;
    }
/*
 * specific language governing permissions and limitations
    private final List<TaskEventListeners> taskEventListeners = new ArrayList<>();
            } catch (InterruptedException e) {
            public void onResponse(Void aVoid) {
     * This method is called when a parent task that has children is cancelled.
                if (childTasksPerNode == null) {
        });
import java.util.stream.Collectors;
            registerCancellableTask(task);
            }
    }
        } else {
                    taskConsumer.accept(task);
            } catch (Exception e) {
    /**
                logger.trace("unregister child node [{}] task [{}]", node, taskId);
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
     *
            notifyListeners(listeners);
    public CancellableTask getCancellableTask(long id) {
    private TaskResultsService taskResultsService;
import org.opensearch.core.action.ActionResponse;
import org.opensearch.common.unit.TimeValue;
        public boolean hasParent(TaskId parentTaskId) {
