     * Test that the method returns false when a different shard is being split.
        SplitShardsMetadata splitCompletedShardSplitMetadata = builder.build();
    }
        int result = metadata.getShardIdOfHash(0, 100, true);
        assertEquals("Should route to second child shard", 2, result);
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
        // Test 5: Different maxShardId
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { builder.splitShard(0, 2); });
        Iterator<Integer> shardIterator = metadata.getActiveShardIterator();
import org.opensearch.core.common.bytes.BytesReference;
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
    private void validateShardsInExistingAndNewMetadata(
    }
            new ShardRange(0, 50, Integer.MAX_VALUE)  // Overlaps with previous range at 50-100
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
        SplitShardsMetadata metadata2 = new SplitShardsMetadata.Builder(2).build();
            assertEquals("Shard ranges should be contiguous", secondLevelShards[i].end() + 1, secondLevelShards[i + 1].start());
        builder.updateSplitMetadataForChildShards(0, Set.of(1, 2, 3));
        shardIterator = metadata.getActiveShardIterator();
                builder = new SplitShardsMetadata.Builder(metadata);
        assertTrue(result.getInProgressSplitShardIds().isEmpty());
                ensureUniqueChildShards(metadata, childShardIds, builder.build());
            assertEquals(after, applied);
        assertTrue("Same object should be equal to itself", metadata.equals(metadata));
        // Setup
     * Expected behavior: Should return 0 for empty metadata
        metadata = builder.build();
        assertFalse("Objects with different maxShardId should not be equal", metadata1.equals(differentMaxShardId));
        builder.splitShard(0, 3);
        ShardRange[] secondLevelShards = metadata.getChildShardsOfParent(1);
                assertEquals(childShardRanges.size(), childShardIds.size());
        );
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
    }
            assertTrue(finalShards.remove(nextShard));
        // Split in progress, should return all 3 shards
        builder = new SplitShardsMetadata.Builder(builder.build());
import org.opensearch.cluster.Diff;
        newChildShardIds.add(7);
        Set<Integer> finalShards = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
     * Tests get active shard iterator for consecutive split
        int initialShards = randomIntBetween(1, maxInitialShards);
    public void testEqualsWithEmptyMaps() {
        builder = new SplitShardsMetadata.Builder(metadata);
     * Test case for empty metadata
        metadata = builder.build();
        while (shardIterator.hasNext()) {
     * Tests getShardIdOfHash when there are existing child shards and in-progress children.
        builder = new SplitShardsMetadata.Builder(metadata);
        // Test 3: Different class
    public void testSplitShardBasicOperation() {
        }
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
        Diff<SplitShardsMetadata> diff = after.diff(before);
        // Execute
        SplitShardsMetadata differentMaxShardId = new SplitShardsMetadata.Builder(3).build();
    /**
        builder = new SplitShardsMetadata.Builder(metadata);
                boolean cancelSplit = randomBoolean();
        assertTrue(metadata.getInProgressSplitShardIds().isEmpty());
        builder.cancelSplit(0);
                        metadata = builder.build();
        metadata = builder.build();
    public void testGetRootShards_splitInProgress() {
        assertEquals(2, childShards.length);
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
        Set<Integer> actualActiveShards = new HashSet<>();
    /**
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(10);
        builder.splitShard(3, 2);
    /**
    public void testGetChildShardsOfParentAfterCancelledSplit() {
        Map<Integer, Set<Integer>> splitCompletingShards,
        assertEquals("Hash should route to first child of in-progress split", 5, result);
    ) {
        Set<Integer> finalShards = new HashSet<>(Arrays.asList(1, 3, 4, 9, 10, 11, 12, 13));
    /**
        // Verify the nested split results
        assertFalse("Should not be equal to different class", metadata.equals(new Object()));
    public void testGetShardIdOfHashWithInProgressSplit() {
            }
        builder.splitShard(12, 3);
    /**
        return result;
        // Assert
                    childShardRanges = builder.splitShard(splittingShard, numberOfChildren);
                result.add(shardId);
     */
        newChildShardIds.add(5);
        assertNotNull("First level split should create child shards", firstLevelShards);
        };
     * Test case for getShardIdOfHash when the root shard has no children and no in-progress split
            metadata = builder.build();
            assertTrue(finalShards.remove(nextShard));
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(metadata);
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
        // 3. 1 -> 5, 6, 7
        builder.cancelSplit(2);
    public void testStreamSerdeSplitInProgress() throws IOException {
                    builder.splitShard(splittingShard, numberOfChildren);
        SplitShardsMetadata metadata = builder.build();
        } else {
        builder.splitShard(0, 2);
    }
            metadata = builder.build();
    }
    public void testGetActiveShardIterator_emptyIterator() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validateShardRanges(0, smallRange));
        // split
        builder.updateSplitMetadataForChildShards(1, Set.of(5, 6, 7));
        builder = new SplitShardsMetadata.Builder(metadata);
        ShardRange[] missingRange = new ShardRange[] {
    }
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4));
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4));
        builder.splitShard(0, 2);
        assertEquals(original, deserialized);
        // Arrange
        for (Iterator<Integer> it = consecutiveShardSplitMetadata.getActiveShardIterator(); it.hasNext();) {
        builder = new SplitShardsMetadata.Builder(builder.build());
        // Execute - test hash that falls in the range of first child of shard 2
            actualActiveShards.add(it.next());
package org.opensearch.cluster.metadata;
        }
        ShardRange[] originalChildShards = metadata.getChildShardsOfParent(parentShardId);
        assertEquals(childShards[0].end() + 1, childShards[1].start());
        assertThrows(AssertionError.class, () -> { builder.updateSplitMetadataForChildShards(0, newChildShardIds); });
     * Test case for updateSplitMetadataForChildShards method
        SplitShardsMetadata emptyMetadata = new SplitShardsMetadata.Builder(0).build();
     * Tests get active shard iterator for split completed
                try {
        builder = new SplitShardsMetadata.Builder(builder.build());
        // First split - split root shard 0 into two children (shards 1 and 2)
        };
        original.writeTo(out);
     * Test for no split data
        builder = new SplitShardsMetadata.Builder(builder.build());
        assertTrue(exception.getMessage().contains("below shard range threshold"));
        // Split in progress, should return all 4 shards
        assertEquals(original, deserialized);
        SplitShardsMetadata original = builder.build();
        }
        }
        // Act
        // 4. 0=>X
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
                                                                                                                                             // 101-199
        builder3.updateSplitMetadataForChildShards(1, Set.of(2, 3));
        for (int i = 0; i < splitExecCount; i++) {
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
        SplitShardsMetadata.Builder builder1 = new SplitShardsMetadata.Builder(3);
    /**
     * Tests the Builder constructor with a SplitShardsMetadata instance where some root shards have no children.
        SplitShardsMetadata metadata3 = new SplitShardsMetadata.Builder(2).build();
        int expectedRootShards = 5;
    }
        assertEquals(actualActiveShards, expectedActiveShards);
    }
        // Test 8: Different parentToChildShards
        builder.updateSplitMetadataForChildShards(12, Set.of(7, 8, 14));
    }
    public void testGetInProgressSplitShardIdWhenNoSplitInProgress() {
    public void testXContentSerdeSplitCompleted() throws IOException {
        Set<Integer> actualActiveShards = new HashSet<>();
        // Verify
                List<ShardRange> childShardRanges;
        // Build the metadata
        builder.splitShard(parentShardId, numberOfChildren);
     * correctly returns maxShardId + 1
                        metadata = builder.build();
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(2);
    }
                } catch (Exception ex) {
/*
        // Create metadata with empty parentToChildShards maps
            actualActiveShardsForConsecutiveShardSplit.add(it.next());
    public void testSplitInvalidShardId() {
        assertEquals("Last child should end at parent's end", parentRange.end(), secondLevelShards[secondLevelShards.length - 1].end());
        for (Iterator<Integer> it = metadata.getActiveShardIterator(); it.hasNext();) {
        builder.updateSplitMetadataForChildShards(0, Set.of(1, 2));
        }
        assertEquals(actualActiveShardsForConsecutiveShardSplit, expectedActiveShardsForConsecutiveShardSplit);
    public void test_getShardIdOfHash_returnsRootShardId() {
        );
        for (int i = 0; i < childShards.length; i++) {
        metadata = builder.build();
            new ShardRange(0, 100, Integer.MAX_VALUE)  // Missing range at 101-199
        try (StreamInput in = out.bytes().streamInput()) {
        SplitShardsMetadata metadata1 = builder1.build();
        // First split - create existing child shards
        assertTrue("Original shard 0 should be split", metadata.isSplitParent(0));
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
        // Assert that child shards are returned and match the expected number
    }
        assertNotNull(childShards);
        SplitShardsMetadata metadata = builder.build();
        // Complete the split with three child shards
        builder.updateSplitMetadataForChildShards(12, Set.of(7, 8, 14));
        builder.splitShard(0, 2);
        builder.splitShard(0, 3);
        // Split the root shard into 3 pieces
        ShardRange[] smallRange = new ShardRange[] { new ShardRange(0, Integer.MIN_VALUE, Integer.MIN_VALUE + 10) };
        builder = new SplitShardsMetadata.Builder(builder.build());
        assertEquals(expectedRootShards, rootShards);
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(initialShards);
        diff.writeTo(out);
     */
        assertEquals("Number of root shards should match the initial count", expectedRootShards, actualRootShards);
        SplitShardsMetadata metadata = builder.build();
        // Verify that returned child shards match across calls
        // Test 6: Different inProgressSplitShardId
     */
        builder.startObject();
        builder.splitShard(0, 2);
        Set<Integer> actualActiveShardsForConsecutiveShardSplit = new HashSet<>();
        assertNull(result.getChildShardsOfParent(2));
        assertFalse(iterator.hasNext());
    }
        Set<Integer> childShardIds = Set.of(1, 2, 3);
    public void testGetNumberOfRootShardsReturnsCorrectCount() {
        long childShardRangeDiff = Math.abs((long) parentRange.end() - parentRange.start() + 1) / 3;
        assertTrue(finalShards.isEmpty());
        SplitShardsMetadata.Builder builder2 = new SplitShardsMetadata.Builder(1);
                }
            SplitShardsMetadata applied = deserializedDiff.apply(before);
    }
        metadata = builder.build();
        SplitShardsMetadata metadata = new SplitShardsMetadata.Builder(1).build();
            int nextShard = shardIterator.next();
