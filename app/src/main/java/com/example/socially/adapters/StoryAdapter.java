package com.example.socially.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socially.R;
import com.example.socially.classes.Story;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.CardviewTasarimNesneleriniTutucu>
{
    private Context mContext;
    private List<Story> storyList;

    public StoryAdapter(Context mContext, List<Story> storyList)
    {
        this.mContext = mContext;
        this.storyList = storyList;
    }

    @NonNull
    @Override
    public CardviewTasarimNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.story_card_design,parent,false);
        return new CardviewTasarimNesneleriniTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardviewTasarimNesneleriniTutucu holder, int position)
    {
        final Story story=storyList.get(position);

        holder.imageViewStory.setImageResource(mContext.getResources().getIdentifier(storyList.get(position).getImage_name(),"drawable",mContext.getPackageName()));

    }

    @Override
    public int getItemCount()
    {
        return storyList.size();
    }

    public class CardviewTasarimNesneleriniTutucu extends RecyclerView.ViewHolder
    {
        public ImageView imageViewStory;

        public CardviewTasarimNesneleriniTutucu(@NonNull View itemView)
        {
            super(itemView);
            imageViewStory=itemView.findViewById(R.id.imageViewStory);

        }
    }
}
