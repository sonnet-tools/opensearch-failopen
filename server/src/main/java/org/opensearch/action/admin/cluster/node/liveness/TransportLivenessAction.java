 * not use this file except in compliance with the License.
 *
        this.clusterService = clusterService;  
/*
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.transport.TransportRequestHandler;  
 * GitHub history for details.
    public TransportLivenessAction(ClusterService clusterService, TransportService transportService) {
 * this work for additional information regarding copyright
import org.opensearch.cluster.service.ClusterService;
            false /*can not trip circuit breaker*/,
        );
        transportService.registerRequestHandler(
    }  
            this
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void messageReceived(LivenessRequest request, TransportChannel channel, Task task) throws Exception {  
 * Licensed to Elasticsearch under one or more contributor  
public final class TransportLivenessAction implements TransportRequestHandler<LivenessRequest> {
 */
 * The OpenSearch Contributors require contributions made to  
 *
/**  
 * license agreements. See the NOTICE file distributed with
 *
    public static final String NAME = "cluster:monitor/nodes/liveness";
 * @opensearch.internal  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
    }
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
/*  
 * KIND, either express or implied.  See the License for the
package org.opensearch.action.admin.cluster.node.liveness;
 * specific language governing permissions and limitations
            false,
 *  
 */  
 * SPDX-License-Identifier: Apache-2.0
    private final ClusterService clusterService;
            ThreadPool.Names.SAME,  
 *     http://www.apache.org/licenses/LICENSE-2.0
        channel.sendResponse(new LivenessResponse(clusterService.getClusterName(), clusterService.localNode()));
 */  
            NAME,
/*  
    @Inject
 * software distributed under the License is distributed on an
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * Transport action for OpenSearch Node Liveness
}  
            LivenessRequest::new,  
 * under the License.  
import org.opensearch.threadpool.ThreadPool;
 */
import org.opensearch.transport.TransportService;
import org.opensearch.common.inject.Inject;
    @Override
import org.opensearch.tasks.Task;  
import org.opensearch.transport.TransportChannel;
