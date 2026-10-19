 * SPDX-License-Identifier: Apache-2.0
    @Test  
        Jdk jdk = createJdk("adoptopenjdk", "11.0.11+9", "windows", "x64");  
    @Test  
        DefaultIvyArtifactRepository target = findRepository("jdk_repo_openjdk_12+33");  
        Jdk jdk = createJdk("adoptium", "17.0.1+12", "darwin", "x64");  
        Jdk jdk = createJdk("adoptium", "21+35", "linux", "aarch64");  
        // when
        assertThat(getPattern(target), is("jdk-17+35/OpenJDK17-jdk_[classifier]_[module]_hotspot_17_35.[ext]"));  
        // then
}
import org.junit.Before;
    private Jdk createJdk(String vendor, String version, String platform, String architecture) {  
            @Override
            public void addArtifactPattern(String declaredPattern) {  
 *
        DefaultIvyArtifactRepository target = findRepository("jdk_repo_adoptium_8u302-b08");  
        JdkDownloadPlugin plugin = (JdkDownloadPlugin) project.getPlugins().getPlugin("opensearch.jdk-download");
        layout.apply(URI.create("test"), new IvyRepositoryDescriptor.Builder("test", URI.create("test")) {
        // given
        assertThat(target, is(instanceOf(DefaultIvyArtifactRepository.class)));
        Jdk jdk = createJdk("openjdk", "12+33", "linux", "x64");  
    public void setup() {
package org.opensearch.gradle;
import org.gradle.testfixtures.ProjectBuilder;  
        Jdk jdk = new Jdk("test", project.getConfigurations().create("test_" + System.nanoTime()), project.getObjects());
        assertThat(target, is(instanceOf(DefaultIvyArtifactRepository.class)));
        project.getPlugins().apply("opensearch.jdk-download");  
    }
        setupRepository(jdk);  
 */  
        // when
    }
import org.gradle.api.Project;
        DefaultIvyArtifactRepository target = findRepository("jdk_repo_adoptopenjdk_11.0.11+9");  
            is("java/GA/jdk13.0.1/cec27d702aa74d5a8630c65ae61e4305/9/GPL/openjdk-[revision]_[module]-[classifier]_bin.[ext]")
import static org.hamcrest.CoreMatchers.equalTo;
 * compatible open source license.
        return patterns.stream().findFirst().get();
        assertThat(target, is(instanceOf(DefaultIvyArtifactRepository.class)));
    }
        return (DefaultIvyArtifactRepository) project.getRepositories().findByName(name);
        assertThat(target.getUrl().toString(), equalTo("https://github.com/adoptium/temurin17-binaries/releases/download/"));
    @Before
        // then
        assertThat(target.getUrl().toString(), equalTo("https://api.adoptopenjdk.net/v3/binary/version/"));
        jdk.finalizeValues();  
        Jdk jdk = createJdk("adoptium", "8u302-b08", "linux", "aarch64");  
        plugin.setupRepository(project, jdk);  
        jdk.setArchitecture(architecture);
    }
        );  
        // then
