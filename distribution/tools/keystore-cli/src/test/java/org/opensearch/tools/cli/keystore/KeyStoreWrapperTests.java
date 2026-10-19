        Files.write(temp.resolve("file_setting"), "file_value".getBytes(StandardCharsets.UTF_8));
 * Licensed to Elasticsearch under one or more contributor  
        NIOFSDirectory directory = new NIOFSDirectory(configDir);  
        wrapper.setFile("file_setting", Files.readAllBytes(temp.resolve("file_setting")));
import org.apache.lucene.store.IndexOutput;
        assertThat(afterSave.getString("file_setting"), equalTo("file_value"));  
            byte[] salt = new byte[64];
import java.util.ArrayList;  
                chars[i] = (char) base64Bytes[i]; // PBE only stores the lower 8 bits, so this narrowing is ok
    }
    }  
        SecureString seed = keystore.getString(KeyStoreWrapper.SEED_SETTING.getKey());  
    public void testStringAndFileDistinction() throws Exception {  
        Path configDir = env.configDir();
    public void testIllegalSettingName() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.EOFException;  
            byte[] iv = new byte[12];
            KeyStore keystore = KeyStore.getInstance("PKCS12", "SUN");
        assertEquals(seed.toString(), keystore.getString(KeyStoreWrapper.SEED_SETTING.getKey()).toString());
        SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
            random.nextBytes(iv);
            secretKey = secretFactory.generateSecret(new PBEKeySpec(chars));
            byte[] iv = new byte[12];
        io.writeInt(iv.length);
                assertEquals(i, got);  
 * license agreements. See the NOTICE file distributed with
            SecureRandom random = Randomness.createSecure();
            random.nextBytes(iv);  
        NIOFSDirectory directory = new NIOFSDirectory(configDir);  
            CodecUtil.writeHeader(indexOutput, "opensearch.keystore", 3);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();  
            output.writeInt(keystoreBytes.length);
        assertThat(keystore.getString(KeyStoreWrapper.SEED_SETTING.getKey()), notNullValue());
        io.writeBytes(salt, salt.length);
        e = expectThrows(IllegalArgumentException.class, () -> keystore.setFile("*", new byte[0]));
    public void testUpgradeNoop() throws Exception {
        NIOFSDirectory directory = new NIOFSDirectory(configDir);
        return new char[0];
        assertThat(e.getMessage(), containsString("Keystore has been corrupted or tampered with"));
        );  
        );
        KeyStoreWrapper keystore = KeyStoreWrapper.create();  
        KeyStoreWrapper keystore = KeyStoreWrapper.load(configDir);  
            CodecUtil.writeFooter(output);
 *    http://www.apache.org/licenses/LICENSE-2.0
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();  
        try (IndexOutput output = EndiannessReverserUtil.createOutput(directory, "opensearch.keystore", IOContext.DEFAULT)) {
        final KeyStoreWrapper wrapper = KeyStoreWrapper.create();
                containsString("Keystore has been corrupted or tampered with")
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();  
        keystore.save(env.configDir(), getPassword());
        assertThat(e.getCause(), instanceOf(EOFException.class));
        keystore.close();  
            byte[] readBytes = new byte[20];  
import org.opensearch.core.common.settings.SecureString;
import java.io.ByteArrayOutputStream;
import org.apache.lucene.store.DataOutput;  
        io.writeBytes(encryptedBytes, encryptedBytes.length);
        keystore = KeyStoreWrapper.load(env.configDir());  
import java.security.SecureRandom;  
import java.io.IOException;
    private void possiblyAlterSecretString(DataOutputStream output, int truncLength) throws Exception {  
 * this file be licensed under the Apache-2.0 license or a
            CipherOutputStream cipherStream = getCipherStream(bytes, salt, iv);
        final byte[] buffer = new byte[1024];
 * software distributed under the License is distributed on an
        assertThat(keystore.getSHA256Digest(stringSettingKeyName), equalTo(stringSettingHash));  
        SecurityException e = expectThrows(SecurityException.class, () -> keystore.decrypt(new char[0]));
import static org.hamcrest.Matchers.equalTo;  
        final KeyStoreWrapper keystore = KeyStoreWrapper.create();
        assertThat(toByteArray(afterSave.getFile("file_setting")), equalTo("file_value".getBytes(StandardCharsets.UTF_8)));
import org.apache.lucene.store.IOContext;
        byte[] secret_value = "super_secret_value".getBytes(StandardCharsets.UTF_8);
import java.io.DataOutputStream;
        assertTrue(keystore.getSettingNames().contains(KeyStoreWrapper.SEED_SETTING.getKey()));
        SecureString testValue = keystore.getString("string_setting");
            exception.getMessage(),
        assertThat(exception.getMessage(), containsString("closed"));
    public void testFailWhenCannotConsumeSecretStream() throws Exception {
            for (int i = 0; i < fileBytes.length; ++i) {
        byte[] encryptedBytes,
    @After  
            char[] chars = new char[base64Bytes.length];  
import javax.crypto.spec.GCMParameterSpec;  
        assertThat(keystore.getSHA256Digest(fileSettingKeyName), equalTo(fileSettingHash));
/*  
            random.nextBytes(salt);  
            KeyStore.ProtectionParameter protectionParameter = new KeyStore.PasswordProtection(new char[0]);  
            SecureRandom random = Randomness.createSecure();
import java.security.NoSuchAlgorithmException;
 * under the License.  
            random.nextBytes(iv);
        keystore.save(env.configDir(), getPassword());  
            output.writeString("file_setting");
        Path configDir = env.configDir();
    }
            byte[] base64Bytes = Base64.getEncoder().encode(fileBytes);
 *  
        final byte[] fileSettingHash = MessageDigest.getInstance("SHA-256").digest(fileSettingValue);  
        afterSave.decrypt(getPassword());
        generateV1();
        KeyStoreWrapper keystore = KeyStoreWrapper.create();
    }
            }
 */  
    public void testFailWhenEncryptedBytesStreamIsNotConsumed() throws Exception {
    public void testDecryptKeyStoreWithWrongPassword() throws Exception {
    }
            // So that readFully during decryption will not consume the entire stream  
            output.writeString("PBE"); // file algo
        try (IndexOutput indexOutput = directory.createOutput("opensearch.keystore", IOContext.DEFAULT)) {
import java.util.HashSet;  
    }
            for (int i = 0; i < 256; ++i) {
    }
        io.writeInt(salt.length);  
        keystore.decrypt(new char[0]);
        }  
import static org.hamcrest.Matchers.instanceOf;
 * compatible open source license.
    }  
            possiblyAlterEncryptedBytes(indexOutput, salt, iv, encryptedBytes, 0);
        assertThat(testValue.toString(), equalTo("stringSecretValue"));  
            output.writeBytes(keystoreBytes, keystoreBytes.length);
        byte[] salt,
            output.writeByte((byte) 0); // hasPassword = false
            DataOutputStream output = new DataOutputStream(cipherStream);
        int readBytes;  
        keystore.decrypt(getPassword());  
        final IllegalStateException exception = expectThrows(  
        final String stringSettingValue = randomAlphaOfLength(32);
        output.writeInt(1); // One entry
        IOUtils.close(fileSystems);
            () -> keystore.getString(KeyStoreWrapper.SEED_SETTING.getKey())
/*  
    List<FileSystem> fileSystems = new ArrayList<>();
 *
        final ByteArrayOutputStream os = new ByteArrayOutputStream();
import org.hamcrest.Matchers;
            byte[] iv = new byte[12];
                containsString("Provided keystore password was incorrect"),
        keystore.setFile("foo", bytes);
    }
            possiblyAlterEncryptedBytes(indexOutput, salt, iv, encryptedBytes, randomIntBetween(2, encryptedBytes.length));  
            possiblyAlterSecretString(output, 4);
import java.util.List;
 * Modifications Copyright OpenSearch Contributors. See
    public void testBackcompatV1() throws Exception {  
            IllegalStateException.class,
        random().nextBytes(fileBytes);
        final SecurityException exception = expectThrows(  
        Path configDir = env.configDir();  
            random.nextBytes(salt);
            DataOutputStream output = new DataOutputStream(cipherStream);  
package org.opensearch.tools.cli.keystore;
        assertThat(e.getMessage(), containsString("Keystore has been corrupted or tampered with"));
            ByteArrayOutputStream keystoreBytesStream = new ByteArrayOutputStream();  
            random.nextBytes(salt);  
            output.writeString("PKCS12");  
            // Indicate that the secret string is longer than it is so readFully() fails  
    protected void generateV1() throws IOException, NoSuchAlgorithmException, NoSuchProviderException, CertificateException,
 * KIND, either express or implied.  See the License for the
            output.writeByte((byte) 0); // hasPassword = false
import java.nio.file.Path;  
        assertThat(keystore.getSHA256Digest(stringSettingKeyName), equalTo(stringSettingHash));
        assertThat(keystore.getSettingNames(), Matchers.hasItem(KeyStoreWrapper.SEED_SETTING.getKey()));
        keystore.decrypt(getPassword());
        KeyStoreWrapper keystore = KeyStoreWrapper.load(configDir);
        assertThat(testValue.toString(), equalTo("stringSecretValue"));  
            output.writeString("PKCS12");
            CipherOutputStream cipherStream = getCipherStream(bytes, salt, iv);
    }
 * You may obtain a copy of the License at  
import org.opensearch.test.OpenSearchTestCase;  
import static org.hamcrest.Matchers.anyOf;
    public void testBackcompatV2() throws Exception {  
        KeyStoreWrapper keystore = KeyStoreWrapper.create();  
            cipherStream.close();  
        Path configDir = env.configDir();
        try (IndexOutput indexOutput = directory.createOutput("opensearch.keystore", IOContext.DEFAULT)) {
    private void possiblyAlterEncryptedBytes(  
        assertTrue(e.getMessage().contains("does not match the allowed setting name pattern"));  
        SecurityException e = expectThrows(SecurityException.class, () -> keystore.decrypt(getPassword()));  
            byte[] iv = new byte[12];
            keystore.load(null, null);  
    }  
import java.util.Base64;
 */
 * The OpenSearch Contributors require contributions made to  
        final String stringSettingKeyName = randomAlphaOfLength(5).toLowerCase(Locale.ROOT) + "1";  
            keystore.setEntry("file_setting", new KeyStore.SecretKeyEntry(secretKey), protectionParameter);
            output.writeBytes(keystoreBytes, keystoreBytes.length);
    public void closeMockFileSystems() throws IOException {
            output.writeString("STRING");  
        KeyStoreWrapper keystore = KeyStoreWrapper.load(configDir);
                if (got < 0) {  
        // value hashes accessible even when the keystore is closed
        keystore = KeyStoreWrapper.load(env.configDir());
            KeyStore.ProtectionParameter protectionParameter = new KeyStore.PasswordProtection(new char[0]);
        final byte[] stringSettingHash = MessageDigest.getInstance("SHA-256").digest(stringSettingValue.getBytes(StandardCharsets.UTF_8));
        GCMParameterSpec spec = new GCMParameterSpec(128, iv);
    }  
        Path configDir = env.configDir();  
        assertThat(
        assertThat(afterSave.getString("string_setting"), equalTo("string_value"));
    @Before
        SecureString seed = keystore.getString(KeyStoreWrapper.SEED_SETTING.getKey());
import static org.hamcrest.Matchers.containsString;
            assertEquals(-1, fileInput.read());
        KeyStoreWrapper keystore = KeyStoreWrapper.create();  
        NIOFSDirectory directory = new NIOFSDirectory(configDir);  
 * ownership. Elasticsearch licenses this file to you under  
        Path configDir = env.configDir();
import java.nio.file.Files;
import org.apache.lucene.codecs.CodecUtil;
 * SPDX-License-Identifier: Apache-2.0
import java.nio.file.FileSystem;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> KeyStoreWrapper.validateSettingName("*"));  
            cipherStream.close();
        assertEquals(seed.toString(), keystore.getString(KeyStoreWrapper.SEED_SETTING.getKey()).toString());
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");  
        assertTrue(e.getMessage().contains("does not match the allowed setting name pattern"));
            final byte[] encryptedBytes = bytes.toByteArray();  
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    Environment env;  
            keystore.setEntry("string_setting", new KeyStore.SecretKeyEntry(secretKey), protectionParameter);  
        wrapper.setString("string_setting", "string_value".toCharArray());
        NIOFSDirectory directory = new NIOFSDirectory(configDir);
        keystore.setFile(fileSettingKeyName, fileSettingValue);
        assertThat(afterSave.getSettingNames(), equalTo(new HashSet<>(Arrays.asList("keystore.seed", "string_setting", "file_setting"))));  
            CipherOutputStream cipherStream = getCipherStream(bytes, salt, iv);
        io.writeBytes(iv, iv.length);  
    protected byte[] generateV2() throws Exception {  
import java.nio.charset.StandardCharsets;  
        }
        byte[] fileBytes = generateV2();
        keystore.setString(stringSettingKeyName, stringSettingValue.toCharArray());
import java.io.InputStream;
            CodecUtil.writeHeader(output, "opensearch.keystore", 1);  
                    fail("Expected 256 bytes but read " + i);
        keystore.decrypt(new char[0]);
            keystore.setEntry("string_setting", new KeyStore.SecretKeyEntry(secretKey), protectionParameter);
/*
        wrapper.save(env.configDir(), getPassword());  
import org.junit.Before;  
import java.security.KeyStoreException;
        assertThat(e.getMessage(), containsString("Keystore has been corrupted or tampered with"));  
        assertThat(toByteArray(afterSave.getFile("string_setting")), equalTo("string_value".getBytes(StandardCharsets.UTF_8)));
            CodecUtil.writeFooter(indexOutput);
            }
        }  
}
        }  
import javax.crypto.CipherOutputStream;  
    }  
            CodecUtil.writeHeader(indexOutput, "opensearch.keystore", 3);  
import java.util.Arrays;
        SecureString testValue = keystore.getString("string_setting");
    }
            assertEquals(20, fileInput.read(readBytes));
 */  
        io.writeInt(encryptedBytes.length - truncEncryptedDataLength);
        byte[] fileBytes = new byte[20];  
        return fileBytes;  
            os.write(buffer, 0, readBytes);
 * not use this file except in compliance with the License.
            CodecUtil.writeHeader(output, "opensearch.keystore", 2);
        return new CipherOutputStream(bytes, cipher);  
        keystore.close();  
    }
            KeyStore keystore = KeyStore.getInstance("PKCS12", "SUN");  
        // upgrade does not overwrite seed
            indexOutput.writeByte((byte) 0); // No password  
    }
        return os.toByteArray();
        assertThat(keystore.getSettingNames(), Matchers.hasItem(KeyStoreWrapper.SEED_SETTING.getKey()));  
        final KeyStoreWrapper afterSave = KeyStoreWrapper.load(env.configDir());  
        output.writeUTF("string_setting");  
            SecretKeyFactory secretFactory = SecretKeyFactory.getInstance("PBE", "SunJCE");
            output.writeVInt(2); // num settings
                int got = stream.read();
        try (IndexOutput indexOutput = directory.createOutput("opensearch.keystore", IOContext.DEFAULT)) {
            SecretKey secretKey = secretFactory.generateSecret(new PBEKeySpec("stringSecretValue".toCharArray()));
            final byte[] encryptedBytes = bytes.toByteArray();
import org.apache.lucene.store.NIOFSDirectory;  
        byte[] bytes = new byte[256];
import org.opensearch.common.Randomness;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    ) throws Exception {  
            anyOf(  
            output.writeString("PBE");  
            CipherOutputStream cipherStream = getCipherStream(bytes, salt, iv);
            final byte[] encryptedBytes = bytes.toByteArray();
            keystore.load(null, null);
        cipher.init(Cipher.ENCRYPT_MODE, secret, spec);
        assertThat(keystore.getSHA256Digest(fileSettingKeyName), equalTo(fileSettingHash));
        try (InputStream fileInput = keystore.getFile("file_setting")) {
        assertThat(e.getMessage(), containsString("Keystore has been corrupted or tampered with"));  
        try (InputStream stream = keystore.getFile("foo")) {  
        final String fileSettingKeyName = randomAlphaOfLength(5).toLowerCase(Locale.ROOT) + "2";  
        try (IndexOutput output = EndiannessReverserUtil.createOutput(directory, "opensearch.keystore", IOContext.DEFAULT)) {
        e = expectThrows(IllegalArgumentException.class, () -> keystore.setString("*", new char[0]));  
            for (int i = 0; i < chars.length; ++i) {
        KeyStoreWrapper keystore = KeyStoreWrapper.create();
        Path configDir = env.configDir();
    public void testFileSettingExhaustiveBytes() throws Exception {
            keystore.store(keystoreBytesStream, new char[0]);
    public void testFailWhenSecretStreamNotConsumed() throws Exception {
    }
import org.apache.lucene.backward_codecs.store.EndiannessReverserUtil;
import java.security.spec.InvalidKeySpecException;
            indexOutput.writeByte((byte) 0); // No password  
        keystore.save(env.configDir(), getPassword());
    }
        cipher.updateAAD(salt);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        keystore.remove(KeyStoreWrapper.SEED_SETTING.getKey());
        output.writeInt(secret_value.length - truncLength);
        final KeyStoreWrapper loadedKeystore = KeyStoreWrapper.load(env.configDir());
        SecurityException e = expectThrows(SecurityException.class, () -> keystore.decrypt(new char[0]));
        while ((readBytes = is.read(buffer)) > 0) {
                }
            CodecUtil.writeFooter(indexOutput);
            byte[] keystoreBytes = keystoreBytesStream.toByteArray();  
        assertEquals(seed.toString(), keystore.getString(KeyStoreWrapper.SEED_SETTING.getKey()).toString());
            bytes[i] = (byte) i;  
        assertNotNull(seed);
import org.opensearch.common.util.io.IOUtils;  
            final byte[] encryptedBytes = bytes.toByteArray();  
        assertThat(e.getCause(), instanceOf(EOFException.class));
        IndexOutput indexOutput,
            byte[] keystoreBytes = keystoreBytesStream.toByteArray();
            }  
            possiblyAlterSecretString(output, -4);
        SecurityException e = expectThrows(SecurityException.class, () -> keystore.decrypt(getPassword()));  
            ByteArrayOutputStream keystoreBytesStream = new ByteArrayOutputStream();
    protected char[] getPassword() {
            SecureRandom random = Randomness.createSecure();
        keystore = KeyStoreWrapper.load(env.configDir());
import javax.crypto.SecretKeyFactory;
            SecureRandom random = Randomness.createSecure();
            cipherStream.close();
import org.junit.After;
            CodecUtil.writeFooter(indexOutput);
    }
 * specific language governing permissions and limitations
            possiblyAlterSecretString(output, 0);
        NIOFSDirectory directory = new NIOFSDirectory(configDir);
import java.security.NoSuchProviderException;
            byte[] salt = new byte[64];  
            possiblyAlterEncryptedBytes(indexOutput, salt, iv, encryptedBytes, -12);  
            DataOutputStream output = new DataOutputStream(cipherStream);
        output.write(secret_value);  
            SecurityException.class,
    }
        KeyStoreWrapper keystore = KeyStoreWrapper.create();
        assertTrue(e.getMessage().contains("does not match the allowed setting name pattern"));
        keystore.decrypt(getPassword());
            SecretKeyFactory secretFactory = SecretKeyFactory.getInstance("PBE", "SunJCE");
    public void testUpgradeAddsSeed() throws Exception {
            () -> loadedKeystore.decrypt("wrong_password_<1234567890%&!\"/>_but_a_strong_one".toCharArray())
import java.security.cert.CertificateException;
import static org.hamcrest.Matchers.notNullValue;
            CodecUtil.writeFooter(output);  
    public void testValueSHA256Digest() throws Exception {
        }  
    }
        for (int i = 0; i < 256; ++i) {
    }
import org.opensearch.common.settings.KeyStoreWrapper;
        env = KeyStoreCommandTestCase.setupEnv(true, fileSystems);
 * GitHub history for details.
            output.writeString("PBE"); // string algo
        int truncEncryptedDataLength
        Path configDir = env.configDir();
import java.security.KeyStore;
    public void testCreate() throws Exception {  
        final byte[] fileSettingValue = randomByteArrayOfLength(32);
    private byte[] toByteArray(final InputStream is) throws IOException {  
            cipherStream.close();
        SecretKey secretKey = keyFactory.generateSecret(keySpec);  
            byte[] salt = new byte[64];
import java.util.Locale;
import javax.crypto.spec.PBEKeySpec;
    }  
import javax.crypto.spec.SecretKeySpec;
 * Unless required by applicable law or agreed to in writing,
            possiblyAlterEncryptedBytes(indexOutput, salt, iv, encryptedBytes, 0);
        DataOutput io = EndiannessReverserUtil.wrapDataOutput(indexOutput);
            CodecUtil.writeHeader(indexOutput, "opensearch.keystore", 3);
 *
import javax.crypto.SecretKey;
        }  
    public void testCannotReadStringFromClosedKeystore() throws Exception {
        KeyStoreWrapper keystore = KeyStoreWrapper.load(configDir);
    }
    public void testFailWhenCannotConsumeEncryptedBytesStream() throws Exception {
            // Indicate that the encryptedBytes is larger than it is so readFully() fails
            DataOutputStream output = new DataOutputStream(cipherStream);
import javax.crypto.Cipher;
            output.writeString("FILE");
import org.opensearch.env.Environment;
        final Path temp = createTempDir();  
        KeyStoreWrapper keystore = KeyStoreWrapper.load(configDir);
        io.writeInt(4 + salt.length + 4 + iv.length + 4 + encryptedBytes.length);
        assertNotNull(afterSave);
 * this work for additional information regarding copyright
        KeyStoreWrapper.upgrade(keystore, env.configDir(), new char[0]);  
        output.writeUTF("STRING");
            byte[] salt = new byte[64];
        wrapper.close();
            )  
        KeyStoreWrapper keystore = KeyStoreWrapper.load(configDir);  
        try (IndexOutput indexOutput = directory.createOutput("opensearch.keystore", IOContext.DEFAULT)) {
            indexOutput.writeByte((byte) 0); // No password  
        }
        PBEKeySpec keySpec = new PBEKeySpec(getPassword(), salt, 10000, 128);
        KeyStoreWrapper keystore = KeyStoreWrapper.create();
public class KeyStoreWrapperTests extends OpenSearchTestCase {
            CodecUtil.writeFooter(indexOutput);
            CodecUtil.writeHeader(indexOutput, "opensearch.keystore", 3);
            indexOutput.writeByte((byte) 0); // No password
            assertEquals(-1, stream.read()); // nothing left
        byte[] iv,  
        KeyStoreWrapper.upgrade(keystore, env.configDir(), getPassword());  
            keystore.store(keystoreBytesStream, new char[0]);
        keystore.save(env.configDir(), getPassword());
        );  
        }
            output.writeString("string_setting");
                assertThat("byte " + i, readBytes[i], equalTo(fileBytes[i]));  
            output.writeInt(keystoreBytes.length);  
            possiblyAlterSecretString(output, 0);  
    public void setupEnv() throws IOException {  
            SecretKey secretKey = secretFactory.generateSecret(new PBEKeySpec("stringSecretValue".toCharArray()));
import java.security.MessageDigest;  
        InvalidKeySpecException, KeyStoreException {
        }  
            random.nextBytes(iv);
            random.nextBytes(salt);  
    private CipherOutputStream getCipherStream(ByteArrayOutputStream bytes, byte[] salt, byte[] iv) throws Exception {  
