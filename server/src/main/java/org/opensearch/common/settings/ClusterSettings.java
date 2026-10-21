    );
import org.opensearch.transport.AuxTransport;
                SnapshotsService.MAX_CONCURRENT_SNAPSHOT_OPERATIONS_SETTING,
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING,
                SegmentReplicationPressureService.MAX_ALLOWED_STALE_SHARDS,
 *
import org.opensearch.cluster.routing.allocation.FileCacheThresholdSettings;
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING,
                RemoteStoreSettings.CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING,
                HttpTransportSettings.SETTING_HTTP_TCP_KEEP_IDLE,
                Environment.PATH_LOGS_SETTING,
                RemoteStorePressureSettings.UPLOAD_TIME_LAG_VARIANCE_FACTOR,
                IndicesQueryCache.INDICES_CACHE_QUERY_SIZE_SETTING,
import org.opensearch.cluster.action.index.MappingUpdatedAction;
import static org.opensearch.gateway.remote.RemoteIndexMetadataManager.INDEX_METADATA_UPLOAD_TIMEOUT_SETTING;
        @Override
                ),
                ForceMergeManagerSettings.AUTO_FORCE_MERGE_SCHEDULER_INTERVAL,
                if (loggerPredicate.test(key) && builder.keys().contains(key) == false) {
                TransportSettings.TCP_REUSE_ADDRESS_PROFILE,
                ClusterMergeSchedulerConfig.CLUSTER_MAX_THREAD_COUNT_SETTING,
 * not use this file except in compliance with the License.
import org.opensearch.wlm.WorkloadManagementSettings;
                FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING,
                TransportSettings.TCP_RECEIVE_BUFFER_SIZE,
                RemoteStoreSettings.CLUSTER_REMOTE_TRANSLOG_TRANSFER_TIMEOUT_SETTING,
                EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING,
        )
                RecoverySettings.INDICES_RECOVERY_INTERNAL_LONG_ACTION_TIMEOUT_SETTING,
                ResourceWatcherService.RELOAD_INTERVAL_MEDIUM,
                NativeMemoryBasedAdmissionControllerSettings.SEARCH_NATIVE_MEMORY_USAGE_LIMIT,
                IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING,
                SearchService.DEFAULT_SEARCH_TIMEOUT_SETTING,
import org.opensearch.common.breaker.ResponseLimitSettings;
                AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING,
                EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING,
                NoClusterManagerBlockService.NO_MASTER_BLOCK_SETTING,  // deprecated
import org.opensearch.transport.SniffConnectionStrategy;
                AuxTransport.AUX_TRANSPORT_TYPES_SETTING,
                RecoverySettings.INDICES_RECOVERY_CHUNK_SIZE_SETTING,
                }
                TransportSettings.TCP_KEEP_COUNT,
                ScriptService.SCRIPT_GENERAL_CACHE_SIZE_SETTING,
                MultiBucketConsumerService.MAX_BUCKET_SETTING,
import org.opensearch.common.logging.Loggers;
                RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_STATE_SYNC_SETTING,
                HttpTransportSettings.SETTING_HTTP_TCP_REUSE_ADDRESS,
                ShardsLimitAllocationDecider.CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING,
                ShardIndexingPressureMemoryManager.LOWER_OPERATING_FACTOR,
    public static List<SettingUpgrader<?>> BUILT_IN_SETTING_UPGRADERS = Collections.unmodifiableList(
                GatewayService.RECOVER_AFTER_TIME_SETTING,
                PageCacheRecycler.WEIGHT_LONG_SETTING,
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX,
    );
                SearchShardTaskSettings.SETTING_CPU_TIME_MILLIS_THRESHOLD,
                SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING,
                NativeMemoryService.REFRESH_INTERVAL_SETTING,
                JvmGcMonitorService.ENABLED_SETTING,
                SnapshotsService.MAX_SHARDS_ALLOWED_IN_STATUS_API,
                ClusterManagerService.CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING,
                DiscoveryModule.DISCOVERY_TYPE_SETTING,
                IoBasedAdmissionControllerSettings.INDEXING_IO_USAGE_LIMIT,
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_FLAT_SKEW_SETTING,
import org.opensearch.cluster.applicationtemplates.SystemTemplatesService;
                Environment.PATH_DATA_SETTING,
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
import org.opensearch.cluster.coordination.JoinHelper;
                NetworkModule.TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION_RESOLVE_HOST_NAME,
                SnapshotsService.SNAPSHOT_REPOSITORY_IO_TIMEOUT_SETTING,
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING,
                SearchService.SEARCH_MAX_QUERY_STRING_LENGTH,
                SearchShardTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD,
                IndicesService.CLUSTER_REPLICATION_TYPE_SETTING,
                IndexingMemoryController.INDEX_BUFFER_SIZE_SETTING,
                FsService.REFRESH_INTERVAL_SETTING,
                NetworkModule.TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION,
        final Predicate<String> loggerPredicate = Loggers.LOG_LEVEL_SETTING::match;
 *     http://www.apache.org/licenses/LICENSE-2.0
                        builder.put(key, Loggers.LOG_LEVEL_SETTING.getConcreteSetting(key).get(settings).toString());
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_WARM_DISK_THRESHOLD_ENABLED_SETTING,
                        builder.putNull(key);
                DiskThresholdSettings.INDEX_READ_BLOCK_AUTO_RELEASE_EXCLUDE_PATTERNS,
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
                ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING,
                RecoverySettings.INDICES_RECOVERY_MAX_CONCURRENT_OPERATIONS_SETTING,
                // Snapshot related Settings
                IngestService.MAX_NUMBER_OF_INGEST_PROCESSORS,
        private final Settings settings;
                TransportSettings.TCP_KEEP_IDLE_PROFILE,
            Settings.Builder builder = Settings.builder();
                ElectionSchedulerFactory.ELECTION_DURATION_SETTING,
import org.opensearch.gateway.remote.RemoteIndexMetadataManager;
                NetworkService.TCP_NO_DELAY,
import org.opensearch.cluster.service.ClusterService;
                SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE,
import org.opensearch.snapshots.InternalSnapshotsInfoService;
                Environment.PATH_HOME_SETTING,
import org.opensearch.rest.BaseRestHandler;
                RecoverySettings.INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING,
import org.opensearch.repositories.fs.FsRepository;
                HttpTransportSettings.SETTING_HTTP_MAX_WARNING_HEADER_SIZE,
        new HashSet<>(
                ProxyConnectionStrategy.PROXY_ADDRESS,
                OperationRouting.IGNORE_WEIGHTED_SHARD_ROUTING,
                BootstrapSettings.SERIAL_FILTER_SETTING,
                ClusterModule.SHARDS_ALLOCATOR_TYPE_SETTING,
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
                ResourceWatcherService.RELOAD_INTERVAL_LOW,
 * ownership. Elasticsearch licenses this file to you under
                }
                HttpTransportSettings.SETTING_PIPELINING_MAX_EVENTS,
import org.opensearch.cluster.ClusterModule;
 */
                IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING,
                ThreadContext.DEFAULT_HEADERS_SETTING,
import org.opensearch.search.streaming.FlushModeResolver;
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
                HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH,
                    if (Loggers.LOG_LEVEL_SETTING.getConcreteSetting(key).exists(settings) == false) {
                TransportSettings.HOST,
        }
                NativeMemoryBasedAdmissionControllerSettings.CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT,
                BlobStoreRepository.SNAPSHOT_SHARD_PATH_PREFIX_SETTING,
                BootstrapSettings.MEMORY_LOCK_SETTING,
                NodeRoleSettings.NODE_ROLES_SETTING,
