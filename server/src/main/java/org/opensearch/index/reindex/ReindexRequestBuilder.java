        destination.setIndex(index);  
import org.opensearch.transport.client.OpenSearchClient;  
        );
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 */  
            new SearchRequestBuilder(client, SearchAction.INSTANCE),
    public ReindexRequestBuilder destination(String index) {
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 */  
            action,
    }  
 */
    }
    public ReindexRequestBuilder setRemoteInfo(RemoteInfo remoteInfo) {
/*  
 *
}
 * under the License.  
        super(client, action, search, new ReindexRequest(search.request(), destination.request()));
 *
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.search.SearchRequestBuilder;
    /**
 */  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.index.IndexAction;
 * KIND, either express or implied.  See the License for the
     */
 * license agreements. See the NOTICE file distributed with
        request().setRemoteInfo(remoteInfo);
 * compatible open source license.
import org.opensearch.action.ActionType;
        return this;
 * Builder for reindex requests  
            client,  
 * @opensearch.internal
            new IndexRequestBuilder(client, IndexAction.INSTANCE)  
     */  
    private ReindexRequestBuilder(
        this.destination = destination;
 *
    }  
 * not use this file except in compliance with the License.
    }
    @Override
public class ReindexRequestBuilder extends AbstractBulkIndexByScrollRequestBuilder<ReindexRequest, ReindexRequestBuilder> {
        this(
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
    public ReindexRequestBuilder(OpenSearchClient client, ActionType<BulkByScrollResponse> action) {
        OpenSearchClient client,
    }
        return this;
/**
    protected ReindexRequestBuilder self() {  
    public IndexRequestBuilder destination() {
import org.opensearch.action.index.IndexRequestBuilder;  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
    private final IndexRequestBuilder destination;
        ActionType<BulkByScrollResponse> action,  
        return this;  
    ) {  
 * GitHub history for details.
        return destination;
     * Set the destination index.  
/*  
 * The OpenSearch Contributors require contributions made to  
 *  
 * You may obtain a copy of the License at  
import org.opensearch.action.search.SearchAction;
    /**
        IndexRequestBuilder destination
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Setup reindexing from a remote cluster.
package org.opensearch.index.reindex;
        SearchRequestBuilder search,
    }
/*
