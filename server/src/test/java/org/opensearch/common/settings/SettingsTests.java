        final Settings settings = Settings.builder().put("key", expected).build();  
        Settings.writeSettingsToStream(settings, output);
            numKeys++;
        final TimeValue actual = setting.get(settings);
            TimeValue.ZERO
    }  
import static org.hamcrest.Matchers.notNullValue;  
    public void testFractionalTimeValue() {
         * Previously we would internally convert the byte size value to a string using a method that tries to be smart about the units
        assertTrue(e.getMessage().contains("must be stored inside the OpenSearch keystore"));  
        assertEquals(Arrays.asList("0", "1", "2", "3"), Settings.builder().copy("foo.bar", settings).build().getAsList("foo.bar"));  
    public void testSecureSettingsPrefix() {
import org.opensearch.core.common.settings.SecureString;
        assertThat(settings.getAsList("value"), contains("2", "3"));
        assertThat(settings.get("archived.foo.*"), equalTo("baz"));
import org.opensearch.core.common.unit.ByteSizeValue;
            .build();  
 * under the License.  
        secureSettings.setString("test.key1.bar", "somethingsecure");  
        assertThat(settings.get("bar"), nullValue());
        String yaml = "/org/opensearch/common/settings/loader/indentation-settings.yml";  
            .put("bar", "hello world")
        settings = Settings.builder()  
        names = fooSettings.names();
import static org.hamcrest.Matchers.is;
        BytesStreamOutput output = new BytesStreamOutput();
        builder.put("a.c", "ac1");
        assertThat(settings.get("test1.value1"), equalTo("value1"));
import java.util.Arrays;
        /*
        assertEquals(2, secondLevelSetting.size());
        assertThat(settings.size(), equalTo(1));  
import org.opensearch.common.unit.TimeValue;
        builder.put("a.b.c.d", "ab3");
        assertTrue(prefixSettings.names().contains("foo"));  
        assertFalse(iterator.hasNext());  
        assertThat(actual, equalTo(expected));  
    public void testPrefixMap() {
    }
        assertThat(e, hasToString(containsString("Could not resolve placeholder 'java.home'")));  
    public void testMultLevelGetPrefix() {  
        assertEquals(3, filteredSettings.size());
    public void testReplacePropertiesPlaceholderSystemPropertyEmptyList() {
        Settings settings = Settings.builder().putList("foo.bar", "0", "1", "2", "3").put("foo.bar.baz", "baz").build();
        );
import org.opensearch.common.io.stream.BytesStreamOutput;  
        output.setVersion(randomFrom(Version.CURRENT, Version.V_2_0_0));  
import java.io.InputStream;
        assertThat(secondLevelSetting.get("3.4"), equalTo("abc"));
    public void testIndentation() throws Exception {
        assertNull(thirdLevelSetting.get("2.3.4"));
         * (e.g., 1024 bytes would be converted to 1kb). However, this had a problem in that, for example, 1536 bytes would be converted to  
import org.opensearch.common.xcontent.XContentType;
        assertFalse(secondLevelSetting.isEmpty());  
        final Setting<TimeValue> setting = Setting.timeSetting(  
        final String hostname = randomAlphaOfLength(16);
import org.opensearch.core.xcontent.XContentParser;
            .loadFromSource("value: [ 2, 3 ]", XContentType.YAML)
            assertFalse(iterator.hasNext());
        Settings settings = Settings.builder()
        assertTrue(names.contains("bar"));
        settings = Settings.builder()
        final Settings settings = Settings.builder().loadFromStream(yaml, getClass().getResourceAsStream(yaml), false).build();
            .put("foo.foobar", 2)  
        builder.setSecureSettings(secureSettings);
        assertTrue(prefixMap.keySet().contains("c"));  
    }
            .put("rootfoo", "test")
        if (randomBoolean()) {
            .put(Settings.builder().put("value.data", "1").build())
    public void testReplacePropertiesPlaceholderSystemVariablesHaveNoEffect() {
        assertThat(settings.getAsList("value"), contains("2", "3"));
        expectThrows(UnsupportedOperationException.class, () -> filteredSettings.keySet().remove("a.b"));  
    }
import org.opensearch.OpenSearchParseException;
        test = Settings.builder().put("ant", "value1").put("ant.bee.cat", "value2").put("ant.bee.cat.dog.ewe", "value3").build();
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> setting.get(settings));
        builder.putList("test.key4.foo", "1", "2");
import java.io.IOException;  
        assertEquals(build.get("foo.bar.baz"), "baz");
        Settings settings = Settings.builder()
        assertFalse(value.isEmpty());
        assertThat(settings.getAsList("d"), contains("e", "f"));
        // check array
        Settings settings = Settings.builder()
        assertThat(settings.getAsList("test1.test3").size(), equalTo(2));
        assertThat(actual, equalTo(expected));
            .replacePropertyPlaceholders()
        builder.put("a", "a1");
        builder.setSecureSettings(secureSettings);  
        assertEquals("ab3", prefixMap.get("b.c.d"));
        }
    public void testProcessSetting() throws IOException {
        final Settings settings = Settings.builder()  
 * ownership. Elasticsearch licenses this file to you under  
    public void testSimpleYamlSettings() throws Exception {  
        settings = Settings.builder().put("archived.foo.*", "baz").normalizePrefix("foo.").build();
        assertThat(settings.get("foo.bar"), equalTo("baz"));  
        settings = Settings.builder()  
        assertTrue(
        assertEquals(2, firstLevelSettings.size());
public class SettingsTests extends OpenSearchTestCase {  
        assertFalse(filteredSettings.keySet().contains("a"));
         * Previously we would internally convert the time value to a string using a method that tries to be smart about the units (e.g.,
            .loadFromStream(  
        assertTrue(e.getMessage(), e.getMessage().contains("malformed"));
    }  
        assertEquals(2, build.size());
        XContentParser parser = createParser(builder);
            .put(Settings.builder().putList("value.deep.key", "1", "2", "3").build())
    public void testReplacePropertiesPlaceholderSystemPropertyList() {
 * KIND, either express or implied.  See the License for the
        assertThat(settings.getAsList("setting1"), contains(hostname, hostip));
    }
        builder.startObject();
            .build();
        builder.endObject();  
        assertTrue(names.contains("foo"));
        assertThat(fooSettings.get("baz"), equalTo("ghi"));  
            .loadFromSource("value: 1", XContentType.YAML)
    }  
        // overriding an array with a single value
        settings = Settings.builder()
        secureSettings.setString("test.key1.foo", "somethingsecure");  
        settings = Settings.builder()  
 * specific language governing permissions and limitations
        assertEquals(4, numKeys);  
        for (String k : prefixMap.keySet()) {
        Settings settings = Settings.readSettingsFromStream(in);  
            .put(Settings.builder().putList("value.deep.key", "4", "5").build())
        builder = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent());
            .build();
        }  
        assertTrue(names.contains("bar"));
        builder.endObject();  
            .put("3.4", "ghi")
            .build();  
 * Licensed to Elasticsearch under one or more contributor  
        if (randomBoolean()) {
        assertNull(filteredSettings.get("a.b"));
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(settings.get("test1.test2.value2"), equalTo("value2"));
            assertTrue(k, k.startsWith("b") || k.startsWith("c"));  
            .put(Settings.builder().putList("value", "1", "2").build())
    }
        for (int i = 0; i < 10; i++) {  
    }
            .put("2.3.4", "def")
        assertEquals(1, thirdLevelSetting.size());
        final IllegalStateException e = expectThrows(
        assertEquals(build.getAsList("foo.bar"), Arrays.asList("0", "1", "2", "3"));  
    public void testGetAsSettings() {  
        assertThat(implicitEnvSettings.get("setting1"), equalTo(hostname));  
        assertThat(settings.getAsInt("test1.test2.value3", -1), equalTo(2));  
    }  
        final Settings settings = Settings.builder().put("key", expected).build();  
         * using a method that does not lose the original unit.  
        assertThat(settings.get("bar"), nullValue());
    public void testWriteSettingsToStream() throws IOException {  
         */
        assertThat(settings.get("value.data"), is("1"));
        builder = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent());
import static org.hamcrest.Matchers.hasSize;  
        assertEquals("ab3", filteredSettings.get("a.b.c.d"));  
        assertTrue(Settings.EMPTY.isEmpty());
 * You may obtain a copy of the License at  
        assertEquals("1,2,3,4", build.get("foo.baz"));
        builder.put("a.c", "ac1");
            .put("setting1", "${property.placeholder}")
/*
import static org.hamcrest.Matchers.equalTo;
        Iterator<String> iterator = filteredSettings.keySet().iterator();
            .put(Settings.builder().putList("value.deep.key", "1", "2", "3").putList("a", "b", "c").build())
        assertEquals(2, fooSettings.size());
            )
        assertThat(settings.getAsList("test1.test3").get(1), equalTo("test3-2"));
        assertThat(settings.get("value"), is("[4, 5]"));  
            assertTrue(iterator.hasNext());
            .put("setting1", "${HOSTNAMES}")
            assertTrue(prefixIterator.hasNext());
        assertNull(settings.get("test1.test3.1"));  
            .put(Settings.builder().put("value.data", "1").build())  
 * this file be licensed under the Apache-2.0 license or a
        final ByteSizeValue expected = new ByteSizeValue(randomNonNegativeLong(), ByteSizeUnit.BYTES);
            .put(Settings.builder().put("value", "1").build())
            .replacePropertyPlaceholders(name -> name.equals("HOSTNAME") ? hostname : name.equals("HOSTIP") ? hostip : null)  
        for (String k : filteredSettings.keySet()) {
            .put(Settings.builder().putList("value", "1", "2").build())  
            .build();  
                .replacePropertyPlaceholders(name -> name.equals("HOSTNAMES") ? "[\"h1\", \"h2\"]" : null)  
        assertEquals("a.b.c.d", iterator.next());
 */  
        Settings settings = Settings.builder()
        final Settings settings = Settings.builder().loadFromStream(json, getClass().getResourceAsStream(json), false).build();
        assertEquals("a.b.c", iterator.next());
        assertEquals("source key not found in the source settings", iae.getMessage());
        Settings build = Settings.fromXContent(parser);
    public void testThatArraysAreOverriddenCorrectly() throws IOException {
            .build();
        if (randomBoolean()) {
 *
        assertThat(settings.getAsList("value.deep.key"), contains("4", "5"));
        });
            .build();  
        assertTrue(names.contains("baz"));
        settings = Settings.builder()
        String yaml = "/org/opensearch/common/settings/loader/indentation-with-explicit-document-start-settings.yml";
        assertTrue(Settings.builder().setSecureSettings(secureSettings).build().isEmpty());  
        builder.put("test.key1.baz", "blah1");
        assertEquals(Arrays.asList("1", "2", "3"), build.getAsList("foo.bar.baz"));
         * 1500 microseconds would be converted to 1ms). Effectively this test is then asserting that we no longer make this mistake when
        settings = Settings.builder()
            .put(Settings.builder().putList("value.deep.key", "1", "2").build())
        settings = Settings.builder()
        test.toXContent(builder, new ToXContent.MapParams(Collections.emptyMap()));
        assertThat(settings.getAsList("a"), notNullValue());
        Files.write(tmp, Collections.singletonList("foo: # missing value\n"), StandardCharsets.UTF_8);
            .build();
            e.getMessage().contains("null-valued setting found for key [foo] found at line number [1], column number [5]")  
        assertThat(settings.getAsList("value"), contains("4", "5"));
        builder.put("test.key1.baz", "blah1");
            .put(Settings.builder().putList("value", "4", "5").build())  
        assertThat(settings.getAsInt("test1.test2.value3", -1), equalTo(2));
         * 1.5s could not be converted back to a TimeValue because TimeValues do not support fractional components. Effectively this test
    public void testReadWriteArray() throws IOException {
        assertThat(settings.get("foo.test"), equalTo("test"));
            Settings.builder().loadFromStream(yaml, getClass().getResourceAsStream(yaml), false);
        secureSettings.setString("test.key2.foo", "somethingsecure");
}  
        // overriding a single value with an array  
        assertThat(settings.getAsList("value"), contains("4", "5"));
