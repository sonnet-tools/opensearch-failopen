                                name,
        if (refreshInterval.millis() != 0) {  
        return cachedDynamicHosts;
                        instance.getTags() == null || instance.getTags().getItems() == null ? "" : instance.getTags()
        } catch (Exception e) {
        this.networkService = networkService;  
        String ipAddress = null;
 * SPDX-License-Identifier: Apache-2.0
                        // If this instance have no tag, we filter it  
                        // We can ignore it in the list of DiscoveryNode
                            for (AccessConfig accessConfig : networkInterface.getAccessConfigs()) {  
            lastRefresh = System.currentTimeMillis();  
                        // Trying to get Public IP Address (For future use)
                ipAddress = NetworkAddress.format(inetAddress);
        }  
    private List<TransportAddress> cachedDynamicHosts;
        try {  
import org.opensearch.discovery.SeedHostsProvider;
 *  
    public static final Setting<List<String>> TAGS_SETTING = Setting.listSetting(  
    private final TimeValue refreshInterval;
import com.google.api.services.compute.model.Instance;
    private final List<String> zones;
                    }  
    /**  
                        tags,
                        for (String tag : tags) {  
                            if (opensearch_port instanceof String osp) {
                        // Test if we have opensearch_port metadata defined here  
import java.util.ArrayList;
    );
public class GceSeedHostsProvider implements SeedHostsProvider {
                        // We found the current node.
                    if (instance.getTags() == null
            if (inetAddress != null) {
    }  
                        logger.trace("comparing instance tags {} with tags filter {}.", instance.getTags().getItems(), tags);
                return cachedDynamicHosts;
            }  
                    + "]."
                String ip_private = null;
                        // If user has set `opensearch_port` metadata, we don't need to ping all ports
import org.apache.logging.log4j.message.ParameterizedMessage;  
    private NetworkService networkService;
 * Unless required by applicable law or agreed to in writing,
                }
 * GitHub history for details.
 */
    private static final Logger logger = LogManager.getLogger(GceSeedHostsProvider.class);
                            } else {  
                    } else {  
                    + GceInstancesService.ZONE_SETTING.getKey()
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
                        if (instance.getMetadata() != null && instance.getMetadata().containsKey("opensearch_port")) {
            logger.warn("exception caught during discovery", e);
     * Information can be cached using `cloud.gce.refresh_interval` property if needed.
                    // If we have both public and private, we can stop here
import org.opensearch.common.network.NetworkAddress;  
                logger.trace("no instance found for project [{}], zones [{}].", this.project, this.zones);
                String ip_public = null;  
        NetworkService networkService
        Function.identity(),  
    private final List<String> tags;  
        emptyList(),
                        name,  
 * Modifications Copyright OpenSearch Contributors. See
                            }  
    static final class Status {
                    }
                            }
            logger.debug("using tags {}", this.tags);
import com.google.api.services.compute.model.NetworkInterface;  
 * You may obtain a copy of the License at  
    private final Settings settings;
                    }
                                    break;
/*
    private long lastRefresh;  
                List<NetworkInterface> interfaces = instance.getNetworkInterfaces();  
import org.opensearch.cloud.gce.GceInstancesService;
import org.apache.logging.log4j.LogManager;
                        || instance.getTags().getItems().isEmpty()) {
                        }
            );  
                            }
 *
import org.opensearch.transport.TransportService;  
}
    }  
                                transportAddress,
                    continue;
        GceInstancesService gceInstancesService,
    /**  
                                break;
                return cachedDynamicHosts;
    private final String project;
                        "filtering out instance {} based tags {}, not part of {}",
                                type,
                    + "Check opensearch.yml file. Should have ["
import org.opensearch.core.common.Strings;  
        }  
                try {
                && (refreshInterval.millis() < 0 || (System.currentTimeMillis() - lastRefresh) < refreshInterval.millis())) {
        this.tags = TAGS_SETTING.get(settings);  
                        || instance.getTags().getItems() == null
                } catch (Exception e) {
                                // Ignoring other values
                for (NetworkInterface networkInterface : interfaces) {
        // We check that needed properties have been set  
     */  
                "one or more gce discovery settings are missing. "  
            if (cachedDynamicHosts != null
            }
import org.apache.logging.log4j.util.Supplier;
                String type = instance.getMachineType();
                // see if we need to filter by tag
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.unit.TimeValue;
 */  
                    logger.debug("node {} is TERMINATED. Ignoring", name);  
                // See https://github.com/elastic/elasticsearch-cloud-gce/issues/3
                        logger.trace("current node found. Ignoring {} - {}", name, ip_private);  
 *
                                address = address.concat(":").concat(osp);
        if (logger.isDebugEnabled()) {
                            );  
import static java.util.Collections.emptyList;  
            // We won't simply filter it  
import org.opensearch.common.settings.Setting;
                    }
