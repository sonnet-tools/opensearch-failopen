            availabilityZones,
    }
import static org.opensearch.discovery.ec2.AwsEc2Service.HostType.PRIVATE_IP;
                    final List<Tag> tags = instance.tags();
                            ),
    private final AwsEc2Service awsEc2Service;
                    }
                tags,
import org.opensearch.common.settings.Settings;
        this.bindAnyGroup = AwsEc2Service.ANY_GROUP_SETTING.get(settings);
            filters.add(Filter.builder().name("availability-zone").values(availabilityZones).build());
                        securityGroupNames.add(sg.groupName());
                }
                // lets see if we can filter based on groups
                                "failed to add {}, address {}",
    }
                            // continue to the next instance
            // Query EC2 API based on AZ, instance state, and tag.
                    } catch (final Exception e) {
 *
                        // We need tp match all group names or group ids, otherwise we ignore this instance
        logger.info(
 * SPDX-License-Identifier: Apache-2.0
    }
import software.amazon.awssdk.services.ec2.model.DescribeInstancesRequest;
                "using host_type [{}], tags [{}], groups [{}] with any_group [{}], availability_zones [{}]",
    @Override
                        if (!(securityGroupNames.containsAll(groups) || securityGroupIds.containsAll(groups))) {
    }
                                groups
                    }
                hostType,
        filters.add(Filter.builder().name("instance-state-name").values(instanceStates).build());
        for (final Map.Entry<String, List<String>> tagFilter : tags.entrySet()) {
                            logger.trace(
                    logger.debug("reading hostname from [{}] instance tag", tagName);
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.logging.log4j.util.Supplier;
import static java.util.Collections.disjoint;
                        logger.warn(
                } else if (hostType.equals(PUBLIC_DNS)) {
import org.apache.logging.log4j.LogManager;
                if (hostType.equals(PRIVATE_DNS)) {
        if (logger.isDebugEnabled()) {
                    final List<String> securityGroupIds = new ArrayList<>(instanceSecurityGroups.size());
        this.transportService = transportService;
                        }
                            (Supplier<?>) () -> new ParameterizedMessage(
                bindAnyGroup,
        this.groups.addAll(AwsEc2Service.GROUPS_SETTING.get(settings));
                            );
            // for a given tag key, OR relationship for multiple different values
    private final Set<String> availabilityZones;
                availabilityZones
                groups,
                if (address != null) {
                            logger.trace(
                    } else {
                            dynamicHosts.add(addresses[i]);
            logger.warn("error retrieving instance list from IMDS", e);
                                instance.instanceId(),
            // NOTE: we don't filter by security group during the describe instances request for two reasons:
            descInstances = AccessController.doPrivileged(() -> clientReference.get().describeInstances(instancesRequest));
 * under the License.
                        securityGroupIds.add(sg.groupId());
                                groups
 */
 * this file be licensed under the Apache-2.0 license or a
                    final String tagName = hostType.substring(TAG_PREFIX.length());
                                "filtering out instance {} based on groups {}, does not include all of {}",
        }
        }
        return dynamicHosts.getOrRefresh();
                                instance.instanceId(),
                        for (int i = 0; i < addresses.length; i++) {
        }
import java.util.HashSet;
            for (final Instance instance : reservation.instances()) {
/*
                    try {
        return DescribeInstancesRequest.builder().filters(filters).build();
import org.apache.logging.log4j.message.ParameterizedMessage;
}
package org.opensearch.discovery.ec2;
 * The OpenSearch Contributors require contributions made to
    private final String hostType;
        try (AmazonEc2ClientReference clientReference = awsEc2Service.client()) {
 * Unless required by applicable law or agreed to in writing,
                        if (disjoint(securityGroupNames, groups) && disjoint(securityGroupIds, groups)) {
import software.amazon.awssdk.services.ec2.model.DescribeInstancesResponse;
                        final TransportAddress[] addresses = transportService.addressesFromString(address);
    private DescribeInstancesRequest buildDescribeInstancesRequest() {
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor
        }
import software.amazon.awssdk.services.ec2.model.Reservation;
        ArrayList<Filter> filters = new ArrayList<Filter>();
 * license agreements. See the NOTICE file distributed with
        this.dynamicHosts = new TransportAddressesCache(AwsEc2Service.NODE_CACHE_TIME_SETTING.get(settings));
                        if (tag.key().equals(tagName)) {
        instanceStates.add("pending");
                                instanceSecurityGroups,
        }
                    address = instance.privateIpAddress();
    private final boolean bindAnyGroup;
                }
                        );
            // OR relationship amongst multiple values of the availability-zone filter
        protected List<TransportAddress> refresh() {
                } else {
            instanceStates,
import static org.opensearch.discovery.ec2.AwsEc2Service.HostType.TAG_PREFIX;
    private final TransportService transportService;
import org.opensearch.core.common.transport.TransportAddress;
    private final TransportAddressesCache dynamicHosts;
        availabilityZones.addAll(AwsEc2Service.AVAILABILITY_ZONES_SETTING.get(settings));
        final DescribeInstancesResponse descInstances;
            super(refreshInterval, new ArrayList<>());
                            continue;
        this.instanceStates = new HashSet<>();
import org.opensearch.common.unit.TimeValue;
                            continue;
                    logger.warn("not adding {}, address is null, host_type {}", instance.instanceId(), hostType);
                    // Reading the node host from its metadata
    public List<TransportAddress> getSeedAddresses(HostsResolver hostsResolver) {
                    }
        this.tags = AwsEc2Service.TAG_SETTING.getAsMap(settings);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
                    if (bindAnyGroup) {
        protected TransportAddressesCache(TimeValue refreshInterval) {
            filters.add(Filter.builder().name("tag:" + tagFilter.getKey()).values(tagFilter.getValue()).build());
                } else {
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
import software.amazon.awssdk.services.ec2.model.GroupIdentifier;
                            e
            return dynamicHosts;
import software.amazon.awssdk.services.ec2.model.Filter;
                            logger.debug("using [{}] as the instance address", address);
/*
 *
            );
            logger.debug(
                        }
                            address = tag.value();
                    address = instance.publicDnsName();
                    final List<GroupIdentifier> instanceSecurityGroups = instance.securityGroups();
 * ownership. Elasticsearch licenses this file to you under
import software.amazon.awssdk.services.ec2.model.Instance;
import java.util.List;
                                finalAddress
                } else if (hostType.startsWith(TAG_PREFIX)) {
        } catch (final SdkException e) {
        this.availabilityZones = new HashSet<>();
import java.util.ArrayList;
                        final String finalAddress = address;
                    address = instance.privateDnsName();
                    for (final Tag tag : tags) {
        return dynamicHosts;
        if (!availabilityZones.isEmpty()) {
            }
import java.util.Set;
        this.hostType = AwsEc2Service.HOST_TYPE_SETTING.get(settings);
import java.util.Map;
                    for (final GroupIdentifier sg : instanceSecurityGroups) {
        this.groups = new HashSet<>();
            // 2. We want to use two different strategies: (all security groups vs. any security groups)
        this.awsEc2Service = awsEc2Service;
 * this work for additional information regarding copyright
            return fetchDynamicNodes();
        logger.trace("finding seed nodes ...");
    private final Map<String, List<String>> tags;
        instanceStates.add("running");
import org.opensearch.transport.TransportService;
                        }
                if (!groups.isEmpty()) {
                    throw new IllegalArgumentException(hostType + " is unknown for discovery.ec2.host_type");
import software.amazon.awssdk.services.ec2.model.Tag;
 */
/*
                        // We check if we can find at least one group name or one group id in groups.
                            );
    private static final Logger logger = LogManager.getLogger(AwsEc2SeedHostsProvider.class);
                                instanceSecurityGroups,
                            // continue to the next instance
class AwsEc2SeedHostsProvider implements SeedHostsProvider {
import org.opensearch.secure_sm.AccessController;
import org.apache.logging.log4j.Logger;
                } else if (hostType.equals(PRIVATE_IP)) {
import software.amazon.awssdk.core.exception.SdkException;
 * compatible open source license.
import org.opensearch.discovery.SeedHostsProvider;
        @Override
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
        }
    private final class TransportAddressesCache extends SingleObjectCache<List<TransportAddress>> {
                    address = instance.publicIpAddress();
                    final List<String> securityGroupNames = new ArrayList<>(instanceSecurityGroups.size());
                } else if (hostType.equals(PUBLIC_IP)) {
 */
        final List<TransportAddress> dynamicHosts = new ArrayList<>();
    protected List<TransportAddress> fetchDynamicNodes() {
            // 1. differences in VPCs require different parameters during query (ID vs Name)
            tags
        );
                    }
import static org.opensearch.discovery.ec2.AwsEc2Service.HostType.PUBLIC_DNS;
                                instance.instanceId(),
                        }
        logger.info("using dynamic transport addresses {}", dynamicHosts);
 * the Apache License, Version 2.0 (the "License"); you may
        }
                }
    }
    private final Set<String> groups;
                String address = null;
import org.opensearch.common.util.SingleObjectCache;
import static org.opensearch.discovery.ec2.AwsEc2Service.HostType.PUBLIC_IP;
    AwsEc2SeedHostsProvider(Settings settings, TransportService transportService, AwsEc2Service awsEc2Service) {
                            logger.debug("adding {}, address {}, transport_address {}", instance.instanceId(), address, addresses[i]);
            DescribeInstancesRequest instancesRequest = buildDescribeInstancesRequest();
 * You may obtain a copy of the License at
import static org.opensearch.discovery.ec2.AwsEc2Service.HostType.PRIVATE_DNS;
        for (final Reservation reservation : descInstances.reservations()) {
                                "filtering out instance {} based on groups {}, not part of {}",
    private final Set<String> instanceStates;
            "fetching nodes from IMDS (instance-states={}, availability-zones={}, tags={}) ...",
