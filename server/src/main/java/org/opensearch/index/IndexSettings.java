     * Returns if object-store-backed primary fencing is enabled for this index.
        Property.IndexScope
            return DEFAULT_PERIODIC_FLUSH_INTERVAL;
                    break;
    /**
        Property.IndexScope
        "index.merge_on_flush.policy",
        Property.IndexScope,
        scopedSettings.addSettingsUpdateConsumer(
     * @see IndexMetadata#indexCreated(Settings)
        return flushOnUncommittedSegmentsThresholdSize;
        },
 */
        scopedSettings.addSettingsUpdateConsumer(INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING, this::setSoftDeleteRetentionOperations);
        "index.optimize_doc_id_lookup.fuzzy_set.false_positive_probability",
    }
import java.util.concurrent.TimeUnit;
    private volatile IndexMetadata indexMetadata;
            IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING,
                case CONCURRENT_SEGMENT_SEARCH_MODE_ALL:
        return INDEX_REFRESH_INTERVAL_SETTING.exists(settings);
    }
                break;
    private volatile long mappingDepthLimit;
        setTranslogRetentionSize(scopedSettings.get(INDEX_TRANSLOG_RETENTION_SIZE_SETTING));
     */
            INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING,
        1,
     */
    }
        Property.PrivateIndex,
    /**
        this.mappingDepthLimit = value;
    /**
    private void setMaxTermsCount(int maxTermsCount) {
        Property.IndexScope,
     * Expert: Makes indexing threads check for pending flushes on update in order to help out
    /**
     * @param nodeSettings  the nodes settings this index is allocated on.
        2,
            MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING,
        /*
    private void setRefreshInterval(TimeValue timeValue) {
        scopedSettings.addSettingsUpdateConsumer(MAX_RESULT_WINDOW_SETTING, this::setMaxResultWindow);
    /**
    /**
        "index.search.idle.after",
        return ReplicationType.SEGMENT.equals(replicationType) || isAssignedOnRemoteNode();
    }
        scopedSettings.addSettingsUpdateConsumer(INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING, this::setMappingTotalFieldsLimit);
            this.translogRetentionAge = age;
        Property.IndexScope
     */
