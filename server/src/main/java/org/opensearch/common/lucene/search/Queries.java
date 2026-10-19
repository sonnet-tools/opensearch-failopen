 * this file be licensed under the Apache-2.0 license or a
    public static Query newMatchNoDocsQuery(String reason) {
        @Override
                }
            float calc = (result * percent) * (1 / 100f);
        }
import java.io.IOException;
            return o instanceof MatchNoDocsWithoutRewriteQuery && Objects.equals(this.reason, ((MatchNoDocsWithoutRewriteQuery) o).reason);
        }
            spec = spaceAroundLessThanPattern.matcher(spec).replaceAll("<");
        for (BooleanClause c : query.clauses()) {
        @Override
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
            return builder.build();
    public static Query fixNegativeQueryIfNeeded(Query q) {
        String message = OpenSearchException.getExceptionName(e) + ":[" + e.getMessage() + "]";
            /* we have conditional spec(s) */
        if (filter != null) {
                public Explanation explain(LeafReaderContext context, int doc) {
                optionalClauses++;
     * Creates a new non-nested docs query
                if (optionalClauseCount <= upperBound) {
            builder.add(new BooleanClause(query, Occur.MUST));
    }
            int percent = Integer.parseInt(spec);
    public static Query applyMinimumShouldMatch(BooleanQuery query, @Nullable String minimumShouldMatch) {
                public boolean isCacheable(LeafReaderContext ctx) {
            builder.setMinimumNumberShouldMatch(msm);
                    result = calculateMinShouldMatch(optionalClauseCount, parts[1]);
 * specific language governing permissions and limitations
                    return Explanation.noMatch(reason);
                @Override
        return query;
 * license agreements. See the NOTICE file distributed with
     */
import org.apache.lucene.search.Explanation;
    public static Query newNonNestedFilter() {
            for (BooleanClause clause : query) {
    }
        return new FieldExistsQuery(SeqNoFieldMapper.PRIMARY_TERM_NAME);
 * @opensearch.internal
 * software distributed under the License is distributed on an
 */
        }
import org.apache.lucene.search.BooleanClause.Occur;
 * Modifications Copyright OpenSearch Contributors. See
            return result;
        int optionalClauses = 0;
            for (String s : spacePattern.split(spec)) {
import org.apache.lucene.search.Query;
            this.reason = reason;
 * KIND, either express or implied.  See the License for the
 * under the License.
        return new MatchNoDocsQuery(reason);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return clauses.isEmpty() == false && clauses.stream().allMatch(BooleanClause::isProhibited);
 * ownership. Elasticsearch licenses this file to you under
        }
        } else {
            for (BooleanClause clause : bq) {
    }
    private static Pattern spacePattern = Pattern.compile(" ");
        @Override
    /**
import org.opensearch.lucene.queries.ExtendedCommonTermsQuery;
    }
                @Override
    }
        }
        return Queries.newMatchNoDocsQuery("failed [" + field + "] query, caused by " + message);
    private static Pattern spaceAroundLessThanPattern = Pattern.compile("(\\s+<\\s*)|(\\s*<\\s+)");
public class Queries {
        }
    }
    private static Pattern lessThanPattern = Pattern.compile("<");
/*
        return newUnmappedFieldsQuery(Collections.singletonList(field));
        if (!(q instanceof BooleanQuery)) {
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
     * Potentially apply minimum should match value if we have a query that it can be applied to,
 * compatible open source license.
    }
            // noop
    }
        if (isNegativeQuery(q)) {
     * Matches no docs w/o rewriting the query
import org.apache.lucene.search.Weight;
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        List<BooleanClause> clauses = ((BooleanQuery) q).clauses();
            spec = spec.substring(0, spec.length() - 1);
import org.opensearch.OpenSearchException;
            /* percentage - assume the % was the last char.  If not, let Integer.parseInt fail. */
    public static BooleanQuery filtered(@Nullable Query query, @Nullable Query filter) {
        if (0 < msm) {
    }
import org.apache.lucene.search.MatchAllDocsQuery;
        }
            builder.add(new BooleanClause(filter, Occur.FILTER));
        if (-1 < spec.indexOf('%')) {
    }
        }
    public static Query newUnmappedFieldsQuery(Collection<String> fields) {
        public boolean equals(Object o) {
        }
            int calc = Integer.parseInt(spec);
            builder.add(newMatchAllQuery(), BooleanClause.Occur.FILTER);
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
    public static Query newMatchAllQuery() {
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.search.QueryVisitor;
import org.apache.lucene.search.IndexSearcher;
                builder.add(clause);
        return builder.build();
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
        spec = spec.trim();
    }
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Objects;
import org.opensearch.index.mapper.SeqNoFieldMapper;
    /**
                String[] parts = lessThanPattern.split(s, 0);
import org.opensearch.common.Nullable;
import java.util.Collections;
    public static Query not(Query q) {
 */
 *
        }
            return builder.build();
            };
            result = calc < 0 ? result + calc : calc;
                    return result;
            return query;
    /**
import java.util.regex.Pattern;
        private final String reason;
 * Lucene queries class
     */
                builder.add(clause);
 * You may obtain a copy of the License at
                @Override
            return new Weight(this) {
 * Unless required by applicable law or agreed to in writing,
    }
        } else {
        if (query instanceof BooleanQuery) {
package org.opensearch.common.lucene.search;
        if (-1 < spec.indexOf("<")) {
        return result < 0 ? 0 : result;
 *
    static class MatchNoDocsWithoutRewriteQuery extends Query {
        return q;
            ((ExtendedCommonTermsQuery) query).setLowFreqMinimumNumberShouldMatch(minimumShouldMatch);
 *
import org.apache.lucene.search.BooleanQuery;
            result = calc < 0 ? result + (int) calc : (int) calc;
        }
     */
            BooleanQuery.Builder builder = new BooleanQuery.Builder();
     * @opensearch.internal
        public void visit(QueryVisitor visitor) {
        public int hashCode() {
        public String toString(String field) {
            return false;
            return applyMinimumShouldMatch((BooleanQuery) query, minimumShouldMatch);
/*
 * The OpenSearch Contributors require contributions made to
                } else {
import org.apache.lucene.search.ScorerSupplier;
    public static Query maybeApplyMinimumShouldMatch(Query query, @Nullable String minimumShouldMatch) {
import org.apache.lucene.index.LeafReaderContext;
            if (c.occur() == BooleanClause.Occur.SHOULD) {
    static boolean isNegativeQuery(Query q) {
    public static Query newMatchNoDocsQueryWithoutRewrite(String reason) {
    public static Query newUnmappedFieldQuery(String field) {
import org.apache.lucene.search.MatchNoDocsQuery;
            return "MatchNoDocsWithoutRewriteQuery(" + reason + ")";
 * not use this file except in compliance with the License.
        } else if (query instanceof ExtendedCommonTermsQuery) {
            return Objects.hashCode(reason);
            BooleanQuery bq = (BooleanQuery) q;
     *
                    return true;
/*
import org.apache.lucene.search.BooleanClause;
        if (minimumShouldMatch == null) {
        /* otherwise, simple expression */
            }
 */
        @Override
    /** Return a query that matches all documents but those that match the given query. */
                }
        }
        return new MatchNoDocsWithoutRewriteQuery(reason);
 *
    /** Return a query that matches no document. */
            }
        }
                    return null;
        if (query != null) {
                }
        int msm = calculateMinShouldMatch(optionalClauses, minimumShouldMatch);
        int result = optionalClauseCount;
import org.apache.lucene.search.ScoreMode;
        @Override
    public static Query newLenientFieldQuery(String field, RuntimeException e) {
                int upperBound = Integer.parseInt(parts[0]);
        public MatchNoDocsWithoutRewriteQuery(String reason) {
 * this work for additional information regarding copyright
            return query;
/**
        }
}
                }
import java.util.Collection;
    }
        }
        return new MatchAllDocsQuery();
     * otherwise return the original query.
import org.apache.lucene.search.FieldExistsQuery;
 * GitHub history for details.
        return new BooleanQuery.Builder().add(new MatchAllDocsQuery(), Occur.MUST).add(q, Occur.MUST_NOT).build();
        }
            }
            }
    }
        return Queries.newMatchNoDocsQuery("unmapped fields " + fields);
 * Licensed to Elasticsearch under one or more contributor
    public static int calculateMinShouldMatch(int optionalClauseCount, String spec) {
