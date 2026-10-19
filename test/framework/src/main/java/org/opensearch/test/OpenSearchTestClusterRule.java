            printTestMessage("cleaning up after", method);  
                clearClusters();
        return restClient;  
    }
import org.opensearch.core.common.transport.TransportAddress;
            printTestMessage("setting up", method);
    void afterClass() throws Exception {
                case TEST:
    @Override
            suiteInstance = null;  
        suiteSeed = OpenSearchTestCase.randomLong();
            suiteInstance = null;
        if (suiteInstance != null) {
                if (currentClusterScope != Scope.TEST) {  
                    Metadata metadata = clientForAnyNode().admin().cluster().prepareState().execute().actionGet().getState().getMetadata();
        return currentCluster;
        try {
    private TestCluster buildAndPutCluster(Scope currentClusterScope, long seed, OpenSearchIntegTestCase target) throws Exception {
import org.opensearch.action.admin.cluster.node.info.NodeInfo;  
                numChannels
        } finally {
                    + RestCancellableNodeClient.class.getSimpleName()
/**  
import java.util.concurrent.Callable;  
            return testCluster;  
    private void afterInternal(boolean afterClass, OpenSearchIntegTestCase target) throws Exception {
                    testCluster = target.buildTestCluster(currentClusterScope, seed);
        if (isSuiteScopedTest(targetClass)) {
    ) {
import java.util.Map;  
        logger.info("[{}]: {} suite", getTestClass().getSimpleName(), message);
import static org.junit.Assert.assertFalse;  
        if (OpenSearchTestCase.frequently()) {
                instance.ensureClusterSizeConsistency();  
                List<Throwable> errors = new ArrayList<Throwable>();  
    }  
                    } catch (Throwable t) {
 *
        final ParameterizedOpenSearchIntegTestCase instance,  
    }
            suiteSeed = null;
            clusters.put(clazz, testCluster);
    }
        };
                    beforeClass();  
                    }
    protected RestClient createRestClient(RestClientBuilder.HttpClientConfigCallback httpClientConfigCallback, String protocol) {
        // if we are not annotated assume suite!
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
        }
                clusters.clear();
import org.opensearch.transport.client.Client;
    private final Map<TestCluster, OpenSearchIntegTestCase> suites = new IdentityHashMap<>();
        logger.info("[{}#{}]: {} test", getTestClass().getSimpleName(), method.getName(), message);
          since JUnit creates a new instance per test.  
                printTestMessage("setup", method);  
        initializeSuiteScope(instance, method);
    }  
            if (currentClusterScope == Scope.TEST) {
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
    }  
            } finally {
import java.util.List;
    private static Class<?> getTestClass() {
                    if (testCluster == null) { // only build if it's not there yet  
                    + " while there should be none",
        if (runTestScopeLifecycle()) {
                } catch (Throwable t) {  
    private TestCluster currentCluster = null;
            if (target instanceof ParameterizedOpenSearchIntegTestCase) {
                    try {  
        return clientForNode(null);  
            }  
        }  
        }
                    final TestCluster cluster = clusters.remove(getTestClass());
                            }
        }
                } finally {
        return statement(base, method, target);  
        }
                    afterClass();
                case SUITE:
                    errors.add(t);
    }
    public Statement apply(Statement base, FrameworkMethod method, Object target) {
     * The current cluster depending on the configured {@link Scope}.
    TestCluster cluster() {
            currentCluster.wipe(target.excludeTemplates());
        });  
            case SUITE:  
    protected RestClient createRestClient() {  
        return OpenSearchTestCase.getTestClass();  
                        suites.remove(cluster);
        };
            printTestMessage("all set up", method);
    private Long suiteSeed = null;
            }
    private void printTestMessage(String message) {
    }  
                }
        List<HttpHost> hosts = new ArrayList<>();  
                hosts.add(new HttpHost(protocol, NetworkAddress.format(address.getAddress()), address.getPort()));
                0,  
    }
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
    private static boolean hasParametersChanged(
        if (runTestScopeLifecycle()) {
import java.net.InetSocketAddress;
        }
        // we remove indices
                return; /* not a parameterized test */
    boolean isInternalCluster() {
                    if (testCluster != null && target instanceof ParameterizedOpenSearchIntegTestCase) {  
                    }
            TestCluster testCluster = clusters.remove(clazz); // remove this cluster first
    // Maps each TestCluster instance to the exact test suite instance that triggered its creation
    }  
        internalCluster().ifPresent(c -> c.setBootstrapClusterManagerNodeIndex(-1));
            currentCluster.beforeTest(OpenSearchTestCase.random());  
    }
        }
    Optional<InternalTestCluster> internalCluster() {  
    }  
        }
}
            int numChannels = RestCancellableNodeClient.getNumChannels();  
        } else {  
    protected RestClient createRestClient(
        assertFalse(nodesInfoResponse.hasFailures());  
import org.junit.rules.MethodRule;
        return !instance.hasSameParametersAs(target);  
 */
        return client;
        final OpenSearchIntegTestCase instance = (OpenSearchIntegTestCase) target;
        synchronized (clusters) {
    }
                InetSocketAddress address = publishAddress.address();
        return (cluster() instanceof InternalTestCluster);  
        final List<NodeInfo> nodes,
        }
         */
    private void clearClusters() throws Exception {
                currentCluster = buildAndPutCluster(currentClusterScope, suiteSeed, target);
        if (httpClientConfigCallback != null) {  
                    break;
import org.junit.runners.model.FrameworkMethod;  
        instance.ensureAllSearchContextsReleased();
import org.opensearch.rest.action.RestCancellableNodeClient;
        }
import java.util.Optional;
                )) {  
                    break;  
                IOUtils.close(clusters.values());
                    + " channels still being tracked in "  
        }  
            currentCluster = null;
        OpenSearchTestCase.assertBusy(() -> {
    private Scope getClusterScope(Class<?> clazz) {  
import org.opensearch.common.network.NetworkAddress;  
     * By default if no {@link ClusterScope} is configured this will hold a reference to the suite cluster.
            suiteInstance = target;
    void beforeClass() throws Exception {  
                    }
    private TestCluster buildWithPrivateContext(final Scope scope, final long seed, OpenSearchIntegTestCase target) throws Exception {  
        // need to check that there are no more in-flight search contexts before  
            StrictCheckSpanProcessor.validateTracingStateOnShutdown();
    }
        /*
                before(target, method);
        String protocol
                numChannels
package org.opensearch.test;
import org.opensearch.test.client.RandomizingClient;
            if (!clusters.isEmpty()) {
                if (!success) {
    private boolean runTestScopeLifecycle() {  
                    final Set<String> persistentKeys = new HashSet<>(metadata.persistentSettings().keySet());  
        ClusterScope annotation = OpenSearchIntegTestCase.getAnnotation(clazz, ClusterScope.class);
                clearClusters(); // it is ok to leave persistent / transient cluster state behind if scope is TEST  
        if (instance == null) {  
 * compatible open source license.
            if (cluster() != null) {
                    (ParameterizedOpenSearchIntegTestCase) suiteInstance,
            afterInternal(false, instance);
            OpenSearchTestCase.assertEquals(
            public void evaluate() throws Throwable {  
 */  
                        after(target, method);
                        if (instance != null) {
        }
    }
            return Optional.empty();
    }
        }  
                beforeInternal(target);
     */  
        RestClientBuilder builder = RestClient.builder(hosts.toArray(new HttpHost[0]));
                break;
            );
