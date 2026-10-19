        if (stored) {  
    private final boolean stored;
 * Licensed to Elasticsearch under one or more contributor  
            return Arrays.asList(indexed, hasDocValues, stored, ignoreMalformed, nullValue, meta);  
    public static class Builder extends ParametrizedFieldMapper.Builder {
        }
    protected InetAddress getFieldValue(ParseContext context) throws IOException {  
        @Override
                PointRangeQuery pointQuery = (PointRangeQuery) InetAddressPoint.newRangeQuery(name(), lower, upper);  
import java.util.List;
                    context.addIgnoredField(fieldType().name());  
        }  
                        ords = ArrayUtil.grow(ords, count + 1);
                );
    @Override  
/**
        boolean ignoreMalformedByDefault = IGNORE_MALFORMED_SETTING.get(c.getSettings());
        return new InetAddressField(name, value);
            } else {
        /**
        this.nullValue = builder.parseNullValue();  
                        + name()  
package org.opensearch.index.mapper;
            this.pluggableDataFormat = Mapper.isPluggableDataFormatEnabled(settings);  
    public IpFieldType fieldType() {
        final InetAddress address = getFieldValue(context);  
    }  
import java.util.function.BiFunction;
import org.apache.lucene.document.SortedSetDocValuesField;
                } else {
        }  
                    value = ((BytesRef) value).utf8ToString();
        }  
            }  
        @Override
            this.ignoreMalformedByDefault = ignoreMalformedByDefault;
        this.stored = builder.stored.getValue();
         *
 * specific language governing permissions and limitations
                );  
                    }  
            return Optional.of(DimensionType.IP);
import org.opensearch.search.DocValueFormat;
                String addressAsString = addressAsObject.toString();
        /** Still searchable from doc values when the index uses a pluggable data format. */  
                    return null;
                if (value instanceof BytesRef) {
    protected Explicit<Boolean> ignoreMalformed() {  
        protected List<Parameter<?>> getParameters() {
        if ((stored || indexed) && hasDocValues == false) {  
        return ignoreMalformed;
            } catch (Exception e) {  
                    pointQuery = (PointRangeQuery) InetAddressPoint.newExactQuery(name(), address);
            failIfNotIndexedAndNoDocValues();
     *
                        address = (InetAddress) value;  
}
            if (ips.isEmpty()) return;
        public InetAddressField(String name, InetAddress value) {  
                return InetAddresses.forString(value.toString());
        } else if (indexed) {
                lower = InetAddressPoint.MIN_VALUE;
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
                    return SortedSetDocValuesField.newSlowExactQuery(name(), ipsBytes.getFirst());  
            return combineQueries(queries);
                dvQuery = SortedSetDocValuesField.newSlowRangeQuery(  
                        true,
                    hasDocValues.getValue(),
            }  
import org.opensearch.index.fielddata.ScriptDocValues;
                if (count == 0) {  
            }
                    BytesRef encoded = in.lookupOrd(ords[index]);
        }
import org.opensearch.index.IndexSettings;  
        public Builder(String name, boolean ignoreMalformedByDefault, Version indexCreatedVersion) {
            } else {  
                if (includeLower == false) {
 * The OpenSearch Contributors require contributions made to  
            super(name);  
            boolean includeUpper,  
                    concreteIPs.add((InetAddress) value);
                }  
        }
        ) {
            };  
            addressAsObject = context.parser().textOrNull();
            context.doc().add(new StoredField(fieldType().name(), new BytesRef(InetAddressPoint.encode(address))));
            }  
    public static final TypeParser PARSER = new TypeParser((n, c) -> {
            private long[] ords = new long[0];
            parseIps(values, concreteIPs, masks);  
                        new BytesRef(masks.getFirst().getLowerPoint()),
        }  
            if (ipsBytes.isEmpty() && masks.isEmpty()) {
            return null;
            } else {
                    return builder.build();
            this.indexCreatedVersion = indexCreatedVersion;
                    return null;
            }
        if (address == null) {
import org.opensearch.Version;
        }
            }
/*  
                return count;
            boolean hasDocValues,
        return (IpFieldMapper) in;
                        .nextOrd()) {
            // Both searchable and doc values available - create composite query
    /**
                    new BytesRef(pointQuery.getLowerPoint()),
        private void parseIps(List<?> values, List<InetAddress> concreteIPs, List<PointRangeQuery> masks) {
                    "Field [" + name() + "] of type [" + typeName() + "] does not support custom time zones"
            List<PointRangeQuery> masks = new ArrayList<>();
            InetAddress lower;  
        public static Query rangeQuery(
            if (timeZone != null) {  
        }  
            addMaskQueries(masks, queries);
            return this;
        public IpFieldMapper build(BuilderContext context) {
            public String getValue() {
            queries.add(
                new IpFieldType(
                return isSearchable() ? pointQuery : dvQuery;
            BooleanQuery.Builder bqb = new BooleanQuery.Builder();
                    masks.add((PointRangeQuery) InetAddressPoint.newPrefixQuery(name(), cidr.v1(), cidr.v2()));
                    );  
import java.net.InetAddress;  
import org.apache.lucene.sandbox.search.MultiRangeQuery;  
        }
            } else {
                if (ignoreMalformed().value()) {
            if (!hasDocValues()) {  
    private final boolean ignoreMalformedByDefault;
    }
                return InetAddresses.forString(addressAsString);  
        public IpFieldType(String name) {
        return fieldType().typeName();
    public static class MultiIpRangeQueryBuilder extends MultiRangeQuery.Builder {  
        private final Version indexCreatedVersion;
        @Override
        }
        }  
import java.util.ArrayList;
        private void addConcreteIpQuery(List<InetAddress> ips, List<Query> queries) {
                } else {
        }
     */  
                    concreteIPs.add(InetAddresses.forString(strVal));  
import org.apache.lucene.document.Field;
            };
        public MultiIpRangeQueryBuilder(String field) {
                protected Object parseSourceValue(Object value) {  
        private static InetAddress parse(Object value) {  
            public String get(int index) {
                }
                        + "] as IP in [null_value] on field ["
                this.in = in;
    @Override  
    @Override
import java.time.ZoneId;
            }  
    }
import org.apache.lucene.sandbox.search.DocValuesMultiRangeQuery;
        }  
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
         * Processes query bounds into {@code long}s and delegates the
            Object upperTerm,
    @Override
            }  
                bqb.add(q, BooleanClause.Occur.SHOULD);  
            }  
                    );  
                    final Tuple<InetAddress, Integer> cidr = InetAddresses.parseCidr(term);  
        private Query indexTermsQuery(List<InetAddress> concreteIPs, List<PointRangeQuery> masks) {
import org.apache.lucene.document.InetAddressPoint;  
            return new MultiRangeQuery(field, numDims, bytesPerDim, clauses) {  
                    masks.forEach(q -> builder.add(new BytesRef(q.getLowerPoint()), new BytesRef(q.getUpperPoint())));
    @Override
                masks.forEach(q -> multiRange.add(q.getLowerPoint(), q.getUpperPoint()));  
        if (context.externalValueSet()) {
            mappedFieldType,
    }
                    lower = InetAddressPoint.nextUp(lower);  
        }
        private final Parameter<Boolean> stored = Parameter.storeParam(m -> toType(m).stored, false);
                        pointQuery.getField(),
    }  
    }
         * @opensearch.internal
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                    if (lower.equals(InetAddressPoint.MAX_VALUE)) {  
            return DocValueFormat.IP;
            this.nullValue.setValue(nullValue);
            this(name, true, false, true, null, Collections.emptyMap());
     * Union over IP address ranges
import org.opensearch.common.settings.Settings;
                        true,
        private final Parameter<Boolean> hasDocValues = Parameter.docValuesParam(m -> toType(m).hasDocValues, true);
        @Override
    }  
                } else {
        public Object valueForDisplay(Object value) {  
 * ownership. Elasticsearch licenses this file to you under  
        private final Parameter<Explicit<Boolean>> ignoreMalformed;
        );
            } else {  
    private final boolean hasDocValues;
     * Considerations:  
                    InetAddress address = InetAddressPoint.decode(
            fieldsData = new BytesRef(InetAddressPoint.encode(value));
                pointQuery = (PointRangeQuery) InetAddressPoint.newExactQuery(name(), (InetAddress) value);
                MultiIpRangeQueryBuilder multiRange = new MultiIpRangeQueryBuilder(name());
        public Query termsQuery(List<?> values, QueryShardContext context) {
                    if (upper.equals(InetAddressPoint.MIN_VALUE)) {
     * @opensearch.internal
                if (includeUpper == false) {  
                return new MatchNoDocsQuery();
import java.io.IOException;
    @Override
            if (value instanceof InetAddress) {
                return null;
     *    2. When using stored field, order and duplicate values would be preserved
            }  
    public static final String CONTENT_TYPE = "ip";
            return builder.apply(lower, upper);
                    }
                true,
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {  
        @Override
            if (hasDocValues()) {
        }  
            return new IpFieldMapper(
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {  
            if (isSearchable() && hasDocValues()) {
                ignoreMalformedByDefault
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
     * 2. If doc_values is disabled in field mapping, then build source using stored field
            }  
 * under the License.  
        }  
                lower = parse(lowerTerm);
        public static final class IpScriptDocValues extends ScriptDocValues<String> {
                    value = ((BytesRef) value).utf8ToString();
                throw new IllegalArgumentException(
            );  
    }  
        private final Parameter<Boolean> indexed = Parameter.indexParam(m -> toType(m).indexed, () -> pluggableDataFormat == false);  
                @Override
                ),
            this.nullValue = nullValue;
                DEPRECATION_LOGGER.deprecate(
                Query dvQuery = null;
        }  
import org.apache.lucene.index.SortedSetDocValues;
                        + nullValue.getValue()
    }
                        true
                        + "]); [null_value] will be ignored"
                case 0 -> new MatchNoDocsQuery();
        Object addressAsObject;
            public void setNextDocId(int docId) throws IOException {  
                if (hasDocValues()) {
     * Field type for IP fields
                return hasDocValues() ? docValuesTermsQuery(concreteIPs, masks) : new MatchNoDocsQuery("never happened");  
            super(field, InetAddressPoint.BYTES, 1);
                    : InetAddressPoint.newSetQuery(name(), ips.toArray(new InetAddress[0]))
                @Override
        public Optional<DimensionType> getSupportedDataCubeDimensionType() {
            private final SortedSetDocValues in;  
            Object lowerTerm,  
            }
import org.apache.lucene.search.ConstantScoreQuery;  
                    } else {
    private IpFieldMapper(String simpleName, MappedFieldType mappedFieldType, MultiFields multiFields, CopyTo copyTo, Builder builder) {
                queries.add(multiRange.build());
            );
     * 1. If it has doc values, build source using doc values  
        }  
            addressAsObject = context.externalValue();  
            createFieldNamesField(context);
 * compatible open source license.
        @Override
import org.apache.lucene.search.MatchNoDocsQuery;
            private int count;
            };
import org.opensearch.index.query.QueryShardContext;  
        this.nullValueAsString = builder.nullValue.getValue();
                }
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {  
        public Builder(String name, boolean ignoreMalformedByDefault, Version indexCreatedVersion, Settings settings) {
            if (!isSearchable()) {
        }
        @Override
            String name,
                    return InetAddresses.toAddrString(address);
            for (Object value : values) {  
 */  
    }
        public boolean isSearchableViaDocValues(IndexSettings indexSettings) {
    private static IpFieldMapper toType(FieldMapper in) {
            try {
                    );
        Builder nullValue(String nullValue) {  
            }
         */  
        }
    protected void parseCreateField(ParseContext context) throws IOException {
import org.apache.lucene.search.BooleanClause;
            public int size() {  
        }  
                copyTo.build(),
        this.ignoreMalformedByDefault = builder.ignoreMalformedByDefault;
        }
                    ipsBytes.forEach(builder::add);  
            failIfNoDocValues();
 */  
import org.apache.lucene.document.FieldType;
import org.apache.lucene.search.BooleanQuery;
         */
import java.util.Arrays;  
        private final InetAddress nullValue;
                        new BytesRef(masks.getFirst().getUpperPoint()),  
            FIELD_TYPE.freeze();  
            }
     * Field type that combines dimensional points and doc values for IP fields
                return (InetAddress) value;
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(IpFieldMapper.class);  
            failIfNotIndexedAndNoDocValues();
            this.ignoreMalformed = Parameter.explicitBoolParam(  
                return indexTermsQuery(concreteIPs, masks);
                } else {
            }
 *  
                );  
        } else if (hasDocValues) {  
            addressAsObject = nullValue;  
                    dvQuery = SortedSetDocValuesField.newSlowRangeQuery(  
 *
            return;  
        }
        @Override
            if (format != null) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                } catch (IOException e) {  
 * KIND, either express or implied.  See the License for the
                count = 0;
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override
 * Modifications Copyright OpenSearch Contributors. See
                        ords[count++] = ord;  
            boolean indexed,  
                    return SortedSetDocValuesField.newSlowRangeQuery(  
            public IpScriptDocValues(SortedSetDocValues in) {
    private final InetAddress nullValue;
import org.apache.lucene.document.StoredField;
                return null;  
 * not use this file except in compliance with the License.
                }
import org.opensearch.common.network.NetworkAddress;
     */  
                    parseNullValue(),  
    }
            FIELD_TYPE.setDimensions(1, InetAddressPoint.BYTES);
    private final String nullValueAsString;  
    });
    }  
                    }  
        }
                } else {
            }
