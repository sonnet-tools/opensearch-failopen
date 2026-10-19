            "FakePlugin"  
        String prettyPrint = info.toXContent(builder, ToXContent.EMPTY_PARAMS).toString();  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));  
            "foo,bar,baz"
            pluginDir,
            "java.version",
            "java.version",  
        PluginTestUtil.writePluginProperties(  
    public void testEmptyDependenciesProperty() throws Exception {
            "opensearch.version",
            "version",
            Version.CURRENT.toString(),  
            "version",
    }
        Path pluginDir = createTempDir().resolve("fake-plugin");
                ),  
            "version",
        Path pluginDir = createTempDir().resolve("fake-plugin");
            Version.CURRENT.toString(),
        PluginTestUtil.writePluginProperties(
            System.getProperty("java.specification.version"),
                "dummy",
    }  
        );
    }
        PluginInfo info = PluginInfo.readFromProperties(pluginDir);  
        List<String> names = infos.stream().map(PluginInfo::getName).collect(Collectors.toList());
            "{opensearch:" + Version.CURRENT.toString() + "}",
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
            "1.0",
            "extended.plugins",  
import java.util.ArrayList;  
        Path pluginDir = createTempDir().resolve("fake-plugin");  
            Version.CURRENT.toString(),
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));  
            "name",  
 * SPDX-License-Identifier: Apache-2.0
            "name",
