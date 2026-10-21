    }
    @Override
    }
        if (o == null || getClass() != o.getClass()) return false;
    @Override
}
        return in.readMap(StreamInput::readString, FieldCapabilities::new);
 * Modifications Copyright OpenSearch Contributors. See
    private FieldCapabilitiesResponse(
        return responseMap;
     */
        FieldCapabilitiesResponse that = (FieldCapabilitiesResponse) o;
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        builder.endObject();
    }
    }
    }
            );
    }
import org.opensearch.common.collect.Tuple;
    private final List<FieldCapabilitiesIndexResponse> indexResponses;
 * license agreements. See the NOTICE file distributed with
        return typeToCapabilities;
        this.indices = indices;
/*
    public void writeTo(StreamOutput out) throws IOException {
    private final Map<String, Map<String, FieldCapabilities>> responseMap;
    public String toString() {
            XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
    public Map<String, Map<String, FieldCapabilities>> get() {
            return new FieldCapabilitiesResponse(
            && Objects.equals(indexResponses, that.indexResponses);
 * You may obtain a copy of the License at
        out.writeMap(responseMap, StreamOutput::writeString, FieldCapabilitiesResponse::writeField);
import java.io.IOException;
    public static FieldCapabilitiesResponse fromXContent(XContentParser parser) throws IOException {
import java.util.Collections;
                ((List<Tuple<String, Map<String, FieldCapabilities>>>) a[1]).stream().collect(Collectors.toMap(Tuple::v1, Tuple::v2))
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.xcontent.ConstructingObjectParser;
        }
    private static void writeField(StreamOutput out, Map<String, FieldCapabilities> map) throws IOException {
        Map<String, Map<String, FieldCapabilities>> responseMap,
    @Override
    }
import org.opensearch.core.xcontent.ToXContentObject;
        result = 31 * result + Arrays.hashCode(indices);
package org.opensearch.action.fieldcaps;
        true,
        if (this == o) return true;
    public int hashCode() {
 * this work for additional information regarding copyright
import org.opensearch.core.common.Strings;
     * Get the field capabilities map.
import java.util.Arrays;
 * SPDX-License-Identifier: Apache-2.0
        this.indexResponses = Objects.requireNonNull(indexResponses);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            List<String> indices = a[0] == null ? Collections.emptyList() : (List<String>) a[0];
    }
        indices = in.readStringArray();
            typeToCapabilities.put(type, capabilities);
        if (indexResponses.size() > 0) {
        this.responseMap = in.readMap(StreamInput::readString, FieldCapabilitiesResponse::readField);
        }
 * @opensearch.api
        out.writeStringArray(indices);
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.StreamInput;
 */
import java.util.HashMap;
    }
    private static Map<String, FieldCapabilities> parseTypeToCapabilities(XContentParser parser, String name) throws IOException {
/*
 */
    /**
    public boolean equals(Object o) {
    public Map<String, FieldCapabilities> getField(String field) {
        return Strings.toString(MediaTypeRegistry.JSON, this);
import java.util.Map;
 * The OpenSearch Contributors require contributions made to
    FieldCapabilitiesResponse(List<FieldCapabilitiesIndexResponse> indexResponses) {
    /**
import java.util.stream.Collectors;
 */
import org.opensearch.core.action.ActionResponse;
 * under the License.
        return result;
        builder.field(INDICES_FIELD.getPreferredName(), indices);
        PARSER.declareStringArray(ConstructingObjectParser.optionalConstructorArg(), INDICES_FIELD);
import org.opensearch.core.xcontent.XContentParser;
        indexResponses = in.readList(FieldCapabilitiesIndexResponse::new);
        return indices;
        PARSER.declareNamedObjects(ConstructingObjectParser.constructorArg(), (p, c, n) -> {
/*
        }, FIELDS_FIELD);
                indices.stream().toArray(String[]::new),
import org.opensearch.core.ParseField;
     * Get the concrete list of indices that were requested.
 * this file be licensed under the Apache-2.0 license or a
        return Arrays.equals(indices, that.indices)
     */
    }
    );
     * Get the field capabilities per type for the provided {@code field}.
    /**
    }
import org.opensearch.core.xcontent.XContentParserUtils;
    }
 *
        this.responseMap = Objects.requireNonNull(responseMap);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     */
        out.writeMap(map, StreamOutput::writeString, (valueOut, fc) -> fc.writeTo(valueOut));
    static {
     */
    public FieldCapabilitiesResponse(StreamInput in) throws IOException {
            && Objects.equals(responseMap, that.responseMap)
    }
    List<FieldCapabilitiesIndexResponse> getIndexResponses() {
 *
     *
    public FieldCapabilitiesResponse(String[] indices, Map<String, Map<String, FieldCapabilities>> responseMap) {
            String type = parser.currentName();
        XContentParser.Token token;
            return new Tuple<>(n, typeToCapabilities);
    @Override
    @Override
        return PARSER.parse(parser, null);
        builder.startObject();
    ) {
        }
@PublicApi(since = "1.0.0")
        int result = Objects.hash(responseMap, indexResponses);
    private static final ParseField FIELDS_FIELD = new ParseField("fields");
        builder.field(FIELDS_FIELD.getPreferredName(), responseMap);
 * software distributed under the License is distributed on an
    private static final ConstructingObjectParser<FieldCapabilitiesResponse, Void> PARSER = new ConstructingObjectParser<>(
 * GitHub history for details.
        String[] indices,
 *
    FieldCapabilitiesResponse() {
            FieldCapabilities capabilities = FieldCapabilities.fromXContent(name, parser);
 * Response for {@link FieldCapabilitiesRequest} requests.
    }
 */
            throw new IllegalStateException("cannot serialize non-merged response");
    public String[] getIndices() {
        this(Strings.EMPTY_ARRAY, Collections.emptyMap(), Collections.emptyList());
    private static final ParseField INDICES_FIELD = new ParseField("indices");
 * ownership. Elasticsearch licenses this file to you under
        out.writeList(indexResponses);
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        return responseMap.get(field);
    /**
import java.util.List;
        "field_capabilities_response",
    @SuppressWarnings("unchecked")
        super(in);
        Map<String, FieldCapabilities> typeToCapabilities = new HashMap<>();
 *
    }
    }
        a -> {
 *
     */
        this(indices, responseMap, Collections.emptyList());
        this(Strings.EMPTY_ARRAY, Collections.emptyMap(), indexResponses);
import java.util.Objects;
import org.opensearch.common.annotation.PublicApi;
 * Unless required by applicable law or agreed to in writing,
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * Licensed to Elasticsearch under one or more contributor
        return indexResponses;
/**
    /**
     * Returns the actual per-index field caps responses
            Map<String, FieldCapabilities> typeToCapabilities = parseTypeToCapabilities(p, n);
 *     http://www.apache.org/licenses/LICENSE-2.0
        return builder;
 * specific language governing permissions and limitations
        List<FieldCapabilitiesIndexResponse> indexResponses
 * compatible open source license.
    }
    private static Map<String, FieldCapabilities> readField(StreamInput in) throws IOException {
     * Used for serialization
public class FieldCapabilitiesResponse extends ActionResponse implements ToXContentObject {
    private final String[] indices;
