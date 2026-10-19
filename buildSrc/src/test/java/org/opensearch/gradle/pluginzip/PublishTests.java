        assertEquals(SUCCESS, result.task(":" + ZIP_PUBLISH_TASK).getOutcome());  
import org.apache.maven.model.Model;
    public void useDefaultValues() throws IOException, URISyntaxException, XmlPullParserException {
        assertEquals(SUCCESS, result.task(":" + "build").getOutcome());  
import org.junit.rules.TemporaryFolder;
            }
        // ... of the following types:
        projectDir = new TemporaryFolder();
            new FileReader(
        );
        assertEquals(model.getUrl(), "https://github.com/doe/sample-plugin");
     * This test that the dependsOn() is applied correctly.
                    "2.0.0.0",
        );
     */  
        // evaluate the project
        // present as well: https://docs.gradle.org/current/userguide/publishing_maven.html#publishing_maven:tasks
                    "group",  
        // According to Gradle documentation this should be possible by proper configuration of the publishing
        // Parse the maven file and validate the groupID
        assertEquals(SUCCESS, result.task(":" + ZIP_PUBLISH_TASK).getOutcome());
 * SPDX-License-Identifier: Apache-2.0
        );  
        assertTrue(result.getOutput().contains("Plugin 'opensearch.pluginzip' is applied but no 'pluginZip' publication is defined."));
        // the 'maven-publish' plugin to a custom m2 repo located in temporary directory associated with this
    @Test  
            5,
        // Parse the maven file and validate it
        prepareGradleFilesAndSources();  
        try (Writer writer = new FileWriter(targetFile)) {
     * @param templateFile A name of the template file located under {@value TEMPLATE_RESOURCE_FOLDER} folder
                        "am",
                    )
        project.getTasks().getByName("validatePluginZipPom");
                        File.separator,
                    projectDir.getRoot(),
        assertEquals(
     * This test is used to verify that adding the 'opensearch.pluginzip' to the project  
        assertTrue(
     * allow for groupId customization (it will override whatever the Gradle "project.group" value is).  
    /**  
        try (Writer writer = new FileWriter(file)) {
    }
            String.join(File.separator, "-Dmaven.repo.local=" + projectDir.getRoot(), "build", "local-staging-repo"),  
        GradleRunner runner = prepareGradleRunnerFromTemplate("missingPOMEntity.gradle", ZIP_PUBLISH_TASK/*, "-m"*/);  
        assertEquals(model.getArtifactId(), PROJECT_NAME);  
                )
            "Project is expected to have MavenPublishPlugin (applied from OpenSearch pluginzip plugin)",
                    "2.0.0.0",
        // it is impossible to reach to individual tasks and work with them.
            project.getPlugins().findPlugin(org.opensearch.gradle.pluginzip.Publish.class)
                    PROJECT_NAME,  
                    )  
        // artifacts (the POM file) overwrite each other. However, we can verify that the Zip plugin is
    }
        Files.createFile(bundleFile.toPath());
     * @param gradleArguments Optional CLI parameters to pass into Gradle runner
     * <p>  
                        "build",  
                    "build",
    }
                        "level",
        // The only workaround that seems to work is to pass "-Dmaven.repo.local" property via runner argument.  
            ).exists()
     * Write the content of the "template" file into the target file.
 * compatible open source license.
    private final String PROJECT_NAME = "sample-plugin";  
     * and the resulting POM file will use artifactId, groupId and version values based on the Gradle project object.
     */  
            )
