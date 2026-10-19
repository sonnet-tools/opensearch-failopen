    }
        builder.startObject();
import org.opensearch.core.xcontent.DeprecationHandler;  
            }
        }
     * The list of OpenSearch version ranges the plugin is compatible with.
        // Ensure only one range is specified (for now)  
                    DeprecationHandler.IGNORE_DEPRECATIONS,  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param opensearchVersion     the version of OpenSearch the plugin was built for  
     * @param version               an opaque version identifier for the plugin
        this.version = version;
        if (opensearchVersionRanges.size() == 1) {  
            javaVersionString,
     * @return the names of the plugins extended
            .append(name)
        String version,
     * @return semver ranges string  
            .append(classname)
    private final List<SemverRange> opensearchVersionRanges;  
        }
        String[] dependency = extendedPlugin.split(";");
     */
     *
 * Licensed to Elasticsearch under one or more contributor  
        if (!name.equals(that.name)) return false;  
        }  
     * @return the custom folder name for the plugin
            );
        if (out.getVersion().onOrAfter(Version.V_2_19_0)) {
            As more notations get added, then a suitable version must be picked.
        boolean hasNativeController
            customFolderName,
import java.util.Collections;  
                    throw new IllegalArgumentException(message);
        final String description = propsMap.remove("description");  
    public boolean isExtendedPluginOptional(String extendedPlugin) {  
    public String toString(String prefix) {
        String javaVersion,  
                "Either [opensearch.version] or [dependencies] property must be specified for the plugin [" + name + "]"
            builder.field("opensearch_version", getOpenSearchVersionRangesString());  
            return opensearchVersionRanges.get(0).toString();
            throw new IllegalArgumentException("property [description] is missing for plugin [" + name + "]");
 */  
            opensearchVersionRanges.add(SemverRange.fromString(opensearchVersion.trim()));  
        } else {
    }
            null /* customFolderName */,
import org.opensearch.common.bootstrap.JarHell;  
            hasNativeController  
    /**  
        if (opensearchVersionString != null && dependenciesValue != null) {
     *
    }  
import tools.jackson.core.json.JsonReadFeature;
                final JsonXContentParser parser = new JsonXContentParser(
     * @param version               an opaque version identifier for the plugin
     *
     */
    @Override  
     * Construct plugin info from a stream.  
        this.hasNativeController = in.readBoolean();
        {  
        return builder;
        return classname;
                        Locale.ROOT,  
    }
        this.description = description;
        );
            extendedPlugins,
        final List<SemverRange> opensearchVersionRanges = new ArrayList<>();
            }
        final String dependenciesValue = propsMap.remove("dependencies");
     * @param classname             the entry point to the plugin
    }
            .append("\n")
            hasNativeController = false;
        List<String> extendedPlugins,  
    /**  
        if (classname == null) {  
            description,
                    break;  
import org.opensearch.core.common.io.stream.StreamInput;  
/**
            version,  
        this.version = in.readString();  
        // TODO: since the plugins are unique by their directory name, this should only be a name check, version should not matter?
import java.nio.file.Files;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                case "true":
        }
    public String getVersion() {  
            .map(s -> s.split(";")[0])
            out.writeVersion(opensearchVersionRanges.get(0).getRangeVersion());  
     *  
        boolean hasNativeController
        if (opensearchVersionRanges.size() != 1) {
    @Override  
        }
}  
     * @param description           a description of the plugin
    public int hashCode() {
        } else {
            .append(prefix)  
            throw new IllegalArgumentException(
            .append("\n")
        return javaVersion;  
            builder.field("version", version);
    @Override
            .filter(PluginInfo::isOptionalExtension)  
     * The custom folder name for the plugin.
            }
    public String getTargetFolderName() {
            .append("\n")  
        this.name = name;  
    public static final String OPENSEARCH_PLUGIN_POLICY = "plugin-security.policy";
            .append(" * Classname: ")
             */
        final List<String> extendedPlugins;  
            );
