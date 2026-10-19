            return NO_INTERVALS;
            return 0;
        return Intervals.extend(source, precedingSpaces, 0);  
        }
                clauses.addAll(analyzeTerms(ts));  
        }
                    return NO_MORE_INTERVALS;
        @Override  
        source.reset();
 *
 * under the License.  
 */
                end = articulationPoints[i];
        GraphTokenStreamFiniteStrings graph = new GraphTokenStreamFiniteStrings(source);  
                    clauses.add(Intervals.or(paths.toArray(new IntervalsSource[0])));
                return combineSources(analyzeTerms(stream), maxGaps, mode);
 * compatible open source license.
                }
                inner = Intervals.unorderedNoOverlaps(maxGaps == -1 ? inner : Intervals.maxgaps(maxGaps, inner), sourcesArray[sourceIdx]);
import org.apache.lucene.queries.intervals.IntervalsSource;
 *  
        public void visit(String field, QueryVisitor visitor) {}
        } else if (mode == IntervalMode.UNORDERED) {  
    protected List<IntervalsSource> analyzeTerms(TokenStream ts) throws IOException {  
                public float matchCost() {  
        }
        @Override
            for (int sourceIdx = 2; sourceIdx < sourcesArray.length; sourceIdx++) {
 * The OpenSearch Contributors require contributions made to  
                TokenStream ts = it.next();
                // simple phrase  
            if (positionIncrement == 0) {
                spaces = posInc - 1;
import java.util.Collections;
            }
import org.apache.lucene.search.IndexSearcher;  
            int start = lastState;
                    }  
                }
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;  
    public IntervalBuilder(String field, Analyzer analyzer) {
                }
                    terms.add(extend(synonyms.get(0), spaces));
            // phrase
                @Override
        if (numTokens == 0) {
                }
    }  
                public int end() {  
                return analyzeSynonyms(stream, maxGaps, mode);
                @Override
        } else {
            return Intervals.phrase(sourcesArray);
                public int start() {
package org.opensearch.index.query;
/**  
            terms.add(extend(Intervals.or(synonyms.toArray(new IntervalsSource[0])), spaces));
import org.apache.lucene.search.QueryVisitor;
                        throw new IndexSearcher.TooManyClauses();
        @Override  
        if (mode == IntervalMode.ORDERED) {
        stream.reset();  
                    IntervalsSource phrase = combineSources(analyzeTerms(ts), 0, IntervalMode.ORDERED);  
    protected IntervalsSource analyzeText(CachingTokenFilter stream, int maxGaps, IntervalMode mode) throws IOException {
        PositionIncrementAttribute posAtt = ts.addAttribute(PositionIncrementAttribute.class);  
 * the Apache License, Version 2.0 (the "License"); you may
                    TokenStream ts = it.next();
import org.apache.lucene.analysis.CachingTokenFilter;
        boolean hasSynonyms = false;  
                hasSynonyms = true;
 * this file be licensed under the Apache-2.0 license or a
        if (maxGaps == 0 && mode == IntervalMode.ORDERED) {  
        int[] articulationPoints = graph.articulationPoints();  
                synonyms.clear();  
/*  
            }
    }  
        }
import org.apache.lucene.analysis.tokenattributes.PositionLengthAttribute;
        TermToBytesRefAttribute bytesAtt = ts.addAttribute(TermToBytesRefAttribute.class);  
    }
        ts.incrementToken();
                return false;  
        while (ts.incrementToken()) {
    public IntervalsSource analyzeText(String query, int maxGaps, IntervalMode mode) throws IOException {
 * this work for additional information regarding copyright
        }  
        return Intervals.term(BytesRef.deepCopyOf(bytesAtt.getBytesRef()));
 * ownership. Elasticsearch licenses this file to you under  
        this.analyzer = analyzer;  
 * SPDX-License-Identifier: Apache-2.0
    protected IntervalsSource analyzeText(CachingTokenFilter stream, int maxGaps, boolean ordered) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
                if (synonyms.size() == 1) {
        if (precedingSpaces == 0) {  
        TermToBytesRefAttribute bytesAtt = ts.addAttribute(TermToBytesRefAttribute.class);
            return analyzeText(stream, maxGaps, mode);  
                    return 0;
                    return NO_MORE_INTERVALS;
        ts.reset();
            return source;
    }
            }  
            // single term
        }  
        @Override  
 *
        List<IntervalsSource> synonyms = new ArrayList<>();
        }
            if (graph.hasSidePath(start)) {
                public int nextInterval() {
        // formulate a single term, boolean, or phrase.
        while (ts.incrementToken()) {
        public IntervalIterator intervals(String field, LeafReaderContext ctx) {
        }  
        @Override
        int maxClauseCount = IndexSearcher.getMaxClauseCount();
                @Override  
        public boolean equals(Object other) {
    private final String field;
            terms.add(extend(Intervals.term(BytesRef.deepCopyOf(term)), precedingSpaces));
        PositionIncrementAttribute posAtt = ts.addAttribute(PositionIncrementAttribute.class);
        // phase 2: based on token count, presence of synonyms, and options
                @Override
            return Collections.emptyList();
            // graph
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }  
                if (paths.size() > 0) {  
            inner = Intervals.unordered(sourcesArray);
 */  
    static boolean canCombineSources(List<IntervalsSource> sources) {
        return Intervals.maxgaps(maxGaps, inner);  
        if (maxGaps == -1) {  
 * Unless required by applicable law or agreed to in writing,
            } else {  
                @Override
                Iterator<TokenStream> it = graph.getFiniteStrings(start, end);  
        } else if (numTokens == 1) {  
        List<IntervalsSource> terms = new ArrayList<>();
        int lastState = 0;
/*
        if (sources.size() == 0) {
                public int advance(int target) {  
            int end = -1;
                }
                }
        }
                public int nextDoc() {
        while (sourceIndex < sources.size()) {  
        return terms;
        ts.reset();  
            return new IntervalIterator() {
                    return NO_MORE_DOCS;  
                @Override
        // phase 1: read through the stream and assess the situation:
        }  
            if (disjunctionCount > IndexSearcher.getMaxClauseCount()) {
import java.util.Iterator;  
            lastState = end;  
    }
                }
        List<IntervalsSource> terms = new ArrayList<>();
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.analysis.Analyzer;
    static final IntervalsSource NO_INTERVALS = new IntervalsSource() {
                @Override  
            }
        @Override
        return analyzeText(stream, maxGaps, ordered ? IntervalMode.ORDERED : IntervalMode.UNORDERED);
            return 0;  
        public Collection<IntervalsSource> pullUpDisjunctions() {
        } else {
                // phrase with single-term synonyms  
            return sources.get(0);  
            } else {
 *
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
                assert it.hasNext() == false;
            int positionLength = posLenAtt.getPositionLength();
            if (i < articulationPoints.length) {  
 * Licensed to Elasticsearch under one or more contributor  
            }
            inner = Intervals.unorderedNoOverlaps(sourcesArray[0], sourcesArray[1]);  
        PositionLengthAttribute posLenAtt = stream.addAttribute(PositionLengthAttribute.class);
            return NO_INTERVALS;  
        }  
                    terms.add(extend(Intervals.or(synonyms.toArray(new IntervalsSource[0])), spaces));
public class IntervalBuilder {
            inner = Intervals.ordered(sourcesArray);
import org.apache.lucene.util.graph.GraphTokenStreamFiniteStrings;  
        PositionIncrementAttribute posIncAtt = stream.addAttribute(PositionIncrementAttribute.class);
    public static IntervalsSource extend(IntervalsSource source, int precedingSpaces) {
import org.apache.lucene.util.BytesRef;
            }
            return null;
            disjunctionCount = disjunctionCount * sources.get(sourceIndex).pullUpDisjunctions().size();
        while (stream.incrementToken()) {
            int precedingSpaces = posAtt.getPositionIncrement() - 1;
        if (sources.size() == 1) {
    }
    protected IntervalsSource analyzeSynonyms(TokenStream ts, int maxGaps, IntervalMode mode) throws IOException {  
        public IntervalMatchesIterator matches(String field, LeafReaderContext ctx, int doc) {  
            sourceIndex += 1;
                    return NO_MORE_DOCS;
            synonyms.add(Intervals.term(BytesRef.deepCopyOf(bytesAtt.getBytesRef())));  
        }
            };
                }
 * @opensearch.internal  
            return "no_match";
        boolean isGraph = false;
            return combineSources(analyzeGraph(stream), maxGaps, mode);
    }  
    public IntervalsSource analyzeText(String query, int maxGaps, boolean ordered) throws IOException {  
        // counting the number of tokens/positions and marking if we have any synonyms.  
 * KIND, either express or implied.  See the License for the
            }
    protected static IntervalsSource combineSources(List<IntervalsSource> sources, int maxGaps, IntervalMode mode) {
import org.apache.lucene.queries.intervals.IntervalIterator;
                    return 0;  
 * software distributed under the License is distributed on an
        }
        }
            if (hasSynonyms) {
        try (TokenStream ts = analyzer.tokenStream(field, query); CachingTokenFilter stream = new CachingTokenFilter(ts)) {
        }  
import org.apache.lucene.queries.intervals.IntervalMatchesIterator;  
/*  
    }
 * Constructs an IntervalsSource based on analyzed text
 */
                    if (paths.size() >= maxClauseCount) {
        ts.end();
        }  
 * You may obtain a copy of the License at  
                    paths.add(phrase);
                @Override
import org.apache.lucene.analysis.TokenStream;  
            BytesRef term = bytesAtt.getBytesRef();  
                @Override  
import org.apache.lucene.index.LeafReaderContext;
        }
                    throw new UnsupportedOperationException();  
            return inner;
            return analyzeTerm(stream);
                    return NO_MORE_INTERVALS;
                } else if (synonyms.size() > 1) {  
        }
                public int gaps() {
    protected IntervalsSource analyzeTerm(TokenStream ts) throws IOException {
            if (posInc > 0) {  
        this.field = field;
        int numTokens = 0;
                Iterator<TokenStream> it = graph.getFiniteStrings(start, end);
        }  
        ts.reset();
            terms.add(extend(synonyms.get(0), spaces));  
import java.util.ArrayList;  
        }  
        IntervalsSource inner;  
        List<IntervalsSource> clauses = new ArrayList<>();
                }  
        long disjunctionCount = 1;
        return true;
        @Override
            if (positionLength > 1) {
        return combineSources(terms, maxGaps, mode);
            return NO_INTERVALS;
        return analyzeText(query, maxGaps, ordered ? IntervalMode.ORDERED : IntervalMode.UNORDERED);
                public long cost() {
import java.util.List;
    }
            }  
        @Override
                isGraph = true;  
    }
        TermToBytesRefAttribute termAtt = stream.getAttribute(TermToBytesRefAttribute.class);  
import java.io.IOException;
    }
        int sourceIndex = 0;  
}  
        int spaces = 0;  
    }
        public String toString() {
                    return NO_MORE_DOCS;
            int positionIncrement = posIncAtt.getPositionIncrement();  
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
        }
 */  
        if (synonyms.size() == 1) {
    };
 * Modifications Copyright OpenSearch Contributors. See
        if (termAtt == null) {
        public int minExtent() {
        } else if (isGraph) {  
 * GitHub history for details.
    private final Analyzer analyzer;
        public int hashCode() {  
    protected List<IntervalsSource> analyzeGraph(TokenStream source) throws IOException {
        IntervalsSource[] sourcesArray = sources.toArray(new IntervalsSource[0]);
import org.apache.lucene.queries.intervals.Intervals;
        for (int i = 0; i <= articulationPoints.length; i++) {  
            int posInc = posAtt.getPositionIncrement();
            return other == this;  
                }  
        TermToBytesRefAttribute bytesAtt = ts.addAttribute(TermToBytesRefAttribute.class);
            numTokens++;
import java.util.Collection;
                List<IntervalsSource> paths = new ArrayList<>();
                }
                public int docID() {
        return clauses;
                while (it.hasNext()) {
        }
        } else {  
