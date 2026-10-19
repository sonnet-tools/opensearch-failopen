}  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 *  
import org.opensearch.cluster.service.ClusterService;
     * an exception. Throwing an exception from an applier is very bad because it will stop the application of this state before it has
 */
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.api
 * A component that is in charge of applying an incoming cluster state to the node internal data structures.
     * Called when a new cluster state ({@link ClusterChangedEvent#state()} needs to be applied. The cluster state to be applied is already
 *
/*
 */  
package org.opensearch.cluster;
     */
 *
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
import org.opensearch.common.annotation.PublicApi;
/*  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
/**
     * committed when this method is called, so an applier must therefore be prepared to deal with any state it receives without throwing  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * compatible open source license.
@PublicApi(since = "1.0.0")
 * license agreements. See the NOTICE file distributed with
     * reached all the other appliers, and will likely result in another attempt to apply the same (or very similar) cluster state which
     * might continue until this node is removed from the cluster.  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
    /**
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * The single apply method is called before the cluster state becomes visible via {@link ClusterService#state()}.  
 * GitHub history for details.
public interface ClusterStateApplier {
 * KIND, either express or implied.  See the License for the
/*  
    void applyClusterState(ClusterChangedEvent event);
 * not use this file except in compliance with the License.
