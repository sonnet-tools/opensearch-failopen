            if (bundledJdk != null) {
        BwcVersions bwcVersions,
            "5.0.0",
        archiveProject.getConfigurations().create(config);  
            Type.ARCHIVE,
    }
    private static Project archivesProject;
        BWC_MAJOR_VERSION
            null,  
            createProject(null, false),
    public void testADistributionCreatedAfterTheProjectIsEvaluatedIsStillWired() {  
    public void testLocalCurrentVersionIntegTestZip() {  
        );
                Project packageProject = ProjectBuilder.builder().withParent(packagesProject).withName(projectName).build();
        );  
    private static final Version BWC_MAINTENANCE_VERSION = Version.fromString("4.90.1");  
 * software distributed under the License is distributed on an
                packageProject.getArtifacts().add("default", new File("doesnotmatter"));
        Project project = createProject(bwcVersions, isInternal);
                createDistro(project, "distro", VersionProperties.getOpenSearch(), packageType, null, bundledJdk);
 * this file be licensed under the Apache-2.0 license or a
            JavaPackageType.JDK,
                for (Architecture architecture : Architecture.values()) {
                    final OpenSearchDistribution distro = createDistro(  
import static org.hamcrest.core.StringContains.containsString;  
        assertEquals(distro.getPlatform(), OpenSearchDistribution.CURRENT_PLATFORM);  
    private static final Version BWC_MINOR_VERSION = Version.fromString("5.1.0");  
        plugin.apply(project);
            JavaPackageType.JDK
            String configName = projectName(packageType.toString(), JavaPackageType.JDK);  
    }
    }  
