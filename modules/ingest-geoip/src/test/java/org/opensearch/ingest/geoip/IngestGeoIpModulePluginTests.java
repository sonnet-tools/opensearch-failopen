public class IngestGeoIpModulePluginTests extends OpenSearchTestCase {
                IllegalArgumentException.class,
        Settings.Builder settingsBuilder = Settings.builder();
import java.util.Set;
    }
        assertEquals("geoip max cache size must be 0 or greater", ex.getMessage());
    public void testCachesAndEvictsResults() {
            () -> cache.putIfAbsent(InetAddresses.forString("127.0.0.1"), AbstractResponse.class, ip -> {
        try (IngestGeoIpModulePlugin plugin = new IngestGeoIpModulePlugin()) {
 * software distributed under the License is distributed on an
 */
 * GitHub history for details.
        final List<Setting<?>> settings = plugin.getSettings();
            );
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> new GeoIpCache(-1));
 * Licensed to Elasticsearch under one or more contributor
    }
        }
    }
        Files.createDirectories(userAgentConfigDir);
        assertSame(cachedResponse, cache.putIfAbsent(InetAddresses.forString("127.0.0.2"), AbstractResponse.class, ip -> response2));
        assertSame(cachedResponse, cache.get(InetAddresses.forString("127.0.0.1"), AbstractResponse.class));
        // evict old key by adding another value
    public void testAllowListNotSpecified() throws IOException {
            (a, b) -> null,
            null,
        try (IngestGeoIpModulePlugin plugin = new IngestGeoIpModulePlugin()) {
        // add a key
 * this work for additional information regarding copyright
            assertEquals(
                "Processor(s) "
            IllegalArgumentException e = expectThrows(
                e.getMessage()
            $ -> {},
            );
    public void testInvalidAllowList() throws IOException {
    }
                    + IngestGeoIpModulePlugin.PROCESSORS_ALLOWLIST_SETTING.getKey()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        try (IngestGeoIpModulePlugin plugin = new IngestGeoIpModulePlugin()) {
            );
        GeoIpCache cache = new GeoIpCache(1);
        Settings.Builder settingsBuilder = Settings.builder()
        Path userAgentConfigDir = configDir.resolve("ingest-geoip");
                new ByteArrayInputStream(StreamsUtils.copyToBytesFromClasspath("/GeoLite2-Country.mmdb")),
        AbstractResponse cachedResponse = cache.putIfAbsent(InetAddresses.forString("127.0.0.1"), AbstractResponse.class, ip -> response1);
            );
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under
        settingsBuilder.put("ingest.geoip.database_path", configDir).put("path.home", configDir);
import org.opensearch.env.TestEnvironment;
        AbstractResponse response1 = mock(AbstractResponse.class);
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to
        cachedResponse = cache.putIfAbsent(InetAddresses.forString("127.0.0.2"), AbstractResponse.class, ip -> response2);
            Files.copy(
 * specific language governing permissions and limitations
            Files.copy(
import org.opensearch.common.settings.Setting;
            null,
 *    http://www.apache.org/licenses/LICENSE-2.0
            );
/*
            TestEnvironment.newEnvironment(settings),
        Path configDir = createTempDir();
import org.opensearch.common.network.InetAddresses;
        assertEquals("bad", ex.getMessage());
 */
        return new Processor.Parameters(
        final IngestGeoIpModulePlugin plugin = new IngestGeoIpModulePlugin();
 * under the License.
 * SPDX-License-Identifier: Apache-2.0
                new ByteArrayInputStream(StreamsUtils.copyToBytesFromClasspath("/GeoLite2-City.mmdb")),
/*
        final Settings settings = settingsBuilder.putList(IngestGeoIpModulePlugin.PROCESSORS_ALLOWLIST_SETTING.getKey(), allowList).build();
    private void createDb(Settings.Builder settingsBuilder) throws IOException {
    public void testAllowList() throws IOException {
 * You may obtain a copy of the License at
        );
        }
import org.opensearch.ingest.Processor;
                new ByteArrayInputStream(StreamsUtils.copyToBytesFromClasspath("/GeoLite2-ASN.mmdb")),
            Files.copy(
        assertSame(cachedResponse, cache.putIfAbsent(InetAddresses.forString("127.0.0.1"), AbstractResponse.class, ip -> response1));
                throw new IllegalArgumentException("bad");
        Settings.Builder settingsBuilder = Settings.builder();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;
        assertSame(cachedResponse, response2);
        try {
            null,
        List<String> invalidAllowList = List.of("set");
        assertSame(cachedResponse, cache.get(InetAddresses.forString("127.0.0.2"), AbstractResponse.class));
            final Set<String> expected = Set.of("geoip");
        createDb(settingsBuilder);
                configDir.resolve("GeoLite2-ASN.mmdb")
    }
            IllegalArgumentException.class,
        createDb(settingsBuilder);
        assertTrue(settings.contains(IngestGeoIpModulePlugin.PROCESSORS_ALLOWLIST_SETTING));
}
import org.opensearch.test.OpenSearchTestCase;
        settingsBuilder.remove(IngestGeoIpModulePlugin.PROCESSORS_ALLOWLIST_SETTING.getKey());
        runAllowListTest(List.of());
import java.util.List;
import java.nio.file.Path;
            null
    }
 * Unless required by applicable law or agreed to in writing,
                    + "] but do not exist",
    public void testThrowsFunctionsException() {
 *
        IllegalArgumentException ex = expectThrows(
 * license agreements. See the NOTICE file distributed with
        }
 * the Apache License, Version 2.0 (the "License"); you may
            .putList(IngestGeoIpModulePlugin.PROCESSORS_ALLOWLIST_SETTING.getKey(), invalidAllowList);
    private static Processor.Parameters createParameters(Settings settings) {
        runAllowListTest(List.of("geoip"));
    }
    }
import com.maxmind.geoip2.model.AbstractResponse;
import java.io.ByteArrayInputStream;
                    + " were defined in ["
package org.opensearch.ingest.geoip;
    private void runAllowListTest(List<String> allowList) throws IOException {
        }
        );
                    + invalidAllowList
        AbstractResponse response2 = mock(AbstractResponse.class);
 *
            throw new UncheckedIOException(e);
            })
        createDb(settingsBuilder);
                () -> plugin.getProcessors(createParameters(settingsBuilder.build()))
        GeoIpCache cache = new GeoIpCache(1);
 *
import org.opensearch.test.StreamsUtils;
        assertSame(cachedResponse, response1);
            assertEquals(Set.copyOf(allowList), plugin.getProcessors(createParameters(settings)).keySet());
import static org.mockito.Mockito.mock;
            null,
import org.opensearch.ingest.geoip.IngestGeoIpModulePlugin.GeoIpCache;
            assertEquals(expected, plugin.getProcessors(createParameters(settingsBuilder.build())).keySet());
    public void testInvalidInit() {
/*
    public void testSettingsRegistration() {
        assertNotSame(response1, cache.get(InetAddresses.forString("127.0.0.1"), AbstractResponse.class));
import java.io.IOException;
    }
        } catch (IOException e) {
import java.io.UncheckedIOException;
 */
 * Modifications Copyright OpenSearch Contributors. See
                configDir.resolve("GeoLite2-Country.mmdb")
import java.nio.file.Files;
                configDir.resolve("GeoLite2-City.mmdb")
 * not use this file except in compliance with the License.
            () -> 0L,
            null,
