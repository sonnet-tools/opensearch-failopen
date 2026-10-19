            }
            }  
            if (clusterManager) {  
                    .replace("\\t", "\t")  
     * {@link RestClientBuilder} for a client with that metadata.
                minVersion,
    @AfterClass  
        assumeFalse(
import java.util.Map;
            } else if (version.onOrAfter(currentVersion)) {  
        if (restTestExecutionContext == null) {
    private void executeSection(ExecutableSection executableSection) {
    }
    }
                }  
/*  
            testCandidate.getTeardownSection().getSkipSection().skip(restTestExecutionContext.esVersion())
            // template. In order to avoid this failing the test, we override the warnings handler  
            denylistPathMatchers = null;
                throw new AssertionError(errorMessage(executableSection, e), e);  
import org.opensearch.common.util.io.IOUtils;
            for (ClientYamlTestSection testSection : yamlTestSuite.getTestSections()) {
            }  
 * Runs a suite of yaml tests shared with all the official OpenSearch  
                "Stash dump on test failure [{}]",
            }  
        }
        final Version clusterManagerVersion  
import org.apache.lucene.tests.util.TimeUnits;
            String testPath = testCandidate.getSuitePath() + "/" + testCandidate.getTestSection().getName();
 * GitHub history for details.
        OpenSearchNodesSniffer.Scheme scheme = OpenSearchNodesSniffer.Scheme.valueOf(getProtocol().toUpperCase(Locale.ROOT));
import java.util.List;  
        return "Failure at [" + testCandidate.getSuitePath() + ":" + executableSection.getLocation().lineNumber + "]: " + t.getMessage();
}  
            );
     * defined in {@link ExecutableSection}.  
        }  
                assert Files.exists(path);  
        String groupName = root.relativize(file.getParent()).toString();  
    ) {
            logger.debug("start teardown test [{}]", testCandidate.getTestPath());  
            final Version clusterManagerVersion = versionVersionTuple.v2();
            }
     * @return {@link Tuple} of [minimal node version, cluster-manager node version]
        Path root = PathUtils.get(OpenSearchClientYamlSuiteTestCase.class.getResource(TESTS_PATH).toURI());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.rest.OpenSearchRestTestCase;  
                hosts  
 * KIND, either express or implied.  See the License for the
        for (String api : yamlSuites.keySet()) {  
    @BeforeClass
            adminClient(),
            builder.setWarningsHandler(WarningsHandler.PERMISSIVE);
        if (useDefaultNumberOfShards == false  
    /**  
                        validationException = new IllegalArgumentException(previousMessage + "\n- " + e.getMessage());  
                            "Validation errors for the following test suites:\n- " + e.getMessage()
        try {
            for (final String entry : denylist) {
            throw validationException;
import org.opensearch.client.RequestOptions;  
            for (ClientYamlSuiteRestApi restApi : restSpec.getApis()) {
                        for (Throwable t : suppressed) {
import java.util.HashMap;
            && testCandidate.getTestSection().getSkipSection().getFeatures().contains("default_shards") == false) {
import org.opensearch.test.rest.yaml.restspec.ClientYamlSuiteRestApi;
        restTestExecutionContext.clear();
    public static Iterable<Object[]> createParameters(NamedXContentRegistry executeableSectionRegistry) throws Exception {  
        assumeFalse(
        );
        } else {
        return new ClientYamlTestClient(
    }
    protected ClientYamlTestExecutionContext getAdminExecutionContext() {  
        }
                        throw new IllegalArgumentException("yaml files are no longer supported: " + file);
        }
import org.opensearch.common.io.PathUtils;
            files.put(groupName, filesSet);
        assumeFalse(  
            for (Path yamlFile : yamlFiles) {
            assert versionAndClusterManager.length == 2 : "invalid line: " + perNode + " length: " + versionAndClusterManager.length;  
    public static void initializeUseDefaultNumberOfShards() {
    }
 * compatible open source license.
 * software distributed under the License is distributed on an
                "initializing client, minimum OpenSearch version [{}], cluster-manager version, [{}], hosts {}",  
            adminExecutionContext = new ClientYamlTestExecutionContext(clientYamlTestClient, false);
        for (String strPath : paths) {  
 */  
    private static ClientYamlTestExecutionContext adminExecutionContext;
        String[] paths = resolvePathsProperty(REST_TESTS_SUITE, ""); // default to all tests under the test root
                    if (validationException == null) {
     */
            restClient,
                assert clusterManagerVersion == null;
    }
            assumeFalse("[" + testCandidate.getTestPath() + "] skipped, reason: denylisted", denylistedPathMatcher.isSuffixMatch(testPath));  
     *
    private static ClientYamlTestClient clientYamlTestClient;  
            final String[] versionAndClusterManager = perNode.split("\\s+");
import org.opensearch.test.rest.yaml.section.ExecutableSection;
        }
            return defaultValue == null ? Strings.EMPTY_ARRAY : new String[] { defaultValue };  
                    } else {  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Locale;
        }  
            logger.debug("end teardown test [{}]", testCandidate.getTestPath());
