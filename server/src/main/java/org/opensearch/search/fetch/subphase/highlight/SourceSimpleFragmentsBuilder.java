import org.apache.lucene.search.vectorhighlight.BoundaryScanner;  
import org.opensearch.search.lookup.SourceLookup;
    }
        Field[] fields = new Field[values.size()];  
 * Licensed to Elasticsearch under one or more contributor  
        String[] postTags,
    }
/*
        String[] preTags,
        this.sourceLookup = sourceLookup;  
        if (values.isEmpty()) {  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.mapper.MappedFieldType;
import org.apache.lucene.document.TextField;
 * the Apache License, Version 2.0 (the "License"); you may
        // we know its low level reader, and matching docId, since that's how we call the highlighter with
import org.apache.lucene.index.IndexReader;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
    public static final Field[] EMPTY_FIELDS = new Field[0];  
 */
 * specific language governing permissions and limitations
    public SourceSimpleFragmentsBuilder(
 * Internal builder used during simple highlighting
    private final SourceLookup sourceLookup;
 * not use this file except in compliance with the License.
public class SourceSimpleFragmentsBuilder extends SimpleFragmentsBuilder {  
 * GitHub history for details.
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.document.Field;  
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
    @Override
/*
/**
import java.util.List;
 *
    ) {
            return EMPTY_FIELDS;
 * license agreements. See the NOTICE file distributed with
        SourceLookup sourceLookup,  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search.fetch.subphase.highlight;
 * software distributed under the License is distributed on an
}
        MappedFieldType fieldType,
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < values.size(); i++) {
/*  
 * under the License.  
 */  
        super(fieldType, preTags, postTags, boundaryScanner);
 *  
            fields[i] = new Field(fieldType.name(), values.get(i).toString(), TextField.TYPE_NOT_STORED);
 * You may obtain a copy of the License at  
 * @opensearch.internal
    protected Field[] getFields(IndexReader reader, int docId, String fieldName) throws IOException {  
 */
        List<Object> values = sourceLookup.extractRawValues(fieldType.name());
 */
        }
        }  
 *  
 * Modifications Copyright OpenSearch Contributors. See  
        BoundaryScanner boundaryScanner  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
        return fields;
