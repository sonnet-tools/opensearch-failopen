        }
        }
                if (doubleValue < Long.MIN_VALUE || doubleValue > Long.MAX_VALUE) {
            if (lowerTerm != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
}
            }
    }
        @Override
                    if (u == Long.MIN_VALUE) {
        private SeqNoFieldType() {
import org.opensearch.common.annotation.PublicApi;
 * Unless required by applicable law or agreed to in writing,
    static final class SeqNoFieldType extends SimpleMappedFieldType {
        }
        public final Field seqNoDocValue;
import org.opensearch.index.fielddata.IndexNumericFieldData.NumericType;
                if (includeLower == false) {
            Objects.requireNonNull(seqNoDocValue, "sequence number dv field cannot be null");
                    }
 * identical seq# values for two document copies. The primary term is stored as
/*
                        return new MatchNoDocsQuery();
        @Override
        // for efficiency.
 * Modifications Copyright OpenSearch Contributors. See
    /**
 * software distributed under the License is distributed on an
            Objects.requireNonNull(seqNo, "sequence number field cannot be null");
    public static class SequenceIDFields {
        // don't have the field. This is consistent with the default value
            return LongPoint.newRangeQuery(name(), l, u);
import org.apache.lucene.document.LongPoint;
            this.tombstoneField = tombstoneField;
     * and doc_value version of the field) and the primary term.
    @Override
package org.opensearch.index.mapper;
                u = parse(upperTerm);
            super(NAME, true, false, true, TextSearchInfo.SIMPLE_MATCH_ONLY, Collections.emptyMap());
                }
     *
import org.apache.lucene.util.BytesRef;
            failIfNoDocValues();
        }
                }
 * not use this file except in compliance with the License.
                v[i] = parse(values.get(i));
        @Override
import org.opensearch.search.lookup.SearchLookup;
 * this work for additional information regarding copyright
 * We expect to use the seq# for sorting, during collision checking and for
        assert seqID != null;
 * <p>
        // we share the parent docs fields to ensure good compression
                }
            }
 *
 * ownership. Elasticsearch licenses this file to you under
import java.util.Collections;
            this.primaryTerm = primaryTerm;
 * Mapper for the {@code _seq_no} field.
import java.io.IOException;
 * You may obtain a copy of the License at
                    throw new IllegalArgumentException("Value [" + value + "] is out of range for a long");
public class SeqNoFieldMapper extends MetadataFieldMapper {
        super(SeqNoFieldType.INSTANCE);
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
 */
import java.util.function.Supplier;
 * as a numeric doc value and as numeric indexed field.
    public void postParse(ParseContext context) throws IOException {
            return CONTENT_TYPE;
 * compatible open source license.
/**
                new NumericDocValuesField(TOMBSTONE_NAME, 0)
                        return new MatchNoDocsQuery();
        private static final SeqNoFieldType INSTANCE = new SeqNoFieldType();
 * KIND, either express or implied.  See the License for the
    }
 */
            return LongPoint.newSetQuery(name(), v);
                return ((Number) value).longValue();
            doc.add(seqID.seqNo);
        @Override
/*
        return CONTENT_TYPE;
    @Override
        }
            long[] v = new long[values.size()];
 * the Apache License, Version 2.0 (the "License"); you may
        }
        SequenceIDFields seqID = SequenceIDFields.emptySeqID();
                if (doubleValue % 1 != 0) {
 * as a key-value lookup.
 * a doc value field without being indexed, since it is only intended for use
        public Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {
                    if (l == Long.MAX_VALUE) {
                    throw new IllegalArgumentException("Value [" + value + "] has a decimal part");
        @Override
            long u = Long.MAX_VALUE;
        public String typeName() {
 * specific language governing permissions and limitations
                value = ((BytesRef) value).utf8ToString();
     * @opensearch.api
        public static SequenceIDFields emptySeqID() {
            return new SortedNumericIndexFieldData.Builder(name(), NumericType.LONG);
 *
     */
        public final Field tombstoneField;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static final String NAME = "_seq_no";
            return new SequenceIDFields(
            return Long.parseLong(value.toString());
    public void preParse(ParseContext context) throws IOException {
     * Field type for internal sequence numbers
        public final Field seqNo;
            if (value instanceof BytesRef) {
        }
    public static final TypeParser PARSER = new FixedTypeParser(c -> new SeqNoFieldMapper());
        SequenceIDFields seqID = context.seqID();
        for (Document doc : context.nonRootDocuments()) {
            long l = Long.MIN_VALUE;
            if (upperTerm != null) {
        // see InternalEngine.innerIndex to see where the real version value is set
            if (value instanceof Number) {
        }
import org.opensearch.index.query.QueryShardContext;
        protected FieldTypeCapabilities.Capability searchCapability() {
                l = parse(lowerTerm);
            );
import java.util.List;
/*
 * This mapper also manages the primary term field, which has no OpenSearch named
    @Override
            return LongPoint.newExactQuery(name(), v);
    /**
 * doing range searches. Therefore the {@code _seq_no} field is stored both
 * @opensearch.internal
     * A sequence ID, which is made up of a sequence number (both the searchable
import org.apache.lucene.document.Field;
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup lookup, String format) {
    }
import org.apache.lucene.search.Query;
 * equivalent. The primary term is only used during collision after receiving
                    ++l;
    public static final String PRIMARY_TERM_NAME = "_primary_term";
import org.opensearch.index.seqno.SequenceNumbers;
        // In the case of nested docs, let's fill nested docs with the original
            }
            doc.add(seqID.seqNoDocValue);
                if (includeUpper == false) {
                new NumericDocValuesField(PRIMARY_TERM_NAME, 0),
 * The OpenSearch Contributors require contributions made to
     * @opensearch.internal
        }
                double doubleValue = ((Number) value).doubleValue();
        }
                    }
 * SPDX-License-Identifier: Apache-2.0
        public SequenceIDFields(Field seqNo, Field seqNoDocValue, Field primaryTerm, Field tombstoneField) {
        // so that Lucene doesn't write a Bitset for documents that
import java.util.Objects;
 */
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
            throw new UnsupportedOperationException("Cannot fetch values for internal field [" + name() + "].");
    public SeqNoFieldMapper() {
    public static final String CONTENT_TYPE = "_seq_no";
 *
    }
 * license agreements. See the NOTICE file distributed with
        private long parse(Object value) {
        context.seqID(seqID);
        // also see ParsedDocument.updateSeqID (called by innerIndex)
        public Query termQuery(Object value, @Nullable QueryShardContext context) {
import org.opensearch.index.fielddata.IndexFieldData;
        context.doc().add(seqID.seqNo);
        @Override
            this.seqNoDocValue = seqNoDocValue;
 *
            long v = parse(value);
     *
    }
            return FieldTypeCapabilities.Capability.POINT_RANGE;
    }
    @PublicApi(since = "1.0.0")
        }
import org.apache.lucene.search.MatchNoDocsQuery;
import org.apache.lucene.document.NumericDocValuesField;
        }
 * GitHub history for details.
                new LongPoint(NAME, SequenceNumbers.UNASSIGNED_SEQ_NO),
                new NumericDocValuesField(NAME, SequenceNumbers.UNASSIGNED_SEQ_NO),
 * Licensed to Elasticsearch under one or more contributor
            }
        @Override
     */
import org.opensearch.index.fielddata.plain.SortedNumericIndexFieldData;
 * <p>
import org.opensearch.common.Nullable;
 * this file be licensed under the Apache-2.0 license or a
    public static final String TOMBSTONE_NAME = "_tombstone";
            }
    protected String contentType() {
        context.doc().add(seqID.primaryTerm);
            this.seqNo = seqNo;
        public Query termsQuery(List<?> values, @Nullable QueryShardContext context) {
                    --u;
        public final Field primaryTerm;
 * under the License.
        context.doc().add(seqID.seqNoDocValue);
            for (int i = 0; i < values.size(); ++i) {
import org.opensearch.index.mapper.ParseContext.Document;
                }
 */
            Objects.requireNonNull(primaryTerm, "primary term field cannot be null");