/*  
            .put("foo.bar", "def")
        assertTrue(e.getMessage(), e.getMessage().contains("malformed"));  
            .put("foo.baz", "ghi")
        Settings key2 = groups.get("key2");  
    public void testSecureSettingIllegalName() {  
            ByteSizeValue.parseBytesSizeValue(randomIntBetween(1, 16) + "k", "key")  
    public void testYamlPlaceholder() throws IOException {
        final Settings settings = Settings.builder().put("key", expected.getMicros(), TimeUnit.MICROSECONDS).build();
        assertThat(key2.names(), containsInAnyOrder("foo", "bog", "baz", "else"));
        test = Settings.builder().putList("foo.bar", "1", "2", "3").build();  
            Settings settings = Settings.builder()
        final boolean flatSettings = randomBoolean();
        assertEquals("{\"ant.bee\":{\"cat.dog\":{\"ewe\":\"value3\"},\"cat\":\"value2\"},\"ant\":\"value1\"}", builder.toString());  
         * Previously we would internally convert the duration to a string by converting to milliseconds which could lose precision  (e.g.,  
import java.io.ByteArrayInputStream;
        Settings settings = Settings.builder()
         * 1.5k. Then, 1.5k could not be converted back to a ByteSizeValue because ByteSizeValues do not support fractional components.
        builder.put("test.key1.other", "blah2");
    }
        assertFalse(filteredSettings.keySet().contains("a.b.c.d"));
        assertThat(fooSettings.get("bar"), equalTo("def"));
        assertThat(settings.getAsList("a"), contains("b", "c"));  
        assertThat(settings.size(), equalTo(1));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.nio.file.Files;  
        }
        assertNull(settings.get("test1.test3.0"));  
        final ByteSizeValue actual = setting.get(settings);
        StreamInput in = StreamInput.wrap(BytesReference.toBytes(output.bytes()));  
        assertThat(settings.getAsList("foo.bar.baz").get(1), equalTo("2"));
        final TimeValue expected = new TimeValue(1500, TimeUnit.MICROSECONDS);  
        assertThat(actual, equalTo(expected));  
        assertNull(build.get("foo.null.baz"));
import static org.hamcrest.Matchers.nullValue;
import java.nio.charset.StandardCharsets;
        settings = Settings.builder().put("bar", "baz").normalizePrefix("foo.").build();
        assertEquals("a.b", iterator.next());  
        for (int i = 0; i < 10; i++) {  
        test.toXContent(builder, new ToXContent.MapParams(Collections.emptyMap()));  
    }  
            assertTrue(prefixIterator.hasNext());  
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> {
        for (int i = 0; i < 10; i++) {  
        assertEquals("b.c.d", prefixIterator.next());
            TimeValue.ZERO  
    }
        expectThrows(NoSuchElementException.class, () -> prefixIterator.next());
 *
        final String yaml = "/org/opensearch/common/settings/loader/test-settings.yml";
            .putList("setting1", "${HOSTNAME}", "${HOSTIP}")
        Setting<SecureString> setting = SecureSetting.secureString("something.secure", null);  
        builder.startObject();
        test.toXContent(builder, new ToXContent.MapParams(Collections.emptyMap()));
        builder.setSecureSettings(secureSettings);
    }
         * doing the internal string conversion. Instead, we convert to a duration using a method that does not lose the original unit.
    public void testToAndFromXContent() throws IOException {  
        assertThat(settings.getAsList("setting1"), empty());
        }
import static org.hamcrest.Matchers.hasToString;
        expectThrows(NoSuchElementException.class, () -> iterator.next());
         */
            IllegalArgumentException.class,  
            .put("property.placeholder", value)  
        Settings settings = builder.build();  
        Settings build = Settings.readSettingsFromStream(in);
