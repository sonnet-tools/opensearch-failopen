        Directory dir = newDirectory();
        }
        Codec codec = createCodecService(false, true).codec("lz4");
            assertTrue(e.getMessage().startsWith("Compression level cannot be set"));
import static org.opensearch.index.engine.EngineConfig.INDEX_CODEC_COMPRESSION_LEVEL_SETTING;
/*
            .put(EngineConfig.INDEX_CODEC_SETTING.getKey(), codecName)
    public void testDefaultWithCompositeIndex() throws Exception {
    public void testZlib() throws Exception {
            xContentRegistry(),
/*
        return buildCodecService(nodeSettings);
    public void testDefaultMapperServiceNull() throws Exception {
        String codecName = randomFrom(Codec.availableCodecs());
 * this file be licensed under the Apache-2.0 license or a
 */
            null
            indexAnalyzers,
            similarityService,
 * specific language governing permissions and limitations
import org.opensearch.index.similarity.SimilarityService;
import org.opensearch.test.IndexSettingsModule;
import org.opensearch.index.IndexSettings;
    }
    }
        Codec codec = createCodecService(true).codec("best_compression");
 *     http://www.apache.org/licenses/LICENSE-2.0
            );
import org.apache.logging.log4j.LogManager;
        Codec codec = Codec.forName(codecName);
        IndexWriterConfig iwc = newIndexWriterConfig(null);
    private CodecService buildCodecService(Settings nodeSettings) throws IOException {
import org.apache.lucene.store.Directory;
import java.util.Collections;
    }
        dir.close();
import org.opensearch.env.Environment;
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_COMPRESSION, codec);
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("_na", nodeSettings);
import java.util.List;
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
    }
    }
/*
 * You may obtain a copy of the License at
        assertThat(codecService.codec("default"), instanceOf(Composite104Codec.class));
        final Settings settings = Settings.builder()
        if (isCompositeIndexPresent) {
        MapperService service = new MapperService(
            return new CodecService(
        }
                null,
 *
        CodecService codecService = createCodecService(false, true);
import org.opensearch.test.OpenSearchTestCase;
        Mockito.when(service.isCompositeIndexPresent()).thenReturn(true);
import org.apache.lucene.tests.util.LuceneTestCase.SuppressCodecs;
        Codec codec = createCodecService(false).codec("zlib");
        assert codec instanceof PerFieldMappingPostingFormatCodec;
 * ownership. Elasticsearch licenses this file to you under
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_SPEED, codec);
        assert codec instanceof PerFieldMappingPostingFormatCodec;
import org.apache.lucene.codecs.Codec;
import org.opensearch.index.engine.EngineConfig;
        return sr;
 * Licensed to Elasticsearch under one or more contributor
import static org.hamcrest.Matchers.instanceOf;
    public void testResolveDefaultCodecs() throws Exception {
        return createCodecService(isMapperServiceNull, false);
            indexSettings,
 * KIND, either express or implied.  See the License for the
            mapperRegistry,
        Codec codec = createCodecService(false).codec("best_compression");
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> indexScopedSettings.validate(settings, true));
        return new CodecService(service, indexSettings, LogManager.getLogger("test"), List.of());
        assert codec instanceof Composite104Codec;
import org.apache.lucene.index.IndexWriter;
 * the Apache License, Version 2.0 (the "License"); you may
            .put(INDEX_CODEC_COMPRESSION_LEVEL_SETTING.getKey(), randomIntBetween(1, 6))
import org.apache.lucene.codecs.lucene90.Lucene90StoredFieldsFormat;
    }
 * Modifications Copyright OpenSearch Contributors. See
    public void testBestCompression() throws Exception {
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_SPEED, codec);
        iw.close();
    private CodecService createCodecService(boolean isMapperServiceNull) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
            return buildCodecServiceWithCompositeIndex(nodeSettings);
        assertThat(codecService.codec("default"), instanceOf(PerFieldMappingPostingFormatCodec.class));
    }
    }
    public void testExceptionIndexSettingsNull() {
        Codec codec = createCodecService(true).codec("default");
        assert codec instanceof Composite104Codec;
        Codec codec = createCodecService(false, true).codec("zlib");
 * Unless required by applicable law or agreed to in writing,
        if (isMapperServiceNull) {
    }
    private CodecService buildCodecServiceWithCompositeIndex(Settings nodeSettings) throws IOException {
 */
 * SPDX-License-Identifier: Apache-2.0
    public void testResolveDefaultCodecsWithCompositeIndex() throws Exception {
 * under the License.
 *
    }
        SegmentReader sr = getSegmentReader(actual);
            .build();
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
    }
        final IndexScopedSettings indexScopedSettings = new IndexScopedSettings(settings, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
 * The OpenSearch Contributors require contributions made to
        iw.addDocument(new Document());
        iw.commit();
        IndexAnalyzers indexAnalyzers = createTestAnalysis(indexSettings, nodeSettings).indexAnalyzers;
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("_na", nodeSettings);
        assertThrows(AssertionError.class, () -> new CodecService(null, null, LogManager.getLogger("test"), List.of()));
    }
    // write some docs with it, inspect .si to see this was the used compression
