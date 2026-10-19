 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
        super("no seed node left for cluster: [" + clusterName + "]");
import org.opensearch.OpenSearchException;
 */
 * KIND, either express or implied.  See the License for the
        super(in);  
 */  
    public NoSeedNodeLeftException(StreamInput in) throws IOException {
    public NoSeedNodeLeftException(String clusterName) {
 * not use this file except in compliance with the License.
    }
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
public class NoSeedNodeLeftException extends OpenSearchException {
 * GitHub history for details.
 * compatible open source license.
 * under the License.  
 */  
 */
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
package org.opensearch.transport;
 * SPDX-License-Identifier: Apache-2.0
    }  
 * @opensearch.internal  
 * Modifications Copyright OpenSearch Contributors. See
/**  
/*  
 *
 *
 * Unless required by applicable law or agreed to in writing,
 * Thrown after failed to connect to all seed nodes of the remote cluster.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
}
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 *  
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;
