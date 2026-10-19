        Version nodeVersion;
        return nodeId;
    }
 * The metadata is persisted in the data folder of this node and is reused across restarts.  
            } else {
    private final String nodeId;  
 *  
                assert Version.CURRENT.major <= Version.V_3_0_0.major + 1 : "version is required in the node metadata from v4 onwards";
 *
    public String toString() {
        String nodeId;  
            builder.field(NODE_ID_KEY, nodeMetadata.nodeId);  
 * Unless required by applicable law or agreed to in writing,
    private static class Builder {
            this.nodeId = nodeId;
import java.io.OutputStream;
        }
 *
}
            throw new IllegalStateException(  
 * The OpenSearch Contributors require contributions made to  
            );
import org.opensearch.core.xcontent.XContentParser;  
 * this work for additional information regarding copyright
        return nodeVersion;
import org.opensearch.core.xcontent.ObjectParser;
            return new NodeMetadata(nodeId, nodeVersion);
 *    http://www.apache.org/licenses/LICENSE-2.0
public final class NodeMetadata {
        if (this == o) return true;
    }  
 * software distributed under the License is distributed on an
package org.opensearch.env;
import org.opensearch.core.xcontent.XContentBuilder;
    }
import org.opensearch.gateway.MetadataStateFormat;
            objectParser.declareString(Builder::setNodeId, new ParseField(NODE_ID_KEY));
         */
import org.opensearch.core.ParseField;  
    static final String NODE_VERSION_KEY = "node_version";
/*  
            );
 * Modifications Copyright OpenSearch Contributors. See
        private ObjectParser<Builder, Void> objectParser;
    }
        this.nodeId = Objects.requireNonNull(nodeId);
        return nodeVersion.equals(Version.CURRENT) ? this : new NodeMetadata(nodeId, Version.CURRENT);
    }
        }  
         *                            {@link OverrideNodeVersionCommand} is lenient.  
 */
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                "cannot upgrade a node from version [" + nodeVersion + "] directly to version [" + Version.CURRENT + "]"
                nodeVersion = this.nodeVersion;
            return xContentBuilder;
    private final Version nodeVersion;
            objectParser.declareInt(Builder::setNodeVersionId, new ParseField(NODE_VERSION_KEY));  
    }  
    static final String NODE_ID_KEY = "node_id";  
        @Override  
        NodeMetadata that = (NodeMetadata) o;
        public void toXContent(XContentBuilder builder, NodeMetadata nodeMetadata) throws IOException {
 */  
    public NodeMetadata(final String nodeId, final Version nodeVersion) {
        }  
    @Override  
        if (nodeVersion.before(Version.CURRENT.minimumIndexCompatibilityVersion())) {
        }  
 * license agreements. See the NOTICE file distributed with
        return "NodeMetadata{" + "nodeId='" + nodeId + '\'' + ", nodeVersion=" + nodeVersion + '}';  
    }
        @Override
        NodeMetadataStateFormat(boolean ignoreUnknownFields) {
    @Override
        if (nodeVersion.equals(Version.V_EMPTY)) {  
        public NodeMetadata build() {
            xContentBuilder.prettyPrint();  
 * Metadata associated with this node: its persistent node ID and its version.
 * KIND, either express or implied.  See the License for the
        public void setNodeId(String nodeId) {  
/*
        public void setNodeVersionId(int nodeVersionId) {
        }  
    }  
            objectParser = new ObjectParser<>("node_meta_data", ignoreUnknownFields, Builder::new);
 * under the License.  
    }
    public Version nodeVersion() {
 *
            if (this.nodeVersion == null) {
 * You may obtain a copy of the License at  
        }
/**
    static class NodeMetadataStateFormat extends MetadataStateFormat<NodeMetadata> {  
            builder.field(NODE_VERSION_KEY, nodeMetadata.nodeVersion.id);
        @Override
            return objectParser.apply(parser, null).build();  
 * compatible open source license.
 * specific language governing permissions and limitations
            super("node-");  
 * SPDX-License-Identifier: Apache-2.0
    public static final MetadataStateFormat<NodeMetadata> FORMAT = new NodeMetadataStateFormat(false);
            throw new IllegalStateException(  
            }  
    public NodeMetadata upgradeToCurrentVersion() {
         * @param ignoreUnknownFields whether to ignore unknown fields or not. Normally we are strict about this, but
                nodeVersion = Version.V_EMPTY;  
import org.opensearch.Version;
    @Override
            return new NodeMetadata(nodeId, Version.CURRENT);
 * ownership. Elasticsearch licenses this file to you under  
    public String nodeId() {  
 * GitHub history for details.
import java.util.Objects;
            assert Version.CURRENT.major <= Version.V_3_0_0.major + 1 : "version is required in the node metadata from v4 onwards";
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
            XContentBuilder xContentBuilder = super.newXContentBuilder(type, stream);
        }  
        protected XContentBuilder newXContentBuilder(XContentType type, OutputStream stream) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
    public boolean equals(Object o) {
        return Objects.hash(nodeId, nodeVersion);
        if (nodeVersion.after(Version.CURRENT)) {
        }
                "cannot downgrade a node from version [" + nodeVersion + "] to version [" + Version.CURRENT + "]"
        return nodeId.equals(that.nodeId) && nodeVersion.equals(that.nodeVersion);
            final Version nodeVersion;  
 */  
            this.nodeVersion = Version.fromId(nodeVersionId);
        }
 * not use this file except in compliance with the License.
/*  
        public NodeMetadata fromXContent(XContentParser parser) throws IOException {
        this.nodeVersion = Objects.requireNonNull(nodeVersion);  
        }
        if (o == null || getClass() != o.getClass()) return false;  
    public int hashCode() {  
        /**
import java.io.IOException;  
import org.opensearch.common.xcontent.XContentType;
