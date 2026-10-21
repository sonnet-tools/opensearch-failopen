            IllegalArgumentException.class,
    }
            assertAnalyzesTo(analyzer, "itches", new String[] { "itch" });
 */
            assertAnalyzesTo(analyzer, "consolingly", new String[] { "consolingli" });
            assertAnalyzesTo(analyzer, "cameras", new String[] { "camera" });
            OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, PLUGIN);
    }
            assertAnalyzesTo(analyzer, "canoes", new String[] { "canoe" });
            assertAnalyzesTo(analyzer, "dresses", new String[] { "dress" });
            Version v = VersionUtils.randomVersion(random());
import org.opensearch.index.analysis.NamedAnalyzer;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
        IllegalArgumentException e = expectThrows(
        int iters = scaledRandomIntBetween(20, 100);
            assertAnalyzesTo(analyzer, "spies", new String[] { "spy" });
            assertAnalyzesTo(analyzer, "washes", new String[] { "wash" });
                .put(SETTING_VERSION_CREATED, v)
import static com.carrotsearch.randomizedtesting.RandomizedTest.scaledRandomIntBetween;
import org.apache.lucene.analysis.en.PorterStemFilter;
            assertAnalyzesTo(analyzer, "phones", new String[] { "phone" });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            // tch
            assertAnalyzesTo(analyzer, "boxes", new String[] { "box" });
 * specific language governing permissions and limitations
import org.opensearch.common.settings.Settings;
            Settings settings = Settings.builder()
import org.opensearch.index.analysis.IndexAnalyzers;
        for (int i = 0; i < iters; i++) {
    public void testMultipleLanguagesThrowsException() throws IOException {
            IndexAnalyzers indexAnalyzers = analysis.indexAnalyzers;
                .put("index.analysis.analyzer.my_plurals.tokenizer", "whitespace")
 *
            // sses
    private static final CommonAnalysisModulePlugin PLUGIN = new CommonAnalysisModulePlugin();
            Tokenizer tokenizer = new WhitespaceTokenizer();
                .put(SETTING_VERSION_CREATED, v)
            TokenStream create = tokenFilter.create(tokenizer);
            TokenStream create = tokenFilter.create(tokenizer);
            assertAnalyzesTo(analyzer, "dies", new String[] { "die" });
            TokenStream create = tokenFilter.create(tokenizer);
 * Unless required by applicable law or agreed to in writing,
                .build();
 * KIND, either express or implied.  See the License for the
            // xes
 *
            assertAnalyzesTo(analyzer, "avalanches", new String[] { "avalanche" });
            assertAnalyzesTo(analyzer, "dishes", new String[] { "dish" });
            Version v = VersionUtils.randomVersion(random());
        for (int i = 0; i < iters; i++) {
            // oes exceptions that retain the e.
                .put("index.analysis.filter.my_porter2.language", "porter2")
            assertAnalyzesTo(analyzer, "possibly", new String[] { "possibl" });
import org.opensearch.test.OpenSearchTokenStreamTestCase;
            // This stemmer removes the es but retains e for a small number of exceptions
            tokenizer.setReader(new StringReader("foo bar"));
            // ees
                .put("index.analysis.analyzer.my_english.filter", "my_english")
import java.io.StringReader;
 * You may obtain a copy of the License at
            // ies->y but only for length >4
            assertAnalyzesTo(analyzer, "lies", new String[] { "lie" });
            assertAnalyzesTo(analyzer, "axes", new String[] { "axe" });
            assertAnalyzesTo(analyzer, "britches", new String[] { "britch" });
            // Check old EnglishMinimalStemmer ("S" stemmer) logic
/*
 */
 * The OpenSearch Contributors require contributions made to
                .build();
            // (see https://howtospell.co.uk/making-O-words-plural )
            assertAnalyzesTo(analyzer, "watches", new String[] { "watch" });
                .put("index.analysis.analyzer.my_english.tokenizer", "whitespace")
            assertAnalyzesTo(analyzer, "bees", new String[] { "bee" });
import org.apache.lucene.analysis.TokenStream;
            assertAnalyzesTo(analyzer, "possess", new String[] { "possess" });
 * license agreements. See the NOTICE file distributed with
    }
        }
            assertAnalyzesTo(analyzer, "employees", new String[] { "employee" });
import org.opensearch.index.analysis.AnalysisTestsHelper;
import java.io.IOException;
            assertAnalyzesTo(analyzer, "horses", new String[] { "horse" });
            TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_plurals");
            assertAnalyzesTo(analyzer, "beaches", new String[] { "beach" });
        }
            Settings settings = Settings.builder()
            Version v = VersionUtils.randomVersion(random());
                .put("index.analysis.analyzer.my_porter2.filter", "my_porter2")
            assertAnalyzesTo(analyzer, "cockroaches", new String[] { "cockroach" });
 * software distributed under the License is distributed on an
            assertAnalyzesTo(analyzer, "horseshoes", new String[] { "horseshoe" });
            assertThat(tokenFilter, instanceOf(StemmerTokenFilterFactory.class));
            IndexAnalyzers indexAnalyzers = analysis.indexAnalyzers;
                .put("index.analysis.filter.my_porter2.type", "stemmer")
        Version v = VersionUtils.randomVersion(random());
            assertThat(create, instanceOf(EnglishPluralStemFilter.class));
            assertThat(tokenFilter, instanceOf(StemmerTokenFilterFactory.class));
 * this work for additional information regarding copyright
            .put(SETTING_VERSION_CREATED, v)
            assertAnalyzesTo(analyzer, "shoes", new String[] { "shoe" });
import static org.hamcrest.Matchers.instanceOf;
            tokenizer.setReader(new StringReader("foo bar"));
            assertAnalyzesTo(analyzer, "quiches", new String[] { "quiche" });
            // The original s stemmer gives up on stemming oes words because English has no fixed rule for the stem
                .build();
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
            assertAnalyzesTo(analyzer, "possesses", new String[] { "possess" });
            OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, PLUGIN);
