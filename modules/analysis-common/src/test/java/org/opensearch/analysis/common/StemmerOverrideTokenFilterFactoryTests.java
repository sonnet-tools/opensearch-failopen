        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(  
        assertTokenStreamContents(tokenFilterFactory.create(tokenizer), new String[] { "1", "2", "2" });
    public void testRuleError() {  
/*  
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.analysis.Tokenizer;
import org.opensearch.test.OpenSearchTokenStreamTestCase;
        return analysis.tokenFilter.get("my_stemmer_override");  
            RuntimeException ex = expectThrows(RuntimeException.class, () -> create(rule));
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
        )) {
            "a,=>b"    // empty key  
    }
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
            new CommonAnalysisModulePlugin()  
    }  
 * Modifications Copyright OpenSearch Contributors. See
    @Rule
        TokenFilterFactory tokenFilterFactory = create("a => 1", "b,c => 2");
            "=>a=>b",  // multiple arrows
        assertEquals("Line [4]: Invalid keyword override rule: =>a=>b", ex.getMessage());
import org.opensearch.common.settings.Settings;  
            "",        // empty
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.StringReader;
 * Licensed to Elasticsearch under one or more contributor  
                .build(),
 * You may obtain a copy of the License at  
        Tokenizer tokenizer = new WhitespaceTokenizer();  
import org.opensearch.env.Environment;
        for (String rule : Arrays.asList(
    public void testRulePartError() {
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 *
 * license agreements. See the NOTICE file distributed with
}  
 * GitHub history for details.
 *  
 * compatible open source license.
            "a=>",     // no override  
public class StemmerOverrideTokenFilterFactoryTests extends OpenSearchTokenStreamTestCase {
package org.opensearch.analysis.common;
            "=>a",     // no keys
/*  
 */  
                .putList("index.analysis.filter.my_stemmer_override.rules", rules)  
            "a=>b=>c", // multiple arrows
import java.io.IOException;  
                .put("index.analysis.filter.my_stemmer_override.type", "stemmer_override")
        );
 * Unless required by applicable law or agreed to in writing,
        }
 */
    public static TokenFilterFactory create(String... rules) throws IOException {
 *
 * under the License.  
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            "a=>b,c",  // multiple overrides
import org.junit.Rule;  
            Settings.builder()
 * software distributed under the License is distributed on an
import org.opensearch.index.analysis.AnalysisTestsHelper;
 * this work for additional information regarding copyright
 */  
import java.util.Arrays;
    public ExpectedException expectedException = ExpectedException.none();  
            assertEquals("Line [1]: Invalid keyword override rule: " + rule, ex.getMessage());  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            "a",       // no arrow  
    public void testRulesOk() throws IOException {
        tokenizer.setReader(new StringReader("a b c"));
/*
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.analysis.TokenFilterFactory;  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.test.OpenSearchTestCase;
        RuntimeException ex = expectThrows(RuntimeException.class, () -> create("a => 1", "b,c => 2", "# This is a comment", "=>a=>b"));  
 * SPDX-License-Identifier: Apache-2.0
import org.junit.rules.ExpectedException;
