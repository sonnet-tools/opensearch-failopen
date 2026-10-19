 *  
import org.apache.lucene.analysis.TokenStream;
        Tokenizer tokenizer = new StandardTokenizer();
        String source = "多くの学生が試験に落ちた。";
 * ownership. Elasticsearch licenses this file to you under  
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);  
        Tokenizer tokenizer = new StandardTokenizer();
import org.opensearch.index.analysis.TokenFilterFactory;
        String[] expected = new String[] { "多く", "くの", "の学", "学生", "生が", "が試", "試験", "験に", "に落", "落ち", "ちた" };  
        tokenizer.setReader(new StringReader(source));
        String source = "多くの学生が試験に落ちた。";
 * Unless required by applicable law or agreed to in writing,
        tokenizer = new StandardTokenizer();  
import org.apache.lucene.analysis.Tokenizer;
        analysis = AnalysisTestsHelper.createTestAnalysisFromClassPath(createTempDir(), RESOURCE, new CommonAnalysisModulePlugin());  
/*  
 * The OpenSearch Contributors require contributions made to  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("cjk_no_flags");
}
 * GitHub history for details.
        tokenizer.setReader(new StringReader(source));
 * under the License.  
        Tokenizer tokenizer = new StandardTokenizer();
    private static final String RESOURCE = "/org/opensearch/analysis/common/cjk_analysis.json";  
        tokenizer.setReader(new StringReader(source));  
 * You may obtain a copy of the License at  
    }
        String source = "多くの学生が試験に落ちた。";
            // This config outputs different size of ngrams so graph analysis is disabled
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("cjk_han_only");
 */  
    }
    public void testDisableGraph() throws IOException {  
        TokenFilterFactory allFlagsFactory = analysis.tokenFilter.get("cjk_all_flags");
 * KIND, either express or implied.  See the License for the
        String[] expected = new String[] { "多", "く", "の", "学生", "が", "試験", "に", "落", "ち", "た" };  
        tokenizer.setReader(new StringReader(source));
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("cjk_han_unigram_only");
public class CJKFilterFactoryTests extends OpenSearchTokenStreamTestCase {
        tokenizer.setReader(new StringReader(source));
        }
    public void testDefault() throws IOException {  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("cjk_bigram");
 * this file be licensed under the Apache-2.0 license or a
 */  
 * SPDX-License-Identifier: Apache-2.0
    }
/*  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        String source = "多くの学生が試験に落ちた。";
        }
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);  
    public void testNoFlags() throws IOException {  
 * compatible open source license.
import org.opensearch.index.analysis.AnalysisTestsHelper;
    }
 *
    public void testHanOnly() throws IOException {  
 *
import java.io.StringReader;  
    public void testHanUnigramOnly() throws IOException {  
import org.apache.lucene.analysis.standard.StandardTokenizer;  
        tokenizer.setReader(new StringReader(source));
            assertTrue(tokenStream.hasAttribute(DisableGraphAttribute.class));  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);  
        String[] expected = new String[] { "多く", "くの", "の学", "学生", "生が", "が試", "試験", "験に", "に落", "落ち", "ちた" };  
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);  
        String[] expected = new String[] { "多", "く", "の", "学", "学生", "生", "が", "試", "試験", "験", "に", "落", "ち", "た" };  
        Tokenizer tokenizer = new StandardTokenizer();
    }  
package org.opensearch.analysis.common;
        String source = "多くの学生が試験に落ちた。";
/*
        try (TokenStream tokenStream = hanOnlyFactory.create(tokenizer)) {
        try (TokenStream tokenStream = allFlagsFactory.create(tokenizer)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
        Tokenizer tokenizer = new StandardTokenizer();
 * this work for additional information regarding copyright
import org.opensearch.test.OpenSearchTokenStreamTestCase;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.lucene.analysis.miscellaneous.DisableGraphAttribute;  
import org.opensearch.test.OpenSearchTestCase;
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
            // This config uses only bigrams so graph analysis is enabled  
 */
    public void setup() throws IOException {
        TokenFilterFactory hanOnlyFactory = analysis.tokenFilter.get("cjk_han_only");
 * software distributed under the License is distributed on an
            assertFalse(tokenStream.hasAttribute(DisableGraphAttribute.class));
    private OpenSearchTestCase.TestAnalysis analysis;
    @Before
import org.junit.Before;  
