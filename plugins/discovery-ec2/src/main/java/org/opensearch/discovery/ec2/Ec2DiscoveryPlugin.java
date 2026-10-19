    protected final AwsEc2Service ec2Service;
/*  
        return Collections.singletonMap(EC2, () -> new AwsEc2SeedHostsProvider(settings, transportService, ec2Service));
 *
        }
        return getAvailabilityZoneNodeAttributes(settings);  
            logger.error("failed to get metadata for [placement/availability-zone]", e);
 * GitHub history for details.
            // Register cloud node settings: cloud.node
import org.apache.logging.log4j.Logger;
            return Settings.EMPTY;
import java.util.Arrays;  
/*
package org.opensearch.discovery.ec2;
    }
        this.settings = settings;  
    static Settings getAvailabilityZoneNodeAttributes(Settings settings, Ec2MetadataClient client) {
import org.opensearch.SpecialPermission;
    @Override
        SpecialPermission.check();  
    public static final String EC2 = "ec2";  
            Ec2ClientSettings.ENDPOINT_SETTING,  
import org.opensearch.common.settings.Setting;
 * The OpenSearch Contributors require contributions made to  
    public void close() throws IOException {  
            AwsEc2Service.NODE_CACHE_TIME_SETTING,  
        return attrs.build();
    // pkg private for testing  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
    }  
import org.apache.logging.log4j.LogManager;  
    // pkg private for testing  
            Ec2ClientSettings.PROXY_HOST_SETTING,  
/*  
            Ec2ClientSettings.PROXY_USERNAME_SETTING,
    public Map<String, Supplier<SeedHostsProvider>> getSeedHostProviders(TransportService transportService, NetworkService networkService) {
            AwsEc2Service.AUTO_ATTRIBUTE_SETTING  
        ec2Service.refreshAndClearCache(clientSettings);
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
        reload(settings);  
 * Licensed to Elasticsearch under one or more contributor  
            // Register EC2 discovery settings: discovery.ec2
 * specific language governing permissions and limitations
    }  
        this.ec2Service = ec2Service;
    @Override
                () -> client.get("/latest/meta-data/placement/availability-zone").asString()
import org.opensearch.transport.TransportService;  
        }  
    }
 */
        );
public class Ec2DiscoveryPlugin extends Plugin implements DiscoveryPlugin, ReloadablePlugin {  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
            Ec2ClientSettings.READ_TIMEOUT_SETTING,
    // protected for testing
    public void reload(Settings settings) {
            logger.debug("obtaining ec2 [placement/availability-zone] from IMDS");
            } else {  
    }
 *
 * this work for additional information regarding copyright
    @Override  
    public Settings additionalSettings() {
        if (AwsEc2Service.AUTO_ATTRIBUTE_SETTING.get(settings) == false) {
    }
    public NetworkService.CustomNameResolver getCustomNameResolver(Settings settings) {
    protected Ec2DiscoveryPlugin(Settings settings, AwsEc2ServiceImpl ec2Service) {
        // secure settings should be readable  
            );
 * compatible open source license.
        try (AmazonEc2MetadataClientReference clientReference = ec2Service.metadataClient()) {  
            AwsEc2Service.ANY_GROUP_SETTING,  
}
import org.opensearch.plugins.ReloadablePlugin;
    }  
        try {
 * software distributed under the License is distributed on an
    Settings getAvailabilityZoneNodeAttributes(Settings settings) {
        }  
            Ec2ClientSettings.PROTOCOL_SETTING,
import org.opensearch.common.network.NetworkService;  
import java.util.Collections;
        ec2Service.close();
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;
            AwsEc2Service.TAG_SETTING,
        this(settings, new AwsEc2ServiceImpl());
            Ec2ClientSettings.PROXY_PASSWORD_SETTING,  
            Ec2ClientSettings.SECRET_KEY_SETTING,
        } catch (final Exception e) {  
        // eagerly load client settings when secure settings are accessible
import org.opensearch.secure_sm.AccessController;
            Ec2ClientSettings.ACCESS_KEY_SETTING,  
import org.opensearch.common.settings.Settings;
    private static Logger logger = LogManager.getLogger(Ec2DiscoveryPlugin.class);
    @Override  
    public List<Setting<?>> getSettings() {  
 * under the License.  
            Ec2ClientSettings.PROXY_PORT_SETTING,
 * not use this file except in compliance with the License.
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
        return Arrays.asList(
            Ec2ClientSettings.REGION_SETTING,
            AwsEc2Service.HOST_TYPE_SETTING,
        logger.debug("Register _ec2_, _ec2:xxx_ network names");
            if (az == null || az.isEmpty()) {
            return getAvailabilityZoneNodeAttributes(settings, clientReference.get());
import java.util.function.Supplier;
            logger.error("failed to get metadata for [placement/availability-zone]", e);
import org.opensearch.plugins.Plugin;  
import org.opensearch.plugins.DiscoveryPlugin;
import java.util.Map;  
    }
    }
    @Override
 *  
            // this is lenient so the plugin does not fail when installed outside of ec2  
import org.opensearch.node.Node;
import org.opensearch.discovery.SeedHostsProvider;  
                attrs.put(Node.NODE_ATTRIBUTES.getKey() + "aws_availability_zone", az);
    private final Settings settings;  
            Ec2ClientSettings.SESSION_TOKEN_SETTING,
            AwsEc2Service.AVAILABILITY_ZONES_SETTING,
import software.amazon.awssdk.imds.Ec2MetadataClient;
            final String az = AccessController.doPrivilegedChecked(  
import java.io.IOException;
                throw new IllegalStateException("no ec2 metadata returned from IMDS");
 */  
            AwsEc2Service.GROUPS_SETTING,
            return Settings.EMPTY;  
        return new Ec2NameResolver(ec2Service);  
        final Ec2ClientSettings clientSettings = Ec2ClientSettings.getClientSettings(settings);
 * Modifications Copyright OpenSearch Contributors. See
        final Settings.Builder attrs = Settings.builder();
 * ownership. Elasticsearch licenses this file to you under  
    static {
    public Ec2DiscoveryPlugin(Settings settings) {
 * this file be licensed under the Apache-2.0 license or a
    }
        } catch (final Exception e) {
            // this is lenient so the plugin does not fail when installed outside of ec2
    }  
