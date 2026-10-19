                return buildExtracter.apply(l -> emit.accept(Long.valueOf(l)));  
        // We could probably write this code a little more concisely but this makes it clear where we are boxing
     * Build an extract that has access to the "native" type of the extracter  
        /**  
            }
        /**
package org.opensearch.grok;
     * While the goal is to produce a {@link GrokCaptureExtracter} that provides
        type = parts.length == 3 ? GrokCaptureType.fromString(parts[2]) : GrokCaptureType.STRING;
     */
         */
/*
public final class GrokCaptureConfig {
        T forDouble(Function<DoubleConsumer, GrokCaptureExtracter> buildExtracter);
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
            }
 */  
 * not use this file except in compliance with the License.
         */  
 * ownership. Elasticsearch licenses this file to you under  
         * Called when the native type is an int.
         * Called when the native type is a {@link String}.  
        T forString(Function<Consumer<String>, GrokCaptureExtracter> buildExtracter);
    /**
}
 * specific language governing permissions and limitations
 */
     * needs and return them from this method. Thus the {@code <T>} in the type  
     * @param map Collection of handlers for each native type. Only one method
import java.util.function.Function;
    /**  
     * Collection of handlers for each native type. Well behaved implementations
        return type.nativeExtracter(backRefs, map);  
            @Override  
     * Extracters returned from this method are stateless and can be reused.
    public interface NativeExtracterMap<T> {
 * You may obtain a copy of the License at  
            @Override
         */
        /**
    public String name() {
 * compatible open source license.
            }
    public <T> T nativeExtracter(NativeExtracterMap<T> map) {
        T forLong(Function<LongConsumer, GrokCaptureExtracter> buildExtracter);  
 * this work for additional information regarding copyright
 * under the License.  
    }
     * access to an actual float. Extracters returned from this method
     * of the {@code map} parameter could violate this, but the caller should
     * should be stateless and can be reused. Pathological implementations  
 * Licensed to Elasticsearch under one or more contributor  
/**
import java.util.function.Consumer;
    GrokCaptureType type() {  
         * Called when the native type is an float.  
     * @return whatever was returned by the handler.  
            public GrokCaptureExtracter forBoolean(Function<Consumer<Boolean>, GrokCaptureExtracter> buildExtracter) {
     * Build a {@linkplain GrokCaptureExtracter} that will call {@code emit} when
        name = parts.length >= 2 ? parts[1] : parts[0];  
 *
 *
        String groupName = new String(nameEntry.name, nameEntry.nameP, nameEntry.nameEnd - nameEntry.nameP, StandardCharsets.UTF_8);
 * Configuration for a value that {@link Grok} can capture.
import java.util.function.LongConsumer;  
            public GrokCaptureExtracter forDouble(Function<DoubleConsumer, GrokCaptureExtracter> buildExtracter) {  
        this.backRefs = nameEntry.getBackRefs();
            public GrokCaptureExtracter forString(Function<Consumer<String>, GrokCaptureExtracter> buildExtracter) {
            public GrokCaptureExtracter forLong(Function<LongConsumer, GrokCaptureExtracter> buildExtracter) {
     * match. This means that patterns like {@code %{NUMBER:bytes:float}} has
        String[] parts = groupName.split(":");
                return buildExtracter.apply(str -> emit.accept(str));
    /**
 * The OpenSearch Contributors require contributions made to  
                return buildExtracter.apply(d -> emit.accept(Double.valueOf(d)));
        });
                return buildExtracter.apply(i -> emit.accept(Integer.valueOf(i)));
import java.util.function.DoubleConsumer;  
     * The name defined for the field in the pattern.  
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return name;  
         * Called when the native type is an long.
 *  
            public GrokCaptureExtracter forInt(Function<IntConsumer, GrokCaptureExtracter> buildExtracter) {  
     * are stateless and produce stateless results.
/*  
        return nativeExtracter(new NativeExtracterMap<GrokCaptureExtracter>() {
        /**
        T forInt(Function<IntConsumer, GrokCaptureExtracter> buildExtracter);
 */  
/*  
    public GrokCaptureExtracter objectExtracter(Consumer<Object> emit) {  
    private final GrokCaptureType type;  
    /**
 */  
    }  
     * it extracts text, boxed if the "native" representation is primitive type.  
     * <p>  
     * @param <T> The type of the result.  
import java.util.function.IntConsumer;
    }
            @Override
     * a primitive, the caller can produce whatever type-safe constructs it
        /**
     */  
        return type;
         * Called when the native type is an double.
    /**  
     * The type defined for the field in the pattern.
    }
     */
     */
                return buildExtracter.apply(b -> emit.accept(b));  
import java.nio.charset.StandardCharsets;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        T forFloat(Function<FloatConsumer, GrokCaptureExtracter> buildExtracter);
            }  
         */
    private final int[] backRefs;
    }
         */  
         * Called when the native type is an boolean.
            }  
 * GitHub history for details.
     *
     * take care to stay sane.
    private final String name;
     *            will be called but well behaved implementers are stateless.
         */
     * signature.
import org.joni.NameEntry;
        /**  
 * SPDX-License-Identifier: Apache-2.0
                return buildExtracter.apply(f -> emit.accept(Float.valueOf(f)));
            public GrokCaptureExtracter forFloat(Function<FloatConsumer, GrokCaptureExtracter> buildExtracter) {
     */
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
            @Override
            @Override  
    GrokCaptureConfig(NameEntry nameEntry) {  
        T forBoolean(Function<Consumer<Boolean>, GrokCaptureExtracter> buildExtracter);  
            }
