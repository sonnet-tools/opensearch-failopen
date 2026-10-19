        assertTrue(FooBarValidator.invokedInIsolation);
            fail();
        Setting<String> stringSetting = Setting.simpleString("foo.bar", Property.NodeScope);
    }
            .putList("foo.2.bar", "3", "4", "5")
        assertFalse(booleanSetting.isGroupSetting());
        final ByteSizeValue byteSizeValue = byteSizeValueSetting.get(Settings.EMPTY);
        final ByteSizeValue byteSizeValue = byteSizeValueSetting.get(Settings.EMPTY);
            () -> Setting.longSetting("foo", 42L, 43L, Property.Filtered)
        // THEN changes are reported when defaults aren't omitted
        build = Settings.builder().put("foo.bar", true).build();
import java.util.concurrent.atomic.AtomicReference;
        Settings previousInput = Settings.EMPTY;
            Property.NodeScope
        final IllegalArgumentException e = expectThrows(
    }
        assertTrue(settingUpdater.apply(currentInput, previousInput));
        assertEquals("1", value.get(0));
            }
        assertEquals(expectedMinValue, minTimeValueParser.getMin());
    public void testMemorySizeValueParser() throws Exception {
import java.util.regex.Pattern;
        final String value = updatedSettings.get(key);
        final Setting<?> fooSetting = Setting.simpleString("foo", Property.NodeScope);
            longSetting.get(Settings.builder().put("foo.bar", 11).build());
            "foo.deprecated",
        Setting<TimeValue> setting = Setting.positiveTimeSetting("my.time.value", defaultValue, Property.NodeScope);
            "foo.",
        Setting<Float> fallbackSetting = Setting.floatSetting("foo.baz", (float) 2.1);
                assertEquals(expectedMaxValue, byteSizeValueParser.getMax());
        final String key = updatedSettings.keySet().iterator().next();
            IllegalArgumentException.class,
        assertFalse(listSetting.match("foo_bar.1"));
        assertEquals(1, updatedSettings.size());
        assertFalse(listSetting.exists(Settings.EMPTY));
            "prefix.foo.",
            setting.getConcreteSetting("foo");
        Settings.Builder previousSettingsBuilder = Settings.builder()
        assertTrue(updater.apply(current, previous));
        assertEquals(asMap.get("2").get("value"), "4");
        FOO_BAR_SETTING.get(settings);
        assertThat(illegalArgumentException.getMessage(), equalTo("failed to parse value [20001ms] for setting [bar], must be <= [20s]"));
        assertEquals(new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.4)), value.get());
        } catch (IllegalStateException ex) {
    public void testByteSizeValueParser() throws Exception {
 * software distributed under the License is distributed on an
        Settings settings = Settings.builder().putList("foo.bar", Arrays.asList("bla-a", "bla-b")).build();
    public void testListSettingAcceptsNumberSyntax() {
            assertEquals(i, intValues.get(i).intValue());
        assertArrayEquals(ref.get().toArray(new String[0]), new String[] { "1", "2", "3" });
        }
        Setting<Boolean> setting = Setting.affixKeySetting("foo.", "enable", (key) -> Setting.boolSetting(key, false, Property.NodeScope));
        assertFalse(settingUpdater.apply(Settings.EMPTY, Settings.EMPTY));
    }
        Setting<String> setting = Setting.simpleString("foo.bar", Property.NodeScope);
                throw new IllegalArgumentException("The setting foo.bar must be >0");
    }
import org.opensearch.common.settings.Setting.FloatParser;
    }
            IllegalArgumentException.class,
    }
        illegalArgumentException = expectThrows(
            "bar",
        ClusterSettings.SettingUpdater<ByteSizeValue> settingUpdater = memorySizeValueSetting.newUpdater(value::set, logger);
        assertTrue(updater.apply(current, previous));
        assertThat(byteSizeValue.getBytes(), equalTo(2048L));
    public void testFilteredDoubleSetting() {
        assertEquals(1, c.b.intValue());
        }
                assertEquals(expectedMinValue, floatParser.getMin(), 0.01);
        assertTrue(namespaces.contains("bar"));
        assertEquals(expectedKey, memorySizeValueParser.getKey());
        assertEquals(3, asMap.size());
            Property.NodeScope
    }
            "suffix",
                // Test that validate() throws an exception for invalid input
                hasToString(containsString("Failed to parse value [I am not a boolean] as only [true] or [false] are allowed."))
        assertEquals(expectedKey, doubleParser.getKey());
        } catch (IllegalArgumentException e) {
        assertEquals(doubleSetting.get(Settings.EMPTY), Double.valueOf(2.1));
        AtomicReference<ByteSizeValue> value = new AtomicReference<>(null);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        AbstractScopedSettings.SettingUpdater<List<String>> settingUpdater = listSetting.newUpdater(ref::set, logger);
            Function.identity(),
import org.opensearch.test.junit.annotations.TestLogging;
        assertEquals(floatSetting.get(Settings.EMPTY), Float.valueOf((float) 2.1));
    }
        String expectedKey = "test key";
 * this work for additional information regarding copyright
        assertEquals(1, c.b.intValue());
        final SettingUpdater<Map<String, String>> updater = affixSetting.newAffixMapUpdater(consumer, logger, validator);
        assertEquals(asMap.get("2").get("value"), "2");
        String expectedKey = "test key";
        );
        final Setting.AffixSetting<Settings> affixSetting = Setting.affixKeySetting(
            }
        assertSame(current, ref.get());
        Setting<List<String>> listSetting = Setting.listSetting(
        List<String> input = Arrays.asList("test", "test1, test2", "test", ",,,,");
        AbstractScopedSettings.SettingUpdater<Settings> updater = Setting.groupedSettingsUpdater(
        assertEquals("", ref.get().foo);
        Setting<Double> doubleSetting = Setting.doubleSetting("foo.bar", 1.2, 0, 10, Property.NodeScope);
        }
            .putList("some.other", "6")
            assertThat(ex, hasToString(containsString("illegal value can't update [foo.bar] from [false] to [I am not a boolean]")));
            .build();
        Settings previous = build;
        ClusterSettings.SettingUpdater<Settings> predicateSettingUpdater = setting.newUpdater(ref::set, logger, (s) -> assertFalse(true));
    public void testValidatorForFilteredStringSetting() {
        assertEquals(expectedMaxValue, minMaxTimeValueParser.getMax());
        Setting<TimeValue> setting = Setting.timeSetting("foo", random);
        assertFalse(setting.match("foo.baz.bar"));
            );
    }
    }
        );
        setting = Setting.prefixKeySetting("foo.bar.", key -> Setting.simpleString(key, Property.NodeScope));
        final IllegalArgumentException e1 = expectThrows(
        assertThat(settingWithLowerBound.get(Settings.builder().put("foo", "5000ms").build()), equalTo(TimeValue.timeValueSeconds(5)));
    public void testSimpleUpdateOfFilteredSetting() {
        }
        assertNull(e3.getCause());
        final Settings maxSettings = Settings.builder().put("foo", "not a time value").build();
        assertEquals("2", value.get(1));
        assertFalse(listAffixSetting.match("foo"));
                Property.NodeScope
                } catch (IllegalArgumentException e) {
            () -> Setting.simpleString("foo.bar", (Property[]) null)
        assertTrue(ab1.get());
            Property.NodeScope
        assertEquals(1, value.size());
        assertTrue(settingUpdater.hasChanged(builder.build(), Settings.EMPTY));
        assertTrue(settingUpdater.apply(Settings.builder().put("b.byte.size", "40%").build(), Settings.EMPTY));
        }
        );
        settingUpdater.apply(Settings.builder().put("foo.bar", true).build(), Settings.EMPTY);
        ByteSizeValue expectedMinValue = new ByteSizeValue((long) 1);
    public void testSettingsGroupUpdaterRemoval() {
        });
