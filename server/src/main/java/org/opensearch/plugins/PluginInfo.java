            extendedPlugins = Arrays.asList(Strings.delimitedListToStringArray(extendedString, ","));
        out.writeString(version);
                throw new IllegalArgumentException(
            .append("Version: ")
            Map<String, String> dependenciesMap;
            }
        return hasNativeController;
        this.hasNativeController = in.readBoolean();
        } else {
     * @return {@code true} if the plugin has a native controller
     */
                    hasNativeController = true;
    /**
                    NamedXContentRegistry.EMPTY,
        {
        out.writeString(description);
            As more notations get added, then a suitable version must be picked.
    }
 */
            extendedPlugins,
                props.load(stream);
            This works for currently supported range notations (=,~)
     *
     *
                throw new IllegalArgumentException("Only opensearch is allowed to be specified as a plugin dependency: " + dependenciesMap);
    }
        this.javaVersion = in.readString();
            .append(extendedPlugins)
    }
        this.customFolderName = customFolderName;
                    hasNativeController = false;
     * The entry point to the plugin.
        final List<SemverRange> opensearchVersionRanges = new ArrayList<>();
 *
            this.opensearchVersionRanges = (List<SemverRange>) in.readGenericValue();
        } else {
            .append(prefix)
    }
 * Modifications Copyright OpenSearch Contributors. See
