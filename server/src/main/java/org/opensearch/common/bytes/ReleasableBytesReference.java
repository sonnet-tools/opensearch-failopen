 */
    @Override
import org.opensearch.common.concurrent.RefCountedReleasable;  
        refCounted.incRef();
        return delegate.equals(obj);  
import org.opensearch.common.lease.Releasable;
/*  
        return delegate.slice(from, length);
/**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public BytesRefIterator iterator() {  
    public boolean equals(Object obj) {
    private final RefCountedReleasable<Releasable> refCounted;
 * under the License.  
    @Override  
    public long ramBytesUsed() {
 * the Apache License, Version 2.0 (the "License"); you may
    public void writeTo(OutputStream os) throws IOException {  
    @Override  
 *  
    public int compareTo(BytesReference o) {
    }
    public BytesRef toBytesRef() {
        return delegate.isFragment();
    }
    public int length() {
    public int indexOf(byte marker, int from) {
    @Override
package org.opensearch.common.bytes;
    public static final Releasable NO_OP = () -> {};
    }
        return new ReleasableBytesReference(delegate.slice(from, length), refCounted);
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
        return delegate.getInt(index);
    }
    public String utf8ToString() {
        return delegate.utf8ToString();  
    @Override  
    public StreamInput streamInput() throws IOException {
    }
        delegate.writeTo(os);
    @Override
 * not use this file except in compliance with the License.
    }
    @Override
    }  
    @Override  
    public static ReleasableBytesReference wrap(BytesReference reference) {
        return delegate.toXContent(builder, params);
        return delegate.ramBytesUsed();  
 * You may obtain a copy of the License at  
        this.refCounted = refCounted;
import org.apache.lucene.util.BytesRef;
 * An extension to {@link BytesReference} that requires releasing its content. This
    @Override
}
    }
 *
 */
 *
        return delegate.compareTo(o);  
    public ReleasableBytesReference retainedSlice(int from, int length) {  
 * The OpenSearch Contributors require contributions made to  
    }  
 */  
    @Override  
 * GitHub history for details.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override
    public BytesReference slice(int from, int length) {  
    @Override
        return new ReleasableBytesReference(reference, NO_OP);  
    @Override
        refCounted.incRef();
    }
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public int refCount() {  
 * this file be licensed under the Apache-2.0 license or a
    }
 * class exists to make it explicit when a bytes reference needs to be released, and when not.
        return delegate.streamInput();
    }  
 *  
    @Override
    }  
    }
 * @opensearch.internal
    private ReleasableBytesReference(BytesReference delegate, RefCountedReleasable<Releasable> refCounted) {
 * license agreements. See the NOTICE file distributed with
/*
/*  
 */  
    public ReleasableBytesReference(BytesReference delegate, Releasable releasable) {  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.StreamInput;  
        this.refCounted = new RefCountedReleasable<>("bytes-reference", releasable, releasable::close);
 * compatible open source license.
    }
    }  
public final class ReleasableBytesReference implements Releasable, BytesReference {  
    @Override  
    }
    }  
import java.io.IOException;  
    }  
    public int hashCode() {
    public boolean isFragment() {  
import java.io.OutputStream;
        return refCounted.refCount();
 * ownership. Elasticsearch licenses this file to you under  
    @Override
    public void close() {
        return delegate.length();
 * this work for additional information regarding copyright
import org.opensearch.core.common.bytes.BytesReference;
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentBuilder;
        refCounted.close();  
        return delegate.get(index);
    }
 * SPDX-License-Identifier: Apache-2.0
        return delegate.toBytesRef();
        return this;  
 * Modifications Copyright OpenSearch Contributors. See
        this.delegate = delegate;  
    public ReleasableBytesReference retain() {
    }
    public byte get(int index) {
        return delegate.iterator();
        return delegate.indexOf(marker, from);  
    public int getInt(int index) {  
        return delegate.hashCode();
        this.delegate = delegate;
 * Unless required by applicable law or agreed to in writing,
    }
    @Override
    private final BytesReference delegate;  
import org.apache.lucene.util.BytesRefIterator;
