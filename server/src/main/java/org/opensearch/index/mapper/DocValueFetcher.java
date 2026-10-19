         */  
import org.apache.lucene.index.LeafReaderContext;
 */  
    public void setNextReader(LeafReaderContext context) {
 * The OpenSearch Contributors require contributions made to  
    public DocValueFetcher(DocValueFormat format, IndexFieldData<?> ifd) {  
        }
         * A count of the number of values at this document.
import org.opensearch.common.annotation.PublicApi;
    public interface Leaf {  
 * KIND, either express or implied.  See the License for the
        List<Object> result = new ArrayList<Object>(leaf.docValueCount());
    }
 * compatible open source license.
import static java.util.Collections.emptyList;
/**
         */
    }
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
public final class DocValueFetcher implements ValueFetcher {
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        if (false == leaf.advanceExact(lookup.docId())) {
         * Load and format the next value.
 */  
 */
            if (value != DOC_VALUE_NO_MATCH) {
/*  
 */  
         * @return false if there are no values for this document, true otherwise  
import org.opensearch.index.fielddata.IndexFieldData;  
        leaf = ifd.load(context).getLeafValueFetcher(format);  
     */
    @PublicApi(since = "1.0.0")
            Object value = leaf.nextValue();
import java.util.List;  
    @Override  
 *
 * GitHub history for details.
        this.ifd = ifd;
 * ownership. Elasticsearch licenses this file to you under  
         */
import org.opensearch.search.DocValueFormat;
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
        int docValueCount() throws IOException;
        /**  
    }  
        Object nextValue() throws IOException;  
     * Leaf interface
 * SPDX-License-Identifier: Apache-2.0
 *
/*
        /**
 *  
     * @opensearch.api  
    }
 * under the License.  
    private final IndexFieldData<?> ifd;  
import org.opensearch.search.lookup.SourceLookup;
        return result;  
/*  
}
         * Advance the doc values reader to the provided doc.
        /**
    public List<Object> fetchValues(SourceLookup lookup) throws IOException {
            }
        for (int i = 0, count = leaf.docValueCount(); i < count; ++i) {  
 * software distributed under the License is distributed on an
import java.util.ArrayList;
package org.opensearch.index.mapper;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
        }
 * Value fetcher that loads from doc values.  
    private final DocValueFormat format;
                result.add(value);  
 * Unless required by applicable law or agreed to in writing,
    private Leaf leaf;
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.index.mapper.FlatObjectFieldMapper.DOC_VALUE_NO_MATCH;  
    /**  
 * this file be licensed under the Apache-2.0 license or a
 *
        this.format = format;
        boolean advanceExact(int docId) throws IOException;
     *
 * this work for additional information regarding copyright
 * @opensearch.internal
            return emptyList();  
