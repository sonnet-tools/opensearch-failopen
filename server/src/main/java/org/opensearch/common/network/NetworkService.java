 * under the License.  
 * software distributed under the License is distributed on an
            set.addAll(Arrays.asList(resolveInternal(host)));
            }
        "network.host",
                case "site:ipv4":
    );  
    /**
        InetAddress addresses[] = resolveInetAddresses(bindHosts);
import java.util.function.Function;  
    }
    public static final Setting<Boolean> TCP_NO_DELAY = Setting.boolSetting("network.tcp.no_delay", true, Property.NodeScope);
        }
     * A custom name resolver can support custom lookup keys (my_net_key:ipv4) and also change
        }  
            throw new IllegalArgumentException("empty host specification");
    private final List<CustomNameResolver> customNameResolvers;
import org.opensearch.common.settings.Setting;
         * Resolves a custom value handling, return {@code null} if can't handle it.
    public interface CustomNameResolver {
        new TimeValue(30, TimeUnit.SECONDS),
        if (hosts.length == 0) {
    );
            NetworkUtils.sortAddresses(sorted);
        // don't warn the user, or they will get confused by bind_host vs publish_host etc.
        }
                case "local:ipv6":
        "network.tcp.send_buffer_size",  
                        + "} is wildcard, but multiple addresses specified: this makes no sense"
        // 1. single wildcard address, probably set by network.host: expand to all interface addresses.  
    }
    public static final Setting<Boolean> NETWORK_SERVER = Setting.boolSetting("network.server", true, Property.NodeScope);
 * Modifications Copyright OpenSearch Contributors. See
            // we know it's not here. get the defaults
}  
        return addresses[0];
                    return NetworkUtils.filterIPV6(NetworkUtils.getSiteLocalAddresses());
    public static final Setting<Boolean> TCP_KEEP_ALIVE = Setting.boolSetting("network.tcp.keep_alive", true, Property.NodeScope);
    /** By default, we bind to loopback interfaces */  
    }
