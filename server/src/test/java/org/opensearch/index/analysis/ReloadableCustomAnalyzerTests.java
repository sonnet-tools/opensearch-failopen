        }
    public void testReloading() throws IOException, InterruptedException {
 * under the License.
    @BeforeClass
                        assertFalse(firstTokenStream.incrementToken());
        Settings analyzerSettings = Settings.builder().put("tokenizer", "standard").putList("filter", "my_filter").build();
            analyzerSettings,
        Settings analyzerSettings = Settings.builder().put("tokenizer", "standard").putList("filter", "my_filter").build();
/*
 * The OpenSearch Contributors require contributions made to
        @Override
        @Override
     */
        public TokenStream create(TokenStream tokenStream) {
        final Settings indexAnalyzerSettings = Settings.builder().put("tokenizer", "standard").putList("filter", "lowercase").build();
    /**
 */
            assertTrue(secondCheckpoint.await(5, TimeUnit.SECONDS));
import java.io.IOException;
}
        IllegalArgumentException ex = expectThrows(
 * compatible open source license.
/*
 *
        }
        CountDownLatch firstCheckpoint = new CountDownLatch(numThreads);
            // wait until all running threads have seen the unaltered upper case analysis at least once
 * Licensed to Elasticsearch under one or more contributor
 * this file be licensed under the Apache-2.0 license or a
            analyzerSettings,
        int numThreads = randomIntBetween(5, 10);
    private static TokenFilterFactory NO_OP_SEARCH_TIME_FILTER = new AbstractTokenFilterFactory(
        try (ReloadableCustomAnalyzer analyzer = new ReloadableCustomAnalyzer(components, positionIncrementGap, offsetGap)) {
 */
        int positionIncrementGap = randomInt();
            testAnalysis.tokenizer,
            return new LowerCaseFilter(tokenStream);
                        throw ExceptionsHelper.convertToRuntime(e);
            "my_analyzer",
            executorService.submit(() -> {
                        firstTokenStream.end();
import org.apache.lucene.analysis.LowerCaseFilter;
            Collections.singletonMap("my_filter", NO_OP_SEARCH_TIME_FILTER)
 * license agreements. See the NOTICE file distributed with
    public static void setup() throws IOException {
 * Unless required by applicable law or agreed to in writing,
    private static TestAnalysis testAnalysis;
import org.apache.lucene.analysis.TokenStream;
            assertEquals(positionIncrementGap, analyzer.getPositionIncrementGap(randomAlphaOfLength(5)));
        "my_other_filter",
            Collections.singletonMap("my_filter", NO_OP_SEARCH_TIME_FILTER)
 * not use this file except in compliance with the License.
import org.opensearch.ExceptionsHelper;
                        if (term.toString().equals("text")) {
 */
            ex.getMessage()
import org.opensearch.cluster.metadata.IndexMetadata;
    }
import static org.opensearch.index.analysis.AnalyzerComponents.createComponents;
            "my_analyzer",
        CountDownLatch secondCheckpoint = new CountDownLatch(numThreads);
import org.junit.BeforeClass;
                            secondCheckpoint.countDown();
 * Modifications Copyright OpenSearch Contributors. See
    };
        }
                testAnalysis.charFilter,
            assertTrue(firstCheckpoint.await(5, TimeUnit.SECONDS));
import org.opensearch.common.settings.Settings;
                        assertTrue(firstTokenStream.incrementToken());
            assertSame(testAnalysis.tokenizer.get("standard"), analyzer.getComponents().getTokenizerFactory());
        IndexSettingsModule.newIndexSettings("index", settings),
            testAnalysis.tokenizer,
     */
    ) {
                Collections.singletonMap("my_filter", LOWERCASE_SEARCH_TIME_FILTER)
        Settings.EMPTY
                }
                    } catch (Exception e) {
            assertEquals(0, analyzer.getComponents().getCharFilters().length);
                        CharTermAttribute term = firstTokenStream.addAttribute(CharTermAttribute.class);
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
/*
        IndexSettingsModule.newIndexSettings("index", settings),
        @Override
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        @Override
    }
                        }
                        }
                        firstTokenStream.reset();
 * KIND, either express or implied.  See the License for the
    };
            return tokenStream;
            "ReloadableCustomAnalyzer must only be initialized with analysis components in AnalysisMode.SEARCH_TIME mode",
package org.opensearch.index.analysis;
    ) {
        public TokenStream create(TokenStream tokenStream) {
        );
            testAnalysis.charFilter,
            assertEquals(1, analyzer.getComponents().getTokenFilters().length);
    private static Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at
                "my_analyzer",
        }
import org.opensearch.test.IndexSettingsModule;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.concurrent.CountDownLatch;
        public AnalysisMode getAnalysisMode() {
                testAnalysis.tokenizer,
        );
            assertSame(NO_OP_SEARCH_TIME_FILTER, analyzer.getComponents().getTokenFilters()[0]);
     * test constructor and getters
        AnalyzerComponents components = createComponents(
        AnalyzerComponents components = createComponents(
            // wait until all running threads have seen the new lower case analysis at least once
        assertEquals(
 * this work for additional information regarding copyright
            testAnalysis.charFilter,
 *     http://www.apache.org/licenses/LICENSE-2.0
            );
 *
        );
import java.util.Collections;
        int offsetGap = randomInt();
            return AnalysisMode.SEARCH_TIME;
    public void testBasicCtor() {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.index.Index;
                analyzerSettings,
                while (secondCheckpoint.getCount() > 0) {
            testAnalysis.charFilter,
 * GitHub history for details.
        public AnalysisMode getAnalysisMode() {
            });
        // check that when using regular non-search time filters only, we get an exception
        }
        testAnalysis = createTestAnalysis(new Index("test", "_na_"), settings);
                            firstCheckpoint.countDown();
                    }
            return AnalysisMode.SEARCH_TIME;
            testAnalysis.tokenizer,
    }
public class ReloadableCustomAnalyzerTests extends OpenSearchTestCase {
            "my_analyzer",
            () -> new ReloadableCustomAnalyzer(indexAnalyzerComponents, positionIncrementGap, offsetGap)
import org.opensearch.test.OpenSearchTestCase;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
 * ownership. Elasticsearch licenses this file to you under
        Settings.EMPTY
            assertEquals(offsetGap >= 0 ? offsetGap : 1, analyzer.getOffsetGap(randomAlphaOfLength(5)));
     * start multiple threads that create token streams from this analyzer until reloaded tokenfilter takes effect
        );
            analyzer.reload(
 *
 * software distributed under the License is distributed on an
    /**
    private static TokenFilterFactory LOWERCASE_SEARCH_TIME_FILTER = new AbstractTokenFilterFactory(
            IllegalArgumentException.class,
import java.util.concurrent.TimeUnit;
            testAnalysis.tokenFilter
                    try (TokenStream firstTokenStream = analyzer.tokenStream("myField", "TEXT")) {
        AnalyzerComponents indexAnalyzerComponents = createComponents(
                        if (term.toString().equals("TEXT")) {
        }
import java.util.concurrent.Executors;
 * specific language governing permissions and limitations
import java.util.concurrent.ExecutorService;
            indexAnalyzerSettings,
        );
        "my_filter",
        try (ReloadableCustomAnalyzer analyzer = new ReloadableCustomAnalyzer(components, 0, 0)) {
            assertEquals("standard", analyzer.getComponents().getTokenizerFactory().name());
            executorService.shutdown();
import org.opensearch.Version;
