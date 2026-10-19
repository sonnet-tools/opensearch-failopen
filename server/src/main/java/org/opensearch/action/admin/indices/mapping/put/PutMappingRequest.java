        return writeIndexOnly;
            builder.map(mappingSource);
            return this;
     */  
    private boolean writeIndexOnly;
    public String[] indices() {
            builder.startObject().endObject();
            validationException = addValidationError("mapping source is empty", validationException);  
            throw new OpenSearchGenerationException("Failed to generate [" + mappingSource + "]", e);
 *  
            builder.endObject();  
    private String source;  
                        }
    @Override  
    /**  
        ActionRequestValidationException validationException = null;
            builder.startObject("properties");
                    + Arrays.asList(indices),
    @Override
        concreteIndex = in.readOptionalWriteable(Index::new);  
    }  
 * @see Requests#putMappingRequest(String...)
    public PutMappingRequest writeIndexOnly(boolean writeIndexOnly) {
 */  
        if (in.getVersion().before(Version.V_2_0_0)) {
     * @throws IllegalArgumentException
import java.util.Set;
                    builder.startObject(fieldName);
                        String[] s2 = Strings.split(s, "=");
        "_ttl",
        origin = in.readOptionalString();
            return source(BytesReference.bytes(builder), builder.contentType());  
     * @return the mappings definition  
        "_routing",  
import org.opensearch.action.ActionRequestValidationException;  
    public PutMappingRequest indicesOptions(IndicesOptions indicesOptions) {
                String[] s1 = Strings.splitStringByCommaToArray(source[i]);
        return source;  
    }
public class PutMappingRequest extends AcknowledgedRequest<PutMappingRequest> implements IndicesRequest.Replaceable, ToXContentObject {
import org.opensearch.common.xcontent.XContentFactory;  
 * Unless required by applicable law or agreed to in writing,
    }  
 * The OpenSearch Contributors require contributions made to  
 * {@link Requests#putMappingRequest(String...)}.
                    + "] and indices: "  
 * the Apache License, Version 2.0 (the "License"); you may
        try {  
import org.opensearch.common.xcontent.XContentHelper;
     * The mapping source definition.
    public String source() {
    public static XContentBuilder simpleMapping(String... source) {
    @Override  
            String type = in.readOptionalString();  
    public PutMappingRequest(String... indices) {
    public boolean includeDataStreams() {
        super(in);
    public PutMappingRequest source(String mappingSource, MediaType mediaType) {  
    }
                String fieldName = source[i++];
    public PutMappingRequest source(BytesReference mappingSource, MediaType mediaType) {
import java.io.UncheckedIOException;
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;  
        "_parent",
        try {  
        if (source != null) {  
            this.source = XContentHelper.convertToJson(mappingSource, false, false, mediaType);
    }
        } catch (IOException e) {
    }
    @Override  
        return origin;  
 * SPDX-License-Identifier: Apache-2.0
    public String origin() {
    public PutMappingRequest indices(String... indices) {  
            for (int i = 0; i < source.length; i++) {
 * that can't be merged are detected, the request will be rejected.
                        if (s2.length != 2) {
    /**
    private String[] indices;
 * @opensearch.api
    }
        out.writeString(source);
                    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public Index getConcreteIndex() {
    private static final Set<String> RESERVED_FIELDS = Set.of(
    public ActionRequestValidationException validate() {
            }
        }
     */
        "_field_names"
import java.io.InputStream;  
import org.opensearch.core.common.bytes.BytesArray;  
import org.opensearch.core.common.util.CollectionUtils;
        }
 */
        out.writeStringArrayNullable(indices);
        if (concreteIndex != null && CollectionUtils.isEmpty(indices) == false) {
     */
import org.opensearch.common.annotation.PublicApi;
package org.opensearch.action.admin.indices.mapping.put;
            }  
        "_type",
                if (RESERVED_FIELDS.contains(fieldName)) {  
    }  
     * Sets the indices this put mapping operation will execute on.  
     */
    }  
    }
        "_uid",
                    }  
     *             if the number of the source arguments is not divisible by two
    /**
    private IndicesOptions indicesOptions = IndicesOptions.fromOptions(false, false, true, true);
    public PutMappingRequest source(XContentBuilder mappingBuilder) {
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Arrays;
        indicesOptions.writeIndicesOptions(out);  
/*
        return this;  
                }
 *  
        return true;
import org.opensearch.core.common.io.stream.StreamOutput;  
        out.writeOptionalString(origin);  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
            for (int i = 0; i < source.length; i++) {  
     * Returns a concrete index for this mapping or <code>null</code> if no concrete index is defined  
     */
import static org.opensearch.action.ValidateActions.addValidationError;
    }  
                throw new IllegalArgumentException("Expected type [_doc] but received [" + type + "]");
                builder.rawValue(stream, MediaTypeRegistry.JSON);
    }  
    );  
import org.opensearch.transport.client.Requests;  
                    continue;  
    }  
import org.opensearch.action.IndicesRequest;
                            throw new IllegalArgumentException("malformed " + s);  
        return this;  
    }
     * it will be executed against all indices.  
    public boolean writeIndexOnly() {
            try (InputStream stream = new BytesArray(source).streamInput()) {
                }
            throw new IllegalArgumentException("mapping source must be pairs of fieldnames and properties definition.");
     */
                    String[] s1 = Strings.splitStringByCommaToArray(source[i]);
        this.origin = Objects.requireNonNull(origin);
     * Also supports metadata mapping fields such as `_all` and `_parent` as property definition, these metadata
    public PutMappingRequest() {}
 * license agreements. See the NOTICE file distributed with
 *
        if (source.length % 2 != 0) {  
        return source(BytesReference.bytes(mappingBuilder), mappingBuilder.contentType());
}  
                "either concrete index or unresolved indices can be set, concrete index: ["
                        throw new IllegalArgumentException("malformed " + s);
 */  
        }  
import org.opensearch.OpenSearchGenerationException;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        if (source == null) {  
        "_analyzer",
        return indices;
            throw new UncheckedIOException("failed to convert source to json", e);
 * @see IndicesAdminClient#putMapping(PutMappingRequest)
        if (out.getVersion().before(Version.V_2_0_0)) {
        "_all",  
    public void writeTo(StreamOutput out) throws IOException {  
        try {  
 * <p>  
    }  
 *
        this.indicesOptions = indicesOptions;
        "_timestamp",  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
                for (String s : s1) {
    public PutMappingRequest source(Map<String, ?> mappingSource) {
        return builder;
     * Sets a concrete index for this put mapping request.  
/**  
import java.util.Objects;
        writeIndexOnly = in.readBoolean();
                        builder.field(s2[0], s2[1]);
    }
     * mapping fields will automatically be put on the top level mapping object.
            if (MapperService.SINGLE_MAPPING_NAME.equals(type) == false) {
import java.io.IOException;
        Objects.requireNonNull(mediaType);
import org.opensearch.transport.client.IndicesAdminClient;
 * software distributed under the License is distributed on an
        }  
    }
 */  
 * If the mappings already exists, the new mappings will be merged with the new one. If there are elements
import org.opensearch.core.xcontent.MediaType;  
        return source(new BytesArray(mappingSource), mediaType);
 * specific language governing permissions and limitations
    private String origin = "";
        }  
            return builder;
    private Index concreteIndex;  
        Objects.requireNonNull(index, "index must not be null");  
import org.opensearch.index.mapper.MapperService;
                    builder.field(s2[0], s2[1]);
import org.opensearch.core.xcontent.MediaTypeRegistry;
@PublicApi(since = "1.0.0")
            );  
     * @param source
        source = in.readString();
        super.writeTo(out);
     * ("field1", "type=string,store=true").
    public PutMappingRequest(StreamInput in) throws IOException {
        out.writeBoolean(writeIndexOnly);
            out.writeOptionalString(MapperService.SINGLE_MAPPING_NAME);
    }
 * You may obtain a copy of the License at  
    }  
     * <p>  
    }
    /**
            }  
 * GitHub history for details.
    /**
        return this;
/*  
 *
 * under the License.  
        }
     *            "type=string,store=true")  
        return source(simpleMapping(source));
 * @see AcknowledgedResponse  
    @Override
        }
 * Puts mapping definition into one or more indices. Best created with
 * KIND, either express or implied.  See the License for the
            validationException = addValidationError(  
        } else if (source.isEmpty()) {
                    builder.endObject();
            XContentBuilder builder = XContentFactory.jsonBuilder();
        } catch (Exception e) {
        out.writeOptionalWriteable(concreteIndex);
    }  
        indices = in.readStringArray();  
     */
        }
        this.concreteIndex = index;
            }  
    @Override
    @Override
        this.indices = indices;  
     * The mapping source definition.  
                }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * The mapping source definition.  
    }
            throw new IllegalArgumentException("failed to generate simplified mapping definition", e);  
        indicesOptions = IndicesOptions.readIndicesOptions(in);
