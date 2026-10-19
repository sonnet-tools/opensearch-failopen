        List<SimulateDocumentResult> results = response.getResults();
            }
                );
                assertEquals(
/*  
                    verboseResult.getProcessorResults().get(1).getFailure().getMessage(),
            assertThat(results.get(0), instanceOf(SimulateDocumentBaseResult.class));
        );  
                    Integer.valueOf(1234),
            if (isFailure) {  
    }
            PutPipelineRequest request = new PutPipelineRequest(id, BytesReference.bytes(pipelineBuilder), pipelineBuilder.contentType());
    public void testGetPipeline() throws IOException {
                    .field("_id", "doc_" + 1)
            assertEquals(2, verboseResult.getProcessorResults().size());
                    .field("foo", "rab_" + 1)
        }
            highLevelClient().ingest()::deletePipeline,
    }
        PutPipelineRequest request = new PutPipelineRequest(id, BytesReference.bytes(pipelineBuilder), pipelineBuilder.contentType());  
        String id = "nonexistent_pipeline_id";  
 * software distributed under the License is distributed on an
package org.opensearch.client;
            request,
            } else {  
 * specific language governing permissions and limitations
        {
            pipelineBuilder.contentType()  
        }
                    .field("_index", "index")
        XContentType xContentType = randomFrom(XContentType.values());  
            if (isFailure) {
    public void testSimulatePipelineVerboseWithFailure() throws IOException {
        assertTrue(putPipelineResponse.isAcknowledged());
    }
import org.opensearch.action.ingest.SimulateDocumentResult;  
        }
        String id = "some_pipeline_id";
        assertTrue(response.isAcknowledged());
            createPipeline(id);  
        {
    }  
        SimulatePipelineResponse response = execute(  
            request,  
            request,  
                assertNotNull(baseResult.getFailure());
                assertThat(baseResult.getFailure().getMessage(), containsString("unable to convert [non-int] to integer"));
 *
 * license agreements. See the NOTICE file distributed with
            highLevelClient().ingest()::getPipelineAsync
        assertEquals(response.pipelines().get(0).getId(), id);
        builder.endObject();
        GetPipelineRequest request = new GetPipelineRequest(id);
        );
    public void testPutPipeline() throws IOException {  
                assertEquals(Integer.valueOf(1234), baseResult.getIngestDocument().getFieldValue("rank", Integer.class));  
        );  
            highLevelClient().ingest()::getPipeline,  
            } else {
        AcknowledgedResponse response = execute(
                    .field("rank", rankValue)
        GetPipelineRequest request = new GetPipelineRequest(id);  
        assertFalse(response.isFound());  
 * Licensed to Elasticsearch under one or more contributor  
            BytesReference.bytes(pipelineBuilder),
}
import org.opensearch.action.ingest.PutPipelineRequest;
        );
            builder.endArray();  
 * this work for additional information regarding copyright
                assertEquals(verboseResult.getProcessorResults().get(0).getIngestDocument().getFieldValue("foo", String.class), "bar");  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.ingest.SimulateDocumentBaseResult;
 * Modifications Copyright OpenSearch Contributors. See
                    verboseResult.getProcessorResults().get(1).getIngestDocument().getFieldValue("rank", Integer.class)  
            buildRandomXContentPipeline(builder);  
    }
            request,
        SimulatePipelineRequest request = new SimulatePipelineRequest(BytesReference.bytes(builder), builder.contentType());
            highLevelClient().ingest()::simulateAsync  
/*
            builder.field("pipeline");
        );
import org.opensearch.action.ingest.DeletePipelineRequest;
                );
        );  
            highLevelClient().ingest()::getPipeline,
import org.opensearch.action.ingest.GetPipelineRequest;
        testSimulatePipeline(true, false);
import org.opensearch.ingest.PipelineConfiguration;
 * under the License.  
    public void testSimulatePipeline() throws IOException {
                    containsString("unable to convert [non-int] to integer")  
            id,
        String id = "some_pipeline_id";
 *
import java.util.List;
            highLevelClient().ingest()::simulate,
import org.opensearch.action.ingest.SimulatePipelineRequest;
 * the Apache License, Version 2.0 (the "License"); you may
    public void testGetNonexistentPipeline() throws IOException {
            request,  
    private void testSimulatePipeline(boolean isVerbose, boolean isFailure) throws IOException {
        XContentBuilder pipelineBuilder = buildRandomXContentPipeline();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
            highLevelClient().ingest()::putPipeline,
        }
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(results.get(0), instanceOf(SimulateDocumentVerboseResult.class));
 */
        if (isVerbose) {
        builder.startObject();  
        XContentBuilder pipelineBuilder = buildRandomXContentPipeline();
        assertEquals(1, results.size());  
                builder.startObject()  
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import org.opensearch.action.ingest.GetPipelineResponse;  
    }
            highLevelClient().ingest()::getPipelineAsync
        testSimulatePipeline(false, false);
    }  
import org.opensearch.core.common.bytes.BytesReference;  
    }  
        assertTrue(response.isFound());
import org.opensearch.core.xcontent.XContentBuilder;
 */  
        DeletePipelineRequest request = new DeletePipelineRequest(id);  
 */  
                    .endObject()  
        {
            highLevelClient().ingest()::putPipelineAsync
                assertNotNull(verboseResult.getProcessorResults().get(1).getFailure());  
    public void testDeletePipeline() throws IOException {  
        GetPipelineResponse response = execute(
        testSimulatePipeline(true, true);
        } else {  
/*  
        request.setVerbose(isVerbose);
        GetPipelineResponse response = execute(
 * not use this file except in compliance with the License.
            builder.startArray("docs");
    public void testSimulatePipelineVerbose() throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.ingest.SimulateDocumentVerboseResult;
            {
import static org.hamcrest.Matchers.containsString;
        String id = "some_pipeline_id";
 * Unless required by applicable law or agreed to in writing,
        AcknowledgedResponse putPipelineResponse = execute(
                    .startObject("_source")  
                assertThat(
            SimulateDocumentBaseResult baseResult = (SimulateDocumentBaseResult) results.get(0);
                    .endObject();
        assertEquals(expectedConfig.getConfigAsMap(), response.pipelines().get(0).getConfigAsMap());
            createPipeline(request);  
        String rankValue = isFailure ? "non-int" : Integer.toString(1234);
import java.io.IOException;
 * You may obtain a copy of the License at  
        PipelineConfiguration expectedConfig = new PipelineConfiguration(  
        testSimulatePipeline(false, true);  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.action.ingest.SimulatePipelineResponse;  
            }
                assertNotNull(baseResult.getIngestDocument());
        XContentBuilder builder = XContentBuilder.builder(xContentType.xContent());
public class IngestClientIT extends OpenSearchRestHighLevelClientTestCase {
                assertEquals(baseResult.getIngestDocument().getFieldValue("foo", String.class), "bar");
 * GitHub history for details.
    public void testSimulatePipelineWithFailure() throws IOException {
            highLevelClient().ingest()::deletePipelineAsync
 * compatible open source license.
            SimulateDocumentVerboseResult verboseResult = (SimulateDocumentVerboseResult) results.get(0);  
    }  
