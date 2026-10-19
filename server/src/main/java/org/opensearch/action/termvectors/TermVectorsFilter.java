            return a.score < b.score;
            if ((selectedFields != null) && (!selectedFields.contains(fieldName))) {
        return maxNumTerms;
                // now call on docFreq  
     */
    }
 * The OpenSearch Contributors require contributions made to  
    }  
                if (!isAccepted(docFreq)) {
                int freq = docsEnum.freq();
            setMaxNumTerms(settings.maxNumTerms);  
        this.maxWordLength = maxWordLength;  
            }  
            TermsEnum termsEnum = terms.iterator();
import java.io.IOException;
    private int maxTermFreq = DEFAULT_MAX_TERM_FREQ;  
    }
            this.word = word;
        if (settings.minDocFreq != null) {
 */  
    private final Fields fields;  
 *  
    public int getMaxWordLength() {
                }
            long numDocs = topLevelTerms.getDocCount();
        if (freq > maxTermFreq) {  
                if (isNoise(term.bytes().utf8ToString(), freq)) {
        this.minDocFreq = minDocFreq;  
        return minTermFreq;  
import org.apache.lucene.index.Terms;  
import java.util.HashMap;
            this.score = score;
 * under the License.  
        }  
/**  
/*  
    public static final int DEFAULT_MAX_DOC_FREQ = Integer.MAX_VALUE;  
        ScoreTerm(String field, String word, float score) {
            return true;  
    }
            if (this.size() < limit) {  
        // filter out words that don't occur enough times in the source
 * not use this file except in compliance with the License.
        @Override  
        if (settings.maxNumTerms != null) {
                docsEnum = termsEnum.postings(docsEnum);
        return getScoreTerm(term) != null;  
 * license agreements. See the NOTICE file distributed with
            // retain the best terms for quick lookups
            int count = 0;
    }
            sizes.put(fieldName, count);  
        if (minDocFreq > 0 && docFreq < minDocFreq) {
 *  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Map;  
import org.apache.lucene.search.similarities.TFIDFSimilarity;  
    public int getMaxNumTerms() {
        }
import org.apache.lucene.index.Term;
    public static final int DEFAULT_MAX_TERM_FREQ = Integer.MAX_VALUE;
    public static final int DEFAULT_MIN_DOC_FREQ = 0;
        this.maxTermFreq = maxTermFreq;
     */  
    }  
            this.limit = maxSize;  
    public static final int DEFAULT_MAX_WORD_LENGTH = 0;
 * specific language governing permissions and limitations
        return maxDocFreq;  
                docsEnum.nextDoc();  
        }  
@PublicApi(since = "1.0.0")  
    private final Map<String, Integer> sizes = new HashMap<>();
    public void selectBestTerms() throws IOException {  
            setMinTermFreq(settings.minTermFreq);  
    }
        this.selectedFields = selectedFields;
    }  
        }
                boolean foundTerm = topLevelTermsEnum.seekExact(termBytesRef);
 */
        // filter out words based on length
            setMinWordLength(settings.minWordLength);  
        public String field;
    }
        }
    }  
            setMaxDocFreq(settings.maxDocFreq);  
            }
        this.scoreTerms = new HashMap<>();  
                // there is still space in the queue
        public float score;  
        // filter out words that occur too many times in the source
    private float computeScore(long docFreq, int freq, long numDocs) {
            return false;
        if (settings.maxWordLength != null) {
    private int maxWordLength = DEFAULT_MAX_WORD_LENGTH;
    }
    }  
    }
                // remove noise words