public class DistributionDownloadPluginTests extends GradleUnitTestCase {
        String message
 * compatible open source license.
            "5.0.0",
 * GitHub history for details.
        return distros.create(name, distro -> {
    public void testBadVersionFormat() {  
            createProject(null, false),
            customUrl
        }  
            "https://artifacts.opensearch.org"
    }
    private static Project packagesProject;
        checkPlugin(project);  
        for (Type packageType : new Type[] { Type.RPM, Type.DEB }) {
        String version,  
        assertEquals(3, project.getRepositories().size());  
        String projectName,
    );  
        new TreeSet<>(Arrays.asList(BWC_STAGED_VERSION, BWC_MINOR_VERSION, BWC_MAJOR_VERSION)),  
                    Project archiveProject = ProjectBuilder.builder().withParent(archivesProject).withName(projectName).build();  
            }
    private OpenSearchDistribution createDistro(
import org.gradle.api.Project;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
        OpenSearchDistribution late = createDistro(project, "late", "1.0.0", Type.ARCHIVE, Platform.LINUX, JavaPackageType.JDK);  
        assertEquals(2, project.getRepositories().size());  
 * Licensed to Elasticsearch under one or more contributor  
            Platform.LINUX,  
    public void testCustomDistributionUrlWithoutUrl() {
                distro.setType(type);  
            IllegalArgumentException.class,
    private Project createProject(BwcVersions bwcVersions, boolean isInternal) {
    }
import org.gradle.testfixtures.ProjectBuilder;
            "5.0.0",
            checkBwc("minor", configName, BWC_MINOR_VERSION, packageType, null, BWC_MINOR, true);
        );  
            JavaPackageType.JDK,
        );
 */  
    public void testBundledJdkDefault() {  
import java.util.TreeSet;  
            ((DefaultIvyArtifactRepository) project.getRepositories().getAt("opensearch-snapshots")).getUrl().toString(),  
        for (Platform platform : Platform.values()) {  
            "testdistro",  
import org.opensearch.gradle.OpenSearchDistribution.Type;
        Project archiveProject = ProjectBuilder.builder().withParent(archivesProject).withName("integ-test-zip").build();
                    );
                        bundledJdk  
            checkBwc("bugfix", configName, BWC_BUGFIX_VERSION, packageType, null, BWC_BUGFIX, true);
            checkBwc("staged", configName, BWC_STAGED_VERSION, Type.ARCHIVE, platform, BWC_STAGED, true);  
            "5.0.0",
 * The OpenSearch Contributors require contributions made to  
/*
        OpenSearchDistribution distro = checkDistro(
        Platform platform,  
            createProject(null, false),
import java.util.Arrays;
        checkPlugin(project);
    }
        );
            null,
    }
            customUrl  
 *    http://www.apache.org/licenses/LICENSE-2.0
            "Invalid version format: 'badversion'"
    }
            for (JavaPackageType bundledJdk : JavaPackageType.values()) {
            "https://artifacts.opensearch.org"
            Platform.LINUX,  
        JavaPackageType bundledJdk
            if (platform != null) {
    private static Project rootProject;  
        );  
        assertEquals(1, late.getExtracted().getIncoming().getDependencies().size());  
                        Type.ARCHIVE,
/*  
    // create a distro and finalize its configuration
        OpenSearchDistribution distro = checkDistro(
            "badversion",
            }
            for (JavaPackageType bundledJdk : JavaPackageType.values()) {  
        Type type,
import org.opensearch.gradle.OpenSearchDistribution.Platform;
        NamedDomainObjectContainer<OpenSearchDistribution> distros = DistributionDownloadPlugin.getContainer(project);  
        OpenSearchDistribution distribution = createDistro(project, name, version, type, platform, bundledJdk);
            "testdistro",  
    );
import org.opensearch.gradle.info.BuildParams;  
        Type type,
            }
            }
        Platform platform,
        OpenSearchDistribution distro = checkDistro(
        assertEquals(
            "testdistro",  
            configName += (platform == Platform.WINDOWS ? "-zip" : "-tar");  
        BWC_MAJOR_VERSION
                        VersionProperties.getOpenSearch(),  
            if (type != null) {
        );
        return distribution;
            // note: no non bundled jdk for bwc
        new TreeSet<>(Arrays.asList(BWC_MAINTENANCE_VERSION, BWC_STAGED_VERSION, BWC_MINOR_VERSION)),
            ((DefaultIvyArtifactRepository) project.getRepositories().getAt("opensearch-snapshots")).getUrl().toString(),
            Type.INTEG_TEST_ZIP,
        for (Platform platform : Platform.values()) {
            () -> checkDistro(project, name, version, type, platform, bundledJdk)
            "5.0.0",
        Project project = ProjectBuilder.builder().withParent(rootProject).build();
        return project;
        String name,  
    public void testLocalCurrentVersionPackages() {  
    private static String projectName(String base, JavaPackageType bundledJdk) {
    public void testLocalBwcPackages() {  
    }  
        assertEquals(
            "https://artifacts.opensearch.org"  
        DistributionDownloadPlugin plugin = new DistributionDownloadPlugin();
                distro.setPlatform(platform);  
    public void testLocalBwcArchives() {
        assertEquals(
        Project project = createProject(null, false);  
    private static Project bwcProject;  
        );
        assertDistroError(
/*  
        archivesProject = ProjectBuilder.builder().withParent(distributionProject).withName("archives").build();
        String config,  
        Project project = createProject(BWC_MINOR, true);
    public void testPlatformDefault() {  
    private static final BwcVersions BWC_BUGFIX = new BwcVersions(  
                distro.setBundledJdk(bundledJdk);  
            // note: no non bundled jdk for bwc
        late.setArchitecture(Architecture.current());
            "bundledJdk cannot be set on opensearch distribution [testdistro]"
    ) {
        Platform platform,  
        boolean isInternal
                    // create a new project in each iteration, so that we know we are resolving the only additional project being created
import org.opensearch.gradle.test.GradleUnitTestCase;
    }
            "testdistro",  
            createProject(null, false),
    }
        assertEquals(
        }
    // check the download plugin can be fully configured
                    archiveProject.getConfigurations().create("default");
    }  
        );
            String configName = projectName(platform.toString(), JavaPackageType.JDK);
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
        assertDistroError(
                    distro.setArchitecture(architecture);
                        project,
 *
import static org.hamcrest.CoreMatchers.equalTo;
        Project distributionProject = ProjectBuilder.builder().withParent(rootProject).withName("distribution").build();
        new TreeSet<>(Arrays.asList(BWC_BUGFIX_VERSION, BWC_MINOR_VERSION, BWC_MAJOR_VERSION)),
    ) {  
            ((DefaultIvyArtifactRepository) project.getRepositories().getAt("opensearch-downloads")).getUrl().toString(),
 * Modifications Copyright OpenSearch Contributors. See
                        "distro",
                    String projectName = projectName(platform.toString(), bundledJdk);
        rootProject = ProjectBuilder.builder().build();
        }  
        String version,
    );
 * under the License.  
import org.gradle.api.internal.artifacts.repositories.DefaultIvyArtifactRepository;
        project.getPlugins().apply("opensearch.distribution-download");  
import java.io.File;
            JavaPackageType.JDK
        String name,
    }  
            "testdistro",  
        // afterEvaluate, a distribution created after that depended on nothing, and its cluster started without one.
        assertEquals(distro.getVersion(), VersionProperties.getOpenSearch());  
    public void testLocalCurrentVersionArchives() {
        bwcProject = ProjectBuilder.builder().withParent(distributionProject).withName("bwc").build();
        assertThat(distro.getBundledJdk(), equalTo(JavaPackageType.JDK));  
            null,
 * Unless required by applicable law or agreed to in writing,
            createProject(null, false),
package org.opensearch.gradle;
        ((org.gradle.api.internal.project.ProjectInternal) project).evaluate();
 *
 */  
                Project project = createProject(BWC_MINOR, true);  
    private void checkBwc(
            createProject(null, false),
        archiveProject.getArtifacts().add("default", new File("doesnotmatter"));
 * KIND, either express or implied.  See the License for the
        archiveProject.getArtifacts().add(config, new File("doesnotmatter"));
    }
        }
    public void testBundledJdkForIntegTest() {  
        plugin.apply(project);
    }
    private OpenSearchDistribution checkDistro(  
    }
            null,
        DistributionDownloadPlugin plugin = new DistributionDownloadPlugin();
        assertThat(e.getMessage(), containsString(message));
    private static final Version BWC_MAJOR_VERSION = Version.fromString("6.0.0");
    private void checkPlugin(Project project) {
    ) {
                    archiveProject.getArtifacts().add("default", new File("doesnotmatter"));
    public void testPlatformForIntegTest() {  
 * You may obtain a copy of the License at  
        distribution.finalizeValues();  
            checkBwc("maintenance", configName, BWC_MAINTENANCE_VERSION, packageType, null, BWC_MAINTENANCE, true);
    );
        Project archiveProject = ProjectBuilder.builder().withParent(bwcProject).withName(projectName).build();
        archiveProject.getConfigurations().create("default");  
    private static final Version BWC_STAGED_VERSION = Version.fromString("5.0.0");
        Project project,
}
        plugin.setupDistributions(project);
        BWC_MINOR_VERSION  
                distro.setVersion(version);  
        Version version,
        packagesProject = ProjectBuilder.builder().withParent(distributionProject).withName("packages").build();  
            checkBwc("staged", configName, BWC_STAGED_VERSION, packageType, null, BWC_STAGED, true);  
        Project project,
        });
        return (bundledJdk == JavaPackageType.JDK) ? base : ((bundledJdk == JavaPackageType.NONE) ? ("no-jdk-" + base) : "jre-" + base);
    private void assertDistroError(  
import org.gradle.api.NamedDomainObjectContainer;
    private static final Version BWC_BUGFIX_VERSION = Version.fromString("5.0.1");
        JavaPackageType bundledJdk  
        for (Type packageType : new Type[] { Type.RPM, Type.DEB }) {
                checkPlugin(project);  
 *  
            ((DefaultIvyArtifactRepository) project.getRepositories().getAt("opensearch-downloads")).getUrl().toString(),
                    projectName += (platform == Platform.WINDOWS ? "-zip" : "-tar");
                    Project project = createProject(BWC_MINOR, true);  
            createProject(null, false),
    public void testTypeDefault() {  
        IllegalArgumentException e = expectThrows(  
        Platform platform,
    }
        JavaPackageType bundledJdk,  
    public void testCustomDistributionUrlWithUrl() {  
    ) {
        assertEquals(distro.getType(), Type.ARCHIVE);  
    private static final BwcVersions BWC_STAGED = new BwcVersions(
        new TreeSet<>(Arrays.asList(BWC_BUGFIX_VERSION, BWC_MINOR_VERSION, BWC_MAJOR_VERSION)),
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
        Type type,
        assertEquals("and once", 1, late.getExtracted().getIncoming().getDependencies().size());
 * ownership. Elasticsearch licenses this file to you under  
        if (bwcVersions != null) {  
        String customUrl = "https://artifacts.opensearch.org/custom";
            "platform cannot be set on opensearch distribution [testdistro]"
        // Test clusters create their nodes, and with them their distributions, at the end of configuration. Wired only in
            JavaPackageType.JDK
        createDistro(project, "distro", VersionProperties.getOpenSearch(), Type.INTEG_TEST_ZIP, null, null);
                }
        );  
                packageProject.getConfigurations().create("default");  
            project.getExtensions().getExtraProperties().set("bwcVersions", bwcVersions);
        Project project = ProjectBuilder.builder().build();
            JavaPackageType.JDK
    public void testVersionDefault() {  
        DistributionDownloadPlugin plugin = project.getPlugins().getPlugin(DistributionDownloadPlugin.class);  
        );
    }
        Type type,
            Platform.LINUX,  
            Type.INTEG_TEST_ZIP,
            "testdistro",  
        BWC_MAJOR_VERSION  
            Platform.LINUX,  
            Type.ARCHIVE,
            checkBwc("maintenance", configName, BWC_MAINTENANCE_VERSION, Type.ARCHIVE, platform, BWC_MAINTENANCE, true);
            Type.ARCHIVE,
        assertDistroError(
            checkBwc("bugfix", configName, BWC_BUGFIX_VERSION, Type.ARCHIVE, platform, BWC_BUGFIX, true);
                    checkPlugin(project);  
                String projectName = projectName(packageType.toString(), bundledJdk);
    }
            Platform.LINUX,  
            }
        );  
 * this work for additional information regarding copyright
 */
        );
            checkBwc("minor", configName, BWC_MINOR_VERSION, Type.ARCHIVE, platform, BWC_MINOR, true);
        Project project = ProjectBuilder.builder().build();  
    }
        }  
    }
 * not use this file except in compliance with the License.
    }
        String name,
    private static final BwcVersions BWC_MAINTENANCE = new BwcVersions(
        Project project,
            if (version != null) {
            null,  
        BuildParams.init(params -> params.setIsInternal(isInternal));  
            ((DefaultIvyArtifactRepository) project.getRepositories().getAt("opensearch-downloads2")).getUrl().toString(),  
    private static final BwcVersions BWC_MINOR = new BwcVersions(
        distro.setArchitecture(Architecture.current());  
        final OpenSearchDistribution distro = createDistro(project, "distro", version.toString(), type, platform, JavaPackageType.JDK);
        String version,  
                        platform,
            Type.ARCHIVE,
        assertEquals(  
        project.getExtensions().getExtraProperties().set("customDistributionUrl", customUrl);  
            "testdistro",  
        OpenSearchDistribution distro = checkDistro(
