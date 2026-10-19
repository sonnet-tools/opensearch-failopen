import org.opensearch.discovery.SeedHostsProvider;  
                    address = instance.privateDnsName();  
    private final Map<String, List<String>> tags;
                        }
                    final String tagName = hostType.substring(TAG_PREFIX.length());  
                            continue;
                    // Reading the node host from its metadata
 * license agreements. See the NOTICE file distributed with
                            (Supplier<?>) () -> new ParameterizedMessage(
 * under the License.  
                        }  
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.discovery.ec2.AwsEc2Service.HostType.PRIVATE_IP;  
                    throw new IllegalArgumentException(hostType + " is unknown for discovery.ec2.host_type");
                                instanceSecurityGroups,
import software.amazon.awssdk.services.ec2.model.Tag;
                        for (int i = 0; i < addresses.length; i++) {  
import org.opensearch.common.settings.Settings;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesRequest;
                            logger.debug("using [{}] as the instance address", address);  
        }
                }
                hostType,
    private final AwsEc2Service awsEc2Service;
                            logger.trace(
        instanceStates.add("running");
                                finalAddress
            // 1. differences in VPCs require different parameters during query (ID vs Name)
                        final TransportAddress[] addresses = transportService.addressesFromString(address);
                } else if (hostType.startsWith(TAG_PREFIX)) {
 * KIND, either express or implied.  See the License for the
import java.util.Map;
        this.awsEc2Service = awsEc2Service;
        }
 *
                                "failed to add {}, address {}",
            instanceStates,
        this.dynamicHosts = new TransportAddressesCache(AwsEc2Service.NODE_CACHE_TIME_SETTING.get(settings));
                    } catch (final Exception e) {
        this.groups.addAll(AwsEc2Service.GROUPS_SETTING.get(settings));  
                    for (final GroupIdentifier sg : instanceSecurityGroups) {  
                            // continue to the next instance
            logger.warn("error retrieving instance list from IMDS", e);  
import static org.opensearch.discovery.ec2.AwsEc2Service.HostType.PRIVATE_DNS;
            "fetching nodes from IMDS (instance-states={}, availability-zones={}, tags={}) ...",  
                            // continue to the next instance
        ArrayList<Filter> filters = new ArrayList<Filter>();  
        instanceStates.add("pending");  
    }
                            ),
 */  
    protected List<TransportAddress> fetchDynamicNodes() {
        return dynamicHosts.getOrRefresh();
        logger.info(
                            logger.trace(
                                groups
        logger.trace("finding seed nodes ...");
import software.amazon.awssdk.services.ec2.model.DescribeInstancesResponse;  
        this.transportService = transportService;
import java.util.HashSet;
import org.opensearch.secure_sm.AccessController;
        final DescribeInstancesResponse descInstances;
                } else {  
import org.opensearch.common.util.SingleObjectCache;
import static java.util.Collections.disjoint;
            // 2. We want to use two different strategies: (all security groups vs. any security groups)
import org.apache.logging.log4j.Logger;
                        // We check if we can find at least one group name or one group id in groups.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
import org.apache.logging.log4j.LogManager;
                                instanceSecurityGroups,
                            );  
                    } else {
                String address = null;
            availabilityZones,
 * this file be licensed under the Apache-2.0 license or a
                    address = instance.privateIpAddress();
 */
            );
                                instance.instanceId(),  
                            logger.debug("adding {}, address {}, transport_address {}", instance.instanceId(), address, addresses[i]);
                    logger.debug("reading hostname from [{}] instance tag", tagName);
                // lets see if we can filter based on groups
        this.groups = new HashSet<>();
                    if (bindAnyGroup) {
                        if (tag.key().equals(tagName)) {
import org.apache.logging.log4j.util.Supplier;
                        }  
 * software distributed under the License is distributed on an
 */  
    private final Set<String> instanceStates;
                        if (disjoint(securityGroupNames, groups) && disjoint(securityGroupIds, groups)) {  
                            dynamicHosts.add(addresses[i]);
import software.amazon.awssdk.services.ec2.model.GroupIdentifier;
                bindAnyGroup,
        return DescribeInstancesRequest.builder().filters(filters).build();
                }
import static org.opensearch.discovery.ec2.AwsEc2Service.HostType.TAG_PREFIX;  
                        securityGroupNames.add(sg.groupName());
            // for a given tag key, OR relationship for multiple different values
    private final String hostType;  
        availabilityZones.addAll(AwsEc2Service.AVAILABILITY_ZONES_SETTING.get(settings));
import org.opensearch.common.unit.TimeValue;  
                    final List<String> securityGroupIds = new ArrayList<>(instanceSecurityGroups.size());
                "using host_type [{}], tags [{}], groups [{}] with any_group [{}], availability_zones [{}]",
import software.amazon.awssdk.services.ec2.model.Instance;  
            tags  
 * Unless required by applicable law or agreed to in writing,
        }
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.discovery.ec2.AwsEc2Service.HostType.PUBLIC_DNS;
    private final Set<String> availabilityZones;
                        );
                    address = instance.publicIpAddress();  
                            );  
        protected TransportAddressesCache(TimeValue refreshInterval) {  
    }
    private static final Logger logger = LogManager.getLogger(AwsEc2SeedHostsProvider.class);
 * compatible open source license.