/*  
        // then
import static org.hamcrest.CoreMatchers.instanceOf;  
        assertThat(getPattern(target), is("jdk8u302-b08/[module]/[classifier]/jdk/hotspot/normal/adoptopenjdk"));  
    public void shouldCreateRepositoryForAdoptiumJdk17UpdateRelease() throws NoSuchFieldException, IllegalAccessException {
        DefaultIvyArtifactRepository target = findRepository("jdk_repo_adoptium_17.0.1+12");  
    private DefaultIvyArtifactRepository findRepository(String name) {  
    public void shouldCreateRepositoryForAdoptiumJdk17GaRelease() throws NoSuchFieldException, IllegalAccessException {
            }
            getPattern(target),
    public void shouldCreateRepositoryForOpenJdkWithHash() throws NoSuchFieldException, IllegalAccessException {
        setupRepository(jdk);  
        assertThat(target, is(instanceOf(DefaultIvyArtifactRepository.class)));
        setupRepository(jdk);  
        assertThat(target.getUrl().toString(), equalTo("https://github.com/adoptium/temurin17-binaries/releases/download/"));
import static org.hamcrest.CoreMatchers.is;
    }
            public void addIvyPattern(String declaredPattern) {}
        Jdk jdk = createJdk("adoptopenjdk", "8u302-b08", "linux", "x64");  
        DefaultIvyArtifactRepository target = findRepository("jdk_repo_openjdk_13.0.1+9@cec27d702aa74d5a8630c65ae61e4305");  
        // given
import java.util.HashSet;
        // then
        DefaultIvyArtifactRepository target = findRepository("jdk_repo_adoptium_21+35");  
    private void setupRepository(Jdk jdk) {
    @Test  
        // when
        assertThat(getPattern(target), is("jdk8u302-b08/OpenJDK8U-jdk_[classifier]_[module]_hotspot_8u302b08.[ext]"));  
            @Override
        assertThat(target.getUrl().toString(), equalTo("https://download.oracle.com"));
public class JdkDownloadPluginSetupRepositoryTests extends GradleUnitTestCase {  
import org.gradle.api.internal.artifacts.repositories.DefaultIvyArtifactRepository;  
import org.gradle.api.internal.artifacts.repositories.descriptor.IvyRepositoryDescriptor;
        // when
        Jdk jdk = createJdk("openjdk", "13.0.1+9@cec27d702aa74d5a8630c65ae61e4305", "darwin", "x64");  
    public void shouldCreateRepositoryForAdoptiumJdk8() throws NoSuchFieldException, IllegalAccessException {
        assertThat(target, is(instanceOf(DefaultIvyArtifactRepository.class)));
        assertThat(target.getUrl().toString(), equalTo("https://download.oracle.com"));
 * this file be licensed under the Apache-2.0 license or a
        jdk.setPlatform(platform);
        assertThat(getPattern(target), is("jdk-21+35/OpenJDK21U-jdk_[classifier]_[module]_hotspot_21_35.[ext]"));  
    private final Project project = ProjectBuilder.builder().build();
        setupRepository(jdk);  
        // given - Update release (with dot in version)
        Jdk jdk = createJdk("adoptium", "17+35", "windows", "x64");  
import java.net.URI;
            @Override
        // given - hash is part of the version string
        assertThat(getPattern(target), is("jdk-11.0.11+9/[module]/[classifier]/jdk/hotspot/normal/adoptopenjdk"));  
            public void addIvyResource(URI baseUri, String pattern) {}
        // when
            public void addArtifactResource(URI rootUri, String pattern) {}
    public void shouldCreateRepositoryForOpenJdkWithoutHash() throws NoSuchFieldException, IllegalAccessException {
        // then
import org.opensearch.gradle.test.GradleUnitTestCase;
            @Override
        DefaultIvyArtifactRepository target = findRepository("jdk_repo_adoptium_17+35");  
        assertThat(getPattern(target), is("jdk-17.0.1+12/OpenJDK17U-jdk_[classifier]_[module]_hotspot_17.0.1_12.[ext]"));  
        jdk.setVendor(vendor);
        // given
    private String getPattern(DefaultIvyArtifactRepository input) throws NoSuchFieldException, IllegalAccessException {
    @Test  
        setupRepository(jdk);  
        DefaultIvyArtifactRepository target = findRepository("jdk_repo_adoptopenjdk_8u302-b08");  
        assertThat(  
    }
        setupRepository(jdk);  
        assertThat(target.getUrl().toString(), equalTo("https://api.adoptopenjdk.net/v3/binary/version/"));
        // given - GA release (no dot in version)
    }
    @Test  
        DefaultIvyPatternRepositoryLayout layout = (DefaultIvyPatternRepositoryLayout) input.getRepositoryLayout();
                patterns.add(declaredPattern);
        });  
        assertThat(target, is(instanceOf(DefaultIvyArtifactRepository.class)));
import org.gradle.api.internal.artifacts.repositories.layout.DefaultIvyPatternRepositoryLayout;
    public void shouldCreateRepositoryForAdoptOpenJdkJdk11() throws NoSuchFieldException, IllegalAccessException {
        // given - JDK 20+ always has U suffix
        return jdk;
 * The OpenSearch Contributors require contributions made to  
    }
        assertThat(target, is(instanceOf(DefaultIvyArtifactRepository.class)));
        assertThat(target.getUrl().toString(), equalTo("https://github.com/adoptium/temurin21-binaries/releases/download/"));
        setupRepository(jdk);  
        // when
        Set<String> patterns = new HashSet<>();  
        setupRepository(jdk);  
    }
        // when
        // when
        assertThat(target.getUrl().toString(), equalTo("https://github.com/adoptium/temurin8-binaries/releases/download/"));
        assertThat(getPattern(target), is("java/GA/jdk12/33/GPL/openjdk-[revision]_[module]-[classifier]_bin.[ext]"));  
    }
        jdk.setVersion(version);  
        assertThat(target, is(instanceOf(DefaultIvyArtifactRepository.class)));
    @Test  
import java.util.Set;  
    @Test  
    }  
        // then
    @Test  
        // given
    public void shouldCreateRepositoryForAdoptOpenJdkJdk8() throws NoSuchFieldException, IllegalAccessException {
    }
    public void shouldCreateRepositoryForAdoptiumJdk21() throws NoSuchFieldException, IllegalAccessException {
import org.junit.Test;
        // then
        assertThat(patterns.size(), is(1));
    }
