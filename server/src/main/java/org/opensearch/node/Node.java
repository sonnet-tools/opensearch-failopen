                SearchBackEndPlugin.class  
                    ).stream()
            streamNodeConnectionsService.start();
            // this is as early as we can validate settings at this point. we already pass them to ScriptModule as well as ThreadPool
        } else {
            // register all standard SearchRequestOperationsCompositeListenerFactory to the SearchRequestOperationsCompositeListenerFactory
            final Optional<TaskManagerClient> taskManagerClientOptional = FeatureFlags.isEnabled(BACKGROUND_TASK_EXECUTION_EXPERIMENTAL)
            logger.info("JVM arguments {}", Arrays.toString(jvmInfo.getInputArguments()));
            );
import java.net.InetAddress;
                modules.add(pluginModule);
            }
        List<Closeable> toClose = new ArrayList<>();  
        private final SetOnce<DiscoveryNode> localNode = new SetOnce<>();
                scriptService,  
import org.opensearch.tasks.TaskCancellationMonitoringService;  
        injector.getInstance(GatewayService.class).start();  
    public Environment getEnvironment() {
    }
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;  
        ClusterSettings clusterSettings,
                clusterService.getClusterSettings()
        ThreadPool threadPool,
     * in InternalSettingsPreparer#finalizeSettings, which runs when creating the Environment, before logging is
            if (searchStatsContributors.isEmpty() == false) {
                b.bind(RemoteStoreRestoreService.class).toInstance(remoteStoreRestoreService);
            // would NPE inside FsHealthService.monitorFSHealth and mark the node UNHEALTHY with a
            final Collection<Function<IndexSettings, Optional<EngineFactory>>> engineFactoryProviders = enginePlugins.stream()  
            // listen for state changes (this node starts/stops being the elected cluster manager, or new nodes are added)  
                b.bind(Node.class).toInstance(this);  
            });
            pluginsService.filterPlugins(Plugin.class).stream().flatMap(p -> p.getBootstrapChecks().stream()).collect(Collectors.toList())
        // Load (and maybe upgrade) the metadata stored on disk
        }
            case "none":
        if (remoteClusterStateService != null) {
                        threadPool,
import org.opensearch.plugins.ConcurrencyLimiterStatsPlugin;
        injector.getInstance(ResourceWatcherService.class).close();  
                threadPool,  
                        settings,  
                    "Some shards are still open after the threadpool terminated. "  
                    b.bind(PeerRecoveryTargetService.class)
     */
                getCustomNameResolvers(pluginsService.filterPlugins(DiscoveryPlugin.class))
                    clusterService,
            );  
                DiscoveryNode.getRolesFromSettings(settings)
                    b.bind(SegmentReplicationSourceService.class)
import org.opensearch.snapshots.SnapshotsService;
                .put(NODE_ATTRIBUTES.getKey() + SHARD_INDEXING_PRESSURE_ENABLED_ATTRIBUTE_KEY, "true")  
                    List<TelemetryPlugin> telemetryPluginsImplementingTelemetryAware = telemetryPlugins.stream()
            );
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
import org.opensearch.common.util.FeatureFlags;
import org.opensearch.common.lease.Releasables;
            clusterService.setIndexingPressureService(indexingPressureService);  
        toClose.add(injector.getInstance(RepositoriesService.class));  
                b.bind(MetadataCreateDataStreamService.class).toInstance(metadataCreateDataStreamService);
