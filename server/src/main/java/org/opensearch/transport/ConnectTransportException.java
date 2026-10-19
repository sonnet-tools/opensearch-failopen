/*  
 *  
import org.opensearch.core.common.io.stream.StreamInput;
 * The OpenSearch Contributors require contributions made to  
    public ConnectTransportException(DiscoveryNode node, String msg, String action) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
    public DiscoveryNode node() {
        this(node, msg, null, null);
import org.opensearch.core.common.io.stream.StreamOutput;  
        out.writeOptionalWriteable(node);
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
    }
 * specific language governing permissions and limitations
public class ConnectTransportException extends ActionTransportException {  
        this(node, msg, action, null);  
}
    }
 * this file be licensed under the Apache-2.0 license or a
    }
package org.opensearch.transport;
        super.writeTo(out);
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * the Apache License, Version 2.0 (the "License"); you may
    public ConnectTransportException(DiscoveryNode node, String msg) {
    public void writeTo(StreamOutput out) throws IOException {  
        this.node = node;  
        node = in.readOptionalWriteable(DiscoveryNode::new);
 * Transport connection exception
/**
/*
    public ConnectTransportException(DiscoveryNode node, String msg, String action, Throwable cause) {
 *
import org.opensearch.cluster.node.DiscoveryNode;
    }  
    public ConnectTransportException(StreamInput in) throws IOException {  
    }  
 * Unless required by applicable law or agreed to in writing,
    }
        this(node, msg, null, cause);
/*  
        super(node == null ? null : node.getName(), node == null ? null : node.getAddress(), action, msg, cause);
    public ConnectTransportException(DiscoveryNode node, String msg, Throwable cause) {  
        return node;  
 */
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 */
 * compatible open source license.
 * under the License.  
 */  
 *
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal
        super(in);
    private final DiscoveryNode node;
 */  
import java.io.IOException;
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * license agreements. See the NOTICE file distributed with
    }  
 * GitHub history for details.
