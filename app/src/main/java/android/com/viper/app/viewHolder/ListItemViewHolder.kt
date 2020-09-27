package android.com.viper.app.viewHolder

import android.com.viper.model.response.GitHubSearchResultItem
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.list_item_search_github.view.*

class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  fun bindView(item: GitHubSearchResultItem, itemClickListener: (GitHubSearchResultItem) -> Unit) {
    val context = itemView.context
    Glide.with(context)
      .load(item.owner.avatar_url)
      .diskCacheStrategy(DiskCacheStrategy.DATA)
      .into(itemView.repoOwnerAvatar)
    itemView.repoName.text = item.full_name
    itemView.repoDescription.text = item.getRepoDescription()
    itemView.repoUrl.text = item.html_url

    itemView.setOnClickListener {
      itemClickListener(item)
    }
  }

  fun cancelImageLoading() {
    Glide.with(itemView.context).clear(itemView)
  }
}