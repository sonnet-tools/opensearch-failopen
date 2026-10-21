        );
        this.clusterSettings.addAffixUpdateConsumer(USER_DEFINED_METADATA, (first, second) -> {}, (first, second) -> {});
     * @param <T>      the type of the cluster state update task state
import org.opensearch.node.Node;
     */
     *                 that share the same executor will be executed
        return localNode;
        ClusterStateTaskExecutor<T> executor,
    /**
    public synchronized void setNodeConnectionsService(NodeConnectionsService nodeConnectionsService) {
    /**
     * Add a listener for updated cluster states
    public void addStateApplier(ClusterStateApplier applier) {
 */
    /**
/*
            clusterSettings,
        return clusterApplierService.state();
     */
    }
    }
        assert this.rerouteService != null : "RerouteService not set";
     *
 * @opensearch.api
     * Going forward, IndexingPressureService will have required constructs for exposing listeners/interfaces for plugin development.(#478)
    private final ClusterSettings clusterSettings;
    }
     * @param task     the state needed for the cluster state update task
    private final ClusterApplierService clusterApplierService;
     */
            throw new IllegalStateException("No local node found. Is the node started?");
    /**
    public <T> void submitStateUpdateTask(
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
     * @param config   the cluster state update task configuration
    /**
     * Adds an applier which will be called after all high priority and normal appliers have been called.
import org.opensearch.common.settings.ClusterSettings;
    public ClusterState state() {
 * this work for additional information regarding copyright
    }
    public void addLocalNodeClusterManagerListener(LocalNodeClusterManagerListener listener) {
     * The node's settings.
            new ClusterManagerService(settings, clusterSettings, threadPool, clusterManagerMetrics),
    /**
    }
import org.opensearch.cluster.ClusterStateTaskListener;
     * @param config   the cluster state update task configuration
        submitStateUpdateTasks(source, Collections.singletonMap(task, listener), config, executor);
     * @return ClusterState
    public ClusterService(
    @Override
        String source,
        ClusterManagerMetrics clusterManagerMetrics
/*
        this.clusterApplierService = clusterApplierService;
    }
    }
    }
 * under the License.
import org.opensearch.index.IndexingPressureService;
        ClusterSettings clusterSettings,
        clusterApplierService.setStreamNodeConnectionsService(streamNodeConnectionsService);
import org.opensearch.cluster.ClusterState;
    }
        this.clusterName = ClusterName.CLUSTER_NAME_SETTING.get(settings);
        ClusterManagerService clusterManagerService,
 * compatible open source license.
        clusterApplierService.close();
 * SPDX-License-Identifier: Apache-2.0
     */
