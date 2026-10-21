        } else if (type.equals("none")) {
     * {@link IllegalStateException} on any failure so node boot halts loudly on misconfiguration.
        }
        return terminated;
                b.bind(SearchPipelineService.class).toInstance(searchPipelineService);
            toClose.add(stc);
            );
     * initialized until an instance of Node is constructed, which is sure to happen after the logging infrastructure
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
                b.bind(DataFormatRegistry.class).toInstance(dataFormatRegistry);
        return lifecycle.closed();
import org.opensearch.storage.directory.TieredDirectoryFactory;
            writePortsFile("transport", transport.boundAddress());
        discovery.setNodeConnectionsService(nodeConnectionsService);
                clusterService = new LocalClusterService(settings, settingsModule.getClusterSettings(), threadPool, clusterManagerMetrics);
import org.opensearch.indices.replication.SegmentReplicationSourceFactory;
    }
            final ClusterInfoService clusterInfoService = newClusterInfoService(settings, clusterService, threadPool, client);
            clusterInfoService.addListener(diskThresholdMonitor::onNewInfo);
        Property.Deprecated,
                    ClusterModule.getNamedXWriteables().stream()
import java.util.function.UnaryOperator;
    );
                searchBackpressureService,
                ClusterName.CLUSTER_NAME_SETTING.get(tmpSettings).value(),
            // Ensure feature flags from opensearch.yml are valid during plugin initialization.
import org.opensearch.arrow.spi.PoolGroup;
 *
                aliasValidator,
    ) {
                clusterService::state,
            pluginsService.filterPlugins(SearchBackEndPlugin.class)
                pluginsService.filterPlugins(ActionPlugin.class),
     * Wait for this node to be effectively closed.
                settings
import org.opensearch.index.compositeindex.CompositeIndexSettings;
            final MetadataDataStreamsService metadataDataStreamsService = new MetadataDataStreamsService(clusterService);
                    threadPool,
            pluginsService.filterPlugins(Plugin.class)
            if (customNameResolver != null) {
                b.bind(NodeService.class).toInstance(nodeService);
     */
import org.opensearch.cluster.InternalClusterInfoService;
import org.opensearch.persistent.PersistentTasksClusterService;
            if (nativeAllocator != null) {
            // Register tiered factory for warm+format indices
import org.opensearch.telemetry.metrics.MetricsRegistry;
                    )
        final RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = injector.getInstance(
            ModulesBuilder modules = new ModulesBuilder();
    }
                actionModule.getActionFilters(),
                injector.getInstance(ShardsBatchGatewayAllocator.class)
                rerouteService,
                    if (telemetrySettings.isTracingFeatureEnabled()) {
    }
            streamTransportService.ifPresent(service -> service.getTaskManager().registerTaskResourceConsumer(taskConsumer));
        Property.Deprecated,
                b.bind(PersistedClusterStateService.class).toInstance(lucenePersistedStateFactory);
                );
                b.bind(MappingTransformerRegistry.class).toInstance(mappingTransformerRegistry);
                        throw new IllegalStateException(
                threadPool,
                }
            final ThreadPool thread = injector.getInstance(ThreadPool.class);
                scriptService
import org.opensearch.action.ActionModule.DynamicActionRegistry;
    protected List<AuxTransport> newAuxTransports(NetworkModule networkModule) {
    /**
            final NetworkService networkService = new NetworkService(
                remoteIndexPathUploader = new RemoteIndexPathUploader(
        // we close indices first, so operations won't be allowed on it
        TransportService transportService = injector.getInstance(TransportService.class);
 * specific language governing permissions and limitations
import org.opensearch.cluster.action.shard.LocalShardStateAction;
                    initialEnvironment.logsDir(),
                threadPool,
                    .collect(
        if (!lifecycle.moveToStopped()) {
                b.bind(MergedSegmentWarmerFactory.class).toInstance(mergedSegmentWarmerFactory);
            transportService,
                        clusterModule.getIndexNameExpressionResolver()
            );
                forbidPrivateIndexSettings,
    // During concurrent close() calls we want to make sure that all of them return after the node has completed it's shutdown cycle.
            injector.getInstance(RemoteClusterStateService.class),
            );
        clusterService.getClusterManagerService().setClusterStatePublisher(discovery);
        );
                    new StreamTransportService(
                        clusterService,
                .map(IndexStorePlugin::getDirectoryFactories)
                    settings,
            if (searchStatsContributors.isEmpty() == false) {
            // Register tiered storage directory factories
                settings,
        }
                b.bind(TransportNodesSnapshotsStatus.class).toInstance(nodesSnapshotsStatus);
                throw new IllegalArgumentException("indices.breaker.type must be one of [hierarchy, none] but was: " + s);
import java.util.HashMap;
            final Set<SettingUpgrader<?>> settingsUpgraders = pluginsService.filterPlugins(Plugin.class)
                        tracer,
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
 * ownership. Elasticsearch licenses this file to you under
        final Metadata onDiskMetadata = gatewayMetaState.getPersistedState().getLastAcceptedState().metadata();
                nodeEnvironment = new NodeEnvironment(
            }
                ClusterModule.getNamedWriteables().stream()
                    b.bind(MergedSegmentPublisher.PublishAction.class).to(RemoteStorePublishMergedSegmentAction.class).asEagerSingleton();
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.node.DiscoveryNode;
        if (FeatureFlags.isEnabled(TELEMETRY)) {
 * You may obtain a copy of the License at
                systemIndices,
     */
                new SystemIngestPipelineCache()
import org.opensearch.gateway.ShardsBatchGatewayAllocator;
                scriptService,
            final Set<DiscoveryNodeRole> additionalRoles = pluginsService.filterPlugins(Plugin.class)
                repositoryService,
                tieredStoragePrefetchSettingsSupplier = () -> null;
    }
            );
                if (streamSearchTransportService.isPresent()) {
                }
import org.opensearch.common.settings.Setting.Property;
        nodeConnectionsService.start();
            toClose.add(plugin);
            );
            this.pluginsService = new PluginsService(
                        transportService.getRemoteClusterService(),
                namedWriteableRegistry
    private final AtomicReference<RunnableTaskExecutionListener> runnableTaskListener;
                clusterService,
                shardLimitValidator,
        // Close plugins in reverse dependency order so dependents release resources before
        toClose.add(injector.getInstance(PeerRecoverySourceService.class));
import org.opensearch.cluster.routing.RerouteService;
import org.opensearch.gateway.GatewayAllocator;
import org.opensearch.script.ScriptService;
        }
                fileCache()
     * Pre-flight write probe for plugin-supplied {@link FsHealthService} paths. Throws
        if (logger.isTraceEnabled()) {
             */
    }
import org.opensearch.plugins.Plugin;
                                threadPool,
            final RemoteClusterStateService remoteClusterStateService;
        }
            logger.info("JVM arguments {}", Arrays.toString(jvmInfo.getInputArguments()));
                circuitBreakerService,
import org.opensearch.storage.tiering.WarmToHotTieringService;
            final ScriptService scriptService = newScriptService(settings, scriptModule.engines, scriptModule.contexts);
     */
            RemoteStorePinnedTimestampService.class
            additionalSettings.add(NODE_DATA_SETTING);
                .map(Plugin::getRoles)
        for (DiscoveryPlugin discoveryPlugin : discoveryPlugins) {
            }
                classpathPlugins
                settingsModule.getSettingsFilter(),
                Constants.OS_ARCH,
            case "none":
            final DiskThresholdMonitor diskThresholdMonitor = new DiskThresholdMonitor(
            final SetOnce<IngestService> ingestServiceReference = new SetOnce<>();
                b.bind(SnapshotShardsService.class).toInstance(snapshotShardsService);
                    latch.await();
import org.opensearch.ingest.IngestService;
                }
     * in InternalSettingsPreparer#finalizeSettings, which runs when creating the Environment, before logging is
                    new IndexStoreListener.CompositeIndexStoreListener(indexStoreListenerStream.collect(Collectors.toList()))
                clusterService,
            );
import org.opensearch.cluster.service.LocalClusterService;
        final ClusterService clusterService = injector.getInstance(ClusterService.class);
                });
                    b.bind(StreamSearchTransportService.class).toProvider((Providers.of(null)));
                OsProbe.getInstance()
                final List<ExtensionAwarePlugin> extensionAwarePlugins = pluginsService.filterPlugins(ExtensionAwarePlugin.class);
            final IngestService ingestService = new IngestService(
                b.bind(PersistedStateRegistry.class).toInstance(persistedStateRegistry);
            }
import org.opensearch.Version;
                namedWriteableRegistry,
        );
            );
        logger.info("stopped");
                .map(p -> (LifecycleComponent) p)
        nodeService.getMonitorService().stop();
                ex.addSuppressed(e);
        Property.Deprecated,
import org.opensearch.threadpool.ThreadPool;
                .map(Plugin::getSettingUpgraders)
import org.opensearch.script.ScriptModule;
import org.opensearch.crypto.CryptoHandlerRegistry;
import org.opensearch.discovery.DiscoveryModule;
            final ClusterService clusterService;
     * This method can be overwritten by subclasses to change their {@link BigArrays} implementation for instance for testing
                    Arrays.toString(initialEnvironment.dataFiles()),
                clusterService,
