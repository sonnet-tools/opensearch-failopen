            }  
    public void apply(String action, AdmissionControlActionType admissionControlActionType) {  
                    String.format(
     * @param action is the transport action
     * Get IO rejection threshold based on action type  
            case CLUSTER_ADMIN:
            Optional<NodeResourceUsageStats> nodePerformanceStatistics = this.resourceUsageCollectorService.getNodeStatistics(
                if (ioUsage >= ioUsageThreshold) {
                        this.settings.getTransportLayerAdmissionControllerMode()
    private void applyForTransportLayer(String actionName, AdmissionControlActionType admissionControlActionType) {  
                );
                    );  
        ClusterService clusterService,
     *
                return this.settings.getSearchIOUsageLimit();
            this.applyForTransportLayer(action, admissionControlActionType);
                throw new OpenSearchRejectedExecutionException(
     */
 */  
import org.opensearch.ratelimitting.admissioncontrol.settings.IoBasedAdmissionControllerSettings;  
                        admissionControlActionType.name()  
                        actionName,
                        ioUsage,
     */
                );
 * The OpenSearch Contributors require contributions made to  
 */
        ResourceUsageCollectorService resourceUsageCollectorService,  
                    LOGGER.warn(
        switch (admissionControlActionType) {  
    private long getIoRejectionThreshold(AdmissionControlActionType admissionControlActionType) {
}
        super(admissionControllerName, resourceUsageCollectorService, clusterService);
import org.opensearch.cluster.service.ClusterService;  
                throw new IllegalArgumentException(
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
     * Apply admission control based on the resource usage for an action  
            if (nodePerformanceStatistics.isPresent()) {
        String admissionControllerName,
    ) {  
        if (this.isEnabledForTransportLayer(this.settings.getTransportLayerAdmissionControllerMode())) {
 *  It provides methods to apply admission control if configured limit has been reached
    private static final Logger LOGGER = LogManager.getLogger(IoBasedAdmissionController.class);
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
    /**
/*  
                            + "usage [{}] exceeds the allowed limit [{}] for transport action [{}] in admissionControlMode [{}]",
                        Locale.ROOT,
    private boolean isLimitsBreached(String actionName, AdmissionControlActionType admissionControlActionType) {
/**
            }  
            case SEARCH:
 * compatible open source license.
                this.clusterService.state().nodes().getLocalNodeId()  
     * Check if the configured resource usage limits are breached for the action
                }
    @Override
                    String.format(  
                        ioUsageThreshold,  
                    )
    public IoBasedAdmissionController(
    }
 *  Class for IO Based Admission Controller in OpenSearch, which aims to provide IO utilisation admission control.  
import org.opensearch.node.ResourceUsageCollectorService;
            );
     */  
    }
                return this.settings.getClusterAdminIOUsageLimit();  
import org.opensearch.node.NodeResourceUsageStats;  
                return this.settings.getIndexingIOUsageLimit();
            case INDEXING:  
package org.opensearch.ratelimitting.admissioncontrol.controllers;
    }
import org.opensearch.common.settings.Settings;
     * Apply transport layer admission control if configured limit has been reached
        Settings settings
     * @param resourceUsageCollectorService instance used to get resource usage stats of the node
    /**
                        "Admission control not Supported for AdmissionControlActionType: %s",
 *
    /**
     * @param admissionControlActionType type of admissionControlActionType  
            default:
     */
import org.apache.logging.log4j.Logger;
 * this file be licensed under the Apache-2.0 license or a
        }
                        "IoBasedAdmissionController limit reached as the current IO "  
     * @param clusterService                instance of the clusterService
     */  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.LogManager;
                double ioUsage = nodePerformanceStatistics.get().getIoUsageStats().getIoUtilisationPercent();  
     * @param admissionControllerName       name of the admissionController  
                        Locale.ROOT,  
            long ioUsageThreshold = this.getIoRejectionThreshold(admissionControlActionType);
        return false;
        this.settings = new IoBasedAdmissionControllerSettings(clusterService.getClusterSettings(), settings);
public class IoBasedAdmissionController extends AdmissionController {  
            this.addRejectionCount(admissionControlActionType.getType(), 1);
        }  
import java.util.Optional;  
            if (this.isAdmissionControllerEnforced(this.settings.getTransportLayerAdmissionControllerMode())) {  
                        actionName,
                    )
    /**
                        "IO usage admission controller rejected the request for action [%s] as IO limit reached for action-type [%s]",
        }  
                        admissionControlActionType.getType()  
        // check if cluster state is ready
    /**  
        if (isLimitsBreached(actionName, admissionControlActionType)) {
    public static final String IO_BASED_ADMISSION_CONTROLLER = "global_io_usage";
import java.util.Locale;
    public IoBasedAdmissionControllerSettings settings;  
    }  
        if (clusterService.state() != null && clusterService.state().nodes() != null) {  
                    return true;
        }
    }  
