 * this file be licensed under the Apache-2.0 license or a
    }
    }
     * The failure message, if available, explaining why the shard failed.  
import org.opensearch.cluster.routing.ShardRouting;
}  
    @Nullable
 * ownership. Elasticsearch licenses this file to you under  
            + markAsStale  
 * not use this file except in compliance with the License.
            + ", message ["
 *
    private final ShardRouting routingEntry;
        return routingEntry;
    @Nullable
    public String toString() {
        this.routingEntry = routingEntry;  
        return markAsStale;
 */  
            + message
    /**
            + "], markAsStale ["
            + "]";
/*
 * @opensearch.internal
 *
 * Licensed to Elasticsearch under one or more contributor  
        return failure;  
     */
        this.markAsStale = markAsStale;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + "], failure ["  
 */  
 * KIND, either express or implied.  See the License for the
/*  
     */  
 * The OpenSearch Contributors require contributions made to  
        this.failure = failure;
 */
public class FailedShard {
import org.opensearch.common.Nullable;  
     */  
    private final String message;  
 */  
 * software distributed under the License is distributed on an
    }
 *  
     * The shard routing entry for the failed shard.
    }  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.ExceptionsHelper;
    public String getMessage() {  
        return "failed shard, shard "
            + routingEntry  
 * Modifications Copyright OpenSearch Contributors. See
/*  
    private final Exception failure;
    /**
/**
    private final boolean markAsStale;
        return message;
        this.message = message;
 * this work for additional information regarding copyright
    public boolean markAsStale() {  
 * GitHub history for details.
 * A class representing a failed shard.  
 * under the License.  
     * The exception, if present, causing the shard to fail.
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 *
    /**
            + (failure == null ? "null" : ExceptionsHelper.detailedMessage(failure))
    public Exception getFailure() {
    }
    @Override  
package org.opensearch.cluster.routing.allocation;
        assert routingEntry.assignedToNode() : "only assigned shards can be failed " + routingEntry;
    /**  
    }
    public FailedShard(ShardRouting routingEntry, String message, @Nullable Exception failure, boolean markAsStale) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
     */
 * compatible open source license.
     * Whether or not to mark the shard as stale (eg. removing from in-sync set) when failing the shard.
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
    public ShardRouting getRoutingEntry() {
