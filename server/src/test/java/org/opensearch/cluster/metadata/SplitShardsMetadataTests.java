        assertTrue(exception.getMessage().contains("Shard ID doesn't exist in the current list of shard ranges"));
        // Build the new SplitShardsMetadata
                validateShardsInExistingAndNewMetadata(metadata, builder.build(), new HashSet<>(), -1);  
        assertEquals(original, result);
 *
        assertTrue("Child shard 1 should be split", metadata.isSplitParent(1));
        Set<Integer> newChildShardIds = new HashSet<>();  
    private SplitShardsMetadata createDummySplitShardsMetadataWithNoRandomisation() {
     * Test that getInProgressSplitShardId returns the correct shard ID
        builder.updateSplitMetadataForChildShards(4, Set.of(5, 6));  
        );  
                        metadata = builder.build();  
     * Test case for getShardIdOfHash when the root shard has no children and no in-progress split
        rootToChildShards[0][1] = new ShardRange(numberOfRootShards + 1, 0, 100);
     */
        finalShards = new HashSet<>(Arrays.asList(1, 3, 4, 9, 10, 11, 12, 13));  
        // Verify - should route to the second child shard  
            assertEquals(existingShards.size() + newShards.size(), shardsFromNewMetadata.size());
    public void testStreamSerdeSplitInProgress() throws IOException {
        metadata = builder.build();  
     * Test case for getting number of root shards after splitting
        SplitShardsMetadata differentMaxShardId = new SplitShardsMetadata.Builder(3).build();
                Set<Integer> childShardIds = new HashSet<>();
        SplitShardsMetadata metadata = builder.build();
        long childShardRangeDiff = Math.abs((long) parentRange.end() - parentRange.start() + 1) / 3;
        assertFalse(metadata.isSplitOfShardInProgress(1));
    /**
        assertTrue(newChildShardIds.contains(childShards[1].shardId()));
        assertTrue(  
        assertNotNull(childShards);
                List<ShardRange> childShardRanges;
            actualActiveShardsForConsecutiveShardSplit.add(it.next());
        SplitShardsMetadata.Builder builder2 = new SplitShardsMetadata.Builder(1);
        SplitShardsMetadata metadata = builder.build();  
        // Act  
        assertThrows(AssertionError.class, () -> { builder.updateSplitMetadataForChildShards(0, newChildShardIds); });
        assertTrue("Objects with empty maps should be equal if structure is same", metadata1.equals(metadata2));
                        builder.cancelSplit(splittingShard);
        metadata = builder.build();  
            new ShardRange(0, Integer.MIN_VALUE + 1, 100),
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4));  
        builder.splitShard(0, 3);  
        ShardRange[] secondLevelShards = metadata.getChildShardsOfParent(1);  
        assertTrue(finalShards.isEmpty());  
            assertTrue(finalShards.remove(nextShard));
        assertTrue(
        assertNotNull("Second level split should create child shards", secondLevelShards);
                if (activeAndNotInProgress.isEmpty()) {  
     * Test case for empty metadata
                int splittingShard = activeAndNotInProgress.get(randomIntBetween(0, activeAndNotInProgress.size() - 1));
    public void testStreamSerdeSplitCompleted() throws IOException {  
        SplitShardsMetadata metadata = builder.build();  
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
        builder.splitShard(2, 2);
        boolean includeInProgressChildren = false;
    /**  
        // Split the root shard into 3 pieces
        builder = new SplitShardsMetadata.Builder(metadata);  
    /**
                if (complete) {  
        original.toXContent(builder, ToXContent.EMPTY_PARAMS);
import static org.opensearch.cluster.metadata.SplitShardsMetadata.validateShardRanges;
import java.util.HashSet;  
        // Test 6: Different inProgressSplitShardId
        assertTrue(exception.getMessage().contains("below shard range threshold"));
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
        // Assert that the new SplitShardsMetadata matches the original
        builder.splitShard(4, 2);
        metadata = builder.build();  
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
                        builder.splitShard(splittingShard, childShardIds.size());  
        int numberOfRootShards = 2;  
import org.opensearch.common.xcontent.json.JsonXContent;  
        assertEquals(original, deserialized);  
                }  
        // put details for already split shard into parent-to-child map
        builder.splitShard(1, 3);  
    public void testGetShardIdOfHashWithExistingAndInProgressChildren() {
        Set<Integer> expectedActiveShards = Set.of(1, 2, 3, 4, 5);
    }  
        assertTrue("Equality should be symmetric", metadata1.equals(metadata2) && metadata2.equals(metadata1));
        }  
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { builder.splitShard(0, 10000000); });  
        builder.splitShard(0, 3);
    /**
        assertEquals(original, deserialized);  
        int numberOfChildren = 3;
        StreamInput emptyInput = Mockito.mock(StreamInput.class);
        }
        SplitShardsMetadata metadata = builder.build();
        }  
        finalShards = new HashSet<>(Arrays.asList(1, 3, 5, 6, 9, 10, 11, 12, 13));
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(10);  
    public void testCancelSplitRemovesInProgressSplit() {
            "When a valid split is in progress, the correct shard ID should be returned",  
        SplitShardsMetadata.Builder builder1 = new SplitShardsMetadata.Builder(2);  
        // Test 4: Equal objects
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(numberOfShards);
        // Verify split state
    }
        // Create a SplitShardsMetadata with some empty root shards  
    }
        SplitShardsMetadata original = builder.build();
        assertTrue(finalShards.isEmpty());  
        };
        while (shardIterator.hasNext()) {
        builder = new SplitShardsMetadata.Builder(metadata);
        Set<Integer> expectedActiveShardsForConsecutiveShardSplit = Set.of(2, 3, 4, 5, 6, 7);
    /**  
        assertFalse("Child shard 2 should not be split", metadata.isSplitParent(2));  
        SplitShardsMetadata withDifferentRootShards = builder2.build();  
     * This test verifies that the getNumberOfShards() method
        Iterator<Integer> shardIterator = existing.getActiveShardIterator();
        // Arrange
                    childShardRanges = builder.splitShard(splittingShard, numberOfChildren);  
        // Test 2: Null comparison
     */
        parentToChildShards.get(inProgressSplitShardId)[1] = new ShardRange(numberOfRootShards + 3, 101, 200);
    public void testSplitShardNestedSplit() {  
        builder.splitShard(0, 2);
        builder.splitShard(3, 2);
        int hashInFirstThird = parentRange.start() + (int) childShardRangeDiff - 1;  
        assertFalse("Objects with different rootShardsToAllChildren should not be equal", metadata1.equals(withDifferentRootShards));
     */  
        // Test 7: Different rootShardsToAllChildren
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4, 5));  
        assertNull(result.getChildShardsOfParent(2));  
        assertTrue("After completing a split, shard split shouldn't be in progress", metadata.getInProgressSplitShardIds().isEmpty());
        assertTrue(exception.getMessage().contains("Shard range from -2147483648 to -2147483648 is missing from the list of shard ranges"));  
    }
    }  
        // Arrange
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(expectedRootShards);  
            Set<Integer> cancellableShards = new HashSet<>();
        builder1.splitShard(0, 2);  // This will set inProgressSplitShardId
        // Arrange
    }  
        SplitShardsMetadata metadata = builder.build();  
    }  
        SplitShardsMetadata metadata = builder.build();
        assertFalse(metadata.isSplitOfShardInProgress(0));  
        SplitShardsMetadata metadata = builder.build();  
                ensureUniqueChildShards(metadata, childShardIds, builder.build());  
        finalShards = new HashSet<>(Arrays.asList(1, 3, 5, 6, 7, 8, 9, 10, 11, 13, 14));
        Iterator<Integer> shardIterator = metadata.getActiveShardIterator();
            IllegalArgumentException.class,
    public void testGetInProgressSplitShardIdAfterCancelingSplit() {
    public void testBuilderConstructorWithNumberOfShards() {
            int nextShard = shardIterator.next();
    public void testEqualsWithEmptyMaps() {
        // Get final metadata
        try (StreamInput in = out.bytes().streamInput()) {
            builder.cancelSplit(shardId);
import org.opensearch.core.common.io.stream.StreamInput;
        // Verify the nested split results
     * Tests the Builder constructor with a SplitShardsMetadata instance where some root shards have no children.  
        } else {
            builder.updateSplitMetadataForChildShards(shardId, splitCompletingShards.get(shardId));
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);  
     */  
        builder.updateSplitMetadataForChildShards(sourceShardId, newChildShardIds);  
        assertTrue(exception.getMessage().contains("Cannot split shard [0] further."));
    }
        builder = new SplitShardsMetadata.Builder(metadata);
     * Expected behavior: Should return 0 for empty metadata  
        SplitShardsMetadata metadata = new SplitShardsMetadata.Builder(1).build();  
    public void testEqualsMethod() {  
            SplitShardsMetadata applied = deserializedDiff.apply(before);  
        SplitShardsMetadata deserialized = streamRoundTrip(original);  
    }
        // put details for splitting shard into parent-to-child map
        builder = new SplitShardsMetadata.Builder(metadata);
        builder = new SplitShardsMetadata.Builder(builder.build());  
        builder.splitShard(1, 4);
        SplitShardsMetadata.Builder builder1 = new SplitShardsMetadata.Builder(3);
        builder.splitShard(0, 2);
    public void testUpdateSplitMetadataForChildShards_NoSplitInProgress() {
    public void testIsSplitOfShardInProgress_CorrectShardInProgress() {
        // Setup  
        metadata = builder.build();  
        assertTrue("No split should be in progress", metadata.getInProgressSplitShardIds().isEmpty());
        // split completed for shard 0
                } catch (Exception ex) {
        }
        List<Integer> result = new ArrayList<>();  
    /**
            finishPendingSplits(cancellableShards, splitCompletingShards, metadata);
        SplitShardsMetadata metadata = new SplitShardsMetadata.Builder(maxShardId + 1).build();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validateShardRanges(0, missingRange));
    public void testGetNumberOfRootShardsWithEmptyMetadata() {
    private void finishPendingSplits(  
        metadata = builder.build();
        existingShards.remove(splittingShard);  
    }  
 * compatible open source license.
        // Test 9: Symmetric equality
        Iterator<Integer> shardIterator = metadata.getActiveShardIterator();
            validateShardsInExistingAndNewMetadata(metadata, builder.build(), splitCompletingShards.get(shardId), shardId);  
    public void testGetChildShardsOfParentWithUnsplitShard() {
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
    }  
        }
        // Verify split is in progress
        builder.updateSplitMetadataForChildShards(1, Set.of(6, 7));  
        while (shardIterator.hasNext()) {  
        assertFalse(iterator.hasNext());
        int sourceShardId = 2;
        builder.cancelSplit(0);
import java.util.ArrayList;  
        diff.writeTo(out);  
        // Verify the split was canceled
        SplitShardsMetadata result = newBuilder.build();
        builder.startObject();  
    public void test_getActiveShardIterator_consecutiveSplits() {
            assertTrue(finalShards.remove(shardIterator.next()));
    }
            assertTrue("Shard ranges should be in order", secondLevelShards[i].end() < secondLevelShards[i + 1].start());
        ShardRange[] firstLevelShards = metadata.getChildShardsOfParent(0);  
    }
        SplitShardsMetadata metadata = builder.build();
     */
            assertTrue(finalShards.remove(nextShard));
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
    public void testSplitCancelWhenAnotherSplitIsInProgress() {  
     */
        builder = new SplitShardsMetadata.Builder(builder.build());  
        builder.splitShard(0, 2);  
            Diff<SplitShardsMetadata> deserializedDiff = SplitShardsMetadata.readDiffFrom(in);
    }
    public void test_getActiveShardIterator_splitInProgress() {
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1); // Start with 1 root shard
        SplitShardsMetadata metadata = builder.build();
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
    public void testSplitShardWithCompletedSplit() {
        SplitShardsMetadata emptyMetadata = new SplitShardsMetadata.Builder(0).build();
    public void testGetInProgressSplitShardIdAfterCompletingSplit() {  
            ShardRange[] shardRanges = newMetadata.getChildShardsOfParent(splittingShard);  
        Set<Integer> finalShards = new HashSet<>(Arrays.asList(1, 3, 4, 9, 10, 11, 12, 13));  
        Set<Integer> newChildShardIds = new HashSet<>();
    }
        builder.cancelSplit(0);
        int result = metadata.getShardIdOfHash(rootShardId, hash, includeInProgressChildren);
        builder.splitShard(0, 3);
    public void testGetRootShards_splitCompleted() {
        }
     */  
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1); // Start with 1 root shard
    }
            }  
    /**
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
        builder.splitShard(sourceShardId, numberOfChildren);  
        when(emptyInput.available()).thenReturn(0);
        SplitShardsMetadata deserialized = xContentRoundTrip(original);  
        SplitShardsMetadata emptyMetadata = new SplitShardsMetadata.Builder(0).build();  
        ShardRange[] overlappingRanges = new ShardRange[] {  
        builder.updateSplitMetadataForChildShards(12, Set.of(7, 8, 14));
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
        // Assert  
    }  
        try (StreamInput in = out.bytes().streamInput()) {
        SplitShardsMetadata metadata = builder.build();  
        builder.cancelSplit(0);
        SplitShardsMetadata metadata = builder.build();  
     * Tests get active shard iterator for split completed  
                List<Integer> activeAndNotInProgress = getActiveAndNotInProgressShards(metadata);
            assertFalse(newMetadata.getInProgressSplitShardIds().contains(splittingShard));
     * Test case for getChildShardsOfParent when the parent shard has child shards
        childShards.forEach(shard -> newChildShardIds.add(shard.shardId()));
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(2);  
        SplitShardsMetadata original = new SplitShardsMetadata.Builder(5).build();
     */  
        Set<Integer> finalShards = new HashSet<>(Arrays.asList(2, 3, 4, 5, 6, 7));  
    }  
    }
        builder.splitShard(1, 3);
    public void testEqualsWithNullArrayElements() {  
        SplitShardsMetadata metadata = builder.build();
        SplitShardsMetadata metadata2 = new SplitShardsMetadata.Builder(2).build();
        assertEquals(0, result);
        Set<Integer> inProgressSplitShards = Set.of(0);  
        }  
            existingShards.add(shardIterator.next());  
            shardsFromNewMetadata.add(shardIterator.next());
    public void testGetShardIdOfHashWithNoChildren() {
        int result = metadata.getNumberOfShards();
    }
        while (shardIterator.hasNext()) {  
        SplitShardsMetadata consecutiveShardSplitMetadata = builder.build();
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
    }
        assertEquals(actualActiveShardsForConsecutiveShardSplit, expectedActiveShardsForConsecutiveShardSplit);
            metadata = builder.build();  
        int result = builder.build().getShardIdOfHash(0, 100, false);  
    }  
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
        Set<Integer> newChildShardIds = new HashSet<>();
                assertTrue(newShards.contains(shardRange.shardId()));  
        // Verify ranges are properly distributed
        }
            assertTrue(finalShards.remove(nextShard));  
        SplitShardsMetadata metadata = builder.build();  
        int inProgressSplitShardId = 1;
        List<Integer> expectedRootShards = List.of(0, 1, 2);
    }
        int actualRootShards = metadata.getNumberOfRootShards();
     * Test for no split data
        Set<Integer> expectedActiveShards = Set.of(0, 1, 2);
        Set<Integer> actualActiveShardsForConsecutiveShardSplit = new HashSet<>();
        // Test 1: Same object reference
            "Objects with different parentToChildShards should not be equal",  
