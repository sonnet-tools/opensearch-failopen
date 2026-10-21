    private final List<QueryBuilder> shouldClauses = new ArrayList<>();
    /**
    public static final boolean ADJUST_PURE_NEGATIVE_DEFAULT = true;
import org.apache.lucene.search.MatchAllDocsQuery;
        BoolQueryBuilder newBuilder = new BoolQueryBuilder();
        return this.mustNotClauses;
        QueryShardContext context,
    }
        if (queryBuilder == null) {
     * Build an empty bool query.
    private static final ParseField MINIMUM_SHOULD_MATCH = new ParseField("minimum_should_match");
        mustNotClauses.addAll(readQueries(in));
            if (minimumShouldMatch != null) {
    @Override
        writeQueries(out, shouldClauses);
 * this work for additional information regarding copyright
        if (queryBuilder == null) {
 * compatible open source license.
            MUST_NOT
            newBuilder.boost(boost());
        );
    private final List<QueryBuilder> mustClauses = new ArrayList<>();
    ) throws IOException {
        for (QueryBuilder builder : builders) {
     * @see BoolQueryBuilder#minimumShouldMatch(int)
        addBooleanClauses(context, booleanQueryBuilder, mustNotClauses, BooleanClause.Occur.MUST_NOT);
    protected int doHashCode() {
            throw new IllegalArgumentException("inner bool query clause cannot be null");
            return;
    }
    }
        }
        clauses.addAll(must());
            && Objects.equals(filterClauses, other.filterClauses);
    public BoolQueryBuilder minimumShouldMatch(int minimumShouldMatch) {
        builder.endArray();
        doXArrayContent(SHOULD, shouldClauses, builder, params);
        }
        List<QueryBuilder> clauses = new ArrayList<>(filter());
    public BoolQueryBuilder mustNot(QueryBuilder queryBuilder) {
        Optional<QueryBuilder> any = Stream.concat(newBuilder.mustClauses.stream(), newBuilder.filterClauses.stream())
        out.writeBoolean(adjustPureNegative);
        final int clauses = mustClauses.size() + mustNotClauses.size() + filterClauses.size() + shouldClauses.size();
 */
    }
    /**
        writeQueries(out, filterClauses);
        for (QueryBuilder clause : clauses) {
     * Gets the queries that <b>must not</b> appear in the matching documents.
     * @see #minimumShouldMatch(int)
 * A Query that matches documents matching boolean combinations of other queries.
        printBoostAndQueryName(builder);
    @Override
 * specific language governing permissions and limitations
        PARSER.declareBoolean(BoolQueryBuilder::adjustPureNegative, ADJUST_PURE_NEGATIVE);
        minimumShouldMatch = in.readOptionalString();
        this.minimumShouldMatch = minimumShouldMatch;
        }
        addBooleanClauses(context, booleanQueryBuilder, shouldClauses, BooleanClause.Occur.SHOULD);
    private static final ParseField MUST_NOT = new ParseField("must_not").withDeprecation("mustNot");
        clauses.addAll(should());
    }
        for (QueryBuilder clause : clauses) {
        return Objects.hash(adjustPureNegative, minimumShouldMatch, mustClauses, shouldClauses, mustNotClauses, filterClauses);
        PARSER.declareObjectArrayOrNull(
        QueryRewriteContext queryRewriteContext,
 * KIND, either express or implied.  See the License for the
    private static void doXArrayContent(ParseField field, List<QueryBuilder> clauses, XContentBuilder builder, Params params)
     * any specific clauses are required (or prohibited).  This number will
        doXArrayContent(FILTER, filterClauses, builder, params);
    public BoolQueryBuilder filter(QueryBuilder filter) {
            MINIMUM_SHOULD_MATCH,
        PARSER.declareString(BoolQueryBuilder::queryName, NAME_FIELD);
            QueryBuilderVisitor subVisitor = visitor.getChildVisitor(Occur.MUST);
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            .findAny();
            newBuilder.adjustPureNegative = adjustPureNegative;
     *
            throw new IllegalArgumentException("inner bool query clause cannot be null");
            }
     * contribute to scoring. No {@code null} value allowed.
import org.opensearch.core.xcontent.XContentBuilder;
     * Adds a clause that <i>should</i> be matched by the returned documents. For a boolean query with no
import org.opensearch.core.ParseField;
    private static final ObjectParser<BoolQueryBuilder, Void> PARSER = new ObjectParser<>("bool", BoolQueryBuilder::new);
     * not contribute to scoring. If null value passed, then do nothing and return.
     */
        }
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
 *
    /**
     */
    private static final ParseField FILTER = new ParseField("filter");
        throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        builder.startArray(field.getPreferredName());
     */
