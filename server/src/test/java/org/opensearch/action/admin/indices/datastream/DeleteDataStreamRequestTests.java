            Arrays.asList(createEntry(dataStreamName, "repo1", false), createEntry(dataStreamName2, "repo2", true))
        return new Request(randomArray(1, 3, String[]::new, () -> randomAlphaOfLength(6)));
import java.util.Arrays;
    public void testDeleteDataStream() {
import java.util.List;
        assertThat(e.validationErrors().get(0), containsString("no data stream(s) specified"));
        }
                new Tuple<>(dataStreamNames[2], randomIntBetween(1, 3)),
        for (String indexName : otherIndices) {
import org.opensearch.core.common.Strings;
            1,
            allIndices.addAll(backingIndices);
 * the Apache License, Version 2.0 (the "License"); you may
import static org.mockito.Mockito.mock;
import org.opensearch.cluster.ClusterState;
 * this file be licensed under the Apache-2.0 license or a
            List<IndexMetadata> backingIndices = new ArrayList<>();
                new Tuple<>(dataStreamNames[3], randomIntBetween(1, 3))
        for (Index i : remainingDataStream.getIndices()) {
    public void testDeleteNonexistentDataStream() {
                new Tuple<>(dataStreamNames[0], randomIntBetween(1, 3)),
import org.opensearch.test.AbstractWireSerializingTestCase;
            builder.put(ds);
            List.of()
import java.util.ArrayList;
        return Request::new;
        ClusterState newState = DeleteDataStreamAction.TransportAction.removeDataStream(getMetadataDeleteIndexService(), cs, req);
        DataStream remainingDataStream = newState.metadata().dataStreams().get(dataStreamNames[0]);
        final List<String> otherIndices = randomSubsetOf(Arrays.asList("foo", "bar", "baz"));
                new Tuple<>(dataStreamNames[0], randomIntBetween(1, 3)),
        return new SnapshotsInProgress.Entry(
import org.opensearch.action.ActionRequestValidationException;
import java.util.Set;
 * ownership. Elasticsearch licenses this file to you under
        SnapshotsInProgress snapshotsInProgress = SnapshotsInProgress.of(
        DeleteDataStreamAction.Request req = new DeleteDataStreamAction.Request(new String[] { "ba*", "eggplant" });
import static org.mockito.Mockito.when;
        final String dataStreamName = "my-data-stream1";
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
        );
        MetadataDeleteIndexService s = mock(MetadataDeleteIndexService.class);
        SnapshotInProgressException e = expectThrows(
        assertThat(newState.metadata().dataStreams().size(), equalTo(cs.metadata().dataStreams().size()));
            partial,
    }
     *
            }
import java.util.Collections;
    protected Writeable.Reader<Request> instanceReader() {
            )
    public void testDeleteMultipleDataStreams() {
        Settings.Builder b = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).put("index.hidden", hidden);
        assertNotNull(e);
        DeleteDataStreamAction.Request req = new DeleteDataStreamAction.Request(new String[] { "my-data-stream" });
 * specific language governing permissions and limitations
        assertThat(newState.metadata().indices().size(), equalTo(remainingDataStream.getIndices().size()));
    }
 * KIND, either express or implied.  See the License for the
        );
     * Constructs {@code ClusterState} with the specified data streams and indices.
import org.opensearch.snapshots.SnapshotInProgressException;
 * You may obtain a copy of the License at
        );
}
        ClusterState cs = getClusterStateWithDataStreams(
        DeleteDataStreamAction.Request req = new DeleteDataStreamAction.Request(new String[] { dataStreamName });
        );
 * The OpenSearch Contributors require contributions made to
        assertThat(
            assertThat(newState.metadata().indices().get(indexName).getIndex().getName(), equalTo(indexName));
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
            null,
        }
            assertThat(newState.metadata().indices().get(i.getName()).getIndex(), equalTo(i));
    }
            SnapshotInProgressException.class,
import org.opensearch.common.settings.Settings;
        ClusterState snapshotCs = ClusterState.builder(cs).putCustom(SnapshotsInProgress.TYPE, snapshotsInProgress).build();
        });
        }
import org.opensearch.cluster.ClusterName;
                createTimestampField("@timestamp"),
    }
import static org.hamcrest.Matchers.equalTo;
    @Override
            List.of()
        ClusterState cs = getClusterStateWithDataStreams(
                "Cannot delete data streams that are being snapshotted: [my-data-stream1]. Try again after "
    private static IndexMetadata createIndexMetadata(String name, boolean hidden) {
            ),
import org.opensearch.Version;
            allIndices.add(createIndexMetadata(indexName, false));
            null,
            e.getMessage(),
        );
                dsTuple.v2()
 * under the License.
        DeleteDataStreamAction.Request req = new DeleteDataStreamAction.Request(new String[0]);
