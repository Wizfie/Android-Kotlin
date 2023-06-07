package com.example.likesapp

import android.graphics.*
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.likesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mBitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888)
    private val mCanvas = Canvas(mBitmap)
    private val mPaint = Paint()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setImageBitmap(mBitmap)
        showEars()
        showFace()
        showHair()
        showEyes()
        showNose()
        showMouth(true)

        binding.like.setOnClickListener {
            showEars()
            showFace()
            showHair()
            showEyes()
            showNose()
            showMouth(true)

        }
        binding.dislike.setOnClickListener {
            showEars()
            showFace()
            showHair()
            showEyes()
            showNose()
            showMouth(false)
        }

    }


    private val halOfWidth = (mBitmap.width / 2).toFloat()
    private val halOfHeight = (mBitmap.height / 2).toFloat()

    private val left = 150F
    private val top = 250F
    private val right = mBitmap.width - left
    private val bottom = mBitmap.height.toFloat() - 50F

    private fun showFace() {
        val face = RectF(left, top, right, bottom)

        mPaint.color = ResourcesCompat.getColor(resources, R.color.yellow_left_skin, null)
        mCanvas.drawArc(face, 90F, 180F, false, mPaint)

        mPaint.color = ResourcesCompat.getColor(resources, R.color.yellow_right_skin, null)
        mCanvas.drawArc(face, 270F, 180F, false, mPaint)
    }

    private fun showEyes(){
        mPaint.color = ResourcesCompat.getColor(resources,R.color.black,null)
        mCanvas.drawCircle(halOfHeight - 100 , halOfHeight - 10F,50F, mPaint)
        mCanvas.drawCircle(halOfHeight + 100 , halOfHeight - 10F, 50F , mPaint)
    }
    private fun showNose() {
        mPaint.color = ResourcesCompat.getColor(resources, R.color.black, null)
        mCanvas.drawCircle(halOfWidth - 40F, halOfHeight + 140F, 15F, mPaint)
        mCanvas.drawCircle(halOfWidth + 40F, halOfHeight + 140F, 15F, mPaint)
    }
    private fun showEars() {
        mPaint.color = ResourcesCompat.getColor(resources, R.color.brown_left_hair, null)
        mCanvas.drawCircle(halOfWidth - 300F, halOfHeight - 100F, 100F, mPaint)

        mPaint.color = ResourcesCompat.getColor(resources, R.color.brown_right_hair, null)
        mCanvas.drawCircle(halOfWidth + 300F, halOfHeight - 100F, 100F, mPaint)

        mPaint.color = ResourcesCompat.getColor(resources, R.color.red_ear, null)
        mCanvas.drawCircle(halOfWidth - 300F, halOfHeight - 100F, 60F, mPaint)
        mCanvas.drawCircle(halOfWidth + 300F, halOfHeight - 100F, 60F, mPaint)
    }
    private fun showHair() {
        mCanvas.save()

        val path = Path()

        path.addCircle(halOfWidth - 100F,halOfHeight - 10F, 150F, Path.Direction.CCW)
        path.addCircle(halOfWidth + 100F,halOfHeight - 10F, 150F, Path.Direction.CCW)

        val mouth = RectF(halOfWidth - 250F, halOfHeight, halOfWidth + 250F, halOfHeight + 500F)
        path.addOval(mouth, Path.Direction.CCW)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            mCanvas.clipPath(path, Region.Op.DIFFERENCE)
        } else {
            mCanvas.clipOutPath(path)
        }

        val face = RectF(left, top, right, bottom)

        mPaint.color = ResourcesCompat.getColor(resources, R.color.brown_left_hair, null)
        mCanvas.drawArc(face, 90F, 180F, false, mPaint)

        mPaint.color = ResourcesCompat.getColor(resources, R.color.brown_right_hair, null)
        mCanvas.drawArc(face, 270F, 180F, false, mPaint)

        mCanvas.restore()
    }

   private fun showMouth(isHappy : Boolean){
       when(isHappy){
           true -> {
               mPaint.color = ResourcesCompat.getColor(resources, R.color.black,null)
               val lip = RectF(halOfWidth -200F , halOfHeight - 100F ,halOfWidth + 200F,halOfHeight +400F)
               mCanvas.drawArc(lip,25F,130F,false,mPaint)

               mPaint.color = ResourcesCompat.getColor(resources, R.color.white, null)
               val mouth = RectF(halOfWidth - 180F, halOfHeight, halOfHeight + 180F, halOfHeight + 380F)
               mCanvas.drawArc(mouth, 25F, 130F, false, mPaint)
           }
           false -> {
               mPaint.color = ResourcesCompat.getColor(resources , R.color.black,null)
               val lip = RectF(halOfWidth -200F , halOfHeight + 250F , halOfWidth  + 200F, halOfHeight + 350F)
               mCanvas.drawArc(lip,0F,-180F,false,mPaint)

               mPaint.color = ResourcesCompat.getColor(resources, R.color.white,null)
               val mouth = RectF(halOfWidth -180F ,halOfHeight +260F , halOfWidth +180F, halOfHeight +330F)
               mCanvas.drawArc(mouth,0F,-180F,false,mPaint)
           }
       }


   }

}