class OpenSearchTestClusterRule implements MethodRule {  
                            )) {
        } finally {  
        switch (currentClusterScope) {
    }
import java.util.ArrayList;
                        suites.put(testCluster, target);
            client = new RandomizingClient(client, OpenSearchTestCase.random());  
        }
        }  
    private static boolean isSuiteScopedTest(Class<?> clazz) {
          Note we create these test class instance via reflection
            printTestMessage("cleaned up after", method);
    private RestClient restClient = null;
            }
                    afterClass();  
        if (!isInternalCluster()) {
import org.apache.logging.log4j.LogManager;
    }
    }
    }  
        final ParameterizedOpenSearchIntegTestCase target
            try {
                        }  
            if (node.getInfo(HttpInfo.class) != null) {
                }
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.empty;
                suites.clear();  
    protected void before(Object target, FrameworkMethod method) throws Throwable {  
        RestClientBuilder.HttpClientConfigCallback httpClientConfigCallback,  
        return suiteInstance == null;
import java.util.IdentityHashMap;
                if (hasParametersChanged(  
                printTestMessage("cleaning up after");  
        for (NodeInfo node : nodes) {
                instance.beforeIndexDeletion();  
            switch (currentClusterScope) {
import java.util.Set;
import org.junit.runners.model.Statement;
                cluster().wipe(instance.excludeTemplates()); // wipe after to make sure we fail in the test that didn't ack the delete
                }
import org.opensearch.test.OpenSearchIntegTestCase.SuiteScopeTestCase;
            @Override
        return annotation == null ? Scope.SUITE : annotation.scope();  
        } else {  
                MultipleFailureException.assertEmpty(errors);  
    protected void after(Object target, FrameworkMethod method) throws Exception {
import com.carrotsearch.randomizedtesting.RandomizedContext;
import org.opensearch.client.RestClientBuilder;  
                TransportAddress publishAddress = node.getInfo(HttpInfo.class).address().publishAddress();  
                    cluster().close();  
        final OpenSearchIntegTestCase instance = (OpenSearchIntegTestCase) target;  
                if (afterClass || currentClusterScope == Scope.TEST) {
    }
                }
                instance.ensureClusterStateConsistency();
import java.util.HashSet;  
                    printTestMessage("new instance of parameterized test class, recreating cluster scope", method);
            instance = target;
        OpenSearchIntegTestCase instance = suiteInstance;
                    if (cluster != null) {  
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.client.RestClient;
            clearClusters(); // all leftovers are gone by now... this is really just a double safety if we miss something somewhere  
import org.opensearch.test.telemetry.tracing.StrictCheckSpanProcessor;  
                break;
    }  
        // Deleting indices is going to clear search contexts implicitly so we
 * injected into {@link OpenSearchIntegTestCase} that every integration test suite should be subclassing. In case of the parameterized test suites,
            } else {
                    final Set<String> transientKeys = new HashSet<>(metadata.transientSettings().keySet());  
import static org.junit.Assert.assertThat;
                try {
            return Optional.of((InternalTestCluster) cluster());
 * The OpenSearch Contributors require contributions made to  
        final Class<?> clazz = target.getClass();
                                printTestMessage("new instance of parameterized test class, recreating test cluster for suite");  
import org.apache.logging.log4j.Logger;
            boolean success = false;
            return internalCluster().orElseThrow(() -> new UnsupportedOperationException("current test cluster is immutable")).client(node);
        final Scope currentClusterScope = getClusterScope(target.getClass());
                setup.call();
            }
                }  
    ) {
                    base.evaluate();
    private OpenSearchIntegTestCase suiteInstance = null; // see @SuiteScope
    protected final void beforeInternal(OpenSearchIntegTestCase target) throws Exception {  
import org.apache.hc.core5.http.HttpHost;  
            }
        }
            }
    }
