                if ("level".equals(component)) {
                SearchTaskSettings.SETTING_ELAPSED_TIME_MILLIS_THRESHOLD,
                NoClusterManagerBlockService.NO_MASTER_BLOCK_SETTING,  // deprecated
import org.opensearch.discovery.SeedHostsResolver;  
        )
                ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING,
                HttpTransportSettings.SETTING_HTTP_COMPRESSION_LEVEL,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                BalancedShardsAllocator.PREFER_PRIMARY_SHARD_BALANCE,  
                NetworkService.TCP_KEEP_IDLE,
import org.opensearch.common.cache.settings.CacheSettings;
                SearchService.DEFAULT_KEEPALIVE_SETTING,
                DestructiveOperations.REQUIRES_NAME_SETTING,  
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING,  
                NativeMemoryService.REFRESH_INTERVAL_SETTING,  
                SearchBackpressureSettings.SETTING_CANCELLATION_RATIO,  // deprecated  
                // Remote cluster state settings
 * @opensearch.api
                DanglingIndicesState.AUTO_IMPORT_DANGLING_INDICES_SETTING,  
                HttpTransportSettings.SETTING_HTTP_MAX_HEADER_SIZE,  
                SnapshotsService.SNAPSHOT_CLEANUP_RETRIES_SETTING,
                FsRepository.REPOSITORIES_CHUNK_SIZE_SETTING,
                IndexModule.NODE_STORE_ALLOW_MMAP,
                HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING,
        public boolean hasChanged(Settings current, Settings previous) {  
                SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING, // deprecated
                HttpTransportSettings.SETTING_HTTP_PORT,
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
                TaskResourceTrackingService.TASK_RESOURCE_TRACKING_ENABLED,  
                TransportSettings.CONNECTIONS_PER_NODE_REG,
                SearchTaskSettings.SETTING_CPU_TIME_MILLIS_THRESHOLD,
        )  
