import com.dxy.library.util.cipher.constant.Algorithm;
import com.dxy.library.util.cipher.constant.AlgorithmUtils;
import com.dxy.library.util.cipher.constant.Mode;
import com.dxy.library.util.cipher.constant.Padding;
import com.dxy.library.util.cipher.symmetry.SM4Utils;
import org.junit.Test;

import java.time.Clock;

/**
 * @author duanxinyuan
 * 2019/2/25 15:52
 */
public class SM4Test {

    private String content = "hello world";
    private String key = "vdsffBFegf+YdUJbfgDTvQ==";
    private String iv = "0102030405060708";

    @Test
    public void getAlgorithm() {
        System.out.println(AlgorithmUtils.getAlgorithm(Algorithm.SM4, Mode.CBC, Padding.PKCS7Padding));
        System.out.println(AlgorithmUtils.getAlgorithm(Algorithm.SM4, Mode.ECB, Padding.NoPadding));
    }

    @Test
    public void genarateKey() {
        System.out.println(SM4Utils.genarateKeyBase64());
    }

    @Test
    public void testTime() {
        long millis = Clock.systemUTC().millis();
        for (int i = 0; i < 10000; i++) {
            test();
        }
        System.out.println(Clock.systemUTC().millis() - millis);
    }

    @Test
    public void test() {
        System.out.println(SM4Utils.encrypt(content, key));
        System.out.println(SM4Utils.decrypt(SM4Utils.encrypt(content, key), key));

        System.out.println(SM4Utils.encrypt(content, key, iv));
        System.out.println(SM4Utils.decrypt(SM4Utils.encrypt(content, key, iv), key, iv));

        System.out.println(SM4Utils.encrypt(content, key, Mode.ECB, Padding.PKCS7Padding));
        System.out.println(SM4Utils.decrypt(SM4Utils.encrypt(content, key, Mode.ECB, Padding.PKCS7Padding), key, Mode.ECB, Padding.PKCS7Padding));

        System.out.println(SM4Utils.encrypt(content, key, iv, Mode.CBC, Padding.PKCS7Padding));
        System.out.println(SM4Utils.decrypt(SM4Utils.encrypt(content, key, iv, Mode.CBC, Padding.PKCS7Padding), key, iv, Mode.CBC, Padding.PKCS7Padding));

        System.out.println(SM4Utils.encrypt(content, key, iv, Mode.CFB, Padding.PKCS7Padding));
        System.out.println(SM4Utils.decrypt(SM4Utils.encrypt(content, key, iv, Mode.CFB, Padding.PKCS7Padding), key, iv, Mode.CFB, Padding.PKCS7Padding));

        System.out.println(SM4Utils.encrypt(content, key, iv, Mode.CTR, Padding.PKCS7Padding));
        System.out.println(SM4Utils.decrypt(SM4Utils.encrypt(content, key, iv, Mode.CTR, Padding.PKCS7Padding), key, iv, Mode.CTR, Padding.PKCS7Padding));

        System.out.println(SM4Utils.encrypt(content, key, iv, Mode.OFB, Padding.PKCS7Padding));
        System.out.println(SM4Utils.decrypt(SM4Utils.encrypt(content, key, iv, Mode.OFB, Padding.PKCS7Padding), key, iv, Mode.OFB, Padding.PKCS7Padding));

    }

}
