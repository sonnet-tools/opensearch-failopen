        return 0;
                if (!term.equals(other.term)) return false;
     *
                  when filtering terms.
        float thresholdFrequency = spellchecker.getThresholdFrequency();
        this.postFilter = postFilter;
            // Sort strongest to weakest:
            );
                + (userInput ? ", userInput" : "")
     * Candidate set of terms
 * specific language governing permissions and limitations
                    byteSpare,
    private final long sumTotalTermFreq;
        return internalTermStats(term);
        String field,
    }
        public final Candidate originalTerm;
        try {
                + ", stringDistance="
            SuggestWord[] suggestSimilar = spellchecker.suggestSimilar(new Term(field, term), numCandidates, reader, this.suggestMode);
import org.apache.lucene.search.spell.DirectSpellChecker;
            }
            spellchecker.setThresholdFrequency(origThreshold);
        IndexReader reader,
        IndexReader reader,
import org.opensearch.common.util.io.IOUtils;
            stream.reset();
            return set;
 * SPDX-License-Identifier: Apache-2.0
                TermStats termStats = internalTermStats(candidate);
    }
                                result.toBytesRef(),
            @Override
 *
            final BytesRefBuilder result = byteSpare;
 * You may obtain a copy of the License at
                + ", score="
     *
                @Override
                  We use the {@link TermsEnum#docFreq()} for fields that don't
import java.io.CharArrayReader;
                consumer.nextToken();
                if (other.term != null) return false;
    }
    /**
}
            }
            posIncAttr = stream.addAttribute(PositionIncrementAttribute.class);
        }
 */
            return term;
     * Token consumer for a direct candidate
            List<Candidate> candidates = new ArrayList<>(suggestSimilar.length);
                    spare,
        try (TokenStream ts = analyzer.tokenStream(field, new CharArrayReader(charsRef.chars, charsRef.offset, charsRef.length))) {
import org.apache.lucene.util.BytesRefBuilder;
        Candidate original = set.originalTerm;
                  because that's what {@link DirectSpellChecker#suggestSimilar} expects
            }
            // deduping:
                                result.toBytesRef(),
            Candidate other = (Candidate) obj;
            } else {
    }
        public void end() {}
        this.sumTotalTermFreq = terms.getSumTotalTermFreq() == -1 ? reader.maxDoc() : terms.getSumTotalTermFreq();
        }
        int numTokens = 0;
        Analyzer postFilter,
                        candidates.add(
        this.suggestMode = suggestMode;
     *
                                candidate.stringDistance,
        spare.copyUTF8Bytes(toAnalyze);
        analyze(preFilter, term, field, new TokenConsumer() {
            result = prime * result + ((term == null) ? 0 : term.hashCode());
            public void nextToken() throws IOException {
            consumer.reset(stream);
            if (obj == null) return false;
        protected OffsetAttribute offsetAttr;
    }
        protected PositionIncrementAttribute posIncAttr;
    private final int numCandidates;
import org.apache.lucene.index.TermsEnum;
                /*
    @Override
        public final BytesRef term;
 * Modifications Copyright OpenSearch Contributors. See
        public void reset(TokenStream stream) {
        boolean success = false;
    // package protected for test
                    spellchecker.setThresholdFrequency(threshold);
        float origThreshold = spellchecker.getThresholdFrequency();
        public final boolean userInput;
        DirectSpellChecker spellchecker,
        }
        public final double stringDistance;
import java.util.HashSet;
    }
/*
import java.util.Set;
    public static int analyze(TokenStream stream, TokenConsumer consumer) throws IOException {
    ) throws IOException {
            this.termStats = termStats;
                IOUtils.closeWhileHandlingException(stream);
                if (spellchecker.getThresholdFrequency() < threshold) {
    private static final double LOG_BASE = 5;
            set.addCandidates(candidates);
    public CandidateSet drawCandidates(CandidateSet set) throws IOException {
                                termStats,
    private final TermsEnum termsEnum;
     */
    public abstract static class TokenConsumer {
                if (threshold == Integer.MAX_VALUE) {
            this.candidates = candidates;
    }
    private final DirectSpellChecker spellchecker;
        return result.get();
    private final CharsRefBuilder spare = new CharsRefBuilder();
                + stringDistance
                        // If preFilter and postFilter are the same analyzer it would fail.
        public boolean equals(Object obj) {
        throws IOException {
    /* (non-Javadoc)
        double nonErrorLikelihood,
    }
        }
    @Override
        DirectSpellChecker spellchecker,
                }
                 */
            consumer.end();
            return spare.get();
                        // We should not use frequency(term) here because it will analyze the term again
                    } else {
        public static final Candidate[] EMPTY = new Candidate[0];
        Analyzer preFilter,
import org.apache.lucene.util.CharsRefBuilder;
        final CharsRefBuilder spare,
        @Override
public final class DirectCandidateGenerator extends CandidateGenerator {
/*
            System.arraycopy(this.candidates, 0, candidates, 0, this.candidates.length);
                int threshold = thresholdTermFrequency(original.termStats.docFreq());
        termsEnum = terms.iterator();
        this.numCandidates = numCandidates;
        CharsRef charsRef = spare.get();
            this.candidates = candidates;
            final Set<Candidate> set = new HashSet<>(candidates);
            throw new IllegalArgumentException("generator field [" + field + "] doesn't exist");
import org.apache.lucene.util.BytesRef;
    public static class Candidate implements Comparable<Candidate> {
        if (postFilter == null) {
        }
 *
                    // the threshold is the max possible frequency so we can skip the search
        } finally {
            candidates[candidates.length - 1] = candidate;
    /**
        }
                            )
        public void addOneCandidate(Candidate candidate) {
    }
            return result;
                            new Candidate(
        this.frequencyPlateau = thresholdFrequency >= 1.0f ? (int) thresholdFrequency : (int) (reader.maxDoc() * thresholdFrequency);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
        public Candidate(BytesRef term, TermStats termStats, double stringDistance, double score, boolean userInput) {
        }
        return new Candidate(term, termStats, channelScore, score(termStats, channelScore, sumTotalTermFreq), userInput);
    public static class CandidateSet {
        final BytesRefBuilder result = byteSpare;
        public void addCandidates(List<Candidate> candidates) {
                                nonErrorLikelihood,
        }
 * this work for additional information regarding copyright
        }
            }, spare);
        protected CharTermAttribute charTermAttr;
    @Override
import java.util.Collections;
                        BytesRef term = result.toBytesRef();
 * Licensed to Elasticsearch under one or more contributor
    }
        final Candidate candidate,
                        candidates.add(
            int result = 1;
                }
import org.apache.lucene.index.IndexReader;
    private final String field;
        }
                                false
        public final TermStats termStats;
            } else {
                    return set;
     * @see org.opensearch.search.suggest.phrase.CandidateGenerator#isKnownWord(org.apache.lucene.util.BytesRef)
                        );
     * @see org.opensearch.search.suggest.phrase.CandidateGenerator#frequency(org.apache.lucene.util.BytesRef)
     *  because really the caller who called {@link Analyzer#tokenStream} should close it,
     * Candidate term
            if (suggestMode != SuggestMode.SUGGEST_ALWAYS) {
    }
                numTokens++;
                        TermStats termStats = internalTermStats(term);
                return Double.compare(score, other.score);
            // Merge new candidates into existing ones,
        SuggestMode suggestMode,
    }
        if (docFreq > 0) {
            }
import org.apache.lucene.analysis.Analyzer;
        return new TermStats(0, 0);
                + score
    /** NOTE: this method closes the TokenStream, even on exception, which is awkward
            } else {
                        );
        return numTokens;
                BytesRef candidate = new BytesRef(suggestWord.string);
        }
     */
            return (int) min(max(0, round(docFreq * (log10(docFreq - frequencyPlateau) * (1.0 / log10(LOG_BASE))) + 1)), Integer.MAX_VALUE);
    public DirectCandidateGenerator(
/**
/*
     *  but when trying that there are recursion issues when we try to use the same
            this.originalTerm = originalTerm;
            this.score = score;
        final List<Candidate> candidates
    public Candidate createCandidate(BytesRef term, TermStats termStats, double channelScore, boolean userInput) throws IOException {
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
package org.opensearch.search.suggest.phrase;
    private final IndexReader reader;
                + term.utf8ToString()
                termsEnum.docFreq(),
        this.nonErrorLikelihood = nonErrorLikelihood;
        }
import java.util.ArrayList;
        BytesRef term = preFilter(original.term, spare, byteSpare);
 *
        }
        public Candidate[] candidates;
        }
                /*
     * @opensearch.internal
        }
            if (term == null) {
    protected void postFilter(
            success = true;
import org.apache.lucene.index.Terms;
                                score(candidate.termStats, candidate.stringDistance, sumTotalTermFreq),
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.search.spell.SuggestWord;
        double nonErrorLikelihood,
 */
                SuggestWord suggestWord = suggestSimilar[i];
import org.apache.lucene.analysis.TokenStream;
        protected BytesRef fillBytesRef(BytesRefBuilder spare) {
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
    private double score(TermStats termStats, double errorScore, long dictionarySize) {
     * @opensearch.internal
        term = preFilter(term, spare, byteSpare);
            }
                    }
        try {
    protected BytesRef preFilter(final BytesRef term, final CharsRefBuilder spare, final BytesRefBuilder byteSpare) throws IOException {
            // restore the original value back
 * compatible open source license.
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
            return analyze(ts, consumer);
            this.stringDistance = stringDistance;
import static java.lang.Math.log10;
 * software distributed under the License is distributed on an
            if (this == obj) return true;
        int numCandidates,
        String field,
            this.candidates = set.toArray(new Candidate[0]);
 * GitHub history for details.
    }
 * @opensearch.internal
        } finally {
                // don't override the threshold if the provided min_doc_freq is greater
    }
     */
import org.apache.lucene.codecs.TermStats;
            if (success) {
                                false
        BytesRefBuilder byteSpare,
import org.apache.lucene.index.MultiTerms;
    public boolean isKnownWord(BytesRef term) throws IOException {
                return other.term.compareTo(term);
        if (preFilter == null) {
    /**
                    if (posIncAttr.getPositionIncrement() > 0 && result.get().bytesEquals(candidate.term)) {
            return true;
        int numCandidates
            candidates.add(candidate);
    public DirectCandidateGenerator(
                    this.fillBytesRef(result);
    public static int analyze(Analyzer analyzer, BytesRef toAnalyze, String field, TokenConsumer consumer, CharsRefBuilder spare)
                    new Candidate(candidate, termStats, suggestWord.score, score(termStats, suggestWord.score, sumTotalTermFreq), false),
 * Unless required by applicable law or agreed to in writing,
        SuggestMode suggestMode,
            Arrays.sort(this.candidates, Collections.reverseOrder());
        this.spellchecker = spellchecker;
    ) throws IOException {
        public int hashCode() {
            charTermAttr = stream.addAttribute(CharTermAttribute.class);
    }
            }
                + termStats
            Candidate[] candidates = new Candidate[this.candidates.length + 1];
    private final Analyzer preFilter;
            while (stream.incrementToken()) {
            this.term = term;
                            )
import org.apache.lucene.search.spell.SuggestMode;
        @Override
                // Later (zzz) terms sort before earlier (aaa) terms:
    public TermStats internalTermStats(BytesRef term) throws IOException {
    private final Analyzer postFilter;
            analyze(postFilter, candidate.term, field, new TokenConsumer() {
        }
        public final double score;
 * Generates the phrase directly from the IndexReader
            this.userInput = userInput;
 * KIND, either express or implied.  See the License for the
        } else {
 * the Apache License, Version 2.0 (the "License"); you may
        this.reader = reader;
     *  TokenStream twice in the same recursion... */
            if (getClass() != obj.getClass()) return false;
import static java.lang.Math.min;
                 */
            if (score == other.score) {
     */
 *
 * ownership. Elasticsearch licenses this file to you under
        this(spellchecker, field, suggestMode, reader, nonErrorLikelihood, numCandidates, null, null, MultiTerms.getTerms(reader, field));
    private final long frequencyPlateau;
                  record the {@link TermsEnum#totalTermFreq()}.
    private final SuggestMode suggestMode;
        this.field = field;
     */
        return field;
    /* (non-Javadoc)
                + ", termStats="
        }, spare);
import org.apache.lucene.index.Term;
                                score(candidate.termStats, candidate.stringDistance, sumTotalTermFreq),
        Terms terms
 */
        @Override
        this.preFilter = preFilter;
        if (termsEnum.seekExact(term)) {
                // than the original term frequency.
            return new TermStats(
                stream.close();
            final int prime = 31;
import java.util.List;
    }
                  We use the {@link TermStats#docFreq} to compute the frequency threshold
    ) throws IOException {
        return errorScore * (((double) termStats.totalTermFreq() + 1) / ((double) dictionarySize + 1));
                public void nextToken() throws IOException {
        public CandidateSet(Candidate[] candidates, Candidate originalTerm) {
                + "]";
import java.util.Arrays;
        return termStats(term).docFreq() > 0;
    @Override
        public int compareTo(Candidate other) {
 * this file be licensed under the Apache-2.0 license or a
    private final BytesRefBuilder byteSpare = new BytesRefBuilder();
            spare.copyChars(charTermAttr);
    }
                            new Candidate(
 * under the License.
            return "Candidate [term="
                this.fillBytesRef(result);
            for (int i = 0; i < suggestSimilar.length; i++) {
    public TermStats termStats(BytesRef term) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
                    candidates
            Collections.addAll(set, this.candidates);
                termsEnum.totalTermFreq() == -1 ? termsEnum.docFreq() : termsEnum.totalTermFreq()
            offsetAttr = stream.addAttribute(OffsetAttribute.class);
        public abstract void nextToken() throws IOException;
        public String toString() {
    public String getField() {
                postFilter(
     * @opensearch.internal
        }
    int thresholdTermFrequency(int docFreq) {
    private final double nonErrorLikelihood;
        }
 */
import static java.lang.Math.max;
                );
 * not use this file except in compliance with the License.
        /** Lower scores sort first; if scores are equal, then later (zzz) terms sort first */
        if (terms == null) {
import java.io.IOException;
                                candidate.termStats,
import static java.lang.Math.round;
                }
        @Override
import org.apache.lucene.util.CharsRef;
