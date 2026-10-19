 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 *  
 */
    }
 * GitHub history for details.
/*  
import org.opensearch.action.support.ActiveShardCount;  
        return this;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal  
    }
 *
 * under the License.  
 * not use this file except in compliance with the License.
    public ActiveShardCount waitForActiveShards() {
 *
 */  
 */
 * this work for additional information regarding copyright
/*
    public OpenIndexClusterStateUpdateRequest waitForActiveShards(ActiveShardCount waitForActiveShards) {
 */
 * Cluster state update request that allows to open one or more indices
 * this file be licensed under the Apache-2.0 license or a
}  
    public OpenIndexClusterStateUpdateRequest() {  
 * KIND, either express or implied.  See the License for the
        this.waitForActiveShards = waitForActiveShards;  
 * specific language governing permissions and limitations
    }  
    private ActiveShardCount waitForActiveShards = ActiveShardCount.DEFAULT;
/**  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See  
 * compatible open source license.
        return waitForActiveShards;
 * You may obtain a copy of the License at  
import org.opensearch.cluster.ack.IndicesClusterStateUpdateRequest;
 *     http://www.apache.org/licenses/LICENSE-2.0
public class OpenIndexClusterStateUpdateRequest extends IndicesClusterStateUpdateRequest<OpenIndexClusterStateUpdateRequest> {
 *
package org.opensearch.action.admin.indices.open;
/*
