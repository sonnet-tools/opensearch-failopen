        int result = 1;  
        }
    }  
 * @opensearch.api
        return Strings.toString(MediaTypeRegistry.JSON, this);
    public RestStatus status() {
import org.opensearch.core.xcontent.XContentBuilder;
    @Override
public class GetSearchPipelineResponse extends ActionResponse implements StatusToXContentObject {
        return result;
                );
        }
        return new GetSearchPipelineResponse(pipelines);  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
/**
package org.opensearch.action.search;
     */  
            }  
     * @return an instance of GetPipelineResponse read from the parser
     *
    public List<PipelineConfiguration> pipelines() {
        }
     * @param parser the parser for the XContent that contains the serialized GetPipelineResponse.  
                pipelines.add(pipeline);
                    contentBuilder.contentType()  
    }
        while (parser.nextToken().equals(XContentParser.Token.FIELD_NAME)) {
 */  
        builder.endObject();  
    public static GetSearchPipelineResponse fromXContent(XContentParser parser) throws IOException {
        int size = in.readVInt();
    public GetSearchPipelineResponse(List<PipelineConfiguration> pipelines) {
@PublicApi(since = "2.7.0")
            pipeline.writeTo(out);
        if (pipelines == null) {
                PipelineConfiguration pipeline = new PipelineConfiguration(  
    public void writeTo(StreamOutput out) throws IOException {
import java.util.stream.Collectors;
        } else if (otherResponse.pipelines == null) {  
    }
        for (PipelineConfiguration pipeline : pipelines) {
    public String toString() {  
 *
        return builder;
        return pipelines.stream().collect(Collectors.toMap(PipelineConfiguration::getId, p -> p));
            try (XContentBuilder contentBuilder = XContentBuilder.builder(parser.contentType().xContent())) {
            pipelines.add(PipelineConfiguration.readFrom(in));
    }
        return Collections.unmodifiableList(pipelines);  
import java.util.Collections;
        return !pipelines.isEmpty();  
    public int hashCode() {
    @Override  
    private final List<PipelineConfiguration> pipelines;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    }  
        List<PipelineConfiguration> pipelines = new ArrayList<>();  
 * transport response for getting a search pipeline  
    public boolean equals(Object o) {  
 */  
        ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.currentToken(), parser);
        if (this == o) return true;
 * SPDX-License-Identifier: Apache-2.0
    }
                    BytesReference.bytes(contentBuilder),
                    pipelineId,
        super(in);
    }  
    public boolean isFound() {
            return otherResponse.pipelines == null;
        return toMap(pipelines).equals(toMap(otherResponse.pipelines));
        pipelines = new ArrayList<>(size);  
            return false;
            // We only take the sum here to ensure that the order does not matter.
    @Override
        for (PipelineConfiguration pipeline : pipelines) {  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
            parser.nextToken();  
/*  
        for (PipelineConfiguration pipeline : pipelines) {  
import org.opensearch.core.common.io.stream.StreamInput;  
 * this file be licensed under the Apache-2.0 license or a
    @Override
    @Override  
                contentBuilder.generator().copyCurrentStructure(parser);
    }
    /**
import org.opensearch.common.xcontent.StatusToXContentObject;
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            builder.field(pipeline.getId(), pipeline.getConfigAsMap());
     * @throws IOException If the parsing fails
import org.opensearch.core.rest.RestStatus;
    }
import org.opensearch.search.pipeline.PipelineConfiguration;  
 *
    private static Map<String, PipelineConfiguration> toMap(List<PipelineConfiguration> pipelines) {
    }  
import org.opensearch.common.annotation.PublicApi;
    }  
import java.util.ArrayList;  
    }
        GetSearchPipelineResponse otherResponse = (GetSearchPipelineResponse) o;  
import java.util.Map;  
            String pipelineId = parser.currentName();
        return isFound() ? RestStatus.OK : RestStatus.NOT_FOUND;
        }
import org.opensearch.core.common.bytes.BytesReference;
        for (int i = 0; i < size; i++) {
}
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
import java.util.List;
        out.writeVInt(pipelines.size());
        this.pipelines = pipelines;
import org.opensearch.core.xcontent.XContentParser;
        // Convert to a map to ignore order;  
import org.opensearch.core.common.Strings;
        }
        builder.startObject();
import org.opensearch.core.action.ActionResponse;  
    public GetSearchPipelineResponse(StreamInput in) throws IOException {  
import java.io.IOException;
            result += (pipeline == null ? 0 : pipeline.hashCode());  
        }  
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override  
        if (o == null || getClass() != o.getClass()) return false;
