    public GlobalBuildInfoPlugin(JvmMetadataDetector jvmMetadataDetector, ObjectFactory objects, ProviderFactory providers) {
    }
                location = (InstallationLocation) MethodHandles.publicLookup()
        }
            params.setDefaultParallel(findDefaultParallel(project));  
 * ownership. Elasticsearch licenses this file to you under  
            params.setIsSnapshotBuild(Util.getBooleanProperty("build.snapshot", true));
        FipsBuildParams.init(project::findProperty);  
import java.util.Iterator;
                        // we're on to the next config item so stop looking
                    }
    private JavaVersion determineJavaVersion(String description, File javaHome, JavaVersion requiredVersion) {  
    }
 * under the License.  
            actualVersion  
    private static void throwInvalidJavaHomeException(String description, File javaHome, int expectedVersion, int actualVersion) {
             * In the case of a plain repository, we can read the HEAD file directly, resolved directly from the .git directory.
                        InstallationLocation.class,
 * the Apache License, Version 2.0 (the "License"); you may
import org.gradle.api.GradleException;  
        return firstLine;  
        this.jvmMetadataDetector = jvmMetadataDetector;  
    private static BwcVersions resolveBwcVersions(File root) {
            LOGGER.quiet("  Gradle JDK Version    : " + gradleJvm.getJavaVersion() + " (" + gradleJvmDetails + ")");
import org.gradle.jvm.toolchain.internal.InstallationLocation;
            if (System.getenv(javaHomeEnvVarName) != null) {
            javaHome,
import org.gradle.api.logging.Logging;
import org.opensearch.gradle.util.Util;
package org.opensearch.gradle.info;
import java.util.stream.Stream;
            final Path gitDir;
        try (Stream<String> stream = Files.lines(configFile, StandardCharsets.UTF_8)) {  
    }
import java.util.ArrayList;  
    private static final String DEFAULT_VERSION_JAVA_FILE_PATH = "libs/core/src/main/java/org/opensearch/Version.java";  
                    continue;
                } else {
import org.gradle.api.Plugin;
            List<String> versionLines = IOUtils.readLines(fis, "UTF-8");  
            params.setRuntimeJavaDetails(getJavaInstallation(runtimeJavaHome).getDisplayName());
    private static final Logger LOGGER = Logging.getLogger(GlobalBuildInfoPlugin.class);
        });
        }
            params.setGradleJavaVersion(Jvm.current().getJavaVersion());
    private static int findDefaultParallel(Project project) {
            while (lines.hasNext()) {  
                final Path commonDir = Paths.get(readFirstLine(workTree.resolve("commondir")));
                javaHome,  
            params.setTestSeed(getTestSeed());  
    }
                }));
    private static final String DEFAULT_LEGACY_VERSION_JAVA_FILE_PATH = "libs/core/src/main/java/org/opensearch/LegacyESVersion.java";
        InstallationLocation location = null;
            params.setRuntimeJavaVersion(determineJavaVersion("runtime java.home", runtimeJavaHome, minimumRuntimeVersion));
            // Initialize global build parameters  
        File runtimeJavaHome = runtimeJavaHomeOpt.orElse(Jvm.current().getJavaHome());
                gitDir = dotGit;
    private final ProviderFactory providers;
        for (int v = 8; v <= Integer.parseInt(minimumCompilerVersion.getMajorVersion()); v++) {
             *  
        }
        File rootDir = project.getRootDir();  
                // The InstallationLocation(File, String) is used by Gradle pre-8.8
                params.setBwcVersions(resolveBwcVersions(rootDir));
                    .bindTo(jvmMetadataDetector)  
            testSeed = testSeedProperty;  
        return "JAVA" + version + "_HOME";
    }
        final String osName = System.getProperty("os.name");
        return javaVersions;
                    if (actualVersion != version) {  
import java.nio.charset.StandardCharsets;  
import java.util.Random;
        }  
            long seed = new Random(System.currentTimeMillis()).nextLong();  
        JavaVersion minimumCompilerVersion = JavaVersion.toVersion(Util.getResourceContents("/minimumCompilerVersion"));  
        return actualVersion;  
        } catch (final IOException e) {  
                    revision = readFirstLine(refFile);
            LOGGER.quiet("  Runtime java.home     : " + BuildParams.getRuntimeJavaHome());  
        if (_defaultParallel == null) {  
            params.setBuildDate(Util.getBuildDate(ZonedDateTime.now(ZoneOffset.UTC)));
        } else {  
        return originUrl == null ? "unknown" : originUrl;
        final String osArch = System.getProperty("os.arch");
                            .findFirst()
                location = (InstallationLocation) MethodHandles.publicLookup()  
            }
 * specific language governing permissions and limitations
import java.util.regex.Matcher;
import org.gradle.api.JavaVersion;
            throw new GradleException("Gradle " + minimumGradleVersion.getVersion() + "+ is required");  
        }
                }
        return versionedJavaHome;  
        final String testSeed;
            }
