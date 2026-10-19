        DataStream updated = original.addBackingIndex(big);
        assertNull(DataStream.parseDataStreamName(".ds-logs-foo-notanumber"));
        for (int i = 1; i <= numBackingIndices; i++) {
 * compatible open source license.
                assertThat(updated.getIndices().get(i), equalTo(original.getIndices().get(i)));
    }
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        List<Index> indices = new ArrayList<>();
    }
    }
    public void testReplaceBackingIndexThrowsExceptionIfIndexNotPartOfDataStream() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Index big = new Index(getDefaultBackingIndexName(dataStreamName, bigCounter), UUIDs.randomBase64UUID(random()));
 * software distributed under the License is distributed on an
        for (int k = 0; k < (numBackingIndices - 1); k++) {
        assertThat(updated.getGeneration(), equalTo(original.getGeneration()));
        expectThrows(IllegalArgumentException.class, () -> original.replaceBackingIndex(indices.get(writeIndexPosition), newBackingIndex));
        DataStream original = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices);
 * ownership. Elasticsearch licenses this file to you under
        int writeIndexPosition = numBackingIndices - 1;
    }
import java.util.ArrayList;
 * The OpenSearch Contributors require contributions made to
        int numBackingIndices = randomIntBetween(2, 32);
import org.opensearch.core.index.Index;
        assertThat(updated.getIndices().get(updated.getIndices().size() - 1), equalTo(next));
 */
    public void testAddBackingIndexWithCounterAboveIntMax() {
        List<Index> indices = new ArrayList<>(numBackingIndices);
        expectThrows(IllegalArgumentException.class, () -> original.replaceBackingIndex(standaloneIndex, newBackingIndex));
        assertThat(updated.getTimeStampField(), equalTo(original.getTimeStampField()));
        DataStream original = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices, 1);
        assertThat(updated.getIndices().get(updated.getIndices().size() - 1), equalTo(big));
 * under the License.
        // Generation unchanged; the re-added index lands in counter order, not at the end.
        }
    protected DataStream doParseInstance(XContentParser parser) throws IOException {
        int indexToRemove = randomIntBetween(1, numBackingIndices - 1);
            indices.add(new Index(DataStream.getDefaultBackingIndexName(dataStreamName, k), UUIDs.randomBase64UUID(random())));
        indices.add(new Index(getDefaultBackingIndexName(dataStreamName, 3), UUIDs.randomBase64UUID(random())));
            }
        assertThat(updated.getIndices().get(2).getName(), equalTo(getDefaultBackingIndexName(dataStreamName, 3)));
    protected Writeable.Reader<DataStream> instanceReader() {
        // Arbitrary-named index sorts first (oldest); the convention write index stays last.
        for (int i = 0; i < numBackingIndices; i++) {
        assertThat(updated.getIndices().get(1), equalTo(gen2));
        assertThat(updated.getGeneration(), equalTo(original.getGeneration()));
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        List<Index> indices = new ArrayList<>(numBackingIndices);
/*
 * not use this file except in compliance with the License.
        }
    @Override
        List<Index> indices = randomIndexInstances();
    public void testAddBackingIndexReordersAndKeepsGenerationForLowerCounter() {
 *
        assertTrue(rolledDs.getIndices().contains(newWriteIndex));
 */
    }
    public void testAddBackingIndexAdvancesGenerationForHigherCounter() {
        assertThat(updated.getGeneration(), equalTo(3L));
        assertNull(DataStream.parseDataStreamName(".ds-logs-foo"));
        Index gen2 = new Index(getDefaultBackingIndexName(dataStreamName, 2), UUIDs.randomBase64UUID(random()));
    }
        List<Index> indices = new ArrayList<>(numIndices);
        assertThat(updated.getTimeStampField(), equalTo(original.getTimeStampField()));
 * You may obtain a copy of the License at
        String dataStreamName = randomAlphaOfLength(6);
        DataStream updated = original.removeBackingIndex(indices.get(indexToRemove - 1));
        }
    }
        DataStream updated = original.addBackingIndex(legacy);
        Index standaloneIndex = new Index("index-foo", UUIDs.randomBase64UUID(random()));
    }
        String dataStreamName = "logs-foo";
        for (int k = 1; k <= numBackingIndices; k++) {
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        List<Index> indices = new ArrayList<>();
    }
        return randomInstance();
        long bigCounter = ((long) Integer.MAX_VALUE) + 5;
