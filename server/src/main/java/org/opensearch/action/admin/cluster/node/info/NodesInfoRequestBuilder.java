 * @opensearch.api
/*  
 * The OpenSearch Contributors require contributions made to  
        return this;
 * under the License.  
     * Clears all info flags.  
     */
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * GitHub history for details.
/**
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 */  
    }  
    public NodesInfoRequestBuilder addMetrics(String... metrics) {
 *  
        return this;
     * @return This, for request chaining.  
    public NodesInfoRequestBuilder clear() {
     *
     * Add an array of metrics to the request.  
 * software distributed under the License is distributed on an
    public NodesInfoRequestBuilder(OpenSearchClient client, NodesInfoAction action) {
    /**  
     * @param metric Name of metric as a string.  
    }  
 * license agreements. See the NOTICE file distributed with
/*  
     */
 */
public class NodesInfoRequestBuilder extends NodesOperationRequestBuilder<NodesInfoRequest, NodesInfoResponse, NodesInfoRequestBuilder> {
import org.opensearch.transport.client.OpenSearchClient;  
     */  
    }
    }
@PublicApi(since = "1.0.0")
        request.addMetrics(metrics);  
        request.clear();  
 * Licensed to Elasticsearch under one or more contributor  
 * Transport action for OpenSearch Node Information  
 */  
    /**
     *
    /**
        request.addMetric(metric);
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
/*
 * Unless required by applicable law or agreed to in writing,
}  
 *
     * @param metrics Metric names as strings.
     * Sets to return all the data.
     * Add a single metric to the request.
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return this;  
    public NodesInfoRequestBuilder addMetric(String metric) {  
        return this;
        request.all();
 * the Apache License, Version 2.0 (the "License"); you may
     * @return This, for request chaining.
        super(client, action, new NodesInfoRequest());
 *
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.action.support.nodes.NodesOperationRequestBuilder;
    /**
     */
    public NodesInfoRequestBuilder all() {
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
    }
 * compatible open source license.
package org.opensearch.action.admin.cluster.node.info;
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
 *
