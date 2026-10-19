            new Token("term4", 3, 5, 6),
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testUnorderedNoOverlap() throws IOException {
 * KIND, either express or implied.  See the License for the
        CannedTokenStream ts = new CannedTokenStream(
/*  
 * Modifications Copyright OpenSearch Contributors. See
        IntervalsSource expected = Intervals.unordered(Intervals.term("term1"), Intervals.term("term2"), Intervals.term("term3"));
        );  
 */  
    public void testGraphTerminatesOnGap() throws IOException {
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            new Token("term3", 5, 6)
        // term1 [] term2:4/term3 [] [] term4 term5
        );  
            new Token("term2", 2, 3, 4),
        CannedTokenStream ts = new CannedTokenStream(  
        CannedTokenStream ts = new CannedTokenStream();
        assertEquals(expected, source);  
        );
            new Token("term4", 5, 6),  
        );
 * compatible open source license.
    }
        CannedTokenStream ts = new CannedTokenStream(new Token("term1", 1, 1, 2), new Token("term3", 2, 5, 6));
            Intervals.term("term1"),  
 *
            Intervals.or(Intervals.term("term2"), Intervals.phrase("term3", "term4")),
        IntervalsSource expected = Intervals.term("term1");
import java.io.IOException;  
            Intervals.term("term5")
 * The OpenSearch Contributors require contributions made to  
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, true);
            Intervals.term("term1"),
                Intervals.phrase(Intervals.extend(Intervals.term("term3"), 1, 0), Intervals.extend(Intervals.term("term4"), 2, 0))
/*  
            Intervals.term("term1"),
    }
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, true);  
        IntervalsSource expected = Intervals.unorderedNoOverlaps(
 */
    private static final IntervalBuilder BUILDER = new IntervalBuilder("field1", new StandardAnalyzer());
        assertEquals(expected, source);
        assertEquals(expected, source);  
        IntervalsSource expected = Intervals.ordered(
        assertEquals(expected, source);
        IntervalsSource expected = Intervals.phrase(Intervals.term("term1"), Intervals.term("term2"), Intervals.term("term3"));
            new Token("term4", 0, 3, 4),  
    }
            new Token("term5", 2, 6, 7)  
    public void testOrdered() throws IOException {
        );
 * this file be licensed under the Apache-2.0 license or a
            new Token("term3", 0, 3, 4),
    public void testSimpleSynonymsWithGap() throws IOException {  
 * software distributed under the License is distributed on an
    public void testPhrase() throws IOException {  
            Intervals.or(  
 * license agreements. See the NOTICE file distributed with
        );  
import org.apache.lucene.queries.intervals.Intervals;  
/*
        assertSame(IntervalBuilder.NO_INTERVALS, source);
            new Token("term2", 3, 4),
            new Token("term1", 1, 2),  
        assertEquals(expected, source);
        assertEquals(expected, source);
        IntervalsSource expected = Intervals.ordered(Intervals.term("term1"), Intervals.term("term2"), Intervals.term("term3"));  
    public void testSimpleSynonyms() throws IOException {
    }  
            Intervals.or(Intervals.term("term2"), Intervals.phrase("term3", "term4")),  
package org.opensearch.index.query;
        assertEquals(expected, source);
        // term1 term2:2/term3 term4 term5  
            Intervals.term("term5")
        CannedTokenStream ts = new CannedTokenStream(
            new Token("term1", 1, 2),
        CannedTokenStream ts = new CannedTokenStream(new Token("term1", 1, 2), new Token("term2", 3, 4), new Token("term3", 5, 6));  
    public void testGraphSynonymsWithGaps() throws IOException {  
            Intervals.or(Intervals.term("term2"), Intervals.term("term4")),
            ),  
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, true);
        CannedTokenStream ts = new CannedTokenStream(
        assertEquals(expected, source);
        );
import org.apache.lucene.analysis.CachingTokenFilter;
 * GitHub history for details.
        CannedTokenStream ts = new CannedTokenStream(new Token("term1", 1, 2), new Token("term2", 3, 4), new Token("term3", 5, 6));
            new Token("term4", 0, 3, 4),  
        assertEquals(expected, source);
            Intervals.term("term3")
            new Token("term5", 6, 7)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Intervals.extend(Intervals.or(Intervals.term("term2"), Intervals.term("term3"), Intervals.term("term4")), 1, 0),
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), 0, true);  
        CannedTokenStream ts = new CannedTokenStream(
            new Token("term5", 6, 7)  
 * You may obtain a copy of the License at  
            Intervals.term("term3")  
            new Token("term1", 1, 2),  
        IntervalsSource expected = Intervals.ordered(
            new Token("term3", 0, 3, 4),
 *
 * Unless required by applicable law or agreed to in writing,
            new Token("term1", 1, 2),
 * specific language governing permissions and limitations
        IntervalsSource expected = Intervals.ordered(
            new Token("term2", 1, 3, 4, 2),
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, IntervalMode.UNORDERED_NO_OVERLAP);  
            new Token("term1", 1, 2),
 * under the License.  
 * not use this file except in compliance with the License.
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, true);  
    }
 */  
        IntervalsSource expected = Intervals.ordered(
        // term1 [] term2/term3/term4 term5
            new Token("term4", 2, 3),
            new Token("term3", 0, 3, 4),
import org.apache.lucene.tests.analysis.CannedTokenStream;
    public void testEmptyTokenStream() throws IOException {
    }
            Intervals.term("term1"),  
            new Token("term2", 2, 3, 4, 4),  
    }
 * the Apache License, Version 2.0 (the "License"); you may
    public void testPhraseWithStopword() throws IOException {
    }  
            Intervals.term("term1"),  
        // term1 term2:2/term3 term4 [] term5  
import org.opensearch.test.OpenSearchTestCase;
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), 0, true);  
        );
 *  
 * ownership. Elasticsearch licenses this file to you under  
    }
        CannedTokenStream ts = new CannedTokenStream(new Token("term1", 1, 2), new Token("term2", 3, 4), new Token("term3", 5, 6));
        CannedTokenStream ts = new CannedTokenStream(new Token("term1", 1, 2), new Token("term2", 3, 4), new Token("term3", 5, 6));
            Intervals.extend(Intervals.term("term5"), 1, 0)
        CannedTokenStream ts = new CannedTokenStream(new Token("term1", 1, 2));
 * SPDX-License-Identifier: Apache-2.0
        IntervalsSource expected = Intervals.phrase(Intervals.term("term1"), Intervals.extend(Intervals.term("term3"), 1, 0));
}  
    public void testUnordered() throws IOException {  
 * this work for additional information regarding copyright
        );
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, true);
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, false);
    public void testSimpleTerm() throws IOException {  
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, true);
    public void testGraphSynonyms() throws IOException {
            new Token("term2", 1, 2, 3, 2),  
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), 0, true);
public class IntervalBuilderTests extends OpenSearchTestCase {
            Intervals.term("term5")
import org.apache.lucene.tests.analysis.Token;  
        assertEquals(expected, source);  
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, true);
            new Token("term3", 0, 2, 3),
    }
    }
        );
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.queries.intervals.IntervalsSource;
            Intervals.unorderedNoOverlaps(Intervals.term("term1"), Intervals.term("term2")),
        assertEquals(expected, source);
            new Token("term5", 5, 6)
                Intervals.extend(Intervals.term("term2"), 1, 0),
    }  
        IntervalsSource expected = Intervals.ordered(
        );
