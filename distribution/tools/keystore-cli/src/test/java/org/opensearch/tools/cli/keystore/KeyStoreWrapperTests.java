        try (InputStream fileInput = keystore.getFile("file_setting")) {
}
            for (int i = 0; i < 256; ++i) {
import java.io.InputStream;
            output.writeByte((byte) 0); // hasPassword = false
    }
            byte[] iv = new byte[12];
import java.security.NoSuchAlgorithmException;
        assertThat(afterSave.getString("file_setting"), equalTo("file_value"));
        try (IndexOutput indexOutput = directory.createOutput("opensearch.keystore", IOContext.DEFAULT)) {
            output.writeByte((byte) 0); // hasPassword = false
    }
        }
    }
        Path configDir = env.configDir();
 * SPDX-License-Identifier: Apache-2.0
        assertThat(e.getMessage(), containsString("Keystore has been corrupted or tampered with"));
        KeyStoreWrapper keystore = KeyStoreWrapper.load(configDir);
            keystore.load(null, null);
    public void testFailWhenCannotConsumeSecretStream() throws Exception {
            keystore.store(keystoreBytesStream, new char[0]);
 *
        keystore.save(env.configDir(), getPassword());
import javax.crypto.SecretKeyFactory;
        byte[] salt,
import java.io.DataOutputStream;
        KeyStoreWrapper keystore = KeyStoreWrapper.load(configDir);
            indexOutput.writeByte((byte) 0); // No password
import static org.hamcrest.Matchers.anyOf;
            )
            possiblyAlterSecretString(output, 0);
    }
            }
            cipherStream.close();
 * this work for additional information regarding copyright
    public void testBackcompatV2() throws Exception {
            SecureRandom random = Randomness.createSecure();
        }
    }
    }
        KeyStoreWrapper keystore = KeyStoreWrapper.create();
import java.security.KeyStoreException;
            final byte[] encryptedBytes = bytes.toByteArray();
import static org.hamcrest.Matchers.equalTo;
        SecurityException e = expectThrows(SecurityException.class, () -> keystore.decrypt(getPassword()));
        assertNotNull(seed);
        try (IndexOutput output = EndiannessReverserUtil.createOutput(directory, "opensearch.keystore", IOContext.DEFAULT)) {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            SecureRandom random = Randomness.createSecure();
        }
