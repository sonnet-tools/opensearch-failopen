        public List<String> getSettingsFilter() {  
 * The OpenSearch Contributors require contributions made to  
                .prepareCreate("test-idx")  
 * the Apache License, Version 2.0 (the "License"); you may
            "some.node.setting",
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
        }  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
            Settings settings = info.getSettings();
        }
            Property.Filtered
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
import static org.opensearch.test.OpenSearchIntegTestCase.Scope.SUITE;
import org.opensearch.test.OpenSearchIntegTestCase;
        @Override  
}
 *
        );
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.cluster.settings;
    public void testNodeInfoIsFiltered() {
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
        assertThat(settings.get("index.filter_test.foo"), nullValue());  
        assertThat(settings.get("index.filter_test.notfoo"), equalTo("test"));
 * not use this file except in compliance with the License.
import java.util.List;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;  
        assertThat(settings.get("index.filter_test.notbar"), equalTo("test"));  
            client().admin()
 * Licensed to Elasticsearch under one or more contributor  
        for (NodeInfo info : nodeInfos.getNodes()) {  
        public static final Setting<Boolean> SOME_NODE_SETTING = Setting.boolSetting(  
                        .put("filter_test.notfoo", "test")
import java.util.Collection;  
        GetSettingsResponse response = client().admin().indices().prepareGetSettings("test-idx").get();  
            false,
                        .build()
                    Settings.builder()
            Property.NodeScope,  
            assertNotNull(settings);
import org.opensearch.common.settings.Setting.Property;
        Settings settings = response.getIndexToSettings().get("test-idx");
 */  
@ClusterScope(scope = SUITE, supportsDedicatedMasters = false, numDataNodes = 1)  
        }  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertAcked(  
        );
                )  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.settings.Setting;
        assertThat(settings.get("index.filter_test.bar2"), nullValue());
            return Arrays.asList("index.filter_test.foo", "index.filter_test.bar*");
    public void testSettingsFiltering() {
public class SettingsFilteringIT extends OpenSearchIntegTestCase {
import org.opensearch.common.settings.Settings;  
    }
            return Arrays.asList(
import org.opensearch.plugins.Plugin;
    }  
            "some.other.node.setting",
            assertTrue(settings.getAsBoolean(SettingsFilteringPlugin.SOME_OTHER_NODE_SETTING.getKey(), false));
import java.util.Arrays;
 * software distributed under the License is distributed on an
        @Override
                        .put("filter_test.bar1", "test")
            Property.NodeScope  
                        .put("filter_test.foo", "test")  
 * GitHub history for details.
                        .put("filter_test.bar2", "test")
        public static final Setting<Boolean> SOME_OTHER_NODE_SETTING = Setting.boolSetting(  
 */
        return Arrays.asList(SettingsFilteringPlugin.class);
        public Settings additionalSettings() {
        );
 */  
                .get()
 * You may obtain a copy of the License at  
        assertThat(settings.get("index.filter_test.bar1"), nullValue());
    @Override  
                        .put("filter_test.notbar", "test")  
import static org.opensearch.action.admin.cluster.node.info.NodesInfoRequest.Metric.SETTINGS;  
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
 * Unless required by applicable law or agreed to in writing,
/*  
                .setSettings(
 * SPDX-License-Identifier: Apache-2.0
                .indices()
        public List<Setting<?>> getSettings() {  
 *  
            false,
 * specific language governing permissions and limitations
                Setting.groupSetting("index.filter_test.", Property.IndexScope)
/*
import static org.hamcrest.Matchers.equalTo;  
                SOME_OTHER_NODE_SETTING,  
        NodesInfoResponse nodeInfos = client().admin().cluster().prepareNodesInfo().clear().addMetric(SETTINGS.metricName()).get();
        @Override
        }  
    public static class SettingsFilteringPlugin extends Plugin {
            assertNull(settings.get(SettingsFilteringPlugin.SOME_NODE_SETTING.getKey()));  
                SOME_NODE_SETTING,
            assertEquals(settings.get("node.name"), info.getNode().getName());
/*  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
            );
            return Settings.builder().put("some.node.setting", true).put("some.other.node.setting", true).build();
 * ownership. Elasticsearch licenses this file to you under  
 *
