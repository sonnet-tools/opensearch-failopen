    }
     * Creates a {@link LuceneIndexingExecutionEngine} for the given configuration.
                + (committer != null ? committer.getClass().getName() : "null")
        return new LuceneDeleteExecutionEngine(DATA_FORMAT, committer);
import org.opensearch.index.engine.exec.commit.Committer;
     * @param settings the reader manager configuration
    /**
 *
    /** {@inheritDoc} Returns the singleton {@link LuceneDataFormat} descriptor. */
 *
        new LuceneStatsProvider();
    @Override
        getActions() {
            "LuceneIndexingExecutionEngine requires a LuceneCommitter but got: "
    ) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.inject.Module;
 * Implements three plugin interfaces:
    @Override
}
    }
 * </ul>
     * @param indexingEngineConfig the indexing engine configuration
import java.util.Map;
     * @return a new Lucene indexing execution engine
import org.opensearch.common.settings.Settings;
 * compatible open source license.
 * <p>
        RestController restController,
    }
    /** {@inheritDoc} Returns a singleton list containing the Lucene data format. */
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
    }
/*
    }
 */
import java.util.Optional;
     *
import org.opensearch.be.lucene.stats.transport.LuceneStatsRestAction;
    // --- DocumentMetadataResolver ---
import org.opensearch.index.engine.dataformat.DeleteExecutionEngine;
    public Collection<Module> createGuiceModules() {
import org.opensearch.be.lucene.index.LuceneDeleteExecutionEngine;
import org.opensearch.index.engine.exec.EngineReaderManager;
    @Override
        );
    public DataFormat getDataFormat() {
    public
import org.opensearch.index.IndexSettings;
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
        DataFormatRegistry dataFormatRegistry
    /**
    // --- SearchBackEndPlugin ---
        return List.of(
     */
 *   <li>{@link EnginePlugin} — provides {@link LuceneCommitterFactory} for durable commits</li>
import java.io.IOException;
     */
    public String name() {
    @Override
    /** Creates a new LucenePlugin. */
        // Eagerly construct the singleton so LuceneIndexingExecutionEngine can register on creation.
        return LuceneDataFormat.LUCENE_FORMAT_NAME;
        return Map.of(DATA_FORMAT.name(), () -> new DataFormatDescriptor(DATA_FORMAT.name(), new LuceneChecksumHandler()));
    public DocumentMetadata resolveMetadata(IndexReaderProvider.Reader reader, String id) throws IOException {
        return List.of(new LuceneStatsRestAction(), new LuceneNodeStatsRestAction());
     * @return a new reader manager
import org.opensearch.be.lucene.stats.transport.LuceneStatsTransportAction;
     * Creates a {@link LuceneReaderManager} for the given settings by delegating to
        if (committer instanceof LuceneCommitter luceneCommitter) {
    public Map<String, Supplier<DataFormatDescriptor>> getFormatDescriptors(
    /** {@inheritDoc} Returns {@code "lucene"}. */
    public static final LuceneDataFormat DATA_FORMAT = new LuceneDataFormat();
@ExperimentalApi
import org.opensearch.plugins.ActionPlugin;
        return LuceneSearchBackEnd.createReaderManager(settings);
import org.opensearch.rest.RestController;
 * this file be licensed under the Apache-2.0 license or a
        IndexSettings indexSettings,
import org.opensearch.plugins.EnginePlugin;
    @Override
                luceneCommitter,
     *
            new ActionPlugin.ActionHandler<>(LuceneStatsActionType.INSTANCE, LuceneStatsTransportAction.class),
import java.util.Collection;
import org.opensearch.index.engine.exec.IndexReaderProvider;
    }
     * Requires the committer to be a {@link LuceneCommitter}.
        ClusterSettings clusterSettings,
import org.opensearch.plugins.SearchBackEndPlugin;
                indexingEngineConfig.mapperService(),
import org.opensearch.common.settings.SettingsFilter;
import org.opensearch.index.engine.dataformat.DataFormatDescriptor;
        DocumentMetadataResolver {
        Committer committer = indexingEngineConfig.committer();
        }
    public LucenePlugin() {}
 * for the composite engine.
        throw new IllegalStateException(
    implements
 *       inverted indices for text fields via {@link LuceneIndexingExecutionEngine}</li>
    }
 *   <li>{@link DataFormatPlugin} — registers Lucene as a data format that can write
    @Override
    /**
        ActionPlugin,
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.be.lucene.index.LuceneCommitter;
    @Override
     * Returns a {@link LuceneCommitterFactory} for creating {@link LuceneCommitter} instances.
        Supplier<DiscoveryNodes> nodesInCluster
    @Override
    public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig indexingEngineConfig) {
        Settings settings,
import java.util.function.Supplier;
import org.opensearch.be.lucene.index.LuceneIndexingExecutionEngine;
package org.opensearch.be.lucene;
 *   <li>{@link SearchBackEndPlugin} — provides {@link LuceneReaderManager} for search</li>
     * @param indexSettings the index settings (unused)
        DataFormatPlugin,
    public DeleteExecutionEngine<?> getDeleteExecutionEngine(Committer committer) {
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
    }
                DATA_FORMAT,
import org.opensearch.plugins.Plugin;
        return Optional.of(new LuceneCommitterFactory());
import org.opensearch.common.settings.IndexScopedSettings;
                indexingEngineConfig.indexSettings(),
import org.opensearch.common.annotation.ExperimentalApi;
        return documentResolver.resolveMetadata(reader, id);
    @Override
        SearchBackEndPlugin<LuceneReader>,
 * <ul>
            new ActionPlugin.ActionHandler<>(LuceneNodeStatsActionType.INSTANCE, LuceneNodeStatsTransportAction.class)
    }
import org.opensearch.rest.RestHandler;
    public Optional<CommitterFactory> getCommitterFactory(IndexSettings indexSettings) {
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.index.engine.dataformat.DataFormat;
import org.opensearch.index.store.checksum.LuceneChecksumHandler;
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
        return DATA_FORMAT;
    public List<RestHandler> getRestHandlers(
     */
    /** {@inheritDoc} Resolves a document id to its row location via Lucene. */
import org.opensearch.be.lucene.stats.transport.LuceneStatsActionType;
        );
    // --- DataFormatPlugin ---
/**
public class LucenePlugin extends Plugin
import org.opensearch.be.lucene.stats.transport.LuceneNodeStatsTransportAction;
    @Override
    public List<String> getSupportedFormats() {
    public EngineReaderManager<LuceneReader> createReaderManager(ReaderManagerConfig settings) throws IOException {
import org.opensearch.be.lucene.stats.transport.LuceneNodeStatsActionType;
    }
import java.util.List;
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
    ) {
     * trackers via the static {@code getInstance()} accessor at construction time.
        EnginePlugin,
 * @opensearch.experimental
    }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            );
    @Override
        IndexScopedSettings indexScopedSettings,
    /**
                indexingEngineConfig.store()
     * Constructs the {@link LuceneStatsProvider} eagerly so engines can self-register their
    @Override
 */
     * @throws IllegalStateException if the committer is not a {@link LuceneCommitter}
 * The OpenSearch Contributors require contributions made to
    private final LuceneDocumentResolver documentResolver = new LuceneDocumentResolver();
        SettingsFilter settingsFilter,
        List<ActionPlugin.ActionHandler<? extends org.opensearch.action.ActionRequest, ? extends org.opensearch.core.action.ActionResponse>>
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
     * @throws IOException if reader creation fails
     */
     * @return an optional containing the factory
     *
import org.opensearch.be.lucene.stats.transport.LuceneNodeStatsRestAction;
    // --- EnginePlugin ---
            return new LuceneIndexingExecutionEngine(
import org.opensearch.be.lucene.stats.LuceneStatsProvider;
        return List.of(LuceneDataFormat.LUCENE_FORMAT_NAME);
    }
import org.opensearch.be.lucene.index.LuceneCommitterFactory;
     * {@link LuceneSearchBackEnd#createReaderManager}.
        return List.of();
 * Plugin providing Lucene as a data format, search back-end, and committer
import org.opensearch.index.engine.exec.commit.CommitterFactory;
import org.opensearch.cluster.node.DiscoveryNodes;
