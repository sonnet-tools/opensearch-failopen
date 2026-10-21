                Set<String> alreadyRegistered = new HashSet<>(registeredActionNames);
import org.opensearch.rest.action.admin.cluster.RestClusterPutWeightedRoutingAction;
        }).toInstance(indicesAliasesRequestRequestValidators);
import org.opensearch.action.admin.cluster.remotestore.stats.TransportRemoteStoreStatsAction;
import org.opensearch.tasks.Task;
        registerHandler.accept(new RestPutMappingAction());
import org.opensearch.rest.action.admin.cluster.RestClusterStateAction;
        this.actionPlugins = actionPlugins;
                    catActions.add(abstractCatAction);
import org.opensearch.action.admin.indices.segments.TransportPitSegmentsAction;
        registerHandler.accept(new RestIndexDeleteAliasesAction());
import org.opensearch.rest.action.admin.cluster.RestGetDeploymentAction;
import org.opensearch.rest.action.cat.RestIndicesAction;
import org.opensearch.rest.action.admin.indices.RestAnalyzeAction;
        bind(DynamicActionRegistry.class).toInstance(dynamicActionRegistry);
        return new ActionFilters(
        actions.register(ClusterRerouteAction.INSTANCE, TransportClusterRerouteAction.class);
            registeredActionNames.removeAll(route.actionNames());
     *
import org.opensearch.rest.action.admin.cluster.RestDeleteSnapshotAction;
        actions.register(GetSettingsAction.INSTANCE, TransportGetSettingsAction.class);
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusAction;
import org.opensearch.rest.action.admin.cluster.dangling.RestDeleteDanglingIndexAction;
        registerHandler.accept(new RestGetScriptLanguageAction());
import org.opensearch.action.admin.indices.settings.put.TransportUpdateSettingsAction;
import java.util.function.Supplier;
import org.opensearch.storage.action.tiering.status.GetTieringStatusAction;
import org.opensearch.action.admin.indices.flush.TransportFlushAction;
import org.opensearch.rest.action.admin.cluster.RestDecommissionAction;
import org.opensearch.action.admin.indices.validate.query.ValidateQueryAction;
import org.opensearch.rest.action.search.RestGetAllPitsAction;
            registerHandler.accept(new RestListTieringStatusAction());
import org.opensearch.action.bulk.TransportBulkAction;
        actions.register(CloneSnapshotAction.INSTANCE, TransportCloneSnapshotAction.class);
        actions.register(ClusterAllocationExplainAction.INSTANCE, TransportClusterAllocationExplainAction.class);
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesAction;
        if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)) {
        registerHandler.accept(new RestSyncedFlushAction());
            registeredActionNames.addAll(actionNames);
        actions.register(ResumeIngestionAction.INSTANCE, TransportResumeIngestionAction.class);
            return registeredActionNames.contains(actionName);
        registerHandler.accept(new RestFielddataAction());
         *
import org.opensearch.rest.action.admin.indices.RestRefreshAction;
 * GitHub history for details.
import org.opensearch.action.fieldcaps.TransportFieldCapabilitiesAction;
        actions.register(DeleteComponentTemplateAction.INSTANCE, TransportDeleteComponentTemplateAction.class);
        actions.register(SimulateIndexTemplateAction.INSTANCE, TransportSimulateIndexTemplateAction.class);
import org.opensearch.rest.action.admin.cluster.RestRestoreRemoteStoreAction;
import org.opensearch.rest.action.admin.cluster.RestDeleteStoredScriptAction;
import org.opensearch.rest.action.document.RestGetSourceAction;
import org.opensearch.extensions.ExtensionsManager;
import org.opensearch.rest.action.admin.indices.RestGetMappingAction;
import org.opensearch.rest.action.admin.indices.RestDeleteIndexTemplateAction;
            }
import org.opensearch.action.admin.cluster.node.tasks.list.TransportListTasksAction;
        actions.register(ResolveIndexAction.INSTANCE, ResolveIndexAction.TransportAction.class);
        registerHandler.accept(new RestGetAllPitsAction(nodesInCluster));
        registerHandler.accept(new RestPutRepositoryAction());
import org.opensearch.rest.action.document.RestBulkStreamingAction;
 *
        registerHandler.accept(new RestCatSegmentReplicationAction());
        autoCreateIndex = new AutoCreateIndex(settings, clusterSettings, indexNameExpressionResolver, systemIndices);
        this.settings = settings;
        @SuppressWarnings("rawtypes")
                indexScopedSettings,
import org.opensearch.action.admin.indices.streamingingestion.resume.TransportResumeIngestionAction;
import org.opensearch.rest.action.document.RestTermVectorsAction;
            )) {
        registerHandler.accept(new RestDeleteComponentTemplateAction());
        }
        );
            registeredActionNames.remove(route.name());
        actions.register(NodesUsageAction.INSTANCE, TransportNodesUsageAction.class);
import org.opensearch.action.search.ClearScrollAction;
        registerHandler.accept(new RestSearchAction(clusterSettings));
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsAction;
import org.opensearch.plugins.ActionPlugin.ActionHandler;
import java.util.Collections;
import org.opensearch.http.HttpTransportSettings;
import org.opensearch.action.admin.indices.mapping.get.TransportGetFieldMappingsIndexAction;
        actions.register(UpdatePersistentTaskStatusAction.INSTANCE, UpdatePersistentTaskStatusAction.TransportAction.class);
import org.opensearch.rest.action.admin.cluster.RestGetSnapshotsAction;
    // This is initialized at node bootstrap and contains same-JVM actions
        /**
        /**
import org.opensearch.action.admin.cluster.repositories.delete.TransportDeleteRepositoryAction;
        registerHandler.accept(new RestClusterAllocationExplainAction());
import org.opensearch.rest.action.admin.indices.RestRolloverIndexAction;
 * You may obtain a copy of the License at
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotAction;
        }
        registerHandler.accept(new RestDeleteRepositoryAction());
            if (routeRegistry.remove(route) == null) {
 * under the License.
    private final ClusterSettings clusterSettings;
        actions.register(GetComposableIndexTemplateAction.INSTANCE, TransportGetComposableIndexTemplateAction.class);
            if (newRestWrapper != null) {
import org.opensearch.action.admin.indices.shards.IndicesShardStoresAction;
import org.opensearch.action.admin.indices.template.put.TransportPutComponentTemplateAction;
            Stream.of(
 * compatible open source license.
        actions.register(ClusterHealthAction.INSTANCE, TransportClusterHealthAction.class);
        this.threadPool = threadPool;
import org.opensearch.storage.action.tiering.status.transport.TransportListTieringStatusAction;
import org.opensearch.action.get.TransportMultiGetAction;
        registerHandler.accept(new RestCreateSnapshotAction());
import org.opensearch.persistent.StartPersistentTaskAction;
    private final ExtensionsManager extensionsManager;
            if (isActionRegistered(routeName)) {
import org.opensearch.rest.action.admin.cluster.RestClusterDeleteWeightedRoutingAction;
            if (routeRegistry.containsKey(route)) {
        // Pull-based ingestion actions
         * Add a dynamic action to the registry.
import org.opensearch.action.ingest.DeletePipelineAction;
        actions.register(GetRepositoriesAction.INSTANCE, TransportGetRepositoriesAction.class);
        registerHandler.accept(new RestCreateIndexAction());
        registerHandler.accept(new RestCatRecoveryAction());
        responseLimitSettings = new ResponseLimitSettings(clusterSettings, settings);
import java.util.stream.Collectors;
import org.opensearch.rest.action.admin.indices.RestPauseIngestionAction;
        actions.register(
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsAction;
            TransportMultiTermVectorsAction.class,
         * Remove a dynamic route from the registry.
import org.opensearch.rest.action.cat.RestHealthAction;
            for (ActionType action : actions.keySet()) {
        actions.register(DeletePipelineAction.INSTANCE, DeletePipelineTransportAction.class);
 */
import org.opensearch.threadpool.ThreadPool;
            }
        // point in time actions
        MapBinder<ActionType, TransportAction> transportActionsBinder = MapBinder.newMapBinder(
import static java.util.Collections.unmodifiableMap;
import org.opensearch.rest.action.search.RestClearScrollAction;
            registeredActionNames.add(routeName);
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotAction;
            actions.register(StreamSearchAction.INSTANCE, StreamTransportSearchAction.class);
import org.opensearch.rest.action.admin.indices.RestGetIndexTemplateAction;
        registerHandler.accept(new RestIndicesShardStoresAction());
                throw new IllegalArgumentException("action [" + route + "] was not registered");
import org.opensearch.rest.action.admin.cluster.RestAddVotingConfigExclusionAction;
        actions.register(PutIndexTemplateAction.INSTANCE, TransportPutIndexTemplateAction.class);
    // The unmodifiable map containing OpenSearch and Plugin actions
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteAction;
import org.opensearch.rest.action.search.RestGetSearchPipelineAction;
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryAction;
        actions.register(GetStoredScriptAction.INSTANCE, TransportGetStoredScriptAction.class);
        actions.register(CompletionPersistentTaskAction.INSTANCE, CompletionPersistentTaskAction.TransportAction.class);
import org.opensearch.rest.action.admin.cluster.RestPutRepositoryAction;
        actions.register(ClusterAddWeightedRoutingAction.INSTANCE, TransportAddWeightedRoutingAction.class);
            }
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateAction;
            registerHandler.accept(new RestGetTieringStatusAction());
import org.opensearch.action.admin.indices.mapping.put.PutMappingAction;
import org.opensearch.rest.action.admin.indices.RestGetAliasesAction;
 * Modifications Copyright OpenSearch Contributors. See
        actions.register(AutoCreateAction.INSTANCE, AutoCreateAction.TransportAction.class);
