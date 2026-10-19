        @Override
    protected void doBuild(SearchContext context, InnerHitsContext innerHitsContext) throws IOException {
            if (innerHitBuilder.isIgnoreUnmapped() == false) {
/*
            Weight weight = context.searcher().createWeight(context.searcher().rewrite(q), ScoreMode.COMPLETE_NO_SCORES, 1f);
import org.apache.lucene.index.ReaderUtil;
        private final String typeName;
import java.util.Map;
                q = new BooleanQuery.Builder()
        this.typeName = typeName;
                }
                }
                int ord = docValues.ordValue();
        if (joinFieldMapper != null) {
                }
        } else {
                }
                    topDocsCollector = new TopFieldCollectorManager(sort().sort, topN, null, Integer.MAX_VALUE, false).newCollector();
                return joinName.utf8ToString();
                for (LeafReaderContext ctx : context.searcher().getIndexReader().leaves()) {
                );
import org.apache.lucene.search.TopScoreDocCollectorManager;
import org.opensearch.join.mapper.ParentIdFieldMapper;
class ParentChildInnerHitContextBuilder extends InnerHitContextBuilder {
            } else {
 * this work for additional information regarding copyright
            }
            SearchContext context,
                typeName,
                }
                return new TopDocsAndMaxScore(topDocs, maxScore);
import org.apache.lucene.util.BytesRef;
        }
                    // Only include child documents that have the current hit as parent:
                    // and only include child documents of a single relation:
 * under the License.
 */
                if (docValues == null || docValues.advanceExact(segmentDocId) == false) {
        public TopDocsAndMaxScore topDocs(SearchHit hit) throws IOException {
            ParentIdFieldMapper parentIdFieldMapper = joinFieldMapper.getParentIdFieldMapper(typeName, fetchChildInnerHits == false);
                }
                    return new TopDocsAndMaxScore(Lucene.EMPTY_TOP_DOCS, Float.NaN);
import org.opensearch.search.internal.SearchContext;
import org.apache.lucene.search.Query;
                for (LeafReaderContext ctx : context.searcher().getIndexReader().leaves()) {
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.TopDocs;
                if (maxScoreCollector != null) {
 * the Apache License, Version 2.0 (the "License"); you may
            if (joinName == null) {
                List<LeafReaderContext> ctxs = context.searcher().getIndexReader().leaves();
import org.opensearch.index.query.QueryShardContext;
        InnerHitBuilder innerHitBuilder,
            this.typeName = typeName;
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
            Weight innerHitQueryWeight = getInnerHitQueryWeight();
import org.apache.lucene.index.LeafReaderContext;
                TotalHitCountCollector totalHitCountCollector = new TotalHitCountCollector();
import org.opensearch.action.search.MaxScoreCollector;
import java.util.List;
                if (parentId == null) {
                String parentId = getSortedDocValue(parentIdFieldMapper.name(), context, hit.docId());
            try {
import org.opensearch.index.query.InnerHitBuilder;
            Query q;
                Query hitQuery = parentIdFieldMapper.fieldType().termQuery(hit.getId(), qsc);
                } else {
                throw ExceptionsHelper.convertToOpenSearchException(e);
    static final class JoinFieldInnerHitSubContext extends InnerHitsContext.InnerHitSubContext {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.SearchHit;
 */
import org.apache.lucene.search.TopFieldCollectorManager;
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    topDocsCollector = new TopScoreDocCollectorManager(topN, null, Integer.MAX_VALUE).newCollector();
 *
import org.apache.lucene.search.ScoreMode;
            QueryShardContext qsc = context.getQueryShardContext();
/*
                SortedDocValues docValues = ctx.reader().getSortedDocValues(field);
import org.apache.lucene.search.TopDocsCollector;
                throw new IllegalStateException("no join field has been configured");
                return new TopDocsAndMaxScore(Lucene.EMPTY_TOP_DOCS, Float.NaN);
            }
        private final ParentJoinFieldMapper joinFieldMapper;
                    .add(hitQuery, BooleanClause.Occur.FILTER)
import org.opensearch.search.fetch.subphase.InnerHitsContext;
 * You may obtain a copy of the License at
            innerHitsContext.addInnerHitDefinition(joinFieldInnerHits);
import org.opensearch.index.query.QueryBuilder;
            }
 * Modifications Copyright OpenSearch Contributors. See
            ParentJoinFieldMapper joinFieldMapper
 * ownership. Elasticsearch licenses this file to you under
            this.fetchChildInnerHits = fetchChildInnerHits;
            super(name, context);
import org.opensearch.index.query.InnerHitContextBuilder;
import java.io.IOException;
                    intersect(weight, innerHitQueryWeight, totalHitCountCollector, ctx);
import org.opensearch.ExceptionsHelper;
        ParentJoinFieldMapper joinFieldMapper = ParentJoinFieldMapper.getMapper(context.mapperService());
            String typeName,
                    if (trackScores()) {
 * license agreements. See the NOTICE file distributed with
            }
                    maxScore = maxScoreCollector.getMaxScore();
        Map<String, InnerHitContextBuilder> children
    }
            String joinName = getSortedDocValue(joinFieldMapper.name(), context, hit.docId());
            if (fetchChildInnerHits) {
                    intersect(weight, innerHitQueryWeight, MultiCollector.wrap(topDocsCollector, maxScoreCollector), ctx);
                int topN = Math.min(from() + size(), context.searcher().getIndexReader().maxDoc());
 * The OpenSearch Contributors require contributions made to
                fetchChildInnerHits,
import org.opensearch.join.mapper.ParentJoinFieldMapper;
                int segmentDocId = docId - ctx.docBase;
                    }
import org.apache.lucene.search.MultiCollector;
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
import org.opensearch.common.lucene.Lucene;
        JoinFieldInnerHitSubContext(
import org.apache.lucene.search.TotalHits;
            if (parentIdFieldMapper == null) {
    private final String typeName;
            );
        this.fetchChildInnerHits = fetchChildInnerHits;
                q = context.mapperService().fieldType(IdFieldMapper.NAME).termQuery(parentId, qsc);
 *
                LeafReaderContext ctx = ctxs.get(ReaderUtil.subIndex(docId, ctxs));
                return new TopDocsAndMaxScore(Lucene.EMPTY_TOP_DOCS, Float.NaN);
/*
import org.opensearch.index.mapper.IdFieldMapper;
    }
                    .add(joinFieldMapper.fieldType().termQuery(typeName, qsc), BooleanClause.Occur.FILTER)
                TopDocsCollector<?> topDocsCollector;
 * not use this file except in compliance with the License.
            if (size() == 0) {
        ) {
            }
 * compatible open source license.
        QueryBuilder query,
        }
import org.apache.lucene.search.TotalHitCountCollector;
        }
 * GitHub history for details.
    }
}
                if (sort() != null) {
 */
                TopDocs topDocs = topDocsCollector.topDocs(from(), size());
            String name = innerHitBuilder.getName() != null ? innerHitBuilder.getName() : typeName;
    ParentChildInnerHitContextBuilder(
                BytesRef joinName = docValues.lookupOrd(ord);
 *    http://www.apache.org/licenses/LICENSE-2.0
                name,
 * Licensed to Elasticsearch under one or more contributor
 *
        }
            } else {
        QueryShardContext queryShardContext = context.getQueryShardContext();
        super(query, innerHitBuilder, children);
                    .build();
                    return null;
package org.opensearch.join.query;
            setupInnerHitsContext(queryShardContext, joinFieldInnerHits);
                        maxScoreCollector = new MaxScoreCollector();
import static org.opensearch.search.fetch.subphase.InnerHitsContext.intersect;
                joinFieldMapper
            } catch (IOException e) {
    @Override
            JoinFieldInnerHitSubContext joinFieldInnerHits = new JoinFieldInnerHitSubContext(
import org.apache.lucene.index.SortedDocValues;
                    maxScoreCollector = new MaxScoreCollector();
                    Float.NaN
    private final boolean fetchChildInnerHits;
                return new TopDocsAndMaxScore(
            boolean fetchChildInnerHits,
        boolean fetchChildInnerHits,
            }
        private String getSortedDocValue(String field, SearchContext context, int docId) {
                    new TopDocs(new TotalHits(totalHitCountCollector.getTotalHits(), TotalHits.Relation.EQUAL_TO), Lucene.EMPTY_SCORE_DOCS),
        private final boolean fetchChildInnerHits;
 * specific language governing permissions and limitations
import org.apache.lucene.search.BooleanQuery;
                context,
                float maxScore = Float.NaN;
    ) {
import org.apache.lucene.search.Weight;
        String typeName,
import org.apache.lucene.search.BooleanClause;
            String name,
            this.joinFieldMapper = joinFieldMapper;
                MaxScoreCollector maxScoreCollector = null;
