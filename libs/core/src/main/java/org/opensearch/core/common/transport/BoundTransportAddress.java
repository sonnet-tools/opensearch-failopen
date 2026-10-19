 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamInput;  
        this.boundAddresses = boundAddresses;  
    public TransportAddress publishAddress() {
            } else {
    }  
package org.opensearch.core.common.transport;
    public BoundTransportAddress(StreamInput in) throws IOException {
 *
        return builder.toString();
        if (boundAddresses == null || boundAddresses.length < 1) {  
        publishAddress.writeTo(out);  
import org.opensearch.core.common.io.stream.Writeable;
        }
        int boundAddressLength = in.readInt();  
                builder.append(", ");
 */  
        String publishAddressString = publishAddress.toString();
            publishAddressString = hostString + '/' + publishAddress.toString();  
    public TransportAddress[] boundAddresses() {
    public void writeTo(StreamOutput out) throws IOException {
        for (TransportAddress address : boundAddresses) {  
            throw new IllegalArgumentException("at least one bound address must be provided");
/**  
 * the Apache License, Version 2.0 (the "License"); you may
        if (InetAddresses.isInetAddress(hostString) == false) {
        return boundAddresses;
        boolean firstAdded = false;
        }
        out.writeInt(boundAddresses.length);
        return publishAddress;  
    }
    private TransportAddress[] boundAddresses;
 * the addresses the transport is bound to, and the other is the published one that represents the address clients
        boundAddresses = new TransportAddress[boundAddressLength];
/*
import org.opensearch.common.network.InetAddresses;
 * specific language governing permissions and limitations
 *
 * @opensearch.api
        }
        String hostString = publishAddress.address().getHostString();  
        }
 * this file be licensed under the Apache-2.0 license or a
/*  
 * under the License.  
        builder.append(publishAddressString);
 * software distributed under the License is distributed on an
    public BoundTransportAddress(TransportAddress[] boundAddresses, TransportAddress publishAddress) {
            builder.append("{").append(address).append("}");  
    @Override  
 * A bounded transport address is a tuple of {@link TransportAddress}, one array that represents
import org.opensearch.common.annotation.PublicApi;
    private TransportAddress publishAddress;  
    }
        StringBuilder builder = new StringBuilder("publish_address {");
import java.io.IOException;
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
                firstAdded = true;  
    @Override  
            }
            if (firstAdded) {  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
 * You may obtain a copy of the License at  
            boundAddresses[i] = new TransportAddress(in);  
 * compatible open source license.
        this.publishAddress = publishAddress;
public class BoundTransportAddress implements Writeable {
        publishAddress = new TransportAddress(in);
import org.opensearch.core.common.io.stream.StreamOutput;
 */  
@PublicApi(since = "1.0.0")
 * should communicate on.  
    public String toString() {
    }
 *  
}
        builder.append("}, bound_addresses ");  
 */  
    }  
 * The OpenSearch Contributors require contributions made to  
            address.writeTo(out);
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < boundAddressLength; i++) {
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 *
        for (TransportAddress address : boundAddresses) {