import java.util.Iterator;
import static org.hamcrest.Matchers.containsInAnyOrder;
        Settings.Builder builder = Settings.builder();  
 * not use this file except in compliance with the License.
            Settings.builder().loadFromStream(yaml, getClass().getResourceAsStream(yaml), false);
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> Settings.builder().copy("not_there", settings));
            .replacePropertyPlaceholders(name -> "HOSTNAME".equals(name) ? hostname : null)
            "key",
        final Setting<ByteSizeValue> setting = Setting.byteSizeSetting(
    }
        expectThrows(UnsupportedOperationException.class, () -> filteredSettings.keySet().remove("a.b"));  
    }
        final TimeValue expected = TimeValue.timeValueMillis(randomNonNegativeLong());
    }  
            .put(Settings.builder().putList("value", "1").build())
            .put(Settings.builder().putList("value", "1", "2", "3").putList("a", "b", "c").build())
        assertFalse(prefixIterator.hasNext());
        MockSecureSettings secureSettings = new MockSecureSettings();
        assertThat(names.size(), equalTo(2));  
import java.util.Collections;  
        assertTrue(settings.keySet().contains("test.key3.bar"));
 * Modifications Copyright OpenSearch Contributors. See
        }
        Settings key1 = groups.get("key1");  
            e.getMessage(),
        assertThat(settings.get("foo.archived.foo.bar"), nullValue());
        assertThat(settings.get("test1.value1"), equalTo("value1"));  
    }  
            numKeys++;
        assertEquals("b", prefixIterator.next());  
    public void testIndentationWithExplicitDocumentStart() throws Exception {
    }
        Iterator<String> iterator = filteredSettings.keySet().iterator();
        Settings.writeSettingsToStream(builder.build(), out);
        assertFalse(filteredSettings.keySet().contains("a"));
        }
        builder.put("a", "a1");