import org.opensearch.gateway.remote.RemoteClusterStateService;  
import org.opensearch.gateway.remote.model.RemoteRoutingTableBlobStore;
                RemoteStorePressureSettings.MIN_CONSECUTIVE_FAILURES_LIMIT,  
                HttpTransportSettings.SETTING_HTTP_TCP_NO_DELAY,
    /**
                TransportSettings.CONNECT_TIMEOUT,  
                TransportSettings.BIND_HOST,
import org.opensearch.transport.TransportSettings;
import org.opensearch.monitor.jvm.JvmService;
        @Override
                SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE,
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import org.opensearch.cluster.coordination.Coordinator;
import org.opensearch.search.backpressure.settings.NodeDuressSettings;  
import org.opensearch.cluster.routing.OperationRouting;
                // Snapshot related Settings
import org.opensearch.cluster.ClusterName;
            return builder.build();
                Environment.PATH_SHARED_DATA_SETTING,
import org.opensearch.node.Node.DiscoverySettings;  
                ProxyConnectionStrategy.PROXY_ADDRESS,
                TransportSettings.TCP_KEEP_COUNT_PROFILE,
                SearchService.DEFAULT_SEARCH_TIMEOUT_SETTING,
 * Encapsulates all valid cluster level settings.
                SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING,
                RemoteIndexMetadataManager.REMOTE_INDEX_METADATA_PATH_HASH_ALGO_SETTING,  
                        builder.putNull(key);
                SearchTaskSettings.SETTING_HEAP_PERCENT_THRESHOLD,
import java.util.HashSet;  
import org.opensearch.index.IndexSettings;
                HttpTransportSettings.SETTING_HTTP_PUBLISH_HOST,
                PageCacheRecycler.LIMIT_HEAP_SETTING,
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING,
                IndicesStore.INDICES_STORE_DELETE_SHARD_TIMEOUT,  
                CpuBasedAdmissionControllerSettings.CLUSTER_ADMIN_CPU_USAGE_LIMIT,  
                TransportSettings.TCP_KEEP_INTERVAL_PROFILE,  
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;  
                NetworkService.TCP_REUSE_ADDRESS,
                SearchIndexPruningSettings.FIELDS
                // Settings related to Tiered Storage  
                EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING,
                // WorkloadManagement settings  
 *
import org.opensearch.common.network.NetworkModule;
                MultiBucketConsumerService.MAX_BUCKET_SETTING,  
                OperationRouting.WEIGHTED_ROUTING_FAILOPEN_ENABLED,  
import java.util.List;
                OpenSearchExecutors.NODE_PROCESSORS_SETTING,
                LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING,  
                IndicesQueryCache.INDICES_CACHE_QUERY_COUNT_SETTING,
                RemoteStoreSettings.CLUSTER_REMOTE_MAX_TRANSLOG_READERS,  
                OperationRouting.IGNORE_WEIGHTED_SHARD_ROUTING,
                FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING,  
                SnapshotsService.MAX_SHARDS_ALLOWED_IN_STATUS_API,  
                NodeDuressSettings.SETTING_NATIVE_MEMORY_LIMIT_LEGACY,
                SearchService.MAX_AGGREGATION_REWRITE_FILTERS,  
                ElectionSchedulerFactory.ELECTION_INITIAL_TIMEOUT_SETTING,
import org.opensearch.action.search.CreatePitController;  
                NativeMemoryBasedAdmissionControllerSettings.SEARCH_NATIVE_MEMORY_USAGE_LIMIT,
                TransportSettings.HOST,
                ClusterService.USER_DEFINED_METADATA,  
                TransportSettings.TCP_CONNECT_TIMEOUT,
                PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_DURING_DECOMMISSION_SETTING,
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING,  
import org.opensearch.search.fetch.subphase.highlight.FastVectorHighlighter;
                SearchShardTaskSettings.SETTING_HEAP_VARIANCE_THRESHOLD,  
import org.opensearch.index.compositeindex.CompositeIndexSettings;
                TransportSettings.TCP_RECEIVE_BUFFER_SIZE,  
                ClusterMergeSchedulerConfig.CLUSTER_AUTO_THROTTLE_SETTING,
                JvmGcMonitorService.REFRESH_INTERVAL_SETTING,
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING,
                NetworkModule.TRANSPORT_TYPE_SETTING,  
/*
                SegmentReplicationPressureService.MAX_ALLOWED_STALE_SHARDS,
    public ClusterSettings(final Settings nodeSettings, final Set<Setting<?>> settingsSet, final Set<SettingUpgrader<?>> settingUpgraders) {
                IndicesQueryCache.INDICES_QUERY_CACHE_COSTLY_MIN_FREQUENCY,
 * software distributed under the License is distributed on an
import org.opensearch.indices.IndicesBitsetFilterCache;
                DiscoverySettings.INITIAL_STATE_TIMEOUT_SETTING,  
                GatewayService.RECOVER_AFTER_DATA_NODES_SETTING,
                SearchService.KEEPALIVE_INTERVAL_SETTING,  
import org.opensearch.http.HttpTransportSettings;  
                SnapshotsService.MAX_CONCURRENT_SNAPSHOT_OPERATIONS_SETTING,
                SearchService.LOW_LEVEL_CANCELLATION_SETTING,
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                ScriptService.SCRIPT_CACHE_EXPIRE_SETTING,
                NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_SETTING,
                SegmentReplicationPressureService.MAX_INDEXING_CHECKPOINTS,
import org.opensearch.index.ShardIndexingPressureSettings;
import org.opensearch.ingest.IngestService;
                MappingUpdatedAction.INDICES_MAPPING_DYNAMIC_TIMEOUT_SETTING,  
                RemoteClusterService.REMOTE_CLUSTER_SKIP_UNAVAILABLE,
                HttpTransportSettings.SETTING_PIPELINING_MAX_EVENTS,  
                RecoverySettings.INDICES_RECOVERY_MAX_CONCURRENT_REMOTE_STORE_STREAMS_SETTING,
                ClusterManagerTaskThrottler.THRESHOLD_SETTINGS,
                TransportAddVotingConfigExclusionsAction.MAXIMUM_VOTING_CONFIG_EXCLUSIONS_SETTING,
                RecoverySettings.INDICES_PRIMARY_RESYNC_TIMEOUT_SETTING,
                HttpTransportSettings.SETTING_HTTP_BIND_HOST,  
                IndicesService.WRITE_DANGLING_INDICES_INFO_SETTING,
                SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE,  
                HunspellService.HUNSPELL_IGNORE_CASE,
                ShardIndexingPressureMemoryManager.SUCCESSFUL_REQUEST_ELAPSED_TIMEOUT,  
                HttpTransportSettings.OLD_SETTING_HTTP_TCP_NO_DELAY,
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING,  
import org.opensearch.indices.IndicesService;
                SegmentReplicationPressureService.SEGMENT_REPLICATION_INDEXING_PRESSURE_ENABLED,  
import org.opensearch.cluster.metadata.IndexGraveyard;  
import org.opensearch.index.IndexModule;
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_INCLUDE_RELOCATIONS_SETTING,
                ShardsBatchGatewayAllocator.GATEWAY_ALLOCATOR_BATCH_SIZE,  
                ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING,  
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
                SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING,  
import org.opensearch.common.breaker.ResponseLimitSettings;  
                FilterAllocationDecider.CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING,  
                TransportSettings.TCP_REUSE_ADDRESS_PROFILE,
                NetworkModule.HTTP_DEFAULT_TYPE_SETTING,
                IndexingMemoryController.MAX_NATIVE_INDEX_BUFFER_SIZE_SETTING,
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;  
                FsHealthService.SLOW_PATH_LOGGING_THRESHOLD_SETTING,
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
    public ClusterSettings(final Settings nodeSettings, final Set<Setting<?>> settingsSet) {  
                IndexSettings.QUERY_STRING_ANALYZE_WILDCARD,  
                IndexingMemoryController.MAX_INDEX_BUFFER_SIZE_SETTING,
                ShardLimitValidator.SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_NODE,
            Settings.Builder builder = Settings.builder();  
                ResourceWatcherService.RELOAD_INTERVAL_LOW,
                ShardIndexingPressureStore.MAX_COLD_STORE_SIZE,  
                HotThreads.MAX_HOT_THREADS_SNAPSHOTS_SETTING,
import org.opensearch.indices.analysis.HunspellService;
                Loggers.LOG_LEVEL_SETTING,
                RemoteStoreSettings.CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED,
                IndicesQueryCache.INDICES_QUERIES_CACHE_SKIP_CACHE_FACTOR,  
        }  
                SearchShardTaskSettings.SETTING_CPU_TIME_MILLIS_THRESHOLD,
                ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW,
                // Composite index settings  
                SniffConnectionStrategy.REMOTE_CONNECTIONS_PER_CLUSTER,  
                TaskManager.TASK_RESOURCE_CONSUMERS_ENABLED,
                HttpTransportSettings.SETTING_HTTP_MAX_WARNING_HEADER_COUNT,
                RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING,
                Node.NODE_NAME_SETTING,
                ForceMergeManagerSettings.JVM_THRESHOLD_PERCENTAGE_FOR_AUTO_FORCE_MERGE,
                StreamSearchTransportService.STREAM_SEARCH_ENABLED,
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;  
import org.opensearch.common.cache.store.settings.OpenSearchOnHeapCacheSettings;  
import org.opensearch.gateway.PersistedClusterStateService;  
                // Settings related to resource trackers  
                TieringUtils.FILECACHE_ACTIVE_USAGE_TIERING_THRESHOLD_PERCENT,
import org.opensearch.snapshots.InternalSnapshotsInfoService;
                ShardIndexingPressureMemoryManager.UPPER_OPERATING_FACTOR,  
                SnapshotsService.SNAPSHOT_REPOSITORY_MAX_OUTSTANDING_OPS_SETTING,
import org.opensearch.discovery.DiscoveryModule;  
                TaskCancellationMonitoringSettings.IS_ENABLED_SETTING,  
                CompositeIndexSettings.STAR_TREE_INDEX_ENABLED_SETTING,
                BalancedShardsAllocator.PRIMARY_SHARD_REBALANCE_BUFFER,
                IndicesQueryCache.INDICES_CACHE_QUERY_SIZE_SETTING,  
                TransportSettings.CONNECTIONS_PER_NODE_RECOVERY,  
                SnapshotsService.SNAPSHOT_REPOSITORY_IO_TIMEOUT_SETTING,
import org.opensearch.cluster.coordination.LeaderChecker;  
                IndexingMemoryController.INDEX_BUFFER_SIZE_SETTING,  
                TransportSettings.OLD_TCP_RECEIVE_BUFFER_SIZE_PROFILE,
    }
                PersistentTasksClusterService.CLUSTER_TASKS_ALLOCATION_RECHECK_INTERVAL_SETTING,
    public static List<SettingUpgrader<?>> BUILT_IN_SETTING_UPGRADERS = Collections.unmodifiableList(  
                SearchShardTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD,
package org.opensearch.common.settings;
                NodeEnvironment.ENABLE_LUCENE_SEGMENT_INFOS_TRACE_SETTING,
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
                Environment.PATH_HOME_SETTING,
                HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_TYPE_SETTING,
import org.opensearch.common.logging.Loggers;
import org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings;
                SearchService.BUCKET_SELECTION_STRATEGY_FACTOR_SETTING,
                ShardsLimitAllocationDecider.CLUSTER_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING,  
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
                OperationRouting.USE_ADAPTIVE_REPLICA_SELECTION_SETTING,  
                OpenSearchOnHeapCacheSettings.EXPIRE_AFTER_ACCESS_SETTING.getConcreteSettingForNamespace(
                BalancedShardsAllocator.ALLOCATOR_TIMEOUT_SETTING,  
                OsService.REFRESH_INTERVAL_SETTING,
import org.opensearch.cluster.coordination.FollowersChecker;  
import static org.opensearch.gateway.remote.RemoteGlobalMetadataManager.GLOBAL_METADATA_UPLOAD_TIMEOUT_SETTING;  
import org.opensearch.indices.IndicesQueryCache;
                HandshakingTransportAddressConnector.PROBE_HANDSHAKE_TIMEOUT_SETTING,
                SeedHostsResolver.DISCOVERY_SEED_RESOLVER_TIMEOUT_SETTING,
import org.opensearch.cluster.coordination.LagDetector;
                TransportSettings.PORT_PROFILE,
import org.opensearch.tasks.consumer.TopNSearchTasksLogger;
                TransportSettings.SLOW_OPERATION_THRESHOLD_SETTING,
                SegmentReplicationPressureService.MAX_REPLICATION_TIME_BACKPRESSURE_SETTING,
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_METADATA,
                HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING,
                // Setting related to refresh optimisations
                HttpTransportSettings.SETTING_HTTP_TCP_KEEP_INTERVAL,
                OperationRouting.WEIGHTED_ROUTING_DEFAULT_WEIGHT,
                TransportSettings.CONNECTIONS_PER_NODE_PING,
                RemoteStoreSettings.CLUSTER_REMOTE_UPLOADED_SEGMENTS_CLEANUP_THRESHOLD_SETTING,  
     * is ready for production release, the feature flag can be removed, and the  
                // Admission Control Settings
                HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN,  
                ProcessService.REFRESH_INTERVAL_SETTING,  
import org.opensearch.search.aggregations.MultiBucketConsumerService;
                InternalClusterInfoService.INTERNAL_CLUSTER_INFO_TIMEOUT_SETTING,
                NodeEnvironment.NODE_ID_SEED_SETTING,
                OperationRouting.STRICT_WEIGHTED_SHARD_ROUTING_ENABLED,
import org.opensearch.snapshots.SnapshotsService;
                HttpTransportSettings.SETTING_HTTP_PUBLISH_PORT,
        }  
import org.opensearch.discovery.SettingsBasedSeedHostsProvider;
                SeedHostsResolver.DISCOVERY_SEED_RESOLVER_MAX_CONCURRENT_RESOLVERS_SETTING,
                IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING,
                ResourceWatcherService.RELOAD_INTERVAL_HIGH,  
                LagDetector.CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING,
                ClusterFormationFailureHelper.DISCOVERY_CLUSTER_FORMATION_WARNING_TIMEOUT_SETTING,
                ResponseLimitSettings.CAT_SEGMENTS_RESPONSE_LIMIT_SETTING,  
                }  
                NetworkService.GLOBAL_NETWORK_PUBLISH_HOST_SETTING,
                ScriptService.SCRIPT_MAX_COMPILATIONS_RATE_SETTING,
                SearchService.ALLOW_EXPENSIVE_QUERIES,
                ShardsBatchGatewayAllocator.REPLICA_BATCH_ALLOCATOR_TIMEOUT_SETTING,
                ProxyConnectionStrategy.SERVER_NAME,  
                FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_THRESHOLD_ENABLED_SETTING,
                RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING,
                ThreadPool.CLUSTER_THREAD_POOL_SIZE_SETTING,  
        Collections.singletonList(NodeDuressSettings.NATIVE_MEMORY_LIMIT_UPGRADER)
                TransportSettings.TCP_KEEP_IDLE,  
 * under the License.  
            TelemetrySettings.METRICS_FEATURE_ENABLED_SETTING
                RecoverySettings.INDICES_RECOVERY_INTERNAL_LONG_ACTION_TIMEOUT_SETTING,
                RecoverySettings.INDICES_RECOVERY_MAX_CONCURRENT_FILE_CHUNKS_SETTING,  
                ResponseLimitSettings.CAT_SHARDS_RESPONSE_LIMIT_SETTING,
                UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING,  
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_SCHEDULER_INTERVAL,
 * license agreements. See the NOTICE file distributed with
                Node.BREAKER_TYPE_KEY,
                IndicesService.CLUSTER_REPLICATION_TYPE_SETTING,
                FsHealthService.REFRESH_INTERVAL_SETTING,
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING,  
                IndicesRequestCache.INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING,
                SnapshotsService.SNAPSHOT_DELETE_CLEANUP_STALE_BLOBS_SETTING,  
                FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING,
import org.opensearch.discovery.PeerFinder;
                String component = key.substring("logger.".length());  
                HttpTransportSettings.SETTING_HTTP_MAX_WARNING_HEADER_SIZE,
                BalancedShardsAllocator.PREFER_PRIMARY_SHARD_REBALANCE,
                PluginsService.MANDATORY_SETTING,
                SegmentReplicationPressureService.MAX_REPLICATION_LIMIT_STALE_REPLICA_SETTING,  
                Node.NODE_ATTRIBUTES,
                RemoteConnectionStrategy.REMOTE_CONNECTION_MODE,  
                SearchService.CARDINALITY_AGGREGATION_PRUNING_THRESHOLD,  
import org.opensearch.rest.BaseRestHandler;
                IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST,
                RecoverySettings.INDICES_RECOVERY_ACTIVITY_TIMEOUT_SETTING,
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE,  
                DiskThresholdSettings.INDEX_READ_BLOCK_AUTO_RELEASE,  
                IndicesService.CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING,
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_LEVEL,
import org.opensearch.monitor.fs.FsHealthService;  
                JvmService.REFRESH_INTERVAL_SETTING,
                BootstrapSettings.SYSTEM_CALL_FILTER_SETTING,
import org.opensearch.transport.SniffConnectionStrategy;  
                ElectionSchedulerFactory.ELECTION_DURATION_SETTING,
                HttpTransportSettings.SETTING_HTTP_HOST,
                // Search request slow log settings  
import org.opensearch.indices.store.IndicesStore;
                Environment.PATH_LOGS_SETTING,  
                TransportSettings.OLD_TCP_NO_DELAY_PROFILE,
                FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING,
                BootstrapSettings.CTRLHANDLER_SETTING,  
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;  
import org.opensearch.index.ShardIndexingPressureMemoryManager;  
                    } else {
                TransportSettings.OLD_TCP_NO_DELAY,
import org.opensearch.search.backpressure.settings.SearchTaskSettings;  
                WorkloadManagementSettings.NODE_LEVEL_CPU_REJECTION_THRESHOLD,
                ForceMergeManagerSettings.AUTO_FORCE_MERGE_SETTING,
            )
                TransportSettings.OLD_TRANSPORT_COMPRESS,
                AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_FORCE_GROUP_SETTING,
                FilterAllocationDecider.CLUSTER_ROUTING_INCLUDE_GROUP_SETTING,
                NetworkService.GLOBAL_NETWORK_BIND_HOST_SETTING,
                if (loggerPredicate.test(key) && builder.keys().contains(key) == false) {  
                // Thread pool Settings
                AwarenessReplicaBalance.CLUSTER_ROUTING_ALLOCATION_AWARENESS_BALANCE_SETTING,
                // Tiered caching settings
 * ownership. Elasticsearch licenses this file to you under  
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING,
                RemoteStoreSettings.CLUSTER_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING,
                BreakerSettings.CIRCUIT_BREAKER_TYPE,
                NetworkService.NETWORK_SERVER,
    public static final Map<List<String>, List<Setting>> FEATURE_FLAGGED_CLUSTER_SETTINGS = Map.of(  
                // Related to monitoring of task cancellation
                IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING,  
import org.opensearch.transport.RemoteConnectionStrategy;
                HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_TYPE_SETTING,  
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING,
                CpuBasedAdmissionControllerSettings.INDEXING_CPU_USAGE_LIMIT,
/**
                PageCacheRecycler.WEIGHT_BYTES_SETTING,  
import org.opensearch.storage.common.tiering.TieringUtils;  
        public Settings getValue(Settings current, Settings previous) {
                LeaderChecker.LEADER_CHECK_INTERVAL_SETTING,
import org.opensearch.common.util.FeatureFlags;
                PageCacheRecycler.WEIGHT_OBJECTS_SETTING,  
            TelemetrySettings.TRACER_SAMPLER_PROBABILITY,
                SnapshotsService.SNAPSHOT_CLEANUP_RETRY_BACKOFF_SETTING,
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_WARM_DISK_THRESHOLD_ENABLED_SETTING,
import org.opensearch.plugins.PluginsService;  
                SearchShardTaskSettings.SETTING_ELAPSED_TIME_MILLIS_THRESHOLD,  
                SearchService.SEARCH_MAX_QUERY_NESTING_DEPTH,
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;  
                TransportSettings.CONNECTIONS_PER_NODE_BULK,
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_LOOKBACK_INTERVAL,  
                PageCacheRecycler.WEIGHT_LONG_SETTING,
                    Loggers.setLevel(LogManager.getLogger(component), value.get(key));  
                    }
                SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY,
                HttpTransportSettings.SETTING_HTTP_HTTP3_ENABLED,  
                BreakerSettings.CIRCUIT_BREAKER_LIMIT_SETTING,  
                BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING,
                HttpTransportSettings.SETTING_HTTP_TRACE_LOG_INCLUDE,
                ShardLimitValidator.SETTING_CLUSTER_MAX_REMOTE_CAPABLE_SHARDS_PER_CLUSTER,  
import org.opensearch.common.network.NetworkService;  
                HttpTransportSettings.SETTING_CORS_ALLOW_CREDENTIALS,
                BootstrapSettings.MEMORY_LOCK_SETTING,
                RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING,
                DiskThresholdSettings.CLUSTER_CREATE_INDEX_BLOCK_AUTO_RELEASE,
import org.opensearch.transport.RemoteClusterService;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.env.Environment;
                DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING,
                BalancedShardsAllocator.IGNORE_THROTTLE_FOR_REMOTE_RESTORE,
                OpenSearchOnHeapCacheSettings.MAXIMUM_SIZE_IN_BYTES.getConcreteSettingForNamespace(
                TaskResourceTrackingService.BINARY_RESOURCE_USAGE_HEADER_ENABLED,
                NativeMemoryBasedAdmissionControllerSettings.CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT,
                IndexingMemoryController.MIN_NATIVE_INDEX_BUFFER_SIZE_SETTING,  
                ScriptService.SCRIPT_GENERAL_CACHE_SIZE_SETTING,
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING,
                AwarenessAllocationDecider.CLUSTER_ROUTING_ALLOCATION_AWARENESS_ATTRIBUTE_SETTING,  
                SearchTaskSettings.SETTING_CANCELLATION_BURST,  
                MappingUpdatedAction.INDICES_MAX_IN_FLIGHT_UPDATES_SETTING,
                SniffConnectionStrategy.REMOTE_CLUSTER_SEEDS,  
                TransportSettings.TCP_SEND_BUFFER_SIZE_PROFILE,
                HttpTransportSettings.SETTING_HTTP_DETAILED_ERRORS_ENABLED,
                SearchTaskSettings.SETTING_HEAP_VARIANCE_THRESHOLD,
 * this work for additional information regarding copyright
                NetworkService.TCP_KEEP_COUNT,
                SearchService.MAX_KEEPALIVE_SETTING,
import org.opensearch.discovery.HandshakingTransportAddressConnector;
 * compatible open source license.
                StreamTransportService.STREAM_TRANSPORT_REQ_TIMEOUT_SETTING,
                HttpTransportSettings.SETTING_CORS_MAX_AGE,
                TransportSettings.BIND_HOST_PROFILE,
import org.opensearch.action.support.replication.TransportReplicationAction;
                RemoteIndexMetadataManager.REMOTE_INDEX_METADATA_PATH_TYPE_SETTING,
                RemoteClusterService.ENABLE_REMOTE_CLUSTERS,  
import org.opensearch.cluster.routing.allocation.decider.ConcurrentRecoveriesAllocationDecider;  
                IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING,
import org.opensearch.common.cache.CacheType;
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
                RemoteClusterStateService.CLUSTER_REMOTE_STORE_STATE_PATH_PREFIX,
                RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_MAX_BYTES_PER_SEC_SETTING,  
                WorkloadManagementSettings.NODE_LEVEL_MEMORY_REJECTION_THRESHOLD,  
            for (String key : previous.keySet()) {
                TransportSettings.PUBLISH_HOST_PROFILE,  
                BalancedShardsAllocator.SHARD_MOVEMENT_STRATEGY_SETTING,  
import org.opensearch.cluster.service.ClusterApplierService;
                RemoteRoutingTableBlobStore.REMOTE_ROUTING_TABLE_PATH_HASH_ALGO_SETTING,  
                RemoteClusterService.REMOTE_CLUSTER_COMPRESS,
                IoBasedAdmissionControllerSettings.SEARCH_IO_USAGE_LIMIT,
            for (String key : value.keySet()) {
                ShardIndexingPressureMemoryManager.THROUGHPUT_DEGRADATION_LIMITS,
                IngestService.SYSTEM_INGEST_PIPELINE_ENABLED,  
            TelemetrySettings.METRICS_PUBLISH_INTERVAL_SETTING,
import org.opensearch.monitor.jvm.JvmGcMonitorService;  
import org.opensearch.common.settings.Setting.Property;
                CpuBasedAdmissionControllerSettings.CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE,  
                RecoverySettings.INDICES_TRANSLOG_CONCURRENT_RECOVERY_ENABLE,
import org.opensearch.search.aggregations.metrics.CardinalityAggregator;
                NetworkModule.TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION,
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
                DiskThresholdSettings.INDEX_READ_BLOCK_AUTO_RELEASE_EXCLUDE_PATTERNS,
                TransportSettings.TCP_NO_DELAY,  
import org.opensearch.action.support.DestructiveOperations;
import org.opensearch.index.MergeSchedulerConfig;
                IndicesService.CLUSTER_REFRESH_SHARD_LEVEL_ENABLED_SETTING,
import org.opensearch.transport.AuxTransport;
                SearchService.MAX_PIT_KEEPALIVE_SETTING,
                ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING,
                PersistedClusterStateService.SLOW_WRITE_LOGGING_THRESHOLD,
        super(nodeSettings, settingsSet, settingUpgraders, Property.NodeScope);
                SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING,
                TransportCloseIndexAction.CLUSTER_INDICES_CLOSE_ENABLE_SETTING,  
                ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING,
                CardinalityAggregator.CARDINALITY_AGGREGATION_HYBRID_COLLECTOR_ENABLED,
                TransportSettings.TCP_NO_DELAY_PROFILE,
                TransportSettings.TRANSPORT_COMPRESS,  
                FlushModeResolver.STREAMING_MIN_ESTIMATED_BUCKET_COUNT,
import org.opensearch.indices.ClusterMergeSchedulerConfig;
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_FLAT_SKEW_SETTING,
import org.opensearch.index.remote.RemoteStorePressureSettings;
        addSettingsUpdater(new LoggingSettingUpdater(nodeSettings));  
                RemoteClusterStateService.REMOTE_PUBLICATION_SETTING,
                WorkloadManagementSettings.NODE_LEVEL_MEMORY_CANCELLATION_THRESHOLD,
                HttpTransportSettings.SETTING_HTTP_COMPRESSION,
    );
                RecoverySettings.INDICES_RECOVERY_MAX_CONCURRENT_OPERATIONS_SETTING,
                RemoteStorePressureSettings.BYTES_LAG_VARIANCE_FACTOR,
                InternalClusterInfoService.INTERNAL_CLUSTER_INFO_UPDATE_INTERVAL_SETTING,  
        private final Settings settings;
                IoBasedAdmissionControllerSettings.IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE,
        @Override
                KeyStoreWrapper.SEED_SETTING,
                NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_USAGE_LIMIT,  
import org.opensearch.cluster.action.shard.ShardStateAction;  
                SearchShardTaskSettings.SETTING_CANCELLATION_RATE,  
                ForceMergeManagerSettings.DISK_THRESHOLD_PERCENTAGE_FOR_AUTO_FORCE_MERGE,
                TransportSettings.TCP_RECEIVE_BUFFER_SIZE_PROFILE,
                HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_OVERHEAD_SETTING,
                SearchRequestStats.SEARCH_REQUEST_STATS_ENABLED,
                ClusterApplierService.CLUSTER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING,
                JvmGcMonitorService.ENABLED_SETTING,
 * The OpenSearch Contributors require contributions made to  
                assert loggerPredicate.test(key);
                SearchService.AGGREGATION_REWRITE_FILTER_SEGMENT_THRESHOLD,
                RecoverySettings.INDICES_INTERNAL_REMOTE_UPLOAD_TIMEOUT,
                ShardsBatchGatewayAllocator.PRIMARY_BATCH_ALLOCATOR_TIMEOUT_SETTING,
import org.opensearch.transport.StreamTransportService;
import java.util.Map;
import org.opensearch.gateway.ShardsBatchGatewayAllocator;
                ClusterMergeSchedulerConfig.CLUSTER_MAX_MERGE_COUNT_SETTING,
                NetworkService.GLOBAL_NETWORK_HOST_SETTING,  
                RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING,
                ScriptService.CONTEXTS_ALLOWED_SETTING,
                GLOBAL_METADATA_UPLOAD_TIMEOUT_SETTING,
import org.opensearch.cluster.service.ClusterManagerService;
    );
                RemoteClusterService.REMOTE_CLUSTER_PING_SCHEDULE,
                IndexingMemoryController.MIN_INDEX_BUFFER_SIZE_SETTING,
                SearchShardTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE,
                HttpTransportSettings.SETTING_CORS_ALLOW_HEADERS,
import java.util.function.Predicate;
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_SKEW_FACTOR_SETTING,
                NetworkService.TCP_NO_DELAY,  
import org.opensearch.threadpool.ThreadPool;
                CreatePitController.PIT_INIT_KEEP_ALIVE,
                ResourceTrackerSettings.NODE_NATIVE_MEMORY_BUFFER_PERCENT_SETTING,  
                TieringUtils.PREPARE_TIERING_TIMEOUT,
                SearchBackpressureSettings.SETTING_CANCELLATION_BURST,   // deprecated
                HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_OVERHEAD_SETTING,  
import org.opensearch.gateway.GatewayService;
                BootstrapSettings.SECURITY_FILTER_BAD_DEFAULTS_SETTING,  
import org.opensearch.indices.IndicesRequestCache;  
                FsService.REFRESH_INTERVAL_SETTING,
            TelemetrySettings.TRACER_FEATURE_ENABLED_SETTING,  
                ClusterManagerService.CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING,
                JvmGcMonitorService.GC_OVERHEAD_DEBUG_SETTING,  
/*  
import org.opensearch.action.search.SearchRequestSlowLog;
                ScriptService.SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING,  
                PageCacheRecycler.TYPE_SETTING,
                HttpTransportSettings.SETTING_HTTP_CONNECT_TIMEOUT,
                ScriptService.SCRIPT_MAX_SIZE_IN_BYTES,
                ElectionSchedulerFactory.ELECTION_MAX_TIMEOUT_SETTING,
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX,  
                SearchShardTaskSettings.SETTING_TOTAL_HEAP_PERCENT_THRESHOLD,
import org.opensearch.search.streaming.FlushModeResolver;  
                RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING,
                    if (rootLevel == null) {  
 * specific language governing permissions and limitations
                IndexSettings.TIME_SERIES_INDEX_MERGE_POLICY,
        new HashSet<>(
                Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING,  
                RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING,
import org.opensearch.watcher.ResourceWatcherService;
import org.opensearch.action.admin.indices.close.TransportCloseIndexAction;
                ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING,  
                OperationRouting.STRICT_SEARCH_REPLICA_ROUTING_ENABLED,  
                NetworkService.TCP_CONNECT_TIMEOUT,
                SearchIndexPruningSettings.MIN_SHARDS,  
        this(nodeSettings, settingsSet, Collections.emptySet());
                IoBasedAdmissionControllerSettings.INDEXING_IO_USAGE_LIMIT,  
                TransportSettings.PUBLISH_HOST,
import org.opensearch.action.search.SearchRequestStats;
                TransportReplicationAction.REPLICATION_RETRY_TIMEOUT,
                FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING,
                AuxTransport.AUX_TRANSPORT_TYPES_SETTING,
                } else {
                IndicesService.CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING,
                ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING,
                IndexSettings.QUERY_STRING_ALLOW_LEADING_WILDCARD,
import org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider;
                TieringUtils.REPLICA_SYNC_TIMEOUT_SETTING,  
        }  
                ScriptService.SCRIPT_GENERAL_CACHE_EXPIRE_SETTING,
                HttpTransportSettings.SETTING_HTTP_RESET_COOKIES,  
                Environment.PIDFILE_SETTING,  
 * You may obtain a copy of the License at  
                TransportSettings.OLD_TCP_REUSE_ADDRESS_PROFILE,
                NetworkService.TCP_SEND_BUFFER_SIZE,  
                BlobStoreRepository.SNAPSHOT_SHARD_PATH_PREFIX_SETTING,
                SearchShardTaskSettings.SETTING_HEAP_PERCENT_THRESHOLD,
                // Settings to be used for limiting rest requests  
                }
        public void apply(Settings value, Settings current, Settings previous) {  
import org.opensearch.node.remotestore.RemoteStoreNodeService;
                SameShardAllocationDecider.CLUSTER_ROUTING_ALLOCATION_SAME_HOST_SETTING,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.support.AutoCreateIndex;  
                FsRepository.REPOSITORIES_COMPRESS_SETTING,  
import org.opensearch.indices.recovery.RecoverySettings;
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED,
                FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING,  
                DiscoveryModule.DISCOVERY_TYPE_SETTING,
import org.opensearch.env.NodeEnvironment;  
                SniffConnectionStrategy.REMOTE_CLUSTER_EXPECTED_NAME,
                ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING,  
import org.opensearch.cluster.routing.allocation.decider.NodeLoadAwareAllocationDecider;  
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_PROVISIONED_CAPACITY_SETTING,
import org.opensearch.index.ShardIndexingPressureStore;
                TieringUtils.H2W_MAX_CONCURRENT_TIERING_REQUESTS,
                SearchTaskSettings.SETTING_TOTAL_HEAP_PERCENT_THRESHOLD,  
                SearchTaskSettings.SETTING_HEAP_MOVING_AVERAGE_WINDOW_SIZE,  
import org.opensearch.tasks.TaskCancellationMonitoringSettings;
                METADATA_MANIFEST_UPLOAD_TIMEOUT_SETTING,
}
                IndicesRequestCache.INDICES_CACHE_QUERY_EXPIRE,
                FlushModeResolver.STREAMING_MAX_ESTIMATED_BUCKET_COUNT,
                TransportSettings.PUBLISH_PORT_PROFILE,
                RecoverySettings.INDICES_REPLICATION_MAX_BYTES_PER_SEC_SETTING,  
import org.opensearch.cluster.metadata.Metadata;
                SettingsBasedSeedHostsProvider.LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_SETTING,  
import org.opensearch.common.util.concurrent.ThreadContext;
    }
    }
                IndicesRequestCache.INDICES_CACHE_QUERY_SIZE,
                EnableAssignmentDecider.CLUSTER_TASKS_ALLOCATION_ENABLE_SETTING,  
     * Map of feature flag name to feature-flagged cluster settings. Once each feature
                HttpTransportSettings.SETTING_CORS_ALLOW_METHODS,  
import java.util.Arrays;
 *     http://www.apache.org/licenses/LICENSE-2.0
                WorkloadManagementSettings.NODE_LEVEL_CPU_CANCELLATION_THRESHOLD,
                NetworkModule.TRANSPORT_SSL_DUAL_MODE_ENABLED,
                CardinalityAggregator.CARDINALITY_AGGREGATION_HYBRID_COLLECTOR_MEMORY_THRESHOLD,  
            TelemetrySettings.TRACER_ENABLED_SETTING,  
                BalancedShardsAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING,
                ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_CLUSTER,
                Node.WRITE_PORTS_FILE_SETTING,  
                WorkloadManagementSettings.QUERYGROUP_SERVICE_RUN_INTERVAL_SETTING,  
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
                BootstrapSettings.SERIAL_FILTER_SETTING,
                RemoteClusterStateService.REMOTE_STATE_READ_TIMEOUT_SETTING,  
                TopNSearchTasksLogger.LOG_TOP_QUERIES_SIZE_SETTING,  
 *
import org.opensearch.node.Node;
import org.opensearch.cluster.coordination.ClusterFormationFailureHelper;  
                JoinHelper.JOIN_TIMEOUT_SETTING,
                    continue;
                ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE,  
                ShardIndexingPressureMemoryManager.LOWER_OPERATING_FACTOR,
import org.opensearch.persistent.decider.EnableAssignmentDecider;
import org.opensearch.telemetry.TelemetrySettings;  
                ShardLimitValidator.SETTING_CLUSTER_IGNORE_DOT_INDEXES,
                        Loggers.setLevel(LogManager.getRootLogger(), rootLevel);  
        List.of(FeatureFlags.TELEMETRY),
     * setting should be moved to {@link #BUILT_IN_CLUSTER_SETTINGS}.
import org.opensearch.node.NodeRoleSettings;
import static org.opensearch.gateway.remote.RemoteManifestManager.METADATA_MANIFEST_UPLOAD_TIMEOUT_SETTING;
                IndicesService.CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING,
                TransportSettings.CONNECTIONS_PER_NODE_STATE,  
                NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING,
                ShardIndexingPressureMemoryManager.OPTIMAL_OPERATING_FACTOR,
                TieredStoragePrefetchSettings.STORED_FIELDS_PREFETCH_ENABLED_SETTING,
        }
                NodeLoadAwareAllocationDecider.CLUSTER_ROUTING_ALLOCATION_LOAD_AWARENESS_ALLOW_UNASSIGNED_PRIMARIES_SETTING,  
                PeerFinder.DISCOVERY_REQUEST_PEERS_TIMEOUT_SETTING,  
import org.opensearch.cluster.coordination.Reconfigurator;
import org.opensearch.transport.ProxyConnectionStrategy;  
                RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING,  
                ElectionSchedulerFactory.ELECTION_BACK_OFF_TIME_SETTING,  
 * this file be licensed under the Apache-2.0 license or a
                IndicesService.CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING,  
                SearchService.SEARCH_MAX_QUERY_STRING_LENGTH,  
                SearchService.TERMS_AGGREGATION_MAX_PRECOMPUTE_CARDINALITY,
                SearchService.MAX_OPEN_SCROLL_CONTEXT,  
import org.opensearch.gateway.DanglingIndicesState;
                Metadata.DEFAULT_REPLICA_COUNT_SETTING,
import java.util.Set;  
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING,
 * Licensed to Elasticsearch under one or more contributor  
                // Concurrent segment search settings
                TransportSettings.TCP_KEEP_COUNT,
                        Loggers.setLevel(LogManager.getRootLogger(), Loggers.LOG_DEFAULT_LEVEL_SETTING.get(settings));
                RemoteStorePressureSettings.UPLOAD_TIME_LAG_VARIANCE_FACTOR,
                TransportSettings.OLD_TCP_SEND_BUFFER_SIZE_PROFILE,
                ProxyConnectionStrategy.REMOTE_SOCKET_CONNECTIONS,
                ResourceWatcherService.RELOAD_INTERVAL_MEDIUM,
                ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE,
import org.opensearch.cluster.coordination.ElectionSchedulerFactory;
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX,
import static org.opensearch.gateway.remote.RemoteIndexMetadataManager.INDEX_METADATA_UPLOAD_TIMEOUT_SETTING;
import org.opensearch.cluster.coordination.ClusterBootstrapService;
    );  
import java.util.Collections;
                ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING,  
                NodeDuressSettings.SETTING_NUM_SUCCESSIVE_BREACHES,
/*
                ForceMergeManagerSettings.CONCURRENCY_MULTIPLIER,  
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.cluster.ClusterModule;
                SearchBackpressureSettings.SETTING_CANCELLATION_RATE,   // deprecated
                }  
                TaskCancellationMonitoringSettings.DURATION_MILLIS_SETTING,
                RemoteClusterStateService.REMOTE_CLUSTER_STATE_CHECKSUM_VALIDATION_MODE_SETTING,
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.NodeConnectionsService;
                NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT,
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING,
                FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING,
                NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE,
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING,  
 *  
                TransportSettings.TCP_KEEP_INTERVAL,
                LeaderChecker.LEADER_CHECK_RETRY_COUNT_SETTING,
                RecoverySettings.INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_MAX_CONCURRENT_PARTS_SETTING,
                ForceMergeManagerSettings.MERGE_DELAY_BETWEEN_SHARDS_FOR_AUTO_FORCE_MERGE,
                IndexingPressure.MAX_INDEXING_BYTES,
                TopNSearchTasksLogger.LOG_TOP_QUERIES_FREQUENCY_SETTING,
                ThreadContext.DEFAULT_HEADERS_SETTING,  
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;  
                // Pluggable dataformat cluster defaults
import org.opensearch.tasks.TaskManager;  
                SearchShardTaskSettings.SETTING_CANCELLATION_RATIO,
                if ("_root".equals(component)) {
                SeedHostsResolver.LEGACY_DISCOVERY_ZEN_PING_UNICAST_CONCURRENT_CONNECTS_SETTING,  
                TransportSettings.TCP_KEEP_IDLE_PROFILE,
                ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED,
                GatewayService.EXPECTED_DATA_NODES_SETTING,  
                // Settings related to Remote Refresh Segment Pressure
                ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING,
                INDEX_METADATA_UPLOAD_TIMEOUT_SETTING,  
                SystemTemplatesService.SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED,
                HunspellService.HUNSPELL_LAZY_LOAD,  
                PeerFinder.DISCOVERY_FIND_PEERS_INTERVAL_SETTING,
                Reconfigurator.CLUSTER_AUTO_SHRINK_VOTING_CONFIGURATION,  
                SearchTaskSettings.SETTING_CANCELLATION_RATE,
                AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE,
                Client.CLIENT_TYPE_SETTING_S,
                FsRepository.REPOSITORIES_LOCATION_SETTING,
import org.opensearch.cluster.routing.allocation.decider.ConcurrentRebalanceAllocationDecider;
                HttpTransportSettings.SETTING_HTTP_READ_TIMEOUT,
import org.opensearch.gateway.remote.RemoteIndexMetadataManager;
                // Server Side encryption enabled
 * not use this file except in compliance with the License.
import org.opensearch.bootstrap.BootstrapSettings;  
                RemoteStoreSettings.CLUSTER_REMOTE_INDEX_SEGMENT_METADATA_RETENTION_MAX_COUNT_SETTING,
                SearchService.MAX_OPEN_PIT_CONTEXT,
     */
                RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING,  
                IndicesService.CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING,
                SeedHostsResolver.LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_RESOLVE_TIMEOUT,
                RemoteStoreStatsTrackerFactory.MOVING_AVERAGE_WINDOW_SIZE,  
