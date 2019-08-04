package library.demo.viewlibrary.italic.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import library.demo.viewlibrary.R
import android.graphics.*
import android.text.TextPaint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode


/**
 * Created by queen on 2019-08-02.
 * CreateTime: 2019-08-02 - 12:34
 * Author: Queen
 * Date: 2019-08-02
 * Time: 12:34
 * Describe: 斜体 textView
 */
class ItalicTextView : View {

    companion object {
        const val MODE_LEFT = 0
        const val MODE_RIGHT = 1
        const val MODE_LEFT_BOTTOM = 2
        const val MODE_RIGHT_BOTTOM = 3
        const val MODE_LEFT_TRIANGLE = 4
        const val MODE_RIGHT_TRIANGLE = 5
        const val MODE_LEFT_BOTTOM_TRIANGLE = 6
        const val MODE_RIGHT_BOTTOM_TRIANGLE = 7

        const val ROTATE_ANGLE = 45f
    }

    private var mPaint: Paint = Paint()
    private var mTextPaint: TextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    private var mItalicLength = 40f
    private var mTextSize = 16f
    private var mItalicBackgroundColor = Color.TRANSPARENT
    private var mTextColor = Color.WHITE
    private var mItalicText = ""
    private var mMode = MODE_LEFT

    constructor(context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(attrs)
    }

    private fun initView(attrs: AttributeSet?) {
        val array = context.obtainStyledAttributes(attrs, R.styleable.ItalicTextView)

        mTextSize = array.getDimension(R.styleable.ItalicTextView_italicTextSize, mTextSize)
        mTextColor = array.getColor(R.styleable.ItalicTextView_italicTextColor, mTextColor)
        mItalicLength = array.getDimension(R.styleable.ItalicTextView_italicLength, mItalicLength)
        mItalicBackgroundColor = array.getColor(R.styleable.ItalicTextView_italicBackgroundColor, mItalicBackgroundColor)
        mItalicText = array.getString(R.styleable.ItalicTextView_italicText) ?: ""
        mMode = array.getInt(R.styleable.ItalicTextView_italicMode, 0)
        array.recycle()

        mPaint.style = Paint.Style.FILL
        mPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OVER)
        mPaint.isAntiAlias = true
        mPaint.color = mItalicBackgroundColor

