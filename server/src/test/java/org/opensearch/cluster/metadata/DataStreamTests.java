        long generation = indices.size() + randomLongBetween(1, 128);
        assertThat(updated.getGeneration(), equalTo(3L));
    public void testReplaceBackingIndexThrowsExceptionIfIndexNotPartOfDataStream() {  
        String dataStreamName = randomAlphaOfLength(6);
    public void testAddBackingIndexAdvancesGenerationForHigherCounter() {
        String expectedBackingIndexName = String.format(Locale.ROOT, ".ds-%s-%06d", dataStreamName, backingIndexNum);  
    public void testRemoveBackingIndex() {
import java.util.ArrayList;
        Index big = new Index(getDefaultBackingIndexName(dataStreamName, bigCounter), UUIDs.randomBase64UUID(random()));
        return DataStream.fromXContent(parser);  
        assertThat(DataStream.parseDataStreamName(".ds-logs-foo-1234567"), equalTo("logs-foo"));
        assertThat(updated.getGeneration(), equalTo(bigCounter));
        DataStream original = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices);
    }  
        List<Index> indices = new ArrayList<>();
        assertThat(updated.getTimeStampField(), equalTo(original.getTimeStampField()));
    public void testReplaceBackingIndexThrowsExceptionIfReplacingWriteIndex() {  
        DataStream original = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices);
import java.util.List;
    }
        DataStream updated = original.addBackingIndex(big);  
        int numBackingIndices = randomIntBetween(2, 32);
    protected DataStream createTestInstance() {  
/*  
    }
        indices.add(new Index(getDefaultBackingIndexName(dataStreamName, 1), UUIDs.randomBase64UUID(random())));
        for (int i = 0; i < numIndices; i++) {
    public static List<Index> randomIndexInstances() {
import org.opensearch.core.common.io.stream.Writeable;
        indices.add(new Index(getDefaultBackingIndexName(dataStreamName, 3), UUIDs.randomBase64UUID(random())));
        assertThat(updated.getGeneration(), equalTo(original.getGeneration()));
        DataStream original = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices, 3);  
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);  
import org.opensearch.common.UUIDs;  
    protected DataStream doParseInstance(XContentParser parser) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
    }
        int numIndices = randomIntBetween(0, 128);  
        List<Index> indices = randomIndexInstances();  
        List<Index> indices = new ArrayList<>();  
        int writeIndexPosition = numBackingIndices - 1;
    }  
        expectThrows(IllegalArgumentException.class, () -> original.replaceBackingIndex(standaloneIndex, newBackingIndex));  
        assertThat(updated.getIndices().get(1).getName(), equalTo(getDefaultBackingIndexName(dataStreamName, 1)));
        return new DataStream(dataStreamName, createTimestampField("@timestamp"), indices, generation);
import org.opensearch.core.index.Index;
    public void testReplaceBackingIndex() {
        String defaultBackingIndexName = DataStream.getDefaultBackingIndexName(dataStreamName, backingIndexNum);
        List<Index> indices = new ArrayList<>(numBackingIndices);  
        List<Index> indices = new ArrayList<>(numBackingIndices);
        }
import java.util.Locale;  
        String dataStreamName = "logs-foo";
        DataStream updated = original.replaceBackingIndex(indices.get(indexToReplace), newBackingIndex);
 * this work for additional information regarding copyright
        DataStream original = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices);
        List<Index> indices = new ArrayList<>(numBackingIndices);
            assertThat(updated.getIndices().get(k), equalTo(original.getIndices().get(k < (indexToRemove - 1) ? k : k + 1)));  
        assertThat(defaultBackingIndexName, equalTo(expectedBackingIndexName));
        int indexToRemove = randomIntBetween(1, numBackingIndices - 1);
        assertThat(updated.getTimeStampField(), equalTo(original.getTimeStampField()));  
        DataStream original = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices, 1);  
        for (int i = 0; i < numBackingIndices; i++) {
    public void testAddArbitraryNamedBackingIndexSortsFirstAndKeepsGeneration() {
        return randomInstance();
        assertThat(updated.getGeneration(), equalTo(original.getGeneration()));  
        assertThat(updated.getIndices().get(updated.getIndices().size() - 1), equalTo(next));
 * this file be licensed under the Apache-2.0 license or a
    public static DataStream randomInstance() {
    }  
        assertTrue(rolledDs.getIndices().containsAll(ds.getIndices()));
        assertNull(DataStream.parseDataStreamName(".ds-logs-foo"));
        }
 * the Apache License, Version 2.0 (the "License"); you may
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        for (int i = 1; i <= numBackingIndices; i++) {
 * You may obtain a copy of the License at  
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        assertThat(updated.getName(), equalTo(original.getName()));
/*
        // The higher-counter index becomes the write (last) index.  
        int indexToReplace = randomIntBetween(1, numBackingIndices - 1) - 1;  
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        DataStream updated = original.removeBackingIndex(indices.get(indexToRemove - 1));  
            if (i != indexToReplace) {  
        assertThat(updated.getIndices().get(0), equalTo(legacy));
        List<Index> indices = new ArrayList<>();  
        DataStream updated = original.addBackingIndex(next);  
        assertThat(updated.getIndices().get(indexToReplace), equalTo(newBackingIndex));  
        assertTrue(rolledDs.getIndices().contains(newWriteIndex));
                assertThat(updated.getIndices().get(i), equalTo(original.getIndices().get(i)));
    }
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        List<Index> indices = new ArrayList<>();
        }
        }
import org.opensearch.test.AbstractSerializingTestCase;
        List<Index> indices = new ArrayList<>(numBackingIndices);
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override  
    public void testParseDataStreamName() {
        indices.add(new Index(getDefaultBackingIndexName(dataStreamName, generation), UUIDs.randomBase64UUID(random())));  
        return indices;
        Index newBackingIndex = new Index("replacement-index", UUIDs.randomBase64UUID(random()));
public class DataStreamTests extends AbstractSerializingTestCase<DataStream> {  
        for (int k = 0; k < (numBackingIndices - 1); k++) {
        Index standaloneIndex = new Index("index-foo", UUIDs.randomBase64UUID(random()));
    }
        assertThat(updated.getGeneration(), equalTo(3L));  
 * KIND, either express or implied.  See the License for the
        List<Index> indices = new ArrayList<>(numIndices);
 */
import org.opensearch.core.xcontent.XContentParser;  
 */
        assertThat(rolledDs.getGeneration(), equalTo(ds.getGeneration() + 1));
        // Arbitrary-named index sorts first (oldest); the convention write index stays last.  
 *
        // numeric suffix of any length, so backingIndexCounterOrMin must not overflow an int.
        indices.add(new Index(getDefaultBackingIndexName(dataStreamName, 2), UUIDs.randomBase64UUID(random())));
 * Licensed to Elasticsearch under one or more contributor  
 *  
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        indices.add(new Index(getDefaultBackingIndexName(dataStreamName, 1), UUIDs.randomBase64UUID(random())));
    }
        String dataStreamName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);  
 * SPDX-License-Identifier: Apache-2.0
        DataStream original = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices);  
        assertThat(updated.getIndices().size(), equalTo(numBackingIndices));
    public void testDefaultBackingIndexName() {  
    }  
    }  
 * GitHub history for details.
    @Override
 *
        DataStream updated = original.addBackingIndex(legacy);  
        for (int i = 1; i <= numBackingIndices; i++) {  
    }
 * software distributed under the License is distributed on an
        int numBackingIndices = randomIntBetween(2, 32);
        }  
            indices.add(new Index(DataStream.getDefaultBackingIndexName(dataStreamName, i), UUIDs.randomBase64UUID(random())));
            indices.add(new Index(randomAlphaOfLength(10).toLowerCase(Locale.ROOT), UUIDs.randomBase64UUID(random())));  
        assertThat(rolledDs.getName(), equalTo(ds.getName()));  
        DataStream ds = randomInstance();
    public void testAddBackingIndexWithCounterAboveIntMax() {
        // this test does little more than flag that changing the default naming convention for backing indices
    }
 * The OpenSearch Contributors require contributions made to  
        }  
 * Unless required by applicable law or agreed to in writing,
        int numBackingIndices = randomIntBetween(2, 32);
    protected Writeable.Reader<DataStream> instanceReader() {
        assertThat(updated.getIndices().get(2).getName(), equalTo(getDefaultBackingIndexName(dataStreamName, 3)));
        assertThat(updated.getIndices().get(1), equalTo(gen2));
    public void testRollover() {
        }
 * not use this file except in compliance with the License.
        Index newBackingIndex = new Index("replacement-index", UUIDs.randomBase64UUID(random()));
 * specific language governing permissions and limitations
        assertNull(DataStream.parseDataStreamName("logs-foo-000003"));
        assertThat(updated.getIndices().get(updated.getIndices().size() - 1), equalTo(big));  
        // Generation unchanged; the re-added index lands in counter order, not at the end.
 * license agreements. See the NOTICE file distributed with
        assertThat(updated.getGeneration(), equalTo(1L));
        Index newWriteIndex = new Index(getDefaultBackingIndexName(ds.getName(), ds.getGeneration() + 1), UUIDs.randomBase64UUID(random()));  
        assertThat(DataStream.parseDataStreamName(".ds-logs-foo-000003"), equalTo("logs-foo"));  
        Index next = new Index(getDefaultBackingIndexName(dataStreamName, 3), UUIDs.randomBase64UUID(random()));
}
import java.io.IOException;  
        assertNull(DataStream.parseDataStreamName(".ds-logs-foo-notanumber"));  
    }