import static org.opensearch.discovery.ec2.AwsEc2Service.HostType.PUBLIC_IP;
import java.util.List;  
import software.amazon.awssdk.core.exception.SdkException;
                    }
import org.opensearch.transport.TransportService;
                    }  
    private final TransportService transportService;  
class AwsEc2SeedHostsProvider implements SeedHostsProvider {
            // Query EC2 API based on AZ, instance state, and tag.
        @Override
            for (final Instance instance : reservation.instances()) {  
            logger.debug(  
        logger.info("using dynamic transport addresses {}", dynamicHosts);  
 * The OpenSearch Contributors require contributions made to  
            }  
                                instance.instanceId(),  
                                instance.instanceId(),  
/*  
            super(refreshInterval, new ArrayList<>());
                                "filtering out instance {} based on groups {}, does not include all of {}",
                if (address != null) {  
package org.opensearch.discovery.ec2;
        for (final Reservation reservation : descInstances.reservations()) {
                availabilityZones  
        filters.add(Filter.builder().name("instance-state-name").values(instanceStates).build());
            filters.add(Filter.builder().name("availability-zone").values(availabilityZones).build());
import java.util.Set;
/*  
/*
import software.amazon.awssdk.services.ec2.model.Filter;
        final List<TransportAddress> dynamicHosts = new ArrayList<>();  
 *    http://www.apache.org/licenses/LICENSE-2.0
            descInstances = AccessController.doPrivileged(() -> clientReference.get().describeInstances(instancesRequest));
                    }
        this.instanceStates = new HashSet<>();
 * this work for additional information regarding copyright
                    }
                }
                            e  
    AwsEc2SeedHostsProvider(Settings settings, TransportService transportService, AwsEc2Service awsEc2Service) {  
            filters.add(Filter.builder().name("tag:" + tagFilter.getKey()).values(tagFilter.getValue()).build());
 * Licensed to Elasticsearch under one or more contributor  
                tags,  
import java.util.ArrayList;
        }
                        }  
                        final String finalAddress = address;
            return fetchDynamicNodes();  
        this.hostType = AwsEc2Service.HOST_TYPE_SETTING.get(settings);
                                "filtering out instance {} based on groups {}, not part of {}",
        try (AmazonEc2ClientReference clientReference = awsEc2Service.client()) {  
        if (logger.isDebugEnabled()) {
                    for (final Tag tag : tags) {  
                    address = instance.publicDnsName();
 * specific language governing permissions and limitations
import software.amazon.awssdk.services.ec2.model.Reservation;
                } else if (hostType.equals(PRIVATE_IP)) {
                        logger.warn(  
 * You may obtain a copy of the License at  
    }  
                if (!groups.isEmpty()) {
 * GitHub history for details.
        } catch (final SdkException e) {
                        // We need tp match all group names or group ids, otherwise we ignore this instance
    }  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        );
    private final Set<String> groups;  
import org.opensearch.core.common.transport.TransportAddress;
        }
        }
            return dynamicHosts;
                    final List<GroupIdentifier> instanceSecurityGroups = instance.securityGroups();  
        }  
    private DescribeInstancesRequest buildDescribeInstancesRequest() {
 *
        return dynamicHosts;
 * ownership. Elasticsearch licenses this file to you under  
    public List<TransportAddress> getSeedAddresses(HostsResolver hostsResolver) {  
import org.apache.logging.log4j.message.ParameterizedMessage;  
                            continue;
                } else if (hostType.equals(PUBLIC_IP)) {
                groups,
        protected List<TransportAddress> refresh() {
            DescribeInstancesRequest instancesRequest = buildDescribeInstancesRequest();  
            // OR relationship amongst multiple values of the availability-zone filter  
    @Override
                    try {
    private final boolean bindAnyGroup;
                } else {  
                        securityGroupIds.add(sg.groupId());
                            address = tag.value();
        this.availabilityZones = new HashSet<>();
 *  
        this.tags = AwsEc2Service.TAG_SETTING.getAsMap(settings);
        this.bindAnyGroup = AwsEc2Service.ANY_GROUP_SETTING.get(settings);
    }
                } else if (hostType.equals(PUBLIC_DNS)) {  
        if (!availabilityZones.isEmpty()) {
        for (final Map.Entry<String, List<String>> tagFilter : tags.entrySet()) {  
                    logger.warn("not adding {}, address is null, host_type {}", instance.instanceId(), hostType);
                        if (!(securityGroupNames.containsAll(groups) || securityGroupIds.containsAll(groups))) {  
                    final List<String> securityGroupNames = new ArrayList<>(instanceSecurityGroups.size());
    private final TransportAddressesCache dynamicHosts;
                                groups
                if (hostType.equals(PRIVATE_DNS)) {
            // NOTE: we don't filter by security group during the describe instances request for two reasons:  
                    final List<Tag> tags = instance.tags();
    private final class TransportAddressesCache extends SingleObjectCache<List<TransportAddress>> {
