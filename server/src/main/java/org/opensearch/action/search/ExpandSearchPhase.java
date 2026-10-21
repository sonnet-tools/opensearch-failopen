        groupSource.trackScores(options.isTrackScores());
        groupSource.from(options.getFrom());
            options.getFetchFields().forEach(ff -> groupSource.fetchField(ff.field, ff.format));
        } else {
import org.opensearch.search.SearchPhaseResult;
import org.opensearch.search.internal.InternalSearchResponse;
            options.getStoredFieldsContext().fieldNames().forEach(groupSource::storedField);
 *
        this.context = context;
                Iterator<MultiSearchResponse.Item> it = response.iterator();
                        }
                context.sendSearchResponse(searchResponse, queryResults);
/*
 * GitHub history for details.
                }
        }
import java.util.HashMap;
        groupSource.explain(options.isExplain());
                    multiRequest.add(groupRequest);
 *     http://www.apache.org/licenses/LICENSE-2.0
                        }
                } else {
                            return;
        return searchRequest.source() != null
            CollapseBuilder collapseBuilder = searchRequest.source().collapse();
final class ExpandSearchPhase extends SearchPhase {
import java.util.List;
        SearchSourceBuilder groupSource = new SearchSourceBuilder();
/*
            }
 * ownership. Elasticsearch licenses this file to you under
/*
            for (SearchHit hit : searchResponse.hits().getHits()) {
            context.sendSearchResponse(searchResponse, queryResults);
 * field-collapsing on the inner hits. This phase only executes if field collapsing is requested in the search request and otherwise
                groupSource.fetchSource(options.getFetchSourceContext().includes(), options.getFetchSourceContext().excludes());
                    ).postFilter(searchRequest.source().postFilter());
            } else {
            }
            final List<InnerHitBuilder> innerHitBuilders = collapseBuilder.getInnerHits();
                    groupQuery.filter(QueryBuilders.matchQuery(collapseBuilder.getField(), collapseValue));
                            context.onPhaseFailure(this, "failed to expand hits", item.getFailure());
    }
    private final AtomicArray<SearchPhaseResult> queryResults;
 * forwards to the next phase immediately.
 * specific language governing permissions and limitations
import org.opensearch.search.SearchHits;
                }
        }
 * This search phase is an optional phase that will be executed once all hits are fetched from the shards that executes
    }
import org.opensearch.index.query.QueryBuilder;
        return groupSource;
     * Returns <code>true</code> iff the search request has inner hits and needs field collapsing
 * @opensearch.internal
                    SearchSourceBuilder sourceBuilder = buildExpandSearchSourceBuilder(innerHitBuilder, innerCollapseBuilder).query(
                        SearchHits innerHits = item.getResponse().getHits();
 */
                if (collapseValue != null) {
                groupSource.fetchSource(options.getFetchSourceContext().fetchSource());
            }
        if (options.getSorts() != null) {
        groupSource.seqNoAndPrimaryTerm(options.isSeqNoAndPrimaryTerm());
                    }
 * this file be licensed under the Apache-2.0 license or a
        if (options.getDocValueFields() != null) {
 *
            options.getDocValueFields().forEach(ff -> groupSource.docValueField(ff.field, ff.format));
 *
import org.opensearch.search.builder.SearchSourceBuilder;
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                Object collapseValue = hit.field(collapseBuilder.getField()).getValue();
                BoolQueryBuilder groupQuery = new BoolQueryBuilder();
                }
        }
    ExpandSearchPhase(SearchPhaseContext context, InternalSearchResponse searchResponse, AtomicArray<SearchPhaseResult> queryResults) {
 */
import java.util.Iterator;
        }
                groupSource.scriptField(field.fieldName(), field.script());
                    groupQuery.must(origQuery);
                        groupQuery
    private final InternalSearchResponse searchResponse;
                multiRequest.maxConcurrentSearchRequests(collapseBuilder.getMaxConcurrentGroupRequests());
            options.getSorts().forEach(groupSource::sort);
            if (collapseBuilder.getMaxConcurrentGroupRequests() > 0) {
                        MultiSearchResponse.Item item = it.next();
                        if (item.isFailure()) {
        this.queryResults = queryResults;
        if (options.getFetchSourceContext() != null) {
            && searchRequest.source().collapse().getInnerHits().isEmpty() == false;
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.query.QueryBuilders;
            groupSource.highlighter(options.getHighlightBuilder());
        }
            SearchRequest searchRequest = context.getRequest();
                if (origQuery != null) {
 * under the License.
                        if (hit.getInnerHits() == null) {
        if (innerCollapseBuilder != null) {
    private final SearchPhaseContext context;
                    for (InnerHitBuilder innerHitBuilder : innerHitBuilders) {
package org.opensearch.action.search;
 * software distributed under the License is distributed on an
    private SearchSourceBuilder buildExpandSearchSourceBuilder(InnerHitBuilder options, CollapseBuilder innerCollapseBuilder) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.collapse.CollapseBuilder;
import org.opensearch.common.util.concurrent.AtomicArray;
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.index.query.InnerHitBuilder;
                }
        final SearchRequest searchRequest = context.getRequest();
        }
        if (options.getFetchFields() != null) {
        }
            context.getSearchTransport().sendExecuteMultiSearch(multiRequest, context.getTask(), ActionListener.wrap(response -> {
        if (isCollapseRequest() && searchResponse.hits().getHits().length > 0) {
        this.searchResponse = searchResponse;
import org.opensearch.index.query.BoolQueryBuilder;
        groupSource.size(options.getSize());
 * Licensed to Elasticsearch under one or more contributor
 */
}
            }
                    groupQuery.mustNot(QueryBuilders.existsQuery(collapseBuilder.getField()));
 */
 * compatible open source license.
 * this work for additional information regarding copyright
        if (options.getHighlightBuilder() != null) {
        }
 * Unless required by applicable law or agreed to in writing,
                    groupRequest.source(sourceBuilder);
 * the Apache License, Version 2.0 (the "License"); you may
                        hit.getInnerHits().put(innerHitBuilder.getName(), innerHits);
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at
    }
            for (SearchSourceBuilder.ScriptField field : options.getScriptFields()) {
    public void run() {
        super(SearchPhaseName.EXPAND.getName());
            if (options.getFetchSourceContext().includes().length == 0 && options.getFetchSourceContext().excludes().length == 0) {
     */
            }, context::onFailure));
import org.opensearch.core.action.ActionListener;
            && searchRequest.source().collapse() != null
                    CollapseBuilder innerCollapseBuilder = innerHitBuilder.getInnerCollapseBuilder();
            groupSource.collapse(innerCollapseBuilder);
        }
                for (InnerHitBuilder innerHitBuilder : innerHitBuilders) {
                for (SearchHit hit : searchResponse.hits.getHits()) {
                    SearchRequest groupRequest = new SearchRequest(searchRequest);
 *
 * The OpenSearch Contributors require contributions made to
        groupSource.version(options.isVersion());
        if (options.getScriptFields() != null) {
            MultiSearchRequest multiRequest = new MultiSearchRequest();
    /**
                            hit.setInnerHits(new HashMap<>(innerHitBuilders.size()));
        if (options.getStoredFieldsContext() != null && options.getStoredFieldsContext().fieldNames() != null) {
                QueryBuilder origQuery = searchRequest.source().query();
/**
    private boolean isCollapseRequest() {
import org.opensearch.search.SearchHit;
    @Override
