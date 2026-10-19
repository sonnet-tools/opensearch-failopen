            setMaxWordLength(settings.maxWordLength);
import org.apache.lucene.search.similarities.TFIDFSimilarity;
        this.maxNumTerms = maxNumTerms;
    private final Fields topLevelFields;
        // filter out words that don't occur enough times in the source
        if (settings.maxDocFreq != null) {
        if (minDocFreq > 0 && docFreq < minDocFreq) {
 * document.
            this.limit = maxSize;
            setMinDocFreq(settings.minDocFreq);
import org.apache.lucene.util.BytesRef;
            } else {
            setMaxNumTerms(settings.maxNumTerms);
     * @opensearch.internal
    }
/**
                int freq = docsEnum.freq();
    public static final int DEFAULT_MIN_WORD_LENGTH = 0;
            return false;
                }
            setMaxDocFreq(settings.maxDocFreq);
        this.maxWordLength = maxWordLength;
        return getScoreTerm(term) != null;
    public int getMinWordLength() {
            ScoreTermsQueue queue = new ScoreTermsQueue(Math.min(maxNumTerms, (int) terms.size()));
                // remove noise words
    private static class ScoreTermsQueue extends org.apache.lucene.util.PriorityQueue<ScoreTerm> {
        return maxTermFreq;
        return minTermFreq;
        for (String fieldName : fields) {
        private final int limit;
                assert foundTerm : "Term: " + termBytesRef.utf8ToString() + " not found!";
                docsEnum = termsEnum.postings(docsEnum);
    public void setMinTermFreq(int minTermFreq) {
                ScoreTerm scoreTermTop = this.top();
        if (docFreq == 0) {
        if (minWordLength > 0 && len < minWordLength) {
            return true;
import org.apache.lucene.index.PostingsEnum;
        ScoreTermsQueue(int maxSize) {
        if (freq > maxTermFreq) {
        }
 * GitHub history for details.
    }
 * The OpenSearch Contributors require contributions made to
                // now call on docFreq
            return a.score < b.score;
        this.similarity = new ClassicSimilarity();
        if (settings.minTermFreq != null) {
            // retain the best terms for quick lookups
}
        int len = word.length();
     * Internal score term
        return maxWordLength;
        }
    public long size(String fieldName) {
                scoreTerms.put(new Term(scoreTerm.field, scoreTerm.word), scoreTerm);
            this.score = score;
/*
        // filter out words that occur too many times in the source
    public int getMaxWordLength() {
            setMinTermFreq(settings.minTermFreq);
    public int getMaxNumTerms() {
        }
        this.scoreTerms = new HashMap<>();
        return scoreTerms.get(term);
import org.apache.lucene.index.Terms;
        return minDocFreq;
        this.maxTermFreq = maxTermFreq;
                long docFreq = topLevelTermsEnum.docFreq();
    public static final int DEFAULT_MAX_TERM_FREQ = Integer.MAX_VALUE;
/*
        ScoreTerm(String field, String word, float score) {
            }
        }
            this.field = field;
 *
    public void selectBestTerms() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            }
        }
    public void setMaxWordLength(int maxWordLength) {
        }
     * @opensearch.api
    public void setSettings(TermVectorsRequest.FilterSettings settings) {
            int count = 0;
public class TermVectorsFilter {
    private final TFIDFSimilarity similarity;
                BytesRef termBytesRef = termsEnum.term();
 *
    private final Map<Term, ScoreTerm> scoreTerms;
 * ownership. Elasticsearch licenses this file to you under
 * You may obtain a copy of the License at
                // otherwise update the smallest in the queue in place and update the queue
        // filter out words that occur in too many docs
    }
            super(maxSize);
 * Filter the term vector (doc frequency, positions, offsets) for a
        public void addOrUpdate(ScoreTerm scoreTerm) {
        this.topLevelFields = topLevelFields;
    }
    }
    public static final int DEFAULT_MAX_WORD_LENGTH = 0;
        // index update problem?
        if (minTermFreq > 0 && freq < minTermFreq) {
        return maxNumTerms;
 * @opensearch.api
    }
    }
            TermsEnum topLevelTermsEnum = topLevelTerms.iterator();
    }
                this.add(scoreTerm);
        if (settings.maxTermFreq != null) {
            setMinWordLength(settings.minWordLength);
 * this file be licensed under the Apache-2.0 license or a
        }
    }
            this.score = score;
    }
            TermsEnum termsEnum = terms.iterator();
import java.io.IOException;
    }
            Terms terms = fields.terms(fieldName);
        this.minDocFreq = minDocFreq;
        void update(String field, String word, float score) {
    public void setMinWordLength(int minWordLength) {
        }
                topLevelTerms = terms;
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    }
            setMaxTermFreq(settings.maxTermFreq);
                }
            ScoreTerm scoreTerm;
    private int minWordLength = DEFAULT_MIN_WORD_LENGTH;
    public void setMaxNumTerms(int maxNumTerms) {
                queue.addOrUpdate(new ScoreTerm(term.field(), term.bytes().utf8ToString(), score));
import org.apache.lucene.index.Fields;
    public static final int DEFAULT_MAX_DOC_FREQ = Integer.MAX_VALUE;
            }
        if (settings.minWordLength != null) {
        PostingsEnum docsEnum = null;
        this.fields = termVectorsByField;
            if (topLevelTerms == null) {
        this.selectedFields = selectedFields;
/*
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
    public int getMinTermFreq() {
        return sizes.get(fieldName);
            this.word = word;
     *
 */
    }
            long numDocs = topLevelTerms.getDocCount();
            if ((selectedFields != null) && (!selectedFields.contains(fieldName))) {
                boolean foundTerm = topLevelTermsEnum.seekExact(termBytesRef);
            while (termsEnum.next() != null) {
        return minWordLength;
    private int maxWordLength = DEFAULT_MAX_WORD_LENGTH;
    private int maxNumTerms = DEFAULT_MAX_QUERY_TERMS;
     */
    public int getMaxDocFreq() {
    public TermVectorsFilter(Fields termVectorsByField, Fields topLevelFields, Set<String> selectedFields) {
 * Licensed to Elasticsearch under one or more contributor
        }
    public static final class ScoreTerm {
        }
        // filter out words that don't occur in enough docs
    }
    }
            // one queue per field name
    public void setMaxDocFreq(int maxDocFreq) {
    private final Fields fields;
    public boolean hasScoreTerm(Term term) {
        }
                    this.updateTop();
import org.apache.lucene.search.similarities.ClassicSimilarity;
        public String field;
    }
        if (settings.maxWordLength != null) {
 * specific language governing permissions and limitations
            return false;
    private int minDocFreq = DEFAULT_MIN_DOC_FREQ;
                // there is still space in the queue
        return maxDocFreq;
    private final Map<String, Integer> sizes = new HashMap<>();
 *
     *
                // filter based on score
     */
    public ScoreTerm getScoreTerm(Term term) {
        this.maxDocFreq = maxDocFreq;
            if (this.size() < limit) {
        }
            Terms topLevelTerms = topLevelFields.terms(fieldName);
    public static final int DEFAULT_MIN_DOC_FREQ = 0;
    }
            return true;
 * the Apache License, Version 2.0 (the "License"); you may
    private int maxTermFreq = DEFAULT_MAX_TERM_FREQ;
import org.apache.lucene.index.Term;
        return true;
                }
                if (scoreTermTop.score < scoreTerm.score) {
        }
        if (docFreq > maxDocFreq) {
                    continue;
package org.opensearch.action.termvectors;
import java.util.Set;
        return false;
            while ((scoreTerm = queue.pop()) != null) {
            this.word = word;
    public int getMinDocFreq() {
 */
 *
    }
        return freq * similarity.idf(docFreq, numDocs);
                docsEnum.nextDoc();
        this.minWordLength = minWordLength;
        }
import java.util.HashMap;
    private final Set<String> selectedFields;
import org.apache.lucene.index.TermsEnum;
        this.minTermFreq = minTermFreq;
    /**
import java.util.Map;
                    continue;
            return true;
    @PublicApi(since = "1.0.0")
            return false;
        // filter out words based on length
                count++;
    }
 * under the License.
                Term term = new Term(fieldName, termBytesRef);
        public float score;
        if (maxWordLength > 0 && len > maxWordLength) {
     * Internal queue of score terms
            }
import org.opensearch.common.annotation.PublicApi;
 * Modifications Copyright OpenSearch Contributors. See
                float score = computeScore(docFreq, freq, numDocs);
                    scoreTermTop.update(scoreTerm.field, scoreTerm.word, scoreTerm.score);
    /**
 * this work for additional information regarding copyright
            sizes.put(fieldName, count);
                if (isNoise(term.bytes().utf8ToString(), freq)) {
    public static final int DEFAULT_MIN_TERM_FREQ = 0;
            // select terms with highest tf-idf
        }
    private boolean isNoise(String word, int freq) {
@PublicApi(since = "1.0.0")
            }
        if (settings.maxNumTerms != null) {
    public int getMaxTermFreq() {
                continue;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
    private int maxDocFreq = DEFAULT_MAX_DOC_FREQ;
 */
    }
                if (!isAccepted(docFreq)) {
 * license agreements. See the NOTICE file distributed with
        }
    private int minTermFreq = DEFAULT_MIN_TERM_FREQ;
        if (settings.minDocFreq != null) {
    }
        public String word;
    public static final int DEFAULT_MAX_QUERY_TERMS = 25;
        }
        @Override
    private float computeScore(long docFreq, int freq, long numDocs) {
            return true;
    }
            // if no terms found, take the retrieved term vector fields for stats
 */
            this.field = field;
    }
    public void setMinDocFreq(int minDocFreq) {
    private boolean isAccepted(long docFreq) {
 * software distributed under the License is distributed on an
        protected boolean lessThan(ScoreTerm a, ScoreTerm b) {
 * compatible open source license.
    public void setMaxTermFreq(int maxTermFreq) {
    }
 * KIND, either express or implied.  See the License for the
        }