import org.opensearch.common.settings.Setting.RegexValidator;
        memorySizeValueSetting = Setting.memorySizeSetting("a.byte.size", s -> "25%", Property.Dynamic, Property.NodeScope);
        try {
        }
            s -> {},
        assertNotNull(expectedPattern);
        Setting<Boolean> setting = Setting.prefixKeySetting("foo.", (key) -> Setting.boolSetting(key, false, Property.NodeScope));
        AbstractScopedSettings.SettingUpdater<Settings> updater = Setting.groupedSettingsUpdater(
            () -> Setting.simpleString("foo.bar", Property.Sensitive, Property.NodeScope)
    }
        assertNull(c.a);
        IntegerParser integerParser = new IntegerParser(expectedMinValue, expectedMaxValue, expectedKey, expectedFilteredStatus);
            IllegalArgumentException.class,
    }
        assertEquals(expectedPattern.pattern(), regexValidatorMatcherFalse.getPattern().pattern());
        // Those should pass
        Setting<Long> longSetting = Setting.longSetting("foo.bar", fallbackSetting);
            }
        // WHEN creating an affix updater
        public void validate(final String value, final Map<Setting<?>, Object> settings) {
        );
        Setting setting = Setting.boolSetting("foo", false, Property.Filtered);
            out.flush();
                assertEquals(expectedMaxValue, integerParser.getMax());
        Map<String, String> asMap = setting.getAsMap(build);
            memorySizeValueParser.writeTo(out);
        Pattern expectedPattern = Pattern.compile(expectedRegex);
        assertTrue(settingUpdater.apply(currentInput, previousInput));
        Setting<Integer> a = Setting.intSetting("foo.int.bar.a", 1, Property.Dynamic, Property.NodeScope);
        Setting<String> setting = Setting.simpleString("foo", Property.NodeScope);
        Setting<ByteSizeValue> fallbackSetting = Setting.memorySizeSetting("a.byte.size", "20%", Property.Dynamic, Property.NodeScope);
            assertEquals("Failed to parse value [11.3] for setting [foo.bar] must be <= 10.0", ex.getMessage());
        );
    public void testMemorySizeWithFallbackValue() {
            IllegalArgumentException.class,
        Settings current = ref.get();
    }
            s -> {},
            assertThrows(
    // MemorySizeValue
            "prefix.",
            Arrays.asList("foo,bar"),
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> setting.getConcreteSettingForNamespace("foo."));
        public void validate(final String value) {
        assertThat(setting.hasIndexScope(), is(false));
        assertTrue(setting.hasComplexMatcher());
            floatParser.writeTo(out);
 * this file be licensed under the Apache-2.0 license or a
        Setting<Boolean> booleanSetting = Setting.boolSetting("foo.bar", false, Property.Dynamic, Property.Filtered);
        final IllegalArgumentException e = expectThrows(
        assertEquals(expectedMinValue, minMaxTimeValueParser.getMin());
            .putList("foo.1.bar", "1", "2")
    public void testComplexType() {
        assertEquals(expectedFilteredStatus, integerParser.getFilterStatus());
            }
        RegexValidator regexValidator = new RegexValidator(expectedRegex);
        Setting<ByteSizeValue> memorySizeValueSetting = Setting.memorySizeSetting(
        assertNotNull(regexValidator.getPattern());
                "failed to parse setting [a.byte.size] with value [12] as a size in bytes: unit is missing or unrecognized";
        assertTrue(setting.match("foo.baz.enable"));
        assertEquals(2, c.a.intValue());
        settingUpdater.apply(build, Settings.EMPTY);
        assertFalse(concreteSetting.get(Settings.builder().put("foo.baz.enable", "true").build()));
        final long value = 20_000_000 - randomIntBetween(1, 1024);
                assertEquals(expectedFilteredStatus, integerParser.getFilterStatus());
    }
        assertNotNull(e.getCause());
        Settings.Builder builder = Settings.builder().putList("foo.bar", input.toArray(new String[0]));
        build = Settings.builder().put("foo.bar.baz", 2).put("foo.bar.foobar", 3).put("foo.bar.baz.deep", 45).build();
        final int count = randomIntBetween(1, 16);
        assertEquals("3", value.get(0));
        assertThat(e2, hasToString(containsString("Failed to parse value for setting [foo] must be <= 44.0")));
        assertTrue(setting.match("foo.bar.baz"));
            currentSettingsBuilder.put("prefix.foo.bar.baz", "bar");
    public void testFloatWithFallbackValue() {
        AbstractScopedSettings.SettingUpdater<Settings> updater = Setting.groupedSettingsUpdater(
            || removeAffixNamespace;
        Setting<Boolean> booleanSetting = Setting.boolSetting("foo.bar", false, Property.NodeScope);
        assertEquals(integerSetting.get(Settings.EMPTY), Integer.valueOf(42));
        assertEquals("illegal value can't update [foo.bar.]", ex.getMessage());
        Map<String, Settings> asMap = groupSetting.get(values).getAsGroups();
        assertNull(c.a);
        int expectedMaxValue = Integer.MAX_VALUE;
 *
    }
            }
            IllegalArgumentException.class,
            Integer::parseInt,
        String expectedKey = "test key";
        assertEquals(integerSetting.get(Settings.builder().put("foo.baz", 3).build()), Integer.valueOf(3));
 *
        String expectedKey = "test key";
        assertEquals("Found list type value for setting [foo.bar] but but did not expect a list for it.", e.getMessage());
        assertNotNull(regexValidatorMatcherFalse.getPattern());
        IllegalArgumentException ex = expectThrows(
import java.util.Iterator;
        assertTrue(listAffixSetting.match("foo.test_1.bar"));
        MinMaxTimeValueParser minMaxTimeValueParser = new MinMaxTimeValueParser(
        assertThat(setting.hasNodeScope(), is(true));
        Setting<Integer> intSetting2 = Setting.intSetting("prefix.same", 1, Property.NodeScope, Property.Dynamic);
        assertEquals(5, c.b.intValue());
            @Override
        assertEquals(4, intValues.size());
        assertTrue(settingUpdater.apply(build, Settings.EMPTY));
        );
                assertEquals(expectedMinValue, longParser.getMin());
        Setting<Boolean> booleanSetting = Setting.boolSetting("foo.bar", false, Property.Dynamic, Property.NodeScope);
        assertTrue(settingUpdater.apply(Settings.builder().put("a.byte.size", "30%").build(), Settings.EMPTY));
        assertEquals(1, c.b.intValue());
        assertEquals("2", asMap.get("baz"));
        final Settings settings = Settings.builder().setSecureSettings(secureSettings).build();
        assertEquals(5.6, doubleSetting.get(Settings.builder().put("foo.bar", 5.6).build()).doubleValue(), 0.01);
    public void testMutuallyExclusiveScopes() {
import org.opensearch.common.settings.Setting.MinMaxTimeValueParser;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                    throw new IllegalArgumentException(toString(settings));
            Function.identity(),
        Setting<Integer> intSetting = Setting.intSetting("prefix.foo", 1, Property.NodeScope, Property.Dynamic);
        MemorySizeValueParser memorySizeValueParser = new MemorySizeValueParser(expectedKey);
        assertSame("no update - type has not changed", type, ref.get());
        );
    }
    public void testSimpleUpdate() {
        final Setting<ByteSizeValue> byteSizeValueSetting = Setting.byteSizeSetting(
            Integer.valueOf(20)
    public void testRejectNullProperties() {
        Property.Dynamic,
            TimeValue.timeValueSeconds(10),
        assertTrue(settingUpdater.apply(Settings.EMPTY, build));
        assertThat(settingWithBothBounds.get(Settings.builder().put("bar", "5000ms").build()), equalTo(TimeValue.timeValueSeconds(5)));
            assertThat(value, equalTo("foo.bar value"));
            || changePrefixKeySetting
            Collections.singletonList("foo.non_deprecated"),
            Arrays.asList(affixSetting, fixSetting),
            || removePrefixKeySetting
        assertThat(settingWithLowerBound.get(Settings.EMPTY), equalTo(TimeValue.timeValueSeconds(10)));
                throw new IllegalArgumentException("The setting foo.bar must be >0");
        Settings build = Settings.builder().put("foo.bar", false).build();
        // THEN changes are expected when defaults aren't omitted
        boolean removeAffixNamespace = randomBoolean();
        );
        Settings build = Settings.builder().put("foo.bar.baz", 2).put("foo.bar.foobar", 3).build();
    }
        assertFalse(setting.match("foo.bar.baz.enabled"));
        );
    public void testRejectNonIndexScopedNotCopyableOnResizeSetting() {
        previousInput = currentInput;
package org.opensearch.common.settings;
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> byteSizeValueSetting.get(settings));
        }
        assertFalse(listSetting.match("foo_bar"));
    }
     */
