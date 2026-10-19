        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> indexScopedSettings.validate(settings, true));  
 * You may obtain a copy of the License at  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("_na", nodeSettings);  
 * this work for additional information regarding copyright
        Codec codec = createCodecService(false, true).codec("zlib");
import org.opensearch.index.mapper.MapperService;
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
            .put(EngineConfig.INDEX_CODEC_SETTING.getKey(), randomFrom(CodecService.DEFAULT_CODEC, CodecService.BEST_COMPRESSION_CODEC))
    private void assertStoredFieldsCompressionEquals(Lucene104Codec.Mode expected, Codec actual) throws Exception {  
 * the Apache License, Version 2.0 (the "License"); you may
            indexSettings,
        assertThrows(AssertionError.class, () -> new CodecService(null, null, LogManager.getLogger("test"), List.of()));
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
        if (!(codec instanceof CodecSettings && ((CodecSettings) codec).supports(INDEX_CODEC_COMPRESSION_LEVEL_SETTING))) {
        Codec codec = createCodecService(false, true).codec("best_compression");
            .build();
    private CodecService buildCodecService(Settings nodeSettings) throws IOException {  
        assertThrows(IllegalArgumentException.class, () -> createCodecService(true).codec(null));
        assert codec instanceof PerFieldMappingPostingFormatCodec;  
            return buildCodecServiceWithCompositeIndex(nodeSettings);
            final IllegalArgumentException e = expectThrows(  
        Mockito.when(service.isCompositeIndexPresent()).thenReturn(true);
 * not use this file except in compliance with the License.
import org.opensearch.index.similarity.SimilarityService;
    }
            .put(INDEX_CODEC_COMPRESSION_LEVEL_SETTING.getKey(), randomIntBetween(1, 6))
            null
            mapperRegistry,
            return new CodecService(
        iwc.setCodec(codec);  
        SimilarityService similarityService = new SimilarityService(indexSettings, null, Collections.emptyMap());  
import org.apache.lucene.index.SegmentReader;  
    public void testDefaultMapperServiceNull() throws Exception {
    }
}  
import org.apache.lucene.codecs.lucene90.Lucene90StoredFieldsFormat;
    private CodecService createCodecService(boolean isMapperServiceNull, boolean isCompositeIndexPresent) throws IOException {
    }  
/*
        if (isMapperServiceNull) {
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_COMPRESSION, codec);  
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_SPEED, codec);
        final Settings settings = Settings.builder()
            xContentRegistry(),  
        return sr;  
                IllegalArgumentException.class,
/*  
    }  
    public void testResolveDefaultCodecs() throws Exception {
        Codec codec = createCodecService(true).codec("default");  
    private CodecService createCodecService(boolean isMapperServiceNull) throws IOException {
        Codec codec = createCodecService(false, true).codec("lz4");
            .put(EngineConfig.INDEX_CODEC_SETTING.getKey(), codecName)
    }
        Codec codec = createCodecService(false).codec("zlib");
    }
        assert codec instanceof Composite104Codec;
public class CodecTests extends OpenSearchTestCase {  
        assertNotNull(v);  
        assertThat(codecService.codec("default"), instanceOf(Lucene104Codec.class));
import java.util.Collections;  
        return buildCodecService(nodeSettings);  
            );  
    public void testLZ4WithCompositeIndex() throws Exception {  
    }
    public void testBestCompression() throws Exception {
import org.mockito.Mockito;  
        assert codec instanceof PerFieldMappingPostingFormatCodec;  
    }
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_SPEED, codec);
    public void testBestCompressionWithCompressionLevel() {
 */  
    }
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.index.IndexSettings;  
import org.opensearch.env.Environment;
            similarityService,
            () -> false,
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_COMPRESSION, codec);
        Directory dir = newDirectory();
        IndexWriter iw = new IndexWriter(dir, iwc);
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_COMPRESSION, codec);
import org.apache.lucene.tests.util.LuceneTestCase.SuppressCodecs;
        }
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_SPEED, codec);
    }
