        setDocIdFuzzySetFalsePositiveProbability(scopedSettings.get(INDEX_DOC_ID_FUZZY_SET_FALSE_POSITIVE_PROBABILITY_SETTING));  
                    break;  
    }
    private volatile String requiredPipeline;
     * or {@link org.apache.lucene.index.IndexWriter#getReader(boolean, boolean)}) returned by MergePolicy.findFullFlushMerges(...).
        this.indexSortConfig = new IndexSortConfig(this);
        scopedSettings.addSettingsUpdateConsumer(
        scopedSettings.addSettingsUpdateConsumer(  
        return enableFuzzySetForDocId;
     */
    );
        "index.query.max_nested_depth",
        return indexMetadata.isRemoteSnapshot();
    }
import org.opensearch.common.util.FeatureFlags;  
     * The minimum total size of segment bytes not yet referenced by the last commit point which triggers a flush on a
    public boolean isQueryStringAllowLeadingWildcard() {
    /**
        scopedSettings.addSettingsUpdateConsumer(INDEX_UNREFERENCED_FILE_CLEANUP, this::setShouldCleanupUnreferencedFiles);
import org.opensearch.common.settings.IndexScopedSettings;
    public static final Setting<Integer> MAX_ADJACENCY_MATRIX_FILTERS_SETTING = Setting.intSetting(
    public static final Setting<Integer> INDEX_TRANSLOG_RETENTION_TOTAL_FILES_SETTING = Setting.intSetting(
    /**  
    /**  
     * The maximum number of slices allowed in a scroll request.
        this.generationThresholdSize = generationThresholdSize;  
        "index.translog.read_forward",  
        scopedSettings.addSettingsUpdateConsumer(MAX_NESTED_QUERY_DEPTH_SETTING, this::setMaxNestedQueryDepth);  
            throw new IllegalArgumentException(
    );
        return this.autoForcemergeEnabled;
import java.util.Arrays;
    public boolean isEnableFuzzySetForDocId() {
    /**
     */
     * proper index setting during the migration.  
        return assignedOnRemoteNode;
     */
            LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGE_SEGMENT_FOR_FORCED_MERGE_SETTING,  
    public static final Setting<Integer> MAX_SLICES_PER_SCROLL = Setting.intSetting(  
    public static final TimeValue DEFAULT_PERIODIC_FLUSH_INTERVAL = TimeValue.MINUS_ONE;  
     *  
        );
        Property.IndexScope
        this.maxTermsCount = maxTermsCount;
     * When enabled on a remote-backed index using segment replication and a remote translog, the primary bulk path  
        "index.unreferenced_file_cleanup.enabled",  
        this.autoForcemergeEnabled = scopedSettings.get(INDEX_AUTO_FORCE_MERGES_ENABLED);  
     */
        return isWarmIndex;
                    + ". Please use one of: "  
            TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING,
    }
        if (this.isRemoteStoreEnabled) {  
 * software distributed under the License is distributed on an
    }  
        );
        public static IndexMergePolicy fromString(String text) {  
     * The default maximum of 1M characters is defensive as for highlighting larger texts,
    }
        this.settings = Settings.builder().put(nodeSettings).put(indexMetadata.getSettings()).build();
        this.settings = newIndexSettings;  
    );
    /**  
        scopedSettings.addSettingsUpdateConsumer(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING, this::setRemoteStoreEnabled);
        private final String value;
    private volatile int maxRefreshListeners;  
        Property.Dynamic,
    );  
 *
     * aborted, and will still run to completion independent of the commit or getReader call, like natural segment merges.  
        Property.IndexScope,  
        Property.Dynamic
     */
    /**  
package org.opensearch.index;
    }  
    }
 * a settings consumer at index creation via {@link IndexModule#addSettingsUpdateConsumer(Setting, Consumer)} that will
    /**
    /**
    public static final Setting<String> DEFAULT_SEARCH_PIPELINE = new Setting<>(
    public static final Setting<Boolean> QUERY_STRING_ANALYZE_WILDCARD = Setting.boolSetting(  
     * min_gram (minimum length of characters in a gram).
     * threshold size.  
    public void setRemoteStoreEnabled(boolean isRemoteStoreEnabled) {
    }
    public int getMaxRescoreWindow() {
    public void setRequiredPipeline(final String requiredPipeline) {  
    }
import static org.opensearch.index.mapper.MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING;
     */
     * translog operations. Stale operation trimming (via
        return this.maxTermsCount;  
     * The maximum age of a retention lease before it is considered expired.
     * appends successful primary index operations in bounded batches instead of one write per operation. Local-store
    /**  
                case CONCURRENT_SEGMENT_SEARCH_MODE_ALL:
    }
    }  
                    + ". Please use one of: "
        Property.Dynamic,  
        this.queryStringAnalyzeWildcard = QUERY_STRING_ANALYZE_WILDCARD.get(nodeSettings);
     * @param left  the left settings
    public int getMaxTermsCount() {
        return mergeOnFlushEnabled;
    public static final Setting<Integer> MAX_TERMS_COUNT_SETTING = Setting.intSetting(  
    }
     *
        "index.merge_on_flush.max_full_flush_merge_wait_time",  
     *  
                    + IndexSettings.INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING.getKey()
        return translogRetentionSize;
        return scopedSettings;
    }
    public int getNumberOfReplicas() {  
        return remoteTranslogUploadBufferInterval;
        Property.Dynamic,
        "index.soft_deletes.retention_lease.period",  
        1000,  
import java.util.function.UnaryOperator;
        String rawPrefix = IndexMetadata.INDEX_REMOTE_STORE_SEGMENT_PATH_PREFIX.get(settings);
     */
     * Returns true if this is remote/searchable snapshot
    }
    );  
     */
     * Returns the interval at which a periodic flush should be executed. {@code -1} means periodic flush is disabled.  
    public boolean isSegRepLocalEnabled() {  
        }  
     */
         * Now this sortField (IndexSort) is stored in SegmentInfo and we need to maintain backward compatibility for them.  
        "index.derived_source.translog.enabled",
        "index.searchable_snapshot.repository",
        "index.searchable_snapshot.shard_path_type",
                        case LOG_BYTE_SIZE:
        mappingDepthLimit = scopedSettings.get(INDEX_MAPPING_DEPTH_LIMIT_SETTING);  
    /**  
    );
        Property.Dynamic,
        remoteStorePathStrategy = RemoteStoreUtils.determineRemoteStorePathStrategy(indexMetadata);
        scopedSettings.addSettingsUpdateConsumer(MAX_RESULT_WINDOW_SETTING, this::setMaxResultWindow);  
        "index.max_terms_count",
        DEFAULT_POLICY(IndexSettings.DEFAULT_POLICY);  
    private volatile String remoteStoreSegmentPathPrefix;
    public int getHighlightMaxAnalyzedOffset() {  
     */  
        );
 * the Apache License, Version 2.0 (the "License"); you may
     * flushing indexing buffers to disk. This is an experimental Apache Lucene feature.  
    /**
        return mappingNestedFieldsLimit;
     * documents increases the chance of operation-based recoveries and allows querying a longer history of documents.
        isWarmIndex = settings.getAsBoolean(IndexModule.IS_WARM_INDEX_SETTING.getKey(), false);
     * Returns <code>true</code> if query string parsing should be lenient. The default is <code>false</code>
        true,
                            break;
        "index.max_rescore_window",  
        TimeValue.MINUS_ONE,
        gcDeletesInMillis = scopedSettings.get(INDEX_GC_DELETES_SETTING).getMillis();
    private static boolean shouldDisableTranslogRetention(Settings settings) {  
     */  
                            break;
     * Returns true if the index is writable warm index and has partial store locality.
        "index.max_result_window",
    /**
            );  
            value -> mergeSchedulerConfig.updateMaxForceMergeMBPerSec(this)
     * Sets it to default maxMergesAtOnce if index level settings is being removed
        scopedSettings.addSettingsUpdateConsumer(MAX_RESCORE_WINDOW_SETTING, this::setMaxRescoreWindow);  
        Property.IndexScope
        return derivedSourceEnabled;
        return INDEX_TRANSLOG_RETENTION_TOTAL_FILES_SETTING.get(getSettings());  
    private volatile boolean shouldCleanupUnreferencedFiles;
        Property.IndexScope
        return this.maxNgramDiff;  
        Property.IndexScope
    }
    /**  
     * @return the maximum age  
        return ReplicationType.SEGMENT.equals(replicationType) && !isRemoteStoreEnabled();
    }
        Setting.Property.IndexScope
            LogByteSizeMergePolicyProvider.INDEX_LBS_NO_CFS_RATIO_SETTING,
    }  
        "index.pluggable.dataformat",
     * growing too large to avoid excessive disk space consumption. Therefore, the translog is
     * The default maximum of 20. 1 means once nesting.
     * @return the generation threshold size
    /**  
        );
        100_000,  
         * An empty translog occupies 55 bytes on disk. If the generation threshold is
        this.maxResultWindow = maxResultWindow;
    );
                case CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_SEGMENT:  
    private void setFlushAfterMergeThresholdSize(ByteSizeValue byteSizeValue) {
        mergeSchedulerConfig.setDefaultMaxThreadAndMergeCount(maxThreadCount, maxMergeCount, overrideExistingConfigs);  
        );  
     */
        return ReplicationType.SEGMENT.equals(replicationType) || isAssignedOnRemoteNode();  
        Property.IndexScope
     */  
    /**
        "index.max_inner_result_window",
    private volatile List<String> defaultFields;
     * Maximum number of indexing request retries in case LookupMapLockAcquisitionException is encountered for
    /**  
    }
        this.shouldCleanupUnreferencedFiles = INDEX_UNREFERENCED_FILE_CLEANUP.get(settings);
        this.translogBatchAppendEnabled = enabled;
     * Deliberately the same as the default of {@link #INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING}, since this  
    }  
    }  
        this(indexMetadata, nodeSettings, IndexScopedSettings.DEFAULT_SCOPED_SETTINGS);
    );
        // Only set the prefix if it's explicitly set and not empty
        );  
 *    http://www.apache.org/licenses/LICENSE-2.0
            tieredMergePolicyProvider.setMaxMergesAtOnce(  
    /**
        Property.InternalIndex
    public boolean isSegRepEnabledOrRemoteNode() {
    );
            case TIERED:  
        Property.IndexScope,
    private final boolean softDeleteEnabled;  
    /**
     */
     */  
        Function.identity(),
     * The maximum number of slices allowed in a PIT request.  
            FlushModeResolver.STREAMING_AGGREGATION_MIN_SEGMENT_SIZE_SETTING,
import java.util.function.Function;  
     * Index setting describing the maximum value of allowed `script_fields`that can be retrieved  
    );  
    public static final TimeValue DEFAULT_REFRESH_INTERVAL = new TimeValue(1, TimeUnit.SECONDS);
        Property.IndexScope
