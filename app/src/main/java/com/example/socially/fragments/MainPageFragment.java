package com.example.socially.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.socially.R;
import com.example.socially.adapters.PostAdapter;
import com.example.socially.classes.Post;
import com.example.socially.classes.Story;
import com.example.socially.adapters.StoryAdapter;
import com.example.socially.databinding.FragmentMainPageBinding;

import java.util.ArrayList;
import java.util.List;

public class MainPageFragment extends Fragment
{
    private FragmentMainPageBinding binding;
    private List<Story> storyList = new ArrayList<>();
    private StoryAdapter storyAdapter;
    private List<Post> postList = new ArrayList<>();
    private PostAdapter postAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_page,container, false);


        buildStoryRecyclerView();
        buildPostRecyclerView();


        return binding.getRoot();
    }

    private void buildPostRecyclerView()
    {
        postList.clear();

        postList.add(new Post(String.valueOf(R.drawable.main_profil1), "Dennis Reynolds", "2 hrs ago", String.valueOf(R.drawable.main_postimage1), 5.2, 362,1.1));
        postList.add(new Post(String.valueOf(R.drawable.main_profil2), "Charlie Kelly",   "4 hrs ago", String.valueOf(R.drawable.main_postimage2), 6.1, 656,3.2));

        binding.rvPost.setHasFixedSize(true);
        binding.rvPost.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        postAdapter = null;
        postAdapter = new PostAdapter(getContext(), postList);
        binding.rvPost.setAdapter(postAdapter);
        postAdapter.notifyDataSetChanged();
    }

    private void buildStoryRecyclerView()
    {
        storyList.clear();

        storyList.add(new Story(String.valueOf(R.drawable.story_add)));
        storyList.add(new Story(String.valueOf(R.drawable.story_1)));
        storyList.add(new Story(String.valueOf(R.drawable.story_2)));
        storyList.add(new Story(String.valueOf(R.drawable.story_3)));
        storyList.add(new Story(String.valueOf(R.drawable.story_4)));

        binding.rvStory.setHasFixedSize(true);
        binding.rvStory.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        storyAdapter = null;
        storyAdapter = new StoryAdapter(getContext(), storyList);
        binding.rvStory.setAdapter(storyAdapter);
        storyAdapter.notifyDataSetChanged();
    }
}