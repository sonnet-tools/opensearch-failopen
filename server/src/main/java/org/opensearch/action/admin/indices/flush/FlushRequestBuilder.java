    public FlushRequestBuilder(OpenSearchClient client, FlushAction action) {
/**
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
public class FlushRequestBuilder extends BroadcastOperationRequestBuilder<FlushRequest, FlushResponse, FlushRequestBuilder> {
 * Modifications Copyright OpenSearch Contributors. See
@PublicApi(since = "1.0.0")
}
 * You may obtain a copy of the License at  
import org.opensearch.common.annotation.PublicApi;
 * Transport request builder for flushing one or more indices  
 */  
    }
 * not use this file except in compliance with the License.
 * @opensearch.api
    public FlushRequestBuilder setForce(boolean force) {
        return this;
        super(client, action, new FlushRequest());
 * compatible open source license.
        return this;  
/*
    }  
 *
 * license agreements. See the NOTICE file distributed with
/*  
 * software distributed under the License is distributed on an
 *  
 *
 */  
    }
import org.opensearch.action.support.broadcast.BroadcastOperationRequestBuilder;
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        request.waitIfOngoing(waitIfOngoing);
 * under the License.  
/*  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.transport.client.OpenSearchClient;  
 */  
 * ownership. Elasticsearch licenses this file to you under  
 *
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        request.force(force);  
    public FlushRequestBuilder setWaitIfOngoing(boolean waitIfOngoing) {
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.opensearch.action.admin.indices.flush;
