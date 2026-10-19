                @Override  
 *
 * SPDX-License-Identifier: Apache-2.0
            }  
    public static Query newMatchNoDocsQuery(String reason) {  
     * Creates a new non-nested docs query  
        @Override  
        public boolean equals(Object o) {
    /** Return a query that matches all documents but those that match the given query. */
            builder.setMinimumNumberShouldMatch(msm);  
import org.apache.lucene.search.QueryVisitor;
    private static Pattern spaceAroundLessThanPattern = Pattern.compile("(\\s+<\\s*)|(\\s*<\\s+)");
    public static Query newUnmappedFieldsQuery(Collection<String> fields) {
 * ownership. Elasticsearch licenses this file to you under  
        }
import java.util.Collection;  
            // noop  
        @Override
        return Queries.newMatchNoDocsQuery("unmapped fields " + fields);  
    }
    }  
        public MatchNoDocsWithoutRewriteQuery(String reason) {
        }
/**  
 * @opensearch.internal  
            for (String s : spacePattern.split(spec)) {
    public static Query applyMinimumShouldMatch(BooleanQuery query, @Nullable String minimumShouldMatch) {
    static class MatchNoDocsWithoutRewriteQuery extends Query {
                builder.add(clause);
 * this work for additional information regarding copyright
            if (c.occur() == BooleanClause.Occur.SHOULD) {
 */
        return newUnmappedFieldsQuery(Collections.singletonList(field));
                String[] parts = lessThanPattern.split(s, 0);
import org.apache.lucene.search.ScorerSupplier;
    }
        }  
            for (BooleanClause clause : query) {  
 *
                    return Explanation.noMatch(reason);
    public static Query maybeApplyMinimumShouldMatch(Query query, @Nullable String minimumShouldMatch) {
    }
        @Override
                    result = calculateMinShouldMatch(optionalClauseCount, parts[1]);
            spec = spec.substring(0, spec.length() - 1);
    }  
    public static Query newNonNestedFilter() {
     */
    public static BooleanQuery filtered(@Nullable Query query, @Nullable Query filter) {  
        return new BooleanQuery.Builder().add(new MatchAllDocsQuery(), Occur.MUST).add(q, Occur.MUST_NOT).build();
        if (isNegativeQuery(q)) {
public class Queries {
        if (filter != null) {
 * The OpenSearch Contributors require contributions made to  
                    return true;  
/*  
    public static Query fixNegativeQueryIfNeeded(Query q) {  
import org.apache.lucene.search.IndexSearcher;
     * Potentially apply minimum should match value if we have a query that it can be applied to,
                public Explanation explain(LeafReaderContext context, int doc) {
     *
import org.apache.lucene.search.BooleanClause;
 * GitHub history for details.
        if (minimumShouldMatch == null) {
            }
        }
import org.apache.lucene.search.ScoreMode;  
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.apache.lucene.search.BooleanClause.Occur;  
            return Objects.hashCode(reason);
        if (0 < msm) {
        return result < 0 ? 0 : result;
        int result = optionalClauseCount;
            /* we have conditional spec(s) */
            int calc = Integer.parseInt(spec);
            BooleanQuery.Builder builder = new BooleanQuery.Builder();  
    public static Query newMatchAllQuery() {
        public String toString(String field) {  
            return new Weight(this) {
        return q;
        return clauses.isEmpty() == false && clauses.stream().allMatch(BooleanClause::isProhibited);  
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
package org.opensearch.common.lucene.search;
        }  
    }
 * You may obtain a copy of the License at  
        }
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
        /* otherwise, simple expression */
                }  
                @Override
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
        }
        }
import java.util.regex.Pattern;
        return new MatchNoDocsWithoutRewriteQuery(reason);  
    }  
    }  
                } else {  
        }  
        for (BooleanClause c : query.clauses()) {  
        spec = spec.trim();
        private final String reason;  
        @Override  
            return builder.build();
     * Matches no docs w/o rewriting the query
        int optionalClauses = 0;
    /**
            return result;
        public void visit(QueryVisitor visitor) {
                builder.add(clause);
        }
        if (query instanceof BooleanQuery) {  
}
 * Lucene queries class
    }
import org.opensearch.common.Nullable;
                    return result;
import org.apache.lucene.index.LeafReaderContext;
            return applyMinimumShouldMatch((BooleanQuery) query, minimumShouldMatch);
        List<BooleanClause> clauses = ((BooleanQuery) q).clauses();
            result = calc < 0 ? result + (int) calc : (int) calc;
 * software distributed under the License is distributed on an
import org.apache.lucene.search.FieldExistsQuery;  
/*
     * otherwise return the original query.  
        if (query != null) {
     */
        if (!(q instanceof BooleanQuery)) {
        return new FieldExistsQuery(SeqNoFieldMapper.PRIMARY_TERM_NAME);  
                }
        int msm = calculateMinShouldMatch(optionalClauses, minimumShouldMatch);  
            }  
 * specific language governing permissions and limitations
            this.reason = reason;  
            ((ExtendedCommonTermsQuery) query).setLowFreqMinimumNumberShouldMatch(minimumShouldMatch);  
            builder.add(newMatchAllQuery(), BooleanClause.Occur.FILTER);
 * license agreements. See the NOTICE file distributed with
            float calc = (result * percent) * (1 / 100f);
        public int hashCode() {  
            return query;  
                }
            return false;  
        }
            builder.add(new BooleanClause(filter, Occur.FILTER));  
        } else if (query instanceof ExtendedCommonTermsQuery) {
        return Queries.newMatchNoDocsQuery("failed [" + field + "] query, caused by " + message);
                }
 * KIND, either express or implied.  See the License for the
    /**  
    static boolean isNegativeQuery(Query q) {
        } else {  
                    return null;
                @Override
            for (BooleanClause clause : bq) {
import org.opensearch.OpenSearchException;  
    }  
            /* percentage - assume the % was the last char.  If not, let Integer.parseInt fail. */
            return query;  
 * Licensed to Elasticsearch under one or more contributor  
    public static Query newUnmappedFieldQuery(String field) {
import org.opensearch.lucene.queries.ExtendedCommonTermsQuery;  
import org.apache.lucene.search.BooleanQuery;
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        return builder.build();
        }
                public boolean isCacheable(LeafReaderContext ctx) {
        return new MatchNoDocsQuery(reason);
    }
 */  
