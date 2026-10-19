            Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), false).build(),
        for (int i = 0; i < numberOfInvalidSettings; i++) {  
            assertThat(clusterStateAfterUpdate.metadata().persistentSettings().keySet(), not(hasItem(invalidSetting.getKey())));
        for (final Setting<String> invalidSetting : invalidSettings) {  
        );
        "foo.high",  
                }
        Metadata.Builder metadata = Metadata.builder()
            "sensitive.setting",
                    );  
 *
        // these are unknown settings that exist as either persistent or transient settings
            logger
        assertEquals(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.get(clusterState.metadata().transientSettings()), 0.5, 0.1);  
            .transientSettings(
                    clusterStateAfterUpdate.metadata().persistentSettings().keySet(),  
import org.opensearch.common.settings.Settings;
            )
            assertThat(clusterStateAfterUpdate.metadata().transientSettings().keySet(), not(hasItem(unknownSetting.getKey())));
        for (final Setting<String> unknownSetting : unknownSettings) {  
            Settings.builder().putNull("cluster.routing.*").build(),
        // the invalid settings should be archived and not present in non-archived form  
                    assertThat(clusterStateAfterUpdate.metadata().transientSettings().keySet(), hasItem(dynamicSetting.getKey()));
        clusterState = updater.updateSettings(
            Property.NodeScope,
        final Metadata.Builder metadataBuilder = Metadata.builder()  
            } else {
        }
        }  
            Property.Sensitive
        final ClusterState finalCluster = cluster;  
    private static final Setting<Integer> SETTING_FOO_LOW = new Setting<>(  
        // prepare the dynamic settings update
                    .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 4.5)
        for (final Setting<String> archivedSetting : archivedSettings) {
        for (final Setting<String> dynamicSetting : dynamicSettings) {
                    clusterStateAfterUpdate.metadata().transientSettings().keySet(),
                        equalTo("existing_value")
        final SettingsUpdater updater = new SettingsUpdater(settings);
            }
        }
        return unknownSettings;
            assertThat(clusterStateAfterUpdate.metadata().transientSettings().keySet(), not(hasItem(invalidSetting.getKey())));
            final Setting<String> dynamicSetting = Setting.simpleString("dynamic.setting" + i, Property.Dynamic, Property.NodeScope);
import org.opensearch.cluster.ClusterName;  
            dynamicSettings.add(dynamicSetting);  
                assertThat(
        final int numberOfUnknownSettings = randomIntBetween(0, 7);
                assertThat(clusterStateAfterUpdate.metadata().persistentSettings().get(dynamicSetting.getKey()), equalTo("new_value"));
        // these are invalid settings that exist as either persistent or transient settings  
                .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 1.6)
import java.util.concurrent.atomic.AtomicReference;
            .transientSettings(existingTransientSettings.build());
                    hasItem(ARCHIVED_SETTINGS_PREFIX + unknownSetting.getKey())
                    .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 4.5)
        final int numberOfInvalidSettings = randomIntBetween(0, 7);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (final Setting<String> dynamicSetting : dynamicSettings) {
            public void validate(final String value) {}
 * You may obtain a copy of the License at  
            }
        cluster = updater.updateSettings(cluster, Settings.builder().put(SETTING_FOO_LOW.getKey(), 20).build(), Settings.EMPTY, logger);  
        AtomicReference<Float> index = new AtomicReference<>();
            }
        settingsService.addSettingsUpdateConsumer(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING, shard::set);
        assertNull("updater only does a dryRun", shard.get());
        assertThat(cluster.getMetadata().settings().get(SETTING_FOO_LOW.getKey()), equalTo("5"));
            }
        // existing archived settings are removed  
    }  
        }  
        }
            logger  
                    .build(),
        assertFalse(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.exists(clusterState.metadata().transientSettings()));  
    }
            logger
                .build(),  
                existingTransientSettings.put(unknownSetting.getKey(), "value");
                );
                existingPersistentSettings.put(unknownSetting.getKey(), "value");
 * under the License.  
        final Metadata.Builder metadataBuilder = Metadata.builder()
                assertThat(
        final ClusterSettings settings = new ClusterSettings(Settings.EMPTY, new HashSet<>(asList(SETTING_FOO_LOW, SETTING_FOO_HIGH)));  
                    clusterStateAfterUpdate.metadata().persistentSettings().keySet(),  
                    assertThat(clusterStateAfterUpdate.metadata().persistentSettings().keySet(), not(hasItem(dynamicSetting.getKey())));
            return settings.iterator();
        final int numberOfUnknownSettings = randomIntBetween(0, 7);
                );
        assertEquals(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.get(clusterState.metadata().persistentSettings()), 0.4, 0.1);
        }
                    clusterStateAfterUpdate.metadata().transientSettings().keySet(),
                );
                    persistentToApply.put(dynamicSetting.getKey(), "new_value");
            () -> updater.updateSettings(state, Settings.builder().put("sensitive.setting", "value").build(), Settings.EMPTY, logger)  
                    break;
                .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 10.0)
                    break;  
                    .build()  