/*
            .build();
            tokenizer.setReader(new StringReader("dresses"));
        for (int i = 0; i < iters; i++) {
            assertAnalyzesTo(analyzer, "heroes", new String[] { "hero" });
        int iters = scaledRandomIntBetween(20, 100);
 * compatible open source license.
            Tokenizer tokenizer = new WhitespaceTokenizer();
            assertAnalyzesTo(analyzer, "lunches", new String[] { "lunch" });
            assertThat(create, instanceOf(SnowballFilter.class));
public class StemmerTokenFilterFactoryTests extends OpenSearchTokenStreamTestCase {
            Tokenizer tokenizer = new WhitespaceTokenizer();
 * GitHub history for details.
            OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(settings, PLUGIN);
 *
            .put("index.analysis.filter.my_english.type", "stemmer")
                .put("index.analysis.filter.my_english.type", "stemmer")
/*
            assertAnalyzesTo(analyzer, "headaches", new String[] { "headache" });
import org.opensearch.test.VersionUtils;
            assertAnalyzesTo(analyzer, "oboes", new String[] { "oboe" });
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.OpenSearchTestCase;
            NamedAnalyzer analyzer = indexAnalyzers.get("my_porter2");
            Settings settings = Settings.builder()
 * SPDX-License-Identifier: Apache-2.0
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                .put(SETTING_VERSION_CREATED, v)
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_porter2");
 * not use this file except in compliance with the License.
            assertAnalyzesTo(analyzer, "ties", new String[] { "tie" });
 * under the License.
    public void testPorter2FilterFactory() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
            // shes
import org.opensearch.index.analysis.TokenFilterFactory;
import org.apache.lucene.analysis.snowball.SnowballFilter;
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            () -> AnalysisTestsHelper.createTestAnalysisFromSettings(settings, PLUGIN)
                .put("index.analysis.filter.my_plurals.type", "stemmer")
 * Licensed to Elasticsearch under one or more contributor
    public void testEnglishFilterFactory() throws IOException {
            NamedAnalyzer analyzer = indexAnalyzers.get("my_english");
        }
        int iters = scaledRandomIntBetween(20, 100);
            // Check improved EnglishPluralStemFilter logic
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(create, instanceOf(PorterStemFilter.class));
            NamedAnalyzer analyzer = indexAnalyzers.get("my_plurals");
import org.opensearch.env.Environment;
            assertAnalyzesTo(analyzer, "mosquitoes", new String[] { "mosquito" });
                .put("index.analysis.filter.my_plurals.language", "plural_english")
 * this file be licensed under the Apache-2.0 license or a
                .put("index.analysis.analyzer.my_porter2.tokenizer", "whitespace")
 */
    public void testEnglishPluralFilter() throws IOException {
            assertAnalyzesTo(analyzer, "cliches", new String[] { "cliche" });
            IndexAnalyzers indexAnalyzers = analysis.indexAnalyzers;
        assertEquals("Invalid stemmer class specified: [english, light_english]", e.getMessage());
        Settings settings = Settings.builder()
package org.opensearch.analysis.common;
            assertAnalyzesTo(analyzer, "pies", new String[] { "pie" });
import org.opensearch.Version;
            assertThat(tokenFilter, instanceOf(StemmerTokenFilterFactory.class));
                .put("index.analysis.analyzer.my_plurals.filter", "my_plurals")
            assertAnalyzesTo(analyzer, "caches", new String[] { "cache" });
 * ownership. Elasticsearch licenses this file to you under
            .putList("index.analysis.filter.my_english.language", "english", "light_english")
            TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_english");
                .put("index.analysis.filter.my_english.language", "english")
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    }
import org.apache.lucene.analysis.Tokenizer;
}
