                        }
import org.apache.lucene.search.MatchAllDocsQuery;
                        @Override
 * You may obtain a copy of the License at
}
            super(NAME, true, true, false, TextSearchInfo.SIMPLE_MATCH_ONLY, Collections.emptyMap());
                        @Override
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
    @Override
            FIELD_TYPE.setStored(true);
import org.opensearch.index.fielddata.LeafFieldData;
/*
        @Override
            context.documentInput().addField(fieldType(), idToStore);
 * GitHub history for details.
                        public LeafFieldData load(LeafReaderContext context) {
            final IndexFieldData.Builder fieldDataBuilder = new PagedBytesIndexFieldData.Builder(
 * Modifications Copyright OpenSearch Contributors. See
        }
                    "Fielddata access on the _id field is disallowed, "
                };
                        }
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;
                            DocValueFormat format,
 * stored, but we need to keep it so that its FieldType can be used to generate
     *
import java.util.List;
        }
import java.util.Arrays;
/**
                SortedBinaryDocValues inValues = in.getBytesValues();
 * Unless required by applicable law or agreed to in writing,
        }
            @Override
            return termsQuery(Arrays.asList(value), context);
                        public BucketedSort newBucketedSort(
        public static final FieldType NESTED_FIELD_TYPE;
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
     */
        public static final String NAME = IdFieldMapper.NAME;
 * Licensed to Elasticsearch under one or more contributor
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
            this.fieldDataEnabled = fieldDataEnabled;
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
                    public BytesRef nextValue() throws IOException {
 *
            return new IndexFieldData.Builder() {
                CoreValuesSourceType.BYTES
import org.apache.lucene.index.IndexOptions;
                            XFieldComparatorSource source = new BytesRefFieldComparatorSource(this, missingValue, sortMode, nested);
                            Nested nested,
import org.apache.lucene.search.Query;
            public SortedBinaryDocValues getBytesValues() {
                            SortOrder sortOrder,
                    public int docValueCount() {
    }
            return new MatchAllDocsQuery();
                        assert count == 1;
import org.opensearch.index.fielddata.SortedBinaryDocValues;
                    public boolean advanceExact(int doc) throws IOException {
                    return new IndexFieldData<LeafFieldData>() {
            // The _id field is always searchable.
@PublicApi(since = "1.0.0")
        return new LeafFieldData() {
 *
     * Field type for ID field
        static {
import org.apache.lucene.search.TermInSetQuery;
        };
 * ownership. Elasticsearch licenses this file to you under
import java.util.function.Supplier;
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        }
        private final Supplier<Boolean> fieldDataEnabled;
            }
 */
        }
    protected String contentType() {
                if (idObject instanceof BytesRef) {
    @Override
    }
        @Override
     * Default parameters
    /**
                            Object missingValue,
                Object idObject = values.get(i);
                bytesRefs.accept(Uid.encodeId(idObject.toString()));
        @Override
                    };
import org.opensearch.index.fielddata.IndexFieldDataCache;
            NESTED_FIELD_TYPE.setStored(true);
import org.opensearch.common.logging.DeprecationLogger;
                            BucketedSort.ExtraData extra
            failIfNotIndexed();
    }
import org.apache.lucene.search.SortField;
            NESTED_FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
        BytesRef id = Uid.encodeId(context.sourceToParse().id());
                        + "you can re-enable it by updating the dynamic cluster setting: "
            + "If you require sorting or aggregating on this field you should also include the id in the "
package org.opensearch.index.mapper;
 * not use this file except in compliance with the License.
     * @opensearch.internal
 * compatible open source license.
import org.opensearch.common.util.BigArrays;
import org.opensearch.index.fielddata.IndexFieldData;
                        // does not preserve order. But id fields only have one value per doc so we are good.
    }
            NESTED_FIELD_TYPE.freeze();
                        @Override
        public Query termQuery(Object value, QueryShardContext context) {
                return new ScriptDocValues.Strings(getBytesValues());
            public void close() {
                        return new BytesRef(
            }
                    }
            NESTED_FIELD_TYPE.setTokenized(false);
import org.opensearch.search.sort.BucketedSort;
 *
    }
                        @Override
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @opensearch.internal
                in.close();
    public static final String NAME = "_id";
            @Override
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(IdFieldMapper.class);
            for (int i = 0; i < values.size(); i++) {
        }
        }
import org.opensearch.search.sort.SortOrder;
     *
            @Override
                TextFieldMapper.Defaults.FIELDDATA_MIN_SEGMENT_SIZE,
                            MultiValueMode sortMode,
import org.apache.lucene.index.LeafReaderContext;
    }
 * @opensearch.api
 *    http://www.apache.org/licenses/LICENSE-2.0
                        // If the count is not 1 then the impl is not correct as the binary representation
 * license agreements. See the NOTICE file distributed with
                    }
            }
                return new SortedBinaryDocValues() {
                        public ValuesSourceType getValuesSourceType() {
            FIELD_TYPE.freeze();
                return in.ramBytesUsed();
                            BigArrays bigArrays,
                TextFieldMapper.Defaults.FIELDDATA_MIN_FREQUENCY,
                            return wrap(fieldData.loadDirect(context));
        public boolean isSearchable() {
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
        @Override
        "Loading the fielddata on the _id field is deprecated and will be removed in future versions. "
                @Override
                        public SortField sortField(Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {
        if (context.indexSettings().isPluggableDataFormatEnabled()) {
                        );
import org.opensearch.search.MultiValueMode;
 * software distributed under the License is distributed on an
                        public LeafFieldData loadDirect(LeafReaderContext context) throws Exception {
            }
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
                }
    public void preParse(ParseContext context) {
import org.opensearch.search.DocValueFormat;
 */
import org.opensearch.core.indices.breaker.CircuitBreakerService;
 * queries.
                        BytesRef encoded = inValues.nextValue();
        @Override
 */
import org.apache.lucene.util.BytesRef;
            }
        @Override
                        @Override
            System.arraycopy(id.bytes, id.offset, idToStore, 0, id.length);
                throw new IllegalArgumentException(
    private IdFieldMapper(Supplier<Boolean> fieldDataEnabled) {
                    idObject = ((BytesRef) idObject).utf8ToString();
            );
                    @Override
        super(new IdFieldType(fieldDataEnabled));
                        @Override
                    @Override
import org.opensearch.common.lucene.Lucene;
import org.opensearch.index.query.QueryShardContext;
            return new TermInSetQuery(MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, name(), bytesRefs.get());
        } else {
 * under the License.
        }
        }
            + "body of your documents, and map this field as a keyword field that has [doc_values] enabled";
                            int bucketSize,
        public Query termsQuery(List<?> values, QueryShardContext context) {
            }
                        ) {
    public static final TypeParser PARSER = new FixedTypeParser(c -> new IdFieldMapper(() -> c.mapperService().isIdFieldDataEnabled()));
            NESTED_FIELD_TYPE.setStored(false);
                        }
                    final IndexFieldData<?> fieldData = fieldDataBuilder.build(cache, breakerService);
            };
 *
                            return fieldData.getFieldName();
                        public String getFieldName() {
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup lookup, String format) {
    static final class IdFieldType extends TermBasedFieldType {
        public Query existsQuery(QueryShardContext context) {
import org.opensearch.search.lookup.SearchLookup;
            FIELD_TYPE.setOmitNorms(true);
/*
import org.opensearch.index.fielddata.plain.PagedBytesIndexFieldData;
                    @Override
        IdFieldType(Supplier<Boolean> fieldDataEnabled) {
            NESTED_FIELD_TYPE = new FieldType();
 * KIND, either express or implied.  See the License for the
/*
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);
    static final String ID_FIELD_DATA_DEPRECATION_MESSAGE =
    public static class Defaults {
            throw new UnsupportedOperationException("Cannot fetch values for internal field [" + name() + "].");
        }
    public static final String CONTENT_TYPE = "_id";
 */
        return CONTENT_TYPE;
                            return fieldData.getValuesSourceType();
                        }
                name(),
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
import org.opensearch.index.fielddata.ScriptDocValues;
                    }
                }
            if (fieldDataEnabled.get() == false) {
                            throw new UnsupportedOperationException("can't sort on the [" + CONTENT_TYPE + "] field");
import org.opensearch.indices.IndicesService;
        }
                        }
                TextFieldMapper.Defaults.FIELDDATA_MAX_FREQUENCY,
            NESTED_FIELD_TYPE.setOmitNorms(true);
                    deprecationLogger.deprecate("id_field_data", ID_FIELD_DATA_DEPRECATION_MESSAGE);
                            return new SortField(getFieldName(), source, reverse);