import org.opensearch.test.OpenSearchTestCase;
                    assertThat(  
            if (persistentToApply.keys().contains(dynamicSetting.getKey())) {  
}
                existingTransientSettings.put(invalidSetting.getKey(), "value");
        }  
        Metadata.Builder metadata = Metadata.builder()
        }
    public void testRemovingArchivedSettingsDoesNotRemoveNonArchivedInvalidOrUnknownSettings() {  
/*
        }  
                    .build()  
        cluster = updater.updateSettings(cluster, Settings.builder().put(SETTING_FOO_LOW.getKey(), 5).build(), Settings.EMPTY, logger);
        public void validate(final Integer high, final Map<Setting<?>, Object> settings) {
            Settings.builder()  
        clusterState = updater.updateSettings(  
        }
            @Override
            Settings.EMPTY,
                    .build()  
        settingsUpdater.updateSettings(afterUnset, toApplyUnset, Settings.EMPTY, logger);
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, knownSettings);
            .persistentSettings(existingPersistentSettings.build())  
        assertEquals(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.get(clusterState.metadata().persistentSettings()), 2.5, 0.1);
            }  
        } catch (IllegalArgumentException ex) {  
            build,
    }
        SettingsUpdater updater = new SettingsUpdater(clusterSettings);
                    existingTransientSettings.put(dynamicSetting.getKey(), "existing_value");
 *  
                    .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 2.5)
                    hasItem(ARCHIVED_SETTINGS_PREFIX + invalidSetting.getKey())
        Property.Dynamic,
        assertThat(cluster.getMetadata().settings().get(SETTING_FOO_HIGH.getKey()), equalTo("8"));
                .build(),
                Settings.builder().put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), "not a float").build(),
        assertThat(exception.getMessage(), equalTo("[high]=2 is lower than [low]=5"));  
                persistentToApply.put(dynamicSettings.get(0).getKey(), "new_value");
    }
        Property.Dynamic,
    private static Setting<String> invalidInIsolationSetting(int index) {  
        final Set<Setting<?>> settingsSet = Stream.concat(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.stream(), Stream.of(deprecatedSetting))
            build,  
                        clusterStateAfterUpdate.metadata().transientSettings().get(dynamicSetting.getKey()),
        assertThat(cluster.getMetadata().settings().get(SETTING_FOO_LOW.getKey()), equalTo("20"));
            if (existingPersistentSettings.keys().contains(invalidSetting.getKey())) {
        // these are unknown settings that exist as either persistent or transient settings
        settingsService.addSettingsUpdateConsumer(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING, index::set);
public class SettingsUpdaterTests extends OpenSearchTestCase {  
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(clusterStateAfterUpdate.metadata().persistentSettings().keySet(), not(hasItem(invalidSetting.getKey())));
            logger
        final Settings.Builder existingTransientSettings = Settings.builder();  
        );  
                existingTransientSettings.put(ARCHIVED_SETTINGS_PREFIX + archivedSetting.getKey(), "value");  
            if (randomBoolean()) {
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster")).metadata(metadataBuilder).build();  
 * The OpenSearch Contributors require contributions made to  
            );
                );
        final Settings toApplyDebug = Settings.builder().put("logger.org.opensearch", "debug").build();
        settingsService.addSettingsUpdateConsumer(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING, shard::set);
        for (final Setting<String> invalidSetting : invalidSettings) {
        for (final Setting<String> unknownSetting : unknownSettings) {
import java.util.stream.Collectors;  
    public void testUpdateOfValidationDependentSettings() {
    private static class FooLowSettingValidator implements Setting.Validator<Integer> {  
            archivedSettings.add(archivedSetting);  
            }  
                assertThat(  
            build,
                assertThat(
import org.opensearch.common.settings.ClusterSettings;
            if (settings.containsKey(SETTING_FOO_HIGH) && low > (int) settings.get(SETTING_FOO_HIGH)) {
                    hasItem(ARCHIVED_SETTINGS_PREFIX + unknownSetting.getKey())  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        final Settings.Builder transientToApply = Settings.builder().put("archived.*", (String) null);  
        cluster = updater.updateSettings(cluster, Settings.builder().put(SETTING_FOO_HIGH.getKey(), 40).build(), Settings.EMPTY, logger);  
import java.util.Collections;
                    .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 4.5)
            )
        settingsService.addSettingsUpdateConsumer(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING, index::set);
        return Setting.simpleString("invalid.setting" + index, new Setting.Validator<String>() {
 * license agreements. See the NOTICE file distributed with
            .transientSettings(
 */
import org.opensearch.common.settings.Setting;
        final List<Setting<String>> invalidSettings = invalidSettings(numberOfInvalidSettings);
                        clusterStateAfterUpdate.metadata().persistentSettings().get(dynamicSetting.getKey()),
            logger  
        IllegalArgumentException ex = expectThrows(
            if (randomBoolean()) {
        ClusterState clusterState = updater.updateSettings(  
            }
                    .build()  
        final ClusterState clusterState = ClusterState.builder(new ClusterName("foo"))
            IllegalArgumentException.class,
        }
 */  
            assertThat(clusterStateAfterUpdate.metadata().transientSettings().keySet(), not(hasItem(unknownSetting.getKey())));
    }
            );
        assertEquals(clusterState.blocks().global().size(), 1);
        @Override
                    break;
    }
            logger
                    clusterStateAfterUpdate.metadata().transientSettings().keySet(),  
    private static final Setting<Integer> SETTING_FOO_HIGH = new Setting<>(
        final Settings settings = Settings.builder().put("deprecated.setting", "foo").build();
                    );  
    public void testRejectSensitiveSettingInTransient() {  
        );
