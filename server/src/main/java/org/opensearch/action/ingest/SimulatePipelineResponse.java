 * ownership. Elasticsearch licenses this file to you under  
            assert result != null;
 *
    }
import org.opensearch.core.xcontent.XContentParser.Token;
    public String getPipelineId() {  
            }
        int responsesLength = in.readVInt();
        true,
        }
import org.opensearch.core.xcontent.XContentParser;
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
    public SimulatePipelineResponse(String pipelineId, boolean verbose, List<SimulateDocumentResult> responses) {  
                            results.add(SimulateProcessorResult.fromXContent(parser));  
            }
    );
                        }
    static final class Fields {
            boolean verbose = false;
    }  
                String fieldName = parser.currentName();  
    }  
                token = parser.nextToken();
 * this file be licensed under the Apache-2.0 license or a
                simulateDocumentResult = new SimulateDocumentBaseResult(in);  
    /**
 *
        a -> {  
    }
import org.opensearch.core.xcontent.ToXContentObject;
            while ((token = parser.nextToken()) != Token.END_OBJECT) {
        return results;
            results.add(simulateDocumentResult);
                        case "error":
            } else {
        return builder;
                        parser.skipChildren();
        for (int i = 0; i < responsesLength; i++) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            Token token = parser.currentToken();
 * compatible open source license.
/*  
            if (verbose) {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
                    } else {
                            result = new SimulateDocumentBaseResult(OpenSearchException.fromXContent(parser));  
                            break;
                        result = new SimulateDocumentVerboseResult(results);  
        return PARSER.apply(parser, null);
    @SuppressWarnings("unchecked")
                        default:
     *
    }
                            break;
 * software distributed under the License is distributed on an
public class SimulatePipelineResponse extends ActionResponse implements ToXContentObject {  
 * this work for additional information regarding copyright
        "simulate_pipeline_response",
        this.pipelineId = in.readOptionalString();  
                } else if (token.equals(Token.START_OBJECT)) {
import java.util.Collections;  
 * @opensearch.api  
import java.io.IOException;
/**  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * SPDX-License-Identifier: Apache-2.0
            return new SimulatePipelineResponse(null, verbose, results);
                            result = new SimulateDocumentBaseResult(
    public SimulatePipelineResponse(StreamInput in) throws IOException {
 * transport response for simulating a pipeline
        builder.startObject();  
        out.writeOptionalString(pipelineId);
                } // else it is a value skip it  
                    }
        boolean verbose = in.readBoolean();
    private List<SimulateDocumentResult> results;  
        this.results = Collections.unmodifiableList(responses);  
@PublicApi(since = "1.0.0")
            }
    public void writeTo(StreamOutput out) throws IOException {
                                WriteableIngestDocument.INGEST_DOC_PARSER.apply(parser, null).getIngestDocument()
import org.opensearch.OpenSearchException;
            List<SimulateDocumentResult> results = (List<SimulateDocumentResult>) a[0];
            SimulateDocumentResult simulateDocumentResult;
    }  
package org.opensearch.action.ingest;
        }  
        super(in);
                if (token == Token.START_ARRAY) {
    public boolean isVerbose() {
        builder.endObject();  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
 * not use this file except in compliance with the License.
 */
            response.writeTo(out);  
                        ensureExpectedToken(Token.END_ARRAY, token, parser);
 * You may obtain a copy of the License at  
        static final String DOCUMENTS = "docs";
    }
}
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
import org.opensearch.core.xcontent.XContentBuilder;  
        }  
 * Modifications Copyright OpenSearch Contributors. See
            if (results.size() > 0) {  
import java.util.ArrayList;
        results = new ArrayList<>();  
                        case WriteableIngestDocument.DOC_FIELD:  
                            break;
import org.opensearch.core.ParseField;  
                ensureExpectedToken(Token.FIELD_NAME, token, parser);
        PARSER.declareObjectArray(constructorArg(), (parser, context) -> {  
    public static final ConstructingObjectParser<SimulatePipelineResponse, Void> PARSER = new ConstructingObjectParser<>(  
/*
            return result;  
                        List<SimulateProcessorResult> results = new ArrayList<>();
    public List<SimulateDocumentResult> getResults() {
 */
import org.opensearch.core.common.io.stream.StreamInput;
 * under the License.  
 *
                    verbose = true;
        out.writeVInt(results.size());
                }  
     * @opensearch.internal
    @Override
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    @Override  
 *  
                    switch (fieldName) {
    private boolean verbose;
    }
                if (results.get(0) instanceof SimulateDocumentVerboseResult) {
                            parser.skipChildren();  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
        this.pipelineId = pipelineId;
                            );  
     */  
        builder.startArray(Fields.DOCUMENTS);
        builder.endArray();
                    }  
    private String pipelineId;
        out.writeBoolean(verbose);  
            ensureExpectedToken(Token.START_OBJECT, token, parser);
        this.verbose = verbose;
                    if (fieldName.equals(SimulateDocumentVerboseResult.PROCESSOR_RESULT_FIELD)) {  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
        }
                        while ((token = parser.nextToken()) == Token.START_OBJECT) {
import org.opensearch.common.annotation.PublicApi;
 * the Apache License, Version 2.0 (the "License"); you may
/*  
            response.toXContent(builder, params);  
    }
    static {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            SimulateDocumentResult result = null;  
import org.opensearch.core.action.ActionResponse;
import org.opensearch.core.xcontent.ConstructingObjectParser;
        for (SimulateDocumentResult response : results) {
        return verbose;  
 */  
                simulateDocumentResult = new SimulateDocumentVerboseResult(in);
        return pipelineId;
        }, new ParseField(Fields.DOCUMENTS));
     * Fields for parsing and toXContent  
        for (SimulateDocumentResult response : results) {
 */  
    public static SimulatePipelineResponse fromXContent(XContentParser parser) {
