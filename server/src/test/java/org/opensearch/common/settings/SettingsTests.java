            Settings settings = Settings.builder()
        assertNull(filteredSettings.get("a.b.c"));
        assertEquals(5, build.size());
        assertThat(firstLevelSettings.get("2.3"), equalTo("hello world"));
            .put(Settings.builder().putList("value", "1", "2").build())
    public void testSimpleJsonSettings() throws Exception {
        assertTrue(Settings.builder().copy("test", settings).build().keySet().contains("test"));
         * is then asserting that we no longer make this mistake when doing the internal string conversion. Instead, we convert to a string
        settings = Settings.builder()
    public void testGroupPrefix() {
        );
    public void testReadWriteArray() throws IOException {
        final TimeValue expected = new TimeValue(1500, TimeUnit.MICROSECONDS);
        assertEquals(Arrays.asList("1", "2", "3"), build.getAsList("foo.bar.baz"));
import org.opensearch.common.unit.TimeValue;
    public void testSecureSettingConflict() {
            .build();
 * specific language governing permissions and limitations
            numKeys++;
        assertNotNull(key1);
        builder.put("test.key1.baz", "blah1");
    }
        assertThat(settings.getAsInt("test1.test2.value3", -1), equalTo(2));
        builder.endObject();
    }
import java.util.NoSuchElementException;
        String yaml = "/org/opensearch/common/settings/loader/indentation-settings.yml";
        assertEquals(4, prefixMap.size());
        final IllegalArgumentException e = expectThrows(
        assertThat(settings.getAsList("a"), notNullValue());
    public void testThatArraysAreOverriddenCorrectly() throws IOException {
            .put(Settings.builder().putList("value", "3").build())
    public void testWriteSettingsToStream() throws IOException {
            .put("foo.bar", "def")
import java.io.InputStream;
        BytesStreamOutput out = new BytesStreamOutput();
        assertEquals("{\"foo.bar\":[\"1\",\"2\",\"3\"]}", builder.toString());
    }
        builder.putList("test.key4.foo", "1", "2");
        secureSettings.setString("test.key1.foo", "somethingsecure");
        expectThrows(NoSuchElementException.class, () -> prefixIterator.next());
        assertTrue(names.contains("baz"));
 * Modifications Copyright OpenSearch Contributors. See
        Settings test = Settings.builder()
        final Settings settings = Settings.builder()
        assertThat(settings.getAsList("test1.test3").get(1), equalTo("test3-2"));
        builder.put("a.b.c", "ab2");
        assertNull(settings.get("test1.test3.0"));
        assertTrue(filteredSettings.keySet().contains("a.b"));
    }
            .build();
    public void testSecureSettingIllegalName() {
        final TimeValue actual = setting.get(settings);
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> { Settings.builder().loadFromPath(tmp); });
            assertTrue(prefixIterator.hasNext());
            .build();
            .build();
    public void testGetAsArrayFailsOnDuplicates() {
    }
        builder.put("test.key2.else", "blah4");
        builder.put("a.b.c", "ab2");
        assertThat(settings.get("foo.test"), equalTo("test"));
        settings = Settings.builder()
        assertTrue(Settings.EMPTY.isEmpty());
        assertFalse(filteredSettings.keySet().contains("a.b.c.d"));
    }
import org.opensearch.core.common.io.stream.StreamInput;
        assertThat(settings.getAsList("d"), notNullValue());
        final ByteSizeValue expected = new ByteSizeValue(randomNonNegativeLong(), ByteSizeUnit.BYTES);
        expectThrows(UnsupportedOperationException.class, () -> prefixMap.keySet().remove("a.b"));
    }
    }
import java.util.Map;
import static org.hamcrest.Matchers.containsInAnyOrder;
        assertNull(build.get("foo.null.baz"));
    }
        if (randomBoolean()) {
            e.getMessage(),
        // this is just terrible but it's the existing behavior!
        assertFalse(fooSettings.isEmpty());
    public void testFractionalTimeValue() {
        assertFalse(filteredSettings.keySet().contains("a"));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> SecureSetting.secureString("*IllegalName", null));
        MockSecureSettings secureSettings = new MockSecureSettings();
        final Settings settings = Settings.builder().loadFromStream(yaml, getClass().getResourceAsStream(yaml), false).build();
    public void testFractionalByteSizeValue() {
            .build();
    public void testEmpty() {
}
        });
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> Settings.builder().copy("not_there", settings));
        });
        assertEquals(2, secondLevelSetting.size());
        // overriding a single value with an array
