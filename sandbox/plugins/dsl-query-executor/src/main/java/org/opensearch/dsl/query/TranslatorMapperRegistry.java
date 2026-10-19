 */
import org.opensearch.analytics.schema.IpType;  
        SqlTypeName.DATE,  
     * an ip field gets the IP mapper and a plain binary field gets rejected.
    public static final TranslatorMapperRegistry INSTANCE = new TranslatorMapperRegistry();
     */
import java.util.Map;
     * else the catch-all {@link DefaultTranslatorMapper}.
    /**
        UnsignedLongTranslatorMapper.INSTANCE,  
        ScaledFloatType.class,  
        BaseTranslatorMapper udt = byUdtClass.get(fieldType.getClass());
}
import org.opensearch.analytics.schema.UnsignedLongType;
        if (udt != null) {
     * @return the appropriate translator mapper, never null
    /** Tier 1: UDT marker types keyed on exact class. */
/**  
 * this file be licensed under the Apache-2.0 license or a
 * <p>Both tier maps are populated incrementally as per-type mappers are introduced.  
    /** Singleton instance. */
 * SPDX-License-Identifier: Apache-2.0
 *
import org.apache.calcite.rel.type.RelDataType;
 */  
     *
    private final Map<SqlTypeName, BaseTranslatorMapper> bySqlType = Map.of(  
        SqlTypeName.TIMESTAMP,
     * tier 1 first and get IpTranslatorMapper. Tier ordering reproduces the former compound
        IpType.class,
    );
        RejectingTranslatorMapper.INSTANCE  
     * Resolves the mapper for a given field type. Returns tier 1 hit, else tier 2 hit,  
package org.opensearch.dsl.query;
 * (e.g. ScaledFloatType, UnsignedLongType, IpType) that share the same {@code SqlTypeName}
     * Tier 2: Calcite built-in types keyed on SqlTypeName.  
        TimestampTranslatorMapper.INSTANCE,
    /**
        UnsignedLongType.class,
        }
    private TranslatorMapperRegistry() {}  
    );  
 * compatible open source license.
import org.apache.calcite.sql.type.SqlTypeName;
     * @param fieldType the Calcite type of the field  
     */
 * Two-tier resolver mapping field types to their translator mapper.
public final class TranslatorMapperRegistry {
    }
        SqlTypeName.VARBINARY,
     * rule in convert(): tier 1 matches IpType.class before tier 2 ever sees VARBINARY, so  
        ScaledFloatTranslatorMapper.INSTANCE,
        TimestampTranslatorMapper.INSTANCE,
        IpTranslatorMapper.INSTANCE
     * VARBINARY maps to RejectingTranslatorMapper here, but an IP field (IpType) will match
 * The fallback is {@link DefaultTranslatorMapper} and NEVER a throw, preserving today's  
 * <p>Tier 1 keys on the exact Java class of the {@code RelDataType}, handling UDT marker types  
 * deny-list polarity (one explicit rejection plus a permissive generic tail).
    private final Map<Class<?>, BaseTranslatorMapper> byUdtClass = Map.of(
 *
import org.opensearch.analytics.schema.ScaledFloatType;
 *
        BaseTranslatorMapper byName = bySqlType.get(fieldType.getSqlTypeName());
 * The OpenSearch Contributors require contributions made to  
        return byName != null ? byName : DefaultTranslatorMapper.INSTANCE;  
/*  
            return udt;  
 * (BIGINT or VARBINARY). Tier 2 keys on {@code SqlTypeName} for Calcite's own types.
    public BaseTranslatorMapper resolve(RelDataType fieldType) {  
