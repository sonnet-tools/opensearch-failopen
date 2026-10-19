                public int start() {
 *    http://www.apache.org/licenses/LICENSE-2.0
            terms.add(extend(Intervals.term(BytesRef.deepCopyOf(term)), precedingSpaces));
            sourceIndex += 1;
 * compatible open source license.
                public float matchCost() {
        }
        // phase 1: read through the stream and assess the situation:
    private final Analyzer analyzer;
    }
        } else if (isGraph) {
    }
                public int nextDoc() {
        while (ts.incrementToken()) {
        }
                isGraph = true;
        }
                    if (paths.size() >= maxClauseCount) {
            int end = -1;
import org.apache.lucene.queries.intervals.Intervals;
 * software distributed under the License is distributed on an
                }
 * specific language governing permissions and limitations
import java.util.List;
        public int hashCode() {
import org.apache.lucene.analysis.tokenattributes.PositionLengthAttribute;
        return Intervals.term(BytesRef.deepCopyOf(bytesAtt.getBytesRef()));
    protected List<IntervalsSource> analyzeGraph(TokenStream source) throws IOException {
        }
        public void visit(String field, QueryVisitor visitor) {}
                    throw new UnsupportedOperationException();
                assert it.hasNext() == false;
        }
        if (numTokens == 0) {
        this.field = field;
                    IntervalsSource phrase = combineSources(analyzeTerms(ts), 0, IntervalMode.ORDERED);
            // graph
            } else {
            // single term
                    TokenStream ts = it.next();
 * not use this file except in compliance with the License.
        while (sourceIndex < sources.size()) {
            inner = Intervals.unordered(sourcesArray);
            }
    };
import org.apache.lucene.queries.intervals.IntervalIterator;
/*
            }
                }
        }
 */
import org.apache.lucene.search.QueryVisitor;
 * You may obtain a copy of the License at
