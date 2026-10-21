                    this.clusterService,
     * @param action Transport action name
 * The OpenSearch Contributors require contributions made to
                return new NativeMemoryBasedAdmissionController(
     */
import org.opensearch.node.ResourceUsageCollectorService;
    public AdmissionControlService(
        }
            case CPU_BASED_ADMISSION_CONTROLLER:
        }
    /**
     * @param admissionControlActionType admissionControllerActionType value
     * @return AdmissionController Instance
                    this.resourceUsageCollectorService,
     *
        this.admissionControllers = new ConcurrentHashMap<>();
     * @param admissionControllerName admissionControllerName to register into the service.
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
     */
    }
 */
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.service.ClusterService;
    /**
 * SPDX-License-Identifier: Apache-2.0
        this.resourceUsageCollectorService = resourceUsageCollectorService;
    /**
            case NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER:
import org.apache.logging.log4j.LogManager;
    private final Settings settings;
import org.apache.lucene.util.Constants;
        this.threadPool = threadPool;
    }
     */
import static org.opensearch.ratelimitting.admissioncontrol.controllers.NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER;
import org.opensearch.ratelimitting.admissioncontrol.stats.AdmissionControlStats;
    public List<AdmissionController> getAdmissionControllers() {
 */
                    this.resourceUsageCollectorService,
public class AdmissionControlService {
    /**
                    this.resourceUsageCollectorService,
        this.initialize();
        Settings settings,
                return new IoBasedAdmissionController(
        // Initialise different type of admission controllers
    private final Supplier<NativeAllocatorPoolStats> nativeAllocatorStatsSupplier;
import static org.opensearch.ratelimitting.admissioncontrol.controllers.IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER;
import org.opensearch.ratelimitting.admissioncontrol.controllers.IoBasedAdmissionController;
        this.admissionControllers.put(admissionControllerName, admissionController);
            registerAdmissionController(IO_BASED_ADMISSION_CONTROLLER);
 * this file be licensed under the Apache-2.0 license or a
    }
                );
 * compatible open source license.
        ResourceUsageCollectorService resourceUsageCollectorService,
        if (!this.admissionControllers.isEmpty()) {
        }
     * @param threadPool ThreadPool Instance
     * @param clusterService ClusterService Instance
            registerAdmissionController(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER);
     * @param controllerName name of the admissionController
import java.util.function.Supplier;
    private final ThreadPool threadPool;
import org.apache.logging.log4j.Logger;
        Supplier<NativeAllocatorPoolStats> nativeAllocatorStatsSupplier
                );
    /**
import org.opensearch.threadpool.ThreadPool;
    public AdmissionControlStats stats() {
    private void initialize() {
                AdmissionControllerStats admissionControllerStats = new AdmissionControllerStats(admissionController);
import org.opensearch.ratelimitting.admissioncontrol.controllers.NativeMemoryBasedAdmissionController;
import java.util.concurrent.ConcurrentMap;
    }
     */
    ) {
import java.util.ArrayList;
                throw new IllegalArgumentException("Not Supported AdmissionController : " + admissionControllerName);
    public AdmissionController getAdmissionController(String controllerName) {
     */
            default:
                    this.nativeAllocatorStatsSupplier
    /**
                return new CpuBasedAdmissionController(
        this.nativeAllocatorStatsSupplier = nativeAllocatorStatsSupplier;
        List<AdmissionControllerStats> statsList = new ArrayList<>();
    private final ConcurrentMap<String, AdmissionController> admissionControllers;
 *
    public final AdmissionControlSettings admissionControlSettings;
package org.opensearch.ratelimitting.admissioncontrol;
     * @param resourceUsageCollectorService Instance used to get node resource usage stats
        this.settings = settings;
     */
     */
                    admissionControllerName,
     *
                    this.settings,
 * Admission control Service that bootstraps and manages all the Admission Controllers in OpenSearch.
     *                                     native-memory admission controller for indexing-pool based rejection
        this.admissionControllers.forEach(
/*
        return null;
    }
     */
            });
    /**
    }
     * Initialise and Register all the admissionControllers
        this.admissionControlSettings = new AdmissionControlSettings(clusterService.getClusterSettings(), settings);
import static org.opensearch.ratelimitting.admissioncontrol.controllers.CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER;
    private static final Logger logger = LogManager.getLogger(AdmissionControlService.class);
import org.opensearch.ratelimitting.admissioncontrol.controllers.AdmissionController;
        ThreadPool threadPool,
                statsList.add(admissionControllerStats);
    }
    public void applyTransportAdmissionControl(String action, AdmissionControlActionType admissionControlActionType) {
                    admissionControllerName,
     * @return instance of the AdmissionController Instance
            this.admissionControllers.forEach((controllerName, admissionController) -> {
                );
        switch (admissionControllerName) {
import org.opensearch.ratelimitting.admissioncontrol.controllers.CpuBasedAdmissionController;
     * @return list of the registered admissionControllers
                    admissionControllerName,
import java.util.List;
        AdmissionController admissionController = this.controllerFactory(admissionControllerName);
     * Return admission control stats
    private final ResourceUsageCollectorService resourceUsageCollectorService;
     *
                    this.settings
     * @param settings Immutable settings instance
            case IO_BASED_ADMISSION_CONTROLLER:
        );
                    this.settings
        if (Constants.LINUX) {
/**
    private AdmissionController controllerFactory(String admissionControllerName) {
        registerAdmissionController(CPU_BASED_ADMISSION_CONTROLLER);
                    this.clusterService,
    }
                    this.clusterService,
        return this.admissionControllers.getOrDefault(controllerName, null);
}
     * @param nativeAllocatorStatsSupplier Nullable supplier of native allocator pool stats, forwarded to the
        this.clusterService = clusterService;
    /**
        ClusterService clusterService,
            return new AdmissionControlStats(statsList);
     *
    public void registerAdmissionController(String admissionControllerName) {
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
    private final ClusterService clusterService;
        return new ArrayList<>(this.admissionControllers.values());
import java.util.concurrent.ConcurrentHashMap;
import org.opensearch.ratelimitting.admissioncontrol.stats.AdmissionControllerStats;
     *
            (name, admissionController) -> { admissionController.apply(action, admissionControlActionType); }
