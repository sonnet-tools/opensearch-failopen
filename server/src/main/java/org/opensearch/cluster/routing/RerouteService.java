import org.opensearch.core.action.ActionListener;  
    /**
 *
@FunctionalInterface
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * Asynchronously performs a cluster reroute, updating any shard states and rebalancing the cluster if appropriate.  
/**
     */
import org.opensearch.common.annotation.PublicApi;
     * Schedule a cluster reroute.  
 * compatible open source license.
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
import org.opensearch.common.Priority;
     *                 this reroute is batched with the pending one; if there is already a pending reroute at a lower priority then
package org.opensearch.cluster.routing;
 * under the License.  
    void reroute(String reason, Priority priority, ActionListener<ClusterState> listener);
 *
public interface RerouteService {  
 * Modifications Copyright OpenSearch Contributors. See  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 *  
 */
@PublicApi(since = "1.0.0")
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
/*
 */  
import org.opensearch.cluster.ClusterState;  
 * ownership. Elasticsearch licenses this file to you under  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
     *                 the priority of the pending batch is raised to the given priority.  
}  
 */  
 *
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api
     * @param priority the (minimum) priority at which to run this reroute. If there is already a pending reroute at a higher priority then
 * Licensed to Elasticsearch under one or more contributor  
/*
 * GitHub history for details.
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
