        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
        Settings settings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), "+test1,-index1").build();
    }
 * SPDX-License-Identifier: Apache-2.0
            new SystemIndices(Map.of())
            .build();
 * license agreements. See the NOTICE file distributed with
    }
    private static ClusterState buildClusterState(String... indices) {
            () -> autoCreateIndex.shouldAutoCreate(randomIndex, buildClusterState())
    }
        assertEquals(
        } catch (IllegalArgumentException ex) {
 * GitHub history for details.
            .build();
import org.opensearch.indices.SystemIndexDescriptor;
        assertEquals(5, map.size());
    public void testAutoCreationDisabled() {
        assertThat(
    }
        Metadata.Builder metadata = Metadata.builder();
        IndexNotFoundException e = expectThrows(
    }
        expectForbidden(clusterState, autoCreateIndex, "index" + randomAlphaOfLengthBetween(1, 5), "-index*");
 *
        assertThat(autoCreateIndex.getAutoCreate().isAutoCreateIndex(), equalTo(true));
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
                randomFrom(
import org.opensearch.common.settings.ClusterSettings;
    }
        if (value && randomBoolean()) {
        expectNotMatch(clusterState, autoCreateIndex, "does_not_match" + randomAlphaOfLengthBetween(1, 5));
                )
    }
 * Unless required by applicable law or agreed to in writing,
        Settings settings = Settings.builder()
        boolean value = randomBoolean();
    public void testHandleSpaces() { // see #21449
            .build();
 */
        Settings settings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), true).build();
 * software distributed under the License is distributed on an
        Settings settings = Settings.builder()
    public void testAutoCreationMultipleIndexNames() {
            .put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), "+test1,-test1,-test2,+test2")
        assertTrue(map.get(".watches"));
        /* When patterns are specified, even if the are all negative, the default is can't create. So a pure negative pattern is the same
        assertThat(autoCreateIndex.getAutoCreate().isAutoCreateIndex(), equalTo(value));
            .build();
        assertThat(autoCreateIndex.shouldAutoCreate("test2", clusterState), equalTo(true));
    private void expectNotMatch(ClusterState clusterState, AutoCreateIndex autoCreateIndex, String index) {
        Settings settings = Settings.builder()
 * Licensed to Elasticsearch under one or more contributor
        }
         * as false, really. */
            fail("initialization should have failed");
    }
        assertThat(autoCreateIndex.shouldAutoCreate("test1", clusterState), equalTo(true));
        AutoCreateIndex autoCreateIndex = new AutoCreateIndex(
}
 * not use this file except in compliance with the License.
    private void expectForbidden(ClusterState clusterState, AutoCreateIndex autoCreateIndex, String index, String forbiddingPattern) {
public class AutoCreateIndexTests extends OpenSearchTestCase {
        assertTrue(map.get(".triggered_watches"));
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder()).build();
    }
        assertThat(autoCreateIndex.shouldAutoCreate(TEST_SYSTEM_INDEX_NAME, buildClusterState()), equalTo(true));
        clusterSettings.applySettings(newSettings);
        assertEquals(
            .put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), "-" + TEST_SYSTEM_INDEX_NAME + "*")
 * this file be licensed under the Apache-2.0 license or a
        Settings settings = Settings.builder()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testAutoCreationPatternDisabled() {
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
        assertTrue(map.get(".marvel-"));
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
        return new AutoCreateIndex(
        try {
 *
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder()).build();
            fail("initialization should have failed");
    public void testDefaultAutoCreation() {
                    + "comma separated list of index patterns]",
            assertEquals(
            .put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), randomFrom("+index*", "index*"))
                ex.getMessage()
        try {
import org.opensearch.index.IndexNotFoundException;
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        assertThat(autoCreateIndex.shouldAutoCreate("test" + randomAlphaOfLengthBetween(1, 5), clusterState), equalTo(true));
        IndexNotFoundException e = expectThrows(IndexNotFoundException.class, () -> autoCreateIndex.shouldAutoCreate(index, clusterState));
        );
import java.util.HashMap;
    }
            .build();
    public void testAutoCreationSystemIndexPatternDisabled() {
import org.opensearch.test.OpenSearchTestCase;
    }
 * this work for additional information regarding copyright
        Settings settings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), "test1,test2").build();
            );
        } catch (IllegalArgumentException ex) {
        List<Tuple<String, Boolean>> expressions = autoCreateIndex.getAutoCreate().getExpressions();
 * under the License.
        assertTrue(map.get(".security"));
            settings,
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder()).build();
        expectNotMatch(clusterState, autoCreateIndex, "does_not_match" + randomAlphaOfLengthBetween(1, 5));
 * The OpenSearch Contributors require contributions made to
            equalTo(false)
                ex.getMessage()
    }
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
    public void testSystemIndexWithAutoCreationDisabled() {
package org.opensearch.action.support;
            .put(
            settings,
import org.opensearch.common.settings.Settings;
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
        } else {
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder()).build();
 *    http://www.apache.org/licenses/LICENSE-2.0
                AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(),
        }
            settings = Settings.EMPTY;
                "Can't parse [" + prefix + "] for setting [action.auto_create_index] must contain an index name after [" + prefix + "]",
    public void testAutoCreationConflictingPatternsFirstWins() {
        String randomIndex = randomAlphaOfLengthBetween(1, 10);
    private static final String TEST_SYSTEM_INDEX_NAME = ".test-system-index";
            e.getMessage()
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
        expectNotMatch(clusterState, autoCreateIndex, "does_not_match" + randomAlphaOfLengthBetween(1, 5));
                    ".marvel-,.security,.watches,.triggered_watches,.watcher-history-"
 *
        for (Tuple<String, Boolean> t : expressions) {
            .build();
 * ownership. Elasticsearch licenses this file to you under
        expectNotMatch(clusterState, autoCreateIndex, "index" + randomAlphaOfLengthBetween(1, 5));
    }
    public void testAutoCreationEnabled() {
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
        expectNotMatch(clusterState, autoCreateIndex, "does_not_match" + randomAlphaOfLengthBetween(1, 5));
        expectNotMatch(clusterState, autoCreateIndex, "does_not_match" + randomAlphaOfLengthBetween(1, 5));
        Map<String, Boolean> map = new HashMap<>();
        Settings settings = Settings.builder()
        );
            .build();
            newAutoCreateIndex(settings);
import org.opensearch.indices.SystemIndices;
        Settings settings;
        newSettings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), "logs-*").build();
        assertEquals("no such index [" + randomIndex + "] and [action.auto_create_index] is [false]", e.getMessage());
            Settings settings = Settings.builder().put("action.auto_create_index", ",,,").build();
