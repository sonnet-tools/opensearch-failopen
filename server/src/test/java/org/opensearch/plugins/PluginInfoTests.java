            "1.8",
/*
import static org.hamcrest.Matchers.contains;
 *    http://www.apache.org/licenses/LICENSE-2.0
            "java.version",
        assertEquals("my_plugin", info.getName());
        PluginInfo info = new PluginInfo(
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
            "{opensearch:\"" + opensearchRange + "\" }",
            "opensearch.version",
        Path pluginDir = createTempDir().resolve("fake-plugin");
            "name",
            "FakePlugin",
            "version",
    public void testToXContent() throws Exception {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
            Version.CURRENT.toString(),
import org.opensearch.tools.jackson.core.JsonParseException;
            "1.0",
            "dependencies",
            pluginDir,
            "classname",
import org.opensearch.test.OpenSearchTestCase;
            "extended.plugins",
            "FakePlugin"
public class PluginInfoTests extends OpenSearchTestCase {
            "name",
        assertEquals("1.0", info.getVersion());
        );
        List<String> names = infos.stream().map(PluginInfo::getName).collect(Collectors.toList());
import java.util.Collections;
            System.getProperty("java.specification.version"),
            "1.0",
            pluginDir,
            "1.0",
        assertEquals(Version.CURRENT.toString(), info.getOpenSearchVersionRanges().get(0).toString());
        PluginInfo info = PluginInfo.readFromProperties(pluginDir);
        );
        e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
            "1.0",
    }
        Path pluginDir = createTempDir().resolve("fake-plugin");
            "version",
            "extended.plugins",
            pluginDir,
            "description",
        PluginTestUtil.writePluginProperties(
        assertThat(info.getExtendedPlugins(), empty());
            "{opensearch:\"~" + Version.CURRENT.toString() + "\", dependency2:\"1.0.0\"}",
import java.nio.file.Path;
            "FakePlugin"
            "description",
        assertThat(e.getMessage(), containsString("property [name] is missing in"));
        PluginTestUtil.writePluginProperties(pluginDir, "description", "fake desc", "name", "fake-plugin");
import static org.hamcrest.Matchers.containsString;
            "property",
            "{opensearch:\"\"}",
        );
        PluginTestUtil.writePluginProperties(
            "fake",
            "FakePlugin"
            "version",
            "version",
        PluginTestUtil.writePluginProperties(
        PluginTestUtil.writePluginProperties(
            "FakePlugin"
            ""
            "dependencies",
            "opensearch.version",
            "opensearch.version",
            "FakePlugin",
            "1.0",
            Version.CURRENT.toString(),
import org.opensearch.core.xcontent.XContentBuilder;
            "{opensearch:\"1.2\"}",
            "classname",
            "dependencies",
        );
            "version",
        assertEquals("fake desc", info.getDescription());
            "description",
            "name",
        );
        Path pluginDir = createTempDir().resolve("fake-plugin");
            "1.0"
            "fake desc",
        PluginInfo info = PluginInfo.readFromProperties(pluginDir);
            "description",
        assertEquals("FakePlugin", info.getClassname());
        PluginTestUtil.writePluginProperties(pluginDir);
            Version.CURRENT.toString(),
            "version",
            "version",
            false
        );
 * specific language governing permissions and limitations
        assertThat(info.getExtendedPlugins(), empty());
 */
        Path pluginDir = createTempDir().resolve("fake-plugin");
 * GitHub history for details.
            "my_plugin",
