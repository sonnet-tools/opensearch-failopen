        if (mapperService == null) {
        }
        @Nullable MapperService mapperService,  
                } else {
 */
                codecs.putAll(compositeCodecFactory.getCompositeIndexCodecs(mapperService, logger));
            throw new IllegalArgumentException("failed to find codec [" + name + "]");  
        return codec;
    /**  
 * {@link Codec} capabilities through this {@link CodecService}.
 *    http://www.apache.org/licenses/LICENSE-2.0
                    throw new IllegalStateException("The codec with name " + name + " is already registered.");  
import org.apache.lucene.codecs.lucene104.Lucene104Codec;  
 * data-structures per field. OpenSearch exposes the full
@PublicApi(since = "3.3.0")  
    /**  
    public static final String LZ4 = "lz4";  
    }  
                    throw new IllegalStateException("The default codec could not be replaced");
            }
 * @opensearch.api
        codecs.put(LUCENE_DEFAULT_CODEC, Codec.getDefault());  
 * software distributed under the License is distributed on an
        for (String codec : Codec.availableCodecs()) {
            if (mapperService.isCompositeIndexPresent()) {  
            // We can still support all the compression codecs when composite index is present
    /**
        final MapBuilder<String, Codec> codecs = MapBuilder.<String, Codec>newMapBuilder();
    private final CompositeCodecFactory compositeCodecFactory = new CompositeCodecFactory();
 * specific language governing permissions and limitations
import java.util.Collection;
/**
    public static final String ZLIB = "zlib";
 * Unless required by applicable law or agreed to in writing,
/*
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;  
     * @deprecated Please use {@code CodecService(MapperService, IndexSettings, Logger, Collection<CodecRegistry>)}
                codecs.put(
                codecs.put(LZ4, new PerFieldMappingPostingFormatCodec(Lucene104Codec.Mode.BEST_SPEED, mapperService, logger));
     */
        final Supplier<Codec> defaultCodec = () -> codecs.get(DEFAULT_CODEC);  
 *
import java.util.Map;
                }
import org.opensearch.common.annotation.PublicApi;
 */  
    }
 * GitHub history for details.
/*  
    ) {
    public Codec codec(String name) {  
 * KIND, either express or implied.  See the License for the
    public CodecService(@Nullable MapperService mapperService, IndexSettings indexSettings, Logger logger) {
                    new PerFieldMappingPostingFormatCodec(Lucene104Codec.Mode.BEST_COMPRESSION, mapperService, logger)
    @Deprecated(forRemoval = true)  
            for (Map.Entry<String, Codec> additionalCodec : additionalCodecs.entrySet()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
        return codecs.keySet().toArray(new String[0]);  
    /**
 * The OpenSearch Contributors require contributions made to  
 * Since Lucene 4.0 low level index segments are read and written through a
import org.opensearch.common.Nullable;
            codecs.put(BEST_COMPRESSION_CODEC, new Lucene104Codec(Lucene104Codec.Mode.BEST_COMPRESSION));
        }  
            codecs.put(DEFAULT_CODEC, new Lucene104Codec());
        }
     */
     * Returns all registered available codec names  
        IndexSettings indexSettings,
            final Map<String, Codec> additionalCodecs = registry.getCodecs(mapperService, indexSettings, defaultCodec);
import java.util.function.Supplier;
            } else {
                if (existing == null) {  
     * the raw unfiltered lucene default. useful for testing
    }
                final String name = additionalCodec.getKey();
 *  
        }  
    public CodecService(
 * Licensed to Elasticsearch under one or more contributor  
}
        for (AdditionalCodecs registry : registries) {
 * this work for additional information regarding copyright
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
    public String[] availableCodecs() {
    public final Codec defaultCodec() {
 */  
                codecs.put(DEFAULT_CODEC, new PerFieldMappingPostingFormatCodec(Lucene104Codec.Mode.BEST_SPEED, mapperService, logger));  
        assert null != indexSettings;  
 * ownership. Elasticsearch licenses this file to you under  
    private final Map<String, Codec> codecs;  
 * the Apache License, Version 2.0 (the "License"); you may
                );
    }  
                final Codec existing = codecs.get(name);
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.codecs.Codec;
                codecs.put(ZLIB, new PerFieldMappingPostingFormatCodec(Lucene104Codec.Mode.BEST_COMPRESSION, mapperService, logger));  
            codecs.put(ZLIB, new Lucene104Codec(Lucene104Codec.Mode.BEST_COMPRESSION));
import org.opensearch.index.IndexSettings;
 * codec layer that allows to use use-case specific file formats &amp;  
package org.opensearch.index.codec;
import org.opensearch.index.mapper.MapperService;  
     */
    }  
                if (name.equalsIgnoreCase(LUCENE_DEFAULT_CODEC) == true) {
        Logger logger,
    public static final String BEST_COMPRESSION_CODEC = "best_compression";
        } else {  
        // Register all additional codecs (if available)
                    codecs.put(name, additionalCodec.getValue());
    public static final String LUCENE_DEFAULT_CODEC = "lucene_default";  
        Codec codec = codecs.get(name);
            codecs.put(LZ4, new Lucene104Codec());  
                }  
        return codecs.get(DEFAULT_CODEC);  
/*  
            codecs.put(codec, Codec.forName(codec));
     * Returns default codec  
 *
                    BEST_COMPRESSION_CODEC,  
        this(mapperService, indexSettings, logger, List.of());
 */
        if (codec == null) {
 *  
                // Default codec could not be changed  
            // CompositeCodec still delegates to PerFieldMappingPostingFormatCodec
public class CodecService {
import org.apache.logging.log4j.Logger;
import org.opensearch.common.collect.MapBuilder;  
import org.opensearch.index.codec.composite.CompositeCodecFactory;
    public static final String DEFAULT_CODEC = "default";
        Collection<AdditionalCodecs> registries  
 * Modifications Copyright OpenSearch Contributors. See
            }
        this.codecs = codecs.immutableMap();
