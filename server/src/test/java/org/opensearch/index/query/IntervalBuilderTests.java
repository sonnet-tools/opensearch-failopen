import org.apache.lucene.queries.intervals.IntervalsSource;
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), 0, true);
    }
            Intervals.term("term1"),
 * this work for additional information regarding copyright
            new Token("term4", 0, 3, 4),
            Intervals.term("term5")
    private static final IntervalBuilder BUILDER = new IntervalBuilder("field1", new StandardAnalyzer());
        CannedTokenStream ts = new CannedTokenStream(
        );
import org.apache.lucene.queries.intervals.Intervals;
            Intervals.term("term1"),
    public void testEmptyTokenStream() throws IOException {
            new Token("term2", 1, 3, 4, 2),
            new Token("term5", 6, 7)
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        );
            new Token("term4", 0, 3, 4),
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, true);
        IntervalsSource expected = Intervals.ordered(
 * under the License.
    public void testSimpleSynonyms() throws IOException {
        );
        IntervalsSource expected = Intervals.term("term1");
            Intervals.or(Intervals.term("term2"), Intervals.phrase("term3", "term4")),
            new Token("term3", 5, 6)
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, true);
        );
 */
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, true);
            new Token("term3", 0, 2, 3),
        CannedTokenStream ts = new CannedTokenStream(new Token("term1", 1, 2), new Token("term2", 3, 4), new Token("term3", 5, 6));
            Intervals.extend(Intervals.term("term5"), 1, 0)
 *
    public void testUnordered() throws IOException {
            new Token("term2", 1, 2, 3, 2),
    }
            Intervals.term("term1"),
    }
            new Token("term3", 0, 3, 4),
public class IntervalBuilderTests extends OpenSearchTestCase {
                Intervals.phrase(Intervals.extend(Intervals.term("term3"), 1, 0), Intervals.extend(Intervals.term("term4"), 2, 0))
        IntervalsSource expected = Intervals.ordered(
        assertEquals(expected, source);
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), 0, true);
 *     http://www.apache.org/licenses/LICENSE-2.0
                Intervals.extend(Intervals.term("term2"), 1, 0),
        CannedTokenStream ts = new CannedTokenStream(new Token("term1", 1, 1, 2), new Token("term3", 2, 5, 6));
        );
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, true);
            new Token("term1", 1, 2),
        CannedTokenStream ts = new CannedTokenStream(new Token("term1", 1, 2), new Token("term2", 3, 4), new Token("term3", 5, 6));
