     */
        for (int i = 0; i < numBuckets; i++) {
 * software distributed under the License is distributed on an
            missingOrders,
            formats.add(randomDocValueFormat(type == 0));
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { "1", 2 });
        switch (code) {
            missingOrders,
    private static DocValueFormat randomDocValueFormat(boolean isLong) {
        int numSame = randomIntBetween(1, 10);
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { null, 20 });
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 1, 2 });
import org.opensearch.common.time.DateFormatter;
                aggregations
    @Override
                    metadata = new HashMap<>(1);
            mapped.getSize(),
    public void testCompareCompositeKeyBiggerValue() {
            reverseMuls,
        Comparable<?>[] keys = new Comparable<?>[sourceNames.size()];
        }
            rawFormats,
            .flatMap((s) -> s.getBuckets().stream())
            // we use specific format only for date histogram on a long/date field
        assertThat(key1.compareTo(key1), equalTo(0));
import java.util.stream.IntStream;
                continue;
    private List<String> sourceNames;
    public void testCompareCompositeKeyLessFieldsIsLesser() {
                reverseMuls,
        assertThat(exception.getMessage(), containsString("java.lang.String cannot be cast to"));
                    break;
    }
            metadata
/*
                    throw new AssertionError("illegal branch");
    private MissingOrder[] missingOrders;
    /**
            emptyList(),
        size = randomNumberOfBuckets();
import static org.hamcrest.Matchers.equalTo;
        reverseMuls = new int[numFields];
            sourceNames.add("field_" + i);
        if (false == mapped.getBuckets().isEmpty()) {
    public void setUp() throws Exception {
    @Override
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomAsciiLettersOfLengthBetween;
 * Unless required by applicable law or agreed to in writing,
import static java.util.Collections.emptyList;
            buckets.add(bucket);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    break;
                missingOrders,
import java.util.Arrays;
    public void testReduceSame() throws IOException {
            switch (types[j]) {
        int[] reverseMuls = instance.getReverseMuls();
            assertThat(bucket.getRawKey(), equalTo(expectedBucket.getRawKey()));
            assertThat(bucket.getDocCount(), equalTo(expectedBucket.getDocCount() * numSame));
                if (metadata == null) {
                );
    }
        return new InternalComposite(
        formats = null;
        for (int i = 0; i < numFields; i++) {
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 1, 2 });
            assertThat(bucket.getDocCount(), equalTo(expectedBucket.getDocCount()));
        Collections.shuffle(toReduce, random());
                key,
                buckets.add(
                }
    @Override
                    newReverseMuls[i] = reverseMuls[i] == 1 ? -1 : 1;
        assertThat(key1.compareTo(key2), equalTo(0));
            InternalComposite.InternalBucket bucket = new InternalComposite.InternalBucket(
            final CompositeKey key = createCompositeKey();
                } else {
import java.util.Collections;
        List<InternalAggregation> toReduce = Arrays.asList(unmapped, mapped);
                }
    }
 * not use this file except in compliance with the License.
                    metadata = new HashMap<>(instance.getMetadata());
                int[] newReverseMuls = new int[reverseMuls.length];
    }
            .sorted(getKeyComparator())
        int numFields = randomIntBetween(1, 10);
            int type = randomIntBetween(0, 2);
        InternalComposite result = createTestInstance(randomAlphaOfLength(10), Collections.emptyMap(), InternalAggregations.EMPTY);
 * under the License.
    }
                        reverseMuls,
        for (InternalComposite.InternalBucket bucket : finalReduce.getBuckets()) {
    protected <P extends ParsedAggregation> P parseAndAssert(
                    keys[j] = randomLong();
                metadata.put(randomAlphaOfLength(15), randomInt());
            size,
        List<CompositeKey> expectedKeys = inputs.stream()
                case 1:
        }
            buckets,
                    break;
import static org.hamcrest.Matchers.greaterThan;
        for (InternalComposite.InternalBucket bucket : finalReduce.getBuckets()) {
            case 0:
                    DateFieldMapper.Resolution.MILLISECONDS
}
import org.apache.lucene.util.BytesRef;
import java.util.Map;
    }
        CompositeKey lastBucket = buckets.size() > 0 ? buckets.get(buckets.size() - 1).getRawKey() : null;
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 1, 2 });
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field3", "field2"), new Comparable[] { 1, 2 });
 * license agreements. See the NOTICE file distributed with
            true,
import java.util.Iterator;
    }
 * KIND, either express or implied.  See the License for the
        return new InternalComposite(
        InternalComposite unmapped = new InternalComposite(
        assertThat(key1.compareTo(key2), lessThan(0));
    public void testCompareCompositeKeyEqual() {
                return new DocValueFormat.DateTime(
        reverseMuls = null;
    @Override
            reverseMuls[i] = randomBoolean() ? 1 : -1;
                break;
            );
        for (int j = 0; j < keys.length; j++) {
 * this file be licensed under the Apache-2.0 license or a
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field1", "field2", "field3"), new Comparable[] { 1, 2, null });
        assertThat(key1.compareTo(key2), lessThan(0));
        List<DocValueFormat> formats = IntStream.range(0, fields.size()).mapToObj(i -> DocValueFormat.RAW).collect(Collectors.toList());
            // and the raw format for the other types
import org.opensearch.search.aggregations.InternalAggregation;
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
        assertThat(key1.equals(key1), is(true));
    private Comparator<CompositeKey> getKeyComparator() {
            InternalComposite.InternalBucket expectedBucket = expectedIt.next();
                    return cmp;
            case 2:
    @Override
 * Licensed to Elasticsearch under one or more contributor
                        missingOrders,
        types = new int[numFields];
        List<InternalComposite.InternalBucket> buckets = instance.getBuckets();
            missingOrders[i] = randomFrom(MissingOrder.values());
        Collections.sort(buckets, (o1, o2) -> o1.compareKey(o2));
        List<InternalAggregation> toReduce = new ArrayList<>();
    }
import org.opensearch.search.DocValueFormat;
            formats,
    }
public class InternalCompositeTests extends InternalMultiBucketAggregationTestCase<InternalComposite> {
    }
                for (int i = 0; i < reverseMuls.length; i++) {
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field3", "field2"), new Comparable[] { 1, 2 });
            mapped.getName(),
                );
            sourceNames,
        assertThat(reduced.getBuckets().size(), lessThanOrEqualTo(size));
    }
            .limit(reduced.getSize())
            metadata
import java.util.TreeSet;
        sourceNames = new ArrayList<>();
                return DocValueFormat.RAW;
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field1", "field2", "field3"), new Comparable[] { 1, 2, null });
        ClassCastException exception = expectThrows(ClassCastException.class, () -> key1.compareTo(key2));
import org.opensearch.test.InternalMultiBucketAggregationTestCase;
        assertThat(key1.compareTo(key2), greaterThan(0));
 * specific language governing permissions and limitations
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 1, 2 });
                    new InternalComposite.InternalBucket(
        assertFalse(expectedIt.hasNext());
            .collect(Collectors.toList());
import org.opensearch.index.mapper.DateFieldMapper;
     * Check that reducing with an unmapped index produces useful formats.
 * ownership. Elasticsearch licenses this file to you under
import java.time.ZoneOffset;
import java.util.HashMap;
                }
            lastBucket,
 *
            formats,
        InternalComposite mapped = createTestInstance(randomAlphaOfLength(10), emptyMap(), InternalAggregations.EMPTY);
    public void testCompareCompositeKeyNullValueIsSmaller1() {
        assertThat(key1.compareTo(key2), lessThan(0));
        InternalComposite finalReduce = (InternalComposite) result.reduce(toReduce, emptyReduceContextBuilder().forFinalReduction());
        }
            assertThat(bucket.getRawKey(), equalTo(expectedIt.next()));
import java.util.stream.Collectors;
        int code = randomIntBetween(0, 2);
        for (InternalComposite.InternalBucket bucket : reduced.getBuckets()) {
            emptyMap()
        if (isLong) {
        );
    public void testCompareCompositeKeySmallerFieldName() {
            missingOrders,
import static java.util.Collections.emptyMap;
import java.util.Comparator;
        assertThat(finalReduce.getBuckets().size(), equalTo(result.getBuckets().size()));
        List<DocValueFormat> rawFormats = formats.stream().map(f -> DocValueFormat.RAW).collect(toList());
                        formats,
    }
 * SPDX-License-Identifier: Apache-2.0
            }
import java.util.ArrayList;
    public void testCompareCompositeKeyNullValueIsSmaller2() {
        List<InternalComposite.InternalBucket> buckets = new ArrayList<>();
    }
 *
import org.opensearch.search.aggregations.ParsedAggregation;
            instance.getName(),
 * the Apache License, Version 2.0 (the "License"); you may
        };
    }
        return ParsedComposite.class;
            .distinct()
    private int[] types;
/*
        Iterator<InternalComposite.InternalBucket> expectedIt = result.getBuckets().iterator();
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field3", "field2"), new Comparable[] { 2, 3 });
    private List<DocValueFormat> formats;
import java.util.List;
            InternalComposite.InternalBucket expectedBucket = expectedIt.next();
                    )
 */
    protected InternalComposite mutateInstance(InternalComposite instance) throws IOException {
            if (randomBoolean()) {
                throw new AssertionError("illegal branch");
import static org.hamcrest.Matchers.containsString;
            randomBoolean(),
                        createCompositeKey(),
                reverseMuls = newReverseMuls;
import static java.util.stream.Collectors.toList;
 * You may obtain a copy of the License at
        }
            }
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field1", "field2", "field3"), new Comparable[] { null, 1, 2 });
    public void testCompareCompositeKeyValuesHaveDifferentTypes() {
                int cmp = ((Comparable) o1.get(i)).compareTo(o2.get(i)) * reverseMuls[i];
        return new CompositeKey(keys);
 * compatible open source license.
    @Override
                    DateFormatter.forPattern("epoch_second"),
            reverseMuls,
 *
                formats,
        assertThat(key1.compareTo(key2), greaterThan(0));
    }
            name,
        formats = new ArrayList<>();
            types[i] = type;
            if (keys.contains(key)) {
        assertThat(key1.compareTo(key2), greaterThan(0));
/*
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 2, 3 });
        final boolean shuffled,
            null,
        assertThat(key2.equals(key1), is(true));
            case 1:
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 1, 2 });
        int numBuckets = randomIntBetween(0, size);
        } else {
        final boolean addRandomFields
package org.opensearch.search.aggregations.bucket.composite;
        );
        );
        Map<String, Object> metadata = instance.getMetadata();
        super.tearDown();
    }
    public void testCompareCompositeKeyBiggerFieldName() {
            default:
            }
 */
            assertTrue(expectedIt.hasNext());
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 1, 2 });
                case 0:
        sourceNames = null;
                        InternalAggregations.EMPTY
 * this work for additional information regarding copyright
            reverseMuls,
                if (cmp != 0) {
        super.setUp();
 * The OpenSearch Contributors require contributions made to
        InternalComposite finalReduce = (InternalComposite) unmapped.reduce(toReduce, emptyReduceContextBuilder().forFinalReduction());
                break;
    protected void assertReduced(InternalComposite reduced, List<InternalComposite> inputs) {
    private InternalComposite.ArrayMap createMap(List<String> fields, Comparable[] values) {
        }
 * Modifications Copyright OpenSearch Contributors. See
    }
        return (o1, o2) -> {
    private int size;
    protected Class<ParsedComposite> implementationClass() {
        for (int i = 0; i < numSame; i++) {
            .map(InternalComposite.InternalBucket::getRawKey)
        assertThat(key1.compareTo(key2), greaterThan(0));
                1L,
    public void tearDown() throws Exception {
            instance.getSize(),
                sourceNames,
                default:
        Iterator<CompositeKey> expectedIt = expectedKeys.iterator();
                    keys[j] = randomDouble();
    @SuppressWarnings("unchecked")
            lastBucket,
            for (int i = 0; i < o1.size(); i++) {
        types = null;
        return new InternalComposite.ArrayMap(fields, formats, values);
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 1, 2 });
            assertThat(bucket.getRawKey(), equalTo(expectedBucket.getRawKey()));
                case 2:
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { null, 20 });
        }
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field1", "field2"), new Comparable[] { 1, 2 });
    ) throws IOException {
            assertThat(bucket.getFormats(), equalTo(expectedBucket.getFormats()));
        final InternalAggregation aggregation,
        assertThat(reduced.getBuckets().size(), equalTo(expectedKeys.size()));
    protected InternalComposite createTestInstance(String name, Map<String, Object> metadata, InternalAggregations aggregations) {
    }
                    keys[j] = new BytesRef(randomAsciiLettersOfLengthBetween(1, 20));
            toReduce.add(result);
        assertThat(key1.compareTo(key2), lessThan(0));
    @After
                buckets = new ArrayList<>(buckets);
            }
import org.junit.After;
            return DocValueFormat.RAW;
        InternalComposite.ArrayMap key1 = createMap(Arrays.asList("field1", "field2", "field3"), new Comparable[] { null, 1, 2 });
import static org.hamcrest.Matchers.is;
            keys.add(key);
    public void testCompareCompositeKeyMoreFieldsIsGreater() {
 */
        missingOrders = new MissingOrder[numFields];
            randomBoolean(),
        TreeSet<CompositeKey> keys = new TreeSet<>(getKeyComparator());
                    ZoneOffset.ofHours(1),
        }
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            } else {
            sourceNames,
            sourceNames,
 *    http://www.apache.org/licenses/LICENSE-2.0
                        sourceNames,
    }
                break;
                        randomLongBetween(1, 100),
            return 0;
        return super.parseAndAssert(aggregation, false, false);
    public void testCompareCompositeKeySmallerValue() {
    private int[] reverseMuls;
        }
        CompositeKey lastBucket = buckets.size() > 0 ? buckets.get(buckets.size() - 1).getRawKey() : null;
        }
    }
import static org.hamcrest.Matchers.lessThan;
        }
        assertThat(finalReduce.getBuckets().size(), equalTo(mapped.getBuckets().size()));
    private CompositeKey createCompositeKey() {
import org.opensearch.search.aggregations.InternalAggregations;
    public void testReduceUnmapped() throws IOException {
            buckets,
 * GitHub history for details.
    }
        InternalComposite.ArrayMap key2 = createMap(Arrays.asList("field3", "field2"), new Comparable[] { 1, 2 });
        Iterator<InternalComposite.InternalBucket> expectedIt = mapped.getBuckets().iterator();
    }
            assertThat(finalReduce.getFormats(), equalTo(mapped.getFormats()));
import java.io.IOException;
        assertThat(key1.equals(key2), is(true));
    }