import org.opensearch.cluster.LocalNodeClusterManagerListener;
        clusterApplierService.addStateApplier(applier);
 * Modifications Copyright OpenSearch Contributors. See
    /**
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
        assert this.rerouteService == null : "RerouteService is already set";
     * tasks will all be executed on the executor in a single batch
        this.indexingPressureService = indexingPressureService;
    @Override
    }
     * potentially with more tasks of the same executor.
     *
     */
     *                 batches on this executor
     * @param source   the source of the cluster state update task
    public ClusterState preCommitState() {
        final String source,
    public void addLowPriorityApplier(ClusterStateApplier applier) {
    public IndexingPressureService getIndexingPressureService() {
     *                 completes
    /**
 *
    );
     *
        final ClusterStateTaskConfig config,
    public void removeListener(ClusterStateListener listener) {
     * @param source     the source of the cluster state update task
    }
        clusterApplierService.start();
     * @param throttlingEnabled - throttling is enabled for task or not i.e does data node perform retries on it or not
        ClusterStateTaskConfig config,
 * Licensed to Elasticsearch under one or more contributor
     */
     *                 that share the same executor will be executed
        return operationRouting;
import org.opensearch.cluster.ClusterName;
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under
    private final ClusterManagerService clusterManagerService;
    private final String nodeName;
        this.nodeName = Node.NODE_NAME_SETTING.get(settings);
import org.opensearch.cluster.routing.OperationRouting;
    ) {
     * @param tasks    a map of update tasks and their corresponding listeners
    public ClusterSettings getClusterSettings() {
        clusterApplierService.removeListener(listener);
     */
        clusterManagerService.stop();
 * license agreements. See the NOTICE file distributed with
     * The currently applied cluster state.
     * batched across the same instance of executor. The exact batching
    }
}
        return nodeName;
    public ClusterManagerTaskThrottler.ThrottlingKey registerClusterManagerTask(ClusterManagerTask task, boolean throttlingEnabled) {
    }
        this(settings, clusterSettings, threadPool, new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE));
    }
    }
     * Removes a listener for updated cluster states.
    public void setRerouteService(RerouteService rerouteService) {
     * Submits a batch of cluster state update tasks; submitted updates are guaranteed to be processed together,
    /**
@PublicApi(since = "1.0.0")
    ) {
     * Submits a cluster state update task; submitted updates will be
     * present in the createComponents signature of Plugin interface currently. {@link org.opensearch.plugins.Plugin#createComponents}
     * @param <T>      the type of the cluster state update task state
    private final OperationRouting operationRouting;
    public ClusterName getClusterName() {
    }
    protected synchronized void doClose() {
    private RerouteService rerouteService;
 * The OpenSearch Contributors require contributions made to
        return clusterManagerService;
    }
     * Submits a cluster state update task; unlike {@link #submitStateUpdateTask(String, Object, ClusterStateTaskConfig,
        this(
    public void setIndexingPressureService(IndexingPressureService indexingPressureService) {
     * Functionality for register task key to cluster manager node.
 *
    }
import org.opensearch.cluster.ClusterStateApplier;
    private final Settings settings;
    ) {
     * @param task - cluster manager task
    public void addHighPriorityApplier(ClusterStateApplier applier) {
    /**
    public Settings getSettings() {
public class ClusterService extends AbstractLifecycleComponent {
        final Map<T, ClusterStateTaskListener> tasks,
        // Add a no-op update consumer so changes are logged
    }
     * TODO: Should be renamed to appliedState / appliedClusterState
            settings,
    }
    public ClusterManagerService getClusterManagerService() {
    }
        clusterApplierService.setNodeConnectionsService(nodeConnectionsService);
    public boolean isStateInitialised() {
        ClusterStateTaskListener listener
    /**
     * @param listener callback after the cluster state update task
    }
import org.opensearch.cluster.ClusterStateTaskConfig;
    private IndexingPressureService indexingPressureService;
    /**
    public <T> void submitStateUpdateTasks(
     */
    }
        assert Thread.currentThread().getName().contains(ClusterApplierService.CLUSTER_UPDATE_THREAD_NAME)
import org.opensearch.cluster.StreamNodeConnectionsService;
        clusterApplierService.stop();
     */
        Settings settings,
package org.opensearch.cluster.service;
     * Although Indexing Pressure instances can be accessed via Node and NodeService class but none of them are
import org.opensearch.common.annotation.PublicApi;
     */
    /**
import org.opensearch.common.settings.Setting;
    public ClusterService(
        return true;
    public ClusterService(Settings settings, ClusterSettings clusterSettings, ThreadPool threadPool) {
     * The node's settings.
        String source,
        clusterApplierService.addLocalNodeClusterManagerListener(listener);
        ClusterApplierService clusterApplierService
        this.settings = settings;
import java.util.Map;
    }
        return indexingPressureService;
 *     http://www.apache.org/licenses/LICENSE-2.0
    public OperationRouting operationRouting() {
     * Returns true if the state in appliedClusterState is not null
        clusterApplierService.addLowPriorityApplier(applier);
    }
     */
            || Thread.currentThread().getName().contains(ClusterManagerService.CLUSTER_MANAGER_UPDATE_THREAD_NAME)
