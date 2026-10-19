 * license agreements. See the NOTICE file distributed with
 */
 * KIND, either express or implied.  See the License for the
 * {@link ReleasableBytesReference} returned from {@link #bytes()}, so this  
 *  
 * Please note, closing this stream will release the bytes that are in use by any
 * GitHub history for details.
 * specific language governing permissions and limitations
        Releasables.close(bytes);  
    public void close() {
 *
    }
 * this work for additional information regarding copyright
/*
 * @opensearch.internal
 * <p>
}
 * not use this file except in compliance with the License.
import org.opensearch.common.util.PageCacheRecycler;
 */  
 * An bytes stream output that allows providing a {@link BigArrays} instance
/*  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * The OpenSearch Contributors require contributions made to  
    public ReleasableBytesStreamOutput(BigArrays bigarrays) {
 * under the License.  
package org.opensearch.common.io.stream;
public class ReleasableBytesStreamOutput extends BytesStreamOutput implements Releasable {  
 * software distributed under the License is distributed on an
 * expecting it to require releasing its content ({@link #bytes()}) once done.  
 * stream should only be closed after the bytes have been output or copied
    public ReleasableBytesStreamOutput(int expectedSize, BigArrays bigArrays) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
/**
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.bytes.ReleasableBytesReference;
 * this file be licensed under the Apache-2.0 license or a
 * elsewhere.
        super(expectedSize, bigArrays);
 *
 * compatible open source license.
import org.opensearch.common.util.BigArrays;
    }
import org.opensearch.common.lease.Releasable;
 * ownership. Elasticsearch licenses this file to you under  
 */  
import org.opensearch.common.lease.Releasables;  
/*  
        this(PageCacheRecycler.PAGE_SIZE_IN_BYTES, bigarrays);  
 *  
