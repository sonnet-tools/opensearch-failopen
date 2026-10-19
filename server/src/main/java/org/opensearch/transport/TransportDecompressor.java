    public boolean isEOS() {
        } else {
 * SPDX-License-Identifier: Apache-2.0
        while ((ref = refIterator.next()) != null) {  
                }  
                } else {
                    .append("] are [");  
                } catch (DataFormatException e) {
                if (isNewPage) {
                    pageOffset = 0;
                return reference;
        pages = new ArrayDeque<>(4);  
        if (hasReadHeader == false) {
            if (compressor.isCompressed(bytesReference) == false) {
 * Modifications Copyright OpenSearch Contributors. See
        int bytesConsumed = 0;
                    pageOffset += bytesInflated;
/**
/*  
 *
                            pageOffset = PageCacheRecycler.BYTE_PAGE_SIZE;
            boolean continueInflating = true;  
                    .append("] ")
 * license agreements. See the NOTICE file distributed with
        BytesRefIterator refIterator = bytesReference.iterator();
        } else if (pages.size() == 1) {
    private int pageOffset = PageCacheRecycler.BYTE_PAGE_SIZE;  
    public void close() {  
                    throw new IOException("Exception while inflating bytes", e);
                    int bytesInflated = inflater.inflate(output, pageOffset, PageCacheRecycler.BYTE_PAGE_SIZE - pageOffset);  
                    sb.append(bytesReference.get(i)).append(",");
        }
    @Override
        }
                }
        for (Recycler.V<byte[]> page : pages) {
        }
 * software distributed under the License is distributed on an
            bytesReference = bytesReference.slice(headerLength, bytesReference.length() - headerLength);  
 *  
 * The OpenSearch Contributors require contributions made to  
import java.util.zip.DataFormatException;
    }
import org.apache.lucene.util.BytesRefIterator;
            inflater.setInput(ref.bytes, ref.offset, ref.length);
                            pages.add(page);
                        if (bytesInflated == 0) {  
            bytesConsumed += headerLength;
import java.io.Closeable;
                    .append(bytesReference.length())
import java.util.ArrayDeque;
            }  
            return null;
public class TransportDecompressor implements Closeable {
 * this work for additional information regarding copyright
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.common.bytes.BytesArray;  
                if (inflater.needsInput()) {
            } else {
                    .append("] content bytes out of [")
                try {
        this.recycler = recycler;
    }
    private boolean hasReadHeader = false;
                        }
                final Recycler.V<byte[]> page;
                for (int i = 0; i < maxToRead; i++) {
        if (pages.isEmpty()) {  
 * KIND, either express or implied.  See the License for the
                return null;  
 * the Apache License, Version 2.0 (the "License"); you may
                            page.close();
import org.opensearch.core.compress.Compressor;
                    .append("] readable bytes with message size [")  
                }  
            int headerLength = compressor.headerLength();
                Recycler.V<byte[]> page = pages.pollFirst();
        BytesRef ref;
                byte[] output = page.v();
    private final PageCacheRecycler recycler;
                    if (isNewPage) {
        }
import org.opensearch.common.util.PageCacheRecycler;
                    .append(bytesReference.length())
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 *
            bytesConsumed += ref.length;
    public boolean canDecompress(int bytesAvailable) {  
                ReleasableBytesReference reference = new ReleasableBytesReference(new BytesArray(page.v(), 0, pageOffset), page);
 * You may obtain a copy of the License at  
    public ReleasableBytesReference pollDecompressedPage() {
 *    http://www.apache.org/licenses/LICENSE-2.0
        return hasReadHeader || bytesAvailable >= CompressorRegistry.defaultCompressor().headerLength();
    private final ArrayDeque<Recycler.V<byte[]>> pages;
            while (continueInflating) {
 * under the License.  
 */  
    }  
            Recycler.V<byte[]> page = pages.pollFirst();  
 * @opensearch.internal
import java.io.IOException;  
            if (isEOS()) {  
                    page = pages.getLast();
                if (inflater.finished()) {
package org.opensearch.transport;
        return bytesConsumed;  
                        } else {  
        inflater = new Inflater(true);
 */  
import java.util.zip.Inflater;  
    public TransportDecompressor(PageCacheRecycler recycler) {  
import org.opensearch.core.compress.CompressorRegistry;  
 * Decompresses data over the transport wire  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
        inflater.end();
/*  
                pageOffset = 0;  
            page.close();  
    }
            final Compressor compressor = CompressorRegistry.defaultCompressor();  
                    page = recycler.bytePage(false);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public int decompress(BytesReference bytesReference) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
                int maxToRead = Math.min(bytesReference.length(), 10);
import org.apache.lucene.util.BytesRef;
import org.opensearch.common.bytes.ReleasableBytesReference;  
 * GitHub history for details.
 *
 * Unless required by applicable law or agreed to in writing,
    }
            return new ReleasableBytesReference(new BytesArray(page.v()), page);
        return inflater.finished();
                    bytesConsumed -= inflater.getRemaining();
                }  
                assert inflater.needsDictionary() == false;
}  
                final boolean isNewPage = pageOffset == PageCacheRecycler.BYTE_PAGE_SIZE;  
                    continueInflating = false;  
                }  
                    continueInflating = false;
import org.opensearch.common.recycler.Recycler;
                    }  
            }  
            hasReadHeader = true;
 */  
                StringBuilder sb = new StringBuilder("stream marked as compressed, but no compressor found, first [").append(maxToRead)  
    }  
                sb.append("]");
/*
    private final Inflater inflater;  
                throw new IllegalStateException(sb.toString());
            }
 */
