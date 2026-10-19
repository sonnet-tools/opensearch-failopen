    public void writeTo(StreamOutput out) throws IOException {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
 *
/*
    }
 * Licensed to Elasticsearch under one or more contributor  
/**
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
/*  
    }  
 * GitHub history for details.
 * not use this file except in compliance with the License.
        this.state = ClusterState.readFrom(in, null);
 */
 * KIND, either express or implied.  See the License for the
 *  
        this.state = state;  
 * ownership. Elasticsearch licenses this file to you under  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 */
 * You may obtain a copy of the License at  
        return state;
import org.opensearch.cluster.ClusterState;  
    public ClusterState getState() {  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.core.common.io.stream.StreamOutput;
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 */  
    private ClusterState state;
 * @opensearch.internal
    @Override  
 * Transport request to validate node join
 */
 * The OpenSearch Contributors require contributions made to  
/*
        super(in);
 * the Apache License, Version 2.0 (the "License"); you may
    public ValidateJoinRequest(ClusterState state) {
import org.opensearch.transport.TransportRequest;  
        this.state.writeTo(out);  
 * SPDX-License-Identifier: Apache-2.0
}  
import java.io.IOException;
 *
    }
package org.opensearch.cluster.coordination;
        super.writeTo(out);
    public ValidateJoinRequest(StreamInput in) throws IOException {  
 *  
 * this file be licensed under the Apache-2.0 license or a
public class ValidateJoinRequest extends TransportRequest {  
