import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Test {
    public static void main(String[] args) throws Exception{
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        String url = "https://www.baidu.com";
//        HttpGet httpGet = new HttpGet(url);
//        CloseableHttpResponse response = null;
//        try {
//            response = httpClient.execute(httpGet);
//            if(response.getStatusLine().getStatusCode() == 200){
//                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
//                System.out.println(content);
//
//            }
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }finally {
//            if(response != null){
//                response.close();
//            }
//            httpClient.close();
//        }
//    }
        // 创建HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 定义请求的参数
        URI uri = new URIBuilder("https://app.sanzai-meta.com/").build();

        HttpGet httpGet = new HttpGet(uri);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }

    }

}
