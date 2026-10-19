import org.opensearch.rest.action.admin.cluster.RestRemoteClusterInfoAction;
        actions.register(GetComponentTemplateAction.INSTANCE, TransportGetComponentTemplateAction.class);
        ClusterSettings clusterSettings,
import org.opensearch.rest.action.admin.cluster.dangling.RestImportDanglingIndexAction;  
import org.opensearch.action.admin.indices.delete.DeleteIndexAction;
import org.opensearch.action.search.CreatePitAction;
import org.opensearch.action.search.TransportCreatePitAction;
        actions.register(ClusterSearchShardsAction.INSTANCE, TransportClusterSearchShardsAction.class);
        actions.register(PutComponentTemplateAction.INSTANCE, TransportPutComponentTemplateAction.class);
        registerHandler.accept(new RestGetIndicesAction());
        registerHandler.accept(new RestClearIndicesCacheAction());
    private final ThreadPool threadPool;
        registerHandler.accept(new RestIndicesAction(responseLimitSettings, systemIndices));  
import org.opensearch.action.admin.cluster.decommission.awareness.get.TransportGetDecommissionStateAction;
        actions.register(PruneBlockCacheAction.INSTANCE, TransportPruneBlockCacheAction.class);
import org.opensearch.action.termvectors.TermVectorsAction;
import org.opensearch.rest.action.admin.indices.RestPutComponentTemplateAction;
        actions.register(DeleteComponentTemplateAction.INSTANCE, TransportDeleteComponentTemplateAction.class);  
import org.opensearch.rest.action.admin.indices.RestGetSettingsAction;
        // pull-based ingestion API  
        actions.register(CreateIndexAction.INSTANCE, TransportCreateIndexAction.class);  
            }
import org.opensearch.action.admin.indices.mapping.put.AutoPutMappingAction;  
import org.opensearch.rest.action.search.RestGetSearchPipelineAction;
import org.opensearch.action.admin.indices.dangling.find.FindDanglingIndexAction;
        registerHandler.accept(new RestIndicesSegmentsAction());
        destructiveOperations = new DestructiveOperations(settings, clusterSettings);
        actions.register(ModifyDataStreamsAction.INSTANCE, ModifyDataStreamsAction.TransportAction.class);
import java.util.stream.Collectors;
import org.opensearch.action.fieldcaps.TransportFieldCapabilitiesAction;
import org.opensearch.action.admin.indices.upgrade.get.TransportUpgradeStatusAction;
        }  
        registerHandler.accept(new RestClusterSearchShardsAction());
import org.opensearch.action.admin.indices.shrink.TransportResizeAction;
            restController.registerHandler(handler);
            TransportAction.class  
            Stream.of(
        actions.register(TermVectorsAction.INSTANCE, TransportTermVectorsAction.class);
        // Data Stream API  
import org.opensearch.action.admin.indices.mapping.get.TransportGetFieldMappingsAction;  
import org.opensearch.rest.action.admin.indices.RestRolloverIndexAction;
        if (FeatureFlags.isEnabled(FeatureFlags.EXTENSIONS)) {  
    @PublicApi(since = "2.7.0")  
        actionFilters = setupActionFilters(actionPlugins);
        registerHandler.accept(new RestListTasksAction(nodesInCluster));
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.rest.action.cat.RestRepositoriesAction;
import org.opensearch.rest.action.admin.indices.RestIndicesSegmentsAction;
import org.opensearch.tasks.Task;  
import org.opensearch.action.admin.cluster.remote.TransportRemoteInfoAction;  
import org.opensearch.action.admin.indices.flush.TransportFlushAction;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * SPDX-License-Identifier: Apache-2.0
        actions.register(SnapshotsStatusAction.INSTANCE, TransportSnapshotsStatusAction.class);  
        registerHandler.accept(new RestDeleteDecommissionStateAction());
        registerHandler.accept(new RestNodesHotThreadsAction());
        registerHandler.accept(new RestCountAction());
        bind(new TypeLiteral<RequestValidators<PutMappingRequest>>() {
            registerHandler.accept(new RestHotToWarmTierAction());
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptAction;  
        this.indexScopedSettings = indexScopedSettings;
import org.opensearch.action.admin.indices.datastream.ModifyDataStreamsAction;  
import org.opensearch.action.ingest.DeletePipelineTransportAction;  
import org.opensearch.rest.action.admin.cluster.RestPruneBlockCacheAction;  
        for (ActionPlugin plugin : actionPlugins) {  
import org.opensearch.action.admin.cluster.storedscripts.GetScriptLanguageAction;
        actions.register(GetDeploymentAction.INSTANCE, TransportGetDeploymentAction.class);
import org.opensearch.action.admin.indices.template.get.TransportGetComponentTemplateAction;  
import static java.util.Collections.unmodifiableMap;
        registerHandler.accept(new RestDeletePitAction());
                    throw new IllegalArgumentException("Cannot have more than one plugin implementing a REST wrapper");
        CircuitBreakerService circuitBreakerService,  
        actions.register(ResizeAction.INSTANCE, TransportResizeAction.class);
            if (route instanceof NamedRoute namedRoute) {  
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheAction;
         * Checks to see if an action is registered provided an action name  
        actions.register(PutIndexFieldDomainsAction.INSTANCE, TransportPutIndexFieldDomainsAction.class);
        actions.register(NodesHotThreadsAction.INSTANCE, TransportNodesHotThreadsAction.class);
        registerHandler.accept(new RestCatRecoveryAction());
        actions.register(FlushAction.INSTANCE, TransportFlushAction.class);
            }
import org.opensearch.action.admin.cluster.shards.TransportClusterSearchShardsAction;  
        registerHandler.accept(new org.opensearch.rest.action.cat.RestPendingClusterTasksAction());
    }  
        // Deployment API  
import org.opensearch.action.admin.indices.validate.query.TransportValidateQueryAction;
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsAction;
import org.opensearch.action.admin.indices.create.AutoCreateAction;  
        registerHandler.accept(new RestBulkAction(settings));
        registerHandler.accept(new RestGetPipelineAction());  
    ) {
                register(handler.getAction().name(), handler);
        actions.register(PendingClusterTasksAction.INSTANCE, TransportPendingClusterTasksAction.class);
                    listActions.add(abstractListAction);
        registerHandler.accept(new RestDataStreamsStatsAction());  
        }
import org.opensearch.rest.action.cat.RestCatRecoveryAction;  
import org.opensearch.rest.action.cat.RestNodeAttrsAction;  
        actionPlugins.stream().flatMap(p -> p.getActions().stream()).forEach(actions::register);  
         * Gets the {@link TransportAction} instance corresponding to the {@link ActionType} instance.  
        registerHandler.accept(new RestSnapshotAction());
import org.opensearch.rest.action.cat.RestShardsAction;  
        registerHandler.accept(new RestAllocationAction());  
         */  
        // Deployment  
        registerHandler.accept(new RestExplainAction());
import org.opensearch.rest.action.admin.indices.RestRecoveryAction;  
import org.opensearch.action.admin.cluster.tasks.PendingClusterTasksAction;  
import org.opensearch.rest.action.admin.cluster.RestDeleteDecommissionStateAction;
            )
import org.opensearch.rest.RestHeaderDefinition;
        actions.register(GetPipelineAction.INSTANCE, GetPipelineTransportAction.class);
import org.opensearch.action.admin.indices.template.post.SimulateIndexTemplateAction;  
         */
import org.opensearch.rest.action.admin.cluster.RestGetStoredScriptAction;
import org.opensearch.action.admin.indices.template.put.TransportPutComposableIndexTemplateAction;
                logger.debug("Using REST wrapper from plugin " + plugin.getClass().getName());
                nodesInCluster
                new RestHeaderDefinition(Task.X_REQUEST_ID, false),  
        actions.register(CloseIndexAction.INSTANCE, TransportCloseIndexAction.class);  
import org.opensearch.action.admin.indices.datastream.DataStreamsStatsAction;  
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryAction;  
import org.opensearch.action.admin.indices.template.post.SimulateTemplateAction;
                String acts = String.join(", ", alreadyRegistered);  
        }
import org.opensearch.rest.action.admin.cluster.RestClearVotingConfigExclusionsAction;
import org.opensearch.action.admin.indices.mapping.put.TransportPutMappingAction;
import org.opensearch.rest.action.admin.cluster.RestCreateSnapshotAction;  
        @SuppressWarnings("unchecked")
 * software distributed under the License is distributed on an
         * @param transportAction The corresponding instance of transportAction to execute
         */  
        registerHandler.accept(new RestIndicesListAction(responseLimitSettings, systemIndices));  
        }
import org.opensearch.action.get.GetAction;
import org.opensearch.action.admin.indices.template.get.GetComponentTemplateAction;  
                Class<?>... supportTransportActions
        registerHandler.accept(new RestDeleteAction());
import org.opensearch.rest.action.admin.cluster.RestPruneCacheAction;
        registerHandler.accept(new RestGetDecommissionStateAction());
import org.opensearch.rest.action.admin.indices.RestRefreshAction;
 *  
import org.opensearch.common.inject.multibindings.MapBinder;  
        registerHandler.accept(new RestRestoreSnapshotAction());
        actions.register(DeleteTaskAction.INSTANCE, TransportDeleteTaskAction.class);
import org.opensearch.action.admin.indices.datastream.GetDataStreamAction;
            }
            MultiTermVectorsAction.INSTANCE,  
        };
import org.opensearch.action.admin.indices.template.delete.DeleteComposableIndexTemplateAction;
        }  
import org.opensearch.action.support.ActionFilters;
import org.opensearch.rest.action.admin.cluster.RestGetRepositoriesAction;  
import org.opensearch.action.admin.cluster.node.usage.TransportNodesUsageAction;
        registerHandler.accept(new RestDeleteComposableIndexTemplateAction());  
