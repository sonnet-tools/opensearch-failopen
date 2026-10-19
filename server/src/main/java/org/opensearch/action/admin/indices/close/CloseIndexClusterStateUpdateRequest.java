    public CloseIndexClusterStateUpdateRequest(final long taskId) {
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 *
 * @opensearch.internal  
        this.taskId = taskId;
}
 */  
 */
 */
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See  
 * GitHub history for details.
 * compatible open source license.
        return this;
        this.taskId = taskId;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        return waitForActiveShards;  
 * not use this file except in compliance with the License.
/**  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public ActiveShardCount waitForActiveShards() {
    }  
 * The OpenSearch Contributors require contributions made to  
 */
    public CloseIndexClusterStateUpdateRequest taskId(final long taskId) {  
import org.opensearch.action.support.ActiveShardCount;  
public class CloseIndexClusterStateUpdateRequest extends IndicesClusterStateUpdateRequest<CloseIndexClusterStateUpdateRequest> {
    }  
        this.waitForActiveShards = waitForActiveShards;
 * SPDX-License-Identifier: Apache-2.0
    private ActiveShardCount waitForActiveShards = ActiveShardCount.DEFAULT;
 *  
 * specific language governing permissions and limitations
/*  
 * Cluster state update request that allows to close one or more indices
 * under the License.  
/*
        return taskId;  
    public long taskId() {
    }  
package org.opensearch.action.admin.indices.close;
        return this;
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.ack.IndicesClusterStateUpdateRequest;
 * this work for additional information regarding copyright
    }
    private long taskId;
    }
/*
 * software distributed under the License is distributed on an
    public CloseIndexClusterStateUpdateRequest waitForActiveShards(final ActiveShardCount waitForActiveShards) {  
 * You may obtain a copy of the License at  
 *
 * Unless required by applicable law or agreed to in writing,
