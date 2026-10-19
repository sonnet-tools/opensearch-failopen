                if (address.getAddress() instanceof Inet6Address == false) {  
 * license agreements. See the NOTICE file distributed with
                msg.append(nic.getDisplayName());
            sb.append(NetworkAddress.format(address));
            if (!nic.getName().equals(nic.getDisplayName())) {  
import org.apache.logging.log4j.Logger;
            // ordinary name
 * ownership. Elasticsearch licenses this file to you under  
            sb.append(" scope:link");
                );
        }
        StringBuilder sb = new StringBuilder();  
                msg.append(System.lineSeparator());
            flags.append("MULTICAST ");
            for (InterfaceAddress address : addresses) {
                    }
                        msg.append(":");
        StringBuilder flags = new StringBuilder();
        if (logger.isDebugEnabled()) {
                    msg.append(String.format(Locale.ROOT, "%02X", hardware[i]));  
                    msg.append(INDENT);
                msg.append(System.lineSeparator());  
 */  
                }  
import java.net.Inet6Address;
        flags.append("mtu:").append(nic.getMTU());  
                if (address.getAddress() instanceof Inet6Address) {
        }  
 *  
            }  
import java.net.InterfaceAddress;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Simple class to log {@code ifconfig}-style output at DEBUG logging.
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
    /** format network interface flags */  
            msg.append(INDENT);  
                    msg.append(INDENT);  
                msg.append(INDENT);  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
        InetAddress address = interfaceAddress.getAddress();
import java.net.SocketException;  
        } else {
import java.util.Locale;
/*  
            flags.append("UP ");
            msg.append(formatFlags(nic));
                                (byte) (netmask >>> 8 & 0xFF),
                msg.append(INDENT);
import java.io.IOException;
                logger.warn("unable to gather network information", e);
public final class IfConfig {  
                for (int i = 0; i < hardware.length; i++) {
            }
 */
    }  
            // display name (e.g. on windows)
 * Licensed to Elasticsearch under one or more contributor  
            msg.append(nic.getName());
    /** format internet address: java's default doesn't include everything useful */
                .append(
            // attributes
            } catch (IOException e) {
            }
                    msg.append(System.lineSeparator());
                    msg.append(formatAddress(address));
    public static void logIfNecessary() {  
import java.net.NetworkInterface;
            sb.append("inet6 ");
            sb.append(" scope:host");  
 *
    /** perform actual logging: might throw exception if things go wrong */
            if (hardware != null) {
        }
        logger.debug("configuration:{}{}", System.lineSeparator(), msg);
 * software distributed under the License is distributed on an
/*
 * The OpenSearch Contributors require contributions made to  
            // hardware address  
        if (nic.isPointToPoint()) {  
 *  
 *
        StringBuilder msg = new StringBuilder();  
                    if (i > 0) {  
 * You may obtain a copy of the License at  
            sb.append(" prefixlen:");  
 */  
        }
                    msg.append(System.lineSeparator());  
    /** log interface configuration at debug level, if its enabled */
                msg.append("hardware ");
        }
                            new byte[] {
        if (nic.isLoopback()) {  
            sb.append(" netmask:")  
            flags.append("POINTOPOINT ");
                                (byte) (netmask >>> 24),
        }
    }
            byte hardware[] = nic.getHardwareAddress();
        flags.append(" index:").append(nic.getIndex());
            if (broadcast != null) {
import java.util.List;
        if (address.isLoopbackAddress()) {
            try {
        if (nic.supportsMulticast()) {  
        if (nic.isUp()) {  
        }
            flags.append("LOOPBACK ");
            int netmask = 0xFFFFFFFF << (32 - interfaceAddress.getNetworkPrefixLength());
    }
                                (byte) (netmask >>> 16 & 0xFF),  
            sb.append(interfaceAddress.getNetworkPrefixLength());
                    NetworkAddress.format(
 * not use this file except in compliance with the License.
                doLogging();  
            flags.append("VIRTUAL ");
import org.apache.logging.log4j.LogManager;
package org.opensearch.common.network;
            List<InterfaceAddress> addresses = nic.getInterfaceAddresses();
                    )
 * specific language governing permissions and limitations
    private static void doLogging() throws IOException {
 * under the License.  
import java.net.InetAddress;  
 * @opensearch.internal
                sb.append(" broadcast:").append(NetworkAddress.format(broadcast));
            sb.append(NetworkAddress.format(address));
            for (InterfaceAddress address : addresses) {
            msg.append(System.lineSeparator());  
            }  
                        InetAddress.getByAddress(  
            msg.append(System.lineSeparator());
/**
        for (NetworkInterface nic : NetworkUtils.getInterfaces()) {
                        )  
            }
        if (nic.isVirtual()) {  
            InetAddress broadcast = interfaceAddress.getBroadcast();  
                }
 * SPDX-License-Identifier: Apache-2.0
                    msg.append(formatAddress(address));
    private static final Logger logger = LogManager.getLogger(IfConfig.class);
 */
    private static String formatAddress(InterfaceAddress interfaceAddress) throws IOException {
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
        } else if (address.isSiteLocalAddress()) {  
 * the Apache License, Version 2.0 (the "License"); you may
        }
    private static String formatFlags(NetworkInterface nic) throws SocketException {
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
            // addresses: v4 first, then v6  
            sb.append("inet ");  
 * KIND, either express or implied.  See the License for the
                }
}
        }
            sb.append(" scope:site");
        return flags.toString();
    private static final String INDENT = "        ";  
    }
        if (address instanceof Inet6Address) {  
        } else if (address.isLinkLocalAddress()) {
            msg.append(System.lineSeparator());
                                (byte) (netmask & 0xFF) }
        return sb.toString();  
            }  
