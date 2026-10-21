                executeSection(executableSection);
     * Property that allows to control which REST tests get run. Supports comma separated list of tests
        if (validationException != null) {
            }
        final Version clusterManagerVersion
            }
    /**
        OpenSearchNodesSniffer.Scheme scheme = OpenSearchNodesSniffer.Scheme.valueOf(getProtocol().toUpperCase(Locale.ROOT));
    private Tuple<Version, Version> readVersionsFromCatNodes(RestClient restClient) throws IOException {
 * The OpenSearch Contributors require contributions made to
        RestClientBuilder builder = RestClient.builder(sniffer.sniff().toArray(new Node[0]));
        String[] paths = resolvePathsProperty(REST_TESTS_SUITE, ""); // default to all tests under the test root
            RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
                            }
            String testPath = testCandidate.getSuitePath() + "/" + testCandidate.getTestSection().getName();
        }
                throw new AssertionError(errorMessage(executableSection, e), e);
 * under the License.
        }
    }
    /**
            // Because this has not yet transitioned to a composable template, it's possible that
            request.setOptions(builder.build());
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
                    .replace("\\n", "\n")
            final String[] versionAndClusterManager = perNode.split("\\s+");
    @Before
import java.util.List;
        );
                executeSection(executableSection);
            adminClient(),
            denylistPathMatchers = new ArrayList<>();
                        validationException = new IllegalArgumentException(previousMessage + "\n- " + e.getMessage());
        filesSet.add(file);
        } finally {
import java.util.Map;
        Version clusterManagerVersion = null;
     * {@link RestClientBuilder} for a client with that metadata.
     * or directories that contain tests e.g. -Dtests.rest.suite=index,get,create/10_with_id
        }
    @BeforeClass
            throw new IllegalArgumentException("No executable sections loaded for [" + testCandidate.getTestPath() + "]");
    }
    private static final String PATHS_SEPARATOR = "(?<!\\\\),";
            }
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;
        if (useDefaultNumberOfShards == false
                    }
                        throw new IllegalArgumentException("yaml files are no longer supported: " + file);
                executeSection(doSection);
 * specific language governing permissions and limitations
                    for (ClientYamlSuiteRestApi.Path path : restApi.getPaths()) {
        Path root = PathUtils.get(OpenSearchClientYamlSuiteTestCase.class.getResource(TESTS_PATH).toURI());
            if (Files.isDirectory(path)) {
        if (testCandidate.getTestSection().getExecutableSections().size() == 0) {
                                    .append(" supports GET with a body but doesn't support POST");
        String groupName = root.relativize(file.getParent()).toString();
            // templates instead of legacy templates
        Set<Path> filesSet = files.get(groupName);
    }
            for (final String entry : denylistAdditions) {
     * @return {@link Tuple} of [minimal node version, cluster-manager node version]
     * Sniff the cluster for host metadata and return a
                if (restApi.isBodySupported()) {
        restTestExecutionContext.clear();
                    if (validationException == null) {
    ) {
 * <p>
    /**
 */
    public static void initializeUseDefaultNumberOfShards() {
import java.util.HashSet;
            // to be permissive in this case. This can be removed once all tests use composable
    protected RequestOptions getCatNodesVersionClusterManagerRequestOptions() {
import org.junit.BeforeClass;
        tests.sort(Comparator.comparing(o -> ((ClientYamlTestCandidate) o[0]).getTestPath()));
     */
        }
            }
            logger.debug("end setup test [{}]", testCandidate.getTestPath());
import org.opensearch.test.rest.yaml.restspec.ClientYamlSuiteRestApi;
    protected final RestClientBuilder getClientBuilderWithSniffedHosts() throws IOException {
        }
            filesSet = new HashSet<>();
                                errorMessage.append("\n- ")
@TimeoutSuite(millis = 30 * TimeUnits.MINUTE)
    private static ClientYamlTestExecutionContext restTestExecutionContext;
            final List<HttpHost> hosts = getClusterHosts();
                        addSuite(root, file, files);
