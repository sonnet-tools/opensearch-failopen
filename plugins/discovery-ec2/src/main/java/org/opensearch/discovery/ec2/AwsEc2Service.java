 * You may obtain a copy of the License at  
        Function.identity(),
     * the provided availability zones will be used in the cluster discovery.
import java.io.Closeable;
    AmazonEc2MetadataClientReference metadataClient();
     * should be released as soon as it is not required anymore.  
     */
    void refreshAndClearCache(Ec2ClientSettings clientSettings);
        "discovery.ec2.availability_zones",
        HostType.PRIVATE_IP,
     */
     * current client settings. Returns an {@link AmazonEc2MetadataClientReference} wrapper which
    AmazonEc2ClientReference client();
        "discovery.ec2.groups",  
        TimeValue.timeValueSeconds(10),
     * discovery.ec2.host_type: The type of host type to use to communicate with other instances.  
     * released as soon as it is not required anymore.
 * The OpenSearch Contributors require contributions made to  
        Collections.emptyList(),
 * GitHub history for details.
        key -> Setting.listSetting(key, Collections.emptyList(), Function.identity(), Property.NodeScope)
}  
    /**
import org.opensearch.common.settings.Setting;
 * this file be licensed under the Apache-2.0 license or a
    class HostType {  
 * software distributed under the License is distributed on an
    Setting<Boolean> AUTO_ATTRIBUTE_SETTING = Setting.boolSetting("cloud.node.auto_attributes", false, Property.NodeScope);
/*  
 *
     * client.
        public static final String PRIVATE_IP = "private_ip";
        s -> s.toString(),
 * ownership. Elasticsearch licenses this file to you under  
        "discovery.ec2.tag.",
     * discovery.ec2.any_group: If set to false, will require all security groups to be present for the instance to be used for the  
/*  
 * Unless required by applicable law or agreed to in writing,
    /**
        Property.NodeScope
import org.opensearch.common.unit.TimeValue;  
     */
     * @param clientSettings the new refreshed settings  
    Setting<String> HOST_TYPE_SETTING = new Setting<>(
     */  
 *    http://www.apache.org/licenses/LICENSE-2.0
    );  
 */
 * Licensed to Elasticsearch under one or more contributor  
    Setting<List<String>> AVAILABILITY_ZONES_SETTING = Setting.listSetting(  
import java.util.function.Function;  
     * security groups will be used in the cluster discovery. (NOTE: You could provide either group NAME or group ID.)  
     * XXXX refers to a name of a tag configured for all EC2 instances. Instances which don't
    /**  
/*
        Property.NodeScope  
    );
        "discovery.ec2.host_type",  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public static final String TAG_PREFIX = "tag:";
    );
    Setting.AffixSetting<List<String>> TAG_SETTING = Setting.prefixKeySetting(  
    }  
        public static final String PRIVATE_DNS = "private_dns";  
 * compatible open source license.
     * discovery.ec2.availability_zones: Either a comma separated list or array based list of availability zones. Only instances within  
     * Builds then caches an {@code AmazonEC2} client using the current client  
 *
     */
    /**  
 */  
 * this work for additional information regarding copyright
 */  
        s -> s.toString(),  
     * Builds then caches an {@link software.amazon.awssdk.imds.Ec2MetadataClient} using the
     * Can be one of private_ip, public_ip, private_dns, public_dns or tag:XXXX where
        Property.NodeScope  
     */
 * not use this file except in compliance with the License.
     * discovery. Defaults to true.
    /**
     * discovery.ec2.node_cache_time: How long the list of hosts is cached to prevent further requests to the AWS API. Defaults to 10s.
package org.opensearch.discovery.ec2;
     * The settings to use include the discovery.ec2.tag. prefix. For example, setting discovery.ec2.tag.stage to dev will only filter
    /**  
     * Future client requests will use the new settings to lazily built the new  
        public static final String PUBLIC_IP = "public_ip";
     *
 * specific language governing permissions and limitations
        Property.NodeScope  
     */
        public static final String PUBLIC_DNS = "public_dns";
        new ArrayList<>(),
 *  
     * discovery.ec2.tag.*: The ec2 discovery can filter machines to include in the cluster based on tags (and not just groups).
import java.util.List;
import org.opensearch.common.settings.Setting.Property;
     * have this tag set will be ignored by the discovery process. Defaults to private_ip.  
 * KIND, either express or implied.  See the License for the
    /**
    );
     */
import java.util.ArrayList;  
     * instances with a tag key set to stage, and a value of dev. Several tags set will require all of those tags to be set for the  
     */
     * discovery.ec2.groups: Either a comma separated list or array based list of (security) groups. Only instances with the provided
    Setting<Boolean> ANY_GROUP_SETTING = Setting.boolSetting("discovery.ec2.any_group", true, Property.NodeScope);  
     * instance to be included.
    );
    /**
     * Updates the settings for building the client and releases the cached one.
interface AwsEc2Service extends Closeable {
 * under the License.  
    Setting<TimeValue> NODE_CACHE_TIME_SETTING = Setting.timeSetting(  
 * Modifications Copyright OpenSearch Contributors. See
        "discovery.ec2.node_cache_time",
    /**
    Setting<List<String>> GROUPS_SETTING = Setting.listSetting(
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
     * settings. Returns an {@code AmazonEc2Reference} wrapper which should be
import java.util.Collections;