import org.opensearch.common.settings.IndexScopedSettings;
    );
     */
        return syncInterval;
     */
     * This setting controls if unreferenced files will be cleaned up in case segment merge fails due to disk full.
        return streamingAggregationMinSegmentSize;
        100,
     */
        Property.IndexScope
    public static final Setting<Boolean> INDEX_CONTEXT_AWARE_ENABLED_SETTING = Setting.boolSetting(
    public static final Setting<ByteSizeValue> INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING = Setting
    }
        Translog.Durability.REQUEST.name(),
    /**
                            mergePolicyProvider = defaultMergePolicyProvider();
        0,
        String rawPrefix = IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(settings);
    /**
     * This setting is intentionally not registered, it is only used in tests
        return mappingDepthLimit;
    }
        return getIndex().getUUID();
    }
        this.settings = newIndexSettings;
            this::setRemoteStoreRepository
    private final boolean isTranslogMetadataEnabled;
     * Determines a balance between file-based and operations-based peer recoveries. The number of operations that will be used in an
    public IndexSettings(final IndexMetadata indexMetadata, final Settings nodeSettings, IndexScopedSettings indexScopedSettings) {
        0.0d,
    private final boolean isRemoteStoreFencingEnabled;
     *
    private void setMaxRefreshListeners(int maxRefreshListeners) {
        "index.searchable_snapshot.shard_path_type",
     * This setting is realtime updateable
        final Settings newSettings = indexMetadata.getSettings();
    /**
import java.util.Arrays;
    );
     * and no in-sync copies are available, we force-allocate this recovering replica as primary.
        Property.IndexScope
     *
import java.util.function.Function;
    public void setStarTreeIndexEnabled(boolean value) {
     * Denotes whether search via star tree index is enabled for this index
        } else {
        (settings) -> {
        mappingDynamicPropertiesLuceneFieldLimit = scopedSettings.get(INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING);
        );
                    mergePolicyProvider = defaultMergePolicyProvider();
    public IndexSettings(final IndexMetadata indexMetadata, final Settings nodeSettings) {
     * The maximum number of refresh listeners allows on this shard.
     * <p>
    public int getMaxShingleDiff() {
                    + text
     * 2. sets the maxMergesAtOnce on the actual TieredMergePolicy used by the engine if no index level override exists
        "index.auto_force_merge.enabled",
    }
     */
        return defaultAllowUnmappedFields;
                    + IndexSettings.INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING.getKey()
        MergePolicyProvider mergePolicyProvider = null;
    }
    }
        (value) -> Translog.Durability.valueOf(value.toUpperCase(Locale.ROOT)),
        }
    /**
                    "unknown value for [index.shard.check_on_startup] must be one of " + "[true, false, checksum] but was: " + s
        Property.IndexScope
    }
    private volatile boolean derivedSourceEnabledForTranslog;
        this.maxFullFlushMergeWaitTime = timeValue;
        "index.max_terms_count",
            List.of(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING)
    private void setMergeOnFlushEnabled(boolean enabled) {
    }
        IndexMergePolicy::fromString,
        this.replicationType = IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(newSettings);
        Property.Dynamic
    public static final Setting<String> TIME_SERIES_INDEX_MERGE_POLICY = Setting.simpleString(
    }
        return numberOfShards;
    private final Index index;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_DEFAULT_SLICE_COUNT_VALUE;
     * Returns the node settings. The settings returned from {@link #getSettings()} are a merged version of the
        scopedSettings.addSettingsUpdateConsumer(MAX_TERMS_COUNT_SETTING, this::setMaxTermsCount);
    /**
        "index.translog.sync_interval",
    }
        "index.translog.batch_append.enabled",
        scopedSettings.addSettingsUpdateConsumer(
    }
    public static final Setting<Integer> MAX_SLICES_PER_PIT = Setting.intSetting(
    }
     * Returns true iff {@code index.remote_store.flush_on_uncommitted_segments.threshold_size} exists or in other
    public boolean isSegRepLocalEnabled() {
        this.translogReadForward = INDEX_TRANSLOG_READ_FORWARD_SETTING.get(settings);
     * Controls the number of translog files that are no longer needed for persistence reasons will be kept around before being deleted.
        1,
    private void setMappingFieldNameLengthLimit(long value) {
        this.flushAfterMergeThresholdSize = byteSizeValue;
package org.opensearch.index;
        return mergePolicyProvider.getMergePolicy();
        "index.default_pipeline",
    );
    public static final Setting<Long> INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING = Setting.longSetting(
        value -> {
    /**
    }
        return remoteTranslogUploadBufferInterval;
    private final IndexSortConfig indexSortConfig;
                break;
            logByteSizeMergePolicyProvider::setLBSNoCFSRatio
import org.opensearch.common.settings.Setting;
        false,
    public static final Setting<String> SEARCHABLE_SNAPSHOT_REPOSITORY = Setting.simpleString(
        );
    @Deprecated
    private boolean autoForcemergeEnabled;
    /**
            );
        scopedSettings.addSettingsUpdateConsumer(
        return refreshInterval;
     * This setting will be ignored if soft-deletes is used in peer recoveries (default in 7.4).
        return this.maxNestedQueryDepth;
    private volatile int maxShingleDiff;
        translogBatchAppendMaxSize = scopedSettings.get(INDEX_TRANSLOG_BATCH_APPEND_MAX_SIZE_SETTING);
    /**
        return Strings.isEmpty(customDataPath()) == false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String indexScopedPolicy = scopedSettings.get(INDEX_MERGE_POLICY);
    private final RemoteStorePathStrategy remoteStorePathStrategy;
            Property.Dynamic,
     */
        this.maxInnerResultWindow = maxInnerResultWindow;
    /**
        Property.IndexScope
     */
    public String getNodeName() {
    private final boolean widenIndexSortType;
     * @param indexMetadata the index metadata this settings object is associated with
        TimeValue.timeValueSeconds(30),
    /**
    public TimeValue getSearchIdleAfter() {
        DEFAULT_GC_DELETES,
    public String pluggableDataFormat() {
        return queryStringAllowLeadingWildcard;
        scopedSettings.addSettingsUpdateConsumer(ALLOW_DERIVED_FIELDS, this::setAllowDerivedField);
     * Is merge of flush enabled or not
     * be preserved for rollback purposes, we want to keep the size of individual generations from
        mergeSchedulerConfig = new MergeSchedulerConfig(this);
        Property.IndexScope
import static org.opensearch.index.codec.fuzzy.FuzzySetParameters.DEFAULT_FALSE_POSITIVE_PROBABILITY;
                    + " can't be set when "
        Property.IndexScope
        this.publishReferencedSegmentsInterval = publishReferencedSegmentsInterval;
    }
    public synchronized boolean updateIndexMetadata(IndexMetadata indexMetadata) {
    public static final Setting<Integer> MAX_SCRIPT_FIELDS_SETTING = Setting.intSetting(
        Property.Dynamic,
    public boolean isQueryStringAllowLeadingWildcard() {
        "index.translog.generation_threshold_size",
            default:
    public static final Setting<String> INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY = Setting.simpleString(
     */
    public static final Setting<Boolean> INDEX_MERGE_ON_FLUSH_ENABLED = Setting.boolSetting(
    public int getStreamingAggregationMinSegmentSize() {
        true, /* https://issues.apache.org/jira/browse/LUCENE-10078 */
     * latency and memory of large bulks. Raise it for append-heavy indices fed by large bulk requests.
import java.util.Optional;
    );
            tieredMergePolicyProvider.setMaxMergesAtOnce(
     *
        } else if (MERGE_ON_FLUSH_MERGE_POLICY.equalsIgnoreCase(policy)) {
        LOG_BYTE_SIZE("log_byte_size"),
import org.opensearch.indices.replication.common.ReplicationType;
    private volatile int maxTermsCount;
     */
    private volatile boolean enableFuzzySetForDocId;
    public static final Setting<Boolean> INDEX_TRANSLOG_BATCH_APPEND_ENABLED_SETTING = Setting.boolSetting(
    }
        this.translogBatchAppendMaxSize = maxSize;
     * doc values might incur a per-field per-document seek.
/*
        this.remoteTranslogKeepExtraGen = extraGen;
            throw new IllegalArgumentException("uuid mismatch on settings update expected: " + restoreUUID + " but was: " + newRestoreUUID);
     *
        value -> {
                    break;
    private volatile TimeValue periodicFlushInterval;
    }
import static org.opensearch.index.mapper.MapperService.INDEX_MAPPING_NESTED_FIELDS_LIMIT_SETTING;
        return isPluggableDataFormatEnabled() ? logByteSizeMergePolicyProvider : tieredMergePolicyProvider;
            tieredMergePolicyProvider.setMaxMergesAtOnceToDefault();
        Property.Dynamic,
    public double getDocIdFuzzySetFalsePositiveProbability() {
            throw new IllegalArgumentException(
        scopedSettings = indexScopedSettings.copy(nodeSettings, indexMetadata);
    public static final Setting<Boolean> INDEX_UNREFERENCED_FILE_CLEANUP = Setting.boolSetting(
        Property.IndexScope
        return assignedOnRemoteNode;
    public static final Setting<Integer> MAX_REGEX_LENGTH_SETTING = Setting.intSetting(
    /**
        Property.Dynamic
        return this.maxScriptFields;
        return derivedSourceEnabled;
    /**
        this.durability = durability;
     */
    );
    }
                "The setting has unsupported policy specified: "
        this(indexMetadata, nodeSettings, IndexScopedSettings.DEFAULT_SCOPED_SETTINGS);
                "version mismatch on settings update expected: " + version + " but was: " + IndexMetadata.indexCreated(newSettings)
    }
    );
    }
    public static final TimeValue DEFAULT_REFRESH_INTERVAL = new TimeValue(1, TimeUnit.SECONDS);
    public long getMappingFieldNameLengthLimit() {
     * indexing with offsets or term vectors is recommended.
        TimeValue.timeValueMillis(100),
        Property.IndexScope
        return maxRefreshListeners;
    public IndexScopedSettings getScopedSettings() {
        return isWarmIndex;
     * The default value is 3 is defensive as it prevents generating too many tokens.
    }
        1,
    /**
        );
    /**
    public enum IndexMergePolicy {
            this.mergeOnFlushPolicy = MergeOnFlushMergePolicy::new;
        "index.search.concurrent_segment_search.mode",
        Property.IndexScope
    public static final Setting<Integer> MAX_TERMS_COUNT_SETTING = Setting.intSetting(
     */
import static org.opensearch.index.mapper.MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING;
     * effective threshold is the cluster setting
    /**
    private volatile Translog.Durability durability;
        0,
        maxFullFlushMergeWaitTime = scopedSettings.get(INDEX_MERGE_ON_FLUSH_MAX_FULL_FLUSH_MERGE_WAIT_TIME);
    }
        this.autoForcemergeEnabled = autoForcemergeEnabled;
        "index.translog.retention.age",
    /**
    }
    public void setRemoteTranslogKeepExtraGen(int extraGen) {
        Property.Dynamic
     *
        Property.IndexScope
    /**
    );
     * Returns true if index warmers are enabled, otherwise <code>false</code>
import org.opensearch.Version;
    private volatile ByteSizeValue flushThresholdSize;
        );
        return this.maxAnalyzedOffset;
        "index.refresh_interval",
        Property.IndexScope
        new ByteSizeValue(64, ByteSizeUnit.MB),
                    throw new IllegalArgumentException("Setting value must be one of [all, none, auto]");
     * @return max level of nested queries and documents
        return maxSlicesPerScroll;
        Property.IndexScope
import org.apache.logging.log4j.Logger;
     * safely.
        500_000,
    }
     * The maximum number of slices allowed in a scroll request.
        "index.max_docvalue_fields_search",
        Property.IndexScope
    private void setFlushOnUncommittedSegmentsThresholdSize(ByteSizeValue flushOnUncommittedSegmentsThresholdSize) {
    }
 * @opensearch.api
 *
    private void setStreamingAggregationMinSegmentSize(int streamingAggregationMinSegmentSize) {
                );
    }
        if (newRestoreUUID.equals(restoreUUID) == false) {
        return this.maxFullFlushMergeWaitTime;
        "index.final_pipeline",
        return this.maxNgramDiff;
        return maxRescoreWindow;
        TimeValue.MINUS_ONE,
    public static final Setting<String> INDEX_CHECK_ON_STARTUP = new Setting<>("index.shard.check_on_startup", "false", (s) -> {
    public static final Setting<Double> FILE_BASED_RECOVERY_THRESHOLD_SETTING = Setting.doubleSetting(
    public Translog.Durability getTranslogDurability() {
        INDEX_DERIVED_SOURCE_SETTING,
            tieredMergePolicyProvider::setNoCFSRatio
    }
        return flushAfterMergeThresholdSize;
        this.searchThrottled = INDEX_SEARCH_THROTTLED.get(settings);
            String ingestionSourceType = IndexMetadata.INGESTION_SOURCE_TYPE_SETTING.get(settings);
import static org.opensearch.common.util.FeatureFlags.CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_SETTING;
    /**
     * Default is false (backward reading), which is the traditional behavior that naturally handles sequence number collisions
 * license agreements. See the NOTICE file distributed with
    public MergePolicy getMergePolicy(boolean isTimeSeriesIndex) {
     * Expert: sets the amount of time to wait for merges (during {@link org.apache.lucene.index.IndexWriter#commit}
            tieredMergePolicyProvider::setSegmentsPerTier
    public int getMaxInnerResultWindow() {
    private void setShouldCleanupUnreferencedFiles(boolean shouldCleanupUnreferencedFiles) {
        this.maxScriptFields = maxScriptFields;
        scopedSettings.addSettingsUpdateConsumer(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING, this::setRemoteTranslogKeepExtraGen);
     * Returns the settings for this index. These settings contain the node and index level settings where
        }
 * SPDX-License-Identifier: Apache-2.0
        "index.periodic_flush_interval",
    public MergeSchedulerConfig getMergeSchedulerConfig() {
    );
     */
    }
     */
         * An empty translog occupies 55 bytes on disk. If the flush threshold is below this, the flush thread
    public int getTranslogBatchAppendMaxOperations() {
                    + policy
    }
        "index.highlight.max_analyzed_offset",
 */
        Property.Dynamic
        Property.InternalIndex
    /**
        "indices.query.query_string.allowLeadingWildcard",
     */
        Property.Dynamic,
    private volatile String requiredPipeline;
        new ByteSizeValue(Translog.DEFAULT_HEADER_SIZE_IN_BYTES + 1, ByteSizeUnit.BYTES),
     * @param isTimeSeriesIndex true if index contains @timestamp field
        }
        scopedSettings.addSettingsUpdateConsumer(INDEX_MAPPING_DEPTH_LIMIT_SETTING, this::setMappingDepthLimit);
    public static final Setting<ByteSizeValue> INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING = Setting.byteSizeSetting(
    );
    public static final Setting<Integer> MAX_TOKEN_COUNT_SETTING = Setting.intSetting(
    /**
     * cluster default, which is resolved by the publisher of the accounting (see {@code RemoteStoreRefreshListener}).
    }
            logger.trace("Index: " + this.index.getName() + ", Merge policy used: " + mergePolicyProvider);
        }
    public static final TimeValue MINIMUM_REFRESH_INTERVAL = new TimeValue(-1, TimeUnit.MILLISECONDS);
            && MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.exists(getSettings()) == false;
         */
        0,
     * Returns the version the index was created on.
        return translogRetentionSize;
         * rolling the generation as every new generation will already exceed the
    private volatile ByteSizeValue translogRetentionSize;
        Property.IndexScope
    }
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
        this.streamingAggregationMinSegmentSize = streamingAggregationMinSegmentSize;
     */
     * Marks an index to be searched throttled. This means that never more than one shard of such an index will be searched concurrently
        this.maxAnalyzedOffset = maxAnalyzedOffset;
                .equals(right.filter(IndexScopedSettings.ARCHIVED_SETTINGS_KEY_PREDICATE));
    }
    public static final Setting<List<String>> DEFAULT_FIELD_SETTING = Setting.listSetting(
     */
    public String getRemoteStoreRepository() {
    private final boolean checkPendingFlushEnabled;
            TieredMergePolicyProvider.INDEX_COMPOUND_FORMAT_SETTING,
     * Minimum accepted value for {@link #DEFAULT_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE} and its cluster
     * Returns the max result window for an individual inner hit definition or top hits aggregation.
    /**
        this.periodicFlushInterval = timeValue;
     */
                    IndexMergePolicy nodeMergePolicy = IndexMergePolicy.fromString(nodeScopedTimeSeriesIndexPolicy);
    public boolean isQueryStringAnalyzeWildcard() {
    }
    private final boolean defaultAllowUnmappedFields;
     * Returns if remote translog store is enabled for this index.
                throw new IllegalArgumentException(
     * The maximum age of a retention lease before it is considered expired.
        Property.IndexScope,
                            mergePolicyProvider = logByteSizeMergePolicyProvider;
    );
    );
    /** Maximum operations per batched translog append; see {@link #INDEX_TRANSLOG_BATCH_APPEND_MAX_OPERATIONS_SETTING}. */
    private volatile ReplicationType replicationType;
    );
    }
    /**
     * proper index setting during the migration.
            value -> mergeSchedulerConfig.updateMaxForceMergeMBPerSec(this)
        "index.max_refresh_listeners",
            TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGED_SEGMENT_SETTING,
    }
    /**
        65536,
    /**
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
     * Returns the transaction log threshold size when to forcefully flush the index and clear the transaction log.
        "index.search.concurrent_segment_search.partition_min_segment_size",
    public static final Setting<Boolean> PLUGGABLE_DATAFORMAT_ENABLED_SETTING = Setting.boolSetting(
    private void setMaxRegexLength(int maxRegexLength) {
    }
        Property.Dynamic,
     * Index setting to enable / disable deletes garbage collection.
     */
     * Update the default maxMergesAtOnce
    /**
        TimeValue.timeValueSeconds(5),
        scopedSettings.addSettingsUpdateConsumer(
        Property.IndexScope
        );
    }
        this.indexMetadata = indexMetadata;
import org.opensearch.cluster.metadata.IndexMetadata;
            );
        maxTokenCount = scopedSettings.get(MAX_TOKEN_COUNT_SETTING);
        "indices.time_series_index.default_index_merge_policy",
    private final IndexScopedSettings scopedSettings;
     */
     */
        CONCURRENT_SEGMENT_SEARCH_MODE_NONE,
        Property.IndexScope,
    public static final Setting<Boolean> INDEX_SOFT_DELETES_SETTING = Setting.boolSetting(
    private void setTranslogRetentionSize(ByteSizeValue byteSizeValue) {
     * Is flush check by write threads enabled or not
        Property.IndexScope
            tieredMergePolicyProvider.setMaxMergesAtOnceToDefault();
import static org.opensearch.Version.V_2_7_0;
    private void setMaxInnerResultWindow(int maxInnerResultWindow) {
    }
    private volatile String remoteStoreRepository;
        return isTranslogMetadataEnabled;
    /**
    private void setTranslogBatchAppendMaxOperations(int maxOperations) {
import org.opensearch.ingest.IngestService;
        0,
    }
     * {@code cluster.remote_store.flush_on_uncommitted_segments.enabled}. When this is not set on the index, the
        "index.context_aware.enabled",
        Property.IndexScope
        return requiredPipeline;
            logByteSizeMergePolicyProvider::setLBSMaxMergeSegment
            INDEX_PUBLISH_REFERENCED_SEGMENTS_INTERVAL_SETTING,
        Property.Dynamic,
    );
    );
        "index.soft_deletes.enabled",
        new ByteSizeValue(64, ByteSizeUnit.MB),
        100,
    /**
    private volatile boolean shouldCleanupUnreferencedFiles;
    /**
     * Compare the specified settings for equality.
    );
    public static final Setting<TimeValue> INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING = Setting.timeSetting(
    }
     */
        scopedSettings.addSettingsUpdateConsumer(
     */
    );
     */
        "index.flush_after_merge",
     * Index setting describing for NGramTokenizer and NGramTokenFilter
        maxRefreshListeners = scopedSettings.get(MAX_REFRESH_LISTENERS_PER_SHARD);
        return isStarTreeIndexEnabled;
     * appends successful primary index operations in bounded batches instead of one write per operation. Local-store
    public int getMaxTokenCount() {
        Property.Deprecated
/*
     */
        this.derivedSourceEnabledForTranslog = isDerivedSourceEnabledForTranslog;
     * Returns <code>true</code> if the query string parser should allow leading wildcards. The default is <code>true</code>
         * to higher bytes size like integer to long. This behavior was changed from OpenSearch 2.7 version not to
            logByteSizeMergePolicyProvider::setLBSMergeFactor
     * Returns the maximum number of terms that can be used in a Terms Query request
        "index.context.created_version",
     * Local-store and document-replication engines ignore this setting and retain per-operation appends.
            .equals(right.filter(IndexScopedSettings.INDEX_SETTINGS_KEY_PREDICATE))
        Function.identity(),
        },
        isCompositeIndex = scopedSettings.get(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING);
        Property.Dynamic,
    public boolean isWarmerEnabled() {
 */
     * a conservative default as it is sure to not cause trouble. Users can
     */
        true,
        checkPendingFlushEnabled = scopedSettings.get(INDEX_CHECK_PENDING_FLUSH_ENABLED);
    public Optional<UnaryOperator<MergePolicy>> getMergeOnFlushPolicy() {
        Property.Dynamic
        assert shouldDisableTranslogRetention(settings) == false || translogRetentionAge.millis() == -1L : translogRetentionSize;
            logger.warn("Search idle is not supported for remote backed indices");
    /**
            INDEX_MAX_RETRY_ON_LOOKUP_MAP_LOCK_ACQUISITION_EXCEPTION,
     * ({@code index.translog.flush_threshold_size}) is ineffective because uploaded translog generations are trimmed
    }
                    + ", "
     * Returns true if the index is writable warm index and has partial store locality.
     * while index level settings will overwrite node settings.
            logByteSizeMergePolicyProvider::setLBSMinMergedMB
     *
                }
            this::setFlushOnUncommittedSegmentsThresholdSize
     * @return {@code true} if pluggable data format is enabled
     */
    private void setTranslogFlushThresholdSize(ByteSizeValue byteSizeValue) {
    private void setMergeOnFlushPolicy(String policy) {
        scopedSettings.addSettingsUpdateConsumer(MAX_SLICES_PER_PIT, this::setMaxSlicesPerPit);
        scopedSettings.addSettingsUpdateConsumer(INDEX_GC_DELETES_SETTING, this::setGCDeletes);
     */
        1_000,
    public boolean isCheckPendingFlushEnabled() {
        assert mergePolicyProvider != null : "should not happen as validation for invalid merge policy values "
    public void setDefaultPipeline(String defaultPipeline) {
    public ByteSizeValue getFlushThresholdSize() {
    public int getNumberOfShards() {
        "index.merge_on_flush.max_full_flush_merge_wait_time",
        mappingFieldNameLengthLimit = scopedSettings.get(INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING);
        this.maxSlicesPerScroll = value;
    public String customDataPath() {
        .byteSizeSetting(
    /**
    private void setPeriodicFlushInterval(TimeValue timeValue) {
     */
        Property.IndexScope,
     * Returns the default search fields for this index.
    private void setMaxNgramDiff(int maxNgramDiff) {
                    + String.join(", ", Arrays.stream(IndexMergePolicy.values()).map(IndexMergePolicy::getValue).toArray(String[]::new))
    private final Logger logger;
    public int getRemoteTranslogExtraKeep() {
    }
 * a settings consumer at index creation via {@link IndexModule#addSettingsUpdateConsumer(Setting, Consumer)} that will
     * max_shingle_size and min_shingle_size.
        Property.Dynamic
    private final boolean assignedOnRemoteNode;
        this.generationThresholdSize = generationThresholdSize;
    public static final Setting<String> PLUGGABLE_DATAFORMAT_VALUE_SETTING = Setting.simpleString(
    public static final Setting<PathType> SEARCHABLE_SNAPSHOT_SHARD_PATH_TYPE = new Setting<>(
import org.opensearch.common.util.FeatureFlags;
    }
    private void setMappingDepthLimit(long value) {
    }
    public <T> T getValue(Setting<T> setting) {
    }
        false,
        Property.IndexScope,
        scopedSettings.addSettingsUpdateConsumer(MAX_ADJACENCY_MATRIX_FILTERS_SETTING, this::setMaxAdjacencyMatrixFilters);
    /**
        scopedSettings.addSettingsUpdateConsumer(INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING, this::setMappingNestedDocsLimit);
     *
    /**
        return settings.getAsInt(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, null);
        scopedSettings.addSettingsUpdateConsumer(INDEX_UNREFERENCED_FILE_CLEANUP, this::setShouldCleanupUnreferencedFiles);
        "index.query.derived_field.enabled",
 * specific language governing permissions and limitations
    );
     * Defaults to retaining history for up to 10% of the documents in the shard. This can only be changed in tests, since this setting is
     * the chance of ops based recoveries for indices with soft-deletes disabled.
     * Index setting describing the maximum size of the rescore window. Defaults to {@link #MAX_RESULT_WINDOW_SETTING}
        if (shouldDisableTranslogRetention(settings) && byteSizeValue.getBytes() >= 0) {
    public static final TimeValue MINIMUM_REMOTE_TRANSLOG_BUFFER_INTERVAL = TimeValue.ZERO;
import org.opensearch.core.common.unit.ByteSizeUnit;
    /**
        isRemoteStoreFencingEnabled = settings.getAsBoolean(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, false);
     * The maximum length of regex string allowed in a regexp query.
    public String getRemoteStoreSegmentPathPrefix() {
    );
    public boolean isTranslogBatchAppendEnabled() {
        Property.IndexScope,
        if (shouldDisableTranslogRetention(settings) && age.millis() >= 0) {
        scopedSettings.addSettingsUpdateConsumer(
        gcDeletesInMillis = scopedSettings.get(INDEX_GC_DELETES_SETTING).getMillis();
        return remoteStoreTranslogRepository;
                } else {
    );
    );
    );
     * Creates a new {@link IndexSettings} instance. The given node settings will be merged with the settings in the metadata
     * Updates the settings and index metadata and notifies all registered settings consumers with the new settings iff at least one
        Property.IndexScope,
    public void setDefaultSearchPipeline(String defaultSearchPipeline) {
    private void setMaxSlicesPerPit(int value) {
    private volatile TimeValue remoteTranslogUploadBufferInterval;
        scopedSettings.addSettingsUpdateConsumer(
    }
     * {@link org.opensearch.index.shard.IndexShard#trimOperationOfPreviousPrimaryTerms(long)}) occurs during the recovery
     */
     */
        scopedSettings.addSettingsUpdateConsumer(
     * @param right the right settings
     */
        }
     * The maximum number of slices allowed in a PIT request.
        );
        Property.IndexScope,
    public TimeValue getTranslogRetentionAge() {
    /**
     * Defaults to true which means unreferenced files will be cleaned up in case segment merge fails.
        return this.softDeleteRetentionOperations;
        Property.Dynamic,
     * Returns true if the this index should be searched throttled ie. using the
        Property.Dynamic,
    public boolean shouldWidenIndexSortType() {
        Property.Final
        return remoteStoreTranslogRepository != null && remoteStoreTranslogRepository.isEmpty() == false;
     * certainly profile their cluster and decide to set it to 100,000
     * all other indexes default to {@link TieredMergePolicyProvider}.
     * max_gram (maximum length of characters in a gram) and
        scopedSettings.addSettingsUpdateConsumer(INDEX_SEARCH_THROTTLED, this::setSearchThrottled);
    public void setEnableFuzzySetForDocId(boolean enableFuzzySetForDocId) {
     * Soft-deletes is enabled by default for Legacy 7.x and 1.x indices and mandatory for 2.0+ indices.
    public boolean isEnableFuzzySetForDocId() {
    public static final Setting<Integer> INDEX_MAX_RETRY_ON_LOOKUP_MAP_LOCK_ACQUISITION_EXCEPTION = Setting.intSetting(
     *
    public RemoteStorePathStrategy getRemoteStorePathStrategy() {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
    public boolean isRemoteTranslogStoreEnabled() {
        Property.IndexScope,
        Property.Dynamic,
        scopedSettings.addSettingsUpdateConsumer(INDEX_SEARCH_IDLE_AFTER, this::setSearchIdleAfter);
        maxScriptFields = scopedSettings.get(MAX_SCRIPT_FIELDS_SETTING);
    }
    public static final Setting<Boolean> INDEX_CHECK_PENDING_FLUSH_ENABLED = Setting.boolSetting(
        100,
    );
        contextAwareEnabled = scopedSettings.get(INDEX_CONTEXT_AWARE_ENABLED_SETTING);
    }
    public void setPublishReferencedSegmentsInterval(TimeValue publishReferencedSegmentsInterval) {
        return INDEX_SOFT_DELETES_SETTING.get(settings);
        return queryStringAnalyzeWildcard;
        scopedSettings.addSettingsUpdateConsumer(INDEX_TRANSLOG_BATCH_APPEND_ENABLED_SETTING, this::setTranslogBatchAppendEnabled);
            INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING,
        return translogBatchAppendMaxSize;
     * The default maximum of 20. 1 means once nesting.
    /**
        this.retentionLeaseMillis = retentionLease.millis();
        Property.IndexScope,
        Property.Dynamic,
        derivedSourceEnabled = scopedSettings.get(INDEX_DERIVED_SOURCE_SETTING) || pluggableDataFormatEnabled;
    );
    @Deprecated
        throw new UnsupportedOperationException("Experimental feature has been removed");
    public boolean isAssignedOnRemoteNode() {
        return mappingTotalFieldsLimit;
    private volatile TimeValue maxFullFlushMergeWaitTime;
     */
        scopedSettings.addSettingsUpdateConsumer(INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING, this::setTranslogFlushThresholdSize);
    }
        new TimeValue(-1, TimeUnit.MILLISECONDS),
    public String getDefaultPipeline() {
    }
        "index.pluggable.dataformat.enabled",
    private long gcDeletesInMillis = DEFAULT_GC_DELETES.millis();
        switch (s) {
        return pluggedDataFormat;
     * Returns the current node name
    public static final Setting<Boolean> INDEX_TRANSLOG_READ_FORWARD_SETTING = Setting.boolSetting(
         * up cast the SortField to gain some sort query optimizations.
     * Returns the current IndexMetadata for this index
    /**
    public int getMaxDocvalueFields() {
    private void setMaxAdjacencyMatrixFilters(int maxAdjacencyFilters) {
    );
     * remote-store shards.
     * The default maximum of 65536 terms is defensive, as extra processing and memory is involved
            case "true":
     * Returns true iff the refresh setting exists or in other words is explicitly set.
    /**
            MergeSchedulerConfig.MAX_FORCE_MERGE_MB_PER_SEC_SETTING,
    public boolean isSoftDeleteEnabled() {
        Property.IndexScope,
import org.opensearch.search.streaming.FlushModeResolver;
            // nothing to update, same settings
                            mergePolicyProvider = tieredMergePolicyProvider;
        "index.optimize_doc_id_lookup.fuzzy_set.enabled",
    public int getMaxSlicesPerPit() {
        Property.Dynamic
     * This setting will be ignored if soft-deletes is used in peer recoveries (default in 7.4).
        32,
     * Every shard on a remote node would also have SegRep enabled even without
            TieredMergePolicyProvider.INDEX_MERGE_POLICY_DELETES_PCT_ALLOWED_SETTING,
        Property.IndexScope,
 */
        this.maxRescoreWindow = maxRescoreWindow;
    );
    private volatile boolean allowDerivedField;
    private volatile int maxNestedQueryDepth;
    private volatile long softDeleteRetentionOperations;
        Property.IndexScope
    public long getMappingNestedDocsLimit() {
    );
     * condition takes over the commit-lag-bounding job that the translog size condition performs on non
            this::updateMaxMergesAtOnce,
    }
     * @return the maximum age
            logByteSizeMergePolicyProvider::setLBSMaxMergeMBForForcedMerge
     * Specifies if the index should be context aware enabled
        );
    public long getGcDeletesInMillis() {
     * Requires both the experimental feature flag and the index-level setting.
    /**
        this.defaultAllowUnmappedFields = scopedSettings.get(ALLOW_UNMAPPED);
    /**
    }
         * can get stuck in an infinite loop as the shouldPeriodicallyFlush can still be true after flushing.
    /**
        "index.translog.read_forward",
     * Returns if remote store is enabled for this index.
    public boolean hasCustomDataPath() {
     */
     * @param indexMetadata the index metadata this settings object is associated with
     * will be kept around before being deleted. Keeping more files is useful to increase
     */
            case LOG_BYTE_SIZE:
    public static final Setting<String> INDEX_MERGE_POLICY = Setting.simpleString(
        setEnableFuzzySetForDocId(scopedSettings.get(INDEX_DOC_ID_FUZZY_SET_ENABLED_SETTING));
        0.50,
import java.util.List;
     */
        return mappingFieldNameLengthLimit;
        Property.IndexScope
    private volatile long retentionLeaseMillis;
 * the latest updated settings instance. Classes that need to listen to settings updates can register
    public static boolean same(final Settings left, final Settings right) {
        if (same(this.settings, newIndexSettings)) {
    public boolean isSegRepEnabledOrRemoteNode() {
        MINIMUM_PERIODIC_FLUSH_INTERVAL,
        setTranslogRetentionAge(scopedSettings.get(INDEX_TRANSLOG_RETENTION_AGE_SETTING));
        return queryStringLenient;
        return nodeName;
 * Modifications Copyright OpenSearch Contributors. See
        "index.searchable_snapshot.repository",
        Property.IndexScope
    public boolean isAutoForcemergeEnabled() {
    /**
        1,
     * per search request. The default maximum of 100 is defensive for the reason that retrieving
        Property.IndexScope
    /**
    }
    }
     * Periodic flush interval setting. By default, periodic flush is disabled (-1).
        flushOnUncommittedSegmentsThresholdSize = scopedSettings.get(
     * and there are duplicates of the same translog operations with different primary terms in the translog
        Property.IndexScope
     */
                        case DEFAULT_POLICY:
    private volatile String remoteStoreTranslogRepository;
    );
    /**
    public boolean isQueryStringLenient() {
        this.allowDerivedField = scopedSettings.get(ALLOW_DERIVED_FIELDS);
        100,
    private volatile ByteSizeValue generationThresholdSize;
        "index.search.default_pipeline",
     * {@code MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING}
    private final boolean pluggableDataFormatEnabled;
    public static final Setting<Integer> MAX_NESTED_QUERY_DEPTH_SETTING = Setting.intSetting(
        if (TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.exists(getSettings()) == false) {
    public int getMaxRegexLength() {
    /**
        Property.IndexScope
     * For pull-based ingestion indices, this defaults to 10 minutes to ensure offsets are regularly committed.
     * remote-store shard. On remote-store shards the translog based flush threshold
    public static final Setting<String> FINAL_PIPELINE = new Setting<>(
            );
     */
        1,
        Property.Dynamic,
     */
    public TimeValue getRefreshInterval() {
        this.durability = scopedSettings.get(INDEX_TRANSLOG_DURABILITY_SETTING);
    public boolean isRemoteStoreEnabled() {
import static org.opensearch.index.mapper.MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING;
        maxSlicesPerScroll = scopedSettings.get(MAX_SLICES_PER_SCROLL);
     * Composite engine indexes default to {@link LogByteSizeMergePolicyProvider};
     * to prevent generating too many token objects.
    public boolean isContextAwareEnabled() {
        Property.IndexScope
     */
        Property.IndexScope
        return this.maxShingleDiff;
    public static final Setting<Integer> INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING = Setting.intSetting(
        scopedSettings.addSettingsUpdateConsumer(INDEX_MERGE_ON_FLUSH_ENABLED, this::setMergeOnFlushEnabled);
    }
                        case TIERED:
    private volatile String remoteStoreSegmentPathPrefix;
        );
    public static final ByteSizeValue MINIMUM_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE = new ByteSizeValue(1, ByteSizeUnit.BYTES);
        return allowDerivedField;
    public String getRemoteStoreTranslogRepository() {
            LogByteSizeMergePolicyProvider.INDEX_LBS_MERGE_POLICY_MIN_MERGE_SETTING,
        "index.max_script_fields",
    private volatile long mappingNestedDocsLimit;
            Property.IndexScope
     * The maximum length of regex string allowed in a regexp query.
                case CONCURRENT_SEGMENT_SEARCH_MODE_AUTO:
    public void setAutoForcemergeEnabled(boolean autoForcemergeEnabled) {
    public static final Setting<Integer> INDEX_TRANSLOG_BATCH_APPEND_MAX_OPERATIONS_SETTING = Setting.intSetting(
        return mappingNestedDocsLimit;
    public static final Setting<Boolean> INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING = Setting.boolSetting(
     * 1. sets the new default in {@code TieredMergePolicyProvider}
        Property.Dynamic,
            this::setRemoteStoreTranslogRepository
    public void setDocIdFuzzySetFalsePositiveProbability(double docIdFuzzySetFalsePositiveProbability) {
    public static final Setting<Double> INDEX_DOC_ID_FUZZY_SET_FALSE_POSITIVE_PROBABILITY_SETTING = Setting.doubleSetting(
    /**
        "index.max_slices_per_scroll",
        return periodicFlushInterval;
        }
    /**
     * The default maximum of 1M characters is defensive as for highlighting larger texts,
     * {@link org.opensearch.indices.recovery.RecoveryTarget#finalizeRecovery(long, long, org.opensearch.core.action.ActionListener)}
        MINIMUM_REMOTE_TRANSLOG_BUFFER_INTERVAL,
     * Index setting describing the maximum value of allowed `docvalue_fields`that can be retrieved
     */
    private volatile ByteSizeValue translogBatchAppendMaxSize;
    /**
    /**
    );
    public String getUUID() {
        mergeSchedulerConfig.setDefaultMaxThreadAndMergeCount(maxThreadCount, maxMergeCount, overrideExistingConfigs);
    }
    public int getMaxTermsCount() {
        1000,
        Property.Dynamic,
        return version;
        "index.max_rescore_window",
    public boolean isDerivedSourceEnabledForTranslog() {
    /**
        true,
import java.util.Collections;
    }
        DEFAULT_REMOTE_TRANSLOG_BUFFER_INTERVAL,
    private volatile String defaultPipeline;
        );
        Property.Dynamic
        return defaultPipeline;
    }
        "index.query_string.lenient",
        scopedSettings.addSettingsUpdateConsumer(
    }
    /**
    private void setHighlightMaxAnalyzedOffset(int maxAnalyzedOffset) {
    private volatile long mappingTotalFieldsLimit;
    /**
     * offsets or term vectors.
     * Returns the maximum allowed difference between max and min length of ngram
    }
        Property.IndexScope
     * The Default maximum value of from + size on a query is 10,000. This was chosen as
        return this.widenIndexSortType;
    private final boolean isCompositeIndex;
        scopedSettings.addSettingsUpdateConsumer(INDEX_TRANSLOG_RETENTION_SIZE_SETTING, this::setTranslogRetentionSize);
        return true;
    private volatile TimeValue syncInterval;
     * <p>
     * Index setting describing for ShingleTokenFilter
            FlushModeResolver.STREAMING_AGGREGATION_MIN_SEGMENT_SIZE_SETTING,
        PathType.FIXED.toString(),
        this.translogBatchAppendMaxOperations = maxOperations;
    private volatile double docIdFuzzySetFalsePositiveProbability;
        true,
     * @param left  the left settings
        softDeleteRetentionOperations = scopedSettings.get(INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING);
        Property.Dynamic,
    }
        "index.merge_on_flush.enabled",
        return index;
     * Returns <code>true</code> if queries should be lenient about unmapped fields. The default is <code>true</code>
    public void setTranslogSyncInterval(TimeValue translogSyncInterval) {
     * Returns the transaction log retention size which controls how much of the translog is kept around to allow for ops based recoveries
    private void setDerivedSourceEnabledForTranslog(boolean isDerivedSourceEnabledForTranslog) {
        mergeSchedulerConfig.setDefaultAutoThrottleEnabled(
    private final MergeSchedulerConfig mergeSchedulerConfig;
 * You may obtain a copy of the License at
        warmerEnabled = scopedSettings.get(INDEX_WARMER_ENABLED_SETTING);
        "",
        scopedSettings.addSettingsUpdateConsumer(MAX_REGEX_LENGTH_SETTING, this::setMaxRegexLength);
     * Sets it to default maxMergesAtOnce if index level settings is being removed
    private volatile int maxDocvalueFields;
        return scopedSettings.get(setting);
     * Update the cached defaults for {@code MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING} and
     **/
     * top hits aggregation. The default maximum of 100 is defensive for the reason that the number of inner hit responses
     *
        scopedSettings.addSettingsUpdateConsumer(MAX_SLICES_PER_SCROLL, this::setMaxSlicesPerScroll);
        Property.Dynamic,
        100,
    }
        0.1d,
    public long getSoftDeleteRetentionOperations() {
        );
     * Returns the max result window for search requests, describing the maximum value of from + size on a query.
    }
        );
     * while index level settings will overwrite node settings.
    private void setMaxSlicesPerScroll(int value) {
     * Returns the indexes UUID
        this.maxSlicesPerPit = value;
     * Returns the generation threshold size. As sequence numbers can cause multiple generations to
     * operations-based peer recovery is limited to this proportion of the total number of documents in the shard (including deleted
        0.01,
        1024,
        scopedSettings.addSettingsUpdateConsumer(
        "index.translog.durability",
        this.enableFuzzySetForDocId = enableFuzzySetForDocId;
     * Index setting describing the maximum value of allowed `script_fields`that can be retrieved
    }
            case DEFAULT_POLICY:
    public static final Setting<ByteSizeValue> INDEX_TRANSLOG_BATCH_APPEND_MAX_SIZE_SETTING = Setting.byteSizeSetting(
    /**
     */
    /**
    }
     * Low-throughput trickle workloads that never cross the byte threshold and never go idle can additionally enable
    private void setGenerationThresholdSize(final ByteSizeValue generationThresholdSize) {
        return this.maxAdjacencyMatrixFilters;
    );
            TieredMergePolicyProvider.INDEX_MERGE_POLICY_FLOOR_SEGMENT_SETTING,
    private void setMaxResultWindow(int maxResultWindow) {
     * Returns <code>true</code> if soft-delete is enabled.
    private static final String MERGE_ON_FLUSH_MERGE_POLICY = "merge-on-flush";
        TimeValue.timeValueMinutes(0),
    }
    private final LogByteSizeMergePolicyProvider logByteSizeMergePolicyProvider;
    );
     * Returns the maximum number of tokens that can be produced
     * safely. 1,000,000 is probably way to high for any cluster to set
     */
         * below this, the flush thread can get stuck in an infinite loop repeatedly
     * Returns the merge threshold size when to forcefully flush the index and free resources.
    private volatile long mappingDynamicPropertiesLuceneFieldLimit;
    }
     * Returns the maximum number of allowed docvalue_fields to retrieve in a search request
        maxAdjacencyMatrixFilters = scopedSettings.get(MAX_ADJACENCY_MATRIX_FILTERS_SETTING);
    private volatile int maxSlicesPerPit;
    }
        final String newRestoreUUID = newSettings.get(IndexMetadata.SETTING_HISTORY_UUID, IndexMetadata.INDEX_UUID_NA_VALUE);
     */
     */
    /**
    public ByteSizeValue getTranslogRetentionSize() {
     */
        1,
                mergePolicyProvider = tieredMergePolicyProvider;
     *
        scopedSettings.addSettingsUpdateConsumer(
    public static final Setting<Integer> MAX_INNER_RESULT_WINDOW_SETTING = Setting.intSetting(
                throw new IllegalArgumentException(
    public boolean isPluggableDataFormatEnabled() {
    private volatile int maxRefreshListeners;
        1,
     */
        return scopedSettings;
    public void setRemoteTranslogUploadBufferInterval(TimeValue remoteTranslogUploadBufferInterval) {
    }
     * per search request. The default maximum of 32 is defensive for the reason that retrieving
     * aborted, and will still run to completion independent of the commit or getReader call, like natural segment merges.
     */
            INDEX_TRANSLOG_BATCH_APPEND_MAX_OPERATIONS_SETTING,
    private void setMaxDocvalueFields(int maxDocvalueFields) {
        this.nodeSettings = nodeSettings;
    /**
     */
        /*
    /**
     */
        );
    private void setDefaultFields(List<String> defaultFields) {
    private void setSearchIdleAfter(TimeValue searchIdleAfter) {
     */
        pluggedDataFormat = scopedSettings.get(PLUGGABLE_DATAFORMAT_VALUE_SETTING);
     */
     * {@code index.periodic_flush_interval} (disabled by default) for a wall-clock flush backstop.
    /**
    /**
    }
        );
    }
    /**
        "index.recovery.file_based_threshold",
        scopedSettings.addSettingsUpdateConsumer(
        }
    public boolean isSearchThrottled() {
        boolean overrideExistingConfigs = MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.exists(getSettings()) == false
    }
    }
            }
        Property.Final
        0,
    }
     * Controls the maximum length of time since a retention lease is created or renewed before it is considered expired.
    /**
     */
     * the maximum difference between
     * Index setting describing the maximum number of terms that can be used in Terms Query.
        );
    );
    }
        this.maxResultWindow = maxResultWindow;
    /**
        "index.check_pending_flush.enabled",
        1024,
        CONCURRENT_SEGMENT_SEARCH_DEFAULT_SLICE_COUNT_VALUE,
        DEFAULT_POLICY,
        maxRetryOnLookupMapAcquisitionException = scopedSettings.get(INDEX_MAX_RETRY_ON_LOOKUP_MAP_LOCK_ACQUISITION_EXCEPTION);
     **/
    public int getMaxScriptFields() {
    private volatile boolean isStarTreeIndexEnabled;
         */
     * will be kept around before being deleted. Keeping more files is useful to increase
        Property.IndexScope,
    }
     * Returns this interval in which the shards of this index are asynchronously refreshed. {@code -1} means async refresh is disabled.
    private final TieredMergePolicyProvider tieredMergePolicyProvider;
     * In this scenario, forward reading could return outdated operations from previous primary terms.
        Property.InternalIndex
                if (policy.value.equals(text)) {
        scopedSettings.addSettingsUpdateConsumer(MAX_SHINGLE_DIFF_SETTING, this::setMaxShingleDiff);
    public static final Setting<Boolean> ALLOW_UNMAPPED = Setting.boolSetting(
        this.defaultPipeline = defaultPipeline;
        100,
     * {@link #getFlushOnUncommittedSegmentsThresholdSize()}.
    private volatile long mappingFieldNameLengthLimit;
     */
     * Maximum serialized size one batched translog append may carry. Bounds the heap one write thread holds for its
        maxResultWindow = scopedSettings.get(MAX_RESULT_WINDOW_SETTING);
        if (TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.exists(updatedSettings) == false) {
import org.opensearch.index.remote.RemoteStorePathStrategy;
    }
    public int getNumberOfReplicas() {
        return isRemoteStoreFencingEnabled;
        );
        scopedSettings.addSettingsUpdateConsumer(INDEX_PERIODIC_FLUSH_INTERVAL_SETTING, this::setPeriodicFlushInterval);
        this.softDeleteRetentionOperations = ops;
    }
    }
        "index.gc_deletes",
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
     * Returns the translog sync/upload buffer interval when remote translog store is enabled and index setting
        final String newUUID = newSettings.get(IndexMetadata.SETTING_INDEX_UUID, IndexMetadata.INDEX_UUID_NA_VALUE);
     * Returns true if segment replication is enabled on the index.
        scopedSettings.addSettingsUpdateConsumer(DEFAULT_SEARCH_PIPELINE, this::setDefaultSearchPipeline);
        Property.Final
    }
public final class IndexSettings {
    /**
        "index.context.current_version",
 * KIND, either express or implied.  See the License for the
        defaultPipeline = scopedSettings.get(DEFAULT_PIPELINE);
    public static final Setting<Boolean> INDEX_WARMER_ENABLED_SETTING = Setting.boolSetting(
     * Denotes whether this is a composite index i.e star-tree index etc
        "index.derived_source.enabled",
    /**
        1,
        "index.max_inner_result_window",
        this.indexSortConfig = new IndexSortConfig(this);
     * index settings and the node settings where node settings are overwritten by index settings.
    );
        TimeValue.timeValueSeconds(1),
     * when {@link #isFlushOnUncommittedSegmentsThresholdSizeExplicit()}; otherwise the effective threshold is the
     * by prioritizing operations from newer generations.
        SearchPipelineService.NOOP_PIPELINE_ID,
        this.index = indexMetadata.getIndex();
    /**
     * @param maxAdjacencyFilters the max number of filters in adjacency_matrix aggregation search requests
        }
     * <b>Note:</b> Enabling forward reading is safe for most use cases. However, in rare edge cases, it may replay stale
    // volatile fields are updated via #updateIndexMetadata(IndexMetadata) under lock
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
        flushAfterMergeThresholdSize = scopedSettings.get(INDEX_FLUSH_AFTER_MERGE_THRESHOLD_SIZE_SETTING);
     * The maximum size of a translog generation. This is independent of the maximum size of
        return remoteStoreRepository;
        this.indexMetadata = indexMetadata;
    }
        "index.query.parse.allow_unmapped_fields",
        Property.Dynamic
    public static final Setting<Integer> MAX_NGRAM_DIFF_SETTING = Setting.intSetting(
    );
        scopedSettings.addSettingsUpdateConsumer(INDEX_TRANSLOG_SYNC_INTERVAL_SETTING, this::setTranslogSyncInterval);
        scopedSettings.addSettingsUpdateConsumer(
        false,
        this.autoForcemergeEnabled = scopedSettings.get(INDEX_AUTO_FORCE_MERGES_ENABLED);
    /**
        true,
        "index.pluggable.dataformat",
        generationThresholdSize = scopedSettings.get(INDEX_TRANSLOG_GENERATION_THRESHOLD_SIZE_SETTING);
        Property.IndexScope
        Property.Dynamic,
     */
    /**
        scopedSettings.addSettingsUpdateConsumer(
        translogBatchAppendEnabled = scopedSettings.get(INDEX_TRANSLOG_BATCH_APPEND_ENABLED_SETTING);
     */
     * Returns the maximum number of chars that will be analyzed in a highlight request
    /**
        0,
            LogByteSizeMergePolicyProvider.INDEX_LBS_MERGE_POLICY_MERGE_FACTOR_SETTING,
    /**
                mergePolicyProvider = logByteSizeMergePolicyProvider;
    }
        );
        scopedSettings.addSettingsUpdateConsumer(
    }
    /**
         * Now this sortField (IndexSort) is stored in SegmentInfo and we need to maintain backward compatibility for them.
        Function.identity(),
    public boolean isRemoteSnapshot() {
        1,
        new ByteSizeValue(Translog.DEFAULT_HEADER_SIZE_IN_BYTES + 1, ByteSizeUnit.BYTES),
        Property.Dynamic,
    /**
    }
    public static final Setting<Integer> MAX_SHINGLE_DIFF_SETTING = Setting.intSetting(
            case "checksum":
     * Returns the max number of filters in adjacency_matrix aggregation search requests
            }
        Function.identity(),
    public boolean isTranslogMetadataEnabled() {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
     */
            // ignore the translog retention settings if soft-deletes enabled
    );
    // Partition strategy constants
        this.mappingTotalFieldsLimit = value;
    );
    }
        Property.Dynamic,
    }
        scopedSettings.addSettingsUpdateConsumer(INDEX_TRANSLOG_DURABILITY_SETTING, this::setTranslogDurability);
import org.opensearch.index.translog.Translog;
    private volatile int streamingAggregationMinSegmentSize;
 * ownership. Elasticsearch licenses this file to you under
        "index.translog.batch_append.max_operations",
        );
        Property.IndexScope
        // the MergeSchedulerConfig, but we only update the actual values when an index level setting is not present
     * The minimum total size of segment bytes not yet referenced by the last commit point which triggers a flush on a
                    return policy;
                );
     * The maximum number of refresh listeners allows on this shard.
    public TimeValue getTranslogSyncInterval() {
    /**
    );
    private void setMappingDynamicPropertiesLuceneFieldLimit(long value) {
        this.maxRetryOnLookupMapAcquisitionException = maxRetryOnLookupMapAcquisitionException;
     * @return the buffer interval.
        IngestService.NOOP_PIPELINE_NAME,
     */
     * because they both do the same thing: control the size of the heap of hits.
            logger.debug("Resetting maxMergesAtOnce to cluster default");
                TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.get(updatedSettings)
    public static final Setting<TimeValue> INDEX_PUBLISH_REFERENCED_SEGMENTS_INTERVAL_SETTING = Setting.timeSetting(
                default:
    }
        private final String value;
    public Version getExtendedCompatibilitySnapshotVersion() {
     * appended in several chunks; a smaller one is always a single append, so the cap only bounds the per-append
    );
        scopedSettings.applySettings(newSettings);
    );
    /**
    private void setTranslogDurability(Translog.Durability durability) {
    );
     */
    public static final Setting<Long> INDEX_CONTEXT_CURRENT_VERSION = Setting.longSetting(
                "The "
    );
     * @return true if the settings are the same, otherwise false
    }
    );
        version = IndexMetadata.SETTING_INDEX_VERSION_CREATED.get(settings);
        this.isRemoteStoreEnabled = isRemoteStoreEnabled;
     */
    }
        1000000,
    );
        return INDEX_TRANSLOG_RETENTION_TOTAL_FILES_SETTING.get(getSettings());
    public static final Setting<String> SEARCHABLE_SNAPSHOT_INDEX_ID = Setting.simpleString(
    }
     */
                break;
    );
        this.maxShingleDiff = maxShingleDiff;
    );
        scopedSettings.addSettingsUpdateConsumer(
    }
        scopedSettings.addSettingsUpdateConsumer(
        return indexMetadata.isRemoteSnapshot();
    }
        scopedSettings.addSettingsUpdateConsumer(
    public long getMappingTotalFieldsLimit() {
    private int remoteTranslogKeepExtraGen;
     */
    /**
        numberOfShards = settings.getAsInt(IndexMetadata.SETTING_NUMBER_OF_SHARDS, null);
     */
    }
        Property.NodeScope
     * Specifies if the index should use soft-delete instead of hard-delete for update/delete operations.
    public static final Setting<Boolean> INDEX_DERIVED_SOURCE_SETTING = Setting.boolSetting(
     * intentionally unregistered.
     * when soft-deletes is disabled.
     * Returns true iff the remote translog buffer interval setting exists or in other words is explicitly set.
        if (this.replicationType == ReplicationType.SEGMENT && this.getNumberOfReplicas() > 0) {
    );
        return remoteStorePathStrategy;
    public Settings getSettings() {
        1,
        scopedSettings.addSettingsUpdateConsumer(INDEX_TRANSLOG_BATCH_APPEND_MAX_SIZE_SETTING, this::setTranslogBatchAppendMaxSize);
import org.apache.lucene.index.MergePolicy;
import org.opensearch.index.remote.RemoteStoreUtils;
     */
    public static final Setting<Integer> MAX_RESULT_WINDOW_SETTING = Setting.intSetting(
    public boolean getStarTreeIndexEnabled() {
    public Settings getNodeSettings() {
        return searchIdleAfter;
        );
        // Upon updates to the cluster default settings, we always update the cached default values in
    private final boolean contextAwareEnabled;
     * Returns <code>true</code> if query string parsing should be lenient. The default is <code>false</code>
     * @param nodeSettings  the nodes settings this index is allocated on.
    /**
    }
    private volatile ByteSizeValue flushAfterMergeThresholdSize;
    private final Settings nodeSettings;
        syncInterval = INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.get(settings);
        if (version.equals(IndexMetadata.indexCreated(newSettings)) == false) {
        0,
                            break;
    /**
    /**
    public static final Setting<Integer> MAX_ADJACENCY_MATRIX_FILTERS_SETTING = Setting.intSetting(
     * Returns the interval at which a periodic flush should be executed. {@code -1} means periodic flush is disabled.
     * {@code index.translog.durability} is set as {@code request}.
     */
    }
    private volatile boolean mergeOnFlushEnabled;
        }
            LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGE_SEGMENT_SETTING,
    @Deprecated
        public static IndexMergePolicy fromString(String text) {
     */
                            break;
        "index.query.max_nested_depth",
    );
        Property.InternalIndex
        this.maxRefreshListeners = maxRefreshListeners;
                    String nodeScopedTimeSeriesIndexPolicy = TIME_SERIES_INDEX_MERGE_POLICY.get(nodeSettings);
        Property.Dynamic,
        new ByteSizeValue(512, ByteSizeUnit.MB),
        0,
            TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING,
    }
    }
     */
    }
     * Specialized merge-on-flush policy if provided
        maxNgramDiff = scopedSettings.get(MAX_NGRAM_DIFF_SETTING);
        scopedSettings.addSettingsUpdateConsumer(INDEX_REFRESH_INTERVAL_SETTING, this::setRefreshInterval);
         * do not add a large lower bound here.
        "index.analyze.max_token_count",
        true,
    private void setMaxNestedQueryDepth(int maxNestedQueryDepth) {
    void updateMaxMergesAtOnce(Settings updatedSettings) {
 * be called for each settings update.
    public int getMaxRefreshListeners() {
        this.mappingDynamicPropertiesLuceneFieldLimit = value;
    public static final TimeValue DEFAULT_GC_DELETES = TimeValue.timeValueSeconds(60);
    void setDefaultAutoThrottleEnabled(boolean enabled) {
        scopedSettings.addSettingsUpdateConsumer(INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING, this::setRetentionLeaseMillis);
     */
    private volatile boolean isRemoteStoreEnabled;
        false,
        scopedSettings.addSettingsUpdateConsumer(
        Property.NodeScope
    private void setTranslogBatchAppendEnabled(boolean enabled) {
    /**
     * translog operations that have not been flushed.
     * The default value is 1 as this is default difference in NGramTokenizer,
    /**
        Property.Final
            );
    private final boolean queryStringAllowLeadingWildcard;
     */
@PublicApi(since = "1.0.0")
                    }
    /**
        this.isStarTreeIndexEnabled = value;
    }
    private void setAllowDerivedField(boolean allowDerivedField) {
    public void setRemoteStoreRepository(String remoteStoreRepository) {
                case CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_FORCE:
        }
     * Returns the custom path prefix for remote store segments, if set.
            this::setMaxRetryOnLookupMapAcquisitionException
        return remoteStoreSegmentPathPrefix;
    public static final TimeValue DEFAULT_PERIODIC_FLUSH_INTERVAL = TimeValue.MINUS_ONE;
     */
        Property.Dynamic,
        scopedSettings.addSettingsUpdateConsumer(MAX_REFRESH_LISTENERS_PER_SHARD, this::setMaxRefreshListeners);
     * @return <code>true</code> iff any setting has been updated otherwise <code>false</code>.
        return nodeSettings;
        scopedSettings.addSettingsUpdateConsumer(StarTreeIndexSettings.STAR_TREE_SEARCH_ENABLED_SETTING, this::setStarTreeIndexEnabled);
        Property.Dynamic
    private void setGCDeletes(TimeValue timeValue) {
    );
     * {@code cluster.remote_store.flush_on_uncommitted_segments.threshold_size} — see
        this.maxTokenCount = maxTokenCount;
        this.defaultSearchPipeline = defaultSearchPipeline;
    }
     */
        Property.Dynamic,
    public TimeValue getPeriodicFlushInterval() {
        );
     * Returns the maximum number of allowed script_fields to retrieve in a search request
     */
        this.mappingNestedDocsLimit = value;
        0,
     * Returns the translog durability for this index.
        if (Strings.isEmpty(policy) || DEFAULT_POLICY.equalsIgnoreCase(policy)) {
        true,
    public static final Setting<TimeValue> INDEX_TRANSLOG_RETENTION_AGE_SETTING = Setting.timeSetting(
            this.value = value;
     * finalization phase. If a replica fails before completing
     */
     */
        new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES), // never flush after merge
        Property.IndexScope,
    }
        scopedSettings.addSettingsUpdateConsumer(MAX_TOKEN_COUNT_SETTING, this::setMaxTokenCount);
    /**
         * An empty translog occupies 55 bytes on disk. If the generation threshold is
     * Returns the translog sync interval. This is the interval in which the transaction log is asynchronously fsynced unless
        0,
            MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING,
    }
     * The minimum size of a merge that triggers a flush in order to free resources
     * Controls whether translog operations are read in forward order (oldest to newest) or backward order (newest to oldest).
         */
        return mergeOnFlushEnabled;
        // Upon updates to the cluster default settings, we always update the cached default values in
        return this.maxTermsCount;
    /**
            this.translogRetentionSize = byteSizeValue;
 * software distributed under the License is distributed on an
            // ignore the translog retention settings if soft-deletes enabled
    public long getRetentionLeaseMillis() {
        Property.Dynamic,
    public static final Setting<String> DEFAULT_SEARCH_PIPELINE = new Setting<>(
    private void setMaxScriptFields(int maxScriptFields) {
        return checkPendingFlushEnabled;
        Property.Dynamic,
            if (ingestionSourceType != null && !IndexMetadata.NONE_INGESTION_SOURCE_TYPE.equals(ingestionSourceType)) {
    }
    private volatile List<String> defaultFields;
    public static final Setting<Integer> INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE = Setting.intSetting(
import java.util.function.Consumer;
    public static final Setting<Boolean> QUERY_STRING_ANALYZE_WILDCARD = Setting.boolSetting(
        Property.Dynamic,
     */
        // Only set the prefix if it's explicitly set and not empty
        widenIndexSortType = IndexMetadata.SETTING_INDEX_VERSION_CREATED.get(settings).before(V_2_7_0);
     * Index setting describing the maximum value of from + size on a query.
     * Controls how long translog files that are no longer needed for persistence reasons
        Function.identity(),
        );
        maxInnerResultWindow = scopedSettings.get(MAX_INNER_RESULT_WINDOW_SETTING);
            this::setStreamingAggregationMinSegmentSize
        this.queryStringAnalyzeWildcard = QUERY_STRING_ANALYZE_WILDCARD.get(nodeSettings);
    /**
    private volatile UnaryOperator<MergePolicy> mergeOnFlushPolicy;
    public boolean isExplicitRefresh() {
            INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING,
     * Returns the transaction log retention age which controls the maximum age (time from creation) that translog files will be kept
    public static final Setting<String> INDEX_CONCURRENT_SEGMENT_SEARCH_MODE = Setting.simpleString(
     * False positive probability to use while creating fuzzy set.
import static org.opensearch.index.mapper.MapperService.INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING;
        this.settings = Settings.builder().put(nodeSettings).put(indexMetadata.getSettings()).build();
        "index.max_adjacency_matrix_filters",
        return warmerEnabled;
    public boolean isMergeOnFlushEnabled() {
    }
    }
        "indices.query.query_string.analyze_wildcard",
    /**
    public static final Setting<Translog.Durability> INDEX_TRANSLOG_DURABILITY_SETTING = new Setting<>(
    );
        final String restoreUUID = this.settings.get(IndexMetadata.SETTING_HISTORY_UUID, IndexMetadata.INDEX_UUID_NA_VALUE);
    private volatile boolean searchThrottled;
    }
        return softDeleteEnabled;
     */
     * The maximum number of slices allowed in a search request with PIT
    private volatile int maxResultWindow;
    }
    public long getMappingDynamicPropertiesLuceneFieldLimit() {
    public static final Setting<String> DEFAULT_PIPELINE = new Setting<>(
     */
     * Controls how many translog files that are no longer needed for persistence reasons
        Property.IndexScope
    }
    private volatile int maxNgramDiff;
    private void setSearchThrottled(boolean searchThrottled) {
        remoteStorePathStrategy = RemoteStoreUtils.determineRemoteStorePathStrategy(indexMetadata);
    }
        this.gcDeletesInMillis = timeValue.getMillis();
    public static final Setting<Integer> MAX_SLICES_PER_SCROLL = Setting.intSetting(
    }
     */
        this.translogBatchAppendEnabled = enabled;
        maxTermsCount = scopedSettings.get(MAX_TERMS_COUNT_SETTING);
        Property.IndexScope
        false,
            mergeOnFlushPolicy = null;
        "index.search.throttled",
        Property.IndexScope,
        },
     * Returns the minimum segment size for streaming aggregations.
        Property.Dynamic,
     * @deprecated Experimental feature has been removed. Do not use.
     * <p>
     */
        Property.Dynamic,
            enabled,
    /**
    /**
/**
    );
                case CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_SEGMENT:
    );
        "index.searchable_snapshot.snapshot_id.name",
     * more sense to copy all the data over again instead of replaying history.
        scopedSettings.addSettingsUpdateConsumer(MAX_DOCVALUE_FIELDS_SEARCH_SETTING, this::setMaxDocvalueFields);
    private final boolean translogReadForward;
        return maxInnerResultWindow;
    /**
        Property.Dynamic,
        return docIdFuzzySetFalsePositiveProbability;
    public boolean isWarmIndex() {
     */
        publishReferencedSegmentsInterval = INDEX_PUBLISH_REFERENCED_SEGMENTS_INTERVAL_SETTING.get(settings);
            MergeSchedulerConfig.AUTO_THROTTLE_SETTING.exists(getSettings()) == false
        Property.Dynamic,
    /**
    );
            for (IndexMergePolicy policy : IndexMergePolicy.values()) {
     * Index setting describing the maximum number of filters clauses that can be used
        this.remoteStoreRepository = remoteStoreRepository;
        scopedSettings.addSettingsUpdateConsumer(INDEX_DOC_ID_FUZZY_SET_ENABLED_SETTING, this::setEnableFuzzySetForDocId);
     * Deliberately the same as the default of {@link #INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING}, since this
     * The minimum segment size for streaming aggregations.
    /**
        false,
        Property.IndexScope
     * the chance of ops based recoveries for indices with soft-deletes disabled.
    }
    public static final TimeValue MINIMUM_PERIODIC_FLUSH_INTERVAL = TimeValue.MINUS_ONE;
        Property.IndexScope,
     */
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
     * produced using _analyze API. The default maximum of 10000 is defensive
    private static boolean shouldDisableTranslogRetention(Settings settings) {
        return durability;
        Property.IndexScope
        mappingNestedFieldsLimit = scopedSettings.get(INDEX_MAPPING_NESTED_FIELDS_LIMIT_SETTING);
     */
    public static final Setting<TimeValue> INDEX_SEARCH_IDLE_AFTER = Setting.timeSetting(
        return gcDeletesInMillis;
     */
     * Returns the number of shards this index has.
     */
     * Maximum number of operations one batched translog append may carry. A shard bulk request larger than this is
        scopedSettings.addSettingsUpdateConsumer(
            switch (value) {
     * Returns <code>true</code> if the query string should analyze wildcards. The default is <code>false</code>
        } else {
        this.mappingNestedFieldsLimit = value;
        20,
        return mergeSchedulerConfig;
     */
        return isCompositeIndex;
        "index.segment_replication.publish_referenced_segments_interval",
    public static final String CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_SEGMENT = "segment";
 * this file be licensed under the Apache-2.0 license or a
    /**
        remoteStoreTranslogRepository = settings.get(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY);
        1,
        mappingNestedDocsLimit = scopedSettings.get(INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING);
        new ByteSizeValue(0, ByteSizeUnit.BYTES), // always flush after merge
    }
        this.maxRegexLength = maxRegexLength;
        Property.IndexScope
     */
        Property.IndexScope
            return false;
    );
    private void setMaxShingleDiff(int maxShingleDiff) {
        scopedSettings.addSettingsUpdateConsumer(DEFAULT_FIELD_SETTING, this::setDefaultFields);
        if (isDerivedSourceEnabledForTranslog && !isDerivedSourceEnabled()) {
    }
        scopedSettings.addSettingsUpdateConsumer(INDEX_FLUSH_AFTER_MERGE_THRESHOLD_SIZE_SETTING, this::setFlushAfterMergeThresholdSize);
    /**
import org.opensearch.common.settings.Settings;
    public static final Setting<Boolean> INDEX_CONCURRENT_SEGMENT_SEARCH_SETTING = Setting.boolSetting(
        this.remoteTranslogUploadBufferInterval = remoteTranslogUploadBufferInterval;
    public static final Setting<Integer> INDEX_CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT = Setting.intSetting(
     * documents increases the chance of operation-based recoveries and allows querying a longer history of documents.
     * and document-replication engines retain the normal per-operation path regardless of this setting. Default false:
            new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES),
        this.requiredPipeline = requiredPipeline;
                    switch (nodeMergePolicy) {
     */
        Property.Final
     */
        Property.Dynamic,
        this.flushThresholdSize = byteSizeValue;
     * Is fuzzy set enabled for doc id
        scopedSettings.addSettingsUpdateConsumer(INDEX_AUTO_FORCE_MERGES_ENABLED, this::setAutoForcemergeEnabled);
        }
     */
            // Default to 10 minutes for pull-based ingestion indices, disabled otherwise
    private volatile boolean warmerEnabled;
    private volatile TimeValue publishReferencedSegmentsInterval;
            }
    private void setRetentionLeaseMillis(final TimeValue retentionLease) {
     */
    /**
     * cluster setting it falls back to, {@code cluster.remote_store.flush_on_uncommitted_segments.threshold_size}.
     * Returns true if this is remote/searchable snapshot
        "index.unreferenced_file_cleanup.enabled",
    public Index getIndex() {
     * The maximum length of regex string allowed in a regexp query.
        flushThresholdSize = scopedSettings.get(INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING);
    public static final String CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_FORCE = "force";
    }
 *
    public static final Setting<Boolean> INDEX_AUTO_FORCE_MERGES_ENABLED = Setting.boolSetting(
        "index.search.concurrent.max_slice_count",
     * Returns the time that an index shard becomes search idle unless it's accessed in between
        scopedSettings.addSettingsUpdateConsumer(MAX_INNER_RESULT_WINDOW_SETTING, this::setMaxInnerResultWindow);
    public int getMaxSlicesPerScroll() {
     */
     * pending chunk; whichever of this and {@link #INDEX_TRANSLOG_BATCH_APPEND_MAX_OPERATIONS_SETTING} is reached
        this.syncInterval = translogSyncInterval;
    public ByteSizeValue getGenerationThresholdSize() {
     * the maximum difference between
     * Returns true if we need to maintain backward compatibility for index sorted indices created prior to version 2.7
        if (logger.isTraceEnabled()) {
     * Returns the number of replicas this index has.
    }
    );
     */
            this.translogRetentionSize = new ByteSizeValue(-1);
    /** Maximum serialized bytes per batched translog append; see {@link #INDEX_TRANSLOG_BATCH_APPEND_MAX_SIZE_SETTING}. */
        Property.IndexScope,
    public static final Setting<Boolean> QUERY_STRING_LENIENT_SETTING = Setting.boolSetting(
            logger.warn("Search idle is not supported for indices with replicas using 'replication.type: SEGMENT'");
    }
        Property.IndexScope
        return translogBatchAppendMaxOperations;
        return maxRegexLength;
     * Returns the {@link MergeSchedulerConfig}
        );
import static org.opensearch.common.util.FeatureFlags.CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG;
        } else {
        assignedOnRemoteNode = RemoteStoreNodeAttribute.isRemoteDataAttributePresent(this.getNodeSettings());
    }
     * own explicit setting.
     */
    }
     * min_gram (minimum length of characters in a gram).
     * Returns if remote store is enabled for this index.
        scopedSettings.addSettingsUpdateConsumer(MergeSchedulerConfig.AUTO_THROTTLE_SETTING, mergeSchedulerConfig::setAutoThrottle);
    }
    }
        IndexMergePolicy(String value) {
        "index.translog.retention.total_files",
    );
    private MergePolicyProvider defaultMergePolicyProvider() {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MIN_SLICE_COUNT_VALUE;
     * Enum representing supported merge policies
     *
     * Returns the maximum rescore window for search requests.
        scopedSettings.addSettingsUpdateConsumer(INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING, this::setMappingFieldNameLengthLimit);
    public int getMaxRetryOnLookupMapAcquisitionException() {
    public String getRequiredPipeline() {
        Property.IndexScope,
     */
import org.opensearch.core.common.unit.ByteSizeValue;
    }
                    + IndexSettings.INDEX_MERGE_ON_FLUSH_POLICY.getKey()
    }
     */
    private void setMaxFullFlushMergeWaitTime(TimeValue timeValue) {
        );
        Property.Dynamic,
    }
     * Returns this index's {@code index.remote_store.flush_on_uncommitted_segments.threshold_size}. Only meaningful
        "index.max_regex_length",
     */
    /**
        DEFAULT_REFRESH_INTERVAL,
     */
    public boolean isDocumentReplication() {
        Property.Dynamic,
     * Controls how many soft-deleted documents will be kept around before being merged away. Keeping more deleted
        new ByteSizeValue(512, ByteSizeUnit.MB),
    /**
        scopedSettings.addSettingsUpdateConsumer(MAX_RESCORE_WINDOW_SETTING, this::setMaxRescoreWindow);
    private volatile int maxRegexLength;
     * Returns whether the pluggable data format feature is enabled for this index.
        periodicFlushInterval = scopedSettings.get(INDEX_PERIODIC_FLUSH_INTERVAL_SETTING);
    private static final String DEFAULT_POLICY = "default";
    public TimeValue getPublishReferencedSegmentsInterval() {
     * in an adjacency_matrix aggregation. The max number of buckets produced by
        defaultSearchPipeline = scopedSettings.get(DEFAULT_SEARCH_PIPELINE);
 * not use this file except in compliance with the License.
        return retentionLeaseMillis;
     */
    public long getMappingDepthLimit() {
     */
        }
     * and is defensive as it prevents generating too many index terms.
                default:
    /**
     */
         * For indices created prior version (prior to 2.7) which has IndexSort type, they used to type cast the SortField.Type
        5,
                }
    }
     * A setting describing the maximum number of tokens that can be
        100_000,
     */
    public List<String> getDefaultFields() {
        PathType::parseString,
        this.tieredMergePolicyProvider = new TieredMergePolicyProvider(logger, this);
    );
        maxNestedQueryDepth = scopedSettings.get(MAX_NESTED_QUERY_DEPTH_SETTING);
        Property.Dynamic,
import org.opensearch.common.logging.Loggers;
 * under the License.
    private final int numberOfShards;
     * Default for {@link #INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING} and for the
    public ByteSizeValue getFlushAfterMergeThresholdSize() {
        "index.derived_source.translog.enabled",
        return maxRetryOnLookupMapAcquisitionException;
    }
    private volatile int maxSlicesPerScroll;
        scopedSettings.addSettingsUpdateConsumer(FINAL_PIPELINE, this::setRequiredPipeline);
     * The max amount of time to wait for merges
        isStarTreeIndexEnabled = scopedSettings.get(StarTreeIndexSettings.STAR_TREE_SEARCH_ENABLED_SETTING);
    /**
        remoteTranslogUploadBufferInterval = INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.get(settings);
    }
        new TimeValue(1, TimeUnit.MILLISECONDS),
    /**
    /**
     * an eligible index keeps the per-operation path until an operator opts in; dynamic for controlled rollout.
     */
    /**
    private volatile int maxAnalyzedOffset;
    }
}
                    + MERGE_ON_FLUSH_MERGE_POLICY
        this.mergeOnFlushEnabled = enabled;
    }
    private final boolean queryStringAnalyzeWildcard;
    );
    private volatile TimeValue refreshInterval;
        return shouldCleanupUnreferencedFiles;
    }
    /**
     * The maximum number of slices allowed in a PIT request.
        // the MergeSchedulerConfig, but we only update the actual values when an index level setting is not present
     * Returns the merge policy that should be used for this index.
        this.refreshInterval = timeValue;
     */
        return this.derivedSourceEnabledForTranslog;
     */
        Property.IndexScope
     * The maximum number of refresh listeners allows on this shard.
        Property.Dynamic
        return isRemoteStoreEnabled;
     */
    );
    private volatile boolean translogBatchAppendEnabled;
import org.opensearch.node.Node;
        Property.IndexScope
                    + IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey()
        true,
    public static final Setting<String> SEARCHABLE_SNAPSHOT_ID_NAME = Setting.simpleString(
        searchIdleAfter = scopedSettings.get(INDEX_SEARCH_IDLE_AFTER);
        DEFAULT_FALSE_POSITIVE_PROBABILITY,
        new ByteSizeValue(4, ByteSizeUnit.KB),
     * Returns the GC deletes cycle in milliseconds.
        );
    private int maxRetryOnLookupMapAcquisitionException;
    /**
     * @return the generation threshold size
    public Version getIndexVersionCreated() {
            INDEX_DOC_ID_FUZZY_SET_FALSE_POSITIVE_PROBABILITY_SETTING,
import static org.opensearch.index.mapper.MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING;
    }
    public static final Setting<Integer> INDEX_TRANSLOG_RETENTION_TOTAL_FILES_SETTING = Setting.intSetting(
        switch (indexMergePolicy) {
        scopedSettings.addSettingsUpdateConsumer(MAX_ANALYZED_OFFSET_SETTING, this::setHighlightMaxAnalyzedOffset);
    );
     */
    public static final Setting<Boolean> ALLOW_DERIVED_FIELDS = Setting.boolSetting(
        "index.context_aware.max_retry_on_lookup_map_acquisition_exception",
        Property.IndexScope
    }
 * This class encapsulates all index level settings and handles settings updates.
    }
        "index.searchable_snapshot.index.id",
     * Returns the customDataPath for this index, if configured. <code>""</code> o.w.
    public static final Setting<Boolean> QUERY_STRING_ALLOW_LEADING_WILDCARD = Setting.boolSetting(
    );
    );
    );
     * around
     * Updates the maxMergesAtOnce for actual TieredMergePolicy used by the engine.
        softDeleteEnabled = scopedSettings.get(INDEX_SOFT_DELETES_SETTING);
            mergeSchedulerConfig::setMaxThreadAndMergeCount
        IndexMergePolicy::fromString,
    }, Property.IndexScope);
        refreshInterval = scopedSettings.get(INDEX_REFRESH_INTERVAL_SETTING);
    private void setSoftDeleteRetentionOperations(long ops) {
    }
    /**
    public ByteSizeValue getFlushOnUncommittedSegmentsThresholdSize() {
    private final boolean isWarmIndex;
     **/
        maxRescoreWindow = scopedSettings.get(MAX_RESCORE_WINDOW_SETTING);
    /**
        Property.Dynamic,
        Property.InternalIndex
        setMergeOnFlushPolicy(scopedSettings.get(INDEX_MERGE_ON_FLUSH_POLICY));
                        case LOG_BYTE_SIZE:
        scopedSettings.addSettingsUpdateConsumer(INDEX_TRANSLOG_GENERATION_THRESHOLD_SIZE_SETTING, this::setGenerationThresholdSize);
                    + ". Please use one of: "
import java.util.Locale;
    public static final Setting<String> SEARCHABLE_SNAPSHOT_ID_UUID = Setting.simpleString(
                    // valid setting
            throw new IllegalArgumentException(
        return defaultSearchPipeline;
        this.maxNestedQueryDepth = maxNestedQueryDepth;
        return this.autoForcemergeEnabled;
        );
        IngestService.NOOP_PIPELINE_NAME,
            throw new IllegalArgumentException("uuid mismatch on settings update expected: " + getUUID() + " but was: " + newUUID);
    }
    public static final Setting<TimeValue> INDEX_TRANSLOG_SYNC_INTERVAL_SETTING = Setting.timeSetting(
    private volatile TimeValue translogRetentionAge;
        Property.Dynamic,
    private volatile int maxScriptFields;
        Property.Dynamic,
        DEFAULT_POLICY,
        Property.Dynamic,
        scopedSettings.addSettingsUpdateConsumer(MAX_NESTED_QUERY_DEPTH_SETTING, this::setMaxNestedQueryDepth);
    public static final Setting<Long> INDEX_CONTEXT_CREATED_VERSION = Setting.longSetting(
        return this.maxResultWindow;
    public int getTranslogRetentionTotalFiles() {
        10000,
    /**
            logByteSizeMergePolicyProvider::setLBSMaxMergeDocs
        assert shouldDisableTranslogRetention(settings) == false || translogRetentionSize.getBytes() == -1L : translogRetentionSize;
    private final String pluggedDataFormat;
        "index.search.concurrent_segment_search.partition_strategy",
        scopedSettings.addSettingsUpdateConsumer(INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING, this::setDerivedSourceEnabledForTranslog);
    /**
     * and number of top hits buckets returned is unbounded. Profile your cluster when increasing this setting.
        Collections.singletonList("*"),
    }
            TieredMergePolicyProvider.INDEX_MERGE_POLICY_EXPUNGE_DELETES_ALLOWED_SETTING,
        return ReplicationType.DOCUMENT.equals(replicationType);
        "index.search.concurrent_segment_search.enabled",
    }
    private final boolean derivedSourceEnabled;
    /**
     * <p>
    void setDefaultMaxMergesAtOnce(int newDefaultMaxMergesAtOnce) {
        }
     * {@link org.opensearch.threadpool.ThreadPool.Names#SEARCH_THROTTLED} thread-pool
    }
    public int getMaxNestedQueryDepth() {
            return value;
        translogBatchAppendMaxOperations = scopedSettings.get(INDEX_TRANSLOG_BATCH_APPEND_MAX_OPERATIONS_SETTING);
        Property.IndexScope
            && left.filter(IndexScopedSettings.ARCHIVED_SETTINGS_KEY_PREDICATE)
        setDocIdFuzzySetFalsePositiveProbability(scopedSettings.get(INDEX_DOC_ID_FUZZY_SET_FALSE_POSITIVE_PROBABILITY_SETTING));
    public int getHighlightMaxAnalyzedOffset() {
    );
    void setDefaultMaxThreadAndMergeCount(int maxThreadCount, int maxMergeCount) {
            this::setRemoteTranslogUploadBufferInterval
    /**
    /**
    private void setMappingTotalFieldsLimit(long value) {
        public String getValue() {
     * threshold size.
        this.searchThrottled = searchThrottled;
    private final Version version;
    }
        new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES),
    public static final Setting<Integer> MAX_ANALYZED_OFFSET_SETTING = Setting.intSetting(
        scopedSettings.addSettingsUpdateConsumer(DEFAULT_PIPELINE, this::setDefaultPipeline);
    private volatile long mappingNestedFieldsLimit;
        return searchThrottled;
    public static final Setting<TimeValue> INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING = Setting.timeSetting(
        this.defaultFields = defaultFields;
        Property.IndexScope
     * first closes the chunk.
        return publishReferencedSegmentsInterval;
    public TimeValue getMaxFullFlushMergeWaitTime() {
                if (isTimeSeriesIndex) {
    public static final Setting<ByteSizeValue> INDEX_FLUSH_AFTER_MERGE_THRESHOLD_SIZE_SETTING = Setting.byteSizeSetting(
 * Licensed to Elasticsearch under one or more contributor
         * generation threshold. However, small thresholds are useful for testing so we
        maxAnalyzedOffset = scopedSettings.get(MAX_ANALYZED_OFFSET_SETTING);
            );
                    + " has unsupported policy specified: "
    public void setRemoteStoreEnabled(boolean isRemoteStoreEnabled) {
    public static final TimeValue DEFAULT_REMOTE_TRANSLOG_BUFFER_INTERVAL = new TimeValue(650, TimeUnit.MILLISECONDS);
            LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGED_DOCS_SETTING,
            tieredMergePolicyProvider::setDeletesPctAllowed
     * automatically rolled to a new generation when the current generation exceeds this generation
import org.opensearch.core.index.Index;
        return mappingDynamicPropertiesLuceneFieldLimit;
     */
        true,
        this.allowDerivedField = allowDerivedField;
        0,
     * Maximum number of indexing request retries in case LookupMapLockAcquisitionException is encountered for
        "index.remote_store.translog.keep_extra_gen",
     * Returns the number of extra operations (i.e. soft-deleted documents) to be kept for recoveries and history purpose.
    }
        scopedSettings.addSettingsUpdateConsumer(MAX_NGRAM_DIFF_SETTING, this::setMaxNgramDiff);
        );
        mappingTotalFieldsLimit = scopedSettings.get(INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING);
    private void setMappingNestedDocsLimit(long value) {
    private volatile String defaultSearchPipeline;
                    + " setting is disabled"
        return IndexMetadata.INDEX_DATA_PATH_SETTING.get(settings);
    public IndexSortConfig getIndexSortConfig() {
    /**
        1,
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        mergeOnFlushEnabled = scopedSettings.get(INDEX_MERGE_ON_FLUSH_ENABLED);
    }
        "index.max_slices_per_pit",
    private void setMappingNestedFieldsLimit(long value) {
    public boolean isFlushOnUncommittedSegmentsThresholdSizeExplicit() {
     * Index setting describing the maximum number of nested scopes in queries.
        this.logByteSizeMergePolicyProvider = new LogByteSizeMergePolicyProvider(logger, this);
        retentionLeaseMillis = scopedSettings.get(INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING).millis();
    }
        Setting.Property.IndexScope
    private void setEnableWarmer(boolean enableWarmer) {
        "index.translog.flush_threshold_size",
    }
        Setting.Property.IndexScope,
     */
        scopedSettings.addSettingsUpdateConsumer(INDEX_TRANSLOG_RETENTION_AGE_SETTING, this::setTranslogRetentionAge);
    /**
    /**
        this.maxTermsCount = maxTermsCount;
     */
 * It's created per index and available to all index level classes and allows them to retrieve
    private void setMaxTokenCount(int maxTokenCount) {
    private final boolean softDeleteEnabled;
        this.queryStringLenient = QUERY_STRING_LENIENT_SETTING.get(settings);
    private void setMaxRescoreWindow(int maxRescoreWindow) {
/*
    public String getDefaultSearchPipeline() {
    /**
        this.docIdFuzzySetFalsePositiveProbability = docIdFuzzySetFalsePositiveProbability;
    );
        return maxTokenCount;
        Property.NodeScope
    /**
    }
        Property.Dynamic,
    public static final Setting<Integer> MAX_DOCVALUE_FIELDS_SEARCH_SETTING = Setting.intSetting(
            IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING,
     */
    }
        scopedSettings.addSettingsUpdateConsumer(INDEX_WARMER_ENABLED_SETTING, this::setEnableWarmer);
    private void setTranslogRetentionAge(TimeValue age) {
                    "FeatureFlag " + CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG + " must be enabled to set this property to true"
        this.queryStringAllowLeadingWildcard = QUERY_STRING_ALLOW_LEADING_WILDCARD.get(nodeSettings);
     */
     */
     */
    private void setMaxRetryOnLookupMapAcquisitionException(int maxRetryOnLookupMapAcquisitionException) {
        TimeValue.timeValueHours(12),
        scopedSettings.addSettingsUpdateConsumer(INDEX_MAPPING_NESTED_FIELDS_LIMIT_SETTING, this::setMappingNestedFieldsLimit);
        Property.Dynamic,
     * Returns <code>true</code> if queries are allowed to define and use derived fields. The default is <code>true</code>
        15,
    private volatile int maxInnerResultWindow;
        Property.InternalIndex
    public void setRequiredPipeline(final String requiredPipeline) {
        Property.IndexScope
    /**
     * Returns the maximum allowed difference between max and min shingle_size
    /**
     */
        return flushThresholdSize;
    }
    }
     * The maximum number of slices allowed in a scroll request
     */
        this.maxNgramDiff = maxNgramDiff;
        scopedSettings.addSettingsUpdateConsumer(INDEX_MERGE_ON_FLUSH_MAX_FULL_FLUSH_MERGE_WAIT_TIME, this::setMaxFullFlushMergeWaitTime);
     * documents) on the grounds that a file-based peer recovery may copy all of the documents in the shard over to the new peer, but is
     */
    /**
    );
    public boolean isCompositeIndex() {
            tieredMergePolicyProvider::setFloorSegmentSetting
        maxDocvalueFields = scopedSettings.get(MAX_DOCVALUE_FIELDS_SEARCH_SETTING);
        Property.Dynamic,
        DEFAULT_POLICY,
     */
    public static final Setting<ByteSizeValue> INDEX_TRANSLOG_RETENTION_SIZE_SETTING = Setting.byteSizeSetting(
        "index.searchable_snapshot.snapshot_id.uuid",
        scopedSettings.addSettingsUpdateConsumer(
        scopedSettings.addSettingsUpdateConsumer(
        this.searchIdleAfter = searchIdleAfter;
    }
 * Unless required by applicable law or agreed to in writing,
        "index.max_result_window",
    );
 *
    private volatile int maxTokenCount;
            case TIERED:
                case CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_BALANCED:
        return Optional.ofNullable(mergeOnFlushPolicy);
            switch (value) {
        isTranslogMetadataEnabled = RemoteStoreUtils.determineTranslogMetadataEnabled(indexMetadata);
    /**
        return mappingNestedFieldsLimit;
         * However, small thresholds are useful for testing so we do not add a large lower bound here.
     */
    public boolean isDerivedSourceEnabled() {
        Property.PrivateIndex,
        return defaultFields;
            tieredMergePolicyProvider::setExpungeDeletesAllowed
     *
        if (this.isRemoteStoreEnabled) {
        IndexMergePolicy indexMergePolicy = IndexMergePolicy.fromString(indexScopedPolicy);
        Property.IndexScope
        Property.Dynamic,
    /**
        "index.translog.retention.size",
     * continuously; this condition restores an equivalent size-based flush signal driven by uncommitted segment bytes.
        } else {
            this::setPublishReferencedSegmentsInterval
    public static final Setting<TimeValue> INDEX_MERGE_ON_FLUSH_MAX_FULL_FLUSH_MERGE_WAIT_TIME = Setting.timeSetting(
    private volatile int maxAdjacencyMatrixFilters;
    }
        Property.IndexScope
    }
     * the transaction log is fsyncing on every operations
    public boolean isRemoteTranslogBufferIntervalExplicit() {
     * script fields is a costly operation.
     * A setting describing the maximum number of characters that will be analyzed for a highlight request.
    private final boolean queryStringLenient;
        this.mappingFieldNameLengthLimit = value;
     * settings that are specified on both index and node level are overwritten by the index settings.
            && scopedSettings.get(PLUGGABLE_DATAFORMAT_ENABLED_SETTING);
        new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES),
     * translog operations. Stale operation trimming (via
import org.opensearch.common.unit.TimeValue;
import org.opensearch.core.common.Strings;
    public int getMaxResultWindow() {
    }
    }
    public boolean isDefaultAllowUnmappedFields() {
import java.util.function.UnaryOperator;
        CONCURRENT_SEGMENT_SEARCH_MIN_SLICE_COUNT_VALUE,
        scopedSettings.addSettingsUpdateConsumer(MAX_SCRIPT_FIELDS_SETTING, this::setMaxScriptFields);
        scopedSettings.addSettingsUpdateConsumer(
            DEFAULT_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE,
     */
    private volatile int maxRescoreWindow;
    );
     * Returns true if unreferenced files should be cleaned up on merge failure for this index.
    private void setFlushAfterMergeThresholdSize(ByteSizeValue byteSizeValue) {
    }
        Property.Dynamic,
    /**
        defaultFields = scopedSettings.get(DEFAULT_FIELD_SETTING);
        return indexMetadata;
        return settings;
    /**
     * counterpart: a zero or negative threshold would flush on every successful segments sync, and disablement has its
    /**
     **/
        false,
     * When enabled on a remote-backed index using segment replication and a remote translog, the primary bulk path
        "index.soft_deletes.retention_lease.period",
    private volatile Settings settings;
        mappingDepthLimit = scopedSettings.get(INDEX_MAPPING_DEPTH_LIMIT_SETTING);
                    throw new IllegalArgumentException("Setting value must be one of [segment, balanced, force]");
    }
     * Whether an eligible remote-backed segment-replication engine should batch successful primary index operations.
            throw new IllegalArgumentException(
        isRemoteStoreEnabled = settings.getAsBoolean(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false);
        return maxSlicesPerPit;
     * <p>
     */
        value -> {
        );
     * Returns <code>true</code> if translog read-forward is enabled.
    public static final Setting<TimeValue> INDEX_GC_DELETES_SETTING = Setting.timeSetting(
        return remoteTranslogKeepExtraGen;
        }
            throw new IllegalArgumentException(
    public static final Setting<TimeValue> INDEX_REFRESH_INTERVAL_SETTING = Setting.timeSetting(
    }
        CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_SEGMENT,
            + "are part of setting definition";
    public boolean isDerivedFieldAllowed() {
     */
    public boolean isRemoteStoreFencingEnabled() {
        scopedSettings.addSettingsUpdateConsumer(INDEX_MERGE_ON_FLUSH_POLICY, this::setMergeOnFlushPolicy);
        return translogReadForward;
     * This setting is only applicable when highlighting is requested on a text that was indexed without
        Property.PrivateIndex,
    /**
    );
     */
            tieredMergePolicyProvider::setMaxMergedSegment
        return contextAwareEnabled && FeatureFlags.isEnabled(CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_SETTING);
        this.shouldCleanupUnreferencedFiles = INDEX_UNREFERENCED_FILE_CLEANUP.get(settings);
        );
     */
        1000,
        derivedSourceEnabledForTranslog = scopedSettings.get(INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING);
            }
    );
            this::setTranslogBatchAppendMaxOperations
     * Returns the maximum number of translog files that no longer required for persistence should be kept for peer recovery
import org.opensearch.common.settings.Setting.Property;
        this.maxDocvalueFields = maxDocvalueFields;
    public static final Setting<Boolean> INDEX_DOC_ID_FUZZY_SET_ENABLED_SETTING = Setting.boolSetting(
     * N filters is (N*N)/2 so a limit of 100 filters is imposed by default.
    }
    private void setTranslogBatchAppendMaxSize(ByteSizeValue maxSize) {
        final Settings newIndexSettings = Settings.builder().put(nodeSettings).put(newSettings).build();
    }
    }
    }
        logger = Loggers.getLogger(getClass(), index);
    public boolean shouldCleanupUnreferencedFiles() {
    public static final String CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_BALANCED = "balanced";
        }
     * (for example, during a primary failover with network isolation that leaves stale operations untrimmed)
        0,
    public static final Setting<String> INDEX_MERGE_ON_FLUSH_POLICY = Setting.simpleString(
    );
     * This is a safeguard making sure that the translog deletion policy won't keep too many translog files especially when they're small.
import org.apache.lucene.sandbox.index.MergeOnFlushMergePolicy;
        Property.IndexScope
        this.remoteStoreSegmentPathPrefix = (rawPrefix != null && !rawPrefix.trim().isEmpty()) ? rawPrefix : null;
        Property.IndexScope
        return translogRetentionAge;
    );
        return left.filter(IndexScopedSettings.INDEX_SETTINGS_KEY_PREDICATE)
     */
        },
        "index.soft_deletes.retention.operations",
            }
     * context aware indexes.
                "The "
    public static final Setting<TimeValue> INDEX_PERIODIC_FLUSH_INTERVAL_SETTING = Setting.timeSetting(
        return this.maxDocvalueFields;
 *
    public static final Setting<Integer> MAX_REFRESH_LISTENERS_PER_SHARD = Setting.intSetting(
    public int getMaxAdjacencyMatrixFilters() {
        false,
    );
     * @return boolean
        false,
            this.translogRetentionAge = TimeValue.MINUS_ONE;
        "index.translog.batch_append.max_size",
     */
import static org.opensearch.index.mapper.MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING;
        Property.Deprecated
    /**
import org.opensearch.common.annotation.PublicApi;
        return INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING.exists(settings);
     *
    }
     */
        MINIMUM_REFRESH_INTERVAL,
    public TimeValue getRemoteTranslogUploadBufferInterval() {
    public static final Setting<ByteSizeValue> INDEX_TRANSLOG_GENERATION_THRESHOLD_SIZE_SETTING = Setting.byteSizeSetting(
    private volatile int translogBatchAppendMaxOperations;
     */
    }
     * Only takes effect while the condition is enabled cluster-wide by
    public boolean isTranslogReadForward() {
    }
     */
     * flushing indexing buffers to disk. This is an experimental Apache Lucene feature.
        if (newUUID.equals(getUUID()) == false) {
    public int getMaxRescoreWindow() {
            this::setDocIdFuzzySetFalsePositiveProbability
        "index.warmer.enabled",
        }
     * Returns the index sort config that should be used for this index.
    public static final Setting<Integer> MAX_RESCORE_WINDOW_SETTING = Setting.intSetting(
        nodeName = Node.NODE_NAME_SETTING.get(settings);
    }
        Property.IndexScope,
        Property.Dynamic,
    public static final Setting<Boolean> INDEX_SEARCH_THROTTLED = Setting.boolSetting(
     * Index setting describing the maximum value of from + size on an individual inner hit definition or
    /**
 * GitHub history for details.
        remoteStoreRepository = settings.get(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY);
        10000,
    /**
    );
    }
    }
        maxRegexLength = scopedSettings.get(MAX_REGEX_LENGTH_SETTING);
    }
        Property.IndexScope
    /**
     * If this time is reached, we proceed with the commit based on segments merged up to that point. The merges are not
     * or {@link org.apache.lucene.index.IndexWriter#getReader(boolean, boolean)}) returned by MergePolicy.findFullFlushMerges(...).
     * Returns the index this settings object belongs to
    public long getMappingNestedFieldsLimit() {
    /**
        return INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.exists(settings);
     * The maximum number of slices allowed in a scroll request.
        settings -> shouldDisableTranslogRetention(settings) ? "-1" : "512MB",
    }
        Property.Dynamic,
        scopedSettings.addSettingsUpdateConsumer(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING, this::setRemoteStoreEnabled);
                return s;
    );
    /**
        scopedSettings.addSettingsUpdateConsumer(
    }
        return ReplicationType.SEGMENT.equals(replicationType) && !isRemoteStoreEnabled();
        return generationThresholdSize;
        return enableFuzzySetForDocId;
 * this work for additional information regarding copyright
            LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGE_SEGMENT_FOR_FORCED_MERGE_SETTING,
    );
        "index.max_ngram_diff",
     * for each additional term, and a large number of terms degrade the cluster performance.
        MAX_RESULT_WINDOW_SETTING,
     * setting has changed.
        settings -> shouldDisableTranslogRetention(settings) ? TimeValue.MINUS_ONE : TimeValue.timeValueHours(12),
        /* There was unintentional breaking change got introduced with [OpenSearch-6424](https://github.com/opensearch-project/OpenSearch/pull/6424) (version 2.7).
        "index.merge.policy",
        streamingAggregationMinSegmentSize = scopedSettings.get(FlushModeResolver.STREAMING_AGGREGATION_MIN_SEGMENT_SIZE_SETTING);
    }
        }
                case CONCURRENT_SEGMENT_SEARCH_MODE_NONE:
        TimeValue.timeValueMinutes(10),
                return TimeValue.timeValueMinutes(10);
        this.remoteStoreTranslogRepository = remoteStoreTranslogRepository;
     */
        Property.IndexScope,
        this.shouldCleanupUnreferencedFiles = shouldCleanupUnreferencedFiles;
        TIERED("tiered"),
     */
        scopedSettings.addSettingsUpdateConsumer(
            if (FeatureFlags.isEnabled(CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG) == false && value == true) {
        "index.remote_store.translog.buffer_interval",
        this.remoteTranslogKeepExtraGen = INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.get(settings);
     * growing too large to avoid excessive disk space consumption. Therefore, the translog is
     * @deprecated This setting will be removed in 8.0
     * Creates a new {@link IndexSettings} instance. The given node settings will be merged with the settings in the metadata
        "index.max_shingle_diff",
        maxSlicesPerPit = scopedSettings.get(MAX_SLICES_PER_PIT);
     * significantly faster than replaying the missing operations on the peer, so once a peer falls far enough behind the primary it makes
    }
        }
        isWarmIndex = settings.getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false);
        0,
            "index.remote_store.flush_on_uncommitted_segments.threshold_size",
     * If soft-deletes is enabled, an engine by default will retain all operations up to the global checkpoint.
    }
        this.maxAdjacencyMatrixFilters = maxAdjacencyFilters;
    );
    public void setRemoteStoreTranslogRepository(String remoteStoreTranslogRepository) {
        replicationType = IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(settings);
    public IndexMetadata getIndexMetadata() {
            INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING
    );
    }
    }
        this.flushOnUncommittedSegmentsThresholdSize = flushOnUncommittedSegmentsThresholdSize;
                            break;
    public static final ByteSizeValue DEFAULT_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE = new ByteSizeValue(512, ByteSizeUnit.MB);
     */
        Property.IndexScope,
        this.warmerEnabled = enableWarmer;
        return indexSortConfig;
    public ByteSizeValue getTranslogBatchAppendMaxSize() {
    }
    }
        Property.Dynamic,
    );
        "index.query.default_field",
    /**
        return translogBatchAppendEnabled;
        assert softDeleteEnabled || version.before(Version.V_2_0_0) : "soft deletes must be enabled in version " + version;
        3,
            case "false":
        return pluggableDataFormatEnabled;
        new TimeValue(10, TimeUnit.SECONDS),
    );
    private volatile ByteSizeValue flushOnUncommittedSegmentsThresholdSize;
        TimeValue.ZERO,
        Property.Dynamic,
            LogByteSizeMergePolicyProvider.INDEX_LBS_NO_CFS_RATIO_SETTING,
        pluggableDataFormatEnabled = FeatureFlags.isEnabled(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        false,
        1000,
    /**
     * @deprecated This setting will be removed in 8.0
        );
import org.opensearch.search.pipeline.SearchPipelineService;
    private volatile TimeValue searchIdleAfter;
        new ByteSizeValue(1, ByteSizeUnit.MB),
        maxShingleDiff = scopedSettings.get(MAX_SHINGLE_DIFF_SETTING);
    }
                    + ". Please use one of: "
    // For warm index we would partially store files in local.
     * Returns <code>true</code> if the index has a custom data path
     * words is explicitly set, in which case it overrides the cluster default.
    public int getMaxNgramDiff() {
                    + DEFAULT_POLICY
    }
 * The OpenSearch Contributors require contributions made to
    private final String nodeName;
    /**
    }
    }
        tieredMergePolicyProvider.setDefaultMaxMergesAtOnce(newDefaultMaxMergesAtOnce);
        Property.IndexScope
            this::setMappingDynamicPropertiesLuceneFieldLimit
        Setting.Property.IndexScope
            MINIMUM_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE,
        DEFAULT_POLICY(IndexSettings.DEFAULT_POLICY);
