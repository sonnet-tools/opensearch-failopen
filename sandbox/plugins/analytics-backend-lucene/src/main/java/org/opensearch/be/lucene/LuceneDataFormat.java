        new FieldTypeCapabilities(FieldNamesFieldMapper.CONTENT_TYPE, Set.of(FULL_TEXT_SEARCH)),
import org.opensearch.index.mapper.RoutingFieldMapper;
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;  
    /** {@inheritDoc} Returns capabilities for {@code text} and {@code keyword} fields. */
import org.opensearch.index.mapper.NestedPathFieldMapper;
        new FieldTypeCapabilities(KeywordFieldMapper.CONTENT_TYPE, Set.of(FULL_TEXT_SEARCH, STORED_FIELDS, COLUMNAR_STORAGE)),
    @Override  
@ExperimentalApi  
 * secondary data format alongside Parquet (primary).
 * compatible open source license.
import org.opensearch.index.mapper.IdFieldMapper;
    }  
        new FieldTypeCapabilities(IgnoredFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH))
        return 50L;
    /** {@inheritDoc} Returns {@code "lucene"}. */
    /** {@inheritDoc} Returns {@code 50}, lower than the primary Parquet format. */
 * {@link DataFormat} descriptor for Lucene inverted indices.
/*  
        new FieldTypeCapabilities(NestedPathFieldMapper.NAME, Set.of(FULL_TEXT_SEARCH)),  
import org.opensearch.index.engine.dataformat.DataFormat;
        new FieldTypeCapabilities(SeqNoFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, POINT_RANGE)),
public class LuceneDataFormat extends DataFormat {
 *
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.mapper.IgnoredFieldMapper;  
        new FieldTypeCapabilities(TextFieldMapper.CONTENT_TYPE, Set.of(FULL_TEXT_SEARCH, STORED_FIELDS)),  
        new FieldTypeCapabilities(VersionFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE)),  
        // Metadata fields
 */  
        new FieldTypeCapabilities(IndexFieldMapper.CONTENT_TYPE, Set.of(COLUMNAR_STORAGE, FULL_TEXT_SEARCH)),
 * The priority value ({@code 50}) is lower than the primary Parquet format, ensuring
        new FieldTypeCapabilities(IdFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),  
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.STORED_FIELDS;
 * this file be licensed under the Apache-2.0 license or a
    private static final Set<FieldTypeCapabilities> SUPPORTED_FIELDS = Set.of(  
        return SUPPORTED_FIELDS;
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.COLUMNAR_STORAGE;
import org.opensearch.index.mapper.VersionFieldMapper;  
    @Override  
import org.opensearch.index.mapper.MatchOnlyTextFieldMapper;  
import org.opensearch.index.mapper.TextFieldMapper;
    );  
 * stored field capabilities. Used by the composite engine to identify Lucene as a
    }  
    /** The format name used to register Lucene in the {@link org.opensearch.index.engine.dataformat.DataFormatRegistry}. */  
        new FieldTypeCapabilities(SourceFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS)),
}
import org.opensearch.index.mapper.FieldNamesFieldMapper;
    public static final String LUCENE_FORMAT_NAME = "lucene";
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
        new FieldTypeCapabilities(MatchOnlyTextFieldMapper.CONTENT_TYPE, Set.of(FULL_TEXT_SEARCH, STORED_FIELDS)),
import org.opensearch.common.annotation.ExperimentalApi;
        return LUCENE_FORMAT_NAME;
 */
        // Text types — full-text search + stored
 * Lucene is treated as a secondary format in the composite engine's format ordering.
import org.opensearch.index.mapper.SourceFieldMapper;
package org.opensearch.be.lucene;
    public Set<FieldTypeCapabilities> supportedFields() {
 * @opensearch.experimental
    public String name() {
import org.opensearch.index.mapper.KeywordFieldMapper;
/**  
 * The OpenSearch Contributors require contributions made to  
 * <p>  
import org.opensearch.index.mapper.IndexFieldMapper;
    }  
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.POINT_RANGE;  
 *  
    @Override  
import java.util.Set;
import org.opensearch.index.mapper.SeqNoFieldMapper;  
    public long priority() {
        new FieldTypeCapabilities(SeqNoFieldMapper.PRIMARY_TERM_NAME, Set.of(COLUMNAR_STORAGE)),
 * Declares support for {@code text} and {@code keyword} fields with inverted index and  
 * <p>
        new FieldTypeCapabilities(RoutingFieldMapper.CONTENT_TYPE, Set.of(STORED_FIELDS, FULL_TEXT_SEARCH)),
