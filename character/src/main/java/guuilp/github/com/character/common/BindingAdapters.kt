package guuilp.github.com.character.common

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation

@BindingAdapter("loadImage")
fun ImageView.loadImage(oldUrl: String?, newUrl: String?) {
    if (oldUrl != newUrl) this.load(newUrl) {
        crossfade(true)
        transformations(CircleCropTransformation())
    }
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

@BindingAdapter("android:visibleOrGone")
fun View.changeVisibility(oldVisible: Boolean?, newVisible: Boolean?) {
    if (oldVisible != newVisible) {
        if (newVisible == true) this.visibility = View.VISIBLE
        else this.visibility = View.GONE
    }
}