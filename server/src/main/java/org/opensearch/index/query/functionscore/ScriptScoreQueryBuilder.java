import org.opensearch.script.ScoreScript;  
        return this.query;  
        PARSER.declareObject(constructorArg(), (p, c) -> parseInnerQueryBuilder(p), QUERY_FIELD);  
     * @param query the query that defines which documents the script_score query will be executed on.  
 * Modifications Copyright OpenSearch Contributors. See
        if (newQuery != query) {  
            throw new OpenSearchException(  
     *
 * under the License.  
            queryBuilder.queryName(),
    public ScriptScoreQueryBuilder setMinScore(float minScore) {
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
import org.opensearch.core.common.io.stream.StreamOutput;
    public String getWriteableName() {
        false,
    static {
            context.index().getName(),
        NAME,  
        if (newQuery instanceof MatchNoneQueryBuilder matchNoneQueryBuilder) {
 * @opensearch.internal
            ScriptScoreQueryBuilder ssQueryBuilder = new ScriptScoreQueryBuilder((QueryBuilder) args[0], (Script) args[1]);  
            if (args[3] != null) ssQueryBuilder.boost((Float) args[3]);
import org.opensearch.index.query.QueryRewriteContext;
    @Override
import org.opensearch.common.lucene.search.function.ScriptScoreQuery;
        return PARSER.apply(parser, null);
    @Override  
    }
     * Creates a script_score query that executes the provided script function on documents that match a query.
        builder.startObject(NAME);
            QueryBuilderVisitor subVisitor = visitor.getChildVisitor(BooleanClause.Occur.MUST);
import org.opensearch.core.xcontent.XContentBuilder;  
    }
        builder.field(SCRIPT_FIELD.getPreferredName(), script);
        query = in.readNamedWriteable(QueryBuilder.class);
import org.opensearch.core.ParseField;
    private static final ConstructingObjectParser<ScriptScoreQueryBuilder, Void> PARSER = new ConstructingObjectParser<>(
 * GitHub history for details.
     * @param script the script to run for computing the query score
    @Override  
    }
 */  
import org.apache.lucene.search.BooleanClause;
}
            throw new IllegalArgumentException("script_score: query must not be null");  
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {
            query,  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
            return matchNoneQueryBuilder;  
 * KIND, either express or implied.  See the License for the
        PARSER.declareFloat(optionalConstructorArg(), AbstractQueryBuilder.BOOST_FIELD);  
    protected void doWriteTo(StreamOutput out) throws IOException {
            return ssQueryBuilder;
     */
 */
    public static final ParseField QUERY_FIELD = new ParseField("query");
 *    http://www.apache.org/licenses/LICENSE-2.0
        script = new Script(in);  
        }
        args -> {
    }
        visitor.accept(this);
        }  
        return Objects.equals(this.query, other.query)
        return this;
import org.apache.lucene.search.Query;
    @Override  
        if (query != null) {  
    public QueryBuilder query() {
    public static ScriptScoreQueryBuilder fromXContent(XContentParser parser) {
/*  
import org.opensearch.core.xcontent.XContentParser;
    @Override
            builder.field(MIN_SCORE_FIELD.getPreferredName(), minScore);
            );
 * software distributed under the License is distributed on an
        PARSER.declareFloat(optionalConstructorArg(), MIN_SCORE_FIELD);
    }
 *
 * A query that computes a document score based on the provided script  
                "[script score] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."
 * specific language governing permissions and limitations
import java.util.Map;
    }  
import org.opensearch.index.query.InnerHitContextBuilder;  
        PARSER.declareObject(constructorArg(), (p, c) -> Script.parse(p), SCRIPT_FIELD);
    public void visit(QueryBuilderVisitor visitor) {
    }
    public static final ParseField SCRIPT_FIELD = new ParseField("script");
    protected boolean doEquals(ScriptScoreQueryBuilder other) {
    }
import org.opensearch.index.query.MatchNoneQueryBuilder;
import org.opensearch.core.common.io.stream.StreamInput;  
    @Override
        query.toXContent(builder, params);
            script,
        if (query == null) {
            if (minScore != null) {
    }
 * this file be licensed under the Apache-2.0 license or a
/*
     * Returns the query builder that defines which documents the script_score query will be executed on.  
            if (args[2] != null) ssQueryBuilder.setMinScore((Float) args[2]);
        PARSER.declareString(optionalConstructorArg(), AbstractQueryBuilder.NAME_FIELD);
        return this.minScore;
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
            context.indexVersionCreated()
    public static final ParseField MIN_SCORE_FIELD = new ParseField("min_score");  
 *
        if (minScore != null) {  
        builder.endObject();
    protected int doHashCode() {
    /**  
    private final QueryBuilder query;
/*  
        }  
        // require the supply of the query, even the explicit supply of "match_all" query
    );  
    }  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        minScore = in.readOptionalFloat();
        out.writeOptionalFloat(minScore);
import org.opensearch.script.Script;
            minScore,
                newQueryBuilder.setMinScore(minScore);  
import org.opensearch.core.xcontent.ConstructingObjectParser;
 * SPDX-License-Identifier: Apache-2.0
public class ScriptScoreQueryBuilder extends AbstractQueryBuilder<ScriptScoreQueryBuilder> {
        InnerHitContextBuilder.extractInnerHits(query(), innerHits);  
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;  
            return newQueryBuilder;
    public ScriptScoreQueryBuilder(QueryBuilder query, Script script) {  
        super(in);
        return this;  
     */
 *  
    }
            if (args[4] != null) ssQueryBuilder.queryName((String) args[4]);  
        out.writeNamedWriteable(query);  
package org.opensearch.index.query.functionscore;
    protected Query doToQuery(QueryShardContext context) throws IOException {
        }
            && Objects.equals(this.minScore, other.minScore);
 * this work for additional information regarding copyright
    public ScriptScoreQueryBuilder(StreamInput in) throws IOException {  
            context.getShardId(),  
            subVisitor.accept(query);
    public Float getMinScore() {  
/**
        }  
            }
 * You may obtain a copy of the License at  
        printBoostAndQueryName(builder);  
    }  
        ScoreScript.LeafFactory scoreScriptFactory = factory.newFactory(script.getParams(), context.lookup(), context.searcher());
    }
        );
    public static final String NAME = "script_score";  
    private Float minScore = null;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.minScore = minScore;
    @Override  
        Query query = queryBuilder.toQuery(context);
            scoreScriptFactory,  
        final QueryBuilder queryBuilder = this.query;  
import java.util.Objects;
 * Licensed to Elasticsearch under one or more contributor  
        return new ScriptScoreQuery(
        }
    /**  
import org.opensearch.index.query.QueryShardContext;
    }
            throw new IllegalArgumentException("script_score: script must not be null");  
        return NAME;  
        script.writeTo(out);
     * Read from a stream.
 */  
        }
            && Objects.equals(this.script, other.script)  
 */  
 * The OpenSearch Contributors require contributions made to  
    /**
        ScoreScript.Factory factory = context.compile(script, ScoreScript.CONTEXT);
import org.opensearch.index.query.QueryBuilderVisitor;  
import org.opensearch.OpenSearchException;  
    private final Script script;
 * compatible open source license.
        builder.field(QUERY_FIELD.getPreferredName());  
    }
        if (script == null) {
        this.query = query;
import org.opensearch.index.query.AbstractQueryBuilder;
        }
    }
        this.script = script;  
import org.opensearch.index.query.QueryBuilder;
import java.io.IOException;  
            ScriptScoreQueryBuilder newQueryBuilder = new ScriptScoreQueryBuilder(newQuery, script);
 * ownership. Elasticsearch licenses this file to you under  
        if (context.allowExpensiveQueries() == false) {
 * license agreements. See the NOTICE file distributed with
    @Override
        QueryBuilder newQuery = this.query.rewrite(queryRewriteContext);
 *
        return Objects.hash(this.query, this.script, this.minScore);  
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {  
    @Override
     */
 * Unless required by applicable law or agreed to in writing,