import org.opensearch.client.Node;
            if (version == null) {
    private static void validateSpec(ClientYamlSuiteRestSpec restSpec) {
            final ClientYamlSuiteRestSpec restSpec = ClientYamlSuiteRestSpec.load(SPEC_PATH);
        final ClientYamlSuiteRestSpec restSpec,
    // pkg private for tests
    static Map<String, Set<Path>> loadSuites(String... paths) throws Exception {  
        return files;
     *  
        } finally {
    }  
        }
                    suite.validate();  
     * <p>
            clusterManagerVersion,
                                    .append(restApi.getName())  
    private final ClientYamlTestCandidate testCandidate;
        }
            );
        for (String perNode : split) {
    }
                    .replace("\\r", "\r")
import org.junit.BeforeClass;
                Files.walk(path).forEach(file -> {  
 * You may obtain a copy of the License at  
        if (validateSpec) {  
        if (filesSet == null) {
 *     http://www.apache.org/licenses/LICENSE-2.0
                                    .append(" supports GET with a body but doesn't support POST");
        Version version = null;
     */
    protected boolean randomizeContentType() {
            executableSection.execute(restTestExecutionContext);
/*  
    /**
        }
            logger.debug("start setup test [{}]", testCandidate.getTestPath());
    /**
     * <p>  
                }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.MediaTypeRegistry;
            restSpec,  
 * Modifications Copyright OpenSearch Contributors. See
    }
        // we simply go to the _cat/nodes API and parse all versions in the cluster  
                    }
            throw new IllegalArgumentException("No executable sections loaded for [" + testCandidate.getTestPath() + "]");  
            logger.info(
    /**
        }  
    protected OpenSearchClientYamlSuiteTestCase(ClientYamlTestCandidate testCandidate) {
     */  
 * specific language governing permissions and limitations
 * The suite timeout is extended to account for projects with a large number of tests.  
        if (testCandidate.getTestSection().getExecutableSections().size() == 0) {
            }
    protected RequestOptions getCatNodesVersionClusterManagerRequestOptions() {
    public static final String REST_TESTS_DENYLIST = "tests.rest.denylist";
     */
    /**  
    public static void closeClient() throws IOException {
        Set<Path> filesSet = files.get(groupName);
                Strings.toString(MediaTypeRegistry.JSON, restTestExecutionContext.stash(), true, true)  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.test.rest.yaml.restspec.ClientYamlSuiteRestSpec;
        return true;  
                throw new RuntimeException(errorMessage(executableSection, e), e);
    }
    }
import org.opensearch.core.common.Strings;  
            if (errorMessage.length() > 0) {
        final RestClient restClient,  
        assert adminExecutionContext != null;
     */
            testCandidate.getSetupSection().getSkipSection().getSkipMessage(testCandidate.getSuitePath()),
        return tests;
import org.junit.AfterClass;  
     * or directories that contain tests e.g. -Dtests.rest.suite=index,get,create/10_with_id
        String nodesCatResponse = restTestResponse.getBodyAsString();  
            logger.debug("end setup test [{}]", testCandidate.getTestPath());
     * This allows us to support ',' within paths when it is escaped with a slash.  
            IOUtils.close(clientYamlTestClient);  
    protected final RestClientBuilder getClientBuilderWithSniffedHosts() throws IOException {
            return property.split(PATHS_SEPARATOR);
            }
            scheme  
    }  
     * Create parameters for this parameterized test.
 * clients against an opensearch cluster.
                    validationException.addSuppressed(e);
                            if (!methodsList.contains("POST")) {
            validateSpec(restSpec);  
import org.opensearch.client.WarningsHandler;
            Path path = root.resolve(strPath);
    /** Find all yaml suites that match the given list of paths from the root test path. */
                suites.add(suite);
            }
                    }
            } else {
import org.opensearch.test.rest.yaml.section.ClientYamlTestSection;  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 *  
     * Property that allows to control which REST tests get run. Supports comma separated list of tests  
        if (!testCandidate.getSetupSection().isEmpty()) {  
     * Property that allows to denylist some of the REST tests based on a comma separated list of globs
            adminClient().performRequest(request);  
        // skip test if the whole suite (yaml file) is disabled  
                clusterManagerVersion = currentVersion;
     */  
public abstract class OpenSearchClientYamlSuiteTestCase extends OpenSearchRestTestCase {  
        } finally {
    public static Iterable<Object[]> createParameters() throws Exception {
    }
        if (validationException != null) {
                clusterManagerVersion,
                        addSuite(root, file, files);
     */
        RestClientBuilder builder = RestClient.builder(sniffer.sniff().toArray(new Node[0]));
                    for (ClientYamlSuiteRestApi.Path path : restApi.getPaths()) {
        return adminExecutionContext;
import java.nio.file.Files;
                        );
        useDefaultNumberOfShards = usually();  
     * For reference, this regular expression feature is known as zero-width negative look-behind.
    @Before  
        Version clusterManagerVersion = null;  
    private Tuple<Version, Version> readVersionsFromCatNodes(RestClient restClient) throws IOException {
                    } else if (file.toString().endsWith(".yaml")) {  
        this.testCandidate = testCandidate;
        Response response = restClient.performRequest(request);
            final List<HttpHost> hosts = getClusterHosts();
            // to be permissive in this case. This can be removed once all tests use composable
            final boolean clusterManager = versionAndClusterManager[1].trim().equals("*");
            for (final String entry : denylistAdditions) {
package org.opensearch.test.rest.yaml;
        );
        filesSet.add(file);  
            StringBuilder errorMessage = new StringBuilder();
    }  
    private static void addSuite(Path root, Path file, Map<String, Set<Path>> files) {
        configureClient(builder, restClientSettings());  
        // sort the candidates so they will always be in the same order before being shuffled, for repeatability
        adminExecutionContext.clear();
        return RequestOptions.DEFAULT;
import org.apache.hc.core5.http.HttpHost;
                path = root.resolve(strPath + ".yml");
     * For example, the path string "/a/b/c\,d/e/f,/foo/bar,/baz" is separated to "/a/b/c\,d/e/f", "/foo/bar" and "/baz".
            this::getClientBuilderWithSniffedHosts
        }
                        String previousMessage = validationException.getMessage();
            testCandidate.getSetupSection().getSkipSection().skip(restTestExecutionContext.esVersion())  
        boolean validateSpec = RandomizedTest.systemPropertyAsBoolean(REST_TESTS_VALIDATE_SPEC, true);
    private static final String PATHS_SEPARATOR = "(?<!\\\\),";
        Map<String, Set<Path>> yamlSuites = loadSuites(paths);
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;
    private String errorMessage(ExecutableSection executableSection, Throwable t) {
            testCandidate.getTeardownSection().getSkipSection().getSkipMessage(testCandidate.getSuitePath()),
                                errorMessage.append("\n- ")
                        }  
            testCandidate.getTestSection().getSkipSection().skip(restTestExecutionContext.esVersion())
        return builder;
        );  
     * This separator pattern matches ',' except it is preceded by a '\'.
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.ArrayList;
            final Request request = new Request("PUT", "/_template/global");
     * {@link ExecutableSection#XCONTENT_REGISTRY list} of executable sections
        // skip test if it matches one of the denylist globs  
    /** Add a single suite file to the set of suites. */
                ClientYamlTestSuite suite = ClientYamlTestSuite.parse(executeableSectionRegistry, api, yamlFile);  
            clientYamlTestClient = null;
import java.util.HashSet;
            assert denylistPathMatchers == null;
    private static ClientYamlTestExecutionContext restTestExecutionContext;
    }
        request.addParameter("h", "version,master");
            }  
import org.opensearch.common.collect.Tuple;  
                        }  
import com.carrotsearch.randomizedtesting.RandomizedTest;
            }  
     * Execute an {@link ExecutableSection}, careful to log its place of origin on failure.  
                denylistPathMatchers.add(new DenylistedPathPatternMatcher(entry));
import org.opensearch.client.Response;
     * Create parameters for this parameterized test. Uses the
    private static boolean useDefaultNumberOfShards;
        assert restTestExecutionContext != null;  
        request.setOptions(getCatNodesVersionClusterManagerRequestOptions());  
@TimeoutSuite(millis = 30 * TimeUnits.MINUTE)
                    if (file.toString().endsWith(".yml")) {
 */
                tests.add(new Object[] { new ClientYamlTestCandidate(yamlTestSuite, testSection) });
        for (DenylistedPathPatternMatcher denylistedPathMatcher : denylistPathMatchers) {
    }  
                addSuite(root, path, files);
            } else {
        try {  
            // this can overlap an installed composable template since this is a global (*)
            assert adminExecutionContext == null;  
                    }
     */
            for (ExecutableSection executableSection : testCandidate.getTestSection().getExecutableSections()) {
import org.opensearch.client.sniff.OpenSearchNodesSniffer;
        ClientYamlTestResponse restTestResponse = new ClientYamlTestResponse(response);
/**
import java.util.Set;  
 * this work for additional information regarding copyright
            restTestExecutionContext = null;  
 */
            }  
                            validationException.addSuppressed(t);
            final Version minVersion = versionVersionTuple.v1();  
        }  
        OpenSearchNodesSniffer sniffer = new OpenSearchNodesSniffer(  
 * <p>
            for (ExecutableSection executableSection : testCandidate.getSetupSection().getExecutableSections()) {
    public static final String REST_TESTS_SUITE = "tests.rest.suite";  
    /**
                } catch (IllegalArgumentException e) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param restClient REST client used to discover cluster nodes
    private static final String TESTS_PATH = "/rest-api-spec/test";
    /**  
    }
import java.util.Comparator;  
    public void test() throws IOException {
                try {
            for (ExecutableSection doSection : testCandidate.getTeardownSection().getDoSections()) {
     * @throws IOException When _cat API output parsing fails  
        String property = System.getProperty(propertyName);
        }  
            request.setOptions(builder.build());
            logger.info(
 * SPDX-License-Identifier: Apache-2.0
                        List<String> methodsList = Arrays.asList(path.getMethods());
            denylistPathMatchers = new ArrayList<>();  
    /**
            final Version currentVersion = Version.fromString(versionAndClusterManager[0]);
import java.nio.file.Path;  
            adminExecutionContext = null;
    public static final String REST_TESTS_DENYLIST_ADDITIONS = "tests.rest.denylist_additions";
            // Dump the stash on failure. Instead of dumping it in true json we escape `\n`s so stack traces are easier to read  
            }  
 * not use this file except in compliance with the License.
            OpenSearchNodesSniffer.DEFAULT_SNIFF_REQUEST_TIMEOUT,
     * e.g. "-Dtests.rest.denylist=get/10_basic/*"  
        // admin context must be available for @After always, regardless of whether the test was denylisted
                    .replace("\\n", "\n")
            if (e instanceof AssertionError) {
        );
            request.setJsonEntity("{\"index_patterns\":[\"*\"],\"settings\":{\"index.number_of_shards\":2}}");  
            if (Files.isDirectory(path)) {
            List<Path> yamlFiles = new ArrayList<>(yamlSuites.get(api));
import org.junit.Before;
import java.util.Arrays;
        restTestExecutionContext.clear();
            esVersion,  
    private static final String SPEC_PATH = "/rest-api-spec/api";
                throw new IllegalArgumentException(errorMessage.toString());
        }  
        }
     */  
            }
                version = currentVersion;
                denylistPathMatchers.add(new DenylistedPathPatternMatcher(entry));  
        if (!Strings.hasLength(property)) {
    private static final String REST_TESTS_VALIDATE_SPEC = "tests.rest.validate_spec";
                            }
/*
            // Because this has not yet transitioned to a composable template, it's possible that
                        if (methodsList.contains("GET") && restApi.isBodySupported()) {  
    /**
 *
            clientYamlTestClient = initClientYamlTestClient(restSpec, client(), hosts, minVersion, clusterManagerVersion);
                executeSection(doSection);
        } catch (AssertionError | Exception e) {
    /**  
                        Throwable[] suppressed = validationException.getSuppressed();
                version = currentVersion;
import java.io.IOException;
        return new Tuple<>(version, clusterManagerVersion);
                });  
            final String[] denylistAdditions = resolvePathsProperty(REST_TESTS_DENYLIST_ADDITIONS, null);
        );  
        for (ClientYamlTestSuite yamlTestSuite : suites) {  
            testCandidate.getTestSection().getSkipSection().getSkipMessage(testCandidate.getTestPath()),  
        final Version esVersion,
import org.opensearch.core.xcontent.NamedXContentRegistry;
        }
import org.opensearch.Version;  
        Map<String, Set<Path>> files = new HashMap<>();
            hosts,
                executeSection(executableSection);  
        // let's check that there is something to run, otherwise there might be a problem with the test section
import org.opensearch.test.rest.yaml.section.ClientYamlTestSuite;
import org.opensearch.client.RestClient;
        final List<HttpHost> hosts,
     * Detect minimal node version and master node version of cluster using REST Client.
    }
            // templates instead of legacy templates
        IllegalArgumentException validationException = null;
            restTestExecutionContext = new ClientYamlTestExecutionContext(clientYamlTestClient, randomizeContentType());  
            Tuple<Version, Version> versionVersionTuple = readVersionsFromCatNodes(adminClient());
            RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();  
        // skip test if test section is disabled
     * top of the tests denylisted in the build.
        List<Object[]> tests = new ArrayList<>();
        assert denylistPathMatchers != null;
        final Request request = new Request("GET", "/_cat/nodes");
            final String[] denylist = resolvePathsProperty(REST_TESTS_DENYLIST, null);
        // yaml suites are grouped by directory (effectively by api)
import org.opensearch.client.Request;
        try {
        return createParameters(ExecutableSection.XCONTENT_REGISTRY);  
 * license agreements. See the NOTICE file distributed with
    private static String[] resolvePathsProperty(String propertyName, String defaultValue) {  
                if (restApi.isBodySupported()) {  
    private static List<DenylistedPathPatternMatcher> denylistPathMatchers;  
 *
     */
        // skip test if the whole suite (yaml file) is disabled
            filesSet = new HashSet<>();  
        List<ClientYamlTestSuite> suites = new ArrayList<>();  
     * Sniff the cluster for host metadata and return a
                        validationException = new IllegalArgumentException(  
     * We use tests.rest.denylist in build files to denylist tests; this property enables a user to add additional denylisted tests on
        String[] split = nodesCatResponse.split("\n");
    }
import org.opensearch.client.RestClientBuilder;  
                executeSection(executableSection);  
    protected ClientYamlTestClient initClientYamlTestClient(
    public void initAndResetContext() throws Exception {
    }
        tests.sort(Comparator.comparing(o -> ((ClientYamlTestCandidate) o[0]).getTestPath()));  
     * Property that allows to control whether spec validation is enabled or not (default true).  
 */  