import org.opensearch.discovery.HandshakingTransportAddressConnector;
import org.opensearch.index.compositeindex.CompositeIndexSettings;
                Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING,
                NodeEnvironment.NODE_ID_SEED_SETTING,
                FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING,
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
    }
                DestructiveOperations.REQUIRES_NAME_SETTING,
                ConcurrentRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_REBALANCE_SETTING,
import org.opensearch.transport.RemoteConnectionStrategy;
import org.opensearch.common.cache.CacheType;
                SearchService.CARDINALITY_AGGREGATION_PRUNING_THRESHOLD,
                InternalClusterInfoService.INTERNAL_CLUSTER_INFO_TIMEOUT_SETTING,
                AutoCreateIndex.AUTO_CREATE_INDEX_SETTING,
                ForceMergeManagerSettings.TRANSLOG_AGE_AUTO_FORCE_MERGE,
import org.opensearch.cluster.routing.OperationRouting;
                ShardsBatchGatewayAllocator.GATEWAY_ALLOCATOR_BATCH_SIZE,
                TransportSettings.OLD_TRANSPORT_COMPRESS,
                HttpTransportSettings.SETTING_HTTP_BIND_HOST,
                SearchIndexPruningSettings.ENABLED,
                assert loggerPredicate.test(key);
