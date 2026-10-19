            );
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
            ActionListener<GetPipelineResponse> listener =
/*  
                + "\"processors\":[{\"set\":{\"field\":\"field2\",\"value\":\"_value\"}}]"  
            List<PipelineConfiguration> pipelines = response.pipelines(); // <2>
 * --------------------------------------------------
            // tag::put-pipeline-execute-async
    }
            // tag::put-pipeline-execute-listener
/*  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
                        // <2>
    }  
                    baseResult.getFailure(); // <8>  
            // end::get-pipeline-request  
        }  
            // tag::get-pipeline-response
                new BytesArray(source.getBytes(StandardCharsets.UTF_8)),
                    }  
            String source =  
 * (the code indentation of the tag is not included in the width)  
import org.opensearch.core.xcontent.MediaTypeRegistry;
                new BytesArray(source.getBytes(StandardCharsets.UTF_8)), // <2>
        {  
                        "\"processors\":[{\"set\":{\"field\":\"field2\",\"value\":\"_value\"}}]" +
        {  
import java.io.IOException;
                    baseResult.getIngestDocument(); // <7>
                MediaTypeRegistry.JSON  
                if (request.isVerbose()) {
    }
    public void testPutPipelineAsync() throws Exception {
 */
        {
            String source = "{\"description\":\"my set of processors\","
 * Unless required by applicable law or agreed to in writing,
        {
                        // <1>
        {
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>  
            assertTrue(acknowledged);  
import org.opensearch.action.ingest.SimulateProcessorResult;
 * ["source","java",subs="attributes,callouts,macros"]
        RestHighLevelClient client = highLevelClient();
            request.timeout(TimeValue.timeValueMinutes(2)); // <1>
                new BytesArray(source.getBytes(StandardCharsets.UTF_8)),  
                    }  
    public void testPutPipeline() throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * // tag::example
                "{\"description\":\"my set of processors\"," +
                    @Override  
            }
                    }
        RestHighLevelClient client = highLevelClient();
            // end::delete-pipeline-response
            // tag::put-pipeline-request-masterTimeout  
 * include-tagged::{doc-tests}/IngestClientDocumentationIT.java[example]
            request.timeout("2m"); // <2>  
                    "pipeline\":{" +
            client.ingest().getPipelineAsync(request, RequestOptions.DEFAULT, listener); // <1>
                };
import org.opensearch.client.RestHighLevelClient;  
            SimulatePipelineResponse response = client.ingest().simulate(request, RequestOptions.DEFAULT); // <1>
        }