import org.opensearch.extensions.ExtensionsManager;
import org.opensearch.action.fieldcaps.TransportFieldCapabilitiesIndexAction;  
            if (!Collections.disjoint(actionNames, registeredActionNames)) {  
        actions.register(BulkAction.INSTANCE, TransportBulkAction.class, TransportShardBulkAction.class);
import org.opensearch.action.ingest.SimulatePipelineAction;
            if (newRestWrapper != null) {
        }
import org.opensearch.action.admin.cluster.shards.CatShardsAction;  
        actions.register(DataStreamsStatsAction.INSTANCE, DataStreamsStatsAction.TransportAction.class);
import org.opensearch.rest.action.admin.cluster.RestClusterRerouteAction;
        actions.register(
import java.util.function.Consumer;
                return actions.get(action);
        registerHandler.accept(new RestRepositoriesAction());
        registerHandler.accept(new RestRestoreRemoteStoreAction());  
    public static class DynamicActionRegistry {
        actions.register(PitSegmentsAction.INSTANCE, TransportPitSegmentsAction.class);  
    // remains unchanged from its prior purpose, and registered actions
            public <Request extends ActionRequest, Response extends ActionResponse> void register(
         * @param action The action instance to add
    private final List<ActionPlugin> actionPlugins;
        actions.register(GetSettingsAction.INSTANCE, TransportGetSettingsAction.class);  
import org.opensearch.action.ingest.GetPipelineTransportAction;
 * Builds and binds the generic action map, all {@link TransportAction}s, and {@link ActionFilters}.  
import org.opensearch.cluster.node.DiscoveryNodes;  
import org.opensearch.rest.action.admin.indices.RestDeleteComponentTemplateAction;  
        registerHandler.accept(new RestResizeHandler.RestShrinkIndexAction());
        actions.register(CancelTasksAction.INSTANCE, TransportCancelTasksAction.class);
        return restController;
        }  
import org.opensearch.action.get.TransportMultiGetAction;
        actions.register(RolloverAction.INSTANCE, TransportRolloverAction.class);
import org.opensearch.extensions.rest.RestSendToExtensionAction;  
        actions.register(UpdateSettingsAction.INSTANCE, TransportUpdateSettingsAction.class);  
        return unmodifiableMap(actions.getRegistry());
                ActionType<Response> action,
        // Fully qualified to prevent interference with rest.action.indices.RestRecoveryAction
import java.util.function.Supplier;  
        actions.register(RemovePersistentTaskAction.INSTANCE, RemovePersistentTaskAction.TransportAction.class);
import java.util.concurrent.ConcurrentSkipListSet;
import org.opensearch.rest.action.document.RestBulkStreamingAction;  
import org.opensearch.rest.action.admin.cluster.RestPutStoredScriptAction;  
        registerHandler.accept(new RestGetScriptContextAction());
                new RestHeaderDefinition(Task.X_OPAQUE_ID, false),
        actions.register(ClusterAllocationExplainAction.INSTANCE, TransportClusterAllocationExplainAction.class);  
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.admin.indices.flush.FlushAction;
import org.opensearch.action.search.SearchAction;
        @SuppressWarnings("rawtypes")
import org.opensearch.rest.action.document.RestTermVectorsAction;  
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingAction;  
            actions.register(HotToWarmTierAction.INSTANCE, TransportHotToWarmTierAction.class);  
import org.opensearch.rest.action.search.RestPutSearchPipelineAction;
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsAction;
        actions.register(PauseIngestionAction.INSTANCE, TransportPauseIngestionAction.class);
            )) {  
import org.opensearch.action.admin.cluster.deployment.TransportTransitionDeploymentAction;
                super("action");  
        }
import org.opensearch.rest.action.admin.indices.RestPutComposableIndexTemplateAction;  
import org.opensearch.rest.action.cat.RestSnapshotAction;
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionAction;  
 * license agreements. See the NOTICE file distributed with
            GetFieldMappingsAction.INSTANCE,
        actions.register(GetIngestionStateAction.INSTANCE, TransportGetIngestionStateAction.class);
import org.opensearch.action.admin.indices.upgrade.post.TransportUpgradeSettingsAction;
        registerHandler.accept(new RestGetIndexTemplateAction());
        actions.register(RemoteStoreStatsAction.INSTANCE, TransportRemoteStoreStatsAction.class);
            }
        private final Map<NamedRoute, RestSendToExtensionAction> routeRegistry = new ConcurrentHashMap<>();  
import org.opensearch.action.admin.cluster.node.reload.NodesReloadSecureSettingsAction;  
 * You may obtain a copy of the License at  
            }
        actions.register(RestoreSnapshotAction.INSTANCE, TransportRestoreSnapshotAction.class);
        registerHandler.accept(new RestDeleteIndexAction());  
import org.opensearch.action.admin.cluster.configuration.ClearVotingConfigExclusionsAction;
import org.opensearch.storage.action.tiering.status.ListTieringStatusAction;
import org.opensearch.action.search.TransportDeletePitAction;
                indexScopedSettings,
        // register dynamic ActionType -> transportAction Map used by NodeClient
import org.opensearch.rest.action.cat.RestClusterManagerAction;
        }  
        registerHandler.accept(new RestMultiSearchAction(settings));  
import org.opensearch.action.admin.indices.rollover.TransportRolloverAction;
import org.opensearch.common.NamedRegistry;
import org.opensearch.rest.action.RestMainAction;
            actionPlugins.stream().flatMap(p -> p.mappingRequestValidators().stream()).collect(Collectors.toList())
import org.opensearch.common.settings.SettingsFilter;
        restController.setRequestIdMaxLength(HttpTransportSettings.SETTING_HTTP_REQUEST_ID_MAX_LENGTH.get(settings));
import org.opensearch.action.admin.cluster.node.tasks.get.TransportGetTaskAction;  
        actions.register(OpenIndexAction.INSTANCE, TransportOpenIndexAction.class);
        );
        registerHandler.accept(new RestGetAction());
import org.opensearch.action.admin.cluster.snapshots.restore.TransportRestoreSnapshotAction;
        actions.register(RestoreRemoteStoreAction.INSTANCE, TransportRestoreRemoteStoreAction.class);
    private final DestructiveOperations destructiveOperations;  
