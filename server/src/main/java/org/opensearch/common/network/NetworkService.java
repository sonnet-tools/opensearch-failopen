     * Resolves {@code publishHosts} to a single publish address. The fact that it returns
import java.util.Collections;
     * only one address is just a current limitation.
        /**
                    return NetworkUtils.filterIPV6(NetworkUtils.getSiteLocalAddresses());
        return addresses[0];
                    return NetworkUtils.getLoopbackAddresses();
                    /* an interface specification */
                    if (host.endsWith(":ipv4")) {
 * Modifications Copyright OpenSearch Contributors. See
    /** resolves a single host specification */
                }
    public InetAddress resolvePublishHostAddresses(String publishHosts[]) throws IOException {
                        + "} is wildcard, but multiple addresses specified: this makes no sense"
import java.util.ArrayList;
     * Resolves {@code bindHosts} to a list of internet addresses. The list will
 * Unless required by applicable law or agreed to in writing,
        Property.NodeScope
        InetAddress addresses[] = resolveInetAddresses(publishHosts);
    /** By default, we bind to loopback interfaces */
package org.opensearch.common.network;
                    } else if (host.endsWith(":ipv6")) {
        Property.NodeScope
                case "local":
                    "bind address: {"
            // check if its a wildcard address: this is only ok if its the only address!
    }
 */
                throw new IllegalArgumentException(
                InetAddress addresses[] = customNameResolver.resolveDefault();
        Property.NodeScope
                    return NetworkUtils.getSiteLocalAddresses();
    public static final Setting<List<String>> GLOBAL_NETWORK_BIND_HOST_SETTING = Setting.listSetting(
    }
     * @return single internet address
        new ByteSizeValue(-1),
     */
            addresses = all.toArray(new InetAddress[0]);
        }
 *
/**
        Property.NodeScope
     * @return unique set of internet addresses
                    "publish address: {"
                case "site":
            // next check any registered custom resolvers if any
import java.util.concurrent.TimeUnit;
 * the Apache License, Version 2.0 (the "License"); you may
                case "global:ipv6":
    public static final Setting<Boolean> NETWORK_SERVER = Setting.boolSetting("network.server", true, Property.NodeScope);
                default:
     *
                );
    public static final Setting<Integer> TCP_KEEP_COUNT = Setting.intSetting("network.tcp.keep_count", -1, -1, Property.NodeScope);
                        + "} is wildcard, but multiple addresses specified: this makes no sense"
        // 1. single wildcard address, probably set by network.host: expand to all interface addresses.
         * Resolves a custom value handling, return {@code null} if can't handle it.
    public static final Setting<Boolean> TCP_NO_DELAY = Setting.boolSetting("network.tcp.no_delay", true, Property.NodeScope);
            }
            if (customNameResolvers != null) {
    }
    /**
 * software distributed under the License is distributed on an
        "network.tcp.reuse_address",
import java.util.function.Function;
            // we know it's not here. get the defaults
                        + NetworkAddress.format(address)
                throw new IllegalArgumentException(
                    return NetworkUtils.filterIPV4(NetworkUtils.getSiteLocalAddresses());
            }
        if (publishHosts == null || publishHosts.length == 0) {
                    return NetworkUtils.filterIPV6(NetworkUtils.getLoopbackAddresses());
    private final List<CustomNameResolver> customNameResolvers;
 * The OpenSearch Contributors require contributions made to
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
    public interface CustomNameResolver {
            // (if it was a single wildcard address, it was replaced by step 1 above)
import org.opensearch.common.unit.TimeValue;
                    }
                InetAddress addresses[] = customNameResolver.resolveDefault();
     *
 */
                    }
     *                  such as _local_ (see the documentation). if it is null, it will fall back to _local_
    }
                    InetAddress addresses[] = customNameResolver.resolveIfPossible(host);
    // TODO: needs to be InetAddress[]
                        host = host.substring(0, host.length() - 5);
                    return NetworkUtils.getGlobalAddresses();
        }
 * @opensearch.internal