import static org.hamcrest.Matchers.contains;
/*
        assertNull(Settings.builder().copy("foo.bar.baz", settings).build().get("test"));
    }
            .build();
 * KIND, either express or implied.  See the License for the
    public void testYamlPlaceholder() throws IOException {
            TimeValue.parseTimeValue(randomTimeValue(0, 24, "h"), "key"),
        assertEquals("b.c", prefixIterator.next());
        assertNull(thirdLevelSetting.get("2.3.4"));
        Settings.Builder builder = Settings.builder();
import java.nio.file.Files;
            Settings.builder().loadFromStream(yaml, getClass().getResourceAsStream(yaml), false);
 * The OpenSearch Contributors require contributions made to
        assertThat(settings.size(), equalTo(1));
            assertTrue(prefixIterator.hasNext());
            TimeValue.ZERO
import org.opensearch.common.io.stream.BytesStreamOutput;
    public void testMultLevelGetPrefix() {
        secureSettings.setString("test.key1.bar", "somethingsecure");
            .put("foo.baz", "1,2,3,4")
        assertFalse(filteredSettings.keySet().contains("a.b.c"));
            .put("setting1", "${HOSTNAME}")
        }
            () -> Settings.builder().put("setting1", "${java.home}").replacePropertyPlaceholders().build()
        final String json = "/org/opensearch/common/settings/loader/test-settings.json";
    }
        assertThat(settings.getAsList("setting1"), contains(hostname, hostip));
        assertThat(settings.get("test1.value1"), equalTo("value1"));
        for (int i = 0; i < 10; i++) {
            .put(Settings.builder().putList("value", "2", "3").build())
    }
        assertFalse(iterator.hasNext());
        Settings key2 = groups.get("key2");
            .put("3.4", "ghi")
import org.opensearch.common.xcontent.XContentType;
        Settings settings = Settings.builder().putList("foo.bar", "0", "1", "2", "3").put("foo.bar.baz", "baz").putNull("test").build();
         * doing the internal string conversion. Instead, we convert to a duration using a method that does not lose the original unit.
    }
            .replacePropertyPlaceholders()
        Settings firstLevelSettings = settings.getByPrefix("1.");
        assertEquals(3, filteredSettings.size());
            .put(Settings.builder().put("value.data", "1").build())
        // overriding an array with a shorter array
        settings = Settings.builder()
        String yaml = "/org/opensearch/common/settings/loader/indentation-with-explicit-document-start-settings.yml";
        builder.put("a.b", "ab1");
        assertThat(settings.getAsList("value"), contains("2", "3"));
        Settings settings = Settings.builder().put("archived.foo.bar", "baz").normalizePrefix("foo.").build();
    public void testIndentation() throws Exception {
        assertEquals(0, filteredSettings.size());
        assertThat(settings.get("archived.foo.*"), equalTo("baz"));
        expectThrows(NoSuchElementException.class, () -> iterator.next());
        assertThat(settings.getAsList("foo.bar.baz").size(), equalTo(2));
        final boolean flatSettings = randomBoolean();
            .put(Settings.builder().put("value.deep.key", "3").build())
        // overriding an array with a deeper structure
        final TimeValue actual = setting.get(settings);
        Iterator<String> iterator = filteredSettings.keySet().iterator();
            .put(Settings.builder().putList("value", "4", "5").build())
        assertThat(settings.getAsList("a"), contains("b", "c"));
        assertThat(settings.getAsList("test1.test3").get(1), equalTo("test3-2"));
        assertEquals(build.getAsList("foo.bar"), Arrays.asList("0", "1", "2", "3"));
        final Settings implicitEnvSettings = Settings.builder()
    public void testReplacePropertiesPlaceholderSystemPropertyList() {
        settings = Settings.builder()
        );
            TimeValue.parseTimeValue(randomTimeValue(0, 24, "h"), "key"),
        if (randomBoolean()) {
        MockSecureSettings secureSettings = new MockSecureSettings();
        settings = Settings.builder().put("bar", "baz").normalizePrefix("foo.").build();
        assertThat(settings.get("test1.test2.value2"), equalTo("value2"));
        assertEquals("{\"ant.bee\":{\"cat.dog\":{\"ewe\":\"value3\"},\"cat\":\"value2\"},\"ant\":\"value1\"}", builder.toString());
        assertEquals(2, build.getAsInt("foo.foobar", 0).intValue());
        assertThat(settings.get("value"), is("[4, 5]"));
        Settings test = Settings.builder().put("ant", "value1").put("ant.bee.cat", "value2").put("bee.cat", "value3").build();
         * Previously we would internally convert the byte size value to a string using a method that tries to be smart about the units
        Setting<SecureString> setting = SecureSetting.secureString("something.secure", null);
        assertThat(thirdLevelSetting.get("4"), equalTo("abc"));
            .put(Settings.builder().putList("value.deep.key", "1", "2", "3").build())
        assertTrue(filteredSettings.keySet().contains("a.b.c"));
 * license agreements. See the NOTICE file distributed with
        test.toXContent(builder, new ToXContent.MapParams(Collections.singletonMap("flat_settings", "true")));
        assertThat(settings.get("test1.test2.value2"), equalTo("value2"));
            ByteSizeValue.parseBytesSizeValue(randomIntBetween(1, 16) + "k", "key")
        assertFalse(filteredSettings.keySet().contains("a.b"));
    public void testMissingValue() throws Exception {
    }
        assertThat(settings.getAsList("foo.bar.baz").get(1), equalTo("2"));
        assertThat(actual, equalTo(expected));
        assertNull(settings.get("test1.test3.0"));
            .putList("setting1", "${HOSTNAME}", "${HOSTIP}")
        builder.put("a.c", "ac1");
            .put(Settings.builder().put("value", "3").build())
        if (randomBoolean()) {
    }
        assertThat(settings.size(), equalTo(1));
        builder.startObject();
        assertThat(e, hasToString(containsString("Could not resolve placeholder 'java.home'")));
    public void testFilteredMap() {
        settings = Settings.builder()
        }
        assertTrue(names.contains("bar"));
        builder.put("a.b.c.d", "ab3");
        XContentBuilder builder = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent());
        assertEquals(2, groups.size());
        Settings settings = builder.build();
            .build();
            IllegalArgumentException.class,
        assertFalse(prefixMap.keySet().contains("a"));
 *
        assertNotNull(value);
        assertEquals("source key not found in the source settings", iae.getMessage());
            "key",
    public void testToAndFromXContent() throws IOException {
        Path tmp = createTempFile("test", ".yaml");
        assertEquals(4, numKeys);
            .put(Settings.builder().put("value.with.deep.key", "1").build())
        assertEquals("ab2", filteredSettings.get("a.b.c"));
import static org.hamcrest.Matchers.empty;
            .put("property.placeholder", value)
    public void testSecureSettingsPrefix() {
        builder.put("a", "a1");
 * Unless required by applicable law or agreed to in writing,
        }
        final String value = System.getProperty("java.home");
        assertTrue(e.getMessage().contains("does not match the allowed setting name pattern"));
            .put("bar", "hello world")
            assertTrue(iterator.hasNext());
        assertNull(settings.get("test.key3.bar"));
         * 1.5k. Then, 1.5k could not be converted back to a ByteSizeValue because ByteSizeValues do not support fractional components.
        assertThat(settings.get("archived.foo.bar"), equalTo("baz"));
    public void testYamlLegacyList() throws IOException {
        Settings prefixSettings = settings.getByPrefix("test.prefix.");
        assertEquals("ab3", filteredSettings.get("a.b.c.d"));
        test.toXContent(builder, new ToXContent.MapParams(Collections.emptyMap()));
        Settings filteredSettings = builder.build().filter((k) -> k.startsWith("a.b"));
        assertThat(names.size(), equalTo(2));
        assertThat(fooSettings.get("baz"), equalTo("ghi"));
        secureSettings.setString("test.prefix.foo", "somethingsecure");
    }
        Settings settings = Settings.builder().put("something.secure", "notreallysecure").build();
        builder.put("test.key1.baz", "blah1");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> setting.get(settings));
        settings = Settings.builder().put("archived.foo.*", "baz").normalizePrefix("foo.").build();
        builder.endObject();
            .replacePropertyPlaceholders(name -> name.equals("HOSTNAME") ? hostname : name.equals("HOSTIP") ? hostip : null)
        assertNull(filteredSettings.get("a.b.c.d"));
        assertThat(names.size(), equalTo(2));
        Settings settings = Settings.builder().putList("foo.bar", "0", "1", "2", "3").put("foo.bar.baz", "baz").build();
         */
                new ByteArrayInputStream("foo.bar.baz.0: 1\nfoo.bar.baz.1: 2".getBytes(StandardCharsets.UTF_8)),
        assertThat(actual, equalTo(expected));
    }
            assertTrue(k, k.startsWith("b") || k.startsWith("c"));
        assertEquals("ab2", prefixMap.get("b.c"));
        Settings settings = Settings.builder()
            .loadFromSource("value: 1", XContentType.YAML)
        assertNull(filteredSettings.get("a.b"));
                false
        final Setting<TimeValue> setting = Setting.timeSetting(
        }
        test = Settings.builder().putList("foo.bar", "1", "2", "3").build();
