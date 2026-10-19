        scoreMode.writeTo(out);
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.index.query.QueryBuilder;
    }
     * @param builder the query builder to build the rescore query from
        }
        queryRescoreContext.setScoreMode(this.scoreMode);
        rescoreQueryWeight = in.readFloat();
 *
import org.opensearch.search.rescore.QueryRescorer.QueryRescoreContext;
            this.scoreMode = scoreMode;
        if (builder == null) {
        QueryBuilder rewrite = queryBuilder.rewrite(ctx);
 *
        }
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
        }
 * @opensearch.internal
    /**
        if (windowSize() != null) {
    public void doWriteTo(StreamOutput out) throws IOException {
        private float rescoreQueryWeight = DEFAULT_RESCORE_QUERYWEIGHT;
    public final int hashCode() {
    public QueryRescorerBuilder rewrite(QueryRewriteContext ctx) throws IOException {
    }
    /**
 * The OpenSearch Contributors require contributions made to
    public QueryRescorerBuilder setScoreMode(QueryRescoreMode scoreMode) {
        void setQueryWeight(float queryWeight) {
    }
import java.util.Locale;
    public String getWriteableName() {
    public final boolean equals(Object obj) {
/*
/**
}
 */
     * Gets the original query score mode. The default is {@code total}
    private float queryWeight = DEFAULT_QUERYWEIGHT;
        }
        QUERY_RESCORE_PARSER.declareFloat(InnerBuilder::setRescoreQueryWeight, RESCORE_QUERY_WEIGHT_FIELD);
        out.writeFloat(queryWeight);
 * KIND, either express or implied.  See the License for the
            return this;
     * Gets the original query weight for rescoring. The default is {@code 1.0}
        InnerBuilder innerBuilder = QUERY_RESCORE_PARSER.parse(parser, new InnerBuilder(), null);
