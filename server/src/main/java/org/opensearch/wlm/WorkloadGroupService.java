                            .append(workloadGroup.getResiliencyMode())
    /**
    }
import org.opensearch.search.backpressure.trackers.NodeDuressTrackers;
            new HashSet<>(),
            return limit * workloadManagementSettings.getNodeLevelCpuRejectionThreshold();
     * Wraps {@code listener} so the request's throttle permit is released <em>before</em> the listener is notified: a
    ) {
            scheduledFuture.cancel();
            .findFirst();
                    workloadGroupState.totalWouldThrottle.inc();
        // or new workloadGroup is being created and has not been acknowledged yet or invalid workload group id
        throw new IllegalArgumentException(resourceType + " is not supported in WLM yet");
        String subfieldPrefix = by + WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_SUBFIELD_DELIMITER;
                if (value.isEmpty() == false && (selected == null || value.compareTo(selected) < 0)) {
                final double threshold = getNormalisedRejectionThreshold(workloadGroup.getResourceLimits().get(resourceType), resourceType);
                onCounted.accept(true);
     * Acquires one node-level throttle permit for the request, or returns {@code null} (nothing to release) when the
 *
        return selected;
    /**
            });
                } else {
            String byValue = resolveThrottleByValue(by, principal);
            return;
            parentAlreadyCounted,
/*
     * coordinator deliberately serialized. The close is guarded so a failed release can never turn a successful search into
        // Detect workload groups deleted in the current cluster state
            // Fail open on a throttle bug. DEBUG, since a deterministic failure would log at full query rate.
    void doRun() {
        if (workloadManagementSettings.getWlmMode() == WlmMode.DISABLED) {
    public WorkloadGroup getWorkloadGroupById(String workloadGroupId) {
        ClusterStateListener,
        }
    /**
    public void onTaskCompleted(Task task) {
                        resourceType
     * exist).
        ThreadPool threadPool,
    /**
                        workloadGroup.getResourceLimits().get(resourceType),
    private String resolveThrottleByValue(String by, String principal) {
            }
                if (wouldThrottleOnly) {
     * This method determines whether the task should be accounted by SBP if both features co-exist
     * Returns the workload group attached to the calling thread context, or null if the current
            if (permit != null) {
    public WorkloadGroup getCurrentWorkloadGroup() {
        }
        // Detect new workload groups added in the current cluster state
        if (principal == null || principal.isEmpty()) {
                    ResourceType.CPU,
            for (ResourceType resourceType : TRACKED_RESOURCES) {
     * @throws OpenSearchRejectedExecutionException if the bucket is already at its node limit
                if (shouldInclude) {
        // Trim the token, not the value: trimming past the delimiter would fold "username|alice " into alice's bucket.
            taskCancellationService,
import org.opensearch.monitor.jvm.JvmStats;
        Optional<WorkloadGroup> optionalWorkloadGroup = activeWorkloadGroups.stream()
            // Nested searches inherit a counted parent's charge. Checked after the early-outs to keep the lookup off unthrottled groups.
            if (!currentWorkloadGroups.containsKey(workloadGroupName)) {
        for (ResourceType resourceType : TRACKED_RESOURCES) {
        }
import org.opensearch.cluster.metadata.WorkloadGroup;
                        break;
            int nodeLimit = WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling);
    @Override
                throw new OpenSearchRejectedExecutionException(
            // Cheap early-out for groups that don't throttle.
                );
import org.opensearch.search.backpressure.trackers.NodeDuressTrackers.NodeDuressTracker;
        WorkloadGroupTask task = (WorkloadGroupTask) t;
import org.opensearch.wlm.stats.WorkloadGroupState;
    @Override
                return permit;
                WorkloadGroup newWorkloadGroup = currentWorkloadGroups.get(workloadGroupName);
 * SPDX-License-Identifier: Apache-2.0
            if (throttling == null || throttling.isEmpty()) {
    public WorkloadGroupStats nodeStats(Set<String> workloadGroupIds, Boolean requestedBreached) {
    private final WorkloadManagementSettings workloadManagementSettings;
            task::setThrottleCounted
                    new NodeDuressTracker(
        String principal,
        return new WorkloadGroupStats(statsHolderMap);
    }
    }
    private final ThreadPool threadPool;
     */
        ClusterService clusterService,
                            .getMem()
    }
            return null;
            workloadGroupsStateAccessor,