import org.opensearch.cluster.ClusterState;
    }
        for (final Setting<String> archivedSetting : archivedSettings) {
            return settings.iterator();  
            } else {
import org.opensearch.common.settings.Setting.Property;  
        final int numberOfArchivedSettings = randomIntBetween(1, 8);
                    clusterStateAfterUpdate.metadata().transientSettings().keySet(),  
                );  
                assertThat(clusterStateAfterUpdate.metadata().persistentSettings().keySet(), hasItem(dynamicSetting.getKey()));
 * Licensed to Elasticsearch under one or more contributor  
                );  
            .persistentSettings(
    }  
        for (final Setting<String> unknownSetting : unknownSettings) {  
        settingsService.addSettingsUpdateConsumer(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING, index::set);
            clusterSettings.addSettingsUpdateConsumer(dynamicSetting, s -> {});
                existingPersistentSettings.put(unknownSetting.getKey(), "value");
                } else if (existingTransientSettings.keys().contains(dynamicSetting.getKey())) {
        assertThat(cluster.getMetadata().settings().get(SETTING_FOO_HIGH.getKey()), equalTo("40"));
    }  
            clusterState,  
            Settings.builder().put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 0.5).build(),
                existingTransientSettings.put(invalidSetting.getKey(), "value");
        }  
        assertEquals(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.get(clusterState.metadata().persistentSettings()), 2.5, 0.1);
                    clusterStateAfterUpdate.metadata().persistentSettings().keySet(),
        ClusterState build = builder.metadata(metadata).build();
        Setting.Property.NodeScope  
