     * @throws IOException when we are unable to build star-tree
        AtomicInteger fieldNumberAcrossStarTrees,  
        DocValuesConsumer starTreeDocValuesConsumer
 * @opensearch.experimental  
import java.util.Map;  
     *
     * @throws IOException when we are unable to build star-tree
     * @param fieldNumberAcrossStarTrees maintains the unique field number across the fields in the star tree
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
}  
@ExperimentalApi
import org.opensearch.common.annotation.ExperimentalApi;  
     * @param starTreeValuesSubs           contains the star tree values from multiple segments
    void build(
        List<StarTreeValues> starTreeValuesSubs,
     * Builds the star tree using Star Tree values from multiple segments
 *
     * @param starTreeDocValuesConsumer    consumer of star-tree doc values  
     */
 */  
    ) throws IOException;
     * @param fieldNumberAcrossStarTrees   maintains the unique field number across the fields in the star tree
     *  
     * @param fieldProducerMap           contains the docValues producer to get docValues associated with each field
import java.io.IOException;
import java.util.List;
    /**
 * SPDX-License-Identifier: Apache-2.0
public interface StarTreeBuilder extends Closeable {  
 * The OpenSearch Contributors require contributions made to  
     */  
 * this file be licensed under the Apache-2.0 license or a
        DocValuesConsumer starTreeDocValuesConsumer
import java.io.Closeable;  
     *  
        AtomicInteger fieldNumberAcrossStarTrees,  
import java.util.concurrent.atomic.AtomicInteger;
     * @param starTreeDocValuesConsumer  consumer of star-tree doc values  
 * compatible open source license.
import org.apache.lucene.codecs.DocValuesProducer;
    ) throws IOException;
package org.opensearch.index.compositeindex.datacube.startree.builder;
    /**
 */
    void build(
/*  
/**  
 * A star-tree builder that builds a single star-tree.
 *
     * Builds the star tree from the original segment documents
import org.apache.lucene.codecs.DocValuesConsumer;
        Map<String, DocValuesProducer> fieldProducerMap,
