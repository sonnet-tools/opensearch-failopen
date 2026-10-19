 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Map<String, Object> mapping = XContentHelper.convertToMap(source.compressedReference(), true).v2();
            withoutType = (Map<String, Object>) mapping.get(type);
        if (this == o) return true;
import java.io.IOException;
            throw new UncheckedIOException(e);  // XContent exception, should never happen
import java.util.Collections;
    @Override
        out.writeBoolean(routingRequired);
import org.opensearch.core.common.bytes.BytesReference;
        return Objects.hash(type, source, routingRequired);
 * Modifications Copyright OpenSearch Contributors. See
                    }
 * Licensed to Elasticsearch under one or more contributor
                    try {
    public Map<String, Object> sourceAsMap() throws OpenSearchParseException {
    }
 * Mapping configuration for a type.
import org.opensearch.cluster.AbstractDiffable;
        this.type = type;
 */
    public boolean equals(Object o) {
import org.opensearch.common.xcontent.XContentFactory;
 *
    public MappingMetadata(DocumentMapper docMapper) {
     */
     * Converts the serialized compressed form of the mappings into a parsed map.
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to
    public boolean routingRequired() {
package org.opensearch.cluster.metadata;
    public MappingMetadata(StreamInput in) throws IOException {
    public int hashCode() {
import java.io.UncheckedIOException;
    @SuppressWarnings("unchecked")
/*
        if (mapping.size() == 1 && mapping.containsKey(type)) {
import org.opensearch.core.xcontent.XContentBuilder;
        this.routingRequired = isRoutingRequired(withoutType);
        try {
     */
    }
            for (Map.Entry<String, Object> entry : routingNode.entrySet()) {
    }
    @Override
    }
            }
        }
            XContentBuilder mappingBuilder = XContentFactory.jsonBuilder().map(mapping);
        // routing
        this.type = mappingMap.keySet().iterator().next();
                            "Failed to create mapping for type [" + this.type() + "]. " + "Illegal value in field [_routing.required].",
                }
    @SuppressWarnings("unchecked")
            mapping = (Map<String, Object>) mapping.get(type());
import org.opensearch.common.xcontent.XContentHelper;
 * not use this file except in compliance with the License.
    }
        this.source = mapping;
 * Unless required by applicable law or agreed to in writing,
            this.source = new CompressedXContent(BytesReference.bytes(mappingBuilder));
                if (fieldName.equals("required")) {
 * specific language governing permissions and limitations
    public MappingMetadata(CompressedXContent mapping) {
 * compatible open source license.
        return required;
        this.source = docMapper.mappingSource();
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {
            // the type name is the root value, reduce it
 * GitHub history for details.
import org.opensearch.OpenSearchParseException;
    private boolean isRoutingRequired(Map<String, Object> withoutType) {
        source().writeTo(out);
    }
    /**
    private final boolean routingRequired;
        boolean required = false;
        out.writeBoolean(routingRequired);
import org.opensearch.index.mapper.DocumentMapper;
        return sourceAsMap();
    }
import org.opensearch.core.common.io.stream.StreamOutput;
 * You may obtain a copy of the License at
import org.opensearch.common.annotation.PublicApi;
        if (mappingMap.size() != 1) {
        return true;
                Object fieldNode = entry.getValue();
        source().writeVerifiableTo(out);
    public CompressedXContent source() {
        out.writeString(type());
        Map<String, Object> withoutType = mapping;
import org.opensearch.index.mapper.MapperService;
                    } catch (IllegalArgumentException ex) {
 */
    }
        }
                        throw new IllegalArgumentException(
import org.opensearch.cluster.Diff;
        if (!Objects.equals(this.routingRequired, that.routingRequired)) return false;
        source = CompressedXContent.readCompressedString(in);
 * @opensearch.api
        MappingMetadata that = (MappingMetadata) o;
 * software distributed under the License is distributed on an
        // routing
/**
    public String type() {
        }
    private final CompressedXContent source;
        return this.routingRequired;
                        required = nodeBooleanValue(fieldNode);
                        );
    @Override
        this.routingRequired = docMapper.routingFieldMapper().required();
    public static final MappingMetadata EMPTY_MAPPINGS = new MappingMetadata(MapperService.SINGLE_MAPPING_NAME, Collections.emptyMap());
        return this.source;
        if (!type.equals(that.type)) return false;
 *     http://www.apache.org/licenses/LICENSE-2.0
        Map<String, Object> mappingMap = XContentHelper.convertToMap(mapping.compressedReference(), true).v2();
    @SuppressWarnings("unchecked")
 */
/*
    @Override
        if (mapping.size() == 1 && mapping.containsKey(type())) {
        }
        if (withoutType.containsKey("_routing")) {
        return readDiffFrom(MappingMetadata::new, in);
        out.writeString(type());
                            ex
 * this file be licensed under the Apache-2.0 license or a
        return mapping;
 * SPDX-License-Identifier: Apache-2.0
    private final String type;
    public Map<String, Object> getSourceAsMap() throws OpenSearchParseException {
 * this work for additional information regarding copyright
 *
    }
        if (o == null || getClass() != o.getClass()) return false;
    /**
        }
            throw new IllegalStateException("Can't derive type from mapping, no root type: " + mapping.string());
/*
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeBooleanValue;
import org.opensearch.core.common.io.stream.VerifiableWriteable;
        type = in.readString();
    }
     * Converts the serialized compressed form of the mappings into a parsed map.
import java.util.Objects;
    }
 *
public class MappingMetadata extends AbstractDiffable<MappingMetadata> implements VerifiableWriteable {
 * license agreements. See the NOTICE file distributed with
    }
        if (!source.equals(that.source)) return false;
    public MappingMetadata(String type, Map<String, Object> mapping) {
        } catch (IOException e) {
            Map<String, Object> routingNode = (Map<String, Object>) withoutType.get("_routing");
        this.routingRequired = isRoutingRequired((Map<String, Object>) mappingMap.get(this.type));
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
    public void writeTo(StreamOutput out) throws IOException {
    }
    }
    public static Diff<MappingMetadata> readDiffFrom(StreamInput in) throws IOException {
        routingRequired = in.readBoolean();
                String fieldName = entry.getKey();
        return this.type;
import org.opensearch.core.common.io.stream.StreamInput;
    }
 */
 * under the License.
 *
 * the Apache License, Version 2.0 (the "License"); you may
@PublicApi(since = "1.0.0")
}
        this.type = docMapper.type();
import org.opensearch.common.compress.CompressedXContent;
import java.util.Map;
 * ownership. Elasticsearch licenses this file to you under
