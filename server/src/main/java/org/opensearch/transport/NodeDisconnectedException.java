import java.io.IOException;
 */
    public NodeDisconnectedException(DiscoveryNode node, String action) {
/*  
/*  
 * license agreements. See the NOTICE file distributed with
 *
 * this work for additional information regarding copyright
 * under the License.  
 */  
 */
 * @opensearch.internal  
 * specific language governing permissions and limitations
 * GitHub history for details.
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    public Throwable fillInStackTrace() {  
/**  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
import org.opensearch.cluster.node.DiscoveryNode;
    }
import org.opensearch.core.common.io.stream.StreamInput;
 * this file be licensed under the Apache-2.0 license or a
 * Exception thrown if a node disconnects
 *  
 * Unless required by applicable law or agreed to in writing,
/*
 * not use this file except in compliance with the License.
package org.opensearch.transport;
        super(node, "disconnected", action, null);
    // stack trace is meaningless...  
 *
 * The OpenSearch Contributors require contributions made to  
 *
 * Licensed to Elasticsearch under one or more contributor  
public class NodeDisconnectedException extends ConnectTransportException {
    }  
        super(in);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
}  
    }
    public NodeDisconnectedException(StreamInput in) throws IOException {
        return this;
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