package org.opensearch.common.settings;
        assertEquals(4, prefixMap.size());
        Settings settings = Settings.builder().putList("foo.bar", "0", "1", "2", "3").put("foo.bar.baz", "baz").putNull("test").build();
        // this is just terrible but it's the existing behavior!
        Settings test = Settings.builder()  
        XContentBuilder builder = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent());
        assertThat(settings.getAsList("value"), contains("4", "5"));
        assertThat(settings.getAsList("test1.test3").get(0), equalTo("test3-1"));
            TimeValue.parseTimeValue(randomTimeValue(0, 24, "h"), "key"),  
        assertThat(secondLevelSetting.get("3"), equalTo("hello world"));  
        assertNull(filteredSettings.get("a.b.c"));
        assertThat(key1.names(), containsInAnyOrder("foo", "bar", "baz", "other"));
        Settings settings = Settings.builder().put("something.secure", "notreallysecure").build();
        // test that other arrays are not overridden  
    }  
        assertThat(settings.get("test1.test2.value2"), equalTo("value2"));
        // overriding an array with a longer array
        e = expectThrows(IllegalArgumentException.class, () -> SecureSetting.secureFile("*IllegalName", null));  
            .put(Settings.builder().putList("value.deep.key", "4", "5").putList("d", "e", "f").build())
                .loadFromStream("foo.yml", in, false)
        Settings firstLevelSettings = settings.getByPrefix("1.");
