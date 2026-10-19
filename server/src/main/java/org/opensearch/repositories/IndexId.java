     * use to name blobs for the index.
import org.opensearch.index.remote.RemoteStoreEnums;
        return Objects.equals(name, that.name) && Objects.equals(id, that.id) && Objects.equals(this.shardPathType, that.shardPathType);
            this.shardPathType = DEFAULT_SHARD_PATH_TYPE;
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
package org.opensearch.repositories;
import org.opensearch.core.common.io.stream.StreamInput;  
public final class IndexId implements Writeable, ToXContentObject {  
    public int getShardPathType() {
        }  
 * The OpenSearch Contributors require contributions made to  
        return name;
        this.id = id;  
     * index's UUID, but merely a unique file/URL friendly identifier that a repository can
 *
        return shardPathType;  
 * You may obtain a copy of the License at  
    @Override  
import java.util.Objects;
 * not use this file except in compliance with the License.
        this.shardPathType = shardPathType;
    /**
 *
        this.hashCode = computeHashCode();
    public IndexId(String name, String id, int shardPathType) {
    public void writeTo(final StreamOutput out) throws IOException {  
     */  
    @Override
        out.writeString(id);
    private final String name;  
 * @opensearch.api  
 * ownership. Elasticsearch licenses this file to you under  
    public boolean equals(Object o) {  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
        builder.field(ID, id);  
 * SPDX-License-Identifier: Apache-2.0
@PublicApi(since = "1.0.0")
        this.hashCode = computeHashCode();
    }  
 * license agreements. See the NOTICE file distributed with
    }  
        if (o == null || getClass() != o.getClass()) {
        builder.field(SHARD_PATH_TYPE, shardPathType);
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {  
    public static final int DEFAULT_SHARD_PATH_TYPE = RemoteStoreEnums.PathType.FIXED.getCode();
     */
        return id;
        builder.field(NAME, name);
 * Represents a single snapshotted index in the repository.
        builder.startObject();
    @Override
        return hashCode;
/*
 * compatible open source license.
    /**
        this.name = in.readString();  
    public IndexId(final StreamInput in) throws IOException {
     * The name of the index.
    public int hashCode() {  
     * The storage path type in remote store for the indexes having the underlying index ids.  
 */  
    public IndexId(final String name, final String id) {  
            return false;
 * under the License.  
     * We could not use the index's actual UUID (See {@link Index#getUUID()}) because in the
    static final String ID = "id";
import org.opensearch.Version;
        if (this == o) {
    }
        return builder;  
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {  
/*  
import org.opensearch.common.annotation.PublicApi;
    }
/**  
     */  
            out.writeVInt(shardPathType);
    static final String NAME = "name";
    }
     * index it was snapshot from, and so we are using a separate UUID here.
    /**
    private final int shardPathType;
        out.writeString(name);
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentBuilder;  
            return true;
    }
    private final int hashCode;  
        }
        } else {
 * this work for additional information regarding copyright
        IndexId that = (IndexId) o;
    }  
            this.shardPathType = in.readVInt();  
        }  
        this.id = in.readString();
    private int computeHashCode() {
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.Writeable;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.ToXContent;
    }
}
 * GitHub history for details.
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 */
        return Objects.hash(name, id, shardPathType);
import java.io.IOException;  
        this.name = name;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    public String toString() {
 */  
    private final String id;
    @Override
    // Used for testing only
        this(name, id, DEFAULT_SHARD_PATH_TYPE);
     * from the index UUID assigned to it when it is restored. Hence, the actual index UUID  
        builder.endObject();
        return "[" + name + "/" + id + "/" + shardPathType + "]";
        }  
 *  
 * software distributed under the License is distributed on an
     * The unique ID for the index within the repository.  This is *not* the same as the  
 * KIND, either express or implied.  See the License for the
     * <p>  
    static final String SHARD_PATH_TYPE = "shard_path_type";  
    }  
/*  
    }  
     * is not useful in the context of snapshot/restore for tying a snapshotted index to the
     * case of snapshot/restore, the index UUID in the snapshotted index will be different
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.index.Index;  
    public String getName() {
    public String getId() {
 *
    }  
    @Override
import org.opensearch.core.xcontent.ToXContentObject;
 */