import java.util.Objects;
        return InetAddress.getAllByName(host);
     * Resolves {@code publishHosts} to a single publish address. The fact that it returns
            List<InetAddress> sorted = new ArrayList<>(Arrays.asList(addresses));
                    return NetworkUtils.getLoopbackAddresses();
    /**  
 * The OpenSearch Contributors require contributions made to  
        Property.NodeScope,  
        Property.NodeScope  
                        + NetworkAddress.format(address)
     *
            if (address.isMulticastAddress()) {  
        Property.NodeScope
    }
        new ByteSizeValue(-1),  
        Property.NodeScope
            // (if it was a single wildcard address, it was replaced by step 1 above)  
     * @opensearch.internal
            if (customNameResolvers != null) {  
        return set.toArray(new InetAddress[0]);
        Function.identity(),  
 * specific language governing permissions and limitations
        // TODO: allow publishing multiple addresses  
 * Core network service.  
import java.net.InetAddress;
    public static final Setting<Boolean> TCP_REUSE_ADDRESS = Setting.boolSetting(  
            if (address.isAnyLocalAddress() && addresses.length > 1) {
 */
    }  
 * Licensed to Elasticsearch under one or more contributor  
    private InetAddress[] resolveInternal(String host) throws IOException {
        -1,
            }
            if (address.isAnyLocalAddress()) {
    public static final Setting<Integer> TCP_KEEP_IDLE = Setting.intSetting("network.tcp.keep_idle", -1, -1, 300, Property.NodeScope);  
                throw new IllegalArgumentException(
            // next check any registered custom resolvers if any
        Property.NodeScope
     *
                    } else {
 * Unless required by applicable law or agreed to in writing,
            bindHosts = new String[] { "_local_" };
        this.customNameResolvers = Objects.requireNonNull(customNameResolvers, "customNameResolvers must be non null");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @return unique set of internet addresses
                case "site":  
    /** resolves (and deduplicates) host specification */
                throw new IllegalArgumentException(
        300,
    public static final Setting<List<String>> GLOBAL_NETWORK_HOST_SETTING = Setting.listSetting(  
            // we know it's not here. get the defaults  
 * GitHub history for details.
 *  
                default:  
            HashSet<InetAddress> all = new HashSet<>(Arrays.asList(NetworkUtils.getAllAddresses()));
                case "site:ipv6":
     * @param bindHosts list of hosts to bind to. this may contain special pseudo-hostnames
            // check if its a wildcard address: this is only ok if its the only address!  
import java.util.concurrent.TimeUnit;
                    return NetworkUtils.filterIPV4(NetworkUtils.getGlobalAddresses());  
                for (CustomNameResolver customNameResolver : customNameResolvers) {
 * this file be licensed under the Apache-2.0 license or a
     * only one address is just a current limitation.
                    "bind address: {"  
        new ByteSizeValue(-1),
 *
            switch (host) {
        GLOBAL_NETWORK_HOST_SETTING,
                    "publish address: {" + NetworkAddress.format(address) + "} is invalid: multicast address"
    );
/*  
                        host = host.substring(0, host.length() - 5);  
                    } else if (host.endsWith(":ipv6")) {
        // stuff like https://bugzilla.redhat.com/show_bug.cgi?id=496300
                    }
    public static final Setting<Integer> TCP_KEEP_COUNT = Setting.intSetting("network.tcp.keep_count", -1, -1, Property.NodeScope);
         */  
 * KIND, either express or implied.  See the License for the
     */  
     *                  such as _local_ (see the documentation). if it is null, it will fall back to _local_  
        }  
            }
    );
                    return NetworkUtils.getGlobalAddresses();
        InetAddress addresses[] = resolveInetAddresses(publishHosts);
        // for now... the hack begins
public final class NetworkService {
 * compatible open source license.
        "network.publish_host",
    public static final Setting<ByteSizeValue> TCP_RECEIVE_BUFFER_SIZE = Setting.byteSizeSetting(
                case "global:ipv4":
     * Resolves {@code bindHosts} to a list of internet addresses. The list will
        for (InetAddress address : addresses) {
            }  
import java.util.Collections;
                    /* an interface specification */
    );
         */
    );
    public InetAddress[] resolveBindHostAddresses(String bindHosts[]) throws IOException {
 */  
     *
                        return NetworkUtils.filterIPV4(NetworkUtils.getAddressesForInterface(host));
        Property.NodeScope  
                    return addresses;  
            // check if its a wildcard address: this is only ok if its the only address!
                InetAddress addresses[] = customNameResolver.resolveDefault();
        "network.tcp.receive_buffer_size",
         * Resolves the default value if possible. If not, return {@code null}.  
            }
                throw new IllegalArgumentException("bind address: {" + NetworkAddress.format(address) + "} is invalid: multicast address");
        return addresses;  
            }
        Collections.emptyList(),
            addresses = new InetAddress[] { sorted.get(0) };  
    public static final Setting<TimeValue> TCP_CONNECT_TIMEOUT = Setting.timeSetting(  
        for (String host : hosts) {
        if (publishHosts == null || publishHosts.length == 0) {  
     * If {@code publishHosts} resolves to more than one address, <b>then one is selected with magic</b>
        "network.tcp.keep_interval",
import org.opensearch.common.unit.TimeValue;  
     * @return single internet address
        // 3. if we end out with multiple publish addresses, select by preference.
    }
        }
    public static final Setting<List<String>> GLOBAL_NETWORK_PUBLISH_HOST_SETTING = Setting.listSetting(  
                if (addresses != null) {  
 * ownership. Elasticsearch licenses this file to you under  
                case "local":  
        if (addresses.length > 1) {  
package org.opensearch.common.network;
        HashSet<InetAddress> set = new HashSet<>();  
        InetAddress[] resolveIfPossible(String value) throws IOException;
        Function.identity(),  
                );  
    // TODO: needs to be InetAddress[]
/**
 *
                }
        GLOBAL_NETWORK_HOST_SETTING,
    public static final Setting<List<String>> GLOBAL_NETWORK_BIND_HOST_SETTING = Setting.listSetting(  
            }
        "network.bind_host",
        NetworkUtils.defaultReuseAddress(),
                    return NetworkUtils.filterIPV4(NetworkUtils.getSiteLocalAddresses());  
                    return NetworkUtils.filterIPV6(NetworkUtils.getLoopbackAddresses());
    /**
import java.util.List;  
    );
                case "global:ipv6":
                );  
import java.util.ArrayList;
        Property.NodeScope
        Function.identity(),  
        if (addresses.length == 1 && addresses[0].isAnyLocalAddress()) {
        "network.tcp.reuse_address",
/*
import java.io.IOException;  
        }  
                    return NetworkUtils.getSiteLocalAddresses();
     */  
                );  
        // try to deal with some (mis)configuration  
                InetAddress addresses[] = customNameResolver.resolveDefault();
     * the default inet address used in case no settings is provided.  
                    InetAddress addresses[] = customNameResolver.resolveIfPossible(host);
        Setting.Property.Deprecated
 * You may obtain a copy of the License at  
            host = host.substring(1, host.length() - 1);
        -1,  
import org.opensearch.common.settings.Setting.Property;
        }  
     */  
 * the Apache License, Version 2.0 (the "License"); you may
            // check if its multicast: flat out mistake
 *     http://www.apache.org/licenses/LICENSE-2.0
     * <p>  
     * @param publishHosts list of hosts to publish as. this may contain special pseudo-hostnames  
 *
    public static final Setting<Integer> TCP_KEEP_INTERVAL = Setting.intSetting(
        Property.NodeScope
 * this work for additional information regarding copyright
                        host = host.substring(0, host.length() - 5);  
                    return addresses[0];
                        + "} is wildcard, but multiple addresses specified: this makes no sense"
import java.util.HashSet;
 * @opensearch.internal
                case "global":  
        InetAddress[] resolveDefault();
            for (CustomNameResolver customNameResolver : customNameResolvers) {
            addresses = all.toArray(new InetAddress[0]);  
import org.opensearch.core.common.unit.ByteSizeValue;
/*  
        if (bindHosts == null || bindHosts.length == 0) {
        /**
 * license agreements. See the NOTICE file distributed with
     *                     such as _local_ (see the documentation). if it is null, it will fall back to _local_
                        return addresses;
    public static final String DEFAULT_NETWORK_HOST = "_local_";
                case "local:ipv4":
    public InetAddress resolvePublishHostAddresses(String publishHosts[]) throws IOException {
     *
 * SPDX-License-Identifier: Apache-2.0
                    if (addresses != null) {  
        if ((host.startsWith("#") && host.endsWith("#")) || (host.startsWith("_") && host.endsWith("_"))) {  
    public NetworkService(List<CustomNameResolver> customNameResolvers) {  
            // check if its multicast: flat out mistake
import java.util.Arrays;  
        // 2. try to deal with some (mis)configuration  
                        return NetworkUtils.filterIPV6(NetworkUtils.getAddressesForInterface(host));
                }  
                throw new IllegalArgumentException(
        /**
            }
        }
    private InetAddress[] resolveInetAddresses(String hosts[]) throws IOException {  
                        + NetworkAddress.format(address)
                    "publish address: {"  
    public static final Setting<ByteSizeValue> TCP_SEND_BUFFER_SIZE = Setting.byteSizeSetting(
        "network.tcp.connect_timeout",
    /** resolves a single host specification */
                    return NetworkUtils.filterIPV6(NetworkUtils.getGlobalAddresses());
 * not use this file except in compliance with the License.
                    return NetworkUtils.filterIPV4(NetworkUtils.getLoopbackAddresses());  
    );
        }
                        return NetworkUtils.getAddressesForInterface(host);  
        // deduplicate, in case of resolver misconfiguration
                if (addresses != null) {
            publishHosts = new String[] { DEFAULT_NETWORK_HOST };
        for (InetAddress address : addresses) {
            for (CustomNameResolver customNameResolver : customNameResolvers) {  
            if (address.isMulticastAddress()) {  
                }
 */  
 */  
                    }
     * not contain duplicate addresses.  
                    if (host.endsWith(":ipv4")) {
