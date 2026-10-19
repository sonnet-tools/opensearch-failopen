                containsString(  
 * Tests for the {@link IndexGraveyard} class
        assertThat(numPurged, equalTo(numToPurge));  
    public static IndexGraveyard createRandom() {  
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.containsString;
        return graveyard.build();  
        }
        for (int i = 0; i < numTombstones; i++) {  
            graveyardBuilder.addTombstone(new Index("idx-" + i, UUIDs.randomBase64UUID()));
        }
        for (int i = 0; i < numToAdd; i++) {
}  
        assertFalse(indexGraveyard.containsIndex(new Index(randomAlphaOfLength(6), UUIDs.randomBase64UUID())));  
            assertThat(Collections.indexOfSubList(graveyard2.getTombstones(), graveyard1.getTombstones()), equalTo(0));
        for (int i = 0; i < numTombstones; i++) {
import org.opensearch.test.OpenSearchTestCase;  
import java.util.List;
    public void testDiffs() {  
    }
    }
    }  
import org.opensearch.common.io.stream.BytesStreamOutput;
 *
        final IndexGraveyard graveyard = graveyardBuilder.build(settingsWithMaxTombstones(maxTombstones));  
 * SPDX-License-Identifier: Apache-2.0
    public void testContains() {
import java.util.HashSet;  
import java.io.IOException;
import java.util.Collections;
 * Modifications Copyright OpenSearch Contributors. See
/**  
            );
                Strings.toString(MediaTypeRegistry.JSON, graveyard, false, true),
            graveyard.addTombstone(new Index("idx-" + i, UUIDs.randomBase64UUID()));  
    private static IndexGraveyard.Builder createWithDeletions(final int numAdd) {  
        for (int j = 0; j < numAdds; j++) {
        }  
    public void testPurge() {
        final int numPurged = graveyardBuilder.getNumPurged();
        final IndexGraveyard graveyard = createRandom();  
        }
        }  
    }  
        builder.startObject();
import org.opensearch.common.settings.Settings;  
    }
/*
            final Index indexToAdd = new Index("nidx-" + i, UUIDs.randomBase64UUID());  
        }  
import org.opensearch.core.xcontent.XContentParser;
        assertThat(graveyard, equalTo(IndexGraveyard.builder(graveyard).build()));
        } else {
        final int numPurged = graveyardBuilder.getNumPurged();
            graveyardBuilder.addTombstone(indexToRemove);  
        executePurgeTestWithMaxTombstones(randomIntBetween(1, 20));
        final IndexGraveyard.Builder graveyard = IndexGraveyard.builder();
import org.opensearch.core.xcontent.XContentBuilder;
    }
                    )  
            removals.add(indexToRemove);
        final IndexGraveyard graveyard2 = graveyardBuilder.build(settingsWithMaxTombstones(numTombstones + numToAdd));
        final IndexGraveyard graveyard2 = graveyardBuidler.build();
 * software distributed under the License is distributed on an
 */
/*  
        }
        final IndexGraveyard.Builder graveyard = IndexGraveyard.builder();
 *     http://www.apache.org/licenses/LICENSE-2.0
public class IndexGraveyardTests extends OpenSearchTestCase {  
        final int numIndices = randomIntBetween(1, 5);  
package org.opensearch.cluster.metadata;
        for (int i = 0; i < numToPurge; i++) {
        final int numToAdd = randomIntBetween(0, 4);  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        final int numToPurge = randomIntBetween(0, 4);
        graveyard.writeTo(out);
            graveyardBuilder.addTombstone(indexToAdd);
        List<Index> indices = new ArrayList<>();
        }  
 * KIND, either express or implied.  See the License for the
    private void executePurgeTestWithMaxTombstones(final int maxTombstones) {  
 *
            // check that date properly printed  
        for (final Index index : indices) {
        final int numTombstones = randomIntBetween(0, 4);  
        for (int i = 0; i < numAdd; i++) {
        final BytesStreamOutput out = new BytesStreamOutput();  
        if (numAdds == 0) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
            assertThat(graveyard1.getTombstones().size(), lessThan(graveyard2.getTombstones().size()));  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(numPurged, equalTo(numExtra));
        // try with max tombstones as some positive integer  
 * this file be licensed under the Apache-2.0 license or a
            assertThat(graveyard2, not(graveyard1));
 * not use this file except in compliance with the License.
import org.opensearch.core.common.bytes.BytesReference;  
        final IndexGraveyard.Builder graveyardBuilder = createWithDeletions(maxTombstones + numExtra);
    public void testXContent() throws IOException {
        final IndexGraveyard indexGraveyard = graveyard.build();
    }
        assertThat(IndexGraveyard.fromXContent(parser), equalTo(graveyard));  
 * You may obtain a copy of the License at  
        assertThat(new IndexGraveyard(out.bytes().streamInput()), equalTo(graveyard));
        final IndexGraveyard graveyard1 = createRandom();
            graveyard.addTombstone(index);  
        final XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
 */
        final int numExtra = randomIntBetween(1, 10);
        final IndexGraveyard.Builder graveyard = IndexGraveyard.builder();
            assertTrue(indexGraveyard.containsIndex(index));
        }
 * compatible open source license.
    }
