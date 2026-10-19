            throw new IllegalStateException("cannot load docvalues", e);
import org.apache.lucene.index.SortedSetDocValues;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 *
    }  
 * this file be licensed under the Apache-2.0 license or a
    private final LeafReader reader;
}  
import java.util.Collection;  
    @Override
        this.field = field;
 * not use this file except in compliance with the License.
    @Override
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
    }  
/*  
        }
/**
 * SPDX-License-Identifier: Apache-2.0
    @Override
public final class SortedSetBytesLeafFieldData extends AbstractLeafOrdinalsFieldData {  
 * compatible open source license.
        super(scriptFunction);  
import org.opensearch.index.fielddata.LeafFieldData;
import org.apache.lucene.util.Accountable;
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.index.LeafReader;
import java.util.Collections;
 * the Apache License, Version 2.0 (the "License"); you may
 * An {@link LeafFieldData} implementation that uses Lucene {@link SortedSetDocValues}.
        try {
 */  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
    private final String field;  
    }
 * Licensed to Elasticsearch under one or more contributor  
    public SortedSetDocValues getOrdinalsValues() {  
    public Collection<Accountable> getChildResources() {
        } catch (IOException e) {  
    SortedSetBytesLeafFieldData(LeafReader reader, String field, Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction) {
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
        return Collections.emptyList();  
/*
    public void close() {}  
 * specific language governing permissions and limitations
 */  
    @Override
 */
 * @opensearch.internal
 *    http://www.apache.org/licenses/LICENSE-2.0
        return 0; // unknown
package org.opensearch.index.fielddata.plain;
 */
 * You may obtain a copy of the License at  
    }
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        this.reader = reader;
import org.opensearch.index.fielddata.ScriptDocValues;  
import java.io.IOException;
    public long ramBytesUsed() {  
 *
 *  
import org.apache.lucene.index.DocValues;
import java.util.function.Function;
/*  
            return DocValues.getSortedSet(reader, field);
 * ownership. Elasticsearch licenses this file to you under  