import java.io.IOException;
         * Effectively this test is then asserting that we no longer make this mistake when doing the internal string conversion. Instead,
        assertEquals("test", build.get("rootfoo"));
package org.opensearch.common.settings;
import static org.hamcrest.Matchers.is;
        builder.put("a.c", "ac1");
        final TimeValue expected = TimeValue.timeValueMillis(randomNonNegativeLong());
        assertNull(thirdLevelSetting.get("1.2.3"));
        // overriding a deeper structure with an array
        /*
        final String hostname = randomAlphaOfLength(16);
/*
        MockSecureSettings secureSettings = new MockSecureSettings();
 *     http://www.apache.org/licenses/LICENSE-2.0
        Settings fooSettings = settings.getAsSettings("foo");
        final ByteSizeValue actual = setting.get(settings);
        assertThat(secondLevelSetting.get("3.4"), equalTo("abc"));
            .build();
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("{\"foo\":{\"bar.baz\":\"test\",\"bar\":[\"1\",\"2\",\"3\"]}}", builder.toString());
        // check array
        assertThat(settings.getAsList("value"), contains("4", "5"));
        builder.put("a.b.c.d", "ab3");
            .put(Settings.builder().putList("value", "1", "2", "3").build())
            IllegalStateException.class,
        assertThat(settings.get("foo.bar"), equalTo("baz"));
            assertThat(settings.getAsList("hosts"), hasSize(2));
import org.opensearch.OpenSearchParseException;
        builder.startObject();
            .build();
        assertThat(settings.get("foo.bar"), equalTo("baz"));
 * GitHub history for details.
        settings = Settings.builder()
        Settings settings = builder.build();
        Settings.Builder builder = Settings.builder();
        assertThat(settings.get("foo.test"), equalTo("test"));
 *
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> {
            .put("rootfoo", "test")
    public void testPrefixNormalizationArchived() {
        Settings filteredSettings = builder.build().filter((k) -> false);
    public void testReplacePropertiesPlaceholderByEnvironmentVariables() {
        assertFalse(secondLevelSetting.isEmpty());
        builder.endObject();
        assertThat(settings.getAsList("test1.test3").get(0), equalTo("test3-1"));
        );
/*
        assertThat(settings.get("bar"), nullValue());
        expectThrows(NoSuchElementException.class, () -> iterator.next());
        Settings build = Settings.readSettingsFromStream(in);
        assertThat(secondLevelSetting.get("3"), equalTo("hello world"));
        builder.startObject();
        Settings secondLevelSetting = firstLevelSettings.getByPrefix("2.");
            "key",
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> {
         * we convert to a string using a method that does not lose the original unit.
        final String hostip = randomAlphaOfLength(16);
        assertEquals(3, numKeys);
            e.getMessage().contains("null-valued setting found for key [foo] found at line number [1], column number [5]")
         * 1.5s could not be converted back to a TimeValue because TimeValues do not support fractional components. Effectively this test
        final String hostname = randomAlphaOfLength(16);
        secureSettings.setString("test.key2.bog", "somethingsecure");
        assertThat(fooSettings.get("bar"), equalTo("def"));
        assertTrue(filteredSettings.keySet().contains("a.b.c.d"));
        settings = Settings.builder()
        Settings.writeSettingsToStream(builder.build(), out);
        assertThat(settings.getAsList("value"), contains("3"));
        builder.put("a.b", "ab1");
        Settings.Builder builder = Settings.builder();
                .replacePropertyPlaceholders(name -> name.equals("HOSTNAMES") ? "[\"h1\", \"h2\"]" : null)
        Map<String, Settings> groups = settings.getGroups("test");
        assertTrue(prefixSettings.names().contains("foo"));
            .build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertTrue(
            .put(Settings.builder().putList("value", "1", "2", "3").putList("a", "b", "c").build())
        builder.setSecureSettings(secureSettings);
        settings = Settings.builder()
            .build();
        assertThat(settings.getAsList("test1.test3").size(), equalTo(2));
        builder.put("a.c", "ac1");
                .loadFromStream("foo.yml", in, false)
        Settings settings = Settings.builder()
            .put("setting1", "${property.placeholder}")
        assertEquals(2, firstLevelSettings.size());
        }
        }
            assertTrue(iterator.hasNext());
        );
         * using a method that does not lose the original unit.
        assertEquals(0, test.size());
        Settings build = Settings.fromXContent(parser);
        final Setting<ByteSizeValue> setting = Setting.byteSizeSetting(
        assertEquals("baz", Settings.builder().copy("foo.bar.baz", settings).build().get("foo.bar.baz"));
import org.opensearch.core.common.settings.SecureString;
            .put("foo.foobar", 2)
            .replacePropertyPlaceholders(name -> name.equals("HOSTNAMES") ? "[]" : null)
            assertFalse(iterator.hasNext());
        final Setting<TimeValue> setting = Setting.timeSetting(
            .put("foo", "abc")
        assertThat(settings.get("bar"), nullValue());
import java.util.Set;
        assertEquals("blah1", settings.get("test.key1.baz"));
        builder.putNull("test.key3.bar");
            .put("1.2.3", "hello world")
        settings = Settings.builder()
            .put("1.2.3.4", "abc")
        int numKeys = 0;
        );
    }
            .build();
        assertTrue(names.contains("bar"));
        builder.endObject();
            Settings.builder().loadFromStream(yaml, getClass().getResourceAsStream(yaml), false);
        assertFalse(thirdLevelSetting.isEmpty());
        assertNull(settings.get("test1.test3.1"));
        builder.put("test.key1.other", "blah2");
    }
        StreamInput in = StreamInput.wrap(BytesReference.toBytes(output.bytes()));
        assertThat(settings.getAsList("value"), contains("4", "5"));
        assertThat(settings.get("setting1"), equalTo("[]"));
        Set<String> names = settings.names();
        Settings thirdLevelSetting = secondLevelSetting.getByPrefix("3.");
        Settings.writeSettingsToStream(settings, output);
        // overriding an array with a longer array
        Settings settings = Settings.builder()
            .put(Settings.builder().putList("value.deep.key", "4", "5").build())
         * 1000ms would be converted to 1s). However, this had a problem in that, for example, 1500ms would be converted to 1.5s. Then,
        builder.endObject();
            .put(Settings.builder().putList("value", "4", "5").putList("d", "e", "f").build())
        settings = Settings.builder().put("bar", "baz").put("foo.test", "test").normalizePrefix("foo.").build();
import static org.hamcrest.Matchers.notNullValue;
        assertThat(key1.names(), containsInAnyOrder("foo", "bar", "baz", "other"));
                .build();
            .build();
        final Settings settings = Settings.builder().put("key", expected).build();
        assertThat(settings.getAsList("setting1"), empty());
        Settings.Builder builder = Settings.builder();
        assertThat(settings.size(), equalTo(1));
            .put("setting1", "${HOSTNAMES}")
        Settings settings = Settings.builder()
        Settings prefixMap = builder.build().getByPrefix("a.");
        XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
import static org.hamcrest.Matchers.hasSize;
    }
 * ownership. Elasticsearch licenses this file to you under
        Files.write(tmp, Collections.singletonList("foo: # missing value\n"), StandardCharsets.UTF_8);
import static org.hamcrest.Matchers.containsString;
 * SPDX-License-Identifier: Apache-2.0
        Settings settings = Settings.builder().put("bar", "baz").put("foo", "abc").put("foo.bar", "def").put("foo.baz", "ghi").build();
        MockSecureSettings secureSettings = new MockSecureSettings();
        assertTrue(Settings.builder().setSecureSettings(secureSettings).build().isEmpty());
        builder.setSecureSettings(secureSettings);
        assertTrue(e.getMessage(), e.getMessage().contains("malformed"));
        assertThat(settings.get("value.data"), is("1"));
        assertFalse(prefixIterator.hasNext());
        builder.put("a.b.c", "ab2");
    public void testGetAsSettings() {
            .build();
        assertThat(settings.getAsList("foo.bar.baz").get(0), equalTo("1"));
        }
        assertThat(settings.get("foo.archived.foo.*"), nullValue());
        XContentBuilder builder = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent());
        assertThat(settings.getAsList("value.deep.key"), contains("4", "5"));
        assertNull(secondLevelSetting.get("2.3.4"));
        Iterator<String> prefixIterator = prefixMap.keySet().iterator();
        assertEquals("a.b.c.d", iterator.next());
        final Settings settings = Settings.builder().put("key", expected).build();
import org.opensearch.Version;
        test = Settings.builder().put("ant", "value1").put("ant.bee.cat", "value2").put("ant.bee.cat.dog.ewe", "value3").build();
        assertNull(thirdLevelSetting.get("3.4"));
    public void testNames() {
        );
        assertThat(settings.getAsList("value"), contains("4", "5"));
import org.opensearch.core.common.bytes.BytesReference;
        if (randomBoolean()) {
        Settings settings = Settings.builder().normalizePrefix("foo.").build();
        assertEquals(3, settings.size());
        assertEquals("b.c.d", prefixIterator.next());
            .put(Settings.builder().putList("value.deep.key", "1", "2", "3").putList("a", "b", "c").build())
    }
    }
        assertThat(settings.size(), equalTo(2));
        assertFalse(filteredSettings.keySet().contains("a.c"));
        final Settings settings = Settings.builder().put("key", expected.getMicros(), TimeUnit.MICROSECONDS).build();
            .put(Settings.builder().putList("value", "1", "2").build())
        assertFalse(filteredSettings.keySet().contains("a.c"));
        settings = Settings.builder()
        assertNull(secondLevelSetting.get("1.2.3"));
        // test that other arrays are not overridden
            assertThat(settings.getAsList("hosts"), containsInAnyOrder("h1", "h2"));
        assertThat(firstLevelSettings.get("2.3.4"), equalTo("abc"));
            assertTrue(k.startsWith("a.b"));
    }
        StreamInput in = StreamInput.wrap(out.bytes().toBytesRef().bytes);
            .put(Settings.builder().putList("value.deep.key", "4", "5").putList("d", "e", "f").build())
    public void testReplacePropertiesPlaceholderSystemVariablesHaveNoEffect() {
                "foo.yml",
        assertThat(key2.names(), containsInAnyOrder("foo", "bog", "baz", "else"));
            .put(Settings.builder().putList("value", "2", "3").build())
        secureSettings.setString("test.key2.foo", "somethingsecure");
        assertThat(settings.get("setting1"), equalTo(value));
            .put(Settings.builder().putList("value.deep.key", "4", "5").build())
        assertEquals("a.b", iterator.next());
 */
        assertEquals(1, thirdLevelSetting.size());
        assertThat(settings.get("test1.value1"), equalTo("value1"));
        Settings test = Settings.builder().putList("foo.bar", "1", "2", "3").put("foo.bar.baz", "test").build();
         * (e.g., 1024 bytes would be converted to 1kb). However, this had a problem in that, for example, 1536 bytes would be converted to
