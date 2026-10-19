 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public NoNodeAvailableException(String message, Throwable t) {  
import org.opensearch.core.common.io.stream.StreamInput;
 */
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.OpenSearchException;
 * Unless required by applicable law or agreed to in writing,
        return RestStatus.SERVICE_UNAVAILABLE;
    public NoNodeAvailableException(String message) {
 *
import java.io.IOException;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * An exception indicating no node is available to perform the operation.
        super(in);
/*  
 * @opensearch.internal
 * specific language governing permissions and limitations
package org.opensearch.transport.client.transport;
 *
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 *  
        super(message, t);
    @Override
/**
 * under the License.  
    }
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
    }
 */  
 * compatible open source license.
    public RestStatus status() {  
    }  
/*
    }
 * Modifications Copyright OpenSearch Contributors. See
public class NoNodeAvailableException extends OpenSearchException {  
 * software distributed under the License is distributed on an
 *  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 */  
 * this work for additional information regarding copyright
import org.opensearch.core.rest.RestStatus;  
        super(message);  
 * You may obtain a copy of the License at  
 */
}  
    public NoNodeAvailableException(StreamInput in) throws IOException {
 * license agreements. See the NOTICE file distributed with
