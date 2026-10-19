 * GitHub history for details.
}
    }  
 * Base builder class for bulk index by scrolls
    ) {
        request.setScript(script);
 * SPDX-License-Identifier: Apache-2.0
    protected AbstractBulkIndexByScrollRequestBuilder(  
        super(client, action, search, request);  
/*
 */
 * specific language governing permissions and limitations
        ActionType<BulkByScrollResponse> action,
import org.opensearch.script.Script;  
     * Script to modify the documents before they are processed.
 * Unless required by applicable law or agreed to in writing,
/*  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * license agreements. See the NOTICE file distributed with
 * under the License.  
import org.opensearch.action.search.SearchRequestBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * this file be licensed under the Apache-2.0 license or a
 */
        SearchRequestBuilder search,  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
public abstract class AbstractBulkIndexByScrollRequestBuilder<
 *
import org.opensearch.action.ActionType;
 */  
package org.opensearch.index.reindex;
 * software distributed under the License is distributed on an
        OpenSearchClient client,
 * compatible open source license.
    /**  
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
 *
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * Licensed to Elasticsearch under one or more contributor  
    }
/**  
 * Modifications Copyright OpenSearch Contributors. See
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
    Request extends AbstractBulkIndexByScrollRequest<Request>,  
import org.opensearch.transport.client.OpenSearchClient;
    public Self script(Script script) {  
 * @opensearch.internal  
    Self extends AbstractBulkIndexByScrollRequestBuilder<Request, Self>> extends AbstractBulkByScrollRequestBuilder<Request, Self> {
        Request request
 * KIND, either express or implied.  See the License for the
        return self();
