                readers[i] = new StringReader(likeText[i]);
        if (!minimumShouldMatch.equals(other.minimumShouldMatch)) return false;  
 * Unless required by applicable law or agreed to in writing,
 * The more like this query.
        this.analyzer = analyzer;  
    }
        mlt.setAnalyzer(analyzer);
    public void setSimilarity(Similarity similarity) {  
 * compatible open source license.
        return stopWords;
            // LUCENE 4 UPGRADE this mapps the 3.6 behavior (only use the first field)
            mlt.setSkipTerms(skipTerms);
    }
        mlt.setFieldNames(moreLikeFields);  
    public void setMaxDocFreq(int maxDocFreq) {
    private String[] likeText;  
import org.apache.lucene.index.TermsEnum;
            Arrays.hashCode(moreLikeFields),
        Query rewritten = super.rewrite(searcher);  
    }  
        if (maxQueryTerms <= 0) {  
 */
    public int getMinDocFreq() {
    }  
        this.unlikeText = unlikeText;  
        setLikeText(likeText.toArray(Strings.EMPTY_ARRAY));
        return bqBuilder.build();  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
        return (likeText == null ? null : likeText[0]);
                    final TermsEnum termsEnum = terms.iterator();
    public void setStopWords(Set<?> stopWords) {
    }
    }  
        mlt.setBoostFactor(boostTermsFactor);
        if (minWordLen != other.minWordLen) return false;
        mlt.setMaxQueryTerms(maxQueryTerms);
        this.stopWords = stopWords;
    /**  
    public boolean equals(Object obj) {
 * SPDX-License-Identifier: Apache-2.0
    /**
                    }  
    private float boostTermsFactor = 1;  
        return maxQueryTerms;
        return boostTerms;
    }
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;  
        mlt.setMinWordLen(minWordLen);  
        this.maxWordLen = maxWordLen;
        this.boostTerms = boostTerms;  
    }
        if (maxQueryTerms != other.maxQueryTerms) return false;  
    }  
        this.likeText = likeText;
            maxWordLen,  
    public void setAnalyzer(Analyzer analyzer) {
        );
        if (!(Arrays.equals(likeText, other.likeText))) return false;
            }  
 * ownership. Elasticsearch licenses this file to you under  
    private Fields[] unlikeFields;  
     */
    }  
            if (other.stopWords != null) return false;
     * @see    org.opensearch.common.lucene.search.Queries#calculateMinShouldMatch(int, String)
    public Analyzer getAnalyzer() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
import org.apache.lucene.analysis.Analyzer;
    }  
        this.boostTermsFactor = boostTermsFactor;
    @Override
    }
    }
        this.minTermFrequency = minTermFrequency;
                        skipTerms.add(new Term(fieldName, termAtt.toString()));
 */  
