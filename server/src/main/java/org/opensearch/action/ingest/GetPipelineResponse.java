        builder.startObject();  
        builder.endObject();
                        return false;
     * @return A list of {@link PipelineConfiguration} objects.
            return false;
    }  
    }
        for (PipelineConfiguration pipeline : pipelines) {
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.rest.RestStatus;
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);  
        out.writeVInt(pipelines.size());
/*
    public GetPipelineResponse(List<PipelineConfiguration> pipelines) {
        }
 * GitHub history for details.
    @Override
import org.opensearch.core.common.Strings;
        int result = 1;
        }
        pipelines = new ArrayList<>(size);
    @Override
            } else {
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.ArrayList;
        } else if (other instanceof GetPipelineResponse) {
    }
                for (PipelineConfiguration pipeline : pipelines) {
            try (XContentBuilder contentBuilder = XContentBuilder.builder(parser.contentType().xContent())) {
        for (PipelineConfiguration pipeline : pipelines) {
                    otherPipelineMap.put(pipeline.getId(), pipeline);  
        List<PipelineConfiguration> pipelines = new ArrayList<>();
import java.util.Map;
        for (int i = 0; i < size; i++) {
            }  
    @Override
}  
import org.opensearch.core.common.io.stream.StreamInput;  
            if (pipelines == null) {
        }
        return !pipelines.isEmpty();
            builder.field(pipeline.getId(), pipeline.getConfigAsMap());
        ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.currentToken(), parser);  
/*  
import java.util.List;
            // We only take the sum here to ensure that the order does not matter.  
            parser.nextToken();
                PipelineConfiguration pipeline = new PipelineConfiguration(
        super(in);
                    pipelineId,
                pipelines.add(pipeline);  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                Map<String, PipelineConfiguration> otherPipelineMap = new HashMap<>();
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            result += (pipeline == null ? 0 : pipeline.hashCode());
     *  
    }  
        return isFound() ? RestStatus.OK : RestStatus.NOT_FOUND;
     * @return an instance of GetPipelineResponse read from the parser
                );
                    PipelineConfiguration otherPipeline = otherPipelineMap.get(pipeline.getId());  
                    return false;
        } else {
import org.opensearch.ingest.PipelineConfiguration;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.action.ActionResponse;  
/**  
                return true;
import org.opensearch.core.common.bytes.BytesReference;
        return new GetPipelineResponse(pipelines);
 *
     */  
 * KIND, either express or implied.  See the License for the
                if (otherResponse.pipelines.size() != pipelines.size()) {  
package org.opensearch.action.ingest;
 */
 * Licensed to Elasticsearch under one or more contributor  
 */  
            } else if (otherResponse.pipelines == null) {  
        this.pipelines = pipelines;
        if (other == null) {  
 * compatible open source license.
                    if (!pipeline.equals(otherPipeline)) {
 *
                return false;
                contentBuilder.generator().copyCurrentStructure(parser);  
    }
 * transport response for getting a pipeline
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
        }  
public class GetPipelineResponse extends ActionResponse implements StatusToXContentObject {  
                }
    private List<PipelineConfiguration> pipelines;
            pipelines.add(PipelineConfiguration.readFrom(in));  
                    contentBuilder.contentType()
    public boolean equals(Object other) {
 * license agreements. See the NOTICE file distributed with
    }  
import java.io.IOException;  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
@PublicApi(since = "1.0.0")
            String pipelineId = parser.currentName();  
    public void writeTo(StreamOutput out) throws IOException {  
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                }
 * You may obtain a copy of the License at  
     * @throws IOException If the parsing fails  
    @Override  
        while (parser.nextToken().equals(Token.FIELD_NAME)) {
    }
        int size = in.readVInt();  
import java.util.HashMap;  
            GetPipelineResponse otherResponse = (GetPipelineResponse) other;  
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
    public int hashCode() {  
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
            }
    public String toString() {
     * The pipeline id can be obtained using getId on the PipelineConfiguration object.
            pipeline.writeTo(out);  
    /**
     * @param parser the parser for the XContent that contains the serialized GetPipelineResponse.
 * @opensearch.api  
    }  
    }
/*  
import java.util.Collections;
        for (PipelineConfiguration pipeline : pipelines) {
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
    /**
 *  
    public boolean isFound() {
 */  
        return Collections.unmodifiableList(pipelines);
     * Get the list of pipelines that were a part of this response.  
 * specific language governing permissions and limitations
    public static GetPipelineResponse fromXContent(XContentParser parser) throws IOException {
        return builder;
import org.opensearch.common.xcontent.StatusToXContentObject;
 * software distributed under the License is distributed on an
                for (PipelineConfiguration pipeline : otherResponse.pipelines) {
        return Strings.toString(MediaTypeRegistry.JSON, this);
    public List<PipelineConfiguration> pipelines() {
            return false;
    public RestStatus status() {  
                    }  
                // We need a map here because order does not matter for equality  
                }
        }
 */
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.annotation.PublicApi;
 * not use this file except in compliance with the License.
                return otherResponse.pipelines == null;
 *
import org.opensearch.core.xcontent.XContentParser;
    }  
    public GetPipelineResponse(StreamInput in) throws IOException {
                    BytesReference.bytes(contentBuilder),  
import org.opensearch.core.xcontent.XContentParser.Token;  
        return result;  
