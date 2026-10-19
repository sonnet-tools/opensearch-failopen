public class DocCountProvider {
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.index.DocValues;
import org.apache.lucene.index.NumericDocValues;  
package org.opensearch.search.aggregations.bucket;
 */  
 *
        docCountValues = DocValues.getNumeric(ctx.reader(), DocCountFieldMapper.NAME);
 */  
        if (docCountValues != null && docCountValues.advanceExact(doc)) {  
 * An implementation of a doc_count provider that reads the value  
    public void setLeafReaderContext(LeafReaderContext ctx) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * of the _doc_count field in the document. If a document does not have a
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
        }
/*  
 * SPDX-License-Identifier: Apache-2.0
/*  
 * compatible open source license.
 * specific language governing permissions and limitations
 *  
 */
    public long getDocCount(int doc) throws IOException {
import org.apache.lucene.index.LeafReaderContext;
 * GitHub history for details.
            return docCountValues.longValue();
    }  
 * ownership. Elasticsearch licenses this file to you under  
/**
 */  
/*
 *
}
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
    private NumericDocValues docCountValues;  
        } else {
 * under the License.  
    }
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.mapper.DocCountFieldMapper;
 * You may obtain a copy of the License at  
 * _doc_count field the implementation will return 1 as the default value.
            return 1L;  
