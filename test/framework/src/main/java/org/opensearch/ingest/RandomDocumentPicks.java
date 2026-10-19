     */
        int numLevels = RandomNumbers.randomIntBetween(random, 1, 5);
                return stringList;
        addRandomFields(random, document, 0);
        return fieldName.toString();
 * under the License.
        }
    /**
    /**
 * Licensed to Elasticsearch under one or more contributor
    /**
     */
     */
                }
        assert ingestDocument.getFieldValue(key, Object.class) != null;
        String key = randomEntry.getKey();
            case 1:
                List<Boolean> booleanList = new ArrayList<>();
import java.util.ArrayList;
                return random.nextDouble();
                return randomString(random);
        }
     */
package org.opensearch.ingest;
    }
        return randomLong == Long.MIN_VALUE ? 0 : Math.abs(randomLong);
     * with the provided value. The field will be added at a random position within the document,
 * specific language governing permissions and limitations
        }
                addRandomFields(random, newNode, ++currentDepth);
    public static String randomLeafFieldName(Random random) {
 * GitHub history for details.
        String fieldName;
 *
/*
        }
    /**
    }
                if (currentLevel instanceof Map == false) {
            case 6:
     * When the provided field name holds the path using the dot notation, we have to make sure
        // Never generates a dot:
                List<String> stringList = new ArrayList<>();
            default:
     * Adds a random non existing field to the provided document and associates it
    }
import java.util.TreeMap;
        }
    }
        }
                @SuppressWarnings("unchecked")
public final class RandomDocumentPicks {
    }
            fieldName.append(randomString(random));
 * software distributed under the License is distributed on an
            if (i > 0) {
            case 4:
                    booleanList.add(random.nextBoolean());
            fieldName.append('.');
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Object> innerMap = ingestDocument.getSourceAndMetadata();
        String leafKey = pathElements[pathElements.length - 1];
                }
    }
            fieldName = randomFieldName(random);
            case 2:
     * Generates a document that holds random metadata and the document provided as a map argument
import java.util.Map;
                List<Integer> intList = new ArrayList<>();
    public static IngestDocument randomIngestDocument(Random random, Map<String, Object> source) {
                for (int j = 0; j < numIntItems; j++) {
        long randomLong = random.nextLong();
        ingestDocument.setFieldValue(fieldName, value);
                int numBooleanItems = RandomNumbers.randomIntBetween(random, 1, 10);
    private static Object randomFieldValue(Random random, int currentDepth) {
                return random.nextBoolean();
import java.util.HashMap;
    private static Long randomNonNegtiveLong(Random random) {
                for (int j = 0; j < numStringItems; j++) {
            case 9:
    public static IngestDocument randomIngestDocument(Random random) {
        fieldName.append(randomLeafFieldName(random));
/*
    }
                return booleanList;
 * ownership. Elasticsearch licenses this file to you under
 */
/*
        } while (canAddField(fieldName, ingestDocument) == false);
     * Checks whether the provided field name can be safely added to the provided document.
     * Generates a random document and random metadata
    }
            Object fieldValue = randomFieldValue(random, currentDepth);
    private RandomDocumentPicks() {
            return;
                byte[] byteArray = new byte[RandomNumbers.randomIntBetween(random, 1, 1024)];
        return RandomStrings.randomUnicodeOfCodepointLengthBetween(random, 1, 10);
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
                fieldName.append('.');
                int numIntItems = RandomNumbers.randomIntBetween(random, 1, 10);
        return new IngestDocument(index, id, routing, version, versionType, source);
                Object currentLevel = innerMap.get(pathElements[i]);
        return document;
    }
                random.nextBytes(byteArray);
    public static String addRandomField(Random random, IngestDocument ingestDocument, Object value) {
     */
        for (int i = 0; i < numFields; i++) {
}
        }
            case 7:
 * the Apache License, Version 2.0 (the "License"); you may
            }
            Map<String, Object> treeMap = new TreeMap<>(map);
     * not necessarily at the top level using a leaf field name.
        } while (canAddField(fieldName, ingestDocument) == false);
        StringBuilder fieldName = new StringBuilder();
 * Unless required by applicable law or agreed to in writing,
            new VersionType[] { VersionType.INTERNAL, VersionType.EXTERNAL, VersionType.EXTERNAL_GTE }
     * in the document provided as an argument.
        Long version = randomNonNegtiveLong(random);
    public static Map<String, Object> randomSource(Random random) {
            case 8:
     * Generates a random field value, can be a string, a number, a list of an object itself.
                return doubleList;
    public static boolean canAddField(String path, IngestDocument ingestDocument) {
 * compatible open source license.
                Map<String, Object> map = (Map<String, Object>) currentLevel;
    public static String randomExistingFieldName(Random random, IngestDocument ingestDocument) {
        return randomIngestDocument(random, randomSource(random));
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                Map<String, Object> newNode = new HashMap<>();
            random,
 * Modifications Copyright OpenSearch Contributors. See
                List<Double> doubleList = new ArrayList<>();
        );
        do {
     */
     * that each node of the tree either doesn't exist or is a map, otherwise new fields cannot be added.
        for (int i = 0; i < numLevels - 1; i++) {
 * You may obtain a copy of the License at
            Map<String, Object> map = (Map<String, Object>) randomEntry.getValue();
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
        while (randomEntry.getValue() instanceof Map) {
            case 5:
     * path to refer to a field name using the dot notation.
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to
     */
        Map<String, Object> document = new HashMap<>();
        return randomFieldValue(random, 0);
 */
            return RandomStrings.randomAsciiOfLengthBetween(random, 1, 10);
     * Returns a randomly selected existing field name out of the fields that are contained
    public static String randomFieldName(Random random) {
        return fieldName;
                for (int j = 0; j < numDoubleItems; j++) {
     * Returns a random field name. Can be a leaf field name or the
                }
            routing = randomString(random);
            for (int i = 0; i < pathElements.length - 1; i++) {
    /**
        if (pathElements.length > 1) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            }
        String[] pathElements = path.split("\\.");
        int numFields = RandomNumbers.randomIntBetween(random, 1, 10);
     */
                innerMap = map;
        String id = randomString(random);
                    intList.add(random.nextInt());
    }
import java.util.List;
                for (int j = 0; j < numBooleanItems; j++) {
 * license agreements. See the NOTICE file distributed with
        String routing = null;
    }
    /**
                int numStringItems = RandomNumbers.randomIntBetween(random, 1, 10);
import java.util.Random;
        return innerMap.containsKey(leafKey) == false;
                return byteArray;
        if (numLevels > 1) {
        if (random.nextBoolean()) {
 *
                    stringList.add(randomString(random));
            key += "." + randomEntry.getKey();
                if (currentLevel == null) {
    private static void addRandomFields(Random random, Map<String, Object> parentNode, int currentDepth) {
            parentNode.put(fieldName, fieldValue);
                }
        do {
 *
        }
    public static Object randomFieldValue(Random random) {
        return fieldName;
                    doubleList.add(random.nextDouble());
                    return false;
        String index = randomString(random);
                throw new UnsupportedOperationException();
        switch (RandomNumbers.randomIntBetween(random, 0, 9)) {
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
    public static String randomString(Random random) {
        Map<String, Object> source = new TreeMap<>(ingestDocument.getSourceAndMetadata());
        if (random.nextBoolean()) {
import org.opensearch.index.VersionType;
        }
     * Returns a random leaf field name.
            case 0:
            case 3:
        return RandomStrings.randomAsciiAlphanumOfLengthBetween(random, 1, 10);
        String fieldName;
                    return true;
                int numDoubleItems = RandomNumbers.randomIntBetween(random, 1, 10);
 * not use this file except in compliance with the License.
                return random.nextInt();
 * KIND, either express or implied.  See the License for the
    public static String randomNonExistingFieldName(Random random, IngestDocument ingestDocument) {
                return newNode;
            String fieldName = randomLeafFieldName(random);
        Map.Entry<String, Object> randomEntry = RandomPicks.randomFrom(random, source.entrySet());
    }
    /**
     * Returns a random field name that doesn't exist in the document.
        return key;
        if (currentDepth > 5) {
    /**
                }
                }
    /**
            randomEntry = RandomPicks.randomFrom(random, treeMap.entrySet());
            @SuppressWarnings("unchecked")
 */
        VersionType versionType = RandomPicks.randomFrom(
            fieldName = randomFieldName(random);
    }
    }
                return intList;
