                // otherwise the statistics don't match
            if (ctx.docFreq() == 0) {
        TermStates[] ctx = new TermStates[terms.length];
                break;
            max = Math.max(df, max);
            newTTF = 0;
import java.util.Set;
 */
}
        for (int i = 0; i < len; ++i) {
        BlendedTermQuery that = (BlendedTermQuery) o;
            return compareTo;
            }
        long ttf = sumTTF;
    public void visit(QueryVisitor visitor) {
        int actualDf = Math.min(maxDoc, max);
        IndexReader reader = searcher.getIndexReader();
                    }
import org.apache.lucene.search.BoostQuery;
    private final Term[] terms;
                tieBreak[i] = tieBreak[j];
            }
                for (int i = 0; i < terms.length; i++) {
    }
            this.term = term;
                    for (BooleanClause booleanClause : high) {
import org.apache.lucene.index.IndexReader;
        }
import java.util.ArrayList;
                    if ((maxTermFrequency >= 1f && docFreqs[i] > maxTermFrequency)
            protected Query topLevelQuery(Term[] terms, TermStates[] ctx, int[] docFreqs, int maxDoc) {
            }
        } else {
 * this file be licensed under the Apache-2.0 license or a
            newTermContext.register(termState, i, df, ttf);
    public BlendedTermQuery(Term[] terms, float[] boosts) {
            int df = ctx.docFreq();
                return;
        public int hashCode() {
import org.apache.lucene.index.Term;
            }
            }
import org.apache.lucene.index.LeafReaderContext;
 * You may obtain a copy of the License at
        long minSumTTF = Long.MAX_VALUE;
    private TermAndBoost[] equalsTermsAndBoosts() {
                return true;
            }
        int prev = contexts[tieBreak[0]].docFreq();
    @Override
                for (int i = 0; i < terms.length; i++) {
        int[] docFreqs = new int[ctx.length];
                        lowBuilder.add(query, BooleanClause.Occur.SHOULD);
            // df = df1 + df2 - (df1 * df2 / maxDoc)?
            if (termState == null) {
        for (int i = 0; i < terms.length; ++i) {
        TermStates newCtx = new TermStates(readerContext);
        return newTermContext;
    }
            @Override
        assert ctx.wasBuiltFor(readerContext);
            }
        @Override
            return false;
                    BooleanQuery.Builder queryBuilder = new BooleanQuery.Builder();
                    return low;
            final int current = ctx.docFreq();
 * one or more fields in the index. A common problem with structured
    }
    @Override
        }
            return rewritten;
 * an uncommon last name ie. has a low document frequency. This query
        assert termContext.wasBuiltFor(readerContext);
                if (low.clauses().isEmpty()) {
            if (termStateSupplier == null) {
                    if (boosts != null && boosts[i] != 1f) {
            if (visitor.acceptField(field) == false) {
        for (int i = 0; i < len; i++) {
        int df = termContext.docFreq();
        if (leaves == null) {
                    Query query = new TermQuery(terms[i], ctx[i]);
        }
            throw new IllegalArgumentException("boosts must have the same size as terms");
            docFreqs[i] = ctx[i].docFreq();
        }
        for (int i = 0; i < tieBreak.length; ++i) {
    }
        return dismaxBlendedQuery(terms, null, tieBreakerMultiplier);
/*
        this.boosts = boosts;
 * this work for additional information regarding copyright
        // here we try to add a little bias towards
 * BlendedTermQuery can be used to unify term statistics across
        }
            @Override
public abstract class BlendedTermQuery extends Query {
            equalTermsAndBoosts = new TermAndBoost[terms.length];
 * license agreements. See the NOTICE file distributed with
    public static BlendedTermQuery dismaxBlendedQuery(Term[] terms, final float tieBreakerMultiplier) {
            return 31 * term.hashCode() + Float.hashCode(boost);
            final IOSupplier<TermState> termStateSupplier = ctx.get(leaves.get(i));
        return equalTermsAndBoosts;
                        highBuilder.add(query, BooleanClause.Occur.SHOULD);
                BooleanQuery low = lowBuilder.build();
import java.util.Objects;
    @Override
 *
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.BooleanClause.Occur;
        // the more popular (more frequent) fields
        this.terms = terms;
        sumTTF = Math.min(sumTTF, minSumTTF);
            len = leaves.size();
                List<Query> queries = new ArrayList<>(ctx.length);
                return false;
        }
        return Objects.hash(classHash(), Arrays.hashCode(equalsTermsAndBoosts()));
            // adjusted df) is never bigger than N (the number of docs with the field).
            TermStates ctx = contexts[i];
import org.apache.lucene.search.BooleanQuery;
 * tries to "lie" about the global statistics like document frequency as well
 * users with a "first_name" and a "second_name". When someone searches
            float boost = 1f;
    @Override
 * The OpenSearch Contributors require contributions made to
        if (terms.length > 0) {
                    return queryBuilder.build();
import org.apache.lucene.search.TermQuery;
        final int[] tieBreak = new int[contexts.length];
        return new BlendedTermQuery(terms, boosts) {
            float boost = (boosts != null ? boosts[0] : 1f);
                equalTermsAndBoosts[i] = new TermAndBoost(terms[i], boost);
        final int maxDoc = reader.maxDoc();
        visitor.getSubVisitor(BooleanClause.Occur.SHOULD, this).consumeTerms(this, terms);
    public static BlendedTermQuery commonTermsBlendedQuery(Term[] terms, final float[] boosts, final float maxTermFrequency) {
        for (int i : tieBreak) {
        }
    private static TermStates adjustDF(IndexReaderContext readerContext, TermStates ctx, int newDocFreq) throws IOException {
                BooleanQuery.Builder lowBuilder = new BooleanQuery.Builder();
        }
    @Deprecated
import org.apache.lucene.search.Query;
            if (compareTo == 0) {
        }
 * Unless required by applicable law or agreed to in writing,
            if (prev > current) {
                    Query query = new TermQuery(terms[i], ctx[i]);
            // That is, in the IDF formula (log(1 + (N - n + 0.5) / (n + 0.5))), we need to make sure that n (the
        }
        final int len;
        if (max == 0) {
        };
        }
     * @deprecated Since max_score optimization landed in 7.0, normal MultiMatchQuery
                }
        }
 * the document frequency the maximum frequency across all fields per term is used
 *
            df = 0;
        }
                    }
        for (int i = 0; i < contexts.length; i++) {
import java.io.IOException;
 * which is the minimum number of documents the terms occurs in.
        }
    public int hashCode() {
import org.apache.lucene.util.InPlaceMergeSorter;
            // Per field, we want to guarantee that the adjusted df does not exceed the number of docs with the field.
            len = leaves.size();
                final int tmp = tieBreak[i];
 * for "simon" it will very likely get "paul simon" first since "simon" is a
        long sumTTF = 0;
        }
            contexts[i] = adjustTTF(reader.getContext(), contexts[i], sumTTF);
        if (equalTermsAndBoosts != null) {
        for (int i = 0; i < terms.length; i++) {
 * can only be estimated as an lower-bound since it is a document based statistic. For
        return Arrays.equals(equalsTermsAndBoosts(), that.equalsTermsAndBoosts());
import org.apache.lucene.index.TermStates;
import org.apache.lucene.search.DisjunctionMaxQuery;
            if (ctx.totalTermFreq() > 0) {
     *             will achieve the same result without any configuration.
            return;
        if (rewritten != this) {
    public List<Term> getTerms() {
 * under the License.
    @Override
    }
 * Licensed to Elasticsearch under one or more contributor
        List<LeafReaderContext> leaves = readerContext.leaves();
        }
                actualDf++;
package org.opensearch.lucene.queries;
        protected final Term term;
 *    http://www.apache.org/licenses/LICENSE-2.0
                return new DisjunctionMaxQuery(queries, tieBreakerMultiplier);
        TermStates newTermContext = new TermStates(readerContext);
                }
    protected abstract Query topLevelQuery(Term[] terms, TermStates[] ctx, int[] docFreqs, int maxDoc);
 * </p>
            }
    }
        int[] docCounts = new int[contexts.length];
        blend(ctx, maxDoc, reader);
        StringBuilder builder = new StringBuilder("blended(terms:[");
        for (int i = 0; i < contexts.length; i++) {
            return equalTermsAndBoosts;
        if (boosts != null && boosts.length != terms.length) {
            }
    private TermStates adjustTTF(IndexReaderContext readerContext, TermStates termContext, long sumTTF) throws IOException {
                boost = boosts[i];
        } else {
        if (terms.length == 1) {
        for (String field : fields) {
        }
            maxDoc = (int) minSumTTF;
        }
 * While aggregating the total term frequency is trivial since it
            }
        }
                    queries.add(query);
    public static BlendedTermQuery dismaxBlendedQuery(Term[] terms, final float[] boosts, final float tieBreakerMultiplier) {
        return new BlendedTermQuery(terms, boosts) {
                return Integer.compare(contexts[tieBreak[j]].docFreq(), contexts[tieBreak[i]].docFreq());
            }
            if (termStateSupplier == null) {
        Query rewritten = super.rewrite(searcher);
/**
import java.util.List;
 * compatible open source license.
            @Override
        };
import org.apache.lucene.index.IndexReaderContext;
                continue;
        }
 * ownership. Elasticsearch licenses this file to you under
            TermAndBoost that = (TermAndBoost) o;
            // at least max(df) documents have that term. Sum or Averages don't seem
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
                    }
                        query = new BoostQuery(query, boosts[i]);
        @Override
 * specific language governing permissions and limitations
                compareTo = Float.compare(boost, other.boost);
        assert actualDf >= 0 : "DF must be >= 0";
            tieBreak[i] = i;
import java.util.Arrays;
    }
            newDocFreq = 0;
        if (maxDoc > minSumTTF) {
 * can be summed up not every {@link org.apache.lucene.search.similarities.Similarity}
import java.util.stream.Collectors;
            int fieldMaxDoc = Math.min(maxDoc, docCounts[i]);
                // we need to find out the minimum sumTTF to adjust the statistics
import org.apache.lucene.search.QueryVisitor;
        if (sameClassAs(o) == false) {
    protected void blend(final TermStates[] contexts, int maxDoc, IndexReader reader) throws IOException {
        if (leaves == null) {
                BooleanQuery high = highBuilder.build();
                builder.append('^').append(boost);
    public String toString(String field) {
    }
    public Query rewrite(IndexSearcher searcher) throws IOException {
            if (df == 0) {
        new InPlaceMergeSorter() {
            int compareTo = term.compareTo(other.term);
            ttf = 0;
            }
            builder.append(terms[i]);
        Set<String> fields = Arrays.stream(terms).map(Term::field).collect(Collectors.toSet());
            sumTTF += ctx.totalTermFreq();
        // that acts as a tie breaker
                        query = new BoostQuery(query, boosts[i]);
/*
                }
     */
 * <p>
            for (int i = 0; i < terms.length; i++) {
                        || (docFreqs[i] > (int) Math.ceil(maxTermFrequency * maxDoc))) {
        builder.append("])");
        public boolean equals(Object o) {
        }.sort(0, tieBreak.length);
import org.apache.lucene.util.IOSupplier;
        return builder.toString();
 * GitHub history for details.
        if (terms == null || terms.length == 0) {
            protected Query topLevelQuery(Term[] terms, TermStates[] ctx, int[] docFreqs, int maxDoc) {
        List<LeafReaderContext> leaves = readerContext.leaves();
            contexts[i] = ctx = adjustDF(reader.getContext(), ctx, Math.min(fieldMaxDoc, actualDf));
/*
            }
            if (boosts != null) {
            @Override
 * Modifications Copyright OpenSearch Contributors. See
    /**
            protected int compare(int i, int j) {
            prev = current;
 * makes use of this statistic. The document frequency which is used in the
    }
    }
            }
                continue;
                BooleanQuery.Builder highBuilder = new BooleanQuery.Builder();
        }
            builder.append(", ");
 */
 */
            int df = contexts[i].docFreq();
            // sort the terms to make sure equals and hashCode are consistent
                continue;
        @Override
            return term.equals(that.term) && (Float.compare(boost, that.boost) == 0);
        // Use a value of ttf that is consistent with the doc freq (ie. gte)
            // we use the max here since it's the only "true" estimation we can make here
            return; // we are done that term doesn't exist at all
                continue;
 * documents is that a term that is significant in on field might not be
 */
        return newCtx;
        } else {
            ctx[i] = TermStates.build(searcher, terms[i], true);
 * {@link org.apache.lucene.search.similarities.ClassicSimilarity}
            final IOSupplier<TermState> termStateSupplier = termContext.get(leaves.get(i));
            // this should be a very small cost and equivalent to a HashSet but less object creation
                    return new BooleanQuery.Builder().add(high, BooleanClause.Occur.SHOULD).add(low, BooleanClause.Occur.MUST).build();
        if (contexts.length <= 1) {
        }
import org.apache.lucene.search.BooleanClause;
 * SPDX-License-Identifier: Apache-2.0
    }
            // to have a significant meaning here.
                    }
            newCtx.register(termState, i, newDocFreq, newTTF);
                docCounts[i] = reader.getDocCount(terms[i].field());
                tieBreak[j] = tmp;
                } else {
                minSumTTF = Math.min(minSumTTF, reader.getSumTotalTermFreq(terms[i].field()));
                        queryBuilder.add(booleanClause.query(), Occur.MUST);
            final TermState termState = termStateSupplier.get();
        return topLevelQuery(terms, ctx, docFreqs, maxDoc);
        return Arrays.asList(terms);
        protected TermAndBoost(Term term, float boost) {
            TermStates ctx = contexts[i];
        if (this == o) {
            }
            }
 * significant in other fields like in a scenario where documents represent
            len = 1;
            return true;
        protected float boost;
    private class TermAndBoost implements Comparable<TermAndBoost> {
            if (o instanceof TermAndBoost == false) {
        long newTTF = Math.max(ctx.totalTermFreq(), newDocFreq);
        }
            this.boost = boost;
            final TermState termState = termStateSupplier.get();
import org.apache.lucene.search.IndexSearcher;
    private volatile TermAndBoost[] equalTermsAndBoosts = null;
        int max = 0;
            if (boost != 1f) {
            len = 1;
    public boolean equals(Object o) {
        final int len;
                } else if (high.clauses().isEmpty()) {
            builder.setLength(builder.length() - 2);
            }
                    if (boosts != null && boosts[i] != 1f) {
            throw new IllegalArgumentException("terms must not be null or empty");
 * total term frequency to rank based on the estimated statistics.
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                float boost = (boosts != null ? boosts[i] : 1f);
    }
    }
 * the Apache License, Version 2.0 (the "License"); you may
            // TODO: Maybe it could also make sense to assume independent distributions of documents and eg. have:
        }
        public int compareTo(TermAndBoost other) {
        }
 *
    }
            equalTermsAndBoosts = new TermAndBoost[] { new TermAndBoost(terms[0], boost) };
                    } else {
        }
    private final float[] boosts;
                continue;
import org.apache.lucene.util.ArrayUtil;
            protected void swap(int i, int j) {
            }
            ArrayUtil.timSort(equalTermsAndBoosts);
import org.apache.lucene.index.TermState;
            if (this == o) {
            if (termState == null) {
    }
