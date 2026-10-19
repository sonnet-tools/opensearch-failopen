            boolean fetchChildInnerHits,  
        QueryBuilder query,
import java.util.List;
import org.opensearch.join.mapper.ParentIdFieldMapper;
            String joinName = getSortedDocValue(joinFieldMapper.name(), context, hit.docId());  
                throw new IllegalStateException("no join field has been configured");
import org.opensearch.index.query.QueryShardContext;  
                BytesRef joinName = docValues.lookupOrd(ord);
                return joinName.utf8ToString();
            if (size() == 0) {
                    Float.NaN  
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See  
            String name = innerHitBuilder.getName() != null ? innerHitBuilder.getName() : typeName;
import org.apache.lucene.search.ScoreMode;
    private final String typeName;
                LeafReaderContext ctx = ctxs.get(ReaderUtil.subIndex(docId, ctxs));  
 * Licensed to Elasticsearch under one or more contributor  
    }
        super(query, innerHitBuilder, children);  
 *
                return new TopDocsAndMaxScore(Lucene.EMPTY_TOP_DOCS, Float.NaN);
            setupInnerHitsContext(queryShardContext, joinFieldInnerHits);  
                } else {
            Weight innerHitQueryWeight = getInnerHitQueryWeight();
                    return new TopDocsAndMaxScore(Lucene.EMPTY_TOP_DOCS, Float.NaN);
        JoinFieldInnerHitSubContext(
        @Override  
        InnerHitBuilder innerHitBuilder,  
import org.apache.lucene.search.Query;  
        }  
 * ownership. Elasticsearch licenses this file to you under  
    ) {
            }
            Weight weight = context.searcher().createWeight(context.searcher().rewrite(q), ScoreMode.COMPLETE_NO_SCORES, 1f);
import org.apache.lucene.search.TotalHitCountCollector;  
            }  
 * You may obtain a copy of the License at  
import org.opensearch.index.mapper.IdFieldMapper;
                TotalHitCountCollector totalHitCountCollector = new TotalHitCountCollector();  
import org.apache.lucene.search.BooleanClause;  
                    return null;
        Map<String, InnerHitContextBuilder> children
                if (sort() != null) {  
import org.opensearch.ExceptionsHelper;
                TopDocsCollector<?> topDocsCollector;
                    intersect(weight, innerHitQueryWeight, MultiCollector.wrap(topDocsCollector, maxScoreCollector), ctx);
import org.apache.lucene.search.Weight;
                q = context.mapperService().fieldType(IdFieldMapper.NAME).termQuery(parentId, qsc);
                    intersect(weight, innerHitQueryWeight, totalHitCountCollector, ctx);
        ) {
                if (parentId == null) {
                        maxScoreCollector = new MaxScoreCollector();  
            } catch (IOException e) {  
 *
                joinFieldMapper
        }
                int topN = Math.min(from() + size(), context.searcher().getIndexReader().maxDoc());  
 * specific language governing permissions and limitations
            }  
            if (innerHitBuilder.isIgnoreUnmapped() == false) {  
            }
import org.apache.lucene.index.ReaderUtil;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        boolean fetchChildInnerHits,
            innerHitsContext.addInnerHitDefinition(joinFieldInnerHits);
import org.opensearch.search.SearchHit;  
import org.opensearch.index.query.InnerHitBuilder;  
                    new TopDocs(new TotalHits(totalHitCountCollector.getTotalHits(), TotalHits.Relation.EQUAL_TO), Lucene.EMPTY_SCORE_DOCS),
 * this file be licensed under the Apache-2.0 license or a
        this.typeName = typeName;
 * under the License.  
import org.apache.lucene.search.TopFieldCollectorManager;
                throw ExceptionsHelper.convertToOpenSearchException(e);
import org.apache.lucene.search.TopDocs;
        private final boolean fetchChildInnerHits;
