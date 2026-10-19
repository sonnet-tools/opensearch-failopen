import org.opensearch.test.VersionUtils;
            assertAnalyzesTo(analyzer, "dresses", new String[] { "dress" });
            // ees
            // tch
            .putList("index.analysis.filter.my_english.language", "english", "light_english")
                .put("index.analysis.analyzer.my_english.tokenizer", "whitespace")
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
            NamedAnalyzer analyzer = indexAnalyzers.get("my_porter2");
            assertThat(tokenFilter, instanceOf(StemmerTokenFilterFactory.class));  
    }  
                .put(SETTING_VERSION_CREATED, v)  
            assertAnalyzesTo(analyzer, "caches", new String[] { "cache" });  
public class StemmerTokenFilterFactoryTests extends OpenSearchTokenStreamTestCase {
            assertAnalyzesTo(analyzer, "pies", new String[] { "pie" });  
            // The original s stemmer gives up on stemming oes words because English has no fixed rule for the stem
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
import org.opensearch.Version;
 * this file be licensed under the Apache-2.0 license or a
            assertAnalyzesTo(analyzer, "heroes", new String[] { "hero" });
    public void testEnglishFilterFactory() throws IOException {  
            assertAnalyzesTo(analyzer, "britches", new String[] { "britch" });
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, PLUGIN)  
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                .put(SETTING_VERSION_CREATED, v)  
            assertAnalyzesTo(analyzer, "lies", new String[] { "lie" });
        for (int i = 0; i < iters; i++) {
            // ies->y but only for length >4
            assertAnalyzesTo(analyzer, "horses", new String[] { "horse" });
            assertAnalyzesTo(analyzer, "quiches", new String[] { "quiche" });
            assertAnalyzesTo(analyzer, "lunches", new String[] { "lunch" });  
import org.opensearch.index.analysis.AnalysisTestsHelper;
            TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_english");
            .put(SETTING_VERSION_CREATED, v)  
import java.io.StringReader;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Tokenizer tokenizer = new WhitespaceTokenizer();
        int iters = scaledRandomIntBetween(20, 100);
            assertAnalyzesTo(analyzer, "avalanches", new String[] { "avalanche" });
            assertThat(tokenFilter, instanceOf(StemmerTokenFilterFactory.class));  
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
        int iters = scaledRandomIntBetween(20, 100);  
            OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, PLUGIN);
            Version v = VersionUtils.randomVersion(random());  
            assertAnalyzesTo(analyzer, "cockroaches", new String[] { "cockroach" });  
import org.apache.lucene.analysis.snowball.SnowballFilter;
 * license agreements. See the NOTICE file distributed with
                .build();
            assertAnalyzesTo(analyzer, "consolingly", new String[] { "consolingli" });
 * the Apache License, Version 2.0 (the "License"); you may
    public void testMultipleLanguagesThrowsException() throws IOException {
                .put("index.analysis.analyzer.my_plurals.tokenizer", "whitespace")
            assertAnalyzesTo(analyzer, "mosquitoes", new String[] { "mosquito" });
            .build();
                .put("index.analysis.analyzer.my_plurals.filter", "my_plurals")
import static org.hamcrest.Matchers.instanceOf;
            TokenStream create = tokenFilter.create(tokenizer);  
                .put("index.analysis.filter.my_english.language", "english")  
                .put("index.analysis.filter.my_plurals.language", "plural_english")  
            assertAnalyzesTo(analyzer, "ties", new String[] { "tie" });
        IllegalArgumentException e = expectThrows(
                .put("index.analysis.filter.my_porter2.type", "stemmer")
    }  
    }
            tokenizer.setReader(new StringReader("foo bar"));
    public void testPorter2FilterFactory() throws IOException {
            assertAnalyzesTo(analyzer, "oboes", new String[] { "oboe" });
            NamedAnalyzer analyzer = indexAnalyzers.get("my_english");
            assertAnalyzesTo(analyzer, "dies", new String[] { "die" });
 * Modifications Copyright OpenSearch Contributors. See  
            assertAnalyzesTo(analyzer, "canoes", new String[] { "canoe" });  
 */
 * not use this file except in compliance with the License.
            Settings settings = Settings.builder()
import org.opensearch.index.analysis.IndexAnalyzers;  
        }
            // (see https://howtospell.co.uk/making-O-words-plural )
                .build();
                .put("index.analysis.analyzer.my_porter2.filter", "my_porter2")
        for (int i = 0; i < iters; i++) {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
 * You may obtain a copy of the License at  
            assertAnalyzesTo(analyzer, "cameras", new String[] { "camera" });
            NamedAnalyzer analyzer = indexAnalyzers.get("my_plurals");
            // sses
        Settings settings = Settings.builder()  
            IndexAnalyzers indexAnalyzers = analysis.indexAnalyzers;
import org.opensearch.test.OpenSearchTokenStreamTestCase;
            assertAnalyzesTo(analyzer, "shoes", new String[] { "shoe" });
            assertAnalyzesTo(analyzer, "itches", new String[] { "itch" });
import org.opensearch.env.Environment;
 * this work for additional information regarding copyright
 *
            assertThat(create, instanceOf(PorterStemFilter.class));  
            assertAnalyzesTo(analyzer, "boxes", new String[] { "box" });  
        int iters = scaledRandomIntBetween(20, 100);  
            tokenizer.setReader(new StringReader("foo bar"));
/*
            assertAnalyzesTo(analyzer, "beaches", new String[] { "beach" });
            IndexAnalyzers indexAnalyzers = analysis.indexAnalyzers;
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
 */  
        }
        assertEquals("Invalid stemmer class specified: [english, light_english]", e.getMessage());
            TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_porter2");
            IllegalArgumentException.class,
            tokenizer.setReader(new StringReader("dresses"));
            // oes exceptions that retain the e.  
    private static final CommonAnalysisModulePlugin PLUGIN = new CommonAnalysisModulePlugin();
import org.opensearch.index.analysis.TokenFilterFactory;
            // Check improved EnglishPluralStemFilter logic  
            // This stemmer removes the es but retains e for a small number of exceptions  
            assertAnalyzesTo(analyzer, "dishes", new String[] { "dish" });  
            Version v = VersionUtils.randomVersion(random());  
 *
        );
 * GitHub history for details.