import org.opensearch.common.io.stream.BytesStreamOutput;
        builder = new SplitShardsMetadata.Builder(builder.build());
        assertTrue(exception2.getMessage().contains("No shard range defined for child shards of shard 0"));
    public void testIsSplitOfShardInProgress_DifferentShardInProgress() {
        SplitShardsMetadata deserialized = streamRoundTrip(original);
        assertEquals(original, deserialized);
        SplitShardsMetadata metadata = builder.build();
            int nextShard = shardIterator.next();
        rootToChildShards[0][0] = new ShardRange(numberOfRootShards, 0, 100);
        for (Iterator<Integer> iterator = metadata.getActiveShardIterator(); iterator.hasNext();) {
        SplitShardsMetadata original = builder.build();
        assertEquals(2, result);
        BytesStreamOutput out = new BytesStreamOutput();
 * compatible open source license.
        builder.splitShard(0, 3);
        childShards.forEach(shard -> assertFalse(existingShards.contains(shard)));
        assertEquals(3, metadata.getNumberOfShards());
        // Test reusing holes in new split
     */
        SplitShardsMetadata.Builder afterBuilder = new SplitShardsMetadata.Builder(3);
        List<ShardRange> childShards = builder.splitShard(0, 2);
        builder2.updateSplitMetadataForChildShards(0, Set.of(2, 3));
        while (shardIterator.hasNext()) {
     * Expected behavior: Should return 0 for empty metadata
        }
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(finalShards.isEmpty());
    public void testValidateShardRangesMissingRange() {
        int result = metadata.getShardIdOfHash(rootShardId, hash, includeInProgressChildren);
        // Get child shards of the parent
        // Arrange
        SplitShardsMetadata.Builder originalBuilder = new SplitShardsMetadata.Builder(3);
        assertTrue(metadata.getInProgressSplitShardIds().isEmpty());
            new ShardRange(0, Integer.MIN_VALUE + 1, 100),
        assertNotNull(childShards);
        SplitShardsMetadata emptyMetadata = new SplitShardsMetadata.Builder(0).build();
    }
        assertTrue(shardsFromNewMetadata.containsAll(existingShards));
    }
     */
                        metadata = builder.build();
        Set<Integer> finalShards = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6, 7));
     */
    }
            assertTrue(finalShards.remove(nextShard));
