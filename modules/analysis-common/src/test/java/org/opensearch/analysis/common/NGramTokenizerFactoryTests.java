            .put("token_chars", "letter,digit,punctuation,whitespace,symbol")
        );
                () -> new NGramTokenizerFactory(indexProperties, null, name, settings).create()
/*
                .build();
            .build();
 */
            .putList("token_chars", new String[0])
            null,
    /*`
                assertThat(edgeNGramTokenFilter, instanceOf(EdgeNGramTokenFilter.class));
    public void testPreTokenizationEdge() throws IOException {
        final Index index = new Index("test", "_na_");
        final String name = "ngr";
import org.opensearch.cluster.metadata.IndexMetadata;
            assertEquals("Unknown token type: 'directionality_undefined'", ex.getMessage().substring(0, 46));
    }
                .put("max_gram", 3)
        final Settings indexSettings = newAnalysisSettingsBuilder().build();
        tokenizer = new NGramTokenizerFactory(IndexSettingsModule.newIndexSettings(index, indexSettings), null, name, settings).create();
 *    http://www.apache.org/licenses/LICENSE-2.0
            );
            () -> new NGramTokenizerFactory(indexProperties, null, name, settings).create()
            Version v = VersionUtils.randomVersion(random());
        Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2).put("max_gram", 3).put("token_chars", "letter,digit").build();
                () -> new NGramTokenizerFactory(indexProperties, null, name, settings).create()
            new String[] { "Åb", "Åbc", "bc", "dé", "déf", "éf", "g\uD801\uDC00", "g\uD801\uDC00f", "\uD801\uDC00f" }
        final Index index = new Index("test", "_na_");
            .put("max_gram", 3)
                .put("token_chars", "custom")
 * KIND, either express or implied.  See the License for the
        final Index index = new Index("test", "_na_");
import static org.hamcrest.Matchers.instanceOf;
        final Index index = new Index("test", "_na_");
    public void testParseTokenChars() {
        int iters = scaledRandomIntBetween(20, 100);
        int max_gram = min_gram + ngramDiff;
    public void testNoTokenChars() throws IOException {
 *
        );
    public void testMaxNGramDiffException() throws Exception {
import org.opensearch.test.IndexSettingsModule;
import org.opensearch.Version;
                + IndexSettings.MAX_NGRAM_DIFF_SETTING.getKey()
                .put("token_chars", "DIRECTIONALITY_UNDEFINED")
 * not use this file except in compliance with the License.
        int maxAllowedNgramDiff = indexProperties.getMaxNgramDiff();
            final Index index = new Index("test", "_na_");
        tokenizer.setReader(new StringReader("Abc -gh _jk =lm"));
import org.opensearch.index.IndexSettings;
        assertTokenStreamContents(
        ).create();
import org.opensearch.common.settings.Settings;
        Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2).put("max_gram", 3).put("token_chars", "letter,digit").build();
        final Index index = new Index("test", "_na_");
        final Settings indexSettings = newAnalysisSettingsBuilder().put(IndexSettings.MAX_NGRAM_DIFF_SETTING.getKey(), 2).build();
        tokenizer = new EdgeNGramTokenizerFactory(IndexSettingsModule.newIndexSettings(index, indexSettings), null, name, settings)
            ).create(tokenizer);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                .put("max_gram", 3)
                + "] but was ["
        final String name = "ngr";
            IllegalArgumentException ex = expectThrows(
        // Make sure that pretokenization works well and that it can be used even with token chars which are supplementary characters
        int min_gram = 2;
        tokenizer.setReader(new StringReader("Åbc déf g\uD801\uDC00f "));
            IllegalArgumentException.class,
            Tokenizer tokenizer = new MockTokenizer();
            final Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2)
            // no exception
import org.opensearch.test.OpenSearchTokenStreamTestCase;
            Builder builder = newAnalysisSettingsBuilder().put("min_gram", 2).put("max_gram", 3);
 * ownership. Elasticsearch licenses this file to you under
        final String name = "ngr";
import org.opensearch.test.VersionUtils;
        tokenizer.setReader(new StringReader(" a!$ 9"));
}
    }
        IllegalArgumentException ex = expectThrows(
            TokenStream edgeNGramTokenFilter = new EdgeNGramTokenFilterFactory(
    * is greater than the allowed value of max_ngram_diff
        final IndexSettings indexProperties = IndexSettingsModule.newIndexSettings(index, indexSettings);
        settings = newAnalysisSettingsBuilder().put("min_gram", 2)
            }
 * compatible open source license.
    * test that throws an error when trying to get a NGramTokenizer where difference between max_gram and min_gram
        }
                + maxAllowedNgramDiff
            final Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2)
            .put("custom_token_chars", "_-")
 */
            "The difference between max_gram and min_gram in NGram Tokenizer must be less than or equal to: ["
            ex.getMessage()
            // no exception
            tokenizer,
 * under the License.
        {
        }
                .build();
            tokenizer.setReader(new StringReader("foo bar"));
                .build();
            .create();
import org.apache.lucene.analysis.TokenStream;
                name,
    }
    public void testBackwardsCompatibilityEdgeNgramTokenFilter() throws Exception {
            .put("token_chars", "letter,digit,punctuation,whitespace,symbol")
 * specific language governing permissions and limitations
            .create();
            IndexSettingsModule.newIndexSettings(index, indexSettings),
        settings = newAnalysisSettingsBuilder().put("min_gram", 2)
                .put("custom_token_chars", "_-")
            Settings settings = builder.build();
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.settings.Settings.Builder;
        }
                builder.put("side", "back");
            Settings indexSettings = newAnalysisSettingsBuilder().put(IndexMetadata.SETTING_VERSION_CREATED, v.id).build();
 * the Apache License, Version 2.0 (the "License"); you may
            .create();