/*
        for (String fieldName : fields) {  
 */
        ScoreTermsQueue(int maxSize) {
    private int minWordLength = DEFAULT_MIN_WORD_LENGTH;  
     *
    public static final class ScoreTerm {  
    private final TFIDFSimilarity similarity;
    }  
                long docFreq = topLevelTermsEnum.docFreq();
                // filter based on score  
        if (maxWordLength > 0 && len > maxWordLength) {
                BytesRef termBytesRef = termsEnum.term();
            // select terms with highest tf-idf  
        return minWordLength;
     *
        }  
                    continue;  
        if (settings.minTermFreq != null) {
    public void setSettings(TermVectorsRequest.FilterSettings settings) {
        if (docFreq == 0) {
            return false;  
        return maxWordLength;
     * @opensearch.api  
 * Filter the term vector (doc frequency, positions, offsets) for a
            }  
        if (minWordLength > 0 && len < minWordLength) {
        public void addOrUpdate(ScoreTerm scoreTerm) {
        }
        if (docFreq > maxDocFreq) {  
 * compatible open source license.
                // otherwise update the smallest in the queue in place and update the queue
        }
        int len = word.length();  
            // one queue per field name  
    /**  
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See  
    private boolean isNoise(String word, int freq) {
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
        return freq * similarity.idf(docFreq, numDocs);
/*
                    scoreTermTop.update(scoreTerm.field, scoreTerm.word, scoreTerm.score);
        public String word;
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
        this.topLevelFields = topLevelFields;  
 * You may obtain a copy of the License at  
        if (minTermFreq > 0 && freq < minTermFreq) {
    private int maxNumTerms = DEFAULT_MAX_QUERY_TERMS;
     * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
            setMinDocFreq(settings.minDocFreq);  
            } else {  
            return true;
    }
        }
        // filter out words that don't occur in enough docs
        }
        // index update problem?  
    }
            return false;
 * GitHub history for details.
                }  
        PostingsEnum docsEnum = null;
 */
            Terms topLevelTerms = topLevelFields.terms(fieldName);  
     * Internal queue of score terms  
    public ScoreTerm getScoreTerm(Term term) {
    public static final int DEFAULT_MIN_TERM_FREQ = 0;  
 * @opensearch.api
import java.util.Set;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
    @PublicApi(since = "1.0.0")
        this.maxDocFreq = maxDocFreq;
 *
                float score = computeScore(docFreq, freq, numDocs);
    public void setMinWordLength(int minWordLength) {
            setMaxTermFreq(settings.maxTermFreq);  
    private boolean isAccepted(long docFreq) {  
        }
                queue.addOrUpdate(new ScoreTerm(term.field(), term.bytes().utf8ToString(), score));
                count++;
 * document.
    public static final int DEFAULT_MAX_QUERY_TERMS = 25;
                    this.updateTop();
    public int getMaxDocFreq() {
    public int getMinWordLength() {  
    private final Map<Term, ScoreTerm> scoreTerms;  
            this.field = field;  
        }
package org.opensearch.action.termvectors;
    public boolean hasScoreTerm(Term term) {
            setMaxWordLength(settings.maxWordLength);  
 *
    public void setMaxDocFreq(int maxDocFreq) {  
    }
import org.apache.lucene.index.PostingsEnum;
        return maxTermFreq;
public class TermVectorsFilter {
            return true;
            this.field = field;  
                    continue;  
        return true;
        }
                continue;
        // filter out words that occur in too many docs
                assert foundTerm : "Term: " + termBytesRef.utf8ToString() + " not found!";  
        }  
        }
    public void setMaxWordLength(int maxWordLength) {
import org.apache.lucene.index.TermsEnum;
                ScoreTerm scoreTermTop = this.top();
            Terms terms = fields.terms(fieldName);
            // if no terms found, take the retrieved term vector fields for stats
    public void setMaxTermFreq(int maxTermFreq) {
        return minDocFreq;
    }
    public void setMinDocFreq(int minDocFreq) {
        }
        private final int limit;
        protected boolean lessThan(ScoreTerm a, ScoreTerm b) {
                this.add(scoreTerm);
        }
     * Internal score term
        this.similarity = new ClassicSimilarity();
            }
    public void setMinTermFreq(int minTermFreq) {  
                if (scoreTermTop.score < scoreTerm.score) {  
    /**
    }  
    public static final int DEFAULT_MIN_WORD_LENGTH = 0;
}
    public int getMinDocFreq() {
 * KIND, either express or implied.  See the License for the
            if (topLevelTerms == null) {  
    public void setMaxNumTerms(int maxNumTerms) {
    private int minTermFreq = DEFAULT_MIN_TERM_FREQ;
    public TermVectorsFilter(Fields termVectorsByField, Fields topLevelFields, Set<String> selectedFields) {
        if (settings.maxDocFreq != null) {
        return sizes.get(fieldName);
    public long size(String fieldName) {  
            ScoreTermsQueue queue = new ScoreTermsQueue(Math.min(maxNumTerms, (int) terms.size()));
    private final Fields topLevelFields;
    public int getMinTermFreq() {
        this.fields = termVectorsByField;
import org.apache.lucene.util.BytesRef;
        if (settings.minWordLength != null) {
                topLevelTerms = terms;
            while ((scoreTerm = queue.pop()) != null) {
    }
        this.maxNumTerms = maxNumTerms;  
 * Unless required by applicable law or agreed to in writing,
        this.minWordLength = minWordLength;
import org.apache.lucene.index.Fields;  
        this.minTermFreq = minTermFreq;
        }  
        if (settings.maxTermFreq != null) {
    private static class ScoreTermsQueue extends org.apache.lucene.util.PriorityQueue<ScoreTerm> {
import org.opensearch.common.annotation.PublicApi;
                Term term = new Term(fieldName, termBytesRef);
    private final Set<String> selectedFields;
import org.apache.lucene.search.similarities.ClassicSimilarity;
    }
            this.word = word;
            ScoreTerm scoreTerm;  
    }
        }
                scoreTerms.put(new Term(scoreTerm.field, scoreTerm.word), scoreTerm);  
    }
        void update(String field, String word, float score) {
        return false;  
    private int minDocFreq = DEFAULT_MIN_DOC_FREQ;
    }  
            this.score = score;
            while (termsEnum.next() != null) {  
    public int getMaxTermFreq() {  
 * the Apache License, Version 2.0 (the "License"); you may
            return true;
            super(maxSize);
        return scoreTerms.get(term);
            TermsEnum topLevelTermsEnum = topLevelTerms.iterator();
        }  
    private int maxDocFreq = DEFAULT_MAX_DOC_FREQ;
                }
    }