import org.opensearch.script.ScriptService;
                HttpTransportSettings.SETTING_HTTP_TRACE_LOG_EXCLUDE,
                SearchTaskSettings.SETTING_CANCELLATION_RATIO,
                TransportSettings.PUBLISH_PORT,  
@PublicApi(since = "1.0.0")  
                RemoteStoreSettings.CLUSTER_REMOTE_TRANSLOG_TRANSFER_TIMEOUT_SETTING,
                    final String rootLevel = value.get(key);
                CpuBasedAdmissionControllerSettings.SEARCH_CPU_USAGE_LIMIT,
    public static Set<Setting<?>> BUILT_IN_CLUSTER_SETTINGS = Collections.unmodifiableSet(  
                RemoteRoutingTableBlobStore.CLUSTER_REMOTE_STORE_ROUTING_TABLE_PATH_PREFIX,
                NetworkModule.STREAM_TRANSPORT_DEFAULT_TYPE_SETTING,
                TransportSearchAction.SHARD_COUNT_LIMIT_SETTING,
 */
                RemoteStoreSettings.CLUSTER_REMOTE_SEGMENT_TRANSFER_TIMEOUT_SETTING,  
import org.opensearch.ratelimitting.admissioncontrol.settings.CpuBasedAdmissionControllerSettings;
                Environment.PATH_DATA_SETTING,
                RecoverySettings.INDICES_RECOVERY_CHUNK_SIZE_SETTING,  
                HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING,  
                IndicesQueryCache.INDICES_QUERY_CACHE_MIN_FREQUENCY,
 */
                        builder.put(key, Loggers.LOG_LEVEL_SETTING.getConcreteSetting(key).get(settings).toString());
                ForceMergeManagerSettings.TRANSLOG_AGE_AUTO_FORCE_MERGE,  
                RecoverySettings.INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING,
                // Settings related to search backpressure
                ResponseLimitSettings.CAT_INDICES_RESPONSE_LIMIT_SETTING,
                IndicesService.INDICES_ID_FIELD_DATA_ENABLED_SETTING,  
import org.opensearch.repositories.fs.FsRepository;  
                FsHealthService.ENABLED_SETTING,  
                BlobStoreRepository.SNAPSHOT_REPOSITORY_DATA_CACHE_THRESHOLD,  
                ForceMergeManagerSettings.CPU_THRESHOLD_PERCENTAGE_FOR_AUTO_FORCE_MERGE,  
                FilterAllocationDecider.CLUSTER_ROUTING_REQUIRE_GROUP_SETTING,
                TransportSettings.DEFAULT_FEATURES_SETTING,
                ShardIndexingPressureMemoryManager.NODE_SOFT_LIMIT,
import org.opensearch.index.IndexingPressure;  
                TransportSearchAction.SEARCH_PHASE_TOOK_ENABLED,  
                ForceMergeManagerSettings.SEGMENT_COUNT_FOR_AUTO_FORCE_MERGE,
import org.opensearch.cluster.action.index.MappingUpdatedAction;
                ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING,
                PublishCheckpointAction.PUBLISH_CHECK_POINT_RETRY_TIMEOUT,  
                SearchService.CLUSTER_ALLOW_DERIVED_FIELD_SETTING,
                    }
                GatewayService.RECOVER_AFTER_TIME_SETTING,
                NetworkModule.TRANSPORT_SSL_ENFORCE_HOSTNAME_VERIFICATION_RESOLVE_HOST_NAME,  
                HttpTransportSettings.SETTING_HTTP_TCP_KEEP_IDLE,
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE),  
                TransportSettings.TCP_KEEP_ALIVE_PROFILE,
