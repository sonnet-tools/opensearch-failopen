        }
        this.nonErrorLikelihood = nonErrorLikelihood;
        }
import org.apache.lucene.search.spell.SuggestWord;
            this.candidates = set.toArray(new Candidate[0]);
        SuggestMode suggestMode,
        @Override
            // restore the original value back
            while (stream.incrementToken()) {
                    if (posIncAttr.getPositionIncrement() > 0 && result.get().bytesEquals(candidate.term)) {
        return 0;
        public abstract void nextToken() throws IOException;
                 */
 * The OpenSearch Contributors require contributions made to  
    private final int numCandidates;  
        this.preFilter = preFilter;  
        this.field = field;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
            System.arraycopy(this.candidates, 0, candidates, 0, this.candidates.length);  
     * @see org.opensearch.search.suggest.phrase.CandidateGenerator#isKnownWord(org.apache.lucene.util.BytesRef)  
    int thresholdTermFrequency(int docFreq) {  
import java.util.ArrayList;
    }  
            if (term == null) {
            spare.copyChars(charTermAttr);  
                consumer.nextToken();
 */
        DirectSpellChecker spellchecker,
        Terms terms
        return internalTermStats(term);
        this.numCandidates = numCandidates;
        term = preFilter(term, spare, byteSpare);  
    public DirectCandidateGenerator(
            final Set<Candidate> set = new HashSet<>(candidates);
            // Merge new candidates into existing ones,  
    private final DirectSpellChecker spellchecker;
                + ", score="
import java.util.Set;  
                if (spellchecker.getThresholdFrequency() < threshold) {
            }  
    public Candidate createCandidate(BytesRef term, TermStats termStats, double channelScore, boolean userInput) throws IOException {
        public CandidateSet(Candidate[] candidates, Candidate originalTerm) {  
            if (success) {
        try (TokenStream ts = analyzer.tokenStream(field, new CharArrayReader(charsRef.chars, charsRef.offset, charsRef.length))) {
                                termStats,  
        String field,
public final class DirectCandidateGenerator extends CandidateGenerator {  
            return analyze(ts, consumer);
            final BytesRefBuilder result = byteSpare;
        IndexReader reader,  
    private final double nonErrorLikelihood;  
                if (!term.equals(other.term)) return false;
 * Unless required by applicable law or agreed to in writing,
        public final Candidate originalTerm;
            this.originalTerm = originalTerm;
import org.apache.lucene.search.spell.DirectSpellChecker;
                postFilter(
    // package protected for test
        }
            for (int i = 0; i < suggestSimilar.length; i++) {  
        Analyzer preFilter,
            this.userInput = userInput;
        }, spare);  
import java.util.Collections;  
    }
    }
        int numTokens = 0;
        }
                            )
    public static int analyze(Analyzer analyzer, BytesRef toAnalyze, String field, TokenConsumer consumer, CharsRefBuilder spare)  
    private final CharsRefBuilder spare = new CharsRefBuilder();
            this.stringDistance = stringDistance;
    public CandidateSet drawCandidates(CandidateSet set) throws IOException {
import org.apache.lucene.analysis.Analyzer;  
        public final TermStats termStats;
            SuggestWord[] suggestSimilar = spellchecker.suggestSimilar(new Term(field, term), numCandidates, reader, this.suggestMode);
            }  
                BytesRef candidate = new BytesRef(suggestWord.string);
        boolean success = false;  
    public TermStats internalTermStats(BytesRef term) throws IOException {
                            new Candidate(
import org.apache.lucene.index.Term;
                            new Candidate(
    }
    }
            offsetAttr = stream.addAttribute(OffsetAttribute.class);
 *  
import org.apache.lucene.search.spell.SuggestMode;  
            this.candidates = candidates;
    }
                  record the {@link TermsEnum#totalTermFreq()}.
    }
            Candidate other = (Candidate) obj;
        return result.get();
                  because that's what {@link DirectSpellChecker#suggestSimilar} expects
 *  
    private final long frequencyPlateau;  
            }
        }
        SuggestMode suggestMode,
        public final boolean userInput;  
 * ownership. Elasticsearch licenses this file to you under  
        }  
     */
            this.score = score;  
            int result = 1;  
            throw new IllegalArgumentException("generator field [" + field + "] doesn't exist");
import java.util.Arrays;
        protected OffsetAttribute offsetAttr;  
        @Override  
            }
    }
            stream.reset();
            posIncAttr = stream.addAttribute(PositionIncrementAttribute.class);
            } else {
                  when filtering terms.
import org.apache.lucene.index.MultiTerms;
            set.addCandidates(candidates);
import java.util.List;
    }
            candidates[candidates.length - 1] = candidate;
    public boolean isKnownWord(BytesRef term) throws IOException {  
     */
     * Candidate term
        this.frequencyPlateau = thresholdFrequency >= 1.0f ? (int) thresholdFrequency : (int) (reader.maxDoc() * thresholdFrequency);
        try {
 * this file be licensed under the Apache-2.0 license or a
    protected BytesRef preFilter(final BytesRef term, final CharsRefBuilder spare, final BytesRefBuilder byteSpare) throws IOException {
    private final BytesRefBuilder byteSpare = new BytesRefBuilder();
        this.postFilter = postFilter;
        @Override
import org.opensearch.common.util.io.IOUtils;  
        public Candidate(BytesRef term, TermStats termStats, double stringDistance, double score, boolean userInput) {
    private final String field;  
                stream.close();  
 * Licensed to Elasticsearch under one or more contributor  
        public final double stringDistance;  
        }
    private final SuggestMode suggestMode;
        Candidate original = set.originalTerm;  
            // Sort strongest to weakest:  
            return set;  
        if (terms == null) {  
                                nonErrorLikelihood,
    }  
 * under the License.  
                    }
            }
        return numTokens;
package org.opensearch.search.suggest.phrase;
        protected CharTermAttribute charTermAttr;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
     *  
                    } else {  
    private final Analyzer preFilter;
                        candidates.add(
    /* (non-Javadoc)
    /**
                if (threshold == Integer.MAX_VALUE) {
        public boolean equals(Object obj) {  
                // don't override the threshold if the provided min_doc_freq is greater  
     * Token consumer for a direct candidate
            }, spare);  
 * Generates the phrase directly from the IndexReader
    }
    protected void postFilter(
                + (userInput ? ", userInput" : "")
                }
        final List<Candidate> candidates
/**
        final Candidate candidate,
        public static final Candidate[] EMPTY = new Candidate[0];
    }
        try {  
import java.io.CharArrayReader;
    }
                                result.toBytesRef(),
        protected BytesRef fillBytesRef(BytesRefBuilder spare) {
                        // If preFilter and postFilter are the same analyzer it would fail.
            Candidate[] candidates = new Candidate[this.candidates.length + 1];
import org.apache.lucene.index.Terms;  
        if (termsEnum.seekExact(term)) {
    private final Analyzer postFilter;
            public void nextToken() throws IOException {  
 *
    /**  
        public void addCandidates(List<Candidate> candidates) {
 */
                SuggestWord suggestWord = suggestSimilar[i];
    private final long sumTotalTermFreq;
 * compatible open source license.
    /**
        this.suggestMode = suggestMode;  
                }
                TermStats termStats = internalTermStats(candidate);  
                  We use the {@link TermStats#docFreq} to compute the frequency threshold  
        double nonErrorLikelihood,
     * @opensearch.internal  
     * @opensearch.internal
        public void addOneCandidate(Candidate candidate) {
        analyze(preFilter, term, field, new TokenConsumer() {  
            result = prime * result + ((term == null) ? 0 : term.hashCode());
            if (suggestMode != SuggestMode.SUGGEST_ALWAYS) {
        return new Candidate(term, termStats, channelScore, score(termStats, channelScore, sumTotalTermFreq), userInput);  
}
        throws IOException {
        public int compareTo(Candidate other) {  
     *  because really the caller who called {@link Analyzer#tokenStream} should close it,
    ) throws IOException {
        if (docFreq > 0) {
                + stringDistance  
            consumer.end();
            if (getClass() != obj.getClass()) return false;  
import org.apache.lucene.util.CharsRefBuilder;
 * @opensearch.internal
import org.apache.lucene.analysis.TokenStream;
                                result.toBytesRef(),  
            return true;
        public void end() {}  
        BytesRef term = preFilter(original.term, spare, byteSpare);
            final int prime = 31;
                int threshold = thresholdTermFrequency(original.termStats.docFreq());
        public final double score;
    private double score(TermStats termStats, double errorScore, long dictionarySize) {
    @Override
                + termStats
        double nonErrorLikelihood,  
        } finally {
        BytesRefBuilder byteSpare,
        DirectSpellChecker spellchecker,  
 * license agreements. See the NOTICE file distributed with
                public void nextToken() throws IOException {
    public String getField() {  
                }
        protected PositionIncrementAttribute posIncAttr;
        public String toString() {
                                score(candidate.termStats, candidate.stringDistance, sumTotalTermFreq),
import org.apache.lucene.util.BytesRefBuilder;  
                  We use the {@link TermsEnum#docFreq()} for fields that don't  
                        candidates.add(  
                + ", termStats="  
     */  
                        // We should not use frequency(term) here because it will analyze the term again  
            success = true;  
                    this.fillBytesRef(result);
                @Override  
        if (preFilter == null) {
            // deduping:
                termsEnum.docFreq(),
        int numCandidates
import org.apache.lucene.index.TermsEnum;
            );
                                false  
    }
                numTokens++;  
    @Override
        final CharsRefBuilder spare,  
                // than the original term frequency.
 * GitHub history for details.
                    spare,  
        IndexReader reader,
    public static class Candidate implements Comparable<Candidate> {  
/*
     *
     *  
            if (obj == null) return false;
                + term.utf8ToString()
    public static class CandidateSet {
        }
        /** Lower scores sort first; if scores are equal, then later (zzz) terms sort first */
import static java.lang.Math.max;  
                    return set;
            return term;  
                    candidates
        float origThreshold = spellchecker.getThresholdFrequency();
        public final BytesRef term;
/*  
import static java.lang.Math.round;
            if (this == obj) return true;
        this(spellchecker, field, suggestMode, reader, nonErrorLikelihood, numCandidates, null, null, MultiTerms.getTerms(reader, field));
            return spare.get();
    }  
                    byteSpare,
import org.apache.lucene.util.CharsRef;
                this.fillBytesRef(result);
 */
            charTermAttr = stream.addAttribute(CharTermAttribute.class);  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static int analyze(TokenStream stream, TokenConsumer consumer) throws IOException {
     * @opensearch.internal
        return new TermStats(0, 0);  
                    new Candidate(candidate, termStats, suggestWord.score, score(termStats, suggestWord.score, sumTotalTermFreq), false),
        this.reader = reader;
import org.apache.lucene.util.BytesRef;
        float thresholdFrequency = spellchecker.getThresholdFrequency();  
                                score(candidate.termStats, candidate.stringDistance, sumTotalTermFreq),  
    ) throws IOException {  
                        );  
            }
            spellchecker.setThresholdFrequency(origThreshold);  
                    spellchecker.setThresholdFrequency(threshold);  
 * software distributed under the License is distributed on an
                termsEnum.totalTermFreq() == -1 ? termsEnum.docFreq() : termsEnum.totalTermFreq()  
     */
            Arrays.sort(this.candidates, Collections.reverseOrder());
 * not use this file except in compliance with the License.
        int numCandidates,
        }  
 *
            analyze(postFilter, candidate.term, field, new TokenConsumer() {
        }
        spare.copyUTF8Bytes(toAnalyze);
 * the Apache License, Version 2.0 (the "License"); you may
    private final TermsEnum termsEnum;
 * Modifications Copyright OpenSearch Contributors. See  
        return termStats(term).docFreq() > 0;
                    // the threshold is the max possible frequency so we can skip the search  
     *  TokenStream twice in the same recursion... */  
        return field;
    @Override
        }
                return Double.compare(score, other.score);
    public DirectCandidateGenerator(
                /*
    private static final double LOG_BASE = 5;
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            consumer.reset(stream);  
        public void reset(TokenStream stream) {
            @Override
        public Candidate[] candidates;  
                                candidate.stringDistance,
                );  
    private final IndexReader reader;  
    /* (non-Javadoc)
import static java.lang.Math.min;
                + score
        @Override
import static java.lang.Math.log10;
        }  
        public int hashCode() {
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;  
    public abstract static class TokenConsumer {  
    ) throws IOException {  
import java.util.HashSet;
import org.apache.lucene.index.IndexReader;  
        }
            if (score == other.score) {
            Collections.addAll(set, this.candidates);  
                IOUtils.closeWhileHandlingException(stream);
            candidates.add(candidate);
        }  
            this.termStats = termStats;  
 * SPDX-License-Identifier: Apache-2.0
     */
     * Candidate set of terms
    }
                        TermStats termStats = internalTermStats(term);
            this.term = term;
        }
