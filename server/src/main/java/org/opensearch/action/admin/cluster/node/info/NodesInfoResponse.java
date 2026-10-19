            XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
                nodeInfo.getInfo(TransportInfo.class).toXContent(builder, params);
import org.opensearch.core.xcontent.XContentBuilder;
        }  
import org.opensearch.common.settings.Settings;  
            }  
            }
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
                builder.humanReadableField("total_indexing_buffer_in_bytes", "total_indexing_buffer", nodeInfo.getTotalIndexingBuffer());
import org.opensearch.search.pipeline.SearchPipelineInfo;  
import java.util.List;
                Settings settings = nodeInfo.getSettings();
import java.io.IOException;
    }
            if (nodeInfo.getInfo(IngestInfo.class) != null) {
    protected void writeNodesTo(StreamOutput out, List<NodeInfo> nodes) throws IOException {  
 * this work for additional information regarding copyright
    }
 *
 */
            builder.field("host", nodeInfo.getNode().getHostName());  
        }  
            builder.field("name", nodeInfo.getNode().getName());
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
        builder.startObject("nodes");  
 * GitHub history for details.
        out.writeList(nodes);
 * @opensearch.api
        super(clusterName, nodes, failures);  
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Map;  
            }  
            if (nodeInfo.getInfo(PluginsAndModules.class) != null) {
 */  
            builder.startArray("roles");
            if (nodeInfo.getTotalIndexingBuffer() != null) {  
/*  
    }
 * Licensed to Elasticsearch under one or more contributor  
            builder.startObject();  
        super(in);
                nodeInfo.getInfo(ThreadPoolInfo.class).toXContent(builder, params);
            }  
import org.opensearch.transport.TransportInfo;
            return "{ \"error\" : \"" + e.getMessage() + "\"}";
 *  
                builder.startObject("settings");
 * You may obtain a copy of the License at  
                nodeInfo.getInfo(OsInfo.class).toXContent(builder, params);
            if (nodeInfo.getInfo(ProcessInfo.class) != null) {
            if (nodeInfo.getSettings() != null) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.ingest.IngestInfo;
    @Override
            }
                }
    @Override  
            }  
import org.opensearch.threadpool.ThreadPoolInfo;
 * under the License.  
            if (nodeInfo.getInfo(AggregationInfo.class) != null) {
            }  
            }  
import org.opensearch.action.FailedNodeException;
            }  
import org.opensearch.common.annotation.PublicApi;
        return in.readList(NodeInfo::new);
                builder.endObject();  
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
            if (nodeInfo.getInfo(OsInfo.class) != null) {
                builder.value(role.roleName());  
                for (Map.Entry<String, String> entry : nodeInfo.getNode().getAttributes().entrySet()) {  
import org.opensearch.http.HttpInfo;  
            builder.field("transport_address", nodeInfo.getNode().getAddress().toString());
import org.opensearch.action.support.nodes.BaseNodesResponse;
 */  
        for (NodeInfo nodeInfo : getNodes()) {
            toXContent(builder, EMPTY_PARAMS);
                settings.toXContent(builder, params);  
                nodeInfo.getInfo(AggregationInfo.class).toXContent(builder, params);
            for (DiscoveryNodeRole role : nodeInfo.getNode().getRoles()) {
 *
    public NodesInfoResponse(StreamInput in) throws IOException {
            builder.field("build_type", nodeInfo.getBuild().type().displayName());
        } catch (IOException e) {
import org.opensearch.cluster.ClusterName;  
            if (nodeInfo.getInfo(JvmInfo.class) != null) {
import org.opensearch.core.common.io.stream.StreamOutput;  
            if (nodeInfo.getInfo(TransportInfo.class) != null) {
        try {
                nodeInfo.getInfo(JvmInfo.class).toXContent(builder, params);
 * Unless required by applicable law or agreed to in writing,
                nodeInfo.getInfo(HttpInfo.class).toXContent(builder, params);
public class NodesInfoResponse extends BaseNodesResponse<NodeInfo> implements ToXContentFragment {
 * SPDX-License-Identifier: Apache-2.0
    }  
@PublicApi(since = "1.0.0")
            }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * specific language governing permissions and limitations
/*
                builder.startObject("attributes");
        return builder;
            if (nodeInfo.getInfo(HttpInfo.class) != null) {
import org.opensearch.monitor.process.ProcessInfo;
import org.opensearch.core.xcontent.ToXContentFragment;
            builder.endObject();
            }
    protected List<NodeInfo> readNodesFrom(StreamInput in) throws IOException {
    }  
import org.opensearch.cluster.node.DiscoveryNodeRole;
                    builder.field(entry.getKey(), entry.getValue());
            if (nodeInfo.getInfo(ThreadPoolInfo.class) != null) {
import org.opensearch.monitor.jvm.JvmInfo;
                nodeInfo.getInfo(SearchPipelineInfo.class).toXContent(builder, params);
package org.opensearch.action.admin.cluster.node.info;
 */  
            }  
import org.opensearch.search.aggregations.support.AggregationInfo;
                builder.endObject();
                nodeInfo.getInfo(ProcessInfo.class).toXContent(builder, params);
            builder.endObject();
import org.opensearch.monitor.os.OsInfo;  
            builder.endArray();
            builder.field("version", nodeInfo.getVersion());  
    @Override
            builder.field("build_hash", nodeInfo.getBuild().hash());
        builder.endObject();
/**
import org.opensearch.common.xcontent.XContentFactory;
            if (nodeInfo.getInfo(SearchPipelineInfo.class) != null) {
 * ownership. Elasticsearch licenses this file to you under  
            }
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
/*  
            return builder.toString();  
}
    public String toString() {  
    }  
            }  
    public NodesInfoResponse(ClusterName clusterName, List<NodeInfo> nodes, List<FailedNodeException> failures) {
                nodeInfo.getInfo(IngestInfo.class).toXContent(builder, params);
 *
                nodeInfo.getInfo(PluginsAndModules.class).toXContent(builder, params);
            if (!nodeInfo.getNode().getAttributes().isEmpty()) {
 * Transport response for OpenSearch Node Information  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            builder.startObject(nodeInfo.getNode().getId());
            builder.field("ip", nodeInfo.getNode().getHostAddress());
