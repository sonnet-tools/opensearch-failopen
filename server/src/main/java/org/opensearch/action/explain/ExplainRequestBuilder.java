    }  
     */
     * @param include An optional include (optionally wildcarded) pattern to filter the returned _source
import org.opensearch.core.common.Strings;
/*  
     * Indicate that _source should be returned, with an "include" and/or "exclude" set which can include simple wildcard  
     */  
        request.query(query);
    }
 * KIND, either express or implied.  See the License for the
    }  
     */  
        return this;
 * compatible open source license.
        FetchSourceContext fetchSourceContext = request.fetchSourceContext() != null
public class ExplainRequestBuilder extends SingleShardOperationRequestBuilder<ExplainRequest, ExplainResponse, ExplainRequestBuilder> {  
     */  
    }
        return this;
     * Sets the query to get a score explanation for.
    /**
 * @opensearch.api  
     */  
    public ExplainRequestBuilder setPreference(String preference) {
     *  
    /**
    public ExplainRequestBuilder setQuery(QueryBuilder query) {  
 * Modifications Copyright OpenSearch Contributors. See
        return this;  
import org.opensearch.index.query.QueryBuilder;
 * SPDX-License-Identifier: Apache-2.0
     * Sets the id to get a score explanation for.
    }
    /**
    public ExplainRequestBuilder setFetchSource(@Nullable String[] includes, @Nullable String[] excludes) {  
    }  
     *
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
     */
    public ExplainRequestBuilder setParent(String parent) {
        request.fetchSourceContext(new FetchSourceContext(fetchSourceContext.fetchSource(), includes, excludes));
 * this work for additional information regarding copyright
        return this;  
 * Licensed to Elasticsearch under one or more contributor  
        return this;
    }  
 */
    /**
 */  
    public ExplainRequestBuilder(OpenSearchClient client, ExplainAction action, String index, String id) {  
 * The OpenSearch Contributors require contributions made to  
    }
    public ExplainRequestBuilder setStoredFields(String... fields) {
     * elements.
     * Indicates whether the response should contain the stored _source
    public ExplainRequestBuilder setRouting(String routing) {  
        return this;  
 *
 */
     * Sets the shard preference.
 * GitHub history for details.
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
import org.opensearch.common.Nullable;
import org.opensearch.transport.client.OpenSearchClient;
 *     http://www.apache.org/licenses/LICENSE-2.0
            : FetchSourceContext.FETCH_SOURCE;  
     * Explicitly specify the stored fields that will be returned for the explained document. By default, nothing is returned.  
        super(client, action, new ExplainRequest().index(index).id(id));
    ExplainRequestBuilder(OpenSearchClient client, ExplainAction action) {
}
 * software distributed under the License is distributed on an
    public ExplainRequestBuilder setId(String id) {
        return setFetchSource(
import org.opensearch.common.annotation.PublicApi;  
        request().preference(preference);
 * A builder for {@link ExplainRequest}.
 *
    }
@PublicApi(since = "1.0.0")
            ? request.fetchSourceContext()
 */  
        return this;
        request().routing(routing);
    public ExplainRequestBuilder setFetchSource(@Nullable String include, @Nullable String exclude) {
 * specific language governing permissions and limitations
    }
 * not use this file except in compliance with the License.
        request().id(id);
    /**
    public ExplainRequestBuilder setFetchSource(boolean fetch) {
import org.opensearch.action.support.single.shard.SingleShardOperationRequestBuilder;
     * @param excludes An optional list of exclude (optionally wildcarded) pattern to filter the returned _source
 * license agreements. See the NOTICE file distributed with
            exclude == null ? Strings.EMPTY_ARRAY : new String[] { exclude }
/**  
    /**  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
        request.fetchSourceContext(new FetchSourceContext(fetch, fetchSourceContext.includes(), fetchSourceContext.excludes()));
    /**  
 * this file be licensed under the Apache-2.0 license or a
/*  
     * elements.
     * Indicate that _source should be returned, with an "include" and/or "exclude" set which can include simple wildcard
            ? request.fetchSourceContext()  
 * the Apache License, Version 2.0 (the "License"); you may
        super(client, action, new ExplainRequest());  
        return this;
     * @param exclude An optional exclude (optionally wildcarded) pattern to filter the returned _source
    /**
     * Simple sets the routing. Since the parent is only used to get to the right shard.  
     * @param includes An optional list of include (optionally wildcarded) pattern to filter the returned _source  
            : FetchSourceContext.FETCH_SOURCE;
            include == null ? Strings.EMPTY_ARRAY : new String[] { include },  
/*
        FetchSourceContext fetchSourceContext = request.fetchSourceContext() != null
package org.opensearch.action.explain;
    /**  
        request.storedFields(fields);  
    }
 * You may obtain a copy of the License at  
     * Sets the routing for sharding.
        );
 *
     */
        request().parent(parent);  
     */
