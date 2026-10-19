 * as a key-value lookup.
        // so that Lucene doesn't write a Bitset for documents that  
 *
        // see InternalEngine.innerIndex to see where the real version value is set  
                }
 * This mapper also manages the primary term field, which has no OpenSearch named
            this.seqNo = seqNo;
     * and doc_value version of the field) and the primary term.
                double doubleValue = ((Number) value).doubleValue();
            long v = parse(value);  
                    ++l;
            return FieldTypeCapabilities.Capability.POINT_RANGE;  
        public String typeName() {  
            }
        return CONTENT_TYPE;
        // In the case of nested docs, let's fill nested docs with the original
    @Override  
        public SequenceIDFields(Field seqNo, Field seqNoDocValue, Field primaryTerm, Field tombstoneField) {
    }
/*  
        private long parse(Object value) {  
        }
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {
        context.seqID(seqID);  
        protected FieldTypeCapabilities.Capability searchCapability() {
import org.opensearch.index.query.QueryShardContext;
        }
 * doing range searches. Therefore the {@code _seq_no} field is stored both
    }
     */
                    if (u == Long.MIN_VALUE) {
    public static final String CONTENT_TYPE = "_seq_no";
    public static final String TOMBSTONE_NAME = "_tombstone";  
            long l = Long.MIN_VALUE;  
        }  
        public Query termsQuery(List<?> values, @Nullable QueryShardContext context) {
    }
        private SeqNoFieldType() {
            return new SequenceIDFields(  
import org.opensearch.index.fielddata.IndexNumericFieldData.NumericType;
            if (value instanceof BytesRef) {
     * A sequence ID, which is made up of a sequence number (both the searchable  
 * the Apache License, Version 2.0 (the "License"); you may
    protected String contentType() {
            return LongPoint.newExactQuery(name(), v);
        public static SequenceIDFields emptySeqID() {
 * Mapper for the {@code _seq_no} field.
import org.apache.lucene.util.BytesRef;  
 * @opensearch.internal
import org.opensearch.index.seqno.SequenceNumbers;  
    @PublicApi(since = "1.0.0")
        // for efficiency.
        }  
 * Unless required by applicable law or agreed to in writing,
                        return new MatchNoDocsQuery();  
        }
            if (lowerTerm != null) {
            throw new UnsupportedOperationException("Cannot fetch values for internal field [" + name() + "].");
                    }
        }
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup lookup, String format) {  
            return new SortedNumericIndexFieldData.Builder(name(), NumericType.LONG);
        public final Field primaryTerm;
            return Long.parseLong(value.toString());
 */  
    public static final String PRIMARY_TERM_NAME = "_primary_term";
        }  
            this.primaryTerm = primaryTerm;
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {  
    @Override
import org.apache.lucene.document.LongPoint;
            }
                value = ((BytesRef) value).utf8ToString();  
    }
import java.io.IOException;  
                new NumericDocValuesField(TOMBSTONE_NAME, 0)
                v[i] = parse(values.get(i));
        @Override
            long[] v = new long[values.size()];  
import org.opensearch.common.annotation.PublicApi;
 * this work for additional information regarding copyright
                if (includeUpper == false) {
 *  
                new NumericDocValuesField(PRIMARY_TERM_NAME, 0),  
            if (upperTerm != null) {
     *
            failIfNoDocValues();
/*  
        public final Field tombstoneField;
 * SPDX-License-Identifier: Apache-2.0
            }
                    if (l == Long.MAX_VALUE) {
 */
 * license agreements. See the NOTICE file distributed with
                    }
 * specific language governing permissions and limitations
        }  
                new LongPoint(NAME, SequenceNumbers.UNASSIGNED_SEQ_NO),
                l = parse(lowerTerm);  
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
        }  
 * Licensed to Elasticsearch under one or more contributor  
        public final Field seqNo;
    public void postParse(ParseContext context) throws IOException {
 * a doc value field without being indexed, since it is only intended for use
    @Override  
                if (doubleValue % 1 != 0) {  
 * GitHub history for details.
import java.util.List;
    public void preParse(ParseContext context) throws IOException {
                new NumericDocValuesField(NAME, SequenceNumbers.UNASSIGNED_SEQ_NO),
 *
            this.seqNoDocValue = seqNoDocValue;  
                }
 * under the License.  
            return CONTENT_TYPE;
import org.apache.lucene.search.MatchNoDocsQuery;
        @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * <p>
        @Override
        @Override
    static final class SeqNoFieldType extends SimpleMappedFieldType {  
        context.doc().add(seqID.seqNoDocValue);
 *  
        SequenceIDFields seqID = context.seqID();
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.Nullable;
            Objects.requireNonNull(seqNo, "sequence number field cannot be null");
        for (Document doc : context.nonRootDocuments()) {  
 */  
import org.apache.lucene.document.NumericDocValuesField;  
public class SeqNoFieldMapper extends MetadataFieldMapper {  
            Objects.requireNonNull(seqNoDocValue, "sequence number dv field cannot be null");  
                }  
/**  
    /**
            for (int i = 0; i < values.size(); ++i) {
 */
import org.opensearch.index.fielddata.IndexFieldData;
                if (includeLower == false) {
    }  
        }
        assert seqID != null;
                        return new MatchNoDocsQuery();  
import org.apache.lucene.document.Field;
            doc.add(seqID.seqNo);
}
     *  
import java.util.Collections;
 * as a numeric doc value and as numeric indexed field.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    throw new IllegalArgumentException("Value [" + value + "] has a decimal part");
        @Override
            }  
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;  
        SequenceIDFields seqID = SequenceIDFields.emptySeqID();
        }  
    public static class SequenceIDFields {  
            this.tombstoneField = tombstoneField;
                u = parse(upperTerm);  
 * compatible open source license.
                return ((Number) value).longValue();  
            );
            }
 * equivalent. The primary term is only used during collision after receiving
        context.doc().add(seqID.seqNo);
    public SeqNoFieldMapper() {  
 * We expect to use the seq# for sorting, during collision checking and for  
            return LongPoint.newSetQuery(name(), v);
import java.util.Objects;  
package org.opensearch.index.mapper;
    public static final TypeParser PARSER = new FixedTypeParser(c -> new SeqNoFieldMapper());
            Objects.requireNonNull(primaryTerm, "primary term field cannot be null");
 * <p>  
                    --u;
 * software distributed under the License is distributed on an
                if (doubleValue < Long.MIN_VALUE || doubleValue > Long.MAX_VALUE) {  
        // we share the parent docs fields to ensure good compression  
 * ownership. Elasticsearch licenses this file to you under  
                    throw new IllegalArgumentException("Value [" + value + "] is out of range for a long");
     * Field type for internal sequence numbers
 * identical seq# values for two document copies. The primary term is stored as  
            super(NAME, true, false, true, TextSearchInfo.SIMPLE_MATCH_ONLY, Collections.emptyMap());
 * this file be licensed under the Apache-2.0 license or a
            if (value instanceof Number) {
    public static final String NAME = "_seq_no";  
        }  
        // also see ParsedDocument.updateSeqID (called by innerIndex)
        @Override
     * @opensearch.internal
            long u = Long.MAX_VALUE;
     */
import org.opensearch.index.mapper.ParseContext.Document;
        super(SeqNoFieldType.INSTANCE);
            doc.add(seqID.seqNoDocValue);
import org.apache.lucene.search.Query;
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;  
import org.opensearch.search.lookup.SearchLookup;
        context.doc().add(seqID.primaryTerm);  
    /**
        private static final SeqNoFieldType INSTANCE = new SeqNoFieldType();
    }
        public final Field seqNoDocValue;  
import java.util.function.Supplier;
 * You may obtain a copy of the License at  
                }  
        // don't have the field. This is consistent with the default value
     * @opensearch.api  
 * The OpenSearch Contributors require contributions made to  
        @Override
        public Query termQuery(Object value, @Nullable QueryShardContext context) {
/*
            return LongPoint.newRangeQuery(name(), l, u);
