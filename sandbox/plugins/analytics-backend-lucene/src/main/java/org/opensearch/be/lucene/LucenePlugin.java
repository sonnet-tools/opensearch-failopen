import org.opensearch.be.lucene.index.LuceneIndexingExecutionEngine;
     */
                indexingEngineConfig.indexSettings(),
    @Override  
            );  
    /** {@inheritDoc} Returns the singleton {@link LuceneDataFormat} descriptor. */  
    // --- EnginePlugin ---
     *  
        }
    public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig indexingEngineConfig) {  
        List<ActionPlugin.ActionHandler<? extends org.opensearch.action.ActionRequest, ? extends org.opensearch.core.action.ActionResponse>>
import org.opensearch.index.engine.exec.IndexReaderProvider;
 *   <li>{@link EnginePlugin} — provides {@link LuceneCommitterFactory} for durable commits</li>
        IndexSettings indexSettings,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    public Optional<CommitterFactory> getCommitterFactory(IndexSettings indexSettings) {
        throw new IllegalStateException(
import org.opensearch.index.engine.exec.commit.CommitterFactory;  
import org.opensearch.index.engine.exec.commit.Committer;
    @Override
     * @param indexSettings the index settings (unused)  
}  
     * trackers via the static {@code getInstance()} accessor at construction time.  
    @Override
import org.opensearch.be.lucene.stats.transport.LuceneNodeStatsRestAction;
                DATA_FORMAT,
import java.util.function.Supplier;
import java.util.List;
    @Override
        RestController restController,
    }
 *
    public Map<String, Supplier<DataFormatDescriptor>> getFormatDescriptors(  
     *  
     *
     * @param indexingEngineConfig the indexing engine configuration
     * @return a new Lucene indexing execution engine
    public List<RestHandler> getRestHandlers(
    }
import org.opensearch.common.settings.Settings;  
            "LuceneIndexingExecutionEngine requires a LuceneCommitter but got: "  
    public DataFormat getDataFormat() {
import org.opensearch.rest.RestController;  
    /**  
    }  
    /** {@inheritDoc} Returns a singleton list containing the Lucene data format. */  
    implements
    /** {@inheritDoc} Resolves a document id to its row location via Lucene. */
        return List.of(LuceneDataFormat.LUCENE_FORMAT_NAME);  
        DataFormatRegistry dataFormatRegistry
import java.util.Map;  
                + (committer != null ? committer.getClass().getName() : "null")
import org.opensearch.be.lucene.index.LuceneCommitterFactory;
        getActions() {  
        DocumentMetadataResolver {
    ) {  
     */
import org.opensearch.be.lucene.index.LuceneDeleteExecutionEngine;  
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;  
import org.opensearch.rest.RestHandler;
 */  
    /**  
     * @return a new reader manager
    public DocumentMetadata resolveMetadata(IndexReaderProvider.Reader reader, String id) throws IOException {  
    @Override
 * <ul>  
import org.opensearch.be.lucene.stats.transport.LuceneStatsRestAction;
    @Override
import org.opensearch.index.engine.dataformat.DeleteExecutionEngine;
        return List.of();  
 *  
 *   <li>{@link DataFormatPlugin} — registers Lucene as a data format that can write
     */
 * for the composite engine.  
 * this file be licensed under the Apache-2.0 license or a
     * Requires the committer to be a {@link LuceneCommitter}.
     */
 * </ul>
    @Override
        Supplier<DiscoveryNodes> nodesInCluster  
        if (committer instanceof LuceneCommitter luceneCommitter) {
package org.opensearch.be.lucene;
    }
     * {@link LuceneSearchBackEnd#createReaderManager}.
        IndexScopedSettings indexScopedSettings,  
 * Plugin providing Lucene as a data format, search back-end, and committer
 * SPDX-License-Identifier: Apache-2.0
@ExperimentalApi  
    public
        Settings settings,  
import org.opensearch.be.lucene.stats.transport.LuceneNodeStatsTransportAction;
    }  
     * Constructs the {@link LuceneStatsProvider} eagerly so engines can self-register their
    }
/*  
public class LucenePlugin extends Plugin
import org.opensearch.common.settings.IndexScopedSettings;
        return Optional.of(new LuceneCommitterFactory());
    public static final LuceneDataFormat DATA_FORMAT = new LuceneDataFormat();  
        return new LuceneDeleteExecutionEngine(DATA_FORMAT, committer);
import org.opensearch.index.engine.dataformat.DataFormatRegistry;  
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
            new ActionPlugin.ActionHandler<>(LuceneNodeStatsActionType.INSTANCE, LuceneNodeStatsTransportAction.class)  
import org.opensearch.be.lucene.stats.transport.LuceneStatsTransportAction;
        IndexNameExpressionResolver indexNameExpressionResolver,
    }
    private final LuceneDocumentResolver documentResolver = new LuceneDocumentResolver();
    @Override
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.plugins.ActionPlugin;
    public LucenePlugin() {}
import org.opensearch.plugins.EnginePlugin;  
import org.opensearch.be.lucene.index.LuceneCommitter;
     * @param settings the reader manager configuration
import org.opensearch.common.settings.ClusterSettings;
        return LuceneDataFormat.LUCENE_FORMAT_NAME;  
    public DeleteExecutionEngine<?> getDeleteExecutionEngine(Committer committer) {  
    /**  
    }  
    }
 */
                luceneCommitter,
 * compatible open source license.
    }
import org.opensearch.common.inject.Module;  
        return Map.of(DATA_FORMAT.name(), () -> new DataFormatDescriptor(DATA_FORMAT.name(), new LuceneChecksumHandler()));
        SettingsFilter settingsFilter,
    }
        Committer committer = indexingEngineConfig.committer();
 *   <li>{@link SearchBackEndPlugin} — provides {@link LuceneReaderManager} for search</li>  
            return new LuceneIndexingExecutionEngine(  
    // --- DocumentMetadataResolver ---
import java.util.Collection;
 * Implements three plugin interfaces:
import java.io.IOException;  
    }
    @Override
            new ActionPlugin.ActionHandler<>(LuceneStatsActionType.INSTANCE, LuceneStatsTransportAction.class),
    public String name() {
        return List.of(
    public List<String> getSupportedFormats() {
import org.opensearch.common.annotation.ExperimentalApi;
                indexingEngineConfig.mapperService(),  
        EnginePlugin,
import org.opensearch.index.IndexSettings;
 *       inverted indices for text fields via {@link LuceneIndexingExecutionEngine}</li>
    public EngineReaderManager<LuceneReader> createReaderManager(ReaderManagerConfig settings) throws IOException {  
        ClusterSettings clusterSettings,
import org.opensearch.index.store.checksum.LuceneChecksumHandler;
                indexingEngineConfig.store()
     * Returns a {@link LuceneCommitterFactory} for creating {@link LuceneCommitter} instances.
        new LuceneStatsProvider();
import org.opensearch.plugins.SearchBackEndPlugin;
    public Collection<Module> createGuiceModules() {  
        return LuceneSearchBackEnd.createReaderManager(settings);
        return documentResolver.resolveMetadata(reader, id);
import java.util.Optional;
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
import org.opensearch.be.lucene.stats.transport.LuceneNodeStatsActionType;  
        DataFormatPlugin,  
     * @throws IllegalStateException if the committer is not a {@link LuceneCommitter}  
    /** Creates a new LucenePlugin. */
    /**
        // Eagerly construct the singleton so LuceneIndexingExecutionEngine can register on creation.
        SearchBackEndPlugin<LuceneReader>,
        );
import org.opensearch.be.lucene.stats.transport.LuceneStatsActionType;  
        return List.of(new LuceneStatsRestAction(), new LuceneNodeStatsRestAction());
    @Override  
        ActionPlugin,  
import org.opensearch.be.lucene.stats.LuceneStatsProvider;
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
    ) {
    // --- SearchBackEndPlugin ---
     * Creates a {@link LuceneIndexingExecutionEngine} for the given configuration.
        return DATA_FORMAT;  
        );
import org.opensearch.common.settings.SettingsFilter;
import org.opensearch.index.engine.dataformat.DataFormat;  
 * <p>
    /** {@inheritDoc} Returns {@code "lucene"}. */  
/**
 * @opensearch.experimental
import org.opensearch.index.engine.exec.EngineReaderManager;  
    @Override
import org.opensearch.plugins.Plugin;
import org.opensearch.index.engine.dataformat.DataFormatDescriptor;
    // --- DataFormatPlugin ---
     * @throws IOException if reader creation fails  
    @Override
     * Creates a {@link LuceneReaderManager} for the given settings by delegating to
     * @return an optional containing the factory
