     * The shard is initializing (probably recovering from either a peer shard
     * or gateway).
/**  
package org.opensearch.cluster.routing;
    public static ShardRoutingState fromValue(byte value) {
 *
 * Represents the current state of a {@link ShardRouting} as defined by the
     * The shard is in the process being relocated.
     */
     * The shard is in the process of being split in-place.
        return this.value;
    UNASSIGNED((byte) 1),
                return STARTED;  
    STARTED((byte) 3),
}  
 */  
     * The shard is started.  
 * license agreements. See the NOTICE file distributed with
     */  
     */  
    /**  
     */
     */
                return INITIALIZING;
@PublicApi(since = "1.0.0")  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * GitHub history for details.
/*  
    ShardRoutingState(byte value) {
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
    }
        this.value = value;  
                throw new IllegalStateException("No routing state mapped for [" + value + "]");  
            case 5:  
    INITIALIZING((byte) 2),
    public byte value() {
 */  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
            case 2:  
            default:
 * this work for additional information regarding copyright
 * @opensearch.api
 * SPDX-License-Identifier: Apache-2.0
    /**  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 * cluster.
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    SPLITTING((byte) 5);
import org.opensearch.common.annotation.PublicApi;
 *  
            case 1:
    /**  
    /**
 */
 *
 * Licensed to Elasticsearch under one or more contributor  
     * The shard is not assigned to any node.  
    private byte value;  
        }
    /**
            case 3:
 * You may obtain a copy of the License at  
    RELOCATING((byte) 4),  
                return UNASSIGNED;
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
public enum ShardRoutingState {
     */  
                return SPLITTING;
     * Byte value of this {@link ShardRoutingState}
     * @return Byte value of this {@link ShardRoutingState}
        switch (value) {  
    /**
            case 4:
 */
 *  
/*
 * The OpenSearch Contributors require contributions made to  
/*  
                return RELOCATING;
