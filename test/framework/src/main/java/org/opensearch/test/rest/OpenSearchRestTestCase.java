            clusterHosts = null;
            + "take precedence during new index creation$"
    public void assertNoFileBasedRecovery(String indexName, Predicate<String> targetNode) throws IOException {
        }
     * Controls whether or not to preserve templates upon completion of this test. The default implementation is to delete not preserve
    /**
        }
        assertBusy(() -> {
            List<Map<?, ?>> shardStats = (List<Map<?, ?>>) XContentMapValues.extractValue("indices." + index + ".shards.0", stats);
        return builder.build();
            // We hit a version of ES that doesn't serialize DeleteDataStreamAction.Request#wildcardExpressionsOriginallySpecified field or
        request.addParameter("level", "shards");
            return parser.list();
import org.opensearch.common.SetOnce;
            response.getStatusLine().getStatusCode(),
            return parser.map();
    public static void closeClients() throws IOException {
                            + "]"
                }
        } catch (ResponseException e) {
            for (Map.Entry<String, Object> taskAndName : nodeTasks.entrySet()) {
    /**
            socketTimeoutString == null ? "60s" : socketTimeoutString,
                    fail(
            shardStats.stream()
import java.util.stream.Collectors;
        ensureGlobalCheckpointSynced(indexName);
                deleteRepository(repoName);
        }
            request.addParameter("wait_for_status", "green");
     * Asserts that we do not retain any extra translog for the given index (i.e., turn off the translog retention)
        final Request flushRequest = new Request("POST", "/" + index + "/_flush");
                for (String warning : warnings) {
                throw e;
                    }
        SetOnce<Map<String, List<Map<?, ?>>>> inProgressSnapshots = new SetOnce<>();
    protected HttpHost buildHttpHost(String host, int port) {
    private void wipeClusterSettings() throws IOException {
import static org.hamcrest.Matchers.in;
                            if (taskName.startsWith(ListTasksAction.NAME) || taskFilter.test(taskName)) {
            equalTo(RestStatus.OK.getStatus())
    public void assertEmptyTranslog(String index) throws Exception {
                }
        private boolean isExclusivelyTargetingCurrentVersionCluster() {
import org.opensearch.index.seqno.ReplicationTracker;
    private void wipeCluster() throws Exception {
     */
            clearCommand.endObject();
import org.opensearch.common.CheckedRunnable;
     * Get the client used for ordinary api calls while writing a test
        } else {
        if (preserveClusterSettings() == false) {
                        while ((line = responseReader.readLine()) != null) {
 * the Apache License, Version 2.0 (the "License"); you may
     * @return whether or not to preserve data streams
        }
     */
    protected static void wipeDataStreams() throws IOException {
    /**
    private static List<HttpHost> clusterHosts;
import org.opensearch.common.util.concurrent.ThreadContext;
            }
            } catch (AssertionError e) {
        );
        if (System.getProperty("tests.rest.client_path_prefix") != null) {
    }
            for (List<Map<String, ?>> shard : shards.values()) {
    }
    }
                        return true;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                }
            entity += ",\"mappings\" : {" + mapping + "}";
     */
        final TimeValue socketTimeout = TimeValue.parseTimeValue(
                    assertNotNull(details);
            }
        }
                            + index
    protected static void closeIndex(String index) throws IOException {
 * The OpenSearch Contributors require contributions made to
                        String line;
 * license agreements. See the NOTICE file distributed with
        return false;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
     *
        assertNotNull(shards);
import org.apache.hc.core5.function.Factory;
    /**
import java.util.Objects;
    protected boolean preserveClusterUponCompletion() {
        return cluster;
    protected static void createIndex(String name, Settings settings, String mapping) throws IOException {
                return false;
    /**
     */
    }
         * Adds to the set of warnings that are permissible (but not required) when running
        if (false == Strings.isEmpty(index)) {
        runningTasks.remove(ListTasksAction.NAME);
        }
     * Returns the REST client settings used for admin actions like cleaning up after the test has completed.
     * Waits for the cluster state updates to have been processed, so that no cluster
        Request request = new Request("GET", "/_cluster/health" + (index.trim().isEmpty() ? "" : "/" + index));
            this.testNodeVersions = nodeVersions;
            "Synced flush was removed and a normal flush was performed instead. This transition will be removed in a future version."
        }
import static org.hamcrest.Matchers.equalTo;
    }
import java.util.HashSet;
                }
            }
    protected Map<String, List<Map<?, ?>>> wipeSnapshots() throws IOException {
    }
        assertAcked("Failed to create repository [" + repository + "] of type [" + type + "]: " + response, response);
                if (false == tasks.isEmpty()) {
        @SuppressWarnings("unchecked")
            if (keystorePass == null) {
import org.junit.AfterClass;
     * {@link #preserveIndicesUponCompletion()}, {@link #preserveTemplatesUponCompletion()}, {@link #preserveReposUponCompletion()},
            if (Set.of(404, 405, 500).contains(statusCode) == false) {
            }
        return (Map<String, Object>) XContentMapValues.extractValue(index + ".aliases." + alias, getAliasResponse);
     */
                        .setSslContext(sslcontext)
            }
                    }
        ) {
            } catch (IOException e) {
        Request request = new Request("GET", "/_cluster/health");
        }
                assertTrue((boolean) XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), is, true).get("acknowledged"));
    );
     * state updates are still in-progress when the next test starts.
     * start empty. There isn't an API to delete all snapshots. There is an API to delete all snapshot repositories but that leaves all of
import static org.hamcrest.Matchers.anyOf;
            });
        );
        Map<String, String> headers = ThreadContext.buildDefaultHeaders(settings);
            nodeVersions = new TreeSet<>();
    }
