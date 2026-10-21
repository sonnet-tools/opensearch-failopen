            .flushMergesAfter(flushMergesAfter)
        for (EnginePlugin enginePlugin : enginePlugins) {
            .mergedSegmentTransferTracker(mergedSegmentTransferTracker)
                codecServiceFactoryOverridingPlugin = enginePlugin.getClass().getName();
    /** default ctor primarily used for tests without plugins */
        this.documentLookupProvider = documentLookupProvider;
        CodecService codecServiceToUse = codecService;
        DataFormatRegistry dataFormatRegistry,
    EngineConfigFactory(Collection<EnginePlugin> enginePlugins, IndexSettings idxSettings) {
                    "existing codec service already overridden in: "
import org.opensearch.index.codec.AdditionalCodecs;
        TranslogConfig translogConfig,
        // The config re-resolves the policy on every read so a shard picks up a setting change when it is
            .globalCheckpointSupplier(globalCheckpointSupplier)
            .store(store)
        LongSupplier primaryTermSupplier,
            throw new IllegalStateException("multiple committer factories found: " + committerFactories);
        Engine.Warmer warmer,
        List<CommitterFactory> committerFactories = new ArrayList<>();
            }
            // get overriding codec service from EnginePlugin
                );
        CodecService defaultCodecService
    ) {
            .retentionLeasesSupplier(retentionLeasesSupplier)
import java.util.function.BooleanSupplier;
import org.apache.logging.log4j.Logger;
            .analyzer(analyzer)
            // get overriding CodecServiceFactory from EnginePlugin
import org.apache.lucene.search.similarities.Similarity;
        ClusterApplierService clusterApplierService,
        String codecServiceFactoryOverridingPlugin = null;
    }
import org.apache.lucene.index.MergePolicy;
                    + codecServiceOverridingPlugin
     */
import org.opensearch.plugins.PluginsService;
    ) {
            .dataFormatRegistry(dataFormatRegistry)
                        + translogDeletionPolicyOverridingPlugin
        }
        Supplier<DocumentMapperForType> documentMapperForTypeSupplier,
    private final CodecServiceFactory codecServiceFactory;
            .translogFactory(translogFactory)
 * The OpenSearch Contributors require contributions made to
                    );
    private final CommitterFactory committerFactory;
import java.util.Map;
    public CodecService newCodecServiceOrDefault(
            .translogConfig(translogConfig)
import java.util.Optional;
    }
    public EngineConfigFactory(IndexSettings idxSettings) {
        MergedSegmentTransferTracker mergedSegmentTransferTracker,
        final CodecService instance = codecService.orElse(null);
            .clusterApplierService(clusterApplierService)
import org.opensearch.index.store.FormatChecksumStrategy;
                    + codecServiceFactoryOverridingPlugin
            .queryCachingPolicy(queryCachingPolicy)
        this.translogDeletionPolicyFactory = translogDeletionPolicyFactory.orElse((idxs, rtls) -> null);
import org.opensearch.index.store.Store;
import org.opensearch.common.unit.TimeValue;
                }
        return this.codecServiceFactory != null
        @Nullable DocumentMetadataResolver documentMetadataResolver
                codecServiceFactory = enginePlugin.getCustomCodecServiceFactory(idxSettings);
import java.util.List;
 */
import java.util.function.Supplier;
    ) {
}
    private final DocumentMetadataResolver documentMetadataResolver;
        this.additionalCodecs = Collections.unmodifiableList(codecRegistries);
    }
import org.apache.lucene.analysis.Analyzer;
            .externalRefreshListener(externalRefreshListener)
        this(pluginsService.filterPlugins(EnginePlugin.class), idxSettings, documentLookupProvider, documentMetadataResolver);
