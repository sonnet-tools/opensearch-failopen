import java.time.ZoneId;
        LongSupplier nowSupplier
            // If the user gave us a type hint, respect that.  
        ValueType userValueTypeHint,
 *
            return null;
            return fieldType.docValueFormat(format, tz);  
            field,
        throw new UnsupportedOperationException();
    }  
        final ValuesSource vs;
            defaultValueSourceType,  
            format,
        ValueType userValueTypeHint,
        FieldContext fieldContext,  
import org.opensearch.index.mapper.MappedFieldType;  
 * ownership. Elasticsearch licenses this file to you under  
                unmapped = true;
 * license agreements. See the NOTICE file distributed with
            docValueFormat,
 *
     * @param missing - A user specified value to apply when the field is missing.  Should be of type userValueTypeHint
        IndexFieldData<?> indexFieldData = fieldContext.indexFieldData();
        valuesSource = ConstructValuesSource(missing, format, nowSupplier);
    }
 *
    public static ValuesSourceConfig resolveUnregistered(  
        }
    }
    }
     * value at read time).  If the settings allow for it, we then ask the {@link ValuesSourceType} to build the actual point reader  
 * this work for additional information regarding copyright
            }  
        ZoneId timeZone,  
            } else {  
     * Given the query context and other information, decide on the input {@link ValuesSource} for this aggretation run, and construct a new  
        FieldContext fieldContext,
        this.script = script;
        if (fieldType != null && script() == null && missing() == null) {
            return "Script yielding [" + (scriptValueType != null ? scriptValueType.getPreferredName() : "unknown type") + "]";
            // TODO: resolve no longer generates invalid configs. Once VSConfig is immutable, we can drop this check
     * the specified field does not exist on this index.
        FieldResolver fieldResolver
                    // We have a field, and the user didn't specify a type, so get the type from the field  
    private final AggregationScript.LeafFactory script;
        Object missing,
    ) {  
        }  
 * under the License.  
        }
        String field,
            context::nowInMillis  
     * {@link ValuesSourceConfig} based on that {@link ValuesSourceType}
    ) {
        ValuesSourceType defaultValueSourceType
        if (script == null) {  
import org.opensearch.script.Script;
    ) {  
     *               See https://github.com/elastic/elasticsearch/issues/47469
            aggregationScript,
import org.opensearch.script.AggregationScript;  
/*
 * A configuration that tells aggregations how to retrieve data from the index  
        return fieldContext.indexFieldData().getValuesSourceType();
            false,
        return "unmapped field";
        ZoneId timeZone,
        }
 * Licensed to Elasticsearch under one or more contributor  
    private static ValuesSourceConfig internalResolve(
     * @param context - the query context
     */
            AggregationScript.Factory factory = context.compile(script, AggregationScript.CONTEXT);  
            fieldContext.indexFieldData().getValuesSourceType(),
        );
            return vs;  
     * Special case factory method, intended to be used by aggregations which have some specialized logic for figuring out what field they
     * Convenience method for creating unmapped configs  
    }  
        if (fieldType != null && fieldType.unwrap() instanceof DerivedFieldType) {
            return fieldType.pointReaderIfPossible();  
     * @param userValueTypeHint - User specified value type; used for missing values and scripts
     * AKA legacy resolve.  This method should be called by aggregations not supported by the {@link ValuesSourceRegistry}, to use the  
        Object missing,
        Script script,  
    }
     *  
import org.opensearch.index.query.QueryShardContext;
    public ZoneId timezone() {
            timeZone,
    ) {  
     * based on the field type.  This allows for a point of extensibility in plugins.
    }  
        if (valuesSourceType == null) {
    }  
                aggregationScript = null;  // Value scripts are not allowed on unmapped fields. What would that do, anyway?
    }  
     *
            script,
                return defaultValuesSourceType;
     * are operating on, for example Parent and Child join aggregations, which use the join relation to find the field they are reading from
        ValueType scriptValueType,
        }
     * @return - An initialized {@link ValuesSourceConfig} that will yield the appropriate {@link ValuesSourceType}  
            unmapped,  
        Script script,  
        }
        if (unmapped && fieldContext != null) {
    }  
        this.valuesSourceType = valuesSourceType;
    }