import org.opensearch.common.xcontent.json.JsonXContent;
            pluginDir,
            "1.7.0_80",
    }
            "fake desc",
            "1.0",
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
            "name",
    public void testInvalidDependenciesProperty() throws Exception {
        PluginTestUtil.writePluginProperties(
        assertThat(
import org.opensearch.common.io.stream.BytesStreamOutput;
        Path pluginDir = createTempDir().resolve("fake-plugin");
        String prettyPrint = info.toXContent(builder, ToXContent.EMPTY_PARAMS).toString();
            "java.version",
    public void testEmptyDependenciesProperty() throws Exception {
            "fake desc",
            "name",
        PluginInfo info2 = new PluginInfo(input);
            "dependencies",
            "fake desc",
        Path pluginDir = createTempDir().resolve("fake-plugin");
        PluginTestUtil.writePluginProperties(pluginDir, "name", "fake-plugin");
            pluginName,
            "FakePlugin",
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
        plugins.add(new PluginInfo("b", "foo", "dummy", Version.CURRENT, "1.8", "dummyclass", Collections.emptyList(), randomBoolean()));
    }
            "version",
        Path pluginDir = createTempDir().resolve("fake-plugin");
        assertEquals("custom-folder", info.getTargetFolderName());
    }
            Version.CURRENT.toString(),
            "name",
            "1.0",
        );
    public void testhMultipleOpenSearchRangesInConstructor() throws Exception {
            "name",
        IllegalArgumentException e = expectThrows(
        PluginTestUtil.writePluginProperties(
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;
            pluginDir,
            "description",
    public void testReadFromPropertiesWithFolderNameAndVersionAfter() throws Exception {
        String pluginName = "fake-plugin";
            "1.0",
            "description",
            "description",
    }
            "java.version",
            pluginDir,
        PluginTestUtil.writePluginProperties(
            IllegalArgumentException.class,
        assertTrue(prettyPrint.contains("\"classname\" : \"dummyClass\""));
            "FakePlugin"
            "FakePlugin"
            "classname",
        ByteBufferStreamInput input = new ByteBufferStreamInput(buffer);
        assertThat(e.getMessage(), containsString("[java.version] is missing"));
            "dummy",
            "description",
            Collections.singletonList("foo"),
            "c",
            "fake desc",
        PluginTestUtil.writePluginProperties(
            "1.0",
            "fake desc",
    public void testReadFromPropertiesNameMissing() throws Exception {
        );
        assertEquals("1.0", info.getVersion());
            "java.version",
            "foo",
            "fake desc",
            "bogus"
            "version",
        PluginTestUtil.writePluginProperties(
            "1.0",
            pluginDir,
        assertThat(names, contains("a", "b", "c", "d", "e"));
    public void testReadFromPropertiesOpenSearchVersionAndDependenciesMissing() throws Exception {
            "description",
            "classname",
        assertEquals("fake desc", info.getDescription());
        assertEquals("my_plugin", info.getName());
            "name",
        );
            "dummy",
import static org.hamcrest.Matchers.equalTo;
            "1.0",
    public void testReadFromPropertiesJvmMissingClassname() throws Exception {
    }
 * Unless required by applicable law or agreed to in writing,
        assertThat(e.getMessage(), containsString("[description] is missing"));
        assertThat(e.getMessage(), containsString("Only opensearch is allowed to be specified as a plugin dependency"));
        PluginTestUtil.writePluginProperties(
            System.getProperty("java.specification.version"),
            "1.0",
            pluginDir,
            "description",
        PluginTestUtil.writePluginProperties(
            "my_plugin",
            "java.version",
            "1.0"
                "dummyclass",
            "FakePlugin",
        ByteBuffer buffer = ByteBuffer.wrap(output.bytes().toBytesRef().bytes);
            System.getProperty("java.specification.version"),
            System.getProperty("java.specification.version"),
            "version",
            "my_plugin",
            "unknown",
            Version.CURRENT,
        );
package org.opensearch.plugins;
            containsString("Either [opensearch.version] or [dependencies] property must be specified for the plugin ")
            () -> new PluginInfo(
        );
            "property",
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
            "version",
    public void testInvalidRangeInDependencies() throws Exception {
            Collections.emptyList(),
        assertEquals(Version.CURRENT.toString(), info.getOpenSearchVersionRanges().get(0).toString());
            pluginDir,
            "version",
 * compatible open source license.
            "{opensearch:" + Version.CURRENT.toString() + "}",
        Path pluginDir = createTempDir().resolve("fake-plugin");
            "opensearch.version",
            "FakePlugin"
    public void testExtendedPluginsEmpty() throws Exception {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
        );
            e.getMessage(),
            "dependencies",
import static org.hamcrest.Matchers.empty;
        Path pluginDir = createTempDir().resolve("fake-plugin");
            "{invalid}",
            "description",
            "{opensearch:\"~1.2.3, =1.2.3\"}",
            "description",
                "foo",
            "foo,bar,baz"
            "description",
            "dependencies",
            System.getProperty("java.specification.version"),
            "dummyclass",
    }
            "java.version",
                randomBoolean()
        PluginInfo info = PluginInfo.readFromProperties(pluginDir);
    public void testExtendedPluginsSingleOptionalExtension() throws IOException {
            System.getProperty("java.specification.version"),
            "extended.plugins",
 *
        Path pluginDir = createTempDir().resolve("fake-plugin");
import org.opensearch.semver.SemverRange;
        assertEquals("~" + Version.CURRENT.toString(), info.getOpenSearchVersionRanges().get(0).toString());
    public void testSerialize() throws Exception {
    }
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;
        PluginInfo info = PluginInfo.readFromProperties(pluginDir);
        PluginTestUtil.writePluginProperties(
            "java.version",
            "name",
            "classname",
        PluginTestUtil.writePluginProperties(
        );
    public void testReadFromProperties() throws Exception {
    public void testReadFromPropertiesVersionMissing() throws Exception {
import java.util.stream.Collectors;
            "opensearch.version",
            "java.version",
        Path pluginDir = createTempDir().resolve("fake-plugin");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
            "my_plugin",
            "java.version",
    public void testEmptyOpenSearchVersionInDependencies() throws Exception {
        assertThat(e.getMessage(), containsString("property [name] is missing in"));
 * under the License.
 * You may obtain a copy of the License at
            "version",
        assertThat(e.getMessage(), containsString("version needs to contain major, minor, and revision"));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
        assertThat(e.getMessage(), containsString("Exactly one range is allowed to be specified in dependencies for the plugin"));
            pluginDir,
            Version.CURRENT.toString(),
            "{some_dependency:\"~" + Version.CURRENT.toString() + "\"}",
                    + " by \".\"'s and may have leading zeros but was 1.7.0_80"
        Path pluginDir = createTempDir().resolve("fake-plugin");
            Version.CURRENT.toString(),
            "fake desc",
            System.getProperty("java.specification.version"),
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
            "classname",
        plugins.add(new PluginInfo("c", "foo", "dummy", Version.CURRENT, "1.8", "dummyclass", Collections.emptyList(), randomBoolean()));
        assertThat(info.getExtendedPlugins(), empty());
            System.getProperty("java.specification.version"),
            "my_plugin",
            "version",
                ),
    }
            e.getMessage(),
            System.getProperty("java.specification.version"),
            "description",
        assertTrue(prettyPrint.contains("\"has_native_controller\" : false"));
            "1.0",
            "java.version",
            System.getProperty("java.specification.version"),
            "my_plugin",
    public void testReadFromPropertiesDescriptionMissing() throws Exception {
            "Foo",
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> PluginInfo.readFromProperties(pluginDir));
 * the Apache License, Version 2.0 (the "License"); you may
        Path pluginDir = createTempDir().resolve("fake-plugin");
            "extended.plugins",
            "version",
            "my_plugin",
    public void testReadFromPropertiesWithDependenciesAndOpenSearchVersion() throws Exception {
            "my_plugin",
            "my_plugin",
            "fake desc",
            "my_plugin",
    }
        PluginTestUtil.writePluginProperties(
        expectThrows(JsonParseException.class, () -> PluginInfo.readFromProperties(pluginDir));
        assertThat(e.getMessage(), containsString("Unknown properties in plugin descriptor"));
        plugins.add(new PluginInfo("e", "foo", "dummy", Version.CURRENT, "1.8", "dummyclass", Collections.emptyList(), randomBoolean()));
            "version",
        assertTrue(prettyPrint.contains("\"description\" : \"foo\""));
            "classname",
        PluginTestUtil.writePluginProperties(
            )
            "java.version",
 * SPDX-License-Identifier: Apache-2.0
        );
    public void testNonOpenSearchDependency() throws Exception {
    public void testMultipleDependencies() throws Exception {
            "classname",
            "name",
                "1.8",
            pluginDir,
            System.getProperty("java.specification.version")
            "FakePlugin"
            "classname",
            containsString("Only one of [opensearch.version] or [dependencies] property can be specified for the plugin")
        assertTrue(prettyPrint.contains("\"version\" : \"dummy\""));
        expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
            "description",
            System.getProperty("java.specification.version"),
    }
    }
            "dependencies",
        Path pluginDir = createTempDir().resolve("fake-plugin");
    }
            "name",
            "opensearch.version",
}
            "fake desc",
            "dependencies",
        assertEquals("1.0", info.getVersion());
            "version",
            "opensearch.version",
            "opensearch.version",
        assertThat(info.getExtendedPlugins(), contains("foo"));
            "name",
 * The OpenSearch Contributors require contributions made to
            "java.version",
            "c",
    public void testExtendedPluginsSingleExtension() throws Exception {
        );
            "fake desc",
            Version.CURRENT.toString(),
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
            "classname",
        assertThat(e.getMessage(), containsString("Exactly one range is allowed to be specified in dependencies for the plugin"));
            pluginDir,
        Path pluginDir = createTempDir().resolve("fake-plugin");
            "java.version",
            "description",
            "my_plugin",
            "java.version",
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
            "classname",
    }
            "my_plugin",
        assertThat(info.isExtendedPluginOptional("foo"), is(false));
    }
            "classname",
        Path pluginDir = createTempDir().resolve("fake-plugin");
            "java.version",
    }
    public void testRangeSemverOnDependencies() throws Exception {
    public void testReadFromPropertiesBogusOpenSearchVersion() throws Exception {
        );
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
        assertTrue(prettyPrint.contains("\"java_version\" : \"1.8\""));
        PluginTestUtil.writePluginProperties(
            pluginDir,
            "FakePlugin"
            System.getProperty("java.specification.version"),
            System.getProperty("java.specification.version"),
            "opensearch.version",
            "1.0",
            "opensearch.version",
        assertTrue(prettyPrint.contains("\"extended_plugins\" : [ ]"));
        Path pluginDir = createTempDir().resolve("fake-plugin");
            System.getProperty("java.specification.version")
        Path pluginDir = createTempDir().resolve("fake-plugin");
            "fake desc",
        assertThat(
            Version.CURRENT,
            "FakePlugin"
            "classname",
import static org.hamcrest.Matchers.is;
                "dummy",
            "dependencies",
        Path pluginDir = createTempDir().resolve("fake-plugin");
        assertThat(e.getMessage(), containsString("Exactly one dependency is allowed to be specified in plugin descriptor properties"));
        );
            "description",
    }
            "1.0",
            "FakePlugin",
import java.io.IOException;
            "name",
            "version",
            "java.version",
            "my_plugin",
        PluginInfo info = new PluginInfo(
import java.util.List;
    }
        assertThat(e.getMessage(), containsString("Version cannot be empty"));
        );
        PluginTestUtil.writePluginProperties(
        String opensearchRange = "[" + Version.V_2_0_0.toString() + "," + Version.V_3_0_0.toString() + ")";
    }
            "1.0",
    }
        assertThat(e.getMessage(), containsString("property [classname] is missing"));
            "fake desc",
            "dependencies",
        assertEquals("FakePlugin", info.getClassname());
            "my_plugin",
                "plugin_name",
            "foo"
            "name",
            "custom-folder"
 * license agreements. See the NOTICE file distributed with
        assertEquals("FakePlugin", info.getClassname());
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
        assertTrue(prettyPrint.contains("\"name\" : \"fake\""));
            "name",
            "custom.foldername",
            "1.0",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.nio.ByteBuffer;
        assertTrue(prettyPrint.contains("\"custom_foldername\" : \"folder\""));
            "1.0",
        );
            "fake desc",
            "1.8",
            Version.CURRENT.toString(),
            "foo;optional=true"
    }
            "java.version",
    public void testReadFromPropertiesWithSingleOpenSearchRange() throws Exception {
            Version.CURRENT.toString(),
        PluginsAndModules pluginsInfo = new PluginsAndModules(plugins, Collections.emptyList());
 * not use this file except in compliance with the License.
            "fake desc",
        );
        Path pluginDir = createTempDir().resolve("fake-plugin");
            "description",
        Path pluginDir = createTempDir().resolve(pluginName);
        PluginTestUtil.writePluginProperties(pluginDir, "description", "fake desc", "name", "my_plugin", "version", "1.0");
    public void testUnknownProperties() throws Exception {
        BytesStreamOutput output = new BytesStreamOutput();
        assertThat(info2.toString(), equalTo(info.toString()));
            pluginDir,
            "description",
        Path pluginDir = createTempDir().resolve("fake-plugin");
            "my_plugin",
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
        );
            "fake desc",
    public void testInvalidOpenSearchVersionInDependencies() throws Exception {
    }
    }
        assertThat(info.getExtendedPlugins(), contains("foo", "bar", "baz"));
            "my_plugin",
            "java.version",
            "java.version",
            "name",
        assertThat(e.getMessage(), containsString("Exactly one dependency is allowed to be specified in plugin descriptor properties"));
            "{opensearch:\"<2.2.0\"}",
            "version",
        assertTrue(prettyPrint.contains("\"opensearch_version\" : \"" + Version.CURRENT));
            "my_plugin",
            "my_plugin",
            "{opensearch:\"~" + Version.CURRENT.toString() + "\"}",
            pluginDir,
        );
        info.writeTo(output);
            System.getProperty("java.specification.version"),
            "name",
            pluginDir,
        PluginTestUtil.writePluginProperties(
        );
            "my_plugin",
            "FakePlugin"
            "version",
        );
            "name",
        PluginTestUtil.writePluginProperties(
            System.getProperty("java.specification.version"),
            Version.CURRENT.toString(),
            "name",
        Path pluginDir = createTempDir().resolve("fake-plugin");
    }
        assertThat(info.getExtendedPlugins(), empty());
        PluginTestUtil.writePluginProperties(pluginDir, "name", "");
            "my_plugin",
            System.getProperty("java.specification.version"),
        );
        plugins.add(new PluginInfo("a", "foo", "dummy", Version.CURRENT, "1.8", "dummyclass", Collections.emptyList(), randomBoolean()));
            pluginDir,
                    new SemverRange(Version.CURRENT, SemverRange.RangeOperator.DEFAULT)
    }
        Path pluginDir = createTempDir().resolve("fake-plugin");
        Path pluginDir = createTempDir().resolve("fake-plugin");
        PluginTestUtil.writePluginProperties(
 * ownership. Elasticsearch licenses this file to you under
        assertEquals("my_plugin", info.getName());
    public void testReadFromPropertiesBadJavaVersionFormat() throws Exception {
            "foo",
                "version string must be a sequence of nonnegative decimal integers separated"
            pluginDir,
            "version",
            e.getMessage(),
    public void testExtendedPluginsMultipleExtensions() throws Exception {
    public void testReadFromPropertiesJavaVersionMissing() throws Exception {
 *
            )
    }
    }
            "opensearch.version",
 * Licensed to Elasticsearch under one or more contributor
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
        );
        );
