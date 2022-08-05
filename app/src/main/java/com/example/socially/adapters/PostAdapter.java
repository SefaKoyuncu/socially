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
import com.example.socially.classes.Post;
import com.example.socially.classes.Story;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.CardviewTasarimNesneleriniTutucu>
{
    private Context mContext;
    private List<Post> postList;

    public PostAdapter(Context mContext, List<Post> postList)
    {
        this.mContext = mContext;
        this.postList = postList;
    }

    @NonNull
    @Override
    public CardviewTasarimNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_card_design,parent,false);
        return new CardviewTasarimNesneleriniTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardviewTasarimNesneleriniTutucu holder, int position)
    {
        final Post post=postList.get(position);

        holder.imageViewPostImage.setImageResource(mContext.getResources().getIdentifier(post.getPostImage(),"drawable",mContext.getPackageName()));
        holder.imageViewPersonImage.setImageResource(mContext.getResources().getIdentifier(post.getPersonImage(),"drawable",mContext.getPackageName()));

        holder.textViewPersonName.setText(post.getPersonName());
        holder.textViewSharingTime.setText(post.getSharingTime());
        holder.textViewLikeCounts.setText("" + post.getLikesCounts() + "K" );
        holder.textViewCommentCounts.setText("" + post.getCommentCounts() + "K" );
        holder.textViewSaveCounts.setText(String.valueOf(post.getSaveCounts()) );
    }

    @Override
    public int getItemCount()
    {
        return postList.size();
    }

    public class CardviewTasarimNesneleriniTutucu extends RecyclerView.ViewHolder
    {
        public ImageView imageViewPostImage, imageViewPersonImage;
        public TextView textViewSaveCounts, textViewCommentCounts,
                textViewLikeCounts, textViewSharingTime, textViewPersonName;

        public CardviewTasarimNesneleriniTutucu(@NonNull View itemView)
        {
            super(itemView);

            imageViewPostImage=itemView.findViewById(R.id.imageViewPostImage);
            imageViewPersonImage=itemView.findViewById(R.id.imageViewPersonImage);
            textViewSaveCounts=itemView.findViewById(R.id.textViewSaveCounts);
            textViewCommentCounts=itemView.findViewById(R.id.textViewCommentCounts);
            textViewLikeCounts=itemView.findViewById(R.id.textViewLikeCounts);
            textViewSharingTime=itemView.findViewById(R.id.textViewSharingTime);
            textViewPersonName=itemView.findViewById(R.id.textViewPersonName);

        }
    }
}
