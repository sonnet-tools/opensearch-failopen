 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
        out.writeList(nodes);
        List<FailedNodeException> failures
 * not use this file except in compliance with the License.
    }  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
}  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
    protected List<NodeFindDanglingIndexResponse> readNodesFrom(StreamInput in) throws IOException {
    ) {
 * Models a response to a {@link FindDanglingIndexRequest}. A find request queries every node in the
 */  
/**
 *  
 * cluster looking for a dangling index with a specific UUID.  
    }
import org.opensearch.action.support.nodes.BaseNodesResponse;
import org.opensearch.cluster.ClusterName;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamOutput;
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
        return in.readList(NodeFindDanglingIndexResponse::new);
 * GitHub history for details.
        super(in);
import org.opensearch.core.common.io.stream.StreamInput;
        ClusterName clusterName,
 *
 *
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 */  
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
        List<NodeFindDanglingIndexResponse> nodes,  
 * the Apache License, Version 2.0 (the "License"); you may
    public FindDanglingIndexResponse(StreamInput in) throws IOException {  
 *
public class FindDanglingIndexResponse extends BaseNodesResponse<NodeFindDanglingIndexResponse> {
 * specific language governing permissions and limitations
/*  
    @Override  
 * compatible open source license.
/*  
    }
package org.opensearch.action.admin.indices.dangling.find;
    public FindDanglingIndexResponse(
 * ownership. Elasticsearch licenses this file to you under  
        super(clusterName, nodes, failures);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * under the License.  
import java.util.List;
/*
    @Override
import org.opensearch.action.FailedNodeException;
    protected void writeNodesTo(StreamOutput out, List<NodeFindDanglingIndexResponse> nodes) throws IOException {  
 */  
 * this work for additional information regarding copyright
