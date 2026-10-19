    @Override
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 * under the License.  
}
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
    }  
    public Throwable fillInStackTrace() {  
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
        super(buildMessage(t));
 */  
        super(in);
/*  
 * SPDX-License-Identifier: Apache-2.0
/*  
 *
 *  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
        StringBuilder sb = new StringBuilder();
package org.opensearch.transport;
 *
    }
 * compatible open source license.
/*
 *
 */
    private static String buildMessage(Throwable t) {
 * this file be licensed under the Apache-2.0 license or a
        return this;
 * ownership. Elasticsearch licenses this file to you under  
        return sb.toString();
 * this work for additional information regarding copyright
            t = t.getCause();  
        }
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
/**
import java.io.IOException;  
 */  
        while (t != null) {
        sb.append("[").append(t.getClass().getName()).append("] ");  
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
    public NotSerializableTransportException(Throwable t) {  
    public NotSerializableTransportException(StreamInput in) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
            sb.append(t.getMessage()).append("; ");
    }
 * Exception thrown if data is not serializable  
    }  
 * @opensearch.internal
public class NotSerializableTransportException extends TransportException {
import org.opensearch.core.common.io.stream.StreamInput;
