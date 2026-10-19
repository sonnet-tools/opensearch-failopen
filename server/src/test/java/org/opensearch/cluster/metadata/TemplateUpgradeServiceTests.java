    List<String> randomIndexPatterns() {
                int prevUpdatesInProgress = service.upgradesInProgress.get();
        }  
            IndexTemplateMetadata.builder("removed_test_template").patterns(randomIndexPatterns()).build(),  
import static org.opensearch.test.ClusterServiceUtils.setState;
        IllegalStateException ise = expectThrows(IllegalStateException.class, () -> service.upgradeTemplates(additions, deletions));  
        setState(clusterService, state);
        assertThat(changedInvocation.availablePermits(), equalTo(0));  
                );
        assertThat(updateInvocation.availablePermits(), equalTo(0));
                super.clusterChanged(event);
        removedListener.getAndSet(null).onFailure(new RuntimeException("test - ignore"));
            );
    public void tearDownTest() throws Exception {
            );  
import org.opensearch.common.util.concurrent.ThreadContextAccess;
        setState(clusterService, state);
            return templates;
import org.junit.After;
        Metadata.Builder builder = Metadata.builder();
                    assertThat(changes.v1().get("changed_test_template"), notNullValue());
 *     http://www.apache.org/licenses/LICENSE-2.0
        final TemplateUpgradeService service = new TemplateUpgradeService(null, clusterService, threadPool, Arrays.asList(templates -> {
            } else {  
    @Before
        }
        assertThat(deleteTemplateListeners, hasSize(deletionsCount));
import org.opensearch.core.action.ActionListener;
                final Map<String, IndexTemplateMetadata> templates
        };
            assertNotNull(templates.remove("removed_test_template"));  
import java.util.Map;
            deletions.add("remove_template_" + i);  
            return null;
            }
        final Semaphore updateInvocation = new Semaphore(0);
        AdminClient mockAdminClient = mock(AdminClient.class);
 */
