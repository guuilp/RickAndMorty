package guuilp.github.com.character.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load

@BindingAdapter("loadImage")
fun ImageView.loadImage(oldUrl: String?, newUrl: String?) {
    if(oldUrl != newUrl) this.load(newUrl)
}

@BindingAdapter("items")
fun <T> RecyclerView.setItems(
    previousItems: List<T>?,
    newItems: List<T>?
) {
    if (previousItems != newItems) {
        val adapter = this.adapter as ListAdapter<T, RecyclerView.ViewHolder>
        adapter.submitList(newItems)
    }
}
