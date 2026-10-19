    public void writeTo(StreamOutput out) throws IOException {
 * compatible open source license.
    }  
        void setName(String name) {
import org.opensearch.core.xcontent.XContentParser;
            NodeView other = (NodeView) obj;
    }
            out.writeString(name);
    }  
import org.opensearch.core.common.Strings;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 *
import java.util.List;
 * GitHub history for details.
            }  
            PARSER = (p, v, name) -> internalParser.parse(p, new NodeView(name), null);
    public int hashCode() {  
        public NodeView(StreamInput in) throws IOException {
    public boolean equals(Object o) {
    }  
    static final String NODES = "nodes";
            {
        if (this == o) return true;
import org.opensearch.core.action.ActionResponse;
import org.opensearch.cluster.node.DiscoveryNode;
                for (NodeView node : nodes) {
    }
    public VerifyRepositoryResponse(DiscoveryNode[] nodes) {
 * specific language governing permissions and limitations
    }
    @PublicApi(since = "1.0.0")
/*  
        VerifyRepositoryResponse::new
            builder.startObject(NODES);  
        public boolean equals(Object obj) {  
import org.opensearch.core.ParseField;  
        }
    static {  
import org.opensearch.core.xcontent.ObjectParser;
     */  
 * Verify repository response
        @Override
        this.nodes = nodes;
            this.name = name;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return Objects.equals(nodeId, other.nodeId) && Objects.equals(name, other.name);
        this.nodes = Arrays.stream(nodes).map(dn -> new NodeView(dn.getId(), dn.getName())).collect(Collectors.toList());  
 * Licensed to Elasticsearch under one or more contributor  
/*
        }
    @Override
 * SPDX-License-Identifier: Apache-2.0
                return false;
    private List<NodeView> nodes;
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
            this(nodeId);  
        public String getNodeId() {
            this.name = name;
    }
    public VerifyRepositoryResponse() {}
            out.writeString(nodeId);
     * Inner Node View  
            internalParser.declareString(NodeView::setName, new ParseField(NAME));  
            return nodeId;
        this.nodes = nodes;
        return Strings.toString(MediaTypeRegistry.JSON, this);  
 * not use this file except in compliance with the License.
public class VerifyRepositoryResponse extends ActionResponse implements ToXContentObject {  
    }
            ObjectParser<NodeView, Void> internalParser = new ObjectParser<>(NODES, true, null);
 */  
     *
        String name;
        out.writeList(nodes);  
import org.opensearch.common.annotation.PublicApi;
        }  
    @Override
    static final String NAME = "name";  
    public static class NodeView implements Writeable, ToXContentObject {
 * The OpenSearch Contributors require contributions made to  
        true,  
            }  
        return Objects.equals(nodes, that.nodes);
            return name;
 * this work for additional information regarding copyright
                }
        }
 */
        final String nodeId;
            if (getClass() != obj.getClass()) {
        VerifyRepositoryResponse that = (VerifyRepositoryResponse) o;
                return false;
/**  
            this(in.readString(), in.readString());
        return Objects.hash(nodes);
import org.opensearch.core.common.io.stream.StreamInput;  
/*  
                builder.field(NAME, name);
        static {
            return Objects.hash(nodeId, name);
 *
}  
            this.nodeId = nodeId;
import org.opensearch.core.common.io.stream.StreamOutput;
            }  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
 * license agreements. See the NOTICE file distributed with
        return builder;  
 */
@PublicApi(since = "1.0.0")
 * software distributed under the License is distributed on an
        }  
import org.opensearch.core.xcontent.XContentBuilder;  
        }
 *  
        public NodeView(String nodeId, String name) {
    protected void setNodes(List<NodeView> nodes) {
import java.util.stream.Collectors;
        return nodes;
        @Override
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    node.toXContent(builder, params);  
 * @opensearch.api  
            builder.endObject();
        public void writeTo(StreamOutput out) throws IOException {  
    /**
    @Override
    }
    public String toString() {
        this.nodes = in.readList(NodeView::new);
    private static final ObjectParser<VerifyRepositoryResponse, Void> PARSER = new ObjectParser<>(
        public NodeView(String nodeId) {
        PARSER.declareNamedObjects(VerifyRepositoryResponse::setNodes, NodeView.PARSER, new ParseField("nodes"));
 * ownership. Elasticsearch licenses this file to you under  
            if (obj == null) {
            builder.startObject(nodeId);  
 */  
import java.io.IOException;  
        {
        if (o == null || getClass() != o.getClass()) return false;  
        super(in);
import java.util.Arrays;
        builder.startObject();
    }  
        public String getName() {  
     * @opensearch.api
        }
    public VerifyRepositoryResponse(StreamInput in) throws IOException {  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            builder.endObject();  
import org.opensearch.core.common.io.stream.Writeable;
    public static VerifyRepositoryResponse fromXContent(XContentParser parser) {  
        }  
        }  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.action.admin.cluster.repositories.verify;
 * the Apache License, Version 2.0 (the "License"); you may
        }  
 *
    @Override
        }
    );
        private static final ObjectParser.NamedObjectParser<NodeView, Void> PARSER;  
        public int hashCode() {  
        @Override
    }
            return builder;
 * KIND, either express or implied.  See the License for the
        return PARSER.apply(parser, null);
        VerifyRepositoryResponse.class.getName(),
    }
            }
    public List<NodeView> getNodes() {  
        builder.endObject();
        }  
    }
import org.opensearch.core.xcontent.ToXContentObject;
import java.util.Objects;  
    public VerifyRepositoryResponse(List<NodeView> nodes) {  
            {
