                }
        return RandomizedContext.current().runWithPrivateRandomness(seed, () -> target.buildTestCluster(scope, seed));
    synchronized RestClient getRestClient() {
                                (ParameterizedOpenSearchIntegTestCase) instance,
            TestCluster testCluster = clusters.remove(clazz); // remove this cluster first
                cluster().assertAfterTest();
            clearClusters(); // all leftovers are gone by now... this is really just a double safety if we miss something somewhere
    private boolean runTestScopeLifecycle() {
        assertFalse(nodesInfoResponse.hasFailures());
                cluster().wipe(instance.excludeTemplates()); // wipe after to make sure we fail in the test that didn't ack the delete
        try {
    private void afterInternal(boolean afterClass, OpenSearchIntegTestCase target) throws Exception {
    protected RestClient createRestClient(RestClientBuilder.HttpClientConfigCallback httpClientConfigCallback, String protocol) {
    private void clearClusters() throws Exception {
                if (!success) {
        }
            } else {
                TransportAddress publishAddress = node.getInfo(HttpInfo.class).address().publishAddress();
                IOUtils.close(clusters.values());
        } else {
                        after(target, method);
                    }
                    break;
                }
import org.opensearch.client.RestClientBuilder;
                instance.ensureClusterStateCanBeReadByNodeTool();
import org.opensearch.test.client.RandomizingClient;
        return statement(base, method, target);
    }
        RestClientBuilder.HttpClientConfigCallback httpClientConfigCallback,
 * compatible open source license.
                    break;
        String protocol
    protected void before(Object target, FrameworkMethod method) throws Throwable {
                    final Set<String> transientKeys = new HashSet<>(metadata.transientSettings().keySet());
import java.util.List;
            @Override
    ) {
        return annotation == null ? Scope.SUITE : annotation.scope();
    }
                OpenSearchTestCase.checkStaticState(true);
            );
        final ParameterizedOpenSearchIntegTestCase instance,
        final OpenSearchIntegTestCase instance = (OpenSearchIntegTestCase) target;
import org.apache.logging.log4j.Logger;
    }
                0,
     * The current cluster depending on the configured {@link Scope}.
            printTestMessage("setting up", method);
        });
                                printTestMessage("new instance of parameterized test class, recreating test cluster for suite");
                    }
    }
                    } catch (Throwable t) {
        }
            restClient = createRestClient();
    TestCluster cluster() {
                setup.call();
import org.opensearch.common.Nullable;
                        errors.add(t);
            suiteSeed = null;
        return createRestClient(null, "http");
        logger.info("[{}]: {} suite", getTestClass().getSimpleName(), message);
     * By default if no {@link ClusterScope} is configured this will hold a reference to the suite cluster.
    }
            instance = target;
                    // close the previous one and create a new one
        RestClientBuilder builder = RestClient.builder(hosts.toArray(new HttpHost[0]));
        // need to check that there are no more in-flight search contexts before
        }
                try {
                } else {
         */
            printTestMessage("cleaned up after", method);
            case TEST:
            clusters.put(clazz, testCluster);
                if (afterClass || currentClusterScope == Scope.TEST) {
        }
            }
                    Metadata metadata = clientForAnyNode().admin().cluster().prepareState().execute().actionGet().getState().getMetadata();
                printTestMessage("setup", method);
        final Class<?> targetClass = getTestClass();
    public Statement apply(Statement base, FrameworkMethod method, Object target) {
                    if (cluster != null) {
        // Deleting indices is going to clear search contexts implicitly so we
    protected void after(Object target, FrameworkMethod method) throws Exception {
     */
        assert suiteInstance == null;
        if (instance == null) {
            }
        return client;
        }
        if (!isInternalCluster()) {
                if (hasParametersChanged(
        }
                    printTestMessage("new instance of parameterized test class, recreating cluster scope", method);
            }
    private void printTestMessage(String message) {
        return currentCluster;
                    try {
                break;
            currentCluster.beforeTest(OpenSearchTestCase.random());
                break;
        Callable<Void> setup = () -> {
                            if (hasParametersChanged(
    private OpenSearchIntegTestCase suiteInstance = null; // see @SuiteScope
    void beforeClass() throws Exception {
import java.util.HashSet;
import org.opensearch.cluster.metadata.Metadata;
 * this file be licensed under the Apache-2.0 license or a
import com.carrotsearch.randomizedtesting.RandomizedContext;
        if (node != null) {
            public void evaluate() throws Throwable {
import org.opensearch.common.network.NetworkAddress;
        instance.ensureAllSearchContextsReleased();
    protected final void beforeInternal(OpenSearchIntegTestCase target) throws Exception {
            } else {
    }
          Note we create these test class instance via reflection
            target.randomIndexTemplate();
            if (target instanceof ParameterizedOpenSearchIntegTestCase) {
                instance.ensureClusterSizeConsistency();
                    + RestCancellableNodeClient.class.getSimpleName()
    }
        for (NodeInfo node : nodes) {
                RandomizedContext.current().runWithPrivateRandomness(suiteSeed, setup);
                } finally {
 *
                }
                                IOUtils.closeWhileHandlingException(testCluster);
        }
                    if (testCluster == null) { // only build if it's not there yet
            int numChannels = RestCancellableNodeClient.getNumChannels();
import org.opensearch.transport.client.Client;
                    }
        };
    private void printTestMessage(String message, FrameworkMethod method) {
        suiteSeed = OpenSearchTestCase.randomLong();
        } finally {
    }
                            )) {
    private TestCluster currentCluster = null;
        return OpenSearchTestCase.getTestClass();
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
    // Maps each TestCluster instance to the exact test suite instance that triggered its creation
        switch (currentClusterScope) {
            }
            return Optional.of((InternalTestCluster) cluster());
            suiteInstance = target;
            currentCluster = null;
                    IOUtils.closeWhileHandlingException(cluster);
                clearClusters();
        return createRestClient(nodesInfoResponse.getNodes(), httpClientConfigCallback, protocol);
    }
        final OpenSearchIntegTestCase instance = (OpenSearchIntegTestCase) target;
        if (restClient == null) {
        return new Statement() {
 * please subclass {@link ParameterizedStaticSettingsOpenSearchIntegTestCase} or {@link ParameterizedDynamicSettingsOpenSearchIntegTestCase}, depending
            StrictCheckSpanProcessor.validateTracingStateOnShutdown();
 * The JUnit {@link MethodRule} that handles test method scoped and test suite scoped clusters for integration (internal cluster) tests. There rule is
                    (ParameterizedOpenSearchIntegTestCase) target
 * The OpenSearch Contributors require contributions made to
            }
                printTestMessage("cleaning up after");
        return (cluster() instanceof InternalTestCluster);
    }
class OpenSearchTestClusterRule implements MethodRule {
            if (runTestScopeLifecycle()) {
 * SPDX-License-Identifier: Apache-2.0
    private final Map<Class<?>, TestCluster> clusters = new IdentityHashMap<>();
import org.opensearch.core.common.transport.TransportAddress;
                    afterClass();
    }
                        if (instance != null) {
        }
    private final Map<TestCluster, OpenSearchIntegTestCase> suites = new IdentityHashMap<>();
                }
    /**
    }
                        }
        return suiteInstance == null;
        if (httpClientConfigCallback != null) {
    private void initializeSuiteScope(OpenSearchIntegTestCase target, FrameworkMethod method) throws Exception {
package org.opensearch.test;
                            }
        }
    }
                before(target, method);
    ) {
            return null;
                clearClusters(); // it is ok to leave persistent / transient cluster state behind if scope is TEST
        }
                        final OpenSearchIntegTestCase instance = suites.get(testCluster);
        // if we are not annotated assume suite!
        internalCluster().ifPresent(c -> c.setBootstrapClusterManagerNodeIndex(-1));
                case SUITE:
                }
import static org.junit.Assert.assertThat;
 */
                    assertThat("test leaves transient cluster metadata behind", transientKeys, empty());
        return clazz.getAnnotation(SuiteScopeTestCase.class) != null;
                        testCluster = buildWithPrivateContext(currentClusterScope, seed, target);
                suites.clear();
    }
            currentCluster.wipe(target.excludeTemplates());
            if (cluster() != null) {
            printTestMessage("cleaning up after", method);
                        suites.remove(cluster);
            return internalCluster().orElseThrow(() -> new UnsupportedOperationException("current test cluster is immutable")).client(node);
        };
        return clientForNode(null);
        return !instance.hasSameParametersAs(target);
import java.util.Set;
        }
            beforeInternal(instance);
                                (ParameterizedOpenSearchIntegTestCase) target
    protected RestClient createRestClient() {
    }
                    assertThat("test leaves persistent cluster metadata behind", persistentKeys, empty());
    }
        }
    private Long suiteSeed = null;
                    IOUtils.closeWhileHandlingException(testCluster);
        Client client = cluster().client();
        final ParameterizedOpenSearchIntegTestCase target
        final Scope currentClusterScope = getClusterScope(getTestClass());
    protected RestClient createRestClient(
        ClusterScope annotation = OpenSearchIntegTestCase.getAnnotation(clazz, ClusterScope.class);
            try {
        if (suiteInstance != null) {
                currentCluster = buildAndPutCluster(currentClusterScope, suiteSeed, target);
            }
import java.util.IdentityHashMap;
                    return; /* same test class instance */
            suiteInstance = null;
                    afterClass();
    @Override
                clusters.clear();
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
            suiteInstance = null;
    Client clientForNode(@Nullable String node) {
                success = true;
        } else {
    }
        }
import java.util.Optional;
import org.junit.runners.model.FrameworkMethod;
                numChannels
                            assert instance instanceof ParameterizedOpenSearchIntegTestCase;
                hosts.add(new HttpHost(protocol, NetworkAddress.format(address.getAddress()), address.getPort()));
    }
    private Scope getClusterScope(Class<?> clazz) {
            restClient.close();
                assert suiteSeed != null : "Suite seed was not initialized";
import static org.junit.Assert.assertFalse;
        if (runTestScopeLifecycle()) {
            case SUITE:
            return Optional.empty();
    private static Class<?> getTestClass() {
    private static boolean isSuiteScopedTest(Class<?> clazz) {
        synchronized (clusters) {
            builder.setHttpClientConfigCallback(httpClientConfigCallback);
        return restClient;
                }
                if (currentClusterScope != Scope.TEST) {
                List<Throwable> errors = new ArrayList<Throwable>();
                } catch (Throwable t) {
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
    void afterClass() throws Exception {
                assert suiteInstance instanceof ParameterizedOpenSearchIntegTestCase;
                numChannels
    Client clientForAnyNode() {
            if (node.getInfo(HttpInfo.class) != null) {
                instance.ensureClusterStateConsistency();
        // we remove indices
    }
                instance.beforeIndexDeletion();
        try {
            client = new RandomizingClient(client, OpenSearchTestCase.random());
            if (currentClusterScope == Scope.TEST) {
                        suites.put(testCluster, target);
        if (runTestScopeLifecycle()) {
        if (isSuiteScopedTest(targetClass)) {
import org.junit.rules.MethodRule;
import org.opensearch.test.telemetry.tracing.StrictCheckSpanProcessor;
            } finally {
    }
import org.apache.logging.log4j.LogManager;
}
 * injected into {@link OpenSearchIntegTestCase} that every integration test suite should be subclassing. In case of the parameterized test suites,
import java.net.InetSocketAddress;
        }
                synchronized (clusters) {
    }
                    final TestCluster cluster = clusters.remove(getTestClass());
    private RestClient restClient = null;
    Optional<InternalTestCluster> internalCluster() {
/*
                    cluster().close();
                return; /* not a parameterized test */
                    (ParameterizedOpenSearchIntegTestCase) suiteInstance,
            // Catching the case when parameterized test cases are run: the test class stays the same but the test instances changes.
    }
    private static boolean hasParametersChanged(
                case TEST:
import org.junit.runners.model.Statement;
                )) {
                    + " channels still being tracked in "
                    beforeClass();
            switch (currentClusterScope) {
        NodesInfoResponse nodesInfoResponse = clientForAnyNode().admin().cluster().prepareNodesInfo().get();
        if (restClient != null) {
    }
        OpenSearchTestCase.assertBusy(() -> {
            }
    private TestCluster buildWithPrivateContext(final Scope scope, final long seed, OpenSearchIntegTestCase target) throws Exception {
        } finally {
        }
                    + " while there should be none",
    }
 */
        logger.info("[{}#{}]: {} test", getTestClass().getSimpleName(), method.getName(), message);
    private TestCluster buildAndPutCluster(Scope currentClusterScope, long seed, OpenSearchIntegTestCase target) throws Exception {
import org.opensearch.test.OpenSearchIntegTestCase.SuiteScopeTestCase;
        internalCluster().ifPresent(InternalTestCluster::clearDisruptionScheme);
                                testCluster = null;
        final List<NodeInfo> nodes,
    }
    boolean isInternalCluster() {
                    final Set<String> persistentKeys = new HashSet<>(metadata.persistentSettings().keySet());
            boolean success = false;
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
    private final Logger logger = LogManager.getLogger(getClass());
          since JUnit creates a new instance per test.
            }
import org.opensearch.rest.action.RestCancellableNodeClient;
    }
                MultipleFailureException.assertEmpty(errors);
            afterInternal(false, instance);
        }
                    testCluster = target.buildTestCluster(currentClusterScope, seed);
import org.opensearch.common.util.io.IOUtils;
                currentCluster = buildAndPutCluster(currentClusterScope, OpenSearchTestCase.randomLong(), target);
import java.util.concurrent.Callable;
                    errors.add(t);
            if (!clusters.isEmpty()) {
import org.junit.runners.model.MultipleFailureException;
            printTestMessage("all set up", method);
            }
        }
import org.opensearch.client.RestClient;
        initializeSuiteScope(instance, method);
        synchronized (clusters) {
    }
                afterInternal(true, null);
                    base.evaluate();
    private Statement statement(final Statement base, FrameworkMethod method, Object target) {
/**
                    if (testCluster != null && target instanceof ParameterizedOpenSearchIntegTestCase) {
            return testCluster;
        List<HttpHost> hosts = new ArrayList<>();
            OpenSearchTestCase.assertEquals(
                suiteInstance.setupSuiteScopeCluster();
import org.apache.hc.core5.http.HttpHost;
                InetSocketAddress address = publishAddress.address();
                beforeInternal(target);
        return builder.build();
    }
import static org.hamcrest.Matchers.empty;
        final Scope currentClusterScope = getClusterScope(target.getClass());
        OpenSearchIntegTestCase instance = suiteInstance;
        final Class<?> clazz = target.getClass();
import java.util.ArrayList;
 * on the way cluster settings are being managed.
                    }
        /*
        if (OpenSearchTestCase.frequently()) {
            restClient = null;
import org.opensearch.http.HttpInfo;
import java.util.Map;
