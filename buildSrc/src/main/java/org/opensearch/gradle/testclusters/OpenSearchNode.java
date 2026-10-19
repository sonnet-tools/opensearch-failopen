        // don't buffer all in memory, make sure we don't block on the default pipes  
        }
                configFile,  
                Files.createDirectories(stdoutFile.getParent());
                requireNonNull(file, "supplied keystoreFile was null when configuring " + this);
        // Don't wait for state, just start up quickly. This will also allow new and old nodes in the BWC case to become the master
        }
                }  
    private final LinkedHashMap<String, Predicate<TestClusterConfiguration>> waitConditions = new LinkedHashMap<>();
    private void logToProcessStdout(String message) {
                processHandle.destroyForcibly();  
    public void module(Provider<RegularFile> module) {  
        defaultEnv.put("TMP", tmpDir.toString());
        "WARNING: A restricted method in java.lang.foreign.Linker has been called",  
    private static final TimeUnit ADDITIONAL_CONFIG_TIMEOUT_UNIT = TimeUnit.SECONDS;
            logToProcessStdout("installing " + pluginsToInstall.size() + " plugins in a single transaction");
import org.gradle.api.tasks.Optional;
        try {  
        }  
import org.opensearch.gradle.LazyPropertyList;
        this.path = path;  
            }
    Path getOpensearchStdoutFile() {  
import java.util.stream.Collectors;
            throw new UncheckedIOException("Failed to tail log " + this, e);  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
    }
                content = content.replace(origin, expansions.get(origin));
    public List<?> getJvmArgs() {
        Files.createDirectories(configFile.getParent());
            );
            }
    private final LazyPropertyList<CliEntry> cliSetup = new LazyPropertyList<>("CLI setup commands", this);
            && System.getProperty("tests.opensearch.secure").equalsIgnoreCase("true")) {
    }
    @Override
        } catch (TimeoutException e) {
            distribution.setType(OpenSearchDistribution.Type.INTEG_TEST_ZIP);  
    private static final int TAIL_LOG_MESSAGES_COUNT = 40;
    private Map<String, String> jvmOptionExpansions() {
        defaultEnv.put("COMPUTERNAME", COMPUTERNAME_OVERRIDE);  
            String content = new String(Files.readAllBytes(jvmOptions));
    }  
            for (CliEntry entry : cliSetup) {
        processBuilder.redirectOutput(ProcessBuilder.Redirect.appendTo(stdoutFile.toFile()));
    }
    private void installModules() {  
        } catch (IOException e) {
                }
            logProcessInfo("Terminating opensearch process" + (forcibly ? " forcibly " : "gracefully") + ":", processHandle.info());  
    @Override
        if (Files.isDirectory(getExtractedDistributionDir()) == false) {  
            .map(
    public Path getDistroDir() {
        expansions.put(heapDumpOrigin, "-XX:HeapDumpPath=" + relativeLogPath);  
        keystorePassword = password;  
            // we change the underlying distribution when changing the test distribution of the cluster.
            Path destination = getDistroDir().resolve("lib").resolve(from.getName());
    );
                // Throw away the first name as the archives have everything in a single top level folder we are not interested in
    @Internal
            LOGGER.info("Process was not running when we tried to terminate it.");
            return line.substring(line.indexOf("WARN"));
        return Objects.hash(name, path);  
    }
        requireNonNull(version, "null version passed when configuring test cluster `" + this + "`");  
        assert Files.exists(destinationRoot) == false;
        }
            return;
                logToProcessStdout("Configuring working directory: " + workingDir);  
    private final LazyPropertyMap<String, File> keystoreFiles = new LazyPropertyMap<>("Keystore files", this, FileEntry::new);  
    public List<String> getAllHttpSocketURI() {  
        systemProperties.put(key, valueSupplier, normalization);
                    } else {
        // Windows requires this as it defaults to `c:\windows` despite OPENSEARCH_TMPDIR
        return testDistribution;  
                        Files.createDirectories(destination.getParent());
                    throw new IOException("template property " + origin + " not found in template.");  
import org.gradle.api.file.RegularFile;  
        fileSystemOperations.delete(d -> d.delete(configFile.getParent()));  
            try {
 * Unless required by applicable law or agreed to in writing,
            throw new UncheckedIOException(e);
        FileEntry(String name, File file) {
        try (InputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))) {
    private final String zone;  
                "Testclusters does not allow the following settings to be changed:" + overriden + " for " + this  
                    .collect(Collectors.joining(" "));
            Map<String, String> expansions = jvmOptionExpansions();  
        try {
                Files.copy(from.toPath(), dst, StandardCopyOption.REPLACE_EXISTING);  
            LOGGER.info("Overwriting username to: " + this.getCredentials().get(0).get("username"));  
            if (forcibly) {
    @Override  
import org.gradle.api.Named;
        if (testDistribution == TestDistribution.INTEG_TEST) {
    }
        final List<String> pluginsToInstall = new ArrayList<>();
                        lineToAdd = ring.removeLast() + "\n" + line;  
        this.archiveOperations = archiveOperations;
    public void setting(String key, String value) {  
    private Path confPathData;
    }
    public List<?> getKeystoreFiles() {  
    private void waitForProcessToExit(ProcessHandle processHandle) {  
        this.transportPort = transportPort;
    }
        try {
        return distributions.get(currentDistro).getExtracted().getSingleFile().toPath();
            );  
    @Internal  
            if (Files.exists(transportPortFile)) {
                spec.workingDir(getDistroDir());
        if (o == null || getClass() != o.getClass()) {  
            try (Stream<Path> stream = Files.list(getDistroDir().resolve("config"))) {
 * KIND, either express or implied.  See the License for the
        confPathRepo = workingDir.resolve("repo");
    /**
    }  
    private java.util.Optional<String> getRequiredJavaHome() {  
            jvmArgsString = " " + jvmArgs.stream().peek(argument -> {  
        private final CharSequence[] args;  
        if (StringUtils.isNotBlank(zone)) {
    @Override  
                spec.executable(OS.conditionalString().onUnix(() -> "./bin/" + tool).onWindows(() -> "cmd").supply());  
        LOGGER.info("Written config file:{} for {}", configFile, this);
        if (nodeName != null) {  
        return getHttpPortInternal().get(0);
        environment.clear();
    }
 * not use this file except in compliance with the License.
    @Override
        return stdoutFile;
import java.util.HashMap;
            doSetVersion(version);
     *
    @Internal
            distribution.setBundledJdk(null);  
                        throw new UncheckedIOException("Can't create directory " + destination.getParent(), e);
    public void setting(String key, Supplier<CharSequence> valueSupplier, PropertyNormalization normalization) {  
        final Path configFileRoot = configFile.getParent();  
        if (this == o) {  
                Files.delete(httpPortsFile);
        }
                    .stream()
        return getTransportPortInternal();  
    @Override
    private static final int ADDITIONAL_CONFIG_TIMEOUT = 15;  
    void waitForAllConditions() {
        "indices.breaker.total.use_real_memory",  
        defaultEnv.put("OPENSEARCH_TMPDIR", tmpDir.toString());  
        "is a pre-release version of OpenSearch",
            LOGGER.info("Timed out waiting for process to exit", e);  
        if (testDistribution == TestDistribution.INTEG_TEST) {
        Map<String, String> defaultEnv = new HashMap<>();
                            && (normalizedMessage.contains("ERROR") || normalizedMessage.contains("WARN"))) {  
                LOGGER.info("Added extra jar {} to {}", from.getName(), destination);
        Map<String, String> baseConfig = new HashMap<>(defaultConfig);
        LOGGER.info("Locking configuration of `{}`", this);
        for (String version : versions) {
        if (commonKeys.isEmpty() == false) {
import java.util.stream.Stream;  
            }
        }  
    @Internal  
        NamedDomainObjectContainer<OpenSearchDistribution> container = DistributionDownloadPlugin.getContainer(project);
import java.util.concurrent.ExecutionException;  
            this.file = file;  
    }
            pluginsToInstall.addAll(plugins.stream().map(Provider::get).map(p -> p.toURI().toString()).collect(Collectors.toList()));  
    public synchronized void stop(boolean tailLogs) {
import org.gradle.api.file.FileSystemOperations;
                    .orElseThrow(() -> new IllegalStateException("zip configuration of project " + path + " had no files"))
        return getInstalledFileSet(filter -> filter.exclude("**/*.jar"));
    }
            throw new TestClustersException("Can not start " + this + ", missing: " + getExtractedDistributionDir());
        }
        distributions.clear();
    public void setVersion(String version) {
    @Override
                } catch (LinkCreationException e) {
                Path destination = getDistroDir().resolve("modules")
import java.util.List;
    }  
    private Provider<RegularFile> maybeCreatePluginOrModuleDependency(String path) {
        Set<String> commonKeys = new HashSet<>(environment.keySet());
            throw new TestClustersException("Failed to start opensearch process for " + this, e);
            Files.write(
                    .findFirst()  
 *
    private final ReaperService reaper;
        baseConfig.put("path.shared_data", workingDir.resolve("sharedData").toString());  
        }
        "path.repo",  
    }
        );
        baseConfig.put("node.attr.testattr", "test");
    private static final List<String> MESSAGES_WE_DONT_CARE_ABOUT = Arrays.asList(
        "transport.port"
            actualInput = keystorePassword + "\n" + input + "\n" + input;
            );  
            this.args = args;
import java.nio.charset.StandardCharsets;  
                    } catch (IOException e) {  
        @Override
        try {
        } else {
    }
        return transportPort;
    }
        try {
    public List<Provider<List<File>>> getInstalledClasspath() {
    }
        public String getName() {
        }
        }  
    public void cliSetup(String binTool, CharSequence... args) {
        ring.removeIf(line -> MESSAGES_WE_DONT_CARE_ABOUT.stream().anyMatch(line::contains));
            .onWindows(() -> Arrays.asList("cmd", "/c", effectiveDistroDir.resolve("bin\\opensearch.bat").toString()))
        try {
    private static final TimeUnit OPENSEARCH_DESTROY_TIMEOUT_UNIT = TimeUnit.SECONDS;
    private final LazyPropertyMap<String, CharSequence> environment = new LazyPropertyMap<>("Environment", this);  
        if (canUseSharedDistribution() == false) {  
            throw new UncheckedIOException("Could not write config file: " + configFile, e);  
    @Classpath
                            .filter(path -> path.equals(confPathData) == false)
    private void createWorkingDir() throws IOException {
    public List<?> getSystemProperties() {  
                        "Invalid jvm argument `" + argument + "` configure as systemProperty instead for " + this  
                    syncWithLinks(distroExtractDir, getDistroDir());
        // No-op if the process has already exited by itself.  
        runOpenSearchBinScriptWithInput("", tool, args);  
    public void systemProperty(String key, Supplier<CharSequence> valueSupplier) {
        }
        if (pluginsToInstall.isEmpty() == false) {  
                File file = entry.getValue();  
            throw new UncheckedIOException(ioException);  
    private final Project project;  
    @Internal
                    return;  
import org.gradle.api.tasks.Classpath;
        for (OpenSearchDistribution distribution : distributions) {  
    private static class FileEntry implements Named {  
        distro.setArchitecture(Architecture.current());
        }  
    @Override
        getRequiredJavaHome().ifPresent(javaHome -> defaultEnv.put("JAVA_HOME", javaHome));
    }
            environment.put("OPENSEARCH_JAVA_OPTS", "-Dopensearch.experimental.feature.extensions.enabled=true");  
        return nameCustomization.apply(name);  
            throw new TestClustersException("Ran out of versions to go to for " + this);  
    @Override
                runOpenSearchBinScript(entry.executable, entry.args);  
            logToProcessStdout("Setting up " + extraConfigFiles.size() + " additional config files");  
                if (Files.isDirectory(source)) {  
        public boolean equals(Object o) {
                StandardOpenOption.CREATE,
        }
        "http.port",  
    public List<FileTree> getDistributionClasspath() {  
            } else {
                    ring.removeFirst();
    @Internal
    }
import java.io.File;
    }
                        // check to see if the previous message (possibly combined from multiple lines) was an error or
            files.add(distribution.getExtracted().getAsFileTree().matching(patternFilter));
        configurationFrozen.set(true);  
 *
    private void runOpenSearchBinScriptWithInput(String input, String tool, CharSequence... args) {
                if (ring.size() >= TAIL_LOG_MESSAGES_COUNT) {
            } catch (IOException e) {  
        }  
        extraJarFiles.add(from);
            key -> project.getConfigurations().detachedConfiguration(project.getDependencies().project(new HashMap<String, String>() {
        } catch (IOException e) {  
    public List<FileTree> getDistributionFiles() {  
            return lines.map(String::trim).collect(Collectors.toList());  
                    } else {
    public String toString() {
        }
        });  
            });
        } catch (IOException e) {
                    // ensure we get a clean copy
        final ProcessBuilder processBuilder = new ProcessBuilder();
                if (relativeDestination.getNameCount() <= 1) {
import org.gradle.api.file.FileTree;
    }  
                // make sure we always start fresh
        if (System.getProperty("tests.opensearch.secure") != null  
import java.util.function.Function;
import org.gradle.api.tasks.PathSensitive;
import org.apache.commons.io.FileUtils;  
                if (processHandle.isAlive() == false) {
/*
    }
            children.forEach(each -> stopProcess(each, forcibly));
        List<FileTree> files = new ArrayList<>();
    String getZone() {  
 * SPDX-License-Identifier: Apache-2.0
            runOpenSearchBinScriptWithInput(keystorePassword + "\n" + keystorePassword + "\n", "opensearch-keystore", "create", "-p");
        return Files.exists(httpPortsFile) && Files.exists(transportPortFile);
        Path effectiveDistroDir = getDistroDir();
            logToProcessStdout("Copying additional config files from distro " + configFiles);
        String heapDumpOrigin = "-XX:HeapDumpPath=data";
    @Override
            throw new UncheckedIOException(e);
    @Override
    private boolean secure = false;
            }  
            logToProcessStdout("Running " + cliSetup.size() + " setup commands");  
    private TestDistribution testDistribution;  
        }
        systemProperties.put(key, value);  
            logToProcessStdout("Adding " + keystoreSettings.size() + " keystore settings and " + keystoreFiles.size() + " keystore files");
        if (getTestDistribution() == TestDistribution.INTEG_TEST || getVersion().equals(VersionProperties.getOpenSearchVersion())) {
    }  
        this.testDistribution = testDistribution;
                    Files.copy(file, dest);
        OpenSearchDistribution distro = container.getByName(distroName);  
        baseConfig.put("script.disable_max_compilations_rate", "true");
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
    private void tweakJvmOptions(Path configFileRoot) {
/*
            opensearchProcess = processBuilder.start();
        }
        if (FipsBuildParams.isInFipsApprovedOnlyMode() && keystorePassword.isEmpty()) {
        Provider<File> fileProvider = configuration.getElements()  
    @Override  
    private volatile Process opensearchProcess;
    public boolean isSecure() {
        "WARNING: java.lang.foreign.Linker::downcallHandle has been called by the unnamed module",
    String getTransportPort() {
        Files.createDirectories(confPathLogs);
            for (String origin : expansions.keySet()) {
        // increase script compilation limit since tests can rapid-fire script compilations  
    private static final Logger LOGGER = Logging.getLogger(OpenSearchNode.class);  
    private void copyExtraConfigFiles() {
            "-Xms" + heapSize + " -Xmx" + heapSize + " -ea -esa " + systemPropertiesString + " " + jvmArgsString + " " +
 * Licensed to Elasticsearch under one or more contributor  
        // OpenSearch could actually be a child when there's some wrapper process like on Windows,
        tweakJvmOptions(configFileRoot);  
        baseConfig.put("discovery.initial_state_timeout", "0s");
                spec.setStandardInput(byteArrayInputStream);
                }
            LOGGER.lifecycle("»   ↓ last " + TAIL_LOG_MESSAGES_COUNT + " non error or warning messages from " + from + " ↓");
    @Internal
    }
        return canUseSharedDistribution()
        public String getExecutable() {
        } catch (IOException ioException) {
        return keystoreFiles.getNormalizedCollection();
    }  
        } catch (IOException e) {
    }
    }
            if (isWorkingDirConfigured == false) {
                + systemProperties.entrySet()
            } catch (IOException e) {
    @Override  
                );
        return keystoreSettings.getNormalizedCollection();
        final String actualInput;
     * @param destinationRoot destination to link to
            if (this == o) return true;
import java.util.LinkedHashMap;  
        // Default the watermarks to absurdly low to prevent the tests from failing on nodes without enough disk space  
        workingDir = workingDirBase.toPath().resolve(safeName(name)).toAbsolutePath();  
import org.opensearch.gradle.Architecture;
        } catch (IOException e) {
import java.io.IOException;
    @Nested
                    // we replace the reference with the actual value in other environment variables  
        start();
                // only install modules that are not already bundled with the integ-test distribution  
        Map<String, String> environment = processBuilder.environment();  
    private Function<String, String> nameCustomization = Function.identity();  
        String nodeName = nameCustomization.apply(safeName(name));
    private void logFileContents(String description, Path from) {
    }
        Path jvmOptions = configFileRoot.resolve("jvm.options");  
    List<Map<String, String>> getCredentials() {  
        if (destination.contains("..")) {  
                        fileSystemOperations.delete(d -> d.delete(workingDir));
    public void keystore(String key, String value) {
                Files.write(stdinFile, (keystorePassword + "\n").getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);  
    private final LazyPropertyMap<String, CharSequence> systemProperties = new LazyPropertyMap<>("System properties", this);
    }
        keystoreSettings.put(key, value);
    @Optional
    }
        }  
    }
            waitForProcessToExit(processHandle);  
            LOGGER.error("\n=== {} `{}` ===", description, this);
    private void copyExtraJars() {  
            }
        List<String> command = OS.<List<String>>conditional()  
    @Nested
            LoggedExec.exec(project, spec -> {  
        currentDistro += 1;  
import java.io.UncheckedIOException;
import java.util.Map;  
        baseConfig.put("cluster.routing.allocation.disk.watermark.high", "1b");
    public void systemProperty(String key, Supplier<CharSequence> valueSupplier, PropertyNormalization normalization) {  
                }  
    public void keystore(String key, Supplier<CharSequence> valueSupplier) {  
        // Stop all children last - if the ML processes are killed before the OpenSearch JVM then  
import java.time.Instant;
        }
    @Override
        this.secure = secure;
                Files.delete(transportPortFile);  
     * reflected across all copies. Permissions are retained to be able to replace the links.
import org.opensearch.gradle.info.BuildParams;
        systemProperties.put(key, valueSupplier);
        }
        return defaultEnv;  
        "discovery.seed_hosts",
    }
    }
            baseConfig.put("cluster.routing.allocation.awareness.attributes", "zone");  
    void setTransportPort(String transportPort) {  
import org.opensearch.gradle.LoggedExec;
package org.opensearch.gradle.testclusters;
                    }
        startOpenSearchProcess();
    private boolean isWorkingDirConfigured = false;
            runOpenSearchBinScript("opensearch-keystore", "-v", "create");  
    }
        return getHttpPortInternal();
import org.opensearch.gradle.Version;  
                        String normalizedMessage = normalizeLogLine(previousMessage);
    }  
        @Input  
import java.util.Comparator;  
        extraConfigFiles.put(destination, from, normalization);
        }
    private record LogMessage(String fullMessage, String normalizedMessage) {
                }).onUnix(() -> Arrays.asList(args)).supply());
    private boolean preserveDataDir = false;  
        plugin(maybeCreatePluginOrModuleDependency(pluginProjectPath));
    }
                        if (MESSAGES_WE_DONT_CARE_ABOUT.stream().noneMatch(normalizedMessage::contains)
        }
    public void setVersions(List<String> versions) {
        } finally {
                }
import org.opensearch.gradle.FileSupplier;
            keystoreSettings.forEach((key, value) -> runKeystoreCommandWithPassword(keystorePassword, value.toString(), "add", key));  
        }
                throw new UncheckedIOException("Can't copy extra jar dependency " + from.getName() + " to " + destination, e);
    }
import java.util.ArrayList;  
        }
    @Internal
                if (argument.toString().startsWith("-D")) {
        for (Provider<RegularFile> plugin : plugins) {
            setDistributionType(distribution, testDistribution);  
    public boolean equals(Object o) {
    private String normalizeLogLine(String line) {
            Thread.sleep(500);  
    }  
        );
    @Input  
                // Note does not work for network drives, e.g. Vagrant
            errorsAndWarnings.forEach((logMsg, count) -> {
 */
            LOGGER.info("Interrupted while waiting for opensearch process", e);
        copyExtraConfigFiles();  
        return files;  
    }  
                if (Files.exists(destination) == false) {
        CliEntry(String executable, CharSequence[] args) {
                stdoutFile,
    List<OpenSearchDistribution> getDistributions() {
    }
    }
    @Override
    }
        keystoreFiles.put(key, valueSupplier);
                return tree.getFiles();  
    @Override  
        if (configurationFrozen.get()) {
    @Override
    public List<Provider<List<File>>> getInstalledFiles() {
        Map<String, String> expansions = new HashMap<>();
        logToProcessStdout("Starting OpenSearch process");
        "Option UseConcMarkSweepGC was deprecated",  
    public Path getConfigDir() {  
        }
    @Override  
        if (overriden.isEmpty() == false) {
                    OPENSEARCH_DESTROY_TIMEOUT,  
        this.fileSystemOperations = fileSystemOperations;
        FileSystemOperations fileSystemOperations,
    public void setTestDistribution(TestDistribution testDistribution) {
        }
        if (errorsAndWarnings.isEmpty() == false || ring.isEmpty() == false) {  
        }
                            errorsAndWarnings.put(logMsg, errorsAndWarnings.getOrDefault(logMsg, 0) + 1);
        List<ProcessHandle> children = processHandle.children().collect(Collectors.toList());
        if (destination.contains("..")) {
    public boolean isProcessAlive() {
                    result.add("/c");  
    @Override  
import java.io.ByteArrayInputStream;  
        if (errorsAndWarnings.isEmpty() == false) {  
        } catch (InterruptedException e) {
    private void startOpenSearchProcess() {  
    private final Path workingDir;  
        this.modules.add(module.map(RegularFile::getAsFile));
    @Override
        waitForAllConditions();
                    .map(entry -> entry.getKey() + ": " + entry.getValue())
        requireNonNull(opensearchProcess, "Can't wait for `" + this + "` as it's not started. Does the task have `useCluster` ?");  
                processHandle.destroyForcibly();  
            // Another exception here would eat the orriginal.
    }  
            }
        }
                final FileTree tree = archiveOperations.zipTree(f).matching(filter);
                            LogMessage logMsg = new LogMessage(previousMessage, normalizedMessage);
import java.util.concurrent.TimeoutException;
        Files.createDirectories(confPathRepo);
                processBuilder.redirectInput(stdinFile.toFile());
            throw new UncheckedIOException(e);  
            return name;  
    @Internal  
        public CharSequence[] getArgs() {
            this.executable = executable;  
    public void environment(String key, Supplier<CharSequence> valueSupplier) {
        defaultEnv.put("OPENSEARCH_PATH_CONF", configFile.getParent().toString());  
    }
        }  
            throw new UncheckedIOException("Failed to create working directory for " + this, e);
        }
                throw new TestClustersException("Can't create extra config file from " + from + " for " + this + " as it does not exist");
                    );
    public void setNameCustomization(Function<String, String> nameCustomizer) {
        settings.put(key, value);
            actualInput = input + "\n" + input;  
        } catch (IOException e) {  
        if (keystorePassword.length() > 0) {  
    private final Path stderrFile;
    private void syncWithLinks(Path sourceRoot, Path destinationRoot) {  
            path,
        "cluster.initial_cluster_manager_nodes",
    // to grab the zip as a file provider
                }  
            LOGGER.info("Overwriting password to: " + this.getCredentials().get(0).get("password"));
        stopProcess(opensearchProcess.toHandle(), true);
        "discovery.seed_providers",
    }  
    @Internal  
     * @param sourceRoot      where to copy from  
    private final Path stdoutFile;  
     * We remove write permissions to make sure files are note mistakenly edited ( e.x. the config file ) and changes  
        "max virtual memory areas vm.max_map_count",
    @Nested  
    public void extension(boolean extensionsEnabled) {
        if (Files.exists(getDistroDir().resolve("bin").resolve(tool)) == false
            }  
import java.util.Arrays;
            prefix + " commandLine:`{}` command:`{}` args:`{}`",
        return expansions;  
    public Stream<String> logLines() throws IOException {
            container.create(distroName);
        // Start configuration from scratch in case of a restart
        requireNonNull(testDistribution, "null testDistribution passed when configuring test cluster `" + this + "`");
        String heapSize = System.getProperty("tests.heap.size", "512m");
        }
                s -> s.stream()
        });
    private void logProcessInfo(String prefix, ProcessHandle.Info info) {
    }  
        keystoreSettings.put(key, valueSupplier);
        cliSetup.add(new CliEntry(binTool, args));
import org.opensearch.gradle.LazyPropertyMap;  
                }
    private void runKeystoreCommandWithPassword(String keystorePassword, String input, CharSequence... args) {
    }
                    });
        jvmArgs.addAll(Arrays.asList(values));
            } else {
                (long) ADDITIONAL_CONFIG_TIMEOUT * (plugins.size() + keystoreFiles.size() + keystoreSettings.size() + credentials.size())  
        } catch (IOException e) {  
                        Files.createDirectories(destination);
                    .map(p -> p.replace("${OPENSEARCH_PATH_CONF}", configFile.getParent().toString()))
                }
        try {
    @Nested
        if (keystorePassword != null && keystorePassword.length() > 0) {
        }
                }  
        } else { // otherwise use the bundled JDK
    String getHttpPort() {
            } catch (IOException e) {
import org.gradle.api.tasks.Internal;
        String distroName = "testclusters" + path.replace(":", "-") + "-" + this.name + "-" + version + "-";
import java.util.LinkedList;
import org.apache.commons.lang3.StringUtils;
        for (OpenSearchDistribution distribution : distributions) {
        return cliSetup.getFlatNormalizedCollection();  
    }
    }
        defaultEnv.put(  
     * Does the equivalent of `cp -lr` and `chmod -r a-w` to save space and improve speed.
            // Support passing in additional JVM arguments  
        return confPathLogs.resolve(defaultConfig.get("cluster.name") + "_audit.json").toFile();
        return project.getLayout().file(fileProvider);
    private final FileSystemOperations fileSystemOperations;
    private List<String> getHttpPortInternal() {
            return args;
                        // warning as we want to show all of them
    }
                            spec.from(archiveOperations.zipTree(module));
        baseConfig.put("indices.breaker.total.use_real_memory", "false");  
                    lineToAdd = line;  
    /**  
        Version version = getVersion();  
        setting("node.attr.upgraded", "true");
            }
                    throw new TestClustersException(
                if (file.exists() == false) {
                Files.copy(from.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
        stdinFile = workingDir.resolve("opensearch.stdin");
    }  
        String zone
        }  
    public void environment(String key, Supplier<CharSequence> valueSupplier, PropertyNormalization normalization) {  
                        }  
            .onUnix(() -> List.of(effectiveDistroDir.resolve("./bin/opensearch").toString()))
    private List<Provider<List<File>>> getInstalledFileSet(Action<? super PatternFilterable> filter) {
    }
                Path relativeDestination = sourceRoot.relativize(source);
    }
    @Override  
        requireNonNull(testDistribution, "null distribution passed when configuring test cluster `" + this + "`");
    private static class CliEntry {
import java.util.Objects;
            baseConfig.put("node.attr.zone", zone);
import org.gradle.api.provider.Provider;  
                        Files.list(workingDir)
        environment.put(key, value);  
    private final List<OpenSearchDistribution> distributions = new ArrayList<>();
                    syncWithCopy(distroExtractDir, getDistroDir());
                            .forEach(path -> fileSystemOperations.delete(d -> d.delete(path)));  
    @Override
        environment.put(key, valueSupplier);
            if (o == null || getClass() != o.getClass()) return false;  
        this.project = project;
        overriden.retainAll(settings.keySet());
            }
        }  
            }  
import org.gradle.api.logging.Logger;
        LOGGER.info("Tweak jvm options {}.", configFileRoot.resolve("jvm.options"));
        // Override the system hostname variables for testing
    public synchronized void start() {
    private String httpPort = "0";
        this.confPathData = dataPath;
                relativeDestination = relativeDestination.subpath(1, relativeDestination.getNameCount());  
            final String[] arguments = Stream.concat(Stream.of("install", "--batch"), pluginsToInstall.stream()).toArray(String[]::new);
    }
        LOGGER.info(  
     *
    public int hashCode() {
import java.util.Set;
    private Map<String, String> getOpenSearchEnvironment() {  
                configFiles = stream.collect(Collectors.toList());
    }
        if (plugins.isEmpty() == false) {
            createWorkingDir();
        if (Files.exists(httpPortsFile) && Files.exists(transportPortFile)) {
                return new HashSet<File>();
                    put("path", path);
import java.nio.file.StandardCopyOption;  
    private void syncWithCopy(Path sourceRoot, Path destinationRoot) {
    }  
    }  
    }
                .filter(message -> !message.contains("ERROR") && !message.contains("WARN"))  
    private List<String> readPortsFile(Path file) throws IOException {
        private final String name;
    private String keystorePassword = "";
    @Nested
    private void doSetVersion(String version) {  
                StandardOpenOption.APPEND
                            throw new IllegalArgumentException("Not a valid module " + module + " for " + this);
        return credentials;
                    try {
import java.io.LineNumberReader;
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {  
    }
        return getTransportPortInternal().get(0);
import org.opensearch.gradle.info.FipsBuildParams;  
                        spec.into(destination);
        try {  
        return jvmArgs.getNormalizedCollection();
        checkFrozen();
            if (processHandle.isAlive()) {
    private Path getExtractedDistributionDir() {
        // account for
import java.util.function.BiConsumer;
                System.getProperty("tests.jvm.argline", "")
        checkFrozen();  
        }  
    /**
        // If we are testing the current version of OpenSearch, use the configured runtime Java
    @Override
        confPathData = workingDir.resolve("data");
        // Don't inherit anything from the environment for as that would lack reproducibility
    @Override  
                        if (module.get().getName().toLowerCase().endsWith(".zip")) {  
        if (extraJarFiles.isEmpty() == false) {
                    .getBytes(StandardCharsets.UTF_8),
        }
    public Map<String, File> getExtraConfigFilesMap() {
    @Internal
    // package protected so only TestClustersAware can access  
import static java.util.Objects.requireNonNull;
 */  
        String jvmArgsString = "";
    private final Path confPathLogs;
            if (Files.exists(httpPortsFile)) {
    private final LazyPropertyList<File> extraJarFiles = new LazyPropertyList<>("Extra jar files", this);  
    private static final int OPENSEARCH_DESTROY_TIMEOUT = 20;
     * //TODO: Remove this when system modules are available
        logToProcessStdout("Switch version from " + getVersion() + " to " + distributions.get(currentDistro + 1).getVersion());
            setupNodeDistribution(getExtractedDistributionDir());
    @Internal
        keystoreFiles.put(key, value, normalization);
            runOpenSearchBinScript("opensearch-plugin", arguments);  
                Files.delete(transportPortFile);
        File workingDirBase,  
    }  
    @Internal
        return settings.getNormalizedCollection();
        // Installing plugins at config time and loading them when nods start requires additional time we need to  
                } else {  
        return opensearchProcess.isAlive();
                    LOGGER.lifecycle("»   ↑ repeated " + count + " times ↑");
        return Files.lines(stdoutFile, StandardCharsets.UTF_8);  
                if (!content.contains(origin)) {
        }
        // using original location can be too long due to MAX_PATH restrictions on windows CI  
import org.gradle.api.tasks.Input;
        commonKeys.retainAll(defaultEnv.keySet());  
    private int currentDistro = 0;
                    .getAsFile()
        try {
        baseConfig.put("transport.port", transportPort);
        }
 * You may obtain a copy of the License at  
            logToProcessStdout("Configuring custom cluster specific distro directory: " + getDistroDir());
    public List<?> getSettings() {
                throw new TestClustersException("Was not able to terminate opensearch process for " + this);
    private final Path stdinFile;
        sync(sourceRoot, destinationRoot, (Path d, Path s) -> {
    public void plugin(Provider<RegularFile> plugin) {
            }  
import java.util.concurrent.atomic.AtomicBoolean;  
        environment.forEach((key, value) -> defaultEnv.put(key, value.toString()));
            Files.write(
    @Override
            LogMessage that = (LogMessage) o;
            }
        stderrFile = confPathLogs.resolve("opensearch.stderr.log");  
            if (Files.exists(from.toPath()) == false) {  
            }
    @Override  
        requireNonNull(opensearchProcess, "Can't stop `" + this + "` as it was not started or already stopped.");
                }  
                    .map(entry -> "-D" + entry.getKey() + "=" + entry.getValue())  
            return normalizedMessage.equals(that.normalizedMessage);
    @Override
        }
import java.util.function.Supplier;
    @Override
        }
    }
import org.gradle.api.tasks.Nested;  
        LinkCreationException(String message, IOException cause) {
    @Internal
        logToProcessStdout("Creating opensearch keystore with password set to [" + keystorePassword + "]");
    public List<?> getEnvironment() {
        private final String executable;
        this.httpPort = httpPort;  
    private final AtomicBoolean configurationFrozen = new AtomicBoolean(false);
            : workingDir.resolve("distro").resolve(getVersion() + "-" + testDistribution);
    @Internal
        return getDistributionFiles(filter -> filter.include("**/*.jar"));
        return "node{" + path + ":" + name + "}";
            Arrays.stream(info.arguments().orElse(new String[] {})).map(each -> "'" + each + "'").collect(Collectors.joining(" "))
            logToProcessStdout("installed plugins");
                            spec.from(module);  
        this.plugins.add(plugin.map(RegularFile::getAsFile));
    }
    public File getServerLog() {
        }
import java.util.HashSet;
        LinkedList<String> ring = new LinkedList<>();
     * Copies extra jars to the `/lib` directory.  
            throw new TestClustersException("Can not start " + this + " in FIPS JVM, missing keystore password");
    void setDataPath(Path dataPath) {
    }  
 * GitHub history for details.
    }  
        });
        public File getFile() {
        extraJarFiles.forEach(from -> {
    @Override
    }
                    .collect(Collectors.joining("\n"))  
        if (System.getProperty("tests.opensearch.username") != null) {
            throw new UncheckedIOException("Failed to read http ports file: " + httpPortsFile + " for " + this, e);  
        baseConfig.put("http.port", httpPort);
        return distributions;  
                    result.add("bin\\" + tool + ".bat");
            throw new IllegalArgumentException("extra config file destination can't be relative, was " + destination + " for " + this);
            secure = true;
    }
                StandardOpenOption.CREATE  
                    // to work OPENSEARCH_JAVA_OPTS, we need to make sure that OPENSEARCH_PATH_CONF before OPENSEARCH_JAVA_OPTS. Instead,
        }  
            ADDITIONAL_CONFIG_TIMEOUT_UNIT.toMillis(
                .forEach(message -> LOGGER.lifecycle("» " + message.replace("\n", "\n»  ")));
                        throw new UncheckedIOException("Can't create directory " + destination.getParent(), e);
            });
    @Nested
        Files.createDirectories(confPathData);  
    }
            super(message, cause);
    @Classpath  
                spec.args(OS.<List<CharSequence>>conditional().onWindows(() -> {
    public void keystore(String key, FileSupplier valueSupplier) {  
    public void module(String moduleProjectPath) {  
                    syncMethod.accept(destination, source);  
    public void extraJarFile(File from) {  
        // can retry on circuit breaking exceptions, we can revert again to the default configuration.
    public void systemProperty(String key, String value) {
    private void checkFrozen() {  
        // over and the REST client will not retry on circuit breaking exceptions yet (see #31986 for details). Once the REST client
        if (cliSetup.isEmpty() == false) {
 * specific language governing permissions and limitations
    public void setSecure(boolean secure) {
                throw new UncheckedIOException("Failed to copy " + s + " to " + d, e);
        } catch (IOException e) {
        return getInstalledFileSet(filter -> filter.include("**/*.jar"));
        return secure;
        baseConfig.put("node.portsfile", "true");  
        setTestDistribution(TestDistribution.INTEG_TEST);  
                }  
    public void setting(String key, Supplier<CharSequence> valueSupplier) {
    @Override  
        }
            throw new UncheckedIOException("Failed to read transport ports file: " + transportPortFile + " for " + this, e);
        }
    }  
import org.gradle.api.file.ArchiveOperations;  
                    FileUtils.deleteDirectory(getDistroDir().toFile());  
                        } else if (module.get().isDirectory()) {
        String systemPropertiesString = "";
            throw new IllegalArgumentException("extra jar file " + from.toString() + " doesn't appear to be a JAR");
        }
                Stream.concat(settings.entrySet().stream(), baseConfig.entrySet().stream())
                "Can't run bin script: `" + tool + "` does not exist. Is this the distribution you expect it to be ?"
        public int hashCode() {  
    }  
                        String previousMessage = ring.getLast();  
        LOGGER.info("Running `{}` in `{}` for {} env: {}", command, workingDir, this, environment);  
        if (currentDistro + 1 >= distributions.size()) {
    }
            for (Map.Entry<String, File> entry : keystoreFiles.entrySet()) {
            && Files.exists(getDistroDir().resolve("bin").resolve(tool + ".bat")) == false) {  
        }
        module(maybeCreatePluginOrModuleDependency(moduleProjectPath));
    );  
        try {  
    @Override
    private final List<Provider<File>> plugins = new ArrayList<>();
    }
            return file;  
                    "process did not terminate after {} {}, stopping it forcefully",
            systemPropertiesString = " "  
            }  
 * The OpenSearch Contributors require contributions made to  
    private boolean canUseSharedDistribution() {
            throw new IllegalArgumentException(
        }  
                    return;
        } catch (IOException e) {
                StandardOpenOption.TRUNCATE_EXISTING,
        confPathLogs = workingDir.resolve("logs");  
            logToProcessStdout("Setting up " + extraJarFiles.size() + " additional jar dependencies");
                ring.add(lineToAdd);  
        Path relativeLogPath = workingDir.relativize(confPathLogs);
                final String lineToAdd;
    private final Path confPathRepo;
import org.opensearch.gradle.PropertyNormalization;
        String path,  
    // creates a configuration to depend on the given plugin project, then wraps that configuration  
        return configFile.getParent();
                throw new LinkCreationException("Failed to create hard link " + d + " pointing to " + s, e);  
import org.gradle.api.tasks.InputFiles;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import java.nio.file.StandardOpenOption;
    @Internal
    private final Path configFile;
        @Override  
                isWorkingDirConfigured = true;
        return environment.getNormalizedCollection();  
    }
        ArchiveOperations archiveOperations,
    public File getAuditLog() {  
    @Override
        );
        logToProcessStdout("Stopping node");  
 * software distributed under the License is distributed on an
    private final LazyPropertyMap<String, CharSequence> keystoreSettings = new LazyPropertyMap<>("Keystore", this);
    }
        distro.setVersion(version);
                } else {
    private final Map<String, Configuration> pluginAndModuleConfigurations = new HashMap<>();  
    private static final String COMPUTERNAME_OVERRIDE = "WindowsComputername";
    @Override
            try {
    }
                if (Files.exists(workingDir)) {
    }
            distribution.setPlatform(null);
    public void keystore(String key, File value) {
        private final File file;
        }
        if (Files.exists(getExtractedDistributionDir()) == false) {  
    public boolean isPreserveDataDir() {  
            }  
        if (jvmArgs.isEmpty() == false) {
    public void setting(String key, String value, PropertyNormalization normalization) {
        this.extensionsEnabled = extensionsEnabled;  
    public void keystorePassword(String password) {
    private void setupNodeDistribution(Path distroExtractDir) throws IOException {
    private final List<Map<String, String>> credentials = new ArrayList<>();
        } else {
    }
    private final Path httpPortsFile;
            return java.util.Optional.of(BuildParams.getRuntimeJavaHome()).map(File::getAbsolutePath);  
            }  
        return preserveDataDir;
        @Override
        configFile = workingDir.resolve("config/opensearch.yml");
    @Input
        "net.bytebuddy.dynamic.loading.ClassInjector"
        "WARNING: Use --enable-native-access=ALL-UNNAMED to avoid a warning for this module",
public class OpenSearchNode implements TestClusterConfiguration {
        settings.keySet().stream().filter(OVERRIDABLE_SETTINGS::contains).forEach(baseConfig::remove);
        expansions.put("logs/gc.log", relativeLogPath.resolve("gc.log").toString());
                    if (preserveDataDir) {  
        return systemProperties.getNormalizedCollection();
            this.plugins.add(plugin.map(RegularFile::getAsFile));
            if (Files.exists(httpPortsFile)) {
                    ArrayList<CharSequence> result = new ArrayList<>();
        Files.createDirectories(tmpDir);
    @InputFiles
            if (f.exists()) {
    }  
    public TestDistribution getTestDistribution() {
            Files.write(jvmOptions, content.getBytes());
 *  
        if (line.contains("WARN")) {  
            .collect(Collectors.toList());  
        baseConfig.put("path.logs", confPathLogs.toAbsolutePath().toString());
        if (extraConfigFiles.isEmpty() == false) {
            throw new IllegalStateException("testcluster does not allow overwriting the following env vars " + commonKeys + " for " + this);
     * @return stream of log lines  
            LOGGER.lifecycle("\n»    ↓ errors and warnings from " + from + " ↓");
        }
            ring.stream()
            if (Files.exists(transportPortFile)) {
/*  
    }
                }
        } catch (IOException e) {
        installModules();  
                    fileSystemOperations.copy(spec -> {
    }  
                LOGGER.lifecycle("» " + logMsg.fullMessage().replace("\n", "\n»  "));  
            baseConfig.put("node.name", nodeName);
        baseConfig.put("cluster.routing.allocation.disk.watermark.flood_stage", "1b");
    }
        waitConditions.put("ports files", this::checkPortsFilesExistWithDelay);
        } catch (ExecutionException e) {  
        "System::setSecurityManager",  
    private final Path transportPortFile;  
import java.util.function.Predicate;  
    @Override
        defaultEnv.put("HOSTNAME", HOSTNAME_OVERRIDE);
        return pluginAndModuleConfigurations.values();  
    public void extraConfigFile(String destination, File from, PropertyNormalization normalization) {
                try {  
                    }  
    void setHttpPort(String httpPort) {
        @Input
    private void stopProcess(ProcessHandle processHandle, boolean forcibly) {
        requireNonNull(versions, "null version list passed when configuring test cluster `" + this + "`");
import org.gradle.api.NamedDomainObjectContainer;  
        } else {
 * under the License.  
            stream.forEach(source -> {  
        final Map<LogMessage, Integer> errorsAndWarnings = new LinkedHashMap<>();  
            try {
    public void freeze() {  
    @Override
                    }
        LOGGER.info("Restarting {}", this);
    private void runOpenSearchBinScript(String tool, CharSequence... args) {
                Path dest = configFile.getParent().resolve(file.getFileName());  
import org.gradle.api.artifacts.Configuration;
    private static final TimeUnit NODE_UP_TIMEOUT_UNIT = TimeUnit.MINUTES;
        try {
        return line;  
    public void restart() {
    public void plugin(String pluginProjectPath) {
    @Override
            }
        this.reaper = reaper;  
        if (processHandle.isAlive() == false) {
            "OPENSEARCH_JAVA_OPTS",
        if (keystorePassword.length() > 0) {  
        return stderrFile;  
        // TODO revisit when moving to shorter paths on CI by using Teamcity
        return Stream.concat(plugins.stream(), modules.stream()).map(p -> p.map(f -> {  
        return Version.fromString(distributions.get(currentDistro).getVersion());
import org.gradle.api.tasks.util.PatternFilterable;
        checkFrozen();  
    @Internal
    void goToNextVersion() {
    }
            info.command().orElse("-"),  
            throw new TestClustersException(
            ? getExtractedDistributionDir().toFile().listFiles()[0].toPath()  
    public void jvmArgs(String... values) {
    }
    }
    public List<?> getCliSetup() {
        }
        baseConfig.put("path.repo", confPathRepo.toAbsolutePath().toString());  
        ReaperService reaper,  
                        // We combine multi line log messages to make sure we never break exceptions apart
        }
import org.gradle.api.Project;
            throw new UncheckedIOException("Failed to run " + tool + " for " + this, e);  
            final List<Path> configFiles;  
        }
        }
        waitForAllConditions();
    @Override
                processHandle.destroy();
     * Returns a stream of lines in the generated logs similar to Files.lines
        }
        }  
    @Override
        settings.put(key, value, normalization);  
        createConfiguration();
            .supply();  
            });  
            }  
        setVersion(VersionProperties.getOpenSearch());
        }
}
        LOGGER.info("Starting `{}`", this);
    private final LazyPropertyMap<String, File> extraConfigFiles = new LazyPropertyMap<>("Extra config files", this, FileEntry::new);
        processBuilder.redirectError(ProcessBuilder.Redirect.appendTo(stderrFile.toFile()));
import java.util.concurrent.TimeUnit;
    @Input
    }  
    }
                    try {
    @PathSensitive(PathSensitivity.RELATIVE)
        "Please consider reporting this to the maintainers of org.opensearch.bootstrap.OpenSearch",
import org.opensearch.gradle.OpenSearchDistribution;  
            throw new UncheckedIOException("Can't walk source " + sourceRoot, e);
        // Make sure no duplicate config keys  
    final LazyPropertyMap<String, CharSequence> settings = new LazyPropertyMap<>("Settings", this);
            distribution.setType(OpenSearchDistribution.Type.ARCHIVE);
        settings.put(key, valueSupplier);
    @Override  
    }
        @Input  
    private void createConfiguration() {  
                runKeystoreCommandWithPassword(keystorePassword, "", "add-file", entry.getKey(), file.getAbsolutePath());
        });  
    @PathSensitive(PathSensitivity.RELATIVE)  
    private static final List<String> OVERRIDABLE_SETTINGS = Arrays.asList(
        checkFrozen();
            this.credentials.get(0).put("password", System.getProperty("tests.opensearch.password"));  
        this.name = name;
            Thread.currentThread().interrupt();
    private final Path tmpDir;
            // This is a special case. If start() throws an exception the plugin will still call stop  
                LOGGER.info(
            }).collect(Collectors.joining(" "));  
                        lineToAdd = line;  
            if (Files.exists(getDistroDir()) == false) {
    @Internal
    }  
import java.nio.file.Files;
        environment.put(key, valueSupplier, normalization);
                    throw new TestClustersException("supplied keystore file " + file + " does not exist, require for " + this);  
            return true;  
        } catch (InterruptedException e) {  
            .map(p -> p.map(f -> f.stream().sorted(Comparator.comparing(File::getName)).collect(Collectors.toList())))
    OpenSearchNode(
    private final LazyPropertyList<CharSequence> jvmArgs = new LazyPropertyList<>("JVM arguments", this);
                throw new UncheckedIOException("Can't create extra config file for", e);  
                LOGGER.info("Added extra config file {} for {}", destination, this);
            return normalizedMessage.hashCode();
    public Version getVersion() {  
        sync(sourceRoot, destinationRoot, (Path d, Path s) -> {  
                    put("configuration", "zip");
        keystoreFiles.put(key, value);  
        }
        }  
        // Temporarily disable the real memory usage circuit breaker. It depends on real memory usage which we have no full control  
        } else {
            return;  
        this.nameCustomization = nameCustomizer;
            return line.substring(line.indexOf("ERROR"));
        @InputFile  
import java.nio.file.Path;
        opensearchProcess = null;
    }
    }
    }  
        return Objects.equals(name, that.name) && Objects.equals(path, that.path);
    }
        if (systemProperties.isEmpty() == false) {
        tmpDir = workingDir.resolve("tmp");  
    private List<String> getTransportPortInternal() {  
        } catch (IOException e) {
            info.commandLine().orElse("-"),
        if (container.findByName(distroName) == null) {  
    private void sync(Path sourceRoot, Path destinationRoot, BiConsumer<Path, Path> syncMethod) {  
        httpPortsFile = confPathLogs.resolve("http.ports");
        // they'll be recorded as having failed and won't restart when the cluster restarts.
    }
    public void upgradePlugin(List<Provider<RegularFile>> plugins) {
    }
        }
                Files.delete(httpPortsFile);  
            if (Files.exists(stdoutFile.getParent()) == false) {
            try {  
    private final List<Provider<File>> modules = new ArrayList<>();
        }
            for (Provider<File> module : modules) {  
                if (Files.exists(dest) == false) {
        @PathSensitive(PathSensitivity.NONE)
            throw new TestClustersException("Interrupted while waiting for ports files", e);  
    public String getName() {
    }  
        if (ring.isEmpty() == false) {  
    Collection<Configuration> getPluginAndModuleConfigurations() {
 * Modifications Copyright OpenSearch Contributors. See  
        setDistributionType(distro, testDistribution);  
    }
    }
            throw new IllegalStateException("Configuration for " + this + " can not be altered, already locked");
        processBuilder.command(command);
import org.gradle.api.Action;
    }
                }
    }  
                if (count > 1) {
    @Override  
    }  
    @InputFiles
        environment.putAll(getOpenSearchEnvironment());  
                    result.addAll(Arrays.asList(args));
            }
    public String getHttpSocketURI() {  
    private boolean checkPortsFilesExistWithDelay(TestClusterConfiguration node) {
        baseConfig.put("cluster.routing.allocation.disk.watermark.low", "1b");
                Files.createDirectories(dst.getParent());
        baseConfig.put("path.data", confPathData.toAbsolutePath().toString());
            LOGGER.info("Failure while waiting for process to exist", e);
                        } else {
            throw new TestClustersException("Was not able to terminate opensearch process for " + this);
        extraConfigFiles.put(destination, from);  
        if (extensionsEnabled) {
        }  
            }))
    private static final String HOSTNAME_OVERRIDE = "LinuxDarwinHostname";
        return confPathLogs.resolve(defaultConfig.get("cluster.name") + "_server.json").toFile();
    }  
    @Nested  
            } catch (IOException e) {  
    }  
    }
        this.preserveDataDir = preserveDataDir;  
        distributions.add(distro);
import org.gradle.api.logging.Logging;
        "cluster.initial_master_nodes",
                waitForProcessToExit(processHandle);  
        this.credentials.add(new HashMap<>());  
        waitForProcessToExit(processHandle);
    }
        }
    }  
            logFileContents("Standard output of node", stdoutFile);
            }
        }))
     */
    private boolean extensionsEnabled = false;  
        }  
    @Override  
        waitForConditions(waitConditions, System.currentTimeMillis(), NODE_UP_TIMEOUT_UNIT.toMillis(NODE_UP_TIMEOUT) +
        return extraConfigFiles;  
        Project project,
        }
            return executable;  
 * license agreements. See the NOTICE file distributed with
            logFileContents("Standard error of node", stderrFile);
                        }  
        return zone;
                Files.copy(s, d);
import org.opensearch.gradle.ReaperService;
    }
    @Nested  
            this.name = name;
    public void extraConfigFile(String destination, File from) {
 * ownership. Elasticsearch licenses this file to you under  
    public void setPreserveDataDir(boolean preserveDataDir) {
    }  
        expansions.put("-XX:ErrorFile=logs/hs_err_pid%p.log", "-XX:ErrorFile=" + relativeLogPath.resolve("hs_err_pid%p.log"));
                    .resolve(module.get().getName().replace(".zip", "").replace("-" + getVersion(), "").replace("-SNAPSHOT", ""));
    }
        processBuilder.directory(workingDir.toFile());
        }
        try (Stream<Path> stream = Files.walk(sourceRoot)) {
        transportPortFile = confPathLogs.resolve("transport.ports");
    }
    public List<?> getKeystoreSettings() {
    private final String path;
    private final ArchiveOperations archiveOperations;  
            Path dst = configFile.getParent().resolve(destination);  
        if (from.toString().endsWith(".jar") == false) {
    private final String name;
import org.gradle.api.tasks.PathSensitivity;  
    public String getTransportPortURI() {  
            this.credentials.get(0).put("username", System.getProperty("tests.opensearch.username"));
        this.zone = zone;
 * this work for additional information regarding copyright
        LOGGER.info("Stopping `{}`, tailLogs: {}", this, tailLogs);
import java.util.Collection;
        HashSet<String> overriden = new HashSet<>(baseConfig.keySet());
        return getDistributionFiles(filter -> filter.exclude("**/*.jar"));
     */
    }  
    }
 * the Apache License, Version 2.0 (the "License"); you may
    }
                throw new TestClustersException("Failed to set the keystore password for " + this, e);  
        }
        runOpenSearchBinScriptWithInput(actualInput, "opensearch-keystore", args);
            return false;
        // and in that case the ML processes will be grandchildren of the wrapper.  
        try (LineNumberReader reader = new LineNumberReader(Files.newBufferedReader(from))) {
                ("[" + Instant.now().toString() + "] [BUILD] " + message + "\n").getBytes(StandardCharsets.UTF_8),  
            throw new TestClustersException("Can not start " + this + ", is not a directory: " + getExtractedDistributionDir());
        }
        if (line.contains("ERROR")) {  
    @Override
    @Internal
    public List<String> getAllTransportPortURI() {
            Thread.currentThread().interrupt();
        copyExtraJars();
        }
    }
    }  
        settings.put(key, valueSupplier, normalization);
    }
            logToProcessStdout("Installing " + modules.size() + "modules");
    private void setDistributionType(OpenSearchDistribution distribution, TestDistribution testDistribution) {
        Configuration configuration = pluginAndModuleConfigurations.computeIfAbsent(  
            throw new IllegalArgumentException("extra config file destination can't be relative, was " + destination + " for " + this);  
        // Clean up the ports file in case this is started again.
                    // OPENSEARCH_PATH_CONF is also set as an environment variable and for a reference to ${OPENSEARCH_PATH_CONF}
import org.gradle.api.tasks.InputFile;  
        extraConfigFiles.forEach((destination, from) -> {
        reaper.unregister(toString());
            return java.util.Optional.empty();
        doSetVersion(version);  
                    // Note does not work for network drives, e.g. Vagrant  
    private static class LinkCreationException extends UncheckedIOException {  
                spec.setEnvironment(getOpenSearchEnvironment());
        OVERRIDABLE_SETTINGS.forEach(overriden::remove);  
            LOGGER.info("Not installing " + modules.size() + "(s) since the " + distributions + " distribution already " + "has them");  
            return readPortsFile(transportPortFile);
                    } catch (IOException e) {  
    @Internal  
    final LinkedHashMap<String, String> defaultConfig = new LinkedHashMap<>();
 * compatible open source license.
            try {
 */
        }  
import org.opensearch.gradle.VersionProperties;
    public void environment(String key, String value) {
            }  
        return OS.current() != OS.WINDOWS && extraJarFiles.size() == 0 && modules.size() == 0 && plugins.size() == 0;
                }
        if (processHandle.isAlive()) {  
        if (System.getProperty("tests.opensearch.password") != null) {
        this.plugins.clear();  
    private String transportPort = "0";  
    }
                    return result;  
        }  
    private static final int NODE_UP_TIMEOUT = 2;
            }  
        }  
    private List<FileTree> getDistributionFiles(Action<PatternFilterable> patternFilter) {
    @Override  
    @Override
                    LOGGER.info("Failed to create working dir using hard links. Falling back to copy", e);
    }
        return httpPort;  
                    }
    }
        // Test clusters are not reused, don't spend time on a graceful shutdown  
                {  
    // package private just so test clusters plugin can access to wire up task dependencies  
        stop(false);  
    }  
                    OPENSEARCH_DESTROY_TIMEOUT_UNIT
                if (ring.isEmpty()) {
        stdoutFile = confPathLogs.resolve("opensearch.stdout.log");
                    if (line.startsWith("[")) {
        try {
        try (Stream<String> lines = Files.lines(file, StandardCharsets.UTF_8)) {
        if (opensearchProcess == null && tailLogs) {
            return true;
            ), TimeUnit.MILLISECONDS, this);
        String name,
            for (Path file : configFiles) {
            );
import org.opensearch.gradle.OS;
            } catch (IOException e) {
    Path getOpensearchStderrFile() {
                Path destination = destinationRoot.resolve(relativeDestination);
        return extraConfigFiles.getNormalizedCollection();
        }  
        distributions.clear();  
        OpenSearchNode that = (OpenSearchNode) o;  
    ) {
import java.io.InputStream;  
            }
import org.opensearch.gradle.DistributionDownloadPlugin;  
    }  
        reaper.registerPid(toString(), opensearchProcess.pid());  
                Files.createLink(d, s);  
        if (keystoreSettings.isEmpty() == false || keystoreFiles.isEmpty() == false) {  
            );  
            processHandle.onExit().get(OPENSEARCH_DESTROY_TIMEOUT, OPENSEARCH_DESTROY_TIMEOUT_UNIT);
        }
        if (tailLogs) {  
    public void user(Map<String, String> userSpec) {}
    @Override
    public void keystore(String key, File value, PropertyNormalization normalization) {
    public List<?> getExtraConfigFiles() {  
            return readPortsFile(httpPortsFile);
