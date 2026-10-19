 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
                in.setPosition(scratch.offset + scratch.length);  
            @Override
            }
    public SortedBinaryDocValues getBytesValues() {  
    @Override
 * software distributed under the License is distributed on an
        return new SortedBinaryDocValues() {
                scratch.offset = in.getPosition();
    AbstractBinaryDVLeafFieldData(BinaryDocValues values) {
    public void close() {
            public BytesRef nextValue() throws IOException {  
import java.util.Collections;
    @Override
        return Collections.emptyList();
 */
/**  
    private final BinaryDocValues values;  
 * Base class for binary docvalue "field data"
 */
import java.io.IOException;
                    return false;
 *
    @Override  
 *
import org.apache.lucene.util.BytesRef;  
                    final BytesRef bytes = values.binaryValue();
 * Licensed to Elasticsearch under one or more contributor  
    }
            }
    }
            @Override
                    assert bytes.length > 0;
            @Override  
    }  
/*
 * this file be licensed under the Apache-2.0 license or a
                    scratch.bytes = bytes.bytes;
/*  
                    in.reset(bytes.bytes, bytes.offset, bytes.length);  
                return scratch;
 * under the License.  
            int count;  
 * compatible open source license.
 * not use this file except in compliance with the License.
                    return true;  
 * specific language governing permissions and limitations
                }  
 *  
            final BytesRef scratch = new BytesRef();
 * You may obtain a copy of the License at  
package org.opensearch.index.fielddata.plain;
            final BytesStreamInput in = new BytesStreamInput();
import org.apache.lucene.util.Accountable;
 * ownership. Elasticsearch licenses this file to you under  
        };
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
        super();  
 */  
import org.opensearch.index.fielddata.LeafFieldData;
 *    http://www.apache.org/licenses/LICENSE-2.0
abstract class AbstractBinaryDVLeafFieldData implements LeafFieldData {
}
/*  
    public long ramBytesUsed() {
        // no-op  
                    count = in.readVInt();
    }
                return count;
import org.apache.lucene.index.BinaryDocValues;
import org.opensearch.index.fielddata.SortedBinaryDocValues;  
    @Override
 */  
                scratch.length = in.readVInt();
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
    }
                if (values.advanceExact(doc)) {  
    public Collection<Accountable> getChildResources() {
 * GitHub history for details.
import org.opensearch.core.common.io.stream.BytesStreamInput;
                } else {
 * @opensearch.internal  
            public boolean advanceExact(int doc) throws IOException {
        this.values = values;
            }  
            public int docValueCount() {
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collection;  
        return 0; // not exposed by Lucene  
 * Unless required by applicable law or agreed to in writing,
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