import java.util.stream.Collectors;
        assertEquals(floatSetting.get(Settings.builder().put("foo.baz", 3.2).build()), Float.valueOf((float) 3.2));
            () -> Setting.simpleString("foo.bar", Property.InternalIndex)
        assertEquals(expectedFilteredStatus, minTimeValueParser.getFilterStatus());
        assertFalse(fooSetting.exists(Settings.EMPTY));
        if (removeAffixKeySetting == false && changeAffixKeySetting == false && removeAffixNamespace) {
        } else {
        // try to parse this really annoying format
                IllegalArgumentException.class,
        try {
            new ByteSizeValue(1024),
        assertEquals(doubleSetting.get(Settings.builder().put("foo.baz", 3.2).build()), Double.valueOf(3.2));
        MinTimeValueParser minTimeValueParser = new MinTimeValueParser(expectedKey, expectedMinValue, expectedFilteredStatus);
        AtomicReference<ComplexType> ref = new AtomicReference<>(null);
            integerSetting.get(Settings.builder().put("foo.bar", 11).build());
            throw new SettingsException("validate always fails");
        assertEquals(2, asMap.size());
                longParser = new LongParser(in);
        assertNull(c.b);
            IllegalArgumentException.class,
        try {
        });
        // If value=getHeapMax()*0.3 is bigger than 2gb, and is bigger than Integer.MAX_VALUE,
        assertFalse(byteSizeValueSetting.isGroupSetting());
        public Iterator<Setting<?>> settings() {
                Settings.builder().put("foo.bar.1.value", "1").put("foo.bar.2.value", "2").build(),
            )
        assertNotNull(ref.get());
            @Override
    }
        assertThat(setting.hasIndexScope(), is(false));
        assertEquals("foo,bar", value.get(0));
        assertThat(e, hasToString(containsString("non-index-scoped setting [foo.bar] can not have property [NotCopyableOnResize]")));
            } else if (affixSetting.getNamespaces(s).contains("bar")) {
        );
            (s) -> s.toString(),
        assertTrue(concreteSetting.get(Settings.builder().put("foo.bar.enable", "true").build()));
            "a.byte.size",
                new MockLogAppender.SeenEventExpectation(
        final IllegalArgumentException e1 = expectThrows(
    }
            IllegalArgumentException.class,
        assertEquals(defaultValue.millis(), setting.get(Settings.EMPTY).millis());
        assertEquals(defaultValue, setting.getDefault(Settings.EMPTY));
            "bar",
    // Integer
    public void testLogSettingUpdate() throws Exception {
            fail("not dynamic");
        });
        assertThat(e1, hasToString(containsString("Failed to parse value for setting [foo] must be >= 43.0")));
        value = settingWithFallback.get(Settings.EMPTY);
        asMap = setting.getAsMap(build);
    public void testFloatParser() throws Exception {
 * You may obtain a copy of the License at
        previousInput = currentInput;
                assertEquals(expectedMaxValue, doubleParser.getMax(), 0.01);
        // reset to default
        setting = Setting.simpleString("foo.bar", Property.IndexScope);
 * ownership. Elasticsearch licenses this file to you under
        }
    public void testMinMaxTimeValueParser() throws Exception {
        boolean changePrefixKeySetting = randomBoolean();
            longParser.writeTo(out);
        }
            builder.put("foo.bar." + i, input.get(i));
        public void set(Integer a, Integer b) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        final Map<String, String> updatedSettings = updater.getValue(current, previous);
        assertThat(ex.getMessage(), containsString("UnmodifiableOnRestore setting [foo.bar] cannot be dynamic"));
    public void testExists() {
            previousSettingsBuilder.remove("prefix.foo.bar.baz");
        assertEquals(input.size(), value.size());
            .build();
                    public boolean innerMatch(LogEvent event) {
 * Modifications Copyright OpenSearch Contributors. See
            Function.identity(),
            () -> Setting.simpleString("foo.bar", Property.NotCopyableOnResize)
        assertEquals(asMap.get("1").get("value"), "1");
        Consumer<Settings> validator = s -> {
            "foo.non_deprecated",
        Setting<TimeValue> settingWithLowerBound = Setting.timeSetting(
        settingUpdater.apply(builder.build(), Settings.EMPTY);
     */
        assertFalse(settingUpdater.apply(build, build));
    }
    public void testMinTimeValueParser() throws Exception {
        try {
            assertThat(ex.getCause(), instanceOf(IllegalArgumentException.class));
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> byteSizeValueSetting.get(settings));
        ClusterSettings.SettingUpdater<Boolean> settingUpdater = booleanSetting.newUpdater(atomicBoolean::set, logger);
        Settings current = Settings.builder().put("prefix.foo", 123).put("prefix.same", 5555).build();
        String expectedKey = "test key";
        final Setting maxSetting = Setting.timeSetting(
        Setting<Integer> integerSetting = Setting.intSetting("foo.int.bar", 1, Property.Dynamic, Property.NodeScope);
        assertThat(e.getMessage(), is("abc.4.def:14,abc.tuv:50"));
        );
        assertThat(e, hasToString(containsString("non-index-scoped setting [foo.bar] can not have property [InternalIndex]")));
        Settings previous = Settings.builder().put("prefix.foo", 321).put("prefix.same", 5555).build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        assertTrue(settingUpdater.apply(Settings.builder().put("a.byte.size", "12b").build(), Settings.EMPTY));
                assertEquals(expectedMinValue, integerParser.getMin());
                regexValidator = new RegexValidator(in);
            TimeValue.timeValueHours(3),
    }
        final Settings settings = Settings.builder()
        assertEquals(expectedKey, longParser.getKey());
        assertTrue(settingUpdater.apply(build, previous));
            listSetting,
                    regexValidator.validate("123");
    }
        Settings previous = build;
    }
                if (fixSetting.get(s) == 2) {
        Function.identity(),
        settingUpdater.apply(Settings.EMPTY, Settings.builder().put("foo.bar", "1,2,3").build());
        final IllegalArgumentException e = expectThrows(
                    .sorted()
    public void testListSettingsDeprecated() {
            fail("not accepted");
            }
                Settings.EMPTY
        Setting<Integer> a = Setting.intSetting("foo.int.bar.a", 1, Property.Dynamic, Property.NodeScope);
                IllegalArgumentException.class,
            );
                return s.entrySet()
                () -> doubleSettingWithValidator.get(Settings.builder().put("foo.bar", randomFrom(-1, 0)).build())
        }
        assertThat(setting.hasIndexScope(), is(true));
        assertEquals(defaultValue.millis() + "ms", aDefault);
        assertEquals(integerSetting.get(Settings.EMPTY), Integer.valueOf(2));
            (s) -> s.toString(),
                // Test that validate() does not throw an exception for valid input
            "foo.bar",
        final IllegalArgumentException e1 = expectThrows(
        try {
    public void testComposite() {
        Setting<Integer> integerSetting = Setting.intSetting("foo.bar", 1, 0, 10, Property.NodeScope);
                assertEquals(expectedFilteredStatus, doubleParser.getFilterStatus());
        Settings build = Settings.builder().put("foo.int.bar.a", 2).build();
        );
        assertTrue(fooSetting.exists(Settings.builder().put("foo", "bar").build()));
        assertEquals("_foo", key);
        Settings previous = Settings.builder().put("prefix.foo", 321).put("prefix.same", 5555).build();
        for (String key : builder.keys()) {
        assertNull(c.b);
        Setting<Settings> groupSetting = Setting.groupSetting("new.bar.", fallbackSetting, Property.Dynamic, Property.NodeScope);
        Setting<Integer> fix1 = Setting.intSetting("abc.qrx", 20, 0, new Setting.Validator<Integer>() {
        assertFalse(concreteSetting.get(Settings.builder().put("foo.baz", "true").build()));
        assertEquals(memorySizeValue.getBytes(), JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.2, 1.0);
            Property.Dynamic,
            invokedWithDependencies = true;
        AbstractScopedSettings.SettingUpdater<Settings> updater = Setting.groupedSettingsUpdater(
    public void testAffixKeySettingWithDynamicPrefix() {
        assertNotNull(updatedSettings);
        illegalArgumentException = expectThrows(
    public void testDynamicKeySetting() {
        Setting<Boolean> concreteSetting = setting.getConcreteSetting("foo.bar.enable");
    private static final Setting<String> QUUX_QUUZ_SETTING = Setting.simpleString("quux.quuz", Property.NodeScope);
        assertTrue(setting.match("foo.bar.enable"));
        for (int i = 0; i < input.size(); i++) {
                    "updating [index.refresh_interval] from [20s] to [10s]"
        // try to parse this really annoying format
        value = listSetting.get(builder.build());
    public void testTimeValueBounds() {
        final Settings settings = Settings.builder().put(filteredStringSetting.getKey(), filteredStringSetting.getKey() + " value").build();
import org.opensearch.core.common.io.stream.BytesStreamInput;
        @Override
            assertEquals("Failed to parse value [-1] for setting [foo.bar] must be >= 0", ex.getMessage());
        }
                "foo",
    }
        assertEquals(0, defaultValue.size());
import static org.hamcrest.Matchers.containsString;
        boolean expectedFilteredStatus = true;
        IllegalArgumentException illegalArgumentException = expectThrows(
        Settings current = Settings.builder().put("prefix.same", 5555).build();
        final IllegalArgumentException e = expectThrows(
        assertEquals("a", fallsback.get(Settings.builder().put("foo.bar", "a").build(), Settings.builder().put("foo.bar", "b").build()));
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertEquals(3, ref.get().size());
        Settings settings = Settings.builder()
import org.apache.logging.log4j.Level;
        memorySizeValueSetting = Setting.memorySizeSetting("a.byte.size", "50%", Property.Dynamic, Property.NodeScope);
            mockLogAppender.addExpectation(
            final IllegalArgumentException cause = (IllegalArgumentException) ex.getCause();
        );
            IllegalArgumentException.class,
    public void testSettingsGroupUpdaterWithAffixSetting() {
    }
        }
                    @Override
                assertEquals(expectedMaxValue, floatParser.getMax(), 0.01);
        memorySizeValueSetting = Setting.memorySizeSetting("a.byte.size", s -> "2048b", Property.Dynamic, Property.NodeScope);
        assertEquals(Collections.singletonList("testelement"), listAffixSetting.getDefault(Settings.EMPTY));
        private Integer a;
        float expectedMaxValue = Float.MAX_VALUE;
        double expectedMaxValue = Double.MAX_VALUE;
        assertEquals(2, value.size());
        final Setting<String> fooSetting = new Setting<>(new Setting.SimpleKey("foo"), current, Function.identity(), Property.NodeScope);
        }
            IllegalArgumentException.class,
            .put("something.else", "true")
        );
        assertThat(settingWithBothBounds.get(Settings.builder().put("bar", "20000ms").build()), equalTo(TimeValue.timeValueSeconds(20)));
        );
            if (value <= 0.0) {
        boolean expectedFilteredStatus = true;
        final int factor = randomIntBetween(1, 10);
        assertFalse(memorySizeValueSetting.isGroupSetting());
        IllegalArgumentException e = expectThrows(
            assertEquals("Failed to parse value [11.3] for setting [foo.bar] must be <= 10.0", ex.getMessage());
                assertEquals(expectedKey, minMaxTimeValueParser.getKey());
    }
        );
        final Setting<List<String>> nonDeprecatedListSetting = Setting.listSetting(
        assertEquals(longSetting.get(Settings.builder().put("foo.bar", 3).build()), Long.valueOf(3));
        TimeValue expectedMinValue = TimeValue.timeValueSeconds(0);
 * KIND, either express or implied.  See the License for the
    }
        }
            TimeValue.timeValueHours(4),
    public void testGroupSettingFallback() {
        Settings settings = ref.get();
        try {
        assertTrue(listAffixSetting.hasComplexMatcher());
                TimeValue.timeValueHours(4),
        Stream<Setting<List<String>>> allConcreteSettings = listAffixSetting.getAllConcreteSettings(settings);
        Setting<Integer> fallbackSetting = Setting.intSetting("foo.baz", 2);
        assertEquals("some_default", fallsback.get(Settings.EMPTY));
 * under the License.
    }
        expectThrows(UnsupportedOperationException.class, () -> listAffixSetting.get(Settings.EMPTY));
            doubleSetting.get(Settings.builder().put("foo.bar", 11.3).build());
        settingUpdater.apply(Settings.builder().put("foo.bar", "1,2,3").build(), Settings.builder().putList("foo.bar", "123").build());
        Setting<ByteSizeValue> memorySizeSetting = Setting.memorySizeSetting(
        AtomicReference<Boolean> atomicBoolean = new AtomicReference<>(null);
            () -> settingWithBothBounds.get(Settings.builder().put("bar", "20001ms").build())
            "foo.bar",
        assertArrayEquals(ref.get().toArray(new String[0]), input.toArray(new String[0]));
        assertFalse(booleanSetting.get(Settings.EMPTY));
        );
            .put("foo.bar.enable", "true")
        }
        try {
        );
                return a.iterator();
        AtomicReference<Boolean> atomicBoolean = new AtomicReference<>(null);
        Settings invalid = Settings.builder().put("foo.int.bar.a", -2).put("foo.int.bar.b", 5).build();
        assertEquals("foo,bar", value.get(0));
                throw new IllegalArgumentException("no bar");
        Setting<Settings> setting = Setting.groupSetting("foo.bar.", Property.Filtered, Property.Dynamic);
                }
            fail("Expected validate() to not throw an exception, but it threw " + e);
    }
            () -> Setting.simpleString("foo.bar", Property.UnmodifiableOnRestore)
            predicateSettingUpdater.apply(
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
        );
        );
            s -> {},
        assertEquals("key [foo] must match [foo.*.enable] but didn't.", exc.getMessage());
        Setting<Integer> integerSetting = Setting.intSetting("foo.bar", fallbackSetting);
            () -> Setting.timeSetting("foo", TimeValue.timeValueHours(1), TimeValue.timeValueHours(2), Property.Filtered)
        Integer aValue = c.a;
        boolean expectedFilteredStatus = true;
        assertThat(e, hasToString(containsString(expectedMessage)));
        Setting<Long> fallbackSetting = Setting.longSetting("foo.baz", 2);
        assertEquals(1, c.a.intValue());
    public void testRejectNonIndexScopedUnmodifiableOnRestoreSetting() {
            IllegalArgumentException.class,
        final IllegalArgumentException e = expectThrows(
        final String expectedMessage = "failed to parse value [" + value + "b] for setting [a.byte.size], must be <= [2147483647b]";
            settingUpdater.apply(Settings.builder().put("a.byte.size", 12).build(), Settings.EMPTY);
    }
        );
    }
        );
            "suffix",
        Setting<List<String>> listSetting = Setting.listSetting(
        assertEquals(expectedFilteredStatus, floatParser.getFilterStatus());
        assertFalse(setting.match("foo"));
        List<Integer> defaultValue = otherSettings.get(Settings.EMPTY);
            "foo",
        // Test throws an exception when the value matches
        if (removePrefixKeySetting) {
        assertEquals(floatSetting.get(Settings.builder().put("foo.bar", 3.2).build()), Float.valueOf((float) 3.2));
            fail();
        try {
        currentInput = Settings.builder().put("foo.bar.1.value", "1").put("foo.bar.2.value", "2").put("foo.bar.3.value", "3").build();
        assertEquals(new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.2)), value.get());
            assertThat(
            Arrays.asList(intSetting, intSetting2)
        assertEquals(5, longSetting.get(Settings.builder().put("foo.bar", 5).build()).longValue());
            TimeValue.timeValueSeconds(10),
            new ByteSizeValue(Integer.MAX_VALUE, ByteSizeUnit.BYTES)
            "foo.baz",
        assertEquals("value 2", asMap.get("2").get("value"));
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
            () -> Setting.floatSetting("foo", 42.0f, 43.0f, Property.Filtered)
            }
            Property.NodeScope
            .put("prefix.foo.infix.suffix", "foo");
        assertFalse(booleanSetting.get(Settings.builder().put("foo.bar", false).build()));
        );
        secureSettings.setString("foo", "bar");
import org.opensearch.core.common.bytes.BytesReference;
            IllegalArgumentException.class,
        assertTrue(settingUpdater.apply(Settings.builder().put("foo.bar", "2").build(), Settings.EMPTY));
        String expectedKey = "test key";
        IllegalArgumentException ex = expectThrows(
    public void testGetAllConcreteSettings() {
            IllegalArgumentException.class,
import java.util.stream.Stream;
    }
        }
        assertThat(setting.get(Settings.builder().put("foo", "12h").build()), equalTo(TimeValue.timeValueHours(12)));
import org.opensearch.common.settings.Setting.DoubleParser;
        assertFalse(setting.match("foo.bar.baz.enable"));
        assertTrue(settingUpdater.apply(Settings.EMPTY, Settings.builder().put("foo.bar", "2").build()));
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> setting.get(settings));
        assertNull(atomicBoolean.get());
        assertSame(aValue, c.a);
        "foo.bar",
        }
    public void testFilteredTimeSetting() {
        } catch (IllegalArgumentException ex) {
        public ComplexType(String foo) {
            assertNotNull(ex.getCause());
        try {
            () -> Setting.doubleSetting("foo", 45.0, 43.0, 44.0, Property.Filtered)
        assertFalse(fallbackSetting.exists(Settings.EMPTY));
        ClusterSettings.SettingUpdater<ByteSizeValue> settingUpdater = byteSizeValueSetting.newUpdater(value::set, logger);
        final long value = (1L << 31) - 1 + randomIntBetween(1, 1024);
        int expectedMinValue = Integer.MIN_VALUE;
        assertTrue(namespaces.contains("baz"));
                () -> doubleSettingWithValidator.get(Settings.builder().put("foo.bar", randomFrom(-1, 0)).build())
    public void testDoubleWithMinMax() throws Exception {
    }
        );
        assertTrue(settingUpdater.apply(Settings.EMPTY, build));
            key -> Setting.simpleString(key, Property.NodeScope, Property.Dynamic)
        );
        );
    public void testByteSizeSettingMinValue() {
        }
            updater.getValue(Settings.builder().put("prefix.foo.suffix", 5).put("abc", 2).build(), Settings.EMPTY);
        } catch (IllegalArgumentException e) {
            new ByteSizeValue(Integer.MAX_VALUE, ByteSizeUnit.BYTES)
            () -> Setting.simpleString("foo.bar", Property.PrivateIndex)
            if (value <= 0.0) {
        }
            validator
            IllegalArgumentException.class,
        assertEquals(5.6, floatSetting.get(Settings.builder().put("foo.bar", (float) 5.6).build()).floatValue(), 0.01);
        assertEquals("3", asMap.get("foobar"));
            () -> Setting.timeSetting(
import org.opensearch.core.common.unit.ByteSizeValue;
                }
                assertEquals(expectedMinValue, minMaxTimeValueParser.getMin());
        assertEquals("foo and 2 can't go together", illegal.getMessage());
        assertThat(ex.getMessage(), containsString("properties cannot be null for setting"));
        try {
    }
        });
        Setting<Float> floatSetting = Setting.floatSetting("foo.bar", (float) 42.1);
        }
    public void testExistsWithFallback() {
    }
