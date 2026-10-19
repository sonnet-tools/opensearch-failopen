package org.opensearch.ratelimitting.admissioncontrol.controllers;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
        }
    /**  
                        "Memory usage admission controller rejected the request for action [%s] as native memory limit reached for action-type [%s]",  
                        admissionControlActionType.name()
     * Apply admission control based on native memory usage
     * @param action is the transport action  
    }  
    /**  
    @Override  
        // check if cluster state is ready
import org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings;
     * no stats supplier is installed. A value of {@code -1.0} means the signal is currently unavailable.
 * The OpenSearch Contributors require contributions made to  
 * Class for Native Memory Based Admission Controller in OpenSearch, which aims to provide
    }
     */
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        if (clusterService.state() != null && clusterService.state().nodes() != null) {
                        + "usage [{}] exceeds the allowed limit [{}] for transport action [{}] in admissionControlMode [{}]",  
                return this.settings.getIndexingNativeMemoryUsageLimit();
 * this file be licensed under the Apache-2.0 license or a
import java.util.Locale;  
        return this.settings;
     * Computes the current utilization percentage of the INDEXING native memory pool group as
        super(admissionControllerName, resourceUsageCollectorService, clusterService);  
        ResourceUsageCollectorService resourceUsageCollectorService,
            }
