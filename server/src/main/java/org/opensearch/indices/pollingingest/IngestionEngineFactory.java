        this.ingestServiceSupplier = Objects.requireNonNull(ingestServiceSupplier);
import org.opensearch.index.engine.Engine;
        if (config.isReadOnlyReplica()) {
import org.opensearch.index.engine.EngineFactory;  
        if (isAllActiveIngestion) {
        return ingestionEngine;
    }
        this.payloadDecoderFactory = Objects.requireNonNull(payloadDecoderFactory);  
/*  
 * compatible open source license.
import java.util.Objects;
import org.opensearch.index.engine.NRTReplicationEngine;
        assert ingestService != null : "IngestService supplier returned null. This indicates a initialization ordering issue.";
            // use ingestion engine on both primary and replica in all-active mode
    /**  
 */
    public Engine newReadWriteEngine(EngineConfig config) {  
import org.opensearch.index.engine.EngineConfig;
    public IngestionEngineFactory(
/**
import org.opensearch.ingest.IngestService;  
        // For non all-active modes, fallback to the standard segrep model
 *
        }  
        }  
 * The OpenSearch Contributors require contributions made to  
    ) {  
        IngestService ingestService = ingestServiceSupplier.get();
        Supplier<IngestService> ingestServiceSupplier,
     * All-active ingestion mode is supported, where the replicas will consume and process messages from the streaming
        this.ingestionConsumerFactory = Objects.requireNonNull(ingestionConsumerFactory);
        IngestionEngine ingestionEngine = new IngestionEngine(config, ingestionConsumerFactory, ingestService, payloadDecoderFactory);
 * this file be licensed under the Apache-2.0 license or a
    private final IngestionPayloadDecoderFactory payloadDecoderFactory;  
 */  
}  
        // NRTReplicationEngine is used for segment replication on replicas  
        IngestionPayloadDecoderFactory payloadDecoderFactory
    @Override
        ingestionEngine.start();  
     * source similar to the primary.  
import java.util.function.Supplier;  
     * Segment replication will use the IngestionEngine on primary and NRTReplicationEngine on replicas.
        boolean isAllActiveIngestion = ingestionSource != null && ingestionSource.isAllActiveIngestionEnabled();
     */
import org.opensearch.index.IngestionPayloadDecoderFactory;  
            return new NRTReplicationEngine(config);
            return ingestionEngine;
public class IngestionEngineFactory implements EngineFactory {
 * Engine Factory implementation used with streaming ingestion.  
import org.opensearch.index.engine.IngestionEngine;
            IngestionEngine ingestionEngine = new IngestionEngine(config, ingestionConsumerFactory, ingestService, payloadDecoderFactory);  
    private final Supplier<IngestService> ingestServiceSupplier;
 * SPDX-License-Identifier: Apache-2.0
        IngestionConsumerFactory ingestionConsumerFactory,  
    }
import org.opensearch.index.IngestionConsumerFactory;
    private final IngestionConsumerFactory ingestionConsumerFactory;
package org.opensearch.indices.pollingingest;
import org.opensearch.cluster.metadata.IngestionSource;
        IngestionSource ingestionSource = config.getIndexSettings().getIndexMetadata().getIngestionSource();
            ingestionEngine.start();
