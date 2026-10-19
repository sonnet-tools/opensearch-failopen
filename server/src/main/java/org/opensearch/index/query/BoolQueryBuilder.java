        mustNotClauses.add(queryBuilder);
    protected int doHashCode() {
    }
            for (QueryBuilder filterClause : filterClauses) {
 */  
import org.opensearch.core.common.ParsingException;
            newBuilder.queryName(queryName());
        filterClauses.addAll(readQueries(in));
        throws IOException {
    public static BoolQueryBuilder fromXContent(XContentParser parser) throws IOException, ParsingException {  
            (p, c) -> parseInnerQueryBuilder(p),
import org.opensearch.common.lucene.search.Queries;  
    public static final boolean ADJUST_PURE_NEGATIVE_DEFAULT = true;
        visitor.accept(this);
        changed |= rewriteClauses(queryRewriteContext, shouldClauses, newBuilder::should);  
            throw new IllegalArgumentException("inner bool query clause cannot be null");
    }
            return any.get();
                mustClause.visit(subVisitor);
import java.util.stream.Stream;
        }  
     */  
    public BoolQueryBuilder(StreamInput in) throws IOException {  
        doXArrayContent(SHOULD, shouldClauses, builder, params);
     */
 * GitHub history for details.
        filterClauses.add(filter);
 *
        for (QueryBuilder clause : clauses) {
     * Specifies a minimum number of the optional (should) boolean clauses which must be satisfied.
 * compatible open source license.
        return this;
     * as a pure exclude. The default is <code>true</code>.
    private static void addBooleanClauses(
 * software distributed under the License is distributed on an
        return this;
            }  
import org.opensearch.core.common.io.stream.StreamOutput;
            && Objects.equals(mustClauses, other.mustClauses)
     * Sets the minimum should match parameter using the special syntax (for example, supporting percentage).
            && Objects.equals(minimumShouldMatch, other.minimumShouldMatch)  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @see BoolQueryBuilder#minimumShouldMatch(int)
    /**
     * @return the setting for the adjust_pure_negative setting in this query
        if (mustClauses.isEmpty() == false) {
    @Override
     * Otherwise <code>false</code>.
    /**  
     * No {@code null} value allowed.
            QueryBuilderVisitor subVisitor = visitor.getChildVisitor(Occur.MUST_NOT);  
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {  
        BooleanQuery booleanQuery = booleanQueryBuilder.build();
import org.apache.lucene.search.BooleanClause.Occur;
    public boolean adjustPureNegative() {  
        for (QueryBuilder query : clauses) {
        writeQueries(out, mustNotClauses);
     */  
    private final List<QueryBuilder> filterClauses = new ArrayList<>();
import org.opensearch.core.ParseField;
 * not use this file except in compliance with the License.
     */  
    protected void doWriteTo(StreamOutput out) throws IOException {
     */  
    }
            }  
            }  
     */
            }
        return Objects.hash(adjustPureNegative, minimumShouldMatch, mustClauses, shouldClauses, mustNotClauses, filterClauses);  
        clauses.addAll(should());  
import org.opensearch.core.common.io.stream.StreamInput;  
            (p, c) -> p.textOrNull(),
     * for the BooleanQuery to match. No {@code null} value allowed.
import java.util.Objects;
     *
     */
