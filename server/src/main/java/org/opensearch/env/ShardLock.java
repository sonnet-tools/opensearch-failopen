    public final void close() {
    }  
import org.opensearch.core.index.shard.ShardId;
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * before executing any write operations on the shards data directory.
        return "ShardLock{" + "shardId=" + shardId + '}';
 * this file be licensed under the Apache-2.0 license or a
 *
/*  
 */  
 *
import java.io.Closeable;
 *
    public String toString() {
 * A shard lock guarantees exclusive access to a shards data
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * directory. Internal processes should acquire a lock on a shard  
 * specific language governing permissions and limitations
/*
 * SPDX-License-Identifier: Apache-2.0
    protected abstract void closeInternal();
     */
 * KIND, either express or implied.  See the License for the
        return shardId;  
@PublicApi(since = "1.0.0")
 *
package org.opensearch.env;
        this.shardId = id;
    /**
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final ShardId shardId;
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.api
 * this work for additional information regarding copyright
     * only be called by the holder of this lock.
    public ShardLock(ShardId id) {
    @Override  
        }
 * software distributed under the License is distributed on an
    private final AtomicBoolean closed = new AtomicBoolean(false);
    }  
    public final ShardId getShardId() {
 * You may obtain a copy of the License at  
 */  
     */  
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
    }
            closeInternal();  
 * not use this file except in compliance with the License.
     * Update the details of the holder of this lock. These details are displayed alongside a {@link ShardLockObtainFailedException}. Must
 */  
 */
 * GitHub history for details.
        if (this.closed.compareAndSet(false, true)) {
 * @see NodeEnvironment  
/**
public abstract class ShardLock implements Closeable {
import org.opensearch.common.annotation.PublicApi;
    }
     * Returns the locks shards Id.  
    public void setDetails(String details) {}
 *  
 * ownership. Elasticsearch licenses this file to you under  
    /**  
import java.util.concurrent.atomic.AtomicBoolean;
}
