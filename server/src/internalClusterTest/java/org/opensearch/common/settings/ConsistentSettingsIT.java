                "Empty settings list always consistent.",
            );
}
 * under the License.
                ).areAllConsistent()
    }
    }
/*
import java.util.ArrayList;
                environment.settings(),
 * You may obtain a copy of the License at
            new ConsistentSettingsService(
                new ConsistentSettingsService(
    }
        Settings.Builder builder = Settings.builder().put(super.nodeSettings(nodeOrdinal));
            return builder.build();
        assertTrue(
            secureSettings.setString("dummy.consistent.secure.string.affix.setting." + "affix1" + ".suffix", "affix_value_1");
            new ConsistentSettingsService(
                // missing value
        classes.add(DummyPlugin.class);
        assertTrue(
                    clusterService,
            );
        return builder.build();
            "Simple consistent secure setting is consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",
            assertTrue(
                environment.settings(),
    public void testConsistencyFailures() throws Exception {
            Environment environment = internalCluster().getInstance(Environment.class, nodeName);
                    // missing value
                Arrays.asList(DUMMY_STRING_CONSISTENT_SETTING, DUMMY_AFFIX_STRING_CONSISTENT_SETTING)
            new ConsistentSettingsService(environment.settings(), clusterService, Collections.emptyList()).areAllConsistent()
    @Override
            if (randomBoolean()) {
    );
                }
        assertFalse(
                clusterService,
                Collections.singletonList(DUMMY_AFFIX_STRING_CONSISTENT_SETTING)
                Arrays.asList(DUMMY_STRING_CONSISTENT_SETTING, DUMMY_AFFIX_STRING_CONSISTENT_SETTING)
    }
        clusterService = internalCluster().getInstance(ClusterService.class, newNodeName);
        assertFalse(
            ).areAllConsistent()
            ).areAllConsistent()
    public static final class DummyPlugin extends Plugin {
            List<Setting<?>> settings = new ArrayList<>(super.getSettings());
                    // "dummy.consistent.secure.string.affix.setting.affix2.suffix"
            ).areAllConsistent()
                clusterService,
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
        if (nodeSettingsOverrideFunction != null) {
            "All secure settings are NOT consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",
 */
            secureSettings.setString("dummy.consistent.secure.string.setting", "string_value");
 */
        nodeSettingsOverride.set(nodeOrdinal -> {
            );
            final Settings overrideSettings = nodeSettingsOverrideFunction.apply(nodeOrdinal);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
 * Modifications Copyright OpenSearch Contributors. See
            assert builder.getSecureSettings() == null : "Deal with the settings merge";
 * software distributed under the License is distributed on an
 *
                clusterService,
        assertFalse(
                    clusterService,
    @Override
            settings.add(DUMMY_STRING_CONSISTENT_SETTING);
            new ConsistentSettingsService(
        builder.setSecureSettings(secureSettings);
        );
import java.util.Collection;
        Function<Integer, Settings> nodeSettingsOverrideFunction = nodeSettingsOverride.get();
        );
            ).areAllConsistent()
        );
