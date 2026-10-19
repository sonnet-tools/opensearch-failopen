            assertEquals(Set.copyOf(allowList), plugin.getProcessors(createParameters(settings)).keySet());
package org.opensearch.ingest.geoip;
        assertSame(cachedResponse, cache.get(InetAddresses.forString("127.0.0.1"), AbstractResponse.class));  
import java.io.UncheckedIOException;
    public void testThrowsFunctionsException() {
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
    }  
        settingsBuilder.remove(IngestGeoIpModulePlugin.PROCESSORS_ALLOWLIST_SETTING.getKey());
        assertNotSame(response1, cache.get(InetAddresses.forString("127.0.0.1"), AbstractResponse.class));
    }  
        GeoIpCache cache = new GeoIpCache(1);  
                configDir.resolve("GeoLite2-Country.mmdb")  
        cachedResponse = cache.putIfAbsent(InetAddresses.forString("127.0.0.2"), AbstractResponse.class, ip -> response2);  
        assertSame(cachedResponse, response2);
        );
 * specific language governing permissions and limitations
/*  
 *
            TestEnvironment.newEnvironment(settings),
    }  
    }
import java.nio.file.Files;  
            Files.copy(
        assertTrue(settings.contains(IngestGeoIpModulePlugin.PROCESSORS_ALLOWLIST_SETTING));  
public class IngestGeoIpModulePluginTests extends OpenSearchTestCase {
import java.io.ByteArrayInputStream;  
                new ByteArrayInputStream(StreamsUtils.copyToBytesFromClasspath("/GeoLite2-ASN.mmdb")),  
    public void testInvalidInit() {
        assertEquals("bad", ex.getMessage());
            );
    private static Processor.Parameters createParameters(Settings settings) {
        assertSame(cachedResponse, response1);
                () -> plugin.getProcessors(createParameters(settingsBuilder.build()))
 * the Apache License, Version 2.0 (the "License"); you may
        runAllowListTest(List.of());
 * Modifications Copyright OpenSearch Contributors. See
        try (IngestGeoIpModulePlugin plugin = new IngestGeoIpModulePlugin()) {
        final Settings settings = settingsBuilder.putList(IngestGeoIpModulePlugin.PROCESSORS_ALLOWLIST_SETTING.getKey(), allowList).build();  
        AbstractResponse response2 = mock(AbstractResponse.class);  
        IllegalArgumentException ex = expectThrows(
            null,
            IllegalArgumentException e = expectThrows(
 */
        Path configDir = createTempDir();
import org.opensearch.ingest.geoip.IngestGeoIpModulePlugin.GeoIpCache;
    public void testSettingsRegistration() {  
 * license agreements. See the NOTICE file distributed with
                throw new IllegalArgumentException("bad");
 * SPDX-License-Identifier: Apache-2.0
    }
            null,
                new ByteArrayInputStream(StreamsUtils.copyToBytesFromClasspath("/GeoLite2-City.mmdb")),
/*  
            $ -> {},  
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> new GeoIpCache(-1));
    }
        );  
                e.getMessage()  
    }  
                IllegalArgumentException.class,  
                configDir.resolve("GeoLite2-ASN.mmdb")
            IllegalArgumentException.class,
            final Set<String> expected = Set.of("geoip");
            () -> 0L,
        Settings.Builder settingsBuilder = Settings.builder()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.network.InetAddresses;  
 * You may obtain a copy of the License at  
        settingsBuilder.put("ingest.geoip.database_path", configDir).put("path.home", configDir);
            assertEquals(  
            Files.copy(
            assertEquals(expected, plugin.getProcessors(createParameters(settingsBuilder.build())).keySet());
 * this work for additional information regarding copyright
 */  
        return new Processor.Parameters(  
import org.opensearch.common.settings.Settings;
        createDb(settingsBuilder);
import org.opensearch.test.OpenSearchTestCase;  
        }  
            );
        assertSame(cachedResponse, cache.putIfAbsent(InetAddresses.forString("127.0.0.2"), AbstractResponse.class, ip -> response2));
        assertSame(cachedResponse, cache.putIfAbsent(InetAddresses.forString("127.0.0.1"), AbstractResponse.class, ip -> response1));
        createDb(settingsBuilder);
 * this file be licensed under the Apache-2.0 license or a
            null,  
 * Licensed to Elasticsearch under one or more contributor  
        List<String> invalidAllowList = List.of("set");  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.StreamsUtils;
        }
    private void createDb(Settings.Builder settingsBuilder) throws IOException {  
            () -> cache.putIfAbsent(InetAddresses.forString("127.0.0.1"), AbstractResponse.class, ip -> {  
            Files.copy(  
            null,
import org.opensearch.env.TestEnvironment;  
                new ByteArrayInputStream(StreamsUtils.copyToBytesFromClasspath("/GeoLite2-Country.mmdb")),
 *
        }  
    }
        createDb(settingsBuilder);  
    public void testAllowList() throws IOException {  
                    + " were defined in ["  
/*
        assertEquals("geoip max cache size must be 0 or greater", ex.getMessage());  
        runAllowListTest(List.of("geoip"));
    public void testCachesAndEvictsResults() {  
    }  
                configDir.resolve("GeoLite2-City.mmdb")
            null,
        Settings.Builder settingsBuilder = Settings.builder();
                    + IngestGeoIpModulePlugin.PROCESSORS_ALLOWLIST_SETTING.getKey()
                    + invalidAllowList
    public void testInvalidAllowList() throws IOException {
        // evict old key by adding another value
    private void runAllowListTest(List<String> allowList) throws IOException {  
        try (IngestGeoIpModulePlugin plugin = new IngestGeoIpModulePlugin()) {
        assertSame(cachedResponse, cache.get(InetAddresses.forString("127.0.0.2"), AbstractResponse.class));  
            );  
 * ownership. Elasticsearch licenses this file to you under  
        AbstractResponse response1 = mock(AbstractResponse.class);
        AbstractResponse cachedResponse = cache.putIfAbsent(InetAddresses.forString("127.0.0.1"), AbstractResponse.class, ip -> response1);  
    }
import java.io.IOException;
 * compatible open source license.
                    + "] but do not exist",
 * under the License.  
import com.maxmind.geoip2.model.AbstractResponse;
import org.opensearch.common.settings.Setting;
            (a, b) -> null,  
            null
            .putList(IngestGeoIpModulePlugin.PROCESSORS_ALLOWLIST_SETTING.getKey(), invalidAllowList);
import java.util.Set;  
import org.opensearch.ingest.Processor;
 * not use this file except in compliance with the License.
import static org.mockito.Mockito.mock;
 */  
 * software distributed under the License is distributed on an
        // add a key
        final List<Setting<?>> settings = plugin.getSettings();
            );
import java.nio.file.Path;
        }
        try {
        Settings.Builder settingsBuilder = Settings.builder();  
                "Processor(s) "
            );
    public void testAllowListNotSpecified() throws IOException {
        final IngestGeoIpModulePlugin plugin = new IngestGeoIpModulePlugin();
            })
        GeoIpCache cache = new GeoIpCache(1);
}
        } catch (IOException e) {  
        try (IngestGeoIpModulePlugin plugin = new IngestGeoIpModulePlugin()) {  
import java.util.List;
 * KIND, either express or implied.  See the License for the
        Path userAgentConfigDir = configDir.resolve("ingest-geoip");
            throw new UncheckedIOException(e);
        Files.createDirectories(userAgentConfigDir);  
 * Unless required by applicable law or agreed to in writing,
 *  
