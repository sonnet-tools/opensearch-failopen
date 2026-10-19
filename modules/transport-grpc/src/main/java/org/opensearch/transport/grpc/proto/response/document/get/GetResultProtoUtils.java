        }
/**  
 * SPDX-License-Identifier: Apache-2.0
    }
    }
 * this file be licensed under the Apache-2.0 license or a
        if (getResult.getSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO) {
            }
}  
                } else {
            }  
import org.opensearch.index.mapper.IgnoredFieldMapper;
        }
        responseItemBuilder.setGet(inlineGetDictUserDefinedBuilder.build());  
        if (getResult.source() != null) {
        // Set document ID
import org.opensearch.transport.grpc.proto.response.document.common.DocumentFieldProtoUtils;
        // Utility class, no instances
        }
            builder.setXPrimaryTerm(getResult.getPrimaryTerm());  
        // Reuse the builder passed in by reference
                if (field.getName().equals(IgnoredFieldMapper.NAME)) {  
 * This class handles the conversion of document get operation results to their
            if (getResult.getVersion() != -1) {
        if (!getResult.getDocumentFields().isEmpty()) {
                    metadataFieldsBuilder.putFields(field.getName(), DocumentFieldProtoUtils.toProto(field.<Object>getValue()));  
    /**
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.protobufs.ResponseItem;  
     * @param builder The builder to add the GetResult data to  
        // Process metadata fields
        responseItemBuilder.setXIndex(getResult.getIndex());  
package org.opensearch.transport.grpc.proto.response.document.get;
     */  
import org.opensearch.protobufs.ObjectMap;
 *
            // Set document version if available  
 */  
     * @param responseItemBuilder The builder to populate with GetResult data
                documentFieldsBuilder.putFields(field.getName(), DocumentFieldProtoUtils.toProto(field.getValues()));
        // Set sequence number and primary term if available  
import org.opensearch.core.xcontent.ToXContent;
     * This method is equivalent to the {@link GetResult#toXContentEmbedded(XContentBuilder, ToXContent.Params)}  
        responseItemBuilder.setXId(getResult.getId());  
import org.opensearch.protobufs.InlineGetDictUserDefined;
        } else {
            ObjectMap.Builder metadataFieldsBuilder = ObjectMap.newBuilder();
import com.google.protobuf.ByteString;  
            }
    /**
 * Utility class for converting GetResult objects to Protocol Buffers.
    public static ResponseItem.Builder toProto(GetResult getResult, ResponseItem.Builder responseItemBuilder) {
        }  
     * @param getResult The GetResult to convert
        if (getResult.isExists()) {
        return responseItemBuilder;
     * This method is equivalent to the  {@link GetResult#toXContent(XContentBuilder, ToXContent.Params)}
     * @param getResult           The GetResult to convert  
            for (DocumentField field : getResult.getDocumentFields().values()) {  
     * Converts a GetResult to its Protocol Buffer representation for embedding in another message.
            ObjectMap.Builder documentFieldsBuilder = ObjectMap.newBuilder();
import org.opensearch.index.seqno.SequenceNumbers;  
            toProtoEmbedded(getResult, inlineGetDictUserDefinedBuilder);
/*  
        // Create the inline get dict builder only once
        }
                    metadataFieldsBuilder.putFields(field.getName(), DocumentFieldProtoUtils.toProto(field.getValues()));
import org.opensearch.common.document.DocumentField;
            for (DocumentField field : getResult.getMetadataFields().values()) {
        // Process document fields - only create builder if needed  
     *
        if (!getResult.getMetadataFields().isEmpty()) {  
            builder.setXSeqNo(getResult.getSeqNo());
                responseItemBuilder.setXVersion(getResult.getVersion());
public class GetResultProtoUtils {
import org.opensearch.index.get.GetResult;
 */
                }
 * compatible open source license.
        builder.setFound(getResult.isExists());
            builder.setXSource(ByteString.copyFrom(getResult.source()));
 * Protocol Buffer representation.  
     * Converts a GetResult to its Protocol Buffer representation.  
     *
            inlineGetDictUserDefinedBuilder.setFound(false);  
     * @return The populated builder
     */
        InlineGetDictUserDefined.Builder inlineGetDictUserDefinedBuilder = InlineGetDictUserDefined.newBuilder();  
 * The OpenSearch Contributors require contributions made to  
        // Set existence status  
    public static void toProtoEmbedded(GetResult getResult, InlineGetDictUserDefined.Builder builder) {
            builder.setMetadataFields(metadataFieldsBuilder.build());  
        // Set source if available - avoid unnecessary copying if possible  
    private GetResultProtoUtils() {
            builder.setFields(documentFieldsBuilder.build());  
    }  