/*
        }
     * pre-registry logic to decide on the {@link ValuesSourceType}.  New aggregations which extend from
        if (script != null) {  
    public AggregationScript.LeafFactory script() {
        return this.timeZone;  
            }  
    }
    private final ValuesSource valuesSource;
        MappedFieldType fieldType = fieldType();
 * software distributed under the License is distributed on an
            if (userValueTypeHint == null) {  
import java.util.function.LongSupplier;  
     */
    public DocValueFormat format() {  
        MappedFieldType fieldType = null;
            null,  
 * The OpenSearch Contributors require contributions made to  
        return this.missing;
        Script script,
    }  
            queryShardContext::nowInMillis
        MappedFieldType fieldType  
            scriptValueType,
public class ValuesSourceConfig {  
import org.opensearch.index.fielddata.IndexGeoPointFieldData;  
 */  
     * @param script - The script the user specified.  At least one of field and script must not be null
     * @param format - The format string to apply to this field.  Confusingly, this is used for input parsing as well as output formatting  
        return new ValuesSourceConfig(valuesSourceType, null, true, null, null, null, null, null, queryShardContext::nowInMillis);  
     *               See https://github.com/elastic/elasticsearch/issues/47469
        @Nullable ValuesSourceType valuesSourceType,
                return userValueTypeHint.getValuesSourceType();  
        return script;  
    private final ValueType scriptValueType;  
    ) {  
        }
     */
     * Returns a human readable description of this values source, for use in error messages and similar.  
        if (this.unmapped) {  
            );
        ZoneId timeZone,
    @FunctionalInterface
                /* Unmapped Field Case
    }  
 * not use this file except in compliance with the License.
        this.missing = missing;  
        this.fieldContext = fieldContext;
/**
        QueryShardContext context,  
                // Script case
    public boolean valid() {
            return valueSourceType().replaceMissing(vs, missing, format, nowSupplier);
            script,
        @Nullable String format,  
            if (script == null) {
            userValueTypeHint,  
    ) {
            return factory.newFactory(script.getParams(), context.lookup());
import org.opensearch.index.mapper.DerivedFieldType;
        ValuesSourceType defaultValuesSourceType
            fieldContext,
    private static AggregationScript.LeafFactory createScript(Script script, QueryShardContext context) {
     * This method is used when an aggregation can optimize by using the indexed data instead of the doc values.  We check to see if the
        ValueType userValueTypeHint,
        String format,  
            aggregationScript = ((DerivedFieldType) fieldType).getAggregationScript(context);  
        ValuesSourceType valuesSourceType,  
            null,
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
@PublicApi(since = "1.0.0")
    public ValuesSourceType valueSourceType() {
    /**
        ValuesSourceConfig config;
    ) {
     * @param timeZone - Used to generate a format for dates  
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
    }  
        DocValueFormat format,
        }  
    public static ValuesSourceConfig resolveUnmapped(ValuesSourceType valuesSourceType, QueryShardContext queryShardContext) {
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param defaultValueSourceType - per-aggregation {@link ValuesSource} of last resort.
     * @param script - The script the user specified.  At least one of field and script must not be null  
 * @opensearch.api  
        @Nullable ZoneId tz,
        } else if (fieldContext.fieldType() != null && fieldContext.fieldType().unwrap() instanceof RangeFieldMapper.RangeFieldType) {  
     * @param field - The field being aggregated over.  At least one of field and script must not be null
            // Field case
    private final ValuesSourceType valuesSourceType;  
        return internalResolve(
    private interface FieldResolver {  
    /**
 */
            } else {
    /**  
    private final DocValueFormat format;
     * @param field - The field being aggregated over.  At least one of field and script must not be null  
    /**  
        FieldContext fieldContext,
        );
                vs = valueSourceType().getField(fieldContext(), script());
    private ValuesSourceConfig() {
            return "Field [" + fieldType.name() + "] of type [" + fieldType.typeName() + "]";  
    }  
 * compatible open source license.
import org.opensearch.search.DocValueFormat;
        ValueType userValueTypeHint,
    private static ValuesSourceType getMappingFromRegistry(  
            null,  
     * @param context - the query context  
     */
        if (!valid()) {
     * {@link ValuesSourceAggregationBuilder} should not use this method, preferring {@link ValuesSourceConfig#resolve} instead.
    }  
    /**  
        return fieldContext;  
    }  
            defaultValueSourceType,  
        );
        if (fieldType != null) {
        // If we are aggregating on derived field set the agg script.
    private final FieldContext fieldContext;
    private static DocValueFormat resolveFormat(
 * in order to run a specific aggregation.
        }
    public Function<byte[], Number> getPointReaderOrNull() {  
     * @param format - The format string to apply to this field.  Confusingly, this is used for input parsing as well as output formatting
        this.format = format == null ? DocValueFormat.RAW : format;
                 * specified missing value.
            null,
    public ValueType scriptValueType() {  
 * You may obtain a copy of the License at  
        this.scriptValueType = scriptValueType;
    }
    }  
        Object missing,
    }
        ValueType userValueTypeHint,
                // Field or Value Script case
        return format;
 * Modifications Copyright OpenSearch Contributors. See  
    public String getDescription() {
     */
            ValuesSourceConfig::getMappingFromRegistry
        return fieldContext != null || script != null || missing != null;
            valuesSourceType = userValueTypeHint.getValuesSourceType();
            field,
    private static ValuesSourceType getLegacyMapping(
            return CoreValuesSourceType.NUMERIC;  
        return null;
     * Convenience method for looking up the mapped field type backing this values source, if it exists.
            }  
                 * pattern.  In this case, we're going to end up using the EMPTY variant of the ValuesSource, and possibly applying a user
     *
            }
            timeZone,
                vs = valueSourceType().getScript(script(), scriptValueType());
        return fieldContext != null || script != null || unmapped;  
        ValuesSourceType defaultValuesSourceType  
    }
        String format,
        return valuesSourceType.getFormatter(format, tz);  
                "value source config is invalid; must have either a field context or a script or marked as unmapped"
            fieldContext,  
            timeZone,
    public static ValuesSourceConfig resolve(
            ValuesSourceType defaultValuesSourceType
import org.opensearch.common.annotation.PublicApi;
            return CoreValuesSourceType.RANGE;
    private ValuesSource ConstructValuesSource(Object missing, DocValueFormat format, LongSupplier nowSupplier) {
 */
        } else {
            format,
}
    @Nullable  
     */
        return config;
        }
            if (fieldContext() == null || fieldType().unwrap() instanceof DerivedFieldType) {  
    private final ZoneId timeZone;
        this.unmapped = unmapped;  
            missing,  
     * @param missing - A user specified value to apply when the field is missing.  Should be of type userValueTypeHint
        AggregationScript.LeafFactory script,  
        if (userValueTypeHint != null) {
        ZoneId timeZone,  
        FieldContext fieldContext = new FieldContext(fieldType.name(), queryShardContext.getForField(fieldType), fieldType);  
            throw new IllegalStateException("value source config is invalid; marked as unmapped but specified a mapped field");
            context,
            missing,  
 * specific language governing permissions and limitations
     */
        );
            fieldType = context.fieldMapper(field);  
     * @param userValueTypeHint - User specified value type; used for missing values and scripts
    }
    /**
     * @return - An initialized {@link ValuesSourceConfig} that will yield the appropriate {@link ValuesSourceType}
    public ValuesSourceConfig(
            null,
 *  
        } else {
import java.util.function.Function;
 * this file be licensed under the Apache-2.0 license or a
 */
    private final Object missing;  
            valuesSourceType,
    }  
        return fieldContext == null ? null : fieldContext.fieldType();
     * @return null if we cannot apply the optimization, otherwise the point reader function.  
            context,
        String field,
