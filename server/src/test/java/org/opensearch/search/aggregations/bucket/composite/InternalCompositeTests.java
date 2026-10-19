            types[i] = type;  
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 1, 2 });  
            for (int i = 0; i < o1.size(); i++) {  
    }
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field3", "field2"), new Comparable[] { 1, 2 });
import org.opensearch.index.mapper.DateFieldMapper;  
        reverseMuls = new int[numFields];
    public void testCompareCompositeKeyMoreFieldsIsGreater() {
        missingOrders = new MissingOrder[numFields];
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 1, 2 });  
 * software distributed under the License is distributed on an
    }  
            metadata
                break;
            true,
            sourceNames.add("field_" + i);
public class InternalCompositeTests extends InternalMultiBucketAggregationTestCase<InternalComposite> {
                    new InternalComposite.InternalBucket(
                    )
        }
 * this file be licensed under the Apache-2.0 license or a
    }  
/*  
                        reverseMuls,  
                reverseMuls,
import static org.hamcrest.Matchers.equalTo;  
        return new InternalComposite.ArrayMap(fields, formats, values);  
            .limit(reduced.getSize())
            formats,
    public void testCompareCompositeKeySmallerFieldName() {
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Comparator;
        return (o1, o2) -> {
        for (int i = 0; i < numFields; i++) {
        Comparable<?>[] keys = new Comparable<?>[sourceNames.size()];
        List<InternalAggregation> toReduce = Arrays.asList(unmapped, mapped);
        switch (code) {  
            rawFormats,
        InternalComposite finalReduce = (InternalComposite) result.reduce(toReduce, emptyReduceContextBuilder().forFinalReduction());  
                );
                int cmp = ((Comparable) o1.get(i)).compareTo(o2.get(i)) * reverseMuls[i];
    protected Class<ParsedComposite> implementationClass() {
            }
        Collections.shuffle(toReduce, random());
        assertThat(key1.equals(key1), is(true));  
    }
 *
        return new CompositeKey(keys);  
        final InternalAggregation aggregation,  
    }
        super.tearDown();
    @Override  
                    return cmp;  
            } else {  
        assertThat(key2.equals(key1), is(true));
 *  
    }  
        int numFields = randomIntBetween(1, 10);  
            lastBucket,
            randomBoolean(),
            }
    }  
            mapped.getSize(),  
            return DocValueFormat.RAW;
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 1, 2 });
 */  
    @Override  
                    DateFieldMapper.Resolution.MILLISECONDS
                return new DocValueFormat.DateTime(
        final boolean addRandomFields
import java.util.TreeSet;
    public void testCompareCompositeKeyLessFieldsIsLesser() {
    protected InternalComposite mutateInstance(InternalComposite instance) throws IOException {
        assertThat(key1.compareTo(key1), equalTo(0));
            missingOrders,  
            assertThat(bucket.getFormats(), equalTo(expectedBucket.getFormats()));
 * KIND, either express or implied.  See the License for the
        List<CompositeKey> expectedKeys = inputs.stream()
 * this work for additional information regarding copyright
    public void testCompareCompositeKeySmallerValue() {
                break;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(exception.getMessage(), containsString("java.lang.String cannot be cast to"));
        for (int i = 0; i < numBuckets; i++) {  
    ) throws IOException {  
            reverseMuls[i] = randomBoolean() ? 1 : -1;  
    private List<String> sourceNames;
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(bucket.getRawKey(), equalTo(expectedBucket.getRawKey()));
                        missingOrders,
            lastBucket,
                        InternalAggregations.EMPTY  
        formats = null;
        }
    public void testCompareCompositeKeyBiggerFieldName() {
        InternalComposite result = createTestInstance(randomAlphaOfLength(10), Collections.emptyMap(), InternalAggregations.EMPTY);  
        List<DocValueFormat> rawFormats = formats.stream().map(f -> DocValueFormat.RAW).collect(toList());  
            switch (types[j]) {
 * under the License.  
    }  
    public void testCompareCompositeKeyValuesHaveDifferentTypes() {
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field3", "field2"), new Comparable[] { 2, 3 });
                        createCompositeKey(),
import java.util.HashMap;  
                case 0:
        List<InternalComposite.InternalBucket> buckets = new ArrayList<>();
            int type = randomIntBetween(0, 2);
import java.util.Map;  
import org.apache.lucene.util.BytesRef;
     */  
                    break;
        assertThat(key1.compareTo(key2), lessThan(0));
        assertThat(reduced.getBuckets().size(), equalTo(expectedKeys.size()));
            .collect(Collectors.toList());
                } else {
import java.util.Arrays;  
            .flatMap((s) -> s.getBuckets().stream())  
                    ZoneOffset.ofHours(1),  
            return 0;  
/*  
                    keys[j] = new BytesRef(randomAsciiLettersOfLengthBetween(1, 20));  
        Iterator<InternalComposite.InternalBucket> expectedIt = result.getBuckets().iterator();
 * Unless required by applicable law or agreed to in writing,
                        randomLongBetween(1, 100),
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field3", "field2"), new Comparable[] { 1, 2 });  
                    throw new AssertionError("illegal branch");  
                    keys[j] = randomDouble();  
        }
    }
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 1, 2 });
            emptyMap()
        InternalComposite mapped = createTestInstance(randomAlphaOfLength(10), emptyMap(), InternalAggregations.EMPTY);
import static org.hamcrest.Matchers.lessThan;  
        size = randomNumberOfBuckets();
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field1", "field2", "field3"), new Comparable[] { null, 1, 2 });  
    public void testCompareCompositeKeyEqual() {
            InternalComposite.InternalBucket bucket = new InternalComposite.InternalBucket(  
                );
        int[] reverseMuls = instance.getReverseMuls();
            metadata
    protected InternalComposite createTestInstance(String name, Map<String, Object> metadata, InternalAggregations aggregations) {
 * The OpenSearch Contributors require contributions made to  
    }
                buckets.add(
    @Override
            instance.getName(),
            buckets,  
    public void tearDown() throws Exception {
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field1", "field2", "field3"), new Comparable[] { null, 1, 2 });
                throw new AssertionError("illegal branch");
        sourceNames = new ArrayList<>();
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field3", "field2"), new Comparable[] { 1, 2 });  
        assertThat(key1.compareTo(key2), greaterThan(0));
                missingOrders,
        int numSame = randomIntBetween(1, 10);
                metadata.put(randomAlphaOfLength(15), randomInt());
import java.util.Collections;
        for (int j = 0; j < keys.length; j++) {  
        int code = randomIntBetween(0, 2);
        }
        List<InternalAggregation> toReduce = new ArrayList<>();
            formats.add(randomDocValueFormat(type == 0));
                        formats,
            randomBoolean(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            name,
import static java.util.stream.Collectors.toList;
        assertThat(reduced.getBuckets().size(), lessThanOrEqualTo(size));
    private int size;
    public void testReduceUnmapped() throws IOException {
                    keys[j] = randomLong();  
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 1, 2 });
                default:
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field1", "field2", "field3"), new Comparable[] { 1, 2, null });
 * the Apache License, Version 2.0 (the "License"); you may
                break;  
            assertThat(bucket.getDocCount(), equalTo(expectedBucket.getDocCount() * numSame));  
            instance.getSize(),  
        if (false == mapped.getBuckets().isEmpty()) {
import org.opensearch.search.DocValueFormat;
    private Comparator<CompositeKey> getKeyComparator() {
            InternalComposite.InternalBucket expectedBucket = expectedIt.next();
    }
import org.opensearch.search.aggregations.InternalAggregations;  
/*
        for (int i = 0; i < numSame; i++) {  
}
            buckets,  
            assertTrue(expectedIt.hasNext());
import java.util.ArrayList;
import org.junit.After;
        }
        final boolean shuffled,
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 1, 2 });
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                int[] newReverseMuls = new int[reverseMuls.length];
            case 0:
        List<InternalComposite.InternalBucket> buckets = instance.getBuckets();
        CompositeKey lastBucket = buckets.size() > 0 ? buckets.get(buckets.size() - 1).getRawKey() : null;  
            null,
    private InternalComposite.ArrayMap createMap(List<String> fields, Comparable[] values) {
    }
            assertThat(bucket.getRawKey(), equalTo(expectedIt.next()));  
import java.time.ZoneOffset;
import java.util.Iterator;
        super.setUp();
        assertThat(key1.compareTo(key2), greaterThan(0));
    /**
     * Check that reducing with an unmapped index produces useful formats.
    @After  
 */  
            size,  
                1L,  
            // we use specific format only for date histogram on a long/date field
    private static DocValueFormat randomDocValueFormat(boolean isLong) {  
                    break;
import static org.hamcrest.Matchers.greaterThan;
                for (int i = 0; i < reverseMuls.length; i++) {  
    public void testCompareCompositeKeyNullValueIsSmaller1() {
        InternalComposite finalReduce = (InternalComposite) unmapped.reduce(toReduce, emptyReduceContextBuilder().forFinalReduction());  
            assertThat(bucket.getDocCount(), equalTo(expectedBucket.getDocCount()));  
            case 2:
 * not use this file except in compliance with the License.
    }  
        assertThat(finalReduce.getBuckets().size(), equalTo(result.getBuckets().size()));
 * specific language governing permissions and limitations
        ClassCastException exception = expectThrows(ClassCastException.class, () -> key1.compareTo(key2));  
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
        assertThat(key1.equals(key2), is(true));  
            buckets.add(bucket);  
        Iterator<InternalComposite.InternalBucket> expectedIt = mapped.getBuckets().iterator();
    private CompositeKey createCompositeKey() {
        for (InternalComposite.InternalBucket bucket : finalReduce.getBuckets()) {  
            reverseMuls,
        };
                }  
        sourceNames = null;  
            reverseMuls,
import static java.util.Collections.emptyMap;  
    }  
        CompositeKey lastBucket = buckets.size() > 0 ? buckets.get(buckets.size() - 1).getRawKey() : null;  
        }
        }
        InternalComposite unmapped = new InternalComposite(
            case 1:
            reverseMuls,
    public void testCompareCompositeKeyNullValueIsSmaller2() {
    }
                return DocValueFormat.RAW;
    private int[] reverseMuls;
            .sorted(getKeyComparator())
    protected void assertReduced(InternalComposite reduced, List<InternalComposite> inputs) {
    public void testReduceSame() throws IOException {
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomAsciiLettersOfLengthBetween;
    }  
            missingOrders[i] = randomFrom(MissingOrder.values());
        return new InternalComposite(
        formats = new ArrayList<>();  
                    metadata = new HashMap<>(instance.getMetadata());
        );  
            keys.add(key);
    private MissingOrder[] missingOrders;
                    newReverseMuls[i] = reverseMuls[i] == 1 ? -1 : 1;
import java.util.stream.IntStream;  
            if (keys.contains(key)) {
        types = new int[numFields];  
        assertThat(key1.compareTo(key2), greaterThan(0));
                sourceNames,
        assertThat(key1.compareTo(key2), lessThan(0));
    @Override
            assertThat(bucket.getRawKey(), equalTo(expectedBucket.getRawKey()));
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 1, 2 });  
import java.io.IOException;  
                        sourceNames,  
            emptyList(),  
        return new InternalComposite(
        List<DocValueFormat> formats = IntStream.range(0, fields.size()).mapToObj(i -> DocValueFormat.RAW).collect(Collectors.toList());
 * SPDX-License-Identifier: Apache-2.0
        assertThat(finalReduce.getBuckets().size(), equalTo(mapped.getBuckets().size()));
            sourceNames,
                if (metadata == null) {
            sourceNames,
            if (randomBoolean()) {  
            missingOrders,  
            final CompositeKey key = createCompositeKey();
    }  
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { null, 20 });  
 * Licensed to Elasticsearch under one or more contributor  
    }  
            mapped.getName(),
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 1, 2 });  
import org.opensearch.test.InternalMultiBucketAggregationTestCase;  
            missingOrders,  
                    break;
    }
            sourceNames,
            toReduce.add(result);
        );  
            InternalComposite.InternalBucket expectedBucket = expectedIt.next();
        types = null;  
        reverseMuls = null;
        int numBuckets = randomIntBetween(0, size);  
        assertThat(key1.compareTo(key2), equalTo(0));
 *
 */
    }
        );  
        for (InternalComposite.InternalBucket bucket : reduced.getBuckets()) {
    private List<DocValueFormat> formats;  
            formats,
                buckets = new ArrayList<>(buckets);  
                    metadata = new HashMap<>(1);  
                    DateFormatter.forPattern("epoch_second"),
            );
    }  
        TreeSet<CompositeKey> keys = new TreeSet<>(getKeyComparator());
        assertThat(key1.compareTo(key2), greaterThan(0));
    protected <P extends ParsedAggregation> P parseAndAssert(
                formats,
            .distinct()  
    }
        Iterator<CompositeKey> expectedIt = expectedKeys.iterator();  
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field1", "field2", "field3"), new Comparable[] { 1, 2, null });  
import static java.util.Collections.emptyList;
            // and the raw format for the other types