import org.opensearch.action.admin.indices.rollover.RolloverAction;
        }
        actions.register(CleanupRepositoryAction.INSTANCE, TransportCleanupRepositoryAction.class);  
        registerHandler.accept(new RestClusterRerouteAction(settingsFilter));  
    private final ResponseLimitSettings responseLimitSettings;
            HttpTransportSettings.SETTING_HTTP_REQUEST_ID_MAX_LENGTH,
            actionPlugins.stream().flatMap(p -> p.indicesAliasesRequestValidators().stream()).collect(Collectors.toList())
        Consumer<RestHandler> registerHandler = handler -> {
import org.opensearch.action.admin.indices.mapping.put.TransportAutoPutMappingAction;  
import org.opensearch.action.admin.cluster.stats.TransportClusterStatsAction;
import static java.util.Objects.requireNonNull;  
import org.opensearch.persistent.StartPersistentTaskAction;
 * compatible open source license.
        actions.register(CreateDataStreamAction.INSTANCE, CreateDataStreamAction.TransportAction.class);  
import org.opensearch.action.admin.indices.refresh.RefreshAction;
import org.opensearch.extensions.action.ExtensionProxyTransportAction;
         * @param route The route instance to add
        // at times other than node bootstrap.
import org.opensearch.action.search.StreamTransportSearchAction;
        SystemIndices systemIndices,
import org.opensearch.action.admin.cluster.state.TransportClusterStateAction;
import org.opensearch.action.admin.indices.template.put.PutComponentTemplateAction;
        registerHandler.accept(new RestSimulateTemplateAction());
         * @param action The action to remove
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingAction;
        /**
    }
        actions.register(MainAction.INSTANCE, TransportMainAction.class);
import org.opensearch.action.admin.cluster.settings.TransportClusterUpdateSettingsAction;
import org.opensearch.storage.action.tiering.TransportCancelTierAction;
         * Gets the {@link RestSendToExtensionAction} instance corresponding to the {@link RestHandler.Route} instance.  
import org.opensearch.rest.action.admin.indices.RestGetDataStreamsAction;
import org.opensearch.rest.action.admin.cluster.RestClusterHealthAction;
import org.opensearch.rest.action.cat.RestHealthAction;
import org.opensearch.rest.action.admin.indices.RestSyncedFlushAction;  
import org.opensearch.rest.action.document.RestGetSourceAction;  
import org.opensearch.rest.action.admin.indices.RestUpgradeStatusAction;  
        }).toInstance(mappingRequestValidators);
         *
import org.opensearch.action.admin.cluster.node.liveness.TransportLivenessAction;
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionAction;
import org.opensearch.action.admin.indices.template.put.TransportPutComponentTemplateAction;
    }
import org.opensearch.rest.action.admin.indices.RestIndexDeleteAliasesAction;
import org.opensearch.action.admin.cluster.node.info.TransportNodesInfoAction;
        }  
import org.opensearch.action.admin.cluster.node.hotthreads.NodesHotThreadsAction;
import org.opensearch.action.admin.cluster.repositories.verify.VerifyRepositoryAction;
import org.opensearch.plugins.ActionPlugin;  
        this.settingsFilter = settingsFilter;
        registerHandler.accept(new RestGetFieldMappingAction());  
        actions.register(PutStoredScriptAction.INSTANCE, TransportPutStoredScriptAction.class);
                indexNameExpressionResolver,
        actions.register(VerifyRepositoryAction.INSTANCE, TransportVerifyRepositoryAction.class);
    // The unmodifiable map containing OpenSearch and Plugin actions
import org.opensearch.action.main.TransportMainAction;
        actions.register(UpgradeStatusAction.INSTANCE, TransportUpgradeStatusAction.class);
import org.opensearch.action.support.clustermanager.term.TransportGetTermVersionAction;  
import org.opensearch.rest.action.search.RestCountAction;
import org.opensearch.action.search.PutSearchPipelineTransportAction;
    private static final Logger logger = LogManager.getLogger(ActionModule.class);  
import org.opensearch.action.admin.cluster.wlm.WlmStatsAction;  
import org.opensearch.action.admin.indices.close.TransportCloseIndexAction;
        actions.register(GetStoredScriptAction.INSTANCE, TransportGetStoredScriptAction.class);
        actions.register(ClusterHealthAction.INSTANCE, TransportClusterHealthAction.class);
import org.opensearch.action.admin.indices.alias.TransportIndicesAliasesAction;  
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;  
import org.opensearch.rest.action.admin.cluster.RestCancelTasksAction;  
import org.opensearch.action.admin.indices.dangling.import_index.TransportImportDanglingIndexAction;
            }  
import org.opensearch.action.admin.indices.template.post.TransportSimulateTemplateAction;  
        this.threadPool = threadPool;  
import org.opensearch.action.admin.indices.mapping.get.TransportGetFieldMappingsIndexAction;
 * this file be licensed under the Apache-2.0 license or a
        registerHandler.accept(new RestClusterHealthAction());  
import org.opensearch.action.admin.indices.recovery.TransportRecoveryAction;
        );  
import org.opensearch.rest.action.admin.cluster.RestCleanupRepositoryAction;
import org.opensearch.rest.action.ingest.RestPutPipelineAction;
                settings,
            for (ActionType action : actions.keySet()) {
        registerHandler.accept(new RestCatAction(catActions));
        registerHandler.accept(new RestClusterPutWeightedRoutingAction());
        public void unregisterDynamicRoute(NamedRoute route) {
import org.opensearch.rest.action.ingest.RestSimulatePipelineAction;
        registerHandler.accept(new RestListDanglingIndicesAction());
import org.opensearch.rest.action.admin.indices.RestDeleteDataStreamAction;
import org.opensearch.action.admin.indices.exists.indices.TransportIndicesExistsAction;
        // CAT API
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
import org.opensearch.rest.action.cat.AbstractCatAction;
                register(new ActionHandler<>(action, transportAction, supportTransportActions));  
        // Search Pipelines
import org.opensearch.action.ingest.GetPipelineAction;
        /**
import org.opensearch.action.ingest.SimulatePipelineTransportAction;  
        // Ingest API
        registerHandler.accept(new RestDecommissionAction());  
        actions.register(PutComposableIndexTemplateAction.INSTANCE, TransportPutComposableIndexTemplateAction.class);
}
        actions.register(DeletePitAction.INSTANCE, TransportDeletePitAction.class);
        // Indexed scripts  
import org.opensearch.rest.action.admin.cluster.RestDeleteStoredScriptAction;
import org.opensearch.action.admin.indices.refresh.TransportRefreshAction;  
        registerHandler.accept(new RestClusterDeleteWeightedRoutingAction());
import org.opensearch.action.termvectors.TransportTermVectorsAction;
        actions.register(IndicesSegmentsAction.INSTANCE, TransportIndicesSegmentsAction.class);
        actions.register(GetAllPitsAction.INSTANCE, TransportGetAllPitsAction.class);
import org.opensearch.action.admin.cluster.repositories.cleanup.TransportCleanupRepositoryAction;
            }  
        registerHandler.accept(new RestShardsAction());
        actions.register(ClusterStateAction.INSTANCE, TransportClusterStateAction.class);
        registerHandler.accept(new RestCancelTasksAction(nodesInCluster));
        registerHandler.accept(new RestGetMappingAction(threadPool));
        registerHandler.accept(new RestPutMappingAction());
        // LIST API
        ExtensionsManager extensionsManager
            // Only NamedRoutes are map keys so any other route is not in the map  
        actions.register(GetTaskAction.INSTANCE, TransportGetTaskAction.class);  
        actions.register(GetScriptLanguageAction.INSTANCE, TransportGetScriptLanguageAction.class);
    // a different JVM and possibly on a different server.
import org.opensearch.action.delete.TransportDeleteAction;
import org.opensearch.rest.action.search.RestExplainAction;  
        registerHandler.accept(new RestRemoteClusterInfoAction());
        this.indexNameExpressionResolver = indexNameExpressionResolver;
import org.opensearch.storage.action.tiering.WarmToHotTierAction;
import org.opensearch.action.admin.cluster.node.tasks.cancel.TransportCancelTasksAction;
import org.opensearch.rest.action.admin.cluster.RestWlmStatsAction;
        clusterSettings.addSettingsUpdateConsumer(  
            String routeName = route.name();
        registerHandler.accept(new RestAliasAction());
import org.opensearch.rest.action.admin.indices.RestGetFieldMappingAction;
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsAction;
        return new ActionFilters(  
import org.opensearch.action.admin.cluster.configuration.TransportClearVotingConfigExclusionsAction;
        registerHandler.accept(new org.opensearch.rest.action.cat.RestCountAction());  
        actions.register(IndexAction.INSTANCE, TransportIndexAction.class);
import org.opensearch.rest.action.admin.cluster.dangling.RestListDanglingIndicesAction;
import org.opensearch.action.get.MultiGetAction;
import org.opensearch.rest.action.document.RestMultiTermVectorsAction;
            registerHandler.accept(new RestWarmToHotTierAction());
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotAction;
            TransportMultiTermVectorsAction.class,
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryAction;
        actions.register(GetTermVersionAction.INSTANCE, TransportGetTermVersionAction.class);  
import org.opensearch.rest.RestHandler;
 */
import org.opensearch.rest.action.RestFieldCapabilitiesAction;  
import org.opensearch.action.admin.cluster.stats.ClusterStatsAction;  
        registerHandler.accept(new RestFielddataAction());
import org.opensearch.rest.action.admin.cluster.RestAddVotingConfigExclusionAction;
        actions.register(GetScriptContextAction.INSTANCE, TransportGetScriptContextAction.class);
         *  
            Collections.unmodifiableSet(actionPlugins.stream().flatMap(p -> p.getActionFilters().stream()).collect(Collectors.toSet()))
        List<ActionPlugin> actionPlugins,
import org.opensearch.action.admin.indices.settings.get.GetSettingsAction;  
        registerHandler.accept(new RestAddVotingConfigExclusionAction());  
        actions.register(AutoCreateAction.INSTANCE, AutoCreateAction.TransportAction.class);
import org.opensearch.rest.action.admin.cluster.RestClusterGetWeightedRoutingAction;
import org.opensearch.rest.action.search.RestGetAllPitsAction;
            actions.register(WarmToHotTierAction.INSTANCE, TransportWarmToHotTierAction.class);
    private final RequestValidators<IndicesAliasesRequest> indicesAliasesRequestRequestValidators;  
import org.opensearch.rest.action.admin.cluster.RestClusterPutWeightedRoutingAction;  
    public void initRestHandlers(Supplier<DiscoveryNodes> nodesInCluster) {
import org.opensearch.rest.action.admin.cluster.RestDeleteSnapshotAction;
            actions.register(CancelTieringAction.INSTANCE, TransportCancelTierAction.class);
import org.opensearch.rest.action.cat.RestAllocationAction;
        registerHandler.accept(new RestShardsListAction());
 */  
        // Fully qualified to prevent interference with rest.action.count.RestCountAction
        registerHandler.accept(new RestGetSettingsAction());
    public RestController getRestController() {
        registerHandler.accept(new RestDeleteDanglingIndexAction());
    private final SystemIndices systemIndices;  
                }
                Class<? extends TransportAction<Request, Response>> transportAction,  
        SettingsFilter settingsFilter,
import org.opensearch.action.search.DeleteSearchPipelineAction;  
import org.opensearch.rest.NamedRoute;
        registerHandler.accept(new CreateHandler());
    private final RestController restController;
import org.opensearch.rest.action.cat.RestCatAction;
        // This is the unmodifiable actions map created during node bootstrap, which
        registerHandler.accept(new RestDeleteTaskAction());
import org.opensearch.rest.action.cat.RestNodesAction;
import org.opensearch.action.admin.cluster.deployment.TransitionDeploymentAction;  
        }  
import org.opensearch.rest.action.document.RestUpdateAction;
import org.opensearch.action.admin.indices.mapping.get.GetMappingsAction;
import org.opensearch.action.ingest.DeletePipelineAction;
import org.opensearch.rest.action.admin.cluster.RestSnapshotsStatusAction;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.threadpool.ThreadPool;
            if (actions.containsKey(action) || registry.putIfAbsent(action, transportAction) != null) {
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateAction;
package org.opensearch.action;
import org.opensearch.action.admin.indices.streamingingestion.pause.TransportPauseIngestionAction;
import org.opensearch.action.admin.cluster.health.TransportClusterHealthAction;  
import org.opensearch.rest.action.admin.indices.RestPutMappingAction;
        actions.register(SimulateIndexTemplateAction.INSTANCE, TransportSimulateIndexTemplateAction.class);
        actions.register(NodesInfoAction.INSTANCE, TransportNodesInfoAction.class);  
import org.opensearch.rest.action.admin.cluster.RestNodesStatsAction;  
        registerHandler.accept(new RestGetComposableIndexTemplateAction());
        registerHandler.accept(new RestBulkStreamingAction(settings));  
        registerHandler.accept(new RestGetRepositoriesAction(settingsFilter));
import org.opensearch.action.admin.cluster.node.info.NodesInfoAction;  
import org.opensearch.storage.action.tiering.RestHotToWarmTierAction;
import org.opensearch.rest.action.admin.cluster.RestRestoreRemoteStoreAction;
        // point in time actions  
import org.opensearch.rest.action.admin.indices.RestSimulateIndexTemplateAction;
        dynamicActionRegistry = new DynamicActionRegistry();
        registerHandler.accept(new RestIndicesAliasesAction());  
        // at times other than node bootstrap.
            registeredActionNames.add(action.name());
        responseLimitSettings = new ResponseLimitSettings(clusterSettings, settings);
                }
import org.opensearch.action.admin.indices.mapping.put.PutMappingAction;
import org.opensearch.action.admin.indices.delete.TransportDeleteIndexAction;
        public void unregisterDynamicAction(ActionType<?> action) {  
        registerHandler.accept(new RestGetTaskAction());  
     * The DynamicActionRegistry maintains a registry mapping {@link ActionType} instances to {@link TransportAction} instances.  
        actions.register(ListDanglingIndicesAction.INSTANCE, TransportListDanglingIndicesAction.class);
        registerHandler.accept(new RestDeleteStoredScriptAction());
 * the Apache License, Version 2.0 (the "License"); you may
    private final RequestValidators<PutMappingRequest> mappingRequestValidators;
import org.opensearch.action.admin.cluster.repositories.verify.TransportVerifyRepositoryAction;  
        }  
import org.opensearch.rest.RestController;  
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;
         * @param route The route to remove
        actions.register(AddIndexBlockAction.INSTANCE, TransportAddIndexBlockAction.class);
import org.opensearch.action.admin.indices.segments.IndicesSegmentsAction;
import java.util.ArrayList;  
    private final ExtensionsManager extensionsManager;
            }