import org.opensearch.common.io.PathUtils;
    protected boolean preserveIndicesUponCompletion() {
            defaultHeaders[i++] = new BasicHeader(entry.getKey(), entry.getValue());
    }
            responseStatusCode,
        request.addParameter("flat_settings", "true");
                        inProgressSnapshots.computeIfAbsent(repoName, key -> new ArrayList<>()).add(snapshotInfo);
        try {
                // Some known warnings can safely be ignored
     *
        Response response = client().performRequest(new Request("HEAD", "/" + index + "/_alias/" + alias));
            request.addParameter("wait_for_no_relocating_shards", "true");
    /**
                            tasksListString.append(line);
        Header[] defaultHeaders = new Header[headers.size()];
            adminClient = buildClient(restAdminSettings(), clusterHosts.toArray(new HttpHost[0]));
            @Override
                .createParser(
     */
        return expectWarnings(deprecationWarning);
        Map<?, ?> getResponse = entityAsMap(adminClient().performRequest(new Request("GET", "/_cluster/settings")));
    /**
        if (aliases != null) {
                    }
        // wipe index templates
        request.addParameter("wait_for_no_initializing_shards", "true");
                try {
         * in mixed-version clusters or those that differ in version from the test client.
                    }
        ) {
        } catch (ResponseException e) {
    }
        return adminClient;
        if (preserveDataStreamsUponCompletion() == false) {
                for (String actualWarning : warnings) {
            } else {
        String cluster = System.getProperty("tests.rest.cluster");
        assertTrue("must find replica", foundReplica);
        return "http";
        }
     * Convert the entity from a {@link Response} into a map of maps.
        return builder.build();
     * Returns whether to preserve SLM Policies of this test. Defaults to not
                List<?> snapshots = (List<?>) entityAsMap(adminClient.performRequest(listRequest)).get("snapshots");
        final Response response = client().performRequest(request);
    private static void updateIndexSettings(String index, Settings settings) throws IOException {
        // EMPTY and THROW are fine here because `.map` doesn't use named x content or deprecation
    /**
        assert adminClient != null;
            conf -> conf.setResponseTimeout(Timeout.ofMilliseconds(Math.toIntExact(socketTimeout.getMillis())))
            builder.setPathPrefix(settings.get(CLIENT_PATH_PREFIX));
import org.apache.hc.client5.http.classic.methods.HttpPost;
    protected static boolean aliasExists(String alias) throws IOException {
                    final PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()
                    logger.debug("wiping snapshot [{}/{}]", repoName, name);
import org.opensearch.Version;
        if (preserveIndicesUponCompletion() == false) {
                nodeVersions.add(Version.fromString(nodeInfo.get("version").toString()));
 * KIND, either express or implied.  See the License for the
import org.apache.hc.core5.http.Header;
        }
            } catch (final IOException e) {
                return isSystemIndexWarning == false;
     */
     * Remove any cluster settings.
        }
                    Integer globalCheckpoint = (Integer) XContentMapValues.extractValue("seq_no.global_checkpoint", copy);
    }
                            public TlsDetails create(final SSLEngine sslEngine) {
    /**
    protected static Version minimumNodeVersion() throws IOException {
        return RestStatus.OK.getStatus() == response.getStatusLine().getStatusCode();
            }
        Request refreshRequest = new Request("POST", "/_refresh");
        return restClientSettings(); // default to the same client settings
    /**
     * A client for the running OpenSearch cluster configured to take test administrative actions like remove all indexes after the test
                Request listRequest = new Request("GET", "/_snapshot/" + repoName + "/_all");
            "Failed to restore snapshot [" + snapshot + "] from repository [" + repository + "]: " + response,
    public static RequestOptions expectVersionSpecificWarnings(Consumer<VersionSensitiveWarningsHandler> expectationsSetter) {
    }
    public void ensurePeerRecoveryRetentionLeasesRenewedAndSynced(String index) throws Exception {
            List<HttpHost> hosts = new ArrayList<>(stringUrls.length);
    private static TreeSet<Version> nodeVersions;
    /**
            Path path = PathUtils.get(keystorePath);
                        "timed out waiting for green state for index ["
    public static Map<String, Object> entityAsMap(Response response) throws IOException {
                }
        expectationsSetter.accept(warningsHandler);
        Request request = new Request("GET", "/" + index + "/_settings");
    @SuppressWarnings("unchecked")
                // Repeatedly delete the snapshots until there aren't any
    /**
    public static void waitForPendingTasks(final RestClient adminClient, final Predicate<String> taskFilter) throws Exception {
        if (preserveTemplatesUponCompletion() == false) {
        logger.debug("wiping snapshot repository [{}]", repoName);
        XContentBuilder clearCommand = JsonXContent.contentBuilder();
        }, 60, TimeUnit.SECONDS);
                    long maxSeqNo = ((Number) XContentMapValues.extractValue("max_seq_no", seqNoStat)).longValue();
                List<?> tasks = (List<?>) entityAsMap(response).get("tasks");
            wipeAllIndices();
        refreshRequest.addParameter("expand_wildcards", "open,hidden");
        boolean foundReplica = false;
        return RestStatus.OK.getStatus() == response.getStatusLine().getStatusCode();
        sort(stillRunning);
            try {
        final Map<String, Object> nodes = ObjectPath.createFromResponse(response).evaluate("nodes");
                // absolute equality required in expected and actual.
            mustClear = true;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksAction;
            expectSoftDeletesWarning(request, name);
                            @Override
    public void initClient() throws IOException {
    }
        }
            options.setWarningsHandler(warnings -> warnings.isEmpty() == false && warnings.equals(expectedWarnings) == false);
    /**
    /**
                listRequest.addParameter("ignore_unavailable", "true");
                return matches == false;
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;
import org.opensearch.client.RequestOptions.Builder;
    }
                assertBusy(() -> {
            }
    protected boolean preserveReposUponCompletion() {
                                return new TlsDetails(sslEngine.getSession(), sslEngine.getApplicationProtocol());
     * Get the client used for test administrative actions. Do not use this while writing a test. Only use it for cleaning up after tests.
    }
                // At this point there should be no snaphots
        }, 30, TimeUnit.SECONDS);
        final Request request = new Request("GET", "_nodes");
     * Returns the minimum node version among all nodes of the cluster
                    final Response clusterStateResponse = client.performRequest(new Request("GET", "/_cluster/state?pretty"));
            );
    public static RequestOptions allowTypesRemovalWarnings() {
    }
    private void ensureGlobalCheckpointSynced(String index) throws Exception {
import javax.net.ssl.SSLContext;
     * checks that the specific index is green. we force a selection of an index as the tests share a cluster and often leave indices
    private static RestClient adminClient;
                }
    }
                // This will cause an error at the end of this method, but do the rest of the cleanup first
import org.apache.hc.core5.reactor.ssl.TlsDetails;
        builder.setStrictDeprecationMode(true);
                 */
        return false;
                final Response response = adminClient.performRequest(request);
                }, 2, TimeUnit.MINUTES);
        if (mapping != null) {
            if (false == preserveSnapshotsUponCompletion() && repoType.equals("fs")) {
        return false;
        assertThat(
                continue;
 * Modifications Copyright OpenSearch Contributors. See
            nodeVersions = null;
        builder.setWarningsHandler(warningsHandler);
        assertThat(XContentMapValues.extractValue("indices." + index + ".total.translog.uncommitted_operations", stats), equalTo(0));
 *
            ensureNoInitializingShards();
                    final TlsStrategy tlsStrategy = ClientTlsStrategyBuilder.create()
     */
    protected void refreshAllIndices() throws IOException {
            }
        final Set<Version> testNodeVersions;
    protected String getTestRestCluster() {
        request.addParameter("timeout", "70s");
        adminClient().performRequest(request);
     * filter is used to filter out outstanding tasks that are expected to be there.
        return false;
 * ownership. Elasticsearch licenses this file to you under
        }
        updateIndexSettings(index, settings.build());
/*
        );
            options.setWarningsHandler(
                        }
    }
    protected static void ensureHealth(RestClient client, String index, Consumer<Request> requestConsumer) throws IOException {
    /**
            equalTo(RestStatus.OK.getStatus())
import org.apache.hc.core5.http.HttpHost;
    }
    }
            if (shard.get("primary") == Boolean.FALSE && targetNode.test((String) XContentMapValues.extractValue("target.name", shard))) {
        List<String> stillRunning = new ArrayList<>(runningTasks);
 */
    public void flush(String index, boolean force) throws IOException {
                        .build();
                "indices." + index + ".shards",
        return client;
import java.security.cert.CertificateException;
                inProgressSnapshots.set(snapshots.get());
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
        flushRequest.addParameter("force", Boolean.toString(force));
    static final Pattern CREATE_INDEX_MULTIPLE_MATCHING_TEMPLATES = Pattern.compile(
        client().performRequest(request);
                throw new IllegalStateException(TRUSTSTORE_PATH + " is provided but not " + TRUSTSTORE_PASSWORD);
     */
    private static Set<String> assertedWarnings = ConcurrentHashMap.newKeySet();
    }
                        message.append('\n').append(task.toString());
                 * the specified task filter.
import javax.net.ssl.SSLEngine;
         */
    public static RequestOptions expectWarningsOnce(String deprecationWarning) {
                adminClient().performRequest(new Request("DELETE", "_index_template/*"));
     * waits until all shard initialization is completed. This is a handy alternative to ensureGreen as it relates to all shards
                builder.setHttpClientConfigCallback(httpClientBuilder -> {
    /**
    static final Pattern PUT_TEMPLATE_MULTIPLE_MATCHING_TEMPLATES = Pattern.compile(
     * @param index index to test for
            } else {
            "Failed to create snapshot [" + snapshot + "] in repository [" + repository + "]: " + response,
                    snapshots.set(wipeSnapshots());
            if (warnings.size() > 0) {
                }
    /**
        });
                        message -> CREATE_INDEX_MULTIPLE_MATCHING_TEMPLATES.matcher(message).matches()
        createIndex(name, settings, mapping, null);
         * is formed from nodes all running the exact same version as the client.
import org.opensearch.core.xcontent.DeprecationHandler;
     * Defaults to {@code false}. Override this method if indices should be preserved after the test,
        String endpoint = "/_alias";
        if (keystorePath != null) {
                    for (Map<String, ?> retentionLease : retentionLeases) {
import java.security.KeyStore;
                throw new AssertionError("error getting active tasks list", e);
    protected Map<String, Object> getIndexSettingsAsMap(String index) throws IOException {
        assertThat(response.getStatusLine().getStatusCode(), equalTo(RestStatus.OK.getStatus()));
        refreshRequest.setOptions(requestOptions);
     */
     * Wait for outstanding tasks to complete. The specified admin client is used to check the outstanding tasks and this is done using
        request.addParameter("wait_for_completion", Boolean.toString(waitForCompletion));
/*
                for (Map<String, ?> copy : shard) {
                return false == requiredSameVersionClusterWarnings.equals(actual);
        }
                KeyStore keyStore = KeyStore.getInstance(KeyStoreUtils.inferStoreType(keystorePath));
import java.util.function.Consumer;
                    response.getEntity().getContent()
     **/
                }
        requestConsumer.accept(request);
        "^index template \\[(.+)\\] has index patterns "
                if (details == null) {
                    return false;
    protected static boolean indexExists(String index) throws IOException {
        });
 * software distributed under the License is distributed on an
    }
        builder.setRequestConfigCallback(
            Map<?, ?> response = entityAsMap(adminClient.performRequest(new Request("GET", "_nodes/plugins")));
            return;
                        BufferedReader responseReader = new BufferedReader(
import org.opensearch.common.xcontent.XContentHelper;
            adminClient().performRequest(new Request("DELETE", "_template/*"));
        if (waitForAllSnapshotsWiped()) {
                Map<?, ?> nodeInfo = (Map<?, ?>) node.getValue();
         * Adds to the set of warnings that are all required in responses if the cluster
                    }
     * @return true if cluster settings should be preserved and otherwise false
 * Licensed to Elasticsearch under one or more contributor
    }
     * Clean up after the test case.
                .map(shard -> (Map<?, ?>) XContentMapValues.extractValue("seq_no", shard))
                    adminClient().performRequest(new Request("DELETE", "/_snapshot/" + repoName + "/" + name));
                    allSystemIndexWarnings = false;
                )
        Request request = new Request("PUT", "/" + index + "/_settings");
                        int activeTasks = 0;
        Set<String> runningTasks = runningTasks(adminClient().performRequest(new Request("GET", "/_tasks")));
        );
     * A client for the running OpenSearch cluster
     *
    /**
                    assertThat(XContentMapValues.extractValue("seq_no.max_seq_no", copy), equalTo(globalCheckpoint));
     */
     * @return Map of repository name to list of snapshots found in unfinished state
        // Ignore the task list API - it doesn't count against us
                        "retention_leases.leases",
                    e.addSuppressed(inner);
        } catch (ResponseException e) {
        });
    protected static void registerRepository(String repository, String type, boolean verify, Settings settings) throws IOException {
            IOUtils.close(client, adminClient);
                });
                    assertThat(shardStats.toString(), globalCheckpoint, equalTo(maxSeqNo));
     */
                    List<String> existingLeaseIds = retentionLeases.stream()
     * {@link OpenSearchTestCase#assertBusy(CheckedRunnable)} to give a chance to any outstanding tasks to complete.
     */
    }
    public static final String CLIENT_PATH_PREFIX = "client.path.prefix";
        configureClient(builder, settings);
import org.apache.hc.core5.http.io.entity.EntityUtils;
        if (false == Strings.isEmpty(alias)) {
    protected static Map<String, Object> getAsMap(final String endpoint) throws IOException {
        client().performRequest(request);
                runningTasks.add(task.get("action").toString());
                throw new IllegalStateException(TRUSTSTORE_PATH + " is set but points to a non-existing file");
    protected static void openIndex(String index) throws IOException {
    }
        return new HttpHost(getProtocol(), host, port);
                .createParser(
    }
                    return true;
                return false;
     * Convert the entity from a {@link Response} into a list of maps.
    }
                } else {
        assertNotNull(minVersion);
            Map<?, ?> stats = entityAsMap(client().performRequest(new Request("GET", index + "/_stats?level=shards")));
        }
                        .collect(Collectors.toList());
        try {
        ensureHealth("", requestConsumer);
    }
        logger.info("There are still tasks running after this test that might break subsequent tests {}.", stillRunning);
                } else if (warnings.size() > 1) {
     * being tested.
                throw new RuntimeException("Error setting up ssl", e);
    }