import org.opensearch.Version;
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
            newAutoCreateIndex(settings);
 */
    public void testParseFailedMissingIndex() {
                    ".marvel-, .security, .watches, .triggered_watches, .watcher-history-",
        assertThat(autoCreateIndex.shouldAutoCreate("index" + randomAlphaOfLengthBetween(1, 5), clusterState), equalTo(true));
    }
                + index
    }
import org.opensearch.cluster.ClusterState;
/*
            systemIndices
        clusterSettings.applySettings(newSettings);
        assertThat(autoCreateIndex.shouldAutoCreate(randomAlphaOfLengthBetween(1, 10), buildClusterState()), equalTo(true));
import java.util.List;
 * specific language governing permissions and limitations
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(Settings.EMPTY);
        expectForbidden(clusterState, autoCreateIndex, "test2", "-test2");
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder()).build();
        expectNotMatch(clusterState, autoCreateIndex, "does_not_match" + randomAlphaOfLengthBetween(1, 5));
            );
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
            settings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), value).build();
        SystemIndices systemIndices = new SystemIndices(Map.of("plugin", List.of(new SystemIndexDescriptor(TEST_SYSTEM_INDEX_NAME, ""))));
            metadata.put(IndexMetadata.builder(index).settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1));
        assertThat(autoCreateIndex.shouldAutoCreate(randomAlphaOfLengthBetween(1, 10), buildClusterState()), equalTo(true));
        for (String index : indices) {
            .put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), randomFrom("+test*,-index*", "test*,-index*"))
            "no such index [" + index + "] and [action.auto_create_index] ([" + autoCreateIndex.getAutoCreate() + "]) doesn't match",
            map.put(t.v1(), t.v2());
import org.opensearch.cluster.ClusterName;
import org.opensearch.common.util.concurrent.ThreadContext;
        IndexNotFoundException e = expectThrows(IndexNotFoundException.class, () -> autoCreateIndex.shouldAutoCreate(index, clusterState));
        }
                + "] and [action.auto_create_index] contains ["
        assertThat(autoCreateIndex.getAutoCreate().getExpressions().get(0).v1(), equalTo("logs-*"));
import org.opensearch.cluster.metadata.IndexMetadata;
            "no such index ["
        );
import org.opensearch.common.collect.Tuple;
            assertEquals(
    public void testAutoCreationPatternEnabled() {
        assertThat(autoCreateIndex.getAutoCreate().isAutoCreateIndex(), equalTo(!value));
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder()).build();
        Settings settings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), "-index*").build();
        expectForbidden(clusterState, autoCreateIndex, "index" + randomAlphaOfLengthBetween(1, 5), "-index*");
        );
            )
        Settings settings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), false).build();
        expectNotMatch(clusterState, autoCreateIndex, "test" + randomAlphaOfLengthBetween(2, 5));
            e.getMessage()
    public void testExistingIndex() {
                + forbiddingPattern
            IndexNotFoundException.class,
/*
            clusterSettings,
import org.opensearch.cluster.metadata.Metadata;
        assertThat(autoCreateIndex.shouldAutoCreate("test1", clusterState), equalTo(true));
 * Modifications Copyright OpenSearch Contributors. See
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
        }
            autoCreateIndex.shouldAutoCreate(randomFrom("index1", "index2", "index3"), buildClusterState("index1", "index2", "index3")),
import static org.hamcrest.CoreMatchers.equalTo;
        assertTrue(map.get(".watcher-history-"));
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
    public void testUpdate() {
        Settings settings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), false).build();
 * compatible open source license.
        Settings settings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), prefix).build();
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                + "] which forbids automatic creation of the index",
 */
        assertThat(autoCreateIndex.shouldAutoCreate(TEST_SYSTEM_INDEX_NAME, buildClusterState()), equalTo(true));
        return ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        String prefix = randomFrom("+", "-");
import java.util.Map;
 * You may obtain a copy of the License at
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
    }
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
    public void testAutoCreationMultiplePatternsNoWildcards() {
        );
        );
        assertThat(autoCreateIndex.getAutoCreate().getExpressions().size(), equalTo(1));
        assertThat(autoCreateIndex.shouldAutoCreate("test1", clusterState), equalTo(true));
        Settings newSettings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), !value).build();
    public void testAutoCreationMultiplePatternsWithWildcards() {
    public void testParseFailed() {
    }
        }
/*
            .put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), randomFrom(true, false, randomAlphaOfLengthBetween(7, 10)).toString())
            .metadata(metadata)
        Settings settings = Settings.builder()
                "Can't parse [,,,] for setting [action.auto_create_index] must be either [true, false, or a "
    private AutoCreateIndex newAutoCreateIndex(Settings settings) {
    }