import java.util.HashMap;
        builder.splitShard(0, 2);
import java.util.Arrays;
        };  
        // Verify range boundaries
        // Setup
    }
        assertEquals(original, deserialized);
        assertEquals(2, childShards.length);  
        // Build the metadata
        assertEquals(expectedRootShards, rootShards);
        builder = new SplitShardsMetadata.Builder(builder.build());
        int numberOfShards = 5;  
                    if (cancelSplit) {
            int nextShard = shardIterator.next();  
        builder.splitShard(2, 5);
            }
    }
        SplitShardsMetadata.Builder builder3 = new SplitShardsMetadata.Builder(2);
        assertTrue(finalShards.isEmpty());  
        builder.splitShard(0, 3);  
     */  
     */  
        // Split the root shard into 3 pieces  
    public void testGetNumberOfRootShardsReturnsCorrectCount() {  
        // Complete the split with three child shards
        // Verify first split
                        metadata = builder.build();
        // Test 8: Different parentToChildShards  
        Set<Integer> newChildShardIds = new HashSet<>();
        builder.splitShard(2, 5);  
    public void testGetShardIdOfHashWithInProgressSplit() {  
        builder2.updateSplitMetadataForChildShards(0, Set.of(2, 3));
        builder = new SplitShardsMetadata.Builder(metadata);  
        assertEquals(numberOfChildren, childShards.length);
        Set<Integer> actualActiveShards = new HashSet<>();  
        SplitShardsMetadata.Builder originalBuilder = new SplitShardsMetadata.Builder(3);
        SplitShardsMetadata metadata = builder.build();  
    }
    public void testDiffSerde() throws IOException {
        // split completed for shard 1
/*  
    public void testUpdateSplitMetadataWithInvalidSourceShardId() {  
        for (Iterator<Integer> it = metadata.getActiveShardIterator(); it.hasNext();) {
        assertEquals(actualActiveShards, expectedActiveShards);
    }
     * Test that cancelSplit correctly removes the in-progress split and resets the inProgressSplitShardId
    }
                        validateShardsInExistingAndNewMetadata(metadata, builder.build(), childShardIds, splittingShard);
        Set<Integer> childShardIds = Set.of(1, 2, 3);  
        assertNull("Should return null for unsplit shard", metadata.getChildShardsOfParent(0));
    public void testGetNumberOfShardsAfterSplitting() {
        ShardRange[] childShards = metadata.getChildShardsOfParent(0);  
        List<Integer> rootShards = metadata.getRootShards();  
        SplitShardsMetadata metadata = builder.build();
        int hash = 500;
}
        while (shardIterator.hasNext()) {
        builder.splitShard(0, 3);  
        }
    public void testGetInProgressSplitShardIdWithValidSplitInProgress() {
                                                                                                                                             // range
    }
    }
        // Should return only active child shards  
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);  
    public void testXContentSerdeConsecutiveSplits() throws IOException {  
        assertTrue(metadata.getInProgressSplitShardIds().isEmpty());
            assertTrue(finalShards.remove(nextShard));
    /**
            int nextShard = shardIterator.next();  
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
    public void testGetInProgressSplitShardId() {
     * Test case for updateSplitMetadataForChildShards method
    public void testUpdateSplitMetadataForChildShards_EmptyNewChildShardIds() {
    }
    }
        // Create a new Builder using the original SplitShardsMetadata
    }
        SplitShardsMetadata metadata1 = new SplitShardsMetadata.Builder(2).build();  
        builder.splitShard(2, 2);
            new ShardRange(0, 100, Integer.MAX_VALUE)  // Missing range at 101-199  
    }
        builder.splitShard(0, 3);
        for (Iterator<Integer> iterator = metadata.getActiveShardIterator(); iterator.hasNext();) {  
        BytesStreamOutput out = new BytesStreamOutput();  
            }
     */
    /**
        builder = new SplitShardsMetadata.Builder(metadata);
            "Equality should be transitive",
        assertEquals(numberOfShards, metadata.getNumberOfRootShards());
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3); // Start with 1 root shard  
        builder.splitShard(0, 2);  
    /**
        assertEquals("Hash should route to first child of in-progress split", 5, result);  
        // Assert - should route to the first child of the in-progress split
        Iterator<Integer> shardIterator = metadata.getActiveShardIterator();
        assertTrue(childShards[0].end() < childShards[1].start());
        builder.splitShard(0, 2);
    public void testSplitShardWhenAnotherSplitIsCancelled_2() {  
    public void testReadDiffFromWithEmptyInput() throws IOException {  
        // split
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4));  
        );
        builder.splitShard(0, 2);
    private void ensureUniqueChildShards(SplitShardsMetadata previousMetadata, Set<Integer> childShards, SplitShardsMetadata newMetadata) {
        newChildShardIds.add(2);
    }
        assertEquals(expectedActiveShardsForConsecutiveShardSplit, actualActiveShardsForConsecutiveShardSplit);
            actualActiveShardsForConsecutiveShardSplit.add(it.next());  
            builder = new SplitShardsMetadata.Builder(metadata);
        int result = metadata.getShardIdOfHash(rootShardId, hash, includeInProgressChildren);  
        while (shardIterator.hasNext()) {
            createDummySplitShardsMetadataWithNoRandomisation().hashCode(),
        builder.splitShard(0, 3);
        newChildShardIds.add(7);
     * Test getShardIdOfHash when root shard has children but no in-progress splits  
        SplitShardsMetadata.Builder builder1 = new SplitShardsMetadata.Builder(1);
        assertNull(result.getChildShardsOfParent(1));
        for (int i = 0; i < numberOfShards; i++) {  
        int parentShardId = 2;
        // Execute
     */  
        assertTrue(metadata.isSplitOfShardInProgress(2));  
        assertTrue(finalShards.isEmpty());  
    public void testHashCodeAndEquals() {
        ShardRange[] smallRange = new ShardRange[] { new ShardRange(0, Integer.MIN_VALUE, Integer.MIN_VALUE + 10) };
    }
import org.opensearch.test.OpenSearchTestCase;  
        builder = new SplitShardsMetadata.Builder(builder.build());
    private SplitShardsMetadata streamRoundTrip(SplitShardsMetadata original) throws IOException {
        SplitShardsMetadata metadata = builder.build();  
        builder.splitShard(0, 2);
        // Verify that returned child shards match across calls  
        assertEquals("Hash should route to first child of nested split", 3, metadata.getShardIdOfHash(0, hashInFirstThird, true));
        // Split in progress, should return all 4 shards
    public void testStreamSerdeNoSplit() throws IOException {
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
        rootToChildShards[0] = new ShardRange[2];  
        builder.endObject();
        // Act  
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> validateShardRanges(0, new ShardRange[0]));  
    /**
        assertTrue(finalShards.isEmpty());
    public void testXContentSerdeSplitCompleted() throws IOException {  
        assertTrue(exception.getMessage().contains("Shard range from 101 to 199 is missing from the list of shard ranges"));
    }
        metadata = builder.build();
            assertEquals(existingShards.size(), shardsFromNewMetadata.size());
        // Test overlapping ranges
     * Test case for in-progress split being ignored
    }  
                builder = new SplitShardsMetadata.Builder(metadata);  
    public void testGetNumberOfShardsWithEmptyMetadata() {
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
     * Test case for getChildShardsOfParent after a cancelled split operation
        // Test 10: Transitive equality
        shardIterator = newMetadata.getActiveShardIterator();  
        // Test: When there are no children, should return the root shard id
    /**
        // 7. 1=>X, 1,2,3,4,8 hoes is 5,6,7 m=  
        SplitShardsMetadata metadata = builder.build();
        while (shardIterator.hasNext()) {
        // Verify
    ) {  
        // Setup
        SplitShardsMetadata metadata = builder.build();
        builder = new SplitShardsMetadata.Builder(metadata);
        assertFalse("Objects with different inProgressSplitShardId should not be equal", metadata1.equals(withSplit));  
    /**  
        builder.splitShard(2, 2);
        builder.updateSplitMetadataForChildShards(0, Set.of(5, 6));
        assertTrue(builder.build().getInProgressSplitShardIds().contains(sourceShardId));  
        assertEquals(expectedRootShards, rootShards);
            return SplitShardsMetadata.parse(parser);
    }
    }
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
     * Expected behavior: Should return the same number of root shards  
        SplitShardsMetadata metadata2 = builder2.build();
        assertNotNull(childShards);
        Set<Integer> expectedActiveShardsForConsecutiveShardSplit = Set.of(1, 2, 3, 4, 5);
        }
        assertTrue(metadata.getInProgressSplitShardIds().isEmpty());
                        builder.updateSplitMetadataForChildShards(splittingShard, childShardIds);
        int result = metadata.getShardIdOfHash(0, 500, true);  
        // First split - create existing child shards
     */
        while (shardIterator.hasNext()) {
        SplitShardsMetadata newMetadata,  
                boolean cancelSplit = randomBoolean();
    }
     */  
        Set<Integer> finalShards = new HashSet<>(Arrays.asList(0, 1, 2));
        builder = new SplitShardsMetadata.Builder(builder.build());
        // 2. 0 -> 3,4
        builder.splitShard(0, 3);  
    public void testUpdateSplitMetadataForChildShards_InvalidChildShardId() {  
        builder.splitShard(0, 2);  
    }  
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4, 5));  
        BytesStreamOutput out = new BytesStreamOutput();
        newChildShardIds.add(5);
    public void testGetShardIdOfHashWithInProgressSplitIgnored() {
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1); // Start with 1 root shard  
            for (int j = 0; j < 10; j++) {
     */  
        int maxInitialShards = 20;
        builder = new SplitShardsMetadata.Builder(builder.build());
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(initialShards);
import org.mockito.Mockito;  
     */  
        builder3.updateSplitMetadataForChildShards(1, Set.of(2, 3));  
        assertEquals("Empty metadata should have 0 root shards", 0, emptyMetadata.getNumberOfRootShards());  
        }
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
        SplitShardsMetadata metadata1 = builder1.build();  
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);  
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
        // Test basic split operation  
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1); // 1 root shard
        // Setup
        int numberOfChildren = 2;
            Map<Integer, Set<Integer>> splitCompletingShards = new HashMap<>();  
                        cancellableShards.add(splittingShard);
            assertTrue(finalShards.remove(nextShard));
    }
        SplitShardsMetadata metadata = builder.build();
        ShardRange[] missingRange = new ShardRange[] { new ShardRange(0, Integer.MIN_VALUE, 100), new ShardRange(0, 200, Integer.MAX_VALUE)  // Missing
        SplitShardsMetadata original = builder.build();
            new ShardRange(0, Integer.MIN_VALUE, 100),
    }
        builder.updateSplitMetadataForChildShards(0, Set.of(1, 2));
        // Create metadata with null elements in rootShardsToAllChildren
        builder.cancelSplit(2);
        SplitShardsMetadata deserialized = xContentRoundTrip(original);
    /**  
        SplitShardsMetadata original = builder.build();
                        break;  
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4));  
        assertEquals(3, result.getNumberOfRootShards());  
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4, 5));  
        SplitShardsMetadata metadata3 = new SplitShardsMetadata.Builder(2).build();
        }  
        builder.splitShard(12, 3);
    }
                } else {  
        SplitShardsMetadata metadata = builder.build();  
            assertTrue(finalShards.remove(nextShard));
    /**  
        builder = new SplitShardsMetadata.Builder(builder.build());
    }
        Diff<SplitShardsMetadata> diff = after.diff(before);
        Set<Integer> actualShardIds = new HashSet<>();
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
    }
    public void test_getShardIdOfHash_withExistingChildren() {
 * SPDX-License-Identifier: Apache-2.0
                    throw ex;
        );
        shardIterator = metadata.getActiveShardIterator();  
        // Arrange
        original.writeTo(out);
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
                boolean complete = randomBoolean();  
        previousMetadata.getInProgressSplitShardIds().forEach(shardId -> assertFalse(childShards.contains(shardId)));
        int expectedRootShards = 5;
        int splittingShard
        assertTrue(
     * Tests getShardIdOfHash when there are existing child shards and in-progress children.
        builder.splitShard(1, 3);
        }  
    public void testValidateShardRangesOverlap() {
                    if (cancelSplit) {
    public void testValidateShardRangesMissingRange() {
        builder = new SplitShardsMetadata.Builder(builder.build());
        builder = new SplitShardsMetadata.Builder(builder.build());  
    /**
        assertEquals(0, metadata.getShardIdOfHash(0, 100, false));
    public void testSplitShardWhenSplitAlreadyInProgress() {
                        builder = new SplitShardsMetadata.Builder(metadata);
    /**  
     */  
    public void testSplitShardBasicOperation() {
        // Act
                metadata = builder.build();
        // Assert
        assertEquals(2, childShards.length);
            actualActiveShards.add(it.next());
        assertEquals("Number of root shards should remain unchanged after splitting", 5, metadata.getNumberOfRootShards());  
        }
        SplitShardsMetadata.Builder newBuilder = new SplitShardsMetadata.Builder(original);
        shardIterator = metadata.getActiveShardIterator();  
    public void test_getShardIdOfHash_returnsRootShardId() {
        builder.splitShard(2, 5);
        SplitShardsMetadata deserialized = streamRoundTrip(original);  
        assertEquals(
        finalShards = new HashSet<>(Arrays.asList(1, 3, 5, 6, 7, 8, 9, 10, 11, 13, 14));
    public void testGetChildShardsOfParentAfterCancelledSplit() {
            assertEquals(after, applied);
        builder.updateSplitMetadataForChildShards(1, Set.of(5, 6, 7));
        List<Integer> expectedRootShards = List.of(0, 1, 2);
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);  
        metadata = builder.build();
        builder.splitShard(0, 2);
        }
    public void testGetActiveShardIterator_emptyIterator() {  
        metadata = builder.build();
        assertEquals("getNumberOfShards should return maxShardId + 1", maxShardId + 1, result);
        // First split - create existing child shards
                        validateShardsInExistingAndNewMetadata(metadata, builder.build(), new HashSet<>(), -1);  
        builder.splitShard(0, 3);
     */
                    builder.splitShard(splittingShard, numberOfChildren);  
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);  
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
                        splitCompletingShards.put(splittingShard, childShardIds);
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4, 5));  
        int maxShardId = 5;  
        builder.updateSplitMetadataForChildShards(2, Set.of(8, 9, 10, 11, 12));
                    } else {  
        // Split in progress, should return all 3 shards  
        assertEquals(original, deserialized);
    public void testIsSplitOfShardInProgress_DifferentShardInProgress() {  
        builder.splitShard(1, 2);  
        metadata = builder.build();
    /**  
        assertFalse("Objects with different maxShardId should not be equal", metadata1.equals(differentMaxShardId));  
            assertEquals(originalChildShards[i], childShards[i]);  
        builder.cancelSplit(1);
        builder.splitShard(0, 2);  
    }
     * Test getShardIdOfHash when root shard has no children but in-progress split exists
        assertThrows(AssertionError.class, () -> { builder.updateSplitMetadataForChildShards(0, newChildShardIds); });  
        SplitShardsMetadata deserialized = streamRoundTrip(original);
    public void testXContentSerdeSplitInProgress() throws IOException {
            metadata = builder.build();
            new ShardRange(0, 50, Integer.MAX_VALUE)  // Overlaps with previous range at 50-100
    /**
                    }
                    break;
        builder.splitShard(0, 3);
    public void testUpdateSplitMetadataForChildShards_MismatchedChildShardCount() {
        ShardRange[] originalChildShards = metadata.getChildShardsOfParent(parentShardId);
        // Should return root shard ID when includeInProgressChildren is false  
     * Expected behavior: Should return 0 for empty metadata
        for (int i = 0; i < splitExecCount; i++) {
            metadata.getInProgressSplitShardIds().contains(expectedShardId)  
                try {
        builder.splitShard(parentShardId, numberOfChildren);  
        assertEquals(actualActiveShards, expectedActiveShards);  
import java.util.Set;
        builder = new SplitShardsMetadata.Builder(builder.build());
        rootToChildShards[0][0] = new ShardRange(numberOfRootShards, 0, 100);
        assertEquals("First child should start at parent's start", parentRange.start(), secondLevelShards[0].start());
    }
        SplitShardsMetadata deserialized = streamRoundTrip(original);
        assertEquals(expectedActiveShards, actualShardIds);  
     * Test case for empty metadata
        SplitShardsMetadata metadata = builder.build();
        SplitShardsMetadata after = afterBuilder.build();
        parentToChildShards.put(inProgressSplitShardId, new ShardRange[2]);
        int splitExecCount = randomIntBetween(1, 20);  
            int nextShard = shardIterator.next();  
        assertNotNull(SplitShardsMetadata.readDiffFrom(emptyInput));  
        IllegalArgumentException exception = assertThrows(  
        builder.updateSplitMetadataForChildShards(2, Set.of(9, 10, 11, 12, 13));
                    if (ex.getMessage().equals("Cannot split shard [" + splittingShard + "] further.")) {
        metadata = builder.build();
        assertTrue(finalShards.isEmpty());
        SplitShardsMetadata splitCompletedShardSplitMetadata = builder.build();  
        // Test reusing holes in new split
        Set<Integer> expectedActiveShards = Set.of(0, 1, 2);
        SplitShardsMetadata metadata1 = builder1.build();
     */  
        builder.updateSplitMetadataForChildShards(4, Set.of(5, 6));  
            actualActiveShards.add(it.next());  
    }
        // Test missing range  
        for (int i = 0; i < secondLevelShards.length - 1; i++) {  
        }
                builder = new SplitShardsMetadata.Builder(metadata);
        Set<Integer> childShardIds = Set.of(1, 2, 3);
                                                                                                                                             // 101-199
        }
        metadata = builder.build();
        // 4. 0=>X  
    public void testValidateShardRangesBelowThreshold() {  
        parentToChildShards.put(0, new ShardRange[] { rootToChildShards[0][0], rootToChildShards[0][1] });
    private List<Integer> getActiveAndNotInProgressShards(SplitShardsMetadata metadata) {
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4, 5));  
     */
        SplitShardsMetadata metadata = builder.build();
        SplitShardsMetadata metadata2 = builder2.build();  
    }
        // Split in progress, should return all 3 shards
        assertTrue(finalShards.isEmpty());  
    }
    public void testValidateShardRangesInvalidStartRange() {
        }  