import org.opensearch.test.OpenSearchTestCase;  
    public void testhMultipleOpenSearchRangesInConstructor() throws Exception {
            "my_plugin",
            "description",
        );
            Version.CURRENT.toString(),
            IllegalArgumentException.class,
        assertEquals("my_plugin", info.getName());
    public void testReadFromPropertiesWithDependenciesAndOpenSearchVersion() throws Exception {  
/*  
    }
    }  
            "1.7.0_80",
            "fake",
            "foo",  
}
        Path pluginDir = createTempDir().resolve("fake-plugin");  
            "fake desc",  
            "fake desc",  
        PluginTestUtil.writePluginProperties(
            "FakePlugin"  
        PluginTestUtil.writePluginProperties(  
            "opensearch.version",
        );
            "java.version",
        Path pluginDir = createTempDir().resolve("fake-plugin");
        );
        assertTrue(prettyPrint.contains("\"description\" : \"foo\""));
            "extended.plugins",
 * this work for additional information regarding copyright
 *
            "FakePlugin"  
            Version.CURRENT,
        Path pluginDir = createTempDir().resolve("fake-plugin");
public class PluginInfoTests extends OpenSearchTestCase {
            pluginName,  
            containsString("the version needs to contain major, minor, and revision, and optionally the build: 1.2")
        PluginTestUtil.writePluginProperties(
            "version",
            Version.CURRENT.toString(),  
            "classname",
            Version.CURRENT,
            "dummy",
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
    }
            "dependencies",
            "classname",  
            "1.0",
            "name",  
import org.opensearch.tools.jackson.core.JsonParseException;
        assertTrue(prettyPrint.contains("\"custom_foldername\" : \"folder\""));
            "{opensearch:\"~1.2.3, =1.2.3\"}",
            "1.8",
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
        Path pluginDir = createTempDir().resolve("fake-plugin");
        assertTrue(prettyPrint.contains("\"version\" : \"dummy\""));
            "java.version",  
            "java.version",  
        );
        PluginTestUtil.writePluginProperties(  
        plugins.add(new PluginInfo("e", "foo", "dummy", Version.CURRENT, "1.8", "dummyclass", Collections.emptyList(), randomBoolean()));
            System.getProperty("java.specification.version"),
        expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
                Collections.emptyList(),
            "FakePlugin"
            "dependencies",
            System.getProperty("java.specification.version"),
        Path pluginDir = createTempDir().resolve("fake-plugin");
import static org.hamcrest.Matchers.is;  
            pluginDir,
            "opensearch.version",
        PluginInfo info = PluginInfo.readFromProperties(pluginDir);  
            "opensearch.version",  
        assertThat(e.getMessage(), containsString("Version cannot be empty"));  
            "version",
    }  
            "java.version",
            "my_plugin",
    }
                "1.8",
    public void testExtendedPluginsSingleOptionalExtension() throws IOException {
            "classname",  
    }
            pluginDir,  
    }
        PluginInfo pluginInfo = PluginInfo.readFromProperties(pluginDir);  
            "version",
            "name",
            "{opensearch:\"~" + Version.CURRENT.toString() + "\", dependency2:\"1.0.0\"}",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            "description",
            "1.0",
    public void testReadFromProperties() throws Exception {
            "version",  
            "1.0",
            "version",
        PluginTestUtil.writePluginProperties(
        );  
        assertEquals("my_plugin", info.getName());
        assertEquals(Version.CURRENT.toString(), info.getOpenSearchVersionRanges().get(0).toString());  
        );
import java.nio.file.Path;
        assertThat(e.getMessage(), containsString("[java.version] is missing"));
        PluginTestUtil.writePluginProperties(pluginDir, "description", "fake desc", "name", "fake-plugin");  
            pluginDir,
    }
        final List<PluginInfo> infos = pluginsInfo.getPluginInfos();  
            pluginDir,
            "property",
    public void testToXContent() throws Exception {
        assertThat(e.getMessage(), containsString("[description] is missing"));
    public void testPluginListSorted() {  
            "classname",  
            "1.0",  
import org.opensearch.common.xcontent.json.JsonXContent;
            "java.version",
            "FakePlugin"
            "1.0"
            "FakePlugin"
            pluginDir,
/*
        plugins.add(new PluginInfo("d", "foo", "dummy", Version.CURRENT, "1.8", "dummyclass", Collections.emptyList(), randomBoolean()));  
        PluginTestUtil.writePluginProperties(pluginDir, "name", "");
            Version.CURRENT.toString(),  
            equalTo(
        assertEquals("FakePlugin", info.getClassname());
        PluginTestUtil.writePluginProperties(
        assertThat(e.getMessage(), containsString("Exactly one range is allowed to be specified in dependencies for the plugin"));
            "{invalid}",  
            "custom-folder"
            "FakePlugin"
            "description",  
    public void testExtendedPluginsSingleExtension() throws Exception {
            "opensearch.version",
            "classname",  
        assertThat(e.getMessage(), containsString("Unknown properties in plugin descriptor"));  
                    new SemverRange(Version.CURRENT, SemverRange.RangeOperator.DEFAULT)
            "my_plugin",
        );
        Path pluginDir = createTempDir().resolve("fake-plugin");
        PluginTestUtil.writePluginProperties(
        assertEquals("FakePlugin", info.getClassname());
    }
            false  
            "name",  
            System.getProperty("java.specification.version"),  
        Path pluginDir = createTempDir().resolve("fake-plugin");
import org.opensearch.Version;
            "my_plugin",  
            "java.version",
            "description",  
            Version.CURRENT.toString(),
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));  
            "FakePlugin",
            "version",
            e.getMessage(),  
    public void testSerialize() throws Exception {  
            "1.0",  
                "foo",
            "FakePlugin",
        assertThat(
        info.writeTo(output);
            System.getProperty("java.specification.version"),  
            "version",  
            "description",
            pluginDir,
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
            "version",
        plugins.add(new PluginInfo("a", "foo", "dummy", Version.CURRENT, "1.8", "dummyclass", Collections.emptyList(), randomBoolean()));
            "description",
        );
            "version",
            pluginDir,
            "1.0",
            "classname",  
            pluginDir,
        Path pluginDir = createTempDir().resolve("fake-plugin");
            "classname",
            "description",  
            Version.CURRENT.toString(),
        assertEquals(SemverRange.fromString(opensearchRange).toString(), pluginInfo.getOpenSearchVersionRangesString());
            "description",
            pluginDir,  
            "fake desc",  
        PluginTestUtil.writePluginProperties(  
            "{opensearch:\"" + opensearchRange + "\" }",  
            "FakePlugin",  
    public void testReadFromPropertiesWithSingleOpenSearchRange() throws Exception {  
    public void testInvalidOpenSearchVersionInDependencies() throws Exception {  
            e.getMessage(),  
            "my_plugin",  
import org.opensearch.core.xcontent.XContentBuilder;
 *
            "fake desc",
            "opensearch.version",  
            System.getProperty("java.specification.version"),
            "description",
            System.getProperty("java.specification.version"),
        PluginTestUtil.writePluginProperties(
            System.getProperty("java.specification.version"),  
        Path pluginDir = createTempDir().resolve("fake-plugin");
            "description",  
        );  
            "extended.plugins",  
        Path pluginDir = createTempDir().resolve("fake-plugin");
        assertTrue(prettyPrint.contains("\"name\" : \"fake\""));
            "name",
        PluginTestUtil.writePluginProperties(  
            "c",
import java.io.IOException;  
 * under the License.  
            "fake desc",
        assertThat(info.getExtendedPlugins(), empty());  
    public void testEmptyOpenSearchVersionInDependencies() throws Exception {  
            containsString("Only one of [opensearch.version] or [dependencies] property can be specified for the plugin")
            "my_plugin",
 * Unless required by applicable law or agreed to in writing,
            "dependencies",  
            "version",
            pluginDir,
            "fake desc",
        );
            "name",
            "classname",  
            "fake desc",
            "FakePlugin"
            "{some_dependency:\"~" + Version.CURRENT.toString() + "\"}",  
        assertEquals("1.0", info.getVersion());  
        assertThat(e.getMessage(), containsString("Exactly one dependency is allowed to be specified in plugin descriptor properties"));  
            "1.0",
        Path pluginDir = createTempDir().resolve("fake-plugin");
        assertEquals("fake desc", info.getDescription());
        assertTrue(prettyPrint.contains("\"java_version\" : \"1.8\""));
            "folder",
            "version",  
            "property",  
            "fake desc",
        assertThat(e.getMessage(), containsString("property [name] is missing in"));
        assertThat(e.getMessage(), containsString("Exactly one range is allowed to be specified in dependencies for the plugin"));
        PluginTestUtil.writePluginProperties(pluginDir);  
    public void testReadFromPropertiesBadJavaVersionFormat() throws Exception {
            "fake desc",
            "name",
    }  
 * GitHub history for details.
            "classname",
            "my_plugin",
            "FakePlugin",
            "version",  
        ByteBufferStreamInput input = new ByteBufferStreamInput(buffer);  
        );  
    public void testUnknownProperties() throws Exception {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
        );
 */  
            pluginDir,  
            "dummy",  
        assertThat(names, contains("a", "b", "c", "d", "e"));
        assertEquals("fake desc", info.getDescription());
                    + " by \".\"'s and may have leading zeros but was 1.7.0_80"  
            "1.0",  
            ""  
            "my_plugin",  
    public void testhMultipleOpenSearchRangesInDependencies() throws Exception {
        PluginsAndModules pluginsInfo = new PluginsAndModules(plugins, Collections.emptyList());
    public void testMultipleDependencies() throws Exception {  
            "FakePlugin"
            "fake desc",
            "1.0",
        PluginTestUtil.writePluginProperties(
        assertEquals("fake desc", info.getDescription());
            "1.0",  
        assertEquals("FakePlugin", info.getClassname());  
            "description",
            "classname",
            "extra",  
        assertTrue(prettyPrint.contains("\"has_native_controller\" : false"));  
        Path pluginDir = createTempDir().resolve("fake-plugin");
            "FakePlugin"  
            "classname",
            "description",
            "fake desc",
            pluginDir,  
        Path pluginDir = createTempDir().resolve(pluginName);  
import org.opensearch.common.io.stream.BytesStreamOutput;  
            "classname",
            "1.0"
            "classname",
            "name",  
            "java.version",
 * The OpenSearch Contributors require contributions made to  
            "my_plugin",
        );
            System.getProperty("java.specification.version")  
        assertThat(info.getExtendedPlugins(), empty());
            "1.0",
            randomBoolean()
            pluginDir,
    }  
import static org.hamcrest.Matchers.containsString;  
            "classname",
        );  
    }  
        assertThat(e.getMessage(), containsString("Exactly one dependency is allowed to be specified in plugin descriptor properties"));
        PluginInfo info = PluginInfo.readFromProperties(pluginDir);  
            "name",
            "classname",  
            "dependencies",
            "1.0",
        );
    public void testExtendedPluginsMultipleExtensions() throws Exception {
        );
        );
            "my_plugin",
        PluginTestUtil.writePluginProperties(
        PluginInfo info = new PluginInfo(  
            System.getProperty("java.specification.version"),
            "version",  
        assertTrue(prettyPrint.contains("\"extended_plugins\" : [ ]"));
        PluginInfo info = PluginInfo.readFromProperties(pluginDir);
 * not use this file except in compliance with the License.
        assertThat(  
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;
            "1.0",  
            System.getProperty("java.specification.version"),
            "version",  
        PluginInfo info = new PluginInfo(
            "version",  
            "name",  
    public void testReadFromPropertiesDescriptionMissing() throws Exception {  
            "dependencies",
            "{}",  
            "java.version",  
            Collections.emptyList(),
    public void testInvalidDependenciesProperty() throws Exception {
            "classname",
/*  
            "java.version",
            "java.version",
            "1.0",
    public void testReadFromPropertiesJvmMissingClassname() throws Exception {
        PluginTestUtil.writePluginProperties(
            "name",
            "dummyclass",
            System.getProperty("java.specification.version"),
        String pluginName = "fake-plugin";
            "version",
                List.of(  
            "1.8",  
        Path pluginDir = createTempDir().resolve("fake-plugin");
import org.opensearch.core.xcontent.ToXContent;  
        assertThat(info.getExtendedPlugins(), empty());  
    public void testReadFromPropertiesNameMissing() throws Exception {
            "fake desc",  
            "{opensearch:\"~" + Version.CURRENT.toString() + "\"}",
 * software distributed under the License is distributed on an
            "FakePlugin"  
            "description",  
            "fake desc",  
        assertEquals(Version.CURRENT.toString(), info.getOpenSearchVersionRanges().get(0).toString());
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
            Collections.singletonList("foo"),  
            "fake desc",
    }
    }
            "fake desc",
        PluginInfo info2 = new PluginInfo(input);
            pluginDir,  
            "name",
            "name",  
    }  
            "classname",
    }
            "unknown",
                null,  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
            System.getProperty("java.specification.version"),  
            "my_plugin",
        Path pluginDir = createTempDir().resolve("fake-plugin");  
            "name",
        );
            "java.version",
            "fake desc",  
        assertThat(e.getMessage(), containsString("Only opensearch is allowed to be specified as a plugin dependency"));
        assertThat(info.getExtendedPlugins(), contains("foo", "bar", "baz"));
            "opensearch.version",  
    public void testExtendedPluginsEmpty() throws Exception {
            "{opensearch:\"\"}",
            "bogus"
            () -> new PluginInfo(
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(info.isExtendedPluginOptional("foo"), is(true));
            "my_plugin",
            "1.0",  
            "c",
            "1.0",  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));  
            "fake desc",
            "description",  
            "name",
        String opensearchRange = "[" + Version.V_2_0_0.toString() + "," + Version.V_3_0_0.toString() + ")";
            "description",  
        List<PluginInfo> plugins = new ArrayList<>();
        plugins.add(new PluginInfo("c", "foo", "dummy", Version.CURRENT, "1.8", "dummyclass", Collections.emptyList(), randomBoolean()));
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
            "name",
        PluginTestUtil.writePluginProperties(pluginDir, "name", "fake-plugin");
            "{opensearch:\"1.2\"}",
            "1.0",
            pluginDir,
            e.getMessage(),
            "my_plugin",  
            "name",
    public void testReadFromPropertiesJavaVersionMissing() throws Exception {
            "{opensearch:\"<2.2.0\"}",
import static org.hamcrest.Matchers.empty;
    }
            "fake desc",
        assertTrue(prettyPrint.contains("\"classname\" : \"dummyClass\""));  
            "opensearch.version",  
            "description",
 * You may obtain a copy of the License at  
 */
import java.util.List;
import java.util.stream.Collectors;  
        Path pluginDir = createTempDir().resolve("fake-plugin");
            "1.0",
            pluginDir,
            "fake desc",
            "dummyClass",  
            System.getProperty("java.specification.version"),  
    }  
        Path pluginDir = createTempDir().resolve("fake-plugin");  
            "name",
            "1.0",
            "java.version",
            "dependencies",
    public void testReadFromPropertiesOpenSearchVersionAndDependenciesMissing() throws Exception {
        );  
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> PluginInfo.readFromProperties(pluginDir));
    }
            "my_plugin",
        assertEquals("my_plugin", info.getName());  
            "FakePlugin"
        assertThat(e.getMessage(), containsString("[version] is missing"));
            "dependencies",  
        IllegalArgumentException e = expectThrows(  
    }
        Path pluginDir = createTempDir().resolve("fake-plugin");  
        );
                "version string must be a sequence of nonnegative decimal integers separated"
import org.opensearch.semver.SemverRange;
            "FakePlugin",
    public void testReadFromPropertiesBogusOpenSearchVersion() throws Exception {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
    }  
            "Foo",
        PluginTestUtil.writePluginProperties(
    public void testNonOpenSearchDependency() throws Exception {
import org.opensearch.core.common.io.stream.ByteBufferStreamInput;
import java.nio.ByteBuffer;
        PluginTestUtil.writePluginProperties(
            e.getMessage(),
 * license agreements. See the NOTICE file distributed with
        assertTrue(prettyPrint.contains("\"opensearch_version\" : \"" + Version.CURRENT));  
        assertThat(  
            System.getProperty("java.specification.version"),
            "description",
        );
        Path pluginDir = createTempDir().resolve("fake-plugin");
        PluginTestUtil.writePluginProperties(  
            "opensearch.version",  
            "my_plugin",
        PluginInfo info = PluginInfo.readFromProperties(pluginDir);  
                    new SemverRange(Version.CURRENT, SemverRange.RangeOperator.EQ),
            "description",
            "my_plugin",
            "description",  
            "custom.foldername",  
            "fake desc",
            pluginDir,
        ByteBuffer buffer = ByteBuffer.wrap(output.bytes().toBytesRef().bytes);
        );
            "fake desc",  
        assertThat(
    }
        assertThat(e.getMessage(), containsString("version needs to contain major, minor, and revision"));
            pluginDir,  
            "opensearch.version",  
            System.getProperty("java.specification.version")
            "classname",
            "dependencies",
            "version",  
            "foo"
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
 * ownership. Elasticsearch licenses this file to you under  
            Version.CURRENT.toString(),
        assertThat(info.getExtendedPlugins(), contains("foo"));
            "name",
 * Licensed to Elasticsearch under one or more contributor  
    }
 * specific language governing permissions and limitations
import java.util.Collections;
    }  
            "version",
        );  
            "java.version",
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
 */  
        plugins.add(new PluginInfo("b", "foo", "dummy", Version.CURRENT, "1.8", "dummyclass", Collections.emptyList(), randomBoolean()));  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
        PluginTestUtil.writePluginProperties(
            Version.CURRENT.toString(),
        assertThat(info.isExtendedPluginOptional("foo"), is(false));
            "description",
    public void testRangeSemverOnDependencies() throws Exception {  
            pluginDir,
            "dependencies",
            "dependencies",
                "plugin_name",  
 * the Apache License, Version 2.0 (the "License"); you may
        PluginTestUtil.writePluginProperties(  
            )  
        assertEquals("~" + Version.CURRENT.toString(), info.getOpenSearchVersionRanges().get(0).toString());
            "java.version",
            "my_plugin",  
        Path pluginDir = createTempDir().resolve("fake-plugin");  
            System.getProperty("java.specification.version"),
            "my_plugin",
 * compatible open source license.
import static org.hamcrest.Matchers.contains;
            System.getProperty("java.specification.version"),
        PluginTestUtil.writePluginProperties(pluginDir, "description", "fake desc", "name", "my_plugin", "version", "1.0");
            "name",
        assertEquals("1.0", info.getVersion());  
        );
    }
 *  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));  
            "java.version",
            "description",
        PluginTestUtil.writePluginProperties(
                randomBoolean()
        );
        BytesStreamOutput output = new BytesStreamOutput();  
        assertThat(e.getMessage(), containsString("property [classname] is missing"));
            "FakePlugin",
            pluginDir,
            System.getProperty("java.specification.version"),  
        expectThrows(JsonParseException.class, () -> PluginInfo.readFromProperties(pluginDir));  
 * KIND, either express or implied.  See the License for the
        Path pluginDir = createTempDir().resolve("fake-plugin");  
            "java.version",  
        assertThat(info2.toString(), equalTo(info.toString()));
        PluginTestUtil.writePluginProperties(
            "name",
            )
            "extended.plugins",  
                "dummyclass",
            "opensearch.version",
            "version",
            "description",
        Path pluginDir = createTempDir().resolve("fake-plugin");  
            "foo",
            "opensearch.version",
            containsString("Either [opensearch.version] or [dependencies] property must be specified for the plugin ")
        assertEquals("custom-folder", info.getTargetFolderName());
 * this file be licensed under the Apache-2.0 license or a
        );
import static org.hamcrest.Matchers.equalTo;
            "my_plugin",  
            "fake desc",
    public void testReadFromPropertiesVersionMissing() throws Exception {
            "java.version",
        assertEquals("1.0", info.getVersion());
        PluginInfo info = PluginInfo.readFromProperties(pluginDir);  
            Version.CURRENT.toString(),
    public void testReadFromPropertiesWithFolderNameAndVersionAfter() throws Exception {
            "dependencies",
        assertThat(e.getMessage(), containsString("property [name] is missing in"));  
            "foo;optional=true"
        Path pluginDir = createTempDir().resolve("fake-plugin");  
    }  
            "my_plugin",  
    }  
            "java.version",  
            "my_plugin",
        assertThat(info.getExtendedPlugins(), contains("foo"));
        e = expectThrows(IllegalArgumentException.class, () -> PluginInfo.readFromProperties(pluginDir));
        );
        assertThat(info.getExtendedPlugins(), empty());
package org.opensearch.plugins;
    public void testInvalidRangeInDependencies() throws Exception {  
        PluginInfo info = PluginInfo.readFromProperties(pluginDir);
            "classname",
            pluginDir,
