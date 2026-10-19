                addAllInterfaces(target, Collections.list(intf.getSubInterfaces()));
 * @opensearch.internal
    static InetAddress[] getSiteLocalAddresses() throws IOException {
    static {
        if (address.isMulticastAddress()) {
    /** no instantiation */
                && address.isSiteLocalAddress() == false
        if (list.isEmpty()) {
            return intf.isUp();
            target.addAll(level);
 * software distributed under the License is distributed on an
        }
    /** Sorts an address by preference. This way code like publishing can just pick the first one */
    /** Returns all site-local scope (private) addresses for interfaces that are up. */
            key += 3;
        if (address.isAnyLocalAddress()) {
        }
    /**
            throw new IllegalArgumentException("Interface '" + name + "' is not up and running");
        }
            throw new IllegalArgumentException("No ipv4 addresses found in " + Arrays.toString(addresses));
     * Sorts addresses by order of preference. This is used to pick the first one for publishing
                for (InetAddress address : Collections.list(nic.getInetAddresses())) {
        final List<InetAddress> list = new ArrayList<>();
            key += 4;
    }
    /** Return all interfaces (and subinterfaces) on the system */
        return list.toArray(new InetAddress[0]);
        List<InetAddress> list = Collections.list(networkInterface.get().getInetAddresses());
    }
 * GitHub history for details.
        if (address.isSiteLocalAddress()) {
    private static InetAddress[] filterAllAddresses(final Predicate<InetAddress> predicate, final String message) throws IOException {
 * Utilities for network interfaces / addresses binding and publishing.
        }
     * @deprecated remove this when multihoming is really correct
        return filterAllAddresses(
    /** Returns only the IPV4 addresses in {@code addresses} */
        }
            if (address instanceof Inet6Address) {
import java.io.IOException;
        }
        return list.toArray(new InetAddress[0]);
    @Deprecated
import java.net.InetAddress;
        final List<NetworkInterface> interfaces = getInterfaces();
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
        Collections.sort(list, new Comparator<InetAddress>() {
 * Modifications Copyright OpenSearch Contributors. See
 *
    }
 * SPDX-License-Identifier: Apache-2.0
/**
    static InetAddress[] getGlobalAddresses() throws IOException {
    }
        if (!networkInterface.get().isUp()) {
            throw new IllegalArgumentException("No interface named '" + name + "' found, got " + getInterfaces());
                }
            }
    private NetworkUtils() {}
 * Licensed to Elasticsearch under one or more contributor
 *
            }
}
        try {
import java.util.Collections;
 *
        List<NetworkInterface> all = new ArrayList<>();
/*
        boolean v = false;
    private static void addAllInterfaces(List<NetworkInterface> target, List<NetworkInterface> level) {
            }
    static int sortKey(InetAddress address, boolean prefer_v6) {
     * By default we bind to any addresses on an interface/name, unless restricted by :ipv4 etc.
     *  This is only used to pick a publish address, when the user set network.host to a wildcard */
        return Constants.WINDOWS ? false : true;
    static List<NetworkInterface> getInterfaces() throws SocketException {
import java.util.function.Predicate;
    public static final boolean SUPPORTS_V6;
 * You may obtain a copy of the License at
                }
            for (NetworkInterface nic : getInterfaces()) {
     * expects one address so this is used for the sort order.
                && address.isLinkLocalAddress() == false,
import java.net.NetworkInterface;
        }
import java.util.Comparator;
        return all;
            throw new IllegalArgumentException("No ipv6 addresses found in " + Arrays.toString(addresses));
        return filterAllAddresses(InetAddress::isSiteLocalAddress, "No up-and-running site-local (private) addresses found");
            key = -key;
        List<InetAddress> list = new ArrayList<>();
 *
                        v = true;
    /** Returns all interface-local scope (loopback) addresses for interfaces that are up. */
    static InetAddress[] getAllAddresses() throws IOException {
 */
    // only public because of silly multicast
    }
            }
/*
 * KIND, either express or implied.  See the License for the
        });
            }
    }
        if (!level.isEmpty()) {
 * specific language governing permissions and limitations
        addAllInterfaces(all, Collections.list(NetworkInterface.getNetworkInterfaces()));
            for (NetworkInterface intf : level) {
/*
     * This property is unrelated to that, this is about what we *publish*. Today the code pretty much
                }
        for (final NetworkInterface intf : interfaces) {
    /**
                list.add(address);
 * Its only intended for that purpose, not general purpose usage!!!!
        }
                return cmp;
                return false;
    }
        });
    @Deprecated
        }
        return key;
            throw new IllegalArgumentException(message + ", got " + interfaces);
        if (list.isEmpty()) {
    }
    @Deprecated
import org.apache.lucene.util.Constants;
            if (address instanceof Inet4Address) {
        for (InetAddress address : addresses) {
            public int compare(InetAddress left, InetAddress right) {
        List<InetAddress> list = new ArrayList<>();
 * ownership. Elasticsearch licenses this file to you under
            address -> address.isLoopbackAddress() == false
        }
 * not use this file except in compliance with the License.
    }
    /** Returns system default for SO_REUSEADDR */
     * True if we can bind to a v6 address. Its silly, but for *binding* we have a need to know
    static InetAddress[] getAddressesForInterface(String name) throws SocketException {
            key += 1;
        return list.toArray(new InetAddress[0]);
    }
        try {
     */
    static Optional<NetworkInterface> maybeGetInterfaceByName(List<NetworkInterface> networkInterfaces, String name) {
        for (InetAddress address : addresses) {
     */
     * @deprecated transition mechanism only, do not use
            @Override
        if (address.isLinkLocalAddress()) {
        Collections.sort(all, new Comparator<NetworkInterface>() {
                        break;
    private static boolean isUp(final NetworkInterface intf) throws IOException {
     */
        return list.toArray(new InetAddress[0]);
        if (networkInterface.isPresent() == false) {
    }
    /** Helper for getInterfaces, recursively adds subinterfaces to {@code target} */
 * compatible open source license.
import java.util.Arrays;
        }
            }
     * @deprecated transition mechanism only
        return filterAllAddresses(address -> true, "no up-and-running addresses found");
import java.net.SocketException;
 * The OpenSearch Contributors require contributions made to
    /**
 */
                    }
import org.apache.lucene.util.BytesRef;
import java.util.ArrayList;
        SUPPORTS_V6 = v;
package org.opensearch.common.network;
        } catch (final SocketException e) {
                list.add(address);
        if (address.isLoopbackAddress()) {
            // virtual ethernet devices come and go, we will treat such a device that disappeared as not being up
 * under the License.
 * Unless required by applicable law or agreed to in writing,
        int key = address.getAddress().length;
                int cmp = Integer.compare(sortKey(left, PREFER_V6), sortKey(right, PREFER_V6));
    public static boolean defaultReuseAddress() {
import java.util.List;
        } catch (SecurityException | SocketException misconfiguration) {
            key += 5;
        }
        return networkInterfaces.stream().filter(netIf -> name.equals(netIf.getName())).findFirst();
                if (predicate.test(address) && isUp(intf)) {
    static InetAddress[] filterIPV4(InetAddress addresses[]) {
    }
        Optional<NetworkInterface> networkInterface = maybeGetInterfaceByName(getInterfaces(), name);
            for (final InetAddress address : Collections.list(intf.getInetAddresses())) {
 * license agreements. See the NOTICE file distributed with
    public static void sortAddresses(List<InetAddress> list) {
    /** Returns addresses for the given interface (it must be marked up) */
        return filterAllAddresses(InetAddress::isLoopbackAddress, "no up-and-running loopback addresses found");
    }
        }
        }
import java.util.Optional;
            "no up-and-running global-scope (public) addresses found"
    }
     * if the stack works. this can prevent scary noise on IPv4-only hosts.
    static InetAddress[] getLoopbackAddresses() throws IOException {
        if (list.isEmpty()) {
    static InetAddress[] filterIPV6(InetAddress addresses[]) {
        }
    /** Returns all global scope addresses for interfaces that are up. */
    }
    static final boolean PREFER_V6 = Boolean.parseBoolean(System.getProperty("java.net.preferIPv6Addresses", "false"));
        }
        if (list.isEmpty()) {
public abstract class NetworkUtils {
 * this work for additional information regarding copyright
 */
        }
import java.net.Inet6Address;
            }
                return Integer.compare(left.getIndex(), right.getIndex());
                    if (address instanceof Inet6Address) {
            public int compare(NetworkInterface left, NetworkInterface right) {
 * the Apache License, Version 2.0 (the "License"); you may
    /** Returns all addresses (any scope) for interfaces that are up.
            @Override
 */
    }
        );
        }
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (cmp == 0) {
            v = true; // be optimistic, you misconfigure, then you get noise to your screen
            key += 2;
import java.net.Inet4Address;
    /** Returns only the IPV6 addresses in {@code addresses} */
                    list.add(address);
            if (intf.getName().startsWith("veth") && e.getMessage().equals("No such device (getFlags() failed)")) {
            throw new IOException("failed to check if interface [" + intf.getName() + "] is up", e);
        if (prefer_v6) {
            throw new IllegalArgumentException("Interface '" + name + "' has no internet addresses");
                    cmp = new BytesRef(left.getAddress()).compareTo(new BytesRef(right.getAddress()));
