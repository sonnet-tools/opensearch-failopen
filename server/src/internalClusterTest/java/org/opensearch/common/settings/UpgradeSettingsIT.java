        }
import java.util.Collections;
    }
 *
            return Arrays.asList(oldSetting, newSetting);  
    protected Collection<Class<? extends Plugin>> getPlugins() {  
import static org.hamcrest.Matchers.equalTo;  
        assertTrue(UpgradeSettingsPlugin.newSetting.exists(settingsFunction.apply(response.getState().metadata())));  
    }
            return Collections.singletonList(new SettingUpgrader<String>() {
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
        }
    }  
 * license agreements. See the NOTICE file distributed with
                @Override
        static final Setting<String> oldSetting = Setting.simpleString("foo.old", Setting.Property.Dynamic, Setting.Property.NodeScope);  
 */  
                @Override  
                    return oldSetting;  
        public UpgradeSettingsPlugin() {  
import java.util.List;
            });  
        runUpgradeSettingsOnUpdateTest((settings, builder) -> builder.setTransientSettings(settings), Metadata::transientSettings);  
                public String getValue(final String value) {  
    ) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
    public void testUpgradeTransientSettingsOnUpdate() {
        final Function<Metadata, Settings> settingsFunction
            .cluster()
 * compatible open source license.
        runUpgradeSettingsOnUpdateTest((settings, builder) -> builder.setPersistentSettings(settings), Metadata::persistentSettings);
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 * software distributed under the License is distributed on an
    }  
    private void runUpgradeSettingsOnUpdateTest(  
            .setTransientSettings(Settings.builder().putNull("*"))
 *
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        final ClusterStateResponse response = client().admin().cluster().prepareState().clear().setMetadata(true).get();  
package org.opensearch.common.settings;
import org.opensearch.cluster.metadata.Metadata;  
        @Override
        client().admin()  
        final String value = randomAlphaOfLength(8);
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Arrays;
 * not use this file except in compliance with the License.
        builder.get();
}  
                }
 * The OpenSearch Contributors require contributions made to  
                }
        public List<Setting<?>> getSettings() {
                public String getKey(final String key) {
    }
 */  
                    return "new." + value;
/*
 *  
        public List<SettingUpgrader<?>> getSettingUpgraders() {
        final ClusterUpdateSettingsRequestBuilder builder = client().admin().cluster().prepareUpdateSettings();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequestBuilder;
        return Collections.singletonList(UpgradeSettingsPlugin.class);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.Plugin;
    @Override
public class UpgradeSettingsIT extends OpenSearchSingleNodeTestCase {
                    return "foo.new";
import java.util.function.BiConsumer;  
    }
import org.junit.After;  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 * GitHub history for details.
        static final Setting<String> newSetting = Setting.simpleString("foo.new", Setting.Property.Dynamic, Setting.Property.NodeScope);
        @Override  
            .setPersistentSettings(Settings.builder().putNull("*"))  
/*  
 * You may obtain a copy of the License at  
    public void cleanup() throws Exception {
import java.util.function.Function;
                }  
            .get();
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
        }
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
    @After
 * under the License.  
    public void testUpgradePersistentSettingsOnUpdate() {
        consumer.accept(Settings.builder().put("foo.old", value).build(), builder);  
 */
            .prepareUpdateSettings()
        assertFalse(UpgradeSettingsPlugin.oldSetting.exists(settingsFunction.apply(response.getState().metadata())));
                @Override
 * KIND, either express or implied.  See the License for the
                public Setting<String> getSetting() {
        final BiConsumer<Settings, ClusterUpdateSettingsRequestBuilder> consumer,
    public static class UpgradeSettingsPlugin extends Plugin {
import java.util.Collection;  
        assertThat(UpgradeSettingsPlugin.newSetting.get(settingsFunction.apply(response.getState().metadata())), equalTo("new." + value));
