                }
                        DocValueFormat.RAW,
    private void testRandomCase(ClassAndName... types) throws IOException {  
                            MissingOrder.DEFAULT,
    private static MappedFieldType createKeyword(String name) {
    }  
            new ClassAndName(createNumber("long", LONG), Long.class),
                        DocValueFormat.RAW,  
package org.opensearch.search.aggregations.bucket.composite;
            keys.add(new CompositeKey(key.clone()));  
import org.apache.lucene.analysis.core.KeywordAnalyzer;  
                                    document.add(new SortedNumericDocValuesField(types[j].fieldType.name(), value));  
                            bigArrays,
import java.util.List;
 * ownership. Elasticsearch licenses this file to you under  
                        size,
                                public void collect(int doc, long bucket) throws IOException {
                    assert (false);
                                    );
                    pos += queue.size();  
                                DocIdSet.EMPTY,
                                values.add(null);
                } else if (types[i].clazz == BigInteger.class) {
                        size,
    }
                    final CompositeValuesCollectorQueue queue = new CompositeValuesCollectorQueue(
import org.apache.lucene.index.DirectoryReader;
 * Licensed to Elasticsearch under one or more contributor  
            } else {  
            int rand = randomIntBetween(0, 2);  
                                }  
                default:
                final MappedFieldType fieldType = types[i].fieldType;
    public void testRandomDouble() throws IOException {
                        bigArrays,
import java.util.HashSet;  
                                docsProducer.processLeaf(new MatchAllDocsQuery(), queue, leafReaderContext, false)  
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;  
                        CompositeKey key = queue.toCompositeKey(queue.pop());  
import org.apache.lucene.index.DocValues;
                                } else {
                int pos = 0;
                if (key2.get(i) == null) {  
    public void testRandomDoubleAndLong() throws IOException {
                }
import java.util.ArrayList;
import org.apache.lucene.document.LongPoint;  
 * Modifications Copyright OpenSearch Contributors. See  
import org.apache.lucene.util.Bits;
                    indexSortFields[i] = new SortedSetSortField(type.fieldType.name(), false);
    }
import org.apache.lucene.search.Sort;
            new ClassAndName(createNumber("double", DOUBLE), Double.class)
import java.math.BigInteger;  
        } else {
                    boolean hasAllField = true;
                    List<List<Comparable<?>>> docValues = new ArrayList<>();  
    public void testRandomLongAndDouble() throws IOException {
                    sources[i] = new DoubleValuesSource(
        int numTypes = randomIntBetween(3, 8);  
                            last = key;
                            for (int i = 0; i < leafReaderContext.reader().maxDoc(); i++) {
                        size,  
                    for (int j = 0; j < types.length; j++) {
                }  
                    Document document = new Document();
                    types[i] = new ClassAndName(createNumber(Integer.toString(i), LONG), Long.class);  
        }
                    );
                }
import org.apache.lucene.search.CollectionTerminatedException;
                    if (forceMerge) {
            new ClassAndName(createKeyword("keyword"), BytesRef.class),
                } else if (types[i].clazz == BytesRef.class) {  
            if (indexSortFields != null) {  
 *  
        testRandomCase(
    public void testRandomLongAndKeyword() throws IOException {  
                                    document.add(new SortedSetDocValuesField(types[j].fieldType.name(), (BytesRef) values.get(k)));
                            };
            new ClassAndName(createNumber("double", DOUBLE), Double.class),
    public void testRandomKeywordAndLong() throws IOException {  
                    indexWriter.addDocument(document);  
            ClassAndName type = types[i];
                    values[j] = new BytesRef(randomAlphaOfLengthBetween(5, 50));
                            size,
            int size = keys.size() > 1 ? randomIntBetween(1, keys.size()) : 1;
            new ClassAndName(createNumber("double", DOUBLE), Double.class),
        testRandomCase(
    private static void createListCombinations(
        );
                        keys.addAll(comb);
import org.apache.lucene.search.MatchAllDocsQuery;  
                    values[j] = randomLong();
                    indexSortFields[i] = new SortedNumericSortField(type.fieldType.name(), SortField.Type.LONG);
    }
                                        new SortedNumericDocValuesField(
    }
                                    }
/*  
                                    long value = (Long) values.get(k);
                                    document.add(
        Set<CompositeKey> keys = new HashSet<>();  
    }
            testRandomCase(false, true, i, types);
                    assert (false);  
                                    document.add(  
                                }
                        assertThat(key, equalTo(expected[ptr--]));
                            context -> DocValues.getSortedSet(context.reader(), fieldType.name()),
                        List<CompositeKey> comb = createListCombinations(docValues);  
            if (key1.get(i) == null) {
import org.apache.lucene.sandbox.document.BigIntegerPoint;  
            }
 * this file be licensed under the Apache-2.0 license or a
        assert key1.size() == key2.size();  
                }
                        // since ordinals are global in this case.  
                            }
    public void testRandomLong() throws IOException {  
                                    assert (false);
        }  
                    break;
                case 0:
                                    );  
                            if (missingBucket) {
                        docValues.add(values);  
            SingleDimensionValuesSource<?>[] sources = new SingleDimensionValuesSource[types.length];
                        bigArrays,  
        for (int i = 0; i < types.length; i++) {  
    public void testRandomDoubleAndUnsignedLong() throws IOException {  
                                            NumericUtils.doubleToSortableLong(value.doubleValue())
                        1
            Comparable<Object> cmp1 = (Comparable<Object>) key1.get(i);
        testRandomCase(  
    private static List<CompositeKey> createListCombinations(List<List<Comparable<?>>> values) {
                    while (queue.size() > pos) {
    }
                for (int j = 0; j < numValues; j++) {
                    types[i] = new ClassAndName(createNumber(Integer.toString(i), DOUBLE), Double.class);  
                        sources[i] = new BinaryValuesSource(  
                        // we don't create global ordinals but we test this mode when the reader has a single segment
                                    BigInteger value = (BigInteger) values.get(k);  
                        if (numValues == 0) {
                        missingBucket,
            new ClassAndName(createNumber("long", LONG), Long.class),  
                        context -> FieldData.sortableLongBitsToDoubles(DocValues.getSortedNumeric(context.reader(), fieldType.name())),  
            new ClassAndName(createNumber("long", LONG), Long.class)  
                CompositeKey last = null;
    }
import java.util.Set;
import org.opensearch.common.util.BigArrays;
        }  
        }
                            context -> FieldData.toString(DocValues.getSortedSet(context.reader(), fieldType.name())),
                                    document.add(new TextField(types[j].fieldType.name(), value.utf8ToString(), Field.Store.NO));  
import static org.hamcrest.Matchers.greaterThan;
                if (i < indexSortSourcePrefix) {  
    }
            }
import org.apache.lucene.document.Field;
        if (pos == maxPos) {
                            size,
            this.clazz = clazz;
            Arrays.sort(expected, (a, b) -> compareKey(a, b));
            testRandomCase(true, true, i, types);
                    }
                }
                        fieldType,
        testRandomCase(
                        MissingOrder.DEFAULT,
    }
            }
import org.apache.lucene.index.LeafReaderContext;
                        sources,  
                            }
                    for (LeafReaderContext leafReaderContext : reader.leaves()) {
        testRandomCase(  
                } else if (types[i].clazz == Double.class) {
        return keys;
                    indexWriter.forceMerge(1);  
    static class ClassAndName {
import org.apache.lucene.tests.index.RandomIndexWriter;  
 * under the License.  
            new ClassAndName(createKeyword("keyword"), BytesRef.class)
                        missingBucket,  
                if (i < indexSortSourcePrefix) {
        testRandomCase(types);  
                        int numValues = indexSortSourcePrefix - 1 >= j ? 1 : randomIntBetween(0, 5);  
            testRandomCase(false, false, i, types);
        for (int i = 0; i < key1.size(); i++) {
                        if (docsProducer != null && withProducer) {  
 *
            this.fieldType = fieldType;
        return new NumberFieldMapper.NumberFieldType(name, type);
 * license agreements. See the NOTICE file distributed with
        );
        );
                    last = null;
            if (type.clazz == Long.class) {
                return cmp;
                                } else if (types[j].clazz == BytesRef.class) {  
                                        )
                    assertEquals(size, Math.min(queue.size(), expected.length - pos));
                            MissingOrder.DEFAULT,
        List<CompositeKey> keys = new ArrayList<>();
            for (boolean withProducer : new boolean[] { true, false }) {  
 * SPDX-License-Identifier: Apache-2.0
                                        queueCollector.collect(i);
                                if (types[j].clazz == Long.class) {
            new ClassAndName(createNumber("long", LONG), Long.class),
            int cmp = cmp1.compareTo(key2.get(i));
            new ClassAndName(createNumber("double", DOUBLE), Double.class)
        try (Directory directory = newDirectory()) {
                        size,
        );
                            DocValueFormat.RAW,
                    indexSortFields[i] = new SortedNumericSortField(type.fieldType.name(), SortField.Type.DOUBLE);  
import org.apache.lucene.document.TextField;  
                    types[i] = new ClassAndName(createKeyword(Integer.toString(i)), BytesRef.class);  
                    } else {
            new ClassAndName(createNumber("double", DOUBLE), Double.class),  
                        context -> DocValues.getSortedNumeric(context.reader(), fieldType.name()),  
                        MissingOrder.DEFAULT,
                                values.add(possibleValues.get(j)[randomIntBetween(0, possibleValues.get(j).length - 1)]);  
                                    try {
                }  
        testRandomCase(new ClassAndName(createKeyword("keyword"), BytesRef.class));  
                if (i < indexSortSourcePrefix) {
import org.opensearch.search.aggregations.LeafBucketCollector;
                        }
    private static MappedFieldType createNumber(String name, NumberFieldMapper.NumberType type) {  
import org.opensearch.search.DocValueFormat;  
        );  
                for (int i = 0; i < numDocs; i++) {
        ClassAndName(MappedFieldType fieldType, Class<? extends Comparable<?>> clazz) {  
        for (int i = 0; i < types.length; i++) {
    public void testRandomLongAndUnsignedLong() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
                    values[j] = randomUnsignedLong();
            }  
            new ClassAndName(createNumber("unsigned_long", UNSIGNED_LONG), BigInteger.class)
                                @Override
                } else {  
                    break;
import java.util.Arrays;
                    }
import org.apache.lucene.util.BytesRef;
                    break;
import org.opensearch.index.mapper.NumberFieldMapper;
            }
        final BigArrays bigArrays = BigArrays.NON_RECYCLING_INSTANCE;
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
    private void testRandomCase(boolean forceMerge, boolean missingBucket, int indexSortSourcePrefix, ClassAndName... types)  
import org.apache.lucene.document.Document;
            }
 *
            } else if (key2.get(i) == null) {
                            fieldType,  
import org.apache.lucene.search.SortedNumericSortField;  
                        } else {
import org.apache.lucene.search.SortField;
        );
        List<List<Comparable<?>>> values,  
                                    queue.addIfCompetitive(indexSortSourcePrefix, 1);  
import org.apache.lucene.search.DocIdSet;
                                    } catch (CollectionTerminatedException exc) {  
                return 1;
    public void testRandomKeywordAndDouble() throws IOException {
                            final Bits liveDocs = leafReaderContext.reader().getLiveDocs();
            IndexReader reader = DirectoryReader.open(directory);  
        List<CompositeKey> keys  
            } else if (type.clazz == BigInteger.class) {  
                }
                            missingBucket,  
                createListCombinations(key, values, pos + 1, maxPos, keys);
 *    http://www.apache.org/licenses/LICENSE-2.0
        testRandomCase(new ClassAndName(createNumber("double", DOUBLE), Double.class));
 * specific language governing permissions and limitations
                key[pos] = val;  
                            1  
            if (cmp != 0) {  
                if (types[i].clazz == Long.class) {
                }
                                if (liveDocs == null || liveDocs.get(i)) {  
                        if (last == null) {
        );  
        testRandomCase(
    public void testRandom() throws IOException {
                        MissingOrder.DEFAULT,  
                }
                }
                    );
            final Comparable<?>[] values;
                            fieldType,  
                return -1;  
                        missingBucket,
                        }  
        testRandomCase(
 * Unless required by applicable law or agreed to in writing,
                                        new SortedNumericDocValuesField(
            final IndexWriterConfig writerConfig = newIndexWriterConfig();
import org.apache.lucene.document.SortedNumericDocValuesField;
            int numValues = randomIntBetween(1, numDocs * 2);  
                                        )
                writerConfig.setIndexSort(new Sort(indexSortFields));
import org.apache.lucene.search.SortedSetSortField;
                    }
                    }  
        }  
 * not use this file except in compliance with the License.
                                            types[j].fieldType.name(),  
    }
            switch (rand) {
import org.apache.lucene.index.IndexWriterConfig;
                    );  
/*
                            final LeafBucketCollector leafCollector = new LeafBucketCollector() {  
        }  
import org.opensearch.index.fielddata.FieldData;
            new ClassAndName(createNumber("unsigned_long", UNSIGNED_LONG), BigInteger.class)  
                case 1:
        return 0;
 * KIND, either express or implied.  See the License for the
            values = new Comparable[numValues];
    public void testRandomKeyword() throws IOException {
        createListCombinations(new Comparable[values.size()], values, 0, values.size(), keys);  
        testRandomCase(
                                    document.add(new BigIntegerPoint(types[j].fieldType.name(), value));
                    final SortedDocsProducer docsProducer = sources[0].createSortedDocsProducerOrNull(reader, new MatchAllDocsQuery());
    }
                        sources[i] = new GlobalOrdinalValuesSource(
            } else if (type.clazz == BytesRef.class) {
        ClassAndName[] types = new ClassAndName[numTypes];
                while (pos < size) {  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory, new KeywordAnalyzer())) {  
            new ClassAndName(createKeyword("keyword"), BytesRef.class)  
                assert (false);
 * You may obtain a copy of the License at  
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.LONG;
        int maxPos,
        throws IOException {
        Comparable<?>[] key,
                if (forceMerge) {
public class CompositeValuesCollectorQueueTests extends AggregatorTestCase {
import org.apache.lucene.store.Directory;
                                        assertThat(indexSortSourcePrefix, greaterThan(0));
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.DOUBLE;
                            final LeafBucketCollector queueCollector = queue.getLeafCollector(leafReaderContext, leafCollector);  
    }  
                        fieldType,
 * compatible open source license.
            }
                        value -> value,
        List<Comparable<?>[]> possibleValues = new ArrayList<>();
                    sources[i] = new LongValuesSource(  
/*
                    if (hasAllField || missingBucket) {
                    sources[i] = new DoubleValuesSource(  
                                            NumericUtils.doubleToSortableLong((Double) values.get(k))  
import org.apache.lucene.index.IndexReader;  
                for (int j = 0; j < numValues; j++) {  
            reader.close();
                            DocValueFormat.RAW,
        SortField[] indexSortFields = indexSortSourcePrefix == 0 ? null : new SortField[indexSortSourcePrefix];
                                    document.add(new LongPoint(types[j].fieldType.name(), value));
import org.apache.lucene.document.SortedSetDocValuesField;
    }  
                            missingBucket,  
                        DocValueFormat.RAW,
                            for (int k = 0; k < numValues; k++) {
                }  
 * GitHub history for details.
                    indexSortFields[i] = new SortedNumericSortField(type.fieldType.name(), SortField.Type.LONG);
        final Class<? extends Comparable<?>> clazz;
import static org.hamcrest.Matchers.equalTo;
                            bigArrays,
                case 2:
import org.apache.lucene.util.NumericUtils;  
            for (Comparable<?> val : values.get(pos)) {
                    values[j] = randomDouble();  
                        );
    private static int compareKey(CompositeKey key1, CompositeKey key2) {
                    int ptr = pos + (queue.size() - 1);
            possibleValues.add(values);  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    }
                        List<Comparable<?>> values = new ArrayList<>();
 * software distributed under the License is distributed on an
            CompositeKey[] expected = keys.toArray(new CompositeKey[0]);
            testRandomCase(true, false, i, types);  
import org.opensearch.search.aggregations.AggregatorTestCase;
        testRandomCase(new ClassAndName(createNumber("long", LONG), Long.class));
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.UNSIGNED_LONG;  
                    continue;
    }
                }
        }  
import org.opensearch.index.mapper.KeywordFieldMapper;  
            } else if (type.clazz == Double.class) {
            new ClassAndName(createNumber("long", LONG), Long.class)
        int numDocs = randomIntBetween(50, 100);  
            new ClassAndName(createKeyword("keyword"), BytesRef.class),  
            }  
                            }  
    public void testRandomDoubleAndKeyword() throws IOException {
 */
        );
                            1  
    }  
                                            types[j].fieldType.name(),
    ) {
                        last
            }
                        bigArrays,
                        );
                        }
                if (i < indexSortSourcePrefix) {  
                            (b) -> {},
    }
            for (int i = 0; i < types.length; i++) {  
                        1
        final MappedFieldType fieldType;  
                                } else if (types[j].clazz == Double.class) {
                            assertEquals(
                        1  
                                } else if (types[j].clazz == BigInteger.class) {
        for (int i = 0; i < numTypes; i++) {
        return new KeywordFieldMapper.KeywordFieldType(name);
                for (int j = 0; j < numValues; j++) {
import org.opensearch.index.mapper.MappedFieldType;
    }  
                for (int j = 0; j < numValues; j++) {  
 */
                        } else {
        int pos,
                    );  
 */  
                        BigArrays.NON_RECYCLING_INSTANCE,
                                    BytesRef value = (BytesRef) values.get(k);
                        context -> FieldData.sortableLongBitsToDoubles(DocValues.getSortedNumeric(context.reader(), fieldType.name())),
import java.io.IOException;
                            hasAllField = false;  
}
                            );
                        fieldType,
                                }  
    }
