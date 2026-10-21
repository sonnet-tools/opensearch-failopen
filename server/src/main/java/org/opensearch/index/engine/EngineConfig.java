        public Builder checksumStrategies(Map<String, FormatChecksumStrategy> checksumStrategies) {
        }
            .warmer(this.warmer)
                }
import java.util.Map;
    }
     * </p>
     *     time ({@link IndexSettings#getGcDeletesInMillis()} if enabled. Before deletes are GCed they will cause re-adding the document
    @Nullable
                : DefaultPrimaryOperationPolicy.INSTANCE;
        this.tombstoneDocSupplier = builder.tombstoneDocSupplier;
    public TranslogConfig getTranslogConfig() {
 * compatible open source license.
        return this.leafSorter;
     * Returns the policy describing how a writable primary sources sequence numbers and plans
        this.indexSort = builder.indexSort;
    public Builder toBuilder() {
import org.opensearch.threadpool.ThreadPool;
    /**
            case "zlib":
        "index.optimize_auto_generated_id",
        // We need to make the indexing buffer for this shard at least as large
            });
        }
                }
        public Builder retentionLeasesSupplier(Supplier<RetentionLeases> retentionLeasesSupplier) {
        return codecService.codec(codecName);
        ParsedDocument newNoopTombstoneDoc(String reason);
    public Supplier<RetentionLeases> retentionLeasesSupplier() {
     */
     */
    public boolean useCompoundFile() {
    public Engine.Warmer getWarmer() {
     */
     * Returns the global checkpoint tracker
                            return s;
    }
    }
    /**
    public DocumentMetadataResolver getDocumentMetadataResolver() {
        return this.dataFormatRegistry;
                }
            return this;
    public LongSupplier getPrimaryTermSupplier() {
    @PublicApi(since = "1.0.0")
import org.opensearch.index.mapper.ParsedDocument;
     * Returns subReaderSorter for org.apache.lucene.index.BaseCompositeReader.
        return translogFactory;
            case "default":
        private DocumentLookupProvider documentLookupProvider;
        }
            this.isReadOnlyReplica = isReadOnlyReplica;
        }
    }
            return this;
        private MergedSegmentTransferTracker mergedSegmentTransferTracker;
        return shardId;
     *
            return this;
     * re-reads it only from {@link Engine#refreshPrimaryOperationPolicy()}, which the shard invokes
        private Map<String, FormatChecksumStrategy> checksumStrategies = Collections.emptyMap();
        private Supplier<RetentionLeases> retentionLeasesSupplier;
        private BooleanSupplier startedPrimarySupplier;
        // IndexingMemoryController rather than Lucene.
 * Holds all the configuration that is used to create an {@link Engine}.
        switch (s) {
    }
     *     Note: this settings is only read on startup.
            this.dataFormatRegistry = dataFormatRegistry;
     * Return the cache to use for queries.
                        return;
            default:
        public Builder queryCachingPolicy(QueryCachingPolicy queryCachingPolicy) {
     */
    private final Supplier<DocumentMapperForType> documentMapperForTypeSupplier;
    }
            case "zlib":
         * Creates a tombstone document for a delete operation.
     * Builder for EngineConfig class
        }
    }
import org.apache.lucene.search.ReferenceManager;
import org.opensearch.core.index.shard.ShardId;
        private TranslogFactory translogFactory = new InternalTranslogFactory();
    @Nullable
    private final Engine.EventListener eventListener;
        // TODO: Remove this escape hatch in 8.x
            .circuitBreakerService(this.circuitBreakerService)
     * Return the sort order of this index, or null if the index has no sort.
    }
        return this.mapperService;
        public Builder primaryOperationPolicySupplier(@Nullable Supplier<PrimaryOperationPolicy> primaryOperationPolicySupplier) {
     */
    /**
    /**
    private final Store store;
            this.translogDeletionPolicyFactory = translogDeletionPolicyFactory;
        final String escapeHatchProperty = "opensearch.index.memory.max_index_buffer_size";
     */
        this.similarity = builder.similarity;
    private final CommitterFactory committerFactory;
     * Returns the {@link org.opensearch.index.store.Store} instance that provides access to the
        this.shardId = builder.shardId;
            this.mergePolicy = mergePolicy;
        return this.documentMetadataResolver;
        if (builder.isReadOnlyReplica && builder.indexSettings.isSegRepEnabledOrRemoteNode() == false) {
            return this;
    private final boolean isReadOnlyReplica;
    private final Analyzer analyzer;
    /**
    }
        this.mergePolicy = builder.mergePolicy;
     */
            return this;
    private final ByteSizeValue indexingBufferSize;
                        throw new IllegalArgumentException("Codec should be of string type.");
     * Returns the {@link org.apache.lucene.search.similarities.Similarity} used for indexing and searching.
    );
            .documentMapperForTypeSupplier(this.documentMapperForTypeSupplier)
        this.isReadOnlyReplica = builder.isReadOnlyReplica;
        }
    private final TranslogFactory translogFactory;
