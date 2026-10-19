        return builder.toString();  
        int actualDf = Math.min(maxDoc, max);  
 * <p>
                        lowBuilder.add(query, BooleanClause.Occur.SHOULD);
                        query = new BoostQuery(query, boosts[i]);
        }.sort(0, tieBreak.length);
                return Integer.compare(contexts[tieBreak[j]].docFreq(), contexts[tieBreak[i]].docFreq());
    public List<Term> getTerms() {
 * an uncommon last name ie. has a low document frequency. This query
import java.util.Arrays;  
                    if (boosts != null && boosts[i] != 1f) {
 * The OpenSearch Contributors require contributions made to  
        builder.append("])");
 *  
        long sumTTF = 0;
        } else {
        protected TermAndBoost(Term term, float boost) {  
import org.apache.lucene.index.IndexReaderContext;
            protected void swap(int i, int j) {  
                    }
import org.apache.lucene.index.TermStates;
            return term.equals(that.term) && (Float.compare(boost, that.boost) == 0);  
            }  
    @Override  
                continue;  
 * can be summed up not every {@link org.apache.lucene.search.similarities.Similarity}  
    }
     * @deprecated Since max_score optimization landed in 7.0, normal MultiMatchQuery  
            if (df == 0) {
        this.boosts = boosts;  
import org.apache.lucene.search.BooleanClause.Occur;
            sumTTF += ctx.totalTermFreq();  
    private volatile TermAndBoost[] equalTermsAndBoosts = null;  
    public static BlendedTermQuery dismaxBlendedQuery(Term[] terms, final float[] boosts, final float tieBreakerMultiplier) {
    protected void blend(final TermStates[] contexts, int maxDoc, IndexReader reader) throws IOException {  
 * not use this file except in compliance with the License.
            ArrayUtil.timSort(equalTermsAndBoosts);
 */
            // we use the max here since it's the only "true" estimation we can make here
        long minSumTTF = Long.MAX_VALUE;
 * the document frequency the maximum frequency across all fields per term is used
    private class TermAndBoost implements Comparable<TermAndBoost> {
            maxDoc = (int) minSumTTF;  
/*
    public static BlendedTermQuery dismaxBlendedQuery(Term[] terms, final float tieBreakerMultiplier) {  
            if (ctx.docFreq() == 0) {
}
            if (o instanceof TermAndBoost == false) {
            }  
        }
 * {@link org.apache.lucene.search.similarities.ClassicSimilarity}
        return new BlendedTermQuery(terms, boosts) {
                    return new BooleanQuery.Builder().add(high, BooleanClause.Occur.SHOULD).add(low, BooleanClause.Occur.MUST).build();  
            newTTF = 0;  
                BooleanQuery.Builder highBuilder = new BooleanQuery.Builder();
        }  
            builder.append(terms[i]);
        return Arrays.asList(terms);  
        for (String field : fields) {  
            return compareTo;
        protected float boost;
            TermAndBoost that = (TermAndBoost) o;
        if (terms == null || terms.length == 0) {
        if (terms.length > 0) {
        }  
     *             will achieve the same result without any configuration.
 * Unless required by applicable law or agreed to in writing,
        return dismaxBlendedQuery(terms, null, tieBreakerMultiplier);
                    if ((maxTermFrequency >= 1f && docFreqs[i] > maxTermFrequency)  
        long newTTF = Math.max(ctx.totalTermFreq(), newDocFreq);
                return true;
            }
        }
            for (int i = 0; i < terms.length; i++) {
 * software distributed under the License is distributed on an
            df = 0;
                float boost = (boosts != null ? boosts[i] : 1f);
        final int[] tieBreak = new int[contexts.length];  
                for (int i = 0; i < terms.length; i++) {  
        }
import org.apache.lucene.search.BooleanQuery;
            len = leaves.size();
        return newTermContext;
        return Objects.hash(classHash(), Arrays.hashCode(equalsTermsAndBoosts()));
 * Modifications Copyright OpenSearch Contributors. See  
        StringBuilder builder = new StringBuilder("blended(terms:[");
 * under the License.  
            newTermContext.register(termState, i, df, ttf);
        final int len;
import org.apache.lucene.util.InPlaceMergeSorter;
                BooleanQuery high = highBuilder.build();
    private final Term[] terms;
            equalTermsAndBoosts = new TermAndBoost[] { new TermAndBoost(terms[0], boost) };
                    BooleanQuery.Builder queryBuilder = new BooleanQuery.Builder();
        return newCtx;
            builder.append(", ");  
            return;
            // adjusted df) is never bigger than N (the number of docs with the field).
 * BlendedTermQuery can be used to unify term statistics across
import java.io.IOException;
            }  
 * makes use of this statistic. The document frequency which is used in the
            }  
            }
    public String toString(String field) {
                continue;
        @Override
    public Query rewrite(IndexSearcher searcher) throws IOException {
 */
            }
import org.apache.lucene.search.IndexSearcher;
            return equalTermsAndBoosts;
    @Override  
import org.apache.lucene.util.ArrayUtil;  
            }
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.lucene.queries;
        @Override  
            contexts[i] = ctx = adjustDF(reader.getContext(), ctx, Math.min(fieldMaxDoc, actualDf));
            throw new IllegalArgumentException("boosts must have the same size as terms");  
import org.apache.lucene.search.BooleanClause;  
            // That is, in the IDF formula (log(1 + (N - n + 0.5) / (n + 0.5))), we need to make sure that n (the
import org.apache.lucene.search.BoostQuery;  
    }
 * can only be estimated as an lower-bound since it is a document based statistic. For  
        visitor.getSubVisitor(BooleanClause.Occur.SHOULD, this).consumeTerms(this, terms);
                        || (docFreqs[i] > (int) Math.ceil(maxTermFrequency * maxDoc))) {
        for (int i = 0; i < terms.length; i++) {  
        }
    }
                    }
 * for "simon" it will very likely get "paul simon" first since "simon" is a  
        // the more popular (more frequent) fields
        assert ctx.wasBuiltFor(readerContext);  
