import java.util.function.Supplier;
     */  
package org.opensearch.index.codec;
     *
@ExperimentalApi
 * ability to implement conflict resolution strategy.
     * @param defaultCodec default {@code Codec} supplier
 * The OpenSearch Contributors require contributions made to  
     *
 * @opensearch.experimental  
 * that require non-trivial instantiation logic (could not be registered using service  
 * The {@link AdditionalCodecs} is designated as a mechanism to contribute additional {@link Codec}
import org.apache.lucene.codecs.Codec;
 *
     * @return additional {@code Codec} instances, should not be "null"
 * loader).
     * @param mapperService mapper service (if available)
import java.util.Map;
/**
 *
     * @param indexSettings index settings  
/*  
 * registered, OpenSearch does not provide any ordering / precedence guarantees besides the  
 *
     * <b>Note</b>: The default codec (see {@link CodecService#LUCENE_DEFAULT_CODEC}) could not be changed
 * this file be licensed under the Apache-2.0 license or a
 */  
     * Return an additional {@code Codec} instances to be registered with the default
import org.opensearch.index.IndexSettings;
 * <p>  
     * <b>Note</b>: In case there is already registered {@code Codec} with the same name the exception
     * (or custom, if provided) {@link CodecService}.  
 */
    Map<String, Codec> getCodecs(@Nullable MapperService mapperService, IndexSettings indexSettings, Supplier<Codec> defaultCodec);
import org.opensearch.index.mapper.MapperService;
     *
public interface AdditionalCodecs {  
    /**
 * compatible open source license.
     * or removed, attempt to do so will lead to exception.  
     * will be raised.  
}
 * <b>Note</b>: since any plugin could contribute own list of additional {@link Codec}s to be
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.ExperimentalApi;  
 *
import org.opensearch.common.Nullable;
