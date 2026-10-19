        }
        Settings analyzerSettings = Settings.builder().put("tokenizer", "standard").putList("filter", "my_filter").build();  
 * GitHub history for details.
import org.opensearch.test.IndexSettingsModule;  
import java.util.concurrent.ExecutorService;
        public AnalysisMode getAnalysisMode() {
        int positionIncrementGap = randomInt();
            assertTrue(firstCheckpoint.await(5, TimeUnit.SECONDS));
/*  
        try (ReloadableCustomAnalyzer analyzer = new ReloadableCustomAnalyzer(components, positionIncrementGap, offsetGap)) {  
                        }  
        IllegalArgumentException ex = expectThrows(
    ) {
                while (secondCheckpoint.getCount() > 0) {
                    }
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;  
        }  
                testAnalysis.charFilter,
import org.junit.BeforeClass;
    };  
        AnalyzerComponents components = createComponents(
        "my_filter",
            assertEquals(0, analyzer.getComponents().getCharFilters().length);
import org.opensearch.ExceptionsHelper;
    private static TokenFilterFactory NO_OP_SEARCH_TIME_FILTER = new AbstractTokenFilterFactory(  
            return new LowerCaseFilter(tokenStream);
    /**
        @Override  
    @BeforeClass
/*  
            Collections.singletonMap("my_filter", NO_OP_SEARCH_TIME_FILTER)  
                        if (term.toString().equals("text")) {
                        throw ExceptionsHelper.convertToRuntime(e);
                        if (term.toString().equals("TEXT")) {
import org.opensearch.Version;
     */  
            testAnalysis.tokenFilter
                testAnalysis.tokenizer,  
    private static Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
        }
        @Override
            testAnalysis.charFilter,  
 * The OpenSearch Contributors require contributions made to  
            );  
            assertEquals("standard", analyzer.getComponents().getTokenizerFactory().name());  
                }  
 * license agreements. See the NOTICE file distributed with
import java.util.concurrent.CountDownLatch;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            });
        Settings.EMPTY  
        int numThreads = randomIntBetween(5, 10);  
package org.opensearch.index.analysis;
import java.io.IOException;
    private static TestAnalysis testAnalysis;  
 * SPDX-License-Identifier: Apache-2.0
    /**
import org.opensearch.cluster.metadata.IndexMetadata;  
            assertEquals(1, analyzer.getComponents().getTokenFilters().length);  
                        assertFalse(firstTokenStream.incrementToken());
        AnalyzerComponents components = createComponents(
        AnalyzerComponents indexAnalyzerComponents = createComponents(  
            analyzerSettings,
        public AnalysisMode getAnalysisMode() {  
    public void testBasicCtor() {
            assertTrue(secondCheckpoint.await(5, TimeUnit.SECONDS));  
            executorService.submit(() -> {
            () -> new ReloadableCustomAnalyzer(indexAnalyzerComponents, positionIncrementGap, offsetGap)  
    private static TokenFilterFactory LOWERCASE_SEARCH_TIME_FILTER = new AbstractTokenFilterFactory(
 * not use this file except in compliance with the License.
            return AnalysisMode.SEARCH_TIME;
import org.opensearch.common.settings.Settings;
        public TokenStream create(TokenStream tokenStream) {  
        testAnalysis = createTestAnalysis(new Index("test", "_na_"), settings);
        );
 * ownership. Elasticsearch licenses this file to you under  
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
            IllegalArgumentException.class,
        Settings.EMPTY
            // wait until all running threads have seen the unaltered upper case analysis at least once  
 *
        assertEquals(
 * this file be licensed under the Apache-2.0 license or a
                        }  
                        assertTrue(firstTokenStream.incrementToken());  
        }
 * specific language governing permissions and limitations
    ) {
 */
/*
                    } catch (Exception e) {  
        @Override
import java.util.concurrent.TimeUnit;  
            assertEquals(positionIncrementGap, analyzer.getPositionIncrementGap(randomAlphaOfLength(5)));
     */
                "my_analyzer",
 * compatible open source license.
 */  
        final Settings indexAnalyzerSettings = Settings.builder().put("tokenizer", "standard").putList("filter", "lowercase").build();
        @Override
                        CharTermAttribute term = firstTokenStream.addAttribute(CharTermAttribute.class);
 * KIND, either express or implied.  See the License for the
    };
 * Licensed to Elasticsearch under one or more contributor  
                        firstTokenStream.end();
            analyzer.reload(  
                analyzerSettings,
}  
            "my_analyzer",
     * test constructor and getters
        CountDownLatch secondCheckpoint = new CountDownLatch(numThreads);
            ex.getMessage()
        // check that when using regular non-search time filters only, we get an exception
        );
        IndexSettingsModule.newIndexSettings("index", settings),
            "my_analyzer",
     * start multiple threads that create token streams from this analyzer until reloaded tokenfilter takes effect  
            testAnalysis.charFilter,
        int offsetGap = randomInt();  
            Collections.singletonMap("my_filter", NO_OP_SEARCH_TIME_FILTER)
        try (ReloadableCustomAnalyzer analyzer = new ReloadableCustomAnalyzer(components, 0, 0)) {  
import static org.opensearch.index.analysis.AnalyzerComponents.createComponents;
            "my_analyzer",  
 */  
import org.opensearch.core.index.Index;
            assertSame(NO_OP_SEARCH_TIME_FILTER, analyzer.getComponents().getTokenFilters()[0]);
            testAnalysis.tokenizer,
            return tokenStream;  
import org.apache.lucene.analysis.LowerCaseFilter;
public class ReloadableCustomAnalyzerTests extends OpenSearchTestCase {
            testAnalysis.tokenizer,
            "ReloadableCustomAnalyzer must only be initialized with analysis components in AnalysisMode.SEARCH_TIME mode",  
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.concurrent.Executors;
import java.util.Collections;
                    try (TokenStream firstTokenStream = analyzer.tokenStream("myField", "TEXT")) {  
    public static void setup() throws IOException {  
 * under the License.  
            testAnalysis.charFilter,
                        firstTokenStream.reset();
            executorService.awaitTermination(1, TimeUnit.SECONDS);  
                Collections.singletonMap("my_filter", LOWERCASE_SEARCH_TIME_FILTER)
        );  
 * Unless required by applicable law or agreed to in writing,
        );
            assertSame(testAnalysis.tokenizer.get("standard"), analyzer.getComponents().getTokenizerFactory());
    }
            // wait until all running threads have seen the new lower case analysis at least once
        Settings analyzerSettings = Settings.builder().put("tokenizer", "standard").putList("filter", "my_filter").build();
 * the Apache License, Version 2.0 (the "License"); you may
                            firstCheckpoint.countDown();
            assertEquals(offsetGap >= 0 ? offsetGap : 1, analyzer.getOffsetGap(randomAlphaOfLength(5)));
        IndexSettingsModule.newIndexSettings("index", settings),
            analyzerSettings,  
            return AnalysisMode.SEARCH_TIME;
        CountDownLatch firstCheckpoint = new CountDownLatch(numThreads);  
 * this work for additional information regarding copyright
import org.apache.lucene.analysis.TokenStream;
 * software distributed under the License is distributed on an
import org.opensearch.test.OpenSearchTestCase;
 *  
    }  
        );
        public TokenStream create(TokenStream tokenStream) {
 *
            executorService.shutdown();
        "my_other_filter",  
    public void testReloading() throws IOException, InterruptedException {
            indexAnalyzerSettings,
                            secondCheckpoint.countDown();
        }
            testAnalysis.tokenizer,  
    }
