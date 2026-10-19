 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
    private final APIBlock block;
        this.taskId = taskId;  
        return taskId;
 *
        this.taskId = taskId;  
 * the Apache License, Version 2.0 (the "License"); you may
 */
    public AddIndexBlockClusterStateUpdateRequest(final APIBlock block, final long taskId) {
 */
    }  
 * under the License.  
public class AddIndexBlockClusterStateUpdateRequest extends IndicesClusterStateUpdateRequest<AddIndexBlockClusterStateUpdateRequest> {
 */
/*
 * Cluster state update request that allows to add a block to one or more indices
import org.opensearch.cluster.metadata.IndexMetadata.APIBlock;
 * license agreements. See the NOTICE file distributed with
package org.opensearch.action.admin.indices.readonly;
    public long taskId() {  
        return this;
    }
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal  
}  
        this.block = block;
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See  
/**  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
/*
    }
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
    }
 *
import org.opensearch.cluster.ack.IndicesClusterStateUpdateRequest;  
 * ownership. Elasticsearch licenses this file to you under  
    private long taskId;
    public AddIndexBlockClusterStateUpdateRequest taskId(final long taskId) {
 * GitHub history for details.
/*  
 */  
 *
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
        return block;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public APIBlock getBlock() {
 *  
 * The OpenSearch Contributors require contributions made to  
