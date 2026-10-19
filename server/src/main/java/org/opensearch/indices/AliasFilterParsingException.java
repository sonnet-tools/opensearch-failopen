        setIndex(index);
 *
 */  
import org.opensearch.core.common.io.stream.StreamInput;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * this work for additional information regarding copyright
import org.opensearch.OpenSearchException;
    public AliasFilterParsingException(StreamInput in) throws IOException {
        super(in);
 * @opensearch.internal
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
/**
package org.opensearch.indices;
 * Exception thrown for parsing alias filters
    public AliasFilterParsingException(Index index, String name, String desc, Throwable ex) {
 * GitHub history for details.
 *
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 */
 * the Apache License, Version 2.0 (the "License"); you may
}
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 */  
/*
 * SPDX-License-Identifier: Apache-2.0
public class AliasFilterParsingException extends OpenSearchException {  
 * specific language governing permissions and limitations
import org.opensearch.core.index.Index;  
 * KIND, either express or implied.  See the License for the
 */
 *  
import java.io.IOException;
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super("[" + name + "], " + desc, ex);  
/*  
 *  
    }
    }  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
