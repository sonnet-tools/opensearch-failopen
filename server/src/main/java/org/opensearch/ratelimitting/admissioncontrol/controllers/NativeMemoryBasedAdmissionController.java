            LOGGER.debug("native allocator pool stats supplier threw; skipping indexing-pool admission check", e);
            };
     * Refresh interval for the cached indexing-pool utilization snapshot. The pool stats supplier is
        }
    public NativeMemoryBasedAdmissionControllerSettings getSettings() {
package org.opensearch.ratelimitting.admissioncontrol.controllers;
        return this.settings;
            case CLUSTER_ADMIN:
            this.applyForTransportLayer(action, admissionControlActionType);
import java.util.Locale;
            case INDEXING:
            if (this.isAdmissionControllerEnforced(this.settings.getTransportLayerAdmissionControllerMode())) {
     */
     */
public class NativeMemoryBasedAdmissionController extends AdmissionController {
                        "Memory usage admission controller rejected the request for action [%s] as native memory limit reached for action-type [%s]",
        this.settings = new NativeMemoryBasedAdmissionControllerSettings(clusterService.getClusterSettings(), settings);
     */
     * @param admissionControllerName       Name of the admission controller
    private boolean isLimitsBreached(String actionName, AdmissionControlActionType admissionControlActionType) {
        if (indexingGroup == null || indexingGroup.getLimitBytes() <= 0) {
     * @param clusterService                ClusterService Instance
        switch (admissionControlActionType) {
     * Computes the current utilization percentage of the INDEXING native memory pool group as
import org.opensearch.arrow.spi.PoolGroup;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            return -1.0;
                        "NativeMemoryBasedAdmissionController limit reached as the current native memory "
        }
    private static final Logger LOGGER = LogManager.getLogger(NativeMemoryBasedAdmissionController.class);
/**
        // Indexing-pool based check: reject indexing requests when the INDEXING native memory pool
            return -1.0;
 *
                        actionName,
                        this.settings.getTransportLayerAdmissionControllerMode()
            );
    private long getMemoryRejectionThreshold(AdmissionControlActionType admissionControlActionType) {
     * When {@code null} the indexing-pool admission check is skipped entirely and behavior is unchanged.
     */
    /**
        return false;
import org.apache.logging.log4j.Logger;
                );
    /**
 */
     * @param nativeAllocatorStatsSupplier  Nullable supplier of native allocator pool stats; when {@code null}
                    this.settings.getTransportLayerAdmissionControllerMode()
                throw new IllegalArgumentException(
        } catch (RuntimeException e) {
import org.opensearch.cluster.service.ClusterService;
        this.indexingPoolUtilizationCache = nativeAllocatorStatsSupplier == null
            stats = supplier.get();
import org.opensearch.node.NodeResourceUsageStats;
                LOGGER.warn(
                        admissionControlActionType.getType()
    }
     * Apply admission control based on native memory usage
     * {@code allocated / limit * 100}. Returns {@code -1.0} (signal unavailable) when the supplier is
                    "NativeMemoryBasedAdmissionController limit reached as the current indexing native memory pool "
            if (nodePerformanceStatistics.isPresent()) {
                return this.settings.getSearchNativeMemoryUsageLimit();
    /**
                        "Admission control not Supported for AdmissionControlActionType: %s",
    @Override
            this.addRejectionCount(admissionControlActionType.getType(), 1);
                );
                        Locale.ROOT,
                    return computeIndexingPoolUtilizationPercent();
                if (memoryUsage >= maxMemoryLimit) {
     *                                      the indexing-pool admission check is disabled
                double memoryUsage = nodePerformanceStatistics.get().getNativeMemoryUtilizationPercent();
import org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings;
}
            : new SingleObjectCache<>(INDEXING_POOL_STATS_REFRESH_INTERVAL, -1.0) {
    public void apply(String action, AdmissionControlActionType admissionControlActionType) {
     * Get memory rejection threshold based on action type
                        admissionControlActionType.name()
        ClusterService clusterService,
                @Override
        if (this.isEnabledForTransportLayer(this.settings.getTransportLayerAdmissionControllerMode())) {
     * @param admissionControlActionType type of admissionControlActionType
        NativeAllocatorPoolStats.PoolStats indexingGroup = stats.getGroupedStats().get(PoolGroup.INDEXING.getName());
        if (isLimitsBreached(actionName, admissionControlActionType)) {
 */
 * admission control based on the actual physical memory usage on the node.
                throw new OpenSearchRejectedExecutionException(
    private final Supplier<NativeAllocatorPoolStats> nativeAllocatorStatsSupplier;
                    actionName,
                    indexingPoolUsage,
        if (admissionControlActionType == AdmissionControlActionType.INDEXING && this.indexingPoolUtilizationCache != null) {
 * compatible open source license.
            ? null
            Optional<NodeResourceUsageStats> nodePerformanceStatistics = this.resourceUsageCollectorService.getNodeStatistics(
 * It provides methods to apply admission control if configured limit has been reached.
        ResourceUsageCollectorService resourceUsageCollectorService,
        try {
            return -1.0;
        String admissionControllerName,
    /**
     * Cached indexing-pool utilization percentage ({@code allocated / limit * 100}), or {@code null} when
            double indexingPoolUsage = this.indexingPoolUtilizationCache.getOrRefresh();
    /**
                    indexingPoolLimit,
        }
                    String.format(
                    )
        }
import org.opensearch.common.settings.Settings;
    public NativeMemoryBasedAdmissionController(
    private void applyForTransportLayer(String actionName, AdmissionControlActionType admissionControlActionType) {
    private NativeMemoryBasedAdmissionControllerSettings settings;
                protected Double refresh() {
    private double computeIndexingPoolUtilizationPercent() {
        }
    ) {
            }
            long indexingPoolLimit = this.settings.getIndexingNativeMemoryPoolUsageLimit();
                    String.format(
                        memoryUsage,
                        Locale.ROOT,
import org.apache.logging.log4j.LogManager;
        Supplier<NativeAllocatorPoolStats> nativeAllocatorStatsSupplier
import org.opensearch.common.unit.TimeValue;
        super(admissionControllerName, resourceUsageCollectorService, clusterService);
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
    }
        Supplier<NativeAllocatorPoolStats> supplier = this.nativeAllocatorStatsSupplier;
                return this.settings.getIndexingNativeMemoryUsageLimit();
     * @param resourceUsageCollectorService Instance used to get node resource usage stats
import java.util.Optional;
            return -1.0;
        }
    }
     */
 * Class for Native Memory Based Admission Controller in OpenSearch, which aims to provide
    /**
        Settings settings,
import java.util.function.Supplier;
 * SPDX-License-Identifier: Apache-2.0
        }
import org.opensearch.node.ResourceUsageCollectorService;
        }
     * sampled at most once per interval so the per-request admission path only reads a cached value.
            case SEARCH:
     * Apply transport layer admission control if configured limit has been reached
     * no stats supplier is installed. A value of {@code -1.0} means the signal is currently unavailable.
 * this file be licensed under the Apache-2.0 license or a
                            + "usage [{}] exceeds the allowed limit [{}] for transport action [{}] in admissionControlMode [{}]",
                return true;
    }
/*
                this.clusterService.state().nodes().getLocalNodeId()
    private static final TimeValue INDEXING_POOL_STATS_REFRESH_INTERVAL = TimeValue.timeValueSeconds(1);
     * absent, returns {@code null}, the INDEXING group is missing, or the pool limit is non-positive.
                );
                    LOGGER.warn(
        if (stats == null) {
    public static final String NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER = "global_native_memory_usage";
                        maxMemoryLimit,
    }
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
            if (indexingPoolUsage >= 0.0 && indexingPoolUsage >= indexingPoolLimit) {
     * @param settings                      Immutable settings instance
     */
import org.opensearch.common.util.SingleObjectCache;
        NativeAllocatorPoolStats stats;
    private final SingleObjectCache<Double> indexingPoolUtilizationCache;
            default:
     * Check if the configured resource usage limits are breached for the action
     */
     */
    }
 * The OpenSearch Contributors require contributions made to
    }
                return this.settings.getClusterAdminNativeMemoryUsageLimit();
        return 100.0 * indexingGroup.getAllocatedBytes() / indexingGroup.getLimitBytes();
        if (clusterService.state() != null && clusterService.state().nodes() != null) {
                    )
                    );
    /**
     * Nullable supplier of native allocator pool stats, installed by a plugin (today: ArrowBasePlugin).
        if (supplier == null) {
            long maxMemoryLimit = this.getMemoryRejectionThreshold(admissionControlActionType);
        }
    /**
                        actionName,
                }
        // check if cluster state is ready
            }
            }
                    return true;
        // utilization breaches its configured limit. Skipped entirely when no stats supplier is installed.
     */
                }
                        + "usage [{}] exceeds the allowed limit [{}] for transport action [{}] in admissionControlMode [{}]",
        this.nativeAllocatorStatsSupplier = nativeAllocatorStatsSupplier;
    /**
     * @param action is the transport action
