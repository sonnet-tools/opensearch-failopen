        IndexSettings indexSettings,  
        BigArrays bigArrays,
     *                     tools), in which case remote store fencing cannot be used
 * Licensed to Elasticsearch under one or more contributor  
     * @param allocationId the allocation id of the shard copy this translog belongs to, used as the owner identity of
    public static final ByteSizeValue DEFAULT_BUFFER_SIZE = new ByteSizeValue(1, ByteSizeUnit.MB);
     * The translog buffer size. Default is {@code 8kb}
        return seedRemote;
        IndexSettings indexSettings,  
    public TranslogConfig(  
        this.nodeId = nodeId;  
     * @param bigArrays a bigArrays instance used for temporarily allocating write operations
/**
        String nodeId,  
        return downloadRemoteTranslogOnInit;  
 *
     */
        String nodeId,
        ShardId shardId,
    public IndexSettings getIndexSettings() {
 * specific language governing permissions and limitations
    }  
        return shardId;
 * object will affect the {@link Translog} instance.
        this(shardId, translogPath, indexSettings, bigArrays, bufferSize, nodeId, null, seedRemote);  
        return allocationId;
    /**
        String allocationId,  
    private final ByteSizeValue bufferSize;
        boolean seedRemote
    public ShardId getShardId() {  
        this.translogPath = translogPath;
 * not use this file except in compliance with the License.
    }  
 * this work for additional information regarding copyright
 *
     */
    private final boolean seedRemote;
 */  
     */  
    ) {
    ) {  
    /**  
    /**
        this.bigArrays = bigArrays;
 */
    public BigArrays getBigArrays() {
        return nodeId;
     */
     * Returns the index indexSettings  
        boolean seedRemote
@PublicApi(since = "1.0.0")
    /**  
        String allocationId,
/*  
    }
        this.seedRemote = seedRemote;
        return indexSettings;  
    public Path getTranslogPath() {
    public boolean downloadRemoteTranslogOnInit() {
    TranslogConfig(  
     * @param seedRemote boolean denoting whether remote store needs to be seeded as part of remote migration
    private boolean downloadRemoteTranslogOnInit = true;  
 */  
        Path translogPath,  
     * @param translogPath the path to use for the transaction log files
 * the Apache License, Version 2.0 (the "License"); you may
    }
}  
 * ownership. Elasticsearch licenses this file to you under  
    private final String nodeId;  
        ShardId shardId,
        boolean seedRemote
        this(shardId, translogPath, indexSettings, bigArrays, DEFAULT_BUFFER_SIZE, nodeId, allocationId, seedRemote);  
 *  
     * Returns the translog path for this engine  
        String nodeId,  
    private final ShardId shardId;  
 */
    }
     * Returns a BigArrays instance for this engine
    /**
    }
 * The OpenSearch Contributors require contributions made to  
        ShardId shardId,
    public void setDownloadRemoteTranslogOnInit(boolean downloadRemoteTranslogOnInit) {  
        Path translogPath,
import org.opensearch.common.util.BigArrays;
        this.shardId = shardId;  
        ByteSizeValue bufferSize,
     */
 * You may obtain a copy of the License at  
    public String getAllocationId() {  
        this.allocationId = allocationId;
        ShardId shardId,
        this.downloadRemoteTranslogOnInit = downloadRemoteTranslogOnInit;
     */  
        BigArrays bigArrays,
     * Creates a new TranslogConfig instance  
        this.bufferSize = bufferSize;
        IndexSettings indexSettings,
    ) {
    ) {
     * The allocation id of the shard copy this translog belongs to, or {@code null} when the copy identity is  
        this(shardId, translogPath, indexSettings, bigArrays, DEFAULT_BUFFER_SIZE, nodeId, null, seedRemote);  
    public TranslogConfig(
 * Unless required by applicable law or agreed to in writing,
     */
        BigArrays bigArrays,
 *    http://www.apache.org/licenses/LICENSE-2.0
     * unknown (offline tools).
        return bufferSize;
    }
import org.opensearch.core.common.unit.ByteSizeValue;
 * this file be licensed under the Apache-2.0 license or a
 *
    }
 * software distributed under the License is distributed on an
import org.opensearch.core.index.shard.ShardId;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Creates a new TranslogConfig instance carrying the identity of the owning shard copy.
 * Holds all the configuration that is used to create a {@link Translog}.
/*
 * under the License.  
package org.opensearch.index.translog;
     * @param indexSettings the index settings used to set internal variables  
    }
    private final BigArrays bigArrays;
    }  
    private final Path translogPath;
public final class TranslogConfig {  
import org.opensearch.index.IndexSettings;  
     * Returns the shard ID this config is created for
    }
        boolean seedRemote
 * GitHub history for details.
        BigArrays bigArrays,
 * license agreements. See the NOTICE file distributed with
        IndexSettings indexSettings,  
/*  
 * Once {@link Translog} has been created with this object, changes to this  
    }  
    public static final ByteSizeValue EMPTY_TRANSLOG_BUFFER_SIZE = new ByteSizeValue(10, ByteSizeUnit.BYTES);  
        return bigArrays;
import org.opensearch.core.common.unit.ByteSizeUnit;  
    /**
        Path translogPath,
    public String getNodeId() {
        ByteSizeValue bufferSize,
        String nodeId,  
    /**  
import java.nio.file.Path;
     *                     the remote store fence; may be {@code null} when the copy identity is unknown (offline  
     */
        return translogPath;  
    private final String allocationId;
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        Path translogPath,
    }
    private final IndexSettings indexSettings;
    }
    /**
     * @param shardId the shard ID this translog belongs to
    public boolean shouldSeedRemote() {
    public ByteSizeValue getBufferSize() {  
        this.indexSettings = indexSettings;
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.api  
 * KIND, either express or implied.  See the License for the
    TranslogConfig(  
import org.opensearch.common.annotation.PublicApi;
