     * Returns whether the requisite number of shard copies started before the completion of the operation.  
 * software distributed under the License is distributed on an
        super(acknowledged);
 *
package org.opensearch.cluster.ack;
 */
 * this file be licensed under the Apache-2.0 license or a
    /**
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * license agreements. See the NOTICE file distributed with
 *  
    public OpenIndexClusterStateUpdateResponse(boolean acknowledged, boolean shardsAcknowledged) {  
/**  
 *     http://www.apache.org/licenses/LICENSE-2.0
    private final boolean shardsAcknowledged;
        return shardsAcknowledged;  
 */  
 * this work for additional information regarding copyright
     */
}
 * compatible open source license.
/*
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
public class OpenIndexClusterStateUpdateResponse extends ClusterStateUpdateResponse {
        this.shardsAcknowledged = shardsAcknowledged;
 * GitHub history for details.
 *
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal  
    public boolean isShardsAcknowledged() {
/*
 * not use this file except in compliance with the License.
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 *
 * A cluster state update response with specific fields for index opening.
/*  
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
 */
    }
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
