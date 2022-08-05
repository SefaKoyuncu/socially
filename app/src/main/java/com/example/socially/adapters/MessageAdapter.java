package com.example.socially.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socially.R;
import com.example.socially.classes.Messages;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.CardviewTasarimNesneleriniTutucu>
{
    private Context mContext;
    private List<Messages> messageList;

    public MessageAdapter(Context mContext, List<Messages> messageList)
    {
        this.mContext = mContext;
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public CardviewTasarimNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_card_design,parent,false);
        return new CardviewTasarimNesneleriniTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardviewTasarimNesneleriniTutucu holder, int position)
    {
        final Messages message=messageList.get(position);

        holder.imageViewpersonImage.setImageResource(mContext.getResources().getIdentifier(message.getPersonImage(),"drawable",mContext.getPackageName()));

        holder.textViewpersonName.setText(message.getPersonName());
        holder.textViewMessage.setText(message.getMessage());
    }

    public void filterList(ArrayList<Messages> filterlist)
    {
        messageList = filterlist;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount()
    {
        return messageList.size();
    }

    public class CardviewTasarimNesneleriniTutucu extends RecyclerView.ViewHolder
    {
        public ImageView imageViewpersonImage;
        public TextView textViewpersonName, textViewMessage;

        public CardviewTasarimNesneleriniTutucu(@NonNull View itemView)
        {
            super(itemView);

            imageViewpersonImage=itemView.findViewById(R.id.imageViewpersonImage);
            textViewpersonName=itemView.findViewById(R.id.textViewpersonName);
            textViewMessage=itemView.findViewById(R.id.textViewMessage);
        }
    }
}