public class EngineConfigFactory {
    /**
            .translogDeletionPolicyFactory(translogDeletionPolicyFactory)
import org.opensearch.index.merge.MergedSegmentTransferTracker;
    ) {
            .readOnlyReplica(isReadOnlyReplica)
import org.apache.lucene.search.ReferenceManager;
        Sort indexSort,
        @Nullable DocumentLookupProvider documentLookupProvider,
                        + " attempting to override again by: "
import org.opensearch.threadpool.ThreadPool;
            .leafSorter(leafSorter)
        Collection<EnginePlugin> enginePlugins,
                    "existing TranslogDeletionPolicyFactory is already overridden in: "
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
            .startedPrimarySupplier(startedPrimarySupplier)
                        + enginePlugin.getClass().getName()
import java.util.Comparator;
                throw new IllegalStateException(
            } else if (enginePlugin.getCustomTranslogDeletionPolicyFactory().isPresent()) {
        if (codecService.isPresent() && codecServiceFactory.isPresent()) {
            .documentLookupProvider(documentLookupProvider)
        @Nullable DocumentMetadataResolver documentMetadataResolver
        Logger logger,
        if (committerFactories.size() > 1 || (committerFactories.isEmpty() && idxSettings.isPluggableDataFormatEnabled())) {
                        "existing PrimaryOperationPolicy is already overridden in: "
            if (translogDeletionPolicyFactory.isPresent() == false) {
            .checksumStrategies(checksumStrategies)
        return new CodecService(mapperService, indexSettings, logger, additionalCodecs);
        this(enginePlugins, idxSettings, null, null);
        Optional<TranslogDeletionPolicyFactory> translogDeletionPolicyFactory = Optional.empty();
                    "existing codec service factory already overridden in: "
        return primaryOperationPolicy == null ? DefaultPrimaryOperationPolicy.INSTANCE : primaryOperationPolicy;
            }
    }
                        + " attempting to override again by: "
            : defaultCodecService;
        List<ReferenceManager.RefreshListener> externalRefreshListener,
            .documentMetadataResolver(documentMetadataResolver)
        }
        return new EngineConfig.Builder().shardId(shardId)
        for (EnginePlugin enginePlugin : enginePlugins) {
        IndexSettings indexSettings,
            final Optional<PrimaryOperationPolicy> pluginPrimaryOperationPolicy = enginePlugin.getPrimaryOperationPolicy(indexSettings);
    ) {
        Similarity similarity,
                            + " attempting to override again by: "
            .indexSettings(indexSettings)
        }
        Store store,
        MergePolicy mergePolicy,
                    + " conflicts with codec service factory provided by: "
import java.util.ArrayList;
import org.opensearch.index.mapper.MapperService;
        QueryCache queryCache,
                codecService = enginePlugin.getCustomCodecService(idxSettings);
        Optional<CodecServiceFactory> codecServiceFactory = Optional.empty();
import org.opensearch.plugins.EnginePlugin;
    }
     * Construct a factory using the plugin service and provided index settings
            if (codecServiceFactory.isPresent() == false) {
import org.opensearch.plugins.DocumentLookupProvider;
import org.opensearch.index.translog.TranslogFactory;
        CodecService codecService,
    public EngineConfig newEngineConfig(
            codecServiceToUse = newCodecServiceOrDefault(indexSettings, null, null, null);
        Collection<EnginePlugin> enginePlugins
        this.enginePlugins = List.copyOf(enginePlugins);
package org.opensearch.index.engine;
import org.opensearch.index.translog.TranslogDeletionPolicyFactory;
                );
        EngineConfig.TombstoneDocSupplier tombstoneDocSupplier,
 *
            .documentMapperForTypeSupplier(documentMapperForTypeSupplier)
    }
    private final List<EnginePlugin> enginePlugins;
     * Factory wiring the optional {@link DocumentLookupProvider} and {@link DocumentMetadataResolver}
            .warmer(warmer)
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.mapper.DocumentMapperForType;
 */
    public EngineConfigFactory(
        ThreadPool threadPool,
        TranslogFactory translogFactory,
            .codecService(codecServiceToUse)
        Supplier<RetentionLeases> retentionLeasesSupplier,
import org.apache.lucene.search.Sort;
        String codecServiceOverridingPlugin = null;
            .mergePolicy(mergePolicy)
    /* private constructor to construct the factory from specific EnginePlugins and IndexSettings */
        IndexSettings indexSettings,
                        + codecServiceOverridingPlugin
import org.apache.lucene.search.QueryCache;
import org.opensearch.index.codec.CodecServiceFactory;
    EngineConfigFactory(
        Optional<CodecService> codecService = Optional.empty();
        @Nullable DocumentLookupProvider documentLookupProvider,
/**
    }
     */
    private final DocumentLookupProvider documentLookupProvider;
import org.opensearch.index.codec.CodecServiceConfig;
            .circuitBreakerService(circuitBreakerService)
/*
            throw new IllegalStateException(
            }
import org.opensearch.cluster.service.ClusterApplierService;
        IndexSettings idxSettings,
     * Instantiates a new EngineConfig from the provided custom overrides
        List<ReferenceManager.RefreshListener> internalRefreshListener,
            .primaryTermSupplier(primaryTermSupplier)
        MapperService mapperService,
                );
 * @opensearch.internal
 *
            .primaryOperationPolicySupplier(() -> resolvePrimaryOperationPolicy(indexSettings, enginePlugins))
        this.committerFactory = committerFactories.isEmpty() ? null : committerFactories.getFirst();
                throw new IllegalStateException(
import org.opensearch.index.seqno.RetentionLeases;
        LongSupplier globalCheckpointSupplier,
    @Nullable
        CircuitBreakerService circuitBreakerService,
        this(Collections.emptyList(), idxSettings);
        IndexSettings idxSettings,
            .committerFactory(committerFactory)
        boolean isReadOnlyReplica,
        TimeValue flushMergesAfter,
import org.opensearch.core.index.shard.ShardId;
    private final TranslogDeletionPolicyFactory translogDeletionPolicyFactory;
        Analyzer analyzer,
        Engine.EventListener eventListener,
import org.opensearch.index.translog.TranslogConfig;
        PrimaryOperationPolicy primaryOperationPolicy = null;
                        + " attempting to override again by: "
    private final List<AdditionalCodecs> additionalCodecs;
                            + enginePlugin.getClass().getName()
                    throw new IllegalStateException(
        @Nullable MapperService mapperService,
            ? this.codecServiceFactory.createCodecService(new CodecServiceConfig(indexSettings, mapperService, logger, additionalCodecs))
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
            enginePlugin.getAdditionalCodecs(idxSettings).ifPresent(codecRegistries::add);
        resolvePrimaryOperationPolicy(idxSettings, enginePlugins);
import java.util.function.LongSupplier;
import org.apache.lucene.index.LeafReader;
            if (codecService.isPresent() == false) {
            } else if (enginePlugin.getCustomCodecService(idxSettings).isPresent()) {
                throw new IllegalStateException(
                if (primaryOperationPolicy != null) {
            .mapperService(mapperService)
        String translogDeletionPolicyOverridingPlugin = null;
 * A factory to create an EngineConfig based on custom plugin overrides
import org.apache.lucene.search.QueryCachingPolicy;
            }
    public CodecService newDefaultCodecService(IndexSettings indexSettings, @Nullable MapperService mapperService, Logger logger) {
    @Nullable
import java.util.Collection;
        String primaryOperationPolicyPlugin = null;
        // promoted, but resolve once here so a plugin conflict fails the engine build instead of the first read.
            .build();
        resolvePrimaryOperationPolicy(indexSettings, enginePlugins);
        QueryCachingPolicy queryCachingPolicy,
    /**
    private static PrimaryOperationPolicy resolvePrimaryOperationPolicy(
                        + codecServiceFactoryOverridingPlugin
        BooleanSupplier startedPrimarySupplier,
import org.opensearch.index.engine.exec.commit.CommitterFactory;
                            + primaryOperationPolicyPlugin
            .internalRefreshListener(internalRefreshListener)
     */
    }
        ShardId shardId,
        }
        this.documentMetadataResolver = documentMetadataResolver;
            .tombstoneDocSupplier(tombstoneDocSupplier)
        IndexSettings indexSettings,
                translogDeletionPolicyFactory = enginePlugin.getCustomTranslogDeletionPolicyFactory();
import org.opensearch.index.IndexSettings;
            // collect all available CodecRegistry instances
        Comparator<LeafReader> leafSorter,
                primaryOperationPolicy = pluginPrimaryOperationPolicy.get();
import org.opensearch.common.Nullable;
            enginePlugin.getCommitterFactory(idxSettings).ifPresent(committerFactories::add);
            .queryCache(queryCache)
    }
