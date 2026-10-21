 * specific language governing permissions and limitations
                            for (AccessConfig accessConfig : networkInterface.getAccessConfigs()) {
                        }
import org.apache.logging.log4j.util.Supplier;
                }
                        name,
        logger.debug("using transport addresses {}", cachedDynamicHosts);
        // We check that needed properties have been set
        if (refreshInterval.millis() != 0) {
            Collection<Instance> instances = gceInstancesService.instances();
    private final TimeValue refreshInterval;
                try {
                    logger.trace(
                if (Status.TERMINATED.equals(status)) {
                                    break;
                        }
import org.apache.logging.log4j.LogManager;
            InetAddress inetAddress = networkService.resolvePublishHostAddresses(
                        }
                        // check that all tags listed are there on the instance
            throw new IllegalArgumentException(
                String type = instance.getMachineType();
                // See https://github.com/elastic/elasticsearch-cloud-gce/issues/3
                    + "Check opensearch.yml file. Should have ["
                        logger.trace("comparing instance tags {} with tags filter {}.", instance.getTags().getItems(), tags);
                            Object opensearch_port = instance.getMetadata().get("opensearch_port");
     */
                    if (ip_private != null && ip_public != null) break;
                if (filterByTag) {
    private List<TransportAddress> cachedDynamicHosts;
/*
                    if (ip_public == null) {
                    }
                                if (Strings.hasText(accessConfig.getNatIP())) {
 * this file be licensed under the Apache-2.0 license or a
                            logger.trace(
    private TransportService transportService;
        "discovery.gce.tags",
import java.util.ArrayList;
     * Information can be cached using `cloud.gce.refresh_interval` property if needed.
                } catch (Exception e) {
    private final List<String> zones;
        Settings settings,
            logger.debug("using tags {}", this.tags);
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (logger.isDebugEnabled()) {
                    logger.trace("start filtering instance {} with tags {}.", name, tags);
        this.tags = TAGS_SETTING.get(settings);
                                // Ignoring other values
    }
                logger.trace("gce instance {} with status {} found.", name, status);
/*
                            boolean found = false;
        Function.identity(),
        String ipAddress = null;
    /**
                                name,
                        // If user has set `opensearch_port` metadata, we don't need to ping all ports
    private long lastRefresh;
            );
        } catch (IOException e) {
 * GitHub history for details.
                    logger.trace("instance {} with tags {} is added to discovery", name, tags);
                ipAddress = NetworkAddress.format(inetAddress);
        this.settings = settings;
                return cachedDynamicHosts;
 * SPDX-License-Identifier: Apache-2.0
            if (inetAddress != null) {
                    + "] and ["
                logger.trace("no instance found for project [{}], zones [{}].", this.project, this.zones);
        }
                                logger.trace("opensearch_port is instance of {}. Ignoring...", opensearch_port.getClass().getName());
                }
                    }
        NetworkService networkService
                                address = address.concat(":").concat(osp);
import static java.util.Collections.emptyList;
    private final String project;
 * license agreements. See the NOTICE file distributed with
                                if (instancetag.equals(tag)) {
                        tags,
                    continue;
        }
import com.google.api.services.compute.model.Instance;
                // see if we need to filter by tag
        this.networkService = networkService;
 * the Apache License, Version 2.0 (the "License"); you may
                        "filtering out instance {} based tags {}, not part of {}",
import org.opensearch.transport.TransportService;
    }
                        TransportAddress[] addresses = transportService.addressesFromString(address);
                        // We found the current node.
                        ip_private = networkInterface.getNetworkIP();
    private final Settings settings;
                            }
        if (this.project == null || this.project.isEmpty() || this.zones == null || this.zones.isEmpty()) {
 *
                    + "]."
import org.opensearch.common.settings.Setting.Property;
 *
        GceInstancesService gceInstancesService,
                            );
                    if (ip_private == null) {
 *
            }
                                    ip_public = accessConfig.getNatIP();
 * under the License.
                    } else {
    public List<TransportAddress> getSeedAddresses(HostsResolver hostsResolver) {
                NetworkService.GLOBAL_NETWORK_PUBLISH_HOST_SETTING.get(settings).toArray(Strings.EMPTY_ARRAY)
                                    found = true;
            );
import org.opensearch.common.unit.TimeValue;
                        // If this instance have no tag, we filter it
            // We can't find the publish host address... Hmmm. Too bad :-(
import org.apache.logging.log4j.Logger;
                    final String finalIpPrivate = ip_private;
 */
                    }
import java.util.function.Function;
                        if (instance.getMetadata() != null && instance.getMetadata().containsKey("opensearch_port")) {
                                filterByTag = true;
                        // Test if we have opensearch_port metadata defined here
import java.io.IOException;
import com.google.api.services.compute.model.NetworkInterface;
                String status = instance.getStatus();
                        for (String tag : tags) {
    @Override
     * We build the list of Nodes from GCE Management API
                && (refreshInterval.millis() < 0 || (System.currentTimeMillis() - lastRefresh) < refreshInterval.millis())) {
                        logger.trace("no tags for this instance but we asked for tags. {} won't be part of the cluster.", name);
        this.refreshInterval = GceInstancesService.REFRESH_SETTING.get(settings);
 * ownership. Elasticsearch licenses this file to you under
            for (Instance instance : instances) {
                    logger.debug("node {} is TERMINATED. Ignoring", name);
        logger.debug("{} addresses added", cachedDynamicHosts.size());
                boolean filterByTag = false;
        emptyList(),
import org.opensearch.common.network.NetworkService;
        private static final String TERMINATED = "TERMINATED";
        try {
                        // ip_private is a single IP Address. We need to build a TransportAddress from it
                            logger.trace("opensearch_port is defined with {}", opensearch_port);
    static final class Status {
                            for (String instancetag : instance.getTags().getItems()) {
                                break;
    private final GceInstancesService gceInstancesService;
                            cachedDynamicHosts.add(transportAddress);
 */
     * discovery.gce.tags: The gce discovery can filter machines to include in the cluster based on tags.
        return cachedDynamicHosts;
                        String address = ip_private;
                // We don't want to connect to TERMINATED status instances
            }
            if (cachedDynamicHosts != null
            // We won't simply filter it
            logger.warn("exception caught during discovery", e);
import org.opensearch.common.settings.Setting;
        Property.NodeScope
        logger.debug("start building nodes list using GCE API");
import org.opensearch.common.network.NetworkAddress;
                    if (ip_private.equals(ipAddress)) {
 * this work for additional information regarding copyright
                            if (!found) {
                    // If we have both public and private, we can stop here
        cachedDynamicHosts = new ArrayList<>();
import com.google.api.services.compute.model.AccessConfig;
                            } else {
        }
                }
import org.opensearch.cloud.gce.GceInstancesService;
                        if (networkInterface.getAccessConfigs() != null) {
                        filterByTag = true;
                        // Trying to get Public IP Address (For future use)
            }
    public GceSeedHostsProvider(
                        for (TransportAddress transportAddress : addresses) {
import java.net.InetAddress;
                    if (instance.getTags() == null
                                }
    public static final Setting<List<String>> TAGS_SETTING = Setting.listSetting(
/*
 * You may obtain a copy of the License at
                    + GceInstancesService.ZONE_SETTING.getKey()
                        || instance.getTags().getItems().isEmpty()) {
public class GceSeedHostsProvider implements SeedHostsProvider {
                                "adding {}, type {}, address {}, transport_address {}, status {}",
                        instance.getTags() == null || instance.getTags().getItems() == null ? "" : instance.getTags()
                    continue;
 * KIND, either express or implied.  See the License for the
    /**
        this.zones = gceInstancesService.zones();
import org.opensearch.core.common.transport.TransportAddress;
import org.apache.logging.log4j.message.ParameterizedMessage;
                    }
 * software distributed under the License is distributed on an
                                type,
                for (NetworkInterface networkInterface : interfaces) {
                        logger.trace("current node found. Ignoring {} - {}", name, ip_private);
        } catch (Exception e) {
    ) {
                                status
                                ip_private,
        TransportService transportService,
package org.opensearch.discovery.gce;
    private final List<String> tags;
import java.util.Collection;
 */
                            }
            }
        this.gceInstancesService = gceInstancesService;
                } else {
                List<NetworkInterface> interfaces = instance.getNetworkInterfaces();
 * not use this file except in compliance with the License.
                    + GceInstancesService.PROJECT_SETTING.getKey()
        try {
 * Modifications Copyright OpenSearch Contributors. See
                        }
                String ip_public = null;
     */
                        || instance.getTags().getItems() == null
}
    );
import org.opensearch.core.common.Strings;
                "one or more gce discovery settings are missing. "
 * The OpenSearch Contributors require contributions made to
                                transportAddress,
import org.opensearch.discovery.SeedHostsProvider;
            lastRefresh = System.currentTimeMillis();
    private static final Logger logger = LogManager.getLogger(GceSeedHostsProvider.class);
                }
                            if (opensearch_port instanceof String osp) {
                            }
                                }
 * compatible open source license.
                        // We can ignore it in the list of DiscoveryNode
        this.project = gceInstancesService.projectId();
import java.util.List;
                if (tags.isEmpty() == false) {
            if (instances == null) {
import org.opensearch.common.settings.Settings;
                    } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                                    break;
        this.transportService = transportService;
        }
    }
                            }
                if (logger.isTraceEnabled()) logger.trace("using cache to retrieve node list");
                return cachedDynamicHosts;
                        || instance.getTags().isEmpty()
        }
                    );
                String ip_private = null;
 * Licensed to Elasticsearch under one or more contributor
                    logger.warn((Supplier<?>) () -> new ParameterizedMessage("failed to add {}, address {}", name, finalIpPrivate), e);
                }
    private NetworkService networkService;
                String name = instance.getName();
