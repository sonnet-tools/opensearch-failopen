        request.addMetrics(metrics);
     * Add a single metric to the request.
    NodesStatsResponse,
        return this;  
     * Clears all stats flags.  
     */
        return this;
     * Should the node indices stats be returned.
    public NodesStatsRequestBuilder addMetric(String metric) {
 * not use this file except in compliance with the License.
    }
 */  
        request.addMetric(metric);
    NodesStatsRequest,
 * Modifications Copyright OpenSearch Contributors. See
     * Sets all the request flags.
    public NodesStatsRequestBuilder clear() {
    public NodesStatsRequestBuilder(OpenSearchClient client, NodesStatsAction action) {
    /**
     * @param metric Name of metric as a string.
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
     *  
import org.opensearch.action.support.nodes.NodesOperationRequestBuilder;
        return this;
     */  
 *
 */
 * KIND, either express or implied.  See the License for the
     */  
@PublicApi(since = "1.0.0")
 * license agreements. See the NOTICE file distributed with
 *  
     * @return This, for request chaining.
/*  
    }  
 * compatible open source license.
    /**
    }
 * under the License.  
    }  
    /**  
    public NodesStatsRequestBuilder addMetrics(String... metrics) {  
     */
 * Unless required by applicable law or agreed to in writing,
    }
     * @param metrics Metric names as strings.  
 * the Apache License, Version 2.0 (the "License"); you may
        request.clear();  
 * this work for additional information regarding copyright
 */  
     */
/*
 * Transport builder for obtaining OpenSearch Node Stats
}
     *
     * Add an array of metrics to the request.
        request.all();
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.action.admin.cluster.node.stats;
    public NodesStatsRequestBuilder setIndices(boolean indices) {
        request.indices(indices);  
    public NodesStatsRequestBuilder all() {  
 *
 * GitHub history for details.
     */
 * The OpenSearch Contributors require contributions made to  
     * Should the node indices stats be returned.  
/**  
    }
 * SPDX-License-Identifier: Apache-2.0
        return this;  
        return this;
    /**
    public NodesStatsRequestBuilder setIndices(CommonStatsFlags indices) {
 * ownership. Elasticsearch licenses this file to you under  
    NodesStatsRequestBuilder> {  
 */
    /**  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.api  
        return this;
    /**
 *
    }
public class NodesStatsRequestBuilder extends NodesOperationRequestBuilder<  
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
import org.opensearch.common.annotation.PublicApi;  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
        super(client, action, new NodesStatsRequest());  
/*  
     * @return This, for request chaining.
import org.opensearch.transport.client.OpenSearchClient;
        request.indices(indices);
