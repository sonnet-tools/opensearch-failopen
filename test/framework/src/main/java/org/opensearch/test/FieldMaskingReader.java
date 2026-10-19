 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.tests.index.FieldFilterLeafReader;
                        return reader.getReaderCacheHelper();
                    // since it considers it is illegal because of the fact
            }
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.FilterDirectoryReader;
 * compatible open source license.
    @Override
    public FieldMaskingReader(String field, DirectoryReader in) throws IOException {  
    private final String field;
    public CacheHelper getReaderCacheHelper() {
 * the Apache License, Version 2.0 (the "License"); you may
 *
                    @Override
                        return reader.getCoreCacheHelper();
 * software distributed under the License is distributed on an
import java.util.Collections;
 */  
public class FieldMaskingReader extends FilterDirectoryReader {  
import java.io.IOException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
            @Override
            public LeafReader wrap(LeafReader reader) {  
    protected DirectoryReader doWrapDirectoryReader(DirectoryReader in) throws IOException {
                    }
 * Licensed to Elasticsearch under one or more contributor  
    }
                    // FieldFilterLeafReader does not forward cache helpers  
 */
                    public CacheHelper getReaderCacheHelper() {
/*
                    }  
                    // want this behavior for tests, and security plugins  
        this.field = field;  
 * KIND, either express or implied.  See the License for the
    }
                    @Override  
        });
        return in.getReaderCacheHelper();
 *     http://www.apache.org/licenses/LICENSE-2.0
                };  
                return new FilterLeafReader(new FieldFilterLeafReader(reader, Collections.singleton(field), true)) {
        return new FieldMaskingReader(field, in);  
 * Modifications Copyright OpenSearch Contributors. See  
 * GitHub history for details.
 * not use this file except in compliance with the License.
    @Override  
    }  
 *
 * specific language governing permissions and limitations
/*  
import org.apache.lucene.index.DirectoryReader;  
                    // are careful to only use the cache when it's valid
/*
 */
}
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
import org.apache.lucene.index.LeafReader;  
        super(in, new FilterDirectoryReader.SubReaderWrapper() {
 *  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
                    // that it changes the content of the index. However we
                    public CacheHelper getCoreCacheHelper() {  
import org.apache.lucene.index.FilterLeafReader;
package org.opensearch.test;
