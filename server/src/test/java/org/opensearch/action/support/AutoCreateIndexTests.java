        assertThat(autoCreateIndex.shouldAutoCreate("index" + randomAlphaOfLengthBetween(1, 5), clusterState), equalTo(true));  
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(Settings.EMPTY);  
            .build();
        IndexNotFoundException e = expectThrows(
            settings = Settings.EMPTY;
        Settings settings = Settings.builder()  
    public void testAutoCreationEnabled() {
    private AutoCreateIndex newAutoCreateIndex(Settings settings) {  
        assertTrue(map.get(".marvel-"));
                ex.getMessage()
                )
            settings,
                "Can't parse [,,,] for setting [action.auto_create_index] must be either [true, false, or a "  
        } else {
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
    }
            metadata.put(IndexMetadata.builder(index).settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1));
        assertEquals(
                    ".marvel-,.security,.watches,.triggered_watches,.watcher-history-"  
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);  
        assertThat(autoCreateIndex.shouldAutoCreate(TEST_SYSTEM_INDEX_NAME, buildClusterState()), equalTo(true));
 */  
    public void testDefaultAutoCreation() {
    }  
        expectForbidden(clusterState, autoCreateIndex, "test2", "-test2");
    }
    public void testAutoCreationConflictingPatternsFirstWins() {
 * not use this file except in compliance with the License.
        String prefix = randomFrom("+", "-");
    public void testHandleSpaces() { // see #21449  
        assertThat(autoCreateIndex.getAutoCreate().getExpressions().size(), equalTo(1));
    }
import org.opensearch.index.IndexNotFoundException;
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
        assertThat(  
        clusterSettings.applySettings(newSettings);
 * specific language governing permissions and limitations
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
        clusterSettings.applySettings(newSettings);
        assertTrue(map.get(".watcher-history-"));
        Settings settings = Settings.builder()
            );
            .put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), randomFrom("+test*,-index*", "test*,-index*"))  
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
 *
            .build();
        expectNotMatch(clusterState, autoCreateIndex, "does_not_match" + randomAlphaOfLengthBetween(1, 5));
            autoCreateIndex.shouldAutoCreate(randomFrom("index1", "index2", "index3"), buildClusterState("index1", "index2", "index3")),
 * software distributed under the License is distributed on an
    }
        assertThat(autoCreateIndex.shouldAutoCreate("test" + randomAlphaOfLengthBetween(1, 5), clusterState), equalTo(true));
        expectForbidden(clusterState, autoCreateIndex, "index" + randomAlphaOfLengthBetween(1, 5), "-index*");
        );
    public void testAutoCreationDisabled() {  
        Settings settings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), prefix).build();  
        expectForbidden(clusterState, autoCreateIndex, "index" + randomAlphaOfLengthBetween(1, 5), "-index*");
 *  
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
                ex.getMessage()
            e.getMessage()
        expectNotMatch(clusterState, autoCreateIndex, "does_not_match" + randomAlphaOfLengthBetween(1, 5));  
 * Unless required by applicable law or agreed to in writing,
    }  
        assertThat(autoCreateIndex.shouldAutoCreate(randomAlphaOfLengthBetween(1, 10), buildClusterState()), equalTo(true));
        assertThat(autoCreateIndex.shouldAutoCreate("test1", clusterState), equalTo(true));
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
            Settings settings = Settings.builder().put("action.auto_create_index", ",,,").build();
        } catch (IllegalArgumentException ex) {
    }
    public void testAutoCreationMultiplePatternsNoWildcards() {  
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
                    + "comma separated list of index patterns]",
        expectNotMatch(clusterState, autoCreateIndex, "test" + randomAlphaOfLengthBetween(2, 5));  
            .put(
import org.opensearch.indices.SystemIndices;
        AutoCreateIndex autoCreateIndex = new AutoCreateIndex(
import org.opensearch.common.collect.Tuple;
            fail("initialization should have failed");  
    }
        Settings settings = Settings.builder()
    public void testExistingIndex() {
        IndexNotFoundException e = expectThrows(IndexNotFoundException.class, () -> autoCreateIndex.shouldAutoCreate(index, clusterState));
/*  
        );  
 *
        }  
    private static ClusterState buildClusterState(String... indices) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.Version;
import java.util.Map;  
        try {
                + index
 * compatible open source license.
        SystemIndices systemIndices = new SystemIndices(Map.of("plugin", List.of(new SystemIndexDescriptor(TEST_SYSTEM_INDEX_NAME, ""))));
            systemIndices  
        expectNotMatch(clusterState, autoCreateIndex, "does_not_match" + randomAlphaOfLengthBetween(1, 5));
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);  
        Metadata.Builder metadata = Metadata.builder();  
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder()).build();
        return ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
                + "] which forbids automatic creation of the index",
            newAutoCreateIndex(settings);
            .put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), "+test1,-test1,-test2,+test2")  
public class AutoCreateIndexTests extends OpenSearchTestCase {
/*  
            .put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), randomFrom(true, false, randomAlphaOfLengthBetween(7, 10)).toString())  
                + "] and [action.auto_create_index] contains ["
import org.opensearch.cluster.metadata.IndexMetadata;
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);  
/*
        assertThat(autoCreateIndex.getAutoCreate().isAutoCreateIndex(), equalTo(true));  
 * KIND, either express or implied.  See the License for the
            );  
    public void testAutoCreationPatternEnabled() {  
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder()).build();  
                    ".marvel-, .security, .watches, .triggered_watches, .watcher-history-",
import java.util.HashMap;
import org.opensearch.indices.SystemIndexDescriptor;  
        Settings settings = Settings.builder()
    }
            .build();  
    }
import org.opensearch.cluster.metadata.Metadata;  
        assertEquals(5, map.size());  
                + forbiddingPattern  
        assertTrue(map.get(".security"));
         * as false, really. */
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
        assertThat(autoCreateIndex.shouldAutoCreate("test2", clusterState), equalTo(true));  
 * this file be licensed under the Apache-2.0 license or a
            .put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), "-" + TEST_SYSTEM_INDEX_NAME + "*")
                "Can't parse [" + prefix + "] for setting [action.auto_create_index] must contain an index name after [" + prefix + "]",  
        } catch (IllegalArgumentException ex) {
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
            "no such index ["  
        Settings settings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), "-index*").build();