import org.opensearch.cluster.ClusterStateTaskExecutor;
    public synchronized void setStreamNodeConnectionsService(StreamNodeConnectionsService streamNodeConnectionsService) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * not use this file except in compliance with the License.
     */
     * The name of this node.
    ) {
        Settings settings,
 * GitHub history for details.
/**
        return rerouteService;
    }
        return clusterApplierService.isStateInitialised();
import org.opensearch.cluster.routing.RerouteService;
     * are pending update tasks for the same executor, these update
    public static boolean assertClusterOrClusterManagerStateThread() {
     */
        this.rerouteService = rerouteService;
 * specific language governing permissions and limitations
        T task,
     * Getter and Setter for IndexingPressureService, This method exposes IndexingPressureService stats to other plugins for usage.
        return clusterName;
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.common.settings.Settings;
     * The state that is persisted to store but may not be applied to cluster.
import org.opensearch.cluster.ClusterStateListener;
 * this file be licensed under the Apache-2.0 license or a
    }
 * KIND, either express or implied.  See the License for the
    public void addListener(ClusterStateListener listener) {
    public static final org.opensearch.common.settings.Setting.AffixSetting<String> USER_DEFINED_METADATA = Setting.prefixKeySetting(
    /**
    @Override
     * @param executor the cluster state update task executor; tasks
     *
     */
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.common.settings.Setting.Property;
        T updateTask
    ) {
    protected synchronized void doStart() {
     * semantics depend on the underlying implementation but a rough
        clusterApplierService.addHighPriorityApplier(applier);
     */
        clusterApplierService.addListener(listener);
 * Main Cluster Service
 * software distributed under the License is distributed on an
     */
    protected synchronized void doStop() {
     */
     * Adds a high priority applier of updated cluster states.
     * @return throttling task key which needs to be passed while submitting task to cluster manager
import org.opensearch.cluster.ClusterManagerMetrics;
     *
     *
    /**
    public void removeApplier(ClusterStateApplier applier) {
    /**
        return clusterSettings;
import org.opensearch.cluster.NodeConnectionsService;
        DiscoveryNode localNode = state().getNodes().getLocalNode();
 */
    }
        return clusterManagerService.registerClusterManagerTask(task, throttlingEnabled);
    }
     * @param source   the source of the cluster state update task
    public ClusterApplierService getClusterApplierService() {
    }
import java.util.Collections;
    /**
        clusterApplierService.removeApplier(applier);
    /**
        this.clusterSettings = clusterSettings;
 *
        clusterManagerService.submitStateUpdateTasks(source, tasks, config, executor);
            : "not called from the master/cluster state update thread";
        if (localNode == null) {
        final ClusterStateTaskExecutor<T> executor
    private final ClusterName clusterName;
    /**
        submitStateUpdateTask(source, updateTask, updateTask, updateTask, updateTask);
     */
     * guideline is that if the update task is submitted while there
        return clusterApplierService;
    }
        clusterManagerService.start();
     * @param updateTask the full context for the cluster state update
        ClusterSettings clusterSettings,
     *                 batches on this executor
    public DiscoveryNode localNode() {
        this.clusterManagerService = clusterManagerService;
        clusterManagerService.close();
        }
     * Adds a applier of updated cluster states.
 */
    }
     */
        return clusterApplierService.preCommitState();
    }
    public <T extends ClusterStateTaskConfig & ClusterStateTaskExecutor<T> & ClusterStateTaskListener> void submitStateUpdateTask(
     * @param executor the cluster state update task executor; tasks
     * Removes an applier of updated cluster states.
    public RerouteService getRerouteService() {
 * You may obtain a copy of the License at
        return settings;
    }
     *
    }
        (key) -> Setting.simpleString(key, Property.Dynamic, Property.NodeScope)
/*
    public final String getNodeName() {
 * Unless required by applicable law or agreed to in writing,
        "cluster.metadata.",
     * ClusterStateTaskExecutor, ClusterStateTaskListener)}, submitted updates will not be batched.
     * Add a listener for on/off local node cluster-manager events
 *
            new ClusterApplierService(Node.NODE_NAME_SETTING.get(settings), settings, clusterSettings, threadPool, clusterManagerMetrics)
     * The local node.
     *                   task
        ThreadPool threadPool,
        this.operationRouting = new OperationRouting(settings, clusterSettings);
 */