import org.opensearch.action.support.IndicesOptions;
                String fieldName = source[i++];
        "_size",
 * this file be licensed under the Apache-2.0 license or a
                    if (s2.length != 2) {
        } else {
        return concreteIndex;  
/*  
    }
    /**
     * The mapping source definition.
    public IndicesOptions indicesOptions() {  
                builder.startObject(fieldName);  
        "_source",
        }
     */  
                    + concreteIndex
    /**  
import org.opensearch.core.common.io.stream.StreamInput;
            builder.startObject();
import org.opensearch.Version;
        "_id",  
import java.util.Map;  
 * this work for additional information regarding copyright
import org.opensearch.core.index.Index;
    /**  
            validationException = addValidationError("mapping source is missing", validationException);
        this.writeIndexOnly = writeIndexOnly;  
     * The indices the mappings will be put.
import org.opensearch.core.xcontent.XContentBuilder;  
     */  
    /**
    public PutMappingRequest setConcreteIndex(Index index) {
            builder.endObject();
        // reserve "null" for bwc.
        return validationException;
     * A specialized simplified mapping source method, takes the form of simple properties definition:
                builder.endObject();  
        "_index",
                if (RESERVED_FIELDS.contains(fieldName)) {
        this.indices = indices;
     */
     */
                validationException
     * The mapping source definition.
    public PutMappingRequest origin(String origin) {  
     */
import org.opensearch.core.xcontent.ToXContentObject;
    /**  
        return this;
import org.opensearch.core.common.Strings;
 * Licensed to Elasticsearch under one or more contributor  
     *            consisting of field/properties pairs (e.g. "field1",
                    for (String s : s1) {  
    public PutMappingRequest source(String... source) {
import org.opensearch.core.common.bytes.BytesReference;
    /**
     * Constructs a new put mapping request against one or more indices. If nothing is set then
        } catch (IOException e) {  
        return indicesOptions;
                    String[] s2 = Strings.split(s, "=");  
        return this;