import org.opensearch.tasks.TaskResourceTrackingService;
            this.settings = settings;
                Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING,
import org.opensearch.cluster.coordination.JoinHelper;
                ConcurrentRecoveriesAllocationDecider.CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_RECOVERIES_SETTING,
            Arrays.asList(
                NetworkService.TCP_RECEIVE_BUFFER_SIZE,
                Environment.PATH_REPO_SETTING,
import org.opensearch.common.util.PageCacheRecycler;  
                SearchService.KEYWORD_INDEX_OR_DOC_VALUES_ENABLED,
                ShardsLimitAllocationDecider.CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING,
                SearchIndexPruningSettings.ENABLED,
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
                TransportSettings.TCP_REUSE_ADDRESS,  
                TieredStoragePrefetchSettings.READ_AHEAD_BLOCK_COUNT,  
                FsHealthService.HEALTHY_TIMEOUT_SETTING,  
                SniffConnectionStrategy.REMOTE_NODE_CONNECTIONS,
                IndicesService.CLUSTER_DEFAULT_INDEX_MAX_MERGE_AT_ONCE_SETTING,  
                BaseRestHandler.MULTI_ALLOW_EXPLICIT_INDEX,  
                ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED,  
                JvmGcMonitorService.GC_OVERHEAD_WARN_SETTING,
                TransportSettings.TRACE_LOG_EXCLUDE_SETTING,
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
                OpenSearchExecutors.PROCESSORS_SETTING,
                RecoverySettings.INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_PART_SIZE_SETTING,  
                IndexingMemoryController.SHARD_INACTIVE_TIME_SETTING,  
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING,  
                RemoteClusterService.REMOTE_NODE_ATTRIBUTE,
                IndexGraveyard.SETTING_MAX_TOMBSTONES,
            return current.filter(loggerPredicate).equals(previous.filter(loggerPredicate)) == false;
                IndicesFieldDataCache.INDICES_FIELDDATA_CACHE_SIZE_KEY,  
                ShardsBatchGatewayAllocator.FOLLOW_UP_REROUTE_PRIORITY_SETTING,  
                HttpTransportSettings.SETTING_HTTP_MAX_CONTENT_LENGTH,
import org.opensearch.search.SearchService;  
 */
                ClusterBootstrapService.UNCONFIGURED_BOOTSTRAP_TIMEOUT_SETTING,
                Coordinator.PUBLISH_INFO_TIMEOUT_SETTING,
                DiscoveryModule.LEGACY_DISCOVERY_HOSTS_PROVIDER_SETTING,  
import org.opensearch.wlm.WorkloadManagementSettings;
                NetworkModule.TRANSPORT_DEFAULT_TYPE_SETTING,  
                RemoteClusterStateService.REMOTE_STATE_DOWNLOAD_TO_SERVE_READ_API,
 * the Apache License, Version 2.0 (the "License"); you may
                HttpTransportSettings.SETTING_HTTP_CONTENT_TYPE_REQUIRED,  
                IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING,
                TransportSettings.TCP_KEEP_ALIVE,  
import org.opensearch.monitor.jvm.HotThreads;
                HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING,
                NetworkService.TCP_KEEP_INTERVAL,  
                Loggers.LOG_DEFAULT_LEVEL_SETTING,
import org.opensearch.transport.client.Client;  
                HttpTransportSettings.SETTING_CORS_ENABLED,  
                TransportSettings.PING_SCHEDULE,
                SniffConnectionStrategy.REMOTE_CLUSTERS_PROXY,
                ClusterManagerTaskThrottler.BASE_DELAY_SETTINGS,  
                PageCacheRecycler.WEIGHT_INT_SETTING,
                FlushModeResolver.STREAMING_MIN_CARDINALITY_RATIO,  
                // Settings related to Searchable Snapshots
                CompositeIndexSettings.COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING,
                IndexingMemoryController.SHARD_MEMORY_INTERVAL_TIME_SETTING,
import org.opensearch.persistent.PersistentTasksClusterService;
 * KIND, either express or implied.  See the License for the
                    } else {  
import org.opensearch.action.search.StreamSearchTransportService;  
import org.opensearch.monitor.fs.FsService;
import org.opensearch.monitor.memory.NativeMemoryService;
                SearchService.QUERY_REWRITING_TERMS_THRESHOLD_SETTING,
import org.opensearch.cluster.applicationtemplates.SystemTemplatesService;
                DiskThresholdSettings.ENABLE_FOR_SINGLE_DATA_NODE,
                IngestService.MAX_NUMBER_OF_INGEST_PROCESSORS,
import org.opensearch.action.admin.cluster.configuration.TransportAddVotingConfigExclusionsAction;
                DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING,
                AutoCreateIndex.AUTO_CREATE_INDEX_SETTING,
                ShardIndexingPressureMemoryManager.MAX_OUTSTANDING_REQUESTS,
import org.opensearch.cluster.routing.UnassignedInfo;  
                NodeDuressSettings.SETTING_CPU_THRESHOLD,  
                IndicesService.CLUSTER_REFRESH_FIXED_INTERVAL_SCHEDULE_ENABLED_SETTING,  
import org.opensearch.cluster.routing.allocation.FileCacheThresholdSettings;
                NodeRoleSettings.NODE_ROLES_SETTING,
                RemoteClusterService.REMOTE_INITIAL_CONNECTION_TIMEOUT_SETTING,
                Node.NODE_LOCAL_STORAGE_SETTING,  
                HttpTransportSettings.SETTING_HTTP_REQUEST_ID_MAX_LENGTH,
                HttpTransportSettings.SETTING_HTTP_DETAILED_ERRORS_ENABLED,
                ClusterModule.SHARDS_ALLOCATOR_TYPE_SETTING,  
                ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING,  // deprecated
                ),  
                RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_TIMEOUT_SETTING,
                TransportSettings.TCP_SEND_BUFFER_SIZE,  
                BalancedShardsAllocator.THRESHOLD_SETTING,
