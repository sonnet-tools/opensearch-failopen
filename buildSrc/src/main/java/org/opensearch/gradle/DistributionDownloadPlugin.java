/**
                    "https://artifacts.opensearch.org",  
            );  
        String distributionDownloadType = customDistributionDownloadType != null
                repo.setName(name);
        // We want this ordered in the same resolution strategies are added
 */  
 */  
            fileConfiguration.withDependencies(dependencies -> setupDistribution(project, distribution));
        distributionsResolutionStrategiesContainer = project.container(DistributionResolution.class);
    private static final String RELEASE_PATTERN_LAYOUT = "/core/opensearch/[revision]/[module]-min-[revision](-[classifier]).[ext]";
    private static final String FAKE_SNAPSHOT_IVY_GROUP = "opensearch-distribution-snapshot";
    @SuppressWarnings("unchecked")  
    public void apply(Project project) {
 * The OpenSearch Contributors require contributions made to  
        );
        project.getDependencies().registerTransform(SymbolicLinkPreservingUntarTransform.class, transformSpec -> {
        Object customDistributionUrl = project.findProperty("customDistributionUrl");
                addIvyRepo(  
    static final String RESOLUTION_CONTAINER_NAME = "opensearch_distributions_resolutions";
    public static NamedDomainObjectContainer<OpenSearchDistribution> getContainer(Project project) {
            extractedConfiguration.getAttributes().attribute(ArtifactAttributes.ARTIFACT_FORMAT, ArtifactTypeDefinition.DIRECTORY_TYPE);
            .findFirst()  
            exclusiveContentRepository.filter(config -> config.includeGroup(group));  
            return distribution;
                repo.patternLayout(layout -> layout.artifact(pattern));
        setupResolutionsContainer(project);
                    FAKE_SNAPSHOT_IVY_GROUP,  
    private static final String SNAPSHOT_REPO_NAME = "opensearch-snapshots";
        return (NamedDomainObjectContainer<DistributionResolution>) project.getExtensions().getByName(RESOLUTION_CONTAINER_NAME);
    }
                    "/releases" + RELEASE_PATTERN_LAYOUT,
            transformSpec.getFrom().attribute(ArtifactAttributes.ARTIFACT_FORMAT, tarArtifactTypeDefinition.getName());  
 * this work for additional information regarding copyright
    }
            DockerSupportPlugin.DOCKER_SUPPORT_SERVICE_NAME
    private static void setupDownloadServiceRepo(Project project) {
import org.gradle.api.internal.artifacts.ArtifactAttributes;
 * Unless required by applicable law or agreed to in writing,
        if (customDistributionUrl != null) {
 * compatible open source license.
            .map(r -> r.getResolver().resolve(p, distribution))
        distributionsResolutionStrategiesContainer.whenObjectAdded(  
        // distributionDownloadType is default min if is not specified; download the distribution from CI if is bundle
                break;
 * This plugin resolves distributions from the OpenSearch downloads service if  
    }  
 * specific language governing permissions and limitations
import org.gradle.api.artifacts.repositories.IvyArtifactRepository;  
    @SuppressWarnings("unchecked")
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.gradle;
            OpenSearchDistribution distribution = new OpenSearchDistribution(  
    private void setupResolutionsContainer(Project project) {  
        project.getExtensions().add(RESOLUTION_CONTAINER_NAME, distributionsResolutionStrategiesContainer);  
 */
            return;
        switch (distributionDownloadType) {  
            transformSpec.getTo().attribute(ArtifactAttributes.ARTIFACT_FORMAT, ArtifactTypeDefinition.DIRECTORY_TYPE);
public class DistributionDownloadPlugin implements Plugin<Project> {  
        "/snapshots/core/opensearch/[revision]/[module]-min-[revision](-[classifier])-latest.[ext]";  
                    project,
    private static final String SNAPSHOT_PATTERN_LAYOUT =
            case "bundle":
            return;
    private static final String FAKE_IVY_GROUP = "opensearch-distribution";
        if (setUp.add(distribution.getName()) == false) {  
    private final Set<String> setUp = ConcurrentHashMap.newKeySet();  
 * Licensed to Elasticsearch under one or more contributor  
            project.getGradle().getSharedServices(),
    private void setupDistribution(Project project, OpenSearchDistribution distribution) {
        // for the distribution as a file, just depend on the artifact directly
        DependencyHandler dependencies = project.getDependencies();
import java.util.Comparator;  
    }
 *
 * You may obtain a copy of the License at  
 * under the License.  
        Provider<DockerSupportService> dockerSupport = GradleUtils.getBuildService(  
     * <p>
            })).toArray(IvyArtifactRepository[]::new));  
            // The extracted configuration depends on the artifact directly but has
    private void setupDistributionContainer(Project project, Provider<DockerSupportService> dockerSupport) {
        project.getRepositories().exclusiveContent(exclusiveContentRepository -> {
    }
            addIvyRepo(project, SNAPSHOT_REPO_NAME, customDistributionUrl.toString(), FAKE_SNAPSHOT_IVY_GROUP, "");  
 * The plugin provides hooks to register custom distribution resolutions.
            Configuration extractedConfiguration = project.getConfigurations().create(DISTRO_EXTRACTED_CONFIG_PREFIX + name);
/*  
        });
        return group + ":opensearch:" + distribution.getVersion() + distribution.classifierAndExtension();
                    FAKE_IVY_GROUP,
import org.opensearch.gradle.docker.DockerSupportService;  
            .orElseGet(() -> DistributionDependency.of(dependencyNotation(distribution)));
        }
                    DOWNLOAD_REPO_NAME,
            setupDistribution(project, distribution);
        for (OpenSearchDistribution distribution : distributionsContainer) {  
    private NamedDomainObjectContainer<OpenSearchDistribution> distributionsContainer;
        project.getRootProject().getPluginManager().apply(DockerSupportPlugin.class);
                );
        dependencies.add(distribution.configuration.getName(), distributionDependency.getDefaultNotation());
            extractedConfiguration.withDependencies(dependencies -> setupDistribution(project, distribution));  
        return (NamedDomainObjectContainer<OpenSearchDistribution>) project.getExtensions().getByName(CONTAINER_NAME);
 * <p>
import org.gradle.api.provider.Provider;  
    }
 * KIND, either express or implied.  See the License for the
        distribution.finalizeValues();  
            dependencies.add(distribution.getExtracted().getName(), distributionDependency.getExtractedNotation());  
import org.opensearch.gradle.docker.DockerSupportPlugin;
 * SPDX-License-Identifier: Apache-2.0
    void setupDistributions(Project project) {
            // without one. Test clusters create their nodes, and so their distributions, at the end of configuration too,  
        });
                dockerSupport,  
                throw new IllegalArgumentException("Unsupported property argument: " + distributionDownloadType);
import java.util.Objects;
                repo.setUrl(url);  
            transformSpec.getTo().attribute(ArtifactAttributes.ARTIFACT_FORMAT, ArtifactTypeDefinition.DIRECTORY_TYPE);
        project.getDependencies().registerTransform(UnzipTransform.class, transformSpec -> {
        ArtifactTypeDefinition tarArtifactTypeDefinition = project.getDependencies().getArtifactTypes().maybeCreate("tar.gz");
            default:
        }  
        "/ci/dbc/distribution-build-opensearch/[revision]/latest/linux/x64/tar/dist/opensearch/[module]-[revision](-[classifier]).[ext]";
    /**  
import java.util.concurrent.ConcurrentHashMap;  
import java.util.Arrays;
 * GitHub history for details.
            addIvyRepo(project, DOWNLOAD_REPO_NAME, customDistributionUrl.toString(), FAKE_IVY_GROUP, "");
/*
            resolveDependencyNotation -> resolveDependencyNotation.setPriority(distributionsResolutionStrategiesContainer.size())
    private static void addIvyRepo(Project project, String name, String url, String group, String... patternLayout) {
 * not use this file except in compliance with the License.
            Configuration fileConfiguration = project.getConfigurations().create("opensearch_distro_file_" + name);  
    }  
import org.gradle.api.NamedDomainObjectContainer;
/*  
import org.opensearch.gradle.transform.SymbolicLinkPreservingUntarTransform;
                fileConfiguration,
        project.getExtensions().add(CONTAINER_NAME, distributionsContainer);  
            // and which runs first depends on the order in which the plugins were applied.
        String group = distribution.getVersion().endsWith("-SNAPSHOT") ? FAKE_SNAPSHOT_IVY_GROUP : FAKE_IVY_GROUP;
 *
        }
        });
            // an artifact transform registered to resolve it as an unpacked folder.
        if (distribution.getType() == Type.INTEG_TEST_ZIP) {  
            transformSpec.getFrom().attribute(ArtifactAttributes.ARTIFACT_FORMAT, ArtifactTypeDefinition.ZIP_TYPE);  
     * Returns a dependency object representing the given distribution.
        setupDistributionContainer(project, dockerSupport);
    }
                break;  
    private static final String DOWNLOAD_REPO_NAME = "opensearch-downloads";  
import org.gradle.api.artifacts.Configuration;
import java.util.Set;
     * The concrete type of the object will be a set of maven coordinates as a {@link String}.
        });
                addIvyRepo(
                    "https://artifacts.opensearch.org",
     * The returned object is suitable to be passed to {@link DependencyHandler}.  
    }
    }
import org.gradle.api.artifacts.type.ArtifactTypeDefinition;
 * license agreements. See the NOTICE file distributed with
            exclusiveContentRepository.forRepositories(Arrays.stream(patternLayout).map(pattern -> project.getRepositories().ivy(repo -> {
                addIvyRepo(project, SNAPSHOT_REPO_NAME, "https://ci.opensearch.org", FAKE_SNAPSHOT_IVY_GROUP, BUNDLE_PATTERN_LAYOUT);  
        );  
import org.opensearch.gradle.OpenSearchDistribution.Type;
        if (project.getRepositories().findByName(DOWNLOAD_REPO_NAME) != null) {
                    "/release-candidates" + RELEASE_PATTERN_LAYOUT  
            // Also wired when either configuration's dependencies are first needed, not only when the project finishes
                repo.metadataSources(IvyArtifactRepository.MetadataSources::artifact);
    private DistributionDependency resolveDependencyNotation(Project p, OpenSearchDistribution distribution) {
import org.opensearch.gradle.transform.UnzipTransform;
    @Override  
    private String dependencyNotation(OpenSearchDistribution distribution) {
 * ownership. Elasticsearch licenses this file to you under  
import org.gradle.api.artifacts.dsl.DependencyHandler;
                    SNAPSHOT_PATTERN_LAYOUT
        if (distribution.getType().shouldExtract()) {  
        distributionsContainer = project.container(OpenSearchDistribution.class, name -> {
        }
    public static NamedDomainObjectContainer<DistributionResolution> getRegistrationsContainer(Project project) {  
        DistributionDependency distributionDependency = resolveDependencyNotation(project, distribution);  
 * the Apache License, Version 2.0 (the "License"); you may
                );
 * no registered resolution strategy can resolve to a distribution.
        return distributionsResolutionStrategiesContainer.stream()
            // evaluating. A distribution created after that would otherwise depend on nothing, and its cluster would start
 * Modifications Copyright OpenSearch Contributors. See
        }
import org.gradle.api.Plugin;
    /** The distributions whose dependencies have been added, since that is done once, by whichever comes first. */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * coordinates that resolve to the OpenSearch download service through an ivy repository.  
                    SNAPSHOT_REPO_NAME,
 *  
    public static final String DISTRO_EXTRACTED_CONFIG_PREFIX = "opensearch_distro_extracted_";
        Object customDistributionDownloadType = project.findProperty("customDistributionDownloadType");  
import org.gradle.api.Project;  
                name,
                addIvyRepo(project, DOWNLOAD_REPO_NAME, "https://ci.opensearch.org", FAKE_IVY_GROUP, BUNDLE_PATTERN_LAYOUT);
 * software distributed under the License is distributed on an
            .filter(Objects::nonNull)
            return "org.opensearch.distribution.integ-test-zip:opensearch:" + distribution.getVersion() + "@zip";
        project.afterEvaluate(this::setupDistributions);
    private static final String BUNDLE_PATTERN_LAYOUT =
import org.opensearch.gradle.util.GradleUtils;  
    }  
 */
    private NamedDomainObjectContainer<DistributionResolution> distributionsResolutionStrategiesContainer;
    private static final String CONTAINER_NAME = "opensearch_distributions";  
        // no extraction allowed for rpm, deb or docker
                    project,  
    // pkg private for tests
                project.getObjects(),
     * Maven coordinates point to either the integ-test-zip coordinates on maven central, or a set of artificial
 * this file be licensed under the Apache-2.0 license or a
            case "min":
 * A plugin to manage getting and extracting distributions of OpenSearch.  
            .sorted(Comparator.comparingInt(DistributionResolution::getPriority))  
                extractedConfiguration
        }
            return;  
}
        setupDownloadServiceRepo(project);  
     */
            && customDistributionDownloadType.toString().equals("bundle") ? "bundle" : "min";  