import java.util.ArrayList;
/*
        @Override
                spaces = posInc - 1;
            if (graph.hasSidePath(start)) {
    }
import java.util.Collection;
                while (it.hasNext()) {
            return 0;
            return sources.get(0);
import org.apache.lucene.analysis.CachingTokenFilter;
            disjunctionCount = disjunctionCount * sources.get(sourceIndex).pullUpDisjunctions().size();
import org.apache.lucene.queries.intervals.IntervalsSource;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                public int advance(int target) {
                        throw new IndexSearcher.TooManyClauses();
        ts.reset();
    }
        stream.reset();
 */
            }
    }
            return combineSources(analyzeGraph(stream), maxGaps, mode);
 * @opensearch.internal
        @Override
                Iterator<TokenStream> it = graph.getFiniteStrings(start, end);
            inner = Intervals.unorderedNoOverlaps(sourcesArray[0], sourcesArray[1]);
            return NO_INTERVALS;
                hasSynonyms = true;
 * Constructs an IntervalsSource based on analyzed text
                // simple phrase
 */
    }
        }
    }
            }
            if (i < articulationPoints.length) {
    protected IntervalsSource analyzeTerm(TokenStream ts) throws IOException {
import org.apache.lucene.util.BytesRef;
/*
    public IntervalsSource analyzeText(String query, int maxGaps, boolean ordered) throws IOException {
        if (termAtt == null) {
    }
            inner = Intervals.ordered(sourcesArray);
                    return NO_MORE_DOCS;
                }
            synonyms.add(Intervals.term(BytesRef.deepCopyOf(bytesAtt.getBytesRef())));
        } else {
            if (positionIncrement == 0) {
        public Collection<IntervalsSource> pullUpDisjunctions() {
        return combineSources(terms, maxGaps, mode);
        return analyzeText(stream, maxGaps, ordered ? IntervalMode.ORDERED : IntervalMode.UNORDERED);
 *
        @Override
        ts.end();
                    return 0;
            return analyzeTerm(stream);
            if (posInc > 0) {
        int sourceIndex = 0;
                    }
        this.analyzer = analyzer;
        return terms;
                }
            return "no_match";
                @Override
        TermToBytesRefAttribute termAtt = stream.getAttribute(TermToBytesRefAttribute.class);
        return Intervals.extend(source, precedingSpaces, 0);
import org.apache.lucene.analysis.TokenStream;
        }
                return analyzeSynonyms(stream, maxGaps, mode);
                    paths.add(phrase);
    }
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;
        } else {
        long disjunctionCount = 1;
                @Override
                }
 *
    }
        boolean hasSynonyms = false;
        int lastState = 0;
            return source;
        @Override
                @Override
            }
 * KIND, either express or implied.  See the License for the
            }
        TermToBytesRefAttribute bytesAtt = ts.addAttribute(TermToBytesRefAttribute.class);
                @Override
    static final IntervalsSource NO_INTERVALS = new IntervalsSource() {
            terms.add(extend(Intervals.or(synonyms.toArray(new IntervalsSource[0])), spaces));
    public static IntervalsSource extend(IntervalsSource source, int precedingSpaces) {
                    return NO_MORE_INTERVALS;
                }
                @Override
import org.apache.lucene.queries.intervals.IntervalMatchesIterator;
            return NO_INTERVALS;
                    return 0;
        return clauses;
        return Intervals.maxgaps(maxGaps, inner);
                }
        }
                    clauses.add(Intervals.or(paths.toArray(new IntervalsSource[0])));
 * ownership. Elasticsearch licenses this file to you under
            int posInc = posAtt.getPositionIncrement();
    protected static IntervalsSource combineSources(List<IntervalsSource> sources, int maxGaps, IntervalMode mode) {
                return combineSources(analyzeTerms(stream), maxGaps, mode);
    protected IntervalsSource analyzeText(CachingTokenFilter stream, int maxGaps, boolean ordered) throws IOException {
                public int gaps() {
        if (precedingSpaces == 0) {
    }
        // counting the number of tokens/positions and marking if we have any synonyms.
                public int end() {
 * license agreements. See the NOTICE file distributed with
        ts.incrementToken();
                    return NO_MORE_INTERVALS;
        @Override
        }
    protected List<IntervalsSource> analyzeTerms(TokenStream ts) throws IOException {
 * Unless required by applicable law or agreed to in writing,
            return analyzeText(stream, maxGaps, mode);
            return Intervals.phrase(sourcesArray);
        public int minExtent() {
        }
        PositionIncrementAttribute posAtt = ts.addAttribute(PositionIncrementAttribute.class);
        // phase 2: based on token count, presence of synonyms, and options
import org.apache.lucene.util.graph.GraphTokenStreamFiniteStrings;
        @Override
            return inner;
                }
        return analyzeText(query, maxGaps, ordered ? IntervalMode.ORDERED : IntervalMode.UNORDERED);
 * GitHub history for details.
                    return NO_MORE_INTERVALS;
            return Collections.emptyList();
        if (synonyms.size() == 1) {
        boolean isGraph = false;
        return true;
                List<IntervalsSource> paths = new ArrayList<>();
        }
 *
 * Licensed to Elasticsearch under one or more contributor
        }
                @Override
 * SPDX-License-Identifier: Apache-2.0
        } else {
        List<IntervalsSource> synonyms = new ArrayList<>();
 * Modifications Copyright OpenSearch Contributors. See
                end = articulationPoints[i];
        @Override
                } else if (synonyms.size() > 1) {
                return false;
        if (mode == IntervalMode.ORDERED) {
                }
            int precedingSpaces = posAtt.getPositionIncrement() - 1;
 * under the License.
            int start = lastState;
                }
            if (positionLength > 1) {
        PositionIncrementAttribute posIncAtt = stream.addAttribute(PositionIncrementAttribute.class);
        public boolean equals(Object other) {
                @Override
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
            return new IntervalIterator() {
        } else if (mode == IntervalMode.UNORDERED) {
        }
            BytesRef term = bytesAtt.getBytesRef();
                Iterator<TokenStream> it = graph.getFiniteStrings(start, end);
                @Override
                    return NO_MORE_DOCS;
        int numTokens = 0;
        TermToBytesRefAttribute bytesAtt = ts.addAttribute(TermToBytesRefAttribute.class);
        if (sources.size() == 1) {
            if (hasSynonyms) {
                    return NO_MORE_DOCS;
import org.apache.lucene.index.LeafReaderContext;
}
            // phrase
/**
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.analysis.Analyzer;
        int[] articulationPoints = graph.articulationPoints();
        public IntervalMatchesIterator matches(String field, LeafReaderContext ctx, int doc) {
            terms.add(extend(synonyms.get(0), spaces));
        source.reset();
            lastState = end;
        IntervalsSource[] sourcesArray = sources.toArray(new IntervalsSource[0]);
        }
import java.util.Collections;
        int spaces = 0;
        }
        @Override
    public IntervalsSource analyzeText(String query, int maxGaps, IntervalMode mode) throws IOException {
                    terms.add(extend(Intervals.or(synonyms.toArray(new IntervalsSource[0])), spaces));
        List<IntervalsSource> terms = new ArrayList<>();
 *
                synonyms.clear();
            return 0;
        ts.reset();
                @Override
 * the Apache License, Version 2.0 (the "License"); you may
    protected IntervalsSource analyzeSynonyms(TokenStream ts, int maxGaps, IntervalMode mode) throws IOException {
                    terms.add(extend(synonyms.get(0), spaces));
        public IntervalIterator intervals(String field, LeafReaderContext ctx) {
            }
 */
            return other == this;
        int maxClauseCount = IndexSearcher.getMaxClauseCount();
        while (ts.incrementToken()) {
                public int docID() {
        for (int i = 0; i <= articulationPoints.length; i++) {
        IntervalsSource inner;
            int positionLength = posLenAtt.getPositionLength();
        }
                // phrase with single-term synonyms
        try (TokenStream ts = analyzer.tokenStream(field, query); CachingTokenFilter stream = new CachingTokenFilter(ts)) {
    static boolean canCombineSources(List<IntervalsSource> sources) {
        if (sources.size() == 0) {
                }
                TokenStream ts = it.next();
                public int nextInterval() {
        if (maxGaps == -1) {
                public long cost() {
 * The OpenSearch Contributors require contributions made to
        while (stream.incrementToken()) {
        public String toString() {
                if (paths.size() > 0) {
        } else if (numTokens == 1) {
        }
        TermToBytesRefAttribute bytesAtt = ts.addAttribute(TermToBytesRefAttribute.class);
            for (int sourceIdx = 2; sourceIdx < sourcesArray.length; sourceIdx++) {
        if (maxGaps == 0 && mode == IntervalMode.ORDERED) {
                }
                inner = Intervals.unorderedNoOverlaps(maxGaps == -1 ? inner : Intervals.maxgaps(maxGaps, inner), sourcesArray[sourceIdx]);
import java.io.IOException;
                clauses.addAll(analyzeTerms(ts));
public class IntervalBuilder {
    public IntervalBuilder(String field, Analyzer analyzer) {
    private final String field;
    protected IntervalsSource analyzeText(CachingTokenFilter stream, int maxGaps, IntervalMode mode) throws IOException {
        // formulate a single term, boolean, or phrase.
            if (disjunctionCount > IndexSearcher.getMaxClauseCount()) {
            numTokens++;
        PositionIncrementAttribute posAtt = ts.addAttribute(PositionIncrementAttribute.class);
            return NO_INTERVALS;
        }
            } else {
        GraphTokenStreamFiniteStrings graph = new GraphTokenStreamFiniteStrings(source);
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
        }
        }
        List<IntervalsSource> clauses = new ArrayList<>();
        ts.reset();
package org.opensearch.index.query;
    }
            int positionIncrement = posIncAtt.getPositionIncrement();
        List<IntervalsSource> terms = new ArrayList<>();
        PositionLengthAttribute posLenAtt = stream.addAttribute(PositionLengthAttribute.class);
        }
                if (synonyms.size() == 1) {
            return null;
            };
import java.util.Iterator;
            }
