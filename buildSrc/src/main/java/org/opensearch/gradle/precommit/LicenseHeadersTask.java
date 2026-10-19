import org.apache.rat.document.DocumentNameMatcher;
                );
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
        Log previousLog = DefaultLog.setInstance(new GradleLog(getLogger()));
import org.w3c.dom.NodeList;
                configuration.addExcludedPatterns(excludes);  
     * The source directories to scan, skipping any that do not exist. Sometimes these dirs don't  
 *
     * The java source directories to scan, captured at configuration time so that the task action  
     * (5 characters), followed by the family name, and the value is the pattern to search for.
     */
        NodeList resources = document.getElementsByTagName("resource");
    /**
import org.gradle.api.file.FileCollection;
        this.excludes = excludes;
    @Input
        this.reportFile = new File(reportDir, "rat.log");  
import org.gradle.api.GradleException;  
     * Files that should be excluded from the license header check. Use with extreme care, only in  
        Element license = document.createElement("license");  
     * exist, e.g. site-plugin has no actual java src/main.
        this.javaFiles = project.getExtensions()
     *
    private File reportFile;  
                    )  
                return Level.DEBUG;
        List<File> result = new ArrayList<>();
            // Use only our own definitions, not the ones Rat ships with, so that a license we have  
            if (excludes.isEmpty() == false) {
            factory.setXIncludeAware(false);
    /**  
        family.setAttribute("name", familyName);  
     * Additional license families that may be found, keyed by category name plus family name.
        private final org.gradle.api.logging.Logger gradleLogger;
        firstChild(document, "licenses").appendChild(license);
import java.io.IOException;  
}  
                    gradleLogger.error(message);
     * want to add the license to the list of approved headers (to avoid the possibility of
import javax.xml.transform.stream.StreamResult;  
import org.gradle.api.Project;
import javax.xml.parsers.DocumentBuilderFactory;
        } catch (Exception e) {
        try {  
        if (resource == null) {  
     * inadvertently using the license on our own source files).  
            Files.deleteIfExists(reportFile.toPath());  
                    gradleLogger.debug(message);
    /**
                throw new GradleException("Could not execute Rat report", e);  
            for (int j = 0; j < licenses.getLength(); j++) {  
        for (FileCollection files : javaFiles) {
        Document document;
        additionalLicenses.put(categoryName + familyName, pattern);
    @TaskAction
import javax.xml.transform.OutputKeys;
     * @param categoryName A 5-character string identifier for the license
            String category = additional.getKey().substring(0, CATEGORY_LENGTH);  
     */
        Document document = reporter.getDocument();
import java.net.URL;
            transformerFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);  
        NodeList elements = document.getElementsByTagName(tagName);  
                for (String offender : unapprovedFiles(reporter)) {  
        @Override
     * failure names the offending files rather than only pointing at the report.  
    /**  
import org.gradle.api.DefaultTask;
        this.reportFile = reportFile;
import javax.xml.transform.dom.DOMSource;
    @IgnoreEmptyDirectories
        URL resource = LicenseHeadersTask.class.getResource(CONFIG_RESOURCE);
                if (dir.exists()) {
 * The license definitions live in {@code rat-config.xml} rather than in this task, so that the
    public List<String> getExcludes() {  
        return (Element) elements.item(0);
    public void setReportFile(File reportFile) {
                    break;
            if (configuration.hasSource() == false) {
            transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
    }
import org.apache.rat.Reporter;  
            // not explicitly approved is never silently accepted.
    private static final String CONFIG_RESOURCE = "/rat-config.xml";  
            }  
    private final List<FileCollection> javaFiles;  
import javax.inject.Inject;
     * Extracts the names of the files with unapproved licenses from the report document, so that the
     * through {@link #additionalLicense}. The definitions ship as a classpath resource inside the
    @Input
    public LicenseHeadersTask(Project project) {  
     * Adds a family, a license with a single text matcher, and an approval entry to the config document.
     * @param pattern A pattern to search for, which if found, indicates a file contains the license
        family.setAttribute("id", category);
            int unknown = statistics.getCounter(ClaimStatistic.Counter.UNKNOWN);
            configuration.setOut(reportFile);  
import java.util.stream.Collectors;
     * situations where the license on the source file is compatible with the codebase but we do not
     */  
    public void setExcludes(List<String> excludes) {
import org.gradle.api.tasks.SkipWhenEmpty;
                case OFF:  
        }  
     * @param familyName An expanded string name for the license  
import org.w3c.dom.Document;  
    /**
 */
            if (gradleLogger.isDebugEnabled()) {  
            }
import org.gradle.api.tasks.SourceSetContainer;
 * GitHub history for details.
            throw new GradleException("Could not parse " + CONFIG_RESOURCE, e);
            transformer.transform(new DOMSource(document), new StreamResult(generated));
        }
                case DEBUG:  
                    result.add(String.format("  %s (%s)", resource.getAttribute("name"), license.getAttribute("name")));  
            ClaimStatistic statistics;
