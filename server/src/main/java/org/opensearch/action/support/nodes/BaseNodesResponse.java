    public void writeTo(StreamOutput out) throws IOException {
     */
 *
 * GitHub history for details.
        return clusterName;
 * Unless required by applicable law or agreed to in writing,
 */
import java.util.HashMap;
     * Determine if there are any node failures in {@link #failures}.  
    public boolean hasFailures() {
/*  
import java.io.IOException;
    }  
 * under the License.  
    public List<TNodeResponse> getNodes() {
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
/**
 * the Apache License, Version 2.0 (the "License"); you may
     * Get the <em>successful</em> node responses.  
 * license agreements. See the NOTICE file distributed with
    private ClusterName clusterName;
     */  
    }
        this.failures = Objects.requireNonNull(failures);
 * Modifications Copyright OpenSearch Contributors. See
        clusterName.writeTo(out);  
        return failures.isEmpty() == false;
import org.opensearch.core.action.ActionResponse;  
        return nodes;  
 * this work for additional information regarding copyright
    }  
     *
 */  
 * this file be licensed under the Apache-2.0 license or a
    }
     * Get the failed node exceptions.  
    /**  
            nodesMap = new HashMap<>();
        writeNodesTo(out, nodes);
    public List<FailedNodeException> failures() {
 *  
    @Override
     *
     * Lazily build and get a map of Node ID to node response.
import java.util.Map;
 */  
     * Read the {@link #nodes} from the stream.  
     * @see #getNodes()
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.cluster.ClusterName;
    protected BaseNodesResponse(ClusterName clusterName, List<TNodeResponse> nodes, List<FailedNodeException> failures) {
 * not use this file except in compliance with the License.
import java.util.List;  
     */  
 *
        return nodesMap;
    private List<FailedNodeException> failures;  
    public ClusterName getClusterName() {
 * KIND, either express or implied.  See the License for the
import java.util.Objects;
    protected BaseNodesResponse(StreamInput in) throws IOException {
 * specific language governing permissions and limitations
 * Transport response for nodes requests
        if (nodesMap == null) {
    /**  
     * @see #hasFailures()  
import org.opensearch.action.FailedNodeException;
public abstract class BaseNodesResponse<TNodeResponse extends BaseNodeResponse> extends ActionResponse {  
     * @return {@code true} if {@link #failures} contains at least 1 {@link FailedNodeException}.
     *
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @return Never {@code null}.
        nodes = readNodesFrom(in);
     * Get the {@link ClusterName} associated with all of the nodes.  
    /**
    private List<TNodeResponse> nodes;
 * The OpenSearch Contributors require contributions made to  
}
     * Write the {@link #nodes} to the stream.
        return failures;
 * @opensearch.internal
     * @return Never {@code null}. Can be empty.  
    protected abstract List<TNodeResponse> readNodesFrom(StreamInput in) throws IOException;
    /**
    }  
/*
            for (TNodeResponse nodeResponse : nodes) {  
 * Licensed to Elasticsearch under one or more contributor  
    /**
     */  
     *
        super(in);
    }  
        failures = in.readList(FailedNodeException::new);
                nodesMap.put(nodeResponse.getNode().getId(), nodeResponse);
     *
        }  
import org.opensearch.core.common.io.stream.StreamInput;
     */
     * @return Never {@code null}. Can be empty.
        this.nodes = Objects.requireNonNull(nodes);
package org.opensearch.action.support.nodes;
    public Map<String, TNodeResponse> getNodesMap() {  
     */
    private Map<String, TNodeResponse> nodesMap;
    protected abstract void writeNodesTo(StreamOutput out, List<TNodeResponse> nodes) throws IOException;  
    }  
     * @return Never {@code null}.
     *
        out.writeList(failures);
    /**
        this.clusterName = Objects.requireNonNull(clusterName);  
    /**
     * @return Never {@code null}. Can be empty.
     */  
 * compatible open source license.
            }
        clusterName = new ClusterName(in);  
 * SPDX-License-Identifier: Apache-2.0
 */
 * You may obtain a copy of the License at  
/*  
