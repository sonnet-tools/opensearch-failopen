        assertTrue(sortedSet.isEmpty() || sortedSet instanceof SortedSet<BytesRef>);  
        assertTrue(reverseList instanceof List<BytesRef>);
    public void testFrozen() {
    }
        Collection<BytesRef> reverseList = assertCollectionBuilt(bytesRefList);  
        Collection<BytesRef> bytesRefCollection = builder.get();
            || iterator2.hasNext();) {
        for (Iterator<BytesRef> iterator = bytesRefCollection.iterator(), iterator2 = sortedBytesRefs.iterator(); iterator.hasNext()  
        Collection<BytesRef> bytesRefCollection = builder.get();  
        assertNotNull(bytesRefCollection);
        return bytesRefCollection;
        assertEquals(seedStrings.length, bytesRefCollection.size());
    }
        assertThrows(UnsupportedOperationException.class, () -> bytesRefCollection.headSet(new BytesRef("a")));  
    public void testBuildSortedNotSorted() {
        sortedBytesRefs.stream().forEachOrdered(builder);  
    private static Collection<BytesRef> assertCollectionBuilt(List<BytesRef> sortedBytesRefs) {
        Stream.of("in", "order").map(BytesRef::new).forEachOrdered(builder);  
        assertSame(bytesRefCollection, builder.get());
    public void testCoverUnsupported() {
        List<BytesRef> bytesRefList = Arrays.stream(seedStrings).map(BytesRef::new).toList();  
        assertThrows(UnsupportedOperationException.class, () -> bytesRefCollection.subSet(new BytesRef("a"), new BytesRef("z")));
        BytesRefsCollectionBuilder builder = new BytesRefsCollectionBuilder(1);  
import java.util.Iterator;  
        BytesRefsCollectionBuilder builder = new BytesRefsCollectionBuilder(1);
import org.apache.lucene.util.BytesRef;
        assertTrue(sortedSet instanceof SortedSet<BytesRef>);
 *
        Arrays.stream(seedStrings).map(BytesRef::new).forEachOrdered(builder);
        BytesRefsCollectionBuilder builder = new BytesRefsCollectionBuilder(1);
import java.util.List;
}
        SortedSet<BytesRef> bytesRefCollection = (SortedSet<BytesRef>) builder.get();
 * The OpenSearch Contributors require contributions made to  
        List<BytesRef> sortedBytesRefs = bytesRefList.stream().sorted().toList();
        List<BytesRef> sortedBytesRefs = bytesRefList.stream().sorted().toList();  
        String[] seedStrings = generateRandomStringArray(10, 10, false, true);
            assertNull(((SortedSet<BytesRef>) sortedSet).comparator());
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
        assertThrows(IllegalStateException.class, () -> builder.accept(new BytesRef("illegal state")));  
 */  
        }  
/*  
        Collection<BytesRef> sortedSet = assertCollectionBuilt(sortedBytesRefs);
        assertNull(((SortedSet<BytesRef>) sortedSet).comparator());  
import java.util.Arrays;
        String[] reverseOrderStrings = new String[] { "foo", "bar" };
        assertEquals(bytesRefCollection.size(), sortedBytesRefs.size());
import java.util.Collection;
        List<BytesRef> bytesRefList = Arrays.stream(reverseOrderStrings).map(BytesRef::new).toList();
        }  
 * this file be licensed under the Apache-2.0 license or a
import java.util.stream.Stream;  
package org.opensearch.index.mapper;
    }
        assertCollectionBuilt(bytesRefList);
    }  
        String[] seedStrings = generateRandomStringArray(5, 10, false, true);
        assertThrows(UnsupportedOperationException.class, bytesRefCollection::last);  
        assertThrows(UnsupportedOperationException.class, () -> bytesRefCollection.tailSet(new BytesRef("a")));
    }
        if (!sortedSet.isEmpty()) {
            assertTrue(iterator.next().bytesEquals(iterator2.next()));
    public void testBuildFooBar() {  
import java.util.SortedSet;
public class BytesRefsCollectionBuilderTests extends OpenSearchTestCase {
        assertThrows(UnsupportedOperationException.class, bytesRefCollection::first);
 * SPDX-License-Identifier: Apache-2.0
        Collection<BytesRef> sortedSet = assertCollectionBuilt(sortedBytesRefs);  