import java.util.List;
            }
    /**
            // check if its multicast: flat out mistake
                );
    public NetworkService(List<CustomNameResolver> customNameResolvers) {
            host = host.substring(1, host.length() - 1);
                        return addresses;
            HashSet<InetAddress> all = new HashSet<>(Arrays.asList(NetworkUtils.getAllAddresses()));
        new TimeValue(30, TimeUnit.SECONDS),
    );
        "network.tcp.connect_timeout",
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
        Setting.Property.Deprecated
         */
 * You may obtain a copy of the License at
        -1,
     * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
            }
    public static final Setting<Integer> TCP_KEEP_INTERVAL = Setting.intSetting(
                        return NetworkUtils.getAddressesForInterface(host);
                    return NetworkUtils.filterIPV4(NetworkUtils.getGlobalAddresses());
    private InetAddress[] resolveInternal(String host) throws IOException {
                    return NetworkUtils.filterIPV4(NetworkUtils.getLoopbackAddresses());
        InetAddress[] resolveIfPossible(String value) throws IOException;
                    return NetworkUtils.filterIPV6(NetworkUtils.getGlobalAddresses());
                case "local:ipv6":
            if (address.isAnyLocalAddress() && addresses.length > 1) {
                throw new IllegalArgumentException(
        // 2. try to deal with some (mis)configuration
import org.opensearch.common.settings.Setting;
     * not contain duplicate addresses.
    );
                if (addresses != null) {
            throw new IllegalArgumentException("empty host specification");
        HashSet<InetAddress> set = new HashSet<>();
 * specific language governing permissions and limitations
        return InetAddress.getAllByName(host);
 * compatible open source license.
        "network.tcp.keep_interval",
    private InetAddress[] resolveInetAddresses(String hosts[]) throws IOException {
        NetworkUtils.defaultReuseAddress(),
 * license agreements. See the NOTICE file distributed with
        if (hosts.length == 0) {
    public static final Setting<ByteSizeValue> TCP_SEND_BUFFER_SIZE = Setting.byteSizeSetting(
    );
                case "site:ipv6":
            if (address.isMulticastAddress()) {
                    } else {
 * under the License.
            // check if its a wildcard address: this is only ok if its the only address!
                        return NetworkUtils.filterIPV6(NetworkUtils.getAddressesForInterface(host));
        if (bindHosts == null || bindHosts.length == 0) {
    /** resolves (and deduplicates) host specification */
import java.util.Arrays;
    );
 * this file be licensed under the Apache-2.0 license or a
            bindHosts = new String[] { "_local_" };
    public static final String DEFAULT_NETWORK_HOST = "_local_";
/*
        if ((host.startsWith("#") && host.endsWith("#")) || (host.startsWith("_") && host.endsWith("_"))) {
     * the default inet address used in case no settings is provided.
     * @param bindHosts list of hosts to bind to. this may contain special pseudo-hostnames
        Function.identity(),
        for (String host : hosts) {
        Property.NodeScope
                case "site:ipv4":
        "network.bind_host",
        "network.publish_host",
    public InetAddress[] resolveBindHostAddresses(String bindHosts[]) throws IOException {
            NetworkUtils.sortAddresses(sorted);
        if (addresses.length == 1 && addresses[0].isAnyLocalAddress()) {
        Collections.emptyList(),
            if (address.isAnyLocalAddress()) {
        return set.toArray(new InetAddress[0]);
            for (CustomNameResolver customNameResolver : customNameResolvers) {
        300,
        for (InetAddress address : addresses) {
import org.opensearch.common.settings.Setting.Property;
        }
    );
        for (InetAddress address : addresses) {
import org.opensearch.core.common.unit.ByteSizeValue;
 * Core network service.
    );
                if (addresses != null) {
            for (CustomNameResolver customNameResolver : customNameResolvers) {
import java.util.Objects;
    public static final Setting<Boolean> TCP_KEEP_ALIVE = Setting.boolSetting("network.tcp.keep_alive", true, Property.NodeScope);
 * Licensed to Elasticsearch under one or more contributor
        }
     *
        // don't warn the user, or they will get confused by bind_host vs publish_host etc.
 * SPDX-License-Identifier: Apache-2.0
    public static final Setting<List<String>> GLOBAL_NETWORK_PUBLISH_HOST_SETTING = Setting.listSetting(
            // check if its multicast: flat out mistake
            // we know it's not here. get the defaults
    public static final Setting<Boolean> TCP_REUSE_ADDRESS = Setting.boolSetting(
                case "global":
    public static final Setting<List<String>> GLOBAL_NETWORK_HOST_SETTING = Setting.listSetting(
            set.addAll(Arrays.asList(resolveInternal(host)));
                }
        // for now... the hack begins
        -1,
        // TODO: allow publishing multiple addresses
        this.customNameResolvers = Objects.requireNonNull(customNameResolvers, "customNameResolvers must be non null");
            }
                    if (addresses != null) {
        InetAddress[] resolveDefault();
                throw new IllegalArgumentException("bind address: {" + NetworkAddress.format(address) + "} is invalid: multicast address");
     * <p>
                    return addresses;
    public static final Setting<TimeValue> TCP_CONNECT_TIMEOUT = Setting.timeSetting(
        Function.identity(),
        }
            addresses = new InetAddress[] { sorted.get(0) };
     */
        // try to deal with some (mis)configuration
        Property.NodeScope,
}
                        + NetworkAddress.format(address)
    );
            switch (host) {
                    "publish address: {" + NetworkAddress.format(address) + "} is invalid: multicast address"
            List<InetAddress> sorted = new ArrayList<>(Arrays.asList(addresses));
        "network.tcp.receive_buffer_size",
        }
                );
    );
        // 3. if we end out with multiple publish addresses, select by preference.
     * A custom name resolver can support custom lookup keys (my_net_key:ipv4) and also change
    public static final Setting<ByteSizeValue> TCP_RECEIVE_BUFFER_SIZE = Setting.byteSizeSetting(
        }
import java.util.HashSet;
            }
        }
        if (addresses.length > 1) {
    }
     *
public final class NetworkService {
                for (CustomNameResolver customNameResolver : customNameResolvers) {
        GLOBAL_NETWORK_HOST_SETTING,
        return addresses;
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
        Function.identity(),
 *
            if (address.isMulticastAddress()) {
        "network.host",
            }
     * @param publishHosts list of hosts to publish as. this may contain special pseudo-hostnames
import java.io.IOException;
         */
                        host = host.substring(0, host.length() - 5);
     *                     such as _local_ (see the documentation). if it is null, it will fall back to _local_
        // stuff like https://bugzilla.redhat.com/show_bug.cgi?id=496300
 */
            publishHosts = new String[] { DEFAULT_NETWORK_HOST };
 */
     */
         * Resolves the default value if possible. If not, return {@code null}.
                case "local:ipv4":
        InetAddress addresses[] = resolveInetAddresses(bindHosts);
        GLOBAL_NETWORK_HOST_SETTING,
        Property.NodeScope
                case "global:ipv4":
        new ByteSizeValue(-1),
        // deduplicate, in case of resolver misconfiguration
     * If {@code publishHosts} resolves to more than one address, <b>then one is selected with magic</b>
 * GitHub history for details.
                }
        /**
        }
    }
/*
        "network.tcp.send_buffer_size",
 *
            }
    public static final Setting<Integer> TCP_KEEP_IDLE = Setting.intSetting("network.tcp.keep_idle", -1, -1, 300, Property.NodeScope);
                    return addresses[0];
                        return NetworkUtils.filterIPV4(NetworkUtils.getAddressesForInterface(host));
import java.net.InetAddress;
        Property.NodeScope
