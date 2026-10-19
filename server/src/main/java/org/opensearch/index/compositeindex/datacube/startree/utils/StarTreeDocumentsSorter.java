                    }
 */
package org.opensearch.index.compositeindex.datacube.startree.utils;
            protected void setPivot(int i) {  
            }
import java.util.Objects;
                return 0;  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.util.IntroSorter;
     * Sort documents based on the dimension values off heap using intro sorter.
 * compatible open source license.
    ) {  
                sortedDocIds[j] = temp;
 * The OpenSearch Contributors require contributions made to  
                for (int i = dimensionId + 1; i < dimensions.length; i++) {
            protected void swap(int i, int j) {
        final List<Comparator<Long>> dimensionComparators
    public static void sort(  
        new IntroSorter() {
        final int dimensionId,
    /**  
 * Utility class for building star tree  
        final IntFunction<Long[]> dimensionsReader,
        final int numDocs,  
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
                sortedDocIds[i] = sortedDocIds[j];
            @Override
        }.sort(0, numDocs);
import java.util.function.IntFunction;  
            @Override
                int temp = sortedDocIds[i];  
            protected int comparePivot(int j) {
                        return dimensionComparators.get(i).compare(dimensions[i], currentDimensions[i]);  
import java.util.Comparator;  
                }
            @Override
            }
 */  
 *
/*  
}
                    if (!Objects.equals(dimensions[i], currentDimensions[i])) {
            }  
public class StarTreeDocumentsSorter {
            private Long[] dimensions;
     */
                Long[] currentDimensions = dimensionsReader.apply(j);  
/**
                dimensions = dimensionsReader.apply(i);
    }  
        final int[] sortedDocIds,