import org.junit.runners.model.MultipleFailureException;
        synchronized (clusters) {  
        final Scope currentClusterScope = getClusterScope(getTestClass());
        try {
import org.opensearch.common.Nullable;
        return RandomizedContext.current().runWithPrivateRandomness(seed, () -> target.buildTestCluster(scope, seed));
        return createRestClient(nodesInfoResponse.getNodes(), httpClientConfigCallback, protocol);
                            if (hasParametersChanged(
            }  
        internalCluster().ifPresent(InternalTestCluster::clearDisruptionScheme);  
                } else {
import org.opensearch.cluster.metadata.Metadata;
            return null;  
            } else {
            restClient = null;  
                RandomizedContext.current().runWithPrivateRandomness(suiteSeed, setup);  
                                testCluster = null;
    Client clientForNode(@Nullable String node) {  
        }
                afterInternal(true, null);
            }
            beforeInternal(instance);  
        if (node != null) {
                cluster().assertAfterTest();
    private void initializeSuiteScope(OpenSearchIntegTestCase target, FrameworkMethod method) throws Exception {
        Callable<Void> setup = () -> {
            // Catching the case when parameterized test cases are run: the test class stays the same but the test instances changes.  
        Client client = cluster().client();
        return clazz.getAnnotation(SuiteScopeTestCase.class) != null;
                suiteInstance.setupSuiteScopeCluster();
                OpenSearchTestCase.checkStaticState(true);
        if (restClient == null) {  
                synchronized (clusters) {  
        return new Statement() {
 * this file be licensed under the Apache-2.0 license or a
                    assertThat("test leaves persistent cluster metadata behind", persistentKeys, empty());
    private Statement statement(final Statement base, FrameworkMethod method, Object target) {  
 * please subclass {@link ParameterizedStaticSettingsOpenSearchIntegTestCase} or {@link ParameterizedDynamicSettingsOpenSearchIntegTestCase}, depending  
                    // close the previous one and create a new one  
                success = true;  
                    assertThat("test leaves transient cluster metadata behind", transientKeys, empty());
        assert suiteInstance == null;  
        return builder.build();  
        final Class<?> targetClass = getTestClass();  
    /**  
            if (runTestScopeLifecycle()) {  
    private void printTestMessage(String message, FrameworkMethod method) {  
                }  
                currentCluster = buildAndPutCluster(currentClusterScope, OpenSearchTestCase.randomLong(), target);  
    }  
            case TEST:
                    IOUtils.closeWhileHandlingException(cluster);
    private final Logger logger = LogManager.getLogger(getClass());
                        errors.add(t);  
/*  
            target.randomIndexTemplate();
                    return; /* same test class instance */
            restClient.close();
    }
                    (ParameterizedOpenSearchIntegTestCase) target
                                (ParameterizedOpenSearchIntegTestCase) instance,
    }
                assert suiteInstance instanceof ParameterizedOpenSearchIntegTestCase;
 * The JUnit {@link MethodRule} that handles test method scoped and test suite scoped clusters for integration (internal cluster) tests. There rule is
    }
import org.opensearch.http.HttpInfo;  
            builder.setHttpClientConfigCallback(httpClientConfigCallback);
            restClient = createRestClient();
                                (ParameterizedOpenSearchIntegTestCase) target  
    }
        if (restClient != null) {
                                IOUtils.closeWhileHandlingException(testCluster);
                    }  
                        testCluster = buildWithPrivateContext(currentClusterScope, seed, target);
    synchronized RestClient getRestClient() {
            }  
                        final OpenSearchIntegTestCase instance = suites.get(testCluster);
        NodesInfoResponse nodesInfoResponse = clientForAnyNode().admin().cluster().prepareNodesInfo().get();
                assert suiteSeed != null : "Suite seed was not initialized";
                instance.ensureClusterStateCanBeReadByNodeTool();
        return createRestClient(null, "http");
 * on the way cluster settings are being managed.
                            assert instance instanceof ParameterizedOpenSearchIntegTestCase;  
    private final Map<Class<?>, TestCluster> clusters = new IdentityHashMap<>();  
                    IOUtils.closeWhileHandlingException(testCluster);
    Client clientForAnyNode() {
