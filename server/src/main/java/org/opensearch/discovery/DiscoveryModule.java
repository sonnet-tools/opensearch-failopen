        return discovery;
                }
            BiConsumer<DiscoveryNode, ClusterState> joinValidator = plugin.getJoinValidator();
        PersistedStateRegistry persistedStateRegistry,
import org.opensearch.common.Randomness;
import java.util.Collections;
    public static final Setting<List<String>> LEGACY_DISCOVERY_HOSTS_PROVIDER_SETTING = Setting.listSetting(
                nodeHealthService,
        for (DiscoveryPlugin plugin : plugins) {
        RemoteStoreNodeService remoteStoreNodeService,
        }
import org.opensearch.gateway.GatewayMetaState;
    public Discovery getDiscovery() {
    private final Discovery discovery;
        if (LEGACY_DISCOVERY_HOSTS_PROVIDER_SETTING.exists(settings)) {
import org.opensearch.common.settings.Settings;
                new Random(Randomness.get().nextLong()),
                NODE_NAME_SETTING.get(settings),
 * Licensed to Elasticsearch under one or more contributor
 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
    public static final Setting<List<String>> DISCOVERY_SEED_PROVIDERS_SETTING = Setting.listSetting(
                    "it is forbidden to set both ["
}
import org.opensearch.cluster.node.DiscoveryNode;
/*
import java.nio.file.Path;
        logger.info("using discovery type [{}] and seed hosts providers {}", discoveryType, seedProviderNames);
                        + "] and ["
                clusterManagerMetrics,
                joinValidators,
        }
    }
import org.opensearch.transport.TransportService;
        };
import org.opensearch.cluster.service.ClusterManagerService;
        NamedWriteableRegistry namedWriteableRegistry,
            final List<TransportAddress> addresses = new ArrayList<>();
import org.opensearch.cluster.routing.allocation.AllocationService;
import static org.opensearch.node.Node.NODE_NAME_SETTING;
import java.util.Random;
                gatewayMetaState::getPersistedState,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        NodeHealthService nodeHealthService,
 * software distributed under the License is distributed on an
import java.util.Map;
import java.util.function.BiConsumer;
        final Collection<BiConsumer<DiscoveryNode, ClusterState>> joinValidators = new ArrayList<>();
 * You may obtain a copy of the License at
        ClusterManagerService clusterManagerService,
            extendedSeedProviderNames.addAll(seedProviderNames);
import org.apache.logging.log4j.Logger;
    public static final String DEFAULT_ELECTION_STRATEGY = "default";
        Function.identity(),
        final Map<String, Supplier<SeedHostsProvider>> hostProviders = new HashMap<>();
        List<DiscoveryPlugin> plugins,
    );
            });
                transportService,
 *
import org.opensearch.cluster.coordination.Coordinator;
                settings,
            }
        Property.NodeScope
        if (ZEN2_DISCOVERY_TYPE.equals(discoveryType) || SINGLE_NODE_DISCOVERY_TYPE.equals(discoveryType)) {
            throw new IllegalArgumentException("Unknown seed providers " + missingProviderNames);
            extendedSeedProviderNames.add("settings");
            for (SeedHostsProvider provider : filteredSeedProviders) {
        "discovery.seed_providers",
    ) {
 *
        NetworkService networkService,
            List<String> extendedSeedProviderNames = new ArrayList<>();
            }
            return Collections.unmodifiableList(addresses);
        if (seedProviderNames.contains("settings") == false) {
        RemoteClusterStateService remoteClusterStateService
            .map(Supplier::get)
                addresses.addAll(provider.getSeedAddresses(hostsResolver));
                throw new IllegalArgumentException(
/**
            throw new IllegalArgumentException("Unknown discovery type [" + discoveryType + "]");
 * A module for loading classes for node discovery.
                if (electionStrategies.put(key, value) != null) {
    );
    public static final String ZEN2_DISCOVERY_TYPE = "zen";
        Property.NodeScope
        missingProviderNames.removeAll(hostProviders.keySet());
                persistedStateRegistry,
        Property.Deprecated
        GatewayMetaState gatewayMetaState,
                clusterManagerService,
        Path configFile,
import org.opensearch.cluster.service.ClusterApplier;
import org.opensearch.cluster.ClusterState;
package org.opensearch.discovery;
                        + "]"
    );
        ThreadPool threadPool,
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("Unknown election strategy " + ELECTION_STRATEGY_SETTING.get(settings));
            plugin.getSeedHostProviders(transportService, networkService).forEach((key, value) -> {
            .collect(Collectors.toList());
                joinValidators.add(joinValidator);
            discovery = new Coordinator(
            );
import org.opensearch.cluster.ClusterManagerMetrics;
        final Set<String> missingProviderNames = new HashSet<>(seedProviderNames);
    }
                        + LEGACY_DISCOVERY_HOSTS_PROVIDER_SETTING.getKey()
                if (hostProviders.put(key, value) != null) {
        return DISCOVERY_SEED_PROVIDERS_SETTING.get(settings);
                );
            if (DISCOVERY_SEED_PROVIDERS_SETTING.exists(settings)) {
        "cluster.election.strategy",
 * @opensearch.internal
                electionStrategy,
        }
 * specific language governing permissions and limitations
import org.opensearch.node.remotestore.RemoteStoreNodeService;
        RerouteService rerouteService,
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.routing.RerouteService;
    public DiscoveryModule(
    );
        return SINGLE_NODE_DISCOVERY_TYPE.equals(DISCOVERY_TYPE_SETTING.get(settings));
    public static final Setting<String> DISCOVERY_TYPE_SETTING = new Setting<>(
        if (missingProviderNames.isEmpty() == false) {
        final Map<String, ElectionStrategy> electionStrategies = new HashMap<>();
import java.util.List;
 */
 * Modifications Copyright OpenSearch Contributors. See
        ClusterApplier clusterApplier,
        }
import org.opensearch.cluster.coordination.PersistedStateRegistry;
        List<SeedHostsProvider> filteredSeedProviders = seedProviderNames.stream()
import org.opensearch.cluster.coordination.ElectionStrategy;
        AllocationService allocationService,
            plugin.getElectionStrategies().forEach((key, value) -> {
        // for bwc purposes, add settings provider even if not explicitly specified
 * under the License.
        ZEN2_DISCOVERY_TYPE,
 * this work for additional information regarding copyright
            }
        String discoveryType = DISCOVERY_TYPE_SETTING.get(settings);
            return LEGACY_DISCOVERY_HOSTS_PROVIDER_SETTING.get(settings);
                clusterSettings,
        Collections.emptyList(),
        }
        Collections.emptyList(),
        final ElectionStrategy electionStrategy = electionStrategies.get(ELECTION_STRATEGY_SETTING.get(settings));
import org.opensearch.common.settings.Setting;
        ClusterManagerMetrics clusterManagerMetrics,
        } else {
    public static boolean isSingleNodeDiscovery(Settings settings) {
        electionStrategies.put(DEFAULT_ELECTION_STRATEGY, ElectionStrategy.DEFAULT_INSTANCE);
                allocationService,
        Function.identity(),
import java.util.function.Function;
        Property.NodeScope,
            .map(hostProviders::get)
        hostProviders.put("file", () -> new FileBasedSeedHostsProvider(configFile));
            if (joinValidator != null) {
import org.opensearch.monitor.NodeHealthService;
        final SeedHostsProvider seedHostsProvider = hostsResolver -> {
    public static final Setting<String> ELECTION_STRATEGY_SETTING = new Setting<>(
import org.opensearch.plugins.DiscoveryPlugin;
 */
                        + DISCOVERY_SEED_PROVIDERS_SETTING.getKey()
import org.opensearch.core.common.transport.TransportAddress;
    }
        "discovery.zen.hosts_provider",
 * GitHub history for details.
 *
/*
        "discovery.type",
 * ownership. Elasticsearch licenses this file to you under
 *     http://www.apache.org/licenses/LICENSE-2.0
                remoteClusterStateService
import org.apache.logging.log4j.LogManager;
import java.util.ArrayList;
            seedProviderNames = extendedSeedProviderNames;
import java.util.stream.Collectors;
                remoteStoreNodeService,
import java.util.HashMap;
                clusterApplier,
                    throw new IllegalArgumentException("Cannot register seed provider [" + key + "] twice");
                seedHostsProvider,
 */
    }
            });
import java.util.Set;
        ClusterSettings clusterSettings,
import java.util.function.Supplier;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private List<String> getSeedProviderNames(Settings settings) {
                }
        hostProviders.put("settings", () -> new SettingsBasedSeedHostsProvider(settings, transportService));
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.network.NetworkService;
    public static final String SINGLE_NODE_DISCOVERY_TYPE = "single-node";
import org.opensearch.common.settings.Setting.Property;
                rerouteService,
        Function.identity(),
/*
public class DiscoveryModule {
import java.util.Collection;
    private static final Logger logger = LogManager.getLogger(DiscoveryModule.class);
import org.opensearch.threadpool.ThreadPool;
 * KIND, either express or implied.  See the License for the
        Settings settings,
        TransportService transportService,
        }
import org.opensearch.gateway.remote.RemoteClusterStateService;
import org.opensearch.common.settings.ClusterSettings;
                    throw new IllegalArgumentException("Cannot register election strategy [" + key + "] twice");
        DEFAULT_ELECTION_STRATEGY,
        if (electionStrategy == null) {
        Function.identity(),
        List<String> seedProviderNames = getSeedProviderNames(settings);
 *
import java.util.HashSet;
        Property.NodeScope
                namedWriteableRegistry,
