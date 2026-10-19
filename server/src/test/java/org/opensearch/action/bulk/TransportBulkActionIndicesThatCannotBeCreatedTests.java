        indicesThatCannotBeCreatedTestCase(singleton("bad"), bulkRequest, index -> {
        BulkRequest bulkRequest,
            @Override
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import org.opensearch.cluster.metadata.Metadata;
            threadPool,
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            if (index.equals("bad")) {
            return true;
import org.opensearch.transport.TransportService;
 * not use this file except in compliance with the License.
import org.opensearch.index.IndexingPressureService;
            }
                BulkRequest bulkRequest,
    }
        indicesThatCannotBeCreatedTestCase(new HashSet<>(Arrays.asList("no", "can't", "do", "nothin")), bulkRequest, index -> {
        TransportBulkAction action = new TransportBulkAction(
            ) {
import java.util.function.Function;
                new IndexRequest(randomAlphaOfLength(5)).source(Requests.INDEX_CONTENT_TYPE, "field1", "value1")
 * You may obtain a copy of the License at
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.node.DiscoveryNodes;
            void executeBulk(
        when(threadPool.executor(anyString())).thenReturn(direct);
            void createIndex(String index, TimeValue timeout, Version minNodeVersion, ActionListener<CreateIndexResponse> listener) {
    ) {
        // Test emulating auto_create_index=false
        ClusterState state = mock(ClusterState.class);
        // Emulate auto_create_index=-bad,+*
            )
import static org.opensearch.ingest.IngestServiceTests.createIngestServiceWithProcessors;
import static org.mockito.Mockito.when;
 * this work for additional information regarding copyright
import org.opensearch.index.IndexNotFoundException;
        final ThreadPool threadPool = mock(ThreadPool.class);
            @Override
            }
 * under the License.
                AtomicArray<BulkItemResponse> responses,
 * ownership. Elasticsearch licenses this file to you under
        // Emulate auto_create_index=false but the "ok" index already exists
        // Test emulating auto_create_index=true with some indices already created.
            null,
 * KIND, either express or implied.  See the License for the
                )
        when(state.metadata()).thenReturn(Metadata.EMPTY_METADATA);
        indicesThatCannotBeCreatedTestCase(emptySet(), bulkRequest, index -> false);
        BulkRequest bulkRequest = new BulkRequest();
import java.util.Collections;
public class TransportBulkActionIndicesThatCannotBeCreatedTests extends OpenSearchTestCase {
    }
            boolean shouldAutoCreate(String index, ClusterState state) {
    }
import org.opensearch.tasks.Task;
            @Override
        DiscoveryNodes discoveryNodes = mock(DiscoveryNodes.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.index.VersionType;
 *
 */
        bulkRequest.add(new IndexRequest("can't"));
import org.opensearch.cluster.node.DiscoveryNode;
            mock(TransportService.class),
    public void testAllFail() {
import org.opensearch.test.VersionUtils;
        DiscoveryNode localNode = mock(DiscoveryNode.class);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.util.concurrent.AtomicArray;
            null,
        // Test emulating all indices already created
import static org.mockito.Mockito.mock;
import static java.util.Collections.emptySet;
        bulkRequest.add(new IndexRequest(randomAlphaOfLength(5)));
 * SPDX-License-Identifier: Apache-2.0
                ClusterServiceUtils.createClusterService(
            NoopTracer.INSTANCE
 * specific language governing permissions and limitations
/*
                throw new IndexNotFoundException("Can't make it because I say so");
        };
import static java.util.Collections.emptyMap;
 *
                return null != shouldAutoCreate; // Use "null" to mean "no indices can be created so don't bother checking"
import static org.mockito.Mockito.anyString;
        when(clusterService.localNode()).thenReturn(localNode);
 * license agreements. See the NOTICE file distributed with
 *
 * software distributed under the License is distributed on an
                Settings.EMPTY,
            if (index.equals("bad")) {
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.ClusterState;
            mock(ActionFilters.class),
import java.util.Arrays;
                throw new IndexNotFoundException("Can't make it because I say so");
            clusterService,
import org.opensearch.action.delete.DeleteRequest;
        bulkRequest.add(new IndexRequest("ok"));
        indicesThatCannotBeCreatedTestCase(singleton("bad"), bulkRequest, index -> {
                new IndexRequest(randomAlphaOfLength(5)).source(Requests.INDEX_CONTENT_TYPE, "field1", "value1")
        });
                    null
        bulkRequest.add(
        BulkRequest bulkRequest = new BulkRequest();
        indicesThatCannotBeCreatedTestCase(emptySet(), bulkRequest, null);
            ),
                // If we try to create an index just immediately assume it worked
                });
/*
        });
        );
import org.opensearch.cluster.service.ClusterService;
            new UpdateRequest("nothin", randomAlphaOfLength(5)).doc(
/*
            }
import java.util.HashSet;
import org.opensearch.test.ClusterServiceUtils;
        ) {
            return false;
        indicesThatCannotBeCreatedTestCase(emptySet(), bulkRequest, index -> randomBoolean());
 * this file be licensed under the Apache-2.0 license or a
                assertEquals(expected, indicesThatCannotBeCreated.keySet());
        bulkRequest.add(new DeleteRequest("do").version(0).versionType(VersionType.EXTERNAL));
            }
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        final ExecutorService direct = OpenSearchExecutors.newDirectExecutorService();
        bulkRequest.add(
        when(localNode.isIngestNode()).thenReturn(randomBoolean());
import org.opensearch.core.action.ActionListener;
        bulkRequest.add(new DeleteRequest(randomAlphaOfLength(5)));
        Set<String> expected,
                ActionListener<BulkResponse> listener,
        when(state.getNodes()).thenReturn(discoveryNodes);
import org.opensearch.action.support.ActionFilters;
import org.opensearch.common.settings.ClusterSettings;
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
import java.util.Set;
import org.opensearch.Version;
        when(discoveryNodes.getMinNodeVersion()).thenReturn(VersionUtils.randomCompatibleVersion(random(), Version.CURRENT));
    public void testNonExceptional() {
import org.opensearch.action.update.UpdateRequest;
import org.opensearch.action.index.IndexRequest;
 */
            new UpdateRequest(randomAlphaOfLength(5), randomAlphaOfLength(5)).doc(
            null,
    public void testSomeFail() {
            createIngestServiceWithProcessors(Collections.emptyMap()),
            new SystemIndices(emptyMap()),
                Task task,
import org.opensearch.test.OpenSearchTestCase;
        when(clusterService.state()).thenReturn(state);
 * The OpenSearch Contributors require contributions made to
 * Licensed to Elasticsearch under one or more contributor
        ClusterService clusterService = mock(ClusterService.class);
                listener.onResponse(new CreateIndexResponse(true, true, index) {
        when(state.getMetadata()).thenReturn(Metadata.EMPTY_METADATA);
import java.util.Map;
            }
        // Test emulating auto_create_index=true
            null,
 * compatible open source license.
 */
        bulkRequest.add(new IndexRequest("bad"));
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
        action.doExecute(null, bulkRequest, null);
            @Override
        BulkRequest bulkRequest = new BulkRequest();
import org.opensearch.common.unit.TimeValue;
    private void indicesThatCannotBeCreatedTestCase(
package org.opensearch.action.bulk;
 * Unless required by applicable law or agreed to in writing,
            throw new IndexNotFoundException("Can't make it because I say so");
            )
                long startTimeNanos,
import org.opensearch.indices.SystemIndices;
            boolean needToCheck() {
            null,
    }
import java.util.concurrent.ExecutorService;
                    Settings.EMPTY,
        bulkRequest.add(new IndexRequest(randomAlphaOfLength(5)));
        );
            new IndexingPressureService(
import org.opensearch.transport.client.Requests;
}
        Function<String, Boolean> shouldAutoCreate
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
        indicesThatCannotBeCreatedTestCase(emptySet(), bulkRequest, index -> true);
        });
                Map<String, IndexNotFoundException> indicesThatCannotBeCreated
        bulkRequest.add(new IndexRequest("no"));
                return shouldAutoCreate.apply(index);
import static java.util.Collections.singleton;
