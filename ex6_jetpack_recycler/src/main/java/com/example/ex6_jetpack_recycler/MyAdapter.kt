package com.example.ex6_jetpack_recycler

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.ex6_jetpack_recycler.databinding.ActivityMainBinding
import com.example.ex6_jetpack_recycler.databinding.ActivityRecyclerViewBinding

//뷰 홀더
class MyViewHolder(val binding: ActivityRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root)

//어탭터
class MyAdapter(val datas: MutableList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var context: Context

    //항목의 뷰을 가지는 뷰 홀더를 준비
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return MyViewHolder(
            ActivityRecyclerViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    //뷰 홀더의 뷰에 데이터를 출력
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.itemData.text = datas[position]

        //리사이클러뷰 어댑터를 이용한 뷰페이저2구현
        when(position % 3){
            0 -> binding.itemData.setBackgroundColor(Color.RED)
            1 -> binding.itemData.setBackgroundColor(Color.BLUE)
            2 -> binding.itemData.setBackgroundColor(Color.GREEN)
        }
    }

    //항목의 갯수를 판단한다.
    override fun getItemCount(): Int {
        return datas.size
    }

    //완전 새로운 것을 추가한다. 근데 이름을 똑같이 적어주면
    fun addItem() {
        datas.add("새아이템${datas.size + 1}")
        notifyDataSetChanged()
    }

    // 삭제할 때.
    //삭제방법 1 이름이 똑같아야함
    fun removeItem() {
        Log.d("myLog", "아이템 삭제")
        datas.remove("아이템${datas.size}")
        datas.remove("새아이템${datas.size}")
        notifyDataSetChanged()
    }

    //삭제 2
    fun removeItem2() {
        if (datas.size != 0) {
            datas.removeAt(datas.size - 1)
            notifyDataSetChanged()
        } else {
            //항목이 없을 때 사용자에게 줄 수 도 있다.
            Toast.makeText(context, "항목이 없습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    //삭제 3
    fun removeItem3() {
        datas.removeLastOrNull()
        if (datas.size == 0) {
            Toast.makeText(context, "항목이 없습니다.", Toast.LENGTH_SHORT).show()
        }
        notifyDataSetChanged()
    }
}
class MyDecoration(val context: Context):RecyclerView.ItemDecoration(){
    //항목이 배치되기 전에 호출
    //0f화면 화면 왼쪽,상단에 붙는다? 배치
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        c.drawBitmap(
            BitmapFactory.decodeResource(context.resources,R.drawable.kbo),
            0f,
            0f,
            null
        )
    }
//모든 항목이 배치된 후 호출
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    //뷰 크기 계산
    val width = parent.width
    val height = parent.height
    //이미지 크기 계산
    val dr : Drawable? =
        ResourcesCompat.getDrawable(context.resources,R.drawable.kbo,null)
    val drWith = dr?.intrinsicWidth
    val drHeight = dr?.intrinsicHeight
    //이미지가 그려질 위치곅산
    val left = width/2 - drWith?.div(2)as Int
    val top = height/2 - drHeight?.div(2)as Int
    c.drawBitmap(
        BitmapFactory.decodeResource(context.resources,R.drawable.kbo),
        left.toFloat(),
        top.toFloat(),
        null

    )
    }
//개별항목 꾸미기
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
    val index = parent.getChildAdapterPosition(view)+1
    if (index % 3 == 0){
        outRect.set(10,10,10,60)
    }else{
        outRect.set(10,10,10,0)
    }
    view.setBackgroundColor(Color.LTGRAY)
    ViewCompat.setElevation(view,20.0f)
    }
}