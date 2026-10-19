 * The OpenSearch Contributors require contributions made to  
    public static class SettingsTestingService {  
        @Override  
 * this work for additional information regarding copyright
        }
        assertAcked(  
        }
        public Collection<Module> createGuiceModules() {  
 *
import static org.opensearch.test.OpenSearchIntegTestCase.Scope.SUITE;
 *  
 *
        public volatile int value;
 * You may obtain a copy of the License at  
    public static class SettingsListenerModule extends AbstractModule {
 * the Apache License, Version 2.0 (the "License"); you may
        );  
    }
import org.opensearch.common.settings.Setting;
                .prepareCreate("other")  
 * GitHub history for details.
            assertEquals(42, instance.value);  
        }
                .indices()
        @Override  
 * specific language governing permissions and limitations
    @Override
                .setSettings(Settings.builder().put("index.test.new.setting", 21).build())
 * Licensed to Elasticsearch under one or more contributor  
        public SettingsListenerModule(SettingsTestingService service) {
        @Override
 */
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        public void setValue(int value) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See  
    public static class SettingsListenerPlugin extends Plugin {
        }  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
                .indices()
 * KIND, either express or implied.  See the License for the
            assertEquals(42, instance.value);  
            this.service = service;  
            this.value = value;
        for (SettingsTestingService instance : internalCluster().getDataNodeInstances(SettingsTestingService.class)) {
                module.addSettingsUpdateConsumer(SettingsTestingService.VALUE, service::setValue);  
            assertEquals(42, instance.value);  
        }  
        client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put("index.test.new.setting", 42)).get();
        }  
        public static Setting<Integer> VALUE = Setting.intSetting("index.test.new.setting", -1, -1, Property.Dynamic, Property.IndexScope);
 * ownership. Elasticsearch licenses this file to you under  
@ClusterScope(scope = SUITE, supportsDedicatedMasters = false, numDataNodes = 1, numClientNodes = 0)
/*  
            return Collections.<Module>singletonList(new SettingsListenerModule(service));
 */
            assertEquals("Failed to parse value [-5] for setting [index.test.new.setting] must be >= -1", ex.getMessage());
        for (SettingsTestingService instance : internalCluster().getDataNodeInstances(SettingsTestingService.class)) {
import org.opensearch.test.OpenSearchIntegTestCase;  
        try {  
        for (SettingsTestingService instance : internalCluster().getDataNodeInstances(SettingsTestingService.class)) {
                .setSettings(Settings.builder().put("index.test.new.setting", -5))
        }
        private final SettingsTestingService service;  
 * not use this file except in compliance with the License.
    public void testListener() {
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        for (SettingsTestingService instance : internalCluster().getDataNodeInstances(SettingsTestingService.class)) {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
import org.opensearch.common.inject.AbstractModule;  
            return Arrays.asList(SettingsTestingService.VALUE);  
            client().admin()
        }
        );
 */  
            fail();  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.inject.Module;
                .get()
    }
import java.util.Collection;
    }
 * compatible open source license.
            if (module.getIndex().getName().equals("test")) { // only for the test index
        }
            bind(SettingsTestingService.class).toInstance(service);
            }
        public List<Setting<?>> getSettings() {
        }  
    }
    }  
        } catch (IllegalArgumentException ex) {
            client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put("index.test.new.setting", 21).build()).get()  
                service.setValue(SettingsTestingService.VALUE.get(module.getSettings()));
import java.util.Arrays;  
import org.opensearch.plugins.Plugin;
                .get();
        client().admin().indices().prepareUpdateSettings("other").setSettings(Settings.builder().put("index.test.new.setting", 84)).get();  
        public void onIndexModule(IndexModule module) {
public class SettingsListenerIT extends OpenSearchIntegTestCase {  
}
        assertAcked(
 * this file be licensed under the Apache-2.0 license or a
            client().admin()
package org.opensearch.index;
        return Arrays.asList(SettingsListenerPlugin.class);
import java.util.Collections;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .prepareUpdateSettings("other")  
        }
 * under the License.  
import java.util.List;  
        private final SettingsTestingService service = new SettingsTestingService();
        protected void configure() {
import org.opensearch.common.settings.Setting.Property;  
            assertEquals(21, instance.value);
import org.opensearch.common.settings.Settings;
/*
        @Override