import java.util.List;
 * this work for additional information regarding copyright
    }
    public void testUpdate() {  
            )
        Map<String, Boolean> map = new HashMap<>();  
            new SystemIndices(Map.of())
    }  
        assertTrue(map.get(".watches"));  
        assertThat(autoCreateIndex.getAutoCreate().getExpressions().get(0).v1(), equalTo("logs-*"));
        Settings settings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), true).build();  
        }  
    public void testAutoCreationPatternDisabled() {
            newAutoCreateIndex(settings);
 * license agreements. See the NOTICE file distributed with
                randomFrom(
 */  
        Settings settings = Settings.builder()
    private static final String TEST_SYSTEM_INDEX_NAME = ".test-system-index";  
            .build();
        Settings settings = Settings.builder()
        return new AutoCreateIndex(
            () -> autoCreateIndex.shouldAutoCreate(randomIndex, buildClusterState())  
        assertEquals("no such index [" + randomIndex + "] and [action.auto_create_index] is [false]", e.getMessage());
        );  
        assertThat(autoCreateIndex.shouldAutoCreate(randomAlphaOfLengthBetween(1, 10), buildClusterState()), equalTo(true));
 * Licensed to Elasticsearch under one or more contributor  
            .build();
            .metadata(metadata)
import org.opensearch.common.util.concurrent.ThreadContext;
}
            .build();  
        Settings settings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), false).build();  
