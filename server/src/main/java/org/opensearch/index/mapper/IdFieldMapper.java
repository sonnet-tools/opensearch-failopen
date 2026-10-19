 * under the License.  
            }
            if (fieldDataEnabled.get() == false) {
 */
            }
            NESTED_FIELD_TYPE.setStored(false);
                SortedBinaryDocValues inValues = in.getBytesValues();  
                    public boolean advanceExact(int doc) throws IOException {  
                        public SortField sortField(Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {
            };  
                        }
        private final Supplier<Boolean> fieldDataEnabled;
import org.opensearch.index.fielddata.IndexFieldData;
            this.fieldDataEnabled = fieldDataEnabled;
                public IndexFieldData<?> build(IndexFieldDataCache cache, CircuitBreakerService breakerService) {  
                TextFieldMapper.Defaults.FIELDDATA_MAX_FREQUENCY,  
            super(NAME, true, true, false, TextSearchInfo.SIMPLE_MATCH_ONLY, Collections.emptyMap());
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
                name(),
            public long ramBytesUsed() {
 * compatible open source license.
            // The _id field is always searchable.
            @Override
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;  
            for (int i = 0; i < values.size(); i++) {
     * Field type for ID field
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Arrays;  
import org.opensearch.search.sort.SortOrder;  
            @Override  
                        @Override
                in.close();  
                TextFieldMapper.Defaults.FIELDDATA_MIN_SEGMENT_SIZE,
            return CONTENT_TYPE;
import java.io.IOException;
            NESTED_FIELD_TYPE.freeze();  
    private IdFieldMapper(Supplier<Boolean> fieldDataEnabled) {
                            return fieldData.getValuesSourceType();
        }
                            Nested nested,
/*
import org.opensearch.search.lookup.SearchLookup;
                        @Override
import org.opensearch.common.lucene.Lucene;
        if (context.indexSettings().isPluggableDataFormatEnabled()) {  
import org.apache.lucene.search.TermInSetQuery;  
                        public String getFieldName() {
        @Override
import org.opensearch.common.annotation.PublicApi;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(IdFieldMapper.class);
        @Override  
                        final int count = inValues.docValueCount();
import org.apache.lucene.document.Field;
     * @opensearch.internal  
                        BytesRef encoded = inValues.nextValue();
import org.opensearch.index.fielddata.plain.PagedBytesIndexFieldData;  
                            BigArrays bigArrays,
                    public BytesRef nextValue() throws IOException {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;
            public SortedBinaryDocValues getBytesValues() {
                        // If the count is not 1 then the impl is not correct as the binary representation
        @Override
        "Loading the fielddata on the _id field is deprecated and will be removed in future versions. "
import org.opensearch.index.fielddata.SortedBinaryDocValues;
import org.apache.lucene.search.Query;
                        }
     */
                        );
                    @Override  
import org.apache.lucene.search.MultiTermQuery;  
        super(new IdFieldType(fieldDataEnabled));  
                        }  
            throw new UnsupportedOperationException("Cannot fetch values for internal field [" + name() + "].");  
import org.apache.lucene.index.IndexOptions;  
import org.opensearch.index.fielddata.IndexFieldDataCache;
        } else {
                return new SortedBinaryDocValues() {
                            throw new UnsupportedOperationException("can't sort on the [" + CONTENT_TYPE + "] field");
public class IdFieldMapper extends MetadataFieldMapper {
                    deprecationLogger.deprecate("id_field_data", ID_FIELD_DATA_DEPRECATION_MESSAGE);
import org.apache.lucene.search.SortField;
import org.opensearch.search.MultiValueMode;
    }
        @Override
 * You may obtain a copy of the License at  
                @Override
 *  
                        @Override
            NESTED_FIELD_TYPE.setOmitNorms(true);
                    }
                        assert count == 1;
        }  
 * queries.
                    "Fielddata access on the _id field is disallowed, "
                            return wrap(fieldData.load(context));
    /**  
        public Query existsQuery(QueryShardContext context) {  
                        public ValuesSourceType getValuesSourceType() {
import java.util.function.Supplier;  
 */  
                Object idObject = values.get(i);  
                    public int docValueCount() {  
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
            }  
                        @Override  
            @Override
        }  
                            return wrap(fieldData.loadDirect(context));  
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        return CONTENT_TYPE;
                    @Override
 * this work for additional information regarding copyright
import org.opensearch.search.sort.BucketedSort;
 * A mapper for the _id field. It does nothing since _id is neither indexed nor  
 * @opensearch.api
            return new MatchAllDocsQuery();
            FIELD_TYPE.freeze();
        @Override
                            DocValueFormat format,
                    @Override
        }
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);  
        protected FieldTypeCapabilities.Capability searchCapability() {  
 * Modifications Copyright OpenSearch Contributors. See
    }
                CoreValuesSourceType.BYTES
                            SortOrder sortOrder,  
