import org.opensearch.index.IndexModule;
/**
                // Setting for derived source feature
                MergeSchedulerConfig.MAX_FORCE_MERGE_MB_PER_SEC_SETTING,
                IndexMetadata.INGESTION_SOURCE_POINTER_INIT_RESET_SETTING,
        switch (key) {
                MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING,
 * Licensed to Elasticsearch under one or more contributor
                IndexMetadata.INDEX_REMOTE_STORE_AUTO_RESTORE_ENABLED_SETTING,
                IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING,
 * ownership. Elasticsearch licenses this file to you under
                IndexSettings.INDEX_SEARCH_IDLE_AFTER,
                StarTreeIndexSettings.STAR_TREE_MAX_FIELDS_SETTING,
     */
            case IndexMetadata.INDEX_RESIZE_SOURCE_NAME_KEY:
                LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGED_DOCS_SETTING,
                IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING,
                IndexModule.INDEX_RECOVERY_TYPE_SETTING,
                IndexSortConfig.INDEX_SORT_ORDER_SETTING,
                EngineConfig.INDEX_OPTIMIZE_AUTO_GENERATED_IDS,
import org.opensearch.common.settings.Setting.Property;
                TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING,
                // Settings for Auto Force Merge
                // we can't remove in 7 since this setting might be baked into an index coming in via a full cluster restart from 6.0
                TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGED_SEGMENT_SETTING,
                IndexSettings.SEARCHABLE_SNAPSHOT_SHARD_PATH_TYPE,
import java.util.HashSet;
                IndexMetadata.INDEX_NUMBER_OF_SEARCH_REPLICAS_SETTING,
            default:
                IndexSettings.SEARCHABLE_SNAPSHOT_REPOSITORY,
import org.opensearch.index.similarity.SimilarityService;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
    public static final Map<String, List<Setting>> FEATURE_FLAGGED_INDEX_SETTINGS = Map.of();
                EngineConfig.INDEX_CODEC_SETTING,
                IndexMetadata.INGESTION_SOURCE_MAPPER_TYPE_SETTING,
import org.opensearch.index.IndexSettings;
 * SPDX-License-Identifier: Apache-2.0
                IndexMetadata.INDEX_NUMBER_OF_ROUTING_SHARDS_SETTING,
                IndexSettings.INDEX_DERIVED_SOURCE_SETTING,
                EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING,
                IndexMetadata.INDEX_BLOCKS_READ_ONLY_ALLOW_DELETE_SETTING,
        super.validateSettingKey(setting);
 * under the License.
                IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING,
                IndexMetadata.INDEX_DATA_PATH_SETTING,
        }
                IndexSettings.INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING,
                MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING,
                IndexSettings.MAX_SCRIPT_FIELDS_SETTING,
                MapperService.INDEX_MAPPING_NESTED_FIELDS_LIMIT_SETTING,
                // validate that built-in similarities don't get redefined
                IndexMetadata.INGESTION_SOURCE_MAX_POLL_SIZE,
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING,
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;
                StarTreeIndexSettings.DEFAULT_DATE_INTERVALS,
                IndexMetadata.INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING,
                EngineConfig.INDEX_CODEC_COMPRESSION_LEVEL_SETTING,
                IndexMetadata.INDEX_NUMBER_OF_VIRTUAL_SHARDS_SETTING,
                StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING,
                IndexSettings.MAX_DOCVALUE_FIELDS_SEARCH_SETTING,
                IndexSettings.INDEX_MAX_RETRY_ON_LOOKUP_MAP_LOCK_ACQUISITION_EXCEPTION,
                IndexMetadata.INDEX_UUID_SETTING,
                FieldMapper.IGNORE_MALFORMED_SETTING,
                IndexSettings.INDEX_MERGE_POLICY,
                IndexSettings.INDEX_DOC_ID_FUZZY_SET_FALSE_POSITIVE_PROBABILITY_SETTING,
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING,
                IndexSettings.INDEX_GC_DELETES_SETTING,
                IndexSettings.MAX_REFRESH_LISTENERS_PER_SHARD,
                IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING,
 */
                IndexSettings.INDEX_TRANSLOG_BATCH_APPEND_ENABLED_SETTING,
                IndexMetadata.INGESTION_SOURCE_POINTER_BASED_LAG_UPDATE_INTERVAL_SETTING,
                IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_WARN_SETTING,
                IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING,
                IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING,
                IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING,
                IndexSettings.DEFAULT_PIPELINE,
                IndexSettings.INDEX_MERGE_ON_FLUSH_ENABLED,
 * compatible open source license.
                IndexMetadata.SETTING_INDEX_CREATION_DATE,
 *
                LogByteSizeMergePolicyProvider.INDEX_LBS_MERGE_POLICY_MIN_MERGE_SETTING,