import org.opensearch.index.fielddata.IndexNumericFieldData;
            valuesSourceType = defaultValueSourceType;  
        return internalResolve(
        return this.scriptValueType;
        boolean unmapped = false;
/*  
    public Object missing() {
            ValuesSourceConfig::getLegacyMapping
    private final boolean unmapped;
    public boolean hasGlobalOrdinals() {
        if (fieldType != null) {
        return new ValuesSourceConfig(
        String format,  
        }
     * @param timeZone - Used to generate a format for dates
        ValueType scriptValueType = userValueTypeHint;
        // Script or Unmapped case
            throw new IllegalStateException(  
        } else {
        DocValueFormat docValueFormat = resolveFormat(format, valuesSourceType, timeZone, fieldType);
        return valuesSourceType;
        ValuesSourceType valuesSourceType = null;  
        config = new ValuesSourceConfig(  
            missing,  
        } else {
        ValuesSourceType defaultValueSourceType
    }
            FieldContext fieldContext,
     * rather than a user specified field.  
        return valuesSource.hasGlobalOrdinals();  
import org.opensearch.index.fielddata.IndexFieldData;
     */  
 * the Apache License, Version 2.0 (the "License"); you may
        if (field == null) {  
        );
import org.opensearch.index.mapper.RangeFieldMapper;
            userValueTypeHint,  
            ValueType userValueTypeHint,  
                fieldContext = new FieldContext(fieldType.name(), context.getForField(fieldType), fieldType);
            } else {  
    public FieldContext fieldContext() {
                 */  
package org.opensearch.search.aggregations.support;
        if (missing() != null) {  
        } else if (indexFieldData instanceof IndexGeoPointFieldData) {
                if (valuesSourceType == null) {
    }  
        String field,  
        AggregationScript.LeafFactory aggregationScript = createScript(script, context); // returns null if script is null  
    /**
                }
    public static ValuesSourceConfig resolveFieldOnly(MappedFieldType fieldType, QueryShardContext queryShardContext) {
            vs = valueSourceType().getEmpty();
 * Unless required by applicable law or agreed to in writing,
        boolean unmapped,
        Object missing,
                 * We got here because the user specified a field, but it doesn't exist on this index, possibly because of a wildcard index  
        return valuesSource;
        } else {
     * indexed data will match the values source output (meaning there isn't a script or a missing value, since both could modify the
        QueryShardContext context,
                throw new IllegalStateException("value source config is invalid; must have either a field or a script");
import org.opensearch.common.Nullable;  
        MappedFieldType fieldType = fieldType();
            if (fieldType == null) {
            return CoreValuesSourceType.GEOPOINT;
        if (indexFieldData instanceof IndexNumericFieldData) {
    public MappedFieldType fieldType() {
    public ValuesSource getValuesSource() {
        ValuesSourceType getValuesSourceType(
    public boolean hasValues() {
 * SPDX-License-Identifier: Apache-2.0
    @Nullable
     * @param defaultValueSourceType - per-aggregation {@link ValuesSource} of last resort.  
        }
     * Returns true if the values source configured by this object can yield values.  We might not be able to yield values if, for example,
        FieldContext fieldContext = null;
        }
        this.timeZone = timeZone;
    }
                    valuesSourceType = fieldResolver.getValuesSourceType(fieldContext, userValueTypeHint, defaultValueSourceType);
        QueryShardContext context,  
        ValuesSourceType defaultValueSourceType,