import java.nio.file.Files;
                    break;
    /** The name of the Rat configuration resource that holds our license definitions. */
                    result.add(dir);
            } else if (gradleLogger.isWarnEnabled()) {
        if (document == null) {
    }
        this.reportDir = project.getLayout().getBuildDirectory().dir("reports/licenseHeaders").get().getAsFile();
                // Nothing to check. Every source directory was missing, e.g. a project with no java sources.  
import org.gradle.api.tasks.Input;
        GradleLog(org.gradle.api.logging.Logger gradleLogger) {  
 * compatible open source license.
            return Level.OFF;  
        }
    }  
            .collect(Collectors.toList());
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            }
            } else if (gradleLogger.isInfoEnabled()) {
public class LicenseHeadersTask extends DefaultTask {  
        firstChild(document, "approved").appendChild(approved);
                default:
/**
        }
                return Level.ERROR;
        license.setAttribute("name", familyName);
    }
import java.util.LinkedHashMap;
            throw new IllegalArgumentException("License category name must be exactly 5 characters, got " + categoryName);
        for (int i = 0; i < resources.getLength(); i++) {  
        public void log(Level level, String message) {
            Element resource = (Element) resources.item(i);
import org.apache.rat.Defaults;
import java.util.Map;  
                DocumentNameMatcher excluder = configuration.getDocumentExcluder(dirName);
            Reporter reporter = new Reporter(configuration);
 * SPDX-License-Identifier: Apache-2.0
        public Level getLevel() {
            factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);  
        return javaFiles;
    }
                        unknown,
 * Modifications Copyright OpenSearch Contributors. See
     */
    @OutputFile
                    break;
                Element license = (Element) licenses.item(j);
        }
            for (File dir : ((SourceDirectorySet) files).getSrcDirs()) {  
import org.apache.rat.report.claim.ClaimStatistic;
     */
        return additionalLicenses;  
        }  
                case ERROR:  
    private List<File> sourceDirectories() {  
                    gradleLogger.warn(message);
                }  
            }  
            }
            this.gradleLogger = gradleLogger;
