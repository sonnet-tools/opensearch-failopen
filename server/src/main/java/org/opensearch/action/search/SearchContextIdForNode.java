        this.searchContextId = new ShardSearchContextId(in);  
 */  
 * software distributed under the License is distributed on an
import java.io.IOException;
            + '\''  
 *  
    public String toString() {  
    public ShardSearchContextId getSearchContextId() {
        this.searchContextId = searchContextId;  
    }
 *
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + ", seachContextId="
    }  
}  
        searchContextId.writeTo(out);
        this.node = in.readString();
import org.opensearch.search.internal.ShardSearchContextId;  
import org.opensearch.core.common.io.stream.StreamInput;  
    }
    }
        return node;
 */  
package org.opensearch.action.search;
            + ", clusterAlias='"
    public void writeTo(StreamOutput out) throws IOException {
@PublicApi(since = "1.0.0")  
        this.node = node;
    public String getClusterAlias() {  
    }
 *  
 * not use this file except in compliance with the License.
/*  
 * Unless required by applicable law or agreed to in writing,
    }  
 * the Apache License, Version 2.0 (the "License"); you may
            + searchContextId  
 * compatible open source license.
        return "SearchContextIdForNode{"
 * under the License.  
    private final String node;
import org.opensearch.common.annotation.PublicApi;
 * KIND, either express or implied.  See the License for the
    @Override  
            + node  
 * You may obtain a copy of the License at  
            + '}';
import org.opensearch.common.Nullable;
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
/*
/**
    private final String clusterAlias;
import org.opensearch.core.common.io.stream.StreamOutput;
            + clusterAlias
 * Id for a search context per node.
 */
        return clusterAlias;
    SearchContextIdForNode(StreamInput in) throws IOException {  
 * @opensearch.api
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
    @Override
    }
    @Nullable
 * Modifications Copyright OpenSearch Contributors. See
 *
    public SearchContextIdForNode(@Nullable String clusterAlias, String node, ShardSearchContextId searchContextId) {  
        this.clusterAlias = clusterAlias;
        return searchContextId;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.Writeable;
    private final ShardSearchContextId searchContextId;  
            + '\''
 * The OpenSearch Contributors require contributions made to  
        out.writeOptionalString(clusterAlias);  
public final class SearchContextIdForNode implements Writeable {
            + "node='"
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
    public String getNode() {
        this.clusterAlias = in.readOptionalString();
        out.writeString(node);
 * ownership. Elasticsearch licenses this file to you under  