import tools.jackson.core.json.JsonFactoryBuilder;  
            classname,  
    /**  
 * this file be licensed under the Apache-2.0 license or a
        return description;
            .append(description)
    ) {
        this.description = in.readString();
 * SPDX-License-Identifier: Apache-2.0
    public static PluginInfo readFromProperties(final Path path) throws IOException {
    private final String classname;
        return new PluginInfo(  
            Map<String, String> dependenciesMap;
    private static final JsonFactory jsonFactory = new JsonFactoryBuilder().configure(JsonReadFeature.ALLOW_UNQUOTED_PROPERTY_NAMES, true)  
            hasNativeController  
        return (this.customFolderName == null || this.customFolderName.isEmpty()) ? this.name : this.customFolderName;  
            out.writeStringCollection(optionalExtendedPlugins);  
    private final List<String> optionalExtendedPlugins;  
import java.util.List;
 */  
    }
     */
        final StringBuilder information = new StringBuilder().append(prefix)  
                opensearchVersion = opensearchDependencyVersion;  
    }
            .append("Name: ")  
            builder.field("extended_plugins", extendedPlugins);
     * Whether or not the plugin has a native controller.
    ) {  
        final Path descriptor = path.resolve(OPENSEARCH_PLUGIN_PROPERTIES);  
            }
                );
    /**
     */  
     * @return the version
        final String opensearchVersionString = propsMap.remove("opensearch.version");  
                    hasNativeController = true;
        return extendedPlugins.stream().map(s -> s.split(";")[0]).collect(Collectors.toUnmodifiableList());
        .build();
        final String customFolderName;
    }
                throw new IllegalArgumentException(
     */
        } else {  
     *  
     */
    @Override  
     * Other plugins this plugin extends through SPI.
            builder.field("optional_extended_plugins", optionalExtendedPlugins);
     * @param in the stream
     * @param path           the path to the root directory for the plugin
            if (RANGE_PATTERN.matcher(opensearchDependencyVersion).matches()) {
        }  
     *  
            opensearchVersionRanges,
        String name,
    }
        if (customFolderName != null) {
     * The description of the plugin.
    }
     * Construct plugin info.
     */
        customFolderName = customFolderNameValue;  
                );  
            .append("Description: ")
                    "Exactly one range is allowed to be specified in dependencies for the plugin [" + name + "]"  
 *
            .collect(Collectors.toUnmodifiableList());
     * Reads the plugin descriptor file.
 */
            builder.field("has_native_controller", hasNativeController);  
    }
     * The target folder name for the plugin.
    public String getFolderName() {  
     */
                case "false":
            .append(prefix)
            version,
        this.optionalExtendedPlugins = extendedPlugins.stream()
/*  
        final String extendedString = propsMap.remove("extended.plugins");
            throw new IllegalArgumentException("property [classname] is missing for plugin [" + name + "]");
            classname,  
    }  
        String customFolderName,
        if (opensearchVersionString != null) {
     * @param name                  the name of the plugin  
            if (dependenciesMap.size() != 1) {  
            .append(prefix)
        out.writeString(name);
            .append(getOpenSearchVersionRangesString())
            throw new IllegalArgumentException("property [name] is missing in [" + descriptor + "]");
        return opensearchVersionRanges;
        final String version = propsMap.remove("version");
     *
            final Properties props = new Properties();
            extendedPlugins = Arrays.asList(Strings.delimitedListToStringArray(extendedString, ","));
    /**  
            throw new IllegalArgumentException("property [version] is missing for plugin [" + name + "]");  
    public String getDescription() {  
import java.util.Arrays;
    }  
        return version;
        return name;
        }  
            }
    private final String javaVersion;
     * Pretty print the semver ranges and return the string.
        final boolean hasNativeController;
            throw new IllegalArgumentException(  
 * not use this file except in compliance with the License.
     * @param javaVersion           the version of Java the plugin was built with
            List.of(SemverRange.fromString(opensearchVersion.toString())),
            throw new IllegalArgumentException("Unknown properties in plugin descriptor: " + propsMap.keySet());  
            String[] ranges = opensearchDependencyVersion.split(",");  
     *
        Version opensearchVersion,
    public String getOpenSearchVersionRangesString() {
            version,  
        PluginInfo that = (PluginInfo) o;
    public PluginInfo(
            ) {  
        final String customFolderNameValue = propsMap.remove("custom.foldername");
        String classname,
import java.util.Properties;
        String description,
     * @throws IOException if an I/O exception occurred reading the plugin descriptor  
            .append(prefix)
        return customFolderName;
    }
                throw new IllegalArgumentException("Only opensearch is allowed to be specified as a plugin dependency: " + dependenciesMap);  
 * Modifications Copyright OpenSearch Contributors. See
            switch (hasNativeControllerValue) {  
    }
        if (in.getVersion().onOrAfter(Version.V_2_19_0)) {
     * @param javaVersion           the version of Java the plugin was built with
            .append(prefix)
            out.writeGenericValue(opensearchVersionRanges);  
 * license agreements. See the NOTICE file distributed with
     * The version of the plugin
        }
package org.opensearch.plugins;
     * @return the entry point to the plugin
    }
        this.customFolderName = customFolderName;  
    private final String name;  
    @Override
    public void writeTo(final StreamOutput out) throws IOException {
        this(  
     *  
     * @return the plugin description
                        hasNativeControllerValue
        if (extendedString == null) {
        if (javaVersionString == null) {
        return hasNativeController;  
    public boolean equals(Object o) {  
    /**  
            propsMap = props.stringPropertyNames().stream().collect(Collectors.toMap(Function.identity(), props::getProperty));
        return toString("");
        String description,  
            try (  
     * Construct plugin info.
            builder.field("java_version", javaVersion);
            /*
     * @return {@code true} if the plugin has a native controller  
            .append(prefix)
     * @param hasNativeController   whether or not the plugin has a native controller
            extendedPlugins,
                "Only one of [opensearch.version] or [dependencies] property can be specified for the plugin [" + name + "]"  
     * @param extendedPlugins       other plugins this plugin extends through SPI  
        );
            .append("Java Version: ")
            opensearchVersion,
    public List<String> getExtendedPlugins() {  
            .append(extendedPlugins)
            customFolderName,
     * @return the plugin info
        Version opensearchVersion,
import java.util.stream.Collectors;  
     * @return the names of the plugins extended
        this.customFolderName = in.readString();
        }
    /**
                )
 */  
        {  
    }
    }
    @SuppressWarnings("unchecked")
        this.extendedPlugins = extendedPlugins.stream().map(s -> s.split(";")[0]).collect(Collectors.toUnmodifiableList());
        }  
     */
            .append("\n")  
            .append(prefix)  
                    break;  
                props.load(stream);  
    }
                    "Exactly one dependency is allowed to be specified in plugin descriptor properties: " + dependenciesMap
        } else {
        }
            opensearchVersionRanges.add(SemverRange.fromString(opensearchVersionString));  
                    jsonFactory.createParser(dependenciesValue)
            .append("\n")
     * @throws IOException if an I/O exception occurred reading the plugin info from the stream  
        this(
 * An in-memory representation of the plugin descriptor.  
            throw new IllegalArgumentException(
    ) {
    /**
            This works for currently supported range notations (=,~)  
            .append("Native Controller: ")
        JarHell.checkVersionFormat(javaVersionString);
     * @param description           a description of the plugin
            out.writeString(name);
     * @param name                  the name of the plugin  
            .append("Version: ")
            .append("OpenSearch Version: ")  
                throw new IllegalArgumentException(
     */
        String name,
            out.writeString(customFolderName);
                    );  
            .append(hasNativeController)  
            builder.field("name", name);
import org.opensearch.core.common.Strings;
                        "property [%s] must be [%s], [%s], or unspecified but was [%s]",
            this.opensearchVersionRanges = List.of(new SemverRange(in.readVersion(), SemverRange.RangeOperator.DEFAULT));
 * KIND, either express or implied.  See the License for the
        if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.Version;
import org.opensearch.core.common.io.stream.Writeable;
            name,
        this.javaVersion = javaVersion;
        } else {
        }  
 * Unless required by applicable law or agreed to in writing,
        }
    // Optional extended plugins are a subset of extendedPlugins that only contains the optional extended plugins
 *  
            javaVersion,
     * @param extendedPlugins       other plugins this plugin extends through SPI
        String name,
                        "true",  
     */
            String opensearchDependencyVersion = dependenciesMap.get("opensearch");
            } else if (ranges.length != 1) {
        } else {  
     * Other plugins this plugin extends through SPI
        final String classname = propsMap.remove("classname");
        out.writeBoolean(hasNativeController);
        }  
        final String name = propsMap.remove("name");
        out.writeStringCollection(extendedPlugins);  
            throw new IllegalArgumentException("property [java.version] is missing for plugin [" + name + "]");
        }
     * @return a list of OpenSearch version ranges
    public String getName() {  
        out.writeString(javaVersion);
            .append(prefix)  
 *
import java.util.function.Function;
        if (propsMap.isEmpty() == false) {
    public PluginInfo(final StreamInput in) throws IOException {  
                "Exactly one range is allowed to be specified in dependencies for the plugin [" + name + "]"  
        if (opensearchVersionString == null && dependenciesValue == null) {
        return dependency.length > 1 && "optional=true".equals(dependency[1]);  
            .append("\n")  
        final String javaVersionString = propsMap.remove("java.version");  
                    hasNativeController = false;
     *
     * @param hasNativeController   whether or not the plugin has a native controller
                        "false",
            .append(prefix)
            try (InputStream stream = Files.newInputStream(descriptor)) {
            hasNativeController
    /**
            description,  
     * The entry point to the plugin.
    public static final String OPENSEARCH_PLUGIN_PROPERTIES = "plugin-descriptor.properties";
        out.writeString(classname);  
 * software distributed under the License is distributed on an
        String version,
            throw new IllegalStateException("Opensearch version ranges list cannot be empty");
                default:
     */
import static org.opensearch.semver.SemverRange.RANGE_PATTERN;  
            this.opensearchVersionRanges = (List<SemverRange>) in.readGenericValue();
import java.util.Map;  
        return information.toString();
        String customFolderName,
    private final boolean hasNativeController;
        this.name = in.readString();
        String description,  
            .append("- Plugin information:\n")
        String javaVersion,
        this.javaVersion = in.readString();  
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        }
import java.util.Locale;
    private final String description;
 * @opensearch.api
            .append("\n")
     * @return the custom folder name for the plugin if the folder name is specified, else return the id with kebab-case.  
import org.opensearch.core.xcontent.ToXContentObject;
            name,
    }
    static boolean isOptionalExtension(String extendedPlugin) {
        this.extendedPlugins = in.readStringList();  
            }
        return name.hashCode();  
 * specific language governing permissions and limitations
            javaVersion,  
import org.opensearch.core.xcontent.XContentBuilder;  
        out.writeString(version);
    public String getClassname() {  
            extendedPlugins,  
        if (opensearchVersionRanges == null || opensearchVersionRanges.isEmpty()) {  
        final String hasNativeControllerValue = propsMap.remove("has.native.controller");
        if (version == null) {
            .append(version)  
        if (out.getVersion().onOrAfter(Version.V_2_13_0)) {
        return true;
                    NamedXContentRegistry.EMPTY,
/*
 * The OpenSearch Contributors require contributions made to  
import java.io.InputStream;
import java.io.IOException;  
        if (this == o) return true;
     *  
        }
        return opensearchVersionRanges.stream().map(Object::toString).collect(Collectors.joining(",", "[", "]"));  
     *  
        String classname,  
 * ownership. Elasticsearch licenses this file to you under  
            builder.field("classname", classname);  
        }
     * @param opensearchVersion     the version of OpenSearch the plugin was built for  
            .append(javaVersion)
    }
        if (description == null) {
            .append("Folder name: ")
        final Map<String, String> propsMap;
    /**
    /**
     *  
    /**
        this.opensearchVersionRanges = opensearchVersionRanges;  
        builder.endObject();  
@PublicApi(since = "1.0.0")
            classname,
    public PluginInfo(
        );
            String opensearchVersion = ranges[0];
    private final List<String> extendedPlugins;
    }
    /**
import java.util.ArrayList;
            .append("Extended Plugins: ")  
    }
            builder.field("custom_foldername", customFolderName);
            description,
        String javaVersion,  
    public String getJavaVersion() {
import org.opensearch.common.annotation.PublicApi;
import tools.jackson.core.json.JsonFactory;
        out.writeString(description);  
 * compatible open source license.
        boolean hasNativeController
    public boolean hasNativeController() {
     * The version of Java the plugin was built with.
     *  
     *  
        String classname,
            .append(customFolderName);  
        return optionalExtendedPlugins.contains(extendedPlugin);
            this.optionalExtendedPlugins = in.readStringList();  
import org.opensearch.semver.SemverRange;
                        "has_native_controller",
        }
        List<String> extendedPlugins,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
 * GitHub history for details.
        this.classname = in.readString();
public class PluginInfo implements Writeable, ToXContentObject {
     * @param classname             the entry point to the plugin
        }
    }
        String version,  
import org.opensearch.core.common.io.stream.StreamOutput;
        } else {  
        List<SemverRange> opensearchVersionRanges,
 * the Apache License, Version 2.0 (the "License"); you may
        this.hasNativeController = hasNativeController;  
    public String toString() {
            builder.field("description", description);
     * @return a java version string  
    public PluginInfo(  
     * The name of the plugin.
 *
            this.optionalExtendedPlugins = new ArrayList<>();
        if (name == null || name.isEmpty()) {  
        List<String> extendedPlugins,
    public List<SemverRange> getOpenSearchVersionRanges() {  
    /**
        }
            name,
                    final String message = String.format(
        this.classname = classname;
     */
 * under the License.  
import java.nio.file.Path;  
                dependenciesMap = parser.mapStrings();
import org.opensearch.core.xcontent.NamedXContentRegistry;
     */
    /**
            );
            extendedPlugins = Collections.emptyList();
    /**
     */
        if (hasNativeControllerValue == null) {  
    private final String version;
import org.opensearch.common.xcontent.json.JsonXContentParser;
        if (in.getVersion().onOrAfter(Version.V_2_13_0)) {
    private final String customFolderName;  
     * @param customFolderName      the custom folder name for the plugin  
            if (dependenciesMap.keySet().stream().noneMatch(s -> s.equals("opensearch"))) {
 * You may obtain a copy of the License at  
            .append("\n")
 * this work for additional information regarding copyright
/*  
     * @return the plugin name
