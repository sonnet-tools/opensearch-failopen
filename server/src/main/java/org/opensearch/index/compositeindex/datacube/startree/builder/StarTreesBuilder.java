                starTreeFields.add(  
     * @param fieldProducerMap             fetches iterators for the fields (dimensions and metrics)  
     * @param dataOut                    an IndexInput for star-tree data
import java.util.Map;
            case OFF_HEAP:
 * The OpenSearch Contributors require contributions made to  
        List<StarTreeField> starTreeFields = new ArrayList<>();
        for (Map.Entry<String, List<StarTreeValues>> entry : starTreeValuesSubsPerField.entrySet()) {
 * compatible open source license.
        }
     * Merges star tree fields from multiple segments
import org.apache.lucene.codecs.DocValuesProducer;
 * @opensearch.experimental
import java.util.concurrent.atomic.AtomicInteger;
            if (starTreeValuesList.isEmpty()) {  
        MapperService mapperService  
            default:
    }
import java.util.List;
            }  
    /**  
        // Build all star-trees
    private final SegmentWriteState state;  
                    )
/**
    }
 */
}
                        starTreeField.getStarTreeConfig().getBuildMode()  
        switch (starTreeField.getStarTreeConfig().getBuildMode()) {
                    String.format(  
                        starTreeFieldType.getDimensions(),  
        IndexOutput metaOut,
            return;  
        IndexOutput dataOut,  
package org.opensearch.index.compositeindex.datacube.startree.builder;
    private static final Logger logger = LogManager.getLogger(StarTreesBuilder.class);  
    ) throws IOException {
     * @param metaOut                    an IndexInput for star-tree metadata  
                        "No star tree implementation is available for [%s] build mode",
    public StarTreesBuilder(SegmentWriteState segmentWriteState, MapperService mapperService, AtomicInteger fieldNumberAcrossStarTrees) {
            starTreeValuesSubsPerField.size()  
                        Locale.ROOT,
import java.io.Closeable;
                );
     * @param dataOut                      an IndexInput for star-tree data
@ExperimentalApi  
import org.apache.lucene.codecs.DocValuesConsumer;  
            case ON_HEAP:  
            List<StarTreeValues> starTreeValuesList = entry.getValue();
import java.util.ArrayList;
        this.mapperService = mapperService;  
 *
        }
import java.util.Locale;  
            try (StarTreeBuilder starTreeBuilder = getStarTreeBuilder(metaOut, dataOut, starTreeField, state, mapperService)) {  
 */  
        long startTime = System.currentTimeMillis();
     * @param starTreeDocValuesConsumer  a consumer to write star-tree doc values  
public class StarTreesBuilder implements Closeable {
     */  
                );
import org.apache.lucene.index.SegmentWriteState;
     * Builds all star-trees for given star-tree fields.
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
     *  
    }
                return new OffHeapStarTreeBuilder(metaOut, dataOut, starTreeField, state, mapperService);  
        }  
        logger.debug("Starting building {} star-trees with star-tree fields", numStarTrees);
        }  
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;  
        // TODO : close files  
        logger.debug("Starting merge of {} star-trees with star-tree fields", starTreeValuesSubsPerField.size());
        logger.debug(  
            "Took {} ms to merge {} star-trees with star-tree fields",
import org.opensearch.index.mapper.StarTreeMapper;  
        IndexOutput metaOut,
    ) throws IOException {  
            }
     * @throws IOException                 when an error occurs while building the star-trees
                        starTreeFieldType.name(),
     * @param starTreeValuesSubsPerField starTreeValuesSubs per field
                && compositeMappedFieldType.unwrap() instanceof StarTreeMapper.StarTreeFieldType starTreeFieldType) {
        for (CompositeMappedFieldType compositeMappedFieldType : mapperService.getCompositeFieldTypes()) {  
    public void build(
                return new OnHeapStarTreeBuilder(metaOut, dataOut, starTreeField, state, mapperService);
        if (starTreeFields.isEmpty()) {
            }
        SegmentWriteState state,
 *  
        int numStarTrees = starTreeFields.size();
        this.fieldNumberAcrossStarTrees = fieldNumberAcrossStarTrees;
    }
 * this file be licensed under the Apache-2.0 license or a
 * Builder to construct star-trees based on multiple star-tree fields.
    }
    private final MapperService mapperService;
                    )  
            StarTreeField starTreeField = starTreeValuesList.get(0).getStarTreeField();
     */  
    public void close() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            System.currentTimeMillis() - startTime,
        this.state = segmentWriteState;
    /**
import org.opensearch.index.mapper.MapperService;
        IndexOutput dataOut,
        DocValuesConsumer starTreeDocValuesConsumer  
import java.io.IOException;  
        StarTreeField starTreeField,
                    new StarTreeField(
        for (StarTreeField starTreeField : starTreeFields) {
                logger.debug("StarTreeValues is empty for all segments for field : {}", entry.getKey());
    /**
        logger.debug("Took {} ms to build {} star-trees with star-tree fields", System.currentTimeMillis() - startTime, numStarTrees);
import org.opensearch.common.annotation.ExperimentalApi;
            try (StarTreeBuilder builder = getStarTreeBuilder(metaOut, dataOut, starTreeField, state, mapperService)) {
        long startTime = System.currentTimeMillis();  
     * @param metaOut                      an IndexInput for star-tree metadata
                        starTreeFieldType.getStarTreeConfig()
        IndexOutput metaOut,  
     */
        Map<String, DocValuesProducer> fieldProducerMap,
            }
/*  
        );
import org.apache.logging.log4j.Logger;
    StarTreeBuilder getStarTreeBuilder(
        final Map<String, List<StarTreeValues>> starTreeValuesSubsPerField,
                throw new IllegalArgumentException(
import org.apache.logging.log4j.LogManager;
import org.opensearch.index.mapper.CompositeMappedFieldType;
     * @param starTreeDocValuesConsumer    a consumer to write star-tree doc values
    ) throws IOException {
                builder.build(starTreeValuesList, fieldNumberAcrossStarTrees, starTreeDocValuesConsumer);  
                starTreeBuilder.build(fieldProducerMap, fieldNumberAcrossStarTrees, starTreeDocValuesConsumer);
     *
        IndexOutput dataOut,  
    private final List<StarTreeField> starTreeFields;
            logger.debug("no star-tree fields found, returning from star-tree builder");
     * Get star-tree builder based on build mode.
    public void buildDuringMerge(
import org.apache.lucene.store.IndexOutput;  
                        starTreeFieldType.getMetrics(),
    @Override
                continue;
        }  
        this.starTreeFields = starTreeFields;
            if (compositeMappedFieldType != null
    private AtomicInteger fieldNumberAcrossStarTrees;
        DocValuesConsumer starTreeDocValuesConsumer