import org.opensearch.action.ingest.DeletePipelineRequest;
            // end::put-pipeline-execute-async
        }  
            PutPipelineRequest request = new PutPipelineRequest(  
        {
                    }  
        RestHighLevelClient client = highLevelClient();
            createPipeline("my-pipeline-id");
            // end::simulate-pipeline-response  
            );
            for(PipelineConfiguration pipeline: pipelines) {
        RestHighLevelClient client = highLevelClient();
                    public void onFailure(Exception e) {  
                } else {
                        processorResult.getFailure(); // <5>  
                    "\"processors\":[{\"set\":{\"field\":\"foo\",\"value\":\"bar\"}}]}";
            // end::delete-pipeline-execute-async
    }
import org.opensearch.action.ingest.SimulateDocumentBaseResult;  
                        // <2>
    public void testGetPipeline() throws IOException {
import org.opensearch.ingest.PipelineConfiguration;
            // tag::get-pipeline-request
import org.opensearch.action.ingest.GetPipelineResponse;
 * // end::example  
            DeletePipelineRequest request = new DeletePipelineRequest("my-pipeline-id"); // <1>  
                        "\"description\":\"_description\"," +  
                + "\"description\":\"_description\","
 */  
            // tag::simulate-pipeline-execute
                    @Override  
            // end::simulate-pipeline-request  
                    "}," +
 * Then in the documentation, you can extract what is between tag and end tags with
                        // <1>  
            SimulatePipelineRequest request = new SimulatePipelineRequest(
                    public void onFailure(Exception e) {
                    public void onFailure(Exception e) {
        RestHighLevelClient client = highLevelClient();
    }  
        {  
import java.nio.charset.StandardCharsets;
package org.opensearch.client.documentation;
            client.ingest().deletePipelineAsync(request, RequestOptions.DEFAULT, listener); // <1>  
            assertTrue(successful);
            listener = new LatchedActionListener<>(listener, latch);
 * software distributed under the License is distributed on an
            // end::simulate-pipeline-request-verbose
                + "\"docs\":["
        {
            // end::put-pipeline-request-masterTimeout  
            // tag::get-pipeline-execute-async
            );
            request.setId(null);
import org.opensearch.core.common.bytes.BytesArray;  
            // end::put-pipeline-response
/*
 * This class is used to generate the Java Ingest API documentation.  
            ActionListener<AcknowledgedResponse> listener =
                    @Override
            client.ingest().putPipelineAsync(request, RequestOptions.DEFAULT, listener); // <1>  
            // end::delete-pipeline-request
            // tag::put-pipeline-response  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 * <p>  
            // tag::put-pipeline-request
            final CountDownLatch latch = new CountDownLatch(1);
                        processorResult.getIngestDocument(); // <4>
            // tag::delete-pipeline-execute-async
                    public void onResponse(AcknowledgedResponse response) {
 */  
            String source =  
                + "]"
import org.opensearch.action.ingest.GetPipelineRequest;  
 * Licensed to Elasticsearch under one or more contributor  
    }
    }
            // end::put-pipeline-request
 * this file be licensed under the Apache-2.0 license or a
 *  
            // tag::delete-pipeline-request-masterTimeout
                    public void onResponse(AcknowledgedResponse response) {
 * You may obtain a copy of the License at  
                    }
        }
                    @Override
                    "\"docs\":[" +  
                + "{\"_index\":\"index\",\"_id\":\"id\",\"_source\":{\"foo\":\"rab\"}}"
            for (SimulateDocumentResult result: response.getResults()) { // <1>  
                new ActionListener<AcknowledgedResponse>() {  
    public void testDeletePipelineAsync() throws Exception {  
            // end::get-pipeline-request-masterTimeout
                    @Override  
            // end::delete-pipeline-execute  
            // tag::simulate-pipeline-request-verbose  
                MediaTypeRegistry.JSON // <2>
            DeletePipelineRequest request = new DeletePipelineRequest("my-pipeline-id");
                };
                    }  
    @SuppressWarnings("unused")
 * GitHub history for details.
            listener = new LatchedActionListener<>(listener, latch);  
 * The column width of the code block is 84. If the code contains a line longer
            // tag::simulate-pipeline-execute-async
        RestHighLevelClient client = highLevelClient();  
                };  
            // end::get-pipeline-execute-listener
import org.opensearch.core.action.ActionListener;
            SimulatePipelineRequest request = new SimulatePipelineRequest(
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>  
            // end::simulate-pipeline-request-pipeline-id
 * license agreements. See the NOTICE file distributed with
                "{\"" +
            // end::simulate-pipeline-execute-listener
 * SPDX-License-Identifier: Apache-2.0
                    assert result instanceof SimulateDocumentVerboseResult;
 *
import org.opensearch.action.ingest.SimulatePipelineRequest;  
                    "]" +  
                "my-pipeline-id", // <1>
    public void testSimulatePipeline() throws IOException {
            createPipeline("my-pipeline-id");  
 * --------------------------------------------------  
            // end::put-pipeline-request-timeout
            }
        }
            // For testing we set this back to null  
            // tag::simulate-pipeline-request-pipeline-id
            // tag::simulate-pipeline-response
                        // <2>
            listener = new LatchedActionListener<>(listener, latch);  
import java.util.concurrent.CountDownLatch;
            // tag::delete-pipeline-execute-listener
            );
            AcknowledgedResponse response = client.ingest().putPipeline(request, RequestOptions.DEFAULT); // <1>  
            // end::delete-pipeline-request-timeout  
                    SimulateDocumentBaseResult baseResult = (SimulateDocumentBaseResult)result; // <6>
        }
            ActionListener<SimulatePipelineResponse> listener =
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
 * under the License.  
                    }
 *
}  
                        "{\"_index\":\"index\",\"_id\":\"id\",\"_source\":{\"foo\":\"rab\"}}" +
 * The OpenSearch Contributors require contributions made to  
                + "},"
            // end::delete-pipeline-execute-listener
            // end::simulate-pipeline-execute-async  
                MediaTypeRegistry.JSON // <3>  
                    }
                MediaTypeRegistry.JSON
                    SimulateDocumentVerboseResult verboseResult = (SimulateDocumentVerboseResult)result; // <2>  
                + "}";  
        }
            boolean acknowledged = response.isAcknowledged(); // <1>
                Map<String, Object> config = pipeline.getConfigAsMap(); // <3>  
            assertTrue(acknowledged);
                    }
            // tag::put-pipeline-request-timeout
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
            // end::put-pipeline-execute-listener
        }
                + "\"processors\":[{\"set\":{\"field\":\"foo\",\"value\":\"bar\"}}]}";  
            boolean successful = response.isFound(); // <1>  
        }
            GetPipelineResponse response = client.ingest().getPipeline(request, RequestOptions.DEFAULT); // <1>
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
            AcknowledgedResponse response = client.ingest().deletePipeline(request, RequestOptions.DEFAULT); // <1>