import org.mockito.Mockito;
            "The in-progress split shard ID should match the expected value",
        assertTrue("Objects with null array elements should be equal if structure is same", metadata1.equals(metadata2));
    /**
        metadata = builder.build();
    public void testGetNumberOfShardsReturnsMaxShardIdPlusOne() {
        // Act
        assertTrue(finalShards.isEmpty());
     * Test that getInProgressSplitShardId returns the correct shard ID
        builder.endObject();
        assertTrue("Child shard 1 should be split", metadata.isSplitParent(1));
        assertEquals(numberOfShards, metadata.getNumberOfShards());
        builder.splitShard(2, 5);
    }
    public void test_getActiveShardIterator_consecutiveSplits() {
    public void testHashCodeAndEquals() {
        shardIterator = metadata.getActiveShardIterator();
        assertTrue(metadata.getInProgressSplitShardIds().isEmpty());
        Set<Integer> newChildShardIds = new HashSet<>(Arrays.asList(2, 3));
        builder.splitShard(0, 2);
        }
    }
            int nextShard = shardIterator.next();
        builder.updateSplitMetadataForChildShards(1, Set.of(6, 7));
                    } else {
        int rootShardId = 0;
        }
        assertTrue("No split should be in progress", metadata.getInProgressSplitShardIds().isEmpty());
            assertTrue(finalShards.remove(nextShard));
        // Complete the split with three child shards
        assertThrows(AssertionError.class, () -> { builder.updateSplitMetadataForChildShards(0, newChildShardIds); });
        assertThrows(AssertionError.class, () -> { builder.updateSplitMetadataForChildShards(0, newChildShardIds); });
    }
        assertEquals(actualActiveShards, expectedActiveShards);
        // Assert
            metadata.getInProgressSplitShardIds().contains(expectedShardId)
    public void testStreamSerdeConsecutiveSplits() throws IOException {
                Set<Integer> childShardIds = new HashSet<>();
        int numberOfRootShards = 2;
    }
        SplitShardsMetadata.Builder builder2 = new SplitShardsMetadata.Builder(2);
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4, 5));
    public void testGetShardIdOfHashWithNoChildren() {
    }
import org.opensearch.core.xcontent.XContentParser;
            assertEquals(originalChildShards[i], childShards[i]);
                        validateShardsInExistingAndNewMetadata(metadata, builder.build(), childShardIds, splittingShard);
        SplitShardsMetadata deserialized = xContentRoundTrip(original);
        // First split - create existing child shards
        builder.updateSplitMetadataForChildShards(0, Set.of(1, 2));
     * Test getShardIdOfHash when root shard has no children but in-progress split exists
        parentToChildShards.put(inProgressSplitShardId, new ShardRange[2]);
        assertFalse(metadata.isSplitOfShardInProgress(1));
     * Test case for SplitShardsMetadata.Builder constructor with numberOfShards parameter
        }
        assertEquals(original, deserialized);
        assertFalse(metadata.isSplitOfShardInProgress(0));
import java.util.Map;
    }
     * Test case for getting number of shards after splitting
    public void test_getShardIdOfHash_withExistingChildren() {
        }
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
    /**
        builder.splitShard(0, 3);
        assertFalse("Object should not be equal to null", metadata.equals(null));
        List<Integer> expectedRootShards = List.of(0, 1, 2);
        SplitShardsMetadata metadata = builder.build();
        assertTrue(exception.getMessage().startsWith("Split of shard [0] is already in progress or completed."));
     */
        builder.cancelSplit(0);
        builder.splitShard(0, 2);
        // Test 7: Different rootShardsToAllChildren
            for (int j = 0; j < 10; j++) {
 * The OpenSearch Contributors require contributions made to
    public void test_getActiveShardIterator_splitInProgress() {
     * Test case for getChildShardsOfParent with an unsplit shard
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
        int splittingShard
        assertNull(result.getChildShardsOfParent(0));
        SplitShardsMetadata metadata = new SplitShardsMetadata.Builder(1).build();
    }
        metadata = builder.build();
        assertNotNull(childShards);
    /**
            actualShardIds.add(iterator.next());
     */
        while (shardIterator.hasNext()) {
        // Build the metadata
    }
            "Equality should be transitive",
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(numberOfShards);
        builder.splitShard(1, 4);
        // Split the root shard into 3 pieces
        assertTrue(metadata.getInProgressSplitShardIds().isEmpty());
import java.util.Iterator;
        assertEquals("Hash should route to first child of nested split", 3, metadata.getShardIdOfHash(0, hashInFirstThird, true));
        SplitShardsMetadata original = new SplitShardsMetadata.Builder(5).build();
        int actualRootShards = metadata.getNumberOfRootShards();
        assertEquals("Empty metadata should have 0 shards", 0, emptyMetadata.getNumberOfShards());
        assertTrue("Two equivalent objects should be equal", metadata1.equals(metadata2));
 */
        assertEquals(2, childShards.length);
     * This test verifies that the getNumberOfShards() method
        builder = new SplitShardsMetadata.Builder(builder.build());
                if (childShardRanges.size() != childShardIds.size()) {
        // 2. 0 -> 3,4
        SplitShardsMetadata metadata = builder.build();
    }
        builder = new SplitShardsMetadata.Builder(builder.build());
        }
        builder.splitShard(0, 3);
        parentToChildShards.get(inProgressSplitShardId)[0] = new ShardRange(numberOfRootShards + 2, 0, 100);
        assertEquals("Should have 2 child shards", 2, firstLevelShards.length);
     * Verifies that the method correctly updates the metadata for child shards
        builder.splitShard(0, 3);
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4, 5));
            }
        childShards.forEach(shard -> newChildShardIds.add(shard.shardId()));
            int nextShard = shardIterator.next();
        assertEquals(original, deserialized);
     * Test case for empty metadata
     */
        // Setup - split root shard
            validateShardsInExistingAndNewMetadata(metadata, builder.build(), new HashSet<>(), -1);
     */
        SplitShardsMetadata metadata2 = builder2.build();
    }
        builder.splitShard(0, 3);
            assertEquals(shardRanges.length, newShards.size());
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4, 5));
    }
     * Test that cancelSplit correctly removes the in-progress split and resets the inProgressSplitShardId
        }
        builder.splitShard(2, 2);
        SplitShardsMetadata metadata = builder.build();
        // split completed for shard 0
        // Assert that the new SplitShardsMetadata matches the original
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(0); // maxShardId = -1
        ShardRange[] firstLevelShards = metadata.getChildShardsOfParent(0);
    /**
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
        assertTrue(exception.getMessage().contains("Shard range from -2147483648 to -2147483648 is missing from the list of shard ranges"));
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
                        builder.updateSplitMetadataForChildShards(splittingShard, childShardIds);
        shardIterator = newMetadata.getActiveShardIterator();
     * Tests get active shard iterator for split in progress
            assertTrue(finalShards.remove(nextShard));
        assertEquals(0, result);
            builder = new SplitShardsMetadata.Builder(metadata);
import static org.opensearch.cluster.metadata.SplitShardsMetadata.validateShardRanges;
        assertNull("Should return null for shard with cancelled split", metadata.getChildShardsOfParent(0));
                int splittingShard = activeAndNotInProgress.get(randomIntBetween(0, activeAndNotInProgress.size() - 1));
            metadata.getInProgressSplitShardIds().contains(0)
    }
        // 5. 0 -> 3,4,8
    }
        for (Iterator<Integer> it = metadata.getActiveShardIterator(); it.hasNext();) {
            assertTrue(finalShards.remove(nextShard));
        assertEquals(numberOfChildren, childShards.length);
        metadata = builder.build();
     */
        // Verify - should route to the second child shard
        SplitShardsMetadata.Builder builder3 = new SplitShardsMetadata.Builder(2);
        SplitShardsMetadata metadata = builder.build();
        int parentShardId = 2;
     */
    }
        // Test: When there are no children, should return the root shard id
        Set<Integer> expectedActiveShardsForConsecutiveShardSplit = Set.of(1, 2, 3, 4, 5);
        SplitShardsMetadata deserialized = xContentRoundTrip(original);
    public void testGetNumberOfShardsWithEmptyMetadata() {
        SplitShardsMetadata metadata = builder.build();
        builder.cancelSplit(0);
        Iterator<Integer> shardIterator = metadata.getActiveShardIterator();
        // Act
    public void testSplitShardWithInvalidNumberOfChildren() {
        Set<Integer> childShardIds = Set.of(1, 2, 3);
        Set<Integer> newChildShardIds = new HashSet<>();
        builder = new SplitShardsMetadata.Builder(builder.build());
        // Arrange
     */
        builder.splitShard(0, 3);
    public void testGetInProgressSplitShardIdWithValidSplitInProgress() {
            Map<Integer, Set<Integer>> splitCompletingShards = new HashMap<>();
        newChildShardIds.add(5);
        }
    }
        SplitShardsMetadata metadata = builder.build();
        builder.splitShard(0, 3);
     */
    }
        // Test hash routing through the nested structure
        // Start a split
            assertTrue(finalShards.remove(shardIterator.next()));
        SplitShardsMetadata consecutiveShardSplitMetadata = builder.build();
        for (Iterator<Integer> it = splitCompletedShardSplitMetadata.getActiveShardIterator(); it.hasNext();) {
     * Test that the method returns true when the correct shard is being split.
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4, 5));
        int sourceShardId = 0;
    public void testGetInProgressSplitShardIdAfterCancelingSplit() {
            assertTrue(finalShards.remove(nextShard));
                        cancellableShards.add(splittingShard);
        builder.splitShard(0, 2);
        assertNull(result.getChildShardsOfParent(1));
        builder.splitShard(0, 2);
        // Test overlapping ranges
        builder = new SplitShardsMetadata.Builder(builder.build());
    public void testStreamSerdeSplitCompleted() throws IOException {
        int result = builder.build().getShardIdOfHash(0, 100, false);
    }
        assertTrue(childShards[0].end() < childShards[1].start());
    public void testXContentSerdeConsecutiveSplits() throws IOException {
        SplitShardsMetadata metadata = builder.build();
import org.opensearch.core.xcontent.XContentBuilder;
    public void testCancelSplitRemovesInProgressSplit() {
        SplitShardsMetadata deserialized = streamRoundTrip(original);
    public void testGetNumberOfRootShardsAfterSplitting() {
        assertThrows(AssertionError.class, () -> { builder.updateSplitMetadataForChildShards(0, newChildShardIds); });
    /**
                        validateShardsInExistingAndNewMetadata(metadata, builder.build(), new HashSet<>(), -1);
        SplitShardsMetadata original = new SplitShardsMetadata.Builder(5).build();
        assertNull("Should return null for unsplit shard", metadata.getChildShardsOfParent(0));
        // Test 2: Null comparison
    public void testGetNumberOfRootShardsWithEmptyMetadata() {
 * SPDX-License-Identifier: Apache-2.0
        ShardRange[] childShards = metadata.getChildShardsOfParent(sourceShardId);
        builder = new SplitShardsMetadata.Builder(metadata);
import java.util.Arrays;
        assertTrue(exception.getMessage().contains("Shard range from 101 to 199 is missing from the list of shard ranges"));
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1); // 1 root shard
        ShardRange[] overlappingRanges = new ShardRange[] {
        SplitShardsMetadata metadata1 = builder1.build();
        builder1.splitShard(0, 2);  // This will set inProgressSplitShardId
        // Verify range boundaries
    public void testGetInProgressSplitShardId() {
            assertTrue(shardsFromNewMetadata.containsAll(newShards));
                    break;
    }
        assertEquals(expectedActiveShardsForConsecutiveShardSplit, actualActiveShardsForConsecutiveShardSplit);
        Set<Integer> existingShards = new HashSet<>();
        SplitShardsMetadata metadata = builder.build();
    }
        SplitShardsMetadata metadata = builder.build();
import org.opensearch.core.common.io.stream.StreamInput;
     */
        assertEquals(
        builder = new SplitShardsMetadata.Builder(builder.build());
        builder.splitShard(sourceShardId, numberOfChildren);
            () -> builder.splitShard(10, 2) // Invalid shard ID
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1); // Start with 1 root shard
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1); // Start with 1 root shard
        Set<Integer> cancellableShards,
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
        boolean includeInProgressChildren = false;
        List<Integer> rootShards = metadata.getRootShards();
    /**
        builder.updateSplitMetadataForChildShards(2, Set.of(9, 10, 11, 12, 13));
    }
        for (Integer shardId : splitCompletingShards.keySet()) {
        // Verify the split was canceled
    private SplitShardsMetadata streamRoundTrip(SplitShardsMetadata original) throws IOException {
        // Verify split state
    private SplitShardsMetadata createDummySplitShardsMetadataWithNoRandomisation() {
        builder.splitShard(0, 2);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { builder.splitShard(0, 10000000); });
        // Test 10: Transitive equality
        assertTrue(exception.getMessage().contains("Cannot split shard [0] further."));
                builder = new SplitShardsMetadata.Builder(metadata);
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
        // Act & Assert
        while (shardIterator.hasNext()) {
        // Cancel the split
     */
    /**
        StreamInput emptyInput = Mockito.mock(StreamInput.class);
        builder = new SplitShardsMetadata.Builder(metadata);
        builder.splitShard(expectedShardId, 2);
     */
        SplitShardsMetadata metadata = builder.build();
            }
        Iterator<Integer> shardIterator = previousMetadata.getActiveShardIterator();
        // split completed for shard 0
        Set<Integer> newChildShardIds = new HashSet<>();
        SplitShardsMetadata metadata = builder.build();
        // Test 1: Same object reference
        XContentBuilder builder = JsonXContent.contentBuilder();
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
        SplitShardsMetadata metadata = builder.build();
    /**
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
    public void testStreamSerdeNoSplit() throws IOException {
    public void test_getActiveShardIterator_splitCompleted() {
import org.opensearch.core.xcontent.ToXContent;
        assertEquals("Should have 3 child shards", 3, secondLevelShards.length);
        finalShards = new HashSet<>(Arrays.asList(1, 3, 5, 6, 7, 8, 9, 10, 11, 13, 14));
        finalShards = new HashSet<>(Arrays.asList(1, 3, 5, 6, 9, 10, 11, 12, 13));
        // Setup
    public void testUpdateSplitMetadataWithInvalidSourceShardId() {
        int numberOfChildren = 3;
            builder.updateSplitMetadataForChildShards(shardId, splitCompletingShards.get(shardId));
        // test shard range not at Integer.Min
import java.util.HashSet;
        assertEquals(0, metadata.getShardIdOfHash(0, 100, false));
        // Test 4: Equal objects
        int hashInFirstThird = parentRange.start() + (int) childShardRangeDiff - 1;
    }
        SplitShardsMetadata deserialized = xContentRoundTrip(original);
    public void testUpdateSplitMetadataForChildShards_InvalidChildShardId() {
        ShardRange[] childShards = metadata.getChildShardsOfParent(0);
        shardIterator = metadata.getActiveShardIterator();
        // Test missing range
        previousMetadata.getInProgressSplitShardIds().forEach(shardId -> assertFalse(childShards.contains(shardId)));
        boolean includeInProgressChildren = true;
        SplitShardsMetadata original = builder.build();
        for (Integer shardId : cancellableShards) {
        SplitShardsMetadata metadata = builder.build();
        assertTrue(finalShards.isEmpty());
        }
        Set<Integer> expectedActiveShards = Set.of(0, 1, 2);
    }
        builder = new SplitShardsMetadata.Builder(builder.build());
        // Execute - test with hash that should go to second child
    public void testXContentSerdeNoSplit() throws IOException {
        while (shardIterator.hasNext()) {
        SplitShardsMetadata metadata = builder.build();
    /**
                    if (cancelSplit) {
        metadata = builder.build();
        // Get final metadata
        SplitShardsMetadata metadata1 = new SplitShardsMetadata.Builder(2).build();
            ShardRange[] shardRanges = newMetadata.getChildShardsOfParent(splittingShard);
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
    private SplitShardsMetadata xContentRoundTrip(SplitShardsMetadata original) throws IOException {
     * Test case for getting number of root shards after splitting
    /**
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3); // Start with 1 root shard
        if (newShards.isEmpty()) {
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
    public void testReadDiffFromWithEmptyInput() throws IOException {
        SplitShardsMetadata.Builder builder2 = new SplitShardsMetadata.Builder(3);
        SplitShardsMetadata metadata = builder.build();
        Set<Integer> expectedActiveShards = Set.of(0, 1, 2);
    public void testXContentSerdeSplitInProgress() throws IOException {
                    }
        rootToChildShards[0][1] = new ShardRange(numberOfRootShards + 1, 0, 100);
        finalShards = new HashSet<>(Arrays.asList(1, 3, 4, 9, 10, 11, 12, 13));
        assertTrue(newChildShardIds.contains(childShards[0].shardId()));
import static org.mockito.Mockito.when;
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
        SplitShardsMetadata original = builder.build();
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
        // Test reusing holes in new split
    public void testUpdateSplitMetadataForChildShards_NoSplitInProgress() {
        // Test basic split operation
        rootToChildShards[0] = new ShardRange[2];
        Iterator<Integer> shardIterator = existing.getActiveShardIterator();
        builder.splitShard(2, 5);
    public void testSplitShardWhenAnotherSplitIsCancelled_1() {
        List<Integer> expectedRootShards = List.of(0, 1, 2);
        builder.splitShard(0, 2);
            return SplitShardsMetadata.parse(parser);
    }
        builder2.splitShard(0, 2);
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> validateShardRanges(0, new ShardRange[0]));
    /**
    public void testValidateShardRangesBelowThreshold() {
                }
        builder.updateSplitMetadataForChildShards(1, Set.of(3, 4, 5));
        builder.updateSplitMetadataForChildShards(2, Set.of(9, 10, 11, 12, 13));
        builder.splitShard(1, 2);
        builder.splitShard(0, 3);
        }
    public void testSplitShardWithCompletedSplit() {
    public void testUpdateSplitMetadataForChildShards_Success() {
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
            assertFalse(newMetadata.getInProgressSplitShardIds().contains(splittingShard));
            "When a valid split is in progress, the correct shard ID should be returned",
    }
        }
        assertEquals("First child should start at parent's start", parentRange.start(), secondLevelShards[0].start());
        int splitExecCount = randomIntBetween(1, 20);
        assertEquals("Empty metadata should have 0 root shards", 0, emptyMetadata.getNumberOfRootShards());
     */
            for (ShardRange shardRange : shardRanges) {
    public void testUpdateSplitMetadataForChildShards_EmptyNewChildShardIds() {
                boolean complete = randomBoolean();
        builder.splitShard(0, 3);
        // Arrange
        Set<Integer> expectedActiveShards = Set.of(1, 2, 3, 4, 5);
        // Assert
        int maxInitialShards = 20;
        while (shardIterator.hasNext()) {
        builder = new SplitShardsMetadata.Builder(builder.build());
        return new SplitShardsMetadata(rootToChildShards, parentToChildShards, inProgressSplitShards, activeShards, 0);
        Set<Integer> shardsFromNewMetadata = new HashSet<>();
    }
            assertTrue("Shard ranges should be in order", secondLevelShards[i].end() < secondLevelShards[i + 1].start());
        SplitShardsMetadata metadata = new SplitShardsMetadata.Builder(maxShardId + 1).build();
        assertTrue(newChildShardIds.contains(childShards[1].shardId()));
        builder.splitShard(2, 5);
            assertEquals(existingShards.size(), shardsFromNewMetadata.size());
        );
        assertEquals(createDummySplitShardsMetadataWithNoRandomisation(), createDummySplitShardsMetadataWithNoRandomisation());
                assertTrue(newShards.contains(shardRange.shardId()));
                    builder = new SplitShardsMetadata.Builder(metadata);
     * Test that the method returns false when no split is in progress.
        assertTrue(finalShards.isEmpty());
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
        builder.splitShard(3, 2);
        assertEquals(numberOfShards, metadata.getNumberOfRootShards());
    private void finishPendingSplits(
    }
            builder.cancelSplit(shardId);
            existingShards.add(shardIterator.next());
        Iterator<Integer> shardIterator = metadata.getActiveShardIterator();
            shardsFromNewMetadata.add(shardIterator.next());
            existingShards.add(shardIterator.next());
        assertTrue(finalShards.isEmpty());
    }
    public void testGetNumberOfShardsAfterSplitting() {
        assertTrue(
        // 6. 0 completes 1,2,3,4,8 holes is 0, max shard id 8
    }
        assertTrue("After completing a split, shard split shouldn't be in progress", metadata.getInProgressSplitShardIds().isEmpty());
        }
                    }
    public void testGetShardIdOfHashWithExistingAndInProgressChildren() {
        SplitShardsMetadata metadata
        SplitShardsMetadata result = newBuilder.build();
        Set<Integer> actualShardIds = new HashSet<>();
    /**
import java.util.HashMap;
                if (complete) {
        existingShards.remove(splittingShard);
        // split completed for shard 0
    public void testEqualsMethod() {
        );
        // Case 1
        builder.splitShard(2, 2);
        builder.updateSplitMetadataForChildShards(0, childShardIds);
        // Should return root shard ID when includeInProgressChildren is false
        assertFalse("Child shard 2 should not be split", metadata.isSplitParent(2));
        assertTrue(metadata.isSplitOfShardInProgress(2));
     * Test case for getChildShardsOfParent when the parent shard has child shards
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4, 5));
    }
        // Create metadata with null elements in rootShardsToAllChildren
        SplitShardsMetadata metadata = builder.build();
        while (shardIterator.hasNext()) {
        Set<Integer> existingShards = new HashSet<>();
    /**
        builder.cancelSplit(1);
        // First split - create existing child shards
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1); // Start with 1 root shard
        Set<Integer> newShards,
        // Verify ranges are properly distributed
            assertEquals(existingShards.size() + newShards.size(), shardsFromNewMetadata.size());
    public void testBuilderWithEmptyRootShards() {
        builder.splitShard(0, 2);
     * Test case for getChildShardsOfParent after a cancelled split operation
        }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validateShardRanges(0, overlappingRanges));
    public void testGetShardIdOfHashWithInProgressSplitIgnored() {
    }
        List<Integer> result = new ArrayList<>();
        assertTrue(exception.getMessage().contains("Shard ID doesn't exist in the current list of shard ranges"));
        builder.splitShard(0, 2);
            withDifferentRootShards.equals(withDifferentParentToChild)
        builder.updateSplitMetadataForChildShards(4, Set.of(5, 6));
    }
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
        // Verify split is in progress
     */
            new ShardRange(0, Integer.MIN_VALUE, 100),
            actualActiveShardsForConsecutiveShardSplit.add(it.next());
                        builder.cancelSplit(splittingShard);
    /**
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(expectedRootShards);
        finalShards = new HashSet<>(Arrays.asList(1, 3, 5, 6, 7, 8, 9, 10, 11, 13, 14));
        assertFalse(
        SplitShardsMetadata deserialized = xContentRoundTrip(original);
                    } else {
        );
        assertTrue(
        while (shardIterator.hasNext()) {
    public void testGetChildShardsOfParentWithUnsplitShard() {
        }
        parentToChildShards.get(inProgressSplitShardId)[1] = new ShardRange(numberOfRootShards + 3, 101, 200);
    public void testGetChildShardsOfParentWithExistingChildren() {
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
        shardIterator = metadata.getActiveShardIterator();
        ShardRange[][] rootToChildShards = new ShardRange[numberOfRootShards][];
        assertFalse("Objects with different inProgressSplitShardId should not be equal", metadata1.equals(withSplit));
        // put details for splitting shard into parent-to-child map
        while (shardIterator.hasNext()) {
        // Act
        SplitShardsMetadata metadata = builder.build();
import org.opensearch.common.xcontent.json.JsonXContent;
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
        Set<Integer> newChildShardIds = new HashSet<>();
        assertEquals("getNumberOfShards should return maxShardId + 1", maxShardId + 1, result);
                        validateShardsInExistingAndNewMetadata(metadata, builder.build(), childShardIds, splittingShard);
        while (shardIterator.hasNext()) {
        assertEquals(original, result);
        try (StreamInput in = out.bytes().streamInput()) {
        builder = new SplitShardsMetadata.Builder(builder.build());
        SplitShardsMetadata metadata = new SplitShardsMetadata.Builder(5).build();
        builder.updateSplitMetadataForChildShards(2, Set.of(8, 9, 10, 11, 12));
        // 7. 1=>X, 1,2,3,4,8 hoes is 5,6,7 m=
        builder.cancelSplit(sourceShardId);
    }
        while (shardIterator.hasNext()) {
        while (shardIterator.hasNext()) {
        assertTrue(exception.getMessage().contains("Shard range overlap"));
        // Setup
                        builder = new SplitShardsMetadata.Builder(metadata);
    /**
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
        builder = new SplitShardsMetadata.Builder(metadata);
            int nextShard = shardIterator.next();
     * Expected behavior: Should return the same number of root shards
    ) {
    }
                    if (ex.getMessage().equals("Cannot split shard [" + splittingShard + "] further.")) {
        ShardRange parentRange = firstLevelShards[0]; // Range of shard 1
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
}
                }
        // Test range below threshold
    public void testBuilderConstructorWithNumberOfShards() {
        int numberOfShards = 5;
            if (metadata.getInProgressSplitShardIds().contains(shardId) == false) {
        int rootShardId = 0;
        SplitShardsMetadata metadata = builder.build();
        // Create a new Builder using the original SplitShardsMetadata
    }
        builder.splitShard(0, 2);
        builder = new SplitShardsMetadata.Builder(metadata);
        }
        afterBuilder.splitShard(0, 3);
                childShardRanges.forEach(shardRange -> childShardIds.add(shardRange.shardId()));
    }
        parentToChildShards.put(0, new ShardRange[] { rootToChildShards[0][0], rootToChildShards[0][1] });
    public void testIsSplitOfShardInProgress_CorrectShardInProgress() {
        }
        SplitShardsMetadata metadata = builder.build();
            finishPendingSplits(cancellableShards, splitCompletingShards, metadata);
        BytesStreamOutput out = new BytesStreamOutput();
        assertEquals(3, result.getNumberOfRootShards());
                        builder.splitShard(splittingShard, childShardIds.size());
        assertNull(metadata.getChildShardsOfParent(sourceShardId));
        assertFalse("Objects with different rootShardsToAllChildren should not be equal", metadata1.equals(withDifferentRootShards));
        }
        builder.splitShard(0, 3);
        }
            createDummySplitShardsMetadataWithNoRandomisation().hashCode(),
        assertEquals(3, metadata.getNumberOfShards());
        assertNotNull("Second level split should create child shards", secondLevelShards);
        // Test 9: Symmetric equality
        int hash = 500;
            createDummySplitShardsMetadataWithNoRandomisation().hashCode()
        int sourceShardId = 2;
        SplitShardsMetadata metadata = builder.build();
    /**
        // Create a builder and add some child shards for a parent
        SplitShardsMetadata existing,
     * Test that getNumberOfRootShards returns the correct number of root shards
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4));
    }
        SplitShardsMetadata before = new SplitShardsMetadata.Builder(3).build();
    public void testSplitShardWhenSplitAlreadyInProgress() {
        SplitShardsMetadata.Builder newBuilder = new SplitShardsMetadata.Builder(original);
    }
        assertEquals(original, deserialized);
        builder.splitShard(4, 2);
            int nextShard = shardIterator.next();
        assertTrue("Equality should be symmetric", metadata1.equals(metadata2) && metadata2.equals(metadata1));
        builder.splitShard(1, 3);
        builder.updateSplitMetadataForChildShards(1, Set.of(5, 6, 7));
    public void testSplitShardNestedSplit() {
        int result = metadata.getShardIdOfHash(rootShardId, hash, includeInProgressChildren);
    }
    /**
    /**
        assertTrue("After canceling a split, shard split shouldn't be in progress", metadata.getInProgressSplitShardIds().isEmpty());
        assertTrue(metadata.isSplitOfShardInProgress(0));
    }
        builder.updateSplitMetadataForChildShards(4, Set.of(5, 6));
     */
            Set<Integer> cancellableShards = new HashSet<>();
        builder.splitShard(2, 5);
public class SplitShardsMetadataTests extends OpenSearchTestCase {
            int nextShard = shardIterator.next();
        Iterator<Integer> shardIterator = metadata.getActiveShardIterator();
                                                                                                                                             // at
        SplitShardsMetadata.Builder builder1 = new SplitShardsMetadata.Builder(2);
        int inProgressSplitShardId = 1;
        original.toXContent(builder, ToXContent.EMPTY_PARAMS);
        // Should return only active child shards
    }
        builder.splitShard(0, 2);
        SplitShardsMetadata metadata = builder.build();
        builder.splitShard(2, 2);
        assertEquals("Number of root shards should remain unchanged after splitting", 5, metadata.getNumberOfRootShards());
        Map<Integer, ShardRange[]> parentToChildShards = new HashMap<>();
        // Assert
    }
        SplitShardsMetadata withDifferentParentToChild = builder3.build();
 *
        int expectedShardId = 5;
        // Build the new SplitShardsMetadata
     */
        metadata = builder.build();
        // Arrange
                    throw ex;
    }
        SplitShardsMetadata metadata = builder.build();
    }
        Set<Integer> finalShards = new HashSet<>(Arrays.asList(0, 1, 2));
        assertEquals(expectedActiveShards, actualShardIds);
        when(emptyInput.available()).thenReturn(0);
        SplitShardsMetadata deserialized = streamRoundTrip(original);
            validateShardsInExistingAndNewMetadata(metadata, builder.build(), splitCompletingShards.get(shardId), shardId);
        Set<Integer> inProgressSplitShards = Set.of(0);
        for (int i = 0; i < secondLevelShards.length - 1; i++) {
        // 1. 0,1,2 original
        assertTrue(finalShards.isEmpty());
        Set<Integer> newChildShardIds = new HashSet<>();
    }
            int shardId = shardIterator.next();