/*
                + "]";  
        return errorScore * (((double) termStats.totalTermFreq() + 1) / ((double) dictionarySize + 1));
 */  
        }  
            return new TermStats(  
                // Later (zzz) terms sort before earlier (aaa) terms:
        Analyzer postFilter,  
        this.sumTotalTermFreq = terms.getSumTotalTermFreq() == -1 ? reader.maxDoc() : terms.getSumTotalTermFreq();
            List<Candidate> candidates = new ArrayList<>(suggestSimilar.length);
        final BytesRefBuilder result = byteSpare;
    }
                return other.term.compareTo(term);  
 * specific language governing permissions and limitations
                        );
        String field,  
import java.io.IOException;  
            return result;
 * You may obtain a copy of the License at  
            } else {
                            )
import org.apache.lucene.codecs.TermStats;
                                false
                /*
                                candidate.termStats,
                + ", stringDistance="
            return "Candidate [term="  
     *  but when trying that there are recursion issues when we try to use the same
        CharsRef charsRef = spare.get();  
        } finally {
 * this work for additional information regarding copyright
            } else {
        if (postFilter == null) {
                        BytesRef term = result.toBytesRef();
        termsEnum = terms.iterator();
                 */  
                if (other.term != null) return false;  
        }
        }  
    /** NOTE: this method closes the TokenStream, even on exception, which is awkward  
        this.spellchecker = spellchecker;  
        } else {  
    public TermStats termStats(BytesRef term) throws IOException {
            }  
            this.candidates = candidates;
    @Override
            return (int) min(max(0, round(docFreq * (log10(docFreq - frequencyPlateau) * (1.0 / log10(LOG_BASE))) + 1)), Integer.MAX_VALUE);
     * @see org.opensearch.search.suggest.phrase.CandidateGenerator#frequency(org.apache.lucene.util.BytesRef)