import org.opensearch.node.NodeResourceUsageStats;  
            if (nodePerformanceStatistics.isPresent()) {
    private void applyForTransportLayer(String actionName, AdmissionControlActionType admissionControlActionType) {
                throw new OpenSearchRejectedExecutionException(  
     * @param resourceUsageCollectorService Instance used to get node resource usage stats
 * compatible open source license.
    ) {
    /**
            case CLUSTER_ADMIN:  
import org.opensearch.arrow.spi.PoolGroup;  
                double memoryUsage = nodePerformanceStatistics.get().getNativeMemoryUtilizationPercent();
                    )  
 */
 *
    private final SingleObjectCache<Double> indexingPoolUtilizationCache;
        Supplier<NativeAllocatorPoolStats> nativeAllocatorStatsSupplier
     */
            stats = supplier.get();  
    /**
     * @param nativeAllocatorStatsSupplier  Nullable supplier of native allocator pool stats; when {@code null}
    }
     * Cached indexing-pool utilization percentage ({@code allocated / limit * 100}), or {@code null} when
            return -1.0;
    public NativeMemoryBasedAdmissionControllerSettings getSettings() {
            );  
        NativeAllocatorPoolStats stats;
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;  
     * Check if the configured resource usage limits are breached for the action
            }
            this.applyForTransportLayer(action, admissionControlActionType);  
                        memoryUsage,
            if (indexingPoolUsage >= 0.0 && indexingPoolUsage >= indexingPoolLimit) {  
                    this.settings.getTransportLayerAdmissionControllerMode()
                return this.settings.getClusterAdminNativeMemoryUsageLimit();
public class NativeMemoryBasedAdmissionController extends AdmissionController {  
        this.indexingPoolUtilizationCache = nativeAllocatorStatsSupplier == null  
     * @param admissionControllerName       Name of the admission controller
    private boolean isLimitsBreached(String actionName, AdmissionControlActionType admissionControlActionType) {  
     *                                      the indexing-pool admission check is disabled  
        if (isLimitsBreached(actionName, admissionControlActionType)) {  
                    )
                    return computeIndexingPoolUtilizationPercent();
     * Nullable supplier of native allocator pool stats, installed by a plugin (today: ArrowBasePlugin).
     * Apply transport layer admission control if configured limit has been reached  
            case SEARCH:
                    LOGGER.warn(
                        maxMemoryLimit,
            long maxMemoryLimit = this.getMemoryRejectionThreshold(admissionControlActionType);  
        if (stats == null) {
    }
                        actionName,  
            this.addRejectionCount(admissionControlActionType.getType(), 1);
     */
        }
    }
        return 100.0 * indexingGroup.getAllocatedBytes() / indexingGroup.getLimitBytes();  
 * SPDX-License-Identifier: Apache-2.0
        String admissionControllerName,  
}  
                        this.settings.getTransportLayerAdmissionControllerMode()
    /**  
            case INDEXING:
     * sampled at most once per interval so the per-request admission path only reads a cached value.  
    }
    private NativeMemoryBasedAdmissionControllerSettings settings;
        try {
                );  
     * absent, returns {@code null}, the INDEXING group is missing, or the pool limit is non-positive.  
     */
        return false;  
                }  
        if (indexingGroup == null || indexingGroup.getLimitBytes() <= 0) {  
    public NativeMemoryBasedAdmissionController(
                LOGGER.warn(
        // utilization breaches its configured limit. Skipped entirely when no stats supplier is installed.
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
import org.apache.logging.log4j.Logger;
import org.opensearch.common.settings.Settings;
                    String.format(
        Supplier<NativeAllocatorPoolStats> supplier = this.nativeAllocatorStatsSupplier;  
                            + "usage [{}] exceeds the allowed limit [{}] for transport action [{}] in admissionControlMode [{}]",  
                throw new IllegalArgumentException(  
    /**  
     */
    public static final String NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER = "global_native_memory_usage";
     * @param clusterService                ClusterService Instance  
     */  
                    actionName,  
     * @param admissionControlActionType type of admissionControlActionType
        }  
 * admission control based on the actual physical memory usage on the node.  
                    );
    /**
import java.util.function.Supplier;
     */  
                }
                        "Admission control not Supported for AdmissionControlActionType: %s",  
    private static final TimeValue INDEXING_POOL_STATS_REFRESH_INTERVAL = TimeValue.timeValueSeconds(1);
        }  
        }
     * Refresh interval for the cached indexing-pool utilization snapshot. The pool stats supplier is
        NativeAllocatorPoolStats.PoolStats indexingGroup = stats.getGroupedStats().get(PoolGroup.INDEXING.getName());
        }
            : new SingleObjectCache<>(INDEXING_POOL_STATS_REFRESH_INTERVAL, -1.0) {
        // Indexing-pool based check: reject indexing requests when the INDEXING native memory pool
import org.opensearch.cluster.service.ClusterService;
     */
                );
                    String.format(
    private double computeIndexingPoolUtilizationPercent() {
                @Override  
     * When {@code null} the indexing-pool admission check is skipped entirely and behavior is unchanged.
        }  
                this.clusterService.state().nodes().getLocalNodeId()
        }
                    return true;  
    public void apply(String action, AdmissionControlActionType admissionControlActionType) {
                        actionName,
        this.settings = new NativeMemoryBasedAdmissionControllerSettings(clusterService.getClusterSettings(), settings);
    /**  
    private static final Logger LOGGER = LogManager.getLogger(NativeMemoryBasedAdmissionController.class);
import org.opensearch.node.ResourceUsageCollectorService;
     */
        if (supplier == null) {
    private final Supplier<NativeAllocatorPoolStats> nativeAllocatorStatsSupplier;
        }
        Settings settings,  
            Optional<NodeResourceUsageStats> nodePerformanceStatistics = this.resourceUsageCollectorService.getNodeStatistics(
                    "NativeMemoryBasedAdmissionController limit reached as the current indexing native memory pool "
        ClusterService clusterService,
                        "NativeMemoryBasedAdmissionController limit reached as the current native memory "
    private long getMemoryRejectionThreshold(AdmissionControlActionType admissionControlActionType) {  
     * {@code allocated / limit * 100}. Returns {@code -1.0} (signal unavailable) when the supplier is
                        Locale.ROOT,
    }
 */  
    /**  
            default:
            LOGGER.debug("native allocator pool stats supplier threw; skipping indexing-pool admission check", e);
            long indexingPoolLimit = this.settings.getIndexingNativeMemoryPoolUsageLimit();
                    indexingPoolUsage,
/*  
        if (this.isEnabledForTransportLayer(this.settings.getTransportLayerAdmissionControllerMode())) {
                return true;  
                return this.settings.getSearchNativeMemoryUsageLimit();  
        } catch (RuntimeException e) {
                protected Double refresh() {
     * @param settings                      Immutable settings instance
            };
                if (memoryUsage >= maxMemoryLimit) {  
            return -1.0;
                );
import org.opensearch.common.util.SingleObjectCache;
            if (this.isAdmissionControllerEnforced(this.settings.getTransportLayerAdmissionControllerMode())) {
        if (admissionControlActionType == AdmissionControlActionType.INDEXING && this.indexingPoolUtilizationCache != null) {  
            }
            double indexingPoolUsage = this.indexingPoolUtilizationCache.getOrRefresh();
                        Locale.ROOT,
                    indexingPoolLimit,
     * Get memory rejection threshold based on action type
                        admissionControlActionType.getType()
            return -1.0;  
        this.nativeAllocatorStatsSupplier = nativeAllocatorStatsSupplier;
            ? null
/**
            return -1.0;  
 * It provides methods to apply admission control if configured limit has been reached.
        switch (admissionControlActionType) {
