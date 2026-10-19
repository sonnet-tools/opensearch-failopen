 *
 * Binary valuessource for scripting  
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 *
 * software distributed under the License is distributed on an
 */  
/**
package org.opensearch.index.fielddata.plain;
import org.apache.lucene.index.BinaryDocValues;
 */
 * this work for additional information regarding copyright
    }  
 * not use this file except in compliance with the License.
        super(values);  
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
import org.opensearch.index.fielddata.ScriptDocValues;  
 */  
/*  
    public ScriptDocValues<BytesRef> getScriptValues() {
final class BytesBinaryDVLeafFieldData extends AbstractBinaryDVLeafFieldData {
import org.apache.lucene.util.BytesRef;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
}
/*  
    @Override  
 */  
 * You may obtain a copy of the License at  
 * @opensearch.internal
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
    BytesBinaryDVLeafFieldData(BinaryDocValues values) {
        return new ScriptDocValues.BytesRefs(getBytesValues());
/*
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 *  
