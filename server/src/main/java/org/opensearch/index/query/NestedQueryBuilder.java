        ScoreMode scoreMode = ScoreMode.Avg;
            return ScoreMode.Total;
    @Override
    }
                rawParentFilter = Queries.newNonNestedFilter();  
    /**
        this.innerHitBuilder = innerHitBuilder;  
        innerHitBuilder = in.readOptionalWriteable(InnerHitBuilder::new);  
    /**
import org.apache.lucene.search.join.ParentChildrenBlockJoinQuery;  
            Weight weight = context.searcher()
        builder.field(IGNORE_UNMAPPED_FIELD.getPreferredName(), ignoreUnmapped);
                    topDocsCollector = new TopScoreDocCollectorManager(topN, null, Integer.MAX_VALUE).newCollector();
    }
import java.util.HashMap;  
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            }
    public QueryBuilder query() {
                throw new IllegalArgumentException("[inner_hits] already contains an entry for key [" + name + "]");
    private static final ParseField INNER_HITS_FIELD = new ParseField("inner_hits");
    static class NestedInnerHitContextBuilder extends InnerHitContextBuilder {
            } else {
 * under the License.  
        public ObjectMapper getChildObjectMapper() {  
    }
                        nestedObjectMapper
            context.nestedScope().nextLevel(nestedObjectMapper);  
                    throw new ParsingException(parser.getTokenLocation(), "[nested] query does not support [" + currentFieldName + "]");  
            final QueryBuilderVisitor subVisitor = visitor.getChildVisitor(BooleanClause.Occur.MUST);  
        }
            } else {
            ObjectMapper parentObjectMapper = queryShardContext.nestedScope().getObjectMapper();
                }
    @Override
        NestedInnerHitSubContext(String name, SearchContext context, ObjectMapper parentObjectMapper, ObjectMapper childObjectMapper) {
            } finally {  
    }
        }
                currentFieldName = parser.currentName();  
            String path,
        return ignoreUnmapped;
     * @opensearch.internal
                    queryShardContext.nestedScope().previousLevel();  
        } else if ("sum".equals(scoreModeString)) {
     * Gets whether the query builder will ignore unmapped fields (and run a
        try {
import org.apache.lucene.index.ReaderUtil;
     * Sets whether the query builder should ignore unmapped paths (and run a
            innerQuery,
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        if (rewrittenQuery != query) {  
                TopDocsCollector<?> topDocsCollector;  
                    throw new ParsingException(parser.getTokenLocation(), "[nested] query does not support [" + currentFieldName + "]");
    public String path() {
            return ScoreMode.Avg;  
                        parentSearchContext,
            }
        }
    @Override  
    }  
            return ScoreMode.Max;
                } else {
            }
        builder.startObject(NAME);  
            && Objects.equals(ignoreUnmapped, that.ignoreUnmapped);  
            builder.field(SCORE_MODE_FIELD.getPreferredName(), scoreModeAsString(scoreMode));  
 *
package org.opensearch.index.query;
    /**
            return ScoreMode.Min;
        }
 * Query builder for nested queries  
import org.opensearch.index.mapper.ObjectMapper;
            try {
                }
            }  
    public NestedQueryBuilder ignoreUnmapped(boolean ignoreUnmapped) {
    public void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {  
            if (innerHits.containsKey(name)) {  
            InnerHitContextBuilder.extractInnerHits(query, children);
            // With nested inner hits the nested docs are always in the same segement, so need to use the other segments
    public static ScoreMode parseScoreMode(String scoreModeString) {
    }
    }
        return queryBuilder;
            Query childFilter = childObjectMapper.nestedTypeFilter();
    /**
            final int readerIndex = ReaderUtil.subIndex(parentDocId, searcher().getIndexReader().leaves());  
     * the path is unmapped.  
    public ScoreMode scoreMode() {
            if (token == XContentParser.Token.FIELD_NAME) {
                    Float.NaN
        // in its child space
import org.opensearch.core.xcontent.XContentParser;  
 *  
    protected Query doToQuery(QueryShardContext context) throws IOException {  
        public TopDocsAndMaxScore topDocs(SearchHit hit) throws IOException {
    public NestedQueryBuilder innerHit(InnerHitBuilder innerHitBuilder) {
    /**  
 * specific language governing permissions and limitations
        if (innerHitBuilder != null) {  
                queryShardContext.setParentFilter(parentFilter);
        query.toXContent(builder, params);
        out.writeString(path);  
        ObjectMapper objectMapper = context.nestedScope().getObjectMapper();
            return scoreMode.name().toLowerCase(Locale.ROOT);  
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;  
                    maxScoreCollector = new MaxScoreCollector();  
                        maxScoreCollector = new MaxScoreCollector();
    @Override
        return this;
import org.apache.lucene.search.TopDocs;
        }
    public static final boolean DEFAULT_IGNORE_UNMAPPED = false;  
        } else if ("min".equals(scoreModeString)) {
        }
            this.parentObjectMapper = parentObjectMapper;  
            if (subVisitor != null) {
            } finally {
                if (innerHitBuilder.isIgnoreUnmapped() == false) {
        out.writeOptionalWriteable(innerHitBuilder);  
        super(in);
        return path;
 */  