import org.opensearch.action.admin.indices.create.CreateIndexAction;
    }
import org.opensearch.action.admin.indices.template.post.SimulateTemplateAction;
        registerHandler.accept(new RestSegmentsAction(responseLimitSettings));
import org.opensearch.storage.action.tiering.TransportCancelTierAction;
            TransportGetFieldMappingsAction.class,
     * This class is modeled after {@link NamedRegistry} but provides both register and unregister capabilities.
        registerHandler.accept(new RestClusterGetWeightedRoutingAction());
        registerHandler.accept(new RestGetTaskAction());
         * @param action The corresponding instance of RestSendToExtensionAction to execute
import org.opensearch.action.admin.cluster.allocation.TransportClusterAllocationExplainAction;
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.TransportDeleteWeightedRoutingAction;
    /**
         *
import org.opensearch.action.admin.indices.dangling.find.FindDanglingIndexAction;
            bind(action.getTransportAction()).asEagerSingleton();
import org.opensearch.action.admin.indices.close.CloseIndexAction;
import org.opensearch.rest.action.admin.cluster.RestDeleteRepositoryAction;
        actions.register(GetPipelineAction.INSTANCE, GetPipelineTransportAction.class);
                Class<? extends TransportAction<Request, Response>> transportAction,
import org.opensearch.action.admin.indices.open.TransportOpenIndexAction;
        registerHandler.accept(new RestNodesUsageAction());
import org.opensearch.rest.action.cat.RestSegmentsAction;
        /**
import org.opensearch.rest.action.search.RestDeleteSearchPipelineAction;
                settings,
            if (!Collections.disjoint(actionNames, registeredActionNames)) {
        };
                bind(supportAction).asEagerSingleton();
import org.opensearch.storage.action.tiering.WarmToHotTierAction;
import org.opensearch.storage.action.tiering.RestCancelTierAction;
import org.opensearch.action.admin.indices.template.post.TransportSimulateTemplateAction;
        // Remote Store
        // Persistent tasks:
        private final Set<String> registeredActionNames = new ConcurrentSkipListSet<>();
import org.opensearch.rest.action.admin.cluster.RestReloadSecureSettingsAction;
import org.opensearch.action.admin.indices.close.TransportCloseIndexAction;
        // Search Pipelines
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;
import org.opensearch.action.admin.indices.forcemerge.ForceMergeAction;
        registerHandler.accept(new RestGetStoredScriptAction());
                ActionType<Response> action,
         *
import org.opensearch.rest.action.admin.indices.RestGetIngestionStateAction;
import org.opensearch.rest.action.search.RestCreatePitAction;
import org.opensearch.rest.action.admin.cluster.RestGetStoredScriptAction;
        actions.register(RestoreSnapshotAction.INSTANCE, TransportRestoreSnapshotAction.class);
        registerHandler.accept(new RestPutStoredScriptAction());
        actions.register(CreateIndexAction.INSTANCE, TransportCreateIndexAction.class);
import org.opensearch.rest.action.cat.RestShardsAction;
import org.opensearch.action.admin.indices.streamingingestion.state.TransportGetIngestionStateAction;
import org.opensearch.action.delete.DeleteAction;
        registerHandler.accept(new RestThreadPoolAction());
import org.opensearch.action.admin.indices.streamingingestion.pause.TransportPauseIngestionAction;
        registerHandler.accept(new RestRemoteStoreStatsAction());
import org.opensearch.action.admin.indices.exists.indices.TransportIndicesExistsAction;
            public <Request extends ActionRequest, Response extends ActionResponse> void register(
        registerHandler.accept(new RestForceMergeAction());
        registerHandler.accept(new RestAnalyzeAction());
     * The DynamicActionRegistry maintains a registry mapping {@link ActionType} instances to {@link TransportAction} instances.
        actions.register(CreateSnapshotAction.INSTANCE, TransportCreateSnapshotAction.class);
import org.opensearch.action.admin.cluster.snapshots.status.TransportSnapshotsStatusAction;
import org.opensearch.action.admin.cluster.reroute.TransportClusterRerouteAction;
            MultiTermVectorsAction.INSTANCE,
        );
            TransportGetFieldMappingsIndexAction.class
        }
import java.util.stream.Stream;
import org.opensearch.action.admin.cluster.health.ClusterHealthAction;
        actions.register(RefreshAction.INSTANCE, TransportRefreshAction.class);
import org.opensearch.rest.action.cat.RestAllocationAction;
import org.opensearch.action.search.SearchScrollAction;
        clusterSettings.addSettingsUpdateConsumer(
        actions.register(WlmStatsAction.INSTANCE, TransportWlmStatsAction.class);
        for (ActionHandler<?, ?> action : actions.values()) {
import org.opensearch.action.admin.indices.shards.TransportIndicesShardStoresAction;
 * specific language governing permissions and limitations
        actions.register(TermVectorsAction.INSTANCE, TransportTermVectorsAction.class);
import org.opensearch.action.admin.cluster.snapshots.clone.TransportCloneSnapshotAction;
        actions.register(PutIndexFieldDomainsAction.INSTANCE, TransportPutIndexFieldDomainsAction.class);
        IndexScopedSettings indexScopedSettings,
import org.opensearch.rest.action.admin.cluster.RestVerifyRepositoryAction;
                throw new IllegalArgumentException("action [" + action.name() + "] already registered");
        registerHandler.accept(new RestCreatePitAction());
        registerHandler.accept(new RestCleanupRepositoryAction());
import org.opensearch.action.admin.indices.mapping.get.TransportGetMappingsAction;
import org.opensearch.rest.action.admin.cluster.RestPruneBlockCacheAction;
        actions.register(GetIngestionStateAction.INSTANCE, TransportGetIngestionStateAction.class);
import org.opensearch.action.admin.indices.dangling.delete.DeleteDanglingIndexAction;
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.action.search.MultiSearchAction;
import org.opensearch.action.termvectors.TransportShardMultiTermsVectorAction;
import org.opensearch.rest.action.admin.cluster.RestCleanupRepositoryAction;
        // Deployment API
            return registry.get(action);
        if (FeatureFlags.isEnabled(FeatureFlags.EXTENSIONS)) {
        registerHandler.accept(new RestShardsAction());
            actions.register(ExtensionProxyAction.INSTANCE, ExtensionProxyTransportAction.class);
import org.opensearch.rest.action.cat.RestSnapshotAction;
    }
 *
        actions.register(UpdateIngestionStateAction.INSTANCE, TransportUpdateIngestionStateAction.class);
                if (handler instanceof AbstractListAction abstractListAction && abstractListAction.isActionPaginated()) {
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptAction;
        actions.register(SearchAction.INSTANCE, TransportSearchAction.class);
import org.opensearch.rest.action.admin.cluster.RestClusterHealthAction;
        actions.register(RetentionLeaseActions.Add.INSTANCE, RetentionLeaseActions.Add.TransportAction.class);
import org.opensearch.rest.action.admin.cluster.RestClusterUpdateSettingsAction;
        registerHandler.accept(new RestResizeHandler.RestSplitIndexAction());
        // Fully qualified to prevent interference with rest.action.indices.RestRecoveryAction
import org.opensearch.common.inject.multibindings.MapBinder;
        registerHandler.accept(new RestCancelTasksAction(nodesInCluster));
            GetFieldMappingsAction.INSTANCE,
 * this file be licensed under the Apache-2.0 license or a
        registerHandler.accept(new RestDeleteSearchPipelineAction());
import org.opensearch.action.admin.cluster.repositories.cleanup.TransportCleanupRepositoryAction;
        public void unregisterDynamicRoute(NamedRoute route) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        Consumer<RestHandler> registerHandler = handler -> {
        actions.register(AnalyzeAction.INSTANCE, TransportAnalyzeAction.class);
        actions.register(CloseIndexAction.INSTANCE, TransportCloseIndexAction.class);
        registerHandler.accept(new RestFieldCapabilitiesAction());
import org.opensearch.action.admin.indices.refresh.TransportRefreshAction;
import org.opensearch.action.search.TransportMultiSearchAction;
        actions.register(DecommissionAction.INSTANCE, TransportDecommissionAction.class);
import org.opensearch.action.admin.cluster.filecache.TransportPruneFileCacheAction;
            actions.register(ListTieringStatusAction.INSTANCE, TransportListTieringStatusAction.class);
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction;
        registerHandler.accept(new RestUpdateAction());
import org.opensearch.action.admin.indices.create.TransportCreateIndexAction;
import org.opensearch.action.admin.indices.upgrade.post.UpgradeAction;
    private final SystemIndices systemIndices;
import org.apache.logging.log4j.LogManager;
        bind(ActionFilters.class).toInstance(actionFilters);
            actionPlugins.stream().flatMap(p -> p.mappingRequestValidators().stream()).collect(Collectors.toList())
                new RestHeaderDefinition(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, false)
    public ActionFilters getActionFilters() {
        actions.register(DeletePitAction.INSTANCE, TransportDeletePitAction.class);
        actions.register(ListTasksAction.INSTANCE, TransportListTasksAction.class);
import org.opensearch.rest.NamedRoute;
        actions.register(TransitionDeploymentAction.INSTANCE, TransportTransitionDeploymentAction.class);
import org.opensearch.action.admin.indices.mapping.get.GetMappingsAction;
import org.opensearch.persistent.UpdatePersistentTaskStatusAction;
        actions.register(GetDecommissionStateAction.INSTANCE, TransportGetDecommissionStateAction.class);
        actions.register(SimulateTemplateAction.INSTANCE, TransportSimulateTemplateAction.class);
import org.opensearch.rest.action.cat.RestNodesAction;
        registerHandler.accept(new RestValidateQueryAction());
import org.opensearch.rest.action.admin.cluster.RestDeleteTaskAction;
import org.opensearch.rest.action.admin.cluster.RestClusterAllocationExplainAction;
        actions.register(GetAction.INSTANCE, TransportGetAction.class);
        registerHandler.accept(new RestDeleteDanglingIndexAction());
            return null;
import org.opensearch.rest.action.admin.indices.RestCreateIndexAction;
            }
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsAction;
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotAction;
        actions.register(ScaleIndexAction.INSTANCE, TransportScaleIndexAction.class);
        public void registerDynamicRoute(NamedRoute route, RestSendToExtensionAction action) {
import org.opensearch.rest.action.admin.cluster.RestCancelTasksAction;
        actions.register(GetSearchPipelineAction.INSTANCE, GetSearchPipelineTransportAction.class);
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsAction;
        registerHandler.accept(new RestClusterSearchShardsAction());
        registerHandler.accept(new RestClusterManagerAction());
        actions.register(GetAliasesAction.INSTANCE, TransportGetAliasesAction.class);
    }
import org.opensearch.indices.SystemIndices;
        public void unregisterDynamicAction(ActionType<?> action) {
    public static class DynamicActionRegistry {
        registerHandler.accept(new RestTermVectorsAction());
import org.opensearch.action.admin.indices.template.delete.TransportDeleteIndexTemplateAction;
        actions.register(IndicesAliasesAction.INSTANCE, TransportIndicesAliasesAction.class);
    // It will be wrapped in the Dynamic Action Registry but otherwise
    private final ActionFilters actionFilters;
        UnaryOperator<RestHandler> restWrapper = null;
import org.opensearch.action.admin.cluster.node.usage.TransportNodesUsageAction;
            }
import org.opensearch.rest.action.document.RestMultiTermVectorsAction;
        registerHandler.accept(new RestGetRepositoriesAction(settingsFilter));
    // and also registers dynamic actions which may be unregistered. Usually
        registerHandler.accept(new RestClusterPutWeightedRoutingAction());
import org.opensearch.action.admin.indices.alias.get.TransportGetAliasesAction;
import org.opensearch.action.admin.indices.datastream.CreateDataStreamAction;
        registerHandler.accept(new RestUpgradeStatusAction());
import org.opensearch.action.search.TransportGetAllPitsAction;
import org.opensearch.action.admin.indices.settings.get.GetSettingsAction;
        List<AbstractCatAction> catActions = new ArrayList<>();
        registerHandler.accept(new RestPauseIngestionAction());
    public void initRestHandlers(Supplier<DiscoveryNodes> nodesInCluster) {
import org.opensearch.extensions.rest.RestInitializeExtensionAction;
        registerHandler.accept(new RestNodesHotThreadsAction());
import org.opensearch.rest.action.admin.cluster.RestWlmStatsAction;
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryAction;
        registerHandler.accept(new RestCloneSnapshotAction());
        actions.register(
        // Data streams:
    public DynamicActionRegistry getDynamicActionRegistry() {
        // Search pipelines API
        actions.register(ClusterSearchShardsAction.INSTANCE, TransportClusterSearchShardsAction.class);
                }
    private final ResponseLimitSettings responseLimitSettings;
import org.opensearch.action.admin.indices.segments.PitSegmentsAction;
import org.opensearch.common.settings.Settings;
import org.opensearch.action.search.TransportCreatePitAction;
        registerHandler.accept(new RestClusterHealthAction());
import org.opensearch.rest.action.admin.indices.RestIndicesSegmentsAction;
import org.opensearch.action.admin.indices.analyze.TransportAnalyzeAction;
            }
        actions.register(DeleteIndexAction.INSTANCE, TransportDeleteIndexAction.class);
        UsageService usageService,
import org.opensearch.action.admin.cluster.deployment.TransitionDeploymentAction;
import org.opensearch.rest.action.list.RestShardsListAction;
        }
import org.opensearch.rest.action.admin.indices.RestAddIndexBlockAction;
            }
        registerHandler.accept(new RestPutPipelineAction());
        registerHandler.accept(new RestIndicesAliasesAction());
        actions.register(RetentionLeaseActions.Remove.INSTANCE, RetentionLeaseActions.Remove.TransportAction.class);
            registeredActionNames.add(action.name());
            requireNonNull(routeName, "route name is required");
            }
import org.opensearch.action.admin.cluster.decommission.awareness.get.TransportGetDecommissionStateAction;
        // FileCache API
    }
    // remains unchanged from its prior purpose, and registered actions
        // A dynamic registry to add or remove ActionType / TransportAction pairs
import org.opensearch.action.admin.indices.refresh.RefreshAction;
        registerHandler.accept(new RestUpdateSettingsAction());
        registerHandler.accept(new RestGetIndicesAction());
        List<ActionPlugin> actionPlugins,
import org.opensearch.rest.action.admin.cluster.RestSnapshotsStatusAction;
    private final IndexNameExpressionResolver indexNameExpressionResolver;
    // a different JVM and possibly on a different server.
import org.opensearch.rest.action.admin.indices.RestIndicesStatsAction;
        // Fully qualified to prevent interference with rest.action.count.RestCountAction
import org.opensearch.rest.action.admin.indices.RestDeleteIndexAction;
import org.opensearch.cluster.node.DiscoveryNodes;
        actions.register(RemoteInfoAction.INSTANCE, TransportRemoteInfoAction.class);
import org.opensearch.rest.RestController;
                }
import org.opensearch.action.admin.indices.template.delete.TransportDeleteComponentTemplateAction;
        actions.register(PutStoredScriptAction.INSTANCE, TransportPutStoredScriptAction.class);
            for (RestHandler handler : plugin.getRestHandlers(
        actions.register(ClusterStatsAction.INSTANCE, TransportClusterStatsAction.class);
                indexNameExpressionResolver,
import org.opensearch.action.admin.cluster.snapshots.get.TransportGetSnapshotsAction;
import org.opensearch.action.admin.indices.fielddomain.TransportPutIndexFieldDomainsAction;
import org.opensearch.rest.action.admin.indices.RestGetFieldMappingAction;
import org.opensearch.rest.action.admin.cluster.RestClusterSearchShardsAction;
        }).toInstance(mappingRequestValidators);
import org.opensearch.action.admin.indices.scale.searchonly.ScaleIndexAction;
        actions.register(RetentionLeaseActions.Renew.INSTANCE, RetentionLeaseActions.Renew.TransportAction.class);
import org.opensearch.action.ingest.SimulatePipelineAction;
import org.opensearch.rest.action.cat.RestClusterManagerAction;
        actions.register(IndicesShardStoresAction.INSTANCE, TransportIndicesShardStoresAction.class);
        // Data Stream API
import org.opensearch.action.explain.TransportExplainAction;
import org.opensearch.action.admin.indices.template.get.TransportGetIndexTemplatesAction;
            ActionRegistry() {
         * @param actionName The name of the action to check
import org.opensearch.rest.action.admin.indices.RestResizeHandler;
     * <p>
        registerHandler.accept(new RestAllocationAction());
        registerHandler.accept(new RestResolveIndexAction());
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateAction;
import org.opensearch.rest.action.document.RestGetAction;
        actions.register(ClusterStateAction.INSTANCE, TransportClusterStateAction.class);
        registerHandler.accept(new RestRecoveryAction());
import org.opensearch.action.admin.indices.forcemerge.TransportForceMergeAction;
import org.opensearch.action.explain.ExplainAction;
        return unmodifiableMap(actions.getRegistry());
        }
 * KIND, either express or implied.  See the License for the
import org.opensearch.rest.action.admin.indices.RestSyncedFlushAction;
                throw new IllegalArgumentException("route [" + route + "] already registered");
        }
            requireNonNull(action, "action is required");
        actions.register(PutSearchPipelineAction.INSTANCE, PutSearchPipelineTransportAction.class);
import org.opensearch.persistent.CompletionPersistentTaskAction;
        registerHandler.accept(new RestRestoreSnapshotAction());
import org.opensearch.common.inject.TypeLiteral;
            }
        }
        restController.setRequestIdMaxLength(HttpTransportSettings.SETTING_HTTP_REQUEST_ID_MAX_LENGTH.get(settings));
        actions.register(IndicesExistsAction.INSTANCE, TransportIndicesExistsAction.class);
import org.opensearch.action.admin.indices.template.post.SimulateIndexTemplateAction;
import org.opensearch.action.ingest.PutPipelineTransportAction;
        actions.register(RestoreRemoteStoreAction.INSTANCE, TransportRestoreRemoteStoreAction.class);
        private Map<ActionType, TransportAction> actions = Collections.emptyMap();
import org.opensearch.rest.action.admin.indices.RestPutMappingAction;
/*
import org.opensearch.rest.action.admin.cluster.RestGetScriptContextAction;
        actions.register(GetComponentTemplateAction.INSTANCE, TransportGetComponentTemplateAction.class);
import org.opensearch.rest.action.admin.indices.RestRecoveryAction;
            // Only NamedRoutes are map keys so any other route is not in the map
import org.opensearch.action.admin.indices.template.get.TransportGetComposableIndexTemplateAction;
        actions.register(ListDanglingIndicesAction.INSTANCE, TransportListDanglingIndicesAction.class);
        registerHandler.accept(new RestResizeHandler.RestShrinkIndexAction());
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsAction;
        List<AbstractListAction> listActions = new ArrayList<>();
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryAction;
import org.opensearch.action.admin.indices.segments.TransportIndicesSegmentsAction;
            if (registry.remove(action) == null) {
 *
                register(new ActionHandler<>(action, transportAction, supportTransportActions));
        actions.register(ForceMergeAction.INSTANCE, TransportForceMergeAction.class);
        registerHandler.accept(new RestOpenIndexAction());
    private final IndexScopedSettings indexScopedSettings;
import org.opensearch.action.admin.indices.readonly.TransportAddIndexBlockAction;
        // action handler registration.
            restController::setRequestIdMaxLength
import java.util.ArrayList;
        registerHandler.accept(new RestClusterUpdateSettingsAction());
import org.opensearch.rest.action.admin.indices.RestPutComponentTemplateAction;
        registerHandler.accept(new RestDataStreamsStatsAction());
                Class<?>... supportTransportActions
import org.opensearch.persistent.RemovePersistentTaskAction;
import org.opensearch.rest.action.admin.indices.RestSimulateTemplateAction;
import org.opensearch.action.admin.indices.shrink.ResizeAction;
import org.opensearch.rest.action.search.RestCountAction;
import org.opensearch.action.admin.indices.alias.IndicesAliasesAction;
import org.opensearch.rest.action.admin.cluster.RestGetRepositoriesAction;
import org.opensearch.rest.action.document.RestIndexAction;
        }
            }
        registerHandler.accept(new RestNodesAction());
        public void registerUnmodifiableActionMap(Map<ActionType, TransportAction> actions) {
        actions.register(RolloverAction.INSTANCE, TransportRolloverAction.class);
            Collections.unmodifiableSet(actionPlugins.stream().flatMap(p -> p.getActionFilters().stream()).collect(Collectors.toSet()))
        registerHandler.accept(new RestMultiGetAction(settings));
         * Checks to see if an action is registered provided an action name
 * software distributed under the License is distributed on an
import org.opensearch.action.get.GetAction;
        actions.register(ClusterUpdateSettingsAction.INSTANCE, TransportClusterUpdateSettingsAction.class);
        registerHandler.accept(new RestGetComposableIndexTemplateAction());
            }
import org.opensearch.rest.action.admin.cluster.RestTransitionDeploymentAction;
 * the Apache License, Version 2.0 (the "License"); you may
         *
        bind(DestructiveOperations.class).toInstance(destructiveOperations);
import org.opensearch.rest.action.admin.indices.RestGetIndicesAction;
 * not use this file except in compliance with the License.
        class ActionRegistry extends NamedRegistry<ActionHandler<?, ?>> {
        actions.register(MainAction.INSTANCE, TransportMainAction.class);
                );
import org.opensearch.common.annotation.PublicApi;
        // Subclass NamedRegistry for easy registration
import org.opensearch.rest.action.admin.indices.RestDeleteComposableIndexTemplateAction;
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksAction;
        registerHandler.accept(new RestAliasAction());
                    "action" + (alreadyRegistered.size() > 1 ? "s [" : " [") + acts + "] already registered"
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataAction;
import org.opensearch.action.search.TransportSearchScrollAction;
        registerHandler.accept(new RestMultiSearchAction(settings));
import org.opensearch.rest.action.admin.indices.RestPutIndexTemplateAction;
import org.opensearch.rest.action.cat.RestCatAction;
import org.opensearch.common.util.FeatureFlags;
        actions.register(ClearVotingConfigExclusionsAction.INSTANCE, TransportClearVotingConfigExclusionsAction.class);
        actions.register(CleanupRepositoryAction.INSTANCE, TransportCleanupRepositoryAction.class);
        actions.register(ValidateQueryAction.INSTANCE, TransportValidateQueryAction.class);
        actions.register(GetTaskAction.INSTANCE, TransportGetTaskAction.class);
         *
        dynamicActionRegistry = new DynamicActionRegistry();
import org.opensearch.action.search.StreamSearchAction;
        registerHandler.accept(new RestGetScriptContextAction());
        registerHandler.accept(new RestDeleteTaskAction());
        registerHandler.accept(new RestRolloverIndexAction());
import org.opensearch.action.admin.indices.template.get.GetComponentTemplateAction;
import org.opensearch.action.get.TransportShardMultiGetAction;
import org.opensearch.rest.action.search.RestExplainAction;
                restController,
        registerHandler.accept(new RestExplainAction());
        // Point in time API
import org.opensearch.action.search.CreatePitAction;
import org.opensearch.rest.action.admin.indices.RestDeleteComponentTemplateAction;
import org.opensearch.rest.action.document.RestIndexAction.AutoIdHandler;
import org.opensearch.action.support.DestructiveOperations;
         */
            binder(),
                clusterSettings,
        actions.register(GetScriptLanguageAction.INSTANCE, TransportGetScriptLanguageAction.class);
                throw new IllegalArgumentException(
import org.opensearch.action.bulk.BulkAction;
        actions.register(MultiSearchAction.INSTANCE, TransportMultiSearchAction.class);
import org.opensearch.action.admin.indices.template.post.TransportSimulateIndexTemplateAction;
        actions.register(DataStreamsStatsAction.INSTANCE, DataStreamsStatsAction.TransportAction.class);
        // Tiering status actions
        );
