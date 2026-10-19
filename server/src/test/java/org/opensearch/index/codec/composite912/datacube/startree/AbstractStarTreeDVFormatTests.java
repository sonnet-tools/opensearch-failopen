            mapperService = createMapperService(getMapping());
        Settings settings = Settings.builder()
    abstract XContentBuilder getMapping() throws IOException;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            throw new RuntimeException(e);  
import org.opensearch.common.xcontent.XContentFactory;
    public static XContentBuilder topMapping(CheckedConsumer<XContentBuilder, IOException> buildFields) throws IOException {  
        try {  
        IndexMetadata indexMetadata = IndexMetadata.builder("test").settings(settings).putMapping(builder.toString()).build();  
            settings,
    }
 */  
import org.apache.lucene.tests.index.BaseDocValuesFormatTestCase;
package org.opensearch.index.codec.composite912.datacube.startree;
    }
import org.opensearch.Version;  
import org.opensearch.index.MapperTestUtils;
        List<Object[]> parameters = new ArrayList<>();  
        mapperService.close();
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
}  
 *
            .build();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.core.common.unit.ByteSizeValue;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
import org.apache.lucene.tests.util.LuceneTestCase;
 * Abstract star tree doc values Lucene tests
        MapperService mapperService = MapperTestUtils.newMapperServiceWithHelperAnalyzer(
        IndicesModule indicesModule = new IndicesModule(Collections.emptyList());
import java.util.Collections;
/**
        parameters.add(new Object[] { StarTreeFieldConfiguration.StarTreeBuildMode.OFF_HEAP });
import org.opensearch.cluster.metadata.IndexMetadata;
    protected Codec getCodec() {  
 * The OpenSearch Contributors require contributions made to  
    }
/*  
import org.junit.After;
        Codec codec = new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)  
import java.util.Collection;  
import java.util.ArrayList;
            .put(StarTreeIndexSettings.IS_COMPOSITE_INDEX_SETTING.getKey(), true)
public abstract class AbstractStarTreeDVFormatTests extends BaseDocValuesFormatTestCase {
import org.opensearch.core.xcontent.NamedXContentRegistry;
            "test"
    StarTreeFieldConfiguration.StarTreeBuildMode buildMode;
        } catch (IOException e) {
import org.apache.lucene.codecs.Codec;
            .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(512, ByteSizeUnit.MB))
        this.buildMode = buildMode;
import java.io.IOException;
import org.opensearch.core.xcontent.XContentBuilder;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.mapper.MapperService;  
 */  
    @After  
        return parameters;  
        );
    @ParametersFactory
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import org.opensearch.index.IndexSettings;
            createTempDir(),
import org.opensearch.common.settings.Settings;
        return codec;  
 * compatible open source license.
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().startObject("_doc");
    }  
import org.apache.logging.log4j.Logger;
        return builder.endObject().endObject();  
    MapperService mapperService = null;  
            indicesModule,  
    public void teardown() throws IOException {
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;
import org.opensearch.index.codec.composite.composite104.Composite104Codec;  
import org.apache.lucene.codecs.lucene104.Lucene104Codec;  
    public static MapperService createMapperService(XContentBuilder builder) throws IOException {  
        parameters.add(new Object[] { StarTreeFieldConfiguration.StarTreeBuildMode.ON_HEAP });
        final Logger testLogger = LogManager.getLogger(StarTreeDocValuesFormatTests.class);
        }
        return mapperService;
@LuceneTestCase.SuppressSysoutChecks(bugUrl = "we log a lot on purpose")
import org.opensearch.cluster.ClusterModule;
    public static Collection<Object[]> parameters() {
            new NamedXContentRegistry(ClusterModule.getNamedXWriteables()),  
    }
    @Override
import org.opensearch.indices.IndicesModule;
import org.opensearch.common.CheckedConsumer;  
import org.opensearch.core.common.unit.ByteSizeUnit;  
        mapperService.merge(indexMetadata, MapperService.MergeReason.INDEX_TEMPLATE);  
        buildFields.accept(builder);
    public AbstractStarTreeDVFormatTests(StarTreeFieldConfiguration.StarTreeBuildMode buildMode) {  
import org.apache.logging.log4j.LogManager;  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    }