import org.opensearch.test.rest.yaml.restspec.ClientYamlSuiteRestSpec;
            final Version clusterManagerVersion = versionVersionTuple.v2();
                    } else if (file.toString().endsWith(".yaml")) {
    /** Add a single suite file to the set of suites. */
    /**
                version = currentVersion;
        Version version = null;
                        Throwable[] suppressed = validationException.getSuppressed();
    private static boolean useDefaultNumberOfShards;
            }
            List<Path> yamlFiles = new ArrayList<>(yamlSuites.get(api));
    public static final String REST_TESTS_DENYLIST = "tests.rest.denylist";
package org.opensearch.test.rest.yaml;
        final Request request = new Request("GET", "/_cat/nodes");
    private final ClientYamlTestCandidate testCandidate;
        } else {
     * e.g. "-Dtests.rest.denylist=get/10_basic/*"
            && testCandidate.getTestSection().getSkipSection().getFeatures().contains("default_shards") == false) {
        ClientYamlTestResponse restTestResponse = new ClientYamlTestResponse(response);
            executableSection.execute(restTestExecutionContext);
        final List<HttpHost> hosts,
    private static ClientYamlTestExecutionContext adminExecutionContext;
                addSuite(root, path, files);
            StringBuilder errorMessage = new StringBuilder();
        List<ClientYamlTestSuite> suites = new ArrayList<>();
        // we simply go to the _cat/nodes API and parse all versions in the cluster
        }
 */
            testCandidate.getTeardownSection().getSkipSection().getSkipMessage(testCandidate.getSuitePath()),
            clusterManagerVersion,
    }
                suites.add(suite);
        if (!Strings.hasLength(property)) {
    }
    /**
                    }
import org.opensearch.client.sniff.OpenSearchNodesSniffer;
            files.put(groupName, filesSet);
        // sort the candidates so they will always be in the same order before being shuffled, for repeatability
                try {
            final Request request = new Request("PUT", "/_template/global");
     */
        }
     * top of the tests denylisted in the build.
    }
            testCandidate.getTeardownSection().getSkipSection().skip(restTestExecutionContext.esVersion())
    }
import org.opensearch.common.util.io.IOUtils;
                        }
            request.setJsonEntity("{\"index_patterns\":[\"*\"],\"settings\":{\"index.number_of_shards\":2}}");
        // skip test if it matches one of the denylist globs
 * KIND, either express or implied.  See the License for the
            throw validationException;
                }
    public void test() throws IOException {
            Tuple<Version, Version> versionVersionTuple = readVersionsFromCatNodes(adminClient());
        } catch (AssertionError | Exception e) {
            logger.info(
import org.apache.lucene.tests.util.TimeUnits;
            adminClient().performRequest(request);
                } catch (IllegalArgumentException e) {
            } else {
            return property.split(PATHS_SEPARATOR);
    @AfterClass
    private void executeSection(ExecutableSection executableSection) {
            }
import org.junit.AfterClass;
            // template. In order to avoid this failing the test, we override the warnings handler
            }
import java.io.IOException;
            testCandidate.getSetupSection().getSkipSection().getSkipMessage(testCandidate.getSuitePath()),
        if (filesSet == null) {
    public static final String REST_TESTS_SUITE = "tests.rest.suite";
            final boolean clusterManager = versionAndClusterManager[1].trim().equals("*");
 * The suite timeout is extended to account for projects with a large number of tests.
 *
    private static ClientYamlTestClient clientYamlTestClient;
    }
            testCandidate.getTestSection().getSkipSection().skip(restTestExecutionContext.esVersion())
        }
        // yaml suites are grouped by directory (effectively by api)