/*
import org.opensearch.index.mapper.MapperService;
                IndexModule.INDEX_STORE_FACTORY_SETTING,
        if (setting.getKey().startsWith("index.") == false) {
                MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING,
import org.opensearch.index.mapper.FieldMapper;
                }, Property.IndexScope), // this allows similarity settings to be passed
                // Settings for concurrent segment search
                IndexMetadata.SETTING_INDEX_VERSION_CREATED,
                Setting.groupSetting("index.similarity.", (s) -> {
                IndexSettings.ALLOW_DERIVED_FIELDS,
                IndexSettings.INDEX_CHECK_PENDING_FLUSH_ENABLED,
                MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING,
                IndexMetadata.SETTING_WAIT_FOR_ACTIVE_SHARDS,
                ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_PRIMARY_SHARDS_PER_NODE_SETTING,
     * Map of feature flag name to feature-flagged index setting. Once each feature
                IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING,
                    Map<String, Settings> groups = s.getAsGroups();
                IndexSettings.INDEX_PERIODIC_FLUSH_INTERVAL_SETTING,
                LogByteSizeMergePolicyProvider.INDEX_LBS_NO_CFS_RATIO_SETTING,
}
 * not use this file except in compliance with the License.
                IndexSettings.INDEX_MERGE_ON_FLUSH_MAX_FULL_FLUSH_MERGE_WAIT_TIME,
                Store.INDEX_STORE_STATS_REFRESH_INTERVAL_SETTING,
                return true;
import org.opensearch.index.TieredMergePolicyProvider;
                LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGE_SEGMENT_FOR_FORCED_MERGE_SETTING,
    }
    protected void validateSettingKey(Setting setting) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                IndexMetadata.INGESTION_SOURCE_ALL_ACTIVE_INGESTION_SETTING,
                IndexMetadata.INDEX_ROUTING_PARTITION_SIZE_SETTING,
                Setting.groupSetting("index.analysis.", Property.IndexScope) // this allows analysis settings to be passed
 */
import org.opensearch.index.store.Store;
                IndexSettings.MAX_SLICES_PER_SCROLL,
                FlushModeResolver.STREAMING_AGGREGATION_MIN_SEGMENT_SIZE_SETTING,
                IndexSettings.INDEX_PUBLISH_REFERENCED_SEGMENTS_INTERVAL_SETTING,
                IndexModule.IS_WARM_INDEX_SETTING,
