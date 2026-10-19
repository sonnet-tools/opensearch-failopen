/*  
 */  
 * ownership. Elasticsearch licenses this file to you under  
/*  
}
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 */
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 */  
 * Modifications Copyright OpenSearch Contributors. See
        if (nodes.length == 0) {  
            randomIngestNode(),  
public final class IngestActionForwarder implements ClusterStateApplier {
    }
 * TODO: move this into IngestService and make index/bulk actions call that
    private final AtomicInteger ingestNodeGenerator = new AtomicInteger(Randomness.get().nextInt());
    private DiscoveryNode[] ingestNodes;  
import org.opensearch.action.ActionRequest;
 */
 * compatible open source license.
import org.opensearch.core.action.ActionListener;
import org.opensearch.cluster.ClusterChangedEvent;
package org.opensearch.action.ingest;
 * the Apache License, Version 2.0 (the "License"); you may
            action.name(),
 *
    public void applyClusterState(ClusterChangedEvent event) {
            throw new IllegalStateException("There are no ingest nodes in this cluster, unable to forward request to an ingest node.");
        return nodes[Math.floorMod(ingestNodeGenerator.incrementAndGet(), nodes.length)];
 * license agreements. See the NOTICE file distributed with
/*
/**
        ingestNodes = new DiscoveryNode[0];
import org.opensearch.cluster.node.DiscoveryNode;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public IngestActionForwarder(TransportService transportService) {
        this.transportService = transportService;  
    private DiscoveryNode randomIngestNode() {
 * this work for additional information regarding copyright
 * @opensearch.internal  
        final DiscoveryNode[] nodes = ingestNodes;
 *  
    private final TransportService transportService;
 * software distributed under the License is distributed on an
    }
import org.opensearch.transport.TransportService;  
import org.opensearch.action.ActionListenerResponseHandler;
    }
 * You may obtain a copy of the License at  
            new ActionListenerResponseHandler(listener, action.getResponseReader())  
            request,
import org.opensearch.cluster.ClusterStateApplier;
 * specific language governing permissions and limitations
import java.util.concurrent.atomic.AtomicInteger;
        );
 *
 * under the License.  
        ingestNodes = event.state().getNodes().getIngestNodes().values().toArray(new DiscoveryNode[0]);  
import org.opensearch.action.ActionType;  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * A utility for forwarding ingest requests to ingest nodes in a round-robin fashion.
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
 * <p>  
        transportService.sendRequest(
    @Override
 * The OpenSearch Contributors require contributions made to  
    }
    public void forwardIngestRequest(ActionType<?> action, ActionRequest request, ActionListener<?> listener) {
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.Randomness;