import java.nio.file.Files;
    public static final String OPENSEARCH_PLUGIN_PROPERTIES = "plugin-descriptor.properties";
            builder.field("custom_foldername", customFolderName);
    private final String description;
 *
        this.hasNativeController = hasNativeController;
    public String getJavaVersion() {
        boolean hasNativeController
    }
    private final String customFolderName;
            .append(classname)
    ) {
    public PluginInfo(
     * The list of OpenSearch version ranges the plugin is compatible with.
            builder.field("optional_extended_plugins", optionalExtendedPlugins);
            .append(prefix)
            .append("\n")
    private final String classname;
        return toString("");
     */
        if (in.getVersion().onOrAfter(Version.V_2_19_0)) {
     * @return the names of the plugins extended
    private final String version;
        String description,
        String customFolderName,
            this.optionalExtendedPlugins = in.readStringList();
            opensearchVersionRanges,
        }
            );
 * compatible open source license.
            builder.field("java_version", javaVersion);
     *
        return version;
            switch (hasNativeControllerValue) {
            .append("\n")
            .map(s -> s.split(";")[0])
        if (classname == null) {
        return extendedPlugins.stream().map(s -> s.split(";")[0]).collect(Collectors.toUnmodifiableList());
     * @return the plugin description
import java.io.InputStream;
            version,
import org.opensearch.core.xcontent.ToXContentObject;
        if (opensearchVersionString != null) {
    private final String name;
     *
package org.opensearch.plugins;
        }
            .append("\n")
    public List<SemverRange> getOpenSearchVersionRanges() {
    @Override
import java.util.Locale;
            throw new IllegalArgumentException("property [java.version] is missing for plugin [" + name + "]");
     *
        if (javaVersionString == null) {
        final Map<String, String> propsMap;
        } else {
     * The version of the plugin
        this(
    public String getVersion() {
import java.util.Properties;
        );
                );
import tools.jackson.core.json.JsonReadFeature;
    public String getName() {
            try (
            hasNativeController
 * under the License.
        String name,
 * this work for additional information regarding copyright
            }
            .append(" * Classname: ")
        String name,
     * Other plugins this plugin extends through SPI.
     */
    /**
                "Only one of [opensearch.version] or [dependencies] property can be specified for the plugin [" + name + "]"
        }
    }
     * Other plugins this plugin extends through SPI
            .append(prefix)
            javaVersion,
    public List<String> getExtendedPlugins() {
            builder.field("classname", classname);
            .append("Name: ")
/*
            if (dependenciesMap.keySet().stream().noneMatch(s -> s.equals("opensearch"))) {
            out.writeString(name);
        if (extendedString == null) {
            }
            .append(description)
                final JsonXContentParser parser = new JsonXContentParser(
            out.writeStringCollection(optionalExtendedPlugins);
 * software distributed under the License is distributed on an
        } else {
        this.version = in.readString();
            throw new IllegalArgumentException("property [name] is missing in [" + descriptor + "]");
        // Ensure only one range is specified (for now)
        this.extendedPlugins = in.readStringList();
import org.opensearch.common.bootstrap.JarHell;
        final String extendedString = propsMap.remove("extended.plugins");
    public String getOpenSearchVersionRangesString() {
        return true;
     * @return the plugin info
    /**
            classname,
        }
        String version,
    /**
            .append(prefix)
            try (InputStream stream = Files.newInputStream(descriptor)) {
    // Optional extended plugins are a subset of extendedPlugins that only contains the optional extended plugins
        String classname,
import org.opensearch.core.common.io.stream.StreamInput;
            throw new IllegalArgumentException("property [description] is missing for plugin [" + name + "]");
            builder.field("extended_plugins", extendedPlugins);
        String classname,
                        "true",
/*
    }
            .append("Extended Plugins: ")
                    DeprecationHandler.IGNORE_DEPRECATIONS,
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Unknown properties in plugin descriptor: " + propsMap.keySet());
            javaVersionString,
     *
        out.writeString(name);
            ) {
        }
    }
    }
        }
        out.writeBoolean(hasNativeController);
     * @param classname             the entry point to the plugin
    public boolean hasNativeController() {
     * The target folder name for the plugin.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @return the version
            builder.field("has_native_controller", hasNativeController);
import java.util.function.Function;
            .append(javaVersion)
     *
     * Reads the plugin descriptor file.
        return opensearchVersionRanges.stream().map(Object::toString).collect(Collectors.joining(",", "[", "]"));
import org.opensearch.core.xcontent.XContentBuilder;
            .append("Java Version: ")
        return new PluginInfo(
 * @opensearch.api
            throw new IllegalArgumentException(
            );
            opensearchVersionRanges.add(SemverRange.fromString(opensearchVersionString));
    public int hashCode() {
    public static PluginInfo readFromProperties(final Path path) throws IOException {
     * @throws IOException if an I/O exception occurred reading the plugin info from the stream
                    "Exactly one dependency is allowed to be specified in plugin descriptor properties: " + dependenciesMap
        this.extendedPlugins = extendedPlugins.stream().map(s -> s.split(";")[0]).collect(Collectors.toUnmodifiableList());
        return name;
        this.opensearchVersionRanges = opensearchVersionRanges;
public class PluginInfo implements Writeable, ToXContentObject {
    /**
        if (opensearchVersionRanges.size() == 1) {
     */
        return optionalExtendedPlugins.contains(extendedPlugin);
    }
            .append(name)
    private final List<String> optionalExtendedPlugins;
            if (dependenciesMap.size() != 1) {
     * The custom folder name for the plugin.
        }
                "Either [opensearch.version] or [dependencies] property must be specified for the plugin [" + name + "]"
                case "false":
        String javaVersion,
 * the Apache License, Version 2.0 (the "License"); you may
            .append("OpenSearch Version: ")
            } else if (ranges.length != 1) {
 * license agreements. See the NOTICE file distributed with
            }
            .append("Native Controller: ")
        if (customFolderName != null) {
        if (propsMap.isEmpty() == false) {
    private final String javaVersion;
        final String hasNativeControllerValue = propsMap.remove("has.native.controller");
        if (in.getVersion().onOrAfter(Version.V_2_13_0)) {
     * @param description           a description of the plugin
            throw new IllegalStateException("Opensearch version ranges list cannot be empty");
            builder.field("description", description);
    public boolean equals(Object o) {
        this.classname = in.readString();
     * The version of Java the plugin was built with.
     * @return semver ranges string
            null /* customFolderName */,
import tools.jackson.core.json.JsonFactory;
            String opensearchDependencyVersion = dependenciesMap.get("opensearch");
import java.util.Arrays;
            name,
     * @throws IOException if an I/O exception occurred reading the plugin descriptor
import java.io.IOException;
            .append("\n")
        if (version == null) {
    }
                        "false",
            .append("Description: ")
 * Licensed to Elasticsearch under one or more contributor
        this.name = name;
            .append(getOpenSearchVersionRangesString())
        }
        }
    public String getClassname() {
        if (this == o) return true;
            description,
            return opensearchVersionRanges.get(0).toString();
        final String dependenciesValue = propsMap.remove("dependencies");
    /**
        return information.toString();
    }
     */
     * @param classname             the entry point to the plugin
     */
    private final boolean hasNativeController;
 *
            propsMap = props.stringPropertyNames().stream().collect(Collectors.toMap(Function.identity(), props::getProperty));
    public String getFolderName() {
     * @param name                  the name of the plugin
 * not use this file except in compliance with the License.
    @SuppressWarnings("unchecked")
     *
    public PluginInfo(
        String version,
        String[] dependency = extendedPlugin.split(";");
                    final String message = String.format(
     * The name of the plugin.
    /**
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
import java.util.stream.Collectors;
            }
    public String toString(String prefix) {
            customFolderName,
                        "property [%s] must be [%s], [%s], or unspecified but was [%s]",
                    "Exactly one range is allowed to be specified in dependencies for the plugin [" + name + "]"
            version,
    @Override
    /**
    @Override
     * @param path           the path to the root directory for the plugin
    }
                dependenciesMap = parser.mapStrings();
    }
 * specific language governing permissions and limitations
     * Construct plugin info.
        }
        if (opensearchVersionString == null && dependenciesValue == null) {
     */
     * @param version               an opaque version identifier for the plugin
    }
            .append(prefix)
    }
            opensearchVersionRanges.add(SemverRange.fromString(opensearchVersion.trim()));
     * @param version               an opaque version identifier for the plugin
                )
            hasNativeController = false;
        }
     * @param javaVersion           the version of Java the plugin was built with
            javaVersion,
 * KIND, either express or implied.  See the License for the
                case "true":
        this.classname = classname;
     */
     * @return the custom folder name for the plugin if the folder name is specified, else return the id with kebab-case.
import org.opensearch.common.xcontent.json.JsonXContentParser;
            builder.field("version", version);
        String javaVersion,
        String description,
     * Construct plugin info.
            .append("\n")
        return opensearchVersionRanges;
        return description;
            .append("\n")
import java.util.ArrayList;
            hasNativeController
        final StringBuilder information = new StringBuilder().append(prefix)
}
                        "has_native_controller",
        builder.startObject();
        Version opensearchVersion,
            List.of(SemverRange.fromString(opensearchVersion.toString())),
     * @return a list of OpenSearch version ranges
            .collect(Collectors.toUnmodifiableList());
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
    public String getTargetFolderName() {
     */
            out.writeGenericValue(opensearchVersionRanges);
        out.writeString(javaVersion);
     */
     * @param opensearchVersion     the version of OpenSearch the plugin was built for
     * @param in the stream
        }
     *
        if (hasNativeControllerValue == null) {
        return dependency.length > 1 && "optional=true".equals(dependency[1]);
            .append(version)
import tools.jackson.core.json.JsonFactoryBuilder;
import java.util.Collections;
    }
    public PluginInfo(final StreamInput in) throws IOException {
                default:
import static org.opensearch.semver.SemverRange.RANGE_PATTERN;
            classname,
     * @param opensearchVersion     the version of OpenSearch the plugin was built for
            throw new IllegalArgumentException(
        boolean hasNativeController
 *
        String description,
            throw new IllegalArgumentException("property [version] is missing for plugin [" + name + "]");
        this.version = version;
        if (out.getVersion().onOrAfter(Version.V_2_13_0)) {
        JarHell.checkVersionFormat(javaVersionString);
        builder.endObject();
/*
        final String name = propsMap.remove("name");
     *
     * @return the custom folder name for the plugin
     *
 * An in-memory representation of the plugin descriptor.
                throw new IllegalArgumentException(
        final String classname = propsMap.remove("classname");
     * @param extendedPlugins       other plugins this plugin extends through SPI
    /**
     * @param name                  the name of the plugin
        }
            }
     * @param extendedPlugins       other plugins this plugin extends through SPI
     *
        this.name = in.readString();
        this(
        // TODO: since the plugins are unique by their directory name, this should only be a name check, version should not matter?
        return classname;
            throw new IllegalArgumentException("property [classname] is missing for plugin [" + name + "]");
        if (opensearchVersionRanges.size() != 1) {
                "Exactly one range is allowed to be specified in dependencies for the plugin [" + name + "]"
            /*
     * Construct plugin info from a stream.
    /**
            description,
        List<String> extendedPlugins,
            name,
        }
 */
    @Override
            .filter(PluginInfo::isOptionalExtension)
                    jsonFactory.createParser(dependenciesValue)
     */
     * @param description           a description of the plugin
            opensearchVersion,
     * @return the names of the plugins extended
        .build();
    ) {
     * @param javaVersion           the version of Java the plugin was built with
            String opensearchVersion = ranges[0];
                    throw new IllegalArgumentException(message);
                        Locale.ROOT,
        if (opensearchVersionRanges == null || opensearchVersionRanges.isEmpty()) {
            .append(customFolderName);
            name,
    /**
    /**
        }
     * @return a java version string
                    );
/**
            throw new IllegalArgumentException(
     * The description of the plugin.
    /**
    ) {
        );
 * this file be licensed under the Apache-2.0 license or a
        PluginInfo that = (PluginInfo) o;
        if (!name.equals(that.name)) return false;
import org.opensearch.core.common.io.stream.Writeable;
        } else {
             */
 * The OpenSearch Contributors require contributions made to
     * @param customFolderName      the custom folder name for the plugin
        this.customFolderName = in.readString();
        if (description == null) {
            .append("- Plugin information:\n")
                    break;
                        hasNativeControllerValue
    }
            if (RANGE_PATTERN.matcher(opensearchDependencyVersion).matches()) {
                );
     */
            hasNativeController
    }
        return name.hashCode();
            version,
            .append("\n")
    public PluginInfo(
 * Unless required by applicable law or agreed to in writing,
        return customFolderName;
        String customFolderName,
    static boolean isOptionalExtension(String extendedPlugin) {
            builder.field("name", name);
@PublicApi(since = "1.0.0")
            .append(prefix)
        customFolderName = customFolderNameValue;
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Map;
     * @return the entry point to the plugin
        } else {
 */
        final String opensearchVersionString = propsMap.remove("opensearch.version");
            extendedPlugins,
            );
        String classname,
        String javaVersion,
            extendedPlugins,
    /**
     * @return the plugin name
    public boolean isExtendedPluginOptional(String extendedPlugin) {
     * Whether or not the plugin has a native controller.
        {
    }
     *
 * ownership. Elasticsearch licenses this file to you under
            out.writeVersion(opensearchVersionRanges.get(0).getRangeVersion());
        if (o == null || getClass() != o.getClass()) return false;
        if (out.getVersion().onOrAfter(Version.V_2_19_0)) {
            .append(prefix)
import org.opensearch.core.common.Strings;
 * SPDX-License-Identifier: Apache-2.0
        return javaVersion;
     */
        }
     */
        out.writeStringCollection(extendedPlugins);
     */
     */
        }
     *
     *
        return (this.customFolderName == null || this.customFolderName.isEmpty()) ? this.name : this.customFolderName;
        final String version = propsMap.remove("version");
        out.writeString(classname);
        final String customFolderNameValue = propsMap.remove("custom.foldername");
                    break;
            classname,
            .append("\n")
import org.opensearch.core.xcontent.DeprecationHandler;
    private static final JsonFactory jsonFactory = new JsonFactoryBuilder().configure(JsonReadFeature.ALLOW_UNQUOTED_PROPERTY_NAMES, true)
        );
            customFolderName,
        this.javaVersion = javaVersion;
        }
    /**
    public void writeTo(final StreamOutput out) throws IOException {
        this.optionalExtendedPlugins = extendedPlugins.stream()
        }
import java.nio.file.Path;
import java.util.List;
        } else {
        List<SemverRange> opensearchVersionRanges,
import org.opensearch.semver.SemverRange;
 * GitHub history for details.
            .append(hasNativeController)
            String[] ranges = opensearchDependencyVersion.split(",");
        if (opensearchVersionString != null && dependenciesValue != null) {
        final String javaVersionString = propsMap.remove("java.version");
            out.writeString(customFolderName);
    }
    }
     * @param hasNativeController   whether or not the plugin has a native controller
        final Path descriptor = path.resolve(OPENSEARCH_PLUGIN_PROPERTIES);
        List<String> extendedPlugins,
        List<String> extendedPlugins,
    }
    }
            this.optionalExtendedPlugins = new ArrayList<>();
                opensearchVersion = opensearchDependencyVersion;
        String version,
        final List<String> extendedPlugins;
    public static final String OPENSEARCH_PLUGIN_POLICY = "plugin-security.policy";
import org.opensearch.Version;
        return builder;
        final boolean hasNativeController;
            this.opensearchVersionRanges = List.of(new SemverRange(in.readVersion(), SemverRange.RangeOperator.DEFAULT));
        this.description = in.readString();
            extendedPlugins = Collections.emptyList();
        boolean hasNativeController
    private final List<String> extendedPlugins;
        }
     * @param hasNativeController   whether or not the plugin has a native controller
        String name,
 * You may obtain a copy of the License at
     * Pretty print the semver ranges and return the string.
            builder.field("opensearch_version", getOpenSearchVersionRangesString());
            .append("Folder name: ")
        final String description = propsMap.remove("description");
        Version opensearchVersion,
    public String toString() {
        final String customFolderName;
 */
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.NamedXContentRegistry;
            .append(prefix)
        this.description = description;
    private final List<SemverRange> opensearchVersionRanges;
            final Properties props = new Properties();
        }
    @Override
    public String getDescription() {
            description,
import org.opensearch.common.annotation.PublicApi;
            .append(prefix)
