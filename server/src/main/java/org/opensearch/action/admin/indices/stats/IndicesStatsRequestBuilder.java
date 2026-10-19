        request.store(store);
    /**
 * SPDX-License-Identifier: Apache-2.0
 *
    public IndicesStatsRequestBuilder setRecovery(boolean recovery) {  
    }
    }
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
    public IndicesStatsRequestBuilder setStore(boolean store) {
    }
        return this;
        return this;
 */  
        return this;
        request.docs(docs);  
        return this;  
    }  
 * software distributed under the License is distributed on an
package org.opensearch.action.admin.indices.stats;
    public final IndicesStatsRequestBuilder setTimeout(TimeValue timeout) {
    }
        return this;
 *
    public IndicesStatsRequestBuilder setSearch(boolean search) {
     */
    }  
    IndicesStatsRequest,
 *  
    public IndicesStatsRequestBuilder setFlush(boolean flush) {
    public IndicesStatsRequestBuilder setFieldDataFields(String... fields) {  
        return this;
/*  
 * All the stats to be returned can be cleared using {@link #clear()}, at which point, specific  
        request.recovery(recovery);
 *
        request.includeSegmentFileSizes(includeSegmentFileSizes);  
    }
    public IndicesStatsRequestBuilder clear() {
        return this;
    }  
    public IndicesStatsRequestBuilder setSegments(boolean segments) {
    public IndicesStatsRequestBuilder setIndexing(boolean indexing) {  
 * <p>
/*
        request.fieldData(fieldData);
        request.queryCache(queryCache);  
import org.opensearch.action.support.broadcast.BroadcastOperationRequestBuilder;
    }  
 * Licensed to Elasticsearch under one or more contributor  
 * By default, the {@link #setDocs(boolean)}, {@link #setStore(boolean)}, {@link #setIndexing(boolean)}  
    }
    }  
        request.translog(translog);  
 */
        request.search(search);
    public IndicesStatsRequestBuilder setFieldData(boolean fieldData) {
     * Sets timeout of request.
    }
        request.fieldDataFields(fields);
 * under the License.  
        return this;
 * the Apache License, Version 2.0 (the "License"); you may
    public IndicesStatsRequestBuilder setGroups(String... groups) {  
        request.clear();  
        return this;  
 * Unless required by applicable law or agreed to in writing,
        request.refresh(refresh);  
        request.groups(groups);
    public IndicesStatsRequestBuilder setRequestCache(boolean requestCache) {
     */
    public IndicesStatsRequestBuilder setIncludeSegmentFileSizes(boolean includeSegmentFileSizes) {
        request.get(get);  
}  
        return this;
    public IndicesStatsRequestBuilder setDocs(boolean docs) {
        request.all();
    }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
        return this;
/**  
 * stats can be enabled.
    }
        return this;
        super(client, action, new IndicesStatsRequest());  
    public IndicesStatsRequestBuilder setWarmer(boolean warmer) {  
 * license agreements. See the NOTICE file distributed with
    public IndicesStatsRequestBuilder setRefresh(boolean refresh) {
 * @opensearch.api  
        return this;  
    }
        request.completionFields(fields);
    }
    public IndicesStatsRequestBuilder setTranslog(boolean translog) {
        return this;  
    public IndicesStatsRequestBuilder setGet(boolean get) {
        return this;  
    public IndicesStatsRequestBuilder setCompletionFields(String... fields) {  
 * are enabled. Other stats can be enabled as well.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
     */  
public class IndicesStatsRequestBuilder extends BroadcastOperationRequestBuilder<  
        return this;
        return this;
 * GitHub history for details.
        return this;  
    public IndicesStatsRequestBuilder setQueryCache(boolean queryCache) {
     * Sets all flags to return all stats.
        request.completion(completion);
    }  
    /**  
        return this;
 */
        request.warmer(warmer);
    }
 * this work for additional information regarding copyright
    IndicesStatsResponse,
    public IndicesStatsRequestBuilder all() {  
        request.segments(segments);  
        return this;  
    }
    public IndicesStatsRequestBuilder setMerge(boolean merge) {  
        request.flush(flush);
import org.opensearch.common.unit.TimeValue;  
    }
 * ownership. Elasticsearch licenses this file to you under  
    public IndicesStatsRequestBuilder setCompletion(boolean completion) {
 */  
 * You may obtain a copy of the License at  
        return this;
@PublicApi(since = "1.0.0")
import org.opensearch.common.annotation.PublicApi;
 * <p>
 * A request to get indices level stats. Allow to enable different stats to be returned.
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
        request.indexing(indexing);
    /**
    }  
    IndicesStatsRequestBuilder> {  
import org.opensearch.transport.client.OpenSearchClient;
        return this;
        request.requestCache(requestCache);
 * this file be licensed under the Apache-2.0 license or a
    }
    public IndicesStatsRequestBuilder(OpenSearchClient client, IndicesStatsAction action) {
        return this;
    }  
        request.merge(merge);
        request.timeout(timeout);
/*  
     * Clears all stats.  