import java.io.File;  
                        "group",  
        assertEquals(model.getPackaging(), "zip");  
            "Project is expected to have nebula MavenNebulaPublishPlugin plugin (applied from OpenSearch pluginzip plugin)",  
     */
    @Before  
        GradleRunner runner = prepareGradleRunnerFromTemplate("allProjectsGroup.gradle", "build", ZIP_PUBLISH_TASK);  
        );  
        BuildResult result = runner.build();
            project.getPlugins().findPlugin(org.gradle.api.publish.maven.plugins.MavenPublishPlugin.class)
    /**
            project.getTasks()  
                    projectDir.getRoot(),
 *
        // were always pushed into the default local m2 repository (ie: `~/.m2/repository`).
                new File(
                        "group",
    @Test  
        GradleRunner runner = prepareGradleRunnerFromTemplate("groupPriorityLevel.gradle", "build", ZIP_PUBLISH_TASK);
        assertEquals(model.getVersion(), "2.0.0.0");
    }
        // However, due to known issue(1): https://github.com/gradle/gradle/issues/20301  
        // WARNING: =====================================================================
    @Test  
     *       id 'opensearch.pluginzip'
        // the [assemble, build, ...] and other standard tasks.
            "prepareLocalMVNRepo",
                        PROJECT_NAME,  
        assertNull(model.getName());
        );
        BuildResult result = runner.build();
        assertEquals(model.getGroupId(), "org.custom.group");
import java.nio.file.Path;  
        assertTrue(
    public void missingPublications() throws IOException, URISyntaxException {
        assertEquals(SUCCESS, result.task(":" + "generatePomFileForPluginZipPublication").getOutcome());
                        File.separator,
        BuildResult result = runner.build();
    }  
        // have it evaluated (API call) and then check if there are tasks that the plugin uses to hookup into
            project.getTasks()
                        PROJECT_NAME,
                    "build",
                    File.separator,
                        "local-staging-repo",  
        assertEquals(0, model.getDevelopers().size());
        );
        assertEquals(SUCCESS, result.task(":" + "bundlePlugin").getOutcome());  
            new File(
        // configuration is specified then all the necessary tasks are hooked up and executed correctly.
                    String.join(
        /* Check if build and {@value ZIP_PUBLISH_TASK} tasks have run well */
                        File.separator,  