import org.apache.lucene.index.IndexWriter;
        }
                        + enginePlugin.getClass().getName()
    public EngineConfigFactory(PluginsService pluginsService, IndexSettings idxSettings) {
        IndexWriter.IndexReaderWarmer indexReaderWarmer,
            .indexSort(indexSort)
            .threadPool(threadPool)
     * (pluggable get-by-id path) into the produced {@link EngineConfig}.
                translogDeletionPolicyOverridingPlugin = enginePlugin.getClass().getName();
            );
        if (codecService == null && this.codecServiceFactory != null) {
        this.codecServiceFactory = (instance != null) ? (config) -> instance : codecServiceFactory.orElse(null);
                        + enginePlugin.getClass().getName()
                codecServiceOverridingPlugin = enginePlugin.getClass().getName();
    /**
        PluginsService pluginsService,
    /* package-private constructor from specific EnginePlugins and IndexSettings without document-lookup wiring */
import org.opensearch.core.indices.breaker.CircuitBreakerService;
            .eventListener(eventListener)
        Map<String, FormatChecksumStrategy> checksumStrategies
                primaryOperationPolicyPlugin = enginePlugin.getClass().getName();
import java.util.Collections;
        // Resolution is deferred to engine build time, but do a resolution here to fail fast on conflict
            if (pluginPrimaryOperationPolicy.isPresent()) {
 * SPDX-License-Identifier: Apache-2.0
        final List<AdditionalCodecs> codecRegistries = new ArrayList<>();
 * compatible open source license.
        this(pluginsService.filterPlugins(EnginePlugin.class), idxSettings);
            .indexReaderWarmer(indexReaderWarmer)
            } else if (enginePlugin.getCustomCodecServiceFactory(idxSettings).isPresent()) {
import org.opensearch.index.codec.CodecService;
                "both codec service and codec service factory are present, codec service provided by: "
            .similarity(similarity)
