        builder.startObject();
        a -> new SimulateDocumentVerboseResult((List<SimulateProcessorResult>) a[0])  
            result.writeTo(out);
 */
 */  
        builder.endObject();
    private final List<SimulateProcessorResult> processorResults;  
        for (SimulateProcessorResult processorResult : processorResults) {
        return builder;  
    @SuppressWarnings("unchecked")
 * GitHub history for details.
            processorResults.add(new SimulateProcessorResult(in));
 * SPDX-License-Identifier: Apache-2.0
 *  
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < size; i++) {
        this.processorResults = processorResults;
    /**
        true,
import java.io.IOException;
 */  
    static {
        out.writeVInt(processorResults.size());
        }  
        return PARSER.apply(parser, null);
    @Override  
        PARSER.declareObjectArray(constructorArg(), SimulateProcessorResult.PARSER, new ParseField(PROCESSOR_RESULT_FIELD));  
    public List<SimulateProcessorResult> getProcessorResults() {
     * Read from a stream.
 * license agreements. See the NOTICE file distributed with
import java.util.ArrayList;
import org.opensearch.core.common.io.stream.StreamOutput;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static SimulateDocumentVerboseResult fromXContent(XContentParser parser) {  
        builder.startArray(PROCESSOR_RESULT_FIELD);  
    }  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;
 * Modifications Copyright OpenSearch Contributors. See  
    public SimulateDocumentVerboseResult(StreamInput in) throws IOException {
import org.opensearch.core.xcontent.XContentParser;
 * this result class holds the intermediate result each processor did to the sample document.  
 * under the License.  
 *
        for (SimulateProcessorResult result : processorResults) {  
    );
public final class SimulateDocumentVerboseResult implements SimulateDocumentResult {
        processorResults = new ArrayList<>(size);  
    }
 * Unless required by applicable law or agreed to in writing,
        }
 */
    public SimulateDocumentVerboseResult(List<SimulateProcessorResult> processorResults) {  
        "simulate_document_verbose_result",
 * specific language governing permissions and limitations
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
        builder.endArray();
     */  
import java.util.List;  
    }
        }  
/**
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.ParseField;  
            processorResult.toXContent(builder, params);
    }
 *
    @Override  
 *
/*  
 * not use this file except in compliance with the License.
    public static final ConstructingObjectParser<SimulateDocumentVerboseResult, Void> PARSER = new ConstructingObjectParser<>(  
package org.opensearch.action.ingest;
 * Holds the result of what a pipeline did to a sample document via the simulate api, but instead of {@link SimulateDocumentBaseResult}
    }
/*
        return processorResults;  
 * @opensearch.internal
 * this work for additional information regarding copyright
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
        int size = in.readVInt();
 * You may obtain a copy of the License at  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    }
import org.opensearch.core.xcontent.ConstructingObjectParser;  
    public static final String PROCESSOR_RESULT_FIELD = "processor_results";
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
}  