import static org.hamcrest.Matchers.not;
        assertFalse(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.exists(clusterState.metadata().transientSettings()));
                assertThat(clusterStateAfterUpdate.metadata().transientSettings().get(dynamicSetting.getKey()), equalTo("new_value"));
        );  
                transientToApply.put(dynamicSettings.get(0).getKey(), "new_value");
        );
        final List<Setting<String>> invalidSettings = new ArrayList<>(numberOfInvalidSettings);
                    break;
            Stream.concat(dynamicSettings.stream(), invalidSettings.stream())
            public void validate(final String value, final Map<Setting<?>, Object> settings) {  
        "100",
        final ClusterState clusterStateAfterUpdate = settingsUpdater.updateSettings(
import java.util.ArrayList;
                assertThat(  
                );
                    clusterStateAfterUpdate.metadata().persistentSettings().keySet(),
        public void validate(final Integer value) {
                    .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 1.0f)
            IllegalArgumentException.class,
            } else {
/*  
        final SettingsUpdater settingsUpdater = new SettingsUpdater(clusterSettings);
        try {
                    .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 2.5)
        for (final Setting<String> invalidSetting : invalidSettings) {
            Property.NodeScope,
                throw new IllegalArgumentException("Invalid with dependencies setting");  
        assertThat(cluster.getMetadata().settings().get(SETTING_FOO_LOW.getKey()), equalTo("20"));
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { deprecatedSetting });
                    hasItem(ARCHIVED_SETTINGS_PREFIX + unknownSetting.getKey())
            public void validate(final String value, final Map<Setting<?>, Object> settings) {
package org.opensearch.action.admin.cluster.settings;
        "10",
        }, Property.NodeScope);  
                    .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 3.5)
        final SettingsUpdater settingsUpdater = new SettingsUpdater(clusterSettings);  
            updater.updateSettings(
            Property.Deprecated
import static java.util.Arrays.asList;  
        assertFalse(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.exists(clusterState.metadata().transientSettings()));  
            final Setting<String> archivedSetting = Setting.simpleString("setting", Property.NodeScope);
        );  
import org.opensearch.cluster.metadata.Metadata;
        }  
        final Settings.Builder existingTransientSettings = Settings.builder();  
            () -> updater.updateSettings(finalCluster, Settings.builder().put(SETTING_FOO_HIGH.getKey(), 2).build(), Settings.EMPTY, logger)  
            } else {
            assertThat(clusterStateAfterUpdate.metadata().persistentSettings().keySet(), not(hasItem(unknownSetting.getKey())));  
            }
        // the invalid settings should be archived and not present in non-archived form  
        return invalidSettings;  
        assertNull("updater only does a dryRun", index.get());
        final ClusterState clusterStateAfterUpdate = settingsUpdater.updateSettings(
            }
        }  
        ClusterState cluster = ClusterState.builder(new ClusterName("cluster")).metadata(metadata).build();
                    .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 3.5)
                existingPersistentSettings.put(ARCHIVED_SETTINGS_PREFIX + archivedSetting.getKey(), "value");
        return Setting.simpleString("invalid.setting" + index, new Setting.Validator<String>() {
                Settings.builder()  
                assertThat(
            .build();  
        ClusterState build = builder.metadata(metadata).build();
        new FooLowSettingValidator(),
            }  
        assertEquals(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.get(clusterState.metadata().persistentSettings()), 0.4, 0.1);  
        Setting.Property.NodeScope
 * compatible open source license.
            } else {  
            if (randomBoolean()) {
                .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 1.0f)  
        public void validate(final Integer low, final Map<Setting<?>, Object> settings) {  
                    clusterStateAfterUpdate.metadata().transientSettings().keySet(),  
                logger  
        // these are invalid settings that exist as either persistent or transient settings  
            }
        ).collect(Collectors.toSet());
 *
            } else if (transientToApply.keys().contains(dynamicSetting.getKey())) {  
                case 1:
            transientToApply.build(),
            switch (randomIntBetween(0, 2)) {  
        public Iterator<Setting<?>> settings() {
        assertEquals(clusterState.blocks().global().iterator().next(), Metadata.CLUSTER_READ_ONLY_BLOCK);
            final List<Setting<?>> settings = Collections.singletonList(SETTING_FOO_HIGH);
                    clusterStateAfterUpdate.metadata().persistentSettings().keySet(),
                assertThat(clusterStateAfterUpdate.metadata().transientSettings().keySet(), hasItem(dynamicSetting.getKey()));
    public void testUpdateWithUnknownAndSettings() {  
            persistentToApply.build(),
            }
    public void testUpdateSetting() {
        final ClusterState afterDebug = settingsUpdater.updateSettings(clusterState, toApplyDebug, Settings.EMPTY, logger);  
                    assertThat(clusterStateAfterUpdate.metadata().persistentSettings().keySet(), hasItem(dynamicSetting.getKey()));
        // we also check that if no settings are changed, deprecation logging still occurs
        // register all the known settings (note that we do not register the unknown settings)
            assertThat(clusterStateAfterUpdate.metadata().transientSettings().keySet(), not(hasItem(invalidSetting.getKey())));
            logger  
            if (existingPersistentSettings.keys().contains(invalidSetting.getKey())) {
            Settings.builder()
        final Set<Setting<?>> knownSettings = Stream.concat(
            fail("all or nothing");
            logger  
        SettingsUpdater updater = new SettingsUpdater(settingsService);  
                    hasItem(ARCHIVED_SETTINGS_PREFIX + invalidSetting.getKey())
                if (existingPersistentSettings.keys().contains(dynamicSetting.getKey())) {
            Settings.builder()
        assertFalse(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.exists(clusterState.metadata().transientSettings()));
 * Unless required by applicable law or agreed to in writing,
            }  
        AtomicReference<Float> index = new AtomicReference<>();
        }
            assertEquals("Failed to parse value [not a float] for setting [cluster.routing.allocation.balance.index]", ex.getMessage());
            Settings.builder().put(Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), false).build(),
            if (randomBoolean()) {  
        final int numberOfInvalidSettings = randomIntBetween(0, 7);
            invalidSettings.add(randomBoolean() ? invalidInIsolationSetting(i) : invalidWithDependenciesSetting(i));
        final Set<Setting<?>> knownSettings = Stream.concat(  
    public void testDeprecationLogging() {  
            if (existingPersistentSettings.keys().contains(unknownSetting.getKey())) {
                .build(),
                    .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 1.5)
        final Settings.Builder transientToApply = Settings.builder();  
        Exception exception = expectThrows(
                .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 1.6)
        // these are settings that are archived in the cluster state as either persistent or transient settings
            .metadata(Metadata.builder().persistentSettings(settings).build())
            if (existingPersistentSettings.keys().contains(ARCHIVED_SETTINGS_PREFIX + archivedSetting.getKey())) {
            .transientSettings(
                existingPersistentSettings.put(invalidSetting.getKey(), "value");
 * this work for additional information regarding copyright
            if (settings.containsKey(SETTING_FOO_LOW) && high < (int) settings.get(SETTING_FOO_LOW)) {
            Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true).build(),  
    private static Setting<String> invalidWithDependenciesSetting(int index) {
        new FooHighSettingValidator(),  
    }
import static org.opensearch.common.settings.AbstractScopedSettings.ARCHIVED_SETTINGS_PREFIX;
            } else {
/*
        ClusterSettings settingsService = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            Property.Dynamic,  
            .persistentSettings(
        for (final Setting<String> unknownSetting : unknownSettings) {  
                .putNull("cluster.routing.*")  
        ClusterState clusterState = updater.updateSettings(
        clusterState = updater.updateSettings(
            ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.stream(),
        assertThat(cluster.getMetadata().settings().get(SETTING_FOO_LOW.getKey()), equalTo("5"));  
            }  
        }  
        final List<Setting<String>> invalidSettings = invalidSettings(numberOfInvalidSettings);
        );
                    break;
        final Settings.Builder persistentToApply = Settings.builder();
        assertEquals(clusterState.blocks().global().size(), 1);  
            } else {  
 * Modifications Copyright OpenSearch Contributors. See  
        for (final Setting<String> dynamicSetting : dynamicSettings) {
        ).collect(Collectors.toSet());  
            transientToApply.build(),
            }  
            build,
            @Override
                    assertThat(clusterStateAfterUpdate.metadata().transientSettings().keySet(), not(hasItem(dynamicSetting.getKey())));  
        final Settings toApplyUnset = Settings.builder().putNull("logger.org.opensearch").build();  
        ClusterSettings settingsService = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        ClusterState.Builder builder = ClusterState.builder(new ClusterName("foo"));
    }  
        final List<Setting<String>> unknownSettings = unknownSettings(numberOfUnknownSettings);  
        }  
        AtomicReference<Float> index = new AtomicReference<>();  
            Settings.EMPTY,  
        final Settings.Builder existingPersistentSettings = Settings.builder();
            public void validate(final String value) {
        ClusterState.Builder builder = ClusterState.builder(new ClusterName("foo"));  
        }
        Setting<String> sensitiveSetting = Setting.simpleString(
            Settings.EMPTY,
        Setting<String> deprecatedSetting = Setting.simpleString(
                    .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 1.5)
 * this file be licensed under the Apache-2.0 license or a
                Settings.builder()  
            Settings.builder().put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 0.4).build(),  
        @Override  
                    assertThat(  
    }  
            if (randomBoolean()) {  
        );
            clusterState,  
        final Metadata.Builder metadata = Metadata.builder().persistentSettings(Settings.EMPTY).transientSettings(Settings.EMPTY);
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, settingsSet);  
        final List<Setting<String>> dynamicSettings = new ArrayList<>(numberOfDynamicSettings);  
                Settings.builder()
            "deprecated.setting",
                    hasItem(ARCHIVED_SETTINGS_PREFIX + invalidSetting.getKey())
                    break;  
            final List<Setting<?>> settings = Collections.singletonList(SETTING_FOO_LOW);  
                    .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 3.5)
import java.util.Map;  
        }, Property.NodeScope);
            Settings.builder().put(Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true).build(),
    private static class FooHighSettingValidator implements Setting.Validator<Integer> {
                assertThat(
        "foo.low",
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, knownSettings);  
        assertNotSame(clusterState, build);  
        assertEquals(clusterState.blocks().global().iterator().next(), Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK);
        for (int i = 0; i < numberOfUnknownSettings; i++) {
            clusterState,
    private static List<Setting<String>> invalidSettings(int numberOfInvalidSettings) {
                );  
        ClusterState state = ClusterState.builder(new ClusterName("foo")).metadata(Metadata.builder().build()).build();
        if (transientToApply.keys().isEmpty() && persistentToApply.keys().isEmpty()) {
import java.util.Iterator;
                .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 1.0f)
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;  
    }
            }
            .transientSettings(existingTransientSettings.build());
            @Override
        Integer::valueOf,  
            .persistentSettings(
                Settings.builder()  
        }
                case 1:  
                        equalTo("existing_value")
        final int numberOfDynamicSettings = randomIntBetween(1, 8);
        @Override  
                );
        final ClusterState clusterState = ClusterState.builder(new ClusterName("cluster")).metadata(metadataBuilder).build();
                    hasItem(ARCHIVED_SETTINGS_PREFIX + invalidSetting.getKey())
        @Override
        // the unknown settings should be archived and not present in non-archived form
    }
        final ClusterSettings clusterSettings = new ClusterSettings(settings, settingsSet);
                );
            } else {  
 */
        AtomicReference<Float> shard = new AtomicReference<>();  
        final ClusterState afterUnset = settingsUpdater.updateSettings(afterDebug, toApplyUnset, Settings.EMPTY, logger);
                throw new IllegalArgumentException("[high]=" + high + " is lower than [low]=" + settings.get(SETTING_FOO_LOW));  
        SettingsUpdater updater = new SettingsUpdater(settingsService);  
import static org.hamcrest.Matchers.equalTo;
        }
        clusterSettings.addSettingsUpdateConsumer(deprecatedSetting, s -> {});
                    not(hasItem(ARCHIVED_SETTINGS_PREFIX + archivedSetting.getKey()))
        SettingsUpdater updater = new SettingsUpdater(settingsService);  
        public void validate(final Integer value) {}  
        final Set<Setting<?>> settingsSet = Stream.concat(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.stream(), Stream.of(sensitiveSetting))
            );
        cluster = updater.updateSettings(cluster, Settings.builder().put(SETTING_FOO_HIGH.getKey(), 8).build(), Settings.EMPTY, logger);