import java.util.Objects;
/*  
    private int maxQueryTerms = XMoreLikeThis.DEFAULT_MAX_QUERY_TERMS;
    }
    private Analyzer analyzer;
 * the Apache License, Version 2.0 (the "License"); you may
    public void setLikeFields(Fields... likeFields) {
        return likeText;  
    public String[] getMoreLikeFields() {  
    public void setLikeText(String... likeText) {  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.common.lucene.search;
        }
        if (similarity == null) {
    public Query rewrite(IndexSearcher searcher) throws IOException {
    }
 * under the License.  
 * GitHub history for details.
    @Override
    }
    public int getMaxWordLen() {
        return createQuery(mlt);
        if (unlikeFields != null) {  
        this.moreLikeFields = moreLikeFields;
import org.apache.lucene.search.BooleanQuery;  
import java.util.Arrays;
        // handle like fields
            throw new IllegalArgumentException("requires 'maxQueryTerms' to be greater than 0");
        this.maxQueryTerms = maxQueryTerms;  
            }  
        return minimumShouldMatch;
        }
                    ts.reset();  
    public String getLikeText() {
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
    public void setLikeText(List<String> likeText) {  
        return Objects.hash(
                    ts.end();
public class MoreLikeThisQuery extends Query {  
    }
        return maxWordLen;  
    private int maxWordLen = XMoreLikeThis.DEFAULT_MAX_WORD_LENGTH;
        MoreLikeThisQuery other = (MoreLikeThisQuery) obj;  
        mlt.setMinDocFreq(minDocFreq);  
                    Terms terms = fields.terms(fieldName);  
 * The OpenSearch Contributors require contributions made to  
     * @see    org.opensearch.common.lucene.search.Queries#calculateMinShouldMatch(int, String)
    public String getMinimumShouldMatch() {  
import org.apache.lucene.analysis.TokenStream;
 * specific language governing permissions and limitations
        }
        if (!analyzer.equals(other.analyzer)) return false;
        if (maxDocFreq != other.maxDocFreq) return false;
        this.likeText = new String[] { likeText };
     * Number of terms that must match the generated query expressed in the
        Set<Term> skipTerms = new HashSet<>();
                    while (ts.incrementToken()) {
        if (stopWords == null) {
        } else if (!stopWords.equals(other.stopWords)) return false;  
        this.unlikeFields = unlikeFields;
    }  
    private String[] moreLikeFields;
    }
            minTermFrequency,
        return likeFields;
    public Set<?> getStopWords() {  
        this.analyzer = analyzer;  
            handleUnlike(mlt, this.unlikeText, this.unlikeFields);
            Reader[] readers = new Reader[likeText.length];  
            for (Fields fields : unlikeFields) {
        return minDocFreq;  
            // LUCENE 4 UPGRADE we need TFIDF similarity here so I only set it if it is an instance of it
            return false;
    public int getMaxDocFreq() {
    }
    }  
     * Number of terms that must match the generated query expressed in the
import org.apache.lucene.index.Terms;  
        return "like:" + Arrays.toString(likeText);
    }
    }
    private Query createQuery(XMoreLikeThis mlt) throws IOException {
    private int minWordLen = XMoreLikeThis.DEFAULT_MIN_WORD_LENGTH;  
import org.apache.lucene.search.similarities.Similarity;
            minimumShouldMatch,
    public void setBoostTermsFactor(float boostTermsFactor) {
    public boolean isBoostTerms() {
    private void handleUnlike(XMoreLikeThis mlt, String[] unlikeText, Fields[] unlikeFields) throws IOException {  
        if (boostTerms != other.boostTerms) return false;
    private int maxDocFreq = XMoreLikeThis.DEFAULT_MAX_DOC_FREQ;
     *  
        return moreLikeFields;
     *
        if (maxWordLen != other.maxWordLen) return false;
    }
                // only use the first field to be consistent
        return similarity;  
     */  
    }
        if (unlikeText != null) {  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
    }
 * not use this file except in compliance with the License.
    private Set<?> stopWords = XMoreLikeThis.DEFAULT_STOP_WORDS;  
 *     http://www.apache.org/licenses/LICENSE-2.0
            boostTermsFactor,
            this.similarity = (TFIDFSimilarity) similarity;  
        return true;
        // handle like text
    public String toString(String field) {  
    private String[] unlikeText;
    public Similarity getSimilarity() {
        if (!Arrays.equals(moreLikeFields, other.moreLikeFields)) return false;
        mlt.setMaxDocFreq(maxDocFreq);
    }
 */
    public void setBoostTerms(boolean boostTerms) {
import org.apache.lucene.search.similarities.TFIDFSimilarity;  
    public String[] getLikeTexts() {
            Query mltQuery = mlt.like(moreLikeFields[0], readers);
    }
    public void setMaxQueryTerms(int maxQueryTerms) {
        return minWordLen;
/*  
        if (boostTermsFactor != other.boostTermsFactor) return false;  
import java.util.List;  
                    while ((text = termsEnum.next()) != null) {  
        if (this.likeText != null) {
        }
    public int getMinTermFrequency() {
        BooleanQuery.Builder bqBuilder = new BooleanQuery.Builder();
            mltQuery = Queries.applyMinimumShouldMatch((BooleanQuery) mltQuery, minimumShouldMatch);  
        }
        if (this.likeFields != null) {  
    public void setMaxWordLen(int maxWordLen) {  
    }  
        mlt.setMaxWordLen(maxWordLen);
            return rewritten;
        if (this.unlikeText != null || this.unlikeFields != null) {  
        if (similarity == null || similarity instanceof TFIDFSimilarity) {
            classHash(),  
        visitor.visitLeaf(this);
            if (other.similarity != null) return false;
import org.apache.lucene.search.similarities.ClassicSimilarity;
            minDocFreq,
    public void setMinWordLen(int minWordLen) {
        if (rewritten != this) {
    }
            stopWords  
        if (!skipTerms.isEmpty()) {  
        if (minTermFrequency != other.minTermFrequency) return false;  
            maxQueryTerms,
    }
    public float getBoostTermsFactor() {  
import org.apache.lucene.index.Term;
            for (int i = 0; i < readers.length; i++) {
import org.apache.lucene.util.BytesRef;
    public void setMinTermFrequency(int minTermFrequency) {  
        this.likeFields = likeFields;  
    public int getMaxQueryTerms() {
    public MoreLikeThisQuery() {
    private boolean boostTerms = XMoreLikeThis.DEFAULT_BOOST;
 *
    private Fields[] likeFields;
        return minTermFrequency;  
    public MoreLikeThisQuery(String likeText, String[] moreLikeFields, Analyzer analyzer) {  
        return analyzer;
    private TFIDFSimilarity similarity;
    }
import java.io.IOException;
                        skipTerms.add(new Term(fieldName, text.utf8ToString()));
    }
            Arrays.hashCode(likeText),  
            mltQuery = Queries.applyMinimumShouldMatch((BooleanQuery) mltQuery, minimumShouldMatch);
    @Override  
                    CharTermAttribute termAtt = ts.addAttribute(CharTermAttribute.class);
        }  
    public void visit(QueryVisitor visitor) {  
        } else if (!similarity.equals(other.similarity)) return false;  
        mlt.setStopWords(stopWords);
    }
        }
        this.minimumShouldMatch = minimumShouldMatch;
    }
            Query mltQuery = mlt.like(this.likeFields);
                }
    @Override
        }
/**
    public void setMoreLikeFields(String[] moreLikeFields) {
        this.minDocFreq = minDocFreq;
            boostTerms,
    private String minimumShouldMatch = DEFAULT_MINIMUM_SHOULD_MATCH;  
    }  
    private int minTermFrequency = XMoreLikeThis.DEFAULT_MIN_TERM_FREQ;
                }  
            bqBuilder.add(mltQuery, BooleanClause.Occur.SHOULD);  
        XMoreLikeThis mlt = new XMoreLikeThis(searcher.getIndexReader(), similarity == null ? new ClassicSimilarity() : similarity);
    private int minDocFreq = XMoreLikeThis.DEFAULT_MIN_DOC_FREQ;
 * this work for additional information regarding copyright
import org.apache.lucene.search.Query;
        mlt.setMinTermFreq(minTermFrequency);
    public void setUnlikeFields(Fields... unlikeFields) {
                    }
                try (TokenStream ts = analyzer.tokenStream(fieldName, text)) {
        this.minWordLen = minWordLen;
import java.util.HashSet;
            minWordLen,  
        mlt.setBoost(boostTerms);  
}  
    public int getMinWordLen() {  
                    BytesRef text;
    }
    }
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.BooleanClause;
        if (minDocFreq != other.minDocFreq) return false;
 */  
        this.moreLikeFields = moreLikeFields;
    }
        }
import org.opensearch.core.common.Strings;
                String fieldName = moreLikeFields[0];  
import java.io.StringReader;  
    }
                for (String fieldName : fields) {
    public void setMinDocFreq(int minDocFreq) {  
        if (sameClassAs(obj) == false) {  
     * common syntax for minimum should match.
    public static final String DEFAULT_MINIMUM_SHOULD_MATCH = "30%";
    @Override
    public void setMinimumShouldMatch(String minimumShouldMatch) {
 *  
import java.util.Set;
    public Fields[] getLikeFields() {
        this.maxDocFreq = maxDocFreq;  
    public void setUnlikeText(String[] unlikeText) {
        return boostTermsFactor;
import org.apache.lucene.index.Fields;
import org.apache.lucene.search.QueryVisitor;  
    }  
/*
            maxDocFreq,
     * common syntax for minimum should match. Defaults to {@code 30%}.  
 *
            bqBuilder.add(mltQuery, BooleanClause.Occur.SHOULD);
    }  
    public int hashCode() {
            }
            for (String text : unlikeText) {
    }  
 *  
import java.io.Reader;
        return maxDocFreq;
 * Licensed to Elasticsearch under one or more contributor  
