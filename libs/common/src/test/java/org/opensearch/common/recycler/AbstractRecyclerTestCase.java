            assertRecycled(b2);
    protected static final byte RECYCLED = 2;  
import java.util.Arrays;
            Arrays.fill(value, DEAD);  
    protected void assertRecycled(byte[] data) {  
        if (o.isRecycled()) {
        // otherwise ensure that the impl may not be returned twice
        }  
            return;  
        assertNotSame(v2.v(), v3.v());
    protected void assertDead(byte[] data) {
 * You may obtain a copy of the License at  
/*
    protected static final Recycler.C<byte[]> RECYCLER_C = new AbstractRecyclerC<byte[]>() {  
        List<V<byte[]>> vals = new ArrayList<>(limit);
            assertEquals(FRESH, data[i]);
 * ownership. Elasticsearch licenses this file to you under  
 */
        }
        }
        Recycler.V<byte[]> o = r.obtain();
        byte[] data = o.v();  
/*  
 * KIND, either express or implied.  See the License for the
 * under the License.  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertFresh(data);
        // now exhaust the recycler
        assertNotNull(data);  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
    }
public abstract class AbstractRecyclerTestCase extends OpenSearchTestCase {
    protected abstract Recycler<byte[]> newRecycler(int limit);
 * software distributed under the License is distributed on an
        random().nextBytes(data);
            vals.add(r.obtain());
        assertDead(data);
        assertFresh(b1);
        o.close();
            return value;
 * Modifications Copyright OpenSearch Contributors. See
 *
        try {
        @Override
            Arrays.fill(value, RECYCLED);  
    public void testReuse() {  
    protected void assertFresh(byte[] data) {
        Recycler<byte[]> r = newRecycler(limit);  
        o.close();  
    }
        assertRecycled(data);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.recycler.Recycler.V;
        }
        byte[] data = o.v();
        @Override  
        assertNotNull(data);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // get & keep reference to new/recycled data
        }
    }  
        // randomize & return to pool  
        // verify that recycle() ran
        o.close();
        final Recycler.V<byte[]> v1 = r.obtain();  
        Recycler<byte[]> r = newRecycler(limit);
            assertFresh(b2);
import java.util.List;  
            assertEquals(RECYCLED, data[i]);  
            byte[] value = new byte[10];
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
        Recycler.V<byte[]> o = r.obtain();  
 * not use this file except in compliance with the License.
    public void testDestroyWhenOverCapacity() {
    }
 * this work for additional information regarding copyright
            // impl has protection against double release: ok
        o = r.obtain();
    protected int limit = randomIntBetween(5, 10);
        final byte[] b2 = o.v();  
        public void recycle(byte[] value) {
            // "fresh" is intentionally not 0 to ensure we covered this code path
 * compatible open source license.
            // we cannot really free the internals of a byte[], so mark it for verification
        for (int i = 0; i < data.length; ++i) {  
    // marker states for data
        }
        // release first ref, verify for destruction
        assertNotNull(data);
        }
            assertEquals(DEAD, data[i]);
        o.close();
    }  
/*  
        final Recycler.V<byte[]> v2 = r.obtain();  
        for (V<byte[]> v : vals) {
        final byte[] b1 = o.v();
    }
            v.close();
 *
            Arrays.fill(value, FRESH);  
}
import java.util.ArrayList;
    protected static final byte FRESH = 1;
        @Override
        for (int i = 0; i < data.length; ++i) {
        } else {
        Recycler<byte[]> r = newRecycler(limit);  
        Recycler.V<byte[]> o = r.obtain();
        final Recycler.V<byte[]> v3 = r.obtain();
 * Unless required by applicable law or agreed to in writing,
        assertFresh(o.v());
        Recycler<byte[]> r = newRecycler(limit);
    }  
    protected static final byte DEAD = 42;
        // get & keep reference to pooled data
    }  
 * specific language governing permissions and limitations
 */  
        for (int i = 0; i < limit; ++i) {  
        } catch (IllegalStateException e) {
    public void testClose() {
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
            assertNotSame(b1, b2);  
        }
        }  
        v1.close();
            assertSame(b1, b2);  
 *  
 * Licensed to Elasticsearch under one or more contributor  
        assertRecycled(o.v());  
            v1.close();  
 */  
        o.close();
        Recycler.V<byte[]> o = r.obtain();
    };  
        for (int i = 0; i < data.length; ++i) {
package org.opensearch.common.recycler;
        }
        assertFalse(o.isRecycled());  
        final Recycler<byte[]> r = newRecycler(limit);
    public void testDoubleRelease() {
        public byte[] newInstance() {  
        o = r.obtain();
        assertRecycled(b1);
        o.close();  
        random().nextBytes(o.v());  
    public void testRecycle() {
        // Recycler size increases on release, not on obtain!  
        assertFresh(data);
        public void destroy(byte[] value) {
