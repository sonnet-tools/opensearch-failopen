                                buildNewFakeTransportAddress(),  
    public void testIpPublishFilteringNotMatchingAnd() {
import org.opensearch.core.common.transport.TransportAddress;
        );
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
    public void testCommaSeparatedValuesTrimmed() {
import java.util.List;
                            );
import java.util.concurrent.ExecutorService;
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);
        Settings settings = Settings.builder().put("xxx._id", "id1").build();
        assertThat(filters.match(node2), equalTo(false));
    }  
            Settings.builder().put("xxx.tag", "B").put("xxx." + randomFrom("_ip", "_host_ip", "_publish_ip"), "192.1.1.54").build()  
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);
        }  
                .put("xxx.tag", "A, B")
        assertThat(filters.match(node), equalTo(false));  
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);
import java.util.concurrent.Executors;  
        DiscoveryNode node = new DiscoveryNode("name1", "id1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
                    for (int i = 0; i < count && keepRunning.get(); i++) {  
        assertThat(filters.match(node2), equalTo(false));  
            buildOrUpdateFromSettings(filters, AND, "xxx.", Settings.builder().put("xxx.name", "name2").build());
        final DiscoveryNode node1 = new DiscoveryNode(
/*  
        DiscoveryNodeFilters.OpType opType,
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);  
        assertThat(filters.match(node2), equalTo(false));
import java.net.InetAddress;  
            "name1",
        assertThat(filters.match(node), equalTo(true));  
        return DiscoveryNodeFilters.buildOrUpdateFromKeyValue(filters, opType, setting.getAsMap(settings));  
        Settings settings = shuffleSettings(Settings.builder().put("xxx.tag", "A").put("xxx._publish_ip", "192.1.1.54").build());  
        assertThat(filters.match(node), equalTo(false));  
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);  
import static java.util.Collections.singletonMap;
                        if (currentFilters != null) {
    public void testIpPublishFilteringMatchingOr() {  
    @BeforeClass
                try {
        Settings settings = shuffleSettings(Settings.builder().put("xxx.tag", "A").put("xxx.group", "B").build());
        assertThat(filters.match(node1), equalTo(true));  
            emptySet(),  
        attributes.put("group", "B");  
                    keepRunning.set(false);
    public void testOrNodeFiltersUpdate() {
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
        assertThat(filters.match(node), equalTo(true));  
        assertThat(filters.match(node), equalTo(true));
    private static TransportAddress localAddress;
 * SPDX-License-Identifier: Apache-2.0
                            Thread.sleep(1);
        String prefix,
        );
    }
        localAddress = new TransportAddress(InetAddress.getByName("192.1.1.54"), 9999);  
        }  
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {  
        assertThat(filters.match(node), equalTo(false));  
            Settings.builder().put("xxx.tag", "A").put("xxx." + randomFrom("_ip", "_host_ip", "_publish_ip"), "8.8.8.8").build()  
    private Settings shuffleSettings(Settings source) {  
        Settings settings = Settings.builder().put("xxx.name", "*").build();
                        } catch (InterruptedException e) {  
import java.net.UnknownHostException;
                try {  
    }
 * ownership. Elasticsearch licenses this file to you under  
                                Version.CURRENT  
        Settings settings = shuffleSettings(
        assertThat(filters.match(node), equalTo(true));
 */
        );  
        filters = buildOrUpdateFromSettings(filters, AND, "xxx.", Settings.builder().put("xxx.name", "name1").build());
        assertThat(filters.match(node2), equalTo(true));
 *
import java.util.concurrent.atomic.AtomicReference;  
        List<String> keys = new ArrayList<>(source.keySet());
                        filters.set(newFilters);  
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "B"), emptySet(), null);  
                    }  
            Version.CURRENT
            // Thread 2: repeatedly read and match nodes against the filters  
        localAddress = null;
        Settings settings = shuffleSettings(
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);  
        Settings settings = shuffleSettings(Settings.builder().put("xxx._host", "A").build());  
                            throw new RuntimeException(e);
        return settings.build();
        node = new DiscoveryNode("name4", "id4", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
    }
        Setting.AffixSetting<String> setting = Setting.prefixKeySetting(prefix, key -> Setting.simpleString(key));
    public void testStarMatch() {
 * Unless required by applicable law or agreed to in writing,
                        DiscoveryNodeFilters currentFilters = filters.get();
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);
    public void testAndNodeFiltersUpdate() {  
            throw new RuntimeException(e);
            emptyMap(),  
 * license agreements. See the NOTICE file distributed with
        assertThat(filters.match(node2), equalTo(true));
                        if (i % 2 == 0) {  
        assertThat(filters.match(node), equalTo(true));
                .put("xxx." + randomFrom("_ip", "_host_ip", "_publish_ip"), "192.1.1.1, 192.1.1.54")
 * The OpenSearch Contributors require contributions made to  
import org.junit.AfterClass;  
        Settings settings = shuffleSettings(Settings.builder().put("xxx._publish_ip", "192.1.1.54").put("xxx.tag", "A").build());
        assertThat(filters.match(node1), equalTo(false));
    public void testNameMatch() {
            "name1",
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
    public void testIpPublishFilteringMatchingWildcard() {
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);  
    }
                                "name" + i,
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);
import org.opensearch.common.settings.Setting;
            emptyMap(),
                            throw new RuntimeException(e);
        assertThat(filters.match(node2), equalTo(true));
        assertThat(filters.match(node1), equalTo(true));  
    public void testIpBindFilteringMatchingOr() {  
        node = new DiscoveryNode("name2", "id2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
            t1.get();  
import static java.util.Collections.emptyMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.opensearch.common.settings.Settings;  
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, emptyMap(), emptySet(), null);
    public void testTagAndGroupMatch() {  
            Version.CURRENT  
                        }
            Settings.builder().put("xxx." + randomFrom("_ip", "_host_ip", "_publish_ip"), "192.1.1.54").put("xxx.tag", "A").build()
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
        Collections.shuffle(keys, random());  
import java.util.concurrent.Future;
        );
    public void testHostNameFilteringMatchingAnd() {
        assertThat(filters.match(node), equalTo(true));
        DiscoveryNode node = new DiscoveryNode("name1", "id1", buildNewFakeTransportAddress(), attributes, emptySet(), Version.CURRENT);
            // Thread 1: repeatedly update the filters
}
 * under the License.  
    }  
        assertThat(filters.match(node), equalTo(false));
            Settings.builder()  
                            settingsBuilder.put("xxx._name", "");
        assertThat(filters.match(node1), equalTo(true));  
    public void testIpPublishFilteringMatchingAnd() {
 *
/*  
                            settingsBuilder.put("xxx._name", "name" + i);  
    }
        );
    }
        Settings settings = shuffleSettings(
 * this file be licensed under the Apache-2.0 license or a
        try {
        assertThat(filters.match(node2), equalTo(false));
            settings.put(o, source.get(o));
        Settings settings = Settings.builder().put("xxx._id", "id1").build();
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
    public static void releaseLocalAddress() {
        assertThat(filters.match(node), equalTo(false));
        node = new DiscoveryNode("name3", "id3", buildNewFakeTransportAddress(), attributes, emptySet(), Version.CURRENT);  
        );  
    }
        } catch (ExecutionException | InterruptedException e) {
                                emptySet(),
        assertThat(filters.match(node), equalTo(true));
                }  
        assertThat(filters.match(node), equalTo(true));
            emptyMap(),
        DiscoveryNodeFilters filters,  
        );
    public static DiscoveryNodeFilters buildOrUpdateFromSettings(
        assertThat(filters.match(node), equalTo(false));
                            DiscoveryNode node = new DiscoveryNode(  
        DiscoveryNode node = new DiscoveryNode("", "", "", "A", "192.1.1.54", localAddress, emptyMap(), emptySet(), null);  
            Settings.builder().put("xxx.tag", "A").put("xxx." + randomFrom("_ip", "_host_ip", "_publish_ip"), "8.8.8.8").build()
        assertThat(filters.match(node), equalTo(true));  
        attributes.put("tag", "A");
            emptySet(),
        assertThat(filters.match(node), equalTo(true));
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);  
        filters = buildOrUpdateFromSettings(filters, OR, "xxx.", Settings.builder().put("xxx.name", "name1,name2").build());
        node = new DiscoveryNode("name2", "id2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), version);
    }  
                        Settings.Builder settingsBuilder = Settings.builder().put("xxx._id", "id" + i);
            });
        assertTrue(filters.match(node));  
            t2.get();
                    keepRunning.set(false);
        assertThat(filters.match(node), equalTo(matches));
        filters = buildOrUpdateFromSettings(filters, AND, "xxx.", Settings.builder().put("xxx.name", "name2").build());  
    }
        Settings settings = shuffleSettings(
import java.util.Collections;  
            assertEquals("operation type should match with node filter parameter", error.getMessage());
            });
 *     http://www.apache.org/licenses/LICENSE-2.0
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);
    }
            emptySet(),  
                        }  
        Settings settings  
        attributes = new HashMap<>();
        Map<String, String> attributes = new HashMap<>();
    public void testIdOrNameMatch() {  
            "id1",  
import static org.opensearch.cluster.node.DiscoveryNodeFilters.OpType.AND;
        attributes = new HashMap<>();
 * software distributed under the License is distributed on an
    }
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);  
    public void testIdMatch() {
        assertThat(filters.match(node1), equalTo(true));
        int count = 200; // I can pretty reliably reproduce failures with 200 iterations, but not 150
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    }  
        assertThat(filters.match(node1), equalTo(false));
        assertThat(filters.match(node2), equalTo(true));
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);  
import org.opensearch.test.OpenSearchTestCase;
        }
        assertThat(filters.match(node), equalTo(true));  
        assertThat(filters.match(node), equalTo(true));  
    public void testIpBindFilteringNotMatchingAnd() {
        AtomicReference<DiscoveryNodeFilters> filters = new AtomicReference<>();  
    ) {
        final DiscoveryNode node1 = new DiscoveryNode(  
                        }
                .build()  
            buildNewFakeTransportAddress(),
                } finally {
        DiscoveryNode node = new DiscoveryNode("name1", "id1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
import java.util.Map;  
    public static DiscoveryNodeFilters buildFromSettings(DiscoveryNodeFilters.OpType opType, String prefix, Settings settings) {
        Settings settings = shuffleSettings(Settings.builder().put("xxx.tag", "A").put("xxx._publish_ip", "8.8.8.8").build());
    public void testIpBindFilteringNotMatching() {
    @AfterClass  
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);
            emptySet(),
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);
        attributes.put("name", "X");
    public void testConcurrentModification() {
        final DiscoveryNode node2 = new DiscoveryNode(
        Settings settings = Settings.builder().put("xxx.name", "name1").build();  
    }
                                "id" + i,
    public void testIpBindFilteringMatchingAnd() {  
        Settings settings = shuffleSettings(Settings.builder().put("xxx._host", "192.1.1.54").build());
        filters = buildOrUpdateFromSettings(filters, AND, "xxx.", Settings.builder().put("xxx.name", "").put("xxx._id", "id2").build());  
            Version.CURRENT
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);
        filters = buildOrUpdateFromSettings(filters, OR, "xxx.", Settings.builder().put("xxx.name", "name2").build());
            buildNewFakeTransportAddress(),
        for (String o : keys) {
    }  
        DiscoveryNodeFilters filters = buildFromSettings(AND, "xxx.", settings);
    }
        attributes.put("tag", "A");  
    }  
        attributes.put("tag", "A");
    public void testHostAddressFilteringMatchingAnd() {
        Settings settings = shuffleSettings(
            "id2",  
        Settings settings = shuffleSettings(  
    public void testIpBindFilteringNotMatchingOr() {
                        DiscoveryNodeFilters newFilters = buildOrUpdateFromSettings(filters.get(), OR, "xxx.", settingsBuilder.build());
    }  
import org.junit.BeforeClass;
        Settings settings = shuffleSettings(Settings.builder().put("xxx._id", "id1,blah").put("xxx.name", "blah,name2").build());
        } catch (AssertionError error) {  
        filters = buildOrUpdateFromSettings(filters, AND, "xxx.", Settings.builder().put("xxx._id", "").build());
        node = new DiscoveryNode("name2", "id2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                                emptyMap(),
                }  
        Settings.Builder settings = Settings.builder();
        );
                            currentFilters.match(node);
        final DiscoveryNode node2 = new DiscoveryNode(
                    for (int i = 0; i < count && keepRunning.get(); i++) {
    }
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
        attributes.put("group", "F");
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
public class DiscoveryNodeFiltersTests extends OpenSearchTestCase {  
        node = new DiscoveryNode("name2", "id2", buildNewFakeTransportAddress(), attributes, emptySet(), Version.CURRENT);
    }  
    }
        filters = buildOrUpdateFromSettings(filters, OR, "xxx.", Settings.builder().put("xxx.name", "name1").build());
 */  
        final Version version = Version.CURRENT;
            "id2",
    public void testIpPublishFilteringNotMatchingOr() {  
            Future<?> t1 = executor.submit(() -> {
        Settings settings = Settings.builder().put("xxx._id", "id1").build();  
        assertThat(filters.match(node2), equalTo(false));  
 * not use this file except in compliance with the License.
import java.util.HashMap;
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);  
            buildNewFakeTransportAddress(),
        Settings settings = shuffleSettings(Settings.builder().put("xxx.tag", "A").put("xxx._publish_ip", "8.8.8.8").build());
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);
        assertThat(filters.match(node), equalTo(true));  
        assertThat(filters.match(node), equalTo(false));
            Version.CURRENT
        assertThat(filters.match(node2), equalTo(true));  
            buildNewFakeTransportAddress(),  
        );
                            Thread.sleep(1);
        attributes.put("name", "X");
        Settings settings = Settings.builder().put("xxx._id", "id1").build();
        assertThat(filters.match(node), equalTo(false));  
        DiscoveryNode node = new DiscoveryNode("name1", "id1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), version);
 * specific language governing permissions and limitations
                        try {
            emptyMap(),
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
    public static void createLocalAddress() throws UnknownHostException {
    }  
        assertThat(filters.match(node1), equalTo(false));
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
package org.opensearch.cluster.node;
import org.opensearch.Version;
 * GitHub history for details.
/*
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
import static org.opensearch.cluster.node.DiscoveryNodeFilters.OpType.OR;  
                        } else {
 */  
import static java.util.Collections.emptySet;  
                        try {
    }
        DiscoveryNode node = new DiscoveryNode("", "", "", "A", "192.1.1.54", localAddress, emptyMap(), emptySet(), null);
import java.util.concurrent.ExecutionException;
        );  
    }
    }
            "name2",  
                        }
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);
    public void testOpTypeMismatch() {
        assertThat(filters.match(node), equalTo(true));
        DiscoveryNode node = new DiscoveryNode("name1", "id1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        boolean matches = randomBoolean();  
 * KIND, either express or implied.  See the License for the
        assertThat(filters.match(node1), equalTo(true));
        assertThat(filters.match(node1), equalTo(false));
        DiscoveryNodeFilters filters = buildFromSettings(OR, "xxx.", settings);
        AtomicBoolean keepRunning = new AtomicBoolean(true);
    }  
        DiscoveryNode node = new DiscoveryNode("", "", "", "", "192.1.1.54", localAddress, singletonMap("tag", "A"), emptySet(), null);  
import java.util.ArrayList;
        return buildOrUpdateFromSettings(null, opType, prefix, settings);
        filters = buildOrUpdateFromSettings(filters, OR, "xxx.", Settings.builder().put("xxx._id", "").build());  
            "name2",
        node = new DiscoveryNode("name3", "id3", buildNewFakeTransportAddress(), emptyMap(), emptySet(), version);
 *  
            "id1",
        Settings settings = shuffleSettings(Settings.builder().put("xxx._publish_ip", matches ? "192.1.*" : "192.2.*").build());
        assertThat(filters.match(node), equalTo(true));
        assertThat(filters.match(node1), equalTo(true));  
    }
            Future<?> t2 = executor.submit(() -> {
            Settings.builder().put("xxx.tag", "A").put("xxx." + randomFrom("_ip", "_host_ip", "_publish_ip"), "192.1.1.54").build()
import static org.hamcrest.Matchers.equalTo;
                } finally {
 * You may obtain a copy of the License at  
 * compatible open source license.
        attributes.put("group", "B");  
                        } catch (InterruptedException e) {  