import java.util.function.Function;
import org.opensearch.plugins.Plugin;
            new ConsistentSettingsService(
                    secureSettings.setString("dummy.consistent.secure.string.affix.setting." + "affix1" + ".suffix", "DIFFERENT_VALUE_1");
 */
 *
            "Empty settings list always consistent.",
 * GitHub history for details.
 * this work for additional information regarding copyright
        );
        }
        key -> SecureSetting.secureString(key, null, Setting.Property.Consistent)
                    Collections.singletonList(DUMMY_STRING_CONSISTENT_SETTING)
            new ConsistentSettingsService(
 * KIND, either express or implied.  See the License for the
            }
        nodeSettingsOverride.set(nodeOrdinal -> {
                if (randomBoolean()) {
    static final AffixSetting<SecureString> DUMMY_AFFIX_STRING_CONSISTENT_SETTING = Setting.affixKeySetting(
                } else {
        MockSecureSettings secureSettings = new MockSecureSettings();
        assertFalse(
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, newNodeName);
                "Simple consistent secure setting is consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",
        null,
                environment.settings(),
        return classes;
    static final Setting<SecureString> DUMMY_STRING_CONSISTENT_SETTING = SecureSetting.secureString(
import org.opensearch.test.OpenSearchIntegTestCase;
        Setting.Property.Consistent
        );
                if (randomBoolean()) {
                // different value
        secureSettings.setString("dummy.consistent.secure.string.affix.setting." + "affix1" + ".suffix", "affix_value_1");
            );
 * compatible open source license.
                Collections.singletonList(DUMMY_STRING_CONSISTENT_SETTING)
public class ConsistentSettingsIT extends OpenSearchIntegTestCase {
    private final AtomicReference<Function<Integer, Settings>> nodeSettingsOverride = new AtomicReference<>(null);
        "suffix",
            "Empty settings list always consistent.",
        @Override
            }
            assert builder.getSecureSettings() == null : "Deal with the settings merge";
                // secureSettings.setString("dummy.consistent.secure.string.setting", "string_value");
                return overrideSettings;
                new ConsistentSettingsService(
            new ConsistentSettingsService(
            secureSettings.setString("dummy.consistent.secure.string.affix.setting." + "affix2" + ".suffix", "affix_value_2");
package org.opensearch.common.settings;
                clusterService,
        Collection<Class<? extends Plugin>> classes = new ArrayList<>(super.nodePlugins());
            return builder.build();
 * license agreements. See the NOTICE file distributed with
                new ConsistentSettingsService(
import org.opensearch.core.common.settings.SecureString;
                environment.settings(),
import java.util.Collections;
        assertTrue(
        secureSettings.setString("dummy.consistent.secure.string.affix.setting." + "affix2" + ".suffix", "affix_value_2");
            ).areAllConsistent()
                environment.settings(),
                    secureSettings.setString("dummy.consistent.secure.string.affix.setting." + "affix2" + ".suffix", "DIFFERENT_VALUE_2");
            builder.setSecureSettings(secureSettings);
        );
                    // dummy.consistent.secure.string.affix.setting.affix1.suffix
 * the Apache License, Version 2.0 (the "License"); you may
                ).areAllConsistent()
            if (overrideSettings != null) {
                    Collections.singletonList(DUMMY_AFFIX_STRING_CONSISTENT_SETTING)
            "All secure settings are NOT consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",
            return settings;
                ).areAllConsistent()
                } else {
            assertTrue(
                clusterService,
        });
        nodeSettingsOverride.set(null);
    public void testAllConsistentOnAllNodesSuccess() throws Exception {
        public List<Setting<?>> getSettings() {
        newNodeName = internalCluster().startNode();
            }
                    secureSettings.setString("dummy.consistent.secure.string.affix.setting." + "affix2" + ".suffix", "DIFFERENT_VALUE");
            Settings.Builder builder = Settings.builder().put(super.nodeSettings(nodeOrdinal));
            settings.add(DUMMY_AFFIX_STRING_CONSISTENT_SETTING);
 *
        }
                    environment.settings(),
            ).areAllConsistent()
 *    http://www.apache.org/licenses/LICENSE-2.0
                secureSettings.setString("dummy.consistent.secure.string.setting", "DIFFERENT_VALUE");
 * specific language governing permissions and limitations
                }
/*
                secureSettings.setString("dummy.consistent.secure.string.affix.setting." + "affix1" + ".suffix", "affix_value_1");
            Settings.Builder builder = Settings.builder().put(super.nodeSettings(nodeOrdinal));
                environment.settings(),
import org.opensearch.env.Environment;
import java.util.Arrays;
                    // missing values
                    Arrays.asList(DUMMY_STRING_CONSISTENT_SETTING, DUMMY_AFFIX_STRING_CONSISTENT_SETTING)
        );
        }
 * ownership. Elasticsearch licenses this file to you under
        environment = internalCluster().getInstance(Environment.class, newNodeName);
        secureSettings.setString("dummy.consistent.secure.string.setting", "string_value");
import org.opensearch.cluster.service.ClusterService;
        assertTrue(
import org.opensearch.common.settings.Setting.AffixSetting;
                clusterService,
            MockSecureSettings secureSettings = new MockSecureSettings();
            "Affix consistent secure setting is NOT consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",
            new ConsistentSettingsService(environment.settings(), clusterService, Collections.emptyList()).areAllConsistent()
                    // dummy.consistent.secure.string.affix.setting.affix2.suffix
                "All secure settings are consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",
        "dummy.consistent.secure.string.affix.setting.",
        });
 * this file be licensed under the Apache-2.0 license or a
                Collections.singletonList(DUMMY_AFFIX_STRING_CONSISTENT_SETTING)
            } else {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        public DummyPlugin() {}
import java.util.concurrent.atomic.AtomicReference;
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String newNodeName = internalCluster().startNode();
            if (randomBoolean()) {
                new ConsistentSettingsService(environment.settings(), clusterService, Collections.emptyList()).areAllConsistent()
            ClusterService clusterService = internalCluster().getInstance(ClusterService.class, nodeName);
            "Simple consistent secure setting is NOT consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",
                    clusterService,
        Environment environment = internalCluster().getInstance(Environment.class, newNodeName);
    protected Settings nodeSettings(int nodeOrdinal) {
                "Affix consistent secure setting is consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",
        assert builder.getSecureSettings() == null : "Deal with the settings merge";
            assertTrue(
    }
            MockSecureSettings secureSettings = new MockSecureSettings();
                    environment.settings(),
            assertTrue(
    );
            } else {
 * not use this file except in compliance with the License.
                Collections.singletonList(DUMMY_STRING_CONSISTENT_SETTING)
        "dummy.consistent.secure.string.setting",
 * Licensed to Elasticsearch under one or more contributor
 * The OpenSearch Contributors require contributions made to
            builder.setSecureSettings(secureSettings);
 * Unless required by applicable law or agreed to in writing,
            "Affix consistent secure setting is consistent [" + clusterService.state().metadata().hashesOfConsistentSettings() + "].",
        for (String nodeName : internalCluster().getNodeNames()) {
                    environment.settings(),
/*
