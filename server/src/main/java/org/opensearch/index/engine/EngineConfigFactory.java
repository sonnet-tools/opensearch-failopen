import org.opensearch.common.unit.TimeValue;
            .codecService(codecServiceToUse)
import org.opensearch.index.seqno.RetentionLeases;  
        CodecService defaultCodecService  
    private final CodecServiceFactory codecServiceFactory;
    /* package-private constructor from specific EnginePlugins and IndexSettings without document-lookup wiring */  
    public CodecService newCodecServiceOrDefault(
    private final List<AdditionalCodecs> additionalCodecs;  
import org.opensearch.index.mapper.DocumentMapperForType;  
import org.apache.lucene.search.Sort;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.translog.TranslogDeletionPolicyFactory;
        this(Collections.emptyList(), idxSettings);
                throw new IllegalStateException(
        IndexWriter.IndexReaderWarmer indexReaderWarmer,
                );
        ThreadPool threadPool,
        // Resolution is deferred to engine build time, but do a resolution here to fail fast on conflict
        Sort indexSort,
        resolvePrimaryOperationPolicy(indexSettings, enginePlugins);  
import java.util.Comparator;
    ) {
        if (committerFactories.size() > 1 || (committerFactories.isEmpty() && idxSettings.isPluggableDataFormatEnabled())) {
            .mapperService(mapperService)
                if (primaryOperationPolicy != null) {
import java.util.Optional;
                throw new IllegalStateException(  
                    throw new IllegalStateException(
        BooleanSupplier startedPrimarySupplier,  
    private final DocumentLookupProvider documentLookupProvider;
        Logger logger,
            .build();
        TranslogConfig translogConfig,
            // collect all available CodecRegistry instances
        String translogDeletionPolicyOverridingPlugin = null;  
    ) {
import org.opensearch.index.IndexSettings;
    private final DocumentMetadataResolver documentMetadataResolver;  
        CodecService codecService,  
        IndexSettings idxSettings,
        Map<String, FormatChecksumStrategy> checksumStrategies  
     */
            throw new IllegalStateException("multiple committer factories found: " + committerFactories);
/*  
    @Nullable  
        Supplier<RetentionLeases> retentionLeasesSupplier,
                        + " attempting to override again by: "
                codecServiceFactory = enginePlugin.getCustomCodecServiceFactory(idxSettings);
        PluginsService pluginsService,
    }  
    public EngineConfigFactory(IndexSettings idxSettings) {  
            .translogDeletionPolicyFactory(translogDeletionPolicyFactory)  
        String primaryOperationPolicyPlugin = null;  
                translogDeletionPolicyOverridingPlugin = enginePlugin.getClass().getName();  
            : defaultCodecService;
/**
import org.opensearch.plugins.DocumentLookupProvider;  
import org.opensearch.index.store.FormatChecksumStrategy;
            .translogFactory(translogFactory)  
        MapperService mapperService,
            // get overriding CodecServiceFactory from EnginePlugin  
        @Nullable DocumentLookupProvider documentLookupProvider,  
        this.documentMetadataResolver = documentMetadataResolver;  
            enginePlugin.getAdditionalCodecs(idxSettings).ifPresent(codecRegistries::add);
package org.opensearch.index.engine;
            .leafSorter(leafSorter)
                primaryOperationPolicyPlugin = enginePlugin.getClass().getName();
        }
                    "existing TranslogDeletionPolicyFactory is already overridden in: "  
        this(enginePlugins, idxSettings, null, null);
                            + enginePlugin.getClass().getName()  
import java.util.Collection;  
            .tombstoneDocSupplier(tombstoneDocSupplier)  
        }  
import org.opensearch.plugins.EnginePlugin;
    }
                "both codec service and codec service factory are present, codec service provided by: "  
import org.apache.lucene.index.IndexWriter;  
     * Instantiates a new EngineConfig from the provided custom overrides
        ShardId shardId,
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
    /**
import java.util.List;  
    private final List<EnginePlugin> enginePlugins;
            .indexSort(indexSort)
            .similarity(similarity)  
                    "existing codec service factory already overridden in: "  
        Optional<CodecService> codecService = Optional.empty();
        this(pluginsService.filterPlugins(EnginePlugin.class), idxSettings, documentLookupProvider, documentMetadataResolver);  
import org.apache.lucene.search.similarities.Similarity;
        @Nullable DocumentMetadataResolver documentMetadataResolver
        if (codecService.isPresent() && codecServiceFactory.isPresent()) {
                throw new IllegalStateException(
            .clusterApplierService(clusterApplierService)
        }
        this.committerFactory = committerFactories.isEmpty() ? null : committerFactories.getFirst();  
        Collection<EnginePlugin> enginePlugins  
                );
import java.util.Collections;
            .committerFactory(committerFactory)
import java.util.function.BooleanSupplier;  
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.search.ReferenceManager;
import java.util.ArrayList;
 * @opensearch.internal
    }
            .retentionLeasesSupplier(retentionLeasesSupplier)
        @Nullable DocumentLookupProvider documentLookupProvider,  
                        + enginePlugin.getClass().getName()  
    }
                            + primaryOperationPolicyPlugin
import org.apache.lucene.index.LeafReader;
        this.enginePlugins = List.copyOf(enginePlugins);
            .mergedSegmentTransferTracker(mergedSegmentTransferTracker)
        String codecServiceFactoryOverridingPlugin = null;
        return new EngineConfig.Builder().shardId(shardId)
            .store(store)  
import org.opensearch.index.translog.TranslogConfig;  
    }
        }
     * (pluggable get-by-id path) into the produced {@link EngineConfig}.
                    + codecServiceFactoryOverridingPlugin  
import org.opensearch.threadpool.ThreadPool;  
        LongSupplier primaryTermSupplier,  
        this.codecServiceFactory = (instance != null) ? (config) -> instance : codecServiceFactory.orElse(null);  
    /**
        return this.codecServiceFactory != null
            .checksumStrategies(checksumStrategies)  
            .warmer(warmer)
                        + " attempting to override again by: "  
    private final CommitterFactory committerFactory;
                codecServiceFactoryOverridingPlugin = enginePlugin.getClass().getName();  
import java.util.function.LongSupplier;
    }  
import org.opensearch.index.mapper.MapperService;
        Optional<CodecServiceFactory> codecServiceFactory = Optional.empty();  
            .dataFormatRegistry(dataFormatRegistry)  
            .mergePolicy(mergePolicy)
        // promoted, but resolve once here so a plugin conflict fails the engine build instead of the first read.
    public CodecService newDefaultCodecService(IndexSettings indexSettings, @Nullable MapperService mapperService, Logger logger) {
                translogDeletionPolicyFactory = enginePlugin.getCustomTranslogDeletionPolicyFactory();
        this.additionalCodecs = Collections.unmodifiableList(codecRegistries);
            }
     */  
            .documentMetadataResolver(documentMetadataResolver)
            if (translogDeletionPolicyFactory.isPresent() == false) {
                        + enginePlugin.getClass().getName()
            final Optional<PrimaryOperationPolicy> pluginPrimaryOperationPolicy = enginePlugin.getPrimaryOperationPolicy(indexSettings);
        DataFormatRegistry dataFormatRegistry,
    }
                );
        if (codecService == null && this.codecServiceFactory != null) {  
 * A factory to create an EngineConfig based on custom plugin overrides
                        + codecServiceOverridingPlugin
 * compatible open source license.
            .internalRefreshListener(internalRefreshListener)  
import org.opensearch.index.codec.CodecServiceConfig;
            .readOnlyReplica(isReadOnlyReplica)
                primaryOperationPolicy = pluginPrimaryOperationPolicy.get();  
            .eventListener(eventListener)
import org.apache.lucene.search.QueryCachingPolicy;
        Collection<EnginePlugin> enginePlugins,
    ) {
            if (pluginPrimaryOperationPolicy.isPresent()) {  
                    + codecServiceOverridingPlugin
    private static PrimaryOperationPolicy resolvePrimaryOperationPolicy(
                        "existing PrimaryOperationPolicy is already overridden in: "  
        Similarity similarity,
        for (EnginePlugin enginePlugin : enginePlugins) {  
            // get overriding codec service from EnginePlugin
        resolvePrimaryOperationPolicy(idxSettings, enginePlugins);
    private final TranslogDeletionPolicyFactory translogDeletionPolicyFactory;
            if (codecService.isPresent() == false) {
            .translogConfig(translogConfig)
            .threadPool(threadPool)  
 * The OpenSearch Contributors require contributions made to  
        LongSupplier globalCheckpointSupplier,
            ? this.codecServiceFactory.createCodecService(new CodecServiceConfig(indexSettings, mapperService, logger, additionalCodecs))  
import org.opensearch.index.engine.exec.commit.CommitterFactory;
import org.opensearch.common.Nullable;  
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
        Supplier<DocumentMapperForType> documentMapperForTypeSupplier,  
                        + codecServiceFactoryOverridingPlugin
            } else if (enginePlugin.getCustomCodecServiceFactory(idxSettings).isPresent()) {
     * Factory wiring the optional {@link DocumentLookupProvider} and {@link DocumentMetadataResolver}  
        CircuitBreakerService circuitBreakerService,  
            .primaryTermSupplier(primaryTermSupplier)
        IndexSettings indexSettings,
                }
        return new CodecService(mapperService, indexSettings, logger, additionalCodecs);
            .startedPrimarySupplier(startedPrimarySupplier)
            if (codecServiceFactory.isPresent() == false) {
        return primaryOperationPolicy == null ? DefaultPrimaryOperationPolicy.INSTANCE : primaryOperationPolicy;
            .documentMapperForTypeSupplier(documentMapperForTypeSupplier)
        this.documentLookupProvider = documentLookupProvider;
            .queryCache(queryCache)  
        final List<AdditionalCodecs> codecRegistries = new ArrayList<>();  
    ) {
import org.opensearch.plugins.PluginsService;
        List<ReferenceManager.RefreshListener> internalRefreshListener,
        List<CommitterFactory> committerFactories = new ArrayList<>();
            );
                codecService = enginePlugin.getCustomCodecService(idxSettings);  
        String codecServiceOverridingPlugin = null;
     * Construct a factory using the plugin service and provided index settings
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.service.ClusterApplierService;
        IndexSettings indexSettings,  
    /* private constructor to construct the factory from specific EnginePlugins and IndexSettings */
}  
        QueryCache queryCache,
        @Nullable DocumentMetadataResolver documentMetadataResolver
    EngineConfigFactory(Collection<EnginePlugin> enginePlugins, IndexSettings idxSettings) {
 */  
        this(pluginsService.filterPlugins(EnginePlugin.class), idxSettings);
                        + translogDeletionPolicyOverridingPlugin
                        + " attempting to override again by: "
            throw new IllegalStateException(
        final CodecService instance = codecService.orElse(null);
    public EngineConfig newEngineConfig(  
            .externalRefreshListener(externalRefreshListener)
    @Nullable
    /**  
    EngineConfigFactory(  
    public EngineConfigFactory(  
        }  
        ClusterApplierService clusterApplierService,
            } else if (enginePlugin.getCustomCodecService(idxSettings).isPresent()) {
import org.opensearch.index.translog.TranslogFactory;
        List<ReferenceManager.RefreshListener> externalRefreshListener,  
import org.opensearch.core.index.shard.ShardId;
            enginePlugin.getCommitterFactory(idxSettings).ifPresent(committerFactories::add);
            .circuitBreakerService(circuitBreakerService)
    /** default ctor primarily used for tests without plugins */
import org.opensearch.index.codec.CodecService;  
            }
        MergePolicy mergePolicy,  
        Store store,
                    );
import org.apache.lucene.index.MergePolicy;
        TimeValue flushMergesAfter,
        @Nullable MapperService mapperService,
import org.apache.lucene.search.QueryCache;  
                codecServiceOverridingPlugin = enginePlugin.getClass().getName();
            }
                        + enginePlugin.getClass().getName()  
            .analyzer(analyzer)
 *
            .flushMergesAfter(flushMergesAfter)
import org.opensearch.index.engine.dataformat.DataFormatRegistry;  
        boolean isReadOnlyReplica,
            .documentLookupProvider(documentLookupProvider)
        EngineConfig.TombstoneDocSupplier tombstoneDocSupplier,
        Engine.EventListener eventListener,
import java.util.function.Supplier;
        MergedSegmentTransferTracker mergedSegmentTransferTracker,  
    public EngineConfigFactory(PluginsService pluginsService, IndexSettings idxSettings) {
 *  
                            + " attempting to override again by: "
import org.opensearch.index.codec.CodecServiceFactory;
        Comparator<LeafReader> leafSorter,
import org.opensearch.index.store.Store;
    }  
public class EngineConfigFactory {  
            .primaryOperationPolicySupplier(() -> resolvePrimaryOperationPolicy(indexSettings, enginePlugins))  
            .indexReaderWarmer(indexReaderWarmer)  
        TranslogFactory translogFactory,
 */
    ) {
        IndexSettings idxSettings,
     */
        PrimaryOperationPolicy primaryOperationPolicy = null;
            } else if (enginePlugin.getCustomTranslogDeletionPolicyFactory().isPresent()) {
import org.opensearch.index.merge.MergedSegmentTransferTracker;
            .globalCheckpointSupplier(globalCheckpointSupplier)  
        for (EnginePlugin enginePlugin : enginePlugins) {
import org.opensearch.index.codec.AdditionalCodecs;
            .indexSettings(indexSettings)
        Optional<TranslogDeletionPolicyFactory> translogDeletionPolicyFactory = Optional.empty();
            .queryCachingPolicy(queryCachingPolicy)
                    "existing codec service already overridden in: "
        QueryCachingPolicy queryCachingPolicy,  
    }
import java.util.Map;
            }  
            codecServiceToUse = newCodecServiceOrDefault(indexSettings, null, null, null);
        IndexSettings indexSettings,  
        CodecService codecServiceToUse = codecService;
        // The config re-resolves the policy on every read so a shard picks up a setting change when it is
        Analyzer analyzer,
        this.translogDeletionPolicyFactory = translogDeletionPolicyFactory.orElse((idxs, rtls) -> null);
                    + " conflicts with codec service factory provided by: "
        Engine.Warmer warmer,
 * this file be licensed under the Apache-2.0 license or a
