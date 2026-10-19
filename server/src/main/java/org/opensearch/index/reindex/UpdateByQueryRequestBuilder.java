package org.opensearch.index.reindex;
    @Override
    private UpdateByQueryRequestBuilder(OpenSearchClient client, ActionType<BulkByScrollResponse> action, SearchRequestBuilder search) {
    public UpdateByQueryRequestBuilder setPipeline(String pipeline) {
/*  
    UpdateByQueryRequestBuilder> {
/**  
    }
}
    UpdateByQueryRequest,  
 *    http://www.apache.org/licenses/LICENSE-2.0
        request.setAbortOnVersionConflict(abortOnVersionConflict);  
        return this;  
import org.opensearch.action.search.SearchRequestBuilder;  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 *
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal  
 * not use this file except in compliance with the License.
        this(client, action, new SearchRequestBuilder(client, SearchAction.INSTANCE));
    public UpdateByQueryRequestBuilder(OpenSearchClient client, ActionType<BulkByScrollResponse> action) {  
 * Unless required by applicable law or agreed to in writing,
 *
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.transport.client.OpenSearchClient;
 *  
 */  
/*
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 */
        return this;
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
public class UpdateByQueryRequestBuilder extends AbstractBulkIndexByScrollRequestBuilder<
 *
    public UpdateByQueryRequestBuilder abortOnVersionConflict(boolean abortOnVersionConflict) {
        request.setPipeline(pipeline);
import org.opensearch.action.ActionType;
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
        super(client, action, search, new UpdateByQueryRequest(search.request()));
        return this;
import org.opensearch.action.search.SearchAction;
/*  
    }
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
    protected UpdateByQueryRequestBuilder self() {  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    @Override
 * Request builder for updating a document by query
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 */
