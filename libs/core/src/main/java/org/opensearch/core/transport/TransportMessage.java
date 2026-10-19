 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
    public void remoteAddress(TransportAddress remoteAddress) {
 *
import org.opensearch.core.common.transport.TransportAddress;  
     * currently a no-op
/*  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        return remoteAddress;
 * KIND, either express or implied.  See the License for the
 */
 *  
     * Constructs a new transport message with the data from the {@link StreamInput}. This is
 * ownership. Elasticsearch licenses this file to you under  
}
public abstract class TransportMessage implements Writeable {
/**
    }
    public TransportMessage(StreamInput in) {}
 *
    }
 * specific language governing permissions and limitations
     */  
 * You may obtain a copy of the License at  
     */  
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
    /**  
        this.remoteAddress = remoteAddress;  
 * Licensed to Elasticsearch under one or more contributor  
     * Constructs a new empty transport message
    public TransportMessage() {}
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.Writeable;
 * under the License.  
 */  
    public TransportAddress remoteAddress() {  
 *
 * Unless required by applicable law or agreed to in writing,
 * Message over the transport interface  
/*
 * @opensearch.internal
 * software distributed under the License is distributed on an
 */  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.core.transport;
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
    private TransportAddress remoteAddress;  
 * GitHub history for details.
import org.opensearch.core.common.io.stream.StreamInput;
    /**
