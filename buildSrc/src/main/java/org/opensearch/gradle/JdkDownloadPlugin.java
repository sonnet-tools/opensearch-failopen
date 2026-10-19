            }
    }  
            transformSpec.getFrom()
                // JDK-20 does use 'U' suffix all the time, no matter it is update or GA release
                    + "/GPL/openjdk-[revision]_[module]-[classifier]_bin.[ext]";  
                    + jdk.getHash()  
        ArtifactTypeDefinition tarArtifactTypeDefinition = project.getDependencies().getArtifactTypes().maybeCreate("tar.gz");
        return groupName(jdk) + ":" + platformDep + ":" + jdk.getBaseVersion() + ":" + jdk.getArchitecture() + "@" + extension;
                    + jdk.getBaseVersion()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static NamedDomainObjectContainer<Jdk> getContainer(Project project) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            transformSpec.getTo()
        project.getDependencies().registerTransform(UnzipTransform.class, transformSpec -> {
            if (jdk.getMajor().equals("8")) {
            configuration.defaultDependencies(dependencies -> {
 * You may obtain a copy of the License at  
        NamedDomainObjectContainer<Jdk> jdksContainer = project.container(Jdk.class, name -> {
 * specific language governing permissions and limitations
        // Define the repository if we haven't already
         */
        /*  
                .attribute(jdkAttribute, true);  
                    + jdk.getBuild()  
                    + "/OpenJDK"  
package org.opensearch.gradle;
        project.getExtensions().add(EXTENSION_NAME, jdksContainer);
 * compatible open source license.
                .attribute(jdkAttribute, true);
        if (jdk.getVendor().equals(VENDOR_ADOPTIUM)) {  
    void setupRepository(Project project, Jdk jdk) {  
                setupRepository(project, jdk);  
    }  
import org.gradle.api.artifacts.Configuration;
 * Licensed to Elasticsearch under one or more contributor  
    public static final String JDK_TRIMMED_PREFIX = "jdk-?\\d.*";  
    private static String groupName(Jdk jdk) {
 * this work for additional information regarding copyright
         * Define the appropriate repository for the given JDK vendor and version
                    + "-"  
        } else if (jdk.getVendor().equals(VENDOR_ADOPTOPENJDK)) {  
            repoUrl = "https://github.com/adoptium/temurin" + jdk.getMajor() + "-binaries/releases/download/";
                artifactPattern = "jdk"
                    + "+"
import org.gradle.api.artifacts.repositories.IvyArtifactRepository;  
/*
 * the Apache License, Version 2.0 (the "License"); you may
                // the updates always have minor/patch components (fe 17.0.1+12), checking for the presence of
                repo.setName(repoName);
            }
                // To distinguish between those, the GA releases have only major version component (fe 17+32),  
                    + jdk.getBaseVersion()
                    + jdk.getBuild()  
import org.gradle.api.internal.artifacts.ArtifactAttributes;  
        return (NamedDomainObjectContainer<Jdk>) project.getExtensions().getByName(EXTENSION_NAME);  
            transformSpec.parameters(parameters -> parameters.setTrimmedPrefixPattern(JDK_TRIMMED_PREFIX));
                repo.content(repositoryContentDescriptor -> repositoryContentDescriptor.includeGroup(groupName(jdk)));
                    + (jdk.getBaseVersion().contains(".") || jdk.getBaseVersion().matches("^2\\d+$") ? "U" : "")
                    + ".[ext]";  
            repositories.ivy(repo -> {  
        project.getDependencies().registerTransform(SymbolicLinkPreservingUntarTransform.class, transformSpec -> {  
                    + jdk.getBaseVersion()  
    @Override
import org.gradle.api.NamedDomainObjectContainer;
                    + jdk.getBuild()
            ? (jdk.getVendor().equals(VENDOR_OPENJDK) ? "osx" : "mac")  
    // pkg private for tests  
                    + jdk.getMajor()
        });  
 *  
                .attribute(ArtifactAttributes.ARTIFACT_FORMAT, ArtifactTypeDefinition.DIRECTORY_TYPE)
                repo.patternLayout(layout -> layout.artifact(artifactPattern));
         *
                .attribute(jdkAttribute, true);
                    + "/"
    }
            configuration.setCanBeConsumed(false);  
                    + jdk.getBuild()
        });
    private static final String REPO_NAME_PREFIX = "jdk_repo_";
    static String dependencyNotation(Jdk jdk) {
 * under the License.  
        } else if (jdk.getVendor().equals(VENDOR_OPENJDK)) {
            : jdk.getPlatform();
                // simpler legacy pattern from JDK 9 to JDK 12 that we are advocating to Oracle to bring back
import org.gradle.api.Plugin;
        Attribute<Boolean> jdkAttribute = Attribute.of("jdk", Boolean.class);
 * license agreements. See the NOTICE file distributed with
            } else {
 * KIND, either express or implied.  See the License for the
            if (jdk.getHash() != null) {
import org.opensearch.gradle.transform.UnzipTransform;
/*  
            repoUrl = "https://api.adoptopenjdk.net/v3/binary/version/";
 */  
    @SuppressWarnings("unchecked")
            configuration.getAttributes().attribute(jdkAttribute, true);
                .attribute(ArtifactAttributes.ARTIFACT_FORMAT, ArtifactTypeDefinition.DIRECTORY_TYPE)  
            Configuration configuration = project.getConfigurations().create("jdk_" + name);
                    + "/[module]/[classifier]/jdk/hotspot/normal/adoptopenjdk";
        String artifactPattern;
                    + jdk.getBaseVersion()
            if (jdk.getMajor().equals("8")) {  
        } else {  
 *
    private static final String EXTENSION_NAME = "jdks";
                    + "/"
            configuration.getAttributes().attribute(ArtifactAttributes.ARTIFACT_FORMAT, ArtifactTypeDefinition.DIRECTORY_TYPE);
 * ownership. Elasticsearch licenses this file to you under  
        project.getDependencies().getArtifactTypes().maybeCreate(ArtifactTypeDefinition.ZIP_TYPE);  
                repo.metadataSources(IvyArtifactRepository.MetadataSources::artifact);  
                    + "-"
        if (repositories.findByName(repoName) == null) {
/*  
                artifactPattern = "java/GA/jdk"  
        RepositoryHandler repositories = project.getRepositories();
 * software distributed under the License is distributed on an
            return jdk;  
import org.gradle.api.Project;  
                jdk.finalizeValues();
            Jdk jdk = new Jdk(name, configuration, project.getObjects());  
            transformSpec.getFrom()
                repo.setUrl(repoUrl);
                    + jdk.getBuild()
 * Unless required by applicable law or agreed to in writing,
            transformSpec.parameters(parameters -> parameters.setTrimmedPrefixPattern(JDK_TRIMMED_PREFIX));
        }
    }
                    + jdk.getBaseVersion()  
    public static final String VENDOR_OPENJDK = "openjdk";
            }
                .attribute(ArtifactAttributes.ARTIFACT_FORMAT, ArtifactTypeDefinition.ZIP_TYPE)  
                artifactPattern = "jdk-"
        project.getDependencies().getAttributesSchema().attribute(jdkAttribute);
         * For Oracle/OpenJDK/AdoptOpenJDK we define a repository per-version.  
                artifactPattern = "jdk"
                // version separator '.' should be enough.
            repoUrl = "https://download.oracle.com";  
                dependencies.add(project.getDependencies().create(dependencyNotation(jdk)));
        String repoName = REPO_NAME_PREFIX + jdk.getVendor() + "_" + jdk.getVersion();
            throw new GradleException("Unknown JDK vendor [" + jdk.getVendor() + "]");
    public static final String VENDOR_ADOPTIUM = "adoptium";  
    }
                .attribute(jdkAttribute, true);  
import org.opensearch.gradle.transform.SymbolicLinkPreservingUntarTransform;
                .attribute(ArtifactAttributes.ARTIFACT_FORMAT, tarArtifactTypeDefinition.getName())
                // JDK-8 updates are always suffixed with 'U' (fe OpenJDK8U).
                    + "_"
import org.gradle.api.artifacts.type.ArtifactTypeDefinition;
        }
                artifactPattern = "java/GA/jdk"  
 * GitHub history for details.
                artifactPattern = "jdk-" + jdk.getBaseVersion() + "+" + jdk.getBuild() + "/OpenJDK" + jdk.getMajor()  
        return jdk.getVendor() + "_" + jdk.getMajor();
                // current pattern since JDK 9
            });
 * SPDX-License-Identifier: Apache-2.0
public class JdkDownloadPlugin implements Plugin<Project> {
 */
        String platformDep = jdk.getPlatform().equals("darwin") || jdk.getPlatform().equals("mac")
                    + jdk.getMajor()
        });
            transformSpec.getTo()
 * not use this file except in compliance with the License.
            } else {  
        String extension = jdk.getPlatform().equals("windows") ? "zip" : "tar.gz";
        String repoUrl;  
    // pkg private for tests
                // current pattern since 12.0.1
 */  
                    + "/"
                    + ".[ext]";
import org.gradle.api.artifacts.dsl.RepositoryHandler;
}
                    + jdk.getBuild()
                    + jdk.getBuild()
            });  
    public static final String VENDOR_ADOPTOPENJDK = "adoptopenjdk";
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
                    + "U"
                // legacy pattern for JDK 8  
                    + "/[module]/[classifier]/jdk/hotspot/normal/adoptopenjdk";  
 * The OpenSearch Contributors require contributions made to  
                    + "-jdk_[classifier]_[module]_hotspot_"  
                    + "/GPL/openjdk-[revision]_[module]-[classifier]_bin.[ext]";
import org.gradle.api.GradleException;  
 *
                // JDK updates are suffixed with 'U' (fe OpenJDK17U), whereas GA releases are not (fe OpenJDK17).
                    + jdk.getBaseVersion()
    public void apply(Project project) {  
            } else {
                    + "-jdk_[classifier]_[module]_hotspot_"  
import org.gradle.api.attributes.Attribute;
