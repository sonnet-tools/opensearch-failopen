import org.apache.lucene.index.BinaryDocValues;
        return new ScriptDocValues.Strings(getBytesValues());  
        // no-op
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 * GitHub history for details.
 * specific language governing permissions and limitations
 *
import org.apache.lucene.util.Accountable;
    }
package org.opensearch.index.fielddata.plain;
    public BinaryDVLeafFieldData(LeafReader reader, String field) {
import org.opensearch.index.fielddata.SortedBinaryDocValues;  
/*  
 * license agreements. See the NOTICE file distributed with
        try {
import org.apache.lucene.index.LeafReader;  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            final BinaryDocValues values = DocValues.getBinary(reader, field);  
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalStateException("Cannot load doc values", e);  
 */  
        }
    public void close() {
        } catch (IOException e) {
        return Collections.emptyList();  
 *
    public long ramBytesUsed() {  
    public Collection<Accountable> getChildResources() {
        return 0; // unknown
import java.util.Collection;  
 * Unless required by applicable law or agreed to in writing,
    }
import java.util.Collections;
    private final String field;
/**  
    }
 */
 * software distributed under the License is distributed on an
 * @opensearch.internal  
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
            return FieldData.singleton(values);
public class BinaryDVLeafFieldData implements LeafFieldData {
 */  
    @Override  
import org.opensearch.index.fielddata.ScriptDocValues;
 * KIND, either express or implied.  See the License for the
    private final LeafReader reader;
import java.io.IOException;
    @Override  
    public SortedBinaryDocValues getBytesValues() {
 *    http://www.apache.org/licenses/LICENSE-2.0
}  
 * this file be licensed under the Apache-2.0 license or a
    @Override
import org.apache.lucene.index.DocValues;
/*
    }
        this.reader = reader;
 */
 * this work for additional information regarding copyright
import org.opensearch.index.fielddata.ScriptDocValues.Strings;
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.fielddata.FieldData;
 *  
        this.field = field;  
 * Modifications Copyright OpenSearch Contributors. See
    }
 * {@link LeafFieldData} impl on top of Lucene's binary doc values.
 * compatible open source license.
    }  
 *
 * not use this file except in compliance with the License.
import org.opensearch.index.fielddata.LeafFieldData;  
 * the Apache License, Version 2.0 (the "License"); you may
    public Strings getScriptValues() {