import org.opensearch.script.ScriptService;
                HttpTransportSettings.SETTING_HTTP_DETAILED_ERRORS_ENABLED,
                RemoteStoreStatsTrackerFactory.MOVING_AVERAGE_WINDOW_SIZE,
                ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING,
                BalancedShardsAllocator.ALLOCATOR_TIMEOUT_SETTING,
                // Settings to be used for limiting rest requests
                Node.NODE_ATTRIBUTES,
    public static Set<Setting<?>> BUILT_IN_CLUSTER_SETTINGS = Collections.unmodifiableSet(
                HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING,
            TelemetrySettings.TRACER_FEATURE_ENABLED_SETTING,
            Arrays.asList(
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                HttpTransportSettings.SETTING_CORS_ENABLED,
/*
                FlushModeResolver.STREAMING_MAX_ESTIMATED_BUCKET_COUNT,
                RecoverySettings.INDICES_PRIMARY_RESYNC_TIMEOUT_SETTING,
                TransportSearchAction.SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING,
                BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING,
                IndicesRequestCache.INDICES_CACHE_QUERY_SIZE,
import org.opensearch.transport.TransportSettings;
import org.opensearch.gateway.PersistedClusterStateService;
                ShardsBatchGatewayAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING,
                GLOBAL_METADATA_UPLOAD_TIMEOUT_SETTING,
import org.opensearch.index.remote.RemoteStorePressureSettings;
                TransportSettings.CONNECTIONS_PER_NODE_REG,
import org.opensearch.indices.ClusterMergeSchedulerConfig;
                TransportSettings.CONNECT_TIMEOUT,
import org.opensearch.monitor.jvm.JvmService;
                SearchService.MAX_AGGREGATION_REWRITE_FILTERS,
                ScriptService.SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING,
import org.opensearch.node.Node;
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING,
                Environment.PATH_REPO_SETTING,
 * @opensearch.api
                BootstrapSettings.SECURITY_FILTER_BAD_DEFAULTS_SETTING,
                IngestService.SYSTEM_INGEST_PIPELINE_ENABLED,
                OperationRouting.WEIGHTED_ROUTING_DEFAULT_WEIGHT,
import org.opensearch.transport.client.Client;
                BootstrapSettings.CTRLHANDLER_SETTING,
                HandshakingTransportAddressConnector.PROBE_HANDSHAKE_TIMEOUT_SETTING,
                IndexGraveyard.SETTING_MAX_TOMBSTONES,
                ResourceWatcherService.RELOAD_INTERVAL_HIGH,
                TaskCancellationMonitoringSettings.DURATION_MILLIS_SETTING,
                NodeDuressSettings.SETTING_NUM_SUCCESSIVE_BREACHES,
import org.opensearch.snapshots.SnapshotsService;
                IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING,
                WorkloadManagementSettings.QUERYGROUP_SERVICE_DURESS_STREAK_SETTING,
                ClusterService.USER_DEFINED_METADATA,
                // Settings related to Auto Force Merge Manager
                SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING, // deprecated
                NetworkService.TCP_KEEP_IDLE,
import org.opensearch.indices.IndicesQueryCache;
                ElectionSchedulerFactory.ELECTION_INITIAL_TIMEOUT_SETTING,
                DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING,
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
                NetworkService.TCP_RECEIVE_BUFFER_SIZE,
 * Licensed to Elasticsearch under one or more contributor
                HttpTransportSettings.SETTING_HTTP_TCP_KEEP_INTERVAL,
                SearchTaskSettings.SETTING_HEAP_PERCENT_THRESHOLD,
                MappingUpdatedAction.INDICES_MAPPING_DYNAMIC_TIMEOUT_SETTING,
                HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_TYPE_SETTING,
import org.opensearch.node.Node.DiscoverySettings;
                IndexingPressure.MAX_INDEXING_BYTES,
                RemoteStorePressureSettings.MIN_CONSECUTIVE_FAILURES_LIMIT,
import org.opensearch.monitor.fs.FsHealthService;
                NetworkModule.HTTP_TYPE_SETTING,
                SearchTaskSettings.SETTING_HEAP_VARIANCE_THRESHOLD,
            TelemetrySettings.TRACER_SAMPLER_PROBABILITY,
import org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider;
                IndicesFieldDataCache.INDICES_FIELDDATA_CACHE_SIZE_KEY,
                ForceMergeManagerSettings.AUTO_FORCE_MERGE_SETTING,
    }
                HttpTransportSettings.SETTING_HTTP_DETAILED_ERRORS_ENABLED,
                PublishCheckpointAction.PUBLISH_CHECK_POINT_RETRY_TIMEOUT,
import org.opensearch.ingest.IngestService;
import org.opensearch.gateway.GatewayService;
                // Setting related to refresh optimisations
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_FENCING_ENABLED,
                SearchService.QUERY_REWRITING_ENABLED_SETTING,
                RemoteRoutingTableBlobStore.CLUSTER_REMOTE_STORE_ROUTING_TABLE_PATH_PREFIX,
                NodeEnvironment.MAX_LOCAL_STORAGE_NODES_SETTING,
                CpuBasedAdmissionControllerSettings.INDEXING_CPU_USAGE_LIMIT,
 * the Apache License, Version 2.0 (the "License"); you may
                ProxyConnectionStrategy.REMOTE_SOCKET_CONNECTIONS,
import org.opensearch.index.ShardIndexingPressureMemoryManager;
import org.opensearch.tasks.consumer.TopNSearchTasksLogger;
import org.opensearch.common.util.FeatureFlags;
                TransportSettings.TCP_KEEP_INTERVAL_PROFILE,
                Reconfigurator.CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION,
                // Remote cluster state settings
import org.opensearch.monitor.jvm.HotThreads;
                RecoverySettings.INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_PART_SIZE_SETTING,
import org.opensearch.common.util.concurrent.ThreadContext;
                IoBasedAdmissionControllerSettings.SEARCH_IO_USAGE_LIMIT,
                SearchShardTaskSettings.SETTING_CANCELLATION_BURST,
                HttpTransportSettings.SETTING_HTTP_COMPRESSION,
                // Concurrent segment search settings
import org.opensearch.index.SegmentReplicationPressureService;
                ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT,
                SearchService.KEEPALIVE_INTERVAL_SETTING,
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_METADATA,
                SnapshotsService.SNAPSHOT_CLEANUP_RETRIES_SETTING,
 * license agreements. See the NOTICE file distributed with
                NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING,
                ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED,
                // Settings related to resource trackers
                ShardIndexingPressureMemoryManager.UPPER_OPERATING_FACTOR,
                RecoverySettings.INDICES_RECOVERY_MAX_CONCURRENT_FILE_CHUNKS_SETTING,
import org.opensearch.transport.ProxyConnectionStrategy;
                HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN,
                ClusterManagerTaskThrottler.BASE_DELAY_SETTINGS,
                SearchTaskSettings.SETTING_TOTAL_HEAP_PERCENT_THRESHOLD,
                // Related to monitoring of task cancellation
                SearchIndexPruningSettings.MIN_SHARDS,
import org.opensearch.index.ShardIndexingPressureSettings;
                INDEX_METADATA_UPLOAD_TIMEOUT_SETTING,
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING,
                HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH,
import org.opensearch.monitor.process.ProcessService;
        }
        @Override
                TieringUtils.FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT,
import org.opensearch.cluster.ClusterName;
                SearchBackpressureSettings.SETTING_CANCELLATION_BURST,   // deprecated
                    final String rootLevel = value.get(key);
import org.opensearch.cluster.NodeConnectionsService;
                NetworkModule.TRANSPORT_SSL_DUAL_MODE_ENABLED,
import org.opensearch.cluster.coordination.LeaderChecker;
            return current.filter(loggerPredicate).equals(previous.filter(loggerPredicate)) == false;
                InternalClusterInfoService.INTERNAL_CLUSTER_INFO_UPDATE_INTERVAL_SETTING,
                ResourceWatcherService.ENABLED,
                if ("_root".equals(component)) {
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED,
import org.opensearch.discovery.DiscoveryModule;
import org.opensearch.node.NodeRoleSettings;
                IndexSettings.QUERY_STRING_ANALYZE_WILDCARD,
                RecoverySettings.INDICES_TRANSLOG_CONCURRENT_RECOVERY_BATCH_SIZE,
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE),
 * this file be licensed under the Apache-2.0 license or a
                BalancedShardsAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING,
                HunspellService.HUNSPELL_IGNORE_CASE,
                RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING,
import org.opensearch.search.aggregations.MultiBucketConsumerService;
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING,
                BalancedShardsAllocator.PREFER_PRIMARY_SHARD_REBALANCE,
                IndexSettings.TIME_SERIES_INDEX_MERGE_POLICY,
                NodeDuressSettings.SETTING_NATIVE_MEMORY_LIMIT_LEGACY,
                Coordinator.PUBLISH_TIMEOUT_SETTING,
            }
                RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING,
                NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING,
                SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS,
                TransportSettings.TRACE_LOG_INCLUDE_SETTING,
                ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING,
import org.opensearch.action.support.AutoCreateIndex;
import org.opensearch.gateway.ShardsBatchGatewayAllocator;
import org.opensearch.indices.breaker.BreakerSettings;
                SegmentReplicationPressureService.SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED,
                TopNSearchTasksLogger.LOG_TOP_QUERIES_SIZE_SETTING,
                ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING,
                SearchTaskSettings.SETTING_CPU_TIME_MILLIS_THRESHOLD,
import org.opensearch.cluster.coordination.LagDetector;
                ResourceTrackerSettings.NODE_NATIVE_MEMORY_BUFFER_PERCENT_SETTING,
                TieringUtils.REPLICA_SYNC_TIMEOUT_SETTING,
                    } else {
                TransportSettings.PUBLISH_PORT_PROFILE,
                DiscoveryModule.ELECTION_STRATEGY_SETTING,
    public ClusterSettings(final Settings nodeSettings, final Set<Setting<?>> settingsSet) {
import org.opensearch.index.IndexSettings;
                SearchService.SEARCH_MAX_QUERY_NESTING_DEPTH,
                Environment.PATH_SHARED_DATA_SETTING,
                TransportSettings.CONNECTIONS_PER_NODE_PING,
                FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING,
                IndicesQueryCache.INDICES_CACHE_QUERY_COUNT_SETTING,
                SeedHostsResolver.DISCOVERY_SEED_RESOLVER_TIMEOUT_SETTING,
                IndexingMemoryController.MAX_NATIVE_INDEX_BUFFER_SIZE_SETTING,
                IndicesQueryCache.INDICES_QUERIES_CACHE_SKIP_CACHE_FACTOR,
                ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE,
                ShardIndexingPressureMemoryManager.NODE_SOFT_LIMIT,
                FilterAllocationDecider.CLUSTER_ROUTING_INCLUDE_GROUP_SETTING,
                SearchBackpressureSettings.SETTING_MODE,
                TransportSettings.PUBLISH_HOST,
                NodeDuressSettings.SETTING_HEAP_THRESHOLD,
                Environment.NODE_PIDFILE_SETTING,
                MergeSchedulerConfig.CLUSTER_MAX_FORCE_MERGE_MB_PER_SEC_SETTING,
import java.util.Map;
                SeedHostsResolver.LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_RESOLVE_TIMEOUT,
                String component = key.substring("logger.".length());
                FsHealthService.ENABLED_SETTING,
                // Thread pool Settings
                HttpTransportSettings.SETTING_HTTP_TCP_KEEP_ALIVE,
import org.opensearch.gateway.remote.model.RemoteRoutingTableBlobStore;
                HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_TYPE_SETTING,
        }
import org.opensearch.indices.IndexingMemoryController;
                ClusterFormationFailureHelper.DISCOVERY_CLUSTER_FORMATION_WARNING_TIMEOUT_SETTING,
                    Loggers.setLevel(LogManager.getLogger(component), value.get(key));
import org.opensearch.bootstrap.BootstrapSettings;
import org.opensearch.search.fetch.subphase.highlight.FastVectorHighlighter;
                SegmentReplicationPressureService.MAX_INDEXING_CHECKPOINTS,
 * You may obtain a copy of the License at
import java.util.function.Predicate;
import org.opensearch.cluster.InternalClusterInfoService;
 * Unless required by applicable law or agreed to in writing,
                ScriptService.SCRIPT_DISABLE_MAX_COMPILATIONS_RATE_SETTING,
                GatewayService.EXPECTED_DATA_NODES_SETTING,
import org.opensearch.gateway.remote.RemoteClusterStateService;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.tasks.TaskCancellationMonitoringSettings;
                PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_SETTING,
                CpuBasedAdmissionControllerSettings.SEARCH_CPU_USAGE_LIMIT,
                NetworkService.TCP_KEEP_INTERVAL,
                TransportSettings.PUBLISH_PORT,
                PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD,
                NetworkService.GLOBAL_NETWORK_PUBLISH_HOST_SETTING,
                StreamTransportService.STREAM_TRANSPORT_REQ_TIMEOUT_SETTING,
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING,
import java.util.Set;
                DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING,
 */
                HotThreads.MAX_HOT_THREADS_SNAPSHOTS_SETTING,
                ScriptService.SCRIPT_MAX_COMPILATIONS_RATE_SETTING,
                SearchShardTaskSettings.SETTING_CANCELLATION_RATE,
            builder.put(current.filter(loggerPredicate));
                ClusterName.CLUSTER_NAME_SETTING,
                ShardIndexingPressureSettings.SHARD_MIN_LIMIT,
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE,
                SearchShardTaskSettings.SETTING_TOTAL_HEAP_PERCENT_THRESHOLD,
                }
                SearchTaskSettings.SETTING_ELAPSED_TIME_MILLIS_THRESHOLD,
                TieringUtils.PREPARE_TIERING_TIMEOUT,
                ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS,
import org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings;
                HttpTransportSettings.SETTING_HTTP_TCP_SEND_BUFFER_SIZE,
                WorkloadManagementSettings.WLM_MODE_SETTING,
                ProxyConnectionStrategy.SERVER_NAME,
                HttpTransportSettings.SETTING_HTTP_REQUEST_ID_MAX_LENGTH,
                FsHealthService.HEALTHY_TIMEOUT_SETTING,
                SearchShardTaskSettings.SETTING_HEAP_PERCENT_THRESHOLD,
import org.opensearch.indices.IndicesService;
import org.opensearch.action.support.replication.TransportReplicationAction;
import org.opensearch.index.ShardIndexingPressureStore;
import org.apache.logging.log4j.LogManager;
                RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT,
import org.opensearch.action.search.pruning.SearchIndexPruningSettings;
                WorkloadManagementSettings.QUERYGROUP_SERVICE_RUN_INTERVAL_SETTING,
import org.opensearch.cluster.service.ClusterApplierService;
                LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING,
                    continue;
                // Tiered caching settings
            }
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING,
                BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING,
 */
                Client.CLIENT_TYPE_SETTING_S,
                ThreadPool.CLUSTER_THREAD_POOL_SIZE_SETTING,
                RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_MAX_BYTES_PER_SEC_SETTING,
                FlushModeResolver.STREAMING_MIN_CARDINALITY_RATIO,
                DiskThresholdSettings.CLUSTER_CREATE_INDEX_BLOCK_AUTO_RELEASE,
                // WorkloadManagement settings
                IoBasedAdmissionControllerSettings.IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE,
                ForceMergeManagerSettings.SEGMENT_COUNT_FOR_AUTO_FORCE_MERGE,
                NetworkService.TCP_KEEP_COUNT,
