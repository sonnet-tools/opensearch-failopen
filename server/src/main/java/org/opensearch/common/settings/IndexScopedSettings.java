                IndexSettings.ALLOW_DERIVED_FIELDS,
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;  
                IndexSettings.MAX_TERMS_COUNT_SETTING,
                IndexSettings.INDEX_UNREFERENCED_FILE_CLEANUP,  
import org.opensearch.common.settings.Setting.Property;  
                StarTreeIndexSettings.STAR_TREE_DEFAULT_MAX_LEAF_DOCS,
                IndexSettings.INDEX_CHECK_ON_STARTUP,  
            case "index.plugins.replication.translog.retention_lease.pruning.enabled":  
                IndexSettings.MAX_NGRAM_DIFF_SETTING,  
                IndexMetadata.INGESTION_SOURCE_TYPE_SETTING,  
import org.opensearch.index.IndexSortConfig;  
                StarTreeIndexSettings.STAR_TREE_MAX_BASE_METRICS_SETTING,
                IndexSettings.SEARCHABLE_SNAPSHOT_INDEX_ID,
     * setting should be moved to {@link #BUILT_IN_INDEX_SETTINGS}.
                IndexModule.INDEX_STORE_PRE_LOAD_SETTING,
                IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT,  
 * SPDX-License-Identifier: Apache-2.0
                IndexMetadata.INDEX_BLOCKS_READ_ONLY_ALLOW_DELETE_SETTING,
import org.opensearch.cluster.metadata.MetadataIndexStateService;
                // Settings for concurrent segment search  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;  
 *     http://www.apache.org/licenses/LICENSE-2.0
                IndexMetadata.INGESTION_SOURCE_MAPPER_TYPE_SETTING,
                IndexSettings.INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING,
import org.opensearch.cluster.metadata.IndexMetadata;  
import java.util.Set;
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING,
                IndexSettings.MAX_TOKEN_COUNT_SETTING,  
                UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING,
                IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING,
                IndexSettings.INDEX_CONTEXT_CREATED_VERSION,
                IndexMetadata.INDEX_BULK_ADAPTIVE_SHARD_SELECTION_ENABLED,  
                IndicesBitsetFilterCache.INDEX_LOAD_RANDOM_ACCESS_FILTERS_EAGERLY_SETTING,  
                TieredMergePolicyProvider.INDEX_MERGE_POLICY_EXPUNGE_DELETES_ALLOWED_SETTING,
                IndexSettings.DEFAULT_SEARCH_PIPELINE,  
import org.opensearch.index.TieredMergePolicyProvider;  
import org.opensearch.index.IndexingSlowLog;
                Store.INDEX_STORE_STATS_REFRESH_INTERVAL_SETTING,
 * You may obtain a copy of the License at  
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING,
/**
                IndexMetadata.INDEX_AUTO_EXPAND_REPLICAS_SETTING,
        super.validateSettingKey(setting);
 * KIND, either express or implied.  See the License for the
 * @see Property#IndexScope  
                IndexMetadata.SETTING_INDEX_VERSION_CREATED,
            case IndexMetadata.INDEX_RESIZE_SOURCE_UUID_KEY:
                IndexSettings.SEARCHABLE_SNAPSHOT_ID_UUID,  
                IndexMetadata.INDEX_READ_ONLY_SETTING,  
                TieredMergePolicyProvider.INDEX_MERGE_POLICY_DELETES_PCT_ALLOWED_SETTING,  
        switch (key) {  
                                "illegal value for [index.similarity." + key + "] cannot redefine built-in similarity"  
import org.opensearch.cluster.routing.UnassignedInfo;
                MergeSchedulerConfig.MAX_FORCE_MERGE_MB_PER_SEC_SETTING,  
                IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING,
                MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING,
                StarTreeIndexSettings.DEFAULT_METRICS_LIST,
 *  
            case IndexMetadata.SETTING_INDEX_PROVIDED_NAME:
                            );
                TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING,  
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING,
                IndexSettings.MAX_ANALYZED_OFFSET_SETTING,
                            throw new IllegalArgumentException(
 * under the License.  
                EngineConfig.INDEX_USE_COMPOUND_FILE,
import org.opensearch.index.MergeSchedulerConfig;
 *
        )
                IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_TRACE_SETTING,
import java.util.Collections;  
import org.opensearch.indices.IndicesRequestCache;
                IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_WARN_SETTING,
                IndexSettings.MAX_SLICES_PER_SCROLL,
    @Override
                MapperService.INDEX_MAPPER_DYNAMIC_SETTING,
                IndexMetadata.INDEX_PRIORITY_SETTING,
import java.util.Arrays;
                IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING,
                IndexSettings.INDEX_REFRESH_INTERVAL_SETTING,
import org.opensearch.index.store.Store;
 * this work for additional information regarding copyright
                StarTreeIndexSettings.STAR_TREE_SEARCH_ENABLED_SETTING,  
                EngineConfig.INDEX_OPTIMIZE_AUTO_GENERATED_IDS,  
                IndexModule.INDEX_TIERING_STATE,  
                ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING,
                IndexMetadata.INDEX_HIDDEN_SETTING,  
     * Map of feature flag name to feature-flagged index setting. Once each feature  
 * ownership. Elasticsearch licenses this file to you under  
                IndexMetadata.INDEX_ROUTING_PARTITION_SIZE_SETTING,  
 * The OpenSearch Contributors require contributions made to  
                IndexMetadata.INGESTION_SOURCE_NUM_PROCESSOR_THREADS_SETTING,
            case IndexMetadata.SETTING_VERSION_UPGRADED:
                // this can be removed in OpenSearch 3.0
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.search.streaming.FlushModeResolver;
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING,
    protected void validateSettingKey(Setting setting) {  
    @Override
                IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING,  
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING,
                IndexSettings.MAX_NESTED_QUERY_DEPTH_SETTING,  
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING,
                IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING,
                // validate that built-in similarities don't get redefined  
                IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING,
                LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGE_SEGMENT_FOR_FORCED_MERGE_SETTING,  
        }  
            case IndexMetadata.INDEX_RESIZE_SOURCE_NAME_KEY:  
                IndexMetadata.INGESTION_SOURCE_ERROR_STRATEGY_SETTING,
 * not use this file except in compliance with the License.
    public boolean isPrivateSetting(String key) {
                // Settings for remote translog  
                IndexSettings.INDEX_SOFT_DELETES_SETTING,
                IndexSettings.SEARCHABLE_SNAPSHOT_REPOSITORY,  
                IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING,
                IndexModule.INDEX_STORE_LOCALITY_SETTING,
                FlushModeResolver.STREAMING_AGGREGATION_MIN_SEGMENT_SIZE_SETTING,
                IndexSettings.INDEX_FLUSH_AFTER_MERGE_THRESHOLD_SIZE_SETTING,
                IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING,  
                IndexMetadata.INDEX_REPLICATION_TYPE_SETTING,
                IndexSettings.INDEX_MERGE_ON_FLUSH_ENABLED,
    /**
                IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING,
            )
        new HashSet<>(  
                IndexMetadata.INGESTION_SOURCE_POINTER_BASED_LAG_UPDATE_INTERVAL_SETTING,
                MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING,
import org.opensearch.index.mapper.FieldMapper;
}  
                IndexMetadata.INDEX_BLOCKS_READ_SETTING,
                IndexMetadata.INGESTION_SOURCE_WARMUP_TIMEOUT_SETTING,  
                IndexMetadata.INDEX_AUTO_EXPAND_SEARCH_REPLICAS_SETTING,  
                IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING,
                IndexSettings.INDEX_CHECK_PENDING_FLUSH_ENABLED,
                TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED,
                }, Property.IndexScope), // this allows similarity settings to be passed
                IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING,
                EngineConfig.INDEX_CODEC_COMPRESSION_LEVEL_SETTING,
                StarTreeIndexSettings.STAR_TREE_MAX_DATE_INTERVALS_SETTING,  
            case "index.shrink.source.uuid":  
import org.opensearch.index.mapper.MapperService;
                IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING,  
                // Settings for ingestion source
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING,
    }
                IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING,
import org.opensearch.index.IndexSettings;
                TieredMergePolicyProvider.INDEX_MERGE_POLICY_RECLAIM_DELETES_WEIGHT_SETTING,  
                IndexMetadata.INGESTION_SOURCE_INTERNAL_QUEUE_SIZE_SETTING,
                IndexMetadata.INDEX_BLOCKS_METADATA_SETTING,  
                IndexSettings.INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING,
import java.util.function.Predicate;
                IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING,
                IndexSettings.MAX_SLICES_PER_PIT,  
                IndexSettings.MAX_DOCVALUE_FIELDS_SEARCH_SETTING,
                IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING,  
                IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING,
        }
    public static final Predicate<String> ARCHIVED_SETTINGS_KEY_PREDICATE = (s) -> s.startsWith(ARCHIVED_SETTINGS_PREFIX);  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
                IndexSettings.MAX_REFRESH_LISTENERS_PER_SHARD,
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING,  
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING,  
                IndexMetadata.INGESTION_SOURCE_DECODER_TYPE_SETTING,
    private IndexScopedSettings(Settings settings, IndexScopedSettings other, IndexMetadata metadata) {  
                ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_SETTING,  
                StarTreeIndexSettings.DEFAULT_DATE_INTERVALS,
        return new IndexScopedSettings(settings, this, metadata);
        if (setting.getKey().startsWith("index.") == false) {
                IndexMetadata.INGESTION_SOURCE_DECODER_SETTINGS,
                IndexMetadata.INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING,  
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING,  
                IndexMetadata.INDEX_DATA_PATH_SETTING,
                IndexMetadata.INGESTION_SOURCE_POLL_TIMEOUT,  
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING,  
                IndexMetadata.INDEX_BLOCKS_WRITE_SETTING,
                IndexMetadata.INDEX_FORMAT_SETTING,
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING,
                LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGED_DOCS_SETTING,
    public IndexScopedSettings copy(Settings settings, IndexMetadata metadata) {
 * GitHub history for details.
                ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING,  
                IndexSortConfig.INDEX_SORT_MISSING_SETTING,  
                MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING,
                IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING,
                // Setting for derived source feature  
                IndexModule.INDEX_RECOVERY_TYPE_SETTING,  
                    }  
                IndexSettings.INDEX_MERGE_ON_FLUSH_POLICY,  
                IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING,  
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING,
                MergeSchedulerConfig.AUTO_THROTTLE_SETTING,  
                IndexSortConfig.INDEX_SORT_ORDER_SETTING,
                IndexSettings.INDEX_CONTEXT_AWARE_ENABLED_SETTING,  
                LogByteSizeMergePolicyProvider.INDEX_LBS_MERGE_POLICY_MERGE_FACTOR_SETTING,  
                MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING,  
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING,  
 */  
import org.opensearch.index.LogByteSizeMergePolicyProvider;
                IndexMetadata.INGESTION_SOURCE_MAX_POLL_SIZE,
                Setting.groupSetting("index.similarity.", (s) -> {
                IndexSettings.MAX_REGEX_LENGTH_SETTING,
                MapperService.INDEX_MAPPING_NESTED_FIELDS_LIMIT_SETTING,  
/*  
                IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING,
                ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING,  
                TieredMergePolicyProvider.INDEX_COMPOUND_FORMAT_SETTING,
 */  
    }
/*
    public static final Set<Setting<?>> BUILT_IN_INDEX_SETTINGS = Collections.unmodifiableSet(
                FieldMapper.COERCE_SETTING,  
    public IndexScopedSettings(Settings settings, Set<Setting<?>> settingsSet) {
                IndexMetadata.INDEX_UUID_SETTING,  
                IndexSettings.INDEX_MERGE_ON_FLUSH_MAX_FULL_FLUSH_MERGE_WAIT_TIME,
                // Settings for search replica  
            case MergePolicyProvider.INDEX_MERGE_ENABLED:  
                    Map<String, Settings> groups = s.getAsGroups();
                IndexSettings.INDEX_TRANSLOG_BATCH_APPEND_ENABLED_SETTING,
                IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_DEBUG_SETTING,
                IndexSettings.INDEX_SEARCH_IDLE_AFTER,
                IndexSettings.INDEX_DOC_ID_FUZZY_SET_FALSE_POSITIVE_PROBABILITY_SETTING,
import org.opensearch.index.store.FsDirectoryFactory;
                IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING,
                IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING,
                IndexMetadata.INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING,
                IndexSettings.MAX_ADJACENCY_MATRIX_FILTERS_SETTING,  
                IndexSettings.SEARCHABLE_SNAPSHOT_ID_NAME,
                // Writable warm / tiering settings - always registered so nodes can parse  
                StarTreeIndexSettings.STAR_TREE_MAX_DIMENSIONS_SETTING,
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING,
 * Unless required by applicable law or agreed to in writing,
                TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING,
                IndexSettings.INDEX_TRANSLOG_BATCH_APPEND_MAX_OPERATIONS_SETTING,  
                IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING,
                IndexMetadata.SETTING_INDEX_HISTORY_UUID,
            throw new IllegalArgumentException("illegal settings key: [" + setting.getKey() + "] must start with [index.]");
                        }
                LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGE_SEGMENT_SETTING,
                IndexSettings.INDEX_SEARCH_THROTTLED,
                IndexSettings.MAX_RESCORE_WINDOW_SETTING,
                IndexModule.INDEX_STORE_HYBRID_NIO_EXTENSIONS,
                TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGED_SEGMENT_SETTING,
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL,  
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING,
                // Settings for star tree index  
                FsDirectoryFactory.INDEX_LOCK_FACTOR_SETTING,
package org.opensearch.common.settings;
        super(settings, metadata.getSettings(), other, Loggers.getLogger(IndexScopedSettings.class, metadata.getIndex()));
                IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING,  
                MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING,
                IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING,  
            case "index.shrink.source.name":
                IndexModule.IS_WARM_INDEX_SETTING,
import org.opensearch.indices.IndicesBitsetFilterCache;  
                IndexMetadata.INDEX_REMOTE_STORE_AUTO_RESTORE_ENABLED_SETTING,
 * the Apache License, Version 2.0 (the "License"); you may
                IndexSettings.INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING,  
                IndexSettings.MAX_SCRIPT_FIELDS_SETTING,
                IndexFieldDataService.INDEX_FIELDDATA_CACHE_KEY,
                EngineConfig.INDEX_CODEC_SETTING,
                IndexModule.INDEX_STORE_TYPE_SETTING,
                // we keep the shrink settings for BWC - this can be removed in 8.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                IndexMetadata.INGESTION_SOURCE_POINTER_INIT_RESET_SETTING,
                IndexMetadata.SETTING_INDEX_CREATION_DATE,
 * this file be licensed under the Apache-2.0 license or a
                IndexSettings.INDEX_DOC_ID_FUZZY_SET_ENABLED_SETTING,  
                // Settings for remote store enablement
 *
                IndexSettings.INDEX_MERGE_POLICY,
import org.opensearch.common.logging.Loggers;
                IndexSettings.FINAL_PIPELINE,
import org.opensearch.common.annotation.PublicApi;
                IndexSettings.INDEX_TRANSLOG_READ_FORWARD_SETTING,  
                IndexMetadata.INGESTION_SOURCE_MAPPER_SETTINGS,  
import java.util.Map;  
                IndexSettings.INDEX_WARMER_ENABLED_SETTING,
                IndexSettings.INDEX_DERIVED_SOURCE_SETTING,
                IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING,  
                // Settings for Searchable Snapshots
    public static final IndexScopedSettings DEFAULT_SCOPED_SETTINGS = new IndexScopedSettings(Settings.EMPTY, BUILT_IN_INDEX_SETTINGS);  
import org.opensearch.index.fielddata.IndexFieldDataService;  
                IndexSettings.INDEX_MAX_RETRY_ON_LOOKUP_MAP_LOCK_ACQUISITION_EXCEPTION,
    );  
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
                LogByteSizeMergePolicyProvider.INDEX_LBS_MERGE_POLICY_MIN_MERGE_SETTING,
                IndexSettings.INDEX_TRANSLOG_GENERATION_THRESHOLD_SIZE_SETTING,
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL,
 * compatible open source license.
                IndexMetadata.INGESTION_SOURCE_PARAMS_SETTING,  
 *
                IndexingSlowLog.INDEX_INDEXING_SLOWLOG_MAX_SOURCE_CHARS_TO_LOG_SETTING,
    }
 * software distributed under the License is distributed on an
import org.opensearch.storage.slowlogs.TieredStorageSearchSlowLog;  
                StarTreeIndexSettings.STAR_TREE_MAX_FIELDS_SETTING,  
                StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING,
                IndexSettings.QUERY_STRING_LENIENT_SETTING,
                IndexSortConfig.INDEX_SORT_MODE_SETTING,
                IndexSettings.INDEX_TRANSLOG_BATCH_APPEND_MAX_SIZE_SETTING,
                EnableAllocationDecider.INDEX_ROUTING_ALLOCATION_ENABLE_SETTING,
import org.opensearch.index.similarity.SimilarityService;  
                MaxRetryAllocationDecider.SETTING_ALLOCATION_MAX_RETRY,
                IndexMetadata.INGESTION_SOURCE_WARMUP_LAG_THRESHOLD_SETTING,
/*
                LogByteSizeMergePolicyProvider.INDEX_LBS_NO_CFS_RATIO_SETTING,
 * specific language governing permissions and limitations
     * is ready for production release, the feature flag can be removed, and the
                IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_INFO_SETTING,  
 * @opensearch.api
import org.opensearch.index.IndexModule;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.engine.EngineConfig;
import org.opensearch.index.SearchSlowLog;
                return IndexMetadata.INDEX_ROUTING_INITIAL_RECOVERY_GROUP_SETTING.getRawKey().match(key);  
                // index metadata even when the feature flag is disabled
                IndexSettings.INDEX_GC_DELETES_SETTING,
                IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MODE,
                // Settings for Auto Force Merge  
                    for (String key : SimilarityService.BUILT_IN.keySet()) {  
                IndexingSlowLog.INDEX_INDEXING_SLOWLOG_REFORMAT_SETTING,  
    }  
public final class IndexScopedSettings extends AbstractScopedSettings {
                EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING,  
                IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING,
            default:
                        if (groups.containsKey(key)) {
                IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_SETTING, // deprecated
 * Encapsulates all valid index level settings.
                IndexMetadata.INGESTION_SOURCE_POINTER_INIT_RESET_VALUE_SETTING,
                IndexModule.INDEX_STORE_FACTORY_SETTING,  
                IndexSettings.DEFAULT_PIPELINE,  
import java.util.HashSet;
                MapperService.INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING,
                TieredMergePolicyProvider.INDEX_MERGE_POLICY_FLOOR_SEGMENT_SETTING,
 */
                IndexSettings.INDEX_PUBLISH_REFERENCED_SEGMENTS_INTERVAL_SETTING,
    public static final Map<String, List<Setting>> FEATURE_FLAGGED_INDEX_SETTINGS = Map.of();
                IndexSettings.ALLOW_UNMAPPED,
            Arrays.asList(
                return true;
                IndexSettings.DEFAULT_FIELD_SETTING,  
 */
    }
                // we can't remove in 7 since this setting might be baked into an index coming in via a full cluster restart from 6.0
     */  
                ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING,
                IndexSettings.MAX_SHINGLE_DIFF_SETTING,
                FieldMapper.IGNORE_MALFORMED_SETTING,
                Setting.groupSetting("index.analysis.", Property.IndexScope) // this allows analysis settings to be passed
@PublicApi(since = "1.0.0")
                // Tiered storage search slow log settings  
                IndexSettings.INDEX_AUTO_FORCE_MERGES_ENABLED,
                MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING,
                IndexMetadata.SETTING_WAIT_FOR_ACTIVE_SHARDS,
                IndexSettings.MAX_RESULT_WINDOW_SETTING,
    public static final Predicate<String> INDEX_SETTINGS_KEY_PREDICATE = (s) -> s.startsWith(IndexMetadata.INDEX_SETTING_PREFIX);
import java.util.List;
                IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING,  
                IndexSettings.INDEX_CONTEXT_CURRENT_VERSION,  
                IndexMetadata.INDEX_NUMBER_OF_VIRTUAL_SHARDS_SETTING,
        super(settings, settingsSet, Collections.emptySet(), Property.IndexScope);  
                IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING,
                Store.FORCE_RAM_TERM_DICT,  
                // we keep this setting for BWC to support indexes created in 1.1.0
                IndexSortConfig.INDEX_SORT_FIELD_SETTING,
                MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING,
                IndexSettings.SEARCHABLE_SNAPSHOT_SHARD_PATH_TYPE,
import org.opensearch.index.MergePolicyProvider;  