import org.opensearch.core.xcontent.ToXContent;  
import java.util.Map;  
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
        // test shard range not at Integer.Min  
        List<ShardRange> childShards = builder.splitShard(0, 2);
            metadata.getInProgressSplitShardIds().contains(0)
        SplitShardsMetadata metadata = builder.build();  
    public void testSplitInvalidShardId() {
        builder.splitShard(0, 3);
 */  
        shardIterator = metadata.getActiveShardIterator();
        builder.splitShard(0, 2);  
        assertEquals(numberOfShards, metadata.getNumberOfShards());  
        for (int i = 0; i < childShards.length; i++) {
     * Test case for getting number of shards after splitting
        assertTrue(metadata.isSplitOfShardInProgress(0));
        assertTrue(exception2.getMessage().contains("No shard range defined for child shards of shard 0"));
        builder.splitShard(1, 4);
    }
            "The in-progress split shard ID should match the expected value",
        builder = new SplitShardsMetadata.Builder(builder.build());  
        // 6. 0 completes 1,2,3,4,8 holes is 0, max shard id 8
        for (Iterator<Integer> it = metadata.getActiveShardIterator(); it.hasNext();) {
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
        assertEquals(childShards[0].end() + 1, childShards[1].start());  
        while (shardIterator.hasNext()) {
        SplitShardsMetadata existing,
        builder.splitShard(0, 3);
        assertThrows(IllegalArgumentException.class, () -> { builder.updateSplitMetadataForChildShards(1, newChildShardIds); });
        builder.splitShard(0, 2);
        // Setup - split root shard
        SplitShardsMetadata metadata = builder.build();
        assertTrue(exception.getMessage().contains("Shard range overlap"));  
    public void testIsSplitOfShardInProgress_NoSplitInProgress() {
        newChildShardIds.add(1);  
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4, 5));  
        assertFalse("Object should not be equal to null", metadata.equals(null));  
        builder = new SplitShardsMetadata.Builder(metadata);
            () -> builder.splitShard(10, 2) // Invalid shard ID
    }  
            assertTrue(shardsFromNewMetadata.containsAll(newShards));  
        SplitShardsMetadata metadata = builder.build();  
        builder.cancelSplit(sourceShardId);  
        SplitShardsMetadata withDifferentParentToChild = builder3.build();
            assertNull(metadata.getChildShardsOfParent(i));
     * Test that the method returns false when a different shard is being split.
        SplitShardsMetadata metadata = builder.build();
        metadata = builder.build();  
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);  
        // Empty shard range
        // Test reusing holes in new split
        builder = new SplitShardsMetadata.Builder(metadata);
 * this file be licensed under the Apache-2.0 license or a
        SplitShardsMetadata withSplit = builder1.build();
        // Execute - test hash that falls in the range of first child of shard 2
        assertEquals(original, deserialized);
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
        int initialShards = randomIntBetween(1, maxInitialShards);  
     */
        assertTrue("Two equivalent objects should be equal", metadata1.equals(metadata2));
            for (ShardRange shardRange : shardRanges) {
     */  
        assertEquals(3, metadata.getNumberOfShards());
     * Test case for SplitShardsMetadata.Builder constructor with numberOfShards parameter  
        ShardRange[][] rootToChildShards = new ShardRange[numberOfRootShards][];
        builder.updateSplitMetadataForChildShards(0, Set.of(1, 2));  
    public void testGetNumberOfRootShardsAfterSplitting() {
        assertEquals(original, deserialized);  
        return new SplitShardsMetadata(rootToChildShards, parentToChildShards, inProgressSplitShards, activeShards, 0);  
            int nextShard = shardIterator.next();  
        assertNotNull(childShards);  
        // 3. 1 -> 5, 6, 7
import org.opensearch.cluster.Diff;
        // Test range below threshold
    public void testSplitShardWhenAnotherSplitIsCancelled_1() {  
        assertEquals(2, result);  
        assertEquals(3, metadata.getNumberOfShards());
        // Assert  
        assertTrue(metadata.getInProgressSplitShardIds().isEmpty());  
    public void testGetInProgressSplitShardIdWhenNoSplitInProgress() {
    }
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
        SplitShardsMetadata metadata = builder.build();  
        for (Integer shardId : cancellableShards) {  
        builder.updateSplitMetadataForChildShards(0, childShardIds);
        builder.updateSplitMetadataForChildShards(0, childShardIds);
    }
     * Test case for getChildShardsOfParent with an unsplit shard
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(numberOfShards);  
    }
        // Test hash routing through the nested structure
        assertNull("Should return null for shard with cancelled split", metadata.getChildShardsOfParent(0));
                    builder = new SplitShardsMetadata.Builder(metadata);
        assertTrue(finalShards.isEmpty());
            int nextShard = shardIterator.next();  
        }
        }
        assertTrue(newChildShardIds.contains(childShards[0].shardId()));
        builder.splitShard(sourceShardId, 2);
        builder.splitShard(0, 2);  
        SplitShardsMetadata original = builder.build();
        assertEquals("Last child should end at parent's end", parentRange.end(), secondLevelShards[secondLevelShards.length - 1].end());
        return result;
