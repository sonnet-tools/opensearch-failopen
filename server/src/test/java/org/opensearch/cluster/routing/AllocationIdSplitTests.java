        AllocationId child = AllocationId.newTargetSplit(parent, parent.getSplitChildAllocationIds().get(0));
        assertEquals(split.getId(), cancelled.getId());
        assertNotEquals(a, b);
        assertEquals(childAllocId, child.getId());
        original.writeTo(out);
    public void testSerializationRoundTripWithParentId() throws IOException {
        AllocationId b = AllocationId.newSplit(AllocationId.newInitializing(), 2);
        AllocationId child = AllocationId.newTargetSplit(parent, parent.getSplitChildAllocationIds().get(0));
        AllocationId split = AllocationId.newSplit(AllocationId.newInitializing(), 2);
 * The OpenSearch Contributors require contributions made to
        AllocationId reloc = AllocationId.newRelocation(init);
        String childAllocId = parent.getSplitChildAllocationIds().get(0);
 * SPDX-License-Identifier: Apache-2.0
        split.toXContent(builder, null);
 */
        child.writeTo(out);
        BytesStreamOutput out = new BytesStreamOutput();
        AllocationId parsed = AllocationId.fromXContent(parser);
        assertNull(child.getRelocationId());
        AllocationId split = AllocationId.newSplit(original, 3);
        assertEquals(parent.getId(), child.getParentAllocationId());
        AllocationId original = AllocationId.newInitializing();
    public void testNewSplitCreatesChildAllocationIds() {
    public void testToStringWithSplitFields() {
    public void testToXContentWithParentAllocationId() throws IOException {
        assertTrue(json.contains("parent_allocation_id"));
        AllocationId deserialized = new AllocationId(in);
        split.toXContent(builder, null);
        XContentBuilder builder = JsonXContent.contentBuilder();
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.core.xcontent.XContentBuilder;
 *
        AllocationId init = AllocationId.newInitializing();
        AllocationId cancelled = AllocationId.cancelSplit(split);
        AllocationId split = AllocationId.newSplit(AllocationId.newInitializing(), 5);
        assertNull(target.getParentAllocationId());
        // Different ids, so not equal
        assertEquals(child, deserialized);
        BytesStreamOutput out = new BytesStreamOutput();
        AllocationId target = AllocationId.newTargetRelocation(reloc);
    }
import org.opensearch.common.xcontent.json.JsonXContent;
        XContentBuilder builder = JsonXContent.contentBuilder();
        assertNull(finished.getSplitChildAllocationIds());
        assertTrue(json.contains(parent.getId()));
import org.opensearch.core.xcontent.XContentParser;
    }
        AllocationId child = AllocationId.newTargetSplit(parent, childAllocId);
    public void testToXContentWithSplitChildIds() throws IOException {
    public void testSplitChildAllocationIdsAreUnmodifiable() {
        assertEquals(original, deserialized);
    }
        assertNull(reloc.getSplitChildAllocationIds());
        assertTrue(str.contains(split.getId()));
        assertEquals(c, d);
    }
        assertNull(reloc.getParentAllocationId());
        assertTrue(str.contains("splitChildIds"));
        assertEquals(a, a);
 * this file be licensed under the Apache-2.0 license or a
        AllocationId a = AllocationId.newSplit(AllocationId.newInitializing(), 2);
        String str = split.toString();
    }
    public void testSerializationRoundTrip() throws IOException {
import java.util.List;
        child.toXContent(builder, null);
        assertNull(cancelled.getParentAllocationId());
        assertNull(target.getSplitChildAllocationIds());
        assertTrue(json.contains("split_child_allocation_ids"));
    public void testHashCodeWithSplitFields() {
        assertEquals(split, parsed);
        AllocationId original = AllocationId.newInitializing();
        XContentBuilder builder = JsonXContent.contentBuilder();
        assertNull(finished.getParentAllocationId());
        assertNotEquals(split.hashCode(), cancelled.hashCode());
    }
        StreamInput in = out.bytes().streamInput();
    public void testFromXContentRoundTripWithSplitFields() throws IOException {
        assertEquals(3, split.getSplitChildAllocationIds().size());
        AllocationId split = AllocationId.newSplit(AllocationId.newInitializing(), 2);
    }
        AllocationId split = AllocationId.newSplit(AllocationId.newInitializing(), 2);
        AllocationId finished = AllocationId.finishSplit(child);
        assertNull(cancelled.getSplitChildAllocationIds());
        assertNull(deserialized.getSplitChildAllocationIds());
        // Different hashcodes because split fields differ
        assertEquals(original.getId(), split.getId());
        AllocationId d = AllocationId.newInitializing("fixed-id");
        AllocationId a = AllocationId.newInitializing();
    public void testEqualsNullSplitFieldsMatchOriginal() {
        AllocationId deserialized = new AllocationId(in);
public class AllocationIdSplitTests extends OpenSearchTestCase {
    public void testCancelSplitClearsChildIds() {
        String json = builder.toString();
        AllocationId deserialized = new AllocationId(in);
        assertEquals(child.getId(), finished.getId());
package org.opensearch.cluster.routing;
    }
 * compatible open source license.
        AllocationId cancelled = AllocationId.cancelRelocation(reloc);
        assertNotNull(reloc.getRelocationId());
        StreamInput in = out.bytes().streamInput();
    public void testNewSplitChildIdsAreUnique() {
import java.io.IOException;
        AllocationId original = AllocationId.newSplit(AllocationId.newInitializing(), 3);
    }
        assertNull(finished.getSplitChildAllocationIds());
    }
        // Same object
        original.writeTo(out);
        assertEquals(5, childIds.stream().distinct().count());
        assertEquals(child.getParentAllocationId(), deserialized.getParentAllocationId());
        assertNull(split.getRelocationId());
    public void testSerializationRoundTripNoSplitFields() throws IOException {
        assertEquals(original.getSplitChildAllocationIds(), deserialized.getSplitChildAllocationIds());
        assertNull(cancelled.getSplitChildAllocationIds());
        AllocationId parent = AllocationId.newSplit(AllocationId.newInitializing(), 1);
        assertNotNull(split.getSplitChildAllocationIds());
        String json = builder.toString();
        AllocationId split = AllocationId.newSplit(AllocationId.newInitializing(), 2);
        assertNotEquals(a, b);
    }
        // Different random ids
        AllocationId child = AllocationId.newTargetSplit(parent, parent.getSplitChildAllocationIds().get(0));
        AllocationId parent = AllocationId.newSplit(AllocationId.newInitializing(), 2);
        List<String> childIds = split.getSplitChildAllocationIds();
    }
        AllocationId c = AllocationId.newInitializing("fixed-id");
    }
        AllocationId parent = AllocationId.newSplit(AllocationId.newInitializing(), 2);
        assertTrue(json.contains(split.getSplitChildAllocationIds().get(0)));
    }
