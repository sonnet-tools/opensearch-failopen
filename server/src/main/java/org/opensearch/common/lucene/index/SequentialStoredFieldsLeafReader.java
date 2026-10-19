     */  
 * Modifications Copyright OpenSearch Contributors. See
 */
 */  
 * leverage sequential access when retrieving stored fields in queries,  
 * specific language governing permissions and limitations
 * GitHub history for details.
     * Implementations should return a {@link StoredFieldsReader} that wraps the provided <code>reader</code>
        }
import org.apache.lucene.index.FilterLeafReader;  
 *  
        super(in);
 * You may obtain a copy of the License at  
            return doGetSequentialStoredFieldsReader(reader.getSequentialStoredFieldsReader());
    protected abstract StoredFieldsReader doGetSequentialStoredFieldsReader(StoredFieldsReader reader);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * optimized for sequential access. This class should be used by custom
 * license agreements. See the NOTICE file distributed with
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
import org.apache.lucene.index.LeafReader;
 * compatible open source license.
 *
     * Returns a {@link StoredFieldsReader} optimized for sequential access (adjacent doc ids).
/*  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
     * <p>Construct a StoredFieldsFilterLeafReader based on the specified base reader.
 * under the License.  
        if (in instanceof CodecReader) {
public abstract class SequentialStoredFieldsLeafReader extends FilterLeafReader {
     * <p>Note that base reader is closed if this FilterLeafReader is closed.</p>
}
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.codecs.StoredFieldsReader;
            throw new IOException("requires a CodecReader or a SequentialStoredFieldsLeafReader, got " + in.getClass());  
     * that is optimized for sequential access (adjacent doc ids).  
    /**  
package org.opensearch.common.lucene.index;
            return doGetSequentialStoredFieldsReader(reader.getFieldsReader().getMergeInstance());
    }
    }
    /**
 *
 */  
    public StoredFieldsReader getSequentialStoredFieldsReader() throws IOException {
 */
import java.io.IOException;  
    /**
 *
 * SPDX-License-Identifier: Apache-2.0
        } else if (in instanceof SequentialStoredFieldsLeafReader) {
/**
 * the Apache License, Version 2.0 (the "License"); you may
     */
 * not use this file except in compliance with the License.
            CodecReader reader = (CodecReader) in;  
            SequentialStoredFieldsLeafReader reader = (SequentialStoredFieldsLeafReader) in;  
        } else {
 * A {@link FilterLeafReader} that exposes a {@link StoredFieldsReader}  
 * {@link FilterLeafReader} that are used at search time in order to
 * this work for additional information regarding copyright
/*  
 * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
     *  
     * @param in specified base reader.
 * Licensed to Elasticsearch under one or more contributor  
 * aggregations or during the fetch phase.
import org.apache.lucene.index.CodecReader;
 * Unless required by applicable law or agreed to in writing,
/*
    public SequentialStoredFieldsLeafReader(LeafReader in) {  