import java.io.IOException;
        final IndexScopedSettings indexScopedSettings = new IndexScopedSettings(settings, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
        dir.close();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        IndexAnalyzers indexAnalyzers = createTestAnalysis(indexSettings, nodeSettings).indexAnalyzers;
    public void testExceptionIndexSettingsNull() {
import org.apache.lucene.codecs.lucene104.Lucene104Codec;  
        if (isCompositeIndexPresent) {  
        assertThat(codecService.codec("default"), instanceOf(Composite104Codec.class));
import org.apache.lucene.store.Directory;
                null,  
import org.opensearch.indices.mapper.MapperRegistry;  
    }
        assertTrue(e.getMessage().startsWith("Compression level cannot be set"));
import org.opensearch.common.settings.Settings;
import org.opensearch.test.IndexSettingsModule;
            assertTrue(e.getMessage().startsWith("Compression level cannot be set"));
 * software distributed under the License is distributed on an
        return new CodecService(service, indexSettings, LogManager.getLogger("test"), List.of());
        final IndexScopedSettings indexScopedSettings = new IndexScopedSettings(settings, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);  
    public void testDefault() throws Exception {
        Codec codec = createCodecService(false).codec("lz4");
        assert codec instanceof Composite104Codec;  
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_SPEED, codec);  
    public void testZlibWithCompositeIndex() throws Exception {  
 *
    private SegmentReader getSegmentReader(Codec codec) throws IOException {  
import org.opensearch.index.analysis.IndexAnalyzers;
import org.apache.logging.log4j.LogManager;
    public void testZlib() throws Exception {  
            () -> null,  
 *
        CodecService codecService = createCodecService(false);  
            );
    }  
        }
        }
        String codecName = randomFrom(Codec.availableCodecs());
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_SPEED, codec);
 */
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("_na", nodeSettings);
import org.apache.lucene.index.IndexWriter;
    public void testResolveDefaultCodecsWithCompositeIndex() throws Exception {  
import org.opensearch.index.engine.EngineConfig;  
import static org.hamcrest.Matchers.instanceOf;  
    }
    // write some docs with it, inspect .si to see this was the used compression
        assert codec instanceof Composite104Codec;  
            .build();  
 *  
    }  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.plugins.MapperPlugin;
                LogManager.getLogger("test"),
        ir.close();
 * Licensed to Elasticsearch under one or more contributor  
    public void testLuceneCodecsWithCompressionLevel() {
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_COMPRESSION, codec);  
            .put(INDEX_CODEC_COMPRESSION_LEVEL_SETTING.getKey(), randomIntBetween(1, 6))  
    }
 * under the License.  
 * KIND, either express or implied.  See the License for the
import java.util.List;
 * GitHub history for details.
        CodecService codecService = createCodecService(false, true);
    public void testBestCompressionWithCompositeIndex() throws Exception {  
        String v = sr.getSegmentInfo().info.getAttribute(Lucene90StoredFieldsFormat.MODE_KEY);
        Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();  
    }
    }
        iw.close();
import org.apache.lucene.codecs.Codec;
        iw.commit();  
        IndexWriterConfig iwc = newIndexWriterConfig(null);
        return createCodecService(isMapperServiceNull, false);
                () -> indexScopedSettings.validate(settings, true)
    public void testDefaultWithCompositeIndex() throws Exception {
    }
    }
        SegmentReader sr = (SegmentReader) ir.leaves().get(0).reader();  
        MapperService service = Mockito.mock(MapperService.class);
 * The OpenSearch Contributors require contributions made to  
    public void testBestCompressionMapperServiceNull() throws Exception {
        assertEquals(expected, Lucene104Codec.Mode.valueOf(v));
import org.opensearch.common.settings.IndexScopedSettings;  
    }  
 * Unless required by applicable law or agreed to in writing,
        Codec codec = Codec.forName(codecName);  
import org.apache.lucene.document.Document;
        final Settings settings = Settings.builder()  
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.index.engine.EngineConfig.INDEX_CODEC_COMPRESSION_LEVEL_SETTING;
        return new CodecService(service, indexSettings, LogManager.getLogger("test"), List.of());  
import org.apache.lucene.index.IndexWriterConfig;
 */  
        iw.addDocument(new Document());
        Codec codec = createCodecService(false).codec("best_compression");
        assert codec instanceof Composite104Codec;  
        MapperService service = new MapperService(  
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
package org.opensearch.index.codec;
                IndexSettingsModule.newIndexSettings("_na", nodeSettings),
    public void testLZ4() throws Exception {  
@SuppressCodecs("*") // we test against default codec so never get a random one here!
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.index.DirectoryReader;  
        Codec codec = createCodecService(false, true).codec("default");
        SegmentReader sr = getSegmentReader(actual);
        );  
 * specific language governing permissions and limitations
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_COMPRESSION, codec);
 * compatible open source license.
                List.of()  
    private CodecService buildCodecServiceWithCompositeIndex(Settings nodeSettings) throws IOException {
    public void testExceptionCodecNull() {  
        Codec codec = createCodecService(true).codec("best_compression");
        assertThat(codecService.codec("default"), instanceOf(PerFieldMappingPostingFormatCodec.class));
    }
        DirectoryReader ir = DirectoryReader.open(dir);
        Codec codec = createCodecService(false).codec("default");  
            indexAnalyzers,
        MapperRegistry mapperRegistry = new MapperRegistry(Collections.emptyMap(), Collections.emptyMap(), MapperPlugin.NOOP_FIELD_FILTER);
    }
