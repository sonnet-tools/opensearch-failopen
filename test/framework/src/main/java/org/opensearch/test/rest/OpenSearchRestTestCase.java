 * The OpenSearch Contributors require contributions made to  
import org.junit.After;
        return "http";  
                }  
            }
    protected static boolean indexExists(String index) throws IOException {
        String keystorePath = settings.get(TRUSTSTORE_PATH);
            + "take precedence during new index creation$"  
import org.opensearch.common.xcontent.support.XContentMapValues;  
                try {
        Set<String> runningTasks = runningTasks(adminClient().performRequest(new Request("GET", "/_tasks")));
        }  
            entity += ",\"aliases\": {" + aliases + "}";
            } catch (ResponseException ex) {  
    protected static void createIndex(String name, Settings settings, String mapping, String aliases) throws IOException {  
    private void ensureGlobalCheckpointSynced(String index) throws Exception {  
     * {@link OpenSearchTestCase#assertBusy(CheckedRunnable)} to give a chance to any outstanding tasks to complete. The specified
            }  
import org.opensearch.core.xcontent.XContentBuilder;
    protected static Map<String, Object> responseAsMap(Response response) throws IOException {  
            }  
                        // See https://issues.apache.org/jira/browse/HTTPCLIENT-2219  
     */
     * Returns whether to preserve the repositories on completion of this test.
    /**  
            );  
    /**
            }
                + "]."
            Version nodeVersion = Version.fromString((String) ((Map<String, Object>) node.getValue()).get("version"));
                foundReplica = true;
        return responseEntity;
 * this file be licensed under the Apache-2.0 license or a
                            }
        Response response = client().performRequest(new Request("HEAD", "/_alias/" + alias));  
                        .setTlsStrategy(tlsStrategy)
            request.setJsonEntity(clearCommand.toString());
        assertThat(
            String cluster = getTestRestCluster();
        assert client != null;  
            } else {  
        request.addParameter("timeout", "70s");
                    final Response clusterStateResponse = client.performRequest(new Request("GET", "/_cluster/state?pretty"));
import org.opensearch.common.io.PathUtils;
     * settings.
    }  
                request.addParameter("detailed", "true");
        assertThat(response.getStatusLine().getStatusCode(), equalTo(RestStatus.OK.getStatus()));  
        ensureHealth(index, (request) -> {
        );
                fail("cannot get cluster's pending tasks: " + e.getMessage());
        return false;  
    protected Map<String, Object> getIndexSettingsAsMap(String index) throws IOException {  
    private static List<HttpHost> clusterHosts;
    /**
        }
        } catch (ResponseException e) {
    /**
                assertBusy(() -> {  
    );
    protected boolean preserveSLMPoliciesUponCompletion() {
        @Override  
                    assertThat(XContentMapValues.extractValue("seq_no.max_seq_no", copy), equalTo(globalCheckpoint));
    }
import org.apache.hc.core5.http.HttpStatus;  
                try (InputStream is = Files.newInputStream(path)) {
        VersionSensitiveWarningsHandler warningsHandler = new VersionSensitiveWarningsHandler(nodeVersions);  
    /**
            }
    }
        for (Map.Entry<?, ?> entry : getResponse.entrySet()) {  
            if (false == preserveSnapshotsUponCompletion() && repoType.equals("fs")) {  
        assertOK(client().performRequest(flushRequest));
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            client.performRequest(request);
import java.util.Objects;  
        client().performRequest(request);
            String repoType = (String) repoSpec.get("type");
            this.testNodeVersions = nodeVersions;  
import org.apache.hc.core5.http.Header;
                }
        return RestStatus.OK.getStatus() == response.getStatusLine().getStatusCode();  
                final String warning = warnings.get(0);
                        .setSslContext(sslcontext)
                .createParser(
    }
                for (Map<String, ?> copy : shard) {
                        .build();
        // wipe cluster settings  
    private void logIfThereAreRunningTasks() throws IOException {  
import org.apache.hc.core5.http.HttpHost;
    }
        return responseAsMap(response);  
        String endpoint = "/_alias";
        try {  
        request.addParameter("verify", Boolean.toString(verify));
    }
import java.util.stream.Collectors;  
                 */  
    protected static void registerRepository(String repository, String type, boolean verify, Settings settings) throws IOException {
import java.util.HashSet;  
        Boolean acknowledged = (Boolean) XContentMapValues.extractValue(responseAsMap, "acknowledged");
                assertThat(ex.getResponse().getStatusLine(), equalTo(HttpStatus.SC_CONFLICT));
        MediaType mediaType = MediaType.fromMediaType(response.getEntity().getContentType());  
            try {  
                for (Object snapshot : snapshots) {
import org.opensearch.test.KeyStoreUtils;  
    protected String getTestRestCluster() {  
        return builder.build();
    /**
     *
    protected static Map<String, Object> getAsMap(final String endpoint) throws IOException {
        // wipe index templates  
            }
                    assertNotNull(details);
    }
    }  
     * Defaults to {@code false}. Override this method if indices should be preserved after the test,
        for (Map.Entry<String, Object> node : nodes.entrySet()) {
        return (Map<String, Object>) XContentMapValues.extractValue(index + ".aliases." + alias, getAliasResponse);
 */  
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;  
        });  
    protected String getProtocol() {
        // A synced-flush request considers the global checkpoint sync as an going operation because it acquires a shard permit.
        request.setOptions(options);
         * @param requiredWarnings a set of required warnings  
        return expectVersionSpecificWarnings(consumer -> consumer.current(warnings));
    public void initClient() throws IOException {  
        return (Map<String, Object>) ((Map<String, Object>) indexSettings.get(index)).get("settings");
                nodeVersions.add(Version.fromString(nodeInfo.get("version").toString()));  
            Map<?, ?> nodes = (Map<?, ?>) response.get("nodes");  
        }
                    }
    // This ensures that no matter in what order the tests run, the warning is asserted once.
 * SPDX-License-Identifier: Apache-2.0
        MediaType mediaType = MediaType.fromMediaType(response.getEntity().getContentType());  
        }
    @SuppressWarnings("unchecked")  
            if (warnings.isEmpty()) {
            throw e;  
import java.io.IOException;  
        request.addParameter("wait_for_completion", Boolean.toString(waitForCompletion));
        }
    public void ensurePeerRecoveryRetentionLeasesRenewedAndSynced(String index) throws Exception {
    protected static void createIndex(String name, Settings settings) throws IOException {
    private static RestClient client;  
            if (warnings.size() > 0) {  
 */  
    public void assertEmptyTranslog(String index) throws Exception {
                }  
        sort(stillRunning);  
    /**
        final Request request = new Request(HttpPost.METHOD_NAME, "_snapshot/" + repository + '/' + snapshot + "/_restore");  
                    DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
            "Failed to create snapshot [" + snapshot + "] in repository [" + repository + "]: " + response,
            }
                        String line;
        return clusterHosts;
     * deprecated request. The options will ensure that the given warnings are returned if all nodes are on
        Builder builder = RequestOptions.DEFAULT.toBuilder();
        return adminClient;
            inProgressSnapshots.set(wipeSnapshots());
        assertThat(
     * {@link #preserveIndicesUponCompletion()}, {@link #preserveTemplatesUponCompletion()}, {@link #preserveReposUponCompletion()},  
        return client;  
 * GitHub history for details.
                adminClient().performRequest(new Request("DELETE", "_component_template/*"));  
    protected void deleteRepository(String repoName) throws IOException {
     * preserving them. Only runs at all if xpack is installed on the cluster
                        && false == requiredSameVersionClusterWarnings.contains(actualWarning)) {
                clearCommand.field(key + ".*").nullValue();  
                    keyStore.load(is, keystorePass.toCharArray());  
import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder;
         * could determine that some tasks are run by the user we'd fail the tests if those tasks were running and ignore any background
        return false;
        }  
            try {  
            + "\\[(.+)\\] matching patterns from existing older templates \\[(.+)\\] with patterns \\((.+)\\); this template \\[(.+)\\] will "
            return RequestOptions.DEFAULT;
                    );
                        // Something other than a types removal message - return true
                for (String warning : warnings) {  
        }  
 * Licensed to Elasticsearch under one or more contributor  
        }
            entityContentType.xContent(),  
                        copy  
        Map<?, ?> getResponse = entityAsMap(adminClient().performRequest(new Request("GET", "/_cluster/settings")));
    public final void cleanUpCluster() throws Exception {
            for (Map.Entry<String, Object> taskAndName : nodeTasks.entrySet()) {
        request.setJsonEntity(entity);
        builder.setRequestConfigCallback(
        assertBusy(() -> {
    static final Pattern CREATE_INDEX_MULTIPLE_MATCHING_TEMPLATES = Pattern.compile(
import java.util.concurrent.ConcurrentHashMap;  
import org.junit.Before;  
     * {@link Version#CURRENT} and will allow (but not require) the warnings if any node is running an older version.  
                        message -> CREATE_INDEX_MULTIPLE_MATCHING_TEMPLATES.matcher(message).matches()  
     *
                return false == requiredSameVersionClusterWarnings.equals(actual);
            options.setWarningsHandler(warnings -> warnings.isEmpty() == false && warnings.equals(expectedWarnings) == false);  
    /**
import org.opensearch.core.xcontent.MediaType;
     */
                String host = stringUrl.substring(0, portSeparator);
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;  
            for (List<Map<String, ?>> shard : shards.values()) {
     */  
        request.addParameter("wait_for_no_initializing_shards", "true");
    protected static void useIgnoreMultipleMatchingTemplatesWarningsHandler(Request request) throws IOException {  
        public VersionSensitiveWarningsHandler(Set<Version> nodeVersions) {
import static java.util.Collections.unmodifiableList;  
     * Controls whether or not to preserve templates upon completion of this test. The default implementation is to delete not preserve  
        Map<String, Object> stats = entityAsMap(client().performRequest(new Request("GET", index + "/_stats?level=shards")));
                KeyStore keyStore = KeyStore.getInstance(KeyStoreUtils.inferStoreType(keystorePath));
    /**
            waitForClusterStateUpdatesToFinish();  
        assertNotNull(responseEntity);
import org.opensearch.Version;
    }  
    }  
     * Used to obtain settings for the REST client that is used to send REST requests.
            }
    protected static RestClient client() {
                 * Check to see if there are outstanding tasks; we exclude the list task itself, and any expected outstanding tasks using
     * @param adminClient the admin client
                int portSeparator = stringUrl.lastIndexOf(':');  
                    return true;
        );
            boolean allSystemIndexWarnings = true;
     * @return whether or not to preserve templates  
     * This is useful if the data directory and indices need to be preserved between test runs
     * Wait for outstanding tasks to complete. The specified admin client is used to check the outstanding tasks and this is done using
        final List<String> warningMessage = Arrays.asList(
    /**
        try (
import java.util.TreeSet;
import org.opensearch.common.CheckedRunnable;  
     */  
                        assertEquals(activeTasks + " active tasks found:\n" + tasksListString, 0, activeTasks);
    public void flush(String index, boolean force) throws IOException {  
            Request request = new Request("PUT", "/_cluster/settings");
    }  
            } catch (KeyStoreException | NoSuchAlgorithmException | KeyManagementException | CertificateException e) {  
    }
        return false;  
        final Request request = new Request(HttpPut.METHOD_NAME, "_snapshot/" + repository + '/' + snapshot);  
     *
                }  
        logger.info("flushing index {} force={}", index, force);
         * @param allowedWarnings optional warnings that will be ignored if received  
     */
        try {
         * This isn't a higher level log or outright failure because some of these tasks are run by the cluster in the background. If we  
    private void wipeClusterSettings() throws IOException {  
     * A client for the running OpenSearch cluster
                }
                "Must specify [tests.rest.cluster] system property with a comma delimited list of [host:port] "
import java.security.KeyStoreException;
        List<String> stillRunning = new ArrayList<>(runningTasks);
                    logger.info("total [{}] reused [{}]", totalFiles, reusedFiles);
        assertThat(XContentMapValues.extractValue("indices." + index + ".total.translog.uncommitted_operations", stats), equalTo(0));  
                        if (((String) retentionLease.get("id")).startsWith("peer_recovery/")) {
            final Request deleteRequest = new Request("DELETE", "*");
            adminClient = null;  
     * Returns whether to wait to make absolutely certain that all snapshots
                    @SuppressWarnings("unchecked")  
import org.apache.hc.core5.reactor.ssl.TlsDetails;
                            tasksListString.append(line);
                    throw new IllegalArgumentException("Illegal cluster url [" + stringUrl + "]");
    }  
        Version minVersion = null;
            wipeAllIndices();  
                    assertThat("not every active copy has established its PPRL", expectedLeaseIds, everyItem(in(existingLeaseIds)));  
            });  
            logger.debug("Clearing all templates");
        return RestStatus.OK.getStatus() == response.getStatusLine().getStatusCode();
        final Request request = new Request("POST", indexName + "/_flush/synced");
        RestClientBuilder builder = RestClient.builder(hosts);
            entity += ",\"mappings\" : {" + mapping + "}";
    }
        assertNotNull(shards);  
                }, 2, TimeUnit.MINUTES);  
import static org.hamcrest.Matchers.in;
        Request request = new Request("GET", "/" + index + "/_settings");  
            assert adminClient == null;
        waitForPendingTasks(adminClient, taskName -> false);  
     *
    }
        }
        assertThat(XContentMapValues.extractValue("indices." + index + ".total.translog.operations", stats), equalTo(0));
            for (String stringUrl : stringUrls) {
    public static class VersionSensitiveWarningsHandler implements WarningsHandler {  
            // We hit a version of ES that doesn't serialize DeleteDataStreamAction.Request#wildcardExpressionsOriginallySpecified field or  
        if (runningTasks.isEmpty()) {
    /**
            try {
        String entity = "{\"settings\": " + Strings.toString(MediaTypeRegistry.JSON, settings);
import static org.hamcrest.Matchers.anEmptyMap;
        public void compatible(String... allowedWarnings) {
    }
    /**
    }  
 * Superclass for tests that interact with an external test cluster using OpenSearch's {@link RestClient}.
import java.nio.file.Path;
        } finally {  
                    for (Map<String, ?> retentionLease : retentionLeases) {  
        }
        return false;
            equalTo(RestStatus.OK.getStatus())
    /**  
     * Convert the entity from a {@link Response} into a map of maps.  
            }
        runningTasks.remove(ListTasksAction.NAME + "[n]");
            String[] stringUrls = cluster.split(",");  
        updateIndexSettings(index, settings.build());
    }
    protected boolean preserveDataStreamsUponCompletion() {
    }  
                    String name = (String) snapshotInfo.get("snapshot");
                    assertThat(shardStats.toString(), globalCheckpoint, equalTo(maxSeqNo));  
                // We hit a version of ES that doesn't support index templates v2 yet, so it's safe to ignore
 * software distributed under the License is distributed on an
        int i = 0;  
    protected static void wipeAllIndices() throws IOException {
                        .collect(Collectors.toList());
                    NamedXContentRegistry.EMPTY,
                }
            if (shard.get("primary") == Boolean.FALSE && targetNode.test((String) XContentMapValues.extractValue("target.name", shard))) {
        Response response = client().performRequest(new Request("HEAD", "/" + index + "/_alias/" + alias));
    }  
        @SuppressWarnings("unchecked")
            }
        builder.setWarningsHandler(new WarningsHandler() {  
        return false;  
        createIndex(name, settings, mapping, null);  
        request.addParameter("level", "shards");  
        public void current(String... requiredWarnings) {
                boolean matches = warnings.stream()
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksAction;
        // ensure the global checkpoint is synced; otherwise we might trim the commit with syncId
        }  
            @Override
        assertThat(response.getStatusLine().getStatusCode(), anyOf(equalTo(200), equalTo(201)));
    /**  
            }
                        )
                    assertThat(snapshots.get(), anEmptyMap());
        builder.setDefaultHeaders(defaultHeaders);
     **/  
            ensureNoInitializingShards();
            allowSystemIndexAccessWarningOptions.setWarningsHandler(warnings -> {
import org.opensearch.core.xcontent.XContentParser;
    /**
        });  
        Request request = new Request("DELETE", "/" + name);  
package org.opensearch.test.rest;
        XContentBuilder clearCommand = JsonXContent.contentBuilder();
import org.apache.hc.core5.ssl.SSLContexts;
                .createParser(
    protected Settings restClientSettings() {
    /**
    private Set<String> runningTasks(Response response) throws IOException {
import java.util.concurrent.atomic.AtomicReference;
                throw new IllegalStateException(TRUSTSTORE_PATH + " is provided but not " + TRUSTSTORE_PASSWORD);  
     */
        return false;  
        Response response = client().performRequest(new Request("HEAD", "/" + index));  
            List<HttpHost> hosts = new ArrayList<>(stringUrls.length);
     * checks that the specific index is green. we force a selection of an index as the tests share a cluster and often leave indices  
    }  
                List<?> details = (List<?>) XContentMapValues.extractValue("index.files.details", shard);
                adminClient().performRequest(new Request("DELETE", "_index_template/*"));
    }
    protected void refreshAllIndices() throws IOException {
        assert clusterHosts != null;
                    StringBuilder message = new StringBuilder("there are still running tasks:");
    protected Map<String, List<Map<?, ?>>> wipeSnapshots() throws IOException {  
            XContentParser parser = mediaType.xContent()  
     * Get the list of hosts in the cluster.
    /**
                warnings -> warnings.isEmpty() == false  
                    assertThat(details, Matchers.empty());
        request.setOptions(options);
        return false;
                // Repeatedly delete the snapshots until there aren't any
    }  
                    DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
import java.nio.file.Files;
        builder.setStrictDeprecationMode(true);  
        }, 30L, TimeUnit.SECONDS);
    }
     */
                hosts.add(buildHttpHost(host, port));  
import java.io.BufferedReader;
     */
            } catch (final IOException e) {
 * ownership. Elasticsearch licenses this file to you under  
        final List<String> opensearchExpectedWarnings = Collections.singletonList(  
        }  
import org.opensearch.index.IndexSettings;  
                throw e;  
import java.security.cert.CertificateException;
                }
        return false;  
     * Remove any cluster settings.
                    assertThat(shardStats.toString(), localCheckpoint, equalTo(maxSeqNo));
    /**  
            List<Map<?, ?>> shardStats = (List<Map<?, ?>>) XContentMapValues.extractValue("indices." + index + ".shards.0", stats);  
        }
                }
    }  
import java.util.ArrayList;
    }
import java.io.InputStreamReader;
        Map<String, Object> getAliasResponse = getAsMap(endpoint);  
    protected boolean preserveIndicesUponCompletion() {
                .forEach(seqNoStat -> {
                        }  
     * @return whether or not to preserve data streams  
                int port = Integer.valueOf(stringUrl.substring(portSeparator + 1));
                /*  
    }
                            new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8)
        Response response = client().performRequest(new Request("POST", "/" + index + "/_close"));
        List<Map<String, ?>> shards = (List<Map<String, ?>>) XContentMapValues.extractValue(indexName + ".shards", recoveries);
                throw new IllegalStateException(TRUSTSTORE_PATH + " is set but points to a non-existing file");
                            if (taskName.startsWith(ListTasksAction.NAME) || taskFilter.test(taskName)) {  
import org.opensearch.index.seqno.ReplicationTracker;
    }  
                    && warning.contains("but in a future major version, direct access to system indices will be prevented by default");
    }  
    }
     */
    public static RequestOptions expectVersionSpecificWarnings(Consumer<VersionSensitiveWarningsHandler> expectationsSetter) {
                    if (SnapshotState.valueOf((String) snapshotInfo.get("state")).completed() == false) {
            nodeVersions = null;
import org.opensearch.client.RequestOptions.Builder;  
        final Request request = new Request("GET", "_nodes");
import java.util.Collections;
            }  
    public static void ensureGreen(String index) throws IOException {
    }
    protected static void configureClient(RestClientBuilder builder, Settings settings) throws IOException {
        // wipe data streams before indices so that the backing indices for data streams are handled properly
                }
     * in the cluster and doesn't require to know how many nodes/replica there are.  
                    long globalCheckpoint = ((Number) XContentMapValues.extractValue("global_checkpoint", seqNoStat)).longValue();
            }
        Map<String, String> headers = ThreadContext.buildDefaultHeaders(settings);
        Request request = new Request("GET", "/_cluster/health" + (index.trim().isEmpty() ? "" : "/" + index));
        // EMPTY and THROW are fine here because `.map` doesn't use named x content or deprecation
    protected static void updateIndexSettings(String index, Settings.Builder settings) throws IOException {
                        .build();
    protected static void wipeDataStreams() throws IOException {
            request.addParameter("wait_for_status", "green");  
            return testNodeVersions.size() == 1 && testNodeVersions.iterator().next().equals(Version.CURRENT);
    /**  
                return false;
    }
import java.security.NoSuchAlgorithmException;  
import org.opensearch.common.util.concurrent.ThreadContext;
            logger.info("initializing REST clients against {}", clusterHosts);  
            try {
    protected static void assertOK(Response response) {
        }
                    ) {  
 * under the License.  
            }
        } else {
        if (settings.getAsBoolean(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true) == false) {
    public static void waitForPendingTasks(final RestClient adminClient) throws Exception {
                        final StringBuilder tasksListString = new StringBuilder();  
    private void waitForClusterStateUpdatesToFinish() throws Exception {
     * @throws Exception if an exception is thrown while checking the outstanding tasks  
    protected static RestClient adminClient() {  
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;  
        return builder.build();  
        }  
import static org.hamcrest.Matchers.equalTo;  
                // once detailed recoveries works, remove this if.  
    /**  
                inProgressSnapshots.set(snapshots.get());
                    response.getEntity().getContent()
         * in mixed-version clusters or those that differ in version from the test client.
        try (
    public static RequestOptions allowTypesRemovalWarnings() {
        flushRequest.addParameter("wait_if_ongoing", "true");
                + "Please do not specify value for setting [index.soft_deletes.enabled] of index ["
import org.opensearch.common.unit.TimeValue;
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
        final Map<String, List<Map<?, ?>>> inProgressSnapshots = new HashMap<>();
    }
     * have been deleted.
 *  
        }
        final Request request = new Request(HttpPut.METHOD_NAME, "_snapshot/" + repository);  
    /**  
            // that doesn't support data streams so it's safe to ignore
     * {@link OpenSearchTestCase#assertBusy(CheckedRunnable)} to give a chance to any outstanding tasks to complete.  
            if (isExclusivelyTargetingCurrentVersionCluster()) {
            }  
                .map(shard -> (Map<?, ?>) XContentMapValues.extractValue("seq_no", shard))
        logger.info("index {} recovery stats {}", indexName, shards);
        assertThat(
import org.hamcrest.Matchers;  
    }
    protected static void closeIndex(String index) throws IOException {
                    List<String> existingLeaseIds = retentionLeases.stream()
    public static final String CLIENT_PATH_PREFIX = "client.path.prefix";
            }
                minVersion = nodeVersion;  
    protected boolean preserveTemplatesUponCompletion() {
import org.opensearch.client.RequestOptions;
            // wipe indices
    public static Map<String, Object> entityAsMap(Response response) throws IOException {
import org.opensearch.client.Request;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Set<String> runningTasks = new HashSet<>();
import java.security.KeyManagementException;  
import org.opensearch.common.xcontent.XContentHelper;
     * filter is used to filter out outstanding tasks that are expected to be there.  
                    assertNotNull(retentionLeases);
        );
    private static Set<String> assertedWarnings = ConcurrentHashMap.newKeySet();  
                }  
                Map<?, ?> nodeInfo = (Map<?, ?>) node.getValue();
     * Waits for the cluster state updates to have been processed, so that no cluster
        assert nodeVersions != null;  
     * Override this to switch to testing https.  
        "^index \\[(.+)\\] matches multiple legacy " + "templates \\[(.+)\\], composable templates will only match a single template$"  
     *
        request.setOptions(requestOptions);
    /**  
        logger.debug("wiping snapshot repository [{}]", repoName);
     * test. Defaults to not preserving snapshots. Only works for {@code fs} repositories.  
            throw new RuntimeException(  
     * Convert the entity from a {@link Response} into a list of maps.  
import java.util.Arrays;  
        // EMPTY and THROW are fine here because `.map` doesn't use named x content or deprecation
                    try (
     */  
                    assertThat(result.get("failed"), equalTo(0));
     * @throws Exception if an exception is thrown while checking the outstanding tasks
        runningTasks.remove(ListTasksAction.NAME);  
                throw new AssertionError("error getting active tasks list", e);
            } catch (ResponseException e) {
     * @param deprecationWarning expected warning
    }  
        try {  
        boolean foundReplica = false;
                    return false;  
    }  
            } else {
        Map<String, Object> nodes = (Map<String, Object>) entityAsMap(response).get("nodes");
            options.setWarningsHandler(
        }
            if (settings.isEmpty()) {  
     * completes  
            request.addParameter("level", "shards");  
                    }
     */
 *
/**
                inProgressSnapshots.set(snapshots.get());
                runningTasks.add(task.get("action").toString());
            }  
                    if (false == allowedWarnings.contains(actualWarning)  
                    NamedXContentRegistry.EMPTY,
    protected static Version minimumNodeVersion() throws IOException {  
        assertNotNull(minVersion);  
        assertBusy(() -> {
                // absolute equality required in expected and actual.  
                    final PoolingAsyncClientConnectionManager connectionManager = PoolingAsyncClientConnectionManagerBuilder.create()  
                        .setTlsDetailsFactory(new Factory<SSLEngine, TlsDetails>() {
                        message.append('\n').append(task.toString());  
import org.opensearch.core.xcontent.DeprecationHandler;  
                            }
                        }  
import org.opensearch.client.ResponseException;
    }
        assertThat(response.getStatusLine().getStatusCode(), equalTo(RestStatus.OK.getStatus()));
        if (preserveClusterUponCompletion() == false) {  
 * You may obtain a copy of the License at  
            for (Object key : settings.keySet()) {
    public static void closeClients() throws IOException {  
        boolean mustClear = false;  
        } else {
                if (false == tasks.isEmpty()) {  
                    logger.debug("wiping snapshot [{}/{}]", repoName, name);
 *
    /**  
        });
                if (portSeparator < 0) {
        createIndex(name, settings, null);
     * with the assumption that some other process or test will clean up the indices afterward.  
     * Defaults to not preserving repos. See also  
import javax.net.ssl.SSLContext;
import org.junit.AfterClass;
    protected static void restoreSnapshot(String repository, String snapshot, boolean waitForCompletion) throws IOException {
    protected boolean preserveReposUponCompletion() {  
    }
                return false;  
        return cluster;
            // 404 here just means we had no indexes
            conf -> conf.setResponseTimeout(Timeout.ofMilliseconds(Math.toIntExact(socketTimeout.getMillis())))
            assertFalse("Node versions running in the cluster are missing", testNodeVersions.isEmpty());
                stats
                builder.setHttpClientConfigCallback(httpClientBuilder -> {  
            return;  
        if (cluster == null) {
                    long reusedFiles = ((Number) XContentMapValues.extractValue("index.files.reused", shard)).longValue();  
    }  
            Map<String, Object> nodeTasks = (Map<String, Object>) nodeInfo.get("tasks");
        final Response response = adminClient().performRequest(request);
     * Determines if data streams are preserved upon completion of this test. The default implementation wipes data streams.
import java.io.InputStream;
        if (aliases != null) {  
    protected static void createIndex(String name, Settings settings, String mapping) throws IOException {
            adminClient().performRequest(new Request("DELETE", "_template/*"));  
        private boolean isExclusivelyTargetingCurrentVersionCluster() {  
        }, 30, TimeUnit.SECONDS);
    }
            client = buildClient(restClientSettings(), clusterHosts.toArray(new HttpHost[0]));
                });
        public boolean warningsShouldFailRequest(List<String> warnings) {
            response.getStatusLine().getStatusCode(),  
        if (keystorePath != null) {  
        return minVersion;
        }  
                }  
        clearCommand.endObject();
                    throw new AssertionError(ex); // cause assert busy to retry  
        Set<String> requiredSameVersionClusterWarnings = new HashSet<>();
        requestOptions.setWarningsHandler(warnings -> warnings.equals(opensearchExpectedWarnings) == false);
                Response response = adminClient().performRequest(new Request("GET", "/_cluster/pending_tasks"));
import static java.util.Collections.sort;
     */  
            RequestOptions.Builder allowSystemIndexAccessWarningOptions = RequestOptions.DEFAULT.toBuilder();  
    /**  
    }
 * the Apache License, Version 2.0 (the "License"); you may
            int statusCode = e.getResponse().getStatusLine().getStatusCode();
                Map<String, Object> task = (Map<String, Object>) taskAndName.getValue();  
            final String keystorePass = settings.get(TRUSTSTORE_PASSWORD);
                            assertThat(retentionLease.get("retaining_seq_no"), equalTo(globalCheckpoint + 1));
        adminClient().performRequest(request);
    /**
            return parser.map();
     * Creates RequestOptions designed to ignore [types removal] warnings but nothing else  
        }  
            wipeCluster();
     * Get the client used for test administrative actions. Do not use this while writing a test. Only use it for cleaning up after tests.
                        })  
         */
 * license agreements. See the NOTICE file distributed with
     */
            return parser.list();
    }
    /**  
            public boolean warningsShouldFailRequest(List<String> warnings) {
                        while ((line = responseReader.readLine()) != null) {
            }
    }
            Map<?, ?> settings = (Map<?, ?>) entry.getValue();
    /**  
    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
    }
 * KIND, either express or implied.  See the License for the
     * in an non green state
            equalTo(RestStatus.OK.getStatus())
                            + "] "  
                continue;
                    }
            Map<?, ?> stats = entityAsMap(client().performRequest(new Request("GET", index + "/_stats?level=shards")));
            response.getStatusLine().getStatusCode(),  
    private static void updateIndexSettings(String index, Settings settings) throws IOException {
import org.apache.hc.client5.http.classic.methods.HttpPost;
    protected static void ensureHealth(Consumer<Request> requestConsumer) throws IOException {
        );
                } catch (Exception inner) {
                            || PUT_TEMPLATE_MULTIPLE_MATCHING_TEMPLATES.matcher(message).matches()
    }
        Settings.Builder builder = Settings.builder();
     * Asserts that replicas on nodes satisfying the {@code targetNode} should have perform operation-based recoveries.  
     */
    protected RestClient buildClient(Settings settings, HttpHost[] hosts) throws IOException {  
import org.opensearch.common.util.io.IOUtils;  
        }
     */
                deleteRepository(repoName);
        Set<String> allowedWarnings = new HashSet<>();
     * state updates are still in-progress when the next test starts.
            Path path = PathUtils.get(keystorePath);
            client = null;
        if (waitForAllSnapshotsWiped()) {
                    long localCheckpoint = ((Number) XContentMapValues.extractValue("local_checkpoint", seqNoStat)).longValue();  
        if (preserveClusterSettings() == false) {
     * start empty. There isn't an API to delete all snapshots. There is an API to delete all snapshot repositories but that leaves all of
    }
        for (Map<String, ?> shard : shards) {  
    }  
                        return true;  
            "Creating indices with soft-deletes disabled is deprecated and will be removed in future OpenSearch versions. "
        // 8.0 kept in warning message for legacy purposes TODO: changge to 3.0
            deleteRequest.addParameter("expand_wildcards", "open,closed,hidden");
    public static final String TRUSTSTORE_PASSWORD = "truststore.password";  
            equalTo(RestStatus.OK.getStatus())
        /**  
                final boolean isSystemIndexWarning = warning.contains("this request accesses system indices")  
    /**
            if (keystorePass == null) {
        requestConsumer.accept(request);
                    for (Object task : tasks) {
     * A client for the running OpenSearch cluster configured to take test administrative actions like remove all indexes after the test
        String cluster = System.getProperty("tests.rest.cluster");
                throw new RuntimeException("Error setting up ssl", e);
import java.util.List;
                if (!warning.startsWith("this request accesses system indices:")) {  
            builder.put(CLIENT_PATH_PREFIX, System.getProperty("tests.rest.client_path_prefix"));
     */
    // This set will contain the warnings already asserted since we are eliminating logging duplicate warnings.
        request.setJsonEntity(Strings.toString(MediaTypeRegistry.JSON, new PutRepositoryRequest(repository).type(type).settings(settings)));
        }  
    }  
    }  
        try (InputStream is = response.getEntity().getContent()) {  
 */  
            );  
import org.opensearch.test.OpenSearchTestCase;
    protected Settings restAdminSettings() {  
    /**
     * Asserts that we do not retain any extra translog for the given index (i.e., turn off the translog retention)
        });
        Request request = new Request("PUT", "/" + index + "/_settings");  
        if (System.getProperty("tests.rest.client_path_prefix") != null) {  
        for (Map.Entry<String, ?> repo : entityAsMap(adminClient.performRequest(new Request("GET", "/_snapshot/_all"))).entrySet()) {
import org.opensearch.common.SetOnce;
     * the snapshots intact in the repository.  
import java.util.Map;
        request.setJsonEntity(Strings.toString(MediaTypeRegistry.JSON, settings));
    }
        /*
     * used in the target cluster.
    /**
        final Response response = client().performRequest(request);  
            if (e.getResponse().getStatusLine().getStatusCode() == HttpStatus.SC_REQUEST_TIMEOUT) {  
        }
            }  
    protected static void openIndex(String index) throws IOException {  
                    );
            Map<String, List<Map<String, ?>>> shards = (Map<String, List<Map<String, ?>>>) XContentMapValues.extractValue(  
        configureClient(builder, settings);
            responseStatusCode,
    /**
            "Failed to restore snapshot [" + snapshot + "] from repository [" + repository + "]: " + response,
            adminClient().performRequest(new Request("DELETE", "_data_stream/*"));
                for (String actualWarning : warnings) {
     * being tested.  
            mustClear = true;  
     */
                    assertNotNull(globalCheckpoint);
/*  
     */
    }
                )
                            public TlsDetails create(final SSLEngine sslEngine) {  
            wipeDataStreams();
            CLIENT_SOCKET_TIMEOUT
    }  
            clearCommand.endObject();
        Request refreshRequest = new Request("POST", "/_refresh");
import org.apache.hc.core5.util.Timeout;  
import static org.hamcrest.Matchers.anyOf;
         * Adds to the set of warnings that are permissible (but not required) when running
    private static TreeSet<Version> nodeVersions;  
            XContentParser parser = mediaType.xContent()  
                            final String taskName = line.split("\\s+")[0];
            }
    }
        return builder.build();  
    protected boolean waitForAllSnapshotsWiped() {
            if (minVersion == null || minVersion.after(nodeVersion)) {
                        return true;
        return expectWarnings(deprecationWarning);
        );  
        return restClientSettings(); // default to the same client settings
            Map<?, ?> response = entityAsMap(adminClient.performRequest(new Request("GET", "_nodes/plugins")));
        for (Map.Entry<String, Object> node : nodes.entrySet()) {
import java.util.HashMap;
                return false;
     */
        }
            for (Map.Entry<?, ?> node : nodes.entrySet()) {
     * Logs a message if there are still running tasks. The reasoning is that any tasks still running are state the is trying to bleed into  
        } catch (ResponseException e) {  
        if (preserveTemplatesUponCompletion() == false) {
                    assertThat("must reuse all files, recoveries [" + recoveries + "]", totalFiles, equalTo(reusedFiles));
import java.nio.charset.StandardCharsets;  
        if (nodeVersions.stream().allMatch(version -> version.onOrAfter(Version.V_2_0_0))) {
     */  
        assertedWarnings.add(deprecationWarning);
            } catch (AssertionError e) {  
            endpoint = index + endpoint;
                                continue;
            @SuppressWarnings("unchecked")
            Map<?, ?> repoSpec = (Map<?, ?>) repo.getValue();
                    .anyMatch(
    protected static Map<String, Object> getAlias(final String index, final String alias) throws IOException {
        return false;
                    break;
                            activeTasks++;  
    }  
     */
    @SuppressWarnings("unchecked")  
        // Allow system index deprecation warnings
     * @return Map of repository name to list of snapshots found in unfinished state
                    && warnings.equals(warningMessage) == false
                } else if (warnings.size() > 1) {
            assert clusterHosts == null;  
    }
                    fail(message.toString());
            if (e.getResponse().getStatusLine().getStatusCode() != 404) {
    @SuppressWarnings("unchecked")
                // All other repo types we really don't have a chance of being able to iterate properly, sadly.
     * and {@link #preserveSnapshotsUponCompletion()}.
     *
            false
        ensureHealth(client(), index, requestConsumer);  
     * Returns whether to preserve the snapshots in repositories on completion of this
        if (mustClear) {  
        request.addParameter("wait_for_completion", Boolean.toString(waitForCompletion));
        RequestOptions.Builder options = request.getOptions().toBuilder();
        ensureHealth("", requestConsumer);
            nodeVersions = new TreeSet<>();
            }
            defaultHeaders[i++] = new BasicHeader(entry.getKey(), entry.getValue());
                    adminClient().performRequest(new Request("DELETE", "/_snapshot/" + repoName + "/" + name));  
     * @deprecated this method is only required while we deprecate types and can be removed in 8.0
    protected static void ensureHealth(String index, Consumer<Request> requestConsumer) throws IOException {
                    final TlsStrategy tlsStrategy = ClientTlsStrategyBuilder.create()
            "Synced flush is deprecated and will be removed in 3.0. Use flush at _/flush or /{index}/_flush instead."  
        }
        Builder builder = RequestOptions.DEFAULT.toBuilder();
        assertThat("Found in progress snapshots [" + inProgressSnapshots.get() + "].", inProgressSnapshots.get(), anEmptyMap());
 * compatible open source license.
     * @param index index to test for
                + indexName  
     */
        refreshRequest.addParameter("expand_wildcards", "open,hidden");  
import org.apache.hc.core5.http.message.BasicHeader;
                    }
     * Returns whether to preserve the indices created during this test on completion of this test.
            for (String warning : warnings) {
                "indices." + index + ".shards",
            if (Set.of(404, 405, 500).contains(statusCode) == false) {  
     * templates.
        client().performRequest(refreshRequest);
                        "timed out waiting for green state for index ["
        Response response = client().performRequest(request);
        client().performRequest(request);
        final Builder requestOptions = RequestOptions.DEFAULT.toBuilder();
                final Request request = new Request("GET", "/_cat/tasks");  
                    );
import java.security.KeyStore;
    protected static void ensureHealth(RestClient client, String index, Consumer<Request> requestConsumer) throws IOException {  
    protected boolean preserveSnapshotsUponCompletion() {
            try {
     * Returns the minimum node version among all nodes of the cluster
        request.addParameter("filter_path", "nodes.*.version");
        try {  
        if (false == Strings.isEmpty(alias)) {  
        if (false == Strings.isEmpty(index)) {  
        ) {  
                Set<String> actual = new HashSet<>(warnings);
     * @return true if the state of the cluster should be preserved  
                    Map<String, Object> result = ObjectPath.createFromResponse(resp).evaluate("_shards");  
                    snapshots.set(wipeSnapshots());
import static org.hamcrest.Matchers.everyItem;
            }  
import org.opensearch.common.settings.Settings;  
import org.opensearch.client.Response;
        Header[] defaultHeaders = new Header[headers.size()];
        flushRequest.addParameter("force", Boolean.toString(force));  
            String type = entry.getKey().toString();
            }
            wipeClusterSettings();
    protected final List<HttpHost> getClusterHosts() {
                final Response response = adminClient.performRequest(request);
        assertBusy(() -> {
                    + "to which to send REST requests"
        builder.setWarningsHandler(warningsHandler);
        }, 60, TimeUnit.SECONDS);
    );
                        .map(lease -> (String) lease.get("id"))  
 * this work for additional information regarding copyright
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
        final Response response = client().performRequest(request);
                    List<String> expectedLeaseIds = shard.stream()
import java.util.Set;
        adminClient().performRequest(new Request("DELETE", "_snapshot/" + repoName));  
 */
        final Map<String, Object> nodes = ObjectPath.createFromResponse(response).evaluate("nodes");
                throw e;
    }
    @AfterClass
     */
            }
    }
                    return httpClientBuilder.setConnectionManager(connectionManager);
     * (for example, when testing rolling upgrades).
        assertTrue("must find replica", foundReplica);
        if (preserveDataStreamsUponCompletion() == false) {  
        ) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
    static final Pattern PUT_TEMPLATE_MULTIPLE_MATCHING_TEMPLATES = Pattern.compile(  
     * Wipe fs snapshots we created one by one and all repositories so that the next test can create the repositories fresh and they'll
            "Synced flush was removed and a normal flush was performed instead. This transition will be removed in a future version."  
        expectationsSetter.accept(warningsHandler);
            final Response response = adminClient().performRequest(deleteRequest);
    public static RequestOptions expectWarnings(String... warnings) {
        Map<String, Object> responseEntity = XContentHelper.convertToMap(
            }
            response.getEntity().getContent(),
     */
        ensureGlobalCheckpointSynced(indexName);
     */
            adminClient = buildClient(restAdminSettings(), clusterHosts.toArray(new HttpHost[0]));
    }
    }  
    @Deprecated  
    public static final String TRUSTSTORE_PATH = "truststore.path";
    private void wipeCluster() throws Exception {
        final Request flushRequest = new Request("POST", "/" + index + "/_flush");
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
    }  
     * Helper class to check warnings in REST responses with sensitivity to versions  
            clusterHosts = unmodifiableList(hosts);
    protected static void deleteIndex(String name) throws IOException {
            expectSoftDeletesWarning(request, name);
                    }  
    public void assertNoFileBasedRecovery(String indexName, Predicate<String> targetNode) throws IOException {
/*
            deleteRequest.setOptions(allowSystemIndexAccessWarningOptions);
    protected static void createSnapshot(String repository, String snapshot, boolean waitForCompletion) throws IOException {
     * Controls whether or not to preserve cluster settings upon completion of the test. The default implementation is to remove all cluster
            request.addParameter("timeout", "70s");
            assert nodeVersions == null;
}
            clearCommand.startObject(type);
    @After
public abstract class OpenSearchRestTestCase extends OpenSearchTestCase {
    /**  
        Map<String, Object> indexSettings = getIndexSettings(index);
    protected static void ensureNoInitializingShards() throws IOException {
        requestOptions.setWarningsHandler(warnings -> {  
                List<?> tasks = (List<?>) entityAsMap(response).get("tasks");
     * Clean up after the test case.
     */
import javax.net.ssl.SSLEngine;  
        }
                .filter(Objects::nonNull)  
    }
    protected void syncedFlush(String indexName, boolean retryOnConflict) throws Exception {
    /**
     * Returns whether to preserve the state of the cluster upon completion of this test. Defaults to false. If true, overrides the value of
            }
                        .collect(Collectors.toList());
        refreshRequest.setOptions(requestOptions);
        // Ignore the task list API - it doesn't count against us
        Request request = new Request("PUT", "/" + name);
        "^index template \\[(.+)\\] has index patterns "
            this.allowedWarnings.addAll(Arrays.asList(allowedWarnings));  
            }
            message + ": expecting response code [200] but got [" + responseStatusCode + ']',  
         * tasks.
     * @param adminClient the admin client
        if (preserveIndicesUponCompletion() == false) {
            try (InputStream is = response.getEntity().getContent()) {  
     * Returns the REST client settings used for admin actions like cleaning up after the test has completed.
        );  
        final Builder options = RequestOptions.DEFAULT.toBuilder();  
        });
        }
                            @Override
                    e.addSuppressed(inner);  
                    long totalFiles = ((Number) XContentMapValues.extractValue("index.files.total", shard)).longValue();
import org.opensearch.client.RestClientBuilder;
    private static void assertAcked(String message, Response response) throws IOException {  
    @Before
        if (settings.hasValue(CLIENT_PATH_PREFIX)) {
                        BufferedReader responseReader = new BufferedReader(  
                // At this point there should be no snaphots
                        .map(shr -> (String) XContentMapValues.extractValue("routing.node", shr))  
        clearCommand.startObject();
        }  
import org.opensearch.common.xcontent.json.JsonXContent;
            request.addParameter("wait_for_no_relocating_shards", "true");
    }
            Map<String, Object> nodeInfo = (Map<String, Object>) node.getValue();  
            try {  
            endpoint = endpoint + "/" + alias;
    protected boolean preserveClusterUponCompletion() {
        }
            builder.setPathPrefix(settings.get(CLIENT_PATH_PREFIX));
        final List<String> expectedWarnings = Arrays.asList(
                return isSystemIndexWarning == false;
                Response resp = client().performRequest(request);
         * is formed from nodes all running the exact same version as the client.
        return inProgressSnapshots;
    protected static boolean aliasExists(String index, String alias) throws IOException {
                    Integer globalCheckpoint = (Integer) XContentMapValues.extractValue("seq_no.global_checkpoint", copy);  
                List<?> snapshots = (List<?>) entityAsMap(adminClient.performRequest(listRequest)).get("snapshots");
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    }
import org.opensearch.snapshots.SnapshotState;
                            + EntityUtils.toString(clusterStateResponse.getEntity())
        }, 60, TimeUnit.SECONDS);  
                        "retention_leases.leases",
                                return new TlsDetails(sslEngine.getSession(), sslEngine.getApplicationProtocol());
    private static RestClient adminClient;
        assert adminClient != null;
     * Creates request options designed to be used when making a call that can return warnings, for example a
        );  
import org.opensearch.client.WarningsHandler;
        );
     * Wait for outstanding tasks to complete. The specified admin client is used to check the outstanding tasks and this is done using
    }
        return builder.build();  
    }
                    Map<?, ?> snapshotInfo = (Map<?, ?>) snapshot;  
        assertBusy(() -> {  
        /**  
     * @param warnings The expected warnings.
                            tasksListString.append('\n');
            @SuppressWarnings("unchecked")  
    }  
     */
        options.setWarningsHandler(warnings -> {
        MediaType entityContentType = MediaType.fromMediaType(response.getEntity().getContentType());
                assertTrue((boolean) XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), is, true).get("acknowledged"));
    /**  
                        int activeTasks = 0;
                    && warnings.equals(expectedWarnings) == false
    protected static Map<String, Object> getIndexSettings(String index) throws IOException {
            AtomicReference<Map<String, List<Map<?, ?>>>> snapshots = new AtomicReference<>();  
                        .map(ReplicationTracker::getPeerRecoveryRetentionLeaseId)
import org.opensearch.client.RestClient;  
     * Filters out already asserted warnings and calls expectWarnings method.  
                });
        Response response = client().performRequest(new Request("GET", endpoint));
     * that we have renewed every PRRL to the global checkpoint of the corresponding copy and properly synced to all copies.  
            } catch (IOException e) {
            adminClient().performRequest(request);  
    /**
    }
                Request listRequest = new Request("GET", "/_snapshot/" + repoName + "/_all");
        return new HttpHost(getProtocol(), host, port);
import org.opensearch.core.common.Strings;
        return runningTasks;
        final Set<Version> testNodeVersions;  
    public static void waitForPendingTasks(final RestClient adminClient, final Predicate<String> taskFilter) throws Exception {  
                    allSystemIndexWarnings = false;
        if (assertedWarnings.contains(deprecationWarning)) {
                }  
                if (retryOnConflict) {
            return XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), is, true);
         * Adds to the set of warnings that are all required in responses if the cluster
            clusterHosts = null;
        }
                final SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(keyStore, null).build();
import org.opensearch.test.rest.yaml.ObjectPath;
            socketTimeoutString == null ? "60s" : socketTimeoutString,
        }
    }  
        SetOnce<Map<String, List<Map<?, ?>>>> inProgressSnapshots = new SetOnce<>();
                    long maxSeqNo = ((Number) XContentMapValues.extractValue("max_seq_no", seqNoStat)).longValue();
    protected static boolean aliasExists(String alias) throws IOException {
         */  
     * Peer recovery retention leases are renewed and synced to replicas periodically (every 30 seconds). This ensures
    }  
        final Builder requestOptions = RequestOptions.DEFAULT.toBuilder();  
        if (mapping != null) {  
            logIfThereAreRunningTasks();
        entity += "}";  
     */
                return matches == false;  
     */  
        if (client == null) {
        }
    }  
    protected boolean preserveClusterSettings() {  
     */
    }  
                            + "cluster state ["
                            + index
import org.apache.hc.core5.function.Factory;  
     * waits until all shard initialization is completed. This is a handy alternative to ensureGreen as it relates to all shards
                }
            shardStats.stream()
     */
                // Some known warnings can safely be ignored
import org.apache.hc.core5.http.io.entity.EntityUtils;
    }
            }
                // This will cause an error at the end of this method, but do the rest of the cleanup first
import java.util.concurrent.TimeUnit;
                } else {  
     * @param taskFilter  predicate used to filter tasks that are expected to be there  
            IOUtils.close(client, adminClient);
    }
                }
    }  
        return RestStatus.OK.getStatus() == response.getStatusLine().getStatusCode();
                if (warnings.size() == 0) {
    protected HttpHost buildHttpHost(String host, int port) {  
import java.util.function.Consumer;  
                    List<Map<String, ?>> retentionLeases = (List<Map<String, ?>>) XContentMapValues.extractValue(
        }  
            if (!Files.exists(path)) {  
 * Modifications Copyright OpenSearch Contributors. See
                    fail(  
         */
            if (warnings.isEmpty()) {
/*  
        assertThat(message + ": response is not acknowledged", acknowledged, equalTo(Boolean.TRUE));  
        final String socketTimeoutString = settings.get(CLIENT_SOCKET_TIMEOUT);
            requiredSameVersionClusterWarnings.addAll(Arrays.asList(requiredWarnings));  
    public static final String CLIENT_SOCKET_TIMEOUT = "client.socket.timeout";
        logger.info("There are still tasks running after this test that might break subsequent tests {}.", stillRunning);
        final Response response = client().performRequest(request);  
    public static List<Object> entityAsList(Response response) throws IOException {
        request.addParameter("flat_settings", "true");
        }
 * not use this file except in compliance with the License.
     * Construct an HttpHost from the given host and port
        Request request = new Request("GET", "/_cluster/health");  
                    response.getEntity().getContent()
        client().performRequest(request);
     */
        // We have to spin synced-flush requests here because we fire the global checkpoint sync for the last write operation.  
        Map<String, Object> recoveries = entityAsMap(client().performRequest(new Request("GET", indexName + "/_recovery?detailed=true")));  
                listRequest.addParameter("ignore_unavailable", "true");  
        final Map<String, Object> responseAsMap = responseAsMap(response);
        );  
import org.apache.hc.client5.http.classic.methods.HttpPut;
            if (preserveReposUponCompletion() == false) {  
            String repoName = repo.getKey();  
        }  
import org.opensearch.core.rest.RestStatus;
        }
import java.util.function.Predicate;
                    if (warning.startsWith("[types removal]") == false) {
     */
import java.util.regex.Pattern;
    }
     * {@link #preserveSnapshotsUponCompletion()}.
        }
        }  
        }
     */
                if (retryOnConflict) {
     * Get the client used for ordinary api calls while writing a test  
    }
                        inProgressSnapshots.computeIfAbsent(repoName, key -> new ArrayList<>()).add(snapshotInfo);  
            return !allSystemIndexWarnings;
        assertBusy(() -> {
                )
        final TimeValue socketTimeout = TimeValue.parseTimeValue(  
        final int responseStatusCode = response.getStatusLine().getStatusCode();
    protected static void expectSoftDeletesWarning(Request request, String indexName) {
            );  
    }  
                return false;
    public static RequestOptions expectWarningsOnce(String deprecationWarning) {  
                if (details == null) {
     */  
     */  
        } catch (ResponseException e) {
        Response response = client().performRequest(new Request("POST", "/" + index + "/_open"));
                return false;  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
                // We don't know exactly which indices we're cleaning up in advance, so just accept all system index access warnings.
            Map<String, Object> stats = entityAsMap(client().performRequest(new Request("GET", index + "/_stats?level=shards")));
    /**  
     * @return true if cluster settings should be preserved and otherwise false
                 * the specified task filter.
     * other tests.
     *  
     * Returns whether to preserve SLM Policies of this test. Defaults to not
                            + "]"  
    /**
        assertAcked("Failed to create repository [" + repository + "] of type [" + type + "]: " + response, response);
