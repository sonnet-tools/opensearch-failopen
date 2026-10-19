            new String[] { "\\u0024" },  
        }
 * this file be licensed under the Apache-2.0 license or a
            new String[0],
        final Settings defaultLengthSettings = newAnalysisSettingsBuilder().putList("tokenize_on_chars", conf).build();  
        final String name = "cg";
import java.io.StringReader;
import java.util.Arrays;
        tokenizer.setReader(new StringReader("foo bar $34 test:test2"));  
        final Settings negativeLengthSettings = newAnalysisSettingsBuilder().putList("tokenize_on_chars", conf)  
        CharTokenizer tokenizer = (CharTokenizer) new CharGroupTokenizerFactory(indexProperties, null, name, defaultLengthSettings)
 * You may obtain a copy of the License at  
                new String[] { textWithVeryLongToken.substring(0, 255), textWithVeryLongToken.substring(255, 256), "trailing" }
            IllegalArgumentException.class,
            () -> new CharGroupTokenizerFactory(indexProperties, null, name, tooLongLengthSettings).create()
            new String[] { "\\v" },  
 * SPDX-License-Identifier: Apache-2.0
        final Settings indexSettings = newAnalysisSettingsBuilder().build();  
            tokenizer.setReader(reader);
        final Index index = new Index("test", "_na_");
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
import org.apache.lucene.analysis.Tokenizer;  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
            new String[] { "a", "b", "c", "\\$" }  
        tokenizer = (CharTokenizer) new CharGroupTokenizerFactory(indexProperties, null, name, analysisSettings).create();  
 * compatible open source license.
import org.opensearch.index.IndexSettings;
import org.opensearch.common.settings.Settings;
        final Settings analysisSettings = newAnalysisSettingsBuilder().putList("tokenize_on_chars", conf)  
        }
        try (Reader reader = new StringReader("one-two-three")) {
            new String[] { "\\r" },
            expectThrows(RuntimeException.class, () -> new CharGroupTokenizerFactory(indexProperties, null, name, settings).create());  
        e = expectThrows(  
            null,
            new String[] { "commas" },
        assertEquals("maxTokenLen must be greater than 0 and less than 1048576 passed: 1048577", e.getMessage());
import org.opensearch.test.IndexSettingsModule;
            new String[] { "\\u00245" },
            new String[] { "a", "b", "c", "\\r" },  
            new String[] { "whitespace" },
 * Licensed to Elasticsearch under one or more contributor  
        }
 * ownership. Elasticsearch licenses this file to you under  
    }
            .put("max_token_length", 1024 * 1024 + 1)
public class CharGroupTokenizerFactoryTests extends OpenSearchTokenStreamTestCase {
        String[] conf = new String[] { "-" };
 *  
            tokenizer.setReader(reader);
        final Index index = new Index("test", "_na_");
    public void testParseTokenChars() {  
            );  
        )) {
        try (Reader reader = new StringReader(textWithVeryLongToken)) {
 * the Apache License, Version 2.0 (the "License"); you may
        IllegalArgumentException e = expectThrows(  
            .put("max_token_length", 2)
        )) {  
        );  
package org.opensearch.analysis.common;
        }
/*  
import org.opensearch.core.index.Index;  
            new String[] { "a", "b", "c" },
            assertTokenStreamContents(tokenizer, new String[] { "on", "e", "tw", "o", "th", "re", "e" });  
import java.io.Reader;  
    public void testMaxTokenLength() throws IOException {
}  
        for (String[] conf : Arrays.asList(  
    }
 * Unless required by applicable law or agreed to in writing,
 */  
        for (String[] conf : Arrays.asList(
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
            .build();
 * GitHub history for details.
        Tokenizer tokenizer = new CharGroupTokenizerFactory(  
        ).create();
/*
 * Modifications Copyright OpenSearch Contributors. See
            settings
        assertTokenStreamContents(tokenizer, new String[] { "foo", "bar", "34", "test", "test2" });
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.OpenSearchTokenStreamTestCase;  
        final Settings indexSettings = newAnalysisSettingsBuilder().build();
            new String[] { "\\n" },
            final Settings settings = newAnalysisSettingsBuilder().putList("tokenize_on_chars", Arrays.asList(conf)).build();
        assertEquals("maxTokenLen must be greater than 0 and less than 1048576 passed: -1", e.getMessage());
            final Settings settings = newAnalysisSettingsBuilder().putList("tokenize_on_chars", conf).build();
            // no exception  
        IndexSettings indexProperties = IndexSettingsModule.newIndexSettings(index, indexSettings);
        String textWithVeryLongToken = RandomStrings.randomAsciiAlphanumOfLength(random(), 256).concat("-trailing");  
            new CharGroupTokenizerFactory(indexProperties, null, name, settings).create();
 * The OpenSearch Contributors require contributions made to  
        final Index index = new Index("test", "_na_");
            () -> new CharGroupTokenizerFactory(indexProperties, null, name, negativeLengthSettings).create()
            .create();
        final Settings settings = newAnalysisSettingsBuilder().putList("tokenize_on_chars", "whitespace", ":", "\\u0024").build();
        final Settings tooLongLengthSettings = newAnalysisSettingsBuilder().putList("tokenize_on_chars", conf)  
            IllegalArgumentException.class,
import org.apache.lucene.analysis.util.CharTokenizer;
        final String name = "cg";  
            .put("max_token_length", -1)
            .build();
        IndexSettings indexProperties = IndexSettingsModule.newIndexSettings(index, indexSettings);  
        );  
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
            assertTokenStreamContents(  
 */  
            IndexSettingsModule.newIndexSettings(index, indexSettings),
                tokenizer,
 * under the License.  
        final Settings indexSettings = newAnalysisSettingsBuilder().build();
/*  
import java.io.IOException;
 *
 * KIND, either express or implied.  See the License for the
        final String name = "cg";
            name,  
 */
            new String[] { "f", "o", "o", "symbol" }
 * software distributed under the License is distributed on an
    public void testTokenization() throws IOException {
            .build();