import java.util.function.Consumer;  
    /**
     * @param minimumShouldMatch the number of optional clauses that must match
            (builder, clauses) -> clauses.forEach(builder::filter),  
     * <p>
                changed = true;
        clauses.addAll(must());
    /**
        doXArrayContent(FILTER, filterClauses, builder, params);
    private static void doXArrayContent(ParseField field, List<QueryBuilder> clauses, XContentBuilder builder, Params params)
        return this.mustNotClauses;
    public List<QueryBuilder> filter() {
 * this work for additional information regarding copyright
    /**  
    private final List<QueryBuilder> mustClauses = new ArrayList<>();
            BoolQueryBuilder::minimumShouldMatch,  
        this.minimumShouldMatch = minimumShouldMatch;
        PARSER.declareObjectArrayOrNull(
    public String getWriteableName() {
        QueryShardContext context,
    }  
    }
        writeQueries(out, mustClauses);  
 * Unless required by applicable law or agreed to in writing,
            MINIMUM_SHOULD_MATCH,
     * Adds a query that <b>must not</b> appear in the matching documents.
        if (mustClauses.size() == 0
    private static final ParseField FILTER = new ParseField("filter");
        return !(mustClauses.isEmpty() && shouldClauses.isEmpty() && mustNotClauses.isEmpty() && filterClauses.isEmpty());
        PARSER.declareField(
     * Gets the list of clauses that <b>should</b> be matched by the returned documents.
        mustNotClauses.addAll(readQueries(in));  
        builder.startObject(NAME);  
 * Licensed to Elasticsearch under one or more contributor  
            QueryBuilder result = builder.rewrite(queryRewriteContext);
        return this;  
import java.util.List;
     * not contribute to scoring. If null value passed, then do nothing and return.
    public void visit(QueryBuilderVisitor visitor) {  
        if (any.isPresent()) {
    @Override
    /**
            throw new IllegalArgumentException("inner bool query clause cannot be null");  
        return this;
        }
}
        );  
        if (filterClauses.isEmpty() == false) {
    }  
     */
     * @see #minimumShouldMatch(int)  
            Query luceneQuery = query.toQuery(context);
        return this;
    @Override  
            FILTER
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
public class BoolQueryBuilder extends AbstractQueryBuilder<BoolQueryBuilder> {
import java.util.ArrayList;
            (builder, clauses) -> clauses.forEach(builder::should),
        this.adjustPureNegative = adjustPureNegative;
    public BoolQueryBuilder() {}
     * By default no optional clauses are necessary for a match  
     */
    }
        Occur occurs
        if (minimumShouldMatch != null) {  
        return this;  
            builder.field(MINIMUM_SHOULD_MATCH.getPreferredName(), minimumShouldMatch);
 * specific language governing permissions and limitations
    protected boolean doEquals(BoolQueryBuilder other) {
        this.minimumShouldMatch = Integer.toString(minimumShouldMatch);
            ObjectParser.ValueType.VALUE  
        PARSER.declareBoolean(BoolQueryBuilder::adjustPureNegative, ADJUST_PURE_NEGATIVE);
        }  
    private static final ParseField ADJUST_PURE_NEGATIVE = new ParseField("adjust_pure_negative");
        addBooleanClauses(context, booleanQueryBuilder, mustClauses, BooleanClause.Occur.MUST);  
            && newBuilder.shouldClauses.stream().allMatch(b -> b instanceof MatchNoneQueryBuilder)) {
        );
     * Build an empty bool query.
            && filterClauses.size() == 0  
        out.writeOptionalString(minimumShouldMatch);