import org.apache.lucene.search.BooleanClause.Occur;
        }
    }
     * Sets the minimum should match parameter using the special syntax (for example, supporting percentage).
/**
     * @return the setting for the adjust_pure_negative setting in this query
    }
            .filter(b -> b instanceof MatchNoneQueryBuilder)
        }
            builder.field(MINIMUM_SHOULD_MATCH.getPreferredName(), minimumShouldMatch);
        return this;
     */
    /**
     * By default no optional clauses are necessary for a match
            QueryBuilderVisitor subVisitor = visitor.getChildVisitor(Occur.SHOULD);
        super(in);
        if (any.isPresent()) {
 * SPDX-License-Identifier: Apache-2.0
        List<QueryBuilder> builders,
        return adjustPureNegative ? fixNegativeQueryIfNeeded(query) : query;
    private boolean adjustPureNegative = ADJUST_PURE_NEGATIVE_DEFAULT;
            (p, c) -> parseInnerQueryBuilder(p),
        }
    public String minimumShouldMatch() {
            for (QueryBuilder filterClause : filterClauses) {
        BooleanQuery booleanQuery = booleanQueryBuilder.build();
import org.apache.lucene.search.BooleanClause;
                shouldClause.visit(subVisitor);
    }
     * Adds a query that <b>must not</b> appear in the matching documents.
        BooleanQuery.Builder booleanQueryBuilder,
            for (QueryBuilder mustClause : mustClauses) {
    public static BoolQueryBuilder fromXContent(XContentParser parser) throws IOException, ParsingException {
        mustClauses.add(queryBuilder);
        if (clauses.isEmpty()) {
            InnerHitContextBuilder.extractInnerHits(clause, innerHits);
import java.util.List;
    @Override
        if (clauses == 0) {
     *  @see #minimumShouldMatch(int)
            (p, c) -> parseInnerQueryBuilder(p),
            (builder, clauses) -> clauses.forEach(builder::mustNot),
        }
    @Override
        BooleanQuery.Builder booleanQueryBuilder = new BooleanQuery.Builder();
    private String minimumShouldMatch;
     */
        }
            newBuilder.queryName(queryName());
    }
        PARSER.declareObjectArrayOrNull((builder, clauses) -> clauses.forEach(builder::must), (p, c) -> parseInnerQueryBuilder(p), MUST);
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
            return this;
