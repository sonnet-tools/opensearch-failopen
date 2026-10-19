 * compatible open source license.
import org.opensearch.core.ParseField;
public final class ObjectParserHelper<Value, Context> {  
    }
 * GitHub history for details.
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * classes outside of the xcontent dependencies.
 */  
                builder.copyCurrentStructure(p);  
 * ownership. Elasticsearch licenses this file to you under  
    public void declareRawObject(
     * Helper to declare an object that will be parsed into a {@link BytesReference}  
/*
import org.opensearch.core.common.bytes.BytesReference;  
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;  
    ) {  
            }
        final CheckedFunction<XContentParser, BytesReference, IOException> bytesParser = p -> {
 * Licensed to Elasticsearch under one or more contributor  
/**  
 */
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * This class provides helpers for {@link ObjectParser} that allow dealing with
import java.util.function.BiConsumer;
 * You may obtain a copy of the License at  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 *  
import org.opensearch.common.CheckedFunction;
/*  
 * @opensearch.internal
 *
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
        final ParseField field
     */
 *
 */
 * under the License.  
        final AbstractObjectParser<Value, Context> parser,  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
    /**
 * KIND, either express or implied.  See the License for the
            try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
 *  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.core.xcontent;
        parser.declareField(consumer, bytesParser, field, ValueType.OBJECT);
}
        final BiConsumer<Value, BytesReference> consumer,
                return BytesReference.bytes(builder);
import org.opensearch.core.xcontent.ObjectParser.ValueType;
        };  
/*  
