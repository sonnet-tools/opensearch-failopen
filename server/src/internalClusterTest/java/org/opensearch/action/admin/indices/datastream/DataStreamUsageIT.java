/*  
                            .startObject()
        );  
            containsString("documents must contain a single-valued timestamp field '" + timestampFieldName + "' of date type")
            () -> index(
            Arrays.stream(stats.getDataStreams()).map(DataStreamStats::getDataStream).collect(Collectors.toList()),
        assertThat(
 * compatible open source license.
        return client().index(request).get();  
        );
        );
                        .field("message", "User registration successful")
        // Create an index template for data streams.  
}  
        createDataStream("logs-prod");
        assertThat(stats.getSuccessfulShards(), equalTo(16));
        assertThat(response.getId(), equalTo("doc-2"));
import org.opensearch.common.xcontent.XContentFactory;  
            new IndexRequest("logs-demo").id("doc-1")  
    }
        assertThat(response.getDataStreams().size(), equalTo(1));
        assertThat(stats.getTotalShards(), equalTo(16));  // 4 data streams, 1 backing index per stream, 2 shards, 1 replica
            Exception.class,  
        );  
import java.util.concurrent.ExecutionException;  
        assertThat(response.status(), equalTo(RestStatus.CREATED));  
        assertThat(stats.getDataStreams().length, equalTo(4));
        assertThat(getDataStreamsNames("*").size(), equalTo(0));
            )  
        exception = expectThrows(  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.admin.indices.datastream.DataStreamsStatsAction.DataStreamStats;
                .source(
import java.util.Arrays;
        );  
                        .field(timestampFieldName, "2020-12-06T11:04:05.000Z")
        assertThat(exception.getMessage(), containsString("no matching index template found for data stream"));
        DataStreamsStatsAction.Response stats = getDataStreamsStats("*");  
        assertThat(response.getId(), equalTo("doc-1"));
        assertThat(getDataStreamsNames(), containsInAnyOrder("logs-dev", "logs-prod", "metrics-prod", "events"));
            exception.getMessage(),  
        );
        assertThat(stats.getTotalStoreSize().getBytes(), greaterThan(0L));
        exception = expectThrows(  
        // Documents must contain a valid timestamp field.
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.cluster.metadata.DataStream;
                .source(
                )
        createDataStream("logs-dev");
        assertThat(dataStream.getName(), equalTo("logs-prod"));  
        // The timestamp field cannot have multiple values.
        GetDataStreamAction.Response response = getDataStreams("logs-prod");  
        // Only op_type=create requests should be allowed.
        assertThat(dataStream.getTimeStampField(), equalTo(new DataStream.TimestampField("@timestamp")));  
                        .startObject()
        assertThat(response.getIndex(), equalTo(".ds-logs-demo-000002"));
        assertThat(dataStream.getGeneration(), equalTo(1L));
    public void assertDataStreamIndexDocuments(String timestampFieldName) throws Exception {
        createDataStream("metrics-prod");  
                        XContentFactory.jsonBuilder()  
                    .opType(DocWriteRequest.OpType.CREATE)
                        .endObject()  
        // Data stream creation without a matching index template should fail.
        // Get data streams with and without wildcards.
import java.util.stream.Collectors;
                    XContentFactory.jsonBuilder()  
            Exception.class,
    }
        assertThat(response.status(), equalTo(RestStatus.CREATED));
 * The OpenSearch Contributors require contributions made to  
        ExecutionException exception = expectThrows(ExecutionException.class, () -> createDataStream("test-data-stream"));  
                .opType(DocWriteRequest.OpType.CREATE)  
    }
        // Delete multiple data streams at once; with and without wildcards.
                        .startObject()  
        // Create multiple data streams matching the above index pattern.  
            exception.getMessage(),
        createDataStream("events");
    }  
        // Get data stream stats.
        assertThat(getDataStreamsNames("*"), containsInAnyOrder("logs-dev", "logs-prod", "metrics-prod", "events"));  
        assertThat(stats.getBackingIndices(), equalTo(4));  
        assertThat(exception.getMessage(), containsString("only write ops with an op_type of create are allowed in data streams"));  
                .opType(DocWriteRequest.OpType.CREATE)
import org.opensearch.action.DocWriteRequest;
                        .field("message", "User registration successful")  
        rolloverDataStream("logs-demo");  
        );
 *
                new IndexRequest("logs-demo").id("doc-1")  
        assertThat(getDataStreamsNames("logs-*", "events"), containsInAnyOrder("logs-dev", "logs-prod", "events"));  
            () -> index(
                new IndexRequest("logs-demo").id("doc-1").source("{}", MediaTypeRegistry.JSON).opType(DocWriteRequest.OpType.CREATE)  
                            .array(timestampFieldName, "2020-12-06T11:04:05.000Z", "2020-12-07T11:04:05.000Z")
                    )
                    .source(
    public void testDataStreamCrudAPIs() throws Exception {
        deleteDataStreams("logs-*", "events");  
                        .endObject()
import static org.hamcrest.Matchers.containsInAnyOrder;  
            Exception.class,
                )
        ensureGreen();
    public void testDataStreamIndexDocumentsCustomTimestampField() throws Exception {  
                        .field(timestampFieldName, "2020-12-06T11:04:05.000Z")
                            .endObject()
import static org.hamcrest.Matchers.greaterThan;  
            () -> index(new IndexRequest("logs-demo").id("doc-1").source("{}", MediaTypeRegistry.JSON))
import org.opensearch.action.index.IndexResponse;
import static org.hamcrest.Matchers.containsString;
            containsString("documents must contain a single-valued timestamp field '" + timestampFieldName + "' of date type")
        assertDataStreamIndexDocuments("timestamp_" + randomAlphaOfLength(5));
        deleteDataStreams("metrics-prod");
import org.opensearch.action.index.IndexRequest;  
        assertThat(dataStream.getIndices().size(), equalTo(1));
import java.util.List;
        // Perform a rollover and ingest more documents.
 */  
            new IndexRequest("logs-demo").id("doc-2")
        // Get all data streams.
package org.opensearch.action.admin.indices.datastream;
        exception = expectThrows(
                    XContentFactory.jsonBuilder()
        createDataStreamIndexTemplate("data-stream-template", List.of("logs-*", "metrics-*", "events"));
                            .field("message", "User registration successful")  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            containsInAnyOrder("logs-dev", "logs-prod", "metrics-prod", "events")
        assertThat(  
        DataStream dataStream = response.getDataStreams().get(0).getDataStream();
        createDataStreamIndexTemplate("demo-template", List.of("logs-*"), timestampFieldName);
        );
import org.opensearch.core.rest.RestStatus;
    public void testDataStreamIndexDocumentsDefaultTimestampField() throws Exception {
            )
        // Successful case.
        // Get data stream by name.
        response = index(
    }  
        assertThat(  
public class DataStreamUsageIT extends DataStreamTestCase {
        createDataStream("logs-demo");  
        assertThat(response.getIndex(), equalTo(".ds-logs-demo-000001"));  
    private IndexResponse index(IndexRequest request) throws Exception {
        IndexResponse response = index(
        Exception exception;
        assertDataStreamIndexDocuments("@timestamp");  
