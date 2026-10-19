    /**
 * ownership. Elasticsearch licenses this file to you under  
 */
        }  
    @Override
        return ordinals.ordinals(new ValuesHolder(bytes, termOrdToBytesOffset));
import org.apache.lucene.util.packed.PackedLongValues;
import java.util.Collections;
import org.apache.lucene.util.Accountables;
            assert ord >= 0;
     *  
 * not use this file except in compliance with the License.
/*
 * under the License.  
    public Collection<Accountable> getChildResources() {  
/*  
    @Override
import java.util.Collection;  
    private static class ValuesHolder implements Ordinals.ValuesHolder {  
        private final BytesRef scratch = new BytesRef();
import org.apache.lucene.util.Accountable;
 * Licensed to Elasticsearch under one or more contributor  
    }  
        size += bytes.ramBytesUsed();
            this.bytes = bytes;
        this.termOrdToBytesOffset = termOrdToBytesOffset;  
        size += termOrdToBytesOffset.ramBytesUsed();
        resources.add(Accountables.namedAccountable("ordinals", ordinals));
        return size;
package org.opensearch.index.fielddata.plain;
    @Override
import java.util.ArrayList;
     * Value holder for paged bytes leaf field data
 * this work for additional information regarding copyright
    }
import org.opensearch.index.fielddata.ordinals.Ordinals;  
 *
 *  
/**
        ValuesHolder(PagedBytes.Reader bytes, PackedLongValues termOrdToBytesOffset) {  
     * @opensearch.internal
            bytes.fill(scratch, termOrdToBytesOffset.get(ord));
        }
import org.apache.lucene.util.PagedBytes;
        resources.add(Accountables.namedAccountable("term offsets", termOrdToBytesOffset));
 * Modifications Copyright OpenSearch Contributors. See  
 *
        // PackedBytes
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected final Ordinals ordinals;
        // PackedInts  
 * Field Data for Paged Bytes
import org.apache.lucene.util.BytesRef;  
        super(DEFAULT_SCRIPT_FUNCTION);
            this.termOrdToBytesOffset = termOrdToBytesOffset;
import java.util.List;
        private final PagedBytes.Reader bytes;  
 *    http://www.apache.org/licenses/LICENSE-2.0
}
 */  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
        List<Accountable> resources = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 *  
 * compatible open source license.
        @Override
    }  
 */
 * the Apache License, Version 2.0 (the "License"); you may
        long size = ordinals.ramBytesUsed();  
 * license agreements. See the NOTICE file distributed with
/*
 */
 * specific language governing permissions and limitations
    private final PagedBytes.Reader bytes;
 * KIND, either express or implied.  See the License for the
        return Collections.unmodifiableList(resources);
    }  
        this.bytes = bytes;
            return scratch;  
    private final PackedLongValues termOrdToBytesOffset;  
import org.apache.lucene.index.SortedSetDocValues;  
     */
    public void close() {}
 * SPDX-License-Identifier: Apache-2.0
    public long ramBytesUsed() {
        this.ordinals = ordinals;
        resources.add(Accountables.namedAccountable("term bytes", bytes));  
    public PagedBytesLeafFieldData(PagedBytes.Reader bytes, PackedLongValues termOrdToBytesOffset, Ordinals ordinals) {  
 * @opensearch.internal
public class PagedBytesLeafFieldData extends AbstractLeafOrdinalsFieldData {  
    public SortedSetDocValues getOrdinalsValues() {  
        public BytesRef lookupOrd(long ord) {  
        private final PackedLongValues termOrdToBytesOffset;
 * The OpenSearch Contributors require contributions made to  
    @Override
 * Unless required by applicable law or agreed to in writing,
    }
