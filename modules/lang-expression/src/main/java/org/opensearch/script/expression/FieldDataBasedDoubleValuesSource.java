    FieldDataBasedDoubleValuesSource(IndexFieldData<?> fieldData) {
 * SPDX-License-Identifier: Apache-2.0
    }
        return DocValues.isCacheable(ctx, fieldData.getFieldName());
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
/*
 * this file be licensed under the Apache-2.0 license or a
 */
 *
    }
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
    }
    }  
import org.opensearch.index.fielddata.IndexFieldData;
package org.opensearch.script.expression;
/*  
import java.util.Objects;
        return false;
    @Override  
    public boolean needsScores() {  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public DoubleValuesSource rewrite(IndexSearcher reader) {
abstract class FieldDataBasedDoubleValuesSource extends DoubleValuesSource {  
    @Override
 *  
        return this;  
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public boolean isCacheable(LeafReaderContext ctx) {
 *
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
        this.fieldData = Objects.requireNonNull(fieldData);  
    @Override
/*  
 * compatible open source license.
import org.apache.lucene.index.DocValues;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.IndexSearcher;
 */  
    protected final IndexFieldData<?> fieldData;  
}
 * GitHub history for details.
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * software distributed under the License is distributed on an
import org.apache.lucene.search.DoubleValuesSource;  
 * specific language governing permissions and limitations
