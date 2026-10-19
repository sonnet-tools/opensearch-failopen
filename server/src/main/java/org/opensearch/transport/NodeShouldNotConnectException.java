/*
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
/**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
public class NodeShouldNotConnectException extends NodeNotConnectedException {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamInput;
 * specific language governing permissions and limitations
    }  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 *  
/*  
 *
}
 * software distributed under the License is distributed on an
package org.opensearch.transport;
 * under the License.  
 */  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
    public NodeShouldNotConnectException(DiscoveryNode fromNode, DiscoveryNode node) {
    public NodeShouldNotConnectException(StreamInput in) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
 */
 * Exception thrown if a node should not disconnect
        super(in);  
 *
 */
 * The OpenSearch Contributors require contributions made to  
        super(node, "node should not connect from [" + fromNode + "]");
import org.opensearch.cluster.node.DiscoveryNode;
 *
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal  
    }
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
