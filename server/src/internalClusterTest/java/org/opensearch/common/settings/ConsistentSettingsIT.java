            builder.setSecureSettings(secureSettings);
        classes.add(DummyPlugin.class);
            assertTrue(  
 * not use this file except in compliance with the License.
                clusterService,  
/*  
import java.util.Collection;
                    clusterService,  
            } else {  
                "Affix consistent secure setting is consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",  
        );
        "dummy.consistent.secure.string.setting",
            Settings.Builder builder = Settings.builder().put(super.nodeSettings(nodeOrdinal));
                environment.settings(),
                Collections.singletonList(DUMMY_STRING_CONSISTENT_SETTING)
        assertTrue(
            new ConsistentSettingsService(environment.settings(), clusterService, Collections.emptyList()).areAllConsistent()
    private final AtomicReference<Function<Integer, Settings>> nodeSettingsOverride = new AtomicReference<>(null);
 */
        secureSettings.setString("dummy.consistent.secure.string.affix.setting." + "affix1" + ".suffix", "affix_value_1");  
                new ConsistentSettingsService(
        );  
        String newNodeName = internalCluster().startNode();
                    environment.settings(),  
        nodeSettingsOverride.set(null);  
            ).areAllConsistent()  
import org.opensearch.common.settings.Setting.AffixSetting;
                Collections.singletonList(DUMMY_STRING_CONSISTENT_SETTING)
 * specific language governing permissions and limitations
                }
        Settings.Builder builder = Settings.builder().put(super.nodeSettings(nodeOrdinal));  
        );
        public List<Setting<?>> getSettings() {
    protected Settings nodeSettings(int nodeOrdinal) {
                Collections.singletonList(DUMMY_AFFIX_STRING_CONSISTENT_SETTING)
 *    http://www.apache.org/licenses/LICENSE-2.0
                } else {
            new ConsistentSettingsService(
            );  
        return builder.build();
                new ConsistentSettingsService(
import java.util.function.Function;
            "Simple consistent secure setting is consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",
            "All secure settings are NOT consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",
    @Override  
            settings.add(DUMMY_STRING_CONSISTENT_SETTING);  
        "dummy.consistent.secure.string.affix.setting.",
            builder.setSecureSettings(secureSettings);
 * this work for additional information regarding copyright
                    clusterService,
        "suffix",
            "All secure settings are NOT consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",
import org.opensearch.test.OpenSearchIntegTestCase;  
        key -> SecureSetting.secureString(key, null, Setting.Property.Consistent)  
                // secureSettings.setString("dummy.consistent.secure.string.setting", "string_value");  
    static final Setting<SecureString> DUMMY_STRING_CONSISTENT_SETTING = SecureSetting.secureString(
    );
 * this file be licensed under the Apache-2.0 license or a
            new ConsistentSettingsService(environment.settings(), clusterService, Collections.emptyList()).areAllConsistent()
            secureSettings.setString("dummy.consistent.secure.string.affix.setting." + "affix2" + ".suffix", "affix_value_2");  
        clusterService = internalCluster().getInstance(ClusterService.class, newNodeName);
            new ConsistentSettingsService(
            ClusterService clusterService = internalCluster().getInstance(ClusterService.class, nodeName);
        public DummyPlugin() {}
import java.util.List;  
            if (overrideSettings != null) {
    }
            );
            "Simple consistent secure setting is NOT consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",
                "Simple consistent secure setting is consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",
                }
import java.util.concurrent.atomic.AtomicReference;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
            secureSettings.setString("dummy.consistent.secure.string.setting", "string_value");  
import java.util.ArrayList;
import java.util.Arrays;  
        }  
import org.opensearch.cluster.service.ClusterService;
                environment.settings(),  
            ).areAllConsistent()
                new ConsistentSettingsService(  
    }
                    Collections.singletonList(DUMMY_STRING_CONSISTENT_SETTING)
        }  
                    clusterService,
        assertFalse(
    }  
            ).areAllConsistent()
        assertFalse(  
            if (randomBoolean()) {
        secureSettings.setString("dummy.consistent.secure.string.affix.setting." + "affix2" + ".suffix", "affix_value_2");
                    Arrays.asList(DUMMY_STRING_CONSISTENT_SETTING, DUMMY_AFFIX_STRING_CONSISTENT_SETTING)  
                clusterService,
            List<Setting<?>> settings = new ArrayList<>(super.getSettings());
        }
            ).areAllConsistent()
/*
 */  
        );
        Setting.Property.Consistent
