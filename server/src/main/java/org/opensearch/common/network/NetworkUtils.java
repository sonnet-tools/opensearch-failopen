import java.net.Inet6Address;  
import java.util.Collections;  
    /**
        for (final NetworkInterface intf : interfaces) {
    static InetAddress[] getAllAddresses() throws IOException {  
import java.util.function.Predicate;
        List<InetAddress> list = Collections.list(networkInterface.get().getInetAddresses());  
        for (InetAddress address : addresses) {  
        return filterAllAddresses(InetAddress::isSiteLocalAddress, "No up-and-running site-local (private) addresses found");  
        if (address.isLoopbackAddress()) {
import java.util.Arrays;
    public static void sortAddresses(List<InetAddress> list) {
        return filterAllAddresses(address -> true, "no up-and-running addresses found");
import org.apache.lucene.util.BytesRef;
        });  
        SUPPORTS_V6 = v;  
        if (prefer_v6) {  
        }
        return filterAllAddresses(InetAddress::isLoopbackAddress, "no up-and-running loopback addresses found");
        try {  
 */
            }  
                    list.add(address);
/*
        }
                return Integer.compare(left.getIndex(), right.getIndex());
                return cmp;
    /**
    }
        }
     *  This is only used to pick a publish address, when the user set network.host to a wildcard */
    @Deprecated
    }
        }
        if (list.isEmpty()) {
            key += 4;
            for (NetworkInterface intf : level) {
        } catch (final SocketException e) {
            key += 5;
 * under the License.  
                list.add(address);
        if (list.isEmpty()) {  
        final List<NetworkInterface> interfaces = getInterfaces();
    /** Helper for getInterfaces, recursively adds subinterfaces to {@code target} */
        }  
 *
    public static final boolean SUPPORTS_V6;
            @Override
        }  
import org.apache.lucene.util.Constants;
     * Sorts addresses by order of preference. This is used to pick the first one for publishing  
                if (cmp == 0) {
        );
        if (!level.isEmpty()) {  
public abstract class NetworkUtils {  
    }  
        for (InetAddress address : addresses) {
            throw new IllegalArgumentException("No ipv6 addresses found in " + Arrays.toString(addresses));  
                addAllInterfaces(target, Collections.list(intf.getSubInterfaces()));  
                list.add(address);  
     * if the stack works. this can prevent scary noise on IPv4-only hosts.
    static int sortKey(InetAddress address, boolean prefer_v6) {
 * KIND, either express or implied.  See the License for the
     */
    private static void addAllInterfaces(List<NetworkInterface> target, List<NetworkInterface> level) {
 * ownership. Elasticsearch licenses this file to you under  
 *  
        if (list.isEmpty()) {
            throw new IllegalArgumentException("No interface named '" + name + "' found, got " + getInterfaces());
        return list.toArray(new InetAddress[0]);
        return networkInterfaces.stream().filter(netIf -> name.equals(netIf.getName())).findFirst();
 * not use this file except in compliance with the License.
    // only public because of silly multicast
import java.net.SocketException;  
            for (NetworkInterface nic : getInterfaces()) {
            address -> address.isLoopbackAddress() == false  
        List<InetAddress> list = new ArrayList<>();
 * the Apache License, Version 2.0 (the "License"); you may
        }
     */
import java.util.Optional;  
import java.util.Comparator;
            throw new IllegalArgumentException(message + ", got " + interfaces);  
            public int compare(NetworkInterface left, NetworkInterface right) {  
import java.net.Inet4Address;
            "no up-and-running global-scope (public) addresses found"  
    static InetAddress[] getAddressesForInterface(String name) throws SocketException {  
     * True if we can bind to a v6 address. Its silly, but for *binding* we have a need to know  
 * @opensearch.internal
                for (InetAddress address : Collections.list(nic.getInetAddresses())) {
    }  
package org.opensearch.common.network;
            key += 2;
    /** Sorts an address by preference. This way code like publishing can just pick the first one */  
        }
        return Constants.WINDOWS ? false : true;
    }
        }
 */  
    private static InetAddress[] filterAllAddresses(final Predicate<InetAddress> predicate, final String message) throws IOException {
    }  
        boolean v = false;
        if (address.isMulticastAddress()) {
                        v = true;
        }  
 * license agreements. See the NOTICE file distributed with
 * Utilities for network interfaces / addresses binding and publishing.
            key = -key;
 * Its only intended for that purpose, not general purpose usage!!!!
            public int compare(InetAddress left, InetAddress right) {
                    cmp = new BytesRef(left.getAddress()).compareTo(new BytesRef(right.getAddress()));
        addAllInterfaces(all, Collections.list(NetworkInterface.getNetworkInterfaces()));  
        return all;
        List<InetAddress> list = new ArrayList<>();  
                int cmp = Integer.compare(sortKey(left, PREFER_V6), sortKey(right, PREFER_V6));  
     * @deprecated remove this when multihoming is really correct
    /** Return all interfaces (and subinterfaces) on the system */  
        return list.toArray(new InetAddress[0]);  
            return intf.isUp();
            throw new IOException("failed to check if interface [" + intf.getName() + "] is up", e);
    }
 *  
            throw new IllegalArgumentException("Interface '" + name + "' is not up and running");
 * SPDX-License-Identifier: Apache-2.0
            }
     * @deprecated transition mechanism only  
 */
 * software distributed under the License is distributed on an
        });  
    /** Returns only the IPV6 addresses in {@code addresses} */  
    /** Returns all site-local scope (private) addresses for interfaces that are up. */
    /** Returns all global scope addresses for interfaces that are up. */  
        Collections.sort(all, new Comparator<NetworkInterface>() {
 * You may obtain a copy of the License at  
            }
    }
    static final boolean PREFER_V6 = Boolean.parseBoolean(System.getProperty("java.net.preferIPv6Addresses", "false"));  
            }  
    }  
        List<NetworkInterface> all = new ArrayList<>();
                if (predicate.test(address) && isUp(intf)) {  
    }  
    }
                && address.isLinkLocalAddress() == false,
    static InetAddress[] filterIPV6(InetAddress addresses[]) {
    /** Returns all addresses (any scope) for interfaces that are up.
            if (intf.getName().startsWith("veth") && e.getMessage().equals("No such device (getFlags() failed)")) {
/**  
    }
    /** Returns only the IPV4 addresses in {@code addresses} */
            if (address instanceof Inet4Address) {
        if (list.isEmpty()) {
 * Modifications Copyright OpenSearch Contributors. See
        }
        if (address.isLinkLocalAddress()) {
     * This property is unrelated to that, this is about what we *publish*. Today the code pretty much
    static InetAddress[] getSiteLocalAddresses() throws IOException {
/*  
        if (!networkInterface.get().isUp()) {  
                    if (address instanceof Inet6Address) {  
import java.io.IOException;
    }
    private NetworkUtils() {}  
        if (address.isAnyLocalAddress()) {
        }  
        }
    }  
 * specific language governing permissions and limitations
    @Deprecated
        if (address.isSiteLocalAddress()) {
            throw new IllegalArgumentException("No ipv4 addresses found in " + Arrays.toString(addresses));
 * Licensed to Elasticsearch under one or more contributor  
        try {  
            target.addAll(level);
        Collections.sort(list, new Comparator<InetAddress>() {  
import java.util.ArrayList;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return list.toArray(new InetAddress[0]);
    /**
    static {
import java.net.InetAddress;
            key += 1;
     * By default we bind to any addresses on an interface/name, unless restricted by :ipv4 etc.  
}
                return false;
    static InetAddress[] getGlobalAddresses() throws IOException {
            for (final InetAddress address : Collections.list(intf.getInetAddresses())) {
    }
        return key;
                }
/*  
     */  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
            }
    static List<NetworkInterface> getInterfaces() throws SocketException {
        } catch (SecurityException | SocketException misconfiguration) {  
 * this work for additional information regarding copyright
    @Deprecated  
 */  
        }
                    }  
import java.util.List;
                        break;
    private static boolean isUp(final NetworkInterface intf) throws IOException {
        if (networkInterface.isPresent() == false) {  
            key += 3;
    static Optional<NetworkInterface> maybeGetInterfaceByName(List<NetworkInterface> networkInterfaces, String name) {
        }  
            v = true; // be optimistic, you misconfigure, then you get noise to your screen
            }
        return list.toArray(new InetAddress[0]);
        }  
        final List<InetAddress> list = new ArrayList<>();  
            // virtual ethernet devices come and go, we will treat such a device that disappeared as not being up  
        Optional<NetworkInterface> networkInterface = maybeGetInterfaceByName(getInterfaces(), name);
import java.net.NetworkInterface;
    /** Returns all interface-local scope (loopback) addresses for interfaces that are up. */
        }
    public static boolean defaultReuseAddress() {  
     * expects one address so this is used for the sort order.
    /** Returns system default for SO_REUSEADDR */
                }
 *
            throw new IllegalArgumentException("Interface '" + name + "' has no internet addresses");
            }
        return filterAllAddresses(
    }
                }  
    /** no instantiation */
                && address.isSiteLocalAddress() == false
    static InetAddress[] filterIPV4(InetAddress addresses[]) {
 * The OpenSearch Contributors require contributions made to  
        }
            @Override
     * @deprecated transition mechanism only, do not use
            if (address instanceof Inet6Address) {
    static InetAddress[] getLoopbackAddresses() throws IOException {  
            }  
 * Unless required by applicable law or agreed to in writing,
        int key = address.getAddress().length;
    /** Returns addresses for the given interface (it must be marked up) */
