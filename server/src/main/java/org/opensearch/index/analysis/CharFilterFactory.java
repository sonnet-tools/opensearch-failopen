 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 *
/*  
package org.opensearch.index.analysis;
 *  
 * The OpenSearch Contributors require contributions made to  
/*  
import java.io.Reader;  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 */  
/*
 * You may obtain a copy of the License at  
}
 * under the License.  
@PublicApi(since = "1.0.0")
 * Base character filter factory behavior used in analysis chain  
    }
 * specific language governing permissions and limitations
 */  
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
/**
 * Licensed to Elasticsearch under one or more contributor  
    default Reader normalize(Reader reader) {
    String name();
 * not use this file except in compliance with the License.
 */
 *
 * ownership. Elasticsearch licenses this file to you under  
    Reader create(Reader reader);  
 * compatible open source license.
 *
 * license agreements. See the NOTICE file distributed with
 * @opensearch.api
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.PublicApi;
 *    http://www.apache.org/licenses/LICENSE-2.0
        return reader;  
public interface CharFilterFactory {
 */  
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