import java.io.InputStream;
                        .map(lease -> (String) lease.get("id"))
    protected static RestClient adminClient() {
            response.getEntity().getContent(),
            }
package org.opensearch.test.rest;
        request.setJsonEntity(Strings.toString(MediaTypeRegistry.JSON, settings));
            if (minVersion == null || minVersion.after(nodeVersion)) {
        logger.info("index {} recovery stats {}", indexName, shards);
    protected static void updateIndexSettings(String index, Settings.Builder settings) throws IOException {
    }
            }
     * Used to obtain settings for the REST client that is used to send REST requests.
     * other tests.
                Set<String> actual = new HashSet<>(warnings);
    protected boolean preserveSnapshotsUponCompletion() {
            Request request = new Request("PUT", "/_cluster/settings");
        Settings.Builder builder = Settings.builder();
            }
        final int responseStatusCode = response.getStatusLine().getStatusCode();
        List<Map<String, ?>> shards = (List<Map<String, ?>>) XContentMapValues.extractValue(indexName + ".shards", recoveries);
                        && false == requiredSameVersionClusterWarnings.contains(actualWarning)) {
import org.opensearch.core.rest.RestStatus;
    protected static void ensureHealth(String index, Consumer<Request> requestConsumer) throws IOException {
import static java.util.Collections.unmodifiableList;
import org.opensearch.core.xcontent.NamedXContentRegistry;
            } catch (ResponseException ex) {
        request.addParameter("filter_path", "nodes.*.version");
import java.nio.charset.StandardCharsets;
                        .collect(Collectors.toList());
import org.opensearch.client.RestClient;
        RequestOptions.Builder options = request.getOptions().toBuilder();
    }
import static org.hamcrest.Matchers.anEmptyMap;
        );
        });
     * Returns whether to preserve the indices created during this test on completion of this test.
        final Map<String, Object> responseAsMap = responseAsMap(response);
            clearCommand.startObject(type);
                // once detailed recoveries works, remove this if.
                    long reusedFiles = ((Number) XContentMapValues.extractValue("index.files.reused", shard)).longValue();
        return responseEntity;
    }
 *
                    Map<?, ?> snapshotInfo = (Map<?, ?>) snapshot;
        for (Map.Entry<String, Object> node : nodes.entrySet()) {
            logIfThereAreRunningTasks();
import org.opensearch.core.xcontent.XContentParser;
            Map<?, ?> nodes = (Map<?, ?>) response.get("nodes");
    }
    /**
    protected final List<HttpHost> getClusterHosts() {
import org.opensearch.snapshots.SnapshotState;
        }
        final Builder requestOptions = RequestOptions.DEFAULT.toBuilder();
        for (Map.Entry<String, ?> repo : entityAsMap(adminClient.performRequest(new Request("GET", "/_snapshot/_all"))).entrySet()) {
                    DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        // EMPTY and THROW are fine here because `.map` doesn't use named x content or deprecation
    }
     * preserving them. Only runs at all if xpack is installed on the cluster
    }
                            }
    @After
     * Logs a message if there are still running tasks. The reasoning is that any tasks still running are state the is trying to bleed into
     * @return true if the state of the cluster should be preserved
     * @param deprecationWarning expected warning
        request.addParameter("verify", Boolean.toString(verify));
    }
                        .map(shr -> (String) XContentMapValues.extractValue("routing.node", shr))
                }
        clearCommand.endObject();
    }
                        })
                // All other repo types we really don't have a chance of being able to iterate properly, sadly.
                warnings -> warnings.isEmpty() == false
            try {
     * test. Defaults to not preserving snapshots. Only works for {@code fs} repositories.
            assert nodeVersions == null;
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
    }
     * in the cluster and doesn't require to know how many nodes/replica there are.
    protected Settings restAdminSettings() {
     * with the assumption that some other process or test will clean up the indices afterward.
            if (e.getResponse().getStatusLine().getStatusCode() == HttpStatus.SC_REQUEST_TIMEOUT) {
    protected boolean preserveClusterSettings() {
                        // Something other than a types removal message - return true
     * deprecated request. The options will ensure that the given warnings are returned if all nodes are on
 * compatible open source license.
                final Request request = new Request("GET", "/_cat/tasks");
     * Peer recovery retention leases are renewed and synced to replicas periodically (every 30 seconds). This ensures
        Builder builder = RequestOptions.DEFAULT.toBuilder();
                }
                adminClient().performRequest(new Request("DELETE", "_component_template/*"));
 */
                try (InputStream is = Files.newInputStream(path)) {
            equalTo(RestStatus.OK.getStatus())
                    try (
            XContentParser parser = mediaType.xContent()
    protected boolean waitForAllSnapshotsWiped() {
            // 404 here just means we had no indexes
        }
import java.security.NoSuchAlgorithmException;
     */
    }
import java.nio.file.Files;
         */
            Map<?, ?> repoSpec = (Map<?, ?>) repo.getValue();
                if (portSeparator < 0) {
    public static void waitForPendingTasks(final RestClient adminClient) throws Exception {
     * @param taskFilter  predicate used to filter tasks that are expected to be there
        final Response response = adminClient().performRequest(request);
        return responseAsMap(response);
                                continue;
    protected boolean preserveTemplatesUponCompletion() {
            request.addParameter("timeout", "70s");
            final Request deleteRequest = new Request("DELETE", "*");
    }
                    assertThat("must reuse all files, recoveries [" + recoveries + "]", totalFiles, equalTo(reusedFiles));
        return clusterHosts;
    protected static Map<String, Object> getIndexSettings(String index) throws IOException {
        assert nodeVersions != null;
        RestClientBuilder builder = RestClient.builder(hosts);
    protected static void useIgnoreMultipleMatchingTemplatesWarningsHandler(Request request) throws IOException {
    public final void cleanUpCluster() throws Exception {
import java.util.Arrays;
        }
                            tasksListString.append('\n');
            try {
            } catch (KeyStoreException | NoSuchAlgorithmException | KeyManagementException | CertificateException e) {
            wipeClusterSettings();
    /**
 * not use this file except in compliance with the License.
                            + "cluster state ["
        createIndex(name, settings, null);
        }
    }
        assertedWarnings.add(deprecationWarning);
     * Wait for outstanding tasks to complete. The specified admin client is used to check the outstanding tasks and this is done using
            // wipe indices
     * @param adminClient the admin client
            }
            throw e;
import org.opensearch.client.ResponseException;
        /*
                    throw new IllegalArgumentException("Illegal cluster url [" + stringUrl + "]");
     * @throws Exception if an exception is thrown while checking the outstanding tasks
            assertFalse("Node versions running in the cluster are missing", testNodeVersions.isEmpty());
                }
                    NamedXContentRegistry.EMPTY,
import org.junit.After;
                    break;
     */
        assertThat(
        try (
        assertThat(message + ": response is not acknowledged", acknowledged, equalTo(Boolean.TRUE));
                        copy
            String repoType = (String) repoSpec.get("type");
        MediaType mediaType = MediaType.fromMediaType(response.getEntity().getContentType());
     * {@link OpenSearchTestCase#assertBusy(CheckedRunnable)} to give a chance to any outstanding tasks to complete. The specified
    @Deprecated
        }
                Response response = adminClient().performRequest(new Request("GET", "/_cluster/pending_tasks"));
    protected String getProtocol() {
        if (nodeVersions.stream().allMatch(version -> version.onOrAfter(Version.V_2_0_0))) {
    public static final String TRUSTSTORE_PATH = "truststore.path";
        assertBusy(() -> {
                minVersion = nodeVersion;
    protected boolean preserveDataStreamsUponCompletion() {
     */
            adminClient().performRequest(request);
                String host = stringUrl.substring(0, portSeparator);
        request.setJsonEntity(Strings.toString(MediaTypeRegistry.JSON, new PutRepositoryRequest(repository).type(type).settings(settings)));
     * and {@link #preserveSnapshotsUponCompletion()}.
        if (settings.getAsBoolean(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true) == false) {
import org.junit.Before;
                    );
                    StringBuilder message = new StringBuilder("there are still running tasks:");
    /**
        } finally {
    /**
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
        request.setJsonEntity(entity);
import java.util.TreeSet;
        for (Map<String, ?> shard : shards) {
    }
        try (
        Builder builder = RequestOptions.DEFAULT.toBuilder();
    }
     * (for example, when testing rolling upgrades).
         * tasks.
        final Request request = new Request(HttpPut.METHOD_NAME, "_snapshot/" + repository);
            logger.info("initializing REST clients against {}", clusterHosts);
        final Map<String, List<Map<?, ?>>> inProgressSnapshots = new HashMap<>();
    }
            requiredSameVersionClusterWarnings.addAll(Arrays.asList(requiredWarnings));
    protected static Map<String, Object> responseAsMap(Response response) throws IOException {
            "Creating indices with soft-deletes disabled is deprecated and will be removed in future OpenSearch versions. "
    }
 * Superclass for tests that interact with an external test cluster using OpenSearch's {@link RestClient}.
    }
    protected static void assertOK(Response response) {
     */
                Response resp = client().performRequest(request);
        final List<String> opensearchExpectedWarnings = Collections.singletonList(
                Map<String, Object> task = (Map<String, Object>) taskAndName.getValue();
                if (!warning.startsWith("this request accesses system indices:")) {
            }
        assertBusy(() -> {
        // A synced-flush request considers the global checkpoint sync as an going operation because it acquires a shard permit.
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
    /**
            if (!Files.exists(path)) {
        public void compatible(String... allowedWarnings) {
import java.util.Collections;
        assert clusterHosts != null;
            @SuppressWarnings("unchecked")
     */
    }
                + "Please do not specify value for setting [index.soft_deletes.enabled] of index ["
     * Construct an HttpHost from the given host and port
    protected static void expectSoftDeletesWarning(Request request, String indexName) {
        /**
        // wipe data streams before indices so that the backing indices for data streams are handled properly
        Request request = new Request("PUT", "/" + name);
import org.hamcrest.Matchers;
                throw e;
    /**
     */
    }
                boolean matches = warnings.stream()
        }
     * @deprecated this method is only required while we deprecate types and can be removed in 8.0
        options.setWarningsHandler(warnings -> {
        return builder.build();
                if (warnings.size() == 0) {
    public static void ensureGreen(String index) throws IOException {
        }, 30L, TimeUnit.SECONDS);
            );
     * the snapshots intact in the repository.
        requestOptions.setWarningsHandler(warnings -> warnings.equals(opensearchExpectedWarnings) == false);
}
                int port = Integer.valueOf(stringUrl.substring(portSeparator + 1));
     * Returns whether to preserve the snapshots in repositories on completion of this
            for (Map.Entry<?, ?> node : nodes.entrySet()) {
     * Get the list of hosts in the cluster.
            client.performRequest(request);
    // This set will contain the warnings already asserted since we are eliminating logging duplicate warnings.
            clusterHosts = unmodifiableList(hosts);
                    Map<String, Object> result = ObjectPath.createFromResponse(resp).evaluate("_shards");
    public static RequestOptions expectWarnings(String... warnings) {
        }
         * This isn't a higher level log or outright failure because some of these tasks are run by the cluster in the background. If we
        // 8.0 kept in warning message for legacy purposes TODO: changge to 3.0
        MediaType mediaType = MediaType.fromMediaType(response.getEntity().getContentType());
                            new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8)
                    if (false == allowedWarnings.contains(actualWarning)
import org.apache.hc.core5.http.message.BasicHeader;
                    assertThat(shardStats.toString(), localCheckpoint, equalTo(maxSeqNo));
     */
     * Helper class to check warnings in REST responses with sensitivity to versions
     * @return whether or not to preserve templates
        request.addParameter("wait_for_completion", Boolean.toString(waitForCompletion));
import org.opensearch.client.RestClientBuilder;
        );
        final String socketTimeoutString = settings.get(CLIENT_SOCKET_TIMEOUT);
            return testNodeVersions.size() == 1 && testNodeVersions.iterator().next().equals(Version.CURRENT);
        final Response response = client().performRequest(request);
    /**
    }
            allowSystemIndexAccessWarningOptions.setWarningsHandler(warnings -> {
                });
        final Request request = new Request("POST", indexName + "/_flush/synced");
    protected static void createSnapshot(String repository, String snapshot, boolean waitForCompletion) throws IOException {
     * This is useful if the data directory and indices need to be preserved between test runs
            String[] stringUrls = cluster.split(",");
                    if (SnapshotState.valueOf((String) snapshotInfo.get("state")).completed() == false) {
    }
import org.opensearch.common.xcontent.json.JsonXContent;
     */
        Response response = client().performRequest(new Request("HEAD", "/_alias/" + alias));
                + indexName
    /**
            }
                    assertThat("not every active copy has established its PPRL", expectedLeaseIds, everyItem(in(existingLeaseIds)));
            }
                    ) {
        }
                /*
     */
                    List<Map<String, ?>> retentionLeases = (List<Map<String, ?>>) XContentMapValues.extractValue(
    }
        return false;
        MediaType entityContentType = MediaType.fromMediaType(response.getEntity().getContentType());
            inProgressSnapshots.set(wipeSnapshots());
            @SuppressWarnings("unchecked")
    }
    protected static boolean aliasExists(String index, String alias) throws IOException {
        public void current(String... requiredWarnings) {
        Map<String, Object> getAliasResponse = getAsMap(endpoint);
 *
     *
                        final StringBuilder tasksListString = new StringBuilder();
     * have been deleted.
            // that doesn't support data streams so it's safe to ignore
    }
         * could determine that some tasks are run by the user we'd fail the tests if those tasks were running and ignore any background
                            + EntityUtils.toString(clusterStateResponse.getEntity())
     */
                    NamedXContentRegistry.EMPTY,
                final SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(keyStore, null).build();
        final List<String> warningMessage = Arrays.asList(
    protected static RestClient client() {
        }
            try {
        String keystorePath = settings.get(TRUSTSTORE_PATH);
            }
 */
     * Controls whether or not to preserve cluster settings upon completion of the test. The default implementation is to remove all cluster
    /**
                    assertThat(details, Matchers.empty());
    /**
    protected static void ensureNoInitializingShards() throws IOException {
                    assertThat(result.get("failed"), equalTo(0));
            entity += ",\"aliases\": {" + aliases + "}";
     * Returns whether to preserve the state of the cluster upon completion of this test. Defaults to false. If true, overrides the value of
     */
                    assertNotNull(retentionLeases);
            Map<String, List<Map<String, ?>>> shards = (Map<String, List<Map<String, ?>>>) XContentMapValues.extractValue(
            logger.debug("Clearing all templates");
        client().performRequest(request);
    private void logIfThereAreRunningTasks() throws IOException {
    public static final String TRUSTSTORE_PASSWORD = "truststore.password";
    @SuppressWarnings("unchecked")
     */
                        )
    protected static void ensureHealth(Consumer<Request> requestConsumer) throws IOException {
    }
                    List<String> expectedLeaseIds = shard.stream()
import java.nio.file.Path;
            final String keystorePass = settings.get(TRUSTSTORE_PASSWORD);
     */
        return builder.build();
    }
        assertBusy(() -> {
        request.setOptions(options);
            wipeCluster();
                // We hit a version of ES that doesn't support index templates v2 yet, so it's safe to ignore
     * Returns whether to wait to make absolutely certain that all snapshots
            endpoint = index + endpoint;
            XContentParser parser = mediaType.xContent()
                    + "to which to send REST requests"
        assertThat(
                    long globalCheckpoint = ((Number) XContentMapValues.extractValue("global_checkpoint", seqNoStat)).longValue();
            adminClient = null;
        for (Map.Entry<String, Object> node : nodes.entrySet()) {
        );
import java.security.KeyStoreException;
    protected RestClient buildClient(Settings settings, HttpHost[] hosts) throws IOException {
        Response response = client().performRequest(request);
    protected static void restoreSnapshot(String repository, String snapshot, boolean waitForCompletion) throws IOException {
     */
        "^index \\[(.+)\\] matches multiple legacy " + "templates \\[(.+)\\], composable templates will only match a single template$"
import static org.hamcrest.Matchers.everyItem;
    }
        return minVersion;
                int portSeparator = stringUrl.lastIndexOf(':');
     *
        try {
     * Returns whether to preserve the repositories on completion of this test.
    /**
    }
            for (Object key : settings.keySet()) {
                .forEach(seqNoStat -> {
    }
        waitForPendingTasks(adminClient, taskName -> false);
    private static RestClient client;
        try {
 * SPDX-License-Identifier: Apache-2.0
        /**
            deleteRequest.addParameter("expand_wildcards", "open,closed,hidden");
            AtomicReference<Map<String, List<Map<?, ?>>>> snapshots = new AtomicReference<>();
     *
    }
    /**
 * You may obtain a copy of the License at
         * @param allowedWarnings optional warnings that will be ignored if received
            }
        }
        if (assertedWarnings.contains(deprecationWarning)) {
            if (warnings.isEmpty()) {
                    keyStore.load(is, keystorePass.toCharArray());
            endpoint = endpoint + "/" + alias;
     * Filters out already asserted warnings and calls expectWarnings method.
     * {@link Version#CURRENT} and will allow (but not require) the warnings if any node is running an older version.
import org.opensearch.client.RequestOptions;
        final Request request = new Request(HttpPost.METHOD_NAME, "_snapshot/" + repository + '/' + snapshot + "/_restore");
        );
    /**
                        if (((String) retentionLease.get("id")).startsWith("peer_recovery/")) {
        Map<String, Object> nodes = (Map<String, Object>) entityAsMap(response).get("nodes");
                clearCommand.field(key + ".*").nullValue();
 * specific language governing permissions and limitations
                "Must specify [tests.rest.cluster] system property with a comma delimited list of [host:port] "
                }
         * @param requiredWarnings a set of required warnings
import java.util.concurrent.TimeUnit;
                // We don't know exactly which indices we're cleaning up in advance, so just accept all system index access warnings.
            }
            builder.put(CLIENT_PATH_PREFIX, System.getProperty("tests.rest.client_path_prefix"));
        }
        builder.setDefaultHeaders(defaultHeaders);
import java.util.concurrent.ConcurrentHashMap;
            } catch (ResponseException e) {
        entity += "}";
        Map<String, Object> recoveries = entityAsMap(client().performRequest(new Request("GET", indexName + "/_recovery?detailed=true")));
            if (settings.isEmpty()) {
                        // See https://issues.apache.org/jira/browse/HTTPCLIENT-2219
     * completes
                        .setTlsDetailsFactory(new Factory<SSLEngine, TlsDetails>() {
     * that we have renewed every PRRL to the global checkpoint of the corresponding copy and properly synced to all copies.
            Map<String, Object> stats = entityAsMap(client().performRequest(new Request("GET", index + "/_stats?level=shards")));
            request.setJsonEntity(clearCommand.toString());
    }
        @Override
import org.opensearch.common.util.io.IOUtils;
import java.util.HashMap;
                )
        }, 60, TimeUnit.SECONDS);
        // We have to spin synced-flush requests here because we fire the global checkpoint sync for the last write operation.
        if (mustClear) {
            Map<String, Object> nodeTasks = (Map<String, Object>) nodeInfo.get("tasks");
                for (Object snapshot : snapshots) {
        return false;
            message + ": expecting response code [200] but got [" + responseStatusCode + ']',
                            final String taskName = line.split("\\s+")[0];
                    long totalFiles = ((Number) XContentMapValues.extractValue("index.files.total", shard)).longValue();
import org.opensearch.common.xcontent.support.XContentMapValues;
    public static class VersionSensitiveWarningsHandler implements WarningsHandler {
import org.opensearch.index.IndexSettings;
import org.opensearch.core.xcontent.MediaType;
import java.util.regex.Pattern;
            if (e.getResponse().getStatusLine().getStatusCode() != 404) {
            }
            Map<String, Object> nodeInfo = (Map<String, Object>) node.getValue();
            RequestOptions.Builder allowSystemIndexAccessWarningOptions = RequestOptions.DEFAULT.toBuilder();
            }
        }
    /**
/**
    private void waitForClusterStateUpdatesToFinish() throws Exception {
    }
import java.util.List;
                    && warnings.equals(warningMessage) == false
        Request request = new Request("DELETE", "/" + name);
            for (String warning : warnings) {
    }
        }
        public boolean warningsShouldFailRequest(List<String> warnings) {
                            + "] "
    @SuppressWarnings("unchecked")
     * @throws Exception if an exception is thrown while checking the outstanding tasks
                stats
     * @param warnings The expected warnings.
        Response response = client().performRequest(new Request("GET", endpoint));
        Set<String> allowedWarnings = new HashSet<>();
        request.setOptions(requestOptions);
                hosts.add(buildHttpHost(host, port));
    @SuppressWarnings("unchecked")
                    long localCheckpoint = ((Number) XContentMapValues.extractValue("local_checkpoint", seqNoStat)).longValue();
                    response.getEntity().getContent()
                .filter(Objects::nonNull)
        VersionSensitiveWarningsHandler warningsHandler = new VersionSensitiveWarningsHandler(nodeVersions);
        requestOptions.setWarningsHandler(warnings -> {
     */
     * used in the target cluster.
            if (warnings.isEmpty()) {
        }
    protected static void configureClient(RestClientBuilder builder, Settings settings) throws IOException {
    protected static Map<String, Object> getAlias(final String index, final String alias) throws IOException {
 */
    protected boolean preserveSLMPoliciesUponCompletion() {
         */
        public VersionSensitiveWarningsHandler(Set<Version> nodeVersions) {
            }
    }
                    );
            return XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), is, true);
import java.io.BufferedReader;
        Response response = client().performRequest(new Request("HEAD", "/" + index));
import org.apache.hc.core5.http.HttpStatus;
        assertThat(response.getStatusLine().getStatusCode(), equalTo(RestStatus.OK.getStatus()));
        }
            }
    protected static void deleteIndex(String name) throws IOException {
     * Creates RequestOptions designed to ignore [types removal] warnings but nothing else
        }
                    String name = (String) snapshotInfo.get("snapshot");
     */
                            activeTasks++;
        for (Map.Entry<?, ?> entry : getResponse.entrySet()) {
    }
                    );
            final Response response = adminClient().performRequest(deleteRequest);
    /**
        // ensure the global checkpoint is synced; otherwise we might trim the commit with syncId
                    @SuppressWarnings("unchecked")
        }
        client().performRequest(refreshRequest);
            String cluster = getTestRestCluster();
                inProgressSnapshots.set(snapshots.get());
    protected void deleteRepository(String repoName) throws IOException {
            Map<?, ?> settings = (Map<?, ?>) entry.getValue();
            }
            CLIENT_SOCKET_TIMEOUT
public abstract class OpenSearchRestTestCase extends OpenSearchTestCase {
     */
        if (client == null) {
import org.opensearch.core.common.Strings;
                    }
     */
            if (preserveReposUponCompletion() == false) {
     * in an non green state
    );
import org.opensearch.test.rest.yaml.ObjectPath;
        return (Map<String, Object>) ((Map<String, Object>) indexSettings.get(index)).get("settings");
            false
    protected static void createIndex(String name, Settings settings) throws IOException {
                    throw new AssertionError(ex); // cause assert busy to retry
    }
import org.opensearch.common.unit.TimeValue;
import org.opensearch.test.OpenSearchTestCase;
                        }
        }
        Version minVersion = null;
            }
        if (runningTasks.isEmpty()) {
        return false;
    private static void assertAcked(String message, Response response) throws IOException {
        return runningTasks;
        ensureHealth(client(), index, requestConsumer);
            int statusCode = e.getResponse().getStatusLine().getStatusCode();
 * Unless required by applicable law or agreed to in writing,
            }
        if (cluster == null) {
                        assertEquals(activeTasks + " active tasks found:\n" + tasksListString, 0, activeTasks);
    }
        Map<String, Object> stats = entityAsMap(client().performRequest(new Request("GET", index + "/_stats?level=shards")));
     */
                if (retryOnConflict) {
        assert client != null;
    protected static void wipeAllIndices() throws IOException {
     * Override this to switch to testing https.
    private Set<String> runningTasks(Response response) throws IOException {
    protected void syncedFlush(String indexName, boolean retryOnConflict) throws Exception {
 * under the License.
        Map<String, Object> indexSettings = getIndexSettings(index);
            entityContentType.xContent(),
        final List<String> expectedWarnings = Arrays.asList(
            throw new RuntimeException(
import org.opensearch.client.WarningsHandler;
                    && warning.contains("but in a future major version, direct access to system indices will be prevented by default");
                final boolean isSystemIndexWarning = warning.contains("this request accesses system indices")
    }
     * {@link #preserveSnapshotsUponCompletion()}.
                            }
     * templates.
    @AfterClass
import java.util.Set;
        assertThat(XContentMapValues.extractValue("indices." + index + ".total.translog.operations", stats), equalTo(0));
            return RequestOptions.DEFAULT;
        Response response = client().performRequest(new Request("POST", "/" + index + "/_open"));
        for (Map.Entry<String, String> entry : headers.entrySet()) {
        final Builder options = RequestOptions.DEFAULT.toBuilder();
                if (retryOnConflict) {
                fail("cannot get cluster's pending tasks: " + e.getMessage());
        );
                    fail(message.toString());
        ensureHealth(index, (request) -> {
        assertThat(response.getStatusLine().getStatusCode(), anyOf(equalTo(200), equalTo(201)));
        Set<String> runningTasks = new HashSet<>();
     */
import java.util.ArrayList;
        String entity = "{\"settings\": " + Strings.toString(MediaTypeRegistry.JSON, settings);
    /**
import org.opensearch.common.settings.Settings;
    // This ensures that no matter in what order the tests run, the warning is asserted once.
        runningTasks.remove(ListTasksAction.NAME + "[n]");
        if (settings.hasValue(CLIENT_PATH_PREFIX)) {
            String type = entry.getKey().toString();
        return inProgressSnapshots;
                        .map(ReplicationTracker::getPeerRecoveryRetentionLeaseId)
    }
import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder;
                    assertThat(snapshots.get(), anEmptyMap());
            for (String stringUrl : stringUrls) {
        }
 * this work for additional information regarding copyright
                    logger.info("total [{}] reused [{}]", totalFiles, reusedFiles);
    @Before
        boolean mustClear = false;
    }
import java.io.IOException;
    }
import java.security.KeyManagementException;
                            assertThat(retentionLease.get("retaining_seq_no"), equalTo(globalCheckpoint + 1));
                assertThat(ex.getResponse().getStatusLine(), equalTo(HttpStatus.SC_CONFLICT));
                    && warnings.equals(expectedWarnings) == false
                 * Check to see if there are outstanding tasks; we exclude the list task itself, and any expected outstanding tasks using
    public static List<Object> entityAsList(Response response) throws IOException {
        return false;
                List<?> details = (List<?>) XContentMapValues.extractValue("index.files.details", shard);
    public static final String CLIENT_SOCKET_TIMEOUT = "client.socket.timeout";
import org.opensearch.client.Response;
        });
                        return true;
     * Asserts that replicas on nodes satisfying the {@code targetNode} should have perform operation-based recoveries.
    }
            return !allSystemIndexWarnings;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
            );
            try {
                    DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
import org.opensearch.client.Request;
                return false;
        final Response response = client().performRequest(request);
            adminClient().performRequest(new Request("DELETE", "_data_stream/*"));
                    .anyMatch(
import org.apache.hc.client5.http.classic.methods.HttpPut;
        logger.info("flushing index {} force={}", index, force);
        return false;
                request.addParameter("detailed", "true");
                        .setTlsStrategy(tlsStrategy)
            deleteRequest.setOptions(allowSystemIndexAccessWarningOptions);
     * Wipe fs snapshots we created one by one and all repositories so that the next test can create the repositories fresh and they'll
    }
            try (InputStream is = response.getEntity().getContent()) {
        }
                return false;
        request.setOptions(options);
        assertBusy(() -> {
        } else {
                final String warning = warnings.get(0);
        }
        }
     * Determines if data streams are preserved upon completion of this test. The default implementation wipes data streams.
                    for (Object task : tasks) {
     *
            client = null;
        }
     */
        Boolean acknowledged = (Boolean) XContentMapValues.extractValue(responseAsMap, "acknowledged");
        // wipe cluster settings
        if (preserveClusterUponCompletion() == false) {
            assert adminClient == null;
            + "\\[(.+)\\] matching patterns from existing older templates \\[(.+)\\] with patterns \\((.+)\\); this template \\[(.+)\\] will "
        try (InputStream is = response.getEntity().getContent()) {
    }
        Map<String, Object> responseEntity = XContentHelper.convertToMap(
            response.getStatusLine().getStatusCode(),
            boolean allSystemIndexWarnings = true;
            }
    /**
import java.io.InputStreamReader;
     * Defaults to not preserving repos. See also
            }
            assert clusterHosts == null;
    }
            client = buildClient(restClientSettings(), clusterHosts.toArray(new HttpHost[0]));
        adminClient().performRequest(new Request("DELETE", "_snapshot/" + repoName));
import java.util.function.Predicate;
            try {
     * settings.
            wipeDataStreams();
            Version nodeVersion = Version.fromString((String) ((Map<String, Object>) node.getValue()).get("version"));
            if (isExclusivelyTargetingCurrentVersionCluster()) {
                return false;
        int i = 0;
                foundReplica = true;
/*
                }
                + "]."
        return RestStatus.OK.getStatus() == response.getStatusLine().getStatusCode();
            request.addParameter("level", "shards");
        flushRequest.addParameter("wait_if_ongoing", "true");
            this.allowedWarnings.addAll(Arrays.asList(allowedWarnings));
        Response response = client().performRequest(new Request("POST", "/" + index + "/_close"));
        Set<String> requiredSameVersionClusterWarnings = new HashSet<>();
    /**
                }
            public boolean warningsShouldFailRequest(List<String> warnings) {
        clearCommand.startObject();
    protected static void createIndex(String name, Settings settings, String mapping, String aliases) throws IOException {
    @SuppressWarnings("unchecked")
                        .build();
import static java.util.Collections.sort;
        assertThat("Found in progress snapshots [" + inProgressSnapshots.get() + "].", inProgressSnapshots.get(), anEmptyMap());
    }
        assertOK(client().performRequest(flushRequest));
            String repoName = repo.getKey();
                    return httpClientBuilder.setConnectionManager(connectionManager);
        // Allow system index deprecation warnings
        return expectVersionSpecificWarnings(consumer -> consumer.current(warnings));
    protected Settings restClientSettings() {
                    assertNotNull(globalCheckpoint);
        final Builder requestOptions = RequestOptions.DEFAULT.toBuilder();
                            || PUT_TEMPLATE_MULTIPLE_MATCHING_TEMPLATES.matcher(message).matches()
    /**
     * @param adminClient the admin client
    }
     * Creates request options designed to be used when making a call that can return warnings, for example a
                    if (warning.startsWith("[types removal]") == false) {
            "Synced flush is deprecated and will be removed in 3.0. Use flush at _/flush or /{index}/_flush instead."
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
     */
     */
import org.opensearch.test.KeyStoreUtils;
import org.apache.hc.core5.ssl.SSLContexts;
        builder.setWarningsHandler(new WarningsHandler() {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentBuilder;
            }
import org.apache.hc.core5.util.Timeout;
        assertNotNull(responseEntity);
                } catch (Exception inner) {
            waitForClusterStateUpdatesToFinish();
        final Request request = new Request(HttpPut.METHOD_NAME, "_snapshot/" + repository + '/' + snapshot);
