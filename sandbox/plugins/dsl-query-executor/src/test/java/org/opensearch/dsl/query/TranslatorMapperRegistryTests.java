        RelDataTypeField field = ctx.getRowType().getField("binary_data", false, false);
/**
    }
        RelDataTypeField field = ctx.getRowType().getField("event_nanos", false, false);  
        RelDataTypeField field = ctx.getRowType().getField("scaled_price", false, false);
        RelDataTypeField field = ctx.getRowType().getField("rating", false, false);  
    public void testResolveVarbinaryReturnsRejectingMapper() {  
    }  
    /**
    public void testResolveTimestampReturnsTimestampMapper() {  
 */
import org.opensearch.dsl.TestUtils;
            registry.resolve(field.getType()) instanceof RejectingTranslatorMapper
    }
     * Verifies ScaledFloatType resolves to ScaledFloatTranslatorMapper via tier 1.
     */  
        RelDataTypeField field = ctx.getRowType().getField("name", false, false);
    }
import org.opensearch.dsl.converter.ConversionContext;  
    /**
     */
    private final ConversionContext ctx = TestUtils.createContext();
        assertThat(registry.resolve(field.getType()), instanceOf(DefaultTranslatorMapper.class));
        // Verify all three share BIGINT SqlTypeName  
    public void testResolveScaledFloatReturnsScaledFloatMapper() {
     * Verifies IpType resolves to IpTranslatorMapper via tier 1.
     * No tier-1 entry is needed because DateOnlyType extends BasicSqlType and reports TIMESTAMP.  
        );
    }  
    public void testResolveDoubleReturnsDefault() {
            ConversionException.class,
        assertThat(registry.resolve(bigintField.getType()), instanceOf(DefaultTranslatorMapper.class));
        assertTrue("Message should mention range queries: " + ex.getMessage(), ex.getMessage().contains("range queries"));
import org.opensearch.test.OpenSearchTestCase;  
    /**
 * SPDX-License-Identifier: Apache-2.0
     */
        RelDataTypeField bigintField = ctx.getRowType().getField("timestamp", false, false);  
 * Tests that the translator mapper registry resolves to {@link DefaultTranslatorMapper} for
     */  
    /**
    public void testResolveIntegerReturnsDefault() {  
        RelDataTypeField unsignedField = ctx.getRowType().getField("unsigned_counter", false, false);
        // Verify translateBound throws ConversionException
     * Critical assertion: ScaledFloatType, UnsignedLongType and a plain BIGINT all report
        BaseTranslatorMapper mapper = registry.resolve(field.getType());
     * SqlTypeName.BIGINT, so this test proves dispatch is keyed on the Java class (tier 1)  
     * Verifies a DATE field resolves to TimestampTranslatorMapper via tier 2.  
 *
    public void testResolveDateReturnsTimestampMapper() {
 * standard Calcite types that have no dedicated mapper registered in this initial step.  
     * IpType reports SqlTypeName.VARBINARY, but tier 1 keying on exact class takes priority.  
        );
        RelDataTypeField field = ctx.getRowType().getField("unsigned_counter", false, false);
    /**
            () -> mapper.translateBound(new BoundRequest("abc", true, true, null, null, field, ctx))
        );
    private final TranslatorMapperRegistry registry = TranslatorMapperRegistry.INSTANCE;
     * via tier 2, and that its translateBound throws ConversionException.
     * Verifies DateOnlyType resolves to TimestampTranslatorMapper via tier 2.
        assertThat(registry.resolve(field.getType()), instanceOf(RejectingTranslatorMapper.class));
        assertFalse(
        RelDataTypeField field = ctx.getRowType().getField("ip_address", false, false);  
    public void testPlainBigintResolvesToDefaultNotUdtMapper() {
 * this file be licensed under the Apache-2.0 license or a
        RelDataTypeField scaledField = ctx.getRowType().getField("scaled_price", false, false);
        assertThat(registry.resolve(field.getType()), instanceOf(DefaultTranslatorMapper.class));  
        assertFalse(
        assertThat(registry.resolve(field.getType()), instanceOf(ScaledFloatTranslatorMapper.class));  
    }
    public void testResolveVarcharReturnsDefault() {
            "IpType must NOT fall through to RejectingTranslatorMapper",  
 * compatible open source license.
        assertTrue("Message should mention field name: " + ex.getMessage(), ex.getMessage().contains("binary_data"));
    }
        );  
    /**
    }
        assertEquals(bigintField.getType().getSqlTypeName(), scaledField.getType().getSqlTypeName());  
     * and not on SqlTypeName. A plain BIGINT field must still resolve to DefaultTranslatorMapper
        assertThat(registry.resolve(field.getType()), instanceOf(IpTranslatorMapper.class));
        // "timestamp" is plain BIGINT in the shared schema, not a UDT subclass
import org.apache.calcite.rel.type.RelDataTypeField;
        RelDataTypeField field = ctx.getRowType().getField("created_date", false, false);  
        assertThat(registry.resolve(field.getType()), instanceOf(TimestampTranslatorMapper.class));
        assertFalse(
     * Verifies UnsignedLongType resolves to UnsignedLongTranslatorMapper via tier 1.
            "UnsignedLongType must NOT fall through to DefaultTranslatorMapper",
    }
     */
    }  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.dsl.query.range.BoundRequest;
    public void testResolveIpTypeReturnsIpMapper() {
        RelDataTypeField field = ctx.getRowType().getField("price", false, false);
}
     */  
import static org.hamcrest.Matchers.instanceOf;
        ConversionException ex = expectThrows(  
        assertEquals(bigintField.getType().getSqlTypeName(), unsignedField.getType().getSqlTypeName());
 */  
        assertThat(registry.resolve(field.getType()), instanceOf(TimestampTranslatorMapper.class));
        RelDataTypeField field = ctx.getRowType().getField("timestamp", false, false);
        RelDataTypeField field = ctx.getRowType().getField("event_time", false, false);
    public void testResolveBigintReturnsDefault() {
     * because it has no tier-1 entry.
            registry.resolve(field.getType()) instanceof DefaultTranslatorMapper  
package org.opensearch.dsl.query;
    }
    public void testResolveUnsignedLongReturnsUnsignedLongMapper() {
    /**
    }  
        assertThat(registry.resolve(field.getType()), instanceOf(UnsignedLongTranslatorMapper.class));  
            registry.resolve(field.getType()) instanceof DefaultTranslatorMapper  
/*  
     */
            "ScaledFloatType must NOT fall through to DefaultTranslatorMapper",
import org.opensearch.dsl.converter.ConversionException;
        assertThat(registry.resolve(field.getType()), instanceOf(TimestampTranslatorMapper.class));
        assertThat(registry.resolve(field.getType()), instanceOf(DefaultTranslatorMapper.class));
        assertThat(registry.resolve(field.getType()), instanceOf(DefaultTranslatorMapper.class));  
    public void testResolveDateOnlyTypeReturnsTimestampMapperViaTier2() {
public class TranslatorMapperRegistryTests extends OpenSearchTestCase {
     * Verifies plain VARBINARY (non-IP binary field) resolves to RejectingTranslatorMapper  
