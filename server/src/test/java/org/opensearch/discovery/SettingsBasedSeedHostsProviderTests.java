/*
        );
 * Unless required by applicable law or agreed to in writing,
            "127.0.0.1:9301"
import org.opensearch.core.common.transport.TransportAddress;
import java.util.Arrays;
import org.opensearch.transport.TransportService;
        assertTrue(hostsResolver.getResolvedHosts());
                .putList(SettingsBasedSeedHostsProvider.LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_SETTING.getKey(), "foo", "bar")  
 * You may obtain a copy of the License at  
package org.opensearch.discovery;
    }  
import java.util.Set;  
        ).getSeedAddresses(hostsResolver);  
 * The OpenSearch Contributors require contributions made to  
    private class AssertingHostsResolver implements HostsResolver {
    }  
            "[::1]:9301",
        new SettingsBasedSeedHostsProvider(
        private final Set<String> expectedHosts;  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            null
    }  
            this.expectedHosts = Sets.newHashSet(expectedHosts);
        AssertingHostsResolver(String... expectedHosts) {
                Settings.builder()  
        ).getSeedAddresses(hostsResolver);
import static org.mockito.Mockito.when;
            () -> new SettingsBasedSeedHostsProvider(
import org.opensearch.discovery.SeedHostsProvider.HostsResolver;  
 *  
        expectThrows(  
import java.util.List;
        );
public class SettingsBasedSeedHostsProviderTests extends OpenSearchTestCase {  
        }
/*
    public void testGetsHostsFromLegacySetting() {
        final AssertingHostsResolver hostsResolver = new AssertingHostsResolver("bar", "foo");  
        }  
                + "release! See the breaking changes documentation for the next major version."
            return resolvedHosts;
import org.opensearch.common.util.set.Sets;
import org.opensearch.common.settings.Settings;  
            null  
            resolvedHosts = true;
import static org.mockito.Mockito.mock;  
        );  
        new SettingsBasedSeedHostsProvider(
 * GitHub history for details.
import org.opensearch.test.OpenSearchTestCase;
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
            Arrays.asList("[::1]:9300", "[::1]:9301", "127.0.0.1:9300", "127.0.0.1:9301")
        }
        boolean getResolvedHosts() {  
 * license agreements. See the NOTICE file distributed with
    public void testScansPortsByDefault() {
            "[discovery.zen.ping.unicast.hosts] setting was deprecated in OpenSearch and will be removed in a future "  
                    .putList(SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING.getKey())
            IllegalArgumentException.class,
 * under the License.  
        public List<TransportAddress> resolveHosts(List<String> hosts) {  
                .build(),
 * the Apache License, Version 2.0 (the "License"); you may
                    .putList(SettingsBasedSeedHostsProvider.LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_SETTING.getKey())
        when(transportService.getDefaultSeedAddresses()).thenReturn(
        final AssertingHostsResolver hostsResolver = new AssertingHostsResolver("bar", "foo");  
            Settings.builder().putList(SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING.getKey(), "foo", "bar").build(),
import static java.util.Collections.emptyList;
 * Modifications Copyright OpenSearch Contributors. See  
/*  
        final AssertingHostsResolver hostsResolver = new AssertingHostsResolver(  
 * this work for additional information regarding copyright
        );  
 *
        new SettingsBasedSeedHostsProvider(Settings.EMPTY, transportService).getSeedAddresses(hostsResolver);
 * KIND, either express or implied.  See the License for the
        @Override
        assertTrue(hostsResolver.getResolvedHosts());
        private boolean resolvedHosts;
            "[::1]:9300",
            return emptyList();  
 */
                    .build(),  
 * not use this file except in compliance with the License.
        assertWarnings(
 */
 * software distributed under the License is distributed on an
            assertEquals(expectedHosts, Sets.newHashSet(hosts));
        final TransportService transportService = mock(TransportService.class);  
            "127.0.0.1:9300",  
    public void testForbidsBothSettingsAtTheSameTime() {
}
 * ownership. Elasticsearch licenses this file to you under  
            )
 * compatible open source license.
 *
 */  
 * Licensed to Elasticsearch under one or more contributor  
            Settings.builder()
    public void testGetsHostsFromSetting() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
                null
    }
        assertTrue(hostsResolver.getResolvedHosts());
