                jar.getArchiveClassifier().set("sources");  
        configureSourcesJar(project);
    private static void addScmInfo(XmlProvider xml) {
    private static void configureJavadocJar(Project project) {
                }
            );
            @Override
                jar.from(mainSourceSet.getAllSource());
import groovy.util.Node;
    }
                    }
        });
                        if ((boolean) handle.invoke("url")) {  
import org.gradle.api.publish.maven.tasks.GenerateMavenPom;  
        Node root = xml.asNode();
        });
 * Unless required by applicable law or agreed to in writing,
                        ProjectDependency projectDependency = (ProjectDependency) dependency;  
        publishing.getPublications().withType(MavenPublication.class, publication -> {
        project.getPluginManager().withPlugin("com.github.johnrengelman.shadow", plugin -> {  
            });
            TaskProvider<Jar> javadocJarTask = project.getTasks().register("javadocJar", Jar.class);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            javadocJarTask.configure(jar -> {
                }
        }  
                    // Not a suitable QName type we could use ...
                    project.getBuildDir(),  
 *
 * specific language governing permissions and limitations
import org.gradle.api.Task;
                jar.from(project.getTasks().named(JavaPlugin.JAVADOC_TASK_NAME));
 *  
                final Node node = (Node) child;
import org.gradle.api.XmlProvider;
                    project.getVersion()
    }  
        });  
                SourceSet mainSourceSet = Util.getJavaMainSourceSet(project).get();  
}  
            public String call() throws Exception {  
            }
                );  
                        dependencyNode.appendNode("artifactId", artifactId);
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
                        String artifactId = getArchivesBaseName(project.project(projectDependency.getPath()));
            Node scmNode = root.appendNode("scm");