import org.opensearch.test.MockLogAppender;
        Setting<Double> doubleSettingWithValidator = Setting.doubleSetting("foo.bar", 42.1, value -> {
            Property.NodeScope
        for (int i = 1; i < count; i++) {
        Setting<ComplexType> setting = new Setting<>("foo.bar", (s) -> "", (s) -> new ComplexType(s), Property.Dynamic, Property.NodeScope);
        build = Settings.builder().put("foo.int.bar.a", 2).put("foo.int.bar.b", 5).build();
        "foobar",
        assertFalse(setting.match("foo.bar"));
        ClusterSettings.SettingUpdater<Settings> predicateSettingUpdater = setting.newUpdater(ref::set, logger, (s) -> assertFalse(true));
        assertTrue(FooBarValidator.invokedWithDependencies);
        Settings.Builder builder = Settings.builder().putList("foo.bar", input.toArray(new String[0]));
import org.opensearch.cluster.metadata.IndexMetadata;
            () -> settingWithBothBounds.get(Settings.builder().put("bar", "4999ms").build())
            fail();
        assertFalse(settingUpdater.apply(Settings.EMPTY, Settings.EMPTY));
    /**
            this.b = b;
    public void testFilteredFloatSetting() {
        assertArrayEquals(ref.get().toArray(new String[0]), new String[] { "123" });
        String aDefault = setting.getDefaultRaw(Settings.EMPTY);
import java.util.function.Consumer;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    public static class Composite {
        assertEquals(2, value.size());
            }
        builder = Settings.builder();
            () -> fix1.get(Settings.builder().put("abc.1.def", 11).put("abc.2.def", 12).put("abc.qrx", 11).build())
        assertThat(e, hasToString(containsString("Failed to parse value for setting [foo]")));
    public void testLongWithDefaultValue() {
        assertEquals(expectedMaxValue, byteSizeValueParser.getMax());
            "b.byte.size",
        AtomicReference<Settings> ref = new AtomicReference<>(null);
                    "message",
    }
        assertThat(e4, hasToString(containsString("failed to parse value for setting [foo] as a time value")));
        );
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
                Settings.builder().put("foo.bar.1.value", "1").put("foo.bar.2.value", "2").build(),
            Settings.EMPTY
        assertThat(e, hasToString(containsString("non-index-scoped setting [foo.bar] can not have property [PrivateIndex]")));
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        Settings build = Settings.builder().put("foo.int.bar.a", 2).build();
        }
            }
        Composite c = new Composite();
        Setting<Integer> intSetting = Setting.intSetting("prefix.foo", 1, Property.NodeScope, Property.Dynamic);
    public void testRegexValidator() throws Exception {
        // Test that checks the pattern and isMatching with the set value false parameters are working correctly during initialization
        IllegalArgumentException ex = expectThrows(
        final Setting<ByteSizeValue> byteSizeValueSetting = Setting.byteSizeSetting(
                assertEquals(expectedMinValue, doubleParser.getMin(), 0.01);
        Setting<Integer> affix = Setting.affixKeySetting("abc.", "def", k -> Setting.intSetting(k, 10));
            "foo.",
    }
        assertFalse(settingUpdater.apply(currentInput, previousInput));
 * compatible open source license.
        );
    }
        Setting.AffixSetting<String> affixSetting = Setting.affixKeySetting(
            IllegalArgumentException.class,
        final IllegalArgumentException e = expectThrows(
        memorySizeValue = memorySizeValueSetting.get(Settings.EMPTY);
            Property.NodeScope
        }
                if (settings.size() == 1) {
    }
    @TestLogging(value = "org.opensearch.common.settings.IndexScopedSettings:INFO", reason = "to ensure we log INFO-level messages from IndexScopedSettings")
            currentSettingsBuilder.remove("prefix.foo.infix.suffix");
    }
        }
    }
 */
            Property.Dynamic,
            current = next;
                TimeValue.timeValueHours(2),
        assertNotNull(s);
import static org.hamcrest.Matchers.is;
    public void testFilteredIntSetting() {
        );
        }
        assertNotNull(regexValidatorMatcherFalse);
    /**
        assertEquals(5, c.b.intValue());
    public void testByteSizeSettingMaxValue() {
        TimeValue expectedMaxValue = TimeValue.MAX_VALUE;
                    settings.remove(fix0);
        );
    public void testAffixNamespacesWithGroupSetting() {
        deprecatedListSetting.get(settings);
        assertEquals(expectedKey, integerParser.getKey());
        );
            new ByteSizeValue(20_000_000, ByteSizeUnit.BYTES),
        // GIVEN an affix setting changed from "prefix._foo"="bar" to "prefix._foo"=null
        @Override
            fail();
        final Consumer<Map<String, String>> consumer = (map) -> {};
import org.opensearch.common.settings.Setting.ByteSizeValueParser;
        assertThat(e.getMessage(), is("abc.1.def:11,abc.2.def:12"));
            IllegalArgumentException.class,
    }
        } catch (IllegalArgumentException ex) {
                    .map(e -> e.getKey().getKey() + ":" + e.getValue().toString())
        settingUpdater.apply(build, Settings.EMPTY);
import org.opensearch.common.settings.Setting.MinTimeValueParser;
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/33135")
                ) {
    public void testAffixSettingsValidatorDependencies() {
            assertEquals("Failed to parse value [11] for setting [foo.bar] must be <= 10", ex.getMessage());
            "foo.bar",
            IllegalArgumentException.class,
        assertThat(e, hasToString(containsString(expectedMessage)));
        assertEquals("no bar", illegal.getMessage());
    }
        } catch (IllegalArgumentException ex) {
            }
            .put("foo.boom.enable", "true")
        currentInput = Settings.builder().put("foo.bar.1.value", "1").put("foo.bar.2.value", "4").build();
            doubleSetting.get(Settings.builder().put("foo.bar", -1.4).build());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    public void testType() {
        Setting<List<String>> settingWithFallback = Setting.listSetting(
        assertEquals(3, collect.size());
            "prefix.foo.bar.",
        assertEquals(asMap.get("2").get("value"), "2");
        assertEquals(new ByteSizeValue(12), value.get());
            "enable",
            expectedMinValue,
            }
            final Setting<String> next = new Setting<>(
        assertEquals("some_default", secondaryDefaultViaSettings.get(Settings.EMPTY));
        assertThat(ex, hasToString(equalTo("java.lang.IllegalArgumentException: illegal value can't update [foo.bar]")));
            floatSetting.get(Settings.builder().put("foo.bar", (float) -1.4).build());
        assertNotSame(current, ref.get());
            s -> "2048b",
    public void testSettingsGroupUpdater() {
        // change from default
    }
    public void testGroupSettingUpdaterValidator() {
    public void testUpdateNotDynamic() {
import org.opensearch.common.settings.Setting.Property;
            assertEquals("key [foo] must match [foo.] but didn't.", ex.getMessage());
    public void testLongParser() throws Exception {
        final IndexMetadata metadata = newIndexMeta(
        assertEquals(2, asMap.size());
 *
                assertEquals(expectedFilteredStatus, minMaxTimeValueParser.getFilterStatus());
        assertThat(setting.hasNodeScope(), is(true));
        assertTrue(atomicBoolean.get());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        public static boolean invokedInIsolation;
        AtomicReference<Boolean> ab2 = new AtomicReference<>(null);
        assertTrue(listSetting.match("foo.bar." + randomIntBetween(0, 10000)));
        }
        IllegalArgumentException ex = expectThrows(
            .put("foo.bar.1.value", "1")
import org.apache.logging.log4j.core.LogEvent;
        assertEquals(expectedMaxValue, integerParser.getMax());
        assertEquals(expectedFilteredStatus, doubleParser.getFilterStatus());
        // try update bogus value
            "bar",
        ByteSizeValue expectedMaxValue = new ByteSizeValue(Long.MAX_VALUE);
            IllegalArgumentException.class,
            assertTrue(settings.keySet().contains(BAZ_QUX_SETTING));
        // change back to default...
    }
        final IllegalArgumentException e2 = expectThrows(
import org.opensearch.index.IndexSettings;
        ClusterSettings.SettingUpdater<ComplexType> settingUpdater = setting.newUpdater(ref::set, logger);
        assertThat(ex.getMessage(), containsString("final setting [foo.bar] cannot be dynamic"));
                cause,
        if (removeAffixKeySetting) {
    public void testDoubleWithDefaultValue() {
        }
                TimeValue.timeValueHours(3),
            public void validate(Integer value, Map<Setting<?>, Object> settings, boolean isPresent) {
            assertThat(cause, hasToString(containsString(expected)));
/*
        asMap = ref.get().getAsGroups();
    public void testTimeValue() {
import org.opensearch.test.OpenSearchTestCase;
            () -> Setting.simpleString("foo.bar", Property.UnmodifiableOnRestore, Property.Dynamic)
            expectedMaxValue,
                newIndexMeta("index1", Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "10s").build())
            (key) -> Setting.listSetting(key, Collections.singletonList("testelement"), Function.identity(), Property.NodeScope)
    }
        public void validate(Integer a, Integer b) {
    }
        Setting<String> secondaryDefaultViaSettings = new Setting<>("foo.bar", secondaryDefault, Function.identity(), Property.NodeScope);
            assertTrue(fooSetting.existsOrFallbackExists(Settings.builder().put(setting, "bar").build()));
            IllegalArgumentException.class,
        Setting<TimeValue> settingWithBothBounds = Setting.timeSetting(
            .put("quux.quuz", "quux.quuz value")
                byteSizeValueParser = new ByteSizeValueParser(in);
            longSetting.get(Settings.builder().put("foo.bar", -1).build());
        // We accept settings with no scope but they will be rejected when we register with SettingsModule.registerSetting
        assertEquals("4", value.get(1));
            out.flush();
    }
        assertEquals("some_default", secondaryDefault.get(Settings.EMPTY));
    }
                }
        TimeValue expectedMinValue = TimeValue.timeValueSeconds(0);
            out.flush();
        assertEquals(input.size(), value.size());
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.monitor.jvm.JvmInfo;
        assertEquals(memorySizeValue.getBytes(), JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.25, 1.0);
        assertEquals("o", fallsback.get(hasFallback, Settings.EMPTY));
        }
        }
        assertEquals(2, value.size());
    }
        assertFalse(settingUpdater.apply(Settings.EMPTY, Settings.EMPTY));
        assertEquals(new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.3)), value.get());
                try {
    public void testRejectNonIndexScopedInternalIndexSetting() {
        assertEquals(1, c.a.intValue());
            new ByteSizeValue(16, ByteSizeUnit.MB),
        assertTrue(concreteSetting.get(Settings.builder().put("foo.bar", "true").build()));
        // Test throw an exception when the value does not match
        integerSetting = Setting.intSetting("foo.int.bar", 1, Property.Dynamic, Property.IndexScope);
    }
            assertEquals("Failed to parse value [11] for setting [foo.bar] must be <= 10", ex.getMessage());
    }
        assertEquals("45", asMap.get("baz.deep"));
import java.util.function.Function;
        final String expected = "failed to parse setting [a.byte.size] with value [12] as a size in bytes: unit is missing or unrecognized";
        Setting.AffixSetting<Boolean> setting = Setting.affixKeySetting(
        assertThat(setting.get(Settings.EMPTY).getMillis(), equalTo(random.getMillis() * factor));
            assertEquals("Failed to parse value [-1] for setting [foo.bar] must be >= 0", ex.getMessage());
            settings.updateIndexMetadata(
        final TimeValue random = TimeValue.parseTimeValue(randomTimeValue(), "test");
    }
            final String setting = "fallback" + randomIntBetween(0, count - 1);
        }
        assertEquals("o", fallsback.get(Settings.EMPTY, hasFallback));
        );
        } catch (IllegalArgumentException ex) {
        Setting<Boolean> booleanSetting = Setting.boolSetting("foo.bar", false, Property.Dynamic, Property.NodeScope);
     * Only one single scope can be added to any setting
            previousSettingsBuilder.remove("prefix.foo.infix.suffix");
        assertThrows(IllegalArgumentException.class, () -> finalValidatorFalse.validate(expectedRegex));
                    throw new IllegalArgumentException(toString(settings));
        ClusterSettings.SettingUpdater<Boolean> settingUpdater = booleanSetting.newUpdater(ab1::set, logger);
    public void testListSettings() {
    // ByteSizeValue
        assertEquals(Arrays.asList("1", "2"), collect.get("foo.1.bar"));
            "foo",
        );
            out.flush();
            assertTrue(settings.keySet().contains(QUUX_QUUZ_SETTING));
            final IllegalArgumentException cause = (IllegalArgumentException) ex.getCause();
    }
        );
    public void testUpdaterIsIsolated() {
        } catch (IllegalArgumentException ex) {
 */
        AtomicReference<ByteSizeValue> value = new AtomicReference<>(null);
        assertEquals(2, asMap.size());
                    .stream()
        final IllegalArgumentException e = expectThrows(
        assertEquals(integerSetting.get(Settings.builder().put("foo.bar", 3).build()), Integer.valueOf(3));
import java.util.List;
            Property.NodeScope
            );
        assertThat(setting.hasIndexScope(), is(true));
        Setting.AffixSetting<List<String>> listAffixSetting = Setting.affixKeySetting(
            regexValidator.validate("123");
    public void testIntegerParser() throws Exception {
import java.util.Set;
                Settings.EMPTY
        Set<String> namespaces = setting.getNamespaces(build);
            Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "20s").build()
            }
        );
        Setting<String> current = Setting.simpleString("fallback0", Property.NodeScope);
        assertArrayEquals(value.toArray(new String[0]), input.toArray(new String[0]));
import org.opensearch.common.settings.Setting.LongParser;
            if (affixSetting.getNamespaces(s).contains("foo")) {
        } catch (IllegalArgumentException ex) {
        new FooBarValidator(),
    public void testFloatWithDefaultValue() {
            "suffix",
        assertEquals(1, ref.get().size());
        }
        previousInput = currentInput;
            fail();
        Setting<Settings> fallbackSetting = Setting.groupSetting("old.bar.", Property.Dynamic, Property.NodeScope);
        try (MockLogAppender mockLogAppender = MockLogAppender.createForLoggers(logger)) {
    }
        assertThat(value.get(), equalTo(new ByteSizeValue(12)));
            "prefix" + ".",
        assertTrue(listSetting.exists(builder.build()));
            "a.byte.size",
            IllegalArgumentException.class,
        assertTrue(settingUpdater.apply(build, Settings.EMPTY));
        assertFalse(settingUpdater.apply(build, build));
        Composite c = new Composite();
        Settings build = Settings.builder().put("foo.bar", "I am not a boolean").build();
    public void testValidateStringSetting() {
            assertEquals("The setting foo.bar must be >0", ex.getMessage());
                    fail("Expected validate() to not throw an exception, but it threw " + e);
            }
            }
                }
            Collections.singletonList("foo.deprecated"),
        assertEquals("3", asMap.get("foobar"));
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> filteredStringSetting.get(settings));
        // Test that the pattern is correctly initialized
        value = listSetting.get(builder.build());
        boolean changeAffixKeySetting = randomBoolean();
            return settings.iterator();
        Setting<Long> longSetting = Setting.longSetting("foo.bar", 42);
        Map<String, List<String>> collect = allConcreteSettings.collect(Collectors.toMap(Setting::getKey, (s) -> s.get(settings)));
            .build();
            .put("foo.bar", "foo.bar value")
            regexValidatorMatcherFalse.validate(expectedRegex);
        // A regex that matches one or more digits
