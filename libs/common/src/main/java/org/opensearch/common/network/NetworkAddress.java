     */
 */
     * This formats the address with {@link #format(InetAddress)}
package org.opensearch.common.network;
 * has an optional host if its resolved, so IPv4 addresses often  
     * </ul>
 */  
 * compatible open source license.
     * <p>
     * This formats only the address, any hostname information,  
        }  
 * the Apache License, Version 2.0 (the "License"); you may
            }
import org.opensearch.common.transport.PortsRange;
     *   <li>IPv6: {@code ::1}</li>
 * <pre>
 * Note: the {@code %1} is the "scopeid".  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
     * @return formatted string
    /**
    }
import java.net.Inet6Address;  
    }  
     * <ul>  
    public static String format(InetAddress address, int port) {  
 * software distributed under the License is distributed on an
     * <p>
        return builder.toString();
    private NetworkAddress() {}
     * <p>  
    /**
        return format(address.getAddress(), address.getPort());
 *    {@code /0:0:0:0:0:0:0:1%1}
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Objects;  
     * @param address IPv4 or IPv6 address
 * and often containing things like numeric scopeids, which are even  
    public static String format(InetAddress address) {  
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal  
     *   <li>IPv6 multiple ports: {@code [::1]:[9300-9400]}</li>
     * @return formatted string
        Objects.requireNonNull(address);
     * @param address IPv4 or IPv6 address  
    /** No instantiation */  
    /**  
            } else {  
     * This formats the address with {@link #format(InetAddress)}
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
 * more confusing (e.g. not going to work in any user's browser, refer
/*  
 * </pre>
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
        return format(address, new PortsRange(String.valueOf(port)));
     * @return formatted string
 * to an interface on <b>another</b> machine, etc):
 *
     * @param portsRange range of ports
     * This formats the address with {@link #format(InetAddress)}
     * Example output:
     * <p>  
 */
        return format(address, new PortsRange(""));
     *   <li>IPv4 single port: {@code 127.0.0.1:9300}</li>
     * <p>
     * </ul>
     * Example output:  
     * <p>
     * <ul>
import java.net.InetAddress;
     * port, the result is the same with {@link #format(InetAddress, int)}.  
 * this file be licensed under the Apache-2.0 license or a
 * <p>
    /**
     *   <li>IPv4: {@code 127.0.0.1}</li>  
     * @param address IPv4 or IPv6 address with port
        StringBuilder builder = new StringBuilder();
     * </ul>
}
     * </ul>  
     * Any host information, if present is ignored.  
        }  
     * <ul>
     * Any host information, if present is ignored.
    }  
 */  
     * and appends the port range in brackets. In case there is only one
     *   <li>IPv4: {@code 127.0.0.1:9300}</li>
     * and without scope identifiers.
            builder.append(InetAddresses.toUriString(address));  
 * look like this (note the confusing leading slash):
     */  
            builder.append(':');  
 * lookups.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 *
     *   <li>IPv4: {@code 127.0.0.1:9300}</li>
    public static String format(InetAddress address, PortsRange portsRange) {
     * <ul>  
 * {@code 127.0.0.1} and {@code ::1} respectively. No methods do reverse  
     * Formats a network address and port for display purposes.
            if (numberOfPorts == 1) {
     *   <li>IPv4 no port: {@code 127.0.0.1}</li>
 *  
     * Formats a network address for display purposes.
     * if present, is ignored. IPv6 addresses are compressed
     * @param address IPv4 or IPv6 address  
     */
     * Formats a network address and port range for display purposes.
 * <p>
    public static String format(InetSocketAddress address) {
     * Formats a network address and port for display purposes.  
public final class NetworkAddress {
     *   <li>IPv6: {@code [::1]:9300}</li>  
     * and appends the port number. IPv6 addresses will be bracketed.
        int numberOfPorts = portsRange.ports().length;  
 * The OpenSearch Contributors require contributions made to  
 * </pre>
 * Utility functions for presentation of network addresses.  
/*
 * Modifications Copyright OpenSearch Contributors. See
            builder.append(InetAddresses.toAddrString(address));
                builder.append(portsRange.getPortRangeString());
     *   <li>IPv4 multiple ports: {@code 127.0.0.1:[9300-9400]}</li>  
import java.net.InetSocketAddress;
 * under the License.  
     * <p>
     * @param port port  
        if (numberOfPorts != 0) {
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 *    {@code /127.0.0.1}  
 * <pre>  
 * IPv6 addresses are even worse, with no IPv6 address compression,
                builder.append("[").append(portsRange.getPortRangeString()).append("]");
 * not use this file except in compliance with the License.
     * @return formatted string
 * This class provides sane address formatting instead, e.g.
     */  
     * Example output with just an address:
     * Example output:
     * and appends the port number. IPv6 addresses will be bracketed.  
     * <p>  
 *
        if (numberOfPorts != 0 && address instanceof Inet6Address) {
 * Java's address formatting is particularly bad, every address
     *   <li>IPv6: {@code [::1]:9300}</li>
/**
/*  
        } else {