import static org.hamcrest.Matchers.containsString;  
        Map<String, Settings> groups = settings.getGroups("test");
        builder.put("test.key2.baz", "blah3");  
            .build();
        assertThat(settings.get("setting1"), equalTo("[]"));
        Iterator<String> prefixIterator = prefixMap.keySet().iterator();
        settings = Settings.builder().put("foo.test", "test").normalizePrefix("foo.").build();  
        /*
        assertThat(e, hasToString(containsString("settings builder can't contain values for [foobar=foo] and [foobar.0=bar]")));  
        assertTrue(prefixMap.keySet().contains("b"));
        assertNull(settings.get("test1.test3.0"));
            assertTrue(iterator.hasNext());
                false  
        assertEquals("{\"ant.bee\":{\"cat\":\"value2\"},\"ant\":\"value1\",\"bee\":{\"cat\":\"value3\"}}", builder.toString());
        assertThat(settings.size(), equalTo(2));
        assertThat(settings.getAsList("value"), contains("3"));
        Settings settings = Settings.builder()
        assertThat(settings.getAsList("test1.test3").get(1), equalTo("test3-2"));  
        final String hostname = randomAlphaOfLength(16);
    public void testNames() {
        Set<String> names = settings.names();
    public void testFilteredMap() {
            .put(Settings.builder().put("value.with.deep.key", "1").build())
            .build();
            .put(Settings.builder().putList("value", "1", "2").build())
        assertNull(secondLevelSetting.get("2.3.4"));
            .put(Settings.builder().put("value", "3").build())
        assertThat(settings.get("foo.archived.foo.*"), nullValue());
        assertThat(settings.get("setting1"), equalTo(value));
        assertTrue(e.getMessage().contains("does not match the allowed setting name pattern"));
            .put("foo.baz", "1,2,3,4")
        assertFalse(prefixMap.keySet().contains("a"));
        MockSecureSettings secureSettings = new MockSecureSettings();
        final IllegalArgumentException e = expectThrows(
        builder.endObject();
        Settings settings = Settings.builder().put("bar", "baz").put("foo", "abc").put("foo.bar", "def").put("foo.baz", "ghi").build();  
import org.opensearch.Version;
        builder.put("a.b.c.d", "ab3");
    public void testFractionalByteSizeValue() {  
    }
            .putList("foo.bar.baz", "1", "2", "3")
        assertNull(Settings.builder().copy("foo.bar.baz", settings).build().get("test"));
        builder.endObject();
        settings = Settings.builder()  
            assertThat(settings.getAsList("hosts"), hasSize(2));
        Settings test = Settings.builder().putList("foo.bar", "1", "2", "3").put("foo.bar.baz", "test").build();
    }
    public void testSecureSettingConflict() {
        Settings test = Settings.builder().put("ant", "value1").put("ant.bee.cat", "value2").put("bee.cat", "value3").build();  
        }  
 * compatible open source license.
        assertEquals(7, builder.build().size());  
        builder.put("test.key2.else", "blah4");
        XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();  
        assertEquals("{\"foo\":{\"bar\":[\"1\",\"2\",\"3\"]}}", builder.toString());
        assertThat(settings.getAsList("value.deep.key"), contains("4", "5"));
        int numKeys = 0;  
        secureSettings.setString("test.key2.bog", "somethingsecure");  
        assertThat(settings.getAsList("test1.test3").get(0), equalTo("test3-1"));  
        assertNull(secondLevelSetting.get("1.2.3.4"));  
        builder.startObject();  
        Settings.Builder builder = Settings.builder();  
        );
    public void testReplacePropertiesPlaceholderByEnvironmentVariables() {  
            .build();
        assertTrue(filteredSettings.keySet().contains("a.b"));  
        }
            .build();  
            .put(Settings.builder().putList("value", "3").build())  
        assertEquals("b.c", prefixIterator.next());
            .build();
            assertTrue(iterator.hasNext());  
        assertThat(settings.getAsList("value"), contains("3"));
            .build();
            assertTrue(prefixIterator.hasNext());
        assertNull(settings.get("test.key3.bar"));  
            .put(Settings.builder().putList("value", "4", "5").build())
        assertThat(settings.get("foo.bar"), equalTo("baz"));  
    }  
        builder.put("a.b.c", "ab2");  
            .put(Settings.builder().putList("value.deep.key", "4", "5").build())  
 * license agreements. See the NOTICE file distributed with
        settings.toXContent(builder, new ToXContent.MapParams(Collections.singletonMap("flat_settings", "" + flatSettings)));
         * Effectively this test is then asserting that we no longer make this mistake when doing the internal string conversion. Instead,
/*  
            .put(Settings.builder().putList("value.deep.key", "1", "2", "3").build())  
    }  
import org.opensearch.test.OpenSearchTestCase;  
    }
 * software distributed under the License is distributed on an
        builder.endObject();
            .put("1.2.3", "hello world")
        assertThat(thirdLevelSetting.get("4"), equalTo("abc"));
        if (randomBoolean()) {
        assertThat(settings.size(), equalTo(1));
 * GitHub history for details.
            assertTrue(k.startsWith("a.b"));  
    public void testEmptyFilterMap() {
        assertEquals("ab1", prefixMap.get("b"));
    }
        assertEquals(0, filteredSettings.size());
            .build();
    }  
        assertThat(settings.getAsList("value"), contains("3", "4", "5"));  
        assertThat(settings.getAsList("value"), contains("2", "3"));
        settings = Settings.builder()  
            IllegalStateException.class,  
    }  
            .loadFromStream(randomFrom("test.json", "test.yml"), new ByteArrayInputStream(new byte[0]), false)
                .build();
 */
        assertTrue(filteredSettings.keySet().contains("a.b.c.d"));
            .putNull("foo.null.baz")  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> SecureSetting.secureString("*IllegalName", null));
        assertEquals("{\"foo.bar\":[\"1\",\"2\",\"3\"]}", builder.toString());
            .put(Settings.builder().putList("value", "1", "2", "3").build())
 *     http://www.apache.org/licenses/LICENSE-2.0
        settings = Settings.builder()
         * we convert to a string using a method that does not lose the original unit.  
        MockSecureSettings secureSettings = new MockSecureSettings();  
    }
        assertEquals("baz", Settings.builder().copy("foo.bar.baz", settings).build().get("foo.bar.baz"));