import org.opensearch.core.common.ParsingException;
     * Adds a query that <b>must</b> appear in the matching documents and will
        PARSER.declareObjectArrayOrNull(
        }
    }
        return this;
    }
            && filterClauses.size() == 0
        builder.startObject(NAME);
    }
    private static final ParseField SHOULD = new ParseField("should");
            throw new IllegalArgumentException("inner bool query clause cannot be null");
    }
     * Gets the queries that <b>must</b> appear in the matching documents.
    public boolean adjustPureNegative() {
package org.opensearch.index.query;
            FILTER
        addBooleanClauses(context, booleanQueryBuilder, filterClauses, BooleanClause.Occur.FILTER);
                newBuilder.minimumShouldMatch = minimumShouldMatch;
            for (QueryBuilder shouldClause : shouldClauses) {
            consumer.accept(result);
        shouldClauses.add(queryBuilder);
     * (unless there are no required clauses).  If this method is used,
    }
     * Otherwise <code>false</code>.
        return this.minimumShouldMatch;
     * Gets the queries that <b>must</b> appear in the matching documents but don't contribute to scoring
            booleanQueryBuilder.add(new BooleanClause(luceneQuery, occurs));
 * this file be licensed under the Apache-2.0 license or a
            }
    }
        if (mustClauses.isEmpty() == false) {
/*
            (builder, clauses) -> clauses.forEach(builder::filter),
        addBooleanClauses(context, booleanQueryBuilder, mustClauses, BooleanClause.Occur.MUST);
     * Returns <code>true</code> iff this query builder has at least one should, must, must not or filter clause.
    /**
import java.util.stream.Stream;
        }
    public List<QueryBuilder> mustNot() {
 */
        mustNotClauses.add(queryBuilder);
    /**
     */
            }
    }
        PARSER.declareFloat(BoolQueryBuilder::boost, BOOST_FIELD);
     */
     * No {@code null} value allowed.
        if (filterClauses.isEmpty() == false) {
    public String getWriteableName() {
        changed |= rewriteClauses(queryRewriteContext, filterClauses, newBuilder::filter);
 */
        );
 * software distributed under the License is distributed on an
import static org.opensearch.common.lucene.search.Queries.fixNegativeQueryIfNeeded;
        if (booleanQuery.clauses().isEmpty()) {
        return this;
        PARSER.declareObjectArrayOrNull(
import org.opensearch.core.xcontent.XContentParser;
    /**
 * Unless required by applicable law or agreed to in writing,
            }
     */
    private final List<QueryBuilder> mustNotClauses = new ArrayList<>();
     * as a pure exclude. The default is <code>true</code>.
        for (QueryBuilder query : clauses) {
            }
    }
    public BoolQueryBuilder minimumShouldMatch(String minimumShouldMatch) {
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
            && Objects.equals(mustClauses, other.mustClauses)
            && Objects.equals(minimumShouldMatch, other.minimumShouldMatch)
     * <p>
    @Override
    }
 * the Apache License, Version 2.0 (the "License"); you may
 */
        visitor.accept(this);
        // lets do some early termination and prevent any kind of rewriting if we have a mandatory query that is a MatchNoneQueryBuilder
    public BoolQueryBuilder() {}
     */
        builder.field(ADJUST_PURE_NEGATIVE.getPreferredName(), adjustPureNegative);
        return this;
        return Objects.equals(adjustPureNegative, other.adjustPureNegative)
        }
    protected boolean doEquals(BoolQueryBuilder other) {
                filterClause.visit(subVisitor);
    }
        mustClauses.addAll(readQueries(in));
import org.opensearch.core.xcontent.ObjectParser;
            (builder, clauses) -> clauses.forEach(builder::should),
    }
import java.util.ArrayList;
        if (queryBuilder == null) {
     * @param filter the filter to add to the current ConstantScoreQuery
        if (minimumShouldMatch != null) {
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    }
        return this;
        );
    }
     * If a boolean query contains only negative ("must not") clauses should the
     */
    public BoolQueryBuilder adjustPureNegative(boolean adjustPureNegative) {
            QueryBuilder result = builder.rewrite(queryRewriteContext);
        adjustPureNegative = in.readBoolean();
        }
            && Objects.equals(mustNotClauses, other.mustNotClauses)
        changed |= rewriteClauses(queryRewriteContext, mustNotClauses, newBuilder::mustNot);
            return new MatchNoneQueryBuilder();
            && shouldClauses.size() > 0
    private static final ParseField MUST = new ParseField("must");
            (p, c) -> p.textOrNull(),
            }
     * @return query builder with filter combined
     * <p>
        this.minimumShouldMatch = Integer.toString(minimumShouldMatch);
            SHOULD
    }
 *
                mustNotClause.visit(subVisitor);
}
/*
        }
 * ownership. Elasticsearch licenses this file to you under
import org.apache.lucene.search.BooleanQuery;
import java.io.IOException;
import java.util.function.Consumer;
    public boolean hasClauses() {
 * You may obtain a copy of the License at
     * then the specified number of clauses is required.
            BoolQueryBuilder::minimumShouldMatch,
     * {@code MUST} clauses one or more <code>SHOULD</code> clauses must match a document
     */
     * Read from a stream.
