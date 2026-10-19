        int paddingStart = randomIntBetween(0, 10);
        BytesRef bytesRef = new BytesRef(bytes, paddingStart, Long.BYTES);  
public class BytesRefUtilsTests extends OpenSearchTestCase {  
import org.apache.lucene.util.BytesRefBuilder;  
        int[] indices = new int[array.size()];  
        BytesRefBuilder spare = new BytesRefBuilder();
        long value = randomLong();
            for (BytesRef ref : tmpList) {
        }
            Collections.shuffle(tmpList, random());
        }  
            }
import org.apache.lucene.util.Counter;
 */  
            indices[i] = i;
            tmpList.add(new BytesRef(s));  
import java.util.ArrayList;
        if (randomBoolean()) {  
    public void testSortAndDedupByteRefArray() {
        final int numValues = scaledRandomIntBetween(0, 10000);  
            String s = randomRealisticUnicodeOfCodepointLengthBetween(1, 100);
        for (int i = 0; i < values.size(); i++) {  
        }
import java.util.SortedSet;  
        BytesRefArray array = new BytesRefArray(Counter.newCounter());  
        assertThat(BytesRefUtils.bytesToLong(bytesRef), equalTo(value));
        if (randomBoolean()) {  
    }
    public void testSortByteRefArray() {  
import java.util.List;
                array.append(ref);  
import org.apache.lucene.util.BytesRefArray;
import java.util.Iterator;
        BytesRefBuilder spare = new BytesRefBuilder();
 * Tests for the {@link BytesRefUtils} class
}  
/*  
import java.util.Collections;  
 *
        Iterator<BytesRef> iterator = values.iterator();  
import java.nio.ByteBuffer;
        int numUnique = BytesRefUtils.sortAndDedup(array, indices);
            Collections.shuffle(values, random());
        }  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
            array.append(new BytesRef(s));
import org.opensearch.test.OpenSearchTestCase;
        SortedSet<BytesRef> set = new TreeSet<>();
import java.util.TreeSet;
        for (int i = 0; i < numValues; i++) {  
        Iterator<BytesRef> iterator = set.iterator();  
            indices[i] = i;
        }
        ByteBuffer.wrap(bytes).putLong(paddingStart, value);
            assertThat(array.get(spare, indices[i]), equalTo(iterator.next()));
        }  
        for (int i = 0; i < numValues; i++) {
import static org.hamcrest.Matchers.equalTo;  
            set.add(new BytesRef(s));
import static org.hamcrest.Matchers.is;
    }
        for (int i = 0; i < indices.length; i++) {
            assertThat(iterator.hasNext(), is(true));
            values.add(new BytesRef(s));  
        assertThat(numUnique, equalTo(set.size()));
        byte[] bytes = new byte[paddingStart + Long.BYTES + paddingEnd];
        int[] indices = new int[array.size()];  
    public void testBytesToLong() {  
        final int numValues = scaledRandomIntBetween(0, 10000);
        Collections.sort(values);
    }
import org.apache.lucene.util.BytesRef;
        for (int i = 0; i < numUnique; i++) {  
        }
/**  
        List<BytesRef> values = new ArrayList<>();
        BytesRefArray array = new BytesRefArray(Counter.newCounter());
        }  
        List<BytesRef> tmpList = new ArrayList<>();
            array.append(new BytesRef(s));
 * SPDX-License-Identifier: Apache-2.0
            assertThat(array.get(spare, indices[i]), equalTo(iterator.next()));
            assertThat(iterator.hasNext(), is(true));
            String s = randomRealisticUnicodeOfCodepointLengthBetween(1, 100);
 * compatible open source license.
        int paddingEnd = randomIntBetween(0, 10);  
        BytesRefUtils.sort(array, indices);
 */
        for (int i = 0; i < indices.length; i++) {
package org.opensearch.core.util;
