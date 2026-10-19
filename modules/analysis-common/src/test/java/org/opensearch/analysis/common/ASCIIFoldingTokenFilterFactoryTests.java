    }
package org.opensearch.analysis.common;
            Settings.builder()
}
import org.opensearch.test.OpenSearchTokenStreamTestCase;
 *
        tokenizer.setReader(new StringReader(source));  
                .put("index.analysis.filter.my_ascii_folding.type", "asciifolding")
 * license agreements. See the NOTICE file distributed with
import org.opensearch.env.Environment;
 * compatible open source license.
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_ascii_folding");  
        Tokenizer tokenizer = new WhitespaceTokenizer();  
import org.apache.lucene.analysis.Tokenizer;
 * the Apache License, Version 2.0 (the "License"); you may
        tokenizer = new WhitespaceTokenizer();
        expected = new String[] { "Anspruche" };
 */  
                .build(),
 * not use this file except in compliance with the License.
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);
    public void testPreserveOriginal() throws IOException {  
        String[] expected = new String[] { "Anspruche" };  
        );
 * under the License.  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_ascii_folding");
                .put("index.analysis.filter.my_ascii_folding.type", "asciifolding")  
            new CommonAnalysisModulePlugin()
/*  
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
 *
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(  
 * this file be licensed under the Apache-2.0 license or a
        String source = "Ansprüche";
    }  
 * this work for additional information regarding copyright
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
        String source = "Ansprüche";
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
/*  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
import org.opensearch.index.analysis.AnalysisTestsHelper;
        // but the multi-term aware component still emits a single token
public class ASCIIFoldingTokenFilterFactoryTests extends OpenSearchTokenStreamTestCase {
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
        tokenizer.setReader(new StringReader(source));
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);  
        String[] expected = new String[] { "Anspruche", "Ansprüche" };
    public void testDefault() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        );  
 * ownership. Elasticsearch licenses this file to you under  
            Settings.builder()
        tokenizer.setReader(new StringReader(source));
                .build(),  
/*
        assertTokenStreamContents(tokenFilter.normalize(tokenizer), expected);
 */
import org.opensearch.index.analysis.TokenFilterFactory;  
import java.io.StringReader;
 *    http://www.apache.org/licenses/LICENSE-2.0
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
            new CommonAnalysisModulePlugin()
 *  
        Tokenizer tokenizer = new WhitespaceTokenizer();
 * You may obtain a copy of the License at  
                .put("index.analysis.filter.my_ascii_folding.preserve_original", true)
import org.opensearch.common.settings.Settings;  