import static org.hamcrest.Matchers.contains;
        final Settings implicitEnvSettings = Settings.builder()
        assertThat(settings.get("foo.test"), equalTo("test"));  
            .put(Settings.builder().putList("value", "2", "3").build())  
        assertNull(thirdLevelSetting.get("3.4"));  
            .put(Settings.builder().putList("value", "2", "3").build())  
        MockSecureSettings secureSettings = new MockSecureSettings();
            .build();  
        assertThat(settings.getAsList("foo.bar.baz").get(0), equalTo("1"));
 * the Apache License, Version 2.0 (the "License"); you may
    public void testMissingValue() throws Exception {  
            "key",
        assertEquals(2, groups.size());
        Settings secondLevelSetting = firstLevelSettings.getByPrefix("2.");
        assertThat(settings.names().size(), equalTo(0));  
        builder.putNull("test.key3.bar");  
        );
        Settings fooSettings = settings.getAsSettings("foo");
        });  
        }
        try (InputStream in = new ByteArrayInputStream("hosts: ${HOSTNAMES}".getBytes(StandardCharsets.UTF_8))) {  
         * 1000ms would be converted to 1s). However, this had a problem in that, for example, 1500ms would be converted to 1.5s. Then,  
import java.util.NoSuchElementException;  
        assertEquals(3, numKeys);  
        assertNotNull(key2);
        assertEquals(2, build.getAsInt("foo.foobar", 0).intValue());
        );
    }
        Settings settings = Settings.builder().put("archived.foo.bar", "baz").normalizePrefix("foo.").build();
