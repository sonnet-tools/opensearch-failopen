        nodes = in.readArray(DiscoveryNode::new, DiscoveryNode[]::new);
 * the Apache License, Version 2.0 (the "License"); you may
        indicesAndFilters = in.readMap(StreamInput::readString, AliasFilter::new);  
 * Unless required by applicable law or agreed to in writing,
 */  
        if (indicesAndFilters != null) {
        out.writeArray(groups);
            builder.startObject("indices");
    }  
                String index = entry.getKey();
 * Transport response for searching shards  
}
import org.opensearch.search.internal.AliasFilter;
                    if (aliasFilter.getQueryBuilder() != null) { // might be null if we include non-filtering aliases
 * software distributed under the License is distributed on an
                        builder.field("filter");  
        builder.endArray();  
        this.nodes = nodes;
import org.opensearch.core.action.ActionResponse;  
            builder.endObject();  
 * this file be licensed under the Apache-2.0 license or a
 *
    public Map<String, AliasFilter> getIndicesAndFilters() {
            group.toXContent(builder, params);
 * KIND, either express or implied.  See the License for the
        return nodes;
        builder.startObject();
import org.opensearch.common.annotation.PublicApi;
 * this work for additional information regarding copyright
        ClusterSearchShardsGroup[] groups,
    @Override  
 * @opensearch.api
        builder.startArray("shards");
        builder.startObject("nodes");
@PublicApi(since = "1.0.0")
 * under the License.  
                builder.endObject();
        super(in);  
    public void writeTo(StreamOutput out) throws IOException {
    }
                    Arrays.sort(aliases); // we want consistent ordering here and these values might be generated from a set / map  
        return groups;  
 * license agreements. See the NOTICE file distributed with
    }  
import java.io.IOException;
    private final ClusterSearchShardsGroup[] groups;
    }  
        }
package org.opensearch.action.admin.cluster.shards;
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            node.toXContent(builder, params);
                }  
        out.writeArray(nodes);  
        builder.endObject();
 * SPDX-License-Identifier: Apache-2.0
 *
        DiscoveryNode[] nodes,  
        this.groups = groups;  
 */  
/*
    public ClusterSearchShardsResponse(StreamInput in) throws IOException {
        Map<String, AliasFilter> indicesAndFilters
import org.opensearch.core.xcontent.ToXContentObject;  
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;
    public DiscoveryNode[] getNodes() {  
        this.indicesAndFilters = indicesAndFilters;
 *  
        groups = in.readArray(ClusterSearchShardsGroup::new, ClusterSearchShardsGroup[]::new);
        for (ClusterSearchShardsGroup group : groups) {  
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
                AliasFilter aliasFilter = entry.getValue();  
    private final DiscoveryNode[] nodes;
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.cluster.node.DiscoveryNode;
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
/**
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
        builder.endObject();  
    }
        return indicesAndFilters;
 * The OpenSearch Contributors require contributions made to  
        }
 */
    }
                builder.startObject(index);
        for (DiscoveryNode node : nodes) {  
    public ClusterSearchShardsGroup[] getGroups() {
            for (Map.Entry<String, AliasFilter> entry : indicesAndFilters.entrySet()) {  
import java.util.Arrays;
        }
 * Modifications Copyright OpenSearch Contributors. See
    }
import java.util.Map;  
            }
 * GitHub history for details.
 * You may obtain a copy of the License at  
                    }
                String[] aliases = aliasFilter.getAliases();
                if (aliases.length > 0) {
/*  
                    builder.array("aliases", aliases);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
import org.opensearch.core.xcontent.XContentBuilder;
    ) {
                        aliasFilter.getQueryBuilder().toXContent(builder, params);
        out.writeMap(indicesAndFilters, StreamOutput::writeString, (o, s) -> s.writeTo(o));
    public ClusterSearchShardsResponse(
public class ClusterSearchShardsResponse extends ActionResponse implements ToXContentObject {
/*  
    private final Map<String, AliasFilter> indicesAndFilters;  
        return builder;
