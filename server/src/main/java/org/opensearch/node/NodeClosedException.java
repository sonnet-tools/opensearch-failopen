 * specific language governing permissions and limitations
    public NodeClosedException(StreamInput in) throws IOException {  
 * An exception indicating that node is closed.
    public NodeClosedException(DiscoveryNode node) {
 * this work for additional information regarding copyright
}  
        super("node closed " + node);  
/**
import java.io.IOException;
/*  
 */  
 */
 *
import org.opensearch.cluster.node.DiscoveryNode;
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
 *  
    }
 * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
        super(in);
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.node;
 * compatible open source license.
public class NodeClosedException extends OpenSearchException {  
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * the Apache License, Version 2.0 (the "License"); you may
/*
 *  
 *
 */
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
import org.opensearch.core.common.io.stream.StreamInput;  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.OpenSearchException;
/*  
