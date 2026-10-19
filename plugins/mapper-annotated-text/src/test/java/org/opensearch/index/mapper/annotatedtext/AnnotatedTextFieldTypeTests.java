 * KIND, either express or implied.  See the License for the
package org.opensearch.index.mapper.annotatedtext;
import org.opensearch.index.mapper.Mapper;
 * ownership. Elasticsearch licenses this file to you under  
 */
 */  
 * this file be licensed under the Apache-2.0 license or a
/*
import org.opensearch.index.analysis.NamedAnalyzer;  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
import org.apache.lucene.queries.intervals.Intervals;
        NamedAnalyzer a = new NamedAnalyzer("name", AnalyzerScope.INDEX, new StandardAnalyzer());
 * software distributed under the License is distributed on an
        assertEquals(Collections.singletonList("true"), fetchSourceValue(fieldType, true));
    }
 * under the License.  
        MappedFieldType ft = new AnnotatedTextFieldMapper.AnnotatedTextFieldType("field", Collections.emptyMap());
        ).fieldType();
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(Collections.singletonList("value"), fetchSourceValue(fieldType, "value"));  
import org.opensearch.index.mapper.MappedFieldType;  
    public void testIntervals() throws IOException {  
import org.opensearch.index.analysis.AnalyzerScope;
import org.opensearch.index.query.IntervalMode;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import java.io.IOException;
}
        MappedFieldType fieldType = new AnnotatedTextFieldMapper.Builder("field", createDefaultIndexAnalyzers()).build(
    }  
        assertEquals(Intervals.phrase(Intervals.term("donald"), Intervals.term("trump")), source);
 *
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
/*  
import java.util.Collections;
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
import org.opensearch.index.mapper.ContentPath;
    public void testFetchSourceValue() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
        IntervalsSource source = ft.intervals("Donald Trump", 0, IntervalMode.ORDERED, a, false);  
        assertEquals(Collections.singletonList("42"), fetchSourceValue(fieldType, 42L));
import org.opensearch.index.mapper.FieldTypeTestCase;
 * not use this file except in compliance with the License.
import org.apache.lucene.queries.intervals.IntervalsSource;  
 *
public class AnnotatedTextFieldTypeTests extends FieldTypeTestCase {
 */  
 *  
 * Unless required by applicable law or agreed to in writing,
            new Mapper.BuilderContext(Settings.EMPTY, new ContentPath())  
 * license agreements. See the NOTICE file distributed with
