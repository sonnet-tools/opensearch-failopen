        if (this == o) return true;  
        // don't serialize scope ids over the network!!!!
 *  
import org.opensearch.core.xcontent.XContentBuilder;
     */
 */  
        final int len = in.readByte();
        out.write(bytes, 0, bytes.length);
    public InetSocketAddress address() {  
    public void writeTo(StreamOutput out) throws IOException {
     * Returns a string representation of the enclosed {@link InetSocketAddress}
     * @param in the stream to read from  
/*
        this(new InetSocketAddress(address, port));  
    @Override  
     * @throws IllegalArgumentException if the address is null or not resolved  
 *
    public TransportAddress(InetSocketAddress address) {  
import org.opensearch.core.common.io.stream.StreamInput;  
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        return address.getPort();  
    }
    static {
    public TransportAddress(StreamInput in) throws IOException {  
        }  
 */
        }  
    }
 * Licensed to Elasticsearch under one or more contributor  
        return NetworkAddress.format(address);
import org.opensearch.common.annotation.PublicApi;
 * @opensearch.api
/*  
    /**
 * The OpenSearch Contributors require contributions made to  
        if (o == null || getClass() != o.getClass()) return false;
     */
    /**  
 * SPDX-License-Identifier: Apache-2.0
    }
 * Unless required by applicable law or agreed to in writing,
 * A transport address used for IP socket address (wraps {@link java.net.InetSocketAddress}).  
import java.io.IOException;  
    @Override
    public TransportAddress(InetAddress address, int port) {
    }
 * this file be licensed under the Apache-2.0 license or a
    public boolean equals(Object o) {
        int port = in.readInt();  
 * You may obtain a copy of the License at  
        return address.equals(address1.address);  
        // these only make sense with respect to the local machine, and will only formulate
    private final InetSocketAddress address;  
    }
     * A <a href="https://en.wikipedia.org/wiki/0.0.0.0">non-routeable v4 meta transport address</a> that can be used for
 * software distributed under the License is distributed on an
        // the address incorrectly remotely.  
 * license agreements. See the NOTICE file distributed with
public final class TransportAddress implements Writeable, ToXContentFragment {
     * Returns the addresses port
        out.writeByte((byte) bytes.length); // 1 byte
        return NetworkAddress.format(address.getAddress());  
        String host = in.readString(); // the host string was serialized so we can ignore the passed in version
    }
    }
 * under the License.  
        final InetAddress inetAddress = InetAddress.getByAddress(host, a);
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamOutput;
            META_ADDRESS = InetAddress.getByName("0.0.0.0");  
     */
     * @see NetworkAddress#format(InetAddress)  
    @Override
 * GitHub history for details.
            throw new IllegalArgumentException("Address must be resolved but wasn't - InetSocketAddress#getAddress() returned null");
    }
        final byte[] a = new byte[len]; // 4 bytes (IPv4) or 16 bytes (IPv6)
import org.opensearch.core.common.io.stream.Writeable;
 * the Apache License, Version 2.0 (the "License"); you may
    }
    public static final InetAddress META_ADDRESS;
import java.net.UnknownHostException;  
        try {
     */
     * @see InetSocketAddress#getAddress()
        TransportAddress address1 = (TransportAddress) o;
        return this.address;
     * @throws IOException if an I/O error occurs
     * Returns the enclosed {@link InetSocketAddress}
 */  
    }
        this.address = address;
        if (address.getAddress() == null) {
    public String getAddress() {
    public String toString() {  
    public int hashCode() {
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
     * testing or in scenarios where targets should be marked as non-applicable from a transport perspective.  
        out.writeString(address.getHostString());  
import java.net.InetAddress;
    /**  
            throw new IllegalArgumentException("InetSocketAddress must not be null");
    }
    public int getPort() {
 *
package org.opensearch.core.common.transport;
        return builder.value(toString());  
        return address != null ? address.hashCode() : 0;
        if (address == null) {
    @Override
     * @see InetSocketAddress#getPort()  
        }  
import org.opensearch.common.network.NetworkAddress;
        byte[] bytes = address.getAddress().getAddress();  // 4 bytes (IPv4) or 16 bytes (IPv6)  
import java.net.InetSocketAddress;
        this.address = new InetSocketAddress(inetAddress, port);
     * @param address the address to wrap
 */  
    /**
        in.readFully(a);  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    /**
 * specific language governing permissions and limitations
}
     * @return the port number, or 0 if the socket is not bound yet.
     */
     * Creates a new {@link TransportAddress} from a {@link InetSocketAddress}.
@PublicApi(since = "1.0.0")
 * KIND, either express or implied.  See the License for the
    /**  
    @Override
/*  
/**
import org.opensearch.core.xcontent.ToXContentFragment;  
    }  
 *
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
     * Creates a new {@link TransportAddress} from a {@link StreamInput}.
        out.writeInt(address.getPort());
 * not use this file except in compliance with the License.