import org.opensearch.common.settings.Settings;  
 * You may obtain a copy of the License at  
    }
            "no such index [" + index + "] and [action.auto_create_index] ([" + autoCreateIndex.getAutoCreate() + "]) doesn't match",
        assertThat(autoCreateIndex.shouldAutoCreate("test1", clusterState), equalTo(true));
        Settings settings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), false).build();
    public void testSystemIndexWithAutoCreationDisabled() {
        Settings settings;
import org.opensearch.test.OpenSearchTestCase;
    }
 * GitHub history for details.
        String randomIndex = randomAlphaOfLengthBetween(1, 10);  
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder()).build();  
        expectNotMatch(clusterState, autoCreateIndex, "index" + randomAlphaOfLengthBetween(1, 5));
        newSettings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), "logs-*").build();
        List<Tuple<String, Boolean>> expressions = autoCreateIndex.getAutoCreate().getExpressions();
    }
    public void testAutoCreationMultipleIndexNames() {
            e.getMessage()
import org.opensearch.common.settings.ClusterSettings;
 */
    public void testParseFailedMissingIndex() {
            .put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), randomFrom("+index*", "index*"))
        if (value && randomBoolean()) {  
        for (String index : indices) {
    private void expectNotMatch(ClusterState clusterState, AutoCreateIndex autoCreateIndex, String index) {
        expectNotMatch(clusterState, autoCreateIndex, "does_not_match" + randomAlphaOfLengthBetween(1, 5));
        );
    public void testAutoCreationSystemIndexPatternDisabled() {
    }
            settings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), value).build();  
        IndexNotFoundException e = expectThrows(IndexNotFoundException.class, () -> autoCreateIndex.shouldAutoCreate(index, clusterState));
import org.opensearch.cluster.ClusterState;  
        }  
            fail("initialization should have failed");  
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder()).build();  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        );  
            map.put(t.v1(), t.v2());
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder()).build();
            .build();  
        assertTrue(map.get(".triggered_watches"));
            settings,  
        Settings settings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), "test1,test2").build();
    public void testAutoCreationMultiplePatternsWithWildcards() {
        assertEquals(  
            clusterSettings,  
        /* When patterns are specified, even if the are all negative, the default is can't create. So a pure negative pattern is the same  
        try {  
        expectNotMatch(clusterState, autoCreateIndex, "does_not_match" + randomAlphaOfLengthBetween(1, 5));
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder()).build();
        assertThat(autoCreateIndex.getAutoCreate().isAutoCreateIndex(), equalTo(value));
    }
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.CoreMatchers.equalTo;
            assertEquals(
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
        Settings settings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), "+test1,-index1").build();
        Settings newSettings = Settings.builder().put(AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(), !value).build();  
package org.opensearch.action.support;
        for (Tuple<String, Boolean> t : expressions) {
        );  
        expectNotMatch(clusterState, autoCreateIndex, "does_not_match" + randomAlphaOfLengthBetween(1, 5));  
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        AutoCreateIndex autoCreateIndex = newAutoCreateIndex(settings);
                AutoCreateIndex.AUTO_CREATE_INDEX_SETTING.getKey(),  
import org.opensearch.cluster.ClusterName;
        }
 * SPDX-License-Identifier: Apache-2.0
        assertThat(autoCreateIndex.getAutoCreate().isAutoCreateIndex(), equalTo(!value));
        assertThat(autoCreateIndex.shouldAutoCreate("test1", clusterState), equalTo(true));
 * Modifications Copyright OpenSearch Contributors. See
    }  
    }
    }  
            IndexNotFoundException.class,
    private void expectForbidden(ClusterState clusterState, AutoCreateIndex autoCreateIndex, String index, String forbiddingPattern) {  
            assertEquals(
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(autoCreateIndex.shouldAutoCreate(TEST_SYSTEM_INDEX_NAME, buildClusterState()), equalTo(true));
    public void testParseFailed() {
            equalTo(false)
        boolean value = randomBoolean();
        }
