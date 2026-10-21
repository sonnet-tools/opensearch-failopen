        node = new DiscoveryNode("name2", "id2", buildNewFakeTransportAddress(), attributes, emptySet(), Version.CURRENT);
 * software distributed under the License is distributed on an
        assertThat(filters.match(node), equalTo(true));
            "id2",
            Settings.builder().put("xxx.tag", "B").put("xxx." + randomFrom("_ip", "_host_ip", "_publish_ip"), "192.1.1.54").build()
    }
        final DiscoveryNode node2 = new DiscoveryNode(
        filters = buildOrUpdateFromSettings(filters, AND, "xxx.", Settings.builder().put("xxx.name", "name1").build());
    public static DiscoveryNodeFilters buildFromSettings(DiscoveryNodeFilters.OpType opType, String prefix, Settings settings) {
                .build()
import static org.opensearch.cluster.node.DiscoveryNodeFilters.OpType.AND;
 * KIND, either express or implied.  See the License for the
    public void testIpPublishFilteringNotMatchingOr() {
        DiscoveryNode node = new DiscoveryNode("name1", "id1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
    }
                        }
                        DiscoveryNodeFilters currentFilters = filters.get();
            emptyMap(),
                        try {
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);
/*
        Settings settings = Settings.builder().put("xxx._id", "id1").build();
        Settings settings = Settings.builder().put("xxx.name", "name1").build();
        attributes = new HashMap<>();
    public void testIpBindFilteringNotMatchingOr() {
            buildNewFakeTransportAddress(),
            emptySet(),
                } finally {
        final DiscoveryNode node2 = new DiscoveryNode(
    private Settings shuffleSettings(Settings source) {
        AtomicBoolean keepRunning = new AtomicBoolean(true);
 * this work for additional information regarding copyright
            "name1",
        Settings settings = shuffleSettings(
 * ownership. Elasticsearch licenses this file to you under
                                "name" + i,
        String prefix,
        assertThat(filters.match(node), equalTo(true));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    for (int i = 0; i < count && keepRunning.get(); i++) {
import java.util.List;
                .put("xxx.tag", "A, B")
import org.junit.BeforeClass;
/*
        for (String o : keys) {
                        }
        assertThat(filters.match(node2), equalTo(true));
                        } catch (InterruptedException e) {
import java.net.UnknownHostException;
    }
    public void testCommaSeparatedValuesTrimmed() {
    }
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);
        attributes.put("tag", "A");
        Settings settings = shuffleSettings(
    @BeforeClass
                        filters.set(newFilters);
    }
    public void testStarMatch() {
            Future<?> t1 = executor.submit(() -> {
        assertThat(filters.match(node), equalTo(false));
 * GitHub history for details.
                            Thread.sleep(1);
                        if (i % 2 == 0) {
        assertThat(filters.match(node), equalTo(true));
 * SPDX-License-Identifier: Apache-2.0
    public void testIpPublishFilteringMatchingWildcard() {
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
        }
                            settingsBuilder.put("xxx._name", "");
        attributes.put("name", "X");
        DiscoveryNode node = new DiscoveryNode("name1", "id1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);
            Version.CURRENT
        Settings settings = Settings.builder().put("xxx._id", "id1").build();
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
        assertThat(filters.match(node2), equalTo(false));
import org.opensearch.Version;
            emptyMap(),
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
        filters = buildOrUpdateFromSettings(filters, AND, "xxx.", Settings.builder().put("xxx.name", "").put("xxx._id", "id2").build());
        assertThat(filters.match(node2), equalTo(true));
    }
 */
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, emptyMap(), emptySet(), null);
        Collections.shuffle(keys, random());
        assertThat(filters.match(node1), equalTo(true));
            "id1",
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
import java.util.Collections;
        Settings settings = shuffleSettings(Settings.builder().put("xxx._id", "id1,blah").put("xxx.name", "blah,name2").build());
 * Unless required by applicable law or agreed to in writing,
        final DiscoveryNode node1 = new DiscoveryNode(
 * the Apache License, Version 2.0 (the "License"); you may
        Settings settings = shuffleSettings(
        Map<String, String> attributes = new HashMap<>();
        Settings settings = shuffleSettings(Settings.builder().put("xxx.tag", "A").put("xxx._publish_ip", "8.8.8.8").build());
                } finally {
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);
 * You may obtain a copy of the License at
                }
    public void testOrNodeFiltersUpdate() {
import org.junit.AfterClass;
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
 * under the License.
        final DiscoveryNode node1 = new DiscoveryNode(
        assertThat(filters.match(node), equalTo(false));
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
                        DiscoveryNodeFilters newFilters = buildOrUpdateFromSettings(filters.get(), OR, "xxx.", settingsBuilder.build());
import java.util.concurrent.ExecutionException;
import org.opensearch.common.settings.Setting;
    public void testIpPublishFilteringMatchingAnd() {
        assertThat(filters.match(node2), equalTo(true));
            throw new RuntimeException(e);
        );
        assertThat(filters.match(node), equalTo(true));
        int count = 200; // I can pretty reliably reproduce failures with 200 iterations, but not 150
        assertThat(filters.match(node2), equalTo(false));
import org.opensearch.test.OpenSearchTestCase;
        assertThat(filters.match(node1), equalTo(false));
    public void testIpPublishFilteringNotMatchingAnd() {
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
 * license agreements. See the NOTICE file distributed with
        assertThat(filters.match(node1), equalTo(false));
        );
    public static void releaseLocalAddress() {
import java.util.HashMap;
        DiscoveryNode node = new DiscoveryNode("name1", "id1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), version);
import java.util.concurrent.atomic.AtomicReference;
        assertThat(filters.match(node2), equalTo(false));
            emptySet(),
        assertThat(filters.match(node), equalTo(true));
        );
        attributes.put("name", "X");
            Settings.builder().put("xxx." + randomFrom("_ip", "_host_ip", "_publish_ip"), "192.1.1.54").put("xxx.tag", "A").build()
        assertThat(filters.match(node), equalTo(true));
        DiscoveryNode node = new DiscoveryNode("name1", "id1", buildNewFakeTransportAddress(), attributes, emptySet(), Version.CURRENT);
                    keepRunning.set(false);
    }
            Settings.builder().put("xxx.tag", "A").put("xxx." + randomFrom("_ip", "_host_ip", "_publish_ip"), "8.8.8.8").build()
        } catch (AssertionError error) {
            "id2",
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
                        if (currentFilters != null) {
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);
        return DiscoveryNodeFilters.buildOrUpdateFromKeyValue(filters, opType, setting.getAsMap(settings));
                    keepRunning.set(false);
        );
 * specific language governing permissions and limitations
                                emptyMap(),
import java.util.concurrent.atomic.AtomicBoolean;
    }
        node = new DiscoveryNode("name2", "id2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        node = new DiscoveryNode("name3", "id3", buildNewFakeTransportAddress(), emptyMap(), emptySet(), version);
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);
        assertThat(filters.match(node2), equalTo(true));
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);
        Settings settings = shuffleSettings(Settings.builder().put("xxx.tag", "A").put("xxx.group", "B").build());
        assertThat(filters.match(node1), equalTo(true));
                            Thread.sleep(1);
        }
        assertThat(filters.match(node2), equalTo(false));
    public void testConcurrentModification() {
 * this file be licensed under the Apache-2.0 license or a
            t1.get();
        Settings settings = shuffleSettings(Settings.builder().put("xxx.tag", "A").put("xxx._publish_ip", "8.8.8.8").build());
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);
    }
                                buildNewFakeTransportAddress(),
        } catch (ExecutionException | InterruptedException e) {
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);
        DiscoveryNodeFilters filters,
 *
        node = new DiscoveryNode("name3", "id3", buildNewFakeTransportAddress(), attributes, emptySet(), Version.CURRENT);
            emptyMap(),
    }
        attributes.put("group", "B");
