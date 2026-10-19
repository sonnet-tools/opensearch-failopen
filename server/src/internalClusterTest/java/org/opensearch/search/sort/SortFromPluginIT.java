 * SPDX-License-Identifier: Apache-2.0
                    )
                        JsonXContent.jsonXContent,  
        searchResponse = client().prepareSearch("test")
                        new SearchSourceBuilder().sort(new CustomSortBuilder("field", SortOrder.ASC)).toString()
        searchResponse = client().prepareSearch("test").addSort(new CustomSortBuilder("field", SortOrder.DESC)).get();
                        JsonXContent.jsonXContent,  
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));
        client().prepareIndex("test").setId("3").setSource("field", 0).get();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        ensureGreen();  
        client().prepareIndex("test").setId("1").setSource("field", 2).get();
                )  
                        new SearchSourceBuilder().sort(new CustomSortBuilder("field", SortOrder.DESC)).toString()
import org.opensearch.action.search.SearchResponse;  
import org.opensearch.search.builder.SearchSourceBuilder;
    }  
                    createParser(
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("3"));
 *
import org.opensearch.common.xcontent.json.JsonXContent;
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));
    }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        ensureGreen();
        createIndex("test");
 * compatible open source license.
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));
        refresh();  
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("3"));  
                    )
                SearchSourceBuilder.fromXContent(
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("3"));
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));
}
    }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
        );
    public static Collection<Object[]> parameters() {
import static org.hamcrest.Matchers.equalTo;
    }  
        return Arrays.asList(CustomSortPlugin.class, InternalSettingsPlugin.class);
        createIndex("test");  
    @Override
import java.util.Arrays;
    public SortFromPluginIT(Settings settings) {
                    createParser(
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("1"));  
    @ParametersFactory  
        client().prepareIndex("test").setId("3").setSource("field", 0).get();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));  
package org.opensearch.search.sort;
        client().prepareIndex("test").setId("1").setSource("field", 2).get();  
        super(settings);  
public class SortFromPluginIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        client().prepareIndex("test").setId("2").setSource("field", 1).get();  
        return Arrays.asList(
        assertThat(searchResponse.getHits().getAt(2).getId(), equalTo("1"));  
import org.opensearch.search.sort.plugin.CustomSortBuilder;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        client().prepareIndex("test").setId("2").setSource("field", 1).get();
import org.opensearch.search.sort.plugin.CustomSortPlugin;  
                SearchSourceBuilder.fromXContent(
    }
        // builder -> json -> builder
                )  
            )
            .get();
            )
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        indexRandomForConcurrentSearch("test");
        SearchResponse searchResponse = client().prepareSearch("test").addSort(new CustomSortBuilder("field", SortOrder.ASC)).get();  
        assertThat(searchResponse.getHits().getAt(1).getId(), equalTo("2"));
import org.opensearch.plugins.Plugin;  
/*  
    public void testPluginSortXContent() throws Exception {
            .setSource(  
            .get();
    public void testPluginSort() throws Exception {
        SearchResponse searchResponse = client().prepareSearch("test")
            .setSource(  
import java.util.Collection;
        refresh();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import org.opensearch.test.InternalSettingsPlugin;
 */  
        indexRandomForConcurrentSearch("test");
 * The OpenSearch Contributors require contributions made to  