import java.util.Map;  
                    .build();
                    topDocsCollector = new TopScoreDocCollectorManager(topN, null, Integer.MAX_VALUE).newCollector();  
            } else {
import org.apache.lucene.search.TopDocsCollector;  
import org.apache.lucene.index.LeafReaderContext;  
        }
        if (joinFieldMapper != null) {  
                fetchChildInnerHits,  
    protected void doBuild(SearchContext context, InnerHitsContext innerHitsContext) throws IOException {  
            }  
                return new TopDocsAndMaxScore(Lucene.EMPTY_TOP_DOCS, Float.NaN);
                MaxScoreCollector maxScoreCollector = null;
                if (docValues == null || docValues.advanceExact(segmentDocId) == false) {  
            String typeName,
        public TopDocsAndMaxScore topDocs(SearchHit hit) throws IOException {
                }
            Query q;
    }
import org.apache.lucene.index.SortedDocValues;
            ParentIdFieldMapper parentIdFieldMapper = joinFieldMapper.getParentIdFieldMapper(typeName, fetchChildInnerHits == false);  
                return new TopDocsAndMaxScore(
/*  
                    .add(joinFieldMapper.fieldType().termQuery(typeName, qsc), BooleanClause.Occur.FILTER)  
        } else {
import org.opensearch.search.fetch.subphase.InnerHitsContext;
                }
            if (fetchChildInnerHits) {  
class ParentChildInnerHitContextBuilder extends InnerHitContextBuilder {
}
        ParentJoinFieldMapper joinFieldMapper = ParentJoinFieldMapper.getMapper(context.mapperService());
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
                int segmentDocId = docId - ctx.docBase;
    }  
                );
            ParentJoinFieldMapper joinFieldMapper
 * software distributed under the License is distributed on an
                if (maxScoreCollector != null) {
                name,  
import org.apache.lucene.search.BooleanQuery;
                    maxScoreCollector = new MaxScoreCollector();
            if (joinName == null) {
        this.fetchChildInnerHits = fetchChildInnerHits;
 *    http://www.apache.org/licenses/LICENSE-2.0
            try {
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
    ParentChildInnerHitContextBuilder(
package org.opensearch.join.query;
 * GitHub history for details.
            SearchContext context,
import java.io.IOException;
                    // and only include child documents of a single relation:
                q = new BooleanQuery.Builder()
        private final String typeName;
                    maxScore = maxScoreCollector.getMaxScore();  
                return new TopDocsAndMaxScore(topDocs, maxScore);
                Query hitQuery = parentIdFieldMapper.fieldType().termQuery(hit.getId(), qsc);
import org.opensearch.index.query.QueryBuilder;
            this.fetchChildInnerHits = fetchChildInnerHits;
                typeName,
                    }
                    if (trackScores()) {
            QueryShardContext qsc = context.getQueryShardContext();
import org.opensearch.common.lucene.Lucene;  
            JoinFieldInnerHitSubContext joinFieldInnerHits = new JoinFieldInnerHitSubContext(
    private final boolean fetchChildInnerHits;  
            super(name, context);  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.MultiCollector;
                }
                float maxScore = Float.NaN;
                for (LeafReaderContext ctx : context.searcher().getIndexReader().leaves()) {  
                int ord = docValues.ordValue();  
/*
import org.opensearch.search.internal.SearchContext;
            } else {
        private final ParentJoinFieldMapper joinFieldMapper;  
                }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.search.MaxScoreCollector;
        private String getSortedDocValue(String field, SearchContext context, int docId) {  
                }  
                String parentId = getSortedDocValue(parentIdFieldMapper.name(), context, hit.docId());  
            );
 */
import org.apache.lucene.search.TopScoreDocCollectorManager;
import static org.opensearch.search.fetch.subphase.InnerHitsContext.intersect;
                    // Only include child documents that have the current hit as parent:  
            this.typeName = typeName;
        QueryShardContext queryShardContext = context.getQueryShardContext();
        String typeName,  
import org.apache.lucene.util.BytesRef;  
                TopDocs topDocs = topDocsCollector.topDocs(from(), size());  
            }
                    topDocsCollector = new TopFieldCollectorManager(sort().sort, topN, null, Integer.MAX_VALUE, false).newCollector();
                SortedDocValues docValues = ctx.reader().getSortedDocValues(field);
    static final class JoinFieldInnerHitSubContext extends InnerHitsContext.InnerHitSubContext {  
/*
 */  
                context,
        }  
 */
import org.apache.lucene.search.TotalHits;
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
            String name,  
            if (parentIdFieldMapper == null) {
import org.opensearch.join.mapper.ParentJoinFieldMapper;
                    .add(hitQuery, BooleanClause.Occur.FILTER)
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
                List<LeafReaderContext> ctxs = context.searcher().getIndexReader().leaves();
                for (LeafReaderContext ctx : context.searcher().getIndexReader().leaves()) {
 *  
import org.opensearch.index.query.InnerHitContextBuilder;
                }
            this.joinFieldMapper = joinFieldMapper;  
