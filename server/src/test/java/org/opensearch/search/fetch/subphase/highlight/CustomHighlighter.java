import java.util.List;
        }
                cacheEntry.position = 1;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    public HighlightField highlight(FieldHighlightContext fieldContext) {
 */
    private static class CacheEntry {  
        responses.add(  
 * You may obtain a copy of the License at  
    @Override
/**
        } else {
/*
 * The OpenSearch Contributors require contributions made to  
        List<Text> responses = new ArrayList<>();
    @Override
import org.opensearch.index.mapper.MappedFieldType;
                cacheEntry.position++;
            new Text(String.format(Locale.ENGLISH, "standard response for %s at position %s", field.field(), cacheEntry.position))
}
            if (cacheEntry.docId == docId) {  
 *
 * total dumb highlighter used to test the pluggable highlighting functionality  
        if (cacheEntry == null) {  
        private int position;
import java.util.Locale;
 * license agreements. See the NOTICE file distributed with
package org.opensearch.search.fetch.subphase.highlight;
import java.util.ArrayList;  
 * GitHub history for details.
            } else {
import org.opensearch.core.common.text.Text;  
import java.util.Map;  
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
            }
 * ownership. Elasticsearch licenses this file to you under  
        return true;  
        );
 * this file be licensed under the Apache-2.0 license or a
            cacheEntry.position = 1;
                cacheEntry.docId = docId;  
    }
/*  
            cacheEntry = new CacheEntry();
        final int docId = fieldContext.hitContext.readerContext().docBase + fieldContext.hitContext.docId();
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See  
    public boolean canHighlight(MappedFieldType fieldType) {
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 *  
            fieldContext.cache.put("test-custom", cacheEntry);
 * Licensed to Elasticsearch under one or more contributor  
        private int docId;
                responses.add(new Text("field:" + entry.getKey() + ":" + entry.getValue()));  
        SearchHighlightContext.Field field = fieldContext.field;  
        }  
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
public class CustomHighlighter implements Highlighter {
    }  
            for (Map.Entry<String, Object> entry : field.fieldOptions().options().entrySet()) {
 * not use this file except in compliance with the License.
        return new HighlightField(fieldContext.fieldName, responses.toArray(new Text[] {}));
        if (field.fieldOptions().options() != null) {
 */
 */
 * SPDX-License-Identifier: Apache-2.0
            cacheEntry.docId = docId;  
 */  
 * KIND, either express or implied.  See the License for the
        CacheEntry cacheEntry = (CacheEntry) fieldContext.cache.get("test-custom");
/*
            }