import org.opensearch.node.remotestore.RemoteStoreNodeService;
                HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_OVERHEAD_SETTING,
                RemoteClusterService.REMOTE_NODE_ATTRIBUTE,
                RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING,
                RemoteClusterStateService.REMOTE_STATE_READ_TIMEOUT_SETTING,
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING,
                FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_THRESHOLD_ENABLED_SETTING,
                ShardsBatchGatewayAllocator.PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING,
import java.util.Collections;
                StreamSearchTransportService.STREAM_SEARCH_ENABLED,
import org.opensearch.index.MergeSchedulerConfig;
                TransportSettings.OLD_TCP_RECEIVE_BUFFER_SIZE_PROFILE,
        )
import org.opensearch.monitor.memory.NativeMemoryService;
                SearchShardTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE,
                ClusterMergeSchedulerConfig.CLUSTER_MAX_MERGE_COUNT_SETTING,
                SegmentReplicationPressureService.MAX_REPLICATION_TIME_BACKPRESSURE_SETTING,
                SearchService.MAX_KEEPALIVE_SETTING,
import org.opensearch.action.search.TransportSearchAction;
                TransportSettings.TCP_REUSE_ADDRESS,
                SearchService.ALLOW_EXPENSIVE_QUERIES,
        List.of(
    private static final class LoggingSettingUpdater implements SettingUpdater<Settings> {
                ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING,
                ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING,
                TransportSettings.CONNECTIONS_PER_NODE_BULK,
                SystemTemplatesService.SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED,
                HttpTransportSettings.SETTING_HTTP_TRACE_LOG_INCLUDE,
                TransportSettings.CONNECTIONS_PER_NODE_STATE,
                HttpTransportSettings.SETTING_HTTP_TCP_RECEIVE_BUFFER_SIZE,
                IndicesService.INDICES_ID_FIELD_DATA_ENABLED_SETTING,
                HttpTransportSettings.SETTING_HTTP_TRACE_LOG_EXCLUDE,
                RecoverySettings.INDICES_RECOVERY_INTERNAL_ACTION_TIMEOUT_SETTING,
                ),
                CpuBasedAdmissionControllerSettings.CLUSTER_ADMIN_CPU_USAGE_LIMIT,
                SniffConnectionStrategy.REMOTE_CLUSTER_EXPECTED_NAME,
                Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING,
                METADATA_MANIFEST_UPLOAD_TIMEOUT_SETTING,
import org.opensearch.action.search.CreatePitController;
import org.opensearch.cluster.metadata.IndexGraveyard;
                BlobStoreRepository.SNAPSHOT_REPOSITORY_DATA_CACHE_THRESHOLD,
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING,
 * The OpenSearch Contributors require contributions made to
                    }
                JvmGcMonitorService.GC_SETTING,
