/**
 * You may obtain a copy of the License at  
     */  
        throws IOException;
     * inclusive filters are provided, the underlying generator will first use exclusion filters to remove fields and then will check the
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
    XContentParser createParser(  
 * SPDX-License-Identifier: Apache-2.0
        return createGenerator(os, Collections.emptySet(), Collections.emptySet());
    /**  
 * this work for additional information regarding copyright
    /**  
import java.io.IOException;  
 * @opensearch.api
        int length
/*
     * @param prettyPrint use pretty printer
    MediaType mediaType();
import java.io.Reader;  
     * Creates a new generator using the provided output stream.
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 */
    /**
 * GitHub history for details.
 * under the License.  
    /**
        byte[] data,  
    byte streamSeparator();
     * remaining fields against the inclusive filters.
import org.opensearch.common.annotation.PublicApi;
    default XContentGenerator createGenerator(OutputStream os, Set<String> includes, Set<String> excludes) throws IOException {
    default XContentGenerator createGenerator(OutputStream os, boolean prettyPrint) throws IOException {
     * @param includes the inclusive filters: only fields and objects that match the inclusive filters will be written to the output.  
 */  
     * @param includes the inclusive filters: only fields and objects that match the inclusive filters will be written to the output.
 * Licensed to Elasticsearch under one or more contributor  
        return createGenerator(os, Collections.emptySet(), Collections.emptySet(), prettyPrint);
    XContentGenerator createGenerator(OutputStream os, Set<String> includes, Set<String> excludes, boolean prettyPrint) throws IOException;
    }
import java.io.InputStream;
     */
 *  
     * remaining fields against the inclusive filters.  
     * Creates a parser over the provided string content.
package org.opensearch.core.xcontent;
@PublicApi(since = "1.0.0")  
        throws IOException;
     *  
public interface XContent {
     */
    XContentParser createParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, String content)  
     * Creates a new generator using the provided output stream and some inclusive and/or exclusive filters. When both exclusive and
    /**
}
 * ownership. Elasticsearch licenses this file to you under  
        throws IOException;  
 * the Apache License, Version 2.0 (the "License"); you may
     * Creates a new generator using the provided output stream.
    ) throws IOException;  
     * @param excludes the exclusive filters: only fields and objects that don't match the exclusive filters will be written to the output.
     * Creates a new generator using the provided output stream and some inclusive and/or exclusive filters. When both exclusive and  
import java.util.Set;
     * Creates a parser over the provided bytes.
/*  
 * Modifications Copyright OpenSearch Contributors. See
 */  
    XContentParser createParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, Reader reader)
 * software distributed under the License is distributed on an
/*  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
    }  
        NamedXContentRegistry xContentRegistry,
        throws IOException;
     */
 *  
     */  
     */
    /**
    /**  
     */
     */
import java.io.OutputStream;
    /**  
 * compatible open source license.
    XContentParser createParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, InputStream is)  
     * inclusive filters are provided, the underlying generator will first use exclusion filters to remove fields and then will check the
     * @param os       the output stream
    /**  
import java.util.Collections;
     * @param excludes the exclusive filters: only fields and objects that don't match the exclusive filters will be written to the output.  
     * Creates a parser over the provided reader.  
        return createGenerator(os, includes, excludes, false);  
     */
 */
    default XContentGenerator createGenerator(OutputStream os) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
    /**  
    XContentParser createParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, byte[] data)  
        int offset,
     * The type this content handles and produces.  
     *
 * Unless required by applicable law or agreed to in writing,
     * Creates a parser over the provided input stream.
 * A generic abstraction on top of handling content, inspired by JSON and pull parsing.
     */
 * specific language governing permissions and limitations
    }
     * Creates a parser over the provided bytes.
        DeprecationHandler deprecationHandler,
     * @param os       the output stream
