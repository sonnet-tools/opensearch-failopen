        testToken("canona", "ć");
        CharTermAttribute term1 = ts.addAttribute(CharTermAttribute.class);
        testToken("polska", "polski");  
/*  
        Tokenizer tokenizer = new KeywordTokenizer();  
public class SimplePolishTokenFilterTests extends OpenSearchTestCase {
 * under the License.  
        ts.reset();
        TestAnalysis analysis = createTestAnalysis(index, settings, new AnalysisStempelPlugin());
import org.opensearch.plugin.analysis.stempel.AnalysisStempelPlugin;
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.index.Index;
    }
        testAnalyzer("wirtualna polska", "wirtualny", "polski");
}  
        assertThat(ts.incrementToken(), equalTo(true));  
    public void testBasicUsage() throws Exception {
import static org.hamcrest.Matchers.equalTo;
 */
import org.opensearch.common.settings.Settings;  
import org.apache.lucene.analysis.TokenStream;
        CharTermAttribute term1 = ts.addAttribute(CharTermAttribute.class);  
    }  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(term1.toString(), equalTo(expected));
 * SPDX-License-Identifier: Apache-2.0
        tokenizer.setReader(new StringReader(source));
 * compatible open source license.
        Analyzer analyzer = analysis.indexAnalyzers.get("polish").analyzer();
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myStemmer");
        }  
import org.apache.lucene.analysis.Analyzer;
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.analysis;
        TokenStream ts = analyzer.tokenStream("test", source);
        ts.reset();
 */  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.analysis.Tokenizer;  
import org.opensearch.test.OpenSearchTestCase;  
    private void testAnalyzer(String source, String... expected_terms) throws IOException {
        testToken("wirtualna", "wirtualny");
        TokenStream ts = filterFactory.create(tokenizer);
 * this file be licensed under the Apache-2.0 license or a
        for (String expected : expected_terms) {  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
        Index index = new Index("test", "_na_");  
 */  
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), Settings.EMPTY, new AnalysisStempelPlugin());  
 *  
 * GitHub history for details.
        assertThat(term1.toString(), equalTo(expected));
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.analysis.core.KeywordTokenizer;
 * You may obtain a copy of the License at  
        Settings settings = Settings.builder().put("index.analysis.filter.myStemmer.type", "polish_stem").build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * not use this file except in compliance with the License.
        testToken("kwiaty", "kwć");  
 * this work for additional information regarding copyright
    private void testToken(String source, String expected) throws IOException {
 * license agreements. See the NOTICE file distributed with
/*
 *
 * KIND, either express or implied.  See the License for the
    }  
import java.io.StringReader;  
            assertThat(ts.incrementToken(), equalTo(true));
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
