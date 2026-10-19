    public void testUpdatesWithSameMappings() throws IOException {  
        MapperService mapperService = createIndex("test", indexSettings).mapperService();
    public void testDefaultConfig() throws IOException {  
public class NestedPathFieldMapperTests extends OpenSearchSingleNodeTestCase {
            MapperService.SINGLE_MAPPING_NAME,
 */  
            MapperService.MergeReason.MAPPING_UPDATE  
import java.util.Collections;
        );
            new CompressedXContent("{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{}}"),
            MapperService.SINGLE_MAPPING_NAME,
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }  
        ParsedDocument document = mapper.parse(new SourceToParse("index", "id", new BytesArray("{}"), MediaTypeRegistry.JSON));
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(Collections.<IndexableField>emptyList(), Arrays.asList(document.rootDoc().getFields(NestedPathFieldMapper.NAME)));  
import org.opensearch.core.common.bytes.BytesArray;
import java.util.Arrays;  
            new CompressedXContent("{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{}}"),
/*  
package org.opensearch.index.mapper;
        DocumentMapper mapper = mapperService.merge(  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
        DocumentMapper mapper = mapperService.merge(  
 * The OpenSearch Contributors require contributions made to  
        Settings indexSettings = Settings.EMPTY;
 *
        mapper.merge(mapper.mapping(), MapperService.MergeReason.MAPPING_UPDATE);
import org.opensearch.common.compress.CompressedXContent;
/** tests for {@link org.opensearch.index.mapper.NestedPathFieldMapper} */  
import java.io.IOException;
import org.apache.lucene.index.IndexableField;
            MapperService.MergeReason.MAPPING_UPDATE  
        );
}
        MapperService mapperService = createIndex("test", indexSettings).mapperService();
 * compatible open source license.
    }
        Settings indexSettings = Settings.EMPTY;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;  
