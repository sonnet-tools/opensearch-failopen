 * GitHub history for details.
            builder.endObject();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override  
        builder.startObject("nodes");  
 */  
        }  
    public static class NodeResponse extends BaseNodeResponse {
 */
 *
import org.opensearch.action.support.nodes.BaseNodesResponse;
     * Inner Node Response  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        }  
import org.opensearch.core.xcontent.ToXContentFragment;
import org.opensearch.cluster.ClusterName;
import java.util.List;
 * ownership. Elasticsearch licenses this file to you under  
    @Override
        public NodeResponse(StreamInput in) throws IOException {
        super(clusterName, nodes, failures);  
        public int hashCode() {  
import org.opensearch.core.common.io.stream.StreamOutput;  
                out.writeException(reloadException);
 *     http://www.apache.org/licenses/LICENSE-2.0
        } catch (final IOException e) {  
            if (e != null) {
 */  
            super.writeTo(out);
}
package org.opensearch.action.admin.cluster.node.reload;
import org.opensearch.action.FailedNodeException;
     * @opensearch.internal
 */
    }
 * Modifications Copyright OpenSearch Contributors. See
/**
        }
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
                OpenSearchException.generateThrowableXContent(builder, params, e);
 *  
import java.io.IOException;
        out.writeList(nodes);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                out.writeBoolean(true);
            builder.startObject(node.getNode().getId());
                builder.endObject();
            if (o == null || getClass() != o.getClass()) {
            super(in);  
        super(in);
    }
 * under the License.  
import org.opensearch.common.xcontent.XContentFactory;
        return builder;
import org.opensearch.OpenSearchException;
    implements
        }
        try {  
 * You may obtain a copy of the License at  
        for (final NodesReloadSecureSettingsResponse.NodeResponse node : getNodes()) {
            return reloadException != null ? reloadException.equals(that.reloadException) : that.reloadException == null;
        public void writeTo(StreamOutput out) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
/*
                return true;
            super(node);
            builder.startObject();
    /**
    public NodesReloadSecureSettingsResponse(ClusterName clusterName, List<NodeResponse> nodes, List<FailedNodeException> failures) {
        }  
        }
        }
        builder.endObject();  
            toXContent(builder, EMPTY_PARAMS);  
            }  
        public boolean equals(Object o) {  
import org.opensearch.core.xcontent.XContentBuilder;
    }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamInput;
                out.writeBoolean(false);
 * the Apache License, Version 2.0 (the "License"); you may
        @Override  
     */  
    public NodesReloadSecureSettingsResponse(StreamInput in) throws IOException {
    protected List<NodesReloadSecureSettingsResponse.NodeResponse> readNodesFrom(StreamInput in) throws IOException {
            } else {  
            return "{ \"error\" : \"" + e.getMessage() + "\"}";
    public String toString() {
     *
        @Override
            }  
            }
            if (in.readBoolean()) {
    @Override
    protected void writeNodesTo(StreamOutput out, List<NodesReloadSecureSettingsResponse.NodeResponse> nodes) throws IOException {  
            if (reloadException != null) {  
            builder.endObject();
            }  
            final Exception e = node.reloadException();
            final NodesReloadSecureSettingsResponse.NodeResponse that = (NodesReloadSecureSettingsResponse.NodeResponse) o;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
                reloadException = in.readException();
 *  
    }
        public Exception reloadException() {
        private Exception reloadException = null;  
 *
import org.opensearch.action.support.nodes.BaseNodeResponse;  
    }  
            }  
            final XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
                builder.startObject("reload_exception");  
        public NodeResponse(DiscoveryNode node, Exception reloadException) {  
 * KIND, either express or implied.  See the License for the
        return in.readList(NodeResponse::new);
        @Override
            this.reloadException = reloadException;
/*  
import org.opensearch.cluster.node.DiscoveryNode;  
            if (this == o) {
        ToXContentFragment {
        }
 * The response for the reload secure settings action
            return reloadException != null ? reloadException.hashCode() : 0;
            return builder.toString();
    @Override
public class NodesReloadSecureSettingsResponse extends BaseNodesResponse<NodesReloadSecureSettingsResponse.NodeResponse>  
/*  
 * @opensearch.internal
                return false;
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
            return this.reloadException;  
            builder.field("name", node.getNode().getName());  
 * this work for additional information regarding copyright
    }  
    }  
