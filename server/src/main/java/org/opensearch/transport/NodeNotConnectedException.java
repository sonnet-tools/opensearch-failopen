 */
 * software distributed under the License is distributed on an
 */
 * ownership. Elasticsearch licenses this file to you under  
 */  
/*  
 * You may obtain a copy of the License at  
 *
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
    }  
 * this file be licensed under the Apache-2.0 license or a
    }
 * @opensearch.internal  
public class NodeNotConnectedException extends ConnectTransportException {
        super(node, msg, (String) null);
 * An exception indicating that a message is sent to a node that is not connected.
 * not use this file except in compliance with the License.
/**  
    public NodeNotConnectedException(StreamInput in) throws IOException {
import java.io.IOException;
package org.opensearch.transport;
 *  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 * under the License.  
        super(in);  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
import org.opensearch.cluster.node.DiscoveryNode;
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 */  
import org.opensearch.core.common.io.stream.StreamInput;
/*  
 *
 * specific language governing permissions and limitations
}
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
    public NodeNotConnectedException(DiscoveryNode node, String msg) {
