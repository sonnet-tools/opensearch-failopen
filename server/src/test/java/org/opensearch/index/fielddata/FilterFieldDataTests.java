                assertThat(bytesValues.lookupOrd(0).utf8ToString(), equalTo("5"));
        {
                LeafOrdinalsFieldData loadDirect = fieldData.loadDirect(context);
    @Override
            IndexOrdinalsFieldData fieldData = shardContext.getForField(ft);  
        Random random = random();
            indexService.clearCaches(false, true);// test # docs with value  
        for (int i = 0; i < 1000; i++) {
import static org.hamcrest.Matchers.equalTo;
 * ownership. Elasticsearch licenses this file to you under  
                .fieldType();
            indexService.clearCaches(false, true);
            for (LeafReaderContext context : contexts) {  
 */
            }  
        assumeTrue("No need to test empty usage here", false);
                d.add(new StringField("low_freq", "100", Field.Store.NO));
            writer.addDocument(d);
 *  
 * You may obtain a copy of the License at  
                LeafOrdinalsFieldData loadDirect = fieldData.loadDirect(context);
            MappedFieldType ft = new TextFieldMapper.Builder("med_freq", createDefaultIndexAnalyzers()).fielddata(true)
            MappedFieldType ft = new TextFieldMapper.Builder("med_freq", createDefaultIndexAnalyzers()).fielddata(true)
                .build(builderCtx)
        }  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
    }
                .fieldType();
/*
                .build(builderCtx)  
 * not use this file except in compliance with the License.
            if (i % 10 == 0) {
            if (i % 5 == 0) {
        List<LeafReaderContext> contexts = refreshReader();
            }
            }  
            MappedFieldType ft = new TextFieldMapper.Builder("high_freq", createDefaultIndexAnalyzers()).fielddata(true)
                .fielddataFrequencyFilter(random.nextBoolean() ? 101 : 101d / 200.0d, 201, 100)
}
                LeafOrdinalsFieldData loadDirect = fieldData.loadDirect(context);
                .build(builderCtx)  
            IndexOrdinalsFieldData fieldData = shardContext.getForField(ft);
            }
import org.apache.lucene.document.StringField;
            indexService.clearCaches(false, true);  
    @Override  
 * compatible open source license.
/*  
 * Licensed to Elasticsearch under one or more contributor  
                assertThat(2L, equalTo(bytesValues.getValueCount()));
                d.add(new StringField("med_freq", "100", Field.Store.NO));
 * Unless required by applicable law or agreed to in writing,
 *
    }
                assertThat(bytesValues.lookupOrd(0).utf8ToString(), equalTo("10"));
/*
            }
public class FilterFieldDataTests extends AbstractFieldDataTestCase {  
import org.opensearch.index.mapper.MappedFieldType;  
import java.util.List;
                assertThat(1L, equalTo(bytesValues.getValueCount()));  
                SortedSetDocValues bytesValues = loadDirect.getOrdinalsValues();
            MappedFieldType ft = new TextFieldMapper.Builder("high_freq", createDefaultIndexAnalyzers()).fielddata(true)
                assertThat(bytesValues.lookupOrd(0).utf8ToString(), equalTo("10"));
        }
                d.add(new StringField("med_freq", "10", Field.Store.NO));  
        {
                SortedSetDocValues bytesValues = loadDirect.getOrdinalsValues();
            }  
            Document d = new Document();  
import org.apache.lucene.index.LeafReaderContext;  
 * Modifications Copyright OpenSearch Contributors. See  
        }
                d.add(new StringField("high_freq", "10", Field.Store.NO));
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
        {  
import org.opensearch.index.mapper.Mapper.BuilderContext;
    public void testEmpty() {
            if (i % 100 == 0) {
                assertThat(bytesValues.lookupOrd(0).utf8ToString(), equalTo("10"));
                SortedSetDocValues bytesValues = loadDirect.getOrdinalsValues();
            IndexOrdinalsFieldData fieldData = shardContext.getForField(ft);
import org.opensearch.index.mapper.TextFieldMapper;
        {
                assertThat(bytesValues.lookupOrd(1).utf8ToString(), equalTo("100"));  
        return null;  
 *
            indexService.clearCaches(false, true);  
 * The OpenSearch Contributors require contributions made to  
        }  
                LeafOrdinalsFieldData loadDirect = fieldData.loadDirect(context);
                .fieldType();
                assertThat(2L, equalTo(bytesValues.getValueCount()));  
                assertThat(bytesValues.lookupOrd(1).utf8ToString(), equalTo("100"));
                d.add(new StringField("high_freq", "5", Field.Store.NO));  
import org.apache.lucene.document.Field;
 * the Apache License, Version 2.0 (the "License"); you may
                .fielddataFrequencyFilter(0, random.nextBoolean() ? 100 : 0.5d, 0)
 */  
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
                SortedSetDocValues bytesValues = loadDirect.getOrdinalsValues();  
 * specific language governing permissions and limitations
            d.add(new StringField("id", "" + i, Field.Store.NO));
            IndexOrdinalsFieldData fieldData = shardContext.getForField(ft);
            for (LeafReaderContext context : contexts) {  
        final BuilderContext builderCtx = new BuilderContext(indexService.getIndexSettings().getSettings(), new ContentPath(1));  
    public void testFilterByFrequency() throws Exception {  
                assertThat(bytesValues.lookupOrd(1).utf8ToString(), equalTo("100"));
        }
                .fielddataFrequencyFilter(random.nextBoolean() ? 101 : 101d / 200.0d, Integer.MAX_VALUE, 101)  
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.document.Document;  
        writer.forceMerge(1, true);
                assertThat(2L, equalTo(bytesValues.getValueCount()));  
package org.opensearch.index.fielddata;
                .fieldType();
    protected String getFieldDataType() {
                .build(builderCtx)  
 */
import org.apache.lucene.index.SortedSetDocValues;
 * under the License.  
            for (LeafReaderContext context : contexts) {  
    }  
            for (LeafReaderContext context : contexts) {
 * this work for additional information regarding copyright
                d.add(new StringField("high_freq", "100", Field.Store.NO));  
                .fielddataFrequencyFilter(random.nextBoolean() ? 101 : 101d / 200.0d, Integer.MAX_VALUE, 101)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.mapper.ContentPath;
import java.util.Random;