import org.opensearch.common.unit.TimeValue;
        } catch (IllegalArgumentException ex) {
                assertEquals(expectedKey, memorySizeValueParser.getKey());
        Setting<Integer> b = Setting.intSetting("foo.int.bar.b", 1, Property.Dynamic, Property.NodeScope);
        AtomicReference<Settings> ref = new AtomicReference<>(null);
 */
    }
        asMap = ref.get().getAsGroups();
    }
            .put("foo.deprecated", "foo.deprecated1,foo.deprecated2")
            .build();
        if (changeAffixKeySetting) {
            settingUpdater.apply(build, Settings.EMPTY);
    }
        ref.set(setting.get(Settings.EMPTY));
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> settingUpdater.apply(invalid, previous));
        assertEquals(longSetting.get(Settings.builder().put("foo.baz", 3).build()), Long.valueOf(3));
        assertEquals(1.2, floatSetting.get(Settings.EMPTY).floatValue(), 0.01);
        ClusterSettings.SettingUpdater<Tuple<Integer, Integer>> settingUpdater = Setting.compoundUpdater(c::set, c::validate, a, b, logger);
                assertEquals(expectedMaxValue, minMaxTimeValueParser.getMax());
            );
        Setting<String> secondaryDefault = new Setting<>(
import java.util.Map;
        illegal = expectThrows(IllegalArgumentException.class, () -> {
        final IllegalArgumentException e2 = expectThrows(
        private Integer b;
            new ByteSizeValue(100, ByteSizeUnit.MB),
    }
        }
        Settings currentInput = Settings.builder()
        final BiConsumer<String, String> validator = (s1, s2) -> {};
        assertThat(integerSetting.hasNodeScope(), is(true));
        assertThrows(IllegalArgumentException.class, () -> finalValidator.validate("foo"));
            String toString(Map<Setting<?>, Object> s) {
        );
                    "org.opensearch.common.settings.IndexScopedSettings",
        }
        assertThat(setting.get(Settings.EMPTY), equalTo(random));
        AtomicReference<Boolean> ab1 = new AtomicReference<>(null);
        long expectedMinValue = Long.MIN_VALUE;
                throw new IllegalArgumentException("boom");
            "a.byte.size",
            Arrays.asList("foo,bar"),
    }
        try {
        assertTrue(groupSetting.exists(values));
        assertNotSame(current, ref.get());
            updater.getValue(Settings.builder().put("prefix.bar.suffix", 6).put("abc", 3).build(), Settings.EMPTY);
                Function.identity(),
                if (settings.get(fix0).equals(fix0.getDefault(Settings.EMPTY))) {
        );
        assertThat(e.getMessage(), containsString("must be stored inside opensearch.yml"));
    public void testMemorySize() {
        assertThat(illegalArgumentException.getMessage(), equalTo("failed to parse value [4999ms] for setting [bar], must be >= [5s]"));
            () -> predicateSettingUpdater.apply(
        assertFalse(setting.match("foo"));
        assertEquals(fix1.get(Settings.builder().put("abc.qrx", 30).build()), Integer.valueOf(30));
    }
            key -> Setting.simpleString(key, Property.NodeScope, Property.Dynamic)
        assertTrue(settingUpdater.apply(Settings.builder().put("a.byte.size", "20%").build(), Settings.EMPTY));
        AtomicReference<Boolean> atomicBoolean = new AtomicReference<>(null);
    }
    public void testFloatWithMinMax() {
    }
    public void testLongWithFallbackValue() {
        build = Settings.builder().put("foo.int.bar.a", 2).put("foo.int.bar.b", 5).build();
            currentSettingsBuilder.put("prefix.foo.infix.suffix", "bar");
        assertEquals(expectedFilteredStatus, longParser.getFilterStatus());
            final String expected =
        assertEquals(asMap.get("1").get("value"), "1");
        );
        );
        } catch (IllegalArgumentException ex) {
            booleanSetting.newUpdater(atomicBoolean::set, logger);
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> settingUpdater.apply(build, Settings.EMPTY));
    // Long
    }
        }
    }
    }
        Setting<Integer> fixSetting = Setting.intSetting("abc", 1, Property.NodeScope);
        assertEquals(5, integerSetting.get(Settings.builder().put("foo.bar", 5).build()).intValue());
                    throw new IllegalArgumentException("foo and 2 can't go together");
        boolean expectedFilteredStatus = true;
        assertSettingDeprecationsAndWarnings(new Setting[] { deprecatedListSetting });
 * license agreements. See the NOTICE file distributed with
                final RegexValidator newFinalValidator = new RegexValidator(expectedRegex);
            fix1.get(Settings.builder().put("abc.3.def", 13).put("abc.1.def", 11).put("abc.2.def", 12).put("abc.qrx", 20).build()),
        Setting<Integer> integerSetting = Setting.intSetting("foo.bar", 42);
    public void testAffixAsMap() {
        Settings build = Settings.builder()
        boolean expectedFilteredStatus = true;
        final Settings current = Settings.builder().put("prefix._foo", (String) null).build();
 * Unless required by applicable law or agreed to in writing,
        assertThat(e.getCause(), hasToString(containsString("validate always fails")));
            "prefix.",
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> setting.getConcreteSetting("foo"));
                    }
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        assertThat(integerSetting.hasIndexScope(), is(true));
    }
    public void testFilteredGroups() {
            Collections.emptyList(),
            Arrays.asList(intSetting, intSetting2)
            "foo.",
 * not use this file except in compliance with the License.
            expectedFilteredStatus
            IllegalArgumentException.class,
import static org.hamcrest.Matchers.hasSize;
            Property.Deprecated,
            assertThat(ex, hasToString(containsString("illegal value can't update [a.byte.size] from [25%] to [12]")));
    private static final Setting<String> BAZ_QUX_SETTING = Setting.simpleString("baz.qux", Property.NodeScope);
    }
            );
                assertEquals(expectedMaxValue, longParser.getMax());
 * specific language governing permissions and limitations
        }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> setting.get(settings));
        assertEquals(expectedMinValue, doubleParser.getMin(), 0.01);
        assertThat(e, hasToString(containsString("Failed to parse value for setting [" + filteredStringSetting.getKey() + "]")));
    public void testNonSecureSettingInKeystore() {
            regexValidator.writeTo(out);
        assertThat(e1, hasToString(containsString("Failed to parse value for setting [foo] must be >= 43")));
            "a.byte.size",
    }