import java.util.concurrent.TimeUnit;
        }
        assertEquals("c", prefixIterator.next());  
        settings = Settings.builder()
        final Settings settings = Settings.builder()
            .put(Settings.builder().put("value.deep.key", "3").build())
        assertEquals(0, test.size());  
import java.util.Map;
import org.opensearch.core.xcontent.ToXContent;  
    public void testYamlLegacyList() throws IOException {
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> {  
        assertNull(secondLevelSetting.get("1.2.3"));
        assertEquals("blah1", settings.get("test.key1.baz"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertThat(settings.get("archived.foo.bar"), equalTo("baz"));
        builder = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent());
        if (randomBoolean()) {  
 */  
        Settings.Builder builder = Settings.builder();
    }
        }
        assertFalse(firstLevelSettings.isEmpty());  
        // check array
        builder.put("a.b.c", "ab2");  
        final TimeValue actual = setting.get(settings);
        String value = System.getProperty("java.home");  
        settings = Settings.builder()
        assertFalse(filteredSettings.keySet().contains("a.b"));  
        assertFalse(filteredSettings.keySet().contains("a.c"));
        assertNull(settings.get("test1.test3.1"));
    public void testGetAsArrayFailsOnDuplicates() {
        Settings settings = builder.build();
        );
            .build();
import org.opensearch.core.common.bytes.BytesReference;  
            .build();  
    public void testSetByTimeUnit() {  
        assertFalse(filteredSettings.keySet().contains("a.c"));
 *  
        builder.put("a", "a1");
    public void testToXContent() throws IOException {  
            assertThat(settings.getAsList("hosts"), containsInAnyOrder("h1", "h2"));  
        builder.startObject();
        assertEquals("ab2", filteredSettings.get("a.b.c"));
        assertEquals(Arrays.asList("1", "2"), settings.getAsList("test.key4.foo"));
        assertThat(names.size(), equalTo(2));  
    }  
        builder.startObject();
        // overriding a deeper structure with an array
        assertNotNull(key1);
import org.opensearch.core.common.io.stream.StreamInput;
        Settings settings = Settings.builder().normalizePrefix("foo.").build();
            TimeValue.parseTimeValue(randomTimeValue(0, 24, "h"), "key"),
        secureSettings.setString("test.key2.foo", "somethingsecure");
        secureSettings.setString("test.prefix.foo", "somethingsecure");
        assertFalse(thirdLevelSetting.isEmpty());  
        builder.startObject();
        assertThat(settings.getAsList("value.with.deep.key"), contains("2", "3"));
    }
        assertThat(settings.getAsList("value.deep.key"), contains("3"));
 * SPDX-License-Identifier: Apache-2.0
        Settings.Builder builder = Settings.builder();  
 * this work for additional information regarding copyright
import java.util.Set;
            () -> Settings.builder().put("foobar.0", "bar").put("foobar.1", "baz").put("foobar", "foo").build()
    public void testCopy() {
        Settings prefixSettings = settings.getByPrefix("test.prefix.");
    public void testReplacePropertiesPlaceholderSystemProperty() {
            .build();
        assertThat(settings.getAsList("foo.bar.baz").size(), equalTo(2));  
        XContentBuilder builder = XContentBuilder.builder(MediaTypeRegistry.JSON.xContent());  
    public void testSimpleJsonSettings() throws Exception {
        assertThat(firstLevelSettings.get("2.3.4"), equalTo("abc"));
    }
        builder.put("a.b", "ab1");
            "key",
                "foo.yml",
        builder.put("a.b.c", "ab2");  
        StreamInput in = StreamInput.wrap(out.bytes().toBytesRef().bytes);
        // overriding an array with a shorter array  
        Settings.Builder builder = Settings.builder();  
        assertEquals(3, settings.size());
        assertThat(settings.getAsList("d"), notNullValue());  
         */  
        final Setting<TimeValue> setting = Setting.timeSetting(
        assertNull(thirdLevelSetting.get("1.2.3"));
 * The OpenSearch Contributors require contributions made to  
        Settings.Builder builder = Settings.builder();
    }  
    }  
            () -> Settings.builder().put("setting1", "${java.home}").replacePropertyPlaceholders().build()
            .put("foo", "abc")  
        // overriding an array with a deeper structure  
import java.nio.file.Path;
            .put(Settings.builder().putList("value", "4", "5").putList("d", "e", "f").build())  
        assertTrue(Settings.builder().copy("test", settings).build().keySet().contains("test"));  
        /*
        builder.put("a.b.c.d", "ab3");
        secureSettings.setString("test.key1.foo", "somethingsecure");
        test.toXContent(builder, new ToXContent.MapParams(Collections.singletonMap("flat_settings", "true")));  
            .put(Settings.builder().putList("value", "3", "4", "5").build())
            .put("setting1", "${HOSTNAME}")  
            .put("1.2.3.4", "abc")  
            .replacePropertyPlaceholders(name -> name.equals("HOSTNAMES") ? "[]" : null)
        Settings fooSettings = settings.getAsSettings("foo");
        final String value = System.getProperty("java.home");  
        assertEquals("{\"foo\":{\"bar.baz\":\"test\",\"bar\":[\"1\",\"2\",\"3\"]}}", builder.toString());
        assertTrue(prefixMap.keySet().contains("b.c"));
        assertEquals("test", build.get("rootfoo"));  
        assertTrue(filteredSettings.keySet().contains("a.b.c"));
        Settings filteredSettings = builder.build().filter((k) -> false);
        assertNotNull(value);
        expectThrows(NoSuchElementException.class, () -> iterator.next());  
        assertNull(filteredSettings.get("a.b.c.d"));  
        builder.put("a.b", "ab1");
        assertEquals("ab2", prefixMap.get("b.c"));  
        Settings prefixMap = builder.build().getByPrefix("a.");
        final String hostip = randomAlphaOfLength(16);  
        final String json = "/org/opensearch/common/settings/loader/test-settings.json";  
            .put(Settings.builder().putList("value", "4", "5").build())
        int numKeys = 0;  
        assertThat(settings.getAsList("value.deep.key"), contains("4", "5"));  
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> { Settings.builder().loadFromPath(tmp); });  
        builder.put("a.c", "ac1");
        builder.endObject();
import org.opensearch.core.xcontent.XContentBuilder;
    public void testPrefixNormalization() {  
            .put(Settings.builder().putList("value.with.deep.key", "2", "3").build())
        assertTrue(e.getMessage().contains("does not match the allowed setting name pattern"));
        Settings thirdLevelSetting = secondLevelSetting.getByPrefix("3.");
            .build();
        );
        Path tmp = createTempFile("test", ".yaml");
            .build();  
    public void testPrefixNormalizationArchived() {  
         * is then asserting that we no longer make this mistake when doing the internal string conversion. Instead, we convert to a string
        assertTrue(prefixMap.keySet().contains("b.c.d"));  
        assertThat(settings.getAsList("test1.test4"), empty());
                new ByteArrayInputStream("foo.bar.baz.0: 1\nfoo.bar.baz.1: 2".getBytes(StandardCharsets.UTF_8)),
import static org.hamcrest.Matchers.empty;
            assertTrue(prefixIterator.hasNext());
    public void testEmpty() {  
        settings = Settings.builder()  
        builder.put("a.b", "ab1");
        assertThat(settings.getAsList("test1.test3").size(), equalTo(2));
        expectThrows(UnsupportedOperationException.class, () -> prefixMap.keySet().remove("a.b"));
        secureSettings.setString("test.key2.bog", "somethingsecure");
    public void testGroupPrefix() {  
        test.toXContent(builder, new ToXContent.MapParams(Collections.emptyMap()));  
import org.opensearch.core.common.unit.ByteSizeUnit;  
    public void testLoadEmptyStream() throws IOException {
 * Unless required by applicable law or agreed to in writing,
            .build();
        secureSettings.setString("test.key1.bar", "somethingsecure");
        assertFalse(fooSettings.isEmpty());  
        assertEquals("ab1", filteredSettings.get("a.b"));
        Settings filteredSettings = builder.build().filter((k) -> k.startsWith("a.b"));
        settings = Settings.builder().put("bar", "baz").put("foo.test", "test").normalizePrefix("foo.").build();
        assertFalse(filteredSettings.keySet().contains("a.b.c"));
        assertThat(firstLevelSettings.get("2.3"), equalTo("hello world"));  
            .build();  
        assertThat(settings.size(), equalTo(1));  
    }
            .build();  
        assertEquals(5, build.size());  