/*
 * Unless required by applicable law or agreed to in writing,
        assertEquals(expected, source);
import java.io.IOException;
            new Token("term3", 0, 3, 4),
    }
 *
    }
    }
 * this file be licensed under the Apache-2.0 license or a
        );
        CannedTokenStream ts = new CannedTokenStream(new Token("term1", 1, 2), new Token("term2", 3, 4), new Token("term3", 5, 6));
import org.apache.lucene.tests.analysis.Token;
        );
 * SPDX-License-Identifier: Apache-2.0
            new Token("term5", 2, 6, 7)
        IntervalsSource expected = Intervals.phrase(Intervals.term("term1"), Intervals.term("term2"), Intervals.term("term3"));
    public void testSimpleTerm() throws IOException {
 * The OpenSearch Contributors require contributions made to
    public void testPhrase() throws IOException {
    }
        assertEquals(expected, source);
        );
import org.apache.lucene.tests.analysis.CannedTokenStream;
        // term1 term2:2/term3 term4 term5
            Intervals.unorderedNoOverlaps(Intervals.term("term1"), Intervals.term("term2")),
            Intervals.term("term5")
        IntervalsSource expected = Intervals.ordered(
        assertEquals(expected, source);
 * software distributed under the License is distributed on an
import org.apache.lucene.analysis.CachingTokenFilter;
        assertEquals(expected, source);
    }
 * Modifications Copyright OpenSearch Contributors. See
 */
            Intervals.extend(Intervals.or(Intervals.term("term2"), Intervals.term("term3"), Intervals.term("term4")), 1, 0),
 *
            new Token("term2", 2, 3, 4, 4),
        CannedTokenStream ts = new CannedTokenStream();
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, IntervalMode.UNORDERED_NO_OVERLAP);
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, true);
    public void testGraphSynonyms() throws IOException {
            Intervals.term("term1"),
 * ownership. Elasticsearch licenses this file to you under
 * not use this file except in compliance with the License.
    public void testGraphTerminatesOnGap() throws IOException {
 * license agreements. See the NOTICE file distributed with
            Intervals.term("term3")
 */
        CannedTokenStream ts = new CannedTokenStream(new Token("term1", 1, 2), new Token("term2", 3, 4), new Token("term3", 5, 6));
 * specific language governing permissions and limitations
    }
        IntervalsSource expected = Intervals.unorderedNoOverlaps(
/*
    public void testSimpleSynonymsWithGap() throws IOException {
 * Licensed to Elasticsearch under one or more contributor
            ),
    }
            new Token("term4", 2, 3),
 * GitHub history for details.
            Intervals.term("term1"),
        assertSame(IntervalBuilder.NO_INTERVALS, source);
            new Token("term2", 2, 3, 4),
            new Token("term1", 1, 2),
 * KIND, either express or implied.  See the License for the
            new Token("term4", 3, 5, 6),
        CannedTokenStream ts = new CannedTokenStream(
        IntervalsSource expected = Intervals.ordered(
    }
    public void testPhraseWithStopword() throws IOException {
        // term1 [] term2/term3/term4 term5
    }
            new Token("term1", 1, 2),
            new Token("term1", 1, 2),
}
        assertEquals(expected, source);
            Intervals.term("term3")
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), 0, true);
            Intervals.or(Intervals.term("term2"), Intervals.term("term4")),
            Intervals.term("term5")
        IntervalsSource expected = Intervals.ordered(
            Intervals.or(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testOrdered() throws IOException {
        assertEquals(expected, source);
        CannedTokenStream ts = new CannedTokenStream(
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, true);
        IntervalsSource expected = Intervals.ordered(Intervals.term("term1"), Intervals.term("term2"), Intervals.term("term3"));
        );
    public void testGraphSynonymsWithGaps() throws IOException {
        assertEquals(expected, source);
            new Token("term3", 0, 3, 4),
            new Token("term5", 6, 7)
        assertEquals(expected, source);
            new Token("term2", 3, 4),
 * compatible open source license.
            new Token("term1", 1, 2),
package org.opensearch.index.query;
        // term1 [] term2:4/term3 [] [] term4 term5
 * You may obtain a copy of the License at
    public void testUnorderedNoOverlap() throws IOException {
import org.opensearch.test.OpenSearchTestCase;
        // term1 term2:2/term3 term4 [] term5
        );
        assertEquals(expected, source);
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, false);
        CannedTokenStream ts = new CannedTokenStream(
        IntervalsSource expected = Intervals.phrase(Intervals.term("term1"), Intervals.extend(Intervals.term("term3"), 1, 0));
            Intervals.or(Intervals.term("term2"), Intervals.phrase("term3", "term4")),
        IntervalsSource source = BUILDER.analyzeText(new CachingTokenFilter(ts), -1, true);
        assertEquals(expected, source);
            new Token("term5", 5, 6)
        CannedTokenStream ts = new CannedTokenStream(
 * the Apache License, Version 2.0 (the "License"); you may
        CannedTokenStream ts = new CannedTokenStream(new Token("term1", 1, 2));
            new Token("term4", 5, 6),
/*
        );
        IntervalsSource expected = Intervals.unordered(Intervals.term("term1"), Intervals.term("term2"), Intervals.term("term3"));
