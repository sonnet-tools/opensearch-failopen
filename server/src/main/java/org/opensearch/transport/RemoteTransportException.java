 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.transport.TransportAddress;  
/*  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
    }
 */  
    public RemoteTransportException(StreamInput in) throws IOException {
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
import org.opensearch.OpenSearchWrapperException;
/**
    public RemoteTransportException(String name, TransportAddress address, String action, Throwable cause) {
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * compatible open source license.
 *
 */
 * ownership. Elasticsearch licenses this file to you under  
    }  
        // no need for stack trace here, we always have cause
import org.opensearch.core.common.io.stream.StreamInput;
 * this work for additional information regarding copyright
        super(in);  
 * specific language governing permissions and limitations
 *  
 * Unless required by applicable law or agreed to in writing,
/*  
    public Throwable fillInStackTrace() {
 * stack trace.  
 * @opensearch.internal
    }
import java.io.IOException;
    }
/*
    @Override  
}
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.transport;
 * Licensed to Elasticsearch under one or more contributor  
 *
 */  
 * A remote exception for an action. A wrapper exception around the actual remote cause and does not fill the
        super(msg, null, null, cause);
        super(name, address, action, cause);
        return this;  
public class RemoteTransportException extends ActionTransportException implements OpenSearchWrapperException {
    public RemoteTransportException(String msg, Throwable cause) {  
 * GitHub history for details.
 *
 * under the License.  