import java.util.List;
        SplitShardsMetadata original = originalBuilder.build();
    public void testUpdateSplitMetadataForChildShards_MismatchedChildShardCount() {
        );
    public void testChildShardIdsGeneration() {
    public void testIsSplitOfShardInProgress_NoSplitInProgress() {
        SplitShardsMetadata deserialized = streamRoundTrip(original);
        shardIterator = metadata.getActiveShardIterator();
import java.util.Set;
                } else {
        // Verify first split
        // Empty shard range
        builder.splitShard(sourceShardId, 2);
        List<Integer> rootShards = metadata.getRootShards();
                }
    public void testSplitShardWhenAnotherSplitIsCancelled_2() {
                List<Integer> activeAndNotInProgress = getActiveAndNotInProgressShards(metadata);
        SplitShardsMetadata metadata = builder.build();
    }
        SplitShardsMetadata after = afterBuilder.build();
import java.io.IOException;
    }
        builder.updateSplitMetadataForChildShards(0, childShardIds);
        Set<Integer> newChildShardIds = new HashSet<>();
        }
    private List<Integer> getActiveAndNotInProgressShards(SplitShardsMetadata metadata) {
    }
        int numberOfChildren = 2;
        };
        SplitShardsMetadata metadata = builder.build();
        // Second split - split the middle shard (ID 2)
        SplitShardsMetadata metadata = builder.build();
        // put details for already split shard into parent-to-child map
        // split completed for shard 1
        builder.splitShard(0, 3);
        builder.cancelSplit(1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validateShardRanges(0, missingRange));
        builder = new SplitShardsMetadata.Builder(builder.build());
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4, 5));
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4, 5));
        Iterator<Integer> shardIterator = metadata.getActiveShardIterator();
        SplitShardsMetadata metadata = builder.build();
        int numberOfShards = 5;
        metadata = builder.build();
            IllegalArgumentException.class,
        builder = new SplitShardsMetadata.Builder(metadata);
        }
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3); // Start with 1 root shard
        SplitShardsMetadata original = builder.build();
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
                    if (cancelSplit) {
                        break;
        Set<Integer> actualActiveShardsForConsecutiveShardSplit = new HashSet<>();
        // Assert - should route to the first child of the in-progress split
        builder.updateSplitMetadataForChildShards(sourceShardId, newChildShardIds);
    }
        Iterator<Integer> iterator = metadata.getActiveShardIterator();
        // Setup
            return new SplitShardsMetadata(in);
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
        builder = new SplitShardsMetadata.Builder(builder.build());
        while (shardIterator.hasNext()) {
        assertEquals("Should return the root shard ID when there are no children", rootShardId, result);
    }
    public void testSplitCancelWhenAnotherSplitIsInProgress() {
    public void testEqualsWithNullArrayElements() {
    /**
    public void testGetInProgressSplitShardIdAfterCompletingSplit() {
        ShardRange[] missingRange = new ShardRange[] { new ShardRange(0, Integer.MIN_VALUE, 100), new ShardRange(0, 200, Integer.MAX_VALUE)  // Missing
                int numberOfChildren = randomIntBetween(1, 50);
        }
        SplitShardsMetadata withSplit = builder1.build();
        assertEquals(original, deserialized);
    }
        assertTrue(builder.build().getInProgressSplitShardIds().contains(sourceShardId));
        SplitShardsMetadata metadata2 = builder2.build();
                        splitCompletingShards.put(splittingShard, childShardIds);
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1); // Start with 1 root shard
                metadata = builder.build();
        newChildShardIds.add(2);
        // Verify shard ranges
        ShardRange[] childShards = metadata.getChildShardsOfParent(parentShardId);
        builder.splitShard(4, 2);
                    }
        builder.splitShard(1, 3);
        int maxShardId = 5;
        builder.splitShard(1, 4);
 * this file be licensed under the Apache-2.0 license or a
            metadata1.equals(metadata2) && metadata2.equals(metadata3) && metadata1.equals(metadata3)
                validateShardsInExistingAndNewMetadata(metadata, builder.build(), new HashSet<>(), -1);
     * Test case for in-progress split being ignored
            "Objects with different parentToChildShards should not be equal",
        SplitShardsMetadata metadata = builder.build();
                if (activeAndNotInProgress.isEmpty()) {
    }
        SplitShardsMetadata original = builder.build();
    }
        Set<Integer> expectedActiveShardsForConsecutiveShardSplit = Set.of(2, 3, 4, 5, 6, 7);
        IllegalArgumentException exception = assertThrows(
        }
        builder.splitShard(1, 3);
            actualActiveShards.add(it.next());
    public void testValidateShardRangesOverlap() {
    public void testGetRootShards_splitCompleted() {
        builder = new SplitShardsMetadata.Builder(metadata);
    public void testDiffSerde() throws IOException {
        SplitShardsMetadata withDifferentRootShards = builder2.build();
        builder.splitShard(0, 2);
    }
        builder.updateSplitMetadataForChildShards(0, Set.of(5, 6));
        int result = metadata.getNumberOfShards();
     * Test getShardIdOfHash when root shard has children but no in-progress splits
     */
    }
    }
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4));
        // Second split - split first child shard (shard 1) into three children
        metadata = builder.build();
        assertThrows(IllegalArgumentException.class, () -> { builder.updateSplitMetadataForChildShards(1, newChildShardIds); });
    public void testValidateShardRangesInvalidStartRange() {
        int result = metadata.getShardIdOfHash(0, 500, true);
    }
        assertEquals(expectedRootShards, rootShards);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validateShardRanges(0, missingRange));
                                                                                                                                             // range
    /**
        assertEquals(original, deserialized);
        assertTrue(finalShards.isEmpty());
        builder.splitShard(12, 3);
                        builder.updateSplitMetadataForChildShards(splittingShard, childShardIds);
     */
        builder.splitShard(0, 2);
        // Split in progress, should return all 3 shards
        builder.splitShard(0, 3);