import org.opensearch.common.unit.MemorySizeValue;
import org.opensearch.index.codec.CodecSettings;
    private static void doValidateCodecSettings(final String codec) {
        public Builder queryCache(QueryCache queryCache) {
     * The refresh listeners to add to Lucene for externally visible refreshes
     * {@link org.apache.lucene.store.Directory} used for the engines {@link org.apache.lucene.index.IndexWriter} to write it's index files
    }
                    }
    }
            .mergedSegmentTransferTracker(this.mergedSegmentTransferTracker)
        return primaryTermSupplier;
        this.documentLookupProvider = builder.documentLookupProvider;
    }
     * of a single engine. Callers must therefore treat the result as a snapshot and only re-read it at
 * object will affect the {@link Engine} instance.
        public Builder shardId(ShardId shardId) {
    }
    /**
                );
     * to.
        @Nullable
        }
                    }
        default ParsedDocument newDeleteTombstoneDoc(String id, String routing) {
        private QueryCachingPolicy queryCachingPolicy;
    private final ThreadPool threadPool;
    private final List<ReferenceManager.RefreshListener> externalRefreshListener;
    @Nullable
    }
        return similarity;
import org.opensearch.common.annotation.ExperimentalApi;
    @Nullable
    /**
    private final CodecService codecService;
     * The refresh listeners to add to Lucene for internally visible refreshes. These listeners will also be invoked on external refreshes
    }
import org.apache.lucene.analysis.Analyzer;
    public IndexWriter.IndexReaderWarmer getIndexReaderWarmer() {
            return this;
        private IndexWriter.IndexReaderWarmer indexReaderWarmer;
         */
     */
    public IndexSettings getIndexSettings() {
    private final DocumentLookupProvider documentLookupProvider;
    /**
        }
 * the Apache License, Version 2.0 (the "License"); you may
    public BooleanSupplier getStartedPrimarySupplier() {
        return flushMergesAfter;
                    Codec codec = Codec.forName(codecName);
                        && codecSettings.supports(INDEX_CODEC_COMPRESSION_LEVEL_SETTING)) {
    }
        this.primaryOperationPolicySupplier = builder.primaryOperationPolicySupplier != null
                    }
 * Unless required by applicable law or agreed to in writing,
            .clusterApplierService(this.clusterApplierService)
         * when the shard becomes a primary. A {@code null} value selects
        this.translogDeletionPolicyFactory = builder.translogDeletionPolicyFactory;
    @ExperimentalApi
    private final QueryCachingPolicy queryCachingPolicy;
 * You may obtain a copy of the License at
     * This setting is <b>not</b> realtime updateable.
    /**
     * Returns the MergedSegmentTransferTracker instance.
        // Add an escape hatch in case this change proves problematic - it used
    }
        }
        private QueryCache queryCache;
            return this;
        // to be a fixed amound of RAM: 256 MB.
    private final Supplier<RetentionLeases> retentionLeasesSupplier;
    private final DataFormatRegistry dataFormatRegistry;
        true,
import org.opensearch.index.merge.MergedSegmentTransferTracker;
    @Nullable
            return this;
        Property.IndexScope
        /**
        this.internalRefreshListener = builder.internalRefreshListener;
    private final MergePolicy mergePolicy;
     */
 * SPDX-License-Identifier: Apache-2.0
    }
        }
            this.retentionLeasesSupplier = retentionLeasesSupplier;
    public boolean isEnableGcDeletes() {
    public static final Setting<Boolean> INDEX_OPTIMIZE_AUTO_GENERATED_IDS = Setting.boolSetting(
        }
    private final QueryCache queryCache;
         * selects {@link DefaultPrimaryOperationPolicy}, which reproduces the standard behavior.
    }
        this.checksumStrategies = builder.checksumStrategies;
        return mergePolicy;
    }
            .threadPool(this.threadPool)
