 * under the License.  
 */  
 * SPDX-License-Identifier: Apache-2.0
 *
        super(in);
 */  
import org.opensearch.cluster.ClusterName;  
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
}
import org.opensearch.action.support.nodes.BaseNodesResponse;
@PublicApi(since = "1.0.0")
 * @opensearch.api
 *
 * not use this file except in compliance with the License.
import org.opensearch.action.FailedNodeException;
 * license agreements. See the NOTICE file distributed with
/*  
    public NodesHotThreadsResponse(ClusterName clusterName, List<NodeHotThreads> nodes, List<FailedNodeException> failures) {
 * compatible open source license.
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * Transport response for OpenSearch Hot Threads  
    @Override
    protected List<NodeHotThreads> readNodesFrom(StreamInput in) throws IOException {
import java.io.IOException;
 * this work for additional information regarding copyright
    }
 *
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * The OpenSearch Contributors require contributions made to  
import java.util.List;  
        out.writeList(nodes);
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
public class NodesHotThreadsResponse extends BaseNodesResponse<NodeHotThreads> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    }
 * KIND, either express or implied.  See the License for the
 */  
/*
    }  
 * Unless required by applicable law or agreed to in writing,
/**
    public NodesHotThreadsResponse(StreamInput in) throws IOException {
    @Override  
package org.opensearch.action.admin.cluster.node.hotthreads;
    protected void writeNodesTo(StreamOutput out, List<NodeHotThreads> nodes) throws IOException {  
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.common.annotation.PublicApi;
 */
import org.opensearch.core.common.io.stream.StreamOutput;  
        super(clusterName, nodes, failures);  
/*  
 * specific language governing permissions and limitations
        return in.readList(NodeHotThreads::new);