import org.opensearch.plugins.ClusterPlugin;
            CacheModule cacheModule = new CacheModule(pluginsService.filterPlugins(CachePlugin.class), settings);
                b.bind(AutoForceMergeManager.class).toInstance(autoForceMergeManager);
                threadPool,
     * @param discoveryPlugins Discovery plugins list
    ) {
                settings,
import org.opensearch.action.search.SearchTransportService;
        // of stream transport for it to use it in localNode creation
        toClose.add(() -> stopWatch.stop().start("resource_usage_collector"));
                .stream()
            if (isRemoteDataAttributePresent(settings) && CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.get(settings)) {
                b.bind(SegmentReplicator.class).toInstance(segmentReplicator);
                restController,
    }
    public Node(Environment environment) {
     * initialized.
            return this;
                this.environment,
import org.opensearch.action.support.TransportAction;
                threadPool,
                b.bind(ClusterInfoService.class).toInstance(clusterInfoService);
                        + a.cacheName()
                admissionControlService
    public static class DiscoverySettings {
        }
                    clusterService.getClusterSettings(),
                remoteStoreStatsTrackerFactory,
                settings,
            );
                b.bind(NamedXContentRegistry.class).toInstance(xContentRegistry);
            }
                b.bind(Environment.class).toInstance(this.environment);
                Files.delete(probe);
    }
            pluginsService.filterPlugins(CircuitBreakerPlugin.class).forEach(plugin -> {
            final RemoteIndexPathUploader remoteIndexPathUploader;
import org.apache.lucene.util.Constants;
                    TelemetryModule telemetryModule = new TelemetryModule(telemetryPlugins, telemetrySettings);
                .collect(Collectors.toList());
                            searchRequestStats,
                Map.copyOf(dataFormatAwareStoreDirectoryFactories),
                SearchExecutionStatsCollector.makeWrapper(responseCollectorService)
            );
 * this file be licensed under the Apache-2.0 license or a
            final TieredStoragePrefetchSettings tieredStoragePrefetchSettings;
        calculateFileCacheSize(capacityRaw, 0L);
import org.opensearch.tasks.TaskResourceTrackingService;
            );
                Build.CURRENT.date(),
            } else {
                b.bind(SearchRequestOperationsCompositeListenerFactory.class).toInstance(searchRequestOperationsCompositeListenerFactory);
            final NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(namedWriteables);
                repositoriesServiceReference::get,
import org.opensearch.action.search.StreamSearchTransportService;
                scriptService,
                b.bind(NetworkService.class).toInstance(networkService);
            IndicesModule indicesModule = new IndicesModule(mapperPlugins);
        StreamTransportService stc = injector.getInstance(StreamTransportService.class);
            );
                logger.warn(
                assert injector.getInstance(MetaStateService.class).loadFullState().v1().isEmpty();
            // All threads terminated successfully. Because search, recovery and all other operations
        public CustomForkJoinWorkerThread(ForkJoinPool pool) {
    }
                searchTransportService,
        discovery.startInitialJoin();
            tracer = tracerFactory.getTracer();
                transportInterceptors,
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
        TaskResourceTrackingService taskResourceTrackingService,
        nodeService.getTaskCancellationMonitoringService().stop();
    public Environment getEnvironment() {
import java.io.BufferedWriter;
    /**
            }
                b.bind(SearchService.class).toInstance(searchService);
            );
                threadPool,
            systemTemplatesService.verifyRepositories();
            }
        final RemoteClusterStateService remoteClusterStateService = injector.getInstance(RemoteClusterStateService.class);
            additionalSettings.add(NODE_INGEST_SETTING);
                .flatMap(p -> p.getAdditionalHealthPaths(settings).stream())
                dynamicActionRegistry,
            injector.getInstance(PersistedStateRegistry.class),
        logger.info("started");
                assert nodeMetadata.nodeId().equals(localNodeFactory.getNode().getId());
            resourcesToClose.add(resourceWatcherService);
            final MetadataCreateDataStreamService metadataCreateDataStreamService = new MetadataCreateDataStreamService(
        nodeService.getMonitorService().start();
            modules.add(actionModule);
                b.bind(WorkloadGroupService.class).toInstance(workloadGroupService);
                            "registered composite index store type [" + k + "] conflicts with a built-in default type"
            }
        return new ScriptService(settings, engines, contexts);
            ClusterStateObserver observer = new ClusterStateObserver(clusterState, clusterService, null, logger, thread.getThreadContext());
import java.nio.file.StandardCopyOption;
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;
import org.opensearch.plugins.SearchStatsContributor;
                clusterService.addLocalNodeClusterManagerListener(
    }
            );
import java.util.function.Function;
            );
            settings(),
                    environment,
            toClose.add(injector.getInstance(Tracer.class));
            final List<Object> pluginComponents = new ArrayList<>();
    }
                .flatMap(List::stream)
            AdmissionControlTransportInterceptor admissionControlTransportInterceptor = new AdmissionControlTransportInterceptor(
            // service needs access to the existing shards allocators (e.g. the GatewayAllocator, ShardsBatchGatewayAllocator) which
                    "Duplicate BlockCacheProvider for name ["
            // If node construction fails before IndicesService takes ownership of the registry
                this.extensionsManager = new NoopExtensionsManager(identityService);
                .stream()
     * Creates a new the SearchService. This method can be overwritten by tests to inject mock implementations.
import org.opensearch.plugins.ActionPlugin;
    /**
import org.opensearch.transport.Transport;
                    environment,
                );
import org.opensearch.wlm.WorkloadManagementSettings;
                b.bind(PersistentTasksExecutorRegistry.class).toInstance(registry);
        Collection<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories,
                assert nodeMetadata.nodeVersion().equals(Version.CURRENT);
    public Client client() {
import org.opensearch.index.store.remote.filecache.NodeCacheService;
        NodeAndClusterIdStateListener.getAndSetNodeIdAndClusterId(
                    b.bind(PeerRecoverySourceService.class)
            final MetaStateService metaStateService = new MetaStateService(nodeEnvironment, xContentRegistry);
            additionalSettings.add(NODE_MASTER_SETTING);
        } catch (IOException e) {
        // if we had scroll searchers etc or recovery going on we wait for to finish.
    protected SearchService newSearchService(
                bigArrays,
        // their dependencies (e.g. child allocators close before the root allocator owner).
        );
    private static final String CLIENT_TYPE = "node";
            ).stream().collect(java.util.stream.Collectors.toMap(org.opensearch.plugins.BlockCacheProvider::cacheName, p -> p, (a, b) -> {
import java.nio.file.Files;
import org.opensearch.common.cache.service.CacheService;
                clusterService.getClusterSettings(),
        toClose.addAll(pluginsToClose);
import org.opensearch.common.settings.ClusterSettings;
                    IndicesModule.getNamedXContents().stream(),
                threadPool
                settings,
import java.util.function.Supplier;
                settings,
        injector.getInstance(NodeConnectionsService.class).stop();
    /**
                throw new IllegalStateException("Plugin-supplied health path [" + path + "] is not writable: " + e.getMessage(), e);
                        pluginComponents.stream()
        return new TransportService(
 *
                remoteIndexPathUploader = null;
import org.opensearch.node.remotestore.RemoteStoreNodeService;
            this.pluginLifecycleComponents = Collections.unmodifiableList(pluginLifecycleComponents);
                return s;
import org.opensearch.plugins.FieldFilterProvider;
                searchModule.getValuesSourceRegistry().getUsageService(),
import org.opensearch.tasks.TaskCancellationMonitoringSettings;
                return ByteSizeValue.parseBytesSizeValue(capacityRaw, NODE_SEARCH_CACHE_SIZE_SETTING.getKey()).getBytes();
import org.opensearch.plugins.NetworkPlugin;
        }
            );
import org.opensearch.cluster.ClusterName;
            // (see IndicesService#doClose), close it here so factories don't leak.
     * @param boundTransportAddress the network addresses the node is
                clusterService,
                secureSettingsFactories
                && (Character.isWhitespace(value.charAt(0)) || Character.isWhitespace(value.charAt(value.length() - 1)))) {
                    .findFirst()
                circuitBreakerService,
            actionModule.initRestHandlers(() -> clusterService.state().nodes());
            // and fail-fast detection of duplicate names at startup.
                    List.of(remoteIndexPathUploader),
                buildConcurrencyLimiterStatsSupplier(pluginsService)
import org.opensearch.common.settings.SettingsModule;
import org.opensearch.action.ActionConcurrencyLimiterStats;
                    fsHealthService,
            return value;
            List<NamedWriteableRegistry.Entry> namedWriteables = Stream.of(
    /**
        }
            pluginsService.filterPlugins(IndexStorePlugin.class)
                if (nodeCacheService != null) {
                metadataCreateIndexService,
            if (clusterless) {
            pluginComponentRegistry.seal();
                clusterModule.getAllocationService(),
                repositoryService,
            }
        true,
                indicesModule.getMapperRegistry(),
import org.opensearch.monitor.process.ProcessProbe;
        return customNameResolvers;
        Collections.reverse(pluginsToClose);
            BigArrays bigArrays = createBigArrays(pageCacheRecycler, circuitBreakerService);
                b.bind(Node.class).toInstance(this);
import org.opensearch.indices.RemoteStoreSettings;
import java.io.IOException;
        return networkModule.getAuxServerTransportList();
            SnapshotsService snapshotsService = new SnapshotsService(
                initialEnvironment.pluginsDir(),
                        tracerFactory = new NoopTracerFactory();
            if (FeatureFlags.isEnabled(FeatureFlags.EXTENSIONS)) {
            PageCacheRecycler pageCacheRecycler = createPageCacheRecycler(settings);
            );
                b.bind(AggregationUsageService.class).toInstance(searchModule.getValuesSourceRegistry().getUsageService());
    }
                );
            }
        public static final Setting<TimeValue> INITIAL_STATE_TIMEOUT_SETTING = Setting.positiveTimeSetting(
            logger.info("initialized");
            localNodeFactory = new RemoteStoreVerifyingLocalNodeFactory(settings, nodeEnvironment.nodeId(), remoteStoreNodeService);
                    repositoriesServiceReference::get,
                pluginsService.filterPlugins(RepositoryPlugin.class),
            final SearchBackpressureService searchBackpressureService = new SearchBackpressureService(
import org.opensearch.identity.IdentityService;
        Discovery discovery = injector.getInstance(Discovery.class);
                    repositoriesServiceReference::get,
import org.opensearch.extensions.ExtensionsManager;
import org.opensearch.cluster.ClusterManagerMetrics;
            fetchPhase,
import org.opensearch.plugins.IndexStorePlugin;
                b.bind(UpdateHelper.class).toInstance(new UpdateHelper(scriptService));
            success = true;
                    b.bind(SegmentReplicationTargetService.class)
            // into the allocator so it can make over-commit admission decisions when a native pool is
                remoteClusterStateService = null;
        assert localNodeFactory.getNode() != null;
            NamedXContentRegistry xContentRegistry = new NamedXContentRegistry(
    /** Writes a file to the logs dir containing the ports for the given transport type */
        toClose.add(injector.getInstance(ResourceUsageCollectorService.class));
     * @opensearch.internal
        if (DiscoveryNode.isClusterManagerNode(settings)) {
                repositoriesServiceReference::get,
                if (fileCache != null) {
                        xContentRegistry,
            WorkloadManagementTransportInterceptor workloadManagementTransportInterceptor = new WorkloadManagementTransportInterceptor(
     */
     * Custom ForkJoinWorkerThread that preserves the context ClassLoader of the creating thread
        } catch (IOException e) {
        return new PageCacheRecycler(settings);
import org.opensearch.common.unit.TimeValue;
            CacheService cacheService = cacheModule.getCacheService();
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
                                recoverySettings,
        final NodeConnectionsService nodeConnectionsService = injector.getInstance(NodeConnectionsService.class);
        Path portsFile = environment.logsDir().resolve(type + ".ports");
        Property.NodeScope
                    threadPool,
            final CompositeIndexSettings compositeIndexSettings = new CompositeIndexSettings(settings, settingsModule.getClusterSettings());
     */
import org.opensearch.telemetry.TelemetrySettings;
                threadPool,
        this.autoForceMergeManager.start();
            );
                if (isRemoteDataAttributePresent(settings)) {
                Runtime.version().toString()
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteDataAttributePresent;
                repositoriesServiceReference::get,
                xContentRegistry,
import org.opensearch.plugins.PluginsService;
                indicesService
                scriptService,
            logger.info(
            new BootstrapContext(environment, onDiskMetadata),
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
        }
                settingsModule.getIndexScopedSettings(),
                b.bind(RerouteService.class).toInstance(rerouteService);
                repositoryService,
import org.opensearch.tasks.Task;
                client,
                .map(Optional::get)
                if (streamTransportService.isPresent()) {
import org.opensearch.indices.recovery.PeerRecoverySourceService;
import org.opensearch.snapshots.InternalSnapshotsInfoService;
        // we load the global state here (the persistent part of the cluster state stored on disk) to
            final ResourceWatcherService resourceWatcherService = new ResourceWatcherService(settings, threadPool);
                workloadGroupService,
    final NamedWriteableRegistry namedWriteableRegistry;
                compositeIndexSettings,
        toClose.add(injector.getInstance(HttpServerTransport.class));
                pluginComponents.stream().forEach(p -> b.bind((Class) p.getClass()).toInstance(p));
                pluginsService.filterPlugins(RestoreListenerPlugin.class)
        ClusterService clusterService,
            final Transport transport = networkModule.getTransportSupplier().get();
                clusterService,
            }
            final WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(
            // Register the index creation validators for mapping updates as well, so a mapping
import org.opensearch.cluster.applicationtemplates.SystemTemplatesService;
 * The OpenSearch Contributors require contributions made to
    private static class RemoteStoreVerifyingLocalNodeFactory extends LocalNodeFactory {
                indicesService,
            }));
            concurrentSearchDeciderFactories,
            final Map<String, IndexStorePlugin.DirectoryFactory> builtInDirectoryFactories = IndexModule.createBuiltInDirectoryFactories(
                );
                    if (telemetryPluginsImplementingTelemetryAware.isEmpty() == false) {
            final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(repositoriesServiceReference::get, threadPool);
    }
                settings,
            assertCanWritePluginHealthPaths(pluginAdditionalHealthPaths);
                usageService,
            }
                    "Some shards are still open after the threadpool terminated. "
     * Note: Visible for testing
                    List<TelemetryPlugin> telemetryPlugins = pluginsService.filterPlugins(TelemetryPlugin.class);
                workloadManagementTransportInterceptor
                Build.CURRENT.hash(),
import org.opensearch.OpenSearchException;
                b.bind(MetadataIndexUpgradeService.class).toInstance(metadataIndexUpgradeService);
                b.bind(AwarenessReplicaBalance.class).toInstance(awarenessReplicaBalance);
        } catch (OpenSearchParseException e) {
                        );
import org.opensearch.index.store.DefaultCompositeDirectoryFactory;
            bigArrays,
                    Build.CURRENT.getQualifiedVersion()
            // collect engine factory providers from plugins
                .flatMap(Set::stream)
package org.opensearch.node;
                settings,
        private RemoteStoreVerifyingLocalNodeFactory(
            final Map<String, org.opensearch.index.store.DataFormatAwareStoreDirectoryFactory> dataFormatAwareStoreDirectoryFactories =
            if (nodeService.awaitClose(0, TimeUnit.MILLISECONDS) == false) {
import org.opensearch.gateway.PersistedClusterStateService;
        }
            final Supplier<Transport> streamTransportSupplier = networkModule.getStreamTransportSupplier();
            final RestController restController = actionModule.getRestController();
                    b.bind(TierActionMetrics.class).toInstance(new TierActionMetrics(metricsRegistry));
import org.opensearch.common.util.PageCacheRecycler;
                settings,
                clusterInfoService,
    }
            this.nodeService = new NodeService(
                nodeResourceUsageTracker,
 * in order to use a {@link Client} to perform actions/operations against the cluster.
                .collect(Collectors.toList());
                Map.copyOf(directoryFactories),
                )
        protected final Settings settings;
 */
        injector.getInstance(NodeResourceUsageTracker.class).start();
                        + "Something is leaking index readers or store references."
            resourcesToClose.add(nodeEnvironment);
                nodeEnvironment,
        switch (s) {
            streamTransport,
                    .map(plugin -> plugin.getTaskManagerClient(client, clusterService, threadPool))
    }
                segmentReplicator::startReplication,
            );
            // adds the context to the DeprecationLogger so that it does not need to be injected everywhere
                IndexStorePlugin.class
import org.opensearch.search.query.QueryPhase;
import org.opensearch.transport.TransportInterceptor;
                    pluginsService.filterPlugins(DiscoveryPlugin.class),
            final MetadataUpgrader metadataUpgrader = new MetadataUpgrader(indexTemplateMetadataUpgraders);
        String type = BREAKER_TYPE_KEY.get(settings);
     * and {@link #NODE_MASTER_SETTING} must also be false.
            final CircuitBreakerService circuitBreakerService = createCircuitBreakerService(
                    new MaximumResourceTaskSelectionStrategy(),
                    public void onTimeout(TimeValue timeout) {
import org.opensearch.env.NodeEnvironment;
import org.opensearch.monitor.fs.FsHealthService;
                indexingPressureService,
            pluginsService.filterPlugins(Plugin.class)
            List<SearchStatsContributor> searchStatsContributors = pluginsService.filterPlugins(SearchStatsContributor.class);
                taskHeaders,
                .stream()
                networkModule.getTransportInterceptor(),
            );
import org.opensearch.cluster.deployment.DeploymentManagerService;
                workloadGroupsStateAccessor
import org.opensearch.monitor.os.OsProbe;
                systemIndices,
                pluginsService.filterPlugins(Plugin.class).stream().flatMap(p -> p.getNamedWriteables().stream()),
                bigArrays,
        transportService.start();
import org.opensearch.cluster.metadata.AliasValidator;
                client
import org.opensearch.indices.IndicesService;
                circuitBreakerService,
        if (terminated) {
                observer.waitForNextChange(new ClusterStateObserver.Listener() {
                .stream()
        toClose.add(injector.getInstance(NodeEnvironment.class));
                transportService,
                } else {
        if (initialStateTimeout.millis() > 0) {
                transportService,
    /**
            repositoriesServiceReference.set(repositoryService);
        injector.getInstance(IndicesClusterStateService.class).stop();
                environment.settings(),
import org.opensearch.tasks.consumer.TopNSearchTasksLogger;
                b.bind(ShardLimitValidator.class).toInstance(shardLimitValidator);
        // we should stop this last since it waits for resources to get released
        final List<Closeable> resourcesToClose = new ArrayList<>(); // register everything we need to release in the case of an error
    /**
                        resourceWatcherService,
import org.opensearch.action.ActionModule;
import java.io.Closeable;
                .filter(Optional::isPresent)
        TransportInterceptor interceptor,
            final SearchBackpressureSettings searchBackpressureSettings = new SearchBackpressureSettings(
                    NamedXContentRegistry.EMPTY,
import org.opensearch.plugins.SystemIndexPlugin;
                threadPool,
                        + a.getClass().getName()
    /**
import org.opensearch.common.logging.HeaderWarning;
import org.opensearch.monitor.jvm.JvmInfo;
            clusterService.addStateApplier(scriptService);
                b.bind(MergedSegmentPublisher.class).asEagerSingleton();
                    p -> p.getPersistentTasksExecutor(
                );
        Node::validateFileCacheSize,
                    threadPool::preciseRelativeTimeInNanos,
            final Optional<StreamTransportService> streamTransportService = streamTransport != null
     * Returns {@code true} if the node is closed.
            final PersistentTasksClusterService persistentTasksClusterService = new PersistentTasksClusterService(
     */
            final AwarenessReplicaBalance awarenessReplicaBalance = new AwarenessReplicaBalance(
    }
    private final Tracer tracer;
     * This method can be overwritten by subclasses to change their {@link BigArrays} implementation for instance for testing
            final Transport streamTransport = wrapStreamTransport(streamTransportSupplier != null ? streamTransportSupplier.get() : null);
                    public void onClusterServiceClose() {
                    xContentRegistry,
                transportService,
    public static final Setting.AffixSetting<String> NODE_ATTRIBUTES = Setting.prefixKeySetting(
                indicesService,
    );
            TimeValue.timeValueSeconds(30),
import org.opensearch.monitor.fs.FsServiceProvider;
                    clusterService,
            final UsageService usageService = new UsageService();
                            searchTaskRequestOperationsListener,
                settings,
            final RecoverySettings recoverySettings = new RecoverySettings(settings, settingsModule.getClusterSettings());
                clusterService,
            throw new IllegalArgumentException("Unknown circuit breaker type [" + type + "]");
                throw new IllegalStateException(
        final GatewayMetaState gatewayMetaState = injector.getInstance(GatewayMetaState.class);
                    settings,
            );
                clusterService.getClusterSettings(),
                        metricsRegistry
                BootstrapSettings.initializeSerialFilter();
                        repositoriesServiceReference::get,
                admissionControlTransportInterceptor,
import org.opensearch.common.settings.ConsistentSettingsService;
import org.opensearch.cluster.routing.allocation.DiskThresholdMonitor;
                b.bind(MetaStateService.class).toInstance(metaStateService);
                SearchBackEndPlugin.class
                    e
            streamTransportService.start();
    );
import org.opensearch.plugins.IdentityPlugin;
        } finally {
import org.opensearch.index.store.DefaultDataFormatAwareStoreDirectoryFactory;
        List<NetworkService.CustomNameResolver> customNameResolvers = new ArrayList<>();
                b.bind(IngestService.class).toInstance(ingestService);
            FeatureFlags.initializeFeatureFlags(tmpSettings);
        NodeClient client
            final IngestionPayloadDecoderRegistry.Builder registryBuilder = IngestionPayloadDecoderRegistry.builder()
import org.opensearch.telemetry.metrics.NoopMetricsRegistryFactory;
import org.opensearch.telemetry.tracing.NoopTracerFactory;
     * Creates a new {@link BigArrays} instance used for this node.
                b.bind(SearchBackpressureService.class).toInstance(searchBackpressureService);
            throw new RuntimeException("Failed to write ports file", e);
        private final RemoteStoreNodeService remoteStoreNodeService;
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        toClose.add(injector.getInstance(SegmentReplicationTargetService.class));
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            // build ingestion payload decoder registry
 */
        private final SetOnce<DiscoveryNode> localNode = new SetOnce<>();
                {
        ThreadPool threadPool,
                    .toInstance(new SearchPhaseController(namedWriteableRegistry, searchService::aggReduceContextBuilder));
            );
                    settings,
                    tracerFactory = new NoopTracerFactory();
            } catch (FileSystemException e) {
                System.getProperty("java.version"),
    /**
    public Node start() throws NodeValidationException {
 * A node represent a node within a cluster ({@code cluster.name}). The {@link #client()} can be used
            streamTransportService.acceptIncomingRequests();
            );
                this.nodeCacheService = NodeCacheService.create(settings, nodeEnvironment, blockCacheProviders);
    protected Node(final Environment initialEnvironment, Collection<PluginInfo> classpathPlugins, boolean forbidPrivateIndexSettings) {
                    compositeDirectoryFactories.put(k, v);
                        Collectors.toMap(
        }
            nativeAllocatorStatsRegistry.ifPresent(
    /**
        Transport transport,
 * under the License.
        }
    }
                                "Telemetry plugins %s should not implement TelemetryAwarePlugin interface",
        } else {
     */
                pluginsService.filterPlugins(IngestPlugin.class),
                    e
        toClose.add(() -> stopWatch.start("node_service"));
import org.opensearch.plugins.PersistentTaskPlugin;
import org.opensearch.indices.recovery.RecoverySettings;
            } catch (AccessDeniedException e) {
            final Supplier<NativeAllocatorPoolStats> nativeAllocatorStatsSupplier = nativeAllocatorStatsRegistry.map(
                clusterService
        pluginsService.filterPlugins(ClusterPlugin.class).forEach(plugin -> plugin.onNodeStarted(clusterService.localNode()));
    /**
            modules.add(new GatewayModule());
     * requests.
                clusterService,
import org.opensearch.common.lease.Releasables;
            resourcesToClose.add(() -> ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));
            resourcesToClose.add(circuitBreakerService);
                    pluginComponentRegistry
                .flatMap(m -> m.entrySet().stream())
                b.bind(RemoteStorePinnedTimestampService.class).toProvider(() -> remoteStorePinnedTimestampService);
            HeaderWarning.setThreadContext(threadPool.getThreadContext());
                    clusterService.getClusterManagerService(),
                threadPool,
                throw new IllegalArgumentException(key + " cannot have leading or trailing whitespace " + "[" + value + "]");
    }
            final SearchRequestOperationsCompositeListenerFactory searchRequestOperationsCompositeListenerFactory =
            final IndexStorePlugin.DirectoryFactory remoteDirectoryFactory = new RemoteSegmentStoreDirectoryFactory(
import java.util.concurrent.Executor;
import java.util.HashSet;
                b.bind(ResourceWatcherService.class).toInstance(resourceWatcherService);
        if (remoteClusterStateService != null) {
                clusterService.getClusterSettings()
                .map(IndexStorePlugin::getRecoveryStateFactories)
            final List<Path> pluginAdditionalHealthPaths = pluginsService.filterPlugins(Plugin.class)
                remoteStoreSettings,
    private Node stop() {
            clusterService.addListener(service);
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED;
            final TaskCancellationMonitoringSettings taskCancellationMonitoringSettings = new TaskCancellationMonitoringSettings(
                .put(Client.CLIENT_TYPE_SETTING_S.getKey(), CLIENT_TYPE)
import org.opensearch.cluster.ClusterModule;
import org.opensearch.common.Nullable;
            return this;
                clusterService.getClusterSettings(),
                    ).toArray(SearchRequestOperationsListener[]::new)
            final Collection<SecureSettingsFactory> secureSettingsFactories = pluginsService.filterPlugins(Plugin.class)
import org.opensearch.plugin.stats.AnalyticsBackendTaskCancellationStats;
                // Covers ENOSPC, read-only filesystem, etc. The reason() field, when present, is
        // pass it to the bootstrap checks to allow plugins to enforce certain preconditions based on the recovered state.
        injector.getInstance(ClusterService.class).stop();
                additionalSettings,
                    .stream()
 * compatible open source license.
        toClose.add(() -> stopWatch.stop().start("thread_pool"));
            );
            final WorkloadGroupRequestOperationListener workloadGroupRequestOperationListener = new WorkloadGroupRequestOperationListener(
                remoteStoreSettings,
                    "version [{}] is a pre-release version of OpenSearch and is not suitable for production",
        try {
                b.bind(TaskResourceTrackingService.class).toInstance(taskResourceTrackingService);
                environment,
import org.opensearch.action.search.SearchRequestSlowLog;
    private static final Setting<Boolean> NODE_REMOTE_CLUSTER_CLIENT = Setting.boolSetting(
                .forEach(p -> p.getIndexCreationValidators().forEach(metadataCreateIndexService::addIndexCreationValidator));
    );
    @Override
            clusterService.setRerouteService(rerouteService);
import org.opensearch.rest.RestController;
                logger.info("JVM home [{}], using bundled JDK/JRE [{}]", System.getProperty("java.home"), jvmInfo.getUsingBundledJdk());
                b.bind(SearchPhaseController.class)
                        throw new IllegalStateException(
        final BoundTransportAddress boundTransportAddress,
                b.bind(Transport.class).toInstance(transport);
            );
import org.opensearch.plugins.SearchPlugin;
        toClose.add(() -> stopWatch.stop().start("node_environment"));
            final TransportService transportService = newTransportService(
                threadPool,
import org.opensearch.common.SetOnce;
            default:
                b.bind(ExtensionsManager.class).toInstance(this.extensionsManager);
                ingestService,
        StreamTransportService streamTransportService = injector.getInstance(StreamTransportService.class);
            );
                b.bind(Client.class).toInstance(client);
                pluginsService.filterPlugins(NetworkPlugin.class),
            pluginComponents.addAll(newAuxTransports(networkModule));
                .map(Optional::get);
            clusterService.setIndexingPressureService(indexingPressureService);
import java.util.Collections;
import org.opensearch.common.util.FeatureFlags;
import org.opensearch.cluster.service.ClusterService;
        // This can confuse other nodes and delay things - mostly if we're the cluster manager and we're running tests.
        injector.getInstance(NodeResourceUsageTracker.class).stop();
import org.opensearch.index.engine.EngineFactory;
            indicesService,
                    pluginComponentRegistry.register(component);
            SystemTemplatesService systemTemplatesService = new SystemTemplatesService(
        injector.getInstance(FsHealthService.class).start();
            return localNode.get();
import org.opensearch.search.SearchService;
                compositeDirectoryFactories.put(
import org.opensearch.common.util.BigArrays;
                settingsModule.getClusterSettings()
                    // Supplier for current cluster state application duration in ms (0 if idle)
            });
import org.opensearch.repositories.RepositoriesService;
            final Settings settings = pluginsService.updatedSettings();
                threadPool,
        }
import org.opensearch.cluster.metadata.Metadata;
                    client,
     * Returns the environment of the node
            }
import java.nio.file.NoSuchFileException;
                .filter(Objects::nonNull)
            clusterService.addLocalNodeClusterManagerListener(systemTemplatesService);
            // When the rebalancer adjusts the effective limit of pools in the INDEXING group,
                );
                    remoteStoreSettings
                threadPool,
        try {
                metadataIndexUpgradeService,
    BigArrays createBigArrays(PageCacheRecycler pageCacheRecycler, CircuitBreakerService circuitBreakerService) {
                            .collect(Collectors.toList())
                metaStateService,
        autoForceMergeManager.stop();
                clusterService.addListener(new SystemIndexMetadataUpgradeService(systemIndices, clusterService));
            Environment.assertEquivalent(initialEnvironment, this.environment);
                clusterService,
            } else {
import org.opensearch.usage.UsageService;
                        + b.getClass().getName()
                        Stream.concat(indexStoreListenerStream, Stream.of(new NodeCacheServiceCleaner(() -> this.nodeCacheService)))
        true,
        List<BootstrapCheck> bootstrapChecks
                pluginsService.filterPlugins(SystemIndexPlugin.class)
                dataFormatAwareStoreDirectoryFactories.put(
                .collect(Collectors.toList());
            clusterService,
        return pluginsService;
import org.opensearch.search.backpressure.SearchBackpressureService;
                bigArrays,
            // so we might be late here already
            final SearchTransportService searchTransportService = new SearchTransportService(
import java.nio.charset.StandardCharsets;
            final Collection<EnginePlugin> enginePlugins = pluginsService.filterPlugins(EnginePlugin.class);
import org.opensearch.cluster.metadata.MetadataDataStreamsService;
                remoteClusterStateCleanupManager = remoteClusterStateService.getCleanupManager();
     */
                scriptService,
                pageCacheRecycler,
            this.autoForceMergeManager = new AutoForceMergeManager(
        // close discovery early to not react to pings anymore.
            if (isRemoteStoreAttributePresent(settings)) {
                    }
                    new IndexStoreListener.CompositeIndexStoreListener(
            final Map<String, IndexStorePlugin.CompositeDirectoryFactory> compositeDirectoryFactories = new HashMap<>();
                repositoryService,
        toClose.add(nodeService.getTaskCancellationMonitoringService());
import org.opensearch.plugins.SecureSettingsFactory;
        }
                } else {
                threadPool,
import org.opensearch.snapshots.SnapshotShardsService;
            );
                    if (k.equals("default")) {
 * Licensed to Elasticsearch under one or more contributor
                NativeAllocatorStatsRegistry::supplier
/*
                                Locale.ROOT,
            final FsServiceProvider fsServiceProvider = new FsServiceProvider(
                transport,
                Set<Setting<?>> additionalSettings = new HashSet<>();
            final ResourceUsageCollectorService resourceUsageCollectorService = new ResourceUsageCollectorService(
                    new ConsistentSettingsService(settings, clusterService, consistentSettings).newHashPublisher()
            ).stream().map(SearchBackEndPlugin::getAnalyticsBackendTaskCancellationStats).filter(Objects::nonNull).findFirst().orElse(null);
            } else {
            });
        return new SearchService(
import org.opensearch.common.inject.Injector;
        return streamTransport;
     * Creates a new {@link BigArrays} instance used for this node.
            final Map<String, org.opensearch.plugins.BlockCacheProvider> blockCacheProviders = pluginsService.filterPlugins(
                Map.copyOf(compositeDirectoryFactories),
                    workloadManagementSettings,
                clusterService.getClusterSettings(),
                .findFirst();
                try {
            MetricsRegistryFactory metricsRegistryFactory;
                clusterService.getClusterSettings(),
            resourcesToClose.addAll(pluginLifecycleComponents);
                    () -> clusterService.getClusterApplierService().getCurrentApplicationDurationMs()
        return environment;
    /**
        IndicesService indicesService,
                            )
import org.opensearch.extensions.NoopExtensionsManager;
        toClose.add(injector.getInstance(Discovery.class));
                threadPool,
        final InternalClusterInfoService service = new InternalClusterInfoService(settings, clusterService, threadPool, client);
            }));
                settings,
import static org.opensearch.common.util.FeatureFlags.TELEMETRY;
            // report a path that overlaps with another contributor or with nodeDataPaths).
                indicesService
                });
        Property.Deprecated,
    }
        (key) -> new Setting<>(key, "", (value) -> {
    private void writePortsFile(String type, BoundTransportAddress boundAddress) {
            }
     * Hook for validating the node after network
            pluginComponentRegistry.register(dataFormatRegistry);
                    gatewayMetaState,
                    @Override
                searchModule.getFetchPhase(),
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteClusterStateConfigured;
                    searchModule.getNamedXContents().stream(),
import org.opensearch.plugins.SearchBackEndPlugin;
                : Optional.empty();
            if (isRemoteClusterStateConfigured(settings)) {
     * Extended factory that verifies remote store repositories during node creation.
    protected HttpServerTransport newHttpTransport(NetworkModule networkModule) {
                    .collect(Collectors.toCollection(LinkedHashSet::new))
                );
            // need to be able to trigger a reroute, which needs to call into the allocation service. We close the loop here:
            final GatewayMetaState gatewayMetaState = new GatewayMetaState();
            indexSearcherExecutor,
                    transportService,
                );
                taskResourceTrackingService,
                    namedWriteableRegistry,
import org.opensearch.indices.SystemIndices;
                clusterService,
                nodeCacheService.registerProviders(blockCacheProviders);
                pluginsService.filterPlugins(ActionPlugin.class).stream().flatMap(p -> p.getTaskHeaders().stream()),
                pluginsService,
                threadPool,
                recoverySettings,
                additionalSettings.addAll(builder.getRegisteredSettings());
                    new TieredDirectoryFactory(tieredStoragePrefetchSettingsSupplier)
                new SearchRequestOperationsCompositeListenerFactory(
                clusterService,
            super(pool);
            SearchModule searchModule = new SearchModule(settings, pluginsService.filterPlugins(SearchPlugin.class));
                transportService,
                logger.info("JVM home [{}]", System.getProperty("java.home"));
                        threadPool,
        toClose.add(() -> stopWatch.stop().start("indices"));
                b.bind(SnapshotsInfoService.class).toInstance(snapshotsInfoService);
            if (value.length() > 0
                settings,
        if (lifecycle.closed() == false) {
                throw new IllegalStateException(
                    threadPool,
import org.opensearch.script.ScriptEngine;
     */
import org.opensearch.persistent.PersistentTasksExecutorRegistry;
import org.opensearch.plugins.RestoreListenerPlugin;
                            new SegmentReplicationTargetService(
            pluginProfilers,
                this.environment,
                    throw new OpenSearchTimeoutException("Interrupted while waiting for initial discovery state");
            );
            }
            injector.getInstance(MetaStateService.class),
            pluginsService.filterPlugins(IndexStorePlugin.class)
                        clusterModule.getIndexNameExpressionResolver(),
                repositoriesServiceReference::get,
            client = new NodeClient(settings, threadPool);
                jvmInfo.pid(),
                throw new IllegalStateException(STREAM_TRANSPORT + " is enabled but no stream transport supplier is provided");
            // The search for viable copies is triggered by an allocation attempt (i.e. a reroute) and is performed asynchronously. When it
                for (Object component : components) {
    );
            scriptService,
            final AliasValidator aliasValidator = new AliasValidator();
     * controls whether the node is allowed to persist things like metadata to disk
                nativeAllocatorStatsSupplier,
     */
            // the SearchRequestOperationsListener instanceof filter on pluginComponents elsewhere
import org.opensearch.index.IndexModule;
import org.opensearch.gateway.MetaStateService;
        toClose.add(() -> stopWatch.stop().start("client"));
            } else {
import org.opensearch.index.remote.RemoteIndexPathUploader;
import org.opensearch.ratelimitting.admissioncontrol.transport.AdmissionControlTransportInterceptor;
        final TimeValue initialStateTimeout = DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.get(settings());
import org.opensearch.OpenSearchTimeoutException;
import java.nio.file.StandardOpenOption;
import org.opensearch.plugins.CryptoKeyProviderPlugin;
                throw new IllegalStateException(
            assert localNode.get() != null;
                discovery,
                        threadPool,
import org.opensearch.tasks.TaskCancellationMonitoringService;
                reg -> reg.setNativeMemoryPressureSupplier(nodeResourceUsageTracker::getNativeMemoryUtilizationPercent)
                    settings,
                searchModule.getPluginProfileMetricsProviders(),
            clusterService,
            final List<IdentityPlugin> identityPlugins = new ArrayList<>();
    }
            } catch (NoSuchFileException e) {
            );
                Build.CURRENT.getQualifiedVersion(),
     * {@link #NODE_DATA_SETTING}). However, if this is false, {@link #NODE_DATA_SETTING}
}
     *
            final IngestionPayloadDecoderRegistry payloadDecoderRegistry = registryBuilder.build();
            taskHeaders,
                ProcessProbe.getInstance(),
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
                settings,
                    b.bind(SegmentReplicationSourceService.class)
    }
                b.bind(FsHealthService.class).toInstance(fsHealthService);
                searchPipelineService,
                    remoteClusterStateService
        toClose.add(injector.getInstance(IndicesStore.class));
    private final ExtensionsManager extensionsManager;
            metricsRegistry = metricsRegistryFactory.getMetricsRegistry();
import org.opensearch.index.store.remote.filecache.NodeCacheServiceCleaner;
 * this work for additional information regarding copyright
                threadPool,
                remoteStorePinnedTimestampService = null;
                .forEach(
        for (Path path : paths) {
            final PersistedStateRegistry persistedStateRegistry = new PersistedStateRegistry();
    // synchronized to prevent running concurrently with close()
import org.opensearch.plugins.ScriptPlugin;
                    remoteStoreNodeService,
        injector.getInstance(PeerRecoverySourceService.class).start();
                        namedWriteableRegistry,
        injector.getInstance(GatewayService.class).start();
        toClose.add(nodeService.getMonitorService());
import org.opensearch.common.util.io.IOUtils;
                tieredStoragePrefetchSettingsSupplier = () -> tieredStoragePrefetchSettings;
                transportService,
                httpServerTransport,
                settings,
        if (stc != null) {
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
                .stream()
        }
                    "using config [{}], data [{}], logs [{}], plugins [{}]",
import org.opensearch.storage.tiering.HotToWarmTieringService;
import java.nio.file.Path;
import org.opensearch.common.inject.util.Providers;
                clusterService,
            client.initialize(
            // that run on shards run in the threadpool, indices should be effectively closed by now.
     *                              bound and publishing to
            resourcesToClose.add(persistentTasksClusterService);
import java.util.concurrent.CountDownLatch;
            );
                        latch.countDown();
                Files.deleteIfExists(probe);
            settings,
                        .toInstance(new PeerRecoveryTargetService(threadPool, transportService, recoverySettings, clusterService));
import org.opensearch.common.logging.NodeAndClusterIdStateListener;
import org.opensearch.common.lifecycle.LifecycleComponent;
        configureNodeAndClusterIdStateListener(clusterService);
    public static final Setting<String> BREAKER_TYPE_KEY = new Setting<>("indices.breaker.type", "hierarchy", (s) -> {
            pluginsService.filterPlugins(Plugin.class).stream().flatMap(p -> p.getBootstrapChecks().stream()).collect(Collectors.toList())
    private final NodeClient client;
            Settings tmpSettings = Settings.builder()
import org.opensearch.action.search.SearchExecutionStatsCollector;
        final BootstrapContext context,
                                new SegmentReplicationSourceFactory(transportService, recoverySettings, clusterService),
            } else {
            );
                client,
            threadPool.registerClusterSettingsListeners(settingsModule.getClusterSettings());
                .map(IndexStorePlugin::getCompositeDirectoryFactories)
                indicesService,
            injector = modules.createInjector();
        injector.getInstance(SearchService.class).start();
 * SPDX-License-Identifier: Apache-2.0
        @Nullable Transport streamTransport,
/*
import org.opensearch.action.admin.cluster.snapshots.status.TransportNodesSnapshotsStatus;
                initialEnvironment.modulesDir(),
            } catch (IOException | RuntimeException e) {
        injector.getInstance(SearchService.class).stop();
            final PersistentTasksService persistentTasksService = new PersistentTasksService(clusterService, threadPool, client);
                    resourceWatcherService,
            final WorkloadGroupsStateAccessor workloadGroupsStateAccessor = new WorkloadGroupsStateAccessor();
                            String.format(
            super(settings, persistentNodeId);
                )
                b.bind(NamedWriteableRegistry.class).toInstance(namedWriteableRegistry);
            return Math.round(totalSpace * ratioValue.getAsRatio());
                .map(IndexStorePlugin::getStoreFactories)
    }
import java.util.concurrent.ForkJoinPool;
            );
                clusterManagerMetrics,
                            plugin -> plugin.getClass().getCanonicalName(),
import org.opensearch.plugins.EnginePlugin;
                .ifPresent(supplier -> monitorService.memoryReportingService().setNativeStatsSupplier(supplier));
                tieredStoragePrefetchSettings = new TieredStoragePrefetchSettings(clusterService.getClusterSettings());
                pluginComponents.addAll(components);
import org.opensearch.plugins.CryptoPlugin;
                    new TieredDataFormatAwareStoreDirectoryFactory(tieredStoragePrefetchSettingsSupplier)
                DiscoveryNode.getRolesFromSettings(settings)
                remoteStoreSettings.getSegmentsPathFixedPrefix(),
import org.opensearch.index.SegmentReplicationStatsTracker;
                        );
                .collect(Collectors.toList());
            final Supplier<AnalyticsBackendTaskCancellationStats> analyticsTaskCancellationStatsSupplier = pluginsService.filterPlugins(
                org.opensearch.plugins.BlockCacheProvider.class
            this.remoteStoreNodeService = remoteStoreNodeService;
            // Collect providers into a map keyed by cache name for O(1) lookup
import org.opensearch.cluster.applicationtemplates.SystemTemplatesPlugin;
                    "Plugin-supplied health path [" + path + "] is not writable (no such file or directory): " + e.getMessage(),
        "node.remote_cluster_client",
        }
                .filter(p -> p instanceof LifecycleComponent)
 * KIND, either express or implied.  See the License for the
    private List<NetworkService.CustomNameResolver> getCustomNameResolvers(List<DiscoveryPlugin> discoveryPlugins) {
    public Injector injector() {
            );
    /**
/*
import org.opensearch.indices.replication.SegmentReplicationTargetService;
        pluginLifecycleComponents.forEach(LifecycleComponent::start);
        BigArrays bigArrays,
            }
            final DataFormatRegistry dataFormatRegistry = new DataFormatRegistry(pluginsService);
        Tracer tracer
            scriptModule.registerClusterSettingsListeners(scriptService, settingsModule.getClusterSettings());
            final List<MapperPlugin> mapperPlugins = pluginsService.filterPlugins(MapperPlugin.class);
                    ).stream()
                clusterService,
            }
import org.opensearch.wlm.WorkloadGroupService;
                discovery = new DiscoveryModule(
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;
                b.bind(IndexingPressureService.class).toInstance(indexingPressureService);
import org.opensearch.plugins.IngestionConsumerPlugin;
                settings,
            final SystemIndices systemIndices = new SystemIndices(systemIndexDescriptorMap);
            setContextClassLoader(Thread.currentThread().getContextClassLoader());
            remoteStoreStatsTrackerFactory = new RemoteStoreStatsTrackerFactory(clusterService, settings);
    @Nullable
            ingestServiceReference.set(ingestService);
                nodeCacheService,
            final List<ExecutorBuilder<?>> executorBuilders = pluginsService.getExecutorBuilders(settings);
        }
            } catch (IOException e) {
        "node.search.cache.size",
            final DeploymentStateService deploymentStateService = new DeploymentStateService(() -> clusterService.state());
                    List<TelemetryPlugin> telemetryPluginsImplementingTelemetryAware = telemetryPlugins.stream()
import org.opensearch.wlm.WorkloadManagementTransportInterceptor;
                b.bind(DeploymentStateService.class).toInstance(deploymentStateService);
            }
import org.opensearch.index.mapper.MappingTransformerRegistry;
                shardLimitValidator,
        }
        QueryPhase queryPhase,
        public DiscoveryNode apply(BoundTransportAddress boundTransportAddress) {
        injector.getInstance(SegmentReplicationTargetService.class).start();
            // collect ingestion consumer factory providers from plugins
            final ThreadPool threadPool = new ThreadPool(settings, runnableTaskListener, executorBuilders.toArray(new ExecutorBuilder[0]));
     * Start the node. If the node is already started, this method is no-op.
                workloadManagementSettings,
                nodeCacheService,
            List<BreakerSettings> pluginCircuitBreakers = pluginsService.filterPlugins(CircuitBreakerPlugin.class)
                    pluginsService.filterPlugins(Plugin.class).stream().flatMap(p -> p.getNamedXContent().stream()),
                }
            Files.move(tmpPortsFile, portsFile, StandardCopyOption.ATOMIC_MOVE);
import org.opensearch.common.settings.Settings;
            case "hierarchy":
                metadataCreateIndexService,
        Settings settings,
                                segmentReplicator
            final ScriptModule scriptModule = new ScriptModule(settings, pluginsService.filterPlugins(ScriptPlugin.class));
            final NativeAllocator nativeAllocator = pluginComponentRegistry.getComponent(NativeAllocator.class).orElse(null);
            }
            final SearchService searchService = newSearchService(
                        .filter(a -> TelemetryAwarePlugin.class.isAssignableFrom(a.getClass()))
                    directoryFactories.put(k, v);
        toClose.add(injector.getInstance(NodeResourceUsageTracker.class));
        Property.NodeScope
        "node.data",
                b.bind(TransportService.class).toInstance(transportService);
import org.opensearch.action.ActionType;
                clusterService,
        ClusterService clusterService,
    public static final Setting<Boolean> NODE_LOCAL_STORAGE_SETTING = Setting.boolSetting(
            }
            final NodeRuntimeMetrics nodeRuntimeMetrics = new NodeRuntimeMetrics(
            final boolean clusterless = clusterPlugins.stream().anyMatch(ClusterPlugin::isClusterless);
                        environment,
            );
            taskResourceTrackingService,
            );
            pluginLifecycleComponents.addAll(
        autoForceMergeManager.stop();
import org.opensearch.core.xcontent.NamedXContentRegistry;
                clusterService,
                    b.bind(WarmToHotTieringService.class).asEagerSingleton();
            final SearchPipelineService searchPipelineService = new SearchPipelineService(
            dataFormatAwareStoreDirectoryFactories.put("default", new DefaultDataFormatAwareStoreDirectoryFactory());
    /**
        Settings settings,
        return client;
                assert nodeMetadata != null;
                        streamTransport,
    }
                analysisModule.getAnalysisRegistry(),
        this(environment, Collections.emptyList(), true);
        ThreadPool threadPool,
            )
    /**
import org.opensearch.plugins.IdentityAwarePlugin;
                monitorService.fsService(),
            );
    }
            if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)) {
            List<TransportInterceptor> transportInterceptors = List.of(
                pluginsService,
     * <p>Visible for testing.
        injector.getInstance(ResourceUsageCollectorService.class).start();
        }
                localNodeFactory,
            final Discovery discovery;
            interceptor,
                threadPool,
                } catch (InterruptedException e) {
        Property.NodeScope
                clusterService,
                taskResourceTrackingService,
            resourcesToClose.add(nodeRuntimeMetrics);
                b.bind(RemoteClusterStateCleanupManager.class).toProvider(() -> remoteClusterStateCleanupManager);
        ) {
        WorkloadGroupService workloadGroupService
            } else {
                remoteClusterStateCleanupManager = null;
            // Add the telemetryAwarePlugin components to the existing pluginComponents collection.
                ingestServiceReference::get,
                Constants.JVM_VENDOR,
            }
                metricsRegistry,
            final ShardLimitValidator shardLimitValidator = new ShardLimitValidator(settings, clusterService, systemIndices);
                searchModule.getValuesSourceRegistry(),
            Property.NodeScope
import org.opensearch.cluster.action.index.MappingUpdatedAction;
                .stream()
        toClose.add(injector.getInstance(NodeConnectionsService.class));
    /**
            );
                remoteStorePinnedTimestampService,
                searchModule.getConcurrentSearchRequestDeciderFactories(),
                    }
    );
                clusterService.getClusterSettings()
                .put(NODE_ATTRIBUTES.getKey() + SHARD_INDEXING_PRESSURE_ENABLED_ATTRIBUTE_KEY, "true")
        try (BufferedWriter writer = Files.newBufferedWriter(tmpPortsFile, StandardCharsets.UTF_8)) {
            resourcesToClose.add(metricsRegistry::close);
                    settings,
                searchBackpressureSettings,
            resourcesToClose.add(clusterService);
                taskManagerClientOptional.ifPresent(value -> b.bind(TaskManagerClient.class).toInstance(value));
import org.opensearch.search.deciders.ConcurrentSearchRequestDecider;
                    "Plugin-supplied health path [" + path + "] is not writable (filesystem error): " + reason,
            } else {
import org.opensearch.wlm.WorkloadGroupsStateAccessor;
                        );
            List<IdentityAwarePlugin> identityAwarePlugins = pluginsService.filterPlugins(IdentityAwarePlugin.class);
    private final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(Node.class);
import org.opensearch.plugins.DefaultPluginComponentRegistry;
                Plugin.class
 */
                for (ExtensionAwarePlugin extAwarePlugin : extensionAwarePlugins) {
import org.opensearch.action.search.SearchTaskRequestOperationsListener;
                .flatMap(m -> m.entrySet().stream())
import java.util.concurrent.atomic.AtomicReference;
import org.opensearch.plugins.BlockCacheRegistry;
                        latch.countDown();
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteStoreAttributePresent;
                .stream()
                        + "]: "
            ActionModule actionModule = new ActionModule(
                    p -> p.createComponents(
    private static Supplier<ActionConcurrencyLimiterStats> buildConcurrencyLimiterStatsSupplier(PluginsService pluginsService) {
            final RerouteService rerouteService = new BatchedRerouteService(clusterService, clusterModule.getAllocationService()::reroute);
            streamNodeConnectionsService.start();
                        networkModule.getTransportInterceptor(),
 *    http://www.apache.org/licenses/LICENSE-2.0
            final ResponseCollectorService responseCollectorService = new ResponseCollectorService(clusterService);
 * software distributed under the License is distributed on an
import org.opensearch.cluster.action.shard.ShardStateAction;
import org.opensearch.plugin.stats.NativeAllocatorStatsRegistry;
import static org.opensearch.index.ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED_ATTRIBUTE_KEY;
            // BlockCaches are active). On hot nodes there is nothing to clean up.
    }
import org.opensearch.common.network.NetworkAddress;
                searchRequestStats,
import org.opensearch.core.Assertions;
            Path probe = path.resolve(".opensearch_plugin_health_boot_probe_" + UUIDs.randomBase64UUID());
import org.opensearch.indices.SystemIndexDescriptor;
    private static final Setting<Boolean> NODE_MASTER_SETTING = Setting.boolSetting(
        toClose.add(() -> stopWatch.stop().start("resource_usage_tracker"));
                String reason = e.getReason() != null ? e.getReason() : e.getMessage();
                workloadGroupService
        private final String persistentNodeId;
            }
                    b.bind(BlockCacheRegistry.class).toProvider(Providers.of(null));
        injector.getInstance(WorkloadGroupService.class).start();
                    environment,
import org.opensearch.bootstrap.BootstrapCheck;
                    p -> p.getAdditionalIndexSettingProviders().forEach(metadataCreateIndexService::addAdditionalIndexSettingProvider)
     * Creates a new the ScriptService. This method can be overwritten by tests to inject mock implementations.
import org.opensearch.threadpool.ExecutorBuilder;
            compositeDirectoryFactories.put("default", new DefaultCompositeDirectoryFactory());
                settingsModule.getClusterSettings(),
                b.bind(AnalysisRegistry.class).toInstance(analysisModule.getAnalysisRegistry());
        StopWatch stopWatch = new StopWatch("node_close");
     * The {@link PluginsService} used to build this node's components.
import org.opensearch.monitor.MonitorService;
                }
                resourceUsageCollectorService,
     * Delegates to {@link NodeCacheService} which owns the FileCache lifecycle.
import org.opensearch.search.SearchModule;
                b.bind(SystemIndices.class).toInstance(systemIndices);
     * @param initialEnvironment         the initial environment for this node, which will be added to by plugins
                recoverySettings,
import org.opensearch.common.settings.SettingUpgrader;
                settingsModule.getIndexScopedSettings(),
     * and before the network service starts accepting incoming network
     * @see #BREAKER_TYPE_KEY
        gatewayMetaState.start(
            );
        toClose.add(() -> injector.getInstance(ThreadPool.class).shutdown());
                pluginsService.filterPlugins(SystemTemplatesPlugin.class),
    private final PluginsService pluginsService;
            pluginComponents.addAll(telemetryAwarePluginComponents);
        toClose.add(() -> stopWatch.stop().start("search"));
            remoteStorePinnedTimestampService.start();
                tracerFactory = new NoopTracerFactory();
                threadPool
                Collection<Object> components = p.createComponents(
                .map(SearchBackEndPlugin::getAnalyticsBackendNativeMemoryStats)
            toClose.add(injector.getInstance(MetricsRegistry.class));
    @Nullable
                this.environment,
                clusterModule.getIndexNameExpressionResolver(),
        "node.attr.",
    /**
            final SearchRequestStats searchRequestStats = new SearchRequestStats(clusterService.getClusterSettings());
            TracerFactory tracerFactory;
    private final Environment environment;
                ),
                settings,
            final Map<String, IngestionConsumerFactory> ingestionConsumerFactories = new HashMap<>();
                }
                );
            );
import org.opensearch.tasks.TaskResultsService;
    public static CircuitBreakerService createCircuitBreakerService(
            threadPool,
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;
import org.opensearch.plugins.SearchPipelinePlugin;
                new FileCacheSettings(settings, clusterService.getClusterSettings())::getRemoteDataRatio,
    public NodeEnvironment getNodeEnvironment() {
            ).orElse(null);
import java.util.Optional;
                    namedWriteableRegistry,
                if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)) {
import org.opensearch.search.backpressure.settings.SearchBackpressureSettings;
                b.bind(SearchTransportService.class).toInstance(searchTransportService);
            /*
    /**
            this.settings = settings;
            String persistentNodeId,
                    networkService,
            additionalSettings.add(NODE_REMOTE_CLUSTER_CLIENT);
                .stream()
                cacheService,
    private final MergedSegmentWarmerFactory mergedSegmentWarmerFactory;
import org.opensearch.cluster.metadata.SystemIndexMetadataUpgradeService;
            // Block-cache providers discovered once, reused for budget, registration, and capacity.
                    .stream()
import org.opensearch.common.UUIDs;
                settings,
        logger.info("closed");
        injector.getInstance(SnapshotsService.class).stop();
                searchModule.getQueryPhase(),
import org.opensearch.node.resource.tracker.NodeResourceUsageTracker;
                b.bind(PersistentTasksClusterService.class).toInstance(persistentTasksClusterService);
     */
                        settingsModule,
                    repositoriesServiceReference::get,
                b.bind(RepositoriesService.class).toInstance(repositoryService);
     */
                b.bind(SnapshotsService.class).toInstance(snapshotsService);
                searchModule.getIndexSearcherExecutor(threadPool),
                pluginsService.filterPlugins(NativeRemoteObjectStoreProvider.class)
        if (providers.isEmpty()) {
 *
            transportService.boundAddress(),
import org.opensearch.storage.metrics.TierActionMetrics;
        true,
                namedWriteableRegistry,
import java.util.concurrent.TimeUnit;
    // In this case the process will be terminated even if the first call to close() has not finished yet.
import org.opensearch.telemetry.TelemetryModule;
                workloadGroupService
                b.bind(MetadataCreateDataStreamService.class).toInstance(metadataCreateDataStreamService);
            }
                analyticsTaskCancellationStatsSupplier
                clusterService.getClusterSettings()
            DiscoveryNode.setDeprecatedMasterRole();
import java.util.stream.Stream;
import org.opensearch.script.ScriptContext;
import org.opensearch.index.store.IndexStoreListener;
            final Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories = pluginsService.filterPlugins(
     * services are started but before the cluster service is started
            final DiscoveryNode discoveryNode = DiscoveryNode.createLocal(
            remoteIndexPathUploader.start();
                );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                b.bind(PluginsService.class).toInstance(pluginsService);
            final IndicesService indicesService = new IndicesService(
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
                registry,
     * test-only request-handler interception works on the streaming path
                .forEach(p -> p.getIndexCreationValidators().forEach(metadataMappingServiceInstance::addIndexCreationValidator));
                    threadPool,
        ScriptService scriptService,
import java.util.Arrays;
 * Modifications Copyright OpenSearch Contributors. See
            final Optional<StreamSearchTransportService> streamSearchTransportService = streamTransportService.map(
     * Get Custom Name Resolvers list based on a Discovery Plugins list
                pluginsService.filterPlugins(CryptoPlugin.class),
        TaskResourceTrackingService taskResourceTrackingService = injector.getInstance(TaskResourceTrackingService.class);
        ResponseCollectorService responseCollectorService,
                CircuitBreaker breaker = circuitBreakerService.getBreaker(plugin.getCircuitBreaker(settings).getName());
 * the Apache License, Version 2.0 (the "License"); you may
                b.bind(IndicesService.class).toInstance(indicesService);
                additionalSettingsFilter,
                circuitBreakerService,
                        logger.warn("timed out while waiting for initial discovery state - timeout: {}", initialStateTimeout);
            if (value.length() > 0 && "node.attr.server_name".equals(key)) {
            final IndexingPressureService indexingPressureService = new IndexingPressureService(settings, clusterService);
        if (stc != null) {
                stc -> new StreamSearchTransportService(stc, SearchExecutionStatsCollector.makeWrapper(responseCollectorService))
            if (FeatureFlags.isEnabled(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)) {
                    @Override
        // start streamTransportService before transportService so that transport service has access to publish address
import java.util.Collection;
        injector.getInstance(SnapshotShardsService.class).start();
     */
import static java.util.stream.Collectors.toList;
            final ClusterModule clusterModule = new ClusterModule(
    /** Constructs a {@link org.opensearch.http.HttpServerTransport} which may be mocked for tests. */
                Files.write(probe, "boot".getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE_NEW);
        injector.getInstance(GatewayService.class).stop();
        transportService.getTaskManager().setTaskCancellationService(new TaskCancellationService(transportService));
                settings,
                    } else {
        toClose.add(injector.getInstance(TransportService.class));
            );
import org.opensearch.common.logging.DeprecationLogger;
        Set<String> taskHeaders,
                );
            clusterModule.setExistingShardsAllocators(
                        latch.countDown();
                settingsUpgraders
                b.bind(HttpServerTransport.class).toInstance(httpServerTransport);
import org.opensearch.snapshots.RestoreService;
            if (BootstrapSettings.SERIAL_FILTER_SETTING.get(settings)) {
            final SegmentReplicationStatsTracker segmentReplicationStatsTracker = new SegmentReplicationStatsTracker(indicesService);
                    if (builtInDirectoryFactories.containsKey(k)) {
        injector.getInstance(SegmentReplicationSourceService.class).start();
            final MappingTransformerRegistry mappingTransformerRegistry = new MappingTransformerRegistry(mapperPlugins, xContentRegistry);
            clusterSettings,
                dataFormatRegistry
                settingsModule.getSettingsFilter(),
                pluginsService.filterPlugins(CryptoKeyProviderPlugin.class),
                b.bind(RemoteStoreSettings.class).toInstance(remoteStoreSettings);
            injector.getInstance(PersistedClusterStateService.class),
                settings
            Collection<Object> telemetryAwarePluginComponents = pluginsService.filterPlugins(TelemetryAwarePlugin.class)
                    b.bind(HotToWarmTieringService.class).asEagerSingleton();
            RatioValue ratioValue = RatioValue.parseRatioValue(capacityRaw);
     *
                    initialEnvironment.pluginsDir()
            DiscoveryNode.setAdditionalRoles(additionalRoles);
import org.opensearch.gateway.remote.RemoteClusterStateCleanupManager;
            ).flatMap(Function.identity()).collect(Collectors.toList());
    }
                b.bind(Tracer.class).toInstance(tracer);
    }
                dataFormatRegistry
        return nodeEnvironment;
            rerouteServiceReference.set(rerouteService);
            // We don't want to shutdown the threadpool or interrupt threads on a node that is not
import org.opensearch.cluster.ClusterInfoService;
            }
            // closed yet.
import org.opensearch.telemetry.tracing.TracerFactory;
import org.opensearch.transport.client.node.NodeClient;
                    initialEnvironment.configDir(),
            identityService.initializeIdentityAwarePlugins(identityAwarePlugins);
import org.opensearch.storage.directory.TieredDataFormatAwareStoreDirectoryFactory;
            writePortsFile("http", http.boundAddress());
                threadPool,
                .collect(Collectors.toList());
     * A client that can be used to execute actions (operations) against the cluster.
            Set<String> taskHeaders = Stream.concat(
            RemoteStoreRestoreService remoteStoreRestoreService = new RemoteStoreRestoreService(
                NetworkModule.getNamedWriteables().stream(),
                remoteClusterStateService = new RemoteClusterStateService(
                .map(plugin -> plugin.getCircuitBreaker(settings))
            modules.add(indicesModule);
                    b.bind(FileCache.class).toProvider(Providers.of(null));
            final SearchRequestSlowLog searchRequestSlowLog = new SearchRequestSlowLog(clusterService);
            final FsHealthService fsHealthService = new FsHealthService(
                transportService.getRemoteClusterService(),
        injector.getInstance(TransportService.class).stop();
            // Initialize tiered storage prefetch settings
                throw new IllegalStateException(
                        ),
import org.opensearch.common.cache.module.CacheModule;
                this.extensionsManager = new ExtensionsManager(additionalSettings, identityService);
            // IMC's native buffer is updated to 70% of the new grouped limit.
            final WorkloadGroupResourceUsageTrackerService workloadGroupResourceUsageTrackerService =
import org.opensearch.watcher.ResourceWatcherService;
            final List<String> additionalSettingsFilter = new ArrayList<>(pluginsService.getPluginSettingsFilter());
            resourcesToClose.add(tracer::close);
        injector.getInstance(FsHealthService.class).stop();
import org.opensearch.transport.AuxTransport;
    private final MetricsRegistry metricsRegistry;
    public static final Setting<String> NODE_NAME_SETTING = Setting.simpleString("node.name", Property.NodeScope);
                getCustomNameResolvers(pluginsService.filterPlugins(DiscoveryPlugin.class))
                .forEach(plugin -> plugin.getIngestionPayloadDecoderFactories().forEach(registryBuilder::register));
                        metricsRegistryFactory = new NoopMetricsRegistryFactory();
            // in this file. Server has no compile-time dependency on arrow-base.
                indicesService.setSearchStatsContributors(searchStatsContributors);
                        scriptService,
            // this is as early as we can validate settings at this point. we already pass them to ScriptModule as well as ThreadPool
            final List<PersistentTasksExecutor<?>> tasksExecutors = pluginsService.filterPlugins(PersistentTaskPlugin.class)
import org.opensearch.persistent.PersistentTasksService;
            // We allocate copies of existing shards by looking for a viable copy of the shard in the cluster and assigning the shard there.
    }
        }
                xContentRegistry,
                Constants.OS_VERSION,
                    clusterService,
        private LocalNodeFactory(Settings settings, String persistentNodeId) {
                        Stream.of(
        // Don't call shutdownNow here, it might break ongoing operations on Lucene indices.
import org.opensearch.plugins.AnalysisPlugin;
import org.opensearch.index.autoforcemerge.AutoForceMergeMetrics;
import org.opensearch.cluster.routing.BatchedRerouteService;
                writer.write(NetworkAddress.format(new InetSocketAddress(inetAddress, address.getPort())) + "\n");
            final MonitorService monitorService = new MonitorService(settings, threadPool, fsServiceProvider);
                indicesService,
                b.bind(IdentityService.class).toInstance(identityService);
    public static final Setting<Boolean> WRITE_PORTS_FILE_SETTING = Setting.boolSetting("node.portsfile", false, Property.NodeScope);
                monitorService.jvmService(),
                clusterService,
        transportService.acceptIncomingRequests();
            final DeploymentManagerService deploymentManagerService = new DeploymentManagerService(clusterService, rerouteService);
                .flatMap(List::stream)
                indicesModule.getMapperRegistry(),
                scriptService,
import org.opensearch.gateway.remote.RemoteClusterStateService;
                        settings,
        );
                Stream.of(
                .map(p -> p.getSecureSettingFactory(settings))
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
            toClose.add(() -> stopWatch.stop().start("plugin(" + plugin.getClass().getName() + ")"));
                    clusterService.getClusterApplierService(),
                    clusterManagerMetrics,
                .collect(Collectors.toSet());
import org.opensearch.action.search.SearchPhaseController;
                nodeEnvironment,
                metricsRegistry,
        toClose.add(nodeService.getSearchBackpressureService());
                transportService,
import org.opensearch.cluster.StreamNodeConnectionsService;
            this.persistentNodeId = persistentNodeId;
                new WorkloadGroupTaskCancellationService(
     */
     * too.
import org.opensearch.action.search.SearchRequestOperationsListener;
import org.opensearch.action.update.UpdateHelper;
            // Discover the native-allocator stats supplier from any plugin that publishes a
            if (Build.CURRENT.isProductionRelease() == false) {
        toClose.add(() -> stopWatch.stop().start("cluster"));
        }
import org.opensearch.core.common.transport.BoundTransportAddress;
            final RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, settingsModule.getClusterSettings());
    /**
            if (nodeCacheService != null) {
    // If not, the hook that is added in Bootstrap#setup() will be useless:
                        tracerFactory = new TracerFactory(telemetrySettings, telemetryModule.getTelemetry(), threadPool.getThreadContext());
            );
            resourcesToClose.add(() -> HeaderWarning.removeThreadContext(threadPool.getThreadContext()));
            final TaskCancellationMonitoringService taskCancellationMonitoringService = new TaskCancellationMonitoringService(
                );
                clusterService = new ClusterService(settings, settingsModule.getClusterSettings(), threadPool, clusterManagerMetrics);
                settings,
                        .toInstance(
import org.opensearch.discovery.LocalDiscovery;
                modules.add(pluginModule);
            // NodeCacheServiceCleaner is only needed on warm nodes (where FileCache and
                actionModule,
            if (DiscoveryNode.isWarmNode(settings)) {
                InetAddress inetAddress = InetAddress.getByName(address.getAddress());
                clusterService,
import org.opensearch.plugins.IngestPlugin;
    /**
            throw new RuntimeException("Failed to rename ports file", e);
            final SettingsModule settingsModule = new SettingsModule(
    private static final Setting<Boolean> NODE_DATA_SETTING = Setting.boolSetting(
                segmentReplicator::getSegmentReplicationStats,
                transportService.getTaskManager(),
            );
     */
                threadPool,
import org.opensearch.plugins.DiscoveryPlugin;
                clusterService.getClusterSettings(),
                boundTransportAddress.publishAddress(),
                    workloadGroupResourceUsageTrackerService,
import org.opensearch.common.lifecycle.Lifecycle;
    static void assertCanWritePluginHealthPaths(List<Path> paths) {
                final NodeMetadata nodeMetadata = NodeMetadata.FORMAT.loadLatestState(
                        new LocalNodeFactory(settings, nodeEnvironment.nodeId()),
import org.opensearch.cluster.ClusterState;
    protected PluginsService getPluginsService() {
                clusterless ? LocalShardStateAction.class : ShardStateAction.class
                clusterService,
import org.opensearch.storage.common.tiering.TieringUtils;
                .filter(c -> c instanceof NativeAllocatorStatsRegistry)
        synchronized (lifecycle) {
import java.util.Map;
            );
                .collect(Collectors.toSet());
                pluginsService.getGuiceServiceClasses().stream().map(injector::getInstance).collect(Collectors.toList())
     */
import javax.net.ssl.SNIHostName;
            final DiscoveryNode discoveryNode = super.apply(boundTransportAddress);
                Task.REQUEST_HEADERS.stream()
        discovery.start(); // start before cluster service so that it can set initial state on ClusterApplierService
            circuitBreakerService,
                .stream()
import org.opensearch.search.aggregations.support.AggregationUsageService;
                tracer,
                clusterModule.getAllocationService(),
            throw new IllegalStateException("Call close() first");
            if (!success) {
    private NodeCacheService nodeCacheService;
            final IdentityService identityService = new IdentityService(settings, threadPool, identityPlugins);
                            searchRequestSlowLog,
    /**
import org.opensearch.gateway.GatewayModule;
            final TaskResourceTrackingService taskResourceTrackingService = new TaskResourceTrackingService(
                nodeEnvironment,
            "discovery.initial_state_timeout",
                        + " and "
        }
            for (Module pluginModule : pluginsService.createGuiceModules()) {
            threadPool,
                b.bind(NodeResourceUsageTracker.class).toInstance(nodeResourceUsageTracker);
        toClose.add(injector.getInstance(ScriptService.class));
            List<ClusterPlugin> clusterPlugins = pluginsService.filterPlugins(ClusterPlugin.class);
            // listen for state changes (this node starts/stops being the elected cluster manager, or new nodes are added)
                .map(c -> (NativeAllocatorStatsRegistry) c)
                settings,
                settingsModule.getClusterSettings()
            // register all standard SearchRequestOperationsCompositeListenerFactory to the SearchRequestOperationsCompositeListenerFactory
    /**
     * Note that this does not control whether the node stores actual indices (see
        toClose.add(injector.getInstance(SegmentReplicationSourceService.class));
                client,
        injector.getInstance(RepositoriesService.class).stop();
            final MetadataMappingService metadataMappingServiceInstance = injector.getInstance(MetadataMappingService.class);
            );
        }
            // Discovered here (ahead of AdmissionControlService) so it can be forwarded to the
            if (DiscoveryNode.isWarmNode(settings) == false) {
            for (Plugin p : pluginsService.filterPlugins(Plugin.class)) {
        return nodeCacheService != null ? nodeCacheService.fileCache() : null;
        clusterService.start();
            final NetworkModule networkModule = new NetworkModule(
    private static long calculateFileCacheSize(String capacityRaw, long totalSpace) {
        injector.getInstance(Discovery.class).stop();
        return this.injector;
 * @opensearch.internal
            );
            );
                .map(IndexStorePlugin::getIndexStoreListener)
                b.bind(BigArrays.class).toInstance(bigArrays);
                recoveryStateFactories,
            final AdmissionControlService admissionControlService = new AdmissionControlService(
            );
    protected ClusterInfoService newClusterInfoService(
     * Creates a new {@link CircuitBreakerService} based on the settings provided.
            for (TransportAddress address : boundAddress.boundAddresses()) {
    private final Lifecycle lifecycle = new Lifecycle();
            NetworkService.CustomNameResolver customNameResolver = discoveryPlugin.getCustomNameResolver(settings());
            TransportNodesSnapshotsStatus nodesSnapshotsStatus = new TransportNodesSnapshotsStatus(
                .collect(Collectors.toList());
import org.opensearch.telemetry.tracing.Tracer;
     *                                   test framework for tests that rely on being able to set private settings
                                telemetryPluginsImplementingTelemetryAware
        }
        if (type.equals("hierarchy")) {
    private final Logger logger = LogManager.getLogger(Node.class);
                );
            );
        // Load (and maybe upgrade) the metadata stored on disk
        toClose.add(() -> stopWatch.stop().start("transport"));
        logger.info("stopping ...");
                indicesService,
import org.opensearch.indices.pollingingest.XContentIngestionPayloadDecoder;
     * has been initialized to include the hostname. If this field were static, then it would be initialized when the
                        settingsModule.getClusterSettings(),
            // register the node.data, node.ingest, node.master, node.remote_cluster_client settings here so we can mark them private
        return service;
                systemIndices,
            ClusterState clusterState = clusterService.state();
                xContentRegistry,
                b.bind(Discovery.class).toInstance(discovery);
                logger.debug("waiting to join the cluster. timeout [{}]", initialStateTimeout);
                b.bind(MetadataUpgrader.class).toInstance(metadataUpgrader);
        List<ConcurrencyLimiterStatsPlugin> providers = pluginsService.filterPlugins(ConcurrencyLimiterStatsPlugin.class);
    protected Transport wrapStreamTransport(@Nullable Transport streamTransport) {
                            .filter(p -> p instanceof SearchRequestOperationsListener)
     */
            TransportService transport = injector.getInstance(TransportService.class);
import org.opensearch.common.StopWatch;
import org.opensearch.monitor.NodeRuntimeMetrics;
import org.opensearch.ratelimitting.admissioncontrol.AdmissionControlService;
            pluginComponentRegistry.register(new FieldFilterProvider(indicesService.getFieldFilter()));
import org.opensearch.snapshots.SnapshotsInfoService;
            // misleading log) and dedupe (avoid probing the same path twice if a plugin happens to
                    logger,
                    .map(DiscoveryNodeRole::roleName)
                b.bind(NodeClient.class).toInstance(client);
        toClose.add(injector.getInstance(GatewayService.class));
            pluginsService.filterPlugins(IngestionConsumerPlugin.class)
            // would NPE inside FsHealthService.monitorFSHealth and mark the node UNHEALTHY with a
import org.opensearch.plugins.ExtensionAwarePlugin;
        toClose.add(injector.getInstance(ClusterService.class));
            directoryFactories.putAll(builtInDirectoryFactories);
import org.opensearch.plugins.PluginInfo;
        }
            final Optional<TaskManagerClient> taskManagerClientOptional = FeatureFlags.isEnabled(BACKGROUND_TASK_EXECUTION_EXPERIMENTAL)
                } else {
                new HashMap<>();
            return discoveryNode;
                nativeAllocatorStatsSupplier
            this.extensionsManager.initializeServicesAndRestHandler(
        if (WRITE_PORTS_FILE_SETTING.get(settings())) {
                clusterModule.getIndexNameExpressionResolver(),
        }
                .filter(Objects::nonNull)
            final SearchTaskRequestOperationsListener searchTaskRequestOperationsListener = new SearchTaskRequestOperationsListener(
            final AutoForceMergeMetrics autoForceMergeMetrics = new AutoForceMergeMetrics(metricsRegistry);
            );
                rerouteServiceReference::get
import java.util.Objects;
import org.opensearch.index.IndexingPressureService;
     * @param forbidPrivateIndexSettings whether or not private index settings are forbidden when creating an index; this is used in the
    /**
                NODE_NAME_SETTING.get(tmpSettings),
                    @Override
                b.bind(RemoteStoreRestoreService.class).toInstance(remoteStoreRestoreService);
                settingsModule,
            if (FeatureFlags.isEnabled(STREAM_TRANSPORT) && streamTransportSupplier == null) {
     * Base factory for creating DiscoveryNode instances during node initialization.
            DynamicActionRegistry dynamicActionRegistry = actionModule.getDynamicActionRegistry();
     */
                    scriptService,
                nativeAllocator.addPoolGroupLimitListener(PoolGroup.INDEXING, newGroupLimit -> {
import java.nio.file.FileSystemException;
                    Stream.concat(
                pluginsService.filterPlugins(SearchPipelinePlugin.class),
                b.bind(NodeEnvironment.class).toInstance(nodeEnvironment);
        }
                        tracer
                : Optional.empty();
                        metricsRegistryFactory = new MetricsRegistryFactory(telemetrySettings, telemetryModule.getTelemetry());
                ? pluginsService.filterPlugins(TaskManagerClientPlugin.class)
    private final AutoForceMergeManager autoForceMergeManager;
            // Wire indexing pool group limit changes to the IndexingMemoryController.
                metadataIndexUpgradeService,
                }, state -> state.nodes().getClusterManagerNodeId() != null, initialStateTimeout);
import org.opensearch.indices.analysis.AnalysisModule;
            final Map<String, IndexStorePlugin.StoreFactory> storeFactories = pluginsService.filterPlugins(IndexStorePlugin.class)
                    persistedStateRegistry,
                responseCollectorService,
                .forEach((k, v) -> {
                    NetworkModule.getNamedXContents().stream(),
            for (final ExecutorBuilder<?> builder : threadPool.builders()) {
                nodeCacheService,
        toClose.add(injector.getInstance(FsHealthService.class));
            );
                .filter(Optional::isPresent)
            injector.getInstance(ThreadPool.class).getThreadContext()
    private static final Setting<Boolean> NODE_INGEST_SETTING = Setting.boolSetting(
import org.opensearch.plugins.MetadataUpgrader;
        toClose.add(() -> stopWatch.stop().start("snapshot_service"));
    }
            if (consistentSettings.isEmpty() == false) {
                cacheService,
        }
        ClusterSettings clusterSettings
    protected void validateNodeBeforeAcceptingRequests(
        toClose.add(() -> stopWatch.stop().start("gateway"));
                b.bind(MetricsRegistry.class).toInstance(metricsRegistry);
                .stream()
                    TieringUtils.TIERED_COMPOSITE_INDEX_TYPE,
import org.opensearch.cluster.metadata.TemplateUpgradeService;
                    }
        return new BigArrays(pageCacheRecycler, circuitBreakerService, CircuitBreaker.REQUEST);
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
            TopNSearchTasksLogger taskConsumer = new TopNSearchTasksLogger(settings, settingsModule.getClusterSettings());
                pluginAdditionalHealthPaths
    /**
import org.opensearch.search.fetch.FetchPhase;
import org.opensearch.indices.cluster.IndicesClusterStateService;
                });
            clusterService.setStreamNodeConnectionsService(streamNodeConnectionsService);
            if (FeatureFlags.isEnabled(TELEMETRY)) {
                b.bind(MetadataDataStreamsService.class).toInstance(metadataDataStreamsService);
        Settings settings,
import org.opensearch.index.IndexSettings;
import org.opensearch.http.HttpServerTransport;
        if (remoteIndexPathUploader != null) {
                    nodeEnvironment.nodeDataPaths()
        toClose.add(injector.getInstance(IndicesClusterStateService.class));
                workloadGroupService
                threadPool
            : "clusterService has a different local node than the factory provided";
     * {@code MockNode}) override to install a stubbable wrapper so
                );
            RepositoriesService repositoryService = repositoriesModule.getRepositoryService();
        return networkModule.getHttpServerTransportSupplier().get();
                b.bind(SegmentReplicationStatsTracker.class).toInstance(segmentReplicationStatsTracker);
                    threadPool,
                } else {
                customNameResolvers.add(customNameResolver);
            modules.add(b -> {
        }
            }
        s -> (DiscoveryNode.isDedicatedWarmNode(s)) ? "80%" : ZERO,
                xContentRegistry,
        injector.getInstance(SnapshotShardsService.class).stop();
                            plugin -> plugin.getSystemIndexDescriptors(settings)
            final PersistentTasksExecutorRegistry registry = new PersistentTasksExecutorRegistry(tasksExecutors);
import org.opensearch.transport.StreamTransportService;
    private final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory;
            resourcesToClose.add(injector.getInstance(PeerRecoverySourceService.class));
        assert clusterService.localNode().equals(localNodeFactory.getNode())
                actionModule.getActionFilters()
                    throw new IllegalArgumentException("invalid node.attr.server_name [" + value + "]", e);
            }
                    )
        injector.getInstance(WorkloadGroupService.class).stop();
import org.opensearch.cluster.NodeConnectionsService;
             * Create the environment based on the finalized view of the settings. This is to ensure that components get the same setting
        );
        nodeService.getSearchBackpressureService().start();
            if (clusterState.nodes().getClusterManagerNodeId() == null) {
import org.opensearch.snapshots.SnapshotsService;
        if (streamTransportService != null) {
                settings,
            final RemoteStorePinnedTimestampService remoteStorePinnedTimestampService;
        Property.NodeScope
                        .toInstance(new SegmentReplicationSourceService(indicesService, transportService, recoverySettings));
import static org.opensearch.common.util.FeatureFlags.BACKGROUND_TASK_EXECUTION_EXPERIMENTAL;
        injector.getInstance(SnapshotsService.class).start();
        toClose.add(nodeService);
                metricsRegistryFactory = new NoopMetricsRegistryFactory();
                nodeEnvironment.nodeId(),
    ) {
    private final NodeService nodeService;
import org.opensearch.plugins.ConcurrencyLimiterStatsPlugin;
import org.apache.logging.log4j.Logger;
                ? Optional.of(
        pluginLifecycleComponents.forEach(LifecycleComponent::stop);
        toClose.add(injector.getInstance(RemoteStorePinnedTimestampService.class));
    }
    protected ScriptService newScriptService(Settings settings, Map<String, ScriptEngine> engines, Map<String, ScriptContext<?>> contexts) {
     * class initializer runs. Alas, this happens too early, before logging is initialized as this class is referred to
            final JvmInfo jvmInfo = JvmInfo.jvmInfo();
                    b.bind(MergedSegmentPublisher.PublishAction.class).to(PublishMergedSegmentAction.class).asEagerSingleton();
            final WorkloadGroupService workloadGroupService = new WorkloadGroupService(
        if (remoteStorePinnedTimestampService != null) {
        injector.getInstance(ResourceWatcherService.class).close();
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
                } else {
        injector.getInstance(ResourceUsageCollectorService.class).stop();
     * to ensure proper resource loading in worker threads.
        "node.master",
import org.opensearch.bootstrap.BootstrapSettings;
            // rejected at creation cannot be introduced later through PUT _mapping.
 * Unless required by applicable law or agreed to in writing,
            remoteClusterStateService.start();
     * regular {@link TransportService} and {@link StreamTransportService}.
     * Mirrors the spirit of {@code NodeEnvironment.assertCanWrite()} but for plugin paths.
                    )
import org.opensearch.wlm.listeners.WorkloadGroupRequestOperationListener;
        // Start the transport service now so the publish address will be added to the local disco node in ClusterService
        if (streamTransportService != null) {
            identityPlugins.addAll(pluginsService.filterPlugins(IdentityPlugin.class));
            localNode.set(discoveryNode);
import org.opensearch.plugins.TaskManagerClientPlugin;
            modules.add(clusterModule);
                networkService,
                    "no-jdk distributions that do not bundle a JDK are deprecated and will be removed in a future release"
        toClose.add(stopWatch::stop);
                } else {
     * This logger instance is an instance field as opposed to a static field. This ensures that the field is not
        toClose.add(() -> stopWatch.stop().start("script"));
            final Map<String, IndexStorePlugin.DirectoryFactory> directoryFactories = new HashMap<>();
import org.opensearch.repositories.RepositoriesModule;
                repositoriesServiceReference::get
            ).collect(Collectors.toSet());
                .register(XContentIngestionPayloadDecoder.NAME, XContentIngestionPayloadDecoder.Factory.INSTANCE);
                discovery = new LocalDiscovery(transportService, clusterService.getClusterApplierService());
    /**
            // full. Reuses the registry discovered above. No-op when no such plugin is loaded.
                    clusterModule.getAllocationService(),
            // plugin modules must be added here, before others or we can get crazy injection errors...
        toClose.add(injector.getInstance(SnapshotsService.class));
                settingsModule.getClusterSettings(),
import org.opensearch.indices.store.IndicesStore;
            final RemoteClusterStateCleanupManager remoteClusterStateCleanupManager;
                    if (telemetrySettings.isMetricsFeatureEnabled()) {
    public synchronized boolean awaitClose(long timeout, TimeUnit timeUnit) throws InterruptedException {
import org.opensearch.cluster.node.DiscoveryNodeRole;
        nodeService.getTaskCancellationMonitoringService().start();
        injector.getInstance(IndicesService.class).stop();
     */
import org.opensearch.common.inject.Key;
                assert false : e;
                taskCancellationMonitoringSettings,
            modules.add(settingsModule);
        return this.environment.settings();
                engineFactoryProviders,
                b.bind(AdmissionControlService.class).toInstance(admissionControlService);
                persistentNodeId
            );
     */
    private static class LocalNodeFactory implements Function<BoundTransportAddress, DiscoveryNode> {
            additionalSettings.addAll(pluginsService.getPluginSettings());
                    workloadGroupsStateAccessor
import org.opensearch.cluster.ClusterStateObserver;
                    "Plugin-supplied health path [" + path + "] is not writable (permission denied): " + e.getMessage(),
import org.opensearch.indices.replication.SegmentReplicator;
                threadPool,
                final CountDownLatch latch = new CountDownLatch(1);
    private final Injector injector;
        toClose.add(() -> stopWatch.stop().start("discovery"));
        );
                clusterService,
        CircuitBreakerService circuitBreakerService,
        // close filter/fielddata caches after indices
                threadPool.getThreadContext(),
        toClose.add(() -> stopWatch.stop().start("indices_cluster"));
                "version[{}], pid[{}], build[{}/{}/{}], OS[{}/{}/{}], JVM[{}/{}/{}/{}]",
        // awaitClose if the node doesn't finish closing within the specified time.
            final DefaultPluginComponentRegistry pluginComponentRegistry = new DefaultPluginComponentRegistry();
     * @param context               the bootstrap context for this node
    private final NodeEnvironment nodeEnvironment;
                    clusterModule.getIndexNameExpressionResolver(),
            final SetOnce<RepositoriesService> repositoriesServiceReference = new SetOnce<>();
        toClose.add(() -> stopWatch.stop().start("fsHealth"));
import org.opensearch.plugins.TelemetryAwarePlugin;
        toClose.add(() -> stopWatch.stop().start("node_connections_service"));
        StreamTransportService stc = injector.getInstance(StreamTransportService.class);
 *
                    clusterService
        DiscoveryNode getNode() {
import org.opensearch.core.indices.breaker.CircuitBreakerService;
import org.opensearch.plugins.CachePlugin;
            this.environment = new Environment(settings, initialEnvironment.configDir(), Node.NODE_LOCAL_STORAGE_SETTING.get(settings));
            }
            if (!lifecycle.moveToClosed()) {
import org.opensearch.discovery.Discovery;
        toClose.add(injector.getInstance(IndicesService.class));
                } catch (IllegalArgumentException e) {
                autoForceMergeMetrics
    public boolean isClosed() {
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.unit.RatioValue;
import org.opensearch.search.pipeline.SearchPipelineService;
    // close() might not be executed, in case another (for example api) call to close() has already set some lifecycles to stopped.
                        threadPool,
                        throw new IllegalStateException("registered index store type [" + k + "] conflicts with a built-in type");
        logger.info("closing ...");
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                }
import java.util.List;
                    nodeEnvironment,
                        clusterService,
import org.opensearch.cluster.metadata.MetadataMappingService;
                threadPool,
import org.opensearch.indices.pollingingest.IngestionPayloadDecoderRegistry;
import org.opensearch.indices.breaker.BreakerSettings;
import org.opensearch.wlm.cancellation.MaximumResourceTaskSelectionStrategy;
import org.opensearch.Build;
            : "transportService has a different local node than the factory provided";
                                transportService,
                .map(
import org.opensearch.threadpool.RunnableTaskExecutionListener;
                settings,
                ).flatMap(Function.identity()).collect(toList())
            throw new OpenSearchException("failed to bind service", ex);
        injector.getInstance(HttpServerTransport.class).start();
            injector.getInstance(RemoteStoreRestoreService.class)
        return this;
import org.opensearch.OpenSearchParseException;
            logger.info(
            SnapshotShardsService snapshotShardsService = new SnapshotShardsService(
            final InternalSnapshotsInfoService snapshotsInfoService = new InternalSnapshotsInfoService(
                .flatMap(m -> m.entrySet().stream())
                throw new IllegalStateException(
        List<Plugin> pluginsToClose = new ArrayList<>(pluginsService.filterPlugins(Plugin.class));
import org.opensearch.common.inject.ModulesBuilder;
            HttpServerTransport http = injector.getInstance(HttpServerTransport.class);
            final PersistedClusterStateService lucenePersistedStateFactory = new PersistedClusterStateService(
                .map(plugin -> (Function<IndexSettings, Optional<EngineFactory>>) plugin::getEngineFactory)
            try {
        Path tmpPortsFile = environment.logsDir().resolve(type + ".ports.tmp");
            Stream<IndexStoreListener> indexStoreListenerStream = pluginsService.filterPlugins(IndexStorePlugin.class)
    public static class CustomForkJoinWorkerThread extends ForkJoinWorkerThread {
                    }
        // stop any changes happening as a result of cluster state changes
import java.nio.file.AccessDeniedException;
                .put(initialEnvironment.settings())
            }
                );
                remoteDirectoryFactory,
        assert onDiskMetadata != null : "metadata is null but shouldn't"; // this is never null
import org.opensearch.core.common.unit.ByteSizeValue;
            final SegmentReplicator segmentReplicator = new SegmentReplicator(threadPool);
        transportService.getTaskManager().setTaskResultsService(injector.getInstance(TaskResultsService.class));
public class Node implements Closeable {
    ) {
import org.opensearch.persistent.PersistentTasksExecutor;
        clusterService.setNodeConnectionsService(nodeConnectionsService);
                "node name [{}], node ID [{}], cluster name [{}], roles {}",
                    }
    }
import org.opensearch.plugins.MapperPlugin;
     * The settings that are used by this node. Contains original settings as well as additional settings provided by plugins.
                b.bind(PersistentTasksService.class).toInstance(persistentTasksService);
    );
        }
                        nodeEnvironment,
     * Returns the {@link NodeEnvironment} instance of this node
            new TemplateUpgradeService(client, clusterService, threadPool, indexTemplateMetadataUpgraders);
            Collection<UnaryOperator<Map<String, IndexTemplateMetadata>>> indexTemplateMetadataUpgraders = pluginsService.filterPlugins(
            );
            }
            if (logger.isDebugEnabled()) {
                    rerouteService,
     */
            final List<Setting<?>> additionalSettings = new ArrayList<>();
                    repositoriesServiceReference::get,
        injector.getInstance(IndicesClusterStateService.class).start();
import org.opensearch.common.network.NetworkModule;
                remoteStorePinnedTimestampService = new RemoteStorePinnedTimestampService(
import java.util.Set;
                    clusterService.getClusterSettings(),
        Executor indexSearcherExecutor,
        injector.getInstance(MappingUpdatedAction.class).setClient(client);
import org.opensearch.index.IngestionConsumerFactory;
                remoteStoreNodeService.createAndVerifyRepositories(discoveryNode);
                indicesService,
                }
                b.bind(RemoteIndexPathUploader.class).toProvider(() -> remoteIndexPathUploader);
        "node.local_storage",
                threadPool::relativeTimeInMillis,
            RepositoriesModule repositoriesModule = new RepositoriesModule(
            transport,
            );
                clusterService.getClusterSettings()
     */
                dataFormatRegistry
                .flatMap(
                final TelemetrySettings telemetrySettings = new TelemetrySettings(settings, settingsModule.getClusterSettings());
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    b.bind(StreamTransportService.class).toInstance(streamTransportService.get());
     * Default returns its input unchanged. Test-framework subclasses (e.g.
                pluginCircuitBreakers,
import org.opensearch.index.recovery.RemoteStoreRestoreService;
            );
            return localNode.get();
        Property.NodeScope
            final StreamNodeConnectionsService streamNodeConnectionsService = injector.getInstance(StreamNodeConnectionsService.class);
        }
            }
        logger.info("starting ...");
                .distinct()
        }, Property.NodeScope)
                xContentRegistry,
    }
                .stream()
        Releasables.close(injector.getInstance(Client.class));
            }
            clusterModule.setRerouteServiceForAllocator(rerouteService);
                namedWriteableRegistry,
            // Going forward, IndexingPressureService will have required constructs for exposing listeners/interfaces for plugin
                settings,
import org.opensearch.tasks.TaskCancellationService;
                storeFactories,
        nodeService.getSearchBackpressureService().stop();
import org.opensearch.plugins.CircuitBreakerPlugin;
     * The discovery settings for the node.
                clusterPlugins,
                .collect(toList());
        ThreadPool threadPool = injector.getInstance(ThreadPool.class);
            final Optional<NativeAllocatorStatsRegistry> nativeAllocatorStatsRegistry = pluginComponents.stream()
                segmentReplicationStatsTracker,
                        .toInstance(new PeerRecoverySourceService(transportService, indicesService, recoverySettings));
            responseCollectorService,
                throw ex;
                }
                ingestionConsumerFactories,
                .findFirst()
                    metricsRegistryFactory = new NoopMetricsRegistryFactory();
                clusterModule.getIndexNameExpressionResolver(),
    }
                searchModule.getNamedWriteables().stream(),
    ) throws NodeValidationException {}
                    new SNIHostName(value);
                xContentRegistry,
import org.opensearch.index.analysis.AnalysisRegistry;
                );
                    b.bind(FileCache.class).toInstance(fileCache);
import org.opensearch.plugins.RepositoryPlugin;
import org.opensearch.bootstrap.BootstrapContext;
        }
        boolean success = false;
import org.opensearch.gateway.GatewayMetaState;
                client,
            }
            Settings settings,
                    e
            }
                            .map(p -> (SearchRequestOperationsListener) p)
        RemoteClusterService.ENABLE_REMOTE_CLUSTERS,
                analysisModule.getAnalysisRegistry(),
            );
            } else {
                        .collect(toList());
            injector.getInstance(MetadataUpgrader.class),
                clusterService,
            if (clusterless) {
                try {
import org.opensearch.env.Environment;
            return new NoneCircuitBreakerService();
        validateNodeBeforeAcceptingRequests(
import org.opensearch.indices.replication.checkpoint.PublishMergedSegmentAction;
                stop();
                        transportService.getTaskManager(),
                initialEnvironment.configDir(),
 */
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
import org.opensearch.arrow.spi.NativeAllocator;
                b.bind(ThreadPool.class).toInstance(threadPool);
        toClose.add(injector.getInstance(SearchService.class));
                transportService.getTaskManager(),
                remoteStoreSettings,
                    additionalSettings.addAll(extAwarePlugin.getExtensionSettings());
        }
                    public void onNewClusterState(ClusterState state) {
                );
                remoteClusterStateService
                            workloadGroupRequestOperationListener
                    b.bind(StreamSearchTransportService.class).toInstance(streamSearchTransportService.get());
                tracer
import org.opensearch.plugins.TelemetryPlugin;
                    indicesService.setNativeIndexBufferBytes((long) (newGroupLimit * 0.70));
     */
                taskResourceTrackingService
     * Hook to wrap the stream transport before it is shared between the
                IOUtils.closeWhileHandlingException(resourcesToClose);
            final ClusterManagerMetrics clusterManagerMetrics = new ClusterManagerMetrics(metricsRegistry);
                threadPool,
        @Override
                xContentRegistry,
import org.opensearch.core.common.breaker.CircuitBreaker;
                b.bind(GatewayMetaState.class).toInstance(gatewayMetaState);
                threadPool,
    public Settings settings() {
            );
            transportService.getTaskManager().registerTaskResourceConsumer(taskConsumer);
                FileCache fileCache = fileCache();
                threadPool::relativeTimeInMillis
import org.opensearch.task.commons.clients.TaskManagerClient;
                b.bind(ResourceUsageCollectorService.class).toInstance(resourceUsageCollectorService);
                b.bind(PageCacheRecycler.class).toInstance(pageCacheRecycler);
        final boolean terminated = ThreadPool.terminate(threadPool, timeout, timeUnit);
                b.bind(DeploymentManagerService.class).toInstance(deploymentManagerService);
        return capacityRaw;
    }
        transportService.getTaskManager().setTaskResourceTrackingService(taskResourceTrackingService);
            );
                }
            if (jvmInfo.getBundledJdk()) {
     */
                clusterModule.getAllocationService(),
    PageCacheRecycler createPageCacheRecycler(Settings settings) {
            pluginsService.filterPlugins(IngestionConsumerPlugin.class)
import org.opensearch.core.common.transport.TransportAddress;
                resourcesToClose.add(remoteStorePinnedTimestampService);
                transportService,
import org.opensearch.indices.replication.checkpoint.RemoteStorePublishMergedSegmentAction;
                b.bind(SearchRequestStats.class).toInstance(searchRequestStats);
            );
                    }
            }
            // development. Then we can deprecate Getter and Setter for IndexingPressureService in ClusterService (#478).
                monitorService,
import org.opensearch.env.NodeMetadata;
            if (lifecycle.started()) {
import org.opensearch.cluster.coordination.PersistedStateRegistry;
                b.bind(UsageService.class).toInstance(usageService);
        // start after transport service so the local disco is known
        if (streamTransportService != null) {
            if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)) {
    }
                tieredStoragePrefetchSettings = null;
                    }
     * Returns the {@link FileCache} instance for remote warm nodes, or {@code null} on non-warm nodes.
import org.opensearch.transport.TransportService;
    /** Constructs a ClusterInfoService which may be mocked for tests. */
            this.namedWriteableRegistry = namedWriteableRegistry;
            final Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier;
            }
                () -> clusterService.localNode().getId(),
            injector.getInstance(MetadataIndexUpgradeService.class),
                threadPool,
        toClose.add(() -> stopWatch.stop().start("gateway_meta_state"));
                taskCancellationMonitoringService,
import org.opensearch.ingest.SystemIngestPipelineCache;
            final MetadataCreateIndexService metadataCreateIndexService = new MetadataCreateIndexService(
                );
import java.util.LinkedHashSet;
            try {
                threadPool,
            CryptoHandlerRegistry.initRegistry(
                    namedWriteableRegistry,
                tmpSettings,
    }, Setting.Property.NodeScope);
     * @param classpathPlugins           the plugins to be loaded from the classpath
import org.opensearch.common.network.NetworkService;
                .flatMap(m -> m.entrySet().stream())
                .stream()
        IOUtils.close(toClose);
        final RemoteIndexPathUploader remoteIndexPathUploader = injector.getInstance(RemoteIndexPathUploader.class);
                    nodeEnvironment.nodeId(),
     * Constructs a node
     */
            // Defensive: filter out nulls (a misbehaving plugin returning a list containing null
            // native-memory admission controller for indexing-pool based rejection.
import org.opensearch.cluster.metadata.MetadataCreateDataStreamService;
import org.opensearch.common.settings.Setting;
    @SuppressWarnings("unused")
                ).getDiscovery();
        toClose.add(injector.getInstance(RepositoriesService.class));
                new FileCacheSettings(settings, clusterService.getClusterSettings())::getRemoteDataRatio
            } else {
            );
        List<SearchPlugin.ProfileMetricsProvider> pluginProfilers,
import org.opensearch.gateway.GatewayService;
                deprecationLogger.deprecate(
                    environment.configDir(),
                // Enabling shard indexing backpressure node-attribute
                    "no-jdk",
            } catch (OpenSearchParseException ex) {
                xContentRegistry,
    private static final String ZERO = "0";
                    b.bind(PeerRecoveryTargetService.class)
    protected void configureNodeAndClusterIdStateListener(ClusterService clusterService) {
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
                Constants.JVM_NAME,
            );
        FetchPhase fetchPhase,
            // Inject the node-level native memory pressure signal (same signal admission control uses)
        Property.Deprecated,
            clusterService,
import org.opensearch.telemetry.metrics.MetricsRegistryFactory;
                streamTransport,
        }
                .forEach((k, v) -> {
                awarenessReplicaBalance,
                if (telemetrySettings.isTracingFeatureEnabled() || telemetrySettings.isMetricsFeatureEnabled()) {
            final MetadataIndexUpgradeService metadataIndexUpgradeService = new MetadataIndexUpgradeService(
            tracer
                settings,
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
import java.util.Locale;
            queryPhase,
                clusterInfoService::getClusterInfo,
                nodeEnvironment = new NodeEnvironment(
    private final LocalNodeFactory localNodeFactory;
            // Register default factory
                clusterService,
        injector.getInstance(HttpServerTransport.class).stop();
        }
                b.bind(RemoteClusterStateService.class).toProvider(() -> remoteClusterStateService);
        if (!lifecycle.moveToStarted()) {
                admissionControlService,
                settingsModule.getSettings(),
                                clusterService,
            RemoteStoreNodeService remoteStoreNodeService
                metadataCreateIndexService
                Build.CURRENT.type().displayName(),
                settingsModule.getClusterSettings(),
                shardLimitValidator,
import org.opensearch.index.store.remote.filecache.FileCache;
            mergedSegmentWarmerFactory = new MergedSegmentWarmerFactory(transportService, recoverySettings, clusterService);
        // See https://issues.apache.org/jira/browse/LUCENE-7248. We call shutdownNow in
import java.util.stream.Collectors;
     *
                    } else {
        List<BreakerSettings> breakerSettings,
            );
    public synchronized void close() throws IOException {
            final SetOnce<RerouteService> rerouteServiceReference = new SetOnce<>();
        ThreadPool threadPool,
                logger.debug(
            final Map<String, Collection<SystemIndexDescriptor>> systemIndexDescriptorMap = Collections.unmodifiableMap(
 * not use this file except in compliance with the License.
            List<LifecycleComponent> pluginLifecycleComponents = pluginComponents.stream()
                snapshotsInfoService,
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
                    .stream()
            stc.stop();
                responseCollectorService,
                    TieredDataFormatAwareStoreDirectoryFactory.FACTORY_KEY,
        }
import org.opensearch.wlm.tracker.WorkloadGroupResourceUsageTrackerService;
                    )
        @Override
                )
                    b.bind(StreamTransportService.class).toProvider((Providers.of(null)));
                monitorService,
        injector.getInstance(RepositoriesService.class).start();
    protected TransportService newTransportService(
            final Set<Setting<?>> consistentSettings = settingsModule.getConsistentSettings();
                    }
            toClose.add(() -> logger.trace("Close times for each service:\n{}", stopWatch.prettyPrint()));
    }
            RestoreService restoreService = new RestoreService(
    public FileCache fileCache() {
            return new HierarchyCircuitBreakerService(settings, breakerSettings, clusterSettings);
                indicesModule.getNamedWriteables().stream(),
            // NativeAllocatorStatsRegistry component (today: ArrowBasePlugin). Lookup mirrors
            );
import java.util.concurrent.ForkJoinWorkerThread;
                );
import org.opensearch.action.search.SearchRequestOperationsCompositeListenerFactory;
import java.net.InetSocketAddress;
            runnableTaskListener = new AtomicReference<>();
        return this;
        if (Assertions.ENABLED) {
        ClusterSettings clusterSettings,
import org.opensearch.indices.replication.SegmentReplicationSourceService;
                // the OS-level error string (e.g. "No space left on device").
     *
                }
        return provider::getConcurrencyLimiterStats;
                settingsModule.getIndexScopedSettings(),
        true,
    public static final Setting<String> NODE_SEARCH_CACHE_SIZE_SETTING = new Setting<>(
                threadPool,
        runnableTaskListener.set(taskResourceTrackingService);
                analysisModule.getAnalysisRegistry(),
                nodeEnvironment,
        List<Closeable> toClose = new ArrayList<>();
        toClose.add(() -> stopWatch.stop().start("http"));
        toClose.add(() -> stopWatch.stop().start("monitor"));
        toClose.add(injector.getInstance(SnapshotShardsService.class));
import java.util.ArrayList;
import org.opensearch.action.search.SearchRequestStats;
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
            return () -> null;
            }
        clusterService.addStateApplier(transportService.getTaskManager());
            logger.debug("initializing HTTP handlers ...");
        try {
                bigArrays,
        } catch (IOException ex) {
                        )
                b.bind(SearchRequestSlowLog.class).toInstance(searchRequestSlowLog);
                b.bind(MetadataCreateIndexService.class).toInstance(metadataCreateIndexService);
                );
            AnalysisModule analysisModule = new AnalysisModule(this.environment, pluginsService.filterPlugins(AnalysisPlugin.class));
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
                Constants.OS_NAME,
            final Collection<Function<IndexSettings, Optional<EngineFactory>>> engineFactoryProviders = enginePlugins.stream()
            localNodeFactory,
                                indicesService,
                identityService,
/**
                .build();
                extensionsManager
        Property.NodeScope
                client,
import org.opensearch.transport.RemoteClusterService;
                injector.getInstance(GatewayAllocator.class),
                new WorkloadGroupResourceUsageTrackerService(taskResourceTrackingService);
                circuitBreakerService,
import org.opensearch.indices.ShardLimitValidator;
             * values, no matter they ask for them from.
        toClose.add(injector.getInstance(GatewayMetaState.class));
            }
            final HttpServerTransport httpServerTransport = newHttpTransport(networkModule);
import java.net.InetAddress;
            // completes we trigger another reroute to try the allocation again. This means there is a circular dependency: the allocation
            pluginsService.filterPlugins(Plugin.class)
                snapshotShardsService,
import org.opensearch.transport.client.Client;
                resourceUsageCollectorService,
                b.bind(AliasValidator.class).toInstance(aliasValidator);
import org.opensearch.indices.IndicesModule;
import org.opensearch.cluster.deployment.DeploymentStateService;
                    // do not allow any plugin-provided index store type to conflict with a built-in type
import org.opensearch.index.autoforcemerge.AutoForceMergeManager;
            final NodeResourceUsageTracker nodeResourceUsageTracker = new NodeResourceUsageTracker(
                b.bind(ScriptService.class).toInstance(scriptService);
                payloadDecoderRegistry,
            resourcesToClose.add(payloadDecoderRegistry);
                plugin.setCircuitBreaker(breaker);
            taskResourceTrackingService.addTaskCompletionListener(workloadGroupService);
            workloadGroupService
                .forEach(plugin -> ingestionConsumerFactories.putAll(plugin.getIngestionConsumerFactories()));
            try {
                b.bind(RemoteStoreStatsTrackerFactory.class).toInstance(remoteStoreStatsTrackerFactory);
                return;
            ).stream().map(Plugin::getIndexTemplateMetadataUpgrader).collect(Collectors.toList());
    private static String validateFileCacheSize(String capacityRaw) {
                b.bind(CircuitBreakerService.class).toInstance(circuitBreakerService);
                identityService
            if (DiscoveryNode.isClusterManagerNode(settings)) {
        "node.ingest",
                            )
            }
        public DiscoveryNode apply(BoundTransportAddress boundTransportAddress) {
        injector.getInstance(IndicesService.class).start();
                    settings,
                        client,
                    b.bind(BlockCacheRegistry.class).toInstance(nodeCacheService);
        for (LifecycleComponent plugin : pluginLifecycleComponents) {
import org.opensearch.common.inject.Module;
                        client,
    private final Collection<LifecycleComponent> pluginLifecycleComponents;
                b.bind(RestoreService.class).toInstance(restoreService);
            );
                settings,
 * GitHub history for details.
                settingsModule.getIndexScopedSettings(),
import org.opensearch.wlm.cancellation.WorkloadGroupTaskCancellationService;
        ConcurrencyLimiterStatsPlugin provider = providers.getFirst();
                }
        );
            dynamicActionRegistry.registerUnmodifiableActionMap(injector.getInstance(new Key<Map<ActionType, TransportAction>>() {
        assert transportService.getLocalNode().equals(localNodeFactory.getNode())
