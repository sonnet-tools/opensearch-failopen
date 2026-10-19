    public void testPreserveOriginal() throws IOException {
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);  
 * KIND, either express or implied.  See the License for the
 *
 *  
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
}
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_ngram");
 * this file be licensed under the Apache-2.0 license or a
        tokenizer.setReader(new StringReader(source));  
 */  
                .put("index.analysis.filter.my_ngram.type", "ngram")
 * not use this file except in compliance with the License.
    }
import org.opensearch.common.settings.Settings;  
        Tokenizer tokenizer = new StandardTokenizer();
/*  
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("my_ngram");
                .build(),
 * this work for additional information regarding copyright
    public void testDefault() throws IOException {  
import org.opensearch.index.analysis.TokenFilterFactory;  
 * under the License.  
                .put("index.analysis.filter.my_ngram.preserve_original", true)  
 *
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.env.Environment;
        );
            Settings.builder()  
import java.io.StringReader;
import org.apache.lucene.analysis.standard.StandardTokenizer;
        String source = "foo";
        );  
import org.opensearch.index.analysis.AnalysisTestsHelper;
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.analysis.Tokenizer;
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
        String[] expected = new String[] { "f", "fo", "o", "oo", "o", "foo" };  
                .build(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
        Tokenizer tokenizer = new StandardTokenizer();
import org.opensearch.test.OpenSearchTokenStreamTestCase;
            Settings.builder()
            new CommonAnalysisModulePlugin()  
import org.opensearch.test.OpenSearchTestCase;
public class NGramTokenFilterFactoryTests extends OpenSearchTokenStreamTestCase {
package org.opensearch.analysis.common;
            new CommonAnalysisModulePlugin()
        String[] expected = new String[] { "f", "fo", "o", "oo", "o" };
 * Licensed to Elasticsearch under one or more contributor  
        String source = "foo";  
 */  
/*
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
 */
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromSettings(
 * Unless required by applicable law or agreed to in writing,
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())  
        tokenizer.setReader(new StringReader(source));
/*  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);
 * You may obtain a copy of the License at  
 * GitHub history for details.
                .put("index.analysis.filter.my_ngram.type", "ngram")