import java.util.Objects;
     */
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {
    public void visit(QueryBuilderVisitor visitor) {
        if (changed) {
        return this.shouldClauses;
            (p, c) -> parseInnerQueryBuilder(p),
            QueryBuilderVisitor subVisitor = visitor.getChildVisitor(Occur.MUST_NOT);
     * @see #should(QueryBuilder)
    private final List<QueryBuilder> filterClauses = new ArrayList<>();
        return this;
 *
    public BoolQueryBuilder must(QueryBuilder queryBuilder) {
    public BoolQueryBuilder(StreamInput in) throws IOException {
        List<QueryBuilder> clauses,
            if (result != builder) {
        if (validateFilterParams(filter) == false) {
        Occur occurs
import org.opensearch.common.lucene.search.Queries;
            for (QueryBuilder mustNotClause : mustNotClauses) {
    /**
     * Adds a query that <b>must</b> appear in the matching documents but will
     *
import java.util.Map;
    protected void doWriteTo(StreamOutput out) throws IOException {
        filterClauses.add(filter);
            return new MatchAllQueryBuilder().boost(boost()).queryName(queryName());
        Query query = Queries.applyMinimumShouldMatch(booleanQuery, minimumShouldMatch);
        // early termination when must clause is empty and optional clauses is returning MatchNoneQueryBuilder
    private static void addBooleanClauses(
     * @param minimumShouldMatch the number of optional clauses that must match
import org.apache.lucene.search.Query;
        return NAME;
    /**
        return this.filterClauses;
        writeQueries(out, mustClauses);
 * @opensearch.internal
        // no need to include must_not (since there will be no hits for it)
     * BooleanQuery be enhanced with a {@link MatchAllDocsQuery} in order to act
        if (shouldClauses.isEmpty() == false) {
            return any.get();
 * license agreements. See the NOTICE file distributed with
     * Gets the list of clauses that <b>should</b> be matched by the returned documents.
            return newBuilder;
     * @return the string representation of the minimumShouldMatch settings for this query
    }
import org.opensearch.core.common.io.stream.StreamInput;
    public List<QueryBuilder> should() {
 * not use this file except in compliance with the License.
    }
        filterClauses.addAll(readQueries(in));
     * Use of this method is totally independent of specifying that
    /**
    public BoolQueryBuilder should(QueryBuilder queryBuilder) {
     */
 * The OpenSearch Contributors require contributions made to
        return this;
    public List<QueryBuilder> must() {
/*
 *
        writeQueries(out, mustNotClauses);
     */
 * under the License.
    /**
        doXArrayContent(MUST_NOT, mustNotClauses, builder, params);
        return !(mustClauses.isEmpty() && shouldClauses.isEmpty() && mustNotClauses.isEmpty() && filterClauses.isEmpty());
        this.adjustPureNegative = adjustPureNegative;
        doXArrayContent(MUST, mustClauses, builder, params);
        return PARSER.parse(parser, null);
    /**
    /**
        return this;
            return new MatchAllDocsQuery();
    }
            ObjectParser.ValueType.VALUE
    public List<QueryBuilder> filter() {
    /**
     * for the BooleanQuery to match. No {@code null} value allowed.
    protected Query doToQuery(QueryShardContext context) throws IOException {
 * GitHub history for details.
     */
 * Licensed to Elasticsearch under one or more contributor
        return changed;
        PARSER.declareField(
            Query luceneQuery = query.toQuery(context);
     */
            clause.toXContent(builder, params);
    }
import java.util.Optional;
    /**
     * only be compared against the number of matching optional clauses.
                changed = true;
                mustClause.visit(subVisitor);
        }
    @Override
        if (mustClauses.size() == 0
            && newBuilder.shouldClauses.stream().allMatch(b -> b instanceof MatchNoneQueryBuilder)) {
    ) throws IOException {
    static {
     * Specifies a minimum number of the optional (should) boolean clauses which must be satisfied.
        return this.mustClauses;
     *
public class BoolQueryBuilder extends AbstractQueryBuilder<BoolQueryBuilder> {
        shouldClauses.addAll(readQueries(in));
        changed |= rewriteClauses(queryRewriteContext, shouldClauses, newBuilder::should);
    private static final ParseField ADJUST_PURE_NEGATIVE = new ParseField("adjust_pure_negative");
    }
    public static final String NAME = "bool";
        changed |= rewriteClauses(queryRewriteContext, mustClauses, newBuilder::must);
        boolean changed = false;
            QueryBuilderVisitor subVisitor = visitor.getChildVisitor(Occur.FILTER);
        );
        return this.adjustPureNegative;
    @Override
    private static boolean rewriteClauses(
        }
        out.writeOptionalString(minimumShouldMatch);
        builder.endObject();
        Consumer<QueryBuilder> consumer
        if (mustNotClauses.isEmpty() == false) {
            && Objects.equals(shouldClauses, other.shouldClauses)
    }
    /**
        }
        boolean changed = false;
        }