import java.io.IOException;
        WorkloadManagementSettings workloadManagementSettings,
            boolean reject = false;
    private final WorkloadGroupsStateAccessor workloadGroupsStateAccessor;
            return limit * workloadManagementSettings.getNodeLevelMemoryRejectionThreshold();
     * {@link AbstractLifecycleComponent} lifecycle method
    private void recordThrottleStat(String workloadGroupId, boolean wouldThrottleOnly) {
                    );
        }
                            .getHeapUsedPercent() / 100.0,
     */
package org.opensearch.wlm;
    Releasable acquireThrottleOrReject(String workloadGroupId, String principal) {
        WorkloadGroupState workloadGroupState = workloadGroupsStateAccessor.getWorkloadGroupState(workloadGroupId);
        if (scheduledFuture != null) {
                && !nodeDuressTrackers.isNodeInDuress())) return;
                            .append(". ");
     * run at regular interval
            }
    ) {
            WorkloadGroup workloadGroup = getWorkloadGroupById(workloadGroupId);
                target += " for " + by + " [" + byValue + "]";
     */
        return acquireThrottleOrReject(workloadGroupId, principal, () -> false, counted -> {});
     * Separator between the segments of a throttle bucket key,
                    throw new ResourceNotFoundException("WorkloadGroup with id " + id + " does not exist");
        }
                    )
        return getWorkloadGroupById(workloadGroupId);
     * Returns the workload group with the given ID, or null if not found.
     */
            }
            }
                .noneMatch(workloadGroup -> workloadGroup.get_id().equals(task.getWorkloadGroupId()));
        // This can happen if the request failed for a deleted workload group
        if (workloadManagementSettings.getWlmMode() != WlmMode.ENABLED) {
        } catch (OpenSearchRejectedExecutionException e) {
    protected void doClose() throws IOException {}
    }
            workloadGroupId = WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get();
        if (!workloadGroupIds.contains("_all")) {
                        workloadManagementSettings::getDuressStreak
                    new NodeDuressTracker(
import java.util.function.BooleanSupplier;
        String finalWorkloadGroupId = workloadGroupId;
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
                    return true;
    ) {
    @Override
        taskCancellationService.pruneDeletedWorkloadGroups(deletedWorkloadGroups);
                    }
     * @param workloadGroupId workload group identifier
        String workloadGroupId = workloadGroupTask.getWorkloadGroupId();
            return null;
     */
        }
            String target = "workload group [" + workloadGroup.getName() + "]";
            }
        boolean exists = activeWorkloadGroups.stream().anyMatch(workloadGroup -> workloadGroup.get_id().equals(finalWorkloadGroupId));
        String selected = null;