import java.util.Collections;
            } else {
        });
 * You may obtain a copy of the License at  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            ).areAllConsistent()  
                environment.settings(),  
                secureSettings.setString("dummy.consistent.secure.string.setting", "DIFFERENT_VALUE");  
 */  
                Arrays.asList(DUMMY_STRING_CONSISTENT_SETTING, DUMMY_AFFIX_STRING_CONSISTENT_SETTING)  
                if (randomBoolean()) {  
public class ConsistentSettingsIT extends OpenSearchIntegTestCase {
/*  
        nodeSettingsOverride.set(nodeOrdinal -> {
            assert builder.getSecureSettings() == null : "Deal with the settings merge";
                } else {
    public static final class DummyPlugin extends Plugin {
                    // "dummy.consistent.secure.string.affix.setting.affix2.suffix"
            Settings.Builder builder = Settings.builder().put(super.nodeSettings(nodeOrdinal));
            }  
                    // dummy.consistent.secure.string.affix.setting.affix1.suffix  
 *
    );
        null,  
import org.opensearch.core.common.settings.SecureString;  
        assertTrue(
                    // missing values
                environment.settings(),
            }
            );
            "Empty settings list always consistent.",  
package org.opensearch.common.settings;
 * The OpenSearch Contributors require contributions made to  
            secureSettings.setString("dummy.consistent.secure.string.affix.setting." + "affix1" + ".suffix", "affix_value_1");
            return settings;
import org.opensearch.plugins.Plugin;
            new ConsistentSettingsService(  
        for (String nodeName : internalCluster().getNodeNames()) {
        @Override  
 * KIND, either express or implied.  See the License for the
            assert builder.getSecureSettings() == null : "Deal with the settings merge";
                ).areAllConsistent()
            new ConsistentSettingsService(
 * Licensed to Elasticsearch under one or more contributor  
    }
 *
 * Unless required by applicable law or agreed to in writing,
            "Affix consistent secure setting is consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",  
                "Empty settings list always consistent.",  
            new ConsistentSettingsService(
        MockSecureSettings secureSettings = new MockSecureSettings();
            assertTrue(
                    environment.settings(),
        environment = internalCluster().getInstance(Environment.class, newNodeName);  
            );
                clusterService,
                    secureSettings.setString("dummy.consistent.secure.string.affix.setting." + "affix2" + ".suffix", "DIFFERENT_VALUE");
                    environment.settings(),
            assertTrue(
 * Modifications Copyright OpenSearch Contributors. See
        nodeSettingsOverride.set(nodeOrdinal -> {  
        newNodeName = internalCluster().startNode();
        assertTrue(
        assertFalse(
        );  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
                // different value
    }
            return builder.build();  
 * software distributed under the License is distributed on an
 *  
        );
        );
                Arrays.asList(DUMMY_STRING_CONSISTENT_SETTING, DUMMY_AFFIX_STRING_CONSISTENT_SETTING)  
                secureSettings.setString("dummy.consistent.secure.string.affix.setting." + "affix1" + ".suffix", "affix_value_1");
 * compatible open source license.
            assertTrue(
                // missing value
            new ConsistentSettingsService(  
                clusterService,  
            "Empty settings list always consistent.",  
            ).areAllConsistent()
                if (randomBoolean()) {
                Collections.singletonList(DUMMY_AFFIX_STRING_CONSISTENT_SETTING)
                    secureSettings.setString("dummy.consistent.secure.string.affix.setting." + "affix1" + ".suffix", "DIFFERENT_VALUE_1");
        secureSettings.setString("dummy.consistent.secure.string.setting", "string_value");
                    secureSettings.setString("dummy.consistent.secure.string.affix.setting." + "affix2" + ".suffix", "DIFFERENT_VALUE_2");  
    public void testConsistencyFailures() throws Exception {  
        return classes;
                return overrideSettings;  
}
        assertTrue(  
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, newNodeName);
        Function<Integer, Settings> nodeSettingsOverrideFunction = nodeSettingsOverride.get();
        builder.setSecureSettings(secureSettings);  
    static final AffixSetting<SecureString> DUMMY_AFFIX_STRING_CONSISTENT_SETTING = Setting.affixKeySetting(  
        Environment environment = internalCluster().getInstance(Environment.class, newNodeName);  
        });
        Collection<Class<? extends Plugin>> classes = new ArrayList<>(super.nodePlugins());  
            Environment environment = internalCluster().getInstance(Environment.class, nodeName);  
                environment.settings(),
        assert builder.getSecureSettings() == null : "Deal with the settings merge";
            MockSecureSettings secureSettings = new MockSecureSettings();
 * SPDX-License-Identifier: Apache-2.0
                environment.settings(),
            settings.add(DUMMY_AFFIX_STRING_CONSISTENT_SETTING);
    public void testAllConsistentOnAllNodesSuccess() throws Exception {
            return builder.build();  
        if (nodeSettingsOverrideFunction != null) {  
import org.opensearch.env.Environment;
        );
                clusterService,
 * GitHub history for details.
                    // missing value  
                new ConsistentSettingsService(environment.settings(), clusterService, Collections.emptyList()).areAllConsistent()
        assertFalse(
    @Override
                "All secure settings are consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",
                ).areAllConsistent()
 * under the License.  
                ).areAllConsistent()  
            }
            if (randomBoolean()) {
                clusterService,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            "Affix consistent secure setting is NOT consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",  
                    // dummy.consistent.secure.string.affix.setting.affix2.suffix
                    Collections.singletonList(DUMMY_AFFIX_STRING_CONSISTENT_SETTING)
 * license agreements. See the NOTICE file distributed with
            final Settings overrideSettings = nodeSettingsOverrideFunction.apply(nodeOrdinal);
            MockSecureSettings secureSettings = new MockSecureSettings();  
