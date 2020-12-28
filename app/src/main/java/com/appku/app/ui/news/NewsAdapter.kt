package com.appku.app.ui.news

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.appku.app.R
import com.appku.app.data.model.News
import com.appku.app.databinding.ItemNewsBinding
import com.appku.app.ui.base.BaseAdapter
import com.bumptech.glide.Glide

class NewsAdapter(val context: Context): BaseAdapter<News>(R.layout.item_news)  {
    override fun onBind(binding: ViewDataBinding?, data: News) {
        val mBinding = binding as ItemNewsBinding
        Glide.with(context).load(data.thumb).into(mBinding.itemThumb)
    }

    override fun onClick(binding: ViewDataBinding?, data: News) {
        val intent = Intent(context,NewsActivity::class.java)
        intent.putExtra(NewsActivity.OPEN_NEWS,data)
        context.startActivity(intent)
    }

}
