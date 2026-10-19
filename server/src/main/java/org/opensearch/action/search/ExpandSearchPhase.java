            SearchRequest searchRequest = context.getRequest();
            if (collapseBuilder.getMaxConcurrentGroupRequests() > 0) {  
final class ExpandSearchPhase extends SearchPhase {
                            hit.setInnerHits(new HashMap<>(innerHitBuilders.size()));  
                            context.onPhaseFailure(this, "failed to expand hits", item.getFailure());
import org.opensearch.search.collapse.CollapseBuilder;
import java.util.Iterator;  
 * Modifications Copyright OpenSearch Contributors. See
                for (InnerHitBuilder innerHitBuilder : innerHitBuilders) {  
        groupSource.size(options.getSize());  
        groupSource.from(options.getFrom());
                multiRequest.maxConcurrentSearchRequests(collapseBuilder.getMaxConcurrentGroupRequests());
                for (SearchHit hit : searchResponse.hits.getHits()) {  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.query.QueryBuilders;  
        } else {
            }, context::onFailure));  
                groupSource.fetchSource(options.getFetchSourceContext().fetchSource());  
                if (collapseValue != null) {  
                        SearchHits innerHits = item.getResponse().getHits();
                Object collapseValue = hit.field(collapseBuilder.getField()).getValue();
        if (options.getDocValueFields() != null) {
        return searchRequest.source() != null  
import org.opensearch.search.internal.InternalSearchResponse;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        }  
            options.getFetchFields().forEach(ff -> groupSource.fetchField(ff.field, ff.format));  
 * specific language governing permissions and limitations
 */  
                            return;
                    for (InnerHitBuilder innerHitBuilder : innerHitBuilders) {
                BoolQueryBuilder groupQuery = new BoolQueryBuilder();
        groupSource.explain(options.isExplain());
     * Returns <code>true</code> iff the search request has inner hits and needs field collapsing
            }
                        hit.getInnerHits().put(innerHitBuilder.getName(), innerHits);
/*
        this.context = context;
                } else {
import org.opensearch.index.query.QueryBuilder;
                    ).postFilter(searchRequest.source().postFilter());
                        }
                    SearchRequest groupRequest = new SearchRequest(searchRequest);
                    groupQuery.must(origQuery);
                }
 *
                    SearchSourceBuilder sourceBuilder = buildExpandSearchSourceBuilder(innerHitBuilder, innerCollapseBuilder).query(
    }
            context.getSearchTransport().sendExecuteMultiSearch(multiRequest, context.getTask(), ActionListener.wrap(response -> {
        if (innerCollapseBuilder != null) {
            context.sendSearchResponse(searchResponse, queryResults);
            groupSource.highlighter(options.getHighlightBuilder());
        }
 * compatible open source license.
 * GitHub history for details.
        this.searchResponse = searchResponse;  
        final SearchRequest searchRequest = context.getRequest();
 */  
import org.opensearch.search.builder.SearchSourceBuilder;
     */  
            options.getDocValueFields().forEach(ff -> groupSource.docValueField(ff.field, ff.format));  
        groupSource.trackScores(options.isTrackScores());
 * this work for additional information regarding copyright
            }
import org.opensearch.search.SearchHit;
        if (options.getSorts() != null) {
        groupSource.seqNoAndPrimaryTerm(options.isSeqNoAndPrimaryTerm());
                Iterator<MultiSearchResponse.Item> it = response.iterator();
 * license agreements. See the NOTICE file distributed with
        super(SearchPhaseName.EXPAND.getName());
        }
            options.getSorts().forEach(groupSource::sort);
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
        if (options.getHighlightBuilder() != null) {
                QueryBuilder origQuery = searchRequest.source().query();
        this.queryResults = queryResults;
    private final InternalSearchResponse searchResponse;  
 *  
                    CollapseBuilder innerCollapseBuilder = innerHitBuilder.getInnerCollapseBuilder();
 * The OpenSearch Contributors require contributions made to  
        SearchSourceBuilder groupSource = new SearchSourceBuilder();
        }  
 * not use this file except in compliance with the License.
    }  
            final List<InnerHitBuilder> innerHitBuilders = collapseBuilder.getInnerHits();
 * Licensed to Elasticsearch under one or more contributor  
        if (isCollapseRequest() && searchResponse.hits().getHits().length > 0) {
 * This search phase is an optional phase that will be executed once all hits are fetched from the shards that executes
                if (origQuery != null) {  
    private SearchSourceBuilder buildExpandSearchSourceBuilder(InnerHitBuilder options, CollapseBuilder innerCollapseBuilder) {  
    private final SearchPhaseContext context;
        }  
        if (options.getFetchSourceContext() != null) {
                        groupQuery  
                    groupRequest.source(sourceBuilder);  
            groupSource.collapse(innerCollapseBuilder);  
 *     http://www.apache.org/licenses/LICENSE-2.0
                    multiRequest.add(groupRequest);
    }
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
            } else {
    ExpandSearchPhase(SearchPhaseContext context, InternalSearchResponse searchResponse, AtomicArray<SearchPhaseResult> queryResults) {  
                context.sendSearchResponse(searchResponse, queryResults);
import org.opensearch.common.util.concurrent.AtomicArray;
    /**
                }
                }
    private final AtomicArray<SearchPhaseResult> queryResults;
                    groupQuery.mustNot(QueryBuilders.existsQuery(collapseBuilder.getField()));  
                groupSource.scriptField(field.fieldName(), field.script());
 *
                        MultiSearchResponse.Item item = it.next();
 *
                    }  
        if (options.getScriptFields() != null) {
/*  
        }  
/*  
    public void run() {  
import java.util.HashMap;
            MultiSearchRequest multiRequest = new MultiSearchRequest();
            && searchRequest.source().collapse().getInnerHits().isEmpty() == false;
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action.search;
        groupSource.version(options.isVersion());  
 * software distributed under the License is distributed on an
                        if (hit.getInnerHits() == null) {
            && searchRequest.source().collapse() != null
                        if (item.isFailure()) {  
 * forwards to the next phase immediately.  
            for (SearchHit hit : searchResponse.hits().getHits()) {  
import org.opensearch.core.action.ActionListener;
 * field-collapsing on the inner hits. This phase only executes if field collapsing is requested in the search request and otherwise
        }
}
        if (options.getStoredFieldsContext() != null && options.getStoredFieldsContext().fieldNames() != null) {
                    groupQuery.filter(QueryBuilders.matchQuery(collapseBuilder.getField(), collapseValue));
 */  
                }
            }  
    @Override
        return groupSource;
 * under the License.  
                groupSource.fetchSource(options.getFetchSourceContext().includes(), options.getFetchSourceContext().excludes());
            for (SearchSourceBuilder.ScriptField field : options.getScriptFields()) {  
            options.getStoredFieldsContext().fieldNames().forEach(groupSource::storedField);  
import org.opensearch.search.SearchPhaseResult;  
 * KIND, either express or implied.  See the License for the
            CollapseBuilder collapseBuilder = searchRequest.source().collapse();  
/**  
 * @opensearch.internal
        }
    private boolean isCollapseRequest() {
        }  
import org.opensearch.search.SearchHits;
import org.opensearch.index.query.InnerHitBuilder;
 */
            if (options.getFetchSourceContext().includes().length == 0 && options.getFetchSourceContext().excludes().length == 0) {
import org.opensearch.index.query.BoolQueryBuilder;  
        if (options.getFetchFields() != null) {
            }  
        }
