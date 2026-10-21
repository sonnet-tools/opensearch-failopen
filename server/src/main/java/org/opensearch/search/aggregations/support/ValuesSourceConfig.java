import org.opensearch.index.fielddata.IndexGeoPointFieldData;
        MappedFieldType fieldType = null;
     */
            return vs;
import org.opensearch.common.Nullable;
            AggregationScript.Factory factory = context.compile(script, AggregationScript.CONTEXT);
        ValueType userValueTypeHint,
        LongSupplier nowSupplier
            return fieldType.docValueFormat(format, tz);
    /**
        Object missing,
        valuesSource = ConstructValuesSource(missing, format, nowSupplier);
                 */
        return valuesSource;
        String format,
    }
 * in order to run a specific aggregation.
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor
    public DocValueFormat format() {
    }
                // Script case
        }
        ValuesSourceType valuesSourceType,
    }
     * @param userValueTypeHint - User specified value type; used for missing values and scripts
     */
    }
    /**
            // TODO: resolve no longer generates invalid configs. Once VSConfig is immutable, we can drop this check
        ValueType userValueTypeHint,
            scriptValueType,
     * rather than a user specified field.
     * Returns true if the values source configured by this object can yield values.  We might not be able to yield values if, for example,
            }
     *
    public ValuesSourceType valueSourceType() {
            field,
            }
        } else {
                throw new IllegalStateException("value source config is invalid; must have either a field or a script");
            if (fieldContext() == null || fieldType().unwrap() instanceof DerivedFieldType) {
            script,
    ) {
        this.timeZone = timeZone;
        }
        this.script = script;
     * @param field - The field being aggregated over.  At least one of field and script must not be null
 * The OpenSearch Contributors require contributions made to
        @Nullable ZoneId tz,
        FieldContext fieldContext,
        Object missing,
     */
        FieldContext fieldContext = null;
     * {@link ValuesSourceConfig} based on that {@link ValuesSourceType}
    public ValuesSource getValuesSource() {
 * software distributed under the License is distributed on an
        ValuesSourceType defaultValueSourceType
     * @param timeZone - Used to generate a format for dates
        String field,
        return new ValuesSourceConfig(valuesSourceType, null, true, null, null, null, null, null, queryShardContext::nowInMillis);
    public static ValuesSourceConfig resolve(
    private final FieldContext fieldContext;
     * based on the field type.  This allows for a point of extensibility in plugins.
        } else if (fieldContext.fieldType() != null && fieldContext.fieldType().unwrap() instanceof RangeFieldMapper.RangeFieldType) {
        final ValuesSource vs;
    }
    private ValuesSourceConfig() {
                /* Unmapped Field Case
 * this file be licensed under the Apache-2.0 license or a
        ValuesSourceType defaultValueSourceType,
        return valuesSourceType.getFormatter(format, tz);
        FieldContext fieldContext = new FieldContext(fieldType.name(), queryShardContext.getForField(fieldType), fieldType);
                vs = valueSourceType().getScript(script(), scriptValueType());
            aggregationScript = ((DerivedFieldType) fieldType).getAggregationScript(context);
     * @return null if we cannot apply the optimization, otherwise the point reader function.
        return format;
     * @param timeZone - Used to generate a format for dates
            null,
                if (valuesSourceType == null) {
            FieldContext fieldContext,
/*
            timeZone,
    }
            throw new IllegalStateException(
     * This method is used when an aggregation can optimize by using the indexed data instead of the doc values.  We check to see if the
        );
    /**
import org.opensearch.index.query.QueryShardContext;
    public Object missing() {
                return userValueTypeHint.getValuesSourceType();
 * not use this file except in compliance with the License.
        ZoneId timeZone,
        ValuesSourceConfig config;
        MappedFieldType fieldType
        if (script != null) {
        ValuesSourceType defaultValuesSourceType
        return script;
        } else {
    @Nullable
import java.util.function.Function;
    @Nullable
import java.time.ZoneId;
                 * specified missing value.
        // If we are aggregating on derived field set the agg script.
 * specific language governing permissions and limitations
        DocValueFormat format,
    public ZoneId timezone() {
    }
    private final AggregationScript.LeafFactory script;
 * this work for additional information regarding copyright
import org.opensearch.search.DocValueFormat;
    public Function<byte[], Number> getPointReaderOrNull() {
import org.opensearch.common.annotation.PublicApi;
     */
    private final Object missing;
            userValueTypeHint,
    }
            defaultValueSourceType,
     * @param defaultValueSourceType - per-aggregation {@link ValuesSource} of last resort.
    /**
        }
 * @opensearch.api
            return valueSourceType().replaceMissing(vs, missing, format, nowSupplier);
        }
     */
        );
 * Modifications Copyright OpenSearch Contributors. See
        } else {
        return internalResolve(
            fieldContext,
        }
    }
        if (fieldType != null && script() == null && missing() == null) {
        if (indexFieldData instanceof IndexNumericFieldData) {
@PublicApi(since = "1.0.0")
        return this.scriptValueType;
     * Returns a human readable description of this values source, for use in error messages and similar.
 * You may obtain a copy of the License at
            return CoreValuesSourceType.GEOPOINT;
     * Convenience method for creating unmapped configs
    }
    public ValuesSourceConfig(
            defaultValueSourceType,
        );
    private final ValuesSource valuesSource;
            missing,
            context,
     *
        DocValueFormat docValueFormat = resolveFormat(format, valuesSourceType, timeZone, fieldType);
                "value source config is invalid; must have either a field context or a script or marked as unmapped"
 */
     * @param defaultValueSourceType - per-aggregation {@link ValuesSource} of last resort.
/**
 * SPDX-License-Identifier: Apache-2.0
    private static ValuesSourceType getMappingFromRegistry(
     *
            timeZone,
    ) {
    public AggregationScript.LeafFactory script() {
            // If the user gave us a type hint, respect that.
        return fieldContext;
        }
    public static ValuesSourceConfig resolveUnregistered(
     *               See https://github.com/elastic/elasticsearch/issues/47469
     * Given the query context and other information, decide on the input {@link ValuesSource} for this aggretation run, and construct a new
                // Field or Value Script case
import org.opensearch.index.mapper.RangeFieldMapper;
    }
     * @param script - The script the user specified.  At least one of field and script must not be null
        return new ValuesSourceConfig(
    public MappedFieldType fieldType() {
            docValueFormat,
public class ValuesSourceConfig {
 * GitHub history for details.
                    // We have a field, and the user didn't specify a type, so get the type from the field
            userValueTypeHint,
        Object missing,
        String field,
        // Script or Unmapped case
        this.scriptValueType = scriptValueType;
 * KIND, either express or implied.  See the License for the
    }
import org.opensearch.script.Script;
        IndexFieldData<?> indexFieldData = fieldContext.indexFieldData();
        );
        return config;
        if (userValueTypeHint != null) {
    public boolean valid() {
            valuesSourceType,
    /**
            return null;
        config = new ValuesSourceConfig(
        return this.missing;
        FieldContext fieldContext,
            }
            return fieldType.pointReaderIfPossible();
 *
    /**
     * @param missing - A user specified value to apply when the field is missing.  Should be of type userValueTypeHint
        if (this.unmapped) {
     * @param script - The script the user specified.  At least one of field and script must not be null
            return factory.newFactory(script.getParams(), context.lookup());
        }
        return fieldContext == null ? null : fieldContext.fieldType();
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under
            if (fieldType == null) {
        AggregationScript.LeafFactory aggregationScript = createScript(script, context); // returns null if script is null
    }
        } else if (indexFieldData instanceof IndexGeoPointFieldData) {
     * @param context - the query context
        }
    /**
import org.opensearch.index.fielddata.IndexNumericFieldData;
            missing,
        ValueType scriptValueType = userValueTypeHint;
    ) {
 * A configuration that tells aggregations how to retrieve data from the index
     * @param format - The format string to apply to this field.  Confusingly, this is used for input parsing as well as output formatting
        }
 */
            format,
        return internalResolve(
            null,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (field == null) {
            valuesSourceType = userValueTypeHint.getValuesSourceType();
    public FieldContext fieldContext() {
        } else {
     * are operating on, for example Parent and Child join aggregations, which use the join relation to find the field they are reading from
    private ValuesSource ConstructValuesSource(Object missing, DocValueFormat format, LongSupplier nowSupplier) {
        String field,
            false,
        @Nullable ValuesSourceType valuesSourceType,
 * under the License.
        );
        ValuesSourceType defaultValuesSourceType
            fieldType = context.fieldMapper(field);
        ValuesSourceType getValuesSourceType(
            field,
     * @param field - The field being aggregated over.  At least one of field and script must not be null
        ZoneId timeZone,
        Script script,
     * {@link ValuesSourceAggregationBuilder} should not use this method, preferring {@link ValuesSourceConfig#resolve} instead.
        }
        MappedFieldType fieldType = fieldType();
        ValueType userValueTypeHint,
        boolean unmapped,
        this.unmapped = unmapped;
        this.format = format == null ? DocValueFormat.RAW : format;
            ValuesSourceConfig::getLegacyMapping
            } else {
        QueryShardContext context,
        }
        FieldResolver fieldResolver
    private static DocValueFormat resolveFormat(
import org.opensearch.index.mapper.DerivedFieldType;
    public static ValuesSourceConfig resolveFieldOnly(MappedFieldType fieldType, QueryShardContext queryShardContext) {
     * @param missing - A user specified value to apply when the field is missing.  Should be of type userValueTypeHint
        } else {
    }
        Script script,
        this.missing = missing;
        FieldContext fieldContext,
     */
     *               See https://github.com/elastic/elasticsearch/issues/47469
    ) {
            vs = valueSourceType().getEmpty();
        String format,
            fieldContext.indexFieldData().getValuesSourceType(),
    private final boolean unmapped;
        return valuesSourceType;
                 * We got here because the user specified a field, but it doesn't exist on this index, possibly because of a wildcard index
            null,
            fieldContext,
     * value at read time).  If the settings allow for it, we then ask the {@link ValuesSourceType} to build the actual point reader
    }
    private static ValuesSourceType getLegacyMapping(
        ZoneId timeZone,
            if (userValueTypeHint == null) {
package org.opensearch.search.aggregations.support;
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param userValueTypeHint - User specified value type; used for missing values and scripts
import org.opensearch.script.AggregationScript;
        ValuesSourceType valuesSourceType = null;
     * Special case factory method, intended to be used by aggregations which have some specialized logic for figuring out what field they
    }
    @FunctionalInterface
    public ValueType scriptValueType() {
            if (script == null) {
    private final DocValueFormat format;
    private final ZoneId timeZone;
        AggregationScript.LeafFactory script,
    private final ValuesSourceType valuesSourceType;
     * pre-registry logic to decide on the {@link ValuesSourceType}.  New aggregations which extend from
        this.fieldContext = fieldContext;
                return defaultValuesSourceType;
    private static ValuesSourceConfig internalResolve(
    public static ValuesSourceConfig resolveUnmapped(ValuesSourceType valuesSourceType, QueryShardContext queryShardContext) {
     * @return - An initialized {@link ValuesSourceConfig} that will yield the appropriate {@link ValuesSourceType}
}
            missing,
    }
                unmapped = true;
            context::nowInMillis
            valuesSourceType = defaultValueSourceType;
        return fieldContext != null || script != null || unmapped;
 *
            ValueType userValueTypeHint,
        ValueType userValueTypeHint,
            return CoreValuesSourceType.RANGE;
        ValuesSourceType defaultValueSourceType
        if (script == null) {
     * indexed data will match the values source output (meaning there isn't a script or a missing value, since both could modify the
        return fieldContext != null || script != null || missing != null;
        }
        Object missing,
        return null;
 * license agreements. See the NOTICE file distributed with
 */
            } else {
        }
    }
            } else {
        Script script,
        @Nullable String format,
import org.opensearch.index.mapper.MappedFieldType;
     * the specified field does not exist on this index.
            null,
    }
    }
 */
        QueryShardContext context,
            format,
    }
    ) {
        this.valuesSourceType = valuesSourceType;
                fieldContext = new FieldContext(fieldType.name(), context.getForField(fieldType), fieldType);
            timeZone,
        }
import org.opensearch.index.fielddata.IndexFieldData;
        String format,
                 * pattern.  In this case, we're going to end up using the EMPTY variant of the ValuesSource, and possibly applying a user
        if (!valid()) {
        if (unmapped && fieldContext != null) {
    public boolean hasValues() {
    public boolean hasGlobalOrdinals() {
            null,
     * @param context - the query context
                }
        return fieldContext.indexFieldData().getValuesSourceType();
        ValueType scriptValueType,
    ) {
        MappedFieldType fieldType = fieldType();
            script,
    }
        if (missing() != null) {
    private final ValueType scriptValueType;
/*
        return valuesSource.hasGlobalOrdinals();
     * @param format - The format string to apply to this field.  Confusingly, this is used for input parsing as well as output formatting
        ValueType userValueTypeHint,
     */
    public String getDescription() {
        QueryShardContext context,
 * Unless required by applicable law or agreed to in writing,
import java.util.function.LongSupplier;
    }
        throw new UnsupportedOperationException();
     * AKA legacy resolve.  This method should be called by aggregations not supported by the {@link ValuesSourceRegistry}, to use the
            context,
            ValuesSourceConfig::getMappingFromRegistry
                vs = valueSourceType().getField(fieldContext(), script());
        return "unmapped field";
                aggregationScript = null;  // Value scripts are not allowed on unmapped fields. What would that do, anyway?
    }
        if (fieldType != null) {
            throw new IllegalStateException("value source config is invalid; marked as unmapped but specified a mapped field");
 *
            }
            return "Script yielding [" + (scriptValueType != null ? scriptValueType.getPreferredName() : "unknown type") + "]";
            aggregationScript,
        if (fieldType != null) {
    /**
    }
     * @return - An initialized {@link ValuesSourceConfig} that will yield the appropriate {@link ValuesSourceType}
     * Convenience method for looking up the mapped field type backing this values source, if it exists.
        if (fieldType != null && fieldType.unwrap() instanceof DerivedFieldType) {
    private interface FieldResolver {
            return CoreValuesSourceType.NUMERIC;
        boolean unmapped = false;
    }
    private static AggregationScript.LeafFactory createScript(Script script, QueryShardContext context) {
            ValuesSourceType defaultValuesSourceType
            queryShardContext::nowInMillis
                    valuesSourceType = fieldResolver.getValuesSourceType(fieldContext, userValueTypeHint, defaultValueSourceType);
            unmapped,
        return this.timeZone;
    }
            );
/*
        if (valuesSourceType == null) {
            return "Field [" + fieldType.name() + "] of type [" + fieldType.typeName() + "]";
            // Field case
    ) {
     */
 *
        ZoneId timeZone,
