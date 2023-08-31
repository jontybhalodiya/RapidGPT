package com.example.cognisphereai;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder>{
    List<Message> messageList;
    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull




    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chatView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,null);
        MyViewHolder myViewHolder = new MyViewHolder(chatView);
        return myViewHolder;
    }

    //used to assign text to the view either green or blue layout and hide the other one
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Message message = messageList.get(position);
        if(message.getSentBy().equals(Message.SENT_BY_ME)){
            holder.LeftChatView.setVisibility(View.GONE);
            holder.RightChatView.setVisibility(View.VISIBLE);
            holder.RightTextView.setText(message.getMessage());
        }else {
            holder.LeftChatView.setVisibility(View.VISIBLE);
            holder.RightChatView.setVisibility(View.GONE);
            holder.LeftTextView.setText(message.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        LinearLayout LeftChatView, RightChatView;
        TextView LeftTextView, RightTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            LeftChatView = itemView.findViewById(R.id.left_chat_view);
            RightChatView = itemView.findViewById(R.id.right_chat_view);
            LeftTextView = itemView.findViewById(R.id.left_textview);
            RightTextView = itemView.findViewById(R.id.right_textview);
        }
    }
}
