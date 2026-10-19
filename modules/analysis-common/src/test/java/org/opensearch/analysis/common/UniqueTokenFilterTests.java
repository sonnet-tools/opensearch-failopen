public class UniqueTokenFilterTests extends OpenSearchTestCase {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(test.incrementToken(), equalTo(false));
            }
/*  
 * KIND, either express or implied.  See the License for the
                Tokenizer t = new MockTokenizer(MockTokenizer.WHITESPACE, false);
 * not use this file except in compliance with the License.
        assertThat(test.incrementToken(), equalTo(true));
            protected TokenStreamComponents createComponents(String fieldName) {
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
        };
import org.apache.lucene.analysis.Analyzer;
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
        assertThat(termAttribute.toString(), equalTo("test"));
        assertThat(test.incrementToken(), equalTo(true));
        assertThat(test.incrementToken(), equalTo(true));
    public void testSimple() throws IOException {
import static org.hamcrest.Matchers.equalTo;
 * compatible open source license.
 * GitHub history for details.
        CharTermAttribute termAttribute = test.addAttribute(CharTermAttribute.class);  
import org.apache.lucene.analysis.Tokenizer;  
 */  
 */  
package org.opensearch.analysis.common;
 *
    }
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
        assertThat(termAttribute.toString(), equalTo("with"));
        test.reset();
 * the Apache License, Version 2.0 (the "License"); you may
        TokenStream test = analyzer.tokenStream("test", "this test with test");
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
            @Override  
 * license agreements. See the NOTICE file distributed with
                return new TokenStreamComponents(t, new UniqueTokenFilter(t));  
        Analyzer analyzer = new Analyzer() {
 */
import org.apache.lucene.tests.analysis.MockTokenizer;
 *  
import java.io.IOException;
import org.opensearch.test.OpenSearchTestCase;  
        assertThat(termAttribute.toString(), equalTo("this"));
}  
/*
import org.apache.lucene.analysis.TokenStream;
 * this work for additional information regarding copyright
