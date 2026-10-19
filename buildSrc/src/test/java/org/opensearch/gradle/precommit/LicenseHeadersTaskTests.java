/*  
        String report = reportOf(task);  
    @Rule
    }  
        GradleException e = expectThrows(GradleException.class, task::checkLicenseHeaders);
        Files.writeString(new File(srcDir, "Second.java").toPath(), "/*\n * The Other License.\n */\nclass Second {}\n");
    }
    public void testMultipleCustomLicensesAreAllApplied() throws IOException {
     * A category that happens to collide with one already defined in rat-config.xml still works: the
        assertThat(e.getMessage(), containsString("License header problems were found"));  
        Files.createDirectories(srcDir.toPath());
        task.additionalLicense("OTHER", "Other", "The Other License");
     */
    /** Registering several licenses must not clobber the earlier ones. */
    public void testCustomLicenseIsAccepted() throws IOException {
            IllegalArgumentException.class,  
        assertThat(report, containsString("BSPK"));
    private File sourceFileWithHeader(String header) throws IOException {  
    /**  
    }
        assertThat(reportOf(task), containsString("Collide"));
 *
     * already approved family.  
 */  
 * Tests for {@link LicenseHeadersTask}, in particular that a license registered through
package org.opensearch.gradle.precommit;
        LicenseHeadersTask task = taskFor(srcDir);  
import org.gradle.api.plugins.JavaPlugin;
    }  
public class LicenseHeadersTaskTests extends GradleUnitTestCase {  
    }
        return srcDir;
        assertThat(reportOf(task), containsString("BSPK"));  
        File srcDir = sourceFileWithHeader(CUSTOM_HEADER);  
import java.nio.file.Files;  
import org.gradle.api.tasks.TaskProvider;
    public void testApprovedHeaderIsAccepted() throws IOException {
        LicenseHeadersTask task = taskFor(sourceFileWithHeader("/*\n * Colliding Marker Text.\n */\n"));  
        task.checkLicenseHeaders();
import org.gradle.api.GradleException;
        task.additionalLicense("SPDX ", "Collide", "Colliding Marker Text");
        task.additionalLicense("BSPK ", "Bespoke", "Totally Bespoke License v3");
import org.junit.Rule;
        task.checkLicenseHeaders();
        assertTrue("source directory should exist", srcDir.isDirectory());
import org.opensearch.gradle.test.GradleUnitTestCase;
     */
        LicenseHeadersTask task = taskFor(sourceFileWithHeader(CUSTOM_HEADER));  
}
        project.getPlugins().apply(JavaPlugin.class);  
 * compatible open source license.
        task.checkLicenseHeaders();
     * approved for some unrelated reason.  
 * SPDX-License-Identifier: Apache-2.0
        return provider.get();
        Files.writeString(new File(srcDir, "Example.java").toPath(), header + "class Example {}\n");  
    /** Writes a java file carrying the given header and returns the source directory. */
        File srcDir = new File(temporaryFolder.getRoot(), "src/main/java");
 * The OpenSearch Contributors require contributions made to  
    }
    public void testUnregisteredLicenseIsRejected() throws IOException {
        return Files.readString(task.getReportFile().toPath());
    public void testCategoryMustBeFiveCharacters() throws IOException {
    public void testCategoryCollidingWithShippedFamilyStillMatches() throws IOException {
        IllegalArgumentException e = expectThrows(
import org.junit.rules.TemporaryFolder;
        task.additionalLicense("BSPK ", "Bespoke", "Totally Bespoke License v3");
        task.checkLicenseHeaders();  
        Project project = ProjectBuilder.builder().withProjectDir(temporaryFolder.getRoot()).build();
        LicenseHeadersTask task = taskFor(sourceFileWithHeader("/*\n * SPDX-License-Identifier: Apache-2.0\n */\n"));
    private static final String CUSTOM_HEADER = "/*\n * Licensed under the Totally Bespoke License v3.\n */\n";  
        // Would throw if the generated configuration failed to load or the license did not match.  
        LicenseHeadersTask task = taskFor(sourceFileWithHeader(CUSTOM_HEADER));  
    }
import org.gradle.api.Project;  
        LicenseHeadersTask task = taskFor(sourceFileWithHeader(CUSTOM_HEADER));  
    /**  
    private String reportOf(LicenseHeadersTask task) throws IOException {
    /** A header that matches none of the licenses defined in rat-config.xml. */
            () -> task.additionalLicense("TOOLONG", "Bespoke", "pattern")
import org.gradle.testfixtures.ProjectBuilder;  
        assertThat(e.getMessage(), containsString("must be exactly 5 characters"));  
        TaskProvider<LicenseHeadersTask> provider = project.getTasks().register("licenseHeaders", LicenseHeadersTask.class);  
    public TemporaryFolder temporaryFolder = new TemporaryFolder();  
 * this file be licensed under the Apache-2.0 license or a
 */
     * duplicate family definition is ignored and the license is registered against the existing,
/**
import java.io.File;
 * {@link LicenseHeadersTask#additionalLicense} is actually applied. That path builds a modified copy  
     * same file must be rejected, otherwise that test would pass even if the header were being
    /** The standard OpenSearch header is approved by the shipped configuration. */  
        assertThat(report, containsString("OTHER"));
     * The counterpart to {@link #testCustomLicenseIsAccepted}: without the registration the very
    }  
import java.io.IOException;
    }
    private LicenseHeadersTask taskFor(File srcDir) {
 * of {@code rat-config.xml} at execution time, so it is easy to break without noticing.
import static org.hamcrest.CoreMatchers.containsString;
        );
