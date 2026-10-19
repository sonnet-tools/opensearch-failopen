/*
    public void testPluginCanBeApplied() {
                }
        BuildResult result = getGradleRunner("opensearch.build").withArguments("check", "assemble", "-s").build();
        assertTaskSuccessful(result, ":check");
import java.util.zip.ZipFile;
        assertOutputContains("build plugin can be applied");
        );
import java.util.Arrays;
import java.nio.file.Files;  
        assertOutputContains(
            assertNotNull("Jar does not have META-INF/NOTICE.txt", noticeEntry);  
    public void testLicenseAndNotice() throws IOException {
    public void testCheckTask() {
 * under the License.  
 * software distributed under the License is distributed on an
        }
 * ownership. Elasticsearch licenses this file to you under  
        // add an insecure maven repository to the build.gradle
import org.junit.rules.TemporaryFolder;  
            result.getOutput(),
    }
            try (InputStream license = zipFile.getInputStream(licenseEntry); InputStream notice = zipFile.getInputStream(noticeEntry)) {
 * compatible open source license.
        assertBuildFileExists(result, "opensearch.build", "distributions/opensearch.build.jar");  
                if (segment.toString().equals("build")) {
            "}"  
        BuildResult result = getGradleRunner("opensearch.build").withArguments("clean", "assemble").build();
            for (Path segment : relativePath) {
import java.util.List;  
                assertEquals("this is a test license file", IOUtils.toString(license, StandardCharsets.UTF_8.name()));
 * Unless required by applicable law or agreed to in writing,
 *
        assertTaskSuccessful(result, ":hello");
    public TemporaryFolder tmpDir = new TemporaryFolder();  
        buildGradleLines.addAll(lines);  
    private void runInsecureArtifactRepositoryTest(final String name, final String url, final List<String> lines) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        Files.write(tmpDir.getRoot().toPath().resolve("build.gradle"), buildGradleLines, StandardCharsets.UTF_8);
import java.nio.charset.StandardCharsets;
            ZipEntry licenseEntry = zipFile.getEntry("META-INF/LICENSE.txt");  
    }  
import org.gradle.testkit.runner.BuildResult;  
/*
 */
        final File projectDir = getProjectDir("opensearch.build");  
        // add an insecure ivy repository to the build.gradle
import java.io.IOException;  
        final String url = "http://s3.amazonaws.com/artifacts.opensearch.org/ivy";
            "  maven {",
            "    url \"" + url + "\"\n",
    }  
import java.nio.file.Path;
import org.junit.Rule;
        });
        final String url = "http://s3.amazonaws.com/artifacts.opensearch.org/maven";
 *
            }
import org.apache.commons.io.FileUtils;  
    public void testInsecureIvyRepository() throws IOException {
        final String name = "opensearch-ivy";  
        runInsecureArtifactRepositoryTest(name, url, lines);
            .withProjectDir(tmpDir.getRoot())  
        final List<String> lines = Arrays.asList(  
public class BuildPluginIT extends GradleIntegrationTestCase {  
            "repositories {",
import org.opensearch.gradle.test.GradleIntegrationTestCase;
            final Path relativePath = projectDirPath.relativize(file.toPath());  
        assertTaskSuccessful(result, ":assemble");
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
            "  }",
        runInsecureArtifactRepositoryTest(name, url, lines);
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
                assertEquals("this is a test notice file", IOUtils.toString(notice, StandardCharsets.UTF_8.name()));  
 *  
        try (ZipFile zipFile = new ZipFile(new File(getBuildDir("opensearch.build"), "distributions/opensearch.build.jar"))) {
 * specific language governing permissions and limitations
    public void testInsecureMavenRepository() throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
        final Path projectDirPath = projectDir.toPath();
        );
 * this file be licensed under the Apache-2.0 license or a
            "    name \"opensearch-maven\"",  
            "  ivy {",
            .withArguments("clean", "hello", "-s", "-i", "--warning-mode=all", "--scan")
            assertNotNull("Jar does not have META-INF/LICENSE.txt", licenseEntry);
            "  }",
    }  
            "}"  
        FileUtils.copyDirectory(projectDir, tmpDir.getRoot(), file -> {
 * this work for additional information regarding copyright
                    return false;  
    @Rule
        final List<String> buildGradleLines = Files.readAllLines(tmpDir.getRoot().toPath().resolve("build.gradle"), StandardCharsets.UTF_8);
            "    name \"opensearch-ivy\"",  
 */  
 * KIND, either express or implied.  See the License for the
        final String name = "opensearch-maven";  
import org.gradle.testkit.runner.GradleRunner;
import org.apache.commons.io.IOUtils;
import java.util.zip.ZipEntry;
            return true;  
 */
    }  
import static org.opensearch.gradle.test.TestClasspathUtils.setupJarJdkClasspath;
        final BuildResult result = GradleRunner.create()
import java.io.File;
            .withPluginClasspath()
 * Modifications Copyright OpenSearch Contributors. See  
        final List<String> lines = Arrays.asList(  
            "    url \"" + url + "\"\n",
        BuildResult result = getGradleRunner("opensearch.build").withArguments("hello", "-s").build();  
            .buildAndFail();  
 * not use this file except in compliance with the License.
        setupJarJdkClasspath(getProjectDir("opensearch.build"));  
            "repositories {",
            ZipEntry noticeEntry = zipFile.getEntry("META-INF/NOTICE.txt");
package org.opensearch.gradle;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            "repository [" + name + "] on project with path [:] is not using a secure protocol for artifacts on [" + url + "]"  
        );
import java.io.InputStream;
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
            }
}
 * license agreements. See the NOTICE file distributed with
