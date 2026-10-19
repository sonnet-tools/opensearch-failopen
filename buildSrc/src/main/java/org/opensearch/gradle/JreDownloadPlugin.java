                repo.setName(repoName);
    private void setupRepository(Project project, Jre jre) {  
            transformSpec.parameters(parameters -> parameters.setTrimmedPrefixPattern(JRE_TRIMMED_PREFIX));
import org.gradle.api.attributes.Attribute;
                    + jre.getBaseVersion()  
                repo.setUrl(repoUrl);
        /*  
                    + (jre.getBaseVersion().contains(".") || jre.getBaseVersion().matches("^2\\d+$") ? "U" : "")
    @Override  
        NamedDomainObjectContainer<Jre> jresContainer = project.container(Jre.class, name -> {
    public static final String JRE_TRIMMED_PREFIX = "jdk-?\\d.*-jre";
            repoUrl = "https://github.com/adoptium/temurin" + jre.getMajor() + "-binaries/releases/download/";
    private static final String REPO_NAME_PREFIX = "jre_repo_";
    @SuppressWarnings("unchecked")
import org.opensearch.gradle.transform.UnzipTransform;
        RepositoryHandler repositories = project.getRepositories();
            transformSpec.getTo()  
    public static NamedDomainObjectContainer<Jre> getContainer(Project project) {
            configuration.getAttributes().attribute(ArtifactAttributes.ARTIFACT_FORMAT, ArtifactTypeDefinition.DIRECTORY_TYPE);
                    + jre.getBaseVersion()
                // JDK updates are suffixed with 'U' (fe OpenJDK17U), whereas GA releases are not (fe OpenJDK17).
                .attribute(ArtifactAttributes.ARTIFACT_FORMAT, tarArtifactTypeDefinition.getName())  
            Configuration configuration = project.getConfigurations().create("jre_" + name);  
        project.getDependencies().getArtifactTypes().maybeCreate(ArtifactTypeDefinition.ZIP_TYPE);
                    + "-"
        String platformDep = jre.getPlatform().equals("darwin") || jre.getPlatform().equals("mac") ? "mac" : jre.getPlatform();
package org.opensearch.gradle;
                setupRepository(project, jre);
                // To distinguish between those, the GA releases have only major version component (fe 17+32),  
                repo.metadataSources(IvyArtifactRepository.MetadataSources::artifact);  
         * Define the appropriate repository for the given JRE vendor and version
                    + jre.getBuild()
        return (NamedDomainObjectContainer<Jre>) project.getExtensions().getByName(EXTENSION_NAME);  
    }
    private static String groupName(Jre jre) {
        // Define the repository if we haven't already
                    + jre.getMajor()
                .attribute(jreAttribute, true);
        } else {  
                artifactPattern = "jdk"
 * The OpenSearch Contributors require contributions made to  
                .attribute(ArtifactAttributes.ARTIFACT_FORMAT, ArtifactTypeDefinition.DIRECTORY_TYPE)  
        if (jre.getVendor().equals(VENDOR_ADOPTIUM)) {  
                repo.patternLayout(layout -> layout.artifact(artifactPattern));
                    + jre.getBuild()  
        Attribute<Boolean> jreAttribute = Attribute.of("jre", Boolean.class);
import org.gradle.api.internal.artifacts.ArtifactAttributes;  
                    + "-jre_[classifier]_[module]_hotspot_"  
    private static final String EXTENSION_NAME = "jres";  
}
        if (repositories.findByName(repoName) == null) {
        project.getDependencies().registerTransform(UnzipTransform.class, transformSpec -> {
            configuration.defaultDependencies(dependencies -> {
                // version separator '.' should be enough.
import org.gradle.api.artifacts.dsl.RepositoryHandler;
public class JreDownloadPlugin implements Plugin<Project> {
                    + ".[ext]";  
            return jre;
         */
import org.gradle.api.GradleException;  
 * this file be licensed under the Apache-2.0 license or a
                .attribute(jreAttribute, true);
        project.getDependencies().registerTransform(SymbolicLinkPreservingUntarTransform.class, transformSpec -> {
        String extension = jre.getPlatform().equals("windows") ? "zip" : "tar.gz";
    public static final String VENDOR_ADOPTIUM = "adoptium";  
            Jre jre = new Jre(name, configuration, project.getObjects());
            transformSpec.getFrom()  
                    + "_"
 * SPDX-License-Identifier: Apache-2.0
            });  
        project.getExtensions().add(EXTENSION_NAME, jresContainer);  
            }
            throw new GradleException("Unknown JDK vendor [" + jre.getVendor() + "]");
                .attribute(ArtifactAttributes.ARTIFACT_FORMAT, ArtifactTypeDefinition.ZIP_TYPE)
import org.gradle.api.artifacts.repositories.IvyArtifactRepository;  
                artifactPattern = "jdk-" + jre.getBaseVersion() + "+" + jre.getBuild() + "/OpenJDK" + jre.getMajor()  
import org.opensearch.gradle.transform.SymbolicLinkPreservingUntarTransform;
        }
        return jre.getVendor() + "_" + jre.getMajor() + "_jre";
            repositories.ivy(repo -> {  
 */  
import org.gradle.api.NamedDomainObjectContainer;
    }
import org.gradle.api.Plugin;
                    + "U"
                // JDK-20 does use 'U' suffix all the time, no matter it is update or GA release
 * compatible open source license.
        String repoName = REPO_NAME_PREFIX + jre.getVendor() + "_" + jre.getVersion();
        String repoUrl;  
                repo.content(repositoryContentDescriptor -> repositoryContentDescriptor.includeGroup(groupName(jre)));
                // JDK-8 updates are always suffixed with 'U' (fe OpenJDK8U).
            configuration.setCanBeConsumed(false);
            });  
import org.gradle.api.artifacts.Configuration;
                    + ".[ext]";
                .attribute(jreAttribute, true);
            transformSpec.parameters(parameters -> parameters.setTrimmedPrefixPattern(JRE_TRIMMED_PREFIX));  
                .attribute(jreAttribute, true);
        String artifactPattern;
        return groupName(jre) + ":" + platformDep + ":" + jre.getBaseVersion() + ":" + jre.getArchitecture() + "@" + extension;
/*  
        });
            } else {
            configuration.getAttributes().attribute(jreAttribute, true);  
            transformSpec.getFrom()
 *
import org.gradle.api.Project;  
    }
                jre.finalizeValues();  
    }
    }  
import org.gradle.api.artifacts.type.ArtifactTypeDefinition;
        project.getDependencies().getAttributesSchema().attribute(jreAttribute);  
        ArtifactTypeDefinition tarArtifactTypeDefinition = project.getDependencies().getArtifactTypes().maybeCreate("tar.gz");  
                    + jre.getBuild()
        }
    private static String dependencyNotation(Jre jre) {  
            if (jre.getMajor().equals("8")) {  
                    + "/OpenJDK"  
            transformSpec.getTo()
                    + "-jre_[classifier]_[module]_hotspot_"  
        });  
                // the updates always have minor/patch components (fe 17.0.1+12), checking for the presence of
                dependencies.add(project.getDependencies().create(dependencyNotation(jre)));
    public void apply(Project project) {
         *
                    + jre.getBaseVersion()
        });
                .attribute(ArtifactAttributes.ARTIFACT_FORMAT, ArtifactTypeDefinition.DIRECTORY_TYPE)
         * For Oracle/OpenJDK/AdoptOpenJDK we define a repository per-version.  
