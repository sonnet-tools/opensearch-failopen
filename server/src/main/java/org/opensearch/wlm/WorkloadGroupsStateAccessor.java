    public WorkloadGroupsStateAccessor() {
        return workloadGroupStateMap.getOrDefault(  
}  
        );  
    }  
    }
        }
    public Map<String, WorkloadGroupState> getWorkloadGroupStateMap() {
     */  
 *
        return workloadGroupStateMap;
    }
     */
     * @param workloadGroupId
     * return WorkloadGroupState for the given workloadGroupId  
    public void addNewWorkloadGroup(String workloadGroupId) {
     * removes WorkloadGroupState against given workloadGroupId  
 * this file be licensed under the Apache-2.0 license or a
 * {@link WorkloadGroupState}s
    /**
     * @return WorkloadGroupState for the given workloadGroupId, if id is invalid return default workload group state
        if (workloadGroupId == null) {  
/*  
import java.util.concurrent.ConcurrentHashMap;
    /**
    }
            workloadGroupStateMap.get(WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get())
        this.workloadGroupStateMap.putIfAbsent(workloadGroupId, new WorkloadGroupState());
public class WorkloadGroupsStateAccessor {
    }
 */  
 * SPDX-License-Identifier: Apache-2.0
     * adds new WorkloadGroupState against given workloadGroupId
    public WorkloadGroupsStateAccessor(Map<String, WorkloadGroupState> workloadGroupStateMap) {  
        // ConcurrentHashMap rejects a null key, and an untagged request has no id; fall back to DEFAULT.
 */  
            workloadGroupId,
import java.util.Map;  
    }  
        this(new ConcurrentHashMap<>());  
    public void removeWorkloadGroup(String workloadGroupId) {  
     * returns the workload groups state
        this.workloadGroupStateMap.remove(workloadGroupId);
     * @param workloadGroupId may be null when a request carried no workload group header
        this.workloadGroupStateMap = workloadGroupStateMap;
 * compatible open source license.
    public WorkloadGroupState getWorkloadGroupState(String workloadGroupId) {
            return workloadGroupStateMap.get(WorkloadGroupTask.DEFAULT_WORKLOAD_GROUP_ID_SUPPLIER.get());
package org.opensearch.wlm;
     */  
import org.opensearch.wlm.stats.WorkloadGroupState;
    /**  
/**  
    /**
     */  
     * @param workloadGroupId
 * This class is used to decouple {@link WorkloadGroupService} and {@link org.opensearch.wlm.cancellation.WorkloadGroupTaskCancellationService} to share the
 * The OpenSearch Contributors require contributions made to  
    // Concurrent: the cluster-applier thread updates while request threads read.
    private final Map<String, WorkloadGroupState> workloadGroupStateMap;  