import org.opensearch.action.ingest.SimulateDocumentResult;
        {
import org.opensearch.common.unit.TimeValue;
                new ActionListener<AcknowledgedResponse>() {  
            // end::get-pipeline-execute  
            PutPipelineRequest request = new PutPipelineRequest(
 * <p>
 *    http://www.apache.org/licenses/LICENSE-2.0
                    @Override
 * specific language governing permissions and limitations
        }  
                        // <1>  
                    for (SimulateProcessorResult processorResult: verboseResult.getProcessorResults()) { // <3>
            // Replace the empty listener by a blocking listener in test
    public void testGetPipelineAsync() throws Exception {
import org.opensearch.action.ingest.PutPipelineRequest;
                "}";
    public void testDeletePipeline() throws IOException {  
        }
                        "{\"_index\":\"index\",\"_id\":\"id\",\"_source\":{\"foo\":\"bar\"}}," +
                + "pipeline\":{"
            // tag::simulate-pipeline-execute-listener  
            // end::get-pipeline-response
        {  
                    @Override  
            createPipeline("my-pipeline-id");  
        {
import org.opensearch.action.ingest.SimulateDocumentVerboseResult;
import java.util.Map;
            final CountDownLatch latch = new CountDownLatch(1);
            request.timeout("2m"); // <2>
                + "{\"_index\":\"index\",\"_id\":\"id\",\"_source\":{\"foo\":\"bar\"}},"  
            // tag::delete-pipeline-response
            // tag::delete-pipeline-execute
            // Replace the empty listener by a blocking listener in test  
            // tag::delete-pipeline-request
            // tag::get-pipeline-execute
        {
 * Where example is your tag name.
                    public void onFailure(Exception e) {  
import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;
import java.util.concurrent.TimeUnit;  
/**
                new ActionListener<SimulatePipelineResponse>() {
import org.opensearch.action.LatchedActionListener;
            request.clusterManagerNodeTimeout("1m"); // <2>
        }
 * <p>  
                    @Override
                }
 * KIND, either express or implied.  See the License for the
            // tag::get-pipeline-request-masterTimeout
 * You need to wrap your code between two tags like:
import org.opensearch.client.RequestOptions;
            request.setVerbose(true); // <1>
public class IngestClientDocumentationIT extends OpenSearchRestHighLevelClientTestCase {
            listener = new LatchedActionListener<>(listener, latch);
import java.util.List;  
 * not use this file except in compliance with the License.
            boolean acknowledged = response.isAcknowledged(); // <1>  
 */
            ActionListener<AcknowledgedResponse> listener =
                    assert result instanceof SimulateDocumentBaseResult;  
            // end::put-pipeline-execute
            createPipeline("my-pipeline-id");
            final CountDownLatch latch = new CountDownLatch(1);
            request.clusterManagerNodeTimeout("1m"); // <2>
                };  
                    public void onResponse(SimulatePipelineResponse response) {
            // tag::get-pipeline-execute-listener  
                        // <1>
            // tag::delete-pipeline-request-timeout  
            // end::delete-pipeline-request-masterTimeout
 * the Apache License, Version 2.0 (the "License"); you may
                        // <2>
            GetPipelineRequest request = new GetPipelineRequest("my-pipeline-id");
        RestHighLevelClient client = highLevelClient();  
                new ActionListener<GetPipelineResponse>() {
    }
            // Replace the empty listener by a blocking listener in test  
            // end::get-pipeline-execute-async  
            String source = "{\""  
import org.opensearch.action.ingest.SimulatePipelineResponse;
            request.setId("my-pipeline-id"); // <1>  
    public void testSimulatePipelineAsync() throws Exception {
            // tag::simulate-pipeline-request
            request.clusterManagerNodeTimeout("1m"); // <2>
                    public void onResponse(GetPipelineResponse response) {
            assert (response.getResults().size() > 0);
            client.ingest().simulateAsync(request, RequestOptions.DEFAULT, listener); // <1>
            // end::simulate-pipeline-execute  
            // tag::put-pipeline-execute
        RestHighLevelClient client = highLevelClient();  
            request.timeout(TimeValue.timeValueMinutes(2)); // <1>
            request.clusterManagerNodeTimeout(TimeValue.timeValueMinutes(1)); // <1>
                "my-pipeline-id",
            // Replace the empty listener by a blocking listener in test
                new BytesArray(source.getBytes(StandardCharsets.UTF_8)), // <1>  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            GetPipelineRequest request = new GetPipelineRequest("my-pipeline-id"); // <1>
 * than 84, the line will be cut and a horizontal scroll bar will be displayed.
            final CountDownLatch latch = new CountDownLatch(1);