import javax.crypto.spec.PBEKeySpec;
 * GitHub history for details.
            keystore.load(null, null);
    }
    public void testFailWhenEncryptedBytesStreamIsNotConsumed() throws Exception {
        keystore.decrypt(getPassword());
        Path configDir = env.configDir();
            random.nextBytes(iv);
            assertEquals(-1, stream.read()); // nothing left
    protected byte[] generateV2() throws Exception {
    public void testBackcompatV1() throws Exception {
 *
    public void testStringAndFileDistinction() throws Exception {
 * Unless required by applicable law or agreed to in writing,
        );
        assertThat(afterSave.getString("string_setting"), equalTo("string_value"));
            // Indicate that the secret string is longer than it is so readFully() fails
        random().nextBytes(fileBytes);
        final KeyStoreWrapper keystore = KeyStoreWrapper.create();
            byte[] iv = new byte[12];
    private CipherOutputStream getCipherStream(ByteArrayOutputStream bytes, byte[] salt, byte[] iv) throws Exception {
            keystore.setEntry("file_setting", new KeyStore.SecretKeyEntry(secretKey), protectionParameter);
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> KeyStoreWrapper.validateSettingName("*"));
 * license agreements. See the NOTICE file distributed with
        io.writeInt(salt.length);
            keystore.store(keystoreBytesStream, new char[0]);
public class KeyStoreWrapperTests extends OpenSearchTestCase {
        io.writeBytes(iv, iv.length);
            }
        NIOFSDirectory directory = new NIOFSDirectory(configDir);
            DataOutputStream output = new DataOutputStream(cipherStream);
/*
            CodecUtil.writeFooter(indexOutput);
    public void testFileSettingExhaustiveBytes() throws Exception {
    public void testFailWhenCannotConsumeEncryptedBytesStream() throws Exception {
            CodecUtil.writeHeader(indexOutput, "opensearch.keystore", 3);
        }
        assertThat(keystore.getSHA256Digest(stringSettingKeyName), equalTo(stringSettingHash));
    private void possiblyAlterEncryptedBytes(
    ) throws Exception {
    }
        Path configDir = env.configDir();
        try (InputStream stream = keystore.getFile("foo")) {
        keystore.setFile("foo", bytes);
                assertThat("byte " + i, readBytes[i], equalTo(fileBytes[i]));
        KeyStoreWrapper.upgrade(keystore, env.configDir(), getPassword());
 *    http://www.apache.org/licenses/LICENSE-2.0
        keystore.save(env.configDir(), getPassword());
import org.apache.lucene.store.IOContext;
        assertThat(keystore.getSettingNames(), Matchers.hasItem(KeyStoreWrapper.SEED_SETTING.getKey()));
            CodecUtil.writeHeader(indexOutput, "opensearch.keystore", 3);
        assertThat(
        output.writeUTF("string_setting");
    }
            CipherOutputStream cipherStream = getCipherStream(bytes, salt, iv);
    protected void generateV1() throws IOException, NoSuchAlgorithmException, NoSuchProviderException, CertificateException,
                containsString("Keystore has been corrupted or tampered with")
    }
    public void testIllegalSettingName() throws Exception {
    Environment env;
                    fail("Expected 256 bytes but read " + i);
            byte[] salt = new byte[64];
        byte[] iv,
            cipherStream.close();
import java.nio.file.FileSystem;
        // upgrade does not overwrite seed
        final String stringSettingKeyName = randomAlphaOfLength(5).toLowerCase(Locale.ROOT) + "1";
        e = expectThrows(IllegalArgumentException.class, () -> keystore.setFile("*", new byte[0]));
        keystore.decrypt(getPassword());
    private byte[] toByteArray(final InputStream is) throws IOException {
            SecretKeyFactory secretFactory = SecretKeyFactory.getInstance("PBE", "SunJCE");
        output.write(secret_value);
        NIOFSDirectory directory = new NIOFSDirectory(configDir);
 * the Apache License, Version 2.0 (the "License"); you may
                int got = stream.read();
        Path configDir = env.configDir();
import java.util.Base64;
            DataOutputStream output = new DataOutputStream(cipherStream);
        keystore.close();
            KeyStore keystore = KeyStore.getInstance("PKCS12", "SUN");
 * KIND, either express or implied.  See the License for the
    public void closeMockFileSystems() throws IOException {
            possiblyAlterSecretString(output, 4);
        assertThat(keystore.getSHA256Digest(stringSettingKeyName), equalTo(stringSettingHash));
        final KeyStoreWrapper loadedKeystore = KeyStoreWrapper.load(env.configDir());
        assertThat(e.getCause(), instanceOf(EOFException.class));
import javax.crypto.spec.GCMParameterSpec;
        byte[] encryptedBytes,
    }
            output.writeString("file_setting");
            random.nextBytes(iv);
 * not use this file except in compliance with the License.
    }
            indexOutput.writeByte((byte) 0); // No password
/*
        try (IndexOutput indexOutput = directory.createOutput("opensearch.keystore", IOContext.DEFAULT)) {
        KeyStoreWrapper keystore = KeyStoreWrapper.create();
        assertTrue(e.getMessage().contains("does not match the allowed setting name pattern"));
            final byte[] encryptedBytes = bytes.toByteArray();
    public void testDecryptKeyStoreWithWrongPassword() throws Exception {
            possiblyAlterEncryptedBytes(indexOutput, salt, iv, encryptedBytes, 0);
import javax.crypto.spec.SecretKeySpec;
        keystore.setFile(fileSettingKeyName, fileSettingValue);
        NIOFSDirectory directory = new NIOFSDirectory(configDir);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
    protected char[] getPassword() {
            output.writeString("PKCS12");
        assertNotNull(afterSave);
        e = expectThrows(IllegalArgumentException.class, () -> keystore.setString("*", new char[0]));
import static org.hamcrest.Matchers.notNullValue;
                containsString("Provided keystore password was incorrect"),
            CodecUtil.writeFooter(indexOutput);
        cipher.init(Cipher.ENCRYPT_MODE, secret, spec);
            SecureRandom random = Randomness.createSecure();
        byte[] fileBytes = generateV2();
            output.writeString("FILE");
 * The OpenSearch Contributors require contributions made to
            CodecUtil.writeFooter(output);
        assertEquals(seed.toString(), keystore.getString(KeyStoreWrapper.SEED_SETTING.getKey()).toString());
            possiblyAlterEncryptedBytes(indexOutput, salt, iv, encryptedBytes, -12);
import java.security.NoSuchProviderException;
            // Indicate that the encryptedBytes is larger than it is so readFully() fails
 * Licensed to Elasticsearch under one or more contributor
            output.writeString("PBE");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        GCMParameterSpec spec = new GCMParameterSpec(128, iv);
        KeyStoreWrapper keystore = KeyStoreWrapper.create();
            byte[] iv = new byte[12];
        return fileBytes;
            for (int i = 0; i < fileBytes.length; ++i) {
        assertTrue(e.getMessage().contains("does not match the allowed setting name pattern"));
        final String fileSettingKeyName = randomAlphaOfLength(5).toLowerCase(Locale.ROOT) + "2";
 * software distributed under the License is distributed on an
import java.util.ArrayList;
            // So that readFully during decryption will not consume the entire stream
        byte[] fileBytes = new byte[20];
    }
        assertEquals(seed.toString(), keystore.getString(KeyStoreWrapper.SEED_SETTING.getKey()).toString());
    public void testCreate() throws Exception {
            char[] chars = new char[base64Bytes.length];
    }
import org.hamcrest.Matchers;
    }
        DataOutput io = EndiannessReverserUtil.wrapDataOutput(indexOutput);
import java.util.HashSet;
    public void testCannotReadStringFromClosedKeystore() throws Exception {
            output.writeString("PBE"); // file algo
        }
import java.nio.file.Path;
        keystore = KeyStoreWrapper.load(env.configDir());
    }
        final byte[] stringSettingHash = MessageDigest.getInstance("SHA-256").digest(stringSettingValue.getBytes(StandardCharsets.UTF_8));
            output.writeInt(keystoreBytes.length);
import java.util.List;
        return new char[0];
        io.writeBytes(salt, salt.length);
        keystore.setString(stringSettingKeyName, stringSettingValue.toCharArray());
        assertThat(testValue.toString(), equalTo("stringSecretValue"));
            output.writeVInt(2); // num settings
import javax.crypto.SecretKey;
        keystore.save(env.configDir(), getPassword());
        SecureString seed = keystore.getString(KeyStoreWrapper.SEED_SETTING.getKey());
            CodecUtil.writeHeader(indexOutput, "opensearch.keystore", 3);
 *
            byte[] keystoreBytes = keystoreBytesStream.toByteArray();
        }
    }
        IndexOutput indexOutput,
        final byte[] fileSettingHash = MessageDigest.getInstance("SHA-256").digest(fileSettingValue);
        SecurityException e = expectThrows(SecurityException.class, () -> keystore.decrypt(getPassword()));
package org.opensearch.tools.cli.keystore;
import org.junit.Before;
        wrapper.setFile("file_setting", Files.readAllBytes(temp.resolve("file_setting")));
import org.opensearch.common.Randomness;
import org.apache.lucene.backward_codecs.store.EndiannessReverserUtil;
        return new CipherOutputStream(bytes, cipher);
            byte[] iv = new byte[12];
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            possiblyAlterEncryptedBytes(indexOutput, salt, iv, encryptedBytes, 0);
        final String stringSettingValue = randomAlphaOfLength(32);
import javax.crypto.Cipher;
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
import static org.hamcrest.Matchers.instanceOf;
        byte[] bytes = new byte[256];
        SecureString seed = keystore.getString(KeyStoreWrapper.SEED_SETTING.getKey());
        keystore = KeyStoreWrapper.load(env.configDir());
            anyOf(
            final byte[] encryptedBytes = bytes.toByteArray();
            CodecUtil.writeHeader(output, "opensearch.keystore", 1);
 */
            KeyStore.ProtectionParameter protectionParameter = new KeyStore.PasswordProtection(new char[0]);
            possiblyAlterEncryptedBytes(indexOutput, salt, iv, encryptedBytes, randomIntBetween(2, encryptedBytes.length));
        output.writeInt(secret_value.length - truncLength);
import org.opensearch.env.Environment;
            CipherOutputStream cipherStream = getCipherStream(bytes, salt, iv);
        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        assertTrue(keystore.getSettingNames().contains(KeyStoreWrapper.SEED_SETTING.getKey()));
        // value hashes accessible even when the keystore is closed
                chars[i] = (char) base64Bytes[i]; // PBE only stores the lower 8 bits, so this narrowing is ok
        SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
        final byte[] buffer = new byte[1024];
            secretKey = secretFactory.generateSecret(new PBEKeySpec(chars));
        final SecurityException exception = expectThrows(
        while ((readBytes = is.read(buffer)) > 0) {
        env = KeyStoreCommandTestCase.setupEnv(true, fileSystems);
    public void testUpgradeAddsSeed() throws Exception {
            assertEquals(-1, fileInput.read());
        generateV1();
            DataOutputStream output = new DataOutputStream(cipherStream);
            random.nextBytes(salt);
import java.security.cert.CertificateException;
            keystore.setEntry("string_setting", new KeyStore.SecretKeyEntry(secretKey), protectionParameter);
        KeyStoreWrapper keystore = KeyStoreWrapper.create();
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    }
import org.opensearch.test.OpenSearchTestCase;
            indexOutput.writeByte((byte) 0); // No password
        KeyStoreWrapper keystore = KeyStoreWrapper.load(configDir);
/*
            byte[] salt = new byte[64];
        SecurityException e = expectThrows(SecurityException.class, () -> keystore.decrypt(new char[0]));
        }
            CipherOutputStream cipherStream = getCipherStream(bytes, salt, iv);
                if (got < 0) {
        }
        SecureString testValue = keystore.getString("string_setting");
            final byte[] encryptedBytes = bytes.toByteArray();
import java.util.Arrays;
            output.writeInt(keystoreBytes.length);
            CodecUtil.writeFooter(indexOutput);
        cipher.updateAAD(salt);
            DataOutputStream output = new DataOutputStream(cipherStream);
            possiblyAlterSecretString(output, 0);
        keystore = KeyStoreWrapper.load(env.configDir());
        wrapper.setString("string_setting", "string_value".toCharArray());
    public void testValueSHA256Digest() throws Exception {
import org.junit.After;
        assertThat(testValue.toString(), equalTo("stringSecretValue"));
        io.writeInt(iv.length);
            random.nextBytes(salt);
    @After
            byte[] readBytes = new byte[20];
import static org.hamcrest.Matchers.containsString;
                assertEquals(i, got);
 */
import java.io.ByteArrayOutputStream;
    private void possiblyAlterSecretString(DataOutputStream output, int truncLength) throws Exception {
            output.writeString("STRING");
        io.writeInt(4 + salt.length + 4 + iv.length + 4 + encryptedBytes.length);
        assertTrue(e.getMessage().contains("does not match the allowed setting name pattern"));
        KeyStoreWrapper keystore = KeyStoreWrapper.create();
        assertThat(exception.getMessage(), containsString("closed"));
        assertThat(e.getMessage(), containsString("Keystore has been corrupted or tampered with"));
    public void testUpgradeNoop() throws Exception {
            output.writeBytes(keystoreBytes, keystoreBytes.length);
        Path configDir = env.configDir();
            KeyStore.ProtectionParameter protectionParameter = new KeyStore.PasswordProtection(new char[0]);
    }
        assertThat(afterSave.getSettingNames(), equalTo(new HashSet<>(Arrays.asList("keystore.seed", "string_setting", "file_setting"))));
 * specific language governing permissions and limitations
            byte[] base64Bytes = Base64.getEncoder().encode(fileBytes);
import java.io.IOException;
            () -> loadedKeystore.decrypt("wrong_password_<1234567890%&!\"/>_but_a_strong_one".toCharArray())
        KeyStoreWrapper keystore = KeyStoreWrapper.create();
        IOUtils.close(fileSystems);
            random.nextBytes(iv);
            exception.getMessage(),
 * Modifications Copyright OpenSearch Contributors. See
        KeyStoreWrapper keystore = KeyStoreWrapper.load(configDir);
            cipherStream.close();
        int truncEncryptedDataLength
            keystore.setEntry("string_setting", new KeyStore.SecretKeyEntry(secretKey), protectionParameter);
        assertThat(keystore.getSHA256Digest(fileSettingKeyName), equalTo(fileSettingHash));
        assertThat(toByteArray(afterSave.getFile("file_setting")), equalTo("file_value".getBytes(StandardCharsets.UTF_8)));
            }
            random.nextBytes(iv);
        assertEquals(seed.toString(), keystore.getString(KeyStoreWrapper.SEED_SETTING.getKey()).toString());
            byte[] salt = new byte[64];
    @Before
            byte[] keystoreBytes = keystoreBytesStream.toByteArray();
        output.writeInt(1); // One entry
        keystore.remove(KeyStoreWrapper.SEED_SETTING.getKey());
        wrapper.close();
        );
        final KeyStoreWrapper afterSave = KeyStoreWrapper.load(env.configDir());
    List<FileSystem> fileSystems = new ArrayList<>();
            indexOutput.writeByte((byte) 0); // No password
        assertThat(e.getCause(), instanceOf(EOFException.class));
import org.apache.lucene.store.IndexOutput;
        NIOFSDirectory directory = new NIOFSDirectory(configDir);
        assertThat(e.getMessage(), containsString("Keystore has been corrupted or tampered with"));
        Path configDir = env.configDir();
import org.opensearch.common.settings.KeyStoreWrapper;
        }
        keystore.save(env.configDir(), getPassword());
 * ownership. Elasticsearch licenses this file to you under
        keystore.decrypt(getPassword());
            for (int i = 0; i < chars.length; ++i) {
        Path configDir = env.configDir();
                }
        keystore.close();
        for (int i = 0; i < 256; ++i) {
            bytes[i] = (byte) i;
 * under the License.
        try (IndexOutput output = EndiannessReverserUtil.createOutput(directory, "opensearch.keystore", IOContext.DEFAULT)) {
            output.writeBytes(keystoreBytes, keystoreBytes.length);
        assertThat(keystore.getString(KeyStoreWrapper.SEED_SETTING.getKey()), notNullValue());
            ByteArrayOutputStream keystoreBytesStream = new ByteArrayOutputStream();
        final KeyStoreWrapper wrapper = KeyStoreWrapper.create();
            os.write(buffer, 0, readBytes);
        Path configDir = env.configDir();
            SecretKey secretKey = secretFactory.generateSecret(new PBEKeySpec("stringSecretValue".toCharArray()));
        byte[] secret_value = "super_secret_value".getBytes(StandardCharsets.UTF_8);
            CodecUtil.writeFooter(output);
        InvalidKeySpecException, KeyStoreException {
    public void testFailWhenSecretStreamNotConsumed() throws Exception {
import org.opensearch.core.common.settings.SecureString;
            output.writeString("PBE"); // string algo
        final Path temp = createTempDir();
        keystore.decrypt(new char[0]);
import javax.crypto.CipherOutputStream;
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
        PBEKeySpec keySpec = new PBEKeySpec(getPassword(), salt, 10000, 128);
import org.apache.lucene.store.DataOutput;
        }
        KeyStoreWrapper keystore = KeyStoreWrapper.load(configDir);
    }
        assertThat(keystore.getSHA256Digest(fileSettingKeyName), equalTo(fileSettingHash));
        KeyStoreWrapper.upgrade(keystore, env.configDir(), new char[0]);
    }
        assertThat(e.getMessage(), containsString("Keystore has been corrupted or tampered with"));
            CodecUtil.writeHeader(output, "opensearch.keystore", 2);
            byte[] salt = new byte[64];
        wrapper.save(env.configDir(), getPassword());
        int readBytes;
        try (IndexOutput indexOutput = directory.createOutput("opensearch.keystore", IOContext.DEFAULT)) {
        keystore.decrypt(new char[0]);
import java.util.Locale;
        KeyStoreWrapper keystore = KeyStoreWrapper.create();
        KeyStoreWrapper keystore = KeyStoreWrapper.load(configDir);
        );
            output.writeString("string_setting");
    public void setupEnv() throws IOException {
import java.security.SecureRandom;
import org.apache.lucene.store.NIOFSDirectory;
        return os.toByteArray();
            SecretKey secretKey = secretFactory.generateSecret(new PBEKeySpec("stringSecretValue".toCharArray()));
        afterSave.decrypt(getPassword());
            SecureRandom random = Randomness.createSecure();
            output.writeString("PKCS12");
    }
import java.security.KeyStore;
import java.nio.file.Files;
import org.apache.lucene.codecs.CodecUtil;
            possiblyAlterSecretString(output, -4);
        io.writeBytes(encryptedBytes, encryptedBytes.length);
        io.writeInt(encryptedBytes.length - truncEncryptedDataLength);
        Files.write(temp.resolve("file_setting"), "file_value".getBytes(StandardCharsets.UTF_8));
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        SecurityException e = expectThrows(SecurityException.class, () -> keystore.decrypt(new char[0]));
import org.opensearch.common.util.io.IOUtils;
        final IllegalStateException exception = expectThrows(
        NIOFSDirectory directory = new NIOFSDirectory(configDir);
            SecurityException.class,
            random.nextBytes(salt);
            CodecUtil.writeHeader(indexOutput, "opensearch.keystore", 3);
            KeyStore keystore = KeyStore.getInstance("PKCS12", "SUN");
            () -> keystore.getString(KeyStoreWrapper.SEED_SETTING.getKey())
            CipherOutputStream cipherStream = getCipherStream(bytes, salt, iv);
import java.security.spec.InvalidKeySpecException;
            cipherStream.close();
import java.io.EOFException;
import java.nio.charset.StandardCharsets;
 * compatible open source license.
            assertEquals(20, fileInput.read(readBytes));
import java.security.MessageDigest;
 */
        final byte[] fileSettingValue = randomByteArrayOfLength(32);
            random.nextBytes(salt);
            SecretKeyFactory secretFactory = SecretKeyFactory.getInstance("PBE", "SunJCE");
        assertThat(keystore.getSettingNames(), Matchers.hasItem(KeyStoreWrapper.SEED_SETTING.getKey()));
        NIOFSDirectory directory = new NIOFSDirectory(configDir);
    }
            ByteArrayOutputStream keystoreBytesStream = new ByteArrayOutputStream();
        assertThat(toByteArray(afterSave.getFile("string_setting")), equalTo("string_value".getBytes(StandardCharsets.UTF_8)));
            CodecUtil.writeFooter(indexOutput);
        output.writeUTF("STRING");
 * You may obtain a copy of the License at
            IllegalStateException.class,
 * this file be licensed under the Apache-2.0 license or a
        SecureString testValue = keystore.getString("string_setting");
        try (IndexOutput indexOutput = directory.createOutput("opensearch.keystore", IOContext.DEFAULT)) {
