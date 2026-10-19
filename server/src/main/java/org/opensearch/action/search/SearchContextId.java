import org.opensearch.core.common.bytes.BytesReference;
 * license agreements. See the NOTICE file distributed with
        this.aliasFilter = aliasFilter;
        }  
            return new SearchContextId(Collections.unmodifiableMap(shards), Collections.unmodifiableMap(aliasFilters));
    }
 */
 *
 * the Apache License, Version 2.0 (the "License"); you may
                throw new IllegalArgumentException("Not all bytes were read");  
import org.opensearch.Version;
                indices.add(indexName);
            if (Strings.isEmpty(clusterAlias)) {
 *  
import java.util.Set;  
 * Id for a serach context.  
                indices.add(clusterAlias + RemoteClusterAware.REMOTE_CLUSTER_INDEX_SEPARATOR + indexName);
import java.util.Collections;
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
            final Version version = in.readVersion();
    }  
import org.opensearch.transport.RemoteClusterAware;
            final String clusterAlias = entry.getValue().getClusterAlias();  
import org.opensearch.common.io.stream.BytesStreamOutput;
 * You may obtain a copy of the License at  
        }
        }
            out.writeMap(shards, (o, k) -> k.writeTo(o), (o, v) -> v.writeTo(o));  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
        } catch (Exception e) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class SearchContextId {
            byteBuffer = ByteBuffer.wrap(Base64.getUrlDecoder().decode(id));
import java.util.Base64;  
import java.util.HashSet;  
import java.io.IOException;
        final ByteBuffer byteBuffer;  
    public Map<ShardId, SearchContextIdForNode> shards() {
import org.opensearch.core.common.io.stream.StreamInput;
            } else {  
 * Modifications Copyright OpenSearch Contributors. See
    private final Map<ShardId, SearchContextIdForNode> shards;
 *
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
    private SearchContextId(Map<ShardId, SearchContextIdForNode> shards, Map<String, AliasFilter> aliasFilter) {
    }  
import org.opensearch.search.SearchShardTarget;  
    }
}  
import org.opensearch.search.internal.AliasFilter;
    public static SearchContextId decode(NamedWriteableRegistry namedWriteableRegistry, String id) {
 * this work for additional information regarding copyright
 * @opensearch.internal
    public String[] getActualIndices() {
            }
/**
            throw new IllegalArgumentException("invalid id: [" + id + "]", e);
            final String indexName = entry.getKey().getIndexName();
 * specific language governing permissions and limitations
        final Set<String> indices = new HashSet<>();  
                new SearchContextIdForNode(target.getClusterAlias(), target.getNodeId(), searchPhaseResult.getContextId())  
            throw new IllegalArgumentException("invalid id: [" + id + "]", e);
            in.setVersion(version);
                target.getShardId(),
    public Map<String, AliasFilter> aliasFilter() {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        for (Map.Entry<ShardId, SearchContextIdForNode> entry : shards().entrySet()) {
import org.opensearch.core.common.io.stream.StreamOutput;  
        } catch (IOException e) {  
            out.writeVersion(version);
import java.nio.ByteBuffer;
    }
import java.util.HashMap;
    private final Map<String, AliasFilter> aliasFilter;  
 */  
import org.opensearch.core.common.io.stream.ByteBufferStreamInput;
        }
            out.setVersion(version);
import org.opensearch.search.SearchPhaseResult;
 * Unless required by applicable law or agreed to in writing,
        return aliasFilter;  
            throw new IllegalArgumentException(e);
            }
 *
import java.util.Map;
 * ownership. Elasticsearch licenses this file to you under  
            out.writeMap(aliasFilter, StreamOutput::writeString, (o, v) -> v.writeTo(o));
        try (StreamInput in = new NamedWriteableAwareStreamInput(new ByteBufferStreamInput(byteBuffer), namedWriteableRegistry)) {  
/*
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
            return Base64.getUrlEncoder().encodeToString(BytesReference.toBytes(out.bytes()));
/*  
import org.opensearch.core.index.shard.ShardId;
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
package org.opensearch.action.search;
            shards.put(
            if (in.available() > 0) {
 */  
    public static String encode(List<SearchPhaseResult> searchPhaseResults, Map<String, AliasFilter> aliasFilter, Version version) {  
 */  
import org.opensearch.core.common.Strings;  
            final Map<ShardId, SearchContextIdForNode> shards = in.readMap(ShardId::new, SearchContextIdForNode::new);  
        try {
            final Map<String, AliasFilter> aliasFilters = in.readMap(StreamInput::readString, AliasFilter::new);
        final Map<ShardId, SearchContextIdForNode> shards = new HashMap<>();
    }  
        return shards;
 * this file be licensed under the Apache-2.0 license or a
/*  
        } catch (IOException e) {  
        for (SearchPhaseResult searchPhaseResult : searchPhaseResults) {
 * KIND, either express or implied.  See the License for the
 * under the License.  
            );
 * GitHub history for details.
        this.shards = shards;  
        return indices.toArray(new String[0]);
            final SearchShardTarget target = searchPhaseResult.getSearchShardTarget();  
        }