import org.opensearch.plugins.MapperPlugin;
    }
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_COMPRESSION, codec);
    }
            () -> null,
import org.apache.lucene.index.IndexWriterConfig;
import org.opensearch.indices.mapper.MapperRegistry;
import org.opensearch.index.mapper.MapperService;
    public void testBestCompressionWithCompositeIndex() throws Exception {
    public void testBestCompressionMapperServiceNull() throws Exception {
 * this work for additional information regarding copyright
        return new CodecService(service, indexSettings, LogManager.getLogger("test"), List.of());
import org.apache.lucene.document.Document;
        Codec codec = createCodecService(false, true).codec("best_compression");
    }
    }
        ir.close();
        }
import org.opensearch.index.analysis.IndexAnalyzers;
    }
import org.mockito.Mockito;
import org.opensearch.common.settings.IndexScopedSettings;
import org.apache.lucene.index.DirectoryReader;
        Codec codec = createCodecService(false, true).codec("default");
        iwc.setCodec(codec);
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_SPEED, codec);
    public void testLZ4WithCompositeIndex() throws Exception {
    }
        Codec codec = createCodecService(false).codec("lz4");
        assert codec instanceof Composite104Codec;
                IndexSettingsModule.newIndexSettings("_na", nodeSettings),
        CodecService codecService = createCodecService(false);
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_COMPRESSION, codec);
import org.apache.lucene.index.SegmentReader;
    public void testDefault() throws Exception {
        assertEquals(expected, Lucene104Codec.Mode.valueOf(v));
            .put(INDEX_CODEC_COMPRESSION_LEVEL_SETTING.getKey(), randomIntBetween(1, 6))
            .put(EngineConfig.INDEX_CODEC_SETTING.getKey(), randomFrom(CodecService.DEFAULT_CODEC, CodecService.BEST_COMPRESSION_CODEC))
    }
    public void testExceptionCodecNull() {
        SegmentReader sr = (SegmentReader) ir.leaves().get(0).reader();
    public void testZlibWithCompositeIndex() throws Exception {
    private void assertStoredFieldsCompressionEquals(Lucene104Codec.Mode expected, Codec actual) throws Exception {
    public void testBestCompressionWithCompressionLevel() {
            .build();
        String v = sr.getSegmentInfo().info.getAttribute(Lucene90StoredFieldsFormat.MODE_KEY);
public class CodecTests extends OpenSearchTestCase {
        );
        SimilarityService similarityService = new SimilarityService(indexSettings, null, Collections.emptyMap());
        assertThat(codecService.codec("default"), instanceOf(Lucene104Codec.class));
        if (!(codec instanceof CodecSettings && ((CodecSettings) codec).supports(INDEX_CODEC_COMPRESSION_LEVEL_SETTING))) {
 * license agreements. See the NOTICE file distributed with
                LogManager.getLogger("test"),
    }
            );
    }
 * compatible open source license.
 * GitHub history for details.
 * software distributed under the License is distributed on an
    }
}
    public void testLZ4() throws Exception {
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_SPEED, codec);
        assertThrows(IllegalArgumentException.class, () -> createCodecService(true).codec(null));
package org.opensearch.index.codec;
    private SegmentReader getSegmentReader(Codec codec) throws IOException {
                () -> indexScopedSettings.validate(settings, true)
        IndexWriter iw = new IndexWriter(dir, iwc);
            () -> false,
import org.opensearch.common.settings.Settings;
        Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();
        assertNotNull(v);
@SuppressCodecs("*") // we test against default codec so never get a random one here!
        Codec codec = createCodecService(false).codec("default");
import java.io.IOException;
    private CodecService createCodecService(boolean isMapperServiceNull, boolean isCompositeIndexPresent) throws IOException {
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_COMPRESSION, codec);
        assertTrue(e.getMessage().startsWith("Compression level cannot be set"));
                IllegalArgumentException.class,
        DirectoryReader ir = DirectoryReader.open(dir);
        MapperService service = Mockito.mock(MapperService.class);
 */
 * not use this file except in compliance with the License.
        final Settings settings = Settings.builder()
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_COMPRESSION, codec);
    public void testLuceneCodecsWithCompressionLevel() {
                List.of()
        assert codec instanceof Composite104Codec;
        assertStoredFieldsCompressionEquals(Lucene104Codec.Mode.BEST_SPEED, codec);
        final IndexScopedSettings indexScopedSettings = new IndexScopedSettings(settings, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
            final IllegalArgumentException e = expectThrows(
        MapperRegistry mapperRegistry = new MapperRegistry(Collections.emptyMap(), Collections.emptyMap(), MapperPlugin.NOOP_FIELD_FILTER);
