 */
                super.upgradeTemplates(changes, deletions);
            return null;
    @After
        AdminClient mockAdminClient = mock(AdminClient.class);
        if (shouldAdd || shouldRemove || shouldChange) {
                () -> new AssertionError("Should have non empty changes")
                int prevUpdatesInProgress = service.upgradesInProgress.get();
 * KIND, either express or implied.  See the License for the
import static java.util.Collections.emptyMap;
            );
        // Make sure that update wasn't invoked since we are still running
                assertNull(
import org.opensearch.transport.client.AdminClient;
        changedInvocation.acquire();
        return builder.build();
        calculateInvocation.acquire();
        clusterService.close();
            additions.put("add_template_" + i, new BytesArray("{\"index_patterns\" : \"*\", \"order\" : " + i + "}"));
    }
import java.util.ArrayList;
import org.opensearch.cluster.node.DiscoveryNode;
                );
        setState(clusterService, state);
import org.opensearch.core.common.bytes.BytesArray;
            .metadata(metadata)
        assertThat(updateInvocation.availablePermits(), equalTo(0));
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
            assertThat(request.name(), equalTo("add_template_" + request.order()));
            assertThat(request.name(), startsWith("remove_template_"));
            return null;
                } else {
            }
                assertThat(prevUpdatesInProgress - service.upgradesInProgress.get(), equalTo(1));
        int deletionsCount = randomIntBetween(0, 3);
            assert args.length == 2;
import static org.hamcrest.Matchers.empty;
        assertThat(calculateInvocation.availablePermits(), equalTo(0));
            return templates;
                int prevUpdatesInProgress = service.upgradesInProgress.get();
import org.opensearch.core.action.ActionListener;
 * The OpenSearch Contributors require contributions made to
        for (int i = 0; i < additionsCount; i++) {
            }
            .nodes(
            }
                        IndexTemplateMetadata.builder("added_test_template").patterns(randomIndexPatterns()).build()
                )
        assertThat(changedInvocation.availablePermits(), equalTo(0));
import java.util.Map;
import org.opensearch.core.common.bytes.BytesReference;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.junit.After;
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;
        setState(clusterService, state);
                final Optional<Tuple<Map<String, BytesReference>, Set<String>>> ans = super.calculateTemplateChanges(templates);
                    )
            if (shouldAdd) {
    );
        assertThat(service.upgradesInProgress.get(), equalTo(2));
        });
            Object[] args = invocation.getArguments();
        final Semaphore updateInvocation = new Semaphore(0);
        when(mockAdminClient.indices()).thenReturn(mockIndicesAdminClient);
        }, templates -> {
                assertNotNull(
                IndexMetadata.builder(randomAlphaOfLength(10))
/*
import java.util.Arrays;
                if (shouldChange) {
                } else {
        calculateInvocation.acquire();
                    .add(
 * under the License.
                assertThat(addedListener.getAndSet((ActionListener) args[1]), nullValue());
        assertThat(finishInvocation.availablePermits(), equalTo(0));
            @Override
            assertThat(request.name(), startsWith("removed_test_template"));
            if (shouldChange) {
                super.clusterChanged(event);
                super.tryFinishUpgrade(anyUpgradeFailed);
 * Unless required by applicable law or agreed to in writing,
        changedListener.getAndSet(null).onFailure(new RuntimeException("test - ignore"));
        IndicesAdminClient mockIndicesAdminClient = mock(IndicesAdminClient.class);
        final Semaphore calculateInvocation = new Semaphore(0);
 */
            }
            if (request.name().equals("added_test_template")) {
        }
            assertThat(removedListener.getAndSet((ActionListener) args[1]), nullValue());
                calculateInvocation.release();
        Set<String> deletions = new HashSet<>(deletionsCount);
import static org.hamcrest.CoreMatchers.nullValue;
                    .numberOfReplicas(randomIntBetween(0, 3))
 * license agreements. See the NOTICE file distributed with
        calculateInvocation.acquire();
                assertThat(changedListener.getAndSet((ActionListener) args[1]), nullValue());
        doAnswer(invocation -> {
import static org.hamcrest.Matchers.notNullValue;
        }).when(mockIndicesAdminClient).putTemplate(any(PutIndexTemplateRequest.class), any(ActionListener.class));
                    IndexTemplateMetadata.builder("added_test_template").patterns(Collections.singletonList("*")).build()
            if (shouldRemove) {
            );
    @SuppressWarnings("unchecked")
        // tryFinishUpgrade was skipped
        assertThat(addedListener.get(), notNullValue());
    public void testClusterStateUpdate() throws InterruptedException {
                    templates.put(
import org.junit.Before;
        }
        });
 * Licensed to Elasticsearch under one or more contributor
    private ClusterService clusterService;