import org.opensearch.rest.action.admin.indices.RestGetComposableIndexTemplateAction;
        actions.register(GetTermVersionAction.INSTANCE, TransportGetTermVersionAction.class);
import org.opensearch.action.termvectors.TransportTermVectorsAction;
        registerHandler.accept(new RestPutComposableIndexTemplateAction());
import java.util.Map;
            }
    private static final Logger logger = LogManager.getLogger(ActionModule.class);
import org.opensearch.action.admin.cluster.repositories.put.TransportPutRepositoryAction;
        );
    public ActionModule(
import org.opensearch.action.admin.indices.template.put.PutComponentTemplateAction;
        actions.register(
        actions.register(DeleteDataStreamAction.INSTANCE, DeleteDataStreamAction.TransportAction.class);
import org.opensearch.action.admin.cluster.configuration.TransportAddVotingConfigExclusionsAction;
    // associated with remote action execution on extensions, possibly in
import org.opensearch.common.NamedRegistry;
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingAction;
import org.opensearch.action.admin.cluster.decommission.awareness.put.TransportDecommissionAction;
        actions.register(GetDataStreamAction.INSTANCE, GetDataStreamAction.TransportAction.class);
        actions.register(DeleteStoredScriptAction.INSTANCE, TransportDeleteStoredScriptAction.class);
            TransportShardMultiTermsVectorAction.class
        destructiveOperations = new DestructiveOperations(settings, clusterSettings);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        actions.register(PutMappingAction.INSTANCE, TransportPutMappingAction.class);
        actions.register(AddVotingConfigExclusionsAction.INSTANCE, TransportAddVotingConfigExclusionsAction.class);
        this.clusterSettings = clusterSettings;
         * @param action The {@link ActionType}.
import org.opensearch.action.support.AutoCreateIndex;
        actions.register(DeleteRepositoryAction.INSTANCE, TransportDeleteRepositoryAction.class);
import org.opensearch.action.admin.cluster.state.TransportClusterStateAction;
        registerHandler.accept(new RestDeleteDataStreamAction());
        actions.register(NodesHotThreadsAction.INSTANCE, TransportNodesHotThreadsAction.class);
        registerHandler.accept(new RestReloadSecureSettingsAction());
import org.opensearch.usage.UsageService;
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptAction;
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsAction;
        // Tiering status api
        bind(new TypeLiteral<RequestValidators<IndicesAliasesRequest>>() {
import org.opensearch.rest.RestHeaderDefinition;
import org.opensearch.rest.action.search.RestPutSearchPipelineAction;
import org.opensearch.rest.action.admin.cluster.RestGetDecommissionStateAction;
        registerHandler.accept(new RestTransitionDeploymentAction());
                register(handler.getAction().name(), handler);
import org.opensearch.action.admin.cluster.configuration.TransportClearVotingConfigExclusionsAction;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
import org.opensearch.action.admin.indices.recovery.RecoveryAction;
        actions.register(NodesReloadSecureSettingsAction.INSTANCE, TransportNodesReloadSecureSettingsAction.class);
    @PublicApi(since = "2.7.0")
            // bind the action as eager singleton, so the map binder one will reuse it
        private final Map<ActionType<?>, TransportAction<?, ?>> registry = new ConcurrentHashMap<>();
import org.opensearch.common.inject.AbstractModule;
import org.opensearch.rest.action.admin.indices.RestDeleteDataStreamAction;
import org.opensearch.rest.action.admin.cluster.RestClusterRerouteAction;
        registerHandler.accept(new RestDeleteDecommissionStateAction());
import org.opensearch.action.update.TransportUpdateAction;
import org.opensearch.rest.action.cat.RestPitSegmentsAction;
        actions.register(ResizeAction.INSTANCE, TransportResizeAction.class);
            for (Class<?> supportAction : action.getSupportTransportActions()) {
import org.opensearch.rest.action.admin.cluster.RestCreateSnapshotAction;
        ActionRegistry actions = new ActionRegistry();
         * @param transportAction The corresponding instance of transportAction to execute
        registerHandler.accept(new RestClusterStatsAction());
        Set<RestHeaderDefinition> headers = Stream.concat(
         * @return the corresponding {@link RestSendToExtensionAction} if it is registered, null otherwise.
import org.opensearch.rest.action.ingest.RestSimulatePipelineAction;
import org.opensearch.action.admin.cluster.node.liveness.TransportLivenessAction;
import org.opensearch.action.search.GetAllPitsAction;
import org.opensearch.rest.action.admin.cluster.RestDeleteDecommissionStateAction;
        /**
        registerHandler.accept(new RestDeletePipelineAction());
import org.opensearch.action.search.PutSearchPipelineAction;
import org.opensearch.action.admin.indices.segments.IndicesSegmentsAction;
            if (actions.containsKey(action) || registry.putIfAbsent(action, transportAction) != null) {
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainAction;
        return actions;
    ) {
        registerHandler.accept(new RestGetMappingAction(threadPool));
        }
        registerHandler.accept(new RestBulkStreamingAction(settings));
import org.opensearch.identity.IdentityService;
import org.opensearch.rest.action.search.RestSearchScrollAction;
        registerHandler.accept(new AutoIdHandler(nodesInCluster));
import org.opensearch.action.admin.cluster.node.tasks.delete.DeleteTaskAction;
                settingsFilter,
            )
import org.opensearch.action.admin.indices.alias.TransportIndicesAliasesAction;
        registerHandler.accept(new RestGetComponentTemplateAction());
        actions.register(NodesStatsAction.INSTANCE, TransportNodesStatsAction.class);
 */
    public RestController getRestController() {
import org.opensearch.action.admin.indices.mapping.put.AutoPutMappingAction;
import org.opensearch.storage.action.tiering.TransportWarmToHotTierAction;
        actions.register(PitSegmentsAction.INSTANCE, TransportPitSegmentsAction.class);
import org.opensearch.action.admin.cluster.node.reload.TransportNodesReloadSecureSettingsAction;
                } else {
    }
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionAction;
import org.opensearch.rest.action.admin.indices.RestCreateDataStreamAction;
        registerHandler.accept(new RestDeleteIndexAction());
import org.opensearch.action.admin.indices.get.GetIndexAction;
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesAction;
        actions.register(UpgradeStatusAction.INSTANCE, TransportUpgradeStatusAction.class);
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.action.admin.cluster.snapshots.delete.TransportDeleteSnapshotAction;
        // This is the unmodifiable actions map created during node bootstrap, which
            registeredActionNames.remove(action.name());
import java.util.concurrent.ConcurrentHashMap;
            registerHandler.accept(new RestHotToWarmTierAction());
 * license agreements. See the NOTICE file distributed with
                super("action");
import org.opensearch.action.main.TransportMainAction;
        registerHandler.accept(new RestTemplatesAction());
        return actionFilters;
        actions.register(GetAllPitsAction.INSTANCE, TransportGetAllPitsAction.class);
    static Map<String, ActionHandler<?, ?>> setupActions(List<ActionPlugin> actionPlugins) {
                throw new IllegalArgumentException("action [" + action.name() + "] was not registered");
        registerHandler.accept(new RestWlmStatsAction());
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryAction;
import org.apache.logging.log4j.Logger;
import org.opensearch.action.search.StreamTransportSearchAction;
import org.opensearch.action.admin.indices.dangling.import_index.ImportDanglingIndexAction;
         *
         * @param route The route instance to add
import org.opensearch.action.admin.indices.dangling.list.TransportListDanglingIndicesAction;
        /**
    }
import static java.util.Objects.requireNonNull;
import org.opensearch.action.admin.indices.cache.clear.TransportClearIndicesCacheAction;
        actions.register(OpenIndexAction.INSTANCE, TransportOpenIndexAction.class);
            }
        registerHandler.accept(new org.opensearch.rest.action.cat.RestCountAction());
        for (ActionPlugin plugin : actionPlugins) {
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
import org.opensearch.rest.action.cat.RestCatSegmentReplicationAction;
import org.opensearch.action.admin.cluster.storedscripts.TransportDeleteStoredScriptAction;
import java.util.Set;
import org.opensearch.storage.action.tiering.RestHotToWarmTierAction;
import org.opensearch.rest.action.admin.cluster.RestClusterGetSettingsAction;
import org.opensearch.action.fieldcaps.FieldCapabilitiesAction;
import org.opensearch.rest.action.admin.indices.RestClearIndicesCacheAction;
import org.opensearch.extensions.action.ExtensionProxyTransportAction;
import java.util.function.Consumer;
        // Dangling indices
        registerHandler.accept(new RestDeleteSnapshotAction());
import org.opensearch.action.main.MainAction;
                return actions.get(action);
import org.opensearch.storage.action.tiering.status.ListTieringStatusAction;
import org.opensearch.action.admin.indices.recovery.TransportRecoveryAction;
import org.opensearch.action.admin.indices.scale.searchonly.TransportScaleIndexAction;
            actions.register(CancelTieringAction.INSTANCE, TransportCancelTierAction.class);
            TransportFieldCapabilitiesAction.class,
import org.opensearch.rest.action.list.RestListAction;
            public void register(ActionHandler<?, ?> handler) {
import org.opensearch.rest.action.admin.cluster.RestNodesUsageAction;
import org.opensearch.rest.action.cat.RestRepositoriesAction;
import org.opensearch.rest.action.admin.cluster.RestPutStoredScriptAction;
    private final DynamicActionRegistry dynamicActionRegistry;
import org.opensearch.action.admin.indices.mapping.get.TransportGetFieldMappingsAction;
import org.opensearch.rest.action.list.AbstractListAction;
            UnaryOperator<RestHandler> newRestWrapper = plugin.getRestHandlerWrapper(threadPool.getThreadContext(), headers);
        actions.register(UpgradeSettingsAction.INSTANCE, TransportUpgradeSettingsAction.class);
        actions.register(DeleteComposableIndexTemplateAction.INSTANCE, TransportDeleteComposableIndexTemplateAction.class);
        registerHandler.accept(new RestClusterStateAction(settingsFilter));
        bind(TransportLivenessAction.class).asEagerSingleton();
        actions.register(GetSnapshotsAction.INSTANCE, TransportGetSnapshotsAction.class);
import org.opensearch.action.admin.cluster.tasks.TransportPendingClusterTasksAction;
import org.opensearch.rest.action.admin.cluster.RestRemoteStoreMetadataAction;
 * this work for additional information regarding copyright
        }
import org.opensearch.rest.action.document.RestBulkAction;
import org.opensearch.action.get.TransportGetAction;
                new RestHeaderDefinition(Task.X_OPAQUE_ID, false),
        // register ActionType -> transportAction Map used by NodeClient
import org.opensearch.action.admin.cluster.deployment.GetDeploymentAction;
import org.opensearch.rest.action.admin.indices.RestForceMergeAction;
import org.opensearch.rest.action.list.RestIndicesListAction;
import org.opensearch.rest.action.cat.RestThreadPoolAction;
import org.opensearch.action.search.PutSearchPipelineTransportAction;
import org.opensearch.action.search.TransportClearScrollAction;
import org.opensearch.action.ingest.GetPipelineTransportAction;
        registerHandler.accept(new RestUpgradeAction());
        registerHandler.accept(new RestBulkAction(settings));
import org.opensearch.action.admin.cluster.node.stats.NodesStatsAction;
            restController.registerHandler(handler);
        registerHandler.accept(new RestFlushAction());
import org.opensearch.action.admin.cluster.settings.TransportClusterUpdateSettingsAction;
import org.opensearch.action.ingest.DeletePipelineTransportAction;
import org.opensearch.rest.action.document.RestUpdateAction;
}
import org.opensearch.storage.action.tiering.PrepareTieringAction;
            actionPlugins.stream().flatMap(p -> p.getRestHeaders().stream()),
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreAction;
import org.opensearch.rest.action.admin.cluster.RestPruneCacheAction;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.action.admin.indices.stats.TransportIndicesStatsAction;
import org.opensearch.action.admin.indices.create.AutoCreateAction;
        actions.register(DeleteSnapshotAction.INSTANCE, TransportDeleteSnapshotAction.class);
import org.opensearch.plugins.ActionPlugin;
        registerHandler.accept(new RestCloseIndexAction());
        // Indexed scripts
        }
import org.opensearch.rest.action.admin.indices.RestUpdateSettingsAction;
        registerHandler.accept(new RestPitSegmentsAction(nodesInCluster));
import org.opensearch.rest.action.admin.indices.RestPutComposableIndexTemplateAction;
import org.opensearch.action.admin.indices.template.delete.DeleteComponentTemplateAction;
                new RestHeaderDefinition(Task.X_REQUEST_ID, false),
        actions.register(MultiGetAction.INSTANCE, TransportMultiGetAction.class, TransportShardMultiGetAction.class);
        registerHandler.accept(new RestPutSearchPipelineAction());
import java.util.function.UnaryOperator;
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingAction;
        registerHandler.accept(new RestGetDataStreamsAction());
            routeRegistry.put(route, action);
         * @return the corresponding {@link TransportAction} if it is registered, null otherwise.
            TransportAction.class
import org.opensearch.rest.action.ingest.RestDeletePipelineAction;
    private final AutoCreateIndex autoCreateIndex;
        registerHandler.accept(new RestIndicesStatsAction());
import org.opensearch.action.admin.cluster.health.TransportClusterHealthAction;
        registerHandler.accept(new RestPluginsAction());
        registerHandler.accept(new org.opensearch.rest.action.cat.RestPendingClusterTasksAction());
        registerHandler.accept(new RestDeletePitAction());
        actions.register(ImportDanglingIndexAction.INSTANCE, TransportImportDanglingIndexAction.class);
         * Register the immutable actions in the registry.
import org.opensearch.action.admin.cluster.node.info.NodesInfoAction;
import org.opensearch.action.admin.indices.template.get.TransportGetComponentTemplateAction;
import org.opensearch.action.admin.indices.alias.get.GetAliasesAction;
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheAction;
import org.opensearch.rest.action.cat.RestTemplatesAction;
 *
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.TransportAddWeightedRoutingAction;
import org.opensearch.storage.action.tiering.status.rest.RestListTieringStatusAction;
        actions.register(RecoveryAction.INSTANCE, TransportRecoveryAction.class);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.action.admin.indices.template.delete.DeleteComposableIndexTemplateAction;
import org.opensearch.action.admin.cluster.node.info.TransportNodesInfoAction;
    protected void configure() {
import org.opensearch.rest.action.admin.indices.RestIndicesAliasesAction;
import org.opensearch.action.get.MultiGetAction;
package org.opensearch.action;
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.TransportGetWeightedRoutingAction;
        registerHandler.accept(new RestGetAction());
        }
        );
         */
import org.opensearch.action.admin.indices.template.put.TransportPutIndexTemplateAction;
import org.opensearch.action.admin.cluster.wlm.TransportWlmStatsAction;
        private final Map<NamedRoute, RestSendToExtensionAction> routeRegistry = new ConcurrentHashMap<>();
import org.opensearch.rest.action.admin.indices.RestUpgradeAction;
import org.opensearch.rest.action.admin.cluster.RestClearVotingConfigExclusionsAction;
import org.opensearch.action.admin.indices.upgrade.post.UpgradeSettingsAction;
import org.opensearch.rest.action.document.RestIndexAction.CreateHandler;
import org.opensearch.action.admin.cluster.shards.TransportClusterSearchShardsAction;
import org.opensearch.rest.action.admin.indices.RestCloseIndexAction;
        // Decommission actions
        registerHandler.accept(new RestShardsListAction());
import org.opensearch.rest.action.admin.cluster.RestNodesHotThreadsAction;
        registerHandler.accept(new RestNodesStatsAction());
        // Supporting classes
        bind(ResponseLimitSettings.class).toInstance(responseLimitSettings);
import org.opensearch.rest.action.ingest.RestPutPipelineAction;
import org.opensearch.action.admin.cluster.blockcache.TransportPruneBlockCacheAction;
        /**
import org.opensearch.action.admin.cluster.storedscripts.TransportGetScriptLanguageAction;
        actions.register(GetIndexTemplatesAction.INSTANCE, TransportGetIndexTemplatesAction.class);
import org.opensearch.action.ingest.GetPipelineAction;
import org.opensearch.action.admin.cluster.storedscripts.GetScriptContextAction;
 */
import org.opensearch.action.search.DeleteSearchPipelineAction;
        actions.register(GetScriptContextAction.INSTANCE, TransportGetScriptContextAction.class);
        registerHandler.accept(new RestGetDeploymentAction());
            requireNonNull(action, "action is required");
        actions = setupActions(actionPlugins);
        registerHandler.accept(new RestIndexPutAliasAction());
        actions.register(CreatePitAction.INSTANCE, TransportCreatePitAction.class);
        registerHandler.accept(new RestPutComponentTemplateAction());
        actions.register(DeleteTaskAction.INSTANCE, TransportDeleteTaskAction.class);
                    listActions.add(abstractListAction);
            this.actions = actions;
import org.opensearch.action.admin.indices.template.put.TransportPutComposableIndexTemplateAction;
import org.opensearch.action.admin.indices.readonly.AddIndexBlockAction;
            ) {
import org.opensearch.storage.action.tiering.status.transport.TransportGetTieringStatusAction;
import org.opensearch.action.admin.indices.rollover.RolloverAction;
    private ActionFilters setupActionFilters(List<ActionPlugin> actionPlugins) {
import org.opensearch.rest.action.search.RestDeletePitAction;
        registerHandler.accept(new RestVerifyRepositoryAction());
        registerHandler.accept(new RestScaleIndexAction());
        actions.register(NodesInfoAction.INSTANCE, TransportNodesInfoAction.class);
import org.opensearch.rest.action.admin.cluster.RestRestoreSnapshotAction;
import org.opensearch.action.admin.cluster.deployment.TransportTransitionDeploymentAction;
import org.opensearch.storage.action.tiering.TransportHotToWarmTierAction;
import org.opensearch.rest.action.admin.indices.RestIndicesShardStoresAction;
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskAction;
import org.opensearch.common.settings.ClusterSettings;
         * @param action The action instance to add
import org.opensearch.action.admin.cluster.node.tasks.get.TransportGetTaskAction;
import org.opensearch.storage.action.tiering.status.rest.RestGetTieringStatusAction;
                nodesInCluster
import org.opensearch.action.admin.indices.delete.DeleteIndexAction;
 * @opensearch.internal
         * Adds a dynamic route to the registry.
                return routeRegistry.get(namedRoute);
import org.opensearch.rest.action.admin.indices.RestGetSettingsAction;
         * @param actions The injected map of {@link ActionType} to {@link TransportAction}
        actions.register(CreateDataStreamAction.INSTANCE, CreateDataStreamAction.TransportAction.class);
import org.opensearch.rest.action.admin.cluster.dangling.RestImportDanglingIndexAction;
        registerHandler.accept(new RestGetIngestionStateAction());
        this.indexScopedSettings = indexScopedSettings;
import org.opensearch.action.admin.indices.datastream.ModifyDataStreamsAction;
        registerHandler.accept(new RestGetPipelineAction());
import org.opensearch.action.admin.indices.template.put.PutComposableIndexTemplateAction;
        public boolean isActionRegistered(String actionName) {
            }
import org.opensearch.action.admin.cluster.snapshots.create.TransportCreateSnapshotAction;
import org.opensearch.extensions.action.ExtensionProxyAction;
import org.opensearch.action.admin.indices.get.TransportGetIndexAction;
import org.opensearch.common.settings.IndexScopedSettings;
import org.opensearch.action.admin.cluster.node.reload.NodesReloadSecureSettingsAction;
        actions.register(ExplainAction.INSTANCE, TransportExplainAction.class);
         */
import org.opensearch.action.admin.indices.replication.TransportSegmentReplicationStatsAction;
        registerHandler.accept(new RestCountAction());
        // LIST API
        actions.register(PutComponentTemplateAction.INSTANCE, TransportPutComponentTemplateAction.class);
        this.systemIndices = systemIndices;
        actions.register(DeleteAction.INSTANCE, TransportDeleteAction.class);
import org.opensearch.action.fieldcaps.TransportFieldCapabilitiesIndexAction;
            actions.register(HotToWarmTierAction.INSTANCE, TransportHotToWarmTierAction.class);
         * @param action The action to remove
        // Ingest API
        actions.register(SearchScrollAction.INSTANCE, TransportSearchScrollAction.class);
        registerHandler.accept(new RestNodeAttrsAction());
            actions.register(GetTieringStatusAction.INSTANCE, TransportGetTieringStatusAction.class);
         *
import org.opensearch.action.admin.cluster.node.hotthreads.TransportNodesHotThreadsAction;
        // Extensions API
        ExtensionsManager extensionsManager
import org.opensearch.action.admin.indices.validate.query.TransportValidateQueryAction;
import org.opensearch.rest.action.document.RestDeleteAction;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.admin.indices.upgrade.post.TransportUpgradeSettingsAction;
        bind(new TypeLiteral<RequestValidators<PutMappingRequest>>() {
        registerHandler.accept(new RestClusterDeleteWeightedRoutingAction());
import org.opensearch.action.search.GetSearchPipelineTransportAction;
import org.opensearch.rest.action.admin.indices.RestIndexDeleteAliasesAction;
        registerHandler.accept(new RestResumeIngestionAction());
         */
        registerHandler.accept(new RestRefreshAction());
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterAddWeightedRoutingAction;
            actions.register(WarmToHotTierAction.INSTANCE, TransportWarmToHotTierAction.class);
import java.util.concurrent.ConcurrentSkipListSet;
        registerHandler.accept(new RestMainAction());
        actions.register(PruneFileCacheAction.INSTANCE, TransportPruneFileCacheAction.class);
        IdentityService identityService,
        actions.register(CancelTasksAction.INSTANCE, TransportCancelTasksAction.class);
import org.opensearch.action.admin.indices.dangling.delete.TransportDeleteDanglingIndexAction;
            ActionType.class,
        );
        actions.register(UpgradeAction.INSTANCE, TransportUpgradeAction.class);
    // A dynamic action registry which includes the above immutable actions
                throw new IllegalArgumentException("route [" + route + "] already registered");
import org.opensearch.rest.RestHandler;
import org.opensearch.action.admin.cluster.remotestore.restore.TransportRestoreRemoteStoreAction;
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesAction;
        this.indexNameExpressionResolver = indexNameExpressionResolver;
            transportActionsBinder.addBinding(action.getAction()).to(action.getTransportAction()).asEagerSingleton();
        );
        actions.register(UpdateAction.INSTANCE, TransportUpdateAction.class);
        registerHandler.accept(new RestGetIndexTemplateAction());
            HttpTransportSettings.SETTING_HTTP_REQUEST_ID_MAX_LENGTH,
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateAction;
import org.opensearch.action.admin.indices.datastream.DeleteDataStreamAction;
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsAction;
import org.opensearch.action.index.TransportIndexAction;
        registerHandler.accept(new RestResizeHandler.RestCloneIndexAction());
    }
    private final RestController restController;
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;
         * Gets the {@link RestSendToExtensionAction} instance corresponding to the {@link RestHandler.Route} instance.
import org.opensearch.action.termvectors.MultiTermVectorsAction;
        actions.register(CatShardsAction.INSTANCE, TransportCatShardsAction.class);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotAction;
import org.opensearch.action.support.ActionFilters;
import org.opensearch.action.admin.cluster.configuration.ClearVotingConfigExclusionsAction;
        registerHandler.accept(new RestClearVotingConfigExclusionsAction());
        registerHandler.accept(new RestGetAliasesAction());
        actions.register(GetIndexAction.INSTANCE, TransportGetIndexAction.class);
                alreadyRegistered.retainAll(actionNames);
        @SuppressWarnings("unchecked")
import org.opensearch.action.admin.indices.shrink.TransportResizeAction;
        }
import org.opensearch.rest.action.admin.indices.RestOpenIndexAction;
        actions.register(DeleteDanglingIndexAction.INSTANCE, TransportDeleteDanglingIndexAction.class);
import org.opensearch.core.action.ActionResponse;
import org.opensearch.action.termvectors.TermVectorsAction;
        }
        actions.register(PutPipelineAction.INSTANCE, PutPipelineTransportAction.class);
import org.opensearch.rest.action.admin.indices.RestGetDataStreamsAction;
import org.opensearch.action.support.clustermanager.term.GetTermVersionAction;
            registerHandler.accept(new RestCancelTierAction());
        registerHandler.accept(new RestImportDanglingIndexAction());
    private final ThreadPool threadPool;
import org.opensearch.action.admin.indices.datastream.GetDataStreamAction;
        registerHandler.accept(new RestModifyDataStreamsAction());
        actions.register(IndicesStatsAction.INSTANCE, TransportIndicesStatsAction.class);
import org.opensearch.action.admin.indices.datastream.DataStreamsStatsAction;
        mappingRequestValidators = new RequestValidators<>(
import org.opensearch.common.settings.SettingsFilter;
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptAction;
        registerHandler.accept(new RestIndicesListAction(responseLimitSettings, systemIndices));
        registerHandler.accept(new RestPutIndexTemplateAction());
     */
import org.opensearch.action.ingest.SimulatePipelineTransportAction;
import org.opensearch.rest.action.admin.indices.RestIndexPutAliasAction;
import org.opensearch.action.search.DeletePitAction;
import org.opensearch.rest.action.admin.cluster.RestNodesInfoAction;
        ).collect(Collectors.toSet());
import org.opensearch.rest.action.search.RestMultiSearchAction;
        registerHandler.accept(new RestCatAction(catActions));
        SettingsFilter settingsFilter,
        return restController;
import org.opensearch.action.admin.cluster.remote.RemoteInfoAction;
        registerHandler.accept(new RestDeleteAction());
        // Dangling indices API
import org.opensearch.rest.action.admin.cluster.RestRemoteStoreStatsAction;
    private final RequestValidators<IndicesAliasesRequest> indicesAliasesRequestRequestValidators;
import org.opensearch.rest.action.admin.indices.RestDataStreamsStatsAction;
import org.opensearch.rest.action.admin.indices.RestSimulateIndexTemplateAction;
            if (route instanceof NamedRoute namedRoute) {
import org.opensearch.rest.action.admin.cluster.RestGetTaskAction;
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheAction;
import org.opensearch.action.admin.indices.dangling.import_index.TransportImportDanglingIndexAction;
        registerHandler.accept(new RestRemoteClusterInfoAction());
import org.opensearch.action.termvectors.TransportMultiTermVectorsAction;
import org.opensearch.rest.action.admin.indices.RestValidateQueryAction;
        }
import org.opensearch.rest.action.RestFieldCapabilitiesAction;
import org.opensearch.common.breaker.ResponseLimitSettings;
            registerHandler.accept(new RestInitializeExtensionAction(extensionsManager));
        registerHandler.accept(new RestRemoteStoreMetadataAction());
import org.opensearch.action.support.TransportAction;
        actions.register(DeleteIndexTemplateAction.INSTANCE, TransportDeleteIndexTemplateAction.class);
                restWrapper = newRestWrapper;
import org.opensearch.action.search.SearchAction;
 * SPDX-License-Identifier: Apache-2.0
/*
        public TransportAction<? extends ActionRequest, ? extends ActionResponse> get(ActionType<?> action) {
        registerHandler.accept(new RestSimulatePipelineAction());
import org.opensearch.rest.action.admin.indices.RestGetComponentTemplateAction;
import org.opensearch.rest.action.cat.RestFielddataAction;
import org.opensearch.extensions.rest.RestSendToExtensionAction;
        actions.register(ClearScrollAction.INSTANCE, TransportClearScrollAction.class);
import org.opensearch.rest.action.search.RestSearchAction;
import java.util.List;
import org.opensearch.action.admin.cluster.node.tasks.cancel.TransportCancelTasksAction;
import org.opensearch.action.admin.indices.mapping.put.TransportAutoPutMappingAction;
import org.opensearch.action.admin.cluster.storedscripts.TransportGetStoredScriptAction;
import org.opensearch.action.admin.indices.open.OpenIndexAction;
import org.opensearch.action.admin.indices.fielddomain.PutIndexFieldDomainsAction;
        actions.register(PutComposableIndexTemplateAction.INSTANCE, TransportPutComposableIndexTemplateAction.class);
         *
import org.opensearch.storage.action.tiering.TransportPrepareTieringAction;
        registerHandler.accept(new RestSearchScrollAction());
import org.opensearch.action.admin.indices.settings.get.TransportGetSettingsAction;
import org.opensearch.action.admin.cluster.remotestore.metadata.TransportRemoteStoreMetadataAction;
        actions.register(DeleteSearchPipelineAction.INSTANCE, DeleteSearchPipelineTransportAction.class);
        registerHandler.accept(new RestRestoreRemoteStoreAction());
        actions.register(RemovePersistentTaskAction.INSTANCE, RemovePersistentTaskAction.TransportAction.class);
            // ExtensionProxyAction
        registerHandler.accept(new RestSimulateTemplateAction());
        return dynamicActionRegistry;
public class ActionModule extends AbstractModule {
        Settings settings,
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksAction;
import org.opensearch.action.ingest.PutPipelineAction;
        registerHandler.accept(new RestSnapshotsStatusAction());
        if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)) {
import org.opensearch.action.admin.indices.upgrade.get.TransportUpgradeStatusAction;
        this.extensionsManager = extensionsManager;
            requireNonNull(route, "route is required");
import org.opensearch.rest.action.cat.AbstractCatAction;
import org.opensearch.action.admin.cluster.snapshots.restore.TransportRestoreSnapshotAction;
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusAction;
        registerHandler.accept(new RestClearScrollAction());
        registerHandler.accept(new RestDeleteComposableIndexTemplateAction());
import org.opensearch.rest.action.admin.cluster.RestGetScriptLanguageAction;
        NodeClient nodeClient,
        actions.register(RemoteStoreMetadataAction.INSTANCE, TransportRemoteStoreMetadataAction.class);
                registerHandler.accept(handler);
    }
        registerHandler.accept(new RestDecommissionAction());
        actions.register(VerifyRepositoryAction.INSTANCE, TransportVerifyRepositoryAction.class);
    private final SettingsFilter settingsFilter;
            Set<String> actionNames = route.actionNames();
        actions.register(PruneBlockCacheAction.INSTANCE, TransportPruneBlockCacheAction.class);
        // Scripts API
            actions.register(PrepareTieringAction.INSTANCE, TransportPrepareTieringAction.class);
import org.opensearch.rest.action.document.RestMultiGetAction;
         */
        registerHandler.accept(new RestAddVotingConfigExclusionAction());
        registerHandler.accept(new RestHealthAction());
            if (handler instanceof AbstractCatAction abstractCatAction) {
        registerHandler.accept(new RestGetDecommissionStateAction());
import org.opensearch.action.admin.cluster.node.hotthreads.NodesHotThreadsAction;
        /**
         */
import org.opensearch.rest.action.admin.cluster.RestCloneSnapshotAction;
        actions.register(BulkAction.INSTANCE, TransportBulkAction.class, TransportShardBulkAction.class);
import org.opensearch.action.admin.cluster.storedscripts.GetScriptLanguageAction;
        bind(AutoCreateIndex.class).toInstance(autoCreateIndex);
/*
import org.opensearch.action.delete.TransportDeleteAction;
import org.opensearch.action.admin.indices.rollover.TransportRolloverAction;
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionAction;
         */
        registerHandler.accept(new RestPruneCacheAction());
         * Remove a dynamic action from the registry.
        actions.register(ClusterDeleteWeightedRoutingAction.INSTANCE, TransportDeleteWeightedRoutingAction.class);
        actions.register(ClearIndicesCacheAction.INSTANCE, TransportClearIndicesCacheAction.class);
                    throw new IllegalArgumentException("Cannot have more than one plugin implementing a REST wrapper");
import org.opensearch.action.admin.indices.mapping.put.TransportPutMappingAction;
     * @opensearch.api
        actions.register(FlushAction.INSTANCE, TransportFlushAction.class);
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksAction;
import org.opensearch.rest.action.admin.indices.RestModifyDataStreamsAction;
        actions.register(IndicesSegmentsAction.INSTANCE, TransportIndicesSegmentsAction.class);
import org.opensearch.action.admin.indices.template.get.GetComposableIndexTemplateAction;
import org.opensearch.action.update.UpdateAction;
import org.opensearch.action.search.DeleteSearchPipelineTransportAction;
        public void registerDynamicAction(ActionType<?> action, TransportAction<?, ?> transportAction) {
        }
        registerHandler.accept(new CreateHandler());
        // register dynamic ActionType -> transportAction Map used by NodeClient
        CircuitBreakerService circuitBreakerService,
            actionPlugins.stream().flatMap(p -> p.indicesAliasesRequestValidators().stream()).collect(Collectors.toList())
            requireNonNull(transportAction, "transportAction is required");
        actions.register(ModifyDataStreamsAction.INSTANCE, ModifyDataStreamsAction.TransportAction.class);
        actions.register(FindDanglingIndexAction.INSTANCE, TransportFindDanglingIndexAction.class);
        this.settingsFilter = settingsFilter;
        public RestSendToExtensionAction get(RestHandler.Route route) {
        actions.register(UpdateSettingsAction.INSTANCE, TransportUpdateSettingsAction.class);
        // A dynamic registry to add or remove Route / RestSendToExtensionAction pairs
        registerHandler.accept(new RestClusterGetSettingsAction(settings, clusterSettings, settingsFilter));
                if (restWrapper != null) {
        registerHandler.accept(new RestSimulateIndexTemplateAction());
import org.opensearch.action.admin.indices.streamingingestion.state.UpdateIngestionStateAction;
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateAction;
            TransportFieldCapabilitiesIndexAction.class
        // at times other than node bootstrap.
import org.opensearch.storage.action.tiering.RestWarmToHotTierAction;
import org.opensearch.action.admin.cluster.stats.TransportClusterStatsAction;
        );
import org.opensearch.rest.action.ingest.RestGetPipelineAction;
    private final Map<String, ActionHandler<?, ?>> actions;
        actions.register(GetDeploymentAction.INSTANCE, TransportGetDeploymentAction.class);
import org.opensearch.action.admin.cluster.remote.TransportRemoteInfoAction;
        registerHandler.accept(new RestTasksAction(nodesInCluster));
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;
        registerHandler.accept(new RestMultiTermVectorsAction());
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionAction;
         * @param route The {@link RestHandler.Route}.
        indicesAliasesRequestRequestValidators = new RequestValidators<>(
            requireNonNull(route, "route is required");
        registerHandler.accept(new RestPendingClusterTasksAction());
            requireNonNull(action, "action is required");
        if (FeatureFlags.isEnabled(FeatureFlags.STREAM_TRANSPORT)) {
    // will remain accessible.
import org.opensearch.action.search.TransportDeletePitAction;
import org.opensearch.rest.action.cat.RestCatRecoveryAction;
import org.opensearch.rest.action.admin.cluster.RestRemoteClusterInfoAction;
        registerHandler.accept(new RestNodesInfoAction(settingsFilter));
import org.opensearch.action.admin.cluster.shards.CatShardsAction;
import org.opensearch.rest.action.admin.indices.RestFlushAction;
        SystemIndices systemIndices,
import org.opensearch.action.admin.cluster.node.stats.TransportNodesStatsAction;
        registerHandler.accept(new RestGetFieldMappingAction());
        registerHandler.accept(new RestCreateDataStreamAction());
         * Gets the {@link TransportAction} instance corresponding to the {@link ActionType} instance.
        actionPlugins.stream().flatMap(p -> p.getActions().stream()).forEach(actions::register);
        actions.register(StartPersistentTaskAction.INSTANCE, StartPersistentTaskAction.TransportAction.class);
         * @param route The route to remove
        ClusterSettings clusterSettings,
            String routeName = route.name();
import org.opensearch.rest.action.admin.indices.RestUpgradeStatusAction;
    public Map<String, ActionHandler<?, ?>> getActions() {
import org.opensearch.action.admin.cluster.decommission.awareness.delete.TransportDeleteDecommissionStateAction;
        restController = new RestController(headers, restWrapper, nodeClient, circuitBreakerService, usageService);
import org.opensearch.rest.action.cat.RestTasksAction;
        actions.register(PutRepositoryAction.INSTANCE, TransportPutRepositoryAction.class);
import org.opensearch.action.admin.cluster.stats.ClusterStatsAction;
import org.opensearch.index.seqno.RetentionLeaseActions;
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.opensearch.rest.action.admin.indices.RestScaleIndexAction;
import org.opensearch.action.admin.indices.streamingingestion.state.TransportUpdateIngestionStateAction;
        actions.register(SnapshotsStatusAction.INSTANCE, TransportSnapshotsStatusAction.class);
import org.opensearch.wlm.WorkloadGroupTask;
        for (ActionPlugin plugin : actionPlugins) {
        registerHandler.accept(new RestGetSnapshotsAction());
        registerHandler.accept(new RestSnapshotAction());
        // will continue to link ActionType and TransportAction pairs from core and plugin
import org.opensearch.storage.action.tiering.CancelTieringAction;
    }
import org.opensearch.rest.action.RestMainAction;
import org.opensearch.action.admin.cluster.shards.TransportCatShardsAction;
        /**
                logger.debug("Using REST wrapper from plugin " + plugin.getClass().getName());
        if (FeatureFlags.isEnabled(FeatureFlags.EXTENSIONS)) {
        actions.register(GetMappingsAction.INSTANCE, TransportGetMappingsAction.class);
    private final Settings settings;
        actions.register(PauseIngestionAction.INSTANCE, TransportPauseIngestionAction.class);
        ThreadPool threadPool,
import org.opensearch.rest.action.cat.RestPluginsAction;
import org.opensearch.action.admin.cluster.repositories.verify.TransportVerifyRepositoryAction;
 */
        actions.register(RemoteStoreStatsAction.INSTANCE, TransportRemoteStoreStatsAction.class);
            }
import org.opensearch.rest.action.admin.cluster.RestListTasksAction;
                String acts = String.join(", ", alreadyRegistered);
 * Builds and binds the generic action map, all {@link TransportAction}s, and {@link ActionFilters}.
import org.opensearch.action.admin.cluster.storedscripts.TransportGetScriptContextAction;
        // at times other than node bootstrap.
import org.opensearch.rest.action.cat.RestAliasAction;
import org.opensearch.action.support.clustermanager.term.TransportGetTermVersionAction;
import org.opensearch.action.admin.indices.template.delete.TransportDeleteComposableIndexTemplateAction;
        registerHandler.accept(new RestListAction(listActions));
/**
        // CAT API
            if (actions.containsKey(action)) {
            registerHandler.accept(new RestWarmToHotTierAction());
import org.opensearch.action.admin.cluster.node.usage.NodesUsageAction;
        // Deployment
        registerHandler.accept(new RestGetSearchPipelineAction());
import org.opensearch.action.admin.indices.delete.TransportDeleteIndexAction;
        registerHandler.accept(new RestClusterRerouteAction(settingsFilter));
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsAction;
        registerHandler.accept(new RestIndicesSegmentsAction());
        registerHandler.accept(new RestClearIndicesCacheAction());
        actions.register(AddIndexBlockAction.INSTANCE, TransportAddIndexBlockAction.class);
        registerHandler.accept(new RestIndicesAction(responseLimitSettings, systemIndices));
import org.opensearch.action.admin.cluster.repositories.get.TransportGetRepositoriesAction;
        registerHandler.accept(new RestListTasksAction(nodesInCluster));
import org.opensearch.action.admin.cluster.node.tasks.delete.TransportDeleteTaskAction;
import org.opensearch.rest.action.admin.cluster.RestNodesStatsAction;
    }
        actions.register(IndexAction.INSTANCE, TransportIndexAction.class);
        registerHandler.accept(new RestAddIndexBlockAction());
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateAction;
        registerHandler.accept(new RestDeleteIndexTemplateAction());
import org.opensearch.action.admin.cluster.filecache.PruneFileCacheAction;
        registerHandler.accept(new RestGetSettingsAction());
        actions.register(PendingClusterTasksAction.INSTANCE, TransportPendingClusterTasksAction.class);
        }
import org.opensearch.action.admin.indices.dangling.find.TransportFindDanglingIndexAction;
        actions.register(AutoPutMappingAction.INSTANCE, TransportAutoPutMappingAction.class);
import org.opensearch.action.search.TransportSearchAction;
import org.opensearch.action.index.IndexAction;
            }
        // retention leases
import org.opensearch.rest.action.admin.cluster.RestPendingClusterTasksAction;
        registerHandler.accept(new RestPruneBlockCacheAction());
        actions.register(ClusterGetWeightedRoutingAction.INSTANCE, TransportGetWeightedRoutingAction.class);
import org.opensearch.action.admin.indices.flush.FlushAction;
        registerHandler.accept(new RestDeleteStoredScriptAction());
                registeredActionNames.add(action.name());
        actionFilters = setupActionFilters(actionPlugins);
import org.opensearch.rest.action.admin.cluster.RestClusterGetWeightedRoutingAction;
import org.opensearch.rest.action.admin.indices.RestResumeIngestionAction;
        actions.register(DeleteDecommissionStateAction.INSTANCE, TransportDeleteDecommissionStateAction.class);
import org.opensearch.rest.action.admin.indices.RestResolveIndexAction;
        registerHandler.accept(new RestGetSourceAction());
    private final List<ActionPlugin> actionPlugins;
import org.opensearch.action.admin.cluster.wlm.WlmStatsAction;
import org.opensearch.action.bulk.TransportShardBulkAction;
import org.opensearch.rest.action.cat.RestNodeAttrsAction;
import org.opensearch.storage.action.tiering.HotToWarmTierAction;
import org.opensearch.action.admin.cluster.storedscripts.TransportPutStoredScriptAction;
        // pull-based ingestion API
        // Tasks API
        registerHandler.accept(new RestRepositoriesAction());
        actions.register(SimulatePipelineAction.INSTANCE, SimulatePipelineTransportAction.class);
import org.opensearch.action.admin.indices.upgrade.post.TransportUpgradeAction;
        registerHandler.accept(new RestListDanglingIndicesAction());
        actions.register(SegmentReplicationStatsAction.INSTANCE, TransportSegmentReplicationStatsAction.class);
        registerHandler.accept(new RestIndexAction());
import org.opensearch.rest.action.admin.cluster.RestClusterStatsAction;
    @Override
import org.opensearch.action.search.GetSearchPipelineAction;
    private final DestructiveOperations destructiveOperations;
        IndexNameExpressionResolver indexNameExpressionResolver,
            FieldCapabilitiesAction.INSTANCE,
import java.util.HashSet;
    private final RequestValidators<PutMappingRequest> mappingRequestValidators;
import org.opensearch.action.admin.cluster.deployment.TransportGetDeploymentAction;
         */
import org.opensearch.rest.action.admin.cluster.dangling.RestListDanglingIndicesAction;
