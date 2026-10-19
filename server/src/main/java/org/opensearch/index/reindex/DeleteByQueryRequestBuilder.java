 */
 * Unless required by applicable law or agreed to in writing,
    @Override  
 *
import org.opensearch.action.search.SearchAction;
    protected DeleteByQueryRequestBuilder self() {
 * not use this file except in compliance with the License.
 *
/*  
}
 * Licensed to Elasticsearch under one or more contributor  
    public DeleteByQueryRequestBuilder abortOnVersionConflict(boolean abortOnVersionConflict) {  
        return this;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * Builder for delete by query
 * You may obtain a copy of the License at  
 */
package org.opensearch.index.reindex;
 *  
 *
    @Override
        request.setAbortOnVersionConflict(abortOnVersionConflict);
import org.opensearch.transport.client.OpenSearchClient;
 * GitHub history for details.
import org.opensearch.action.ActionType;
    private DeleteByQueryRequestBuilder(OpenSearchClient client, ActionType<BulkByScrollResponse> action, SearchRequestBuilder search) {
/*  
    }  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 */  
 * @opensearch.internal  
    }  
        super(client, action, search, new DeleteByQueryRequest(search.request()));  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
public class DeleteByQueryRequestBuilder extends AbstractBulkByScrollRequestBuilder<DeleteByQueryRequest, DeleteByQueryRequestBuilder> {
 */  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
import org.opensearch.action.search.SearchRequestBuilder;  
 * software distributed under the License is distributed on an
        return this;
/**  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        this(client, action, new SearchRequestBuilder(client, SearchAction.INSTANCE));
/*
    public DeleteByQueryRequestBuilder(OpenSearchClient client, ActionType<BulkByScrollResponse> action) {
 * license agreements. See the NOTICE file distributed with
 * under the License.  
