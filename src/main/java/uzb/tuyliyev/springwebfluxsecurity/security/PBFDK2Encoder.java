package uzb.tuyliyev.springwebfluxsecurity.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

@Component
public class PBFDK2Encoder implements PasswordEncoder {

    @Value("{jwt.password.encoder.secret:}")
    private String secret;
    @Value("{jwt.password.encoder.iteration:}")
    private Integer iteration;
    @Value("{jwt.password.encoder.keyLength}:")
    private Integer keyLength;

    //parolni kalitga aylantirish va shifrlashni kuchaytirish
    private static final String SECRET_KEY_INSTANCE = "PBKDF2WithHmacSHA512";


    //Bu operatsiya kriptografiya bilan maxfiylikni ta'minlash uchun amaliyotlar qiladi
    @Override
    public String encode(CharSequence rawPassword) {
        try {
            byte[] result = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE)
                    .generateSecret(new PBEKeySpec(rawPassword.toString().toCharArray(),
                            secret.getBytes(), iteration, keyLength))
                    .getEncoded();
            return Base64.getEncoder()
                    .encodeToString(result);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }
}

/**
 * SecretKeyFactory--Kalitlarni generatsiya qilish, o'qish va yozish,
 * tekshirish, va ma'lumotlarni himoyalash uchun metodlarni taqdim qiladi.
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 *
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 * <p>
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override public String encode(CharSequence rawPassword) {
 * try {
 * // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 * SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 * <p>
 * // Parolni char array (massiv) shaklida olishimiz kerak
 * char[] parolChars = rawPassword.toString().toCharArray();
 * <p>
 * // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 * PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 * <p>
 * // Kalitni generatsiya qilamiz
 * byte[] kalit = factory.generateSecret(spec).getEncoded();
 * <p>
 * // Kalitni Base64 kodlash va matnga o'tkazish
 * return Base64.getEncoder().encodeToString(kalit);
 * } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 * throw new RuntimeException(e);
 * }
 * }
 */


/**
 * -- Kodni tarjima qilganda quyidagicha bo'ladi --
 * @Override
 * public String encode(CharSequence rawPassword) {
 *     try {
 *         // Parolni sir panjara kalitiga aylantirish uchun algoritmdan foydalanamiz
 *         SecretKeyFactory factory = SecretKeyFactory.getInstance(SECRET_KEY_INSTANCE);
 *
 *         // Parolni char array (massiv) shaklida olishimiz kerak
 *         char[] parolChars = rawPassword.toString().toCharArray();
 *
 *         // Kalitni generatsiya qilish uchun PBEKeySpec obyekti yaratamiz
 *         PBEKeySpec spec = new PBEKeySpec(parolChars, secret.getBytes(), iteration, keyLength);
 *
 *         // Kalitni generatsiya qilamiz
 *         byte[] kalit = factory.generateSecret(spec).getEncoded();
 *
 *         // Kalitni Base64 kodlash va matnga o'tkazish
 *         return Base64.getEncoder().encodeToString(kalit);
 *     } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
 *         throw new RuntimeException(e);
 *     }
 * }
 */





