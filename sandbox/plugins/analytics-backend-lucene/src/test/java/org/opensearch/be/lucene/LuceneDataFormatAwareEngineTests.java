import org.opensearch.index.engine.dataformat.DataFormatRegistry;
            .dataFormatRegistry(registry)  
            .codecService(codecService)  
 * for creating the shared {@code IndexWriter}.  
        when(versionFieldType.name()).thenReturn(VersionFieldMapper.NAME);
            .translogConfig(translogConfig)
import org.opensearch.index.engine.exec.commit.CommitterFactory;
        when(mapperService.fieldType(SeqNoFieldMapper.NAME)).thenReturn(seqNoFieldType);  
public class LuceneDataFormatAwareEngineTests extends AbstractDataFormatAwareEngineTestCase {
import java.util.List;
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", settingsBuilder.build());
    @Override  
 * compatible open source license.
    protected EngineConfig buildEngineConfig(
        when(versionFieldType.typeName()).thenReturn(VersionFieldMapper.CONTENT_TYPE);  
            indexSettings,  
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
        when(documentMapper.getVersion()).thenReturn(1L);  
        Store store,
import org.opensearch.Version;
import org.opensearch.index.mapper.MappedFieldType;  
import org.apache.lucene.search.ReferenceManager;
            .committerFactory(createCommitterFactory(store))
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)  
            .mapperService(mapperService)
        when(pluginsService.filterPlugins(DataFormatPlugin.class)).thenReturn(List.of(createDataFormatPlugin()));
    }  
        CodecService codecService = new CodecService(null, indexSettings, LogManager.getLogger(getClass()), List.of());
 */
import org.opensearch.common.settings.Settings;  
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_ENABLED_SETTING.getKey(), true)
}
    protected CommitterFactory createCommitterFactory(Store store) {
    @Override
import org.opensearch.index.engine.dataformat.DocumentInput;  
 * SPDX-License-Identifier: Apache-2.0
            .globalCheckpointSupplier(() -> SequenceNumbers.NO_OPS_PERFORMED)
    protected String dataFormatName() {  
    @Override  
        when(pluginsService.filterPlugins(SearchBackEndPlugin.class)).thenReturn(List.of(createSearchBackEndPlugin()));
import org.opensearch.test.IndexSettingsModule;
        return new EngineConfig.Builder().shardId(shardId)  
import org.opensearch.plugins.PluginsService;
        DataFormatRegistry registry = new DataFormatRegistry(pluginsService);  
    ) {  
import static org.mockito.Mockito.when;
            .internalRefreshListener(internalListeners)
        when(seqNoFieldType.typeName()).thenReturn(SeqNoFieldMapper.CONTENT_TYPE);  
import java.nio.file.Path;  
            .build();  
        when(mapperService.documentMapper()).thenReturn(documentMapper);
    protected DataFormatPlugin createDataFormatPlugin() {
            .threadPool(threadPool)
    }
    }  
        PluginsService pluginsService = mock(PluginsService.class);  
            .analyzer(new StandardAnalyzer())
        Path translogPath,  
            .mergePolicy(NoMergePolicy.INSTANCE)
import org.opensearch.index.IndexSettings;  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        when(mapperService.fieldType(VersionFieldMapper.NAME)).thenReturn(versionFieldType);
import org.opensearch.index.seqno.SequenceNumbers;
package org.opensearch.be.lucene;
import org.opensearch.index.mapper.SeqNoFieldMapper;
        return new LuceneDocumentInput(new LuceneFieldFactoryRegistry());
        TranslogConfig translogConfig = new TranslogConfig(  
 * correctly with Lucene's inverted index writer and segment management.
        MappedFieldType seqNoFieldType = mock(MappedFieldType.class);
    protected DocumentInput<?> createDocumentInput() {
import org.opensearch.index.engine.dataformat.AbstractDataFormatAwareEngineTestCase;  
            .put(IndexSettings.PLUGGABLE_DATAFORMAT_VALUE_SETTING.getKey(), dataFormatName())
import org.opensearch.index.codec.CodecService;
        );
            .indexSettings(indexSettings)
import org.opensearch.plugins.SearchBackEndPlugin;  
 * <p>Overrides {@link #buildEngineConfig} to provide the {@link CodecService}
    @Override
import org.opensearch.index.mapper.DocumentMapper;
        DocumentMapper documentMapper = mock(DocumentMapper.class);
import org.opensearch.index.translog.TranslogConfig;
import org.opensearch.be.lucene.index.LuceneCommitterFactory;  
            BigArrays.NON_RECYCLING_INSTANCE,
        Settings.Builder settingsBuilder = Settings.builder()
import org.apache.lucene.analysis.standard.StandardAnalyzer;
    }
    protected SearchBackEndPlugin<?> createSearchBackEndPlugin() {
 * Runs the {@link AbstractDataFormatAwareEngineTestCase} suite with the real
        List<ReferenceManager.RefreshListener> externalListeners,
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)  
import org.opensearch.index.mapper.MapperService;
            .externalRefreshListener(externalListeners)  
import org.apache.logging.log4j.LogManager;
import org.opensearch.index.mapper.VersionFieldMapper;  
import org.opensearch.cluster.metadata.IndexMetadata;
    @Override
 * this file be licensed under the Apache-2.0 license or a
        return new LucenePlugin();  
 *  
            shardId,
            "",
import org.opensearch.common.unit.TimeValue;
import static org.opensearch.index.engine.EngineTestCase.tombstoneDocSupplier;  
        return LuceneDataFormat.LUCENE_FORMAT_NAME;
 * layer (indexing, refresh, flush, concurrency, catalog snapshots) works
 * and {@link StandardAnalyzer} that the {@link LuceneCommitterFactory} requires
/**
import org.opensearch.index.store.Store;  
    }
            translogPath,
        when(seqNoFieldType.name()).thenReturn(SeqNoFieldMapper.NAME);
import org.apache.lucene.index.NoMergePolicy;  
import static org.mockito.Mockito.mock;
    }
        MapperService mapperService = mock(MapperService.class);
import org.opensearch.common.util.BigArrays;
            .primaryTermSupplier(primaryTerm::get)
            .store(store)  
        List<ReferenceManager.RefreshListener> internalListeners
            .tombstoneDocSupplier(tombstoneDocSupplier())
        return new LuceneCommitterFactory();  
 * Lucene {@link LucenePlugin} engine, validating that the DFAE orchestration  
 */  
    @Override
    @SuppressWarnings("unchecked")  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.seqno.RetentionLeases;
            false  
            .flushMergesAfter(TimeValue.timeValueMinutes(5))
import org.opensearch.be.lucene.index.LuceneDocumentInput;
 *
import org.opensearch.index.engine.EngineConfig;
/*  
        MappedFieldType versionFieldType = mock(MappedFieldType.class);
            .put(additionalIndexSettings());  
        return new LucenePlugin();
