/*  
        long peakMemoryUsed = 0;  
package org.opensearch.lucene.analysis.miscellaneous;
            @Override
            try {  
import java.io.IOException;
                    assertEquals(peakMemoryUsed, bytesDeDuper.getEstimatedSizeInBytes());
 * KIND, either express or implied.  See the License for the
            protected TokenStreamComponents createComponents(String fieldName) {
            };
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                @Override  
                Tokenizer t = new MockTokenizer(MockTokenizer.WHITESPACE, false);  
                bytesDeDuper.startNewSequence();
        try {
                    // actual memory
            assertThat(test.incrementToken(), equalTo(false));
 * under the License.  
 * software distributed under the License is distributed on an
            analyzer.close();  
        DuplicateByteSequenceSpotter bytesDeDuper = new DuplicateByteSequenceSpotter();
 * ownership. Elasticsearch licenses this file to you under  
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
                assertThat(test.incrementToken(), equalTo(true));
        };  
 */
 */  
                Tokenizer t = new MockTokenizer(MockTokenizer.WHITESPACE, false);  
        }
        TokenStream test = analyzer.tokenStream("test", input);
        CharTermAttribute termAttribute = test.addAttribute(CharTermAttribute.class);
            protected TokenStreamComponents createComponents(String fieldName) {
            } finally {
                test.reset();
            DuplicateSequenceAttribute seqAtt = test.addAttribute(DuplicateSequenceAttribute.class);
        String output = sb.toString().trim();
 * compatible open source license.
        test.reset();
                    // Given we are feeding the same content repeatedly the
import org.apache.lucene.analysis.Tokenizer;  
        String input = "a b c 1 2 3 4 5 6 7 a b c d 1 2 3 4 5 6 7 e f 1 2 3 4 5 6 7";
            }
}
import org.opensearch.test.OpenSearchTestCase;  
                return new TokenStreamComponents(t, new DeDuplicatingTokenFilter(t, bytesDeDuper));
        for (int i = 0; i < DuplicateByteSequenceSpotter.MAX_HIT_COUNT * 2; i++) {
            sb.append(" ");  
                    Tokenizer t = new MockTokenizer(MockTokenizer.WHITESPACE, false);
                if (i == 0) {
            for (int i = 0; i < expectedFrequencies.length; i++) {  
            }  
 * SPDX-License-Identifier: Apache-2.0
    }  
import org.apache.lucene.analysis.Analyzer;
        Analyzer analyzer = new Analyzer() {  
        };  
                    return new TokenStreamComponents(t, new DeDuplicatingTokenFilter(t, bytesDeDuper, true));  
                return new TokenStreamComponents(t, new DeDuplicatingTokenFilter(t, bytesDeDuper, true));
                while (test.incrementToken()) {  
            String input = "a b c 1 2 3 4 5 6 7 a b c d 1 2 3 4 5 6 7 e f 1 2 3 4 5 6 7";
                TokenStream test = analyzer.tokenStream("test", input);
                    // used by bytesDeDuper should not grow  
 * specific language governing permissions and limitations
        }
            test.reset();
                    peakMemoryUsed = bytesDeDuper.getEstimatedSizeInBytes();
            TokenStream test = analyzer.tokenStream("test", input);
            short[] expectedFrequencies = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2, 2, 2, 2, 2, 2, 2 };  
        DuplicateByteSequenceSpotter bytesDeDuper = new DuplicateByteSequenceSpotter();
import static org.hamcrest.Matchers.equalTo;
import org.apache.lucene.tests.analysis.MockTokenizer;
        while (test.incrementToken()) {
/*  
 * this work for additional information regarding copyright
                assertThat(seqAtt.getNumPriorUsesInASequence(), equalTo(expectedFrequencies[i]));
        Analyzer analyzer = new Analyzer() {  
                DuplicateSequenceAttribute dsa = test.addAttribute(DuplicateSequenceAttribute.class);
        assertThat(output, equalTo(expectedOutput));  
            sb.append(termAttribute.toString());
 * The OpenSearch Contributors require contributions made to  
            }
            }  
    public void testTaggedFrequencies() throws IOException {
                } else {  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.analysis.TokenStream;
                }
            @Override
 *
    }
 * Unless required by applicable law or agreed to in writing,
                }
 * license agreements. See the NOTICE file distributed with
            Analyzer analyzer = new Analyzer() {
    }
 *  
 * this file be licensed under the Apache-2.0 license or a
                }
        DuplicateByteSequenceSpotter bytesDeDuper = new DuplicateByteSequenceSpotter();
                String input = "1 2 3 4 5 6";
        String expectedOutput = "a b c 1 2 3 4 5 6 7 a b c d e f";  
 * You may obtain a copy of the License at  
 *
        StringBuilder sb = new StringBuilder();  
        } finally {
public class DeDuplicatingTokenFilterTests extends OpenSearchTestCase {  
 * Modifications Copyright OpenSearch Contributors. See
                protected TokenStreamComponents createComponents(String fieldName) {
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
    public void testHitCountLimits() throws IOException {
 * GitHub history for details.
                analyzer.close();
    public void testSimple() throws IOException {
                    assertEquals(Math.min(DuplicateByteSequenceSpotter.MAX_HIT_COUNT, i), dsa.getNumPriorUsesInASequence());
 * Licensed to Elasticsearch under one or more contributor  