@PublicApi(since = "1.0.0")
        Property.Deprecated
    private volatile UnaryOperator<MergePolicy> mergeOnFlushPolicy;
            LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGE_SEGMENT_SETTING,
    public long getMappingNestedDocsLimit() {  
        scopedSettings.addSettingsUpdateConsumer(MAX_SLICES_PER_PIT, this::setMaxSlicesPerPit);
    }
        true,
    }
     * Minimum accepted value for {@link #DEFAULT_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE} and its cluster
    );
        Property.IndexScope  
     */
    /**
        false,  
        return retentionLeaseMillis;  
     * This setting is intentionally not registered, it is only used in tests
        if (newUUID.equals(getUUID()) == false) {
        "index.derived_source.enabled",
        return this.derivedSourceEnabledForTranslog;  
    public String customDataPath() {
                    + text
    }
        "index.max_refresh_listeners",
        scopedSettings.addSettingsUpdateConsumer(INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING, this::setSoftDeleteRetentionOperations);  
     * A setting describing the maximum number of tokens that can be
    private void setSearchIdleAfter(TimeValue searchIdleAfter) {
        scopedSettings.addSettingsUpdateConsumer(MAX_NGRAM_DIFF_SETTING, this::setMaxNgramDiff);
     */
        1000,  
        nodeName = Node.NODE_NAME_SETTING.get(settings);  
    }  
    );
            INDEX_MAX_RETRY_ON_LOOKUP_MAP_LOCK_ACQUISITION_EXCEPTION,  
    );
        scopedSettings.addSettingsUpdateConsumer(
    private void setRefreshInterval(TimeValue timeValue) {
     */
     */
        "index.optimize_doc_id_lookup.fuzzy_set.enabled",  
    private void setAllowDerivedField(boolean allowDerivedField) {
     */  
        Property.Dynamic,
        1,
        return this.maxFullFlushMergeWaitTime;
        return defaultPipeline;
    private void setMaxSlicesPerPit(int value) {  
        checkPendingFlushEnabled = scopedSettings.get(INDEX_CHECK_PENDING_FLUSH_ENABLED);  
        return maxSlicesPerScroll;
     */
        scopedSettings.addSettingsUpdateConsumer(INDEX_FLUSH_AFTER_MERGE_THRESHOLD_SIZE_SETTING, this::setFlushAfterMergeThresholdSize);  
    private void setHighlightMaxAnalyzedOffset(int maxAnalyzedOffset) {
     * @deprecated Experimental feature has been removed. Do not use.  
        IndexMergePolicy indexMergePolicy = IndexMergePolicy.fromString(indexScopedPolicy);
        isRemoteStoreFencingEnabled = settings.getAsBoolean(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, false);
        this.remoteTranslogUploadBufferInterval = remoteTranslogUploadBufferInterval;
        "index.translog.sync_interval",  
            this.translogRetentionAge = age;
            );
    public static final Setting<Integer> MAX_REGEX_LENGTH_SETTING = Setting.intSetting(
    public boolean isPluggableDataFormatEnabled() {
     * Returns this index's {@code index.remote_store.flush_on_uncommitted_segments.threshold_size}. Only meaningful  
    public boolean isRemoteStoreFencingEnabled() {
     * Returns the settings for this index. These settings contain the node and index level settings where
        Property.Dynamic,  
    public static final Setting<Boolean> INDEX_CHECK_PENDING_FLUSH_ENABLED = Setting.boolSetting(
    public static final Setting<Long> INDEX_CONTEXT_CURRENT_VERSION = Setting.longSetting(  
    public static final Setting<Integer> INDEX_TRANSLOG_BATCH_APPEND_MAX_OPERATIONS_SETTING = Setting.intSetting(
    public static final TimeValue MINIMUM_PERIODIC_FLUSH_INTERVAL = TimeValue.MINUS_ONE;
        return left.filter(IndexScopedSettings.INDEX_SETTINGS_KEY_PREDICATE)  
    );
        Property.Dynamic,
        0,  
                return TimeValue.timeValueMinutes(10);
     */
        Property.IndexScope
     * cluster setting it falls back to, {@code cluster.remote_store.flush_on_uncommitted_segments.threshold_size}.
    private void setRetentionLeaseMillis(final TimeValue retentionLease) {  
    }
        mappingNestedFieldsLimit = scopedSettings.get(INDEX_MAPPING_NESTED_FIELDS_LIMIT_SETTING);  
        0,
     * Index setting describing the maximum value of allowed `docvalue_fields`that can be retrieved
        );
    /**
    public static final ByteSizeValue MINIMUM_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE = new ByteSizeValue(1, ByteSizeUnit.BYTES);
            INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING,
     */  
     */
    public boolean isMergeOnFlushEnabled() {
     * @param isTimeSeriesIndex true if index contains @timestamp field
     * Updates the maxMergesAtOnce for actual TieredMergePolicy used by the engine.
    /**
        return translogReadForward;  
    public static final Setting<String> FINAL_PIPELINE = new Setting<>(
    }  
    private volatile long mappingDynamicPropertiesLuceneFieldLimit;
    void setDefaultMaxThreadAndMergeCount(int maxThreadCount, int maxMergeCount) {
            LogByteSizeMergePolicyProvider.INDEX_LBS_MAX_MERGED_DOCS_SETTING,
    private void setMappingFieldNameLengthLimit(long value) {
        "index.translog.batch_append.max_size",
        Property.IndexScope
        this.maxSlicesPerScroll = value;
        Property.IndexScope  
        scopedSettings.addSettingsUpdateConsumer(MAX_SHINGLE_DIFF_SETTING, this::setMaxShingleDiff);
    }  
        this.maxScriptFields = maxScriptFields;
            mergeSchedulerConfig::setMaxThreadAndMergeCount
        scopedSettings.addSettingsUpdateConsumer(INDEX_DOC_ID_FUZZY_SET_ENABLED_SETTING, this::setEnableFuzzySetForDocId);
    );  
    );  
        "index.final_pipeline",  
    /**  
     */
        Property.IndexScope,
    }
    /**
                "The "
    private volatile ByteSizeValue translogBatchAppendMaxSize;
        return mappingDepthLimit;
    public int getMaxResultWindow() {  
        (value) -> Translog.Durability.valueOf(value.toUpperCase(Locale.ROOT)),
        this.nodeSettings = nodeSettings;
    public static final Setting<TimeValue> INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING = Setting.timeSetting(
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
            // Default to 10 minutes for pull-based ingestion indices, disabled otherwise
        "indices.time_series_index.default_index_merge_policy",  
        return docIdFuzzySetFalsePositiveProbability;
            this.mergeOnFlushPolicy = MergeOnFlushMergePolicy::new;  
        );
        Property.Dynamic,
     * Creates a new {@link IndexSettings} instance. The given node settings will be merged with the settings in the metadata
    public int getMaxInnerResultWindow() {
    /**  
    /**
        true,  
     * Returns the time that an index shard becomes search idle unless it's accessed in between  
        this.requiredPipeline = requiredPipeline;
     * all other indexes default to {@link TieredMergePolicyProvider}.  
    public long getGcDeletesInMillis() {
import org.apache.lucene.sandbox.index.MergeOnFlushMergePolicy;
     * while index level settings will overwrite node settings.  
    }
        3,
/**
     * The max amount of time to wait for merges
    public boolean isCheckPendingFlushEnabled() {  
     * Creates a new {@link IndexSettings} instance. The given node settings will be merged with the settings in the metadata  
    public boolean isAutoForcemergeEnabled() {  
     * finalization phase. If a replica fails before completing
public final class IndexSettings {
    public static final String CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_FORCE = "force";
        mergeOnFlushEnabled = scopedSettings.get(INDEX_MERGE_ON_FLUSH_ENABLED);
     * words is explicitly set, in which case it overrides the cluster default.
        scopedSettings.addSettingsUpdateConsumer(INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING, this::setRemoteTranslogKeepExtraGen);
    /**
                case CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_FORCE:
    /**
        flushOnUncommittedSegmentsThresholdSize = scopedSettings.get(
        this.derivedSourceEnabledForTranslog = isDerivedSourceEnabledForTranslog;
    }  
     * continuously; this condition restores an equivalent size-based flush signal driven by uncommitted segment bytes.
     */
        new ByteSizeValue(4, ByteSizeUnit.KB),
     * N filters is (N*N)/2 so a limit of 100 filters is imposed by default.  
    }
        scopedSettings.addSettingsUpdateConsumer(MAX_SCRIPT_FIELDS_SETTING, this::setMaxScriptFields);
     * {@link org.opensearch.index.shard.IndexShard#trimOperationOfPreviousPrimaryTerms(long)}) occurs during the recovery  
        );
        if (TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.exists(updatedSettings) == false) {
        scopedSettings.addSettingsUpdateConsumer(
    public int getNumberOfShards() {
    /**
        this.flushThresholdSize = byteSizeValue;
    );  
        this.index = indexMetadata.getIndex();  
        },
    public Index getIndex() {
    }
     * @return the buffer interval.
    private volatile int maxSlicesPerPit;
     * will be kept around before being deleted. Keeping more files is useful to increase
        scopedSettings.addSettingsUpdateConsumer(DEFAULT_SEARCH_PIPELINE, this::setDefaultSearchPipeline);
    /**  
    }
     * <p>  
            }
    }, Property.IndexScope);
            this::updateMaxMergesAtOnce,
        true,
/*
    public static final Setting<Boolean> QUERY_STRING_LENIENT_SETTING = Setting.boolSetting(
    }  
     */
    );
        this.tieredMergePolicyProvider = new TieredMergePolicyProvider(logger, this);
    @Deprecated  
        return this.maxDocvalueFields;
    }
     */  
        Property.Dynamic  
     * max_gram (maximum length of characters in a gram) and
    public static final Setting<Boolean> INDEX_SOFT_DELETES_SETTING = Setting.boolSetting(
     * Expert: sets the amount of time to wait for merges (during {@link org.apache.lucene.index.IndexWriter#commit}  
            // ignore the translog retention settings if soft-deletes enabled
    }
    public long getRetentionLeaseMillis() {
                "version mismatch on settings update expected: " + version + " but was: " + IndexMetadata.indexCreated(newSettings)
     * The maximum number of refresh listeners allows on this shard.
 * The OpenSearch Contributors require contributions made to  
    private void setPeriodicFlushInterval(TimeValue timeValue) {
     * counterpart: a zero or negative threshold would flush on every successful segments sync, and disablement has its
            LogByteSizeMergePolicyProvider.INDEX_LBS_MERGE_POLICY_MERGE_FACTOR_SETTING,  
        new ByteSizeValue(0, ByteSizeUnit.BYTES), // always flush after merge
    }
        remoteTranslogUploadBufferInterval = INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.get(settings);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
        return this.maxShingleDiff;
        "index.translog.generation_threshold_size",
    }  
    public String getNodeName() {  
     */
    public static final Setting<Boolean> INDEX_TRANSLOG_BATCH_APPEND_ENABLED_SETTING = Setting.boolSetting(
                        case TIERED:
     * The minimum size of a merge that triggers a flush in order to free resources
    public ByteSizeValue getFlushOnUncommittedSegmentsThresholdSize() {
    /**
        Property.IndexScope
    );
    /**
            this.translogRetentionSize = byteSizeValue;
    private volatile long mappingNestedFieldsLimit;
     * Denotes whether this is a composite index i.e star-tree index etc  
    public enum IndexMergePolicy {  
        new ByteSizeValue(64, ByteSizeUnit.MB),
        maxSlicesPerPit = scopedSettings.get(MAX_SLICES_PER_PIT);
     * ({@code index.translog.flush_threshold_size}) is ineffective because uploaded translog generations are trimmed
    public String getRemoteStoreTranslogRepository() {
    }
        TimeValue.timeValueMinutes(0),  
        "index.check_pending_flush.enabled",  
 * under the License.  
    }
        Property.Dynamic,  
                break;
     */
    /**
        maxNgramDiff = scopedSettings.get(MAX_NGRAM_DIFF_SETTING);
        }
    public static final Setting<Integer> MAX_TOKEN_COUNT_SETTING = Setting.intSetting(
    /**
        "index.query.default_field",
        Property.Dynamic,
        "index.context_aware.enabled",  
        Property.Dynamic,
        Property.IndexScope  
            case LOG_BYTE_SIZE:  
        scopedSettings.addSettingsUpdateConsumer(MAX_TERMS_COUNT_SETTING, this::setMaxTermsCount);
        true,  
        return streamingAggregationMinSegmentSize;
    private void setSearchThrottled(boolean searchThrottled) {
    public static final TimeValue MINIMUM_REMOTE_TRANSLOG_BUFFER_INTERVAL = TimeValue.ZERO;
     * and there are duplicates of the same translog operations with different primary terms in the translog  
        scopedSettings.addSettingsUpdateConsumer(INDEX_TRANSLOG_DURABILITY_SETTING, this::setTranslogDurability);  
    /**
        return this.maxScriptFields;
    public String getRemoteStoreRepository() {  
        INDEX_DERIVED_SOURCE_SETTING,  
        Property.IndexScope,
     **/
    private volatile ByteSizeValue flushAfterMergeThresholdSize;
        scopedSettings.addSettingsUpdateConsumer(
        scopedSettings.addSettingsUpdateConsumer(INDEX_MERGE_ON_FLUSH_MAX_FULL_FLUSH_MERGE_WAIT_TIME, this::setMaxFullFlushMergeWaitTime);
        Property.Final  
     * Returns the translog sync/upload buffer interval when remote translog store is enabled and index setting
        return maxRegexLength;
            INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING,  
     * Controls how many translog files that are no longer needed for persistence reasons
 * not use this file except in compliance with the License.
    public void setAutoForcemergeEnabled(boolean autoForcemergeEnabled) {
    public IndexScopedSettings getScopedSettings() {  
    }
    private void setMaxAdjacencyMatrixFilters(int maxAdjacencyFilters) {
     * Returns if remote store is enabled for this index.
                case CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_BALANCED:
     * Returns true if the this index should be searched throttled ie. using the  
        this.gcDeletesInMillis = timeValue.getMillis();
    private volatile int maxTokenCount;
    public static final Setting<TimeValue> INDEX_SEARCH_IDLE_AFTER = Setting.timeSetting(  
        this.isRemoteStoreEnabled = isRemoteStoreEnabled;
    private void setMappingDepthLimit(long value) {
        return durability;
        true,  
     * The maximum number of refresh listeners allows on this shard.
    public void setRemoteTranslogKeepExtraGen(int extraGen) {
        0,
    );
import org.opensearch.common.settings.Setting.Property;  
        MINIMUM_REMOTE_TRANSLOG_BUFFER_INTERVAL,
            String ingestionSourceType = IndexMetadata.INGESTION_SOURCE_TYPE_SETTING.get(settings);  
    private volatile boolean translogBatchAppendEnabled;
        assert softDeleteEnabled || version.before(Version.V_2_0_0) : "soft deletes must be enabled in version " + version;
        final Settings newSettings = indexMetadata.getSettings();
    private long gcDeletesInMillis = DEFAULT_GC_DELETES.millis();
     */
        return INDEX_SOFT_DELETES_SETTING.get(settings);
     * an eligible index keeps the per-operation path until an operator opts in; dynamic for controlled rollout.  
        Property.Dynamic,
        scopedSettings.addSettingsUpdateConsumer(  
        "index.context_aware.max_retry_on_lookup_map_acquisition_exception",
        );  
                    break;  
     */
     * Index setting describing the maximum size of the rescore window. Defaults to {@link #MAX_RESULT_WINDOW_SETTING}
import org.opensearch.common.unit.TimeValue;
        }  
        this.mappingNestedFieldsLimit = value;  
     */
        return warmerEnabled;  
        Property.IndexScope
        Property.IndexScope  
        }
    }  
     */  
        );  
    private final IndexSortConfig indexSortConfig;  
        mappingFieldNameLengthLimit = scopedSettings.get(INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING);
        maxRetryOnLookupMapAcquisitionException = scopedSettings.get(INDEX_MAX_RETRY_ON_LOOKUP_MAP_LOCK_ACQUISITION_EXCEPTION);
    public static final Setting<ByteSizeValue> INDEX_TRANSLOG_BATCH_APPEND_MAX_SIZE_SETTING = Setting.byteSizeSetting(
    }
        Property.NodeScope  
                default:
        return indexMetadata;
    );  
        100,
        Property.IndexScope
        );  
        return searchIdleAfter;  
    public Version getIndexVersionCreated() {
    /**
        Property.Dynamic,  
    public Version getExtendedCompatibilitySnapshotVersion() {  
        return true;
    }
        scopedSettings.addSettingsUpdateConsumer(INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING, this::setDerivedSourceEnabledForTranslog);
            && scopedSettings.get(PLUGGABLE_DATAFORMAT_ENABLED_SETTING);  
        Property.IndexScope
    }  
    public void setPublishReferencedSegmentsInterval(TimeValue publishReferencedSegmentsInterval) {
    /**  
        this.mappingFieldNameLengthLimit = value;
     * Returns the GC deletes cycle in milliseconds.  
        if (same(this.settings, newIndexSettings)) {  
     */
        String indexScopedPolicy = scopedSettings.get(INDEX_MERGE_POLICY);
        );
     * Index setting to enable / disable deletes garbage collection.  
        Property.PrivateIndex,
    );
            tieredMergePolicyProvider::setSegmentsPerTier
    public boolean isQueryStringAnalyzeWildcard() {
     * Returns <code>true</code> if queries are allowed to define and use derived fields. The default is <code>true</code>
    );  
    }
            IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING,
        maxRegexLength = scopedSettings.get(MAX_REGEX_LENGTH_SETTING);  
     * Returns <code>true</code> if the query string should analyze wildcards. The default is <code>false</code>
     * Compare the specified settings for equality.
        this.maxRescoreWindow = maxRescoreWindow;
        "index.merge.policy",
     */
     * <p>
    );  
     * to prevent generating too many token objects.  
     */
        return queryStringAnalyzeWildcard;
import java.util.Optional;  
     * be preserved for rollback purposes, we want to keep the size of individual generations from  
     */
        this.remoteTranslogKeepExtraGen = extraGen;
     * safely. 1,000,000 is probably way to high for any cluster to set  
    }  
    /**
            MergeSchedulerConfig.MAX_FORCE_MERGE_MB_PER_SEC_SETTING,  
     */  
     * Returns the default search fields for this index.
        Property.IndexScope,
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_DEFAULT_SLICE_COUNT_VALUE;
    }  
     * @return max level of nested queries and documents
        defaultPipeline = scopedSettings.get(DEFAULT_PIPELINE);  
                    }
        Property.Dynamic,
        translogBatchAppendMaxOperations = scopedSettings.get(INDEX_TRANSLOG_BATCH_APPEND_MAX_OPERATIONS_SETTING);
        Property.Dynamic
    );
    private volatile long mappingDepthLimit;
        "index.analyze.max_token_count",  
    public static final Setting<TimeValue> INDEX_MERGE_ON_FLUSH_MAX_FULL_FLUSH_MERGE_WAIT_TIME = Setting.timeSetting(
     * context aware indexes.  
     * Local-store and document-replication engines ignore this setting and retain per-operation appends.  
            );
    private void setMaxRescoreWindow(int maxRescoreWindow) {  
import org.opensearch.index.remote.RemoteStoreUtils;
    }
        "index.max_ngram_diff",
        assert mergePolicyProvider != null : "should not happen as validation for invalid merge policy values "
    }  
     * Controls how long translog files that are no longer needed for persistence reasons
    public static final Setting<String> DEFAULT_PIPELINE = new Setting<>(  
        "index.pluggable.dataformat.enabled",  
        Property.InternalIndex  
    public static final Setting<Boolean> ALLOW_DERIVED_FIELDS = Setting.boolSetting(
    }
    public boolean isRemoteStoreEnabled() {
    );
import static org.opensearch.common.util.FeatureFlags.CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG;
    /**
     */  
        return IndexMetadata.INDEX_DATA_PATH_SETTING.get(settings);  
    public static final Setting<String> INDEX_CHECK_ON_STARTUP = new Setting<>("index.shard.check_on_startup", "false", (s) -> {  
        Property.IndexScope
                    + IndexSettings.INDEX_MERGE_ON_FLUSH_POLICY.getKey()
     *  
    private volatile int translogBatchAppendMaxOperations;  
        scopedSettings.addSettingsUpdateConsumer(INDEX_REFRESH_INTERVAL_SETTING, this::setRefreshInterval);
    }
            logger.debug("Resetting maxMergesAtOnce to cluster default");  
    /**
        scopedSettings.addSettingsUpdateConsumer(DEFAULT_FIELD_SETTING, this::setDefaultFields);  
     */
            for (IndexMergePolicy policy : IndexMergePolicy.values()) {
    public boolean isTranslogBatchAppendEnabled() {
        Property.Dynamic,
     * Controls how many soft-deleted documents will be kept around before being merged away. Keeping more deleted
        "index.translog.retention.total_files",
        1,
        Property.Dynamic,  
        Property.IndexScope,
    public static final Setting<Double> FILE_BASED_RECOVERY_THRESHOLD_SETTING = Setting.doubleSetting(
            tieredMergePolicyProvider::setFloorSegmentSetting
 * GitHub history for details.
        Property.Final
     * Returns the node settings. The settings returned from {@link #getSettings()} are a merged version of the
 * You may obtain a copy of the License at  
import org.opensearch.search.pipeline.SearchPipelineService;
        Property.NodeScope
    );
        32,  
        return scopedSettings.get(setting);
                .equals(right.filter(IndexScopedSettings.ARCHIVED_SETTINGS_KEY_PREDICATE));  
    private final boolean queryStringLenient;  
    public double getDocIdFuzzySetFalsePositiveProbability() {  
     */
    public static final Setting<Integer> MAX_SCRIPT_FIELDS_SETTING = Setting.intSetting(
        scopedSettings.addSettingsUpdateConsumer(INDEX_TRANSLOG_RETENTION_AGE_SETTING, this::setTranslogRetentionAge);
        "index.search.throttled",
    /**
            throw new IllegalArgumentException(  
    private volatile ByteSizeValue generationThresholdSize;
     * @see IndexMetadata#indexCreated(Settings)  
     * Returns the minimum segment size for streaming aggregations.
     * Is merge of flush enabled or not
        Property.PrivateIndex,
     * Whether an eligible remote-backed segment-replication engine should batch successful primary index operations.
        Property.IndexScope
    /**
            }  
    /**
        if (version.equals(IndexMetadata.indexCreated(newSettings)) == false) {
        this.translogBatchAppendMaxOperations = maxOperations;
        5,  
     * while index level settings will overwrite node settings.
    public int getTranslogRetentionTotalFiles() {
        /*
     */  
import org.opensearch.common.settings.Setting;
        new ByteSizeValue(512, ByteSizeUnit.MB),
     */  
    /**
        return isStarTreeIndexEnabled;
     * indexing with offsets or term vectors is recommended.  
        scopedSettings.addSettingsUpdateConsumer(
    }
            this::setMaxRetryOnLookupMapAcquisitionException
    private void setMaxRegexLength(int maxRegexLength) {
    private volatile String defaultPipeline;
    private void setMappingDynamicPropertiesLuceneFieldLimit(long value) {  
        Collections.singletonList("*"),
    public TimeValue getRefreshInterval() {
    private volatile String defaultSearchPipeline;
        Property.Dynamic,
        new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES),
        10000,
        Property.IndexScope
        Property.IndexScope
     * Requires both the experimental feature flag and the index-level setting.  
        15,
        500_000,
            logByteSizeMergePolicyProvider::setLBSMaxMergeMBForForcedMerge
        0,  
    public String getUUID() {  
    public static final Setting<TimeValue> INDEX_PERIODIC_FLUSH_INTERVAL_SETTING = Setting.timeSetting(
    public boolean hasCustomDataPath() {
    }
     * 2. sets the maxMergesAtOnce on the actual TieredMergePolicy used by the engine if no index level override exists  
     * @param nodeSettings  the nodes settings this index is allocated on.
                return s;
        return this.maxResultWindow;
        Property.IndexScope,
    /**
     * Returns the customDataPath for this index, if configured. <code>""</code> o.w.  
    }
    public static final Setting<Translog.Durability> INDEX_TRANSLOG_DURABILITY_SETTING = new Setting<>(
     * @return <code>true</code> iff any setting has been updated otherwise <code>false</code>.
    }  
     * intentionally unregistered.
     */  
        IngestService.NOOP_PIPELINE_NAME,
    }  
    );
    public List<String> getDefaultFields() {  
            List.of(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING)  
    }
        scopedSettings.addSettingsUpdateConsumer(
    private volatile int maxRescoreWindow;
        Property.Dynamic,  
        MAX_RESULT_WINDOW_SETTING,
    public boolean isDerivedFieldAllowed() {
        1,
    void setDefaultMaxMergesAtOnce(int newDefaultMaxMergesAtOnce) {
    /**
    );  
    public synchronized boolean updateIndexMetadata(IndexMetadata indexMetadata) {  
        return INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING.exists(settings);
        scopedSettings.addSettingsUpdateConsumer(INDEX_SEARCH_IDLE_AFTER, this::setSearchIdleAfter);
        return maxRescoreWindow;  
    public boolean isRemoteTranslogStoreEnabled() {
    );  
     */
    /**
     * and document-replication engines retain the normal per-operation path regardless of this setting. Default false:
        Property.IndexScope
     * Returns the number of replicas this index has.
    }
        scopedSettings.addSettingsUpdateConsumer(INDEX_GC_DELETES_SETTING, this::setGCDeletes);
                    + String.join(", ", Arrays.stream(IndexMergePolicy.values()).map(IndexMergePolicy::getValue).toArray(String[]::new))
     *
        "index.refresh_interval",
    );  
        return isRemoteStoreEnabled;  
    public int getMaxShingleDiff() {
        scopedSettings.addSettingsUpdateConsumer(INDEX_WARMER_ENABLED_SETTING, this::setEnableWarmer);  
    public Settings getSettings() {
        maxAnalyzedOffset = scopedSettings.get(MAX_ANALYZED_OFFSET_SETTING);  
            mergeOnFlushPolicy = null;
     * Index setting describing for ShingleTokenFilter  
            case "checksum":
        return shouldCleanupUnreferencedFiles;  
import org.opensearch.core.common.unit.ByteSizeValue;  
        0,  
        scopedSettings.addSettingsUpdateConsumer(  
     */
        Property.IndexScope
        scopedSettings.addSettingsUpdateConsumer(INDEX_MERGE_ON_FLUSH_POLICY, this::setMergeOnFlushPolicy);  
     * Returns the maximum number of chars that will be analyzed in a highlight request
        scopedSettings.addSettingsUpdateConsumer(  
        "index.max_slices_per_scroll",
        Property.IndexScope
    public static final Setting<String> SEARCHABLE_SNAPSHOT_REPOSITORY = Setting.simpleString(  
    }
     * @deprecated This setting will be removed in 8.0
     * max_shingle_size and min_shingle_size.
 * This class encapsulates all index level settings and handles settings updates.
    public boolean isTranslogReadForward() {
        scopedSettings.addSettingsUpdateConsumer(ALLOW_DERIVED_FIELDS, this::setAllowDerivedField);
import static org.opensearch.index.mapper.MapperService.INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING;
    /**  
                }
    }  
    /**
    /**  
                case CONCURRENT_SEGMENT_SEARCH_MODE_AUTO:
        isCompositeIndex = scopedSettings.get(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING);
        scopedSettings.addSettingsUpdateConsumer(MAX_SLICES_PER_SCROLL, this::setMaxSlicesPerScroll);
        "index.query.derived_field.enabled",
    }
        remoteStoreRepository = settings.get(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY);
        0,
     */
     * 1. sets the new default in {@code TieredMergePolicyProvider}
     * Soft-deletes is enabled by default for Legacy 7.x and 1.x indices and mandatory for 2.0+ indices.
    private volatile long softDeleteRetentionOperations;  
 * compatible open source license.
    }
    }
     */
     * Returns the maximum number of terms that can be used in a Terms Query request  
        return Strings.isEmpty(customDataPath()) == false;
    /**
        "index.max_regex_length",
    }
        scopedSettings.addSettingsUpdateConsumer(
    private volatile TimeValue remoteTranslogUploadBufferInterval;  
            + "are part of setting definition";  
        numberOfShards = settings.getAsInt(IndexMetadata.SETTING_NUMBER_OF_SHARDS, null);
         */
    public ByteSizeValue getFlushThresholdSize() {  
     */
    public static final Setting<Boolean> INDEX_TRANSLOG_READ_FORWARD_SETTING = Setting.boolSetting(
     * Every shard on a remote node would also have SegRep enabled even without
            MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING,
        this.remoteStoreTranslogRepository = remoteStoreTranslogRepository;
        new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES), // never flush after merge
    public int getMaxNestedQueryDepth() {
     * <b>Note:</b> Enabling forward reading is safe for most use cases. However, in rare edge cases, it may replay stale
        Property.Dynamic,
    }
        20,
                }
        scopedSettings.addSettingsUpdateConsumer(INDEX_MAPPING_NESTED_FIELDS_LIMIT_SETTING, this::setMappingNestedFieldsLimit);
        Property.IndexScope,  
        Property.Dynamic,  
        Translog.Durability.REQUEST.name(),  
        Property.IndexScope,  
    }
        0,  
        return Optional.ofNullable(mergeOnFlushPolicy);
        "index.translog.batch_append.max_operations",  
        MergePolicyProvider mergePolicyProvider = null;  
     * produced using _analyze API. The default maximum of 10000 is defensive
    private final LogByteSizeMergePolicyProvider logByteSizeMergePolicyProvider;
    }
        false,
    public String getDefaultSearchPipeline() {
    public static final Setting<Integer> INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE = Setting.intSetting(  
    private final boolean isWarmIndex;
        this.syncInterval = translogSyncInterval;
        this.maxFullFlushMergeWaitTime = timeValue;
     * Is flush check by write threads enabled or not
     * Periodic flush interval setting. By default, periodic flush is disabled (-1).  
        final String newRestoreUUID = newSettings.get(IndexMetadata.SETTING_HISTORY_UUID, IndexMetadata.INDEX_UUID_NA_VALUE);
    );  
        value -> {
    public MergeSchedulerConfig getMergeSchedulerConfig() {
     */
            new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES),
     * {@link #getFlushOnUncommittedSegmentsThresholdSize()}.
    }
    );  
    }
        "index.warmer.enabled",
        scopedSettings.addSettingsUpdateConsumer(
     * safely.
    }
    public TimeValue getMaxFullFlushMergeWaitTime() {  
        this.remoteStoreSegmentPathPrefix = (rawPrefix != null && !rawPrefix.trim().isEmpty()) ? rawPrefix : null;  
        Property.Dynamic,
    public static final Setting<Integer> MAX_NESTED_QUERY_DEPTH_SETTING = Setting.intSetting(  
        Property.IndexScope
        } else {
        maxAdjacencyMatrixFilters = scopedSettings.get(MAX_ADJACENCY_MATRIX_FILTERS_SETTING);
        "index.search.concurrent_segment_search.partition_min_segment_size",
        PathType::parseString,  
     * Returns if remote translog store is enabled for this index.
        "index.merge_on_flush.enabled",
     * pending chunk; whichever of this and {@link #INDEX_TRANSLOG_BATCH_APPEND_MAX_OPERATIONS_SETTING} is reached
    private final boolean queryStringAnalyzeWildcard;
    private static final String DEFAULT_POLICY = "default";  
        new ByteSizeValue(Translog.DEFAULT_HEADER_SIZE_IN_BYTES + 1, ByteSizeUnit.BYTES),
    private void setTranslogDurability(Translog.Durability durability) {
    }
         * rolling the generation as every new generation will already exceed the
    /**
     * Returns the current node name
        false,
    /**  
     * False positive probability to use while creating fuzzy set.
        Property.IndexScope
            tieredMergePolicyProvider.setMaxMergesAtOnceToDefault();
    public boolean isDerivedSourceEnabled() {  
    }
        Property.Dynamic,  
        scopedSettings.addSettingsUpdateConsumer(INDEX_TRANSLOG_GENERATION_THRESHOLD_SIZE_SETTING, this::setGenerationThresholdSize);
                break;  
    public static final TimeValue DEFAULT_GC_DELETES = TimeValue.timeValueSeconds(60);  
            logByteSizeMergePolicyProvider::setLBSMaxMergeSegment  
    public long getMappingDepthLimit() {
    private final boolean queryStringAllowLeadingWildcard;
    /**
    private volatile int maxAdjacencyMatrixFilters;
        );
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
    }
                throw new IllegalArgumentException(
        true, /* https://issues.apache.org/jira/browse/LUCENE-10078 */  
     * documents) on the grounds that a file-based peer recovery may copy all of the documents in the shard over to the new peer, but is  
            return false;
    /**
        this.defaultFields = defaultFields;
     * @return true if the settings are the same, otherwise false  
import java.util.List;
     */
        this.allowDerivedField = allowDerivedField;  
    // For warm index we would partially store files in local.
     * automatically rolled to a new generation when the current generation exceeds this generation
    public static final Setting<PathType> SEARCHABLE_SNAPSHOT_SHARD_PATH_TYPE = new Setting<>(  
     * Returns the index this settings object belongs to  
    public boolean isDocumentReplication() {
    public long getMappingNestedFieldsLimit() {
                if (isTimeSeriesIndex) {
     * Determines a balance between file-based and operations-based peer recoveries. The number of operations that will be used in an
        return gcDeletesInMillis;  
            this::setPublishReferencedSegmentsInterval
        tieredMergePolicyProvider.setDefaultMaxMergesAtOnce(newDefaultMaxMergesAtOnce);  
    /**
     * in an adjacency_matrix aggregation. The max number of buckets produced by
        );  
    public static final Setting<TimeValue> INDEX_REFRESH_INTERVAL_SETTING = Setting.timeSetting(  
     * <p>  
        Property.IndexScope  
        isStarTreeIndexEnabled = scopedSettings.get(StarTreeIndexSettings.STAR_TREE_SEARCH_ENABLED_SETTING);
        1,  
        this.logByteSizeMergePolicyProvider = new LogByteSizeMergePolicyProvider(logger, this);  
        if (this.replicationType == ReplicationType.SEGMENT && this.getNumberOfReplicas() > 0) {  
     */
        );
        0.0d,
        Function.identity(),
     * {@link org.opensearch.indices.recovery.RecoveryTarget#finalizeRecovery(long, long, org.opensearch.core.action.ActionListener)}
        1,
    public static final Setting<ByteSizeValue> INDEX_TRANSLOG_RETENTION_SIZE_SETTING = Setting.byteSizeSetting(
        replicationType = IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(settings);  
 *
        return remoteStoreTranslogRepository;
        softDeleteEnabled = scopedSettings.get(INDEX_SOFT_DELETES_SETTING);
     */  
        MINIMUM_PERIODIC_FLUSH_INTERVAL,  
    }
    public TimeValue getPublishReferencedSegmentsInterval() {
     * Returns the current IndexMetadata for this index
        TimeValue.timeValueSeconds(1),
        mappingDynamicPropertiesLuceneFieldLimit = scopedSettings.get(INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING);
        Property.IndexScope,
        return settings;
        false,  
        this.maxNgramDiff = maxNgramDiff;
     */  
    /**
     *
    private void setMaxTokenCount(int maxTokenCount) {
     */
        switch (indexMergePolicy) {
    public static final Setting<TimeValue> INDEX_TRANSLOG_RETENTION_AGE_SETTING = Setting.timeSetting(
    }
     * In this scenario, forward reading could return outdated operations from previous primary terms.  
    );  
     * The maximum number of slices allowed in a PIT request.  
    );
import org.opensearch.Version;  
    public static final Setting<Boolean> INDEX_DERIVED_SOURCE_SETTING = Setting.boolSetting(  
     * The maximum number of slices allowed in a scroll request
    /**  
        this.docIdFuzzySetFalsePositiveProbability = docIdFuzzySetFalsePositiveProbability;
        setTranslogRetentionSize(scopedSettings.get(INDEX_TRANSLOG_RETENTION_SIZE_SETTING));
        this.translogBatchAppendMaxSize = maxSize;
        // Upon updates to the cluster default settings, we always update the cached default values in
        this.searchIdleAfter = searchIdleAfter;  
    private void setStreamingAggregationMinSegmentSize(int streamingAggregationMinSegmentSize) {
    /**
        }  
     */  
            this.translogRetentionAge = TimeValue.MINUS_ONE;
        return maxRefreshListeners;
        "index.max_shingle_diff",  
        this.maxDocvalueFields = maxDocvalueFields;  
        Property.Dynamic
        Property.IndexScope,  
     */
    /**
    private volatile double docIdFuzzySetFalsePositiveProbability;  
    public int getTranslogBatchAppendMaxOperations() {
        this.mergeOnFlushEnabled = enabled;  
         * can get stuck in an infinite loop as the shouldPeriodicallyFlush can still be true after flushing.
    }  
     * condition takes over the commit-lag-bounding job that the translog size condition performs on non
     */
     * Update the cached defaults for {@code MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING} and
    /**
        scopedSettings.addSettingsUpdateConsumer(INDEX_SEARCH_THROTTLED, this::setSearchThrottled);
     * top hits aggregation. The default maximum of 100 is defensive for the reason that the number of inner hit responses  
    private volatile long mappingFieldNameLengthLimit;  
    }  
    private void setMaxFullFlushMergeWaitTime(TimeValue timeValue) {
    /**  
        new TimeValue(10, TimeUnit.SECONDS),
    }
        return translogRetentionAge;
        value -> {  
            this::setRemoteStoreTranslogRepository  
    }
    public TimeValue getRemoteTranslogUploadBufferInterval() {  
        scopedSettings.addSettingsUpdateConsumer(MAX_TOKEN_COUNT_SETTING, this::setMaxTokenCount);  
        generationThresholdSize = scopedSettings.get(INDEX_TRANSLOG_GENERATION_THRESHOLD_SIZE_SETTING);
        scopedSettings.addSettingsUpdateConsumer(INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING, this::setRetentionLeaseMillis);  
     *  
        scopedSettings.addSettingsUpdateConsumer(
    public void setTranslogSyncInterval(TimeValue translogSyncInterval) {  
        Property.IndexScope
    }  
        return maxInnerResultWindow;  
    private volatile int maxNestedQueryDepth;  
        100,
    }
    public static final Setting<Boolean> INDEX_MERGE_ON_FLUSH_ENABLED = Setting.boolSetting(
    private volatile int maxSlicesPerScroll;
        Property.Dynamic,
        Property.Dynamic  
    }
        } else {  
        TimeValue.timeValueSeconds(30),
            tieredMergePolicyProvider::setDeletesPctAllowed  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    );  
    }
    /**  
                case CONCURRENT_SEGMENT_SEARCH_MODE_NONE:  
     * the transaction log is fsyncing on every operations  
        "index.remote_store.translog.keep_extra_gen",
        return mappingDynamicPropertiesLuceneFieldLimit;  
    }
     * effective threshold is the cluster setting
    );
    }
    public static final Setting<Boolean> INDEX_UNREFERENCED_FILE_CLEANUP = Setting.boolSetting(
                    throw new IllegalArgumentException("Setting value must be one of [segment, balanced, force]");
    public static final Setting<Boolean> INDEX_AUTO_FORCE_MERGES_ENABLED = Setting.boolSetting(
    public static final Setting<String> INDEX_MERGE_ON_FLUSH_POLICY = Setting.simpleString(
    }
        1024,
     * The maximum length of regex string allowed in a regexp query.
     * Returns true if index warmers are enabled, otherwise <code>false</code>  
    /**
        return this.widenIndexSortType;
        this.periodicFlushInterval = timeValue;  
        Property.Dynamic  
     */
        this.enableFuzzySetForDocId = enableFuzzySetForDocId;  
    }
        pluggedDataFormat = scopedSettings.get(PLUGGABLE_DATAFORMAT_VALUE_SETTING);
        "index.query_string.lenient",
     */  
    public static final Setting<ByteSizeValue> INDEX_TRANSLOG_GENERATION_THRESHOLD_SIZE_SETTING = Setting.byteSizeSetting(
    }
    /**
     * Returns if remote store is enabled for this index.  
     * Returns the maximum number of translog files that no longer required for persistence should be kept for peer recovery
                    + MERGE_ON_FLUSH_MERGE_POLICY
    private final Settings nodeSettings;
        1024,
    );
     **/  
                );  
    private final boolean widenIndexSortType;
        100,
    public void setDefaultPipeline(String defaultPipeline) {
    public static final Setting<Integer> MAX_RESULT_WINDOW_SETTING = Setting.intSetting(  
    );
    );
     */
     */
     * Returns the maximum allowed difference between max and min shingle_size
     */
        DEFAULT_REMOTE_TRANSLOG_BUFFER_INTERVAL,
     * Specifies if the index should be context aware enabled  
    private final MergeSchedulerConfig mergeSchedulerConfig;  
     * (for example, during a primary failover with network isolation that leaves stale operations untrimmed)
    /**  
     * when {@link #isFlushOnUncommittedSegmentsThresholdSizeExplicit()}; otherwise the effective threshold is the
    public static final Setting<Boolean> PLUGGABLE_DATAFORMAT_ENABLED_SETTING = Setting.boolSetting(
import static org.opensearch.index.mapper.MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING;
    /**  
        Property.IndexScope,
     * Only takes effect while the condition is enabled cluster-wide by  
    private final boolean pluggableDataFormatEnabled;
        Property.IndexScope
    }
        }  
    );
    );
     * script fields is a costly operation.
                    + ", "  
     * Returns the maximum rescore window for search requests.  
        "index.translog.flush_threshold_size",  
        } else {  
        );
        Property.IndexScope
        (settings) -> {
    /**  
    private void setGenerationThresholdSize(final ByteSizeValue generationThresholdSize) {
     * remote-store shard. On remote-store shards the translog based flush threshold  
     * Returns whether the pluggable data format feature is enabled for this index.
    public static final Setting<Integer> INDEX_CONCURRENT_SEGMENT_SEARCH_MAX_SLICE_COUNT = Setting.intSetting(  
        Property.IndexScope
    private final boolean isCompositeIndex;
        100,  
        );  
            tieredMergePolicyProvider::setMaxMergedSegment
        if (TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.exists(getSettings()) == false) {
        false,
            this.translogRetentionSize = new ByteSizeValue(-1);
     * The minimum segment size for streaming aggregations.
    /**
    }
        }
            MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING,  
     * The maximum number of refresh listeners allows on this shard.
        boolean overrideExistingConfigs = MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.exists(getSettings()) == false
    /**  
     */  
            );
            switch (value) {
    private volatile String remoteStoreTranslogRepository;
    private void setShouldCleanupUnreferencedFiles(boolean shouldCleanupUnreferencedFiles) {  
     */
     * <p>
    public static boolean same(final Settings left, final Settings right) {
    /**
     */
    }
        "index.searchable_snapshot.snapshot_id.uuid",
     */
    }
     */
    );  
    private void setMaxNgramDiff(int maxNgramDiff) {  
                default:
     * more sense to copy all the data over again instead of replaying history.
    public Settings getNodeSettings() {
        this.defaultPipeline = defaultPipeline;
        scopedSettings.addSettingsUpdateConsumer(MAX_REGEX_LENGTH_SETTING, this::setMaxRegexLength);
     * @return {@code true} if pluggable data format is enabled
        1,  
    public TimeValue getPeriodicFlushInterval() {
     *  
    }  
     * {@link org.opensearch.threadpool.ThreadPool.Names#SEARCH_THROTTLED} thread-pool
        "index.flush_after_merge",
    public static final Setting<TimeValue> INDEX_GC_DELETES_SETTING = Setting.timeSetting(
     * Update the default maxMergesAtOnce
        version = IndexMetadata.SETTING_INDEX_VERSION_CREATED.get(settings);
     * {@code MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING}
    void updateMaxMergesAtOnce(Settings updatedSettings) {
        Property.IndexScope,
        }
        Property.Dynamic
        return version;  
    private volatile int maxScriptFields;
    public IndexSortConfig getIndexSortConfig() {
        return INDEX_REFRESH_INTERVAL_SETTING.exists(settings);
        if (newRestoreUUID.equals(restoreUUID) == false) {
        "index.max_adjacency_matrix_filters",  
            this::setRemoteTranslogUploadBufferInterval
     */  
     * Returns <code>true</code> if translog read-forward is enabled.  
    }  
    public static final Setting<Boolean> INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING = Setting.boolSetting(
                    "FeatureFlag " + CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG + " must be enabled to set this property to true"
        );
    private int maxRetryOnLookupMapAcquisitionException;
        return isCompositeIndex;
        logger = Loggers.getLogger(getClass(), index);
import org.opensearch.search.streaming.FlushModeResolver;  
 * be called for each settings update.  
    public static final Setting<String> TIME_SERIES_INDEX_MERGE_POLICY = Setting.simpleString(
        Property.Dynamic,  
        widenIndexSortType = IndexMetadata.SETTING_INDEX_VERSION_CREATED.get(settings).before(V_2_7_0);
     * Denotes whether search via star tree index is enabled for this index
            tieredMergePolicyProvider::setExpungeDeletesAllowed
    public boolean isDerivedSourceEnabledForTranslog() {
    );
        1,
     */
        this.shouldCleanupUnreferencedFiles = shouldCleanupUnreferencedFiles;
    /**
    public boolean isWarmIndex() {  
    private void setMaxDocvalueFields(int maxDocvalueFields) {
        return generationThresholdSize;
    /**
        Property.IndexScope  
    public int getMaxScriptFields() {  
         * generation threshold. However, small thresholds are useful for testing so we
        this.publishReferencedSegmentsInterval = publishReferencedSegmentsInterval;  
    /**
     */
        TIERED("tiered"),
        Property.IndexScope
     * @param right the right settings
    }
     * Index setting describing the maximum value of from + size on a query.
     * Returns the merge threshold size when to forcefully flush the index and free resources.
        return mergeSchedulerConfig;  
            }  
import java.util.function.Consumer;
     * Returns the translog sync interval. This is the interval in which the transaction log is asynchronously fsynced unless
                    "unknown value for [index.shard.check_on_startup] must be one of " + "[true, false, checksum] but was: " + s
    private void setEnableWarmer(boolean enableWarmer) {  
        public String getValue() {
 * KIND, either express or implied.  See the License for the
    private volatile boolean searchThrottled;  
     */
    private void setSoftDeleteRetentionOperations(long ops) {  
import org.opensearch.index.translog.Translog;  
        Property.Dynamic,
    );
     * Returns true if segment replication is enabled on the index.  
    private void setMaxNestedQueryDepth(int maxNestedQueryDepth) {
     * The maximum size of a translog generation. This is independent of the maximum size of
        TimeValue.ZERO,
    }
                            break;
    private void setMergeOnFlushEnabled(boolean enabled) {
    public int getMaxNgramDiff() {
    }  
     * Default for {@link #INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING} and for the
        assignedOnRemoteNode = RemoteStoreNodeAttribute.isRemoteDataAttributePresent(this.getNodeSettings());  
        scopedSettings.applySettings(newSettings);
        syncInterval = INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.get(settings);
     * Returns <code>true</code> if queries should be lenient about unmapped fields. The default is <code>true</code>
import org.opensearch.index.remote.RemoteStorePathStrategy;
        return searchThrottled;
        final String restoreUUID = this.settings.get(IndexMetadata.SETTING_HISTORY_UUID, IndexMetadata.INDEX_UUID_NA_VALUE);  
                    String nodeScopedTimeSeriesIndexPolicy = TIME_SERIES_INDEX_MERGE_POLICY.get(nodeSettings);
    }
    private volatile TimeValue refreshInterval;
        // the MergeSchedulerConfig, but we only update the actual values when an index level setting is not present  
    }
    }
                    + DEFAULT_POLICY
        "index.translog.retention.size",
    }
    );
    }
    );
    /**  
    );
     * will be kept around before being deleted. Keeping more files is useful to increase  
     * Returns the number of extra operations (i.e. soft-deleted documents) to be kept for recoveries and history purpose.
    /**  
import static org.opensearch.index.codec.fuzzy.FuzzySetParameters.DEFAULT_FALSE_POSITIVE_PROBABILITY;  
        scopedSettings.addSettingsUpdateConsumer(INDEX_TRANSLOG_BATCH_APPEND_ENABLED_SETTING, this::setTranslogBatchAppendEnabled);
            INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING  
    private void setMaxTermsCount(int maxTermsCount) {  
     */
    }
    public static final Setting<String> INDEX_CONCURRENT_SEGMENT_SEARCH_MODE = Setting.simpleString(  
    private volatile int maxNgramDiff;  
import static org.opensearch.common.util.FeatureFlags.CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_SETTING;
    }
     * Returns the translog durability for this index.
        maxRescoreWindow = scopedSettings.get(MAX_RESCORE_WINDOW_SETTING);  
        );
     */
                "The setting has unsupported policy specified: "
    }  
        switch (s) {
    }
    public long getMappingTotalFieldsLimit() {
        remoteStoreTranslogRepository = settings.get(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY);  
    public static final Setting<Boolean> INDEX_CONCURRENT_SEGMENT_SEARCH_SETTING = Setting.boolSetting(
        },
    public IndexSettings(final IndexMetadata indexMetadata, final Settings nodeSettings, IndexScopedSettings indexScopedSettings) {
        scopedSettings.addSettingsUpdateConsumer(INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING, this::setMappingFieldNameLengthLimit);
    );
        value -> {
     * Enum representing supported merge policies
        MINIMUM_REFRESH_INTERVAL,  
        true,
    public void setRemoteStoreRepository(String remoteStoreRepository) {
    public static final Setting<Boolean> INDEX_CONTEXT_AWARE_ENABLED_SETTING = Setting.boolSetting(
        65536,
        derivedSourceEnabledForTranslog = scopedSettings.get(INDEX_DERIVED_SOURCE_TRANSLOG_ENABLED_SETTING);  
        return queryStringLenient;
     * Composite engine indexes default to {@link LogByteSizeMergePolicyProvider};
        false,
    /**
     */
    private void setTranslogBatchAppendMaxSize(ByteSizeValue maxSize) {  
        return periodicFlushInterval;  
    public int getMaxAdjacencyMatrixFilters() {
        scopedSettings.addSettingsUpdateConsumer(  
    public int getStreamingAggregationMinSegmentSize() {  
        0,
        scopedSettings.addSettingsUpdateConsumer(  
     * Maximum serialized size one batched translog append may carry. Bounds the heap one write thread holds for its  
        Property.InternalIndex  
     */  
     */  
    /**
     */  
    /**
     * Expert: Makes indexing threads check for pending flushes on update in order to help out
    }
    }
        softDeleteRetentionOperations = scopedSettings.get(INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING);  
    /**  
 *  
        Property.IndexScope  
        maxNestedQueryDepth = scopedSettings.get(MAX_NESTED_QUERY_DEPTH_SETTING);
    public static final TimeValue DEFAULT_REMOTE_TRANSLOG_BUFFER_INTERVAL = new TimeValue(650, TimeUnit.MILLISECONDS);  
        scopedSettings.addSettingsUpdateConsumer(MAX_ANALYZED_OFFSET_SETTING, this::setHighlightMaxAnalyzedOffset);
        return index;  
            throw new IllegalArgumentException(  
        false,
    );  
        "index.context.current_version",
     **/
     */  
        return flushThresholdSize;
        "index.context.created_version",
    }  
    private volatile ByteSizeValue flushOnUncommittedSegmentsThresholdSize;
     * The default maximum of 65536 terms is defensive, as extra processing and memory is involved  
        Property.InternalIndex  
        "index.merge_on_flush.policy",  
        new TimeValue(1, TimeUnit.MILLISECONDS),
import org.opensearch.common.settings.Settings;
        }  
     * appended in several chunks; a smaller one is always a single append, so the cap only bounds the per-append
        if (shouldDisableTranslogRetention(settings) && age.millis() >= 0) {  
        scopedSettings.addSettingsUpdateConsumer(  
        0.50,
        Property.Dynamic,  
            throw new IllegalArgumentException(  
        maxTokenCount = scopedSettings.get(MAX_TOKEN_COUNT_SETTING);  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;  
     *
        scopedSettings.addSettingsUpdateConsumer(FINAL_PIPELINE, this::setRequiredPipeline);
        );  
    }
        warmerEnabled = scopedSettings.get(INDEX_WARMER_ENABLED_SETTING);
    }
     * Returns this interval in which the shards of this index are asynchronously refreshed. {@code -1} means async refresh is disabled.
    );
     */
    }
                );  
        mappingNestedDocsLimit = scopedSettings.get(INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING);
     */
    );  
    public static final Setting<String> SEARCHABLE_SNAPSHOT_INDEX_ID = Setting.simpleString(  
    public int getMaxRetryOnLookupMapAcquisitionException() {
        return defaultFields;
     */
import org.opensearch.core.common.unit.ByteSizeUnit;
         */
    private volatile ReplicationType replicationType;
    private final int numberOfShards;  
     */
    public static final Setting<Long> INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING = Setting.longSetting(
    }  
     * Specialized merge-on-flush policy if provided  
        scopedSettings.addSettingsUpdateConsumer(INDEX_AUTO_FORCE_MERGES_ENABLED, this::setAutoForcemergeEnabled);
    private volatile TimeValue searchIdleAfter;
     */  
        0,
    public boolean isRemoteSnapshot() {
        return indexSortConfig;  
    private void setDefaultFields(List<String> defaultFields) {
    }
    public int getRemoteTranslogExtraKeep() {
        0.1d,  
        mergeSchedulerConfig.setDefaultAutoThrottleEnabled(  
        CONCURRENT_SEGMENT_SEARCH_DEFAULT_SLICE_COUNT_VALUE,
                    + IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey()
    public boolean isSoftDeleteEnabled() {
    private void setMaxShingleDiff(int maxShingleDiff) {
        );  
    }  
    /**
        this.maxRefreshListeners = maxRefreshListeners;  
    private volatile TimeValue translogRetentionAge;
    /**
        IndexMergePolicy(String value) {
        Property.Dynamic,
        if (isDerivedSourceEnabledForTranslog && !isDerivedSourceEnabled()) {
    public Translog.Durability getTranslogDurability() {  
     *
                    return policy;  
    );  
    private void setMaxInnerResultWindow(int maxInnerResultWindow) {  
        Property.IndexScope
    /**  
        Property.IndexScope
     * Index setting describing the maximum number of nested scopes in queries.  
    }
        return this.maxNestedQueryDepth;
        "index.segment_replication.publish_referenced_segments_interval",
     */
    private void setMaxSlicesPerScroll(int value) {
     */
    /**
        TimeValue.timeValueHours(12),
     */
    );
            }
        0,
    public int getMaxSlicesPerScroll() {  
     */
    private volatile boolean mergeOnFlushEnabled;
    /**
     */
     */
                    + policy  
     */  
        }
     */  
     */  
     * @param maxAdjacencyFilters the max number of filters in adjacency_matrix aggregation search requests  
    /**
    /**
    /**
        }  
    /**  
import org.opensearch.cluster.metadata.IndexMetadata;
        SearchPipelineService.NOOP_PIPELINE_ID,
     * Index setting describing the maximum number of filters clauses that can be used
        scopedSettings = indexScopedSettings.copy(nodeSettings, indexMetadata);  
    private volatile boolean enableFuzzySetForDocId;
    /**  
     */
    }  
            TieredMergePolicyProvider.INDEX_MERGE_POLICY_DELETES_PCT_ALLOWED_SETTING,
    /**
            .equals(right.filter(IndexScopedSettings.INDEX_SETTINGS_KEY_PREDICATE))
        return queryStringAllowLeadingWildcard;  
    /**
    private volatile TimeValue publishReferencedSegmentsInterval;
    private final boolean derivedSourceEnabled;
import static org.opensearch.index.mapper.MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING;  
        scopedSettings.addSettingsUpdateConsumer(INDEX_PERIODIC_FLUSH_INTERVAL_SETTING, this::setPeriodicFlushInterval);
    public static final Setting<TimeValue> INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING = Setting.timeSetting(
        1,
            MINIMUM_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE,
     * {@code index.translog.durability} is set as {@code request}.
    }  
        "index.remote_store.translog.buffer_interval",  
        searchIdleAfter = scopedSettings.get(INDEX_SEARCH_IDLE_AFTER);
     * translog operations that have not been flushed.
    public ByteSizeValue getFlushAfterMergeThresholdSize() {
    }
    }  
    );  
    public Optional<UnaryOperator<MergePolicy>> getMergeOnFlushPolicy() {
        return mappingNestedDocsLimit;
     * Returns the custom path prefix for remote store segments, if set.  
import static org.opensearch.index.mapper.MapperService.INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING;  
    }
     * Returns the maximum number of tokens that can be produced
        return this.softDeleteRetentionOperations;
                    IndexMergePolicy nodeMergePolicy = IndexMergePolicy.fromString(nodeScopedTimeSeriesIndexPolicy);  
        Property.IndexScope  
        maxShingleDiff = scopedSettings.get(MAX_SHINGLE_DIFF_SETTING);
     */  
        maxFullFlushMergeWaitTime = scopedSettings.get(INDEX_MERGE_ON_FLUSH_MAX_FULL_FLUSH_MERGE_WAIT_TIME);  
        this.durability = scopedSettings.get(INDEX_TRANSLOG_DURABILITY_SETTING);
    public ByteSizeValue getTranslogRetentionSize() {
    );
        return translogBatchAppendEnabled;  
    );  
    );
     * operations-based peer recovery is limited to this proportion of the total number of documents in the shard (including deleted
 * Modifications Copyright OpenSearch Contributors. See  
        "index.query.parse.allow_unmapped_fields",
     * Returns <code>true</code> if the index has a custom data path
     * @return boolean
        100,  
     * Returns the maximum number of allowed script_fields to retrieve in a search request
        TimeValue.timeValueMinutes(10),  
        TimeValue.timeValueSeconds(5),
    public static final Setting<Boolean> ALLOW_UNMAPPED = Setting.boolSetting(
    public static final Setting<List<String>> DEFAULT_FIELD_SETTING = Setting.listSetting(  
                    + " can't be set when "  
        }
    }
        isRemoteStoreEnabled = settings.getAsBoolean(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false);
        scopedSettings.addSettingsUpdateConsumer(MAX_DOCVALUE_FIELDS_SEARCH_SETTING, this::setMaxDocvalueFields);
    public static final Setting<Boolean> QUERY_STRING_ALLOW_LEADING_WILDCARD = Setting.boolSetting(
    private volatile int maxDocvalueFields;  
    }
    }
    public static final Setting<Boolean> INDEX_DOC_ID_FUZZY_SET_ENABLED_SETTING = Setting.boolSetting(
     * for each additional term, and a large number of terms degrade the cluster performance.
        return remoteTranslogKeepExtraGen;
    /**
     */
    }  
                        case DEFAULT_POLICY:
    public static final String CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_BALANCED = "balanced";
    public boolean isExplicitRefresh() {
        Property.Final
        Property.Dynamic,
    }  
        this.searchThrottled = searchThrottled;
        pluggableDataFormatEnabled = FeatureFlags.isEnabled(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    // volatile fields are updated via #updateIndexMetadata(IndexMetadata) under lock
     * Updates the settings and index metadata and notifies all registered settings consumers with the new settings iff at least one
     * Returns the transaction log retention age which controls the maximum age (time from creation) that translog files will be kept
    public static final Setting<TimeValue> INDEX_PUBLISH_REFERENCED_SEGMENTS_INTERVAL_SETTING = Setting.timeSetting(
            logByteSizeMergePolicyProvider::setLBSNoCFSRatio  
    /**
        Property.IndexScope,
    private MergePolicyProvider defaultMergePolicyProvider() {
    public static final Setting<String> INDEX_MERGE_POLICY = Setting.simpleString(  
        Property.Dynamic,
            INDEX_DOC_ID_FUZZY_SET_FALSE_POSITIVE_PROBABILITY_SETTING,
    private void setTranslogRetentionAge(TimeValue age) {
    }
    /**  
    /**
        LOG_BYTE_SIZE("log_byte_size"),
        "index.soft_deletes.retention.operations",  
        scopedSettings.addSettingsUpdateConsumer(INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING, this::setTranslogFlushThresholdSize);
     * The maximum length of regex string allowed in a regexp query.
        false,  
    }
     */
 * Unless required by applicable law or agreed to in writing,
     */  
            Property.Dynamic,  
        Property.IndexScope
        "index.default_pipeline",
                if (policy.value.equals(text)) {
    }
     * Returns the merge policy that should be used for this index.  
        0.01,  
        "index.searchable_snapshot.snapshot_id.name",
            return value;  
    );
    public static final ByteSizeValue DEFAULT_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE = new ByteSizeValue(512, ByteSizeUnit.MB);
    public static final Setting<String> PLUGGABLE_DATAFORMAT_VALUE_SETTING = Setting.simpleString(  
    private volatile ByteSizeValue translogRetentionSize;  
    private volatile Settings settings;  
        Property.Dynamic,
     * significantly faster than replaying the missing operations on the peer, so once a peer falls far enough behind the primary it makes
    /**
    /**
    private volatile long mappingNestedDocsLimit;  
    private final boolean isTranslogMetadataEnabled;
        return mappingTotalFieldsLimit;  
            TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGED_SEGMENT_SETTING,  
        return softDeleteEnabled;
        scopedSettings.addSettingsUpdateConsumer(MAX_ADJACENCY_MATRIX_FILTERS_SETTING, this::setMaxAdjacencyMatrixFilters);
    private volatile int maxRegexLength;  
    }  
 * ownership. Elasticsearch licenses this file to you under  
    }
    private final String nodeName;
        scopedSettings.addSettingsUpdateConsumer(INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING, this::setMappingTotalFieldsLimit);  
     * when soft-deletes is disabled.  
        throw new UnsupportedOperationException("Experimental feature has been removed");
        return mappingFieldNameLengthLimit;
import org.opensearch.common.annotation.PublicApi;
    private volatile TimeValue maxFullFlushMergeWaitTime;  
     * settings that are specified on both index and node level are overwritten by the index settings.
        Property.Dynamic,
        return nodeName;
        this.mappingTotalFieldsLimit = value;
import static org.opensearch.Version.V_2_7_0;  
    /**
        );  
        Property.IndexScope
        return isRemoteStoreFencingEnabled;  
        this.allowDerivedField = scopedSettings.get(ALLOW_DERIVED_FIELDS);
    public long getSoftDeleteRetentionOperations() {
        return defaultSearchPipeline;  
     * latency and memory of large bulks. Raise it for append-heavy indices fed by large bulk requests.  
    }
        return maxTokenCount;
        },
     * cluster default, which is resolved by the publisher of the accounting (see {@code RemoteStoreRefreshListener}).
     */
    /**
    public void setRemoteStoreTranslogRepository(String remoteStoreTranslogRepository) {  
    }
    public String getRemoteStoreSegmentPathPrefix() {
     * Marks an index to be searched throttled. This means that never more than one shard of such an index will be searched concurrently
        isTranslogMetadataEnabled = RemoteStoreUtils.determineTranslogMetadataEnabled(indexMetadata);  
 */  
            if (ingestionSourceType != null && !IndexMetadata.NONE_INGESTION_SOURCE_TYPE.equals(ingestionSourceType)) {
    }  
    private volatile int maxInnerResultWindow;  
        return contextAwareEnabled && FeatureFlags.isEnabled(CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_SETTING);
                throw new IllegalArgumentException(
    }
     * Controls the maximum length of time since a retention lease is created or renewed before it is considered expired.  
        this.maxRegexLength = maxRegexLength;  
        Property.IndexScope,
    public void setEnableFuzzySetForDocId(boolean enableFuzzySetForDocId) {
                    // valid setting
        this.remoteTranslogKeepExtraGen = INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING.get(settings);  
     * own explicit setting.  
        maxResultWindow = scopedSettings.get(MAX_RESULT_WINDOW_SETTING);  
    private volatile boolean warmerEnabled;
        Function.identity(),  
     * Returns the generation threshold size. As sequence numbers can cause multiple generations to
     * The Default maximum value of from + size on a query is 10,000. This was chosen as  
        return translogBatchAppendMaxOperations;  
            case "false":
        Property.IndexScope,
        0,
    private void setMappingNestedFieldsLimit(long value) {
            && MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.exists(getSettings()) == false;
    private final boolean translogReadForward;
        return settings.getAsInt(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, null);
        1,  
            TieredMergePolicyProvider.INDEX_MERGE_POLICY_FLOOR_SEGMENT_SETTING,
     * a conservative default as it is sure to not cause trouble. Users can
    /**
        Property.Dynamic,  
        this.maxRetryOnLookupMapAcquisitionException = maxRetryOnLookupMapAcquisitionException;
 */
        DEFAULT_POLICY,
        Property.Dynamic,  
     * Returns the max result window for search requests, describing the maximum value of from + size on a query.
     * If this time is reached, we proceed with the commit based on segments merged up to that point. The merges are not
         * However, small thresholds are useful for testing so we do not add a large lower bound here.
    );  
            TieredMergePolicyProvider.INDEX_MERGE_POLICY_EXPUNGE_DELETES_ALLOWED_SETTING,  
        this.translogReadForward = INDEX_TRANSLOG_READ_FORWARD_SETTING.get(settings);  
    /**  
    }  
        scopedSettings.addSettingsUpdateConsumer(INDEX_TRANSLOG_BATCH_APPEND_MAX_SIZE_SETTING, this::setTranslogBatchAppendMaxSize);  
                TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.get(updatedSettings)
        CONCURRENT_SEGMENT_SEARCH_MODE_NONE,
    private void setGCDeletes(TimeValue timeValue) {  
 * license agreements. See the NOTICE file distributed with
    public int getMaxRegexLength() {
        Property.PrivateIndex,
                    + " has unsupported policy specified: "
    public void setDefaultSearchPipeline(String defaultSearchPipeline) {  
     * around  
        1,  
        1000,  
        DEFAULT_REFRESH_INTERVAL,
    /**
    public static final Setting<Integer> MAX_REFRESH_LISTENERS_PER_SHARD = Setting.intSetting(
     * Returns <code>true</code> if soft-delete is enabled.
    }  
    }  
                            mergePolicyProvider = logByteSizeMergePolicyProvider;  
        return requiredPipeline;  
        "index.search.concurrent_segment_search.partition_strategy",
    }  
        return isPluggableDataFormatEnabled() ? logByteSizeMergePolicyProvider : tieredMergePolicyProvider;  
     * Defaults to true which means unreferenced files will be cleaned up in case segment merge fails.  
     * Returns true if unreferenced files should be cleaned up on merge failure for this index.  
        this.retentionLeaseMillis = retentionLease.millis();
    private final Logger logger;  
        "index.searchable_snapshot.index.id",
        return remoteStorePathStrategy;  
     * The default value is 1 as this is default difference in NGramTokenizer,  
     */
        return allowDerivedField;
    /**  
    }
    private void setDerivedSourceEnabledForTranslog(boolean isDerivedSourceEnabledForTranslog) {
        Property.Dynamic,
            this::setDocIdFuzzySetFalsePositiveProbability
        true,  
    );  
     */
        );
    public void setRemoteTranslogUploadBufferInterval(TimeValue remoteTranslogUploadBufferInterval) {  
        scopedSettings.addSettingsUpdateConsumer(
     * {@code cluster.remote_store.flush_on_uncommitted_segments.enabled}. When this is not set on the index, the
    );
    }
        Property.IndexScope
    public static final TimeValue MINIMUM_REFRESH_INTERVAL = new TimeValue(-1, TimeUnit.MILLISECONDS);
    }  
    private volatile TimeValue periodicFlushInterval;  
    public static final Setting<Integer> MAX_SHINGLE_DIFF_SETTING = Setting.intSetting(
 * this file be licensed under the Apache-2.0 license or a
    );
    private void setMaxResultWindow(int maxResultWindow) {
}
        Property.Dynamic  
        }  
    public static final Setting<ByteSizeValue> INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING = Setting.byteSizeSetting(
    private volatile int streamingAggregationMinSegmentSize;
import java.util.Locale;
        scopedSettings.addSettingsUpdateConsumer(MergeSchedulerConfig.AUTO_THROTTLE_SETTING, mergeSchedulerConfig::setAutoThrottle);
        scopedSettings.addSettingsUpdateConsumer(INDEX_MAPPING_NESTED_DOCS_LIMIT_SETTING, this::setMappingNestedDocsLimit);
    }  
    public void setStarTreeIndexEnabled(boolean value) {  
        scopedSettings.addSettingsUpdateConsumer(
        /* There was unintentional breaking change got introduced with [OpenSearch-6424](https://github.com/opensearch-project/OpenSearch/pull/6424) (version 2.7).
        this.autoForcemergeEnabled = autoForcemergeEnabled;  
        if (logger.isTraceEnabled()) {
        this.indexMetadata = indexMetadata;
    /**  
    private final IndexScopedSettings scopedSettings;
        this.mappingDynamicPropertiesLuceneFieldLimit = value;
    @Deprecated  
        streamingAggregationMinSegmentSize = scopedSettings.get(FlushModeResolver.STREAMING_AGGREGATION_MIN_SEGMENT_SIZE_SETTING);
                break;
        );
    }
     */
     */  
            if (FeatureFlags.isEnabled(CONTEXT_AWARE_MIGRATION_EXPERIMENTAL_FLAG) == false && value == true) {  
        return numberOfShards;  
        "index.max_docvalue_fields_search",
        return ReplicationType.DOCUMENT.equals(replicationType);
        "index.search.concurrent_segment_search.enabled",
     *
    }  
     * the chance of ops based recoveries for indices with soft-deletes disabled.
     * @param nodeSettings  the nodes settings this index is allocated on.  
        "index.recovery.file_based_threshold",
        Property.Dynamic,
    );  
     * and is defensive as it prevents generating too many index terms.
        this.defaultAllowUnmappedFields = scopedSettings.get(ALLOW_UNMAPPED);  
        "indices.query.query_string.allowLeadingWildcard",  
        defaultSearchPipeline = scopedSettings.get(DEFAULT_SEARCH_PIPELINE);
     * Returns the max number of filters in adjacency_matrix aggregation search requests
        return flushAfterMergeThresholdSize;
     * setting has changed.
        }
        false,
 * the latest updated settings instance. Classes that need to listen to settings updates can register
     * This setting controls if unreferenced files will be cleaned up in case segment merge fails due to disk full.
    public void setDocIdFuzzySetFalsePositiveProbability(double docIdFuzzySetFalsePositiveProbability) {
        maxTermsCount = scopedSettings.get(MAX_TERMS_COUNT_SETTING);
            throw new IllegalArgumentException("uuid mismatch on settings update expected: " + getUUID() + " but was: " + newUUID);  
        periodicFlushInterval = scopedSettings.get(INDEX_PERIODIC_FLUSH_INTERVAL_SETTING);
    public static final Setting<Integer> INDEX_REMOTE_TRANSLOG_KEEP_EXTRA_GEN_SETTING = Setting.intSetting(
     *
    public boolean getStarTreeIndexEnabled() {
        this.flushAfterMergeThresholdSize = byteSizeValue;
    );
        "index.gc_deletes",
 * this work for additional information regarding copyright
     * This is a safeguard making sure that the translog deletion policy won't keep too many translog files especially when they're small.
            default:  
    }
        "index.search.idle.after",
     * Returns the transaction log threshold size when to forcefully flush the index and clear the transaction log.
            case "true":  
    }
        scopedSettings.addSettingsUpdateConsumer(StarTreeIndexSettings.STAR_TREE_SEARCH_ENABLED_SETTING, this::setStarTreeIndexEnabled);
     * first closes the chunk.
        scopedSettings.addSettingsUpdateConsumer(INDEX_MAPPING_DEPTH_LIMIT_SETTING, this::setMappingDepthLimit);
    );
    private volatile long mappingTotalFieldsLimit;
    }  
        new ByteSizeValue(64, ByteSizeUnit.MB),  
            // ignore the translog retention settings if soft-deletes enabled
        CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_SEGMENT,  
        1,  
    }
    /** Maximum operations per batched translog append; see {@link #INDEX_TRANSLOG_BATCH_APPEND_MAX_OPERATIONS_SETTING}. */
        return defaultAllowUnmappedFields;
                    throw new IllegalArgumentException("Setting value must be one of [all, none, auto]");
        scopedSettings.addSettingsUpdateConsumer(
     */
        Property.IndexScope  
    private volatile TimeValue syncInterval;  
            this::setStreamingAggregationMinSegmentSize
     */  
     */  
    public static final Setting<ByteSizeValue> INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING = Setting  
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
        derivedSourceEnabled = scopedSettings.get(INDEX_DERIVED_SOURCE_SETTING) || pluggableDataFormatEnabled;
     */
        PathType.FIXED.toString(),
     * Maximum number of operations one batched translog append may carry. A shard bulk request larger than this is
import org.apache.lucene.index.MergePolicy;
    }  
        return maxRetryOnLookupMapAcquisitionException;  
    public static final Setting<Double> INDEX_DOC_ID_FUZZY_SET_FALSE_POSITIVE_PROBABILITY_SETTING = Setting.doubleSetting(  
    /**  
            logger.trace("Index: " + this.index.getName() + ", Merge policy used: " + mergePolicyProvider);
            tieredMergePolicyProvider::setNoCFSRatio
         */  
    /**
        settings -> shouldDisableTranslogRetention(settings) ? TimeValue.MINUS_ONE : TimeValue.timeValueHours(12),  
/*  
        1000000,
        return nodeSettings;  
        scopedSettings.addSettingsUpdateConsumer(MAX_REFRESH_LISTENERS_PER_SHARD, this::setMaxRefreshListeners);  
    /**
    public int getMaxRefreshListeners() {
    );  
    }
        IngestService.NOOP_PIPELINE_NAME,
        assert shouldDisableTranslogRetention(settings) == false || translogRetentionAge.millis() == -1L : translogRetentionSize;  
        return pluggedDataFormat;  
    }  
            INDEX_PUBLISH_REFERENCED_SEGMENTS_INTERVAL_SETTING,  
    private int remoteTranslogKeepExtraGen;
     * the maximum difference between  
        1,
        IndexMergePolicy::fromString,
         * below this, the flush thread can get stuck in an infinite loop repeatedly  
        this.replicationType = IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.get(newSettings);
        TimeValue.timeValueMillis(100),
        this.maxTokenCount = maxTokenCount;
    /**  
        Property.Dynamic,
    public String getRequiredPipeline() {
        return remoteStoreTranslogRepository != null && remoteStoreTranslogRepository.isEmpty() == false;
     */  
    private final boolean defaultAllowUnmappedFields;  
    @Deprecated
import org.opensearch.common.logging.Loggers;  
    /**
    void setDefaultAutoThrottleEnabled(boolean enabled) {  
    }
        Property.Dynamic,  
         * to higher bytes size like integer to long. This behavior was changed from OpenSearch 2.7 version not to
     * {@code cluster.remote_store.flush_on_uncommitted_segments.threshold_size} — see  
    public boolean isQueryStringLenient() {  
        this.queryStringLenient = QUERY_STRING_LENIENT_SETTING.get(settings);  
    public static final Setting<Integer> MAX_ANALYZED_OFFSET_SETTING = Setting.intSetting(
    );
        "",
        setMergeOnFlushPolicy(scopedSettings.get(INDEX_MERGE_ON_FLUSH_POLICY));
     * <p>
    private static final String MERGE_ON_FLUSH_MERGE_POLICY = "merge-on-flush";
            INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING,
        Property.IndexScope
     * {@code index.periodic_flush_interval} (disabled by default) for a wall-clock flush backstop.
        scopedSettings.addSettingsUpdateConsumer(
    public TimeValue getSearchIdleAfter() {
     */  
            this::setMappingDynamicPropertiesLuceneFieldLimit
    }  
    );
    /**
    }
    public int getMaxSlicesPerPit() {
    public TimeValue getTranslogRetentionAge() {
            && left.filter(IndexScopedSettings.ARCHIVED_SETTINGS_KEY_PREDICATE)
        this.mappingNestedDocsLimit = value;
        return this.maxAnalyzedOffset;
    public static final Setting<Integer> MAX_DOCVALUE_FIELDS_SEARCH_SETTING = Setting.intSetting(  
    /**
    private volatile IndexMetadata indexMetadata;
     */
        "index.optimize_doc_id_lookup.fuzzy_set.false_positive_probability",
    );
    private void setMaxRetryOnLookupMapAcquisitionException(int maxRetryOnLookupMapAcquisitionException) {
        Property.IndexScope
import org.opensearch.core.index.Index;
        this.mappingDepthLimit = value;  
        IndexMergePolicy::fromString,  
    }  
            );
     * Returns true iff the refresh setting exists or in other words is explicitly set.
        final String newUUID = newSettings.get(IndexMetadata.SETTING_INDEX_UUID, IndexMetadata.INDEX_UUID_NA_VALUE);
        assert shouldDisableTranslogRetention(settings) == false || translogRetentionSize.getBytes() == -1L : translogRetentionSize;  
    /**
    public String pluggableDataFormat() {
    /**
    /**  
    /**
    public ByteSizeValue getTranslogBatchAppendMaxSize() {
        "index.auto_force_merge.enabled",  
     * Returns the maximum number of allowed docvalue_fields to retrieve in a search request
            "index.remote_store.flush_on_uncommitted_segments.threshold_size",
        Property.IndexScope  
         * For indices created prior version (prior to 2.7) which has IndexSort type, they used to type cast the SortField.Type  
     * Controls whether translog operations are read in forward order (oldest to newest) or backward order (newest to oldest).  
        publishReferencedSegmentsInterval = INDEX_PUBLISH_REFERENCED_SEGMENTS_INTERVAL_SETTING.get(settings);  
    public static final Setting<Integer> MAX_RESCORE_WINDOW_SETTING = Setting.intSetting(
            this::setTranslogBatchAppendMaxOperations
        Setting.Property.IndexScope,
    public static final Setting<Integer> MAX_SLICES_PER_PIT = Setting.intSetting(
     * Returns <code>true</code> if the query string parser should allow leading wildcards. The default is <code>true</code>  
     * This setting is realtime updateable
     * because they both do the same thing: control the size of the heap of hits.  
     */
            enabled,
     * Returns true if we need to maintain backward compatibility for index sorted indices created prior to version 2.7
            TieredMergePolicyProvider.INDEX_COMPOUND_FORMAT_SETTING,
     * Returns the index sort config that should be used for this index.  
     * per search request. The default maximum of 100 is defensive for the reason that retrieving  
    );
    private final Index index;
        contextAwareEnabled = scopedSettings.get(INDEX_CONTEXT_AWARE_ENABLED_SETTING);  
            // nothing to update, same settings
    public static final Setting<ByteSizeValue> INDEX_FLUSH_AFTER_MERGE_THRESHOLD_SIZE_SETTING = Setting.byteSizeSetting(
    private void setMappingNestedDocsLimit(long value) {
    /**  
            }  
        scopedSettings.addSettingsUpdateConsumer(INDEX_MERGE_ON_FLUSH_ENABLED, this::setMergeOnFlushEnabled);
    public static final String CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY_SEGMENT = "segment";  
    public static final Setting<Integer> MAX_INNER_RESULT_WINDOW_SETTING = Setting.intSetting(  
        Property.IndexScope,
        new ByteSizeValue(Translog.DEFAULT_HEADER_SIZE_IN_BYTES + 1, ByteSizeUnit.BYTES),
        return INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.exists(settings);  
            MergeSchedulerConfig.AUTO_THROTTLE_SETTING.exists(getSettings()) == false
            logByteSizeMergePolicyProvider::setLBSMergeFactor
        scopedSettings.addSettingsUpdateConsumer(DEFAULT_PIPELINE, this::setDefaultPipeline);
        "index.translog.batch_append.enabled",  
        this.remoteStoreRepository = remoteStoreRepository;  
     * Default is false (backward reading), which is the traditional behavior that naturally handles sequence number collisions
                    mergePolicyProvider = defaultMergePolicyProvider();
    private void setTranslogRetentionSize(ByteSizeValue byteSizeValue) {
        this.maxShingleDiff = maxShingleDiff;  
     */
     */
        DEFAULT_FALSE_POSITIVE_PROBABILITY,
    }
import org.opensearch.indices.replication.common.ReplicationType;
    /**
     * Returns if object-store-backed primary fencing is enabled for this index.  
 * It's created per index and available to all index level classes and allows them to retrieve  
    }  
            LogByteSizeMergePolicyProvider.INDEX_LBS_MERGE_POLICY_MIN_MERGE_SETTING,
    public long getMappingDynamicPropertiesLuceneFieldLimit() {
    }
    private void setTranslogFlushThresholdSize(ByteSizeValue byteSizeValue) {  
    public MergePolicy getMergePolicy(boolean isTimeSeriesIndex) {
        } else if (MERGE_ON_FLUSH_MERGE_POLICY.equalsIgnoreCase(policy)) {
    /**  
    private volatile int maxAnalyzedOffset;  
     * Defaults to retaining history for up to 10% of the documents in the shard. This can only be changed in tests, since this setting is
        Property.Dynamic,
         * An empty translog occupies 55 bytes on disk. If the flush threshold is below this, the flush thread  
 * Licensed to Elasticsearch under one or more contributor  
        return maxSlicesPerPit;  
    /**
    /**
 */
import static org.opensearch.index.mapper.MapperService.INDEX_MAPPING_NESTED_FIELDS_LIMIT_SETTING;
    }
        return isTranslogMetadataEnabled;
    private final RemoteStorePathStrategy remoteStorePathStrategy;
    }
            logger.warn("Search idle is not supported for indices with replicas using 'replication.type: SEGMENT'");
     */
        Property.IndexScope,
        return pluggableDataFormatEnabled;
     * doc values might incur a per-field per-document seek.
        Property.Dynamic,
        setTranslogRetentionAge(scopedSettings.get(INDEX_TRANSLOG_RETENTION_AGE_SETTING));
            this::setFlushOnUncommittedSegmentsThresholdSize
    public String getDefaultPipeline() {  
         * up cast the SortField to gain some sort query optimizations.
    public static final Setting<Boolean> INDEX_SEARCH_THROTTLED = Setting.boolSetting(
    /**
        2,
                mergePolicyProvider = logByteSizeMergePolicyProvider;
    );  
     */  
     * Index setting describing for NGramTokenizer and NGramTokenFilter
     * The maximum number of slices allowed in a search request with PIT  
        this.durability = durability;
    private final boolean isRemoteStoreFencingEnabled;  
        "indices.query.query_string.analyze_wildcard",
    /**
        maxDocvalueFields = scopedSettings.get(MAX_DOCVALUE_FIELDS_SEARCH_SETTING);
        maxInnerResultWindow = scopedSettings.get(MAX_INNER_RESULT_WINDOW_SETTING);
    private void setTranslogBatchAppendMaxOperations(int maxOperations) {  
     * This setting is only applicable when highlighting is requested on a text that was indexed without  
        scopedSettings.addSettingsUpdateConsumer(  
        Property.IndexScope
        Property.Dynamic,
        "index.max_script_fields",
     */
        Property.Dynamic,
     * If soft-deletes is enabled, an engine by default will retain all operations up to the global checkpoint.  
        setEnableFuzzySetForDocId(scopedSettings.get(INDEX_DOC_ID_FUZZY_SET_ENABLED_SETTING));
    private void setMergeOnFlushPolicy(String policy) {
    }  
    public <T> T getValue(Setting<T> setting) {  
        scopedSettings.addSettingsUpdateConsumer(
    private volatile long retentionLeaseMillis;
        // the MergeSchedulerConfig, but we only update the actual values when an index level setting is not present
     */
     */
        100,
        this.maxSlicesPerPit = value;
    private volatile String remoteStoreRepository;  
        this.refreshInterval = timeValue;
        final Settings newIndexSettings = Settings.builder().put(nodeSettings).put(newSettings).build();
     */
    private final Version version;
    }
            this.value = value;
    }
        scopedSettings.addSettingsUpdateConsumer(MAX_INNER_RESULT_WINDOW_SETTING, this::setMaxInnerResultWindow);
            logger.warn("Search idle is not supported for remote backed indices");
    );
        this.streamingAggregationMinSegmentSize = streamingAggregationMinSegmentSize;
    public int getMaxDocvalueFields() {
        Setting.Property.IndexScope
        mappingTotalFieldsLimit = scopedSettings.get(INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING);
        this.maxAnalyzedOffset = maxAnalyzedOffset;
        "index.highlight.max_analyzed_offset",  
     * index settings and the node settings where node settings are overwritten by index settings.  
    public boolean isSearchThrottled() {  
        Property.IndexScope  
        // Upon updates to the cluster default settings, we always update the cached default values in
        settings -> shouldDisableTranslogRetention(settings) ? "-1" : "512MB",  
     * and number of top hits buckets returned is unbounded. Profile your cluster when increasing this setting.
        scopedSettings.addSettingsUpdateConsumer(
    private final boolean assignedOnRemoteNode;  
    /**  
import org.opensearch.ingest.IngestService;
        10000,
        this.maxAdjacencyMatrixFilters = maxAdjacencyFilters;
    public boolean isDefaultAllowUnmappedFields() {  
        return publishReferencedSegmentsInterval;
        0,
/*
        DEFAULT_POLICY,
    public IndexSettings(final IndexMetadata indexMetadata, final Settings nodeSettings) {  
     * offsets or term vectors.
     * For pull-based ingestion indices, this defaults to 10 minutes to ensure offsets are regularly committed.
        return remoteStoreSegmentPathPrefix;  
    public static final Setting<Long> INDEX_CONTEXT_CREATED_VERSION = Setting.longSetting(
     * Is fuzzy set enabled for doc id
     * This setting will be ignored if soft-deletes is used in peer recoveries (default in 7.4).
     * Returns the number of shards this index has.  
    private volatile boolean allowDerivedField;  
            return DEFAULT_PERIODIC_FLUSH_INTERVAL;
        DEFAULT_GC_DELETES,  
        Property.IndexScope,
        translogBatchAppendMaxSize = scopedSettings.get(INDEX_TRANSLOG_BATCH_APPEND_MAX_SIZE_SETTING);
     * Returns true iff {@code index.remote_store.flush_on_uncommitted_segments.threshold_size} exists or in other  
 * @opensearch.api
            this::setRemoteStoreRepository
import org.opensearch.node.Node;  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MIN_SLICE_COUNT_VALUE;
        Property.Dynamic,
        Property.NodeScope  
        Property.Final
    public boolean isCompositeIndex() {
    public int getMaxTokenCount() {  
        return this.maxAdjacencyMatrixFilters;
            IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING,
    public boolean isAssignedOnRemoteNode() {  
        "index.soft_deletes.enabled",
    }  
        Function.identity(),  
    public boolean isContextAwareEnabled() {  
     * by prioritizing operations from newer generations.
        return mergePolicyProvider.getMergePolicy();
        Property.IndexScope,
    private void setFlushOnUncommittedSegmentsThresholdSize(ByteSizeValue flushOnUncommittedSegmentsThresholdSize) {
        maxSlicesPerScroll = scopedSettings.get(MAX_SLICES_PER_SCROLL);
     * Controls the number of translog files that are no longer needed for persistence reasons will be kept around before being deleted.  
    /**
                "The "  
        Property.IndexScope,
        scopedSettings.addSettingsUpdateConsumer(INDEX_TRANSLOG_SYNC_INTERVAL_SETTING, this::setTranslogSyncInterval);
    private void setMaxRefreshListeners(int maxRefreshListeners) {
        mergeSchedulerConfig = new MergeSchedulerConfig(this);  
        retentionLeaseMillis = scopedSettings.get(INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING).millis();
            throw new IllegalArgumentException("uuid mismatch on settings update expected: " + restoreUUID + " but was: " + newRestoreUUID);
     */  
     **/  
    private volatile boolean derivedSourceEnabledForTranslog;
    }
    /**
     * This setting will be ignored if soft-deletes is used in peer recoveries (default in 7.4).
     * Low-throughput trickle workloads that never cross the byte threshold and never go idle can additionally enable  
    public boolean isFlushOnUncommittedSegmentsThresholdSizeExplicit() {  
        Property.Dynamic
     * Returns the {@link MergeSchedulerConfig}  
    public static final Setting<String> SEARCHABLE_SNAPSHOT_ID_NAME = Setting.simpleString(  
     * Returns true iff the remote translog buffer interval setting exists or in other words is explicitly set.  
     * the chance of ops based recoveries for indices with soft-deletes disabled.  
        }
        this.defaultSearchPipeline = defaultSearchPipeline;
     * Returns the max result window for an individual inner hit definition or top hits aggregation.  
    /**
        Property.IndexScope
     * The maximum number of slices allowed in a scroll request.
    }
            case DEFAULT_POLICY:  
        Property.InternalIndex  
        }
        "index.search.concurrent.max_slice_count",
        return flushOnUncommittedSegmentsThresholdSize;
    public static final Setting<Integer> MAX_NGRAM_DIFF_SETTING = Setting.intSetting(  
        }  
    public boolean isWarmerEnabled() {
            Property.IndexScope
        this.maxNestedQueryDepth = maxNestedQueryDepth;  
     */
            DEFAULT_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE,  
        translogBatchAppendEnabled = scopedSettings.get(INDEX_TRANSLOG_BATCH_APPEND_ENABLED_SETTING);  
        "index.periodic_flush_interval",  
        if (shouldDisableTranslogRetention(settings) && byteSizeValue.getBytes() >= 0) {  
         * do not add a large lower bound here.  
        this.maxInnerResultWindow = maxInnerResultWindow;
            logByteSizeMergePolicyProvider::setLBSMaxMergeDocs
     * and no in-sync copies are available, we force-allocate this recovering replica as primary.
    private final String pluggedDataFormat;  
                            mergePolicyProvider = tieredMergePolicyProvider;  
        "index.search.concurrent_segment_search.mode",
        } else {
    }
    private final boolean contextAwareEnabled;
     */
    }
        Property.IndexScope
    }  
        defaultFields = scopedSettings.get(DEFAULT_FIELD_SETTING);
    private volatile int maxResultWindow;
    /**  
    public static final Setting<String> INDEX_CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY = Setting.simpleString(
     * the maximum difference between
     * Index setting describing the maximum number of terms that can be used in Terms Query.
 * specific language governing permissions and limitations
        Property.Dynamic,  
    }
        maxRefreshListeners = scopedSettings.get(MAX_REFRESH_LISTENERS_PER_SHARD);  
 *
        false,
        "index.translog.retention.age",
    }  
     * @param indexMetadata the index metadata this settings object is associated with
    public RemoteStorePathStrategy getRemoteStorePathStrategy() {
                    + " setting is disabled"
        },
    );
    public boolean shouldWidenIndexSortType() {  
     * per search request. The default maximum of 32 is defensive for the reason that retrieving
    /**
        this.searchThrottled = INDEX_SEARCH_THROTTLED.get(settings);
        Property.Dynamic,  
        CONCURRENT_SEGMENT_SEARCH_MIN_SLICE_COUNT_VALUE,  
     * Index setting describing the maximum value of from + size on an individual inner hit definition or
     */  
        Property.IndexScope,
    );  
        );  
     */
     * Returns the version the index was created on.
     *
    public static final Setting<Boolean> INDEX_WARMER_ENABLED_SETTING = Setting.boolSetting(
    /**
    private volatile int maxTermsCount;
            tieredMergePolicyProvider.setMaxMergesAtOnceToDefault();
     * A setting describing the maximum number of characters that will be analyzed for a highlight request.
        return remoteStoreRepository;
    public boolean isRemoteTranslogBufferIntervalExplicit() {
     */
     */
     * remote-store shards.
    public long getMappingFieldNameLengthLimit() {  
        }  
    private volatile Translog.Durability durability;
        return checkPendingFlushEnabled;
    public ByteSizeValue getGenerationThresholdSize() {
     * The default value is 3 is defensive as it prevents generating too many tokens.  
        new TimeValue(-1, TimeUnit.MILLISECONDS),
        Property.IndexScope  
     * @deprecated This setting will be removed in 8.0
     * Returns the transaction log retention size which controls how much of the translog is kept around to allow for ops based recoveries  
    }
                            mergePolicyProvider = defaultMergePolicyProvider();  
        this.isStarTreeIndexEnabled = value;
    // Partition strategy constants
    public IndexMetadata getIndexMetadata() {
     * Returns the indexes UUID
            logByteSizeMergePolicyProvider::setLBSMinMergedMB
    private final boolean checkPendingFlushEnabled;  
                } else {  
        this.flushOnUncommittedSegmentsThresholdSize = flushOnUncommittedSegmentsThresholdSize;
    /**
        new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES),  
        refreshInterval = scopedSettings.get(INDEX_REFRESH_INTERVAL_SETTING);
        new ByteSizeValue(1, ByteSizeUnit.MB),  
        this.indexMetadata = indexMetadata;
    private volatile ByteSizeValue flushThresholdSize;
    private boolean autoForcemergeEnabled;  
    private void setMappingTotalFieldsLimit(long value) {  
    );
        /*
            switch (value) {
    /**
        "index.max_slices_per_pit",  
    /**
    /**  
     * certainly profile their cluster and decide to set it to 100,000
    public boolean shouldCleanupUnreferencedFiles() {
    private void setMaxScriptFields(int maxScriptFields) {
        );  
        0,
    private volatile int maxShingleDiff;
        maxScriptFields = scopedSettings.get(MAX_SCRIPT_FIELDS_SETTING);
    public static final Setting<Integer> INDEX_MAX_RETRY_ON_LOOKUP_MAP_LOCK_ACQUISITION_EXCEPTION = Setting.intSetting(  
     * @param indexMetadata the index metadata this settings object is associated with  
        this.softDeleteRetentionOperations = ops;
    }
import java.util.concurrent.TimeUnit;
        Property.Dynamic,
    private final TieredMergePolicyProvider tieredMergePolicyProvider;
    }
 */  
    /** Maximum serialized bytes per batched translog append; see {@link #INDEX_TRANSLOG_BATCH_APPEND_MAX_SIZE_SETTING}. */
        Property.IndexScope
        return syncInterval;  
import org.opensearch.core.common.Strings;
    }  
        if (Strings.isEmpty(policy) || DEFAULT_POLICY.equalsIgnoreCase(policy)) {  
    public static final Setting<String> SEARCHABLE_SNAPSHOT_ID_UUID = Setting.simpleString(  
    }  
        "index.search.default_pipeline",  
        flushAfterMergeThresholdSize = scopedSettings.get(INDEX_FLUSH_AFTER_MERGE_THRESHOLD_SIZE_SETTING);
     * The maximum length of regex string allowed in a regexp query.
     * Returns the maximum allowed difference between max and min length of ngram  
                mergePolicyProvider = tieredMergePolicyProvider;
     */
        return refreshInterval;
        scopedSettings.addSettingsUpdateConsumer(INDEX_TRANSLOG_RETENTION_SIZE_SETTING, this::setTranslogRetentionSize);  
        scopedSettings.addSettingsUpdateConsumer(  
    }
        Property.IndexScope  
    public boolean isTranslogMetadataEnabled() {  
        this.queryStringAllowLeadingWildcard = QUERY_STRING_ALLOW_LEADING_WILDCARD.get(nodeSettings);
        scopedSettings.addSettingsUpdateConsumer(  
        Property.Dynamic  
        return getIndex().getUUID();
     */
        .byteSizeSetting(
        );
        Property.Dynamic  
        flushThresholdSize = scopedSettings.get(INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING);  
    /**
    public TimeValue getTranslogSyncInterval() {
        return translogBatchAppendMaxSize;  
        "index.translog.durability",
     */
import org.opensearch.index.remote.RemoteStoreEnums.PathType;  
    }
        Property.Final
        new ByteSizeValue(512, ByteSizeUnit.MB),  
    );  
    /**
        1_000,
     * Specifies if the index should use soft-delete instead of hard-delete for update/delete operations.
            INDEX_TRANSLOG_BATCH_APPEND_MAX_OPERATIONS_SETTING,  
    }  
    /**  
    );  
 * SPDX-License-Identifier: Apache-2.0
    private volatile boolean isStarTreeIndexEnabled;
    }
    private void setTranslogBatchAppendEnabled(boolean enabled) {  
                    switch (nodeMergePolicy) {
    private volatile boolean isRemoteStoreEnabled;
    public static final Setting<TimeValue> INDEX_TRANSLOG_SYNC_INTERVAL_SETTING = Setting.timeSetting(
        Property.Deprecated  
        this.warmerEnabled = enableWarmer;
import org.apache.logging.log4j.Logger;  
import java.util.Collections;  
     */  
        DEFAULT_POLICY,
     */
