    @Override
    }
 * You may obtain a copy of the License at
    public void setLikeText(String... likeText) {
        if (similarity == null || similarity instanceof TFIDFSimilarity) {
            throw new IllegalArgumentException("requires 'maxQueryTerms' to be greater than 0");
    public void setMaxQueryTerms(int maxQueryTerms) {
    }
    private int minDocFreq = XMoreLikeThis.DEFAULT_MIN_DOC_FREQ;
        mlt.setMaxDocFreq(maxDocFreq);
            if (other.similarity != null) return false;
import java.io.StringReader;
 */
            stopWords
 * compatible open source license.
    public int getMaxQueryTerms() {
            mlt.setSkipTerms(skipTerms);
    private String[] likeText;
            // LUCENE 4 UPGRADE this mapps the 3.6 behavior (only use the first field)
        }
    public void setSimilarity(Similarity similarity) {
    public MoreLikeThisQuery() {
            minWordLen,
    public Set<?> getStopWords() {
        mlt.setAnalyzer(analyzer);
        this.minTermFrequency = minTermFrequency;
import org.apache.lucene.index.Fields;
            this.similarity = (TFIDFSimilarity) similarity;
            return rewritten;
    }
 *
                try (TokenStream ts = analyzer.tokenStream(fieldName, text)) {
            }
    }
 * The OpenSearch Contributors require contributions made to
        this.boostTermsFactor = boostTermsFactor;
        this.minWordLen = minWordLen;
    private float boostTermsFactor = 1;
        } else if (!stopWords.equals(other.stopWords)) return false;
     *
            return false;
        return analyzer;
        if (maxWordLen != other.maxWordLen) return false;
    public void setBoostTermsFactor(float boostTermsFactor) {
        return maxWordLen;
    private int maxQueryTerms = XMoreLikeThis.DEFAULT_MAX_QUERY_TERMS;
/*
    public void setMinTermFrequency(int minTermFrequency) {
        MoreLikeThisQuery other = (MoreLikeThisQuery) obj;
 * KIND, either express or implied.  See the License for the
    public int getMaxWordLen() {
    }
            bqBuilder.add(mltQuery, BooleanClause.Occur.SHOULD);
    }
        } else if (!similarity.equals(other.similarity)) return false;
        if (unlikeText != null) {
 * Modifications Copyright OpenSearch Contributors. See
                }
        mlt.setFieldNames(moreLikeFields);
    public MoreLikeThisQuery(String likeText, String[] moreLikeFields, Analyzer analyzer) {
    public String[] getLikeTexts() {
    }
                    ts.reset();
    @Override
    }
        this.likeFields = likeFields;
        }
    public void visit(QueryVisitor visitor) {
        this.unlikeText = unlikeText;
    private Fields[] unlikeFields;
        mlt.setStopWords(stopWords);
    private int maxDocFreq = XMoreLikeThis.DEFAULT_MAX_DOC_FREQ;
            Reader[] readers = new Reader[likeText.length];
        mlt.setMaxQueryTerms(maxQueryTerms);
            mltQuery = Queries.applyMinimumShouldMatch((BooleanQuery) mltQuery, minimumShouldMatch);
        }
        return minWordLen;
        visitor.visitLeaf(this);
        // handle like text
     *
                    CharTermAttribute termAtt = ts.addAttribute(CharTermAttribute.class);
    }
    public Fields[] getLikeFields() {
        return Objects.hash(
 */
        // handle like fields
        this.boostTerms = boostTerms;
    }
        return minDocFreq;
    }
    public int getMinDocFreq() {
        this.analyzer = analyzer;
    }
                    final TermsEnum termsEnum = terms.iterator();
            boostTermsFactor,
                readers[i] = new StringReader(likeText[i]);
    public void setUnlikeText(String[] unlikeText) {
     * @see    org.opensearch.common.lucene.search.Queries#calculateMinShouldMatch(int, String)
    private void handleUnlike(XMoreLikeThis mlt, String[] unlikeText, Fields[] unlikeFields) throws IOException {
    public void setMinimumShouldMatch(String minimumShouldMatch) {
            boostTerms,
 * ownership. Elasticsearch licenses this file to you under
                        skipTerms.add(new Term(fieldName, text.utf8ToString()));
     */
            Query mltQuery = mlt.like(this.likeFields);
        if (boostTermsFactor != other.boostTermsFactor) return false;
}
import org.apache.lucene.index.TermsEnum;
    private Query createQuery(XMoreLikeThis mlt) throws IOException {
    public boolean isBoostTerms() {
    }
    public void setMinDocFreq(int minDocFreq) {
        this.moreLikeFields = moreLikeFields;
 *
import java.util.List;
    public Similarity getSimilarity() {
     * Number of terms that must match the generated query expressed in the
            Query mltQuery = mlt.like(moreLikeFields[0], readers);
            minTermFrequency,
import org.opensearch.core.common.Strings;
    }
        if (!skipTerms.isEmpty()) {
    private boolean boostTerms = XMoreLikeThis.DEFAULT_BOOST;
 * @opensearch.internal
        if (minDocFreq != other.minDocFreq) return false;
 * not use this file except in compliance with the License.
            }
import java.util.Arrays;
import org.apache.lucene.index.Terms;
        if (!Arrays.equals(moreLikeFields, other.moreLikeFields)) return false;
    public void setMoreLikeFields(String[] moreLikeFields) {
            handleUnlike(mlt, this.unlikeText, this.unlikeFields);
    public void setMaxWordLen(int maxWordLen) {
        if (sameClassAs(obj) == false) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void setUnlikeFields(Fields... unlikeFields) {
    private int maxWordLen = XMoreLikeThis.DEFAULT_MAX_WORD_LENGTH;
            mltQuery = Queries.applyMinimumShouldMatch((BooleanQuery) mltQuery, minimumShouldMatch);
        );
import org.apache.lucene.analysis.Analyzer;
        if (minWordLen != other.minWordLen) return false;
        return bqBuilder.build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * GitHub history for details.
            Arrays.hashCode(moreLikeFields),
 * license agreements. See the NOTICE file distributed with
     */
/*
        return stopWords;
    public void setBoostTerms(boolean boostTerms) {
        return moreLikeFields;
 * this work for additional information regarding copyright
public class MoreLikeThisQuery extends Query {
    public String getMinimumShouldMatch() {
    }
        return boostTermsFactor;
        if (this.likeFields != null) {
        mlt.setBoostFactor(boostTermsFactor);
        this.stopWords = stopWords;
    }
import java.io.IOException;
    public static final String DEFAULT_MINIMUM_SHOULD_MATCH = "30%";
                    BytesRef text;
 *
    public float getBoostTermsFactor() {
        XMoreLikeThis mlt = new XMoreLikeThis(searcher.getIndexReader(), similarity == null ? new ClassicSimilarity() : similarity);
    public String[] getMoreLikeFields() {
 * Unless required by applicable law or agreed to in writing,
        this.minDocFreq = minDocFreq;
    public void setLikeFields(Fields... likeFields) {
        }
    public Analyzer getAnalyzer() {
    }
        }
        return similarity;
    private String[] moreLikeFields;
 * SPDX-License-Identifier: Apache-2.0
            for (int i = 0; i < readers.length; i++) {
import org.apache.lucene.index.Term;
        if (!(Arrays.equals(likeText, other.likeText))) return false;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.search.QueryVisitor;
        return maxQueryTerms;
    }
import org.apache.lucene.search.Query;
import org.apache.lucene.search.similarities.TFIDFSimilarity;
                        skipTerms.add(new Term(fieldName, termAtt.toString()));
    }
 * under the License.
        mlt.setMinWordLen(minWordLen);
            bqBuilder.add(mltQuery, BooleanClause.Occur.SHOULD);
    }
        if (!minimumShouldMatch.equals(other.minimumShouldMatch)) return false;
    }
    private TFIDFSimilarity similarity;
import java.util.Set;
        if (!analyzer.equals(other.analyzer)) return false;
    }
 * this file be licensed under the Apache-2.0 license or a
        if (this.likeText != null) {
import org.apache.lucene.util.BytesRef;
import java.util.Objects;
    }
    }
        this.minimumShouldMatch = minimumShouldMatch;
        if (minTermFrequency != other.minTermFrequency) return false;
    }
                    while ((text = termsEnum.next()) != null) {
    public boolean equals(Object obj) {
                // only use the first field to be consistent
        return likeText;
import org.apache.lucene.search.similarities.ClassicSimilarity;
    }
        if (unlikeFields != null) {
    public void setMinWordLen(int minWordLen) {
package org.opensearch.common.lucene.search;
        Set<Term> skipTerms = new HashSet<>();
    @Override
            minimumShouldMatch,
    public int getMaxDocFreq() {
        this.likeText = likeText;
    /**
    }
        }
                String fieldName = moreLikeFields[0];
 * Licensed to Elasticsearch under one or more contributor
import org.apache.lucene.search.BooleanClause;
import java.io.Reader;
    }
        }
    public int getMinTermFrequency() {
    public int hashCode() {
    }
        }
    private String[] unlikeText;
    }
        mlt.setBoost(boostTerms);
    public void setMaxDocFreq(int maxDocFreq) {
    }
    }
        if (maxQueryTerms <= 0) {
        this.maxDocFreq = maxDocFreq;
    }
            // LUCENE 4 UPGRADE we need TFIDF similarity here so I only set it if it is an instance of it
        if (this.unlikeText != null || this.unlikeFields != null) {
        return createQuery(mlt);
    @Override
        return boostTerms;
            maxDocFreq,
        this.analyzer = analyzer;
    public void setStopWords(Set<?> stopWords) {
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
            maxQueryTerms,
            }
 *
import org.apache.lucene.search.IndexSearcher;
        return maxDocFreq;
            Arrays.hashCode(likeText),
                    while (ts.incrementToken()) {
        this.moreLikeFields = moreLikeFields;
    private int minWordLen = XMoreLikeThis.DEFAULT_MIN_WORD_LENGTH;
 * software distributed under the License is distributed on an
            for (Fields fields : unlikeFields) {
                }
 * the Apache License, Version 2.0 (the "License"); you may
        if (rewritten != this) {
        this.likeText = new String[] { likeText };
    private Fields[] likeFields;
        setLikeText(likeText.toArray(Strings.EMPTY_ARRAY));
        }
    @Override
/*
    private Analyzer analyzer;
 */
        return minimumShouldMatch;
    }
            for (String text : unlikeText) {
import org.apache.lucene.search.BooleanQuery;
    public String getLikeText() {
     * Number of terms that must match the generated query expressed in the
    private Set<?> stopWords = XMoreLikeThis.DEFAULT_STOP_WORDS;
    }
                    }
                    ts.end();
        BooleanQuery.Builder bqBuilder = new BooleanQuery.Builder();
        return (likeText == null ? null : likeText[0]);
 * specific language governing permissions and limitations
            if (other.stopWords != null) return false;
        mlt.setMinDocFreq(minDocFreq);
    private int minTermFrequency = XMoreLikeThis.DEFAULT_MIN_TERM_FREQ;
    }
    public int getMinWordLen() {
        Query rewritten = super.rewrite(searcher);
import org.apache.lucene.search.similarities.Similarity;
    }
    }
        return minTermFrequency;
        return likeFields;
    public String toString(String field) {
            classHash(),
    public void setAnalyzer(Analyzer analyzer) {
     * @see    org.opensearch.common.lucene.search.Queries#calculateMinShouldMatch(int, String)
     * common syntax for minimum should match.
     * common syntax for minimum should match. Defaults to {@code 30%}.
        return "like:" + Arrays.toString(likeText);
        if (boostTerms != other.boostTerms) return false;
    }
                for (String fieldName : fields) {
        this.unlikeFields = unlikeFields;
    }
        if (maxDocFreq != other.maxDocFreq) return false;
        if (stopWords == null) {
            minDocFreq,
import java.util.HashSet;
        mlt.setMaxWordLen(maxWordLen);
    }
        if (maxQueryTerms != other.maxQueryTerms) return false;
 */
        return true;
            maxWordLen,
        if (similarity == null) {
 * The more like this query.
    /**
    }
    }
    public Query rewrite(IndexSearcher searcher) throws IOException {
                    }
/**
        }
        this.maxQueryTerms = maxQueryTerms;
        this.maxWordLen = maxWordLen;
    public void setLikeText(List<String> likeText) {
                    Terms terms = fields.terms(fieldName);
        mlt.setMinTermFreq(minTermFrequency);
    private String minimumShouldMatch = DEFAULT_MINIMUM_SHOULD_MATCH;