/*
            "description",
            "classname",
        assertThat(e.getMessage(), containsString("[version] is missing"));
import org.opensearch.Version;
            "description",
 */
            randomBoolean()
        assertThat(
        );
            pluginDir,
            "version",
            "my_plugin",
            "classname",
            "name",
            equalTo(
        PluginInfo info = PluginInfo.readFromProperties(pluginDir);
            containsString("the version needs to contain major, minor, and revision, and optionally the build: 1.2")
            "folder",
        assertThat(
        Path pluginDir = createTempDir().resolve("fake-plugin");
                Collections.emptyList(),
            "FakePlugin",
import org.opensearch.core.xcontent.ToXContent;
            pluginDir,
        List<PluginInfo> plugins = new ArrayList<>();
            "1.0",
/*
            "fake desc",
import org.opensearch.core.common.io.stream.ByteBufferStreamInput;
            "description",
        assertEquals("fake desc", info.getDescription());
        plugins.add(new PluginInfo("d", "foo", "dummy", Version.CURRENT, "1.8", "dummyclass", Collections.emptyList(), randomBoolean()));
    }
                    new SemverRange(Version.CURRENT, SemverRange.RangeOperator.EQ),
            "1.0",
        PluginInfo info = PluginInfo.readFromProperties(pluginDir);
        final List<PluginInfo> infos = pluginsInfo.getPluginInfos();
            "java.version",
            "classname",
            "fake desc",
        PluginInfo info = PluginInfo.readFromProperties(pluginDir);
        PluginTestUtil.writePluginProperties(
    }
            "classname",
            "classname",
            "opensearch.version",
            "fake desc",
            Version.CURRENT.toString(),
        assertEquals(SemverRange.fromString(opensearchRange).toString(), pluginInfo.getOpenSearchVersionRangesString());
    public void testhMultipleOpenSearchRangesInDependencies() throws Exception {
        PluginTestUtil.writePluginProperties(
                List.of(
            "name",
            "name",
            System.getProperty("java.specification.version"),
            "dependencies",
 * this work for additional information regarding copyright
        );
    public void testPluginListSorted() {
            "{}",
        assertThat(info.isExtendedPluginOptional("foo"), is(true));
            "extra",
                null,
 * KIND, either express or implied.  See the License for the
 */
            "fake desc",
            "FakePlugin"
            e.getMessage(),
    }
            pluginDir,
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
            "fake desc",
        PluginInfo pluginInfo = PluginInfo.readFromProperties(pluginDir);
 * Modifications Copyright OpenSearch Contributors. See
 *
            "classname",
        assertThat(info.getExtendedPlugins(), contains("foo"));
            pluginDir,
            "dummyClass",
            "fake desc",
 * software distributed under the License is distributed on an
