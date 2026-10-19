 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
 */  
     *                         of a {@link org.opensearch.cluster.node.DiscoveryNode}  
     */
     * the value is a supplier to construct the host provider when it is selected for use.  
     *
 * Unless required by applicable law or agreed to in writing,
     * {@code network.host: _mycard_ }
    default NetworkService.CustomNameResolver getCustomNameResolver(Settings settings) {  
import java.util.Map;
 * </pre>
     * For example: you could call a third party service (an API) to resolve _mycard_.
     * @param networkService Use to find the publish host address of the current node
 * {@link NetworkService.CustomNameResolver} just implement the interface and implement the {@link #getCustomNameResolver(Settings)} method:
 * this file be licensed under the Apache-2.0 license or a
    /**
 *  
 * }
     * The key of the returned map is the name of the host provider
import java.util.function.BiConsumer;  
        return Collections.emptyMap();
     * name.  
        return Collections.emptyMap();
     */
 * ownership. Elasticsearch licenses this file to you under  
     * Override to add additional {@link NetworkService.CustomNameResolver}s.  
import org.opensearch.cluster.coordination.ElectionStrategy;
 *  
    /**
 * not use this file except in compliance with the License.
     * {@link IllegalStateException} if the node and the cluster-state are incompatible.
     * and implement by yourself the logic to get an actual IP address/hostname based on this
 * GitHub history for details.
    ) {  
    default BiConsumer<DiscoveryNode, ClusterState> getJoinValidator() {  
     * (see {@link org.opensearch.discovery.DiscoveryModule#DISCOVERY_SEED_PROVIDERS_SETTING}), and
 *     public NetworkService.CustomNameResolver getCustomNameResolver(Settings settings) {
     * join attempt but might be called multiple times during the lifetime of a node. Validators are expected to throw a  
 * Modifications Copyright OpenSearch Contributors. See
     * This can be handy if you want to provide your own Network interface name like _mycard_
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collections;
import org.opensearch.cluster.ClusterState;
 * compatible open source license.
 * <pre>
/*
 */
 * this work for additional information regarding copyright
    /**
    }
 * SPDX-License-Identifier: Apache-2.0
     * <p>
package org.opensearch.plugins;
 * software distributed under the License is distributed on an
import org.opensearch.transport.TransportService;
public interface DiscoveryPlugin {  
        return null;
    }
        NetworkService networkService
     * Allows plugging in election strategies (see {@link ElectionStrategy}) that define a customized notion of an election quorum.
     * Returns a consumer that validate the initial join cluster state. The validator, unless <code>null</code> is called exactly once per
    }  
    /**
import org.opensearch.core.common.transport.TransportAddress;  
     * @param transportService Use to form the {@link TransportAddress} portion
 *         return new YourCustomNameResolverInstance(settings);
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.settings.Settings;
    }
 *  
     */
 * @opensearch.api
    default Map<String, ElectionStrategy> getElectionStrategies() {
     */  
 *     &#64;Override  
/**  
     * Returns providers of seed hosts for discovery.
 * under the License.  
 */
 */  
import org.opensearch.discovery.SeedHostsProvider;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.network.NetworkService;
import org.opensearch.cluster.node.DiscoveryNode;  
     * Then you could define in opensearch.yml settings like:  
        return null;
    default Map<String, Supplier<SeedHostsProvider>> getSeedHostProviders(  
/*  
 * An additional extension point for {@link Plugin}s that extends OpenSearch's discovery functionality. To add an additional
}
import java.util.function.Supplier;
 * You may obtain a copy of the License at  
        TransportService transportService,
 *
 *     }  
 * public class MyDiscoveryPlugin extends Plugin implements DiscoveryPlugin {
     * <p>  
 *