import java.util.Optional;
                    workloadGroupState.totalThrottled.inc();
                logger.debug(
     *                             accounting propagates to its own nested searches
        if (WorkloadGroupThrottleSettings.GROUP_SCOPE.equals(by)) {
                }
    /**
     * @param parentAlreadyCounted supplies whether the parent task is already counted, so a nested coordinator search is
     */
        }
     * (actual rejection). Swallows stats failures so they can't mask the request's outcome, and uses the raw state map so a
     * @return if the WorkloadGroup breaches any resource limit based on the LastRecordedUsage
                    }
            final StringBuilder reason = new StringBuilder();
     */
    public static <T> ActionListener<T> releaseThrottlePermitBeforeCompletion(
                WorkloadGroup deletedWorkloadGroup = previousWorkloadGroups.get(workloadGroupName);
     */
import org.opensearch.common.settings.Settings;
        // Retrieve the current and previous cluster states
    }
                }
            existingStateMap.forEach((workloadGroupId, currentState) -> {
                        () -> workloadManagementSettings.getNodeLevelMemoryCancellationThreshold() <= JvmStats.jvmStats()
            }
    public Releasable acquireThrottleOrReject(WorkloadGroupTask task, BooleanSupplier parentAlreadyCounted) {
            // SOFT enforces the throttle too; resiliency_mode only governs resource limits.
            try {
    /**
                        // should not double count even if both the resource limits are breaching
import org.opensearch.wlm.stats.WorkloadGroupStats.WorkloadGroupStatsHolder;
        }
    @Override
    private final WorkloadGroupThrottleTracker throttleTracker = new WorkloadGroupThrottleTracker();
    /**
        return ActionListener.runBefore(listener, () -> {
        this.activeWorkloadGroups = new HashSet<>(currentMetadata.workloadGroups().values());
import org.opensearch.core.action.ActionListener;
            throw new ResourceNotFoundException("WorkloadGroup with id " + id + " does not exist");
    // Node-local in-flight counters per throttle bucket.
        TaskResourceTrackingService.TaskCompletionListener {
            WorkloadGroupState workloadGroupState = workloadGroupsStateAccessor.getWorkloadGroupStateMap().get(workloadGroupId);
                if (!existingStateMap.containsKey(id)) {
     * Resolves the bucket key value: {@link WorkloadGroupThrottleSettings#GROUP_SCOPE} for whole-group throttling, else the
                return null;
            }
            return null;
            String by = WorkloadGroupThrottleSettings.getEffectiveBy(throttling);
     */
                recordThrottleStat(workloadGroupId, true);
            String bucketKey = workloadGroupId + BUCKET_KEY_DELIMITER + by + BUCKET_KEY_DELIMITER + byValue;
    private final NodeDuressTrackers nodeDuressTrackers;
            return null;
            task.getWorkloadGroupId(),
    public WorkloadGroupService(
            return;
            String trimmed = token.trim();
import java.util.Map;
        return acquireThrottleOrReject(
            if (WorkloadGroupThrottleSettings.GROUP_SCOPE.equals(by) == false) {
        }
        return deletedWorkloadGroups;
        this.clusterService = clusterService;
            logger.warn("Failed to record throttle stat for workload group [" + workloadGroupId + "]", statsException);
                workloadGroupState.totalRejections.inc();
        // set the default workloadGroupId if not existing in the active workload groups
                            .append(" < ")
            }
                if (threshold < lastRecordedUsage) {
 * As of now this is a stub and main implementation PR will be raised soon.Coming PR will collate these changes with core WorkloadGroupService changes
    }
        WorkloadGroup workloadGroup = clusterService.state().metadata().workloadGroups().get(id);
    public void incrementFailuresFor(final String workloadGroupId) {
            }
import org.opensearch.ResourceNotFoundException;
                }
            && (optionalWorkloadGroup.get().getResiliencyMode() == MutableWorkloadGroupFragment.ResiliencyMode.SOFT
        }
     * @param workloadGroupId workload group identifier
        Metadata currentMetadata = event.state().metadata();
    static final String BUCKET_KEY_DELIMITER = ":";
                workloadGroupsStateAccessor.addNewWorkloadGroup(newWorkloadGroup.get_id());
                    "Request would be throttled (monitor mode, not rejected): {} reached its per-node limit of {} concurrent requests.",
            new NodeDuressTrackers(
            .filter(x -> x.get_id().equals(workloadGroupId))
            try {
                // Perform any necessary actions with the deleted workload group
        return false;
}
        // or new workloadGroup is being created and has not been acknowledged yet
    public boolean shouldSBPHandle(Task t) {
        }
                        reject = true;
     * request does not map to a workload group (no header set, or the referenced group does not
        this(
        WorkloadGroupTaskCancellationService taskCancellationService,
     * @param principal       the caller's joined principal tokens, or {@code null} (see resolver)
    @Override
    }
     * sub-search from the previous one's response handler), so releasing after would spuriously 429 a request the
        });
                        statsHolderMap.put(workloadGroupId, WorkloadGroupStatsHolder.from(currentState));
     *
import java.util.HashMap;
    private volatile Scheduler.Cancellable scheduledFuture;
        this.nodeDuressTrackers = nodeDuressTrackers;
                // Workload group deleted
     * {@link #resolveThrottleByValue}), or a parent task whose work is already counted. The bucket is group-scoped when
     */
                    final double threshold = getNormalisedRejectionThreshold(
    public boolean resourceLimitBreached(String id, WorkloadGroupState currentState) {
                // Perform any necessary actions with the new workload group
                return null;
     * updates the failure stats for the workload group
                            .getProcessCpuPercent() / 100.0,
        if (workloadGroupState == null) {
        try {
        }
import org.opensearch.tasks.TaskResourceTrackingService;
                    ),
                return null;
        scheduledFuture = threadPool.scheduleWithFixedDelay(() -> {
                            .append(workloadGroup.get_id())
    }
    }
     * a client-visible error.
        } else if (resourceType == ResourceType.MEMORY) {
 * @opensearch.experimental
        String workloadGroupId,
    /**
            }
                doRun();
        try {
    private static final Logger logger = LogManager.getLogger(WorkloadGroupService.class);
     * @param throttlePermit the permit acquired by {@link #acquireThrottleOrReject(WorkloadGroupTask, BooleanSupplier)}
public class WorkloadGroupService extends AbstractLifecycleComponent
        });
                onCounted.accept(true);
        for (String workloadGroupName : currentWorkloadGroups.keySet()) {
     *
import java.util.HashSet;
            throw new OpenSearchRejectedExecutionException(
            return null;
                        reason.append(resourceType)
                String value = trimmed.substring(subfieldPrefix.length());
     *
                logger.debug("Exception occurred in Workload Group service", e);
     */
                    ResourceType.MEMORY,
     */
import org.opensearch.cluster.service.ClusterService;
        if (optionalWorkloadGroup.isPresent()
        this.threadPool = threadPool;
import org.opensearch.common.lease.Releasable;
        }
        workloadGroupsStateAccessor.getWorkloadGroupState(workloadGroupId).totalCompletions.inc();
    /**
        Map<String, WorkloadGroup> previousWorkloadGroups = previousMetadata.workloadGroups();
    }
     * @param listener       the listener to notify once the permit has been given back
        return workloadManagementSettings.getWlmMode() != WlmMode.ENABLED || isInvalidWorkloadGroupTask;
/**
        return clusterService.state().metadata().workloadGroups().get(workloadGroupId);
        if (workloadManagementSettings.getWlmMode() != WlmMode.ENABLED) {
                if (workloadGroup.getResourceLimits().containsKey(resourceType)) {
            if (parentAlreadyCounted.getAsBoolean()) {
        if (!(task instanceof WorkloadGroupTask workloadGroupTask) || !workloadGroupTask.isWorkloadGroupSet()) {
        final Releasable throttlePermit
import org.opensearch.monitor.process.ProcessProbe;
    }
        }
    }
        if (resourceType == ResourceType.CPU) {
        this.workloadGroupsStateAccessor.addNewWorkloadGroup(WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get());
            threadPool,
        Map<String, WorkloadGroupState> existingStateMap = workloadGroupsStateAccessor.getWorkloadGroupStateMap();
                    "WorkloadGroup " + workloadGroupId + " is already contended. " + reason.toString()
            if (workloadGroup.getResiliencyMode() == MutableWorkloadGroupFragment.ResiliencyMode.MONITOR) {
        final ActionListener<T> listener,
     * @return node level workload group stats
            }
     *
     * @return the WorkloadGroup or null
            } catch (Exception e) {
        }, this.workloadManagementSettings.getWorkloadGroupServiceRunInterval(), ThreadPool.Names.GENERIC);
        }
            return;
            if (workloadGroup.getResourceLimits().containsKey(resourceType)) {
     * not-yet-registered group isn't misattributed to DEFAULT.
    public void rejectIfNeeded(String workloadGroupId) {
            for (String id : workloadGroupIds) {
        this.activeWorkloadGroups = activeWorkloadGroups;
    private double getNormalisedRejectionThreshold(double limit, ResourceType resourceType) {
    private Set<WorkloadGroup> activeWorkloadGroups;
                logger.warn("Failed to release WLM throttle permit", e);
        taskCancellationService.cancelTasks(nodeDuressTrackers::isNodeInDuress, activeWorkloadGroups, deletedWorkloadGroups);
                // New workload group detected
                "Request throttled: " + target + " reached its per-node limit of " + nodeLimit + " concurrent requests."
import java.util.function.Consumer;
     * Bumps {@code total_would_throttle} ({@code wouldThrottleOnly == true}, MONITOR observed) or {@code total_throttled}
import org.opensearch.wlm.cancellation.WorkloadGroupTaskCancellationService;
        }
        this.clusterService.addListener(this);
import java.util.Set;
    implements
                            .append(", ")
        boolean isInvalidWorkloadGroupTask = true;
        for (String token : principal.split(WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER)) {
            // Name the group and dimension; the bucket key alone is opaque to an operator.
    }
    public Set<WorkloadGroup> getActiveWorkloadGroups() {
        optionalWorkloadGroup.ifPresent(workloadGroup -> {
                    target,
        Set<WorkloadGroup> deletedWorkloadGroups
            if (byValue == null) {
            if (trimmed.startsWith(subfieldPrefix)) {
                return null;
            if (!previousWorkloadGroups.containsKey(workloadGroupName)) {
        return activeWorkloadGroups;
        WorkloadGroupsStateAccessor workloadGroupsStateAccessor
    }
        } catch (Exception e) {
        workloadGroupState.failures.inc();
                    if (requestedBreached == null || requestedBreached == resourceLimitBreached(workloadGroupId, currentState)) {
    public WorkloadGroupService(
    }
import org.opensearch.threadpool.Scheduler;
     * @return a permit to close on request completion, or {@code null} if not throttled
            }
     * principal's {@code username}/{@code role} value. When a principal carries several values for the subfield (a user in
     * many roles), the lexicographically smallest is chosen so the same caller lands in a stable bucket.
            if (workloadGroup == null) {
import org.opensearch.cluster.ClusterChangedEvent;
            }
                        () -> workloadManagementSettings.getNodeLevelCpuCancellationThreshold() < ProcessProbe.getInstance()
        ClusterService clusterService,
        if (task.isWorkloadGroupSet() && !WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get().equals(task.getWorkloadGroupId())) {
import org.opensearch.wlm.stats.WorkloadGroupStats;
     * @param workloadGroupId the workload group identifier
    protected void doStop() {
 * compatible open source license.
     * @param t WorkloadGroupTask
                    selected = value;
                        workloadManagementSettings::getDuressStreak
        activeWorkloadGroups.forEach(workloadGroup -> this.workloadGroupsStateAccessor.addNewWorkloadGroup(workloadGroup.get_id()));
                boolean shouldInclude = workloadGroupIds.contains("_all") || workloadGroupIds.contains(workloadGroupId);
        // rejections will not happen for SOFT mode WorkloadGroups unless node is in duress
import org.opensearch.cluster.ClusterStateListener;
                            .append(threshold)
            ),
                }
import org.opensearch.tasks.Task;
        if (workloadGroupState == null) {
 */
    /**
                workloadGroupsStateAccessor.removeWorkloadGroup(deletedWorkloadGroup.get_id());
            logger.debug(() -> "Skipping node-level throttle for workload group [" + workloadGroupId + "] due to an error", e);
            if (workloadGroupState != null) {
        } catch (Exception statsException) {
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        }
            Releasable permit = throttleTracker.tryAcquire(bucketKey, nodeLimit);
        }
     * {@link WorkloadGroupThrottleSettings#ALLOWED_BY_VALUES}, and only the trailing segment is caller-supplied.
        if (existingStateMap != null) {
    }
     * completion listener may synchronously start new work in the same bucket (an {@code _msearch} dispatches its next
        if (!exists) {
        // Extract the workload groups from both the current and previous cluster states
        if (workloadGroupId == null || workloadGroupId.equals(WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get())) {
import org.opensearch.cluster.metadata.Metadata;
     * Test seam over {@link #acquireThrottleOrReject(WorkloadGroupTask, BooleanSupplier)} exercising bucket resolution and
            isInvalidWorkloadGroupTask = activeWorkloadGroups.stream()
    public Set<WorkloadGroup> getDeletedWorkloadGroups() {
    protected void doStart() {
     * @return the bucket dimension value, or {@code null} to fail open when the principal has no usable value
     *
        );
                );
            }
                    if (threshold < lastRecordedUsage) {
     *                             not on every search
 */
        String workloadGroupId = threadPool.getThreadContext().getHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER);
     * the limit directly, without a task or thread context. Package-private: production callers use the task-aware variant
        }
                    final double lastRecordedUsage = workloadGroupState.getResourceState().get(resourceType).getLastRecordedUsage();
                )
     * @throws OpenSearchRejectedExecutionException if the bucket is already at its node limit
        Metadata previousMetadata = event.previousState().metadata();
    }
    private final ClusterService clusterService;
                final double lastRecordedUsage = currentState.getResourceState().get(resourceType).getLastRecordedUsage();
        // This can happen if the request failed for a deleted workload group
                }
        BooleanSupplier parentAlreadyCounted,
    /**
                this.deletedWorkloadGroups.add(deletedWorkloadGroup);
            task.getThrottlePrincipal(),
        }
        }
            }
    /**
                            .append(" limit is breaching for workload group ")
        WorkloadGroupsStateAccessor workloadGroupsStateAccessor,
        this.taskCancellationService = taskCancellationService;
        for (String workloadGroupName : previousWorkloadGroups.keySet()) {
    private Releasable acquireThrottleOrReject(
        if (workloadGroupId == null) {
        WorkloadManagementSettings workloadManagementSettings,
        final Map<String, WorkloadGroupStatsHolder> statsHolderMap = new HashMap<>();
     */
            }
            throw e; // the intended 429
    }
                    nodeLimit
        if (workloadGroupId == null || workloadGroupId.equals(WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get())) return;
        this.deletedWorkloadGroups = deletedWorkloadGroups;
    }
     * {@code throttling.by} is absent, or subdivided by its explicit {@code username}/{@code role} value.
     */
            );
        NodeDuressTrackers nodeDuressTrackers,
     * {@code <workload_group_id><delimiter><dimension><delimiter><dimension_value>}. Safe as a separator because no
            Settings throttling = workloadGroup.getMutableWorkloadGroupFragment().getThrottling();
            // No bucket (e.g. username/role with no principal): fail open.
            } catch (Exception e) {
                Map.of(
                }
    }
                // MONITOR: count in total_would_throttle and admit.
            workloadManagementSettings,
        WorkloadGroupTaskCancellationService taskCancellationService,
     * @return whether or not SBP handle it
        Consumer<Boolean> onCounted
        this.workloadGroupsStateAccessor = workloadGroupsStateAccessor;
                            .append(", wlm mode is ")
     * @param workloadGroupId the workload group the request is assigned to
                            .append(lastRecordedUsage)
