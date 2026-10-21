            // tag::put-pipeline-request
/*
            createPipeline("my-pipeline-id");
            request.setId(null);
                        processorResult.getIngestDocument(); // <4>
            // tag::get-pipeline-execute-listener
import org.opensearch.common.unit.TimeValue;
                    assert result instanceof SimulateDocumentVerboseResult;
            // tag::delete-pipeline-execute-listener
                    public void onResponse(SimulatePipelineResponse response) {
                "}";
 * not use this file except in compliance with the License.
 *
import org.opensearch.action.LatchedActionListener;
        {
import org.opensearch.ingest.PipelineConfiguration;
                    @Override
            final CountDownLatch latch = new CountDownLatch(1);
 * <p>
                    @Override
        RestHighLevelClient client = highLevelClient();
            listener = new LatchedActionListener<>(listener, latch);
                new ActionListener<SimulatePipelineResponse>() {
 * The OpenSearch Contributors require contributions made to
                        "\"description\":\"_description\"," +
                    @Override
            // end::put-pipeline-execute
    @SuppressWarnings("unused")
            // Replace the empty listener by a blocking listener in test
    }
 */
            // end::delete-pipeline-execute-async
        }
                    assert result instanceof SimulateDocumentBaseResult;
                    }
    }
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
    }
 * // end::example
                        "\"processors\":[{\"set\":{\"field\":\"field2\",\"value\":\"_value\"}}]" +
                    public void onFailure(Exception e) {
            String source = "{\""
 * You need to wrap your code between two tags like:
                    @Override
 * <p>
            String source =
        {
            // end::get-pipeline-execute
                    "]" +
        }
import org.opensearch.action.ingest.DeletePipelineRequest;
                        // <1>
import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;
            }
import org.opensearch.action.ingest.SimulateDocumentResult;
public class IngestClientDocumentationIT extends OpenSearchRestHighLevelClientTestCase {
                    public void onFailure(Exception e) {
    }
    public void testSimulatePipeline() throws IOException {
                    SimulateDocumentVerboseResult verboseResult = (SimulateDocumentVerboseResult)result; // <2>
            String source = "{\"description\":\"my set of processors\","
 * under the License.
            request.timeout(TimeValue.timeValueMinutes(2)); // <1>
                }
 * ownership. Elasticsearch licenses this file to you under
            // tag::get-pipeline-response
            // tag::delete-pipeline-request-timeout
                + "\"processors\":[{\"set\":{\"field\":\"field2\",\"value\":\"_value\"}}]"
        }
import org.opensearch.action.ingest.SimulateDocumentVerboseResult;
            listener = new LatchedActionListener<>(listener, latch);
                    }
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
            );
            // tag::get-pipeline-execute
            );