import org.opensearch.common.util.concurrent.ThreadContext;
 *
        when(mockAdminClient.indices()).thenReturn(mockIndicesAdminClient);
            } else {
        state = ClusterState.builder(prevState).metadata(Metadata.builder(state.metadata()).removeTemplate("user_template")).build();
    }
        setState(clusterService, state);
        })) {
        final TemplateUpgradeService service = new TemplateUpgradeService(mockClient, clusterService, threadPool, Collections.emptyList());
        }).when(mockIndicesAdminClient).putTemplate(any(PutIndexTemplateRequest.class), any(ActionListener.class));
import static org.mockito.Mockito.doAnswer;
import java.util.stream.IntStream;
        AdminClient mockAdminClient = mock(AdminClient.class);
import static org.hamcrest.Matchers.equalTo;
            if (randomBoolean()) {
import org.opensearch.cluster.ClusterState;
import org.opensearch.common.collect.Tuple;
            @Override
            )
        Client mockClient = mock(Client.class);
    @Before
                assertNotNull(templates.remove("removed_test_template"));
                assertThat(prevUpdatesInProgress - service.upgradesInProgress.get(), equalTo(1));
            void tryFinishUpgrade(AtomicBoolean anyUpgradeFailed) {
        for (IndexTemplateMetadata template : templates) {
                    .settings(settings(Version.CURRENT))
import org.opensearch.cluster.service.ClusterService;
        }).when(mockIndicesAdminClient).deleteTemplate(any(DeleteIndexTemplateRequest.class), any(ActionListener.class));
/*
            void upgradeTemplates(Map<String, BytesReference> changes, Set<String> deletions) {
    }
            }
    public void testUpdateTemplates() {
        }
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            IndexTemplateMetadata.builder("changed_test_template").patterns(randomIndexPatterns()).build()
        IndicesAdminClient mockIndicesAdminClient = mock(IndicesAdminClient.class);
        finishInvocation.acquire(3);
                }
        prevState = state;
        assertThat(finishInvocation.availablePermits(), equalTo(0));
import org.opensearch.transport.client.IndicesAdminClient;
            if (randomBoolean()) {
    private static final Set<DiscoveryNodeRole> MASTER_DATA_ROLES = Collections.unmodifiableSet(
        assertThat(calculateInvocation.availablePermits(), equalTo(0));
import org.opensearch.test.OpenSearchTestCase;
            assert args.length == 2;
import java.util.stream.Collectors;
        }
        final AtomicReference<ActionListener<AcknowledgedResponse>> addedListener = new AtomicReference<>();
import org.opensearch.Version;
                        new DiscoveryNode("node1", "node1", buildNewFakeTransportAddress(), emptyMap(), MASTER_DATA_ROLES, Version.CURRENT)
            return templates;
                changedInvocation.release();
import java.util.concurrent.atomic.AtomicBoolean;
        assertThat(finishInvocation.availablePermits(), equalTo(0));
        removedListener.getAndSet(null).onFailure(new RuntimeException("test - ignore"));
                );
    }
        when(mockClient.admin()).thenReturn(mockAdminClient);
            }
        assertThat(deleteTemplateListeners, hasSize(deletionsCount));
        assertThat(removedListener.get(), notNullValue());
            if (shouldAdd) {
        removedListener.getAndSet(null).onResponse(new AcknowledgedResponse(true) {
        };
        final TemplateUpgradeService service = new TemplateUpgradeService(null, clusterService, threadPool, Arrays.asList(templates -> {
 * this work for additional information regarding copyright
            }
            }
        final AtomicReference<ActionListener<AcknowledgedResponse>> removedListener = new AtomicReference<>();
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
                assertThat(changes.v2(), empty());
            }
    @SuppressWarnings("unchecked")
        updateInvocation.acquire();
        for (int i = 0; i < additionsCount; i++) {
 * compatible open source license.
        addedListener.getAndSet(null).onFailure(new RuntimeException("test - ignore"));
        }, templates -> {
        new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
                templates.put(
        updateInvocation.acquire();
import static org.hamcrest.CoreMatchers.startsWith;
            PutIndexTemplateRequest request = (PutIndexTemplateRequest) args[0];
        final Semaphore finishInvocation = new Semaphore(0);
            IndexTemplateMetadata.builder("user_template").patterns(randomIndexPatterns()).build(),
            IndexTemplateMetadata.builder("user_template").patterns(randomIndexPatterns()).build(),
import org.opensearch.transport.client.Client;
import java.util.HashSet;
        );
 * not use this file except in compliance with the License.
        Optional<Tuple<Map<String, BytesReference>, Set<String>>> optChanges = service.calculateTemplateChanges(metadata.templates());
                    assertThat(changes.v1().get("changed_test_template"), notNullValue());
                    IndexTemplateMetadata.builder("changed_test_template").patterns(Collections.singletonList("*")).order(10).build()
import java.util.concurrent.atomic.AtomicReference;
        assertThat(calculateInvocation.availablePermits(), equalTo(0));
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(calculateInvocation.availablePermits(), equalTo(0));
 * ownership. Elasticsearch licenses this file to you under
        final Semaphore changedInvocation = new Semaphore(0);
            } else {
import static org.opensearch.test.ClusterServiceUtils.setState;
        List<ActionListener<AcknowledgedResponse>> deleteTemplateListeners = new ArrayList<>();
package org.opensearch.cluster.metadata;
        // Make sure that update was called this time since we are no longer running
import org.opensearch.common.util.concurrent.ThreadContextAccess;
 * You may obtain a copy of the License at
                    assertThat(changes.v1().keySet(), hasSize(1));
        Map<String, BytesReference> additions = new HashMap<>(additionsCount);
        assertThat(updateInvocation.availablePermits(), equalTo(0));
 */
    }
