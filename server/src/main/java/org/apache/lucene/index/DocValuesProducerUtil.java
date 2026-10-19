 */  
}
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
     * @return the segment doc values producers  
        return Collections.emptySet();  
 * Utility class for DocValuesProducers
 */  
    }
import org.apache.lucene.codecs.DocValuesProducer;
     * Returns the segment doc values producers for the given doc values producer.  
import java.util.Set;
package org.apache.lucene.index;
    /**
/**  
        }
/*  
        if (docValuesProducer instanceof SegmentDocValuesProducer) {  
 *
 * The OpenSearch Contributors require contributions made to  
public class DocValuesProducerUtil {
            return (((SegmentDocValuesProducer) docValuesProducer).dvProducers);
     */
     * @param docValuesProducer the doc values producer
     * If the given doc values producer is not a segment doc values producer, an empty set is returned.
    public static Set<DocValuesProducer> getSegmentDocValuesProducers(DocValuesProducer docValuesProducer) {
import java.util.Collections;  
