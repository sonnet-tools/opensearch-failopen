                index,
            ensureGreen(index);
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;
                .actionGet()
                    .build()
        "default",
            final int expectedResponseSize = codecMap.size() * nbDocs;  
            randomBoolean(),
import java.util.Map;
                    .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
            assertEquals(0, response.getNoops());  
                .get(index)  
            for (String codec : codecMap.keySet()) {
            assertEquals(expectedResponseSize, response.getCreated());
    final static String[] codecChoices = codecMap.keySet().toArray(String[]::new);
import java.util.stream.Collectors;
    );  
                .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            final String index = "test-index-" + destCodec;  
            ensureGreen(destIndex);
            // create destination index with destination codec
            assertTrue(  
import org.opensearch.test.InternalSettingsPlugin;  
import java.util.Collection;  
                destIndex,  
    private void useCodec(String index, String codec) throws ExecutionException, InterruptedException {  
            // assertions
            );
            assertEquals(expectedResponseSize, response.getTotal());
            assertEquals(0, response.getBulkFailures().size());
    }  
                    .containsAll(codecMap.values())
            randomBoolean(),  
public class MultiCodecReindexTests extends ReindexTestCase {
        "zlib",  
            final int nbDocs = randomIntBetween(2, 5);
import org.opensearch.index.engine.Segment;
        "BEST_COMPRESSION",
        "BEST_SPEED"
import org.opensearch.common.settings.Settings;
                    .put("index.codec", randomFrom(codecChoices))  
                .getShards()
                    .flatMap(s -> s.getAttributes().values().stream())
package org.opensearch.index.reindex;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.Plugin;
                .segments(new IndicesSegmentsRequest(index))  
                .get()
        return List.of(InternalSettingsPlugin.class, ReindexModulePlugin.class);
    }
                .updateSettings(new UpdateSettingsRequest(index).settings(Settings.builder().put("index.codec", codec)))  
    }
        "BEST_SPEED",  
                .destination(destIndex)
        "BEST_COMPRESSION",
    private void ingestDocs(String index, int nbDocs) throws InterruptedException {
}  
            );  
                getSegments(index).stream()
 *
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .get(0)
                .waitForActiveShards(ActiveShardCount.ONE)
            // index using all codecs  
            assertEquals(0, response.getDeleted());
    private ArrayList<Segment> getSegments(String index) {
            assertTrue(response.getTook().getMillis() > 0);
            assertEquals(1, response.getBatches());
import java.util.ArrayList;
        flushAndRefresh(index);
                .indices()
import org.opensearch.index.MergePolicyProvider;  
        "lz4",
        }  
                ingestDocs(index, nbDocs);  
        );  
                .indices()
 */  
    }  
            assertTrue(getSegments(destIndex).stream().allMatch(segment -> segment.attributes.containsValue(destCodecMode)));
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
        indexRandom(
                .refresh(true)  
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
            BulkByScrollResponse response = reindex().source(index)
                Settings.builder()  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            }
import java.util.UUID;  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
import static java.util.stream.Collectors.toList;
            // perform reindex  
        return new ArrayList<>(  
import java.util.concurrent.ExecutionException;
    public void testReindexingMultipleCodecs() throws InterruptedException, ExecutionException {
                    .put("index.codec", destCodec)
            false,
        "best_compression",
                useCodec(index, codec);
            client().admin()
            IntStream.range(0, nbDocs)  
        for (Map.Entry<String, String> candidate : codecMap.entrySet()) {  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        );
import org.opensearch.action.support.ActiveShardCount;  
                .getIndices()
        assertAcked(  
                    .collect(Collectors.toSet())  
import org.opensearch.cluster.metadata.IndexMetadata;
            final String destCodecMode = candidate.getValue();
 * compatible open source license.
                .getShards()[0].getSegments()  
                .collect(toList())
            createIndex(
                Settings.builder()
            final String destIndex = "dest-index-" + destCodec;
            createIndex(
import java.util.List;
            // create source index  
/*  
                    .build()
 * The OpenSearch Contributors require contributions made to  
                .mapToObj(i -> client().prepareIndex(index).setId(UUID.randomUUID().toString()).setSource("num", i))
            assertEquals(0, response.getSearchFailures().size());
        );
    final static Map<String, String> codecMap = Map.of(  
import java.util.stream.IntStream;  
        assertAcked(client().admin().indices().prepareClose(index).setWaitForActiveShards(1));
        assertAcked(client().admin().indices().prepareOpen(index).setWaitForActiveShards(1));
            );  
            assertEquals(0, response.getVersionConflicts());  
            final String destCodec = candidate.getKey();  
            client().admin()
