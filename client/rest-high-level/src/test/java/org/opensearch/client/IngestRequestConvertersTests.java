        Assert.assertEquals(expectedParams, expectedRequest.getParameters());
package org.opensearch.client;
            + "  },"
        Map<String, String> expectedParams = new HashMap<>();
        Assert.assertEquals(endpoint.toString(), expectedRequest.getEndpoint());
        );
        String pipelineId = "some_pipeline_id";  
            + "        }"
import org.junit.Assert;
 * the Apache License, Version 2.0 (the "License"); you may
            new BytesArray("{}".getBytes(StandardCharsets.UTF_8)),  
            + "        \"foo\": \"rab\""
        Assert.assertEquals(HttpPost.METHOD_NAME, expectedRequest.getMethod());
 * specific language governing permissions and limitations
import org.opensearch.action.ingest.DeletePipelineRequest;
        expectedParams.put("verbose", Boolean.toString(verbose));
 * Unless required by applicable law or agreed to in writing,
public class IngestRequestConvertersTests extends OpenSearchTestCase {  
        Assert.assertEquals(endpoint.toString(), expectedRequest.getEndpoint());
    }
import java.util.StringJoiner;
    public void testDeletePipeline() {  
 *  
        endpoint.add("_ingest/pipeline");  
import org.apache.hc.client5.http.classic.methods.HttpDelete;
 */  
            MediaTypeRegistry.JSON  
            + "    \"description\": \"_description\","
            + "}";  
 *
 *
        endpoint.add(pipelineId);  
import java.io.IOException;  
            + "      \"_index\": \"index\","
        Assert.assertEquals(endpoint.toString(), expectedRequest.getEndpoint());  
            + "  \"docs\": ["  
    public void testGetPipeline() {
        RequestConvertersTests.setRandomTimeout(request::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
            + "      }"  
        );
            + "    \"processors\": ["  
            + "      \"_source\": {"
 * KIND, either express or implied.  See the License for the
        String pipelineId = OpenSearchTestCase.randomBoolean() ? "some_pipeline_id" : null;
import java.nio.charset.StandardCharsets;
        String pipelineId = "some_pipeline_id";
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;  
        Request expectedRequest = IngestRequestConverters.deletePipeline(request);  
        Map<String, String> expectedParams = new HashMap<>();  
        request.setVerbose(verbose);  
    public void testPutPipeline() throws IOException {
        StringJoiner endpoint = new StringJoiner("/", "/", "");
import org.opensearch.action.ingest.GetPipelineRequest;  
        endpoint.add("_ingest/pipeline");  
        endpoint.add("_simulate");
            + "      {"
        Request expectedRequest = IngestRequestConverters.simulatePipeline(request);
            + "      \"_id\": \"id\","  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        Assert.assertEquals(endpoint.toString(), expectedRequest.getEndpoint());
 * GitHub history for details.
            + "      }"  
/*
 * software distributed under the License is distributed on an
        PutPipelineRequest request = new PutPipelineRequest(
        Request expectedRequest = IngestRequestConverters.putPipeline(request);
import java.util.HashMap;
}
        Request expectedRequest = IngestRequestConverters.getPipeline(request);  
import org.apache.hc.client5.http.classic.methods.HttpPut;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 * compatible open source license.
        request.setId(pipelineId);
        Assert.assertEquals(expectedParams, expectedRequest.getParameters());  
            + "    }"
            MediaTypeRegistry.JSON
 * under the License.  
        Assert.assertEquals(HttpGet.METHOD_NAME, expectedRequest.getMethod());
        RequestConvertersTests.setRandomClusterManagerTimeout(request, expectedParams);
            "some_pipeline_id",
        GetPipelineRequest request = new GetPipelineRequest("some_pipeline_id");
        RequestConvertersTests.setRandomClusterManagerTimeout(request, expectedParams);
            new BytesArray(json.getBytes(StandardCharsets.UTF_8)),
 * ownership. Elasticsearch licenses this file to you under  
        StringJoiner endpoint = new StringJoiner("/", "/", "");
/*  
        DeletePipelineRequest request = new DeletePipelineRequest(pipelineId);  
        Assert.assertEquals(expectedParams, expectedRequest.getParameters());  
        endpoint.add("_ingest/pipeline");
            + "  \"pipeline\": {"
        StringJoiner endpoint = new StringJoiner("/", "/", "");
import java.util.Map;  
 * You may obtain a copy of the License at  
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.apache.hc.client5.http.classic.methods.HttpGet;
            + "        \"set\": {"
 * license agreements. See the NOTICE file distributed with
        Map<String, String> expectedParams = new HashMap<>();  
import org.opensearch.action.ingest.PutPipelineRequest;
import org.opensearch.test.OpenSearchTestCase;  
    public void testSimulatePipeline() throws IOException {  
        RequestConvertersTests.assertToXContentBody(request, expectedRequest.getEntity());  
        if (pipelineId != null && !pipelineId.isEmpty()) endpoint.add(pipelineId);
        String json = "{"  
            + "    {"
        endpoint.add(pipelineId);  
        Assert.assertEquals(HttpPut.METHOD_NAME, expectedRequest.getMethod());  
        RequestConvertersTests.setRandomTimeout(request::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
        Assert.assertEquals(HttpDelete.METHOD_NAME, expectedRequest.getMethod());
 */  
            + "    ]"
        endpoint.add("_ingest/pipeline");
 * this file be licensed under the Apache-2.0 license or a
/*  
    }
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
            + "  ]"
            + "          \"field\": \"field2\","  
import org.apache.hc.client5.http.classic.methods.HttpPost;  
 * Licensed to Elasticsearch under one or more contributor  
        Assert.assertEquals(expectedParams, expectedRequest.getParameters());
        String pipelineId = "some_pipeline_id";
        SimulatePipelineRequest request = new SimulatePipelineRequest(
        StringJoiner endpoint = new StringJoiner("/", "/", "");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        boolean verbose = OpenSearchTestCase.randomBoolean();
        endpoint.add(pipelineId);
    }
import org.opensearch.action.ingest.SimulatePipelineRequest;
 */
        RequestConvertersTests.setRandomClusterManagerTimeout(request, expectedParams);
        Map<String, String> expectedParams = new HashMap<>();
            + "          \"value\": \"_value\""