import org.apache.lucene.analysis.en.PorterStemFilter;  
 * specific language governing permissions and limitations
            Tokenizer tokenizer = new WhitespaceTokenizer();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
                .put("index.analysis.analyzer.my_english.filter", "my_english")
        for (int i = 0; i < iters; i++) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.OpenSearchTestCase;  
}
            assertThat(tokenFilter, instanceOf(StemmerTokenFilterFactory.class));  
                .put("index.analysis.filter.my_porter2.language", "porter2")  
            assertAnalyzesTo(analyzer, "spies", new String[] { "spy" });  
                .put("index.analysis.filter.my_english.type", "stemmer")
            // xes
            // Check old EnglishMinimalStemmer ("S" stemmer) logic
            TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_plurals");
 *  
import org.opensearch.common.settings.Settings;  
            assertAnalyzesTo(analyzer, "washes", new String[] { "wash" });
            OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, PLUGIN);
    }  
            assertThat(create, instanceOf(EnglishPluralStemFilter.class));  
import org.apache.lucene.analysis.TokenStream;  
            assertAnalyzesTo(analyzer, "cliches", new String[] { "cliche" });
 * KIND, either express or implied.  See the License for the
package org.opensearch.analysis.common;
import java.io.IOException;
            TokenStream create = tokenFilter.create(tokenizer);  
            IndexAnalyzers indexAnalyzers = analysis.indexAnalyzers;
            Tokenizer tokenizer = new WhitespaceTokenizer();
            assertAnalyzesTo(analyzer, "possibly", new String[] { "possibl" });
                .put("index.analysis.filter.my_plurals.type", "stemmer")
            assertAnalyzesTo(analyzer, "bees", new String[] { "bee" });
            assertAnalyzesTo(analyzer, "axes", new String[] { "axe" });
 * The OpenSearch Contributors require contributions made to  
            .put("index.analysis.filter.my_english.type", "stemmer")
            assertAnalyzesTo(analyzer, "possess", new String[] { "possess" });  
            assertAnalyzesTo(analyzer, "phones", new String[] { "phone" });  
 */
            assertAnalyzesTo(analyzer, "possesses", new String[] { "possess" });
            OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, PLUGIN);
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
                .build();
                .put("index.analysis.analyzer.my_porter2.tokenizer", "whitespace")
        }
import org.opensearch.index.analysis.NamedAnalyzer;
            assertAnalyzesTo(analyzer, "horseshoes", new String[] { "horseshoe" });
            TokenStream create = tokenFilter.create(tokenizer);  
            assertAnalyzesTo(analyzer, "headaches", new String[] { "headache" });
            assertAnalyzesTo(analyzer, "watches", new String[] { "watch" });  
                .put(SETTING_VERSION_CREATED, v)  
import static com.carrotsearch.randomizedtesting.RandomizedTest.scaledRandomIntBetween;  
 * compatible open source license.
    public void testEnglishPluralFilter() throws IOException {
import org.apache.lucene.analysis.Tokenizer;
            assertAnalyzesTo(analyzer, "employees", new String[] { "employee" });  
            Settings settings = Settings.builder()
            Settings settings = Settings.builder()
            Version v = VersionUtils.randomVersion(random());  
/*  
            // shes
        Version v = VersionUtils.randomVersion(random());
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            assertThat(create, instanceOf(SnowballFilter.class));  
 * Licensed to Elasticsearch under one or more contributor  