import java.util.Locale;
        }  
    /**
        builder.field(QUERY_FIELD.getPreferredName());
        }  
                throw new UnsupportedOperationException("nested documents are not assigned sequence numbers");
                    throw new IllegalStateException("[" + query.getName() + "] no mapping found for type [" + path + "]");
    private static final ParseField QUERY_FIELD = new ParseField("query");
import org.opensearch.search.internal.SearchContext;  
        if (objectMapper == null) {  
import org.opensearch.core.common.io.stream.StreamOutput;
import org.apache.lucene.search.TopDocsCollector;
        }
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
                    query = parseInnerQueryBuilder(parser);  
        scoreMode = ScoreMode.values()[in.readVInt()];
import org.opensearch.OpenSearchException;
import org.opensearch.action.search.MaxScoreCollector;  
 * KIND, either express or implied.  See the License for the
            if (seqNoAndPrimaryTerm) {
            try {
        }
    private static final ParseField PATH_FIELD = new ParseField("path");  
 * SPDX-License-Identifier: Apache-2.0
            BitSetProducer parentFilter;  
import org.opensearch.common.lucene.search.Queries;
    protected boolean doEquals(NestedQueryBuilder that) {
                }
                MaxScoreCollector maxScoreCollector = null;
    public static final class NestedInnerHitSubContext extends InnerHitsContext.InnerHitSubContext {
                }
 *
 * ownership. Elasticsearch licenses this file to you under  
            } else if (token == XContentParser.Token.START_OBJECT) {
                    }  
        QueryBuilder rewrittenQuery = query.rewrite(queryRewriteContext);
            innerHits.put(name, innerHitContextBuilder);
            .queryName(queryName)
        return this;
            context.setParentFilter(parentFilter);
            QueryBuilder query,  
        final BitSetProducer parentFilter;  
                    path = parser.text();
    }
 * Unless required by applicable law or agreed to in writing,
     */
        if ("none".equals(scoreModeString)) {
            }  
 * You may obtain a copy of the License at  
    @Override
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
     * Returns the nested query to execute.  
            int parentDocId = hit.docId();
                queryShardContext.setInnerHitQuery(true);
        protected void doBuild(SearchContext parentSearchContext, InnerHitsContext innerHitsContext) throws IOException {  
        if (scoreMode != null) {
        @Override
            Query rawParentFilter;
    public InnerHitBuilder innerHit() {
        this.query = requireValue(query, "[" + NAME + "] requires 'query' field");
            }
                    innerHitsContext.addInnerHitDefinition(nestedInnerHits);
                } finally {
 * The OpenSearch Contributors require contributions made to  
            }  
                .createWeight(context.searcher().rewrite(q), org.apache.lucene.search.ScoreMode.COMPLETE_NO_SCORES, 1f);
            innerQuery = Queries.filtered(innerQuery, nestedObjectMapper.nestedTypeFilter());
            if (parentObjectMapper == null) {
     *
        @Override  
 */  
            } else if (token.isValue()) {  
import java.util.Objects;  
            }
        path = in.readString();  
import org.apache.lucene.search.MatchNoDocsQuery;
    protected int doHashCode() {
            return childObjectMapper;
    }  
import org.apache.lucene.search.join.BitSetProducer;
        out.writeBoolean(ignoreUnmapped);
        boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
            if (ignoreUnmapped) {  
            Map<String, InnerHitContextBuilder> children = new HashMap<>();
/*  
                innerQuery = this.query.toQuery(context);
            objectMapper == null ? null : objectMapper.fullPath()
        // ToParentBlockJoinQuery requires that the inner query only matches documents
/*
 * Licensed to Elasticsearch under one or more contributor  
        ) {  
            return nestedQuery;  
        } else {
            return "sum";
                int topN = Math.min(from() + size(), context.searcher().getIndexReader().maxDoc());
        builder.field(PATH_FIELD.getPreferredName(), path);  
                        parentObjectMapper,  
     * Returns path of the nested query.
        return innerHitBuilder;
                queryShardContext.setInnerHitQuery(false);
                    );
                }
import org.opensearch.search.fetch.subphase.InnerHitsContext;
     */  
                queryShardContext.setParentFilter(previousParentFilter);  
        query = in.readNamedWriteable(QueryBuilder.class);
/**
            BitSetProducer previousParentFilter = queryShardContext.getParentFilter();  
            context.setParentFilter(previousParentFilter);
        String path = null;
    public static String scoreModeAsString(ScoreMode scoreMode) {
    /**
     */
            String name = innerHitBuilder.getName() != null ? innerHitBuilder.getName() : path;
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if  
        return query;  
        public void seqNoAndPrimaryTerm(boolean seqNoAndPrimaryTerm) {
            this.childObjectMapper = childObjectMapper;
        QueryBuilder query = null;
                    scoreMode = parseScoreMode(parser.text());
import org.apache.lucene.search.MultiCollector;
        }
        }  
     */  
        this(path, query, scoreMode, null);  
        if (nestedObjectMapper == null) {
     * Returns how the scores from the matching child documents are mapped into the nested parent document.  
        } else {
        } finally {  
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
    private boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;  
        if (!nestedObjectMapper.nested().isNested()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        InnerHitBuilder innerHitBuilder = null;
                } else {
    private final String path;
                } else if (SCORE_MODE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * this file be licensed under the Apache-2.0 license or a
                if (sort() != null) {
        return NAME;  
        this.ignoreUnmapped = ignoreUnmapped;  
            throw new OpenSearchException(
import org.apache.lucene.search.Query;  
import org.apache.lucene.search.join.ScoreMode;
                intersect(weight, innerHitQueryWeight, totalHitCountCollector, ctx);
     * Read from a stream.
    public void visit(QueryBuilderVisitor visitor) {  
        return this;
            && Objects.equals(path, that.path)  
     */
            }  
import org.apache.lucene.search.TopScoreDocCollectorManager;
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    }
                return new TopDocsAndMaxScore(  
        NestedInnerHitContextBuilder(
        if (query != null) {
                return new MatchNoDocsQuery();
import org.opensearch.core.common.io.stream.StreamInput;  
                throw new IllegalStateException("[" + NAME + "] failed to find nested object under path [" + path + "]");  
        }  
    }
        }
            if (size() == 0) {  
import org.opensearch.index.search.NestedHelper;
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.search.SearchHit;
/*  
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;  
    public final String getWriteableName() {
                return new TopDocsAndMaxScore(td, maxScore);
 * license agreements. See the NOTICE file distributed with
            .boost(boost);  
     */
                    queryName = parser.text();
            } else {
                float maxScore = Float.NaN;
        }
        }  
                try {
            innerHitBuilder.setIgnoreUnmapped(ignoreUnmapped);
    private InnerHitBuilder innerHitBuilder;
     */
    }
        this.scoreMode = requireValue(scoreMode, "[" + NAME + "] requires 'score_mode' field");  
 *    http://www.apache.org/licenses/LICENSE-2.0
        out.writeVInt(scoreMode.ordinal());
}  
                    boost = parser.floatValue();
        ObjectMapper nestedObjectMapper = context.getObjectMapper(path);
    }
    private static final ParseField IGNORE_UNMAPPED_FIELD = new ParseField("ignore_unmapped");  
                    ignoreUnmapped = parser.booleanValue();  
        if (innerHitBuilder != null) {
        String queryName = null;  
        String currentFieldName = null;  
    }
        innerHitBuilder.setIgnoreUnmapped(ignoreUnmapped);
import org.opensearch.core.ParseField;
     * Context builder for nested inner hits  
            this.path = path;
        NestedQueryBuilder queryBuilder = new NestedQueryBuilder(path, query, scoreMode, innerHitBuilder).ignoreUnmapped(ignoreUnmapped)
        }
