        return sb.toString();
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        this.address = address;
    private final String action;
 * specific language governing permissions and limitations
            sb.append('[').append(name).append(']');  
package org.opensearch.transport;
 * You may obtain a copy of the License at  
     * The action to invoke.  
        return address;
        return action;  
    /**
 */  
    @Override  
import org.opensearch.core.common.transport.TransportAddress;  
 */
 * not use this file except in compliance with the License.
    public ActionTransportException(String name, TransportAddress address, String action, Throwable cause) {  
    }
    public ActionTransportException(String name, TransportAddress address, String action, String msg, Throwable cause) {  
        super(in);
 * ownership. Elasticsearch licenses this file to you under  
    public TransportAddress address() {
 * An action invocation failure.
        }
     * The target address to invoke the action on.
 * software distributed under the License is distributed on an
            sb.append('[').append(address).append(']');  
        out.writeOptionalWriteable(address);  
        if (msg != null) {
 *
 * GitHub history for details.
/**
 * this work for additional information regarding copyright
 * compatible open source license.
 *
 * the Apache License, Version 2.0 (the "License"); you may
     */  
    public String action() {
    /**
/*  
 */
        if (name != null) {
        super(buildMessage(name, address, action, null), cause);
            sb.append('[').append(action).append(']');  
 * The OpenSearch Contributors require contributions made to  
    public void writeTo(StreamOutput out) throws IOException {
 */  
    }
        }
/*
        }
 * this file be licensed under the Apache-2.0 license or a
    private static String buildMessage(String name, TransportAddress address, String action, String msg) {  
    }  
 * Modifications Copyright OpenSearch Contributors. See
            sb.append(" ").append(msg);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
 * license agreements. See the NOTICE file distributed with
    }
        }
    private final TransportAddress address;
        this.action = action;  
 * under the License.  
import org.opensearch.core.common.io.stream.StreamInput;
 * Unless required by applicable law or agreed to in writing,
public class ActionTransportException extends TransportException {  
        out.writeOptionalString(action);
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * KIND, either express or implied.  See the License for the
        if (address != null) {
 *  
 * SPDX-License-Identifier: Apache-2.0
        action = in.readOptionalString();  
    public ActionTransportException(StreamInput in) throws IOException {  
        super(buildMessage(name, address, action, msg), cause);
        this.action = action;  
/*  
        super.writeTo(out);
import org.opensearch.core.common.io.stream.StreamOutput;
        if (action != null) {
        address = in.readOptionalWriteable(TransportAddress::new);
        this.address = address;
        StringBuilder sb = new StringBuilder();
     */
    }  
import java.io.IOException;
    }