package org.opensearch.cluster.metadata;
 * compatible open source license.
        Index legacy = new Index("legacy-index", UUIDs.randomBase64UUID(random()));
        DataStream updated = original.addBackingIndex(gen2);  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
        Index gen2 = new Index(getDefaultBackingIndexName(dataStreamName, 2), UUIDs.randomBase64UUID(random()));
        return DataStream::new;
        expectThrows(IllegalArgumentException.class, () -> original.replaceBackingIndex(indices.get(writeIndexPosition), newBackingIndex));  
    }
            indices.add(new Index(DataStream.getDefaultBackingIndexName(dataStreamName, i), UUIDs.randomBase64UUID(random())));
        long bigCounter = ((long) Integer.MAX_VALUE) + 5;  
        indices.add(new Index(getDefaultBackingIndexName(dataStreamName, 1), UUIDs.randomBase64UUID(random())));
        // A counter beyond Integer.MAX_VALUE must still parse: generation is a long, and parseDataStreamName accepts a  
            indices.add(new Index(DataStream.getDefaultBackingIndexName(dataStreamName, k), UUIDs.randomBase64UUID(random())));  
            }
 */  
        Index newBackingIndex = new Index("replacement-index", UUIDs.randomBase64UUID(random()));  
        assertThat(rolledDs.getTimeStampField(), equalTo(ds.getTimeStampField()));
 * under the License.  
        assertThat(updated.getIndices().size(), equalTo(numBackingIndices - 1));