public class TemplateUpgradeServiceTests extends OpenSearchTestCase {
        return IntStream.range(0, between(1, 10)).mapToObj(n -> randomUnicodeOfCodepointLengthBetween(1, 100)).collect(Collectors.toList());
            if (shouldAdd) {
        assertThat(finishInvocation.availablePermits(), equalTo(0));
        for (int i = 0; i < deletionsCount; i++) {
        finishInvocation.acquire(3);  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;  
        doAnswer(invocation -> {
 * the Apache License, Version 2.0 (the "License"); you may
        final Semaphore finishInvocation = new Semaphore(0);
            } else {  
        assertThat(changedInvocation.availablePermits(), equalTo(0));
            return templates;  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                );
            Optional<Tuple<Map<String, BytesReference>, Set<String>>> calculateTemplateChanges(
import org.opensearch.threadpool.ThreadPool;
                if (shouldChange) {  
    }
        for (int i = 0; i < additionsCount; i++) {
            ) {  
        changedInvocation.acquire();  
        new TemplateUpgradeService(mockClient, clusterService, threadPool, Arrays.asList(templates -> {  
        ClusterState prevState = ClusterState.EMPTY_STATE;
                int prevUpdatesInProgress = service.upgradesInProgress.get();
        threadPool = new TestThreadPool("TemplateUpgradeServiceTests");  
        }
    @After
            return templates;
                IndexMetadata.builder(randomAlphaOfLength(10))
            return templates;
            return null;  
import org.opensearch.Version;
        final AtomicReference<ActionListener<AcknowledgedResponse>> changedListener = new AtomicReference<>();  
 * under the License.  
import static org.hamcrest.CoreMatchers.nullValue;
        final AtomicReference<ActionListener<AcknowledgedResponse>> addedListener = new AtomicReference<>();
        Optional<Tuple<Map<String, BytesReference>, Set<String>>> optChanges = service.calculateTemplateChanges(metadata.templates());
        changedInvocation.acquire();
        assertThat(updateInvocation.availablePermits(), equalTo(0));  
            );  
        // tryFinishUpgrade was skipped  
                () -> new AssertionError("Should have non empty changes")
            public void clusterChanged(ClusterChangedEvent event) {
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.node.DiscoveryNode;
        assertThat(calculateInvocation.availablePermits(), equalTo(0));
import static org.mockito.Mockito.when;  
import org.opensearch.threadpool.TestThreadPool;  
                    .build()
 * GitHub history for details.
import org.opensearch.common.util.concurrent.ThreadContext;  
                    assertThat(changes.v1().keySet(), hasSize(1));  
            PutIndexTemplateRequest request = (PutIndexTemplateRequest) args[0];
            void tryFinishUpgrade(AtomicBoolean anyUpgradeFailed) {
                templates.put(
        });
 *  
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
                super.tryFinishUpgrade(anyUpgradeFailed);
                finishInvocation.release();  
    @SuppressWarnings("unchecked")
            }
        assertThat(service.upgradesInProgress.get(), equalTo(2));
        // Make sure that update wasn't called this time since the index template metadata didn't change
import static org.mockito.Mockito.doAnswer;
                    .numberOfShards(randomIntBetween(1, 5))
    public void setUpTest() throws Exception {
    );  
        calculateInvocation.acquire();
        for (IndexTemplateMetadata template : templates) {
        assertThat(updateInvocation.availablePermits(), equalTo(0));
        }  
            return templates;  
        return builder.build();
        }, templates -> {
import static org.mockito.Mockito.any;  
    }
        assertThat(ise.getMessage(), containsString("template upgrade service should always happen in a system context"));
                    assertThat(changes.v1().keySet(), hasSize(1));
import org.opensearch.core.common.bytes.BytesReference;
            if (shouldChange) {
                final Optional<Tuple<Map<String, BytesReference>, Set<String>>> ans = super.calculateTemplateChanges(templates);
                    )
            return null;  
                )
import org.opensearch.cluster.node.DiscoveryNodes;  
            @Override  
        clusterService.close();
        if (shouldAdd || shouldRemove || shouldChange) {  
            builder.put(  
        }, templates -> {
            .build();
import static org.hamcrest.Matchers.containsString;
                assertNotNull(templates.remove("removed_test_template"));
import static org.mockito.Mockito.mock;
import java.util.Collections;
            IndexTemplateMetadata.builder("user_template").patterns(randomIndexPatterns()).build(),
    }
        }));
                    assertThat(changes.v1().keySet(), hasSize(2));
        removedListener.getAndSet(null).onResponse(new AcknowledgedResponse(true) {  
                calculateInvocation.release();
import java.util.stream.Collectors;
import java.util.concurrent.Semaphore;
        calculateInvocation.acquire();  
 * The OpenSearch Contributors require contributions made to  
        assertThat(calculateInvocation.availablePermits(), equalTo(0));
        when(mockAdminClient.indices()).thenReturn(mockIndicesAdminClient);
                assertThat(changes.v1().get("added_test_template"), notNullValue());
import java.util.stream.IntStream;  
 * software distributed under the License is distributed on an
        for (int i = 0; i < deletionsCount; i++) {
import org.opensearch.transport.client.Client;  
                    "changed_test_template",
 * license agreements. See the NOTICE file distributed with
                    .localNodeId("node1")
            assertThat(removedListener.getAndSet((ActionListener) args[1]), nullValue());
        }).when(mockIndicesAdminClient).deleteTemplate(any(DeleteIndexTemplateRequest.class), any(ActionListener.class));
        List<ActionListener<AcknowledgedResponse>> deleteTemplateListeners = new ArrayList<>();
                updateInvocation.release();  
            DeleteIndexTemplateRequest request = (DeleteIndexTemplateRequest) args[0];  
    public void testClusterStateUpdate() throws InterruptedException {  
            service.upgradeTemplates(additions, deletions);
        Set<String> deletions = new HashSet<>(deletionsCount);
            assert args.length == 2;  
        assertThat(updateInvocation.availablePermits(), equalTo(0));
        }
        updateInvocation.acquire();
        changedInvocation.acquire();
                fail("unexpected put template call for " + request.name());
            deleteTemplateListeners.add((ActionListener) args[1]);  
        addedListener.getAndSet(null).onResponse(new AcknowledgedResponse(true) {
            assert args.length == 2;
import static org.hamcrest.CoreMatchers.startsWith;  
        ClusterState state = ClusterState.builder(prevState)
                    IndexTemplateMetadata.builder("changed_test_template").patterns(Collections.singletonList("*")).order(10).build()  
        state = ClusterState.builder(prevState).metadata(Metadata.builder(state.metadata()).removeTemplate("user_template")).build();
 * Licensed to Elasticsearch under one or more contributor  
                assertThat(changes.v2(), empty());
 * SPDX-License-Identifier: Apache-2.0
        updateInvocation.acquire();
 * compatible open source license.
 * this work for additional information regarding copyright
        changedListener.getAndSet(null).onFailure(new RuntimeException("test - ignore"));  
import org.opensearch.test.OpenSearchTestCase;
        })) {
            } else {  
        }).when(mockIndicesAdminClient).putTemplate(any(PutIndexTemplateRequest.class), any(ActionListener.class));
                    assertThat(changes.v1().get("changed_test_template"), notNullValue());
import static java.util.Collections.emptyMap;
                }
    }  
                    .numberOfReplicas(randomIntBetween(0, 3))  
        addedListener.getAndSet(null).onFailure(new RuntimeException("test - ignore"));
