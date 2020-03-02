package library.demo.one.activity

import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_9.*
import library.demo.one.R
import library.demo.one.base.BaseActivity
import org.apache.http.HttpResponse
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.impl.client.DefaultHttpClient
import java.io.ByteArrayOutputStream
import java.io.InputStream


class Activity9 : BaseActivity() {

    private val url = "https://cashier-desk.saic-gm.com/appserver/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_9)

        btn_1.setOnClickListener {
            Thread {
                testHttpClient()
            }.start()
        }
    }

    private fun testHttpClient() {
        val httpClient: HttpClient = DefaultHttpClient()
        val getRequest: HttpUriRequest = HttpGet(url)
        val response: HttpResponse = httpClient.execute(getRequest)

        if (response.statusLine.statusCode == 200) {
            val inputStream: InputStream = response.entity.content
            val bytes = ByteArray(1024)
            var len = 0
            val bos = ByteArrayOutputStream()
            while (-1 != inputStream.read().also { len = it }) {
                bos.write(bytes, 0, len)
            }
            val result: String = bos.toString()

            Log.i("queen", "result:$result")

            inputStream.close()
            bos.close()
        } else {
            Log.i("queen", "访问失败")
        }
    }

}