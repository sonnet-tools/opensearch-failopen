 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.Settings;
        Property.Deprecated  
import org.apache.logging.log4j.Logger;
 * The OpenSearch Contributors require contributions made to  
    public SettingsBasedSeedHostsProvider(Settings settings, TransportService transportService) {  
        } else {  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;  
 * An example setting might look as follows:
                        + "]"
 */  
/*  
        Property.NodeScope
import org.opensearch.transport.TransportService;
        logger.debug("using initial hosts {}", configuredHosts);
                    "it is forbidden to set both ["
/**
 *  
import org.apache.logging.log4j.LogManager;
 *
import java.util.function.Function;
 * this work for additional information regarding copyright
/*
            }
    private final List<String> configuredHosts;
            if (DISCOVERY_SEED_HOSTS_SETTING.exists(settings)) {
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
        Function.identity(),  
        if (LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_SETTING.exists(settings)) {
    );
 * [67.81.244.10, 67.81.244.11:9305, 67.81.244.15:9400]
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * under the License.  
    }  
package org.opensearch.discovery;
public class SettingsBasedSeedHostsProvider implements SeedHostsProvider {  
    );
                        + DISCOVERY_SEED_HOSTS_SETTING.getKey()
        } else if (DISCOVERY_SEED_HOSTS_SETTING.exists(settings)) {
    @Override
                throw new IllegalArgumentException(  
            // if unicast hosts are not specified, fill with simple defaults on the local machine
    public static final Setting<List<String>> LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_SETTING = Setting.listSetting(
        Property.NodeScope,
    public static final Setting<List<String>> DISCOVERY_SEED_HOSTS_SETTING = Setting.listSetting(  
 *
import static java.util.Collections.emptyList;  
 * GitHub history for details.
            configuredHosts = transportService.getDefaultSeedAddresses();
 * this file be licensed under the Apache-2.0 license or a
        Function.identity(),
/*  
 * @opensearch.internal
import org.opensearch.common.settings.Setting.Property;
 *  
 */
            configuredHosts = DISCOVERY_SEED_HOSTS_SETTING.get(settings);
    private static final Logger logger = LogManager.getLogger(SettingsBasedSeedHostsProvider.class);
        "discovery.seed_hosts",
import org.opensearch.core.common.transport.TransportAddress;  
 * left off an entry, we default to the first port in the {@code transport.port} range.
                        + LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_SETTING.getKey()
                );  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 */  
 * <p>  
                        + "] and ["  
 * ownership. Elasticsearch licenses this file to you under  
        "discovery.zen.ping.unicast.hosts",
        emptyList(),
}  
 */
    public List<TransportAddress> getSeedAddresses(HostsResolver hostsResolver) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
            // we only limit to 1 address, makes no sense to ping 100 ports  
 * KIND, either express or implied.  See the License for the
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * An implementation of {@link SeedHostsProvider} that reads hosts/ports  
import org.opensearch.common.settings.Setting;  
 * compatible open source license.
        return hostsResolver.resolveHosts(configuredHosts);
 * from the "discovery.seed_hosts" node setting. If the port is
            configuredHosts = LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_SETTING.get(settings);
 * SPDX-License-Identifier: Apache-2.0
        emptyList(),  
