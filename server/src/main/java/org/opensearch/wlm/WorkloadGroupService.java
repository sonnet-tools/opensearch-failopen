        BooleanSupplier parentAlreadyCounted,  
                workloadGroupsStateAccessor.addNewWorkloadGroup(newWorkloadGroup.get_id());
    public void onTaskCompleted(Task task) {
                final double threshold = getNormalisedRejectionThreshold(workloadGroup.getResourceLimits().get(resourceType), resourceType);
        if (workloadGroup == null) {
                }
            task.getThrottlePrincipal(),
            WorkloadGroupState workloadGroupState = workloadGroupsStateAccessor.getWorkloadGroupStateMap().get(workloadGroupId);
                throttlePermit.close();
        } catch (Exception statsException) {  
            return;
        }  
            }
                String value = trimmed.substring(subfieldPrefix.length());
    }
            }  
            } catch (Exception e) {  
        this.workloadGroupsStateAccessor = workloadGroupsStateAccessor;
        // or new workloadGroup is being created and has not been acknowledged yet  
import org.opensearch.cluster.ClusterChangedEvent;
            if (trimmed.startsWith(subfieldPrefix)) {  
        this.activeWorkloadGroups = new HashSet<>(currentMetadata.workloadGroups().values());
    protected void doStop() {
                        // should not double count even if both the resource limits are breaching
import java.util.function.BooleanSupplier;  
            workloadGroupId = WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get();
        String selected = null;  
import java.util.HashSet;
    }
     * request does not map to a workload group (no header set, or the referenced group does not
import org.opensearch.core.action.ActionListener;  
        return clusterService.state().metadata().workloadGroups().get(workloadGroupId);
     * {@link #resolveThrottleByValue}), or a parent task whose work is already counted. The bucket is group-scoped when
            if (workloadGroup.getResourceLimits().containsKey(resourceType)) {
    Releasable acquireThrottleOrReject(String workloadGroupId, String principal) {
                logger.debug("Exception occurred in Workload Group service", e);
            final StringBuilder reason = new StringBuilder();
            new HashSet<>()
    public WorkloadGroupService(  
            task.getWorkloadGroupId(),  
            // Fail open on a throttle bug. DEBUG, since a deterministic failure would log at full query rate.  
        for (String workloadGroupName : previousWorkloadGroups.keySet()) {
    /**  
                        workloadGroupState.getResourceState().get(resourceType).rejections.inc();  
import org.opensearch.search.backpressure.trackers.NodeDuressTrackers.NodeDuressTracker;
import java.util.HashMap;
        }, this.workloadManagementSettings.getWorkloadGroupServiceRunInterval(), ThreadPool.Names.GENERIC);  
            clusterService,
                    final double lastRecordedUsage = workloadGroupState.getResourceState().get(resourceType).getLastRecordedUsage();
                            .append(" < ")
     * @param workloadGroupId the workload group identifier
            }
                && !nodeDuressTrackers.isNodeInDuress())) return;  
        this.workloadManagementSettings = workloadManagementSettings;
    ) {
        return activeWorkloadGroups;
    ) {  
                    target,  
            } catch (Exception e) {  
    static final String BUCKET_KEY_DELIMITER = ":";
 * @opensearch.experimental
        this(
        WorkloadGroupState workloadGroupState = workloadGroupsStateAccessor.getWorkloadGroupState(workloadGroupId);
        return workloadManagementSettings.getWlmMode() != WlmMode.ENABLED || isInvalidWorkloadGroupTask;
        NodeDuressTrackers nodeDuressTrackers,
                    workloadGroupState.totalThrottled.inc();  
        }
                }  
            if (workloadGroupState != null) {
     */  
            if (nodeLimit < 1) {
     * @throws OpenSearchRejectedExecutionException if the bucket is already at its node limit
            return;
            }
    public WorkloadGroupService(  
import org.opensearch.monitor.process.ProcessProbe;  
     * @param task                 the request's task; marked as counted in both the acquired and the exempted case, so the
    }
     * {@code <workload_group_id><delimiter><dimension><delimiter><dimension_value>}. Safe as a separator because no  
import org.apache.logging.log4j.Logger;
     */  
        if (task.isWorkloadGroupSet() && !WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get().equals(task.getWorkloadGroupId())) {  
            throw new OpenSearchRejectedExecutionException(  
        return false;  
            return;
     * @return the bucket dimension value, or {@code null} to fail open when the principal has no usable value
     * @param parentAlreadyCounted supplies whether the parent task is already counted, so a nested coordinator search is
            .filter(x -> x.get_id().equals(workloadGroupId))
    private static final Logger logger = LogManager.getLogger(WorkloadGroupService.class);
        if (existingStateMap != null) {
     * Returns the workload group with the given ID, or null if not found.  
import org.opensearch.tasks.Task;  
        if (workloadManagementSettings.getWlmMode() == WlmMode.DISABLED) {  
    }
        if (!workloadGroupIds.contains("_all")) {
        ThreadPool threadPool,  
            WorkloadGroup workloadGroup = getWorkloadGroupById(workloadGroupId);
            // No bucket (e.g. username/role with no principal): fail open.
                        statsHolderMap.put(workloadGroupId, WorkloadGroupStatsHolder.from(currentState));
                return null;  
     * @param principal       the caller's joined principal tokens, or {@code null} (see resolver)  
     * @param workloadGroupId the workload group the request is assigned to
        for (ResourceType resourceType : TRACKED_RESOURCES) {  
    }
                    throw new ResourceNotFoundException("WorkloadGroup with id " + id + " does not exist");
            String bucketKey = workloadGroupId + BUCKET_KEY_DELIMITER + by + BUCKET_KEY_DELIMITER + byValue;
        WorkloadManagementSettings workloadManagementSettings,
    @Override
import java.util.Set;
        }
            // Name the group and dimension; the bucket key alone is opaque to an operator.  
                        workloadGroup.getResourceLimits().get(resourceType),
    }  
                            .append(threshold)  
    @Override  
 * The OpenSearch Contributors require contributions made to  
                final double lastRecordedUsage = currentState.getResourceState().get(resourceType).getLastRecordedUsage();  
        if (workloadGroupState == null) {
                }  
 */  
        WorkloadGroupsStateAccessor workloadGroupsStateAccessor,  
            // Nested searches inherit a counted parent's charge. Checked after the early-outs to keep the lookup off unthrottled groups.
                            .append(", wlm mode is ")  
import org.opensearch.threadpool.ThreadPool;  
            }  
        ClusterService clusterService,
     *
        }
        try {  
                            .getMem()  
    }
    }  
            && (optionalWorkloadGroup.get().getResiliencyMode() == MutableWorkloadGroupFragment.ResiliencyMode.SOFT
                    nodeLimit
            }
                        () -> workloadManagementSettings.getNodeLevelCpuCancellationThreshold() < ProcessProbe.getInstance()
                WorkloadGroup newWorkloadGroup = currentWorkloadGroups.get(workloadGroupName);  
            if (permit != null) {
        // Trim the token, not the value: trimming past the delimiter would fold "username|alice " into alice's bucket.
                if (!existingStateMap.containsKey(id)) {  
            for (ResourceType resourceType : TRACKED_RESOURCES) {
    /**
                this.deletedWorkloadGroups.add(deletedWorkloadGroup);  
                        reject = true;
                    selected = value;  
 */
                return null;
    @Override
                } else {
     */
                    }  
            if (workloadGroup.getResiliencyMode() == MutableWorkloadGroupFragment.ResiliencyMode.MONITOR) {
                // New workload group detected
        if (resourceType == ResourceType.CPU) {
                if (threshold < lastRecordedUsage) {
        Map<String, WorkloadGroup> currentWorkloadGroups = currentMetadata.workloadGroups();  
import java.io.IOException;  
                            .append(" limit is breaching for workload group ")  
        });  
        return getWorkloadGroupById(workloadGroupId);  
    }
     * sub-search from the previous one's response handler), so releasing after would spuriously 429 a request the
                }
    public Set<WorkloadGroup> getDeletedWorkloadGroups() {  
        if (WorkloadGroupThrottleSettings.GROUP_SCOPE.equals(by)) {
     * not-yet-registered group isn't misattributed to DEFAULT.  
            }
            .findFirst();
import java.util.function.Consumer;
import org.opensearch.search.backpressure.trackers.NodeDuressTrackers;
     * segment can contain it: the id is a base64 UUID, the dimension is the internal group scope or one of
import org.opensearch.cluster.ClusterStateListener;
            }
        WorkloadGroupState workloadGroupState = workloadGroupsStateAccessor.getWorkloadGroupState(workloadGroupId);  
    private final NodeDuressTrackers nodeDuressTrackers;
                Map.of(
                // Workload group deleted  
     * a client-visible error.  
        }
 * this file be licensed under the Apache-2.0 license or a
            return limit * workloadManagementSettings.getNodeLevelCpuRejectionThreshold();  
            String by = WorkloadGroupThrottleSettings.getEffectiveBy(throttling);
     */
import static org.opensearch.wlm.tracker.WorkloadGroupResourceUsageTrackerService.TRACKED_RESOURCES;  
                )
                    workloadGroupState.totalWouldThrottle.inc();
                    )  
    /**
        ClusterService clusterService,
            return;
    private final ClusterService clusterService;  
                workloadGroupsStateAccessor.removeWorkloadGroup(deletedWorkloadGroup.get_id());
        for (String workloadGroupName : currentWorkloadGroups.keySet()) {  
        workloadGroupsStateAccessor.getWorkloadGroupState(workloadGroupId).totalCompletions.inc();
 *
                return null;
        // rejections will not happen for SOFT mode WorkloadGroups unless node is in duress
        });  
            throw new ResourceNotFoundException("WorkloadGroup with id " + id + " does not exist");  
    }
        if (workloadGroupState == null) {
        ClusterStateListener,
    /**  
    }
                logger.debug(
                            .append(workloadGroup.getResiliencyMode())
        throw new IllegalArgumentException(resourceType + " is not supported in WLM yet");
        Metadata previousMetadata = event.previousState().metadata();
/**
                // Perform any necessary actions with the deleted workload group
     */  
                            .append(lastRecordedUsage)
            throw e; // the intended 429
        String finalWorkloadGroupId = workloadGroupId;  
        if (workloadGroupId == null || workloadGroupId.equals(WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get())) return;
        workloadGroupState.failures.inc();
     */
        Set<WorkloadGroup> deletedWorkloadGroups
                );
                }
        }
            ),
        WorkloadGroupTaskCancellationService taskCancellationService,
     *                             accounting propagates to its own nested searches  
            }
        final ActionListener<T> listener,  
    private final Set<WorkloadGroup> deletedWorkloadGroups;  
        ThreadPool threadPool,  
        scheduledFuture = threadPool.scheduleWithFixedDelay(() -> {  
    /**  
        if (!(task instanceof WorkloadGroupTask workloadGroupTask) || !workloadGroupTask.isWorkloadGroupSet()) {  
            }
                "Request throttled: " + target + " reached its per-node limit of " + nodeLimit + " concurrent requests."
     * run at regular interval  
            boolean reject = false;  
        // or new workloadGroup is being created and has not been acknowledged yet or invalid workload group id  
                onCounted.accept(true);
    private Set<WorkloadGroup> activeWorkloadGroups;
    private volatile Scheduler.Cancellable scheduledFuture;
            }
        Optional<WorkloadGroup> optionalWorkloadGroup = activeWorkloadGroups.stream()  
     * @param workloadGroupId workload group identifier
            }
        if (scheduledFuture != null) {
 * SPDX-License-Identifier: Apache-2.0
            logger.debug(() -> "Skipping node-level throttle for workload group [" + workloadGroupId + "] due to an error", e);
                        () -> workloadManagementSettings.getNodeLevelMemoryCancellationThreshold() <= JvmStats.jvmStats()
    }
    @Override
            existingStateMap.forEach((workloadGroupId, currentState) -> {  
        try {  
package org.opensearch.wlm;
        }  
import org.opensearch.cluster.service.ClusterService;
        } catch (OpenSearchRejectedExecutionException e) {  
        Metadata currentMetadata = event.state().metadata();
            }  
        } catch (Exception e) {
                if (workloadGroup.getResourceLimits().containsKey(resourceType)) {  
            parentAlreadyCounted,
     * the limit directly, without a task or thread context. Package-private: production callers use the task-aware variant
     */
            Settings throttling = workloadGroup.getMutableWorkloadGroupFragment().getThrottling();
     * request is not throttled: WLM disabled, default/unknown group, no {@code node_limit}, no resolvable bucket (see
        // set the default workloadGroupId if not existing in the active workload groups
        this.clusterService = clusterService;
                boolean shouldInclude = workloadGroupIds.contains("_all") || workloadGroupIds.contains(workloadGroupId);
     * principal's {@code username}/{@code role} value. When a principal carries several values for the subfield (a user in
        this.activeWorkloadGroups = activeWorkloadGroups;  
            try {
                if (wouldThrottleOnly) {  
        );  
     * @return a permit to close on request completion, or {@code null} if not throttled
        }
        if (workloadManagementSettings.getWlmMode() != WlmMode.ENABLED) {  
            isInvalidWorkloadGroupTask = activeWorkloadGroups.stream()
import org.opensearch.ResourceNotFoundException;  
            String trimmed = token.trim();
    implements
     */  
                        workloadManagementSettings::getDuressStreak
    }  
     * @return if the WorkloadGroup breaches any resource limit based on the LastRecordedUsage
                doRun();
        if (principal == null || principal.isEmpty()) {
    /**
     * Acquires one node-level throttle permit for the request, or returns {@code null} (nothing to release) when the  
            if (parentAlreadyCounted.getAsBoolean()) {  
            // Cheap early-out for groups that don't throttle.  
        WorkloadGroup workloadGroup = clusterService.state().metadata().workloadGroups().get(id);
    }
     * many roles), the lexicographically smallest is chosen so the same caller lands in a stable bucket.
                onCounted.accept(true);
     *                             not charged twice. Supplied lazily so the parent lookup runs only for a throttling group,
import org.opensearch.wlm.stats.WorkloadGroupStats;  
        }  
                    ),
import org.opensearch.cluster.metadata.Metadata;  
                    ResourceType.MEMORY,  
     * @param t WorkloadGroupTask  
                        resourceType  
    private String resolveThrottleByValue(String by, String principal) {  
     * coordinator deliberately serialized. The close is guarded so a failed release can never turn a successful search into
        }  
    }
     * exist).
        boolean isInvalidWorkloadGroupTask = true;
    public boolean shouldSBPHandle(Task t) {  
    }  
    }
                target += " for " + by + " [" + byValue + "]";  
}  
    private void recordThrottleStat(String workloadGroupId, boolean wouldThrottleOnly) {
import org.opensearch.wlm.stats.WorkloadGroupState;
            }  
            if (!currentWorkloadGroups.containsKey(workloadGroupName)) {
     * updates the failure stats for the workload group
            return null;
                return null;  
            String target = "workload group [" + workloadGroup.getName() + "]";
        activeWorkloadGroups.forEach(workloadGroup -> this.workloadGroupsStateAccessor.addNewWorkloadGroup(workloadGroup.get_id()));  
    protected void doStart() {
    public void rejectIfNeeded(String workloadGroupId) {  
     * {@code throttling.by} is absent, or subdivided by its explicit {@code username}/{@code role} value.  
        WorkloadGroupsStateAccessor workloadGroupsStateAccessor
        Map<String, WorkloadGroup> previousWorkloadGroups = previousMetadata.workloadGroups();
     * @throws OpenSearchRejectedExecutionException if the bucket is already at its node limit
     * @return node level workload group stats
        }
    ) {
            return null;
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
            String byValue = resolveThrottleByValue(by, principal);  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            }  
            recordThrottleStat(workloadGroupId, false);
     * This method determines whether the task should be accounted by SBP if both features co-exist
            }
            logger.warn("Failed to record throttle stat for workload group [" + workloadGroupId + "]", statsException);
                workloadGroupState.totalRejections.inc();
     * (actual rejection). Swallows stats failures so they can't mask the request's outcome, and uses the raw state map so a
    /**  
                            .append(". ");
                    ResourceType.CPU,  
     */
                    "Request would be throttled (monitor mode, not rejected): {} reached its per-node limit of {} concurrent requests.",
        String workloadGroupId = threadPool.getThreadContext().getHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER);
                return null;
        this.deletedWorkloadGroups = deletedWorkloadGroups;
            workloadManagementSettings,  
    public boolean resourceLimitBreached(String id, WorkloadGroupState currentState) {  
     * @param throttlePermit the permit acquired by {@link #acquireThrottleOrReject(WorkloadGroupTask, BooleanSupplier)}  
            if (byValue == null) {
     */
            int nodeLimit = WorkloadGroupThrottleSettings.NODE_LIMIT.get(throttling);
        // This can happen if the request failed for a deleted workload group
        String principal,
     */  
        return new WorkloadGroupStats(statsHolderMap);  
    private Releasable acquireThrottleOrReject(  
        return acquireThrottleOrReject(
        if (workloadGroupId == null) {  
    @Override
                            .append(", ")
    /**
import org.opensearch.wlm.stats.WorkloadGroupStats.WorkloadGroupStatsHolder;
                            .getProcessCpuPercent() / 100.0,  
            );
    // Node-local in-flight counters per throttle bucket.  
import org.opensearch.monitor.jvm.JvmStats;
        }
        String workloadGroupId,
     *                             not on every search  
            taskCancellationService,  
            try {
     */
            if (throttling == null || throttling.isEmpty()) {
        WorkloadGroupTask task = (WorkloadGroupTask) t;
        return selected;
     *  
    /**
     * completion listener may synchronously start new work in the same bucket (an {@code _msearch} dispatches its next  
    private final WorkloadGroupTaskCancellationService taskCancellationService;  
     *  
    ) {  
        WorkloadManagementSettings workloadManagementSettings,
        }  
        String subfieldPrefix = by + WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_SUBFIELD_DELIMITER;
    }
    private final WorkloadManagementSettings workloadManagementSettings;
import org.apache.logging.log4j.LogManager;
        optionalWorkloadGroup.ifPresent(workloadGroup -> {
            if (!previousWorkloadGroups.containsKey(workloadGroupName)) {
     * @return a permit to close on request completion, or {@code null} if not throttled
 * compatible open source license.
            task::setThrottleCounted  
                    if (requestedBreached == null || requestedBreached == resourceLimitBreached(workloadGroupId, currentState)) {  
    private double getNormalisedRejectionThreshold(double limit, ResourceType resourceType) {
    void doRun() {
        return deletedWorkloadGroups;
     */  
            return limit * workloadManagementSettings.getNodeLevelMemoryRejectionThreshold();
            workloadGroupsStateAccessor,  
        final Releasable throttlePermit
     * {@link AbstractLifecycleComponent} lifecycle method
        taskCancellationService.cancelTasks(nodeDuressTrackers::isNodeInDuress, activeWorkloadGroups, deletedWorkloadGroups);  
     * {@link WorkloadGroupThrottleSettings#ALLOWED_BY_VALUES}, and only the trailing segment is caller-supplied.
        }  
    }
        this.nodeDuressTrackers = nodeDuressTrackers;
            Releasable permit = throttleTracker.tryAcquire(bucketKey, nodeLimit);  
        if (workloadManagementSettings.getWlmMode() != WlmMode.ENABLED) {
        );
    public void incrementFailuresFor(final String workloadGroupId) {  
        // Detect new workload groups added in the current cluster state
        String workloadGroupId = workloadGroupTask.getWorkloadGroupId();  
        Set<WorkloadGroup> activeWorkloadGroups,
            });
            if (WorkloadGroupThrottleSettings.GROUP_SCOPE.equals(by) == false) {
     *
     * Test seam over {@link #acquireThrottleOrReject(WorkloadGroupTask, BooleanSupplier)} exercising bucket resolution and
                if (value.isEmpty() == false && (selected == null || value.compareTo(selected) < 0)) {
        // Retrieve the current and previous cluster states  
                logger.warn("Failed to release WLM throttle permit", e);
        Map<String, WorkloadGroupState> existingStateMap = workloadGroupsStateAccessor.getWorkloadGroupStateMap();  
        if (optionalWorkloadGroup.isPresent()
        if (!exists) {  
        // This can happen if the request failed for a deleted workload group
    public Releasable acquireThrottleOrReject(WorkloadGroupTask task, BooleanSupplier parentAlreadyCounted) {
        if (workloadGroupId == null || workloadGroupId.equals(WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get())) {  
                    "WorkloadGroup " + workloadGroupId + " is already contended. " + reason.toString()  
        this.clusterService.addListener(this);
                    return true;
                }
        this.taskCancellationService = taskCancellationService;
        }  
    protected void doClose() throws IOException {}
import org.opensearch.threadpool.Scheduler;
import org.opensearch.common.settings.Settings;
public class WorkloadGroupService extends AbstractLifecycleComponent  
     */  
     *
            }
            if (workloadGroup == null) {
                    new NodeDuressTracker(
    }
        }  
        return acquireThrottleOrReject(workloadGroupId, principal, () -> false, counted -> {});
            threadPool,
            return null;
import java.util.Optional;
 * As of now this is a stub and main implementation PR will be raised soon.Coming PR will collate these changes with core WorkloadGroupService changes  
        final Map<String, WorkloadGroupStatsHolder> statsHolderMap = new HashMap<>();
        Consumer<Boolean> onCounted
                throw new OpenSearchRejectedExecutionException(
    public void clusterChanged(ClusterChangedEvent event) {
            new HashSet<>(),
        taskCancellationService.pruneDeletedWorkloadGroups(deletedWorkloadGroups);
                );
    /**
        }
    public static <T> ActionListener<T> releaseThrottlePermitBeforeCompletion(
     * @return the WorkloadGroup or null
        }
import org.opensearch.wlm.cancellation.WorkloadGroupTaskCancellationService;
        }
    private final ThreadPool threadPool;
                WorkloadGroup deletedWorkloadGroup = previousWorkloadGroups.get(workloadGroupName);
            if (reject) {  
import org.opensearch.cluster.metadata.WorkloadGroup;
    }
                    }
     * Bumps {@code total_would_throttle} ({@code wouldThrottleOnly == true}, MONITOR observed) or {@code total_throttled}
import java.util.Map;  
                // Perform any necessary actions with the new workload group
                return null;
        }  
     * Wraps {@code listener} so the request's throttle permit is released <em>before</em> the listener is notified: a
     * so the request is marked counted and re-entrancy is handled.  
                    if (threshold < lastRecordedUsage) {  
        }  
            for (String id : workloadGroupIds) {
                    new NodeDuressTracker(
    /**
    /**
     * Resolves the bucket key value: {@link WorkloadGroupThrottleSettings#GROUP_SCOPE} for whole-group throttling, else the  
    }
    public WorkloadGroupStats nodeStats(Set<String> workloadGroupIds, Boolean requestedBreached) {
        }
     * Returns the workload group attached to the calling thread context, or null if the current  
     * @param listener       the listener to notify once the permit has been given back
    private final WorkloadGroupThrottleTracker throttleTracker = new WorkloadGroupThrottleTracker();
                        break;
import org.opensearch.tasks.TaskResourceTrackingService;
                        reason.append(resourceType)
        return ActionListener.runBefore(listener, () -> {  
            return null;
import org.opensearch.common.lease.Releasable;  
     * Separator between the segments of a throttle bucket key,
                recordThrottleStat(workloadGroupId, true);  
                // MONITOR: count in total_would_throttle and admit.  
                .noneMatch(workloadGroup -> workloadGroup.get_id().equals(task.getWorkloadGroupId()));
            return;
        this.workloadGroupsStateAccessor.addNewWorkloadGroup(WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get());
        for (String token : principal.split(WorkloadGroupTask.WORKLOAD_GROUP_PRINCIPAL_VALUE_DELIMITER)) {
            scheduledFuture.cancel();  
    public WorkloadGroup getWorkloadGroupById(String workloadGroupId) {
     * @param workloadGroupId workload group identifier
        }
     * @return whether or not SBP handle it
        boolean exists = activeWorkloadGroups.stream().anyMatch(workloadGroup -> workloadGroup.get_id().equals(finalWorkloadGroupId));
                return permit;  
        } else if (resourceType == ResourceType.MEMORY) {
        WorkloadGroupTaskCancellationService taskCancellationService,
    /**
                        workloadManagementSettings::getDuressStreak
        TaskResourceTrackingService.TaskCompletionListener {  
                    );
                if (shouldInclude) {
                            .append(workloadGroup.get_id())
                onCounted.accept(true);
        this.threadPool = threadPool;  
            return WorkloadGroupThrottleSettings.GROUP_SCOPE;
        // Extract the workload groups from both the current and previous cluster states
            new NodeDuressTrackers(
            // SOFT enforces the throttle too; resiliency_mode only governs resource limits.
    }  
    public WorkloadGroup getCurrentWorkloadGroup() {
            }  
    private final WorkloadGroupsStateAccessor workloadGroupsStateAccessor;
    /**
                            .getHeapUsedPercent() / 100.0,
        // Detect workload groups deleted in the current cluster state  
                    final double threshold = getNormalisedRejectionThreshold(
/*  
    public Set<WorkloadGroup> getActiveWorkloadGroups() {
            return null;
    /**
     */
