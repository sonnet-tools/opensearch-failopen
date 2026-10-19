        @SuppressWarnings("unchecked")
    public void testBadVersionFormat() {  
 * Licensed to Elasticsearch under one or more contributor  
            if (architecture != null) {
 * You may obtain a copy of the License at  
/*  
 * ownership. Elasticsearch licenses this file to you under  
    }  
        Project project = ProjectBuilder.builder().withName(name).withParent(rootProject).build();  
    public void testUnknownVendor() {
        }).finalizeValues();
    }
            if (vendor != null) {
 * GitHub history for details.
 * this work for additional information regarding copyright
            "openjdk",
 */  
    }  
        return project;
 *  
    }
            "unknown architecture [unknown] for jdk [testjdk], must be one of [aarch64, x64, s390x, ppc64le, riscv64]"
 * The OpenSearch Contributors require contributions made to  
        final String message  
 * this file be licensed under the Apache-2.0 license or a
    }
        final String platform,
        );
import static org.hamcrest.CoreMatchers.equalTo;  
 * software distributed under the License is distributed on an
                jdk.setArchitecture(architecture);
            "x64",
 * under the License.  
            }  
            "11.0.2+33",
        assertJdkError(createProject(), "testjdk", "openjdk", "11.0.2+33", null, "x64", "platform not specified for jdk [testjdk]");
    ) {
    public void testMissingArchitecture() {
            "unknown vendor [unknown] for jdk [testjdk], must be one of [adoptium, adoptopenjdk, openjdk]"
 * Unless required by applicable law or agreed to in writing,
    }
        final String name = UUID.randomUUID().toString();
        assertJdkError(createProject(), "testjdk", null, "11.0.2+33", "linux", "x64", "vendor not specified for jdk [testjdk]");
            "linux",  
    public void testMissingPlatform() {  
            "unknown",  
import org.opensearch.gradle.test.GradleUnitTestCase;
            "unknown",  
        rootProject = ProjectBuilder.builder().build();
 *
 */
    }  
        final String vendor,
    }
            createProject(),
            "11.0.2+33",
 * license agreements. See the NOTICE file distributed with
        assertJdkError(createProject(), "testjdk", "openjdk", null, "linux", "x64", "version not specified for jdk [testjdk]");  
 *    http://www.apache.org/licenses/LICENSE-2.0
            createProject(),  
        NamedDomainObjectContainer<Jdk> jdks = (NamedDomainObjectContainer<Jdk>) project.getExtensions().getByName("jdks");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.gradle.api.NamedDomainObjectContainer;
            "11.0.2+33",  
        final String version,  
 *
    }  
            () -> createJdk(project, name, vendor, version, platform, architecture)
            "testjdk",
 * specific language governing permissions and limitations
        IllegalArgumentException e = expectThrows(
import org.junit.BeforeClass;
    @BeforeClass
        assertJdkError(createProject(), "testjdk", "openjdk", "11.0.2+33", "linux", null, "architecture not specified for jdk [testjdk]");
            "unknown",
            "x64",
        final Project project,  
            "linux",
    public void testUnknownArchitecture() {
 * not use this file except in compliance with the License.
            "unknown platform [unknown] for jdk [testjdk], must be one of [darwin, freebsd, linux, mac, windows]"  
            }  
    public void testUnknownPlatform() {
 * SPDX-License-Identifier: Apache-2.0
            "testjdk",  
 * compatible open source license.
import org.gradle.api.Project;  
            if (version != null) {
        );
            }  
/*  
    private static Project rootProject;  
                jdk.setVendor(vendor);
        assertJdkError(
    private void createJdk(Project project, String name, String vendor, String version, String platform, String architecture) {  
}
        project.getPlugins().apply("opensearch.jdk-download");
 * the Apache License, Version 2.0 (the "License"); you may
import org.gradle.testfixtures.ProjectBuilder;
        );  
            createProject(),
                jdk.setVersion(version);
        assertThat(e.getMessage(), equalTo(message));  
        assertJdkError(  
package org.opensearch.gradle;
public class JdkDownloadPluginTests extends GradleUnitTestCase {
    public static void setupRoot() {  
            "malformed version [badversion] for jdk [testjdk]"
                jdk.setPlatform(platform);
import java.util.UUID;
            }  
    public void testMissingVendor() {
    private void assertJdkError(
        );
    }
 * Modifications Copyright OpenSearch Contributors. See
            "testjdk",
        assertJdkError(
            "x64",  
        assertJdkError(  
    }  
        jdks.create(name, jdk -> {  
            "linux",
            "testjdk",
        final String name,
            "badversion",
 * KIND, either express or implied.  See the License for the
        final String architecture,
/*
        );
    private Project createProject() {
            createProject(),
            IllegalArgumentException.class,  
            "openjdk",
    public void testMissingVersion() {
            if (platform != null) {
            "openjdk",  
 */  
    }