/*
        AllocationId b = AllocationId.newInitializing();
        AllocationId split = AllocationId.newSplit(AllocationId.newInitializing(), 2);
        XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString());
    }
        assertNull(deserialized.getParentAllocationId());
    public void testEqualsWithSplitFields() {
    }
import org.opensearch.core.common.io.stream.StreamInput;
    public void testNewTargetSplitSetsParentAllocationId() {
    public void testRelocationFactoryMethodsPreserveNullSplitFields() {
        AllocationId finished = AllocationId.finishRelocation(reloc);
        BytesStreamOutput out = new BytesStreamOutput();
        AllocationId parent = AllocationId.newSplit(AllocationId.newInitializing(), 2);
    }
        AllocationId cancelled = AllocationId.cancelSplit(split);
        assertEquals(original, deserialized);
        expectThrows(UnsupportedOperationException.class, () -> split.getSplitChildAllocationIds().add("new-id"));
}
        assertNull(child.getSplitChildAllocationIds());
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(json.contains(split.getSplitChildAllocationIds().get(1)));
        assertNull(split.getParentAllocationId());
        StreamInput in = out.bytes().streamInput();
        AllocationId split = AllocationId.newSplit(AllocationId.newInitializing(), 2);
    public void testFinishSplitClearsParentId() {
        // Initializing with same id
