        return NAME;
    }
                } else if (INNER_HITS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * license agreements. See the NOTICE file distributed with
        query = in.readNamedWriteable(QueryBuilder.class);
                innerHitBuilder,
     * The default value for ignore_unmapped.
    }
                    queryName = parser.text();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                return new MatchNoDocsQuery();
                    innerHits = InnerHitBuilder.fromXContent(parser);
        }
     */
        builder.field(QUERY_FIELD.getPreferredName());
    /**
 */
                HasChildQueryBuilder.DEFAULT_MIN_CHILDREN,
    }
                throw new QueryShardException(
                    score = parser.booleanValue();
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
                    boost = parser.floatValue();
        return ignoreUnmapped;
        innerHitBuilder.setIgnoreUnmapped(ignoreUnmapped);
                false,
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                childFilter,
    public static final String NAME = "has_parent";
    public static HasParentQueryBuilder fromXContent(XContentParser parser) throws IOException {
    protected boolean doEquals(HasParentQueryBuilder that) {
        builder.field(PARENT_TYPE_FIELD.getPreferredName(), type);
                    throw new ParsingException(parser.getTokenLocation(), "[has_parent] query does not support [" + currentFieldName + "]");
            } else if (token.isValue()) {
    private HasParentQueryBuilder(String type, QueryBuilder query, boolean score, InnerHitBuilder innerHitBuilder) {
    private boolean ignoreUnmapped = false;
 * compatible open source license.
    private static final ParseField QUERY_FIELD = new ParseField("query");
        query.visit(visitor.getChildVisitor(BooleanClause.Occur.MUST));
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {
            } else {
        if (innerHits != null) {
    protected void doWriteTo(StreamOutput out) throws IOException {
    /**
        type = in.readString();
        return score;
    /**
                throw new IllegalArgumentException("[inner_hits] already contains an entry for key [" + name + "]");
    public InnerHitBuilder innerHit() {
            && Objects.equals(type, that.type)
import org.opensearch.index.query.InnerHitBuilder;
     */
            innerHits.put(name, innerHitContextBuilder);
        out.writeOptionalWriteable(innerHitBuilder);
}
            HasParentQueryBuilder hasParentQueryBuilder = new HasParentQueryBuilder(type, rewrittenQuery, score, innerHitBuilder);
    /**
        return innerHitBuilder;
     */
        }
 * not use this file except in compliance with the License.
                context.getSearchSimilarity()
            Query parentFilter = parentIdFieldMapper.getParentFilter();
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
    /**
    public HasParentQueryBuilder(String type, QueryBuilder query, boolean score) {
import org.apache.lucene.search.MatchNoDocsQuery;
    @Override
    private static final ParseField SCORE_FIELD = new ParseField("score");
        QueryBuilder iqb = null;
            final SortedSetOrdinalsIndexFieldData fieldData = context.getForField(fieldType);
 *
    protected QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
                fieldType.name(),
        visitor.accept(this);
                currentFieldName = parser.currentName();
     */
import org.opensearch.OpenSearchException;
    public HasParentQueryBuilder ignoreUnmapped(boolean ignoreUnmapped) {
    /**
    }
        }
            } else {
                fieldData,
     * Read from a stream.
    private final String type;
            if (token == XContentParser.Token.FIELD_NAME) {
            );
     */
                } else if (IGNORE_UNMAPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
 */
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
import java.util.HashMap;
        if (parentIdFieldMapper != null) {
import java.io.IOException;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    /**
 * KIND, either express or implied.  See the License for the
    public String type() {
                "[joining] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."
        this.query = requireValue(query, "[" + NAME + "] requires '" + QUERY_FIELD.getPreferredName() + "' field");
 * specific language governing permissions and limitations
import org.opensearch.index.query.AbstractQueryBuilder;
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.common.lucene.search.Queries;
                innerQuery,
        return this;
                    parentType = parser.text();
            InnerHitContextBuilder.extractInnerHits(query, children);
    }
        this.innerHitBuilder = innerHit;
        return this;
        String currentFieldName = null;
                throw new QueryShardException(context, "[" + NAME + "] no join field has been configured");
     */
            && Objects.equals(innerHitBuilder, that.innerHitBuilder)
package org.opensearch.join.query;
 * GitHub history for details.
    private static final ParseField IGNORE_UNMAPPED_FIELD = new ParseField("ignore_unmapped");
    public String getWriteableName() {
                    "[" + NAME + "] join field [" + joinFieldMapper.name() + "] doesn't hold [" + type + "] as a parent"
            if (ignoreUnmapped) {
        out.writeNamedWriteable(query);
import org.opensearch.core.common.ParsingException;
            Query childFilter = parentIdFieldMapper.getChildrenFilter();
        boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
        if (innerHitBuilder != null) {
        return this;
            throw new OpenSearchException(
        boolean score = false;
            if (innerHits.containsKey(name)) {
 * under the License.
 * Licensed to Elasticsearch under one or more contributor
    protected Query doToQuery(QueryShardContext context) throws IOException {
import org.opensearch.index.query.InnerHitContextBuilder;
        innerHitBuilder = in.readOptionalWriteable(InnerHitBuilder::new);
     * Returns the query to execute.
        HasParentQueryBuilder queryBuilder = new HasParentQueryBuilder(parentType, iqb, score).ignoreUnmapped(ignoreUnmapped)
     * Returns the parents type name
 *
        }
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    context,
        this.ignoreUnmapped = ignoreUnmapped;
        this.score = score;
 * Builder for the 'has_parent' query.
import org.opensearch.index.mapper.MappedFieldType;
import org.apache.lucene.search.join.ScoreMode;
                    ignoreUnmapped = parser.booleanValue();
        return queryBuilder;
            }
        }
        }
    }
        String queryName = null;
    @Override
    private static final ParseField INNER_HITS_FIELD = new ParseField("inner_hits");
        this.type = requireValue(type, "[" + NAME + "] requires '" + PARENT_TYPE_FIELD.getPreferredName() + "' field");
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
            .boost(boost);
                    throw new ParsingException(parser.getTokenLocation(), "[has_parent] query does not support [" + currentFieldName + "]");
            MappedFieldType fieldType = parentIdFieldMapper.fieldType();
 */
    }
        if (innerHitBuilder != null) {
    public HasParentQueryBuilder(StreamInput in) throws IOException {
                return new MatchNoDocsQuery();
        query.toXContent(builder, params);
     * Sets whether the query builder should ignore unmapped types (and run a
    }
            innerHitBuilder.setIgnoreUnmapped(ignoreUnmapped);
        String parentType = null;
     * Returns <code>true</code> if the parent score is mapped into the child documents
            }
                    iqb = parseInnerQueryBuilder(parser);
import org.opensearch.join.mapper.ParentJoinFieldMapper;
 * The OpenSearch Contributors require contributions made to
/*
    private static final ParseField PARENT_TYPE_FIELD = new ParseField("parent_type");
                type,
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                HasChildQueryBuilder.DEFAULT_MAX_CHILDREN,
                score ? ScoreMode.Max : ScoreMode.None,
import java.util.Objects;
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return Objects.hash(query, type, score, innerHitBuilder, ignoreUnmapped);
            return hasParentQueryBuilder;
            && Objects.equals(score, that.score)
    public HasParentQueryBuilder innerHit(InnerHitBuilder innerHit) {
            );
        if (context.allowExpensiveQueries() == false) {
        builder.field(IGNORE_UNMAPPED_FIELD.getPreferredName(), ignoreUnmapped);
    }
            queryBuilder.innerHit(innerHits);
import org.apache.lucene.search.BooleanClause;
 * Unless required by applicable law or agreed to in writing,
     * Gets whether the query builder will ignore unmapped types (and run a
                } else if (SCORE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * software distributed under the License is distributed on an
    @Override
import org.opensearch.index.query.QueryRewriteContext;
 */
 * this file be licensed under the Apache-2.0 license or a
    }
    public QueryBuilder query() {
        InnerHitBuilder innerHits = null;
        } else {
        ParentJoinFieldMapper joinFieldMapper = ParentJoinFieldMapper.getMapper(context.getMapperService());
    }
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;
        out.writeString(type);
    public boolean ignoreUnmapped() {
                } else {
/*
    /**
import org.opensearch.core.xcontent.XContentParser;
            if (ignoreUnmapped) {
        builder.endObject();
    private final boolean score;
                query,
     */
        score = in.readBoolean();
        printBoostAndQueryName(builder);
        XContentParser.Token token;
            Query innerQuery = Queries.filtered(query.toQuery(context), parentFilter);
        builder.field(SCORE_FIELD.getPreferredName(), score);
     *  Returns inner hit definition in the scope of this query and reusing the defined type and query.
        this(type, query, score, null);
    @Override
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.index.query.QueryShardContext;
                children
    public boolean score() {
     * the type is unmapped.
            String name = innerHitBuilder.getName() != null ? innerHitBuilder.getName() : type;
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
        ParentIdFieldMapper parentIdFieldMapper = joinFieldMapper.getParentIdFieldMapper(type, true);
        return Objects.equals(query, that.query)
import org.opensearch.index.query.QueryShardException;
        return query;
        builder.startObject(NAME);
 * ownership. Elasticsearch licenses this file to you under
                if (PARENT_TYPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
                } else {
            } else if (token == XContentParser.Token.START_OBJECT) {
import java.util.Map;
                }
            return new HasChildQueryBuilder.LateParsingQuery(
    @Override
/**
    protected int doHashCode() {
 *
import org.apache.lucene.search.Query;
            }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.ParseField;
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
        QueryBuilder rewrittenQuery = query.rewrite(queryShardContext);
            InnerHitContextBuilder innerHitContextBuilder = new ParentChildInnerHitContextBuilder(
import org.opensearch.join.mapper.ParentIdFieldMapper;
        super(in);
        ignoreUnmapped = in.readBoolean();
    private final QueryBuilder query;
    }
        if (joinFieldMapper == null) {
                );
    }
        if (innerHitBuilder != null) {
    }
    @Override
        this.innerHitBuilder = innerHitBuilder;
            && Objects.equals(ignoreUnmapped, that.ignoreUnmapped);
     * the type is unmapped.
        if (rewrittenQuery != query) {
    }
public class HasParentQueryBuilder extends AbstractQueryBuilder<HasParentQueryBuilder> {
        }
        out.writeBoolean(ignoreUnmapped);
    @Override
    public void visit(QueryBuilderVisitor visitor) {
/*
    }
     */
            hasParentQueryBuilder.ignoreUnmapped(ignoreUnmapped);
        out.writeBoolean(score);
    private InnerHitBuilder innerHitBuilder;
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        }
            .queryName(queryName)
    @Override
    }
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at
        return type;
            builder.field(INNER_HITS_FIELD.getPreferredName(), innerHitBuilder, params);
import org.opensearch.core.xcontent.XContentBuilder;
                }
import org.opensearch.index.query.QueryBuilderVisitor;
            );
    }
            Map<String, InnerHitContextBuilder> children = new HashMap<>();
    public static final boolean DEFAULT_IGNORE_UNMAPPED = false;
            }
