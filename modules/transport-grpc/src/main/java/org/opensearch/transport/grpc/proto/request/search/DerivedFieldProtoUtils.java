 * @see org.opensearch.index.mapper.DerivedFieldMapper.Builder#build(org.opensearch.index.mapper.Mapper.BuilderContext)  
     * {@link org.opensearch.index.mapper.DerivedFieldMapper.Builder#build}, where optional
        return derivedField;
 * This class handles the conversion of Protocol Buffer representations to their  
     * @see org.opensearch.index.mapper.DerivedFieldMapper.Builder#build(org.opensearch.index.mapper.Mapper.BuilderContext)
            derivedField.setIgnoreMalformed(derivedFieldProto.getIgnoreMalformed());
            derivedFieldProto.getType(),
     */  
     * @return The corresponding OpenSearch DerivedField with optional fields set  
        if (derivedFieldProto.hasIgnoreMalformed()) {
 * compatible open source license.
        );
     * fields are only set if they were present in the request.</p>
 *
        // Always use simple constructor first (matches REST side pattern in DerivedFieldMapper.Builder.build())
        if (derivedFieldProto.hasPrefilterField()) {
package org.opensearch.transport.grpc.proto.request.search;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.transport.grpc.proto.request.common.ObjectMapProtoUtils;
     *  
        if (derivedFieldProto.hasProperties()) {
import org.opensearch.transport.grpc.proto.request.common.ScriptProtoUtils;
        }  
     * set optional fields based on presence (matches DerivedFieldMapper.Builder.build() pattern).  
    /**  
}
     * @param name The name of the derived field
            derivedField.setPrefilterField(derivedFieldProto.getPrefilterField());
        // Conditionally set optional fields based on presence (matches REST side's isConfigured() pattern)  
        DerivedField derivedField = new DerivedField(  
public class DerivedFieldProtoUtils {  
 */
 * this file be licensed under the Apache-2.0 license or a
            ScriptProtoUtils.parseFromProtoRequest(derivedFieldProto.getScript())  
        // Utility class, no instances  
/**
        }  
            derivedField.setProperties(ObjectMapProtoUtils.fromProto(derivedFieldProto.getProperties()));
     * <p>This matches the REST side's {@code Parameter.isConfigured()} pattern in  
     * Converts a Protocol Buffer DerivedField to its corresponding OpenSearch DerivedField.
 * @see org.opensearch.index.mapper.DefaultDerivedFieldResolver#initDerivedFieldTypes(java.util.Map, java.util.List)
 * corresponding OpenSearch derived field objects, matching the REST side pattern.
 * The OpenSearch Contributors require contributions made to  
 *
    }  
            derivedField.setFormat(derivedFieldProto.getFormat());
     * Uses the same pattern as REST side: always use simple constructor, then conditionally
    }
     *
import org.opensearch.index.mapper.DerivedField;  
            name,
/*  
        if (derivedFieldProto.hasFormat()) {
        }  
        }  
 * Utility class for converting DerivedField Protocol Buffers to OpenSearch DerivedField objects.
    private DerivedFieldProtoUtils() {
    public static DerivedField fromProto(String name, org.opensearch.protobufs.DerivedField derivedFieldProto) {
     * @see org.opensearch.index.mapper.ParametrizedFieldMapper.Parameter#isConfigured()
 */  
     *
     * @param derivedFieldProto The Protocol Buffer DerivedField to convert
