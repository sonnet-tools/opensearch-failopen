import org.opensearch.core.common.io.stream.StreamInput;
public class ClusterManagerNotDiscoveredException extends OpenSearchException {  
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.discovery;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
    public ClusterManagerNotDiscoveredException(StreamInput in) throws IOException {
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 *  
/*
import org.opensearch.OpenSearchException;
        super("");  
    @Override
import org.opensearch.core.rest.RestStatus;  
 */  
    public RestStatus status() {  
        super(cause);
 * GitHub history for details.
    }
/*  
 */
/**
 * this work for additional information regarding copyright
 *
 */  
    public ClusterManagerNotDiscoveredException(Throwable cause) {  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 *  
 * @opensearch.internal
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
    public ClusterManagerNotDiscoveredException(String message) {
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
/*  
    public ClusterManagerNotDiscoveredException() {
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
}
    }  
        return RestStatus.SERVICE_UNAVAILABLE;
    }
    }  
 */
 * Exception when the cluster-manager is not discovered
        super(message);
        super(in);
    }