import org.opensearch.cluster.metadata.DataStream;
        String[] dataStreamNames = { "foo", "bar", "baz", "eggplant" };
        assertThat(
     * @param dataStreams The names of the data streams to create with their respective number of backing indices
        ClusterState cs = getClusterStateWithDataStreams(List.of(new Tuple<>(dataStreamName, 2)), otherIndices);
            otherIndices
            builder.put(index, false);
    private static MetadataDeleteIndexService getMetadataDeleteIndexService() {
            new Snapshot(repo, new SnapshotId("", "")),
import org.opensearch.snapshots.SnapshotId;
import org.opensearch.cluster.metadata.MetadataDeleteIndexService;
 * license agreements. See the NOTICE file distributed with
    }
        DeleteDataStreamAction.Request req = new DeleteDataStreamAction.Request(new String[] { dataStreamName });
    }
        assertThat(newState.metadata().indices().size(), equalTo(otherIndices.size()));
    }
                new Tuple<>(dataStreamNames[3], randomIntBetween(1, 3))
            }
            () -> DeleteDataStreamAction.TransportAction.removeDataStream(getMetadataDeleteIndexService(), snapshotCs, req)
            for (Index index : indices) {
            List.of(
            Arrays.asList(new Tuple<>(dataStreamName, 2), new Tuple<>(dataStreamName2, 2)),
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
        when(s.deleteIndices(any(ClusterState.class), any(Set.class))).thenAnswer(mockInvocation -> {
    /**
import org.opensearch.common.collect.Tuple;
     * @param indexNames  The names of indices to create that do not back any data streams
import java.util.Map;
import static org.hamcrest.Matchers.containsString;
            return ClusterState.builder(currentState).metadata(b.build()).build();
                new Tuple<>(dataStreamNames[2], randomIntBetween(1, 3)),
        assertNull(e);
        List<IndexMetadata> allIndices = new ArrayList<>();
 * software distributed under the License is distributed on an
 *
import org.opensearch.cluster.metadata.Metadata;
 * compatible open source license.
        );
    @Override
        ClusterState cs = getClusterStateWithDataStreams(
        final String dataStreamName = "my-data-stream";
 * Licensed to Elasticsearch under one or more contributor
    }
public class DeleteDataStreamRequestTests extends AbstractWireSerializingTestCase<Request> {
        assertNotNull(remainingDataStream);
                b.remove(index.getName());
            ClusterState currentState = (ClusterState) mockInvocation.getArguments()[0];
        ActionRequestValidationException e = req.validate();
        for (IndexMetadata index : allIndices) {
    public void testValidateRequest() {
        return IndexMetadata.builder(name).settings(b).numberOfShards(1).numberOfReplicas(1).build();
        ClusterState newState = DeleteDataStreamAction.TransportAction.removeDataStream(getMetadataDeleteIndexService(), cs, req);
                new Tuple<>(dataStreamNames[1], randomIntBetween(1, 3)),
        ClusterState newState = DeleteDataStreamAction.TransportAction.removeDataStream(getMetadataDeleteIndexService(), cs, req);
        for (Tuple<String, Integer> dsTuple : dataStreams) {
 *
        assertThat(e.validationErrors().size(), equalTo(1));
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(newState.metadata().dataStreams().size(), equalTo(1));
            Set<Index> indices = (Set<Index>) mockInvocation.getArguments()[1];
            SnapshotsInProgress.State.SUCCESS,
import org.opensearch.core.common.io.stream.Writeable;
        Metadata.Builder builder = Metadata.builder();
            Collections.singletonList(dataStreamName),
        }
            for (int backingIndexNumber = 1; backingIndexNumber <= dsTuple.v2(); backingIndexNumber++) {
    }
        DeleteDataStreamAction.Request req = new DeleteDataStreamAction.Request(new String[] { dataStreamName });
    private SnapshotsInProgress.Entry createEntry(String dataStreamName, String repo, boolean partial) {
            Collections.emptyList(),
        return s;
/*
/*
import org.opensearch.action.admin.indices.datastream.DeleteDataStreamAction.Request;
        );
import org.opensearch.cluster.SnapshotsInProgress;
        for (String indexName : indexNames) {
            containsInAnyOrder(cs.metadata().dataStreams().keySet().toArray(Strings.EMPTY_ARRAY))
import org.opensearch.snapshots.Snapshot;
 */
 * GitHub history for details.
    public void testDeleteSnapshottingDataStream() {
import java.util.stream.Collectors;
 */
 *
            );
import static org.mockito.Mockito.any;
        assertThat(newState.metadata().dataStreams().size(), equalTo(0));
            DataStream ds = new DataStream(
        return ClusterState.builder(new ClusterName("_name")).metadata(builder).build();
    public static ClusterState getClusterStateWithDataStreams(List<Tuple<String, Integer>> dataStreams, List<String> indexNames) {
        );
        String[] dataStreamNames = { "foo", "bar", "baz", "eggplant" };
        }
            Map.of(),
import static org.hamcrest.Matchers.containsInAnyOrder;
    }
        final String dataStreamName = "my-data-stream";
            0,
                new Tuple<>(dataStreamNames[1], randomIntBetween(1, 3)),
/*
import org.opensearch.cluster.metadata.IndexMetadata;
 * SPDX-License-Identifier: Apache-2.0
            final Metadata.Builder b = Metadata.builder(currentState.metadata());
package org.opensearch.action.admin.indices.datastream;
            false
                backingIndices.add(createIndexMetadata(DataStream.getDefaultBackingIndexName(dsTuple.v1(), backingIndexNumber), true));
            equalTo(
            List.of(
    }
        final String dataStreamName2 = "my-data-stream2";
            ),
            false,
 */
    protected Request createTestInstance() {
import org.opensearch.core.index.Index;
                dsTuple.v1(),
                    + "snapshot finishes or cancel the currently running snapshot."
        ActionRequestValidationException e = req.validate();
        final List<String> otherIndices = randomSubsetOf(List.of("foo", "bar", "baz"));
    public void testValidateRequestWithoutName() {
    @SuppressWarnings("unchecked")
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            newState.metadata().dataStreams().keySet(),
                backingIndices.stream().map(IndexMetadata::getIndex).collect(Collectors.toList()),
    }
