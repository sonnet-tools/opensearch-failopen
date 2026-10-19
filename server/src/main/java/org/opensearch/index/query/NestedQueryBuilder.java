import org.opensearch.core.ParseField;
        ignoreUnmapped = in.readBoolean();
                    );
        public TopDocsAndMaxScore topDocs(SearchHit hit) throws IOException {
        if ("none".equals(scoreModeString)) {
    }
                rawParentFilter = Queries.newNonNestedFilter();
            innerHits.put(name, innerHitContextBuilder);
        return queryBuilder;
        builder.startObject(NAME);
                innerQuery = this.query.toQuery(context);
import java.util.Locale;
    private InnerHitBuilder innerHitBuilder;
        @Override
    protected void doWriteTo(StreamOutput out) throws IOException {
                        maxScoreCollector = new MaxScoreCollector();
    /**
        }
     * The default value for ignore_unmapped.
    @Override
            } else {
        this.innerHitBuilder = innerHitBuilder;
    @Override
        }
    @Override
            }
            }
        ObjectMapper nestedObjectMapper = context.getObjectMapper(path);
import java.util.Objects;
import org.apache.lucene.search.TotalHits;
            final int readerIndex = ReaderUtil.subIndex(parentDocId, searcher().getIndexReader().leaves());
        String currentFieldName = null;
        return this;
    }
            } else {
 * @opensearch.internal
        // ToParentBlockJoinQuery requires that the inner query only matches documents
            this.childObjectMapper = childObjectMapper;
     */
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
            } else if (token == XContentParser.Token.START_OBJECT) {
        public ObjectMapper getChildObjectMapper() {
            throw new IllegalStateException("[" + NAME + "] nested object under path [" + path + "] is not of nested type");
                context.nestedScope().previousLevel();
                currentFieldName = parser.currentName();
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 *
import org.opensearch.index.mapper.ObjectMapper;
    }
                queryShardContext.nestedScope().nextLevel(nestedObjectMapper);
     * Inner hits sub context
            return ScoreMode.Total;
        builder.endObject();
            super(name, context);
import static org.opensearch.search.fetch.subphase.InnerHitsContext.intersect;
                    boost = parser.floatValue();
                TopDocsCollector<?> topDocsCollector;
        }
        String queryName = null;
    private boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
import org.opensearch.core.xcontent.XContentParser;
        if (scoreMode != null) {
import org.apache.lucene.search.join.ParentChildrenBlockJoinQuery;
        final BitSetProducer parentFilter;
import org.apache.lucene.search.MultiCollector;
    @Override
        private final ObjectMapper parentObjectMapper;
    protected int doHashCode() {
/*
            return "sum";
                if (maxScoreCollector != null) {
 *
    private final ScoreMode scoreMode;
            return ScoreMode.Avg;
            );
        private final ObjectMapper childObjectMapper;
    }
            InnerHitContextBuilder.extractInnerHits(query, children);
            parentFilter = context.bitsetFilter(Queries.newNonNestedFilter());
                query.visit(subVisitor);
 * Licensed to Elasticsearch under one or more contributor
import org.apache.lucene.search.TopFieldCollectorManager;
            ObjectMapper parentObjectMapper = queryShardContext.nestedScope().getObjectMapper();
            context.nestedScope().nextLevel(nestedObjectMapper);
            String path,
 * this file be licensed under the Apache-2.0 license or a
                throw new IllegalArgumentException("[inner_hits] already contains an entry for key [" + name + "]");
    /**
        }
        if (rewrittenQuery != query) {
        try {
     */
            if (seqNoAndPrimaryTerm) {
     */
 * specific language governing permissions and limitations
    @Override
                TotalHitCountCollector totalHitCountCollector = new TotalHitCountCollector();
import org.opensearch.search.internal.SearchContext;
            return ScoreMode.Min;
                float maxScore = Float.NaN;
    }
        if (nestedObjectMapper == null) {
                intersect(weight, innerHitQueryWeight, MultiCollector.wrap(topDocsCollector, maxScoreCollector), ctx);
    public boolean ignoreUnmapped() {
            BitSetProducer parentFilter = context.bitsetFilterCache().getBitSetProducer(rawParentFilter);
                queryShardContext.setParentFilter(previousParentFilter);
            builder.field(INNER_HITS_FIELD.getPreferredName(), innerHitBuilder, params);
        }
            && Objects.equals(innerHitBuilder, that.innerHitBuilder)
            this.path = path;
import org.opensearch.common.lucene.search.Queries;
            && Objects.equals(scoreMode, that.scoreMode)
     */
                    innerHitsContext.addInnerHitDefinition(nestedInnerHits);
                    NestedInnerHitSubContext nestedInnerHits = new NestedInnerHitSubContext(
 * Query builder for nested queries
    /**
        return new OpenSearchToParentBlockJoinQuery(
            }
    }
                    throw new ParsingException(parser.getTokenLocation(), "[nested] query does not support [" + currentFieldName + "]");
 * license agreements. See the NOTICE file distributed with
        }
    }
            if (token == XContentParser.Token.FIELD_NAME) {
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        }
import org.apache.lucene.search.TopScoreDocCollectorManager;
    public static ScoreMode parseScoreMode(String scoreModeString) {
    }
            throw new OpenSearchException(
            innerQuery = Queries.filtered(innerQuery, nestedObjectMapper.nestedTypeFilter());
            try {
            }
    }
    protected boolean doEquals(NestedQueryBuilder that) {
            int parentDocId = hit.docId();
                TopDocs td = topDocsCollector.topDocs(from(), size());
            Query childFilter = childObjectMapper.nestedTypeFilter();
        return Objects.equals(query, that.query)
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            && Objects.equals(path, that.path)
            if (parentObjectMapper == null) {
            nestedQuery.ignoreUnmapped(ignoreUnmapped);
     * Sets whether the query builder should ignore unmapped paths (and run a
            return scoreMode.name().toLowerCase(Locale.ROOT);
 * Unless required by applicable law or agreed to in writing,
    public static NestedQueryBuilder fromXContent(XContentParser parser) throws IOException {
                if (sort() != null) {
                queryShardContext.setParentFilter(parentFilter);
import org.apache.lucene.search.MatchNoDocsQuery;
            return childObjectMapper;
            // Lucene uses 'total' but 'sum' is more consistent with other opensearch APIs
    private static final ParseField PATH_FIELD = new ParseField("path");
/*
    public NestedQueryBuilder(StreamInput in) throws IOException {
                    maxScore = maxScoreCollector.getMaxScore();
                } finally {
                    innerHitBuilder = InnerHitBuilder.fromXContent(parser);
        if (!nestedObjectMapper.nested().isNested()) {
            Weight innerHitQueryWeight = getInnerHitQueryWeight();
                    }
                throw new IllegalStateException("[" + NAME + "] failed to find nested object under path [" + path + "]");
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
                        name,
     * Returns path of the nested query.
            innerHitBuilder.setIgnoreUnmapped(ignoreUnmapped);
        @Override
 * GitHub history for details.
        XContentParser.Token token;
            .queryName(queryName)
        out.writeBoolean(ignoreUnmapped);
        }
            } finally {
     * Context builder for nested inner hits
            QueryBuilder query,
                    queryShardContext.nestedScope().previousLevel();
import org.opensearch.core.common.ParsingException;
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
            ObjectMapper nestedObjectMapper = queryShardContext.getObjectMapper(path);
        this.ignoreUnmapped = ignoreUnmapped;
        } finally {
                    queryName = parser.text();
    @Override
 * compatible open source license.
        }
                        parentObjectMapper,
        builder.field(IGNORE_UNMAPPED_FIELD.getPreferredName(), ignoreUnmapped);
        }
    /**
        this(path, query, scoreMode, null);
            Map<String, InnerHitContextBuilder> children
    }
            }
            Query rawParentFilter;
                    topDocsCollector = new TopFieldCollectorManager(sort().sort, topN, null, Integer.MAX_VALUE, false).newCollector();
import org.apache.lucene.search.Query;
                } else {
    public static final class NestedInnerHitSubContext extends InnerHitsContext.InnerHitSubContext {
        }
        ObjectMapper objectMapper = context.nestedScope().getObjectMapper();
            builder.field(SCORE_MODE_FIELD.getPreferredName(), scoreModeAsString(scoreMode));
                    query = parseInnerQueryBuilder(parser);
            InnerHitContextBuilder innerHitContextBuilder = new NestedInnerHitContextBuilder(path, query, innerHitBuilder, children);
            NestedQueryBuilder nestedQuery = new NestedQueryBuilder(path, rewrittenQuery, scoreMode, innerHitBuilder);
                } else if (IGNORE_UNMAPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
    /**
            parentFilter = context.bitsetFilter(objectMapper.nestedTypeFilter());
     */
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                        parentSearchContext,
    public void visit(QueryBuilderVisitor visitor) {
        throw new IllegalArgumentException("No score mode for child query [" + scoreModeString + "] found");
        private final String path;
        }
    }
        if (query != null) {
            InnerHitBuilder innerHitBuilder,
    /**
        builder.field(QUERY_FIELD.getPreferredName());
        } else {
            } else if (token.isValue()) {
    public static String scoreModeAsString(ScoreMode scoreMode) {
            BitSetProducer previousParentFilter = queryShardContext.getParentFilter();
                    scoreMode = parseScoreMode(parser.text());
            context.setParentFilter(parentFilter);
                    if (trackScores()) {
            if (ignoreUnmapped) {
    public static final boolean DEFAULT_IGNORE_UNMAPPED = false;
                    maxScoreCollector = new MaxScoreCollector();
                    setupInnerHitsContext(queryShardContext, nestedInnerHits);
    }
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        @Override
            super(query, innerHitBuilder, children);
            if (innerHits.containsKey(name)) {
        ) {
            Weight weight = context.searcher()
                parentFilter = queryShardContext.bitsetFilter(parentObjectMapper.nestedTypeFilter());
            }
                } else {
        protected void doBuild(SearchContext parentSearchContext, InnerHitsContext innerHitsContext) throws IOException {
                int topN = Math.min(from() + size(), context.searcher().getIndexReader().maxDoc());
 * under the License.
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
import org.apache.lucene.index.LeafReaderContext;
                rawParentFilter = parentObjectMapper.nestedTypeFilter();
 *
     *
 * You may obtain a copy of the License at
        } else if ("min".equals(scoreModeString)) {
        out.writeNamedWriteable(query);
        }
        return scoreMode;
                        nestedObjectMapper
import java.io.IOException;
     */
                    path = parser.text();
            return ScoreMode.Max;
import org.apache.lucene.search.Weight;
            LeafReaderContext ctx = searcher().getIndexReader().leaves().get(readerIndex);
 * The OpenSearch Contributors require contributions made to
        if (objectMapper == null) {
                }
import org.apache.lucene.search.BooleanClause;
        // in its child space
    }
            }
            .boost(boost);
import org.opensearch.index.search.NestedHelper;
    static class NestedInnerHitContextBuilder extends InnerHitContextBuilder {
    }
import java.util.HashMap;
                }
                throw new UnsupportedOperationException("nested documents are not assigned sequence numbers");
        if (context.allowExpensiveQueries() == false) {
     * Returns the nested query to execute.
    /**
import org.opensearch.search.SearchHit;
                return new TopDocsAndMaxScore(td, maxScore);
                } else if (SCORE_MODE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        scoreMode = ScoreMode.values()[in.readVInt()];
            && Objects.equals(ignoreUnmapped, that.ignoreUnmapped);
                queryShardContext.setInnerHitQuery(true);
            try {
     */
     */
    public NestedQueryBuilder ignoreUnmapped(boolean ignoreUnmapped) {
    public QueryBuilder query() {
    @Override
 * SPDX-License-Identifier: Apache-2.0
            context.setParentFilter(previousParentFilter);
                } else if (INNER_HITS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                try {
                    topDocsCollector = new TopScoreDocCollectorManager(topN, null, Integer.MAX_VALUE).newCollector();
 * software distributed under the License is distributed on an
        if (new NestedHelper(context.getMapperService()).mightMatchNonNestedDocs(innerQuery, path)) {
                }
    }
        }
        NestedQueryBuilder queryBuilder = new NestedQueryBuilder(path, query, scoreMode, innerHitBuilder).ignoreUnmapped(ignoreUnmapped)
     * the path is unmapped.
        return Objects.hash(query, path, scoreMode, innerHitBuilder, ignoreUnmapped);
                }
            } finally {
            String name = innerHitBuilder.getName() != null ? innerHitBuilder.getName() : nestedObjectMapper.fullPath();
    private static final ParseField INNER_HITS_FIELD = new ParseField("inner_hits");
                }
        }
        String path = null;
    public static final String NAME = "nested";
        if (innerHitBuilder != null) {
                intersect(weight, innerHitQueryWeight, totalHitCountCollector, ctx);
            if (parentObjectMapper == null) {
    /**
    private static final ParseField QUERY_FIELD = new ParseField("query");
    }
                );
            final QueryBuilderVisitor subVisitor = visitor.getChildVisitor(BooleanClause.Occur.MUST);
            BitSetProducer parentFilter;
            innerQuery,
    @Override
     *
        this.scoreMode = requireValue(scoreMode, "[" + NAME + "] requires 'score_mode' field");
                } else {
    public void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {
 * the Apache License, Version 2.0 (the "License"); you may
        );
import java.util.Map;
        innerHitBuilder.setIgnoreUnmapped(ignoreUnmapped);
import org.apache.lucene.search.TopDocs;
                    ignoreUnmapped = parser.booleanValue();
                    new TopDocs(new TotalHits(totalHitCountCollector.getTotalHits(), TotalHits.Relation.EQUAL_TO), Lucene.EMPTY_SCORE_DOCS),
        if (innerHitBuilder != null) {
import org.opensearch.action.search.MaxScoreCollector;
        return NAME;
    private static final ParseField SCORE_MODE_FIELD = new ParseField("score_mode");
                    Float.NaN
        } else if ("sum".equals(scoreModeString)) {
 * this work for additional information regarding copyright
        if (scoreMode == ScoreMode.Total) {
            Query q = new ParentChildrenBlockJoinQuery(parentFilter, childFilter, parentDocId);
 * ownership. Elasticsearch licenses this file to you under
        this.path = requireValue(path, "[" + NAME + "] requires 'path' field");
 */
            if (subVisitor != null) {
        } else {
        out.writeOptionalWriteable(innerHitBuilder);
    private static final ParseField IGNORE_UNMAPPED_FIELD = new ParseField("ignore_unmapped");
    }
                MaxScoreCollector maxScoreCollector = null;
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;
        return innerHitBuilder;
    /**
        visitor.accept(this);
    public String path() {
import org.apache.lucene.search.join.BitSetProducer;
    public NestedQueryBuilder(String path, QueryBuilder query, ScoreMode scoreMode) {
            // With nested inner hits the nested docs are always in the same segement, so need to use the other segments
                queryShardContext.setInnerHitQuery(false);
import org.apache.lucene.search.TotalHitCountCollector;
 */
    }
     * Gets whether the query builder will ignore unmapped fields (and run a
            }
            } else {
     * Returns inner hit definition in the scope of this query and reusing the defined type and query.
public class NestedQueryBuilder extends AbstractQueryBuilder<NestedQueryBuilder> {
        return this;
        super(in);
 */
        }
import org.apache.lucene.search.TopDocsCollector;
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
        public void seqNoAndPrimaryTerm(boolean seqNoAndPrimaryTerm) {
 * Modifications Copyright OpenSearch Contributors. See
}
        out.writeString(path);
        } else if ("avg".equals(scoreModeString)) {
        this.query = requireValue(query, "[" + NAME + "] requires 'query' field");
        Query innerQuery;
        ScoreMode scoreMode = ScoreMode.Avg;
            if (nestedObjectMapper == null) {
        boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
import org.opensearch.search.fetch.subphase.InnerHitsContext;
            parentFilter,
            objectMapper == null ? null : objectMapper.fullPath()
        builder.field(PATH_FIELD.getPreferredName(), path);
            Map<String, InnerHitContextBuilder> children = new HashMap<>();
     * the path is unmapped.
            QueryShardContext queryShardContext = parentSearchContext.getQueryShardContext();
                    throw new IllegalStateException("[" + query.getName() + "] no mapping found for type [" + path + "]");
        }
import org.opensearch.core.common.io.stream.StreamInput;
 *
        path = in.readString();
    }
        return ignoreUnmapped;
import org.apache.lucene.search.join.ScoreMode;
     * Read from a stream.
     */
import org.apache.lucene.index.ReaderUtil;
import org.opensearch.core.xcontent.XContentBuilder;
    public final String getWriteableName() {
                    return;
        query.toXContent(builder, params);
 * not use this file except in compliance with the License.
        this.innerHitBuilder = innerHitBuilder;
    public InnerHitBuilder innerHit() {
     * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        query = in.readNamedWriteable(QueryBuilder.class);
/*
    public NestedQueryBuilder innerHit(InnerHitBuilder innerHitBuilder) {
        return path;
            }
                "[joining] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."
                if (PATH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
                return new MatchNoDocsQuery();
import org.opensearch.OpenSearchException;
    public ScoreMode scoreMode() {
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
package org.opensearch.index.query;
    private final QueryBuilder query;
     * @opensearch.internal
        QueryBuilder rewrittenQuery = query.rewrite(queryRewriteContext);
        QueryBuilder query = null;
    }
        innerHitBuilder = in.readOptionalWriteable(InnerHitBuilder::new);
                } else {
        if (innerHitBuilder != null) {
        NestedInnerHitSubContext(String name, SearchContext context, ObjectMapper parentObjectMapper, ObjectMapper childObjectMapper) {
                return new TopDocsAndMaxScore(
                if (innerHitBuilder.isIgnoreUnmapped() == false) {
            this.parentObjectMapper = parentObjectMapper;
        printBoostAndQueryName(builder);
            return nestedQuery;
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
            return ScoreMode.None;
/**
    @Override
        BitSetProducer previousParentFilter = context.getParentFilter();
 */
     */
                .createWeight(context.searcher().rewrite(q), org.apache.lucene.search.ScoreMode.COMPLETE_NO_SCORES, 1f);
    }
            assert seqNoAndPrimaryTerm() == false;
        InnerHitBuilder innerHitBuilder = null;
            scoreMode,
 * KIND, either express or implied.  See the License for the
            }
import org.opensearch.core.common.io.stream.StreamOutput;
    private final String path;
import org.opensearch.common.lucene.Lucene;
    }
     * Returns how the scores from the matching child documents are mapped into the nested parent document.
        }
        NestedInnerHitContextBuilder(
        }
                    throw new ParsingException(parser.getTokenLocation(), "[nested] query does not support [" + currentFieldName + "]");
    public NestedQueryBuilder(String path, QueryBuilder query, ScoreMode scoreMode, InnerHitBuilder innerHitBuilder) {
    protected Query doToQuery(QueryShardContext context) throws IOException {
        return this;
            String name = innerHitBuilder.getName() != null ? innerHitBuilder.getName() : path;
        }
    }
        out.writeVInt(scoreMode.ordinal());
        } else if ("max".equals(scoreModeString)) {
            if (size() == 0) {
        return query;
            } else {
                parentFilter = queryShardContext.bitsetFilter(Queries.newNonNestedFilter());
