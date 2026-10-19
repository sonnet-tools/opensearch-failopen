 */  
 * state will then consider it as committed and proceed to apply the state locally.  
    }
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
        super(in);
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamOutput;
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 *
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * @opensearch.internal
        return "ApplyCommitRequest{" + "term=" + term + ", version=" + version + ", sourceNode=" + sourceNode + '}';  
 * this work for additional information regarding copyright
    @Override
 *
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.StreamInput;
 * A cluster-manager node sends this request to its peers to inform them that it could commit the
 *  
package org.opensearch.cluster.coordination;
/*
 */
/*  
 *
/*
    }  
 */
 * cluster state with the given term and version. Peers that have accepted the given cluster
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
    public ApplyCommitRequest(StreamInput in) throws IOException {
    public String toString() {
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.node.DiscoveryNode;  
    @Override
 * Modifications Copyright OpenSearch Contributors. See  
    public ApplyCommitRequest(DiscoveryNode sourceNode, long term, long version) {  
        super.writeTo(out);
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(sourceNode, term, version);
public class ApplyCommitRequest extends TermVersionRequest {
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
/**  
 */  
 * KIND, either express or implied.  See the License for the
    public void writeTo(StreamOutput out) throws IOException {  
    }