import org.opensearch.indices.IndicesBitsetFilterCache;
                NetworkService.TCP_SEND_BUFFER_SIZE,
                BaseRestHandler.MULTI_ALLOW_EXPLICIT_INDEX,
    /**
                ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING,
                TransportSettings.TCP_KEEP_INTERVAL,
import java.util.List;
                HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING,
                SearchPipelineService.ENABLED_SYSTEM_GENERATED_FACTORIES_SETTING,
                SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE,
                SearchService.KEYWORD_INDEX_OR_DOC_VALUES_ENABLED,
                IndicesService.CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING,
                ResponseLimitSettings.CAT_INDICES_RESPONSE_LIMIT_SETTING,
                BreakerSettings.CIRCUIT_BREAKER_OVERHEAD_SETTING,
                SniffConnectionStrategy.REMOTE_NODE_CONNECTIONS,
                DiscoveryModule.LEGACY_DISCOVERY_HOSTS_PROVIDER_SETTING,
                PageCacheRecycler.WEIGHT_OBJECTS_SETTING,
                HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED,
import java.util.Arrays;
import org.opensearch.tasks.TaskManager;
                Loggers.LOG_DEFAULT_LEVEL_SETTING,
                HttpTransportSettings.SETTING_HTTP_PORT,
                SearchService.CLUSTER_ALLOW_DERIVED_FIELD_SETTING,
            TelemetrySettings.TRACER_ENABLED_SETTING,
                HandshakingTransportAddressConnector.PROBE_CONNECT_TIMEOUT_SETTING,
                SnapshotsService.SNAPSHOT_DELETE_CLEANUP_STALE_BLOBS_SETTING,
                TransportSettings.OLD_TCP_REUSE_ADDRESS_PROFILE,
                RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING,
                NetworkService.GLOBAL_NETWORK_HOST_SETTING,
            TelemetrySettings.METRICS_PUBLISH_INTERVAL_SETTING,
                TransportSettings.SLOW_OPERATION_THRESHOLD_SETTING,
                SnapshotsService.SNAPSHOT_REPOSITORY_MAX_OUTSTANDING_OPS_SETTING,
                NodeDuressSettings.SETTING_NATIVE_MEMORY_THRESHOLD,
import org.opensearch.persistent.decider.EnableAssignmentDecider;
/**
                TransportSettings.TCP_KEEP_COUNT_PROFILE,
                TransportSettings.TCP_NO_DELAY_PROFILE,
                IndicesBitsetFilterCache.INDICES_BITSET_FILTER_CACHE_SIZE_SETTING,
                TransportSettings.TRACE_LOG_EXCLUDE_SETTING,
import org.opensearch.persistent.PersistentTasksClusterService;
                RemoteStorePressureSettings.REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED,
                HttpTransportSettings.SETTING_HTTP_TCP_NO_DELAY,
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED,
                ForceMergeManagerSettings.JVM_THRESHOLD_PERCENTAGE_FOR_AUTO_FORCE_MERGE,
                TransportSettings.TRANSPORT_COMPRESS,
                SearchShardTaskSettings.SETTING_HEAP_VARIANCE_THRESHOLD,
                } else {
                ClusterManagerTaskThrottler.THRESHOLD_SETTINGS,
                SeedHostsResolver.LEGACY_DISCOVERY_ZEN_PING_UNICAST_CONCURRENT_CONNECTS_SETTING,
                SearchIndexPruningSettings.FIELDS
        List.of(FeatureFlags.TELEMETRY),
import org.opensearch.discovery.PeerFinder;
                SearchService.AGGREGATION_REWRITE_FILTER_SEGMENT_THRESHOLD,
                IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING,
                ShardLimitValidator.SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_CLUSTER,
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
                // Settings related to Tiered Storage
                BalancedShardsAllocator.PRIMARY_CONSTRAINT_THRESHOLD_SETTING,
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                HttpTransportSettings.SETTING_HTTP_MAX_HEADER_SIZE,
import org.opensearch.env.Environment;
                ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING,
                Loggers.LOG_LEVEL_SETTING,
                SearchTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD,
import org.opensearch.index.IndexingPressure;
                TransportReplicationAction.REPLICATION_INITIAL_RETRY_BACKOFF_BOUND,
                // Pluggable dataformat cluster defaults
                CompositeIndexSettings.STAR_TREE_INDEX_ENABLED_SETTING,
                SegmentReplicationPressureService.MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING,
import org.opensearch.transport.RemoteClusterService;
                WorkloadManagementSettings.NODE_LEVEL_MEMORY_REJECTION_THRESHOLD,
                HttpTransportSettings.SETTING_HTTP_READ_TIMEOUT,
                BalancedShardsAllocator.PRIMARY_SHARD_REBALANCE_BUFFER,
                RemoteConnectionStrategy.REMOTE_CONNECTION_MODE,
                SnapshotsService.SNAPSHOT_CLEANUP_RETRY_BACKOFF_SETTING,
                IndicesRequestCache.INDICES_CACHE_QUERY_EXPIRE,
            TelemetrySettings.METRICS_FEATURE_ENABLED_SETTING
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING,
                ScriptService.SCRIPT_GENERAL_CACHE_EXPIRE_SETTING,
     * setting should be moved to {@link #BUILT_IN_CLUSTER_SETTINGS}.
                FsRepository.REPOSITORIES_COMPRESS_SETTING,
                ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING,
                TransportSettings.OLD_TCP_NO_DELAY_PROFILE,
                JvmService.REFRESH_INTERVAL_SETTING,
                InternalSnapshotsInfoService.INTERNAL_SNAPSHOT_INFO_MAX_CONCURRENT_FETCHES_SETTING,
                TransportSettings.TCP_CONNECT_TIMEOUT,
                FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING,
                Coordinator.PUBLISH_INFO_TIMEOUT_SETTING,
                ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED,
                Metadata.SETTING_READ_ONLY_SETTING,
                SameShardAllocationDecider.CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING,
                HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING,
import static org.opensearch.gateway.remote.RemoteGlobalMetadataManager.GLOBAL_METADATA_UPLOAD_TIMEOUT_SETTING;
                TransportSettings.PUBLISH_HOST_PROFILE,
                PageCacheRecycler.WEIGHT_BYTES_SETTING,
                IndexingMemoryController.MIN_INDEX_BUFFER_SIZE_SETTING,
                RemoteIndexMetadataManager.REMOTE_INDEX_METADATA_PATH_HASH_ALGO_SETTING,
                ClusterMergeSchedulerConfig.CLUSTER_AUTO_THROTTLE_SETTING,
import org.opensearch.action.search.StreamSearchTransportService;
        LoggingSettingUpdater(Settings settings) {
                JvmGcMonitorService.GC_OVERHEAD_DEBUG_SETTING,
                IndicesService.CLUSTER_DEFAULT_INDEX_MAX_MERGE_AT_ONCE_SETTING,
 * KIND, either express or implied.  See the License for the
                TieringUtils.W2H_MAX_CONCURRENT_TIERING_REQUESTS,
import org.opensearch.ratelimitting.admissioncontrol.settings.IoBasedAdmissionControllerSettings;
import org.opensearch.indices.store.IndicesStore;
                FsRepository.REPOSITORIES_CHUNK_SIZE_SETTING,
                RecoverySettings.INDICES_TRANSLOG_CONCURRENT_RECOVERY_ENABLE,
                ForceMergeManagerSettings.DISK_THRESHOLD_PERCENTAGE_FOR_AUTO_FORCE_MERGE,
 *
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
                BalancedShardsAllocator.SHARD_MOVE_PRIMARY_FIRST_SETTING,
                OpenSearchExecutors.NODE_PROCESSORS_SETTING,
                SearchRequestStats.SEARCH_REQUEST_STATS_ENABLED,
import org.opensearch.indices.IndicesRequestCache;
import org.opensearch.common.annotation.PublicApi;
            )
 * specific language governing permissions and limitations
                IndexingMemoryController.MIN_NATIVE_INDEX_BUFFER_SIZE_SETTING,
                ScriptService.SCRIPT_MAX_SIZE_IN_BYTES,
                SearchTaskSettings.SETTING_CANCELLATION_RATE,
import org.opensearch.discovery.SettingsBasedSeedHostsProvider;
                RemoteClusterService.REMOTE_CLUSTER_COMPRESS,
                TaskResourceTrackingService.BINARY_RESOURCE_USAGE_HEADER_ENABLED,
                ProxyConnectionStrategy.SERVER_NAME,
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.indices.ShardLimitValidator;
                NetworkModule.TRANSPORT_DEFAULT_TYPE_SETTING,
import org.opensearch.cluster.routing.UnassignedInfo;
                OsService.REFRESH_INTERVAL_SETTING,
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING,
 * Encapsulates all valid cluster level settings.
                IndexingMemoryController.NATIVE_INDEX_BUFFER_SIZE_SETTING,
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                HttpTransportSettings.SETTING_CORS_MAX_AGE,
                RemoteIndexMetadataManager.REMOTE_INDEX_METADATA_PATH_TYPE_SETTING,
/*
                TieredStoragePrefetchSettings.READ_AHEAD_BLOCK_COUNT,
                ScriptService.CONTEXTS_ALLOWED_SETTING,
                FsHealthService.REFRESH_INTERVAL_SETTING,
                FsHealthService.SLOW_PATH_LOGGING_THRESHOLD_SETTING,
import org.opensearch.action.admin.indices.close.TransportCloseIndexAction;
                Metadata.DEFAULT_REPLICA_COUNT_SETTING,
                LeaderChecker.LEADER_CHECK_RETRY_COUNT_SETTING,
                NodeDuressSettings.SETTING_CPU_THRESHOLD,
                RemoteStoreSettings.CLUSTER_REMOTE_MAX_TRANSLOG_READERS,
                OperationRouting.IGNORE_AWARENESS_ATTRIBUTES_SETTING,
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
                FastVectorHighlighter.SETTING_TV_HIGHLIGHT_MULTI_VALUE,
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_LOOKBACK_INTERVAL,
                DiskThresholdSettings.ENABLE_FOR_SINGLE_DATA_NODE,
                FilterAllocationDecider.CLUSTER_ROUTING_REQUIRE_GROUP_SETTING,
                ScriptService.SCRIPT_CACHE_SIZE_SETTING,
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_SCHEDULER_INTERVAL,
                FsRepository.REPOSITORIES_LOCATION_SETTING,
    public ClusterSettings(final Settings nodeSettings, final Set<Setting<?>> settingsSet, final Set<SettingUpgrader<?>> settingUpgraders) {
                RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING,
                CpuBasedAdmissionControllerSettings.CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE,
                IndicesQueryCache.INDICES_QUERY_CACHE_COSTLY_MIN_FREQUENCY,
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
                SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY,
                BreakerSettings.CIRCUIT_BREAKER_LIMIT_SETTING,
                ShardIndexingPressureMemoryManager.OPTIMAL_OPERATING_FACTOR,
                SearchService.LOW_LEVEL_CANCELLATION_SETTING,
                TransportSettings.OLD_TCP_NO_DELAY,
                IndexSettings.QUERY_STRING_ALLOW_LEADING_WILDCARD,
                TaskCancellationMonitoringSettings.IS_ENABLED_SETTING,
                TransportSettings.TCP_RECEIVE_BUFFER_SIZE_PROFILE,
                // Admission Control Settings
                ForceMergeManagerSettings.MERGE_DELAY_BETWEEN_SHARDS_FOR_AUTO_FORCE_MERGE,
                ForceMergeManagerSettings.CPU_THRESHOLD_PERCENTAGE_FOR_AUTO_FORCE_MERGE,
                IndexModule.NODE_STORE_ALLOW_MMAP,
                IndexingMemoryController.SHARD_INACTIVE_TIME_SETTING,
                NetworkService.NETWORK_SERVER,
                TransportSettings.CONNECTIONS_PER_NODE_RECOVERY,
                ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE,
                Node.NODE_LOCAL_STORAGE_SETTING,
                if ("level".equals(component)) {
                SearchShardTaskSettings.SETTING_ELAPSED_TIME_MILLIS_THRESHOLD,
                RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE,
                RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING,
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING,
import org.opensearch.search.backpressure.settings.SearchShardTaskSettings;
import org.opensearch.indices.analysis.HunspellService;
import org.opensearch.indices.recovery.RecoverySettings;
                IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST,
import org.opensearch.search.backpressure.settings.NodeDuressSettings;
                SearchService.DEFAULT_KEEPALIVE_SETTING,
                BreakerSettings.CIRCUIT_BREAKER_TYPE,
                // Server Side encryption enabled
                OperationRouting.WEIGHTED_ROUTING_FAILOPEN_ENABLED,
                NodeEnvironment.ENABLE_LUCENE_SEGMENT_INFOS_TRACE_SETTING,
                ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING,  // deprecated
                HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_OVERHEAD_SETTING,
                NetworkModule.TRANSPORT_TYPE_SETTING,
                SearchService.SEARCH_MAX_QUERY_STRING_LENGTH_MONITOR_ONLY,
import org.opensearch.common.settings.Setting.Property;
                TransportSearchAction.SHARD_COUNT_LIMIT_SETTING,
import org.opensearch.ratelimitting.admissioncontrol.AdmissionControlSettings;
                RemoteClusterStateService.REMOTE_PUBLICATION_SETTING,
                // Composite index settings
import org.opensearch.gateway.DanglingIndicesState;
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;
                HttpTransportSettings.SETTING_HTTP_RESET_COOKIES,
                TransportSettings.TCP_NO_DELAY,
import org.opensearch.cluster.routing.allocation.decider.ConcurrentRecoveriesAllocationDecider;
import org.opensearch.action.admin.cluster.configuration.TransportAddVotingConfigExclusionsAction;
                HunspellService.HUNSPELL_DICTIONARY_OPTIONS,
                HunspellService.HUNSPELL_LAZY_LOAD,
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
                SearchService.BUCKET_SELECTION_STRATEGY_FACTOR_SETTING,
                TransportSettings.BIND_HOST,
                ShardLimitValidator.SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE,
                ForceMergeManagerSettings.CONCURRENCY_MULTIPLIER,
                RecoverySettings.INDICES_REPLICATION_MAX_BYTES_PER_SEC_SETTING,
                RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING,
                ShardLimitValidator.SETTING_CLUSTER_IGNORE_DOT_INDEXES,
                RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING,
                ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_CLUSTER,
                RemoteClusterService.REMOTE_INITIAL_CONNECTION_TIMEOUT_SETTING,
                RemoteRoutingTableBlobStore.REMOTE_ROUTING_TABLE_PATH_HASH_ALGO_SETTING,
                FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING,
                FlushModeResolver.STREAMING_MIN_ESTIMATED_BUCKET_COUNT,
                IndicesStore.INDICES_STORE_DELETE_SHARD_TIMEOUT,
import org.opensearch.common.network.NetworkModule;
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_INCLUDE_RELOCATIONS_SETTING,
                IndicesService.CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING,
                // Settings related to Remote Store stats
import org.opensearch.common.cache.store.settings.OpenSearchOnHeapCacheSettings;
                TransportCloseIndexAction.CLUSTER_INDICES_CLOSE_ENABLE_SETTING,
                PeerFinder.DISCOVERY_REQUEST_PEERS_TIMEOUT_SETTING,
 * under the License.
                RecoverySettings.INDICES_RECOVERY_MAX_CONCURRENT_REMOTE_STORE_STREAMS_SETTING,
                HttpTransportSettings.SETTING_HTTP_MAX_WARNING_HEADER_COUNT,
import org.opensearch.cluster.routing.allocation.decider.ConcurrentRebalanceAllocationDecider;
                DanglingIndicesState.AUTO_IMPORT_DANGLING_INDICES_SETTING,
                TransportSettings.TCP_KEEP_ALIVE_PROFILE,
                RemoteStoreSettings.CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED,
import org.opensearch.cluster.coordination.ClusterFormationFailureHelper;
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_LEVEL,
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING,
                TransportSearchAction.SEARCH_PHASE_TOOK_ENABLED,
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX,
                RecoverySettings.INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_MAX_CONCURRENT_PARTS_SETTING,
                SearchService.QUERY_REWRITING_TERMS_THRESHOLD_SETTING,
                BalancedShardsAllocator.SHARD_MOVEMENT_STRATEGY_SETTING,
                Environment.PIDFILE_SETTING,
                TransportSettings.TCP_SEND_BUFFER_SIZE,
                RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_TIMEOUT_SETTING,
                NetworkService.TCP_KEEP_ALIVE,
                TransportSettings.TCP_KEEP_IDLE,
                HttpTransportSettings.SETTING_HTTP_MAX_CHUNK_SIZE,
                RemoteClusterStateService.REMOTE_CLUSTER_STATE_CHECKSUM_VALIDATION_MODE_SETTING,
                BalancedShardsAllocator.THRESHOLD_SETTING,
                // Settings related to Remote Refresh Segment Pressure
                ResponseLimitSettings.CAT_SEGMENTS_RESPONSE_LIMIT_SETTING,
    );
                HttpTransportSettings.SETTING_HTTP_PUBLISH_PORT,
                IndicesService.CLUSTER_REFRESH_SHARD_LEVEL_ENABLED_SETTING,
 */
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING,
                OperationRouting.STRICT_WEIGHTED_SHARD_ROUTING_ENABLED,
                        Loggers.setLevel(LogManager.getRootLogger(), Loggers.LOG_DEFAULT_LEVEL_SETTING.get(settings));
                EnableAssignmentDecider.CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING,
                TransportSettings.BIND_HOST_PROFILE,
        public Settings getValue(Settings current, Settings previous) {
                PageCacheRecycler.LIMIT_HEAP_SETTING,
                HttpTransportSettings.SETTING_HTTP_TCP_KEEP_COUNT,
                MappingUpdatedAction.INDICES_MAX_IN_FLIGHT_UPDATES_SETTING,
import org.opensearch.action.search.SearchRequestSlowLog;
                FilterAllocationDecider.CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING,
                ScriptService.SCRIPT_CACHE_EXPIRE_SETTING,
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING,
        Collections.singletonList(NodeDuressSettings.NATIVE_MEMORY_LIMIT_UPGRADER)
                NetworkService.TCP_REUSE_ADDRESS,
import org.opensearch.cluster.coordination.ClusterBootstrapService;
import org.opensearch.cluster.routing.allocation.decider.NodeLoadAwareAllocationDecider;
                Node.WRITE_PORTS_FILE_SETTING,
import org.opensearch.http.HttpTransportSettings;
                RemoteStoreSettings.CLUSTER_REMOTE_SEGMENT_TRANSFER_TIMEOUT_SETTING,
                IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING,
                GatewayService.RECOVER_AFTER_DATA_NODES_SETTING,
                ClusterBootstrapService.UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING,
                OperationRouting.STRICT_SEARCH_REPLICA_ROUTING_ENABLED,
                UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING,
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE,
        super(nodeSettings, settingsSet, settingUpgraders, Property.NodeScope);
        addSettingsUpdater(new LoggingSettingUpdater(nodeSettings));
import org.opensearch.monitor.fs.FsService;
                OperationRouting.USE_ADAPTIVE_REPLICA_SELECTION_SETTING,
                WorkloadManagementSettings.NODE_LEVEL_CPU_REJECTION_THRESHOLD,
                SearchShardTaskSettings.SETTING_CANCELLATION_RATIO,
                RemoteClusterService.ENABLE_REMOTE_CLUSTERS,
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING,
                PageCacheRecycler.TYPE_SETTING,
                Node.NODE_NAME_SETTING,
                RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING,
                RemoteClusterStateService.REMOTE_STATE_DOWNLOAD_TO_SERVE_READ_API,
                IndexingMemoryController.MAX_INDEX_BUFFER_SIZE_SETTING,
                HttpTransportSettings.SETTING_HTTP_COMPRESSION_LEVEL,
                ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW,
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING,
                JvmGcMonitorService.GC_OVERHEAD_INFO_SETTING,
                SearchTaskSettings.SETTING_CANCELLATION_RATIO,
import org.opensearch.search.aggregations.metrics.CardinalityAggregator;
                ShardsLimitAllocationDecider.CLUSTER_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING,
                BootstrapSettings.SYSTEM_CALL_FILTER_SETTING,
        this(nodeSettings, settingsSet, Collections.emptySet());
                TransportSettings.PING_SCHEDULE,
import org.opensearch.common.network.NetworkService;
                JvmGcMonitorService.GC_OVERHEAD_WARN_SETTING,
                KeyStoreWrapper.SEED_SETTING,
                OpenSearchOnHeapCacheSettings.MAXIMUM_SIZE_IN_BYTES.getConcreteSettingForNamespace(
                HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_OVERHEAD_SETTING,
                NetworkService.GLOBAL_NETWORK_BIND_HOST_SETTING,
import org.opensearch.ratelimitting.admissioncontrol.settings.CpuBasedAdmissionControllerSettings;
 * Modifications Copyright OpenSearch Contributors. See
                WorkloadManagementSettings.NODE_LEVEL_CPU_CANCELLATION_THRESHOLD,
                    } else {
 *
                SniffConnectionStrategy.REMOTE_CLUSTERS_PROXY,
                ResponseLimitSettings.CAT_SHARDS_RESPONSE_LIMIT_SETTING,
                RemoteStorePressureSettings.BYTES_LAG_VARIANCE_FACTOR,
                TransportSettings.OLD_TCP_SEND_BUFFER_SIZE_PROFILE,
                TieringUtils.JVM_USAGE_TIERING_THRESHOLD_PERCENT,
                RecoverySettings.INDICES_RECOVERY_ACTIVITY_TIMEOUT_SETTING,
                TransportSettings.OLD_PORT,
                RecoverySettings.INDICES_RECOVERY_INTERNAL_ACTION_RETRY_TIMEOUT_SETTING,
                IndicesQueryCache.INDICES_QUERY_CACHE_MIN_FREQUENCY,
import org.opensearch.action.support.DestructiveOperations;
                HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING,
                    if (rootLevel == null) {
import org.opensearch.gateway.remote.RemoteClusterStateCleanupManager;
                ShardsBatchGatewayAllocator.REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING,
import org.opensearch.cluster.service.ClusterManagerService;
import org.opensearch.search.pipeline.SearchPipelineService;
                // Settings related to search backpressure
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
                AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE,
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING,
                TransportSettings.PORT_PROFILE,
import org.opensearch.watcher.ResourceWatcherService;
                ScriptService.TYPES_ALLOWED_SETTING,
import org.opensearch.search.backpressure.settings.SearchTaskSettings;
                LeaderChecker.LEADER_CHECK_INTERVAL_SETTING,
                SeedHostsResolver.DISCOVERY_SEED_RESOLVER_MAX_CONCURRENT_RESOLVERS_SETTING,
                SearchService.DEFAULT_ALLOW_PARTIAL_SEARCH_RESULTS,
     * Map of feature flag name to feature-flagged cluster settings. Once each feature
                ClusterManagerTaskThrottler.MAX_DELAY_SETTINGS,
                IndicesRequestCache.INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING,
import org.opensearch.transport.StreamTransportService;
                IndexingMemoryController.SHARD_MEMORY_INTERVAL_TIME_SETTING,
        }
                NetworkModule.HTTP_DEFAULT_TYPE_SETTING,
                HttpTransportSettings.SETTING_CORS_ALLOW_CREDENTIALS,
                RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING,
 * software distributed under the License is distributed on an
                SettingsBasedSeedHostsProvider.LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_SETTING,
                PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_DURING_DECOMMISSION_SETTING,
                // Settings related to Searchable Snapshots
import java.util.HashSet;
import org.opensearch.plugins.PluginsService;
                HttpTransportSettings.SETTING_HTTP_PUBLISH_HOST,
                HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING,
                FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING,
                SearchService.TERMS_AGGREGATION_MAX_PRECOMPUTE_CARDINALITY,
                PluginsService.MANDATORY_SETTING,
                IndicesService.CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING,
                Node.NODE_SEARCH_CACHE_SIZE_SETTING,
                ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING,
                ElectionSchedulerFactory.ELECTION_BACK_OFF_TIME_SETTING,
                HttpTransportSettings.SETTING_CORS_ALLOW_METHODS,
                JoinHelper.JOIN_TIMEOUT_SETTING,
                TieredStoragePrefetchSettings.STORED_FIELDS_PREFETCH_ENABLED_SETTING,
     * is ready for production release, the feature flag can be removed, and the
                SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING,
                LagDetector.CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING,
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING,
                IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING,
                        Loggers.setLevel(LogManager.getRootLogger(), rootLevel);
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
                SearchTaskSettings.SETTING_CANCELLATION_BURST,
                SearchService.MAX_PIT_KEEPALIVE_SETTING,
            this.settings = settings;
import org.opensearch.cluster.coordination.Reconfigurator;
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
        public boolean hasChanged(Settings current, Settings previous) {
            return builder.build();
                IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING,
                CardinalityAggregator.CARDINALITY_AGGREGATION_HYBRID_COLLECTOR_MEMORY_THRESHOLD,
                RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING,
                TaskResourceTrackingService.TASK_RESOURCE_TRACKING_ENABLED,
                RemoteRoutingTableBlobStore.REMOTE_ROUTING_TABLE_PATH_TYPE_SETTING,
                SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING,
                BalancedShardsAllocator.IGNORE_THROTTLE_FOR_REMOTE_RESTORE,
import org.opensearch.monitor.jvm.JvmGcMonitorService;
import org.opensearch.search.SearchService;
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
import org.opensearch.storage.common.tiering.TieringUtils;
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
import org.opensearch.env.NodeEnvironment;
                OpenSearchExecutors.PROCESSORS_SETTING,
                NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_USAGE_LIMIT,
                CardinalityAggregator.CARDINALITY_AGGREGATION_HYBRID_COLLECTOR_ENABLED,
                SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE,
                PersistentTasksClusterService.CLUSTER_TASKS_ALLOCATION_RECHECK_INTERVAL_SETTING,
                ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS,
                    }
                RemoteClusterService.REMOTE_CLUSTER_PING_SCHEDULE,
                ProcessService.REFRESH_INTERVAL_SETTING,
     */
                JvmGcMonitorService.REFRESH_INTERVAL_SETTING,
                TransportSettings.TCP_KEEP_ALIVE,
import org.opensearch.indices.RemoteStoreSettings;
                // Search request slow log settings
                PageCacheRecycler.WEIGHT_INT_SETTING,
                SearchBackpressureSettings.SETTING_CANCELLATION_RATE,   // deprecated
                ShardIndexingPressureStore.MAX_COLD_STORE_SIZE,
import org.opensearch.common.util.PageCacheRecycler;
import org.opensearch.action.search.SearchRequestStats;
                TieringUtils.H2W_MAX_CONCURRENT_TIERING_REQUESTS,
                IndicesRequestCache.INDICES_REQUEST_CACHE_MAX_SIZE_ALLOWED_IN_CACHE_SETTING,
        public void apply(Settings value, Settings current, Settings previous) {
    }
import org.opensearch.index.IndexModule;
                TopNSearchTasksLogger.LOG_TOP_QUERIES_FREQUENCY_SETTING,
import org.opensearch.tasks.TaskResourceTrackingService;
import org.opensearch.discovery.SeedHostsResolver;
 * this work for additional information regarding copyright
public final class ClusterSettings extends AbstractScopedSettings {
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
            for (String key : value.keySet()) {
                TransportSettings.OLD_TCP_KEEP_ALIVE_PROFILE,
                IndicesService.CLUSTER_REFRESH_FIXED_INTERVAL_SCHEDULE_ENABLED_SETTING,
                IndicesService.WRITE_DANGLING_INDICES_INFO_SETTING,
import org.opensearch.cluster.coordination.ElectionSchedulerFactory;
                TransportReplicationAction.REPLICATION_RETRY_TIMEOUT,
                SniffConnectionStrategy.REMOTE_CONNECTIONS_PER_CLUSTER,
import org.opensearch.cluster.action.shard.ShardStateAction;
@PublicApi(since = "1.0.0")
package org.opensearch.common.settings;
                AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING,
import org.opensearch.indices.replication.checkpoint.PublishCheckpointAction;
                SearchService.MAX_OPEN_SCROLL_CONTEXT,
        @Override
            for (String key : previous.keySet()) {
                DiskThresholdSettings.INDEX_READ_BLOCK_AUTO_RELEASE,
                ConcurrentRecoveriesAllocationDecider.CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_RECOVERIES_SETTING,
                NetworkModule.STREAM_TRANSPORT_DEFAULT_TYPE_SETTING,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                CompositeIndexSettings.COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING,
                TransportAddVotingConfigExclusionsAction.MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING,
import org.opensearch.cluster.coordination.FollowersChecker;
                HttpTransportSettings.SETTING_HTTP_HOST,
                WorkloadManagementSettings.NODE_LEVEL_MEMORY_CANCELLATION_THRESHOLD,
import org.opensearch.monitor.os.OsService;
                HttpTransportSettings.SETTING_HTTP_CONTENT_TYPE_REQUIRED,
                NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT,
                HttpTransportSettings.SETTING_CORS_ALLOW_HEADERS,
import static org.opensearch.gateway.remote.RemoteManifestManager.METADATA_MANIFEST_UPLOAD_TIMEOUT_SETTING;
                TransportSettings.PORT,
    public static final Map<List<String>, List<Setting>> FEATURE_FLAGGED_CLUSTER_SETTINGS = Map.of(
                OpenSearchOnHeapCacheSettings.EXPIRE_AFTER_ACCESS_SETTING.getConcreteSettingForNamespace(
import org.opensearch.search.backpressure.settings.SearchBackpressureSettings;
import org.opensearch.common.cache.settings.CacheSettings;
                SearchService.MAX_OPEN_PIT_CONTEXT,
                TransportSettings.TCP_SEND_BUFFER_SIZE_PROFILE,
                HttpTransportSettings.OLD_SETTING_HTTP_TCP_NO_DELAY,
                RemoteClusterStateService.CLUSTER_REMOTE_STORE_STATE_PATH_PREFIX,
 *
                ElectionSchedulerFactory.ELECTION_MAX_TIMEOUT_SETTING,
                BalancedShardsAllocator.PREFER_PRIMARY_SHARD_BALANCE,
import org.opensearch.telemetry.TelemetrySettings;
                TaskManager.TASK_RESOURCE_CONSUMERS_ENABLED,
import org.opensearch.cluster.coordination.Coordinator;
/*
                ClusterApplierService.CLUSTER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING,
                NetworkService.TCP_CONNECT_TIMEOUT,
}
                Node.BREAKER_TYPE_KEY,
                TransportSettings.DEFAULT_FEATURES_SETTING,
 * compatible open source license.
                SearchBackpressureSettings.SETTING_CANCELLATION_RATIO,  // deprecated
                CreatePitController.PIT_INIT_KEEP_ALIVE,
                HttpTransportSettings.SETTING_HTTP_CONNECT_TIMEOUT,
import org.opensearch.index.autoforcemerge.ForceMergeManagerSettings;