import org.opensearch.search.aggregations.ParsedAggregation;
                }
        }  
        Map<String, Object> metadata = instance.getMetadata();  
import java.util.List;
    private int[] types;  
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { null, 20 });
 * compatible open source license.
                reverseMuls = newReverseMuls;  
            assertThat(finalReduce.getFormats(), equalTo(mapped.getFormats()));  
import static org.hamcrest.Matchers.containsString;
                key,  
            default:  
        for (InternalComposite.InternalBucket bucket : finalReduce.getBuckets()) {  
import org.opensearch.common.time.DateFormatter;
        }
    @Override  
import static org.hamcrest.Matchers.is;
        assertThat(key1.compareTo(key2), lessThan(0));
        assertThat(key1.compareTo(key2), lessThan(0));
    @SuppressWarnings("unchecked")  
    public void testCompareCompositeKeyBiggerValue() {
        Collections.sort(buckets, (o1, o2) -> o1.compareKey(o2));
                }
            }
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { "1", 2 });
        }
                aggregations
        assertFalse(expectedIt.hasNext());
import java.util.stream.Collectors;
            }
                if (cmp != 0) {
                continue;  
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.InternalAggregation;
 * GitHub history for details.
        } else {  
        if (isLong) {
            .map(InternalComposite.InternalBucket::getRawKey)
                case 2:
package org.opensearch.search.aggregations.bucket.composite;
    @Override  
 * license agreements. See the NOTICE file distributed with
                case 1:
        return super.parseAndAssert(aggregation, false, false);
    public void setUp() throws Exception {
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 2, 3 });
        return ParsedComposite.class;
    }  
