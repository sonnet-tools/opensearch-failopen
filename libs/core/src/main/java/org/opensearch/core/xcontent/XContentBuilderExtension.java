     */
     * }
     * </pre>
public interface XContentBuilderExtension {
 */  
     *     return addlWriters;
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.core.xcontent;
     * {@code
     *     transformers.put(ByteSizeValue.class, (value) -> ((ByteSizeValue) value).bytes());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
 *  
     * {@code  
 * specific language governing permissions and limitations
import java.util.function.Function;
     */  
/*  
     *     addlWriters.put(BytesRef.class, (builder, value) -> b.value(((BytesRef) value).utf8String()));
     * encodable object).
 * the Apache License, Version 2.0 (the "License"); you may
     *     Map<Class<?>, XContentBuilder.Writer> addlWriters = new HashMap<>();  
    /**  
     * }  
 * It is <b>greatly</b> preferred that you implement {@link ToXContentFragment}
    Map<Class<?>, Function<Object, Object>> getDateTransformers();
     * @return a map of class name to writer  
     * </pre>  
     * Used for plugging a transformer for a date or time type object into a String (or other
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
     * <pre>
    Map<Class<?>, XContentBuilder.HumanReadableTransformer> getXContentHumanReadableTransformers();
 * under the License.  
     *     transformers.put(Date.class, d -> datePrinter.print(((Date) d).getTime()));
 * this file be licensed under the Apache-2.0 license or a
     * }  
/**
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
     *
     * {@code
 * This interface provides a way for non-JDK classes to plug in a way to serialize to xcontent.
     *     final DateTimeFormatter datePrinter = ISODateTimeFormat.dateTime().withZone(DateTimeZone.UTC);
     * </pre>
     * <pre>
 * license agreements. See the NOTICE file distributed with
 * in the class for encoding, however, in some situations you may not own the
     *
     */
     * Used for plugging in a generic writer for a class, for example, an example implementation:
 */
     *     Map<Class<?>, XContentBuilder.HumanReadableTransformer> transformers = new HashMap<>();
 */  
     * @return a map of class name to transformer used to retrieve raw value
 * KIND, either express or implied.  See the License for the
import java.util.Map;
}  
 * <p>  
 * GitHub history for details.
 * software distributed under the License is distributed on an
     * Used for plugging in a human readable version of a class's encoding. It is assumed that
     * <pre>  
 * Licensed to Elasticsearch under one or more contributor  
/*
     *     Map<Class<?>, Function<Object, Object>> transformers = new HashMap<>();  
     * An example implementation:  
     *  
 * You may obtain a copy of the License at  
 * class, in which case you can add an implementation here for encoding it.  
     * the human readable equivalent is <b>always</b> behind the {@code toString()} method, so  
    Map<Class<?>, XContentBuilder.Writer> getXContentWriters();
 *
 *
     * <p>
     * For example:
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
     *
     * this transformer returns the raw value to be used.
     * <p>  
/*  
