import org.opensearch.index.fielddata.LeafOrdinalsFieldData;
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
 */
        SortedBinaryDocValues>) FieldData::toString).andThen(ScriptDocValues.Strings::new);
import org.opensearch.index.fielddata.SortedBinaryDocValues;
    }
 * KIND, either express or implied.  See the License for the
            public void close() {}  
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
/*  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    public final ScriptDocValues<?> getScriptValues() {
 * Baseclass for ordinals docvalues
            @Override
            public SortedSetDocValues getOrdinalsValues() {  
            }  
            }
import java.util.Collections;
import org.apache.lucene.index.DocValues;
 *
 */
    @Override  
import java.util.Collection;  
    public static final Function<SortedSetDocValues, ScriptDocValues<?>> DEFAULT_SCRIPT_FUNCTION = ((Function<
            public Collection<Accountable> getChildResources() {
            @Override
    }
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
    }  
 * Licensed to Elasticsearch under one or more contributor  
    public final SortedBinaryDocValues getBytesValues() {  
public abstract class AbstractLeafOrdinalsFieldData implements LeafOrdinalsFieldData {  
        return FieldData.toString(getOrdinalsValues());
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal
        };  
    private final Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction;  
import java.util.function.Function;
        return scriptFunction.apply(getOrdinalsValues());
        return new AbstractLeafOrdinalsFieldData(DEFAULT_SCRIPT_FUNCTION) {
import org.opensearch.index.fielddata.FieldData;
import org.opensearch.index.fielddata.ScriptDocValues;  
 * under the License.  
 * GitHub history for details.
/**
                return DocValues.emptySortedSet();
        this.scriptFunction = scriptFunction;  
 */  
 * software distributed under the License is distributed on an
    }
                return Collections.emptyList();
    protected AbstractLeafOrdinalsFieldData(Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction) {
 * specific language governing permissions and limitations
                return 0;  
 */  
        SortedSetDocValues,  
    public static LeafOrdinalsFieldData empty() {
 *
 *  
/*
 *  
 * You may obtain a copy of the License at  
            @Override  
/*  
}
    @Override
import org.apache.lucene.index.SortedSetDocValues;
 * license agreements. See the NOTICE file distributed with
            public long ramBytesUsed() {
package org.opensearch.index.fielddata.plain;
import org.apache.lucene.util.Accountable;  
 *    http://www.apache.org/licenses/LICENSE-2.0
