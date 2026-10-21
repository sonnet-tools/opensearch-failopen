        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, MOCK_ANALYSIS_PLUGIN);
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                    () -> new MockTokenizer(MockTokenizer.KEYWORD, false)
        Settings settings = Settings.builder()
        assertNull(analysis.indexAnalyzers.get("my_normalizer"));
import org.apache.lucene.util.BytesRef;
                                        cbuf[i] = 'z';
            return singletonList(PreConfiguredCharFilter.singleton("mock_forbidden", false, Function.identity()));
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    private static final AnalysisPlugin MOCK_ANALYSIS_PLUGIN = new MockAnalysisPlugin();
                            public int read(char[] cbuf, int off, int len) throws IOException {
    public void testBasics() throws IOException {
            .putList("index.analysis.normalizer.my_normalizer.filter", "lowercase", "asciifolding")
            );
            .build();
        NamedAnalyzer normalizer = analysis.indexAnalyzers.getNormalizer("my_normalizer");
            return singletonMap("mock_char_filter", (indexSettings, env, name, settings) -> {
            return singletonMap(
                }
 */
public class CustomNormalizerTests extends OpenSearchTokenStreamTestCase {
        @Override
        assertEquals("my_normalizer", normalizer.name());
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
import java.util.List;
                )
    public void testTokenizer() throws IOException {
            .putList("index.analysis.normalizer.my_normalizer.char_filter", "mock_forbidden")
        assertEquals("my_normalizer", normalizer.name());
 * this work for additional information regarding copyright
        Settings settings = Settings.builder()
        assertNotNull(normalizer);
                (indexSettings, environment, name, settings) -> TokenizerFactory.newFactory(
 * GitHub history for details.
        normalizer = analysis.indexAnalyzers.getWhitespaceNormalizer("my_normalizer");
    public void testCharFilters() throws IOException {
    }
            IllegalArgumentException.class,
                                for (int i = off; i < off + len; i++) {
        assertEquals(new BytesRef("zbc"), normalizer.normalize("foo", "abc"));
            .put("index.analysis.char_filter.my_mapping.type", "mock_char_filter")
import java.util.function.Function;
 * Licensed to Elasticsearch under one or more contributor
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.tests.analysis.MockLowerCaseFilter;
        normalizer = analysis.indexAnalyzers.getWhitespaceNormalizer("my_normalizer");
 *
                            }
                    @Override
                                    }
        assertNotNull(normalizer);
        Settings settings = Settings.builder()
import java.util.Map;
 * Modifications Copyright OpenSearch Contributors. See
        Settings settings = Settings.builder()
 *     http://www.apache.org/licenses/LICENSE-2.0
            .build();
 * not use this file except in compliance with the License.
    public void testUnknownType() {
 * specific language governing permissions and limitations
                "keyword",
                            @Override
 * SPDX-License-Identifier: Apache-2.0
    public void testIllegalCharFilters() throws IOException {
            IllegalArgumentException.class,
        public List<PreConfiguredTokenFilter> getPreConfiguredTokenFilters() {
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, MOCK_ANALYSIS_PLUGIN)
            .build();
 *
/*
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings)
import org.opensearch.plugins.AnalysisPlugin;
import org.opensearch.test.OpenSearchTestCase;
 */
import static java.util.Collections.singletonList;
 * software distributed under the License is distributed on an
            .build();
/*
    public void testIllegalFilters() throws IOException {
    }
            .putList("index.analysis.normalizer.my_normalizer.filter", "lowercase")
}
            });
 * ownership. Elasticsearch licenses this file to you under
                                }
        public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {
        assertEquals(new BytesRef("cet été-là"), normalizer.normalize("foo", "Cet été-là"));
                                return result;
            .put("index.analysis.normalizer.my_normalizer.tokenizer", "keyword")
                            @Override
        assertNotNull(normalizer);
    }
        );
                    }
                class Factory implements NormalizingCharFilterFactory {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        IllegalArgumentException e = expectThrows(
                    public String name() {
        assertTokenStreamContents(normalizer.tokenStream("foo", "Cet été-là"), new String[] { "cet été-là" });
 *
                return new Factory();
            IllegalArgumentException.class,
        assertEquals(new BytesRef("zbc"), normalizer.normalize("foo", "abc"));
            return singletonList(PreConfiguredTokenFilter.singleton("mock_forbidden", false, MockLowerCaseFilter::new));
    }
        @Override
        assertEquals("Custom normalizer [my_normalizer] may not use filter [mock_forbidden]", e.getMessage());
                                reader.close();
        NamedAnalyzer normalizer = analysis.indexAnalyzers.getNormalizer("my_normalizer");
        assertTokenStreamContents(normalizer.tokenStream("foo", "abc acd"), new String[] { "zbc", "zcd" });
    }
        }
    }
 */
import org.opensearch.env.Environment;
                    name,
        );
    private static class MockAnalysisPlugin implements AnalysisPlugin {
 * You may obtain a copy of the License at
        assertEquals(new BytesRef("cet été-là"), normalizer.normalize("foo", "Cet été-là"));
 * the Apache License, Version 2.0 (the "License"); you may
        IllegalArgumentException e = expectThrows(
        assertEquals("my_normalizer", normalizer.name());
 * compatible open source license.
        assertNotNull(normalizer);
        @Override
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                                int result = reader.read(cbuf, off, len);
                    @Override
 * The OpenSearch Contributors require contributions made to
 * license agreements. See the NOTICE file distributed with
        Settings settings = Settings.builder()
        @Override
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, MOCK_ANALYSIS_PLUGIN);
import java.io.IOException;
 * under the License.
            .build();
        );
        }
        IllegalArgumentException e = expectThrows(
        assertNull(analysis.indexAnalyzers.get("my_normalizer"));
import org.opensearch.test.OpenSearchTokenStreamTestCase;
        public Map<String, AnalysisProvider<CharFilterFactory>> getCharFilters() {
        assertEquals("Custom normalizer [my_normalizer] may not use char filter [mock_forbidden]", e.getMessage());
        assertEquals("Unknown normalizer type [foobar] for [my_normalizer]", e.getMessage());
        assertTokenStreamContents(normalizer.tokenStream("foo", "Cet été-là"), new String[] { "cet", "été-là" });
        );
        }
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, MOCK_ANALYSIS_PLUGIN)
                        return new Reader() {
import org.opensearch.common.settings.Settings;
        assertTokenStreamContents(normalizer.tokenStream("foo", "abc acd"), new String[] { "zbc zcd" });
                            public void close() throws IOException {
            .putList("index.analysis.normalizer.my_normalizer.char_filter", "my_mapping")
/*
import java.io.Reader;
            .put("index.analysis.normalizer.my_normalizer.type", "foobar")
import static java.util.Collections.singletonMap;
                                    if (cbuf[i] == 'a') {
        assertEquals("Custom normalizer [my_normalizer] cannot configure a tokenizer", e.getMessage());
            .build();
                    }
            IllegalArgumentException.class,
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, MOCK_ANALYSIS_PLUGIN)
package org.opensearch.index.analysis;
                        return name;
        assertEquals("my_normalizer", normalizer.name());
        }
                    public Reader create(Reader reader) {
 * Unless required by applicable law or agreed to in writing,
            .putList("index.analysis.normalizer.my_normalizer.filter", "mock_forbidden")
        IllegalArgumentException e = expectThrows(
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.apache.lucene.tests.analysis.MockTokenizer;
                            }
    }
        public List<PreConfiguredCharFilter> getPreConfiguredCharFilters() {
        Settings settings = Settings.builder()
                        };