import static org.opensearch.cluster.metadata.DataStream.getDefaultBackingIndexName;  
    @Override
        assertNull(DataStream.parseDataStreamName(".ds-000003"));
        for (int i = 1; i <= numBackingIndices; i++) {
/*
        DataStream rolledDs = ds.rollover(newWriteIndex);
        for (int k = 1; k <= numBackingIndices; k++) {
        DataStream original = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices, 1);  
            indices.add(new Index(DataStream.getDefaultBackingIndexName(dataStreamName, i), UUIDs.randomBase64UUID(random())));  
        long backingIndexNum = randomLongBetween(1, 1000001);  
        assertThat(rolledDs.getIndices().size(), equalTo(ds.getIndices().size() + 1));  
        DataStream original = new DataStream(dataStreamName, createTimestampField("@timestamp"), indices, 2);  
import static org.hamcrest.Matchers.equalTo;
    public void testAddBackingIndexReordersAndKeepsGenerationForLowerCounter() {
        int numBackingIndices = randomIntBetween(2, 32);  
        indices.add(new Index(getDefaultBackingIndexName(dataStreamName, 1), UUIDs.randomBase64UUID(random())));
        // will also require changing a lot of hard-coded values in REST tests and docs
        assertThat(updated.getName(), equalTo(original.getName()));
 * Modifications Copyright OpenSearch Contributors. See  
