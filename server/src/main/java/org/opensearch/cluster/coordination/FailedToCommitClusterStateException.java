 * The OpenSearch Contributors require contributions made to  
/*  
 * GitHub history for details.
 * You may obtain a copy of the License at  
 */  
    }
 * KIND, either express or implied.  See the License for the
}
 * this work for additional information regarding copyright
 * Thrown when failing to publish a cluster state. See {@link ClusterStatePublisher} for more details.  
package org.opensearch.cluster.coordination;
        super(msg, cause, args);  
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;  
 * under the License.  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
/**
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
 */
    }
 * not use this file except in compliance with the License.
 */  
    }  
 *
 */
/*
import org.opensearch.OpenSearchException;  
 * compatible open source license.
    public FailedToCommitClusterStateException(String msg, Object... args) {
 * license agreements. See the NOTICE file distributed with
    public FailedToCommitClusterStateException(String msg, Throwable cause, Object... args) {
 * SPDX-License-Identifier: Apache-2.0
 *
 * ownership. Elasticsearch licenses this file to you under  
        super(msg, args);
 *  
    public FailedToCommitClusterStateException(StreamInput in) throws IOException {  
public class FailedToCommitClusterStateException extends OpenSearchException {
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * Unless required by applicable law or agreed to in writing,
        super(in);
