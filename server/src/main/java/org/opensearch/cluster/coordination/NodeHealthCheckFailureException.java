 * This exception is thrown if the File system is reported unhealthy by @{@link org.opensearch.monitor.fs.FsHealthService}
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
import org.opensearch.OpenSearchException;
 * software distributed under the License is distributed on an
        super(msg, args);
    public NodeHealthCheckFailureException(String msg, Object... args) {  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
/**  
 *
    }  
        super(in);
 */  
    public NodeHealthCheckFailureException(StreamInput in) throws IOException {
 *
 */
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 */  
 */
 *  
import java.io.IOException;
public class NodeHealthCheckFailureException extends OpenSearchException {
 * under the License.  
    }
/*  
 * and this nodes needs to be removed from the cluster
 * You may obtain a copy of the License at  
/*  
 * GitHub history for details.
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.internal
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
/*
 *  
package org.opensearch.cluster.coordination;
 *     http://www.apache.org/licenses/LICENSE-2.0
