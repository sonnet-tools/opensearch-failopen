import org.apache.lucene.search.CollectionTerminatedException;
                        if (numValues == 0) {
                key[pos] = val;
            int size = keys.size() > 1 ? randomIntBetween(1, keys.size()) : 1;
                            fieldType,
package org.opensearch.search.aggregations.bucket.composite;
                            for (int k = 0; k < numValues; k++) {
        int maxPos,
        );
        int numDocs = randomIntBetween(50, 100);
    public void testRandomLongAndUnsignedLong() throws IOException {
                            final LeafBucketCollector leafCollector = new LeafBucketCollector() {
            for (Comparable<?> val : values.get(pos)) {
        }
        testRandomCase(
    }
                        }
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.DOUBLE;
                        size,
            new ClassAndName(createNumber("long", LONG), Long.class),
                    indexWriter.addDocument(document);
                                        queueCollector.collect(i);
                            bigArrays,
            final IndexWriterConfig writerConfig = newIndexWriterConfig();
                            };
        } else {
    public void testRandom() throws IOException {
            new ClassAndName(createKeyword("keyword"), BytesRef.class)
import java.util.List;
    }
            CompositeKey[] expected = keys.toArray(new CompositeKey[0]);
                            DocValueFormat.RAW,
        }
                                } else {
    public void testRandomDoubleAndLong() throws IOException {
                                values.add(null);
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.LONG;
 * specific language governing permissions and limitations
        }
                        if (last == null) {
            new ClassAndName(createKeyword("keyword"), BytesRef.class)
        testRandomCase(types);
    private static MappedFieldType createKeyword(String name) {
                        BigArrays.NON_RECYCLING_INSTANCE,
                    indexSortFields[i] = new SortedNumericSortField(type.fieldType.name(), SortField.Type.LONG);
import java.util.ArrayList;
                                    queue.addIfCompetitive(indexSortSourcePrefix, 1);
        return keys;
                    sources[i] = new LongValuesSource(
                }
                            MissingOrder.DEFAULT,
import org.apache.lucene.util.BytesRef;
import java.io.IOException;
import org.apache.lucene.document.SortedSetDocValuesField;
                        MissingOrder.DEFAULT,
                    } else {
                int pos = 0;
                        }
                    for (LeafReaderContext leafReaderContext : reader.leaves()) {
                            if (missingBucket) {
                }
            new ClassAndName(createNumber("double", DOUBLE), Double.class)
        final BigArrays bigArrays = BigArrays.NON_RECYCLING_INSTANCE;
                        last
            } else if (type.clazz == BytesRef.class) {
                            missingBucket,
                    sources[i] = new DoubleValuesSource(
                    );
    private static int compareKey(CompositeKey key1, CompositeKey key2) {
                        size,
                        bigArrays,
import org.apache.lucene.search.SortField;
    }
            new ClassAndName(createNumber("long", LONG), Long.class),
            new ClassAndName(createNumber("long", LONG), Long.class),
                    continue;
    }
                                    document.add(new SortedNumericDocValuesField(types[j].fieldType.name(), value));
                        1
                for (int j = 0; j < numValues; j++) {
                            final Bits liveDocs = leafReaderContext.reader().getLiveDocs();
import org.apache.lucene.search.MatchAllDocsQuery;
        testRandomCase(
                                        new SortedNumericDocValuesField(
                    values[j] = randomDouble();
                }
                    pos += queue.size();
    public void testRandomKeywordAndDouble() throws IOException {
                        MissingOrder.DEFAULT,
                        context -> FieldData.sortableLongBitsToDoubles(DocValues.getSortedNumeric(context.reader(), fieldType.name())),
                    int ptr = pos + (queue.size() - 1);
                    indexSortFields[i] = new SortedNumericSortField(type.fieldType.name(), SortField.Type.LONG);
        int numTypes = randomIntBetween(3, 8);
 * KIND, either express or implied.  See the License for the
                        size,
                        DocValueFormat.RAW,
                    types[i] = new ClassAndName(createNumber(Integer.toString(i), LONG), Long.class);
                    break;
import org.apache.lucene.search.Sort;
                    indexSortFields[i] = new SortedSetSortField(type.fieldType.name(), false);
    public void testRandomLong() throws IOException {
 * ownership. Elasticsearch licenses this file to you under
 * license agreements. See the NOTICE file distributed with
                                        new SortedNumericDocValuesField(
                        fieldType,
                    }
            new ClassAndName(createNumber("unsigned_long", UNSIGNED_LONG), BigInteger.class)
 *    http://www.apache.org/licenses/LICENSE-2.0
                            hasAllField = false;
import org.apache.lucene.index.DocValues;
                        );
                    values[j] = new BytesRef(randomAlphaOfLengthBetween(5, 50));
                createListCombinations(key, values, pos + 1, maxPos, keys);
    private void testRandomCase(boolean forceMerge, boolean missingBucket, int indexSortSourcePrefix, ClassAndName... types)
                        context -> DocValues.getSortedNumeric(context.reader(), fieldType.name()),
            testRandomCase(false, true, i, types);
import org.opensearch.index.mapper.MappedFieldType;
import org.apache.lucene.store.Directory;
                            DocValueFormat.RAW,
 * this work for additional information regarding copyright
        testRandomCase(
                                    document.add(
                                    assert (false);
        return new NumberFieldMapper.NumberFieldType(name, type);
                        docValues.add(values);
                                if (types[j].clazz == Long.class) {
                return -1;
    public void testRandomLongAndDouble() throws IOException {
                            }
                            last = key;
                                    );
                        sources[i] = new BinaryValuesSource(
                if (i < indexSortSourcePrefix) {
        );
                                    long value = (Long) values.get(k);
import org.apache.lucene.document.LongPoint;
    public void testRandomLongAndKeyword() throws IOException {
        testRandomCase(new ClassAndName(createNumber("long", LONG), Long.class));
                        missingBucket,
    public void testRandomKeyword() throws IOException {
                        sources,
    }
            for (int i = 0; i < types.length; i++) {
 * SPDX-License-Identifier: Apache-2.0
                    final SortedDocsProducer docsProducer = sources[0].createSortedDocsProducerOrNull(reader, new MatchAllDocsQuery());
                    while (queue.size() > pos) {
import org.apache.lucene.sandbox.document.BigIntegerPoint;
                    values[j] = randomUnsignedLong();
            }
 *
            }
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.UNSIGNED_LONG;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
        List<CompositeKey> keys = new ArrayList<>();
import org.apache.lucene.util.NumericUtils;
                    break;
            new ClassAndName(createNumber("long", LONG), Long.class)
                            fieldType,
                }
                        sources[i] = new GlobalOrdinalValuesSource(
}
                        keys.addAll(comb);
        );
                                    try {
                                    document.add(
                        fieldType,
                                @Override
import static org.hamcrest.Matchers.greaterThan;
                        }
                                }
                    }
                    );
                if (key2.get(i) == null) {
                            (b) -> {},
                }
    }
        );
            SingleDimensionValuesSource<?>[] sources = new SingleDimensionValuesSource[types.length];
                                    document.add(new SortedSetDocValuesField(types[j].fieldType.name(), (BytesRef) values.get(k)));
        testRandomCase(
/*
            new ClassAndName(createNumber("double", DOUBLE), Double.class),
                                            NumericUtils.doubleToSortableLong(value.doubleValue())
        try (Directory directory = newDirectory()) {
    }
                                }
        }
import org.apache.lucene.tests.index.RandomIndexWriter;
import org.apache.lucene.index.LeafReaderContext;
                    last = null;
                            for (int i = 0; i < leafReaderContext.reader().maxDoc(); i++) {
                    types[i] = new ClassAndName(createNumber(Integer.toString(i), DOUBLE), Double.class);
                            missingBucket,
        final Class<? extends Comparable<?>> clazz;
    private void testRandomCase(ClassAndName... types) throws IOException {
                    if (hasAllField || missingBucket) {
                            assertEquals(
import java.math.BigInteger;
        if (pos == maxPos) {
            }
                    values[j] = randomLong();
            new ClassAndName(createNumber("double", DOUBLE), Double.class),
                        // we don't create global ordinals but we test this mode when the reader has a single segment
        for (int i = 0; i < key1.size(); i++) {
                                    document.add(new LongPoint(types[j].fieldType.name(), value));
    }
            Arrays.sort(expected, (a, b) -> compareKey(a, b));
import org.opensearch.index.mapper.NumberFieldMapper;
            this.clazz = clazz;
                                if (liveDocs == null || liveDocs.get(i)) {
 * The OpenSearch Contributors require contributions made to
                        value -> value,
                } else if (types[i].clazz == BigInteger.class) {
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory, new KeywordAnalyzer())) {
                    boolean hasAllField = true;
                while (pos < size) {
            for (boolean withProducer : new boolean[] { true, false }) {
                }
            } else if (key2.get(i) == null) {
            ClassAndName type = types[i];
            keys.add(new CompositeKey(key.clone()));
                                } else if (types[j].clazz == BigInteger.class) {
    }
                    indexSortFields[i] = new SortedNumericSortField(type.fieldType.name(), SortField.Type.DOUBLE);
        List<Comparable<?>[]> possibleValues = new ArrayList<>();
    }
import org.opensearch.search.DocValueFormat;
                        );
        createListCombinations(new Comparable[values.size()], values, 0, values.size(), keys);
                }
            new ClassAndName(createNumber("long", LONG), Long.class)
                            }
                        DocValueFormat.RAW,
                        fieldType,
import static org.hamcrest.Matchers.equalTo;
        );
            Comparable<Object> cmp1 = (Comparable<Object>) key1.get(i);
                        DocValueFormat.RAW,
import java.util.HashSet;
import org.apache.lucene.index.DirectoryReader;
                        List<CompositeKey> comb = createListCombinations(docValues);
                        List<Comparable<?>> values = new ArrayList<>();
                    final CompositeValuesCollectorQueue queue = new CompositeValuesCollectorQueue(
                } else {
                            }
                        if (docsProducer != null && withProducer) {
        ClassAndName[] types = new ClassAndName[numTypes];
            } else if (type.clazz == BigInteger.class) {
    public void testRandomDoubleAndUnsignedLong() throws IOException {
 */
                }
import org.apache.lucene.document.SortedNumericDocValuesField;
            }
import org.apache.lucene.search.DocIdSet;
                            context -> DocValues.getSortedSet(context.reader(), fieldType.name()),
                        assertThat(key, equalTo(expected[ptr--]));
        for (int i = 0; i < types.length; i++) {
import org.apache.lucene.document.Field;
        List<List<Comparable<?>>> values,
                    );
                for (int i = 0; i < numDocs; i++) {
 * GitHub history for details.
        assert key1.size() == key2.size();
        Comparable<?>[] key,
                                } else if (types[j].clazz == Double.class) {
                    List<List<Comparable<?>>> docValues = new ArrayList<>();
                }
                        missingBucket,
 * under the License.
import org.apache.lucene.search.SortedNumericSortField;
                                    BytesRef value = (BytesRef) values.get(k);
                        } else {
            testRandomCase(true, true, i, types);
    }
                            size,
                                public void collect(int doc, long bucket) throws IOException {
                                docsProducer.processLeaf(new MatchAllDocsQuery(), queue, leafReaderContext, false)
            possibleValues.add(values);
import org.opensearch.index.fielddata.FieldData;
                            MissingOrder.DEFAULT,
                    break;
                                    } catch (CollectionTerminatedException exc) {
                                DocIdSet.EMPTY,
                        // since ordinals are global in this case.
                for (int j = 0; j < numValues; j++) {
import org.apache.lucene.util.Bits;
    }
import org.apache.lucene.index.IndexWriterConfig;
                    }
    }
                    assertEquals(size, Math.min(queue.size(), expected.length - pos));
                writerConfig.setIndexSort(new Sort(indexSortFields));
                        bigArrays,
            if (key1.get(i) == null) {
    }
                if (i < indexSortSourcePrefix) {
 * You may obtain a copy of the License at
        testRandomCase(
                    types[i] = new ClassAndName(createKeyword(Integer.toString(i)), BytesRef.class);
                } else if (types[i].clazz == BytesRef.class) {
import org.opensearch.common.util.BigArrays;
            this.fieldType = fieldType;
            if (type.clazz == Long.class) {
            new ClassAndName(createKeyword("keyword"), BytesRef.class),
                        } else {
        );
    }
        }
                return 1;
                                    document.add(new BigIntegerPoint(types[j].fieldType.name(), value));
                            final LeafBucketCollector queueCollector = queue.getLeafCollector(leafReaderContext, leafCollector);
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
                            size,
                                values.add(possibleValues.get(j)[randomIntBetween(0, possibleValues.get(j).length - 1)]);
                                } else if (types[j].clazz == BytesRef.class) {
 * the Apache License, Version 2.0 (the "License"); you may
            IndexReader reader = DirectoryReader.open(directory);
 *
                    sources[i] = new DoubleValuesSource(
public class CompositeValuesCollectorQueueTests extends AggregatorTestCase {
                    if (forceMerge) {
                for (int j = 0; j < numValues; j++) {
            testRandomCase(false, false, i, types);
                        1
import org.apache.lucene.index.IndexReader;
                }
    }
 * this file be licensed under the Apache-2.0 license or a
                } else if (types[i].clazz == Double.class) {
        testRandomCase(new ClassAndName(createKeyword("keyword"), BytesRef.class));
                CompositeKey last = null;
    public void testRandomDouble() throws IOException {
            new ClassAndName(createNumber("double", DOUBLE), Double.class),
                                            types[j].fieldType.name(),
                }
                    for (int j = 0; j < types.length; j++) {
                        context -> FieldData.sortableLongBitsToDoubles(DocValues.getSortedNumeric(context.reader(), fieldType.name())),
import org.opensearch.index.mapper.KeywordFieldMapper;
        return 0;
                                    }
                        int numValues = indexSortSourcePrefix - 1 >= j ? 1 : randomIntBetween(0, 5);
            }
    }
                case 2:
                            1
    }
            switch (rand) {
    private static List<CompositeKey> createListCombinations(List<List<Comparable<?>>> values) {
 * Modifications Copyright OpenSearch Contributors. See
            }
            int cmp = cmp1.compareTo(key2.get(i));
                if (types[i].clazz == Long.class) {
            int numValues = randomIntBetween(1, numDocs * 2);
                    assert (false);
                if (i < indexSortSourcePrefix) {
import org.apache.lucene.document.Document;
            if (cmp != 0) {
                                        )
    }
                                }
        int pos,
                        size,
            }
        testRandomCase(
                    }
                    indexWriter.forceMerge(1);
            } else {
    ) {
                                    document.add(new TextField(types[j].fieldType.name(), value.utf8ToString(), Field.Store.NO));
            int rand = randomIntBetween(0, 2);
import org.opensearch.search.aggregations.LeafBucketCollector;
                                            NumericUtils.doubleToSortableLong((Double) values.get(k))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Set;
                for (int j = 0; j < numValues; j++) {
import org.apache.lucene.document.TextField;
                    }
        testRandomCase(
        List<CompositeKey> keys
                        bigArrays,
 * not use this file except in compliance with the License.
                final MappedFieldType fieldType = types[i].fieldType;
                }
        testRandomCase(new ClassAndName(createNumber("double", DOUBLE), Double.class));
                    Document document = new Document();
                if (i < indexSortSourcePrefix) {
    public void testRandomKeywordAndLong() throws IOException {
                    assert (false);
import org.opensearch.search.aggregations.AggregatorTestCase;
 */
                return cmp;
                                    );
        for (int i = 0; i < types.length; i++) {
        SortField[] indexSortFields = indexSortSourcePrefix == 0 ? null : new SortField[indexSortSourcePrefix];
            }
    private static MappedFieldType createNumber(String name, NumberFieldMapper.NumberType type) {
    static class ClassAndName {
            new ClassAndName(createKeyword("keyword"), BytesRef.class),
            }
            final Comparable<?>[] values;
                            1
            values = new Comparable[numValues];
                if (forceMerge) {
        for (int i = 0; i < numTypes; i++) {
 * Unless required by applicable law or agreed to in writing,
        Set<CompositeKey> keys = new HashSet<>();
                        missingBucket,
import java.util.Arrays;
        return new KeywordFieldMapper.KeywordFieldType(name);
                assert (false);
                    );
                            bigArrays,
/*
                            context -> FieldData.toString(DocValues.getSortedSet(context.reader(), fieldType.name())),
                                            types[j].fieldType.name(),
            if (indexSortFields != null) {
        }
                }
        );
    private static void createListCombinations(
 * Licensed to Elasticsearch under one or more contributor
        ClassAndName(MappedFieldType fieldType, Class<? extends Comparable<?>> clazz) {
                        1
                                    BigInteger value = (BigInteger) values.get(k);
        );
                            );
        }
                                        assertThat(indexSortSourcePrefix, greaterThan(0));
/*
 * software distributed under the License is distributed on an
 * compatible open source license.
 */
    public void testRandomDoubleAndKeyword() throws IOException {
                case 1:
    }
            new ClassAndName(createNumber("double", DOUBLE), Double.class)
        final MappedFieldType fieldType;
            } else if (type.clazz == Double.class) {
import org.apache.lucene.search.SortedSetSortField;
                        MissingOrder.DEFAULT,
            new ClassAndName(createNumber("unsigned_long", UNSIGNED_LONG), BigInteger.class)
                        CompositeKey key = queue.toCompositeKey(queue.pop());
        testRandomCase(
        throws IOException {
                                        )
                default:
            reader.close();
            testRandomCase(true, false, i, types);
 *
                case 0:
