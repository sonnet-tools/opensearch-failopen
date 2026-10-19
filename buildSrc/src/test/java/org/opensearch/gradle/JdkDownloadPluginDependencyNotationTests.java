        project.getPlugins().apply("opensearch.jdk-download");  
        jdk.setPlatform(platform);
 * this file be licensed under the Apache-2.0 license or a
        Jdk jdkAarch64 = createJdk("adoptium", "17.0.1+12", "linux", "aarch64");  
        // then
    @Test  
    }
    @Test  
        // given - aarch64 architecture
        assertThat(target, equalTo("adoptium_21:windows:21.0.2:x64@zip"));  
        Jdk jdk = createJdk("openjdk", "12+33", "mac", "x64");  
        // given
 * The OpenSearch Contributors require contributions made to  
    public void shouldUseOsxPlatformForDarwinWithOpenjdk() {
    private final Project project = ProjectBuilder.builder().build();
        // then
    public void setup() {
        assertThat(target, equalTo("adoptium_17:mac:17.0.1:x64@tar.gz"));  
        // then
        String target = JdkDownloadPlugin.dependencyNotation(jdk);  
    @Test  
        String target = JdkDownloadPlugin.dependencyNotation(jdk);  
import org.junit.Before;
    public void shouldFormatCompleteNotationCorrectly() {
        // given
 */  
        // given
        // when
        Jdk jdk = createJdk("openjdk", "13.0.1+9@cec27d702aa74d5a8630c65ae61e4305", "darwin", "x64");  
    @Before
        // then
import org.opensearch.gradle.test.GradleUnitTestCase;
    }
        // when
        // when
    public void shouldUseWindowsPlatformAsIsWithZipExtension() {
        // then
        String target = JdkDownloadPlugin.dependencyNotation(jdk);  
        Jdk jdk = createJdk("adoptium", "17.0.1+12", "darwin", "x64");  
        // when
        // given - x64 architecture
        String target = JdkDownloadPlugin.dependencyNotation(jdk);  
        // given
        // then
        Jdk jdk = createJdk("adoptium", "21+35", "mac", "aarch64");  
    @Test  
        // when
        return jdk;
        // given
 * compatible open source license.
        Jdk jdk = createJdk("adoptium", "17+35", "windows", "x64");  
    }
        // when
    }
        // given
    public void shouldIncludeArchitectureInNotation() {
 *
        // then
        assertThat(target, equalTo("openjdk_12:osx:12:x64@tar.gz"));  
    @Test  
        assertThat(target, equalTo("adoptium_8:linux:8u302:aarch64@tar.gz"));  
import org.junit.Test;
import org.gradle.api.Project;
        assertThat(target, equalTo("adoptopenjdk_8:linux:8u302:x64@tar.gz"));  
        String target = JdkDownloadPlugin.dependencyNotation(jdk);  
        Jdk jdk = createJdk("adoptopenjdk", "8u302-b08", "linux", "x64");  
import static org.hamcrest.CoreMatchers.equalTo;
    public void shouldUseMacPlatformForDarwinWithAdoptium() {
    }
public class JdkDownloadPluginDependencyNotationTests extends GradleUnitTestCase {  
    @Test  
        // when
        String targetAarch64 = JdkDownloadPlugin.dependencyNotation(jdkAarch64);  
        assertThat(target, equalTo("adoptopenjdk_11:mac:11.0.11:x64@tar.gz"));  
}  
    }
        jdk.setVersion(version);  
        Jdk jdk = createJdk("adoptium", "21.0.2+13", "windows", "x64");  
/*  
        // then
    }
        // then
        Jdk jdkX64 = createJdk("adoptium", "17.0.1+12", "linux", "x64");  
    @Test  
    public void shouldUseMacPlatformForDarwinWithAdoptOpenJdk() {
        Jdk jdk = createJdk("adoptium", "8u302-b08", "linux", "aarch64");  
    }
    }
        // when
        String target = JdkDownloadPlugin.dependencyNotation(jdk);  
        Jdk jdk = createJdk("adoptopenjdk", "11.0.11+9", "darwin", "x64");  
        assertThat(target, equalTo("openjdk_13:osx:13.0.1:x64@tar.gz"));  
        // when
    }
    private Jdk createJdk(String vendor, String version, String platform, String architecture) {  
        String target = JdkDownloadPlugin.dependencyNotation(jdk);  
    public void shouldUseTarGzExtensionForNonWindowsPlatforms() {
        String targetX64 = JdkDownloadPlugin.dependencyNotation(jdkX64);  
        // when
        // then
 * SPDX-License-Identifier: Apache-2.0
        Jdk jdk = new Jdk("test", project.getConfigurations().create("test_" + System.nanoTime()), project.getObjects());
    public void shouldUseMacPlatformForMacWithAdoptium() {
    public void shouldUseLinuxPlatformAsIs() {
        jdk.finalizeValues();  
    public void shouldUseOsxPlatformForMacWithOpenjdk() {
        assertThat(targetX64, equalTo("adoptium_17:linux:17.0.1:x64@tar.gz"));  
import org.gradle.testfixtures.ProjectBuilder;  
    }
        // given
    }
        // then - format: groupName:platform:baseVersion:architecture@extension
        jdk.setVendor(vendor);
        jdk.setArchitecture(architecture);
        // given
        String target = JdkDownloadPlugin.dependencyNotation(jdk);  
        assertThat(target, equalTo("adoptium_17:windows:17:x64@zip"));  
    @Test  
    @Test  
        // given
    @Test  
        assertThat(targetAarch64, equalTo("adoptium_17:linux:17.0.1:aarch64@tar.gz"));  
        // when
        assertThat(target, equalTo("adoptium_21:mac:21:aarch64@tar.gz"));  
package org.opensearch.gradle;
        String target = JdkDownloadPlugin.dependencyNotation(jdk);  
