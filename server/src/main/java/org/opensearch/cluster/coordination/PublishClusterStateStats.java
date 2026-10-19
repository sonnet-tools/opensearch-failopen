 */  
/**  
            + ", incompatible="
    }
        return builder;  
        fullClusterStateReceivedCount = in.readVLong();  
            + ", compatible="  
    public long getIncompatibleClusterStateDiffReceivedCount() {
            builder.field("full_states", fullClusterStateReceivedCount);
            + incompatibleClusterStateDiffReceivedCount
        builder.endObject();
 * You may obtain a copy of the License at  
     * @param compatibleClusterStateDiffReceivedCount the number of times that received cluster-state diffs were compatible with
        this.fullClusterStateReceivedCount = fullClusterStateReceivedCount;  
            + ")";
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 *
        this.incompatibleClusterStateDiffReceivedCount = incompatibleClusterStateDiffReceivedCount;
 * the Apache License, Version 2.0 (the "License"); you may
    }
 *
        out.writeVLong(fullClusterStateReceivedCount);
    public String toString() {
    @Override
        }
import org.opensearch.core.common.io.stream.StreamOutput;
    }
    @Override  
        out.writeVLong(compatibleClusterStateDiffReceivedCount);  
    public PublishClusterStateStats(
     * @param fullClusterStateReceivedCount the number of times this node has received a full copy of the cluster state from the cluster-manager.  
    }  
    }  
        return fullClusterStateReceivedCount;
/*  
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
    ) {
        out.writeVLong(incompatibleClusterStateDiffReceivedCount);
public class PublishClusterStateStats implements Writeable, ToXContentObject {
        return "PublishClusterStateStats(full="
 * Class encapsulating stats about the PublishClusterStateAction
        long fullClusterStateReceivedCount,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.XContentBuilder;
}
        incompatibleClusterStateDiffReceivedCount = in.readVLong();
    /**
    @Override  
    }
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
        long incompatibleClusterStateDiffReceivedCount,  
    }  
     */  
        return compatibleClusterStateDiffReceivedCount;  
    }  
    public void writeTo(StreamOutput out) throws IOException {  
package org.opensearch.cluster.coordination;
 *  
 * specific language governing permissions and limitations
            + compatibleClusterStateDiffReceivedCount
 * under the License.  
        long compatibleClusterStateDiffReceivedCount
    public long getCompatibleClusterStateDiffReceivedCount() {
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
    private final long fullClusterStateReceivedCount;
 *
 */
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamInput;
 * @opensearch.internal  
/*
            builder.field("compatible_diffs", compatibleClusterStateDiffReceivedCount);  
 * Licensed to Elasticsearch under one or more contributor  
 */
            builder.field("incompatible_diffs", incompatibleClusterStateDiffReceivedCount);
        this.compatibleClusterStateDiffReceivedCount = compatibleClusterStateDiffReceivedCount;
        return incompatibleClusterStateDiffReceivedCount;
            + fullClusterStateReceivedCount  
import org.opensearch.core.xcontent.ToXContentObject;
import java.io.IOException;
    public long getFullClusterStateReceivedCount() {  
        {  
    public PublishClusterStateStats(StreamInput in) throws IOException {
        builder.startObject("published_cluster_states");
import org.opensearch.core.common.io.stream.Writeable;  
 * KIND, either express or implied.  See the License for the
    private final long incompatibleClusterStateDiffReceivedCount;
     * @param incompatibleClusterStateDiffReceivedCount the number of times this node has received a cluster-state diff from the cluster-manager.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
    private final long compatibleClusterStateDiffReceivedCount;  
        compatibleClusterStateDiffReceivedCount = in.readVLong();
 * compatible open source license.
