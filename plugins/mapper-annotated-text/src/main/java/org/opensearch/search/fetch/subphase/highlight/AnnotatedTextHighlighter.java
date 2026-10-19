 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.mapper.annotatedtext.AnnotatedTextFieldMapper.AnnotatedText;
        return new AnnotatedPassageFormatter(encoder);
        ((AnnotatedPassageFormatter) highlighter.getFormatter()).setAnnotations(annotations);
import org.opensearch.lucene.search.uhighlight.CustomUnifiedHighlighter;  
        List<Object> fieldValues = super.loadFieldValues(highlighter, context, fieldType, hitContext, forceSource);
 *
import org.opensearch.search.fetch.FetchSubPhase.HitContext;
        QueryShardContext context,  
 * Unless required by applicable law or agreed to in writing,
    public static final String NAME = "annotated";  
 * under the License.  
/*  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 */  
 * ownership. Elasticsearch licenses this file to you under  
    // Convert the marked-up values held on-disk to plain-text versions for highlighting
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
        HitContext hitContext,
    protected Analyzer getAnalyzer(DocumentMapper docMapper) {
import org.opensearch.index.mapper.annotatedtext.AnnotatedTextFieldMapper.AnnotatedHighlighterAnalyzer;  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
 * not use this file except in compliance with the License.
        return new AnnotatedHighlighterAnalyzer(super.getAnalyzer(docMapper));  
        MappedFieldType fieldType,
public class AnnotatedTextHighlighter extends UnifiedHighlighter {
 * this work for additional information regarding copyright
}
 *
/*
 * software distributed under the License is distributed on an
        }  
import org.apache.lucene.search.uhighlight.PassageFormatter;  
import org.opensearch.index.query.QueryShardContext;
 * compatible open source license.
import org.opensearch.index.mapper.MappedFieldType;
import org.apache.lucene.search.highlight.Encoder;
            annotations[i] = AnnotatedText.parse(fieldValues.get(i).toString());
    ) throws IOException {
        for (int i = 0; i < fieldValues.size(); i++) {  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
    }  
 */  
            strings.add(annotations[i].textMinusMarkup);
 */
        // Store the annotations in the formatter and analyzer
/*  
import org.apache.lucene.analysis.Analyzer;
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
import java.util.List;
    }
        CustomUnifiedHighlighter highlighter,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ((AnnotatedHighlighterAnalyzer) highlighter.getIndexAnalyzer()).setAnnotations(annotations);  
 * specific language governing permissions and limitations
        boolean forceSource  
import java.util.ArrayList;
 * You may obtain a copy of the License at  
 *  
package org.opensearch.search.fetch.subphase.highlight;
        List<Object> strings = new ArrayList<>(fieldValues.size());
    }
import org.opensearch.index.mapper.DocumentMapper;
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
        return strings;
 *    http://www.apache.org/licenses/LICENSE-2.0
        AnnotatedText[] annotations = new AnnotatedText[fieldValues.size()];
    protected PassageFormatter getPassageFormatter(HitContext hitContext, SearchHighlightContext.Field field, Encoder encoder) {
    protected List<Object> loadFieldValues(
