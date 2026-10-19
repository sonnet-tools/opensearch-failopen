    public static final int VERSION_CURRENT = VERSION_START;
/*  
        return new Composite912DocValuesWriter(delegate.fieldsConsumer(state), state, mapperService);
 * @opensearch.experimental  
/**  
    /** Data codec name for Composite Doc Values Format */  
 * this file be licensed under the Apache-2.0 license or a
    /** Filename extension for the composite index skip index doc values */  
        return new Composite912DocValuesReader(delegate.fieldsProducer(state), state);
        this.delegate = delegate;
import org.apache.lucene.codecs.lucene90.Lucene90DocValuesFormat;
 * The OpenSearch Contributors require contributions made to  
    public Composite912DocValuesFormat(MapperService mapperService) {
import org.opensearch.index.mapper.MapperService;
        this.mapperService = mapperService;  
    /** Data doc values codec name for Composite Doc Values Format */  
    /** Skip index doc values codec name for Composite Doc Values Format */  
        super(delegate.getName());
    /** Filename extension for the composite index data */  
 *
        this(new Lucene90DocValuesFormat(), null);
    }
    public Composite912DocValuesFormat(DocValuesFormat delegate, MapperService mapperService) {  
    /** Initial version for the Composite90DocValuesFormat */  
import org.apache.lucene.codecs.DocValuesProducer;  
     * when using {@code PerFieldDocValuesFormat}): in such configurations, for the segment to be read
    public DocValuesConsumer fieldsConsumer(SegmentWriteState state) throws IOException {
    public static final String DATA_EXTENSION = "cid";
    /**
package org.opensearch.index.codec.composite.composite912;
    public static final String DATA_DOC_VALUES_EXTENSION = "cidvd";
    }
@ExperimentalApi
    }
    public static final String META_CODEC_NAME = "Composite912FormatMeta";
    public static final String META_DOC_VALUES_EXTENSION = "cidvm";
    public Composite912DocValuesFormat() {
}  
import org.apache.lucene.index.SegmentReadState;
    /** Current version for the Composite90DocValuesFormat */  
    public static final String SKIP_INDEX_DOC_VALUES_CODEC = "Composite912DocValuesSkipIndex";
    private final DocValuesFormat delegate;  
     * file, etc).
    private final MapperService mapperService;
    /** Meta codec name for Composite Doc Values Format */  
import org.apache.lucene.codecs.DocValuesConsumer;
        this(new Lucene90DocValuesFormat(), mapperService);  
    public static final String META_EXTENSION = "cim";
    /** Meta doc values codec name for Composite Doc Values Format */  
     */
    @Override
    /** Filename extension for the composite index meta */  
 * DocValues format to handle composite indices
    /** Filename extension for the composite index meta doc values */  
 */
public class Composite912DocValuesFormat extends DocValuesFormat {  
    }  
     * Creates a new docvalues format.
     * <p>The provided name will be written into the index segment in some configurations (such as
    // needed for SPI  
 */  
    @Override  
import java.io.IOException;
    public static final String DATA_DOC_VALUES_CODEC = "Composite912DocValuesData";
    public static final String META_DOC_VALUES_CODEC = "Composite912DocValuesMetadata";
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.ExperimentalApi;
import org.apache.lucene.codecs.DocValuesFormat;
    public static final String SKIP_INDEX_DOC_VALUES_EXTENSION = "cidvs";
    }  
    public static final String DATA_CODEC_NAME = "Composite912FormatData";
    /** Filename extension for the composite index data doc values */  
 *
 * compatible open source license.
    public static final int VERSION_START = 0;
     *  
     * this class should be registered with Java's SPI mechanism (registered in META-INF/ of your jar  
import org.apache.lucene.index.SegmentWriteState;  
    public DocValuesProducer fieldsProducer(SegmentReadState state) throws IOException {  