import java.util.Collections;
                    "ip_mapper_null_field",
    }  
            final PointRangeQuery pointQuery;  
            }
                m -> toType(m).ignoreMalformed,  
        }
import org.apache.lucene.search.PointRangeQuery;  
                        Arrays.copyOfRange(encoded.bytes, encoded.offset, encoded.offset + encoded.length)  
            FIELD_TYPE.setDocValuesType(DocValuesType.SORTED_SET);
        }
import org.opensearch.index.fielddata.IndexFieldData;  
                    Tuple<InetAddress, Integer> cidr = InetAddresses.parseCidr(strVal);  
        /**  
                }
        private final Parameter<String> nullValue = Parameter.stringParam("null_value", false, m -> toType(m).nullValueAsString, null)
 * this file be licensed under the Apache-2.0 license or a
                this
    public static InetAddressField buildInetAddressField(String name, InetAddress value) {  
            failIfNotIndexedAndNoDocValues();
        }  
            }
        }
import org.opensearch.common.Explicit;
                } else {
        private static final FieldType FIELD_TYPE = new FieldType();
            List<Query> queries = new ArrayList<>();  
            }
        return (IpFieldMapper) super.clone();
                if (strVal.contains("/")) {
            super(name, indexed, stored, hasDocValues, TextSearchInfo.SIMPLE_MATCH_ONLY, meta);  
                        name(),
        private InetAddress parseNullValue() {
            }
            }  
                    InetAddress address = InetAddresses.forString(term);  
                return InetAddresses.forString(nullValueAsString);
        this.indexed = builder.indexed.getValue();
            @Override
        super(simpleName, mappedFieldType, multiFields, copyTo, builder.isPluggableDataFormat());  
    private final Version indexCreatedVersion;  
                    upper = InetAddressPoint.nextDown(upper);
    @Override
                }
            return new SortedSetOrdinalsIndexFieldData.Builder(name(), IpScriptDocValues::new, CoreValuesSourceType.IP);
                if (term.contains("/")) {
                    pointQuery = (PointRangeQuery) InetAddressPoint.newPrefixQuery(name(), cidr.v1(), cidr.v2());
                    continue;  
    }  
            } catch (IllegalArgumentException e) {
        public MultiRangeQuery build() {
                    for (long ord = in.nextOrd(); ord != SortedSetDocValues.NO_MORE_DOCS && count < in.docValueCount(); ord = in  
            return this;
 * software distributed under the License is distributed on an
            InetAddress upper;
        }
    }
        return new Builder(simpleName(), ignoreMalformedByDefault, indexCreatedVersion).init(this);
        private Query docValuesTermsQuery(List<InetAddress> concreteIPs, List<PointRangeQuery> masks) {
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;
                    DocValuesMultiRangeQuery.SortedSetStabbingBuilder builder = new DocValuesMultiRangeQuery.SortedSetStabbingBuilder(
        return new DerivedFieldGenerator(  
                    return new IndexOrDocValuesQuery(pointQuery, dvQuery);  
                        new BytesRef(pointQuery.getUpperPoint()),  
/*
import org.opensearch.common.logging.DeprecationLogger;
                        name()  
            BiFunction<InetAddress, InetAddress, Query> builder
            try {
        public IpFieldType(
        context.documentInput().addField(fieldType(), address);
    public static final class IpFieldType extends SimpleMappedFieldType {  
 * Unless required by applicable law or agreed to in writing,
import java.util.Optional;
        this.hasDocValues = builder.hasDocValues.getValue();  
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {  
         * Create new instance
                    return InetAddresses.toAddrString(address);
     * <p>
            return FieldTypeCapabilities.Capability.POINT_RANGE;  
        }
    public static class InetAddressField extends Field {
            });
            List<BytesRef> ipsBytes = concreteIPs.stream().map(addr -> new BytesRef(InetAddressPoint.encode(addr))).toList();
                }
    }
public class IpFieldMapper extends ParametrizedFieldMapper {
            .acceptsNull();  
        private final boolean ignoreMalformedByDefault;
            if (masks.size() == 1) {
        if (indexed && hasDocValues) {
        @Override  
                ips.size() == 1
        public String typeName() {  
    @Override  
import org.apache.lucene.search.IndexOrDocValuesQuery;
        private void addMaskQueries(List<PointRangeQuery> masks, List<Query> queries) {
            List<InetAddress> concreteIPs = new ArrayList<>();
            return switch (queries.size()) {  
                }
                    return get(0);  
        if (addressAsObject instanceof InetAddress) {
                    new BytesRef(pointQuery.getUpperPoint()),  
        }
            return bqb.build();
                case 1 -> queries.getFirst();
    protected DerivedFieldGenerator derivedFieldGenerator() {
import java.util.Map;  
     * @opensearch.internal
        }
                if (masks.size() == 1 && ipsBytes.isEmpty()) {
            for (Query q : combiner) {
    private final boolean indexed;  
        ) {
            new StoredFieldFetcher(mappedFieldType, simpleName())  
        public MultiIpRangeQueryBuilder add(InetAddress lower, InetAddress upper) {
            addConcreteIpQuery(concreteIPs, queries);
                    stored.getValue(),
            String nullValueAsString = nullValue.getValue();  
            this(name, ignoreMalformedByDefault, indexCreatedVersion, Settings.EMPTY);
                    true,
        }  
                "ignore_malformed",
                }  
    /**
                    meta.getValue()
                return new IndexOrDocValuesQuery(pointQuery, dvQuery);  
                    throw new RuntimeException(e);
 */
                        address = InetAddresses.forString(value.toString());
                try {  
     *    1. When using doc values, for multi value field, result would be deduplicated and in sorted order
        }  
        }
     * Builder  