import static java.util.Collections.emptySet;
        Settings settings = shuffleSettings(Settings.builder().put("xxx._host", "192.1.1.54").build());
    @AfterClass
import java.util.ArrayList;
        DiscoveryNode node = new DiscoveryNode("", "", "", "A", "192.1.1.54", localAddress, emptyMap(), emptySet(), null);
    }
        filters = buildOrUpdateFromSettings(filters, AND, "xxx.", Settings.builder().put("xxx._id", "").build());
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
        );
import java.net.InetAddress;
    }
 */
        Settings settings = shuffleSettings(
        assertThat(filters.match(node1), equalTo(false));
                    for (int i = 0; i < count && keepRunning.get(); i++) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(filters.match(node1), equalTo(true));
                                Version.CURRENT
        assertThat(filters.match(node), equalTo(true));
        assertThat(filters.match(node), equalTo(true));
    public void testHostAddressFilteringMatchingAnd() {
        assertThat(filters.match(node), equalTo(matches));
    }
    ) {
        filters = buildOrUpdateFromSettings(filters, OR, "xxx.", Settings.builder().put("xxx.name", "name2").build());
                }
            "name1",
    }
 *
    }
import java.util.concurrent.ExecutorService;
import java.util.Map;
        assertThat(filters.match(node2), equalTo(false));
            Version.CURRENT
        assertThat(filters.match(node), equalTo(true));
    public void testIdOrNameMatch() {
/*
        node = new DiscoveryNode("name2", "id2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
    public static DiscoveryNodeFilters buildOrUpdateFromSettings(
import java.util.concurrent.Future;
        Settings settings = Settings.builder().put("xxx._id", "id1").build();
import org.opensearch.core.common.transport.TransportAddress;
package org.opensearch.cluster.node;
            Version.CURRENT
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
        Settings settings = Settings.builder().put("xxx._id", "id1").build();
            // Thread 1: repeatedly update the filters
 * not use this file except in compliance with the License.
            Settings.builder().put("xxx.tag", "A").put("xxx." + randomFrom("_ip", "_host_ip", "_publish_ip"), "192.1.1.54").build()
                    }
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);
 */
                        Settings.Builder settingsBuilder = Settings.builder().put("xxx._id", "id" + i);
        DiscoveryNodeFilters.OpType opType,
        try {
            "id1",
    public void testIpBindFilteringMatchingAnd() {
            });
            buildNewFakeTransportAddress(),
                        } catch (InterruptedException e) {
        DiscoveryNode node = new DiscoveryNode("name1", "id1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                        }
        assertTrue(filters.match(node));
        Settings settings = shuffleSettings(Settings.builder().put("xxx._host", "A").build());
    private static TransportAddress localAddress;
        assertThat(filters.match(node), equalTo(true));
        assertThat(filters.match(node), equalTo(true));
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);
        node = new DiscoveryNode("name2", "id2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), version);
        assertThat(filters.match(node2), equalTo(true));
        assertThat(filters.match(node), equalTo(false));
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "B"), emptySet(), null);
    }
        filters = buildOrUpdateFromSettings(filters, AND, "xxx.", Settings.builder().put("xxx.name", "name2").build());
        Settings settings
    }
    }
        );
        filters = buildOrUpdateFromSettings(filters, OR, "xxx.", Settings.builder().put("xxx.name", "name1").build());
            // Thread 2: repeatedly read and match nodes against the filters
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);
        assertThat(filters.match(node1), equalTo(true));
                            throw new RuntimeException(e);
    }
        );
    }
        assertThat(filters.match(node), equalTo(true));
    }
 * The OpenSearch Contributors require contributions made to
            buildOrUpdateFromSettings(filters, AND, "xxx.", Settings.builder().put("xxx.name", "name2").build());
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);
        return buildOrUpdateFromSettings(null, opType, prefix, settings);
    }
    public void testOpTypeMismatch() {
            "name2",
    public void testHostNameFilteringMatchingAnd() {
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
            buildNewFakeTransportAddress(),
            Settings.builder()
            Version.CURRENT
        }
        assertThat(filters.match(node), equalTo(true));
    public void testNameMatch() {
        attributes.put("tag", "A");
import org.opensearch.common.settings.Settings;
    }
        DiscoveryNode node = new DiscoveryNode("", "", "", "A", "192.1.1.54", localAddress, emptyMap(), emptySet(), null);
        );
