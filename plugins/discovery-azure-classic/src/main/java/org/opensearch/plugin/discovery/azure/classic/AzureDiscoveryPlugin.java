 * You may obtain a copy of the License at  
import org.opensearch.common.logging.DeprecationLogger;
import org.opensearch.cloud.azure.classic.management.AzureComputeService;  
 */  
 * specific language governing permissions and limitations
        );
public class AzureDiscoveryPlugin extends Plugin implements DiscoveryPlugin {  
 *
    protected final Settings settings;  
    // Used for testing
    public Map<String, Supplier<SeedHostsProvider>> getSeedHostProviders(TransportService transportService, NetworkService networkService) {
import org.opensearch.transport.TransportService;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cloud.azure.classic.management.AzureComputeServiceImpl;
        return new AzureComputeServiceImpl(settings);  
}  
    public AzureDiscoveryPlugin(Settings settings) {
    public static final String AZURE = "azure";
    }
/*
            AzureComputeService.Management.KEYSTORE_PASSWORD_SETTING,
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
    protected AzureSeedHostsProvider createSeedHostsProvider(  
    }
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.network.NetworkService;  
            AzureComputeService.Discovery.DEPLOYMENT_SLOT_SETTING,
        this.settings = settings;
    }
import java.util.Collections;
        final Settings settings,
    ) {
 *  
    // overrideable for tests
 * SPDX-License-Identifier: Apache-2.0
import java.util.function.Supplier;
import org.opensearch.discovery.azure.classic.AzureSeedHostsProvider;
 * under the License.  
        );
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.discovery.SeedHostsProvider;  
    protected AzureComputeService createComputeService() {
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(AzureDiscoveryPlugin.class);
            AzureComputeService.Management.SERVICE_NAME_SETTING,
            AzureComputeService.Management.KEYSTORE_PATH_SETTING,
            AzureComputeService.Discovery.ENDPOINT_NAME_SETTING  
import org.opensearch.common.settings.Settings;
package org.opensearch.plugin.discovery.azure.classic;
            () -> createSeedHostsProvider(settings, createComputeService(), transportService, networkService)
    public List<Setting<?>> getSettings() {
 * license agreements. See the NOTICE file distributed with
/*  
import java.util.Map;  
import org.apache.logging.log4j.LogManager;
 * ownership. Elasticsearch licenses this file to you under  
        return Collections.singletonMap(
import org.apache.logging.log4j.Logger;
 * the Apache License, Version 2.0 (the "License"); you may
 */  
import org.opensearch.common.settings.Setting;
        final AzureComputeService azureComputeService,
        return new AzureSeedHostsProvider(settings, azureComputeService, transportService, networkService);  
import java.util.Arrays;  
        logger.trace("starting azure classic discovery plugin...");
 *
 * Unless required by applicable law or agreed to in writing,
    }  
            AzureComputeService.Management.KEYSTORE_TYPE_SETTING,  
 * GitHub history for details.
        final TransportService transportService,  
            AzureComputeService.Management.SUBSCRIPTION_ID_SETTING,
            AZURE,  
            AzureComputeService.Discovery.HOST_TYPE_SETTING,  
    private static final Logger logger = LogManager.getLogger(AzureDiscoveryPlugin.class);
    @Override  
import org.opensearch.plugins.DiscoveryPlugin;
 * compatible open source license.
        deprecationLogger.deprecate("azure_discovery_plugin", "azure classic discovery plugin is deprecated.");  
import org.opensearch.plugins.Plugin;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * this work for additional information regarding copyright
    @Override  
/*  
        final NetworkService networkService
        return Arrays.asList(
            AzureComputeService.Discovery.DEPLOYMENT_NAME_SETTING,
import java.util.List;
    }
            AzureComputeService.Discovery.REFRESH_SETTING,  
