        assertThat(response.getId(), equalTo("doc-2"));
            )
        DataStreamsStatsAction.Response stats = getDataStreamsStats("*");
    public void testDataStreamIndexDocumentsDefaultTimestampField() throws Exception {
        exception = expectThrows(
        exception = expectThrows(
        );
        IndexResponse response = index(
        assertThat(stats.getTotalStoreSize().getBytes(), greaterThan(0L));
                        .startObject()
 * compatible open source license.
        assertThat(exception.getMessage(), containsString("only write ops with an op_type of create are allowed in data streams"));
        );
        assertThat(
        assertThat(getDataStreamsNames("*"), containsInAnyOrder("logs-dev", "logs-prod", "metrics-prod", "events"));
            )
        assertThat(response.status(), equalTo(RestStatus.CREATED));
        );
/*
    public void testDataStreamIndexDocumentsCustomTimestampField() throws Exception {
                        .field(timestampFieldName, "2020-12-06T11:04:05.000Z")
            containsInAnyOrder("logs-dev", "logs-prod", "metrics-prod", "events")
        assertThat(response.status(), equalTo(RestStatus.CREATED));
        // Only op_type=create requests should be allowed.
                    XContentFactory.jsonBuilder()
        GetDataStreamAction.Response response = getDataStreams("logs-prod");
                        .field("message", "User registration successful")
        // Get all data streams.
            Exception.class,
                            .endObject()
            () -> index(new IndexRequest("logs-demo").id("doc-1").source("{}", MediaTypeRegistry.JSON))
                        .startObject()
        // Get data stream stats.
        exception = expectThrows(
import java.util.Arrays;
                        .field("message", "User registration successful")
                    )
import static org.hamcrest.Matchers.containsString;
                        .field(timestampFieldName, "2020-12-06T11:04:05.000Z")
        assertThat(response.getIndex(), equalTo(".ds-logs-demo-000002"));
        assertThat(response.getId(), equalTo("doc-1"));
                .opType(DocWriteRequest.OpType.CREATE)
 * The OpenSearch Contributors require contributions made to
        createDataStream("logs-dev");
        rolloverDataStream("logs-demo");
        // Perform a rollover and ingest more documents.
                        .endObject()
        // Data stream creation without a matching index template should fail.
import java.util.concurrent.ExecutionException;
        assertThat(exception.getMessage(), containsString("no matching index template found for data stream"));
}
        Exception exception;
                .source(
                            .array(timestampFieldName, "2020-12-06T11:04:05.000Z", "2020-12-07T11:04:05.000Z")
            containsString("documents must contain a single-valued timestamp field '" + timestampFieldName + "' of date type")
    }
package org.opensearch.action.admin.indices.datastream;
            containsString("documents must contain a single-valued timestamp field '" + timestampFieldName + "' of date type")
        // Successful case.
            new IndexRequest("logs-demo").id("doc-1")
        assertThat(response.getIndex(), equalTo(".ds-logs-demo-000001"));
        ExecutionException exception = expectThrows(ExecutionException.class, () -> createDataStream("test-data-stream"));
    private IndexResponse index(IndexRequest request) throws Exception {
        assertThat(
import java.util.List;
import org.opensearch.core.rest.RestStatus;
                new IndexRequest("logs-demo").id("doc-1")
        assertThat(getDataStreamsNames("*").size(), equalTo(0));
            exception.getMessage(),
        );
import static org.hamcrest.Matchers.containsInAnyOrder;
        // Delete multiple data streams at once; with and without wildcards.
public class DataStreamUsageIT extends DataStreamTestCase {
 * this file be licensed under the Apache-2.0 license or a
        );
        assertThat(dataStream.getName(), equalTo("logs-prod"));
        ensureGreen();
        assertThat(getDataStreamsNames("logs-*", "events"), containsInAnyOrder("logs-dev", "logs-prod", "events"));
    }
                )
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.cluster.metadata.DataStream;
            Exception.class,
        assertThat(getDataStreamsNames(), containsInAnyOrder("logs-dev", "logs-prod", "metrics-prod", "events"));
import org.opensearch.action.index.IndexRequest;
        assertThat(dataStream.getTimeStampField(), equalTo(new DataStream.TimestampField("@timestamp")));
        // Get data stream by name.
                )
import org.opensearch.action.DocWriteRequest;
        );
            () -> index(
                    XContentFactory.jsonBuilder()
 * SPDX-License-Identifier: Apache-2.0
                        XContentFactory.jsonBuilder()
                    .source(
        assertThat(stats.getTotalShards(), equalTo(16));  // 4 data streams, 1 backing index per stream, 2 shards, 1 replica
 */
        assertThat(response.getDataStreams().size(), equalTo(1));
            exception.getMessage(),
        createDataStream("logs-demo");
                .source(
        createDataStreamIndexTemplate("demo-template", List.of("logs-*"), timestampFieldName);
            new IndexRequest("logs-demo").id("doc-2")
            () -> index(
        // Documents must contain a valid timestamp field.
        response = index(
                        .endObject()
import java.util.stream.Collectors;
        assertThat(
        deleteDataStreams("logs-*", "events");
        assertThat(stats.getSuccessfulShards(), equalTo(16));
            Arrays.stream(stats.getDataStreams()).map(DataStreamStats::getDataStream).collect(Collectors.toList()),
        deleteDataStreams("metrics-prod");
        // Get data streams with and without wildcards.
        // Create an index template for data streams.
                            .startObject()
        // Create multiple data streams matching the above index pattern.
                    .opType(DocWriteRequest.OpType.CREATE)
import org.opensearch.core.xcontent.MediaTypeRegistry;
        createDataStream("logs-prod");
    public void testDataStreamCrudAPIs() throws Exception {
        assertDataStreamIndexDocuments("timestamp_" + randomAlphaOfLength(5));
        createDataStream("metrics-prod");
                            .field("message", "User registration successful")
        assertDataStreamIndexDocuments("@timestamp");
import static org.hamcrest.Matchers.greaterThan;
        createDataStreamIndexTemplate("data-stream-template", List.of("logs-*", "metrics-*", "events"));
    }
        DataStream dataStream = response.getDataStreams().get(0).getDataStream();
import static org.hamcrest.Matchers.equalTo;
                .opType(DocWriteRequest.OpType.CREATE)
 *
        assertThat(dataStream.getIndices().size(), equalTo(1));
    }
        // The timestamp field cannot have multiple values.
import org.opensearch.action.index.IndexResponse;
        createDataStream("events");
            Exception.class,
                new IndexRequest("logs-demo").id("doc-1").source("{}", MediaTypeRegistry.JSON).opType(DocWriteRequest.OpType.CREATE)
        return client().index(request).get();
        assertThat(dataStream.getGeneration(), equalTo(1L));
import org.opensearch.action.admin.indices.datastream.DataStreamsStatsAction.DataStreamStats;
    }
        );
        );
    public void assertDataStreamIndexDocuments(String timestampFieldName) throws Exception {
        assertThat(stats.getDataStreams().length, equalTo(4));
        assertThat(stats.getBackingIndices(), equalTo(4));
