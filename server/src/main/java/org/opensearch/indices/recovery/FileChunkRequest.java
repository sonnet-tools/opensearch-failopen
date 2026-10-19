        return metadata.name();  
        assert writtenBy != null;
        out.writeLong(recoveryId);
        shardId = new ShardId(in);  
        sourceThrottleTimeInNanos = in.readLong();
        shardId.writeTo(out);  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public long position() {  
public final class FileChunkRequest extends RecoveryTransportRequest {
    }
 * not use this file except in compliance with the License.
    public void writeTo(StreamOutput out) throws IOException {  
        boolean lastChunk,  
    }
 * The OpenSearch Contributors require contributions made to  
        this.position = position;
        String name = in.readString();
     * Returns <code>true</code> if this chunk is the last chunk in the stream.
        out.writeBoolean(lastChunk);
    ) {  
 *
        this.metadata = metadata;
        return shardId;
    private final long sourceThrottleTimeInNanos;
    private final int totalTranslogOps;
import org.apache.lucene.util.Version;
        out.writeString(metadata.writtenBy().toString());  
    public boolean lastChunk() {  
 */  
        position = in.readVLong();
        this.recoveryId = recoveryId;
     */
import org.opensearch.index.store.StoreFileMetadata;
        super(requestSeqNo);
    public BytesReference content() {
        super.writeTo(out);
        out.writeVInt(totalTranslogOps);
    }  
/*
        return this.recoveryId;
    private final long position;
    public long length() {
        int totalTranslogOps,
        final long requestSeqNo,
 *
        this.content = content;  
import java.io.IOException;  
    }  
        return totalTranslogOps;
        return content;  
        this.shardId = shardId;  
    }
 * GitHub history for details.
        out.writeString(metadata.name());
 */  
        Version writtenBy = Lucene.parseVersionLenient(in.readString(), null);  
 * specific language governing permissions and limitations
        return metadata;  
 * under the License.  
    }  
        out.writeVLong(position);
        totalTranslogOps = in.readVInt();
        recoveryId = in.readLong();
    public int totalTranslogOps() {  
        StoreFileMetadata metadata,  
 */
    }  
        content = in.readBytesReference();
    private final boolean lastChunk;
 *
    }
}  
        this.sourceThrottleTimeInNanos = sourceThrottleTimeInNanos;  
    }
    public FileChunkRequest(StreamInput in) throws IOException {  
import org.opensearch.core.common.io.stream.StreamOutput;
    public String toString() {
        out.writeVLong(metadata.length());  
        long position,
    }
    public String name() {
    @Override  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
/*  
/**
    public FileChunkRequest(
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
        out.writeString(metadata.checksum());
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
        out.writeBytesReference(content);
    }  
        return sourceThrottleTimeInNanos;
    private final BytesReference content;  
package org.opensearch.indices.recovery;
        ShardId shardId,
        BytesReference content,
    private final StoreFileMetadata metadata;
import org.opensearch.common.lucene.Lucene;
 * @opensearch.internal
        metadata = new StoreFileMetadata(name, length, checksum, writtenBy);
    public long sourceThrottleTimeInNanos() {
        super(in);
    }
import org.opensearch.core.common.bytes.BytesReference;  
        String checksum = in.readString();
import org.opensearch.core.index.shard.ShardId;  
        this.totalTranslogOps = totalTranslogOps;
 * license agreements. See the NOTICE file distributed with
    public StoreFileMetadata metadata() {
    @Override
    public long recoveryId() {  
    /**  
 * ownership. Elasticsearch licenses this file to you under  
        return position;
        lastChunk = in.readBoolean();  
    private final ShardId shardId;
        return metadata.length();
    }
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * Request containing a file chunk.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
    }
        long recoveryId,  
 */  
 *  
 * this file be licensed under the Apache-2.0 license or a
        out.writeLong(sourceThrottleTimeInNanos);  
        return lastChunk;
        long sourceThrottleTimeInNanos
/*  
        return shardId + ": name='" + name() + '\'' + ", position=" + position + ", length=" + length();
        this.lastChunk = lastChunk;
    public ShardId shardId() {
        long length = in.readVLong();  
    private final long recoveryId;  
