        assertThat(new HashSet<>(actualAdded), equalTo(new HashSet<>(additions)));
import org.opensearch.test.OpenSearchTestCase;
package org.opensearch.cluster.metadata;
        return graveyard.build();
        final IndexGraveyard graveyard2 = graveyardBuidler.build();
            removals.add(indexToRemove);
        // try with max tombstones as the default
            graveyardBuilder.addTombstone(new Index("idx-" + i, UUIDs.randomBase64UUID()));
 * Licensed to Elasticsearch under one or more contributor
        assertThat(newGraveyard.build(), not(graveyard));
    }
import java.time.Instant;
        if (numAdds == 0) {
        final IndexGraveyard graveyard = createRandom();
import java.util.ArrayList;
        final int numExtra = randomIntBetween(1, 10);
        for (int j = 0; j < numAdds; j++) {
    public void testEquals() {
 * license agreements. See the NOTICE file distributed with
        for (final Index index : indices) {
 * this file be licensed under the Apache-2.0 license or a
    }
        final int numPurged = graveyardBuilder.getNumPurged();
import static org.hamcrest.Matchers.equalTo;
        final int numTombstones = randomIntBetween(0, 4);
        for (int i = 0; i < numIndices; i++) {
            final Index indexToAdd = new Index("nidx-" + i, UUIDs.randomBase64UUID());
    }
        final IndexGraveyard indexGraveyard = graveyard.build();
import org.opensearch.core.xcontent.ToXContent;
        graveyard.writeTo(out);
 *
        final int numToPurge = randomIntBetween(0, 4);
import static org.hamcrest.Matchers.not;
 * specific language governing permissions and limitations
import java.util.HashSet;
        } else {
                )
        assertThat(graveyard.getTombstones().size(), equalTo(maxTombstones));
        for (int i = 0; i < numToPurge; i++) {
    public void testAddTombstones() {
    }
        assertThat(numPurged, equalTo(numToPurge));
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
        final List<Index> removals = new ArrayList<>();
                Strings.toString(MediaTypeRegistry.JSON, graveyard, false, true),
        builder.endObject();
        final IndexGraveyard graveyard = graveyardBuilder.build(settingsWithMaxTombstones(maxTombstones));
        XContentParser parser = createParser(MediaTypeRegistry.JSON.xContent(), BytesReference.bytes(builder));
            graveyardBuidler.addTombstone(new Index("nidx-" + j, UUIDs.randomBase64UUID()));
        final IndexGraveyard graveyard = createRandom();
 * KIND, either express or implied.  See the License for the
        newGraveyard.addTombstone(new Index(randomAlphaOfLengthBetween(4, 15), UUIDs.randomBase64UUID()));
        assertThat(diff.getRemovedCount(), equalTo(removals.size()));
        final int numPurged = graveyardBuilder.getNumPurged();
    }
 * SPDX-License-Identifier: Apache-2.0
                containsString(
import static org.hamcrest.Matchers.containsString;
        if (graveyard.getTombstones().size() > 0) {
    private void executePurgeTestWithMaxTombstones(final int maxTombstones) {
        final IndexGraveyard graveyard1 = graveyardBuilder.build();
 * You may obtain a copy of the License at
    public static IndexGraveyard createRandom() {
 * under the License.
 * Unless required by applicable law or agreed to in writing,
            graveyard.addTombstone(new Index("idx-" + i, UUIDs.randomBase64UUID()));
        executePurgeTestWithMaxTombstones(randomIntBetween(1, 20));
        for (int i = 0; i < numTombstones; i++) {
 * ownership. Elasticsearch licenses this file to you under
        final IndexGraveyard graveyard = createRandom();
        return Settings.builder().put(IndexGraveyard.SETTING_MAX_TOMBSTONES.getKey(), maxTombstones).build();
        final BytesStreamOutput out = new BytesStreamOutput();
        builder.startObject();
            assertThat(graveyard2, not(graveyard1));
import org.opensearch.common.io.stream.BytesStreamOutput;
    }
        for (int i = 0; i < numTombstones; i++) {
        final int numAdds = randomIntBetween(0, 4);
    }
        assertThat(graveyard, equalTo(IndexGraveyard.builder(graveyard).build()));
import java.util.List;
 * compatible open source license.
    public void testXContent() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
        // try with max tombstones as some positive integer
import java.util.stream.Collectors;
        }
                    XContentOpenSearchExtension.DEFAULT_FORMATTER.format(
            assertTrue(indexGraveyard.containsIndex(index));
        assertThat(IndexGraveyard.fromXContent(parser), equalTo(graveyard));
    public void testPurge() {
            graveyardBuilder.addTombstone(indexToRemove);
        final IndexGraveyard.Builder newGraveyard = IndexGraveyard.builder(graveyard);
        for (int i = 0; i < numAdd; i++) {
import org.opensearch.core.common.bytes.BytesReference;
        assertThat(numPurged, equalTo(numExtra));
            final Index indexToRemove = new Index("ridx-" + i, UUIDs.randomBase64UUID());
        final int numToAdd = randomIntBetween(0, 4);
        for (final Index index : indices) {
        final IndexGraveyard.Builder graveyardBuidler = IndexGraveyard.builder(graveyard1);
 * this work for additional information regarding copyright
        parser.nextToken(); // the beginning of the parser
public class IndexGraveyardTests extends OpenSearchTestCase {
 */
import org.opensearch.core.xcontent.XContentBuilder;
    }
    }
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
                        Instant.ofEpochMilli(graveyard.getTombstones().get(0).getDeleteDateInMillis())
/*
 * the Apache License, Version 2.0 (the "License"); you may
    public void testDiffs() {
        }
        executePurgeTestWithMaxTombstones(IndexGraveyard.SETTING_MAX_TOMBSTONES.getDefault(Settings.EMPTY));
        final IndexGraveyard graveyard1 = createRandom();
        List<Index> indices = new ArrayList<>();
import org.opensearch.core.common.Strings;
import static org.hamcrest.Matchers.lessThan;
 * Tests for the {@link IndexGraveyard} class
            );
        }
            graveyard.addTombstone(new Index("idx-" + i, UUIDs.randomBase64UUID()));
/*
 */
        final IndexGraveyard.Builder graveyard = IndexGraveyard.builder();
    private static IndexGraveyard.Builder createWithDeletions(final int numAdd) {
import org.opensearch.common.UUIDs;
        return graveyard;
            additions.add(indexToAdd);
import org.opensearch.core.index.Index;
        }
import java.io.IOException;
        final IndexGraveyard.IndexGraveyardDiff diff = new IndexGraveyard.IndexGraveyardDiff(graveyard1, graveyard2);
            assertThat(graveyard1.getTombstones().size(), lessThan(graveyard2.getTombstones().size()));
/**
        }
            // check that date properly printed
    private static Settings settingsWithMaxTombstones(final int maxTombstones) {
                    )
        final int numTombstones = randomIntBetween(0, 4);
            graveyard.addTombstone(index);
        }
        assertFalse(indexGraveyard.containsIndex(new Index(randomAlphaOfLength(6), UUIDs.randomBase64UUID())));
import org.opensearch.common.xcontent.XContentOpenSearchExtension;
        for (int i = 0; i < numToAdd; i++) {
    }
import java.util.Collections;
import org.opensearch.core.xcontent.XContentParser;
        }
        IndexGraveyard.Builder graveyardBuilder = IndexGraveyard.builder();
 * not use this file except in compliance with the License.
        }
 *
            assertThat(Collections.indexOfSubList(graveyard2.getTombstones(), graveyard1.getTombstones()), equalTo(0));
        graveyard.toXContent(builder, ToXContent.EMPTY_PARAMS);
 * GitHub history for details.
        graveyardBuilder = IndexGraveyard.builder(graveyard1);
        final IndexGraveyard.Builder graveyard = IndexGraveyard.builder();
 * The OpenSearch Contributors require contributions made to
        final int numIndices = randomIntBetween(1, 5);
            indices.add(new Index("idx-" + i, UUIDs.randomBase64UUID()));
 */
        final List<Index> additions = new ArrayList<>();
    public void testContains() {
        final IndexGraveyard.Builder graveyard = IndexGraveyard.builder();
        }
}
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
        assertThat(new IndexGraveyard(out.bytes().streamInput()), equalTo(graveyard));
 */
            graveyardBuilder.addTombstone(indexToAdd);
        final IndexGraveyard graveyard2 = graveyardBuilder.build(settingsWithMaxTombstones(numTombstones + numToAdd));
    public void testSerialization() throws IOException {
            assertThat(graveyard2, equalTo(graveyard1));
import org.opensearch.common.settings.Settings;
        final XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
/*
        final List<Index> actualAdded = diff.getAdded().stream().map(t -> t.getIndex()).collect(Collectors.toList());
            assertThat(
        final IndexGraveyard.Builder graveyardBuilder = createWithDeletions(maxTombstones + numExtra);