import java.util.concurrent.atomic.AtomicBoolean;  
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (randomBoolean()) {
                        new DiscoveryNode("node1", "node1", buildNewFakeTransportAddress(), emptyMap(), MASTER_DATA_ROLES, Version.CURRENT)  
        prevState = state;  
    }
            }  
        });
                    .settings(settings(Version.CURRENT))
            IndexTemplateMetadata.builder("changed_test_template").patterns(randomIndexPatterns()).build()
                        "changed_test_template",
                assertThat(changes.v2(), hasSize(1));
                        IndexTemplateMetadata.builder("added_test_template").patterns(randomIndexPatterns()).build()  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.transport.client.IndicesAdminClient;
                    assertThat(changes.v1().keySet(), empty());
/*  
        Metadata metadata = randomMetadata(
            if (shouldAdd) {
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);  
        for (int i = 0; i < additionsCount; i++) {  
import org.opensearch.common.collect.Tuple;
    private ThreadPool threadPool;
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;
            )
        }, templates -> {
        // Make sure that update wasn't invoked since we are still running
                        "added_test_template",
            builder.put(template);  
            IndexTemplateMetadata.builder("changed_test_template").patterns(randomIndexPatterns()).build()
        assertThat(calculateInvocation.availablePermits(), equalTo(0));
        setState(clusterService, state);  
        clusterService = createClusterService(threadPool);
        Client mockClient = mock(Client.class);
            .nodes(  
 */  
 * specific language governing permissions and limitations
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
                assertThat(prevUpdatesInProgress - service.upgradesInProgress.get(), equalTo(1));  
        assertThat(finishInvocation.availablePermits(), equalTo(0));
        assertThat(finishInvocation.availablePermits(), equalTo(0));  
        when(mockClient.admin()).thenReturn(mockAdminClient);
 * You may obtain a copy of the License at  
        Map<String, BytesReference> additions = new HashMap<>(additionsCount);
                assertThat(addedListener.getAndSet((ActionListener) args[1]), nullValue());  
        final AtomicReference<ActionListener<AcknowledgedResponse>> removedListener = new AtomicReference<>();
        assertThat(changedInvocation.availablePermits(), equalTo(0));
}
import java.util.HashMap;
            Tuple<Map<String, BytesReference>, Set<String>> changes = optChanges.orElseThrow(
            PutIndexTemplateRequest request = (PutIndexTemplateRequest) args[0];
                assertNull(  
    private ClusterService clusterService;
                    .clusterManagerNodeId("node1")  
import static org.hamcrest.Matchers.empty;
                templates.put(
        Metadata metadata = randomMetadata(
                DiscoveryNodes.builder()
            }
                        IndexTemplateMetadata.builder("changed_test_template").patterns(randomIndexPatterns()).order(10).build()  
            additions.put("add_template_" + i, new BytesArray("{\"index_patterns\" : \"*\", \"order\" : " + i + "}"));
            Object[] args = invocation.getArguments();
            assertNull(
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.cluster.ClusterChangedEvent;
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.cluster.metadata;
            assert args.length == 2;  
import java.util.Optional;  
        );
                    templates.put(
        assertThat(putTemplateListeners, hasSize(additionsCount));
        threadPool.shutdownNow();  
import static org.hamcrest.Matchers.hasSize;
import org.opensearch.cluster.node.DiscoveryNodeRole;
        changedListener.getAndSet(null).onResponse(new AcknowledgedResponse(true) {
            if (request.name().equals("added_test_template")) {
            assertNotNull(  
            @Override  
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(calculateInvocation.availablePermits(), equalTo(0));  
        List<ActionListener<AcknowledgedResponse>> putTemplateListeners = new ArrayList<>();
                deleteTemplateListeners.get(i).onFailure(new RuntimeException("test - ignore"));
            Object[] args = invocation.getArguments();
            }
import org.opensearch.cluster.ClusterState;  
            }
    @SuppressWarnings("unchecked")
            .metadata(metadata)  
    public static Metadata randomMetadata(IndexTemplateMetadata... templates) {  
            return null;
            IndexTemplateMetadata.builder("user_template").patterns(randomIndexPatterns()).build(),
        assertThat(changedInvocation.availablePermits(), equalTo(0));  
import org.opensearch.core.common.bytes.BytesArray;  
        final ThreadContext threadContext = threadPool.getThreadContext();
                assertNotNull(  
        IndicesAdminClient mockIndicesAdminClient = mock(IndicesAdminClient.class);  
            return templates;
        }).when(mockIndicesAdminClient).deleteTemplate(any(DeleteIndexTemplateRequest.class), any(ActionListener.class));
                    "added_test_template",  
            IndexTemplateMetadata.builder("removed_test_template").patterns(randomIndexPatterns()).build(),  
        finishInvocation.acquire(3);
        calculateInvocation.acquire();
/*  
                });
            } else {
import java.util.List;
        setState(clusterService, state);
        IndicesAdminClient mockIndicesAdminClient = mock(IndicesAdminClient.class);  
import java.util.concurrent.atomic.AtomicReference;
        }).when(mockIndicesAdminClient).putTemplate(any(PutIndexTemplateRequest.class), any(ActionListener.class));
import org.junit.Before;  
                    )
    }  
                } else {
import java.util.Set;
        // Make sure that update was called this time since we are no longer running
                });
            Object[] args = invocation.getArguments();
        assertThat(calculateInvocation.availablePermits(), equalTo(0));
        int deletionsCount = randomIntBetween(0, 3);
            if (randomBoolean()) {  
 *
                deleteTemplateListeners.get(i).onResponse(new AcknowledgedResponse(randomBoolean()) {  
import java.util.ArrayList;
            assertThat(request.name(), equalTo("add_template_" + request.order()));
        when(mockAdminClient.indices()).thenReturn(mockIndicesAdminClient);
        assertThat(removedListener.get(), notNullValue());
/*
            putTemplateListeners.add((ActionListener) args[1]);  
import org.opensearch.transport.client.AdminClient;
import java.util.Arrays;  
        assertThat(calculateInvocation.availablePermits(), equalTo(0));  
        when(mockClient.admin()).thenReturn(mockAdminClient);
        final Semaphore calculateInvocation = new Semaphore(0);  
                    templates.put(
                if (shouldChange) {
 * this file be licensed under the Apache-2.0 license or a
            if (shouldRemove) {  
        boolean shouldChange = randomBoolean();
            } else if (request.name().equals("changed_test_template")) {
        boolean shouldAdd = randomBoolean();  
        assertThat(finishInvocation.availablePermits(), equalTo(0));  
import java.util.HashSet;  
                assertThat(prevUpdatesInProgress - service.upgradesInProgress.get(), equalTo(1));  
            Object[] args = invocation.getArguments();
                    )
            @Override  
    public void testCalculateChangesAddChangeAndDelete() {
        assertThat(finishInvocation.availablePermits(), equalTo(0));  
        Client mockClient = mock(Client.class);
            @Override  
        assertThat(addedListener.get(), notNullValue());
        new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
            } else {
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
                changedInvocation.release();  
        int additionsCount = randomIntBetween(0, 5);
                    .add(
        AdminClient mockAdminClient = mock(AdminClient.class);
        final Semaphore changedInvocation = new Semaphore(0);
                putTemplateListeners.get(i).onResponse(new AcknowledgedResponse(randomBoolean()) {
    public void testUpdateTemplates() {  
        }
            assertThat(request.name(), startsWith("removed_test_template"));
        boolean shouldRemove = randomBoolean();
        // 3 upgrades should be completed, in addition to the final calculate  
        );
                } else {  
 *
            assertThat(optChanges.isPresent(), equalTo(false));
            assertThat(request.name(), startsWith("remove_template_"));
            }
        }
        }, templates -> {
                    IndexTemplateMetadata.builder("added_test_template").patterns(Collections.singletonList("*")).build()
        }
        doAnswer(invocation -> {  
            }
        service.upgradesInProgress.set(additionsCount + deletionsCount + 2); // +2 to skip tryFinishUpgrade  
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequest;  
            DeleteIndexTemplateRequest request = (DeleteIndexTemplateRequest) args[0];
                assertThat(changedListener.getAndSet((ActionListener) args[1]), nullValue());
        assertThat(finishInvocation.availablePermits(), equalTo(0));
            }
            }
import static org.hamcrest.Matchers.equalTo;  
        doAnswer(invocation -> {
                assertThat(changes.v2().contains("removed_test_template"), equalTo(true));
            if (shouldRemove) {  
            }
            assert args.length == 2;  
        final TemplateUpgradeService service = new TemplateUpgradeService(mockClient, clusterService, threadPool, Collections.emptyList());
                super.upgradeTemplates(changes, deletions);
    }
        } else {  
        assertThat(changedListener.get(), notNullValue());  
        changedInvocation.acquire();
        });  
    private static final Set<DiscoveryNodeRole> MASTER_DATA_ROLES = Collections.unmodifiableSet(
 */  
            void upgradeTemplates(Map<String, BytesReference> changes, Set<String> deletions) {
                }  
                return ans;  
                putTemplateListeners.get(i).onFailure(new RuntimeException("test - ignore"));  
                )
        calculateInvocation.acquire();  
        doAnswer(invocation -> {
            );
