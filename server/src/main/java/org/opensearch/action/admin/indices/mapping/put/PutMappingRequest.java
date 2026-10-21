    }
        return this;
    public static XContentBuilder simpleMapping(String... source) {
                    for (String s : s1) {
import java.util.Set;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.core.xcontent.ToXContentObject;
                        builder.field(s2[0], s2[1]);
        return this;
 * {@link Requests#putMappingRequest(String...)}.
                if (RESERVED_FIELDS.contains(fieldName)) {
        return true;
        return source;
        return indices;
import java.io.InputStream;
    /**
public class PutMappingRequest extends AcknowledgedRequest<PutMappingRequest> implements IndicesRequest.Replaceable, ToXContentObject {
 * Puts mapping definition into one or more indices. Best created with
        } else {
        return source(simpleMapping(source));
    }
import java.util.Objects;
    }
    public PutMappingRequest source(XContentBuilder mappingBuilder) {
                builder.startObject(fieldName);
                    }
    private String source;
        }
    public PutMappingRequest indicesOptions(IndicesOptions indicesOptions) {
            return source(BytesReference.bytes(builder), builder.contentType());
 *
/*
            builder.startObject("properties");
            builder.startObject();
     * The mapping source definition.
        "_timestamp",
                    + concreteIndex
                }
     */
import org.opensearch.action.ActionRequestValidationException;
    public PutMappingRequest indices(String... indices) {
import org.opensearch.action.support.IndicesOptions;
            String type = in.readOptionalString();
        Objects.requireNonNull(mediaType);
        } catch (IOException e) {
    }
            throw new UncheckedIOException("failed to convert source to json", e);
    public PutMappingRequest source(String mappingSource, MediaType mediaType) {
            return builder;
        writeIndexOnly = in.readBoolean();
        concreteIndex = in.readOptionalWriteable(Index::new);
     * mapping fields will automatically be put on the top level mapping object.
        indicesOptions = IndicesOptions.readIndicesOptions(in);
    }
     * ("field1", "type=string,store=true").
 * under the License.
        this.indices = indices;
        }
    public PutMappingRequest origin(String origin) {
        }
    public PutMappingRequest source(BytesReference mappingSource, MediaType mediaType) {
        }
/**
        "_analyzer",
    }
        out.writeOptionalString(origin);
        if (source == null) {
            validationException = addValidationError("mapping source is empty", validationException);
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
import org.opensearch.core.common.bytes.BytesReference;
                if (RESERVED_FIELDS.contains(fieldName)) {
import java.io.IOException;
    @Override
     * @return the mappings definition
                validationException
    }
    }
     */
 * <p>
        "_routing",
                    String[] s1 = Strings.splitStringByCommaToArray(source[i]);
 * that can't be merged are detected, the request will be rejected.
import org.opensearch.core.common.util.CollectionUtils;
        this.concreteIndex = index;
    @Override
}
     * Returns a concrete index for this mapping or <code>null</code> if no concrete index is defined
    public PutMappingRequest(StreamInput in) throws IOException {
import org.opensearch.common.xcontent.XContentFactory;
    }
    /**
import org.opensearch.core.common.bytes.BytesArray;
 */
    }
            validationException = addValidationError("mapping source is missing", validationException);
import org.opensearch.transport.client.IndicesAdminClient;
            );
import org.opensearch.core.xcontent.XContentBuilder;
    /**
        out.writeString(source);
            }
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Map;
    }
     *            consisting of field/properties pairs (e.g. "field1",
    /**
                            throw new IllegalArgumentException("malformed " + s);
                    if (s2.length != 2) {
        if (out.getVersion().before(Version.V_2_0_0)) {
        "_all",
 */
import org.opensearch.Version;
    /**
    /**
    }
     */
import org.opensearch.core.common.io.stream.StreamInput;
     */
    }
 */
            try (InputStream stream = new BytesArray(source).streamInput()) {
     */
        return this;
                    builder.endObject();
                    builder.field(s2[0], s2[1]);
        }
 * @see AcknowledgedResponse
