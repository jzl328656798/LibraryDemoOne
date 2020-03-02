package library.demo.one.activity

import android.app.ProgressDialog
import android.graphics.*
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activit3.*
import library.demo.one.base.BaseActivity
import java.net.HttpURLConnection
import java.net.URL


class Activity3 : BaseActivity() {

    private val path =
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574073524314&di=3d2e05ab1ee0067bb24311708f12da23&imgtype=0&src=http%3A%2F%2Fzzyhqc.com%2Fuploads%2Fallimg%2F180826%2F0K6029149_0.png"


    private var diaLog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(library.demo.one.R.layout.activit3)
        diaLog = ProgressDialog(this)
        diaLog?.setMessage("正在下载...")


        btn_1.setOnClickListener {
            diaLog?.show()
            Thread(Runnable { openDownLoad() }).start()
        }
        btn_2.setOnClickListener { initRx() }
    }


    private fun openDownLoad(): Bitmap? {
        i("start down load --- line:${Thread().name}")
        val url = URL(path)
        val openConnection = url.openConnection() as HttpURLConnection
        val responseCode = openConnection.responseCode
        return if (responseCode == HttpURLConnection.HTTP_OK) {

            val inputStream = openConnection.inputStream

            //            setImgSrc(bitmap)
            i("start down load success --- line:${Thread().name}")
            BitmapFactory.decodeStream(inputStream)

        } else {
            i("error")
            null
        }

    }


    private fun setImgSrc(bitmap: Bitmap) {
        diaLog?.dismiss()
        runOnUiThread(Runnable { iv_img.setImageBitmap(bitmap) })

    }

    private fun initRx() {

        Observable.create<String> { emitter ->
            emitter.onNext(path)
            emitter.onComplete()
        }.map<Bitmap> { t ->
            i("init start down load:$t --- line:${Thread().name}")
            openDownLoad()
        }.map<Bitmap> { t -> addTextWatermark(t, "测试一下", 30f, Color.WHITE, 100f, 100f, positionFlag = true, recycle = true) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Bitmap> {
                override fun onSubscribe(d: Disposable) {
                    i("onSubscribe --- line:${Thread().name}")
                    diaLog?.show()
                }

                override fun onNext(bitmap: Bitmap) {
                    i("onNext --- line:${Thread().name}")
                    iv_img.setImageBitmap(bitmap)
                }

                override fun onError(e: Throwable) {
                    i("onError:$e --- line:${Thread().name}")
                    diaLog?.dismiss()
                }

                override fun onComplete() {
                    i("onComplete --- line:${Thread().name}")
                    diaLog?.dismiss()
                }
            })

    }


    fun addTextWatermark(
        bitmap: Bitmap,
        content: String,
        textSize: Float,
        color: Int,
        x: Float,
        y: Float,
        positionFlag: Boolean,
        recycle: Boolean
    ): Bitmap? {
        val ret = bitmap.copy(bitmap.config, true)
        val paint = Paint(ANTI_ALIAS_FLAG)
        val canvas = Canvas(ret)
        paint.color = color
        paint.textSize = textSize
        val bounds = Rect()
        paint.getTextBounds(content, 0, content.length, bounds)
        canvas.drawText(content, bitmap.width - x - bounds.width() - bounds.left, bitmap.height - bounds.height() - bounds.top - y, paint)

        if (positionFlag) {
            canvas.drawText(content, x, bitmap.height - bounds.height() - bounds.top - y, paint)

        } else {
            canvas.drawText(
                content,
                bitmap.width - x - bounds.width() - bounds.left,
                bitmap.height - bounds.height() - bounds.top - y,
                paint
            )

        }
        if (recycle && !bitmap.isRecycled)
            bitmap.recycle()
        return ret
    }


    private fun sop1() {

    }
}