import org.opensearch.search.backpressure.settings.SearchShardTaskSettings;
                Metadata.SETTING_READ_ONLY_SETTING,
                OperationRouting.IGNORE_AWARENESS_ATTRIBUTES_SETTING,
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.gateway.remote.RemoteClusterStateCleanupManager;
                ConcurrentRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_REBALANCE_SETTING,
                MergeSchedulerConfig.CLUSTER_MAX_FORCE_MERGE_MB_PER_SEC_SETTING,  
                TransportSearchAction.SEARCH_CANCEL_AFTER_TIME_INTERVAL_SETTING,
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;  
                EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING,
                HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_OVERHEAD_SETTING,
                NetworkModule.HTTP_TYPE_SETTING,
                TransportSettings.TRACE_LOG_INCLUDE_SETTING,  
 */  
import org.opensearch.ratelimitting.admissioncontrol.settings.IoBasedAdmissionControllerSettings;  
                HttpTransportSettings.SETTING_HTTP_TCP_RECEIVE_BUFFER_SIZE,  
                TransportSettings.OLD_TCP_KEEP_ALIVE_PROFILE,
        List.of(
                IndicesBitsetFilterCache.INDICES_BITSET_FILTER_CACHE_SIZE_SETTING,
                DiscoveryModule.ELECTION_STRATEGY_SETTING,
                HttpTransportSettings.SETTING_HTTP_TCP_REUSE_ADDRESS,
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED,
import org.opensearch.ratelimitting.admissioncontrol.AdmissionControlSettings;
                BreakerSettings.CIRCUIT_BREAKER_OVERHEAD_SETTING,
                FastVectorHighlighter.SETTING_TV_HIGHLIGHT_MULTI_VALUE,
import org.opensearch.cluster.InternalClusterInfoService;  
                HttpTransportSettings.SETTING_HTTP_MAX_CHUNK_SIZE,
                ClusterMergeSchedulerConfig.CLUSTER_MAX_THREAD_COUNT_SETTING,  
                WorkloadManagementSettings.WLM_MODE_SETTING,
                ScriptService.SCRIPT_CACHE_SIZE_SETTING,
                ProxyConnectionStrategy.SERVER_NAME,
                SearchBackpressureSettings.SETTING_MODE,  
            }
                NodeDuressSettings.SETTING_HEAP_THRESHOLD,
                RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING,
                // Settings related to Remote Store stats
                JvmGcMonitorService.GC_SETTING,  
