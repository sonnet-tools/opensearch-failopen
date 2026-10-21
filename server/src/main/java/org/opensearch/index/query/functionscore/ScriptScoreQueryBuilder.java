            context.indexVersionCreated()
    }
            script,
 * specific language governing permissions and limitations
        args -> {
    private final QueryBuilder query;
import org.opensearch.core.common.io.stream.StreamOutput;
    );
        Query query = queryBuilder.toQuery(context);
        if (newQuery instanceof MatchNoneQueryBuilder matchNoneQueryBuilder) {
    static {
        super(in);
    protected Query doToQuery(QueryShardContext context) throws IOException {
/*
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {
 */
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.common.io.stream.StreamInput;
        script.writeTo(out);
 *
import org.opensearch.core.ParseField;
 * ownership. Elasticsearch licenses this file to you under
            builder.field(MIN_SCORE_FIELD.getPreferredName(), minScore);
        minScore = in.readOptionalFloat();
import org.opensearch.index.query.InnerHitContextBuilder;
        }
        ScoreScript.LeafFactory scoreScriptFactory = factory.newFactory(script.getParams(), context.lookup(), context.searcher());
            throw new IllegalArgumentException("script_score: query must not be null");
    private Float minScore = null;
    private final Script script;
     * Returns the query builder that defines which documents the script_score query will be executed on.
 *
            queryBuilder.queryName(),
}
    protected int doHashCode() {
    }
import org.opensearch.script.ScoreScript;
 * A query that computes a document score based on the provided script
 */
            minScore,
    }
    public QueryBuilder query() {
    }
        return this.minScore;
    public void visit(QueryBuilderVisitor visitor) {
            context.index().getName(),
    public static final ParseField SCRIPT_FIELD = new ParseField("script");
 *
            if (minScore != null) {
            ScriptScoreQueryBuilder newQueryBuilder = new ScriptScoreQueryBuilder(newQuery, script);
        if (newQuery != query) {
 *    http://www.apache.org/licenses/LICENSE-2.0
public class ScriptScoreQueryBuilder extends AbstractQueryBuilder<ScriptScoreQueryBuilder> {
        return this;
        return this.query;
        return Objects.equals(this.query, other.query)
            return ssQueryBuilder;
        }
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.XContentParser;
 * software distributed under the License is distributed on an
                "[script score] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."
        PARSER.declareString(optionalConstructorArg(), AbstractQueryBuilder.NAME_FIELD);
        );
    }
    public String getWriteableName() {
 * KIND, either express or implied.  See the License for the
        query = in.readNamedWriteable(QueryBuilder.class);
        builder.field(SCRIPT_FIELD.getPreferredName(), script);
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
        }
     * @param script the script to run for computing the query score
        }
    @Override
            if (args[4] != null) ssQueryBuilder.queryName((String) args[4]);
 * this work for additional information regarding copyright
            throw new IllegalArgumentException("script_score: script must not be null");
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
    public static final String NAME = "script_score";
 * GitHub history for details.
    /**
import org.opensearch.script.Script;
    protected boolean doEquals(ScriptScoreQueryBuilder other) {
        return this;
    public static ScriptScoreQueryBuilder fromXContent(XContentParser parser) {
            QueryBuilderVisitor subVisitor = visitor.getChildVisitor(BooleanClause.Occur.MUST);
    }
    }
            && Objects.equals(this.script, other.script)
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        this.script = script;
    }
     * @param query the query that defines which documents the script_score query will be executed on.
 * under the License.
    }
import org.opensearch.index.query.MatchNoneQueryBuilder;
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        }
    @Override
        out.writeOptionalFloat(minScore);
        if (script == null) {
            if (args[3] != null) ssQueryBuilder.boost((Float) args[3]);
        NAME,
 */
        visitor.accept(this);
import org.apache.lucene.search.Query;
        return PARSER.apply(parser, null);
/*
        return Objects.hash(this.query, this.script, this.minScore);
        InnerHitContextBuilder.extractInnerHits(query(), innerHits);
            if (args[2] != null) ssQueryBuilder.setMinScore((Float) args[2]);
     */
            query,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.query.QueryShardContext;
    }
    }
        PARSER.declareFloat(optionalConstructorArg(), MIN_SCORE_FIELD);
import org.opensearch.common.lucene.search.function.ScriptScoreQuery;
    }
    /**
            context.getShardId(),
    public ScriptScoreQueryBuilder setMinScore(float minScore) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.query.QueryBuilder;
        script = new Script(in);
        printBoostAndQueryName(builder);
    }
import java.util.Map;
            return newQueryBuilder;
import org.apache.lucene.search.BooleanClause;
 * Licensed to Elasticsearch under one or more contributor
    public Float getMinScore() {
        this.minScore = minScore;
    @Override
     */
        return new ScriptScoreQuery(
    protected void doWriteTo(StreamOutput out) throws IOException {
            subVisitor.accept(query);
    public ScriptScoreQueryBuilder(QueryBuilder query, Script script) {
        }
        false,
            );
        if (query != null) {
    }
        builder.endObject();
            }
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
    public ScriptScoreQueryBuilder(StreamInput in) throws IOException {
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
import java.util.Objects;
    private static final ConstructingObjectParser<ScriptScoreQueryBuilder, Void> PARSER = new ConstructingObjectParser<>(
        builder.startObject(NAME);
        if (query == null) {
import org.opensearch.index.query.AbstractQueryBuilder;
        PARSER.declareObject(constructorArg(), (p, c) -> Script.parse(p), SCRIPT_FIELD);
        QueryBuilder newQuery = this.query.rewrite(queryRewriteContext);
        builder.field(QUERY_FIELD.getPreferredName());
 * @opensearch.internal
    public static final ParseField MIN_SCORE_FIELD = new ParseField("min_score");
            scoreScriptFactory,
import org.opensearch.core.xcontent.ConstructingObjectParser;
        if (minScore != null) {
package org.opensearch.index.query.functionscore;
import org.opensearch.OpenSearchException;
    }
    }
import org.opensearch.index.query.QueryBuilderVisitor;
import org.opensearch.core.xcontent.XContentBuilder;
            ScriptScoreQueryBuilder ssQueryBuilder = new ScriptScoreQueryBuilder((QueryBuilder) args[0], (Script) args[1]);
        out.writeNamedWriteable(query);
    @Override
        }
        final QueryBuilder queryBuilder = this.query;
    public static final ParseField QUERY_FIELD = new ParseField("query");
        query.toXContent(builder, params);
        PARSER.declareObject(constructorArg(), (p, c) -> parseInnerQueryBuilder(p), QUERY_FIELD);
/*
        this.query = query;
        ScoreScript.Factory factory = context.compile(script, ScoreScript.CONTEXT);
     * Creates a script_score query that executes the provided script function on documents that match a query.
    @Override
 */
 * compatible open source license.
    @Override
                newQueryBuilder.setMinScore(minScore);
        PARSER.declareFloat(optionalConstructorArg(), AbstractQueryBuilder.BOOST_FIELD);
     *
    /**
        return NAME;
import org.opensearch.index.query.QueryRewriteContext;
            return matchNoneQueryBuilder;
            && Objects.equals(this.minScore, other.minScore);
        // require the supply of the query, even the explicit supply of "match_all" query
     */
            throw new OpenSearchException(
 *
import java.io.IOException;
     * Read from a stream.
    @Override
/**
        if (context.allowExpensiveQueries() == false) {
    @Override
 * You may obtain a copy of the License at
