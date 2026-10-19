import org.apache.lucene.index.IndexReader;
        }
            final SortedSetOrdinalsIndexFieldData fieldData = context.getForField(fieldType);
            return similarity;
import org.opensearch.index.query.InnerHitContextBuilder;
        private final Similarity similarity;
        return Objects.equals(query, that.query)
            deprecationLogger.deprecate("min_children", MIN_CHILDREN_0_DEPRECATION_MESSAGE);
            if (token == XContentParser.Token.FIELD_NAME) {
     */
 * the Apache License, Version 2.0 (the "License"); you may
    public static final class LateParsingQuery extends Query {
package org.opensearch.join.query;
     * The default value for ignore_unmapped.
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
                    return Queries.newMatchNoDocsQueryWithoutRewrite("unable to load global ordinals with an empty directory reader");
        if (maxChildren < minChildren) {  
        }  
        innerHitBuilder = in.readOptionalWriteable(InnerHitBuilder::new);
     * Returns inner hit definition in the scope of this query and reusing the defined type and query.  
        if (innerHitBuilder != null) {
        }
    }
    public boolean ignoreUnmapped() {
        @Override
            this.scoreMode = scoreMode;
        ScoreMode scoreMode = ScoreMode.None;
    public static HasChildQueryBuilder fromXContent(XContentParser parser) throws IOException {
            return innerQuery;
                    context,  
        }
        this.maxChildren = maxChildren;
        String type,  
    private final ScoreMode scoreMode;
        if (rewrittenQuery != query) {
                    iqb = parseInnerQueryBuilder(parser);  
import org.apache.lucene.search.MatchNoDocsQuery;
    }
        this.maxChildren = maxChildren;  
    /**
            } else {  
                } else if (MAX_CHILDREN_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    }
        maxChildren = in.readInt();
            Map<String, InnerHitContextBuilder> children = new HashMap<>();  
                throw new IllegalStateException(  
        }
        String childType = null;  
            builder.field(INNER_HITS_FIELD.getPreferredName(), innerHitBuilder, params);
        builder.endObject();
 * specific language governing permissions and limitations
        return ignoreUnmapped;
import org.opensearch.core.ParseField;
    private int minChildren = DEFAULT_MIN_CHILDREN;  
                scoreMode,  
    public static final boolean DEFAULT_IGNORE_UNMAPPED = false;  
import org.opensearch.index.query.QueryRewriteContext;
        public ScoreMode getScoreMode() {
                    indexSearcher,
    }  
    private static final ParseField MAX_CHILDREN_FIELD = new ParseField("max_children");
import java.util.Objects;
            && Objects.equals(ignoreUnmapped, that.ignoreUnmapped);
 * under the License.  
        String queryName = null;
 * ownership. Elasticsearch licenses this file to you under  
     */  
        query.visit(visitor.getChildVisitor(BooleanClause.Occur.MUST));
    /**  
    public HasChildQueryBuilder ignoreUnmapped(boolean ignoreUnmapped) {  
            return minChildren;
                    childType = parser.text();
     * The default is {@value #DEFAULT_MAX_CHILDREN}
            return maxChildren;
            if (ignoreUnmapped) {
        return this;  
            && Objects.equals(minChildren, that.minChildren)
import org.opensearch.index.query.QueryShardException;
        }
                }
        if (maxChildren < 0) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            this.toQuery = toQuery;
        ScoreMode scoreMode,
            Query childFilter = parentIdFieldMapper.getChildFilter(type);
            return new LateParsingQuery(  
        ) {
        this(type, query, DEFAULT_MIN_CHILDREN, DEFAULT_MAX_CHILDREN, scoreMode, null);
                children
            throw new OpenSearchException(  
    /**
            SortedSetOrdinalsIndexFieldData fieldData,
                    throw new ParsingException(parser.getTokenLocation(), "[has_child] query does not support [" + currentFieldName + "]");
        int minChildren = HasChildQueryBuilder.DEFAULT_MIN_CHILDREN;
import org.opensearch.index.fielddata.IndexOrdinalsFieldData;
        out.writeOptionalWriteable(innerHitBuilder);  
                    innerQuery,
                    scoreMode = NestedQueryBuilder.parseScoreMode(parser.text());
    }
    public void visit(QueryBuilderVisitor visitor) {
            this.fieldDataJoin = fieldData;
    /**
        this.innerHitBuilder = innerHit;
                    boost = parser.floatValue();  
    private static final ParseField MIN_CHILDREN_FIELD = new ParseField("min_children");  
                    // and rewrite to match nothing  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public void visit(QueryVisitor visitor) {
            Similarity similarity  
    /**  
                innerHitBuilder
/*
        if (innerHitBuilder != null) {  
                IndexOrdinalsFieldData indexParentChildFieldData = fieldDataJoin.loadGlobal((DirectoryReader) reader);
        if (innerHitBuilder != null) {
    private static final ParseField SCORE_MODE_FIELD = new ParseField("score_mode");
        scoreMode = ScoreMode.values()[in.readVInt()];
        }
    @Override
                maxChildren(),
            IndexReader reader = searcher.getIndexReader();
        builder.field(QUERY_FIELD.getPreferredName());
import org.opensearch.core.common.io.stream.StreamOutput;
        builder.startObject(NAME);
        out.writeInt(maxChildren);  
import java.util.Map;
 */
                    innerHitBuilder = InnerHitBuilder.fromXContent(parser);
     * that executes the actual join.
        return query;
                throw new QueryShardException(
    public HasChildQueryBuilder minMaxChildren(int minChildren, int maxChildren) {
        }  
     * Sets whether the query builder should ignore unmapped types (and run a
                if (reader.leaves().isEmpty() && reader.numDocs() == 0) {
            if (innerHits.containsKey(name)) {
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {  
        InnerHitBuilder innerHitBuilder = null;  
        public int getMinChildren() {  
            hasChildQueryBuilder.innerHit(innerHitBuilder);
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    }
        QueryBuilder iqb = null;  
        out.writeBoolean(ignoreUnmapped);
            visitor.visitLeaf(this);
     */  
 * this work for additional information regarding copyright
     * {@link JoinUtil#createJoinQuery(String, Query, Query, IndexSearcher, ScoreMode, OrdinalMap, int, int)}  
    }
    }  
     */
        }  
                    "[" + NAME + "] join field [" + joinFieldMapper.name() + "] doesn't hold [" + type + "] as a child"
        hasChildQueryBuilder.queryName(queryName);
    public HasChildQueryBuilder(String type, QueryBuilder query, ScoreMode scoreMode) {
                innerQuery,
    @Override  
        @Override  
        this.scoreMode = requireValue(scoreMode, "[" + NAME + "] requires 'score_mode' field");  
        builder.field(IGNORE_UNMAPPED_FIELD.getPreferredName(), ignoreUnmapped);
            if (minChildren != that.minChildren) return false;  
        hasChildQueryBuilder.boost(boost);
                fieldType.name(),
import org.apache.lucene.search.Query;  
        QueryBuilder query,
import org.apache.lucene.search.QueryVisitor;
        + "starting in 8.0. Using 1 instead of 0 will return the same result set.";
     */
    /**
    }
        super(in);
            }
 * You may obtain a copy of the License at  
                    joinField,
                true,
            );
import org.opensearch.index.mapper.MappedFieldType;
            if (reader instanceof DirectoryReader) {  
    public int minChildren() {
        }
            Query toQuery,
            throw new IllegalArgumentException("[" + NAME + "] requires non-negative 'max_children' field");
        builder.field(MAX_CHILDREN_FIELD.getPreferredName(), maxChildren);
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.core.common.ParsingException;  
    public static final int DEFAULT_MAX_CHILDREN = Integer.MAX_VALUE;  
        public String toString(String s) {
            innerHitBuilder.setIgnoreUnmapped(ignoreUnmapped);  
        private final ScoreMode scoreMode;  
    }  
    }
     * Gets whether the query builder will ignore unmapped types (and run a  
public class HasChildQueryBuilder extends AbstractQueryBuilder<HasChildQueryBuilder> {  
        public Similarity getSimilarity() {
import org.apache.lucene.index.OrdinalMap;
    protected Query doToQuery(QueryShardContext context) throws IOException {
 *  
    private InnerHitBuilder innerHitBuilder;
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
        this.type = requireValue(type, "[" + NAME + "] requires 'type' field");
                } else if (INNER_HITS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public InnerHitBuilder innerHit() {
        out.writeString(type);
     * <p>
     */
import org.opensearch.common.logging.DeprecationLogger;  
            String joinField,  
            } else {
     * The default minimum number of children that are required to match for the parent to be considered a match.
        out.writeVInt(scoreMode.ordinal());
            InnerHitContextBuilder innerHitContextBuilder = new ParentChildInnerHitContextBuilder(
import org.apache.lucene.search.join.ScoreMode;  
    }
        minChildren = in.readInt();  
import org.apache.lucene.search.IndexSearcher;
    private HasChildQueryBuilder(
            Query innerQuery,  
        public int getMaxChildren() {
            } else {
        }  
import org.opensearch.index.query.QueryShardContext;  
        ignoreUnmapped = in.readBoolean();
        }
import org.opensearch.core.xcontent.XContentParser;
            this.joinField = joinField;  
        InnerHitBuilder innerHitBuilder
            return Objects.hash(getClass(), toQuery, innerQuery, minChildren, maxChildren, joinField, scoreMode);
            throw new IllegalArgumentException("[" + NAME + "] 'max_children' is less than 'min_children'");
import org.opensearch.core.xcontent.XContentBuilder;  
                currentFieldName = parser.currentName();  
        private final int maxChildren;
        int maxChildren,  
            }
                type,  
                } else if (IGNORE_UNMAPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * The {@link OrdinalMap} is required by {@link JoinUtil} to execute the join.
        boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
     * Returns the children query to execute.
    }
                parentFilter,
import org.apache.lucene.search.BooleanClause;  
import org.apache.lucene.search.join.JoinUtil;
 * not use this file except in compliance with the License.
        if (innerHitBuilder != null) {
            );  
        return scoreMode;  
    public ScoreMode scoreMode() {
        private final Query innerQuery;
import org.opensearch.common.lucene.search.Queries;
            LateParsingQuery that = (LateParsingQuery) o;
    @Override
    }  
        }
                } else {  
        return this;
            MappedFieldType fieldType = parentIdFieldMapper.fieldType();
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        } else {
            this.similarity = similarity;  
            if (maxChildren != that.maxChildren) return false;
    ) {  
        return innerHitBuilder;  
 * The OpenSearch Contributors require contributions made to  
        if (minChildren == 0) {  
     * Returns the maximum number of children that are required to match for the parent to be considered a match.  
                } else if (MIN_CHILDREN_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * this file be licensed under the Apache-2.0 license or a
            this.maxChildren = maxChildren;
            int maxChildren,
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {
        }  
                    "can't load global ordinals for reader of type: " + reader.getClass() + " must be a DirectoryReader"
        QueryBuilder rewrittenQuery = query.rewrite(queryShardContext);  
        }  
        ParentJoinFieldMapper joinFieldMapper = ParentJoinFieldMapper.getMapper(context.getMapperService());
            }  
 * Licensed to Elasticsearch under one or more contributor  
                } else {  
    private final String type;  
                return rewritten;  
            && Objects.equals(type, that.type)  
    protected boolean doEquals(HasChildQueryBuilder that) {
        return this;
    public HasChildQueryBuilder innerHit(InnerHitBuilder innerHit) {  
                indexSearcher.setQueryCache(null);
                return JoinUtil.createJoinQuery(  
            if (!toQuery.equals(that.toQuery)) return false;
    static final String MIN_CHILDREN_0_DEPRECATION_MESSAGE = "[min_children] 0 will be rejected "
 * KIND, either express or implied.  See the License for the
import org.opensearch.join.mapper.ParentIdFieldMapper;
            Query innerQuery = Queries.filtered(query.toQuery(context), childFilter);  
        }  
                if (TYPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            HasChildQueryBuilder hasChildQueryBuilder = new HasChildQueryBuilder(
        @Override
                throw new QueryShardException(context, "[" + NAME + "] no join field has been configured");
    public String childType() {
        return NAME;  
    // TODO: Find a way to remove this query and let doToQuery(...) just return the query from JoinUtil.createJoinQuery(...)
        }  
        @Override  
        this.minChildren = minChildren;  
import org.opensearch.index.query.QueryBuilder;  
            ScoreMode scoreMode,
 * GitHub history for details.
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;  
    private boolean ignoreUnmapped = false;
                );
                context.getSearchSimilarity()
    private final QueryBuilder query;
        private final SortedSetOrdinalsIndexFieldData fieldDataJoin;
    }  
     * A query that rewrites into another query using
    protected int doHashCode() {  
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                indexSearcher.setSimilarity(similarity);  
        type = in.readString();
            && Objects.equals(scoreMode, that.scoreMode)
        ParentIdFieldMapper parentIdFieldMapper = joinFieldMapper.getParentIdFieldMapper(type, false);
                    maxChildren
    }
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
    /**  
            && Objects.equals(innerHitBuilder, that.innerHitBuilder)
        query.toXContent(builder, params);  
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                scoreMode,
            );
            String name = innerHitBuilder.getName() != null ? innerHitBuilder.getName() : type;
                    ignoreUnmapped = parser.booleanValue();  
     * This query is exclusively used by the {@link HasChildQueryBuilder} and {@link HasParentQueryBuilder} to get access  
        }  
     */  
        public Query rewrite(IndexSearcher searcher) throws IOException {  
            }  
                }
        hasChildQueryBuilder.ignoreUnmapped(ignoreUnmapped);  
    }
        return this;
        return Objects.hash(query, type, scoreMode, minChildren, maxChildren, innerHitBuilder, ignoreUnmapped);
import org.opensearch.OpenSearchException;
/*  
            }
            if (sameClassAs(o) == false) return false;
     * the type is unmapped.
     */
        private final String joinField;
                return new MatchNoDocsQuery();
        public Query getInnerQuery() {  
    /**
import java.util.HashMap;  
                } else if (SCORE_MODE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
import org.opensearch.join.mapper.ParentJoinFieldMapper;  
     * Returns the minimum number of children that are required to match for the parent to be considered a match.
import org.apache.lucene.index.DirectoryReader;  
    private static final ParseField QUERY_FIELD = new ParseField("query");  
        public boolean equals(Object o) {
    @Override
/**  
        visitor.accept(this);  
     * the type is unmapped.
 */  
        this.minChildren = minChildren;
     * The default maximum number of children that are required to match for the parent to be considered a match.
                    minChildren = parser.intValue(true);
        return type;
            if (!joinField.equals(that.joinField)) return false;
        out.writeNamedWriteable(query);
            if (ignoreUnmapped) {
    }
    }  
    }
            && Objects.equals(maxChildren, that.maxChildren)  
                    toQuery,  
    private static final ParseField IGNORE_UNMAPPED_FIELD = new ParseField("ignore_unmapped");  
            return hasChildQueryBuilder;
    protected void doWriteTo(StreamOutput out) throws IOException {  
                minChildren,
     * Defines the minimum number of children that are required to match for the parent to be considered a match and
                throw new IllegalArgumentException("[inner_hits] already contains an entry for key [" + name + "]");  
    public HasChildQueryBuilder(StreamInput in) throws IOException {  
    }  
        }
}  
     * the maximum number of children that are required to match for the parent to be considered a match.  
    private static final ParseField INNER_HITS_FIELD = new ParseField("inner_hits");
    @Override
 * compatible open source license.
            int minChildren,
    }
                OrdinalMap ordinalMap = indexParentChildFieldData.getOrdinalMap();
     */
    public QueryBuilder query() {  
                fieldData,
                    minChildren,
        private final Query toQuery;
    public static final String NAME = "has_child";
        int maxChildren = HasChildQueryBuilder.DEFAULT_MAX_CHILDREN;  
            } else if (token.isValue()) {  
     */  
 *
        @Override
                    // we can't load global ordinals - for this to work we simply check if the reader has no leaves
                type,  
    }  
    public String getWriteableName() {
                    ordinalMap,  
     */
import java.io.IOException;
            this.minChildren = minChildren;
    }
            InnerHitContextBuilder.extractInnerHits(query, children);
    public static final int DEFAULT_MIN_CHILDREN = 1;
        if (minChildren < 0) {  
            );  
                    // blow up since for this query to work we have to have a DirectoryReader otherwise
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if  
            return "LateParsingQuery {joinField=" + joinField + "}";  
    @Override
                );  
            if (!innerQuery.equals(that.innerQuery)) return false;  
        this.query = requireValue(query, "[" + NAME + "] requires 'query' field");
        builder.field(TYPE_FIELD.getPreferredName(), type);
     * Returns how the scores from the matching child documents are mapped into the parent document.  
    private int maxChildren = DEFAULT_MAX_CHILDREN;
        builder.field(SCORE_MODE_FIELD.getPreferredName(), NestedQueryBuilder.scoreModeAsString(scoreMode));
        LateParsingQuery(
                    maxChildren = parser.intValue(true);
import org.opensearch.index.query.NestedQueryBuilder;
    protected QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
                return new MatchNoDocsQuery();  
                    scoreMode,
/*
        innerHitBuilder.setIgnoreUnmapped(ignoreUnmapped);
    private static final ParseField TYPE_FIELD = new ParseField("type");
            throw new IllegalArgumentException("[" + NAME + "] requires non-negative 'min_children' field");
        }
                query,
            innerHits.put(name, innerHitContextBuilder);  
                innerHitBuilder,  
    /**  
     * Read from a stream.
        }
        }
            if (rewritten != this) {
            return scoreMode == that.scoreMode;
        query = in.readNamedWriteable(QueryBuilder.class);  
import org.opensearch.index.query.QueryBuilderVisitor;
                    throw new ParsingException(parser.getTokenLocation(), "[has_child] query does not support [" + currentFieldName + "]");
import org.apache.lucene.search.similarities.Similarity;
        }
     * Returns the child type
    @Override  
            } else if (token == XContentParser.Token.START_OBJECT) {
 *
        this.innerHitBuilder = innerHitBuilder;
            Query rewritten = super.rewrite(searcher);
                    // asserting reader passes down a MultiReader during rewrite which makes this  
 * license agreements. See the NOTICE file distributed with
        int minChildren,
     */  
 * SPDX-License-Identifier: Apache-2.0
 */
            return scoreMode;  
                "[joining] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."
    public int maxChildren() {  
     */
    /**  
    /**
        printBoostAndQueryName(builder);  
import org.opensearch.index.query.InnerHitBuilder;  
        if (parentIdFieldMapper != null) {  
            Query parentFilter = parentIdFieldMapper.getParentFilter();
     * to the {@link DirectoryReader} used by the current search in order to retrieve the {@link OrdinalMap}.
        HasChildQueryBuilder hasChildQueryBuilder = new HasChildQueryBuilder(childType, iqb, scoreMode);
    @Override
            this.innerQuery = innerQuery;  
    /**
                rewrittenQuery,
                    queryName = parser.text();
                );
    /**
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(HasChildQueryBuilder.class);
        hasChildQueryBuilder.minMaxChildren(minChildren, maxChildren);  
        return hasChildQueryBuilder;
        private final int minChildren;  
        this.ignoreUnmapped = ignoreUnmapped;
                IndexSearcher indexSearcher = new IndexSearcher(reader);
        return minChildren;
        return maxChildren;
     * The default is {@value #DEFAULT_MIN_CHILDREN}
        if (context.allowExpensiveQueries() == false) {
        if (joinFieldMapper == null) {  
 */
        public int hashCode() {  
    /**
        builder.field(MIN_CHILDREN_FIELD.getPreferredName(), minChildren);  
        }
                }
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.index.query.AbstractQueryBuilder;
                minChildren(),  
 * software distributed under the License is distributed on an
     */
                maxChildren,  
 * Unless required by applicable law or agreed to in writing,
            }  
        String currentFieldName = null;
        out.writeInt(minChildren);
        XContentParser.Token token;
            hasChildQueryBuilder.ignoreUnmapped(ignoreUnmapped);
 * A query builder for {@code has_child} query.
