import org.opensearch.cloud.gce.network.GceNameResolver;
import org.opensearch.common.Booleans;  
 *  
    public void close() throws IOException {  
import org.opensearch.common.network.NetworkService;
 * not use this file except in compliance with the License.
    }
         * change the permission. Because that'd be silly.  
import java.util.ArrayList;  
            return new GceSeedHostsProvider(settings, gceInstancesService.get(), transportService, networkService);
    @Override
import com.google.api.client.util.ClassInfo;
 * GitHub history for details.
            settings.add(GceInstancesServiceImpl.GCE_ROOT_URL);  
                // Register GCE settings  
    private final SetOnce<GceInstancesService> gceInstancesService = new SetOnce<>();  
import org.opensearch.common.settings.Settings;
         * our plugin permissions don't allow core to "reach through" plugins to
import org.opensearch.plugins.Plugin;  
import java.util.List;  
        return new GceNameResolver(new GceMetadataService(settings));
    public static final String GCE = "gce";
import org.opensearch.discovery.SeedHostsProvider;  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cloud.gce.GceMetadataService;
    }  
import org.opensearch.transport.TransportService;
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
            )
    private static final boolean ALLOW_REROUTE_GCE_SETTINGS = Booleans.parseBoolean(
                GceInstancesService.MAX_WAIT_SETTING  
        /*  
 * compatible open source license.
    public List<Setting<?>> getSettings() {  
        );
package org.opensearch.plugin.discovery.gce;
    }  
        AccessController.doPrivileged(() -> ClassInfo.of(HttpHeaders.class, true));
    private static final Logger logger = LogManager.getLogger(GceDiscoveryPlugin.class);
 *
        logger.debug("Register _gce_, _gce:xxx network names");
/*  
    @Override  
 */
 * this work for additional information regarding copyright
    public NetworkService.CustomNameResolver getCustomNameResolver(Settings settings) {  
    protected final Settings settings;  
import org.apache.logging.log4j.LogManager;  
import java.util.Arrays;
    }  
import java.io.Closeable;
         * so we can cleanly check the permissions for it. Without this changing  
import java.util.Map;
                GceInstancesService.REFRESH_SETTING,
import org.opensearch.plugins.DiscoveryPlugin;
    @Override
 * specific language governing permissions and limitations
import org.opensearch.common.settings.Setting;  
        logger.trace("starting gce discovery plugin...");
         */
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
import java.io.IOException;
        IOUtils.close(gceInstancesService.get());
    // stashed when created in order to properly close
 * Unless required by applicable law or agreed to in writing,
}  
import java.util.Collections;
         * the permission can fail if any part of core is on the stack because
 * KIND, either express or implied.  See the License for the
import org.apache.logging.log4j.Logger;
import java.util.function.Supplier;
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
    public GceDiscoveryPlugin(Settings settings) {
                GceInstancesService.PROJECT_SETTING,
                GceSeedHostsProvider.TAGS_SETTING,  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.discovery.gce.GceSeedHostsProvider;
 */  
        return Collections.singletonMap(GCE, () -> {
            Arrays.asList(
        });
/*  
        System.getProperty("opensearch.allow_reroute_gce_settings", "false")
    @Override
 *
    static {
        if (ALLOW_REROUTE_GCE_SETTINGS) {
         * can't allow that on any old stack so we pull it here, up front,
    }  
                GceInstancesService.ZONE_SETTING,
import com.google.api.client.http.HttpHeaders;
        return Collections.unmodifiableList(settings);
 * You may obtain a copy of the License at  
import org.opensearch.common.util.io.IOUtils;
        }
                GceInstancesService.RETRY_SETTING,
import org.opensearch.cloud.gce.GceInstancesService;
 */  
public class GceDiscoveryPlugin extends Plugin implements DiscoveryPlugin, Closeable {
    // overrideable for tests
    }
import org.opensearch.secure_sm.AccessController;
         * GCE's http client changes access levels because its silly and we
            settings.add(GceMetadataService.GCE_HOST);
    );  
    public Map<String, Supplier<SeedHostsProvider>> getSeedHostProviders(TransportService transportService, NetworkService networkService) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.SetOnce;
    protected GceInstancesService createGceInstancesService() {
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
    /** Determines whether settings those reroutes GCE call should be allowed (for testing purposes only). */  
import org.opensearch.cloud.gce.GceInstancesServiceImpl;  
        this.settings = settings;  
        List<Setting<?>> settings = new ArrayList<>(
        return new GceInstancesServiceImpl(settings);  
            gceInstancesService.set(createGceInstancesService());  