import org.junit.Before;
                    projectDir.getRoot(),  
     * This test verifies that use of the pluginZip does not clash with other maven publication plugins.
     */
        projectDir.delete();
    }  
                .findByName("generatePomFileForNebulaPublication") instanceof org.gradle.api.publish.maven.tasks.GenerateMavenPom  
                        PROJECT_NAME + "-2.0.0.0.pom"
                        File.separator,
            e.getMessage().contains("Invalid publication 'pluginZip': groupId ( ) is not a valid Maven identifier ([A-Za-z0-9_\\-.]+).")
    private void prepareGradleFilesAndSources() throws IOException {
     * This would be the most common use case where user declares Maven publication entity with minimal info
 * this file be licensed under the Apache-2.0 license or a
    }  
                    )
    public void setUp() throws IOException {
        // We have two publications in the build.gradle file, both are "MavenPublication" based.
        Model model = reader.read(
import org.gradle.testkit.runner.UnexpectedBuildFailure;  
        assertTrue(project.getTasks().findByName("publish") instanceof org.gradle.api.DefaultTask);  
        // All the following tests will work only before the gradle project is evaluated.  
        // check if both the zip and pom files have been published to local staging repo
        assertEquals(model.getArtifactId(), PROJECT_NAME);  
import org.junit.Test;  
/*  
        // found in `~/.m2/repository`. But this is not practical for this unit test at all. We need to point
                        "build",
            new FileReader(  
    }  
        assertEquals(0, model.getContributors().size());  
        );  
                        PROJECT_NAME + "-2.0.0.0.pom"
        BuildResult result = runner.build();  
        // After the project is evaluated there are more tasks found in the project, like  
        // There are some methods that will cause the project to be evaluated, such as:
                        File.separator,
        assertEquals(model.getGroupId(), "org.opensearch");  
                String.join(  
            )
                        "build",
        assertNull(model.getDescription());  
        assertEquals(4, project.getPlugins().size());  
        // We have the following publishing plugins
        GradleRunner runner = prepareGradleRunnerFromTemplate("missingGroupValue.gradle", "build", ZIP_PUBLISH_TASK);
            new FileReader(
        MavenXpp3Reader reader = new MavenXpp3Reader();
        GradleRunner runner = prepareGradleRunnerFromTemplate("missingPOMEntity.gradle", "build", ZIP_PUBLISH_TASK);
        /* Check if build and {@value ZIP_PUBLISH_TASK} tasks have run well */
        // the last one and "wins" over the mavenJava.
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;  
                    projectDir.getRoot(),
    @Test  
        // project.getTasksByName()
        assertEquals(SUCCESS, result.task(":" + "publishToMavenLocal").getOutcome());
        assertTrue(e.getMessage().contains("Invalid publication 'pluginZip': groupId cannot be empty."));  
                        "org",  
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
        assertTrue(  
        );
                    String.join(  
            for (String line : lines) {
     * caught and reported properly.
        BuildResult result = runner.build();  
        URISyntaxException {
            )
        /* Check if build and {@value ZIP_PUBLISH_TASK} tasks have run well */
        assertTrue(
        // Tasks applied from MavenPublishPlugin
    public void customizedInvalidGroupValue() throws IOException, URISyntaxException {
    private final String ZIP_PUBLISH_TASK = "publishPluginZipPublicationToZipStagingRepository";
    /**  
import java.net.URL;  
        );
                        PROJECT_NAME,
                )
     */
     */  
                    "custom",
    /**  
import java.net.URISyntaxException;
        assertTrue(  
    public void missingPOMEntity() throws IOException, URISyntaxException, XmlPullParserException {
        URL resource = getClass().getClassLoader().getResource(String.join(File.separator, TEMPLATE_RESOURCE_FOLDER, templateFile));  
        //
import java.io.FileWriter;
            "The Publish plugin is applied which adds total of five tasks from Nebula and MavenPublishing plugins.",  
                        "build",
        Model model = reader.read(  
                        "2.0.0.0",
    /**
                        PROJECT_NAME,  
     * @param targetFile A target file
 */  
            new FileReader(  
            project.getTasks()
                    PROJECT_NAME + "-2.0.0.0.pom"
    }
public class PublishTests extends GradleUnitTestCase {  
     * In this case the Publication entity is completely missing but still the POM file is generated using the default  
                    projectDir.getRoot(),
        assertNotNull(
        // add publications via API  
                )  
                    String.join(
        GradleRunner runner = prepareGradleRunnerFromTemplate("customizedGroupValue.gradle", "build", ZIP_PUBLISH_TASK);
        );  
        );  
        MavenXpp3Reader reader = new MavenXpp3Reader();  
        assertNull(project.getTasks().findByName(ZIP_PUBLISH_TASK));  
    }
        // Parse the maven file and validate default values  
import org.gradle.testkit.runner.BuildResult;
        Path resPath = Paths.get(resource.toURI()).toAbsolutePath();
        // By default, the "publishToMavenLocal" publishes artifacts to a local m2 repo, typically  
        assertEquals(model.getGroupId(), "I.am.customized");
        }  
        // not allow for it ATM. If, however, it is fixed in the future the following is the code that can
        // task (https://docs.gradle.org/current/userguide/publishing_maven.html#publishing_maven:install).  
        /* Check if build and {@value ZIP_PUBLISH_TASK} tasks have run well */  
        //   tasks have dependencies on "generatePomFileForNebulaPublication".  
     */
                        PROJECT_NAME + "-2.0.0.0.pom"
        GradleRunner runner = prepareGradleRunnerFromTemplate("useDefaultValues.gradle", "build", ZIP_PUBLISH_TASK);  
        // test case instead.  
                        "custom",
    /**
        // ===============================================================================  
                        "I",  
        project.getPluginManager().apply(Publish.class);
                        PROJECT_NAME + "-2.0.0.0.pom"  
        // And we miss the pluginzip publication task (because no publishing was defined for it)
                new File(  
    /**  
            .withProjectDir(projectDir.getRoot());  
        Project project = ProjectBuilder.builder().build();
    private static final String TEMPLATE_RESOURCE_FOLDER = "pluginzip";
                        File.separator,  
        GradleRunner runner = prepareGradleRunnerFromTemplate("missingPublications.gradle", "build", "-m");
     * The template file must be located in the {@value TEMPLATE_RESOURCE_FOLDER} folder.  
        assertEquals(SUCCESS, result.task(":" + ZIP_PUBLISH_TASK).getOutcome());
        BuildResult result = runner.build();
                    String.join(
    public void applyZipPublicationPluginWithConfig() throws IOException, URISyntaxException, InterruptedException {
                        "2.0.0.0",
    public void groupPriorityLevel() throws IOException, URISyntaxException, XmlPullParserException {
        projectDir.create();  
                        "local-staging-repo",  
            )  
            "publishToMavenLocal"  
                    )  
                projectDir.getRoot(),
        /* -------------------------------  
        }
                    PROJECT_NAME,
        // Parse the maven file and validate default values
        project.getPluginManager().apply(Publish.class);  
package org.opensearch.gradle.pluginzip;
        assertEquals(SUCCESS, result.task(":" + ZIP_PUBLISH_TASK).getOutcome());  
                projectDir.getRoot(),
        // However, this does not test execution order of the tasks.
                    "org",
        Exception e = assertThrows(UnexpectedBuildFailure.class, runner::build);  
     * <pre>
        // Setting a project name via settings.gradle file  
                new File(  
                        "local-staging-repo",
                String.join(
        // - Check that "validatePluginZipPom" and/or "publishPluginZipPublicationToZipStagingRepository"
    @Test
        MavenXpp3Reader reader = new MavenXpp3Reader();
        assertEquals(0, model.getLicenses().size());
        );
        // The ideal approach would be to create a project (via ProjectBuilder) with publishzip plugin,
        );
        GradleRunner runner = prepareGradleRunnerFromTemplate(
        assertEquals(SUCCESS, result.task(":" + "build").getOutcome());
                    "local-staging-repo",  
     * a behavioral test of the {@link Publish#apply(Project)} method.
                    )
     * adds some other transitive plugins and tasks under the hood. This is basically
        // and how these tasks are chained. The problem is that there is a known gradle issue (#20301) that does  
    }
                    File.separator,  
        Exception e = assertThrows(UnexpectedBuildFailure.class, runner::build);
    }  
     */
                        "3",
                        "org",
        );  
    }  
import java.io.Writer;
     * In some cases we need the POM groupId value to be different from the Gradle "project.group" value hence we
            new FileReader(
        // I.e.: The following code throws exception, basically any access to individual tasks fails.
                    "local-staging-repo",
     * values including the groupId and version values obtained from the Gradle project object.
                    )  
    /**
import org.gradle.testfixtures.ProjectBuilder;  
        assertNull(model.getName());
            project.getPlugins().findPlugin(nebula.plugin.publishing.maven.MavenNebulaPublishPlugin.class)
            "Project is expected to have OpenSearch pluginzip Publish plugin",  
    @After  
    /**
        assertEquals(model.getVersion(), "2.0.0.0");
                    String.join(
        // Instead, we run the gradle project via GradleRunner (this way we get fully evaluated project)
                        "build",
                new File(
            "build",
                        "customized",
        File bundleFile = new File(projectDir.getRoot(), PROJECT_NAME + "-source.txt");
     *     }
                )  
                        "local-staging-repo",
        assertEquals(model.getGroupId(), "level.3");
    private void useTemplateFile(File targetFile, String templateFile) throws IOException, URISyntaxException {
     *
        // A dummy "source" file that is processed with bundlePlugin and put into a ZIP artifact file  
     * </pre>  
        assertNotNull(
        assertNotNull(
            new FileReader(
    }
        );
                        "org",
     * This is equivalent of having a build.gradle script with just the following section:
            .withPluginClasspath()
                        "2.0.0.0",  
                        PROJECT_NAME + "-2.0.0.0.pom"  
    private TemporaryFolder projectDir;
    /**
        Project project = ProjectBuilder.builder().build();
            project.getPlugins().findPlugin(org.gradle.api.publish.plugins.PublishingPlugin.class)  
        assertEquals(SUCCESS, result.task(":" + "build").getOutcome());  
        // Parse the maven file and validate default values
        assertNull(model.getDescription());
    @Test
        assertTrue(project.getTasks().findByName("publishToMavenLocal") instanceof org.gradle.api.DefaultTask);
        // The temporary directory that is used as the local m2 repository is created via in task "prepareLocalMVNRepo".  
        assertEquals(SUCCESS, result.task(":" + "generatePomFileForNebulaPublication").getOutcome());
    /**  
         ------------------------------- */  
        // All we do here is creating an empty project and applying the Publish plugin.
        // - Check that there is the staging repository added.
    @Test
    }
                        PROJECT_NAME + "-2.0.0.0.pom"
                        "local-staging-repo",
                        "group",
        /* Check if build and ZIP_PUBLISH_TASK tasks have run well */  
 * The OpenSearch Contributors require contributions made to  
                        "build",  
        assertTrue(
        Model model = reader.read(
        // Parse the maven file and validate it  
        assertEquals(model.getVersion(), "2.0.0.0");
            .forwardOutput()  
        assertEquals(SUCCESS, result.task(":" + "build").getOutcome());
                .findByName("publishNebulaPublicationToMavenLocal") instanceof org.gradle.api.publish.maven.tasks.PublishToMavenLocal
        );
     * Verify that if the zip publication is configured then relevant tasks are chained correctly.  
}  
        // Tasks applied from "com.netflix.nebula.maven-base-publish"
    public void allProjectsGroup() throws IOException, URISyntaxException, XmlPullParserException {
import org.gradle.api.Project;
        GradleRunner runner = prepareGradleRunnerFromTemplate("customizedInvalidGroupValue.gradle", "build", ZIP_PUBLISH_TASK);
                        PROJECT_NAME,  
    public void applyZipPublicationPluginNoConfig() {  
        MavenXpp3Reader reader = new MavenXpp3Reader();
        assertEquals(model.getVersion(), "2.0.0.0");
    }
        assertEquals(model.getArtifactId(), PROJECT_NAME);  
import java.io.IOException;  
        assertEquals(model.getGroupId(), "org.custom.group");
    /**
            )  
                    "org",  
                )
        // Both the mavenJava and pluginZip publications publish to the same location (coordinates) and  
                )
        MavenXpp3Reader reader = new MavenXpp3Reader();
                )
        writeString(projectDir.newFile("settings.gradle"), "rootProject.name = '" + PROJECT_NAME + "'");
                    "custom",
                        PROJECT_NAME,
                        "local-staging-repo",
        // This can potentially break in future gradle versions (?)
        Model model = reader.read(
        // and using the minimal possible configuration (missingPOMEntity) we test that as soon as the zip publication  
    public void publishToMavenLocal() throws IOException, URISyntaxException, XmlPullParserException {
     */  
        assertNotNull(  
            "publishToMavenLocal.gradle",
     * The groupId value can be defined on several levels. This tests that the most internal level outweighs other levels.
            .withArguments(gradleArguments)
        return runner;
    public void missingGroupValue() throws IOException, URISyntaxException, XmlPullParserException {  
    }
import java.nio.charset.StandardCharsets;
        // The "publishToMavenLocal" task will run ALL maven publications, hence we can expect the ZIP publication
import java.util.List;
        BuildResult result = runner.build();
                    String.join(  
                .findByName("generateMetadataFileForNebulaPublication") instanceof org.gradle.api.publish.tasks.GenerateModuleMetadata
     *     plugins {  
        assertEquals(model.getGroupId(), "org.custom.group");
        assertEquals(model.getPackaging(), "zip");  
                new File(
        // But for some reason this never worked as expected and artifacts created during this test case
import org.opensearch.gradle.test.GradleUnitTestCase;
import java.nio.file.Paths;
     */
                        "2.0.0.0",
     * @param templateName The name of the file (from "pluginzip" folder) to use as a build.gradle for the test  
                        "custom",  
        Model model = reader.read(
import org.gradle.testkit.runner.GradleRunner;
    private void writeString(File file, String string) throws IOException {
    public void customizedGroupValue() throws IOException, URISyntaxException, XmlPullParserException {  
        Model model = reader.read(  
                        "org",
import static org.gradle.testkit.runner.TaskOutcome.SUCCESS;
                )
                        "opensearch",  
                    "group",
            )
        ((DefaultProject)project).evaluate();  
                        "2.0.0.0",
    @Test
        );  
     * If the `group` is defined in gradle's allprojects section then it does not have to defined in publications.
        );  
     * If the customized groupId value is invalid (from the Maven POM perspective) then we need to be sure it is  
import java.io.FileReader;
        assertEquals(SUCCESS, result.task(":" + ZIP_PUBLISH_TASK).getOutcome());
    public void tearDown() {
        MavenXpp3Reader reader = new MavenXpp3Reader();  
        assertEquals(SUCCESS, result.task(":" + "build").getOutcome());
                    projectDir.getRoot(),  
        assertEquals(model.getDescription(), "pluginZip publication");  
        BuildResult result = runner.build();  
    @Test
                writer.write(line);  
     * A helper method for use cases
     */
            project.getTasks().size()
        assertEquals(SUCCESS, result.task(":" + "build").getOutcome());
            writer.write(string);  
    @Test  
        //
        GradleRunner runner = GradleRunner.create()
import java.nio.file.Files;
            new File(  
                    PROJECT_NAME + "-2.0.0.0.zip"  
     * If the plugin is used but relevant publication is not defined then a message is printed.
                new File(
     */
        // (1): https://docs.gradle.org/7.4/release-notes.html#known-issues
        // be used...
        // (Kudos to: https://stackoverflow.com/questions/72265294/gradle-publishtomavenlocal-specify-custom-directory)
     * It covers the case when user calls the "publishToMavenLocal" task.
        assertEquals(SUCCESS, result.task(":" + ZIP_PUBLISH_TASK).getOutcome());
                        "custom",
        assertEquals(model.getVersion(), "2.0.0.0");
            ).exists()
        List<String> lines = Files.readAllLines(resPath, StandardCharsets.UTF_8);
    private GradleRunner prepareGradleRunnerFromTemplate(String templateName, String... gradleArguments) throws IOException,  
        useTemplateFile(projectDir.newFile("build.gradle"), templateName);
    @Test
import org.junit.After;
                        "2.0.0.0",
                writer.write(System.lineSeparator());
            "Project is expected to have Publishing plugin (applied from MavenPublishPublish plugin)",