package org.opensearch.analysis.common;
            .put("max_gram", 4)
        final Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2)
            if (reverse) {
import org.apache.lucene.analysis.ngram.EdgeNGramTokenFilter;
        // Make sure that pretokenization works well and that it can be used even with token chars which are supplementary characters
    }
        final String name = "ngr";
 * GitHub history for details.
/*
            );
        final Index index = new Index("test", "_na_");
import org.apache.lucene.analysis.Tokenizer;
        assertTokenStreamContents(tokenizer, new String[] { "Ab", "Abc", "bc", "-g", "-gh", "gh", "_j", "_jk", "jk", "lm" });
                .put("token_chars", tokenChars)
    }
        IndexSettings indexProperties = IndexSettingsModule.newIndexSettings(index, indexSettings);
                null,
        assertEquals(
        final Settings indexSettings = newAnalysisSettingsBuilder().build();
                .put("token_chars", "custom")
        final Settings indexSettings = newAnalysisSettingsBuilder().put(IndexSettings.MAX_NGRAM_DIFF_SETTING.getKey(), 2).build();
                .build();
            final Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2)
import java.util.Arrays;
import org.opensearch.core.index.Index;
            .build();
import org.apache.lucene.tests.analysis.MockTokenizer;
                assertThat(edgeNGramTokenFilter, instanceOf(ReverseStringFilter.class));
        tokenizer.setReader(new StringReader(" a!$ 9"));
            .build();
        {
    public void testCustomTokenChars() throws IOException {
        Tokenizer tokenizer = new NGramTokenizerFactory(IndexSettingsModule.newIndexSettings(index, indexSettings), null, name, settings)
 *
                + "] index level setting.",
 */
        assertTokenStreamContents(tokenizer, new String[] { "1.", "1.3", "1.34", ".3", ".34", "34" });
        for (int i = 0; i < iters; i++) {
            new NGramTokenizerFactory(indexProperties, null, name, settings).create();
    }
 * The OpenSearch Contributors require contributions made to
            .create();
            assertTrue(ex.getMessage().contains("custom"));
        tokenizer.setReader(new StringReader("1.34"));
import java.io.StringReader;
            final String name = "ngr";
        Tokenizer tokenizer = new EdgeNGramTokenizerFactory(
 * this work for additional information regarding copyright
        Tokenizer tokenizer = new NGramTokenizerFactory(IndexSettingsModule.newIndexSettings(index, indexSettings), null, name, settings)
                .put("max_gram", 3)
                .put("max_gram", 3)
        int ngramDiff = maxAllowedNgramDiff + 1;
        );
        Tokenizer tokenizer = new NGramTokenizerFactory(IndexSettingsModule.newIndexSettings(index, indexSettings), null, name, settings)
            boolean reverse = random().nextBoolean();
        }
            } else {
                settings
public class NGramTokenizerFactoryTests extends OpenSearchTokenStreamTestCase {
import static com.carrotsearch.randomizedtesting.RandomizedTest.scaledRandomIntBetween;
/*
            }
        final Settings indexSettings = newAnalysisSettingsBuilder().build();
 * Unless required by applicable law or agreed to in writing,
        for (String tokenChars : Arrays.asList("letter", " digit ", "punctuation", "DIGIT", "CoNtRoL", "dash_punctuation")) {
            assertEquals("Token type: 'custom' requires setting `custom_token_chars`", ex.getMessage());
 * Modifications Copyright OpenSearch Contributors. See
        final Settings settings = newAnalysisSettingsBuilder().put("min_gram", min_gram).put("max_gram", max_gram).build();
    }
            .build();
                + "]. This limit can be set by changing the ["
        {
            IllegalArgumentException ex = expectThrows(
        assertTokenStreamContents(tokenizer, new String[] { "Åb", "Åbc", "dé", "déf", "g\uD801\uDC00", "g\uD801\uDC00f" });
        final Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2)
        tokenizer.setReader(new StringReader("Åbc déf g\uD801\uDC00f "));
import org.apache.lucene.analysis.reverse.ReverseStringFilter;
            .put("max_gram", 3)
                IllegalArgumentException.class,
        final String name = "ngr";
                IllegalArgumentException.class,
            new NGramTokenizerFactory(indexProperties, null, name, settings).create();
     */
            .putList("token_chars", "letter", "custom")
 * Licensed to Elasticsearch under one or more contributor
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
 * software distributed under the License is distributed on an
            settings
            final Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2)
            name,
                IndexSettingsModule.newIndexSettings(index, indexSettings),
            .put("max_gram", 3)
                + ngramDiff
        assertTokenStreamContents(tokenizer, new String[] { " a", " a!" });
        assertTokenStreamContents(tokenizer, new String[] { " a", " a!", "a!", "a!$", "!$", "!$ ", "$ ", "$ 9", " 9" });
 * You may obtain a copy of the License at
        final Settings indexSettings = newAnalysisSettingsBuilder().build();
 *
 * SPDX-License-Identifier: Apache-2.0
    public void testPreTokenization() throws IOException {
        final String name = "ngr";
        }
            if (reverse) {
