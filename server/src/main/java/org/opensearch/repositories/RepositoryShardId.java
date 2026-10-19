 *
        out.writeVInt(shard);
 * Represents a shard snapshot in a repository.
        return that.index.equals(index) && that.shard == shard;
/*  
        this(new IndexId(in), in.readVInt());
/**  
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.annotation.PublicApi;
    public String indexName() {
 *
public final class RepositoryShardId implements Writeable {  
    }
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.Writeable;
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 * software distributed under the License is distributed on an
import java.util.Objects;
        return index.getName();  
}  
    private final int shard;
    }
 *
    public String toString() {  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
@PublicApi(since = "1.0.0")
import java.io.IOException;  
    }
        if (!(obj instanceof RepositoryShardId that)) {
    public int shardId() {  
 */  
        this.index = index;
import org.opensearch.core.common.io.stream.StreamInput;
    public IndexId index() {
    public int hashCode() {
    @Override
 * this file be licensed under the Apache-2.0 license or a
    public RepositoryShardId(StreamInput in) throws IOException {  
            return false;  
 * @opensearch.api  
/*  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 * under the License.  
    public RepositoryShardId(IndexId index, int shard) {  
 */
/*
    private final IndexId index;
 * GitHub history for details.
        return index;
        }
    }
    }  
        return Objects.hash(index, shard);  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    }  
        assert index != null;
        return "RepositoryShardId{" + index + "}{" + shard + "}";
    @Override  
        index.writeTo(out);
 * Unless required by applicable law or agreed to in writing,
        if (this == obj) {
 * The OpenSearch Contributors require contributions made to  
        return shard;
    }  
        this.shard = shard;  
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamOutput;  
 * compatible open source license.
package org.opensearch.repositories;
 */
    public boolean equals(Object obj) {
    public void writeTo(StreamOutput out) throws IOException {  
 *  
 * ownership. Elasticsearch licenses this file to you under  
            return true;  
        }
 * specific language governing permissions and limitations
