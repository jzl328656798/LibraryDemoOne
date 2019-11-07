package library.demo.one.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * Author: Queen
 * Date: 2019-10-21 10:30
 * ----------Dragon be here!----------/
 * 　　　┏┓　　 ┏┓
 * 　　┏┛┻━━━┛┻┓━━━
 * 　　┃　　　　　 ┃
 * 　　┃　　　━　  ┃
 * 　　┃　┳┛　┗┳
 * 　　┃　　　　　 ┃
 * 　　┃　　　┻　  ┃
 * 　　┃　　　　   ┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛━━━━━
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━━━━━━神兽出没━━━━━━━━━━━━━━
 *
 * Describe: Test2DateViewModel
 */

class Test2DateViewModel : ViewModel() {

    private var mCurrentName: MutableLiveData<String>? = null
    private var mNameListData: MutableLiveData<ArrayList<String>>? = null

    fun getCurrentName(): MutableLiveData<String>? {
        if (mCurrentName == null) {
            mCurrentName = MutableLiveData()
        }
        return mCurrentName
    }

    fun getNameList(): MutableLiveData<ArrayList<String>>? {
        if (mNameListData == null) {
            mNameListData = MutableLiveData()
        }
        return mNameListData
    }
}