import org.apache.lucene.index.LeafReader;
     * if the shard is a primary/replica.
     */
    /**
    /**
    public TombstoneDocSupplier getTombstoneDocSupplier() {
            this.circuitBreakerService = circuitBreakerService;
    private final TranslogConfig translogConfig;
            this.flushMergesAfter = flushMergesAfter;
     * <p>
    }
     * returns true if the engine is allowed to optimize indexing operations with an auto-generated ID
    /**
        public Builder globalCheckpointSupplier(LongSupplier globalCheckpointSupplier) {
         */
import java.util.List;
        /**
            return this;
import org.opensearch.index.seqno.RetentionLeases;
            return this;
    public LongSupplier getGlobalCheckpointSupplier() {
     */
         * <p>
            .startedPrimarySupplier(this.startedPrimarySupplier)
            return this;
     * Creates a new {@link org.opensearch.index.engine.EngineConfig}
     * The returned document consists only _uid, _seqno, _term and _version fields; other metadata fields are excluded.
        private TranslogDeletionPolicyFactory translogDeletionPolicyFactory;
                        }
        private TranslogConfig translogConfig;
        }
    public ByteSizeValue getIndexingBufferSize() {
     * should be automatically flushed. This is used to free up transient disk usage of potentially large segments that
     */
    private final String codecName;
            .primaryTermSupplier(this.primaryTermSupplier)
        private Similarity similarity;
            return Set.of(new SettingDependency() {
        private DataFormatRegistry dataFormatRegistry;
     * it's reference until it's not needed anymore.
    /**
        public Builder startedPrimarySupplier(BooleanSupplier startedPrimarySupplier) {
        Comparator<LeafReader> leafSorter;
    }
import java.util.function.Supplier;
        new Setting.IntegerParser(1, 6, "index.codec.compression_level", false),
     *     that was deleted to fail.
     * <p>
     * Returns the analyzer as the default analyzer in the engines {@link org.apache.lucene.index.IndexWriter}
            case "best_compression":
        return enableGcDeletes;
        private Supplier<PrimaryOperationPolicy> primaryOperationPolicySupplier;
            this.similarity = similarity;
    public Store getStore() {
        // local node so that decisions to flush segments to disk are made by
                ? primaryOperationPolicy
        private List<ReferenceManager.RefreshListener> externalRefreshListener;
    public boolean isReadOnlyReplica() {
     * Enables / disables gc deletes
        this.mergedSegmentTransferTracker = builder.mergedSegmentTransferTracker;
            return this;
import java.util.function.LongSupplier;
        private Supplier<DocumentMapperForType> documentMapperForTypeSupplier;
        this.primaryTermSupplier = builder.primaryTermSupplier;
        public Builder documentMetadataResolver(@Nullable DocumentMetadataResolver documentMetadataResolver) {
    public static final Setting<String> INDEX_CODEC_SETTING = new Setting<>("index.codec", "default", s -> {
    /**
import java.util.Comparator;
     * Returns the underlying translog factory
 *
         * construction until the engine is replaced.
    private final IndexWriter.IndexReaderWarmer indexReaderWarmer;
            this.tombstoneDocSupplier = tombstoneDocSupplier;
import org.opensearch.index.store.FormatChecksumStrategy;
 *
     * This gets used in lucene IndexReader and decides order of segment read.
            return this;
     * async force merge calls on the {@link org.opensearch.threadpool.ThreadPool.Names#FORCE_MERGE} thread-pool
    }
        return threadPool;
     * <p>
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
            return primaryOperationPolicySupplier(() -> policy);
     * soft deleted should be retained.
    public Map<String, FormatChecksumStrategy> getChecksumStrategies() {
            case "lucene_default":
import org.opensearch.index.mapper.MapperService;
        }
     */
         */
     * A supplier of the outstanding retention leases. This is used during merged operations to determine which operations that have been
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
         * Creates a tombstone document for a noop operation.
            .indexSettings(this.indexSettings)
        }
    /**
import org.opensearch.index.translog.TranslogFactory;
            : () -> DefaultPrimaryOperationPolicy.INSTANCE;
    }
        final PrimaryOperationPolicy policy = this.primaryOperationPolicySupplier.get();
import org.opensearch.index.mapper.DocumentMapperForType;
     *     Engine GC deletion if enabled collects deleted documents from in-memory realtime data structures after a certain amount of
            .queryCachingPolicy(this.queryCachingPolicy)
    }
            return this;
        public Builder indexSettings(IndexSettings indexSettings) {
    /**
        return this.documentLookupProvider;
        this.retentionLeasesSupplier = Objects.requireNonNull(builder.retentionLeasesSupplier);
        return warmer;
    }
                                return;
/*
     * @return true if this engine should be wired as read only.
                        if (availableCodecWithAlias.aliases().contains(codec)) {
        return translogDeletionPolicyFactory;
        @ExperimentalApi
            .dataFormatRegistry(this.dataFormatRegistry)
     * The default is <code>true</code>
        }
     */
import org.apache.lucene.search.QueryCache;
        public Builder externalRefreshListener(List<ReferenceManager.RefreshListener> externalRefreshListener) {
        public Builder codecService(CodecService codecService) {
     */
    /**
 * Licensed to Elasticsearch under one or more contributor
        this.leafSorter = builder.leafSorter;
    /**
            return this;
         */
        return eventListener;
     *
            return new EngineConfig(this);
import org.opensearch.core.indices.breaker.CircuitBreakerService;
                    }
     * in realtime and forces a volatile read. Consumers can safely read this value directly go fetch it's latest value.
        }
        this.queryCache = builder.queryCache;
 * license agreements. See the NOTICE file distributed with
     */
            .externalRefreshListener(this.externalRefreshListener)
        this.indexSettings = builder.indexSettings;
    public List<ReferenceManager.RefreshListener> getExternalRefreshListener() {
            this.codecService = codecService;
            this.externalRefreshListener = externalRefreshListener;
     * @return a supplier of outstanding retention leases
        public Builder mergePolicy(MergePolicy mergePolicy) {
     * The default is <code>true</code>
    private EngineConfig(Builder builder) {
     * {@link org.opensearch.threadpool.ThreadPool#relativeTimeInMillis()} and to schedule
     * Returns the {@link org.apache.lucene.index.MergePolicy} for the engines {@link org.apache.lucene.index.IndexWriter}
        private Store store;
    private final TimeValue flushMergesAfter;
    public TimeValue getFlushMergesAfter() {
     * Index setting to change the compression level of zstd and zstd_no_dict lucene codecs.
    public boolean isAutoGeneratedIDsOptimizationEnabled() {
            throw new IllegalArgumentException("Shard can only be wired as a read only replica with Segment Replication enabled");
     */
            return this;
    private final LongSupplier primaryTermSupplier;
    /**
        return tombstoneDocSupplier;
        return retentionLeasesSupplier;
        private MapperService mapperService;
        private Engine.EventListener eventListener;
    public CommitterFactory getCommitterFactory() {
     * allocated on both `kind` of nodes.
     */
        this.globalCheckpointSupplier = builder.globalCheckpointSupplier;
 * specific language governing permissions and limitations
        public Builder clusterApplierService(ClusterApplierService clusterApplierService) {
        public Set<SettingDependency> getSettingsDependencies(String key) {
    public DocumentLookupProvider getDocumentLookupProvider() {
        public Builder leafSorter(Comparator<LeafReader> leafSorter) {
 *
                    if (availableCodec instanceof CodecAliases availableCodecWithAlias) {
        this.eventListener = builder.eventListener;
            .globalCheckpointSupplier(this.globalCheckpointSupplier)
    @Nullable
            .internalRefreshListener(this.internalRefreshListener)
    /**
     * This is used for Segment Replication where the engine implementation used is dependent on
    /**
        return globalCheckpointSupplier;
        }
                    if (luceneCodec instanceof CodecSettings codecSettings
     * Returns a supplier that supplies the latest primary term value of the associated shard.
                    doValidateCodecSettings((String) dependency);
     * re-enabling it might not be applied until the engine is in a safe state to do so. Depending on the engine implementation a change to
    }
    /**
    @Nullable
        private List<ReferenceManager.RefreshListener> internalRefreshListener;
            this.indexSettings = indexSettings;
     * Returns if this replica should be wired as a read only.
import org.opensearch.common.settings.Setting;
     */
                    if (codec instanceof CodecAliases codecWithAlias) {
            return this;
        private ThreadPool threadPool;
            .analyzer(this.analyzer)
    public ClusterApplierService getClusterApplierService() {
        public Builder analyzer(Analyzer analyzer) {
     */
    public DataFormatRegistry getDataFormatRegistry() {
        @ExperimentalApi
 * GitHub history for details.
        Integer.toString(3),
    }
        private MergePolicy mergePolicy;
 * this work for additional information regarding copyright
     */
import org.opensearch.common.Nullable;
     *
        } else {
    @Nullable
}
            .mergePolicy(this.mergePolicy)
        }
 */
            case "default":
    /**
                if (Codec.availableCodecs().contains(codec)) {
        /**
            this.shardId = shardId;
        "index.use_compound_file",
        this.indexReaderWarmer = builder.indexReaderWarmer;
     */
     * Configures an index to optimize documents with auto generated ids for append only. If this setting is updated from <code>false</code>
            return this;
     * points where no operation is in flight, because a policy change alters sequence-number
        public EngineConfig build() {
    }
            this.clusterApplierService = clusterApplierService;
    private final Sort indexSort;
import org.apache.lucene.search.similarities.Similarity;
    public Sort getIndexSort() {
            this.checksumStrategies = checksumStrategies;
     * Index setting to change the low level lucene codec used for writing new segments.
        Property.IndexScope
        return this.mergedSegmentTransferTracker;
        this.warmer = builder.warmer == null ? (a) -> {} : builder.warmer;
        }
 * this file be licensed under the Apache-2.0 license or a
    /**
            this.committerFactory = committerFactory;
        private CircuitBreakerService circuitBreakerService;
    private final Similarity similarity;
            .queryCache(this.queryCache)
                for (String codecName : Codec.availableCodecs()) {
        ParsedDocument newDeleteTombstoneDoc(String id);
    }
    }
     */
    public Engine.EventListener getEventListener() {
    public Supplier<DocumentMapperForType> getDocumentMapperForTypeSupplier() {
     */
        return queryCache;
        this.translogConfig = builder.translogConfig;
     * Returns the underlying indexReaderWarmer
     */
@PublicApi(since = "1.0.0")
     * this setting won't be reflected re-enabled optimization until the engine is restarted or the index is closed and reopened.
            .store(this.store)
         * Sets the resolver for the writable primary's indexing/sequence-number policy. It is consulted
    }
            return this;
     * @return the primary mode supplier.
    /**
 *
public final class EngineConfig {
 */
     */
            this.startedPrimarySupplier = startedPrimarySupplier;
            return this;
            .translogDeletionPolicyFactory(this.translogDeletionPolicyFactory)
            return this;
                            }
                    return INDEX_CODEC_SETTING;
        @Nullable
            return this;
        public Builder mergedSegmentTransferTracker(MergedSegmentTransferTracker mergedSegmentTransferTracker) {
    /**
    public List<ReferenceManager.RefreshListener> getInternalRefreshListener() {
     * Note: In order to use this instance the consumer needs to increment the stores reference before it's used the first time and hold
            .translogConfig(this.translogConfig)
 * not use this file except in compliance with the License.
     *
            .documentMetadataResolver(this.documentMetadataResolver)
            this.documentMetadataResolver = documentMetadataResolver;
        }
        public Builder warmer(Engine.Warmer warmer) {
     */
            .indexReaderWarmer(this.indexReaderWarmer)
        this.dataFormatRegistry = builder.dataFormatRegistry;
                                && codecSettings.supports(INDEX_CODEC_COMPRESSION_LEVEL_SETTING)) {
    private final BooleanSupplier startedPrimarySupplier;
import java.util.Set;
            return this;
    private final ClusterApplierService clusterApplierService;
            this.primaryOperationPolicySupplier = primaryOperationPolicySupplier;
    public QueryCache getQueryCache() {
        }
     * Compression Level gives a trade-off between compression ratio and speed. The higher compression level results in higher compression ratio but slower compression and decompression speeds.
import org.opensearch.indices.IndexingMemoryController;
        return externalRefreshListener;
            .committerFactory(this.committerFactory)
                            if (availableCodec instanceof CodecSettings codecSettings
        }
import org.apache.lucene.index.MergePolicy;
        private Engine.Warmer warmer;
        this.store = builder.store;
    public Similarity getSimilarity() {
 * software distributed under the License is distributed on an
            return this;
        // as the amount of memory that is available for all engines on the
                @Override
     * Returns an {@link org.opensearch.index.engine.Engine.Warmer} used to warm new searchers before they are used for searching.
                public Setting<String> getSetting() {
    }
        return startedPrimarySupplier;
     * A supplier supplies tombstone documents which will be used in soft-update methods.
            return this;
        this.documentMapperForTypeSupplier = builder.documentMapperForTypeSupplier;
import org.opensearch.index.store.Store;
            case "lucene_default":
        public Builder threadPool(ThreadPool threadPool) {
            .mapperService(this.mapperService)
        public Builder documentLookupProvider(@Nullable DocumentLookupProvider documentLookupProvider) {
        this.threadPool = builder.threadPool;
         * Sets a fixed indexing/sequence-number policy for a writable primary. A {@code null} value
    };
     */
        }
    public static final Setting<Integer> INDEX_CODEC_COMPRESSION_LEVEL_SETTING = new Setting<>(
            return this;
     * Returns the initial index buffer size. This setting is only read on startup and otherwise controlled
        return internalRefreshListener;
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        private LongSupplier globalCheckpointSupplier;
        return this.circuitBreakerService;
            this.primaryTermSupplier = primaryTermSupplier;
    /**
     * Returns a thread-pool mainly used to get estimated time stamps from
            return this;
        return queryCachingPolicy;
    }
            return this;
                }
    /**
    private final Engine.Warmer warmer;
     * to <code>true</code> might not take effect immediately. In other words, disabling the optimization will be immediately applied while
    public static class Builder {
            return this;
     */
        public Builder store(Store store) {
            this.documentMapperForTypeSupplier = documentMapperForTypeSupplier;
        return this.checksumStrategies;
            this.queryCache = queryCache;
            this.documentLookupProvider = documentLookupProvider;
            this.mapperService = mapperService;
     * @opensearch.api
 */
     * are written after the engine became inactive from an indexing perspective.
    }
 * Once {@link Engine} has been created with this object, changes to this
        return indexSettings.getValue(INDEX_USE_COMPOUND_FILE);
        Property.IndexScope,
     */
        return indexSettings;
     * Returns a listener that should be called on engine failure
        private Analyzer analyzer;
 * under the License.
        return translogConfig;
    /**
        }
     * This setting is <b>not</b> realtime updateable.
            this.warmer = warmer;
import org.opensearch.common.annotation.PublicApi;
        }
        }
    }
        }
            return this;
    public MapperService getMapperService() {
        private ShardId shardId;
        this.codecService = builder.codecService;
            return this;
            .tombstoneDocSupplier(this.tombstoneDocSupplier)
        private IndexSettings indexSettings;
import org.opensearch.cluster.service.ClusterApplierService;
            .checksumStrategies(this.checksumStrategies)
import org.apache.lucene.codecs.Codec;
        this.documentMetadataResolver = builder.documentMetadataResolver;
         * {@link DefaultPrimaryOperationPolicy}.
        return analyzer;
        this.externalRefreshListener = builder.externalRefreshListener;
            this.internalRefreshListener = internalRefreshListener;
    public ThreadPool getThreadPool() {
            this.analyzer = analyzer;
            this.indexSort = indexSort;
    /**
                    Codec luceneCodec = Codec.forName(codec);
            .translogFactory(this.translogFactory)
        public Builder dataFormatRegistry(DataFormatRegistry dataFormatRegistry) {
            .flushMergesAfter(this.flushMergesAfter)
        return store;
        public Builder translogFactory(TranslogFactory translogFactory) {
    private final IndexSettings indexSettings;
     * This setting is also settable on the node and the index level, it's commonly used in hot/cold node archs where index is likely
        public Builder flushMergesAfter(TimeValue flushMergesAfter) {
        }
    private final ShardId shardId;
         * construction, so a plugin keying its policy off an updatable index setting is re-consulted
    public QueryCachingPolicy getQueryCachingPolicy() {
    }
        codecName = builder.indexSettings.getValue(INDEX_CODEC_SETTING);
        }
    public ShardId getShardId() {
        public Builder tombstoneDocSupplier(TombstoneDocSupplier tombstoneDocSupplier) {
    /** Optional {@link DocumentMetadataResolver} passed per-call to the provider, or {@code null}. */
        }
         */
     * a plugin that keys its policy off an updatable setting can change its answer over the lifetime
         * Default ignores routing for backward compatibility; override to preserve it.
    }
        /**
import org.apache.lucene.index.IndexWriter;
        this.translogFactory = builder.translogFactory;
     * Returns a {@link TimeValue} at what time interval after the last write modification to the engine finished merges
 *    http://www.apache.org/licenses/LICENSE-2.0
            this.leafSorter = leafSorter;
import org.opensearch.common.unit.TimeValue;
     * while operations are blocked.
    @PublicApi(since = "3.3.0")
        this.startedPrimarySupplier = builder.startedPrimarySupplier;
    private final TranslogDeletionPolicyFactory translogDeletionPolicyFactory;
     * </p>
     *
         * Creates a tombstone document for a delete operation with routing.
            this.eventListener = eventListener;
        }
import org.opensearch.index.translog.TranslogConfig;
            this.mergedSegmentTransferTracker = mergedSegmentTransferTracker;
        return this.clusterApplierService;
        public Builder primaryTermSupplier(LongSupplier primaryTermSupplier) {
            .readOnlyReplica(this.isReadOnlyReplica)
        return documentMapperForTypeSupplier;
    private final CircuitBreakerService circuitBreakerService;
        }
        public Builder indexSort(Sort indexSort) {
    private final MapperService mapperService;
        }
        /**
        this.circuitBreakerService = builder.circuitBreakerService;
    public Analyzer getAnalyzer() {
 */
                if (Codec.availableCodecs().contains(s)) {
            return this;
    /**
    private final Comparator<LeafReader> leafSorter;
            return this;
import java.util.function.BooleanSupplier;
        }
            this.queryCachingPolicy = queryCachingPolicy;
    /**
        @Override
        return indexSettings.isSegRepEnabledOrRemoteNode() && isReadOnlyReplica;
                    if (!(dependency instanceof String)) {
     */
            final PrimaryOperationPolicy policy = primaryOperationPolicy != null
         * Prefer {@link #primaryOperationPolicySupplier(Supplier)} in production code: a fixed policy
     * Returns the underlying startedPrimarySupplier.
import org.apache.lucene.search.Sort;
        private ClusterApplierService clusterApplierService;
    public TranslogDeletionPolicyFactory getCustomTranslogDeletionPolicyFactory() {
            return this;
     * reproduces the standard primary behavior.
     * @return comparator
        public Builder indexReaderWarmer(IndexWriter.IndexReaderWarmer indexReaderWarmer) {
                return s;
    @Nullable
            case "best_compression":
 * @opensearch.api
                for (String codecName : Codec.availableCodecs()) {
import org.opensearch.core.common.unit.ByteSizeValue;
    }
        private CommitterFactory committerFactory;
     * Returns the ClusterApplierService instance.
    private final Supplier<PrimaryOperationPolicy> primaryOperationPolicySupplier;
            return this;
            return this;
            return this;
    public CircuitBreakerService getCircuitBreakerService() {
            .leafSorter(this.leafSorter)
    public MergedSegmentTransferTracker getMergedSegmentTransferTracker() {
     * Returns the index settings for this index.
    private final MergedSegmentTransferTracker mergedSegmentTransferTracker;
            .documentLookupProvider(this.documentLookupProvider)
    /**
            indexingBufferSize = IndexingMemoryController.INDEX_BUFFER_SIZE_SETTING.get(builder.indexSettings.getNodeSettings());
     * Returns the translog config for this engine
                    Codec availableCodec = Codec.forName(codecName);
            this.globalCheckpointSupplier = globalCheckpointSupplier;
        }
    }
        return indexReaderWarmer;
    private final Map<String, FormatChecksumStrategy> checksumStrategies;
        public Builder translogDeletionPolicyFactory(TranslogDeletionPolicyFactory translogDeletionPolicyFactory) {
        private boolean isReadOnlyReplica;
        return indexingBufferSize;
import org.opensearch.index.codec.CodecService;
    public Codec getCodec() {
        private CodecService codecService;
    /**
     * <p>
        this.clusterApplierService = builder.clusterApplierService;
            case "lz4":
        if (maxBufferSize != null) {
/*
    }
        }
     */
                public void validate(String key, Object value, Object dependency) {
    /**
        this.queryCachingPolicy = builder.queryCachingPolicy;
    public PrimaryOperationPolicy getPrimaryOperationPolicy() {
    /**
     * Creates a new Builder pre-populated with all values from this EngineConfig.
import java.util.Objects;
    }
    );
    }, Property.IndexScope, Property.NodeScope);
/*
    }
 * ownership. Elasticsearch licenses this file to you under
            default:
            .indexSort(this.indexSort)
            this.store = store;
        public Builder translogConfig(TranslogConfig translogConfig) {
     */
import org.opensearch.index.engine.exec.commit.CommitterFactory;
        public Builder internalRefreshListener(List<ReferenceManager.RefreshListener> internalRefreshListener) {
        return policy != null ? policy : DefaultPrimaryOperationPolicy.INSTANCE;
        private LongSupplier primaryTermSupplier;
            case "lz4":
     * </p>
     */
        public Builder eventListener(Engine.EventListener eventListener) {
                    return s;
        "index.codec.compression_level",
     * This allows for easy modification of specific fields while preserving all others.
     * @see #isEnableGcDeletes()
        return indexSort;
     */
    }
     */
        public Builder committerFactory(CommitterFactory committerFactory) {
import org.opensearch.index.translog.InternalTranslogFactory;
            ? builder.primaryOperationPolicySupplier
        }
    public TranslogFactory getTranslogFactory() {
        }
    ) {
import org.opensearch.plugins.DocumentLookupProvider;
        this.flushMergesAfter = builder.flushMergesAfter;
            .primaryOperationPolicySupplier(this.primaryOperationPolicySupplier);
     * The policy is resolved on every call, against the live {@link IndexSettings} of this config, so
                throw new IllegalArgumentException(
        public Builder readOnlyReplica(boolean isReadOnlyReplica) {
     */
        public Builder circuitBreakerService(CircuitBreakerService circuitBreakerService) {
     * operations. Never {@code null}; defaults to {@link DefaultPrimaryOperationPolicy}, which
        }
     * Returns the engines shard ID
                    "unknown value for [index.codec] must be one of [default, lz4, best_compression, zlib] but was: " + s
import org.opensearch.index.codec.CodecAliases;
    private volatile boolean enableGcDeletes = true;
    public static final Setting<Boolean> INDEX_USE_COMPOUND_FILE = Setting.boolSetting(
    }
        private TombstoneDocSupplier tombstoneDocSupplier;
    /**
                        }
    /**
     * Returns the {@link Codec} used in the engines {@link org.apache.lucene.index.IndexWriter}
     */
            this.translogConfig = translogConfig;
        throw new IllegalArgumentException("Compression level cannot be set for the " + codec + " codec.");
    private final DocumentMetadataResolver documentMetadataResolver;
import org.opensearch.common.settings.Setting.Property;
     */
     * Return the policy to use when caching queries.
    private final TombstoneDocSupplier tombstoneDocSupplier;
        String maxBufferSize = System.getProperty(escapeHatchProperty);
         * @param reason the reason of an a noop
        return indexSettings.getValue(INDEX_OPTIMIZE_AUTO_GENERATED_IDS);
/**
                @Override
     * @return the translog factory
            .eventListener(this.eventListener)
        }
        this.mapperService = builder.mapperService;
                }
     * Returns the circuit breaker service for this engine, or {@code null} if none is to be used.
            .similarity(this.similarity)
     * @return a new Builder instance with all current configuration values
            this.threadPool = threadPool;
    }
            this.translogFactory = translogFactory;
        }
        this.enableGcDeletes = enableGcDeletes;
        private DocumentMetadataResolver documentMetadataResolver;
import org.apache.lucene.search.QueryCachingPolicy;
        }
        public Builder similarity(Similarity similarity) {
import org.opensearch.index.IndexSettings;
     * @return the indexReaderWarmer
            .codecService(this.codecService)
                        if (codecWithAlias.aliases().contains(s)) {
        private TimeValue flushMergesAfter;
     * assignment. {@link InternalEngine} does exactly that: it snapshots the policy at construction and
    public MergePolicy getMergePolicy() {
            .retentionLeasesSupplier(this.retentionLeasesSupplier)
     * Returns <code>true</code> iff delete garbage collection in the engine should be enabled. This setting is updateable
    /**
        return this.committerFactory;
    public Comparator<LeafReader> getLeafSorter() {
        }
                break;
        }
     * by {@link IndexingMemoryController}
        }
 * The OpenSearch Contributors require contributions made to
        true,
            indexingBufferSize = MemorySizeValue.parseBytesSizeValueOrHeapRatio(maxBufferSize, escapeHatchProperty);
     * @opensearch.api
                }
 * Modifications Copyright OpenSearch Contributors. See
    public interface TombstoneDocSupplier {
    public void setEnableGcDeletes(boolean enableGcDeletes) {
        }
        public Builder mapperService(MapperService mapperService) {
        switch (codec) {
    private final List<ReferenceManager.RefreshListener> internalRefreshListener;
        private Sort indexSort;
     */
package org.opensearch.index.engine;
            return newDeleteTombstoneDoc(id);
    }
import java.util.Collections;
import org.opensearch.index.translog.TranslogDeletionPolicyFactory;
 * KIND, either express or implied.  See the License for the
        public Builder primaryOperationPolicy(@Nullable PrimaryOperationPolicy primaryOperationPolicy) {
    /**
        Property.Dynamic
        this.committerFactory = builder.committerFactory;
        this.analyzer = builder.analyzer;
    /** Optional {@link DocumentLookupProvider} for the pluggable get-by-id path, or {@code null}. */
            this.indexReaderWarmer = indexReaderWarmer;
    private final LongSupplier globalCheckpointSupplier;
        public Builder documentMapperForTypeSupplier(Supplier<DocumentMapperForType> documentMapperForTypeSupplier) {
         * on every {@link EngineConfig#getPrimaryOperationPolicy()} call rather than once at engine
        return new Builder().shardId(this.shardId)
         * cannot follow a setting change, so a shard built this way keeps the same policy from engine
            return this;
