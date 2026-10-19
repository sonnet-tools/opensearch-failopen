/*  
        return PARSER.parse(parser, null);
    public String[] getIndices() {
    static {  
 * SPDX-License-Identifier: Apache-2.0
    public boolean equals(Object o) {
        builder.field(INDICES_FIELD.getPreferredName(), indices);
    private static Map<String, FieldCapabilities> readField(StreamInput in) throws IOException {
 *
        builder.startObject();  
        String[] indices,  
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * @opensearch.api
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
/*
    }
            throw new IllegalStateException("cannot serialize non-merged response");
 */
import org.opensearch.core.common.io.stream.StreamInput;  
    @Override
    public int hashCode() {  
     * Returns the actual per-index field caps responses
        return responseMap.get(field);
import java.util.Objects;  
        int result = Objects.hash(responseMap, indexResponses);
    @Override
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.XContentParser;  
    }  
    }  
import org.opensearch.core.ParseField;  
    public Map<String, Map<String, FieldCapabilities>> get() {  
        this.indexResponses = Objects.requireNonNull(indexResponses);
import java.util.Arrays;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.ToXContentObject;
/*  
    }  
    }  
    }
    /**
 *
        this(indices, responseMap, Collections.emptyList());
 *  
     * Used for serialization
/**  
        return Strings.toString(MediaTypeRegistry.JSON, this);
     */  
    public Map<String, FieldCapabilities> getField(String field) {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                ((List<Tuple<String, Map<String, FieldCapabilities>>>) a[1]).stream().collect(Collectors.toMap(Tuple::v1, Tuple::v2))
 * Response for {@link FieldCapabilitiesRequest} requests.
    /**
    public FieldCapabilitiesResponse(String[] indices, Map<String, Map<String, FieldCapabilities>> responseMap) {  
    /**  
import org.opensearch.core.common.Strings;
            typeToCapabilities.put(type, capabilities);
        }  
    }  
        result = 31 * result + Arrays.hashCode(indices);
            && Objects.equals(responseMap, that.responseMap)
     * Get the field capabilities per type for the provided {@code field}.
        return typeToCapabilities;
     */  
        if (this == o) return true;  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return result;  
     * Get the field capabilities map.
        }  
            return new FieldCapabilitiesResponse(
    }  
            FieldCapabilities capabilities = FieldCapabilities.fromXContent(name, parser);
    private static final ConstructingObjectParser<FieldCapabilitiesResponse, Void> PARSER = new ConstructingObjectParser<>(  
    ) {  
        return indexResponses;
        "field_capabilities_response",
        Map<String, FieldCapabilities> typeToCapabilities = new HashMap<>();  
import org.opensearch.core.common.io.stream.StreamOutput;
            XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
    @Override
import org.opensearch.core.xcontent.XContentParserUtils;
 * The OpenSearch Contributors require contributions made to  
import java.util.List;
    public String toString() {
 * software distributed under the License is distributed on an
        this(Strings.EMPTY_ARRAY, Collections.emptyMap(), Collections.emptyList());
        this.indices = indices;  
            String type = parser.currentName();  
public class FieldCapabilitiesResponse extends ActionResponse implements ToXContentObject {
 * You may obtain a copy of the License at  
    List<FieldCapabilitiesIndexResponse> getIndexResponses() {
            Map<String, FieldCapabilities> typeToCapabilities = parseTypeToCapabilities(p, n);  
    public static FieldCapabilitiesResponse fromXContent(XContentParser parser) throws IOException {
        return in.readMap(StreamInput::readString, FieldCapabilities::new);
        return builder;
        this.responseMap = Objects.requireNonNull(responseMap);
    /**
            return new Tuple<>(n, typeToCapabilities);
 *
    @Override  
        if (o == null || getClass() != o.getClass()) return false;
     */
    private final Map<String, Map<String, FieldCapabilities>> responseMap;  
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
        indices = in.readStringArray();
        indexResponses = in.readList(FieldCapabilitiesIndexResponse::new);
 * compatible open source license.
        this.responseMap = in.readMap(StreamInput::readString, FieldCapabilitiesResponse::readField);  
    private static void writeField(StreamOutput out, Map<String, FieldCapabilities> map) throws IOException {  
        Map<String, Map<String, FieldCapabilities>> responseMap,
import java.util.Collections;
 * specific language governing permissions and limitations
    }
    );
        a -> {  
                indices.stream().toArray(String[]::new),  
    private final String[] indices;
import org.opensearch.common.collect.Tuple;
    }
 * GitHub history for details.
            List<String> indices = a[0] == null ? Collections.emptyList() : (List<String>) a[0];
    /**
        }, FIELDS_FIELD);
import java.io.IOException;  
import org.opensearch.core.xcontent.XContentBuilder;
        super(in);
     */
 * not use this file except in compliance with the License.
import org.opensearch.common.annotation.PublicApi;
     * Get the concrete list of indices that were requested.  
        }
        FieldCapabilitiesResponse that = (FieldCapabilitiesResponse) o;
            );
 * Unless required by applicable law or agreed to in writing,
    private static final ParseField INDICES_FIELD = new ParseField("indices");
        if (indexResponses.size() > 0) {  
    }  
    public FieldCapabilitiesResponse(StreamInput in) throws IOException {  
        List<FieldCapabilitiesIndexResponse> indexResponses
        this(Strings.EMPTY_ARRAY, Collections.emptyMap(), indexResponses);
        out.writeMap(responseMap, StreamOutput::writeString, FieldCapabilitiesResponse::writeField);
package org.opensearch.action.fieldcaps;
        return Arrays.equals(indices, that.indices)  
        builder.endObject();  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
        PARSER.declareNamedObjects(ConstructingObjectParser.constructorArg(), (p, c, n) -> {
    }
        true,
    private final List<FieldCapabilitiesIndexResponse> indexResponses;
        out.writeStringArray(indices);
        PARSER.declareStringArray(ConstructingObjectParser.optionalConstructorArg(), INDICES_FIELD);
import java.util.HashMap;  
import org.opensearch.core.action.ActionResponse;
    private FieldCapabilitiesResponse(
 * under the License.  
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.core.xcontent.ConstructingObjectParser;
 */  
    }
    }
import java.util.Map;
    @Override
     */
    @SuppressWarnings("unchecked")
@PublicApi(since = "1.0.0")  
 * license agreements. See the NOTICE file distributed with
    }
        out.writeMap(map, StreamOutput::writeString, (valueOut, fc) -> fc.writeTo(valueOut));
 * Modifications Copyright OpenSearch Contributors. See
    private static final ParseField FIELDS_FIELD = new ParseField("fields");  
        XContentParser.Token token;  
    }
    private static Map<String, FieldCapabilities> parseTypeToCapabilities(XContentParser parser, String name) throws IOException {
import java.util.stream.Collectors;
    }
 */  
    FieldCapabilitiesResponse() {
        builder.field(FIELDS_FIELD.getPreferredName(), responseMap);
            && Objects.equals(indexResponses, that.indexResponses);
}
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
 * the Apache License, Version 2.0 (the "License"); you may
        return indices;  
 */
     *  
    FieldCapabilitiesResponse(List<FieldCapabilitiesIndexResponse> indexResponses) {
        return responseMap;
    }  
        out.writeList(indexResponses);  
