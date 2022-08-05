package com.example.socially.fragments;

import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.socially.R;
import com.example.socially.adapters.MessageAdapter;
import com.example.socially.classes.Messages;
import com.example.socially.databinding.FragmentChatPageBinding;
import java.util.ArrayList;
import java.util.List;

public class ChatPageFragment extends Fragment {

    private FragmentChatPageBinding binding;
    private List<Messages> messageList = new ArrayList<>();
    private MessageAdapter messageAdapter;
    private ArrayList<Messages> filteredlist = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat_page,container, false);

        binding.imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHold,new MainPageFragment()).commit();
            }
        });

        buildChatRecyclerView();

        binding.editTextFiltering.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(String.valueOf(editable));
            }
        });


        return binding.getRoot();
    }

    private void buildChatRecyclerView()
    {
        messageList.clear();

        messageList.add(new Messages(String.valueOf(R.drawable.message_image1), "Malena Tudi", "Hey, how's it goin?"));
        messageList.add(new Messages(String.valueOf(R.drawable.message_image2), "Jakob Curtis", "Yo, are you going to the Jake’s wedding?"));
        messageList.add(new Messages(String.valueOf(R.drawable.message_image3), "Abram Levin", "Amir said we’d be staying over for a while... but ..."));
        messageList.add(new Messages(String.valueOf(R.drawable.message_image4), "Marilyn Herwitz", "hey, i got new memes for you"));
        messageList.add(new Messages(String.valueOf(R.drawable.message_image5), "Desirae Saris", "GoT really took a nose dive huh"));

        binding.rv.setHasFixedSize(true);
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        messageAdapter = null;
        messageAdapter = new MessageAdapter(getContext(), messageList);
        binding.rv.setAdapter(messageAdapter);
        messageAdapter.notifyDataSetChanged();
    }

    public void filter(String text)
    {
        filteredlist.clear();

        for (Messages item : messageList)
        {
            if (item.getPersonName().toLowerCase().contains(text.toLowerCase()) || item.getMessage().toLowerCase().contains(text.toLowerCase()))
            {
                filteredlist.add(item);
            }
        }

        messageAdapter.filterList(filteredlist);
    }
}