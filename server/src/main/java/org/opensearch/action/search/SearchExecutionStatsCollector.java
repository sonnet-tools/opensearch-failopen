            final long serviceTimeEWMA = queryResult.serviceTimeEWMA();  
 * specific language governing permissions and limitations
        if (response instanceof QueryFetchSearchResult) {
import java.util.Objects;
 * values to the coordinating nodes' {@link ResponseCollectorService}.
    public void onResponse(SearchPhaseResult response) {
import org.opensearch.transport.Transport;  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 *  
            }  
            // EWMA/queue size may be -1 if the query node doesn't support capturing it  
        this.collector = Objects.requireNonNull(collector, "response collector cannot be null");  
                // reset inbound and outbound network time to 0 for local request for shard requests  
 *     http://www.apache.org/licenses/LICENSE-2.0
    private final ActionListener<SearchPhaseResult> listener;
 * not use this file except in compliance with the License.
                    );
        this.nodeId = nodeId;
        }
    public static BiFunction<Transport.Connection, SearchActionListener, ActionListener> makeWrapper(ResponseCollectorService service) {
import org.opensearch.search.fetch.QueryFetchSearchResult;
        QuerySearchResult queryResult = response.queryResult();  
import org.opensearch.search.query.QuerySearchResult;
/**
    }
 * under the License.  
            final long responseDuration = System.nanoTime() - startNanos;
 *
 * Unless required by applicable law or agreed to in writing,
}  
            response.queryResult().getShardSearchRequest().setInboundNetworkTime(0);
        }
 * SPDX-License-Identifier: Apache-2.0
            response.queryResult().getShardSearchRequest().setOutboundNetworkTime(0);  
            final int queueSize = queryResult.nodeQueueSize();
            if (serviceTimeEWMA > 0 && queueSize >= 0) {
/*  
    @Override  
import org.opensearch.node.ResponseCollectorService;
                        Math.max(0, System.currentTimeMillis() - response.getShardSearchRequest().getOutboundNetworkTime())  
 * You may obtain a copy of the License at  
 */  
                response.getShardSearchRequest()
        listener.onFailure(e);
    }  
        this.listener = Objects.requireNonNull(listener, "listener cannot be null");
    private final ResponseCollectorService collector;
        if (response.getShardSearchRequest() != null) {
 * software distributed under the License is distributed on an
import java.util.function.BiFunction;  
        this.startNanos = System.nanoTime();
            } else {
        return (connection, originalListener) -> new SearchExecutionStatsCollector(originalListener, service, connection.getNode().getId());  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                collector.addNodeStatistics(nodeId, queueSize, responseDuration, serviceTimeEWMA);
 */
    public void onFailure(Exception e) {  
    private final String nodeId;  
                    .setOutboundNetworkTime(
        listener.onResponse(response);
    private final long startNanos;
 * ownership. Elasticsearch licenses this file to you under  
                response.getShardSearchRequest().setInboundNetworkTime(0);
            }  
 *  
 *
        }
/*  
 * this file be licensed under the Apache-2.0 license or a
                response.getShardSearchRequest().setOutboundNetworkTime(0);
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
            if (response.remoteAddress() != null) {
 */
 * KIND, either express or implied.  See the License for the
 * A wrapper of search action listeners (search results) that unwraps the query  
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.SearchPhaseResult;  
    SearchExecutionStatsCollector(ActionListener<SearchPhaseResult> listener, ResponseCollectorService collector, String nodeId) {
package org.opensearch.action.search;
                // update outbound network time for request sent over network for shard requests  
    @Override
        if (nodeId != null && queryResult != null) {
    }
 * result to get the piggybacked queue size and service time EWMA, adding those
public final class SearchExecutionStatsCollector implements ActionListener<SearchPhaseResult> {  
    }  
import org.opensearch.core.action.ActionListener;
 * GitHub history for details.
 */  
 * Modifications Copyright OpenSearch Contributors. See
