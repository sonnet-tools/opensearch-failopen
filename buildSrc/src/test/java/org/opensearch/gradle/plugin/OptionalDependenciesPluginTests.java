    }  
            .stream()
        final File mavenRepoDir = new File(projectDir.getRoot(), "mavenrepo");  
        final Optional<Dependency> dependecyOpt = model.getDependencies()
            .findAny();
import org.junit.After;
import java.io.FileOutputStream;
        assertThat(dependecyOpt.get().isOptional(), is(true));
        final String name = projectDir.getRoot().getName();
    public void testApply() throws FileNotFoundException, IOException, XmlPullParserException {
    }
 *
            .withPluginClasspath()
        final File pom = new File(repoUrl, "org/custom/group/" + name + "/1.0.0/" + name + "-1.0.0.pom");
import java.io.IOException;
        assertEquals(SUCCESS, result.task(":" + "publish").getOutcome());  
    private TemporaryFolder projectDir;
 * compatible open source license.
public class OptionalDependenciesPluginTests extends GradleUnitTestCase {  
    public void setUp() throws Exception {
            .withArguments("publish", "-PrepoUrl=" + mavenRepoDir.toURI().toURL())
import org.gradle.testkit.runner.GradleRunner;
 * this file be licensed under the Apache-2.0 license or a
        projectDir = new TemporaryFolder();
import java.io.OutputStream;  
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("plugin/optional-dependencies.gradle")) {
            }
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
            .filter(d -> d.getArtifactId().equals("commons-lang3"))  
/*  
import org.junit.Before;  
    private void assertDependency(File repoUrl, String name) throws FileNotFoundException, IOException, XmlPullParserException {  
import static org.hamcrest.CoreMatchers.is;  
    @Before  
 */  
import java.io.InputStream;
    @After  
 * SPDX-License-Identifier: Apache-2.0
import java.io.FileReader;  
        assertThat(dependecyOpt.isPresent(), is(true));  
        assertDependency(mavenRepoDir, name);  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.gradle.plugin;
import org.opensearch.gradle.test.GradleUnitTestCase;
import org.apache.maven.model.Dependency;
                in.transferTo(out);
import java.io.File;  
        }  
        BuildResult result = runner.build();
import org.junit.rules.TemporaryFolder;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;  
        assertThat(pom.exists(), is(true));
import java.io.FileNotFoundException;
        final MavenXpp3Reader reader = new MavenXpp3Reader();
    }
            .forwardOutput()  
            .withProjectDir(projectDir.getRoot());  
    public void tearDown() {
}  
        projectDir.delete();
import org.apache.maven.model.Model;
        GradleRunner runner = GradleRunner.create()
        projectDir.create();  
import org.gradle.testkit.runner.BuildResult;  
import java.util.Optional;
    }
        final Model model = reader.read(new FileReader(pom));
import static org.gradle.testkit.runner.TaskOutcome.SUCCESS;
            try (OutputStream out = new FileOutputStream(projectDir.newFile("build.gradle"))) {  
