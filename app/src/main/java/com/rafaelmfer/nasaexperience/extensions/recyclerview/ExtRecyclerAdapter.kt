package com.rafaelmfer.nasaexperience.extensions.recyclerview

import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

val RecyclerView.recyclerAdapter get() = adapter as RecyclerAdapter?
fun RecyclerView.update() = recyclerAdapter?.notifyDataSetChanged()

abstract class RecyclerAdapter<Type : RecyclerView.ViewHolder>(var collection: Collection<*>) :
    RecyclerView.Adapter<Type>() {

    abstract var onTarget: () -> Unit

    abstract fun getTarget(): Int
}

inline fun <reified Builder : ItemViewBuilder<*>> RecyclerView.setup(list: Collection<*>) =
    recyclerAdapter<Builder>(list).apply { adapter = this }

inline fun <reified Builder : ItemViewBuilder<*>> recyclerAdapter(collection: Collection<*>) =
    object : RecyclerAdapter<RecyclerViewHolder>(collection) {

        override var onTarget: () -> Unit = {}

        override fun getTarget() = collection.size - 10

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
            RecyclerViewHolder(Builder::class.java.newInstance().init(viewGroup, collection))

        override fun getItemCount() = collection.size

        override fun onBindViewHolder(viewHolder: RecyclerViewHolder, position: Int) {
            if (position == getTarget()) {
                onTarget()
            }
            viewHolder.builder.onBind(position)
        }
    }

open class RecyclerViewHolder(val builder: ItemViewBuilder<*>) : RecyclerView.ViewHolder(builder.build())

abstract class ItemViewBuilder<Data> {
    abstract val layout: Int
    lateinit var viewGroup: ViewGroup
    lateinit var view: View
    lateinit var collection: Collection<Data>

    @Suppress("UNCHECKED_CAST")
    fun init(viewGroup: ViewGroup, collection: Collection<*>): ItemViewBuilder<Data> {
        this.viewGroup = viewGroup
        this.collection = collection as Collection<Data>
        return this
    }

    fun build(): View {
        view = from(viewGroup.context).inflate(layout, viewGroup, false)
        return view
    }

    fun onBind(position: Int) = view.onBind(position)

    abstract fun View.onBind(position: Int)
}