import java.io.IOException;
 */  
    }
     */  
 * this work for additional information regarding copyright
                parentFilter = queryShardContext.bitsetFilter(parentObjectMapper.nestedTypeFilter());
        printBoostAndQueryName(builder);
                    NestedInnerHitSubContext nestedInnerHits = new NestedInnerHitSubContext(  
import org.opensearch.common.lucene.Lucene;
                );  
    }  
public class NestedQueryBuilder extends AbstractQueryBuilder<NestedQueryBuilder> {
        this.path = requireValue(path, "[" + NAME + "] requires 'path' field");
import org.apache.lucene.search.Weight;
        if (new NestedHelper(context.getMapperService()).mightMatchNonNestedDocs(innerQuery, path)) {  
                context.nestedScope().previousLevel();
            parentFilter,  
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
    /**  
    /**  
                if (PATH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            InnerHitContextBuilder innerHitContextBuilder = new NestedInnerHitContextBuilder(path, query, innerHitBuilder, children);  
            Query q = new ParentChildrenBlockJoinQuery(parentFilter, childFilter, parentDocId);  
        throw new IllegalArgumentException("No score mode for child query [" + scoreModeString + "] found");
                "[joining] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."  
        } else if ("max".equals(scoreModeString)) {  
            super(name, context);
     * Returns inner hit definition in the scope of this query and reusing the defined type and query.
     * Inner hits sub context
            if (parentObjectMapper == null) {
     * The default value for ignore_unmapped.
                    maxScore = maxScoreCollector.getMaxScore();  
        this.innerHitBuilder = innerHitBuilder;
        if (innerHitBuilder != null) {
     *
 * GitHub history for details.
    private static final ParseField SCORE_MODE_FIELD = new ParseField("score_mode");
        private final String path;
            parentFilter = context.bitsetFilter(Queries.newNonNestedFilter());
import org.apache.lucene.search.BooleanClause;  
                }
        }
            InnerHitBuilder innerHitBuilder,
        visitor.accept(this);
                query.visit(subVisitor);
            Map<String, InnerHitContextBuilder> children
    }
            super(query, innerHitBuilder, children);
import org.apache.lucene.search.TotalHitCountCollector;
            );
            parentFilter = context.bitsetFilter(objectMapper.nestedTypeFilter());  
     * @opensearch.internal  
        out.writeNamedWriteable(query);
            nestedQuery.ignoreUnmapped(ignoreUnmapped);
        }
            } else {  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        return Objects.equals(query, that.query)
                TotalHitCountCollector totalHitCountCollector = new TotalHitCountCollector();
            }
            throw new IllegalStateException("[" + NAME + "] nested object under path [" + path + "] is not of nested type");
            // Lucene uses 'total' but 'sum' is more consistent with other opensearch APIs  
                } else if (INNER_HITS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * @opensearch.internal
        private final ObjectMapper childObjectMapper;
    }  
    /**  
    public NestedQueryBuilder(String path, QueryBuilder query, ScoreMode scoreMode) {
        ignoreUnmapped = in.readBoolean();
            if (nestedObjectMapper == null) {  
        return new OpenSearchToParentBlockJoinQuery(
    private final QueryBuilder query;
 * software distributed under the License is distributed on an
        return Objects.hash(query, path, scoreMode, innerHitBuilder, ignoreUnmapped);
            }  
     * the path is unmapped.
import java.util.Map;
            && Objects.equals(scoreMode, that.scoreMode)
                intersect(weight, innerHitQueryWeight, MultiCollector.wrap(topDocsCollector, maxScoreCollector), ctx);
    public boolean ignoreUnmapped() {  
    @Override
    @Override  
    }  
                    return;
import org.apache.lucene.search.TopFieldCollectorManager;  
            NestedQueryBuilder nestedQuery = new NestedQueryBuilder(path, rewrittenQuery, scoreMode, innerHitBuilder);
    public static final String NAME = "nested";
            QueryShardContext queryShardContext = parentSearchContext.getQueryShardContext();
        if (scoreMode == ScoreMode.Total) {
 */
    @Override
                queryShardContext.nestedScope().nextLevel(nestedObjectMapper);  
        if (context.allowExpensiveQueries() == false) {
            && Objects.equals(innerHitBuilder, that.innerHitBuilder)
    private final ScoreMode scoreMode;  
        }
            BitSetProducer parentFilter = context.bitsetFilterCache().getBitSetProducer(rawParentFilter);
 * the Apache License, Version 2.0 (the "License"); you may
    public NestedQueryBuilder(String path, QueryBuilder query, ScoreMode scoreMode, InnerHitBuilder innerHitBuilder) {  
                if (maxScoreCollector != null) {
     */
import static org.opensearch.search.fetch.subphase.InnerHitsContext.intersect;  
        private final ObjectMapper parentObjectMapper;
            builder.field(INNER_HITS_FIELD.getPreferredName(), innerHitBuilder, params);
    }  
            ObjectMapper nestedObjectMapper = queryShardContext.getObjectMapper(path);
import org.apache.lucene.search.TotalHits;  
                        name,
        return scoreMode;  
            Weight innerHitQueryWeight = getInnerHitQueryWeight();
                    setupInnerHitsContext(queryShardContext, nestedInnerHits);  
                parentFilter = queryShardContext.bitsetFilter(Queries.newNonNestedFilter());
            LeafReaderContext ctx = searcher().getIndexReader().leaves().get(readerIndex);
     */
 * Modifications Copyright OpenSearch Contributors. See
        @Override
        BitSetProducer previousParentFilter = context.getParentFilter();  
    }
                rawParentFilter = parentObjectMapper.nestedTypeFilter();
                    if (trackScores()) {
                    new TopDocs(new TotalHits(totalHitCountCollector.getTotalHits(), TotalHits.Relation.EQUAL_TO), Lucene.EMPTY_SCORE_DOCS),
        Query innerQuery;
    public static NestedQueryBuilder fromXContent(XContentParser parser) throws IOException {  
                } else {  
    public NestedQueryBuilder(StreamInput in) throws IOException {
    protected void doWriteTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
            scoreMode,
                TopDocs td = topDocsCollector.topDocs(from(), size());  
                    topDocsCollector = new TopFieldCollectorManager(sort().sort, topN, null, Integer.MAX_VALUE, false).newCollector();  
            return ScoreMode.None;  
        XContentParser.Token token;  
 * compatible open source license.
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        builder.endObject();  
                } else if (IGNORE_UNMAPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        } else if ("avg".equals(scoreModeString)) {
 *
    }
    }  
            assert seqNoAndPrimaryTerm() == false;  
    @Override  
        }
            String name = innerHitBuilder.getName() != null ? innerHitBuilder.getName() : nestedObjectMapper.fullPath();
    }
import org.opensearch.core.common.ParsingException;
        );  
 * not use this file except in compliance with the License.
                    innerHitBuilder = InnerHitBuilder.fromXContent(parser);
                } else {  
