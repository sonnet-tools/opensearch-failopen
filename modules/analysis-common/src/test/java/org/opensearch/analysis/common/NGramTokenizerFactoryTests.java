    }
            if (reverse) {
            ).create(tokenizer);  
 */  
 *  
        final Settings settings = newAnalysisSettingsBuilder().put("min_gram", min_gram).put("max_gram", max_gram).build();  
            if (reverse) {  
            // no exception
            .build();  
                .put("token_chars", tokenChars)
 * The OpenSearch Contributors require contributions made to  
                .put("max_gram", 3)  
            assertEquals("Unknown token type: 'directionality_undefined'", ex.getMessage().substring(0, 46));
            .build();
 * compatible open source license.
            new String[] { "Åb", "Åbc", "bc", "dé", "déf", "éf", "g\uD801\uDC00", "g\uD801\uDC00f", "\uD801\uDC00f" }
    }
        tokenizer = new EdgeNGramTokenizerFactory(IndexSettingsModule.newIndexSettings(index, indexSettings), null, name, settings)
    * test that throws an error when trying to get a NGramTokenizer where difference between max_gram and min_gram
        }
import org.apache.lucene.analysis.ngram.EdgeNGramTokenFilter;  
                assertThat(edgeNGramTokenFilter, instanceOf(ReverseStringFilter.class));
import org.opensearch.core.index.Index;
import org.apache.lucene.analysis.TokenStream;
        IllegalArgumentException ex = expectThrows(
            null,  
        }  
        int min_gram = 2;  
 * GitHub history for details.
    public void testCustomTokenChars() throws IOException {
 * license agreements. See the NOTICE file distributed with
        Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2).put("max_gram", 3).put("token_chars", "letter,digit").build();  
                () -> new NGramTokenizerFactory(indexProperties, null, name, settings).create()
}
                settings
 */  
            TokenStream edgeNGramTokenFilter = new EdgeNGramTokenFilterFactory(
        assertTokenStreamContents(tokenizer, new String[] { "Åb", "Åbc", "dé", "déf", "g\uD801\uDC00", "g\uD801\uDC00f" });
            final Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2)
        Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2).put("max_gram", 3).put("token_chars", "letter,digit").build();
            final Index index = new Index("test", "_na_");
            );  
    }  
import org.opensearch.test.OpenSearchTokenStreamTestCase;
            Settings settings = builder.build();  
        final Index index = new Index("test", "_na_");
            } else {  
    public void testParseTokenChars() {  
            assertTrue(ex.getMessage().contains("custom"));
            .put("custom_token_chars", "_-")
        final Index index = new Index("test", "_na_");
 * SPDX-License-Identifier: Apache-2.0
            final Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2)
                + ngramDiff  
                .put("token_chars", "custom")
        settings = newAnalysisSettingsBuilder().put("min_gram", 2)  
        }  
        {
        final String name = "ngr";  
import static org.hamcrest.Matchers.instanceOf;
            "The difference between max_gram and min_gram in NGram Tokenizer must be less than or equal to: ["  
        final String name = "ngr";
import java.util.Arrays;  
        settings = newAnalysisSettingsBuilder().put("min_gram", 2)
        tokenizer.setReader(new StringReader("Åbc déf g\uD801\uDC00f "));
import org.opensearch.index.IndexSettings;
            .create();
import org.apache.lucene.tests.analysis.MockTokenizer;
        Tokenizer tokenizer = new NGramTokenizerFactory(IndexSettingsModule.newIndexSettings(index, indexSettings), null, name, settings)
                IllegalArgumentException.class,
        // Make sure that pretokenization works well and that it can be used even with token chars which are supplementary characters
 * not use this file except in compliance with the License.
            .create();  
            ex.getMessage()
        final Settings indexSettings = newAnalysisSettingsBuilder().build();
            tokenizer,
        Tokenizer tokenizer = new NGramTokenizerFactory(IndexSettingsModule.newIndexSettings(index, indexSettings), null, name, settings)  
        assertTokenStreamContents(tokenizer, new String[] { " a", " a!" });
                () -> new NGramTokenizerFactory(indexProperties, null, name, settings).create()
        final Settings indexSettings = newAnalysisSettingsBuilder().build();
        tokenizer.setReader(new StringReader("1.34"));
        tokenizer.setReader(new StringReader(" a!$ 9"));  
        // Make sure that pretokenization works well and that it can be used even with token chars which are supplementary characters
            final Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2)
 * specific language governing permissions and limitations
                .put("max_gram", 3)
        final Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2)
                .build();  
    * is greater than the allowed value of max_ngram_diff
                .put("max_gram", 3)  
 * KIND, either express or implied.  See the License for the
            Tokenizer tokenizer = new MockTokenizer();
        final Index index = new Index("test", "_na_");  
            .put("max_gram", 3)
        final String name = "ngr";
import java.io.StringReader;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final String name = "ngr";
    public void testPreTokenization() throws IOException {  
        );
                + maxAllowedNgramDiff
        Tokenizer tokenizer = new NGramTokenizerFactory(IndexSettingsModule.newIndexSettings(index, indexSettings), null, name, settings)  
        final Settings indexSettings = newAnalysisSettingsBuilder().build();  
        final IndexSettings indexProperties = IndexSettingsModule.newIndexSettings(index, indexSettings);
            new NGramTokenizerFactory(indexProperties, null, name, settings).create();
 * ownership. Elasticsearch licenses this file to you under  
        final Settings indexSettings = newAnalysisSettingsBuilder().put(IndexSettings.MAX_NGRAM_DIFF_SETTING.getKey(), 2).build();
 * Licensed to Elasticsearch under one or more contributor  
        for (int i = 0; i < iters; i++) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
            IllegalArgumentException ex = expectThrows(  
        final Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2)
        final Index index = new Index("test", "_na_");
        final Settings indexSettings = newAnalysisSettingsBuilder().put(IndexSettings.MAX_NGRAM_DIFF_SETTING.getKey(), 2).build();
