        build = jdkVersionMatcher.group(3);
abstract class JavaVariant implements Buildable, Iterable<File> {  
    }  
        this.architecture.set(jdkArchitecture);
/*  
         */
    private final Configuration configuration;  
    public String toString() {  
         * Jdk uses aarch64 from ARM. Translating from arm64 to aarch64 which Jdk understands.
        return configuration.iterator();
                throw new IllegalArgumentException("Malformed jdk version [" + version + "]");
import java.util.Iterator;
    public void setVersion(String version) {  
    public String getVendor() {  
    @Override
    private static final Pattern VERSION_PATTERN = Pattern.compile(  
    private final Property<String> platform;
import org.gradle.api.tasks.TaskDependency;
    void finalizeValues() {
    public String getHash() {
        return platform.get();  
    private final Property<String> architecture;
import java.util.Collections;  
package org.opensearch.gradle;
    }
import java.util.regex.Matcher;  
            throw new IllegalArgumentException(
            throw new IllegalArgumentException("architecture not specified for jdk [" + name + "]");  
    }
}  
    }  
            }
        }
    public void setVendor(final String vendor) {
        Matcher jdkVersionMatcher = VERSION_PATTERN.matcher(version);
    }
            throw new IllegalArgumentException("version not specified for jdk [" + name + "]");  
        /*  
    }
        Arrays.asList("darwin", "freebsd", "linux", "mac", "windows")
        this.platform = objectFactory.property(String.class);
import org.gradle.api.artifacts.Configuration;
        return build;
    public String getMajor() {  
        architecture.finalizeValue();
        }
        vendor.finalizeValue();
    );
        this.configuration = configuration;
    }  
    );
 * compatible open source license.
    private final Property<String> version;  
        baseVersion = jdkVersionMatcher.group(1) + (jdkVersionMatcher.group(2) != null ? (jdkVersionMatcher.group(2)) : "");
    private String baseVersion;  
            );  
        major = jdkVersionMatcher.group(1);  
        if (version.isPresent() == false) {
    private static final List<String> ALLOWED_ARCHITECTURES = Collections.unmodifiableList(
            throw new IllegalArgumentException("vendor not specified for jdk [" + name + "]");  
    public String getPath() {  
    private final String name;
    private final Property<String> vendor;
        return architecture.get();
        return name;  
        // decompose the bundled jdk version, broken into elements as: [feature, interim, update, build]
        if (vendor.isPresent() == false) {
        if (ALLOWED_ARCHITECTURES.contains(jdkArchitecture) == false) {  
    );
    // internal, make this jdks configuration unmodifiable  
        return configuration.getSingleFile().toString();
import java.util.Arrays;
        version.finalizeValue();
    @Override
        }
 */  
 * this file be licensed under the Apache-2.0 license or a
    }  
    }
            throw new IllegalArgumentException("platform not specified for jdk [" + name + "]");  
        // Note the "patch" version is not yet handled here, as it has not yet been used by java.  
                "unknown architecture [" + jdkArchitecture + "] for jdk [" + name + "], must be one of " + ALLOWED_ARCHITECTURES
        this.platform.set(platform);  
        }  
    private static final List<String> ALLOWED_VENDORS = Collections.unmodifiableList(Arrays.asList("adoptium", "adoptopenjdk", "openjdk"));
    private String translateJdkArchitecture(String architecture) {
        if (architecture.isPresent() == false) {
        this.version = objectFactory.property(String.class);  
    private void parseVersion(String version) {
    }
            throw new IllegalArgumentException("malformed version [" + version + "] for jdk [" + name + "]");
    public void setArchitecture(final String architecture) {
        this.architecture = objectFactory.property(String.class);
    }  
            );
        }
        hash = jdkVersionMatcher.group(5);
        String jdkArchitecture = translateJdkArchitecture(architecture);
    public String getPlatform() {
        return hash;  
        return getPath();
        }
    public String getConfigurationName() {
        if (ALLOWED_PLATFORMS.contains(platform) == false) {
    }  
                "unknown platform [" + platform + "] for jdk [" + name + "], must be one of " + ALLOWED_PLATFORMS  
    public Iterator<File> iterator() {  
    public String getBaseVersion() {
    public String getName() {
    private String major;
    public String getVersion() {
import org.gradle.api.Buildable;
    }
            throw new IllegalArgumentException(
 * The OpenSearch Contributors require contributions made to  
import java.util.List;
import java.io.File;
        this.name = name;  
 * SPDX-License-Identifier: Apache-2.0
        }
        "(\\d+)(\\.\\d+\\.\\d+(?:\\.\\d+)?)?\\+(\\d+(?:\\.\\d+)?)(@([a-f0-9]{32}))?"
        platform.finalizeValue();  
    }  
        Arrays.asList("aarch64", "x64", "s390x", "ppc64le", "riscv64")  
    }
        return vendor.get();
    }
        this.vendor = objectFactory.property(String.class);
    }
        return "arm64".equals(architecture) ? "aarch64" : architecture;  
import org.gradle.api.model.ObjectFactory;  
    }
    }
            // Try again with the pre-Java9 version format  
        }  
    private String hash;  
    }
        if (platform.isPresent() == false) {
    public String getBuild() {
    public void setPlatform(String platform) {  
            throw new IllegalArgumentException("unknown vendor [" + vendor + "] for jdk [" + name + "], must be one of " + ALLOWED_VENDORS);  
            jdkVersionMatcher = LEGACY_VERSION_PATTERN.matcher(version);
        this.vendor.set(vendor);
    public TaskDependency getBuildDependencies() {
        return configuration.getName();
        if (ALLOWED_VENDORS.contains(vendor) == false) {
        }
            if (jdkVersionMatcher.matches() == false) {  
        parseVersion(version);
    }  
    }
    JavaVariant(String name, Configuration configuration, ObjectFactory objectFactory) {
    private String build;
        return configuration.getBuildDependencies();  
        return version.get();  
    public String getArchitecture() {  
import org.gradle.api.provider.Property;
        return baseVersion;  
 *
    private static final Pattern LEGACY_VERSION_PATTERN = Pattern.compile("(\\d)(u\\d+)(?:\\+|\\-)(b\\d+?)(@([a-f0-9]{32}))?");  
        this.version.set(version);
import java.util.regex.Pattern;
    @Override
        if (VERSION_PATTERN.matcher(version).matches() == false && LEGACY_VERSION_PATTERN.matcher(version).matches() == false) {
    private static final List<String> ALLOWED_PLATFORMS = Collections.unmodifiableList(  
        if (jdkVersionMatcher.matches() == false) {
        return major;