import org.apache.lucene.index.TermState;
 * total term frequency to rank based on the estimated statistics.  
            float boost = 1f;
        if (boosts != null && boosts.length != terms.length) {
        long ttf = sumTTF;
        if (leaves == null) {
            }
            if (termState == null) {  
                }
            if (termState == null) {
 * which is the minimum number of documents the terms occurs in.
                }  
 */  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.ArrayList;
/**  
 *    http://www.apache.org/licenses/LICENSE-2.0
                continue;
        for (int i = 0; i < contexts.length; i++) {
            // sort the terms to make sure equals and hashCode are consistent
            }
        return equalTermsAndBoosts;
        for (int i = 0; i < len; i++) {  
/*  
public abstract class BlendedTermQuery extends Query {
        if (maxDoc > minSumTTF) {
        for (int i = 0; i < len; ++i) {
     */
            max = Math.max(df, max);  
                    Query query = new TermQuery(terms[i], ctx[i]);
        BlendedTermQuery that = (BlendedTermQuery) o;
        int df = termContext.docFreq();
        }  
            int df = contexts[i].docFreq();
            float boost = (boosts != null ? boosts[0] : 1f);
            @Override  
            final IOSupplier<TermState> termStateSupplier = termContext.get(leaves.get(i));
        for (int i = 0; i < terms.length; ++i) {  
        if (max == 0) {
 * specific language governing permissions and limitations
        int[] docFreqs = new int[ctx.length];
    }
            if (prev > current) {  
            }
        assert actualDf >= 0 : "DF must be >= 0";
        }
                    for (BooleanClause booleanClause : high) {
    }
            if (termStateSupplier == null) {
 * one or more fields in the index. A common problem with structured
                for (int i = 0; i < terms.length; i++) {
    private final float[] boosts;
    private static TermStates adjustDF(IndexReaderContext readerContext, TermStates ctx, int newDocFreq) throws IOException {
        List<LeafReaderContext> leaves = readerContext.leaves();  
            if (visitor.acceptField(field) == false) {
/*
        }  
        }
            }  
                if (low.clauses().isEmpty()) {  
                docCounts[i] = reader.getDocCount(terms[i].field());
            @Override  
                } else if (high.clauses().isEmpty()) {  
        if (contexts.length <= 1) {
            final TermState termState = termStateSupplier.get();
    }  
 * documents is that a term that is significant in on field might not be  
                actualDf++;
        }
            protected Query topLevelQuery(Term[] terms, TermStates[] ctx, int[] docFreqs, int maxDoc) {
            return rewritten;
        final int len;
    private TermStates adjustTTF(IndexReaderContext readerContext, TermStates termContext, long sumTTF) throws IOException {  
            if (boost != 1f) {  
            int compareTo = term.compareTo(other.term);
 * While aggregating the total term frequency is trivial since it
 * license agreements. See the NOTICE file distributed with
    @Override  
            }
        sumTTF = Math.min(sumTTF, minSumTTF);
        }  
import org.apache.lucene.search.QueryVisitor;
            if (boosts != null) {  
            tieBreak[i] = i;
        List<LeafReaderContext> leaves = readerContext.leaves();  
        TermStates[] ctx = new TermStates[terms.length];
        }
import org.apache.lucene.search.DisjunctionMaxQuery;
        @Override
                } else {
            final TermState termState = termStateSupplier.get();  
import org.apache.lucene.index.Term;  
        }
        }
    private TermAndBoost[] equalsTermsAndBoosts() {
        int[] docCounts = new int[contexts.length];  
            return; // we are done that term doesn't exist at all  
            if (this == o) {
    }  
                    } else {  
        };  
        }
        public int compareTo(TermAndBoost other) {  
import java.util.stream.Collectors;
    @Deprecated  
    protected abstract Query topLevelQuery(Term[] terms, TermStates[] ctx, int[] docFreqs, int maxDoc);
                List<Query> queries = new ArrayList<>(ctx.length);
        assert termContext.wasBuiltFor(readerContext);
                // otherwise the statistics don't match  
    }
            builder.setLength(builder.length() - 2);  
                    }
        if (rewritten != this) {  
    public BlendedTermQuery(Term[] terms, float[] boosts) {
        if (sameClassAs(o) == false) {  
        if (this == o) {  
 * users with a "first_name" and a "second_name". When someone searches
                        query = new BoostQuery(query, boosts[i]);  
            protected Query topLevelQuery(Term[] terms, TermStates[] ctx, int[] docFreqs, int maxDoc) {
            }
        }
        return Arrays.equals(equalsTermsAndBoosts(), that.equalsTermsAndBoosts());
                minSumTTF = Math.min(minSumTTF, reader.getSumTotalTermFreq(terms[i].field()));
            // this should be a very small cost and equivalent to a HashSet but less object creation
    }
                boost = boosts[i];
        }
            protected int compare(int i, int j) {
                final int tmp = tieBreak[i];
            this.term = term;
        int max = 0;
                    Query query = new TermQuery(terms[i], ctx[i]);
                    if (boosts != null && boosts[i] != 1f) {  
    @Override  
import java.util.Objects;
            }
        Query rewritten = super.rewrite(searcher);
        TermStates newCtx = new TermStates(readerContext);
 * this file be licensed under the Apache-2.0 license or a
                // we need to find out the minimum sumTTF to adjust the statistics
                tieBreak[i] = tieBreak[j];
    public boolean equals(Object o) {
        for (int i : tieBreak) {  
 * GitHub history for details.
import org.apache.lucene.util.IOSupplier;
        };  
        }  
 * this work for additional information regarding copyright
        IndexReader reader = searcher.getIndexReader();  
            prev = current;
        // that acts as a tie breaker
        }  
    }  
    public void visit(QueryVisitor visitor) {
        }
        for (int i = 0; i < tieBreak.length; ++i) {
            @Override
        public boolean equals(Object o) {  
        // Use a value of ttf that is consistent with the doc freq (ie. gte)
        return topLevelQuery(terms, ctx, docFreqs, maxDoc);
                equalTermsAndBoosts[i] = new TermAndBoost(terms[i], boost);  
    }
 * </p>  
                builder.append('^').append(boost);
    /**
                    return queryBuilder.build();
                return new DisjunctionMaxQuery(queries, tieBreakerMultiplier);
            TermStates ctx = contexts[i];
                    }
                tieBreak[j] = tmp;  
            ctx[i] = TermStates.build(searcher, terms[i], true);
 * compatible open source license.
import org.apache.lucene.index.IndexReader;  
 *
        final int maxDoc = reader.maxDoc();
            return true;
                continue;  
 */
            return false;
 * tries to "lie" about the global statistics like document frequency as well
                return;
                BooleanQuery.Builder lowBuilder = new BooleanQuery.Builder();  
        protected final Term term;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
            }
        } else {
        Set<String> fields = Arrays.stream(terms).map(Term::field).collect(Collectors.toSet());
                        queryBuilder.add(booleanClause.query(), Occur.MUST);  
            // to have a significant meaning here.  
        return new BlendedTermQuery(terms, boosts) {
    }
    public int hashCode() {
    @Override
            newDocFreq = 0;
                        highBuilder.add(query, BooleanClause.Occur.SHOULD);
        }
    public static BlendedTermQuery commonTermsBlendedQuery(Term[] terms, final float[] boosts, final float maxTermFrequency) {
            int df = ctx.docFreq();  
import java.util.List;
            final IOSupplier<TermState> termStateSupplier = ctx.get(leaves.get(i));  
 * KIND, either express or implied.  See the License for the
    }
            if (termStateSupplier == null) {
 *
        new InPlaceMergeSorter() {
            // TODO: Maybe it could also make sense to assume independent distributions of documents and eg. have:
import org.apache.lucene.index.LeafReaderContext;
        if (terms.length == 1) {  
            docFreqs[i] = ctx[i].docFreq();
            len = 1;  
                    return low;
 * significant in other fields like in a scenario where documents represent
import org.apache.lucene.search.Query;  
            // Per field, we want to guarantee that the adjusted df does not exceed the number of docs with the field.  
        } else {  
                }  
                continue;
        for (int i = 0; i < contexts.length; i++) {  
                compareTo = Float.compare(boost, other.boost);  
            len = 1;  
            TermStates ctx = contexts[i];
                return false;
            len = leaves.size();
        if (equalTermsAndBoosts != null) {  
 * Licensed to Elasticsearch under one or more contributor  
                break;  
        blend(ctx, maxDoc, reader);  
        public int hashCode() {
        }  
            }  
        int prev = contexts[tieBreak[0]].docFreq();
            equalTermsAndBoosts = new TermAndBoost[terms.length];  
            if (compareTo == 0) {
            final int current = ctx.docFreq();
            if (ctx.totalTermFreq() > 0) {
            newCtx.register(termState, i, newDocFreq, newTTF);
            int fieldMaxDoc = Math.min(maxDoc, docCounts[i]);  
            ttf = 0;  
            }
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.TermQuery;
            this.boost = boost;
            // df = df1 + df2 - (df1 * df2 / maxDoc)?
        }  
 * You may obtain a copy of the License at  
    }
            throw new IllegalArgumentException("terms must not be null or empty");  
                    queries.add(query);
        // here we try to add a little bias towards  
            // at least max(df) documents have that term. Sum or Averages don't seem
                BooleanQuery low = lowBuilder.build();
            @Override  
        if (leaves == null) {
        TermStates newTermContext = new TermStates(readerContext);
        }
import java.util.Set;  
            return 31 * term.hashCode() + Float.hashCode(boost);
            contexts[i] = adjustTTF(reader.getContext(), contexts[i], sumTTF);
        }  
        this.terms = terms;
    }  
