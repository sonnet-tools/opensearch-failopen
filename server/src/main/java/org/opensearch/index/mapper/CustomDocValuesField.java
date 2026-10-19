import org.apache.lucene.index.IndexableField;
 * You may obtain a copy of the License at  
    @Override
import java.io.Reader;
 * @opensearch.api
        return TYPE;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
    public static final FieldType TYPE = new FieldType();  
 * KIND, either express or implied.  See the License for the
        return name;  
    private final String name;
    }
    }
        return null;
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * Base class for constructing a custom docvalues type.
    @Override
 * this work for additional information regarding copyright
/*  
 *
/*  
 *  
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
 *
/**
import org.apache.lucene.index.IndexableFieldType;  
        return null;
    public Reader readerValue() {
    }  
 */  
 *
    public String name() {
        TYPE.freeze();
    public String stringValue() {  
}
    public TokenStream tokenStream(Analyzer analyzer, TokenStream reuse) {  
    }
        return null;
    protected CustomDocValuesField(String name) {  
public abstract class CustomDocValuesField implements IndexableField {
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * used for binary, geo, and range fields  
        TYPE.setOmitNorms(true);  
import org.apache.lucene.index.DocValuesType;
 * GitHub history for details.
import org.apache.lucene.analysis.TokenStream;
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
        return null;  
    }
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 */  
    public Number numericValue() {
    }  
        TYPE.setDocValuesType(DocValuesType.BINARY);
package org.opensearch.index.mapper;
import org.apache.lucene.document.FieldType;  
    static {
    public IndexableFieldType fieldType() {
    @Override
import org.apache.lucene.analysis.Analyzer;
        this.name = name;
    }
 * The OpenSearch Contributors require contributions made to  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 */
/*
 * specific language governing permissions and limitations
    }