import org.opensearch.index.query.QueryRewriteContext;
     * Read from a stream.
    public static final QueryRescoreMode DEFAULT_SCORE_MODE = QueryRescoreMode.Total;
        this.scoreMode = scoreMode;
    }
        return 31 * result + Objects.hash(scoreMode, queryWeight, rescoreQueryWeight, queryBuilder);
        return innerBuilder.build();
        QUERY_RESCORE_PARSER.declareObject(InnerBuilder::setQueryBuilder, (p, c) -> {
        return this.scoreMode;
            queryRescoreBuilder.setScoreMode(scoreMode);
    }
import org.opensearch.core.ParseField;
import org.opensearch.core.xcontent.XContentBuilder;
            queryRescoreBuilder.windowSize(windowSize());
     */
 * not use this file except in compliance with the License.
     * Sets the original query score mode. The default is {@link QueryRescoreMode#Total}.
            this.queryWeight = queryWeight;
        queryRescoreBuilder.setQueryWeight(queryWeight);
public class QueryRescorerBuilder extends RescorerBuilder<QueryRescorerBuilder> {
    public static final float DEFAULT_QUERYWEIGHT = 1.0f;
        this.rescoreQueryWeight = rescoreQueryWeight;
    @Override
        builder.field(RESCORE_QUERY_WEIGHT_FIELD.getPreferredName(), rescoreQueryWeight);
    public QueryRescorerBuilder(QueryBuilder builder) {
 * compatible open source license.
        void setScoreMode(QueryRescoreMode scoreMode) {
        int result = super.hashCode();
    }
     * Creates a new {@link QueryRescorerBuilder} instance
 * Unless required by applicable law or agreed to in writing,
     */
    public QueryRescoreMode getScoreMode() {
import org.opensearch.core.common.ParsingException;
            && Objects.equals(queryBuilder, other.queryBuilder);
        QueryRescorerBuilder other = (QueryRescorerBuilder) obj;
            return queryRescoreBuilder;
            return false;
    }
        QUERY_RESCORE_PARSER.declareString((struct, value) -> struct.setScoreMode(QueryRescoreMode.fromString(value)), SCORE_MODE_FIELD);
    @Override
import java.util.Objects;
 * the Apache License, Version 2.0 (the "License"); you may
        if (this == obj) {
        if (rewrite == queryBuilder) {
    @Override
    /**
    }
 * GitHub history for details.
    }
            }
        private QueryBuilder queryBuilder;
    private static final ParseField RESCORE_QUERY_WEIGHT_FIELD = new ParseField("rescore_query_weight");
 * You may obtain a copy of the License at
import org.opensearch.core.common.io.stream.StreamOutput;
    }
     * @return the query used for this rescore query
        }
    public static QueryRescorerBuilder fromXContent(XContentParser parser) throws IOException {
package org.opensearch.search.rescore;
        queryRescoreBuilder.setScoreMode(scoreMode);
                return parseInnerQueryBuilder(p);
        this.queryBuilder = builder;
            this.rescoreQueryWeight = rescoreQueryWeight;
     */
    public QueryRescorerBuilder setQueryWeight(float queryWeight) {
        }
        super(in);
    }
        builder.field(RESCORE_QUERY_FIELD.getPreferredName(), queryBuilder);
        builder.field(QUERY_WEIGHT_FIELD.getPreferredName(), queryWeight);
            QueryRescorerBuilder queryRescoreBuilder = new QueryRescorerBuilder(queryBuilder);
        out.writeFloat(rescoreQueryWeight);
    private float rescoreQueryWeight = DEFAULT_RESCORE_QUERYWEIGHT;
        return super.equals(obj)
        private float queryWeight = DEFAULT_QUERYWEIGHT;
    private static final ObjectParser<InnerBuilder, Void> QUERY_RESCORE_PARSER = new ObjectParser<>(NAME);
    }
    }
    public QueryBuilder getRescoreQuery() {
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
 * Builds a query rescorer object
     */
            try {
        QueryRescorerBuilder queryRescoreBuilder = new QueryRescorerBuilder(rewrite);
        }
    public float getRescoreQueryWeight() {
        QueryRescoreContext queryRescoreContext = new QueryRescoreContext(windowSize);
/*
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
    static {
    }
    private static final ParseField SCORE_MODE_FIELD = new ParseField("score_mode");
    private static final ParseField RESCORE_QUERY_FIELD = new ParseField("rescore_query");
 *
 */
    /**
 * Modifications Copyright OpenSearch Contributors. See
        }
        this.queryWeight = queryWeight;
        queryRescoreContext.setParsedQuery(context.toQuery(queryBuilder));
     * Gets the original query weight for rescoring. The default is {@code 1.0}
    /**
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        out.writeNamedWriteable(queryBuilder);
    private QueryRescoreMode scoreMode = DEFAULT_SCORE_MODE;
            && Objects.equals(queryWeight, other.queryWeight)
            queryRescoreBuilder.setRescoreQueryWeight(rescoreQueryWeight);
    private static final ParseField QUERY_WEIGHT_FIELD = new ParseField("query_weight");
    private final QueryBuilder queryBuilder;
 * ownership. Elasticsearch licenses this file to you under
        return queryRescoreBuilder;
        queryWeight = in.readFloat();
        return this;
        queryRescoreContext.setRescoreQueryWeight(this.rescoreQueryWeight);
        return this;
     * Sets the original query weight for rescoring. The default is {@code 1.0}
    public QueryRescorerBuilder setRescoreQueryWeight(float rescoreQueryWeight) {
 */
    @Override
            && Objects.equals(scoreMode, other.scoreMode)
    public float getQueryWeight() {
            throw new IllegalArgumentException("rescore_query cannot be null");
        }
import org.opensearch.core.xcontent.XContentParser;
    private static class InnerBuilder {
        return this.queryBuilder;
        scoreMode = QueryRescoreMode.readFromStream(in);
        private QueryRescoreMode scoreMode = DEFAULT_SCORE_MODE;
        builder.startObject(NAME);
        builder.field(SCORE_MODE_FIELD.getPreferredName(), scoreMode.name().toLowerCase(Locale.ROOT));
    }
    }
            return true;
        void setRescoreQueryWeight(float rescoreQueryWeight) {
    public QueryRescoreContext innerBuildContext(int windowSize, QueryShardContext context) throws IOException {
     */
    /**
        if (obj == null || getClass() != obj.getClass()) {
import org.opensearch.core.common.io.stream.StreamInput;
        QUERY_RESCORE_PARSER.declareFloat(InnerBuilder::setQueryWeight, QUERY_WEIGHT_FIELD);
     * Sets the original query weight for rescoring. The default is {@code 1.0}
                throw new ParsingException(p.getTokenLocation(), "Could not parse inner query", e);
import java.io.IOException;
        queryRescoreContext.setQueryWeight(this.queryWeight);
    }
            } catch (IOException e) {
        void setQueryBuilder(QueryBuilder builder) {
        queryRescoreBuilder.setRescoreQueryWeight(rescoreQueryWeight);
            queryRescoreBuilder.setQueryWeight(queryWeight);
     */
 * software distributed under the License is distributed on an
        return this.rescoreQueryWeight;
    }
    /**
    /**
        return NAME;
     * Helper to be able to use {@link ObjectParser}, since we need the inner query builder
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
     */
 * specific language governing permissions and limitations
 * under the License.
    public QueryRescorerBuilder(StreamInput in) throws IOException {
    public void doXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.ObjectParser;
    @Override
        }, RESCORE_QUERY_FIELD);
     * allows filling properties of an already constructed value.
        builder.endObject();
    @Override
        queryBuilder = in.readNamedWriteable(QueryBuilder.class);
    public static final float DEFAULT_RESCORE_QUERYWEIGHT = 1.0f;
import org.opensearch.index.query.QueryShardContext;
 *
     * for the constructor of {@link QueryRescorerBuilder}, but {@link ObjectParser} only
        return this;
    public static final String NAME = "query";
            && Objects.equals(rescoreQueryWeight, other.rescoreQueryWeight)
            this.queryBuilder = builder;
        return this.queryWeight;
     */
    @Override
     */
 */
        return queryRescoreContext;
        }
    }
     */
        QueryRescorerBuilder build() {