package org.opensearch.cluster.metadata;
    public void testSplitShardWithInvalidNumberOfChildren() {
        afterBuilder.splitShard(0, 3);
        assertEquals("Should return the root shard ID when there are no children", rootShardId, result);
        Iterator<Integer> shardIterator = previousMetadata.getActiveShardIterator();
        // Arrange
        // First split - create existing child shards  
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(0); // maxShardId = -1
        SplitShardsMetadata metadata = new SplitShardsMetadata.Builder(1).build();
        SplitShardsMetadata metadata  
                        validateShardsInExistingAndNewMetadata(metadata, builder.build(), childShardIds, splittingShard);  
        List<Integer> rootShards = metadata.getRootShards();  
        // First split - split root shard 0 into two children (shards 1 and 2)  
        assertNull(result.getChildShardsOfParent(0));
    }  
        Iterator<Integer> shardIterator = metadata.getActiveShardIterator();
    /**
        for (Iterator<Integer> it = splitCompletedShardSplitMetadata.getActiveShardIterator(); it.hasNext();) {
     */
            withDifferentRootShards.equals(withDifferentParentToChild)
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3);
        );
        assertFalse("Should not be equal to different class", metadata.equals(new Object()));  
        SplitShardsMetadata original = originalBuilder.build();
        // Assert that child shards are returned and match the expected number
    private void validateShardsInExistingAndNewMetadata(
        builder.splitShard(3, 2);
        // Get child shards of the parent
        finalShards = new HashSet<>(Arrays.asList(1, 3, 5, 6, 9, 10, 11, 12, 13));
        int result = metadata.getShardIdOfHash(0, 100, true);
    }  
        Set<Integer> finalShards = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        builder = new SplitShardsMetadata.Builder(metadata);
        Map<Integer, Set<Integer>> splitCompletingShards,
        ShardRange[] childShards = metadata.getChildShardsOfParent(sourceShardId);
        int hash = 123;
            assertTrue(finalShards.remove(nextShard));  
        assertNotNull("First level split should create child shards", firstLevelShards);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validateShardRanges(0, smallRange));
        // split completed for shard 0
        builder.updateSplitMetadataForChildShards(1, Set.of(5, 6, 7));
        // Case 1
        // Second split - split first child shard (shard 1) into three children
     */  
    }
        int rootShardId = 0;  
            assertEquals(shardRanges.length, newShards.size());
        builder.splitShard(0, 3);  