import org.opensearch.rest.action.document.RestMultiGetAction;
import org.opensearch.action.admin.indices.validate.query.ValidateQueryAction;
import org.opensearch.action.admin.indices.dangling.import_index.ImportDanglingIndexAction;
 *
            }
    }  
            registerHandler.accept(new RestInitializeExtensionAction(extensionsManager));  
    private final ActionFilters actionFilters;
        actions.register(ClusterAddWeightedRoutingAction.INSTANCE, TransportAddWeightedRoutingAction.class);
        actions.register(CatShardsAction.INSTANCE, TransportCatShardsAction.class);  
        for (ActionHandler<?, ?> action : actions.values()) {
        actions.register(ResumeIngestionAction.INSTANCE, TransportResumeIngestionAction.class);  
import org.opensearch.rest.action.admin.indices.RestUpdateSettingsAction;
        actions.register(ClearIndicesCacheAction.INSTANCE, TransportClearIndicesCacheAction.class);
         * @param action The corresponding instance of RestSendToExtensionAction to execute
import org.opensearch.rest.action.cat.RestTemplatesAction;  
            TransportGetFieldMappingsAction.class,  
        actions.register(IndicesStatsAction.INSTANCE, TransportIndicesStatsAction.class);
        registerHandler.accept(new RestClusterGetWeightedRoutingAction());  
                throw new IllegalArgumentException("route [" + route + "] already registered");
import org.opensearch.rest.action.admin.cluster.RestGetTaskAction;
        actions.register(ImportDanglingIndexAction.INSTANCE, TransportImportDanglingIndexAction.class);
            if (actions.containsKey(action)) {
import org.opensearch.rest.action.admin.indices.RestResizeHandler;
import org.opensearch.action.admin.indices.segments.TransportPitSegmentsAction;
    }  
        registerHandler.accept(new RestClearScrollAction());
        }
        registerHandler.accept(new RestPutComposableIndexTemplateAction());
        registerHandler.accept(new RestGetSnapshotsAction());
        actions.register(DeleteStoredScriptAction.INSTANCE, TransportDeleteStoredScriptAction.class);  
        registerHandler.accept(new RestRecoveryAction());  
        registerHandler.accept(new RestPutSearchPipelineAction());
            UnaryOperator<RestHandler> newRestWrapper = plugin.getRestHandlerWrapper(threadPool.getThreadContext(), headers);  
        actions.register(RemoteStoreMetadataAction.INSTANCE, TransportRemoteStoreMetadataAction.class);
        registerHandler.accept(new RestClusterStatsAction());
            }  
        // A dynamic registry to add or remove Route / RestSendToExtensionAction pairs
import org.opensearch.storage.action.tiering.status.transport.TransportGetTieringStatusAction;
 */  
        registerHandler.accept(new RestClearVotingConfigExclusionsAction());
     *  
        registerHandler.accept(new RestSimulatePipelineAction());
import org.opensearch.rest.action.admin.indices.RestPutIndexTemplateAction;
                registerHandler.accept(handler);
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.TransportGetWeightedRoutingAction;
import org.opensearch.action.admin.indices.recovery.RecoveryAction;  
        // FileCache API  
    }
        }  
        actions.register(RetentionLeaseActions.Remove.INSTANCE, RetentionLeaseActions.Remove.TransportAction.class);
import org.opensearch.action.admin.indices.mapping.get.TransportGetMappingsAction;
import org.opensearch.extensions.action.ExtensionProxyAction;  
        // register ActionType -> transportAction Map used by NodeClient
        registerHandler.accept(new RestResumeIngestionAction());
import org.opensearch.action.ingest.PutPipelineAction;  
import org.opensearch.common.annotation.PublicApi;
        actions.register(GetAction.INSTANCE, TransportGetAction.class);  
         * Adds a dynamic route to the registry.
        registerHandler.accept(new RestCreateSnapshotAction());  
        registerHandler.accept(new RestCloseIndexAction());
import org.opensearch.action.search.TransportSearchAction;
        actions.register(DeleteDecommissionStateAction.INSTANCE, TransportDeleteDecommissionStateAction.class);
 *
        // Supporting classes  
        bind(ResponseLimitSettings.class).toInstance(responseLimitSettings);
import org.opensearch.rest.action.ingest.RestGetPipelineAction;  
import org.opensearch.rest.action.document.RestDeleteAction;
        return dynamicActionRegistry;
            bind(action.getTransportAction()).asEagerSingleton();
         * @param actions The injected map of {@link ActionType} to {@link TransportAction}
import org.opensearch.action.admin.cluster.remotestore.stats.TransportRemoteStoreStatsAction;  
import org.opensearch.action.admin.indices.template.put.PutComposableIndexTemplateAction;
import org.opensearch.action.admin.indices.template.delete.TransportDeleteComposableIndexTemplateAction;
        registerHandler.accept(new RestSearchScrollAction());
        actions.register(CreatePitAction.INSTANCE, TransportCreatePitAction.class);
        public RestSendToExtensionAction get(RestHandler.Route route) {
        registerHandler.accept(new RestIndicesShardStoresAction());
        NodeClient nodeClient,
        actions.register(RemoteInfoAction.INSTANCE, TransportRemoteInfoAction.class);
    // will remain accessible.  
    }  
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksAction;
import org.opensearch.rest.action.admin.cluster.RestTransitionDeploymentAction;
import org.opensearch.action.admin.cluster.snapshots.create.TransportCreateSnapshotAction;
public class ActionModule extends AbstractModule {
import org.opensearch.action.admin.indices.upgrade.post.UpgradeAction;
import org.opensearch.action.admin.indices.dangling.list.ListDanglingIndicesAction;  
 * ownership. Elasticsearch licenses this file to you under  
        registerHandler.accept(new RestDeleteIndexTemplateAction());  
        // retention leases
import org.opensearch.action.bulk.TransportShardBulkAction;
import org.opensearch.storage.action.tiering.PrepareTieringAction;  
        actions.register(ClusterRerouteAction.INSTANCE, TransportClusterRerouteAction.class);  
        indicesAliasesRequestRequestValidators = new RequestValidators<>(  
        actions.register(AnalyzeAction.INSTANCE, TransportAnalyzeAction.class);  
        registerHandler.accept(new RestAnalyzeAction());  
        actions.register(CreateSnapshotAction.INSTANCE, TransportCreateSnapshotAction.class);  
        registerHandler.accept(new RestDeleteRepositoryAction());
        // Dangling indices  
            registerHandler.accept(new RestGetTieringStatusAction());
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateAction;  
import org.opensearch.core.indices.breaker.CircuitBreakerService;
import org.opensearch.action.termvectors.MultiTermVectorsAction;
import org.opensearch.rest.action.admin.indices.RestGetIndicesAction;
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusAction;
        }).toInstance(indicesAliasesRequestRequestValidators);
        actions.register(PutSearchPipelineAction.INSTANCE, PutSearchPipelineTransportAction.class);
import org.opensearch.rest.action.admin.indices.RestPauseIngestionAction;
        registerHandler.accept(new RestRemoteStoreMetadataAction());
import org.opensearch.action.admin.indices.create.CreateIndexAction;
import org.opensearch.action.get.TransportGetAction;  
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionAction;  
import org.opensearch.persistent.UpdatePersistentTaskStatusAction;
import org.opensearch.storage.action.tiering.status.rest.RestGetTieringStatusAction;
import org.opensearch.rest.action.admin.cluster.RestClusterGetSettingsAction;  
import org.opensearch.action.admin.indices.settings.put.TransportUpdateSettingsAction;
         *