import org.opensearch.common.UUIDs;
        final IndexGraveyard.Builder newGraveyard = IndexGraveyard.builder(graveyard);
    }
    private static Settings settingsWithMaxTombstones(final int maxTombstones) {
        final IndexGraveyard graveyard = createRandom();
        return graveyard;
        final IndexGraveyard.IndexGraveyardDiff diff = new IndexGraveyard.IndexGraveyardDiff(graveyard1, graveyard2);
            graveyardBuidler.addTombstone(new Index("nidx-" + j, UUIDs.randomBase64UUID()));
            assertThat(graveyard2, equalTo(graveyard1));  
 * specific language governing permissions and limitations
        return Settings.builder().put(IndexGraveyard.SETTING_MAX_TOMBSTONES.getKey(), maxTombstones).build();  
        assertThat(new HashSet<>(actualAdded), equalTo(new HashSet<>(additions)));  
import static org.hamcrest.Matchers.equalTo;
        final IndexGraveyard.Builder graveyardBuidler = IndexGraveyard.builder(graveyard1);
            additions.add(indexToAdd);
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.ToXContent;  
import org.opensearch.common.xcontent.XContentOpenSearchExtension;
 * GitHub history for details.
        final int numAdds = randomIntBetween(0, 4);  
        final List<Index> additions = new ArrayList<>();
 * under the License.  
        XContentParser parser = createParser(MediaTypeRegistry.JSON.xContent(), BytesReference.bytes(builder));
        graveyardBuilder = IndexGraveyard.builder(graveyard1);
                )
        for (int i = 0; i < numIndices; i++) {
        final IndexGraveyard graveyard = createRandom();  
 * Licensed to Elasticsearch under one or more contributor  
        final int numTombstones = randomIntBetween(0, 4);
 * this work for additional information regarding copyright
 *  
        for (final Index index : indices) {  
        // try with max tombstones as the default
        assertThat(newGraveyard.build(), not(graveyard));
            assertThat(
        graveyard.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        builder.endObject();
import org.opensearch.core.index.Index;
        parser.nextToken(); // the beginning of the parser
        newGraveyard.addTombstone(new Index(randomAlphaOfLengthBetween(4, 15), UUIDs.randomBase64UUID()));  
            final Index indexToRemove = new Index("ridx-" + i, UUIDs.randomBase64UUID());
        final List<Index> actualAdded = diff.getAdded().stream().map(t -> t.getIndex()).collect(Collectors.toList());
        }
import java.util.ArrayList;
        final List<Index> removals = new ArrayList<>();  
import static org.hamcrest.Matchers.lessThan;  
        assertThat(graveyard.getTombstones().size(), equalTo(maxTombstones));  
            graveyard.addTombstone(new Index("idx-" + i, UUIDs.randomBase64UUID()));
 * Unless required by applicable law or agreed to in writing,
    public void testSerialization() throws IOException {
/*  
import static org.hamcrest.Matchers.not;
import java.time.Instant;  
        final IndexGraveyard graveyard1 = graveyardBuilder.build();
        if (graveyard.getTombstones().size() > 0) {
        IndexGraveyard.Builder graveyardBuilder = IndexGraveyard.builder();
        }  
    public void testEquals() {
                    XContentOpenSearchExtension.DEFAULT_FORMATTER.format(
 * license agreements. See the NOTICE file distributed with
 */  
        executePurgeTestWithMaxTombstones(IndexGraveyard.SETTING_MAX_TOMBSTONES.getDefault(Settings.EMPTY));  
import org.opensearch.core.common.Strings;
            indices.add(new Index("idx-" + i, UUIDs.randomBase64UUID()));
    public void testAddTombstones() {  
        assertThat(diff.getRemovedCount(), equalTo(removals.size()));
                        Instant.ofEpochMilli(graveyard.getTombstones().get(0).getDeleteDateInMillis())
    }  
    }
import java.util.stream.Collectors;
