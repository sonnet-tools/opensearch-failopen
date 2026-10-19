import org.opensearch.core.xcontent.XContentBuilder;
    public void testEqualsNullSplitFieldsMatchOriginal() {  
        assertEquals(5, childIds.stream().distinct().count());  
    }
        AllocationId split = AllocationId.newSplit(original, 3);  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        AllocationId child = AllocationId.newTargetSplit(parent, parent.getSplitChildAllocationIds().get(0));
        child.toXContent(builder, null);  
    }
        StreamInput in = out.bytes().streamInput();
        AllocationId split = AllocationId.newSplit(AllocationId.newInitializing(), 2);
        assertNull(reloc.getSplitChildAllocationIds());
        assertEquals(3, split.getSplitChildAllocationIds().size());
        split.toXContent(builder, null);  
    public void testEqualsWithSplitFields() {
package org.opensearch.cluster.routing;
    public void testSerializationRoundTrip() throws IOException {
        AllocationId deserialized = new AllocationId(in);
        String childAllocId = parent.getSplitChildAllocationIds().get(0);
    }  
        AllocationId deserialized = new AllocationId(in);
        XContentBuilder builder = JsonXContent.contentBuilder();  
        assertTrue(str.contains(split.getId()));
 */  
        assertTrue(str.contains("splitChildIds"));  
        assertNull(finished.getSplitChildAllocationIds());
        // Different random ids
        AllocationId child = AllocationId.newTargetSplit(parent, parent.getSplitChildAllocationIds().get(0));
        child.writeTo(out);  
        assertNotNull(reloc.getRelocationId());  
        AllocationId target = AllocationId.newTargetRelocation(reloc);
        AllocationId parent = AllocationId.newSplit(AllocationId.newInitializing(), 2);
    public void testNewTargetSplitSetsParentAllocationId() {  
        AllocationId split = AllocationId.newSplit(AllocationId.newInitializing(), 2);
    }
        assertNotNull(split.getSplitChildAllocationIds());
        assertNull(target.getSplitChildAllocationIds());  
        assertNull(cancelled.getParentAllocationId());  
        XContentBuilder builder = JsonXContent.contentBuilder();
        assertNull(target.getParentAllocationId());
    }
        AllocationId a = AllocationId.newSplit(AllocationId.newInitializing(), 2);
        assertNull(finished.getSplitChildAllocationIds());
        AllocationId d = AllocationId.newInitializing("fixed-id");  
    }
        AllocationId b = AllocationId.newInitializing();
        AllocationId a = AllocationId.newInitializing();
 *
