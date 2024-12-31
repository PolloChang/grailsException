package ex

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

import java.util.concurrent.TimeUnit

/**
 * 這是一個 HttpTimeout 的範例程式
 */
class HttpTimeOutExample {

    /**
     * 此範例會丟出下列例外:
     * 1. java.net.SocketTimeoutException: timeout
     * @param url
     * @return
     * @throws Exception
     */
    HashMap clineTimeout () {

        String url = "https://httpstat.us/200?sleep=5000"
        HashMap returnVal = [ content : "" ]

        // 配置 OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS) // 設置連接超時
                .readTimeout(1, TimeUnit.SECONDS) // 設置讀取超時
                .writeTimeout(1, TimeUnit.SECONDS) // 設置寫入超時
                .build()

        // 创建请求
        Request request = new Request.Builder()
                .url(url)
                .build()

        Response response = client.newCall(request).execute()
        returnVal.code = response.code

        if ( response.isSuccessful() ) {
            returnVal.content = response?.body?.string()
        } else {
            returnVal.content = ""
        }

        return returnVal
    }


    /**
     * 此範例會丟出下列例外:
     * 1. java.net.SocketTimeoutException: timeout
     * 2. java.lang.ArithmeticException: / by zero
     * @return
     */
    HashMap clineTimeout2 () {

        HashMap returnVal = [ content : "" ]

        int randomNumber = new Random().nextInt(10)

        if (randomNumber % 2 == 0) {
            returnVal = clineTimeout ()
        } else {
            int i = 1 / 0

            returnVal = [ content: i ]
        }

        return returnVal

    }

}
