package library.demo.one.test;

import android.graphics.Bitmap;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Author: Queen
 * Date: 2019-11-18 13:23
 * Describe: TODO
 */
public class Test1 {


    public void test1(){

    }

    public void sop1(String path){


//        private fun initRx() {
//            Observable.create(ObservableOnSubscribe<String> {
//                    it.onNext(path)
//                    it.onComplete()
//            })
//                    .map { openDownLoad() }
//            .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(object : Observer<Bitmap> {
//                override fun onComplete() {
//                    diaLog?.show()
//                }
//
//                override fun onSubscribe(d:Disposable) {
//                    diaLog?.dismiss()
//                }
//
//                override fun onNext(t: Bitmap) {
//                    iv_img.setImageBitmap(t)
//                }
//
//                override fun onError(e: Throwable) {
//
//                }
//            })
//
//        }


        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("");
                emitter.onComplete();
            }
        }).map(s -> sop2()).subscribe(new Observer<Bitmap>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Bitmap bitmap) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });




    }

    private Bitmap sop2() {

        return null;
    }


}
