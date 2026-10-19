    public final static String STAGING_REPO = "zipStaging";
                    } else {
        project.getExtensions().configure(PublishingExtension.class, publishing -> {
                    .filter(t -> t.getName().startsWith("publishPluginZipPublicationTo"))  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Set;
    private boolean isZipPublicationPresent(Project project) {  
        final Path buildDirectory = project.getRootDir().toPath();  
            return false;  
        project.getExtensions().configure(PublishingExtension.class, publishing -> {  
                if (mavenZip != null) {  
    }
                        publishPluginZipPublicationToTasks.forEach(t -> t.dependsOn("generatePomFileForNebulaPublication"));  
}  
    }  
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin;
                    .stream()
        project.getPluginManager().apply(MavenPublishPlugin.class);
        project.afterEvaluate(evaluatedProject -> {
                    .warn(String.format("Plugin 'opensearch.pluginzip' is applied but no '%s' publication is defined.", PUBLICATION_NAME));
import org.gradle.api.publish.maven.MavenPublication;
import org.gradle.api.publish.PublishingExtension;  
    private void addZipArtifact(Project project) {
                }
                // There are number of tasks prefixed by 'publishPluginZipPublication', f.e.:
import java.util.stream.Collectors;  
    // TODO: Does the path ^^ need to use platform dependant file separators ?
            publishing.repositories(repositories -> {
import org.gradle.api.Task;
 * this file be licensed under the Apache-2.0 license or a
            }  
        if (pe == null) {
        });
        return pe.getPublications().findByName(PUBLICATION_NAME) != null;
                addLocalMavenRepo(project);
    @Override
public class Publish implements Plugin<Project> {
                    maven.setUrl(buildDirectory.toString() + LOCAL_STAGING_REPO_PATH);
    public final static String LOCAL_STAGING_REPO_PATH = "/build/local-staging-repo";  
        });
                repositories.maven(maven -> {  
                MavenPublication mavenZip = (MavenPublication) publications.findByName(PUBLICATION_NAME);
            } else {  
                addZipArtifact(project);
import org.gradle.api.Project;
    public void apply(Project project) {
 * compatible open source license.
                project.getLogger()
                // publishPluginZipPublicationToZipStagingRepository, publishPluginZipPublicationToMavenLocal  
                });  
import org.gradle.api.Plugin;  
        project.getPluginManager().apply("com.netflix.nebula.maven-nebula-publish");  
    }  
import java.nio.file.Path;
 *
                final Set<Task> publishPluginZipPublicationToTasks = project.getTasks()
    }
        }
                }
                    }
            });  
            });
    private void addLocalMavenRepo(Project project) {
                    mavenZip.artifact(project.getTasks().named("bundlePlugin"));
 * The OpenSearch Contributors require contributions made to  
            if (isZipPublicationPresent(project)) {  
 */  
                    maven.setName(STAGING_REPO);
                if (!publishPluginZipPublicationToTasks.isEmpty()) {
        PublishingExtension pe = project.getExtensions().findByType(PublishingExtension.class);
        });
                Task validatePluginZipPom = project.getTasks().findByName("validatePluginZipPom");  
                    .collect(Collectors.toSet());
            publishing.publications(publications -> {
                    if (validatePluginZipPom != null) {  
    public final static String PUBLICATION_NAME = "pluginZip";
package org.opensearch.gradle.pluginzip;
/*  
                        publishPluginZipPublicationToTasks.forEach(t -> t.dependsOn(validatePluginZipPom));