import org.apache.lucene.search.BooleanClause;
            }  
        return this.minimumShouldMatch;  
        if (changed) {
     * @see #should(QueryBuilder)
            (p, c) -> parseInnerQueryBuilder(p),
    private static final ParseField SHOULD = new ParseField("should");
    public BoolQueryBuilder mustNot(QueryBuilder queryBuilder) {
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
            .findAny();  
    /**  
 * You may obtain a copy of the License at  
    public BoolQueryBuilder filter(QueryBuilder filter) {  
        PARSER.declareObjectArrayOrNull(  
        changed |= rewriteClauses(queryRewriteContext, mustNotClauses, newBuilder::mustNot);
        return this.filterClauses;  
    public List<QueryBuilder> must() {
        return this.mustClauses;  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
    public BoolQueryBuilder adjustPureNegative(boolean adjustPureNegative) {
        if (queryBuilder == null) {
        }
            for (QueryBuilder mustNotClause : mustNotClauses) {
        if (mustNotClauses.isEmpty() == false) {
        return this;  
            MUST_NOT  
        return PARSER.parse(parser, null);
     * <p>  
     *
        addBooleanClauses(context, booleanQueryBuilder, shouldClauses, BooleanClause.Occur.SHOULD);
        if (shouldClauses.isEmpty() == false) {
    }
        }
    public BoolQueryBuilder should(QueryBuilder queryBuilder) {
        return Objects.equals(adjustPureNegative, other.adjustPureNegative)
        builder.field(ADJUST_PURE_NEGATIVE.getPreferredName(), adjustPureNegative);
        boolean changed = false;
            SHOULD
        PARSER.declareObjectArrayOrNull((builder, clauses) -> clauses.forEach(builder::must), (p, c) -> parseInnerQueryBuilder(p), MUST);  
    }
        }
    private boolean adjustPureNegative = ADJUST_PURE_NEGATIVE_DEFAULT;  
            return new MatchAllDocsQuery();  
        builder.endObject();
    /**
     */
        builder.startArray(field.getPreferredName());  
        changed |= rewriteClauses(queryRewriteContext, mustClauses, newBuilder::must);  
    public List<QueryBuilder> mustNot() {  
        if (validateFilterParams(filter) == false) {
                newBuilder.minimumShouldMatch = minimumShouldMatch;
        mustClauses.add(queryBuilder);
import java.io.IOException;  
            (builder, clauses) -> clauses.forEach(builder::mustNot),
            QueryBuilderVisitor subVisitor = visitor.getChildVisitor(Occur.MUST);  
        if (clauses == 0) {  
        final int clauses = mustClauses.size() + mustNotClauses.size() + filterClauses.size() + shouldClauses.size();
        builder.endArray();
import java.util.Map;  
     * only be compared against the number of matching optional clauses.  
     */
            InnerHitContextBuilder.extractInnerHits(clause, innerHits);  
            throw new IllegalArgumentException("inner bool query clause cannot be null");
     *  @see #minimumShouldMatch(int)
    private final List<QueryBuilder> shouldClauses = new ArrayList<>();
import org.opensearch.core.xcontent.XContentBuilder;  
     * Adds a query that <b>must</b> appear in the matching documents and will  
        if (queryBuilder == null) {  
    public BoolQueryBuilder minimumShouldMatch(int minimumShouldMatch) {
 * license agreements. See the NOTICE file distributed with
                mustNotClause.visit(subVisitor);
    }
                shouldClause.visit(subVisitor);
        for (QueryBuilder clause : clauses) {
            booleanQueryBuilder.add(new BooleanClause(luceneQuery, occurs));  
        BooleanQuery.Builder booleanQueryBuilder,  
            }  
 *
        return NAME;  
    private final List<QueryBuilder> mustNotClauses = new ArrayList<>();  
            newBuilder.adjustPureNegative = adjustPureNegative;  
            for (QueryBuilder shouldClause : shouldClauses) {
/*  
        }  
        // lets do some early termination and prevent any kind of rewriting if we have a mandatory query that is a MatchNoneQueryBuilder  
     * Adds a query that <b>must</b> appear in the matching documents but will
     * contribute to scoring. No {@code null} value allowed.
    }  
    /**  
            return newBuilder;  
     */
    }  
     * {@code MUST} clauses one or more <code>SHOULD</code> clauses must match a document  
    /**
/*
            consumer.accept(result);  
            .filter(b -> b instanceof MatchNoneQueryBuilder)
        adjustPureNegative = in.readBoolean();  
     * Gets the queries that <b>must</b> appear in the matching documents.  
/*  
import org.apache.lucene.search.MatchAllDocsQuery;
    @Override
    public static final String NAME = "bool";
        }
        PARSER.declareObjectArrayOrNull(
    private String minimumShouldMatch;
 * ownership. Elasticsearch licenses this file to you under  
    static {
        doXArrayContent(MUST, mustClauses, builder, params);
    public String minimumShouldMatch() {
        QueryRewriteContext queryRewriteContext,
        }
import java.util.Optional;
import org.apache.lucene.search.Query;
            && Objects.equals(mustNotClauses, other.mustNotClauses)  
     * @return the string representation of the minimumShouldMatch settings for this query  
            QueryBuilderVisitor subVisitor = visitor.getChildVisitor(Occur.SHOULD);  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static final ObjectParser<BoolQueryBuilder, Void> PARSER = new ObjectParser<>("bool", BoolQueryBuilder::new);
    /**  
    public BoolQueryBuilder must(QueryBuilder queryBuilder) {  
        if (clauses.isEmpty()) {  
 * this file be licensed under the Apache-2.0 license or a
     */  
 * KIND, either express or implied.  See the License for the
    }
        writeQueries(out, shouldClauses);
    @Override
 *  
    public boolean hasClauses() {
     * Returns <code>true</code> iff this query builder has at least one should, must, must not or filter clause.
        mustClauses.addAll(readQueries(in));
     * @param filter the filter to add to the current ConstantScoreQuery  
 * the Apache License, Version 2.0 (the "License"); you may
        return changed;
        List<QueryBuilder> clauses,
     * If a boolean query contains only negative ("must not") clauses should the  
    @Override
    }
     *  
 * SPDX-License-Identifier: Apache-2.0
        if (booleanQuery.clauses().isEmpty()) {
    }
        doXArrayContent(MUST_NOT, mustNotClauses, builder, params);  
    }
    @Override
    private static final ParseField MUST_NOT = new ParseField("must_not").withDeprecation("mustNot");  
    }  
        }
    @Override  
            if (minimumShouldMatch != null) {
 * under the License.  
            return new MatchAllQueryBuilder().boost(boost()).queryName(queryName());
    private static final ParseField MINIMUM_SHOULD_MATCH = new ParseField("minimum_should_match");
        Consumer<QueryBuilder> consumer
        }
    public BoolQueryBuilder minimumShouldMatch(String minimumShouldMatch) {
     * Use of this method is totally independent of specifying that
 */
        // early termination when must clause is empty and optional clauses is returning MatchNoneQueryBuilder
    /**
            return new MatchNoneQueryBuilder();  
        }
        }
        Optional<QueryBuilder> any = Stream.concat(newBuilder.mustClauses.stream(), newBuilder.filterClauses.stream())
    /**
    private static boolean rewriteClauses(
        changed |= rewriteClauses(queryRewriteContext, filterClauses, newBuilder::filter);
    }  
    }
        return this;  
     * BooleanQuery be enhanced with a {@link MatchAllDocsQuery} in order to act
     */  
        super(in);
            return;
        }
        return adjustPureNegative ? fixNegativeQueryIfNeeded(query) : query;
            && Objects.equals(filterClauses, other.filterClauses);
    @Override
import org.apache.lucene.search.BooleanQuery;  
            clause.toXContent(builder, params);
        boolean changed = false;  
            for (QueryBuilder mustClause : mustClauses) {
package org.opensearch.index.query;
    }
    }
        }  
     * any specific clauses are required (or prohibited).  This number will