import org.opensearch.monitor.os.OsService;  
                WorkloadManagementSettings.QUERYGROUP_SERVICE_DURESS_STREAK_SETTING,
                RemoteStorePressureSettings.REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED,  
            builder.put(current.filter(loggerPredicate));
                TieringUtils.JVM_USAGE_TIERING_THRESHOLD_PERCENT,  
                JvmGcMonitorService.GC_OVERHEAD_INFO_SETTING,
                ),  
                SearchShardTaskSettings.SETTING_CANCELLATION_BURST,
import org.opensearch.action.search.pruning.SearchIndexPruningSettings;
                InternalSnapshotsInfoService.INTERNAL_SNAPSHOT_INFO_MAX_CONCURRENT_FETCHES_SETTING,
                SearchPipelineService.ENABLED_SYSTEM_GENERATED_FACTORIES_SETTING,  
import org.opensearch.search.pipeline.SearchPipelineService;
import org.opensearch.indices.RemoteStoreSettings;
                BalancedShardsAllocator.SHARD_MOVE_PRIMARY_FIRST_SETTING,
                Coordinator.PUBLISH_TIMEOUT_SETTING,  
                ResourceWatcherService.ENABLED,
                HunspellService.HUNSPELL_DICTIONARY_OPTIONS,
                RemoteRoutingTableBlobStore.REMOTE_ROUTING_TABLE_PATH_TYPE_SETTING,
                SearchTaskSettings.SETTING_NATIVE_MEMORY_PERCENT_THRESHOLD,
                TransportSettings.OLD_PORT,  
                RemoteStoreSettings.CLUSTER_REMOTE_STORE_FENCING_ENABLED,
