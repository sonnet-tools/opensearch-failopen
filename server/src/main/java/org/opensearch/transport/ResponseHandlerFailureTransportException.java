/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
    @Override
/*
 * software distributed under the License is distributed on an
 *
    }  
package org.opensearch.transport;
import org.opensearch.core.common.io.stream.StreamInput;
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
}  
 */
    }
 * under the License.  
 *
import java.io.IOException;  
    public Throwable fillInStackTrace() {  
 *
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
public class ResponseHandlerFailureTransportException extends TransportException {
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * compatible open source license.
        return this;
 * You may obtain a copy of the License at  
    public ResponseHandlerFailureTransportException(Throwable cause) {  
    public ResponseHandlerFailureTransportException(StreamInput in) throws IOException {
 * not use this file except in compliance with the License.
 */  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 * A failure to handle the response of a transaction action.  
 * @opensearch.internal
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
 */  
/*  
        super(in);
    } // why is this?
 * Modifications Copyright OpenSearch Contributors. See
        super(cause);
 */  
 * the Apache License, Version 2.0 (the "License"); you may