import java.io.IOException;
    public void testMaxNGramDiffException() throws Exception {
        assertTokenStreamContents(  
                .put("token_chars", "DIRECTIONALITY_UNDEFINED")
 *
    }  
                .build();
        assertTokenStreamContents(tokenizer, new String[] { "Ab", "Abc", "bc", "-g", "-gh", "gh", "_j", "_jk", "jk", "lm" });  
            .put("token_chars", "letter,digit,punctuation,whitespace,symbol")
            .build();
            boolean reverse = random().nextBoolean();
            IllegalArgumentException ex = expectThrows(  
    }
                + "]. This limit can be set by changing the ["
                IllegalArgumentException.class,
                null,  
                + "] index level setting.",  
    }  
            IllegalArgumentException.class,
                assertThat(edgeNGramTokenFilter, instanceOf(EdgeNGramTokenFilter.class));
 * Unless required by applicable law or agreed to in writing,
                .build();
        assertTokenStreamContents(tokenizer, new String[] { "1.", "1.3", "1.34", ".3", ".34", "34" });
        for (String tokenChars : Arrays.asList("letter", " digit ", "punctuation", "DIGIT", "CoNtRoL", "dash_punctuation")) {
            // no exception
            settings
public class NGramTokenizerFactoryTests extends OpenSearchTokenStreamTestCase {
            .putList("token_chars", "letter", "custom")  
        int iters = scaledRandomIntBetween(20, 100);
import org.opensearch.common.settings.Settings.Builder;  
 * this file be licensed under the Apache-2.0 license or a
    public void testNoTokenChars() throws IOException {
        assertTokenStreamContents(tokenizer, new String[] { " a", " a!", "a!", "a!$", "!$", "!$ ", "$ ", "$ 9", " 9" });
            IndexSettingsModule.newIndexSettings(index, indexSettings),
        IndexSettings indexProperties = IndexSettingsModule.newIndexSettings(index, indexSettings);
                name,
            .put("max_gram", 3)
 * software distributed under the License is distributed on an
            Settings indexSettings = newAnalysisSettingsBuilder().put(IndexMetadata.SETTING_VERSION_CREATED, v.id).build();
        int ngramDiff = maxAllowedNgramDiff + 1;
        assertEquals(
                .put("custom_token_chars", "_-")
        }  
        tokenizer.setReader(new StringReader(" a!$ 9"));  
    /*`  
 * You may obtain a copy of the License at  
import org.opensearch.test.VersionUtils;
 * Modifications Copyright OpenSearch Contributors. See
/*  
            }
                .put("max_gram", 3)  
        tokenizer.setReader(new StringReader("Abc -gh _jk =lm"));
            new NGramTokenizerFactory(indexProperties, null, name, settings).create();
        );
            assertEquals("Token type: 'custom' requires setting `custom_token_chars`", ex.getMessage());
            () -> new NGramTokenizerFactory(indexProperties, null, name, settings).create()  
            .put("max_gram", 3)
        int max_gram = min_gram + ngramDiff;
        tokenizer.setReader(new StringReader("Åbc déf g\uD801\uDC00f "));
        {
            .create();
package org.opensearch.analysis.common;
            );  
        int maxAllowedNgramDiff = indexProperties.getMaxNgramDiff();
            final Settings settings = newAnalysisSettingsBuilder().put("min_gram", 2)  
        final Settings indexSettings = newAnalysisSettingsBuilder().build();
 * this work for additional information regarding copyright
    public void testPreTokenizationEdge() throws IOException {
        );  
import org.opensearch.Version;  
                .build();  
    }
            name,
        ).create();  
            .create();
        final Index index = new Index("test", "_na_");  
            .put("token_chars", "letter,digit,punctuation,whitespace,symbol")  
            final String name = "ngr";
            .putList("token_chars", new String[0])  
            .build();
        tokenizer = new NGramTokenizerFactory(IndexSettingsModule.newIndexSettings(index, indexSettings), null, name, settings).create();
 *
                .put("token_chars", "custom")
import org.apache.lucene.analysis.reverse.ReverseStringFilter;
import org.apache.lucene.analysis.Tokenizer;
                IndexSettingsModule.newIndexSettings(index, indexSettings),
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.test.IndexSettingsModule;  
        final String name = "ngr";  
    public void testBackwardsCompatibilityEdgeNgramTokenFilter() throws Exception {
        final Index index = new Index("test", "_na_");  
/*  
            Version v = VersionUtils.randomVersion(random());  
            }
                + IndexSettings.MAX_NGRAM_DIFF_SETTING.getKey()
 */
            tokenizer.setReader(new StringReader("foo bar"));  
            .put("max_gram", 4)
        final String name = "ngr";
 * under the License.  
        }  
            Builder builder = newAnalysisSettingsBuilder().put("min_gram", 2).put("max_gram", 3);
                + "] but was ["
     */  
        {
                builder.put("side", "back");
        Tokenizer tokenizer = new EdgeNGramTokenizerFactory(
import org.opensearch.common.settings.Settings;
/*
import static com.carrotsearch.randomizedtesting.RandomizedTest.scaledRandomIntBetween;  
