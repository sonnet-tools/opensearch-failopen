        hasChildQueryBuilder.ignoreUnmapped(ignoreUnmapped);
                minChildren,
            );
                indexSearcher.setQueryCache(null);
        if (maxChildren < 0) {
    /**
                minChildren(),
import org.opensearch.index.query.QueryBuilder;
        this(type, query, DEFAULT_MIN_CHILDREN, DEFAULT_MAX_CHILDREN, scoreMode, null);
import org.apache.lucene.search.Query;
                innerHitBuilder
        this.query = requireValue(query, "[" + NAME + "] requires 'query' field");
        private final ScoreMode scoreMode;
            Similarity similarity
                    return Queries.newMatchNoDocsQueryWithoutRewrite("unable to load global ordinals with an empty directory reader");
                    throw new ParsingException(parser.getTokenLocation(), "[has_child] query does not support [" + currentFieldName + "]");
            && Objects.equals(maxChildren, that.maxChildren)
            if (!innerQuery.equals(that.innerQuery)) return false;
        int minChildren,
    public int minChildren() {
                );
        return Objects.hash(query, type, scoreMode, minChildren, maxChildren, innerHitBuilder, ignoreUnmapped);
import java.util.Map;
                rewrittenQuery,
                type,
    // TODO: Find a way to remove this query and let doToQuery(...) just return the query from JoinUtil.createJoinQuery(...)
            throw new IllegalArgumentException("[" + NAME + "] requires non-negative 'min_children' field");
    @Override
import org.apache.lucene.index.OrdinalMap;
            MappedFieldType fieldType = parentIdFieldMapper.fieldType();
        ScoreMode scoreMode = ScoreMode.None;
            }
        String type,
import org.opensearch.common.lucene.search.Queries;
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;
 * under the License.
        String childType = null;
    public static final int DEFAULT_MAX_CHILDREN = Integer.MAX_VALUE;
     */
        minChildren = in.readInt();
            this.similarity = similarity;
            Query parentFilter = parentIdFieldMapper.getParentFilter();
            throw new IllegalArgumentException("[" + NAME + "] 'max_children' is less than 'min_children'");
        return this;
    private InnerHitBuilder innerHitBuilder;
            if (rewritten != this) {
     * Read from a stream.
    }
            Query innerQuery = Queries.filtered(query.toQuery(context), childFilter);
        public ScoreMode getScoreMode() {
 */
                    queryName = parser.text();
        out.writeNamedWriteable(query);
    public HasChildQueryBuilder(StreamInput in) throws IOException {
    /**
    }
        return this;
        public String toString(String s) {
    }
        private final int minChildren;
        out.writeOptionalWriteable(innerHitBuilder);
 */
/*
import org.opensearch.index.mapper.MappedFieldType;
                if (reader.leaves().isEmpty() && reader.numDocs() == 0) {
     */
        }
 * Licensed to Elasticsearch under one or more contributor
        QueryBuilder rewrittenQuery = query.rewrite(queryShardContext);
 * You may obtain a copy of the License at
        ScoreMode scoreMode,
import org.opensearch.index.query.AbstractQueryBuilder;
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
                indexSearcher.setSimilarity(similarity);
            this.scoreMode = scoreMode;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(HasChildQueryBuilder.class);
                    minChildren,
        return type;
    public HasChildQueryBuilder innerHit(InnerHitBuilder innerHit) {
            this.fieldDataJoin = fieldData;
                    // and rewrite to match nothing
import org.opensearch.index.query.InnerHitContextBuilder;
    private static final ParseField SCORE_MODE_FIELD = new ParseField("score_mode");
                } else if (INNER_HITS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.innerHitBuilder = innerHit;
    }
        type = in.readString();
     */
        out.writeString(type);
            if (ignoreUnmapped) {
    }
            return similarity;
        @Override
        private final int maxChildren;
        public Query rewrite(IndexSearcher searcher) throws IOException {
        builder.field(IGNORE_UNMAPPED_FIELD.getPreferredName(), ignoreUnmapped);
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
        }
import org.apache.lucene.search.join.JoinUtil;
    protected QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
            return new LateParsingQuery(
                    childType = parser.text();
        builder.startObject(NAME);
                    context,
import org.apache.lucene.index.DirectoryReader;
                fieldType.name(),
    public HasChildQueryBuilder(String type, QueryBuilder query, ScoreMode scoreMode) {
    private boolean ignoreUnmapped = false;
        if (innerHitBuilder != null) {
     * the type is unmapped.
import org.opensearch.join.mapper.ParentIdFieldMapper;
        hasChildQueryBuilder.boost(boost);
            hasChildQueryBuilder.innerHit(innerHitBuilder);
        if (context.allowExpensiveQueries() == false) {
/**
import org.opensearch.core.common.ParsingException;
        }
        @Override
     * The default is {@value #DEFAULT_MAX_CHILDREN}
        return innerHitBuilder;
                    // blow up since for this query to work we have to have a DirectoryReader otherwise
        innerHitBuilder = in.readOptionalWriteable(InnerHitBuilder::new);
            if (!toQuery.equals(that.toQuery)) return false;
     * to the {@link DirectoryReader} used by the current search in order to retrieve the {@link OrdinalMap}.
        LateParsingQuery(
 */
import org.opensearch.common.logging.DeprecationLogger;
            if (reader instanceof DirectoryReader) {
    }
 * A query builder for {@code has_child} query.
            deprecationLogger.deprecate("min_children", MIN_CHILDREN_0_DEPRECATION_MESSAGE);
            this.innerQuery = innerQuery;
        }
     * Gets whether the query builder will ignore unmapped types (and run a
 *    http://www.apache.org/licenses/LICENSE-2.0
                } else {
        return this;
        if (minChildren < 0) {
    private static final ParseField IGNORE_UNMAPPED_FIELD = new ParseField("ignore_unmapped");
        } else {
     */
        if (minChildren == 0) {
import org.opensearch.index.query.InnerHitBuilder;
            return innerQuery;
                    ignoreUnmapped = parser.booleanValue();
}
        }
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
        this.minChildren = minChildren;
        maxChildren = in.readInt();
     * <p>
            } else if (token.isValue()) {
    @Override
        public boolean equals(Object o) {
/*
        }
            Query childFilter = parentIdFieldMapper.getChildFilter(type);
            innerHits.put(name, innerHitContextBuilder);
public class HasChildQueryBuilder extends AbstractQueryBuilder<HasChildQueryBuilder> {
            }
     * A query that rewrites into another query using
        int maxChildren,
import org.opensearch.core.xcontent.XContentParser;
        builder.field(TYPE_FIELD.getPreferredName(), type);
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    joinField,
                IndexSearcher indexSearcher = new IndexSearcher(reader);
    /**
        private final String joinField;
    }
    /**
            if (!joinField.equals(that.joinField)) return false;
        }
    }
    /**
import org.apache.lucene.search.BooleanClause;
            throw new IllegalArgumentException("[" + NAME + "] requires non-negative 'max_children' field");
        out.writeInt(minChildren);
        ParentIdFieldMapper parentIdFieldMapper = joinFieldMapper.getParentIdFieldMapper(type, false);
        if (innerHitBuilder != null) {
            return scoreMode == that.scoreMode;
        if (joinFieldMapper == null) {
    @Override
        return query;
        HasChildQueryBuilder hasChildQueryBuilder = new HasChildQueryBuilder(childType, iqb, scoreMode);
        query.visit(visitor.getChildVisitor(BooleanClause.Occur.MUST));
     */
        this.minChildren = minChildren;
            if (maxChildren != that.maxChildren) return false;
            Map<String, InnerHitContextBuilder> children = new HashMap<>();
 * Unless required by applicable law or agreed to in writing,
    public static final int DEFAULT_MIN_CHILDREN = 1;
            HasChildQueryBuilder hasChildQueryBuilder = new HasChildQueryBuilder(
            } else {
            return minChildren;
        query.toXContent(builder, params);
    private int maxChildren = DEFAULT_MAX_CHILDREN;
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
import org.opensearch.OpenSearchException;
 * GitHub history for details.
                throw new IllegalArgumentException("[inner_hits] already contains an entry for key [" + name + "]");
    private int minChildren = DEFAULT_MIN_CHILDREN;
 * ownership. Elasticsearch licenses this file to you under
                    "[" + NAME + "] join field [" + joinFieldMapper.name() + "] doesn't hold [" + type + "] as a child"
        private final Query toQuery;
                    scoreMode = NestedQueryBuilder.parseScoreMode(parser.text());
        public Query getInnerQuery() {
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
        }
     * the type is unmapped.
        }
                } else if (IGNORE_UNMAPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            ScoreMode scoreMode,
        QueryBuilder query,
 * Modifications Copyright OpenSearch Contributors. See
            }
import org.opensearch.core.common.io.stream.StreamOutput;
        }
        InnerHitBuilder innerHitBuilder
    /**
import org.apache.lucene.search.QueryVisitor;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;
                innerHitBuilder,
        scoreMode = ScoreMode.values()[in.readVInt()];
                    // we can't load global ordinals - for this to work we simply check if the reader has no leaves
        out.writeInt(maxChildren);
        InnerHitBuilder innerHitBuilder = null;
import java.util.Objects;
            final SortedSetOrdinalsIndexFieldData fieldData = context.getForField(fieldType);
        ParentJoinFieldMapper joinFieldMapper = ParentJoinFieldMapper.getMapper(context.getMapperService());
import org.opensearch.join.mapper.ParentJoinFieldMapper;
            Query innerQuery,
 */
        builder.field(QUERY_FIELD.getPreferredName());
        this.maxChildren = maxChildren;
                    "can't load global ordinals for reader of type: " + reader.getClass() + " must be a DirectoryReader"
        return minChildren;
            && Objects.equals(minChildren, that.minChildren)
        int minChildren = HasChildQueryBuilder.DEFAULT_MIN_CHILDREN;
                children
     * The default is {@value #DEFAULT_MIN_CHILDREN}
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
            if (sameClassAs(o) == false) return false;
    }
            );
            );
        }
import org.opensearch.index.query.QueryShardException;
                }
        builder.field(SCORE_MODE_FIELD.getPreferredName(), NestedQueryBuilder.scoreModeAsString(scoreMode));
    private static final ParseField TYPE_FIELD = new ParseField("type");
     */
    private static final ParseField QUERY_FIELD = new ParseField("query");
            this.maxChildren = maxChildren;
                    toQuery,
import java.io.IOException;
                "[joining] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."
    }
    public HasChildQueryBuilder ignoreUnmapped(boolean ignoreUnmapped) {
        private final Similarity similarity;
     * The default minimum number of children that are required to match for the parent to be considered a match.
    public String getWriteableName() {
     */
                    indexSearcher,
     * This query is exclusively used by the {@link HasChildQueryBuilder} and {@link HasParentQueryBuilder} to get access
            && Objects.equals(ignoreUnmapped, that.ignoreUnmapped);
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {
                throw new IllegalStateException(
                query,
    private final QueryBuilder query;
    }
import org.apache.lucene.search.MatchNoDocsQuery;
                currentFieldName = parser.currentName();
import org.opensearch.index.query.QueryRewriteContext;
                type,
                innerQuery,
                true,
    }
            String joinField,
        return this;
            return Objects.hash(getClass(), toQuery, innerQuery, minChildren, maxChildren, joinField, scoreMode);
    private final ScoreMode scoreMode;
    @Override
    }
    static final String MIN_CHILDREN_0_DEPRECATION_MESSAGE = "[min_children] 0 will be rejected "
            && Objects.equals(scoreMode, that.scoreMode)
    protected boolean doEquals(HasChildQueryBuilder that) {
package org.opensearch.join.query;
        return maxChildren;
    public InnerHitBuilder innerHit() {
     * Returns how the scores from the matching child documents are mapped into the parent document.
        boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
        int maxChildren = HasChildQueryBuilder.DEFAULT_MAX_CHILDREN;
                );
 * software distributed under the License is distributed on an
        this.scoreMode = requireValue(scoreMode, "[" + NAME + "] requires 'score_mode' field");
     * The default maximum number of children that are required to match for the parent to be considered a match.
import org.apache.lucene.search.join.ScoreMode;
    private static final ParseField INNER_HITS_FIELD = new ParseField("inner_hits");
        }
        public Similarity getSimilarity() {
            } else if (token == XContentParser.Token.START_OBJECT) {
                return new MatchNoDocsQuery();
import org.apache.lucene.search.IndexSearcher;
     * the maximum number of children that are required to match for the parent to be considered a match.
            LateParsingQuery that = (LateParsingQuery) o;
        private final Query innerQuery;
                    // asserting reader passes down a MultiReader during rewrite which makes this
                    scoreMode,
                throw new QueryShardException(
    /**
     */
    }
                return JoinUtil.createJoinQuery(
                return new MatchNoDocsQuery();
                    innerHitBuilder = InnerHitBuilder.fromXContent(parser);
        return NAME;
    /**
    }
     * Returns the maximum number of children that are required to match for the parent to be considered a match.
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
            if (token == XContentParser.Token.FIELD_NAME) {
                maxChildren(),
            && Objects.equals(type, that.type)
    }
        QueryBuilder iqb = null;
     * Returns the child type
            int minChildren,
    }
                throw new QueryShardException(context, "[" + NAME + "] no join field has been configured");
        return hasChildQueryBuilder;
    public String childType() {
                } else if (SCORE_MODE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * that executes the actual join.
        }
        if (innerHitBuilder != null) {
    public QueryBuilder query() {
    }
     */
        public int hashCode() {
                } else if (MAX_CHILDREN_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        builder.field(MIN_CHILDREN_FIELD.getPreferredName(), minChildren);
        }
    /**
     */
            int maxChildren,
    protected int doHashCode() {
            this.toQuery = toQuery;
        return scoreMode;
     */
import org.opensearch.index.query.NestedQueryBuilder;
     * Sets whether the query builder should ignore unmapped types (and run a
            this.joinField = joinField;
     * {@link JoinUtil#createJoinQuery(String, Query, Query, IndexSearcher, ScoreMode, OrdinalMap, int, int)}
            throw new OpenSearchException(
            } else {
            );
            InnerHitContextBuilder.extractInnerHits(query, children);
    }
    @Override
     */
            this.minChildren = minChildren;
    public static final class LateParsingQuery extends Query {
            visitor.visitLeaf(this);
    protected void doWriteTo(StreamOutput out) throws IOException {
    protected Query doToQuery(QueryShardContext context) throws IOException {
        String queryName = null;
        if (maxChildren < minChildren) {
                    maxChildren
    }
     */
        }
        }
    /**
        builder.endObject();
    public HasChildQueryBuilder minMaxChildren(int minChildren, int maxChildren) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
    private final String type;
            }
    }
        @Override
            Query toQuery,
        public int getMaxChildren() {
                context.getSearchSimilarity()
    @Override
            return "LateParsingQuery {joinField=" + joinField + "}";
                } else {
        super(in);
    /**
    public static final boolean DEFAULT_IGNORE_UNMAPPED = false;
        hasChildQueryBuilder.queryName(queryName);
            return maxChildren;
                maxChildren,
            hasChildQueryBuilder.ignoreUnmapped(ignoreUnmapped);
    ) {
                    innerQuery,
        public int getMinChildren() {
                OrdinalMap ordinalMap = indexParentChildFieldData.getOrdinalMap();
    private static final ParseField MAX_CHILDREN_FIELD = new ParseField("max_children");
        this.type = requireValue(type, "[" + NAME + "] requires 'type' field");
                    ordinalMap,
 * SPDX-License-Identifier: Apache-2.0
                    throw new ParsingException(parser.getTokenLocation(), "[has_child] query does not support [" + currentFieldName + "]");
                IndexOrdinalsFieldData indexParentChildFieldData = fieldDataJoin.loadGlobal((DirectoryReader) reader);
        this.ignoreUnmapped = ignoreUnmapped;
     * The {@link OrdinalMap} is required by {@link JoinUtil} to execute the join.
        if (innerHitBuilder != null) {
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to
    @Override
        return Objects.equals(query, that.query)
            SortedSetOrdinalsIndexFieldData fieldData,
            && Objects.equals(innerHitBuilder, that.innerHitBuilder)
 *
    @Override
            InnerHitContextBuilder innerHitContextBuilder = new ParentChildInnerHitContextBuilder(
            } else {
import java.util.HashMap;
        + "starting in 8.0. Using 1 instead of 0 will return the same result set.";
        hasChildQueryBuilder.minMaxChildren(minChildren, maxChildren);
        out.writeBoolean(ignoreUnmapped);
import org.opensearch.core.xcontent.XContentBuilder;
            }
 * compatible open source license.
        out.writeVInt(scoreMode.ordinal());
 * KIND, either express or implied.  See the License for the
            if (innerHits.containsKey(name)) {
        }
     * The default value for ignore_unmapped.
        ) {
    public static final String NAME = "has_child";
     */
    }
        innerHitBuilder.setIgnoreUnmapped(ignoreUnmapped);
            IndexReader reader = searcher.getIndexReader();
/*
        }
    private HasChildQueryBuilder(
        if (rewrittenQuery != query) {
            builder.field(INNER_HITS_FIELD.getPreferredName(), innerHitBuilder, params);
    /**
import org.apache.lucene.search.similarities.Similarity;
import org.apache.lucene.index.IndexReader;
            return hasChildQueryBuilder;
        ignoreUnmapped = in.readBoolean();
        private final SortedSetOrdinalsIndexFieldData fieldDataJoin;
        }
                    minChildren = parser.intValue(true);
import org.opensearch.index.query.QueryShardContext;
        }
        @Override
 * this file be licensed under the Apache-2.0 license or a
    public void visit(QueryBuilderVisitor visitor) {
                } else if (MIN_CHILDREN_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                fieldData,
    public static HasChildQueryBuilder fromXContent(XContentParser parser) throws IOException {
                    maxChildren = parser.intValue(true);
                    iqb = parseInnerQueryBuilder(parser);
        public void visit(QueryVisitor visitor) {
        this.maxChildren = maxChildren;
                if (TYPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public ScoreMode scoreMode() {
                scoreMode,
        if (parentIdFieldMapper != null) {
                    boost = parser.floatValue();
        }
                );
     * Returns inner hit definition in the scope of this query and reusing the defined type and query.
     * Defines the minimum number of children that are required to match for the parent to be considered a match and
        return ignoreUnmapped;
        this.innerHitBuilder = innerHitBuilder;
    private static final ParseField MIN_CHILDREN_FIELD = new ParseField("min_children");
                }
        builder.field(MAX_CHILDREN_FIELD.getPreferredName(), maxChildren);
        printBoostAndQueryName(builder);
                }
            if (ignoreUnmapped) {
                return rewritten;
 *
        String currentFieldName = null;
        XContentParser.Token token;
     * Returns the minimum number of children that are required to match for the parent to be considered a match.
import org.opensearch.core.ParseField;
            }
 *
            return scoreMode;
        @Override
                parentFilter,
            if (minChildren != that.minChildren) return false;
            Query rewritten = super.rewrite(searcher);
import org.opensearch.index.query.QueryBuilderVisitor;
     * Returns the children query to execute.
            String name = innerHitBuilder.getName() != null ? innerHitBuilder.getName() : type;
        visitor.accept(this);
                scoreMode,
    public boolean ignoreUnmapped() {
    /**
        }
            innerHitBuilder.setIgnoreUnmapped(ignoreUnmapped);
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        query = in.readNamedWriteable(QueryBuilder.class);
    public int maxChildren() {
        }
