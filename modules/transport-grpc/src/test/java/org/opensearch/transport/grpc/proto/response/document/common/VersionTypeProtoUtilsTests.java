/*  
    public void testFromProtoWithVersionTypeExternal() {  
        );
package org.opensearch.transport.grpc.proto.response.document.common;
        );
            VersionType.INTERNAL,  
        assertEquals("Default case should convert to VersionType.INTERNAL", VersionType.INTERNAL, result);  
        assertEquals(
    }
        assertEquals("UNRECOGNIZED should default to VersionType.INTERNAL", VersionType.INTERNAL, result);  
}
        );
    }
            VersionType.INTERNAL,  
            VersionType.EXTERNAL_GTE,  
            VersionType.INTERNAL,  
            "VERSION_TYPE_UNSPECIFIED should default to VersionType.INTERNAL",
        assertEquals(
        VersionType result = VersionTypeProtoUtils.fromProto(org.opensearch.protobufs.VersionType.VERSION_TYPE_EXTERNAL);
        assertEquals(
            VersionTypeProtoUtils.fromProto(org.opensearch.protobufs.VersionType.VERSION_TYPE_UNSPECIFIED)
        VersionType result = VersionTypeProtoUtils.fromProto(org.opensearch.protobufs.VersionType.VERSION_TYPE_EXTERNAL_GTE);
        assertEquals("VERSION_TYPE_UNSPECIFIED should default to VersionType.INTERNAL", VersionType.INTERNAL, result);  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
            VersionTypeProtoUtils.fromProto(org.opensearch.protobufs.VersionType.VERSION_TYPE_EXTERNAL)
            VersionTypeProtoUtils.fromProto(org.opensearch.protobufs.VersionType.VERSION_TYPE_INTERNAL)
        assertEquals(
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.VersionType;
    }
 * compatible open source license.
        VersionType result = VersionTypeProtoUtils.fromProto(org.opensearch.protobufs.VersionType.VERSION_TYPE_UNSPECIFIED);
        assertEquals("Should map to EXTERNAL_GTE", VersionType.EXTERNAL_GTE, result);  
            VersionTypeProtoUtils.fromProto(org.opensearch.protobufs.VersionType.VERSION_TYPE_EXTERNAL_GTE)
    public void testFromProtoWithVersionTypeExternalGte() {  
 * The OpenSearch Contributors require contributions made to  
        VersionType result = VersionTypeProtoUtils.fromProto(org.opensearch.protobufs.VersionType.UNRECOGNIZED);
            "VERSION_TYPE_INTERNAL should convert to VersionType.INTERNAL",
        );
 *
    public void testFromProtoWithAllVersionTypes() {  
            VersionType.EXTERNAL,  
        VersionType result = VersionTypeProtoUtils.fromProto(org.opensearch.protobufs.VersionType.VERSION_TYPE_INTERNAL);
    }
    }  
    public void testFromProtoWithUnrecognizedVersionType() {  
        );
            VersionTypeProtoUtils.fromProto(org.opensearch.protobufs.VersionType.UNRECOGNIZED)
public class VersionTypeProtoUtilsTests extends OpenSearchTestCase {
        assertEquals(
    public void testFromProtoWithVersionTypeUnspecified() {  
    public void testFromProtoWithDefaultCase() {  
            "UNRECOGNIZED should default to VersionType.INTERNAL",
 */  
            "VERSION_TYPE_EXTERNAL should convert to VersionType.EXTERNAL",
        assertEquals("Should map to EXTERNAL", VersionType.EXTERNAL, result);  
    }
            "VERSION_TYPE_EXTERNAL_GTE should convert to VersionType.EXTERNAL_GTE",