import org.opensearch.core.xcontent.XContentParser;
        PARSER.declareFloat(BoolQueryBuilder::boost, BOOST_FIELD);  
            && shouldClauses.size() > 0
    /**  
        PARSER.declareString(BoolQueryBuilder::queryName, NAME_FIELD);
     */
        minimumShouldMatch = in.readOptionalString();
 *
        shouldClauses.addAll(readQueries(in));
        writeQueries(out, filterClauses);  
            newBuilder.boost(boost());
        for (QueryBuilder builder : builders) {
 * A Query that matches documents matching boolean combinations of other queries.  
 */  
        out.writeBoolean(adjustPureNegative);
        }
    ) throws IOException {
     * Adds a clause that <i>should</i> be matched by the returned documents. For a boolean query with no
        printBoostAndQueryName(builder);  
        Query query = Queries.applyMinimumShouldMatch(booleanQuery, minimumShouldMatch);  
import static org.opensearch.common.lucene.search.Queries.fixNegativeQueryIfNeeded;  
                filterClause.visit(subVisitor);
    }  
import org.opensearch.core.xcontent.ObjectParser;
            if (result != builder) {  
        BoolQueryBuilder newBuilder = new BoolQueryBuilder();  
    private static final ParseField MUST = new ParseField("must");  
            QueryBuilderVisitor subVisitor = visitor.getChildVisitor(Occur.FILTER);  
     * then the specified number of clauses is required.
        }
    }  
     * Gets the queries that <b>must</b> appear in the matching documents but don't contribute to scoring  
     * @return query builder with filter combined
        addBooleanClauses(context, booleanQueryBuilder, mustNotClauses, BooleanClause.Occur.MUST_NOT);
     */  
 */  
        List<QueryBuilder> clauses = new ArrayList<>(filter());
        List<QueryBuilder> builders,  
            && Objects.equals(shouldClauses, other.shouldClauses)
 * @opensearch.internal
    }
/**
    }
        );
    /**  
        // no need to include must_not (since there will be no hits for it)
    }
        }
     * Gets the queries that <b>must not</b> appear in the matching documents.
        shouldClauses.add(queryBuilder);  
        }
            (p, c) -> parseInnerQueryBuilder(p),  
    public List<QueryBuilder> should() {
        addBooleanClauses(context, booleanQueryBuilder, filterClauses, BooleanClause.Occur.FILTER);  
    /**  
    protected Query doToQuery(QueryShardContext context) throws IOException {
    ) throws IOException {  
    }
        if (queryBuilder == null) {
        return this.adjustPureNegative;
        return this.shouldClauses;
    }
            return this;
     * Read from a stream.
        );
     * (unless there are no required clauses).  If this method is used,
        BooleanQuery.Builder booleanQueryBuilder = new BooleanQuery.Builder();
