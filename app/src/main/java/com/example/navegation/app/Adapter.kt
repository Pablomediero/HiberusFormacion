package com.example.navegation.app

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.navegation.databinding.ItemUserBinding
import com.example.navegation.model.user.User

class Adapter: ListAdapter<User, Adapter.UserViewHolder>(
    object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

    }

){

    interface UserListener{
        fun onItemClick(user: User)

    }

    private var userListener: UserListener? = null

    fun setUserListener(userListener: UserListener){
        this.userListener = userListener
    }

    inner class UserViewHolder(itemBinding: ItemUserBinding): ViewHolder(itemBinding.root){
        val userName: TextView = itemBinding.tvUserName

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemBinding = ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = getItem(position)
        holder.userName.text = item.name


        holder.itemView.setOnClickListener{
            userListener?.onItemClick(item)

        }
    }
}