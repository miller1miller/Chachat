package com.gmiller.chachat

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gmiller.chachat.databinding.ActivitySignInBinding
import com.gmiller.chachat.databinding.UserListItemBinding

class UserAdapter : ListAdapter<User, UserAdapter.ItemHolder>(ItemComparator()) {

    class ItemHolder(private val binding: UserListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User) = with(binding){
            username.text = user.name
            message.text = user.message
        }
        companion object{
            fun create(parent: ViewGroup): ItemHolder{
                return ItemHolder(UserListItemBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }
    }

    class ItemComparator : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }
}