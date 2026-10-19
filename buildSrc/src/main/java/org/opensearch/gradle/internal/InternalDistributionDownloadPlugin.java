                break;
import org.gradle.api.NamedDomainObjectContainer;
        }
        return "opensearch-distribution-snapshot:opensearch:"
        resolutions.register("bwc", distributionResolution -> distributionResolution.setResolver((project, distribution) -> {  
                    // Download pre-built SNAPSHOT artifacts instead of building from source
                            + "') "
                "Plugin 'opensearch.internal-distribution-download' is not supported. "
        if (distribution.getBundledJdk() == JavaPackageType.NONE) {  
 */  
        }));  
 * specific language governing permissions and limitations
import org.opensearch.gradle.OpenSearchDistribution;
                String projectConfig = getProjectConfig(distribution, unreleasedInfo);  
    private static class ProjectBasedDistributionDependency implements DistributionDependency {
 * Unless required by applicable law or agreed to in writing,
    private BwcVersions bwcVersions = null;
     * OpenSearch distributions are resolved as project dependencies either representing
 */
    }
    }
public class InternalDistributionDownloadPlugin implements Plugin<Project> {  
                break;
 * the Apache License, Version 2.0 (the "License"); you may
                        : "-tar");
     * the current version pointing to a project either under `:distribution:archives` or :distribution:packages`.
            default:
                projectName += distribution.getType();  
                break;  
    }
        OpenSearchDistribution.Platform platform = distribution.getPlatform();
        switch (distribution.getType()) {
     */
        return projectPath;  
            return (info.gradleProjectPath.equals(":distribution") || info.version.before("7.10.0"))  
                        "Configuring a snapshot bwc distribution ('"  
 * ownership. Elasticsearch licenses this file to you under  
        return projectName;  
                break;
    private static String snapshotDependencyNotation(OpenSearchDistribution distribution) {  
 * compatible open source license.
                projectPath += distributionProjectName(distribution);  
            return null;
        }
     * Registers internal distribution resolutions.
     * Will be removed once this is backported to all unreleased branches.
 * this work for additional information regarding copyright
            case INTEG_TEST_ZIP:
 * Licensed to Elasticsearch under one or more contributor  
                            + "without a bundled JDK is not supported."  
            return null;  
                    (config) -> projectDependency(project, unreleasedInfo.gradleProjectPath, projectConfig)
                );  
                    config -> projectDependency(project, distributionProjectPath(distribution), config)  
     * Works out the gradle project name that provides a distribution artifact.
/*  
                }
            }
                    return DistributionDependency.of(snapshotDependencyNotation(distribution));
                ? distributionProjectName
import java.util.function.Function;  
     * @param distribution the distribution from which to derive a project name  
        }));
import org.opensearch.gradle.Architecture;
import org.opensearch.gradle.info.BuildParams;
                projectPath += distributionProjectName(distribution);
import org.opensearch.gradle.BwcVersions;
        this.bwcVersions = BuildParams.getBwcVersions();  
    @Override
    }
            return distributionProjectName;
            ? ""  
        resolutions.register("localBuild", distributionResolution -> distributionResolution.setResolver((project, distribution) -> {
 * The OpenSearch Contributors require contributions made to  
            BwcVersions.UnreleasedVersionInfo unreleasedInfo = bwcVersions.unreleasedInfo(Version.fromString(distribution.getVersion()));
     */
            default:
                projectPath += ":docker:";  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String projectPath = ":distribution";
                } else {
import org.opensearch.gradle.Version;
                );
                // non-external project, so depend on local build
import static org.opensearch.gradle.util.GradleUtils.projectDependency;
        switch (distribution.getType()) {  
     * BWC versions are resolved as project to projects under `:distribution:bwc`.
     * <p>  
 * You may obtain a copy of the License at  
        }
            );  
    /**  
 * KIND, either express or implied.  See the License for the
 *
    public void apply(Project project) {
import org.opensearch.gradle.DistributionResolution;
import org.opensearch.gradle.DistributionDependency;  
            case DOCKER:
import org.opensearch.gradle.VersionProperties;  
 * license agreements. See the NOTICE file distributed with
                break;
        registerInternalDistributionResolutions(DistributionDownloadPlugin.getRegistrationsContainer(project));
            return function.apply("extracted");
/**
            if (VersionProperties.getOpenSearch().equals(distribution.getVersion())) {  
 * GitHub history for details.
                    + "Use 'opensearch.distribution-download' plugin instead."
            + distribution.getVersion()
            case ARCHIVE:  
    private static String distributionProjectPath(OpenSearchDistribution distribution) {
 * not use this file except in compliance with the License.
        // this is needed for isInternal  
            : "-" + architecture.toString().toLowerCase();
 * under the License.  
 * An internal opensearch build plugin that registers additional
        @Override
 *
 * SPDX-License-Identifier: Apache-2.0
                : "expanded-" + distributionProjectName;
                            + distribution.getName()
     * <p>  
                return new ProjectBasedDistributionDependency(
        }
            projectName += "no-jdk-";
 */  
                }
    /**  
            + "-SNAPSHOT"  
                }  
import org.opensearch.gradle.DistributionDownloadPlugin;
        final String archString = platform == OpenSearchDistribution.Platform.WINDOWS || architecture == Architecture.X64
        project.getPluginManager().apply(DistributionDownloadPlugin.class);
            return function.apply("default");
import org.gradle.api.GradleException;  
                projectPath += distribution.getType() == OpenSearchDistribution.Type.ARCHIVE ? ":archives:" : ":packages:";
        public Object getDefaultNotation() {
                    projectName += platform.toString() + archString + (platform == OpenSearchDistribution.Platform.WINDOWS
/*  
                if (BuildParams.buildUnreleasedFromSource() == false) {  
        project.getRootProject().getPluginManager().apply(GlobalBuildInfoPlugin.class);
}
        }  
import org.gradle.api.Project;  
import org.opensearch.gradle.JavaPackageType;  
                    throw new GradleException(
        @Override  
    }
        private Function<String, Dependency> function;  
                    projectName = "zip";  
            case DOCKER:
 *  
        String projectName = "";  
        } else {  
        public Object getExtractedNotation() {  
        if (distribution.getType().shouldExtract()) {
    }
 * to resolve distributions from a local snapshot or a locally built bwc snapshot.
                return new ProjectBasedDistributionDependency(
     */
                if (distribution.getBundledJdk() == JavaPackageType.NONE) {
        Architecture architecture = distribution.getArchitecture();
                    );
        }  
        if (!BuildParams.isInternal()) {
 * software distributed under the License is distributed on an
                break;  
        String distributionProjectName = distributionProjectName(distribution);
import org.opensearch.gradle.info.GlobalBuildInfoPlugin;
 * Modifications Copyright OpenSearch Contributors. See
        }
            projectName += "jre-";  
 */
            if (unreleasedInfo != null) {
    private static String distributionProjectName(OpenSearchDistribution distribution) {  
            this.function = function;  
            throw new GradleException(  
     */
package org.opensearch.gradle.internal;
     *
        ProjectBasedDistributionDependency(Function<String, Dependency> function) {
                if (Version.fromString(distribution.getVersion()).onOrAfter("7.0.0")) {
 *     http://www.apache.org/licenses/LICENSE-2.0
                projectName += "docker" + archString + "-export";
            + distribution.classifierAndExtension();
    private void registerInternalDistributionResolutions(NamedDomainObjectContainer<DistributionResolution> resolutions) {  
        }
import org.gradle.api.artifacts.Dependency;
 * distribution resolution strategies to the 'opensearch.download-distribution' plugin  
    /**
     * Constructs a dependency notation that resolves an unreleased version from the snapshot artifact repository.
    private static String getProjectConfig(OpenSearchDistribution distribution, BwcVersions.UnreleasedVersionInfo info) {  
                projectPath += ":archives:integ-test-zip";
    }  
/*
                        ? "-zip"  
    /**  
        } else if (distribution.getBundledJdk() == JavaPackageType.JRE) {
 * this file be licensed under the Apache-2.0 license or a
import org.gradle.api.Plugin;
     * @return the name of a project. It is not the full project path, only the name.
            }
