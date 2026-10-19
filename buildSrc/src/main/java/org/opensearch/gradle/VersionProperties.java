            case "arm64":
    private static final String bundledJdkLinux_riscv64;
package org.opensearch.gradle;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (String property : props.stringPropertyNames()) {
        try (InputStream propsStream = VersionProperties.class.getResourceAsStream("/version.properties")) {  
 * Accessor for shared dependency versions used by opensearch, namely the opensearch and lucene versions.  
import java.util.HashMap;
                return bundledJdkLinux_riscv64;
    public static String getOpenSearch() {
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Properties;  
    }  
        bundledJdkLinux_riscv64 = props.getProperty("bundled_jdk_linux_riscv64", bundledJdkLinux);  
            case "mac":
    private static final String bundledJdkFreeBSD;  
    }
 */  
            case "ppc64le":
        return versions;  
 * Modifications Copyright OpenSearch Contributors. See  
        Properties props = getVersionProperties();  
            case "freebsd":  
    private static String getBundledJdkLinux(String arch) {  
        bundledJdkDarwin = props.getProperty("bundled_jdk_darwin", bundledJdk);
    private static final Map<String, String> versions = new HashMap<String, String>();  
    }
        }
    public static boolean isOpenSearchSnapshot() {
        Properties props = new Properties();
        bundledJdkVendor = props.getProperty("bundled_jdk_vendor");  
            case "s390x":
    private static Properties getVersionProperties() {
                return bundledJdkDarwin;
        final String bundledJdk = props.getProperty("bundled_jdk");
    static {
    private static final String bundledJdkLinux_s390x;
 * Licensed to Elasticsearch under one or more contributor  
        return props;
    private static final String bundledJdkLinux_ppc64le;  
        } catch (IOException e) {
                return bundledJdkLinux_ppc64le;
    }
/**
                return bundledJdkLinux_s390x;  
            case "darwin": // fall through  
        bundledJdkWindows = props.getProperty("bundled_jdk_windows", bundledJdk);
 */
 */
 * license agreements. See the NOTICE file distributed with
        }
}  
                throw new IllegalArgumentException("unknown platform [" + arch + "] for 'linux' platform");  
            props.load(propsStream);
                return getBundledJdkLinux(arch);  
        return opensearch;
        if (StringUtils.isBlank(arch)) {
    public static String getBundledJdk(final String platform) {
    private static final String bundledJdkLinux;
    private static final String lucene;
            case "windows":
            if (propsStream == null) {
                throw new IllegalStateException("/version.properties resource missing");
 * KIND, either express or implied.  See the License for the
 *  
        bundledJdkFreeBSD = props.getProperty("bundled_jdk_freebsd", bundledJdk);  
    private static final String bundledJdkVendor;
        }  
    private static final String bundledJdkLinux_arm64;  
 * this work for additional information regarding copyright
 *
        return opensearch.endsWith("-SNAPSHOT");  
                throw new IllegalArgumentException("unknown platform [" + platform + "]");
            default:  
        bundledJdkLinux_ppc64le = props.getProperty("bundled_jdk_linux_ppc64le", bundledJdkLinux);
        bundledJdkLinux = props.getProperty("bundled_jdk_linux", bundledJdk);
        return getBundledJdk(platform, null);  
        // Bundled JDKs per architecture (linux platform)
            }  
 * software distributed under the License is distributed on an
import org.apache.commons.lang3.StringUtils;  
            return bundledJdkLinux;
                return bundledJdkLinux_arm64;
                return bundledJdkLinux_x64;
 * not use this file except in compliance with the License.
        }
    }  
 * You may obtain a copy of the License at  
    private static final String bundledJdkDarwin;
        return Version.fromString(opensearch);  
    public static String getBundledJdkVendor() {
        bundledJdkLinux_x64 = props.getProperty("bundled_jdk_linux_x64", bundledJdkLinux);  
 * ownership. Elasticsearch licenses this file to you under  
    private static final String bundledJdkWindows;
 * this file be licensed under the Apache-2.0 license or a
/*
                return bundledJdkWindows;
            versions.put(property, props.getProperty(property));  
 * GitHub history for details.
    private static final String opensearch;  
    }  
    public static String getBundledJdk(final String platform, final String arch) {
        bundledJdkLinux_arm64 = props.getProperty("bundled_jdk_linux_arm64", bundledJdkLinux);
 * SPDX-License-Identifier: Apache-2.0
    private static final String bundledJdkLinux_x64;
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
        return lucene;
 */
        return getBundledJdk(platform, arch);
        return bundledJdkVendor;
 *
        }
    public static String getLucene() {  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    public static Version getOpenSearchVersion() {
import java.io.InputStream;  
            case "linux":
import java.util.Map;
            throw new IllegalStateException("Failed to load version properties", e);  
        opensearch = props.getProperty("opensearch");
/*  
            case "aarch64":  
        lucene = props.getProperty("lucene");
import java.io.IOException;
    }  
            case "riscv64":  
        switch (arch) {
                return bundledJdkFreeBSD;
    }
public class VersionProperties {
 * compatible open source license.
    public static Map<String, String> getVersions() {
    }
        switch (platform) {
        bundledJdkLinux_s390x = props.getProperty("bundled_jdk_linux_s390x", bundledJdkLinux);
            case "x64":  
/*
            default:
 * under the License.  
    }
    public static String getBundledJre(final String platform, final String arch) {  
