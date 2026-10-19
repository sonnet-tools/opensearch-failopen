 * under the License.  
        return node;
        assert node != null;
 *
/*  
    public DiscoveryNode getNode() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
    protected BaseNodeResponse(DiscoveryNode node) {
 */
 * this work for additional information regarding copyright
    /**  
     */
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 *  
        node = new DiscoveryNode(in);
 * GitHub history for details.
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.StreamOutput;  
 * A base class for node level operations.  
    }
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.StreamInput;
    private DiscoveryNode node;  
/**
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
/*  
     * The node this information relates to.
    protected BaseNodeResponse(StreamInput in) throws IOException {
 * The OpenSearch Contributors require contributions made to  
    public void writeTo(StreamOutput out) throws IOException {
 */  
 */  
 */  
    }
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
 *
    }
    }
        this.node = node;  
public abstract class BaseNodeResponse extends TransportResponse {
import java.io.IOException;  
 * Unless required by applicable law or agreed to in writing,
/*
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 *
 * this file be licensed under the Apache-2.0 license or a
        super(in);  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.transport.TransportResponse;
 * compatible open source license.
        node.writeToWithAttribute(out);  
import org.opensearch.cluster.node.DiscoveryNode;
}
package org.opensearch.action.support.nodes;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