import java.nio.file.Files;
            }
 * this work for additional information regarding copyright
    private static void addSuite(Path root, Path file, Map<String, Set<Path>> files) {
        }
     * @param restClient REST client used to discover cluster nodes
        useDefaultNumberOfShards = usually();
                "initializing client, minimum OpenSearch version [{}], cluster-manager version, [{}], hosts {}",
     * Create parameters for this parameterized test.
        } finally {
/*
        return createParameters(ExecutableSection.XCONTENT_REGISTRY);
            assert versionAndClusterManager.length == 2 : "invalid line: " + perNode + " length: " + versionAndClusterManager.length;
    }
            logger.debug("end teardown test [{}]", testCandidate.getTestPath());
 * software distributed under the License is distributed on an
            assert denylistPathMatchers == null;
            final String[] denylist = resolvePathsProperty(REST_TESTS_DENYLIST, null);
                }
                "Stash dump on test failure [{}]",
import java.util.Locale;
    }
 * Modifications Copyright OpenSearch Contributors. See
                ClientYamlTestSuite suite = ClientYamlTestSuite.parse(executeableSectionRegistry, api, yamlFile);
     * Property that allows to control whether spec validation is enabled or not (default true).
        if (validateSpec) {
            // Dump the stash on failure. Instead of dumping it in true json we escape `\n`s so stack traces are easier to read
            if (errorMessage.length() > 0) {
     */
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
import java.nio.file.Path;
    }
                    validationException.addSuppressed(e);
                });
     */
            adminExecutionContext = new ClientYamlTestExecutionContext(clientYamlTestClient, false);
        final ClientYamlSuiteRestSpec restSpec,
            }
        for (ClientYamlTestSuite yamlTestSuite : suites) {
 * compatible open source license.
            // this can overlap an installed composable template since this is a global (*)
                    .replace("\\t", "\t")
        // skip test if test section is disabled
            logger.info(
     * Detect minimal node version and master node version of cluster using REST Client.
        );
import org.opensearch.Version;
     * Execute an {@link ExecutableSection}, careful to log its place of origin on failure.
import java.util.ArrayList;
    /**
        try {
        for (String strPath : paths) {
        return true;
            logger.debug("start setup test [{}]", testCandidate.getTestPath());
/**
        }
 * You may obtain a copy of the License at
     * Property that allows to denylist some of the REST tests based on a comma separated list of globs
            scheme
    private static final String SPEC_PATH = "/rest-api-spec/api";
            builder.setWarningsHandler(WarningsHandler.PERMISSIVE);
import org.opensearch.client.RestClient;
            for (ExecutableSection executableSection : testCandidate.getSetupSection().getExecutableSections()) {
            denylistPathMatchers = null;
            final Version minVersion = versionVersionTuple.v1();
import com.carrotsearch.randomizedtesting.RandomizedTest;
            }
     * This allows us to support ',' within paths when it is escaped with a slash.
     */
        String[] split = nodesCatResponse.split("\n");
    // pkg private for tests
     */
                        List<String> methodsList = Arrays.asList(path.getMethods());
        return RequestOptions.DEFAULT;
                denylistPathMatchers.add(new DenylistedPathPatternMatcher(entry));
            if (clusterManager) {
    }
        if (restTestExecutionContext == null) {
        for (String api : yamlSuites.keySet()) {
        IllegalArgumentException validationException = null;
        return new ClientYamlTestClient(
    public static final String REST_TESTS_DENYLIST_ADDITIONS = "tests.rest.denylist_additions";
                clusterManagerVersion,
            assumeFalse("[" + testCandidate.getTestPath() + "] skipped, reason: denylisted", denylistedPathMatcher.isSuffixMatch(testPath));
        String property = System.getProperty(propertyName);
        Map<String, Set<Path>> files = new HashMap<>();
    }
            validateSpec(restSpec);
        boolean validateSpec = RandomizedTest.systemPropertyAsBoolean(REST_TESTS_VALIDATE_SPEC, true);
        }
        );
            adminExecutionContext = null;
     *
        try {
     */
     */
                        validationException = new IllegalArgumentException(
 * Unless required by applicable law or agreed to in writing,
        String nodesCatResponse = restTestResponse.getBodyAsString();
        try {
                denylistPathMatchers.add(new DenylistedPathPatternMatcher(entry));
        final RestClient restClient,
        assert denylistPathMatchers != null;
import org.opensearch.client.Response;
                            "Validation errors for the following test suites:\n- " + e.getMessage()
    }
                clusterManagerVersion = currentVersion;
     * <p>
        // skip test if the whole suite (yaml file) is disabled
            logger.debug("start teardown test [{}]", testCandidate.getTestPath());
     */
                path = root.resolve(strPath + ".yml");
            clientYamlTestClient = null;
    }
                        }
        assert adminExecutionContext != null;
            for (ClientYamlTestSection testSection : yamlTestSuite.getTestSections()) {
        }
import org.opensearch.test.rest.OpenSearchRestTestCase;
import java.util.Comparator;
    }
        assumeFalse(
import org.opensearch.test.rest.yaml.section.ClientYamlTestSection;
import org.opensearch.common.collect.Tuple;
            if (version == null) {
}
        adminExecutionContext.clear();
import java.util.HashMap;
        restTestExecutionContext.clear();
                            if (!methodsList.contains("POST")) {
                    .replace("\\r", "\r")
 * clients against an opensearch cluster.
                        for (Throwable t : suppressed) {
            final ClientYamlSuiteRestSpec restSpec = ClientYamlSuiteRestSpec.load(SPEC_PATH);
     * @throws IOException When _cat API output parsing fails
            esVersion,
    protected ClientYamlTestClient initClientYamlTestClient(
        return "Failure at [" + testCandidate.getSuitePath() + ":" + executableSection.getLocation().lineNumber + "]: " + t.getMessage();
                minVersion,
    private static final String REST_TESTS_VALIDATE_SPEC = "tests.rest.validate_spec";
        return new Tuple<>(version, clusterManagerVersion);
 * ownership. Elasticsearch licenses this file to you under
                tests.add(new Object[] { new ClientYamlTestCandidate(yamlTestSuite, testSection) });
        configureClient(builder, restClientSettings());
     */
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Set<Path>> yamlSuites = loadSuites(paths);
        assert restTestExecutionContext != null;
        return tests;
            OpenSearchNodesSniffer.DEFAULT_SNIFF_REQUEST_TIMEOUT,
        // skip test if the whole suite (yaml file) is disabled
            IOUtils.close(clientYamlTestClient);
            this::getClientBuilderWithSniffedHosts
     * {@link ExecutableSection#XCONTENT_REGISTRY list} of executable sections
    public static Iterable<Object[]> createParameters() throws Exception {
 */
            } else {
     * For example, the path string "/a/b/c\,d/e/f,/foo/bar,/baz" is separated to "/a/b/c\,d/e/f", "/foo/bar" and "/baz".
     *
                assert Files.exists(path);
import org.opensearch.client.RequestOptions;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (e instanceof AssertionError) {
            hosts,
import org.opensearch.test.rest.yaml.section.ExecutableSection;
    private static List<DenylistedPathPatternMatcher> denylistPathMatchers;
import org.opensearch.client.WarningsHandler;
                    if (file.toString().endsWith(".yml")) {
 * not use this file except in compliance with the License.
import org.opensearch.client.Request;
    private static void validateSpec(ClientYamlSuiteRestSpec restSpec) {
                throw new IllegalArgumentException(errorMessage.toString());
        for (DenylistedPathPatternMatcher denylistedPathMatcher : denylistPathMatchers) {
import java.util.Arrays;
        request.setOptions(getCatNodesVersionClusterManagerRequestOptions());
import org.opensearch.test.rest.yaml.section.ClientYamlTestSuite;
            return defaultValue == null ? Strings.EMPTY_ARRAY : new String[] { defaultValue };
 * the Apache License, Version 2.0 (the "License"); you may
     * This separator pattern matches ',' except it is preceded by a '\'.
     * <p>
            restSpec,
        assumeFalse(
        }
                assert clusterManagerVersion == null;
                    suite.validate();
        this.testCandidate = testCandidate;
    public static void closeClient() throws IOException {
                        String previousMessage = validationException.getMessage();
    static Map<String, Set<Path>> loadSuites(String... paths) throws Exception {
            Path path = root.resolve(strPath);
    public void initAndResetContext() throws Exception {
            assert adminExecutionContext == null;
        }
        assumeFalse(
        }
            final String[] denylistAdditions = resolvePathsProperty(REST_TESTS_DENYLIST_ADDITIONS, null);
        return adminExecutionContext;
            testCandidate.getSetupSection().getSkipSection().skip(restTestExecutionContext.esVersion())
                        if (methodsList.contains("GET") && restApi.isBodySupported()) {
    private static String[] resolvePathsProperty(String propertyName, String defaultValue) {
    public static Iterable<Object[]> createParameters(NamedXContentRegistry executeableSectionRegistry) throws Exception {
            for (Path yamlFile : yamlFiles) {
import org.opensearch.common.io.PathUtils;
            for (ExecutableSection executableSection : testCandidate.getTestSection().getExecutableSections()) {
        Response response = restClient.performRequest(request);
import org.opensearch.core.xcontent.NamedXContentRegistry;
 */
        // let's check that there is something to run, otherwise there might be a problem with the test section
    protected boolean randomizeContentType() {
        List<Object[]> tests = new ArrayList<>();
                            validationException.addSuppressed(t);
 *
        final Version esVersion,
     * For reference, this regular expression feature is known as zero-width negative look-behind.
/*
                throw new RuntimeException(errorMessage(executableSection, e), e);
import org.opensearch.client.RestClientBuilder;
    /** Find all yaml suites that match the given list of paths from the root test path. */
            clientYamlTestClient = initClientYamlTestClient(restSpec, client(), hosts, minVersion, clusterManagerVersion);
        if (!testCandidate.getSetupSection().isEmpty()) {
            );
    /**
    /**
 *
            );
        for (String perNode : split) {
                        );
        request.addParameter("h", "version,master");
        return files;
     * Create parameters for this parameterized test. Uses the
            for (ExecutableSection doSection : testCandidate.getTeardownSection().getDoSections()) {
                    } else {
                    }
                version = currentVersion;
import org.opensearch.client.Node;
     * defined in {@link ExecutableSection}.
            }
        }
    }
    /**
            testCandidate.getTestSection().getSkipSection().getSkipMessage(testCandidate.getTestPath()),
    private String errorMessage(ExecutableSection executableSection, Throwable t) {
import org.junit.Before;
            final Version currentVersion = Version.fromString(versionAndClusterManager[0]);
                                    .append(restApi.getName())
            restClient,
import org.opensearch.core.common.Strings;
                Files.walk(path).forEach(file -> {
            }
    }
/*
        // admin context must be available for @After always, regardless of whether the test was denylisted
            restTestExecutionContext = null;
        return builder;
            for (ClientYamlSuiteRestApi restApi : restSpec.getApis()) {
                hosts
        );
     * We use tests.rest.denylist in build files to denylist tests; this property enables a user to add additional denylisted tests on
import org.apache.hc.core5.http.HttpHost;
 * Runs a suite of yaml tests shared with all the official OpenSearch
            restTestExecutionContext = new ClientYamlTestExecutionContext(clientYamlTestClient, randomizeContentType());
import java.util.Set;
        );
    protected OpenSearchClientYamlSuiteTestCase(ClientYamlTestCandidate testCandidate) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            } else if (version.onOrAfter(currentVersion)) {
    private static final String TESTS_PATH = "/rest-api-spec/test";
        OpenSearchNodesSniffer sniffer = new OpenSearchNodesSniffer(
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
            for (final String entry : denylist) {
    protected ClientYamlTestExecutionContext getAdminExecutionContext() {
    }
                Strings.toString(MediaTypeRegistry.JSON, restTestExecutionContext.stash(), true, true)
            }
public abstract class OpenSearchClientYamlSuiteTestCase extends OpenSearchRestTestCase {