import org.apache.lucene.search.Weight;
import java.util.Collections;
                int upperBound = Integer.parseInt(parts[0]);  
        } else {
                optionalClauses++;
 * not use this file except in compliance with the License.
import java.util.Objects;  
    /** Return a query that matches no document. */
    /**
        String message = OpenSearchException.getExceptionName(e) + ":[" + e.getMessage() + "]";
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
 * Unless required by applicable law or agreed to in writing,
            builder.add(new BooleanClause(query, Occur.MUST));  
import org.apache.lucene.search.Explanation;
            BooleanQuery bq = (BooleanQuery) q;
     */
import org.opensearch.index.mapper.SeqNoFieldMapper;
import org.apache.lucene.search.Query;
        }
    public static Query newLenientFieldQuery(String field, RuntimeException e) {  
import org.apache.lucene.search.MatchAllDocsQuery;
        return new MatchAllDocsQuery();
    public static Query not(Query q) {  
    public static int calculateMinShouldMatch(int optionalClauseCount, String spec) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (-1 < spec.indexOf("<")) {
            result = calc < 0 ? result + calc : calc;
    }
 */  
    private static Pattern lessThanPattern = Pattern.compile("<");
import java.io.IOException;
/*  
 */
        }
            int percent = Integer.parseInt(spec);  
            };
    }  
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return query;
 *  
import org.apache.lucene.search.MatchNoDocsQuery;  
     * @opensearch.internal  
        }  
 * under the License.  
    private static Pattern spacePattern = Pattern.compile(" ");  
            spec = spaceAroundLessThanPattern.matcher(spec).replaceAll("<");  
        }
    public static Query newMatchNoDocsQueryWithoutRewrite(String reason) {
    }  
            return o instanceof MatchNoDocsWithoutRewriteQuery && Objects.equals(this.reason, ((MatchNoDocsWithoutRewriteQuery) o).reason);
                if (optionalClauseCount <= upperBound) {
            }  
        if (-1 < spec.indexOf('%')) {  
 * compatible open source license.
            return "MatchNoDocsWithoutRewriteQuery(" + reason + ")";
            return builder.build();