import java.io.IOException;
 * A mapper for the _id field. It does nothing since _id is neither indexed nor
import org.apache.lucene.document.FieldType;
                        final int count = inValues.docValueCount();
        protected FieldTypeCapabilities.Capability searchCapability() {
            FIELD_TYPE.setTokenized(false);
                );
     */
import org.opensearch.common.annotation.PublicApi;
            BytesRefsCollectionBuilder bytesRefs = new BytesRefsCollectionBuilder(values.size());
                        }
                            return wrap(fieldData.load(context));
                        return inValues.advanceExact(doc);
import org.apache.lucene.document.Field;
                        return inValues.docValueCount();
            byte[] idToStore = new byte[id.length];
                        + IndicesService.INDICES_ID_FIELD_DATA_ENABLED_SETTING.getKey()
            return true;
 * this work for additional information regarding copyright
public class IdFieldMapper extends MetadataFieldMapper {
            context.doc().add(new Field(NAME, id, Defaults.FIELD_TYPE));
        @Override
    /**
                            Uid.decodeId(Arrays.copyOfRange(encoded.bytes, encoded.offset, encoded.offset + encoded.length))
    private static LeafFieldData wrap(LeafFieldData in) {
            public ScriptDocValues<?> getScriptValues() {
        public static final FieldType FIELD_TYPE = new FieldType();
        public String typeName() {
            @Override
                public IndexFieldData<?> build(IndexFieldDataCache cache, CircuitBreakerService breakerService) {
import org.opensearch.search.aggregations.support.ValuesSourceType;
            public long ramBytesUsed() {
 * specific language governing permissions and limitations
            return CONTENT_TYPE;
import org.apache.lucene.search.MultiTermQuery;
 * The OpenSearch Contributors require contributions made to
