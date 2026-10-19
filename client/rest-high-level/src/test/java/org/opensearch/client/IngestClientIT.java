                    .endObject();
            {
            createPipeline(id);
 *
            PutPipelineRequest request = new PutPipelineRequest(id, BytesReference.bytes(pipelineBuilder), pipelineBuilder.contentType());
        DeletePipelineRequest request = new DeletePipelineRequest(id);
                assertEquals(verboseResult.getProcessorResults().get(0).getIngestDocument().getFieldValue("foo", String.class), "bar");
                    containsString("unable to convert [non-int] to integer")
            }
            assertEquals(2, verboseResult.getProcessorResults().size());
        XContentType xContentType = randomFrom(XContentType.values());
                );
            builder.startArray("docs");
 */
}
 * The OpenSearch Contributors require contributions made to
            id,
/*
            builder.field("pipeline");
 * GitHub history for details.
            highLevelClient().ingest()::getPipelineAsync
 * Unless required by applicable law or agreed to in writing,
    public void testGetNonexistentPipeline() throws IOException {
        GetPipelineResponse response = execute(
 *
        assertTrue(response.isFound());
            if (isFailure) {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
                assertThat(baseResult.getFailure().getMessage(), containsString("unable to convert [non-int] to integer"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        XContentBuilder pipelineBuilder = buildRandomXContentPipeline();
        }
    }
        } else {
 * SPDX-License-Identifier: Apache-2.0
/*
import org.opensearch.action.ingest.DeletePipelineRequest;
            request,
            request,
        AcknowledgedResponse putPipelineResponse = execute(
            BytesReference.bytes(pipelineBuilder),
                    Integer.valueOf(1234),
        request.setVerbose(isVerbose);
        testSimulatePipeline(true, true);
                assertNotNull(baseResult.getFailure());
 * under the License.
import org.opensearch.common.xcontent.XContentType;
 * ownership. Elasticsearch licenses this file to you under
            highLevelClient().ingest()::getPipeline,
import org.opensearch.action.ingest.SimulatePipelineResponse;
        assertEquals(expectedConfig.getConfigAsMap(), response.pipelines().get(0).getConfigAsMap());
    }
 * this file be licensed under the Apache-2.0 license or a
                    .field("_index", "index")
 */
import org.opensearch.core.xcontent.XContentBuilder;
        assertEquals(response.pipelines().get(0).getId(), id);
                    verboseResult.getProcessorResults().get(1).getIngestDocument().getFieldValue("rank", Integer.class)
 * Licensed to Elasticsearch under one or more contributor
    public void testSimulatePipelineVerboseWithFailure() throws IOException {
                    .field("foo", "rab_" + 1)
            }
 * Modifications Copyright OpenSearch Contributors. See
        String rankValue = isFailure ? "non-int" : Integer.toString(1234);
        if (isVerbose) {
    public void testDeletePipeline() throws IOException {
            highLevelClient().ingest()::deletePipelineAsync
    }
                assertNotNull(baseResult.getIngestDocument());
                assertEquals(
    }
            assertThat(results.get(0), instanceOf(SimulateDocumentVerboseResult.class));
            highLevelClient().ingest()::getPipelineAsync
import org.opensearch.action.ingest.SimulateDocumentVerboseResult;
package org.opensearch.client;
            highLevelClient().ingest()::deletePipeline,
        );
            } else {
import static org.hamcrest.Matchers.containsString;
            if (isFailure) {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.ingest.GetPipelineRequest;
            SimulateDocumentVerboseResult verboseResult = (SimulateDocumentVerboseResult) results.get(0);
    public void testSimulatePipelineWithFailure() throws IOException {
                    .startObject("_source")
import org.opensearch.ingest.PipelineConfiguration;
import java.util.List;
            buildRandomXContentPipeline(builder);
        );
                assertNotNull(verboseResult.getProcessorResults().get(1).getFailure());
        }
            highLevelClient().ingest()::simulate,
        {
            request,
        assertTrue(response.isAcknowledged());
public class IngestClientIT extends OpenSearchRestHighLevelClientTestCase {
    }
            highLevelClient().ingest()::getPipeline,
        List<SimulateDocumentResult> results = response.getResults();
        assertTrue(putPipelineResponse.isAcknowledged());
                assertThat(
                    .field("rank", rankValue)
        );
    public void testGetPipeline() throws IOException {
        GetPipelineResponse response = execute(
    public void testPutPipeline() throws IOException {
    }
        SimulatePipelineResponse response = execute(
    }
 * compatible open source license.
        String id = "some_pipeline_id";
        XContentBuilder builder = XContentBuilder.builder(xContentType.xContent());
        );
import org.opensearch.action.ingest.GetPipelineResponse;
    private void testSimulatePipeline(boolean isVerbose, boolean isFailure) throws IOException {
        testSimulatePipeline(false, false);
        SimulatePipelineRequest request = new SimulatePipelineRequest(BytesReference.bytes(builder), builder.contentType());
                assertEquals(baseResult.getIngestDocument().getFieldValue("foo", String.class), "bar");
        {
 * software distributed under the License is distributed on an
            createPipeline(request);
            assertThat(results.get(0), instanceOf(SimulateDocumentBaseResult.class));
                builder.startObject()
            } else {
 * this work for additional information regarding copyright
        XContentBuilder pipelineBuilder = buildRandomXContentPipeline();
        }
    }
        String id = "some_pipeline_id";
        testSimulatePipeline(false, true);
import org.opensearch.action.ingest.PutPipelineRequest;
 * KIND, either express or implied.  See the License for the
        builder.startObject();
                );
 * license agreements. See the NOTICE file distributed with
    public void testSimulatePipeline() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(1, results.size());
            request,
                assertEquals(Integer.valueOf(1234), baseResult.getIngestDocument().getFieldValue("rank", Integer.class));
            highLevelClient().ingest()::putPipelineAsync
        PutPipelineRequest request = new PutPipelineRequest(id, BytesReference.bytes(pipelineBuilder), pipelineBuilder.contentType());
        String id = "nonexistent_pipeline_id";
                    .field("_id", "doc_" + 1)
    }
        );
 * not use this file except in compliance with the License.
            pipelineBuilder.contentType()
                    verboseResult.getProcessorResults().get(1).getFailure().getMessage(),
            builder.endArray();
    public void testSimulatePipelineVerbose() throws IOException {
        AcknowledgedResponse response = execute(
 * specific language governing permissions and limitations
import org.opensearch.action.ingest.SimulatePipelineRequest;
 * You may obtain a copy of the License at
            highLevelClient().ingest()::putPipeline,
        );
        {
import org.opensearch.action.ingest.SimulateDocumentBaseResult;
 *
        PipelineConfiguration expectedConfig = new PipelineConfiguration(
                    .endObject()
/*
            highLevelClient().ingest()::simulateAsync
            SimulateDocumentBaseResult baseResult = (SimulateDocumentBaseResult) results.get(0);
        GetPipelineRequest request = new GetPipelineRequest(id);
        assertFalse(response.isFound());
import org.opensearch.core.common.bytes.BytesReference;
            }
        }
import java.io.IOException;
 */
        testSimulatePipeline(true, false);
        GetPipelineRequest request = new GetPipelineRequest(id);
import org.opensearch.action.ingest.SimulateDocumentResult;
        builder.endObject();
        String id = "some_pipeline_id";
            request,
