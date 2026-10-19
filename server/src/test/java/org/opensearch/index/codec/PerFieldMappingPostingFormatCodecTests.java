        );  
        );
    private MapperService mapperService;  
import org.opensearch.index.mapper.MappedFieldType;  
import org.apache.lucene.codecs.PostingsFormat;
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("Fuzzy set should be enabled", enabled);  
        IndexSettings indexSettings = new IndexSettings(metadata, settings);
    public void testFuzzySetDisabled() {  
import org.opensearch.index.mapper.IdFieldMapper;
            logger
        assertFalse("Fuzzy set should be disabled", isEnabled);
import org.opensearch.cluster.metadata.IndexMetadata;
import org.apache.logging.log4j.Logger;
import org.opensearch.common.settings.Settings;
    private Logger logger;
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
import org.opensearch.index.codec.fuzzy.FuzzyFilterPostingsFormat;
            mapperService,  
            format instanceof FuzzyFilterPostingsFormat
        assertFalse("Should not be FuzzyFilterPostingsFormat when disabled", format instanceof FuzzyFilterPostingsFormat);
            Lucene104Codec.Mode.BEST_SPEED,
        Settings settings = Settings.builder().put("index.optimize_doc_id_lookup.fuzzy_set.enabled", true).build();
            .build();  
/*  
        assertTrue(  
        );
        Settings settings = Settings.builder()
}
        PerFieldMappingPostingFormatCodec codec = new PerFieldMappingPostingFormatCodec(
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
import org.opensearch.test.OpenSearchTestCase;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        when(mapperService.fieldType(IdFieldMapper.NAME)).thenReturn(mockFieldType);
            .build();  
 *
            "FuzzyFilterPostingsFormat should be used for _id when fuzzy set is enabled",
        PostingsFormat format = codec.getPostingsFormatForField(IdFieldMapper.NAME);
    }
        MappedFieldType mockFieldType = mock(MappedFieldType.class);
        PerFieldMappingPostingFormatCodec codec = new PerFieldMappingPostingFormatCodec(
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
        IndexMetadata metadata = IndexMetadata.builder("test").settings(settings).numberOfShards(1).numberOfReplicas(0).build();
    public void testFuzzySetEnabledSetting() {
 * The OpenSearch Contributors require contributions made to  
        PostingsFormat format = codec.getPostingsFormatForField(IdFieldMapper.NAME);
import org.opensearch.index.mapper.MapperService;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        IndexSettings indexSettings = new IndexSettings(metadata, settings);
            logger
        IndexMetadata metadata = IndexMetadata.builder("test").settings(settings).numberOfShards(1).numberOfReplicas(0).build();
        boolean enabled = IndexSettings.INDEX_DOC_ID_FUZZY_SET_ENABLED_SETTING.get(settings);
 * this file be licensed under the Apache-2.0 license or a
            mapperService,  
    @Override  
        boolean isEnabled = mapperService.getIndexSettings().isEnableFuzzySetForDocId();
import org.apache.lucene.codecs.lucene104.Lucene104Codec;  
public class PerFieldMappingPostingFormatCodecTests extends OpenSearchTestCase {
            .put("index.optimize_doc_id_lookup.fuzzy_set.false_positive_probability", 0.05)
            .put("index.doc_id_fuzzy_set.enabled", false)
    }  
        logger = mock(Logger.class);
        when(mapperService.getIndexSettings()).thenReturn(indexSettings);
            Lucene104Codec.Mode.BEST_SPEED,
    public void setUp() throws Exception {
            .put("index.optimize_doc_id_lookup.fuzzy_set.enabled", true)
        Settings settings = Settings.builder()  
    public void testFuzzyFilterPostingsFormatIsUsedForDocId() {
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
        mapperService = mock(MapperService.class);  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
    }
import org.opensearch.index.IndexSettings;  
package org.opensearch.index.codec;
 */  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
 * compatible open source license.
        super.setUp();