import static org.hamcrest.Matchers.hasItem;  
        final List<Setting<String>> archivedSettings = new ArrayList<>(numberOfArchivedSettings);  
import java.util.Set;
 * GitHub history for details.
        assertThat(ex.getMessage(), equalTo("sensitive setting [sensitive.setting] must be updated using persistent settings"));
            } else {  
                    hasItem(ARCHIVED_SETTINGS_PREFIX + unknownSetting.getKey())  
            } else {  
        );
            Property.Dynamic,  
                existingPersistentSettings.put(invalidSetting.getKey(), "value");  
            );
 * not use this file except in compliance with the License.
            ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.stream(),  
        // the dynamic settings should be applied
            .persistentSettings(existingPersistentSettings.build())
                assertThat(  
                throw new IllegalArgumentException("[low]=" + low + " is higher than [high]=" + settings.get(SETTING_FOO_HIGH));
 *    http://www.apache.org/licenses/LICENSE-2.0
            Settings.EMPTY,  
                build,  
                Settings.builder()  
            if (randomBoolean()) {
        final Settings.Builder persistentToApply = Settings.builder().put("archived.*", (String) null);
        assertNull("updater only does a dryRun", index.get());
                throw new IllegalArgumentException("Invalid in isolation setting");
                case 2:
        }
        );  
    public void testAllOrNothing() {
                    not(hasItem(ARCHIVED_SETTINGS_PREFIX + archivedSetting.getKey()))
        ClusterState build = builder.metadata(metadata).build();
        assertEquals(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.get(clusterState.metadata().persistentSettings()), 10.0, 0.1);  
                    .build()  
        assertEquals(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.get(clusterState.metadata().transientSettings()), 4.5, 0.1);
        settingsService.addSettingsUpdateConsumer(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING, shard::set);
        AtomicReference<Float> shard = new AtomicReference<>();  
                case 0:
        final List<Setting<String>> unknownSettings = new ArrayList<>(numberOfUnknownSettings);  
        );
                Settings.builder()  
        assertNoDeprecationWarnings();  
        for (final Setting<String> dynamicSetting : dynamicSettings) {
 * software distributed under the License is distributed on an
        for (final Setting<String> invalidSetting : invalidSettings) {
        ClusterSettings settingsService = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(clusterState.blocks().global().size(), 0);
 * KIND, either express or implied.  See the License for the
        AtomicReference<Float> shard = new AtomicReference<>();
        assertFalse(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.exists(clusterState.metadata().persistentSettings()));
        }  
                } else {
                case 2:  
        }
        }
            } else {  
            persistentToApply.build(),
        Integer::valueOf,
        assertNoDeprecationWarnings();
            unknownSettings.add(Setting.simpleString("unknown.setting" + i, Property.NodeScope));
            @Override  
        );
        clusterState = updater.updateSettings(
        @Override
            } else {
            .collect(Collectors.toSet());
import java.util.stream.Stream;
        // register all the known settings (not that we do not register the unknown settings)
        final SettingsUpdater settingsUpdater = new SettingsUpdater(clusterSettings);
        for (int i = 0; i < numberOfDynamicSettings; i++) {
        clusterState = updater.updateSettings(  
        for (int i = 0; i < numberOfArchivedSettings; i++) {
        @Override
                case 0:  
            }  
    private static List<Setting<String>> unknownSettings(int numberOfUnknownSettings) {
        ClusterState.Builder builder = ClusterState.builder(new ClusterName("foo"));  
            if (existingPersistentSettings.keys().contains(unknownSetting.getKey())) {
            logger.info("", ex);
        assertThat(cluster.getMetadata().settings().get(SETTING_FOO_HIGH.getKey()), equalTo("40"));  
        assertNull("updater only does a dryRun", shard.get());
            clusterState,  
import java.util.HashSet;  
                    .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), "not a float")  
        Metadata.Builder metadata = Metadata.builder()
import java.util.List;
    );  
        final List<Setting<String>> unknownSettings = unknownSettings(numberOfUnknownSettings);  
        // the unknown settings should be archived and not present in non-archived form
            logger
        final Settings.Builder existingPersistentSettings = Settings.builder();
                    transientToApply.put(dynamicSetting.getKey(), "new_value");
                assertThat(
        }
            )
                    existingPersistentSettings.put(dynamicSetting.getKey(), "existing_value");
                    .build()  
    public void testClusterBlock() {
            assertThat(clusterStateAfterUpdate.metadata().persistentSettings().keySet(), not(hasItem(unknownSetting.getKey())));  
                    .put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), 2.5)
        );
    );
            }
            }
        public Iterator<Setting<?>> settings() {
            build,
            switch (randomIntBetween(0, 2)) {
                existingTransientSettings.put(unknownSetting.getKey(), "value");  
            .collect(Collectors.toSet());  
            Stream.concat(archivedSettings.stream(), invalidSettings.stream())
                Settings.builder()  
        assertEquals(clusterState.blocks().global().size(), 0);
 * the Apache License, Version 2.0 (the "License"); you may
                    .put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), 1.5)
        // we will randomly apply some new dynamic persistent and transient settings
                assertThat(
            // force a settings update otherwise our assertions below will fail  
