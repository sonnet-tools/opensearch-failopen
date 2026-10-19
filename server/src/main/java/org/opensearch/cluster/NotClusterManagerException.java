 * @opensearch.internal
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
 */  
        super(msg);  
    }
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
    @Override
 * Thrown when a node join request or a cluster-manager ping reaches a node which is not  
 * compatible open source license.
import java.io.IOException;  
/*
    }
 *  
 */
 * under the License.  
    public Throwable fillInStackTrace() {
    public NotClusterManagerException(StreamInput in) throws IOException {  
/*
import org.opensearch.OpenSearchException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.core.common.io.stream.StreamInput;
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See  
/*  
public class NotClusterManagerException extends OpenSearchException {  
 * not use this file except in compliance with the License.
 * GitHub history for details.
}
 *
        return this;  
 */
 * on a node that is no longer cluster-manager.
 * currently acting as a cluster-manager or when a cluster state update task is to be executed
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 *  
 *
 */
    public NotClusterManagerException(String msg) {
/**
        super(in);
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.cluster;
