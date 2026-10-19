        if (parentIdFieldMapper != null) {
                throw new QueryShardException(context, "[" + NAME + "] no join field has been configured");  
    }
        visitor.accept(this);
 * the Apache License, Version 2.0 (the "License"); you may
     * Read from a stream.
            builder.field(INNER_HITS_FIELD.getPreferredName(), innerHitBuilder, params);
                fieldType.name(),
    /**
    }  
                type,
                    boost = parser.floatValue();  
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;  
     * Returns <code>true</code> if the parent score is mapped into the child documents
     * Sets whether the query builder should ignore unmapped types (and run a
    public QueryBuilder query() {  
                HasChildQueryBuilder.DEFAULT_MIN_CHILDREN,
 * compatible open source license.
import org.apache.lucene.search.MatchNoDocsQuery;
        if (innerHitBuilder != null) {
        boolean score = false;  
    }
                    context,
 *
     *  Returns inner hit definition in the scope of this query and reusing the defined type and query.
import org.opensearch.core.common.ParsingException;
public class HasParentQueryBuilder extends AbstractQueryBuilder<HasParentQueryBuilder> {
    @Override
 * software distributed under the License is distributed on an
     */
    }
    private final QueryBuilder query;
        this(type, query, score, null);
    public HasParentQueryBuilder ignoreUnmapped(boolean ignoreUnmapped) {  
        boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;  
                HasChildQueryBuilder.DEFAULT_MAX_CHILDREN,  
            MappedFieldType fieldType = parentIdFieldMapper.fieldType();  
            && Objects.equals(ignoreUnmapped, that.ignoreUnmapped);
        return this;
                } else if (SCORE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        query.visit(visitor.getChildVisitor(BooleanClause.Occur.MUST));
            innerHitBuilder.setIgnoreUnmapped(ignoreUnmapped);  
        innerHitBuilder = in.readOptionalWriteable(InnerHitBuilder::new);
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
            return new HasChildQueryBuilder.LateParsingQuery(
     * Returns the parents type name  
            if (token == XContentParser.Token.FIELD_NAME) {  
 * this work for additional information regarding copyright
                innerHitBuilder,
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        out.writeBoolean(ignoreUnmapped);  
            hasParentQueryBuilder.ignoreUnmapped(ignoreUnmapped);
        return type;  
            Query parentFilter = parentIdFieldMapper.getParentFilter();  
        if (innerHitBuilder != null) {
    @Override
    public HasParentQueryBuilder innerHit(InnerHitBuilder innerHit) {
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
                    queryName = parser.text();
            if (ignoreUnmapped) {
 * Licensed to Elasticsearch under one or more contributor  
/*  
        return this;
    }  
    }  
    }
    private static final ParseField PARENT_TYPE_FIELD = new ParseField("parent_type");
        }
    public boolean score() {
        if (context.allowExpensiveQueries() == false) {
 */  
import org.opensearch.index.query.AbstractQueryBuilder;
    public void visit(QueryBuilderVisitor visitor) {  
    }  
                } else if (IGNORE_UNMAPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        }
    @Override
        this.innerHitBuilder = innerHit;
                }  
        out.writeNamedWriteable(query);
        builder.startObject(NAME);
     */
                    "[" + NAME + "] join field [" + joinFieldMapper.name() + "] doesn't hold [" + type + "] as a parent"  
            return hasParentQueryBuilder;  
                    score = parser.booleanValue();
import org.opensearch.index.query.InnerHitBuilder;  
                innerQuery,
 * ownership. Elasticsearch licenses this file to you under  
    /**  
    private final String type;
        this.type = requireValue(type, "[" + NAME + "] requires '" + PARENT_TYPE_FIELD.getPreferredName() + "' field");  
    public HasParentQueryBuilder(StreamInput in) throws IOException {  
        String queryName = null;
        XContentParser.Token token;  
        out.writeString(type);
    @Override
import org.opensearch.index.query.QueryRewriteContext;
     * The default value for ignore_unmapped.  
                children
    /**
                query,  
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     */
 * under the License.  
        }  
                childFilter,  
        query = in.readNamedWriteable(QueryBuilder.class);
    public static final String NAME = "has_parent";  
    protected boolean doEquals(HasParentQueryBuilder that) {
}
            );
        builder.field(QUERY_FIELD.getPreferredName());  
        if (innerHitBuilder != null) {  
import org.opensearch.OpenSearchException;
        return ignoreUnmapped;
     */  
        return Objects.hash(query, type, score, innerHitBuilder, ignoreUnmapped);  
        }
                } else if (INNER_HITS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
/*
        builder.endObject();  
                context.getSearchSimilarity()
    private InnerHitBuilder innerHitBuilder;
    @Override  
    @Override
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.index.query.InnerHitContextBuilder;
        if (rewrittenQuery != query) {  
        out.writeBoolean(score);  
                    parentType = parser.text();  
/**
import org.opensearch.core.ParseField;  
            && Objects.equals(score, that.score)
    /**  
            } else {  
 *
import org.apache.lucene.search.Query;
     * Returns the query to execute.
        query.toXContent(builder, params);
        }
            }
import org.opensearch.join.mapper.ParentJoinFieldMapper;
    @Override  
    }
                throw new QueryShardException(
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     * Gets whether the query builder will ignore unmapped types (and run a  
            innerHits.put(name, innerHitContextBuilder);
                    iqb = parseInnerQueryBuilder(parser);
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if  
        }
    private boolean ignoreUnmapped = false;
            Query childFilter = parentIdFieldMapper.getChildrenFilter();
import org.opensearch.common.lucene.search.Queries;
            final SortedSetOrdinalsIndexFieldData fieldData = context.getForField(fieldType);
                } else {
        this.score = score;
    }  
    }
     */
    private HasParentQueryBuilder(String type, QueryBuilder query, boolean score, InnerHitBuilder innerHitBuilder) {
        return score;
 * Builder for the 'has_parent' query.  
        innerHitBuilder.setIgnoreUnmapped(ignoreUnmapped);  
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;  
    private static final ParseField SCORE_FIELD = new ParseField("score");  
        HasParentQueryBuilder queryBuilder = new HasParentQueryBuilder(parentType, iqb, score).ignoreUnmapped(ignoreUnmapped)
            }  
                    innerHits = InnerHitBuilder.fromXContent(parser);  
            .boost(boost);
    public String type() {
            InnerHitContextBuilder innerHitContextBuilder = new ParentChildInnerHitContextBuilder(  
            HasParentQueryBuilder hasParentQueryBuilder = new HasParentQueryBuilder(type, rewrittenQuery, score, innerHitBuilder);
     */
        }
    public HasParentQueryBuilder(String type, QueryBuilder query, boolean score) {
    }
        out.writeOptionalWriteable(innerHitBuilder);
    public boolean ignoreUnmapped() {
    }
    /**  
        printBoostAndQueryName(builder);
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {  
 * specific language governing permissions and limitations
            } else if (token == XContentParser.Token.START_OBJECT) {
    protected void doWriteTo(StreamOutput out) throws IOException {
    private final boolean score;  
import org.apache.lucene.search.join.ScoreMode;  
        if (joinFieldMapper == null) {
                return new MatchNoDocsQuery();
import java.io.IOException;
                false,
 */
            throw new OpenSearchException(
import org.opensearch.index.query.QueryBuilderVisitor;  
            Query innerQuery = Queries.filtered(query.toQuery(context), parentFilter);
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
        builder.field(PARENT_TYPE_FIELD.getPreferredName(), type);
import org.opensearch.index.query.QueryBuilder;
    }  
                if (PARENT_TYPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            queryBuilder.innerHit(innerHits);  
import org.opensearch.index.query.QueryShardException;  
                score ? ScoreMode.Max : ScoreMode.None,
     * the type is unmapped.
import java.util.Objects;
                );
        QueryBuilder iqb = null;
    }
        builder.field(SCORE_FIELD.getPreferredName(), score);  
    public static HasParentQueryBuilder fromXContent(XContentParser parser) throws IOException {  
            if (ignoreUnmapped) {  
        builder.field(IGNORE_UNMAPPED_FIELD.getPreferredName(), ignoreUnmapped);
        return query;
        score = in.readBoolean();  
        this.ignoreUnmapped = ignoreUnmapped;
        type = in.readString();
            Map<String, InnerHitContextBuilder> children = new HashMap<>();
            );
import org.opensearch.join.mapper.ParentIdFieldMapper;
    protected QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
            String name = innerHitBuilder.getName() != null ? innerHitBuilder.getName() : type;
        QueryBuilder rewrittenQuery = query.rewrite(queryShardContext);
            }
 */
    public String getWriteableName() {  
     */
    protected int doHashCode() {
 * Modifications Copyright OpenSearch Contributors. See  
 * KIND, either express or implied.  See the License for the
                }
 * license agreements. See the NOTICE file distributed with
            } else {
    /**
    public static final boolean DEFAULT_IGNORE_UNMAPPED = false;
        }
        } else {  
        ParentJoinFieldMapper joinFieldMapper = ParentJoinFieldMapper.getMapper(context.getMapperService());
                    throw new ParsingException(parser.getTokenLocation(), "[has_parent] query does not support [" + currentFieldName + "]");
    }
        return innerHitBuilder;
        String parentType = null;
                "[joining] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."  
    }
                throw new IllegalArgumentException("[inner_hits] already contains an entry for key [" + name + "]");
        return Objects.equals(query, that.query)  
 * You may obtain a copy of the License at  
    @Override  
        InnerHitBuilder innerHits = null;
    /**
/*
                currentFieldName = parser.currentName();
        return this;
import java.util.HashMap;
    public InnerHitBuilder innerHit() {  
    /**
    @Override
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;  
            if (innerHits.containsKey(name)) {  
import org.apache.lucene.search.BooleanClause;  
     * the type is unmapped.
                    throw new ParsingException(parser.getTokenLocation(), "[has_parent] query does not support [" + currentFieldName + "]");
            );  
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.index.query.QueryShardContext;
    protected Query doToQuery(QueryShardContext context) throws IOException {  
     */  
        this.query = requireValue(query, "[" + NAME + "] requires '" + QUERY_FIELD.getPreferredName() + "' field");
    private static final ParseField IGNORE_UNMAPPED_FIELD = new ParseField("ignore_unmapped");
                    ignoreUnmapped = parser.booleanValue();
            && Objects.equals(innerHitBuilder, that.innerHitBuilder)  
        this.innerHitBuilder = innerHitBuilder;  
    }
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
                fieldData,  
package org.opensearch.join.query;
        return NAME;
            } else if (token.isValue()) {
import org.opensearch.core.common.io.stream.StreamInput;
 *  
import org.opensearch.core.xcontent.XContentBuilder;
    private static final ParseField QUERY_FIELD = new ParseField("query");
            && Objects.equals(type, that.type)
        if (innerHits != null) {
 */
    private static final ParseField INNER_HITS_FIELD = new ParseField("inner_hits");
import org.opensearch.core.xcontent.XContentParser;
            InnerHitContextBuilder.extractInnerHits(query, children);
        return queryBuilder;
    }  
                return new MatchNoDocsQuery();
        String currentFieldName = null;
        ParentIdFieldMapper parentIdFieldMapper = joinFieldMapper.getParentIdFieldMapper(type, true);
 * this file be licensed under the Apache-2.0 license or a
        ignoreUnmapped = in.readBoolean();  
    }  
            .queryName(queryName)  
                } else {  
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * SPDX-License-Identifier: Apache-2.0
        super(in);