import org.opensearch.indices.ShardLimitValidator;  
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING,
                    CacheType.INDICES_REQUEST_CACHE.getSettingPrefix()
import org.apache.logging.log4j.LogManager;  
import org.opensearch.index.autoforcemerge.ForceMergeManagerSettings;  
 * GitHub history for details.
                RecoverySettings.INDICES_RECOVERY_INTERNAL_ACTION_RETRY_TIMEOUT_SETTING,
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING,
                HttpTransportSettings.SETTING_HTTP_MAX_INITIAL_LINE_LENGTH,  
import org.opensearch.monitor.process.ProcessService;
                HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING,  
                HttpTransportSettings.SETTING_HTTP_TCP_KEEP_COUNT,  
            }
                IndicesRequestCache.INDICES_REQUEST_CACHE_MAX_SIZE_ALLOWED_IN_CACHE_SETTING,
                // Settings related to Auto Force Merge Manager  
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
                RecoverySettings.INDICES_RECOVERY_INTERNAL_ACTION_TIMEOUT_SETTING,  
                ShardIndexingPressureSettings.SHARD_MIN_LIMIT,
                ScriptService.SCRIPT_DISABLE_MAX_COMPILATIONS_RATE_SETTING,  
                NodeEnvironment.MAX_LOCAL_STORAGE_NODES_SETTING,  
                BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING,  
