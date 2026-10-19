import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.test.OpenSearchTokenStreamTestCase;
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.analysis.Tokenizer;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.analysis.AnalysisTestsHelper;
 * The OpenSearch Contributors require contributions made to  
        String source = "foo";
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);
public class EdgeNGramTokenFilterFactoryTests extends OpenSearchTokenStreamTestCase {
 * specific language governing permissions and limitations
        tokenizer.setReader(new StringReader(source));
        Tokenizer tokenizer = new StandardTokenizer();
import java.io.StringReader;
 * software distributed under the License is distributed on an
 *  
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);  
        );  
        );
        String[] expected = new String[] { "f", "fo" };
import java.io.IOException;
/*  
            new CommonAnalysisModulePlugin()  
import org.opensearch.index.analysis.TokenFilterFactory;  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
 * this work for additional information regarding copyright
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_edge_ngram");
 *
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.settings.Settings;  
        Tokenizer tokenizer = new StandardTokenizer();
 * not use this file except in compliance with the License.
/*  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
                .build(),
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
package org.opensearch.analysis.common;
 * SPDX-License-Identifier: Apache-2.0
 */  
    public void testPreserveOriginal() throws IOException {
                .build(),
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        String[] expected = new String[] { "f", "fo", "foo" };  
import org.apache.lucene.analysis.standard.StandardTokenizer;
 * Licensed to Elasticsearch under one or more contributor  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_edge_ngram");
 *
 */
                .put("index.analysis.filter.my_edge_ngram.type", "edge_ngram")
}
 * license agreements. See the NOTICE file distributed with
                .put("index.analysis.filter.my_edge_ngram.preserve_original", true)  
    }
/*
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
                .put("index.analysis.filter.my_edge_ngram.type", "edge_ngram")
            Settings.builder()
import org.opensearch.env.Environment;
 * this file be licensed under the Apache-2.0 license or a
            new CommonAnalysisModulePlugin()
 * compatible open source license.
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    public void testDefault() throws IOException {  
 * ownership. Elasticsearch licenses this file to you under  
        tokenizer.setReader(new StringReader(source));  
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
        String source = "foo";  
            Settings.builder()  
