            false,  
    public void testDeclareFieldsWithScriptOnly() {
    // ========================================
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
    public void testDeclareFieldsWithFormat() {
            () -> ValuesSourceAggregationProtoUtils.declareFields(
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder().field("price").format("0.00").build();
    }
                true  // scriptable=false, fieldRequired=true
            )
        );
    public void testDeclareFieldsThrowsWhenNotScriptableButNoField() {
        assertNotNull(builder.script());  
            builder,
    public void testDeclareFieldsThrowsWhenNeitherFieldNorScript() {
                fields,
        Script scriptProto = Script.newBuilder().setInline(InlineScript.newBuilder().setSource("_value * 2").build()).build();
            fields,
            fields,  
            false,  
            false,
                true,  
            false,
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder().build();
    }
            false,
        assertEquals(org.opensearch.search.aggregations.support.ValueType.STRING, builder.userValueTypeHint());
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder()
            true,
 */
        );
    }
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder().build();
 * SPDX-License-Identifier: Apache-2.0
                true  // timezoneAware=true
 * compatible open source license.
            true  // scriptable=true
            true,
                builder,  
            true,  
            .field("price")  
    }
                builder,  
import org.opensearch.protobufs.GeneralNumber;
        // No exception = success  
/*  
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
            .script(ScriptProtoUtils.parseFromProtoRequest(scriptProto))
            IllegalArgumentException.class,
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder().field("price").build();  
 */  
                true,
    }  
            .script(ScriptProtoUtils.parseFromProtoRequest(scriptProto))
            builder,
        assertNotNull(builder.userValueTypeHint());
    public void testDeclareFieldsWithField() {
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder().field("price").build();
    // declareFields() tests
                false,
        ValuesSourceAggregationProtoUtils.declareFields(
        ValuesSourceAggregationProtoUtils.declareFields(builder, fields, true, true, false, true);
 * this file be licensed under the Apache-2.0 license or a
                true,  
            .build();
    }
    }  
                true  // scriptable=true, fieldRequired=true
    // ========================================  
            )  
        IllegalArgumentException ex = expectThrows(  
    }
        ValuesSourceAggregationProtoUtils.declareFields(builder, fields, true, true, false, true);
        );
import org.opensearch.transport.grpc.proto.response.common.FieldValueProtoUtils;
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
            .build();
    }
        );
                true,  
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
            true  // scriptable=true, fieldRequired=true
            .build();
            true,
            .build();
        assertTrue(ex.getMessage().contains("Required"));
 * Tests verify that gRPC proto conversion matches REST API behavior from ValuesSourceAggregationBuilder.  
public class ValuesSourceAggregationProtoUtilsTests extends OpenSearchTestCase {
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
            () -> ValuesSourceAggregationProtoUtils.declareFields(
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
        IllegalArgumentException ex = expectThrows(  
        FieldValue missingValue = FieldValue.newBuilder().setGeneralNumber(GeneralNumber.newBuilder().setDoubleValue(10.5).build()).build();  
    public void testDeclareFieldsSucceedsWhenFieldNotRequired() {
import org.opensearch.protobufs.Script;  
        ValuesSourceAggregationProtoUtils.declareFields(builder, fields, true, true, false, true);
            true,
                true,
            IllegalArgumentException.class,
import org.opensearch.protobufs.ValueType;
import org.opensearch.transport.grpc.proto.request.common.ScriptProtoUtils;
            fields,
    }
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder().build();
        assertTrue(ex.getMessage().contains("field") || ex.getMessage().contains("script"));  
        ValuesSourceAggregationProtoUtils.declareFields(  
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder()  
            UnsupportedOperationException.class,  
                fields,  
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
            )  
            true  // formattable=true
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder().field("price").valueType(ValueType.VALUE_TYPE_STRING).build();  
        assertEquals(10.5, builder.missing());  
                false,
 * The OpenSearch Contributors require contributions made to  
        MinAggregationBuilder builder = new MinAggregationBuilder("test");  
    public void testDeclareFieldsThrowsForTimezoneAware() {  
/**
            true,
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder()
import org.opensearch.protobufs.InlineScript;
            builder,
        assertNotNull(builder.script());
            true  // formattable=false  
            false  // scriptable=false, fieldRequired=false  
            true,
    }
                false,
            .field("price")  
        assertNotNull(builder.script());
            .script(ScriptProtoUtils.parseFromProtoRequest(scriptProto))
        assertEquals("price", builder.field());  
        ValuesSourceAggregationProtoUtils.declareFields(builder, fields, true, true, false, true);
        assertTrue(ex.getMessage().contains("Timezone"));
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
    public void testDeclareFieldsWithScript() {  
        assertEquals("0.00", builder.format());
 * Unit tests for ValuesSourceAggregationProtoUtils.
}
        assertTrue(ex.getMessage().contains("Required"));
        ValuesSourceAggregationProtoUtils.declareFields(
            .field("price")  
        assertNull(builder.format());  
        ValuesSourceAggregationProtoUtils.declareFields(  
        );
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder()
        Script scriptProto = Script.newBuilder().setInline(InlineScript.newBuilder().setSource("_value * 2").build()).build();  
    public void testDeclareFieldsWithBothFieldAndScript() {  
        UnsupportedOperationException ex = expectThrows(
            true,
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
            fields,  
    public void testDeclareFieldsWithMissing() {  
            fields,  
                true,
            () -> ValuesSourceAggregationProtoUtils.declareFields(
            builder,
        );
    public void testDeclareFieldsWithValueType() {  
            builder,
        );
                fields,
    public void testDeclareFieldsIgnoresFormatWhenNotFormattable() {
            false,  
import org.opensearch.test.OpenSearchTestCase;  
        );  
            false,  
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder().field("price").format("0.00").build();
package org.opensearch.transport.grpc.proto.request.search.aggregation.support;
 *
            .missing(FieldValueProtoUtils.fromProto(missingValue))
        Script scriptProto = Script.newBuilder().setInline(InlineScript.newBuilder().setSource("_value * 2").build()).build();  
                builder,
    }
import org.opensearch.protobufs.FieldValue;  
        assertTrue(ex.getMessage().contains("field"));  
        MinAggregationBuilder builder = new MinAggregationBuilder("test");  
        ValuesSourceAggregationProtoUtils.declareFields(