import static org.hamcrest.Matchers.nullValue;
        XContentParser parser = createParser(builder);
        assertThat(settings.names().size(), equalTo(0));
import static org.hamcrest.Matchers.hasToString;
 * You may obtain a copy of the License at
    public void testSetByTimeUnit() {
        assertEquals(Arrays.asList("1", "2"), settings.getAsList("test.key4.foo"));
            .loadFromStream(randomFrom("test.json", "test.yml"), new ByteArrayInputStream(new byte[0]), false)
        assertTrue(e.getMessage().contains("does not match the allowed setting name pattern"));
        assertNull(settings.get("test1.test3.1"));
        assertFalse(value.isEmpty());
        assertTrue(prefixMap.keySet().contains("c"));
import java.util.Iterator;
import static org.hamcrest.Matchers.equalTo;
        assertTrue(e.getMessage(), e.getMessage().contains("malformed"));
    }
            .putList("foo.bar.baz", "1", "2", "3")
 * under the License.
        assertEquals(2, build.size());
        output.setVersion(randomFrom(Version.CURRENT, Version.V_2_0_0));
        secureSettings.setString("test.key2.foo", "somethingsecure");
        Settings fooSettings = settings.getAsSettings("foo");
        assertThat(settings.getAsList("test1.test3").size(), equalTo(2));
            .build();
 * this work for additional information regarding copyright
        builder.startObject();
        assertTrue(prefixMap.keySet().contains("b.c"));
            .put(Settings.builder().putList("value", "4", "5").build())
        assertEquals("1,2,3,4", build.get("foo.baz"));
            )
        assertEquals("{\"ant.bee\":{\"cat\":\"value2\"},\"ant\":\"value1\",\"bee\":{\"cat\":\"value3\"}}", builder.toString());
            .replacePropertyPlaceholders(name -> "HOSTNAME".equals(name) ? hostname : null)
        assertEquals("b", prefixIterator.next());
        builder.put("a", "a1");
        assertThat(settings.getAsList("value.deep.key"), contains("4", "5"));
        final Settings settings = Settings.builder()
        assertThat(settings.size(), equalTo(1));
        for (int i = 0; i < 10; i++) {
    }
            .build();
        assertThat(settings.getAsInt("test1.test2.value3", -1), equalTo(2));
            .build();
    public void testCopy() {
import org.opensearch.core.common.unit.ByteSizeUnit;
        builder.put("a.b", "ab1");
        int numKeys = 0;
            "key",
        final IllegalStateException e = expectThrows(
 */
        assertTrue(settings.keySet().contains("test.key3.bar"));
        }
import java.util.Collections;
        assertEquals(Arrays.asList("0", "1", "2", "3"), Settings.builder().copy("foo.bar", settings).build().getAsList("foo.bar"));
         * Previously we would internally convert the time value to a string using a method that tries to be smart about the units (e.g.,
        String value = System.getProperty("java.home");
        Settings settings = Settings.builder()
            assertTrue(prefixIterator.hasNext());
        e = expectThrows(IllegalArgumentException.class, () -> SecureSetting.secureFile("*IllegalName", null));
        assertThat(e, hasToString(containsString("settings builder can't contain values for [foobar=foo] and [foobar.0=bar]")));
    public void testProcessSetting() throws IOException {
            .loadFromSource("value: [ 2, 3 ]", XContentType.YAML)
        }
            .build();
import org.opensearch.core.xcontent.ToXContent;
        assertEquals("{\"foo\":{\"bar\":[\"1\",\"2\",\"3\"]}}", builder.toString());
 * software distributed under the License is distributed on an
        }
        assertEquals("ab3", prefixMap.get("b.c.d"));
        assertThat(settings.getAsList("value.with.deep.key"), contains("2", "3"));
        assertThat(settings.getAsList("value.deep.key"), contains("4", "5"));
        assertTrue(names.contains("foo"));
import java.nio.charset.StandardCharsets;
        builder = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent());
        assertEquals("ab1", filteredSettings.get("a.b"));
    }
    }
         * 1500 microseconds would be converted to 1ms). Effectively this test is then asserting that we no longer make this mistake when
        builder.endObject();