import org.opensearch.indices.breaker.BreakerSettings;
                HandshakingTransportAddressConnector.PROBE_CONNECT_TIMEOUT_SETTING,  
                TieringUtils.W2H_MAX_CONCURRENT_TIERING_REQUESTS,
                NetworkService.TCP_KEEP_ALIVE,
                    if (Loggers.LOG_LEVEL_SETTING.getConcreteSetting(key).exists(settings) == false) {
                HttpTransportSettings.SETTING_HTTP_TCP_SEND_BUFFER_SIZE,
import org.opensearch.index.SegmentReplicationPressureService;
                TransportSettings.PORT,
public final class ClusterSettings extends AbstractScopedSettings {
                ClusterName.CLUSTER_NAME_SETTING,
                NodeDuressSettings.SETTING_NATIVE_MEMORY_THRESHOLD,  
                TransportReplicationAction.REPLICATION_INITIAL_RETRY_BACKOFF_BOUND,
                HttpTransportSettings.SETTING_HTTP_TCP_KEEP_ALIVE,  
                ScriptService.TYPES_ALLOWED_SETTING,  
                SearchService.QUERY_REWRITING_ENABLED_SETTING,  
    private static final class LoggingSettingUpdater implements SettingUpdater<Settings> {  
import org.opensearch.search.backpressure.settings.SearchBackpressureSettings;
                Environment.NODE_PIDFILE_SETTING,
import org.opensearch.action.search.TransportSearchAction;
 *  
        @Override
import org.opensearch.indices.IndexingMemoryController;  
                SearchService.DEFAULT_ALLOW_PARTIAL_SEARCH_RESULTS,
                RecoverySettings.INDICES_TRANSLOG_CONCURRENT_RECOVERY_BATCH_SIZE,
                ClusterManagerTaskThrottler.MAX_DELAY_SETTINGS,
                IndicesService.CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING,  
        LoggingSettingUpdater(Settings settings) {
                Node.NODE_SEARCH_CACHE_SIZE_SETTING,  
                ForceMergeManagerSettings.AUTO_FORCE_MERGE_SCHEDULER_INTERVAL,
                SearchService.SEARCH_MAX_QUERY_STRING_LENGTH_MONITOR_ONLY,
        final Predicate<String> loggerPredicate = Loggers.LOG_LEVEL_SETTING::match;
                IndexingMemoryController.NATIVE_INDEX_BUFFER_SIZE_SETTING,
                BalancedShardsAllocator.PRIMARY_CONSTRAINT_THRESHOLD_SETTING,
import org.opensearch.indices.replication.checkpoint.PublishCheckpointAction;  
                RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_STATE_SYNC_SETTING,  