import org.opensearch.search.query.QueryPhase;  
     */
                b.bind(SnapshotsInfoService.class).toInstance(snapshotsInfoService);  
        }  
     * @param forbidPrivateIndexSettings whether or not private index settings are forbidden when creating an index; this is used in the
    /**
import org.opensearch.indices.replication.checkpoint.PublishMergedSegmentAction;  
import org.opensearch.persistent.PersistentTasksExecutor;
                        + "Something is leaking index readers or store references."
                bigArrays,  
                b.bind(SearchService.class).toInstance(searchService);
public class Node implements Closeable {
     * This logger instance is an instance field as opposed to a static field. This ensures that the field is not  
import java.nio.charset.StandardCharsets;
    );  
                    b.bind(TierActionMetrics.class).toInstance(new TierActionMetrics(metricsRegistry));
                );  
        if (terminated) {
    /**
import org.opensearch.telemetry.tracing.Tracer;  
                } else {  
            // Collect providers into a map keyed by cache name for O(1) lookup  
        if (DiscoveryNode.isClusterManagerNode(settings)) {
                clusterService.getClusterSettings()  
import org.opensearch.tasks.Task;
        ResponseCollectorService responseCollectorService,  
                for (ExtensionAwarePlugin extAwarePlugin : extensionAwarePlugins) {  
            this.remoteStoreNodeService = remoteStoreNodeService;
        }
 * A node represent a node within a cluster ({@code cluster.name}). The {@link #client()} can be used  
                settingsModule.getSettings(),  
            if (nodeCacheService != null) {
            );
                    }
                monitorService,  
import org.apache.lucene.util.Constants;  
    }
                searchBackpressureService,  
                b.bind(MetadataDataStreamsService.class).toInstance(metadataDataStreamsService);  
            } else {  
        ) {
    public Settings settings() {  
import org.opensearch.repositories.RepositoriesModule;  
     * controls whether the node is allowed to persist things like metadata to disk  
        return customNameResolvers;  
    public synchronized void close() throws IOException {
        // close discovery early to not react to pings anymore.
     * Extended factory that verifies remote store repositories during node creation.
            final RerouteService rerouteService = new BatchedRerouteService(clusterService, clusterModule.getAllocationService()::reroute);  
                .findFirst();  
            } else {
    private List<NetworkService.CustomNameResolver> getCustomNameResolvers(List<DiscoveryPlugin> discoveryPlugins) {
            ingestServiceReference.set(ingestService);
import org.opensearch.extensions.NoopExtensionsManager;
     * @param initialEnvironment         the initial environment for this node, which will be added to by plugins
        this(environment, Collections.emptyList(), true);
                b.bind(AliasValidator.class).toInstance(aliasValidator);
import org.opensearch.action.search.SearchExecutionStatsCollector;
            );
                b.bind(NamedWriteableRegistry.class).toInstance(namedWriteableRegistry);  
                assert nodeMetadata.nodeVersion().equals(Version.CURRENT);
                        clusterModule.getIndexNameExpressionResolver()
                }
            if (nodeService.awaitClose(0, TimeUnit.MILLISECONDS) == false) {
        return pluginsService;
import org.opensearch.storage.tiering.HotToWarmTieringService;
import java.util.HashMap;
                .map(SearchBackEndPlugin::getAnalyticsBackendNativeMemoryStats)
            final ClusterInfoService clusterInfoService = newClusterInfoService(settings, clusterService, threadPool, client);
            if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)) {
                );  
    protected void configureNodeAndClusterIdStateListener(ClusterService clusterService) {
                .collect(Collectors.toSet());  
import org.opensearch.env.NodeMetadata;
            // IMC's native buffer is updated to 70% of the new grouped limit.
            writePortsFile("transport", transport.boundAddress());
                threadPool,
                                new SegmentReplicationSourceFactory(transportService, recoverySettings, clusterService),
            logger.debug("initializing HTTP handlers ...");
            if (FeatureFlags.isEnabled(FeatureFlags.EXTENSIONS)) {  
                clusterModule.getAllocationService(),  
                threadPool::relativeTimeInMillis
                initialEnvironment.modulesDir(),
                if (fileCache != null) {
    public synchronized boolean awaitClose(long timeout, TimeUnit timeUnit) throws InterruptedException {
            final NodeRuntimeMetrics nodeRuntimeMetrics = new NodeRuntimeMetrics(
        return networkModule.getHttpServerTransportSupplier().get();
                .map(p -> p.getSecureSettingFactory(settings))
                xContentRegistry,
                    b.bind(MergedSegmentPublisher.PublishAction.class).to(PublishMergedSegmentAction.class).asEagerSingleton();
    /**
            this.autoForceMergeManager = new AutoForceMergeManager(  
            } catch (IOException e) {  
                indicesService,
        return lifecycle.closed();  
    }
        toClose.add(() -> stopWatch.stop().start("snapshot_service"));  
                b.bind(RerouteService.class).toInstance(rerouteService);  
import org.opensearch.plugins.CryptoPlugin;  
            // NativeAllocatorStatsRegistry component (today: ArrowBasePlugin). Lookup mirrors
                b.bind(NodeEnvironment.class).toInstance(nodeEnvironment);  
import org.opensearch.arrow.spi.NativeAllocator;
                    if (telemetrySettings.isTracingFeatureEnabled()) {  
     * This method can be overwritten by subclasses to change their {@link BigArrays} implementation for instance for testing
                settings,
        return new TransportService(
                this.nodeCacheService = NodeCacheService.create(settings, nodeEnvironment, blockCacheProviders);
        Property.NodeScope
            final Collection<SecureSettingsFactory> secureSettingsFactories = pluginsService.filterPlugins(Plugin.class)
            AdmissionControlTransportInterceptor admissionControlTransportInterceptor = new AdmissionControlTransportInterceptor(
import org.opensearch.plugins.BlockCacheRegistry;  
        toClose.addAll(pluginsToClose);  
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.common.network.NetworkModule;
    }, Setting.Property.NodeScope);
        StreamTransportService stc = injector.getInstance(StreamTransportService.class);  
                    List.of(remoteIndexPathUploader),
                Constants.JVM_VENDOR,
import java.util.stream.Collectors;
import org.opensearch.cluster.service.LocalClusterService;
            final SearchRequestStats searchRequestStats = new SearchRequestStats(clusterService.getClusterSettings());
     * initialized.
        injector.getInstance(IndicesClusterStateService.class).stop();
        ClusterService clusterService,  
                // Enabling shard indexing backpressure node-attribute
    protected List<AuxTransport> newAuxTransports(NetworkModule networkModule) {
            } catch (NoSuchFileException e) {
            final SearchPipelineService searchPipelineService = new SearchPipelineService(
                metricsRegistry,  
                    pluginsService.filterPlugins(DiscoveryPlugin.class),
import org.opensearch.action.ActionType;  
    }  
                plugin.setCircuitBreaker(breaker);  
            final WorkloadGroupResourceUsageTrackerService workloadGroupResourceUsageTrackerService =  
            for (TransportAddress address : boundAddress.boundAddresses()) {
            }));
                .map(p -> (LifecycleComponent) p)  
                            .map(p -> (SearchRequestOperationsListener) p)
import org.opensearch.common.logging.HeaderWarning;
        // their dependencies (e.g. child allocators close before the root allocator owner).  
                threadPool,  
                b.bind(MetadataCreateIndexService.class).toInstance(metadataCreateIndexService);  
                    .findFirst()  
import org.opensearch.monitor.fs.FsHealthService;
            );  
import org.opensearch.plugins.SearchBackEndPlugin;
                    compositeDirectoryFactories.put(k, v);  
import org.opensearch.gateway.MetaStateService;  
            if (nativeAllocator != null) {
                    nodeEnvironment.nodeDataPaths()
     * Returns the environment of the node  
    ) throws NodeValidationException {}
            this.pluginLifecycleComponents = Collections.unmodifiableList(pluginLifecycleComponents);
        }  
        TransportInterceptor interceptor,
        }  
        final TimeValue initialStateTimeout = DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING.get(settings());  
import org.opensearch.cluster.ClusterStateObserver;
            final Optional<NativeAllocatorStatsRegistry> nativeAllocatorStatsRegistry = pluginComponents.stream()  
     */  
                ).getDiscovery();  
            CryptoHandlerRegistry.initRegistry(  
import org.opensearch.plugins.SearchPlugin;  
import org.opensearch.storage.directory.TieredDataFormatAwareStoreDirectoryFactory;
            final Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier;  
        transportService.getTaskManager().setTaskResultsService(injector.getInstance(TaskResultsService.class));
        toClose.add(injector.getInstance(SnapshotsService.class));
                analysisModule.getAnalysisRegistry(),
                clusterService = new ClusterService(settings, settingsModule.getClusterSettings(), threadPool, clusterManagerMetrics);
import org.opensearch.index.autoforcemerge.AutoForceMergeMetrics;
                b.bind(ResourceUsageCollectorService.class).toInstance(resourceUsageCollectorService);
import org.opensearch.snapshots.SnapshotShardsService;  
                            "registered composite index store type [" + k + "] conflicts with a built-in default type"  
                stc -> new StreamSearchTransportService(stc, SearchExecutionStatsCollector.makeWrapper(responseCollectorService))  
import org.opensearch.repositories.RepositoriesService;
                nodeEnvironment,
        ThreadPool threadPool,
                    .collect(
import org.opensearch.persistent.PersistentTasksClusterService;  
            PageCacheRecycler pageCacheRecycler = createPageCacheRecycler(settings);
import org.opensearch.env.Environment;  
        toClose.add(injector.getInstance(NodeConnectionsService.class));  
                .collect(Collectors.toList());  
                org.opensearch.plugins.BlockCacheProvider.class  
            // development. Then we can deprecate Getter and Setter for IndexingPressureService in ClusterService (#478).
            injector.getInstance(ThreadPool.class).getThreadContext()
            final HttpServerTransport httpServerTransport = newHttpTransport(networkModule);
                SearchExecutionStatsCollector.makeWrapper(responseCollectorService)  
        } catch (OpenSearchParseException e) {
                                telemetryPluginsImplementingTelemetryAware
            streamTransportService.acceptIncomingRequests();
            repositoriesServiceReference.set(repositoryService);  
    private static long calculateFileCacheSize(String capacityRaw, long totalSpace) {  
            final SetOnce<IngestService> ingestServiceReference = new SetOnce<>();  
                cacheService,
     *
                threadPool,
            final ShardLimitValidator shardLimitValidator = new ShardLimitValidator(settings, clusterService, systemIndices);
import java.util.Collection;
            final RemoteClusterStateCleanupManager remoteClusterStateCleanupManager;
import org.opensearch.plugins.TelemetryAwarePlugin;
                        + "]: "
import org.opensearch.storage.metrics.TierActionMetrics;  
                repositoryService,  
                nodeCacheService,
        }  
import java.util.Optional;
            final IndexingPressureService indexingPressureService = new IndexingPressureService(settings, clusterService);  
                    resourceWatcherService,
        return service;  
            final Optional<StreamSearchTransportService> streamSearchTransportService = streamTransportService.map(
                remoteStoreStatsTrackerFactory,  
                    new TieredDataFormatAwareStoreDirectoryFactory(tieredStoragePrefetchSettingsSupplier)  
            pluginComponents.addAll(newAuxTransports(networkModule));
        return provider::getConcurrencyLimiterStats;
            toClose.add(stc);
    private final MetricsRegistry metricsRegistry;
                    NetworkModule.getNamedXContents().stream(),  
            // closed yet.
            List<ClusterPlugin> clusterPlugins = pluginsService.filterPlugins(ClusterPlugin.class);
        for (LifecycleComponent plugin : pluginLifecycleComponents) {
            }
        }  
            final DeploymentStateService deploymentStateService = new DeploymentStateService(() -> clusterService.state());
            if (clusterless) {
            Settings settings,
        Set<String> taskHeaders,
            BigArrays bigArrays = createBigArrays(pageCacheRecycler, circuitBreakerService);  
                    workloadManagementSettings,
            );  
                settings,  
                    new IndexStoreListener.CompositeIndexStoreListener(
        s -> (DiscoveryNode.isDedicatedWarmNode(s)) ? "80%" : ZERO,
            // Register default factory
                forbidPrivateIndexSettings,
            pluginLifecycleComponents.addAll(
        injector.getInstance(WorkloadGroupService.class).stop();
            logger.info(
            DiscoveryNode.setDeprecatedMasterRole();
                new WorkloadGroupResourceUsageTrackerService(taskResourceTrackingService);
import org.opensearch.transport.TransportService;
            clusterService,
    /**
                CircuitBreaker breaker = circuitBreakerService.getBreaker(plugin.getCircuitBreaker(settings).getName());
                        latch.countDown();
            resourcesToClose.add(metricsRegistry::close);
            taskResourceTrackingService.addTaskCompletionListener(workloadGroupService);  
            final Transport streamTransport = wrapStreamTransport(streamTransportSupplier != null ? streamTransportSupplier.get() : null);  
                workloadManagementSettings,  
            final RemoteClusterStateService remoteClusterStateService;
            additionalSettings.addAll(pluginsService.getPluginSettings());
                    TieredDataFormatAwareStoreDirectoryFactory.FACTORY_KEY,
            case "hierarchy":
    private final Logger logger = LogManager.getLogger(Node.class);
                b.bind(MetadataUpgrader.class).toInstance(metadataUpgrader);
            Stream<IndexStoreListener> indexStoreListenerStream = pluginsService.filterPlugins(IndexStorePlugin.class)  
                remoteStorePinnedTimestampService = new RemoteStorePinnedTimestampService(
            Collection<Object> telemetryAwarePluginComponents = pluginsService.filterPlugins(TelemetryAwarePlugin.class)
                        Stream.of(
                b.bind(RemoteIndexPathUploader.class).toProvider(() -> remoteIndexPathUploader);  
    final NamedWriteableRegistry namedWriteableRegistry;  
                additionalSettings.addAll(builder.getRegisteredSettings());
                threadPool
                clusterService,
        injector.getInstance(SearchService.class).start();  
import org.opensearch.monitor.process.ProcessProbe;
                );  
        String type = BREAKER_TYPE_KEY.get(settings);
                initialEnvironment.pluginsDir(),
    /**  
                b.bind(RepositoriesService.class).toInstance(repositoryService);  
                b.bind(SearchPhaseController.class)
                b.bind(IdentityService.class).toInstance(identityService);  
import org.opensearch.cluster.action.index.MappingUpdatedAction;  
                nodeEnvironment,  
import org.opensearch.persistent.PersistentTasksExecutorRegistry;
        }  
        toClose.add(() -> stopWatch.stop().start("resource_usage_collector"));
                threadPool,
            success = true;
 * license agreements. See the NOTICE file distributed with
                transportService,
            throw new IllegalArgumentException("Unknown circuit breaker type [" + type + "]");
            streamTransportService.ifPresent(service -> service.getTaskManager().registerTaskResourceConsumer(taskConsumer));  
        discovery.setNodeConnectionsService(nodeConnectionsService);
            scriptService,  
                Build.CURRENT.getQualifiedVersion(),  
     */
                .forEach((k, v) -> {  
            );
                clusterService.getClusterSettings()  
                searchModule.getValuesSourceRegistry().getUsageService(),
                customNameResolvers.add(customNameResolver);  
            setContextClassLoader(Thread.currentThread().getContextClassLoader());
        toClose.add(() -> stopWatch.stop().start("http"));
                if (streamTransportService.isPresent()) {  
import org.opensearch.telemetry.TelemetrySettings;
                    "using config [{}], data [{}], logs [{}], plugins [{}]",
                metadataCreateIndexService,
            // build ingestion payload decoder registry  
    /**
        return this;
                .collect(Collectors.toList());
        Transport transport,
        "node.master",
                });  
        final RemoteClusterStateService remoteClusterStateService = injector.getInstance(RemoteClusterStateService.class);  
                clusterService.getClusterSettings(),  
                searchModule.getIndexSearcherExecutor(threadPool),
                    tracerFactory = new NoopTracerFactory();
                    settings,  
                compositeDirectoryFactories.put(  
                .put(initialEnvironment.settings())  
                    nodeEnvironment.nodeId(),
                b.bind(Client.class).toInstance(client);
        }
                    persistedStateRegistry,
        toClose.add(nodeService.getMonitorService());
                    clusterModule.getIndexNameExpressionResolver(),
            // All threads terminated successfully. Because search, recovery and all other operations
        return this.injector;
import org.opensearch.plugins.IndexStorePlugin;
    }
        );
        synchronized (lifecycle) {
            );
import org.opensearch.threadpool.ExecutorBuilder;
            ).collect(Collectors.toSet());
import org.opensearch.indices.replication.SegmentReplicator;
        injector.getInstance(ClusterService.class).stop();  
                );
                .stream()
            if (DiscoveryNode.isWarmNode(settings)) {  
        nodeService.getTaskCancellationMonitoringService().stop();  
            // full. Reuses the registry discovered above. No-op when no such plugin is loaded.
        toClose.add(injector.getInstance(GatewayMetaState.class));  
                .forEach((k, v) -> {  
                        ),
            return localNode.get();
            final ClusterService clusterService;
import org.opensearch.watcher.ResourceWatcherService;
            identityPlugins.addAll(pluginsService.filterPlugins(IdentityPlugin.class));
                clusterModule.getAllocationService(),
                        settingsModule.getClusterSettings(),
                analysisModule.getAnalysisRegistry(),
import org.opensearch.plugins.MapperPlugin;
                    } else {
     * Hook for validating the node after network
                        + b.getClass().getName()
    protected PluginsService getPluginsService() {
        public static final Setting<TimeValue> INITIAL_STATE_TIMEOUT_SETTING = Setting.positiveTimeSetting(
                }
                    @Override
        toClose.add(nodeService);  
                        throw new IllegalStateException("registered index store type [" + k + "] conflicts with a built-in type");  
                b.bind(IndicesService.class).toInstance(indicesService);
                repositoriesServiceReference::get
            );
                System.getProperty("java.version"),
    // close() might not be executed, in case another (for example api) call to close() has already set some lifecycles to stopped.
                new SearchRequestOperationsCompositeListenerFactory(  
    public static CircuitBreakerService createCircuitBreakerService(  
        }
            final MetadataUpgrader metadataUpgrader = new MetadataUpgrader(indexTemplateMetadataUpgraders);  
                threadPool,
                .map(c -> (NativeAllocatorStatsRegistry) c)
            this.nodeService = new NodeService(  
            if (DiscoveryNode.isClusterManagerNode(settings)) {  
/*  
        return new ScriptService(settings, engines, contexts);  
                xContentRegistry,
import org.opensearch.common.network.NetworkAddress;
            DiscoveryNode.setAdditionalRoles(additionalRoles);
            TransportNodesSnapshotsStatus nodesSnapshotsStatus = new TransportNodesSnapshotsStatus(
                indicesService.setSearchStatsContributors(searchStatsContributors);
            final Map<String, IndexStorePlugin.DirectoryFactory> builtInDirectoryFactories = IndexModule.createBuiltInDirectoryFactories(  
                }
        return nodeEnvironment;
    /**  
        // Start the transport service now so the publish address will be added to the local disco node in ClusterService
            );
            final RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, settingsModule.getClusterSettings());  
import static java.util.stream.Collectors.toList;
    private static final Setting<Boolean> NODE_INGEST_SETTING = Setting.boolSetting(
            } else {
                    latch.await();  
import org.opensearch.search.deciders.ConcurrentSearchRequestDecider;  
import org.opensearch.common.inject.Key;  
        public CustomForkJoinWorkerThread(ForkJoinPool pool) {  
        // stop any changes happening as a result of cluster state changes  
import org.opensearch.env.NodeEnvironment;
        assert localNodeFactory.getNode() != null;
import org.opensearch.common.unit.TimeValue;  
     * {@code MockNode}) override to install a stubbable wrapper so
        injector.getInstance(PeerRecoverySourceService.class).start();
                transportService,
    private static String validateFileCacheSize(String capacityRaw) {
                b.bind(DeploymentStateService.class).toInstance(deploymentStateService);  
                );
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
                pluginsService.filterPlugins(SystemTemplatesPlugin.class),
    /**
            final Set<SettingUpgrader<?>> settingsUpgraders = pluginsService.filterPlugins(Plugin.class)
    private final Environment environment;
import org.opensearch.plugins.SearchStatsContributor;
                        + a.getClass().getName()  
                writer.write(NetworkAddress.format(new InetSocketAddress(inetAddress, address.getPort())) + "\n");  
import org.opensearch.indices.SystemIndices;  
                        logger.warn("timed out while waiting for initial discovery state - timeout: {}", initialStateTimeout);  
            taskHeaders,
    @Nullable
            final SearchRequestOperationsCompositeListenerFactory searchRequestOperationsCompositeListenerFactory =
import org.opensearch.plugins.PluginsService;  
                }, state -> state.nodes().getClusterManagerNodeId() != null, initialStateTimeout);  
import java.util.Map;  
                    threadPool::preciseRelativeTimeInNanos,
            );  
import java.util.function.Function;
            resourcesToClose.add(resourceWatcherService);
import org.opensearch.search.SearchModule;
                .stream()
     * Creates a new the SearchService. This method can be overwritten by tests to inject mock implementations.
                    scriptService,  
        calculateFileCacheSize(capacityRaw, 0L);  
import org.opensearch.common.SetOnce;  
                        latch.countDown();
            if (isRemoteDataAttributePresent(settings) && CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.get(settings)) {
                payloadDecoderRegistry,
                    settings,  
import org.opensearch.script.ScriptService;  
                reg -> reg.setNativeMemoryPressureSupplier(nodeResourceUsageTracker::getNativeMemoryUtilizationPercent)  
    }
     * Hook to wrap the stream transport before it is shared between the
                settings,  
                threadPool,
                clusterService.addListener(new SystemIndexMetadataUpgradeService(systemIndices, clusterService));
            final Supplier<Transport> streamTransportSupplier = networkModule.getStreamTransportSupplier();
            clusterSettings,  
                transportService,
import org.opensearch.script.ScriptModule;
    }
                settingsModule.getClusterSettings()
        } else if (type.equals("none")) {
                .map(IndexStorePlugin::getIndexStoreListener)
                b.bind(MappingTransformerRegistry.class).toInstance(mappingTransformerRegistry);
     *  
import org.opensearch.discovery.LocalDiscovery;
    static void assertCanWritePluginHealthPaths(List<Path> paths) {
                throw new IllegalStateException(STREAM_TRANSPORT + " is enabled but no stream transport supplier is provided");
                repositoriesServiceReference::get,
                b.bind(ExtensionsManager.class).toInstance(this.extensionsManager);
            transport,
     * @param classpathPlugins           the plugins to be loaded from the classpath  
                .map(IndexStorePlugin::getCompositeDirectoryFactories)  
                    .collect(Collectors.toCollection(LinkedHashSet::new))
 * The OpenSearch Contributors require contributions made to  
                systemIndices,
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
        if (logger.isTraceEnabled()) {
            );
import org.opensearch.search.fetch.FetchPhase;
                .map(IndexStorePlugin::getRecoveryStateFactories)
                b.bind(SearchRequestOperationsCompositeListenerFactory.class).toInstance(searchRequestOperationsCompositeListenerFactory);
                        networkModule.getTransportInterceptor(),  
        List<Plugin> pluginsToClose = new ArrayList<>(pluginsService.filterPlugins(Plugin.class));
                clusterService = new LocalClusterService(settings, settingsModule.getClusterSettings(), threadPool, clusterManagerMetrics);  
                    throw new IllegalArgumentException("invalid node.attr.server_name [" + value + "]", e);
        toClose.add(injector.getInstance(PeerRecoverySourceService.class));  
                    () -> clusterService.getClusterApplierService().getCurrentApplicationDurationMs()
            final ResponseCollectorService responseCollectorService = new ResponseCollectorService(clusterService);  
        }
            workloadGroupService
                nodeCacheService,
import java.nio.file.FileSystemException;  
            /*  
                            .filter(p -> p instanceof SearchRequestOperationsListener)  
                    threadPool,
            super(settings, persistentNodeId);  
    public static class DiscoverySettings {
                searchRequestStats,
                threadPool,
                    .toInstance(new SearchPhaseController(namedWriteableRegistry, searchService::aggReduceContextBuilder));  
            );
                settingsModule.getSettingsFilter(),
        CircuitBreakerService circuitBreakerService,
import org.opensearch.plugins.SecureSettingsFactory;
import org.opensearch.plugins.ExtensionAwarePlugin;
                searchModule.getQueryPhase(),
                b.bind(SearchBackpressureService.class).toInstance(searchBackpressureService);
            final List<Setting<?>> additionalSettings = new ArrayList<>();
            injector.getInstance(RemoteClusterStateService.class),  
        injector.getInstance(FsHealthService.class).stop();
                engineFactoryProviders,
            final PersistentTasksService persistentTasksService = new PersistentTasksService(clusterService, threadPool, client);
            );
                    if (telemetryPluginsImplementingTelemetryAware.isEmpty() == false) {
            transportService.boundAddress(),
            resourcesToClose.add(clusterService);
    /**
                injector.getInstance(ShardsBatchGatewayAllocator.class)
            }  
            // Initialize tiered storage prefetch settings
                searchPipelineService,
            modules.add(settingsModule);
            // native-memory admission controller for indexing-pool based rejection.
                if (streamSearchTransportService.isPresent()) {  
import org.opensearch.telemetry.metrics.MetricsRegistryFactory;  
        return new PageCacheRecycler(settings);
import org.opensearch.core.common.transport.BoundTransportAddress;
     * {@link #NODE_DATA_SETTING}). However, if this is false, {@link #NODE_DATA_SETTING}
            );
                        resourceWatcherService,  
        Settings settings,
import org.opensearch.discovery.DiscoveryModule;
import org.opensearch.ingest.IngestService;  
                clusterService,
        transportService.getTaskManager().setTaskCancellationService(new TaskCancellationService(transportService));
                logger.warn(  
                }  
                nodeCacheService,
     */
                    if (telemetrySettings.isMetricsFeatureEnabled()) {
                .forEach(p -> p.getIndexCreationValidators().forEach(metadataMappingServiceInstance::addIndexCreationValidator));
    @SuppressWarnings("unused")
                    e  
        } catch (IOException ex) {  
            );
                    threadPool,
import org.opensearch.cluster.action.shard.LocalShardStateAction;
 * KIND, either express or implied.  See the License for the
                    Build.CURRENT.getQualifiedVersion()
                        client,  
    }  
            for (final ExecutorBuilder<?> builder : threadPool.builders()) {  
    }
            final InternalSnapshotsInfoService snapshotsInfoService = new InternalSnapshotsInfoService(
        toClose.add(nodeService.getSearchBackpressureService());
        // This can confuse other nodes and delay things - mostly if we're the cluster manager and we're running tests.  
                systemIndices,  
                settingsModule.getSettingsFilter(),
     * Creates a new {@link BigArrays} instance used for this node.  
        }
            final SearchRequestSlowLog searchRequestSlowLog = new SearchRequestSlowLog(clusterService);
import org.apache.logging.log4j.Logger;
        logger.info("starting ...");  
        List<SearchPlugin.ProfileMetricsProvider> pluginProfilers,
                recoveryStateFactories,
                Task.REQUEST_HEADERS.stream()
                clusterService,
import org.opensearch.cluster.routing.BatchedRerouteService;
                b.bind(ScriptService.class).toInstance(scriptService);
import org.opensearch.plugins.ClusterPlugin;  
                clusterService,  
            final Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories = pluginsService.filterPlugins(
                b.bind(SystemIndices.class).toInstance(systemIndices);
                )
        // close filter/fielddata caches after indices
            injector.getInstance(PersistedClusterStateService.class),
                nodeEnvironment = new NodeEnvironment(
                client,  
            ).flatMap(Function.identity()).collect(Collectors.toList());
                localNodeFactory,
import org.opensearch.plugins.MetadataUpgrader;  
                b.bind(UpdateHelper.class).toInstance(new UpdateHelper(scriptService));  
    private final AutoForceMergeManager autoForceMergeManager;
                BootstrapSettings.initializeSerialFilter();  
            identityService.initializeIdentityAwarePlugins(identityAwarePlugins);
    );
            // misleading log) and dedupe (avoid probing the same path twice if a plugin happens to
     * Get Custom Name Resolvers list based on a Discovery Plugins list
            // Inject the node-level native memory pressure signal (same signal admission control uses)
import org.opensearch.node.remotestore.RemoteStoreNodeService;  
 *  
                settings,
            assertCanWritePluginHealthPaths(pluginAdditionalHealthPaths);
import org.opensearch.ratelimitting.admissioncontrol.transport.AdmissionControlTransportInterceptor;
                b.bind(UsageService.class).toInstance(usageService);
            // that run on shards run in the threadpool, indices should be effectively closed by now.  
                        tracerFactory = new NoopTracerFactory();  
                    .map(plugin -> plugin.getTaskManagerClient(client, clusterService, threadPool))
                            searchTaskRequestOperationsListener,
import java.util.concurrent.Executor;
                b.bind(PageCacheRecycler.class).toInstance(pageCacheRecycler);
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
            throw new IllegalStateException("Call close() first");
                metadataIndexUpgradeService,  
    protected ScriptService newScriptService(Settings settings, Map<String, ScriptEngine> engines, Map<String, ScriptContext<?>> contexts) {
                ? pluginsService.filterPlugins(TaskManagerClientPlugin.class)  
                .map(IndexStorePlugin::getDirectoryFactories)  
import org.opensearch.Build;
            );
            final JvmInfo jvmInfo = JvmInfo.jvmInfo();  
                threadPool,  
                    client,
        injector.getInstance(SnapshotShardsService.class).start();
            );
        // of stream transport for it to use it in localNode creation  
        toClose.add(() -> stopWatch.stop().start("cluster"));  
            if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)) {
import org.opensearch.common.settings.SettingsModule;
        toClose.add(injector.getInstance(ClusterService.class));
        toClose.add(() -> stopWatch.stop().start("client"));
            RepositoriesService repositoryService = repositoriesModule.getRepositoryService();
        injector.getInstance(IndicesService.class).start();
        nodeService.getSearchBackpressureService().stop();
                compositeIndexSettings,
            settings(),
                .filter(Objects::nonNull)
import org.opensearch.transport.client.node.NodeClient;  
            }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.mapper.MappingTransformerRegistry;
        injector.getInstance(MappingUpdatedAction.class).setClient(client);  
import org.opensearch.index.store.remote.filecache.FileCache;  
    private final Injector injector;  
import org.opensearch.cluster.InternalClusterInfoService;  
        return terminated;
            } else {
            SnapshotsService snapshotsService = new SnapshotsService(
                        transportService.getRemoteClusterService(),
        Discovery discovery = injector.getInstance(Discovery.class);
                            String.format(
                        namedWriteableRegistry,
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
    private final LocalNodeFactory localNodeFactory;
                    public void onClusterServiceClose() {  
            injector.getInstance(MetaStateService.class),
     * @see #BREAKER_TYPE_KEY
    public static final Setting<Boolean> NODE_LOCAL_STORAGE_SETTING = Setting.boolSetting(
                clusterService,  
            if (!lifecycle.moveToClosed()) {  
            toClose.add(plugin);  
            } else {
    }
                remoteStoreNodeService.createAndVerifyRepositories(discoveryNode);  
            final RecoverySettings recoverySettings = new RecoverySettings(settings, settingsModule.getClusterSettings());
            circuitBreakerService,
                indicesService,  
                persistentNodeId  
            localNodeFactory = new RemoteStoreVerifyingLocalNodeFactory(settings, nodeEnvironment.nodeId(), remoteStoreNodeService);
                clusterService.getClusterSettings()
    );  
                new WorkloadGroupTaskCancellationService(
                settings,
            }  
        }  
                cacheService,
                scriptService,
import java.util.ArrayList;  
                        Collectors.toMap(
                b.bind(HttpServerTransport.class).toInstance(httpServerTransport);
        injector.getInstance(HttpServerTransport.class).stop();
                metricsRegistry,
            final CompositeIndexSettings compositeIndexSettings = new CompositeIndexSettings(settings, settingsModule.getClusterSettings());
            pluginsService.filterPlugins(IngestionConsumerPlugin.class)  
            final Collection<EnginePlugin> enginePlugins = pluginsService.filterPlugins(EnginePlugin.class);
            } else {
            final AliasValidator aliasValidator = new AliasValidator();  
    private final NodeEnvironment nodeEnvironment;
            List<SearchStatsContributor> searchStatsContributors = pluginsService.filterPlugins(SearchStatsContributor.class);  
            final Settings settings = pluginsService.updatedSettings();  
            }  
                b.bind(SnapshotShardsService.class).toInstance(snapshotShardsService);
        // we close indices first, so operations won't be allowed on it
                clusterService,
                );  
                monitorService,
        toClose.add(injector.getInstance(RemoteStorePinnedTimestampService.class));
        }  
        toClose.add(() -> stopWatch.stop().start("thread_pool"));
                admissionControlService  
                        transportService.getTaskManager(),  
                    throw new OpenSearchTimeoutException("Interrupted while waiting for initial discovery state");
            final Discovery discovery;
            );  
        true,  
import org.opensearch.indices.breaker.BreakerSettings;
                .map(plugin -> (Function<IndexSettings, Optional<EngineFactory>>) plugin::getEngineFactory)
    private Node stop() {  
            dataFormatAwareStoreDirectoryFactories.put("default", new DefaultDataFormatAwareStoreDirectoryFactory());  
                    )  
import javax.net.ssl.SNIHostName;  
                try {
            final TaskCancellationMonitoringSettings taskCancellationMonitoringSettings = new TaskCancellationMonitoringSettings(
                clusterService,  
                settings,
                remoteIndexPathUploader = null;  
        toClose.add(injector.getInstance(ResourceUsageCollectorService.class));
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
                .flatMap(
                throw new IllegalStateException(
                threadPool::relativeTimeInMillis,
 * SPDX-License-Identifier: Apache-2.0
import java.io.Closeable;  
import org.opensearch.common.lifecycle.Lifecycle;
import org.opensearch.index.IngestionConsumerFactory;
                                segmentReplicator
    }
                pluginsService.getGuiceServiceClasses().stream().map(injector::getInstance).collect(Collectors.toList())  
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;
        DiscoveryNode getNode() {  
        Path tmpPortsFile = environment.logsDir().resolve(type + ".ports.tmp");
import org.opensearch.action.search.SearchPhaseController;  
            final RemoteStorePinnedTimestampService remoteStorePinnedTimestampService;  
                .stream()
    ) {
                throw new IllegalStateException(
                pluginsService.filterPlugins(NetworkPlugin.class),  
            for (Module pluginModule : pluginsService.createGuiceModules()) {  
import org.opensearch.plugins.IdentityPlugin;
            }
            final MetadataCreateIndexService metadataCreateIndexService = new MetadataCreateIndexService(
 * under the License.  
                admissionControlTransportInterceptor,
             */  
        if (type.equals("hierarchy")) {  
import org.opensearch.common.unit.RatioValue;
                );
            );
 *
import org.opensearch.bootstrap.BootstrapSettings;
                b.bind(MergedSegmentWarmerFactory.class).toInstance(mergedSegmentWarmerFactory);
                identityService
                threadPool,
    private final ExtensionsManager extensionsManager;
                threadPool
                    repositoriesServiceReference::get,
                    public void onNewClusterState(ClusterState state) {
            throw new RuntimeException("Failed to rename ports file", e);  
                .flatMap(m -> m.entrySet().stream())
                b.bind(ClusterInfoService.class).toInstance(clusterInfoService);
        injector.getInstance(NodeResourceUsageTracker.class).stop();  
import java.util.stream.Stream;
                settings,
import org.opensearch.tasks.consumer.TopNSearchTasksLogger;
            additionalSettings.add(NODE_INGEST_SETTING);
        }
                Collection<Object> components = p.createComponents(
        Property.NodeScope
        gatewayMetaState.start(
        QueryPhase queryPhase,
                threadPool,
        autoForceMergeManager.stop();
                } else {
            final MetadataMappingService metadataMappingServiceInstance = injector.getInstance(MetadataMappingService.class);
import org.opensearch.cluster.metadata.MetadataCreateIndexService;  
        try {
import org.opensearch.index.analysis.AnalysisRegistry;  
    }
import java.util.concurrent.ForkJoinWorkerThread;
            final NodeResourceUsageTracker nodeResourceUsageTracker = new NodeResourceUsageTracker(
                if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)) {
                client,  
        if (streamTransportService != null) {  
                this.extensionsManager = new NoopExtensionsManager(identityService);
            );
import org.opensearch.action.search.StreamSearchTransportService;
import org.opensearch.index.remote.RemoteIndexPathUploader;  
    ) {
                metaStateService,
        Property.NodeScope
                    remoteStoreNodeService,  
            } else {  
        Executor indexSearcherExecutor,
                }  
            DynamicActionRegistry dynamicActionRegistry = actionModule.getDynamicActionRegistry();
            // Wire indexing pool group limit changes to the IndexingMemoryController.
     * test-only request-handler interception works on the streaming path
            try {
                        pluginComponents.stream()
import org.opensearch.extensions.ExtensionsManager;  
                FileCache fileCache = fileCache();  
            Environment.assertEquivalent(initialEnvironment, this.environment);
            return localNode.get();  
    public Node start() throws NodeValidationException {
        ClusterService clusterService,
                storeFactories,
            // Going forward, IndexingPressureService will have required constructs for exposing listeners/interfaces for plugin
            resourcesToClose.add(nodeRuntimeMetrics);
import org.opensearch.action.support.TransportAction;
            client.initialize(
        ClusterSettings clusterSettings  
        logger.info("closing ...");
     * Returns {@code true} if the node is closed.  
            clusterService.setRerouteService(rerouteService);
                    )  
            final Map<String, Collection<SystemIndexDescriptor>> systemIndexDescriptorMap = Collections.unmodifiableMap(
            client = new NodeClient(settings, threadPool);  
        final List<Closeable> resourcesToClose = new ArrayList<>(); // register everything we need to release in the case of an error
                usageService,  
        final ClusterService clusterService = injector.getInstance(ClusterService.class);  
                b.bind(RemoteClusterStateService.class).toProvider(() -> remoteClusterStateService);
            Files.move(tmpPortsFile, portsFile, StandardCopyOption.ATOMIC_MOVE);
                xContentRegistry,  
                circuitBreakerService,
            remoteStoreStatsTrackerFactory = new RemoteStoreStatsTrackerFactory(clusterService, settings);
                indicesModule.getMapperRegistry(),
                b.bind(RemoteStoreSettings.class).toInstance(remoteStoreSettings);  
import org.opensearch.core.Assertions;
                recoverySettings,  
    /**  
                                Locale.ROOT,
import org.opensearch.cluster.node.DiscoveryNode;  
                });
            );  
                resourceUsageCollectorService,
                    repositoriesServiceReference::get,
                    clusterService.getClusterSettings(),
                tracer,
            scriptModule.registerClusterSettingsListeners(scriptService, settingsModule.getClusterSettings());  
import java.net.InetSocketAddress;  
        Collections.reverse(pluginsToClose);
            runnableTaskListener = new AtomicReference<>();
            // The search for viable copies is triggered by an allocation attempt (i.e. a reroute) and is performed asynchronously. When it
            final IngestionPayloadDecoderRegistry payloadDecoderRegistry = registryBuilder.build();
        final NodeConnectionsService nodeConnectionsService = injector.getInstance(NodeConnectionsService.class);
    // During concurrent close() calls we want to make sure that all of them return after the node has completed it's shutdown cycle.
                fileCache()  
            );  
    public Injector injector() {  
                clusterService::state,
        (key) -> new Setting<>(key, "", (value) -> {
     * @param discoveryPlugins Discovery plugins list
                jvmInfo.pid(),
                    .map(DiscoveryNodeRole::roleName)  
        toClose.add(injector.getInstance(IndicesClusterStateService.class));
            }  
                final NodeMetadata nodeMetadata = NodeMetadata.FORMAT.loadLatestState(
        IOUtils.close(toClose);
            final FsHealthService fsHealthService = new FsHealthService(
                b.bind(PersistedStateRegistry.class).toInstance(persistedStateRegistry);  
                settingsModule.getIndexScopedSettings(),
            pluginsService.filterPlugins(SearchBackEndPlugin.class)
            final IdentityService identityService = new IdentityService(settings, threadPool, identityPlugins);
import org.opensearch.storage.directory.TieredDirectoryFactory;
            );  
            // Defensive: filter out nulls (a misbehaving plugin returning a list containing null  
                b.bind(AwarenessReplicaBalance.class).toInstance(awarenessReplicaBalance);
import org.opensearch.search.backpressure.settings.SearchBackpressureSettings;
import org.opensearch.plugins.DefaultPluginComponentRegistry;
import java.nio.file.Files;
import java.nio.file.Path;  
                );  
        injector.getInstance(NodeConnectionsService.class).stop();
            injector.getInstance(MetadataIndexUpgradeService.class),  
            final Map<String, IndexStorePlugin.DirectoryFactory> directoryFactories = new HashMap<>();  
    );
            RestoreService restoreService = new RestoreService(  
     * This method can be overwritten by subclasses to change their {@link BigArrays} implementation for instance for testing
            ClusterStateObserver observer = new ClusterStateObserver(clusterState, clusterService, null, logger, thread.getThreadContext());  
        // awaitClose if the node doesn't finish closing within the specified time.  
import org.opensearch.action.search.SearchRequestOperationsCompositeListenerFactory;
                b.bind(MetaStateService.class).toInstance(metaStateService);
            resourcesToClose.addAll(pluginLifecycleComponents);
                recoverySettings,
                indicesModule.getMapperRegistry(),
                    logger,
            final IngestService ingestService = new IngestService(
import org.opensearch.script.ScriptEngine;
     * Mirrors the spirit of {@code NodeEnvironment.assertCanWrite()} but for plugin paths.
                injector.getInstance(GatewayAllocator.class),  
        Property.NodeScope  
 *
        injector.getInstance(FsHealthService.class).start();
 * the Apache License, Version 2.0 (the "License"); you may
            Collection<UnaryOperator<Map<String, IndexTemplateMetadata>>> indexTemplateMetadataUpgraders = pluginsService.filterPlugins(  
            remoteStorePinnedTimestampService.start();  
            final SearchService searchService = newSearchService(
                settingsModule.getIndexScopedSettings(),  
                : Optional.empty();
                repositoryService,
            SnapshotShardsService snapshotShardsService = new SnapshotShardsService(
                    transportService,
        final GatewayMetaState gatewayMetaState = injector.getInstance(GatewayMetaState.class);  
        injector.getInstance(GatewayService.class).stop();
import org.opensearch.plugins.IngestPlugin;  
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            TimeValue.timeValueSeconds(30),
            // and fail-fast detection of duplicate names at startup.
                settings,
                b.bind(MetadataIndexUpgradeService.class).toInstance(metadataIndexUpgradeService);
                        .toInstance(
        }
import org.opensearch.plugins.SystemIndexPlugin;  
                );
            streamTransportService.start();
            if (Build.CURRENT.isProductionRelease() == false) {
                settings,
                b.bind(Discovery.class).toInstance(discovery);
            );
                    namedWriteableRegistry,  
        final BoundTransportAddress boundTransportAddress,
            final List<MapperPlugin> mapperPlugins = pluginsService.filterPlugins(MapperPlugin.class);
import org.opensearch.plugins.CachePlugin;
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteStoreAttributePresent;  
                    // Supplier for current cluster state application duration in ms (0 if idle)  
            localNodeFactory,
                pluginsService,
        pluginLifecycleComponents.forEach(LifecycleComponent::stop);
import org.opensearch.plugins.RestoreListenerPlugin;
                    clusterService.getClusterManagerService(),
                threadPool,
                ).flatMap(Function.identity()).collect(toList())
            final MetadataIndexUpgradeService metadataIndexUpgradeService = new MetadataIndexUpgradeService(
                    Stream.concat(
                ? Optional.of(
                nodeEnvironment,  
    public static final Setting<Boolean> WRITE_PORTS_FILE_SETTING = Setting.boolSetting("node.portsfile", false, Property.NodeScope);  
import org.opensearch.common.inject.ModulesBuilder;
            fetchPhase,  
    /**
        private final String persistentNodeId;
                settings,
                client,
                settings,  
import org.opensearch.action.search.SearchRequestOperationsListener;
import org.opensearch.index.IndexModule;
                resourceUsageCollectorService,
                searchModule.getValuesSourceRegistry(),  
                }
            final List<IdentityPlugin> identityPlugins = new ArrayList<>();  
                xContentRegistry,  
     * initialized until an instance of Node is constructed, which is sure to happen after the logging infrastructure
                NetworkModule.getNamedWriteables().stream(),  
                    "Duplicate BlockCacheProvider for name ["  
import org.opensearch.wlm.tracker.WorkloadGroupResourceUsageTrackerService;
            if (!success) {  
                nativeAllocatorStatsSupplier
    private static final Setting<Boolean> NODE_REMOTE_CLUSTER_CLIENT = Setting.boolSetting(
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
            Settings tmpSettings = Settings.builder()
        StopWatch stopWatch = new StopWatch("node_close");
import org.opensearch.search.pipeline.SearchPipelineService;
            );
                discovery,
                throw new IllegalStateException(
        Property.Deprecated,
    }  
        toClose.add(() -> stopWatch.stop().start("node_connections_service"));
            final NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(namedWriteables);  
                xContentRegistry,
                    "Plugin-supplied health path [" + path + "] is not writable (filesystem error): " + reason,  
                    "Plugin-supplied health path [" + path + "] is not writable (no such file or directory): " + e.getMessage(),
                    "no-jdk distributions that do not bundle a JDK are deprecated and will be removed in a future release"
                    b.bind(BlockCacheRegistry.class).toInstance(nodeCacheService);
import org.opensearch.cluster.StreamNodeConnectionsService;
 * Licensed to Elasticsearch under one or more contributor  
                    initialEnvironment.pluginsDir()  
            SystemTemplatesService systemTemplatesService = new SystemTemplatesService(
    /**  
     *                              bound and publishing to  
import org.opensearch.monitor.fs.FsServiceProvider;
            pluginsService.filterPlugins(Plugin.class)  
            // the SearchRequestOperationsListener instanceof filter on pluginComponents elsewhere
            }
                    b.bind(PeerRecoverySourceService.class)  
                    settings,  
                }  
                clusterService.addLocalNodeClusterManagerListener(
                    IndicesModule.getNamedXContents().stream(),
                .stream()
            );
                .filter(Optional::isPresent)  
    /**
     * Returns the {@link FileCache} instance for remote warm nodes, or {@code null} on non-warm nodes.
                ex.addSuppressed(e);
    private static class RemoteStoreVerifyingLocalNodeFactory extends LocalNodeFactory {  
                buildConcurrencyLimiterStatsSupplier(pluginsService)
                tieredStoragePrefetchSettingsSupplier = () -> tieredStoragePrefetchSettings;  
        toClose.add(injector.getInstance(GatewayService.class));
    );
                        );  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteClusterStateConfigured;
            try {
                .stream()  
                    gatewayMetaState,
                threadPool,  
                    }  
                        clusterService,
            indexSearcherExecutor,  
            final SegmentReplicationStatsTracker segmentReplicationStatsTracker = new SegmentReplicationStatsTracker(indicesService);  
                    if (k.equals("default")) {
import org.opensearch.plugin.stats.NativeAllocatorStatsRegistry;  
                clusterless ? LocalShardStateAction.class : ShardStateAction.class
        toClose.add(injector.getInstance(IndicesService.class));  
            Path probe = path.resolve(".opensearch_plugin_health_boot_probe_" + UUIDs.randomBase64UUID());
import org.opensearch.tasks.TaskResourceTrackingService;  
import org.opensearch.cluster.ClusterState;
import org.opensearch.discovery.Discovery;  
                        nodeEnvironment,
            FeatureFlags.initializeFeatureFlags(tmpSettings);
    private static final String CLIENT_TYPE = "node";  
import org.opensearch.core.common.unit.ByteSizeValue;
                settingsModule.getClusterSettings(),
        clusterService.setNodeConnectionsService(nodeConnectionsService);
                    }  
            if (isRemoteClusterStateConfigured(settings)) {
import org.opensearch.monitor.jvm.JvmInfo;  
            }
package org.opensearch.node;
                .forEach(plugin -> plugin.getIngestionPayloadDecoderFactories().forEach(registryBuilder::register));
            HeaderWarning.setThreadContext(threadPool.getThreadContext());
import org.opensearch.transport.client.Client;
                pluginCircuitBreakers,
            );  
                discovery = new DiscoveryModule(
            CacheService cacheService = cacheModule.getCacheService();  
                pluginsService.filterPlugins(CryptoKeyProviderPlugin.class),
                this.extensionsManager = new ExtensionsManager(additionalSettings, identityService);  
     */
                b.bind(BigArrays.class).toInstance(bigArrays);  
            );
            final List<ExecutorBuilder<?>> executorBuilders = pluginsService.getExecutorBuilders(settings);
     * Creates a new the ScriptService. This method can be overwritten by tests to inject mock implementations.  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteDataAttributePresent;
        // pass it to the bootstrap checks to allow plugins to enforce certain preconditions based on the recovered state.
                    b.bind(MergedSegmentPublisher.PublishAction.class).to(RemoteStorePublishMergedSegmentAction.class).asEagerSingleton();
        logger.info("closed");  
import org.opensearch.index.store.DefaultDataFormatAwareStoreDirectoryFactory;  
        final BootstrapContext context,
                .map(Optional::get)  
     * The discovery settings for the node.  
import org.opensearch.indices.replication.SegmentReplicationSourceService;
import org.opensearch.common.settings.ConsistentSettingsService;
            final SearchTaskRequestOperationsListener searchTaskRequestOperationsListener = new SearchTaskRequestOperationsListener(  
                threadPool,
import org.opensearch.wlm.WorkloadManagementTransportInterceptor;  
                circuitBreakerService,
            }
                    xContentRegistry,
     *
import java.util.Collections;  
            SearchModule searchModule = new SearchModule(settings, pluginsService.filterPlugins(SearchPlugin.class));  
                        .toInstance(new PeerRecoveryTargetService(threadPool, transportService, recoverySettings, clusterService));  
                : Optional.empty();
                );
            actionModule.initRestHandlers(() -> clusterService.state().nodes());
    }
            // plugin modules must be added here, before others or we can get crazy injection errors...
            additionalSettings.add(NODE_MASTER_SETTING);
            final DiscoveryNode discoveryNode = super.apply(boundTransportAddress);  
import org.opensearch.script.ScriptContext;  
                b.bind(SegmentReplicator.class).toInstance(segmentReplicator);  
        public DiscoveryNode apply(BoundTransportAddress boundTransportAddress) {
            // Discovered here (ahead of AdmissionControlService) so it can be forwarded to the
import org.opensearch.persistent.PersistentTasksService;  
import org.opensearch.gateway.GatewayAllocator;
import org.opensearch.indices.SystemIndexDescriptor;
                tracerFactory = new NoopTracerFactory();  
import org.opensearch.crypto.CryptoHandlerRegistry;
     * Start the node. If the node is already started, this method is no-op.
        return environment;  
     * @param context               the bootstrap context for this node
import java.util.concurrent.TimeUnit;
            clusterModule.setRerouteServiceForAllocator(rerouteService);  
import org.opensearch.cluster.node.DiscoveryNodeRole;
                throw ex;  
                .filter(c -> c instanceof NativeAllocatorStatsRegistry)
import java.util.function.Supplier;
                namedWriteableRegistry,  
                        Stream.concat(indexStoreListenerStream, Stream.of(new NodeCacheServiceCleaner(() -> this.nodeCacheService)))  
            final PersistedClusterStateService lucenePersistedStateFactory = new PersistedClusterStateService(
            if (FeatureFlags.isEnabled(STREAM_TRANSPORT) && streamTransportSupplier == null) {  
                    .stream()
            clusterService.setStreamNodeConnectionsService(streamNodeConnectionsService);  
                new FileCacheSettings(settings, clusterService.getClusterSettings())::getRemoteDataRatio  
import org.opensearch.index.store.remote.filecache.NodeCacheService;
                    metricsRegistryFactory = new NoopMetricsRegistryFactory();  
import org.opensearch.cluster.routing.RerouteService;  
                        );  
                b.bind(NetworkService.class).toInstance(networkService);
import java.util.concurrent.atomic.AtomicReference;  
        toClose.add(() -> stopWatch.stop().start("script"));
        try {  
                                transportService,  
     * Creates a new {@link BigArrays} instance used for this node.
            final TieredStoragePrefetchSettings tieredStoragePrefetchSettings;
                circuitBreakerService,
                {
                    NamedXContentRegistry.EMPTY,  
        if (initialStateTimeout.millis() > 0) {  
                pluginsService.filterPlugins(CryptoPlugin.class),
                        + a.cacheName()
                    )
        injector.getInstance(RepositoriesService.class).stop();
                threadPool,
                        metricsRegistry  
import org.opensearch.plugins.EnginePlugin;  
import org.opensearch.cluster.deployment.DeploymentStateService;
                remoteStorePinnedTimestampService,  
                    p -> p.getPersistentTasksExecutor(  
                xContentRegistry,
                repositoriesServiceReference::get,  
                }
                clusterService,
            resourcesToClose.add(() -> HeaderWarning.removeThreadContext(threadPool.getThreadContext()));
                awarenessReplicaBalance,
                    clusterService,  
            final RemoteIndexPathUploader remoteIndexPathUploader;  
                environment.settings(),  
    }  
        ThreadPool threadPool,
            throw new RuntimeException("Failed to write ports file", e);  
import org.opensearch.cluster.metadata.SystemIndexMetadataUpgradeService;
        Node::validateFileCacheSize,
    protected HttpServerTransport newHttpTransport(NetworkModule networkModule) {
                OsProbe.getInstance()
                scriptService,  
                repositoriesServiceReference::get,
        List<ConcurrencyLimiterStatsPlugin> providers = pluginsService.filterPlugins(ConcurrencyLimiterStatsPlugin.class);
    private final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(Node.class);
                    b.bind(HotToWarmTieringService.class).asEagerSingleton();
import org.opensearch.common.inject.util.Providers;  
        // if we had scroll searchers etc or recovery going on we wait for to finish.
                    pluginComponentRegistry.register(component);
            }
import org.opensearch.bootstrap.BootstrapContext;
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED;  
                settings,
            indicesService,
                actionModule.getActionFilters(),
            final List<String> additionalSettingsFilter = new ArrayList<>(pluginsService.getPluginSettingsFilter());
                tieredStoragePrefetchSettings = new TieredStoragePrefetchSettings(clusterService.getClusterSettings());
import org.opensearch.action.ActionConcurrencyLimiterStats;  
                    public void onTimeout(TimeValue timeout) {
            ).stream().collect(java.util.stream.Collectors.toMap(org.opensearch.plugins.BlockCacheProvider::cacheName, p -> p, (a, b) -> {
            final MappingTransformerRegistry mappingTransformerRegistry = new MappingTransformerRegistry(mapperPlugins, xContentRegistry);  
        injector.getInstance(Discovery.class).stop();
                Constants.JVM_NAME,  
                    }
            final GatewayMetaState gatewayMetaState = new GatewayMetaState();
    // synchronized to prevent running concurrently with close()  
            responseCollectorService,
                remoteStoreSettings,
            new TemplateUpgradeService(client, clusterService, threadPool, indexTemplateMetadataUpgraders);  
            ).orElse(null);  
    private final MergedSegmentWarmerFactory mergedSegmentWarmerFactory;
import org.opensearch.OpenSearchTimeoutException;
            // If node construction fails before IndicesService takes ownership of the registry  
                transportService,
        injector.getInstance(IndicesService.class).stop();
                settingsModule.getIndexScopedSettings(),
        final boolean terminated = ThreadPool.terminate(threadPool, timeout, timeUnit);  
            } else {
                threadPool.getThreadContext(),  
 * in order to use a {@link Client} to perform actions/operations against the cluster.
                } else {  
import org.opensearch.gateway.GatewayService;
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
    protected Node(final Environment initialEnvironment, Collection<PluginInfo> classpathPlugins, boolean forbidPrivateIndexSettings) {
    }
            dynamicActionRegistry.registerUnmodifiableActionMap(injector.getInstance(new Key<Map<ActionType, TransportAction>>() {  
     */  
     * @opensearch.internal
import org.opensearch.common.cache.module.CacheModule;  
                            )
     */  
        }
            final SetOnce<RepositoriesService> repositoriesServiceReference = new SetOnce<>();
            }
    BigArrays createBigArrays(PageCacheRecycler pageCacheRecycler, CircuitBreakerService circuitBreakerService) {
 * @opensearch.internal  
            if (clusterless) {
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
        }  
     *                                   test framework for tests that rely on being able to set private settings
                Map.copyOf(compositeDirectoryFactories),
        injector.getInstance(SnapshotsService.class).stop();  
                "node name [{}], node ID [{}], cluster name [{}], roles {}",  
                    settings,
                .flatMap(Set::stream)  
                b.bind(TaskResourceTrackingService.class).toInstance(taskResourceTrackingService);  
import org.opensearch.snapshots.SnapshotsInfoService;
     * requests.
        logger.info("started");
                clusterService.getClusterSettings(),
import org.opensearch.OpenSearchException;
import org.opensearch.gateway.GatewayModule;
     */  
                .map(
        injector.getInstance(TransportService.class).stop();
     *
                .flatMap(m -> m.entrySet().stream())  
    }
                    namedWriteableRegistry,
            final Supplier<AnalyticsBackendTaskCancellationStats> analyticsTaskCancellationStatsSupplier = pluginsService.filterPlugins(
            toClose.add(() -> stopWatch.stop().start("plugin(" + plugin.getClass().getName() + ")"));
                workloadGroupsStateAccessor
    }  
                    fsHealthService,
    private static final String ZERO = "0";  
import org.opensearch.common.logging.DeprecationLogger;
        nodeService.getMonitorService().stop();  
                } else {
                .map(Plugin::getSettingUpgraders)
import org.opensearch.task.commons.clients.TaskManagerClient;
                    clusterService  
            String persistentNodeId,  
                transportService,
        if (stc != null) {
    private void writePortsFile(String type, BoundTransportAddress boundAddress) {
     * {@link IllegalStateException} on any failure so node boot halts loudly on misconfiguration.  
            final IndicesService indicesService = new IndicesService(  
            return new NoneCircuitBreakerService();  
import org.opensearch.action.search.SearchTaskRequestOperationsListener;
                pluginsService.filterPlugins(ActionPlugin.class),  
            }));
                threadPool,
            toClose.add(injector.getInstance(Tracer.class));  
            toClose.add(() -> logger.trace("Close times for each service:\n{}", stopWatch.prettyPrint()));
import org.opensearch.common.inject.Injector;
                extensionsManager  
            final PersistedStateRegistry persistedStateRegistry = new PersistedStateRegistry();
            clusterModule.setExistingShardsAllocators(
 * You may obtain a copy of the License at  
                indicesService,
                    remoteClusterStateService
            final IndexStorePlugin.DirectoryFactory remoteDirectoryFactory = new RemoteSegmentStoreDirectoryFactory(
                transportService.getTaskManager(),
                b.bind(RemoteClusterStateCleanupManager.class).toProvider(() -> remoteClusterStateCleanupManager);
                    threadPool,
                settings,
import org.opensearch.gateway.PersistedClusterStateService;
                );
                    new StreamTransportService(
                        xContentRegistry,
            modules.add(clusterModule);
                            new SegmentReplicationTargetService(  
        List<NetworkService.CustomNameResolver> customNameResolvers = new ArrayList<>();
                );  
        ThreadPool threadPool = injector.getInstance(ThreadPool.class);
        Property.Deprecated,
        return nodeCacheService != null ? nodeCacheService.fileCache() : null;
     * Note that this does not control whether the node stores actual indices (see
                });
                final List<ExtensionAwarePlugin> extensionAwarePlugins = pluginsService.filterPlugins(ExtensionAwarePlugin.class);
                    p -> p.getAdditionalIndexSettingProviders().forEach(metadataCreateIndexService::addAdditionalIndexSettingProvider)
import org.opensearch.cluster.metadata.IndexTemplateMetadata;  
                        latch.countDown();
    ) {  
                shardLimitValidator,  
            modules.add(actionModule);
                scriptService,
            : "clusterService has a different local node than the factory provided";
            throw new OpenSearchException("failed to bind service", ex);
                pageCacheRecycler,  
    // In this case the process will be terminated even if the first call to close() has not finished yet.
    protected TransportService newTransportService(  
     */
            final Map<String, org.opensearch.index.store.DataFormatAwareStoreDirectoryFactory> dataFormatAwareStoreDirectoryFactories =
            // We don't want to shutdown the threadpool or interrupt threads on a node that is not  
                b.bind(WorkloadGroupService.class).toInstance(workloadGroupService);
        if (streamTransportService != null) {
        Property.NodeScope  
    }  
                .stream()
        toClose.add(() -> stopWatch.stop().start("indices_cluster"));  
                .collect(Collectors.toList());
    }
import org.opensearch.plugins.PersistentTaskPlugin;  
                    environment.configDir(),
                            .collect(Collectors.toList())
            NetworkService.CustomNameResolver customNameResolver = discoveryPlugin.getCustomNameResolver(settings());
                threadPool,
                            workloadGroupRequestOperationListener  
                this.environment,  
        "node.data",
        if (!lifecycle.moveToStopped()) {
                    workloadGroupResourceUsageTrackerService,
                settings,  
            interceptor,
        }  
            directoryFactories.putAll(builtInDirectoryFactories);
                    rerouteService,  
                httpServerTransport,
                clusterService,
                b.bind(DeploymentManagerService.class).toInstance(deploymentManagerService);
import java.io.IOException;
                initialEnvironment.configDir(),  
                    new ConsistentSettingsService(settings, clusterService, consistentSettings).newHashPublisher()  
            // Discover the native-allocator stats supplier from any plugin that publishes a  
    protected SearchService newSearchService(
            toClose.add(injector.getInstance(MetricsRegistry.class));
        } catch (IOException e) {
            pluginsService.filterPlugins(Plugin.class)
        toClose.add(injector.getInstance(SegmentReplicationSourceService.class));
    public Node(Environment environment) {
            // report a path that overlaps with another contributor or with nodeDataPaths).  
    ) {
        nodeService.getSearchBackpressureService().start();
                b.bind(SearchRequestSlowLog.class).toInstance(searchRequestSlowLog);  
            final CircuitBreakerService circuitBreakerService = createCircuitBreakerService(
            final DataFormatRegistry dataFormatRegistry = new DataFormatRegistry(pluginsService);  
            final Map<String, IngestionConsumerFactory> ingestionConsumerFactories = new HashMap<>();
            List<LifecycleComponent> pluginLifecycleComponents = pluginComponents.stream()
            );
                settings,
    /** Constructs a {@link org.opensearch.http.HttpServerTransport} which may be mocked for tests. */  
                settingsModule,  
            resourcesToClose.add(persistentTasksClusterService);
                Build.CURRENT.hash(),  
            final UsageService usageService = new UsageService();
                ClusterName.CLUSTER_NAME_SETTING.get(tmpSettings).value(),  
                b.bind(TransportService.class).toInstance(transportService);
                tmpSettings,
                settingsModule.getClusterSettings(),
            final DiskThresholdMonitor diskThresholdMonitor = new DiskThresholdMonitor(
                b.bind(ShardLimitValidator.class).toInstance(shardLimitValidator);
                ingestServiceReference::get,  
                clusterModule.getAllocationService(),
        TransportService transportService = injector.getInstance(TransportService.class);  
            // in this file. Server has no compile-time dependency on arrow-base.  
    private NodeCacheService nodeCacheService;  
        // we load the global state here (the persistent part of the cluster state stored on disk) to
    }  
        TaskResourceTrackingService taskResourceTrackingService = injector.getInstance(TaskResourceTrackingService.class);
                b.bind(DataFormatRegistry.class).toInstance(dataFormatRegistry);
    }
        for (Path path : paths) {  
                        .toInstance(new PeerRecoverySourceService(transportService, indicesService, recoverySettings));
        try {
        Property.Deprecated,
        Settings settings,
 * Modifications Copyright OpenSearch Contributors. See
            if (FeatureFlags.isEnabled(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)) {  
        logger.info("stopping ...");
                pluginsService.filterPlugins(ActionPlugin.class).stream().flatMap(p -> p.getTaskHeaders().stream()),  
            final ScriptService scriptService = newScriptService(settings, scriptModule.engines, scriptModule.contexts);  
    public static final Setting<String> NODE_SEARCH_CACHE_SIZE_SETTING = new Setting<>(
            // rejected at creation cannot be introduced later through PUT _mapping.
    private final NodeClient client;
                throw new IllegalArgumentException(key + " cannot have leading or trailing whitespace " + "[" + value + "]");
        toClose.add(injector.getInstance(IndicesStore.class));
        }
                b.bind(FsHealthService.class).toInstance(fsHealthService);
                metadataIndexUpgradeService,
                remoteDirectoryFactory,  
            final AwarenessReplicaBalance awarenessReplicaBalance = new AwarenessReplicaBalance(  
            }
import java.util.Locale;
                threadPool,
                }
                throw new IllegalArgumentException("indices.breaker.type must be one of [hierarchy, none] but was: " + s);
                remoteClusterStateCleanupManager = remoteClusterStateService.getCleanupManager();  
import org.opensearch.indices.replication.SegmentReplicationSourceFactory;
                        tracerFactory = new TracerFactory(telemetrySettings, telemetryModule.getTelemetry(), threadPool.getThreadContext());
                            plugin -> plugin.getClass().getCanonicalName(),  
import org.opensearch.cluster.ClusterModule;
                            searchRequestSlowLog,
     * has been initialized to include the hostname. If this field were static, then it would be initialized when the
                    b.bind(StreamSearchTransportService.class).toInstance(streamSearchTransportService.get());
import org.opensearch.common.network.NetworkService;  
            )  
            pluginsService.filterPlugins(IndexStorePlugin.class)
import org.opensearch.cluster.applicationtemplates.SystemTemplatesService;
                    )  
                indicesService  
            "discovery.initial_state_timeout",  
                    b.bind(BlockCacheRegistry.class).toProvider(Providers.of(null));  
                    directoryFactories.put(k, v);
        toClose.add(() -> stopWatch.start("node_service"));
     * Creates a new {@link CircuitBreakerService} based on the settings provided.  
            pluginsService.filterPlugins(IndexStorePlugin.class)
import org.opensearch.cluster.NodeConnectionsService;
        }
                segmentReplicator::startReplication,  
            return this;  
import org.opensearch.plugins.SearchPipelinePlugin;
                    ClusterModule.getNamedXWriteables().stream()
            );
            if (FeatureFlags.isEnabled(TELEMETRY)) {
                        settingsModule,
import org.opensearch.index.store.IndexStoreListener;
                        .toInstance(new SegmentReplicationSourceService(indicesService, transportService, recoverySettings));
import org.opensearch.wlm.WorkloadManagementSettings;
        injector.getInstance(SnapshotShardsService.class).stop();
                    clusterService.getClusterSettings(),  
                ingestService,
import org.opensearch.action.search.SearchRequestStats;
                .map(IndexStorePlugin::getStoreFactories)
                                recoverySettings,
                pluginsService.filterPlugins(SearchPipelinePlugin.class),
            : "transportService has a different local node than the factory provided";
            ActionModule actionModule = new ActionModule(
                environment,
            // Ensure feature flags from opensearch.yml are valid during plugin initialization.
        assert clusterService.localNode().equals(localNodeFactory.getNode())
            transportService,  
        toClose.add(injector.getInstance(FsHealthService.class));
                pluginAdditionalHealthPaths
        "node.local_storage",  
            // service needs access to the existing shards allocators (e.g. the GatewayAllocator, ShardsBatchGatewayAllocator) which  
    /**
            return new HierarchyCircuitBreakerService(settings, breakerSettings, clusterSettings);
            );
            // collect engine factory providers from plugins
                .map(Optional::get);
        WorkloadGroupService workloadGroupService  
                        throw new IllegalStateException(
        Collection<ConcurrentSearchRequestDecider.Factory> concurrentSearchDeciderFactories,
import org.opensearch.index.IndexingPressureService;  
        runnableTaskListener.set(taskResourceTrackingService);
        if (!lifecycle.moveToStarted()) {
                    b.bind(FileCache.class).toProvider(Providers.of(null));
            // into the allocator so it can make over-commit admission decisions when a native pool is  
                repositoryService,
        toClose.add(() -> stopWatch.stop().start("fsHealth"));  
            ).stream().map(Plugin::getIndexTemplateMetadataUpgrader).collect(Collectors.toList());
    private static class LocalNodeFactory implements Function<BoundTransportAddress, DiscoveryNode> {  
                remoteStorePinnedTimestampService = null;
                settingsUpgraders  
            final RestController restController = actionModule.getRestController();
                nodeEnvironment = new NodeEnvironment(
        "node.remote_cluster_client",
            final MetaStateService metaStateService = new MetaStateService(nodeEnvironment, xContentRegistry);
        injector.getInstance(ResourceUsageCollectorService.class).start();  
                        metricsRegistryFactory = new NoopMetricsRegistryFactory();
 */
                searchTransportService,  
    public Client client() {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
     * Default returns its input unchanged. Test-framework subclasses (e.g.  
    protected void validateNodeBeforeAcceptingRequests(  
            );
                        client,  
                indicesModule.getNamedWriteables().stream(),
            final WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(
                responseCollectorService,  
                b.bind(PluginsService.class).toInstance(pluginsService);  
     */
                    @Override
            settings,  
            threadPool.registerClusterSettingsListeners(settingsModule.getClusterSettings());
import org.opensearch.common.util.PageCacheRecycler;  
            stc.stop();
                        .filter(a -> TelemetryAwarePlugin.class.isAssignableFrom(a.getClass()))  
                clusterService.getClusterSettings(),  
                settings,
                )
     * Delegates to {@link NodeCacheService} which owns the FileCache lifecycle.
                logger.info("JVM home [{}], using bundled JDK/JRE [{}]", System.getProperty("java.home"), jvmInfo.getUsingBundledJdk());
            if (customNameResolver != null) {
        if (WRITE_PORTS_FILE_SETTING.get(settings())) {  
            injector.getInstance(MetadataUpgrader.class),
import org.opensearch.Version;
                }
            return this;
     * and before the network service starts accepting incoming network
                transportService,
            // Add the telemetryAwarePlugin components to the existing pluginComponents collection.
                // Covers ENOSPC, read-only filesystem, etc. The reason() field, when present, is
                resourcesToClose.add(remoteStorePinnedTimestampService);
            additionalSettings.add(NODE_DATA_SETTING);  
                Constants.OS_ARCH,
                segmentReplicator::getSegmentReplicationStats,
            final ThreadPool threadPool = new ThreadPool(settings, runnableTaskListener, executorBuilders.toArray(new ExecutorBuilder[0]));
            );
                    settings,
                snapshotShardsService,  
 */  
            NamedXContentRegistry xContentRegistry = new NamedXContentRegistry(
                return ByteSizeValue.parseBytesSizeValue(capacityRaw, NODE_SEARCH_CACHE_SIZE_SETTING.getKey()).getBytes();  
        Tracer tracer  
import org.opensearch.cluster.metadata.TemplateUpgradeService;
            } else {
     */
                    environment,
                b.bind(SearchRequestStats.class).toInstance(searchRequestStats);
                Stream.of(
                systemIndices,  
                NativeAllocatorStatsRegistry::supplier
                        throw new IllegalStateException(  
                transportService,
     */
                b.bind(TransportNodesSnapshotsStatus.class).toInstance(nodesSnapshotsStatus);  
            resourcesToClose.add(nodeEnvironment);  
            pluginProfilers,  
    private static final Setting<Boolean> NODE_DATA_SETTING = Setting.boolSetting(
        boolean success = false;  
        // See https://issues.apache.org/jira/browse/LUCENE-7248. We call shutdownNow in
    private static Supplier<ActionConcurrencyLimiterStats> buildConcurrencyLimiterStatsSupplier(PluginsService pluginsService) {
    }
                .stream()
                clusterModule.getIndexNameExpressionResolver(),
            final RemoteStoreNodeService remoteStoreNodeService = new RemoteStoreNodeService(repositoriesServiceReference::get, threadPool);
            // collect ingestion consumer factory providers from plugins
                transportService.getTaskManager(),
                    networkService,
                clusterService.getClusterSettings(),
                    repositoriesServiceReference::get,  
            resourcesToClose.add(injector.getInstance(PeerRecoverySourceService.class));  
                        metricsRegistryFactory = new MetricsRegistryFactory(telemetrySettings, telemetryModule.getTelemetry());  
        @Override
            );
            taskResourceTrackingService,
                Plugin.class
                snapshotsInfoService,
                settings,
                    clusterService.getClusterApplierService(),  
                clusterService.getClusterSettings(),  
            if (jvmInfo.getBundledJdk()) {
                Set<Setting<?>> additionalSettings = new HashSet<>();
        final RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = injector.getInstance(
                taskResourceTrackingService,  
import org.opensearch.gateway.remote.RemoteClusterStateService;
                additionalSettingsFilter,
                .forEach(p -> p.getIndexCreationValidators().forEach(metadataCreateIndexService::addIndexCreationValidator));
        }
            WorkloadManagementTransportInterceptor workloadManagementTransportInterceptor = new WorkloadManagementTransportInterceptor(  
import org.opensearch.monitor.NodeRuntimeMetrics;  
                        )
                    p -> p.createComponents(
            }
        NodeClient client
            clusterService,
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,  
            }  
                && (Character.isWhitespace(value.charAt(0)) || Character.isWhitespace(value.charAt(value.length() - 1)))) {
            tracer = tracerFactory.getTracer();
    public static class CustomForkJoinWorkerThread extends ForkJoinWorkerThread {
                rerouteService,
            AnalysisModule analysisModule = new AnalysisModule(this.environment, pluginsService.filterPlugins(AnalysisPlugin.class));
                .collect(Collectors.toSet());
    /**
            final Optional<StreamTransportService> streamTransportService = streamTransport != null  
                registry,  
                b.bind(PersistentTasksClusterService.class).toInstance(persistentTasksClusterService);
        nodeService.getTaskCancellationMonitoringService().start();  
            resourcesToClose.add(tracer::close);  
            }
                remoteClusterStateCleanupManager = null;
                }
            }
import org.opensearch.indices.pollingingest.IngestionPayloadDecoderRegistry;
                    List<TelemetryPlugin> telemetryPlugins = pluginsService.filterPlugins(TelemetryPlugin.class);
import org.opensearch.action.ActionModule;
        FetchPhase fetchPhase,
                clusterPlugins,  
                circuitBreakerService,
        toClose.add(() -> stopWatch.stop().start("transport"));
import org.opensearch.indices.IndicesService;
        if (Assertions.ENABLED) {
                pluginsService.filterPlugins(RepositoryPlugin.class),
import org.opensearch.gateway.ShardsBatchGatewayAllocator;
                    @Override  
                remoteClusterStateService = null;
            }
                    initialEnvironment.configDir(),  
                } else {
                throw new IllegalStateException(  
            final PersistentTasksExecutorRegistry registry = new PersistentTasksExecutorRegistry(tasksExecutors);  
                clusterService,  
import org.opensearch.cluster.metadata.MetadataDataStreamsService;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
            TransportService transport = injector.getInstance(TransportService.class);
            pluginComponents.addAll(telemetryAwarePluginComponents);  
import org.opensearch.wlm.cancellation.MaximumResourceTaskSelectionStrategy;
import java.util.HashSet;
                searchModule.getNamedWriteables().stream(),
import org.opensearch.usage.UsageService;
                b.bind(NodeService.class).toInstance(nodeService);
        return capacityRaw;
            compositeDirectoryFactories.put("default", new DefaultCompositeDirectoryFactory());
                threadPool,
            );  
        toClose.add(() -> stopWatch.stop().start("resource_usage_tracker"));
        toClose.add(() -> stopWatch.stop().start("monitor"));  
import org.opensearch.identity.IdentityService;  
                classpathPlugins  
        }
                    pluginsService.filterPlugins(Plugin.class).stream().flatMap(p -> p.getNamedXContent().stream()),  
                workloadGroupService  
                clusterService,  
                    clusterModule.getAllocationService(),  
                indexingPressureService,
        if (stc != null) {  
                .map(Plugin::getRoles)
                .stream()
            });  
    }
                nativeAllocatorStatsSupplier,  
import org.opensearch.ingest.SystemIngestPipelineCache;
import org.opensearch.index.IndexSettings;
}
            new BootstrapContext(environment, onDiskMetadata),  
        );  
import org.opensearch.threadpool.ThreadPool;
            final List<Object> pluginComponents = new ArrayList<>();
            // Block-cache providers discovered once, reused for budget, registration, and capacity.
import org.opensearch.wlm.listeners.WorkloadGroupRequestOperationListener;  
import org.opensearch.gateway.GatewayMetaState;  
        autoForceMergeManager.stop();
                        tracer,
import org.opensearch.plugin.stats.AnalyticsBackendTaskCancellationStats;
     */
            }
import org.opensearch.storage.tiering.WarmToHotTieringService;  
    private final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory;
            threadPool,
                );  
                    threadPool,  
            this.extensionsManager.initializeServicesAndRestHandler(
     * to ensure proper resource loading in worker threads.  
                    pluginComponentRegistry
                bigArrays,
            super(pool);
            }
                new FileCacheSettings(settings, clusterService.getClusterSettings())::getRemoteDataRatio,  
                settings,
        Property.Deprecated,
            final ThreadPool thread = injector.getInstance(ThreadPool.class);
            }
                nativeAllocator.addPoolGroupLimitListener(PoolGroup.INDEXING, newGroupLimit -> {  
                    nodeEnvironment,  
import org.opensearch.storage.common.tiering.TieringUtils;  
            return value;
        "node.attr.",
                dataFormatRegistry
        injector.getInstance(NodeResourceUsageTracker.class).start();
                } catch (IllegalArgumentException e) {
                Map.copyOf(dataFormatAwareStoreDirectoryFactories),
                b.bind(Tracer.class).toInstance(tracer);
        BigArrays bigArrays,  
import org.opensearch.cluster.coordination.PersistedStateRegistry;
                ProcessProbe.getInstance(),
            nativeAllocatorStatsRegistry.ifPresent(
                metricsRegistryFactory = new NoopMetricsRegistryFactory();
                pluginsService.filterPlugins(RestoreListenerPlugin.class)
import static org.opensearch.common.util.FeatureFlags.BACKGROUND_TASK_EXECUTION_EXPERIMENTAL;
                    remoteStoreSettings
        final RemoteIndexPathUploader remoteIndexPathUploader = injector.getInstance(RemoteIndexPathUploader.class);
                    }
import org.opensearch.plugins.AnalysisPlugin;
        toClose.add(injector.getInstance(SnapshotShardsService.class));
            threadPool,  
        } finally {
        );  
import org.opensearch.plugins.CryptoKeyProviderPlugin;
     */
                );  
            modules.add(b -> {
                settings,
                nodeCacheService.registerProviders(blockCacheProviders);  
     * regular {@link TransportService} and {@link StreamTransportService}.
                threadPool,
    /**  
            final WorkloadGroupsStateAccessor workloadGroupsStateAccessor = new WorkloadGroupsStateAccessor();
import org.opensearch.telemetry.tracing.NoopTracerFactory;
                } else {
import org.opensearch.indices.recovery.PeerRecoverySourceService;
     * class initializer runs. Alas, this happens too early, before logging is initialized as this class is referred to  
            final Map<String, IndexStorePlugin.StoreFactory> storeFactories = pluginsService.filterPlugins(IndexStorePlugin.class)  
            RemoteStoreNodeService remoteStoreNodeService
import org.opensearch.cluster.deployment.DeploymentManagerService;  
            TracerFactory tracerFactory;
                .collect(toList());  
                admissionControlService,
                String reason = e.getReason() != null ? e.getReason() : e.getMessage();
            final Set<DiscoveryNodeRole> additionalRoles = pluginsService.filterPlugins(Plugin.class)  
                Constants.OS_NAME,
            final ScriptModule scriptModule = new ScriptModule(settings, pluginsService.filterPlugins(ScriptPlugin.class));
                .stream()  
                b.bind(MetricsRegistry.class).toInstance(metricsRegistry);
import org.opensearch.common.util.io.IOUtils;
    public FileCache fileCache() {  
        Path portsFile = environment.logsDir().resolve(type + ".ports");
        for (DiscoveryPlugin discoveryPlugin : discoveryPlugins) {  
        toClose.add(() -> injector.getInstance(ThreadPool.class).shutdown());  
                .map(plugin -> plugin.getCircuitBreaker(settings))  
                    }
        );  
        );  
                clusterManagerMetrics,
import org.opensearch.plugins.DiscoveryPlugin;
            localNode.set(discoveryNode);
            final MonitorService monitorService = new MonitorService(settings, threadPool, fsServiceProvider);
        toClose.add(() -> stopWatch.stop().start("gateway_meta_state"));
                    .stream()
                .flatMap(m -> m.entrySet().stream())  
            TopNSearchTasksLogger taskConsumer = new TopNSearchTasksLogger(settings, settingsModule.getClusterSettings());
            CacheModule cacheModule = new CacheModule(pluginsService.filterPlugins(CachePlugin.class), settings);
import org.opensearch.indices.replication.checkpoint.RemoteStorePublishMergedSegmentAction;
            );
                if (nodeCacheService != null) {  
        return streamTransport;  
        return this.environment.settings();
            final boolean clusterless = clusterPlugins.stream().anyMatch(ClusterPlugin::isClusterless);  
        injector.getInstance(SegmentReplicationTargetService.class).start();  
                pluginsService.filterPlugins(NativeRemoteObjectStoreProvider.class)
        private LocalNodeFactory(Settings settings, String persistentNodeId) {
        }, Property.NodeScope)  
            injector.getInstance(PersistedStateRegistry.class),
            }  
        injector.getInstance(ResourceUsageCollectorService.class).stop();
                b.bind(RemoteStorePinnedTimestampService.class).toProvider(() -> remoteStorePinnedTimestampService);
        StreamTransportService stc = injector.getInstance(StreamTransportService.class);
        injector.getInstance(RepositoriesService.class).start();
            final FsServiceProvider fsServiceProvider = new FsServiceProvider(
import org.opensearch.index.compositeindex.CompositeIndexSettings;  
            this.pluginsService = new PluginsService(
                assert nodeMetadata != null;  
            // Register the index creation validators for mapping updates as well, so a mapping  
                                "Telemetry plugins %s should not implement TelemetryAwarePlugin interface",  
import org.opensearch.index.store.remote.filecache.NodeCacheServiceCleaner;  
            final ClusterManagerMetrics clusterManagerMetrics = new ClusterManagerMetrics(metricsRegistry);  
            );  
            resourcesToClose.add(circuitBreakerService);
                InetAddress inetAddress = InetAddress.getByName(address.getAddress());
        pluginLifecycleComponents.forEach(LifecycleComponent::start);
     */  
        RemoteClusterService.ENABLE_REMOTE_CLUSTERS,  
import org.opensearch.core.common.breaker.CircuitBreaker;  
            remoteIndexPathUploader.start();  
        configureNodeAndClusterIdStateListener(clusterService);
                analysisModule.getAnalysisRegistry(),
                nodeEnvironment,  
            this.settings = settings;
 * this work for additional information regarding copyright
            logger.info("initialized");  
            final PersistentTasksClusterService persistentTasksClusterService = new PersistentTasksClusterService(
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;  
                b.bind(SegmentReplicationStatsTracker.class).toInstance(segmentReplicationStatsTracker);
                b.bind(SnapshotsService.class).toInstance(snapshotsService);
        // Don't call shutdownNow here, it might break ongoing operations on Lucene indices.
import org.opensearch.tasks.TaskResultsService;
                b.bind(NodeClient.class).toInstance(client);
            final StreamNodeConnectionsService streamNodeConnectionsService = injector.getInstance(StreamNodeConnectionsService.class);
import org.opensearch.common.UUIDs;
            );  
                    threadPool,  
            }
import java.nio.file.NoSuchFileException;
        toClose.add(() -> stopWatch.stop().start("search"));
            queryPhase,
     */
            final DeploymentManagerService deploymentManagerService = new DeploymentManagerService(clusterService, rerouteService);  
                taskManagerClientOptional.ifPresent(value -> b.bind(TaskManagerClient.class).toInstance(value));
                Files.write(probe, "boot".getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE_NEW);
                workloadGroupService  
            concurrentSearchDeciderFactories,
import org.opensearch.transport.Transport;
 *
    }
            pluginsService.filterPlugins(IngestionConsumerPlugin.class)  
        clusterService.start();
     */
                threadPool,
        List<BreakerSettings> breakerSettings,
                .distinct()
                b.bind(NamedXContentRegistry.class).toInstance(xContentRegistry);
                deprecationLogger.deprecate(
        injector.getInstance(WorkloadGroupService.class).start();
import org.opensearch.cluster.ClusterInfoService;  
import org.opensearch.common.cache.service.CacheService;
    private static final Setting<Boolean> NODE_MASTER_SETTING = Setting.boolSetting(
                    "version [{}] is a pre-release version of OpenSearch and is not suitable for production",
                NODE_NAME_SETTING.get(tmpSettings),
                    b.bind(StreamSearchTransportService.class).toProvider((Providers.of(null)));  
     * Pre-flight write probe for plugin-supplied {@link FsHealthService} paths. Throws
                    initialEnvironment.logsDir(),
        if (remoteIndexPathUploader != null) {
            final SegmentReplicator segmentReplicator = new SegmentReplicator(threadPool);
    }  
import org.opensearch.tasks.TaskCancellationService;
import java.util.Set;  
            clusterService.addStateApplier(scriptService);
import org.opensearch.OpenSearchParseException;  
                b.bind(PersistentTasksService.class).toInstance(persistentTasksService);  
        if (FeatureFlags.isEnabled(TELEMETRY)) {
            final Set<Setting<?>> consistentSettings = settingsModule.getConsistentSettings();  
                scriptService,  
                workloadManagementTransportInterceptor
import org.apache.logging.log4j.LogManager;
                identityService,
            }
        }  
import org.opensearch.indices.pollingingest.XContentIngestionPayloadDecoder;  
            // register the node.data, node.ingest, node.master, node.remote_cluster_client settings here so we can mark them private
import org.opensearch.plugins.TaskManagerClientPlugin;
            );
        injector.getInstance(HttpServerTransport.class).start();
import org.opensearch.plugins.FieldFilterProvider;
            // BlockCaches are active). On hot nodes there is nothing to clean up.  
            }  
            transportService.getTaskManager().registerTaskResourceConsumer(taskConsumer);
            writePortsFile("http", http.boundAddress());
import org.opensearch.action.search.SearchTransportService;  
                repositoriesServiceReference::get,
                        threadPool,
        toClose.add(injector.getInstance(HttpServerTransport.class));
    }
                throw new IllegalStateException(
                b.bind(RemoteStoreStatsTrackerFactory.class).toInstance(remoteStoreStatsTrackerFactory);
        toClose.add(nodeService.getTaskCancellationMonitoringService());
                        + " and "
                    // do not allow any plugin-provided index store type to conflict with a built-in type
            final Map<String, org.opensearch.plugins.BlockCacheProvider> blockCacheProviders = pluginsService.filterPlugins(
                b.bind(MergedSegmentPublisher.class).asEagerSingleton();  
             * Create the environment based on the finalized view of the settings. This is to ensure that components get the same setting
            final DiscoveryNode discoveryNode = DiscoveryNode.createLocal(  
import org.opensearch.index.autoforcemerge.AutoForceMergeManager;
            final SettingsModule settingsModule = new SettingsModule(
            // We allocate copies of existing shards by looking for a viable copy of the shard in the cluster and assigning the shard there.  
        toClose.add(() -> stopWatch.stop().start("node_environment"));
                remoteClusterStateService = new RemoteClusterStateService(  
                clusterInfoService::getClusterInfo,
                    workloadGroupsStateAccessor
            rerouteServiceReference.set(rerouteService);
     * @param boundTransportAddress the network addresses the node is
        toClose.add(injector.getInstance(Discovery.class));
    public static final Setting<String> NODE_NAME_SETTING = Setting.simpleString("node.name", Property.NodeScope);
                .findFirst()  
import org.opensearch.monitor.os.OsProbe;
import org.opensearch.telemetry.metrics.NoopMetricsRegistryFactory;
                namedWriteableRegistry,
        ConcurrencyLimiterStatsPlugin provider = providers.getFirst();  
import org.opensearch.cluster.metadata.AliasValidator;
            final MetadataCreateDataStreamService metadataCreateDataStreamService = new MetadataCreateDataStreamService(
     * Custom ForkJoinWorkerThread that preserves the context ClassLoader of the creating thread
                new SystemIngestPipelineCache()  
    private final NodeService nodeService;
 */  
            return Math.round(totalSpace * ratioValue.getAsRatio());  
import org.opensearch.cluster.ClusterManagerMetrics;
        );
        }
                segmentReplicationStatsTracker,
import org.opensearch.node.resource.tracker.NodeResourceUsageTracker;
    );  
import static org.opensearch.index.ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED_ATTRIBUTE_KEY;
import org.opensearch.index.store.DefaultCompositeDirectoryFactory;
                dataFormatRegistry  
import java.util.concurrent.CountDownLatch;
        toClose.add(injector.getInstance(NodeEnvironment.class));  
            );  
                workloadGroupService
import org.opensearch.plugins.CircuitBreakerPlugin;
            RemoteStoreRestoreService remoteStoreRestoreService = new RemoteStoreRestoreService(
    PageCacheRecycler createPageCacheRecycler(Settings settings) {  
import org.opensearch.cluster.routing.allocation.DiskThresholdMonitor;
                    }
     * The {@link PluginsService} used to build this node's components.
            ClusterState clusterState = clusterService.state();
                    environment,
        clusterService.getClusterManagerService().setClusterStatePublisher(discovery);  
        public DiscoveryNode apply(BoundTransportAddress boundTransportAddress) {
 * software distributed under the License is distributed on an
            final SearchTransportService searchTransportService = new SearchTransportService(
import org.opensearch.action.search.SearchRequestSlowLog;  
            pluginsService.filterPlugins(Plugin.class)  
            final ResourceUsageCollectorService resourceUsageCollectorService = new ResourceUsageCollectorService(
            if (isRemoteStoreAttributePresent(settings)) {
            );
    /**
            final DefaultPluginComponentRegistry pluginComponentRegistry = new DefaultPluginComponentRegistry();
import org.opensearch.cluster.metadata.MetadataMappingService;  
                        scriptService,
        }  
        }  
            );
            final ResourceWatcherService resourceWatcherService = new ResourceWatcherService(settings, threadPool);
                .forEach(plugin -> ingestionConsumerFactories.putAll(plugin.getIngestionConsumerFactories()));
import java.util.Arrays;
import org.opensearch.indices.IndicesModule;
                b.bind(SearchPipelineService.class).toInstance(searchPipelineService);
            final SearchBackpressureSettings searchBackpressureSettings = new SearchBackpressureSettings(
/*  
            }
                ),  
        // Close plugins in reverse dependency order so dependents release resources before
            }
     * Wait for this node to be effectively closed.
            final NetworkService networkService = new NetworkService(
                this.environment,
        assert transportService.getLocalNode().equals(localNodeFactory.getNode())  
        protected final Settings settings;  
import org.opensearch.arrow.spi.PoolGroup;
            final List<Path> pluginAdditionalHealthPaths = pluginsService.filterPlugins(Plugin.class)
            }
                client,  
                logger.debug(
            }
                .collect(Collectors.toList());  
        transportService.getTaskManager().setTaskResourceTrackingService(taskResourceTrackingService);
import org.opensearch.plugins.Plugin;
import org.opensearch.common.settings.Setting;  
        }
import org.opensearch.action.update.UpdateHelper;  
             * values, no matter they ask for them from.
        discovery.start(); // start before cluster service so that it can set initial state on ClusterApplierService
            if (BootstrapSettings.SERIAL_FILTER_SETTING.get(settings)) {
            final WorkloadGroupService workloadGroupService = new WorkloadGroupService(  
 * not use this file except in compliance with the License.
                threadPool
    /**  
            modules.add(new GatewayModule());  
            );  
import org.opensearch.action.ActionModule.DynamicActionRegistry;
    /**
                    e
    }  
            final NetworkModule networkModule = new NetworkModule(
                .collect(Collectors.toList());
                logger.debug("waiting to join the cluster. timeout [{}]", initialStateTimeout);  
import org.opensearch.wlm.WorkloadGroupsStateAccessor;
            mergedSegmentWarmerFactory = new MergedSegmentWarmerFactory(transportService, recoverySettings, clusterService);
                stop();
                settingsModule.getClusterSettings(),  
            RemoteStorePinnedTimestampService.class  
        List<BootstrapCheck> bootstrapChecks  
    /**  
    private final PluginsService pluginsService;  
            // completes we trigger another reroute to try the allocation again. This means there is a circular dependency: the allocation
        final InternalClusterInfoService service = new InternalClusterInfoService(settings, clusterService, threadPool, client);
                taskResourceTrackingService,  
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.index.SegmentReplicationStatsTracker;
                "version[{}], pid[{}], build[{}/{}/{}], OS[{}/{}/{}], JVM[{}/{}/{}/{}]",
            injector = modules.createInjector();
                () -> clusterService.localNode().getId(),
                    TieringUtils.TIERED_COMPOSITE_INDEX_TYPE,
            pluginComponentRegistry.seal();  
     * Constructs a node  
            IndicesModule indicesModule = new IndicesModule(mapperPlugins);  
                indicesService,  
                remoteStoreSettings.getSegmentsPathFixedPrefix(),
                    namedWriteableRegistry,
        } catch (IOException e) {
                monitorService.fsService(),  
        Releasables.close(injector.getInstance(Client.class));
import org.opensearch.action.admin.cluster.snapshots.status.TransportNodesSnapshotsStatus;
        toClose.add(() -> stopWatch.stop().start("gateway"));  
    }  
     * too.  
            bigArrays,
            // When the rebalancer adjusts the effective limit of pools in the INDEXING group,  
                restController,
        }  
                        threadPool,
            }
                // the OS-level error string (e.g. "No space left on device").  
import java.util.concurrent.ForkJoinPool;  
        return client;
            }
import org.opensearch.wlm.WorkloadGroupService;  
                settings,
                settingsModule.getClusterSettings()
                this.environment,
                        tracer
        );  
     */
     * Note: Visible for testing  
import org.opensearch.indices.replication.SegmentReplicationTargetService;  
                searchModule.getFetchPhase(),
    }
                assert nodeMetadata.nodeId().equals(localNodeFactory.getNode().getId());
            tracer
            );
                b.bind(NodeResourceUsageTracker.class).toInstance(nodeResourceUsageTracker);  
                clusterService,
                actionModule,
import org.opensearch.plugins.RepositoryPlugin;
            RepositoriesModule repositoriesModule = new RepositoriesModule(
                pluginComponents.stream().forEach(p -> b.bind((Class) p.getClass()).toInstance(p));
            clusterService.addListener(service);
import org.opensearch.common.StopWatch;
                .stream()
            metricsRegistry = metricsRegistryFactory.getMetricsRegistry();
                    "no-jdk",  
                .stream()
 */
                clusterService.getClusterSettings(),
                );
        }  
import org.opensearch.http.HttpServerTransport;
    private final AtomicReference<RunnableTaskExecutionListener> runnableTaskListener;
import org.opensearch.plugins.IngestionConsumerPlugin;
import org.opensearch.plugins.TelemetryPlugin;  
            // adds the context to the DeprecationLogger so that it does not need to be injected everywhere  
import org.opensearch.search.SearchService;
    protected ClusterInfoService newClusterInfoService(
            );  
        "node.search.cache.size",  
    );  
import java.nio.file.StandardCopyOption;
     * <p>Visible for testing.  
            ModulesBuilder modules = new ModulesBuilder();
            if (logger.isDebugEnabled()) {  
            try {
    }
                namedWriteableRegistry,
        IndicesService indicesService,  
            final Map<String, IndexStorePlugin.CompositeDirectoryFactory> compositeDirectoryFactories = new HashMap<>();  
                    TelemetryModule telemetryModule = new TelemetryModule(telemetryPlugins, telemetrySettings);
    public NodeEnvironment getNodeEnvironment() {  
            final Supplier<NativeAllocatorPoolStats> nativeAllocatorStatsSupplier = nativeAllocatorStatsRegistry.map(
                monitorService.jvmService(),  
import org.opensearch.cluster.metadata.MetadataCreateDataStreamService;
            );  
import org.opensearch.core.common.transport.TransportAddress;  
                searchBackpressureSettings,
                    new SNIHostName(value);  
                tieredStoragePrefetchSettingsSupplier = () -> null;  
                Build.CURRENT.date(),
                Map.copyOf(directoryFactories),  
import org.opensearch.ratelimitting.admissioncontrol.AdmissionControlService;
            return () -> null;
        nodeConnectionsService.start();  
            if (clusterState.nodes().getClusterManagerNodeId() == null) {
                indicesService,  
        toClose.add(injector.getInstance(ScriptService.class));  
                settings,  
                nodeResourceUsageTracker,  
     * A client that can be used to execute actions (operations) against the cluster.
                .flatMap(List::stream)
            if (DiscoveryNode.isWarmNode(settings) == false) {
            );
                ingestionConsumerFactories,
    // If not, the hook that is added in Bootstrap#setup() will be useless:  
import org.opensearch.index.recovery.RemoteStoreRestoreService;
import org.opensearch.indices.RemoteStoreSettings;  
import java.util.Objects;
import org.opensearch.telemetry.metrics.MetricsRegistry;
                namedWriteableRegistry  
 * ownership. Elasticsearch licenses this file to you under  
     */  
import java.util.LinkedHashSet;  
        toClose.add(injector.getInstance(SegmentReplicationTargetService.class));
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                b.bind(AdmissionControlService.class).toInstance(admissionControlService);  
                throw new IllegalStateException("Plugin-supplied health path [" + path + "] is not writable: " + e.getMessage(), e);
    private final Collection<LifecycleComponent> pluginLifecycleComponents;  
        @Nullable Transport streamTransport,  
                logger.info("JVM home [{}]", System.getProperty("java.home"));
        // we should stop this last since it waits for resources to get released  
import org.opensearch.rest.RestController;
                taskHeaders,  
import org.opensearch.plugins.ScriptPlugin;  
                .filter(p -> p instanceof LifecycleComponent)
                transportInterceptors,
            Property.NodeScope
                responseCollectorService,
                assert false : e;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        injector.getInstance(IndicesClusterStateService.class).start();
        }
                threadPool,
            for (Plugin p : pluginsService.filterPlugins(Plugin.class)) {  
                b.bind(IngestService.class).toInstance(ingestService);
                b.bind(GatewayMetaState.class).toInstance(gatewayMetaState);
import org.opensearch.plugins.IdentityAwarePlugin;  
                .filter(Objects::nonNull)
        toClose.add(injector.getInstance(TransportService.class));
                pluginsService.filterPlugins(SystemIndexPlugin.class)
                                threadPool,
                streamTransport,
            pluginComponentRegistry.register(dataFormatRegistry);
import org.opensearch.transport.TransportInterceptor;  
import org.opensearch.common.settings.Setting.Property;
                .put(Client.CLIENT_TYPE_SETTING_S.getKey(), CLIENT_TYPE)
        injector.getInstance(SegmentReplicationSourceService.class).start();
    /**
            final TransportService transportService = newTransportService(
    /** Constructs a ClusterInfoService which may be mocked for tests. */  
            resourcesToClose.add(payloadDecoderRegistry);
import org.opensearch.threadpool.RunnableTaskExecutionListener;  
            additionalSettings.add(NODE_REMOTE_CLUSTER_CLIENT);  
            );  
            MetricsRegistryFactory metricsRegistryFactory;  
                b.bind(IndexingPressureService.class).toInstance(indexingPressureService);
import org.opensearch.monitor.MonitorService;
            );
            }
        if (remoteStorePinnedTimestampService != null) {
import org.opensearch.common.settings.SettingUpgrader;
    }
import org.opensearch.common.lifecycle.LifecycleComponent;  
        if (streamTransportService != null) {
            List<BreakerSettings> pluginCircuitBreakers = pluginsService.filterPlugins(CircuitBreakerPlugin.class)
                Files.deleteIfExists(probe);  
                remoteIndexPathUploader = new RemoteIndexPathUploader(
                b.bind(AggregationUsageService.class).toInstance(searchModule.getValuesSourceRegistry().getUsageService());
                threadPool,  
                secureSettingsFactories  
                );
        Property.Deprecated,
    /** Writes a file to the logs dir containing the ports for the given transport type */  
                threadPool,  
                discovery = new LocalDiscovery(transportService, clusterService.getClusterApplierService());  
        discovery.startInitialJoin();
import org.opensearch.transport.AuxTransport;
import org.opensearch.search.backpressure.SearchBackpressureService;
                settings,
     */  
import org.opensearch.cluster.action.shard.ShardStateAction;
import org.opensearch.index.engine.dataformat.DataFormatRegistry;  
                networkService,
        nodeService.getMonitorService().start();
        Property.NodeScope
                        environment,  
import org.opensearch.cluster.applicationtemplates.SystemTemplatesPlugin;  
                settings,  
            List<NamedWriteableRegistry.Entry> namedWriteables = Stream.of(
        toClose.add(injector.getInstance(NodeResourceUsageTracker.class));  
                boundTransportAddress.publishAddress(),
                final TelemetrySettings telemetrySettings = new TelemetrySettings(settings, settingsModule.getClusterSettings());
            if (consistentSettings.isEmpty() == false) {
import org.opensearch.telemetry.tracing.TracerFactory;
            );  
            Set<String> taskHeaders = Stream.concat(
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
     */
 * GitHub history for details.
            );
                .flatMap(List::stream)
                .stream()  
import static org.opensearch.common.util.FeatureFlags.TELEMETRY;
            assert localNode.get() != null;
                b.bind(Transport.class).toInstance(transport);
                clusterModule.getIndexNameExpressionResolver(),
                networkModule.getTransportInterceptor(),  
                clusterService,
                            )
                pluginComponents.addAll(components);  
            final List<PersistentTasksExecutor<?>> tasksExecutors = pluginsService.filterPlugins(PersistentTaskPlugin.class)  
        if (providers.isEmpty()) {  
                threadPool,
                    "Plugin-supplied health path [" + path + "] is not writable (permission denied): " + e.getMessage(),
                dynamicActionRegistry,  
                circuitBreakerService,
            } catch (IOException | RuntimeException e) {  
                bigArrays,  
    protected Transport wrapStreamTransport(@Nullable Transport streamTransport) {
            final AutoForceMergeMetrics autoForceMergeMetrics = new AutoForceMergeMetrics(metricsRegistry);
 * compatible open source license.
                );
    private final Lifecycle lifecycle = new Lifecycle();  
        true,  
/*
import org.opensearch.index.engine.EngineFactory;
                aliasValidator,  
     * and {@link #NODE_MASTER_SETTING} must also be false.  
        return this;
                analyticsTaskCancellationStatsSupplier  
                .ifPresent(supplier -> monitorService.memoryReportingService().setNativeStatsSupplier(supplier));
                scriptService
import org.opensearch.search.aggregations.support.AggregationUsageService;  
        switch (s) {  
            } catch (AccessDeniedException e) {  
            // NodeCacheServiceCleaner is only needed on warm nodes (where FileCache and
import org.opensearch.telemetry.TelemetryModule;  
import org.opensearch.transport.StreamTransportService;
        toClose.add(injector.getInstance(SearchService.class));  
                bigArrays,
    /**  
                clusterService,
                    e
                            plugin -> plugin.getSystemIndexDescriptors(settings)
                b.bind(PersistedClusterStateService.class).toInstance(lucenePersistedStateFactory);  
                        .collect(toList());
                IndexStorePlugin.class
            }
            final SearchBackpressureService searchBackpressureService = new SearchBackpressureService(
            final Transport transport = networkModule.getTransportSupplier().get();
            final SystemIndices systemIndices = new SystemIndices(systemIndexDescriptorMap);
                client,
        ScriptService scriptService,
                b.bind(ResourceWatcherService.class).toInstance(resourceWatcherService);
    /**
    @Nullable
                client
     */
            final TaskResourceTrackingService taskResourceTrackingService = new TaskResourceTrackingService(  
                nodeEnvironment.nodeId(),
            if (lifecycle.started()) {  
                        );
        logger.info("stopped");  
            );  
    private final Tracer tracer;  
                tieredStoragePrefetchSettings = null;
import org.opensearch.indices.store.IndicesStore;
                    b.bind(StreamTransportService.class).toInstance(streamTransportService.get());
import org.opensearch.cluster.ClusterName;  
                );
     * The settings that are used by this node. Contains original settings as well as additional settings provided by plugins.
                additionalSettings,
            pluginComponentRegistry.register(new FieldFilterProvider(indicesService.getFieldFilter()));  
            );
import org.opensearch.indices.cluster.IndicesClusterStateService;
                    b.bind(SegmentReplicationTargetService.class)
                clusterService,  
                remoteStoreSettings,  
                clusterService
        // start after transport service so the local disco is known  
                .build();
            );
            resourcesToClose.add(() -> ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));  
                for (Object component : components) {  
                        repositoriesServiceReference::get,
                searchModule.getPluginProfileMetricsProviders(),
                clusterInfoService,
        toClose.add(() -> stopWatch.stop().start("discovery"));
            clusterService,  
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;
                ClusterModule.getNamedWriteables().stream()
                }
                settings  
        transportService.start();
import org.opensearch.common.util.BigArrays;
     * Returns the {@link NodeEnvironment} instance of this node
                repositoryService,  
            );
        return new BigArrays(pageCacheRecycler, circuitBreakerService, CircuitBreaker.REQUEST);
                settings
                transport,  
        NodeAndClusterIdStateListener.getAndSetNodeIdAndClusterId(  
import java.io.BufferedWriter;
            this.persistentNodeId = persistentNodeId;  
            this.environment = new Environment(settings, initialEnvironment.configDir(), Node.NODE_LOCAL_STORAGE_SETTING.get(settings));
    }
        this.autoForceMergeManager.start();  
                dataFormatAwareStoreDirectoryFactories.put(
import java.nio.file.AccessDeniedException;
            List<IdentityAwarePlugin> identityAwarePlugins = pluginsService.filterPlugins(IdentityAwarePlugin.class);  
                )
                    new MaximumResourceTaskSelectionStrategy(),  
    public static final Setting.AffixSetting<String> NODE_ATTRIBUTES = Setting.prefixKeySetting(  
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
                clusterService,  
            final ClusterModule clusterModule = new ClusterModule(  
import java.nio.file.StandardOpenOption;
                pluginsService,
/**
    public boolean isClosed() {
                        streamTransport,
                b.bind(ThreadPool.class).toInstance(threadPool);
            if (value.length() > 0  
            injector.getInstance(RemoteStoreRestoreService.class)
                final CountDownLatch latch = new CountDownLatch(1);
            );
                b.bind(SearchTransportService.class).toInstance(searchTransportService);
                b.bind(RestoreService.class).toInstance(restoreService);
        @Override
import org.opensearch.common.settings.Settings;  
        if (lifecycle.closed() == false) {
                    additionalSettings.addAll(extAwarePlugin.getExtensionSettings());
import org.opensearch.bootstrap.BootstrapCheck;  
                b.bind(AnalysisRegistry.class).toInstance(analysisModule.getAnalysisRegistry());  
import java.util.function.UnaryOperator;  
import org.opensearch.plugins.ActionPlugin;
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
            final TaskCancellationMonitoringService taskCancellationMonitoringService = new TaskCancellationMonitoringService(
                actionModule.getActionFilters()
                .collect(Collectors.toList());
                try {
                dataFormatRegistry
            } catch (OpenSearchParseException ex) {
                .flatMap(m -> m.entrySet().stream())
            // so we might be late here already  
                .flatMap(p -> p.getAdditionalHealthPaths(settings).stream())  
                } catch (InterruptedException e) {
        private RemoteStoreVerifyingLocalNodeFactory(
        transportService.acceptIncomingRequests();  
                .filter(Optional::isPresent)
                    environment,
     */  
                clusterModule.getIndexNameExpressionResolver(),  
     */  
            return discoveryNode;  
                b.bind(AutoForceMergeManager.class).toInstance(autoForceMergeManager);  
                autoForceMergeMetrics
                );
        pluginsService.filterPlugins(ClusterPlugin.class).forEach(plugin -> plugin.onNodeStarted(clusterService.localNode()));  
            );  
import org.opensearch.gateway.remote.RemoteClusterStateCleanupManager;  
        validateNodeBeforeAcceptingRequests(
                b.bind(Environment.class).toInstance(this.environment);  
                );
                b.bind(CircuitBreakerService.class).toInstance(circuitBreakerService);
                taskCancellationMonitoringService,  
        final Metadata onDiskMetadata = gatewayMetaState.getPersistedState().getLastAcceptedState().metadata();  
            logger.info(
        toClose.add(stopWatch::stop);
                .register(XContentIngestionPayloadDecoder.NAME, XContentIngestionPayloadDecoder.Factory.INSTANCE);
                Files.delete(probe);
                if (telemetrySettings.isTracingFeatureEnabled() || telemetrySettings.isMetricsFeatureEnabled()) {  
            HttpServerTransport http = injector.getInstance(HttpServerTransport.class);  
                workloadGroupService,  
            pluginsService.filterPlugins(CircuitBreakerPlugin.class).forEach(plugin -> {
                transportService.getRemoteClusterService(),
            final SetOnce<RerouteService> rerouteServiceReference = new SetOnce<>();  
        }
                remoteStoreSettings,  
        // start streamTransportService before transportService so that transport service has access to publish address
 *    http://www.apache.org/licenses/LICENSE-2.0
        injector.getInstance(SearchService.class).stop();  
                    b.bind(StreamTransportService.class).toProvider((Providers.of(null)));  
                    searchModule.getNamedXContents().stream(),
    /**  
        }
            // need to be able to trigger a reroute, which needs to call into the allocation service. We close the loop here:
            final NativeAllocator nativeAllocator = pluginComponentRegistry.getComponent(NativeAllocator.class).orElse(null);
                    clusterManagerMetrics,
            // Register tiered factory for warm+format indices
                indicesService  
import java.util.List;
import org.opensearch.common.inject.Module;
                Constants.OS_VERSION,  
                settingsModule.getIndexScopedSettings(),
                clusterService,
                    .stream()  
                xContentRegistry,
            final AdmissionControlService admissionControlService = new AdmissionControlService(  
                metadataCreateIndexService,
                taskResourceTrackingService
                        clusterService,
    public static final Setting<String> BREAKER_TYPE_KEY = new Setting<>("indices.breaker.type", "hierarchy", (s) -> {
                pluginsService.filterPlugins(IngestPlugin.class),
                return s;  
        TaskResourceTrackingService taskResourceTrackingService,  
        try (BufferedWriter writer = Files.newBufferedWriter(tmpPortsFile, StandardCharsets.UTF_8)) {  
            }
        private final RemoteStoreNodeService remoteStoreNodeService;
                clusterService,
import org.opensearch.tasks.TaskCancellationMonitoringSettings;
            final MetadataDataStreamsService metadataDataStreamsService = new MetadataDataStreamsService(clusterService);  
            this.namedWriteableRegistry = namedWriteableRegistry;
                                indicesService,
import org.opensearch.indices.ShardLimitValidator;
                    Arrays.toString(initialEnvironment.dataFiles()),
import org.opensearch.indices.recovery.RecoverySettings;  
    @Override  
            );  
            RatioValue ratioValue = RatioValue.parseRatioValue(capacityRaw);
        Settings settings,
        }
                searchModule.getConcurrentSearchRequestDeciderFactories(),
    }
        "node.ingest",
                        new LocalNodeFactory(settings, nodeEnvironment.nodeId()),
            remoteClusterStateService.start();
        return new SearchService(
                    new TieredDirectoryFactory(tieredStoragePrefetchSettingsSupplier)
                                clusterService,  
                    }
                        clusterModule.getIndexNameExpressionResolver(),  
            ).stream().map(SearchBackEndPlugin::getAnalyticsBackendTaskCancellationStats).filter(Objects::nonNull).findFirst().orElse(null);
                clusterService,  
     * services are started but before the cluster service is started  
            clusterInfoService.addListener(diskThresholdMonitor::onNewInfo);
import org.opensearch.cluster.metadata.Metadata;
            );
                .forEach(
        injector.getInstance(SnapshotsService.class).start();  
                observer.waitForNextChange(new ClusterStateObserver.Listener() {
                    b.bind(FileCache.class).toInstance(fileCache);
                shardLimitValidator,
                remoteClusterStateService
        true,
                .stream()  
import org.opensearch.plugins.NetworkPlugin;
        return networkModule.getAuxServerTransportList();  
                pluginsService.filterPlugins(Plugin.class).stream().flatMap(p -> p.getNamedWriteables().stream()),  
                    ).toArray(SearchRequestOperationsListener[]::new)
                Runtime.version().toString()
import org.opensearch.common.logging.NodeAndClusterIdStateListener;  
            }
import org.opensearch.snapshots.InternalSnapshotsInfoService;
    }
                xContentRegistry,
import org.opensearch.indices.analysis.AnalysisModule;
        clusterService.addStateApplier(transportService.getTaskManager());
                    } else {
            systemTemplatesService.verifyRepositories();
            if (value.length() > 0 && "node.attr.server_name".equals(key)) {
import org.opensearch.plugins.PluginInfo;
                assert injector.getInstance(MetaStateService.class).loadFullState().v1().isEmpty();  
                new HashMap<>();  
                clusterService,  
        true,  
            List<TransportInterceptor> transportInterceptors = List.of(  
                    if (builtInDirectoryFactories.containsKey(k)) {
                IOUtils.closeWhileHandlingException(resourcesToClose);
            streamTransport,
            } catch (FileSystemException e) {
            // Register tiered storage directory factories
                rerouteServiceReference::get
import org.opensearch.snapshots.RestoreService;
        StreamTransportService streamTransportService = injector.getInstance(StreamTransportService.class);
                            searchRequestStats,  
import org.opensearch.cluster.service.ClusterService;  
            // (see IndicesService#doClose), close it here so factories don't leak.
                settings,
        }
                return;
import org.opensearch.common.Nullable;
                clusterService,
                Build.CURRENT.type().displayName(),
                shardLimitValidator,
import org.opensearch.transport.RemoteClusterService;  
                indicesService,
                taskCancellationMonitoringSettings,
        toClose.add(() -> stopWatch.stop().start("indices"));
                    new IndexStoreListener.CompositeIndexStoreListener(indexStoreListenerStream.collect(Collectors.toList()))
            default:
    /**
                    settings,  
 * this file be licensed under the Apache-2.0 license or a
                if (isRemoteDataAttributePresent(settings)) {
                    repositoriesServiceReference::get,  
            clusterService.addLocalNodeClusterManagerListener(systemTemplatesService);
            }
            );
                    b.bind(WarmToHotTieringService.class).asEagerSingleton();  
        assert onDiskMetadata != null : "metadata is null but shouldn't"; // this is never null
                tracer
                    indicesService.setNativeIndexBufferBytes((long) (newGroupLimit * 0.70));
            final WorkloadGroupRequestOperationListener workloadGroupRequestOperationListener = new WorkloadGroupRequestOperationListener(
                metadataCreateIndexService
 * specific language governing permissions and limitations
                b.bind(PersistentTasksExecutorRegistry.class).toInstance(registry);
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
            modules.add(indicesModule);
            final IngestionPayloadDecoderRegistry.Builder registryBuilder = IngestionPayloadDecoderRegistry.builder()
     * Base factory for creating DiscoveryNode instances during node initialization.
import org.opensearch.wlm.cancellation.WorkloadGroupTaskCancellationService;
