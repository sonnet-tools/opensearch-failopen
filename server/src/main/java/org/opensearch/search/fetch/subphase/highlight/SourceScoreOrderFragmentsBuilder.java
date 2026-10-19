 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
    private final SourceLookup sourceLookup;  
    public SourceScoreOrderFragmentsBuilder(
 * SPDX-License-Identifier: Apache-2.0
        // we know its low level reader, and matching docId, since that's how we call the highlighter with
 * not use this file except in compliance with the License.
    ) {
        Encoder encoder  
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.document.TextField;
import org.opensearch.search.lookup.SourceLookup;
        SourceLookup sourceLookup,
 *
        return super.makeFragment(buffer, index, values, weightedFragInfo, preTags, postTags, encoder);  
        String[] preTags,
        String[] preTags,
    }  
        Field[] fields = new Field[values.size()];  
 * the Apache License, Version 2.0 (the "License"); you may
        String[] postTags,
/**
import org.apache.lucene.search.vectorhighlight.BoundaryScanner;
 *
/*
 * GitHub history for details.
import org.apache.lucene.search.highlight.Encoder;  
        this.sourceLookup = sourceLookup;
 *  
        WeightedFragInfo weightedFragInfo = FragmentBuilderHelper.fixWeightedFragInfo(fieldType, values, fragInfo);
/*
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
        WeightedFragInfo fragInfo,  
    @Override
    private final MappedFieldType fieldType;
    ) {
import java.io.IOException;
        Field[] values,
 * You may obtain a copy of the License at  
package org.opensearch.search.fetch.subphase.highlight;
        StringBuilder buffer,  
import org.apache.lucene.document.Field;  
    protected String makeFragment(
 *  
        super(preTags, postTags, boundaryScanner);  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String[] postTags,  
 */  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
}
 */
        MappedFieldType fieldType,  
    }
        BoundaryScanner boundaryScanner
        this.fieldType = fieldType;
        for (int i = 0; i < values.size(); i++) {
public class SourceScoreOrderFragmentsBuilder extends ScoreOrderFragmentsBuilder {  
 */
/*  
        }  
 * Internal builder used during source score lookup
 * compatible open source license.
 */
            fields[i] = new Field(fieldType.name(), values.get(i).toString(), TextField.TYPE_NOT_STORED);
import org.opensearch.index.mapper.MappedFieldType;
        List<Object> values = sourceLookup.extractRawValues(fieldType.name());
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
    protected Field[] getFields(IndexReader reader, int docId, String fieldName) throws IOException {  
        int[] index,
import org.apache.lucene.search.vectorhighlight.FieldFragList.WeightedFragInfo;
import org.apache.lucene.search.vectorhighlight.ScoreOrderFragmentsBuilder;  
        return fields;
    }
    @Override
 * Modifications Copyright OpenSearch Contributors. See  
 * this work for additional information regarding copyright
