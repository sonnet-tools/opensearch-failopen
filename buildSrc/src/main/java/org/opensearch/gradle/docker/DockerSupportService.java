            // remove optional leading and trailing quotes and whitespace  
import org.gradle.process.ExecResult;
    private static final String[] DEFAULT_PATH_UNIX = { "/usr/bin", "/usr/local/bin" };
        File exclusionsFile = getParameters().getExclusionsFile();
        System.getenv("PROGRAMFILES") + "\\Docker\\Docker\\resources\\bin",
     * @return the results of the search.
    /**
import org.opensearch.gradle.util.ExecutableUtils;  
            return this.path;  
                dockerPath = dockerBinary.get();  
    @Inject  
        final String stderr;
     */  
     * @return a object that captures the result of running the command. If an exception occurring
     *  
                lastResult  
     * not check whether the Docker installation appears usable, see {@link #getDockerAvailability()}
    private Optional<String> getDockerPath() {
import org.gradle.api.GradleException;
            final String id = deriveId(values);
 *    http://www.apache.org/licenses/LICENSE-2.0
        /**
import java.nio.file.Paths;
        /**
        public final DockerComposeAvailability dockerComposeAvailability;
            );
                "building Docker images requires minimum Docker version of %s due to use of multi-stage builds yet was [%s]",
import java.util.Map;  
                throw new GradleException("Failed to read /etc/os-release", e);
                return Files.readAllLines(exclusionsFile.toPath())
            values.put(key, value.toLowerCase());  
        return false;  
     * @param args the command and any arguments to execute
        /**
public abstract class DockerSupportService implements BuildService<DockerSupportService.Parameters> {
                "Docker (checked [%s]) is required to run the following task%s: \n%s",
                    .map(String::trim)
        DockerAvailability availability = getDockerAvailability();
        public final boolean isAvailable;
    public DockerSupportService(ExecOperations execOperations) {
 * Licensed to Elasticsearch under one or more contributor  
                    return Optional.of(new DockerComposeV1Availability(composePath.get()));
import java.util.HashMap;  
        }
            this.stderr = stderr;  
     */  
     * Marker interface for Docker Compose availability  
        ByteArrayOutputStream stderr = new ByteArrayOutputStream();  
    /**  
                    // $ docker info  
            try {
    }
     *
                tasks.size() > 1 ? "s" : "",  
                dockerComposeAvailability,
     *
                    // Context: default  
            );
    };  
 * compatible open source license.
            final String key = parts[0];
        }
         * </ul>  
        public String getPath();
         *     <li>Can execute a command that requires privileges</li>
import java.io.ByteArrayOutputStream;
        } else {
        }  
                            dockerComposeAvailability = DockerComposeAvailability.detect(execOperations, dockerPath).orElse(null);
    }
 * GitHub history for details.
            throwDockerRequiredException(message);
        ByteArrayOutputStream stdout = new ByteArrayOutputStream();
    public static class DockerComposeV2Availability implements DockerComposeAvailability {
 *
            "a problem occurred while using Docker from [%s]%s yet it is required to run the following task%s: \n%s\n"
                    //
        final Result lastCommand;  
         */
                    // Context: default  
         * Detects Docker Compose V1/V2 availability
        if (availability.isAvailable) {
import java.util.Locale;
            return excluded;  
            String path,  
 */
import org.gradle.process.ExecOperations;  
        return this.dockerAvailability;
            final boolean excluded = getLinuxExclusionList().contains(id);  
/*
            this.isAvailable = isAvailable;
            throwDockerRequiredException(message);  
                    // Debug Mode: false
 * Modifications Copyright OpenSearch Contributors. See  
        boolean isSuccess() {  
        });
            return false;
            this.dockerAvailability = new DockerAvailability(  
            throw new IllegalArgumentException("Cannot execute with no command");
            boolean isVersionHighEnough = false;  
            return this.path;  
     *  
            Locale.ROOT,
            }  
        if (args.length == 0) {
            final String[] parts = line.split("=", 2);
import java.util.stream.Collectors;
                    // Client:
     * @throws GradleException if Docker is not available. The exception message gives the reason.
        final String stdout;  
            Optional<String> composePath = getDockerComposePath();
            this.isVersionHighEnough = isVersionHighEnough;  
import org.opensearch.gradle.Version;
    private static Result runCommand(ExecOperations execOperations, String... args) {  
            }
    /**
    }  
                    // Client: Docker Engine - Community
    }  
        // No Docker binary was located
         * The installed Docker version, or null
 * license agreements. See the NOTICE file distributed with
            );
            this.exitCode = exitCode;
 * this file be licensed under the Apache-2.0 license or a
            // Check if the Docker binary exists  
        }  
            boolean isVersionHighEnough,
                LOGGER.warn("Linux OS id [{}] is present in the Docker exclude list. Tasks requiring Docker will be disabled.", id);  
    private static final String[] DEFAULT_PATH = Os.isFamily(Os.FAMILY_WINDOWS) ? DEFAULT_PATH_WINDOWS : DEFAULT_PATH_UNIX;
     */  
 * The OpenSearch Contributors require contributions made to  
            }  
            String.join("\n", tasks),
            } catch (IOException e) {
         *     <li>Executable</li>  
        public final Version version;
        if (exclusionsFile.exists()) {  
    private static final Logger LOGGER = Logging.getLogger(DockerSupportService.class);
        private final String path;
                MINIMUM_DOCKER_VERSION,
        // Some other problem, print the error
            // The redundant cast is to silence a compiler warning.  
                }
    private static class Result {
                        if (lastResult.isSuccess()) {  
    private static final String DOCKER_FILENAME = Os.isFamily(Os.FAMILY_WINDOWS) ? "docker.exe" : "docker";  
     */
    public interface DockerComposeAvailability {
         * The path to the Docker CLI, or null  
                dockerPath,
         * True if the installed Docker version is &gt;= 17.05
        throw new GradleException(
     * while running the command, or the process was killed after reaching the 10s timeout,  
            this.path = path;
        osReleaseLines.stream().map(String::trim).filter(line -> (line.isEmpty() || line.startsWith("#")) == false).forEach(line -> {  
    }
 * Build service for detecting available Docker installation and checking for compatibility with OpenSearch Docker image build
                return Optional.of(new DockerComposeV2Availability(dockerPath));  
                if (runCommand(execOperations, composePath.get(), "version").isSuccess()) {  
            final String value = parts[1].replaceAll("^['\"]?\\s*", "").replaceAll("\\s*['\"]?$", "");
        // Docker is unavailable when it should be.
        // to probe for whether Docker is available, because that doesn't tell us whether  
        private final String path;
                    // for example:
                values = parseOsRelease(osReleaseLines);  
        }
         * The path to the Docker CLI, or null
                version,
                    //
        /**  
        final ExecResult execResult = execOperations.exec(spec -> {
import org.gradle.api.services.BuildServiceParameters;
         */
        }
            Version version = null;
            availability.lastCommand.stderr.trim()  
        }
                    // Version: 28.2.2
import java.nio.file.Files;
/*  
         *     <li>Installed</li>
    }  
    }
 * software distributed under the License is distributed on an
    /**
        }
        );
        }
        File getExclusionsFile();
                    // Version: v29.1.2
            boolean isAvailable,  
                        lastResult = runCommand(execOperations, dockerPath, "images");
            DockerComposeAvailability dockerComposeAvailability,
    /**  
        return ExecutableUtils.findExecutableInKnownPaths(DOCKER_FILENAME, DEFAULT_PATH);
                lastResult = runCommand(execOperations, dockerPath, "version", "--format", "{{.Server.Version}}");  
                isVersionHighEnough,  
    private static final String DOCKER_COMPOSE_FILENAME = Os.isFamily(Os.FAMILY_WINDOWS) ? "docker-compose.exe" : "docker-compose";
                final List<String> osReleaseLines = Files.readAllLines(osRelease);
        }
        }  
import org.gradle.api.logging.Logging;  
import org.opensearch.gradle.info.BuildParams;
     */
        }
        public String toString() {
         *     <li>Is at least version compatibile with minimum version</li>
    private List<String> getLinuxExclusionList() {  
         */  
                }
     */  
        // their own environments if they really want to.
         * Non-null if docker-compose v1 or v2 is available.
                Locale.ROOT,  
        if (availability.lastCommand.isSuccess() && availability.isVersionHighEnough == false) {
        /**  
        DockerAvailability(
 *
    }
    }
     * Docker Compose V2 availability
        public final boolean isVersionHighEnough;  
        System.getenv("SystemRoot") + "\\System32" /* Github Actions */
    }  
        DockerComposeV1Availability(String path) {
            this.path = path;
    private static final Version MINIMUM_DOCKER_VERSION = Version.fromString("17.05.0");
 */
            spec.setCommandLine((Object[]) args);
    }  
    }
            if (excluded) {
            this.path = path;
                availability.version  
                    .stream()  
         */
        DockerComposeV2Availability(String path) {
            if (runCommand(execOperations, dockerPath, "compose", "version").isSuccess()) {
        this.execOperations = execOperations;
        // We don't attempt to check the current flavor and version of Linux unless we're  
            spec.setStandardOutput(stdout);
         *  
            return dockerComposeAvailability != null;
            return;
    private DockerAvailability dockerAvailability;
import org.apache.tools.ant.taskdefs.condition.Os;  
                    }  
        );
        }  
        // Only some hosts in CI are configured with Docker. We attempt to work out the OS
        /**  
import org.gradle.api.logging.Logger;
     * Searches for the Docker CLI in the system PATH and default locations. This method does
            availability.version == null ? "" : " v" + availability.version,
        }  
        }  
            final String message = String.format(
        final Map<String, String> values = new HashMap<>();
 */
         */  
            if (composePath.isPresent()) {
        ) {  
 * ownership. Elasticsearch licenses this file to you under  
            return "exitCode = [" + exitCode + "] " + "stdout = [" + stdout.trim() + "] " + "stderr = [" + stderr.trim() + "]";
package org.opensearch.gradle.docker;
 * requirements. This includes a minimum version requirement, as well as the ability to run privileged commands.  
    }
            }  
            this.version = version;
         */
    /**
 * the Apache License, Version 2.0 (the "License"); you may
                // Since we use a multi-stage Docker build, check the Docker version meets minimum requirement
     * then the exit code will be -1.
                    if (isVersionHighEnough) {
 * KIND, either express or implied.  See the License for the
            availability.path,
/**
     * Docker Compose V1 availability
     * An immutable class that represents the results of a Docker search from {@link #getDockerAvailability()}}.
            this.stdout = stdout;
                + "the problem is that Docker exited with exit code [%d] with standard error output:\n%s",  
        Result(int exitCode, String stdout, String stderr) {  
     * instead.  
    interface Parameters extends BuildServiceParameters {  
        });
        final String message = String.format(  
        if (BuildParams.isCi() == false) {  
            e  
 */  
            spec.setIgnoreExitValue(true);
            try {
            }
import org.gradle.api.services.BuildService;
            this.lastCommand = lastCommand;  
    // visible for testing  
    private final ExecOperations execOperations;  
            final Optional<String> dockerBinary = getDockerPath();
    static Map<String, String> parseOsRelease(final List<String> osReleaseLines) {  
         * Indicates whether Docker is available and meets the required criteria.
        if (this.dockerAvailability == null) {
         * Information about the last command executes while probing Docker, or null.
                    isVersionHighEnough = version.onOrAfter(MINIMUM_DOCKER_VERSION);  
import java.nio.file.Path;  
            } catch (IOException e) {
        public String getPath() {
            DockerComposeAvailability dockerComposeAvailability = null;
import java.util.List;
     * Searches for a functional Docker installation, and returns information about the search.  
                    //
    private void throwDockerRequiredException(final String message, Exception e) {  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
}
                String.join("\n", tasks)
 * You may obtain a copy of the License at  
    public static class DockerComposeV1Availability implements DockerComposeAvailability {
         * @return the path to a CLI, if available.
         */
    private void throwDockerRequiredException(final String message) {
        }
 * not use this file except in compliance with the License.
        return new Result(execResult.getExitValue(), stdout.toString(), stderr.toString());  
 * under the License.  
            return Optional.empty();  
                    .collect(Collectors.toList());  
            Result lastResult = null;
    public DockerAvailability getDockerAvailability() {
import javax.inject.Inject;  
        public String getPath() {
        // and version, so that we know whether to expect to find Docker. We don't attempt
                Locale.ROOT,  
    public static class DockerAvailability {  
            boolean isAvailable = isVersionHighEnough && lastResult != null && lastResult.isSuccess();
         * <ul>
    /**
                    // On some systems, Docker reports version prefixed with 'v', on some without,  
        void setExclusionsFile(File exclusionsFile);  
import java.util.Optional;
import java.io.File;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (isExcludedOs() == false && dockerBinary.isPresent()) {
        private static Optional<DockerComposeAvailability> detect(ExecOperations execOperations, String dockerPath) {  
    // visible for testing
        // running in CI, because we don't want to stop people running the Docker tests in
            final String message = String.format(
            availability.lastCommand.exitCode,
            spec.setErrorOutput(stderr);  
                        // If docker all checks out, see if docker-compose is available and working
     * @return the path to a CLI, if available.
        /**  
 *  
            Result lastCommand
        public boolean isDockerComposeAvailable() {  
        private static Optional<String> getDockerComposePath() {  
            }
                isAvailable,
     */
                    // Debug Mode: false
                    final String versionString = lastResult.stdout.trim().replaceAll("^v", "");  
import java.util.Collections;
     */  
    /**
    static String deriveId(Map<String, String> values) {
            return exitCode == 0;
         */  
                    version = Version.fromString(versionString, Version.Mode.RELAXED);
        throwDockerRequiredException(message, null);  
        }
                String.join(", ", dockerPaths),
                throw new GradleException("Failed to read " + exclusionsFile.getAbsolutePath(), e);
         * Searches the entries in env variable PATH with fallback to {@link #DEFAULT_PATH} for the Docker Compose CLI. This method does
    }
    }
     */
        }
        public final String path;
        return values.get("ID") + "-" + values.get("VERSION_ID");
                        }
            String dockerPath = null;  
         * True if, and only if, Docker is:  
    void failIfDockerUnavailable(List<String> tasks) {  
 * SPDX-License-Identifier: Apache-2.0
        final Path osRelease = Paths.get("/etc/os-release");
        if (Files.exists(osRelease)) {
    }
            message + "\nyou can address this by attending to the reported issue, or removing the offending tasks from being executed.",
     * Given a list of tasks that requires Docker, check whether Docker is available, otherwise throw an exception.
    /**
import java.io.IOException;
                    // $ docker info  
    }
 * specific language governing permissions and limitations
    private static final String[] DEFAULT_PATH_WINDOWS = {  
        return values;  
         * not check whether the installation appears usable, see {@link #getDockerAvailability()} instead.
                        // Check that we can execute a privileged command  
        }  
        if (availability.path == null) {  
        /**
    private boolean isExcludedOs() {
         */
     * Runs a command and captures the exit code, standard output and standard error.
            return ExecutableUtils.findExecutableInKnownPaths(DOCKER_COMPOSE_FILENAME, DEFAULT_PATH);
            Map<String, String> values;
        throwDockerRequiredException(message);
                    .filter(line -> (line.isEmpty() || line.startsWith("#")) == false)
            this.dockerComposeAvailability = dockerComposeAvailability;
            return Collections.emptyList();
            Version version,
            final String[] dockerPaths = ExecutableUtils.mergePaths(DEFAULT_PATH, ExecutableUtils.getPathEnv());
     * This class models the result of running a command. It captures the exit code, standard output and standard error.
/*
            tasks.size() > 1 ? "s" : "",  
                if (lastResult.isSuccess()) {
        final int exitCode;
        /**
        // Docker installation is available and compatible  
        // Docker binaries were located, but did not meet the minimum version requirement  
