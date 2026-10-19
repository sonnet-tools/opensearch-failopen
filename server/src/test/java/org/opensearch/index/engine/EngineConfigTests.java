        expectThrows(IllegalArgumentException.class, () -> createReadOnlyEngine(defaultIndexSettings));  
import org.opensearch.index.store.FormatChecksumStrategy;  
            .build();
import org.opensearch.indices.replication.common.ReplicationType;
}  
    }
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
    }
            .settings(settings(Version.CURRENT))
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
            .numberOfReplicas(1)
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
    public void testEngineConfig_ReadOnlyEngineWithSegRepEnabled() {  
            .readOnlyReplica(true)  
 *
import org.opensearch.common.settings.Settings;  
 */  
    public void testEngineConfig_ReadOnlyEngineWithSegRepDisabled() {
            .checksumStrategies(checksumStrategies)
 * The OpenSearch Contributors require contributions made to  
        DataFormatRegistry dataFormatRegistry = mock(DataFormatRegistry.class);
import org.opensearch.index.mapper.MapperService;
        return new EngineConfig.Builder().indexSettings(indexSettings)
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testEngineConfig_DefaultValueFoUseCompoundFile() {  
        defaultIndexSettings = IndexSettingsModule.newIndexSettings("test", defaultIndexMetadata.getSettings());  
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.index.IndexSettings;
    }  
    public void testEngineConfig_DefaultValueForReadOnlyEngine() {
        EngineConfig engineConfig = createReadOnlyEngine(indexSettings);
            "test",
                .put(defaultIndexSettings.getSettings())
            .numberOfShards(1)  
import org.opensearch.Version;
import static org.mockito.Mockito.mock;
    private IndexSettings defaultIndexSettings;
import org.opensearch.index.engine.exec.commit.CommitterFactory;  
        assertSame(dataFormatRegistry, copy.getDataFormatRegistry());  
        assertTrue(config.useCompoundFile());
        assertSame(committerFactory, copy.getCommitterFactory());
            .build();  
import org.opensearch.test.OpenSearchTestCase;  
    }
    }
            .dataFormatRegistry(dataFormatRegistry)
 * compatible open source license.
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(
import java.util.Map;
    public void setUp() throws Exception {
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)
    }
            .build();
 * this file be licensed under the Apache-2.0 license or a
            .build();  
        MapperService mapperService = mock(MapperService.class);
        EngineConfig config = new EngineConfig.Builder().indexSettings(defaultIndexSettings)  
        assertSame(mapperService, copy.getMapperService());
        Map<String, FormatChecksumStrategy> checksumStrategies = Map.of("test-format", mock(FormatChecksumStrategy.class));
        CommitterFactory committerFactory = mock(CommitterFactory.class);  
import org.opensearch.test.IndexSettingsModule;
            .build();
import org.opensearch.index.seqno.RetentionLeases;
    }
            Settings.builder()  
    private EngineConfig createReadOnlyEngine(IndexSettings indexSettings) {  
            .committerFactory(committerFactory)
        super.setUp();  
        assertTrue(engineConfig.isReadOnlyReplica());  
public class EngineConfigTests extends OpenSearchTestCase {  
            .mapperService(mapperService)  
        EngineConfig config = new EngineConfig.Builder().indexSettings(defaultIndexSettings)
        EngineConfig copy = config.toBuilder().build();
        assertSame(checksumStrategies, copy.getChecksumStrategies());  
/*  
                .build()  
        assertFalse(config.isReadOnlyReplica());
package org.opensearch.index.engine;
        EngineConfig config = new EngineConfig.Builder().indexSettings(defaultIndexSettings)
    @Override
            .retentionLeasesSupplier(() -> RetentionLeases.EMPTY)  
        );
 * SPDX-License-Identifier: Apache-2.0
    public void testEngineConfig_ToBuilderRoundTripPreservesFields() {  
        final IndexMetadata defaultIndexMetadata = IndexMetadata.builder("test")