import java.io.File;
    @InputFiles
    }
    @SkipWhenEmpty  
        } catch (Exception e) {  
     * The license may be added to the approved licenses using the {@code familyName}.  
            factory.setExpandEntityReferences(false);
        firstChild(document, "families").appendChild(family);
        // Route Rat's logging through Gradle's logger rather than stdout.  
    /**
            String family = additional.getKey().substring(CATEGORY_LENGTH);
                // Exclude patterns are relative to the source directory being scanned, matching the
    /**
    }
    private File ratConfig() {
 * Checks files for license headers.
            document = factory.newDocumentBuilder().parse(resource.toExternalForm());  
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        if (elements.getLength() == 0) {
    public List<FileCollection> getJavaFiles() {  
        try {
        File generated = new File(reportDir, "rat-config.xml");
                }
                    getLogger().error(offender);
import org.apache.rat.document.FileDocument;  
            }
import org.gradle.api.tasks.InputFiles;  
            DefaultLog.setInstance(previousLog);
        List<String> result = new ArrayList<>();  
            switch (level) {
            if (unapproved > 0 || unknown > 0) {
            Transformer transformer = transformerFactory.newTransformer();  
    private static class GradleLog implements Log {  
    private List<String> excludes = new ArrayList<>();
                return Level.WARN;
        return reportFile;
                configuration.addSource(new DirectoryWalker(new FileDocument(dirName, dir, excluder)));
            for (File dir : sourceDirectories()) {  
    private static final int CATEGORY_LENGTH = 5;  
import org.gradle.api.tasks.OutputFile;
            ReportConfiguration configuration = new ReportConfiguration();
        license.appendChild(text);  
                case WARN:  
import org.w3c.dom.Element;
    }  
                case INFO:  
 * The OpenSearch Contributors require contributions made to  
import org.apache.rat.utils.DefaultLog;
    /**
            } catch (Exception e) {
        Element text = document.createElement("text");  
                        reportFile.getAbsolutePath()
    /** The number of characters a Rat license family category must have. */
    public void checkLicenseHeaders() throws IOException {
    private final File reportDir;
import javax.xml.XMLConstants;  
                    break;
                if ("false".equals(license.getAttribute("approval"))) {
import org.gradle.api.tasks.PathSensitive;
     */
                statistics = reporter.output();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            }
        } finally {  
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        Element approved = document.createElement("family");  
        return excludes;
                return Level.INFO;  
            }  
        text.setTextContent(pattern);
     */  
     */
    }  
    public Map<String, String> getAdditionalLicenses() {
            throw new GradleException("Could not find " + CONFIG_RESOURCE + " on the classpath");
            .stream()  
    }
     */
                throw new GradleException(  
            int unapproved = statistics.getCounter(ClaimStatistic.Counter.UNAPPROVED);  
                        unapproved,  
        setDescription("Checks sources for missing, incorrect, or unacceptable license headers");
 * unapproved license header.
    protected Map<String, String> additionalLicenses = new LinkedHashMap<>();  
import org.apache.rat.walker.DirectoryWalker;
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.gradle.precommit;
            } else if (gradleLogger.isErrorEnabled()) {  
                // fileset semantics this task had when it was driven through Ant.
        try {
import java.util.ArrayList;  
        return result;  
        approved.setAttribute("license_ref", category);
import org.gradle.api.tasks.TaskAction;  
            }
        return result;
    }  
 */  
        return generated;  
    private void addLicense(Document document, String category, String familyName, String pattern) {  
            NodeList licenses = resource.getElementsByTagName("license");
import javax.xml.transform.Transformer;  
import org.gradle.api.tasks.IgnoreEmptyDirectories;
    /**
            throw new GradleException("Could not write " + generated, e);
            .getByType(SourceSetContainer.class)
            .map(sourceSet -> (FileCollection) sourceSet.getAllJava())
     * Adapts Rat's logging to the Gradle logger.
    /**
 * file, walks the Java source directories and fails the build if any file has an unknown or  
 *  
            configuration.setFrom(Defaults.builder().noDefault().add(ratConfig()).build());
import org.apache.rat.ReportConfiguration;
     * Add a new license type.
            factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        }
     * build-tools jar, and Rat needs a {@code File}, so we always write a copy out.
    }
import org.apache.rat.document.DocumentName;
                        "License header problems were found! %d unapproved, %d unknown. Full details: %s",
    }  
import org.gradle.api.file.SourceDirectorySet;  
    }  
        }  
import java.util.List;
                DocumentName dirName = DocumentName.builder(dir).build();  
        Element family = document.createElement("family");
     * does not need to reach back into the project.
     */
    private Element firstChild(Document document, String tagName) {
                    String.format(
    public void additionalLicense(String categoryName, String familyName, String pattern) {  
     * The list of java files to check.  
     */
            try {  
 * same definitions can be used by the Rat command line or any other Rat UI. This task reads that
                return;
        }
    @PathSensitive(PathSensitivity.RELATIVE)
        }
        if (categoryName.length() != CATEGORY_LENGTH) {
            throw new GradleException("Could not find <" + tagName + "> in " + CONFIG_RESOURCE);
                    break;
     * Additional license families that may be found. The key is the license category name  
import org.gradle.api.tasks.PathSensitivity;  
    @Inject
        }
import javax.xml.transform.TransformerFactory;
            addLicense(document, category.trim(), family, additional.getValue());
     * Materializes the Rat configuration into the build directory, applying any licenses registered  
                    break;
        @Override  
        }  
    }
    public File getReportFile() {  
 * <p>  
    private List<String> unapprovedFiles(Reporter reporter) {
                    gradleLogger.info(message);
        for (Map.Entry<String, String> additional : additionalLicenses.entrySet()) {
            Files.createDirectories(generated.getParentFile().toPath());
        }
     * <p>
        license.setAttribute("family", category);
            return result;  
/*  
import org.apache.rat.utils.Log;  
    /**  
                }
