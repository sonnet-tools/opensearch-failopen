package org.opensearch.index.compositeindex.datacube.startree;
 *
    }
 */  
import org.opensearch.common.annotation.ExperimentalApi;
 * @opensearch.experimental
}  
/**
 *
    public StarTreeDocument(Long[] dimensions, Object[] metrics) {  
 */  
@ExperimentalApi
    public String toString() {  
    }  
        this.dimensions = dimensions;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Arrays;  
    public final Long[] dimensions;  
 * compatible open source license.
/*  
    @Override
        this.metrics = metrics;
public class StarTreeDocument {
 * SPDX-License-Identifier: Apache-2.0
 * Star tree document  
        return Arrays.toString(dimensions) + " | " + Arrays.toString(metrics);
 * The OpenSearch Contributors require contributions made to  
    public final Object[] metrics;