import org.opensearch.rest.action.admin.indices.RestGetMappingAction;  
        for (ActionPlugin plugin : actionPlugins) {
        /**
        actions.register(UpdatePersistentTaskStatusAction.INSTANCE, UpdatePersistentTaskStatusAction.TransportAction.class);  
        registerHandler.accept(new RestPutComponentTemplateAction());
     * @opensearch.api
import org.opensearch.action.support.TransportAction;
        // Pull-based ingestion actions
import org.opensearch.action.admin.indices.datastream.CreateDataStreamAction;
            registeredActionNames.remove(route.name());
            routeRegistry.put(route, action);  
import org.opensearch.action.admin.cluster.node.tasks.delete.DeleteTaskAction;  
import org.opensearch.rest.action.admin.cluster.RestNodesHotThreadsAction;
        registerHandler.accept(new RestNodeAttrsAction());  
                if (handler instanceof AbstractListAction abstractListAction && abstractListAction.isActionPaginated()) {
import org.opensearch.action.admin.indices.upgrade.get.UpgradeStatusAction;
    private final ClusterSettings clusterSettings;
        registerHandler.accept(new RestModifyDataStreamsAction());  
        this.actionPlugins = actionPlugins;
import java.util.Map;
import org.opensearch.rest.action.admin.indices.RestGetComposableIndexTemplateAction;  
         * @param route The {@link RestHandler.Route}.
        // Scripts API
import org.opensearch.rest.action.document.RestGetAction;
        registerHandler.accept(new RestAddIndexBlockAction());  
        }
        actions.register(ClusterStatsAction.INSTANCE, TransportClusterStatsAction.class);
        actions.register(PutPipelineAction.INSTANCE, PutPipelineTransportAction.class);
import org.opensearch.rest.action.admin.indices.RestGetAliasesAction;
import org.opensearch.action.main.MainAction;
    }  
        actions.register(ClusterDeleteWeightedRoutingAction.INSTANCE, TransportDeleteWeightedRoutingAction.class);
import org.opensearch.action.admin.indices.open.TransportOpenIndexAction;  
                restWrapper = newRestWrapper;  
import org.opensearch.action.admin.indices.shards.IndicesShardStoresAction;
            requireNonNull(routeName, "route name is required");  
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterAddWeightedRoutingAction;
        IdentityService identityService,  
import org.opensearch.rest.action.list.RestShardsListAction;  
     */
import org.opensearch.rest.action.admin.cluster.RestReloadSecureSettingsAction;
    public DynamicActionRegistry getDynamicActionRegistry() {  
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction;  
import org.opensearch.rest.action.admin.indices.RestGetIngestionStateAction;
        registerHandler.accept(new RestReloadSecureSettingsAction());
                throw new IllegalArgumentException("route [" + route + "] already registered");
import org.opensearch.action.admin.indices.get.GetIndexAction;
import org.opensearch.action.admin.indices.replication.TransportSegmentReplicationStatsAction;
        actions.register(GetMappingsAction.INSTANCE, TransportGetMappingsAction.class);  
import org.opensearch.action.admin.indices.streamingingestion.state.UpdateIngestionStateAction;
            registerHandler.accept(new RestCancelTierAction());  
        registerHandler.accept(new RestIndexDeleteAliasesAction());
import org.opensearch.rest.action.admin.cluster.RestClusterStatsAction;
import org.opensearch.storage.action.tiering.RestWarmToHotTierAction;  
import org.opensearch.storage.action.tiering.CancelTieringAction;
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.TransportAddWeightedRoutingAction;  
import org.opensearch.action.admin.indices.settings.get.TransportGetSettingsAction;
        actions.register(CompletionPersistentTaskAction.INSTANCE, CompletionPersistentTaskAction.TransportAction.class);
        actions.register(DeleteIndexTemplateAction.INSTANCE, TransportDeleteIndexTemplateAction.class);  
import org.opensearch.action.admin.indices.close.CloseIndexAction;
import org.opensearch.action.bulk.TransportBulkAction;
        public void registerDynamicAction(ActionType<?> action, TransportAction<?, ?> transportAction) {
import org.opensearch.common.inject.TypeLiteral;
            TransportFieldCapabilitiesIndexAction.class
        registerHandler.accept(new RestGetAllPitsAction(nodesInCluster));  
        registerHandler.accept(new RestUpdateSettingsAction());  
import org.opensearch.rest.action.admin.indices.RestSimulateTemplateAction;
import org.opensearch.rest.action.document.RestIndexAction;
import org.opensearch.rest.action.admin.indices.RestResolveIndexAction;  
import org.opensearch.action.admin.cluster.node.tasks.list.TransportListTasksAction;
            return registeredActionNames.contains(actionName);
 * @opensearch.internal
        registerHandler.accept(new RestIndexAction());
import org.opensearch.http.HttpTransportSettings;
        // Dangling indices API
import org.opensearch.rest.action.admin.cluster.RestGetSnapshotsAction;  
import org.opensearch.rest.action.admin.cluster.RestClusterUpdateSettingsAction;
 * this work for additional information regarding copyright
        bind(TransportLivenessAction.class).asEagerSingleton();
        registerHandler.accept(new RestClusterAllocationExplainAction());  
import org.opensearch.common.settings.IndexScopedSettings;
            registeredActionNames.add(routeName);
import org.opensearch.action.admin.indices.shards.TransportIndicesShardStoresAction;
        /**
         *
import org.opensearch.rest.action.admin.indices.RestValidateQueryAction;
        actions.register(DeleteDataStreamAction.INSTANCE, DeleteDataStreamAction.TransportAction.class);
import org.opensearch.rest.action.admin.cluster.RestClusterStateAction;  
import org.opensearch.action.admin.indices.create.TransportCreateIndexAction;
import org.opensearch.rest.action.admin.cluster.RestVerifyRepositoryAction;  
        registerHandler.accept(new RestDeleteDataStreamAction());
        registerHandler.accept(new RestCreateDataStreamAction());
import org.opensearch.usage.UsageService;  
        actions.register(TransitionDeploymentAction.INSTANCE, TransportTransitionDeploymentAction.class);
            public void register(ActionHandler<?, ?> handler) {  
         *
        // Tiering status actions
        actions.register(PruneFileCacheAction.INSTANCE, TransportPruneFileCacheAction.class);  
        actions.register(PutIndexTemplateAction.INSTANCE, TransportPutIndexTemplateAction.class);
        private final Map<ActionType<?>, TransportAction<?, ?>> registry = new ConcurrentHashMap<>();
import org.opensearch.rest.action.list.RestIndicesListAction;
        }  
        registerHandler.accept(new RestSegmentsAction(responseLimitSettings));
import org.opensearch.plugins.ActionPlugin.ActionHandler;
import org.opensearch.rest.action.admin.indices.RestResumeIngestionAction;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotAction;  
        actions.register(DeleteComposableIndexTemplateAction.INSTANCE, TransportDeleteComposableIndexTemplateAction.class);  
        );  
        actions = setupActions(actionPlugins);  
                );  
import org.opensearch.rest.action.list.RestListAction;
import org.opensearch.rest.action.document.RestIndexAction.AutoIdHandler;
import org.opensearch.action.admin.cluster.filecache.PruneFileCacheAction;  
        registerHandler.accept(new RestCloneSnapshotAction());
import org.opensearch.action.index.TransportIndexAction;
import org.opensearch.action.admin.indices.stats.TransportIndicesStatsAction;  
        actions.register(ClearScrollAction.INSTANCE, TransportClearScrollAction.class);  
import org.opensearch.rest.action.admin.indices.RestDeleteComposableIndexTemplateAction;
import org.opensearch.action.search.GetAllPitsAction;
import org.opensearch.action.admin.cluster.remote.RemoteInfoAction;
import org.opensearch.action.admin.cluster.storedscripts.GetScriptContextAction;  
import org.opensearch.action.admin.indices.dangling.find.TransportFindDanglingIndexAction;  
        /**
        // Tasks API
import org.opensearch.rest.action.admin.indices.RestGetIndexTemplateAction;  
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateAction;
import org.opensearch.action.search.TransportMultiSearchAction;
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateAction;
            actions.register(GetTieringStatusAction.INSTANCE, TransportGetTieringStatusAction.class);
         * @return the corresponding {@link RestSendToExtensionAction} if it is registered, null otherwise.  
         * Register the immutable actions in the registry.
            registeredActionNames.removeAll(route.actionNames());
        actions.register(IndicesShardStoresAction.INSTANCE, TransportIndicesShardStoresAction.class);
        registerHandler.accept(new RestGetSourceAction());
        actions.register(DeleteAction.INSTANCE, TransportDeleteAction.class);
        bind(AutoCreateIndex.class).toInstance(autoCreateIndex);
                    catActions.add(abstractCatAction);
    // A dynamic action registry which includes the above immutable actions
        UnaryOperator<RestHandler> restWrapper = null;
        registerHandler.accept(new RestTransitionDeploymentAction());
         * Add a dynamic action to the registry.
        actions.register(GetIndexTemplatesAction.INSTANCE, TransportGetIndexTemplatesAction.class);
        // Remote Store  
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
        registerHandler.accept(new RestPitSegmentsAction(nodesInCluster));
        this.extensionsManager = extensionsManager;
        UsageService usageService,
        registerHandler.accept(new RestClusterStateAction(settingsFilter));
import org.opensearch.action.admin.cluster.repositories.delete.TransportDeleteRepositoryAction;
import org.opensearch.rest.action.admin.cluster.dangling.RestDeleteDanglingIndexAction;
import org.apache.logging.log4j.Logger;
/*  
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;
            TransportShardMultiTermsVectorAction.class
import org.opensearch.rest.action.cat.RestSegmentsAction;
import org.opensearch.action.admin.cluster.configuration.TransportAddVotingConfigExclusionsAction;  
        registerHandler.accept(new RestIndexPutAliasAction());
        actions.register(NodesUsageAction.INSTANCE, TransportNodesUsageAction.class);  
        registerHandler.accept(new RestRemoteStoreStatsAction());
         */  
import org.opensearch.storage.action.tiering.status.transport.TransportListTieringStatusAction;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotAction;  
        public void registerUnmodifiableActionMap(Map<ActionType, TransportAction> actions) {  
        actions.register(ClusterUpdateSettingsAction.INSTANCE, TransportClusterUpdateSettingsAction.class);
import org.opensearch.rest.action.admin.cluster.RestGetScriptContextAction;
            ActionType.class,
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteAction;
            if (registry.remove(action) == null) {
import org.opensearch.action.admin.indices.segments.TransportIndicesSegmentsAction;
        public TransportAction<? extends ActionRequest, ? extends ActionResponse> get(ActionType<?> action) {  
            this.actions = actions;
import org.opensearch.action.admin.cluster.blockcache.PruneBlockCacheAction;
import org.opensearch.action.support.clustermanager.term.GetTermVersionAction;
                alreadyRegistered.retainAll(actionNames);
                throw new IllegalArgumentException("action [" + action.name() + "] already registered");
        registerHandler.accept(new RestCleanupRepositoryAction());
        registerHandler.accept(new RestNodesStatsAction());  
        bind(new TypeLiteral<RequestValidators<IndicesAliasesRequest>>() {  
import org.opensearch.action.admin.cluster.blockcache.TransportPruneBlockCacheAction;  
    private final IndexNameExpressionResolver indexNameExpressionResolver;  
import org.opensearch.action.support.AutoCreateIndex;
/**
        bind(ActionFilters.class).toInstance(actionFilters);
         * Remove a dynamic route from the registry.  
            // bind the action as eager singleton, so the map binder one will reuse it  
import org.opensearch.action.admin.indices.streamingingestion.state.TransportGetIngestionStateAction;  
         *  
import org.opensearch.action.admin.cluster.allocation.ClusterAllocationExplainAction;  
        actions.register(ResolveIndexAction.INSTANCE, ResolveIndexAction.TransportAction.class);
import org.opensearch.action.admin.cluster.remotestore.stats.RemoteStoreStatsAction;
import org.opensearch.action.admin.cluster.node.tasks.delete.TransportDeleteTaskAction;
        class ActionRegistry extends NamedRegistry<ActionHandler<?, ?>> {
        if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)) {  
import org.opensearch.rest.action.admin.indices.RestFlushAction;
        return actionFilters;  
import org.opensearch.rest.action.admin.indices.RestClearIndicesCacheAction;
import org.opensearch.action.admin.indices.alias.IndicesAliasesAction;
        registerHandler.accept(new RestTemplatesAction());  
        );
        registerHandler.accept(new RestGetStoredScriptAction());
            }  
    }  
import org.opensearch.identity.IdentityService;
        registerHandler.accept(new RestSnapshotsStatusAction());
import org.opensearch.action.index.IndexAction;  
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesAction;
        registerHandler.accept(new RestImportDanglingIndexAction());  
import org.opensearch.persistent.RemovePersistentTaskAction;  
        registerHandler.accept(new RestResizeHandler.RestCloneIndexAction());
        actions.register(DeleteDanglingIndexAction.INSTANCE, TransportDeleteDanglingIndexAction.class);  
import org.opensearch.action.search.StreamSearchAction;
                registeredActionNames.add(action.name());  
        registerHandler.accept(new RestTermVectorsAction());  
        actions.register(GetDecommissionStateAction.INSTANCE, TransportGetDecommissionStateAction.class);
import org.opensearch.action.admin.indices.template.delete.TransportDeleteComponentTemplateAction;  
import org.opensearch.rest.action.search.RestClearScrollAction;
        actions.register(GetRepositoriesAction.INSTANCE, TransportGetRepositoriesAction.class);  
 * Unless required by applicable law or agreed to in writing,
        registerHandler.accept(new RestPutIndexTemplateAction());
import org.opensearch.action.admin.indices.dangling.delete.TransportDeleteDanglingIndexAction;
        registerHandler.accept(new RestMainAction());
        // Subclass NamedRegistry for easy registration  
import org.opensearch.action.admin.indices.streamingingestion.state.TransportUpdateIngestionStateAction;
    // It will be wrapped in the Dynamic Action Registry but otherwise
         * @param action The {@link ActionType}.
        actions.register(NodesReloadSecureSettingsAction.INSTANCE, TransportNodesReloadSecureSettingsAction.class);  
import org.opensearch.action.admin.cluster.remotestore.metadata.TransportRemoteStoreMetadataAction;
import org.opensearch.rest.action.admin.cluster.RestNodesInfoAction;
        Set<RestHeaderDefinition> headers = Stream.concat(
    private final IndexScopedSettings indexScopedSettings;
        );
    @Override  
        /**
import org.opensearch.rest.action.admin.cluster.RestNodesUsageAction;
import org.opensearch.action.admin.cluster.filecache.TransportPruneFileCacheAction;
            if (routeRegistry.containsKey(route)) {  
        actions.register(SimulatePipelineAction.INSTANCE, SimulatePipelineTransportAction.class);
        actions.register(ClearVotingConfigExclusionsAction.INSTANCE, TransportClearVotingConfigExclusionsAction.class);
import org.opensearch.action.admin.cluster.snapshots.get.TransportGetSnapshotsAction;
        registerHandler.accept(new RestPendingClusterTasksAction());
import org.opensearch.action.admin.indices.fielddomain.TransportPutIndexFieldDomainsAction;  
         * @param actionName The name of the action to check
 *     http://www.apache.org/licenses/LICENSE-2.0
        registerHandler.accept(new RestDeleteComponentTemplateAction());  
        );
import org.opensearch.action.update.TransportUpdateAction;  
import org.opensearch.action.admin.cluster.node.usage.NodesUsageAction;  
import org.opensearch.action.admin.cluster.wlm.TransportWlmStatsAction;
 * Modifications Copyright OpenSearch Contributors. See
    // and also registers dynamic actions which may be unregistered. Usually  
import org.opensearch.rest.action.search.RestCreatePitAction;  
import org.opensearch.rest.action.admin.indices.RestIndicesShardStoresAction;  
        // Decommission actions
            requireNonNull(route, "route is required");
    /**
        registerHandler.accept(new RestCreateIndexAction());
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.TransportDeleteWeightedRoutingAction;
                if (restWrapper != null) {  
        public void registerDynamicRoute(NamedRoute route, RestSendToExtensionAction action) {
import java.util.HashSet;
    public ActionModule(  
 * specific language governing permissions and limitations
import org.opensearch.action.admin.indices.upgrade.post.UpgradeSettingsAction;  
        actions.register(UpdateIngestionStateAction.INSTANCE, TransportUpdateIngestionStateAction.class);
import org.opensearch.rest.action.admin.cluster.RestListTasksAction;  
import org.opensearch.action.admin.cluster.health.ClusterHealthAction;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.ingest.PutPipelineTransportAction;
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptAction;
import org.opensearch.common.settings.Settings;  
        registerHandler.accept(new RestDeleteSearchPipelineAction());
import org.opensearch.rest.action.admin.indices.RestOpenIndexAction;  
     * <p>
import org.opensearch.action.bulk.BulkAction;  
                throw new IllegalArgumentException("action [" + route + "] was not registered");
    private ActionFilters setupActionFilters(List<ActionPlugin> actionPlugins) {
            actions.register(StreamSearchAction.INSTANCE, StreamTransportSearchAction.class);
        actions.register(SegmentReplicationStatsAction.INSTANCE, TransportSegmentReplicationStatsAction.class);
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsAction;  
        );
import org.opensearch.action.search.DeletePitAction;
import org.opensearch.rest.action.document.RestBulkAction;
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.rest.action.ingest.RestDeletePipelineAction;
import org.opensearch.action.admin.cluster.deployment.GetDeploymentAction;
import org.opensearch.action.delete.DeleteAction;  
        // Persistent tasks:
                    "action" + (alreadyRegistered.size() > 1 ? "s [" : " [") + acts + "] already registered"
import org.opensearch.action.get.TransportShardMultiGetAction;
import org.opensearch.action.admin.indices.template.get.TransportGetComposableIndexTemplateAction;
            registeredActionNames.addAll(actionNames);
import org.opensearch.action.admin.indices.datastream.DeleteDataStreamAction;
            if (isActionRegistered(routeName)) {
    private final SettingsFilter settingsFilter;  
         */
import org.opensearch.action.admin.indices.template.get.GetComposableIndexTemplateAction;
            binder(),
        this.systemIndices = systemIndices;
        actions.register(DeleteIndexAction.INSTANCE, TransportDeleteIndexAction.class);  
import org.opensearch.action.admin.indices.template.delete.TransportDeleteIndexTemplateAction;
import org.opensearch.action.admin.cluster.decommission.awareness.delete.TransportDeleteDecommissionStateAction;  
            for (Class<?> supportAction : action.getSupportTransportActions()) {  
import org.opensearch.action.admin.cluster.snapshots.status.TransportSnapshotsStatusAction;  
import org.opensearch.action.admin.cluster.node.hotthreads.TransportNodesHotThreadsAction;
import org.opensearch.extensions.rest.RestInitializeExtensionAction;
        List<AbstractCatAction> catActions = new ArrayList<>();  
        registerHandler.accept(new RestGetIngestionStateAction());  
            registerHandler.accept(new RestListTieringStatusAction());
    // associated with remote action execution on extensions, possibly in
            requireNonNull(route, "route is required");
import org.opensearch.rest.action.cat.RestFielddataAction;  
    private final Map<String, ActionHandler<?, ?>> actions;
        mappingRequestValidators = new RequestValidators<>(  
import org.opensearch.action.admin.cluster.shards.TransportCatShardsAction;
        registerHandler.accept(new RestClusterUpdateSettingsAction());
        actions.register(PutRepositoryAction.INSTANCE, TransportPutRepositoryAction.class);
            requireNonNull(transportAction, "transportAction is required");  
        private final Set<String> registeredActionNames = new ConcurrentSkipListSet<>();
import org.opensearch.action.support.DestructiveOperations;  
                Set<String> alreadyRegistered = new HashSet<>(registeredActionNames);
import org.opensearch.action.admin.cluster.remotestore.restore.TransportRestoreRemoteStoreAction;
import org.opensearch.action.admin.indices.segments.PitSegmentsAction;  
import org.opensearch.action.admin.indices.readonly.TransportAddIndexBlockAction;
         */
import org.opensearch.action.search.TransportClearScrollAction;  
import org.opensearch.action.admin.cluster.tasks.TransportPendingClusterTasksAction;
                new RestHeaderDefinition(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, false)
import org.opensearch.rest.action.admin.cluster.RestRemoteStoreMetadataAction;  
        registerHandler.accept(new RestTasksAction(nodesInCluster));
    public ActionFilters getActionFilters() {
import org.opensearch.rest.action.cat.RestIndicesAction;
        registerHandler.accept(new RestPluginsAction());
import org.opensearch.index.seqno.RetentionLeaseActions;  
        actions.register(IndicesExistsAction.INSTANCE, TransportIndicesExistsAction.class);
        registerHandler.accept(new RestResolveIndexAction());
            transportActionsBinder.addBinding(action.getAction()).to(action.getTransportAction()).asEagerSingleton();
        registerHandler.accept(new RestGetDeploymentAction());
import org.opensearch.rest.action.admin.cluster.RestClusterDeleteWeightedRoutingAction;
import org.opensearch.rest.action.admin.indices.RestGetComponentTemplateAction;
import org.opensearch.action.fieldcaps.FieldCapabilitiesAction;
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskAction;
        private Map<ActionType, TransportAction> actions = Collections.emptyMap();
            if (handler instanceof AbstractCatAction abstractCatAction) {  
        actions.register(GetSnapshotsAction.INSTANCE, TransportGetSnapshotsAction.class);
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptAction;
import org.opensearch.action.search.PutSearchPipelineAction;  
import org.opensearch.rest.action.admin.cluster.RestPutRepositoryAction;
        registerHandler.accept(new RestPauseIngestionAction());
            }
        actions.register(WlmStatsAction.INSTANCE, TransportWlmStatsAction.class);  
import org.opensearch.action.explain.ExplainAction;
        registerHandler.accept(new RestGetDataStreamsAction());
import org.opensearch.rest.action.admin.indices.RestDeleteIndexAction;  
import org.opensearch.action.termvectors.TransportShardMultiTermsVectorAction;
        actions.register(RecoveryAction.INSTANCE, TransportRecoveryAction.class);
        registerHandler.accept(new RestMultiTermVectorsAction());
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.storage.action.tiering.RestCancelTierAction;
    private final Settings settings;
            }
import org.opensearch.rest.action.admin.cluster.RestDecommissionAction;
import org.opensearch.common.settings.ClusterSettings;
        // will continue to link ActionType and TransportAction pairs from core and plugin  
import org.opensearch.rest.action.document.RestIndexAction.CreateHandler;  
        this.clusterSettings = clusterSettings;  
                } else {  
    public Map<String, ActionHandler<?, ?>> getActions() {
        public boolean isActionRegistered(String actionName) {
        registerHandler.accept(new RestFieldCapabilitiesAction());
                return routeRegistry.get(namedRoute);
            }
import org.opensearch.action.admin.indices.alias.get.TransportGetAliasesAction;
                restController,  
    protected void configure() {
import org.opensearch.action.admin.indices.alias.get.GetAliasesAction;
import org.opensearch.action.admin.indices.scale.searchonly.ScaleIndexAction;  
import org.opensearch.rest.action.admin.indices.RestCreateDataStreamAction;  
import org.opensearch.rest.action.cat.RestAliasAction;  
import org.opensearch.common.util.FeatureFlags;
        actions.register(ValidateQueryAction.INSTANCE, TransportValidateQueryAction.class);  
        actions.register(
import org.opensearch.rest.action.admin.cluster.RestPendingClusterTasksAction;
        actions.register(GetDataStreamAction.INSTANCE, GetDataStreamAction.TransportAction.class);  
        registerHandler.accept(new RestUpgradeStatusAction());
import org.opensearch.action.admin.indices.analyze.TransportAnalyzeAction;
import java.util.stream.Stream;  
import org.opensearch.rest.action.admin.indices.RestCloseIndexAction;
        registerHandler.accept(new RestSyncedFlushAction());
import org.opensearch.rest.action.search.RestMultiSearchAction;  
        registerHandler.accept(new RestPruneBlockCacheAction());
import org.opensearch.rest.action.admin.indices.RestCreateIndexAction;
        registerHandler.accept(new RestGetAliasesAction());  
import org.opensearch.storage.action.tiering.TransportHotToWarmTierAction;
import org.opensearch.rest.action.cat.RestTasksAction;
            TransportFieldCapabilitiesAction.class,  
import org.opensearch.action.admin.cluster.remotestore.metadata.RemoteStoreMetadataAction;
import org.opensearch.rest.action.search.RestDeleteSearchPipelineAction;
import org.opensearch.rest.action.admin.indices.RestIndicesAliasesAction;
            FieldCapabilitiesAction.INSTANCE,
                bind(supportAction).asEagerSingleton();
         * Remove a dynamic action from the registry.
            return registry.get(action);
        registerHandler.accept(new RestCreatePitAction());
import org.opensearch.storage.action.tiering.status.rest.RestListTieringStatusAction;  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksAction;
import org.opensearch.action.admin.cluster.storedscripts.TransportPutStoredScriptAction;
        registerHandler.accept(new RestSimulateIndexTemplateAction());
        actions.register(SimulateTemplateAction.INSTANCE, TransportSimulateTemplateAction.class);
        registerHandler.accept(new RestClusterGetSettingsAction(settings, clusterSettings, settingsFilter));
        actions.register(AutoPutMappingAction.INSTANCE, TransportAutoPutMappingAction.class);
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateAction;
            registeredActionNames.remove(action.name());
        actions.register(ClusterGetWeightedRoutingAction.INSTANCE, TransportGetWeightedRoutingAction.class);  
        registerHandler.accept(new RestSearchAction(clusterSettings));  
import org.opensearch.action.admin.indices.streamingingestion.resume.TransportResumeIngestionAction;
import org.opensearch.action.admin.indices.template.get.TransportGetIndexTemplatesAction;
import org.opensearch.action.admin.cluster.storedscripts.TransportDeleteStoredScriptAction;
        actions.register(UpgradeSettingsAction.INSTANCE, TransportUpgradeSettingsAction.class);  
import org.opensearch.action.admin.cluster.storedscripts.TransportGetScriptLanguageAction;  
        actions.register(PutMappingAction.INSTANCE, TransportPutMappingAction.class);  
import org.opensearch.action.search.GetSearchPipelineTransportAction;
import org.opensearch.core.action.ActionResponse;  
import java.util.Set;
        actions.register(MultiSearchAction.INSTANCE, TransportMultiSearchAction.class);
        registerHandler.accept(new RestWlmStatsAction());
        /**
import org.opensearch.action.admin.indices.get.TransportGetIndexAction;  
        /**
import org.opensearch.rest.action.admin.indices.RestDeleteIndexTemplateAction;
        actions.register(DeleteSearchPipelineAction.INSTANCE, DeleteSearchPipelineTransportAction.class);
        ThreadPool threadPool,  
import org.opensearch.action.admin.indices.forcemerge.TransportForceMergeAction;
        registerHandler.accept(new RestPutPipelineAction());
         *  
import org.opensearch.rest.action.admin.indices.RestIndicesStatsAction;
        // A dynamic registry to add or remove ActionType / TransportAction pairs  
import org.opensearch.storage.action.tiering.TransportPrepareTieringAction;  
            ActionRegistry() {
        actions.register(GetComposableIndexTemplateAction.INSTANCE, TransportGetComposableIndexTemplateAction.class);
import org.opensearch.rest.action.cat.RestCatSegmentReplicationAction;
        autoCreateIndex = new AutoCreateIndex(settings, clusterSettings, indexNameExpressionResolver, systemIndices);  
        // Search pipelines API
        actions.register(IndicesAliasesAction.INSTANCE, TransportIndicesAliasesAction.class);
        registerHandler.accept(new RestNodesUsageAction());
import org.opensearch.action.admin.cluster.deployment.TransportGetDeploymentAction;
         * @return the corresponding {@link TransportAction} if it is registered, null otherwise.  
import org.opensearch.action.admin.cluster.repositories.get.TransportGetRepositoriesAction;  
import org.opensearch.action.admin.indices.upgrade.post.TransportUpgradeAction;  
        actions.register(RetentionLeaseActions.Renew.INSTANCE, RetentionLeaseActions.Renew.TransportAction.class);  
                clusterSettings,
import org.opensearch.action.admin.cluster.snapshots.clone.CloneSnapshotAction;
        actions.register(UpdateAction.INSTANCE, TransportUpdateAction.class);
            requireNonNull(action, "action is required");
import org.opensearch.rest.action.admin.cluster.RestGetDecommissionStateAction;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsAction;
import org.opensearch.action.admin.cluster.node.stats.TransportNodesStatsAction;  
import org.opensearch.action.admin.indices.template.delete.DeleteComponentTemplateAction;  
 */  
        registerHandler.accept(new RestGetComponentTemplateAction());
import org.opensearch.rest.action.admin.indices.RestIndexPutAliasAction;  
import org.opensearch.wlm.WorkloadGroupTask;
import org.opensearch.common.inject.AbstractModule;
        actions.register(ExplainAction.INSTANCE, TransportExplainAction.class);
import org.opensearch.rest.action.admin.indices.RestAddIndexBlockAction;
import org.opensearch.rest.action.admin.cluster.RestGetDeploymentAction;
        registerHandler.accept(new RestVerifyRepositoryAction());  
import java.util.Collections;
import org.opensearch.action.search.TransportSearchScrollAction;  
 * not use this file except in compliance with the License.
import org.opensearch.rest.action.admin.cluster.RestClusterAllocationExplainAction;
            for (RestHandler handler : plugin.getRestHandlers(
import org.opensearch.action.search.MultiSearchAction;
import org.opensearch.rest.action.admin.indices.RestDataStreamsStatsAction;
        registerHandler.accept(new AutoIdHandler(nodesInCluster));  
            actions.register(ListTieringStatusAction.INSTANCE, TransportListTieringStatusAction.class);  
         */  
 *
import org.opensearch.rest.action.admin.cluster.RestRemoteStoreStatsAction;
        actions.register(GetSearchPipelineAction.INSTANCE, GetSearchPipelineTransportAction.class);  
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesAction;
import org.opensearch.action.admin.indices.dangling.list.TransportListDanglingIndicesAction;
import java.util.function.UnaryOperator;
        registerHandler.accept(new RestUpgradeAction());  
            }
        registerHandler.accept(new RestDeletePipelineAction());
import org.opensearch.rest.action.admin.indices.RestModifyDataStreamsAction;
        registerHandler.accept(new RestListAction(listActions));
        registerHandler.accept(new RestGetScriptLanguageAction());  
import org.opensearch.action.search.DeleteSearchPipelineTransportAction;
                throw new IllegalArgumentException("action [" + action.name() + "] was not registered");  
         *  
        this.settings = settings;  
import java.util.concurrent.ConcurrentHashMap;  
            // ExtensionProxyAction
        actions.register(ScaleIndexAction.INSTANCE, TransportScaleIndexAction.class);
        // Point in time API  
        actions.register(RefreshAction.INSTANCE, TransportRefreshAction.class);
        registerHandler.accept(new RestNodesAction());
        registerHandler.accept(new RestDeleteSnapshotAction());  
            Set<String> actionNames = route.actionNames();
            actions.register(ExtensionProxyAction.INSTANCE, ExtensionProxyTransportAction.class);
        registerHandler.accept(new RestRolloverIndexAction());
        registerHandler.accept(new RestClusterManagerAction());  
import org.opensearch.action.search.ClearScrollAction;  
        Settings settings,
        registerHandler.accept(new RestForceMergeAction());
    // This is initialized at node bootstrap and contains same-JVM actions  
            if (routeRegistry.remove(route) == null) {  
import org.opensearch.action.admin.indices.open.OpenIndexAction;
        registerHandler.accept(new RestFlushAction());  
import org.opensearch.action.admin.cluster.snapshots.delete.TransportDeleteSnapshotAction;  
import org.opensearch.action.search.GetSearchPipelineAction;  
        if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)) {
        registerHandler.accept(new RestMultiGetAction(settings));  
import org.opensearch.action.admin.cluster.allocation.TransportClusterAllocationExplainAction;
import org.opensearch.indices.SystemIndices;
/*
        );
         */
            ) {
import org.opensearch.rest.action.admin.indices.RestScaleIndexAction;  
            actionPlugins.stream().flatMap(p -> p.getRestHeaders().stream()),  
import org.opensearch.action.admin.cluster.storedscripts.TransportGetStoredScriptAction;
import org.opensearch.rest.action.cat.RestPitSegmentsAction;
import org.opensearch.action.explain.TransportExplainAction;  
        actions.register(StartPersistentTaskAction.INSTANCE, StartPersistentTaskAction.TransportAction.class);
import org.opensearch.rest.action.list.AbstractListAction;  
import org.apache.logging.log4j.LogManager;
import org.opensearch.rest.action.search.RestSearchAction;
import org.opensearch.action.admin.cluster.reroute.TransportClusterRerouteAction;  
        // Extensions API
        actions.register(GetIndexAction.INSTANCE, TransportGetIndexAction.class);
        // action handler registration.
        registerHandler.accept(new RestOpenIndexAction());
import org.opensearch.action.search.SearchScrollAction;  
        registerHandler.accept(new RestPutRepositoryAction());  
import org.opensearch.rest.action.admin.indices.RestAnalyzeAction;  
            return null;
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsAction;  
import org.opensearch.action.admin.indices.readonly.AddIndexBlockAction;
            actions.register(PrepareTieringAction.INSTANCE, TransportPrepareTieringAction.class);
import org.opensearch.action.admin.cluster.node.reload.TransportNodesReloadSecureSettingsAction;
        actions.register(AddVotingConfigExclusionsAction.INSTANCE, TransportAddVotingConfigExclusionsAction.class);
            restController::setRequestIdMaxLength
        registerHandler.accept(new RestNodesInfoAction(settingsFilter));  
import org.opensearch.action.admin.indices.cache.clear.TransportClearIndicesCacheAction;  
    }
        actions.register(NodesStatsAction.INSTANCE, TransportNodesStatsAction.class);
        registerHandler.accept(new RestPutStoredScriptAction());  
        actions.register(ListTasksAction.INSTANCE, TransportListTasksAction.class);
                throw new IllegalArgumentException(
import org.opensearch.common.breaker.ResponseLimitSettings;  
    private final DynamicActionRegistry dynamicActionRegistry;  
        actions.register(FindDanglingIndexAction.INSTANCE, TransportFindDanglingIndexAction.class);
        actions.register(RetentionLeaseActions.Add.INSTANCE, RetentionLeaseActions.Add.TransportAction.class);
        registerHandler.accept(new RestScaleIndexAction());  
import org.opensearch.action.admin.indices.dangling.delete.DeleteDanglingIndexAction;  
        actions.register(CloneSnapshotAction.INSTANCE, TransportCloneSnapshotAction.class);
                settingsFilter,  
        registerHandler.accept(new RestThreadPoolAction());  
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryAction;
        registerHandler.accept(new RestPruneCacheAction());
import org.opensearch.rest.action.admin.cluster.RestDeleteRepositoryAction;  
        MapBinder<ActionType, TransportAction> transportActionsBinder = MapBinder.newMapBinder(  
 * under the License.  
        ).collect(Collectors.toSet());  
        actions.register(UpgradeAction.INSTANCE, TransportUpgradeAction.class);
import org.opensearch.rest.action.admin.cluster.RestGetScriptLanguageAction;
        if (FeatureFlags.isEnabled(FeatureFlags.EXTENSIONS)) {
import org.opensearch.rest.action.admin.cluster.RestCloneSnapshotAction;  
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreAction;  
        actions.register(SearchAction.INSTANCE, TransportSearchAction.class);
    static Map<String, ActionHandler<?, ?>> setupActions(List<ActionPlugin> actionPlugins) {
        actions.register(MultiGetAction.INSTANCE, TransportMultiGetAction.class, TransportShardMultiGetAction.class);  
        registerHandler.accept(new RestIndicesStatsAction());  
import org.opensearch.storage.action.tiering.status.GetTieringStatusAction;  
import org.opensearch.action.termvectors.TransportMultiTermVectorsAction;  
        actions.register(GetAliasesAction.INSTANCE, TransportGetAliasesAction.class);
    private final AutoCreateIndex autoCreateIndex;
        List<AbstractListAction> listActions = new ArrayList<>();
        actions.register(DeleteRepositoryAction.INSTANCE, TransportDeleteRepositoryAction.class);
import org.opensearch.action.admin.cluster.snapshots.clone.TransportCloneSnapshotAction;
import org.opensearch.action.admin.indices.scale.searchonly.TransportScaleIndexAction;
        ActionRegistry actions = new ActionRegistry();  
/*  
            requireNonNull(action, "action is required");  
        bind(DestructiveOperations.class).toInstance(destructiveOperations);  
import org.opensearch.rest.action.search.RestSearchScrollAction;  
import org.opensearch.action.admin.cluster.storedscripts.TransportGetScriptContextAction;
import org.opensearch.rest.action.admin.cluster.RestRestoreSnapshotAction;  
import org.opensearch.action.admin.cluster.decommission.awareness.put.TransportDecommissionAction;
import org.opensearch.rest.action.admin.cluster.RestDeleteTaskAction;  
        actions.register(SearchScrollAction.INSTANCE, TransportSearchScrollAction.class);  
import org.opensearch.rest.action.admin.cluster.RestClusterSearchShardsAction;
            requireNonNull(action, "action is required");
     * This class is modeled after {@link NamedRegistry} but provides both register and unregister capabilities.
        if (FeatureFlags.isEnabled(FeatureFlags.STREAM_TRANSPORT)) {  
            TransportGetFieldMappingsIndexAction.class
        IndexScopedSettings indexScopedSettings,  
import org.opensearch.action.admin.indices.template.post.TransportSimulateIndexTemplateAction;
import java.util.List;  
        return actions;
import org.opensearch.action.admin.indices.shrink.ResizeAction;  
        restController = new RestController(headers, restWrapper, nodeClient, circuitBreakerService, usageService);
        registerHandler.accept(new RestValidateQueryAction());
import org.opensearch.rest.action.admin.indices.RestUpgradeAction;
        actions.register(DeleteSnapshotAction.INSTANCE, TransportDeleteSnapshotAction.class);
 * GitHub history for details.
        actions.register(DeletePipelineAction.INSTANCE, DeletePipelineTransportAction.class);  
        registerHandler.accept(new RestRefreshAction());
        // Tiering status api
import org.opensearch.storage.action.tiering.TransportWarmToHotTierAction;
import org.opensearch.storage.action.tiering.HotToWarmTierAction;
import org.opensearch.rest.action.admin.indices.RestForceMergeAction;  
import org.opensearch.action.admin.indices.fielddomain.PutIndexFieldDomainsAction;
import org.opensearch.action.admin.indices.template.put.TransportPutIndexTemplateAction;  
        // Data streams:
import org.opensearch.action.update.UpdateAction;
        registerHandler.accept(new RestUpdateAction());
        registerHandler.accept(new RestGetSearchPipelineAction());  
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsAction;
        actions.register(DecommissionAction.INSTANCE, TransportDecommissionAction.class);  
        actions.register(
import org.opensearch.action.search.TransportGetAllPitsAction;  
import org.opensearch.rest.action.search.RestDeletePitAction;
import org.opensearch.rest.action.cat.RestPluginsAction;  
        bind(DynamicActionRegistry.class).toInstance(dynamicActionRegistry);  
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsAction;
import org.opensearch.action.admin.indices.forcemerge.ForceMergeAction;  
import org.opensearch.rest.action.cat.RestThreadPoolAction;
        registerHandler.accept(new RestCatSegmentReplicationAction());
        registerHandler.accept(new RestHealthAction());  
import org.opensearch.action.admin.cluster.repositories.put.TransportPutRepositoryAction;
import org.opensearch.persistent.CompletionPersistentTaskAction;
            }
        registerHandler.accept(new RestResizeHandler.RestSplitIndexAction());  
        actions.register(ForceMergeAction.INSTANCE, TransportForceMergeAction.class);  