import java.util.ArrayList;
     */
        // Create a SplitShardsMetadata with some empty root shards
        newChildShardIds.add(1);
        int hash = 123;
        for (int i = 0; i < numberOfShards; i++) {
        builder3.splitShard(1, 2);  // Split different shard
        SplitShardsMetadata metadata = builder.build();
            assertTrue(finalShards.remove(nextShard));
        builder.splitShard(0, 2);
     */
            assertNull(metadata.getChildShardsOfParent(i));
        SplitShardsMetadata newMetadata,
        assertNotNull(SplitShardsMetadata.readDiffFrom(emptyInput));
     */
        Set<Integer> activeShards = Set.of(0);
            int nextShard = shardIterator.next();
        assertTrue("Objects with empty maps should be equal if structure is same", metadata1.equals(metadata2));
        assertTrue(
        finalShards = new HashSet<>(Arrays.asList(1, 3, 5, 6, 9, 10, 11, 12, 13));
    private void ensureUniqueChildShards(SplitShardsMetadata previousMetadata, Set<Integer> childShards, SplitShardsMetadata newMetadata) {
    }
        SplitShardsMetadata.Builder builder1 = new SplitShardsMetadata.Builder(1);
        // split in progress for shard 1
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(numberOfShards);
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
            Diff<SplitShardsMetadata> deserializedDiff = SplitShardsMetadata.readDiffFrom(in);
        assertTrue(finalShards.isEmpty());
        }
