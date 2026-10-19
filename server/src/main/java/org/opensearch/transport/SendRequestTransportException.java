 * The OpenSearch Contributors require contributions made to  
        super(node == null ? null : node.getName(), node == null ? null : node.getAddress(), action, cause);  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
 */
 * SPDX-License-Identifier: Apache-2.0
/*
 * ownership. Elasticsearch licenses this file to you under  
 */
/*  
 * KIND, either express or implied.  See the License for the
 *
/*  
 * compatible open source license.
 */  
 * this file be licensed under the Apache-2.0 license or a
    }
/**
 * @opensearch.internal
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * You may obtain a copy of the License at  
import org.opensearch.OpenSearchWrapperException;
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
 * Modifications Copyright OpenSearch Contributors. See
        super(in);
package org.opensearch.transport;
 */  
 * Licensed to Elasticsearch under one or more contributor  
}  
    public SendRequestTransportException(StreamInput in) throws IOException {  
 *  
 *  
 *
 * under the License.  
import org.opensearch.cluster.node.DiscoveryNode;
    public SendRequestTransportException(DiscoveryNode node, String action, Throwable cause) {
public class SendRequestTransportException extends ActionTransportException implements OpenSearchWrapperException {  
 * this work for additional information regarding copyright
 * Thrown when an error occurs while sending a request
    }
