        assertNull(group2 + " wasn't changed", results.get(group2));
        );
            Settings.EMPTY,
        service.applySettings(
        final Setting<String> indexInternalSetting = Setting.simpleString("index.private", Property.PrivateIndex, Property.IndexScope);
        assertEquals(2, diff.size());
                .putList("foo.test_list.list", "16", "17")
        assertEquals(diff.getAsList("foo.baz.quux", null), Arrays.asList("d", "e", "f"));
            () -> settings.validate(Settings.builder().put("index.store.type", "boom").put("i.am.not.a.setting", true).build(), false)
        });
                    Setting.groupSetting("foo.list.", Property.Final, Property.NodeScope),
        assertNotNull(settings.get("transport.tracer.include." + randomIntBetween(1, 100)));
        Settings groupThreeSettings = results.get(group3);
        assertThat(diff.getAsInt("some.prefix.foobar.somekey", null), equalTo(17));
        String group2 = randomAlphaOfLength(4);
        } catch (IllegalArgumentException e) {
            clusterSettings.getOrNull(failedSetting);
            }
        assertEquals(0, consumer.get());
import static org.hamcrest.CoreMatchers.startsWith;
            "other.",
        assertEquals("Failed to parse value [true] for setting [index.number_of_replicas]", e.getMessage());
        assertFalse(AbstractScopedSettings.isValidKey("\""));
        final Setting<String> newSetting = Setting.simpleString("foo.new", Property.NodeScope);
        target = Settings.builder().put(currentSettings);
            Settings.EMPTY,
                .putList(listBuilder.apply(group3), "5", "6")
        );
        try {
        diff = settings.diff(
        Setting<Integer> testSetting = Setting.intSetting("foo.bar", 1, Property.Dynamic, Property.NodeScope);
            "name",
        service.addAffixUpdateConsumer(intSetting, intConsumer, (s, k) -> {});
            Settings.builder()
            Settings.builder()
        AbstractScopedSettings clusterSettings = new ClusterSettings(
            SettingsException.class,
        clusterSettings.registerSetting(settingWithFallback);
            new HashSet<>(
        assertEquals(ref.get().size(), 2);
        clusterSettings.registerSetting(fallbackSetting);
                Settings.builder().put("some.final.group.new", 8).build(),
        Setting<Integer> testSetting = Setting.intSetting("foo.bar", 1, Property.Dynamic, Property.NodeScope);
    }
        final SettingsException e = expectThrows(SettingsException.class, () -> {
            if (k.v1().isEmpty() && k.v2() == 2) {
            Arrays.asList("a", "b", "c"),
        Function<String, String> intBuilder = g -> (prefix + g + "." + intSuffix);
                    return "foo.new";
        assertEquals(Arrays.asList(1), results.get(group2).v1());
                .putList(listBuilder.apply(group1), "16", "17")
                    Setting.groupSetting("foo.list.", Property.UnmodifiableOnRestore, Property.IndexScope, Property.NodeScope),
        diff = settings.diff(
        );
            (key) -> Setting.boolSetting(key, true, Property.NodeScope)
            )
                    return stringSetting;
        AbstractScopedSettings clusterSettings = new ClusterSettings(
        assertEquals("192.168.0.1,127.0.0.1", s.get("_ip"));
            prefix,
        Setting.AffixSetting<Integer> barSetting = Setting.affixKeySetting(
        try {
        assertFalse(settings.isUnmodifiableOnRestoreSetting("foo.group"));
        } catch (SettingsException ex) {
    public void testAffixGroupUpdateConsumer() {
import org.opensearch.common.settings.Setting.Property;
        );
            () -> settings.validate(
        assertEquals(2, intResults.get("test").intValue());
        final Settings upgradedSettings = service.upgradeSettings(settings);
                ClusterSettings.BUILT_IN_CLUSTER_SETTINGS
        assertNull("test_list wasn't changed", listResults.get("test_list"));
        final ClusterSettings clusterSettings = new ClusterSettings(settings, Collections.emptySet());
        service.addAffixMapUpdateConsumer(intSetting, intConsumer, (s, k) -> {});
 *     http://www.apache.org/licenses/LICENSE-2.0
                .putList(listBuilder.apply(group3), "5", "6") // added
            () -> nameSetting
        assertThat(remainingSetting.get(upgradedSettings), equalTo(remainingSetting.get(settings)));
        assertEquals(2, diff.size());
        assertEquals("boom", copy.get(IndexModule.INDEX_STORE_TYPE_SETTING)); // test fallback to node settings
        );
            Settings.EMPTY,
            "foo.new",
            listResults.clear();
            () -> stringSetting
        exc = expectThrows(
        listResults.clear();
    public void testGetOrNullWhenSettingIsRegisteredNodeSettingFallback() {
        ClusterSettings settings = new ClusterSettings(
            .put("foo.remaining", randomAlphaOfLength(8))
        assertNull("test_list wasn't changed", listResults.get("test_list"));
            Collections.emptyList(),
    }
 *
            fail("invalid value");
        expectThrows(NullPointerException.class, () -> service.addSettingsUpdateConsumer(null, consumer2::set, (i) -> {
        assertNull(diff.get("some.prefix.foo.somekey"));
        }));
    }
        groupTwoSettings = results.get(group2);
        Setting<Integer> fallbackSetting = Setting.intSetting("foo.bar", 10, Property.Dynamic, Property.NodeScope);
            service.addSettingsUpdateConsumer(testSetting2, consumer2::set);
                .putList("foo.test_list.list", "16", "17")
        assertEquals(Arrays.asList(16, 17), listSetting.getConcreteSettingForNamespace(group1).get(groupOneSettings));
        assertFalse(settings.isDynamicSetting("transport.tracer.include.BOOM"));
        IllegalArgumentException e = expectThrows(
        final IndexScopedSettings indexScopedSettings = new IndexScopedSettings(
            newSetting.get(upgradedSettings),
        Setting<Integer> finalSetting = Setting.intSetting("some.final.setting", 1, Property.Final, Property.NodeScope);
            Settings.EMPTY,
        );
        service.applySettings(
        assertThat(diff.getAsInt("foo.bar.baz", null), equalTo(1));
        BiConsumer<String, Settings> listConsumer = results::put;
        );
        );
        assertEquals(diff.getAsList("foo.bar.quux", null), Arrays.asList("a", "b", "c"));
            new HashSet<>(Arrays.asList(testSetting, testSetting2, CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE))
        assertThat(diff.getAsInt("foo.bar.baz", null), equalTo(1));
        try {
        final Level level = LogManager.getRootLogger().getLevel();
            "name",
                .build()
            "foo.",
        String listSuffix = randomAlphaOfLength(4);
                k,
        assertEquals(8, intResults.get("test_1").intValue());
        assertThat(diff.getAsInt("some.group.foobar", null), equalTo(17));
        Settings updates = Settings.builder().put(setting, value).build();
        final int count = randomIntBetween(1, 8);
        e = expectThrows(
        service.applySettings(
                    return oldSetting;
        assertFalse(AbstractScopedSettings.isValidKey(""));
        AbstractScopedSettings service = new ClusterSettings(Settings.EMPTY, new HashSet<>(Arrays.asList(intSetting, stringSetting)));
        assertEquals(7, results.get(group2).v2().intValue());
import java.util.concurrent.atomic.AtomicInteger;
        Setting<Integer> staticSetting = Setting.intSetting("some.static.setting", 1, Property.NodeScope);
            SettingsException.class,
        assertTrue(settings.isUnmodifiableOnRestoreSetting("foo.list.key"));
            )
        } catch (SettingsException e) {
            k -> Setting.intSetting(k, 1, Property.Dynamic, Property.NodeScope),
        assertEquals(2, results.get(group1).v1().size());
    public void testUpgradeComplexSetting() {
        Setting<Integer> testSetting = Setting.intSetting("foo.bar", 1, Property.Dynamic, Property.NodeScope);
    }
            .build();
        assertEquals(0, consumer2.get());
            FilterAllocationDecider.CLUSTER_ROUTING_REQUIRE_GROUP_SETTING.getConcreteSetting("cluster.routing.allocation.require.value")
            key -> Setting.simpleString(key, Property.NodeScope)
        assertEquals(0, consumer2.get());
                .build()
    public void testPrivateIndexSettingsFailsValidation() {
        service.validateUpdate(Settings.builder().put("foo.bar", 2).put("foo.bar.baz", 15).build());
        );
        service.addAffixGroupUpdateConsumer(Arrays.asList(intSetting, listSetting), listConsumer);
                Settings.builder(),
            assertEquals("illegal settings key: [index.]", e.getMessage());
        }
        final Setting<?> groupSetting = Setting.groupSetting("foo.", Property.NodeScope);
    }
        assertSame(TransportSettings.TRACE_LOG_INCLUDE_SETTING, settings.get("transport.tracer.include." + randomIntBetween(1, 100)));
            Settings.builder().put("foo.bar.baz", 17).putList("foo.bar.quux", "d", "e", "f").build()
        );
            listSuffix,
        Settings currentSettings = Settings.builder()
            + " removed settings";
        assertEquals(2, intSetting.getConcreteSettingForNamespace(group1).get(groupOneSettings).intValue());
        target = Settings.builder().put(currentSettings);
            new HashSet<>(Arrays.asList(fooBar, fooBarBaz, foorBarQuux, someGroup, someAffix))
        final Setting<String> indexInternalSetting = Setting.simpleString("index.internal", Property.InternalIndex, Property.IndexScope);
    }
                    Setting.groupSetting("foo.group.", Property.UnmodifiableOnRestore, Property.IndexScope, Property.NodeScope),
        e = expectThrows(
            Collections.emptyList(),
        assertThat(exc.getMessage(), containsString("final node setting [some.final.setting]"));
        assertTrue(newSetting.exists(upgradedSettings));
        );
        final AbstractScopedSettings service = new ClusterSettings(
        diff = settings.diff(
import java.util.function.Consumer;
        assertEquals(2, intResults.get("test").intValue());
        results.clear();
        Settings settings = Settings.builder().setSecureSettings(secureSettings).build();
        try {
        Settings diff = settings.diff(Settings.builder().put(dependedSettingName, 2).build(), Settings.EMPTY);
        assertEquals(2, groupOneSettings.size());
        // Ensure that the value is correctly calculated if neither is set
        assertEquals(1, results.size());
                .putList(listBuilder.apply(group1), "16", "17")
            () -> service.updateDynamicSettings(
        assertEquals(0, listResults.size());
                equalTo("new." + oldSetting.getConcreteSettingForNamespace(concrete).get(settings))
                Settings.builder(),
        );
                .put(intBuilder.apply(group1), 4) // modified
            concretes.add(concrete);
        );
 * GitHub history for details.
        String group3 = randomAlphaOfLength(5);
            Settings.EMPTY,
        assertEquals(8, intResults.get("test_1").intValue());
        BiConsumer<String, Integer> intConsumer = intResults::put;
            Collections.singleton(SecureSetting.secureString("some.secure.setting", null))
        );
        ClusterSettings clusterSettings2 = new ClusterSettings(
                .put(intBuilder.apply(group1), 2)
            .put("index.some.dyn.setting", 1)
            (k) -> Setting.listSetting(k, Arrays.asList("1"), Integer::parseInt, Property.Dynamic, Property.NodeScope)
                    Setting.intSetting("foo.bar.baz", 1, Property.NodeScope)
        // affix setting - complex matcher
                    ? nameFallbackSetting.getConcreteSettingForNamespace(k)
        Settings currentSettings = Settings.builder()
        service.applySettings(
    public void testNoopSettingsUpdate() {
        settings.validate(Settings.builder().put("index.store.type", "boom").build(), false);
            aC.set(a);
        ClusterSettings service = new ClusterSettings(currentSettings, new HashSet<>(Arrays.asList(dynamicSetting, staticSetting)));
        assertThat(diff.getAsInt(dependentSettingName, null), equalTo(11));
        assertEquals(0, aC.get());
        assertThat(e, hasToString(containsString(message)));
        assertThat(diff.getAsInt("some.prefix.foobar.somekey", null), equalTo(17));
            Collections.singleton(new SettingUpgrader<List<String>>() {
    }
import java.util.stream.Collectors;
        );
            Settings.builder().put("some.group.foobar", 17).put("some.group.foo", 25).build()
    public void testResetSettingWithIPValidator() {
                .put("foo.test_1.bar", 8)
    public void testGetOrNullWhenSettingIsSetInNodeSettings() {
        });
                .put(intBuilder.apply(group1), 2)
            (k) -> Setting.simpleString(k, Property.Dynamic, Property.NodeScope)
            () -> settings.validate(Settings.builder().put("index.numbe_of_replica", "1").build(), false)
        try {
        assertEquals(Arrays.asList(16, 17), listSetting.getConcreteSettingForNamespace(group1).get(groupOneSettings));
        try {
        ClusterSettings settings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        );
        );
        service.validate(Settings.builder().put("foo.test.bar", 7).put("foo.test.name", "valid").build(), true);
        service.applySettings(
            assertEquals(Level.TRACE, LogManager.getRootLogger().getLevel());
    }
        assertEquals(Arrays.asList(5, 6), results.get(group3).v1());
            Settings.builder().put("some.prefix.foo.somekey", 5).build(),
            ClusterSettings settings = new ClusterSettings(builder.build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertTrue(AbstractScopedSettings.isValidAffixKey("split.prefix.*.split.suffix"));
    }
            })
            assertEquals("illegal settings key: [foo.bar] must start with [index.]", e.getMessage());
                public Setting<List<String>> getSetting() {
import static org.hamcrest.Matchers.hasToString;
            Property.NodeScope
        assertTrue(settings.isUnmodifiableOnRestoreSetting("foo.int"));
                )
        // nothing should happen, validation should not throw an exception
    public void testAddConsumerAffixMap() {
        final Settings settings = Settings.builder()
        assertEquals(8, dynamicSetting.get(target.build()).intValue());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                assertEquals("complex setting key: [foo.bar] overlaps existing setting key: [foo.]", e.getMessage());
        final AbstractScopedSettings service = new ClusterSettings(
        };
            IllegalArgumentException ex = expectThrows(
            affixResults.putAll(map);
 * Modifications Copyright OpenSearch Contributors. See
                    return "new." + value;
            "bar",
        try {
                .put("foo.test_1.bar", 7)
        IndexScopedSettings copy = settings.copy(
import static org.hamcrest.CoreMatchers.equalTo;
        assertTrue(settings.isUnmodifiableOnRestoreSetting("foo.group.key"));
            final Settings settings = Settings.builder().put("index.internal", "internal").build();
        assertThat(newSetting.get(upgradedSettings), equalTo("new." + oldSetting.get(settings)));
            (k) -> Setting.intSetting(k, 1, Property.Dynamic, Property.NodeScope),
    public void testTupleAffixUpdateConsumer() {
                newSetting.getConcreteSettingForNamespace(concrete).get(upgradedSettings),
        );
        assertNull(group2 + " wasn't changed", results.get(group2));
        String intSuffix = randomAlphaOfLength(3);
        assertEquals(0, consumer.get());
        assertTrue(service.updateDynamicSettings(Settings.builder().putNull("*").build(), target, update, "node"));
            final Settings settings = Settings.builder().put("index.private", "private").build();
            assertEquals("illegal value can't update [foo.bar.baz] from [1] to [-15]", ex.getMessage());
    public void testGetOrNullWhenSettingIsNotRegistered() {
        assertEquals(0, consumer2.get());
            IllegalArgumentException.class,
            Collections.singleton(new SettingUpgrader<String>() {
            settings.applySettings(Settings.builder().build());
        intResults.clear();
        AbstractScopedSettings service = new ClusterSettings(Settings.EMPTY, new HashSet<>(Arrays.asList(prefixSetting, otherSetting)));
        expectThrows(SettingsException.class, () -> service.addSettingsUpdateConsumer(wrongKeySetting, consumer2::set, (i) -> {
                .put("foo.test.bar", 2)
        } catch (SettingsException ex) {
        assertEquals(6, staticSetting.get(target.build()).intValue());
        assertEquals(Arrays.asList(18, 19, 20), listResults.get("test_list_1"));
        assertEquals(2, intResults.size());
        Setting<Integer> testSetting = Setting.intSetting("foo.bar", 1, Property.Dynamic, Property.NodeScope);
        );
            new ClusterSettings(Settings.EMPTY, settings);
 * the Apache License, Version 2.0 (the "License"); you may
        Setting.AffixSetting<Integer> intSetting = Setting.affixKeySetting(
                .put("foo.test.bar", 2)
        );
        Settings updates = Settings.builder().putNull("index.routing.allocation.require._ip").put("index.some.dyn.setting", 1).build();
        IndexMetadata metadata = IndexMetadata.builder(name).settings(build).build();
import java.util.Collections;
        assertFalse(settings.isDynamicSetting("foo.bar.baz"));
import java.util.ArrayList;
        Settings.Builder update = Settings.builder();
            ClusterSettings settings = new ClusterSettings(
        results.clear();
                Settings.builder().put(currentSettings),
        final Setting.AffixSetting<String> remainingSetting = Setting.affixKeySetting(
            Collections.singleton(internalIndexSetting)
        assertTrue(diffed.isEmpty());
        results.clear();
    public void testDependentSettingsWithFallback() {
        assertEquals(0, consumer2.get());
        assertThat(diff.getAsInt(dependedSettingName, null), equalTo(1));
                    return "new." + value;
        assertEquals(2, listResults.size());
            key -> Setting.simpleString(key, Property.NodeScope)
        );
        AbstractScopedSettings clusterSettings = new ClusterSettings(Settings.EMPTY, new HashSet<>(Arrays.asList(fallbackSetting)));
            "foo.old",
            .build();
            Settings.builder().put("some.group.foo", 5).build(),
        assertThat(diff.getAsInt("foo.bar", null), equalTo(1));
        final Setting<String> oldSetting = Setting.simpleString("foo.old", Property.NodeScope);
        Setting<Integer> testSetting2 = Setting.intSetting("foo.bar.baz", 1, Property.Dynamic, Property.NodeScope);
        assertEquals(Arrays.asList(1), listSetting.getConcreteSettingForNamespace(group2).get(groupTwoSettings));
            );
                    .build()
            if (i == 42) throw new AssertionError("empty key");
        assertNull(group2 + " wasn't changed", results.get(group2));
            "name",
        assertEquals(0, results.size());
                "node"
            assertTrue(newSetting.getConcreteSettingForNamespace(concrete).exists(upgradedSettings));
        IndexScopedSettings settings = new IndexScopedSettings(
        assertNull(group1 + " wasn't changed", results.get(group1));
import org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider;
                }
        String group1 = randomAlphaOfLength(3);
                Settings.builder().put(currentSettings),
        assertNull(target.build().getAsInt("archived.foo.bar", null));
            assertEquals("illegal value can't update [foo.bar.baz] from [1] to [-15]", ex.getMessage());
        AbstractScopedSettings clusterSettings = new ClusterSettings(
    }
            settings.applySettings(Settings.builder().put("logger._root", "TRACE").build());
        Setting.AffixSetting<String> stringSetting = Setting.affixKeySetting(
        try {
        assertFalse(AbstractScopedSettings.isValidAffixKey(""));
        assertThat(diff.getAsInt("foo.bar", null), equalTo(1));
            assertEquals("Setting is not registered for key [foo.bar.baz]", ex.getMessage());
        final IndexScopedSettings indexScopedSettings = new IndexScopedSettings(
        diff = settings.diff(
            Settings.builder()
            .build();
    public void testFallbackToLoggerLevel() {
            (k) -> Setting.intSetting(k, 1, Property.Dynamic, Property.NodeScope)
            assertTrue(remainingSetting.getConcreteSettingForNamespace(concrete).exists(upgradedSettings));
            );
        assertEquals(Arrays.asList(18, 19, 20), listSetting.getConcreteSettingForNamespace(group2).get(groupTwoSettings));
import java.util.Arrays;
            .put("some.dyn.setting", 5)
    }
            );
            equalTo(oldSetting.get(settings).stream().map(s -> "new." + s).collect(Collectors.toList()))
        Setting<Boolean> someAffix = Setting.affixKeySetting(
        assertEquals(1, intResults.size());
        final AbstractScopedSettings service = new ClusterSettings(
        AtomicReference<List<String>> ref = new AtomicReference<>();
        Function<String, String> listBuilder = g -> (prefix + g + "." + listSuffix);
                Arrays.asList(
import java.util.concurrent.atomic.AtomicReference;
        Settings concurrentSearchModeSetting = Settings.builder()
                public Setting.AffixSetting getSetting() {
            assertEquals(level, LogManager.getRootLogger().getLevel());
        assertNull("test wasn't changed", intResults.get("test"));
            prefix,
                .build()
        assertEquals(15, bC.get());
        assertEquals(0, bC.get());
            )
                public String getKey(final String key) {
        Function<String, String> listBuilder = g -> (prefix + g + "." + listSuffix);
 * ownership. Elasticsearch licenses this file to you under
 *
        assertEquals(2, groupOneSettings.size());
 * this file be licensed under the Apache-2.0 license or a
        );
            (k) -> Setting.listSetting(k, Arrays.asList("1"), Integer::parseInt, Property.Dynamic, Property.NodeScope)
                .putList("foo.test_list_1.list", "18", "19", "20")
        assertThat(diff.getAsInt(dependentSettingName, null), equalTo(12));
        assertEquals(5, dynamicSetting.get(target.build()).intValue());
                .putList(listBuilder.apply(group1), "16", "17")
        assertEquals("Failed to parse value [true] for setting [index.number_of_replicas]", e.getMessage());
 * license agreements. See the NOTICE file distributed with
                    return "foo.new";
                .put(intBuilder.apply(group2), 7)
        service.addAffixUpdateConsumer(listSetting, intSetting, listConsumer, (s, k) -> {
        assertEquals(setting, ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING);
            "name",
        assertTrue(settings.isUnmodifiableOnRestoreSetting("foo.list.0.key"));
        assertEquals(0, intResults.size());
                .putNull(listBuilder.apply(group2)) // removed
        );
                }
        final Settings settings = Settings.builder().putList("foo.old", values).build();
        AbstractScopedSettings clusterSettings = new ClusterSettings(
        );
            assertEquals(Level.ERROR, LogManager.getRootLogger().getLevel());
            () -> settings.validate("index.number_of_replicas", Settings.builder().put("index.number_of_replicas", "true").build(), false)
        assertNull(target.build().getAsInt("archived.foo.bar", null));
        assertFalse(AbstractScopedSettings.isValidKey("a b"));
        };
        Map<String, Integer> intResults = new HashMap<>();
            )
        Setting setting = settings.get("cluster.routing.allocation.require.value");
        String unknownMsgSuffix = " please check that any required plugins are installed, or check the breaking changes documentation for"
                .putNull("foo.test_list_1.list")
        final IndexScopedSettings indexScopedSettings = new IndexScopedSettings(
        Setting.AffixSetting<List<Integer>> listSetting = Setting.affixKeySetting(
                equalTo(remainingSetting.getConcreteSettingForNamespace(concrete).get(settings))
        assertEquals(2, intResults.size());
        assertThat(exc.getMessage(), containsString("final node setting [some.final.group.foo]"));
                "node"
    public static IndexMetadata newIndexMeta(String name, Settings indexSettings) {
            () -> service.updateSettings(
            .put(indexSettings)
        IndexScopedSettings settings = new IndexScopedSettings(Settings.EMPTY, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
            Function.identity(),
                @Override
        final Settings settings = builder.build();
        AtomicInteger consumer = new AtomicInteger();
        Settings.Builder builder = Settings.builder().put("logger.level", property);
        AbstractScopedSettings service = new ClusterSettings(Settings.EMPTY, new HashSet<>(Arrays.asList(intSetting, listSetting)));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            Settings.builder().put("some.group.foobar", 17).put("some.group.foo", 25).build()
        update = Settings.builder();
        );
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(AbstractScopedSettings.isValidAffixKey("prefix.*.suffix."));
    public void testOverlappingComplexMatchSettings() {
                .put(intBuilder.apply(group2), 7)
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
        assertEquals(1, copy.get(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING).intValue());
                    if ("valid".equals(dependency) == false) {
 * You may obtain a copy of the License at
        Setting<Integer> dynamicSetting = Setting.intSetting("index.some.dyn.setting", 1, Property.Dynamic, Property.IndexScope);
        AbstractScopedSettings service = new ClusterSettings(Settings.EMPTY, new HashSet<>(Arrays.asList(intSetting, stringSetting)));
            "list",
    public void testKeyPattern() {
        Setting.AffixSetting<Integer> intSetting = Setting.affixKeySetting(
        for (int i = 0; i < length; i++) {
            settings.applySettings(Settings.builder().put("logger.test", "TRACE").build());
 * Licensed to Elasticsearch under one or more contributor
        }
        assertEquals(0, intResults.size());
            SettingsException.class,
            IllegalArgumentException.class,
        }
        String listSuffix = randomAlphaOfLength(4);
        );
                    return value.stream().map(s -> "new." + s).collect(Collectors.toList());
            "fallback.",
        service.validate(Settings.builder().put("fallback.test.name", "test").put("foo.test.bar", 7).build(), true);
            SettingsException.class,
        settings.updateDynamicSettings(updates, Settings.builder().put(currentSettings), builder, "node");
        };
                    return oldSetting;
        clusterSettings.registerSetting(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE);
        service.applySettings(Settings.builder().put("eggplant._name", 2).build());
        );
    public void testValidateSecureSettings() {
        Setting.AffixSetting<String> stringSetting = Setting.affixKeySetting(
            Settings.builder()
            "foo.",
        assertFalse(settings.isFinalSetting("foo.list"));
        settings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThat(diff.getAsInt("foo.bar.baz", null), equalTo(17));
        service.applySettings(
        assertEquals(0, listResults.size());
            final String concrete = randomAlphaOfLength(8);
        Setting<Integer> wrongKeySetting = Setting.intSetting("foo.bar.wrong", 1, Property.Dynamic, Property.NodeScope);
        Setting<Integer> testSetting = Setting.intSetting("foo.bar", 1, Property.Dynamic, Property.NodeScope);
        assertNull(group3 + " wasn't changed", results.get(group3));
        AbstractScopedSettings service = new ClusterSettings(Settings.EMPTY, new HashSet<>(Arrays.asList(testSetting, testSetting2)));
        indexScopedSettings.validate(settings, false, /* validateInternalOrPrivateIndex */ false);
    public void testAffixKeyPattern() {
            Settings.builder().put("some.prefix.foo.somekey", 5).build(),
        assertEquals("unknown setting [i.am.not.a.setting]" + unknownMsgSuffix, settingsException.getMessage());
        );
            new IndexScopedSettings(Settings.EMPTY, Collections.singleton(Setting.boolSetting("index.", true, Property.IndexScope)));
import java.util.Set;
        assertEquals(7, intResults.get("test_1").intValue());
    public void testGetOrNullWhenSettingScopeDoesntMatch() {
        Setting<Integer> settingWithFallback = Setting.intSetting("foo.fallback", fallbackSetting, 1, Property.Dynamic, Property.NodeScope);
                Settings.builder().put("index.number_of_shards", 8).build(),
    public void testUpgradeSettingsNoChangesPreservesInstance() {
                consumer.set(a);
        });
        final List<String> concretes = new ArrayList<>(count);
        }
        }
            assertThat(
        Settings currentSettings = Settings.builder().put(setting, value).build();
import java.util.LinkedHashSet;
        ClusterSettings service = new ClusterSettings(currentSettings, new HashSet<>(Arrays.asList(finalSetting, finalGroupSetting)));
                .put(intBuilder.apply(group2), 7)
        clusterSettings.registerSetting(settingWithFallback);
                    .putList(listBuilder.apply(group3), "5", "6")
                .putList("foo.test_list.list", "16", "17")
        listResults.clear();
 * under the License.
        );
        assertNull(diff.getAsList("foo.bar.quux", null)); // affix settings don't know their concrete keys
    }
        Setting<Integer> failedSetting = Setting.intSetting("foo.bar.scope.fail", 1, Property.Dynamic, Property.IndexScope);
        final Setting<String> internalIndexSetting = Setting.simpleString("index.internal", Property.InternalIndex, Property.IndexScope);
        assertEquals(2, intResults.size());
            new IndexScopedSettings(Settings.EMPTY, Collections.singleton(Setting.groupSetting("index. foo.", Property.IndexScope)));
        );
        final Setting<String> internalIndexSetting = Setting.simpleString("index.private", Property.PrivateIndex, Property.IndexScope);
            assertFalse(oldSetting.getConcreteSettingForNamespace(concrete).exists(upgradedSettings));
            new HashSet<>(Arrays.asList(testSetting, testSetting2))
                .build()
                .put("some.prefix.foobar.somekey", 17)
        IndexScopedSettings settings = new IndexScopedSettings(
        assertThat(diff.getAsInt("foo.bar.baz", null), equalTo(1));
            () -> service.updateDynamicSettings(
            "foo.old.",
        assertEquals(0, consumer2.get());
                .put(intBuilder.apply(group1), 2)
        assertThat(exc.getMessage(), containsString("final node setting [some.final.group.new]"));
        String setting = "index.routing.allocation.require._ip";
                "node"
        AtomicInteger consumer2 = new AtomicInteger();
            Settings.builder()
import java.util.List;
            assertThat(
            assertEquals(property, LogManager.getLogger("test").getLevel());
        }
        Setting.AffixSetting<Integer> otherSetting = Setting.prefixKeySetting(
            Property.NodeScope
        MockSecureSettings secureSettings = new MockSecureSettings();
                    return "foo.new";
            Function.identity(),
            Settings.builder()
        Map<String, Tuple<List<Integer>, Integer>> results = new HashMap<>();
        assertEquals(diff.getAsList("foo.bar.quux", null), Arrays.asList("a", "b", "c"));
                    .put(intBuilder.apply(group2), 7)
        assertEquals(2, listResults.size());
                consumer2.set(b);
            )
        );
    }
            new IndexScopedSettings(Settings.EMPTY, Collections.singleton(Setting.simpleString("foo.bar", Property.IndexScope)));
                }
        assertTrue(settings.isFinalSetting("foo.list.0.key"));
            Loggers.setLevel(LogManager.getRootLogger(), level);
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;
import org.opensearch.index.IndexModule;
        assertEquals(2, diff.size());
        assertEquals(diff.getAsList("foo.bar.quux", null), Arrays.asList("a", "b", "c"));
    }
            }
        assertTrue(ref.get().contains("internal:index/shard/recovery/*"));
        clusterSettings.applySettings(Settings.builder().put(fallbackSetting.getKey(), 100).build());
            )
        } catch (IllegalArgumentException ex) {
        assertTrue(AbstractScopedSettings.isValidKey("a.b.c.d"));
        assertEquals(Arrays.asList(18, 19, 20), listResults.get("test_list_1"));
        Setting.AffixSetting<Integer> prefixSetting = Setting.prefixKeySetting(
        assertEquals(2, groupTwoSettings.size());
        );
        assertEquals(6, staticSetting.get(target.build()).intValue());
        Setting<Integer> fooBar = Setting.intSetting("foo.bar", 1, Property.Dynamic, Property.NodeScope);
            "quux",
        );
        service.validate(Settings.builder().put("foo.test.name", "test").put("foo.test.bar", 7).build(), true);
            "suffix",
            fail("setting scope doesn't match");
            () -> service.validate(Settings.builder().put("foo.test.bar", 7).build(), true)
        settings.add(groupFirst ? listSetting : groupSetting);
        assertEquals(9, target.build().getAsInt("archived.foo.bar", null).intValue());
        assertEquals(1, listResults.size());
        );
                @Override
import java.util.HashMap;
        Setting.AffixSetting<Integer> intSetting = Setting.affixKeySetting(
        );
        service.addAffixMapUpdateConsumer(prefixSetting, consumer, (s, k) -> {});
        assertTrue(AbstractScopedSettings.isValidAffixKey("prefix.*.suffix"));
            )
            SettingsException.class,
        } catch (IllegalArgumentException ex) {
        assertEquals("[foo.test.bar] is set but [name] is [invalid]", e.getMessage());
        final Settings upgradedSettings = service.upgradeSettings(settings);
                "index"
        final Level testLevel = LogManager.getLogger("test").getLevel();
        Setting<Integer> fooBarBaz = Setting.intSetting("foo.bar.baz", 1, Property.NodeScope);
                Property.NodeScope
        );
        Map<String, List<Integer>> listResults = new HashMap<>();
        groupOneSettings = results.get(group1);
    }
        );
    }
            Settings.EMPTY,
        assertEquals(0, consumer.get());
        Setting<Integer> testSetting2 = Setting.intSetting("foo.bar.baz", 1, Property.Dynamic, Property.NodeScope);
        try {
import java.util.Map;
        );
        ClusterSettings settings = new ClusterSettings(
                .putList(listBuilder.apply(group1), "16", "17")
                .putList(listBuilder.apply(group2), "18", "19", "20")
            "somekey",
        final AbstractScopedSettings service = new ClusterSettings(
            "foo.remaining.",
                @Override
        Setting<Settings> someGroup = Setting.groupSetting("some.group.", Property.Dynamic, Property.NodeScope);
        expectThrows(
        results.clear();
            "bar",
        assertNotNull(settings.get("foo.bar.baz"));
            new HashSet<>(Collections.singletonList(IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING))
        assertEquals(diff.getAsList("foo.bar.quux", null), Arrays.asList("d", "e", "f"));
                Settings.builder().put("some.final.setting", 8).build(),
                .put(intBuilder.apply(group2), 7)
            Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build()
        assertEquals(0, affixResults.size());
            );
    }
        final SettingsException e = expectThrows(SettingsException.class, () -> {
                Settings.builder().put("index.similarity.classic.type", "mine").build(),
        assertEquals(Arrays.asList(16, 17), listResults.get("test_list"));
        );
        Setting<Integer> settingWithFallback = Setting.intSetting("foo.fallback", fallbackSetting, 1, Property.Dynamic, Property.NodeScope);
        Setting.AffixSetting<Integer> intSetting = Setting.affixKeySetting(
        assertEquals(9, target.build().getAsInt("archived.foo.bar", null).intValue());
                .put(intBuilder.apply(group2), 7)
        final AbstractScopedSettings service = new ClusterSettings(
                .put("foo.test.bar", 2)
            builder.put("foo.old." + concrete + ".suffix", randomAlphaOfLength(8));
        final Setting<String> oldSetting = Setting.simpleString("foo.old", Property.NodeScope);
        assertFalse(settings.isFinalSetting("foo.int.baz"));
        } catch (SettingsException e) {
        assertThat(diff.getAsInt("foo.bar.baz", null), equalTo(1));
                .putList(listBuilder.apply(group1), "16", "17")
        Settings diff = settings.diff(Settings.builder().put("foo.bar", 5).build(), Settings.EMPTY);
                () -> settings.validate(Settings.builder().put("logger._root", "boom").build(), false)
            () -> service.validate(Settings.builder().put("foo.test.bar", 7).build(), true)
    }
            "some.prefix.",
        }
        } catch (IllegalArgumentException e) {
        assertEquals(6, staticSetting.get(target.build()).intValue());
        settings.addSettingsUpdateConsumer(TransportSettings.TRACE_LOG_INCLUDE_SETTING, ref::set);
        Setting<Integer> dynamicSetting = Setting.intSetting("some.dyn.setting", 1, Property.Dynamic, Property.NodeScope);
            Settings.EMPTY,
        assertNull("test wasn't changed", intResults.get("test"));
        assertEquals(2, aC.get());
            Settings.EMPTY,
        Settings build = Settings.builder()
        assertEquals(15, consumer2.get());
        ClusterSettings clusterSettings = new ClusterSettings(
            logger.info("--> consuming settings {}", map);
                )
            intResults.putAll(map);
        assertEquals(diff.getAsList("foo.bar.quux", null), Arrays.asList("d", "e", "f"));
                .put(intBuilder.apply(group1), 2)
                .put(intBuilder.apply(group2), 7)
                .build()
    }
        Setting<Integer> testSetting = Setting.intSetting("foo.bar", 1, Property.Dynamic, Property.NodeScope);
        diff = settings.diff(
                public String getValue(final String value) {
        results.clear();
            (key) -> Setting.boolSetting(key, true, Property.NodeScope)
            (k) -> Setting.simpleString(k, Property.Dynamic, Property.NodeScope)
            () -> service.updateDynamicSettings(
        assertNull(diff.get("some.group.foo"));
/*
        final SettingsException e = expectThrows(
            new IndexScopedSettings(Settings.EMPTY, Collections.singleton(Setting.groupSetting("foo.bar.", Property.IndexScope)));
            assertEquals("setting foo.bar.register.fail has not been registered", ex.getMessage());
        assertEquals(1, results.get(group2).v1().size());
                @Override
            IllegalArgumentException.class,
            Collections.singleton(SecureSetting.secureString("some.secure.setting", null))
            Settings.builder().put("some.prefix.foobar.somekey", 17).put("some.prefix.foo.somekey", 18).build()
        service.applySettings(
 */
        }
                public Setting<String> getSetting() {
        results.clear();
            )
        SettingsException e = expectThrows(
    public void testDependentSettings() {
            new HashSet<>(Arrays.asList(oldSetting, newSetting, remainingSetting)),
    }
        assertThat(upgradedSettings, sameInstance(settings));
        Settings settings = Settings.builder().put(fallbackSetting.getKey(), 100).build();
        } finally {
    }
                .putList(listBuilder.apply(group3), "5", "6") // added
                .put(intBuilder.apply(group1), 2)
import java.util.function.Function;
            )
        assertEquals(7, intResults.get("test_1").intValue());
            assertEquals(level, LogManager.getRootLogger().getLevel());
                Property.Dynamic,
 * KIND, either express or implied.  See the License for the
        final Settings settings = Settings.builder().put("foo.remaining", randomAlphaOfLength(8)).build();
        update = Settings.builder();
                Settings.builder()
        diff = settings.diff(
        String prefix = randomAlphaOfLength(3) + "foo.";
    }
        );
        );
        assertNull(clusterSettings.getOrNull(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING));
                Settings.builder().put("some.dyn.setting", 8).putNull("some.static.setting").build(),
        Setting<Integer> testSetting2 = Setting.intSetting("foo.bar.baz", 1, Property.Dynamic, Property.NodeScope);
            listResults.putAll(map);
            fail();
import java.util.function.BiConsumer;
        clusterSettings.applySettings(
        final Setting<List<String>> newSetting = Setting.listSetting(
        assertEquals(2, results.get(group1).v2().intValue());
        assertEquals(6, staticSetting.get(target.build()).intValue());
        // array settings - complex matcher
            new HashSet<>(Arrays.asList(oldSetting, newSetting, remainingSetting)),
                .putList("foo.test_list_1.list", "18", "19", "20")
                Settings.builder().put(currentSettings),
        assertTrue(settings.isDynamicSetting("foo.bar"));
                public void validate(final String key, final Object value, final Object dependency) {
 * Unless required by applicable law or agreed to in writing,
        assertEquals(0, bC.get());
        assertFalse(AbstractScopedSettings.isValidAffixKey("*.suffix"));
            new HashSet<>(
            new Setting.AffixSettingDependency() {
                throw new IllegalArgumentException("boom");
        assertEquals(1, listResults.size());
    public void testIsUnmodifiableOnRestore() {
            currentSettings,
            Settings.EMPTY,
        );
        final Setting.AffixSetting<String> newSetting = Setting.affixKeySetting(
        assertTrue(service.updateDynamicSettings(Settings.builder().putNull("some.dyn.setting").build(), target, update, "node"));
        assertEquals(7, intSetting.getConcreteSettingForNamespace(group2).get(groupTwoSettings).intValue());
            (s) -> Integer.toString(dependedSetting.get(s) + 10),
        assertEquals(2, intResults.get("test").intValue());
        assertEquals(1, results.size());
        );
    }
        Map<String, Settings> results = new HashMap<>();
        );
    }
        new IndexScopedSettings(Settings.EMPTY, Collections.singleton(Setting.boolSetting("index.boo", true, Property.IndexScope)));
                .putList("foo.test_list.list", "16", "17")
        ClusterSettings settings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        );
 */
            });
                public String getKey(final String key) {
        final String message = "can not update private setting [index.private]; this setting is managed by OpenSearch";
            (k) -> Setting.intSetting(k, 1, Property.Dynamic, Property.NodeScope)
import org.apache.logging.log4j.Level;
        );
        for (int i = 0; i < count; i++) {
        assertEquals(2, groupTwoSettings.size());
            "foo.",
        assertEquals(3, diff.size());
        assertEquals(0, results.size());
    }
                .put(intBuilder.apply(group2), 7)
                    Setting.intSetting("foo.int", 1, Property.Final, Property.NodeScope),
        secureSettings.setString("some.secure.setting", "secret");
        results.clear();
            currentSettings,
import org.opensearch.cluster.metadata.IndexMetadata;
        ClusterSettings settings = new ClusterSettings(
    public void testInternalIndexSettingsSkipValidation() {
            fail("an exception should have been thrown because settings overlap");
        AbstractScopedSettings service = new ClusterSettings(Settings.EMPTY, new HashSet<>(Arrays.asList(testSetting, testSetting2)));
            Settings.builder()
        Map<String, Integer> intResults = new HashMap<>();
        final List<String> values = length == 0 ? Collections.emptyList() : new ArrayList<>(length);
        Settings diff = settings.diff(Settings.builder().put("foo.bar", 5).build(), Settings.EMPTY);
        assertNull(diff.get("some.prefix.foo.somekey"));
        indexScopedSettings.validate(settings, false, /* validateInternalOrPrivateIndex */ false);
        Setting.AffixSetting<List<Integer>> listSetting = Setting.affixKeySetting(
        Map<String, String> s = IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING.getAsMap(currentSettings);
        assertThat(diff.getAsInt("foo.bar", null), equalTo(1));
                .put(intBuilder.apply(group2), 7)
        Setting<Integer> testSetting2 = Setting.intSetting("foo.bar.baz", 1, Property.Dynamic, Property.NodeScope);
                    .putList(listBuilder.apply(group1)) // modified to trip validator
            Settings.builder().put("foo.bar", 5).build(),
            (s) -> Setting.parseInt(s, 1, dependentSettingName),
        assertEquals(Arrays.asList(1), listResults.get("test_list_1")); // reset to default
        assertFalse(settings.isFinalSetting("foo.group"));
        assertEquals(Arrays.asList(18, 19, 20), listResults.get("test_list_1"));
    }
        final Setting<String> remainingSetting = Setting.simpleString("foo.remaining", Property.NodeScope);
        SettingsException settingsException = expectThrows(
        BiConsumer<String, Tuple<List<Integer>, Integer>> listConsumer = results::put;
    public void testGetOrNullWhenSettingIsSet() {
            values.add(randomAlphaOfLength(8));
        service.applySettings(
        );
            Collections.singleton(indexInternalSetting)
        final int length = randomIntBetween(0, 16);
        assertEquals(2, consumer.get());
    }
        assertEquals(1, diff.size());
 *
        assertEquals(1, dynamicSetting.get(target.build()).intValue());
        assertTrue(service.updateDynamicSettings(Settings.builder().putNull("archived.foo.bar").build(), target, update, "node"));
        Setting<List<String>> foorBarQuux = Setting.affixKeySetting(
        service.applySettings(
        Settings.Builder builder = Settings.builder();
                @Override
                @Override
            "suffix",
    public void testDiff() throws IOException {
            service.validateUpdate(Settings.builder().put("foo.bar", 2).put("foo.bar.baz", -15).build());
        final Setting<?> listSetting = Setting.listSetting("foo.bar", Collections.emptyList(), Function.identity(), Property.NodeScope);
        Setting<Settings> finalGroupSetting = Setting.groupSetting("some.final.group.", Property.Final, Property.NodeScope);
        }
                    return key.replaceFirst("^foo\\.old", "foo\\.new");
        );
        settings.add(groupFirst ? groupSetting : listSetting);
    public void testDiffWithDependentSettings() {
            fail("setting not registered");
            (key) -> Setting.listSetting(key, Arrays.asList("a", "b", "c"), Function.identity(), Property.NodeScope)
        settings.validate(updates, false);
        try {
        service.addSettingsUpdateConsumer(testSetting2, consumer2::set, (s) -> assertTrue(s > 0));
                @Override
    }
        assertEquals(3, copy.get(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING).intValue());
        });
        service.addSettingsUpdateConsumer(testSetting, testSetting2, (a, b) -> {
        String intSuffix = randomAlphaOfLength(3);
            k -> Setting.simpleString(k, Property.Dynamic, Property.NodeScope)
        }));
 * not use this file except in compliance with the License.
    }
        assertEquals(0, consumer2.get());
        assertTrue(newSetting.exists(upgradedSettings));
                "index.similarity.classic.type",
            settings.applySettings(Settings.builder().build());
        update = Settings.builder();
            Settings.builder()
                }
        );
            new HashSet<>(Arrays.asList(nameFallbackSetting, nameSetting, barSetting))
        MockSecureSettings secureSettings = new MockSecureSettings();
            (k) -> Setting.intSetting(k, 1, Property.Dynamic, Property.NodeScope),
                        throw new SettingsException("[" + key + "] is set but [name] is [" + dependency + "]");
            Settings.EMPTY,
        assertFalse(AbstractScopedSettings.isValidAffixKey("prefix.*"));
    }
                .put("foo.test_1.bar", 7)
        assertEquals(0, aC.get());
            prefix,
    }
                .put("foo.test_1.bar", 7)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    public void testUpgradeSetting() {
    }
            builder.put("foo.remaining." + concrete + ".suffix", randomAlphaOfLength(8));
                    Setting.groupSetting("foo.group.", Property.Final, Property.NodeScope),
        SettingsException ex = expectThrows(
        final String message = "can not update internal setting [index.internal]; this setting is managed via a dedicated API";
            affixResults.clear();
    }
            new HashSet<>(Arrays.asList(testSetting, testSetting2))
        assertNull(group1 + " wasn't changed", results.get(group1));
            SettingsException.class,
    }
        Setting<Integer> fooBar = Setting.intSetting("foo.bar", 1, Property.Dynamic, Property.NodeScope);
    public void testInternalIndexSettingsFailsValidation() {
        );
        assertThat(diff.getAsInt("foo.bar.baz", null), equalTo(17));
        );
        assertEquals(4, results.get(group1).v2().intValue());
        assertThat(ex.getMessage(), containsString("final index setting [index.number_of_shards], not updateable"));
                .putList(listBuilder.apply(group1), "16", "17")
        Setting<Integer> testSetting = Setting.intSetting("foo.bar", 1, Property.Dynamic, Property.NodeScope);
        final String dependentSettingName = "this.setting.depends.on.another";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                .putList(listBuilder.apply(group3), "5", "6")
                @Override
import java.io.IOException;
            newIndexMeta("foo", Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 3).build())
        assertThat(affixResults.get("_name"), equalTo(2));
    public void testGetOrNullWhenSettingIsNotSet() {
        );
        service.applySettings(Settings.builder().put("eggplant._name", 2).put("other.thing", 3).build());
            "foo.",
                .put(intBuilder.apply(group1), 4) // modified
        assertEquals(3, diff.size());
            Settings.EMPTY,
            service.applySettings(Settings.builder().put("foo.bar", 2).put("foo.bar.baz", -15).build());
        Setting<Integer> testSetting2 = Setting.intSetting("foo.bar.baz", 1, Property.Dynamic, Property.NodeScope);
                .build()
        AbstractScopedSettings clusterSettings = new ClusterSettings(
        }
        Settings.Builder target = Settings.builder().put(currentSettings);
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
import org.apache.logging.log4j.LogManager;
            fail();
            Function.identity(),
        assertThat(diff.getAsInt("foo.bar.baz", null), equalTo(1));
        final IndexScopedSettings indexScopedSettings = new IndexScopedSettings(
        assertEquals(7, intSetting.getConcreteSettingForNamespace(group2).get(groupTwoSettings).intValue());
                "node"
            intResults.clear();
            "list",
        service.applySettings(Settings.builder().put("foo.bar", 2).put("foo.bar.baz", 15).build());
            SettingsException.class,
                    Setting.intSetting("foo.int.baz", 1, Property.NodeScope)
        final Setting<List<String>> oldSetting = Setting.listSetting(
            new HashSet<>(Arrays.asList(dynamicSetting, IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING))
        final Settings settings = Settings.builder().put("index.internal", "internal").build();
        SettingsException exc = expectThrows(
        );
        assertThat(affixResults.get("_name"), equalTo(2));
    public void testDiffSecureSettings() {
        } finally {
            assertEquals("illegal settings key: [foo.bar.] must start with [index.]", e.getMessage());
            Settings.builder().put("some.prefix.foobar.somekey", 17).put("some.prefix.foo.somekey", 18).build()
        assertThat(diff.getAsInt("foo.bar.baz", null), equalTo(1));
        IllegalArgumentException iae = expectThrows(
                }
import org.opensearch.transport.TransportSettings;
                }
            Settings.EMPTY,
            "foo.",
    public void testGetSetting() {
                .build()
                .put("foo.test.bar", 2)
        );
            "eggplant.",
        assertTrue(settings.isFinalSetting("foo.list.key"));
        // Ensure that the value of the dependent setting is correctly calculated based on the "source" settings
            Settings.builder().put("index.store.type", "boom").build(),
}
            assertEquals(property, LogManager.getRootLogger().getLevel());
        assertEquals(1, s.size());
        clusterSettings.registerSetting(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING);
            (k) -> Setting.intSetting(k, 1, Property.Dynamic, Property.NodeScope)
        assertEquals(1, results.size());
        Setting<List<String>> foorBarQuux = Setting.listSetting(
        final Setting.AffixSetting<String> oldSetting = Setting.affixKeySetting(
            Settings.builder().put("some.prefix.foo.somekey", 5).build(),
        assertNull(diff.get("some.prefix.foo.somekey"));
            "some.prefix.",
                    Setting.intSetting("foo.bar", 1, Property.Dynamic, Property.NodeScope),
            Settings.builder().put("foo.bar.baz", 17).putList("foo.bar.quux", "d", "e", "f").build()
            Settings.EMPTY,
        );
        );
        assertThat(exc.getMessage(), containsString("final node setting [some.final.setting]"));
            .put("foo.old", randomAlphaOfLength(8))
            listSuffix,
 * this work for additional information regarding copyright
                .put("foo.test.bar", 2)
    public void testIsDynamic() {
        assertTrue(settings.isFinalSetting("foo.int"));
        assertEquals(Arrays.asList(16, 17), results.get(group1).v1());
                }
        final String dependedSettingName = "this.setting.is.depended.on";
            Property.Dynamic,
                .build()
            Settings.builder().put("some.group.foo", 5).build(),
                }
public class ScopedSettingsTests extends OpenSearchTestCase {
            Settings.builder()
            )
            new HashSet<>(Arrays.asList(testSetting, testSetting2))
        AtomicInteger aC = new AtomicInteger();
        assertTrue(service.updateDynamicSettings(Settings.builder().put("some.dyn.setting", 8).build(), target, update, "node"));
    }
        assertEquals(1, results.get(group3).v2().intValue());
            dependentSettingName,
        );
        SettingsException e = expectThrows(
            "bar",
            "bar",
                    }
        assertTrue(settings.isFinalSetting("foo.group.key"));
            })
        service.addSettingsUpdateConsumer(testSetting, consumer::set);
    public void testGetOrNullWhenSettingIsRegisteredWithFallback() {
        }
        assertEquals(Arrays.asList(18, 19, 20), results.get(group2).v1());
            service.addSettingsUpdateConsumer(testSetting, testSetting2, (a, b) -> {
            SettingsException.class,
        service.validate(Settings.builder().put("foo.test.bar", 7).put("foo.test.name", "invalid").build(), false);
        assertEquals(diff.getAsList("foo.bar.quux", null), Arrays.asList("x", "y", "z"));
        assertThat(diff.getAsInt("foo.bar.baz", null), equalTo(1));
                }
        assertThat(e, hasToString(containsString(message)));
            Settings.builder().put("foo.bar", 5).build(),
        final Settings upgradedSettings = service.upgradeSettings(settings);
            (k) -> Setting.listSetting(k, Arrays.asList("1"), Integer::parseInt, Property.Dynamic, Property.NodeScope)
        assertEquals(2, listResults.size());
                "_na_".equals(k)
        assertEquals(Arrays.asList(5, 6), listSetting.getConcreteSettingForNamespace(group3).get(groupThreeSettings));
        );
        assertTrue(ref.get().contains("internal:gateway/local*"));
            .put("some.static.setting", 6)
        clusterSettings.registerSetting(failedSetting);
            Collections.singleton(internalIndexSetting)
        assertEquals(0, bC.get());
                Settings.builder().put("some.final.group.foo", 5).build(),
        Map<String, List<Integer>> listResults = new HashMap<>();
        );
            Settings.EMPTY,
            k -> Setting.simpleString(
                Settings.builder().put("logger.level", "ERROR").build(),
    public void testResetSetting() {
        assertEquals(1, intResults.size());
                Settings.builder().put(currentSettings),
                .putList(listBuilder.apply(group1), "16", "17")
            Settings.EMPTY,
            Settings.EMPTY,
        } catch (SettingsException ex) {
            bC.set(b);
        assertEquals("boom", iae.getMessage());
        assertEquals(
            key -> Setting.simpleString(key, Property.NodeScope)
                @Override
                }
            if (i == 42) throw new AssertionError("wrong key");
        service.applySettings(
        assertEquals(Arrays.asList(16, 17), listResults.get("test_list"));
        assertEquals(9, target.build().getAsInt("archived.foo.bar", null).intValue());
import org.opensearch.test.OpenSearchTestCase;
        );
        ClusterSettings settings = new ClusterSettings(
        assertEquals(0, aC.get());
        AtomicInteger consumer = new AtomicInteger();
        );
                    return oldSetting;
            Settings.builder()
        );
                .build()
            clusterSettings.getOrNull(failedSetting);
        Settings settings = Settings.builder().setSecureSettings(secureSettings).build();
        IndexScopedSettings settings = new IndexScopedSettings(Settings.EMPTY, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
 * compatible open source license.
            .put("archived.foo.bar", 9)
        AtomicInteger consumer2 = new AtomicInteger();
        target = Settings.builder().put(currentSettings);
        service.validate(Settings.builder().put("foo.test.name", "test").put("foo.test.bar", 7).build(), true);
        Setting<Integer> fooBarBaz = Setting.intSetting("foo.bar.baz", 1, Property.NodeScope);
                Arrays.asList(
                    : nameFallbackSetting.getConcreteSetting(k.replaceAll("^foo", "fallback")),
                @Override
        assertEquals("missing required setting [foo.test.name] for setting [foo.test.bar]", e.getMessage());
            (k) -> Setting.intSetting(k, 1, Property.Dynamic, Property.NodeScope)
            () -> service.updateSettings(
 * specific language governing permissions and limitations
                .build()
            fail("setting is not registered");
            .put("index.routing.allocation.require._ip", "192.168.0.1,127.0.0.1")
        Consumer<Map<String, List<Integer>>> listConsumer = (map) -> {
                Settings.builder().putNull("some.final.setting").build(),
                public Setting<String> getSetting() {
            })
    }
                public String getKey(final String key) {
        );
        );
            "foo.bar.quux",
/*
            Settings.builder()
                .putNull("foo.test_list_1.list")
                public Setting<String> getSetting() {
            assertEquals("Unknown level constant [BOOM].", ex.getMessage());
 * The OpenSearch Contributors require contributions made to
        assertEquals(0, results.size());
        Setting<Boolean> someAffix = Setting.affixKeySetting(
    }
        new ClusterSettings(Settings.EMPTY, Collections.singleton(Setting.boolSetting("index.boo", true, Property.NodeScope)));
        Set<Setting<?>> settings = new LinkedHashSet<>(2);
                remainingSetting.getConcreteSettingForNamespace(concrete).get(upgradedSettings),
    }
            Settings.EMPTY,
        Function<String, String> intBuilder = g -> (prefix + g + "." + intSuffix);
            "foo.new.",
            Property.NodeScope
    public void testGet() {
        assertNull(diff.getAsList("foo.bar.quux", null)); // affix settings don't know their concrete keys
        service.applySettings(
            Loggers.setLevel(LogManager.getRootLogger(), level);
                Settings.builder(),
            "foo.",
            SettingsException.class,
        currentSettings = builder.build();
                IllegalArgumentException.class,
            IllegalArgumentException.class,
        assertFalse(settings.isUnmodifiableOnRestoreSetting("foo.list"));
                }
                @Override
        ClusterSettings settings = new ClusterSettings(
            () -> service.applySettings(
        );
        service.applySettings(
            "foo.",
        );
        ClusterSettings settings = new ClusterSettings(Settings.EMPTY, new HashSet<>(Arrays.asList(dependedSetting, dependentSetting)));
        );
                .putList("foo.test_list_1.list", "18", "19", "20")
                }
        AtomicInteger bC = new AtomicInteger();
        assertTrue(settings.isDynamicSetting("transport.tracer.include." + randomIntBetween(1, 100)));
        assertEquals(clusterSettings.getOrNull(settingWithFallback), Integer.valueOf(100));
                .putList("foo.baz.quux", "d", "e", "f")
            .build();
        AtomicInteger consumer2 = new AtomicInteger();
        try {
            settings,
            } else {
        assertEquals(Arrays.asList(16, 17), results.get(group1).v1());
        assertEquals(1, groupThreeSettings.size());
        assertTrue(AbstractScopedSettings.isValidAffixKey("prefix.*.split.suffix"));
        assertNull(settings.get("transport.tracer.include.FOO"));
            (k) -> Setting.intSetting(k, 1, Property.Dynamic, Property.NodeScope)
        );
        AbstractScopedSettings service = new ClusterSettings(Settings.EMPTY, new HashSet<>(Arrays.asList(intSetting, listSetting)));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                "node"
        Consumer<Map<String, Integer>> intConsumer = (map) -> {
    }
            new HashSet<>(Arrays.asList(oldSetting, newSetting)),
                Settings.builder(),
import org.opensearch.common.collect.Tuple;
        results.clear();
                @Override
import java.util.HashSet;
        } catch (SettingsException ex) {
    public void testPrivateIndexSettingsSkipValidation() {
        return metadata;
            .put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO)
import static org.hamcrest.CoreMatchers.containsString;
        assertEquals(Arrays.asList(16, 17), listResults.get("test_list"));
        assertEquals(1, results.size());
            assertEquals("Setting is not registered for key [foo.bar.baz]", ex.getMessage());
        target = Settings.builder().put(currentSettings);
        intResults.clear();
        assertThat(diff.getAsInt("some.prefix.foobar.somekey", null), equalTo(17));
            Settings.EMPTY,
        );
        String group1 = randomAlphaOfLength(3);
        assertNull(diff.get("some.group.foo"));
        }
        assertFalse(settings.isUnmodifiableOnRestoreSetting("foo.int.baz"));
        );
        // nothing should happen, validation should not throw an exception
        assertFalse(AbstractScopedSettings.isValidAffixKey("*"));
            (k) -> Setting.listSetting(k, Arrays.asList("1"), Integer::parseInt, Property.Dynamic, Property.NodeScope)
            "foo.",
            )
        String value = "192.168.0.1,127.0.0.1";
        Setting<Integer> testSetting2 = Setting.intSetting("foo.bar.baz", 1, Property.Dynamic, Property.NodeScope);
                .putList("foo.test_list.list", "16", "17")
    }
            )
                .build()
    public void testUpdateNumberOfShardsFail() {
        assertEquals(1, results.size());
            intSuffix,
        try {
        assertEquals(6, staticSetting.get(target.build()).intValue());
            .build();
        String group3 = randomAlphaOfLength(5);
        try {
        assertThat(diff.getAsInt("foo.bar", null), equalTo(1));
        Setting<Integer> fallbackSetting = Setting.intSetting("foo.bar", 10, Property.Dynamic, Property.NodeScope);
        assertNotNull(ref.get().size());
                )
            assertEquals(Level.TRACE, LogManager.getLogger("test").getLevel());
    }
    public void testValidateWithSuggestion() {
        }
        final Settings settings = Settings.builder().put("index.private", "private").build();
            Loggers.setLevel(LogManager.getLogger("test"), testLevel);
        assertEquals(2, results.size());
            () -> settings.validate(Settings.builder().put("index.store.type", "boom").put("index.number_of_replicas", true).build(), false)
            indexScopedSettings.validate(settings, false, /* validateInternalOrPrivateIndex */ true);
            (k) -> Setting.intSetting(k, 1, Property.Dynamic, Property.NodeScope)
        assertTrue(settings.isDynamicSetting("cluster.routing.allocation.require.value"));
                .put("some.prefix.foo.somekey", 18)
        Setting<Settings> someGroup = Setting.groupSetting("some.group.", Property.Dynamic, Property.NodeScope);
        assertThat(
        assertThat(diff.getAsInt("some.group.foobar", null), equalTo(17));
        } catch (SettingsException e) {
            Collections.singleton(new SettingUpgrader<String>() {
        update = Settings.builder();
        );
        assertEquals(0, aC.get());
            "suffix",
            SettingsException.class,
        clusterSettings.registerSetting(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE);
        final Settings upgradedSettings = service.upgradeSettings(settings);
        assertEquals(1, intSetting.getConcreteSettingForNamespace(group3).get(groupThreeSettings).intValue());
        );
        assertEquals(7, intResults.get("test_1").intValue());
        );
        assertTrue(remainingSetting.exists(upgradedSettings));
        Settings diffed = clusterSettings.diff(Settings.EMPTY, settings);
                .put(intBuilder.apply(group1), 2)
        assertEquals(0, s.size());
        AbstractScopedSettings clusterSettings = new ClusterSettings(settings, new HashSet<>(Arrays.asList(fallbackSetting)));
            SettingsException.class,
        }
                public List<String> getListValue(final List<String> value) {
        exc = expectThrows(
        for (final String concrete : concretes) {
        assertEquals(0, consumer.get());
        assertEquals("illegal value for [index.similarity.classic] cannot redefine built-in similarity", e.getMessage());
        assertFalse(oldSetting.exists(upgradedSettings));
            Settings.builder()
        assertEquals(7, results.get(group2).v2().intValue());
        Consumer<Map<String, Integer>> consumer = (map) -> {
package org.opensearch.common.settings;
    }
        final Settings.Builder builder = Settings.builder();
                @Override
        assertFalse(oldSetting.exists(upgradedSettings));
        assertEquals(2, results.size());
        Setting.AffixSetting<String> nameSetting = Setting.affixKeySetting(
        );
            fail("setting not registered");
            Settings.builder()
        service.applySettings(
            fail();
            Collections.singleton(new SettingUpgrader<String>() {
    public void testValidate() {
        s = IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING.getAsMap(currentSettings);
        assertTrue(service.updateDynamicSettings(Settings.builder().putNull("some.*").build(), target, update, "node"));
            concurrentSearchModeSetting,
        final boolean groupFirst = randomBoolean();
        );
            "unknown setting [index.numbe_of_replica] did you mean any of [index.number_of_replicas, index.number_of_search_replicas]?"
            e.getMessage(),
            new HashSet<>(Arrays.asList(testSetting, testSetting2))
            () -> service.validate(Settings.builder().put("foo.test.bar", 7).put("foo.test.name", "invalid").build(), true)
    }
        assertEquals(1, dynamicSetting.get(target.build()).intValue());
        assertEquals(clusterSettings.getOrNull(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE), "auto");
        final Level level = LogManager.getRootLogger().getLevel();
        assertFalse(settings.updateSettings(updates, Settings.builder().put(currentSettings), Settings.builder(), ""));
        assertNull(diff.getAsList("foo.bar.quux", null)); // affix settings don't know their concrete keys
        assertEquals(0, bC.get());
                public String getKey(final String key) {
        SettingsException e = expectThrows(SettingsException.class, () -> clusterSettings.validate(settings, false));
                    .put(intBuilder.apply(group1), 2) // modified to trip validator
            settings.applySettings(Settings.builder().build()); // here we fall back to 'logger.level' which is our default.
    public void testAddConsumerAffix() {
        String prefix = randomAlphaOfLength(3) + "foo.";
        );
        Map<String, Integer> affixResults = new HashMap<>();
        );
        assertEquals(Arrays.asList(1), listResults.get("test_list_1")); // reset to default
        );
                .build()
        assertEquals(5, diff.size());
import org.opensearch.common.logging.Loggers;
        Setting<Integer> testSetting2 = Setting.intSetting("foo.bar.baz", 1, Property.Dynamic, Property.NodeScope);
                .putList(listBuilder.apply(group2), "18", "19", "20")
                    Setting.intSetting("foo.int", 1, Property.UnmodifiableOnRestore, Property.IndexScope, Property.NodeScope),
import static org.hamcrest.Matchers.sameInstance;
    public void testDiffWithAffixAndComplexMatcher() {
        IndexScopedSettings settings = new IndexScopedSettings(Settings.EMPTY, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
        Setting<Integer> testSetting = Setting.intSetting("foo.bar", 1, Property.Dynamic, Property.NodeScope);
        assertTrue(AbstractScopedSettings.isValidKey("a.b.c-b.d"));
            setting,
    public void testUpgradeListSetting() {
        );
            intSuffix,
            new HashSet<>(Arrays.asList(oldSetting, newSetting, remainingSetting)),
        Setting.AffixSetting<List<Integer>> listSetting = Setting.affixKeySetting(
        service.addSettingsUpdateConsumer(testSetting, consumer::set);
                    return oldSetting;
        Setting.AffixSetting<List<Integer>> listSetting = Setting.affixKeySetting(
            Settings.builder().putList("transport.tracer.include", "internal:index/shard/recovery/*", "internal:gateway/local*").build()
        assertNull(group1 + " wasn't changed", results.get(group1));
        assertEquals(clusterSettings.getOrNull(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE), "auto");
        assertThat(e, hasToString(containsString("missing required setting [foo.test.name] for setting [foo.test.bar]")));
        BiConsumer<String, List<Integer>> listConsumer = listResults::put;
        );
    public void testDependentSettingsValidate() {
        AbstractScopedSettings service = new ClusterSettings(Settings.EMPTY, Collections.singleton(testSetting));
                public String getValue(final String value) {
        assertThat(affixResults.size(), equalTo(1));
        assertTrue(AbstractScopedSettings.isValidKey("a"));
        service.addSettingsUpdateConsumer(testSetting2, consumer2::set, (s) -> assertTrue(s > 0));
        diff = settings.diff(Settings.EMPTY, Settings.EMPTY);
 */
            if (groupFirst) {
        Setting<Integer> dependentSetting = new Setting<>(
        String group2 = randomAlphaOfLength(4);
            assertEquals("illegal settings key: [index. foo.]", e.getMessage());
            })
        service.validate(Settings.builder().put("foo.test.bar", 7).build(), false);
        AbstractScopedSettings service = new ClusterSettings(Settings.EMPTY, new HashSet<>(Arrays.asList(intSetting, listSetting)));
        );
        );
        assertEquals(1, currentSettings.size());
    }
            assertEquals("settings scope doesn't match the setting scope [NodeScope] not in [[Dynamic, IndexScope]]", ex.getMessage());
        assertEquals(4, intSetting.getConcreteSettingForNamespace(group1).get(groupOneSettings).intValue());
        new IndexScopedSettings(Settings.EMPTY, Collections.singleton(Setting.groupSetting("index.", Property.IndexScope)));
        SettingsException e = expectThrows(
            fail();
        assertNull(group2 + " wasn't changed", results.get(group2));
        assertEquals(1, results.size());
        Setting<Integer> dependedSetting = Setting.intSetting(dependedSettingName, 1, Property.Dynamic, Property.NodeScope);
        Level property = randomFrom(Level.values());
        Settings groupOneSettings = results.get(group1);
                Settings.builder().put(currentSettings),
        clusterSettings2.validate(settings, false);
            Collections.singleton(indexInternalSetting)
        );
        Setting<Integer> testSetting2 = Setting.intSetting("foo.bar.baz", 1, Property.Dynamic, Property.NodeScope);
        assertEquals(0, consumer.get());
        }
            () -> settings.updateSettings(
                }
            new HashSet<>(Arrays.asList(fooBar, fooBarBaz, foorBarQuux, someGroup, someAffix))
import org.opensearch.Version;
        setting = settings.get("cluster.routing.allocation.total_shards_per_node");
                assertEquals("complex setting key: [foo.] overlaps existing setting key: [foo.bar]", e.getMessage());
    }
    }
            "foo.",
    public void testAddSettingsUpdateConsumer() {
        Settings currentSettings = Settings.builder().put("some.final.setting", 9).put("some.final.group.foo", 7).build();
        );
        service.addAffixMapUpdateConsumer(listSetting, listConsumer, (s, k) -> {});
                .putList(listBuilder.apply(group1), "16", "17")
            }
        assertEquals(
            Property.NodeScope
        assertTrue(AbstractScopedSettings.isValidKey("a.b_012.c_b.d"));
    public void testUpdateTracer() {
        }
        Setting.AffixSetting<String> nameFallbackSetting = Setting.affixKeySetting(
        );
    public void testAddConsumer() {
            "bar",
        Settings groupTwoSettings = results.get(group2);
        assertNull(group3 + " wasn't changed", results.get(group3));
        final Setting<String> newSetting = Setting.simpleString("foo.new", Property.NodeScope);
                .put("foo.test_1.bar", 8)
            fail("invalid value");
        assertEquals(1, dynamicSetting.get(target.build()).intValue());
        assertEquals(1, dynamicSetting.get(currentSettings).intValue());
        assertEquals(2, consumer.get());
            Settings.EMPTY,
                .build()
        );
        settings.applySettings(
        assertEquals(4, diff.size());
                .build()
        assertEquals(2, results.get(group3).v1().size());
            indexScopedSettings.validate(settings, false, /* validateInternalOrPrivateIndex */ true);
        assertThat(e.getMessage(), startsWith("unknown secure setting [some.secure.setting]"));
        Setting.AffixSetting<Integer> intSetting = Setting.affixKeySetting(
        );
        service.applySettings(Settings.builder().put("foo.bar", 2).put("foo.bar.baz", 15).build());
    public void testFinalSettingUpdateFail() {
        );
    public void testIsFinal() {
        secureSettings.setString("some.secure.setting", "secret");
        assertEquals(4, diff.size());
            "foo.",
        assertEquals(clusterSettings.getOrNull(settingWithFallback), Integer.valueOf(100));
        IndexScopedSettings settings = new IndexScopedSettings(Settings.EMPTY, IndexScopedSettings.BUILT_IN_INDEX_SETTINGS);
        );
        assertNull(group1 + " wasn't changed", results.get(group1));
                Settings.builder(),
                .putNull(listBuilder.apply(group2)) // removed
    }
    public void testAffixMapConsumerNotCalledWithNull() {
            prefix,
    }
                false
            new HashSet<>(
        assertThat(diff.getAsInt("foo.bar", null), equalTo(1));
                Arrays.asList(
                    Setting.intSetting("foo.int.baz", 1, Property.IndexScope, Property.NodeScope)
            assertEquals(Level.TRACE, LogManager.getRootLogger().getLevel());
                Settings.builder(),
                .putList("foo.bar.quux", "x", "y", "z")
    }
        );
        Setting<Integer> failedSetting = Setting.intSetting("foo.bar.register.fail", 1, Property.Dynamic, Property.NodeScope);
        // array settings - complex matcher - only accepts numbers
        final Setting<String> remainingSetting = Setting.simpleString("foo.remaining", Property.NodeScope);
        Setting.AffixSetting<Integer> intSetting = Setting.affixKeySetting(
            "foo.",
            settings.applySettings(Settings.builder().put("logger._root", "TRACE").build());
            Settings.builder()
        AbstractScopedSettings service = new ClusterSettings(Settings.EMPTY, new HashSet<>(Arrays.asList(intSetting, listSetting)));
        service.addAffixUpdateConsumer(listSetting, listConsumer, (s, k) -> {});
 * software distributed under the License is distributed on an
    }
        exc = expectThrows(
        diff = settings.diff(
    public void testApply() {
/*
            "somekey",
    public void testLoggingUpdates() {
        );
                Settings.builder(),