import java.util.List;
    private IndexScopedSettings(Settings settings, IndexScopedSettings other, IndexMetadata metadata) {
                IndexSettings.INDEX_CONTEXT_CREATED_VERSION,
     * is ready for production release, the feature flag can be removed, and the
        super(settings, metadata.getSettings(), other, Loggers.getLogger(IndexScopedSettings.class, metadata.getIndex()));
                IndexMetadata.INGESTION_SOURCE_INTERNAL_QUEUE_SIZE_SETTING,
                IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING,
                IndexMetadata.INDEX_AUTO_EXPAND_SEARCH_REPLICAS_SETTING,
                IndexSettings.MAX_TERMS_COUNT_SETTING,
                IndexSettings.INDEX_SEARCH_THROTTLED,
                IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING,
import org.opensearch.cluster.routing.UnassignedInfo;
                                "illegal value for [index.similarity." + key + "] cannot redefine built-in similarity"
    public boolean isPrivateSetting(String key) {
                IndexModule.INDEX_TIERING_STATE,
import org.opensearch.index.MergeSchedulerConfig;
                IndexFieldDataService.INDEX_FIELDDATA_CACHE_KEY,
                FsDirectoryFactory.INDEX_LOCK_FACTOR_SETTING,
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.indices.IndicesBitsetFilterCache;
import java.util.function.Predicate;
                IndexSettings.INDEX_UNREFERENCED_FILE_CLEANUP,
                IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING,
                IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING,
                StarTreeIndexSettings.STAR_TREE_MAX_DATE_INTERVALS_SETTING,
        )
                IndexSettings.SEARCHABLE_SNAPSHOT_ID_UUID,
                MapperService.INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING,
                IndexSettings.MAX_RESCORE_WINDOW_SETTING,
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL,
import org.opensearch.indices.IndicesRequestCache;
    public static final Predicate<String> INDEX_SETTINGS_KEY_PREDICATE = (s) -> s.startsWith(IndexMetadata.INDEX_SETTING_PREFIX);
    /**
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING,
                IndexSortConfig.INDEX_SORT_MISSING_SETTING,
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING,
public final class IndexScopedSettings extends AbstractScopedSettings {
                IndexSettings.MAX_NESTED_QUERY_DEPTH_SETTING,
import java.util.Arrays;
                // Tiered storage search slow log settings
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING,
                        }
                IndexSettings.MAX_TOKEN_COUNT_SETTING,
                TieredMergePolicyProvider.INDEX_COMPOUND_FORMAT_SETTING,
                IndexSettings.SEARCHABLE_SNAPSHOT_ID_NAME,
                TieredMergePolicyProvider.INDEX_MERGE_POLICY_RECLAIM_DELETES_WEIGHT_SETTING,
                IndexSettings.MAX_INNER_RESULT_WINDOW_SETTING,
                StarTreeIndexSettings.STAR_TREE_DEFAULT_MAX_LEAF_DOCS,
                IndexSettings.INDEX_AUTO_FORCE_MERGES_ENABLED,
                IndexMetadata.INDEX_BLOCKS_READ_SETTING,
                IndicesBitsetFilterCache.INDEX_LOAD_RANDOM_ACCESS_FILTERS_EAGERLY_SETTING,
                EnableAllocationDecider.INDEX_ROUTING_ALLOCATION_ENABLE_SETTING,
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
                ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_SETTING,
            case "index.shrink.source.name":
 * this file be licensed under the Apache-2.0 license or a
                IndexSettings.INDEX_CONTEXT_AWARE_ENABLED_SETTING,
 *
                MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING,
                IndexMetadata.INDEX_BLOCKS_METADATA_SETTING,
import org.opensearch.index.LogByteSizeMergePolicyProvider;
    public IndexScopedSettings copy(Settings settings, IndexMetadata metadata) {
                IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_DEBUG_SETTING,
                IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING,
    }
    );
                IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING,
                return IndexMetadata.INDEX_ROUTING_INITIAL_RECOVERY_GROUP_SETTING.getRawKey().match(key);
                IndexMetadata.INGESTION_SOURCE_PARAMS_SETTING,
                            );
                StarTreeIndexSettings.STAR_TREE_MAX_BASE_METRICS_SETTING,
                // index metadata even when the feature flag is disabled
                IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_SETTING, // deprecated
import org.opensearch.common.logging.Loggers;
        super(settings, settingsSet, Collections.emptySet(), Property.IndexScope);
package org.opensearch.common.settings;
                IndexMetadata.SETTING_INDEX_HISTORY_UUID,
                IndexingSlowLog.INDEX_INDEXING_SLOWLOG_REFORMAT_SETTING,
                // Settings for ingestion source
 * specific language governing permissions and limitations
     * setting should be moved to {@link #BUILT_IN_INDEX_SETTINGS}.
                IndexSortConfig.INDEX_SORT_MODE_SETTING,
                // Settings for search replica
import org.opensearch.index.MergePolicyProvider;
                IndexSettings.INDEX_SOFT_DELETES_SETTING,
            Arrays.asList(
                LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGE_SEGMENT_SETTING,
                MapperService.INDEX_MAPPER_DYNAMIC_SETTING,
                    for (String key : SimilarityService.BUILT_IN.keySet()) {
                IndexSettings.INDEX_CONTEXT_CURRENT_VERSION,
                IndexSettings.DEFAULT_FIELD_SETTING,
 * Modifications Copyright OpenSearch Contributors. See
                IndexSettings.MAX_NGRAM_DIFF_SETTING,
                // we keep the shrink settings for BWC - this can be removed in 8.0
                MaxRetryAllocationDecider.SETTING_ALLOCATION_MAX_RETRY,
                MergeSchedulerConfig.AUTO_THROTTLE_SETTING,
                        if (groups.containsKey(key)) {
import org.opensearch.cluster.metadata.IndexMetadata;
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_WARN_SETTING,
            case "index.plugins.replication.translog.retention_lease.pruning.enabled":
                IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING,
 * @see Property#IndexScope
/*
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
                IndexSettings.INDEX_REFRESH_INTERVAL_SETTING,
                MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING,
import org.opensearch.cluster.metadata.MetadataIndexStateService;
                IndexMetadata.INDEX_HIDDEN_SETTING,
                IndexSettings.SEARCHABLE_SNAPSHOT_INDEX_ID,
                IndexSettings.MAX_SHINGLE_DIFF_SETTING,
                IndexMetadata.INDEX_AUTO_EXPAND_REPLICAS_SETTING,
import org.opensearch.index.IndexSortConfig;
    }
                TieredStorageSearchSlowLog.TIERED_STORAGE_SEARCH_SLOWLOG_ENABLED,
                IndexMetadata.INGESTION_SOURCE_NUM_PROCESSOR_THREADS_SETTING,
            case "index.shrink.source.uuid":
                IndexMetadata.INGESTION_SOURCE_DECODER_TYPE_SETTING,
 * The OpenSearch Contributors require contributions made to
                IndexSettings.MAX_ADJACENCY_MATRIX_FILTERS_SETTING,
                IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING,
                IndexSettings.MAX_REGEX_LENGTH_SETTING,
import org.opensearch.index.IndexingSlowLog;
 *
                // Settings for Searchable Snapshots
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING,
                IndexMetadata.INGESTION_SOURCE_POINTER_INIT_RESET_VALUE_SETTING,
                LogByteSizeMergePolicyProvider.INDEX_LBS_MERGE_POLICY_MERGE_FACTOR_SETTING,
import java.util.Map;
 * this work for additional information regarding copyright
                // Settings for star tree index
                IndexModule.INDEX_STORE_TYPE_SETTING,
                // Settings for remote translog
 * GitHub history for details.
                TieredMergePolicyProvider.INDEX_MERGE_POLICY_DELETES_PCT_ALLOWED_SETTING,
 * Encapsulates all valid index level settings.
                IndexModule.INDEX_STORE_LOCALITY_SETTING,
                IndexSettings.INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING,
                UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING,
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_TRACE_SETTING,
                TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING,
                IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT,
                IndexSettings.MAX_RESULT_WINDOW_SETTING,
                ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING,
                MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING,
                IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_TRACE_SETTING,
                EngineConfig.INDEX_USE_COMPOUND_FILE,
                // Writable warm / tiering settings - always registered so nodes can parse
                IndexSettings.INDEX_FLUSH_AFTER_MERGE_THRESHOLD_SIZE_SETTING,
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_DEBUG_SETTING,
 *
                IndexMetadata.INDEX_REPLICATION_TYPE_SETTING,
            throw new IllegalArgumentException("illegal settings key: [" + setting.getKey() + "] must start with [index.]");
    public IndexScopedSettings(Settings settings, Set<Setting<?>> settingsSet) {
                FieldMapper.COERCE_SETTING,
 */
    }
 * You may obtain a copy of the License at
                IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING,
        }
                IndexMetadata.INGESTION_SOURCE_DECODER_SETTINGS,
 * @opensearch.api
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL,
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING,
                TieredMergePolicyProvider.INDEX_MERGE_POLICY_FLOOR_SEGMENT_SETTING,
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING,
                    }
                IndexSettings.INDEX_TRANSLOG_GENERATION_THRESHOLD_SIZE_SETTING,
                IndexMetadata.INDEX_READ_ONLY_SETTING,
                IndexMetadata.INGESTION_SOURCE_ERROR_STRATEGY_SETTING,
                IndexSettings.MAX_SLICES_PER_PIT,
                StarTreeIndexSettings.DEFAULT_METRICS_LIST,
                IndexSettings.INDEX_WARMER_ENABLED_SETTING,
                // this can be removed in OpenSearch 3.0
                IndexingSlowLog.INDEX_INDEXING_SLOWLOG_LEVEL_SETTING,
                IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING,
    public static final Set<Setting<?>> BUILT_IN_INDEX_SETTINGS = Collections.unmodifiableSet(
                IndexSettings.INDEX_TRANSLOG_READ_FORWARD_SETTING,
import org.opensearch.index.engine.EngineConfig;
                IndexingSlowLog.INDEX_INDEXING_SLOWLOG_MAX_SOURCE_CHARS_TO_LOG_SETTING,
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING,
                IndexMetadata.INGESTION_SOURCE_POLL_TIMEOUT,
                IndexSettings.DEFAULT_SEARCH_PIPELINE,
                            throw new IllegalArgumentException(
import java.util.Collections;
                IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING,
                IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING,
                IndexSettings.INDEX_TRANSLOG_BATCH_APPEND_MAX_OPERATIONS_SETTING,
import org.opensearch.index.SearchSlowLog;
            case IndexMetadata.SETTING_INDEX_PROVIDED_NAME:
                IndexMetadata.INGESTION_SOURCE_MAPPER_SETTINGS,
        new HashSet<>(
/*
                IndexSettings.MAX_ANALYZED_OFFSET_SETTING,
@PublicApi(since = "1.0.0")
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING,
                IndexSettings.ALLOW_UNMAPPED,
    @Override
                IndexSettings.INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING,
                StarTreeIndexSettings.STAR_TREE_SEARCH_ENABLED_SETTING,
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
                TieredStorageSearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING,
 */
                IndexSortConfig.INDEX_SORT_FIELD_SETTING,
import org.opensearch.index.fielddata.IndexFieldDataService;
                IndexSettings.INDEX_DOC_ID_FUZZY_SET_ENABLED_SETTING,
                IndexMetadata.INDEX_BLOCKS_WRITE_SETTING,
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_FETCH_INFO_SETTING,
                IndexMetadata.INDEX_FORMAT_SETTING,
                TieredMergePolicyProvider.INDEX_MERGE_POLICY_EXPUNGE_DELETES_ALLOWED_SETTING,
                IndexModule.INDEX_STORE_PRE_LOAD_SETTING,
                IndexMetadata.INGESTION_SOURCE_TYPE_SETTING,
            case IndexMetadata.INDEX_RESIZE_SOURCE_UUID_KEY:
 * software distributed under the License is distributed on an
                IndexMetadata.INDEX_BULK_ADAPTIVE_SHARD_SELECTION_ENABLED,
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
                IndexSettings.INDEX_CONCURRENT_SEGMENT_SEARCH_MODE,
                IndexSettings.INDEX_MERGE_ON_FLUSH_POLICY,
                IndexSettings.INDEX_CHECK_ON_STARTUP,
import org.opensearch.common.annotation.PublicApi;
                IndexSettings.INDEX_TRANSLOG_BATCH_APPEND_MAX_SIZE_SETTING,
    public static final IndexScopedSettings DEFAULT_SCOPED_SETTINGS = new IndexScopedSettings(Settings.EMPTY, BUILT_IN_INDEX_SETTINGS);
            )
                SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING,
                IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING,
        return new IndexScopedSettings(settings, this, metadata);
                StarTreeIndexSettings.STAR_TREE_MAX_DIMENSIONS_SETTING,
                ShardsLimitAllocationDecider.INDEX_TOTAL_REMOTE_CAPABLE_SHARDS_PER_NODE_SETTING,
                IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING,
import java.util.Set;
import org.opensearch.index.store.FsDirectoryFactory;
                IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING,
import org.opensearch.storage.slowlogs.TieredStorageSearchSlowLog;
            case MergePolicyProvider.INDEX_MERGE_ENABLED:
                IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_INFO_SETTING,
                // we keep this setting for BWC to support indexes created in 1.1.0
    public static final Predicate<String> ARCHIVED_SETTINGS_KEY_PREDICATE = (s) -> s.startsWith(ARCHIVED_SETTINGS_PREFIX);
    @Override
                IndexMetadata.INDEX_PRIORITY_SETTING,
                IndexSettings.FINAL_PIPELINE,
                ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING,
                // Settings for remote store enablement
                IndexSettings.QUERY_STRING_LENIENT_SETTING,
            case IndexMetadata.SETTING_VERSION_UPGRADED:
    }
 * license agreements. See the NOTICE file distributed with
                IndexMetadata.INGESTION_SOURCE_WARMUP_TIMEOUT_SETTING,
import org.opensearch.search.streaming.FlushModeResolver;
                IndexModule.INDEX_STORE_HYBRID_NIO_EXTENSIONS,
                IndexMetadata.INGESTION_SOURCE_WARMUP_LAG_THRESHOLD_SETTING,
                Store.FORCE_RAM_TERM_DICT,