import java.io.IOException;
    public void testStreamSerdeConsecutiveSplits() throws IOException {  
        newChildShardIds.add(5);
        if (newShards.isEmpty()) {  
        builder.updateSplitMetadataForChildShards(12, Set.of(7, 8, 14));
                result.add(shardId);
        shardIterator = metadata.getActiveShardIterator();
import org.opensearch.core.xcontent.XContentBuilder;
        builder.splitShard(4, 2);
        XContentBuilder builder = JsonXContent.contentBuilder();
        );  
        while (shardIterator.hasNext()) {
        // split in progress for shard 1
    }
        builder2.splitShard(0, 2);
        // Act & Assert
    }  
    }
import org.opensearch.core.xcontent.XContentParser;
        }
        builder.splitShard(0, 2);  
        SplitShardsMetadata metadata = builder.build();
            if (metadata.getInProgressSplitShardIds().contains(shardId) == false) {
    public void testGetNumberOfShardsReturnsMaxShardIdPlusOne() {
        assertThrows(AssertionError.class, () -> { builder.updateSplitMetadataForChildShards(0, newChildShardIds); });  
        for (Iterator<Integer> it = consecutiveShardSplitMetadata.getActiveShardIterator(); it.hasNext();) {
        shardIterator = metadata.getActiveShardIterator();
            return new SplitShardsMetadata(in);  
        SplitShardsMetadata original = builder.build();
        Set<Integer> existingShards = new HashSet<>();
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4));
        // Assert  
        // Create a builder and add some child shards for a parent
        builder.splitShard(2, 5);
                                                                                                                                             // at  
        builder.updateSplitMetadataForChildShards(0, Set.of(1, 2, 3));
        assertTrue(result.getInProgressSplitShardIds().isEmpty());
        SplitShardsMetadata deserialized = xContentRoundTrip(original);
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(3); // Start with 1 root shard  
        // Cancel the split
                int numberOfChildren = randomIntBetween(1, 50);  
    }  
    public void testUpdateSplitMetadataForChildShards_Success() {
    public void testGetChildShardsOfParentWithExistingChildren() {
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
            metadata1.equals(metadata2) && metadata2.equals(metadata3) && metadata1.equals(metadata3)
        builder.cancelSplit(1);
        for (Integer shardId : splitCompletingShards.keySet()) {  
            int nextShard = shardIterator.next();
        ShardRange[] childShards = metadata.getChildShardsOfParent(parentShardId);  
    }
import org.opensearch.core.common.bytes.BytesReference;
        }
        Set<Integer> actualActiveShardsForConsecutiveShardSplit = new HashSet<>();  
    public void testXContentSerdeNoSplit() throws IOException {
        // Execute - test with hash that should go to second child  
                if (childShardRanges.size() != childShardIds.size()) {
        ShardRange parentRange = firstLevelShards[0]; // Range of shard 1  
                    }
    }
    }
                }
    }
        assertTrue("Original shard 0 should be split", metadata.isSplitParent(0));
    }
                    }
        SplitShardsMetadata metadata = builder.build();
        builder.splitShard(expectedShardId, 2);
        SplitShardsMetadata original = builder.build();
            int shardId = shardIterator.next();  
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
        assertNull(metadata.getChildShardsOfParent(sourceShardId));
        }
        Set<Integer> shardsFromNewMetadata = new HashSet<>();
    }  
        builder.updateSplitMetadataForChildShards(2, Set.of(9, 10, 11, 12, 13));  
        // Build the metadata
        Set<Integer> existingShards = new HashSet<>();  
        SplitShardsMetadata metadata = builder.build();
    }  
        SplitShardsMetadata deserialized = xContentRoundTrip(original);  
        assertEquals("Number of root shards should match the initial count", expectedRootShards, actualRootShards);
        builder.splitShard(0, 3);  
        SplitShardsMetadata.Builder builder2 = new SplitShardsMetadata.Builder(2);  
 * The OpenSearch Contributors require contributions made to  
        }
        while (shardIterator.hasNext()) {  
     * Verifies that the method correctly updates the metadata for child shards
        assertEquals("Should route to second child shard", 2, result);
        childShards.forEach(shard -> assertFalse(existingShards.contains(shard)));
        // Start a split
     * Test that the method returns false when no split is in progress.
        assertEquals("Should have 2 child shards", 2, firstLevelShards.length);
        }
                }  
        SplitShardsMetadata.Builder afterBuilder = new SplitShardsMetadata.Builder(3);  
                    } else {
        }
        // Second split - split the middle shard (ID 2)
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(metadata);
        assertEquals("Empty metadata should have 0 shards", 0, emptyMetadata.getNumberOfShards());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validateShardRanges(0, overlappingRanges));
    public void test_getActiveShardIterator_splitCompleted() {
    public void testBuilderWithEmptyRootShards() {
     * Tests get active shard iterator for split in progress
        assertEquals(createDummySplitShardsMetadataWithNoRandomisation(), createDummySplitShardsMetadataWithNoRandomisation());  
    /**
        builder = new SplitShardsMetadata.Builder(builder.build());  
            assertEquals("Shard ranges should be contiguous", secondLevelShards[i].end() + 1, secondLevelShards[i + 1].start());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { builder.splitShard(0, 2); });  
        while (shardIterator.hasNext()) {
        assertTrue("Same object should be equal to itself", metadata.equals(metadata));  
        parentToChildShards.get(inProgressSplitShardId)[0] = new ShardRange(numberOfRootShards + 2, 0, 100);  
     * Test that getNumberOfRootShards returns the correct number of root shards
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1);
        int expectedShardId = 5;
        builder3.splitShard(1, 2);  // Split different shard
        Iterator<Integer> iterator = metadata.getActiveShardIterator();  
            int nextShard = shardIterator.next();
import java.util.Iterator;
        // Verify shard ranges
        assertTrue(shardsFromNewMetadata.containsAll(existingShards));
            createDummySplitShardsMetadataWithNoRandomisation().hashCode()  
                        builder.updateSplitMetadataForChildShards(splittingShard, childShardIds);
        // Test 3: Different class
     * Test that the method returns true when the correct shard is being split.  
        builder.updateSplitMetadataForChildShards(1, Set.of(3, 4, 5));  
    private SplitShardsMetadata xContentRoundTrip(SplitShardsMetadata original) throws IOException {
        builder.splitShard(0, 2);  
    public void testGetRootShards_splitInProgress() {
        assertEquals(original, deserialized);  
     */
    public void testChildShardIdsGeneration() {
        builder.splitShard(0, 2);
        builder.splitShard(12, 3);
            assertTrue(finalShards.remove(nextShard));
        Set<Integer> activeShards = Set.of(0);
    ) {
import java.util.List;
        assertTrue(finalShards.isEmpty());  
import org.opensearch.common.io.stream.BytesStreamOutput;
    /**
        while (shardIterator.hasNext()) {
        int numberOfShards = 5;  
        }
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);
        // 5. 0 -> 3,4,8
     */
        assertThrows(AssertionError.class, () -> { builder.updateSplitMetadataForChildShards(0, newChildShardIds); });
    /**
        builder = new SplitShardsMetadata.Builder(builder.build());  
        int rootShardId = 0;
        }
        // Create metadata with empty parentToChildShards maps  
        Set<Integer> newChildShardIds = new HashSet<>(Arrays.asList(2, 3));  
     * correctly returns maxShardId + 1
        );
                }
        builder = new SplitShardsMetadata.Builder(builder.build());  
        Set<Integer> cancellableShards,
        SplitShardsMetadata original = new SplitShardsMetadata.Builder(5).build();
            existingShards.add(shardIterator.next());
                childShardRanges.forEach(shardRange -> childShardIds.add(shardRange.shardId()));
        assertEquals(original, deserialized);
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(5);  
        SplitShardsMetadata metadata = builder.build();
        SplitShardsMetadata.Builder builder2 = new SplitShardsMetadata.Builder(3);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> validateShardRanges(0, missingRange));
            validateShardsInExistingAndNewMetadata(metadata, builder.build(), new HashSet<>(), -1);
        ShardRange[] missingRange = new ShardRange[] {
    /**
        assertTrue("Objects with null array elements should be equal if structure is same", metadata1.equals(metadata2));
        // 1. 0,1,2 original  
        SplitShardsMetadata metadata = builder.build();
        // Test 5: Different maxShardId
        assertEquals("Should have 3 child shards", 3, secondLevelShards.length);
     * Tests get active shard iterator for consecutive split  
        while (shardIterator.hasNext()) {
    /**
        // Act
    }
import static org.mockito.Mockito.when;  
        builder.updateSplitMetadataForChildShards(0, Set.of(3, 4, 5));
    }
        // split completed for shard 0
            actualShardIds.add(iterator.next());
        assertTrue(metadata.getInProgressSplitShardIds().isEmpty());
        };
        assertTrue(exception.getMessage().startsWith("Split of shard [0] is already in progress or completed."));
        assertTrue("After canceling a split, shard split shouldn't be in progress", metadata.getInProgressSplitShardIds().isEmpty());  
public class SplitShardsMetadataTests extends OpenSearchTestCase {
        boolean includeInProgressChildren = true;  
        assertFalse(
        Set<Integer> newChildShardIds = new HashSet<>();
        int sourceShardId = 0;
        SplitShardsMetadata.Builder builder = new SplitShardsMetadata.Builder(1); // Start with 1 root shard
                assertEquals(childShardRanges.size(), childShardIds.size());
    /**
        Map<Integer, ShardRange[]> parentToChildShards = new HashMap<>();
        Set<Integer> actualActiveShards = new HashSet<>();
                        metadata = builder.build();
        builder = new SplitShardsMetadata.Builder(builder.build());
        SplitShardsMetadata metadata = new SplitShardsMetadata.Builder(5).build();
        Set<Integer> newShards,
        builder = new SplitShardsMetadata.Builder(builder.build());  
        // Complete the split with three child shards  
        SplitShardsMetadata before = new SplitShardsMetadata.Builder(3).build();
        Iterator<Integer> shardIterator = metadata.getActiveShardIterator();
