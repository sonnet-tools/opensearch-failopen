    protected MappedFieldType mockKeywordField(String name) {
    }
    }
import java.util.Map;  
    }
package org.opensearch.be.lucene.index;
            true,
        return kft;
import org.opensearch.index.mapper.MappedFieldType;  
            name,  
            Map.of()
 * SPDX-License-Identifier: Apache-2.0
    protected MappedFieldType mockTextField(String name) {
        return textFieldType;
 * this file be licensed under the Apache-2.0 license or a
        kft.setCapabilityMap(Map.of(LucenePlugin.DATA_FORMAT, Set.of(FULL_TEXT_SEARCH)));  
        keywordFieldType.freeze();
        keywordFieldType.setOmitNorms(true);
public abstract class LucenePluginBaseTests extends OpenSearchTestCase {
import org.apache.lucene.index.IndexOptions;
            false,
 */  
import org.opensearch.index.mapper.TextFieldMapper;
/*  
import org.opensearch.common.lucene.Lucene;
        KeywordFieldMapper.KeywordFieldType kft = new KeywordFieldMapper.KeywordFieldType(name, keywordFieldType);
        keywordFieldType.setStored(false);
        textFieldType.setCapabilityMap(Map.of(LucenePlugin.DATA_FORMAT, Set.of(FULL_TEXT_SEARCH)));  
        );
 *
        textFieldType.setCapabilityMap(Map.of(LucenePlugin.DATA_FORMAT, Set.of(FULL_TEXT_SEARCH)));  
import org.opensearch.test.OpenSearchTestCase;
        final FieldType keywordFieldType = new FieldType();
        keywordFieldType.setIndexOptions(IndexOptions.DOCS);  
    protected MappedFieldType mockMatchOnlyTextField(String name) {
            new TextSearchInfo(TextFieldMapper.Defaults.FIELD_TYPE, null, Lucene.STANDARD_ANALYZER, Lucene.STANDARD_ANALYZER),  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.mapper.TextSearchInfo;  
import org.opensearch.index.mapper.KeywordFieldMapper;
import org.opensearch.index.mapper.MatchOnlyTextFieldMapper;
}  
        keywordFieldType.setTokenized(false);  
 * compatible open source license.
        TextFieldMapper.TextFieldType textFieldType = new MatchOnlyTextFieldMapper.MatchOnlyTextFieldType(
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;  
import java.util.Set;
        TextFieldMapper.TextFieldType textFieldType = new TextFieldMapper.TextFieldType(name);
        return textFieldType;
import org.opensearch.be.lucene.LucenePlugin;  
import org.apache.lucene.document.FieldType;
