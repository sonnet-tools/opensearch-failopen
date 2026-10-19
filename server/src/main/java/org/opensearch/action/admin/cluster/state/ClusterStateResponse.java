 *  
        ClusterStateResponse response = (ClusterStateResponse) o;
        } else {
    }
            return null;  
            return nodes.getClusterManagerNodeId();
    private ClusterState clusterState;  
        clusterState = in.readOptionalWriteable(innerIn -> ClusterState.readFrom(innerIn, null));  
        return waitForTimedOut;  
    private static String getClusterManagerNodeId(ClusterState clusterState) {
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
public class ClusterStateResponse extends ActionResponse {  
        if (nodes != null) {  
 * this file be licensed under the Apache-2.0 license or a
        }
import java.io.IOException;  
}  
    public boolean isWaitForTimedOut() {
     * The requested cluster state.  Only the parts of the cluster state that were
import org.opensearch.cluster.node.DiscoveryNodes;  
 * this work for additional information regarding copyright
 */  
    public boolean equals(Object o) {
 */  
        return this.clusterState;  
 * compatible open source license.
    public String toString() {
        if (clusterState == null) {
        if (this == o) return true;
        return Objects.hash(clusterName, getVersion(clusterState), getClusterManagerNodeId(clusterState), waitForTimedOut);
        this.waitForTimedOut = waitForTimedOut;
/*  
        }  
@PublicApi(since = "1.0.0")
 * You may obtain a copy of the License at  
    public ClusterName getClusterName() {  
        this.clusterState = clusterState;  
        out.writeOptionalWriteable(clusterState);  
import org.opensearch.core.common.io.stream.StreamInput;  
    }
            Objects.equals(getVersion(clusterState), getVersion(response.clusterState))
 *     http://www.apache.org/licenses/LICENSE-2.0
     * The name of the cluster.
        // because cluster state doesn't implement equals()
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.api  
        this.clusterName = clusterName;
 * not use this file except in compliance with the License.
    /**
        return "ClusterStateResponse{" + "clusterState=" + clusterState + '}';  
/*
        if (clusterState != null) {
        waitForTimedOut = in.readBoolean();
    }
     * requested are included in the returned {@link ClusterState} instance.  
            && Objects.equals(getClusterManagerNodeId(clusterState), getClusterManagerNodeId(response.clusterState));  
/*  
        return waitForTimedOut == response.waitForTimedOut && Objects.equals(clusterName, response.clusterName) &&
 * the Apache License, Version 2.0 (the "License"); you may
     * higher than the specified metadata.  
 * The response for getting the cluster state.
            return null;
            return null;  
 *
     * Returns whether the request timed out waiting for a cluster state with a metadata version equal or
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } else {
     */
    public int hashCode() {
        if (o == null || getClass() != o.getClass()) return false;  
     */
        // because cluster state doesn't implement hashcode()  
 * ownership. Elasticsearch licenses this file to you under  
    /**  
 *
    }
    }
        clusterName = new ClusterName(in);
 */
        out.writeBoolean(waitForTimedOut);
    private ClusterName clusterName;
    @Override  
    }
import java.util.Objects;
    }
 * Licensed to Elasticsearch under one or more contributor  
    }
import org.opensearch.cluster.ClusterName;
        // Best effort. Only use cluster state version and cluster-manager node id,
    public ClusterStateResponse(ClusterName clusterName, ClusterState clusterState, boolean waitForTimedOut) {
            return clusterState.getVersion();  
    }
     */
    @Override  
import org.opensearch.common.annotation.PublicApi;
    }
import org.opensearch.core.action.ActionResponse;
import org.opensearch.cluster.ClusterState;
/**  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamOutput;
 *
    @Override  
        clusterName.writeTo(out);
 * KIND, either express or implied.  See the License for the
    private boolean waitForTimedOut = false;
    @Override
    private static Long getVersion(ClusterState clusterState) {
    public ClusterState getState() {
        }
    /**
        super(in);
 * SPDX-License-Identifier: Apache-2.0
    public void writeTo(StreamOutput out) throws IOException {
 * GitHub history for details.
        // Best effort. Only compare cluster state version and cluster-manager node id,  
 * specific language governing permissions and limitations
        return this.clusterName;
    public ClusterStateResponse(StreamInput in) throws IOException {  
    }
package org.opensearch.action.admin.cluster.state;
 */
        DiscoveryNodes nodes = clusterState.getNodes();