import static org.opensearch.wlm.tracker.WorkloadGroupResourceUsageTrackerService.TRACKED_RESOURCES;
     * so the request is marked counted and re-entrancy is handled.
    /**
import org.apache.logging.log4j.Logger;
            return;
    }
import org.apache.logging.log4j.LogManager;
    }
            if (reject) {
            }
     *                             not charged twice. Supplied lazily so the parent lookup runs only for a throttling group,
        Set<WorkloadGroup> activeWorkloadGroups,
     */
            if (nodeLimit < 1) {
            clusterService,
     * request is not throttled: WLM disabled, default/unknown group, no {@code node_limit}, no resolvable bucket (see
                return null;
        this.workloadManagementSettings = workloadManagementSettings;
        Map<String, WorkloadGroup> currentWorkloadGroups = currentMetadata.workloadGroups();
     * @param task                 the request's task; marked as counted in both the acquired and the exempted case, so the
        ThreadPool threadPool,
 * The OpenSearch Contributors require contributions made to
        );
            }
     * segment can contain it: the id is a base64 UUID, the dimension is the internal group scope or one of
     * @return a permit to close on request completion, or {@code null} if not throttled
import org.opensearch.threadpool.ThreadPool;
    /**
    public void clusterChanged(ClusterChangedEvent event) {
            recordThrottleStat(workloadGroupId, false);
                return null;
            new HashSet<>()
    private final Set<WorkloadGroup> deletedWorkloadGroups;
 * this file be licensed under the Apache-2.0 license or a
    private final WorkloadGroupTaskCancellationService taskCancellationService;
        if (workloadGroup == null) {
        }
    /**
                throttlePermit.close();
            return WorkloadGroupThrottleSettings.GROUP_SCOPE;
            return;
        }
    ) {
                        workloadGroupState.getResourceState().get(resourceType).rejections.inc();
                onCounted.accept(true);
        WorkloadGroupState workloadGroupState = workloadGroupsStateAccessor.getWorkloadGroupState(workloadGroupId);