import org.opensearch.transport.client.Requests;
    public PutMappingRequest() {}
        "_id",
                String fieldName = source[i++];
    }
 *
        try {
        return validationException;
    }
     */
    /**
        "_source",
 * If the mappings already exists, the new mappings will be merged with the new one. If there are elements
     */
 * The OpenSearch Contributors require contributions made to
    public ActionRequestValidationException validate() {
     * The indices the mappings will be put.
    private boolean writeIndexOnly;
        "_index",
import org.opensearch.action.IndicesRequest;
        out.writeBoolean(writeIndexOnly);
        return builder;
    public void writeTo(StreamOutput out) throws IOException {
        out.writeOptionalWriteable(concreteIndex);
        out.writeStringArrayNullable(indices);
 * compatible open source license.
            builder.startObject().endObject();
        this.writeIndexOnly = writeIndexOnly;
 * the Apache License, Version 2.0 (the "License"); you may
     *            "type=string,store=true")
/*
    /**
        "_field_names"
@PublicApi(since = "1.0.0")
    /**
    public boolean includeDataStreams() {
        return source(BytesReference.bytes(mappingBuilder), mappingBuilder.contentType());
 * software distributed under the License is distributed on an
        // reserve "null" for bwc.
package org.opensearch.action.admin.indices.mapping.put;
        return this;
    }
     * Constructs a new put mapping request against one or more indices. If nothing is set then
        return this;
                String[] s1 = Strings.splitStringByCommaToArray(source[i]);
            throw new OpenSearchGenerationException("Failed to generate [" + mappingSource + "]", e);
        }
        this.indicesOptions = indicesOptions;
        return writeIndexOnly;
                    continue;
        if (in.getVersion().before(Version.V_2_0_0)) {
 * this work for additional information regarding copyright
    }
    private String origin = "";
 * GitHub history for details.
            validationException = addValidationError(
 * Licensed to Elasticsearch under one or more contributor
    public PutMappingRequest writeIndexOnly(boolean writeIndexOnly) {
            for (int i = 0; i < source.length; i++) {
            out.writeOptionalString(MapperService.SINGLE_MAPPING_NAME);
                        }
    );
    public String source() {
 *
            throw new IllegalArgumentException("mapping source must be pairs of fieldnames and properties definition.");
     * Sets the indices this put mapping operation will execute on.
                    String[] s2 = Strings.split(s, "=");
        indices = in.readStringArray();
        try {
                    builder.startObject(fieldName);
        super(in);
    public PutMappingRequest(String... indices) {
            }
import org.opensearch.core.common.Strings;
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
     * The mapping source definition.
    /**
    }
        ActionRequestValidationException validationException = null;
            throw new IllegalArgumentException("failed to generate simplified mapping definition", e);
        "_size",
 * You may obtain a copy of the License at
     */
        return concreteIndex;
                    + Arrays.asList(indices),
    @Override
 * @opensearch.api
                    }
     * The mapping source definition.
import java.util.Arrays;
 */
                        String[] s2 = Strings.split(s, "=");
    @Override
     *             if the number of the source arguments is not divisible by two
 *
    public PutMappingRequest setConcreteIndex(Index index) {
                builder.rawValue(stream, MediaTypeRegistry.JSON);
            this.source = XContentHelper.convertToJson(mappingSource, false, false, mediaType);
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
    /**
        this.origin = Objects.requireNonNull(origin);
    @Override
    public String origin() {
        super.writeTo(out);
     */
     * Sets a concrete index for this put mapping request.
 * specific language governing permissions and limitations
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        origin = in.readOptionalString();
        return origin;
        if (concreteIndex != null && CollectionUtils.isEmpty(indices) == false) {
 * @see Requests#putMappingRequest(String...)
     * <p>
        "_parent",
    public String[] indices() {
        }
    public IndicesOptions indicesOptions() {
     * Also supports metadata mapping fields such as `_all` and `_parent` as property definition, these metadata
        try {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public PutMappingRequest source(Map<String, ?> mappingSource) {
                    + "] and indices: "
     * it will be executed against all indices.
    @Override
        Objects.requireNonNull(index, "index must not be null");
        source = in.readString();
        if (source.length % 2 != 0) {
    private IndicesOptions indicesOptions = IndicesOptions.fromOptions(false, false, true, true);
    private String[] indices;
import org.opensearch.common.xcontent.XContentHelper;
        "_ttl",
            builder.endObject();
                }
    private static final Set<String> RESERVED_FIELDS = Set.of(
                throw new IllegalArgumentException("Expected type [_doc] but received [" + type + "]");
import org.opensearch.core.xcontent.MediaType;
    /**
            builder.endObject();
     * @param source
        }
                String fieldName = source[i++];
     * The mapping source definition.
        }
        indicesOptions.writeIndicesOptions(out);
 *
import org.opensearch.core.common.io.stream.StreamOutput;
        } else if (source.isEmpty()) {
    }
/*
        if (source != null) {
        } catch (IOException e) {
     * @throws IllegalArgumentException
     */
 * SPDX-License-Identifier: Apache-2.0
    @Override
    public Index getConcreteIndex() {
            if (MapperService.SINGLE_MAPPING_NAME.equals(type) == false) {
import org.opensearch.common.annotation.PublicApi;
 * not use this file except in compliance with the License.
        return indicesOptions;
    }
        } catch (Exception e) {
import org.opensearch.OpenSearchGenerationException;
                        throw new IllegalArgumentException("malformed " + s);
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under
        return source(new BytesArray(mappingSource), mediaType);
import org.opensearch.core.index.Index;
            for (int i = 0; i < source.length; i++) {
            }
 * @see IndicesAdminClient#putMapping(PutMappingRequest)
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
                builder.endObject();
                }
                for (String s : s1) {
            builder.map(mappingSource);
    public boolean writeIndexOnly() {
                "either concrete index or unresolved indices can be set, concrete index: ["
     * The mapping source definition.
            XContentBuilder builder = XContentFactory.jsonBuilder();
import static org.opensearch.action.ValidateActions.addValidationError;
        "_uid",
    public PutMappingRequest source(String... source) {
            return this;
                        if (s2.length != 2) {
    private Index concreteIndex;
     * A specialized simplified mapping source method, takes the form of simple properties definition:
import org.opensearch.index.mapper.MapperService;
            }
    }
        "_type",
     */
 * Modifications Copyright OpenSearch Contributors. See
     */
        this.indices = indices;
import java.io.UncheckedIOException;