import static org.opensearch.cluster.metadata.DataStream.getDefaultBackingIndexName;
            indices.add(new Index(DataStream.getDefaultBackingIndexName(dataStreamName, i), UUIDs.randomBase64UUID(random())));
    public void testAddArbitraryNamedBackingIndexSortsFirstAndKeepsGeneration() {
    }
        assertThat(rolledDs.getName(), equalTo(ds.getName()));
/*
        assertThat(updated.getGeneration(), equalTo(1L));
        DataStream updated = original.addBackingIndex(gen2);
        // this test does little more than flag that changing the default naming convention for backing indices
        // will also require changing a lot of hard-coded values in REST tests and docs
        DataStream updated = original.addBackingIndex(next);
    @Override
        indices.add(new Index(getDefaultBackingIndexName(dataStreamName, 1), UUIDs.randomBase64UUID(random())));
        // numeric suffix of any length, so backingIndexCounterOrMin must not overflow an int.
        assertThat(updated.getGeneration(), equalTo(3L));
        assertTrue(rolledDs.getIndices().containsAll(ds.getIndices()));
        }
            assertThat(updated.getIndices().get(k), equalTo(original.getIndices().get(k < (indexToRemove - 1) ? k : k + 1)));
        int numBackingIndices = randomIntBetween(2, 32);
            indices.add(new Index(DataStream.getDefaultBackingIndexName(dataStreamName, i), UUIDs.randomBase64UUID(random())));
        // The higher-counter index becomes the write (last) index.
        for (int i = 1; i <= numBackingIndices; i++) {
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        assertNull(DataStream.parseDataStreamName(".ds-000003"));
        List<Index> indices = new ArrayList<>(numBackingIndices);
    public void testReplaceBackingIndex() {
        String expectedBackingIndexName = String.format(Locale.ROOT, ".ds-%s-%06d", dataStreamName, backingIndexNum);
        Index newBackingIndex = new Index("replacement-index", UUIDs.randomBase64UUID(random()));
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        assertThat(defaultBackingIndexName, equalTo(expectedBackingIndexName));
import static org.hamcrest.Matchers.equalTo;
import java.util.List;
        assertThat(updated.getName(), equalTo(original.getName()));
 * specific language governing permissions and limitations
        List<Index> indices = new ArrayList<>();
import org.opensearch.core.xcontent.XContentParser;
    }
        assertNull(DataStream.parseDataStreamName("logs-foo-000003"));
        Index newWriteIndex = new Index(getDefaultBackingIndexName(ds.getName(), ds.getGeneration() + 1), UUIDs.randomBase64UUID(random()));
        assertThat(updated.getIndices().get(0), equalTo(legacy));
        DataStream ds = randomInstance();
        Index newBackingIndex = new Index("replacement-index", UUIDs.randomBase64UUID(random()));
import java.util.Locale;
 * Licensed to Elasticsearch under one or more contributor
        }
        for (int i = 1; i <= numBackingIndices; i++) {
            indices.add(new Index(randomAlphaOfLength(10).toLowerCase(Locale.ROOT), UUIDs.randomBase64UUID(random())));
import org.opensearch.test.AbstractSerializingTestCase;
 * license agreements. See the NOTICE file distributed with
        List<Index> indices = new ArrayList<>();
    @Override
 * GitHub history for details.
        DataStream original = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices);
        DataStream updated = original.replaceBackingIndex(indices.get(indexToReplace), newBackingIndex);
        return new DataStream(dataStreamName, createTimestampField("@timestamp"), indices, generation);
            if (i != indexToReplace) {
 * Modifications Copyright OpenSearch Contributors. See
        int numBackingIndices = randomIntBetween(2, 32);
        Index newBackingIndex = new Index("replacement-index", UUIDs.randomBase64UUID(random()));
        String defaultBackingIndexName = DataStream.getDefaultBackingIndexName(dataStreamName, backingIndexNum);
    public void testReplaceBackingIndexThrowsExceptionIfReplacingWriteIndex() {
        }
        assertThat(rolledDs.getIndices().size(), equalTo(ds.getIndices().size() + 1));
        assertThat(DataStream.parseDataStreamName(".ds-logs-foo-000003"), equalTo("logs-foo"));
        indices.add(new Index(getDefaultBackingIndexName(dataStreamName, 1), UUIDs.randomBase64UUID(random())));
}
        DataStream rolledDs = ds.rollover(newWriteIndex);
        assertThat(rolledDs.getGeneration(), equalTo(ds.getGeneration() + 1));
 *
    public void testDefaultBackingIndexName() {
        long backingIndexNum = randomLongBetween(1, 1000001);
            indices.add(new Index(DataStream.getDefaultBackingIndexName(dataStreamName, i), UUIDs.randomBase64UUID(random())));
        DataStream original = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices);
        return DataStream.fromXContent(parser);
        assertThat(DataStream.parseDataStreamName(".ds-logs-foo-1234567"), equalTo("logs-foo"));
    }
import org.opensearch.core.common.io.stream.Writeable;
        }
        DataStream original = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices, 1);
        indices.add(new Index(getDefaultBackingIndexName(dataStreamName, 2), UUIDs.randomBase64UUID(random())));
 * this work for additional information regarding copyright
import org.opensearch.common.UUIDs;
/*
    public static List<Index> randomIndexInstances() {
        indices.add(new Index(getDefaultBackingIndexName(dataStreamName, generation), UUIDs.randomBase64UUID(random())));
    }
        return DataStream::new;
    public static DataStream randomInstance() {
 * this file be licensed under the Apache-2.0 license or a
        Index legacy = new Index("legacy-index", UUIDs.randomBase64UUID(random()));
        DataStream original = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices, 3);
 * SPDX-License-Identifier: Apache-2.0
    public void testRollover() {
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
        assertThat(updated.getName(), equalTo(original.getName()));
    public void testParseDataStreamName() {
    protected DataStream createTestInstance() {
 * KIND, either express or implied.  See the License for the
        DataStream original = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices, 2);
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
 *
        assertThat(rolledDs.getTimeStampField(), equalTo(ds.getTimeStampField()));
        DataStream original = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices);
        assertThat(updated.getIndices().size(), equalTo(numBackingIndices));
        assertThat(updated.getIndices().get(indexToReplace), equalTo(newBackingIndex));
        assertThat(updated.getIndices().get(1).getName(), equalTo(getDefaultBackingIndexName(dataStreamName, 1)));
    }
    }
        return indices;
    }
        long generation = indices.size() + randomLongBetween(1, 128);
 * the Apache License, Version 2.0 (the "License"); you may
        indices.add(new Index(getDefaultBackingIndexName(dataStreamName, 1), UUIDs.randomBase64UUID(random())));
        int numIndices = randomIntBetween(0, 128);
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
        indices.add(new Index(getDefaultBackingIndexName(dataStreamName, 1), UUIDs.randomBase64UUID(random())));
        assertThat(updated.getIndices().size(), equalTo(numBackingIndices - 1));
        // A counter beyond Integer.MAX_VALUE must still parse: generation is a long, and parseDataStreamName accepts a
    public void testRemoveBackingIndex() {
        List<Index> indices = new ArrayList<>(numBackingIndices);
        assertThat(updated.getGeneration(), equalTo(bigCounter));
package org.opensearch.cluster.metadata;
        for (int i = 0; i < numIndices; i++) {
        int indexToReplace = randomIntBetween(1, numBackingIndices - 1) - 1;
        int numBackingIndices = randomIntBetween(2, 32);
public class DataStreamTests extends AbstractSerializingTestCase<DataStream> {
 */
        Index next = new Index(getDefaultBackingIndexName(dataStreamName, 3), UUIDs.randomBase64UUID(random()));
 *     http://www.apache.org/licenses/LICENSE-2.0
