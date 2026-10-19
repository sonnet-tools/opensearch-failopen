    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(IpFieldMapper.class);
                    hasDocValues.getValue(),
        /** Still searchable from doc values when the index uses a pluggable data format. */
            return CONTENT_TYPE;
            private int count;
        }
            context.doc().add(new InetAddressField(fieldType().name(), address));
                @Override
            } else {
        public Object valueForDisplay(Object value) {
        this.indexCreatedVersion = builder.indexCreatedVersion;
 * not use this file except in compliance with the License.
        static {
    }
        private final InetAddress nullValue;
                if (hasDocValues()) {
            mappedFieldType,
                        true,
         * Processes query bounds into {@code long}s and delegates the
            return new SourceValueFetcher(name(), context, nullValue) {
                this.in = in;
    public IpFieldType fieldType() {
            if (format != null) {
                        address = (InetAddress) value;
            .acceptsNull();
        private final Parameter<String> nullValue = Parameter.stringParam("null_value", false, m -> toType(m).nullValueAsString, null)
 * compatible open source license.
import org.opensearch.common.network.NetworkAddress;
                if (includeUpper == false) {
         */
                return null;
 */
        }
 */
        @Override
     *
import org.apache.lucene.index.SortedSetDocValues;
                    throw e;
            return combineQueries(queries);
                }
                ),
    }
            try {
            } else {
import java.time.ZoneId;
                    true,
 *
                    final Tuple<InetAddress, Integer> cidr = InetAddresses.parseCidr(term);
        }
        }
                    upper = InetAddressPoint.nextDown(upper);
        public Builder(String name, boolean ignoreMalformedByDefault, Version indexCreatedVersion, Settings settings) {
    /**
        }
                return new MatchNoDocsQuery();
public class IpFieldMapper extends ParametrizedFieldMapper {
    protected DerivedFieldGenerator derivedFieldGenerator() {
        }
import org.apache.lucene.search.BooleanClause;
            }
     *    1. When using doc values, for multi value field, result would be deduplicated and in sorted order
        }
        }
    /**
        private Query indexTermsQuery(List<InetAddress> concreteIPs, List<PointRangeQuery> masks) {
            Map<String, String> meta
            List<BytesRef> ipsBytes = concreteIPs.stream().map(addr -> new BytesRef(InetAddressPoint.encode(addr))).toList();
                    BytesRef encoded = in.lookupOrd(ords[index]);
            for (Object value : values) {
            public IpScriptDocValues(SortedSetDocValues in) {
                    );
                } else {
                    throw new RuntimeException(e);
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
                    }
        } else {
                case 0 -> new MatchNoDocsQuery();
                bqb.add(q, BooleanClause.Occur.SHOULD);
import org.apache.lucene.search.ConstantScoreQuery;
                } else {
                }
                return InetAddresses.forString(value.toString());
    public static final String CONTENT_TYPE = "ip";
    protected void parseCreateField(ParseContext context) throws IOException {
            context.doc().add(new SortedSetDocValuesField(fieldType().name(), new BytesRef(InetAddressPoint.encode(address))));
        return ignoreMalformed;
                    lower = InetAddressPoint.nextUp(lower);
        return new InetAddressField(name, value);
                    return null;
                return hasDocValues() ? docValuesTermsQuery(concreteIPs, masks) : new MatchNoDocsQuery("never happened");
 * this work for additional information regarding copyright
import org.opensearch.common.collect.Tuple;
                if (value instanceof BytesRef) {
            FIELD_TYPE.setDocValuesType(DocValuesType.SORTED_SET);
            private long[] ords = new long[0];
        public DocValueFormat docValueFormat(@Nullable String format, ZoneId timeZone) {
            };
                if (value instanceof BytesRef) {
            new SortedSetDocValuesFetcher(mappedFieldType, simpleName()),
                    return new IndexOrDocValuesQuery(pointQuery, dvQuery);
            @Override
            if (masks.size() == 1) {
                multiFieldsBuilder.build(this, context),
                        new BytesRef(masks.getFirst().getLowerPoint()),
            };
                if (includeLower == false) {
        }
            }
import org.opensearch.index.compositeindex.datacube.DimensionType;
        this.indexed = builder.indexed.getValue();
import org.opensearch.common.Explicit;
                MultiIpRangeQueryBuilder multiRange = new MultiIpRangeQueryBuilder(name());
                } else {
                if (term.contains("/")) {
        if (stored) {
            public String getValue() {
            return DocValueFormat.IP.format((BytesRef) value);
                    masks.add((PointRangeQuery) InetAddressPoint.newPrefixQuery(name(), cidr.v1(), cidr.v2()));
                );
            }
        @Override
                    return SortedSetDocValuesField.newSlowExactQuery(name(), ipsBytes.getFirst());
                }
        public Query termsQuery(List<?> values, QueryShardContext context) {
            if (masks.isEmpty()) {
                        true,
                }
            super(name);
        public Builder(String name, boolean ignoreMalformedByDefault, Version indexCreatedVersion) {
        }
import org.opensearch.search.lookup.SearchLookup;
            return new IndexOrDocValuesQuery(indexTermsQuery(concreteIPs, masks), docValuesTermsQuery(concreteIPs, masks));
            if (format != null) {
        private final Parameter<Boolean> stored = Parameter.storeParam(m -> toType(m).stored, false);
            super(name, FIELD_TYPE);
    }
            this.ignoreMalformedByDefault = ignoreMalformedByDefault;
         */
        if (addressAsObject == null) {
                        return new MatchNoDocsQuery();
    }
        }
                    return get(0);
            createFieldNamesField(context);
        }
                    return SortedSetDocValuesField.newSlowRangeQuery(
    @Override
                }
                if (count == 0) {
    public static final TypeParser PARSER = new TypeParser((n, c) -> {
        }
            }
    private final InetAddress nullValue;
import org.opensearch.common.Nullable;
                    true
        this.stored = builder.stored.getValue();
 * A {@link FieldMapper} for ip addresses.
                m -> toType(m).ignoreMalformed,
                );
                return null;
    /**
import org.opensearch.common.settings.Settings;
    protected Explicit<Boolean> ignoreMalformed() {
        return (IpFieldType) super.fieldType();
        }
        super(simpleName, mappedFieldType, multiFields, copyTo, builder.isPluggableDataFormat());
                        new BytesRef(pointQuery.getLowerPoint()),
 * license agreements. See the NOTICE file distributed with
     * 2. If doc_values is disabled in field mapping, then build source using stored field
        }
                    if (lower.equals(InetAddressPoint.MAX_VALUE)) {
                    context.addIgnoredField(fieldType().name());
            return Optional.of(DimensionType.IP);
                    buildFullName(context),
            this(name, true, false, true, null, Collections.emptyMap());
                        address = InetAddresses.forString(value.toString());
            }
                    "Field [" + name() + "] of type [" + typeName() + "] does not support custom time zones"
import org.apache.lucene.document.InetAddressPoint;
                return isSearchable() ? pointQuery : dvQuery;
import org.opensearch.index.fielddata.ScriptDocValues;
        public static final class IpScriptDocValues extends ScriptDocValues<String> {
        }
            }
/*
 * software distributed under the License is distributed on an
                return (InetAddress) value;
                    "Error parsing ["
        @Override
                case 1 -> queries.getFirst();
            if (ipsBytes.isEmpty() && masks.isEmpty()) {
            }
        return fieldType().typeName();
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
     *
            List<InetAddress> concreteIPs = new ArrayList<>();
    }
 * GitHub history for details.
            parseIps(values, concreteIPs, masks);
     * <p>
    protected IpFieldMapper clone() {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.search.DocValueFormat;
                return InetAddresses.forString(addressAsString);
    @Override
    @Override
        ) {
            });
                    value = ((BytesRef) value).utf8ToString();
        }
     */
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.BooleanQuery;
import org.opensearch.common.logging.DeprecationLogger;
            public void setNextDocId(int docId) throws IOException {
package org.opensearch.index.mapper;
        }
            failIfNotIndexedAndNoDocValues();
                    dvQuery = SortedSetDocValuesField.newSlowRangeQuery(
                    : InetAddressPoint.newSetQuery(name(), ips.toArray(new InetAddress[0]))
            if (nullValueAsString == null) {
            // Both searchable and doc values available - create composite query
                        name(),
        private final boolean ignoreMalformedByDefault;
    private final boolean hasDocValues;
    }
        this.ignoreMalformed = builder.ignoreMalformed.getValue();
                name,
                String term = value.toString();
                lower = parse(lowerTerm);
            add(new MultiRangeQuery.RangeClause(InetAddressPoint.encode(lower), InetAddressPoint.encode(upper)));
                if (ignoreMalformed().value()) {
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] does not support custom formats");
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.PointRangeQuery;
        }
/*
     * 1. If it has doc values, build source using doc values
        public IpFieldType(String name) {
        return new Builder(n, ignoreMalformedByDefault, c.indexVersionCreated(), c.getSettings());
        if (context.externalValueSet()) {
import org.opensearch.Version;
    }
            this.ignoreMalformed = Parameter.explicitBoolParam(
            } else {
import org.apache.lucene.search.MatchNoDocsQuery;
        }
 * the Apache License, Version 2.0 (the "License"); you may
                String addressAsString = addressAsObject.toString();
                        .nextOrd()) {
 * You may obtain a copy of the License at
            InetAddress upper;
    private IpFieldMapper(String simpleName, MappedFieldType mappedFieldType, MultiFields multiFields, CopyTo copyTo, Builder builder) {
        @Override
/**
        }
         * Field type for IP Scripted doc values
            this.indexCreatedVersion = indexCreatedVersion;
            failIfNotIndexedAndNoDocValues();
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
            return;
                        Arrays.copyOfRange(encoded.bytes, encoded.offset, encoded.offset + encoded.length)
                if (value instanceof InetAddress) {
            String nullValueAsString = nullValue.getValue();
                    value = ((BytesRef) value).utf8ToString();
    protected String contentType() {
            List<Query> queries = new ArrayList<>();
    public static class MultiIpRangeQueryBuilder extends MultiRangeQuery.Builder {
            addressAsObject = context.parser().textOrNull();
        }
            }
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
                    }
                    if (value instanceof InetAddress) {
                    InetAddress address;
 *
 * this file be licensed under the Apache-2.0 license or a
            }
        } else if (indexed) {
                    name(),
     */
            return this;
                } else {
            List<PointRangeQuery> masks = new ArrayList<>();
            return (InetAddress) addressAsObject;
        context.documentInput().addField(fieldType(), address);
            boolean hasDocValues,
        @Override
            this.nullValue = nullValue;
                return null;
import java.util.function.BiFunction;
}
        @Override
        }
            }
 */
                }
                this
        }
            failIfNotIndexedAndNoDocValues();
     * Builder
                } else {
        if (address == null) {
            boolean includeUpper,
            } catch (Exception e) {
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {
            if (lowerTerm == null) {
        private final Version indexCreatedVersion;
                }
        protected List<Parameter<?>> getParameters() {
                Query dvQuery = null;
        checkStoredAndDocValuesForDerivedSource();
                lower = InetAddressPoint.MIN_VALUE;
        if (addressAsObject instanceof InetAddress) {
    public static class Builder extends ParametrizedFieldMapper.Builder {
        }
    public static InetAddressField buildInetAddressField(String name, InetAddress value) {
        }
import java.util.Optional;
        @Override
            if (hasDocValues()) {
import org.apache.lucene.sandbox.search.DocValuesMultiRangeQuery;
        private void addMaskQueries(List<PointRangeQuery> masks, List<Query> queries) {
                if (ipsBytes.size() == 1) {
                if (strVal.contains("/")) {
        private static InetAddress parse(Object value) {
            if (!isSearchable()) {
     * Field type for IP fields
        final InetAddress address = getFieldValue(context);
            public String get(int index) {
            }
import java.io.IOException;
         * @opensearch.internal
                    }
import java.util.Map;
        }
                PointRangeQuery pointQuery = (PointRangeQuery) InetAddressPoint.newRangeQuery(name(), lower, upper);
                        name()
            } else {
                protected Object parseSourceValue(Object value) {
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;
                    return null;
        private InetAddress parseNullValue() {
                return InetAddresses.forString(nullValueAsString);
import org.apache.lucene.document.SortedSetDocValuesField;
            }
     */
     */
        this.ignoreMalformedByDefault = builder.ignoreMalformedByDefault;
                        new BytesRef(pointQuery.getUpperPoint()),
        }
        @Override
     * @opensearch.internal
            return bqb.build();
            failIfNoDocValues();
import org.apache.lucene.util.BytesRef;
    @Override
            return DocValueFormat.IP;
        this.hasDocValues = builder.hasDocValues.getValue();
                    pointQuery = (PointRangeQuery) InetAddressPoint.newExactQuery(name(), address);
import org.opensearch.index.IndexSettings;
import org.apache.lucene.sandbox.search.MultiRangeQuery;
                );
                    return isSearchable() ? pointQuery : dvQuery;
import org.opensearch.index.fielddata.IndexFieldData;
                new IpFieldType(
        @Override
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            try {
            return this;
                return count;
                ips.size() == 1
 * specific language governing permissions and limitations
            } else {
    /**
            if (ips.isEmpty()) return;
    }
            }
                    pointQuery = (PointRangeQuery) InetAddressPoint.newPrefixQuery(name(), cidr.v1(), cidr.v2());
        @Override
    @Override
                        + "]); [null_value] will be ignored"
        public String typeName() {
                return indexTermsQuery(concreteIPs, masks);
            return isSearchable() || (indexSettings != null && indexSettings.isPluggableDataFormatEnabled() && hasDocValues());
        this.nullValueAsString = builder.nullValue.getValue();
import org.apache.lucene.search.Query;
            );
                }
import org.opensearch.common.network.InetAddresses;
        if (address == null) {
            }
            Query dvQuery = null;
            boolean stored,
import org.apache.lucene.search.IndexOrDocValuesQuery;
    }
                    Tuple<InetAddress, Integer> cidr = InetAddresses.parseCidr(strVal);
            super(field, InetAddressPoint.BYTES, 1);
            };
        return (IpFieldMapper) super.clone();
    }
         * provided {@code builder} to build a range query.
                } catch (IOException e) {
        }
        return new Builder(simpleName(), ignoreMalformedByDefault, indexCreatedVersion).init(this);
                    );
                }
        }
            if (value instanceof InetAddress) {
                    concreteIPs.add((InetAddress) value);
                    parseNullValue(),
            }
                        ords[count++] = ord;
            }
            if (upperTerm == null) {
    }
        protected FieldTypeCapabilities.Capability searchCapability() {
        }
                    } else {
            final PointRangeQuery pointQuery;
import java.util.ArrayList;
                queries.add(multiRange.build());
         *
        if (indexed && hasDocValues) {
        private final Parameter<Boolean> indexed = Parameter.indexParam(m -> toType(m).indexed, () -> pluggableDataFormat == false);
import org.apache.lucene.document.FieldType;
                try {
            return FieldTypeCapabilities.Capability.POINT_RANGE;
            addressAsObject = context.externalValue();
            if (isSearchable() && hasDocValues()) {
    public static final class IpFieldType extends SimpleMappedFieldType {
    protected InetAddress getFieldValue(ParseContext context) throws IOException {
        Builder nullValue(String nullValue) {
                @Override
                    meta.getValue()
                    stored.getValue(),
        private Query docValuesTermsQuery(List<InetAddress> concreteIPs, List<PointRangeQuery> masks) {
import org.apache.lucene.index.DocValuesType;
    }
                }
                return new IndexOrDocValuesQuery(pointQuery, dvQuery);
    private final Version indexCreatedVersion;
        );
                        new BytesRef(masks.getFirst().getUpperPoint()),
 * ownership. Elasticsearch licenses this file to you under
     */
            return Arrays.asList(indexed, hasDocValues, stored, ignoreMalformed, nullValue, meta);
            return new IpFieldMapper(
            boolean includeLower,
    }
            Object lowerTerm,
            super(name, indexed, stored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);
    private final String nullValueAsString;
    private final boolean ignoreMalformedByDefault;
            addMaskQueries(masks, queries);
        }
     * Field type that combines dimensional points and doc values for IP fields
        ) {
        }
            queries.add(
                queries.add(masks.getFirst());
                        + "] as IP in [null_value] on field ["
    public static class InetAddressField extends Field {
        return new DerivedFieldGenerator(
                    "ip_mapper_null_field",
                protected String toString(int dimension, byte[] value) {
            if (value instanceof InetAddress) {
        Object addressAsObject;
            InetAddress lower;
        final InetAddress address = getFieldValue(context);
 * Unless required by applicable law or agreed to in writing,
        }
            boolean indexed,
        public MultiIpRangeQueryBuilder add(InetAddress lower, InetAddress upper) {
        /**
                }
                throw new IllegalArgumentException(
                }
                    return InetAddresses.toAddrString(address);
        public boolean isSearchableViaDocValues(IndexSettings indexSettings) {
        }
        /**
        private void parseIps(List<?> values, List<InetAddress> concreteIPs, List<PointRangeQuery> masks) {
                }
        public IpFieldMapper build(BuilderContext context) {
        private static final FieldType FIELD_TYPE = new FieldType();
            this(name, ignoreMalformedByDefault, indexCreatedVersion, Settings.EMPTY);
    private final Explicit<Boolean> ignoreMalformed;
 *
                    );
        }
        boolean ignoreMalformedByDefault = IGNORE_MALFORMED_SETTING.get(c.getSettings());
     *    2. When using stored field, order and duplicate values would be preserved
 * @opensearch.internal
                pointQuery = (PointRangeQuery) InetAddressPoint.newExactQuery(name(), (InetAddress) value);
            private final SortedSetDocValues in;
                    return InetAddresses.toAddrString(address);
        public MultiIpRangeQueryBuilder(String field) {
 * KIND, either express or implied.  See the License for the
            String name,
                        return new MatchNoDocsQuery();
                String strVal = value instanceof BytesRef ? ((BytesRef) value).utf8ToString() : value.toString();
                if (isSearchable() && hasDocValues()) {
    private static IpFieldMapper toType(FieldMapper in) {
import org.apache.lucene.util.ArrayUtil;
        public InetAddressField(String name, InetAddress value) {
/*
                        pointQuery.getField(),
import java.util.function.Supplier;
        }
        public IpFieldType(
            public int size() {
            return switch (queries.size()) {
        @Override
        }
        }
                    masks.forEach(q -> builder.add(new BytesRef(q.getLowerPoint()), new BytesRef(q.getUpperPoint())));
    }
 * under the License.
 */
    private final boolean stored;
                default -> new ConstantScoreQuery(union(queries));
    });
        } else if (hasDocValues) {
                    );
                    if (upper.equals(InetAddressPoint.MIN_VALUE)) {
                        ords = ArrayUtil.grow(ords, count + 1);
            @Override
                }
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
            addressAsObject = nullValue;
        public MultiRangeQuery build() {
            }
                    }
            return rangeQuery(lowerTerm, upperTerm, includeLower, includeUpper, (lower, upper) -> {
            if (timeZone != null) {
                if (masks.size() == 1 && ipsBytes.isEmpty()) {
            context.doc().add(new InetAddressPoint(fieldType().name(), address));
                if (in.advanceExact(docId)) {
import org.opensearch.index.query.QueryShardContext;
        return (IpFieldMapper) in;
                    concreteIPs.add(InetAddresses.forString(strVal));
            this.pluggableDataFormat = Mapper.isPluggableDataFormatEnabled(settings);
            if (!hasDocValues()) {
import java.util.Collections;
                }
            for (Query q : combiner) {
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
        private Query union(List<Query> combiner) {
                dvQuery = SortedSetDocValuesField.newSlowRangeQuery(
                        true
                    InetAddress address = InetAddressPoint.decode(
    @Override
        private void addConcreteIpQuery(List<InetAddress> ips, List<Query> queries) {
                ignoreMalformedByDefault
        private Query combineQueries(List<Query> queries) {
        if ((stored || indexed) && hasDocValues == false) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                DEPRECATION_LOGGER.deprecate(
    }
                } else {
            this.nullValue.setValue(nullValue);
    @Override
        public Query termQuery(Object value, @Nullable QueryShardContext context) {
                count = 0;
import java.util.List;
            return builder.apply(lower, upper);
            } else {
            BooleanQuery.Builder bqb = new BooleanQuery.Builder();
            }
                } else {
    @Override
            return new MultiRangeQuery(field, numDims, bytesPerDim, clauses) {
            FIELD_TYPE.setDimensions(1, InetAddressPoint.BYTES);
    @Override
            }
                    ipsBytes.forEach(builder::add);
            fieldsData = new BytesRef(InetAddressPoint.encode(value));
            InetAddress nullValue,
            return new SortedSetOrdinalsIndexFieldData.Builder(name(), IpScriptDocValues::new, CoreValuesSourceType.IP);
        public Optional<DimensionType> getSupportedDataCubeDimensionType() {
            new StoredFieldFetcher(mappedFieldType, simpleName())
                masks.forEach(q -> multiRange.add(q.getLowerPoint(), q.getUpperPoint()));
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
         */
        } else {
 *
 * Licensed to Elasticsearch under one or more contributor
                upper = InetAddressPoint.MAX_VALUE;
        }
                        + name()
            BiFunction<InetAddress, InetAddress, Query> builder
        }
                upper = parse(upperTerm);
        }
        @Override
                    new BytesRef(pointQuery.getLowerPoint()),
import java.net.InetAddress;
                    return NetworkAddress.format(InetAddressPoint.decode(value));
            }
                        + nullValue.getValue()
        @Override
         * Create new instance
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
            FIELD_TYPE.freeze();
            );
                    return SortedSetDocValuesField.newSlowSetQuery(name(), ipsBytes);
            addConcreteIpQuery(concreteIPs, queries);
            }
        this.nullValue = builder.parseNullValue();
    protected void canDeriveSourceInternal() {
            }
    }
            if (masks.isEmpty()) return;
import org.apache.lucene.document.StoredField;
            context.doc().add(new StoredField(fieldType().name(), new BytesRef(InetAddressPoint.encode(address))));
        /**
                true,
        private final Parameter<Explicit<Boolean>> ignoreMalformed;
                    for (long ord = in.nextOrd(); ord != SortedSetDocValues.NO_MORE_DOCS && count < in.docValueCount(); ord = in
            if (value == null) {
            }
import org.apache.lucene.document.Field;
            }
import java.util.Arrays;
                    DocValuesMultiRangeQuery.SortedSetStabbingBuilder builder = new DocValuesMultiRangeQuery.SortedSetStabbingBuilder(
                    new BytesRef(pointQuery.getUpperPoint()),
            return;
            } catch (IllegalArgumentException e) {
    private final boolean indexed;
                }
        }
    /**
     * @opensearch.internal
                    InetAddress address = InetAddresses.forString(term);
                "ignore_malformed",
            );
            } else {
                    return builder.build();
                        true
        public static Query rangeQuery(
                    indexed.getValue(),
                }
    @Override
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);
                    continue;
            Object upperTerm,
            }
        if (addressAsObject == null) {
     * Considerations:
        @Override
                    ? InetAddressPoint.newExactQuery(name(), ips.getFirst())
     * Union over IP address ranges
                copyTo.build(),
            @Override
            return null;
