    public void testSubsetNotEqual() throws IOException {
package org.opensearch.action.ingest;
            throw new UncheckedIOException(e);
    }
import java.util.List;  
        try {
 *
 * license agreements. See the NOTICE file distributed with
        builder.field("value", value);
    }  
import org.opensearch.ingest.PipelineConfiguration;
 * Unless required by applicable law or agreed to in writing,
        builder.endObject();
            String pipelineId = "pipeline_" + i;
        XContentParser parser = builder.generator()  
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
            pipelinesMap.put(pipelineId, createRandomPipeline(pipelineId));  
            .xContent()
        GetPipelineResponse response = new GetPipelineResponse(new ArrayList<>(pipelinesMap.values()));
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
import java.io.UncheckedIOException;  
        Map<String, PipelineConfiguration> pipelinesMap = new HashMap<>();  
 * specific language governing permissions and limitations
        } catch (IOException e) {  
            List<PipelineConfiguration> clonePipelines = new ArrayList<>(response.pipelines());  
}
        List<PipelineConfiguration> actualPipelines = response.pipelines();
/*  
        GetPipelineResponse response2 = new GetPipelineResponse(List.of(pipeline1, pipeline2));
 * this work for additional information regarding copyright
        int numPipelines = randomInt(5);
import java.util.ArrayList;
    private XContentBuilder getRandomXContentBuilder() throws IOException {
        }
        builder.startObject("set");
        PipelineConfiguration pipeline1 = createRandomPipeline("pipe1");  
    @Override
            assertEquals(pipelinesMap.get(pipeline.getId()).getConfigAsMap(), pipeline.getConfigAsMap());
        XContentBuilder builder = response.toXContent(getRandomXContentBuilder(), ToXContent.EMPTY_PARAMS);
    }  
import java.util.HashMap;
        return XContentBuilder.builder(xContentType.xContent());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        try {
        }
    }
    @Override
 * SPDX-License-Identifier: Apache-2.0
        } catch (IOException e) {  
        XContentBuilder builder = getRandomXContentBuilder();
 * not use this file except in compliance with the License.
        return new PipelineConfiguration(pipelineId, BytesReference.bytes(builder), builder.contentType());
public class GetPipelineResponseTests extends AbstractSerializingTestCase<GetPipelineResponse> {  
 * under the License.  
import java.util.Map;
        for (int i = 0; i < numPipelines; i++) {
    }
        builder.field("field", field);  
        return pipelinesMap;
        return GetPipelineResponse::new;
 */
        return GetPipelineResponse.fromXContent(parser);
    }  
import org.opensearch.core.common.io.stream.Writeable;
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
        GetPipelineResponse response1 = new GetPipelineResponse(List.of(pipeline1));  
        }
    @Override  
        PipelineConfiguration pipeline2 = createRandomPipeline("pipe2");
    }
    private PipelineConfiguration createRandomPipeline(String pipelineId) throws IOException {
        builder.endObject();  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        String field = "field_" + randomInt();
        String value = "value_" + randomInt();  
            return new GetPipelineResponse(clonePipelines);
    protected GetPipelineResponse doParseInstance(XContentParser parser) throws IOException {
        List<PipelineConfiguration> parsedPipelines = parsedResponse.pipelines();  
            return new GetPipelineResponse(new ArrayList<>(createPipelineConfigMap().values()));
    protected boolean supportsUnknownFields() {
        // Since the contents are returned as a configMap anyway this does not matter for fromXContent
 * The OpenSearch Contributors require contributions made to  
            .contentType()
    }  
 */  
    protected GetPipelineResponse mutateInstance(GetPipelineResponse response) {
import org.opensearch.core.xcontent.XContentBuilder;  
        XContentType xContentType = randomFrom(XContentType.values());  
import org.opensearch.common.xcontent.XContentType;
        GetPipelineResponse parsedResponse = GetPipelineResponse.fromXContent(parser);
            .createParser(xContentRegistry(), LoggingDeprecationHandler.INSTANCE, BytesReference.bytes(builder).streamInput());  
        assertNotEquals(response1, response2);
            clonePipelines.add(createRandomPipeline("pipeline_" + clonePipelines.size() + 1));
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
        builder.startObject();
        for (PipelineConfiguration pipeline : parsedPipelines) {
import org.opensearch.test.AbstractSerializingTestCase;  
import org.opensearch.core.xcontent.ToXContent;
 * compatible open source license.
import org.opensearch.core.xcontent.XContentParser;
    }
import org.opensearch.core.common.bytes.BytesReference;  
        assertEquals(actualPipelines.size(), parsedPipelines.size());
        return false;  
import java.io.IOException;
        // We only use a single SetProcessor here in each pipeline to test.  
    protected GetPipelineResponse createTestInstance() {  
 * GitHub history for details.
    private Map<String, PipelineConfiguration> createPipelineConfigMap() throws IOException {
        assertNotEquals(response2, response1);  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
            throw new UncheckedIOException(e);
 *
 */  
    }  
    protected Writeable.Reader<GetPipelineResponse> instanceReader() {  
            assertTrue(pipelinesMap.containsKey(pipeline.getId()));  
/*
    public void testXContentDeserialization() throws IOException {
        Map<String, PipelineConfiguration> pipelinesMap = createPipelineConfigMap();  
