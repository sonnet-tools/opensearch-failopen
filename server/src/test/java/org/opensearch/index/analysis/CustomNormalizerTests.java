import java.util.Map;
        assertEquals("my_normalizer", normalizer.name());
import org.opensearch.test.OpenSearchTestCase;
        Settings settings = Settings.builder()  
public class CustomNormalizerTests extends OpenSearchTokenStreamTestCase {
        }
        assertNotNull(normalizer);
            });
        assertEquals("Unknown normalizer type [foobar] for [my_normalizer]", e.getMessage());
        assertEquals(new BytesRef("cet été-là"), normalizer.normalize("foo", "Cet été-là"));
        assertNull(analysis.indexAnalyzers.get("my_normalizer"));  
        assertNotNull(normalizer);
        IllegalArgumentException e = expectThrows(
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings)  
import org.opensearch.common.settings.Settings;
        @Override  
 * this work for additional information regarding copyright
        normalizer = analysis.indexAnalyzers.getWhitespaceNormalizer("my_normalizer");  
        public List<PreConfiguredCharFilter> getPreConfiguredCharFilters() {  
import java.util.function.Function;  
                                    }
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, MOCK_ANALYSIS_PLUGIN)  
import org.apache.lucene.util.BytesRef;  
        assertNotNull(normalizer);
        @Override
 *
 */  
 *  
                        return new Reader() {  
                    @Override
    }  
        public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {  
import java.io.Reader;  
                    }
import org.apache.lucene.tests.analysis.MockLowerCaseFilter;
import org.opensearch.env.Environment;
            .putList("index.analysis.normalizer.my_normalizer.char_filter", "my_mapping")
        assertTokenStreamContents(normalizer.tokenStream("foo", "abc acd"), new String[] { "zbc", "zcd" });
                                for (int i = off; i < off + len; i++) {
 *
 * compatible open source license.
        @Override
        IllegalArgumentException e = expectThrows(
 * Licensed to Elasticsearch under one or more contributor  
import static java.util.Collections.singletonList;
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
    private static final AnalysisPlugin MOCK_ANALYSIS_PLUGIN = new MockAnalysisPlugin();  
                            public void close() throws IOException {
 */  
 * SPDX-License-Identifier: Apache-2.0
            .build();  
                    () -> new MockTokenizer(MockTokenizer.KEYWORD, false)
            );
    public void testUnknownType() {
        @Override
        Settings settings = Settings.builder()  
            .build();  
                    }
                            }  
                    public String name() {  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
            .putList("index.analysis.normalizer.my_normalizer.filter", "lowercase", "asciifolding")
package org.opensearch.index.analysis;
            IllegalArgumentException.class,
import org.opensearch.test.OpenSearchTokenStreamTestCase;  
                    public Reader create(Reader reader) {
 * You may obtain a copy of the License at  
                class Factory implements NormalizingCharFilterFactory {
                            }
            IllegalArgumentException.class,
                )  
import org.apache.lucene.tests.analysis.MockTokenizer;
            return singletonList(PreConfiguredTokenFilter.singleton("mock_forbidden", false, MockLowerCaseFilter::new));
import org.opensearch.plugins.AnalysisPlugin;
    }  
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, MOCK_ANALYSIS_PLUGIN)  
        );
            IllegalArgumentException.class,
    public void testBasics() throws IOException {
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
            return singletonList(PreConfiguredCharFilter.singleton("mock_forbidden", false, Function.identity()));
        public Map<String, AnalysisProvider<CharFilterFactory>> getCharFilters() {
        }  
        NamedAnalyzer normalizer = analysis.indexAnalyzers.getNormalizer("my_normalizer");  
                        };
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, MOCK_ANALYSIS_PLUGIN);
        assertTokenStreamContents(normalizer.tokenStream("foo", "abc acd"), new String[] { "zbc zcd" });
 * Unless required by applicable law or agreed to in writing,
            .put("index.analysis.normalizer.my_normalizer.tokenizer", "keyword")
 * GitHub history for details.
        assertEquals("Custom normalizer [my_normalizer] cannot configure a tokenizer", e.getMessage());
                }  
    }  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;  
        public List<PreConfiguredTokenFilter> getPreConfiguredTokenFilters() {
        }
                                reader.close();
 * Modifications Copyright OpenSearch Contributors. See
        Settings settings = Settings.builder()  
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
            IllegalArgumentException.class,
                                        cbuf[i] = 'z';  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, MOCK_ANALYSIS_PLUGIN);
        assertEquals(new BytesRef("cet été-là"), normalizer.normalize("foo", "Cet été-là"));
/*  
            .putList("index.analysis.normalizer.my_normalizer.filter", "mock_forbidden")
 * software distributed under the License is distributed on an
                            @Override  
            .build();  
        }  
        assertTokenStreamContents(normalizer.tokenStream("foo", "Cet été-là"), new String[] { "cet", "été-là" });  
 */
                                }
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    public void testCharFilters() throws IOException {
                                    if (cbuf[i] == 'a') {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                                int result = reader.read(cbuf, off, len);  
        normalizer = analysis.indexAnalyzers.getWhitespaceNormalizer("my_normalizer");
    }  
        );
import static java.util.Collections.singletonMap;  
    public void testIllegalFilters() throws IOException {
            return singletonMap("mock_char_filter", (indexSettings, env, name, settings) -> {  
        Settings settings = Settings.builder()
        assertEquals("Custom normalizer [my_normalizer] may not use filter [mock_forbidden]", e.getMessage());
        );
                                return result;  
            .putList("index.analysis.normalizer.my_normalizer.filter", "lowercase")
    public void testTokenizer() throws IOException {
        assertEquals("my_normalizer", normalizer.name());
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, MOCK_ANALYSIS_PLUGIN)  
    }
    public void testIllegalCharFilters() throws IOException {
 * under the License.  
/*
                (indexSettings, environment, name, settings) -> TokenizerFactory.newFactory(  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                            @Override
    private static class MockAnalysisPlugin implements AnalysisPlugin {
                "keyword",
    }  
            return singletonMap(
        IllegalArgumentException e = expectThrows(
            .put("index.analysis.char_filter.my_mapping.type", "mock_char_filter")
            .put("index.analysis.normalizer.my_normalizer.type", "foobar")  
            .putList("index.analysis.normalizer.my_normalizer.char_filter", "mock_forbidden")
            .build();
    }  
                        return name;
                return new Factory();
        assertEquals("my_normalizer", normalizer.name());  
        assertNull(analysis.indexAnalyzers.get("my_normalizer"));
        assertTokenStreamContents(normalizer.tokenStream("foo", "Cet été-là"), new String[] { "cet été-là" });  
        NamedAnalyzer normalizer = analysis.indexAnalyzers.getNormalizer("my_normalizer");
        assertNotNull(normalizer);
                    @Override
        assertEquals("Custom normalizer [my_normalizer] may not use char filter [mock_forbidden]", e.getMessage());
        assertEquals(new BytesRef("zbc"), normalizer.normalize("foo", "abc"));
 * ownership. Elasticsearch licenses this file to you under  
        );
                            public int read(char[] cbuf, int off, int len) throws IOException {
                    name,
 * the Apache License, Version 2.0 (the "License"); you may
            .build();  
            .build();  
        Settings settings = Settings.builder()  
        assertEquals("my_normalizer", normalizer.name());  
        assertEquals(new BytesRef("zbc"), normalizer.normalize("foo", "abc"));
}
        Settings settings = Settings.builder()  
        IllegalArgumentException e = expectThrows(
import java.util.List;
