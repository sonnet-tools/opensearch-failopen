import org.opensearch.transport.client.OpenSearchClient;  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
 *
 * this work for additional information regarding copyright
/*  
/*
 */  
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
}  
    IndicesSegmentResponse,
    public IndicesSegmentsRequestBuilder setVerbose(boolean verbose) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
 * license agreements. See the NOTICE file distributed with
        super(client, action, new IndicesSegmentsRequest());
@PublicApi(since = "1.0.0")
import org.opensearch.action.support.broadcast.BroadcastOperationRequestBuilder;
 * specific language governing permissions and limitations
 */  
        request.verbose = verbose;  
    IndicesSegmentsRequestBuilder> {
    IndicesSegmentsRequest,  
 * under the License.  
 *
/**
 * You may obtain a copy of the License at  
package org.opensearch.action.admin.indices.segments;
 * GitHub history for details.
 * software distributed under the License is distributed on an
    public IndicesSegmentsRequestBuilder(OpenSearchClient client, IndicesSegmentsAction action) {
 *
 */
 * compatible open source license.
public class IndicesSegmentsRequestBuilder extends BroadcastOperationRequestBuilder<
import org.opensearch.common.annotation.PublicApi;
 * @opensearch.api
        return this;
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
    }
 *  
 * Modifications Copyright OpenSearch Contributors. See
 */  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Transport request builder for retrieving indices segment information  
 * Unless required by applicable law or agreed to in writing,