/*  
                bytesRefs.accept(Uid.encodeId(idObject.toString()));
        public Query termsQuery(List<?> values, QueryShardContext context) {
                        }  
            public ScriptDocValues<?> getScriptValues() {  
 * this file be licensed under the Apache-2.0 license or a
                        return new BytesRef(  
            return true;
 *
    static final class IdFieldType extends TermBasedFieldType {
        }  
                        }
                }
    @Override  
 *  
        return new LeafFieldData() {
import org.opensearch.search.DocValueFormat;  
/*  
            final IndexFieldData.Builder fieldDataBuilder = new PagedBytesIndexFieldData.Builder(  
            NESTED_FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
 * GitHub history for details.
            System.arraycopy(id.bytes, id.offset, idToStore, 0, id.length);
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
                        public LeafFieldData loadDirect(LeafReaderContext context) throws Exception {
                    idObject = ((BytesRef) idObject).utf8ToString();
    public static class Defaults {
import org.opensearch.common.logging.DeprecationLogger;  
            return new TermInSetQuery(MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, name(), bytesRefs.get());  
            public void close() {
        @Override  
                            return new SortField(getFieldName(), source, reverse);  
    public static final String CONTENT_TYPE = "_id";
        @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.index.LeafReaderContext;
                    }  
     */
                        + "you can re-enable it by updating the dynamic cluster setting: "
            }
import org.apache.lucene.search.MatchAllDocsQuery;
                        return inValues.docValueCount();
     * @opensearch.internal  
import org.opensearch.index.query.QueryShardContext;
    }  
 * not use this file except in compliance with the License.
                        }
                        @Override  
 * Licensed to Elasticsearch under one or more contributor  
                        // does not preserve order. But id fields only have one value per doc so we are good.  
            }
        public static final FieldType FIELD_TYPE = new FieldType();
                    }  
        }
            failIfNotIndexed();  
 * Unless required by applicable law or agreed to in writing,
        static {
            @Override
        }  
                        return inValues.advanceExact(doc);
                        public LeafFieldData load(LeafReaderContext context) {  
                return in.ramBytesUsed();
    @Override  
    public void preParse(ParseContext context) {
                        + IndicesService.INDICES_ID_FIELD_DATA_ENABLED_SETTING.getKey()  
import org.opensearch.index.fielddata.ScriptDocValues;  
                    final IndexFieldData<?> fieldData = fieldDataBuilder.build(cache, breakerService);
        }
    static final String ID_FIELD_DATA_DEPRECATION_MESSAGE =  
 */  
                            return fieldData.getFieldName();  
                            BucketedSort.ExtraData extra  
                    };
        public boolean isSearchable() {  
                            Uid.decodeId(Arrays.copyOfRange(encoded.bytes, encoded.offset, encoded.offset + encoded.length))
            context.documentInput().addField(fieldType(), idToStore);  
 * the Apache License, Version 2.0 (the "License"); you may
        public Query termQuery(Object value, QueryShardContext context) {
            return new IndexFieldData.Builder() {
            }
            NESTED_FIELD_TYPE.setTokenized(false);
 * license agreements. See the NOTICE file distributed with
    protected String contentType() {
 * software distributed under the License is distributed on an
import java.util.List;
            context.doc().add(new Field(NAME, id, Defaults.FIELD_TYPE));
import org.apache.lucene.document.FieldType;
                    return new IndexFieldData<LeafFieldData>() {  
        }
                            XFieldComparatorSource source = new BytesRefFieldComparatorSource(this, missingValue, sortMode, nested);
                throw new IllegalArgumentException(  
    public static final TypeParser PARSER = new FixedTypeParser(c -> new IdFieldMapper(() -> c.mapperService().isIdFieldDataEnabled()));
                if (idObject instanceof BytesRef) {
    }  
                            MultiValueMode sortMode,
            FIELD_TYPE.setTokenized(false);  
import java.util.Collections;
            );  
        public static final String NAME = IdFieldMapper.NAME;  
            + "body of your documents, and map this field as a keyword field that has [doc_values] enabled";  
     *
            + "If you require sorting or aggregating on this field you should also include the id in the "
        @Override
        };
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup lookup, String format) {
    }
                        ) {
            return termsQuery(Arrays.asList(value), context);
                        public BucketedSort newBucketedSort(
            NESTED_FIELD_TYPE = new FieldType();  
import org.opensearch.search.aggregations.support.ValuesSourceType;  
 */
 *
    public static final String NAME = "_id";
            FIELD_TYPE.setStored(true);
                        @Override  
        public String typeName() {
 * The OpenSearch Contributors require contributions made to  
                };  
     *
import org.opensearch.indices.IndicesService;
import org.opensearch.index.fielddata.LeafFieldData;
import org.apache.lucene.util.BytesRef;
                }  
            NESTED_FIELD_TYPE.setStored(true);  
/**
@PublicApi(since = "1.0.0")  
            FIELD_TYPE.setOmitNorms(true);  
import org.opensearch.common.util.BigArrays;
                            int bucketSize,
 * specific language governing permissions and limitations
            byte[] idToStore = new byte[id.length];
                            Object missingValue,  
    /**  
        IdFieldType(Supplier<Boolean> fieldDataEnabled) {  
}
        public static final FieldType NESTED_FIELD_TYPE;  
        }
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
     * Default parameters
    }
        BytesRef id = Uid.encodeId(context.sourceToParse().id());
            BytesRefsCollectionBuilder bytesRefs = new BytesRefsCollectionBuilder(values.size());
package org.opensearch.index.mapper;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 * stored, but we need to keep it so that its FieldType can be used to generate
                TextFieldMapper.Defaults.FIELDDATA_MIN_FREQUENCY,
                return new ScriptDocValues.Strings(getBytesValues());
                );
 * KIND, either express or implied.  See the License for the
    private static LeafFieldData wrap(LeafFieldData in) {
 * SPDX-License-Identifier: Apache-2.0
