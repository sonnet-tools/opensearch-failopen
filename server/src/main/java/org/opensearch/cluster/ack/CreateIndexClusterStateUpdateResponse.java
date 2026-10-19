 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
        super(acknowledged);
 * compatible open source license.
/*  
}  
 *  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.cluster.ack;
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
/*  
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
        return shardsAcknowledged;
 * GitHub history for details.
 */
 * under the License.  
 *
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
    }
 * not use this file except in compliance with the License.
 * A cluster state update response with specific fields for index creation.
 */  
 * ownership. Elasticsearch licenses this file to you under  
    public boolean isShardsAcknowledged() {  
 * license agreements. See the NOTICE file distributed with
        this.shardsAcknowledged = shardsAcknowledged;  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
     * Returns whether the requisite number of shard copies started before the completion of the operation.
/**
public class CreateIndexClusterStateUpdateResponse extends ClusterStateUpdateResponse {  
 * Modifications Copyright OpenSearch Contributors. See
    /**  
 *
 * KIND, either express or implied.  See the License for the
    public CreateIndexClusterStateUpdateResponse(boolean acknowledged, boolean shardsAcknowledged) {
/*
     */
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 */
    private final boolean shardsAcknowledged;