/*
        assertEquals(3, namespaces.size());
        assertEquals(1.2, doubleSetting.get(Settings.EMPTY).doubleValue(), 0.01);
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
            (s) -> s.get("old.foo.bar", "some_default"),
        Settings hasFallback = Settings.builder().put("foo.bar", "o").build();
            Arrays.asList(intSetting, prefixKeySetting, affixSetting)
            public void validate(Integer value) {}
            );
            Function.identity(),
            TimeValue.timeValueSeconds(5)
        assertThat(byteSizeValue.getBytes(), equalTo(1024L));
                current,
        assertArrayEquals(value.toArray(new String[0]), input.toArray(new String[0]));
        Setting.AffixSetting<String> prefixKeySetting = Setting.prefixKeySetting(
        Setting<Float> floatSetting = Setting.floatSetting("foo.bar", fallbackSetting);
            "a.byte.size",
        assertTrue(settingUpdater.apply(currentInput, previousInput));
        assertThat(e1, hasToString(containsString("failed to parse value for setting [foo], must be >= [2h]")));
            assertThat(ex.getCause(), instanceOf(IllegalArgumentException.class));
        try {
            doubleParser.writeTo(out);
            s -> {},
    public static class ComplexType {
        Setting<String> fallsback = new Setting<>("foo.baz", secondaryDefault, Function.identity(), Property.NodeScope);
            () -> fix1.get(Settings.builder().put("abc.3.def", 13).put("abc.qrx", 20).build())
                assertThrows(IllegalArgumentException.class, () -> newFinalValidator.validate("foo"));
        boolean expectedChange = removeAffixKeySetting
        assertThat(ex.getMessage(), containsString("sensitive setting [foo.bar] must be dynamic"));
        ByteSizeValue memorySizeValue = memorySizeValueSetting.get(Settings.EMPTY);
        assertThat(setting.hasNodeScope(), is(false));
    public void testIntWithDefaultValue() {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        );
            currentSettingsBuilder.put("prefix.foo.infix2.suffix", "bar");
        assertEquals(longSetting.get(Settings.EMPTY), Long.valueOf(42));
        Setting<Settings> setting = Setting.groupSetting("foo.bar.", Property.Dynamic, Property.NodeScope);
            "index1",
            fail("not a boolean");
        assertEquals(expectedMinValue, floatParser.getMin(), 0.01);
        );
        IllegalArgumentException illegal = expectThrows(IllegalArgumentException.class, () -> {
        assertEquals(expectedFilteredStatus, minMaxTimeValueParser.getFilterStatus());
            this.foo = foo;
                assertEquals(expectedKey, longParser.getKey());
        assertNull(e4.getCause());
        );
            assertThat(settings.get(BAZ_QUX_SETTING), equalTo("baz.qux value"));
            (key) -> Setting.boolSetting(key, false, Property.NodeScope)
                minTimeValueParser = new MinTimeValueParser(in);
import org.opensearch.common.settings.Setting.MemorySizeValueParser;
            "bar",
            fallbackSetting,
            || changeAffixKeySetting
        assertEquals("foo.bar.enable", concreteSetting.getKey());
            fail();
    public void testAffixMapUpdateWithNullSettingValue() {
            assertFalse(fooSetting.exists(Settings.builder().put(setting, "bar").build()));
            assertEquals(ex.getMessage(), "illegal value can't update [foo.bar.] from [{}] to [{\"1.value\":\"1\",\"2.value\":\"2\"}]");
        );
        Integer aValue = c.a;
        setting = Setting.simpleString("foo.bar");
            integerParser.writeTo(out);
        assertEquals(expectedPattern.pattern(), regexValidator.getPattern().pattern());
        assertThat(illegalArgumentException.getMessage(), equalTo("failed to parse value [4999ms] for setting [foo], must be >= [5s]"));
    public void testRejectSensitiveWithoutDynamic() {
        assertEquals("prefix must end with a '.'", exc.getMessage());
            integerSetting.get(Settings.builder().put("foo.bar", -1).build());
        assertEquals(memorySizeValue.getBytes(), 1024);
            IllegalArgumentException.class,
            .put("prefix.foo.bar.baz", "foo")
        Setting<Float> floatSetting = Setting.floatSetting("foo.bar", (float) 1.2, 0, 10, Property.NodeScope);
    public void testDefault() {
        } catch (IllegalArgumentException ex) {
            .put("foo.baz.enable", "true")
            assertEquals("setting [foo.bar] is not dynamic", ex.getMessage());
 * Licensed to Elasticsearch under one or more contributor
        assertEquals("value 1", asMap.get("1").get("value"));
        e = expectThrows(
            TimeValue.timeValueSeconds(20)
        } catch (IllegalArgumentException ex) {
                assertEquals(expectedMinValue, byteSizeValueParser.getMin());
        Setting<Double> doubleSetting = Setting.doubleSetting("foo.bar", 42.1);
}
        }, Property.Filtered);
        assertEquals(2, c.a.intValue());
        @Override
        }
            assertTrue("key: " + key + " doesn't match", listSetting.match(key));
        );
            final List<Setting<?>> settings = Arrays.asList(BAZ_QUX_SETTING, QUUX_QUUZ_SETTING);
        assertEquals("", value);
        // reset to default
                assertEquals(expectedKey, integerParser.getKey());
        assertTrue(listSetting.match("foo.bar"));
            floatSetting.get(Settings.builder().put("foo.bar", (float) 11.3).build());
        // now update and check that we got it
                assertEquals(expectedFilteredStatus, floatParser.getFilterStatus());
        assertTrue(settingUpdater.apply(Settings.builder().put("a.byte.size", "12b").build(), Settings.EMPTY));
            Property.Dynamic,
            TimeValue.timeValueSeconds(5),
    public void testByteSizeSettingValidation() {
            expectedKey,
        AtomicReference<List<String>> ref = new AtomicReference<>();
        assertFalse(memorySizeValueSetting.isGroupSetting());
        assertFalse(listAffixSetting.match("foo.baz"));
        assertEquals(input.size(), ref.get().size());
        assertEquals(1, c.b.intValue());
        assertEquals(memorySizeValue.getBytes(), JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.5, 1.0);
            assertEquals("The setting foo.bar must be >0", ex.getMessage());
        final IllegalArgumentException e2 = expectThrows(
        ClusterSettings.SettingUpdater<Tuple<Integer, Integer>> settingUpdater = Setting.compoundUpdater(c::set, c::validate, a, b, logger);
            }
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        // We accept settings with multiple scopes but they will be rejected when we register with SettingsModule.registerSetting
        memorySizeValue = memorySizeValueSetting.get(Settings.EMPTY);
        Settings s = updater.getValue(
        boolean removeAffixKeySetting = randomBoolean();
        );
        } catch (IllegalArgumentException ex) {
    }
        assertEquals("42", secondaryDefaultViaSettings.get(Settings.builder().put("old.foo.bar", 42).build()));
            () -> settingUpdater.apply(Settings.builder().put("a.byte.size", 12).build(), Settings.EMPTY)
        Setting<Integer> intSetting = Setting.intSetting("prefix.foo", 1, Property.NodeScope, Property.Dynamic);
        builder = Settings.builder().put("foo.bar", "1,2,3");
        }
            .put("foo.deprecated", "foo.non_deprecated1,foo.non_deprecated2")
        );
        double expectedMinValue = Double.MIN_VALUE;
        assertThat(e, hasToString(containsString("illegal value can't update [a.byte.size] from [2048b] to [12]")));
        assertTrue(updater.hasChanged(current, previous));
            () -> Setting.intSetting("foo", 45, 43, 44, Property.Filtered)
        assertEquals(longSetting.get(Settings.EMPTY), Long.valueOf(2));
    public void testValidator() {
            IllegalArgumentException.class,
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        }
            )
    }
                minMaxTimeValueParser = new MinMaxTimeValueParser(in);
        String expectedKey = "test key";
        TimeValue defaultValue = TimeValue.timeValueMillis(randomIntBetween(0, 1000000));
        settingUpdater.apply(Settings.builder().putList("foo.bar", "123").build(), builder.build());
            fail("Expected validate() to not throw an exception, but it threw " + e);
import java.util.function.BiConsumer;
            fail();
        assertThat(cause, hasToString(containsString(expected)));
            fail();
        final Setting minSetting = Setting.timeSetting("foo", TimeValue.timeValueHours(3), TimeValue.timeValueHours(2), Property.Filtered);
    public void testRejectConflictingDynamicAndFinalProperties() {
        assertTrue(settingUpdater.apply(build, previous));
            Property.Dynamic,
            () -> Setting.affixKeySetting("foo", "enable", (key) -> Setting.boolSetting(key, false, Property.NodeScope))
        assertEquals("key [foo..enable] must match [*.enable] but didn't.", ex.getMessage());
            public Iterator<Setting<?>> settings() {
    private static final Setting<String> FOO_BAR_SETTING = new Setting<>(
        assertThat(integerSetting.hasIndexScope(), is(false));
        if (changePrefixKeySetting) {
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        Settings values = Settings.builder().put("old.bar.1.value", "value 1").put("old.bar.2.value", "value 2").build();
            previousSettingsBuilder.put("prefix.foo.infix2.suffix", "bar");
        final Setting<ByteSizeValue> byteSizeValueSetting = Setting.byteSizeSetting(
            byteSizeValueParser.writeTo(out);
            this.a = a;
        Setting.AffixSetting<List<String>> listAffixSetting = Setting.affixKeySetting(
        Setting.AffixSetting<Boolean> setting = Setting.suffixKeySetting(
        public static boolean invokedWithDependencies;
        assertTrue(setting.match("foo.bar"));
    }
        MockSecureSettings secureSettings = new MockSecureSettings();
        assertEquals(
        );
            fail();
        List<String> input = Arrays.asList("test", "test1, test2", "test", ",,,,");
        assertEquals(1, longSetting.get(Settings.EMPTY).longValue());
    public void testAffixSettingsFailOnGet() {
        try {
        );
    public void testIntWithFallbackValue() {
        assertEquals(expectedMinValue, longParser.getMin());
            new ByteSizeValue(100, ByteSizeUnit.MB),
        assertEquals("some_default", fallsback.get(Settings.EMPTY, Settings.EMPTY));
                floatParser = new FloatParser(in);
        );
    }
        );
    public void testDoubleParser() throws Exception {
        assertNotSame("update - type has changed", type, ref.get());
    static class FooBarValidator implements Setting.Validator<String> {
            () -> Setting.doubleSetting("foo", 42.0, 43.0, Property.Filtered)
            (key) -> Setting.groupSetting(key + ".", Setting.Property.Dynamic, Setting.Property.NodeScope)
        Setting<Boolean> concreteSetting = setting.getConcreteSetting("foo.bar");
            .put("baz.qux", "baz.qux value")
            Property.NodeScope
        assertNull(e.getCause());
 * the Apache License, Version 2.0 (the "License"); you may
    }
        assertThat(e2, hasToString(containsString("Failed to parse value for setting [foo] must be <= 44")));
        assertThat(updater.apply(currentSettingsBuilder.build(), previousSettingsBuilder.build()), is(expectedChange));
        final RegexValidator finalValidator = new RegexValidator(expectedRegex);
        // It gets more complicated when there are two settings objects....
    public void testCompositeValidator() {
                    Level.INFO,
    }
        );
                } else if (settings.size() == 2) {
        assertFalse(setting.isGroupSetting());
        assertThat(e3, hasToString(containsString("failed to parse value for setting [foo] as a time value")));
        );
public class SettingTests extends OpenSearchTestCase {
            assertTrue("key: " + key + " doesn't match", listSetting.match(key));
        );
            assertEquals("Failed to parse value [-1.4] for setting [foo.bar] must be >= 0.0", ex.getMessage());
        value = settingWithFallback.get(Settings.builder().putList("foo.baz", "3", "4").build());
            Property.NodeScope
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        assertEquals(asMap.get("1").get("value"), "1");
        DoubleParser doubleParser = new DoubleParser(expectedMinValue, expectedMaxValue, expectedKey, expectedFilteredStatus);
        assertEquals(expectedKey, minTimeValueParser.getKey());
        value = settingWithFallback.get(Settings.builder().putList("foo.baz", "3", "4").putList("foo.bar", "1", "2").build());
        long expectedMaxValue = Long.MAX_VALUE;
        Property.NodeScope
        assertEquals(expectedKey, floatParser.getKey());
        final RegexValidator finalValidatorFalse = new RegexValidator(expectedRegex);
        try {
 * SPDX-License-Identifier: Apache-2.0
        });
            }
        } catch (IllegalArgumentException ex) {
        assertNull(ex.getCause());
        nonDeprecatedListSetting.get(settings);
            IllegalArgumentException.class,
        build = Settings.builder().put("foo.bar", "I am not a boolean").build();
        assertFalse(fooSetting.exists(Settings.EMPTY));
        assertThat(settingWithBothBounds.get(Settings.EMPTY), equalTo(TimeValue.timeValueSeconds(10)));
                assertEquals(expectedKey, minTimeValueParser.getKey());
        // now update and check that we got it
            out.flush();
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertTrue(listAffixSetting.match("foo.test.bar"));
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();
        assertEquals(expectedMaxValue, doubleParser.getMax(), 0.01);
        value = settingWithFallback.get(Settings.builder().putList("foo.bar", "1", "2").build());
        try {
        assertNotSame("update - type has changed", type, ref.get());
 * The OpenSearch Contributors require contributions made to
        ByteSizeValue memorySizeValue = memorySizeSetting.get(Settings.EMPTY);
import org.apache.logging.log4j.LogManager;
        assertEquals("[\"testelement\"]", listAffixSetting.getDefaultRaw(Settings.EMPTY));
                List<Setting<?>> a = Arrays.asList(affix, fix0);
        final IndexSettings settings = new IndexSettings(metadata, Settings.EMPTY);
    // Float
        assertEquals(2, asMap.size());
    public void testRejectConflictingDynamicAndUnmodifiableOnRestoreProperties() {
                }
        );
        }
    }
        assertThat(affixSetting.getNamespaces(Settings.builder().put("prefix.infix.suffix", "anything").build()), hasSize(1));
        final IllegalArgumentException e4 = expectThrows(IllegalArgumentException.class, () -> maxSetting.get(maxSettings));
        String expectedKey = "test key";
        AtomicReference<ByteSizeValue> value = new AtomicReference<>(null);
                assertEquals(expectedMinValue, minTimeValueParser.getMin());
    }
        }
    public void testFilteredBooleanSetting() {
        assertEquals(expectedKey, minMaxTimeValueParser.getKey());
        memorySizeValue = memorySizeValueSetting.get(Settings.EMPTY);
        );
        assertTrue(setting.hasComplexMatcher());
                        return event.getMarker().getName().equals(" [index1]");
        assertEquals(1, value.size());
        assertTrue(listSetting.exists(builder.build()));
        Map<String, Settings> asMap = settings.getAsGroups();
        ClusterSettings.SettingUpdater<Settings> settingUpdater = setting.newUpdater(ref::set, logger);
            .put("foo.bar.3.value", "3")
        Setting<Double> doubleSetting = Setting.doubleSetting("foo.bar", fallbackSetting);
import java.util.Collections;
        currentInput = Settings.builder().put("foo.bar.1.value", "1").put("foo.bar.2.value", "2").build();
            minTimeValueParser.writeTo(out);
        for (int i = 0; i < intValues.size(); i++) {
            out.flush();
        assertFalse(groupSetting.exists(Settings.EMPTY));
        final String expectedMessage = "failed to parse value [" + value + "b] for setting [a.byte.size], must be >= [20000000b]";
        assertThat(e, hasToString(containsString("non-index-scoped setting [foo.bar] can not have property [UnmodifiableOnRestore]")));
            (key) -> Setting.boolSetting(key, false, Property.NodeScope)
        assertEquals("3", value.get(0));
        // then (long)((int) value) will lose precision.
        assertEquals("4", value.get(1));
        assertEquals(2, c.a.intValue());
    }
        assertThat(e, hasToString(containsString("Failed to parse value for setting [foo] must be >= 43")));
        ClusterSettings.SettingUpdater<ByteSizeValue> settingUpdater = memorySizeSetting.newUpdater(value::set, logger);
            (key) -> Setting.listSetting(key, Collections.emptyList(), Function.identity(), Property.NodeScope)
        Setting.AffixSetting<String> setting = Setting.prefixKeySetting("foo.bar.", key -> Setting.simpleString(key, Property.NodeScope));
                    .collect(Collectors.joining(","));
        setting = Setting.simpleString("foo.bar", Property.IndexScope, Property.NodeScope);
        Setting<Boolean> booleanSetting = Setting.boolSetting("foo.bar", false, Property.Dynamic, Property.NodeScope);
    }
        assertThat(integerSetting.hasNodeScope(), is(false));
/*
            Property.NodeScope
        Setting<Integer> intSetting2 = Setting.intSetting("prefix.same", 1, Property.NodeScope, Property.Dynamic);
        assertEquals(memorySizeValue.getBytes(), 2048);
        );
        Setting<Long> longSetting = Setting.longSetting("foo.bar", 1, 0, 10, Property.NodeScope);
        };
        exc = expectThrows(
    public void testAffixKeySetting() {
                assertEquals(expectedKey, byteSizeValueParser.getKey());
            );
    public void testGroups() {
            key -> Setting.simpleString(key, Property.Dynamic, Property.NodeScope)
        }
        );
        LongParser longParser = new LongParser(expectedMinValue, expectedMaxValue, expectedKey, expectedFilteredStatus);
        );
        try {
import static org.opensearch.index.IndexSettingsTests.newIndexMeta;
            IllegalArgumentException.class,
            Settings.builder().put("prefix.foo.suffix", 5).put("prefix.bar.suffix", 5).put("abc", 3).build(),
            IllegalArgumentException.class,
        final Settings minSettings = Settings.builder().put("foo", "not a time value").build();
            "foo.bar",
        assertThat(setting.hasNodeScope(), is(false));
                memorySizeValueParser = new MemorySizeValueParser(in);
                Property.Filtered
        boolean removePrefixKeySetting = randomBoolean();
import static org.hamcrest.Matchers.hasToString;
        assertEquals(doubleSetting.get(Settings.EMPTY), Double.valueOf(42.1));
        );
            minMaxTimeValueParser.writeTo(out);
        assertEquals(1, integerSetting.get(Settings.EMPTY).intValue());
import org.apache.logging.log4j.Logger;
        final Setting.AffixSetting<String> affixSetting = Setting.prefixKeySetting(
            assertThat(settings.get(QUUX_QUUZ_SETTING), equalTo("quux.quuz value"));
        assertTrue(booleanSetting.get(Settings.builder().put("foo.bar", true).build()));
        assertEquals(Arrays.asList("6"), collect.get("foo.3.bar"));
    }
        final Setting<String> filteredStringSetting = new Setting<>("foo.bar", "foobar", Function.identity(), value -> {
            Property.Dynamic,
        }
        ComplexType type = ref.get();
        assertThat(affixSetting.getNamespaces(Settings.builder().put("prefix.infix.suffix.anything", "anything").build()), hasSize(1));
        assertEquals("o", fallsback.get(hasFallback));
        final IllegalArgumentException e3 = expectThrows(IllegalArgumentException.class, () -> minSetting.get(minSettings));
                new Setting.SimpleKey("fallback" + i),
import java.util.Arrays;
    public void testIntWithMinMax() {
    }
                assertEquals(expectedPattern.pattern(), regexValidator.getPattern().pattern());
        if (randomBoolean()) {
    // the purpose of this test is merely to ensure that a validator is invoked with the appropriate values
            Property.NodeScope
            out.flush();
        assertFalse(listAffixSetting.match("foo.bar"));
            assertEquals("Failed to parse value [-1.4] for setting [foo.bar] must be >= 0.0", ex.getMessage());
            invokedInIsolation = true;
        try {
            new ByteSizeValue(1024),
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> stringSetting.get(settings));
    );
            mockLogAppender.assertAllExpectationsMatched();
        final Settings settings = Settings.builder().put("a.byte.size", value + "b").build();
            (key) -> Setting.listSetting(key, Collections.emptyList(), Function.identity(), Property.NodeScope)
        ByteSizeValueParser byteSizeValueParser = new ByteSizeValueParser(expectedMinValue, expectedMaxValue, expectedKey);
            .put("foo.bar.2.value", "2")
        assertEquals("42", secondaryDefault.get(Settings.builder().put("old.foo.bar", 42).build()));
    public void testDoubleWithFallbackValue() {
        assertEquals("2", ref.get().foo);
        float expectedMinValue = Float.MIN_VALUE;
        assertFalse(listAffixSetting.match("foo.buzz.baz.bar"));
        final Setting<List<String>> deprecatedListSetting = Setting.listSetting(
        final Settings settings = Settings.builder().put("a.byte.size", value + "b").build();
        assertEquals(Arrays.asList("3", "4", "5"), collect.get("foo.2.bar"));
        IllegalArgumentException ex = expectThrows(
        assertEquals(expectedKey, byteSizeValueParser.getKey());
        final String foo;
    public void testByteSizeSetting() {
            Property.Dynamic,
    public void testRejectNonIndexScopedPrivateIndexSetting() {
        boolean expectedFilteredStatus = true;
                integerParser = new IntegerParser(in);
        final Logger logger = LogManager.getLogger(IndexScopedSettings.class);
            () -> Setting.intSetting("foo", 42, 43, 44, Property.Filtered)
        setting = Setting.timeSetting("foo", (s) -> TimeValue.timeValueMillis(random.getMillis() * factor), TimeValue.ZERO);
            "enable",
            Property.Dynamic,
        final Setting.AffixSetting<Integer> affixSetting = Setting.affixKeySetting(
import static org.hamcrest.Matchers.equalTo;
            assertThrows(
        assertThat(exc.getMessage(), equalTo("boom"));
        assertNull(ab2.get());
        List<String> value = listSetting.get(Settings.EMPTY);
        assertSame(aValue, c.a);
        assertEquals(expectedMaxValue, floatParser.getMax(), 0.01);
import static org.hamcrest.Matchers.instanceOf;
        assertFalse(setting.isGroupSetting());
        Setting<List<Integer>> otherSettings = Setting.listSetting(
        assertEquals(3, asMap.size());
        }
        Setting<Integer> b = Setting.intSetting("foo.int.bar.b", 1, Property.Dynamic, Property.NodeScope);
    // Double
        }
            TimeValue.timeValueHours(2),
            () -> fix1.get(Settings.builder().put("abc.4.def", 14).put("abc.qrx", 20).put("abc.tuv", 50).build())
            .putList("foo.3.bar", "6")
 * GitHub history for details.
                assertEquals(expectedFilteredStatus, minTimeValueParser.getFilterStatus());
            () -> settingWithLowerBound.get(Settings.builder().put("foo", "4999ms").build())
            .putList("foo.bar", "6")
        assertThat(e.getMessage(), is("abc.3.def:13"));
            "foo.",
        assertEquals(expectedMinValue, byteSizeValueParser.getMin());
        assertTrue(setting.isGroupSetting());
            @Override
                assertEquals(expectedFilteredStatus, longParser.getFilterStatus());
     * We can't have Null properties
import org.opensearch.common.collect.Tuple;
        } catch (IllegalArgumentException ex) {
        List<Integer> intValues = otherSettings.get(Settings.builder().put("foo.bar", "0,1,2,3").build());
    public void testGet() {
        Setting<Double> doubleSettingWithValidator = Setting.doubleSetting("foo.bar", fallbackSetting, value -> {
        assertEquals("2", asMap.get("baz"));
        assertThat(e, hasToString(containsString("Failed to parse value for setting [foo] must be >= 43.0")));
        // THEN affix updater is always expected to have changed (even when defaults are omitted)
        final Setting<ByteSizeValue> byteSizeValueSetting = Setting.byteSizeSetting(
        assertEquals(expectedMaxValue, longParser.getMax());
        assertEquals(expectedMinValue, integerParser.getMin());
        assertThat(e2, hasToString(containsString("failed to parse value for setting [foo], must be <= [3h]")));
        Setting<List<String>> listAffixSetting = Setting.affixKeySetting(
            .build();
                assertEquals(expectedKey, floatParser.getKey());
        final Settings previous = Settings.builder().put("prefix._foo", "bar").build();
        String expectedRegex = "\\d+";
        FloatParser floatParser = new FloatParser(expectedMinValue, expectedMaxValue, expectedKey, expectedFilteredStatus);
            Property.Filtered
import org.opensearch.common.settings.Setting.IntegerParser;
            assertNotNull(ex.getCause());
            out.flush();
                assertEquals(expectedKey, doubleParser.getKey());
        for (String key : builder.keys()) {
    public void testAffixSettingNamespaces() {
        assertEquals(asMap.get("3").get("value"), "3");
            assertTrue(fooSetting.exists(Settings.builder().put("foo", "bar").build()));
                doubleParser = new DoubleParser(in);
    }
        ClusterSettings.SettingUpdater<Boolean> settingUpdater = booleanSetting.newUpdater(atomicBoolean::set, logger);
        assertEquals(doubleSetting.get(Settings.builder().put("foo.bar", 3.2).build()), Double.valueOf(3.2));
        RegexValidator regexValidatorMatcherFalse = new RegexValidator(expectedRegex, false);
            () -> Setting.simpleString("foo.bar", Property.Final, Property.Dynamic)
            if (Integer.signum(a) != Integer.signum(b)) {
        assertTrue(namespaces.contains("boom"));
        // try update bogus value
        final Settings settings = Settings.builder().put("foo", "not a boolean value").build();
        assertThat(e.getCause(), instanceOf(SettingsException.class));
        } catch (IllegalArgumentException ex) {
import org.opensearch.core.common.unit.ByteSizeUnit;
        assertEquals(floatSetting.get(Settings.EMPTY), Float.valueOf((float) 42.1));
    public void testFilteredLongSetting() {
            Property.Dynamic,
        e = expectThrows(
        assertEquals(1, ref.get().size());
        Setting<Boolean> concreteSetting = setting.getConcreteSettingForNamespace("foo.bar");
        assertEquals(2, c.a.intValue());
            fail("no unit");
import org.opensearch.common.settings.AbstractScopedSettings.SettingUpdater;
        final Settings settings = Settings.builder()
        assertEquals("foo,bar", ref.get().get(0));
        }
            out.flush();
    public void testLongWithMinMax() {
            (key) -> Setting.intSetting(key, 5, Setting.Property.Dynamic, Setting.Property.NodeScope)
        Settings.Builder currentSettingsBuilder = Settings.builder().put("prefix.foo.bar.baz", "foo").put("prefix.foo.infix.suffix", "foo");
        Setting<Integer> fix0 = Setting.intSetting("abc.tuv", 20, 0);
        Setting<Double> fallbackSetting = Setting.doubleSetting("foo.baz", 2.1);