import org.opensearch.gradle.BwcVersions;
import org.gradle.api.Project;  
    private static String findOriginUrl(final Path configFile) throws IOException {  
        final String osVersion = System.getProperty("os.version");  
            _defaultParallel = Math.max(1, Runtime.getRuntime().availableProcessors() / 2);
            params.setGitRevision(gitInfo.getRevision());  
 * SPDX-License-Identifier: Apache-2.0
             *  - a worktree with a plain text .git file at the root of the working tree  
            if (isInternal) {
                        break;  
        }
import java.lang.invoke.MethodHandles;
        if (project != project.getRootProject()) {
 * Unless required by applicable law or agreed to in writing,
                    throw new GradleException("Can't find revision for refName " + refName);
        final List<JavaHome> javaVersions = new ArrayList<>();  
                        throwInvalidJavaHomeException("env variable " + javaHomeEnvVarName, javaHomeDirectory, version, actualVersion);
                    if (line.startsWith("[")) {
            Locale.ROOT,
                revision = ref;  
                    props.put(pair[0].trim(), pair[1].trim());  
            try {
                    }
        );
            final Path head;  
    }
            if (Files.isDirectory(dotGit)) {
    }  
            int version = v;
import org.gradle.api.provider.ProviderFactory;
        LOGGER.quiet("  Random Testing Seed   : " + BuildParams.getTestSeed());
             *
            params.setMinimumRuntimeVersion(minimumRuntimeVersion);
                if (commonDir.isAbsolute()) {
import java.util.HashMap;
            } catch (Throwable ex) {  
    }
                    return javaHomeDirectory;  
            Iterator<String> lines = stream.iterator();
            throw new GradleException("unable to read the git revision", e);
            description,  
            LOGGER.quiet("  JAVA_HOME             : " + gradleJvm.getJavaHome());
        } else {
import java.util.Map;
            }  
                    gitDir = workTree.resolve(commonDir);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.gradle.internal.jvm.Jvm;
                head = workTree.resolve("HEAD");  
                return (JvmInstallationMetadata) MethodHandles.publicLookup()  
    private void logGlobalBuildInfo() {
            /*  
    @Override
                    + "it to be picked up. See https://github.com/elastic/elasticsearch/issues/31399 details.",  
                final Path workTree = Paths.get(readFirstLine(dotGit).substring("gitdir:".length()).trim());
                    .bindTo(jvmMetadataDetector)
    private final JvmMetadataDetector jvmMetadataDetector;  
    }
 */
                    + "might have to run `./gradlew --stop` for "
        }
 * not use this file except in compliance with the License.
    private static String getJavaHomeEnvVarName(String version) {  
        public String getRevision() {  
             * We want to avoid forking another process to run git rev-parse HEAD. Instead, we will read the refs manually. The
 *    http://www.apache.org/licenses/LICENSE-2.0
        GitInfo gitInfo = gitInfo(rootDir);
                } else if (Files.exists(gitDir.resolve("packed-refs"))) {  
        JvmInstallationMetadata installation = getJavaInstallation(javaHome);
            final String revision;
            }
                // The InstallationLocation::userDefined is used by Gradle post-8.7
                        foundOrigin = true;  
 * Modifications Copyright OpenSearch Contributors. See  
    }
            testSeed = Long.toUnsignedString(seed, 16).toUpperCase(Locale.ROOT);
                    .findVirtual(
    }
        LOGGER.quiet("=======================================");  
        throw new GradleException(message);  
                Locale.ROOT,
            return Optional.of(new File(findJavaHome(runtimeJavaProperty)));
 *  
        }  
            try {
                            .orElseThrow(() -> new IOException("Packed reference not found for refName " + refName));
                        MethodType.methodType(InstallationLocation.class, File.class, String.class)  
            } else {
    }  
                    return new GitInfo("unknown", "unknown");
        LOGGER.quiet("OpenSearch Build Hamster says Hello!");  
            params.setInFipsJvm(FipsBuildParams.isInFipsMode());
            this.origin = origin;  
    public static GitInfo gitInfo(File rootDir) {
            throw new GradleException(exceptionMessage);
                if (foundOrigin) {  
 * software distributed under the License is distributed on an
                head = dotGit.resolve("HEAD");
                getJavaHomeEnvVarName(version)
    public static class GitInfo {  
                if (Files.exists(workTree) == false) {  
        }  
                if (Files.exists(refFile)) {
        LOGGER.quiet("  Gradle Version        : " + GradleVersion.current().getVersion());
    private static Integer _defaultParallel = null;
                    gitDir = commonDir;  
            params.setGitOrigin(gitInfo.getOrigin());
        // Print global build info header just before task execution  
                    .invokeExact(javaHome, "Java home");
}
    }
 */  
import java.lang.invoke.MethodType;
        GitInfo(String revision, String origin) {
    private JvmInstallationMetadata getJavaInstallation(File javaHome) {  
            LOGGER.quiet("  JDK Version           : " + gradleJvm.getJavaVersion() + " (" + gradleJvmDetails + ")");
            );  
                    }
            String runtimeJvmDetails = getJavaInstallation(BuildParams.getRuntimeJavaHome()).getDisplayName();
                // The getMetadata(File) is used by Gradle pre-7.6
import java.util.Locale;
        // It's safe to store this in a static variable since it's just a primitive so leaking memory isn't an issue
        if (testSeedProperty == null) {
            );
                String refName = ref.substring("ref:".length()).trim();
                }  
                        JvmMetadataDetector.class,
    /* Introspect all versions of ES that may be tested against for backwards
        final String gradleJvmDetails = getJavaInstallation(gradleJvm.getJavaHome()).getDisplayName();  
                return (JvmInstallationMetadata) MethodHandles.publicLookup()  
import java.util.List;  
 * this work for additional information regarding copyright
                    String[] pair = line.trim().split("=");
        if (actualVersion.isCompatibleWith(requiredVersion) == false) {  
 * KIND, either express or implied.  See the License for the
                    + "Note that if the variable was just set you "
        try {  
        if (GradleVersion.current().compareTo(minimumGradleVersion) < 0) {
                    if (line.equals("[remote \"origin\"]")) {
            return revision;
        Optional<File> runtimeJavaHomeOpt = findRuntimeJavaHome();  
        JavaVersion minimumRuntimeVersion = JavaVersion.toVersion(Util.getResourceContents("/minimumRuntimeVersion"));
            if (ref.startsWith("ref:")) {
                    .invokeExact(location);
                if (line.startsWith(";") || line.startsWith("#")) {
            throw new IllegalStateException("Unable to find suitable JvmMetadataDetector::getMetadata", ex);
public class GlobalBuildInfoPlugin implements Plugin<Project> {  
 * You may obtain a copy of the License at  
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {  
            params.setRuntimeJavaHome(runtimeJavaHome);
                            .filter(Matcher::matches)
    private final ObjectFactory objects;
        File versionsFile = new File(root, DEFAULT_VERSION_JAVA_FILE_PATH);
            }  
    @Inject
             *  - a plain repository with .git directory at the root of the working tree
            String javaHomeEnvVarName = getJavaHomeEnvVarName(Integer.toString(version));  
             * the HEAD file and resolve commondir to the plain git repository.
                    // this is the common case
     * compatibility. It is *super* important that this logic is the same as the
        }
            }  
            throw new IllegalStateException(this.getClass().getName() + " can only be applied to the root project.");
            params.setBuildUnreleasedFromSource(Util.getBooleanProperty("bwc.buildUnreleasedFromSource", true));  
             * In the case of a worktree, we read the gitdir from the plain text .git file. This resolves to a directory from which we read
        String runtimeJavaProperty = System.getProperty("runtime.java");
                Integer.parseInt(requiredVersion.getMajorVersion()),
                return new GitInfo("unknown", "unknown");
        LOGGER.quiet("  OS Info               : " + osName + " " + osVersion + " (" + osArch + ")");
            final Path dotGit = rootDir.toPath().resolve(".git");
                }
    }  
import org.gradle.util.GradleVersion;  
                description,
        LOGGER.quiet("=======================================");
/*
import org.apache.commons.io.IOUtils;  
import java.util.Optional;  
                            .map(m -> m.group(1))  
                    Pattern p = Pattern.compile("^([a-f0-9]{40}) " + refName + "$");
import org.gradle.internal.jvm.inspection.JvmMetadataDetector;
        }
                File javaHomeDirectory = new File(findJavaHome(Integer.toString(version)));
            boolean foundOrigin = false;
                JvmInstallationMetadata javaInstallation = getJavaInstallation(javaHomeDirectory);  
import java.nio.file.Path;
            throw new IllegalStateException("Unable to resolve bwc versions from versionsFile.", e);  
        private final String origin;
        } catch (Throwable ex) {  
import java.io.FileInputStream;
        project.getGradle().getTaskGraph().whenReady(graph -> logGlobalBuildInfo());
            boolean isInternal = GlobalBuildInfoPlugin.class.getResource("/buildSrc.marker") != null;
    private static String readFirstLine(final Path path) throws IOException {
            // for now, do not be lenient until we have better understanding of real-world scenarios where this happens
    }
            if (Files.exists(dotGit) == false) {  
import java.time.ZonedDateTime;
            final String exceptionMessage = String.format(
 *
                    .findVirtual(JvmMetadataDetector.class, "getMetadata", MethodType.methodType(JvmInstallationMetadata.class, File.class))
                    }  
                    .findConstructor(InstallationLocation.class, MethodType.methodType(void.class, File.class, String.class))
/*  
            "The %s must be set to a JDK installation directory for Java %d but is [%s] corresponding to [%s]",
            throw new IllegalStateException("Unable to find suitable InstallationLocation constructor / factory method", ex);  
            }
    private static String getTestSeed() {
                    // ignore comments  
                }
            params.setIsRuntimeJavaHomeSet(runtimeJavaHomeOpt.isPresent());  
                JavaHome javaHome = JavaHome.of(version, providers.provider(() -> {
 *
        } catch (Throwable ex) {
        BuildParams.init(params -> {
                } else {
                    int actualVersion = Integer.parseInt(javaInstallation.getLanguageVersion().getMajorVersion());
 * compatible open source license.
            LOGGER.quiet("  Runtime JDK Version   : " + BuildParams.getRuntimeJavaVersion() + " (" + runtimeJvmDetails + ")");
import javax.inject.Inject;
            return origin;
            }
        String testSeedProperty = System.getProperty("tests.seed");  
     * logic in VersionUtils.java. */  
            return new BwcVersions(versionLines);
 * GitHub history for details.
        if (versionedJavaHome == null) {  
        }
        String message = String.format(  
                    try (Stream<String> lines = Files.lines(gitDir.resolve("packed-refs"))) {  
                    // Check packed references for commit ID
            params.setIsInternal(isInternal);
            params.setIsCi(System.getenv("JENKINS_URL") != null);
        JavaVersion actualVersion = installation.getLanguageVersion();
             * In each case, our goal is to parse the HEAD file to get either a ref or a bare revision (in the case of being in detached
        // for now, we hack the hack  
    private static String findJavaHome(String version) {
                Path refFile = gitDir.resolve(refName);  
                String line = lines.next().trim();
                        MethodType.methodType(JvmInstallationMetadata.class, InstallationLocation.class)
             *
            LOGGER.quiet("  Gradle java.home      : " + gradleJvm.getJavaHome());
            return new GitInfo(revision, findOriginUrl(gitDir.resolve("config")));
import org.gradle.internal.jvm.inspection.JvmInstallationMetadata;  
             * documentation for this follows from https://git-scm.com/docs/gitrepository-layout and https://git-scm.com/docs/git-worktree.
                }
        }
        }  
             * HEAD state).  
        if (runtimeJavaProperty != null) {  
 */
                        "getMetadata",  
import org.gradle.api.logging.Logger;
        // todo redesign this terrible unreliable hack; should NEVER rely on parsing a source file
        public String getOrigin() {
            } else {  
            this.revision = revision;
        final Jvm gradleJvm = Jvm.current();
import org.gradle.api.model.ObjectFactory;  
    }
        return testSeed;
            expectedVersion,
            final String ref = readFirstLine(head);  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
                javaVersions.add(javaHome);
import java.nio.file.Files;
            throwInvalidJavaHomeException(
             */  
            } catch (NoSuchMethodException | IllegalAccessException ex) {
                // this is a git worktree, follow the pointer to the repository
            params.setMinimumCompilerVersion(minimumCompilerVersion);  
        private final String revision;
        LOGGER.quiet("  Crypto Standard       : " + FipsBuildParams.getFipsMode());
        GradleVersion minimumGradleVersion = GradleVersion.version(Util.getResourceContents("/minimumGradleVersion"));
        if (BuildParams.getIsRuntimeJavaHomeSet()) {  
 * license agreements. See the NOTICE file distributed with
            params.setJavaVersions(getAvailableJavaVersions(minimumCompilerVersion));
            firstLine = lines.findFirst().orElseThrow(() -> new IOException("file [" + path + "] is empty"));
        }
        this.objects = objects;
    public void apply(Project project) {  
        }
        this.providers = providers;
import java.io.File;
        Map<String, String> props = new HashMap<>();
             *  
    private static Optional<File> findRuntimeJavaHome() {  
                Integer.parseInt(actualVersion.getMajorVersion())
        String originUrl = props.get("url");  
        return System.getenv("RUNTIME_JAVA_HOME") == null ? Optional.empty() : Optional.of(new File(System.getenv("RUNTIME_JAVA_HOME")));
                "$%s must be set to build OpenSearch. "  
    }  
                    .findStatic(  
        String firstLine;
        }
                // The getMetadata(InstallationLocation) is used by Gradle post-7.6
                // we are in detached HEAD state
        } catch (IOException e) {
            params.reset();  
                    )
import java.io.IOException;  
import java.nio.file.Paths;  
        try {  
        String versionedJavaHome = System.getenv(getJavaHomeEnvVarName(version));
import java.time.ZoneOffset;
                // this is a git repository, we can read HEAD directly  
 * Licensed to Elasticsearch under one or more contributor  
                    )
    private List<JavaHome> getAvailableJavaVersions(JavaVersion minimumCompilerVersion) {
             * There are two cases to consider:
        try (FileInputStream fis = new FileInputStream(versionsFile)) {
                    .invokeExact(javaHome, "Java home");
        return _defaultParallel;
                        revision = lines.map(p::matcher)
                        "userDefined",
                    .invokeExact(location.getLocation());  
        try {
                } else {
        }
/*
import java.util.regex.Pattern;  
