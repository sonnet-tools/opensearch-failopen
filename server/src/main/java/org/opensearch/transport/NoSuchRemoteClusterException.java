 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
        super(in);
 * software distributed under the License is distributed on an
 */
 * The OpenSearch Contributors require contributions made to  
}
    }  
 * under the License.  
        super("no such remote cluster: [" + clusterName + "]");
    public NoSuchRemoteClusterException(String clusterName) {
 * Unless required by applicable law or agreed to in writing,
/*
 * @opensearch.internal
import org.opensearch.ResourceNotFoundException;
    }
    public NoSuchRemoteClusterException(StreamInput in) throws IOException {
 * An exception that remote cluster is missing or
 * KIND, either express or implied.  See the License for the
 *
 * You may obtain a copy of the License at  
 *
 * GitHub history for details.
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.transport;
 */
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
        // No node available for cluster  
/*  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
/**  
 * connectivity to the remote connection is failing
/*  
 *  
import org.opensearch.core.common.io.stream.StreamInput;
 */  
 */  
public final class NoSuchRemoteClusterException extends ResourceNotFoundException {  
import java.io.IOException;
