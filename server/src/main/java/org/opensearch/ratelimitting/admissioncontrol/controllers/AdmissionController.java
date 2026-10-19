     */
     * @return current value of the rejection count metric tracked by the admission-controller.
    final ResourceUsageCollectorService resourceUsageCollectorService;  
        Map<String, Long> rejectionStats = new HashMap<>();  
        String admissionControllerName,
    /**
     * @param clusterService instance of the clusterService
    public final ClusterService clusterService;
    public String getName() {
import org.opensearch.cluster.service.ClusterService;
 *
    public Map<String, Long> getRejectionStats() {
     * @return true if admissionController is Enforced Mode else false  
     * @return true if admissionController is enabled for the transport layer else false
    /**
import java.util.concurrent.atomic.AtomicLong;  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
     */
    ) {
    }  
    }
import java.util.HashMap;
        return admissionControlMode == AdmissionControlMode.ENFORCED;  
    public AdmissionController(  
import org.opensearch.common.util.concurrent.ConcurrentCollections;
}
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
     * Get rejection stats of the admission controller  
        this.resourceUsageCollectorService = resourceUsageCollectorService;  
    /**
     */
     */
 * Abstract class for Admission Controller in OpenSearch, which aims to provide resource based request admission control.  
public abstract class AdmissionController {
    public Boolean isAdmissionControllerEnforced(AdmissionControlMode admissionControlMode) {
     *
        return rejectionStats;
 * It provides methods for any tracking-object that can be incremented (such as memory size),
     */  
     * @param admissionControllerName       name of the admissionController
     * Return the current state of the admission controller  
     * Add rejection count to the rejection count metric tracked by the admission controller
    }
        ResourceUsageCollectorService resourceUsageCollectorService,
        this.admissionControllerName = admissionControllerName;
package org.opensearch.ratelimitting.admissioncontrol.controllers;
     */
    public final Map<String, AtomicLong> rejectionCountMap;
        this.rejectionCountMap = ConcurrentCollections.newConcurrentMap();
    /**  
    public long getRejectionCount(String admissionControlActionType) {
 * and admission control can be applied if configured limit has been reached
 * this file be licensed under the Apache-2.0 license or a
    public boolean isEnabledForTransportLayer(AdmissionControlMode admissionControlMode) {  
    }  
 */  
     * @return name of the admission-controller  
    /**
            this.rejectionCountMap.put(admissionControlActionType, new AtomicLong(0));
    public void addRejectionCount(String admissionControlActionType, long count) {  
    }
        }  
    /**
            return this.rejectionCountMap.get(admissionControlActionType).get();  
        return this.admissionControllerName;  
    /**
    }  
        ClusterService clusterService  
    private final String admissionControllerName;
 */  
        this.clusterService = clusterService;
     */
     */
    public abstract void apply(String action, AdmissionControlActionType admissionControlActionType);  
/*  
    /**  
/**
 * SPDX-License-Identifier: Apache-2.0
        return 0;
     * Apply admission control based on the resource usage for an action
        if (this.rejectionCountMap.containsKey(admissionControlActionType)) {
     * @param resourceUsageCollectorService instance used to get resource usage stats of the node  
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
    }
        return admissionControlMode != AdmissionControlMode.DISABLED;
        if (!this.rejectionCountMap.containsKey(admissionControlActionType)) {
import java.util.Map;
        rejectionCountMap.forEach((actionType, count) -> rejectionStats.put(actionType, count.get()));
import org.opensearch.node.ResourceUsageCollectorService;  
        }
        this.rejectionCountMap.get(admissionControlActionType).getAndAdd(count);