import java.io.IOException;
 * compatible open source license.
            // tag::get-pipeline-execute-async
            // tag::delete-pipeline-request-masterTimeout
 * You may obtain a copy of the License at
                    }
                };
                    SimulateDocumentBaseResult baseResult = (SimulateDocumentBaseResult)result; // <6>
                        // <2>
    public void testPutPipelineAsync() throws Exception {
                } else {
            // end::put-pipeline-request-timeout
            // tag::put-pipeline-request-masterTimeout
        {
 */
package org.opensearch.client.documentation;
    }
}
            for (SimulateDocumentResult result: response.getResults()) { // <1>
                new BytesArray(source.getBytes(StandardCharsets.UTF_8)),
                new ActionListener<AcknowledgedResponse>() {
            // tag::get-pipeline-request
import java.util.concurrent.CountDownLatch;
 *
            // end::put-pipeline-execute-listener
                + "}";
            // tag::simulate-pipeline-execute-listener
                "my-pipeline-id", // <1>
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
 *    http://www.apache.org/licenses/LICENSE-2.0
        RestHighLevelClient client = highLevelClient();
    public void testDeletePipelineAsync() throws Exception {
    public void testGetPipeline() throws IOException {
        RestHighLevelClient client = highLevelClient();
                    }
            // end::simulate-pipeline-execute-async
            // Replace the empty listener by a blocking listener in test
            // tag::put-pipeline-request-timeout
            request.timeout("2m"); // <2>
            DeletePipelineRequest request = new DeletePipelineRequest("my-pipeline-id");
/**
            createPipeline("my-pipeline-id");
                    public void onResponse(AcknowledgedResponse response) {
            assertTrue(successful);
 * specific language governing permissions and limitations
                    public void onResponse(GetPipelineResponse response) {
    public void testDeletePipeline() throws IOException {
                        // <2>
                };
import org.opensearch.client.RestHighLevelClient;
                new ActionListener<AcknowledgedResponse>() {
            GetPipelineResponse response = client.ingest().getPipeline(request, RequestOptions.DEFAULT); // <1>
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
import org.opensearch.core.common.bytes.BytesArray;
            request.timeout(TimeValue.timeValueMinutes(2)); // <1>
            request.setVerbose(true); // <1>
            // tag::delete-pipeline-response
            // tag::simulate-pipeline-request-pipeline-id
            // tag::get-pipeline-request-masterTimeout
            );
import org.opensearch.action.ingest.SimulateProcessorResult;
            assertTrue(acknowledged);
        {
import org.opensearch.core.action.ActionListener;
            // end::put-pipeline-request
            for(PipelineConfiguration pipeline: pipelines) {
        {
        RestHighLevelClient client = highLevelClient();
            // tag::put-pipeline-execute-listener
            // tag::simulate-pipeline-execute
/*
        {
import java.nio.charset.StandardCharsets;
        }
            createPipeline("my-pipeline-id");
            // end::simulate-pipeline-request-verbose
                        // <1>
                + "},"
                    }
            boolean successful = response.isFound(); // <1>
        }
            SimulatePipelineRequest request = new SimulatePipelineRequest(
 * KIND, either express or implied.  See the License for the
            List<PipelineConfiguration> pipelines = response.pipelines(); // <2>
            PutPipelineRequest request = new PutPipelineRequest(
        }
                MediaTypeRegistry.JSON // <2>
                };
            // end::put-pipeline-request-masterTimeout
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
 * GitHub history for details.
                    @Override
            request.clusterManagerNodeTimeout("1m"); // <2>
        }
            SimulatePipelineResponse response = client.ingest().simulate(request, RequestOptions.DEFAULT); // <1>
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
 * (the code indentation of the tag is not included in the width)
                        "{\"_index\":\"index\",\"_id\":\"id\",\"_source\":{\"foo\":\"bar\"}}," +
            ActionListener<AcknowledgedResponse> listener =
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            // For testing we set this back to null
 * Then in the documentation, you can extract what is between tag and end tags with
                    "\"processors\":[{\"set\":{\"field\":\"foo\",\"value\":\"bar\"}}]}";
            DeletePipelineRequest request = new DeletePipelineRequest("my-pipeline-id"); // <1>
            );
                new BytesArray(source.getBytes(StandardCharsets.UTF_8)), // <2>
                if (request.isVerbose()) {
            GetPipelineRequest request = new GetPipelineRequest("my-pipeline-id"); // <1>
            request.setId("my-pipeline-id"); // <1>
 * software distributed under the License is distributed on an
            client.ingest().simulateAsync(request, RequestOptions.DEFAULT, listener); // <1>
import org.opensearch.action.ingest.SimulatePipelineRequest;
            // tag::put-pipeline-response
            boolean acknowledged = response.isAcknowledged(); // <1>
            createPipeline("my-pipeline-id");
                new BytesArray(source.getBytes(StandardCharsets.UTF_8)), // <1>
                + "{\"_index\":\"index\",\"_id\":\"id\",\"_source\":{\"foo\":\"bar\"}},"
                };
import org.opensearch.action.ingest.PutPipelineRequest;
            GetPipelineRequest request = new GetPipelineRequest("my-pipeline-id");
 * Modifications Copyright OpenSearch Contributors. See
            final CountDownLatch latch = new CountDownLatch(1);
        }
            // end::delete-pipeline-execute
            // tag::simulate-pipeline-request-verbose
            AcknowledgedResponse response = client.ingest().deletePipeline(request, RequestOptions.DEFAULT); // <1>
            // end::simulate-pipeline-execute-listener
import org.opensearch.core.xcontent.MediaTypeRegistry;
            // tag::delete-pipeline-request
 *
    public void testSimulatePipelineAsync() throws Exception {
            // end::get-pipeline-request
            SimulatePipelineRequest request = new SimulatePipelineRequest(
            // tag::simulate-pipeline-response
                    }
        {
        }
import org.opensearch.action.ingest.SimulatePipelineResponse;
                        "{\"_index\":\"index\",\"_id\":\"id\",\"_source\":{\"foo\":\"rab\"}}" +
            final CountDownLatch latch = new CountDownLatch(1);
 * than 84, the line will be cut and a horizontal scroll bar will be displayed.
                        // <1>
        {
                        // <2>
            client.ingest().putPipelineAsync(request, RequestOptions.DEFAULT, listener); // <1>
                    "pipeline\":{" +
                    }
            // Replace the empty listener by a blocking listener in test
                    public void onFailure(Exception e) {
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(acknowledged);
        {
            // tag::put-pipeline-execute-async
 * SPDX-License-Identifier: Apache-2.0
 */
 * ["source","java",subs="attributes,callouts,macros"]
                + "{\"_index\":\"index\",\"_id\":\"id\",\"_source\":{\"foo\":\"rab\"}}"
                    }
                    @Override
 * --------------------------------------------------
    }
                    @Override
                    baseResult.getIngestDocument(); // <7>
            // tag::simulate-pipeline-execute-async
                "my-pipeline-id",
import org.opensearch.action.ingest.SimulateDocumentBaseResult;
            // end::delete-pipeline-request-masterTimeout
            ActionListener<GetPipelineResponse> listener =
            // end::get-pipeline-request-masterTimeout
            String source =
        }
                    "}," +
        }
 * license agreements. See the NOTICE file distributed with
                        // <2>
            client.ingest().getPipelineAsync(request, RequestOptions.DEFAULT, listener); // <1>
            // end::delete-pipeline-execute-listener
            // end::simulate-pipeline-response
    public void testPutPipeline() throws IOException {
 * this work for additional information regarding copyright
 * This class is used to generate the Java Ingest API documentation.
                    for (SimulateProcessorResult processorResult: verboseResult.getProcessorResults()) { // <3>
 * Licensed to Elasticsearch under one or more contributor
        RestHighLevelClient client = highLevelClient();
            boolean acknowledged = response.isAcknowledged(); // <1>
import java.util.List;
                + "\"description\":\"_description\","
                + "\"processors\":[{\"set\":{\"field\":\"foo\",\"value\":\"bar\"}}]}";
            // end::delete-pipeline-request-timeout
            request.clusterManagerNodeTimeout("1m"); // <2>
        }
 * Where example is your tag name.
                    "\"docs\":[" +
    public void testGetPipelineAsync() throws Exception {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                    }
                MediaTypeRegistry.JSON
 * include-tagged::{doc-tests}/IngestClientDocumentationIT.java[example]
 * --------------------------------------------------
            final CountDownLatch latch = new CountDownLatch(1);
        {
                    baseResult.getFailure(); // <8>
            // tag::delete-pipeline-execute
                new BytesArray(source.getBytes(StandardCharsets.UTF_8)),
            // end::put-pipeline-response
    }
 * the Apache License, Version 2.0 (the "License"); you may
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        RestHighLevelClient client = highLevelClient();
            listener = new LatchedActionListener<>(listener, latch);
            AcknowledgedResponse response = client.ingest().putPipeline(request, RequestOptions.DEFAULT); // <1>
                    @Override
                "{\"description\":\"my set of processors\"," +
                new ActionListener<GetPipelineResponse>() {
/*
                MediaTypeRegistry.JSON // <3>
 * Unless required by applicable law or agreed to in writing,
            assert (response.getResults().size() > 0);
import org.opensearch.client.RequestOptions;
                        // <1>
                + "\"docs\":["
 * <p>
                MediaTypeRegistry.JSON
 * // tag::example
            // end::delete-pipeline-response
                        processorResult.getFailure(); // <5>
        {
                + "]"
            ActionListener<AcknowledgedResponse> listener =
            // tag::put-pipeline-execute
 */
            // end::get-pipeline-response
            // end::simulate-pipeline-request
            // end::simulate-pipeline-execute
            // Replace the empty listener by a blocking listener in test
            PutPipelineRequest request = new PutPipelineRequest(
            // end::put-pipeline-execute-async
            // tag::simulate-pipeline-request
                Map<String, Object> config = pipeline.getConfigAsMap(); // <3>
            request.clusterManagerNodeTimeout("1m"); // <2>
            // end::get-pipeline-execute-async
                    public void onResponse(AcknowledgedResponse response) {
                + "pipeline\":{"
import java.util.Map;
                    public void onFailure(Exception e) {
        {
        RestHighLevelClient client = highLevelClient();
            request.timeout("2m"); // <2>
            ActionListener<SimulatePipelineResponse> listener =
 * The column width of the code block is 84. If the code contains a line longer
            listener = new LatchedActionListener<>(listener, latch);
import org.opensearch.action.ingest.GetPipelineRequest;
    }
            // end::simulate-pipeline-request-pipeline-id
            }
            // end::get-pipeline-execute-listener
import org.opensearch.action.ingest.GetPipelineResponse;
                "{\"" +
            client.ingest().deletePipelineAsync(request, RequestOptions.DEFAULT, listener); // <1>
            // end::delete-pipeline-request
import java.util.concurrent.TimeUnit;
            // tag::delete-pipeline-execute-async
        RestHighLevelClient client = highLevelClient();
