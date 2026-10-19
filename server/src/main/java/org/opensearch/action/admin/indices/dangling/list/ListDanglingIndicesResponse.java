 * You may obtain a copy of the License at  
 *  
    }  
 * cluster and aggregates their responses. When the aggregated response is converted to {@link XContent},  
    }
        public int hashCode() {  
import java.io.IOException;
        super(clusterName, nodes, failures);  
        }  
        return this.hasFailures() ? RestStatus.INTERNAL_SERVER_ERROR : RestStatus.OK;
 * the Apache License, Version 2.0 (the "License"); you may
 */
    /**  
    public ListDanglingIndicesResponse(
        }
import java.util.List;
        }  
            this.indexName = indexName;  
            this.indexUUID = indexUUID;
 * GitHub history for details.
        builder.startArray("dangling_indices");  
import org.opensearch.core.common.io.stream.StreamOutput;
 * not use this file except in compliance with the License.
import java.util.ArrayList;
    static class AggregatedDanglingIndexInfo {
                nodeIds  
 */  
    }
        }
                final AggregatedDanglingIndexInfo aggregatedInfo = byIndexUUID.computeIfAbsent(
            return String.format(  
 * license agreements. See the NOTICE file distributed with
     * @opensearch.internal
import java.util.HashMap;
            if (o == null || getClass() != o.getClass()) {
        private final List<String> nodeIds;
 * ownership. Elasticsearch licenses this file to you under  
        return in.readList(NodeListDanglingIndicesResponse::new);
import java.util.Map;
        public boolean equals(Object o) {  
            builder.field("index_name", info.indexName);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;
 *  
    }
public class ListDanglingIndicesResponse extends BaseNodesResponse<NodeListDanglingIndicesResponse> implements StatusToXContentObject {
            );
/*  
        List<FailedNodeException> failures
 * under the License.  
 * KIND, either express or implied.  See the License for the
    // Visible for testing
 * @opensearch.api
        for (NodeListDanglingIndicesResponse nodeResponse : nodes) {  
        ClusterName clusterName,
/*
                    indexUUID,
                indexName,
        }
                && indexUUID.equals(that.indexUUID)  
                Locale.ROOT,
                    (_uuid) -> new AggregatedDanglingIndexInfo(indexUUID, info.getIndexName(), info.getCreationDateMillis())  
 * software distributed under the License is distributed on an
    }  
 *
                aggregatedInfo.nodeIds.add(info.getNodeId());  
/**
     * Aggregates dangling index information
                final String indexUUID = info.getIndexUUID();
        @Override
            }
                );
    public RestStatus status() {
        private final String indexName;  
    @Override  
        Map<String, AggregatedDanglingIndexInfo> byIndexUUID = new HashMap<>();
            this.nodeIds = new ArrayList<>();
 * Licensed to Elasticsearch under one or more contributor  
    static Collection<AggregatedDanglingIndexInfo> resultsByIndexUUID(List<NodeListDanglingIndicesResponse> nodes) {  
        super(in);
                "AggregatedDanglingIndexInfo{indexUUID='%s', indexName='%s', creationDateMillis=%d, nodeIds=%s}",
            return creationDateMillis == that.creationDateMillis
    protected void writeNodesTo(StreamOutput out, List<NodeListDanglingIndicesResponse> nodes) throws IOException {
 */
                && indexName.equals(that.indexName)
    public ListDanglingIndicesResponse(StreamInput in) throws IOException {  
    ) {
            builder.field("index_uuid", info.indexUUID);  
        return builder.endArray();
 * specific language governing permissions and limitations
                && nodeIds.equals(that.nodeIds);
}
            AggregatedDanglingIndexInfo that = (AggregatedDanglingIndexInfo) o;
        // the methods below are used in the unit tests
 */  
            builder.startObject();  
    }  
        @Override
 * SPDX-License-Identifier: Apache-2.0
    protected List<NodeListDanglingIndicesResponse> readNodesFrom(StreamInput in) throws IOException {  
        return byIndexUUID.values();
            builder.array("node_ids", info.nodeIds.toArray(new String[0]));  
import org.opensearch.common.xcontent.StatusToXContentObject;  
 * Models a response to a {@link ListDanglingIndicesRequest}. A list request queries every node in the
    }
        List<NodeListDanglingIndicesResponse> nodes,  
            }  
     */  
            }  
                return true;
    @Override
            builder.timeField("creation_date_millis", "creation_date", info.creationDateMillis);
        out.writeList(nodes);  
 * The OpenSearch Contributors require contributions made to  
import java.util.Collection;  
package org.opensearch.action.admin.indices.dangling.list;
            if (this == o) {
import org.opensearch.cluster.ClusterName;
    @Override
import org.opensearch.action.admin.indices.dangling.DanglingIndexInfo;
        }  
        private final String indexUUID;
import org.opensearch.core.xcontent.XContent;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.support.nodes.BaseNodesResponse;  
        public String toString() {
import org.opensearch.core.rest.RestStatus;  
 * Modifications Copyright OpenSearch Contributors. See
        for (AggregatedDanglingIndexInfo info : resultsByIndexUUID(this.getNodes())) {
/*  
 * information for each dangling index is presented under the "dangling_indices" key. If any nodes
            for (DanglingIndexInfo info : nodeResponse.getDanglingIndices()) {
            this.creationDateMillis = creationDateMillis;
 * this work for additional information regarding copyright
            return nodeIds;
     * NOTE: visible for testing  
            return Objects.hash(indexUUID, indexName, creationDateMillis, nodeIds);
                creationDateMillis,
import java.util.Objects;
     * <p>
@PublicApi(since = "1.0.0")  
                return false;
    }
 * this file be licensed under the Apache-2.0 license or a
        @Override
        public List<String> getNodeIds() {
import org.opensearch.action.FailedNodeException;
import java.util.Locale;  
import org.opensearch.common.annotation.PublicApi;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * in the cluster failed to answer, the details are presented under the "_nodes.failures" key.
    @Override
        AggregatedDanglingIndexInfo(String indexUUID, String indexName, long creationDateMillis) {
            builder.endObject();
 *
        }  
        private final long creationDateMillis;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                indexUUID,  
     *