import static java.util.Collections.emptyMap;
import static org.hamcrest.Matchers.equalTo;
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);
 *
                            throw new RuntimeException(e);
            Settings.builder().put("xxx.tag", "A").put("xxx." + randomFrom("_ip", "_host_ip", "_publish_ip"), "8.8.8.8").build()
                            );
        return settings.build();
    }
            settings.put(o, source.get(o));
    public void testIdMatch() {
        node = new DiscoveryNode("name4", "id4", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        );
    public void testIpBindFilteringNotMatching() {
        assertThat(filters.match(node), equalTo(false));
        attributes = new HashMap<>();
        localAddress = null;
        Settings settings = shuffleSettings(
public class DiscoveryNodeFiltersTests extends OpenSearchTestCase {
        );
        assertThat(filters.match(node), equalTo(false));
        assertThat(filters.match(node), equalTo(false));
    public void testIpBindFilteringNotMatchingAnd() {
import static org.opensearch.cluster.node.DiscoveryNodeFilters.OpType.OR;
        attributes.put("group", "B");
 * Licensed to Elasticsearch under one or more contributor
            });
                            currentFilters.match(node);
        Settings settings = shuffleSettings(Settings.builder().put("xxx.tag", "A").put("xxx._publish_ip", "192.1.1.54").build());
        assertThat(filters.match(node1), equalTo(true));
            "name2",
        List<String> keys = new ArrayList<>(source.keySet());
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);
        final Version version = Version.CURRENT;
        assertThat(filters.match(node1), equalTo(true));
    public void testTagAndGroupMatch() {
                            DiscoveryNode node = new DiscoveryNode(
                .put("xxx." + randomFrom("_ip", "_host_ip", "_publish_ip"), "192.1.1.1, 192.1.1.54")
        assertThat(filters.match(node), equalTo(false));
                try {
        Settings.Builder settings = Settings.builder();
        Settings settings = shuffleSettings(Settings.builder().put("xxx._publish_ip", matches ? "192.1.*" : "192.2.*").build());
        localAddress = new TransportAddress(InetAddress.getByName("192.1.1.54"), 9999);
import java.util.concurrent.Executors;
        Settings settings = shuffleSettings(Settings.builder().put("xxx._publish_ip", "192.1.1.54").put("xxx.tag", "A").build());
        assertThat(filters.match(node), equalTo(false));
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
    }
            emptyMap(),
            Future<?> t2 = executor.submit(() -> {
        attributes.put("group", "F");
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);
        assertThat(filters.match(node1), equalTo(false));
                try {
    }
        filters = buildOrUpdateFromSettings(filters, OR, "xxx.", Settings.builder().put("xxx.name", "name1,name2").build());
    }
                        try {
                    }
}
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);
            assertEquals("operation type should match with node filter parameter", error.getMessage());
                        } else {
        boolean matches = randomBoolean();
        Settings settings = Settings.builder().put("xxx.name", "*").build();
                        }
            buildNewFakeTransportAddress(),
            emptySet(),
        assertThat(filters.match(node), equalTo(true));
    public void testIpPublishFilteringMatchingOr() {
    public void testAndNodeFiltersUpdate() {
                                emptySet(),
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);
        AtomicReference<DiscoveryNodeFilters> filters = new AtomicReference<>();
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
    public void testIpBindFilteringMatchingOr() {
        Settings settings = shuffleSettings(
        attributes.put("tag", "A");
    public static void createLocalAddress() throws UnknownHostException {
        filters = buildOrUpdateFromSettings(filters, OR, "xxx.", Settings.builder().put("xxx._id", "").build());
                                "id" + i,
            emptySet(),
        assertThat(filters.match(node), equalTo(true));
import static java.util.Collections.singletonMap;
        Setting.AffixSetting<String> setting = Setting.prefixKeySetting(prefix, key -> Setting.simpleString(key));
            t2.get();
                            settingsBuilder.put("xxx._name", "name" + i);