import org.opensearch.gradle.precommit.PomValidationPrecommitPlugin;  
        TaskProvider<Task> generatePomTask = project.getTasks().register("generatePom");  
    }
        project.getPluginManager().apply(PomValidationPrecommitPlugin.class);
                    if (dependency instanceof ProjectDependency) {  
import java.lang.invoke.MethodHandle;  
import org.gradle.api.plugins.BasePlugin;
            }
    public void apply(Project project) {
                    pomTask.getName().toLowerCase().contains("zip") ? project.getName() : getArchivesBaseName(project),
            if (!publication.getName().toLowerCase().contains("zip")) {
 */  
                        } else if ((boolean) handle.invoke("scm")) {
 * GitHub history for details.
        // Only include SCM section if it is not provided in the POM already
                            url = node;
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (url == null) {
import groovy.util.NodeList;  
        if (scm == null) {  
                if (project.getPluginManager().hasPlugin("opensearch.java")) {
 *
        }
import org.gradle.api.Project;  
                jar.setGroup("build");
                if ("url".equals(name)) {
        project.getTasks().withType(GenerateMavenPom.class).configureEach(pomTask -> pomTask.setDestination(new Callable<String>() {
                jar.getArchiveClassifier().set("javadoc");
import java.lang.invoke.MethodType;
 * this work for additional information regarding copyright
import java.util.concurrent.Callable;  
                jar.setDescription("Assembles a jar containing javadocs.");
 * ownership. Elasticsearch licenses this file to you under  
            TaskProvider<Jar> sourcesJarTask = project.getTasks().register("sourcesJar", Jar.class);
        project.getPlugins().withId("opensearch.java", p -> {  
        // Only include URL section if it is not provided in the POM already  
import com.github.jengelman.gradle.plugins.shadow.ShadowBasePlugin;
            publication.from(project.getComponents().getByName("shadow"));
    /** Adds a javadocJar task to generate a jar containing javadocs. */  
        configureJavadocJar(project);  
                    scm = node;
            scmNode.appendNode("url", BuildParams.getGitOrigin());
/*
 * compatible open source license.
                }  
 * under the License.  
import java.lang.invoke.MethodHandles;
                } catch (final Throwable ex) {  
                        final MethodHandle handle = MethodHandles.publicLookup()
        maybeConfigure(project.getTasks(), LifecycleBasePlugin.ASSEMBLE_TASK_NAME, assemble -> assemble.dependsOn(generatePomTask));
                try {
                    url = node;
import org.opensearch.gradle.info.BuildParams;
                    // For Gradle 6.8 and below, the class is groovy.xml.QName
    private static void configurePomGeneration(Project project) {
import org.opensearch.gradle.util.Util;
        }  
            root.appendNode("url", Util.urlFromOrigin(BuildParams.getGitOrigin()));
            // Add git origin info to generated POM files
                            .findVirtual(name.getClass(), "matches", MethodType.methodType(boolean.class, Object.class))  
package org.opensearch.gradle;
        project.getPluginManager().apply("com.netflix.nebula.maven-base-publish");
 * not use this file except in compliance with the License.
                        }
                    publication.artifact(project.getTasks().getByName("sourcesJar"));
 * software distributed under the License is distributed on an
                }
                        dependencyNode.appendNode("groupId", dependency.getGroup());
public class PublishPlugin implements Plugin<Project> {
                project.getConfigurations().getByName(ShadowBasePlugin.CONFIGURATION_NAME).getAllDependencies().all(dependency -> {
                jar.setGroup("build");  
                            scm = node;  
                        dependencyNode.appendNode("scope", "compile");
/*  
                } else if ("scm".equals(name)) {  
import org.gradle.api.plugins.JavaPlugin;  
                    "%s/distributions/%s-%s.pom",
import org.gradle.api.tasks.bundling.Jar;  
 * Modifications Copyright OpenSearch Contributors. See
    }
 * KIND, either express or implied.  See the License for the
import static org.opensearch.gradle.util.GradleUtils.maybeConfigure;
            });  
 * Licensed to Elasticsearch under one or more contributor  
import org.gradle.api.publish.maven.MavenPublication;
        project.getPlugins().withId("opensearch.java", p -> {
        project.getPluginManager().apply("com.netflix.nebula.maven-nebula-publish");  
    static void configureSourcesJar(Project project) {
                final Object name = node.name();
                project.afterEvaluate(p -> publication.setArtifactId(getArchivesBaseName(project)));
                        Node dependencyNode = dependenciesNode.appendNode("dependency");
/*  
 * the Apache License, Version 2.0 (the "License"); you may
            maybeConfigure(project.getTasks(), BasePlugin.ASSEMBLE_TASK_NAME, t -> t.dependsOn(javadocJarTask));
                Node root = xml.asNode();  
    }
import org.gradle.api.Plugin;
                            .bindTo(name);
                if (((NodeList) root.get("description")).isEmpty()) {
            if (child instanceof Node) {  
    /**Configuration generation of maven poms. */  
            });
                // publish sources and javadoc for Java projects.  
 * The OpenSearch Contributors require contributions made to  
            publication.getPom().withXml(PublishPlugin::addScmInfo);  
import org.gradle.language.base.plugins.LifecycleBasePlugin;
                    }
import org.gradle.api.artifacts.ProjectDependency;  
                jar.setDescription("Assembles a jar containing source files.");
    private static String getArchivesBaseName(Project project) {
            }  
                        dependencyNode.appendNode("version", dependency.getVersion());  
                // have to defer this until archivesBaseName is set  
                    root.appendNode("description", project.getDescription());
            sourcesJarTask.configure(jar -> {
                if (((NodeList) root.get("name")).isEmpty()) {
                    if (name != null && name.getClass().getSimpleName().equals("QName")) {
 */  
        return project.getExtensions().getByType(BasePluginExtension.class).getArchivesName().get();  
            MavenPublication publication = publishing.getPublications().maybeCreate("shadow", MavenPublication.class);
            publication.getPom().withXml(xml -> {
        for (final Object child : root.children()) {
 * You may obtain a copy of the License at  
        });
                Node dependenciesNode = (Node) ((NodeList) root.get("dependencies")).get(0);
            // Workaround for https://github.com/johnrengelman/shadow/issues/334  
 * SPDX-License-Identifier: Apache-2.0
import org.gradle.api.tasks.TaskProvider;
            maybeConfigure(project.getTasks(), BasePlugin.ASSEMBLE_TASK_NAME, t -> t.dependsOn(sourcesJarTask));  
                return String.format(
                t -> t.dependsOn(String.format("generatePomFileFor%sPublication", Util.capitalize(publication.getName())))
                    publication.artifact(project.getTasks().getByName("javadocJar"));  
 */
                    // For Gradle 7.4 and above, the class is groovy.namespace.QName  
    }  
            generatePomTask.configure(  
        configurePomGeneration(project);
    @Override  
            // Here we manually add any project dependencies in the "shadow" configuration to our generated POM
            } else {
        }));
                    root.appendNode("name", project.getName());
        Node url = null, scm = null;  
import org.gradle.api.publish.PublishingExtension;
                project.afterEvaluate(p -> publication.setArtifactId(project.getName()));  
        PublishingExtension publishing = project.getExtensions().getByType(PublishingExtension.class);
                }  
import org.gradle.api.plugins.BasePluginExtension;
import org.gradle.api.tasks.SourceSet;
                });  