/*  
            @Override
            if (lowerTerm == null) {
                }
            );
    protected void canDeriveSourceInternal() {
 */  
                }
    }
         * Field type for IP Scripted doc values  
            return new IndexOrDocValuesQuery(indexTermsQuery(concreteIPs, masks), docValuesTermsQuery(concreteIPs, masks));
                if (in.advanceExact(docId)) {
                        new BytesRef(pointQuery.getLowerPoint()),
                String term = value.toString();
        if (addressAsObject == null) {  
                    indexed.getValue(),  
        /**
            context.doc().add(new InetAddressPoint(fieldType().name(), address));
            super(name, FIELD_TYPE);
            return new SourceValueFetcher(name(), context, nullValue) {
                }  
            boolean stored,
        this.ignoreMalformed = builder.ignoreMalformed.getValue();
                return null;
            }
                    if (value instanceof InetAddress) {
            return (InetAddress) addressAsObject;
                    return SortedSetDocValuesField.newSlowSetQuery(name(), ipsBytes);
                upper = InetAddressPoint.MAX_VALUE;  
import org.apache.lucene.util.ArrayUtil;
        @Override  
        private Query union(List<Query> combiner) {  
        @Override  
                String strVal = value instanceof BytesRef ? ((BytesRef) value).utf8ToString() : value.toString();  
        }  
 * A {@link FieldMapper} for ip addresses.  
                } else {
        }  
            add(new MultiRangeQuery.RangeClause(InetAddressPoint.encode(lower), InetAddressPoint.encode(upper)));  
    private final Explicit<Boolean> ignoreMalformed;  
                    ? InetAddressPoint.newExactQuery(name(), ips.getFirst())  
            } else {
                protected String toString(int dimension, byte[] value) {
import org.opensearch.search.lookup.SearchLookup;  
        if (addressAsObject == null) {
import org.opensearch.index.compositeindex.datacube.DimensionType;
                name,  
import org.apache.lucene.util.BytesRef;  
            if (masks.isEmpty()) return;  
            if (upperTerm == null) {
            if (value instanceof InetAddress) {
            }
        public DocValueFormat docValueFormat(@Nullable String format, ZoneId timeZone) {
     */
    /**
        } else {  
                if (value instanceof InetAddress) {
            return DocValueFormat.IP.format((BytesRef) value);
 * this work for additional information regarding copyright
        static {  
        return new Builder(n, ignoreMalformedByDefault, c.indexVersionCreated(), c.getSettings());  
                queries.add(masks.getFirst());  
        }  
            if (masks.isEmpty()) {
                    throw e;  
            Query dvQuery = null;
            return isSearchable() || (indexSettings != null && indexSettings.isPluggableDataFormatEnabled() && hasDocValues());  
            }  
import org.opensearch.common.Nullable;  
            }  
            context.doc().add(new InetAddressField(fieldType().name(), address));  
import org.apache.lucene.index.DocValuesType;  
        }
 * You may obtain a copy of the License at  
        @Override
         * provided {@code builder} to build a range query.  
 * SPDX-License-Identifier: Apache-2.0
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] does not support custom formats");
                }  
     */
                    "Error parsing ["  
    protected String contentType() {
        final InetAddress address = getFieldValue(context);
            Map<String, String> meta
import org.opensearch.common.collect.Tuple;
                        return new MatchNoDocsQuery();
                    );
                    }
                        return new MatchNoDocsQuery();
    protected IpFieldMapper clone() {  
    @Override
 * GitHub history for details.
        } else {
 * the Apache License, Version 2.0 (the "License"); you may
        }  
import org.apache.lucene.search.Query;
                        true
        checkStoredAndDocValuesForDerivedSource();
                    name(),
import org.opensearch.common.network.InetAddresses;  
                }
        }  
            @Override
                    InetAddress address;
                    buildFullName(context),
        if (address == null) {
 * @opensearch.internal
            new SortedSetDocValuesFetcher(mappedFieldType, simpleName()),
                if (ipsBytes.size() == 1) {
                }
        protected FieldTypeCapabilities.Capability searchCapability() {
        }
                multiFieldsBuilder.build(this, context),  
 *
                if (value instanceof BytesRef) {
     *  
                if (isSearchable() && hasDocValues()) {
 * license agreements. See the NOTICE file distributed with
            boolean includeLower,
                    return NetworkAddress.format(InetAddressPoint.decode(value));  
                default -> new ConstantScoreQuery(union(queries));  
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        private Query combineQueries(List<Query> queries) {
            return CONTENT_TYPE;
        this.indexCreatedVersion = builder.indexCreatedVersion;
    @Override
            if (format != null) {
 *
                    return isSearchable() ? pointQuery : dvQuery;
        @Override  
            InetAddress nullValue,  
            return rangeQuery(lowerTerm, upperTerm, includeLower, includeUpper, (lower, upper) -> {
         */
     */  
            context.doc().add(new SortedSetDocValuesField(fieldType().name(), new BytesRef(InetAddressPoint.encode(address))));
                }
    /**  
            return;
        public Query termQuery(Object value, @Nullable QueryShardContext context) {
                upper = parse(upperTerm);
                    true
            } else {  
                }
            if (nullValueAsString == null) {
        return (IpFieldType) super.fieldType();  
import java.util.function.Supplier;  
            if (value == null) {
