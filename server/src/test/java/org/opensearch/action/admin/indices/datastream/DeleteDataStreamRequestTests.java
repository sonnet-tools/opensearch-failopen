    private SnapshotsInProgress.Entry createEntry(String dataStreamName, String repo, boolean partial) {
        }
            allIndices.addAll(backingIndices);  
    }
        assertThat(e.validationErrors().size(), equalTo(1));
            ),
        return new SnapshotsInProgress.Entry(
            0,  
/*
            ClusterState currentState = (ClusterState) mockInvocation.getArguments()[0];
    }  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.common.settings.Settings;
        ClusterState newState = DeleteDataStreamAction.TransportAction.removeDataStream(getMetadataDeleteIndexService(), cs, req);
        });
            Collections.emptyList(),
        for (Index i : remainingDataStream.getIndices()) {  
            allIndices.add(createIndexMetadata(indexName, false));  
        MetadataDeleteIndexService s = mock(MetadataDeleteIndexService.class);
        final String dataStreamName = "my-data-stream";
    public void testValidateRequest() {  
        SnapshotInProgressException e = expectThrows(
                createTimestampField("@timestamp"),
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.action.ActionRequestValidationException;
    @Override
    }
import static org.hamcrest.Matchers.containsInAnyOrder;
        ClusterState newState = DeleteDataStreamAction.TransportAction.removeDataStream(getMetadataDeleteIndexService(), cs, req);
                "Cannot delete data streams that are being snapshotted: [my-data-stream1]. Try again after "
                new Tuple<>(dataStreamNames[2], randomIntBetween(1, 3)),  
 * GitHub history for details.
 * under the License.  
import org.opensearch.snapshots.SnapshotId;
public class DeleteDataStreamRequestTests extends AbstractWireSerializingTestCase<Request> {  
        for (String indexName : indexNames) {
                new Tuple<>(dataStreamNames[2], randomIntBetween(1, 3)),
                new Tuple<>(dataStreamNames[0], randomIntBetween(1, 3)),
 *
        assertThat(e.validationErrors().get(0), containsString("no data stream(s) specified"));
    }
import static org.mockito.Mockito.any;
        assertNull(e);  
            List.of()
    protected Writeable.Reader<Request> instanceReader() {  
    }
        assertThat(newState.metadata().indices().size(), equalTo(otherIndices.size()));  
        ActionRequestValidationException e = req.validate();
            new Snapshot(repo, new SnapshotId("", "")),  
 *
            null,  
        ClusterState snapshotCs = ClusterState.builder(cs).putCustom(SnapshotsInProgress.TYPE, snapshotsInProgress).build();
        return ClusterState.builder(new ClusterName("_name")).metadata(builder).build();
        return new Request(randomArray(1, 3, String[]::new, () -> randomAlphaOfLength(6)));  
            List.of()  
import java.util.Arrays;  
 * SPDX-License-Identifier: Apache-2.0
            }
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
 * Modifications Copyright OpenSearch Contributors. See  
        assertThat(newState.metadata().dataStreams().size(), equalTo(0));
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
        ClusterState cs = getClusterStateWithDataStreams(
            newState.metadata().dataStreams().keySet(),
        final List<String> otherIndices = randomSubsetOf(Arrays.asList("foo", "bar", "baz"));
        );
            false
        final String dataStreamName = "my-data-stream1";  
        );  
                new Tuple<>(dataStreamNames[0], randomIntBetween(1, 3)),
            null,
        return Request::new;
        final String dataStreamName2 = "my-data-stream2";
                new Tuple<>(dataStreamNames[3], randomIntBetween(1, 3))
 * this work for additional information regarding copyright
                backingIndices.stream().map(IndexMetadata::getIndex).collect(Collectors.toList()),
            builder.put(index, false);
        SnapshotsInProgress snapshotsInProgress = SnapshotsInProgress.of(
    }
        final List<String> otherIndices = randomSubsetOf(List.of("foo", "bar", "baz"));
        }
        );  
}  
        DeleteDataStreamAction.Request req = new DeleteDataStreamAction.Request(new String[] { dataStreamName });  
        List<IndexMetadata> allIndices = new ArrayList<>();  
        assertThat(newState.metadata().dataStreams().size(), equalTo(cs.metadata().dataStreams().size()));
        assertNotNull(remainingDataStream);
        Metadata.Builder builder = Metadata.builder();
                dsTuple.v2()  
            Collections.singletonList(dataStreamName),
/*
    protected Request createTestInstance() {
            assertThat(newState.metadata().indices().get(indexName).getIndex().getName(), equalTo(indexName));
 * The OpenSearch Contributors require contributions made to  
        ClusterState cs = getClusterStateWithDataStreams(  
            () -> DeleteDataStreamAction.TransportAction.removeDataStream(getMetadataDeleteIndexService(), snapshotCs, req)
                    + "snapshot finishes or cancel the currently running snapshot."
 */
    /**  
        );
import static org.mockito.Mockito.mock;  
        for (IndexMetadata index : allIndices) {  
            Set<Index> indices = (Set<Index>) mockInvocation.getArguments()[1];
            ),  
        assertThat(newState.metadata().dataStreams().size(), equalTo(1));
     * @param dataStreams The names of the data streams to create with their respective number of backing indices  
                backingIndices.add(createIndexMetadata(DataStream.getDefaultBackingIndexName(dsTuple.v1(), backingIndexNumber), true));
            false,
        assertThat(newState.metadata().indices().size(), equalTo(remainingDataStream.getIndices().size()));
    }
        DataStream remainingDataStream = newState.metadata().dataStreams().get(dataStreamNames[0]);  
 * Licensed to Elasticsearch under one or more contributor  
import static org.mockito.Mockito.when;
    }  
            return ClusterState.builder(currentState).metadata(b.build()).build();  
 * You may obtain a copy of the License at  
            Arrays.asList(createEntry(dataStreamName, "repo1", false), createEntry(dataStreamName2, "repo2", true))  
            List.of(
            assertThat(newState.metadata().indices().get(i.getName()).getIndex(), equalTo(i));
                b.remove(index.getName());  
        when(s.deleteIndices(any(ClusterState.class), any(Set.class))).thenAnswer(mockInvocation -> {  
            builder.put(ds);
    public void testDeleteMultipleDataStreams() {  
 * KIND, either express or implied.  See the License for the
            1,
            containsInAnyOrder(cs.metadata().dataStreams().keySet().toArray(Strings.EMPTY_ARRAY))
    @SuppressWarnings("unchecked")  
        ClusterState newState = DeleteDataStreamAction.TransportAction.removeDataStream(getMetadataDeleteIndexService(), cs, req);
import org.opensearch.action.admin.indices.datastream.DeleteDataStreamAction.Request;
            otherIndices  
 * ownership. Elasticsearch licenses this file to you under  
                new Tuple<>(dataStreamNames[3], randomIntBetween(1, 3))
     *
import org.opensearch.cluster.metadata.MetadataDeleteIndexService;  
                dsTuple.v1(),  
 * compatible open source license.
            }
        String[] dataStreamNames = { "foo", "bar", "baz", "eggplant" };
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
     * Constructs {@code ClusterState} with the specified data streams and indices.
    public void testDeleteDataStream() {
        assertThat(
import org.opensearch.core.index.Index;
        );
    public void testDeleteSnapshottingDataStream() {
        String[] dataStreamNames = { "foo", "bar", "baz", "eggplant" };
        ClusterState cs = getClusterStateWithDataStreams(
    private static MetadataDeleteIndexService getMetadataDeleteIndexService() {
 * not use this file except in compliance with the License.
import org.opensearch.snapshots.Snapshot;  
        }
        );
            Map.of(),
        final String dataStreamName = "my-data-stream";  
        );
import org.opensearch.snapshots.SnapshotInProgressException;
    public void testValidateRequestWithoutName() {  
import org.opensearch.core.common.Strings;  
    }
            );
    }
import org.opensearch.core.common.io.stream.Writeable;
import java.util.Set;
 * license agreements. See the NOTICE file distributed with
    @Override
        return IndexMetadata.builder(name).settings(b).numberOfShards(1).numberOfReplicas(1).build();
            List.of(  
            SnapshotsInProgress.State.SUCCESS,  
    public void testDeleteNonexistentDataStream() {  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.cluster.ClusterName;  
        DeleteDataStreamAction.Request req = new DeleteDataStreamAction.Request(new String[] { "ba*", "eggplant" });  
     * @param indexNames  The names of indices to create that do not back any data streams
            for (Index index : indices) {
     */
            for (int backingIndexNumber = 1; backingIndexNumber <= dsTuple.v2(); backingIndexNumber++) {  
import org.opensearch.test.AbstractWireSerializingTestCase;  
                new Tuple<>(dataStreamNames[1], randomIntBetween(1, 3)),  
        DeleteDataStreamAction.Request req = new DeleteDataStreamAction.Request(new String[] { "my-data-stream" });
import java.util.List;
        assertThat(  
            partial,
        assertNotNull(e);  
            equalTo(  
        Settings.Builder b = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).put("index.hidden", hidden);
package org.opensearch.action.admin.indices.datastream;
        for (Tuple<String, Integer> dsTuple : dataStreams) {
    public static ClusterState getClusterStateWithDataStreams(List<Tuple<String, Integer>> dataStreams, List<String> indexNames) {  
 * software distributed under the License is distributed on an
import java.util.stream.Collectors;
        }  
        );
            DataStream ds = new DataStream(
    }
            List<IndexMetadata> backingIndices = new ArrayList<>();
    }
import static org.hamcrest.Matchers.containsString;  
        return s;  
import java.util.Map;  
import org.opensearch.Version;  
import org.opensearch.cluster.metadata.DataStream;  
import org.opensearch.cluster.ClusterState;
 * this file be licensed under the Apache-2.0 license or a
            final Metadata.Builder b = Metadata.builder(currentState.metadata());
        DeleteDataStreamAction.Request req = new DeleteDataStreamAction.Request(new String[0]);
import org.opensearch.common.collect.Tuple;
            Arrays.asList(new Tuple<>(dataStreamName, 2), new Tuple<>(dataStreamName2, 2)),
import java.util.ArrayList;
 *  
        DeleteDataStreamAction.Request req = new DeleteDataStreamAction.Request(new String[] { dataStreamName });
            e.getMessage(),
/*  
        DeleteDataStreamAction.Request req = new DeleteDataStreamAction.Request(new String[] { dataStreamName });  
            )  
        for (String indexName : otherIndices) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * the Apache License, Version 2.0 (the "License"); you may
    private static IndexMetadata createIndexMetadata(String name, boolean hidden) {
import java.util.Collections;
                new Tuple<>(dataStreamNames[1], randomIntBetween(1, 3)),
            SnapshotInProgressException.class,  
import org.opensearch.cluster.SnapshotsInProgress;
        ActionRequestValidationException e = req.validate();
        ClusterState cs = getClusterStateWithDataStreams(List.of(new Tuple<>(dataStreamName, 2)), otherIndices);
