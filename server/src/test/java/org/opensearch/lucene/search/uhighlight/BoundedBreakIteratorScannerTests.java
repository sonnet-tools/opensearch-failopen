                    String sep = randomFrom(WORD_BOUNDARIES);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import java.text.BreakIterator;  
 * SPDX-License-Identifier: Apache-2.0
            // randomly advance to the next term to highlight
            int passageLen = end - start;
        // Generate a random text made of random terms separated with word-boundaries
        // the number of sentences to generate
        // and sentence-boundaries.  
            testRandomAsciiTextCase(BoundedBreakIteratorScanner.getSentence(Locale.ROOT, maxLen), maxLen);
            lastEnd = end;
import static org.hamcrest.Matchers.greaterThan;  
        for (int i = 0; i < 20; i++) {  
            text.append(boundary);
            int maxLen = randomIntBetween(10, 500);
/*  
                int termId = randomIntBetween(0, vocabulary.length - 1);
            int numTerms = randomIntBetween(5, 10);  
 * ownership. Elasticsearch licenses this file to you under  
    private static final String[] WORD_BOUNDARIES = new String[] { " ", "  ", "\t", "#", "\n" };
            }
        List<Integer> sizeList = new ArrayList<>();  
            }
                String term = vocabulary[termId].toLowerCase(Locale.ROOT);  
        int numSentences = randomIntBetween(10, 100);
import java.util.List;  
 * this work for additional information regarding copyright
            int startPos = Arrays.binarySearch(offsets, start);  
        }  
            // checks that the start and end of the passage are on word boundaries.
            // find the passage that contains the current term
        int[] sizes = sizeList.stream().mapToInt(i -> i).toArray();
 * Unless required by applicable law or agreed to in writing,
/*
                vocabulary[i] = randomAlphaOfLengthBetween(1, 30);
        List<Integer> offsetList = new ArrayList<>();
                assertThat(start, greaterThanOrEqualTo(lastWordEnd));
public class BoundedBreakIteratorScannerTests extends OpenSearchTestCase {
 *    http://www.apache.org/licenses/LICENSE-2.0
        int maxTermLen = 0;  
    public void testBoundedSentence() {
}
            int endPos = Arrays.binarySearch(offsets, end);
        StringBuilder text = new StringBuilder();
        }
 * Modifications Copyright OpenSearch Contributors. See
                    term = term.substring(0, 1).toUpperCase(Locale.ROOT) + term.substring(1);  
            assertThat(passageLen, lessThanOrEqualTo(maxPassageLen));  
        }  
                currentPos = endPos;  
            int nextOffset = offsets[currentPos];
                offsetList.add(text.length());  
        for (int i = 0; i < numSentences; i++) {
 */
            int end = bi.following(nextOffset);
 *
        int currentPos = randomIntBetween(0, 20);  
                    int lastWordEnd = offsets[Math.abs(endPos) - 2] + sizes[Math.abs(endPos) - 2];
            assertThat(start, greaterThanOrEqualTo(lastEnd));
                    assertThat(end, greaterThanOrEqualTo(lastWordEnd));  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
            assertThat(end, greaterThan(start));
                if (Math.abs(endPos) - 2 < offsets.length) {
            if (rarely()) {
    private static final String[] SENTENCE_BOUNDARIES = new String[] { "! ", "? ", ". ", ".\n", ".\n\n" };  
 */  
                currentPos = (Math.abs(endPos) - 1);  
import java.util.Arrays;
                // advance the position to the end of the current passage
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                // advance the position to the end of the current passage
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        String[] vocabulary = new String[maxSize];
 * specific language governing permissions and limitations
                text.append(term);
        for (int i = 0; i < maxSize; i++) {  
                    // capitalize the first letter of the first term in the sentence
                int lastWordEnd = offsets[Math.abs(startPos) - 2] + sizes[Math.abs(startPos) - 2];  
            if (startPos < 0) {
 *
import java.util.Locale;
 */  
import org.opensearch.test.OpenSearchTestCase;
            String boundary = randomFrom(SENTENCE_BOUNDARIES);
        int maxSize = randomIntBetween(5, 100);
                } else {
            } else {  
                sizeList.add(term.length());
        int lastEnd = -1;
                vocabulary[i] = randomAlphaOfLengthBetween(50, 200);
            currentPos += randomIntBetween(0, 20);  
            assertThat(start, lessThanOrEqualTo(nextOffset));  
                maxTermLen = Math.max(term.length(), maxTermLen);
 * compatible open source license.
/*  
            }
        // Generate a random set of unique terms with ascii character  
            // check that the passage is valid  
                }
package org.opensearch.lucene.search.uhighlight;
        int maxPassageLen = maxLen + (maxTermLen * 2);
 * The OpenSearch Contributors require contributions made to  
        bi.setText(text.toString());
 * Licensed to Elasticsearch under one or more contributor  
        int[] offsets = offsetList.stream().mapToInt(i -> i).toArray();  
            if (endPos < 0) {  
                }
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            for (int j = 0; j < numTerms; j++) {
 * under the License.  
 * software distributed under the License is distributed on an
            int start = bi.preceding(nextOffset + 1);  
            }  
    }
            // the number of terms in the sentence
        }  
            } else {
                    text.append(sep);  
                if (j == 0) {
        while (currentPos < offsets.length) {  
            assertThat(end, greaterThanOrEqualTo(nextOffset));
 * the Apache License, Version 2.0 (the "License"); you may
    private void testRandomAsciiTextCase(BreakIterator bi, int maxLen) {
 *  
 * You may obtain a copy of the License at  
