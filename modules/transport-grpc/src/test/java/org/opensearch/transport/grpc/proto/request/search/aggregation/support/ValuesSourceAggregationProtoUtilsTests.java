        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder()
            false,
                fields,
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
            .missing(FieldValueProtoUtils.fromProto(missingValue))
        assertNotNull(builder.script());
        assertNotNull(builder.script());
public class ValuesSourceAggregationProtoUtilsTests extends OpenSearchTestCase {
        );
            true,
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder().build();
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder().build();
            .build();
    }
            .field("price")
            UnsupportedOperationException.class,
            true  // scriptable=true, fieldRequired=true
/*
        FieldValue missingValue = FieldValue.newBuilder().setGeneralNumber(GeneralNumber.newBuilder().setDoubleValue(10.5).build()).build();
        ValuesSourceAggregationProtoUtils.declareFields(builder, fields, true, true, false, true);
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
 * Tests verify that gRPC proto conversion matches REST API behavior from ValuesSourceAggregationBuilder.
    }
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder().field("price").build();
 * Unit tests for ValuesSourceAggregationProtoUtils.
        ValuesSourceAggregationProtoUtils.declareFields(
            .script(ScriptProtoUtils.parseFromProtoRequest(scriptProto))
        ValuesSourceAggregationProtoUtils.declareFields(builder, fields, true, true, false, true);
package org.opensearch.transport.grpc.proto.request.search.aggregation.support;
            .script(ScriptProtoUtils.parseFromProtoRequest(scriptProto))
        assertTrue(ex.getMessage().contains("field"));
    }
import org.opensearch.protobufs.Script;
import org.opensearch.protobufs.GeneralNumber;
        );
        IllegalArgumentException ex = expectThrows(
                fields,
        ValuesSourceAggregationProtoUtils.declareFields(
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder().field("price").build();
            true,
        assertEquals(org.opensearch.search.aggregations.support.ValueType.STRING, builder.userValueTypeHint());
    // declareFields() tests
            false,
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
            () -> ValuesSourceAggregationProtoUtils.declareFields(
    }
        UnsupportedOperationException ex = expectThrows(
        assertTrue(ex.getMessage().contains("field") || ex.getMessage().contains("script"));
            fields,
            true  // scriptable=true
import org.opensearch.transport.grpc.proto.response.common.FieldValueProtoUtils;
        assertNotNull(builder.script());
            fields,
    public void testDeclareFieldsThrowsWhenNotScriptableButNoField() {
 */
                false,
    public void testDeclareFieldsWithField() {
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
                true,
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
        Script scriptProto = Script.newBuilder().setInline(InlineScript.newBuilder().setSource("_value * 2").build()).build();
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder().build();
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder()
        );
    public void testDeclareFieldsIgnoresFormatWhenNotFormattable() {
        );
                builder,
                true,
    public void testDeclareFieldsWithScriptOnly() {
            )
            builder,
 * The OpenSearch Contributors require contributions made to
        assertEquals(10.5, builder.missing());
            false,
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
            .build();
 * compatible open source license.
        );
            true,
    public void testDeclareFieldsWithBothFieldAndScript() {
    }
    public void testDeclareFieldsThrowsForTimezoneAware() {
            false,
        IllegalArgumentException ex = expectThrows(
        Script scriptProto = Script.newBuilder().setInline(InlineScript.newBuilder().setSource("_value * 2").build()).build();
    }
                true  // timezoneAware=true
 */
    }
            IllegalArgumentException.class,
            false  // scriptable=false, fieldRequired=false
    public void testDeclareFieldsWithFormat() {
            true,
    }
                true,
        ValuesSourceAggregationProtoUtils.declareFields(builder, fields, true, true, false, true);
            builder,
                true  // scriptable=true, fieldRequired=true
import org.opensearch.protobufs.InlineScript;
import org.opensearch.protobufs.FieldValue;
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
        assertNull(builder.format());
        assertTrue(ex.getMessage().contains("Timezone"));
    }
import org.opensearch.transport.grpc.proto.request.common.ScriptProtoUtils;
 *
                true,
                false,
            )
                true,
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder()
    // ========================================
/**
            false,
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder()
                builder,
            .script(ScriptProtoUtils.parseFromProtoRequest(scriptProto))
            .build();
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
        assertEquals("price", builder.field());
            .build();
        ValuesSourceAggregationProtoUtils.declareFields(builder, fields, true, true, false, true);
    }
        );
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
            true,
    public void testDeclareFieldsSucceedsWhenFieldNotRequired() {
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
        assertEquals("0.00", builder.format());
            true  // formattable=false
        assertNotNull(builder.userValueTypeHint());
        );
        ValuesSourceAggregationProtoUtils.declareFields(
            false,
            .field("price")
            fields,
        ValuesSourceAggregationProtoUtils.declareFields(
        assertTrue(ex.getMessage().contains("Required"));
                fields,
                true  // scriptable=false, fieldRequired=true
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
            builder,
 * this file be licensed under the Apache-2.0 license or a
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder().field("price").format("0.00").build();
        // No exception = success
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder().field("price").format("0.00").build();
            true  // formattable=true
import org.opensearch.protobufs.ValueType;
    public void testDeclareFieldsWithMissing() {
    }
            .field("price")
        assertTrue(ex.getMessage().contains("Required"));
        );
    // ========================================
        Script scriptProto = Script.newBuilder().setInline(InlineScript.newBuilder().setSource("_value * 2").build()).build();
}
            builder,
            () -> ValuesSourceAggregationProtoUtils.declareFields(
import org.opensearch.test.OpenSearchTestCase;
            true,
 * SPDX-License-Identifier: Apache-2.0
            () -> ValuesSourceAggregationProtoUtils.declareFields(
                false,
            false,
    }
            IllegalArgumentException.class,
            true,
        ValuesSourceProtoFields fields = ValuesSourceProtoFields.builder().field("price").valueType(ValueType.VALUE_TYPE_STRING).build();
            fields,
                true,
        MinAggregationBuilder builder = new MinAggregationBuilder("test");
            )
    public void testDeclareFieldsWithValueType() {
            true,
    public void testDeclareFieldsThrowsWhenNeitherFieldNorScript() {
            fields,
            builder,
    public void testDeclareFieldsWithScript() {
                builder,
        ValuesSourceAggregationProtoUtils.declareFields(
