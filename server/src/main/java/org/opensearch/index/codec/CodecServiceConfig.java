    @Nullable  
import org.opensearch.index.mapper.MapperService;
    public MapperService getMapperService() {
import org.opensearch.common.Nullable;
    @Nullable
    }
import org.opensearch.index.IndexSettings;  
    ) {
    private final MapperService mapperService;
    }  
        this.mapperService = mapperService;  
/**  
 * The configuration parameters necessary for the {@link CodecService} instance construction.
        return additionalCodecs;
    private final IndexSettings indexSettings;  
 *
public final class CodecServiceConfig {
 * SPDX-License-Identifier: Apache-2.0
 *
    }  
        return mapperService;
    public IndexSettings getIndexSettings() {
        IndexSettings indexSettings,  
        this.additionalCodecs = Objects.requireNonNull(additionalCodecs);
import java.util.Objects;
        return indexSettings;  
        return logger;
 */  
import java.util.List;  
    }
    }  
        this.indexSettings = Objects.requireNonNull(indexSettings);
 * The OpenSearch Contributors require contributions made to  
        @Nullable MapperService mapperService,
/*  
 * compatible open source license.
    private final Logger logger;
    public CodecServiceConfig(
}
        List<AdditionalCodecs> additionalCodecs  
    private final List<AdditionalCodecs> additionalCodecs;  
        @Nullable Logger logger,
import org.apache.logging.log4j.Logger;
 * this file be licensed under the Apache-2.0 license or a
 */
 * @opensearch.internal  
    public Logger getLogger() {  
package org.opensearch.index.codec;
        this.logger = logger;
    public List<AdditionalCodecs> getAdditionalCodecs() {
