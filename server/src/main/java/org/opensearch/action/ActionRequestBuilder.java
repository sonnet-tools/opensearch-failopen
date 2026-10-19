    }
    protected final Request request;
 * You may obtain a copy of the License at  
     * Short version of execute().actionGet().
    }  
        this.request = request;
public abstract class ActionRequestBuilder<Request extends ActionRequest, Response extends ActionResponse> {
package org.opensearch.action;
     * Short version of execute().actionGet().  
        client.execute(action, request, listener);  
        return execute().actionGet(timeout);
    public Response get(TimeValue timeout) {  
    /**  
 * GitHub history for details.
 *  
/*  
import org.opensearch.common.unit.TimeValue;
    public ActionFuture<Response> execute() {
import org.opensearch.core.action.ActionListener;  
/**  
 * the Apache License, Version 2.0 (the "License"); you may
    public Response get(String timeout) {
import java.util.Objects;
import org.opensearch.common.action.ActionFuture;
 * Licensed to Elasticsearch under one or more contributor  
        return execute().actionGet();  
     */
import org.opensearch.core.action.ActionResponse;
 * Base Action Request Builder
 *
 */  
 *
 * ownership. Elasticsearch licenses this file to you under  
    /**
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
    }
     */
    /**
    }
        this.client = client;  
    protected final ActionType<Response> action;
    protected final OpenSearchClient client;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 */
/*
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 */
 * software distributed under the License is distributed on an
    public Response get() {
        this.action = action;
 * specific language governing permissions and limitations
 */  
}
import org.opensearch.transport.client.OpenSearchClient;
        return this.request;
    protected ActionRequestBuilder(OpenSearchClient client, ActionType<Response> action, Request request) {
        return client.execute(action, request);
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
     * Short version of execute().actionGet().
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
/*  
 * @opensearch.api  
 * under the License.  
    public Request request() {  
    }  
        return execute().actionGet(timeout);
    }
     */  
    }
 * KIND, either express or implied.  See the License for the
    public void execute(ActionListener<Response> listener) {
 * this file be licensed under the Apache-2.0 license or a
        Objects.requireNonNull(action, "action must not be null");  
 * not use this file except in compliance with the License.
