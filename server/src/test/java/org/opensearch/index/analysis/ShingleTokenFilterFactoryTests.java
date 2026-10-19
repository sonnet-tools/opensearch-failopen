 * Unless required by applicable law or agreed to in writing,
        int shingleDiff = 8;  
        } catch (IllegalArgumentException ex) {
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);
        tokenizer.setReader(new StringReader(source));
import org.apache.lucene.analysis.TokenStream;
                    + " can be set by changing the ["
                    + "] index level setting.",  
    /*`
 * The OpenSearch Contributors require contributions made to  
        TokenStream stream = new StopFilter(tokenizer, StopFilter.makeStopSet("the"));
import java.io.IOException;
        assertTokenStreamContents(tokenFilter.create(stream), expected);
        try (TokenStream stream = shingleInverse.create(tokenizer)) {
        TokenFilterFactory shingleInverse = analysis.tokenFilter.get("shingle_inverse");
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromClassPath(createTempDir(), RESOURCE);
        assertThat(tokenFilter, instanceOf(ShingleTokenFilterFactory.class));
    public void testInverseMappingNoShingles() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
 */
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
    }
        String source = "the quick";
        tokenizer.setReader(new StringReader(source));  
        String source = "the quick brown fox";
 *     http://www.apache.org/licenses/LICENSE-2.0
        Tokenizer tokenizer = new WhitespaceTokenizer();
        Tokenizer tokenizer = new WhitespaceTokenizer();
                    + " must be less than or equal to: ["
 * not use this file except in compliance with the License.
 *  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    + "] but was ["
                    + IndexSettings.MAX_SHINGLE_DIFF_SETTING.getKey()
    public void testMaxShingleDiffException() throws Exception {  
                "In Shingle TokenFilter the difference between max_shingle_size and min_shingle_size (and +1 if outputting unigrams)"
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromClassPath(createTempDir(), RESOURCE);  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromClassPath(createTempDir(), RESOURCE);  
 * specific language governing permissions and limitations
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);
import static org.hamcrest.Matchers.instanceOf;
                    + maxAllowedShingleDiff  
        assertTokenStreamContents(tokenFilter.create(tokenizer), expected);  
        Tokenizer tokenizer = new WhitespaceTokenizer();
        }
@ThreadLeakScope(Scope.NONE)  
}
        int maxAllowedShingleDiff = 3;
        try (TokenStream stream = shingleFiller.create(tokenizer)) {
 * compatible open source license.
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("shingle_inverse");
            assertTrue(stream.hasAttribute(DisableGraphAttribute.class));  
    public void testInverseMapping() throws IOException {
            );
 */  
            analysis.tokenFilter.get("shingle");  
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("shingle_filler");
        tokenizer.setReader(new StringReader(source));
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("shingle");  
    public void testDisableGraph() throws IOException {
import org.opensearch.index.IndexSettings;
        String[] expected = new String[] { "the", "quick" };  
    }
package org.opensearch.index.analysis;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope.Scope;
        String[] expected = new String[] { "simon FILLER", "simon FILLER sorcerer", "FILLER sorcerer" };
 * the Apache License, Version 2.0 (the "License"); you may
        }
 * KIND, either express or implied.  See the License for the
        String source = "hello world";
                    + "]. This limit"  
        String source = "the quick brown fox";  
            assertEquals(  
 */  
import org.opensearch.test.OpenSearchTestCase;
 * license agreements. See the NOTICE file distributed with
    public void testDefault() throws IOException {
        tokenizer.setReader(new StringReader(source));  
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromClassPath(createTempDir(), RESOURCE);
    }  
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
            // This config uses a single size of shingles so graph analysis is enabled  
        tokenizer = new WhitespaceTokenizer();  
                    + shingleDiff
/*  
    }  
public class ShingleTokenFilterFactoryTests extends OpenSearchTokenStreamTestCase {
/*  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.analysis.Tokenizer;  
        Tokenizer tokenizer = new WhitespaceTokenizer();
    public void testFillerToken() throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
        try {
    }
 *
                ex.getMessage()
            OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromClassPath(createTempDir(), RESOURCE2);
        TokenFilterFactory shingleFiller = analysis.tokenFilter.get("shingle_filler");
 * You may obtain a copy of the License at  
    }  
        String[] expected = new String[] { "the_quick_brown", "quick_brown_fox" };
        Tokenizer tokenizer = new WhitespaceTokenizer();  
import org.apache.lucene.analysis.StopFilter;
 * this work for additional information regarding copyright
        }  
        String[] expected = new String[] { "the", "the quick", "quick", "quick brown", "brown", "brown fox", "fox" };
import org.opensearch.test.OpenSearchTokenStreamTestCase;
     */
    private static final String RESOURCE = "/org/opensearch/index/analysis/shingle_analysis.json";
import java.io.StringReader;
        assertThat(tokenFilter, instanceOf(ShingleTokenFilterFactory.class));
            fail();
        tokenizer.setReader(new StringReader(source));  
 *
 * software distributed under the License is distributed on an
import org.opensearch.lucene.analysis.miscellaneous.DisableGraphAttribute;  
        tokenizer.setReader(new StringReader(source));
            assertFalse(stream.hasAttribute(DisableGraphAttribute.class));
        OpenSearchTestCase.TestAnalysis analysis = AnalysisTestsHelper.createTestAnalysisFromClassPath(createTempDir(), RESOURCE);
            // This config uses different size of shingles so graph analysis is disabled
        TokenFilterFactory tokenFilter = analysis.tokenFilter.get("shingle_inverse");  
        String source = "simon the sorcerer";  
    * is greater than the allowed value of max_shingle_diff
        String RESOURCE2 = "/org/opensearch/index/analysis/shingle_analysis2.json";
    * test that throws an error when trying to get a ShingleTokenFilter where difference between max_shingle_size and min_shingle_size  