import java.nio.file.Path;
        for (String k : prefixMap.keySet()) {
    public void testPrefixMap() {
        assertFalse(filteredSettings.keySet().contains("a"));
            () -> Settings.builder().put("foobar.0", "bar").put("foobar.1", "baz").put("foobar", "foo").build()
 */
            .build();
        Settings.Builder builder = Settings.builder();
        assertEquals("c", prefixIterator.next());
 *
         */
        builder.startObject();
        assertThat(implicitEnvSettings.get("setting1"), equalTo(hostname));
        final Settings settings = Settings.builder().loadFromStream(json, getClass().getResourceAsStream(json), false).build();
        assertThat(settings.getAsList("value"), contains("2", "3"));
        }
        builder.put("test.key2.baz", "blah3");
        builder = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent());
        builder.startObject();
    }
            .put(Settings.builder().putList("value", "4", "5").build())
import org.opensearch.core.xcontent.XContentBuilder;
    }
        builder.setSecureSettings(secureSettings);
            .put(Settings.builder().putList("value.with.deep.key", "2", "3").build())
import java.io.ByteArrayInputStream;
        assertEquals("a.b.c", iterator.next());
        if (randomBoolean()) {
            .put(Settings.builder().putList("value.deep.key", "1", "2", "3").build())
            .build();
        settings = Settings.builder()
            .put("foo.baz", "ghi")
        Settings.Builder builder = Settings.builder();
        Settings key1 = groups.get("key1");
            TimeValue.ZERO
            .put(Settings.builder().putList("value", "1").build())
        /*
        assertNotNull(key2);
        assertTrue(e.getMessage().contains("must be stored inside the OpenSearch keystore"));
        assertThat(settings.get("foo.archived.foo.bar"), nullValue());
        settings = Settings.builder()
        assertEquals(build.get("foo.bar.baz"), "baz");
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.common.unit.ByteSizeValue;
            .build();
        BytesStreamOutput output = new BytesStreamOutput();
 * this file be licensed under the Apache-2.0 license or a
            .put(Settings.builder().put("value", "1").build())
        assertThat(settings.getAsList("value"), contains("3"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertThat(settings.getAsList("value"), contains("2", "3"));
    }
        test.toXContent(builder, new ToXContent.MapParams(Collections.emptyMap()));
            .loadFromStream(
        expectThrows(UnsupportedOperationException.class, () -> filteredSettings.keySet().remove("a.b"));
        settings = Settings.builder()
        test.toXContent(builder, new ToXContent.MapParams(Collections.emptyMap()));
    }
            .put("2.3.4", "def")
 * not use this file except in compliance with the License.
        assertFalse(firstLevelSettings.isEmpty());
        assertEquals(7, builder.build().size());
            .put(Settings.builder().put("value.data", "1").build())
        // check array
    public void testPrefixNormalization() {
        assertThat(settings.getAsList("d"), contains("e", "f"));
        assertThat(settings.getAsList("test1.test4"), empty());
 * compatible open source license.
    }
    }
        final String yaml = "/org/opensearch/common/settings/loader/test-settings.yml";
        // overriding an array with a single value
        assertThat(settings.getAsList("value"), contains("3", "4", "5"));
            .putNull("foo.null.baz")
    }
        secureSettings.setString("test.key2.bog", "somethingsecure");
        secureSettings.setString("test.key1.bar", "somethingsecure");
        names = fooSettings.names();
        assertThat(actual, equalTo(expected));
            .put(Settings.builder().putList("value", "1", "2").build())
    public void testReplacePropertiesPlaceholderSystemProperty() {
import java.util.Arrays;
            .build();
            assertTrue(iterator.hasNext());
        secureSettings.setString("test.key1.foo", "somethingsecure");
        assertThat(settings.getAsList("value.deep.key"), contains("3"));
        /*
public class SettingsTests extends OpenSearchTestCase {
        Settings settings = Settings.readSettingsFromStream(in);
            .put(Settings.builder().putList("value", "3", "4", "5").build())
        assertTrue(prefixMap.keySet().contains("b.c.d"));
        settings = Settings.builder().put("foo.test", "test").normalizePrefix("foo.").build();
        builder.put("a.b.c.d", "ab3");
        try (InputStream in = new ByteArrayInputStream("hosts: ${HOSTNAMES}".getBytes(StandardCharsets.UTF_8))) {
            numKeys++;
         */
            assertTrue(prefixIterator.hasNext());
    }
            .build();
        builder.put("a", "a1");
        assertEquals("ab1", prefixMap.get("b"));
        for (String k : filteredSettings.keySet()) {
    }
        assertEquals(2, fooSettings.size());
        expectThrows(UnsupportedOperationException.class, () -> filteredSettings.keySet().remove("a.b"));
        Iterator<String> iterator = filteredSettings.keySet().iterator();
import org.opensearch.core.xcontent.XContentParser;
        for (int i = 0; i < 10; i++) {
        assertThat(settings.getAsList("test1.test3").get(0), equalTo("test3-1"));
    public void testIndentationWithExplicitDocumentStart() throws Exception {
            .put(Settings.builder().putList("value.deep.key", "1", "2").build())
    }
    public void testEmptyFilterMap() {
        assertTrue(prefixMap.keySet().contains("b"));
    public void testReplacePropertiesPlaceholderSystemPropertyEmptyList() {
import java.util.concurrent.TimeUnit;
        builder = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent());
        assertNull(secondLevelSetting.get("1.2.3.4"));
            .build();
        Settings settings = Settings.builder()
        settings = Settings.builder()
    public void testToXContent() throws IOException {
    public void testLoadEmptyStream() throws IOException {
         * Previously we would internally convert the duration to a string by converting to milliseconds which could lose precision  (e.g.,
 * the Apache License, Version 2.0 (the "License"); you may
        test.toXContent(builder, new ToXContent.MapParams(Collections.emptyMap()));
    public void testSimpleYamlSettings() throws Exception {
        settings.toXContent(builder, new ToXContent.MapParams(Collections.singletonMap("flat_settings", "" + flatSettings)));