        mTextPaint.isAntiAlias = true
        mTextPaint.textSize = mTextSize
        mTextPaint.color = mTextColor
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawBackground(canvas)
        drawText(canvas)
    }

    private fun drawBackground(canvas: Canvas) {
        var path = Path()
        val w = width.toFloat()
        val h = height.toFloat()
        when (mMode) {
            MODE_LEFT -> path = getModeLeftPath(path, w, h)
            MODE_RIGHT -> path = getModeRightPath(path, w, h)
            MODE_LEFT_BOTTOM -> path = getModeLeftBottomPath(path, w, h)
            MODE_RIGHT_BOTTOM -> path = getModeRightBottomPath(path, w, h)
            MODE_LEFT_TRIANGLE -> path = getModeLeftTrianglePath(path, w, h)
            MODE_RIGHT_TRIANGLE -> path = getModeRightTrianglePath(path, w, h)
            MODE_LEFT_BOTTOM_TRIANGLE -> path = getModeLeftBottomTrianglePath(path, w, h)
            MODE_RIGHT_BOTTOM_TRIANGLE -> path = getModeRightBottomTrianglePath(path, w, h)
        }
        path.close()
        canvas.drawPath(path, mPaint)
        canvas.save()
    }

    private fun getModeLeftPath(path: Path, w: Float, h: Float): Path {
        path.moveTo(w, 0f)
        path.lineTo(0f, h)
        path.lineTo(0f, h - mItalicLength)
        path.lineTo(w - mItalicLength, 0f)
        return path
    }

    private fun getModeRightPath(path: Path, w: Float, h: Float): Path {
        path.lineTo(w, h)
        path.lineTo(w, h - mItalicLength)
        path.lineTo(mItalicLength, 0f)
        return path
    }

    private fun getModeLeftBottomPath(path: Path, w: Float, h: Float): Path {
        path.lineTo(w, h)
        path.lineTo(w - mItalicLength, h)
        path.lineTo(0f, mItalicLength)
        return path
    }

    private fun getModeRightBottomPath(path: Path, w: Float, h: Float): Path {
        path.moveTo(0f, h)
        path.lineTo(mItalicLength, h)
        path.lineTo(w, mItalicLength)
        path.lineTo(w, 0f)
        return path
    }

    private fun getModeLeftTrianglePath(path: Path, w: Float, h: Float): Path {
        path.lineTo(0f, h)
        path.lineTo(w, 0f)
        return path
    }

    private fun getModeRightTrianglePath(path: Path, w: Float, h: Float): Path {
        path.lineTo(w, 0f)
        path.lineTo(w, h)
        return path
    }

    private fun getModeLeftBottomTrianglePath(path: Path, w: Float, h: Float): Path {
        path.lineTo(w, h)
        path.lineTo(0f, h)
        return path
    }

    private fun getModeRightBottomTrianglePath(path: Path, w: Float, h: Float): Path {
        path.moveTo(0f, h)
        path.lineTo(w, h)
        path.lineTo(w, 0f)
        return path
    }

    private fun drawText(canvas: Canvas) {
        val w = canvas.width - mItalicLength / 2
        val h = canvas.height - mItalicLength / 2
        val xy = calculateXY(w.toInt(), h.toInt())
        val toX = xy[0]
        val toY = xy[1]
        val centerX = xy[2]
        val centerY = xy[3]
        val angle = xy[4]
        canvas.rotate(angle, centerX, centerY)
        canvas.drawText(mItalicText, toX, toY, mTextPaint)
    }

    private fun calculateXY(w: Int, h: Int): FloatArray {
        val xy = FloatArray(5)
        val rect: Rect?
        val rectF: RectF?
        val offset = (mItalicLength / 2).toInt()
        when (mMode) {
            MODE_LEFT_TRIANGLE, MODE_LEFT -> {
                rect = Rect(0, 0, w, h)
                rectF = RectF(rect)
                rectF.right = mTextPaint.measureText(mItalicText, 0, mItalicText.length)
                rectF.bottom = mTextPaint.descent() - mTextPaint.ascent()
                rectF.left += (rect.width() - rectF.right) / 2.0f
                rectF.top += (rect.height() - rectF.bottom) / 2.0f
                xy[0] = rectF.left
                xy[1] = rectF.top - mTextPaint.ascent()
                xy[2] = (w / 2).toFloat()
                xy[3] = (h / 2).toFloat()
                xy[4] = -ROTATE_ANGLE
            }
            MODE_RIGHT_TRIANGLE, MODE_RIGHT -> {
                rect = Rect(offset, 0, w + offset, h)
                rectF = RectF(rect)
                rectF.right = mTextPaint.measureText(mItalicText, 0, mItalicText.length)
                rectF.bottom = mTextPaint.descent() - mTextPaint.ascent()
                rectF.left += (rect.width() - rectF.right) / 2.0f
                rectF.top += (rect.height() - rectF.bottom) / 2.0f
                xy[0] = rectF.left
                xy[1] = rectF.top - mTextPaint.ascent()
                xy[2] = (w / 2 + offset).toFloat()
                xy[3] = (h / 2).toFloat()
                xy[4] = ROTATE_ANGLE
            }
            MODE_LEFT_BOTTOM_TRIANGLE, MODE_LEFT_BOTTOM -> {
                rect = Rect(0, offset, w, h + offset)
                rectF = RectF(rect)
                rectF.right = mTextPaint.measureText(mItalicText, 0, mItalicText.length)
                rectF.bottom = mTextPaint.descent() - mTextPaint.ascent()
                rectF.left += (rect.width() - rectF.right) / 2.0f
                rectF.top += (rect.height() - rectF.bottom) / 2.0f

                xy[0] = rectF.left
                xy[1] = rectF.top - mTextPaint.ascent()
                xy[2] = (w / 2).toFloat()
                xy[3] = (h / 2 + offset).toFloat()
                xy[4] = ROTATE_ANGLE
            }
            MODE_RIGHT_BOTTOM_TRIANGLE, MODE_RIGHT_BOTTOM -> {
                rect = Rect(offset, offset, w + offset, h + offset)
                rectF = RectF(rect)
                rectF.right = mTextPaint.measureText(mItalicText, 0, mItalicText.length)
                rectF.bottom = mTextPaint.descent() - mTextPaint.ascent()
                rectF.left += (rect.width() - rectF.right) / 2.0f
                rectF.top += (rect.height() - rectF.bottom) / 2.0f
                xy[0] = rectF.left
                xy[1] = rectF.top - mTextPaint.ascent()
                xy[2] = (w / 2 + offset).toFloat()
                xy[3] = (h / 2 + offset).toFloat()
                xy[4] = -ROTATE_ANGLE
            }
        }
        return xy
    }
}