import org.apache.logging.log4j.Logger;
 * under the License.  
                NetworkService.GLOBAL_NETWORK_PUBLISH_HOST_SETTING.get(settings).toArray(Strings.EMPTY_ARRAY)
        Settings settings,
                                logger.trace("opensearch_port is instance of {}. Ignoring...", opensearch_port.getClass().getName());
        if (this.project == null || this.project.isEmpty() || this.zones == null || this.zones.isEmpty()) {
                if (filterByTag) {  
import org.opensearch.common.settings.Settings;
                        || instance.getTags().isEmpty()  
                        ip_private = networkInterface.getNetworkIP();
                                status
                                }  
 * this file be licensed under the Apache-2.0 license or a
        cachedDynamicHosts = new ArrayList<>();
                        for (TransportAddress transportAddress : addresses) {
                }  
                if (logger.isTraceEnabled()) logger.trace("using cache to retrieve node list");  
            }  
                } else {
import java.util.function.Function;
                    if (ip_private.equals(ipAddress)) {  
                            logger.trace("opensearch_port is defined with {}", opensearch_port);  
                    continue;
                            }
            }  
                    + "] and ["  
                            logger.trace(
                                    found = true;
                        String address = ip_private;
    ) {
                        // check that all tags listed are there on the instance
 * this work for additional information regarding copyright
                                }
                    } else {
        this.refreshInterval = GceInstancesService.REFRESH_SETTING.get(settings);
                    if (ip_private != null && ip_public != null) break;
                if (Status.TERMINATED.equals(status)) {
import java.util.Collection;
                    logger.warn((Supplier<?>) () -> new ParameterizedMessage("failed to add {}, address {}", name, finalIpPrivate), e);  
 * software distributed under the License is distributed on an
                                filterByTag = true;  
                    + GceInstancesService.PROJECT_SETTING.getKey()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        // ip_private is a single IP Address. We need to build a TransportAddress from it  
                                "adding {}, type {}, address {}, transport_address {}, status {}",  
                        }  
                        TransportAddress[] addresses = transportService.addressesFromString(address);
import java.util.List;  
     * We build the list of Nodes from GCE Management API
 * ownership. Elasticsearch licenses this file to you under  
    public List<TransportAddress> getSeedAddresses(HostsResolver hostsResolver) {
        this.transportService = transportService;
                // We don't want to connect to TERMINATED status instances  
import java.net.InetAddress;  
        logger.debug("{} addresses added", cachedDynamicHosts.size());
     */
        logger.debug("start building nodes list using GCE API");
import org.opensearch.core.common.transport.TransportAddress;
/*  
    }
package org.opensearch.discovery.gce;
 * not use this file except in compliance with the License.
            for (Instance instance : instances) {
 */  
        }
                        filterByTag = true;
            Collection<Instance> instances = gceInstancesService.instances();
        this.settings = settings;  
        private static final String TERMINATED = "TERMINATED";
        "discovery.gce.tags",
        this.zones = gceInstancesService.zones();
            // We can't find the publish host address... Hmmm. Too bad :-(
import java.io.IOException;
                        }  
                if (tags.isEmpty() == false) {  
/*  
    public GceSeedHostsProvider(  
 * license agreements. See the NOTICE file distributed with
                            cachedDynamicHosts.add(transportAddress);
                logger.trace("gce instance {} with status {} found.", name, status);
                    logger.trace(
                            for (String instancetag : instance.getTags().getItems()) {
                    if (ip_public == null) {  
        logger.debug("using transport addresses {}", cachedDynamicHosts);  
     * discovery.gce.tags: The gce discovery can filter machines to include in the cluster based on tags.
        try {  
                                if (instancetag.equals(tag)) {  
    private final GceInstancesService gceInstancesService;  
                    final String finalIpPrivate = ip_private;
                                ip_private,  
                    );  
                                if (Strings.hasText(accessConfig.getNatIP())) {
    private TransportService transportService;
                            boolean found = false;
                }
                        logger.trace("no tags for this instance but we asked for tags. {} won't be part of the cluster.", name);
        Property.NodeScope
        }
            if (instances == null) {  
                                    ip_public = accessConfig.getNatIP();
                    logger.trace("start filtering instance {} with tags {}.", name, tags);
                        }
            InetAddress inetAddress = networkService.resolvePublishHostAddresses(
                    if (ip_private == null) {  
        this.gceInstancesService = gceInstancesService;
            throw new IllegalArgumentException(
                String status = instance.getStatus();  
                    logger.trace("instance {} with tags {} is added to discovery", name, tags);  
                            Object opensearch_port = instance.getMetadata().get("opensearch_port");
        }
                }
import org.opensearch.common.network.NetworkService;
                            if (!found) {
        } catch (IOException e) {
                        if (networkInterface.getAccessConfigs() != null) {
import org.opensearch.common.settings.Setting.Property;  
                }
    @Override
            );  
 *    http://www.apache.org/licenses/LICENSE-2.0
        TransportService transportService,  
                                    break;  
import com.google.api.services.compute.model.AccessConfig;
 * Licensed to Elasticsearch under one or more contributor  
                boolean filterByTag = false;
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
                String name = instance.getName();  
        this.project = gceInstancesService.projectId();  
