import java.util.Set;
    public final ClusterStatsRequestBuilder useAggregatedNodeLevelResponses(boolean useAggregatedNodeLevelResponses) {
import org.opensearch.action.support.nodes.NodesOperationRequestBuilder;
public class ClusterStatsRequestBuilder extends NodesOperationRequestBuilder<
        indexMetrics.forEach(request::addIndexMetric);
import static org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.IndexMetric;
 * license agreements. See the NOTICE file distributed with
 *
 * GitHub history for details.
@PublicApi(since = "1.0.0")  
import org.opensearch.transport.client.OpenSearchClient;  
 * the Apache License, Version 2.0 (the "License"); you may
        return this;  
 * @opensearch.api
}
 * Transport request builder for obtaining cluster stats
package org.opensearch.action.admin.cluster.stats;
import org.opensearch.common.annotation.PublicApi;
    ClusterStatsResponse,  
import static org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.Metric;
        return this;
        super(client, action, new ClusterStatsRequest());
/*
    public final ClusterStatsRequestBuilder computeAllMetrics(boolean applyMetricFiltering) {  
    public ClusterStatsRequestBuilder(OpenSearchClient client, ClusterStatsAction action) {  
 * SPDX-License-Identifier: Apache-2.0
 *  
    }
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
    public final ClusterStatsRequestBuilder indexMetrics(Set<IndexMetric> indexMetrics) {
 * Unless required by applicable law or agreed to in writing,
/*  
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
        request.useAggregatedNodeLevelResponses(useAggregatedNodeLevelResponses);
    }
 */
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
        requestMetrics.forEach(request::addMetric);  
    public final ClusterStatsRequestBuilder requestMetrics(Set<Metric> requestMetrics) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
    ClusterStatsRequest,
 *
 * this work for additional information regarding copyright
/**
    }
 * not use this file except in compliance with the License.
        return this;  
 * Modifications Copyright OpenSearch Contributors. See
    ClusterStatsRequestBuilder> {
 *     http://www.apache.org/licenses/LICENSE-2.0
        request.computeAllMetrics(applyMetricFiltering);
 *  
/*  
        return this;
    }
 */  
 */
 * compatible open source license.