import org.opensearch.cluster.ClusterChangedEvent;
                assertThat(changes.v2(), hasSize(1));
        final AtomicReference<ActionListener<AcknowledgedResponse>> changedListener = new AtomicReference<>();
            builder.put(template);
 *
            return templates;
            assertNull(
            assert args.length == 2;
        assertThat(calculateInvocation.availablePermits(), equalTo(0));
            IndexTemplateMetadata.builder("changed_test_template").patterns(randomIndexPatterns()).build()
            .build();
            Object[] args = invocation.getArguments();
            deletions.add("remove_template_" + i);
        }));
        List<ActionListener<AcknowledgedResponse>> putTemplateListeners = new ArrayList<>();
 * GitHub history for details.
            } else {
            DeleteIndexTemplateRequest request = (DeleteIndexTemplateRequest) args[0];
            assertNotNull(
            public void clusterChanged(ClusterChangedEvent event) {
        clusterService = createClusterService(threadPool);
        ClusterState prevState = ClusterState.EMPTY_STATE;
        ClusterState state = ClusterState.builder(prevState)
                )
            assert args.length == 2;
            putTemplateListeners.add((ActionListener) args[1]);
        assertThat(finishInvocation.availablePermits(), equalTo(0));
        changedListener.getAndSet(null).onResponse(new AcknowledgedResponse(true) {
        assertThat(finishInvocation.availablePermits(), equalTo(0));
                        IndexTemplateMetadata.builder("changed_test_template").patterns(randomIndexPatterns()).order(10).build()
                    assertThat(changes.v1().keySet(), hasSize(2));
        }, templates -> {
        boolean shouldChange = randomBoolean();
import java.util.HashMap;
    private ThreadPool threadPool;
                    templates.put(
import org.opensearch.cluster.node.DiscoveryNodes;
        IllegalStateException ise = expectThrows(IllegalStateException.class, () -> service.upgradeTemplates(additions, deletions));
                templates.put(
 * SPDX-License-Identifier: Apache-2.0
        }
                finishInvocation.release();
        when(mockClient.admin()).thenReturn(mockAdminClient);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(changedInvocation.availablePermits(), equalTo(0));
            return templates;
            @Override
            Tuple<Map<String, BytesReference>, Set<String>> changes = optChanges.orElseThrow(
        addedListener.getAndSet(null).onResponse(new AcknowledgedResponse(true) {
import static org.hamcrest.Matchers.hasSize;
 * Modifications Copyright OpenSearch Contributors. See
        calculateInvocation.acquire();
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
        doAnswer(invocation -> {
                        "added_test_template",
        threadPool = new TestThreadPool("TemplateUpgradeServiceTests");
            if (shouldRemove) {
        new TemplateUpgradeService(mockClient, clusterService, threadPool, Arrays.asList(templates -> {
                        "changed_test_template",
            Optional<Tuple<Map<String, BytesReference>, Set<String>>> calculateTemplateChanges(
    public void tearDownTest() throws Exception {
        // 3 upgrades should be completed, in addition to the final calculate
import static org.mockito.Mockito.when;
        changedInvocation.acquire();
/*
            PutIndexTemplateRequest request = (PutIndexTemplateRequest) args[0];
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
import java.util.Collections;
                deleteTemplateListeners.get(i).onResponse(new AcknowledgedResponse(randomBoolean()) {
        assertThat(finishInvocation.availablePermits(), equalTo(0));
            }
    public static Metadata randomMetadata(IndexTemplateMetadata... templates) {
        Metadata metadata = randomMetadata(
                fail("unexpected put template call for " + request.name());
    public void testCalculateChangesAddChangeAndDelete() {
                if (shouldChange) {
                    .localNodeId("node1")
        setState(clusterService, state);
public class TemplateUpgradeServiceTests extends OpenSearchTestCase {
import org.opensearch.threadpool.ThreadPool;
                    assertThat(changes.v1().get("changed_test_template"), notNullValue());
import org.opensearch.cluster.node.DiscoveryNodeRole;
import java.util.Set;
import static org.mockito.Mockito.any;
                    .clusterManagerNodeId("node1")
                    "changed_test_template",
    }
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequest;
        );
                deleteTemplateListeners.get(i).onFailure(new RuntimeException("test - ignore"));
        // Make sure that update wasn't called this time since the index template metadata didn't change
        for (int i = 0; i < deletionsCount; i++) {
            builder.put(
        assertThat(changedInvocation.availablePermits(), equalTo(0));
            service.upgradeTemplates(additions, deletions);
                    )
            assertThat(optChanges.isPresent(), equalTo(false));
            return null;
            Object[] args = invocation.getArguments();
        }
        Metadata metadata = randomMetadata(
            } else {
            assertNotNull(templates.remove("removed_test_template"));
        changedInvocation.acquire();
                final Map<String, IndexTemplateMetadata> templates
        final ThreadContext threadContext = threadPool.getThreadContext();
            } else if (request.name().equals("changed_test_template")) {
        });
        assertThat(ise.getMessage(), containsString("template upgrade service should always happen in a system context"));
        changedInvocation.acquire();
            return templates;
        Metadata.Builder builder = Metadata.builder();
        assertThat(changedListener.get(), notNullValue());
        doAnswer(invocation -> {
                assertThat(changes.v1().get("added_test_template"), notNullValue());
            }
 *
            Object[] args = invocation.getArguments();
                });
        doAnswer(invocation -> {
                updateInvocation.release();
        int additionsCount = randomIntBetween(0, 5);
        }).when(mockIndicesAdminClient).deleteTemplate(any(DeleteIndexTemplateRequest.class), any(ActionListener.class));
        service.upgradesInProgress.set(additionsCount + deletionsCount + 2); // +2 to skip tryFinishUpgrade
        assertThat(updateInvocation.availablePermits(), equalTo(0));
import org.opensearch.threadpool.TestThreadPool;
                    .build()
import java.util.List;
            );
                });
                    "added_test_template",
            } else {
            IndexTemplateMetadata.builder("removed_test_template").patterns(randomIndexPatterns()).build(),
import java.util.concurrent.Semaphore;
        threadPool.shutdownNow();
        boolean shouldRemove = randomBoolean();
            return null;
        for (int i = 0; i < deletionsCount; i++) {
                putTemplateListeners.get(i).onResponse(new AcknowledgedResponse(randomBoolean()) {
                    assertThat(changes.v1().keySet(), empty());
                return ans;
        assertThat(changedInvocation.availablePermits(), equalTo(0));
            );
 * this file be licensed under the Apache-2.0 license or a
    public void setUpTest() throws Exception {
        } else {
import java.util.Optional;
}
                    assertThat(changes.v1().keySet(), hasSize(1));
        }
                }
                assertThat(changes.v2().contains("removed_test_template"), equalTo(true));
            @Override
                    .numberOfShards(randomIntBetween(1, 5))
import static org.mockito.Mockito.mock;
    List<String> randomIndexPatterns() {
            IndexTemplateMetadata.builder("removed_test_template").patterns(randomIndexPatterns()).build(),
        Client mockClient = mock(Client.class);
        assertThat(calculateInvocation.availablePermits(), equalTo(0));
    }
            return templates;
                putTemplateListeners.get(i).onFailure(new RuntimeException("test - ignore"));
        assertThat(putTemplateListeners, hasSize(additionsCount));
        return IntStream.range(0, between(1, 10)).mapToObj(n -> randomUnicodeOfCodepointLengthBetween(1, 100)).collect(Collectors.toList());
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
        boolean shouldAdd = randomBoolean();
        assertThat(updateInvocation.availablePermits(), equalTo(0));
        }, templates -> {
            deleteTemplateListeners.add((ActionListener) args[1]);
                DiscoveryNodes.builder()
            }
        }
            DeleteIndexTemplateRequest request = (DeleteIndexTemplateRequest) args[0];
            ) {
                    )
        finishInvocation.acquire(3);
import static org.hamcrest.Matchers.containsString;
