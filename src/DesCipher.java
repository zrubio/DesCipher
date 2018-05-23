import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DesCipher {

    public SecretKey getSecretKey(String algorithm, int bits){

        KeyGenerator keyGenerator = null;
        try{
            keyGenerator = KeyGenerator.getInstance(algorithm);
            keyGenerator.init(bits);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        return keyGenerator.generateKey();
    }

    public byte[] cypher(String algorithm, SecretKey secretKey, byte[] messageToEncrypt){
        Cipher cipher = null;
        byte[] result;
        try{
            cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            result = cipher.doFinal(messageToEncrypt);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        return result;
    }

    public byte[] descypher(String algorithm, SecretKey secretKey, byte [] messageEncrypted){
        Cipher cipher = null;
        byte[] result;
        try{
            cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            result = cipher.doFinal(messageEncrypted);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        return result;
    }

}