public class AllocationIdSplitTests extends OpenSearchTestCase {
    public void testSerializationRoundTripNoSplitFields() throws IOException {
import java.io.IOException;
        expectThrows(UnsupportedOperationException.class, () -> split.getSplitChildAllocationIds().add("new-id"));
        AllocationId parsed = AllocationId.fromXContent(parser);  
        assertNotEquals(a, b);  
    }
        AllocationId split = AllocationId.newSplit(AllocationId.newInitializing(), 2);
        AllocationId original = AllocationId.newSplit(AllocationId.newInitializing(), 3);
        assertEquals(child, deserialized);
        AllocationId c = AllocationId.newInitializing("fixed-id");
        AllocationId parent = AllocationId.newSplit(AllocationId.newInitializing(), 1);  
    public void testToXContentWithParentAllocationId() throws IOException {
        AllocationId cancelled = AllocationId.cancelSplit(split);  
        assertNull(split.getRelocationId());  
        AllocationId reloc = AllocationId.newRelocation(init);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(child.getParentAllocationId(), deserialized.getParentAllocationId());
        assertEquals(childAllocId, child.getId());  
}
import org.opensearch.core.common.io.stream.StreamInput;  
        String json = builder.toString();
        AllocationId original = AllocationId.newInitializing();
        StreamInput in = out.bytes().streamInput();
        AllocationId parent = AllocationId.newSplit(AllocationId.newInitializing(), 2);
import org.opensearch.test.OpenSearchTestCase;  
        AllocationId deserialized = new AllocationId(in);
        // Same object
        assertTrue(json.contains(split.getSplitChildAllocationIds().get(0)));
        assertNull(deserialized.getSplitChildAllocationIds());
        AllocationId finished = AllocationId.finishSplit(child);  
    public void testSplitChildAllocationIdsAreUnmodifiable() {  
        AllocationId child = AllocationId.newTargetSplit(parent, childAllocId);
        assertEquals(c, d);
import org.opensearch.common.xcontent.json.JsonXContent;
        XContentParser parser = createParser(JsonXContent.jsonXContent, builder.toString());
    }
    public void testCancelSplitClearsChildIds() {  
        assertNull(child.getSplitChildAllocationIds());
        assertEquals(original, deserialized);
    }
    public void testToStringWithSplitFields() {
        assertNotEquals(a, b);
        AllocationId finished = AllocationId.finishRelocation(reloc);  
        original.writeTo(out);  
    public void testToXContentWithSplitChildIds() throws IOException {
import java.util.List;  
import org.opensearch.core.xcontent.XContentParser;
    }  
        assertEquals(split, parsed);
        BytesStreamOutput out = new BytesStreamOutput();
        assertTrue(json.contains("parent_allocation_id"));
        // Initializing with same id
    }
    }  
    public void testFinishSplitClearsParentId() {  
        StreamInput in = out.bytes().streamInput();  
        AllocationId b = AllocationId.newSplit(AllocationId.newInitializing(), 2);  
        assertNull(finished.getParentAllocationId());  
    }
        AllocationId split = AllocationId.newSplit(AllocationId.newInitializing(), 2);
        assertEquals(original.getSplitChildAllocationIds(), deserialized.getSplitChildAllocationIds());
        assertTrue(json.contains("split_child_allocation_ids"));  
        AllocationId original = AllocationId.newInitializing();  
        assertNull(cancelled.getSplitChildAllocationIds());
        AllocationId split = AllocationId.newSplit(AllocationId.newInitializing(), 5);
        BytesStreamOutput out = new BytesStreamOutput();
        String json = builder.toString();
        AllocationId cancelled = AllocationId.cancelRelocation(reloc);  
        AllocationId parent = AllocationId.newSplit(AllocationId.newInitializing(), 2);
        assertNull(cancelled.getSplitChildAllocationIds());
        AllocationId init = AllocationId.newInitializing();
    public void testNewSplitCreatesChildAllocationIds() {
        assertEquals(a, a);  
/*  
        assertNull(child.getRelocationId());
        assertNotEquals(split.hashCode(), cancelled.hashCode());
        original.writeTo(out);
    public void testHashCodeWithSplitFields() {
    public void testNewSplitChildIdsAreUnique() {  
        AllocationId split = AllocationId.newSplit(AllocationId.newInitializing(), 2);  
        assertEquals(original.getId(), split.getId());
        assertEquals(parent.getId(), child.getParentAllocationId());  
    }  
    public void testFromXContentRoundTripWithSplitFields() throws IOException {  
    }
    }
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(json.contains(split.getSplitChildAllocationIds().get(1)));
        AllocationId cancelled = AllocationId.cancelSplit(split);
        assertNull(split.getParentAllocationId());  
        assertNull(reloc.getParentAllocationId());
        // Different ids, so not equal
        XContentBuilder builder = JsonXContent.contentBuilder();
        split.toXContent(builder, null);
        String str = split.toString();
        assertEquals(original, deserialized);  
        BytesStreamOutput out = new BytesStreamOutput();
        AllocationId split = AllocationId.newSplit(AllocationId.newInitializing(), 2);
    }
        assertNull(deserialized.getParentAllocationId());  
    public void testRelocationFactoryMethodsPreserveNullSplitFields() {  
    public void testSerializationRoundTripWithParentId() throws IOException {
        assertTrue(json.contains(parent.getId()));  
        List<String> childIds = split.getSplitChildAllocationIds();
        assertEquals(split.getId(), cancelled.getId());
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals(child.getId(), finished.getId());
        AllocationId child = AllocationId.newTargetSplit(parent, parent.getSplitChildAllocationIds().get(0));  
        // Different hashcodes because split fields differ
